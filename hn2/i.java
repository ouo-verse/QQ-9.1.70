package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f405375a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUIButton f405376b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ThemeImageView f405377c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405378d;

    i(@NonNull RelativeLayout relativeLayout, @NonNull QUIButton qUIButton, @NonNull ThemeImageView themeImageView, @NonNull TextView textView) {
        this.f405375a = relativeLayout;
        this.f405376b = qUIButton;
        this.f405377c = themeImageView;
        this.f405378d = textView;
    }

    @NonNull
    public static i e(@NonNull View view) {
        int i3 = R.id.f166866ir0;
        QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.f166866ir0);
        if (qUIButton != null) {
            i3 = R.id.f101945wk;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, R.id.f101945wk);
            if (themeImageView != null) {
                i3 = R.id.k0i;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.k0i);
                if (textView != null) {
                    return new i((RelativeLayout) view, qUIButton, themeImageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static i g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hns, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f405375a;
    }
}
