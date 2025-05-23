package n74;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bh implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f418834a;

    /* renamed from: b, reason: collision with root package name */
    public final RoundCornerImageView f418835b;

    /* renamed from: c, reason: collision with root package name */
    public final RoundCornerImageView f418836c;

    /* renamed from: d, reason: collision with root package name */
    public final RoundCornerImageView f418837d;

    bh(FrameLayout frameLayout, RoundCornerImageView roundCornerImageView, RoundCornerImageView roundCornerImageView2, RoundCornerImageView roundCornerImageView3) {
        this.f418834a = frameLayout;
        this.f418835b = roundCornerImageView;
        this.f418836c = roundCornerImageView2;
        this.f418837d = roundCornerImageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f418834a;
    }

    public static bh e(View view) {
        int i3 = R.id.pxl;
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.pxl);
        if (roundCornerImageView != null) {
            i3 = R.id.pxm;
            RoundCornerImageView roundCornerImageView2 = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.pxm);
            if (roundCornerImageView2 != null) {
                i3 = R.id.pxp;
                RoundCornerImageView roundCornerImageView3 = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.pxp);
                if (roundCornerImageView3 != null) {
                    return new bh((FrameLayout) view, roundCornerImageView, roundCornerImageView2, roundCornerImageView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
