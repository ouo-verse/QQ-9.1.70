package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppTextArea extends EditText {
    static IPatchRedirector $redirector_;

    public MiniAppTextArea(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public void a(int i3, JSONObject jSONObject, WebviewContainer webviewContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), jSONObject, webviewContainer);
            return;
        }
        setBackgroundDrawable(null);
        setSingleLine(false);
        setHorizontallyScrolling(false);
        setInputType(IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_TCP_OPEN);
        setFocusable(true);
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (jSONObject.optBoolean("disabled")) {
            setInputType(0);
        }
        if (jSONObject.optBoolean("hidden")) {
            setVisibility(8);
        }
        if (jSONObject.optBoolean(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM)) {
            setImeOptions(6);
        }
        int optInt = jSONObject.optInt("maxLength");
        if (optInt != -1) {
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(optInt)});
        }
        String optString = jSONObject.optString("placeholder");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("placeholderStyle");
        if (!StringUtil.isEmpty(optString)) {
            setHint(optString);
            setHintTextColor(Color.parseColor(optJSONObject2.optString("color")));
        }
        if ("left".equals(optJSONObject.optString("textAlign"))) {
            setGravity(3);
        }
        addTextChangedListener(new c(this, optJSONObject2, optJSONObject, i3, webviewContainer, jSONObject));
    }
}
