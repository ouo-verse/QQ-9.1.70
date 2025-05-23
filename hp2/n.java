package hp2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class n implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f405698a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405699b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405700c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f405701d;

    n(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageFilterView imageFilterView, @NonNull TextView textView) {
        this.f405698a = linearLayout;
        this.f405699b = linearLayout2;
        this.f405700c = imageFilterView;
        this.f405701d = textView;
    }

    @NonNull
    public static n e(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.zp9;
        ImageFilterView imageFilterView = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.zp9);
        if (imageFilterView != null) {
            i3 = R.id.zp_;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.zp_);
            if (textView != null) {
                return new n(linearLayout, linearLayout, imageFilterView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f405698a;
    }
}
