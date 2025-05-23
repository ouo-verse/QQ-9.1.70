package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class bh implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final HorizontalScrollView f421033a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f421034b;

    bh(@NonNull HorizontalScrollView horizontalScrollView, @NonNull LinearLayout linearLayout) {
        this.f421033a = horizontalScrollView;
        this.f421034b = linearLayout;
    }

    @NonNull
    public static bh e(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.u7v);
        if (linearLayout != null) {
            return new bh((HorizontalScrollView) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.u7v)));
    }

    @NonNull
    public static bh g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hxw, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public HorizontalScrollView getRoot() {
        return this.f421033a;
    }
}
