package com.tencent.filament.zplan.scene.couple.config;

import com.tencent.ark.ark;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.LightsParams;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.filament.zplan.scene.couple.config.d;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.common.utils.GsonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u0000 42\u00020\u0001:\u00015B\u008f\u0001\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0010\b\u0002\u0010#\u001a\n\u0018\u00010\u001fj\u0004\u0018\u0001` \u0012\u0010\b\u0002\u0010%\u001a\n\u0018\u00010\u001fj\u0004\u0018\u0001` \u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0014\u0010\u001dR\u001f\u0010#\u001a\n\u0018\u00010\u001fj\u0004\u0018\u0001` 8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\u001b\u0010\"R\u001f\u0010%\u001a\n\u0018\u00010\u001fj\u0004\u0018\u0001` 8\u0006\u00a2\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b$\u0010\"R\u0019\u0010)\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010+\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b*\u0010(R\u0019\u0010.\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b,\u0010&\u001a\u0004\b-\u0010(R\u0019\u00101\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b/\u0010&\u001a\u0004\b0\u0010(\u00a8\u00066"}, d2 = {"Lcom/tencent/filament/zplan/scene/couple/config/BpConfig;", "", "Lcom/tencent/filament/zplan/scene/couple/CoupleAvatarScene$AvatarTarget;", "avatarTarget", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "Lcom/tencent/filament/zplan/scene/couple/config/d;", h.F, "Lcom/tencent/filament/zplan/avatar/CameraParams;", "a", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "b", "()Lcom/tencent/filament/zplan/avatar/CameraParams;", "camera", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "e", "()Lcom/tencent/filament/zplan/avatar/LightsParams;", "lights", "Lorg/json/JSONObject;", "c", "Lorg/json/JSONObject;", "g", "()Lorg/json/JSONObject;", "shadow", "", "Lcom/tencent/filament/zplan/scene/couple/config/ItemConfig;", "d", "Ljava/util/List;", "()Ljava/util/List;", "items", "", "Lcom/tencent/filament/zplan/scene/couple/config/Location;", "[D", "()[D", "leftSingleAnimPosition", "f", "rightSingleAnimPosition", "Lcom/tencent/filament/zplan/scene/couple/config/d;", "getTransformLeftMale", "()Lcom/tencent/filament/zplan/scene/couple/config/d;", "transformLeftMale", "getTransformLeftFemale", "transformLeftFemale", "i", "getTransformRightMale", "transformRightMale", "j", "getTransformRightFemale", "transformRightFemale", "<init>", "(Lcom/tencent/filament/zplan/avatar/CameraParams;Lcom/tencent/filament/zplan/avatar/LightsParams;Lorg/json/JSONObject;Ljava/util/List;[D[DLcom/tencent/filament/zplan/scene/couple/config/d;Lcom/tencent/filament/zplan/scene/couple/config/d;Lcom/tencent/filament/zplan/scene/couple/config/d;Lcom/tencent/filament/zplan/scene/couple/config/d;)V", "l", "Companion", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class BpConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final CameraParams camera;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final LightsParams lights;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final JSONObject shadow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ItemConfig> items;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final double[] leftSingleAnimPosition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final double[] rightSingleAnimPosition;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final d transformLeftMale;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final d transformLeftFemale;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final d transformRightMale;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final d transformRightFemale;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    private static final d f105921k = new d(new double[]{0.0d, 0.0d, 0.0d}, null, null, 6, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001d\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/filament/zplan/scene/couple/config/BpConfig$Companion;", "", "Lorg/json/JSONObject;", "", "key", "Lorg/json/JSONArray;", "b", "directory", "Lcom/tencent/filament/zplan/scene/couple/config/BpConfig;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "Lcom/tencent/filament/zplan/scene/couple/config/d;", "defaultTransform", "Lcom/tencent/filament/zplan/scene/couple/config/d;", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        private final JSONArray b(JSONObject jSONObject, String str) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject != null) {
                return optJSONObject.optJSONArray("location");
            }
            return jSONObject.optJSONArray(str);
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x01b8, code lost:
        
            r0 = kotlin.sequences.SequencesKt___SequencesKt.toList(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x00bc, code lost:
        
            r10 = kotlin.sequences.SequencesKt__SequenceBuilderKt.sequence(new com.tencent.filament.zplan.scene.couple.config.BpConfig$Companion$from$$inlined$asSequence$1(r10, null));
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x010f  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0166  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x01ad  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x01d0  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x01f8  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0220  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0234  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x010b  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0066  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0104 -> B:11:0x0107). Please report as a decompilation issue!!! */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object a(@NotNull String str, @NotNull Continuation<? super BpConfig> continuation) {
            BpConfig$Companion$from$1 bpConfig$Companion$from$1;
            Object coroutine_suspended;
            int i3;
            String filePathInDir;
            Companion companion;
            JSONObject jSONObject;
            List arrayList;
            List list;
            Sequence sequence;
            Companion companion2;
            JSONObject jSONObject2;
            String str2;
            Iterator it;
            JSONObject optJSONObject;
            Object obj;
            JSONObject optJSONObject2;
            Object obj2;
            JSONArray b16;
            double[] dArr;
            JSONArray b17;
            d b18;
            d b19;
            d b26;
            d b27;
            Sequence sequence2;
            List list2;
            Sequence sequence3;
            List list3;
            double[] doubleArray;
            boolean z16;
            String str3 = str;
            if (continuation instanceof BpConfig$Companion$from$1) {
                bpConfig$Companion$from$1 = (BpConfig$Companion$from$1) continuation;
                int i16 = bpConfig$Companion$from$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    bpConfig$Companion$from$1.label = i16 - Integer.MIN_VALUE;
                    Object obj3 = bpConfig$Companion$from$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = bpConfig$Companion$from$1.label;
                    boolean z17 = true;
                    double[] dArr2 = null;
                    if (i3 == 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                it = (Iterator) bpConfig$Companion$from$1.L$4;
                                arrayList = (List) bpConfig$Companion$from$1.L$3;
                                jSONObject2 = (JSONObject) bpConfig$Companion$from$1.L$2;
                                str2 = (String) bpConfig$Companion$from$1.L$1;
                                companion2 = (Companion) bpConfig$Companion$from$1.L$0;
                                ResultKt.throwOnFailure(obj3);
                                ItemConfig itemConfig = (ItemConfig) obj3;
                                if (itemConfig != null) {
                                    arrayList.add(itemConfig);
                                }
                                if (it.hasNext()) {
                                    String str4 = (String) it.next();
                                    bpConfig$Companion$from$1.L$0 = companion2;
                                    bpConfig$Companion$from$1.L$1 = str2;
                                    bpConfig$Companion$from$1.L$2 = jSONObject2;
                                    bpConfig$Companion$from$1.L$3 = arrayList;
                                    bpConfig$Companion$from$1.L$4 = it;
                                    bpConfig$Companion$from$1.label = 2;
                                    obj3 = ItemConfig.INSTANCE.a(str2 + '/' + str4, bpConfig$Companion$from$1);
                                    if (obj3 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    ItemConfig itemConfig2 = (ItemConfig) obj3;
                                    if (itemConfig2 != null) {
                                    }
                                    if (it.hasNext()) {
                                        list = arrayList;
                                        jSONObject = jSONObject2;
                                        companion = companion2;
                                        optJSONObject = jSONObject.optJSONObject("camera");
                                        if (optJSONObject != null) {
                                            String jSONObject3 = optJSONObject.toString();
                                            if (jSONObject3 != null && jSONObject3.length() != 0) {
                                                z16 = false;
                                            } else {
                                                z16 = true;
                                            }
                                            if (!z16) {
                                                try {
                                                    obj = GsonUtil.f385283b.a().fromJson(jSONObject3, (Class<Object>) CameraParams.class);
                                                } catch (Throwable th5) {
                                                    FLog.INSTANCE.e("JsonUtil", "json2Object exception for " + jSONObject3, th5);
                                                }
                                                CameraParams cameraParams = (CameraParams) obj;
                                                optJSONObject2 = jSONObject.optJSONObject("lights");
                                                if (optJSONObject2 != null) {
                                                    String jSONObject4 = optJSONObject2.toString();
                                                    if (jSONObject4 != null && jSONObject4.length() != 0) {
                                                        z17 = false;
                                                    }
                                                    if (!z17) {
                                                        try {
                                                            obj2 = GsonUtil.f385283b.a().fromJson(jSONObject4, (Class<Object>) LightsParams.class);
                                                        } catch (Throwable th6) {
                                                            FLog.INSTANCE.e("JsonUtil", "json2Object exception for " + jSONObject4, th6);
                                                        }
                                                        LightsParams lightsParams = (LightsParams) obj2;
                                                        JSONObject optJSONObject3 = jSONObject.optJSONObject("shadow");
                                                        b16 = companion.b(jSONObject, "single_anim_L_pos");
                                                        if (b16 == null && sequence3 != null && list3 != null) {
                                                            doubleArray = CollectionsKt___CollectionsKt.toDoubleArray(list3);
                                                            dArr = doubleArray;
                                                        } else {
                                                            dArr = null;
                                                        }
                                                        b17 = companion.b(jSONObject, "single_anim_R_pos");
                                                        if (b17 != null && sequence2 != null && list2 != null) {
                                                            dArr2 = CollectionsKt___CollectionsKt.toDoubleArray(list2);
                                                        }
                                                        double[] dArr3 = dArr2;
                                                        d.Companion companion3 = d.INSTANCE;
                                                        b18 = companion3.b(jSONObject.optJSONObject("transform_L_M"));
                                                        if (b18 == null) {
                                                            b18 = BpConfig.f105921k;
                                                        }
                                                        d dVar = b18;
                                                        b19 = companion3.b(jSONObject.optJSONObject("transform_L_F"));
                                                        if (b19 == null) {
                                                            b19 = BpConfig.f105921k;
                                                        }
                                                        d dVar2 = b19;
                                                        b26 = companion3.b(jSONObject.optJSONObject("transform_R_M"));
                                                        if (b26 == null) {
                                                            b26 = BpConfig.f105921k;
                                                        }
                                                        d dVar3 = b26;
                                                        b27 = companion3.b(jSONObject.optJSONObject("transform_R_F"));
                                                        if (b27 == null) {
                                                            b27 = BpConfig.f105921k;
                                                        }
                                                        return new BpConfig(cameraParams, lightsParams, optJSONObject3, list, dArr, dArr3, dVar, dVar2, dVar3, b27);
                                                    }
                                                }
                                                obj2 = null;
                                                LightsParams lightsParams2 = (LightsParams) obj2;
                                                JSONObject optJSONObject32 = jSONObject.optJSONObject("shadow");
                                                b16 = companion.b(jSONObject, "single_anim_L_pos");
                                                if (b16 == null) {
                                                    sequence3 = SequencesKt__SequenceBuilderKt.sequence(new BpConfig$Companion$from$$inlined$asSequence$2(b16, null));
                                                }
                                                dArr = null;
                                                b17 = companion.b(jSONObject, "single_anim_R_pos");
                                                if (b17 != null) {
                                                    sequence2 = SequencesKt__SequenceBuilderKt.sequence(new BpConfig$Companion$from$$inlined$asSequence$3(b17, null));
                                                    list2 = SequencesKt___SequencesKt.toList(sequence2);
                                                    dArr2 = CollectionsKt___CollectionsKt.toDoubleArray(list2);
                                                }
                                                double[] dArr32 = dArr2;
                                                d.Companion companion32 = d.INSTANCE;
                                                b18 = companion32.b(jSONObject.optJSONObject("transform_L_M"));
                                                if (b18 == null) {
                                                }
                                                d dVar4 = b18;
                                                b19 = companion32.b(jSONObject.optJSONObject("transform_L_F"));
                                                if (b19 == null) {
                                                }
                                                d dVar22 = b19;
                                                b26 = companion32.b(jSONObject.optJSONObject("transform_R_M"));
                                                if (b26 == null) {
                                                }
                                                d dVar32 = b26;
                                                b27 = companion32.b(jSONObject.optJSONObject("transform_R_F"));
                                                if (b27 == null) {
                                                }
                                                return new BpConfig(cameraParams, lightsParams2, optJSONObject32, list, dArr, dArr32, dVar4, dVar22, dVar32, b27);
                                            }
                                        }
                                        obj = null;
                                        CameraParams cameraParams2 = (CameraParams) obj;
                                        optJSONObject2 = jSONObject.optJSONObject("lights");
                                        if (optJSONObject2 != null) {
                                        }
                                        obj2 = null;
                                        LightsParams lightsParams22 = (LightsParams) obj2;
                                        JSONObject optJSONObject322 = jSONObject.optJSONObject("shadow");
                                        b16 = companion.b(jSONObject, "single_anim_L_pos");
                                        if (b16 == null) {
                                        }
                                        dArr = null;
                                        b17 = companion.b(jSONObject, "single_anim_R_pos");
                                        if (b17 != null) {
                                        }
                                        double[] dArr322 = dArr2;
                                        d.Companion companion322 = d.INSTANCE;
                                        b18 = companion322.b(jSONObject.optJSONObject("transform_L_M"));
                                        if (b18 == null) {
                                        }
                                        d dVar42 = b18;
                                        b19 = companion322.b(jSONObject.optJSONObject("transform_L_F"));
                                        if (b19 == null) {
                                        }
                                        d dVar222 = b19;
                                        b26 = companion322.b(jSONObject.optJSONObject("transform_R_M"));
                                        if (b26 == null) {
                                        }
                                        d dVar322 = b26;
                                        b27 = companion322.b(jSONObject.optJSONObject("transform_R_F"));
                                        if (b27 == null) {
                                        }
                                        return new BpConfig(cameraParams2, lightsParams22, optJSONObject322, list, dArr, dArr322, dVar42, dVar222, dVar322, b27);
                                    }
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            String str5 = (String) bpConfig$Companion$from$1.L$2;
                            String str6 = (String) bpConfig$Companion$from$1.L$1;
                            companion = (Companion) bpConfig$Companion$from$1.L$0;
                            ResultKt.throwOnFailure(obj3);
                            filePathInDir = str5;
                            str3 = str6;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj3);
                        FilamentFileUtil filamentFileUtil = FilamentFileUtil.INSTANCE;
                        filePathInDir = filamentFileUtil.filePathInDir(str3, "bp_config", ark.ARKMETADATA_JSON);
                        if (filePathInDir != null) {
                            bpConfig$Companion$from$1.L$0 = this;
                            bpConfig$Companion$from$1.L$1 = str3;
                            bpConfig$Companion$from$1.L$2 = filePathInDir;
                            bpConfig$Companion$from$1.label = 1;
                            obj3 = filamentFileUtil.readJsonFile(filePathInDir, bpConfig$Companion$from$1);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            companion = this;
                        }
                        return null;
                    }
                    jSONObject = (JSONObject) obj3;
                    if (jSONObject != null) {
                        FLog.INSTANCE.i("BpConfig", "build BpConfig from: " + filePathInDir + ", content: " + jSONObject);
                        arrayList = new ArrayList();
                        JSONArray optJSONArray = jSONObject.optJSONArray("items");
                        if (optJSONArray != null && sequence != null) {
                            Iterator it5 = sequence.iterator();
                            companion2 = companion;
                            jSONObject2 = jSONObject;
                            str2 = str3;
                            it = it5;
                            if (it.hasNext()) {
                            }
                        } else {
                            list = arrayList;
                            optJSONObject = jSONObject.optJSONObject("camera");
                            if (optJSONObject != null) {
                            }
                            obj = null;
                            CameraParams cameraParams22 = (CameraParams) obj;
                            optJSONObject2 = jSONObject.optJSONObject("lights");
                            if (optJSONObject2 != null) {
                            }
                            obj2 = null;
                            LightsParams lightsParams222 = (LightsParams) obj2;
                            JSONObject optJSONObject3222 = jSONObject.optJSONObject("shadow");
                            b16 = companion.b(jSONObject, "single_anim_L_pos");
                            if (b16 == null) {
                            }
                            dArr = null;
                            b17 = companion.b(jSONObject, "single_anim_R_pos");
                            if (b17 != null) {
                            }
                            double[] dArr3222 = dArr2;
                            d.Companion companion3222 = d.INSTANCE;
                            b18 = companion3222.b(jSONObject.optJSONObject("transform_L_M"));
                            if (b18 == null) {
                            }
                            d dVar422 = b18;
                            b19 = companion3222.b(jSONObject.optJSONObject("transform_L_F"));
                            if (b19 == null) {
                            }
                            d dVar2222 = b19;
                            b26 = companion3222.b(jSONObject.optJSONObject("transform_R_M"));
                            if (b26 == null) {
                            }
                            d dVar3222 = b26;
                            b27 = companion3222.b(jSONObject.optJSONObject("transform_R_F"));
                            if (b27 == null) {
                            }
                            return new BpConfig(cameraParams22, lightsParams222, optJSONObject3222, list, dArr, dArr3222, dVar422, dVar2222, dVar3222, b27);
                        }
                    }
                    return null;
                }
            }
            bpConfig$Companion$from$1 = new BpConfig$Companion$from$1(this, continuation);
            Object obj32 = bpConfig$Companion$from$1.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = bpConfig$Companion$from$1.label;
            boolean z172 = true;
            double[] dArr22 = null;
            if (i3 == 0) {
            }
            jSONObject = (JSONObject) obj32;
            if (jSONObject != null) {
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BpConfig() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final CameraParams getCamera() {
        return this.camera;
    }

    @NotNull
    public final List<ItemConfig> c() {
        return this.items;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final double[] getLeftSingleAnimPosition() {
        return this.leftSingleAnimPosition;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final LightsParams getLights() {
        return this.lights;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final double[] getRightSingleAnimPosition() {
        return this.rightSingleAnimPosition;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final JSONObject getShadow() {
        return this.shadow;
    }

    @Nullable
    public final d h(@NotNull CoupleAvatarScene.AvatarTarget avatarTarget, @NotNull EnumUserGender gender) {
        Intrinsics.checkNotNullParameter(avatarTarget, "avatarTarget");
        Intrinsics.checkNotNullParameter(gender, "gender");
        int i3 = b.f105947c[avatarTarget.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return null;
            }
            int i16 = b.f105946b[gender.ordinal()];
            if (i16 != 1) {
                if (i16 != 2) {
                    return null;
                }
                return this.transformRightFemale;
            }
            return this.transformRightMale;
        }
        int i17 = b.f105945a[gender.ordinal()];
        if (i17 != 1) {
            if (i17 != 2) {
                return null;
            }
            return this.transformLeftFemale;
        }
        return this.transformLeftMale;
    }

    public BpConfig(@Nullable CameraParams cameraParams, @Nullable LightsParams lightsParams, @Nullable JSONObject jSONObject, @NotNull List<ItemConfig> items, @Nullable double[] dArr, @Nullable double[] dArr2, @Nullable d dVar, @Nullable d dVar2, @Nullable d dVar3, @Nullable d dVar4) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.camera = cameraParams;
        this.lights = lightsParams;
        this.shadow = jSONObject;
        this.items = items;
        this.leftSingleAnimPosition = dArr;
        this.rightSingleAnimPosition = dArr2;
        this.transformLeftMale = dVar;
        this.transformLeftFemale = dVar2;
        this.transformRightMale = dVar3;
        this.transformRightFemale = dVar4;
    }

    public /* synthetic */ BpConfig(CameraParams cameraParams, LightsParams lightsParams, JSONObject jSONObject, List list, double[] dArr, double[] dArr2, d dVar, d dVar2, d dVar3, d dVar4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : cameraParams, (i3 & 2) != 0 ? null : lightsParams, (i3 & 4) != 0 ? null : jSONObject, (i3 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 16) != 0 ? null : dArr, (i3 & 32) != 0 ? null : dArr2, (i3 & 64) != 0 ? null : dVar, (i3 & 128) != 0 ? null : dVar2, (i3 & 256) != 0 ? null : dVar3, (i3 & 512) == 0 ? dVar4 : null);
    }
}
