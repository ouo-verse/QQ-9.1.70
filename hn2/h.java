package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.widget.ThemeImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f405369a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f405370b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUIButton f405371c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405372d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ThemeImageView f405373e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f405374f;

    h(@NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout, @NonNull QUIButton qUIButton, @NonNull TextView textView, @NonNull ThemeImageView themeImageView, @NonNull TextView textView2) {
        this.f405369a = relativeLayout;
        this.f405370b = frameLayout;
        this.f405371c = qUIButton;
        this.f405372d = textView;
        this.f405373e = themeImageView;
        this.f405374f = textView2;
    }

    @NonNull
    public static h e(@NonNull View view) {
        int i3 = R.id.f164007sd0;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f164007sd0);
        if (frameLayout != null) {
            i3 = R.id.f164010gx;
            QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.f164010gx);
            if (qUIButton != null) {
                i3 = R.id.sdt;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.sdt);
                if (textView != null) {
                    i3 = R.id.f101945wk;
                    ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, R.id.f101945wk);
                    if (themeImageView != null) {
                        i3 = R.id.k0i;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.k0i);
                        if (textView2 != null) {
                            return new h((RelativeLayout) view, frameLayout, qUIButton, textView, themeImageView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static h g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hnr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f405369a;
    }
}
