package i33;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import androidx.core.graphics.ColorUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.k;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.theme.AbsTintManger;
import com.tencent.mobileqq.vas.theme.SimpleTintManager;
import com.tencent.mobileqq.vas.theme.ThemeConfigParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends AbsTintManger {

    /* renamed from: a, reason: collision with root package name */
    protected JSONObject f407138a;

    /* renamed from: b, reason: collision with root package name */
    protected JSONObject f407139b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<String> f407140c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private String f407141d = "";

    /* renamed from: e, reason: collision with root package name */
    protected String f407142e;

    private void a(Paint paint, String str, JSONObject jSONObject) {
        String str2;
        String optString = jSONObject.optString(str);
        if (!TextUtils.isEmpty(optString)) {
            if (str.contains(".")) {
                str2 = str.split("\\.")[0];
            } else {
                str2 = str;
            }
            int f16 = d.f(str2, "drawable");
            if (f16 > 0 && SkinEngine.getInstances().checkResExist(f16)) {
                if (QLog.isColorLevel()) {
                    QLog.i("BaseTintManager", 2, "checkResExist fileName:" + str);
                    return;
                }
                return;
            }
            if (optString.contains(",")) {
                String[] split = optString.split("\\,");
                int length = split.length;
                for (int i3 = 0; i3 < length && !f(paint, split[i3]); i3++) {
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("BaseTintManager", 2, "plateName:" + optString + " fileName:" + str);
            }
            f(paint, optString);
        }
    }

    private void e(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                this.f407138a = jSONObject.optJSONObject("mapping");
                this.f407139b = jSONObject.optJSONObject("plate");
            }
        } catch (JSONException e16) {
            VasLogReporter.getTheme().report("TintManager parseLocalData error");
            QLog.e("BaseTintManager", 1, "parseLocalData error", e16);
        }
        if (this.f407138a == null) {
            this.f407138a = new JSONObject();
        }
        if (this.f407139b == null) {
            this.f407139b = new JSONObject();
        }
    }

    private boolean f(Paint paint, String str) {
        String replace;
        int f16;
        Integer plateColor;
        if (this.f407139b != null && (plateColor = getPlateColor(str)) != null && paint != null) {
            paint.setColorFilter(new LightingColorFilter(0, plateColor.intValue()));
            return true;
        }
        if (str.contains(".xml") && (f16 = d.f((replace = str.replace(".xml", "")), "color")) > 0) {
            int color = SkinEngine.getInstances().getColor(f16);
            if (paint != null) {
                paint.setColorFilter(new LightingColorFilter(0, color));
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(" skin_bar_textcolorName:");
                    sb5.append(replace);
                    sb5.append(" colorId:");
                    sb5.append(f16);
                    sb5.append(" rgbColor:");
                    int i3 = 16777215 - color;
                    sb5.append(Integer.toString(i3, 16));
                    sb5.append(" ");
                    sb5.append(Integer.toHexString(i3));
                    sb5.append(" ");
                    sb5.append(color);
                    QLog.i("BaseTintManager", 1, sb5.toString());
                }
                return true;
            }
        }
        return false;
    }

    private void setColors(int[] iArr, int i3, Integer num) {
        if (num != null && iArr != null && iArr.length > i3) {
            iArr[i3] = num.intValue();
        }
    }

    protected boolean b(String str) {
        String parseThemeIdFromPath = ThemeConfigParser.parseThemeIdFromPath(str);
        if (TextUtils.isEmpty(parseThemeIdFromPath)) {
            QLog.d("BaseTintManager", 1, "load config theme id is null");
            return true;
        }
        if (Objects.equals(parseThemeIdFromPath, this.f407142e)) {
            QLog.d("BaseTintManager", 1, "config same theme!");
            return true;
        }
        this.f407142e = parseThemeIdFromPath;
        QQTheme.getCurrentThemeId();
        return false;
    }

    @Override // com.tencent.theme.ISkinTint
    public void clear() {
        this.f407138a = null;
        this.f407139b = null;
        this.f407142e = null;
        this.f407140c.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("mapping");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("plate");
                JSONArray optJSONArray = jSONObject.optJSONArray("forbidden");
                d.h(this.f407138a, optJSONObject, true);
                d.h(this.f407139b, optJSONObject2, false);
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        this.f407140c.add(optJSONArray.optString(i3));
                    }
                }
            }
        } catch (JSONException e16) {
            VasLogReporter.getTheme().report("TintManager overrideData error");
            QLog.e("BaseTintManager", 1, "overrideData error", e16);
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.AbsTintManger
    public Map<String, String> getCurrentTintColorMap() {
        Integer plateColor;
        if (this.f407138a != null && this.f407139b != null) {
            try {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = this.f407138a;
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    if (str.contains("qui_") && !jSONObject.optString(str).contains(",") && (plateColor = getPlateColor(jSONObject.optString(str))) != null) {
                        hashMap.put(str, d.i(plateColor.intValue()));
                    }
                }
                return hashMap;
            } catch (Exception e16) {
                QLog.e("BaseTintManager", 1, "getCurrentQUITokenMap error: ", e16);
                return null;
            }
        }
        QLog.i("BaseTintManager", 1, "getCurrentQUITokenMap, mapping or plate is null");
        return null;
    }

    @Override // com.tencent.mobileqq.vas.theme.AbsTintManger
    public Integer getPlateColor(String str) {
        JSONObject jSONObject;
        Integer valueOf;
        Integer valueOf2;
        if (TextUtils.isEmpty(str) || (jSONObject = this.f407139b) == null) {
            return null;
        }
        String optString = jSONObject.optString(str.split("[*+!]")[0]);
        if (!TextUtils.isEmpty(optString)) {
            try {
                valueOf = Integer.valueOf(Color.parseColor(optString));
            } catch (NumberFormatException e16) {
                QLog.e("BaseTintManager", 1, e16, new Object[0]);
                return null;
            }
        } else {
            valueOf = null;
        }
        if (valueOf == null) {
            return null;
        }
        if (str.contains("*")) {
            int parseFloat = (int) (Float.parseFloat(str.split("[*]")[1]) * 255.0f);
            if (parseFloat == 0) {
                return 0;
            }
            if (parseFloat > 0 && parseFloat < 255) {
                valueOf2 = Integer.valueOf(ColorUtils.setAlphaComponent(valueOf.intValue(), parseFloat));
            } else {
                return valueOf;
            }
        } else if (str.contains(Marker.ANY_NON_NULL_MARKER)) {
            int parseFloat2 = (int) (Float.parseFloat(str.split("[+]")[1]) * 255.0f);
            if (parseFloat2 > 0 && parseFloat2 < 255) {
                valueOf2 = Integer.valueOf(d.a(valueOf.intValue(), parseFloat2));
            } else {
                return valueOf;
            }
        } else {
            if (str.contains("!")) {
                return Integer.valueOf(d.c(valueOf.intValue()));
            }
            return valueOf;
        }
        return valueOf2;
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean isTint(String str) {
        JSONObject jSONObject = this.f407138a;
        if (this.f407140c.contains(str) || jSONObject == null) {
            return false;
        }
        return !TextUtils.isEmpty(jSONObject.optString(str));
    }

    @Override // com.tencent.theme.ISkinTint
    public void loadConfig(Resources resources, String str) {
        if (b(str)) {
            return;
        }
        SimpleTintManager.instance().clear();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (TextUtils.isEmpty(this.f407141d)) {
                this.f407141d = k.b(resources.getAssets(), "theme_mapping.json");
            }
            String str2 = "";
            if (!TextUtils.isEmpty(str)) {
                QLog.i("BaseTintManager", 2, "skinFilePath " + str);
                File file = new File(str);
                if (file.exists()) {
                    str2 = FileUtils.readFileContent(file);
                }
            }
            this.f407140c.clear();
            e(this.f407141d);
            d(str2);
            c(resources, str);
            QLog.i("BaseTintManager", 2, "loadConfig elapse:" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e16) {
            QLog.e("BaseTintManager", 1, "loadConfig error skinFilePath:" + str, e16);
        }
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean needTintRes(String str) {
        return false;
    }

    @Override // com.tencent.theme.ISkinTint
    public void tint(Paint paint, String str) {
        JSONObject jSONObject = this.f407138a;
        if (jSONObject != null && paint != null && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("BaseTintManager", 2, " fileName:" + str);
            }
            ArrayList<String> arrayList = this.f407140c;
            if (arrayList != null && arrayList.contains(str)) {
                return;
            }
            a(paint, str, jSONObject);
        }
    }

    @Override // com.tencent.theme.ISkinTint
    public void tintColorState(int[] iArr, int[][] iArr2, String str) {
        JSONObject jSONObject = this.f407138a;
        if (iArr != null && iArr.length > 0 && jSONObject != null && !TextUtils.isEmpty(str)) {
            String optString = jSONObject.optString(str);
            if (optString.contains(",")) {
                String[] split = optString.split("\\,");
                for (int i3 = 0; i3 < split.length; i3++) {
                    setColors(iArr, i3, getPlateColor(split[i3]));
                }
                return;
            }
            if (!TextUtils.isEmpty(optString)) {
                setColors(iArr, 0, getPlateColor(optString));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Resources resources, String str) {
    }
}
