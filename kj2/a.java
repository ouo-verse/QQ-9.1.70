package kj2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f412556a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f412557b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f412558c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f412559d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f412560e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f412561f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final URLImageView f412562g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f412563h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f412564i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f412565j;

    a(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout, @NonNull URLImageView uRLImageView, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull FrameLayout frameLayout2) {
        this.f412556a = relativeLayout;
        this.f412557b = imageView;
        this.f412558c = imageView2;
        this.f412559d = frameLayout;
        this.f412560e = relativeLayout2;
        this.f412561f = linearLayout;
        this.f412562g = uRLImageView;
        this.f412563h = linearLayout2;
        this.f412564i = linearLayout3;
        this.f412565j = frameLayout2;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.t2f;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.t2f);
        if (imageView != null) {
            i3 = R.id.t2g;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.t2g);
            if (imageView2 != null) {
                i3 = R.id.lae;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.lae);
                if (frameLayout != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i3 = R.id.f165004uk3;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f165004uk3);
                    if (linearLayout != null) {
                        i3 = R.id.f27040f6;
                        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.f27040f6);
                        if (uRLImageView != null) {
                            i3 = R.id.f793549j;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f793549j);
                            if (linearLayout2 != null) {
                                i3 = R.id.f83074il;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f83074il);
                                if (linearLayout3 != null) {
                                    i3 = R.id.f99475pw;
                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f99475pw);
                                    if (frameLayout2 != null) {
                                        return new a(relativeLayout, imageView, imageView2, frameLayout, relativeLayout, linearLayout, uRLImageView, linearLayout2, linearLayout3, frameLayout2);
                                    }
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
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.i8w, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f412556a;
    }
}
