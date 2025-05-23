package com.tencent.filament.zplan.record;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import cl0.FilamentRecordSizeConfig;
import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019JE\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ-\u0010\u0012\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/filament/zplan/record/FilamentRecordHelper;", "", "Lorg/json/JSONObject;", "stickerConfig", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "", "recordStickDataBaseUrl", "Lkotlin/Pair;", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "b", "(Lorg/json/JSONObject;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "configJsonPath", "", "a", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/String;Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lcl0/e;", "d", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentRecordHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FilamentRecordHelper f105779a = new FilamentRecordHelper();

    FilamentRecordHelper() {
    }

    public static /* synthetic */ Object c(FilamentRecordHelper filamentRecordHelper, JSONObject jSONObject, EnumUserGender enumUserGender, FilamentUrlTemplate filamentUrlTemplate, String str, Continuation continuation, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str = null;
        }
        return filamentRecordHelper.b(jSONObject, enumUserGender, filamentUrlTemplate, str, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ce, code lost:
    
        if (0 != 0) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00cb -> B:11:0x00ce). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object a(com.tencent.zplan.zplantracing.c cVar, String str, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super Unit> continuation) {
        FilamentRecordHelper$fetchSplitShaderWithConfigJson$1 filamentRecordHelper$fetchSplitShaderWithConfigJson$1;
        Object coroutine_suspended;
        int i3;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        com.tencent.zplan.zplantracing.c cVar2;
        String str2;
        int length;
        int i16;
        FilamentUrlTemplate filamentUrlTemplate2;
        JSONArray jSONArray;
        if (continuation instanceof FilamentRecordHelper$fetchSplitShaderWithConfigJson$1) {
            filamentRecordHelper$fetchSplitShaderWithConfigJson$1 = (FilamentRecordHelper$fetchSplitShaderWithConfigJson$1) continuation;
            int i17 = filamentRecordHelper$fetchSplitShaderWithConfigJson$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                filamentRecordHelper$fetchSplitShaderWithConfigJson$1.label = i17 - Integer.MIN_VALUE;
                Object obj = filamentRecordHelper$fetchSplitShaderWithConfigJson$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = filamentRecordHelper$fetchSplitShaderWithConfigJson$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            length = filamentRecordHelper$fetchSplitShaderWithConfigJson$1.I$1;
                            i16 = filamentRecordHelper$fetchSplitShaderWithConfigJson$1.I$0;
                            jSONArray = (JSONArray) filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$3;
                            filamentUrlTemplate2 = (FilamentUrlTemplate) filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$2;
                            str2 = (String) filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$1;
                            cVar2 = (com.tencent.zplan.zplantracing.c) filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            i16++;
                            if (i16 < length) {
                                String path = jSONArray.optJSONObject(i16).optString("path");
                                Intrinsics.checkNotNullExpressionValue(path, "path");
                                if (path.length() == 0) {
                                    if (1 == 0) {
                                        String pathAppend = FilamentFileUtil.INSTANCE.pathAppend(com.tencent.filament.zplanservice.util.c.b(str2), path);
                                        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
                                        filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$0 = cVar2;
                                        filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$1 = str2;
                                        filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$2 = filamentUrlTemplate2;
                                        filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$3 = jSONArray;
                                        filamentRecordHelper$fetchSplitShaderWithConfigJson$1.I$0 = i16;
                                        filamentRecordHelper$fetchSplitShaderWithConfigJson$1.I$1 = length;
                                        filamentRecordHelper$fetchSplitShaderWithConfigJson$1.label = 2;
                                        if (zPlanAvatarResourceHelper.c0(cVar2, pathAppend, filamentUrlTemplate2, filamentRecordHelper$fetchSplitShaderWithConfigJson$1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                }
                                i16++;
                                if (i16 < length) {
                                    return Unit.INSTANCE;
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        filamentUrlTemplate = (FilamentUrlTemplate) filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$2;
                        str = (String) filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$1;
                        cVar = (com.tencent.zplan.zplantracing.c) filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    FilamentFileUtil filamentFileUtil = FilamentFileUtil.INSTANCE;
                    filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$0 = cVar;
                    filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$1 = str;
                    filamentRecordHelper$fetchSplitShaderWithConfigJson$1.L$2 = filamentUrlTemplate;
                    filamentRecordHelper$fetchSplitShaderWithConfigJson$1.label = 1;
                    obj = filamentFileUtil.readJsonFile(str, filamentRecordHelper$fetchSplitShaderWithConfigJson$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                jSONObject = (JSONObject) obj;
                if (jSONObject == null && (optJSONObject = jSONObject.optJSONObject("attachments")) != null && (optJSONArray = optJSONObject.optJSONArray("meshes")) != null) {
                    cVar2 = cVar;
                    str2 = str;
                    length = optJSONArray.length();
                    i16 = 0;
                    filamentUrlTemplate2 = filamentUrlTemplate;
                    jSONArray = optJSONArray;
                    if (i16 < length) {
                    }
                } else {
                    return Unit.INSTANCE;
                }
            }
        }
        filamentRecordHelper$fetchSplitShaderWithConfigJson$1 = new FilamentRecordHelper$fetchSplitShaderWithConfigJson$1(this, continuation);
        Object obj2 = filamentRecordHelper$fetchSplitShaderWithConfigJson$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = filamentRecordHelper$fetchSplitShaderWithConfigJson$1.label;
        if (i3 == 0) {
        }
        jSONObject = (JSONObject) obj2;
        if (jSONObject == null) {
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object b(@NotNull JSONObject jSONObject, @Nullable EnumUserGender enumUserGender, @NotNull FilamentUrlTemplate filamentUrlTemplate, @Nullable String str, @NotNull Continuation<? super Pair<ZPlanAction, String>> continuation) {
        return CoroutineScopeKt.coroutineScope(new FilamentRecordHelper$fetchStickerAnimation$2(jSONObject, enumUserGender, str, filamentUrlTemplate, null), continuation);
    }

    @NotNull
    public final FilamentRecordSizeConfig d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        FilamentRecordSizeConfig A = FilamentFeatureUtil.f106409g.A();
        FilamentRecordSizeConfig filamentRecordSizeConfig = new FilamentRecordSizeConfig(Math.max(i3, A.getWidth()), Math.max(i16, A.getHeight()));
        FLog.INSTANCE.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", "genSurfaceTextureSizeConfig, screenWidth:" + i3 + ", screenHeight:" + i16 + ", sizeConfigFromQQMC:" + A + ", result:" + filamentRecordSizeConfig);
        return filamentRecordSizeConfig;
    }
}
