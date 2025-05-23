package com.tencent.qqnt.ntrelation.vasinfo.api.impl;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi;
import com.tencent.qqnt.ntrelation.vasinfo.api.impl.QQVasInfoApiImpl;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import hx3.a;
import hx3.b;
import hx3.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import jx3.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J>\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u000f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016J2\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016H\u0016J:\u0010\u001a\u001a\u00020\u00182\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00120\rj\b\u0012\u0004\u0012\u00020\u0012`\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016H\u0016J*\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001cH\u0016J(\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001fH\u0016J*\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016H\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/ntrelation/vasinfo/api/impl/QQVasInfoApiImpl;", "Lcom/tencent/qqnt/ntrelation/vasinfo/api/IQQVasInfoApi;", "Lkx3/a;", "ntVasDetailInfo", "Lcom/tencent/mobileqq/data/ExtensionInfo;", "extensionInfo", "", "vasDetailInfoTransferExtensionInfo", "originInfo", "changedInfo", "Lcom/tencent/mobileqq/data/Friends;", GuildMsgItem.NICK_FRIEND, "vasDetailInfoTransferToFriend", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "getVasSimpleInfoWithUid", "originDetailInfo", "changedDetailInfo", "Lhx3/c;", "updateCallback", "", "updateVasDetailInfo", "accurateUpdateVasDetailInfo", "uid", "Lhx3/a;", "deleteCallback", "deleteVasDetailInfo", "Lhx3/b;", "iQueryGeneralDataCallback", "getVasInfoWithUid", "<init>", "()V", "Companion", "a", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQVasInfoApiImpl implements IQQVasInfoApi {
    public static final String TAG = "QQVasInfoApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void accurateUpdateVasDetailInfo$lambda$1(AppRuntime app, ArrayList changedDetailInfo, c cVar, Ref.ObjectRef responseData) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(changedDetailInfo, "$changedDetailInfo");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        IRuntimeService runtimeService = app.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        IFriendExtensionService iFriendExtensionService = (IFriendExtensionService) runtimeService;
        IRuntimeService runtimeService2 = app.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService<IF\u2026nt.MAIN\n                )");
        IFriendDataService iFriendDataService = (IFriendDataService) runtimeService2;
        Iterator it = changedDetailInfo.iterator();
        while (it.hasNext()) {
            NTVasSimpleInfo nTVasSimpleInfo = (NTVasSimpleInfo) it.next();
            if (nTVasSimpleInfo != null) {
                String uin = nTVasSimpleInfo.getUin();
                Friends friend = iFriendDataService.getFriend(uin, true);
                ExtensionInfo extensionInfo = iFriendExtensionService.getExtensionInfo(uin, true);
                if (extensionInfo == null) {
                    extensionInfo = new ExtensionInfo();
                    extensionInfo.uin = uin;
                }
                if (friend == null) {
                    friend = new Friends();
                    friend.uin = uin;
                }
                m mVar = m.f411114a;
                if (mVar.a(nTVasSimpleInfo, extensionInfo)) {
                    iFriendExtensionService.saveExtensionInfo(extensionInfo);
                }
                if (mVar.b(nTVasSimpleInfo, friend)) {
                    iFriendDataService.saveFriend(friend);
                }
                QLog.i(TAG, 1, "updateVasDetailInfo " + changedDetailInfo);
            }
        }
        if (cVar != null) {
            ((e) responseData.element).e(changedDetailInfo);
            cVar.onUpdateResult((e) responseData.element);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void deleteVasDetailInfo$lambda$3$lambda$2(AppRuntime app, String it, a aVar, Ref.ObjectRef responseData) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        IRuntimeService runtimeService = app.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        ((IFriendExtensionService) runtimeService).deleteExtensionInfo(it);
        if (aVar != null) {
            aVar.a((e) responseData.element);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void getVasInfoWithUid$lambda$4(AppRuntime appRuntime, String uin, String uid, ArrayList result, Ref.ObjectRef responseData, b iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "$uid");
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        IRuntimeService runtimeService = appRuntime.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IF\u2026va, ProcessConstant.MAIN)");
        IRuntimeService runtimeService2 = appRuntime.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService<IF\u2026va, ProcessConstant.MAIN)");
        ExtensionInfo extensionInfo = ((IFriendExtensionService) runtimeService).getExtensionInfo(uin, true);
        Friends friend = ((IFriendDataService) runtimeService2).getFriend(uin, true);
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        int i3 = friend != null ? friend.qqVipInfo : 0;
        int i16 = friend != null ? friend.superQqInfo : 0;
        int i17 = friend != null ? friend.superVipInfo : 0;
        int i18 = friend != null ? friend.hollywoodVipInfo : 0;
        String str = friend != null ? friend.medalsInfo : null;
        String str2 = friend != null ? friend.nameplateCfgInfo : null;
        long j3 = friend != null ? friend.namePlateOfKingGameId : 0L;
        int i19 = i3;
        long j16 = friend != null ? friend.namePlateOfKingLoginTime : 0L;
        int i26 = friend != null ? friend.namePlateOfKingDan : 0;
        boolean z16 = friend != null ? friend.namePlateOfKingDanDisplatSwitch : false;
        int i27 = friend != null ? friend.bigClubInfo : 0;
        int i28 = friend != null ? friend.superVipTemplateId : 0;
        int i29 = friend != null ? friend.bigClubTemplateId : 0;
        int i36 = friend != null ? friend.bigClubExtTemplateId : 0;
        int i37 = friend != null ? friend.diyFontId : 0;
        int i38 = friend != null ? friend.vipStartFlag : 0;
        String str3 = friend != null ? friend.vipIcons : null;
        result.add(new kx3.a(uid, uin, i19, i16, i17, i18, str, str2, j3, j16, i26, z16, i27, i28, i29, i36, i37, i38, str3 == null ? "" : str3, friend != null ? friend.vipDataFlag : 0, friend != null ? friend.gameCardId : 0, friend != null ? friend.nameplateVipType : 0, friend != null ? friend.grayNameplateFlag : 0, friend != null ? friend.cNewLoverDiamondFlag : 0, extensionInfo != null ? extensionInfo.pendantId : 0L, extensionInfo != null ? extensionInfo.pendantDiyId : 0, extensionInfo != null ? extensionInfo.faceId : 0, extensionInfo != null ? extensionInfo.faceIdUpdateTime : 0L, extensionInfo != null ? extensionInfo.timestamp : 0L, extensionInfo != null ? extensionInfo.uVipFont : 0L, extensionInfo != null ? extensionInfo.vipFontType : 0, extensionInfo != null ? extensionInfo.magicFont : 0, extensionInfo != null ? extensionInfo.lastUpdateTime : 0L, extensionInfo != null ? extensionInfo.fontEffect : 0, extensionInfo != null ? extensionInfo.fontEffectLastUpdateTime : 0L, extensionInfo != null ? extensionInfo.diyFontTimestampMap : null, extensionInfo != null ? extensionInfo.diyFontTimestampBytes : null, extensionInfo != null ? extensionInfo.diyFontConfigMap : null, extensionInfo != null ? extensionInfo.diyFontConfigBytes : null));
        ((e) responseData.element).e(result);
        iQueryGeneralDataCallback.onQueryResult((e) responseData.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void updateVasDetailInfo$lambda$0(AppRuntime app, kx3.a changedDetailInfo, QQVasInfoApiImpl this$0, kx3.a originDetailInfo, String str, c cVar, Ref.ObjectRef responseData) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(changedDetailInfo, "$changedDetailInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(originDetailInfo, "$originDetailInfo");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        IRuntimeService runtimeService = app.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        IFriendExtensionService iFriendExtensionService = (IFriendExtensionService) runtimeService;
        IRuntimeService runtimeService2 = app.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService<IF\u2026nt.MAIN\n                )");
        IFriendDataService iFriendDataService = (IFriendDataService) runtimeService2;
        String uin = changedDetailInfo.getUin();
        Friends friend = iFriendDataService.getFriend(uin, true);
        ExtensionInfo extensionInfo = iFriendExtensionService.getExtensionInfo(uin, true);
        if (extensionInfo == null) {
            extensionInfo = new ExtensionInfo();
            extensionInfo.uin = uin;
        }
        if (friend == null) {
            friend = new Friends();
            friend.uin = uin;
        }
        if (this$0.vasDetailInfoTransferExtensionInfo(originDetailInfo, changedDetailInfo, extensionInfo)) {
            iFriendExtensionService.saveExtensionInfo(extensionInfo);
        }
        if (this$0.vasDetailInfoTransferToFriend(originDetailInfo, changedDetailInfo, friend)) {
            iFriendDataService.saveFriend(friend);
        }
        if (QLog.isDebugVersion()) {
            QLog.e(TAG, 1, "updateVasDetailInfo " + changedDetailInfo + " trace " + str);
        }
        if (cVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(changedDetailInfo);
            ((e) responseData.element).e(arrayList);
            cVar.onUpdateResult((e) responseData.element);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void updateVasDetailInfo$lambda$5(AppRuntime app, kx3.a ntVasDetailInfo, QQVasInfoApiImpl this$0, c cVar, Ref.ObjectRef responseData) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(ntVasDetailInfo, "$ntVasDetailInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        IRuntimeService runtimeService = app.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        IFriendExtensionService iFriendExtensionService = (IFriendExtensionService) runtimeService;
        IRuntimeService runtimeService2 = app.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService<IF\u2026nt.MAIN\n                )");
        IFriendDataService iFriendDataService = (IFriendDataService) runtimeService2;
        String uin = ntVasDetailInfo.getUin();
        Friends friend = iFriendDataService.getFriend(uin, true);
        ExtensionInfo extensionInfo = iFriendExtensionService.getExtensionInfo(uin, true);
        if (extensionInfo == null) {
            extensionInfo = new ExtensionInfo();
            extensionInfo.uin = uin;
        }
        if (friend == null) {
            friend = new Friends();
            friend.uin = uin;
        }
        if (this$0.vasDetailInfoTransferExtensionInfo(ntVasDetailInfo, extensionInfo)) {
            iFriendExtensionService.saveExtensionInfo(extensionInfo);
        }
        if (this$0.vasDetailInfoTransferToFriend(ntVasDetailInfo, friend)) {
            iFriendDataService.saveFriend(friend);
        }
        QLog.i(TAG, 1, "updateVasDetailInfo " + ntVasDetailInfo);
        if (cVar != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ntVasDetailInfo);
            ((e) responseData.element).e(arrayList);
            cVar.onUpdateResult((e) responseData.element);
        }
    }

    private final boolean vasDetailInfoTransferExtensionInfo(kx3.a ntVasDetailInfo, ExtensionInfo extensionInfo) {
        boolean z16;
        if (extensionInfo.pendantId != ntVasDetailInfo.getPendantId()) {
            extensionInfo.pendantId = ntVasDetailInfo.getPendantId();
            z16 = true;
        } else {
            z16 = false;
        }
        if (extensionInfo.pendantDiyId != ntVasDetailInfo.getPendantDiyId()) {
            extensionInfo.pendantDiyId = ntVasDetailInfo.getPendantDiyId();
            z16 = true;
        }
        if (extensionInfo.faceId != ntVasDetailInfo.getFaceId()) {
            extensionInfo.faceId = ntVasDetailInfo.getFaceId();
            z16 = true;
        }
        if (extensionInfo.faceIdUpdateTime != ntVasDetailInfo.getFaceIdUpdateTime()) {
            extensionInfo.faceIdUpdateTime = ntVasDetailInfo.getFaceIdUpdateTime();
            z16 = true;
        }
        if (extensionInfo.timestamp != ntVasDetailInfo.getTimestamp()) {
            extensionInfo.timestamp = ntVasDetailInfo.getTimestamp();
            z16 = true;
        }
        if (extensionInfo.uVipFont != ntVasDetailInfo.getUVipFont()) {
            extensionInfo.uVipFont = ntVasDetailInfo.getUVipFont();
            z16 = true;
        }
        if (extensionInfo.vipFontType != ntVasDetailInfo.getVipFontType()) {
            extensionInfo.vipFontType = ntVasDetailInfo.getVipFontType();
            z16 = true;
        }
        if (extensionInfo.magicFont != ntVasDetailInfo.getMagicFont()) {
            extensionInfo.magicFont = ntVasDetailInfo.getMagicFont();
            z16 = true;
        }
        if (extensionInfo.lastUpdateTime != ntVasDetailInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String()) {
            extensionInfo.lastUpdateTime = ntVasDetailInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String();
            z16 = true;
        }
        if (extensionInfo.fontEffect != ntVasDetailInfo.getFontEffect()) {
            extensionInfo.fontEffect = ntVasDetailInfo.getFontEffect();
            z16 = true;
        }
        if (extensionInfo.fontEffectLastUpdateTime != ntVasDetailInfo.getFontEffectLastUpdateTime()) {
            extensionInfo.fontEffectLastUpdateTime = ntVasDetailInfo.getFontEffectLastUpdateTime();
            z16 = true;
        }
        if (!Intrinsics.areEqual(extensionInfo.diyFontTimestampMap, ntVasDetailInfo.i())) {
            extensionInfo.diyFontTimestampMap = ntVasDetailInfo.i();
            z16 = true;
        }
        if (!Arrays.equals(extensionInfo.diyFontConfigBytes, ntVasDetailInfo.getDiyFontConfigBytes())) {
            extensionInfo.diyFontConfigBytes = ntVasDetailInfo.getDiyFontConfigBytes();
            z16 = true;
        }
        if (Intrinsics.areEqual(extensionInfo.diyFontConfigMap, ntVasDetailInfo.f())) {
            return z16;
        }
        extensionInfo.diyFontConfigMap = ntVasDetailInfo.f();
        return true;
    }

    private final boolean vasDetailInfoTransferToFriend(kx3.a ntVasDetailInfo, Friends friend) {
        boolean z16;
        if (friend.qqVipInfo != ntVasDetailInfo.getQqVipInfo()) {
            friend.qqVipInfo = ntVasDetailInfo.getQqVipInfo();
            z16 = true;
        } else {
            z16 = false;
        }
        if (friend.superQqInfo != ntVasDetailInfo.getSuperQqInfo()) {
            friend.superQqInfo = ntVasDetailInfo.getSuperQqInfo();
            z16 = true;
        }
        if (friend.superVipInfo != ntVasDetailInfo.getSuperVipInfo()) {
            friend.superVipInfo = ntVasDetailInfo.getSuperVipInfo();
            z16 = true;
        }
        if (friend.hollywoodVipInfo != ntVasDetailInfo.getHollywoodVipInfo()) {
            friend.hollywoodVipInfo = ntVasDetailInfo.getHollywoodVipInfo();
            z16 = true;
        }
        if (!Intrinsics.areEqual(friend.medalsInfo, ntVasDetailInfo.getMedalsInfo())) {
            friend.medalsInfo = ntVasDetailInfo.getMedalsInfo();
            z16 = true;
        }
        if (!Intrinsics.areEqual(friend.nameplateCfgInfo, ntVasDetailInfo.getNameplateCfgInfo())) {
            friend.nameplateCfgInfo = ntVasDetailInfo.getNameplateCfgInfo();
            z16 = true;
        }
        if (friend.namePlateOfKingGameId != ntVasDetailInfo.getNamePlateOfKingGameId()) {
            friend.namePlateOfKingGameId = ntVasDetailInfo.getNamePlateOfKingGameId();
            z16 = true;
        }
        if (friend.namePlateOfKingLoginTime != ntVasDetailInfo.getNamePlateOfKingLoginTime()) {
            friend.namePlateOfKingLoginTime = ntVasDetailInfo.getNamePlateOfKingLoginTime();
            z16 = true;
        }
        if (friend.namePlateOfKingDan != ntVasDetailInfo.getNamePlateOfKingDan()) {
            friend.namePlateOfKingDan = ntVasDetailInfo.getNamePlateOfKingDan();
            z16 = true;
        }
        if (friend.namePlateOfKingDanDisplatSwitch != ntVasDetailInfo.getNamePlateOfKingDanDisplatSwitch()) {
            friend.namePlateOfKingDanDisplatSwitch = ntVasDetailInfo.getNamePlateOfKingDanDisplatSwitch();
            z16 = true;
        }
        if (friend.bigClubInfo != ntVasDetailInfo.getBigClubInfo()) {
            friend.bigClubInfo = ntVasDetailInfo.getBigClubInfo();
            z16 = true;
        }
        if (friend.superVipTemplateId != ntVasDetailInfo.getSuperVipTemplateId()) {
            friend.superVipTemplateId = ntVasDetailInfo.getSuperVipTemplateId();
            z16 = true;
        }
        if (friend.bigClubTemplateId != ntVasDetailInfo.getBigClubTemplateId()) {
            friend.bigClubTemplateId = ntVasDetailInfo.getBigClubTemplateId();
            z16 = true;
        }
        if (friend.bigClubExtTemplateId != ntVasDetailInfo.getBigClubExtTemplateId()) {
            friend.bigClubExtTemplateId = ntVasDetailInfo.getBigClubExtTemplateId();
            z16 = true;
        }
        if (friend.diyFontId != ntVasDetailInfo.getDiyFontId()) {
            friend.diyFontId = ntVasDetailInfo.getDiyFontId();
            z16 = true;
        }
        if (friend.vipStartFlag != ntVasDetailInfo.getVipStartFlag()) {
            friend.vipStartFlag = ntVasDetailInfo.getVipStartFlag();
            z16 = true;
        }
        if (!Intrinsics.areEqual(friend.vipIcons, ntVasDetailInfo.getVipIcons())) {
            friend.vipIcons = ntVasDetailInfo.getVipIcons();
            z16 = true;
        }
        if (friend.vipDataFlag != ntVasDetailInfo.getVipDataFlag()) {
            friend.vipDataFlag = ntVasDetailInfo.getVipDataFlag();
            z16 = true;
        }
        if (friend.gameCardId != ntVasDetailInfo.getGameCardId()) {
            friend.gameCardId = ntVasDetailInfo.getGameCardId();
            z16 = true;
        }
        if (friend.nameplateVipType != ntVasDetailInfo.getNameplateVipType()) {
            friend.nameplateVipType = ntVasDetailInfo.getNameplateVipType();
            z16 = true;
        }
        if (friend.grayNameplateFlag != ntVasDetailInfo.getGrayNameplateFlag()) {
            friend.grayNameplateFlag = ntVasDetailInfo.getGrayNameplateFlag();
            z16 = true;
        }
        if (friend.cNewLoverDiamondFlag == ntVasDetailInfo.getCNewLoverDiamondFlag()) {
            return z16;
        }
        friend.cNewLoverDiamondFlag = ntVasDetailInfo.getCNewLoverDiamondFlag();
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.tencent.qqnt.ntrelation.friendsinfo.bean.e] */
    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void accurateUpdateVasDetailInfo(final ArrayList<NTVasSimpleInfo> changedDetailInfo, String trace, final c<NTVasSimpleInfo> updateCallback) {
        Intrinsics.checkNotNullParameter(changedDetailInfo, "changedDetailInfo");
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new e();
        ThreadManagerV2.excute(new Runnable() { // from class: jx3.k
            @Override // java.lang.Runnable
            public final void run() {
                QQVasInfoApiImpl.accurateUpdateVasDetailInfo$lambda$1(AppRuntime.this, changedDetailInfo, updateCallback, objectRef);
            }
        }, 16, null, false);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.tencent.qqnt.ntrelation.friendsinfo.bean.e] */
    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void deleteVasDetailInfo(String uid, String trace, final a<kx3.a> deleteCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new e();
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        final String uinFromUid = ((IRelationNTUinAndUidApi) api).getUinFromUid(uid);
        if (uinFromUid != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: jx3.l
                @Override // java.lang.Runnable
                public final void run() {
                    QQVasInfoApiImpl.deleteVasDetailInfo$lambda$3$lambda$2(AppRuntime.this, uinFromUid, deleteCallback, objectRef);
                }
            }, 32, null, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, com.tencent.qqnt.ntrelation.friendsinfo.bean.e] */
    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void getVasInfoWithUid(final String uid, String trace, final b<kx3.a> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        new ArrayList().add(uid);
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new e();
        if (peekAppRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, trace + " getVasInfoWithUid app == nul");
            }
            ((e) objectRef.element).d(-1);
            iQueryGeneralDataCallback.onQueryResult((e) objectRef.element);
            return;
        }
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        final ArrayList arrayList = new ArrayList();
        final String uinFromUid = ((IRelationNTUinAndUidApi) api).getUinFromUid(uid);
        ThreadManagerV2.excute(new Runnable() { // from class: jx3.i
            @Override // java.lang.Runnable
            public final void run() {
                QQVasInfoApiImpl.getVasInfoWithUid$lambda$4(AppRuntime.this, uinFromUid, uid, arrayList, objectRef, iQueryGeneralDataCallback);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public ArrayList<NTVasSimpleInfo> getVasSimpleInfoWithUid(ArrayList<String> uids, String trace) {
        Boolean bool;
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(uids, "uids");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IF\u2026va, ProcessConstant.MAIN)");
        IFriendDataService iFriendDataService = (IFriendDataService) runtimeService;
        IRuntimeService runtimeService2 = peekAppRuntime.getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        IFriendExtensionService iFriendExtensionService = (IFriendExtensionService) runtimeService2;
        ArrayList<NTVasSimpleInfo> arrayList = new ArrayList<>();
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) api;
        Iterator<String> it = uids.iterator();
        while (it.hasNext()) {
            String uid = it.next();
            String uin = iRelationNTUinAndUidApi.getUinFromUid(uid);
            Friends friend = iFriendDataService.getFriend(uin, true);
            ExtensionInfo extensionInfo = iFriendExtensionService.getExtensionInfo(uin, true);
            byte[] bArr = null;
            NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(null, null, 3, null);
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            nTVasSimpleInfo.f(uin);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            nTVasSimpleInfo.e(uid);
            nTVasSimpleInfo.qqVipInfo = friend != null ? friend.qqVipInfo : 0;
            nTVasSimpleInfo.superVipInfo = friend != null ? friend.superVipInfo : 0;
            nTVasSimpleInfo.namePlateOfKingGameId = friend != null ? friend.namePlateOfKingGameId : 0L;
            nTVasSimpleInfo.namePlateOfKingLoginTime = friend != null ? friend.namePlateOfKingLoginTime : 0L;
            nTVasSimpleInfo.namePlateOfKingDan = friend != null ? friend.namePlateOfKingDan : 0;
            if (friend != null) {
                bool = Boolean.valueOf(friend.namePlateOfKingDanDisplatSwitch);
            } else {
                bool = Boolean.FALSE;
            }
            nTVasSimpleInfo.namePlateOfKingDanDisplatSwitch = bool;
            nTVasSimpleInfo.bigClubInfo = friend != null ? friend.bigClubInfo : 0;
            nTVasSimpleInfo.gameCardId = friend != null ? friend.gameCardId : 0;
            nTVasSimpleInfo.nameplateVipType = friend != null ? friend.nameplateVipType : 0;
            nTVasSimpleInfo.grayNameplateFlag = friend != null ? friend.grayNameplateFlag : 0;
            nTVasSimpleInfo.superQqInfo = friend != null ? friend.superQqInfo : 0;
            if (friend == null || (str = friend.medalsInfo) == null) {
                str = "";
            }
            nTVasSimpleInfo.medalsInfo = str;
            if (friend == null || (str2 = friend.nameplateCfgInfo) == null) {
                str2 = "";
            }
            nTVasSimpleInfo.nameplateCfgInfo = str2;
            nTVasSimpleInfo.superVipTemplateId = friend != null ? friend.superVipTemplateId : 0;
            nTVasSimpleInfo.bigClubTemplateId = friend != null ? friend.bigClubTemplateId : 0;
            nTVasSimpleInfo.bigClubExtTemplateId = friend != null ? friend.bigClubExtTemplateId : 0;
            nTVasSimpleInfo.diyFontId = friend != null ? friend.diyFontId : 0;
            nTVasSimpleInfo.vipStartFlag = friend != null ? friend.vipStartFlag : 0;
            if (friend == null || (str3 = friend.vipIcons) == null) {
                str3 = "";
            }
            nTVasSimpleInfo.vipIcons = str3;
            nTVasSimpleInfo.vipDataFlag = friend != null ? friend.vipDataFlag : 0;
            nTVasSimpleInfo.cNewLoverDiamondFlag = friend != null ? friend.cNewLoverDiamondFlag : 0;
            nTVasSimpleInfo.pendantId = extensionInfo != null ? extensionInfo.pendantId : 0L;
            nTVasSimpleInfo.pendantDiyId = extensionInfo != null ? extensionInfo.pendantDiyId : 0;
            nTVasSimpleInfo.faceId = extensionInfo != null ? extensionInfo.faceId : 0;
            nTVasSimpleInfo.uVipFont = extensionInfo != null ? extensionInfo.uVipFont : 0L;
            nTVasSimpleInfo.vipFontType = extensionInfo != null ? extensionInfo.vipFontType : 0;
            nTVasSimpleInfo.magicFont = extensionInfo != null ? extensionInfo.magicFont : 0;
            nTVasSimpleInfo.fontEffect = extensionInfo != null ? extensionInfo.fontEffect : 0;
            nTVasSimpleInfo.diyFontConfigMap = extensionInfo != null ? extensionInfo.diyFontConfigMap : null;
            nTVasSimpleInfo.faceIdUpdateTime = extensionInfo != null ? extensionInfo.faceIdUpdateTime : 0L;
            nTVasSimpleInfo.timestamp = extensionInfo != null ? extensionInfo.timestamp : 0L;
            nTVasSimpleInfo.com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String = extensionInfo != null ? extensionInfo.lastUpdateTime : 0L;
            nTVasSimpleInfo.diyFontTimestampBytes = extensionInfo != null ? extensionInfo.diyFontTimestampBytes : null;
            nTVasSimpleInfo.fontEffectLastUpdateTime = extensionInfo != null ? extensionInfo.fontEffectLastUpdateTime : 0L;
            nTVasSimpleInfo.diyFontTimestampMap = extensionInfo != null ? extensionInfo.diyFontTimestampMap : null;
            if (extensionInfo != null) {
                bArr = extensionInfo.diyFontConfigBytes;
            }
            nTVasSimpleInfo.diyFontConfigBytes = bArr;
            arrayList.add(nTVasSimpleInfo);
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, com.tencent.qqnt.ntrelation.friendsinfo.bean.e] */
    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void updateVasDetailInfo(final kx3.a originDetailInfo, final kx3.a changedDetailInfo, final String trace, final c<kx3.a> updateCallback) {
        Intrinsics.checkNotNullParameter(originDetailInfo, "originDetailInfo");
        Intrinsics.checkNotNullParameter(changedDetailInfo, "changedDetailInfo");
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new e();
        ThreadManagerV2.excute(new Runnable() { // from class: jx3.h
            @Override // java.lang.Runnable
            public final void run() {
                QQVasInfoApiImpl.updateVasDetailInfo$lambda$0(AppRuntime.this, changedDetailInfo, this, originDetailInfo, trace, updateCallback, objectRef);
            }
        }, 16, null, false);
    }

    /* JADX WARN: Type inference failed for: r8v4, types: [T, com.tencent.qqnt.ntrelation.friendsinfo.bean.e] */
    @Override // com.tencent.qqnt.ntrelation.vasinfo.api.IQQVasInfoApi
    public void updateVasDetailInfo(final kx3.a ntVasDetailInfo, String trace, final c<kx3.a> updateCallback) {
        Intrinsics.checkNotNullParameter(ntVasDetailInfo, "ntVasDetailInfo");
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new e();
        ThreadManagerV2.excute(new Runnable() { // from class: jx3.j
            @Override // java.lang.Runnable
            public final void run() {
                QQVasInfoApiImpl.updateVasDetailInfo$lambda$5(AppRuntime.this, ntVasDetailInfo, this, updateCallback, objectRef);
            }
        }, 16, null, false);
    }

    private final boolean vasDetailInfoTransferExtensionInfo(kx3.a originInfo, kx3.a changedInfo, ExtensionInfo extensionInfo) {
        boolean z16;
        if (changedInfo.getPendantId() != originInfo.getPendantId()) {
            extensionInfo.pendantId = changedInfo.getPendantId();
            z16 = true;
        } else {
            z16 = false;
        }
        if (changedInfo.getPendantDiyId() != originInfo.getPendantDiyId()) {
            extensionInfo.pendantDiyId = changedInfo.getPendantDiyId();
            z16 = true;
        }
        if (changedInfo.getFaceId() != originInfo.getFaceId()) {
            extensionInfo.faceId = changedInfo.getFaceId();
            z16 = true;
        }
        if (changedInfo.getFaceIdUpdateTime() != originInfo.getFaceIdUpdateTime()) {
            extensionInfo.faceIdUpdateTime = changedInfo.getFaceIdUpdateTime();
            z16 = true;
        }
        if (changedInfo.getTimestamp() != originInfo.getTimestamp()) {
            extensionInfo.timestamp = changedInfo.getTimestamp();
            z16 = true;
        }
        if (changedInfo.getUVipFont() != originInfo.getUVipFont()) {
            extensionInfo.uVipFont = changedInfo.getUVipFont();
            z16 = true;
        }
        if (changedInfo.getVipFontType() != originInfo.getVipFontType()) {
            extensionInfo.vipFontType = changedInfo.getVipFontType();
            z16 = true;
        }
        if (changedInfo.getMagicFont() != originInfo.getMagicFont()) {
            extensionInfo.magicFont = changedInfo.getMagicFont();
            z16 = true;
        }
        if (changedInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String() != originInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String()) {
            extensionInfo.lastUpdateTime = changedInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.LAST_UPDATE_TIME java.lang.String();
            z16 = true;
        }
        if (changedInfo.getFontEffect() != originInfo.getFontEffect()) {
            extensionInfo.fontEffect = changedInfo.getFontEffect();
            z16 = true;
        }
        if (changedInfo.getFontEffectLastUpdateTime() != originInfo.getFontEffectLastUpdateTime()) {
            extensionInfo.fontEffectLastUpdateTime = changedInfo.getFontEffectLastUpdateTime();
            z16 = true;
        }
        com.tencent.qqnt.ntrelation.util.a aVar = com.tencent.qqnt.ntrelation.util.a.f360228a;
        if (!aVar.a(changedInfo.i(), originInfo.i())) {
            extensionInfo.diyFontTimestampMap = changedInfo.i();
            z16 = true;
        }
        if (!aVar.b(changedInfo.getDiyFontConfigBytes(), originInfo.getDiyFontConfigBytes())) {
            extensionInfo.diyFontConfigBytes = changedInfo.getDiyFontConfigBytes();
            z16 = true;
        }
        if (aVar.a(changedInfo.f(), originInfo.f())) {
            return z16;
        }
        extensionInfo.diyFontConfigMap = changedInfo.f();
        return true;
    }

    private final boolean vasDetailInfoTransferToFriend(kx3.a originInfo, kx3.a changedInfo, Friends friend) {
        boolean z16;
        if (changedInfo.getQqVipInfo() != originInfo.getQqVipInfo()) {
            friend.qqVipInfo = changedInfo.getQqVipInfo();
            z16 = true;
        } else {
            z16 = false;
        }
        if (changedInfo.getSuperQqInfo() != originInfo.getSuperQqInfo()) {
            friend.superQqInfo = changedInfo.getSuperQqInfo();
            z16 = true;
        }
        if (changedInfo.getSuperVipInfo() != originInfo.getSuperVipInfo()) {
            friend.superVipInfo = changedInfo.getSuperVipInfo();
            z16 = true;
        }
        if (changedInfo.getHollywoodVipInfo() != originInfo.getHollywoodVipInfo()) {
            friend.hollywoodVipInfo = changedInfo.getHollywoodVipInfo();
            z16 = true;
        }
        com.tencent.qqnt.ntrelation.util.a aVar = com.tencent.qqnt.ntrelation.util.a.f360228a;
        if (!aVar.a(changedInfo.getMedalsInfo(), originInfo.getMedalsInfo())) {
            friend.medalsInfo = changedInfo.getMedalsInfo();
            z16 = true;
        }
        if (!Intrinsics.areEqual(changedInfo.getNameplateCfgInfo(), originInfo.getNameplateCfgInfo())) {
            friend.nameplateCfgInfo = changedInfo.getNameplateCfgInfo();
            z16 = true;
        }
        if (changedInfo.getNamePlateOfKingGameId() != originInfo.getNamePlateOfKingGameId()) {
            friend.namePlateOfKingGameId = changedInfo.getNamePlateOfKingGameId();
            z16 = true;
        }
        if (changedInfo.getNamePlateOfKingLoginTime() != originInfo.getNamePlateOfKingLoginTime()) {
            friend.namePlateOfKingLoginTime = changedInfo.getNamePlateOfKingLoginTime();
            z16 = true;
        }
        if (changedInfo.getNamePlateOfKingDan() != originInfo.getNamePlateOfKingDan()) {
            friend.namePlateOfKingDan = changedInfo.getNamePlateOfKingDan();
            z16 = true;
        }
        if (changedInfo.getNamePlateOfKingDanDisplatSwitch() != originInfo.getNamePlateOfKingDanDisplatSwitch()) {
            friend.namePlateOfKingDanDisplatSwitch = changedInfo.getNamePlateOfKingDanDisplatSwitch();
            z16 = true;
        }
        if (changedInfo.getBigClubInfo() != originInfo.getBigClubInfo()) {
            friend.bigClubInfo = changedInfo.getBigClubInfo();
            z16 = true;
        }
        if (changedInfo.getSuperVipTemplateId() != originInfo.getSuperVipTemplateId()) {
            friend.superVipTemplateId = changedInfo.getSuperVipTemplateId();
            z16 = true;
        }
        if (changedInfo.getBigClubTemplateId() != originInfo.getBigClubTemplateId()) {
            friend.bigClubTemplateId = changedInfo.getBigClubTemplateId();
            z16 = true;
        }
        if (changedInfo.getBigClubExtTemplateId() != originInfo.getBigClubExtTemplateId()) {
            friend.bigClubExtTemplateId = changedInfo.getBigClubExtTemplateId();
            z16 = true;
        }
        if (changedInfo.getDiyFontId() != originInfo.getDiyFontId()) {
            friend.diyFontId = changedInfo.getDiyFontId();
            z16 = true;
        }
        if (changedInfo.getVipStartFlag() != originInfo.getVipStartFlag()) {
            friend.vipStartFlag = changedInfo.getVipStartFlag();
            z16 = true;
        }
        if (!aVar.a(changedInfo.getVipIcons(), originInfo.getVipIcons())) {
            friend.vipIcons = changedInfo.getVipIcons();
            z16 = true;
        }
        if (changedInfo.getVipDataFlag() != originInfo.getVipDataFlag()) {
            friend.vipDataFlag = changedInfo.getVipDataFlag();
            z16 = true;
        }
        if (changedInfo.getGameCardId() != originInfo.getGameCardId()) {
            friend.gameCardId = changedInfo.getGameCardId();
            z16 = true;
        }
        if (changedInfo.getNameplateVipType() != originInfo.getNameplateVipType()) {
            friend.nameplateVipType = changedInfo.getNameplateVipType();
            z16 = true;
        }
        if (changedInfo.getGrayNameplateFlag() != originInfo.getGrayNameplateFlag()) {
            friend.grayNameplateFlag = changedInfo.getGrayNameplateFlag();
            z16 = true;
        }
        if (changedInfo.getCNewLoverDiamondFlag() == originInfo.getCNewLoverDiamondFlag()) {
            return z16;
        }
        friend.cNewLoverDiamondFlag = changedInfo.getCNewLoverDiamondFlag();
        return true;
    }
}
