package com.tencent.filament.zplan.business.impl;

import al0.a;
import cl0.f;
import com.google.gson.Gson;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.AvatarCheckResult;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import com.tencent.zplan.zplantracing.b;
import com.tencent.zplan.zplantracing.c;
import dl0.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wx4.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.business.impl.AbsBusinessScene$innerLoadAvatarResource$2", f = "AbsBusinessScene.kt", i = {0, 0, 0}, l = {TVKQQLiveAssetPlayerMsg.PLAYER_INFO_UPDATE_ADAPTIVE_DEFINITION_STATE}, m = "invokeSuspend", n = {"loadAvatarResourceSpan", "fetchAllResourceSpan", "fetchAllResourceStatic"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes6.dex */
public final class AbsBusinessScene$innerLoadAvatarResource$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $avatarInfo;
    final /* synthetic */ c $spanContext;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AbsBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBusinessScene$innerLoadAvatarResource$2(AbsBusinessScene absBusinessScene, c cVar, JSONObject jSONObject, Continuation continuation) {
        super(2, continuation);
        this.this$0 = absBusinessScene;
        this.$spanContext = cVar;
        this.$avatarInfo = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        AbsBusinessScene$innerLoadAvatarResource$2 absBusinessScene$innerLoadAvatarResource$2 = new AbsBusinessScene$innerLoadAvatarResource$2(this.this$0, this.$spanContext, this.$avatarInfo, completion);
        absBusinessScene$innerLoadAvatarResource$2.L$0 = obj;
        return absBusinessScene$innerLoadAvatarResource$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AbsBusinessScene$innerLoadAvatarResource$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02ab  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        b bVar;
        b bVar2;
        final b bVar3;
        Deferred async$default;
        Deferred async$default2;
        Deferred async$default3;
        List listOf;
        Object awaitAll;
        al0.a aVar;
        FilamentEventDispatcher dispatcher;
        AvatarCheckResult checkShader;
        f fVar;
        f fVar2;
        Map<String, String> mutableMapOf;
        f fVar3;
        h hVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                aVar = (al0.a) this.L$2;
                bVar2 = (b) this.L$1;
                bVar3 = (b) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    bVar = bVar2;
                    awaitAll = obj;
                } catch (Exception e16) {
                    e = e16;
                    if (bVar2 != null) {
                    }
                    if (bVar3 != null) {
                    }
                    dispatcher = this.this$0.getDispatcher();
                    if (dispatcher != null) {
                    }
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ZPlanSpanFactory zPlanSpanFactory = ZPlanSpanFactory.INSTANCE;
            b startSpan = zPlanSpanFactory.startSpan("loadAvatarResource", this.$spanContext);
            EnumUserGender a16 = EnumUserGender.INSTANCE.a(this.$avatarInfo.optInt("gender", 0));
            b startSpan2 = zPlanSpanFactory.startSpan("fetchAllResource", startSpan);
            al0.a aVar2 = new al0.a(0L, 0L, false, 0, null, 31, null);
            aVar2.l(al0.a.INSTANCE.b());
            try {
                Deferred[] deferredArr = new Deferred[3];
                bVar = startSpan2;
                try {
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null), null, new AbsBusinessScene$innerLoadAvatarResource$2$allResult$1(this, startSpan2, null), 2, null);
                    deferredArr[0] = async$default;
                    async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null), null, new AbsBusinessScene$innerLoadAvatarResource$2$allResult$2(this, bVar, null), 2, null);
                    deferredArr[1] = async$default2;
                    async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null), null, new AbsBusinessScene$innerLoadAvatarResource$2$allResult$3(this, bVar, a16, null), 2, null);
                    deferredArr[2] = async$default3;
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) deferredArr);
                    this.L$0 = startSpan;
                    this.L$1 = bVar;
                    this.L$2 = aVar2;
                    this.label = 1;
                    awaitAll = AwaitKt.awaitAll(listOf, this);
                    if (awaitAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar = aVar2;
                    bVar3 = startSpan;
                } catch (Exception e17) {
                    e = e17;
                    bVar2 = bVar;
                    bVar3 = startSpan;
                    if (bVar2 != null) {
                        bVar2.a(e.getMessage());
                    }
                    if (bVar3 != null) {
                        bVar3.a(e.getMessage());
                    }
                    dispatcher = this.this$0.getDispatcher();
                    if (dispatcher != null) {
                        String message = e.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        dispatcher.onEvent("onFilamentRenderFail", message);
                    }
                    return Unit.INSTANCE;
                }
            } catch (Exception e18) {
                e = e18;
                bVar = startSpan2;
            }
        }
        try {
            List list = (List) awaitAll;
            if (list.size() != 3) {
                FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAllResource fail. allResult.size != 3");
                return Unit.INSTANCE;
            }
            Pair pair = (Pair) list.get(0);
            AvatarCheckResult avatarCheckResult = (AvatarCheckResult) pair.component1();
            Object component2 = pair.component2();
            Pair pair2 = (Pair) list.get(1);
            AvatarCheckResult avatarCheckResult2 = (AvatarCheckResult) pair2.component1();
            final Object component22 = pair2.component2();
            Pair pair3 = (Pair) list.get(2);
            AvatarCheckResult avatarCheckResult3 = (AvatarCheckResult) pair3.component1();
            final Object component23 = pair3.component2();
            if ((component2 instanceof BootResourceModel) && (component22 instanceof ReloadAvatarResourceModel) && (component23 instanceof Object[])) {
                if (bVar != null) {
                    bVar.b();
                }
                a.Companion companion = al0.a.INSTANCE;
                aVar.i(companion.b());
                FilamentEventDispatcher dispatcher2 = this.this$0.getDispatcher();
                if (dispatcher2 != null) {
                    String jSONObject = companion.c(aVar).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "fetchAllResourceStatic.toJSON().toString()");
                    dispatcher2.onEvent("onAllResourceReady", jSONObject);
                }
                checkShader = this.this$0.checkShader(((BootResourceModel) component2).getShaderDir());
                AvatarCheckResult c16 = avatarCheckResult.c(avatarCheckResult2).c(avatarCheckResult3).c(checkShader);
                d.Companion companion2 = d.INSTANCE;
                fVar = this.this$0.checkConfig;
                fVar2 = this.this$0.checkConfig;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("enable_generate", String.valueOf(companion2.b(fVar.getEnableGenerate()))), TuplesKt.to("check_select", String.valueOf(fVar2.getCheckSelect())), TuplesKt.to("scene", String.valueOf(Reflection.getOrCreateKotlinClass(this.this$0.getClass()).getSimpleName())));
                mutableMapOf.putAll(c16.d());
                fVar3 = this.this$0.checkConfig;
                if (fVar3.getEnableCheck() && (hVar = (h) fl0.a.f399763a.a(h.class)) != null) {
                    hVar.a("filament_resource_verify", mutableMapOf);
                }
                if (!c16.getPassVerify()) {
                    FLog.INSTANCE.e(AbsBusinessScene.TAG, "verify resource fail. detail msg:" + mutableMapOf);
                    Iterator<T> it = c16.a().iterator();
                    while (it.hasNext()) {
                        FilamentFileUtil.INSTANCE.deleteDirSafely((String) it.next());
                    }
                    FilamentEventDispatcher dispatcher3 = this.this$0.getDispatcher();
                    if (dispatcher3 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errorCode", 301007);
                        jSONObject2.put("errorMessage", mutableMapOf.toString());
                        Unit unit = Unit.INSTANCE;
                        String jSONObject3 = jSONObject2.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().apply {\n   \u2026\n            }.toString()");
                        dispatcher3.onEvent("onFilamentRenderFail", jSONObject3);
                    }
                    return Unit.INSTANCE;
                }
                this.this$0.doTask("setBodyTypeCamera", new Function0<Unit>() { // from class: com.tencent.filament.zplan.business.impl.AbsBusinessScene$innerLoadAvatarResource$2.3
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
                        AbsBusinessScene absBusinessScene = AbsBusinessScene$innerLoadAvatarResource$2.this.this$0;
                        CameraParams bodyTypeCamera = absBusinessScene.getBodyTypeCamera(absBusinessScene.getBodyTypeName());
                        if (bodyTypeCamera != null) {
                            FilamentViewerV2 viewerV2 = AbsBusinessScene$innerLoadAvatarResource$2.this.this$0.getViewerV2();
                            if (viewerV2 != null) {
                                String json = new Gson().toJson(bodyTypeCamera);
                                Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(camera)");
                                viewerV2.setCamera(json);
                            }
                            FLog.INSTANCE.i(AbsBusinessScene.TAG, "setBodyTypeCamera, camera: " + bodyTypeCamera);
                        }
                    }
                });
                this.this$0.doTask("reloadAvatar", new Function0<Unit>() { // from class: com.tencent.filament.zplan.business.impl.AbsBusinessScene$innerLoadAvatarResource$2.4
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
                        ZPlanSpanFactory zPlanSpanFactory2 = ZPlanSpanFactory.INSTANCE;
                        b startSpan3 = zPlanSpanFactory2.startSpan("reloadAvatar", bVar3);
                        al0.a aVar3 = new al0.a(0L, 0L, false, 0, null, 31, null);
                        a.Companion companion3 = al0.a.INSTANCE;
                        aVar3.l(companion3.b());
                        AbsBusinessScene$innerLoadAvatarResource$2 absBusinessScene$innerLoadAvatarResource$2 = AbsBusinessScene$innerLoadAvatarResource$2.this;
                        absBusinessScene$innerLoadAvatarResource$2.this$0.reloadAvatar((ReloadAvatarResourceModel) component22, absBusinessScene$innerLoadAvatarResource$2.$avatarInfo, startSpan3 != null ? startSpan3.c() : null);
                        if (startSpan3 != null) {
                            startSpan3.b();
                        }
                        b startSpan4 = zPlanSpanFactory2.startSpan("loadAnim", bVar3);
                        AbsBusinessScene absBusinessScene = AbsBusinessScene$innerLoadAvatarResource$2.this.this$0;
                        Object obj2 = component23;
                        if (!(obj2 instanceof ZPlanAction[])) {
                            obj2 = null;
                        }
                        ZPlanAction[] zPlanActionArr = (ZPlanAction[]) obj2;
                        if (zPlanActionArr == null) {
                            zPlanActionArr = new ZPlanAction[0];
                        }
                        absBusinessScene.loadAnimation(zPlanActionArr, startSpan4 != null ? startSpan4.c() : null);
                        if (startSpan4 != null) {
                            startSpan4.b();
                            Unit unit2 = Unit.INSTANCE;
                        }
                        aVar3.i(companion3.b());
                        b bVar4 = bVar3;
                        if (bVar4 != null) {
                            bVar4.b();
                        }
                        com.tencent.filament.zplan.business.api.c reloadAvatarCompleteListener = AbsBusinessScene$innerLoadAvatarResource$2.this.this$0.getReloadAvatarCompleteListener();
                        if (reloadAvatarCompleteListener != null) {
                            reloadAvatarCompleteListener.a(aVar3);
                        }
                    }
                });
                return Unit.INSTANCE;
            }
            FLog.INSTANCE.e(AbsBusinessScene.TAG, "fetchAllResource fail. return value is wrong");
            return Unit.INSTANCE;
        } catch (Exception e19) {
            e = e19;
            bVar2 = bVar;
            if (bVar2 != null) {
            }
            if (bVar3 != null) {
            }
            dispatcher = this.this$0.getDispatcher();
            if (dispatcher != null) {
            }
            return Unit.INSTANCE;
        }
    }
}
