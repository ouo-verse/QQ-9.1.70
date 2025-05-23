package com.tencent.open.base;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h {
    public static void a(Context context) {
        if (context == null) {
            QLog.e("MemoryLeakUtil", 1, "fixInputMethodMemoryLeak context null");
            return;
        }
        if (Build.VERSION.SDK_INT >= 35) {
            QLog.e("MemoryLeakUtil", 1, "fixInputMethodMemoryLeak, android 15 ignore");
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null) {
            QLog.e("MemoryLeakUtil", 1, "fixInputMethodMemoryLeak inputMethodManager null");
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView", "mLastSrvView"};
        for (int i3 = 0; i3 < 4; i3++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i3]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (obj != null && (obj instanceof View)) {
                    if (((View) obj).getContext() == context) {
                        declaredField.set(inputMethodManager, null);
                    } else {
                        return;
                    }
                }
            } catch (Exception e16) {
                QLog.w("MemoryLeakUtil", 1, e16.getMessage());
            }
        }
    }
}
