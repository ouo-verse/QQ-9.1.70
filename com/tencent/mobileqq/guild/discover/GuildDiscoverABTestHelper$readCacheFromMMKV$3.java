package com.tencent.mobileqq.guild.discover;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper$readCacheFromMMKV$3", f = "GuildDiscoverABTestHelper.kt", i = {}, l = {325}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildDiscoverABTestHelper$readCacheFromMMKV$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper$readCacheFromMMKV$3$1", f = "GuildDiscoverABTestHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper$readCacheFromMMKV$3$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GuildDiscoverABTestHelper.ExpDataForCacheSave $expDataCache;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GuildDiscoverABTestHelper.ExpDataForCacheSave expDataForCacheSave, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$expDataCache = expDataForCacheSave;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$expDataCache, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (GuildDiscoverABTestHelper.expData == null) {
                    GuildDiscoverABTestHelper.expData = this.$expDataCache;
                    GuildDiscoverABTestHelper.f216488d.H();
                    Logger logger = Logger.f235387a;
                    GuildDiscoverABTestHelper.ExpDataForCacheSave expDataForCacheSave = this.$expDataCache;
                    logger.d().i("Guild.discovery.GuildDiscoverABTestHelper", 1, "readCache(" + GuildDiscoverABTestHelper.accountUin + "), expData: " + expDataForCacheSave);
                }
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
    public GuildDiscoverABTestHelper$readCacheFromMMKV$3(Continuation<? super GuildDiscoverABTestHelper$readCacheFromMMKV$3> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildDiscoverABTestHelper$readCacheFromMMKV$3(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        GuildDiscoverABTestHelper.ExpDataForCacheSave expDataForCacheSave;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            try {
                expDataForCacheSave = (GuildDiscoverABTestHelper.ExpDataForCacheSave) new Gson().fromJson(bw.f235485a.r(), GuildDiscoverABTestHelper.ExpDataForCacheSave.class);
            } catch (JsonSyntaxException unused) {
                expDataForCacheSave = null;
            }
            i.e eVar = i.e.f261783e;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(expDataForCacheSave, null);
            this.label = 1;
            if (CorountineFunKt.i(eVar, "readCacheFromMMKV", null, anonymousClass1, this, 4, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildDiscoverABTestHelper$readCacheFromMMKV$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
