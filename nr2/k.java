package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class k implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421081a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f421082b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f421083c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f421084d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f421085e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f421086f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f421087g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f421088h;

    k(@NonNull View view, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5) {
        this.f421081a = view;
        this.f421082b = frameLayout;
        this.f421083c = imageView;
        this.f421084d = textView;
        this.f421085e = imageView2;
        this.f421086f = imageView3;
        this.f421087g = imageView4;
        this.f421088h = imageView5;
    }

    @NonNull
    public static k e(@NonNull View view) {
        int i3 = R.id.f164636ta4;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f164636ta4);
        if (frameLayout != null) {
            i3 = R.id.up_;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.up_);
            if (imageView != null) {
                i3 = R.id.xoe;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.xoe);
                if (textView != null) {
                    i3 = R.id.f166251z62;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f166251z62);
                    if (imageView2 != null) {
                        i3 = R.id.zds;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.zds);
                        if (imageView3 != null) {
                            i3 = R.id.f27550gj;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f27550gj);
                            if (imageView4 != null) {
                                i3 = R.id.f100965tx;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.f100965tx);
                                if (imageView5 != null) {
                                    return new k(view, frameLayout, imageView, textView, imageView2, imageView3, imageView4, imageView5);
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
    public static k f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.ht5, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f421081a;
    }
}
