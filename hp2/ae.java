package hp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.view.QSearchShowHighlightTextView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ae implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405545a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f405546b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f405547c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405548d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final View f405549e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405550f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f405551g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final QSearchShowHighlightTextView f405552h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final Guideline f405553i;

    ae(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull ConstraintLayout constraintLayout2, @NonNull View view2, @NonNull ConstraintLayout constraintLayout3, @NonNull TextView textView, @NonNull QSearchShowHighlightTextView qSearchShowHighlightTextView, @NonNull Guideline guideline) {
        this.f405545a = constraintLayout;
        this.f405546b = imageView;
        this.f405547c = view;
        this.f405548d = constraintLayout2;
        this.f405549e = view2;
        this.f405550f = constraintLayout3;
        this.f405551g = textView;
        this.f405552h = qSearchShowHighlightTextView;
        this.f405553i = guideline;
    }

    @NonNull
    public static ae e(@NonNull View view) {
        int i3 = R.id.f164472yw;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f164472yw);
        if (imageView != null) {
            i3 = R.id.acn;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.acn);
            if (findChildViewById != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i3 = R.id.bmt;
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.bmt);
                if (findChildViewById2 != null) {
                    i3 = R.id.f165675d35;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.f165675d35);
                    if (constraintLayout2 != null) {
                        i3 = R.id.ezq;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ezq);
                        if (textView != null) {
                            i3 = R.id.title;
                            QSearchShowHighlightTextView qSearchShowHighlightTextView = (QSearchShowHighlightTextView) ViewBindings.findChildViewById(view, R.id.title);
                            if (qSearchShowHighlightTextView != null) {
                                i3 = R.id.jsv;
                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.jsv);
                                if (guideline != null) {
                                    return new ae(constraintLayout, imageView, findChildViewById, constraintLayout, findChildViewById2, constraintLayout2, textView, qSearchShowHighlightTextView, guideline);
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
    public static ae g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.h38, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405545a;
    }
}
