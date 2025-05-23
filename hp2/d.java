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
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405635a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f405636b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f405637c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405638d;

    d(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f405635a = constraintLayout;
        this.f405636b = view;
        this.f405637c = imageView;
        this.f405638d = textView;
    }

    @NonNull
    public static d e(@NonNull View view) {
        int i3 = R.id.uj8;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.uj8);
        if (findChildViewById != null) {
            i3 = R.id.y1f;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.y1f);
            if (imageView != null) {
                i3 = R.id.f1068769w;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f1068769w);
                if (textView != null) {
                    return new d((ConstraintLayout) view, findChildViewById, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405635a;
    }
}
