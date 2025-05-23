package com.tencent.filament.zplan.record;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.BootResourceModel;
import com.tencent.filament.zplan.avatar.model.ReloadAvatarResourceModel;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.record.FilamentRecordNativeApp$record$3", f = "FilamentRecordNativeApp.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {243, 259, 275}, m = "invokeSuspend", n = {"bootResourceStep", "avatarResourceStep", "avatarResourceDeferred", "animationResourceStep", "animationResourceDeferred", "bootResourceStep", "avatarResourceStep", "animationResourceStep", "animationResourceDeferred", "bootResource", "bootResourceStep", "avatarResourceStep", "animationResourceStep", "bootResource", "avatarResource"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes6.dex */
public final class FilamentRecordNativeApp$record$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef $anythingDownloadFromNet;
    final /* synthetic */ JSONObject $avatarInfo;
    final /* synthetic */ JSONObject $data;
    final /* synthetic */ int $height;
    final /* synthetic */ JSONObject $statistic;
    final /* synthetic */ JSONObject $stickerConfig;
    final /* synthetic */ int $taskId;
    final /* synthetic */ int $theme;
    final /* synthetic */ int $width;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ FilamentRecordNativeApp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentRecordNativeApp$record$3(FilamentRecordNativeApp filamentRecordNativeApp, int i3, JSONObject jSONObject, JSONObject jSONObject2, Ref.ObjectRef objectRef, JSONObject jSONObject3, JSONObject jSONObject4, int i16, int i17, int i18, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filamentRecordNativeApp;
        this.$taskId = i3;
        this.$avatarInfo = jSONObject;
        this.$data = jSONObject2;
        this.$anythingDownloadFromNet = objectRef;
        this.$statistic = jSONObject3;
        this.$stickerConfig = jSONObject4;
        this.$theme = i16;
        this.$width = i17;
        this.$height = i18;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        FilamentRecordNativeApp$record$3 filamentRecordNativeApp$record$3 = new FilamentRecordNativeApp$record$3(this.this$0, this.$taskId, this.$avatarInfo, this.$data, this.$anythingDownloadFromNet, this.$statistic, this.$stickerConfig, this.$theme, this.$width, this.$height, completion);
        filamentRecordNativeApp$record$3.L$0 = obj;
        return filamentRecordNativeApp$record$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilamentRecordNativeApp$record$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x022e  */
    /* JADX WARN: Type inference failed for: r2v10, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v19, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v26, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v35, types: [T, java.lang.Boolean] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        al0.a aVar;
        Deferred async$default;
        al0.a aVar2;
        Deferred async$default2;
        String str;
        Deferred async$default3;
        Object await;
        Deferred deferred;
        al0.a aVar3;
        Deferred deferred2;
        BootResourceModel bootResourceModel;
        AtomicBoolean atomicBoolean;
        String str2;
        Object await2;
        al0.a aVar4;
        al0.a aVar5;
        al0.a aVar6;
        AtomicBoolean atomicBoolean2;
        Object await3;
        ReloadAvatarResourceModel reloadAvatarResourceModel;
        BootResourceModel bootResourceModel2;
        AtomicBoolean atomicBoolean3;
        boolean z16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ReloadAvatarResourceModel reloadAvatarResourceModel2 = (ReloadAvatarResourceModel) this.L$4;
                        BootResourceModel bootResourceModel3 = (BootResourceModel) this.L$3;
                        aVar6 = (al0.a) this.L$2;
                        al0.a aVar7 = (al0.a) this.L$1;
                        aVar5 = (al0.a) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        reloadAvatarResourceModel = reloadAvatarResourceModel2;
                        bootResourceModel2 = bootResourceModel3;
                        aVar4 = aVar7;
                        str2 = "recordStart";
                        await3 = obj;
                        Pair pair = (Pair) await3;
                        ZPlanAction zPlanAction = (ZPlanAction) pair.component1();
                        String str3 = (String) pair.component2();
                        atomicBoolean3 = this.this$0.hasDestroy;
                        if (!atomicBoolean3.get()) {
                            FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "fetchAnimation finish but nativeApp hasDestroy, return!!");
                            return Unit.INSTANCE;
                        }
                        if (zPlanAction == null) {
                            this.$anythingDownloadFromNet.element = Boxing.boxBoolean(true);
                            this.$statistic.put("downloadResource", FilamentRecordNativeApp.INSTANCE.i((Boolean) this.$anythingDownloadFromNet.element));
                            FilamentEventDispatcher O = this.this$0.O();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, this.$taskId);
                            jSONObject.put("errorCode", 201004);
                            jSONObject.put("statistic", this.$statistic);
                            Unit unit = Unit.INSTANCE;
                            String jSONObject2 = jSONObject.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026             }.toString()");
                            O.onEvent(str2, jSONObject2);
                            return Unit.INSTANCE;
                        }
                        Ref.ObjectRef objectRef = this.$anythingDownloadFromNet;
                        if (!bootResourceModel2.getDownloadFromNet() && !reloadAvatarResourceModel.getDownloadFromNet() && !zPlanAction.getDownloadFromNet()) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        objectRef.element = Boxing.boxBoolean(z16);
                        this.$statistic.put("downloadResource", FilamentRecordNativeApp.INSTANCE.i((Boolean) this.$anythingDownloadFromNet.element));
                        this.$statistic.put("fetchBootResourceTimeCost", String.valueOf(aVar5.f()));
                        this.$statistic.put("fetchAvatarResourceTimeCost", String.valueOf(aVar4.f()));
                        this.$statistic.put("fetchAnimationResourceTimeCost", String.valueOf(aVar6.f()));
                        this.this$0.z(this.$data, this.$taskId, this.$avatarInfo, this.$stickerConfig, str3, this.$theme, this.$width, this.$height, bootResourceModel2, reloadAvatarResourceModel, zPlanAction, this.$statistic);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                BootResourceModel bootResourceModel4 = (BootResourceModel) this.L$4;
                deferred2 = (Deferred) this.L$3;
                al0.a aVar8 = (al0.a) this.L$2;
                aVar4 = (al0.a) this.L$1;
                al0.a aVar9 = (al0.a) this.L$0;
                ResultKt.throwOnFailure(obj);
                str2 = "recordStart";
                aVar6 = aVar8;
                aVar5 = aVar9;
                bootResourceModel = bootResourceModel4;
                await2 = obj;
                ReloadAvatarResourceModel reloadAvatarResourceModel3 = (ReloadAvatarResourceModel) await2;
                atomicBoolean2 = this.this$0.hasDestroy;
                if (!atomicBoolean2.get()) {
                    FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "fetchAvatarResource finish but nativeApp hasDestroy, return!!");
                    return Unit.INSTANCE;
                }
                if (reloadAvatarResourceModel3 == null) {
                    this.$anythingDownloadFromNet.element = Boxing.boxBoolean(true);
                    this.$statistic.put("downloadResource", FilamentRecordNativeApp.INSTANCE.i((Boolean) this.$anythingDownloadFromNet.element));
                    FilamentEventDispatcher O2 = this.this$0.O();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, this.$taskId);
                    jSONObject3.put("errorCode", 201003);
                    jSONObject3.put("statistic", this.$statistic);
                    Unit unit2 = Unit.INSTANCE;
                    String jSONObject4 = jSONObject3.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject4, "JSONObject().apply {\n   \u2026             }.toString()");
                    O2.onEvent(str2, jSONObject4);
                    return Unit.INSTANCE;
                }
                this.L$0 = aVar5;
                this.L$1 = aVar4;
                this.L$2 = aVar6;
                this.L$3 = bootResourceModel;
                this.L$4 = reloadAvatarResourceModel3;
                this.label = 3;
                await3 = deferred2.await(this);
                if (await3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                reloadAvatarResourceModel = reloadAvatarResourceModel3;
                bootResourceModel2 = bootResourceModel;
                Pair pair2 = (Pair) await3;
                ZPlanAction zPlanAction2 = (ZPlanAction) pair2.component1();
                String str32 = (String) pair2.component2();
                atomicBoolean3 = this.this$0.hasDestroy;
                if (!atomicBoolean3.get()) {
                }
            } else {
                Deferred deferred3 = (Deferred) this.L$4;
                aVar3 = (al0.a) this.L$3;
                deferred = (Deferred) this.L$2;
                aVar2 = (al0.a) this.L$1;
                aVar = (al0.a) this.L$0;
                ResultKt.throwOnFailure(obj);
                deferred2 = deferred3;
                str = "recordStart";
                await = obj;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            aVar = new al0.a(0L, 0L, false, 0, null, 31, null);
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FilamentRecordNativeApp$record$3$bootResourceDeferred$1(this, aVar, null), 3, null);
            aVar2 = new al0.a(0L, 0L, false, 0, null, 31, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FilamentRecordNativeApp$record$3$avatarResourceDeferred$1(this, aVar2, null), 3, null);
            al0.a aVar10 = new al0.a(0L, 0L, false, 0, null, 31, null);
            str = "recordStart";
            async$default3 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new FilamentRecordNativeApp$record$3$animationResourceDeferred$1(this, aVar10, null), 3, null);
            this.L$0 = aVar;
            this.L$1 = aVar2;
            this.L$2 = async$default2;
            this.L$3 = aVar10;
            this.L$4 = async$default3;
            this.label = 1;
            await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            deferred = async$default2;
            aVar3 = aVar10;
            deferred2 = async$default3;
        }
        bootResourceModel = (BootResourceModel) await;
        atomicBoolean = this.this$0.hasDestroy;
        if (atomicBoolean.get()) {
            FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "fetchBootResource finish but nativeApp hasDestroy, return!!");
            return Unit.INSTANCE;
        }
        if (bootResourceModel == null) {
            this.$anythingDownloadFromNet.element = Boxing.boxBoolean(true);
            this.$statistic.put("downloadResource", FilamentRecordNativeApp.INSTANCE.i((Boolean) this.$anythingDownloadFromNet.element));
            FilamentEventDispatcher O3 = this.this$0.O();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, this.$taskId);
            jSONObject5.put("errorCode", 201021);
            jSONObject5.put("statistic", this.$statistic);
            Unit unit3 = Unit.INSTANCE;
            String jSONObject6 = jSONObject5.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject6, "JSONObject().apply {\n   \u2026             }.toString()");
            O3.onEvent(str, jSONObject6);
            return Unit.INSTANCE;
        }
        str2 = str;
        this.L$0 = aVar;
        this.L$1 = aVar2;
        this.L$2 = aVar3;
        this.L$3 = deferred2;
        this.L$4 = bootResourceModel;
        this.label = 2;
        await2 = deferred.await(this);
        if (await2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        aVar4 = aVar2;
        al0.a aVar11 = aVar3;
        aVar5 = aVar;
        aVar6 = aVar11;
        ReloadAvatarResourceModel reloadAvatarResourceModel32 = (ReloadAvatarResourceModel) await2;
        atomicBoolean2 = this.this$0.hasDestroy;
        if (!atomicBoolean2.get()) {
        }
    }
}
