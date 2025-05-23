package com.tencent.qqnt.ntrelation.friendsinfo.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.contacts.cache.FriendListInfoCache;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.BuddyListCategory;
import com.tencent.qqnt.kernel.nativeinterface.BuddyListReqType;
import com.tencent.qqnt.kernel.nativeinterface.IBuddyListCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICheckIsBuddyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IModifyCategoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ProfileBizType;
import com.tencent.qqnt.kernel.nativeinterface.RelationFlag;
import com.tencent.qqnt.kernel.nativeinterface.Source;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.StockLocalData;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$UpdateMsg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 G2\u00020\u0001:\u0001HB\u0007\u00a2\u0006\u0004\bE\u0010FJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J>\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J*\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eH\u0016J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J8\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bH\u0016J(\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bH\u0016J(\u0010 \u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001bH\u0016J8\u0010 \u001a\u00020\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001bH\u0016J \u0010!\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bH\u0016J\u0012\u0010\"\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010#\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J(\u0010%\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020$2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bH\u0016J8\u0010'\u001a\u00020\u00062\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020$0\bj\b\u0012\u0004\u0012\u00020$`\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bH\u0016J>\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J>\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010)\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J2\u0010,\u001a\u00020\u00062\u0006\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020$2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bH\u0016J4\u00101\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010.\u001a\u00020$2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010/H\u0016J:\u00104\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bH\u0016J \u00105\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020$0\u001bH\u0016J \u00106\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0016J*\u00107\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bH\u0016J:\u00109\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bH\u0016J0\u0010:\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bH\u0016J:\u0010=\u001a\u00020\u00062\u0016\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\bj\b\u0012\u0004\u0012\u00020\u001f`\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010/H\u0016J\u0018\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010?\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010@\u001a\u00020$2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010B\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0016J(\u0010D\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00042\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010/H\u0016\u00a8\u0006I"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/api/impl/NTFriendsInfoApiImpl;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/api/IQQFriendsInfoApi;", "", "isPullRefresh", "", "trace", "", "requestFriendListFromNT", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uids", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "getFriendSimpleInfoWithUid", "uid", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteNTFriendSimpleInfo", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/a;", "getFriendsCategoryBaseInfo", "categoryId", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "getFriendsCategoryInfo", "Lcom/tencent/qqnt/ntrelation/constant/RelationListReqType;", "reqType", "isObserver", "forceUpdate", "Lhx3/b;", "iQueryGeneralDataCallback", "friendsCategoryCacheInfoV2", "unregisterFriendCategoryInfoV2Callback", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "getFriendsDetailInfoWithUid", "addChangeFriendUidsCallBack", "requestAllCategoriesInfo", "resetData", "", "getCategoryInfoWithCategoryId", "categoryIds", "getCategoryInfoListWithCategoryId", "getNickWithUid", "getRemarkWithUid", "srcGroupId", "dstGroupId", "moveGroup", "friendUid", "newGroupId", "Lhx3/c;", "iUpdateGeneralDataCallback", "moveFriendToNewGroup", "groupId", "uncommonlyUsedFrd", "addFriendToFriendList", "getGatheredFriendsCount", "isGetFriendListSuc", "changeBuddyOnline", "uidList", "doUnComUsed2Normal", "normal2UnComUsed", "ntFriendDetailInfoArrayList", "updateCallback", "accurateUpdateNTFriendDetailInfo", "getAllFriend", "isHasFriend", "getFriendCount", "tag", IProfileProtocolConst.PARAM_IS_FRIEND, "categoryName", "addCategoryV2", "<init>", "()V", "Companion", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class NTFriendsInfoApiImpl implements IQQFriendsInfoApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "NTFriendsInfoApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/api/impl/NTFriendsInfoApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.NTFriendsInfoApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36697);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTFriendsInfoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accurateUpdateNTFriendDetailInfo$lambda$11(final ArrayList ntFriendDetailInfoArrayList, final String str, final hx3.c cVar, int i3, String str2) {
        Intrinsics.checkNotNullParameter(ntFriendDetailInfoArrayList, "$ntFriendDetailInfoArrayList");
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        if (i3 == 0) {
            eVar.d(0);
        } else {
            eVar.d(-1);
        }
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        eVar.f(str2);
        eVar.e(ntFriendDetailInfoArrayList);
        y f16 = com.tencent.qqnt.msg.f.f();
        if (f16 != null) {
            if (str != null) {
                str3 = str;
            }
            f16.updateStockLocalData(str3, com.tencent.qqnt.ntrelation.util.c.f360229a.c(ntFriendDetailInfoArrayList), new IOperateCallback() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str4) {
                    NTFriendsInfoApiImpl.accurateUpdateNTFriendDetailInfo$lambda$11$lambda$10(ntFriendDetailInfoArrayList, str, cVar, eVar, i16, str4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accurateUpdateNTFriendDetailInfo$lambda$11$lambda$10(ArrayList ntFriendDetailInfoArrayList, String str, hx3.c cVar, com.tencent.qqnt.ntrelation.friendsinfo.bean.e responseData, int i3, String str2) {
        Intrinsics.checkNotNullParameter(ntFriendDetailInfoArrayList, "$ntFriendDetailInfoArrayList");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        if (i3 == 0) {
            com.tencent.qqnt.ntrelation.util.c.f360229a.b(ntFriendDetailInfoArrayList, str);
        }
        if (cVar != null) {
            cVar.onUpdateResult(responseData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addCategoryV2$lambda$13(hx3.c cVar, int i3, String errMsg, byte[] bArr, String str, int i16) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        ArrayList arrayList = new ArrayList();
        if (i3 == 0) {
            eVar.d(0);
            com.tencent.qqnt.ntrelation.friendsinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.a(0, null, 0, 0, (byte) 0, 31, null);
            aVar.e(i16);
            aVar.f(str);
            arrayList.add(aVar);
            eVar.e(arrayList);
        } else {
            eVar.d(-1);
        }
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        eVar.f(errMsg);
        if (cVar != null) {
            cVar.onUpdateResult(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCategoryInfoListWithCategoryId$lambda$5(ArrayList categoryIds, NTFriendsInfoApiImpl this$0, String str, hx3.b iQueryGeneralDataCallback) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.b friendsCategoryInfo;
        Intrinsics.checkNotNullParameter(categoryIds, "$categoryIds");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        ArrayList arrayList = new ArrayList();
        Iterator it = categoryIds.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num != null && (friendsCategoryInfo = this$0.getFriendsCategoryInfo(String.valueOf(num.intValue()), str)) != null) {
                arrayList.add(friendsCategoryInfo);
            }
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        if (arrayList.isEmpty()) {
            eVar.d(-1);
        } else {
            eVar.d(0);
            eVar.e(arrayList);
        }
        iQueryGeneralDataCallback.onQueryResult(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriendsDetailInfoWithUid$lambda$3(hx3.b iQueryGeneralDataCallback, ArrayList uids, String str, HashMap hashMap, int i3, String errMsg, Source source, HashMap hashMap2) {
        String str2;
        UserDetailInfo userDetailInfo;
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        Intrinsics.checkNotNullParameter(uids, "$uids");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        if (i3 != 0) {
            QLog.i(TAG, 1, "getFriendsDetailInfoWithUid errMsg: " + errMsg);
            eVar.d(-1);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            eVar.f(errMsg);
            iQueryGeneralDataCallback.onQueryResult(eVar);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = uids.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            com.tencent.qqnt.ntrelation.util.c cVar = com.tencent.qqnt.ntrelation.util.c.f360229a;
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            StockLocalData stockLocalData = null;
            if (hashMap2 != null) {
                userDetailInfo = (UserDetailInfo) hashMap2.get(str3);
            } else {
                userDetailInfo = null;
            }
            if (hashMap != null) {
                stockLocalData = (StockLocalData) hashMap.get(str3);
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.c e16 = cVar.e(str2, userDetailInfo, stockLocalData);
            if (e16 != null) {
                arrayList.add(e16);
            }
        }
        eVar.e(arrayList);
        iQueryGeneralDataCallback.onQueryResult(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isFriend$lambda$12(String uid, hx3.b iQueryGeneralDataCallback, String str, boolean z16) {
        Intrinsics.checkNotNullParameter(uid, "$uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        if (str != null && str.equals(uid)) {
            eVar.d(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(Boolean.valueOf(z16));
            eVar.e(arrayList);
        } else {
            eVar.d(-1);
        }
        iQueryGeneralDataCallback.onQueryResult(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moveFriendToNewGroup$lambda$9(hx3.c cVar, int i3, String str) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        ArrayList arrayList = new ArrayList();
        if (i3 == 0) {
            eVar.d(0);
            arrayList.add(Boolean.TRUE);
        } else {
            eVar.d(-1);
            if (str == null) {
                str = "";
            }
            eVar.f(str);
            arrayList.add(Boolean.FALSE);
        }
        eVar.e(arrayList);
        if (cVar != null) {
            cVar.onUpdateResult(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moveGroup$lambda$8(hx3.b bVar, int i3, String str) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        ArrayList arrayList = new ArrayList();
        if (i3 == 0) {
            eVar.d(0);
            arrayList.add(Boolean.TRUE);
        } else {
            eVar.d(-1);
            if (str == null) {
                str = "";
            }
            eVar.f(str);
            arrayList.add(Boolean.FALSE);
        }
        eVar.e(arrayList);
        if (bVar != null) {
            bVar.onQueryResult(eVar);
        }
    }

    private final void requestFriendListFromNT(boolean isPullRefresh, String trace) {
        if (!isPullRefresh) {
            QLog.e(TAG, 1, "requestFriendListFromNT isPullRefresh is false, trace: " + trace);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "requestFriendListFromNT app == null  trace: " + trace);
            return;
        }
        com.tencent.qqnt.kernel.api.m buddyService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getBuddyService();
        if (buddyService == null) {
            QLog.e(TAG, 1, "requestFriendListFromNT buddyService == null  trace: " + trace);
            return;
        }
        buddyService.getBuddyListV2("requestFriendListFromNT--" + trace, true, com.tencent.qqnt.ntrelation.constant.a.f359917a.a(RelationListReqType.NORMAL), new IBuddyListCallback() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IBuddyListCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                NTFriendsInfoApiImpl.requestFriendListFromNT$lambda$4(i3, str, arrayList);
            }
        });
        y f16 = com.tencent.qqnt.msg.f.f();
        if (f16 != null) {
            f16.startStatusPolling(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestFriendListFromNT$lambda$4(int i3, String str, ArrayList arrayList) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "requestFriendListFromNT result:" + i3 + " errMsg:" + str);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void accurateUpdateNTFriendDetailInfo(@NotNull final ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> ntFriendDetailInfoArrayList, @Nullable final String trace, @Nullable final hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> updateCallback) {
        String str;
        byte[] bArr;
        y f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, ntFriendDetailInfoArrayList, trace, updateCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(ntFriendDetailInfoArrayList, "ntFriendDetailInfoArrayList");
        com.tencent.qqnt.ntrelation.util.c cVar = com.tencent.qqnt.ntrelation.util.c.f360229a;
        String str2 = "";
        if (trace == null) {
            str = "";
        } else {
            str = trace;
        }
        ProfileUpdateMsg$UpdateMsg a16 = cVar.a(str, ntFriendDetailInfoArrayList);
        if (a16 != null) {
            bArr = a16.toByteArray();
        } else {
            bArr = null;
        }
        if (bArr != null && (f16 = com.tencent.qqnt.msg.f.f()) != null) {
            if (trace != null) {
                str2 = trace;
            }
            f16.updateProfileData(str2, bArr, new IOperateCallback() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str3) {
                    NTFriendsInfoApiImpl.accurateUpdateNTFriendDetailInfo$lambda$11(ntFriendDetailInfoArrayList, trace, updateCallback, i3, str3);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void addCategoryV2(@NotNull String categoryName, @NotNull String tag, @Nullable final hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> iUpdateGeneralDataCallback) {
        com.tencent.qqnt.kernel.api.m b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, categoryName, tag, iUpdateGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (iUpdateGeneralDataCallback != null && (b16 = com.tencent.qqnt.msg.f.b()) != null) {
            b16.addCategoryV2(categoryName, null, new IModifyCategoryCallback() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IModifyCategoryCallback
                public final void onResult(int i3, String str, byte[] bArr, String str2, int i16) {
                    NTFriendsInfoApiImpl.addCategoryV2$lambda$13(hx3.c.this, i3, str, bArr, str2, i16);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void addChangeFriendUidsCallBack(@Nullable String trace, @NotNull hx3.b<String> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
            com.tencent.qqnt.ntrelation.friendsinfo.manager.c.f360050a.d(trace, iQueryGeneralDataCallback);
        }
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
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
            com.tencent.qqnt.ntrelation.util.f.f360260a.b(uid, trace, iDeleteGeneralDataCallback);
        }
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
        com.tencent.qqnt.ntrelation.friendsinfo.manager.c.f360050a.e(reqType, isObserver, trace, forceUpdate, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @NotNull
    public List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> getAllFriend(@Nullable String trace) {
        List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (List) iPatchRedirector.redirect((short) 29, (Object) this, (Object) trace);
        }
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 != null) {
            ArrayList<BuddyListCategory> buddyListFromCache = b16.getBuddyListFromCache("getAllFriend--" + trace, BuddyListReqType.KNOMAL);
            if (buddyListFromCache != null) {
                ArrayList arrayList = new ArrayList();
                int specialCareCategoryId = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getSpecialCareCategoryId();
                Iterator<BuddyListCategory> it = buddyListFromCache.iterator();
                while (it.hasNext()) {
                    BuddyListCategory next = it.next();
                    if (next.categoryId != specialCareCategoryId) {
                        ArrayList<String> arrayList2 = next.buddyUids;
                        Intrinsics.checkNotNullExpressionValue(arrayList2, "kernelInfo.buddyUids");
                        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = getFriendSimpleInfoWithUid(arrayList2, trace);
                        if (friendSimpleInfoWithUid != null) {
                            arrayList.addAll(friendSimpleInfoWithUid);
                        }
                    }
                }
                return arrayList;
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void getCategoryInfoListWithCategoryId(@NotNull final ArrayList<Integer> categoryIds, @Nullable final String trace, @NotNull final hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, categoryIds, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(categoryIds, "categoryIds");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                NTFriendsInfoApiImpl.getCategoryInfoListWithCategoryId$lambda$5(categoryIds, this, trace, iQueryGeneralDataCallback);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void getCategoryInfoWithCategoryId(int categoryId, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(categoryId), trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(categoryId));
        getCategoryInfoListWithCategoryId(arrayList, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public int getFriendCount(@Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this, (Object) trace)).intValue();
        }
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 != null) {
            return b16.getAllBuddyCount();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @Nullable
    public ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> getFriendSimpleInfoWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        String str;
        HashMap<String, StockLocalData> hashMap;
        HashMap<String, StatusInfo> hashMap2;
        HashMap<String, RelationFlag> hashMap3;
        StatusInfo statusInfo;
        RelationFlag relationFlag;
        String str2;
        StockLocalData stockLocalData;
        String str3;
        String str4;
        String str5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<String> it = uids.iterator();
        while (it.hasNext()) {
            String uid = it.next();
            FriendListInfoCache a16 = FriendListInfoCache.INSTANCE.a();
            String a17 = com.tencent.qqnt.contacts.cache.a.f355804a.a();
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            Object k3 = a16.k(a17, uid, trace);
            if (k3 != null && (k3 instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d)) {
                ((com.tencent.qqnt.ntrelation.friendsinfo.bean.d) k3).g0(System.currentTimeMillis());
                arrayList.add(k3);
            } else {
                arrayList2.add(uid);
            }
        }
        boolean z16 = true;
        if (!arrayList2.isEmpty()) {
            y f16 = com.tencent.qqnt.msg.f.f();
            if (f16 != null) {
                if (trace == null) {
                    str = "";
                } else {
                    str = trace;
                }
                HashMap<String, UserSimpleInfo> coreAndBaseInfo = f16.getCoreAndBaseInfo(str, arrayList2);
                if (coreAndBaseInfo != null) {
                    y f17 = com.tencent.qqnt.msg.f.f();
                    if (f17 != null) {
                        if (trace == null) {
                            str5 = "";
                        } else {
                            str5 = trace;
                        }
                        hashMap = f17.getStockLocalData(str5, arrayList2);
                    } else {
                        hashMap = null;
                    }
                    y f18 = com.tencent.qqnt.msg.f.f();
                    if (f18 != null) {
                        if (trace == null) {
                            str4 = "";
                        } else {
                            str4 = trace;
                        }
                        hashMap2 = f18.getStatusInfo(str4, arrayList2);
                    } else {
                        hashMap2 = null;
                    }
                    y f19 = com.tencent.qqnt.msg.f.f();
                    if (f19 != null) {
                        if (trace == null) {
                            str3 = "";
                        } else {
                            str3 = trace;
                        }
                        hashMap3 = f19.getRelationFlag(str3, arrayList2);
                    } else {
                        hashMap3 = null;
                    }
                    for (Map.Entry<String, UserSimpleInfo> entry : coreAndBaseInfo.entrySet()) {
                        String key = entry.getKey();
                        UserSimpleInfo value = entry.getValue();
                        if (value != null) {
                            if (hashMap2 != null) {
                                statusInfo = hashMap2.get(key);
                            } else {
                                statusInfo = null;
                            }
                            value.status = statusInfo;
                            if (hashMap3 != null) {
                                relationFlag = hashMap3.get(key);
                            } else {
                                relationFlag = null;
                            }
                            value.relationFlags = relationFlag;
                            com.tencent.qqnt.ntrelation.util.c cVar = com.tencent.qqnt.ntrelation.util.c.f360229a;
                            if (trace == null) {
                                str2 = "";
                            } else {
                                str2 = trace;
                            }
                            if (hashMap != null) {
                                stockLocalData = hashMap.get(key);
                            } else {
                                stockLocalData = null;
                            }
                            com.tencent.qqnt.ntrelation.friendsinfo.bean.d f26 = cVar.f(str2, key, value, stockLocalData);
                            if (f26 != null) {
                                arrayList.add(f26);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        z16 = false;
        if (z16) {
            com.tencent.qqnt.ntrelation.friendsinfo.util.a.f360077a.d(trace + "-kernel", arrayList);
        } else {
            com.tencent.qqnt.ntrelation.friendsinfo.util.a.f360077a.d(trace, arrayList);
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @NotNull
    public List<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> getFriendsCategoryBaseInfo(@Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) trace);
        }
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 != null) {
            ArrayList<BuddyListCategory> buddyListFromCache = b16.getBuddyListFromCache("getFriendsCategoryBaseInfo1--" + trace, BuddyListReqType.KNOMAL);
            if (buddyListFromCache != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<BuddyListCategory> it = buddyListFromCache.iterator();
                while (it.hasNext()) {
                    BuddyListCategory next = it.next();
                    arrayList.add(new com.tencent.qqnt.ntrelation.friendsinfo.bean.a(next.getCategoryId(), next.getCategroyName(), next.getCategroyMbCount(), next.getOnlineCount(), (byte) next.getCategorySortId()));
                }
                return arrayList;
            }
        }
        return new ArrayList();
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @Nullable
    public com.tencent.qqnt.ntrelation.friendsinfo.bean.b getFriendsCategoryInfo(@NotNull String categoryId, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.ntrelation.friendsinfo.bean.b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) categoryId, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 != null) {
            ArrayList<BuddyListCategory> buddyListFromCache = b16.getBuddyListFromCache("getFriendsCategoryInfo--" + trace, BuddyListReqType.KNOMAL);
            if (buddyListFromCache != null) {
                Iterator<BuddyListCategory> it = buddyListFromCache.iterator();
                while (it.hasNext()) {
                    BuddyListCategory next = it.next();
                    if (next.categoryId == Integer.parseInt(categoryId)) {
                        ArrayList<String> buddyUids = next.getBuddyUids();
                        Intrinsics.checkNotNullExpressionValue(buddyUids, "buddyCategory.getBuddyUids()");
                        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = getFriendSimpleInfoWithUid(buddyUids, trace);
                        int i3 = next.categoryId;
                        String str = next.categroyName;
                        int categroyMbCount = next.getCategroyMbCount();
                        int onlineCount = next.getOnlineCount();
                        byte categorySortId = (byte) next.getCategorySortId();
                        if (friendSimpleInfoWithUid == null) {
                            friendSimpleInfoWithUid = new ArrayList<>();
                        }
                        ArrayList<String> buddyUids2 = next.getBuddyUids();
                        Intrinsics.checkNotNullExpressionValue(buddyUids2, "buddyCategory.getBuddyUids()");
                        return new com.tencent.qqnt.ntrelation.friendsinfo.bean.b(i3, str, categroyMbCount, onlineCount, categorySortId, friendSimpleInfoWithUid, buddyUids2);
                    }
                }
            }
        }
        return null;
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
        getFriendsDetailInfoWithUid(new ArrayList<>(Collections.singletonList(uid)), trace, iQueryGeneralDataCallback);
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
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = getFriendSimpleInfoWithUid(uids, trace);
        if (friendSimpleInfoWithUid == null || friendSimpleInfoWithUid.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it = friendSimpleInfoWithUid.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendSimpleInfoList = it.next();
            Intrinsics.checkNotNullExpressionValue(friendSimpleInfoList, "friendSimpleInfoList");
            String p16 = friendSimpleInfoList.p();
            if (p16 != null) {
                arrayList.add(p16);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @Nullable
    public ArrayList<String> getRemarkWithUid(@NotNull ArrayList<String> uids, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ArrayList) iPatchRedirector.redirect((short) 18, (Object) this, (Object) uids, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = getFriendSimpleInfoWithUid(uids, trace);
        if (friendSimpleInfoWithUid == null || friendSimpleInfoWithUid.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it = friendSimpleInfoWithUid.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendSimpleInfoList = it.next();
            Intrinsics.checkNotNullExpressionValue(friendSimpleInfoList, "friendSimpleInfoList");
            String r16 = friendSimpleInfoList.r();
            if (r16 != null) {
                arrayList.add(r16);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void isFriend(@NotNull final String uid, @NotNull String tag, @NotNull final hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, uid, tag, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 != null) {
            b16.R(uid, tag, new ICheckIsBuddyCallback() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.ICheckIsBuddyCallback
                public final void onResult(String str, boolean z16) {
                    NTFriendsInfoApiImpl.isFriend$lambda$12(uid, iQueryGeneralDataCallback, str, z16);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void isGetFriendListSuc(@Nullable String trace, @NotNull hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
        } else {
            Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public boolean isHasFriend(@NotNull String uid, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) uid, (Object) trace)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 == null || !b16.H0()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void moveFriendToNewGroup(@Nullable String friendUid, int newGroupId, @Nullable String trace, @Nullable final hx3.c<Boolean> iUpdateGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, friendUid, Integer.valueOf(newGroupId), trace, iUpdateGeneralDataCallback);
            return;
        }
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 != null) {
            b16.setBuddyCategory(friendUid, newGroupId, new IOperateCallback() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NTFriendsInfoApiImpl.moveFriendToNewGroup$lambda$9(hx3.c.this, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void moveGroup(int srcGroupId, int dstGroupId, @Nullable String trace, @Nullable final hx3.b<Boolean> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(srcGroupId), Integer.valueOf(dstGroupId), trace, iQueryGeneralDataCallback);
            return;
        }
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 != null) {
            b16.delCategory(srcGroupId, new IOperateCallback() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NTFriendsInfoApiImpl.moveGroup$lambda$8(hx3.b.this, i3, str);
                }
            });
        }
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
        } else {
            requestFriendListFromNT(true, trace);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void resetData(@Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) trace);
        }
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
        com.tencent.qqnt.ntrelation.friendsinfo.manager.c.f360050a.v(reqType, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void getFriendsDetailInfoWithUid(@NotNull final ArrayList<String> uids, @Nullable final String trace, @NotNull final hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> iQueryGeneralDataCallback) {
        final HashMap<String, StockLocalData> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, uids, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        y f16 = com.tencent.qqnt.msg.f.f();
        if (f16 != null) {
            hashMap = f16.getStockLocalData(trace == null ? "" : trace, uids);
        } else {
            hashMap = null;
        }
        y f17 = com.tencent.qqnt.msg.f.f();
        if (f17 != null) {
            f17.fetchUserDetailInfo(trace == null ? "" : trace, uids, Source.KDB, new ArrayList<>(Collections.singletonList(ProfileBizType.KALL)), new IDetailInfoCallback() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback
                public final void onResult(int i3, String str, Source source, HashMap hashMap2) {
                    NTFriendsInfoApiImpl.getFriendsDetailInfoWithUid$lambda$3(hx3.b.this, uids, trace, hashMap, i3, str, source, hashMap2);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @Nullable
    public String getNickWithUid(@NotNull String uid, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) uid, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        ArrayList<String> nickWithUid = getNickWithUid(arrayList, trace);
        if (nickWithUid == null || nickWithUid.isEmpty()) {
            return null;
        }
        return nickWithUid.get(0);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @Nullable
    public String getRemarkWithUid(@NotNull String uid, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, (Object) uid, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        ArrayList<String> remarkWithUid = getRemarkWithUid(arrayList, trace);
        if (remarkWithUid == null || remarkWithUid.isEmpty()) {
            return null;
        }
        return remarkWithUid.get(0);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    @Nullable
    public com.tencent.qqnt.ntrelation.friendsinfo.bean.a getFriendsCategoryBaseInfo(@NotNull String categoryId, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qqnt.ntrelation.friendsinfo.bean.a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) categoryId, (Object) trace);
        }
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 != null) {
            ArrayList<BuddyListCategory> buddyListFromCache = b16.getBuddyListFromCache("getFriendsCategoryBaseInfo2--" + trace, BuddyListReqType.KNOMAL);
            if (buddyListFromCache != null) {
                Iterator<BuddyListCategory> it = buddyListFromCache.iterator();
                while (it.hasNext()) {
                    BuddyListCategory next = it.next();
                    if (next.categoryId == Integer.parseInt(categoryId)) {
                        return new com.tencent.qqnt.ntrelation.friendsinfo.bean.a(next.getCategoryId(), next.getCategroyName(), next.getCategroyMbCount(), next.getOnlineCount(), (byte) next.getCategorySortId());
                    }
                }
            }
        }
        return null;
    }
}
