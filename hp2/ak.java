package hp2;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.TopCropImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ak implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405595a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TopCropImageView f405596b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405597c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405598d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f405599e;

    ak(@NonNull ConstraintLayout constraintLayout, @NonNull TopCropImageView topCropImageView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f405595a = constraintLayout;
        this.f405596b = topCropImageView;
        this.f405597c = constraintLayout2;
        this.f405598d = textView;
        this.f405599e = textView2;
    }

    @NonNull
    public static ak e(@NonNull View view) {
        int i3 = R.id.y0r;
        TopCropImageView topCropImageView = (TopCropImageView) ViewBindings.findChildViewById(view, R.id.y0r);
        if (topCropImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i3 = R.id.f107866bk;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f107866bk);
            if (textView != null) {
                i3 = R.id.f112106n1;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f112106n1);
                if (textView2 != null) {
                    return new ak(constraintLayout, topCropImageView, constraintLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405595a;
    }
}
