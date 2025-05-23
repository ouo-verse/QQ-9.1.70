package com.tencent.biz.qui.quicommon;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AccessibilityUtil {

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qui.quicommon.AccessibilityUtil$4, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f95151d;

        @Override // java.lang.Runnable
        public void run() {
            this.f95151d.sendAccessibilityEvent(8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f95152a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f95153b;

        a(CharSequence charSequence, String str) {
            this.f95152a = charSequence;
            this.f95153b = str;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            CharSequence charSequence = this.f95152a;
            if (charSequence != null) {
                accessibilityNodeInfo.setContentDescription(charSequence);
            }
            accessibilityNodeInfo.setClassName(this.f95153b);
        }
    }

    @TargetApi(14)
    public static void a(View view, CharSequence charSequence, String str) {
        view.setAccessibilityDelegate(new a(charSequence, str));
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                return false;
            }
            if (!accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @TargetApi(14)
    public static void c(final View view) {
        if (view == null) {
            if (ud0.d.h()) {
                ud0.d.k("AccessibilityUtil", ud0.d.f438810d, "requestFocus view can't be null");
                return;
            }
            return;
        }
        view.postDelayed(new Runnable() { // from class: com.tencent.biz.qui.quicommon.AccessibilityUtil.3
            @Override // java.lang.Runnable
            public void run() {
                view.sendAccessibilityEvent(128);
            }
        }, 200L);
    }
}
