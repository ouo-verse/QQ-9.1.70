package com.tencent.qqmini.sdk.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class DebugUtil {
    public static boolean getDebugEnabled(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return false;
        }
        return getDebugEnabled(miniAppInfo.appId);
    }

    public static String getPrintableStackTrace(Throwable th5) {
        return getPrintableStackTrace(th5, false);
    }

    public static String getStackTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringWriter stringWriter = new StringWriter();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringWriter.write(stackTraceElement.toString());
            stringWriter.write("\n");
        }
        stringWriter.flush();
        return stringWriter.toString();
    }

    public static boolean isDebugVersion() {
        return ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion();
    }

    public static void setDebugEnabled(MiniAppInfo miniAppInfo, boolean z16) {
        if (miniAppInfo == null) {
            return;
        }
        setDebugEnabled(miniAppInfo.appId, z16, false);
    }

    public static boolean getDebugEnabled(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return StorageUtil.getPreference().getBoolean(str + "_debug", false);
    }

    private static String getPrintableStackTrace(Throwable th5, boolean z16) {
        Throwable cause;
        if (th5 == null) {
            return "";
        }
        Thread currentThread = Thread.currentThread();
        StringBuilder sb5 = new StringBuilder();
        if (!z16) {
            sb5.append("Exception in thread \"");
            sb5.append(currentThread.getName());
            sb5.append("\"");
            sb5.append(th5.toString());
        }
        for (StackTraceElement stackTraceElement : th5.getStackTrace()) {
            sb5.append("\tat ");
            sb5.append(stackTraceElement);
            sb5.append("\n");
        }
        if (th5 instanceof InvocationTargetException) {
            cause = ((InvocationTargetException) th5).getTargetException();
        } else {
            cause = th5.getCause();
        }
        if (cause != null) {
            sb5.append("caused by: ");
            sb5.append(cause.toString());
            sb5.append("\n");
            sb5.append(getPrintableStackTrace(cause, true));
        }
        return sb5.toString();
    }

    public static void setDebugEnabled(String str, boolean z16, boolean z17) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = StorageUtil.getPreference().edit();
        edit.putBoolean(str + "_debug", z16);
        if (z17) {
            edit.commit();
        } else {
            edit.apply();
        }
    }
}
