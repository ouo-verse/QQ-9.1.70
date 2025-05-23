package com.tencent.rmonitor.memory.leakdetect;

import android.content.Context;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ActivityLeakSolution {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f365715a = false;

    private static void a(Context context, InputMethodManager inputMethodManager) {
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i3]);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                if (obj instanceof View) {
                    View view = (View) obj;
                    if (view.getContext() == context) {
                        declaredField.set(inputMethodManager, null);
                    } else {
                        Logger.f365497g.d("RMonitor_MemoryLeak_ActivityLeakSolution", "fixInputMethodManagerLeak break, context not suitable", ", get_context=", view.getContext().toString(), ", dest_context=", context.toString());
                        return;
                    }
                } else {
                    continue;
                }
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_MemoryLeak_ActivityLeakSolution", th5);
            }
        }
    }

    public static void fixAudioManagerLeak(@NonNull Context context) {
        if (f365715a && !AndroidVersion.isOverM()) {
            try {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                Field declaredField = audioManager.getClass().getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(audioManager, null);
            } catch (Exception e16) {
                Logger.f365497g.e("RMonitor_MemoryLeak_ActivityLeakSolution", e16.toString());
            }
        }
    }

    public static void fixInputMethodManagerLeak(@Nullable Context context) {
        InputMethodManager inputMethodManager;
        if (!f365715a || context == null) {
            return;
        }
        try {
            inputMethodManager = (InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_MemoryLeak_ActivityLeakSolution", th5);
            inputMethodManager = null;
        }
        if (inputMethodManager == null) {
            return;
        }
        a(context, inputMethodManager);
    }

    public static void setSwitchLeakSolution(boolean z16) {
        f365715a = z16;
    }
}
