package hp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ag implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f405560a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f405561b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f405562c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QQProAvatarView f405563d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f405564e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f405565f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f405566g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f405567h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f405568i;

    ag(@NonNull View view, @NonNull TextView textView, @NonNull View view2, @NonNull QQProAvatarView qQProAvatarView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f405560a = view;
        this.f405561b = textView;
        this.f405562c = view2;
        this.f405563d = qQProAvatarView;
        this.f405564e = imageView;
        this.f405565f = textView2;
        this.f405566g = textView3;
        this.f405567h = textView4;
        this.f405568i = textView5;
    }

    @NonNull
    public static ag e(@NonNull View view) {
        int i3 = R.id.toj;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.toj);
        if (textView != null) {
            i3 = R.id.vs7;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.vs7);
            if (findChildViewById != null) {
                i3 = R.id.f165909du3;
                QQProAvatarView qQProAvatarView = (QQProAvatarView) ViewBindings.findChildViewById(view, R.id.f165909du3);
                if (qQProAvatarView != null) {
                    i3 = R.id.y9v;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.y9v);
                    if (imageView != null) {
                        i3 = R.id.f906052x;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f906052x);
                        if (textView2 != null) {
                            i3 = R.id.k5h;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.k5h);
                            if (textView3 != null) {
                                i3 = R.id.k6s;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.k6s);
                                if (textView4 != null) {
                                    i3 = R.id.kbs;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.kbs);
                                    if (textView5 != null) {
                                        return new ag(view, textView, findChildViewById, qQProAvatarView, imageView, textView2, textView3, textView4, textView5);
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
    public static ag f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.h3a, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: getRoot */
    public View getMRv() {
        return this.f405560a;
    }
}
