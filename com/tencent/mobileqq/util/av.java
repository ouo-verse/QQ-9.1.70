package com.tencent.mobileqq.util;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/util/av;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class av {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final av f306600a = new av();

    av() {
    }

    public final void a(@Nullable Context context) {
        InputMethodManager inputMethodManager;
        if (context == null) {
            QLog.e("MemoryLeakUtil_Login", 1, "fixInputMethodMemoryLeak context null");
            return;
        }
        if (Build.VERSION.SDK_INT >= 35) {
            QLog.e("MemoryLeakUtil_Login", 1, "fixInputMethodMemoryLeak, android 15 ignore");
            return;
        }
        Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (systemService instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) systemService;
        } else {
            inputMethodManager = null;
        }
        if (inputMethodManager == null) {
            QLog.e("MemoryLeakUtil_Login", 1, "fixInputMethodMemoryLeak inputMethodManager null");
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView", "mLastSrvView"};
        for (int i3 = 0; i3 < 4; i3++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i3]);
                Intrinsics.checkNotNullExpressionValue(declaredField, "inputMethodManager.javaC\u2026ss.getDeclaredField(view)");
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
                QLog.w("MemoryLeakUtil_Login", 1, e16.getMessage());
            }
        }
    }
}
