package com.tencent.state.map.v2.filament;

import com.tencent.filament.zplan.scene.square.ObjectUpdateResourceEvent;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplan.scene.square.SquareImageData;
import com.tencent.state.map.v2.ObjectUpdateResourceParams;
import com.tencent.state.map.v2.filament.FilamentMapObject;
import com.tencent.state.square.avatar.filament.MoodConfig;
import com.tencent.state.square.avatar.filament.SquareActionHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.state.map.v2.filament.FilamentMapObject$updateResource$1", f = "FilamentMapObject.kt", i = {0, 1}, l = {104, 117}, m = "invokeSuspend", n = {"event", "event"}, s = {"L$0", "L$0"})
/* loaded from: classes34.dex */
final class FilamentMapObject$updateResource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $callback;
    final /* synthetic */ FilamentMapObjectParams $newParams;
    final /* synthetic */ ObjectUpdateResourceParams $params;
    Object L$0;
    int label;
    final /* synthetic */ FilamentMapObject this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentMapObject$updateResource$1(FilamentMapObject filamentMapObject, ObjectUpdateResourceParams objectUpdateResourceParams, FilamentMapObjectParams filamentMapObjectParams, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filamentMapObject;
        this.$params = objectUpdateResourceParams;
        this.$newParams = filamentMapObjectParams;
        this.$callback = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentMapObject$updateResource$1(this.this$0, this.$params, this.$newParams, this.$callback, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentMapObject$updateResource$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ObjectUpdateResourceEvent objectUpdateResourceEvent;
        ObjectUpdateResourceEvent objectUpdateResourceEvent2;
        ImageResource imageResource;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    objectUpdateResourceEvent = new ObjectUpdateResourceEvent(this.$params.getId(), null, null, 6, null);
                    int i16 = FilamentMapObject.WhenMappings.$EnumSwitchMapping$0[this.$newParams.getType().ordinal()];
                    if (i16 == 1) {
                        AvatarResource avatarResource = this.$newParams.getAvatarResource();
                        if (avatarResource != null) {
                            SquareActionHelper squareActionHelper = SquareActionHelper.INSTANCE;
                            long hostUin = avatarResource.getHostUin();
                            Long guestUin = avatarResource.getGuestUin();
                            String url = avatarResource.getUrl();
                            this.L$0 = objectUpdateResourceEvent;
                            this.label = 1;
                            Object loadPlayParams = squareActionHelper.loadPlayParams(hostUin, guestUin, url, this);
                            if (loadPlayParams == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objectUpdateResourceEvent2 = objectUpdateResourceEvent;
                            obj = loadPlayParams;
                            Triple triple = (Triple) obj;
                            MoodConfig moodConfig = (MoodConfig) triple.component1();
                            SquareAvatarData squareAvatarData = (SquareAvatarData) triple.component2();
                            objectUpdateResourceEvent2.setAvatarResource(squareAvatarData);
                            this.this$0.interactionParams = FilamentMapObjectKt.getInteractionEventData(moodConfig, squareAvatarData);
                            objectUpdateResourceEvent = objectUpdateResourceEvent2;
                        }
                    } else if (i16 == 2 && (imageResource = this.$newParams.getImageResource()) != null) {
                        FilamentResourceHelper filamentResourceHelper = FilamentResourceHelper.INSTANCE;
                        this.L$0 = objectUpdateResourceEvent;
                        this.label = 2;
                        Object loadImageParams = filamentResourceHelper.loadImageParams(imageResource, this);
                        if (loadImageParams == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectUpdateResourceEvent2 = objectUpdateResourceEvent;
                        obj = loadImageParams;
                        objectUpdateResourceEvent2.setImageResource((SquareImageData) obj);
                        objectUpdateResourceEvent = objectUpdateResourceEvent2;
                    }
                } else if (i3 == 1) {
                    objectUpdateResourceEvent2 = (ObjectUpdateResourceEvent) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Triple triple2 = (Triple) obj;
                    MoodConfig moodConfig2 = (MoodConfig) triple2.component1();
                    SquareAvatarData squareAvatarData2 = (SquareAvatarData) triple2.component2();
                    objectUpdateResourceEvent2.setAvatarResource(squareAvatarData2);
                    this.this$0.interactionParams = FilamentMapObjectKt.getInteractionEventData(moodConfig2, squareAvatarData2);
                    objectUpdateResourceEvent = objectUpdateResourceEvent2;
                } else if (i3 == 2) {
                    objectUpdateResourceEvent2 = (ObjectUpdateResourceEvent) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectUpdateResourceEvent2.setImageResource((SquareImageData) obj);
                    objectUpdateResourceEvent = objectUpdateResourceEvent2;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.this$0.setParams(this.$newParams);
                FilamentMap filamentMap = this.this$0.getMap().get();
                if (filamentMap != null) {
                    filamentMap.dispatchToScene(objectUpdateResourceEvent);
                }
                Function2 function2 = this.$callback;
                if (function2 != null) {
                }
                return Unit.INSTANCE;
            } catch (Exception unused) {
                Function2 function22 = this.$callback;
                if (function22 != null) {
                }
                return Unit.INSTANCE;
            }
        } catch (Exception unused2) {
            Function2 function23 = this.$callback;
            if (function23 != null) {
            }
            return Unit.INSTANCE;
        }
    }
}
