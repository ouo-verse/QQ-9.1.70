package n74;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.recommend.main.dress.ui.detail.DressSquareDetailDesView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class az implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f418777a;

    /* renamed from: b, reason: collision with root package name */
    public final DressSquareDetailDesView f418778b;

    az(RelativeLayout relativeLayout, DressSquareDetailDesView dressSquareDetailDesView) {
        this.f418777a = relativeLayout;
        this.f418778b = dressSquareDetailDesView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f418777a;
    }

    public static az e(View view) {
        DressSquareDetailDesView dressSquareDetailDesView = (DressSquareDetailDesView) ViewBindings.findChildViewById(view, R.id.pou);
        if (dressSquareDetailDesView != null) {
            return new az((RelativeLayout) view, dressSquareDetailDesView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.pou)));
    }
}
