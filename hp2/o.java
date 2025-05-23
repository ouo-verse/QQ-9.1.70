package hp2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class o implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405702a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f405703b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f405704c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f405705d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f405706e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f405707f;

    o(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f405702a = constraintLayout;
        this.f405703b = view;
        this.f405704c = imageView;
        this.f405705d = imageView2;
        this.f405706e = textView;
        this.f405707f = textView2;
    }

    @NonNull
    public static o e(@NonNull View view) {
        int i3 = R.id.vs7;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.vs7);
        if (findChildViewById != null) {
            i3 = R.id.f165909du3;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f165909du3);
            if (imageView != null) {
                i3 = R.id.y9v;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.y9v);
                if (imageView2 != null) {
                    i3 = R.id.k6s;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.k6s);
                    if (textView != null) {
                        i3 = R.id.kbs;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.kbs);
                        if (textView2 != null) {
                            return new o((ConstraintLayout) view, findChildViewById, imageView, imageView2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405702a;
    }
}
