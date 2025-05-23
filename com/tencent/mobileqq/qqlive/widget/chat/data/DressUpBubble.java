package com.tencent.mobileqq.qqlive.widget.chat.data;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class DressUpBubble implements Serializable {
    static IPatchRedirector $redirector_;
    public int andOrientation;
    public String bgColorFirst;
    public String bgColorSecond;
    public String decorationUrl;
    public boolean disableDecor;
    public String outlineColor;
    public String outlineColorSecond;
    public String textColor;

    public DressUpBubble() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.andOrientation = GradientDrawable.Orientation.LEFT_RIGHT.ordinal();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public int parseTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        try {
            return Color.parseColor(this.textColor);
        } catch (Exception unused) {
            return i3;
        }
    }

    public String toJsonStr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "{\n\"and_orientation\": " + this.andOrientation + ",\n\"bg_color_first\": \"" + this.bgColorFirst + "\",\n\"bg_color_second\": \"" + this.bgColorSecond + "\",\n\"decoration_url\": \"" + this.decorationUrl + "\",\n\"disable_decor\": " + this.disableDecor + ",\n\"outline_color\": \"" + this.outlineColor + "\",\n\"text_color\": \"" + this.textColor + "\"\n}";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "DressUpBubble{textColor='" + this.textColor + "', bgColorFirst='" + this.bgColorFirst + "', bgColorSecond='" + this.bgColorSecond + "', outlineColor='" + this.outlineColor + "', outlineColorSecond='" + this.outlineColorSecond + "', decorationUrl='" + this.decorationUrl + "', andOrientation='" + this.andOrientation + "', disableDecor='" + this.disableDecor + "'}";
    }

    public DressUpBubble(sr4.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        this.andOrientation = GradientDrawable.Orientation.LEFT_RIGHT.ordinal();
        this.textColor = aVar.f434347a;
        this.bgColorFirst = aVar.f434348b;
        this.bgColorSecond = aVar.f434349c;
        this.outlineColor = aVar.f434350d;
        this.decorationUrl = aVar.f434351e;
        this.disableDecor = aVar.f434358l;
        this.andOrientation = aVar.f434357k;
    }

    public DressUpBubble(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.andOrientation = GradientDrawable.Orientation.LEFT_RIGHT.ordinal();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("text_color")) {
                this.textColor = jSONObject.getString("text_color");
            }
            if (jSONObject.has("bg_color_first")) {
                this.bgColorFirst = jSONObject.getString("bg_color_first");
            }
            if (jSONObject.has("bg_color_second")) {
                this.bgColorSecond = jSONObject.getString("bg_color_second");
            }
            if (jSONObject.has("outline_color")) {
                this.outlineColor = jSONObject.getString("outline_color");
            }
            if (jSONObject.has("outline_color_second")) {
                this.outlineColorSecond = jSONObject.getString("outline_color_second");
            }
            if (jSONObject.has("decoration_url")) {
                this.decorationUrl = jSONObject.getString("decoration_url");
            }
            if (jSONObject.has("disable_decor")) {
                this.disableDecor = jSONObject.optBoolean("disable_decor");
            }
            if (jSONObject.has("and_orientation")) {
                this.andOrientation = jSONObject.optInt("and_orientation");
            }
        } catch (Exception e16) {
            QLog.e("DressUpBubble", 1, "parse exception: " + e16);
        }
    }
}
