package com.tencent.qqnt.ntrelation.friendsinfo.api;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.a;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.c;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import hx3.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\bg\u0018\u00002\u00020\u0001J>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J*\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH&J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J8\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H&J(\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H&J(\u0010\u001e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0019H&J8\u0010\u001e\u001a\u00020\f2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0019H&J \u0010\u001f\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H&J\u0012\u0010 \u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010!\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J(\u0010#\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H&J8\u0010%\u001a\u00020\f2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\"0\u0002j\b\u0012\u0004\u0012\u00020\"`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H&J>\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J>\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J2\u0010*\u001a\u00020\f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019H&J4\u0010/\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u00032\u0006\u0010,\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-H&J:\u00102\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00032\u0006\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019H&J \u00103\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\"0\u0019H&J \u00104\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H&J*\u00105\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019H&J:\u00107\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019H&J0\u00108\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019H&J<\u0010;\u001a\u00020\f2\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u0002j\b\u0012\u0004\u0012\u00020\u001d`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010-H&J\u0018\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u001a\u0010=\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010>\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J&\u0010@\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H&J(\u0010B\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010-H&\u00a8\u0006C"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/api/IQQFriendsInfoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "getFriendSimpleInfoWithUid", "uid", "Lhx3/a;", "iDeleteGeneralDataCallback", "", "deleteNTFriendSimpleInfo", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/a;", "getFriendsCategoryBaseInfo", "categoryId", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "getFriendsCategoryInfo", "Lcom/tencent/qqnt/ntrelation/constant/RelationListReqType;", "reqType", "", "isObserver", "forceUpdate", "Lhx3/b;", "iQueryGeneralDataCallback", "friendsCategoryCacheInfoV2", "unregisterFriendCategoryInfoV2Callback", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "getFriendsDetailInfoWithUid", "addChangeFriendUidsCallBack", "requestAllCategoriesInfo", "resetData", "", "getCategoryInfoWithCategoryId", "categoryIds", "getCategoryInfoListWithCategoryId", "getNickWithUid", "getRemarkWithUid", "srcGroupId", "dstGroupId", "moveGroup", "friendUid", "newGroupId", "Lhx3/c;", "iUpdateGeneralDataCallback", "moveFriendToNewGroup", "groupId", "uncommonlyUsedFrd", "addFriendToFriendList", "getGatheredFriendsCount", "isGetFriendListSuc", "changeBuddyOnline", "uidList", "doUnComUsed2Normal", "normal2UnComUsed", "ntFriendSimpleInfoList", "updateCallback", "accurateUpdateNTFriendDetailInfo", "getAllFriend", "isHasFriend", "getFriendCount", "tag", IProfileProtocolConst.PARAM_IS_FRIEND, "categoryName", "addCategoryV2", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IQQFriendsInfoApi extends QRouteApi {
    void accurateUpdateNTFriendDetailInfo(@NotNull ArrayList<c> ntFriendSimpleInfoList, @Nullable String trace, @Nullable hx3.c<c> updateCallback);

    void addCategoryV2(@NotNull String categoryName, @NotNull String tag, @Nullable hx3.c<a> iUpdateGeneralDataCallback);

    void addChangeFriendUidsCallBack(@Nullable String trace, @NotNull b<String> iQueryGeneralDataCallback);

    void addFriendToFriendList(@NotNull String uid, int groupId, boolean uncommonlyUsedFrd, @Nullable String trace, @Nullable b<Boolean> iQueryGeneralDataCallback);

    void changeBuddyOnline(@Nullable String trace, @NotNull String uid, @Nullable b<Boolean> iQueryGeneralDataCallback);

    void deleteNTFriendSimpleInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<d> iDeleteGeneralDataCallback);

    void doUnComUsed2Normal(@Nullable String trace, @NotNull ArrayList<String> uidList, @Nullable b<Boolean> iQueryGeneralDataCallback);

    void friendsCategoryCacheInfoV2(@NotNull RelationListReqType reqType, boolean isObserver, @Nullable String trace, boolean forceUpdate, @NotNull b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback);

    @NotNull
    List<d> getAllFriend(@Nullable String trace);

    void getCategoryInfoListWithCategoryId(@NotNull ArrayList<Integer> categoryIds, @Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback);

    void getCategoryInfoWithCategoryId(int categoryId, @Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback);

    int getFriendCount(@Nullable String trace);

    @Nullable
    ArrayList<d> getFriendSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace);

    @Nullable
    a getFriendsCategoryBaseInfo(@NotNull String categoryId, @Nullable String trace);

    @NotNull
    List<a> getFriendsCategoryBaseInfo(@Nullable String trace);

    @Nullable
    com.tencent.qqnt.ntrelation.friendsinfo.bean.b getFriendsCategoryInfo(@NotNull String categoryId, @Nullable String trace);

    void getFriendsDetailInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull b<c> iQueryGeneralDataCallback);

    void getFriendsDetailInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace, @NotNull b<c> iQueryGeneralDataCallback);

    void getGatheredFriendsCount(@Nullable String trace, @NotNull b<Integer> iQueryGeneralDataCallback);

    @Nullable
    String getNickWithUid(@NotNull String uid, @Nullable String trace);

    @Nullable
    ArrayList<String> getNickWithUid(@NotNull ArrayList<String> uids, @Nullable String trace);

    @Nullable
    String getRemarkWithUid(@NotNull String uid, @Nullable String trace);

    @Nullable
    ArrayList<String> getRemarkWithUid(@NotNull ArrayList<String> uids, @Nullable String trace);

    void isFriend(@NotNull String uid, @NotNull String tag, @NotNull b<Boolean> iQueryGeneralDataCallback);

    void isGetFriendListSuc(@Nullable String trace, @NotNull b<Boolean> iQueryGeneralDataCallback);

    boolean isHasFriend(@NotNull String uid, @Nullable String trace);

    void moveFriendToNewGroup(@Nullable String friendUid, int newGroupId, @Nullable String trace, @Nullable hx3.c<Boolean> iUpdateGeneralDataCallback);

    void moveGroup(int srcGroupId, int dstGroupId, @Nullable String trace, @Nullable b<Boolean> iQueryGeneralDataCallback);

    void normal2UnComUsed(@Nullable String trace, @NotNull List<String> uidList, @Nullable b<Boolean> iQueryGeneralDataCallback);

    void requestAllCategoriesInfo(@Nullable String trace);

    void resetData(@Nullable String trace);

    void unregisterFriendCategoryInfoV2Callback(@NotNull RelationListReqType reqType, @Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback);
}
