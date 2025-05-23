package com.tencent.luggage.wxa.bo;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.luggage.wxa.tn.w;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static Activity a(Context context) {
        Context baseContext;
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == context) {
            return null;
        }
        return a(baseContext);
    }

    public static void b(Context context) {
        InputMethodManager inputMethodManager;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) == null) {
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView", "mLastSrvView"};
        for (int i3 = 0; i3 < 4; i3++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i3]);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(inputMethodManager);
                if (obj != null && (obj instanceof View)) {
                    View view = (View) obj;
                    if (view.getContext() == context || a(context, view.getContext())) {
                        declaredField.set(inputMethodManager, null);
                    }
                }
            } catch (Throwable th5) {
                w.h("Luggage.AndroidContextUtil", "fixInputMethodManagerLeak %s", th5.getMessage());
            }
        }
    }

    public static boolean a(Context context, Context context2) {
        if (context == context2) {
            return true;
        }
        if (context2 instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context2).getBaseContext();
            while (context != baseContext) {
                if ((baseContext instanceof ContextWrapper) && (baseContext = ((ContextWrapper) baseContext).getBaseContext()) != null) {
                }
            }
            return true;
        }
        return false;
    }
}
