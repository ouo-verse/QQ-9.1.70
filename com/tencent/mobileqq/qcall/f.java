package com.tencent.mobileqq.qcall;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.utils.ak;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.util.aw;
import com.tencent.mobileqq.utils.bt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f extends Observable implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f261563d;

    /* renamed from: e, reason: collision with root package name */
    private ar f261564e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.discussion.observer.a f261565f;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends ar {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
            } else {
                f.this.h(String.valueOf(obj));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends com.tencent.mobileqq.discussion.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void r(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else {
                f.this.j(str, 3000);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        protected int f261568a;

        /* renamed from: b, reason: collision with root package name */
        protected int f261569b;

        /* renamed from: c, reason: collision with root package name */
        protected String f261570c;

        /* renamed from: d, reason: collision with root package name */
        protected String f261571d;

        /* renamed from: e, reason: collision with root package name */
        protected int f261572e;

        /* renamed from: f, reason: collision with root package name */
        protected QQAppInterface f261573f;

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006b, code lost:
        
            if (com.tencent.mobileqq.utils.c.g(r20.msgtype) != false) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        c(QQAppInterface qQAppInterface, String str, int i3, int i16, Message message) {
            boolean z16;
            f fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, str, Integer.valueOf(i3), Integer.valueOf(i16), message);
                return;
            }
            this.f261568a = 0;
            this.f261570c = null;
            this.f261569b = i16;
            this.f261571d = str;
            this.f261572e = i3;
            this.f261573f = qQAppInterface;
            try {
                fVar = (f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
            } catch (Exception e16) {
                e = e16;
                z16 = false;
            }
            if (fVar != null) {
                int r16 = fVar.r(str, i3);
                this.f261568a = r16;
                if (r16 > 0) {
                    if (message != null) {
                        if (!com.tencent.mobileqq.utils.c.i(message.msgtype)) {
                        }
                        z16 = true;
                        if (!z16) {
                            try {
                                this.f261570c = HardCodeUtil.qqStr(R.string.q87);
                            } catch (Exception e17) {
                                e = e17;
                                QLog.w("fetchUnReadCount", 1, "CallUnreadCountInfo , Exception", e);
                                if (!QLog.isDevelopLevel()) {
                                }
                            }
                        }
                        if (!QLog.isDevelopLevel()) {
                            QLog.d("fetchUnReadCount", 4, String.format("CallUnreadCountInfo, isCallTabShow[%s], isConversationTabShow[%s], isInCallList[%s], uin[%s], type[%s], mUnreadMsgNum[%s], mMissCallCount[%s], mMsgExtroInfo[%s], isVideoMsg[%s]", Boolean.valueOf(qQAppInterface.isCallTabShow), Boolean.valueOf(qQAppInterface.isConversationTabShow), Boolean.valueOf(qQAppInterface.isInCallList), str, Integer.valueOf(i3), Integer.valueOf(this.f261569b), Integer.valueOf(this.f261568a), this.f261570c, Boolean.valueOf(z16)));
                            return;
                        }
                        return;
                    }
                    z16 = false;
                    if (!z16) {
                    }
                    if (!QLog.isDevelopLevel()) {
                    }
                }
            }
            z16 = false;
            if (!QLog.isDevelopLevel()) {
            }
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f261568a;
        }

        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f261570c;
        }
    }

    public f(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f261564e = new a();
        this.f261565f = new b();
        this.f261563d = qQAppInterface;
        qQAppInterface.addObserver(this.f261564e);
        qQAppInterface.addObserver(this.f261565f);
    }

    private long B(QQAppInterface qQAppInterface) {
        BaseApplication app = qQAppInterface.getApp();
        return app.getSharedPreferences("voice_tab_time", 0).getLong(qQAppInterface.getCurrentAccountUin(), 0L);
    }

    private void H(int i3) {
        setChanged();
        notifyObservers(Integer.valueOf(i3));
        if (z().n()) {
            setChanged();
            notifyObservers(Boolean.TRUE);
        }
    }

    private void I(QCallRecent qCallRecent, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, String.format("saveRecentCall[%s], [%s]", str, qCallRecent));
        }
        z().E(qCallRecent);
        if (ao.r(qCallRecent.type) && qCallRecent.state == 5) {
            H(1);
        } else {
            H(0);
        }
    }

    private void J(QCallRecent qCallRecent) {
        if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, "save " + qCallRecent);
        }
        z().G(qCallRecent);
        if (ao.r(qCallRecent.type) && qCallRecent.state == 5) {
            H(1);
        } else {
            H(0);
        }
    }

    public static boolean N(QQAppInterface qQAppInterface, String str, int i3) {
        f fVar = (f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (fVar != null && fVar.r(str, i3) > 0) {
            fVar.R(str, i3);
            return true;
        }
        return false;
    }

    private void e() {
        QQAppInterface qQAppInterface = this.f261563d;
        if (qQAppInterface != null) {
            qQAppInterface.getProxyManager().l().init();
        }
    }

    private boolean f(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, "checkIsRealMissed friendUin:" + str + ",uinType:" + i3);
        }
        List<QCallRecord> n3 = n(str, i3);
        boolean z16 = false;
        if (n3 != null && !n3.isEmpty()) {
            int i16 = 0;
            while (true) {
                if (i16 >= n3.size()) {
                    break;
                }
                QCallRecord qCallRecord = n3.get(i16);
                if (qCallRecord != null && qCallRecord.type == QCallRecord.TYPE_REALRECORD) {
                    if (qCallRecord.isMissCall() || qCallRecord.state == 1) {
                        z16 = true;
                    }
                } else {
                    i16++;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("QCallFacade", 2, "checkIsRealMissed ret:" + z16);
            }
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, "checkIsRealMissed CallRecord count 0");
        }
        return false;
    }

    public static c l(QQAppInterface qQAppInterface, String str, int i3, int i16, Message message) {
        return new c(qQAppInterface, str, i3, i16, message);
    }

    private QCallRecord o(MessageForVideo messageForVideo) {
        String str;
        String[] split;
        if (messageForVideo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QCallFacade", 2, "getMessageToCallRecord message is null");
            }
            return null;
        }
        QCallRecord qCallRecord = new QCallRecord();
        qCallRecord.friendUin = messageForVideo.frienduin;
        qCallRecord.time = messageForVideo.time;
        qCallRecord.uinType = messageForVideo.istroop;
        qCallRecord.senderuin = messageForVideo.senderuin;
        qCallRecord.issend = messageForVideo.issend;
        qCallRecord.uniseq = messageForVideo.uniseq;
        String str2 = messageForVideo.f203106msg;
        if (str2 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QCallFacade", 2, "getMessageToCallRecord message's msg is null");
            }
            return null;
        }
        String[] split2 = str2.split("\\|");
        if (split2 != null && split2.length > 3) {
            qCallRecord.isVideo = "1".equals(split2[3]) ? 1 : 0;
        } else {
            qCallRecord.isVideo = 1;
        }
        if (split2 != null && split2.length > 3) {
            str = split2[0].trim();
            try {
                qCallRecord.state = Integer.parseInt(split2[1]);
            } catch (Exception unused) {
                if (str2.length() > 0 && str2.charAt(0) == 22) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QCallFacade", 2, "getMessageToCallRecord java.lang.NumberFormatException: Invalid int: " + split2[1] + " msg is " + str2);
                    }
                } else {
                    qCallRecord.state = 5;
                    if (QLog.isColorLevel()) {
                        QLog.d("QCallFacade", 2, "getMessageToCallRecord java.lang.NumberFormatException: Invalid int: " + split2[1] + " msg byte " + aw.a(str2));
                    }
                }
            }
        } else {
            qCallRecord.state = 5;
            str = "";
        }
        int i3 = qCallRecord.state;
        if ((i3 == 0 || i3 == 2 || i3 == 24 || i3 == 46 || i3 == 47 || i3 == 48 || i3 == 57 || i3 == 9 || i3 == 15) && str != null && (split = str.split(" ")) != null) {
            if (split.length > 1) {
                qCallRecord.talkTime = split[1];
            } else if (split.length == 1) {
                int i16 = qCallRecord.state;
                if (2 != i16 && 24 != i16) {
                    if (i16 == 0) {
                        qCallRecord.state = 12;
                    }
                } else {
                    qCallRecord.state = 12;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, "getMessageToCallRecord:" + qCallRecord.toString());
        }
        return qCallRecord;
    }

    private QCallRecent p(MessageForVideo messageForVideo) {
        String str = messageForVideo.frienduin;
        long j3 = messageForVideo.time;
        QCallRecent l3 = z().l(str, messageForVideo.istroop);
        l3.uin = str;
        l3.type = messageForVideo.istroop;
        l3.sendFlag = messageForVideo.issend;
        l3.lastCallMsg = bt.l(this.f261563d.getApp(), messageForVideo.text);
        if (j3 > l3.lastCallTime) {
            l3.lastCallTime = j3;
            l3.isSystemCall = 0;
        }
        int i3 = l3.type;
        if (i3 == 1000 || i3 == 1020 || i3 == 1004) {
            l3.troopUin = messageForVideo.senderuin;
        }
        int i16 = l3.missedCallCount;
        l3.missedCallCount = x(messageForVideo.frienduin, messageForVideo.istroop);
        if (QLog.isDevelopLevel()) {
            QLog.d("fetchUnReadCount", 4, String.format("getMessageToRecentCall, uin[%s], type[%s], count[%s], src[%s]", messageForVideo.frienduin, Integer.valueOf(messageForVideo.istroop), Integer.valueOf(l3.missedCallCount), Integer.valueOf(i16)));
        }
        String str2 = messageForVideo.f203106msg;
        if (str2 != null) {
            String[] split = str2.split("\\|");
            if (split != null && split.length > 3) {
                l3.isVideo = "1".equals(split[3]) ? 1 : 0;
            } else {
                l3.isVideo = 1;
            }
        }
        l3.isLastCallRealMissed = f(messageForVideo.frienduin, messageForVideo.istroop);
        l3.callType = k(messageForVideo, l3.type);
        return l3;
    }

    public static int w(QQAppInterface qQAppInterface) {
        return 0;
    }

    private int x(String str, int i3) {
        List<QCallRecord> n3 = n(str, i3);
        if (n3 != null && !n3.isEmpty()) {
            int i16 = 0;
            for (int i17 = 0; i17 < n3.size(); i17++) {
                QCallRecord qCallRecord = n3.get(i17);
                if (qCallRecord != null && qCallRecord.type == QCallRecord.TYPE_REALRECORD) {
                    if (!qCallRecord.isMissCall()) {
                        break;
                    }
                    i16++;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("fetchUnReadCount", 2, String.format("getNewestMissCallCount, uin[%s], type[%s], count[%s]", str, Integer.valueOf(i3), Integer.valueOf(i16)));
            }
            return i16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("fetchUnReadCount", 2, String.format("getNewestMissCallCount count 0, uin[%s], type[%s]]", str, Integer.valueOf(i3)));
        }
        return 0;
    }

    public QCallRecent A(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (QCallRecent) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, i3);
        }
        return z().m(str, i3);
    }

    public void C(MessageForVideo messageForVideo, boolean z16) {
        QCallRecent m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, messageForVideo, Boolean.valueOf(z16));
            return;
        }
        if (messageForVideo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QCallFacade", 2, "insertCallRecord updateRecentMissedCallCount: msg is null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, "insertCallRecord updateRecentMissedCallCount:" + z16 + ", msg :" + messageForVideo.toString());
        }
        z().y(o(messageForVideo));
        if (z16 && (m3 = z().m(messageForVideo.frienduin, messageForVideo.istroop)) != null) {
            m3.missedCallCount = x(messageForVideo.frienduin, messageForVideo.istroop);
            if (QLog.isColorLevel()) {
                QLog.d("QCallFacade", 2, "insertCallRecord QCallRecent update MissCallCount" + m3.missedCallCount);
            }
            m3.isLastCallRealMissed = f(messageForVideo.frienduin, messageForVideo.istroop);
            I(m3, "when_insertCallRecord");
        }
        setChanged();
        notifyObservers(n(messageForVideo.frienduin, messageForVideo.istroop));
    }

    public void D(MessageForVideo messageForVideo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) messageForVideo);
            return;
        }
        messageForVideo.parse();
        QCallRecent p16 = p(messageForVideo);
        I(p16, "when_insertMessage");
        QQAppInterface qQAppInterface = this.f261563d;
        if (qQAppInterface != null) {
            String str = "1";
            if (p16 != null && p16.type == 3000) {
                if (!p16.isSend()) {
                    str = "0";
                }
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004067", "0X8004067", 0, 0, str, "", "", "");
            } else {
                if (!p16.isSend()) {
                    str = "0";
                }
                ReportController.o(qQAppInterface, "CliOper", "", "", "Msg_tab", "Call_history_count", 0, 0, str, "", "", "");
            }
            if (this.f261563d.mainActivityIsForeground) {
                QQAppInterface qQAppInterface2 = this.f261563d;
                if (qQAppInterface2.isConversationTabShow && qQAppInterface2.isInCallList) {
                    K(com.tencent.mobileqq.service.message.e.K0());
                }
            }
            this.f261563d.refreshMsgTabUnreadNum(true, 0);
            if (this.f261563d.isLogin()) {
                ((IAppBadgeService) this.f261563d.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
            }
        }
    }

    @Deprecated
    public void E(String str) {
        PhoneContact queryContactByCodeNumber;
        boolean z16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
            return;
        }
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f261563d.getRuntimeService(IPhoneContactService.class, "");
        FriendsManager friendsManager = (FriendsManager) this.f261563d.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Friends friends = null;
        if (iPhoneContactService == null) {
            queryContactByCodeNumber = null;
        } else {
            queryContactByCodeNumber = iPhoneContactService.queryContactByCodeNumber(str);
        }
        if (queryContactByCodeNumber != null) {
            boolean z17 = true;
            boolean z18 = !TextUtils.isEmpty(queryContactByCodeNumber.uin);
            int i3 = 0;
            if (z18 && !queryContactByCodeNumber.uin.equals("0")) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && friendsManager != null) {
                friends = friendsManager.v(queryContactByCodeNumber.uin);
            }
            if (friends == null || !friends.isFriend()) {
                z17 = false;
            }
            if (z17) {
                str2 = queryContactByCodeNumber.uin;
            } else if (z18) {
                str2 = queryContactByCodeNumber.mobileCode;
                i3 = 1006;
            } else {
                str2 = queryContactByCodeNumber.mobileNo;
                i3 = AppConstants.VALUE.UIN_TYPE_UNBIND_PHONE_CONTACT;
            }
            F(str2, i3, queryContactByCodeNumber.contactID, com.tencent.mobileqq.service.message.e.K0(), str);
        }
    }

    @Deprecated
    public void F(String str, int i3, int i16, long j3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), str2);
            return;
        }
        QCallProxy z16 = z();
        QCallRecord qCallRecord = new QCallRecord();
        qCallRecord.uinType = i3;
        qCallRecord.state = 58;
        qCallRecord.contactId = i16;
        qCallRecord.friendUin = str;
        qCallRecord.time = j3;
        z16.y(qCallRecord);
        QCallRecent l3 = z16.l(str, i3);
        l3.uin = str;
        l3.type = i3;
        if (j3 > l3.lastCallTime) {
            l3.lastCallTime = j3;
        }
        l3.contactId = i16;
        l3.isSystemCall = 1;
        l3.sendFlag = 1;
        l3.phoneNumber = str2;
        z16.E(l3);
        notifyObservers(n(str, i3));
        setChanged();
    }

    public void K(final long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, j3);
        } else if (ak.e("qav_qcall_anr_fix_control", true)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qcall.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.G(j3);
                }
            }, 16, null, true);
        } else {
            G(j3);
        }
    }

    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void G(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, j3);
            return;
        }
        QQAppInterface qQAppInterface = this.f261563d;
        if (qQAppInterface == null) {
            return;
        }
        BaseApplication app = qQAppInterface.getApp();
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        if (app != null && !TextUtils.isEmpty(currentAccountUin)) {
            SharedPreferences sharedPreferences = app.getSharedPreferences("voice_tab_time", 0);
            if (sharedPreferences == null) {
                QLog.e("QCallFacade", 1, "sp is null?!");
                return;
            }
            sharedPreferences.edit().putLong(currentAccountUin, j3).commit();
            if (QLog.isColorLevel()) {
                QLog.d("fetchUnReadCount", 2, String.format("\u8bbe\u7f6esaveVoiceTabTime, time[%s]", Long.valueOf(j3)));
                return;
            }
            return;
        }
        QLog.e("QCallFacade", 1, "Context or uin empty!");
    }

    public void M(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            z().H(z16);
        }
    }

    public void O(long j3, long j16, boolean z16, long j17, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), Long.valueOf(j17), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, "updateDissCall-->discussid=" + j3 + " friendUin=" + j16 + " b=" + z16 + " time=" + j17 + " isSend=" + z17);
        }
        if (j3 != 0 && j16 != 0 && ((n) this.f261563d.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(String.valueOf(j3)) != null && this.f261563d.getCurrentAccountUin().equals(String.valueOf(j16))) {
            QCallRecent l3 = z().l(String.valueOf(j3), 3000);
            l3.lastCallTime = com.tencent.mobileqq.service.message.e.K0();
            if (z16) {
                l3.state = 1;
            } else {
                l3.state = 3;
                l3.time = j17;
                if (j17 > 0) {
                    QCallRecord qCallRecord = new QCallRecord();
                    qCallRecord.friendUin = String.valueOf(j3);
                    qCallRecord.isVideo = 0;
                    qCallRecord.time = com.tencent.mobileqq.service.message.e.K0();
                    qCallRecord.talkTime = String.valueOf(j17);
                    qCallRecord.type = QCallRecord.TYPE_REALRECORD;
                    qCallRecord.uinType = 3000;
                    if (z17) {
                        qCallRecord.state = 4;
                        qCallRecord.issend = 1;
                    } else {
                        qCallRecord.state = 3;
                        qCallRecord.issend = 0;
                    }
                    z().y(qCallRecord);
                } else {
                    QCallRecord qCallRecord2 = new QCallRecord();
                    qCallRecord2.friendUin = String.valueOf(j3);
                    qCallRecord2.issend = 1;
                    qCallRecord2.isVideo = 0;
                    qCallRecord2.time = com.tencent.mobileqq.service.message.e.K0();
                    qCallRecord2.type = QCallRecord.TYPE_REALRECORD;
                    qCallRecord2.state = 4;
                    qCallRecord2.uinType = 3000;
                    z().y(qCallRecord2);
                }
            }
            I(l3, "when_updateDissCall");
        }
    }

    public void P(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            Q(str, i3, 0, 0, null, i16);
        }
    }

    public void Q(String str, int i3, int i16, int i17, String str2, int i18) {
        QQAppInterface qQAppInterface;
        FriendsManager friendsManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str2, Integer.valueOf(i18));
            return;
        }
        QLog.d("QCallFacade", 1, String.format("updateDoubleCallStatus, peerUin[%s], uinType[%s], extraType[%s], bindType[%s], bindId[%s], status[%s]", str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str2, Integer.valueOf(i18)));
        if (i3 == 1011 || i3 == -1 || (qQAppInterface = this.f261563d) == null) {
            return;
        }
        if ((i3 == 0 && (friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)) != null && !friendsManager.c0(str)) || str == null) {
            return;
        }
        if (i3 == 3000 && ((n) this.f261563d.getManager(QQManagerFactory.DISCUSSION_MANAGER)).h(str) == null) {
            return;
        }
        QCallRecent l3 = z().l(str, i3);
        if (i18 == 6 || i18 == 5 || l3.isMissedCall()) {
            l3.lastCallTime = com.tencent.mobileqq.service.message.e.K0();
        }
        if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, "updateDoubleCallStatus lastCallTime = " + l3.lastCallTime);
        }
        l3.state = i18;
        l3.extraType = i16;
        l3.bindId = str2;
        l3.bindType = i17;
        if (TextUtils.isEmpty(str2)) {
            l3.callType = 1;
        }
        if (i18 == 0) {
            I(l3, "when_updateDoubleCallStatus");
        } else {
            J(l3);
        }
    }

    public void R(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
            return;
        }
        QCallRecent m3 = z().m(str, i3);
        if (m3 == null) {
            return;
        }
        long j3 = m3.readTime;
        m3.readTime = com.tencent.mobileqq.service.message.e.K0();
        if (QLog.isDevelopLevel()) {
            QLog.d("fetchUnReadCount", 4, String.format("updateQCallRecentReadTime, uin[%s], type[%s], readTime[%s], src[%s]", str, Integer.valueOf(i3), Long.valueOf(m3.readTime), Long.valueOf(j3)));
        }
        I(m3, "when_updateQCallRecentReadTime");
    }

    public void b(int i3, String str, String str2, String str3, int i16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("QCallFacade", 2, String.format("addMissCallMsg, uinType[%s], discussId[%s], peerUin[%s], senderUin[%s]", Integer.valueOf(i3), str, str2, str3));
        }
        if (this.f261563d != null && str != null && str2 != null) {
            try {
                j3 = Long.parseLong(str);
            } catch (Throwable unused) {
                j3 = 0;
            }
            if (i3 == 3000) {
                i17 = 2;
            } else if (i3 == 1 || i3 != 0) {
                i17 = 1;
            }
            QCallRecord qCallRecord = new QCallRecord();
            qCallRecord.friendUin = str;
            qCallRecord.issend = 0;
            qCallRecord.isVideo = 0;
            qCallRecord.time = com.tencent.mobileqq.service.message.e.K0();
            qCallRecord.type = QCallRecord.TYPE_REALRECORD;
            qCallRecord.state = i16;
            qCallRecord.uinType = i3;
            z().y(qCallRecord);
            QCallRecent l3 = z().l(str, i3);
            l3.uin = str;
            l3.lastCallTime = com.tencent.mobileqq.service.message.e.K0();
            l3.type = i3;
            l3.sendFlag = 0;
            l3.troopUin = str;
            l3.memberCount = this.f261563d.getAVNotifyCenter().y(i17, j3);
            l3.state = i16;
            l3.missedCallCount = x(str, i3);
            l3.senderUin = str3;
            l3.isLastCallRealMissed = f(str, i3);
            l3.isSystemCall = 0;
            I(l3, "when_addMissCallMsg");
            if (this.f261563d.isLogin()) {
                ((IAppBadgeService) this.f261563d.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
            }
        }
    }

    public void c(int i3, long j3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Long.valueOf(j3), str, str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("QCallFacade", 2, String.format("addQCallRecent, issend[%s], discussId[%s], senderUin[%s] , pstnUserInfo[%s]", Integer.valueOf(i3), Long.valueOf(j3), str, str2));
        }
        QCallRecent l3 = z().l(String.valueOf(j3), 3000);
        l3.uin = String.valueOf(j3);
        l3.lastCallTime = com.tencent.mobileqq.service.message.e.K0();
        l3.type = 3000;
        l3.sendFlag = i3;
        l3.troopUin = String.valueOf(j3);
        l3.memberCount = this.f261563d.getAVNotifyCenter().y(2, j3);
        l3.missedCallCount = x(String.valueOf(j3), 3000);
        if (l3.state != 1) {
            if (i3 == 1) {
                l3.state = 4;
            } else {
                l3.state = 0;
            }
        }
        l3.pstnInfo = str2;
        l3.senderUin = str;
        l3.isLastCallRealMissed = f(String.valueOf(j3), 3000);
        l3.isSystemCall = 0;
        I(l3, "when_addQCallRecent");
    }

    public void d(String str, int i3, String str2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16));
        } else {
            z().g(str, i3, str2, i16);
        }
    }

    public void g(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, "clearAllRecord friendUin:" + str + ",uinType:" + i3);
        }
        z().j(str, i3);
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        j(str, 0);
        j(str, 1000);
        j(str, 1020);
        j(str, 1004);
        j(str, 1024);
        j(str, 8);
    }

    public void i(QCallRecent qCallRecent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) qCallRecent);
        } else {
            if (qCallRecent == null) {
                return;
            }
            z().D(qCallRecent);
            H(-1);
        }
    }

    public void j(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, i3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QCallRecent m3 = z().m(str, i3);
        if (m3 != null) {
            i(m3);
        }
        g(str, i3);
        if (this.f261563d.isLogin()) {
            ((IAppBadgeService) this.f261563d.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
    }

    public int k(MessageRecord messageRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) messageRecord, i3)).intValue();
        }
        int i16 = messageRecord.msgtype;
        if (i16 == -2046) {
            return 2;
        }
        if (i16 != -2026 && !ao.r(i3)) {
            return 0;
        }
        return 1;
    }

    public int m(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, i3)).intValue();
        }
        QCallRecent m3 = z().m(str, i3);
        if (m3 != null) {
            return m3.state;
        }
        return 0;
    }

    public List<QCallRecord> n(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (List) iPatchRedirector.redirect((short) 31, (Object) this, (Object) str, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QCallFacade", 2, "getListRecord friendUin:" + str + ",uinType:" + i3);
        }
        return z().s(str, i3);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f261563d.removeObserver(this.f261564e);
        this.f261563d.removeObserver(this.f261565f);
        deleteObservers();
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        List<QCallRecent> A = z().A();
        int i3 = 0;
        if (A == null) {
            return 0;
        }
        long B = B(this.f261563d);
        for (QCallRecent qCallRecent : A) {
            long j3 = qCallRecent.readTime;
            if (j3 <= B) {
                j3 = B;
            }
            if (qCallRecent.lastCallTime > j3 && qCallRecent.isMissedCall()) {
                i3++;
            }
        }
        return i3;
    }

    public int r(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, i3)).intValue();
        }
        QCallRecent A = A(str, i3);
        if (A != null && A.isMissedCall()) {
            long B = B(this.f261563d);
            long j3 = A.readTime;
            if (j3 > B) {
                B = j3;
            }
            return u(A.uin, A.type, B);
        }
        return 0;
    }

    public ArrayList<MessageRecord> s() {
        MessageRecord d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ArrayList) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        List<QCallRecent> A = z().A();
        if (A == null) {
            return arrayList;
        }
        long B = B(this.f261563d);
        for (QCallRecent qCallRecent : A) {
            long j3 = qCallRecent.readTime;
            if (j3 <= B) {
                j3 = B;
            }
            if (qCallRecent.lastCallTime > j3 && qCallRecent.isMissedCall() && qCallRecent.uin != null) {
                List<QCallRecord> s16 = z().s(qCallRecent.uin, qCallRecent.type);
                for (int i3 = 0; i3 < s16.size(); i3++) {
                    QCallRecord qCallRecord = s16.get(i3);
                    if (qCallRecord.type != QCallRecord.TYPE_DATE) {
                        if (qCallRecord.isMissCall()) {
                            if (qCallRecord.time > j3) {
                                if (qCallRecent.type == 3000) {
                                    d16 = q.d(MessageRecord.MSG_TYPE_MULTI_VIDEO);
                                    d16.f203106msg = this.f261563d.getApp().getString(R.string.de9);
                                    d16.frienduin = qCallRecent.troopUin;
                                    d16.msgtype = MessageRecord.MSG_TYPE_MULTI_VIDEO;
                                    d16.senderuin = "";
                                } else {
                                    d16 = q.d(-2009);
                                    d16.frienduin = qCallRecent.uin;
                                    d16.msgtype = -2009;
                                    if (qCallRecord.isVideo()) {
                                        d16.f203106msg = this.f261563d.getApp().getString(R.string.de_);
                                    } else {
                                        d16.f203106msg = this.f261563d.getApp().getString(R.string.de8);
                                    }
                                    d16.senderuin = qCallRecord.senderuin;
                                }
                                d16.istroop = qCallRecent.type;
                                d16.time = qCallRecord.time;
                                arrayList.add(d16);
                            }
                        }
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "getMissCallMessageRecordList = list size" + arrayList.size());
        }
        return arrayList;
    }

    public int t(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this, (Object) str, i3)).intValue();
        }
        List<QCallRecent> A = z().A();
        if (A == null) {
            if (QLog.isColorLevel()) {
                QLog.d("fetchUnReadCount", 2, String.format("getMissCallRecordCount fail, friendUin[%s], uinType[%s]", str, Integer.valueOf(i3)));
            }
            return 0;
        }
        long B = B(this.f261563d);
        int i16 = 0;
        for (QCallRecent qCallRecent : A) {
            if (str.equals(qCallRecent.uin) && i3 == qCallRecent.type) {
                long j3 = qCallRecent.readTime;
                if (j3 <= B) {
                    j3 = B;
                }
                if (qCallRecent.lastCallTime > j3 && qCallRecent.isMissedCall() && qCallRecent.uin != null) {
                    List<QCallRecord> s16 = z().s(str, i3);
                    for (int i17 = 0; i17 < s16.size(); i17++) {
                        QCallRecord qCallRecord = s16.get(i17);
                        if (qCallRecord.type != QCallRecord.TYPE_DATE) {
                            if (qCallRecord.isMissCall()) {
                                if (qCallRecord.time > j3) {
                                    i16++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i16;
    }

    public int u(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, this, str, Integer.valueOf(i3), Long.valueOf(j3))).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("fetchUnReadCount", 2, String.format("getMissCallRecordCount, uin\u4e3a\u7a7a, uin[%s], type[%s], time[%s]", str, Integer.valueOf(i3), Long.valueOf(j3)));
            }
            return 0;
        }
        List<QCallRecord> s16 = z().s(str, i3);
        int i16 = 0;
        for (int i17 = 0; i17 < s16.size(); i17++) {
            try {
                QCallRecord qCallRecord = s16.get(i17);
                if (qCallRecord.type != QCallRecord.TYPE_DATE) {
                    if (!qCallRecord.isMissCall()) {
                        break;
                    }
                    if (qCallRecord.time > j3) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("fetchUnReadCount", 4, String.format("getMissCallRecordCount, uinType[%s], qcr.time[%s], time[%s], %s", Integer.valueOf(i3), Long.valueOf(qCallRecord.time), Long.valueOf(j3), qCallRecord));
                        }
                        i16++;
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QCallFacade", 2, "getMissCallRecordCount:" + e16);
                }
            }
        }
        return i16;
    }

    public int v() {
        RecentUserProxy m3;
        List<RecentUser> recentList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        if (this.f261563d == null || z().A() == null || (m3 = this.f261563d.getProxyManager().m()) == null || (recentList = m3.getRecentList(false)) == null || recentList.size() <= 0) {
            return 0;
        }
        int i3 = 0;
        for (RecentUser recentUser : recentList) {
            if (recentUser.getType() == 3000) {
                n nVar = (n) this.f261563d.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                DiscussionMemberInfo l3 = nVar.l(recentUser.uin, this.f261563d.getCurrentAccountUin());
                if (l3 != null && (l3.flag & 1) == 1) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("fetchUnReadCount", 4, String.format("getMissCallTotalCount, \u5f00\u542f\u4e86\u514d\u6253\u6270, disc[%s]", recentUser.uin));
                    }
                } else {
                    DiscussionInfo h16 = nVar.h(recentUser.uin);
                    if (h16 == null || h16.isUIControlFlag_Hidden_RecentUser() || h16.isHidden()) {
                        if (QLog.isColorLevel()) {
                            QLog.i("QCallFacade", 2, "getMissCallTotalCount, invalid discussion, uin[" + recentUser.uin + "], unread[" + r(recentUser.uin, recentUser.getType()) + "]");
                        }
                    }
                }
            }
            if (recentUser.getType() != 0 || (!FriendsStatusUtil.k(recentUser.uin, this.f261563d) && !com.tencent.mobileqq.app.nthiddenchat.b.h(recentUser.uin, recentUser.getType(), this.f261563d))) {
                ITempMsgBoxManager iTempMsgBoxManager = (ITempMsgBoxManager) this.f261563d.getRuntimeService(ITempMsgBoxManager.class, "");
                if (!iTempMsgBoxManager.isBelongToMsgBox(recentUser.uin, recentUser.getType()) && !iTempMsgBoxManager.isBelongToFilterBox(recentUser.uin, recentUser.getType()) && recentUser.getType() != 10007) {
                    i3 += r(recentUser.uin, recentUser.getType());
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("fetchUnReadCount", 4, String.format("getMissCallTotalCount, count[%s]", Integer.valueOf(i3)));
        }
        return i3;
    }

    public String y(String str, boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, this, str, Boolean.valueOf(z16));
        }
        List<QCallRecent> A = z().A();
        if (A == null) {
            return "";
        }
        long B = B(this.f261563d);
        QCallRecord qCallRecord = null;
        int i3 = 0;
        int i16 = 0;
        for (QCallRecent qCallRecent : A) {
            long j16 = qCallRecent.readTime;
            if (j16 <= B) {
                j16 = B;
            }
            if (qCallRecent.lastCallTime > j16 && qCallRecent.isMissedCall()) {
                i16++;
                if (qCallRecent.uin != null) {
                    List<QCallRecord> s16 = z().s(qCallRecent.uin, qCallRecent.type);
                    int i17 = 0;
                    while (i17 < s16.size()) {
                        QCallRecord qCallRecord2 = s16.get(i17);
                        if (qCallRecord2.type == QCallRecord.TYPE_DATE) {
                            j3 = B;
                        } else {
                            if (!qCallRecord2.isMissCall()) {
                                break;
                            }
                            j3 = B;
                            if (qCallRecord2.time > j16) {
                                if (i3 == 0) {
                                    qCallRecord = s16.get(i17);
                                }
                                i3++;
                            }
                        }
                        i17++;
                        B = j3;
                    }
                }
            }
            B = B;
        }
        StringBuilder sb5 = new StringBuilder();
        if (i3 != 1 && i16 != 1) {
            sb5.append(this.f261563d.getApp().getString(R.string.f171226dc1, "" + i16, "" + i3));
        } else if (z16) {
            if (str != null) {
                sb5.append(str);
                sb5.append(this.f261563d.getApp().getString(R.string.dcy));
            }
        } else if (qCallRecord != null && qCallRecord.isVideo()) {
            sb5.append(this.f261563d.getApp().getString(R.string.dm6));
        } else {
            sb5.append(this.f261563d.getApp().getString(R.string.d9_));
        }
        return sb5.toString();
    }

    public QCallProxy z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QCallProxy) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        e();
        QQAppInterface qQAppInterface = this.f261563d;
        if (qQAppInterface != null) {
            return qQAppInterface.getProxyManager().l();
        }
        return null;
    }
}
