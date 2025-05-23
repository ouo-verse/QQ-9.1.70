package com.tencent.filament.zplan.scene.square;

import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplan.scene.square.SquareAvatarScene;
import com.tencent.filament.zplanservice.util.log.FLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.square.SquareAvatarScene$NormalState$handleOnLoadEvent$1", f = "SquareAvatarScene.kt", i = {}, l = {276}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class SquareAvatarScene$NormalState$handleOnLoadEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SquareAvatarData $data;
    final /* synthetic */ com.tencent.zplan.zplantracing.c $spanContext;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SquareAvatarScene.NormalState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareAvatarScene$NormalState$handleOnLoadEvent$1(SquareAvatarScene.NormalState normalState, SquareAvatarData squareAvatarData, com.tencent.zplan.zplantracing.c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = normalState;
        this.$data = squareAvatarData;
        this.$spanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        SquareAvatarScene$NormalState$handleOnLoadEvent$1 squareAvatarScene$NormalState$handleOnLoadEvent$1 = new SquareAvatarScene$NormalState$handleOnLoadEvent$1(this.this$0, this.$data, this.$spanContext, completion);
        squareAvatarScene$NormalState$handleOnLoadEvent$1.L$0 = obj;
        return squareAvatarScene$NormalState$handleOnLoadEvent$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SquareAvatarScene$NormalState$handleOnLoadEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AtomicBoolean atomicBoolean;
        Deferred deferred;
        Deferred deferred2;
        Deferred r16;
        List mutableListOf;
        JSONObject jSONObject;
        String str;
        Deferred r17;
        String avatarInfoStr;
        Deferred n3;
        Object orNull;
        Object orNull2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        Object obj2 = null;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            atomicBoolean = this.this$0.loaded;
            atomicBoolean.set(true);
            this.this$0.rotateCount = 0.0f;
            com.tencent.zplan.common.utils.h hVar = com.tencent.zplan.common.utils.h.f385294a;
            JSONObject b16 = hVar.b(this.$data.getHost().getAvatarInfoStr());
            if (b16 == null) {
                FLog.INSTANCE.e("SquareAvatarScene", "avatarInfo is not valid " + this.$data.getHost().getAvatarInfoStr());
                return Unit.INSTANCE;
            }
            synchronized (this.this$0) {
                deferred = this.this$0.bootJob;
                if (deferred == null) {
                    SquareAvatarScene.NormalState normalState = this.this$0;
                    n3 = normalState.n(this.$spanContext);
                    normalState.bootJob = n3;
                }
                Unit unit = Unit.INSTANCE;
            }
            Deferred[] deferredArr = new Deferred[2];
            deferred2 = this.this$0.bootJob;
            if (deferred2 == null) {
                deferred2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new SquareAvatarScene$NormalState$handleOnLoadEvent$1$jobs$1(null), 3, null);
            }
            deferredArr[0] = deferred2;
            r16 = this.this$0.r(this.$spanContext, b16);
            deferredArr[1] = r16;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(deferredArr);
            if (this.$data.hasGuest()) {
                SquareAvatarData.AvatarData guest = this.$data.getGuest();
                if (guest != null && (avatarInfoStr = guest.getAvatarInfoStr()) != null) {
                    jSONObject = hVar.b(avatarInfoStr);
                } else {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    r17 = this.this$0.r(this.$spanContext, jSONObject);
                    mutableListOf.add(r17);
                } else {
                    FLog fLog = FLog.INSTANCE;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("guest avatarInfo is not valid ");
                    SquareAvatarData.AvatarData guest2 = this.$data.getGuest();
                    if (guest2 != null) {
                        str = guest2.getAvatarInfoStr();
                    } else {
                        str = null;
                    }
                    sb5.append(str);
                    fLog.e("SquareAvatarScene", sb5.toString());
                }
            }
            this.label = 1;
            obj = AwaitKt.awaitAll(mutableListOf, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        List list = (List) obj;
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, 1);
        if (!(orNull instanceof ReloadAvatarResourceModel)) {
            orNull = null;
        }
        final ReloadAvatarResourceModel reloadAvatarResourceModel = (ReloadAvatarResourceModel) orNull;
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(list, 2);
        if (orNull2 instanceof ReloadAvatarResourceModel) {
            obj2 = orNull2;
        }
        final ReloadAvatarResourceModel reloadAvatarResourceModel2 = (ReloadAvatarResourceModel) obj2;
        if (reloadAvatarResourceModel == null) {
            FLog.INSTANCE.e("SquareAvatarScene", "avatarRes is null");
            return Unit.INSTANCE;
        }
        SquareAvatarScene.this.k().d("configRenderObjects", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.square.SquareAvatarScene$NormalState$handleOnLoadEvent$1.2
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
                SquareAvatarScene$NormalState$handleOnLoadEvent$1 squareAvatarScene$NormalState$handleOnLoadEvent$1 = SquareAvatarScene$NormalState$handleOnLoadEvent$1.this;
                squareAvatarScene$NormalState$handleOnLoadEvent$1.this$0.q(squareAvatarScene$NormalState$handleOnLoadEvent$1.$spanContext, squareAvatarScene$NormalState$handleOnLoadEvent$1.$data, reloadAvatarResourceModel, reloadAvatarResourceModel2);
            }
        });
        return Unit.INSTANCE;
    }
}
