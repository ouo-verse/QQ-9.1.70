package com.tencent.pts.ui;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSStrToObjMap;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes22.dex */
public class PTSNodeStyle extends PTSStrToObjMap {
    static IPatchRedirector $redirector_;
    private Integer backgroundColor;
    private float[] borderRadii;
    private float borderWidth;
    private float fontSize;
    private int height;
    private int left;
    private float lineHeight;
    private int[] padding;
    private int top;
    private int width;

    public PTSNodeStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void init() {
        this.left = PTSDeviceUtil.dp2pxInt(PTSValueConvertUtil.getFloat(get(PTSNodeStyleConstant.CALCULATED_LEFT)));
        this.top = PTSDeviceUtil.dp2pxInt(PTSValueConvertUtil.getFloat(get(PTSNodeStyleConstant.CALCULATED_TOP)));
        this.width = PTSDeviceUtil.dp2pxInt(PTSValueConvertUtil.getFloat(get(PTSNodeStyleConstant.CALCULATED_WIDTH)));
        this.height = PTSDeviceUtil.dp2pxInt(PTSValueConvertUtil.getFloat(get(PTSNodeStyleConstant.CALCULATED_HEIGHT)));
        this.borderWidth = PTSValueConvertUtil.getFloat(get(PTSNodeStyleConstant.BORDER_WIDTH));
        this.fontSize = 16.0f;
        if (get("font-size") != null) {
            this.fontSize = PTSValueConvertUtil.getFloat(get("font-size"));
        }
        this.lineHeight = getFontSize() * 1.6f;
        if (get("line-height") != null) {
            this.lineHeight = PTSValueConvertUtil.getFloat(get("line-height"));
        }
        if (get("background-color") != null) {
            this.backgroundColor = Integer.valueOf(PTSValueConvertUtil.getColor(get("background-color")));
        }
        initPadding();
        initBorderRadii();
    }

    private void initBorderRadii() {
        this.borderRadii = new float[4];
        try {
            String str = (String) get("border-radius");
            if (str != null) {
                String[] split = str.trim().split("\\s+");
                for (int i3 = 0; i3 < Math.min(split.length, 4); i3++) {
                    if (Float.parseFloat(split[i3]) > 0.0f) {
                        this.borderRadii[i3] = PTSDeviceUtil.dp2px(Float.parseFloat(split[i3]));
                    } else {
                        this.borderRadii[i3] = 0.0f;
                    }
                }
            }
        } catch (Exception e16) {
            PTSLog.e(this.TAG, "getBorderRadii, e = " + e16);
        }
    }

    private void initPadding() {
        this.padding = new int[4];
        try {
            String str = (String) get("padding");
            if (str != null && !str.isEmpty() && !str.equalsIgnoreCase("0 0 0 0")) {
                String[] split = str.trim().split("\\s+");
                for (int i3 = 0; i3 < Math.min(split.length, 4); i3++) {
                    this.padding[i3] = PTSDeviceUtil.dp2pxInt(Float.parseFloat(split[i3]));
                }
            }
        } catch (Exception e16) {
            PTSLog.e(this.TAG, "getPadding, e = " + e16);
        }
    }

    public Integer getBackgroundColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Integer) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.backgroundColor;
    }

    public float[] getBorderRadii() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (float[]) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.borderRadii;
    }

    public float getBorderWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.borderWidth;
    }

    public float getFontSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return this.fontSize;
    }

    public String getFontWeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (get("font-weight") != null) {
            return PTSValueConvertUtil.getString(get("font-weight"));
        }
        return "normal";
    }

    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.height;
    }

    public int getLeft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.left;
    }

    public float getLineHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
        }
        return this.lineHeight;
    }

    public float getLineSpacing(TextPaint textPaint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Float) iPatchRedirector.redirect((short) 13, (Object) this, (Object) textPaint)).floatValue();
        }
        if (TextUtils.equals("bold", getFontWeight())) {
            textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        }
        float lineSpacing = PTSNodeTextBase.getLineSpacing(getLineHeight(), getFontSize(), textPaint);
        if (lineSpacing <= 0.0f) {
            return 0.0f;
        }
        return lineSpacing;
    }

    public int[] getPadding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (int[]) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.padding;
    }

    public int getTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.top;
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.width;
    }

    public PTSNodeStyle(Map<String, Object> map) {
        super(map);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
        }
    }

    public PTSNodeStyle(JSONObject jSONObject) {
        super(jSONObject);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
        }
    }

    private void initLineSpacing() {
    }
}
