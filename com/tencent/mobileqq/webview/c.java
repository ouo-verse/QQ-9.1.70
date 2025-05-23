package com.tencent.mobileqq.webview;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/webview/c;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f313816a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39964);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f313816a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007f A[Catch: Exception -> 0x00c1, TryCatch #0 {Exception -> 0x00c1, blocks: (B:7:0x0011, B:9:0x001d, B:12:0x0024, B:14:0x003c, B:16:0x0048, B:18:0x0055, B:20:0x0062, B:22:0x006f, B:27:0x007f, B:29:0x0082, B:33:0x0085, B:34:0x0089, B:36:0x008f, B:38:0x009b, B:39:0x009e, B:41:0x00a6, B:43:0x00ac, B:47:0x00ba, B:49:0x00bd), top: B:6:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082 A[SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(@NotNull Context context) {
        InputMethodManager inputMethodManager;
        View view;
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 29) {
            return;
        }
        try {
            Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (systemService instanceof InputMethodManager) {
                inputMethodManager = (InputMethodManager) systemService;
            } else {
                inputMethodManager = null;
            }
            if (inputMethodManager == null) {
                return;
            }
            Field[] declaredFields = inputMethodManager.getClass().getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "imm.javaClass.declaredFields");
            ArrayList<Field> arrayList = new ArrayList();
            for (Field field : declaredFields) {
                if (!Intrinsics.areEqual(field.getName(), "mCurRootView") && !Intrinsics.areEqual(field.getName(), "mServedView") && !Intrinsics.areEqual(field.getName(), "mNextServedView") && !Intrinsics.areEqual(field.getName(), "mLastSrvView") && !Intrinsics.areEqual(field.getName(), "mCurRootView")) {
                    z16 = false;
                    if (!z16) {
                        arrayList.add(field);
                    }
                }
                z16 = true;
                if (!z16) {
                }
            }
            for (Field field2 : arrayList) {
                boolean isAccessible = field2.isAccessible();
                if (!isAccessible) {
                    field2.setAccessible(true);
                }
                Object obj = field2.get(inputMethodManager);
                if (obj instanceof View) {
                    view = (View) obj;
                } else {
                    view = null;
                }
                if (view != null) {
                    if (!Intrinsics.areEqual(view.getContext(), context)) {
                        view = null;
                    }
                    if (view != null) {
                        field2.set(inputMethodManager, null);
                    }
                }
                field2.setAccessible(isAccessible);
            }
        } catch (Exception e16) {
            QLog.d("LeakFix", 1, "fixImmMemoryLeak exception. ", e16);
        }
    }
}
