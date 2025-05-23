package com.tencent.qqnt.ntrelation.api;

import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import com.tencent.qqnt.ntrelation.otherinfo.bean.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0013\u001a\u00020\u0012H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/ntrelation/api/IFriendDataTransApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/data/Friends;", "friends", "", "needUid", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "friendsConvertToOnlineStatusInfo", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "Lkotlin/collections/ArrayList;", "allFriendsConvertToFriendsSimpleInfo", "Lcom/tencent/mobileqq/data/ExtensionInfo;", "extensionInfo", "friendConvertToFriendsSimpleInfo", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "SpecialInfoConvertToNTOtherDetailInfo", "", "checkNTDBDataOK", "relation-common-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IFriendDataTransApi extends QRouteApi {
    @Nullable
    a SpecialInfoConvertToNTOtherDetailInfo(@Nullable Friends friends, @Nullable ExtensionInfo extensionInfo);

    @NotNull
    ArrayList<d> allFriendsConvertToFriendsSimpleInfo(@NotNull List<? extends Friends> friends);

    void checkNTDBDataOK();

    @NotNull
    d friendConvertToFriendsSimpleInfo(@NotNull Friends friends, @Nullable ExtensionInfo extensionInfo);

    @NotNull
    c friendsConvertToOnlineStatusInfo(@NotNull Friends friends, boolean needUid);
}
