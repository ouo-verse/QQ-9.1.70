package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405353a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f405354b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f405355c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QQBlurViewWrapper f405356d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RoundImageView f405357e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RoundImageView f405358f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f405359g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f405360h;

    f(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull QQBlurViewWrapper qQBlurViewWrapper, @NonNull RoundImageView roundImageView, @NonNull RoundImageView roundImageView2, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView2) {
        this.f405353a = constraintLayout;
        this.f405354b = textView;
        this.f405355c = relativeLayout;
        this.f405356d = qQBlurViewWrapper;
        this.f405357e = roundImageView;
        this.f405358f = roundImageView2;
        this.f405359g = relativeLayout2;
        this.f405360h = textView2;
    }

    @NonNull
    public static f e(@NonNull View view) {
        int i3 = R.id.thq;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.thq);
        if (textView != null) {
            i3 = R.id.thr;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.thr);
            if (relativeLayout != null) {
                i3 = R.id.ths;
                QQBlurViewWrapper qQBlurViewWrapper = (QQBlurViewWrapper) ViewBindings.findChildViewById(view, R.id.ths);
                if (qQBlurViewWrapper != null) {
                    i3 = R.id.f165861dq1;
                    RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.f165861dq1);
                    if (roundImageView != null) {
                        i3 = R.id.f165867xw3;
                        RoundImageView roundImageView2 = (RoundImageView) ViewBindings.findChildViewById(view, R.id.f165867xw3);
                        if (roundImageView2 != null) {
                            i3 = R.id.drj;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.drj);
                            if (relativeLayout2 != null) {
                                i3 = R.id.title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                                if (textView2 != null) {
                                    return new f((ConstraintLayout) view, textView, relativeLayout, qQBlurViewWrapper, roundImageView, roundImageView2, relativeLayout2, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static f g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dt_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405353a;
    }
}
