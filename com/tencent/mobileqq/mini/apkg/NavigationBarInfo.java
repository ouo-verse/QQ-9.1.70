package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NavigationBarInfo implements Cloneable {
    public int backgoundColor;
    public String style;
    public String textStyle;
    public String titleText;

    public static NavigationBarInfo getDefault() {
        NavigationBarInfo navigationBarInfo = new NavigationBarInfo();
        navigationBarInfo.backgoundColor = ColorUtils.parseColor("#000000");
        navigationBarInfo.textStyle = "white";
        navigationBarInfo.style = "default";
        return navigationBarInfo;
    }

    public void updateInfo(JSONObject jSONObject) {
        int parseColor;
        String optString = jSONObject.optString("navigationBarBackgroundColor");
        if (TextUtils.isEmpty(optString)) {
            parseColor = this.backgoundColor;
        } else {
            parseColor = ColorUtils.parseColor(optString);
        }
        this.backgoundColor = parseColor;
        String optString2 = jSONObject.optString("navigationBarTextStyle", this.textStyle);
        this.textStyle = optString2;
        if (!"white".equals(optString2) && !"black".equals(this.textStyle)) {
            this.textStyle = "white";
        }
        this.titleText = jSONObject.optString("navigationBarTitleText", this.titleText);
        this.style = jSONObject.optString("navigationStyle", this.style);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public NavigationBarInfo m200clone() {
        try {
            return (NavigationBarInfo) super.clone();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
