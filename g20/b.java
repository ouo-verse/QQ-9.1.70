package g20;

import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
import com.tencent.biz.qqcircle.fragments.chat.QCircleRecentContactInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qcircle.api.data.IQCircleMessageFacadeListener;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import qqcircle.QQCircleCounter$PrivateMessage;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static volatile b f401112c;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<IQCircleMessageFacadeListener> f401113a;

    /* renamed from: b, reason: collision with root package name */
    private final Function1<RecentContactListChangedInfo, Unit> f401114b = new a();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements Function1<RecentContactListChangedInfo, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(RecentContactListChangedInfo recentContactListChangedInfo) {
            b.this.f(recentContactListChangedInfo);
            b.this.e(recentContactListChangedInfo);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: g20.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C10348b implements IOperateCallback {
        C10348b() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            QLog.d("QCircleChatNtMsgHelper", 1, "[fetchRecentContactInfo] result = " + i3 + ", errMsg = " + str);
        }
    }

    b() {
    }

    public static b d() {
        if (f401112c == null) {
            synchronized (QCircleChatBoxHelper.class) {
                if (f401112c == null) {
                    f401112c = new b();
                }
            }
        }
        return f401112c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(RecentContactListChangedInfo recentContactListChangedInfo) {
        IQCircleMessageFacadeListener iQCircleMessageFacadeListener;
        ArrayList<RecentContactInfo> changedList;
        WeakReference<IQCircleMessageFacadeListener> weakReference = this.f401113a;
        ArrayList<Long> arrayList = null;
        if (weakReference == null) {
            iQCircleMessageFacadeListener = null;
        } else {
            iQCircleMessageFacadeListener = weakReference.get();
        }
        if (iQCircleMessageFacadeListener == null) {
            return;
        }
        if (recentContactListChangedInfo == null) {
            changedList = null;
        } else {
            changedList = recentContactListChangedInfo.getChangedList();
        }
        if (recentContactListChangedInfo != null) {
            arrayList = recentContactListChangedInfo.getSortedContactList();
        }
        if (changedList != null && changedList.size() > 0 && arrayList != null) {
            QLog.d("QCircleChatNtMsgHelper", 1, "[parseChangedInfoForMessageList] size = " + changedList.size());
            ArrayList arrayList2 = new ArrayList();
            Iterator<RecentContactInfo> it = changedList.iterator();
            while (it.hasNext()) {
                RecentContactInfo next = it.next();
                if (next != null && next.getChatType() == 113 && arrayList.contains(Long.valueOf(next.getContactId()))) {
                    arrayList2.add(new QCircleRecentContactInfo(next));
                }
            }
            if (arrayList2.size() > 0) {
                iQCircleMessageFacadeListener.tryRefreshData(arrayList2);
                return;
            }
            return;
        }
        QLog.e("QCircleChatNtMsgHelper", 1, "[parseChangedInfoForMessageList] list error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(RecentContactListChangedInfo recentContactListChangedInfo) {
        ArrayList<RecentContactInfo> changedList;
        ArrayList<Long> arrayList = null;
        if (recentContactListChangedInfo == null) {
            changedList = null;
        } else {
            changedList = recentContactListChangedInfo.getChangedList();
        }
        if (recentContactListChangedInfo != null) {
            arrayList = recentContactListChangedInfo.getSortedContactList();
        }
        if (changedList != null && changedList.size() > 0 && arrayList != null) {
            long currentAccountLongUin = QCircleCommonUtil.getCurrentAccountLongUin();
            Iterator<RecentContactInfo> it = changedList.iterator();
            while (it.hasNext()) {
                RecentContactInfo next = it.next();
                if (next != null && next.getChatType() == 113 && next.getUnreadCnt() > 0 && arrayList.contains(Long.valueOf(next.getContactId())) && currentAccountLongUin != next.getSenderUin()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QCircleChatNtMsgHelper", 2, "[mRecentContactListener] uin = " + next.getPeerUin() + ", timestamp = " + next.getMsgTime() + ", unreadCnt = " + next.getUnreadCnt());
                    }
                    QQCircleCounter$PrivateMessage qQCircleCounter$PrivateMessage = new QQCircleCounter$PrivateMessage();
                    qQCircleCounter$PrivateMessage.uID.set(String.valueOf(next.getSenderUin()));
                    qQCircleCounter$PrivateMessage.timestamp.set((int) next.getMsgTime());
                    QCircleChatBoxHelper.getInstance().insertUnReadMessage(qQCircleCounter$PrivateMessage);
                    if (QCircleHandler.getQCircleHandler() != null) {
                        QCircleHandler.getQCircleHandler().updateRedPoint();
                    }
                }
            }
            return;
        }
        QLog.e("QCircleChatNtMsgHelper", 1, "[parseChangedInfoForRedDot] list error");
    }

    public void c() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface == null) {
            QLog.d("QCircleChatNtMsgHelper", 1, "[addRecentContactListener] appInterface == null");
            return;
        }
        aa recentContactService = ((IKernelService) appInterface.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.d("QCircleChatNtMsgHelper", 1, "[addRecentContactListener] recentContactService == null");
            return;
        }
        recentContactService.g0(12, this.f401114b);
        recentContactService.v(new AnchorPointContactInfo(), true, 12, 200, new C10348b());
        QLog.d("QCircleChatNtMsgHelper", 1, "[addRecentContactListener]");
    }

    public void g() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface == null) {
            QLog.e("QCircleChatNtMsgHelper", 1, "[removeRecentContactListener] appInterface == null");
            return;
        }
        aa recentContactService = ((IKernelService) appInterface.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.e("QCircleChatNtMsgHelper", 1, "[removeRecentContactListener] recentContactService == null");
        } else {
            recentContactService.m(12, this.f401114b);
            QLog.d("QCircleChatNtMsgHelper", 1, "[addRecentContactListener]");
        }
    }

    public void h(IQCircleMessageFacadeListener iQCircleMessageFacadeListener) {
        if (iQCircleMessageFacadeListener == null) {
            QLog.d("QCircleChatNtMsgHelper", 1, "[addQCircleMessageFacadeListener]");
            this.f401113a = null;
        } else {
            QLog.d("QCircleChatNtMsgHelper", 1, "[removeQCircleMessageFacadeListener]");
            this.f401113a = new WeakReference<>(iQCircleMessageFacadeListener);
            c();
        }
    }
}
