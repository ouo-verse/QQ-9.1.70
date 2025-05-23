package h03;

import android.graphics.Color;
import android.text.TextUtils;
import com.qzone.widget.v;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J6\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\rH\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u001a\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010$\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010%\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010'\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0018R\u0017\u0010+\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b!\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010-\u00a8\u00061"}, d2 = {"Lh03/a;", "", "Lf03/b;", "bubbleConfig", "Lorg/json/JSONObject;", "bubbleConfigJsonObject", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "p", "Lorg/json/JSONArray;", "animationsJsonArray", "Ljava/util/ArrayList;", "Lf03/a;", "animationConfigs", "", "i", "e", "object", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DownloadInfo.spKey_Config, "c", "j", "f", "", "key", "rootJSONObj", "b", "o", "animType", "animation", "animationConfig", "d", "a", h.F, "l", DomainData.DOMAIN_NAME, "g", "jsonString", "r", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Lh03/b;", "Lh03/b;", "diyBubbleConfigParser", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = IBubbleManager.INSTANCE.b() + "BubbleConfigParser";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b diyBubbleConfigParser = new b();

    private final JSONObject a(String key, JSONObject rootJSONObj) throws JSONException {
        if (!rootJSONObj.has("animations")) {
            return null;
        }
        return rootJSONObj.getJSONObject("animations").getJSONObject(key);
    }

    private final JSONObject b(String key, JSONObject rootJSONObj) throws JSONException {
        if (!rootJSONObj.has("animation_sets")) {
            return null;
        }
        return rootJSONObj.getJSONObject("animation_sets").getJSONObject(key);
    }

    private final void c(JSONObject object, f03.a config) throws JSONException {
        if (object.has("cut_array")) {
            JSONArray jSONArray = object.getJSONArray("cut_array");
            if (jSONArray.length() > 0) {
                config.q(new int[jSONArray.length()]);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    int[] cutPoints = config.getCutPoints();
                    Intrinsics.checkNotNull(cutPoints);
                    cutPoints[i3] = jSONArray.getInt(i3);
                }
                int[] cutPoints2 = config.getCutPoints();
                if (cutPoints2 != null) {
                    Arrays.sort(cutPoints2);
                }
            }
        }
    }

    private final void d(JSONObject animation, f03.a animationConfig) throws JSONException {
        if (animation.has(CanvasView.ACTION_RECT)) {
            JSONArray jSONArray = animation.getJSONArray(CanvasView.ACTION_RECT);
            animationConfig.t(new int[4]);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                int[] gifRect = animationConfig.getGifRect();
                Intrinsics.checkNotNull(gifRect);
                gifRect[i3] = jSONArray.getInt(i3);
            }
        }
    }

    private final void e(f03.b bubbleConfig, JSONObject bubbleConfigJsonObject, JSONArray animationsJsonArray, ArrayList<f03.a> animationConfigs, int i3) throws JSONException {
        JSONObject jSONObject = animationsJsonArray.getJSONObject(i3);
        if (jSONObject.has("animation")) {
            String string = jSONObject.getString("animation");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(\"animation\")");
            JSONObject a16 = a(string, bubbleConfigJsonObject);
            if (a16 == null) {
                return;
            }
            f03.a i16 = i(1, a16);
            JSONArray jSONArray = jSONObject.getJSONArray(QCircleSchemeAttr.Detail.KEY_WORD);
            Intrinsics.checkNotNullExpressionValue(jSONArray, "jsonObj.getJSONArray(\"key_word\")");
            if (i16 != null) {
                i16.u(new ArrayList<>(jSONArray.length()));
                int length = jSONArray.length();
                for (int i17 = 0; i17 < length; i17++) {
                    ArrayList<String> e16 = i16.e();
                    Intrinsics.checkNotNull(e16);
                    e16.add(jSONArray.getString(i17));
                }
                String string2 = jSONObject.getString("animation");
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getString(\"animation\")");
                i16.o(string2);
                i16.k(jSONObject.getString("align"));
                animationConfigs.add(i16);
                if (!TextUtils.isEmpty(i16.getZipName())) {
                    bubbleConfig.a().add(i16.getZipName());
                }
            }
        }
    }

    private final f03.a f(JSONObject object) throws JSONException {
        if (object == null) {
            QLog.e(this.TAG, 1, "parseBubbleFrameAnimationConfig object = null");
            return null;
        }
        f03.a aVar = new f03.a();
        aVar.m(2);
        aVar.n(1);
        if (object.has("repeat")) {
            aVar.r(object.getInt("repeat"));
        }
        if (object.has("count")) {
            aVar.p(object.getInt("count"));
        }
        if (object.has(v.COLUMN_ZIP_NAME)) {
            String string = object.getString(v.COLUMN_ZIP_NAME);
            Intrinsics.checkNotNullExpressionValue(string, "`object`.getString(\"zip_name\")");
            aVar.C(string);
        }
        if (object.has("time")) {
            aVar.B(object.getInt("time"));
        }
        return aVar;
    }

    private final void g(f03.b bubbleConfig, JSONObject bubbleConfigJsonObject) {
        if (bubbleConfigJsonObject.has("loopList")) {
            try {
                JSONArray jSONArray = bubbleConfigJsonObject.getJSONArray("loopList");
                if (jSONArray.length() > 0) {
                    bubbleConfig.B(new ArrayList<>());
                    bubbleConfig.w(0);
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        ArrayList<Integer> k3 = bubbleConfig.k();
                        Intrinsics.checkNotNull(k3);
                        k3.add(Integer.valueOf(jSONArray.getInt(i3)));
                    }
                }
            } catch (Exception e16) {
                QLog.e(this.TAG, 1, "", e16);
            }
        }
    }

    private final void h(f03.b bubbleConfig, JSONObject bubbleConfigJsonObject) throws JSONException {
        boolean startsWith$default;
        boolean startsWith$default2;
        n(bubbleConfig, bubbleConfigJsonObject);
        l(bubbleConfig, bubbleConfigJsonObject);
        if (bubbleConfigJsonObject.has("shadow_blur_color")) {
            bubbleConfig.r(true);
            String strColor = bubbleConfigJsonObject.getString("shadow_blur_color");
            Intrinsics.checkNotNullExpressionValue(strColor, "strColor");
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(strColor, RelationNTPushServiceImpl.PRE_HEX_STRING, false, 2, null);
            if (startsWith$default2) {
                Intrinsics.checkNotNullExpressionValue(strColor, "strColor");
                strColor = strColor.substring(2);
                Intrinsics.checkNotNullExpressionValue(strColor, "this as java.lang.String).substring(startIndex)");
            }
            try {
                bubbleConfig.A(Color.parseColor("#" + strColor));
                return;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "strokeColor invalid");
                    return;
                }
                return;
            }
        }
        if (bubbleConfigJsonObject.has("shadow_color")) {
            bubbleConfig.n(true);
            String strColor2 = bubbleConfigJsonObject.getString("shadow_color");
            Intrinsics.checkNotNullExpressionValue(strColor2, "strColor");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(strColor2, RelationNTPushServiceImpl.PRE_HEX_STRING, false, 2, null);
            if (startsWith$default) {
                Intrinsics.checkNotNullExpressionValue(strColor2, "strColor");
                strColor2 = strColor2.substring(2);
                Intrinsics.checkNotNullExpressionValue(strColor2, "this as java.lang.String).substring(startIndex)");
            }
            try {
                bubbleConfig.A(Color.parseColor("#" + strColor2));
            } catch (Exception unused2) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "strokeColor invalid");
                }
            }
        }
    }

    private final f03.a i(int animType, JSONObject animation) throws JSONException {
        f03.a aVar = new f03.a();
        aVar.m(animType);
        if (animation == null) {
            QLog.e(this.TAG, 1, "parseCommonAnimationConfig animation = null");
            return null;
        }
        d(animation, aVar);
        if (animation.has("cycle_count")) {
            aVar.r(animation.getInt("cycle_count"));
        }
        if (animation.has("count")) {
            aVar.p(animation.getInt("count"));
        }
        if (animation.has(v.COLUMN_ZIP_NAME)) {
            String string = animation.getString(v.COLUMN_ZIP_NAME);
            Intrinsics.checkNotNullExpressionValue(string, "animation.getString(\"zip_name\")");
            aVar.C(string);
        }
        if (animation.has("second_zip_name")) {
            String string2 = animation.getString("second_zip_name");
            Intrinsics.checkNotNullExpressionValue(string2, "animation.getString(\"second_zip_name\")");
            aVar.v(string2);
        }
        if (animation.has("align")) {
            aVar.k(animation.getString("align"));
        }
        if (animation.has(com.tencent.luggage.wxa.c8.c.f123400v)) {
            aVar.l(animation.getBoolean(com.tencent.luggage.wxa.c8.c.f123400v));
        }
        if (animation.has("displayChartlet")) {
            aVar.s(animation.getBoolean("displayChartlet"));
        }
        if (animation.has("mirror")) {
            aVar.w(animation.getBoolean("mirror"));
        }
        aVar.B(animation.getInt("time"));
        return aVar;
    }

    private final void j(f03.b bubbleConfig, JSONObject bubbleConfigJsonObject) throws JSONException {
        String str;
        if (bubbleConfigJsonObject.has("bubbleframe_animation")) {
            JSONObject jSONObject = bubbleConfigJsonObject.getJSONObject("bubbleframe_animation");
            if (!jSONObject.has("animation_set")) {
                return;
            }
            String string = jSONObject.getString("animation_set");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(\"animation_set\")");
            JSONObject b16 = b(string, bubbleConfigJsonObject);
            if (b16 == null) {
                return;
            }
            f03.a f16 = f(b16);
            if (f16 != null) {
                String string2 = jSONObject.getString("animation_set");
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getString(\"animation_set\")");
                f16.o(string2);
            }
            bubbleConfig.o(f16);
            if (f16 != null) {
                str = f16.getZipName();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                HashSet<String> a16 = bubbleConfig.a();
                Intrinsics.checkNotNull(f16);
                a16.add(f16.getZipName());
            }
        }
    }

    private final void k(f03.b bubbleConfig, JSONObject bubbleConfigJsonObject) {
        if (bubbleConfigJsonObject.has("key_animations")) {
            JSONArray animationsJsonArray = bubbleConfigJsonObject.getJSONArray("key_animations");
            ArrayList<f03.a> arrayList = new ArrayList<>();
            int length = animationsJsonArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                Intrinsics.checkNotNullExpressionValue(animationsJsonArray, "animationsJsonArray");
                e(bubbleConfig, bubbleConfigJsonObject, animationsJsonArray, arrayList, i3);
            }
            bubbleConfig.t(arrayList);
        }
    }

    private final void l(f03.b bubbleConfig, JSONObject bubbleConfigJsonObject) throws JSONException {
        boolean startsWith$default;
        if (bubbleConfigJsonObject.has(DittoTextArea.LinkColor)) {
            String strColor = bubbleConfigJsonObject.getString(DittoTextArea.LinkColor);
            Intrinsics.checkNotNullExpressionValue(strColor, "strColor");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(strColor, RelationNTPushServiceImpl.PRE_HEX_STRING, false, 2, null);
            if (startsWith$default) {
                Intrinsics.checkNotNullExpressionValue(strColor, "strColor");
                strColor = strColor.substring(2);
                Intrinsics.checkNotNullExpressionValue(strColor, "this as java.lang.String).substring(startIndex)");
            }
            try {
                bubbleConfig.u(Color.parseColor("#" + strColor));
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "linkcolor invalid");
                }
            }
        }
    }

    private final void m(f03.b bubbleConfig, JSONObject bubbleConfigJsonObject) {
        if (VasNtToggle.VAS_BUG_112810099.isEnable(true) && bubbleConfigJsonObject.has("zoom_point")) {
            JSONArray jSONArray = bubbleConfigJsonObject.getJSONArray("zoom_point");
            bubbleConfig.x(jSONArray.getInt(0));
            bubbleConfig.y(jSONArray.getInt(1));
        }
    }

    private final void n(f03.b bubbleConfig, JSONObject bubbleConfigJsonObject) throws JSONException {
        boolean startsWith$default;
        if (bubbleConfigJsonObject.has("color")) {
            String strColor = bubbleConfigJsonObject.getString("color");
            Intrinsics.checkNotNullExpressionValue(strColor, "strColor");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(strColor, RelationNTPushServiceImpl.PRE_HEX_STRING, false, 2, null);
            if (startsWith$default) {
                Intrinsics.checkNotNullExpressionValue(strColor, "strColor");
                strColor = strColor.substring(2);
                Intrinsics.checkNotNullExpressionValue(strColor, "this as java.lang.String).substring(startIndex)");
            }
            try {
                bubbleConfig.q(Color.parseColor("#" + strColor));
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "color invalid");
                }
            }
        }
    }

    private final void o(f03.b bubbleConfig, JSONObject bubbleConfigJsonObject) throws JSONException {
        String str;
        if (bubbleConfigJsonObject.has("voice_animation")) {
            JSONObject jSONObject = bubbleConfigJsonObject.getJSONObject("voice_animation");
            if (!jSONObject.has("animation")) {
                return;
            }
            String string = jSONObject.getString("animation");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(\"animation\")");
            JSONObject a16 = a(string, bubbleConfigJsonObject);
            if (a16 == null) {
                return;
            }
            f03.a i3 = i(0, a16);
            if (i3 != null) {
                String string2 = jSONObject.getString("animation");
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getString(\"animation\")");
                i3.o(string2);
            }
            bubbleConfig.D(i3);
            if (i3 != null) {
                str = i3.getZipName();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                HashSet<String> a17 = bubbleConfig.a();
                Intrinsics.checkNotNull(i3);
                a17.add(i3.getZipName());
            }
        }
    }

    private final void p(f03.b bubbleConfig, JSONObject bubbleConfigJsonObject) throws JSONException {
        String str;
        if (bubbleConfigJsonObject.has("voiceprint_animation")) {
            JSONObject jSONObject = bubbleConfigJsonObject.getJSONObject("voiceprint_animation");
            if (jSONObject.has("animation_set")) {
                String string = jSONObject.getString("animation_set");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(\"animation_set\")");
                JSONObject b16 = b(string, bubbleConfigJsonObject);
                if (b16 != null) {
                    f03.a q16 = q(b16);
                    if (q16 != null) {
                        String string2 = jSONObject.getString("animation_set");
                        Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getString(\"animation_set\")");
                        q16.o(string2);
                    }
                    bubbleConfig.E(q16);
                    if (q16 != null) {
                        str = q16.getZipName();
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        HashSet<String> a16 = bubbleConfig.a();
                        Intrinsics.checkNotNull(q16);
                        a16.add(q16.getZipName());
                    }
                }
            }
        }
    }

    private final f03.a q(JSONObject object) throws JSONException {
        f03.a aVar = new f03.a();
        aVar.m(3);
        aVar.n(1);
        if (object == null) {
            QLog.e(this.TAG, 1, "parseVoicePrintAnimationConfig object = null");
            return null;
        }
        if (object.has("align")) {
            aVar.k(object.getString("align"));
        }
        if (object.has("repeat")) {
            aVar.r(object.getInt("repeat"));
        }
        if (object.has("count")) {
            aVar.p(object.getInt("count"));
        }
        if (object.has(v.COLUMN_ZIP_NAME)) {
            String string = object.getString(v.COLUMN_ZIP_NAME);
            Intrinsics.checkNotNullExpressionValue(string, "`object`.getString(\"zip_name\")");
            aVar.C(string);
        }
        if (object.has("time")) {
            aVar.B(object.getInt("time"));
        }
        if (object.has("padding")) {
            if (object.getJSONArray("padding").length() > 0) {
                aVar.y(x.a(r3.getInt(0) / 2.0f));
                aVar.A(x.a(r3.getInt(1) / 2.0f));
                aVar.z(x.a(r3.getInt(2) / 2.0f));
                aVar.x(x.a(r3.getInt(3) / 2.0f));
            }
        }
        c(object, aVar);
        return aVar;
    }

    public final void r(@NotNull f03.b bubbleConfig, @NotNull String jsonString) {
        Intrinsics.checkNotNullParameter(bubbleConfig, "bubbleConfig");
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        JSONObject jSONObject = new JSONObject(jsonString);
        String string = jSONObject.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "bubbleConfigJsonObject.getString(\"id\")");
        bubbleConfig.s(string);
        bubbleConfig.v(jSONObject.getString("name"));
        m(bubbleConfig, jSONObject);
        g(bubbleConfig, jSONObject);
        h(bubbleConfig, jSONObject);
        bubbleConfig.C(jSONObject.optDouble("color_threshold_factor", 1.0d));
        o(bubbleConfig, jSONObject);
        p(bubbleConfig, jSONObject);
        j(bubbleConfig, jSONObject);
        k(bubbleConfig, jSONObject);
        bubbleConfig.p(this.diyBubbleConfigParser.b(bubbleConfig, jSONObject));
    }
}
