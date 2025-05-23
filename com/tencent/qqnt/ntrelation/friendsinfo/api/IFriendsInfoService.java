package com.tencent.qqnt.ntrelation.friendsinfo.api;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.a;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.c;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import hx3.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010$\n\u0002\b\u000e\bg\u0018\u0000 X2\u00020\u0001:\u0001YJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0002H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0002H&J>\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J>\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J>\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J,\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015H&J<\u0010\u0017\u001a\u00020\u00062\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00110\fj\b\u0012\u0004\u0012\u00020\u0011`\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015H&J<\u0010\u001b\u001a\u00020\u00062\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00190\fj\b\u0012\u0004\u0012\u00020\u0019`\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0015H&J*\u0010\u001e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001cH&J(\u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H&J8\u0010&\u001a\u00020\u00062\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\fj\b\u0012\u0004\u0012\u00020\u001f`\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H&J\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00110'2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020)0'2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010,\u001a\u0004\u0018\u00010\"2\u0006\u0010 \u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J0\u0010/\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010.\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H'J \u00100\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H&J8\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u0002012\u0006\u0010-\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010.\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H&J(\u00104\u001a\u00020\u00062\u0006\u00102\u001a\u0002012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H&J(\u00105\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190!H&J8\u00105\u001a\u00020\u00062\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190!H&J0\u00105\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190!H&J \u00107\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020!H&J\u0012\u00108\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J2\u0010;\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!H&J4\u0010?\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010\u00022\u0006\u0010=\u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H&J:\u0010B\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!H&J \u0010C\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0!H&J \u0010D\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040!H&J*\u0010E\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!H&J:\u0010F\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\r2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!H&J0\u0010G\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020'2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!H&J\u001a\u0010H\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010I\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010J\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J4\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040L2\u0006\u0010K\u001a\u00020\u00022\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\fj\b\u0012\u0004\u0012\u00020\u0002`\rH&J\u0018\u0010O\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u0002H&J(\u0010P\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190!H&J\u0018\u0010Q\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u0002H&J\u0018\u0010R\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010S\u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J!\u0010T\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\bT\u0010UJ&\u0010J\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040!H&J(\u0010W\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00022\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u0015H&\u00a8\u0006Z"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/api/IFriendsInfoService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "trace", "", "forceInit", "", "initFriendsInfoListener", "uin", "getUidFromUin", "uid", "getUinFromUid", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uids", "getNickWithUid", "getRemarkWithUid", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "getFriendSimpleInfoWithUid", "getFriendsSimpleInfoWithUid", "ntFriendSimpleInfo", "Lhx3/c;", "updateCallback", "accurateUpdateNTFriendSimpleInfo", "ntFriendSimpleInfoList", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "ntFriendDetailInfoList", "accurateUpdateNTFriendDetailInfo", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteNTFriendSimpleInfo", "", "categoryId", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "iQueryGeneralDataCallback", "getCategoryInfoWithCategoryId", "categoryIds", "getCategoryInfoListWithCategoryId", "", "getAllFriend", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/a;", "getFriendsCategoryBaseInfo", "cateogryId", "getFriendsCategoryInfo", "isObserver", "forceUpdate", "friendsCategoryInfo", "unregisterFriendCategoryInfoCallback", "Lcom/tencent/qqnt/ntrelation/constant/RelationListReqType;", "reqType", "friendsCategoryCacheInfoV2", "unregisterFriendCategoryInfoV2Callback", "getFriendsDetailInfoWithUid", "uidList", "addChangeFriendUidsCallBack", "requestAllCategoriesInfo", "srcGroupId", "dstGroupId", "moveGroup", "friendUid", "newGroupId", "iUpdateGeneralDataCallback", "moveFriendToNewGroup", "groupId", "uncommonlyUsedFrd", "addFriendToFriendList", "getGatheredFriendsCount", "isGetFriendListSuc", "changeBuddyOnline", "doUnComUsed2Normal", "normal2UnComUsed", "isValidUin", "isValidUid", IProfileProtocolConst.PARAM_IS_FRIEND, "callFrom", "", "isFriends", "tag", "isShieldFriend", "getControlGroupFriendsDetailInfoWithUid", "getSpecialCareGlobalSwitch", "isHasFriend", "getFriendCount", "getRingId", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "categoryName", "addCategory", "Companion", "a", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IFriendsInfoService extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "IFriendsInfoService";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/api/IFriendsInfoService$a;", "", "<init>", "()V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f359919a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37290);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f359919a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(37295), (Class<?>) IFriendsInfoService.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f359919a;
        }
    }

    void accurateUpdateNTFriendDetailInfo(@NotNull ArrayList<c> ntFriendDetailInfoList, @Nullable String trace, @Nullable hx3.c<c> updateCallback);

    void accurateUpdateNTFriendSimpleInfo(@NotNull d ntFriendSimpleInfo, @Nullable String trace, @Nullable hx3.c<d> updateCallback);

    void accurateUpdateNTFriendSimpleInfo(@NotNull ArrayList<d> ntFriendSimpleInfoList, @Nullable String trace, @Nullable hx3.c<d> updateCallback);

    void addCategory(@NotNull String categoryName, @NotNull String tag, @Nullable hx3.c<a> iUpdateGeneralDataCallback);

    void addChangeFriendUidsCallBack(@Nullable String trace, @NotNull b<String> iQueryGeneralDataCallback);

    void addFriendToFriendList(@NotNull String uid, int groupId, boolean uncommonlyUsedFrd, @Nullable String trace, @Nullable b<Boolean> iQueryGeneralDataCallback);

    void changeBuddyOnline(@Nullable String trace, @NotNull String uid, @Nullable b<Boolean> iQueryGeneralDataCallback);

    void deleteNTFriendSimpleInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<d> iDeleteGeneralDataCallback);

    void doUnComUsed2Normal(@Nullable String trace, @NotNull ArrayList<String> uidList, @Nullable b<Boolean> iQueryGeneralDataCallback);

    void friendsCategoryCacheInfoV2(@NotNull RelationListReqType reqType, boolean isObserver, @Nullable String trace, boolean forceUpdate, @NotNull b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback);

    @Deprecated(level = DeprecationLevel.WARNING, message = TAG, replaceWith = @ReplaceWith(expression = "friendsCategoryCacheInfoV2", imports = {}))
    void friendsCategoryInfo(boolean isObserver, @Nullable String trace, boolean forceUpdate, @NotNull b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback);

    @NotNull
    List<d> getAllFriend(@Nullable String trace);

    void getCategoryInfoListWithCategoryId(@NotNull ArrayList<Integer> categoryIds, @Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback);

    void getCategoryInfoWithCategoryId(int categoryId, @Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback);

    void getControlGroupFriendsDetailInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull b<c> iQueryGeneralDataCallback);

    int getFriendCount(@Nullable String trace);

    @Nullable
    ArrayList<d> getFriendSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace);

    @Nullable
    a getFriendsCategoryBaseInfo(@NotNull String cateogryId, @Nullable String trace);

    @NotNull
    List<a> getFriendsCategoryBaseInfo(@Nullable String trace);

    @Nullable
    com.tencent.qqnt.ntrelation.friendsinfo.bean.b getFriendsCategoryInfo(@NotNull String categoryId, @Nullable String trace);

    void getFriendsDetailInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull b<c> iQueryGeneralDataCallback);

    void getFriendsDetailInfoWithUid(@NotNull String uid, boolean isObserver, @Nullable String trace, @NotNull b<c> iQueryGeneralDataCallback);

    void getFriendsDetailInfoWithUid(@NotNull ArrayList<String> uidList, @Nullable String trace, @NotNull b<c> iQueryGeneralDataCallback);

    @Nullable
    d getFriendsSimpleInfoWithUid(@NotNull String uid, @Nullable String trace);

    void getGatheredFriendsCount(@Nullable String trace, @NotNull b<Integer> iQueryGeneralDataCallback);

    @Nullable
    String getNickWithUid(@NotNull String uid, @Nullable String trace);

    @Nullable
    ArrayList<String> getNickWithUid(@NotNull ArrayList<String> uids, @Nullable String trace);

    @Nullable
    String getRemarkWithUid(@NotNull String uid, @Nullable String trace);

    @Nullable
    ArrayList<String> getRemarkWithUid(@NotNull ArrayList<String> uids, @Nullable String trace);

    @Nullable
    Integer getRingId(@NotNull String uid, @NotNull String trace);

    boolean getSpecialCareGlobalSwitch(@NotNull String uid, @NotNull String tag);

    @Nullable
    String getUidFromUin(@NotNull String uin);

    @Nullable
    String getUinFromUid(@NotNull String uid);

    void initFriendsInfoListener(@Nullable String trace, boolean forceInit);

    void isFriend(@NotNull String uid, @NotNull String tag, @NotNull b<Boolean> iQueryGeneralDataCallback);

    boolean isFriend(@NotNull String uid, @Nullable String trace);

    @NotNull
    Map<String, Boolean> isFriends(@NotNull String callFrom, @NotNull ArrayList<String> uids);

    void isGetFriendListSuc(@Nullable String trace, @NotNull b<Boolean> iQueryGeneralDataCallback);

    boolean isHasFriend(@NotNull String uid, @NotNull String trace);

    boolean isShieldFriend(@NotNull String uid, @NotNull String tag);

    boolean isValidUid(@NotNull String uid, @Nullable String trace);

    boolean isValidUin(@NotNull String uin, @Nullable String trace);

    void moveFriendToNewGroup(@Nullable String friendUid, int newGroupId, @Nullable String trace, @Nullable hx3.c<Boolean> iUpdateGeneralDataCallback);

    void moveGroup(int srcGroupId, int dstGroupId, @Nullable String trace, @Nullable b<Boolean> iQueryGeneralDataCallback);

    void normal2UnComUsed(@Nullable String trace, @NotNull List<String> uidList, @Nullable b<Boolean> iQueryGeneralDataCallback);

    void requestAllCategoriesInfo(@Nullable String trace);

    void unregisterFriendCategoryInfoCallback(@Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback);

    void unregisterFriendCategoryInfoV2Callback(@NotNull RelationListReqType reqType, @Nullable String trace, @NotNull b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback);
}
