package fx4;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import gx4.c;
import gx4.d;
import gx4.e;
import gx4.f;
import gx4.g;
import gx4.i;
import gx4.j;
import gx4.k;
import gx4.l;
import gx4.m;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\n\u0010\b\u001a\u00020\u0005*\u00020\u0000\u001a\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004*\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\r*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\u0000*\u00020\r\u001a\n\u0010\u0011\u001a\u00020\u0010*\u00020\u0000\u001a\n\u0010\u0012\u001a\u00020\u0000*\u00020\u0010\u001a\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004*\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a\n\u0010\u0016\u001a\u00020\u0013*\u00020\u0000\u001a\n\u0010\u0017\u001a\u00020\u0000*\u00020\u0013\u001a\n\u0010\u0019\u001a\u00020\u0018*\u00020\u0000\u001a\n\u0010\u001a\u001a\u00020\u0000*\u00020\u0018\u001a\n\u0010\u001c\u001a\u00020\u001b*\u00020\u0000\u001a\n\u0010\u001d\u001a\u00020\u0000*\u00020\u001b\u001a\n\u0010\u001f\u001a\u00020\u001e*\u00020\u0000\u001a\n\u0010 \u001a\u00020\u0000*\u00020\u001e\u001a\n\u0010!\u001a\u00020\u0000*\u00020\u0001\u001a\n\u0010\"\u001a\u00020\u0000*\u00020\u0005\u001a\n\u0010$\u001a\u00020#*\u00020\u0000\u001a\n\u0010%\u001a\u00020\u0000*\u00020#\u001a\u0019\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0004*\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b'\u0010(\u001a\n\u0010)\u001a\u00020&*\u00020\u0000\u001a\n\u0010*\u001a\u00020\u0000*\u00020&\u001a\n\u0010,\u001a\u00020+*\u00020\u0000\u001a\n\u0010-\u001a\u00020\u0000*\u00020+\u001a\n\u0010.\u001a\u00020\u0000*\u00020\t\u001a\n\u00100\u001a\u00020/*\u00020\u0000\u001a\n\u00101\u001a\u00020\u0000*\u00020/\u001a/\u00107\u001a\u000206\"\u0004\b\u0000\u00102*\u00020\u00002\u0006\u00104\u001a\u0002032\u000e\u00105\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u00a2\u0006\u0004\b7\u00108\u001a\u001c\u0010:\u001a\u000206*\u00020\u00002\u0006\u00104\u001a\u0002032\b\u00105\u001a\u0004\u0018\u000109\u00a8\u0006;"}, d2 = {"Lorg/json/JSONObject;", "Lgx4/g;", "i", "Lorg/json/JSONArray;", "", "Lgx4/h;", "k", "(Lorg/json/JSONArray;)[Lgx4/h;", "j", "Lgx4/f;", h.F, "(Lorg/json/JSONArray;)[Lgx4/f;", "g", "Lgx4/a;", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lgx4/c;", "c", "o", "Lgx4/d;", "e", "(Lorg/json/JSONArray;)[Lgx4/d;", "d", "p", "Lgx4/i;", "l", "u", "Lgx4/k;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", "Lgx4/j;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", ReportConstant.COSTREPORT_PREFIX, "t", "Lgx4/b;", "b", DomainData.DOMAIN_NAME, "Lgx4/l;", BdhLogUtil.LogTag.Tag_Conn, "(Lorg/json/JSONArray;)[Lgx4/l;", "B", HippyTKDListViewAdapter.X, "Lgx4/e;", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Lgx4/m;", "D", "y", "T", "", "key", HippyControllerProps.ARRAY, "", UserInfo.SEX_FEMALE, "(Lorg/json/JSONObject;Ljava/lang/String;[Ljava/lang/Object;)V", "", "E", "record_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a {
    @NotNull
    public static final k A(@NotNull JSONObject convertToSingleColor) {
        Intrinsics.checkNotNullParameter(convertToSingleColor, "$this$convertToSingleColor");
        k kVar = new k();
        kVar.f403786a = convertToSingleColor.optInt("color_config_id");
        kVar.f403787b = convertToSingleColor.optInt("custom_color");
        return kVar;
    }

    @NotNull
    public static final l B(@NotNull JSONObject convertToSlotInfo) {
        e eVar;
        Intrinsics.checkNotNullParameter(convertToSlotInfo, "$this$convertToSlotInfo");
        l lVar = new l();
        lVar.f403789a = convertToSlotInfo.optInt(MiniAppReportManager2.KEY_SLOT_ID);
        lVar.f403790b = convertToSlotInfo.optInt("item_id");
        lVar.f403791c = convertToSlotInfo.optLong("inst_id");
        JSONObject optJSONObject = convertToSlotInfo.optJSONObject("custom_data");
        m mVar = null;
        if (optJSONObject != null) {
            eVar = f(optJSONObject);
        } else {
            eVar = null;
        }
        lVar.f403792d = eVar;
        JSONObject optJSONObject2 = convertToSlotInfo.optJSONObject("item_data");
        if (optJSONObject2 != null) {
            mVar = D(optJSONObject2);
        }
        lVar.f403793e = mVar;
        return lVar;
    }

    @NotNull
    public static final l[] C(@Nullable JSONArray jSONArray) {
        if (jSONArray == null) {
            return new l[0];
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length <= 0) {
            Object[] array = arrayList.toArray(new l[0]);
            if (array != null) {
                return (l[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            if (jSONObject != null) {
                arrayList.add(B(jSONObject));
            }
        }
        Object[] array2 = arrayList.toArray(new l[0]);
        if (array2 != null) {
            return (l[]) array2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public static final m D(@NotNull JSONObject convertToSlotItemData) {
        String[] strArr;
        String[] strArr2;
        int[] iArr;
        int[] iArr2;
        String[] strArr3;
        String[] strArr4;
        String[] strArr5;
        Intrinsics.checkNotNullParameter(convertToSlotItemData, "$this$convertToSlotItemData");
        m mVar = new m();
        mVar.f403794a = convertToSlotItemData.optString("model");
        mVar.f403795b = convertToSlotItemData.optString("model_full_dose");
        JSONArray optJSONArray = convertToSlotItemData.optJSONArray("override_material_slots");
        String[] strArr6 = null;
        if (optJSONArray != null) {
            strArr = b.g(optJSONArray);
        } else {
            strArr = null;
        }
        mVar.f403796c = strArr;
        JSONArray optJSONArray2 = convertToSlotItemData.optJSONArray("override_material_assets");
        if (optJSONArray2 != null) {
            strArr2 = b.g(optJSONArray2);
        } else {
            strArr2 = null;
        }
        mVar.f403797d = strArr2;
        mVar.f403798e = convertToSlotItemData.optString("animation_bp");
        mVar.f403799f = convertToSlotItemData.optInt("avatar_type");
        mVar.f403800g = convertToSlotItemData.optString("additional_info");
        mVar.f403801h = (float) convertToSlotItemData.optDouble("shoe_height", 0.0d);
        mVar.f403802i = convertToSlotItemData.optBoolean("is_ugc");
        mVar.f403803j = convertToSlotItemData.optString("color_tex");
        mVar.f403804k = convertToSlotItemData.optString("normal_tex");
        mVar.f403805l = convertToSlotItemData.optString("mask_tex");
        JSONArray optJSONArray3 = convertToSlotItemData.optJSONArray("offset_scale");
        if (optJSONArray3 != null) {
            iArr = b.e(optJSONArray3);
        } else {
            iArr = null;
        }
        mVar.f403806m = iArr;
        mVar.f403807n = convertToSlotItemData.optString("slot_name");
        JSONArray optJSONArray4 = convertToSlotItemData.optJSONArray("contain_avatars");
        if (optJSONArray4 != null) {
            iArr2 = b.e(optJSONArray4);
        } else {
            iArr2 = null;
        }
        mVar.f403808o = iArr2;
        mVar.f403809p = convertToSlotItemData.optInt("anim_group_id");
        JSONArray optJSONArray5 = convertToSlotItemData.optJSONArray("relax_head_nan");
        if (optJSONArray5 != null) {
            strArr3 = b.g(optJSONArray5);
        } else {
            strArr3 = null;
        }
        mVar.f403810q = strArr3;
        JSONArray optJSONArray6 = convertToSlotItemData.optJSONArray("relax_body_nan");
        if (optJSONArray6 != null) {
            strArr4 = b.g(optJSONArray6);
        } else {
            strArr4 = null;
        }
        mVar.f403811r = strArr4;
        JSONArray optJSONArray7 = convertToSlotItemData.optJSONArray("relax_head_nv");
        if (optJSONArray7 != null) {
            strArr5 = b.g(optJSONArray7);
        } else {
            strArr5 = null;
        }
        mVar.f403812s = strArr5;
        JSONArray optJSONArray8 = convertToSlotItemData.optJSONArray("relax_body_nv");
        if (optJSONArray8 != null) {
            strArr6 = b.g(optJSONArray8);
        }
        mVar.f403813t = strArr6;
        mVar.f403814u = convertToSlotItemData.optString("ugc_texture_path");
        mVar.f403815v = convertToSlotItemData.optString("ugc_texture_cfg_path");
        mVar.f403816w = convertToSlotItemData.optString("head_montage_path");
        mVar.f403817z = convertToSlotItemData.optString("body_montage_path");
        mVar.A = convertToSlotItemData.optInt("hide_glove_section");
        mVar.B = convertToSlotItemData.optString("ext_data");
        return mVar;
    }

    public static final void E(@NotNull JSONObject innerAppendArray, @NotNull String key, @Nullable int[] iArr) {
        Intrinsics.checkNotNullParameter(innerAppendArray, "$this$innerAppendArray");
        Intrinsics.checkNotNullParameter(key, "key");
        JSONArray jSONArray = new JSONArray();
        if (iArr != null) {
            for (int i3 : iArr) {
                jSONArray.put(i3);
            }
        }
        innerAppendArray.put(key, jSONArray);
    }

    public static final <T> void F(@NotNull JSONObject innerAppendArray, @NotNull String key, @Nullable T[] tArr) {
        Intrinsics.checkNotNullParameter(innerAppendArray, "$this$innerAppendArray");
        Intrinsics.checkNotNullParameter(key, "key");
        JSONArray jSONArray = new JSONArray();
        if (tArr != null) {
            for (T t16 : tArr) {
                jSONArray.mo162put(t16);
            }
        }
        innerAppendArray.put(key, jSONArray);
    }

    @NotNull
    public static final gx4.a a(@NotNull JSONObject convertToAvatarCharacter) {
        c c16;
        j z16;
        g i3;
        gx4.b b16;
        Intrinsics.checkNotNullParameter(convertToAvatarCharacter, "$this$convertToAvatarCharacter");
        gx4.a aVar = new gx4.a();
        JSONObject optJSONObject = convertToAvatarCharacter.optJSONObject("avatar_info");
        if (optJSONObject != null && (b16 = b(optJSONObject)) != null) {
            aVar.f403746a = b16;
        }
        JSONObject optJSONObject2 = convertToAvatarCharacter.optJSONObject("face_info");
        if (optJSONObject2 != null && (i3 = i(optJSONObject2)) != null) {
            aVar.f403747b = i3;
        }
        JSONObject optJSONObject3 = convertToAvatarCharacter.optJSONObject("makeup_info");
        if (optJSONObject3 != null && (z16 = z(optJSONObject3)) != null) {
            aVar.f403748c = z16;
        }
        JSONObject optJSONObject4 = convertToAvatarCharacter.optJSONObject("color_info");
        if (optJSONObject4 != null && (c16 = c(optJSONObject4)) != null) {
            aVar.f403749d = c16;
        }
        aVar.f403750e = convertToAvatarCharacter.optInt("gender");
        return aVar;
    }

    @NotNull
    public static final gx4.b b(@NotNull JSONObject convertToAvatarInfo) {
        l[] lVarArr;
        Intrinsics.checkNotNullParameter(convertToAvatarInfo, "$this$convertToAvatarInfo");
        gx4.b bVar = new gx4.b();
        bVar.f403751a = convertToAvatarInfo.optInt("version");
        JSONArray optJSONArray = convertToAvatarInfo.optJSONArray("slot_arr");
        if (optJSONArray != null) {
            lVarArr = C(optJSONArray);
        } else {
            lVarArr = null;
        }
        bVar.f403752b = lVarArr;
        bVar.f403753c = convertToAvatarInfo.optBoolean("has_timelimit");
        return bVar;
    }

    @NotNull
    public static final c c(@NotNull JSONObject convertToColorInfo) {
        Intrinsics.checkNotNullParameter(convertToColorInfo, "$this$convertToColorInfo");
        c cVar = new c();
        cVar.f403754a = convertToColorInfo.optInt("version");
        cVar.f403755b = e(convertToColorInfo.optJSONArray("slot_arr"));
        return cVar;
    }

    @NotNull
    public static final d d(@NotNull JSONObject convertToColorSlotInfo) {
        k kVar;
        Intrinsics.checkNotNullParameter(convertToColorSlotInfo, "$this$convertToColorSlotInfo");
        d dVar = new d();
        dVar.f403757a = convertToColorSlotInfo.optInt(MiniAppReportManager2.KEY_SLOT_ID);
        dVar.f403758b = convertToColorSlotInfo.optInt("color_type");
        JSONObject optJSONObject = convertToColorSlotInfo.optJSONObject("single_color");
        i iVar = null;
        if (optJSONObject != null) {
            kVar = A(optJSONObject);
        } else {
            kVar = null;
        }
        dVar.f403759c = kVar;
        JSONObject optJSONObject2 = convertToColorSlotInfo.optJSONObject("gradient_type");
        if (optJSONObject2 != null) {
            iVar = l(optJSONObject2);
        }
        dVar.f403760d = iVar;
        return dVar;
    }

    @NotNull
    public static final d[] e(@Nullable JSONArray jSONArray) {
        if (jSONArray == null) {
            return new d[0];
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length <= 0) {
            Object[] array = arrayList.toArray(new d[0]);
            if (array != null) {
                return (d[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            if (jSONObject != null) {
                arrayList.add(d(jSONObject));
            }
        }
        Object[] array2 = arrayList.toArray(new d[0]);
        if (array2 != null) {
            return (d[]) array2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public static final e f(@NotNull JSONObject convertToCustomSlotData) {
        Intrinsics.checkNotNullParameter(convertToCustomSlotData, "$this$convertToCustomSlotData");
        e eVar = new e();
        eVar.f403761a = convertToCustomSlotData.optInt("color_config_id");
        eVar.f403762b = convertToCustomSlotData.optInt("custom_color");
        eVar.f403763c = h(convertToCustomSlotData.optJSONArray("control_points"));
        eVar.f403764d = convertToCustomSlotData.optLong("ugc_id");
        return eVar;
    }

    @NotNull
    public static final f g(@NotNull JSONObject convertToFaceControlData) {
        Intrinsics.checkNotNullParameter(convertToFaceControlData, "$this$convertToFaceControlData");
        f fVar = new f();
        fVar.f403766a = convertToFaceControlData.optInt("control_index");
        fVar.f403767b = convertToFaceControlData.optInt("x_per");
        fVar.f403768c = convertToFaceControlData.optInt("y_per");
        fVar.f403769d = convertToFaceControlData.optInt("side_x_per");
        fVar.f403770e = convertToFaceControlData.optInt("side_y_per");
        return fVar;
    }

    @NotNull
    public static final f[] h(@Nullable JSONArray jSONArray) {
        if (jSONArray == null) {
            return new f[0];
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length <= 0) {
            Object[] array = arrayList.toArray(new f[0]);
            if (array != null) {
                return (f[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            if (jSONObject != null) {
                arrayList.add(g(jSONObject));
            }
        }
        Object[] array2 = arrayList.toArray(new f[0]);
        if (array2 != null) {
            return (f[]) array2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public static final g i(@Nullable JSONObject jSONObject) {
        g gVar = new g();
        if (jSONObject == null) {
            return gVar;
        }
        gVar.f403771a = jSONObject.optInt("version");
        gVar.f403772b = k(jSONObject.optJSONArray("slot_arr"));
        return gVar;
    }

    @NotNull
    public static final gx4.h j(@NotNull JSONObject convertToFaceSlotInfo) {
        Intrinsics.checkNotNullParameter(convertToFaceSlotInfo, "$this$convertToFaceSlotInfo");
        gx4.h hVar = new gx4.h();
        hVar.f403774a = convertToFaceSlotInfo.optInt(MiniAppReportManager2.KEY_SLOT_ID);
        hVar.f403775b = convertToFaceSlotInfo.optInt("item_id");
        hVar.f403776c = convertToFaceSlotInfo.optLong("inst_id");
        hVar.f403777d = h(convertToFaceSlotInfo.optJSONArray("control_points"));
        return hVar;
    }

    @NotNull
    public static final gx4.h[] k(@Nullable JSONArray jSONArray) {
        if (jSONArray == null) {
            return new gx4.h[0];
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length <= 0) {
            Object[] array = arrayList.toArray(new gx4.h[0]);
            if (array != null) {
                return (gx4.h[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            if (jSONObject != null) {
                arrayList.add(j(jSONObject));
            }
        }
        Object[] array2 = arrayList.toArray(new gx4.h[0]);
        if (array2 != null) {
            return (gx4.h[]) array2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @NotNull
    public static final i l(@NotNull JSONObject convertToGradientColor) {
        k kVar;
        Intrinsics.checkNotNullParameter(convertToGradientColor, "$this$convertToGradientColor");
        i iVar = new i();
        iVar.f403778a = convertToGradientColor.optInt("color_config_id");
        JSONObject optJSONObject = convertToGradientColor.optJSONObject("from_color");
        k kVar2 = null;
        if (optJSONObject != null) {
            kVar = A(optJSONObject);
        } else {
            kVar = null;
        }
        iVar.f403779b = kVar;
        JSONObject optJSONObject2 = convertToGradientColor.optJSONObject("to_color");
        if (optJSONObject2 != null) {
            kVar2 = A(optJSONObject2);
        }
        iVar.f403780c = kVar2;
        iVar.f403781d = (float) convertToGradientColor.optDouble("from_progress", 0.0d);
        iVar.f403782e = (float) convertToGradientColor.optDouble("to_progress", 0.0d);
        iVar.f403783f = (float) convertToGradientColor.optDouble("progress", 0.0d);
        return iVar;
    }

    @NotNull
    public static final JSONObject m(@NotNull gx4.a convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        gx4.b avatarInfo = convertToJson.f403746a;
        if (avatarInfo != null) {
            Intrinsics.checkNotNullExpressionValue(avatarInfo, "avatarInfo");
            jSONObject.put("avatar_info", n(avatarInfo));
        }
        g faceInfo = convertToJson.f403747b;
        if (faceInfo != null) {
            Intrinsics.checkNotNullExpressionValue(faceInfo, "faceInfo");
            jSONObject.put("face_info", s(faceInfo));
        }
        j makeupInfo = convertToJson.f403748c;
        if (makeupInfo != null) {
            Intrinsics.checkNotNullExpressionValue(makeupInfo, "makeupInfo");
            jSONObject.put("makeup_info", v(makeupInfo));
        }
        c colorInfo = convertToJson.f403749d;
        if (colorInfo != null) {
            Intrinsics.checkNotNullExpressionValue(colorInfo, "colorInfo");
            jSONObject.put("color_info", o(colorInfo));
        }
        jSONObject.put("gender", convertToJson.f403750e);
        return jSONObject;
    }

    @NotNull
    public static final JSONObject n(@NotNull gx4.b convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", convertToJson.f403751a);
        JSONArray jSONArray = new JSONArray();
        l[] slotArr = convertToJson.f403752b;
        Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
        for (l it : slotArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(x(it));
        }
        jSONObject.put("slot_arr", jSONArray);
        jSONObject.put("has_timelimit", convertToJson.f403753c);
        return jSONObject;
    }

    @NotNull
    public static final JSONObject o(@NotNull c convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", convertToJson.f403754a);
        JSONArray jSONArray = new JSONArray();
        d[] slotArr = convertToJson.f403755b;
        Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
        for (d it : slotArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(p(it));
        }
        jSONObject.put("slot_arr", jSONArray);
        return jSONObject;
    }

    @NotNull
    public static final JSONObject p(@NotNull d convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MiniAppReportManager2.KEY_SLOT_ID, convertToJson.f403757a);
        jSONObject.put("color_type", convertToJson.f403758b);
        k singleColor = convertToJson.f403759c;
        if (singleColor != null) {
            Intrinsics.checkNotNullExpressionValue(singleColor, "singleColor");
            jSONObject.put("single_color", w(singleColor));
        }
        i gradientType = convertToJson.f403760d;
        if (gradientType != null) {
            Intrinsics.checkNotNullExpressionValue(gradientType, "gradientType");
            jSONObject.put("gradient_type", u(gradientType));
        }
        return jSONObject;
    }

    @NotNull
    public static final JSONObject q(@NotNull e convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("color_config_id", convertToJson.f403761a);
        jSONObject.put("custom_color", convertToJson.f403762b);
        JSONArray jSONArray = new JSONArray();
        f[] controlPoints = convertToJson.f403763c;
        Intrinsics.checkNotNullExpressionValue(controlPoints, "controlPoints");
        for (f it : controlPoints) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(r(it));
        }
        jSONObject.put("control_points", jSONArray);
        jSONObject.put("ugc_id", convertToJson.f403764d);
        return jSONObject;
    }

    @NotNull
    public static final JSONObject r(@NotNull f convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("control_index", convertToJson.f403766a);
        jSONObject.put("x_per", convertToJson.f403767b);
        jSONObject.put("y_per", convertToJson.f403768c);
        jSONObject.put("side_x_per", convertToJson.f403769d);
        jSONObject.put("side_y_per", convertToJson.f403770e);
        return jSONObject;
    }

    @NotNull
    public static final JSONObject s(@NotNull g convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", convertToJson.f403771a);
        JSONArray jSONArray = new JSONArray();
        gx4.h[] slotArr = convertToJson.f403772b;
        Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
        for (gx4.h it : slotArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(t(it));
        }
        jSONObject.put("slot_arr", jSONArray);
        return jSONObject;
    }

    @NotNull
    public static final JSONObject t(@NotNull gx4.h convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MiniAppReportManager2.KEY_SLOT_ID, convertToJson.f403774a);
        jSONObject.put("item_id", convertToJson.f403775b);
        jSONObject.put("inst_id", convertToJson.f403776c);
        JSONArray jSONArray = new JSONArray();
        f[] controlPoints = convertToJson.f403777d;
        Intrinsics.checkNotNullExpressionValue(controlPoints, "controlPoints");
        for (f it : controlPoints) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(r(it));
        }
        jSONObject.put("control_points", jSONArray);
        return jSONObject;
    }

    @NotNull
    public static final JSONObject u(@NotNull i convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("color_config_id", convertToJson.f403778a);
        k fromColor = convertToJson.f403779b;
        if (fromColor != null) {
            Intrinsics.checkNotNullExpressionValue(fromColor, "fromColor");
            jSONObject.put("from_color", w(fromColor));
        }
        k toColor = convertToJson.f403780c;
        if (toColor != null) {
            Intrinsics.checkNotNullExpressionValue(toColor, "toColor");
            jSONObject.put("to_color", w(toColor));
        }
        jSONObject.put("from_progress", Float.valueOf(convertToJson.f403781d));
        jSONObject.put("to_progress", Float.valueOf(convertToJson.f403782e));
        jSONObject.put("progress", Float.valueOf(convertToJson.f403783f));
        return jSONObject;
    }

    @NotNull
    public static final JSONObject v(@NotNull j convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", convertToJson.f403784a);
        JSONArray jSONArray = new JSONArray();
        l[] slotArr = convertToJson.f403785b;
        Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
        for (l it : slotArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            jSONArray.mo162put(x(it));
        }
        jSONObject.put("slot_arr", jSONArray);
        return jSONObject;
    }

    @NotNull
    public static final JSONObject w(@NotNull k convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("color_config_id", convertToJson.f403786a);
        jSONObject.put("custom_color", convertToJson.f403787b);
        return jSONObject;
    }

    @NotNull
    public static final JSONObject x(@NotNull l convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MiniAppReportManager2.KEY_SLOT_ID, convertToJson.f403789a);
        jSONObject.put("item_id", convertToJson.f403790b);
        jSONObject.put("inst_id", convertToJson.f403791c);
        e customData = convertToJson.f403792d;
        if (customData != null) {
            Intrinsics.checkNotNullExpressionValue(customData, "customData");
            jSONObject.put("custom_data", q(customData));
        }
        m itemData = convertToJson.f403793e;
        if (itemData != null) {
            Intrinsics.checkNotNullExpressionValue(itemData, "itemData");
            jSONObject.put("item_data", y(itemData));
        }
        return jSONObject;
    }

    @NotNull
    public static final JSONObject y(@NotNull m convertToJson) {
        Intrinsics.checkNotNullParameter(convertToJson, "$this$convertToJson");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("model", convertToJson.f403794a);
        jSONObject.put("model_full_dose", convertToJson.f403795b);
        F(jSONObject, "override_material_slots", convertToJson.f403796c);
        F(jSONObject, "override_material_assets", convertToJson.f403797d);
        jSONObject.put("animation_bp", convertToJson.f403798e);
        jSONObject.put("avatar_type", convertToJson.f403799f);
        jSONObject.put("additional_info", convertToJson.f403800g);
        jSONObject.put("shoe_height", Float.valueOf(convertToJson.f403801h));
        jSONObject.put("is_ugc", convertToJson.f403802i);
        jSONObject.put("color_tex", convertToJson.f403803j);
        jSONObject.put("normal_tex", convertToJson.f403804k);
        jSONObject.put("mask_tex", convertToJson.f403805l);
        E(jSONObject, "offset_scale", convertToJson.f403806m);
        jSONObject.put("slot_name", convertToJson.f403807n);
        E(jSONObject, "contain_avatars", convertToJson.f403808o);
        jSONObject.put("anim_group_id", convertToJson.f403809p);
        F(jSONObject, "relax_head_nan", convertToJson.f403810q);
        F(jSONObject, "relax_body_nan", convertToJson.f403811r);
        F(jSONObject, "relax_head_nv", convertToJson.f403812s);
        F(jSONObject, "relax_body_nv", convertToJson.f403813t);
        jSONObject.put("ugc_texture_path", convertToJson.f403814u);
        jSONObject.put("ugc_texture_cfg_path", convertToJson.f403815v);
        jSONObject.put("head_montage_path", convertToJson.f403816w);
        jSONObject.put("body_montage_path", convertToJson.f403817z);
        jSONObject.put("hide_glove_section", convertToJson.A);
        jSONObject.put("ext_data", convertToJson.B);
        return jSONObject;
    }

    @NotNull
    public static final j z(@NotNull JSONObject convertToMakeupInfo) {
        l[] lVarArr;
        Intrinsics.checkNotNullParameter(convertToMakeupInfo, "$this$convertToMakeupInfo");
        j jVar = new j();
        jVar.f403784a = convertToMakeupInfo.optInt("version");
        JSONArray optJSONArray = convertToMakeupInfo.optJSONArray("slot_arr");
        if (optJSONArray != null) {
            lVarArr = C(optJSONArray);
        } else {
            lVarArr = null;
        }
        jVar.f403785b = lVarArr;
        return jVar;
    }
}
