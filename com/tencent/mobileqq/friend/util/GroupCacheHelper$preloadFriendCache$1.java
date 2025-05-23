package com.tencent.mobileqq.friend.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.contacts.cache.api.IFriendListCacheService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.friend.util.GroupCacheHelper$preloadFriendCache$1", f = "GroupCacheHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class GroupCacheHelper$preloadFriendCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $endIndex;
    final /* synthetic */ boolean $firstInit;
    final /* synthetic */ ArrayList<b> $ntCategoryInfoList;
    final /* synthetic */ int $startIndex;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupCacheHelper$preloadFriendCache$1(ArrayList<b> arrayList, int i3, int i16, boolean z16, Continuation<? super GroupCacheHelper$preloadFriendCache$1> continuation) {
        super(2, continuation);
        this.$ntCategoryInfoList = arrayList;
        this.$endIndex = i3;
        this.$startIndex = i16;
        this.$firstInit = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupCacheHelper$preloadFriendCache$1(this.$ntCategoryInfoList, this.$endIndex, this.$startIndex, this.$firstInit, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List subList;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GroupCacheHelper.isCacheLoading = true;
            ArrayList arrayList = new ArrayList();
            Iterator<b> it = this.$ntCategoryInfoList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    arrayList.addAll(next.c());
                }
            }
            int size = arrayList.size();
            int i3 = this.$endIndex;
            if (size >= i3) {
                subList = arrayList.subList(this.$startIndex, i3);
                Intrinsics.checkNotNullExpressionValue(subList, "{\n                    ui\u2026dIndex)\n                }");
            } else {
                subList = arrayList.subList(this.$startIndex, size);
                Intrinsics.checkNotNullExpressionValue(subList, "{\n                    ui\u2026bCount)\n                }");
            }
            QLog.i("GroupCacheHelper", 2, "cacheUidList.size \uff1a" + subList.size() + "firstInit:" + this.$firstInit);
            ((IFriendListCacheService) QRoute.api(IFriendListCacheService.class)).preLoadContactList(new ArrayList<>(subList), this.$firstInit, "GroupCacheHelper");
            GroupCacheHelper.isCacheLoading = false;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GroupCacheHelper$preloadFriendCache$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
