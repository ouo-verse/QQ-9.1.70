package com.tencent.mobileqq.mutualmark.oldlogic;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.intimate.e;
import com.tencent.mobileqq.activity.aio.intimate.header.h;
import com.tencent.mobileqq.activity.aio.intimate.header.n;
import com.tencent.mobileqq.activity.aio.x;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LoveZoneInfoHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.config.business.q;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.d;
import com.tencent.mobileqq.mutualmark.nt.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$RelationalChainChange;
import tencent.intimate_relation.intimate_relation$IntimateInfo;
import tencent.intimate_relation_ext.intimate_relation_ext$IntimateRelationExtMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class FriendIntimateRelationshipHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static boolean f252215a;

    /* renamed from: b, reason: collision with root package name */
    private static String f252216b;

    /* renamed from: c, reason: collision with root package name */
    static boolean f252217c;

    /* renamed from: d, reason: collision with root package name */
    static long f252218d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Comparator<String> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
            }
            if (str != null && str2 != null) {
                if (str.length() > str2.length()) {
                    return -1;
                }
                if (str.length() < str2.length()) {
                    return 1;
                }
                return 0;
            }
            if (str != null) {
                return -1;
            }
            if (str2 != null) {
                return 1;
            }
            return 0;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73303);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f252215a = false;
        f252216b = null;
        f252217c = false;
        f252218d = 0L;
    }

    public static String b(String str) {
        h hVar;
        Uri.Builder buildUpon = Uri.parse(FriendIntimateRelationshipConfProcessor.a().f202706f).buildUpon();
        buildUpon.appendQueryParameter("uin", str);
        String builder = buildUpon.toString();
        if (n.b() && (hVar = (h) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("intimate_aio_rightframe_game_8970_config")) != null) {
            builder = hVar.getBindIntimateJumpUrl().replace("{touin}", str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendIntimateRelationshipHelper", 2, "bindPageURL url:" + builder);
        }
        return builder;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x0114. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:162:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(AppInterface appInterface, submsgtype0xc7$RelationalChainChange submsgtype0xc7_relationalchainchange, PushMsg0x210C7Info pushMsg0x210C7Info, String str) {
        String str2;
        char c16;
        String str3;
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        AppInterface appInterface2;
        int i26;
        LoveZoneInfoHandler loveZoneInfoHandler;
        int i27;
        x.c cVar;
        x.c cVar2;
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar2;
        x.c cVar3;
        x.c cVar4;
        int i28;
        int i29;
        String str4;
        int i36;
        x.c cVar5;
        String str5;
        String str6;
        char c17;
        int i37;
        int i38;
        IntimateInfoHandler intimateInfoHandler;
        x.c cVar6;
        String str7;
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar3;
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar4;
        IIntimateInfoService iIntimateInfoService;
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar5;
        MessageForUniteGrayTip messageForUniteGrayTip;
        g gVar;
        List<String> list;
        String str8;
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar6;
        String str9;
        boolean z16;
        IIntimateInfoService iIntimateInfoService2;
        long j3;
        if (QLog.isColorLevel()) {
            QLog.d("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 from:" + str + "  app:" + appInterface + "  changeInfo:" + submsgtype0xc7_relationalchainchange + "  msginfo:" + pushMsg0x210C7Info);
        }
        if (appInterface != null && submsgtype0xc7_relationalchainchange != null && pushMsg0x210C7Info != null) {
            long j16 = pushMsg0x210C7Info.msgSeq;
            long j17 = pushMsg0x210C7Info.msgUid;
            x j18 = x.j(submsgtype0xc7_relationalchainchange, pushMsg0x210C7Info.onlinePush);
            if (TextUtils.equals(appInterface.getCurrentAccountUin(), j18.f180247a) && !TextUtils.isEmpty(j18.f180248b)) {
                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(j18.f180248b);
                FriendsManager friendsManager = (FriendsManager) appInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
                QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 from:" + str + " msginfo:" + pushMsg0x210C7Info + "changePushInfo:" + j18);
                if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "FriendIntimateRelationshipHelper")) {
                    return;
                }
                IIntimateInfoService iIntimateInfoService3 = (IIntimateInfoService) QRoute.api(IIntimateInfoService.class);
                com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar7 = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(uidFromUin, j18.f180248b);
                aVar7.q();
                com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(uidFromUin, "FriendIntimateRelationshipHelper");
                if (intimateSimpleInfoWithUid == null) {
                    intimateSimpleInfoWithUid = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a();
                    intimateSimpleInfoWithUid.A(uidFromUin);
                    intimateSimpleInfoWithUid.B(j18.f180248b);
                }
                IntimateInfoHandler intimateInfoHandler2 = (IntimateInfoHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
                String[] strArr = {null};
                com.tencent.mobileqq.mutualmark.elegantlogic.a.a(intimateSimpleInfoWithUid, j18);
                aVar7.z(intimateSimpleInfoWithUid.m());
                int i39 = j18.f180249c;
                String str10 = " intimate_level:";
                if (i39 == 1) {
                    str2 = "FriendIntimateRelationshipHelper";
                    c16 = 0;
                    str3 = " intimate_level:";
                    aVar = intimateSimpleInfoWithUid;
                    if (j18.f180252f != null && e.e(r0.f180260a)) {
                        aVar7.v(j18.f180252f.f180260a);
                        aVar7.t(0);
                        aVar7.u(j18.f180252f.a());
                        aVar7.r(Boolean.FALSE);
                        x.c.b bVar = j18.f180252f.f180261b;
                        if (bVar != null) {
                            long j19 = bVar.f180267c;
                            if (j19 > 0) {
                                aVar7.w(j19);
                            }
                        }
                        String d16 = com.tencent.mobileqq.mutualmark.oldlogic.a.d(appInterface.getApp(), 162);
                        strArr[0] = d16;
                        ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).accurateUpdateIntimateSimpleInfo(aVar7, str2, new hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>(appInterface, pushMsg0x210C7Info, friendsManager, d16, intimateInfoHandler2) { // from class: com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: b, reason: collision with root package name */
                            final /* synthetic */ AppInterface f252220b;

                            /* renamed from: c, reason: collision with root package name */
                            final /* synthetic */ PushMsg0x210C7Info f252221c;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ FriendsManager f252222d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ String f252223e;

                            /* renamed from: f, reason: collision with root package name */
                            final /* synthetic */ IntimateInfoHandler f252224f;

                            {
                                this.f252220b = appInterface;
                                this.f252221c = pushMsg0x210C7Info;
                                this.f252222d = friendsManager;
                                this.f252223e = d16;
                                this.f252224f = intimateInfoHandler2;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, this, x.this, appInterface, pushMsg0x210C7Info, friendsManager, d16, intimateInfoHandler2);
                                }
                            }

                            @Override // hx3.c
                            public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> eVar) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                                } else {
                                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper.1.1
                                        static IPatchRedirector $redirector_;

                                        {
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            LoveZoneInfoHandler loveZoneInfoHandler2;
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                                return;
                                            }
                                            if (FriendIntimateRelationshipHelper.m(x.this.f180247a)) {
                                                int b16 = d.b(x.this);
                                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                                if (FriendIntimateRelationshipHelper.r(anonymousClass1.f252220b, x.this.f180252f)) {
                                                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                                    d.c((QQAppInterface) anonymousClass12.f252220b, x.this, anonymousClass12.f252221c);
                                                } else {
                                                    AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                                    AppInterface appInterface3 = anonymousClass13.f252220b;
                                                    FriendsManager friendsManager2 = anonymousClass13.f252222d;
                                                    x xVar = x.this;
                                                    String str11 = xVar.f180248b;
                                                    String str12 = anonymousClass13.f252223e;
                                                    x.c cVar7 = xVar.f180252f;
                                                    b.g(appInterface3, friendsManager2, str11, str12, cVar7.f180260a, cVar7.a(), AnonymousClass1.this.f252221c, 1018, b16);
                                                }
                                                AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                                                anonymousClass14.f252224f.notifyUI(2, true, new Object[]{x.this.f180248b});
                                                f.f252196a.p(x.this.f180248b);
                                            }
                                            AnonymousClass1 anonymousClass15 = AnonymousClass1.this;
                                            if (x.this.f180252f.f180260a == 1 && (loveZoneInfoHandler2 = (LoveZoneInfoHandler) anonymousClass15.f252220b.getBusinessHandler(BusinessHandlerFactory.LOVE_STATE_CHANGE_HANDLER)) != null) {
                                                loveZoneInfoHandler2.E2(1, x.this.f180248b);
                                            }
                                        }
                                    });
                                }
                            }
                        });
                        QLog.i(str2, 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Add friendUin:" + j18.f180248b + " changePushInfo.now:" + j18.f180252f);
                    }
                } else if (i39 == 2) {
                    str2 = "FriendIntimateRelationshipHelper";
                    c16 = 0;
                    str3 = " intimate_level:";
                    aVar = intimateSimpleInfoWithUid;
                    x.c cVar7 = j18.f180251e;
                    if (cVar7 != null) {
                        int i46 = cVar7.f180260a;
                        i16 = cVar7.a();
                        i3 = i46;
                    } else {
                        i3 = 0;
                        i16 = 0;
                    }
                    if (i3 == 0 && (cVar = j18.f180252f) != null) {
                        i3 = cVar.f180260a;
                        i16 = cVar.a();
                    }
                    if (i3 == 0) {
                        i3 = aVar.j();
                        i16 = aVar.f();
                    }
                    int i47 = i3;
                    int i48 = i16;
                    if (e.e(i47)) {
                        aVar7.v(0);
                        aVar7.u(0);
                        aVar7.t(0);
                        aVar7.r(Boolean.FALSE);
                        if (i48 == 1) {
                            i19 = 164;
                        } else if (i48 == 2) {
                            i19 = 165;
                        } else {
                            i19 = 163;
                        }
                        iIntimateInfoService3.accurateUpdateIntimateSimpleInfo(aVar7, str2, (hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>) null);
                        if (m(j18.f180247a)) {
                            if (q(appInterface, submsgtype0xc7_relationalchainchange)) {
                                strArr[0] = com.tencent.mobileqq.mutualmark.oldlogic.a.d(appInterface.getApp(), i19);
                                if (r(appInterface, j18.f180252f)) {
                                    d.c((QQAppInterface) appInterface, j18, pushMsg0x210C7Info);
                                } else {
                                    i17 = i48;
                                    i27 = i47;
                                    b.g(appInterface, friendsManager, j18.f180248b, strArr[0], i47, 0, pushMsg0x210C7Info, 1019, 1);
                                    i26 = 1;
                                    intimateInfoHandler2.notifyUI(1, true, new Object[]{j18.f180248b, Boolean.TRUE});
                                    f.f252196a.p(j18.f180248b);
                                    appInterface2 = appInterface;
                                    ((com.tencent.mobileqq.friends.intimate.c) appInterface2.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER)).t(j18.f180248b);
                                    i18 = i27;
                                }
                            }
                            i17 = i48;
                            i27 = i47;
                            i26 = 1;
                            intimateInfoHandler2.notifyUI(1, true, new Object[]{j18.f180248b, Boolean.TRUE});
                            f.f252196a.p(j18.f180248b);
                            appInterface2 = appInterface;
                            ((com.tencent.mobileqq.friends.intimate.c) appInterface2.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER)).t(j18.f180248b);
                            i18 = i27;
                        } else {
                            i17 = i48;
                            appInterface2 = appInterface;
                            i26 = 1;
                            i18 = i47;
                        }
                        if (i18 == i26 && (loveZoneInfoHandler = (LoveZoneInfoHandler) appInterface2.getBusinessHandler(BusinessHandlerFactory.LOVE_STATE_CHANGE_HANDLER)) != null) {
                            loveZoneInfoHandler.E2(0, "0");
                        }
                    } else {
                        i17 = i48;
                        i18 = i47;
                    }
                    QLog.i(str2, 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Del intimate_type:" + i18 + str3 + i17 + " friendUin:" + j18.f180248b);
                } else if (i39 == 11000) {
                    str2 = "FriendIntimateRelationshipHelper";
                    c16 = 0;
                    str3 = " intimate_level:";
                    aVar = intimateSimpleInfoWithUid;
                    if (n() && m(j18.f180247a) && (cVar2 = j18.f180252f) != null) {
                        if (e.e(cVar2.f180260a)) {
                            aVar7.r(Boolean.FALSE);
                            ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).accurateUpdateIntimateSimpleInfo(aVar7, str2, new hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>(strArr, appInterface, j18, pushMsg0x210C7Info, friendsManager, intimateInfoHandler2) { // from class: com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper.3
                                static IPatchRedirector $redirector_;

                                /* renamed from: a, reason: collision with root package name */
                                final /* synthetic */ String[] f252225a;

                                /* renamed from: b, reason: collision with root package name */
                                final /* synthetic */ AppInterface f252226b;

                                /* renamed from: c, reason: collision with root package name */
                                final /* synthetic */ x f252227c;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ PushMsg0x210C7Info f252228d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ FriendsManager f252229e;

                                /* renamed from: f, reason: collision with root package name */
                                final /* synthetic */ IntimateInfoHandler f252230f;

                                {
                                    this.f252225a = strArr;
                                    this.f252226b = appInterface;
                                    this.f252227c = j18;
                                    this.f252228d = pushMsg0x210C7Info;
                                    this.f252229e = friendsManager;
                                    this.f252230f = intimateInfoHandler2;
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, this, strArr, appInterface, j18, pushMsg0x210C7Info, friendsManager, intimateInfoHandler2);
                                    }
                                }

                                @Override // hx3.c
                                public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> eVar) {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                                    } else {
                                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper.3.1
                                            static IPatchRedirector $redirector_;

                                            {
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                                                }
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                                    return;
                                                }
                                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                                anonymousClass3.f252225a[0] = com.tencent.mobileqq.mutualmark.oldlogic.a.d(anonymousClass3.f252226b.getApp(), 167);
                                                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                                if (FriendIntimateRelationshipHelper.r(anonymousClass32.f252226b, anonymousClass32.f252227c.f180252f)) {
                                                    AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                                                    d.c((QQAppInterface) anonymousClass33.f252226b, anonymousClass33.f252227c, anonymousClass33.f252228d);
                                                } else {
                                                    AnonymousClass3 anonymousClass34 = AnonymousClass3.this;
                                                    AppInterface appInterface3 = anonymousClass34.f252226b;
                                                    FriendsManager friendsManager2 = anonymousClass34.f252229e;
                                                    x xVar = anonymousClass34.f252227c;
                                                    String str11 = xVar.f180248b;
                                                    String str12 = anonymousClass34.f252225a[0];
                                                    x.c cVar8 = xVar.f180252f;
                                                    b.g(appInterface3, friendsManager2, str11, str12, cVar8.f180260a, cVar8.a(), AnonymousClass3.this.f252228d, 1018, 0);
                                                }
                                                AnonymousClass3 anonymousClass35 = AnonymousClass3.this;
                                                IntimateInfoHandler intimateInfoHandler3 = anonymousClass35.f252230f;
                                                x xVar2 = anonymousClass35.f252227c;
                                                intimateInfoHandler3.notifyUI(3, true, new Object[]{xVar2.f180248b, Integer.valueOf(xVar2.f180252f.f180260a), Integer.valueOf(AnonymousClass3.this.f252227c.f180252f.a()), Integer.valueOf(AnonymousClass3.this.f252227c.f180252f.a())});
                                                ((FriendListHandler) AnonymousClass3.this.f252226b.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(3, true, AnonymousClass3.this.f252227c.f180248b);
                                                f.f252196a.p(AnonymousClass3.this.f252227c.f180248b);
                                            }
                                        });
                                    }
                                }
                            });
                        }
                        QLog.i(str2, 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Icon_Light intimate_type:" + j18.f180252f.f180260a + str3 + j18.f180252f.a());
                    }
                } else if (i39 == 11001) {
                    str2 = "FriendIntimateRelationshipHelper";
                    aVar2 = aVar7;
                    c16 = 0;
                    str3 = " intimate_level:";
                    aVar = intimateSimpleInfoWithUid;
                    if (n() && m(j18.f180247a) && (cVar3 = j18.f180252f) != null) {
                        if (e.e(cVar3.f180260a)) {
                            aVar7 = aVar2;
                            aVar7.r(Boolean.FALSE);
                            ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).accurateUpdateIntimateSimpleInfo(aVar7, str2, new hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>(strArr, appInterface, j18, pushMsg0x210C7Info, friendsManager, intimateInfoHandler2) { // from class: com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper.4
                                static IPatchRedirector $redirector_;

                                /* renamed from: a, reason: collision with root package name */
                                final /* synthetic */ String[] f252231a;

                                /* renamed from: b, reason: collision with root package name */
                                final /* synthetic */ AppInterface f252232b;

                                /* renamed from: c, reason: collision with root package name */
                                final /* synthetic */ x f252233c;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ PushMsg0x210C7Info f252234d;

                                /* renamed from: e, reason: collision with root package name */
                                final /* synthetic */ FriendsManager f252235e;

                                /* renamed from: f, reason: collision with root package name */
                                final /* synthetic */ IntimateInfoHandler f252236f;

                                {
                                    this.f252231a = strArr;
                                    this.f252232b = appInterface;
                                    this.f252233c = j18;
                                    this.f252234d = pushMsg0x210C7Info;
                                    this.f252235e = friendsManager;
                                    this.f252236f = intimateInfoHandler2;
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, this, strArr, appInterface, j18, pushMsg0x210C7Info, friendsManager, intimateInfoHandler2);
                                    }
                                }

                                @Override // hx3.c
                                public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> eVar) {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                                    } else {
                                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper.4.1
                                            static IPatchRedirector $redirector_;

                                            {
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                                                }
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                                    return;
                                                }
                                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                                anonymousClass4.f252231a[0] = com.tencent.mobileqq.mutualmark.oldlogic.a.d(anonymousClass4.f252232b.getApp(), 166);
                                                AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                                                if (FriendIntimateRelationshipHelper.r(anonymousClass42.f252232b, anonymousClass42.f252233c.f180252f)) {
                                                    AnonymousClass4 anonymousClass43 = AnonymousClass4.this;
                                                    d.c((QQAppInterface) anonymousClass43.f252232b, anonymousClass43.f252233c, anonymousClass43.f252234d);
                                                } else {
                                                    AnonymousClass4 anonymousClass44 = AnonymousClass4.this;
                                                    AppInterface appInterface3 = anonymousClass44.f252232b;
                                                    FriendsManager friendsManager2 = anonymousClass44.f252235e;
                                                    x xVar = anonymousClass44.f252233c;
                                                    String str11 = xVar.f180248b;
                                                    String str12 = anonymousClass44.f252231a[0];
                                                    x.c cVar8 = xVar.f180252f;
                                                    b.g(appInterface3, friendsManager2, str11, str12, cVar8.f180260a, cVar8.a(), AnonymousClass4.this.f252234d, 1019, 0);
                                                }
                                                AnonymousClass4 anonymousClass45 = AnonymousClass4.this;
                                                IntimateInfoHandler intimateInfoHandler3 = anonymousClass45.f252236f;
                                                x xVar2 = anonymousClass45.f252233c;
                                                intimateInfoHandler3.notifyUI(3, true, new Object[]{xVar2.f180248b, Integer.valueOf(xVar2.f180252f.f180260a), Integer.valueOf(AnonymousClass4.this.f252233c.f180252f.a()), Integer.valueOf(AnonymousClass4.this.f252233c.f180252f.a())});
                                                ((FriendListHandler) AnonymousClass4.this.f252232b.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(3, true, AnonymousClass4.this.f252233c.f180248b);
                                                f.f252196a.p(AnonymousClass4.this.f252233c.f180248b);
                                            }
                                        });
                                    }
                                }
                            });
                        } else {
                            aVar7 = aVar2;
                        }
                        QLog.i(str2, 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Icon_Extinguish intimate_type:" + j18.f180252f.f180260a + str3 + j18.f180252f.a());
                    }
                    aVar7 = aVar2;
                } else {
                    int i49 = -1;
                    switch (i39) {
                        case 10003:
                            aVar = intimateSimpleInfoWithUid;
                            if (!n() || !m(j18.f180247a) || (cVar4 = j18.f180252f) == null || j18.f180251e == null) {
                                str2 = "FriendIntimateRelationshipHelper";
                                aVar2 = aVar7;
                                str3 = " intimate_level:";
                                c16 = 0;
                            } else {
                                x.c.b bVar2 = cVar4.f180261b;
                                if (bVar2 != null) {
                                    long j26 = bVar2.f180267c;
                                    if (j26 > 0) {
                                        aVar7.w(j26);
                                    }
                                }
                                int a16 = j18.f180252f.a();
                                int a17 = j18.f180251e.a();
                                if (e.e(j18.f180252f.f180260a) && a16 < a17) {
                                    if (a17 == 1) {
                                        int i56 = j18.f180252f.f180260a;
                                        if (i56 == 1) {
                                            i49 = 152;
                                        } else if (i56 == 2) {
                                            i49 = 160;
                                        } else if (i56 == 26) {
                                            i49 = 170;
                                        } else if (i56 == 3) {
                                            i49 = 156;
                                        }
                                    } else if (a17 == 2) {
                                        int i57 = j18.f180252f.f180260a;
                                        if (i57 == 1) {
                                            i49 = 153;
                                        } else if (i57 == 2) {
                                            i49 = 161;
                                        } else if (i57 == 26) {
                                            i49 = 171;
                                        } else if (i57 == 3) {
                                            i49 = 157;
                                        }
                                    }
                                    strArr[0] = com.tencent.mobileqq.mutualmark.oldlogic.a.d(appInterface.getApp(), i49);
                                    aVar7.v(j18.f180252f.f180260a);
                                    aVar7.u(a16);
                                    str2 = "FriendIntimateRelationshipHelper";
                                    iIntimateInfoService3.accurateUpdateIntimateSimpleInfo(aVar7, str2, (hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>) null);
                                    if (r(appInterface, j18.f180252f)) {
                                        d.c((QQAppInterface) appInterface, j18, pushMsg0x210C7Info);
                                        i28 = a17;
                                        i29 = a16;
                                        str4 = " intimate_level:";
                                        aVar2 = aVar7;
                                        i36 = 4;
                                        c16 = 0;
                                    } else {
                                        i29 = a16;
                                        i28 = a17;
                                        str4 = " intimate_level:";
                                        aVar2 = aVar7;
                                        c16 = 0;
                                        b.g(appInterface, friendsManager, j18.f180248b, strArr[0], j18.f180252f.f180260a, i29, pushMsg0x210C7Info, 1019, 0);
                                        i36 = 4;
                                    }
                                    Object[] objArr = new Object[i36];
                                    objArr[c16] = j18.f180248b;
                                    objArr[1] = Integer.valueOf(j18.f180252f.f180260a);
                                    objArr[2] = Integer.valueOf(i28);
                                    objArr[3] = Integer.valueOf(i29);
                                    intimateInfoHandler2.notifyUI(3, true, objArr);
                                    f.f252196a.p(j18.f180248b);
                                } else {
                                    i28 = a17;
                                    i29 = a16;
                                    str4 = " intimate_level:";
                                    aVar2 = aVar7;
                                    str2 = "FriendIntimateRelationshipHelper";
                                    c16 = 0;
                                }
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("decodeC2CMsgPkgSubMsgType0xc7 Type_Downgrade intimate_type:");
                                sb5.append(j18.f180252f.f180260a);
                                str3 = str4;
                                sb5.append(str3);
                                sb5.append(i29);
                                sb5.append(" old_intimate_level:");
                                sb5.append(i28);
                                QLog.i(str2, 1, sb5.toString());
                            }
                            aVar7 = aVar2;
                            break;
                        case 10004:
                            com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar8 = intimateSimpleInfoWithUid;
                            if (n() && m(j18.f180247a) && (cVar5 = j18.f180252f) != null && j18.f180251e != null) {
                                x.c.b bVar3 = cVar5.f180261b;
                                if (bVar3 != null) {
                                    long j27 = bVar3.f180267c;
                                    if (j27 > 0) {
                                        aVar7.w(j27);
                                    }
                                }
                                int a18 = j18.f180252f.a();
                                int a19 = j18.f180251e.a();
                                if (!e.e(j18.f180252f.f180260a) || a18 <= a19) {
                                    str5 = " old_intimate_level:";
                                    str6 = " intimate_level:";
                                    aVar = aVar8;
                                    c17 = 0;
                                } else {
                                    if (a18 == 1) {
                                        int i58 = j18.f180252f.f180260a;
                                        if (i58 == 1) {
                                            i37 = 150;
                                            strArr[0] = com.tencent.mobileqq.mutualmark.oldlogic.a.d(appInterface.getApp(), i37);
                                            aVar7.v(j18.f180252f.f180260a);
                                            aVar7.u(a18);
                                            iIntimateInfoService3.accurateUpdateIntimateSimpleInfo(aVar8, "FriendIntimateRelationshipHelper", (hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>) null);
                                            int b16 = d.b(j18);
                                            if (!r(appInterface, j18.f180252f)) {
                                                d.c((QQAppInterface) appInterface, j18, pushMsg0x210C7Info);
                                                str5 = " old_intimate_level:";
                                                str6 = " intimate_level:";
                                                intimateInfoHandler = intimateInfoHandler2;
                                                i38 = 4;
                                                aVar = aVar8;
                                            } else {
                                                i38 = 4;
                                                str6 = " intimate_level:";
                                                intimateInfoHandler = intimateInfoHandler2;
                                                str5 = " old_intimate_level:";
                                                aVar = aVar8;
                                                b.g(appInterface, friendsManager, j18.f180248b, strArr[0], j18.f180252f.f180260a, a18, pushMsg0x210C7Info, 1018, b16);
                                            }
                                            Object[] objArr2 = new Object[i38];
                                            c17 = 0;
                                            objArr2[0] = j18.f180248b;
                                            objArr2[1] = Integer.valueOf(j18.f180252f.f180260a);
                                            objArr2[2] = Integer.valueOf(a19);
                                            objArr2[3] = Integer.valueOf(a18);
                                            intimateInfoHandler.notifyUI(3, true, objArr2);
                                            f.f252196a.p(j18.f180248b);
                                        } else if (i58 == 2) {
                                            i49 = 158;
                                        } else if (i58 == 26) {
                                            i49 = 168;
                                        } else if (i58 == 3) {
                                            i49 = 154;
                                        }
                                    } else if (a18 == 2) {
                                        int i59 = j18.f180252f.f180260a;
                                        if (i59 == 1) {
                                            i49 = 151;
                                        } else if (i59 == 2) {
                                            i49 = 159;
                                        } else if (i59 == 26) {
                                            i49 = 169;
                                        } else if (i59 == 3) {
                                            i49 = 155;
                                        }
                                    }
                                    i37 = i49;
                                    strArr[0] = com.tencent.mobileqq.mutualmark.oldlogic.a.d(appInterface.getApp(), i37);
                                    aVar7.v(j18.f180252f.f180260a);
                                    aVar7.u(a18);
                                    iIntimateInfoService3.accurateUpdateIntimateSimpleInfo(aVar8, "FriendIntimateRelationshipHelper", (hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>) null);
                                    int b162 = d.b(j18);
                                    if (!r(appInterface, j18.f180252f)) {
                                    }
                                    Object[] objArr22 = new Object[i38];
                                    c17 = 0;
                                    objArr22[0] = j18.f180248b;
                                    objArr22[1] = Integer.valueOf(j18.f180252f.f180260a);
                                    objArr22[2] = Integer.valueOf(a19);
                                    objArr22[3] = Integer.valueOf(a18);
                                    intimateInfoHandler.notifyUI(3, true, objArr22);
                                    f.f252196a.p(j18.f180248b);
                                }
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("decodeC2CMsgPkgSubMsgType0xc7 Type_Upgrade intimate_type:");
                                sb6.append(j18.f180252f.f180260a);
                                String str11 = str6;
                                sb6.append(str11);
                                sb6.append(a18);
                                sb6.append(str5);
                                sb6.append(a19);
                                QLog.i("FriendIntimateRelationshipHelper", 1, sb6.toString());
                                str2 = "FriendIntimateRelationshipHelper";
                                aVar7 = aVar7;
                                str3 = str11;
                                c16 = c17;
                                break;
                            } else {
                                aVar = aVar8;
                                str2 = "FriendIntimateRelationshipHelper";
                                aVar7 = aVar7;
                                c16 = 0;
                                str3 = str10;
                                break;
                            }
                            break;
                        case 10005:
                            if (n() && m(j18.f180247a) && (cVar6 = j18.f180252f) != null) {
                                if (cVar6.f180260a == 0 || cVar6.f180261b == null) {
                                    str7 = " intimate_level:";
                                    aVar3 = aVar7;
                                    aVar4 = intimateSimpleInfoWithUid;
                                } else {
                                    if (r(appInterface, cVar6)) {
                                        d.c((QQAppInterface) appInterface, j18, pushMsg0x210C7Info);
                                    } else if (!TextUtils.isEmpty(j18.f180252f.f180261b.f180270f) && !com.tencent.mobileqq.mutualmark.g.k(appInterface)) {
                                        List<String> e16 = com.tencent.mobileqq.mutualmark.oldlogic.a.e(appInterface, j18.f180252f.f180261b.f180270f, ac.H(appInterface, j18.f180248b), friendsManager);
                                        List<String> c18 = com.tencent.mobileqq.mutualmark.oldlogic.a.c(appInterface, e16.get(0), j18.f180248b);
                                        String str12 = c18.get(0);
                                        e16.remove(0);
                                        c18.remove(0);
                                        String str13 = j18.f180248b;
                                        g gVar2 = new g(str13, str13, str12, 0, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, 1018, com.tencent.mobileqq.service.message.e.K0());
                                        if (c18.size() <= 0) {
                                            str7 = " intimate_level:";
                                            iIntimateInfoService = iIntimateInfoService3;
                                            aVar4 = intimateSimpleInfoWithUid;
                                        } else {
                                            aVar4 = intimateSimpleInfoWithUid;
                                            int i65 = 0;
                                            while (i65 < c18.size()) {
                                                Bundle bundle = new Bundle();
                                                List<String> list2 = c18;
                                                String str14 = c18.get(i65);
                                                String str15 = str10;
                                                if (!TextUtils.isEmpty(str14)) {
                                                    bundle.putString("image_resource", str14);
                                                    int lastIndexOf = str12.lastIndexOf(str14);
                                                    if (lastIndexOf >= 0) {
                                                        iIntimateInfoService2 = iIntimateInfoService3;
                                                        gVar2.b(lastIndexOf, lastIndexOf + str14.length(), bundle);
                                                    } else {
                                                        iIntimateInfoService2 = iIntimateInfoService3;
                                                    }
                                                    if (QLog.isColorLevel()) {
                                                        QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + str12 + "iconPos=" + lastIndexOf + "icon=" + str14 + "grayStr=" + str12);
                                                    }
                                                } else {
                                                    iIntimateInfoService2 = iIntimateInfoService3;
                                                }
                                                i65++;
                                                c18 = list2;
                                                str10 = str15;
                                                iIntimateInfoService3 = iIntimateInfoService2;
                                            }
                                            str7 = str10;
                                            iIntimateInfoService = iIntimateInfoService3;
                                        }
                                        if (e16.size() > 0) {
                                            Collections.sort(e16, new a());
                                            ArrayList arrayList = new ArrayList();
                                            int i66 = 0;
                                            while (i66 < e16.size()) {
                                                Bundle bundle2 = new Bundle();
                                                String str16 = e16.get(i66);
                                                if (!TextUtils.isEmpty(str16)) {
                                                    list = e16;
                                                    bundle2.putInt("key_action", 11);
                                                    bundle2.putString("key_action_DATA", str16);
                                                    int i67 = 0;
                                                    while (true) {
                                                        int indexOf = str12.indexOf(str16, i67);
                                                        if (indexOf < 0) {
                                                            str8 = str12;
                                                            str9 = str16;
                                                            aVar6 = aVar7;
                                                        } else {
                                                            i67 = str16.length() + indexOf;
                                                            Iterator it = arrayList.iterator();
                                                            while (true) {
                                                                if (it.hasNext()) {
                                                                    str9 = str16;
                                                                    Pair pair = (Pair) it.next();
                                                                    aVar6 = aVar7;
                                                                    if (indexOf >= ((Integer) pair.first).intValue() && indexOf < ((Integer) pair.second).intValue()) {
                                                                        z16 = true;
                                                                    } else {
                                                                        str16 = str9;
                                                                        aVar7 = aVar6;
                                                                    }
                                                                } else {
                                                                    str9 = str16;
                                                                    aVar6 = aVar7;
                                                                    z16 = false;
                                                                }
                                                            }
                                                            if (z16) {
                                                                str8 = str12;
                                                            } else {
                                                                str8 = str12;
                                                                arrayList.add(new Pair(Integer.valueOf(indexOf), Integer.valueOf(i67)));
                                                                if (indexOf >= 0) {
                                                                    gVar2.b(indexOf, i67, bundle2);
                                                                    if (QLog.isColorLevel()) {
                                                                        QLog.d("FriendIntimateRelationshipHelper", 2, "spanPos=" + indexOf + " fromIndex=" + i67);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (indexOf < 0) {
                                                            break;
                                                        }
                                                        str16 = str9;
                                                        str12 = str8;
                                                        aVar7 = aVar6;
                                                    }
                                                } else {
                                                    list = e16;
                                                    str8 = str12;
                                                    aVar6 = aVar7;
                                                }
                                                i66++;
                                                e16 = list;
                                                str12 = str8;
                                                aVar7 = aVar6;
                                            }
                                        }
                                        String str17 = str12;
                                        aVar5 = aVar7;
                                        MessageForUniteGrayTip messageForUniteGrayTip2 = new MessageForUniteGrayTip();
                                        messageForUniteGrayTip2.hasRead = 0;
                                        messageForUniteGrayTip2.initGrayTipMsg(appInterface, gVar2);
                                        StringBuilder sb7 = new StringBuilder(21);
                                        sb7.append(j16);
                                        sb7.append("_");
                                        sb7.append(j17);
                                        messageForUniteGrayTip2.tipParam.f213693p = sb7.toString();
                                        List<MessageRecord> msgList = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(j18.f180248b, 0);
                                        if (msgList != null && !msgList.isEmpty()) {
                                            MessageRecord messageRecord = msgList.get(msgList.size() - 1);
                                            if ((messageRecord instanceof MessageForUniteGrayTip) && (gVar = (messageForUniteGrayTip = (MessageForUniteGrayTip) messageRecord).tipParam) != null && messageForUniteGrayTip.subType == messageForUniteGrayTip2.subType && gVar.f213683f.equals(messageForUniteGrayTip2.tipParam.f213683f) && messageForUniteGrayTip2.tipParam.f213686i - messageForUniteGrayTip.tipParam.f213686i <= 1) {
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        if (!TextUtils.isEmpty(str17)) {
                                            com.tencent.mobileqq.graytip.f.a(appInterface, messageForUniteGrayTip2);
                                        }
                                        aVar3 = aVar5;
                                        aVar3.v(j18.f180252f.a());
                                        j3 = j18.f180252f.f180261b.f180267c;
                                        if (j3 > 0) {
                                            aVar3.w(j3);
                                        }
                                        iIntimateInfoService.accurateUpdateIntimateSimpleInfo(aVar3, "FriendIntimateRelationshipHelper", (hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>) null);
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(j18.f180248b);
                                        appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(102, true, arrayList2);
                                        f.f252196a.p(j18.f180248b);
                                    }
                                    str7 = " intimate_level:";
                                    iIntimateInfoService = iIntimateInfoService3;
                                    aVar5 = aVar7;
                                    aVar4 = intimateSimpleInfoWithUid;
                                    aVar3 = aVar5;
                                    aVar3.v(j18.f180252f.a());
                                    j3 = j18.f180252f.f180261b.f180267c;
                                    if (j3 > 0) {
                                    }
                                    iIntimateInfoService.accurateUpdateIntimateSimpleInfo(aVar3, "FriendIntimateRelationshipHelper", (hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>) null);
                                    ArrayList arrayList22 = new ArrayList();
                                    arrayList22.add(j18.f180248b);
                                    appInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(102, true, arrayList22);
                                    f.f252196a.p(j18.f180248b);
                                }
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append("decodeC2CMsgPkgSubMsgType0xc7 Type_Egalitarian_Soon intimate_type:");
                                sb8.append(j18.f180252f.f180260a);
                                str10 = str7;
                                sb8.append(str10);
                                sb8.append(j18.f180252f.a());
                                QLog.i("FriendIntimateRelationshipHelper", 1, sb8.toString());
                                str2 = "FriendIntimateRelationshipHelper";
                                aVar7 = aVar3;
                                aVar = aVar4;
                                c16 = 0;
                                str3 = str10;
                                break;
                            }
                            break;
                        default:
                            str2 = "FriendIntimateRelationshipHelper";
                            aVar = intimateSimpleInfoWithUid;
                            c16 = 0;
                            str3 = str10;
                            break;
                    }
                }
                QLog.i(str2, 1, "decodeC2CMsgPkgSubMsgType0xc7 changeType:" + j18.f180249c + " grayTips:" + strArr[c16] + " uin:" + aVar.n() + " isOpen:" + m(j18.f180247a) + " intimate_type:" + aVar7.j() + str3 + aVar7.f() + " intimate_chatDays:" + aVar7.e() + " isExtinguish:" + aVar7.o() + " last_intimate_chatTime:" + aVar7.k());
            }
        }
    }

    public static String d(int i3, int i16) {
        String str;
        q a16 = FriendIntimateRelationshipConfProcessor.a();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 26) {
                        str = a16.f202709h;
                    } else if (i16 == 0) {
                        str = a16.D;
                    } else if (i16 == 1) {
                        str = a16.E;
                    } else {
                        if (i16 == 2) {
                            str = a16.F;
                        }
                        str = "";
                    }
                } else if (i16 == 0) {
                    str = a16.G;
                } else if (i16 == 1) {
                    str = a16.H;
                } else {
                    if (i16 == 2) {
                        str = a16.I;
                    }
                    str = "";
                }
            } else if (i16 == 0) {
                str = a16.f202711i;
            } else if (i16 == 1) {
                str = a16.f202716m;
            } else {
                if (i16 == 2) {
                    str = a16.C;
                }
                str = "";
            }
        } else if (i16 == 0) {
            str = a16.J;
        } else if (i16 == 1) {
            str = a16.K;
        } else {
            if (i16 == 2) {
                str = a16.L;
            }
            str = "";
        }
        QLog.i("FriendIntimateRelationshipHelper", 1, "getAIOIntimateBG intimateType:" + i3 + " level:" + i16 + " res:" + str);
        return str;
    }

    public static String e(int i3, int i16) {
        q a16 = FriendIntimateRelationshipConfProcessor.a();
        String str = "";
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 26) {
                        if (i16 == 0) {
                            str = a16.Q;
                        } else if (i16 == 1) {
                            str = a16.R;
                        } else if (i16 == 2) {
                            str = a16.S;
                        }
                    }
                } else if (i16 == 0) {
                    str = a16.T;
                } else if (i16 == 1) {
                    str = a16.U;
                } else if (i16 == 2) {
                    str = a16.V;
                }
            } else if (i16 == 0) {
                str = a16.M;
            } else if (i16 == 1) {
                str = a16.N;
            } else if (i16 == 2) {
                str = a16.P;
            }
        } else if (i16 == 0) {
            str = a16.W;
        } else if (i16 == 1) {
            str = a16.X;
        } else if (i16 == 2) {
            str = a16.Y;
        }
        QLog.i("FriendIntimateRelationshipHelper", 1, "getAIOIntimateDarkBG intimateType:" + i3 + " level:" + i16 + " res:" + str);
        return str;
    }

    public static String f(int i3, int i16) {
        String str;
        q a16 = FriendIntimateRelationshipConfProcessor.a();
        if (i3 != 0) {
            str = "";
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 26) {
                            if (i16 == 0) {
                                str = a16.f202703d0;
                            } else if (i16 == 1) {
                                str = a16.f202705e0;
                            } else if (i16 == 2) {
                                str = a16.f202707f0;
                            }
                        }
                    } else if (i16 == 0) {
                        str = a16.f202708g0;
                    } else if (i16 == 1) {
                        str = a16.f202710h0;
                    } else if (i16 == 2) {
                        str = a16.f202712i0;
                    }
                } else if (i16 == 0) {
                    str = a16.f202699a0;
                } else if (i16 == 1) {
                    str = a16.f202700b0;
                } else if (i16 == 2) {
                    str = a16.f202701c0;
                }
            } else if (i16 == 0) {
                str = a16.f202713j0;
            } else if (i16 == 1) {
                str = a16.f202714k0;
            } else if (i16 == 2) {
                str = a16.f202715l0;
            }
        } else {
            str = a16.Z;
        }
        QLog.i("FriendIntimateRelationshipHelper", 1, "getAIOIntimateShareBG intimateType:" + i3 + " level:" + i16 + " res:" + str);
        return str;
    }

    protected static boolean g(AppRuntime appRuntime) {
        return ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("AIO_DelIntimate_GrayTips_864145781");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(QQAppInterface qQAppInterface, intimate_relation$IntimateInfo intimate_relation_intimateinfo) {
        if (intimate_relation_intimateinfo == null) {
            return;
        }
        long j3 = intimate_relation_intimateinfo.frd_uin.get();
        if (j3 <= 0) {
            return;
        }
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(j3)), String.valueOf(j3));
        aVar.q();
        boolean z16 = false;
        if (intimate_relation_intimateinfo.is_del.has() && intimate_relation_intimateinfo.is_del.get()) {
            aVar.v(0);
            aVar.u(0);
            aVar.t(0);
            aVar.r(Boolean.FALSE);
        } else if (intimate_relation_intimateinfo.lover.has()) {
            aVar.v(1);
            aVar.u(intimate_relation_intimateinfo.lover.level.get());
            aVar.t(intimate_relation_intimateinfo.lover.chat_days.get());
            if (intimate_relation_intimateinfo.lover.buffer.has() && intimate_relation_intimateinfo.lover.buffer.get() != null) {
                k(qQAppInterface, aVar, intimate_relation_intimateinfo.lover.buffer.get().toByteArray());
            }
        } else if (intimate_relation_intimateinfo.ladybro.has()) {
            aVar.v(2);
            aVar.u(intimate_relation_intimateinfo.ladybro.level.get());
            aVar.t(intimate_relation_intimateinfo.ladybro.chat_days.get());
            if (intimate_relation_intimateinfo.ladybro.buffer.has() && intimate_relation_intimateinfo.ladybro.buffer.get() != null) {
                k(qQAppInterface, aVar, intimate_relation_intimateinfo.ladybro.buffer.get().toByteArray());
            }
        } else if (intimate_relation_intimateinfo.bestfriend.has()) {
            aVar.v(26);
            aVar.u(intimate_relation_intimateinfo.bestfriend.level.get());
            aVar.t(intimate_relation_intimateinfo.bestfriend.chat_days.get());
            if (intimate_relation_intimateinfo.bestfriend.buffer.has() && intimate_relation_intimateinfo.bestfriend.buffer.get() != null) {
                k(qQAppInterface, aVar, intimate_relation_intimateinfo.bestfriend.buffer.get().toByteArray());
            }
        } else {
            if (intimate_relation_intimateinfo.buddy.has()) {
                aVar.v(3);
                aVar.u(intimate_relation_intimateinfo.buddy.level.get());
                aVar.t(intimate_relation_intimateinfo.buddy.chat_days.get());
                if (intimate_relation_intimateinfo.buddy.buffer.has() && intimate_relation_intimateinfo.buddy.buffer.get() != null) {
                    k(qQAppInterface, aVar, intimate_relation_intimateinfo.buddy.buffer.get().toByteArray());
                }
            }
            if (z16) {
                ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).accurateUpdateIntimateSimpleInfo(aVar, "FriendIntimateRelationshipHelper", (hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>) null);
            }
            if (!QLog.isColorLevel()) {
                QLog.i("FriendIntimateRelationshipHelper", 1, "handleGet0x5e0IntimateInfo end changed:" + z16 + "  uin:" + j3 + " isOpen:" + m(qQAppInterface.getCurrentUin()) + " intimate_type:" + aVar.j() + " intimate_level:" + aVar.f() + " isExtinguish:" + aVar.o() + " intimate_chatDays:" + aVar.e());
                return;
            }
            return;
        }
        z16 = true;
        if (z16) {
        }
        if (!QLog.isColorLevel()) {
        }
    }

    public static boolean i(QQAppInterface qQAppInterface, ExtensionInfo extensionInfo, byte[] bArr) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (bArr != null && bArr.length > 0) {
            intimate_relation$IntimateInfo intimate_relation_intimateinfo = new intimate_relation$IntimateInfo();
            try {
                intimate_relation_intimateinfo.mergeFrom(bArr);
                z17 = false;
            } catch (Exception e16) {
                e16.printStackTrace();
                intimate_relation_intimateinfo = null;
                z17 = true;
            }
            if (intimate_relation_intimateinfo != null && extensionInfo != null) {
                if (intimate_relation_intimateinfo.lover.has()) {
                    extensionInfo.intimate_type = 1;
                    extensionInfo.intimate_level = intimate_relation_intimateinfo.lover.level.get();
                    extensionInfo.intimate_chatDays = intimate_relation_intimateinfo.lover.chat_days.get();
                    if (intimate_relation_intimateinfo.lover.buffer.has() && intimate_relation_intimateinfo.lover.buffer.get() != null) {
                        j(qQAppInterface, extensionInfo, intimate_relation_intimateinfo.lover.buffer.get().toByteArray());
                    }
                } else if (intimate_relation_intimateinfo.ladybro.has()) {
                    extensionInfo.intimate_type = 2;
                    extensionInfo.intimate_level = intimate_relation_intimateinfo.ladybro.level.get();
                    extensionInfo.intimate_chatDays = intimate_relation_intimateinfo.ladybro.chat_days.get();
                    if (intimate_relation_intimateinfo.ladybro.buffer.has() && intimate_relation_intimateinfo.ladybro.buffer.get() != null) {
                        j(qQAppInterface, extensionInfo, intimate_relation_intimateinfo.ladybro.buffer.get().toByteArray());
                    }
                } else if (intimate_relation_intimateinfo.bestfriend.has()) {
                    extensionInfo.intimate_type = 26;
                    extensionInfo.intimate_level = intimate_relation_intimateinfo.bestfriend.level.get();
                    extensionInfo.intimate_chatDays = intimate_relation_intimateinfo.bestfriend.chat_days.get();
                    if (intimate_relation_intimateinfo.bestfriend.buffer.has() && intimate_relation_intimateinfo.bestfriend.buffer.get() != null) {
                        j(qQAppInterface, extensionInfo, intimate_relation_intimateinfo.bestfriend.buffer.get().toByteArray());
                    }
                } else if (intimate_relation_intimateinfo.buddy.has()) {
                    extensionInfo.intimate_type = 3;
                    extensionInfo.intimate_level = intimate_relation_intimateinfo.buddy.level.get();
                    extensionInfo.intimate_chatDays = intimate_relation_intimateinfo.buddy.chat_days.get();
                    if (intimate_relation_intimateinfo.buddy.buffer.has() && intimate_relation_intimateinfo.buddy.buffer.get() != null) {
                        j(qQAppInterface, extensionInfo, intimate_relation_intimateinfo.buddy.buffer.get().toByteArray());
                    }
                }
                z16 = true;
                z18 = z16;
            }
            z16 = false;
            z18 = z16;
        } else {
            z16 = false;
            z17 = false;
            z18 = false;
        }
        if (!z16 && !z17 && extensionInfo != null && (extensionInfo.intimate_type != 0 || extensionInfo.intimate_level != 0 || extensionInfo.intimate_chatDays != 0 || extensionInfo.isExtinguish)) {
            extensionInfo.intimate_type = 0;
            extensionInfo.intimate_level = 0;
            extensionInfo.intimate_chatDays = 0;
            extensionInfo.isExtinguish = false;
            return true;
        }
        return z18;
    }

    public static void j(QQAppInterface qQAppInterface, ExtensionInfo extensionInfo, byte[] bArr) {
        intimate_relation_ext$IntimateRelationExtMsg intimate_relation_ext_intimaterelationextmsg = new intimate_relation_ext$IntimateRelationExtMsg();
        try {
            intimate_relation_ext_intimaterelationextmsg.mergeFrom(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            intimate_relation_ext_intimaterelationextmsg = null;
        }
        if (intimate_relation_ext_intimaterelationextmsg != null) {
            boolean z16 = false;
            if (intimate_relation_ext_intimaterelationextmsg.uint64_icon_status.has() && intimate_relation_ext_intimaterelationextmsg.uint64_icon_status.get() == 1) {
                z16 = true;
            }
            if (extensionInfo.isExtinguish != z16) {
                extensionInfo.isExtinguish = z16;
            }
            if (QLog.isColorLevel()) {
                QLog.i("FriendIntimateRelationshipHelper", 1, "handleGetIntimateRelationExtMsgInfo ext_info.uint64_icon_status.has():" + intimate_relation_ext_intimaterelationextmsg.uint64_icon_status.has() + " newIsExtinguish:" + z16);
            }
        }
    }

    public static void k(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, byte[] bArr) {
        intimate_relation_ext$IntimateRelationExtMsg intimate_relation_ext_intimaterelationextmsg = new intimate_relation_ext$IntimateRelationExtMsg();
        try {
            intimate_relation_ext_intimaterelationextmsg.mergeFrom(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            intimate_relation_ext_intimaterelationextmsg = null;
        }
        if (intimate_relation_ext_intimaterelationextmsg != null) {
            boolean z16 = false;
            if (intimate_relation_ext_intimaterelationextmsg.uint64_icon_status.has() && intimate_relation_ext_intimaterelationextmsg.uint64_icon_status.get() == 1) {
                z16 = true;
            }
            aVar.r(Boolean.valueOf(z16));
            if (QLog.isColorLevel()) {
                QLog.i("FriendIntimateRelationshipHelper", 1, "handleGetIntimateRelationExtMsgInfo extInfo.uint64_icon_status.has():" + intimate_relation_ext_intimaterelationextmsg.uint64_icon_status.has() + " newIsExtinguish:" + z16);
            }
        }
    }

    protected static boolean l(submsgtype0xc7$RelationalChainChange submsgtype0xc7_relationalchainchange) {
        if (submsgtype0xc7_relationalchainchange.uint64_trigger_uin.get() == submsgtype0xc7_relationalchainchange.uint64_dst_uin.get()) {
            return true;
        }
        return false;
    }

    public static boolean m(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, f252216b)) {
            boolean z16 = f252215a;
            String str2 = f252216b;
            f252216b = str;
            f252215a = BaseApplicationImpl.getApplication().getSharedPreferences(str, 0).getBoolean("friend_intimate_isOpen", false);
            if (QLog.isColorLevel()) {
                QLog.d("FriendIntimateRelationshipHelper", 2, "isOpen oldOpen:" + z16 + " sLastIsOpen:" + f252215a + "  oldUin:" + str2 + "  sLastUin:" + f252216b);
            }
        }
        return f252215a;
    }

    public static boolean n() {
        if (System.currentTimeMillis() - f252218d < 1000) {
            return f252217c;
        }
        f252218d = System.currentTimeMillis();
        f252217c = FriendIntimateRelationshipConfProcessor.a().f202702d;
        QLog.i("FriendIntimateRelationshipHelper", 1, "isUpgradeOpen res:" + f252217c);
        return f252217c;
    }

    public static String o() {
        return FriendIntimateRelationshipConfProcessor.a().f202704e;
    }

    public static String p() {
        return FriendIntimateRelationshipConfProcessor.a().f202721q0;
    }

    private static boolean q(AppInterface appInterface, submsgtype0xc7$RelationalChainChange submsgtype0xc7_relationalchainchange) {
        if (g(appInterface) && l(submsgtype0xc7_relationalchainchange)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean r(AppInterface appInterface, x.c cVar) {
        x.c.b bVar;
        if (!((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion() || !com.tencent.relation.common.config.toggle.c.f364711x.g(false) || !(appInterface instanceof QQAppInterface) || cVar == null || (bVar = cVar.f180261b) == null || TextUtils.isEmpty(bVar.f180270f)) {
            return false;
        }
        return true;
    }

    public static void s(String str, boolean z16) {
        boolean z17 = f252215a;
        if (!TextUtils.isEmpty(str)) {
            f252215a = z16;
            SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(str, 0).edit();
            edit.putBoolean("friend_intimate_isOpen", z16);
            edit.commit();
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendIntimateRelationshipHelper", 1, "updateIsOpen uin:" + str + " isOpen:" + z16 + "  sLastIsOpen:" + f252215a + " lastOpen:" + z17);
        }
    }
}
