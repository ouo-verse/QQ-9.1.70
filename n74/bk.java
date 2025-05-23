package n74;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bk implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f418848a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f418849b;

    /* renamed from: c, reason: collision with root package name */
    public final View f418850c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f418851d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f418852e;

    bk(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view, ImageView imageView, TextView textView) {
        this.f418848a = constraintLayout;
        this.f418849b = constraintLayout2;
        this.f418850c = view;
        this.f418851d = imageView;
        this.f418852e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f418848a;
    }

    public static bk e(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i3 = R.id.r3b;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.r3b);
        if (findChildViewById != null) {
            i3 = R.id.r6e;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.r6e);
            if (imageView != null) {
                i3 = R.id.r9a;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.r9a);
                if (textView != null) {
                    return new bk(constraintLayout, constraintLayout, findChildViewById, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
