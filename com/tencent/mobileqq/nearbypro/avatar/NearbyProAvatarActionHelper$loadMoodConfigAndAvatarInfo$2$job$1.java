package com.tencent.mobileqq.nearbypro.avatar;

import com.tencent.state.square.avatar.filament.LoadFilamentAssetsStatistics;
import com.tencent.state.square.avatar.filament.MoodConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.avatar.NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1", f = "NearbyProAvatarActionHelper.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
final class NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $guestUin;
    final /* synthetic */ long $hostUin;
    final /* synthetic */ CancellableContinuation<Pair<FilamentPlayRawData, LoadFilamentAssetsStatistics>> $it;
    final /* synthetic */ LoadFilamentAssetsStatistics $statistics;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1(CancellableContinuation<? super Pair<FilamentPlayRawData, LoadFilamentAssetsStatistics>> cancellableContinuation, long j3, Long l3, String str, LoadFilamentAssetsStatistics loadFilamentAssetsStatistics, Continuation<? super NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1> continuation) {
        super(2, continuation);
        this.$it = cancellableContinuation;
        this.$hostUin = j3;
        this.$guestUin = l3;
        this.$url = str;
        this.$statistics = loadFilamentAssetsStatistics;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1 nearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1 = new NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1(this.$it, this.$hostUin, this.$guestUin, this.$url, this.$statistics, continuation);
        nearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1.L$0 = obj;
        return nearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        Deferred async$default3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        JSONObject jSONObject = null;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1$moodConfigDeferred$1(this.$url, this.$statistics, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1$hostDeferred$1(this.$hostUin, this.$statistics, null), 3, null);
            async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1$guestDeferred$1(this.$guestUin, this.$statistics, null), 3, null);
            this.label = 1;
            obj = AwaitKt.awaitAll(new Deferred[]{async$default, async$default2, async$default3}, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        List list = (List) obj;
        Object obj2 = list.get(0);
        Object obj3 = list.get(1);
        Object obj4 = list.get(2);
        if (obj2 != null && (obj2 instanceof MoodConfig)) {
            if (obj3 != null && (obj3 instanceof JSONObject)) {
                CancellableContinuation<Pair<FilamentPlayRawData, LoadFilamentAssetsStatistics>> cancellableContinuation = this.$it;
                Result.Companion companion = Result.INSTANCE;
                MoodConfig moodConfig = (MoodConfig) obj2;
                JSONObject jSONObject2 = (JSONObject) obj3;
                if (obj4 instanceof JSONObject) {
                    jSONObject = (JSONObject) obj4;
                }
                cancellableContinuation.resumeWith(Result.m476constructorimpl(new Pair(new FilamentPlayRawData(moodConfig, jSONObject2, jSONObject), this.$statistics)));
            } else {
                CancellableContinuation<Pair<FilamentPlayRawData, LoadFilamentAssetsStatistics>> cancellableContinuation2 = this.$it;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("NearbyProAvatarActionHelper loadAvatarInfo hostAvatar failed, uin:" + this.$hostUin))));
            }
        } else {
            CancellableContinuation<Pair<FilamentPlayRawData, LoadFilamentAssetsStatistics>> cancellableContinuation3 = this.$it;
            Result.Companion companion3 = Result.INSTANCE;
            cancellableContinuation3.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception("NearbyProAvatarActionHelper loadActionInfo moodConfig failed, uin:" + this.$hostUin + ", guestUin:" + this.$guestUin + ", url:" + this.$url))));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
