package com.tencent.qqnt.ntrelation.friendsinfo.api.impl;

import com.tencent.help.GroupInfoHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.ntrelation.api.IFriendDataTransApi;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IQQFriendDataCallbackService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/ntrelation/friendsinfo/api/impl/QQFriendsInfoApiImpl$friendListObserver$1", "Lcom/tencent/mobileqq/app/ar;", "", "isSuccess", "isComplete", "", "onUpdateFriendList", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQFriendsInfoApiImpl$friendListObserver$1 extends ar {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ QQFriendsInfoApiImpl f359923d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QQFriendsInfoApiImpl$friendListObserver$1(QQFriendsInfoApiImpl qQFriendsInfoApiImpl) {
        this.f359923d = qQFriendsInfoApiImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(IFriendDataService iFriendDataService, IQQFriendDataCallbackService qqDataCallbackService) {
        Intrinsics.checkNotNullParameter(qqDataCallbackService, "$qqDataCallbackService");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> f16 = GroupInfoHelper.INSTANCE.f(iFriendDataService);
        qqDataCallbackService.friendsCategoryInfoToCallback(f16);
        qqDataCallbackService.friendsCategoryUidsInfoToCallback(f16);
        List<Friends> allFriends = iFriendDataService.getAllFriends();
        if (com.tencent.relation.common.utils.e.f364767a.a()) {
            Intrinsics.checkNotNullExpressionValue(allFriends, "allFriends");
            CollectionsKt__MutableCollectionsKt.removeAll((List) allFriends, (Function1) new Function1<Friends, Boolean>() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.QQFriendsInfoApiImpl$friendListObserver$1$onUpdateFriendList$1$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Friends friends) {
                    return Boolean.valueOf((friends.robotVersion == 0 && friends.robotType == 0) ? false : true);
                }
            });
        }
        IQQFriendDataCallbackService iQQFriendDataCallbackService = (IQQFriendDataCallbackService) QRoute.api(IQQFriendDataCallbackService.class);
        IFriendDataTransApi iFriendDataTransApi = (IFriendDataTransApi) QRoute.api(IFriendDataTransApi.class);
        Intrinsics.checkNotNullExpressionValue(allFriends, "allFriends");
        iQQFriendDataCallbackService.allFriendsInfoToCallback(iFriendDataTransApi.allFriendsConvertToFriendsSimpleInfo(allFriends));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.ar
    public void onUpdateFriendList(boolean isSuccess, boolean isComplete) {
        final IFriendDataService friendDataService;
        super.onUpdateFriendList(isSuccess, isComplete);
        QRouteApi api = QRoute.api(IQQFriendDataCallbackService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQFriendDataCallbackService::class.java)");
        final IQQFriendDataCallbackService iQQFriendDataCallbackService = (IQQFriendDataCallbackService) api;
        friendDataService = this.f359923d.getFriendDataService();
        if (isSuccess && friendDataService != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.api.impl.w
                @Override // java.lang.Runnable
                public final void run() {
                    QQFriendsInfoApiImpl$friendListObserver$1.b(IFriendDataService.this, iQQFriendDataCallbackService);
                }
            }, 16, null, true);
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
        eVar.d(-1);
        iQQFriendDataCallbackService.friendsCategoryInfoToCallback(eVar);
        iQQFriendDataCallbackService.friendsCategoryUidsInfoToCallback(eVar);
    }
}
