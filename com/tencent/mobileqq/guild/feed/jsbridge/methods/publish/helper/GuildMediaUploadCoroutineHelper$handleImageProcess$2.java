package com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.publish.result.SelectPhotoResult;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Deferred;", "Lcom/tencent/mobileqq/guild/feed/publish/result/SelectPhotoResult;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildMediaUploadCoroutineHelper$handleImageProcess$2", f = "GuildMediaUploadCoroutineHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildMediaUploadCoroutineHelper$handleImageProcess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends SelectPhotoResult>>, Object> {
    final /* synthetic */ GuildUploadHelper $instance;
    final /* synthetic */ LocalMediaInfo $localMediaInfo;
    final /* synthetic */ String $photoPath;
    final /* synthetic */ String $taskId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/guild/feed/publish/result/SelectPhotoResult;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildMediaUploadCoroutineHelper$handleImageProcess$2$1", f = "GuildMediaUploadCoroutineHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildMediaUploadCoroutineHelper$handleImageProcess$2$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SelectPhotoResult>, Object> {
        final /* synthetic */ GuildUploadHelper $instance;
        final /* synthetic */ LocalMediaInfo $localMediaInfo;
        final /* synthetic */ String $photoPath;
        final /* synthetic */ String $taskId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GuildUploadHelper guildUploadHelper, LocalMediaInfo localMediaInfo, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$instance = guildUploadHelper;
            this.$localMediaInfo = localMediaInfo;
            this.$taskId = str;
            this.$photoPath = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$instance, this.$localMediaInfo, this.$taskId, this.$photoPath, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    ArrayList arrayList = new ArrayList();
                    this.$instance.n(arrayList, this.$localMediaInfo, this.$taskId, this.$photoPath);
                    return new SelectPhotoResult(arrayList, this.$instance.h());
                } catch (Exception e16) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "handleImageProcess--error:" + e16.getMessage();
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("GuildMediaUploadCoroutineHelper", 1, (String) it.next(), null);
                    }
                    return null;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SelectPhotoResult> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaUploadCoroutineHelper$handleImageProcess$2(GuildUploadHelper guildUploadHelper, LocalMediaInfo localMediaInfo, String str, String str2, Continuation<? super GuildMediaUploadCoroutineHelper$handleImageProcess$2> continuation) {
        super(2, continuation);
        this.$instance = guildUploadHelper;
        this.$localMediaInfo = localMediaInfo;
        this.$taskId = str;
        this.$photoPath = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildMediaUploadCoroutineHelper$handleImageProcess$2 guildMediaUploadCoroutineHelper$handleImageProcess$2 = new GuildMediaUploadCoroutineHelper$handleImageProcess$2(this.$instance, this.$localMediaInfo, this.$taskId, this.$photoPath, continuation);
        guildMediaUploadCoroutineHelper$handleImageProcess$2.L$0 = obj;
        return guildMediaUploadCoroutineHelper$handleImageProcess$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Deferred async$default;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.$instance, this.$localMediaInfo, this.$taskId, this.$photoPath, null), 3, null);
            return async$default;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Deferred<? extends SelectPhotoResult>> continuation) {
        return ((GuildMediaUploadCoroutineHelper$handleImageProcess$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
