package com.tencent.mobileqq.search.util;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.util.QSearchDetailUtilKt$shareFeedClick$1$1", f = "QSearchDetailUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class QSearchDetailUtilKt$shareFeedClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $feedId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchDetailUtilKt$shareFeedClick$1$1(Context context, String str, Continuation<? super QSearchDetailUtilKt$shareFeedClick$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$feedId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QSearchDetailUtilKt$shareFeedClick$1$1(this.$context, this.$feedId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Activity h16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IGuildFeedUtilsApi iGuildFeedUtilsApi = (IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class);
            h16 = QSearchDetailUtilKt.h(this.$context);
            Intrinsics.checkNotNull(h16, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            String feedId = this.$feedId;
            Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
            iGuildFeedUtilsApi.shareContent((FragmentActivity) h16, feedId);
            Unit unit = Unit.INSTANCE;
            QLog.d("QSearchDetailUtil", 1, "vote up result " + unit);
            return unit;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QSearchDetailUtilKt$shareFeedClick$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
