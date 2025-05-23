package com.tencent.mobileqq.reminder.util;

import Wallet.AcsMsg;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAbstractElementData;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactData;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002J$\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0015R\u0016\u0010\u001d\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/reminder/util/QQNotifyNTUtil;", "", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/reminder/db/entity/b;", "msg", "Lcom/tencent/mobileqq/reminder/api/IQQReminderRecordFacadeApi;", "msgFacade", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactData;", "f", "", "content", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAbstractElementData;", "Lkotlin/collections/ArrayList;", "d", "Lcom/tencent/mobileqq/reminder/api/IQQReminderDataService;", "reminderDataManager", "Lkotlin/Triple;", "", "e", "", "g", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", tl.h.F, "b", "J", "mCurrentUin", "Lcom/tencent/qqnt/msg/i;", "c", "Lcom/tencent/qqnt/msg/i;", "mMsgListener", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QQNotifyNTUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQNotifyNTUtil f281102a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long mCurrentUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.qqnt.msg.i mMsgListener;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30740);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f281102a = new QQNotifyNTUtil();
        }
    }

    QQNotifyNTUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ArrayList<MsgAbstractElementData> d(String content) {
        MsgAbstractElementData msgAbstractElementData = new MsgAbstractElementData(1, content, "", 0, 0);
        ArrayList<MsgAbstractElementData> arrayList = new ArrayList<>();
        arrayList.add(msgAbstractElementData);
        return arrayList;
    }

    private final Triple<Long, String, Long> e(IQQReminderDataService reminderDataManager) {
        Triple<Long, String, Long> triple;
        long serverTime = NetConnInfoCenter.getServerTime();
        Iterator<String> it = reminderDataManager.getCacheKeyList().iterator();
        String str = "";
        long j3 = 0;
        String str2 = "";
        while (it.hasNext()) {
            com.tencent.mobileqq.reminder.biz.entity.a entityByKey = reminderDataManager.getEntityByKey(it.next());
            Intrinsics.checkNotNullExpressionValue(entityByKey, "reminderDataManager.getEntityByKey(key)");
            AcsMsg acsMsg = entityByKey.getAcsMsg();
            long j16 = acsMsg.notice_time;
            if (j16 <= serverTime && j16 > j3) {
                str = acsMsg.title;
                Intrinsics.checkNotNullExpressionValue(str, "acsMsg.title");
                str2 = acsMsg.msg_id;
                Intrinsics.checkNotNullExpressionValue(str2, "acsMsg.msg_id");
                j3 = j16;
            }
        }
        if (j3 > 0 && !TextUtils.isEmpty(str)) {
            triple = new Triple<>(Long.valueOf(j3), str, Long.valueOf(str2.hashCode()));
        } else {
            triple = null;
        }
        if (triple == null) {
            QLog.e("QQNotifyNTUtil", 1, "getLastMessage msg not found!!!!");
        } else {
            QLog.d("QQNotifyNTUtil", 1, "getLastMessage id: " + str2);
        }
        return triple;
    }

    private final RecentContactData f(final AppRuntime app, final com.tencent.mobileqq.reminder.db.entity.b msg2, IQQReminderRecordFacadeApi msgFacade) {
        String str;
        String str2;
        long j3;
        String str3;
        long j16;
        boolean z16;
        if (app.getApplicationContext() == null) {
            str = "";
        } else {
            str = app.getApplicationContext().getString(R.string.f170010ct);
            Intrinsics.checkNotNullExpressionValue(str, "app.applicationContext.g\u2026ng.activate_friend_title)");
        }
        long uniseq = msg2.getUniseq();
        int unreadCount = msgFacade.getUnreadCount(msg2.getFrienduin(), Integer.valueOf(msg2.getIstroop()), new Function0<Integer>(msg2) { // from class: com.tencent.mobileqq.reminder.util.QQNotifyNTUtil$getRecentContactData$unreadNum$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.reminder.db.entity.b $msg;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$msg = msg2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppRuntime.this, (Object) msg2);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                IRuntimeService runtimeService = AppRuntime.this.getRuntimeService(IConversationFacade.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IC\u2026nstant.MAIN\n            )");
                return Integer.valueOf(((IConversationFacade) runtimeService).getUnreadCount(this.$msg.getFrienduin(), this.$msg.getIstroop()));
            }
        });
        if (msg2.getMsg() == null) {
            str2 = "";
        } else {
            str2 = String.valueOf(msg2.getMsg());
        }
        long time = msg2.getTime();
        if (TextUtils.isEmpty(str2)) {
            IRuntimeService runtimeService = app.getRuntimeService(IQQReminderDataService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IQ\u2026va, ProcessConstant.MAIN)");
            Triple<Long, String, Long> e16 = e((IQQReminderDataService) runtimeService);
            if (e16 == null) {
                return null;
            }
            String second = e16.getSecond();
            long longValue = e16.getFirst().longValue();
            long longValue2 = e16.getThird().longValue();
            j16 = longValue;
            str3 = second;
            j3 = longValue2;
        } else {
            j3 = uniseq;
            str3 = str2;
            j16 = time;
        }
        RecentContactData recentContactData = new RecentContactData(AppConstants.ACTIVATE_FRIENDS_UIN, 9002L, str, 132, unreadCount, "", String.valueOf(R.drawable.qq_af_icon), 2, d(str3), j16, null, null, new ArrayList());
        if (unreadCount > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        recentContactData.forceInsert = z16;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("need notify msg", true)) {
            QLog.d("QQNotifyNTUtil", 2, "getRecentContactData:" + recentContactData + " uniSeq: " + j3);
        }
        QLog.d("QQNotifyNTUtil", 2, "peerName: " + str + " unread " + unreadCount + " uniSeq: " + j3);
        return recentContactData;
    }

    private final void g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        long longAccountUin = peekAppRuntime.getLongAccountUin();
        if (mCurrentUin == longAccountUin) {
            return;
        }
        QLog.d("QQNotifyNTUtil", 1, "registerMsgListener");
        mCurrentUin = longAccountUin;
        w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getMsgService();
        com.tencent.qqnt.msg.i iVar = mMsgListener;
        if (iVar != null && msgService != null) {
            Intrinsics.checkNotNull(iVar);
            msgService.removeMsgListener(iVar);
        }
        k kVar = new k();
        mMsgListener = kVar;
        if (msgService != null) {
            Intrinsics.checkNotNull(kVar);
            msgService.addMsgListener(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(aa aaVar, int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList != null && arrayList.size() >= 1) {
            aaVar.deleteRecentContacts(arrayList, null);
            f281102a.l();
            QLog.e("QQNotifyNTUtil", 1, "removeNotifyRecentContactData succeed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.d("QQNotifyNTUtil", 1, "setMsgRead result: " + i3 + " , errMsg: " + errMsg);
    }

    private final void l() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        mCurrentUin = 0L;
        w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getMsgService();
        com.tencent.qqnt.msg.i iVar = mMsgListener;
        if (iVar != null && msgService != null) {
            Intrinsics.checkNotNull(iVar);
            msgService.removeMsgListener(iVar);
        }
        mMsgListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(int i3, String str) {
        QLog.i("QQNotifyNTUtil", 1, "onResult:" + i3 + " ,errMsg:" + str);
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        final aa recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.e("QQNotifyNTUtil", 1, "removeNotifyRecentContactData service is null");
        } else {
            recentContactService.F0(new Contact(132, AppConstants.ACTIVATE_FRIENDS_UIN, ""), new IGetContactsCallback() { // from class: com.tencent.mobileqq.reminder.util.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
                public final void onResult(int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
                    QQNotifyNTUtil.i(aa.this, i3, str, arrayList, arrayList2);
                }
            });
        }
    }

    public final void j(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) app);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        w msgService = ((IKernelService) app.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.e("QQNotifyNTUtil", 1, "clearUnreadNum service is null");
        } else {
            msgService.setMsgRead(new Contact(132, AppConstants.ACTIVATE_FRIENDS_UIN, ""), new IOperateCallback() { // from class: com.tencent.mobileqq.reminder.util.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    QQNotifyNTUtil.k(i3, str);
                }
            });
        }
    }

    public final void m(@NotNull AppRuntime app) {
        com.tencent.mobileqq.reminder.db.entity.b bVar;
        QQNotifyNTUtil qQNotifyNTUtil;
        RecentContactData f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) app);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        IQQReminderRecordFacadeApi a16 = com.tencent.mobileqq.reminder.db.d.a(app);
        if (a16 != null) {
            if (a16.getMsgList(AppConstants.ACTIVATE_FRIENDS_UIN, 9002).size() > 0) {
                bVar = a16.getLastMessage(QQConstants.ACTIVATE_FRIENDS_UIN, 9002);
            } else {
                bVar = null;
            }
            if (bVar != null && (f16 = (qQNotifyNTUtil = f281102a).f(app, bVar, a16)) != null) {
                aa recentContactService = ((IKernelService) app.getRuntimeService(IKernelService.class, "")).getRecentContactService();
                if (recentContactService != null) {
                    qQNotifyNTUtil.g();
                    recentContactService.upsertRecentContactManually(f16, new IOperateCallback() { // from class: com.tencent.mobileqq.reminder.util.j
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str) {
                            QQNotifyNTUtil.n(i3, str);
                        }
                    });
                    QLog.e("QQNotifyNTUtil", 1, "updateMessageList succeed");
                    return;
                }
                QLog.e("QQNotifyNTUtil", 1, "updateMessageList service is null");
            }
        }
    }
}
