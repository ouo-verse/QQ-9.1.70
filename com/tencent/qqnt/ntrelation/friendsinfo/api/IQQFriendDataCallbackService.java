package com.tencent.qqnt.ntrelation.friendsinfo.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.b;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.c;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H&J\u0018\u0010\n\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\u0018\u0010\u000b\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\u0018\u0010\f\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J \u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH&J \u0010\u0012\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0002j\b\u0012\u0004\u0012\u00020\r`\u0004H&J(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH&J\u0018\u0010\u0017\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\bH&J(\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/api/IQQFriendDataCallbackService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "Lkotlin/collections/ArrayList;", "data", "", "allFriendsInfoToCallback", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "friendsCategoryInfoToCallback", "friendsCategoryUidsInfoToCallback", "friendsLetterCategoryUidsInfoToCallback", "", "trace", "Lhx3/b;", "iQueryGeneralDataCallback", "registerAnyFriendChangeUids", "allFriendUidsChangeToCallback", "Lcom/tencent/qqnt/ntrelation/constant/RelationListReqType;", "reqType", "registerCategoryInfoCallback", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "friendDetailInfoToCallback", "unregisterFriendCategoryInfoV2Callback", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IQQFriendDataCallbackService extends QRouteApi {
    void allFriendUidsChangeToCallback(@NotNull ArrayList<String> data);

    void allFriendsInfoToCallback(@NotNull ArrayList<d> data);

    void friendDetailInfoToCallback(@Nullable e<c> data);

    void friendsCategoryInfoToCallback(@Nullable e<b> data);

    void friendsCategoryUidsInfoToCallback(@Nullable e<b> data);

    void friendsLetterCategoryUidsInfoToCallback(@Nullable e<b> data);

    void registerAnyFriendChangeUids(@Nullable String trace, @NotNull hx3.b<String> iQueryGeneralDataCallback);

    void registerCategoryInfoCallback(@NotNull RelationListReqType reqType, @Nullable String trace, @NotNull hx3.b<b> iQueryGeneralDataCallback);

    void unregisterFriendCategoryInfoV2Callback(@NotNull RelationListReqType reqType, @Nullable String trace, @NotNull hx3.b<b> iQueryGeneralDataCallback);
}
