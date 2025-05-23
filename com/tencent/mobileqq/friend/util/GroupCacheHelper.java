package com.tencent.mobileqq.friend.util;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J<\u0010\f\u001a\u00020\u000b2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\"\u0010\r\u001a\u00020\u000b2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004J2\u0010\u000e\u001a\u00020\u000b2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/friend/util/GroupCacheHelper;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "Lkotlin/collections/ArrayList;", "ntCategoryInfoList", "", "startIndex", "endIndex", "", "firstInit", "", "d", "b", "c", "Z", "isCacheLoading", "<init>", "()V", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GroupCacheHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final GroupCacheHelper f211730a = new GroupCacheHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isCacheLoading;

    GroupCacheHelper() {
    }

    private final void d(ArrayList<b> ntCategoryInfoList, int startIndex, int endIndex, boolean firstInit) {
        if (isCacheLoading) {
            QLog.d("GroupCacheHelper", 1, "isCacheLoading");
            return;
        }
        if (ntCategoryInfoList == null) {
            QLog.d("GroupCacheHelper", 1, "ntCategoryInfoList == null");
            return;
        }
        QRouteApi api = QRoute.api(IFriendsTABService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(\n            IFriend\u2026ice::class.java\n        )");
        if (!((IFriendsTABService) api).isNtDataService()) {
            QLog.d("GroupCacheHelper", 1, "!friendsTABService.isNtDataService()");
            return;
        }
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.a.f261779e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "GroupCacheHelper_initFriendCache", null, null, null, new GroupCacheHelper$preloadFriendCache$1(ntCategoryInfoList, endIndex, startIndex, firstInit, null), 14, null);
        }
    }

    public final void b(ArrayList<b> ntCategoryInfoList) {
        IFriendsTABService iFriendsTABService = (IFriendsTABService) QRoute.api(IFriendsTABService.class);
        if (iFriendsTABService == null) {
            return;
        }
        d(ntCategoryInfoList, 0, iFriendsTABService.getCacheFriendCount(), true);
    }

    public final void c(ArrayList<b> ntCategoryInfoList, int startIndex, int endIndex) {
        d(ntCategoryInfoList, startIndex, endIndex, false);
    }
}
