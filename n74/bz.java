package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.nativeui.view.history.PortalStoreHistoryControllerView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bz implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418950a;

    /* renamed from: b, reason: collision with root package name */
    public final PortalStoreHistoryControllerView f418951b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f418952c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f418953d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f418954e;

    /* renamed from: f, reason: collision with root package name */
    public final RelativeLayout f418955f;

    bz(View view, PortalStoreHistoryControllerView portalStoreHistoryControllerView, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout) {
        this.f418950a = view;
        this.f418951b = portalStoreHistoryControllerView;
        this.f418952c = linearLayout;
        this.f418953d = imageView;
        this.f418954e = imageView2;
        this.f418955f = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418950a;
    }

    public static bz e(View view) {
        int i3 = R.id.pzo;
        PortalStoreHistoryControllerView portalStoreHistoryControllerView = (PortalStoreHistoryControllerView) ViewBindings.findChildViewById(view, R.id.pzo);
        if (portalStoreHistoryControllerView != null) {
            i3 = R.id.qoz;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qoz);
            if (linearLayout != null) {
                i3 = R.id.f163542qp0;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163542qp0);
                if (imageView != null) {
                    i3 = R.id.f163543qp1;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163543qp1);
                    if (imageView2 != null) {
                        i3 = R.id.f163544qp2;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163544qp2);
                        if (relativeLayout != null) {
                            return new bz(view, portalStoreHistoryControllerView, linearLayout, imageView, imageView2, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bz f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.de8, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
