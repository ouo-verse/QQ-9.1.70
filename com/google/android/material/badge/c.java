package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.ParcelableSparseArray;
import com.tencent.mobileqq.R;

/* compiled from: P */
@ExperimentalBadgeUtils
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f33274a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends AccessibilityDelegateCompat {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BadgeDrawable f33275a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View.AccessibilityDelegate accessibilityDelegate, BadgeDrawable badgeDrawable) {
            super(accessibilityDelegate);
            this.f33275a = badgeDrawable;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(this.f33275a.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b extends AccessibilityDelegateCompat {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BadgeDrawable f33276a;

        b(BadgeDrawable badgeDrawable) {
            this.f33276a = badgeDrawable;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(this.f33276a.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@NonNull BadgeDrawable badgeDrawable, @NonNull View view) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (Build.VERSION.SDK_INT >= 29 && ViewCompat.hasAccessibilityDelegate(view)) {
            accessibilityDelegate = view.getAccessibilityDelegate();
            ViewCompat.setAccessibilityDelegate(view, new a(accessibilityDelegate, badgeDrawable));
        } else {
            ViewCompat.setAccessibilityDelegate(view, new b(badgeDrawable));
        }
    }

    public static void c(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        g(badgeDrawable, view, frameLayout);
        if (badgeDrawable.g() != null) {
            badgeDrawable.g().setForeground(badgeDrawable);
        } else {
            if (!f33274a) {
                view.getOverlay().add(badgeDrawable);
                return;
            }
            throw new IllegalArgumentException("Trying to reference null customBadgeParent");
        }
    }

    @NonNull
    public static SparseArray<BadgeDrawable> d(Context context, @NonNull ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i3 = 0; i3 < parcelableSparseArray.size(); i3++) {
            int keyAt = parcelableSparseArray.keyAt(i3);
            BadgeState.State state = (BadgeState.State) parcelableSparseArray.valueAt(i3);
            if (state != null) {
                sparseArray.put(keyAt, BadgeDrawable.c(context, state));
            } else {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
        }
        return sparseArray;
    }

    @NonNull
    public static ParcelableSparseArray e(@NonNull SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            int keyAt = sparseArray.keyAt(i3);
            BadgeDrawable valueAt = sparseArray.valueAt(i3);
            if (valueAt != null) {
                parcelableSparseArray.put(keyAt, valueAt.k());
            } else {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        return parcelableSparseArray;
    }

    public static void f(@Nullable BadgeDrawable badgeDrawable, @NonNull View view) {
        if (badgeDrawable == null) {
            return;
        }
        if (!f33274a && badgeDrawable.g() == null) {
            view.getOverlay().remove(badgeDrawable);
        } else {
            badgeDrawable.g().setForeground(null);
        }
    }

    public static void g(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.C(view, frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static void h(BadgeDrawable badgeDrawable, Resources resources) {
        badgeDrawable.w(resources.getDimensionPixelOffset(R.dimen.cre));
        badgeDrawable.x(resources.getDimensionPixelOffset(R.dimen.crf));
    }

    public static void i(@NonNull Rect rect, float f16, float f17, float f18, float f19) {
        rect.set((int) (f16 - f18), (int) (f17 - f19), (int) (f16 + f18), (int) (f17 + f19));
    }
}
