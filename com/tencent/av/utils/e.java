package com.tencent.av.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.utils.api.IAudioHelperApi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f77109a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f77110b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f77111c = true;

    public static void a(Resources resources, TextView textView, int i3, int i16, int i17) {
        ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).changButtonStyle(resources, textView, i3, i16, i17);
    }

    public static void b(View view, boolean z16, int i3) {
        ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).changViewStyle(view, z16, i3);
    }

    @TargetApi(17)
    public static long c() {
        return ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).elapsedRealtimeNanos();
    }

    public static synchronized long d() {
        long genDebugSeq;
        synchronized (e.class) {
            genDebugSeq = ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).genDebugSeq();
        }
        return genDebugSeq;
    }

    public static int e(int i3) {
        return ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).getDebugValue(i3);
    }

    public static String f(Object obj) {
        return ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).getLogString(obj);
    }

    public static String g(Resources resources, int i3) {
        return ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).getResIDName(resources, i3);
    }

    public static String h(View view, int i3) {
        return ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).getResIDName(view, i3);
    }

    public static long i() {
        return NetConnInfoCenter.getServerTimeMillis();
    }

    public static boolean j() {
        return ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).isDev();
    }

    public static boolean k() {
        return ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).isLogColorOrGary();
    }

    public static void l(String str, Intent intent) {
        ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).print(str, intent);
    }

    public static void m(String str, Bundle bundle) {
        ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).print(str, bundle);
    }

    public static void n(String str, Bundle bundle, boolean z16) {
        ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).print(str, bundle, z16);
    }

    public static <T1, T2> void o(String str, Map<T1, T2> map, boolean z16) {
        ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).print(str, map, z16);
    }

    @TargetApi(17)
    public static void p(String str) {
        ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).printTime(str);
    }

    public static boolean q(BaseApplication baseApplication, long j3) {
        return ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).registDebugReceiver(baseApplication, j3);
    }

    public static void r(String str, boolean z16) {
        ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).reportExp(str, z16);
    }

    public static void s(Context context) {
        ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).setBeaconDebug(context);
    }

    public static void t(long j3) {
        ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).setCurAccount(j3);
    }

    public static void u(String str) {
        ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).showDebugToast(str);
    }

    public static long v(String str) {
        return ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).stringToLong(str);
    }

    public static void w(AppInterface appInterface) {
        ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).syncPrintBaseInfo(appInterface);
    }

    public static final void x(String str) {
        ((IAudioHelperApi) QRoute.api(IAudioHelperApi.class)).writeTestLog(str);
    }
}
