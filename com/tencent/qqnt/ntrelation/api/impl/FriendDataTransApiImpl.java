package com.tencent.qqnt.ntrelation.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.help.GroupInfoHelper;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.api.IFriendDataTransApi;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.impl.b;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import com.tencent.qqnt.ntrelation.otherinfo.bean.a;
import com.tencent.qqnt.ntrelation.util.i;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/ntrelation/api/impl/FriendDataTransApiImpl;", "Lcom/tencent/qqnt/ntrelation/api/IFriendDataTransApi;", "Lcom/tencent/mobileqq/data/Friends;", "friends", "", "needUid", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "friendsConvertToOnlineStatusInfo", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "Lkotlin/collections/ArrayList;", "allFriendsConvertToFriendsSimpleInfo", "Lcom/tencent/mobileqq/data/ExtensionInfo;", "extensionInfo", "friendConvertToFriendsSimpleInfo", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "SpecialInfoConvertToNTOtherDetailInfo", "", "checkNTDBDataOK", "<init>", "()V", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FriendDataTransApiImpl implements IFriendDataTransApi {
    @Override // com.tencent.qqnt.ntrelation.api.IFriendDataTransApi
    public ArrayList<d> allFriendsConvertToFriendsSimpleInfo(List<? extends Friends> friends) {
        Intrinsics.checkNotNullParameter(friends, "friends");
        ArrayList<d> arrayList = new ArrayList<>();
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFriendExtensionService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IFriendExtensionService iFriendExtensionService = (IFriendExtensionService) runtimeService;
        for (Friends friends2 : friends) {
            arrayList.add(friendConvertToFriendsSimpleInfo(friends2, iFriendExtensionService.getExtensionInfo(friends2.uin)));
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendDataTransApi
    public void checkNTDBDataOK() {
        i.f360262a.d();
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendDataTransApi
    public d friendConvertToFriendsSimpleInfo(Friends friends, ExtensionInfo extensionInfo) {
        Intrinsics.checkNotNullParameter(friends, "friends");
        return GroupInfoHelper.INSTANCE.d(friends, extensionInfo);
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendDataTransApi
    public c friendsConvertToOnlineStatusInfo(Friends friends, boolean needUid) {
        String uid;
        Intrinsics.checkNotNullParameter(friends, "friends");
        String uin = friends.uin;
        if (needUid) {
            uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        } else {
            uid = "";
        }
        b bVar = b.f360117a;
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        return bVar.a(uin, uid, friends);
    }

    @Override // com.tencent.qqnt.ntrelation.api.IFriendDataTransApi
    public a SpecialInfoConvertToNTOtherDetailInfo(Friends friends, ExtensionInfo extensionInfo) {
        String str;
        Number number;
        if (friends != null) {
            str = friends.uin;
        } else {
            if (extensionInfo == null) {
                return null;
            }
            str = extensionInfo.uin;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        Manager manager = ((QQAppInterface) runtime).getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        SpecialCareInfo O = ((FriendsManager) manager).O(str);
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(friends != null ? friends.uin : null);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        String str2 = friends != null ? friends.uin : null;
        String str3 = str2 == null ? "" : str2;
        Boolean valueOf = Boolean.valueOf(extensionInfo != null ? extensionInfo.isAioShortcutBarOpen : true);
        int i3 = extensionInfo != null ? extensionInfo.isSharingLocation : 0;
        int i16 = extensionInfo != null ? extensionInfo.chatInputType : 0;
        long j3 = O != null ? O.dateTime : 0L;
        if (extensionInfo != null) {
            number = Integer.valueOf(extensionInfo.friendRingId);
        } else {
            number = 0L;
        }
        long longValue = number.longValue();
        int i17 = O != null ? O.specialRingSwitch : 0;
        int i18 = extensionInfo != null ? extensionInfo.showC2CPanel : 1;
        int i19 = extensionInfo != null ? extensionInfo.pttChangeVoiceType : 0;
        int i26 = extensionInfo != null ? extensionInfo.audioPanelType : -1;
        Boolean valueOf2 = Boolean.valueOf(extensionInfo != null ? extensionInfo.isDataChanged : false);
        int i27 = extensionInfo != null ? extensionInfo.hiddenChatSwitch : 0;
        long j16 = extensionInfo != null ? extensionInfo.latestPLUpdateTimestamp : 0L;
        long j17 = extensionInfo != null ? extensionInfo.lastPullPLNewsTimestamp : 0L;
        long j18 = extensionInfo != null ? extensionInfo.lastPLNewsTimestamp : 0L;
        long j19 = extensionInfo != null ? extensionInfo.lastIceBreakCheckTs : 0L;
        long j26 = extensionInfo != null ? extensionInfo.lastIceBreakChatTs : 0L;
        long j27 = extensionInfo != null ? extensionInfo.makeFrdsTs : 0L;
        long j28 = extensionInfo != null ? extensionInfo.topPositionTime : 0L;
        long j29 = extensionInfo != null ? extensionInfo.mTogetherBusinessFlag : 0L;
        long j36 = extensionInfo != null ? extensionInfo.colorRingId : 0L;
        long j37 = extensionInfo != null ? extensionInfo.timestamp : 0L;
        long j38 = extensionInfo != null ? extensionInfo.commingRingId : 0L;
        int i28 = extensionInfo != null ? extensionInfo.messageEnablePreviewNew : 0;
        int i29 = extensionInfo != null ? extensionInfo.messageEnableSoundNew : 0;
        int i36 = extensionInfo != null ? extensionInfo.messageEnableVibrateNew : 0;
        String str4 = friends != null ? friends.strMasterUin : null;
        if (str4 == null) {
            str4 = "";
        }
        return new a(uid, str3, valueOf, i3, i16, j3, longValue, i17, i18, i19, i26, valueOf2, i27, j16, j17, j18, j19, j26, j27, j28, j29, j36, j37, j38, i28, i29, i36, str4);
    }
}
