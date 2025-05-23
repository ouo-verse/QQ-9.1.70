package com.tencent.mobileqq.nearbypro.avatar;

import com.tencent.mobileqq.nearbypro.repository.service.AvatarService;
import com.tencent.state.square.avatar.filament.LoadFilamentAssetsStatistics;
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
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lorg/json/JSONObject;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.avatar.NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1$guestDeferred$1", f = "NearbyProAvatarActionHelper.kt", i = {0}, l = {101}, m = "invokeSuspend", n = {"startTs"}, s = {"J$0"})
/* loaded from: classes15.dex */
public final class NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1$guestDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JSONObject>, Object> {
    final /* synthetic */ Long $guestUin;
    final /* synthetic */ LoadFilamentAssetsStatistics $statistics;
    long J$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1$guestDeferred$1(Long l3, LoadFilamentAssetsStatistics loadFilamentAssetsStatistics, Continuation<? super NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1$guestDeferred$1> continuation) {
        super(2, continuation);
        this.$guestUin = l3;
        this.$statistics = loadFilamentAssetsStatistics;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1$guestDeferred$1(this.$guestUin, this.$statistics, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        LoadFilamentAssetsStatistics loadFilamentAssetsStatistics;
        long j3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                j3 = this.J$0;
                loadFilamentAssetsStatistics = (LoadFilamentAssetsStatistics) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Long l3 = this.$guestUin;
            if (l3 != null) {
                LoadFilamentAssetsStatistics loadFilamentAssetsStatistics2 = this.$statistics;
                long longValue = l3.longValue();
                long currentTimeMillis = System.currentTimeMillis();
                AvatarService avatarService = AvatarService.INSTANCE;
                this.L$0 = loadFilamentAssetsStatistics2;
                this.J$0 = currentTimeMillis;
                this.label = 1;
                obj = avatarService.reqAvatarInfo(longValue, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                loadFilamentAssetsStatistics = loadFilamentAssetsStatistics2;
                j3 = currentTimeMillis;
            } else {
                return null;
            }
        }
        JSONObject jSONObject = (JSONObject) obj;
        loadFilamentAssetsStatistics.setLoadGuestAvatarInfoCost(System.currentTimeMillis() - j3);
        return jSONObject;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super JSONObject> continuation) {
        return ((NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1$guestDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
