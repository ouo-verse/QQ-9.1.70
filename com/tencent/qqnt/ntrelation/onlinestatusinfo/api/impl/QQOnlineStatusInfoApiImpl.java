package com.tencent.qqnt.ntrelation.onlinestatusinfo.api.impl;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J*\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0016J8\u0010\u0015\u001a\u00020\u00062\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0010j\b\u0012\u0004\u0012\u00020\b`\u00112\b\u0010\f\u001a\u0004\u0018\u00010\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J>\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0010j\b\u0012\u0004\u0012\u00020\b`\u00112\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J:\u0010\u001b\u001a\u00020\u00062\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0010j\b\u0012\u0004\u0012\u00020\u0002`\u00112\b\u0010\f\u001a\u0004\u0018\u00010\b2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0019H\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/impl/QQOnlineStatusInfoApiImpl;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/api/IQQOnlineStatusInfoApi;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a;", "ntOnlineStatusDetailInfo", "Lcom/tencent/mobileqq/data/Friends;", GuildMsgItem.NICK_FRIEND, "", "onlineStatusDetailInfoTransferFriend", "", "uin", "uid", "friend2DetailInfo", "trace", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteOnlineStatusInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uids", "Lhx3/b;", "iQueryGeneralDataCallback", "getOnlineStatusInfoWithUid", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "getOnlineStatusSimpleInfoWithUid", "ntOnlineStatusDetailInfoList", "Lhx3/c;", "iUpdateGeneralDataCallback", "updateOnlineStatusInfo", "<init>", "()V", "Companion", "a", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQOnlineStatusInfoApiImpl implements IQQOnlineStatusInfoApi {
    public static final String DELETE_ONLINE_STATUS_INFO_TASK_TAG = "_DELETE_ONLINE_STATUS_INFO_TASK_TAG";
    public static final String TAG = "QQOnlineStatusInfoApiImpl";
    public static final String UPDATE_ONLINE_STATUS_INFO_TASK_TAG = "_UPDATE_ONLINE_STATUS_INFO_TASK_TAG";

    /* JADX INFO: Access modifiers changed from: private */
    public final void onlineStatusDetailInfoTransferFriend(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a ntOnlineStatusDetailInfo, Friends friend) {
        friend.uin = ntOnlineStatusDetailInfo.f0();
        friend.detalStatusFlag = ntOnlineStatusDetailInfo.u();
        friend.iTermType = ntOnlineStatusDetailInfo.z();
        friend.netTypeIconId = ntOnlineStatusDetailInfo.C();
        friend.eNetwork = ntOnlineStatusDetailInfo.E();
        friend.songId = ntOnlineStatusDetailInfo.V();
        friend.songName = ntOnlineStatusDetailInfo.Z();
        friend.singerName = ntOnlineStatusDetailInfo.G();
        friend.songEndTime = ntOnlineStatusDetailInfo.N();
        friend.songSourceType = ntOnlineStatusDetailInfo.b0();
        friend.songPauseRemainTime = ntOnlineStatusDetailInfo.a0();
        friend.songDuration = ntOnlineStatusDetailInfo.M();
        friend.temper = ntOnlineStatusDetailInfo.d0();
        friend.weatherType = ntOnlineStatusDetailInfo.o0();
        friend.weatherTypeId = ntOnlineStatusDetailInfo.p0();
        friend.weatherTip = ntOnlineStatusDetailInfo.n0();
        friend.adCode = ntOnlineStatusDetailInfo.c();
        friend.weatherUpdateTime = ntOnlineStatusDetailInfo.q0();
        friend.city = ntOnlineStatusDetailInfo.f();
        friend.weatherDecs = ntOnlineStatusDetailInfo.j0();
        friend.weatherFlag = ntOnlineStatusDetailInfo.k0();
        friend.area = ntOnlineStatusDetailInfo.e();
        friend.weatherIconKey = ntOnlineStatusDetailInfo.l0();
        friend.weatherPrompt = ntOnlineStatusDetailInfo.m0();
        friend.constellationTodayTrend = ntOnlineStatusDetailInfo.p();
        friend.constellationTomorrowTrend = ntOnlineStatusDetailInfo.q();
        friend.constellationBgImageUrl = ntOnlineStatusDetailInfo.j();
        friend.constellationIconUrl = ntOnlineStatusDetailInfo.l();
        friend.constellationJumpUrl = ntOnlineStatusDetailInfo.m();
        friend.constellationDateStr = ntOnlineStatusDetailInfo.k();
        friend.constellationLuckyColor = ntOnlineStatusDetailInfo.n();
        friend.constellationLuckyNumber = ntOnlineStatusDetailInfo.o();
        friend.diyEmoType = ntOnlineStatusDetailInfo.x();
        friend.diyEmoSeverId = ntOnlineStatusDetailInfo.w();
        friend.diyDesc = ntOnlineStatusDetailInfo.v();
        friend.videoId = ntOnlineStatusDetailInfo.g0();
        friend.videoName = ntOnlineStatusDetailInfo.h0();
        friend.videoUrl = ntOnlineStatusDetailInfo.i0();
        friend.curOlympicRank = ntOnlineStatusDetailInfo.r();
        friend.lastLoginType = ntOnlineStatusDetailInfo.B();
        friend.showLoginClient = ntOnlineStatusDetailInfo.A();
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi
    public void deleteOnlineStatusInfo(String uid, String trace, hx3.a<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iDeleteGeneralDataCallback) {
        CoroutineScope f16;
        Intrinsics.checkNotNullParameter(uid, "uid");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            m.f383989a.a(iDeleteGeneralDataCallback);
            QLog.i("LogUtil", 1, "deleteOnlineStatusInfo " + trace + " app is null \n");
            return;
        }
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        String uinFromUid = ((IRelationNTUinAndUidApi) api).getUinFromUid(uid);
        if (uinFromUid == null || (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.c.f261781e)) == null) {
            return;
        }
        CorountineFunKt.e(f16, "QQOnlineStatusInfoApiImpl_DELETE_ONLINE_STATUS_INFO_TASK_TAG", null, null, null, new QQOnlineStatusInfoApiImpl$deleteOnlineStatusInfo$1$1(peekAppRuntime, uinFromUid, iDeleteGeneralDataCallback, trace, null), 14, null);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi
    public ArrayList<c> getOnlineStatusSimpleInfoWithUid(ArrayList<String> uids, String trace) {
        Intrinsics.checkNotNullParameter(uids, "uids");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IF\u2026nstant.MAIN\n            )");
        IFriendDataService iFriendDataService = (IFriendDataService) runtimeService;
        ArrayList<c> arrayList = new ArrayList<>();
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) api;
        Iterator<String> it = uids.iterator();
        while (it.hasNext()) {
            String uid = it.next();
            String uin = iRelationNTUinAndUidApi.getUinFromUid(uid);
            Friends friend = iFriendDataService.getFriend(uin, false);
            b bVar = b.f360117a;
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            arrayList.add(bVar.a(uin, uid, friend));
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi
    public void updateOnlineStatusInfo(ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> ntOnlineStatusDetailInfoList, String trace, hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iUpdateGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(ntOnlineStatusDetailInfoList, "ntOnlineStatusDetailInfoList");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.c.f261781e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QQOnlineStatusInfoApiImpl_UPDATE_ONLINE_STATUS_INFO_TASK_TAG", null, null, null, new QQOnlineStatusInfoApiImpl$updateOnlineStatusInfo$1(peekAppRuntime, ntOnlineStatusDetailInfoList, this, iUpdateGeneralDataCallback, null), 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a friend2DetailInfo(String uin, String uid, Friends friend) {
        long j3 = friend != null ? friend.abilityBits : 0L;
        int i3 = friend != null ? friend.iBatteryStatus : 0;
        int i16 = friend != null ? friend.netTypeIconId : 0;
        long j16 = friend != null ? friend.uExtOnlineStatus : 0L;
        byte b16 = friend != null ? friend.detalStatusFlag : (byte) 0;
        int i17 = friend != null ? friend.iTermType : 0;
        int i18 = friend != null ? friend.eNetwork : 0;
        String str = friend != null ? friend.songId : null;
        if (str == null) {
            str = "";
        }
        String str2 = friend != null ? friend.songName : null;
        String str3 = str2 == null ? "" : str2;
        String str4 = friend != null ? friend.singerName : null;
        String str5 = str4 == null ? "" : str4;
        long j17 = friend != null ? friend.songEndTime : 0L;
        int i19 = friend != null ? friend.songSourceType : 0;
        int i26 = friend != null ? friend.songPauseRemainTime : 0;
        int i27 = friend != null ? friend.songDuration : 0;
        String str6 = friend != null ? friend.temper : null;
        String str7 = str6 == null ? "" : str6;
        String str8 = friend != null ? friend.weatherType : null;
        String str9 = str8 == null ? "" : str8;
        String str10 = friend != null ? friend.weatherTypeId : null;
        String str11 = str10 == null ? "" : str10;
        String str12 = friend != null ? friend.weatherTip : null;
        String str13 = str12 == null ? "" : str12;
        String str14 = friend != null ? friend.adCode : null;
        String str15 = str14 == null ? "" : str14;
        long j18 = friend != null ? friend.weatherUpdateTime : 0L;
        String str16 = friend != null ? friend.city : null;
        String str17 = str16 == null ? "" : str16;
        String str18 = friend != null ? friend.weatherDecs : null;
        String str19 = str18 == null ? "" : str18;
        int i28 = friend != null ? friend.weatherFlag : 0;
        String str20 = friend != null ? friend.area : null;
        String str21 = str20 == null ? "" : str20;
        String str22 = friend != null ? friend.weatherIconKey : null;
        String str23 = str22 == null ? "" : str22;
        String str24 = friend != null ? friend.weatherPrompt : null;
        String str25 = str24 == null ? "" : str24;
        String str26 = friend != null ? friend.constellationTodayTrend : null;
        String str27 = str26 == null ? "" : str26;
        String str28 = friend != null ? friend.constellationTomorrowTrend : null;
        String str29 = str28 == null ? "" : str28;
        String str30 = friend != null ? friend.constellationBgImageUrl : null;
        String str31 = str30 == null ? "" : str30;
        String str32 = friend != null ? friend.constellationIconUrl : null;
        String str33 = str32 == null ? "" : str32;
        String str34 = friend != null ? friend.constellationJumpUrl : null;
        String str35 = str34 == null ? "" : str34;
        String str36 = friend != null ? friend.constellationDateStr : null;
        String str37 = str36 == null ? "" : str36;
        String str38 = friend != null ? friend.constellationLuckyColor : null;
        String str39 = str38 == null ? "" : str38;
        String str40 = friend != null ? friend.constellationLuckyNumber : null;
        String str41 = str40 == null ? "" : str40;
        int i29 = friend != null ? friend.diyEmoType : 0;
        long j19 = friend != null ? friend.diyEmoSeverId : 0L;
        String str42 = friend != null ? friend.diyDesc : null;
        String str43 = str42 == null ? "" : str42;
        String str44 = friend != null ? friend.videoId : null;
        String str45 = str44 == null ? "" : str44;
        String str46 = friend != null ? friend.videoName : null;
        String str47 = str46 == null ? "" : str46;
        String str48 = friend != null ? friend.videoUrl : null;
        String str49 = str48 == null ? "" : str48;
        long j26 = friend != null ? friend.curOlympicRank : -1L;
        long j27 = friend != null ? friend.lastLoginType : 0L;
        long j28 = friend != null ? friend.showLoginClient : 0L;
        String str50 = friend != null ? friend.strTermDesc : null;
        String str51 = str50 == null ? "" : str50;
        String str52 = friend != null ? friend.customOnlineStatus : null;
        return new com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a(uid, uin, j3, i3, i16, j16, b16, i17, i18, str, str3, str5, j17, i19, i26, i27, str7, str9, str11, str13, str15, j18, str17, str19, i28, str21, str23, str25, str27, str29, str31, str33, str35, str37, str39, str41, i29, j19, str43, str45, str47, str49, j26, j27, j28, str51, str52 == null ? "" : str52, friend != null ? friend.customOnlineStatusType : 0, 0L, 0, 65536, null);
    }

    @Override // com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IQQOnlineStatusInfoApi
    public void getOnlineStatusInfoWithUid(ArrayList<String> uids, String trace, hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uids, "uids");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "getOnlineStatusInfoWithUid " + trace + " app is null \n");
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        IFriendDataService iFriendDataService = (IFriendDataService) runtimeService;
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) api;
        ArrayList arrayList = new ArrayList();
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "QQOnlineStatusInfoApiImpl_UPDATE_ONLINE_STATUS_INFO_TASK_TAG", null, null, null, new QQOnlineStatusInfoApiImpl$getOnlineStatusInfoWithUid$1(uids, iRelationNTUinAndUidApi, iFriendDataService, this, iQueryGeneralDataCallback, trace, arrayList, null), 14, null);
        }
    }
}
