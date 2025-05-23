package hp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class z implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f405789a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f405790b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QQProAvatarView f405791c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405792d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f405793e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405794f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final ImageView f405795g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f405796h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f405797i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ImageView f405798j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f405799k;

    z(@NonNull View view, @NonNull TextView textView, @NonNull QQProAvatarView qQProAvatarView, @NonNull ImageFilterView imageFilterView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView4) {
        this.f405789a = view;
        this.f405790b = textView;
        this.f405791c = qQProAvatarView;
        this.f405792d = imageFilterView;
        this.f405793e = textView2;
        this.f405794f = linearLayout;
        this.f405795g = imageView;
        this.f405796h = textView3;
        this.f405797i = imageView2;
        this.f405798j = imageView3;
        this.f405799k = textView4;
    }

    @NonNull
    public static z e(@NonNull View view) {
        int i3 = R.id.f164665ai2;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f164665ai2);
        if (textView != null) {
            i3 = R.id.tnu;
            QQProAvatarView qQProAvatarView = (QQProAvatarView) ViewBindings.findChildViewById(view, R.id.tnu);
            if (qQProAvatarView != null) {
                i3 = R.id.tnv;
                ImageFilterView imageFilterView = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.tnv);
                if (imageFilterView != null) {
                    i3 = R.id.ar_;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.ar_);
                    if (textView2 != null) {
                        i3 = R.id.j65;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.j65);
                        if (linearLayout != null) {
                            i3 = R.id.f905852v;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f905852v);
                            if (imageView != null) {
                                i3 = R.id.f905952w;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f905952w);
                                if (textView3 != null) {
                                    i3 = R.id.f116086xs;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f116086xs);
                                    if (imageView2 != null) {
                                        i3 = R.id.f1199678_;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f1199678_);
                                        if (imageView3 != null) {
                                            i3 = R.id.f1199778a;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f1199778a);
                                            if (textView4 != null) {
                                                return new z(view, textView, qQProAvatarView, imageFilterView, textView2, linearLayout, imageView, textView3, imageView2, imageView3, textView4);
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
    public static z f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.h2r, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: getRoot */
    public View getMRv() {
        return this.f405789a;
    }
}
