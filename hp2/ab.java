package hp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ab implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405529a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f405530b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f405531c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405532d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final QUITagView f405533e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f405534f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f405535g;

    ab(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull QUITagView qUITagView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f405529a = constraintLayout;
        this.f405530b = view;
        this.f405531c = imageView;
        this.f405532d = textView;
        this.f405533e = qUITagView;
        this.f405534f = textView2;
        this.f405535g = textView3;
    }

    @NonNull
    public static ab e(@NonNull View view) {
        int i3 = R.id.bmt;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.bmt);
        if (findChildViewById != null) {
            i3 = R.id.y57;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.y57);
            if (imageView != null) {
                i3 = R.id.f107956bt;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f107956bt);
                if (textView != null) {
                    i3 = R.id.f107966bu;
                    QUITagView qUITagView = (QUITagView) ViewBindings.findChildViewById(view, R.id.f107966bu);
                    if (qUITagView != null) {
                        i3 = R.id.f107986bw;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f107986bw);
                        if (textView2 != null) {
                            i3 = R.id.f107996bx;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f107996bx);
                            if (textView3 != null) {
                                return new ab((ConstraintLayout) view, findChildViewById, imageView, textView, qUITagView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ab g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.h2z, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405529a;
    }
}
