package com.tencent.tfd.sdk.wxa;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.HashSet;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.case, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Ccase {
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010b, code lost:
    
        r11 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        StringBuilder sb5 = new StringBuilder();
        try {
            HashSet hashSet = new HashSet();
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            sb5.append(accessibilityManager.isEnabled() ? 1 : 0);
            sb5.append(",");
            sb5.append(accessibilityManager.isTouchExplorationEnabled() ? 1 : 0);
            sb5.append(",");
            boolean z16 = true;
            for (AccessibilityServiceInfo accessibilityServiceInfo : accessibilityManager.getEnabledAccessibilityServiceList(-1)) {
                if (z16) {
                    z16 = false;
                } else {
                    sb5.append(";");
                }
                sb5.append(Integer.toHexString(accessibilityServiceInfo.eventTypes));
                sb5.append(":");
                sb5.append(Integer.toHexString(accessibilityServiceInfo.feedbackType));
                sb5.append(":");
                sb5.append(Integer.toHexString(accessibilityServiceInfo.flags));
                sb5.append(":");
                sb5.append(Integer.toHexString(accessibilityServiceInfo.getCapabilities()));
                sb5.append(":");
                String id5 = accessibilityServiceInfo.getId();
                sb5.append(id5);
                hashSet.add(id5);
                z16 = z16;
            }
            sb5.append(",");
            sb5.append(Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", -1));
            sb5.append(",");
            TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
            String string = DeviceInfoMonitor.getString(context.getContentResolver(), "enabled_accessibility_services");
            if (string != null) {
                simpleStringSplitter.setString(string);
                boolean z17 = true;
                while (simpleStringSplitter.hasNext()) {
                    String next = simpleStringSplitter.next();
                    if (!TextUtils.isEmpty(next) && !hashSet.contains(next)) {
                        String[] split = next.split("/");
                        if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                            ComponentName componentName = new ComponentName(split[0], split[1]);
                            if (!hashSet.contains(componentName.flattenToShortString()) && !hashSet.contains(componentName.flattenToString())) {
                            }
                        }
                        sb5.append(";");
                        z17 = z17;
                        sb5.append(next);
                    }
                }
            }
            return sb5.toString();
        } catch (Throwable unused) {
            return "exp";
        }
    }
}
