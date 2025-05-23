package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ac implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f420773a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f420774b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f420775c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f420776d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420777e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f420778f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f420779g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f420780h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420781i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f420782j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f420783k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final FrameLayout f420784l;

    ac(@NonNull View view, @NonNull View view2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout2, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull FrameLayout frameLayout) {
        this.f420773a = view;
        this.f420774b = view2;
        this.f420775c = imageView;
        this.f420776d = imageView2;
        this.f420777e = linearLayout;
        this.f420778f = textView;
        this.f420779g = textView2;
        this.f420780h = textView3;
        this.f420781i = linearLayout2;
        this.f420782j = textView4;
        this.f420783k = textView5;
        this.f420784l = frameLayout;
    }

    @NonNull
    public static ac e(@NonNull View view) {
        int i3 = R.id.txv;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.txv);
        if (findChildViewById != null) {
            i3 = R.id.f164822az1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164822az1);
            if (imageView != null) {
                i3 = R.id.ymc;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ymc);
                if (imageView2 != null) {
                    i3 = R.id.yrp;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.yrp);
                    if (linearLayout != null) {
                        i3 = R.id.yrr;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.yrr);
                        if (textView != null) {
                            i3 = R.id.ef5;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ef5);
                            if (textView2 != null) {
                                i3 = R.id.i9b;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.i9b);
                                if (textView3 != null) {
                                    i3 = R.id.f114756u7;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f114756u7);
                                    if (linearLayout2 != null) {
                                        i3 = R.id.f114766u8;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f114766u8);
                                        if (textView4 != null) {
                                            i3 = R.id.f114776u9;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f114776u9);
                                            if (textView5 != null) {
                                                i3 = R.id.f1171470n;
                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f1171470n);
                                                if (frameLayout != null) {
                                                    return new ac(view, findChildViewById, imageView, imageView2, linearLayout, textView, textView2, textView3, linearLayout2, textView4, textView5, frameLayout);
                                                }
                                            }
                                        }
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
    public static ac f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.huq, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f420773a;
    }
}
