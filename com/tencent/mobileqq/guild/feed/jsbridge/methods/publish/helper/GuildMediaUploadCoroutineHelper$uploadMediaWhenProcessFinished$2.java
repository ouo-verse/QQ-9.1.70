package com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.publish.event.GuildOnPhotoSelectedEvent;
import com.tencent.mobileqq.guild.feed.publish.result.SelectPhotoResult;
import com.tencent.mobileqq.guild.feed.publish.result.SelectVideoResult;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rk1.n;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildMediaUploadCoroutineHelper$uploadMediaWhenProcessFinished$2", f = "GuildMediaUploadCoroutineHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildMediaUploadCoroutineHelper$uploadMediaWhenProcessFinished$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ GuildOnPhotoSelectedEvent $event;
    final /* synthetic */ n $publishConfigMethod;
    final /* synthetic */ Deferred<Object>[] $results;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildMediaUploadCoroutineHelper$uploadMediaWhenProcessFinished$2$1", f = "GuildMediaUploadCoroutineHelper.kt", i = {0, 0, 0, 0}, l = {143}, m = "invokeSuspend", n = {"$this$launch", "$this$forEachIndexed$iv", "index$iv", "idx"}, s = {"L$0", "L$1", "I$0", "I$3"})
    /* renamed from: com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildMediaUploadCoroutineHelper$uploadMediaWhenProcessFinished$2$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GuildOnPhotoSelectedEvent $event;
        final /* synthetic */ n $publishConfigMethod;
        final /* synthetic */ Deferred<Object>[] $results;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Deferred<Object>[] deferredArr, n nVar, GuildOnPhotoSelectedEvent guildOnPhotoSelectedEvent, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$results = deferredArr;
            this.$publishConfigMethod = nVar;
            this.$event = guildOnPhotoSelectedEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$results, this.$publishConfigMethod, this.$event, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x014b  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0091  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0058 -> B:8:0x0144). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x008c -> B:5:0x008f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            CoroutineScope coroutineScope;
            Deferred<Object>[] deferredArr;
            int length;
            int i3;
            GuildOnPhotoSelectedEvent guildOnPhotoSelectedEvent;
            AnonymousClass1 anonymousClass1;
            n nVar;
            int i16;
            int i17;
            Object obj2;
            Object orNull;
            String str;
            Object orNull2;
            String str2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i18 = this.label;
            int i19 = 1;
            if (i18 != 0) {
                if (i18 == 1) {
                    i3 = this.I$3;
                    length = this.I$2;
                    i16 = this.I$1;
                    int i26 = this.I$0;
                    guildOnPhotoSelectedEvent = (GuildOnPhotoSelectedEvent) this.L$3;
                    nVar = (n) this.L$2;
                    deferredArr = (Deferred[]) this.L$1;
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Object await = obj;
                    int i27 = i26;
                    anonymousClass1 = this;
                    if (await == null) {
                        Logger.f235387a.d().d("GuildMediaUploadCoroutineHelper", i19, "null select result when upload media--idx" + i3);
                        obj2 = coroutine_suspended;
                        i17 = i19;
                    } else {
                        if (await instanceof SelectVideoResult) {
                            Logger.a d16 = Logger.f235387a.d();
                            List<LocalMediaInfo> list = guildOnPhotoSelectedEvent.localMediaInfos;
                            Intrinsics.checkNotNullExpressionValue(list, "event.localMediaInfos");
                            orNull2 = CollectionsKt___CollectionsKt.getOrNull(list, i3);
                            LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull2;
                            if (localMediaInfo != null) {
                                str2 = localMediaInfo.path;
                            } else {
                                str2 = null;
                            }
                            StringBuilder sb5 = new StringBuilder();
                            obj2 = coroutine_suspended;
                            sb5.append("upload video--idx:");
                            sb5.append(i3);
                            sb5.append(",path:");
                            sb5.append(str2);
                            d16.d("GuildMediaUploadCoroutineHelper", 1, sb5.toString());
                            nVar.i(((SelectVideoResult) await).c());
                        } else {
                            obj2 = coroutine_suspended;
                            if (await instanceof SelectPhotoResult) {
                                Logger.a d17 = Logger.f235387a.d();
                                List<LocalMediaInfo> list2 = guildOnPhotoSelectedEvent.localMediaInfos;
                                Intrinsics.checkNotNullExpressionValue(list2, "event.localMediaInfos");
                                orNull = CollectionsKt___CollectionsKt.getOrNull(list2, i3);
                                LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) orNull;
                                if (localMediaInfo2 != null) {
                                    str = localMediaInfo2.path;
                                } else {
                                    str = null;
                                }
                                i17 = 1;
                                d17.d("GuildMediaUploadCoroutineHelper", 1, "upload photo--idx:" + i3 + ",path:" + str);
                                nVar.i(((SelectPhotoResult) await).c());
                            }
                        }
                        i17 = 1;
                    }
                    coroutine_suspended = obj2;
                    i16 += i17;
                    i19 = i17;
                    i3 = i27;
                    if (i16 >= length) {
                        Deferred<Object> deferred = deferredArr[i16];
                        i27 = i3 + 1;
                        if (deferred == null) {
                            Logger.f235387a.d().d("GuildMediaUploadCoroutineHelper", i19, "null deferred when upload media--idx" + i3);
                            i17 = i19;
                            i16 += i17;
                            i19 = i17;
                            i3 = i27;
                            if (i16 >= length) {
                                return Unit.INSTANCE;
                            }
                        } else {
                            anonymousClass1.L$0 = coroutineScope;
                            anonymousClass1.L$1 = deferredArr;
                            anonymousClass1.L$2 = nVar;
                            anonymousClass1.L$3 = guildOnPhotoSelectedEvent;
                            anonymousClass1.I$0 = i27;
                            anonymousClass1.I$1 = i16;
                            anonymousClass1.I$2 = length;
                            anonymousClass1.I$3 = i3;
                            anonymousClass1.label = i19;
                            await = deferred.await(anonymousClass1);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (await == null) {
                            }
                            coroutine_suspended = obj2;
                            i16 += i17;
                            i19 = i17;
                            i3 = i27;
                            if (i16 >= length) {
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                Deferred<Object>[] deferredArr2 = this.$results;
                n nVar2 = this.$publishConfigMethod;
                GuildOnPhotoSelectedEvent guildOnPhotoSelectedEvent2 = this.$event;
                coroutineScope = coroutineScope2;
                deferredArr = deferredArr2;
                length = deferredArr2.length;
                i3 = 0;
                guildOnPhotoSelectedEvent = guildOnPhotoSelectedEvent2;
                anonymousClass1 = this;
                nVar = nVar2;
                i16 = 0;
                if (i16 >= length) {
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaUploadCoroutineHelper$uploadMediaWhenProcessFinished$2(Deferred<Object>[] deferredArr, n nVar, GuildOnPhotoSelectedEvent guildOnPhotoSelectedEvent, Continuation<? super GuildMediaUploadCoroutineHelper$uploadMediaWhenProcessFinished$2> continuation) {
        super(2, continuation);
        this.$results = deferredArr;
        this.$publishConfigMethod = nVar;
        this.$event = guildOnPhotoSelectedEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildMediaUploadCoroutineHelper$uploadMediaWhenProcessFinished$2 guildMediaUploadCoroutineHelper$uploadMediaWhenProcessFinished$2 = new GuildMediaUploadCoroutineHelper$uploadMediaWhenProcessFinished$2(this.$results, this.$publishConfigMethod, this.$event, continuation);
        guildMediaUploadCoroutineHelper$uploadMediaWhenProcessFinished$2.L$0 = obj;
        return guildMediaUploadCoroutineHelper$uploadMediaWhenProcessFinished$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Job launch$default;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            launch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.$results, this.$publishConfigMethod, this.$event, null), 3, null);
            return launch$default;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Job> continuation) {
        return ((GuildMediaUploadCoroutineHelper$uploadMediaWhenProcessFinished$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
