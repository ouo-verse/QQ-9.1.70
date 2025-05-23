package com.tencent.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class InputMethodUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_QQPINYIN_EXPRESSION = "com.tencent.qqpinyin.expression";
    public static final String ACTION_QQPINYIN_QQEXP = "com.tencent.qqpinyin.qqexp";
    public static final String ACTION_SOGOU_APP_ID = "com.sogou.inputmethod.appid";
    public static final String ACTION_SOGOU_EXPRESSION = "com.sogou.inputmethod.expression";
    public static final String ACTION_SOGOU_OPEN_ID = "com.tencent.mobileqq.sogou.openid";
    public static final String ACTION_SOGOU_PTT_ARGS_NOTIFY = "com.tencent.mobileqq_audioArgs";
    public static final String ACTION_SOGOU_PTT_HANDLED_NOTIFY = "com.tencent.mobileqq_handleCompleted";
    public static final String ACTION_SOGOU_QQEXP = "com.sogou.inputmethod.qqexp";
    public static final String ACTION_SOUGOU_NEW_EXP = "com.sogou.inputmethod.exp.commit";
    public static final String ARGS_KEY_2SOGOU_SUPPORT_PTT = "DoesSupportDirectlyAudio";
    public static final String ARGS_KEY_2SOGOU_TIME_LENGTH = "TimeLength";
    public static final String ARGS_KEY_CHANNELS = "Channels";
    public static final String ARGS_KEY_INPUT_METHOD = "InputMethodName";
    public static final String ARGS_KEY_PCMFILE_PATH = "PCMFilePath";
    public static final String ARGS_KEY_SAMPLE_RATE = "SampleRate";
    public static final String ARGS_KEY_SOUGOU_INPUT_NAME = "com.sohu.inputmethod.sogou";
    public static final String BUDNLE_KEY_SOGOU_EXP_PATH = "EXP_PATH";
    public static final String BUNDLE_KEY_SOGOU_EXP_ALL_PACKID = "EXP_ALL_PACKID";
    public static final String BUNDLE_KEY_SOGOU_EXP_ID = "EXP_ID";
    public static final String BUNDLE_KEY_SOGOU_EXP_KEY = "EXP_KEY";
    public static final String BUNDLE_KEY_SOGOU_PACK_ID = "PACKAGE_ID";
    public static final String EXP_PATH_URI = "EXP_PATH_URI";
    public static final String FLAG_SOGOU_EXPRESSION = "SOGOU_EXPRESSION";
    public static final String KEY_QQPINYIN_EXPRESSION = "QQINPUT_EXP_PATH";
    public static final String KEY_SOGOU_APP_ID = "SOGOU_APP_ID";
    public static final String KEY_SOGOU_EXPRESSION = "SOGOU_EXP_PATH";
    public static final String KEY_SOGOU_OPEN_ID = "SOGOU_OPENID";
    public static final String QQPINYIN_PACKAGENAME = "com.tencent.qqpinyin";
    public static final String SOGOU_EXPRESSION_WEBP = "SOGOU_EXPRESSION_WEBP";
    public static final String SOGOU_INPUT_EXP = "sogou_input_exp";
    public static final String SOUGOU_PTT_TAG = "sougouptt";
    public static final String SOUGOU_URI_DISPLAYNAME = "_display_name";
    public static final String SUPPORT_SOGOU_EXPRESSION = "SUPPORT_SOGOU_EXPRESSION";

    public InputMethodUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean checkSogouInputDefault(Context context) {
        try {
            String string = DeviceInfoMonitor.getString(context.getContentResolver(), "default_input_method");
            if (string == null || (!string.contains("com.sohu.inputmethod.sogou") && !string.contains(QQPINYIN_PACKAGENAME) && !string.contains("com.sogou.zhuyininput"))) {
                return false;
            }
            return true;
        } catch (NullPointerException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("InputMethodUtil", 2, "checkSogouInputDefault(), e = " + e16.getStackTrace());
            }
            return false;
        }
    }

    public static void hide(View view) {
        if (view == null) {
            return;
        }
        ((InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void show(View view) {
        ((InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(view, 0);
    }

    public static void hide(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
            }
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                e16.printStackTrace();
            }
        }
    }
}
