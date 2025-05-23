package hp2;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class k implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405676a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405677b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405678c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405679d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405680e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405681f;

    k(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageFilterView imageFilterView, @NonNull ImageFilterView imageFilterView2, @NonNull ImageFilterView imageFilterView3, @NonNull ImageFilterView imageFilterView4) {
        this.f405676a = constraintLayout;
        this.f405677b = constraintLayout2;
        this.f405678c = imageFilterView;
        this.f405679d = imageFilterView2;
        this.f405680e = imageFilterView3;
        this.f405681f = imageFilterView4;
    }

    @NonNull
    public static k e(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i3 = R.id.f25270ad;
        ImageFilterView imageFilterView = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f25270ad);
        if (imageFilterView != null) {
            i3 = R.id.f25280ae;
            ImageFilterView imageFilterView2 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f25280ae);
            if (imageFilterView2 != null) {
                i3 = R.id.f25290af;
                ImageFilterView imageFilterView3 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f25290af);
                if (imageFilterView3 != null) {
                    i3 = R.id.f25300ag;
                    ImageFilterView imageFilterView4 = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.f25300ag);
                    if (imageFilterView4 != null) {
                        return new k(constraintLayout, constraintLayout, imageFilterView, imageFilterView2, imageFilterView3, imageFilterView4);
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
        return this.f405676a;
    }
}
