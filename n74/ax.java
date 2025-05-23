package n74;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.player.ZPlanPlayerWithPreLoadView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ax implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f418765a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f418766b;

    /* renamed from: c, reason: collision with root package name */
    public final ZPlanPlayerWithPreLoadView f418767c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f418768d;

    ax(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView, ImageView imageView) {
        this.f418765a = relativeLayout;
        this.f418766b = relativeLayout2;
        this.f418767c = zPlanPlayerWithPreLoadView;
        this.f418768d = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f418765a;
    }

    public static ax e(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i3 = R.id.qd5;
        ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView = (ZPlanPlayerWithPreLoadView) ViewBindings.findChildViewById(view, R.id.qd5);
        if (zPlanPlayerWithPreLoadView != null) {
            i3 = R.id.qno;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.qno);
            if (imageView != null) {
                return new ax(relativeLayout, relativeLayout, zPlanPlayerWithPreLoadView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }
}
