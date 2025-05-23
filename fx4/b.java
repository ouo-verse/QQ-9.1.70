package fx4;

import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qqlive.tvkplayer.report.capability.decode.TVKDeviceDecodeCapabilityReportConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0006\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u001f\u0010\t\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\t\u0010\n\u001a\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u000bH\u0002\u001a\f\u0010\r\u001a\u00020\u0003*\u0004\u0018\u00010\u0005\u001a\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\f\u0010\u0010\u001a\u00020\u000b*\u0004\u0018\u00010\u0005\u00a8\u0006\u0011"}, d2 = {"Ljx4/a;", "Lorg/json/JSONObject;", "f", "", "input", "Lorg/json/JSONArray;", "b", "", "", "c", "([Ljava/lang/String;)Lorg/json/JSONArray;", "", "a", "e", "g", "(Lorg/json/JSONArray;)[Ljava/lang/String;", "d", "record_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b {
    private static final JSONArray a(float[] fArr) {
        JSONArray jSONArray = new JSONArray();
        if (fArr != null) {
            for (float f16 : fArr) {
                jSONArray.mo162put(Float.valueOf(f16));
            }
        }
        return jSONArray;
    }

    private static final JSONArray b(int[] iArr) {
        JSONArray jSONArray = new JSONArray();
        if (iArr != null) {
            for (int i3 : iArr) {
                jSONArray.put(i3);
            }
        }
        return jSONArray;
    }

    private static final JSONArray c(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null) {
            for (String str : strArr) {
                jSONArray.mo162put(str);
            }
        }
        return jSONArray;
    }

    @NotNull
    public static final float[] d(@Nullable JSONArray jSONArray) {
        int i3;
        float[] floatArray;
        float[] floatArray2;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            i3 = jSONArray.length();
        } else {
            i3 = 0;
        }
        if (jSONArray == null || i3 <= 0) {
            floatArray = CollectionsKt___CollectionsKt.toFloatArray(arrayList);
            return floatArray;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            arrayList.add(Float.valueOf((float) jSONArray.optDouble(i16, 0.0d)));
        }
        floatArray2 = CollectionsKt___CollectionsKt.toFloatArray(arrayList);
        return floatArray2;
    }

    @NotNull
    public static final int[] e(@Nullable JSONArray jSONArray) {
        int i3;
        int[] intArray;
        int[] intArray2;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            i3 = jSONArray.length();
        } else {
            i3 = 0;
        }
        if (jSONArray == null || i3 <= 0) {
            intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
            return intArray;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            arrayList.add(Integer.valueOf(jSONArray.optInt(i16)));
        }
        intArray2 = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        return intArray2;
    }

    @NotNull
    public static final JSONObject f(@NotNull jx4.a convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, convertToJson.f411115a);
        jSONObject.put("zh_name", convertToJson.f411116b);
        jSONObject.put("type", b(convertToJson.f411117c));
        jSONObject.put("player_number", convertToJson.f411118d);
        jSONObject.put("is_dynamic", convertToJson.f411119e);
        jSONObject.put("icon_url", convertToJson.f411120f);
        jSONObject.put("cover_index", convertToJson.f411121g);
        jSONObject.put("duration", convertToJson.f411122h);
        jSONObject.put("female_duration", convertToJson.f411123i);
        jSONObject.put(TVKDeviceDecodeCapabilityReportConstant.DECODING_CAPABILITY_PARAM_FRAME_RATE, convertToJson.f411124j);
        jSONObject.put("ue4_bp_path", c(convertToJson.f411125k));
        jSONObject.put("ue4_bp_pose_path", c(convertToJson.f411126l));
        jSONObject.put("ue4_bp_female_pose_path", c(convertToJson.f411127m));
        jSONObject.put("ue4_anim_path", c(convertToJson.f411128n));
        jSONObject.put("ue4_pose_anim_path", c(convertToJson.f411129o));
        jSONObject.put("ue4_head_anim_path", c(convertToJson.f411130p));
        jSONObject.put("ue4_head_pose_anim_path", c(convertToJson.f411131q));
        jSONObject.put("ue4_bp_female_path", c(convertToJson.f411132r));
        jSONObject.put("ue4_anim_female_path", c(convertToJson.f411133s));
        jSONObject.put("ue4_pose_anim_female_path", c(convertToJson.f411134t));
        jSONObject.put("ue4_head_anim_female_path", c(convertToJson.f411135u));
        jSONObject.put("ue4_head_pose_anim_female_path", c(convertToJson.f411136v));
        jSONObject.put("version", convertToJson.f411137w);
        jSONObject.put("hide_body_part", c(convertToJson.f411138z));
        jSONObject.put("disable_lights", convertToJson.A);
        jSONObject.put("camera_adjust", convertToJson.B);
        jSONObject.put("show_hand_slot", convertToJson.C);
        jSONObject.put("sequences", c(convertToJson.D));
        jSONObject.put("body_version", convertToJson.E);
        jSONObject.put("dtype_camera_x", a(convertToJson.F));
        jSONObject.put("dtype_camera_y", a(convertToJson.G));
        jSONObject.put("dtype_camera_z", a(convertToJson.H));
        return jSONObject;
    }

    @NotNull
    public static final String[] g(@Nullable JSONArray jSONArray) {
        int i3;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            i3 = jSONArray.length();
        } else {
            i3 = 0;
        }
        if (jSONArray != null && i3 > 0) {
            for (int i16 = 0; i16 < i3; i16++) {
                arrayList.add(jSONArray.optString(i16));
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Object[] array2 = arrayList.toArray(new String[0]);
        if (array2 != null) {
            return (String[]) array2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
