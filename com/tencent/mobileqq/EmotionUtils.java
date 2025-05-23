package com.tencent.mobileqq;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class EmotionUtils {
    static IPatchRedirector $redirector_;

    public static final int a(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static boolean b() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    public static void c(Context context, int i3) {
        new QQToastNotifier(context).notifyUser(i3, context.getResources().getDimensionPixelSize(R.dimen.title_bar_height), 0, 0);
    }

    public static void d(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3) {
        if (iEmoticonMainPanelApp == null) {
            return;
        }
        if (i3 == 1) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.EmotionUtils.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) IEmoticonMainPanelApp.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        VasUpdateUtil.getJSONFromLocal(IEmoticonMainPanelApp.this.getAppRuntime(), VasUpdateConstants.SCID_KANDIAN_RECOMMENT_EMOTICON, true, null);
                    }
                }
            }, 128, null, true);
            return;
        }
        SharedPreferences sharedPreferences = iEmoticonMainPanelApp.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
        if (System.currentTimeMillis() - sharedPreferences.getLong("last_get_recommendemotion_time_" + iEmoticonMainPanelApp.getCurrentUin(), 0L) >= sharedPreferences.getInt("recommendSeqinterval", 7200) * 1000) {
            if (QLog.isColorLevel()) {
                QLog.d("EmoticonMainPanelApp", 2, "sendRecommendSSORequest send req to recommend");
            }
            ((EmoticonHandlerProxy) iEmoticonMainPanelApp.getBusinessHandler(EmoticonHandler.F)).getRecommendEmoticonInfo();
            sharedPreferences.edit().putLong("last_get_recommendemotion_time_" + iEmoticonMainPanelApp.getCurrentUin(), System.currentTimeMillis()).apply();
        }
    }

    public static void e(View view) {
        if (view == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, "showKeyboard failed, view is null ");
                return;
            }
            return;
        }
        if (view.requestFocus()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " requestFocus success ");
            }
            boolean hasFocus = view.hasFocus();
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " hasFocus " + hasFocus);
            }
        } else if (QLog.isColorLevel()) {
            QLog.e("Q.aio.XPanelContainer", 2, " requestFocus fail ");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager.showSoftInput(view, 0)) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput success ");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("Q.aio.XPanelContainer", 2, " showSoftInput fail ");
            }
            try {
                Class<?> cls = inputMethodManager.getClass();
                Field declaredField = cls.getDeclaredField("mServedView");
                Field declaredField2 = cls.getDeclaredField("mNextServedView");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                Object obj = declaredField.get(inputMethodManager);
                Object obj2 = declaredField2.get(inputMethodManager);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput fail mNextServedObject = " + obj2 + " mServedObject" + obj + " messageInputer = " + view);
                }
                if (obj != null && obj != view && (obj instanceof View)) {
                    inputMethodManager.hideSoftInputFromWindow(((View) obj).getWindowToken(), 0);
                    view.requestFocusFromTouch();
                    view.requestFocus();
                    if (!inputMethodManager.showSoftInput(view, 0) && QLog.isColorLevel()) {
                        QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput fail ");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput end");
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " imm.isActive() = " + inputMethodManager.isActive());
        }
    }

    public static void f(Context context, int i3, int i16) {
        QQToast.makeText(context, i3, i16).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }
}
