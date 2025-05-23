package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.o;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BottomNavigationView extends NavigationBarView {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements ViewUtils.d {
        a() {
        }

        @Override // com.google.android.material.internal.ViewUtils.d
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.e eVar) {
            int i3;
            eVar.f33795d += windowInsetsCompat.getSystemWindowInsetBottom();
            boolean z16 = true;
            if (ViewCompat.getLayoutDirection(view) != 1) {
                z16 = false;
            }
            int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
            int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
            int i16 = eVar.f33792a;
            if (z16) {
                i3 = systemWindowInsetRight;
            } else {
                i3 = systemWindowInsetLeft;
            }
            eVar.f33792a = i16 + i3;
            int i17 = eVar.f33794c;
            if (!z16) {
                systemWindowInsetLeft = systemWindowInsetRight;
            }
            eVar.f33794c = i17 + systemWindowInsetLeft;
            eVar.a(view);
            return windowInsetsCompat;
        }
    }

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface b extends NavigationBarView.b {
    }

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes2.dex */
    public interface c extends NavigationBarView.c {
    }

    public BottomNavigationView(@NonNull Context context) {
        this(context, null);
    }

    private void k(@NonNull Context context) {
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor(context, R.color.bgs));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.c8e)));
        addView(view);
    }

    private void l() {
        ViewUtils.b(this, new a());
    }

    private int m(int i3) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i3) != 1073741824 && suggestedMinimumHeight > 0) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), suggestedMinimumHeight + getPaddingTop() + getPaddingBottom()), 1073741824);
        }
        return i3;
    }

    private boolean n() {
        return false;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected NavigationBarMenuView d(@NonNull Context context) {
        return new BottomNavigationMenuView(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int e() {
        return 5;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, m(i16));
    }

    public void setItemHorizontalTranslationEnabled(boolean z16) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) h();
        if (bottomNavigationMenuView.v() != z16) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z16);
            i().updateMenuView(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable b bVar) {
        setOnItemReselectedListener(bVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable c cVar) {
        setOnItemSelectedListener(cVar);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.a2s);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, R.style.aly);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Context context2 = getContext();
        TintTypedArray i17 = o.i(context2, attributeSet, w0.a.f443949m0, i3, i16, new int[0]);
        setItemHorizontalTranslationEnabled(i17.getBoolean(w0.a.f443971o0, true));
        int i18 = w0.a.f443960n0;
        if (i17.hasValue(i18)) {
            setMinimumHeight(i17.getDimensionPixelSize(i18, 0));
        }
        i17.recycle();
        if (n()) {
            k(context2);
        }
        l();
    }
}
