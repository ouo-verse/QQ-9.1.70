package com.tencent.mobileqq.nearbypro.avatar;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.state.square.avatar.filament.AnimType;
import com.tencent.state.square.avatar.filament.AvatarType;
import com.tencent.state.square.avatar.filament.IActionHelper;
import com.tencent.state.square.avatar.filament.LoadFilamentAssetsStatistics;
import com.tencent.state.square.avatar.filament.MoodConfig;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J9\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ?\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/avatar/NearbyProAvatarActionHelper;", "Lcom/tencent/state/square/avatar/filament/IActionHelper;", "", "hostUin", "guestUin", "", "url", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/nearbypro/avatar/d;", "Lcom/tencent/state/square/avatar/filament/LoadFilamentAssetsStatistics;", "a", "(JLjava/lang/Long;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Triple;", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "loadPlayParams", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProAvatarActionHelper implements IActionHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NearbyProAvatarActionHelper f253199a = new NearbyProAvatarActionHelper();

    NearbyProAvatarActionHelper() {
    }

    private final Object a(long j3, Long l3, String str, Continuation<? super Pair<FilamentPlayRawData, LoadFilamentAssetsStatistics>> continuation) {
        Continuation intercepted;
        final Job launch$default;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(cancellableContinuationImpl.get$context()), null, null, new NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$job$1(cancellableContinuationImpl, j3, l3, str, new LoadFilamentAssetsStatistics(0L, false, 0L, 0L, 15, null), null), 3, null);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.nearbypro.avatar.NearbyProAvatarActionHelper$loadMoodConfigAndAvatarInfo$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                Job.DefaultImpls.cancel$default(Job.this, (CancellationException) null, 1, (Object) null);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    @Override // com.tencent.state.square.avatar.filament.IActionHelper
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadPlayParams(long j3, @Nullable Long l3, @NotNull String str, @NotNull Continuation<? super Triple<MoodConfig, SquareAvatarData, LoadFilamentAssetsStatistics>> continuation) {
        NearbyProAvatarActionHelper$loadPlayParams$1 nearbyProAvatarActionHelper$loadPlayParams$1;
        Object coroutine_suspended;
        int i3;
        Long l16;
        long j16;
        Object a16;
        String str2;
        MoodConfig moodConfig;
        AnimType animType;
        AnimType animType2;
        SquareAvatarData.AvatarData avatarData;
        if (continuation instanceof NearbyProAvatarActionHelper$loadPlayParams$1) {
            nearbyProAvatarActionHelper$loadPlayParams$1 = (NearbyProAvatarActionHelper$loadPlayParams$1) continuation;
            int i16 = nearbyProAvatarActionHelper$loadPlayParams$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                nearbyProAvatarActionHelper$loadPlayParams$1.label = i16 - Integer.MIN_VALUE;
                NearbyProAvatarActionHelper$loadPlayParams$1 nearbyProAvatarActionHelper$loadPlayParams$12 = nearbyProAvatarActionHelper$loadPlayParams$1;
                Object obj = nearbyProAvatarActionHelper$loadPlayParams$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = nearbyProAvatarActionHelper$loadPlayParams$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        long j17 = nearbyProAvatarActionHelper$loadPlayParams$12.J$0;
                        str2 = (String) nearbyProAvatarActionHelper$loadPlayParams$12.L$1;
                        Long l17 = (Long) nearbyProAvatarActionHelper$loadPlayParams$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        j16 = j17;
                        a16 = obj;
                        l16 = l17;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    l16 = l3;
                    nearbyProAvatarActionHelper$loadPlayParams$12.L$0 = l16;
                    nearbyProAvatarActionHelper$loadPlayParams$12.L$1 = str;
                    j16 = j3;
                    nearbyProAvatarActionHelper$loadPlayParams$12.J$0 = j16;
                    nearbyProAvatarActionHelper$loadPlayParams$12.label = 1;
                    a16 = a(j3, l3, str, nearbyProAvatarActionHelper$loadPlayParams$12);
                    if (a16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str2 = str;
                }
                Pair pair = (Pair) a16;
                FilamentPlayRawData filamentPlayRawData = (FilamentPlayRawData) pair.component1();
                LoadFilamentAssetsStatistics loadFilamentAssetsStatistics = (LoadFilamentAssetsStatistics) pair.component2();
                moodConfig = filamentPlayRawData.getMoodConfig();
                JSONObject hostAvatarInfo = filamentPlayRawData.getHostAvatarInfo();
                JSONObject guestAvatarInfo = filamentPlayRawData.getGuestAvatarInfo();
                j.c().c("NearbyProAvatarActionHelper", "loadPlayParams hostUin: " + j16 + ", guestUin: " + l16 + ", url: " + str2 + " \n moodConfig: " + moodConfig + ", \n hostAvatarInfo: " + hostAvatarInfo + ", \n guestAvatarInfo: " + guestAvatarInfo);
                EnumUserGender.Companion companion = EnumUserGender.INSTANCE;
                EnumUserGender a17 = companion.a(hostAvatarInfo.optInt("gender", 0));
                AvatarType avatarType = AvatarType.HOST;
                animType = AnimType.IDLE;
                SquareAvatarData.AvatarAnim avatarAnim = moodConfig.getAvatarAnim(a17, avatarType, animType);
                String jSONObject = hostAvatarInfo.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "hostAvatarInfo.toString()");
                SquareAvatarData.AvatarData avatarData2 = new SquareAvatarData.AvatarData(j16, a17, avatarAnim, jSONObject);
                if (!moodConfig.hasGuest() && l16 != null && guestAvatarInfo != null) {
                    EnumUserGender a18 = companion.a(guestAvatarInfo.optInt("gender", 0));
                    long longValue = l16.longValue();
                    animType2 = animType;
                    SquareAvatarData.AvatarAnim avatarAnim2 = moodConfig.getAvatarAnim(a18, AvatarType.GUEST, animType2);
                    String jSONObject2 = guestAvatarInfo.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "guestAvatarInfo.toString()");
                    avatarData = new SquareAvatarData.AvatarData(longValue, a18, avatarAnim2, jSONObject2);
                } else {
                    animType2 = animType;
                    avatarData = null;
                }
                return new Triple(moodConfig, new SquareAvatarData(avatarData2, avatarData, moodConfig.getExtraActorData(animType2, a17), moodConfig.getLightInfo(), moodConfig.getCameraInfo()), loadFilamentAssetsStatistics);
            }
        }
        nearbyProAvatarActionHelper$loadPlayParams$1 = new NearbyProAvatarActionHelper$loadPlayParams$1(this, continuation);
        NearbyProAvatarActionHelper$loadPlayParams$1 nearbyProAvatarActionHelper$loadPlayParams$122 = nearbyProAvatarActionHelper$loadPlayParams$1;
        Object obj2 = nearbyProAvatarActionHelper$loadPlayParams$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = nearbyProAvatarActionHelper$loadPlayParams$122.label;
        if (i3 == 0) {
        }
        Pair pair2 = (Pair) a16;
        FilamentPlayRawData filamentPlayRawData2 = (FilamentPlayRawData) pair2.component1();
        LoadFilamentAssetsStatistics loadFilamentAssetsStatistics2 = (LoadFilamentAssetsStatistics) pair2.component2();
        moodConfig = filamentPlayRawData2.getMoodConfig();
        JSONObject hostAvatarInfo2 = filamentPlayRawData2.getHostAvatarInfo();
        JSONObject guestAvatarInfo2 = filamentPlayRawData2.getGuestAvatarInfo();
        j.c().c("NearbyProAvatarActionHelper", "loadPlayParams hostUin: " + j16 + ", guestUin: " + l16 + ", url: " + str2 + " \n moodConfig: " + moodConfig + ", \n hostAvatarInfo: " + hostAvatarInfo2 + ", \n guestAvatarInfo: " + guestAvatarInfo2);
        EnumUserGender.Companion companion2 = EnumUserGender.INSTANCE;
        EnumUserGender a172 = companion2.a(hostAvatarInfo2.optInt("gender", 0));
        AvatarType avatarType2 = AvatarType.HOST;
        animType = AnimType.IDLE;
        SquareAvatarData.AvatarAnim avatarAnim3 = moodConfig.getAvatarAnim(a172, avatarType2, animType);
        String jSONObject3 = hostAvatarInfo2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "hostAvatarInfo.toString()");
        SquareAvatarData.AvatarData avatarData22 = new SquareAvatarData.AvatarData(j16, a172, avatarAnim3, jSONObject3);
        if (!moodConfig.hasGuest()) {
        }
        animType2 = animType;
        avatarData = null;
        return new Triple(moodConfig, new SquareAvatarData(avatarData22, avatarData, moodConfig.getExtraActorData(animType2, a172), moodConfig.getLightInfo(), moodConfig.getCameraInfo()), loadFilamentAssetsStatistics2);
    }
}
