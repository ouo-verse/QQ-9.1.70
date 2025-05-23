package com.tencent.qqperf.monitor.crash.tools;

import android.content.Context;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.HashMap;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Stack<String> f363222a = new Stack<>();

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, String> f363223b = new HashMap<>(4);

    public static void a() {
        f363222a.clear();
    }

    public static String b() {
        StringBuilder sb5 = new StringBuilder(128);
        for (int min = Math.min(f363222a.size(), 5); min > 0; min--) {
            String pop = f363222a.pop();
            if (sb5.length() > 0) {
                sb5.append("\n--->");
            }
            sb5.append(pop);
        }
        return sb5.toString();
    }

    public static int c() {
        return f363222a.size();
    }

    public static String d() {
        return f363223b.toString();
    }

    private static void e(String str, String str2) {
        if (str != null && str2 != null) {
            f363223b.remove(str);
            f363223b.put(str, str2 + " time:" + System.currentTimeMillis() + "\n");
        }
    }

    public static void f(Context context) {
        if (context != null) {
            String obj = context.toString();
            f363222a.push(obj);
            e("onCreate", obj);
        }
    }

    public static void g(Context context) {
        if (context != null) {
            String obj = context.toString();
            f363222a.remove(obj);
            e(MosaicConstants$JsFunction.FUNC_ON_DESTROY, obj);
        }
    }

    public static void h(Context context) {
        if (context != null) {
            e(MiniSDKConst.NOTIFY_EVENT_ONPAUSE, context.toString());
        }
    }

    public static void i(Context context) {
        if (context != null) {
            e("onResume", context.toString());
        }
    }
}
