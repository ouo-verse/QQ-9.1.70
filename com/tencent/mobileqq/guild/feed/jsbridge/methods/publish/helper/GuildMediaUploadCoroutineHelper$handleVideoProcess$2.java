package com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.publish.result.SelectVideoResult;
import com.tencent.mobileqq.guild.feed.util.GuildFeedMediaUtils;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Deferred;", "Lcom/tencent/mobileqq/guild/feed/publish/result/SelectVideoResult;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildMediaUploadCoroutineHelper$handleVideoProcess$2", f = "GuildMediaUploadCoroutineHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildMediaUploadCoroutineHelper$handleVideoProcess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends SelectVideoResult>>, Object> {
    final /* synthetic */ GuildUploadHelper $instance;
    final /* synthetic */ LocalMediaInfo $localMediaInfo;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $videoPath;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/guild/feed/publish/result/SelectVideoResult;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildMediaUploadCoroutineHelper$handleVideoProcess$2$1", f = "GuildMediaUploadCoroutineHelper.kt", i = {0}, l = {93}, m = "invokeSuspend", n = {"selectVideoResult"}, s = {"L$0"})
    /* renamed from: com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildMediaUploadCoroutineHelper$handleVideoProcess$2$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SelectVideoResult>, Object> {
        final /* synthetic */ GuildUploadHelper $instance;
        final /* synthetic */ LocalMediaInfo $localMediaInfo;
        final /* synthetic */ String $taskId;
        final /* synthetic */ String $videoPath;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GuildUploadHelper guildUploadHelper, LocalMediaInfo localMediaInfo, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$instance = guildUploadHelper;
            this.$localMediaInfo = localMediaInfo;
            this.$videoPath = str;
            this.$taskId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$instance, this.$localMediaInfo, this.$videoPath, this.$taskId, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Object e16;
            SelectVideoResult selectVideoResult;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
                if (i3 != 0) {
                    if (i3 == 1) {
                        selectVideoResult = (SelectVideoResult) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    SelectVideoResult selectVideoResult2 = new SelectVideoResult(this.$instance.h(), 1);
                    long j3 = this.$localMediaInfo.mDuration;
                    String thumbnailPath = GuildFeedMediaUtils.b(this.$videoPath);
                    String str = this.$taskId;
                    String str2 = this.$videoPath;
                    LocalMediaInfo localMediaInfo = this.$localMediaInfo;
                    selectVideoResult2.d(str, str2, j3, thumbnailPath);
                    GuildMediaUploadCoroutineHelper guildMediaUploadCoroutineHelper = GuildMediaUploadCoroutineHelper.f220036a;
                    Intrinsics.checkNotNullExpressionValue(thumbnailPath, "thumbnailPath");
                    this.L$0 = selectVideoResult2;
                    this.L$1 = selectVideoResult2;
                    this.label = 1;
                    e16 = guildMediaUploadCoroutineHelper.e(selectVideoResult2, localMediaInfo, str2, thumbnailPath, str, this);
                    if (e16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    selectVideoResult = selectVideoResult2;
                }
                return selectVideoResult;
            } catch (Exception e17) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str3 = "handleVideoProcess--error:" + e17.getMessage();
                if (str3 instanceof String) {
                    bVar.a().add(str3);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildMediaUploadCoroutineHelper", 1, (String) it.next(), null);
                }
                return null;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SelectVideoResult> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaUploadCoroutineHelper$handleVideoProcess$2(GuildUploadHelper guildUploadHelper, LocalMediaInfo localMediaInfo, String str, String str2, Continuation<? super GuildMediaUploadCoroutineHelper$handleVideoProcess$2> continuation) {
        super(2, continuation);
        this.$instance = guildUploadHelper;
        this.$localMediaInfo = localMediaInfo;
        this.$videoPath = str;
        this.$taskId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildMediaUploadCoroutineHelper$handleVideoProcess$2 guildMediaUploadCoroutineHelper$handleVideoProcess$2 = new GuildMediaUploadCoroutineHelper$handleVideoProcess$2(this.$instance, this.$localMediaInfo, this.$videoPath, this.$taskId, continuation);
        guildMediaUploadCoroutineHelper$handleVideoProcess$2.L$0 = obj;
        return guildMediaUploadCoroutineHelper$handleVideoProcess$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Deferred async$default;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.$instance, this.$localMediaInfo, this.$videoPath, this.$taskId, null), 3, null);
            return async$default;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Deferred<? extends SelectVideoResult>> continuation) {
        return ((GuildMediaUploadCoroutineHelper$handleVideoProcess$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
