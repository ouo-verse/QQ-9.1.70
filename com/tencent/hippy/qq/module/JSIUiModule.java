package com.tencent.hippy.qq.module;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = JSIUiModule.CLASS_NAME)
/* loaded from: classes7.dex */
public class JSIUiModule extends QQBaseModule {
    public static final String CLASS_NAME = "JSIUiModule";
    public static final String EMPTY_JSON = "{}";

    public JSIUiModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private String formatColor(String str) {
        try {
            int parseColor = Color.parseColor(str);
            int alpha = Color.alpha(parseColor);
            int red = Color.red(parseColor);
            int green = Color.green(parseColor);
            int blue = Color.blue(parseColor);
            if (alpha == 255) {
                return String.format("#%02X%02X%02X", Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue));
            }
            String replace = String.format("%.2f", Float.valueOf((alpha * 1.0f) / 255.0f)).replace("0.", ".");
            if (replace == ".00") {
                return String.format("rgba(%d, %d, %d, 0)", Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue));
            }
            if (replace.lastIndexOf(replace.length() - 1) == 48) {
                return String.format("rgba(%d, %d, %d, %s)", Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue), replace.substring(0, 2));
            }
            return String.format("rgba(%d, %d, %d, %s)", Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue), replace);
        } catch (IllegalArgumentException e16) {
            QLog.e(CLASS_NAME, 1, "formatColor e:", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRightFlingToBackFromCenter$0(boolean z16) {
        QBaseFragment fragment = getFragment();
        if (fragment instanceof BaseHippyFragment) {
            BaseHippyFragment baseHippyFragment = (BaseHippyFragment) fragment;
            if (!baseHippyFragment.isFragmentDestroyed()) {
                baseHippyFragment.enableRightFling(z16);
            }
        }
    }

    @HippyMethod(isSync = true, name = "getQuiColors")
    public String getQuiColors(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{}";
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return "{}";
            }
            JSONObject jSONObject = new JSONObject();
            Map<String, String> currentTokenMap = QUIUtil.getCurrentTokenMap();
            QLog.i(CLASS_NAME, 1, "tokenMap :" + currentTokenMap);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String obj = jSONArray.get(i3).toString();
                String str2 = currentTokenMap.get(obj);
                if (!TextUtils.isEmpty(str2) && !str2.contains(",")) {
                    String formatColor = formatColor(str2);
                    if (!TextUtils.isEmpty(formatColor)) {
                        jSONObject.put(obj, formatColor);
                    }
                }
            }
            return jSONObject.toString();
        } catch (IllegalArgumentException e16) {
            QLog.e(CLASS_NAME, 1, "getTokenColors IllegalArgument e:", e16);
            return "{}";
        } catch (JSONException e17) {
            QLog.e(CLASS_NAME, 1, "getTokenColors json e:", e17);
            return "{}";
        }
    }

    @HippyMethod(isSync = true, name = "isNightModeTheme")
    public boolean isNightModeTheme() {
        return QQTheme.isNowThemeIsNight();
    }

    @HippyMethod(isSync = true, name = "setRightFlingToBackFromCenter")
    public void setRightFlingToBackFromCenter(final boolean z16) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.hippy.qq.module.d
            @Override // java.lang.Runnable
            public final void run() {
                JSIUiModule.this.lambda$setRightFlingToBackFromCenter$0(z16);
            }
        });
    }
}
