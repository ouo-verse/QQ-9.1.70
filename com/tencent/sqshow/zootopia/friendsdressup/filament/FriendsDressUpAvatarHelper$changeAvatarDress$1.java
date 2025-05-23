package com.tencent.sqshow.zootopia.friendsdressup.filament;

import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import vk0.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.zootopia.friendsdressup.filament.FriendsDressUpAvatarHelper$changeAvatarDress$1", f = "FriendsDressUpAvatarHelper.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class FriendsDressUpAvatarHelper$changeAvatarDress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $callback;
    final /* synthetic */ long $uin;
    int label;
    final /* synthetic */ FriendsDressUpAvatarHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsDressUpAvatarHelper$changeAvatarDress$1(FriendsDressUpAvatarHelper friendsDressUpAvatarHelper, long j3, a aVar, Continuation<? super FriendsDressUpAvatarHelper$changeAvatarDress$1> continuation) {
        super(2, continuation);
        this.this$0 = friendsDressUpAvatarHelper;
        this.$uin = j3;
        this.$callback = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FriendsDressUpAvatarHelper$changeAvatarDress$1(this.this$0, this.$uin, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        FriendsDressUpBusinessScene friendsDressUpBusinessScene;
        uk0.e eVar;
        wk0.a aVar;
        uk0.e eVar2;
        wk0.a aVar2;
        wk0.a aVar3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentAvatarHelper", "changeAvatarDress, start");
            FriendsDressUpAvatarHelper friendsDressUpAvatarHelper = this.this$0;
            long j3 = this.$uin;
            this.label = 1;
            obj = friendsDressUpAvatarHelper.h(j3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        JSONObject jSONObject = (JSONObject) obj;
        friendsDressUpBusinessScene = this.this$0.scene;
        friendsDressUpBusinessScene.updateAvatarCharacter(jSONObject);
        this.$callback.preloadRes();
        com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentAvatarHelper", "changeAvatarDress paramStr:" + jSONObject);
        final long currentTimeMillis = System.currentTimeMillis();
        eVar = this.this$0.mListener;
        if (eVar != null) {
            aVar3 = this.this$0.filamentNativeApp;
            aVar3.t("onFirstFrameRenderEnd", eVar);
        }
        final FriendsDressUpAvatarHelper friendsDressUpAvatarHelper2 = this.this$0;
        final long j16 = this.$uin;
        final a aVar4 = this.$callback;
        friendsDressUpAvatarHelper2.mListener = new uk0.e() { // from class: com.tencent.sqshow.zootopia.friendsdressup.filament.FriendsDressUpAvatarHelper$changeAvatarDress$1.2
            @Override // uk0.e
            public void onEvent(String type, String eventData) {
                wk0.a aVar5;
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(eventData, "eventData");
                QLog.i("FilamentAvatarHelper", 1, "changeAvatarDress onEvent type:" + type + ", eventData:" + eventData);
                if (Intrinsics.areEqual(type, "onFirstFrameRenderEnd")) {
                    com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentAvatarHelper", "onCustomChange cost = " + (System.currentTimeMillis() - currentTimeMillis));
                    aVar5 = friendsDressUpAvatarHelper2.filamentNativeApp;
                    aVar5.removeEventListener("onFirstFrameRenderEnd");
                    final FriendsDressUpAvatarHelper friendsDressUpAvatarHelper3 = friendsDressUpAvatarHelper2;
                    final long j17 = j16;
                    final a aVar6 = aVar4;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.filament.FriendsDressUpAvatarHelper$changeAvatarDress$1$2$onEvent$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            AtomicLong atomicLong;
                            atomicLong = FriendsDressUpAvatarHelper.this.atomicUin;
                            if (atomicLong.get() == j17) {
                                com.tencent.sqshow.zootopia.friendsdressup.a.a("FilamentAvatarHelper", "changeAvatarDress, on first frame complete");
                                aVar6.b();
                            }
                        }
                    });
                }
            }
        };
        aVar = this.this$0.filamentNativeApp;
        eVar2 = this.this$0.mListener;
        Intrinsics.checkNotNull(eVar2);
        aVar.c("onFirstFrameRenderEnd", eVar2);
        aVar2 = this.this$0.filamentNativeApp;
        b.a.a(aVar2, "onCostumeChange", "", null, 4, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FriendsDressUpAvatarHelper$changeAvatarDress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
