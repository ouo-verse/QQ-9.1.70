package com.tencent.mobileqq.remoteweb;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.log.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/ac;", "", "Landroid/content/Context;", "appContext", "", "a", "", "b", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ac {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ac f281144a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39661);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f281144a = new ac();
        }
    }

    ac() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(@NotNull Context appContext) {
        ActivityManager activityManager;
        List<ActivityManager.RunningServiceInfo> emptyList;
        boolean z16;
        ComponentName componentName;
        String className;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appContext)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Object systemService = appContext.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService instanceof ActivityManager) {
            activityManager = (ActivityManager) systemService;
        } else {
            activityManager = null;
        }
        if (activityManager == null) {
            return false;
        }
        try {
            emptyList = activityManager.getRunningServices(100);
            if (emptyList == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
        } catch (Throwable th5) {
            com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
            a.b bVar = new a.b();
            String str = "[checkPreloadWebServiceRunning] error " + th5;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWebRenderUtils", 1, (String) it.next(), null);
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList<ActivityManager.RunningServiceInfo> arrayList = new ArrayList();
        for (Object obj : emptyList) {
            if (((ActivityManager.RunningServiceInfo) obj).process.equals("com.tencent.mobileqq:tool")) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (ActivityManager.RunningServiceInfo runningServiceInfo : arrayList) {
            if (runningServiceInfo != null && (componentName = runningServiceInfo.service) != null && (className = componentName.getClassName()) != null && className.equals(f281144a.b())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String canonicalName = PreloadWebService.class.getCanonicalName();
        if (canonicalName == null) {
            return "";
        }
        return canonicalName;
    }
}
