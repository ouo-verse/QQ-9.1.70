package h03;

import android.content.Context;
import android.graphics.Color;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import com.tencent.upload.uinterface.data.UppUploadTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0002R\u0017\u0010\u001a\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u000f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001e\u001a\u00020\u000f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\u00a8\u0006!"}, d2 = {"Lh03/b;", "", "Lorg/json/JSONObject;", "jsonObj", "Lg03/a;", "d", "Landroid/content/Context;", "context", "", "sp", "", "e", "c", "bubbleConfigJsonObject", "", "", "diyPasterKeys", "", "a", "Lf03/b;", "bubbleConfig", "Ljava/util/HashMap;", "b", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "getDIY_NEW_CONFIG_TYPE", "DIY_NEW_CONFIG_TYPE", "getDIY_OLD_CONFIG_TYPE", "DIY_OLD_CONFIG_TYPE", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = IBubbleManager.INSTANCE.b() + "DIYBubbleConfigParser";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String DIY_NEW_CONFIG_TYPE = "diy_chartlet";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String DIY_OLD_CONFIG_TYPE = "static";

    private final void a(JSONObject bubbleConfigJsonObject, List<String> diyPasterKeys) {
        if (bubbleConfigJsonObject.has("chartlet_animation")) {
            JSONObject optJSONObject = bubbleConfigJsonObject.optJSONObject("chartlet_animation");
            if (optJSONObject.has("animation_set")) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("animation_set");
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray.optString(i3);
                    Intrinsics.checkNotNullExpressionValue(optString, "animatorJsonArray.optString(j)");
                    diyPasterKeys.add(optString);
                }
            }
        }
    }

    private final g03.a c(JSONObject jsonObj) {
        boolean equals;
        boolean equals2;
        String type = jsonObj.optString("type");
        equals = StringsKt__StringsJVMKt.equals(this.DIY_NEW_CONFIG_TYPE, type, true);
        if (!equals) {
            equals2 = StringsKt__StringsJVMKt.equals(this.DIY_OLD_CONFIG_TYPE, type, true);
            if (!equals2) {
                QLog.e(this.TAG, 1, "error! paster type: " + type);
                return null;
            }
        }
        g03.b bVar = new g03.b();
        Intrinsics.checkNotNullExpressionValue(type, "type");
        bVar.k(type);
        String optString = jsonObj.optString("align");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(\"align\")");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String upperCase = optString.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        bVar.f(upperCase);
        if (jsonObj.has(CanvasView.ACTION_RECT)) {
            JSONArray optJSONArray = jsonObj.optJSONArray(CanvasView.ACTION_RECT);
            bVar.i(new int[4]);
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr = bVar.getCom.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RECT java.lang.String();
                Intrinsics.checkNotNull(iArr);
                iArr[i3] = optJSONArray.optInt(i3);
            }
        }
        bVar.h(jsonObj.optBoolean("mirror", true));
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "Resolve DiyBubblePasterConfig json->" + jsonObj);
        }
        return bVar;
    }

    private final g03.a d(JSONObject jsonObj) {
        boolean startsWith$default;
        g03.c cVar = new g03.c();
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String optString = jsonObj.optString("align");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(\"align\")");
        cVar.f(optString);
        cVar.r(e(context, jsonObj.optInt("text_size") / 2) + 1);
        cVar.o(jsonObj.optString("text_align"));
        String strColor = jsonObj.optString("text_color");
        Intrinsics.checkNotNullExpressionValue(strColor, "strColor");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(strColor, RelationNTPushServiceImpl.PRE_HEX_STRING, false, 2, null);
        if (startsWith$default) {
            Intrinsics.checkNotNullExpressionValue(strColor, "strColor");
            strColor = strColor.substring(2);
            Intrinsics.checkNotNullExpressionValue(strColor, "this as java.lang.String).substring(startIndex)");
        }
        try {
            cVar.p(Color.parseColor("#" + strColor));
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "diy text_color invalid");
            }
        }
        if (jsonObj.has(CanvasView.ACTION_RECT)) {
            JSONArray optJSONArray = jsonObj.optJSONArray(CanvasView.ACTION_RECT);
            cVar.i(new int[4]);
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr = cVar.getCom.tencent.qqmini.miniapp.widget.CanvasView.ACTION_RECT java.lang.String();
                Intrinsics.checkNotNull(iArr);
                iArr[i3] = optJSONArray.optInt(i3);
            }
        }
        cVar.q(jsonObj.optInt("text_max_count"));
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "Resolve DiyBubbleTextConfig json->" + jsonObj);
        }
        return cVar;
    }

    private final int e(Context context, float sp5) {
        return (int) ((sp5 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Nullable
    public final HashMap<String, g03.a> b(@NotNull f03.b bubbleConfig, @NotNull JSONObject bubbleConfigJsonObject) {
        g03.a c16;
        Intrinsics.checkNotNullParameter(bubbleConfig, "bubbleConfig");
        Intrinsics.checkNotNullParameter(bubbleConfigJsonObject, "bubbleConfigJsonObject");
        ArrayList arrayList = new ArrayList();
        a(bubbleConfigJsonObject, arrayList);
        if (bubbleConfigJsonObject.has("diy_animation")) {
            String optString = bubbleConfigJsonObject.optJSONObject("diy_animation").optString(UppUploadTask.sfUppAppId);
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(\"diy\")");
            arrayList.add(optString);
        }
        if (bubbleConfigJsonObject.has("animation_sets")) {
            JSONObject optJSONObject = bubbleConfigJsonObject.optJSONObject("animation_sets");
            HashMap<String, g03.a> hashMap = new HashMap<>(4);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(it.next());
                if (optJSONObject2 != null) {
                    if (optJSONObject2.has("text_size")) {
                        c16 = d(optJSONObject2);
                    } else {
                        c16 = c(optJSONObject2);
                    }
                    if (c16 != null) {
                        c16.g(bubbleConfig.getId());
                        c16.getAlign();
                        hashMap.put(c16.getAlign(), c16);
                    }
                }
            }
            return hashMap;
        }
        return null;
    }
}
