package com.tencent.qqnt.ntrelation.friendsinfo.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.help.GroupInfoHelper;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendDataCallbackService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi;
import com.tencent.qqnt.ntrelation.util.UidCategoryListUtil;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\b*\u0001M\u0018\u0000 R2\u00020\u0001:\u0001SB\u0007\u00a2\u0006\u0004\bP\u0010QJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J>\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u00020\u0006`\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J>\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u00020\u0006`\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J:\u0010\u0015\u001a\u00020\u000e2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00110\nj\b\u0012\u0004\u0012\u00020\u0011`\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013H\u0016J \u0010\u0018\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0016J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010!\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0016H\u0016J(\u0010%\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0013H\u0016J8\u0010(\u001a\u00020\u000e2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\nj\b\u0012\u0004\u0012\u00020\u001e`\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020'0\u0016H\u0016J(\u0010*\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u001e2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020'0\u0016H\u0016J>\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u00020\u0006`\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010,\u001a\u0004\u0018\u00010#2\u0006\u0010)\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020#0\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010-\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J(\u0010.\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016H\u0016J8\u0010.\u001a\u00020\u000e2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u00020\u0006`\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016H\u0016J:\u00101\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016H\u0016J \u00102\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0016H\u0016J \u00103\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0016H\u0016J4\u00106\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u00010\u00062\u0006\u00105\u001a\u00020\u001e2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0013H\u0016J2\u00109\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u001e2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016H\u0016J0\u0010;\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016H\u0016J*\u0010<\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016H\u0016J*\u0010?\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010=H\u0016J:\u0010@\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00060\nj\b\u0012\u0004\u0012\u00020\u0006`\u000b2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0016H\u0016J8\u0010E\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010D\u001a\u00020\u001c2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020'0\u0016H\u0016J(\u0010F\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020A2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020'0\u0016H\u0016R\"\u0010G\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006T"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/api/impl/QQFriendsInfoApiImpl;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/api/IQQFriendsInfoApi;", "Lcom/tencent/mobileqq/friend/api/IFriendDataService;", "getFriendDataService", "Lcom/tencent/mobileqq/friend/api/IFriendExtensionService;", "getFriendExtensionService", "", "uid", "trace", "getNickWithUid", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uids", "getRemarkWithUid", "", "requestAllCategoriesInfo", "resetData", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "ntFriendDetailInfo", "Lhx3/c;", "updateCallback", "accurateUpdateNTFriendDetailInfo", "Lhx3/b;", "iQueryGeneralDataCallback", "addChangeFriendUidsCallBack", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "getAllFriend", "", "isHasFriend", "", "getFriendCount", "tag", IProfileProtocolConst.PARAM_IS_FRIEND, "categoryName", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/a;", "iUpdateGeneralDataCallback", "addCategoryV2", "categoryIds", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "getCategoryInfoListWithCategoryId", "categoryId", "getCategoryInfoWithCategoryId", "getFriendSimpleInfoWithUid", "getFriendsCategoryBaseInfo", "getFriendsCategoryInfo", "getFriendsDetailInfoWithUid", "groupId", "uncommonlyUsedFrd", "addFriendToFriendList", "getGatheredFriendsCount", "isGetFriendListSuc", "friendUid", "newGroupId", "moveFriendToNewGroup", "srcGroupId", "dstGroupId", "moveGroup", "uidList", "normal2UnComUsed", "changeBuddyOnline", "Lhx3/a;", "iDeleteGeneralDataCallback", "deleteNTFriendSimpleInfo", "doUnComUsed2Normal", "Lcom/tencent/qqnt/ntrelation/constant/RelationListReqType;", "reqType", "isObserver", "forceUpdate", "friendsCategoryCacheInfoV2", "unregisterFriendCategoryInfoV2Callback", "hasRegisterFriendListObserver", "Z", "getHasRegisterFriendListObserver", "()Z", "setHasRegisterFriendListObserver", "(Z)V", "com/tencent/qqnt/ntrelation/friendsinfo/api/impl/QQFriendsInfoApiImpl$friendListObserver$1", "friendListObserver", "Lcom/tencent/qqnt/ntrelation/friendsinfo/api/impl/QQFriendsInfoApiImpl$friendListObserver$1;", "<init>", "()V", "Companion", "a", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQFriendsInfoApiImpl implements IQQFriendsInfoApi {
    public static final String TAG = "QQFriendsInfoApiImpl";
    private final QQFriendsInfoApiImpl$friendListObserver$1 friendListObserver = new QQFriendsInfoApiImpl$friendListObserver$1(this);
    private volatile boolean hasRegisterFriendListObserver;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f359922a;

        static {
            int[] iArr = new int[RelationListReqType.values().length];
            try {
                iArr[RelationListReqType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RelationListReqType.LETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f359922a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void accurateUpdateNTFriendDetailInfo$lambda$3(AppRuntime app, ArrayList ntFriendDetailInfo, com.tencent.qqnt.ntrelation.friendsinfo.bean.e responseData, hx3.c cVar) {
        IFriendExtensionService iFriendExtensionService;
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(ntFriendDetailInfo, "$ntFriendDetailInfo");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        IFriendDataService iFriendDataService = (IFriendDataService) app.getRuntimeService(IFriendDataService.class, "");
        if (iFriendDataService == null || (iFriendExtensionService = (IFriendExtensionService) app.getRuntimeService(IFriendExtensionService.class, "")) == null) {
            return;
        }
        Manager manager = app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        FriendsManager friendsManager = (FriendsManager) manager;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = ntFriendDetailInfo.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar2 = (com.tencent.qqnt.ntrelation.friendsinfo.bean.c) it.next();
            if (cVar2 != null) {
                String x16 = cVar2.x();
                if (!TextUtils.isEmpty(x16)) {
                    Friends friend = iFriendDataService.getFriend(x16, true);
                    if (friend == null) {
                        friend = new Friends();
                        friend.uin = x16;
                    }
                    GroupInfoHelper.Companion companion = GroupInfoHelper.INSTANCE;
                    if (companion.a(friend, cVar2)) {
                        arrayList.add(friend);
                    }
                    ExtensionInfo extensionInfo = iFriendExtensionService.getExtensionInfo(x16, true);
                    if (extensionInfo == null) {
                        extensionInfo = new ExtensionInfo();
                        extensionInfo.uin = x16;
                    }
                    if (companion.b(extensionInfo, cVar2)) {
                        arrayList2.add(extensionInfo);
                    }
                    SpecialCareInfo O = friendsManager.O(x16);
                    if (O == null) {
                        O = new SpecialCareInfo();
                        O.uin = x16;
                    }
                    if (companion.c(O, cVar2)) {
                        arrayList3.add(O);
                    }
                }
            }
        }
        boolean saveFriendList = iFriendDataService.saveFriendList(arrayList);
        boolean saveExtensionInfoList = iFriendExtensionService.saveExtensionInfoList(arrayList2);
        friendsManager.i(arrayList3);
        if (!saveFriendList && !saveExtensionInfoList) {
            responseData.d(-1);
        }
        responseData.e(ntFriendDetailInfo);
        if (cVar != null) {
            cVar.onUpdateResult(responseData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addFriendToFriendList$lambda$13(FriendsManager fmi, String str, int i3, boolean z16, hx3.b bVar) {
        Intrinsics.checkNotNullParameter(fmi, "$fmi");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Boolean.valueOf(fmi.f(str, i3, z16, null)));
        eVar.e(arrayList);
        if (bVar != null) {
            bVar.onQueryResult(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changeBuddyOnline$lambda$27(String uid, hx3.b bVar, String str, FriendsManager fmi, com.tencent.qqnt.ntrelation.friendsinfo.bean.e responseData) {
        Intrinsics.checkNotNullParameter(uid, "$uid");
        Intrinsics.checkNotNullParameter(fmi, "$fmi");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        String uin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(uid);
        if (TextUtils.isEmpty(uin)) {
            com.tencent.util.m.f383989a.b(bVar);
            QLog.i(TAG, 1, "changeBuddyOnline " + str + ", uin is empty");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        fmi.j(Long.parseLong(uin));
        if (bVar != null) {
            bVar.onQueryResult(responseData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteNTFriendSimpleInfo$lambda$30$lambda$29(IFriendDataService friendsDataService, String it, hx3.a aVar) {
        Intrinsics.checkNotNullParameter(friendsDataService, "$friendsDataService");
        Intrinsics.checkNotNullParameter(it, "$it");
        friendsDataService.deleteFriend(it);
        if (aVar != null) {
            aVar.a(new com.tencent.qqnt.ntrelation.friendsinfo.bean.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doUnComUsed2Normal$lambda$33(ArrayList uidList, FriendsManager fmi, hx3.b bVar, com.tencent.qqnt.ntrelation.friendsinfo.bean.e responseData) {
        Intrinsics.checkNotNullParameter(uidList, "$uidList");
        Intrinsics.checkNotNullParameter(fmi, "$fmi");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        ArrayList arrayList = new ArrayList();
        Iterator it = uidList.iterator();
        while (it.hasNext()) {
            arrayList.add(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid((String) it.next()));
        }
        fmi.p(arrayList);
        if (bVar != null) {
            bVar.onQueryResult(responseData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void friendsCategoryCacheInfoV2$lambda$34(boolean z16, RelationListReqType reqType, String str, hx3.b iQueryGeneralDataCallback, QQFriendsInfoApiImpl this$0, boolean z17) {
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> b16;
        Intrinsics.checkNotNullParameter(reqType, "$reqType");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            ((IQQFriendDataCallbackService) QRoute.api(IQQFriendDataCallbackService.class)).registerCategoryInfoCallback(reqType, str, iQueryGeneralDataCallback);
        }
        IFriendDataService friendDataService = this$0.getFriendDataService();
        if (friendDataService == null) {
            com.tencent.util.m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "getAllFriends " + str + " friendsDataService is null");
            return;
        }
        int i3 = b.f359922a[reqType.ordinal()];
        if (i3 == 1) {
            b16 = UidCategoryListUtil.f360227a.b(friendDataService);
        } else if (i3 != 2) {
            b16 = new ArrayList<>();
        } else {
            List<Friends> allFriends = friendDataService.getAllFriends();
            if (com.tencent.relation.common.utils.e.f364767a.a()) {
                Intrinsics.checkNotNullExpressionValue(allFriends, "allFriends");
                CollectionsKt__MutableCollectionsKt.removeAll((List) allFriends, (Function1) new Function1<Friends, Boolean>() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.QQFriendsInfoApiImpl$friendsCategoryCacheInfoV2$1$result$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Friends friends) {
                        return Boolean.valueOf((friends.robotVersion == 0 && friends.robotType == 0) ? false : true);
                    }
                });
            }
            b16 = com.tencent.qqnt.ntrelation.util.l.f360279a.c(allFriends);
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        eVar.e(b16);
        iQueryGeneralDataCallback.onQueryResult(eVar);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            if (!this$0.hasRegisterFriendListObserver) {
                ((QQAppInterface) peekAppRuntime).addObserver(this$0.friendListObserver);
                QLog.i(TAG, 1, "getAllFriends " + str + " app is null");
                this$0.hasRegisterFriendListObserver = true;
            }
            BusinessHandler businessHandler = ((QQAppInterface) peekAppRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            if (businessHandler == null || !(businessHandler instanceof FriendListHandler)) {
                return;
            }
            ((FriendListHandler) businessHandler).getFriendGroupList(z17, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFriendDataService getFriendDataService() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "getFriendsSimpleInfoWithUid is error! app is invalid!");
            return null;
        }
        IFriendDataService iFriendDataService = (IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        if (iFriendDataService == null) {
            return null;
        }
        return iFriendDataService;
    }

    private final IFriendExtensionService getFriendExtensionService() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "getFriendsSimpleInfoWithUid is error! app is invalid!");
            return null;
        }
        return (IFriendExtensionService) peekAppRuntime.getRuntimeService(IFriendExtensionService.class, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFriendsDetailInfoWithUid$lambda$11(ArrayList uids, IRelationNTUinAndUidApi relationNTUinAndUidApi, IFriendDataService friendsDataService, IFriendExtensionService extensionService, com.tencent.qqnt.ntrelation.friendsinfo.bean.e responseData, hx3.b iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uids, "$uids");
        Intrinsics.checkNotNullParameter(relationNTUinAndUidApi, "$relationNTUinAndUidApi");
        Intrinsics.checkNotNullParameter(friendsDataService, "$friendsDataService");
        Intrinsics.checkNotNullParameter(extensionService, "$extensionService");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        ArrayList arrayList = new ArrayList();
        Iterator it = uids.iterator();
        while (it.hasNext()) {
            String uid = (String) it.next();
            String uin = relationNTUinAndUidApi.getUinFromUid(uid);
            Friends friend = friendsDataService.getFriend(uin, true, true);
            if (friend != null) {
                ExtensionInfo extensionInfo = extensionService.getExtensionInfo(uin, true);
                com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.c();
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                cVar.v0(uid);
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                cVar.w0(uin);
                cVar.k0(friend.name);
                cVar.m0(friend.remark);
                cVar.u0(friend.status);
                cVar.c0(Byte.valueOf(friend.cSpecialFlag));
                cVar.d0(friend.groupid);
                cVar.g0(friend.datetime);
                cVar.Z(friend.alias);
                cVar.h0(Byte.valueOf(friend.gathtertype));
                cVar.V(friend.age);
                cVar.q0(friend.gender);
                cVar.j0(friend.multiFlags);
                cVar.l0(friend.recommReason);
                cVar.e0(friend.mComparePartInt);
                String str = friend.mCompareSpell;
                if (str == null) {
                    str = "";
                }
                cVar.f0(str);
                cVar.a0(Boolean.valueOf(friend.isBlack == 1));
                cVar.b0(Boolean.valueOf(friend.isBlacked == 1));
                if (extensionInfo == null) {
                    arrayList.add(cVar);
                } else {
                    cVar.o0(extensionInfo.richTime);
                    cVar.n0(extensionInfo.richBuffer);
                    cVar.N(Boolean.valueOf(extensionInfo.isAdded2C2C));
                    cVar.p0(String.valueOf(extensionInfo.friendRingId));
                    cVar.i0(Boolean.valueOf(extensionInfo.openDoNotDisturbTime != 0));
                    arrayList.add(cVar);
                }
            }
        }
        responseData.e(arrayList);
        iQueryGeneralDataCallback.onQueryResult(responseData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGatheredFriendsCount$lambda$15(FriendsManager fmi, com.tencent.qqnt.ntrelation.friendsinfo.bean.e responseData, String str, hx3.b iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(fmi, "$fmi");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        int L = fmi.L();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(L));
        responseData.e(arrayList);
        QLog.i(TAG, 1, "addFriendToFriendList " + str + " count: " + L + " \n");
        iQueryGeneralDataCallback.onQueryResult(responseData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isGetFriendListSuc$lambda$17(FriendsManager friendsManager, com.tencent.qqnt.ntrelation.friendsinfo.bean.e responseData, hx3.b iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        boolean g06 = friendsManager != null ? friendsManager.g0() : false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Boolean.valueOf(g06));
        responseData.e(arrayList);
        iQueryGeneralDataCallback.onQueryResult(responseData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moveFriendToNewGroup$lambda$19(String str, IFriendDataService friendsDataService, int i3, hx3.c cVar) {
        Intrinsics.checkNotNullParameter(friendsDataService, "$friendsDataService");
        friendsDataService.moveFriendToNewGroup(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(str), i3);
        if (cVar != null) {
            cVar.onUpdateResult(new com.tencent.qqnt.ntrelation.friendsinfo.bean.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moveGroup$lambda$21(IFriendDataService friendsDataService, int i3, int i16, hx3.b bVar, com.tencent.qqnt.ntrelation.friendsinfo.bean.e responseData, String str) {
        Intrinsics.checkNotNullParameter(friendsDataService, "$friendsDataService");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        friendsDataService.moveGroup(i3, i16);
        if (bVar != null) {
            bVar.onQueryResult(responseData);
        }
        QLog.i(TAG, 1, "moveGroup " + str + ", from " + i3 + " to " + i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void normal2UnComUsed$lambda$24(List uidList, FriendsManager fmi, hx3.b bVar, com.tencent.qqnt.ntrelation.friendsinfo.bean.e responseData) {
        Intrinsics.checkNotNullParameter(uidList, "$uidList");
        Intrinsics.checkNotNullParameter(fmi, "$fmi");
        Intrinsics.checkNotNullParameter(responseData, "$responseData");
        ArrayList arrayList = new ArrayList();
        Iterator it = uidList.iterator();
        while (it.hasNext()) {
            arrayList.add(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid((String) it.next()));
        }
        fmi.k0(arrayList);
        if (bVar == null) {
            return;
        }
        bVar.onQueryResult(responseData);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void accurateUpdateNTFriendDetailInfo(final ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> ntFriendDetailInfo, String trace, final hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> updateCallback) {
        Intrinsics.checkNotNullParameter(ntFriendDetailInfo, "ntFriendDetailInfo");
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            com.tencent.util.m.f383989a.c(updateCallback);
            QLog.i(TAG, 1, "updateNTCategoryInfo " + trace + ", app is null");
            return;
        }
        if (QLog.isDebugVersion()) {
            Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> it = ntFriendDetailInfo.iterator();
            while (it.hasNext()) {
                QLog.e(TAG, 1, "trace " + trace + " updateNTFriendDetailInfo frienduin: " + it.next().x() + TokenParser.SP + QLog.getStackTraceString(new Throwable()));
            }
        }
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                QQFriendsInfoApiImpl.accurateUpdateNTFriendDetailInfo$lambda$3(AppRuntime.this, ntFriendDetailInfo, eVar, updateCallback);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void addCategoryV2(String categoryName, String tag, hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> iUpdateGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void addChangeFriendUidsCallBack(String trace, hx3.b<String> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ((IQQFriendDataCallbackService) QRoute.api(IQQFriendDataCallbackService.class)).registerAnyFriendChangeUids(trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void addFriendToFriendList(String uid, final int groupId, final boolean uncommonlyUsedFrd, String trace, final hx3.b<Boolean> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            com.tencent.util.m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "addFriendToFriendList app is null \n");
            return;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        final FriendsManager friendsManager = (FriendsManager) manager;
        final String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(uid);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.u
            @Override // java.lang.Runnable
            public final void run() {
                QQFriendsInfoApiImpl.addFriendToFriendList$lambda$13(FriendsManager.this, uinFromUid, groupId, uncommonlyUsedFrd, iQueryGeneralDataCallback);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void changeBuddyOnline(final String trace, final String uid, final hx3.b<Boolean> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            com.tencent.util.m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "changeBuddyOnline " + trace + ", app is null");
            return;
        }
        final FriendsManager friendsManager = (FriendsManager) peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsManager == null) {
            com.tencent.util.m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "changeBuddyOnline " + trace + ", fmi is null");
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.o
            @Override // java.lang.Runnable
            public final void run() {
                QQFriendsInfoApiImpl.changeBuddyOnline$lambda$27(uid, iQueryGeneralDataCallback, trace, friendsManager, eVar);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void deleteNTFriendSimpleInfo(String uid, String trace, final hx3.a<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> iDeleteGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            com.tencent.util.m.f383989a.a(iDeleteGeneralDataCallback);
            QLog.i(TAG, 1, "deleteNTFriendSimpleInfo " + trace + " app is null \n");
            return;
        }
        final IFriendDataService iFriendDataService = (IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        if (iFriendDataService == null) {
            return;
        }
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        final String uinFromUid = ((IRelationNTUinAndUidApi) api).getUinFromUid(uid);
        if (uinFromUid != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.v
                @Override // java.lang.Runnable
                public final void run() {
                    QQFriendsInfoApiImpl.deleteNTFriendSimpleInfo$lambda$30$lambda$29(IFriendDataService.this, uinFromUid, iDeleteGeneralDataCallback);
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void doUnComUsed2Normal(String trace, final ArrayList<String> uidList, final hx3.b<Boolean> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            com.tencent.util.m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "doUnComUsed2Normal " + trace + ", app is null");
            return;
        }
        final FriendsManager friendsManager = (FriendsManager) peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsManager == null) {
            com.tencent.util.m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "doUnComUsed2Normal " + trace + ", fmi is null");
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.p
            @Override // java.lang.Runnable
            public final void run() {
                QQFriendsInfoApiImpl.doUnComUsed2Normal$lambda$33(uidList, friendsManager, iQueryGeneralDataCallback, eVar);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void friendsCategoryCacheInfoV2(final RelationListReqType reqType, final boolean isObserver, final String trace, final boolean forceUpdate, final hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(reqType, "reqType");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.n
            @Override // java.lang.Runnable
            public final void run() {
                QQFriendsInfoApiImpl.friendsCategoryCacheInfoV2$lambda$34(isObserver, reqType, trace, iQueryGeneralDataCallback, this, forceUpdate);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public List<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> getAllFriend(String trace) {
        IFriendDataService friendDataService = getFriendDataService();
        IFriendExtensionService friendExtensionService = getFriendExtensionService();
        ArrayList arrayList = new ArrayList();
        if (friendDataService == null) {
            return arrayList;
        }
        for (Friends friends : friendDataService.getAllFriends()) {
            GroupInfoHelper.Companion companion = GroupInfoHelper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(friends, "friends");
            arrayList.add(companion.d(friends, friendExtensionService != null ? friendExtensionService.getExtensionInfo(friends.uin, true) : null));
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void getCategoryInfoListWithCategoryId(final ArrayList<Integer> categoryIds, final String trace, final hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(categoryIds, "categoryIds");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.q
            @Override // java.lang.Runnable
            public final void run() {
                QQFriendsInfoApiImpl.getCategoryInfoListWithCategoryId$lambda$5(QQFriendsInfoApiImpl.this, categoryIds, trace, iQueryGeneralDataCallback);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void getCategoryInfoWithCategoryId(int categoryId, String trace, hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(categoryId));
        getCategoryInfoListWithCategoryId(arrayList, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public int getFriendCount(String trace) {
        IFriendDataService friendDataService = getFriendDataService();
        if (friendDataService != null) {
            return friendDataService.getFriendCount();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> getFriendSimpleInfoWithUid(ArrayList<String> uids, String trace) {
        IFriendExtensionService iFriendExtensionService;
        Friends friend;
        Intrinsics.checkNotNullParameter(uids, "uids");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i(TAG, 1, "getFriendsSimpleInfoWithUid " + trace + " fail, because app is null");
            return null;
        }
        IFriendDataService iFriendDataService = (IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        if (iFriendDataService == null || (iFriendExtensionService = (IFriendExtensionService) peekAppRuntime.getRuntimeService(IFriendExtensionService.class, "")) == null) {
            return null;
        }
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) api;
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList = new ArrayList<>();
        Iterator<String> it = uids.iterator();
        while (it.hasNext()) {
            String uinFromUid = iRelationNTUinAndUidApi.getUinFromUid(it.next());
            if (!TextUtils.isEmpty(uinFromUid) && (friend = iFriendDataService.getFriend(uinFromUid, true)) != null) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d d16 = GroupInfoHelper.INSTANCE.d(friend, iFriendExtensionService.getExtensionInfo(uinFromUid, true));
                if (QLog.isDebugVersion()) {
                    QLog.i(TAG, 1, "getFriendsSimpleInfoWithUid " + trace + " info: " + d16);
                }
                arrayList.add(d16);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public com.tencent.qqnt.ntrelation.friendsinfo.bean.a getFriendsCategoryBaseInfo(String categoryId, String trace) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        for (Groups groups : ((IFriendDataService) runtimeService).getGroupList()) {
            if (groups != null && Integer.valueOf(groups.group_id).equals(categoryId)) {
                return GroupInfoHelper.INSTANCE.j(groups);
            }
        }
        return null;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public com.tencent.qqnt.ntrelation.friendsinfo.bean.b getFriendsCategoryInfo(String categoryId, String trace) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i(TAG, 1, "getFriendsCategoryInfo app is null");
            return null;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        IFriendDataService iFriendDataService = (IFriendDataService) runtimeService;
        Groups group = iFriendDataService.getGroup(Integer.parseInt(categoryId));
        List<Friends> friendList = iFriendDataService.getFriendList(Integer.parseInt(categoryId));
        ArrayList<String> arrayList = new ArrayList<>();
        for (Friends friend : friendList) {
            GroupInfoHelper.Companion companion = GroupInfoHelper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(friend, "friend");
            arrayList.add(companion.d(friend, null).getUid());
        }
        if (group == null) {
            return null;
        }
        return GroupInfoHelper.INSTANCE.i(group, arrayList.size(), friendList.size(), new ArrayList<>(), arrayList);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void getFriendsDetailInfoWithUid(String uid, String trace, hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        getFriendsDetailInfoWithUid(arrayList, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void getGatheredFriendsCount(final String trace, final hx3.b<Integer> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            com.tencent.util.m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "addFriendToFriendList " + trace + " app is null \n");
            return;
        }
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        final FriendsManager friendsManager = (FriendsManager) manager;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.l
            @Override // java.lang.Runnable
            public final void run() {
                QQFriendsInfoApiImpl.getGatheredFriendsCount$lambda$15(FriendsManager.this, eVar, trace, iQueryGeneralDataCallback);
            }
        }, 16, null, true);
    }

    public final boolean getHasRegisterFriendListObserver() {
        return this.hasRegisterFriendListObserver;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public String getNickWithUid(String uid, String trace) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        ArrayList<String> nickWithUid = getNickWithUid(arrayList, trace);
        if (nickWithUid == null || nickWithUid.size() <= 0) {
            return null;
        }
        return nickWithUid.get(0);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public String getRemarkWithUid(String uid, String trace) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        ArrayList<String> remarkWithUid = getRemarkWithUid(arrayList, trace);
        if (remarkWithUid == null || remarkWithUid.size() <= 0) {
            return null;
        }
        return remarkWithUid.get(0);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void isFriend(String uid, String tag, hx3.b<Boolean> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void isGetFriendListSuc(String trace, final hx3.b<Boolean> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            com.tencent.util.m.f383989a.b(iQueryGeneralDataCallback);
        } else {
            final FriendsManager friendsManager = (FriendsManager) peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.s
                @Override // java.lang.Runnable
                public final void run() {
                    QQFriendsInfoApiImpl.isGetFriendListSuc$lambda$17(FriendsManager.this, eVar, iQueryGeneralDataCallback);
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public boolean isHasFriend(String uid, String trace) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        QLog.i(TAG, 1, TokenParser.SP + trace + " QQFriendsInfoApiImpl isHasFriend \u6682\u4e0d\u5b9e\u73b0");
        return false;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void moveFriendToNewGroup(final String friendUid, final int newGroupId, String trace, final hx3.c<Boolean> iUpdateGeneralDataCallback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            com.tencent.util.m.f383989a.c(iUpdateGeneralDataCallback);
            QLog.i(TAG, 1, "moveFriendToNewGroup " + trace + ", app is null");
            return;
        }
        final IFriendDataService iFriendDataService = (IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        if (iFriendDataService == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.m
            @Override // java.lang.Runnable
            public final void run() {
                QQFriendsInfoApiImpl.moveFriendToNewGroup$lambda$19(friendUid, iFriendDataService, newGroupId, iUpdateGeneralDataCallback);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void moveGroup(final int srcGroupId, final int dstGroupId, final String trace, final hx3.b<Boolean> iQueryGeneralDataCallback) {
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            com.tencent.util.m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "moveGroup " + trace + ", app is null");
            return;
        }
        final IFriendDataService iFriendDataService = (IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        if (iFriendDataService == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.t
            @Override // java.lang.Runnable
            public final void run() {
                QQFriendsInfoApiImpl.moveGroup$lambda$21(IFriendDataService.this, srcGroupId, dstGroupId, iQueryGeneralDataCallback, eVar, trace);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void normal2UnComUsed(String trace, final List<String> uidList, final hx3.b<Boolean> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            com.tencent.util.m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "normal2UnComUsed " + trace + ", app is null");
            return;
        }
        final FriendsManager friendsManager = (FriendsManager) peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsManager == null) {
            com.tencent.util.m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "normal2UnComUsed " + trace + ", fmi is null");
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.r
            @Override // java.lang.Runnable
            public final void run() {
                QQFriendsInfoApiImpl.normal2UnComUsed$lambda$24(uidList, friendsManager, iQueryGeneralDataCallback, eVar);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void requestAllCategoriesInfo(String trace) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!this.hasRegisterFriendListObserver && (peekAppRuntime instanceof AppInterface)) {
            ((AppInterface) peekAppRuntime).addObserver(this.friendListObserver);
            this.hasRegisterFriendListObserver = true;
        }
        ((IFriendHandlerService) peekAppRuntime.getRuntimeService(IFriendHandlerService.class, "all")).requestFriendList(true);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void resetData(String trace) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!this.hasRegisterFriendListObserver && (peekAppRuntime instanceof AppInterface)) {
            ((AppInterface) peekAppRuntime).removeObserver(this.friendListObserver);
        }
        this.hasRegisterFriendListObserver = false;
    }

    public final void setHasRegisterFriendListObserver(boolean z16) {
        this.hasRegisterFriendListObserver = z16;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void unregisterFriendCategoryInfoV2Callback(RelationListReqType reqType, String trace, hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        Intrinsics.checkNotNullParameter(reqType, "reqType");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ((IQQFriendDataCallbackService) QRoute.api(IQQFriendDataCallbackService.class)).unregisterFriendCategoryInfoV2Callback(reqType, trace, iQueryGeneralDataCallback);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public void getFriendsDetailInfoWithUid(final ArrayList<String> uids, String trace, final hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> iQueryGeneralDataCallback) {
        final IFriendExtensionService iFriendExtensionService;
        Intrinsics.checkNotNullParameter(uids, "uids");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            com.tencent.util.m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "getFriendsDetailInfoWithUid " + trace + " app is null");
            return;
        }
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        final IFriendDataService iFriendDataService = (IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        if (iFriendDataService == null || (iFriendExtensionService = (IFriendExtensionService) peekAppRuntime.getRuntimeService(IFriendExtensionService.class, "")) == null) {
            return;
        }
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        final IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) api;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                QQFriendsInfoApiImpl.getFriendsDetailInfoWithUid$lambda$11(uids, iRelationNTUinAndUidApi, iFriendDataService, iFriendExtensionService, eVar, iQueryGeneralDataCallback);
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCategoryInfoListWithCategoryId$lambda$5(QQFriendsInfoApiImpl this$0, ArrayList categoryIds, String str, hx3.b iQueryGeneralDataCallback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(categoryIds, "$categoryIds");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "$iQueryGeneralDataCallback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            com.tencent.util.m.f383989a.b(iQueryGeneralDataCallback);
            QLog.i(TAG, 1, "getCategoryInfoListWithCategoryId " + str + " app is null");
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e();
        IFriendDataService iFriendDataService = (IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        if (iFriendDataService == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = categoryIds.iterator();
        while (it.hasNext()) {
            Integer categoryId = (Integer) it.next();
            Intrinsics.checkNotNullExpressionValue(categoryId, "categoryId");
            Groups group = iFriendDataService.getGroup(categoryId.intValue());
            List<Friends> friendList = iFriendDataService.getFriendList(categoryId.intValue());
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (Friends friend : friendList) {
                GroupInfoHelper.Companion companion = GroupInfoHelper.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(friend, "friend");
                IFriendDataService iFriendDataService2 = iFriendDataService;
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d e16 = GroupInfoHelper.Companion.e(companion, friend, null, 2, null);
                arrayList2.add(e16);
                arrayList3.add(e16.getUid());
                iFriendDataService = iFriendDataService2;
            }
            IFriendDataService iFriendDataService3 = iFriendDataService;
            GroupInfoHelper.Companion companion2 = GroupInfoHelper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(group, "group");
            com.tencent.qqnt.ntrelation.friendsinfo.bean.b i3 = companion2.i(group, arrayList2.size(), friendList.size(), arrayList2, arrayList3);
            if (QLog.isColorLevel()) {
                z16 = true;
                QLog.i(TAG, 1, "getCategoryInfoListWithCategoryId " + str + " categoryInfo: " + i3);
            } else {
                z16 = true;
            }
            arrayList.add(i3);
            iFriendDataService = iFriendDataService3;
        }
        eVar.e(arrayList);
        iQueryGeneralDataCallback.onQueryResult(eVar);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public ArrayList<String> getNickWithUid(ArrayList<String> uids, String trace) {
        Intrinsics.checkNotNullParameter(uids, "uids");
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = getFriendSimpleInfoWithUid(uids, trace);
        if (friendSimpleInfoWithUid == null) {
            QLog.i(TAG, 1, "getNickWithUid " + trace + " fail, ntSimpleInfoList is null");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it = friendSimpleInfoWithUid.iterator();
        while (it.hasNext()) {
            String p16 = it.next().p();
            if (p16 != null) {
                arrayList.add(p16);
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "getNickWithUid " + trace + " nick: " + p16);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public ArrayList<String> getRemarkWithUid(ArrayList<String> uids, String trace) {
        Intrinsics.checkNotNullParameter(uids, "uids");
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = getFriendSimpleInfoWithUid(uids, trace);
        if (friendSimpleInfoWithUid == null) {
            QLog.i(TAG, 1, "getRemarkWithUid " + trace + " fail, ntSimpleInfoList is null");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it = friendSimpleInfoWithUid.iterator();
        while (it.hasNext()) {
            String r16 = it.next().r();
            if (r16 != null) {
                arrayList.add(r16);
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "getRemarkWithUid " + trace + " remark is " + r16);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendsInfoApi
    public List<com.tencent.qqnt.ntrelation.friendsinfo.bean.a> getFriendsCategoryBaseInfo(String trace) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return new ArrayList();
        }
        IFriendDataService iFriendDataService = (IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        if (iFriendDataService == null) {
            return new ArrayList();
        }
        List<Groups> groupList = iFriendDataService.getGroupList();
        ArrayList arrayList = new ArrayList();
        for (Groups groups : groupList) {
            if (groups != null) {
                arrayList.add(GroupInfoHelper.INSTANCE.j(groups));
            }
        }
        return arrayList;
    }
}
