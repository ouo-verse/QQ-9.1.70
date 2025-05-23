package com.tencent.state.map.v2.filament;

import com.tencent.filament.zplan.scene.square.AddObjectEvent;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplan.scene.square.SquareImageData;
import com.tencent.filament.zplan.scene.square.SquareInteractionEventData;
import com.tencent.state.map.v2.ObjectParams;
import com.tencent.state.map.v2.Size;
import com.tencent.state.map.v2.filament.FilamentMap;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.avatar.filament.LoadFilamentAssetsStatistics;
import com.tencent.state.square.avatar.filament.MoodConfig;
import com.tencent.state.square.avatar.filament.SquareActionHelper;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.apache.httpcore.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/state/map/v2/filament/FilamentMap$addObject$1$2"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.state.map.v2.filament.FilamentMap$addObject$1$2", f = "FilamentMap.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {252, 275}, m = "invokeSuspend", n = {"avatarResource", "imageResource", "size", "interactionParams", "loadStatistics", "it", "avatarResource", "imageResource", "size", "interactionParams", "loadStatistics", "it"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes34.dex */
public final class FilamentMap$addObject$$inlined$synchronized$lambda$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $callback$inlined;
    final /* synthetic */ FilamentMapObjectParams $filamentParams;
    final /* synthetic */ WeakReference $mapRef;
    final /* synthetic */ ObjectParams $params$inlined;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ FilamentMap this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentMap$addObject$$inlined$synchronized$lambda$2(FilamentMapObjectParams filamentMapObjectParams, WeakReference weakReference, Continuation continuation, FilamentMap filamentMap, ObjectParams objectParams, Function2 function2) {
        super(2, continuation);
        this.$filamentParams = filamentMapObjectParams;
        this.$mapRef = weakReference;
        this.this$0 = filamentMap;
        this.$params$inlined = objectParams;
        this.$callback$inlined = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentMap$addObject$$inlined$synchronized$lambda$2(this.$filamentParams, this.$mapRef, completion, this.this$0, this.$params$inlined, this.$callback$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentMap$addObject$$inlined$synchronized$lambda$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x023a, code lost:
    
        r1 = r1.mapObjects;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [T, com.tencent.state.map.v2.Size] */
    /* JADX WARN: Type inference failed for: r0v17, types: [T, com.tencent.filament.zplan.scene.square.SquareInteractionEventData] */
    /* JADX WARN: Type inference failed for: r0v24, types: [T, com.tencent.state.map.v2.Size] */
    /* JADX WARN: Type inference failed for: r1v20, types: [T, com.tencent.state.square.avatar.filament.LoadFilamentAssetsStatistics] */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, com.tencent.state.map.v2.Size] */
    /* JADX WARN: Type inference failed for: r2v16, types: [T, com.tencent.filament.zplan.scene.square.SquareImageData] */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, com.tencent.filament.zplan.scene.square.SquareAvatarData] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        Object loadPlayParams;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        AvatarResource avatarResource;
        Ref.ObjectRef objectRef8;
        Ref.ObjectRef objectRef9;
        ImageResource imageResource;
        Object loadImageParams;
        ImageResource imageResource2;
        Ref.ObjectRef objectRef10;
        ConcurrentHashMap concurrentHashMap;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    SquareBaseKt.getSquareLog().d("FilamentMap", "addObject " + this.$params$inlined.getId() + TokenParser.SP + this.$filamentParams.getType() + " load start");
                    objectRef = new Ref.ObjectRef();
                    objectRef.element = null;
                    objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = null;
                    objectRef3 = new Ref.ObjectRef();
                    objectRef3.element = new Size(0.0f, 0.0f, 3, null);
                    objectRef4 = new Ref.ObjectRef();
                    objectRef4.element = null;
                    Ref.ObjectRef objectRef11 = new Ref.ObjectRef();
                    objectRef11.element = null;
                    int i16 = FilamentMap.WhenMappings.$EnumSwitchMapping$0[this.$filamentParams.getType().ordinal()];
                    if (i16 == 1) {
                        AvatarResource avatarResource2 = this.$filamentParams.getAvatarResource();
                        if (avatarResource2 != null) {
                            SquareActionHelper squareActionHelper = SquareActionHelper.INSTANCE;
                            long hostUin = avatarResource2.getHostUin();
                            Long guestUin = avatarResource2.getGuestUin();
                            String url = avatarResource2.getUrl();
                            this.L$0 = objectRef;
                            this.L$1 = objectRef2;
                            this.L$2 = objectRef3;
                            this.L$3 = objectRef4;
                            this.L$4 = objectRef11;
                            this.L$5 = avatarResource2;
                            this.label = 1;
                            loadPlayParams = squareActionHelper.loadPlayParams(hostUin, guestUin, url, this);
                            if (loadPlayParams == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objectRef5 = objectRef;
                            objectRef6 = objectRef2;
                            objectRef7 = objectRef3;
                            avatarResource = avatarResource2;
                            objectRef8 = objectRef11;
                            Triple triple = (Triple) loadPlayParams;
                            MoodConfig moodConfig = (MoodConfig) triple.component1();
                            ?? r85 = (SquareAvatarData) triple.component2();
                            objectRef8.element = (LoadFilamentAssetsStatistics) triple.component3();
                            objectRef5.element = r85;
                            objectRef7.element = avatarResource.getSize();
                            objectRef4.element = FilamentMapObjectKt.getInteractionEventData(moodConfig, r85);
                            objectRef9 = objectRef8;
                            objectRef3 = objectRef7;
                            objectRef2 = objectRef6;
                            objectRef = objectRef5;
                        }
                    } else if (i16 == 2 && (imageResource = this.$filamentParams.getImageResource()) != null) {
                        FilamentResourceHelper filamentResourceHelper = FilamentResourceHelper.INSTANCE;
                        this.L$0 = objectRef;
                        this.L$1 = objectRef2;
                        this.L$2 = objectRef3;
                        this.L$3 = objectRef4;
                        this.L$4 = objectRef11;
                        this.L$5 = imageResource;
                        this.label = 2;
                        loadImageParams = filamentResourceHelper.loadImageParams(imageResource, this);
                        if (loadImageParams == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        imageResource2 = imageResource;
                        objectRef10 = objectRef11;
                        objectRef5 = objectRef;
                        objectRef6 = objectRef2;
                        objectRef7 = objectRef3;
                        objectRef6.element = (SquareImageData) loadImageParams;
                        objectRef7.element = imageResource2.getSize();
                        objectRef9 = objectRef10;
                        objectRef3 = objectRef7;
                        objectRef2 = objectRef6;
                        objectRef = objectRef5;
                    }
                    objectRef9 = objectRef11;
                } else if (i3 == 1) {
                    avatarResource = (AvatarResource) this.L$5;
                    Ref.ObjectRef objectRef12 = (Ref.ObjectRef) this.L$4;
                    Ref.ObjectRef objectRef13 = (Ref.ObjectRef) this.L$3;
                    objectRef7 = (Ref.ObjectRef) this.L$2;
                    objectRef6 = (Ref.ObjectRef) this.L$1;
                    objectRef5 = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectRef4 = objectRef13;
                    objectRef8 = objectRef12;
                    loadPlayParams = obj;
                    Triple triple2 = (Triple) loadPlayParams;
                    MoodConfig moodConfig2 = (MoodConfig) triple2.component1();
                    ?? r852 = (SquareAvatarData) triple2.component2();
                    objectRef8.element = (LoadFilamentAssetsStatistics) triple2.component3();
                    objectRef5.element = r852;
                    objectRef7.element = avatarResource.getSize();
                    objectRef4.element = FilamentMapObjectKt.getInteractionEventData(moodConfig2, r852);
                    objectRef9 = objectRef8;
                    objectRef3 = objectRef7;
                    objectRef2 = objectRef6;
                    objectRef = objectRef5;
                } else if (i3 == 2) {
                    imageResource2 = (ImageResource) this.L$5;
                    objectRef10 = (Ref.ObjectRef) this.L$4;
                    Ref.ObjectRef objectRef14 = (Ref.ObjectRef) this.L$3;
                    objectRef7 = (Ref.ObjectRef) this.L$2;
                    objectRef6 = (Ref.ObjectRef) this.L$1;
                    objectRef5 = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectRef4 = objectRef14;
                    loadImageParams = obj;
                    objectRef6.element = (SquareImageData) loadImageParams;
                    objectRef7.element = imageResource2.getSize();
                    objectRef9 = objectRef10;
                    objectRef3 = objectRef7;
                    objectRef2 = objectRef6;
                    objectRef = objectRef5;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AddObjectEvent addObjectEvent = new AddObjectEvent(this.$params$inlined.getId(), ModelsKt.toFilament(this.$filamentParams.getType()), ModelsKt.toFilament(this.$filamentParams.getLocation()), ModelsKt.toFilament((Size) objectRef3.element), this.$filamentParams.getDepth(), (SquareAvatarData) objectRef.element, (SquareImageData) objectRef2.element);
                SquareBaseKt.getSquareLog().d("FilamentMap", "addObject " + this.$params$inlined.getId() + " dispatchToScene");
                FilamentMap filamentMap = (FilamentMap) this.$mapRef.get();
                if (filamentMap != null && concurrentHashMap != null) {
                    String id5 = this.$params$inlined.getId();
                    FilamentMapObject filamentMapObject = new FilamentMapObject(this.$mapRef, this.$filamentParams, (SquareInteractionEventData) objectRef4.element);
                    filamentMapObject.getStatistics().setAssetsLoadStatistics((LoadFilamentAssetsStatistics) objectRef9.element);
                    Unit unit = Unit.INSTANCE;
                    concurrentHashMap.put(id5, filamentMapObject);
                }
                FilamentMap filamentMap2 = (FilamentMap) this.$mapRef.get();
                if (filamentMap2 != null) {
                    filamentMap2.dispatchToScene(addObjectEvent);
                }
                Function2 function2 = this.$callback$inlined;
                if (function2 != null) {
                }
                return Unit.INSTANCE;
            } catch (Exception e16) {
                SquareBaseKt.getSquareLog().d("FilamentMap", "load action data failed " + e16);
                Function2 function22 = this.$callback$inlined;
                if (function22 != null) {
                }
                return Unit.INSTANCE;
            }
        } catch (Exception e17) {
            SquareBaseKt.getSquareLog().d("FilamentMap", "load image data failed " + e17);
            Function2 function23 = this.$callback$inlined;
            if (function23 != null) {
            }
            return Unit.INSTANCE;
        }
    }
}
