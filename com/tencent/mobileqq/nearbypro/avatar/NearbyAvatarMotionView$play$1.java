package com.tencent.mobileqq.nearbypro.avatar;

import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.state.square.avatar.filament.LoadFilamentAssetsStatistics;
import com.tencent.state.square.avatar.filament.MoodConfig;
import com.tencent.state.square.media.MapPlayableSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarMotionView$play$1", f = "NearbyAvatarMotionView.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes15.dex */
public final class NearbyAvatarMotionView$play$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $curDataTag;
    final /* synthetic */ Long $guestUin;
    final /* synthetic */ Function2<CoroutineContext, Throwable, Unit> $handleException;
    final /* synthetic */ long $hostUin;
    final /* synthetic */ MapPlayableSource $playableSource;
    int label;
    final /* synthetic */ NearbyAvatarMotionView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NearbyAvatarMotionView$play$1(long j3, Long l3, MapPlayableSource mapPlayableSource, Function2<? super CoroutineContext, ? super Throwable, Unit> function2, NearbyAvatarMotionView nearbyAvatarMotionView, String str, Continuation<? super NearbyAvatarMotionView$play$1> continuation) {
        super(1, continuation);
        this.$hostUin = j3;
        this.$guestUin = l3;
        this.$playableSource = mapPlayableSource;
        this.$handleException = function2;
        this.this$0 = nearbyAvatarMotionView;
        this.$curDataTag = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new NearbyAvatarMotionView$play$1(this.$hostUin, this.$guestUin, this.$playableSource, this.$handleException, this.this$0, this.$curDataTag, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean q16;
        IFilamentNativeAppV2305 iFilamentNativeAppV2305;
        com.tencent.zplan.zplantracing.b bVar;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        String str2 = null;
        com.tencent.zplan.zplantracing.c cVar = null;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                NearbyProAvatarActionHelper nearbyProAvatarActionHelper = NearbyProAvatarActionHelper.f253199a;
                long j3 = this.$hostUin;
                Long l3 = this.$guestUin;
                String remoteUrl = this.$playableSource.getRemoteUrl();
                this.label = 1;
                obj = nearbyProAvatarActionHelper.loadPlayParams(j3, l3, remoteUrl, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            Triple triple = (Triple) obj;
            MoodConfig moodConfig = (MoodConfig) triple.component1();
            SquareAvatarData squareAvatarData = (SquareAvatarData) triple.component2();
            LoadFilamentAssetsStatistics loadFilamentAssetsStatistics = (LoadFilamentAssetsStatistics) triple.component3();
            SquareAvatarData.AvatarData host = squareAvatarData.getHost();
            SquareAvatarData.AvatarData guest = squareAvatarData.getGuest();
            if (host.getAvatarInfoStr().length() > 2 && (guest == null || guest.getAvatarInfoStr().length() > 2)) {
                j.c().e("NearbyAvatarMotionView", "loadPlayParams: mcCost=" + loadFilamentAssetsStatistics.getLoadMoodConfigCost() + ", mcFromNet:" + loadFilamentAssetsStatistics.getLoadMoodConfigFromNet() + ", hostInfoCost:" + loadFilamentAssetsStatistics.getLoadHostAvatarInfoCost() + ", guestInfoCost:" + loadFilamentAssetsStatistics.getLoadGuestAvatarInfoCost());
                final NearbyAvatarMotionView nearbyAvatarMotionView = this.this$0;
                String str3 = this.$curDataTag;
                synchronized (nearbyAvatarMotionView) {
                    q16 = nearbyAvatarMotionView.q(str3);
                    if (!q16) {
                        nearbyAvatarMotionView.currentAvatarData = squareAvatarData;
                        nearbyAvatarMotionView.currentMoodConfig = moodConfig;
                        iFilamentNativeAppV2305 = nearbyAvatarMotionView.filamentApp;
                        if (iFilamentNativeAppV2305 != null) {
                            bVar = nearbyAvatarMotionView.filamentSpan;
                            if (bVar != null) {
                                cVar = bVar.c();
                            }
                            iFilamentNativeAppV2305.dispatchEvent(cVar, "SquareAvatarScene.ON_LOAD", squareAvatarData.toJson());
                        }
                        j.g().postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarMotionView$play$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                NearbyAvatarMotionView.this.x();
                            }
                        });
                        return Unit.INSTANCE;
                    }
                    ga2.a c16 = j.c();
                    str = nearbyAvatarMotionView.dataTag;
                    c16.e("NearbyAvatarMotionView", "playData changed, cancel play " + str3 + " != " + str);
                    return Unit.INSTANCE;
                }
            }
            ga2.a c17 = j.c();
            String avatarInfoStr = host.getAvatarInfoStr();
            if (guest != null) {
                str2 = guest.getAvatarInfoStr();
            }
            c17.d("NearbyAvatarMotionView", "failed to load user avatar info: host=[" + avatarInfoStr + "], guest=[" + str2 + "]");
            return Unit.INSTANCE;
        } catch (Exception e16) {
            this.$handleException.invoke(null, e16);
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((NearbyAvatarMotionView$play$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
