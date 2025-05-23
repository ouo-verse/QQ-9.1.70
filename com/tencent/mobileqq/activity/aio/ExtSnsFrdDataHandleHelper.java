package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.x;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.listentogether.api.IListenTogetherApi;
import com.tencent.mobileqq.mutualmark.MutualMarkDataS2CHandleHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.DigestErrCode;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50$ExtSnsFrdData;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$RelationalChainChange;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ExtSnsFrdDataHandleHelper {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements hx3.b<com.tencent.qqnt.ntrelation.otherinfo.bean.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f178074a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f178075b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f178076c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Oidb_0xd50$ExtSnsFrdData f178077d;

        a(String str, String str2, QQAppInterface qQAppInterface, Oidb_0xd50$ExtSnsFrdData oidb_0xd50$ExtSnsFrdData) {
            this.f178074a = str;
            this.f178075b = str2;
            this.f178076c = qQAppInterface;
            this.f178077d = oidb_0xd50$ExtSnsFrdData;
        }

        @Override // hx3.b
        public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> eVar) {
            ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.a> b16;
            com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar;
            if (eVar.a() != 0 || (b16 = eVar.b()) == null) {
                return;
            }
            if (b16.size() != 0 && b16.get(0) != null) {
                aVar = b16.get(0);
            } else {
                aVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.a();
                aVar.t(this.f178074a);
                aVar.u(this.f178075b);
            }
            ExtSnsFrdDataHandleHelper.c(this.f178076c, aVar, this.f178075b, this.f178077d);
        }
    }

    public static void b(QQAppInterface qQAppInterface, submsgtype0xc7$RelationalChainChange submsgtype0xc7_relationalchainchange, PushMsg0x210C7Info pushMsg0x210C7Info, String str) {
        if (qQAppInterface != null && submsgtype0xc7_relationalchainchange != null && pushMsg0x210C7Info != null) {
            x j3 = x.j(submsgtype0xc7_relationalchainchange, pushMsg0x210C7Info.onlinePush);
            if (TextUtils.equals(qQAppInterface.getCurrentAccountUin(), j3.f180247a) && !TextUtils.isEmpty(j3.f180248b)) {
                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(j3.f180248b);
                com.tencent.qqnt.ntrelation.intimateinfo.bean.a intimateSimpleInfoWithUid = ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).getIntimateSimpleInfoWithUid(uidFromUin, "ExtSnsFrdDataHandlerHelper");
                if (intimateSimpleInfoWithUid == null) {
                    intimateSimpleInfoWithUid = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a();
                    intimateSimpleInfoWithUid.B(j3.f180248b);
                    intimateSimpleInfoWithUid.A(uidFromUin);
                }
                com.tencent.mobileqq.mutualmark.elegantlogic.a.a(intimateSimpleInfoWithUid, j3);
                QLog.i("ExtSnsFrdDataHandlerHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 from:" + str + " msginfo:" + pushMsg0x210C7Info + " changePushInfo:" + j3);
                int i3 = j3.f180249c;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 50000) {
                                switch (i3) {
                                    case 10001:
                                        i(qQAppInterface, intimateSimpleInfoWithUid, j3, pushMsg0x210C7Info);
                                        return;
                                    case 10002:
                                        j(qQAppInterface, intimateSimpleInfoWithUid, j3, pushMsg0x210C7Info);
                                        return;
                                    case 10003:
                                        h(qQAppInterface, intimateSimpleInfoWithUid, j3, pushMsg0x210C7Info);
                                        return;
                                    case 10004:
                                        q(qQAppInterface, intimateSimpleInfoWithUid, j3, pushMsg0x210C7Info);
                                        return;
                                    case 10005:
                                        p(qQAppInterface, intimateSimpleInfoWithUid, j3, pushMsg0x210C7Info);
                                        return;
                                    default:
                                        switch (i3) {
                                            case 11000:
                                                m(qQAppInterface, intimateSimpleInfoWithUid, j3, pushMsg0x210C7Info);
                                                return;
                                            case 11001:
                                                l(qQAppInterface, intimateSimpleInfoWithUid, j3, pushMsg0x210C7Info);
                                                return;
                                            case DigestErrCode.MSG_ALREADY_ADDED /* 11002 */:
                                                n(qQAppInterface, intimateSimpleInfoWithUid, j3, pushMsg0x210C7Info);
                                                return;
                                            case DigestErrCode.SPACE_NOT_ENOUGH /* 11003 */:
                                                e(qQAppInterface, intimateSimpleInfoWithUid, j3, pushMsg0x210C7Info);
                                                return;
                                            default:
                                                return;
                                        }
                                }
                            }
                            k(qQAppInterface, j3, pushMsg0x210C7Info);
                            return;
                        }
                        o(qQAppInterface, intimateSimpleInfoWithUid, j3, pushMsg0x210C7Info);
                        return;
                    }
                    g(qQAppInterface, intimateSimpleInfoWithUid, j3, pushMsg0x210C7Info);
                    return;
                }
                f(qQAppInterface, intimateSimpleInfoWithUid, j3, pushMsg0x210C7Info);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    public static int c(final QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar, final String str, Oidb_0xd50$ExtSnsFrdData oidb_0xd50$ExtSnsFrdData) {
        boolean z16;
        boolean z17;
        ?? r75;
        boolean z18;
        boolean z19;
        boolean z26;
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "ExtSnsFrdDataHandlerHelper");
        com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar2 = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(uidFromUin, str);
        aVar2.m();
        if (isFriend) {
            if (oidb_0xd50$ExtSnsFrdData.bytes_music_switch.has()) {
                z16 = ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).isC2CListenTogetherOpening(oidb_0xd50$ExtSnsFrdData.bytes_music_switch.get().toByteArray());
            } else {
                z16 = false;
            }
            if (oidb_0xd50$ExtSnsFrdData.bytes_ksing_switch.has()) {
                z17 = com.tencent.mobileqq.intervideo.singtogether.c.i(oidb_0xd50$ExtSnsFrdData.bytes_ksing_switch.get().toByteArray());
            } else {
                z17 = false;
            }
            if (oidb_0xd50$ExtSnsFrdData.bytes_lbs_share.has()) {
                z26 = com.tencent.mobileqq.location.a.a(oidb_0xd50$ExtSnsFrdData.bytes_lbs_share);
            } else {
                z26 = false;
            }
            if (oidb_0xd50$ExtSnsFrdData.bytes_aio_quick_app.has()) {
                z18 = com.tencent.mobileqq.c2cshortcutbar.g.b(oidb_0xd50$ExtSnsFrdData.bytes_aio_quick_app);
                r75 = z26;
            } else {
                z18 = false;
                r75 = z26;
            }
        } else {
            z16 = false;
            z17 = false;
            r75 = 0;
            z18 = false;
        }
        aVar2.w0(z17, 16777216);
        aVar2.r(r75);
        if (aVar.l() == 1) {
            z19 = true;
        } else {
            z19 = false;
        }
        com.tencent.mobileqq.location.a.g(qQAppInterface, 0, str, z19);
        if (QLog.isColorLevel()) {
            QLog.d("ExtSnsFrdDataHandlerHelper", 2, "handleExtSnsFrdData: invoked. update ei & msg data ", " isSharingLbs: ", Boolean.valueOf((boolean) r75));
        }
        aVar2.n(Boolean.valueOf(z18));
        if (QLog.isColorLevel()) {
            QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleExtSnsFrdData friendUin:" + str + " newIsOpen:" + z16 + " is_sing_together=" + z17 + " isSharingLocation: " + aVar2.l() + " isAioShortcutBarOpen: " + aVar2.k() + " friend:" + isFriend);
        }
        ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singleton(aVar2)), "ExtSnsFrdDataHandlerHelper", new hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.a>() { // from class: com.tencent.mobileqq.activity.aio.ExtSnsFrdDataHandleHelper.2
            @Override // hx3.c
            public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.a> eVar) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.ExtSnsFrdDataHandleHelper.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQAppInterface.this.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, str);
                    }
                });
            }
        });
        IIntimateInfoService iIntimateInfoService = (IIntimateInfoService) QRoute.api(IIntimateInfoService.class);
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar3 = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(uidFromUin, str);
        aVar3.q();
        aVar3.x(Boolean.valueOf(z16));
        iIntimateInfoService.accurateUpdateIntimateSimpleInfo(aVar3, "ExtSnsFrdDataHandlerHelper", (hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a>) null);
        if (QLog.isColorLevel()) {
            QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleExtSnsFrdData friendUin:" + str + " newIsOpen:" + z16 + " oldIsOpen" + aVar3.p());
        }
        if (!isFriend) {
            return 0;
        }
        if (oidb_0xd50$ExtSnsFrdData.bytes_mutualmark_alienation.has()) {
            com.tencent.mobileqq.mutualmark.alienation.a.e(qQAppInterface, str, oidb_0xd50$ExtSnsFrdData.bytes_mutualmark_alienation.get().toByteArray(), false);
            if (QLog.isColorLevel()) {
                QLog.d("ExtSnsFrdDataHandlerHelper", 1, "handleExtSnsFrdData friendUin:" + str);
            }
            return 2;
        }
        if (!QLog.isColorLevel()) {
            return 0;
        }
        QLog.e("ExtSnsFrdDataHandlerHelper", 2, "handleExtSnsFrdData ExtSnsFrdData  friendUin:" + str + " doesn't has bytes_mutualmark_alienation");
        return 0;
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static void d(QQAppInterface qQAppInterface, boolean z16, ExtensionInfo extensionInfo, String str, Oidb_0xd50$ExtSnsFrdData oidb_0xd50$ExtSnsFrdData) {
        boolean z17;
        boolean z18;
        boolean z19;
        ?? r26;
        boolean z26;
        boolean z27;
        boolean z28;
        if (z16) {
            if (oidb_0xd50$ExtSnsFrdData.bytes_music_switch.has()) {
                z17 = ((IListenTogetherApi) QRoute.api(IListenTogetherApi.class)).isC2CListenTogetherOpening(oidb_0xd50$ExtSnsFrdData.bytes_music_switch.get().toByteArray());
            } else {
                z17 = false;
            }
            if (oidb_0xd50$ExtSnsFrdData.bytes_ksing_switch.has()) {
                z19 = com.tencent.mobileqq.intervideo.singtogether.c.i(oidb_0xd50$ExtSnsFrdData.bytes_ksing_switch.get().toByteArray());
            } else {
                z19 = false;
            }
            if (oidb_0xd50$ExtSnsFrdData.bytes_lbs_share.has()) {
                z28 = com.tencent.mobileqq.location.a.a(oidb_0xd50$ExtSnsFrdData.bytes_lbs_share);
            } else {
                z28 = false;
            }
            if (oidb_0xd50$ExtSnsFrdData.bytes_aio_quick_app.has()) {
                z18 = com.tencent.mobileqq.c2cshortcutbar.g.b(oidb_0xd50$ExtSnsFrdData.bytes_aio_quick_app);
                r26 = z28;
            } else {
                z18 = false;
                r26 = z28;
            }
        } else {
            z17 = false;
            z18 = false;
            z19 = false;
            r26 = 0;
        }
        if (extensionInfo.isTogetherBusinessOpen(16777216) != z19) {
            extensionInfo.setTogetherBusiness(z19, 16777216);
        }
        if (extensionInfo.isListenTogetherOpen != z17) {
            extensionInfo.isListenTogetherOpen = z17;
        }
        if (extensionInfo.isSharingLocation == 1) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26 != r26) {
            extensionInfo.isSharingLocation = r26;
            if (r26 == 1) {
                z27 = true;
            } else {
                z27 = false;
            }
            com.tencent.mobileqq.location.a.g(qQAppInterface, 0, str, z27);
            if (QLog.isColorLevel()) {
                QLog.d("ExtSnsFrdDataHandlerHelper", 2, "handleExtSnsFrdDataForListenTogether: invoked. update ei & msg data ", " isSharingLbs: ", Boolean.valueOf((boolean) r26));
            }
        }
        if (extensionInfo.isAioShortcutBarOpen != z18) {
            extensionInfo.isAioShortcutBarOpen = z18;
        }
    }

    public static void e(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        if (xVar.f180252f != null) {
            QLog.i("ExtSnsFrdDataHandlerHelper", 1, "[MutualMarkInfo_0x7cPush]handleExtSnsFrdDataPushTypeWearing msginfo:" + pushMsg0x210C7Info);
            MutualMarkDataS2CHandleHelper.k(qQAppInterface, aVar, xVar, pushMsg0x210C7Info);
        }
    }

    public static void f(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        x.c cVar = xVar.f180252f;
        if (cVar != null) {
            int i3 = cVar.f180260a;
            if (i3 != 10) {
                if (com.tencent.mobileqq.mutualmark.g.n(i3)) {
                    QLog.i("ExtSnsFrdDataHandlerHelper", 1, "handleMutualMarkDataPushType_Add msginfo:" + pushMsg0x210C7Info);
                    MutualMarkDataS2CHandleHelper.k(qQAppInterface, aVar, xVar, pushMsg0x210C7Info);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.mutualmark.alienation.a.e(qQAppInterface, xVar.f180248b, cVar.f180263d, true);
        }
    }

    public static void g(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        if (xVar.f180251e != null && com.tencent.mobileqq.mutualmark.g.n(r0.f180260a)) {
            QLog.i("ExtSnsFrdDataHandlerHelper", 1, "handleMutualMarkDataPushType_Del msginfo:" + pushMsg0x210C7Info);
            MutualMarkDataS2CHandleHelper.k(qQAppInterface, aVar, xVar, pushMsg0x210C7Info);
        }
    }

    public static void h(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        if (xVar.f180252f != null && com.tencent.mobileqq.mutualmark.g.n(r0.f180260a)) {
            QLog.i("ExtSnsFrdDataHandlerHelper", 1, "handleMutualMarkDataPushType_Downgrade msginfo:" + pushMsg0x210C7Info);
            MutualMarkDataS2CHandleHelper.k(qQAppInterface, aVar, xVar, pushMsg0x210C7Info);
        }
    }

    public static void i(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        if (xVar.f180252f != null && com.tencent.mobileqq.mutualmark.g.n(r0.f180260a)) {
            QLog.i("ExtSnsFrdDataHandlerHelper", 1, "handleMutualMarkDataPushType_Downgrade_Soon msginfo:" + pushMsg0x210C7Info);
            MutualMarkDataS2CHandleHelper.k(qQAppInterface, aVar, xVar, pushMsg0x210C7Info);
        }
    }

    public static void j(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        if (xVar.f180252f != null && com.tencent.mobileqq.mutualmark.g.n(r0.f180260a)) {
            QLog.i("ExtSnsFrdDataHandlerHelper", 1, "handleMutualMarkDataPushType_Egalitarian_Soon msginfo:" + pushMsg0x210C7Info);
            MutualMarkDataS2CHandleHelper.k(qQAppInterface, aVar, xVar, pushMsg0x210C7Info);
        }
    }

    public static void k(QQAppInterface qQAppInterface, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        if (xVar.f180252f != null) {
            QLog.i("ExtSnsFrdDataHandlerHelper", 1, "handleMutualMarkDataPushType_GrayTipChannel msginfo:" + pushMsg0x210C7Info);
            if (!com.tencent.mobileqq.mutualmark.g.k(qQAppInterface)) {
                com.tencent.mobileqq.mutualmark.d.c(qQAppInterface, xVar, pushMsg0x210C7Info);
            }
        }
    }

    public static void l(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        if (xVar.f180252f != null || xVar.f180253g != null) {
            QLog.i("ExtSnsFrdDataHandlerHelper", 1, "handleMutualMarkDataPushType_Icon_Extinguish msginfo:" + pushMsg0x210C7Info);
            MutualMarkDataS2CHandleHelper.k(qQAppInterface, aVar, xVar, pushMsg0x210C7Info);
        }
    }

    public static void m(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        if (xVar.f180252f != null || xVar.f180253g != null) {
            QLog.i("ExtSnsFrdDataHandlerHelper", 1, "handleMutualMarkDataPushType_Icon_Light msginfo:" + pushMsg0x210C7Info);
            MutualMarkDataS2CHandleHelper.k(qQAppInterface, aVar, xVar, pushMsg0x210C7Info);
        }
    }

    public static void n(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        if (xVar.f180252f != null || xVar.f180253g != null) {
            QLog.i("ExtSnsFrdDataHandlerHelper", 1, "handleMutualMarkDataPushType_Icon_Extinguish msginfo:" + pushMsg0x210C7Info);
            MutualMarkDataS2CHandleHelper.k(qQAppInterface, aVar, xVar, pushMsg0x210C7Info);
        }
    }

    public static void o(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        x.c cVar = xVar.f180252f;
        if (cVar != null) {
            int i3 = cVar.f180260a;
            if (i3 != 10) {
                if (com.tencent.mobileqq.mutualmark.g.n(i3)) {
                    QLog.i("ExtSnsFrdDataHandlerHelper", 1, "handleMutualMarkDataPushType_Del msginfo:" + pushMsg0x210C7Info);
                    MutualMarkDataS2CHandleHelper.k(qQAppInterface, aVar, xVar, pushMsg0x210C7Info);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.mutualmark.alienation.a.e(qQAppInterface, xVar.f180248b, cVar.f180263d, true);
        }
    }

    public static void p(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        if (xVar.f180252f != null && com.tencent.mobileqq.mutualmark.g.n(r0.f180260a)) {
            QLog.i("ExtSnsFrdDataHandlerHelper", 1, "handleMutualMarkDataPushType_Upgrade msginfo:" + pushMsg0x210C7Info);
            MutualMarkDataS2CHandleHelper.k(qQAppInterface, aVar, xVar, pushMsg0x210C7Info);
        }
    }

    public static void q(QQAppInterface qQAppInterface, com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        if (xVar.f180252f != null && com.tencent.mobileqq.mutualmark.g.n(r0.f180260a)) {
            QLog.i("ExtSnsFrdDataHandlerHelper", 1, "handleMutualMarkDataPushType_Upgrade msginfo:" + pushMsg0x210C7Info);
            MutualMarkDataS2CHandleHelper.k(qQAppInterface, aVar, xVar, pushMsg0x210C7Info);
        }
    }

    public static void r(QQAppInterface qQAppInterface, Oidb_0xd50$ExtSnsFrdData oidb_0xd50$ExtSnsFrdData) {
        if (oidb_0xd50$ExtSnsFrdData == null) {
            return;
        }
        long j3 = oidb_0xd50$ExtSnsFrdData.frd_uin.get();
        if (j3 <= 0) {
            return;
        }
        String valueOf = String.valueOf(j3);
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf);
        ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherInfoWithUid(uidFromUin, "ExtSnsFrdDataHandlerHelper", new a(uidFromUin, valueOf, qQAppInterface, oidb_0xd50$ExtSnsFrdData));
    }

    public static void s(QQAppInterface qQAppInterface, Friends friends, String str, Oidb_0xd50$ExtSnsFrdData oidb_0xd50$ExtSnsFrdData) {
        if (friends != null) {
            if (oidb_0xd50$ExtSnsFrdData.bytes_mutualmark_alienation.has()) {
                com.tencent.mobileqq.mutualmark.alienation.a.d(qQAppInterface, (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER), friends, str, oidb_0xd50$ExtSnsFrdData.bytes_mutualmark_alienation.get().toByteArray(), false);
                if (QLog.isDebugVersion()) {
                    QLog.d("ExtSnsFrdDataHandlerHelper", 4, "handleMutualMarExtSnsFrdData friendUin:" + str + " relationIconFlag" + friends.relationIconFlag);
                    return;
                }
                return;
            }
            if (QLog.isDebugVersion()) {
                QLog.d("ExtSnsFrdDataHandlerHelper", 4, "handleMutualMarExtSnsFrdData ExtSnsFrdData  friendUin:" + str + " doesn't has bytes_mutualmark_alienation");
            }
        }
    }
}
