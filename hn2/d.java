package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f405345a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final URLImageView f405346b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f405347c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f405348d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f405349e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f405350f;

    d(@NonNull FrameLayout frameLayout, @NonNull URLImageView uRLImageView, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3) {
        this.f405345a = frameLayout;
        this.f405346b = uRLImageView;
        this.f405347c = relativeLayout;
        this.f405348d = imageView;
        this.f405349e = imageView2;
        this.f405350f = imageView3;
    }

    @NonNull
    public static d e(@NonNull View view) {
        int i3 = R.id.xip;
        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.xip);
        if (uRLImageView != null) {
            i3 = R.id.yep;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.yep);
            if (relativeLayout != null) {
                i3 = R.id.e98;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.e98);
                if (imageView != null) {
                    i3 = R.id.iob;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iob);
                    if (imageView2 != null) {
                        i3 = R.id.f114186sn;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f114186sn);
                        if (imageView3 != null) {
                            return new d((FrameLayout) view, uRLImageView, relativeLayout, imageView, imageView2, imageView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static d g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static d h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167577dt4, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f405345a;
    }
}
