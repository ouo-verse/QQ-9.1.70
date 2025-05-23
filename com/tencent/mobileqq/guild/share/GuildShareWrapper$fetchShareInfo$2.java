package com.tencent.mobileqq.guild.share;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.av;
import com.tencent.mobileqq.qqguildsdk.data.genc.ey;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.share.GuildShareWrapper$fetchShareInfo$2", f = "GuildShareWrapper.kt", i = {0, 1}, l = {60, 61, 64}, m = "invokeSuspend", n = {"deferred2", "shortUrlResult"}, s = {"L$0", "L$0"})
/* loaded from: classes14.dex */
public final class GuildShareWrapper$fetchShareInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $businessParam;
    final /* synthetic */ int $businessType;
    final /* synthetic */ t $cb;
    final /* synthetic */ long $channelIdLong;
    final /* synthetic */ long $guildIdLong;
    final /* synthetic */ ArrayList<ey> $urlParams;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.share.GuildShareWrapper$fetchShareInfo$2$1", f = "GuildShareWrapper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.share.GuildShareWrapper$fetchShareInfo$2$1, reason: invalid class name */
    /* loaded from: classes14.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ t $cb;
        final /* synthetic */ ShareInfoResult $longUrlResult;
        final /* synthetic */ ShareInfoResult $shortUrlResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(t tVar, ShareInfoResult shareInfoResult, ShareInfoResult shareInfoResult2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$cb = tVar;
            this.$shortUrlResult = shareInfoResult;
            this.$longUrlResult = shareInfoResult2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$cb, this.$shortUrlResult, this.$longUrlResult, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$cb.a(this.$shortUrlResult);
                Logger logger = Logger.f235387a;
                ShareInfoResult shareInfoResult = this.$shortUrlResult;
                ShareInfoResult shareInfoResult2 = this.$longUrlResult;
                logger.d().i("Guild.share.GuildShareWrapper", 1, "fetchShareInfo short:" + shareInfoResult.getShareUrl() + " long:" + shareInfoResult2.getShareUrl() + " ");
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildShareWrapper$fetchShareInfo$2(int i3, byte[] bArr, ArrayList<ey> arrayList, long j3, long j16, t tVar, Continuation<? super GuildShareWrapper$fetchShareInfo$2> continuation) {
        super(2, continuation);
        this.$businessType = i3;
        this.$businessParam = bArr;
        this.$urlParams = arrayList;
        this.$guildIdLong = j3;
        this.$channelIdLong = j16;
        this.$cb = tVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildShareWrapper$fetchShareInfo$2 guildShareWrapper$fetchShareInfo$2 = new GuildShareWrapper$fetchShareInfo$2(this.$businessType, this.$businessParam, this.$urlParams, this.$guildIdLong, this.$channelIdLong, this.$cb, continuation);
        guildShareWrapper$fetchShareInfo$2.L$0 = obj;
        return guildShareWrapper$fetchShareInfo$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b9 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        av h16;
        av h17;
        Deferred async$default;
        Deferred async$default2;
        Object await;
        ShareInfoResult shareInfoResult;
        Object await2;
        String d16;
        MainCoroutineDispatcher main;
        AnonymousClass1 anonymousClass1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ShareInfoResult shareInfoResult2 = (ShareInfoResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                shareInfoResult = shareInfoResult2;
                await2 = obj;
                ShareInfoResult shareInfoResult3 = (ShareInfoResult) await2;
                d16 = GuildShareWrapper.f234954a.d(shareInfoResult, shareInfoResult3);
                shareInfoResult.i(d16);
                main = Dispatchers.getMain();
                anonymousClass1 = new AnonymousClass1(this.$cb, shareInfoResult, shareInfoResult3, null);
                this.L$0 = null;
                this.label = 3;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            async$default2 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
            await = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            GuildShareWrapper guildShareWrapper = GuildShareWrapper.f234954a;
            h16 = guildShareWrapper.h(this.$businessType, this.$businessParam, this.$urlParams, true);
            h17 = guildShareWrapper.h(this.$businessType, this.$businessParam, this.$urlParams, false);
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new GuildShareWrapper$fetchShareInfo$2$deferred1$1(this.$guildIdLong, this.$channelIdLong, h16, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new GuildShareWrapper$fetchShareInfo$2$deferred2$1(this.$guildIdLong, this.$channelIdLong, h17, null), 3, null);
            this.L$0 = async$default2;
            this.label = 1;
            await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        shareInfoResult = (ShareInfoResult) await;
        this.L$0 = shareInfoResult;
        this.label = 2;
        await2 = async$default2.await(this);
        if (await2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        ShareInfoResult shareInfoResult32 = (ShareInfoResult) await2;
        d16 = GuildShareWrapper.f234954a.d(shareInfoResult, shareInfoResult32);
        shareInfoResult.i(d16);
        main = Dispatchers.getMain();
        anonymousClass1 = new AnonymousClass1(this.$cb, shareInfoResult, shareInfoResult32, null);
        this.L$0 = null;
        this.label = 3;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildShareWrapper$fetchShareInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
