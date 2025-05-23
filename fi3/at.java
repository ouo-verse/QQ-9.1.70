package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class at implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f398934a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f398935b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f398936c;

    /* renamed from: d, reason: collision with root package name */
    public final QUIButton f398937d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f398938e;

    at(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, QUIButton qUIButton, TextView textView2) {
        this.f398934a = constraintLayout;
        this.f398935b = textView;
        this.f398936c = imageView;
        this.f398937d = qUIButton;
        this.f398938e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f398934a;
    }

    public static at g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static at e(View view) {
        int i3 = R.id.py6;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.py6);
        if (textView != null) {
            i3 = R.id.py7;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.py7);
            if (imageView != null) {
                i3 = R.id.py8;
                QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.py8);
                if (qUIButton != null) {
                    i3 = R.id.py9;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.py9);
                    if (textView2 != null) {
                        return new at((ConstraintLayout) view, textView, imageView, qUIButton, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static at h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167438db2, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
