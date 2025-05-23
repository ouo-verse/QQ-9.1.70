package com.tencent.biz.qrcode;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class CustomAccessibilityDelegate extends View.AccessibilityDelegate {

    /* renamed from: a, reason: collision with root package name */
    private View f94574a;

    /* renamed from: b, reason: collision with root package name */
    private a f94575b;

    /* renamed from: c, reason: collision with root package name */
    private Runnable f94576c = new Runnable() { // from class: com.tencent.biz.qrcode.CustomAccessibilityDelegate.1
        @Override // java.lang.Runnable
        public void run() {
            if (CustomAccessibilityDelegate.this.f94575b != null) {
                CustomAccessibilityDelegate.this.f94575b.e2();
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void e2();

        void z1();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends AccessibilityNodeProvider {
        public b() {
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i3) {
            if (i3 == -1 && CustomAccessibilityDelegate.this.f94574a != null) {
                AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(CustomAccessibilityDelegate.this.f94574a);
                CustomAccessibilityDelegate.this.f94574a.onInitializeAccessibilityNodeInfo(obtain);
                obtain.setText(CustomAccessibilityDelegate.this.f94574a.getContentDescription());
                return obtain;
            }
            return null;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i3, int i16, Bundle bundle) {
            boolean performAccessibilityAction = CustomAccessibilityDelegate.this.f94574a.performAccessibilityAction(i16, bundle);
            if (i16 == 128) {
                CustomAccessibilityDelegate.this.f94574a.post(CustomAccessibilityDelegate.this.f94576c);
            } else if (i16 == 64) {
                CustomAccessibilityDelegate.this.f94574a.removeCallbacks(CustomAccessibilityDelegate.this.f94576c);
                if (CustomAccessibilityDelegate.this.f94575b != null) {
                    CustomAccessibilityDelegate.this.f94575b.z1();
                }
            }
            return performAccessibilityAction;
        }
    }

    public CustomAccessibilityDelegate(View view, a aVar) {
        this.f94574a = view;
        this.f94575b = aVar;
    }

    @Override // android.view.View.AccessibilityDelegate
    public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return new b();
    }
}
