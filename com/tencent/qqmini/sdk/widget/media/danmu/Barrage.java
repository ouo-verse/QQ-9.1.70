package com.tencent.qqmini.sdk.widget.media.danmu;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import java.util.Arrays;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Barrage {
    public final int color;
    public final String text;
    public final long time;

    public Barrage(String str, int i3, long j3) {
        this.text = str;
        this.color = i3;
        this.time = j3;
    }

    public static Barrage parseJson(JSONObject jSONObject) {
        int parseColor;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("text");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        long optLong = jSONObject.optLong("time", -1L);
        if (optLong < 0) {
            return null;
        }
        String optString2 = jSONObject.optString("color");
        if (TextUtils.isEmpty(optString2)) {
            parseColor = -1;
        } else {
            parseColor = ColorUtils.parseColor(optString2);
        }
        return new Barrage(optString, parseColor, optLong);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Barrage barrage = (Barrage) obj;
        if (this.color == barrage.color && this.time == barrage.time && this.text == null && barrage.text == null) {
            return true;
        }
        String str = this.text;
        if (str != null && str.equals(barrage.text)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.text, Integer.valueOf(this.color), Long.valueOf(this.time)});
    }
}
