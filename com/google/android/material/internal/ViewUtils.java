package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class ViewUtils {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f33786a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f33787b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f33788c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f33789d;

        a(boolean z16, boolean z17, boolean z18, d dVar) {
            this.f33786a = z16;
            this.f33787b = z17;
            this.f33788c = z18;
            this.f33789d = dVar;
        }

        @Override // com.google.android.material.internal.ViewUtils.d
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull e eVar) {
            if (this.f33786a) {
                eVar.f33795d += windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean i3 = ViewUtils.i(view);
            if (this.f33787b) {
                if (i3) {
                    eVar.f33794c += windowInsetsCompat.getSystemWindowInsetLeft();
                } else {
                    eVar.f33792a += windowInsetsCompat.getSystemWindowInsetLeft();
                }
            }
            if (this.f33788c) {
                if (i3) {
                    eVar.f33792a += windowInsetsCompat.getSystemWindowInsetRight();
                } else {
                    eVar.f33794c += windowInsetsCompat.getSystemWindowInsetRight();
                }
            }
            eVar.a(view);
            d dVar = this.f33789d;
            if (dVar != null) {
                return dVar.a(view, windowInsetsCompat, eVar);
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements OnApplyWindowInsetsListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f33790d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f33791e;

        b(d dVar, e eVar) {
            this.f33790d = dVar;
            this.f33791e = eVar;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return this.f33790d.a(view, windowInsetsCompat, new e(this.f33791e));
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface d {
        WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, e eVar);
    }

    public static void a(@NonNull View view, @Nullable AttributeSet attributeSet, int i3, int i16, @Nullable d dVar) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, w0.a.f444080x3, i3, i16);
        boolean z16 = obtainStyledAttributes.getBoolean(w0.a.f444092y3, false);
        boolean z17 = obtainStyledAttributes.getBoolean(w0.a.f444104z3, false);
        boolean z18 = obtainStyledAttributes.getBoolean(w0.a.A3, false);
        obtainStyledAttributes.recycle();
        b(view, new a(z16, z17, z18, dVar));
    }

    public static void b(@NonNull View view, @NonNull d dVar) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new b(dVar, new e(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom())));
        k(view);
    }

    public static float c(@NonNull Context context, @Dimension(unit = 0) int i3) {
        return TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
    }

    @Nullable
    public static Integer d(@NonNull View view) {
        if (view.getBackground() instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) view.getBackground()).getColor());
        }
        return null;
    }

    @Nullable
    public static ViewGroup e(@Nullable View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    @Nullable
    public static r f(@NonNull View view) {
        return g(e(view));
    }

    @Nullable
    public static r g(@Nullable View view) {
        if (view == null) {
            return null;
        }
        return new q(view);
    }

    public static float h(@NonNull View view) {
        float f16 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f16 += ViewCompat.getElevation((View) parent);
        }
        return f16;
    }

    public static boolean i(View view) {
        if (ViewCompat.getLayoutDirection(view) == 1) {
            return true;
        }
        return false;
    }

    public static PorterDuff.Mode j(int i3, PorterDuff.Mode mode) {
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 != 9) {
                    switch (i3) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public static void k(@NonNull View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new c());
        }
    }

    public static void l(@NonNull final View view) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.ViewUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(view, 1);
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f33792a;

        /* renamed from: b, reason: collision with root package name */
        public int f33793b;

        /* renamed from: c, reason: collision with root package name */
        public int f33794c;

        /* renamed from: d, reason: collision with root package name */
        public int f33795d;

        public e(int i3, int i16, int i17, int i18) {
            this.f33792a = i3;
            this.f33793b = i16;
            this.f33794c = i17;
            this.f33795d = i18;
        }

        public void a(View view) {
            ViewCompat.setPaddingRelative(view, this.f33792a, this.f33793b, this.f33794c, this.f33795d);
        }

        public e(@NonNull e eVar) {
            this.f33792a = eVar.f33792a;
            this.f33793b = eVar.f33793b;
            this.f33794c = eVar.f33794c;
            this.f33795d = eVar.f33795d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            view.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
