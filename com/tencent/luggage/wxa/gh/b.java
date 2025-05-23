package com.tencent.luggage.wxa.gh;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f126710a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f126711b;

        public a(String str, String str2) {
            this.f126710a = str;
            this.f126711b = str2;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            if (!w0.c(this.f126710a)) {
                accessibilityNodeInfo.setContentDescription(this.f126710a);
            }
            if (!w0.c(this.f126711b) && this.f126711b.equalsIgnoreCase("button")) {
                accessibilityNodeInfo.setClickable(true);
                accessibilityNodeInfo.setClassName(Button.class.getName());
            } else {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.setClassName(TextView.class.getName());
            }
        }
    }

    public static void a(View view, JSONObject jSONObject) {
        if (view == null || jSONObject == null || !jSONObject.has("accessibility") || !jSONObject.optBoolean("accessibility", false)) {
            return;
        }
        view.setAccessibilityDelegate(new a(jSONObject.optString("ariaLabel", ""), jSONObject.optString("ariaRole", "")));
    }

    public static Boolean a(Context context) {
        if (context == null) {
            w.f("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, context is null");
            return null;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager == null) {
            w.f("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, accessibilityManager is null");
            return null;
        }
        if (!accessibilityManager.isTouchExplorationEnabled()) {
            w.d("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, isTalkBackAccessibilityEnabled: false");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
