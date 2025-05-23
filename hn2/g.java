package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.RoundImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f405361a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f405362b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RoundImageView f405363c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RoundImageView f405364d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405365e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405366f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f405367g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405368h;

    g(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull RoundImageView roundImageView, @NonNull RoundImageView roundImageView2, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout4) {
        this.f405361a = linearLayout;
        this.f405362b = imageView;
        this.f405363c = roundImageView;
        this.f405364d = roundImageView2;
        this.f405365e = linearLayout2;
        this.f405366f = linearLayout3;
        this.f405367g = imageView2;
        this.f405368h = linearLayout4;
    }

    @NonNull
    public static g e(@NonNull View view) {
        int i3 = R.id.uza;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.uza);
        if (imageView != null) {
            i3 = R.id.xhq;
            RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.xhq);
            if (roundImageView != null) {
                i3 = R.id.xsm;
                RoundImageView roundImageView2 = (RoundImageView) ViewBindings.findChildViewById(view, R.id.xsm);
                if (roundImageView2 != null) {
                    i3 = R.id.yro;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.yro);
                    if (linearLayout != null) {
                        i3 = R.id.ys5;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ys5);
                        if (linearLayout2 != null) {
                            i3 = R.id.ys6;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ys6);
                            if (imageView2 != null) {
                                i3 = R.id.ef6;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ef6);
                                if (linearLayout3 != null) {
                                    return new g((LinearLayout) view, imageView, roundImageView, roundImageView2, linearLayout, linearLayout2, imageView2, linearLayout3);
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
    public static g g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static g h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dtb, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f405361a;
    }
}
