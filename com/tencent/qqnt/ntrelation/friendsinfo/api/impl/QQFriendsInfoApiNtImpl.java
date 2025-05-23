package com.tencent.qqnt.ntrelation.friendsinfo.api.impl;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bC\u0010DJ>\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH\u0016J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J8\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H\u0016J(\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H\u0016J(\u0010\u001e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0019H\u0016J8\u0010\u001e\u001a\u00020\f2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0019H\u0016J \u0010\u001f\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u0016J\u0012\u0010 \u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010!\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010#\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H\u0016J8\u0010%\u001a\u00020\f2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\"0\u0002j\b\u0012\u0004\u0012\u00020\"`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H\u0016J>\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J>\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J2\u0010*\u001a\u00020\f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019H\u0016J4\u0010/\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u00032\u0006\u0010,\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-H\u0016J:\u00102\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00032\u0006\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019H\u0016J \u00103\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\"0\u0019H\u0016J \u00104\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H\u0016J*\u00105\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u00032\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019H\u0016J:\u00107\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019H\u0016J0\u00108\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019H\u0016J:\u0010;\u001a\u00020\f2\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u0002j\b\u0012\u0004\u0012\u00020\u001d`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010-H\u0016J\u0018\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010=\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010>\u001a\u00020\"2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J&\u0010@\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H\u0016J(\u0010B\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010-H\u0016\u00a8\u0006E"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/api/impl/QQFriendsInfoApiNtImpl;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/api/IQQFriendsInfoApi;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "getFriendSimpleInfoWithUid", "uid", "Lhx3/a;", "iDeleteGeneralDataCallback", "", "deleteNTFriendSimpleInfo", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/a;", "getFriendsCategoryBaseInfo", "categoryId", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "getFriendsCategoryInfo", "Lcom/tencent/qqnt/ntrelation/constant/RelationListReqType;", "reqType", "", "isObserver", "forceUpdate", "Lhx3/b;", "iQueryGeneralDataCallback", "friendsCategoryCacheInfoV2", "unregisterFriendCategoryInfoV2Callback", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "getFriendsDetailInfoWithUid", "addChangeFriendUidsCallBack", "requestAllCategoriesInfo", "resetData", "", "getCategoryInfoWithCategoryId", "categoryIds", "getCategoryInfoListWithCategoryId", "getNickWithUid", "getRemarkWithUid", "srcGroupId", "dstGroupId", "moveGroup", "friendUid", "newGroupId", "Lhx3/c;", "iUpdateGeneralDataCallback", "moveFriendToNewGroup", "groupId", "uncommonlyUsedFrd", "addFriendToFriendList", "getGatheredFriendsCount", "isGetFriendListSuc", "changeBuddyOnline", "uidList", "doUnComUsed2Normal", "normal2UnComUsed", "ntFriendSimpleInfoList", "updateCallback", "accurateUpdateNTFriendDetailInfo", "getAllFriend", "isHasFriend", "getFriendCount", "tag", IProfileProtocolConst.PARAM_IS_FRIEND, "categoryName", "addCategoryV2", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class QQFriendsInfoApiNtImpl implements IQQFriendsInfoApi {
    static IPatchRedirector $redirector_;

    public QQFriendsInfoApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void accurateUpdateNTFriendDetailInfo(@NotNull ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> ntFriendSimpleInfoList, @Nullable String trace, @Nullable hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> updateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, ntFriendSimpleInfoList, trace, updateCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntFriendSimpleInfoList, "ntFriendSimpleInfoList");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void addCategoryV2(@NotNull String categoryName, @NotNull String tag, @Nullable hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, categoryName, tag, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(tag, "tag");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void addChangeFriendUidsCallBack(@Nullable String trace, @NotNull hx3.b<String> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void addFriendToFriendList(@NotNull String uid, int groupId, boolean uncommonlyUsedFrd, @Nullable String trace, @Nullable hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, uid, Integer.valueOf(groupId), Boolean.valueOf(uncommonlyUsedFrd), trace, iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void changeBuddyOnline(@Nullable String trace, @NotNull String uid, @Nullable hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, trace, uid, iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void deleteNTFriendSimpleInfo(@NotNull String uid, @Nullable String trace, @Nullable hx3.a<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> iDeleteGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uid, trace, iDeleteGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void doUnComUsed2Normal(@Nullable String trace, @NotNull ArrayList<String> uidList, @Nullable hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, trace, uidList, iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(uidList, "uidList");
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void friendsCategoryCacheInfoV2(@NotNull RelationListReqType reqType, boolean isObserver, @Nullable String trace, boolean forceUpdate, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, reqType, Boolean.valueOf(isObserver), trace, Boolean.valueOf(forceUpdate), iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(reqType, "reqType");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @NotNull
    public List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> getAllFriend(@Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (List) iPatchRedirector.redirect((short) 29, (Object) this, (Object) trace);
        }
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void getCategoryInfoListWithCategoryId(@NotNull ArrayList<Integer> categoryIds, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, categoryIds, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(categoryIds, "categoryIds");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void getCategoryInfoWithCategoryId(int categoryId, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(categoryId), trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public int getFriendCount(@Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this, (Object) trace)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @Nullable
    public ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> getFriendSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @NotNull
    public List<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> getFriendsCategoryBaseInfo(@Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) trace);
        }
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @Nullable
    public com.tencent.qqnt.ntrelation.friendsinfo.bean.b getFriendsCategoryInfo(@NotNull String categoryId, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) categoryId, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void getFriendsDetailInfoWithUid(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void getGatheredFriendsCount(@Nullable String trace, @NotNull hx3.b<Integer> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @Nullable
    public ArrayList<String> getNickWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ArrayList) iPatchRedirector.redirect((short) 16, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @Nullable
    public ArrayList<String> getRemarkWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ArrayList) iPatchRedirector.redirect((short) 18, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void isFriend(@NotNull String uid, @NotNull String tag, @NotNull hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, uid, tag, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void isGetFriendListSuc(@Nullable String trace, @NotNull hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public boolean isHasFriend(@NotNull String uid, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) uid, (Object) trace)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void moveFriendToNewGroup(@Nullable String friendUid, int newGroupId, @Nullable String trace, @Nullable hx3.c<Boolean> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, friendUid, Integer.valueOf(newGroupId), trace, iUpdateGeneralDataCallback);
            return;
        }
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void moveGroup(int srcGroupId, int dstGroupId, @Nullable String trace, @Nullable hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(srcGroupId), Integer.valueOf(dstGroupId), trace, iQueryGeneralDataCallback);
            return;
        }
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void normal2UnComUsed(@Nullable String trace, @NotNull List<String> uidList, @Nullable hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, trace, uidList, iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(uidList, "uidList");
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void requestAllCategoriesInfo(@Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) trace);
            return;
        }
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void resetData(@Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) trace);
            return;
        }
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void unregisterFriendCategoryInfoV2Callback(@NotNull RelationListReqType reqType, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, reqType, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(reqType, "reqType");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @Nullable
    public com.tencent.qqnt.ntrelation.friendsinfo.bean.a getFriendsCategoryBaseInfo(@NotNull String categoryId, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qqnt.ntrelation.friendsinfo.bean.a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) categoryId, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void getFriendsDetailInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, uids, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @Nullable
    public String getNickWithUid(@NotNull String uid, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) uid, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @Nullable
    public String getRemarkWithUid(@NotNull String uid, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, (Object) uid, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
