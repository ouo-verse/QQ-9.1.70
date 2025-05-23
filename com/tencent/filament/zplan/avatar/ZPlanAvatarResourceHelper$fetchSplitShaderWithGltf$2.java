package com.tencent.filament.zplan.avatar;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2", f = "ZPlanAvatarResourceHelper.kt", i = {0, 0, 1}, l = {836, 882}, m = "invokeSuspend", n = {"$this$coroutineScope", "fetchSplitShaderWithSpan", "fetchSplitShaderWithSpan"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes6.dex */
public final class ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $gltfPath;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    final /* synthetic */ com.tencent.zplan.zplantracing.c $zplanSpanContext;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2(com.tencent.zplan.zplantracing.c cVar, String str, FilamentUrlTemplate filamentUrlTemplate, Continuation continuation) {
        super(2, continuation);
        this.$zplanSpanContext = cVar;
        this.$gltfPath = str;
        this.$urlTemplate = filamentUrlTemplate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2 zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2 = new ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2(this.$zplanSpanContext, this.$gltfPath, this.$urlTemplate, completion);
        zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2.L$0 = obj;
        return zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0115  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        com.tencent.zplan.zplantracing.b startSpan;
        Object readJsonFile;
        com.tencent.zplan.zplantracing.b bVar;
        String str;
        int i3;
        boolean z16;
        int i16;
        ArrayList arrayList;
        JSONArray jSONArray;
        boolean z17;
        boolean startsWith$default;
        String substringAfter$default;
        String replace$default;
        Deferred async$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 == 2) {
                    bVar = (com.tencent.zplan.zplantracing.b) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (bVar != null) {
                        bVar.b();
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            startSpan = (com.tencent.zplan.zplantracing.b) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            readJsonFile = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            startSpan = ZPlanSpanFactory.INSTANCE.startSpan("fetchSplitShaderWithGltf", this.$zplanSpanContext);
            if (startSpan != null) {
                startSpan.e("gltfPath", this.$gltfPath);
            }
            FilamentFileUtil filamentFileUtil = FilamentFileUtil.INSTANCE;
            String str2 = this.$gltfPath;
            this.L$0 = coroutineScope;
            this.L$1 = startSpan;
            this.label = 1;
            readJsonFile = filamentFileUtil.readJsonFile(str2, this);
            if (readJsonFile == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        com.tencent.zplan.zplantracing.b bVar2 = startSpan;
        CoroutineScope coroutineScope2 = coroutineScope;
        JSONObject jSONObject = (JSONObject) readJsonFile;
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("buffers");
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray == null) {
                return Unit.INSTANCE;
            }
            int length = optJSONArray.length();
            boolean z18 = false;
            int i18 = 0;
            while (i18 < length) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i18);
                if (optJSONObject != null) {
                    str = optJSONObject.optString(LayoutAttrDefine.CLICK_URI);
                } else {
                    str = null;
                }
                if (str != null) {
                    if (str.length() == 0) {
                        z17 = true;
                    } else {
                        z17 = z18;
                    }
                    if (!z17) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "zplanlite-filamat://", z18, 2, null);
                        if (startsWith$default) {
                            substringAfter$default = StringsKt__StringsKt.substringAfter$default(str, "zplanlite-filamat://", (String) null, 2, (Object) null);
                            replace$default = StringsKt__StringsJVMKt.replace$default(this.$urlTemplate.getMaterialSplitUrl(), "{file_name}", com.tencent.filament.zplanservice.util.c.c(substringAfter$default), false, 4, (Object) null);
                            ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2$fetchShaderJob$1 zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2$fetchShaderJob$1 = new ZPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2$fetchShaderJob$1(this, bVar2, replace$default, substringAfter$default, null);
                            i3 = i18;
                            z16 = z18;
                            i16 = length;
                            arrayList = arrayList2;
                            jSONArray = optJSONArray;
                            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, null, zPlanAvatarResourceHelper$fetchSplitShaderWithGltf$2$fetchShaderJob$1, 3, null);
                            arrayList.add(async$default);
                            i18 = i3 + 1;
                            z18 = z16;
                            length = i16;
                            arrayList2 = arrayList;
                            optJSONArray = jSONArray;
                        }
                    }
                }
                i3 = i18;
                z16 = z18;
                i16 = length;
                arrayList = arrayList2;
                jSONArray = optJSONArray;
                FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]V2", "fetchSplitShaderWithGltf fail. uri invalid.");
                i18 = i3 + 1;
                z18 = z16;
                length = i16;
                arrayList2 = arrayList;
                optJSONArray = jSONArray;
            }
            this.L$0 = bVar2;
            this.L$1 = null;
            this.label = 2;
            if (AwaitKt.awaitAll(arrayList2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = bVar2;
            if (bVar != null) {
            }
            return Unit.INSTANCE;
        }
        FLog.INSTANCE.e("FilamentNativeApp[ZPlanAvatarResourceHelper]", "parse gltf fail. gltfPath:" + this.$gltfPath);
        throw new FetchFileException(FetchFileException.Type.FILE_IS_BROKEN, 201023, "parse gltf fail. gltfPath:" + this.$gltfPath, "");
    }
}
