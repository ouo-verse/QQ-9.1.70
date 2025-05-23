package ca1;

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
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.widget.AIOMsgTextView;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f30487a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RFWRoundImageView f30488b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f30489c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f30490d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f30491e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final AIOMsgTextView f30492f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f30493g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f30494h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f30495i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f30496j;

    b(@NonNull ConstraintLayout constraintLayout, @NonNull RFWRoundImageView rFWRoundImageView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull AIOMsgTextView aIOMsgTextView, @NonNull TextView textView, @NonNull View view, @NonNull View view2, @NonNull View view3) {
        this.f30487a = constraintLayout;
        this.f30488b = rFWRoundImageView;
        this.f30489c = imageView;
        this.f30490d = imageView2;
        this.f30491e = imageView3;
        this.f30492f = aIOMsgTextView;
        this.f30493g = textView;
        this.f30494h = view;
        this.f30495i = view2;
        this.f30496j = view3;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.f165909du3;
        RFWRoundImageView rFWRoundImageView = (RFWRoundImageView) ViewBindings.findChildViewById(view, R.id.f165909du3);
        if (rFWRoundImageView != null) {
            i3 = R.id.y0r;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.y0r);
            if (imageView != null) {
                i3 = R.id.y0u;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.y0u);
                if (imageView2 != null) {
                    i3 = R.id.y6z;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.y6z);
                    if (imageView3 != null) {
                        i3 = R.id.tv_summary;
                        AIOMsgTextView aIOMsgTextView = (AIOMsgTextView) ViewBindings.findChildViewById(view, R.id.tv_summary);
                        if (aIOMsgTextView != null) {
                            i3 = R.id.kbs;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.kbs);
                            if (textView != null) {
                                i3 = R.id.f1185874j;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.f1185874j);
                                if (findChildViewById != null) {
                                    i3 = R.id.f1186874t;
                                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f1186874t);
                                    if (findChildViewById2 != null) {
                                        i3 = R.id.kxi;
                                        View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.kxi);
                                        if (findChildViewById3 != null) {
                                            return new b((ConstraintLayout) view, rFWRoundImageView, imageView, imageView2, imageView3, aIOMsgTextView, textView, findChildViewById, findChildViewById2, findChildViewById3);
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
    public static b g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e16, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f30487a;
    }
}
