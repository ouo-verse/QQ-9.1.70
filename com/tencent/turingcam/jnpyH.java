package com.tencent.turingcam;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class jnpyH {
    public static boolean a(AccessibilityServiceInfo accessibilityServiceInfo) {
        ServiceInfo serviceInfo;
        ApplicationInfo applicationInfo;
        ResolveInfo resolveInfo = accessibilityServiceInfo.getResolveInfo();
        if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null && (applicationInfo = serviceInfo.applicationInfo) != null) {
            if (applicationInfo.uid < 10000) {
                return true;
            }
            if (!TextUtils.isEmpty(applicationInfo.sourceDir) && !applicationInfo.sourceDir.startsWith("/data/")) {
                return true;
            }
            Object a16 = A0PGF.a(ApplicationInfo.class, "seInfo", applicationInfo);
            if (a16 instanceof String) {
                String str = (String) a16;
                if (str.contains("partition=product") || str.contains("partition=system_ext")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(StringBuilder sb5, AccessibilityServiceInfo accessibilityServiceInfo) {
        sb5.append(Integer.toHexString(accessibilityServiceInfo.eventTypes));
        sb5.append(":");
        sb5.append(Integer.toHexString(accessibilityServiceInfo.feedbackType));
        sb5.append(":");
        sb5.append(Integer.toHexString(accessibilityServiceInfo.flags));
        sb5.append(":");
        sb5.append(Integer.toHexString(accessibilityServiceInfo.getCapabilities()));
        sb5.append(":");
        sb5.append(accessibilityServiceInfo.getId());
    }
}
