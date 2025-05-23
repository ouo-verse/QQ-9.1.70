package com.tencent.mobileqq.newfriend.api.impl;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.msg.f;
import com.tencent.mobileqq.newfriend.msg.g;
import com.tencent.mobileqq.newfriend.msg.h;
import com.tencent.mobileqq.newfriend.msg.i;
import com.tencent.mobileqq.newfriend.msg.j;
import com.tencent.mobileqq.newfriend.msg.l;
import com.tencent.mobileqq.newfriend.msg.m;
import com.tencent.mobileqq.newfriend.msg.n;
import com.tencent.mobileqq.newfriend.msg.q;
import com.tencent.mobileqq.newfriend.msg.r;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.ContactBinded;
import com.tencent.mobileqq.phonecontact.data.ContactMatch;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.mobileim.structmsg.structmsg$SystemMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NewFriendServiceImpl extends Observable implements INewFriendService, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_LOADDATA = 1;
    private static final int MSG_MARKREADED = 3;
    private static final int MSG_MARKRECOMMEND_READED = 8;
    private static final int MSG_MARKSYSMSG_READED = 5;
    private static final int MSG_REFRESHDATA = 2;
    public static final int NEW_FRIEND_ICON_ID;
    public static final String NEW_FRIEND_TAG;
    public static final String TAG = "NEW_FRD.NewFriendServiceImpl";

    /* renamed from: em, reason: collision with root package name */
    private EntityManager f253969em;
    private com.tencent.mobileqq.newfriend.observer.a flo;
    private volatile boolean hasInitNewFriendList;
    AppInterface mApp;
    public com.tencent.mobileqq.newfriend.config.a mBean;
    private Comparator<i> mComparator;
    private IFriendsInfoService mFriendsInfoService;
    private Handler mHandler;
    public boolean mHasReadContactPermission;
    private boolean mIsGuideBindReported;
    private boolean mIsGuidePermissionReported;
    private int mLastSysMsgTotalCount;
    private LinkedList<nb2.a> mListenerList;
    ArrayList<i> mMixedMessages;
    private HashSet<String> mNewFriends;
    private od2.a mPCListener;
    private IPhoneContactService mPhoneContactService;
    com.tencent.mobileqq.newfriend.observer.c mPokeObserver;
    private int mRecommendShowCount;
    private int mRecommendSubTitleIndex;
    private ConcurrentHashMap<Long, SysSuspiciousMsg> mSuspiciousMsgMap;
    private boolean mSysMsgShouldAddMoreInfo;
    private int mSysMsgShowCount;
    private volatile boolean mSysSuspiciousForceLoadDb;
    private Comparator<SysSuspiciousMsg> mSysSuspiciousMsgComparator;
    private volatile int mSysSuspiciousUnreadNum;
    private boolean mUnReadListSwitch;
    private Comparator<Object> newFriendMsgHeadComparator;
    private boolean showContactGuide;
    public boolean showContactGuideV2;
    ArrayList<com.tencent.mobileqq.newfriend.msg.c> unReadNewFriendSystemMsg;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Comparator<i> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendServiceImpl.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVar, (Object) iVar2)).intValue();
            }
            if (!iVar.b() && iVar2.b()) {
                return -1;
            }
            if (iVar.b() && !iVar2.b()) {
                return 1;
            }
            return (int) (iVar2.f254036b - iVar.f254036b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements Comparator<SysSuspiciousMsg> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendServiceImpl.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SysSuspiciousMsg sysSuspiciousMsg, SysSuspiciousMsg sysSuspiciousMsg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) sysSuspiciousMsg, (Object) sysSuspiciousMsg2)).intValue();
            }
            if (sysSuspiciousMsg != null && sysSuspiciousMsg2 != null) {
                return (int) (sysSuspiciousMsg2.time - sysSuspiciousMsg.time);
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c extends com.tencent.mobileqq.newfriend.observer.c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.c
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else if (z16 && NewFriendServiceImpl.this.mHandler != null) {
                NewFriendServiceImpl.this.mHandler.sendEmptyMessage(2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements od2.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendServiceImpl.this);
            }
        }

        @Override // od2.a
        public void B7(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
        }

        @Override // od2.a
        public void L1(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(NewFriendServiceImpl.TAG, 2, "onUpdateContactList = " + i3);
            }
            if ((i3 & 1) != 0) {
                synchronized (NewFriendServiceImpl.this.mListenerList) {
                    Iterator it = NewFriendServiceImpl.this.mListenerList.iterator();
                    while (it.hasNext()) {
                        ((nb2.a) it.next()).onContactCountChanged();
                    }
                }
            }
        }

        @Override // od2.a
        public void T2(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }

        @Override // od2.a
        public void Ug(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(NewFriendServiceImpl.TAG, 2, "onBindStateChanged = " + i3);
            }
            NewFriendServiceImpl.this.getUnreadMessageCountAsync();
        }

        @Override // od2.a
        public void e7(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(NewFriendServiceImpl.TAG, 2, "onRecommendCountChanged = " + i3);
            }
            NewFriendServiceImpl.this.getUnreadMessageCountAsync();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e implements Comparator<Object> {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendServiceImpl.this);
            }
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, obj, obj2)).intValue();
            }
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            boolean z16 = obj instanceof i;
            if (z16 && (obj2 instanceof i)) {
                return (int) (((i) obj2).f254036b - ((i) obj).f254036b);
            }
            if (z16 && (obj2 instanceof PhoneContact)) {
                return (int) (((PhoneContact) obj2).lastScanTime - (((i) obj).f254036b * 1000));
            }
            boolean z17 = obj instanceof PhoneContact;
            if (z17 && (obj2 instanceof PhoneContact)) {
                return (int) (((PhoneContact) obj2).lastScanTime - ((PhoneContact) obj).lastScanTime);
            }
            if (z17 && (obj2 instanceof i)) {
                return (int) ((((i) obj2).f254036b * 1000) - ((PhoneContact) obj).lastScanTime);
            }
            if (z17 || z16) {
                return -1;
            }
            if ((obj2 instanceof PhoneContact) || (obj2 instanceof i)) {
                return 1;
            }
            return obj.hashCode() - obj2.hashCode();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27440);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 60)) {
            redirector.redirect((short) 60);
        } else {
            NEW_FRIEND_TAG = HardCodeUtil.qqStr(R.string.oon);
            NEW_FRIEND_ICON_ID = R.drawable.cqe;
        }
    }

    public NewFriendServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.showContactGuide = false;
        this.mBean = null;
        this.mHasReadContactPermission = false;
        this.showContactGuideV2 = false;
        this.mRecommendSubTitleIndex = -1;
        this.mIsGuidePermissionReported = false;
        this.mIsGuideBindReported = false;
        this.mMixedMessages = new ArrayList<>();
        this.mUnReadListSwitch = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105880", false);
        this.mListenerList = new LinkedList<>();
        this.mComparator = new a();
        this.mSysSuspiciousUnreadNum = 0;
        this.mSysSuspiciousForceLoadDb = true;
        this.mSuspiciousMsgMap = new ConcurrentHashMap<>(50);
        this.mSysSuspiciousMsgComparator = new b();
        this.mPokeObserver = new c();
        this.flo = new com.tencent.mobileqq.newfriend.observer.a() { // from class: com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NewFriendServiceImpl.this);
                }
            }

            @Override // com.tencent.mobileqq.newfriend.observer.a
            protected void b(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this, (Object) str);
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ArrayList<i> mixedNewFriendDatas = NewFriendServiceImpl.this.getMixedNewFriendDatas();
                if (!mixedNewFriendDatas.isEmpty()) {
                    Iterator<i> it = mixedNewFriendDatas.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        i next = it.next();
                        if (next instanceof com.tencent.mobileqq.newfriend.msg.c) {
                            com.tencent.mobileqq.newfriend.msg.c cVar = (com.tencent.mobileqq.newfriend.msg.c) next;
                            int i3 = cVar.f254022d.structMsg.f436065msg.sub_type.get();
                            String str2 = cVar.f254022d.senderuin;
                            if (i3 == 13 && str.equals(str2)) {
                                it.remove();
                                ((IMessageFacade) NewFriendServiceImpl.this.mApp.getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, cVar.f254022d.uniseq, false);
                                break;
                            }
                        }
                    }
                    NewFriendServiceImpl.this.mHandler.sendEmptyMessage(2);
                }
            }

            @Override // com.tencent.mobileqq.newfriend.observer.a
            protected void d(boolean z16, String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Boolean.valueOf(z16), str);
                } else if (z16 && NewFriendServiceImpl.this.mHandler != null) {
                    NewFriendServiceImpl.this.mHandler.sendEmptyMessage(2);
                }
            }

            @Override // com.tencent.mobileqq.newfriend.observer.a
            protected void g(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                } else if (z16 && NewFriendServiceImpl.this.mHandler != null) {
                    NewFriendServiceImpl.this.mHandler.sendEmptyMessage(2);
                }
            }

            @Override // com.tencent.mobileqq.newfriend.observer.a
            protected void h(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, z16);
                } else {
                    NewFriendServiceImpl.this.mApp.runOnUiThread(new Runnable(z16) { // from class: com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.4.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f253971d;

                        {
                            this.f253971d = z16;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass4.this, Boolean.valueOf(z16));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (this.f253971d) {
                                synchronized (NewFriendServiceImpl.this.mListenerList) {
                                    Iterator it = NewFriendServiceImpl.this.mListenerList.iterator();
                                    while (it.hasNext()) {
                                        ((nb2.a) it.next()).onMayKnowStatesChanged();
                                    }
                                }
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.newfriend.observer.a
            protected void k(boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, this, Boolean.valueOf(z16), obj);
                } else if (z16 && NewFriendServiceImpl.this.mHandler != null) {
                    NewFriendServiceImpl.this.mHandler.sendEmptyMessage(2);
                }
            }
        };
        this.mPCListener = new d();
        this.unReadNewFriendSystemMsg = new ArrayList<>();
        this.newFriendMsgHeadComparator = new e();
        this.mNewFriends = new HashSet<>();
        this.hasInitNewFriendList = false;
    }

    private void addMayKnowTitle(ArrayList<i> arrayList, boolean z16, List<MayKnowRecommend> list) {
        if (z16 && !list.isEmpty()) {
            arrayList.add(new h());
            Iterator<MayKnowRecommend> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new g(it.next()));
            }
        }
    }

    private ArrayList<i> createNewFriendMoroInfo(ArrayList<i> arrayList) {
        com.tencent.mobileqq.newfriend.data.a aVar = new com.tencent.mobileqq.newfriend.data.a();
        aVar.f254014a = HardCodeUtil.qqStr(R.string.cig);
        aVar.f254015b = 1000;
        arrayList.add(new j(aVar));
        return arrayList;
    }

    private ArrayList<com.tencent.mobileqq.newfriend.msg.c> getClonedUnReadNewFriendSystemMsg() {
        return (ArrayList) this.unReadNewFriendSystemMsg.clone();
    }

    private ArrayList<Entity> getRecommendContacts(boolean z16, ArrayList<i> arrayList, StringBuilder sb5, ArrayList<com.tencent.mobileqq.activity.contact.connections.a> arrayList2, boolean z17, ArrayList<Entity> arrayList3) {
        if (this.mHasReadContactPermission) {
            arrayList3 = (ArrayList) this.mPhoneContactService.getRecommendContact().clone();
            com.tencent.mobileqq.activity.contact.connections.a aVar = null;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                Iterator<com.tencent.mobileqq.activity.contact.connections.a> it = arrayList2.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.activity.contact.connections.a next = it.next();
                    if (z16) {
                        aVar = next;
                    }
                }
            }
            if (aVar != null && QLog.isColorLevel()) {
                QLog.d(TAG, 2, "loadNewFriendMsg init defaultTabInfo.recommend_count = " + aVar.f181254b);
            }
            if (arrayList3 != null && arrayList3.size() > 0) {
                Iterator<Entity> it5 = arrayList3.iterator();
                while (it5.hasNext()) {
                    Entity next2 = it5.next();
                    if (next2 instanceof ContactMatch) {
                        if (z17) {
                            arrayList.add(new com.tencent.mobileqq.newfriend.msg.b((ContactMatch) next2));
                        }
                        if (aVar != null) {
                            aVar.f181254b++;
                        }
                        if (QLog.isColorLevel()) {
                            sb5.append(" cm");
                            ContactMatch contactMatch = (ContactMatch) next2;
                            sb5.append(contactMatch.mobileNo);
                            sb5.append(contactMatch.isReaded);
                        }
                    } else if (next2 instanceof ContactBinded) {
                        if (z17) {
                            arrayList.add(new com.tencent.mobileqq.newfriend.msg.a((ContactBinded) next2));
                        }
                        if (QLog.isColorLevel()) {
                            sb5.append(" cb");
                            sb5.append(((ContactBinded) next2).isReaded);
                        }
                    }
                }
                if (aVar != null && QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "loadNewFriendMsg result defaultTabInfo.recommend_count = " + aVar.f181254b);
                }
            }
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ArrayList<com.tencent.mobileqq.newfriend.msg.c> getUnReadNewFriendSystemMsgFromDB() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getUnReadNewFriendSystemMsgFromDB start,old unReadNewFriendSystemMsg.size() = " + this.unReadNewFriendSystemMsg.size());
        }
        this.unReadNewFriendSystemMsg.clear();
        List<MessageRecord> msgList = ((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).getMsgList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        if (msgList != null && msgList.size() > 0) {
            for (MessageRecord messageRecord : msgList) {
                if (messageRecord instanceof MessageForSystemMsg) {
                    ((MessageForSystemMsg) messageRecord).parse();
                    if (((MessageForSystemMsg) messageRecord).structMsg.f436065msg.sub_type.get() == 13) {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(((MessageForSystemMsg) messageRecord).structMsg.req_uin.get())), TAG);
                        if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B()) {
                        }
                    }
                    if (!messageRecord.isread) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "getUnReadNewFriendSystemMsgFromDB add a msg,mr.senderuin = " + messageRecord.senderuin + ",mr.time = " + messageRecord.time);
                        }
                        if (this.unReadNewFriendSystemMsg.size() > 0) {
                            Iterator<com.tencent.mobileqq.newfriend.msg.c> it = this.unReadNewFriendSystemMsg.iterator();
                            while (it.hasNext()) {
                                MessageForSystemMsg messageForSystemMsg = it.next().f254022d;
                                if (messageForSystemMsg != null && messageForSystemMsg.senderuin.equals(messageRecord.senderuin)) {
                                    z16 = true;
                                    break;
                                }
                            }
                        }
                        z16 = false;
                        if (!z16) {
                            this.unReadNewFriendSystemMsg.add(new com.tencent.mobileqq.newfriend.msg.c((MessageForSystemMsg) messageRecord));
                        }
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getUnReadNewFriendSystemMsgFromDB size = " + this.unReadNewFriendSystemMsg.size());
        }
        return this.unReadNewFriendSystemMsg;
    }

    private void insertMsgForAIOShowNewsMsg(String str, String str2, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "insertMsgForAIOShowNewsMsg" + str2 + ",msgType:" + i3);
        }
        long K0 = com.tencent.mobileqq.service.message.e.K0() - 60;
        List<MessageRecord> aIOList = ((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).getAIOList(str2, 0);
        if (aIOList != null && !aIOList.isEmpty()) {
            K0 = aIOList.get(0).time - 360;
        }
        long j3 = K0;
        List<MessageRecord> allMessages = ((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).getAllMessages(str2, 0, new int[]{i3});
        if (allMessages != null) {
            for (MessageRecord messageRecord : allMessages) {
                if (messageRecord != null) {
                    ((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).removeMsgFromCacheByUniseq(messageRecord.frienduin, 0, messageRecord.msgtype, messageRecord.uniseq);
                }
            }
        }
        MessageRecord createMsgRecordByMsgType = ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createMsgRecordByMsgType(i3);
        createMsgRecordByMsgType.init(this.mApp.getCurrentAccountUin(), str2, str2, str, j3, i3, 0, j3);
        createMsgRecordByMsgType.isread = true;
        if (!MessageHandlerUtils.msgFilter(this.mApp, createMsgRecordByMsgType, false)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(createMsgRecordByMsgType);
            ((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).addAIOHeadMessage(str2, 0, arrayList);
        }
    }

    private boolean isMessageRecordExist(String str, int i3) {
        List<MessageRecord> allMessages = ((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).getAllMessages(str, 0, new int[]{i3});
        if (allMessages != null && allMessages.size() > 0) {
            return true;
        }
        return false;
    }

    private boolean isShouldCreateOrGetRecentUser(i iVar) {
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return false;
        }
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) appInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        if (iVar == null || recentUserCache == null) {
            return false;
        }
        if (iVar.b() && !recentUserCache.isRecentUserInCache(AppConstants.RECOMMEND_CONTACT_UIN, 4000)) {
            return false;
        }
        return true;
    }

    public static boolean isSuspiciousSysMsg(MessageRecord messageRecord) {
        byte[] bArr;
        if (messageRecord == null || (bArr = messageRecord.msgData) == null) {
            return false;
        }
        try {
            return com.tencent.mobileqq.newfriend.msg.c.j(MessageForSystemMsg.parseStructMsg(bArr));
        } catch (Exception e16) {
            QLog.e(TAG, 2, e16, new Object[0]);
            return false;
        }
    }

    private void loadGuideMessage(ArrayList<i> arrayList, IPhoneContactService iPhoneContactService) {
        if (isShowContactGuide()) {
            arrayList.add(new com.tencent.mobileqq.newfriend.msg.e());
        } else if (this.showContactGuideV2) {
            if (!this.mHasReadContactPermission || iPhoneContactService.needUploadContact()) {
                arrayList.add(new f(getConfBean(), this.mHasReadContactPermission));
            }
        }
    }

    private void loadLimitCountNewFriendMsg(ArrayList<i> arrayList, ArrayList<i> arrayList2, int i3, int i16, boolean z16, int i17) {
        int i18 = 0;
        if (arrayList2.size() > 0) {
            Collections.sort(arrayList2, this.mComparator);
            com.tencent.mobileqq.newfriend.data.b bVar = new com.tencent.mobileqq.newfriend.data.b();
            bVar.f254016a = HardCodeUtil.qqStr(R.string.cim);
            bVar.f254017b = i17 == 3;
            bVar.f254018c = ((INewFriendVerificationService) this.mApp.getRuntimeService(INewFriendVerificationService.class, "")).isShowRedPointAtNewFriendBanner();
            arrayList.add(new l(bVar));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "loadNewFriendMsg|mLastSysMsgTotalCount = " + this.mLastSysMsgTotalCount + ",notifyListSize = " + arrayList2.size() + ", mSysMsgShouldAddMoreInfo = " + this.mSysMsgShouldAddMoreInfo);
            }
            if (z16 && i16 > 0) {
                if (this.mLastSysMsgTotalCount != arrayList2.size()) {
                    loadWhenNotifyListSizeNotEqTotal(arrayList, arrayList2);
                } else {
                    while (i18 < this.mSysMsgShowCount) {
                        arrayList.add(arrayList2.get(i18));
                        i18++;
                    }
                    if (this.mSysMsgShouldAddMoreInfo) {
                        createNewFriendMoroInfo(arrayList);
                    }
                }
                this.mLastSysMsgTotalCount = arrayList2.size();
                return;
            }
            if (arrayList2.size() > 100) {
                while (i18 < 100) {
                    arrayList.add(arrayList2.get(i18));
                    i18++;
                }
                createNewFriendMoroInfo(arrayList);
                return;
            }
            arrayList.addAll(arrayList2);
            if ((i3 % 20 != 0 || ((INewFriendApi) QRoute.api(INewFriendApi.class)).isHasNoMoreMsg(this.mApp)) && (i3 <= 20 || ((INewFriendApi) QRoute.api(INewFriendApi.class)).getSysMsgOverValue(this.mApp))) {
                return;
            }
            createNewFriendMoroInfo(arrayList);
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("new_friend_sys_empty_builder", false);
        QLog.i(TAG, 1, "newSwitch: " + isSwitchOn + "mayKnowPersonNum: " + i16);
        if (!isSwitchOn || i16 <= 0) {
            arrayList.add(new m());
        }
    }

    private void loadMsgAccordingToTabAndMayKnow(ArrayList<i> arrayList, boolean z16, ArrayList<i> arrayList2, boolean z17) {
        if (z17) {
            if (z16 && arrayList2.size() == 0) {
                arrayList.add(new n());
                return;
            }
            return;
        }
        if (arrayList2.size() > 0) {
            com.tencent.mobileqq.newfriend.data.b bVar = new com.tencent.mobileqq.newfriend.data.b();
            bVar.f254016a = HardCodeUtil.qqStr(R.string.f170117gw);
            arrayList.add(new l(bVar));
        }
    }

    private void loadQIMMsg(ArrayList<QIMFollwerAdd> arrayList, ArrayList<i> arrayList2) {
        ArrayList<r> qIMNotifyAddFriendsMsg = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getQIMNotifyAddFriendsMsg(false, this.mApp);
        if (qIMNotifyAddFriendsMsg.size() > 0) {
            arrayList2.addAll(qIMNotifyAddFriendsMsg);
        }
        if (((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).hasQimSource(this.mApp) && arrayList != null && arrayList.size() > 0) {
            Iterator<QIMFollwerAdd> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new q(it.next()));
            }
        }
    }

    private void loadRecommendAndEducation(ArrayList<i> arrayList, ArrayList<i> arrayList2, StringBuilder sb5, ArrayList<MayKnowRecommend> arrayList3, boolean z16) {
        if (arrayList2.size() > 0) {
            this.mRecommendSubTitleIndex = arrayList.size();
            Collections.sort(arrayList2, this.mComparator);
            arrayList.addAll(arrayList2);
        }
        this.mRecommendShowCount = arrayList2.size();
        if (QLog.isColorLevel()) {
            sb5.append(" mRecommendSubTitleIndex : ");
            sb5.append(this.mRecommendSubTitleIndex);
            sb5.append(" mRecommendShowCount : ");
            sb5.append(this.mRecommendShowCount);
            sb5.append(" shouldShowNewFriendMayknow:");
            sb5.append(z16);
            QLog.d(TAG, 2, sb5.toString());
        }
    }

    private int loadSystemMsg(boolean z16, StringBuilder sb5, ArrayList<i> arrayList, int i3) {
        List<MessageRecord> msgList;
        if (z16) {
            List<ChatMessage> aIOList = ((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, ((INewFriendApi) QRoute.api(INewFriendApi.class)).getOldestSysMsgTime(this.mApp));
            msgList = new ArrayList(aIOList.size());
            try {
                msgList.addAll(aIOList);
            } catch (NullPointerException unused) {
                QLog.e(TAG, 1, "[loadSystemMsg] is NullPointerException!");
                msgList = new ArrayList();
            }
        } else {
            msgList = ((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).getMsgList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        }
        if (msgList != null && msgList.size() > 0) {
            for (MessageRecord messageRecord : msgList) {
                if (messageRecord instanceof MessageForSystemMsg) {
                    if (QLog.isColorLevel()) {
                        sb5.append(" sys");
                        sb5.append(messageRecord.isread);
                    }
                    MessageForSystemMsg messageForSystemMsg = (MessageForSystemMsg) messageRecord;
                    messageForSystemMsg.parse();
                    if (messageForSystemMsg.structMsg.f436065msg.sub_type.get() == 13) {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(messageForSystemMsg.structMsg.req_uin.get())), TAG);
                        if (friendsSimpleInfoWithUid == null || !friendsSimpleInfoWithUid.B()) {
                            i3++;
                            if (QLog.isColorLevel()) {
                                sb5.append(" sys");
                                sb5.append(messageRecord.isread);
                            }
                        }
                    }
                    arrayList.add(new com.tencent.mobileqq.newfriend.msg.c(messageForSystemMsg));
                }
            }
        }
        return i3;
    }

    private void loadWhenNotifyListSizeNotEqTotal(ArrayList<i> arrayList, ArrayList<i> arrayList2) {
        int i3 = 0;
        if (arrayList2.size() > 3) {
            boolean z16 = true;
            int size = arrayList2.size() - 1;
            while (size >= 0 && arrayList2.get(size).b()) {
                size--;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "loadNewFriendMsg|lastUnReadIndex = " + size);
            }
            int unReadFriendSystemMsgNum = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getUnReadFriendSystemMsgNum(this.mApp);
            if (size <= 2) {
                while (i3 < 3) {
                    arrayList.add(arrayList2.get(i3));
                    i3++;
                }
                this.mSysMsgShowCount = 3;
            } else {
                while (i3 <= size) {
                    arrayList.add(arrayList2.get(i3));
                    i3++;
                }
                int i16 = size + 1;
                this.mSysMsgShowCount = i16;
                if (unReadFriendSystemMsgNum <= 99 && i16 == arrayList2.size()) {
                    z16 = true ^ ((INewFriendApi) QRoute.api(INewFriendApi.class)).getSysMsgOverValue(this.mApp);
                }
            }
            this.mSysMsgShouldAddMoreInfo = z16;
            if (z16) {
                createNewFriendMoroInfo(arrayList);
                return;
            }
            return;
        }
        arrayList.addAll(arrayList2);
        this.mSysMsgShouldAddMoreInfo = false;
        this.mSysMsgShowCount = arrayList2.size();
    }

    private void logLoadMsgSizeAndUnReadMsgCountInCache(ArrayList<i> arrayList) {
        if (QLog.isColorLevel()) {
            Iterator<i> it = arrayList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i next = it.next();
                if (next != null && !next.b() && (next instanceof com.tencent.mobileqq.newfriend.msg.c)) {
                    i3++;
                }
            }
            QLog.d(TAG, 2, "loadNewFriendMsg size = " + arrayList.size() + ",unReadSysMsgCountInCache = " + i3);
        }
    }

    private void markQIMFollwerReaded() {
        EntityManager createEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        ArrayList arrayList = (ArrayList) createEntityManager.query(QIMFollwerAdd.class);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                QIMFollwerAdd qIMFollwerAdd = (QIMFollwerAdd) it.next();
                qIMFollwerAdd.isRead = true;
                createEntityManager.update(qIMFollwerAdd);
            }
        }
        createEntityManager.close();
    }

    private void refreshNotification() {
        i lastUnreadNewFriendMessage = getLastUnreadNewFriendMessage();
        if (lastUnreadNewFriendMessage != null) {
            refreshRecentData(lastUnreadNewFriendMessage);
            setChanged();
            notifyObservers(lastUnreadNewFriendMessage);
        } else {
            removeNewFriendRecentUser();
        }
        refreshContactUnreadCount();
    }

    private void refreshRecentData(i iVar) {
        if (!isShouldCreateOrGetRecentUser(iVar)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "refreshRecentData | isShouldCreateOrGetRecentUser = true");
        }
        RecentUserProxy recentUserCache = ((IRecentUserProxyService) this.mApp.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        RecentUser findRecentUserByUin = recentUserCache.findRecentUserByUin(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
        Object obj = findRecentUserByUin.f203116msg;
        if (obj != null && !(obj instanceof String)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "wrong ru.msg error | type is :" + findRecentUserByUin.f203116msg.getClass().toString());
                return;
            }
            return;
        }
        findRecentUserByUin.msgType = 26;
        findRecentUserByUin.displayName = NEW_FRIEND_TAG;
        if (iVar != null && (iVar instanceof com.tencent.mobileqq.newfriend.msg.d)) {
            findRecentUserByUin.lastmsgdrafttime = iVar.f254036b;
            findRecentUserByUin.f203116msg = iVar.f254035a;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "resetRecentUserUnreadCount | temp str = " + findRecentUserByUin.f203116msg);
            }
        } else if (iVar != null && (iVar instanceof com.tencent.mobileqq.newfriend.msg.c) && !TextUtils.isEmpty(iVar.f254035a)) {
            long j3 = iVar.f254036b;
            if (j3 > 0) {
                findRecentUserByUin.lastmsgtime = j3;
            }
            findRecentUserByUin.f203116msg = iVar.f254035a;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "resetRecentUserUnreadCount | ru.lastmsgtime = " + findRecentUserByUin.lastmsgtime);
            }
        }
        if (findRecentUserByUin.msgData == null) {
            findRecentUserByUin.msgData = String.valueOf(findRecentUserByUin.f203116msg).getBytes();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "refreshRecentData | ru.msg = " + findRecentUserByUin.f203116msg);
        }
        recentUserCache.saveRecentUser(findRecentUserByUin);
    }

    private synchronized void setMixedMessagesReaded() {
        Collection<i> collection;
        if (((INewFriendApi) QRoute.api(INewFriendApi.class)).getUnReadFriendSystemMsgNum(this.mApp) != 0) {
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102145", false);
        ArrayList<i> arrayList = new ArrayList<>();
        if (isSwitchOn) {
            collection = Collections.synchronizedCollection(this.mMixedMessages);
        } else {
            collection = this.mMixedMessages;
        }
        for (i iVar : collection) {
            if ((iVar instanceof com.tencent.mobileqq.newfriend.msg.c) && !iVar.b()) {
                ((com.tencent.mobileqq.newfriend.msg.c) iVar).f254022d.isread = true;
                com.tencent.mobileqq.newfriend.msg.c cVar = new com.tencent.mobileqq.newfriend.msg.c(((com.tencent.mobileqq.newfriend.msg.c) iVar).f254022d);
                cVar.f254022d.isread = true;
                arrayList.add(cVar);
            } else {
                arrayList.add(iVar);
            }
        }
        if (isSwitchOn) {
            collection.clear();
            collection.addAll(arrayList);
        } else {
            this.mMixedMessages = arrayList;
        }
    }

    public static boolean shouldMergeNewFriendContact(AppInterface appInterface, String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.equals(AppConstants.RECOMMEND_CONTACT_UIN) && !str.equals(AppConstants.MAYKNOW_RECOMMEND_UIN) && !str.equals(AppConstants.FRIEND_SYSTEM_MSG_UIN) && !str.equals(AppConstants.FRIEND_ANNIVER_UIN)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void addListener(nb2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        synchronized (this.mListenerList) {
            if (!this.mListenerList.contains(aVar)) {
                this.mListenerList.add(aVar);
            }
        }
    }

    @Override // java.util.Observable, com.tencent.mobileqq.newfriend.api.INewFriendService
    public void addObserver(Observer observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) observer);
        } else {
            super.addObserver(observer);
        }
    }

    public void clearAllSysSuspiciousCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "clearAllSysSuspiciousCache ");
        }
        if (!this.mSuspiciousMsgMap.isEmpty()) {
            this.mSuspiciousMsgMap.clear();
        }
        this.mSysSuspiciousForceLoadDb = true;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void clearAllSysSuspiciousMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
            return;
        }
        this.mSuspiciousMsgMap.clear();
        EntityManager entityManager = this.f253969em;
        if (entityManager != null && entityManager.isOpen()) {
            boolean drop = this.f253969em.drop(SysSuspiciousMsg.class);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "clearAllSysSuspiciousMsg " + drop);
            }
        }
    }

    @Override // java.util.Observable, com.tencent.mobileqq.newfriend.api.INewFriendService
    public synchronized void deleteObserver(Observer observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) observer);
        } else {
            super.deleteObserver(observer);
        }
    }

    public void deleteQIMFollowerAdd(QIMFollwerAdd qIMFollwerAdd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qIMFollwerAdd);
        } else {
            this.mApp.getEntityManagerFactory().createEntityManager().remove(qIMFollwerAdd);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void deleteSysSuspiciousMsg(long j3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, j3);
            return;
        }
        SysSuspiciousMsg remove = this.mSuspiciousMsgMap.remove(Long.valueOf(j3));
        EntityManager entityManager = this.f253969em;
        if (entityManager != null && entityManager.isOpen()) {
            if (remove == null) {
                remove = (SysSuspiciousMsg) DBMethodProxy.find(this.f253969em, (Class<? extends Entity>) SysSuspiciousMsg.class, j3);
            }
            if (remove != null) {
                z16 = this.f253969em.remove(remove);
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "deleteSysSuspiciousMsg " + j3 + " " + z16);
            }
        }
    }

    public int getAllMessageCount() {
        com.tencent.mobileqq.newfriend.msg.c cVar;
        MessageForSystemMsg messageForSystemMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        Iterator<i> it = getMixedNewFriendDatas().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i next = it.next();
            if (next != null && !next.b() && (next instanceof com.tencent.mobileqq.newfriend.msg.c) && (messageForSystemMsg = (cVar = (com.tencent.mobileqq.newfriend.msg.c) next).f254022d) != null && messageForSystemMsg.getSystemMsg() != null && cVar.f254022d.getSystemMsg().f436065msg != null) {
                i3++;
            }
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public List<SysSuspiciousMsg> getAllSysSuspiciousMsg() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (List) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        List<SysSuspiciousMsg> list = null;
        if (!this.mSysSuspiciousForceLoadDb) {
            Collection<SysSuspiciousMsg> values = this.mSuspiciousMsgMap.values();
            if (values != null) {
                list = new ArrayList(values);
            }
        } else {
            EntityManager entityManager = this.f253969em;
            if (entityManager != null && entityManager.isOpen()) {
                list = this.f253969em.query(SysSuspiciousMsg.class);
                this.mSuspiciousMsgMap.clear();
                if (list != null) {
                    for (SysSuspiciousMsg sysSuspiciousMsg : list) {
                        this.mSuspiciousMsgMap.put(Long.valueOf(sysSuspiciousMsg.uin), sysSuspiciousMsg);
                    }
                }
                this.mSysSuspiciousForceLoadDb = false;
            }
        }
        if (list != null) {
            Collections.sort(list, this.mSysSuspiciousMsgComparator);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getAllSysSuspiciousMsg ");
            sb5.append(this.mSysSuspiciousForceLoadDb);
            sb5.append(" ");
            if (list != null) {
                obj = Integer.valueOf(list.size());
            } else {
                obj = "null";
            }
            sb5.append(obj);
            QLog.i(TAG, 2, sb5.toString());
        }
        return list;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public int getAllUnreadMessageCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        int unReadFriendSystemMsgNum = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getUnReadFriendSystemMsgNum(this.mApp);
        Collection<i> mixedNewFriendDatas = getMixedNewFriendDatas();
        int i3 = 0;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102207", false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getAllUnreadMessageCount isSynchronizedSwitch : " + isSwitchOn);
        }
        if (isSwitchOn) {
            mixedNewFriendDatas = Collections.synchronizedCollection(mixedNewFriendDatas);
        }
        int i16 = 0;
        for (i iVar : mixedNewFriendDatas) {
            if (iVar != null && !iVar.b()) {
                if (iVar instanceof com.tencent.mobileqq.newfriend.msg.c) {
                    i16++;
                } else {
                    i3++;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getAllUnreadMessageCount|total unread = " + i3 + ",unReadSysMsgCount = " + unReadFriendSystemMsgNum + ",unReadSysMsgCountInCache = " + i16);
        }
        return i3 + unReadFriendSystemMsgNum;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public List<Object> getAllUnreadMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (List) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        Collection<i> mixedNewFriendDatas = getMixedNewFriendDatas();
        int i3 = 0;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102145", false);
        StringBuilder sb5 = new StringBuilder();
        if (QLog.isColorLevel()) {
            sb5.append("isSynchronizedSwitch : ");
            sb5.append(isSwitchOn);
            sb5.append("\n");
        }
        if (isSwitchOn) {
            mixedNewFriendDatas = Collections.synchronizedCollection(mixedNewFriendDatas);
        }
        for (i iVar : mixedNewFriendDatas) {
            if (iVar != null && !iVar.b()) {
                if (iVar instanceof com.tencent.mobileqq.newfriend.msg.c) {
                    QLog.i(TAG, 2, "mUnReadListSwitch = " + this.mUnReadListSwitch);
                    if (this.mUnReadListSwitch) {
                        arrayList.add(iVar);
                    }
                    i3++;
                } else {
                    arrayList.add(iVar);
                    sb5.append("getAllUnreadMsg unexpected nfm = ");
                    sb5.append(iVar);
                    sb5.append("\n");
                }
            }
        }
        if (!this.mUnReadListSwitch) {
            arrayList.addAll(getClonedUnReadNewFriendSystemMsg());
        }
        if (arrayList.size() > 0) {
            try {
                Collections.sort(arrayList, this.newFriendMsgHeadComparator);
            } catch (Exception unused) {
                sb5.append("getAllUnreadMsg sort exception\n");
            }
        }
        if (QLog.isColorLevel()) {
            sb5.append("getAllUnreadMsg size = ");
            sb5.append(arrayList.size());
            sb5.append(",unReadSysMsgCountInCache = ");
            sb5.append(i3);
            sb5.append("\n");
            if (arrayList.size() > 0) {
                for (Object obj : arrayList) {
                    if (obj instanceof PhoneContact) {
                        sb5.append("getAllUnreadMsg PhoneContact time  = ");
                        sb5.append(((PhoneContact) obj).lastScanTime);
                        sb5.append("\n");
                    } else if (obj instanceof com.tencent.mobileqq.newfriend.msg.c) {
                        sb5.append("getAllUnreadMsg FriendSystemMessage time  = ");
                        sb5.append(((com.tencent.mobileqq.newfriend.msg.c) obj).f254036b * 1000);
                        sb5.append("\n");
                    } else if (obj instanceof com.tencent.mobileqq.newfriend.msg.b) {
                        sb5.append("getAllUnreadMsg ContactMatchMessage time  = ");
                        sb5.append(((com.tencent.mobileqq.newfriend.msg.b) obj).f254036b * 1000);
                        sb5.append("\n");
                    }
                }
            }
            QLog.d(TAG, 2, sb5.toString());
        }
        return arrayList;
    }

    public int getAllZPlanUnreadMessageCount() {
        com.tencent.mobileqq.newfriend.msg.c cVar;
        MessageForSystemMsg messageForSystemMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        ArrayList<i> mixedNewFriendDatas = getMixedNewFriendDatas();
        int i3 = 0;
        if (mixedNewFriendDatas == null) {
            return 0;
        }
        Iterator<i> it = mixedNewFriendDatas.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (next != null && !next.b() && (next instanceof com.tencent.mobileqq.newfriend.msg.c) && (messageForSystemMsg = (cVar = (com.tencent.mobileqq.newfriend.msg.c) next).f254022d) != null && messageForSystemMsg.getSystemMsg() != null && cVar.f254022d.getSystemMsg().f436065msg != null) {
                structmsg$SystemMsg structmsg_systemmsg = cVar.f254022d.getSystemMsg().f436065msg;
                if (structmsg_systemmsg.sub_type.get() == 1 && (structmsg_systemmsg.src_id.get() == 3177 || structmsg_systemmsg.src_id.get() == 3178 || structmsg_systemmsg.src_id.get() == 2177 || structmsg_systemmsg.src_id.get() == 2178)) {
                    i3++;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getAllZPlanUnreadMessageCount|total unread = " + i3);
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public com.tencent.mobileqq.newfriend.config.a getConfBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (com.tencent.mobileqq.newfriend.config.a) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        if (this.mBean == null) {
            this.mBean = new com.tencent.mobileqq.newfriend.config.a();
        }
        return this.mBean;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public i getLastUnreadNewFriendMessage() {
        Collection collection;
        i iVar;
        i iVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (i) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        ArrayList<i> mixedNewFriendDatas = getMixedNewFriendDatas();
        int i3 = 0;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102207", false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getLastUnreadNewFriendMessage isSynchronizedSwitch : " + isSwitchOn);
        }
        if (isSwitchOn) {
            collection = Collections.synchronizedCollection(mixedNewFriendDatas);
        } else {
            collection = mixedNewFriendDatas;
        }
        int size = collection.size();
        int i16 = 0;
        while (true) {
            iVar = null;
            if (i16 < size) {
                if (i16 >= size) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getLastUnreadNewFriendMessage i>= size");
                    }
                } else {
                    iVar2 = mixedNewFriendDatas.get(i16);
                    if (iVar2 != null && !iVar2.b()) {
                        break;
                    }
                    i16++;
                }
            } else {
                break;
            }
        }
        iVar2 = null;
        if (iVar2 != null && !(iVar2 instanceof com.tencent.mobileqq.newfriend.msg.d)) {
            while (true) {
                if (i3 < mixedNewFriendDatas.size()) {
                    i iVar3 = mixedNewFriendDatas.get(i3);
                    if (iVar3 != null && !iVar3.b() && !(iVar3 instanceof com.tencent.mobileqq.newfriend.msg.c)) {
                        iVar = iVar3;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            if (iVar != null && iVar2.f254036b < iVar.f254036b) {
                return iVar;
            }
            return iVar2;
        }
        return iVar2;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public ArrayList<i> getMixedNewFriendDatas() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ArrayList) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102209", false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getMixedNewFriendDatas isSynchronizedSwitch : " + isSwitchOn);
        }
        if (isSwitchOn) {
            return new ArrayList<>(this.mMixedMessages);
        }
        return (ArrayList) this.mMixedMessages.clone();
    }

    public ArrayList<QIMFollwerAdd> getQIMFollwerAddList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ArrayList) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return (ArrayList) this.mApp.getEntityManagerFactory().createEntityManager().query(QIMFollwerAdd.class);
    }

    public int getRceommendShowCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.mRecommendShowCount;
    }

    public int getRecommendSubTitleIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.mRecommendSubTitleIndex;
    }

    public int getSysSuspiciousUnreadNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Integer) iPatchRedirector.redirect((short) 44, (Object) this)).intValue();
        }
        return this.mSysSuspiciousUnreadNum;
    }

    public SysSuspiciousMsg getSysSuspicousMsg(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (SysSuspiciousMsg) iPatchRedirector.redirect((short) 49, (Object) this, j3);
        }
        SysSuspiciousMsg sysSuspiciousMsg = this.mSuspiciousMsgMap.get(Long.valueOf(j3));
        if (sysSuspiciousMsg == null) {
            EntityManager entityManager = this.f253969em;
            if (entityManager != null && entityManager.isOpen()) {
                sysSuspiciousMsg = (SysSuspiciousMsg) DBMethodProxy.find(this.f253969em, (Class<? extends Entity>) SysSuspiciousMsg.class, j3);
            }
            if (sysSuspiciousMsg != null) {
                this.mSuspiciousMsgMap.put(Long.valueOf(j3), sysSuspiciousMsg);
            }
        }
        return sysSuspiciousMsg;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void getUnreadMessageCountAsync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else if (Looper.getMainLooper() != Looper.myLooper()) {
            refreshContactUnreadCount();
        } else {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NewFriendServiceImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        NewFriendServiceImpl.this.loadNewFriendMsg(true);
                        NewFriendServiceImpl.this.refreshContactUnreadCount();
                    }
                }
            }, null, false);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public int getUnreadSystemMessageCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return ((INewFriendApi) QRoute.api(INewFriendApi.class)).getUnReadFriendSystemMsgNum(this.mApp);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "HandleMessage what=" + message.what);
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 == 8) {
                            this.mPhoneContactService.markRecommendReaded();
                            reloadNewFriendMsg();
                        }
                    } else {
                        ((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).setReaded(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
                        ((INewFriendApi) QRoute.api(INewFriendApi.class)).setUnReadFriendSystemMsgNum(this.mApp, 0);
                        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).sendFriendSystemMsgReadedReport(this.mApp);
                        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).markQIMNotifyAddFriendsRead(this.mApp);
                        reloadNewFriendMsg();
                    }
                } else {
                    ((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).setReaded(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, true, true);
                    this.mPhoneContactService.markRecommendReaded();
                    markQIMFollwerReaded();
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).markQIMNotifyAddFriendsRead(this.mApp);
                    ((INewFriendApi) QRoute.api(INewFriendApi.class)).setUnReadFriendSystemMsgNum(this.mApp, 0);
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).sendFriendSystemMsgReadedReport(this.mApp);
                    reloadNewFriendMsg();
                }
            } else {
                reloadNewFriendMsg();
            }
        } else {
            loadNewFriendMsg(true);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public boolean handleNewFrdAIOShow(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, (Object) this, i3, (Object) str)).booleanValue();
        }
        if (i3 != 0) {
            return false;
        }
        boolean isNewFrdMiniCardSwitchOn = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).isNewFrdMiniCardSwitchOn(this.mApp);
        boolean isNewFriend = isNewFriend(str);
        QLog.d(TAG, 1, String.format("handleNewFrdAIOShow [isNewFrd,newFrdMiniCardSwitch]=[%b,%b]", Boolean.valueOf(isNewFriend), Boolean.valueOf(isNewFrdMiniCardSwitchOn)));
        if (!isNewFriend) {
            return false;
        }
        if (!isNewFrdMiniCardSwitchOn) {
            isFirstEnterNewFriendAio(str);
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).insertCommonHobbyIfNeeded(this.mApp, str);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void handleQIMNewFollower(QIMFollwerAdd qIMFollwerAdd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) qIMFollwerAdd);
            return;
        }
        EntityManager createEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        createEntityManager.persistOrReplace(qIMFollwerAdd);
        createEntityManager.close();
        reloadNewFriendMsg();
        ((IAppBadgeService) this.mApp.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void initNewFriendList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "initNewFriendList hasInitNewFriendList: " + this.hasInitNewFriendList);
        }
        if (this.hasInitNewFriendList) {
            return;
        }
        this.hasInitNewFriendList = true;
        String string = MobileQQ.sMobileQQ.getSharedPreferences("new_friend", 0).getString("new_friend_list", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        String[] split = string.split("#");
        synchronized (this.mNewFriends) {
            int length = split.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (!TextUtils.isEmpty(split[i3])) {
                    this.mNewFriends.add(split[i3]);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void insertCommonHobbyForAIOShowNewsMsg(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) str, (Object) str2);
        } else if (!isMessageRecordExist(str2, MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED)) {
            insertMsgForAIOShowNewsMsg(str, str2, -2023);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void insertFriendFeedForAIOShowNewsMsg(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str, (Object) str2);
        } else if (!isMessageRecordExist(str2, -2023)) {
            insertMsgForAIOShowNewsMsg(str, str2, MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public boolean isFirstEnterNewFriendAio(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.mNewFriends) {
            boolean remove = this.mNewFriends.remove(str);
            StringBuilder sb5 = new StringBuilder();
            Iterator<String> it = this.mNewFriends.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
                sb5.append("#");
            }
            SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("new_friend", 0);
            if (sharedPreferences.edit() == null) {
                QLog.e(TAG, 1, "saveNewFriend2Cache is error! sp.edit() is null!");
                return remove;
            }
            sharedPreferences.edit().putString("new_friend_list", sb5.toString()).apply();
            return remove;
        }
    }

    public boolean isGuideBindReported() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, (Object) this)).booleanValue();
        }
        return this.mIsGuideBindReported;
    }

    public boolean isGuidePermissionReported() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this)).booleanValue();
        }
        return this.mIsGuidePermissionReported;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public boolean isNewFriend(String str) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, (Object) str)).booleanValue();
        }
        synchronized (this.mNewFriends) {
            contains = this.mNewFriends.contains(str);
        }
        return contains;
    }

    public boolean isShowContactGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Boolean) iPatchRedirector.redirect((short) 58, (Object) this)).booleanValue();
        }
        return this.showContactGuide;
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void loadNewFriendMsg(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            loadNewFriendMsg(z16, 23);
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        }
    }

    public synchronized void loadNewFriendMsgData(boolean z16, List<MayKnowRecommend> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), list);
            return;
        }
        ArrayList<i> arrayList = new ArrayList<>();
        ArrayList<QIMFollwerAdd> qIMFollwerAddList = getQIMFollwerAddList();
        ArrayList<i> arrayList2 = new ArrayList<>();
        StringBuilder sb5 = new StringBuilder();
        if (QLog.isColorLevel()) {
            sb5.append("loadNewFriendMsg");
        }
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.mApp.getRuntimeService(IPhoneContactService.class, "");
        this.mHasReadContactPermission = PermissionChecker.h().f();
        loadGuideMessage(arrayList, iPhoneContactService);
        int loadSystemMsg = loadSystemMsg(z16, sb5, arrayList2, 0);
        loadQIMMsg(qIMFollwerAddList, arrayList2);
        boolean shouldShowMayKnowInNewFriend = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).shouldShowMayKnowInNewFriend(this.mApp);
        loadLimitCountNewFriendMsg(arrayList, arrayList2, loadSystemMsg, list.size(), shouldShowMayKnowInNewFriend, ((INewFriendVerificationService) this.mApp.getRuntimeService(INewFriendVerificationService.class, "")).getEntranceType());
        logLoadMsgSizeAndUnReadMsgCountInCache(arrayList);
        addMayKnowTitle(arrayList, shouldShowMayKnowInNewFriend, list);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102145", false)) {
            Collection synchronizedCollection = Collections.synchronizedCollection(this.mMixedMessages);
            synchronizedCollection.clear();
            synchronizedCollection.addAll(arrayList);
        } else {
            this.mMixedMessages = arrayList;
        }
        setMixedMessagesReaded();
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void markAllDataReaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            this.mHandler.sendEmptyMessage(3);
        }
    }

    public void markRecommendReaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            this.mHandler.sendEmptyMessage(8);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void markSystemMsgReaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else {
            this.mHandler.sendEmptyMessage(5);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public boolean needShowAvatar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        i lastUnreadNewFriendMessage = getLastUnreadNewFriendMessage();
        if (lastUnreadNewFriendMessage != null && lastUnreadNewFriendMessage.c(this.mApp)) {
            return true;
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.mApp = (AppInterface) appRuntime;
        this.mHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.f253969em = this.mApp.getEntityManagerFactory().createEntityManager();
        this.mPhoneContactService = (IPhoneContactService) this.mApp.getRuntimeService(IPhoneContactService.class, "");
        this.mFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        this.mPhoneContactService.addListener(this.mPCListener);
        this.mApp.addObserver(this.flo, true);
        this.mApp.addObserver(this.mPokeObserver);
        this.mHandler.sendEmptyMessageDelayed(1, 3000L);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102145", false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isSynchronizedSwitch : " + isSwitchOn);
        }
        if (isSwitchOn) {
            Collections.synchronizedCollection(this.mMixedMessages).clear();
        } else {
            this.mMixedMessages.clear();
        }
        this.mPhoneContactService.removeListener(this.mPCListener);
        this.mApp.removeObserver(this.flo);
        this.mApp.removeObserver(this.mPokeObserver);
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void reSetLastSysMsgTotalCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mLastSysMsgTotalCount = i3;
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void refreshContactUnreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NewFriendServiceImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        NewFriendServiceImpl.this.getUnReadNewFriendSystemMsgFromDB();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 32, new ThreadExcutor.IThreadListener(getAllUnreadMessageCount()) { // from class: com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f253973d;

                {
                    this.f253973d = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NewFriendServiceImpl.this, r5);
                    }
                }

                @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
                public void onAdded() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }

                @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
                public void onPostRun() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this);
                    } else {
                        NewFriendServiceImpl.this.mApp.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl.7.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                    synchronized (NewFriendServiceImpl.this.mListenerList) {
                                        Iterator it = NewFriendServiceImpl.this.mListenerList.iterator();
                                        while (it.hasNext()) {
                                            ((nb2.a) it.next()).onUnreadChanged(AnonymousClass7.this.f253973d);
                                        }
                                    }
                                    return;
                                }
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        });
                    }
                }

                @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
                public void onPreRun() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this);
                    }
                }
            }, false);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void refreshNotificationWithFriendSystemMessage(com.tencent.mobileqq.newfriend.msg.c cVar) {
        com.tencent.mobileqq.newfriend.msg.c cVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) cVar);
            return;
        }
        Iterator<ChatMessage> it = ((IMessageFacade) this.mApp.getRuntimeService(IMessageFacade.class, "")).getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, ((INewFriendApi) QRoute.api(INewFriendApi.class)).getOldestSysMsgTime(this.mApp)).iterator();
        while (true) {
            if (it.hasNext()) {
                ChatMessage next = it.next();
                if (!next.isread && (next instanceof MessageForSystemMsg)) {
                    cVar2 = new com.tencent.mobileqq.newfriend.msg.c((MessageForSystemMsg) next);
                    break;
                }
            } else {
                cVar2 = null;
                break;
            }
        }
        if (cVar2 != null) {
            cVar2.f254036b = cVar.f254036b;
            cVar2.f254035a = cVar.f254035a;
            refreshRecentData(cVar2);
            setChanged();
            notifyObservers(cVar2);
        } else {
            removeNewFriendRecentUser();
        }
        refreshContactUnreadCount();
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void reloadNewFriendMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            loadNewFriendMsg(true);
            refreshNotification();
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void removeListener(nb2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        synchronized (this.mListenerList) {
            this.mListenerList.remove(aVar);
        }
    }

    public void removeNewFriendRecentUser() {
        RecentUserProxy recentUserCache;
        RecentUser findRecentUser;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        AppInterface appInterface = this.mApp;
        if (appInterface != null && (findRecentUser = (recentUserCache = ((IRecentUserProxyService) appInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache()).findRecentUser(AppConstants.RECOMMEND_CONTACT_UIN, 4000)) != null) {
            recentUserCache.delRecentUser(findRecentUser);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void saveNewFriend2Cache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.mNewFriends) {
            this.mNewFriends.add(str);
            StringBuilder sb5 = new StringBuilder();
            Iterator<String> it = this.mNewFriends.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
                sb5.append("#");
            }
            SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("new_friend", 0);
            if (sharedPreferences.edit() == null) {
                QLog.e(TAG, 1, "saveNewFriend2Cache is error! sp.edit() is null!");
            } else {
                sharedPreferences.edit().putString("new_friend_list", sb5.toString()).apply();
            }
        }
    }

    public void setContactGuideCancelByUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.showContactGuideV2 = false;
            this.mApp.getPreferences().edit().putBoolean("contact_guide_user_close", true).putInt("new_friend_show_count_after_user_close", 0).apply();
        }
    }

    public void setIsGuideBindReported(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, z16);
        } else {
            this.mIsGuideBindReported = z16;
        }
    }

    public void setIsGuidePermissionReported(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, z16);
        } else {
            this.mIsGuidePermissionReported = z16;
        }
    }

    public void setShowContactGuide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, z16);
        } else {
            this.showContactGuide = z16;
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void setSysSuspiciousUnreadNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
        } else {
            this.mSysSuspiciousUnreadNum = i3;
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void updateBindContactGuideState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        SharedPreferences preferences = this.mApp.getPreferences();
        if (isShowContactGuide()) {
            this.showContactGuideV2 = false;
            if (preferences.edit() == null) {
                QLog.e(TAG, 1, "updateBindContactGuideState is error! pref.edit() is null!");
                return;
            } else {
                preferences.edit().putInt("new_friend_show_count_after_user_close", 0).putBoolean("contact_guide_user_close", false).apply();
                return;
            }
        }
        boolean z16 = preferences.getBoolean("contact_guide_user_close", false);
        int i3 = preferences.getInt("new_friend_show_count_after_user_close", 0);
        com.tencent.mobileqq.newfriend.config.a confBean = getConfBean();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("updateBindContactGuideState [%s, %s, %s, %s]", Boolean.valueOf(confBean.f253997a), Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(confBean.f253998b)));
        }
        if (confBean.f253997a && (!z16 || i3 >= confBean.f253998b)) {
            this.showContactGuideV2 = true;
            if (preferences.edit() == null) {
                QLog.e(TAG, 1, "updateBindContactGuideState is error! pref.edit() is null!");
                return;
            } else {
                preferences.edit().putBoolean("contact_guide_user_close", false).putInt("new_friend_show_count_after_user_close", 0).apply();
                return;
            }
        }
        if (z16) {
            int i16 = i3 + 1;
            if (preferences.edit() == null) {
                QLog.e(TAG, 1, "updateBindContactGuideState is error! pref.edit() is null!");
                return;
            }
            preferences.edit().putInt("new_friend_show_count_after_user_close", i16).apply();
        }
        this.showContactGuideV2 = false;
    }

    protected boolean updateEntity(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) entity)).booleanValue();
        }
        if (this.f253969em.isOpen()) {
            if (entity.getStatus() == 1000) {
                this.f253969em.persistOrReplace(entity);
                if (entity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                return this.f253969em.update(entity);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateEntity em closed e=" + entity.getTableName());
        }
        return false;
    }

    public void updateOrInsertSysSuspiciousMsg(SysSuspiciousMsg sysSuspiciousMsg) {
        EntityManager entityManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) sysSuspiciousMsg);
            return;
        }
        if (sysSuspiciousMsg != null && (entityManager = this.f253969em) != null && entityManager.isOpen()) {
            this.f253969em.persistOrReplace(sysSuspiciousMsg);
            this.mSuspiciousMsgMap.put(Long.valueOf(sysSuspiciousMsg.uin), sysSuspiciousMsg);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "updateOrInsertSysSuspiciousMsg " + sysSuspiciousMsg.uin + " " + sysSuspiciousMsg.time);
            }
        }
    }

    @Override // com.tencent.mobileqq.newfriend.api.INewFriendService
    public void updateSuspiciousMsgListFromServer(ArrayList<SysSuspiciousMsg> arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, arrayList, Boolean.valueOf(z16));
            return;
        }
        if (arrayList != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "updateSuspiciousMsgListFromServer " + z16 + " " + arrayList.size() + " " + arrayList.toString());
            }
            List<SysSuspiciousMsg> allSysSuspiciousMsg = getAllSysSuspiciousMsg();
            if (allSysSuspiciousMsg != null) {
                int size = arrayList.size();
                if (size == 0 && z16) {
                    clearAllSysSuspiciousMsg();
                } else if (size > 0) {
                    Collections.sort(arrayList, this.mSysSuspiciousMsgComparator);
                    SysSuspiciousMsg sysSuspiciousMsg = arrayList.get(0);
                    SysSuspiciousMsg sysSuspiciousMsg2 = arrayList.get(arrayList.size() - 1);
                    for (SysSuspiciousMsg sysSuspiciousMsg3 : allSysSuspiciousMsg) {
                        if (!z16) {
                            long j3 = sysSuspiciousMsg3.time;
                            if (j3 <= sysSuspiciousMsg.time && j3 >= sysSuspiciousMsg2.time) {
                                deleteSysSuspiciousMsg(sysSuspiciousMsg3.uin);
                            }
                        } else if (sysSuspiciousMsg3.time <= sysSuspiciousMsg.time) {
                            deleteSysSuspiciousMsg(sysSuspiciousMsg3.uin);
                        }
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "updateSuspiciousMsgListFromServer local empty");
            }
            Iterator<SysSuspiciousMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                updateOrInsertSysSuspiciousMsg(it.next());
            }
        }
    }

    public synchronized void loadNewFriendMsg(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        ArrayList<i> arrayList = new ArrayList<>();
        ArrayList<QIMFollwerAdd> qIMFollwerAddList = getQIMFollwerAddList();
        if (i3 != 23) {
            z17 = false;
        }
        ArrayList<i> arrayList2 = new ArrayList<>();
        ArrayList<i> arrayList3 = new ArrayList<>();
        StringBuilder sb5 = new StringBuilder(256);
        if (QLog.isColorLevel()) {
            sb5.append("loadNewFriendMsg");
        }
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.mApp.getRuntimeService(IPhoneContactService.class, "");
        this.mHasReadContactPermission = PermissionChecker.h().f();
        loadGuideMessage(arrayList, iPhoneContactService);
        int loadSystemMsg = loadSystemMsg(z16, sb5, arrayList2, 0);
        loadQIMMsg(qIMFollwerAddList, arrayList2);
        ArrayList<MayKnowRecommend> arrayList4 = new ArrayList<>();
        boolean shouldShowMayKnowInNewFriend = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).shouldShowMayKnowInNewFriend(this.mApp);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadNewFriendMsg mHasReadContactPermission = " + this.mHasReadContactPermission + ",needAddContactMsg =" + z17);
        }
        loadLimitCountNewFriendMsg(arrayList, arrayList2, loadSystemMsg, shouldShowMayKnowInNewFriend, (ArrayList<Entity>) null, ((INewFriendVerificationService) this.mApp.getRuntimeService(INewFriendVerificationService.class, "")).getEntranceType());
        loadMsgAccordingToTabAndMayKnow(arrayList, z17, arrayList3, shouldShowMayKnowInNewFriend);
        loadRecommendAndEducation(arrayList, arrayList3, sb5, arrayList4, shouldShowMayKnowInNewFriend);
        logLoadMsgSizeAndUnReadMsgCountInCache(arrayList);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102145", false)) {
            Collection synchronizedCollection = Collections.synchronizedCollection(this.mMixedMessages);
            synchronizedCollection.clear();
            synchronizedCollection.addAll(arrayList);
        } else {
            this.mMixedMessages = arrayList;
        }
        setMixedMessagesReaded();
    }

    private void loadLimitCountNewFriendMsg(ArrayList<i> arrayList, ArrayList<i> arrayList2, int i3, boolean z16, ArrayList<Entity> arrayList3, int i16) {
        if (arrayList2.size() > 0) {
            Collections.sort(arrayList2, this.mComparator);
            com.tencent.mobileqq.newfriend.data.b bVar = new com.tencent.mobileqq.newfriend.data.b();
            bVar.f254016a = HardCodeUtil.qqStr(R.string.cim);
            int i17 = 0;
            bVar.f254017b = i16 == 3;
            bVar.f254018c = ((INewFriendVerificationService) this.mApp.getRuntimeService(INewFriendVerificationService.class, "")).isShowRedPointAtNewFriendBanner();
            arrayList.add(new l(bVar));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "loadNewFriendMsg|mLastSysMsgTotalCount = " + this.mLastSysMsgTotalCount + ",notifyListSize = " + arrayList2.size() + ", mSysMsgShouldAddMoreInfo = " + this.mSysMsgShouldAddMoreInfo);
            }
            if ((this.mHasReadContactPermission && arrayList3 != null && arrayList3.size() > 0) || z16) {
                if (this.mLastSysMsgTotalCount != arrayList2.size()) {
                    loadWhenNotifyListSizeNotEqTotal(arrayList, arrayList2);
                } else {
                    while (i17 < this.mSysMsgShowCount) {
                        arrayList.add(arrayList2.get(i17));
                        i17++;
                    }
                    if (this.mSysMsgShouldAddMoreInfo) {
                        createNewFriendMoroInfo(arrayList);
                    }
                }
                this.mLastSysMsgTotalCount = arrayList2.size();
                return;
            }
            if (arrayList2.size() > 100) {
                while (i17 < 100) {
                    arrayList.add(arrayList2.get(i17));
                    i17++;
                }
                createNewFriendMoroInfo(arrayList);
                return;
            }
            arrayList.addAll(arrayList2);
            if ((i3 % 20 != 0 || ((INewFriendApi) QRoute.api(INewFriendApi.class)).isHasNoMoreMsg(this.mApp)) && (i3 <= 20 || ((INewFriendApi) QRoute.api(INewFriendApi.class)).getSysMsgOverValue(this.mApp))) {
                return;
            }
            createNewFriendMoroInfo(arrayList);
            return;
        }
        arrayList.add(new m());
    }

    public static void logMsg(String str, List<? extends MessageRecord> list) {
    }
}
