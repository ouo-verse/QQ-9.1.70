package i33;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.k;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableColorStateList;
import java.io.File;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import xy2.d;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e extends a {

    /* renamed from: f, reason: collision with root package name */
    private String f407151f = "";

    private String h(String str, String str2) {
        String str3 = "vas_palette_theme5_" + str;
        String decodeString = VasMMKV.getCommon().decodeString(str3, "");
        String str4 = "vas_palette_theme_text5_" + str;
        String str5 = "vas_palette_theme_text_t5_" + str;
        r(VasMMKV.getCommon().decodeString(str4, ""), VasMMKV.getCommon().decodeString(str5, ""));
        if (!TextUtils.isEmpty(decodeString)) {
            QLog.d("VasBaseThemeTint", 1, "calculateBackgroundColor use cache color:" + decodeString);
            return decodeString;
        }
        return m(str, str2, str4, str5, str3);
    }

    private String j(String str, float f16) {
        return d.i(d.b(Color.parseColor(str), f16, d.g(Color.parseColor(str))));
    }

    private void k(String str, Resources resources, String str2) {
        boolean z16;
        boolean z17 = false;
        if (!TextUtils.isEmpty(str) && QQTheme.isVasTheme(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        File parentFile = new File(str2).getParentFile();
        l(parentFile);
        JSONObject jSONObject = this.f407139b;
        if (jSONObject == null) {
            return;
        }
        if (TextUtils.isEmpty(jSONObject.optString("A1", "")) || TextUtils.isEmpty(this.f407139b.optString("B1", "")) || TextUtils.isEmpty(this.f407139b.optString("C1", ""))) {
            z17 = true;
        }
        if (z17 && parentFile != null) {
            String absolutePath = parentFile.getAbsolutePath();
            q(this.f407139b, absolutePath, "A1", R.color.skin_input_theme_version2, "#4D4D4D");
            q(this.f407139b, absolutePath, NowProxyConstants.AccountInfoKey.A2, R.color.skin_bar_text, "#FFFFFF");
            q(this.f407139b, absolutePath, "A3", R.color.skin_gray2_theme_version2, "#999999");
            q(this.f407139b, absolutePath, "A4", R.color.skin_bar_text, "#CCCCCC");
            q(this.f407139b, absolutePath, "A6", R.color.skin_color_tab_simple_selected, "#0099FF");
            q(this.f407139b, absolutePath, "T1", R.color.skin_input_theme_version2, "#000000");
            q(this.f407139b, absolutePath, "T2", R.color.skin_gray2_theme_version2, "#8C8C8C");
            q(this.f407139b, absolutePath, "T3", R.color.skin_hint_input_theme_version2, "#CCCCCC");
            q(this.f407139b, absolutePath, "T4", R.color.skin_title_segment_item_color, "#FFFFFF");
            q(this.f407139b, absolutePath, "T5", R.color.skin_chat_buble_link, "#000000");
            q(this.f407139b, absolutePath, "T6", R.color.skin_chat_buble_link_mine, "#2D77E5");
            q(this.f407139b, absolutePath, "T7", R.color.skin_chat_buble, "#000000");
            q(this.f407139b, absolutePath, "T8", R.color.skin_chat_buble_mine, "#FFFFFF");
            q(this.f407139b, absolutePath, "T9", R.color.skin_aio_input_button, "#000000");
            q(this.f407139b, absolutePath, "C2", R.color.skin_color_btn_blue_v2, "#0099FF");
            p(str, h(str, absolutePath));
            g(str, resources);
            return;
        }
        try {
            if (this.f407139b != null) {
                Integer plateColor = getPlateColor("B1");
                Integer plateColor2 = getPlateColor("B3");
                if (plateColor != null && plateColor2 != null && plateColor.intValue() == plateColor2.intValue()) {
                    this.f407139b.put("B3", j(d.i(plateColor.intValue()), 0.12f));
                    QLog.i("VasBaseThemeTint", 1, "overrideBackgroundColor b3");
                }
            }
        } catch (Exception e16) {
            QLog.e("VasBaseThemeTint", 1, "plate error", e16);
        }
    }

    private static void l(File file) {
        if (!new File(file, "drawable-xxhdpi/skin_background.png").exists() && !new File(file, "drawable-xhdpi/skin_background.png").exists()) {
            if (new File(file, "drawable-xxhdpi/skin_background_theme_version2.png").exists()) {
                QLog.i("VasBaseThemeTint", 2, "copy drawable-xxhdpi/skin_background_theme_version2.png");
                FileUtils.copyFile(new File(file, "drawable-xxhdpi/skin_background_theme_version2.png"), new File(file, "drawable-xxhdpi/skin_background.png"));
            } else if (new File(file, "drawable-xhdpi/skin_background_theme_version2.png").exists()) {
                QLog.i("VasBaseThemeTint", 2, "copy drawable-xhdpi/skin_background_theme_version2.png");
                FileUtils.copyFile(new File(file, "drawable-xhdpi/skin_background_theme_version2.png"), new File(file, "drawable-xhdpi/skin_background.png"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String q(JSONObject jSONObject, String str, String str2, int i3, String str3) {
        SkinnableColorStateList skinnableColorStateList;
        if (SkinEngine.getInstances().checkResExist(i3)) {
            skinnableColorStateList = SkinEngine.getInstances().loadColorForTheme(i3, str);
        } else {
            skinnableColorStateList = null;
        }
        if (skinnableColorStateList != null) {
            try {
                String i16 = d.i(skinnableColorStateList.getDefaultColor());
                jSONObject.put(str2, i16);
                QLog.i("VasBaseThemeTint", 1, "overrideColor " + str2 + " to " + i16);
                return i16;
            } catch (JSONException e16) {
                QLog.e("VasBaseThemeTint", 1, e16, new Object[0]);
            }
        }
        try {
            jSONObject.put(str2, str3);
            QLog.w("VasBaseThemeTint", 1, "overrideColor " + str2 + " to default(" + str3 + ")");
        } catch (JSONException e17) {
            QLog.e("VasBaseThemeTint", 1, e17, new Object[0]);
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i33.a
    public void c(Resources resources, String str) {
        super.c(resources, str);
        k(this.f407142e, resources, str);
        String optString = VasLongToggle.THEME_FIX_PLATE_CONFIG.getJson().optString(this.f407142e);
        if (!TextUtils.isEmpty(optString)) {
            d(optString);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(String str, Resources resources) {
        if (TextUtils.isEmpty(this.f407151f)) {
            this.f407151f = k.b(resources.getAssets(), "theme_mapping_extra.json");
        }
        if (this.f407138a != null && !TextUtils.isEmpty(this.f407151f)) {
            try {
                JSONObject optJSONObject = new JSONObject(this.f407151f).optJSONObject("mapping");
                if (optJSONObject == null) {
                    return;
                }
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    String optString = optJSONObject.optString(str2);
                    if (!TextUtils.isEmpty(optString) && !this.f407138a.has(str2)) {
                        try {
                            this.f407138a.putOpt(str2, optString);
                            QLog.w("VasBaseThemeTint", 1, "addMappingIfEmpty:" + str2 + "," + optString);
                        } catch (JSONException e16) {
                            QLog.e("VasBaseThemeTint", 1, "addExtraMapping error", e16);
                        }
                    }
                }
            } catch (JSONException e17) {
                QLog.e("TintManager", 1, "addExtraMapping error", e17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String i() {
        Integer plateColor = getPlateColor("T1");
        if (plateColor != null && d.g(plateColor.intValue())) {
            return d.i(-1);
        }
        return "#7f7f7f";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String m(String str, String str2, String str3, String str4, String str5) {
        int parseColor;
        String i3 = i();
        try {
            String str6 = "";
            String str7 = File.separator;
            if (!str2.endsWith(str7)) {
                str6 = str2 + str7;
            }
            String o16 = o(str, str6);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inSampleSize = 4;
            Bitmap decodeFile = BitmapFactory.decodeFile(o16, options);
            if (decodeFile != null) {
                xy2.d b16 = new d.b(decodeFile).a().b();
                if (decodeFile.getWidth() > 0 && decodeFile.getHeight() > 0) {
                    parseColor = decodeFile.getPixel(0, 0);
                } else {
                    parseColor = Color.parseColor(i3);
                }
                String i16 = d.i(b16.i(parseColor));
                s(str, str2, str3, str4, b16.j());
                String n3 = n(str, i16);
                QLog.d("VasBaseThemeTint", 1, "calculateBackgroundColor palette dominant color:" + n3);
                VasMMKV.getCommon().encodeString(str5, n3);
                decodeFile.recycle();
                return n3;
            }
            QLog.d("VasBaseThemeTint", 1, "calculateBackgroundColor null bitmap:" + str2);
            return i3;
        } catch (Exception e16) {
            QLog.e("VasBaseThemeTint", 1, e16, new Object[0]);
            return i3;
        }
    }

    protected String o(String str, String str2) {
        return d.d(str2, "skin_background.png");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(String str, String str2) {
        try {
            this.f407139b.put("B1", str2);
            this.f407139b.put("B2", j(str2, 0.05f));
            this.f407139b.put("B3", j(str2, 0.12f));
            this.f407139b.put("B4", str2);
            this.f407139b.put("B5", j(str2, 0.23f));
            this.f407139b.put("B6", j(str2, 0.28f));
            this.f407139b.put("C1", j(str2, 0.1f));
            QLog.i("VasBaseThemeTint", 1, "overrideBackgroundColor " + str2);
        } catch (JSONException e16) {
            QLog.e("VasBaseThemeTint", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f407139b.put("T1", str);
            if (!TextUtils.isEmpty(str2)) {
                this.f407139b.put("T2", str2);
            }
            QLog.w("VasBaseThemeTint", 1, "overrideTextColor t1" + str + ",t2=" + str2);
        } catch (JSONException e16) {
            QLog.e("VasBaseThemeTint", 1, e16, new Object[0]);
        }
    }

    protected void s(String str, String str2, String str3, String str4, d.C11578d c11578d) {
        if (c11578d != null) {
            String i3 = d.i(c11578d.b());
            VasMMKV.getCommon().encodeString(str3, i3);
            r(i3, "");
        }
    }

    protected String n(String str, String str2) {
        return str2;
    }
}
