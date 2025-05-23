package hp2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405655a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405656b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f405657c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405658d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405659e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405660f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f405661g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f405662h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405663i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f405664j;

    g(@NonNull ConstraintLayout constraintLayout, @NonNull ImageFilterView imageFilterView, @NonNull View view, @NonNull TextView textView, @NonNull ImageFilterView imageFilterView2, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull View view2) {
        this.f405655a = constraintLayout;
        this.f405656b = imageFilterView;
        this.f405657c = view;
        this.f405658d = textView;
        this.f405659e = imageFilterView2;
        this.f405660f = constraintLayout2;
        this.f405661g = textView2;
        this.f405662h = textView3;
        this.f405663i = linearLayout;
        this.f405664j = view2;
    }

    @NonNull
    public static g e(@NonNull View view) {
        int i3 = R.id.t3u;
        ImageFilterView imageFilterView = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.t3u);
        if (imageFilterView != null) {
            i3 = R.id.t3y;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.t3y);
            if (findChildViewById != null) {
                i3 = R.id.f166391zp0;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f166391zp0);
                if (textView != null) {
                    i3 = R.id.f166392zp1;
                    ImageFilterView imageFilterView2 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f166392zp1);
                    if (imageFilterView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i3 = R.id.f166394zp3;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f166394zp3);
                        if (textView2 != null) {
                            i3 = R.id.zp5;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.zp5);
                            if (textView3 != null) {
                                i3 = R.id.f2143010;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f2143010);
                                if (linearLayout != null) {
                                    i3 = R.id.jta;
                                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.jta);
                                    if (findChildViewById2 != null) {
                                        return new g(constraintLayout, imageFilterView, findChildViewById, textView, imageFilterView2, constraintLayout, textView2, textView3, linearLayout, findChildViewById2);
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

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405655a;
    }
}
