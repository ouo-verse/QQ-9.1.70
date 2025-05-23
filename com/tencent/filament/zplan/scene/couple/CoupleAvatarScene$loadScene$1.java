package com.tencent.filament.zplan.scene.couple;

import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.filament.zplan.scene.couple.config.SceneConfig;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.utils.h;
import com.tencent.zplan.zplantracing.c;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$loadScene$1", f = "CoupleAvatarScene.kt", i = {0, 0, 0}, l = {232}, m = "invokeSuspend", n = {"leftAvatarCharacter", "rightAvatarCharacter", "enableCrossFade"}, s = {"L$0", "L$1", "Z$0"})
/* loaded from: classes6.dex */
public final class CoupleAvatarScene$loadScene$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventData;
    final /* synthetic */ c $spanContext;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ CoupleAvatarScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoupleAvatarScene$loadScene$1(CoupleAvatarScene coupleAvatarScene, String str, c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = coupleAvatarScene;
        this.$eventData = str;
        this.$spanContext = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new CoupleAvatarScene$loadScene$1(this.this$0, this.$eventData, this.$spanContext, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoupleAvatarScene$loadScene$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        AtomicBoolean atomicBoolean;
        Deferred P0;
        Deferred R0;
        Deferred R02;
        Deferred T0;
        List listOf;
        Object awaitAll;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        final boolean z16;
        boolean z17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                boolean z18 = this.Z$0;
                JSONObject jSONObject3 = (JSONObject) this.L$1;
                JSONObject jSONObject4 = (JSONObject) this.L$0;
                ResultKt.throwOnFailure(obj);
                z16 = z18;
                jSONObject2 = jSONObject3;
                jSONObject = jSONObject4;
                awaitAll = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.this$0.hasDownloadFromNet = false;
            this.this$0.hasPaused = false;
            JSONObject b16 = h.f385294a.b(this.$eventData);
            if (b16 != null) {
                JSONObject optJSONObject = b16.optJSONObject(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT.toString());
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = b16.optJSONObject(CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT.toString());
                    if (optJSONObject2 != null) {
                        boolean optBoolean = b16.optBoolean("enableCrossFade", false);
                        int optInt = b16.optInt(WadlProxyConsts.SCENE_ID);
                        AppTheme a16 = AppTheme.INSTANCE.a(b16.optInt("theme"));
                        FLog.INSTANCE.i("CoupleAvatarScene", "loadScene, sceneId:" + optInt);
                        String bodyTypeName = b16.optString("bodyTypeName", "BodyType40");
                        boolean optBoolean2 = b16.optBoolean("needRecordFrame", false);
                        atomicBoolean = this.this$0.needRecordFrame;
                        atomicBoolean.set(optBoolean2);
                        CoupleAvatarScene coupleAvatarScene = this.this$0;
                        c cVar = this.$spanContext;
                        Intrinsics.checkNotNullExpressionValue(bodyTypeName, "bodyTypeName");
                        P0 = coupleAvatarScene.P0(cVar, bodyTypeName);
                        R0 = this.this$0.R0(this.$spanContext, optJSONObject);
                        R02 = this.this$0.R0(this.$spanContext, optJSONObject2);
                        T0 = this.this$0.T0(this.$spanContext, optInt, a16, optJSONObject, optJSONObject2);
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Deferred[]{P0, R0, R02, T0});
                        this.L$0 = optJSONObject;
                        this.L$1 = optJSONObject2;
                        this.Z$0 = optBoolean;
                        this.label = 1;
                        awaitAll = AwaitKt.awaitAll(listOf, this);
                        if (awaitAll == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        jSONObject = optJSONObject;
                        jSONObject2 = optJSONObject2;
                        z16 = optBoolean;
                    } else {
                        throw new IllegalArgumentException("rightAvatarCharacter is null");
                    }
                } else {
                    throw new IllegalArgumentException("leftAvatarCharacter is null");
                }
            } else {
                throw new IllegalArgumentException("eventData parse fail");
            }
        }
        List list = (List) awaitAll;
        if (list.size() == 4) {
            final Object obj2 = list.get(0);
            if (obj2 instanceof BootResourceModel) {
                final Object obj3 = list.get(1);
                if (obj3 instanceof ReloadAvatarResourceModel) {
                    final Object obj4 = list.get(2);
                    if (obj4 instanceof ReloadAvatarResourceModel) {
                        final Object obj5 = list.get(3);
                        if (obj5 instanceof SceneConfig) {
                            if (FilamentFeatureUtil.f106409g.m()) {
                                try {
                                    CoupleAvatarScene coupleAvatarScene2 = this.this$0;
                                    c cVar2 = this.$spanContext;
                                    BootResourceModel bootResourceModel = (BootResourceModel) obj2;
                                    ReloadAvatarResourceModel reloadAvatarResourceModel = (ReloadAvatarResourceModel) obj3;
                                    ReloadAvatarResourceModel reloadAvatarResourceModel2 = (ReloadAvatarResourceModel) obj4;
                                    SceneConfig sceneConfig = (SceneConfig) obj5;
                                    if (z16) {
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    coupleAvatarScene2.G0(cVar2, bootResourceModel, reloadAvatarResourceModel, jSONObject, reloadAvatarResourceModel2, jSONObject2, sceneConfig, z17);
                                } catch (Throwable th5) {
                                    FLog.INSTANCE.e("CoupleAvatarScene", "configRenderObjectsSplitFunction failed, t:" + th5);
                                    this.this$0.b1(th5);
                                }
                            } else {
                                final JSONObject jSONObject5 = jSONObject;
                                final JSONObject jSONObject6 = jSONObject2;
                                this.this$0.k().d("configRenderObjects_CoupleAvatarScene", new Function0<Unit>() { // from class: com.tencent.filament.zplan.scene.couple.CoupleAvatarScene$loadScene$1$invokeSuspend$$inlined$apply$lambda$1
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
                                        try {
                                            CoupleAvatarScene$loadScene$1 coupleAvatarScene$loadScene$1 = this;
                                            coupleAvatarScene$loadScene$1.this$0.F0(coupleAvatarScene$loadScene$1.$spanContext, (BootResourceModel) obj2, (ReloadAvatarResourceModel) obj3, jSONObject5, (ReloadAvatarResourceModel) obj4, jSONObject6, (SceneConfig) obj5, z16);
                                        } catch (Throwable th6) {
                                            FLog.INSTANCE.e("CoupleAvatarScene", "configRenderObjects failed, t:" + th6);
                                            this.this$0.b1(th6);
                                        }
                                    }
                                });
                            }
                            return Unit.INSTANCE;
                        }
                        throw new IllegalArgumentException("fourthParam isn't SceneConfig");
                    }
                    throw new IllegalArgumentException("thirdParam isn't ReloadAvatarResourceModel");
                }
                throw new IllegalArgumentException("secondParam isn't ReloadAvatarResourceModel");
            }
            throw new IllegalArgumentException("firstParam isn't BootResourceModel");
        }
        throw new IllegalArgumentException("defer count is mismatched");
    }
}
