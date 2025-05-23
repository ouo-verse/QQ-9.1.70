package com.tencent.hippy.qq.view.text;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@HippyController(name = HippyQQJustifyTextViewController.CLASS_NAME)
/* loaded from: classes7.dex */
public class HippyQQJustifyTextViewController extends HippyViewController<HippyQQJustifyTextView> {
    public static final String CLASS_NAME = "QQJustifyTextView";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class FontStyleName {
        private static final String BOLD = "bold";
        private static final String BOLD_ITALIC = "bold_italic";
        private static final String ITALIC = "italic";
        private static final String NORMAL = "normal";
        private String styleName;

        public FontStyleName(String str) {
            this.styleName = str;
        }

        public int getStyle() {
            if ("bold".equals(this.styleName)) {
                return 1;
            }
            if ("italic".equals(this.styleName)) {
                return 2;
            }
            if (BOLD_ITALIC.equals(this.styleName)) {
                return 3;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private interface PropertyName {
        public static final String FONT_FAMILY = "fontFamily";
        public static final String FONT_STYLE = "fontStyle";
        public static final String TEXT = "text";
        public static final String TEXT_COLOR = "textColor";
        public static final String TEXT_SIZE = "textSize";
    }

    private View createView(Context context) {
        return new HippyQQJustifyTextView(context);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return createView(context);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onAfterUpdateProps(HippyQQJustifyTextView hippyQQJustifyTextView) {
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "fontFamily")
    public void setFontFamily(HippyQQJustifyTextView hippyQQJustifyTextView, String str) {
        if (!TextUtils.isEmpty(str)) {
            hippyQQJustifyTextView.setFontFamily(str);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "fontStyle")
    public void setFontStyle(HippyQQJustifyTextView hippyQQJustifyTextView, String str) {
        if (!TextUtils.isEmpty(str)) {
            hippyQQJustifyTextView.setFontStyle(str);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "text")
    public void setText(HippyQQJustifyTextView hippyQQJustifyTextView, String str) {
        hippyQQJustifyTextView.setText(str);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "textColor")
    public void setTextColor(HippyQQJustifyTextView hippyQQJustifyTextView, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                hippyQQJustifyTextView.setTextColor(Color.parseColor(str));
            }
        } catch (IllegalArgumentException e16) {
            QLog.e(CLASS_NAME, 1, e16, new Object[0]);
        }
    }

    @HippyControllerProps(defaultType = "number", name = "textSize")
    public void setTextSize(HippyQQJustifyTextView hippyQQJustifyTextView, float f16) {
        if (f16 > 0.0f) {
            hippyQQJustifyTextView.setTextSize(f16);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        return createView(context);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyQQJustifyTextView hippyQQJustifyTextView, String str, HippyArray hippyArray) {
        hippyQQJustifyTextView.dispatchFunction(str, hippyArray, null);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyQQJustifyTextView hippyQQJustifyTextView, String str, HippyArray hippyArray, Promise promise) {
        hippyQQJustifyTextView.dispatchFunction(str, hippyArray, promise);
    }
}
