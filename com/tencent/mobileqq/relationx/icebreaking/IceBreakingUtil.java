package com.tencent.mobileqq.relationx.icebreaking;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.portal.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class IceBreakingUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static HashMap<Integer, Integer> f280785a;

    /* renamed from: b, reason: collision with root package name */
    static int[] f280786b;

    /* renamed from: c, reason: collision with root package name */
    static int[] f280787c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f280793a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f280794b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f280795c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Contact f280796d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f280797e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f280798f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ IceBreakingMng f280799g;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        class C8500a implements IMsgOperateCallback {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.qqnt.ntrelation.otherinfo.bean.a f280800a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f280801b;

            C8500a(com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar, long j3) {
                this.f280800a = aVar;
                this.f280801b = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, aVar, Long.valueOf(j3));
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public void onResult(int i3, String str, ArrayList<MsgRecord> arrayList) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, arrayList);
                    return;
                }
                if (i3 == 0 && arrayList != null && arrayList.size() == 1) {
                    long msgTime = arrayList.get(0).getMsgTime() * 1000;
                    if (msgTime > this.f280800a.A()) {
                        this.f280800a.l0(msgTime);
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (((float) Math.abs(this.f280801b - msgTime)) < a.this.f280795c * 8.64E7f) {
                        if (z16) {
                            a aVar = a.this;
                            com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar2 = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(aVar.f280793a, aVar.f280794b);
                            aVar2.m();
                            aVar2.l0(msgTime);
                            ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singleton(aVar2)), "IceBreak.IceBreakingUtil", null);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak last msg within nDays=%.3f", Float.valueOf(a.this.f280795c)));
                        }
                    }
                }
            }
        }

        a(String str, String str2, float f16, Contact contact, boolean z16, QQAppInterface qQAppInterface, IceBreakingMng iceBreakingMng) {
            this.f280793a = str;
            this.f280794b = str2;
            this.f280795c = f16;
            this.f280796d = contact;
            this.f280797e = z16;
            this.f280798f = qQAppInterface;
            this.f280799g = iceBreakingMng;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Float.valueOf(f16), contact, Boolean.valueOf(z16), qQAppInterface, iceBreakingMng);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x017d  */
        /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
        @Override // hx3.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> eVar) {
            com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar;
            boolean z16;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                return;
            }
            boolean z18 = true;
            if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                aVar = eVar.b().get(0);
                z16 = false;
            } else {
                aVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.a();
                aVar.t(this.f280793a);
                aVar.u(this.f280794b);
                z16 = true;
            }
            if (aVar.F() > 0 && ((float) (System.currentTimeMillis() - aVar.F())) < this.f280795c * 8.64E7f) {
                if (QLog.isColorLevel()) {
                    QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak new make friends duration=%d nDay=%.3f", Long.valueOf(System.currentTimeMillis() - aVar.F()), Float.valueOf(this.f280795c)));
                    return;
                }
                return;
            }
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            if (((float) Math.abs(serverTimeMillis - aVar.z())) < this.f280795c * 8.64E7f) {
                if (QLog.isColorLevel()) {
                    QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak lastChatTs within nDays=%.3f", Float.valueOf(this.f280795c)));
                    return;
                }
                return;
            }
            ((IMsgService) QRoute.api(IMsgService.class)).getMsgs(this.f280796d, 0L, 1, true, new C8500a(aVar, serverTimeMillis));
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (!this.f280797e && (aVar.A() == 0 || Math.abs(aVar.A() - elapsedRealtime) > 86400000)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak reqServer=%b lastCheckTs=%d nDays=%.3f", Boolean.valueOf(z17), Long.valueOf(aVar.A()), Float.valueOf(this.f280795c)));
            }
            if (z17) {
                if (AppNetConnInfo.isNetSupport()) {
                    aVar.l0(elapsedRealtime);
                    ((FriendListHandler) this.f280798f.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).reqLastChatTime(this.f280794b, (int) Math.ceil(this.f280795c));
                    if (!z18) {
                        com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar2 = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(this.f280793a, this.f280794b);
                        aVar2.m();
                        aVar2.l0(elapsedRealtime);
                        ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singleton(aVar2)), "IceBreak.IceBreakingUtil", null);
                        return;
                    }
                    return;
                }
            } else if (this.f280797e) {
                if (QLog.isColorLevel()) {
                    QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak add_to_breaklist on forceLocal " + this.f280794b);
                }
                this.f280799g.m(this.f280794b, false);
            }
            z18 = z16;
            if (!z18) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74639);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        f280785a = hashMap;
        hashMap.put(0, 10021);
        f280785a.put(1, 0);
        f280785a.put(2, 1);
        f280785a.put(3, 3000);
        f280785a.put(4, 10014);
        f280785a.put(5, 1035);
        f280785a.put(30, 1035);
        f280785a.put(6, 9000);
        f280785a.put(7, 5000);
        f280785a.put(8, 7);
        f280785a.put(9, 10016);
        f280785a.put(100, 1000);
        f280785a.put(101, 1022);
        f280785a.put(103, 1008);
        f280785a.put(104, 1046);
        f280785a.put(105, 10007);
        f280785a.put(113, 10008);
        f280785a.put(115, 10019);
        f280785a.put(99, 10021);
        f280785a.put(102, 10021);
        f280786b = new int[]{MessageRecord.MSG_TYPE_TEXT_FRIEND_FEED, MessageRecord.MSG_TYPE_PL_NEWS, MessageRecord.MSG_TYPE_MEDAL_NEWS, MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED, MessageRecord.MSG_TYPE_CONFESS_NEWS, MessageRecord.MSG_TYPE_QQSTORY_LATEST_FEED, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, MessageRecord.MSG_TYPE_UNITE_GRAY_HISTORY_INVI, MessageRecord.MSG_TYPE_FRIEND_SYSTEM_STRUCT_MSG, MessageRecord.MSG_TYPE_SYSTEM_STRUCT_MSG, -2023, MessageRecord.MSG_TYPE_AIO_FOR_STORY_VIDEO, -7009, -7010, -7011, -7012, -7015};
        f280787c = new int[]{0, 1000, 1004, 1020, 1006, 1001, 1003, 1021, 1022};
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        if (com.tencent.mobileqq.troop.utils.k.l(r6, r8) == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(QQAppInterface qQAppInterface, int i3, String str) {
        boolean z16 = true;
        if (!s(i3) && !u(i3) && !w(i3) && !t(i3) && !v(i3)) {
            if (x(i3)) {
                boolean z17 = ((ITroopGagService) qQAppInterface.getRuntimeService(ITroopGagService.class, "")).getSelfGagInfo(str, true).f300235b;
                QLog.d("IceBreak.IceBreakingUtil", 1, "isValidTroopConv, isGag: ", Boolean.valueOf(z17));
                z16 = !z17;
            }
            z16 = false;
        } else {
            if (!Utils.G(str)) {
            }
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("IceBreak.IceBreakingUtil", 4, "[canShowIceBreak]: type: " + i3 + " uin: " + str + " canShow: " + z16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(QQAppInterface qQAppInterface, String str) {
        ((IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).p(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(QQAppInterface qQAppInterface, String str) {
        ((IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).q(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(QQAppInterface qQAppInterface, String str) {
        ((IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).r(str);
    }

    public static void k(QQAppInterface qQAppInterface, Contact contact, String str, boolean z16, int i3) {
        ThreadManagerV2.post(new Runnable(str, i3, qQAppInterface, contact, z16) { // from class: com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f280788d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f280789e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f280790f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Contact f280791h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ boolean f280792i;

            {
                this.f280788d = str;
                this.f280789e = i3;
                this.f280790f = qQAppInterface;
                this.f280791h = contact;
                this.f280792i = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), qQAppInterface, contact, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String str2 = this.f280788d;
                if (str2 != null && str2.length() > 4 && o.g(this.f280788d)) {
                    if (IceBreakingUtil.s(this.f280789e)) {
                        IceBreakingUtil.n(this.f280790f, this.f280791h, this.f280788d, this.f280792i);
                        return;
                    }
                    if (IceBreakingUtil.x(this.f280789e)) {
                        IceBreakingUtil.m(this.f280790f, this.f280788d);
                        return;
                    }
                    if (IceBreakingUtil.u(this.f280789e)) {
                        IceBreakingUtil.h(this.f280790f, this.f280788d);
                        return;
                    }
                    if (IceBreakingUtil.w(this.f280789e)) {
                        IceBreakingUtil.j(this.f280790f, this.f280788d);
                    } else if (IceBreakingUtil.t(this.f280789e)) {
                        IceBreakingUtil.l(this.f280790f, this.f280788d);
                    } else if (IceBreakingUtil.v(this.f280789e)) {
                        IceBreakingUtil.i(this.f280790f, this.f280788d);
                    }
                }
            }
        }, 5, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(QQAppInterface qQAppInterface, String str) {
        ((IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).o(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(QQAppInterface qQAppInterface, String str) {
        ((IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).n(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(QQAppInterface qQAppInterface, Contact contact, String str, boolean z16) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str) && str.length() >= 5) {
            if (QLog.isColorLevel()) {
                QLog.i("IceBreak.IceBreakingUtil", 2, String.format("checkNeedShowIceBreak uin=%s forceLocal=%b", str, Boolean.valueOf(z16)));
            }
            if (!((IStickerRecManager) qQAppInterface.getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen()) {
                if (QLog.isColorLevel()) {
                    QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak emotionRec switch is off");
                    return;
                }
                return;
            }
            IceBreakingMng iceBreakingMng = (IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
            if (!iceBreakingMng.K(false)) {
                if (QLog.isColorLevel()) {
                    QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak switch is off");
                    return;
                }
                return;
            }
            if (iceBreakingMng.D(str)) {
                QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak entered c2c");
                return;
            }
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "IceBreak.IceBreakingUtil")) {
                if (QLog.isColorLevel()) {
                    QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak not friend");
                    return;
                }
                return;
            } else {
                if (iceBreakingMng.I(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak already in break list");
                        return;
                    }
                    return;
                }
                ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherInfoWithUid(uidFromUin, "IceBreak.IceBreakingUtil", new a(uidFromUin, str, iceBreakingMng.x(), contact, z16, qQAppInterface, iceBreakingMng));
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("IceBreak.IceBreakingUtil", 2, "checkNeedShowIceBreak invalidate params uin: " + str);
        }
    }

    public static void o(QQAppInterface qQAppInterface, String str, int i3, MessageRecord messageRecord) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str) && messageRecord != null) {
            if (str.length() >= 5 && !s.j(messageRecord.msgtype) && !ad.M(messageRecord.msgtype)) {
                r(messageRecord.msgtype);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("IceBreak.IceBreakingUtil", 2, "clearIceBreakingFlag invalidate params uin: " + str);
        }
    }

    public static Integer p(Integer num) {
        if (!f280785a.containsKey(num)) {
            return 10021;
        }
        return f280785a.get(num);
    }

    public static int q(String str, Integer num) {
        if (str.isEmpty()) {
            return 6;
        }
        if (s(num.intValue())) {
            if (((IceBreakingMng) ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getManager(QQManagerFactory.ICE_BREAKING_MNG)).w(str, num.intValue()) != 1) {
                return 1;
            }
            return 2;
        }
        if (x(num.intValue())) {
            return 3;
        }
        if (u(num.intValue())) {
            return 4;
        }
        if (w(num.intValue())) {
            return 5;
        }
        if (!v(num.intValue())) {
            return 6;
        }
        return 8;
    }

    public static boolean r(int i3) {
        int i16 = 0;
        while (true) {
            int[] iArr = f280786b;
            if (i16 >= iArr.length) {
                return false;
            }
            if (i3 == iArr[i16]) {
                return true;
            }
            i16++;
        }
    }

    public static boolean s(int i3) {
        int i16 = 0;
        while (true) {
            int[] iArr = f280787c;
            if (i16 >= iArr.length) {
                return false;
            }
            if (i3 == iArr[i16]) {
                return true;
            }
            i16++;
        }
    }

    public static boolean t(int i3) {
        return p61.a.d(i3);
    }

    public static boolean u(int i3) {
        return ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).isExtendMatchChatType(i3);
    }

    public static boolean v(int i3) {
        if (1046 == i3) {
            return true;
        }
        return false;
    }

    public static boolean w(int i3) {
        return p61.a.f(i3);
    }

    public static boolean x(int i3) {
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    public static void y(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            IceBreakingMng iceBreakingMng = (IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(str));
            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "IceBreak.IceBreakingUtil")) {
                if (((IStickerRecManager) qQAppInterface.getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen()) {
                    if (iceBreakingMng.K(true)) {
                        if (iceBreakingMng.E(str)) {
                            iceBreakingMng.Q(str);
                            if (QLog.isColorLevel()) {
                                QLog.i("IceBreak.IceBreakingUtil", 2, "has matchChat show. uin: " + str);
                            }
                        } else if (iceBreakingMng.F(str)) {
                            iceBreakingMng.R(str);
                            if (QLog.isColorLevel()) {
                                QLog.i("IceBreak.IceBreakingUtil", 2, "has matchFriendChat show. uin: " + str);
                            }
                        } else {
                            iceBreakingMng.m(str, true);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("IceBreak.IceBreakingUtil", 2, "onAddFrdSuc uin: " + str);
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.i("IceBreak.IceBreakingUtil", 2, "onAddFrdSuc emotionRec switch is off");
                }
                IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
                com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(uidFromUin, str);
                aVar.m();
                aVar.p0(System.currentTimeMillis());
                iOtherInfoService.accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singleton(aVar)), "IceBreak.IceBreakingUtil_onAddFrdSuc", null);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("IceBreak.IceBreakingUtil", 2, "onAddFrdSuc not is friend");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("IceBreak.IceBreakingUtil", 2, "onAddFrdSuc invalidate params uin: " + str);
        }
    }

    public static void z(QQAppInterface qQAppInterface, String str) {
        IceBreakingMng iceBreakingMng = (IceBreakingMng) qQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG);
        boolean S = iceBreakingMng.S(str);
        if (iceBreakingMng.I(str) && QLog.isColorLevel()) {
            QLog.i("IceBreak.IceBreakingUtil", 2, String.format(Locale.getDefault(), "clearIceBreakingFlag onDelFrd uin: %s %b", str, Boolean.valueOf(S)));
        }
    }
}
