package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.guild.media.thirdapp.share.g;
import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaChannelShareLoadInfoHelper$doFetchShareLoadInfo$1", f = "MediaChannelShareLoadInfoHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class MediaChannelShareLoadInfoHelper$doFetchShareLoadInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sessionId;
    final /* synthetic */ int $shareType;
    int label;
    final /* synthetic */ MediaChannelShareLoadInfoHelper this$0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelShareLoadInfoHelper$doFetchShareLoadInfo$1$a", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/a;", "", "code", "", "queryParam", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements com.tencent.mobileqq.guild.media.thirdapp.share.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MediaChannelShareLoadInfoHelper f228227a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f228228b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f228229c;

        a(MediaChannelShareLoadInfoHelper mediaChannelShareLoadInfoHelper, int i3, String str) {
            this.f228227a = mediaChannelShareLoadInfoHelper;
            this.f228228b = i3;
            this.f228229c = str;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.share.a
        public void onResult(int code, @Nullable String queryParam) {
            Logger.f235387a.d().d("QGMC.MediaChannelShareLoadInfoHelper", 1, "[FetchSessionIdCallback] code " + code + ", queryParam " + queryParam);
            this.f228227a.Q(queryParam, this.f228228b, this.f228229c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaChannelShareLoadInfoHelper$doFetchShareLoadInfo$1(String str, MediaChannelShareLoadInfoHelper mediaChannelShareLoadInfoHelper, int i3, Continuation<? super MediaChannelShareLoadInfoHelper$doFetchShareLoadInfo$1> continuation) {
        super(2, continuation);
        this.$sessionId = str;
        this.this$0 = mediaChannelShareLoadInfoHelper;
        this.$shareType = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaChannelShareLoadInfoHelper$doFetchShareLoadInfo$1(this.$sessionId, this.this$0, this.$shareType, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            g.Companion companion = com.tencent.mobileqq.guild.media.thirdapp.share.g.INSTANCE;
            String str = this.$sessionId;
            companion.a(str, new a(this.this$0, this.$shareType, str));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaChannelShareLoadInfoHelper$doFetchShareLoadInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
