package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.nativeui.view.history.AvatarHistoryControlView;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ah implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418612a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f418613b;

    /* renamed from: c, reason: collision with root package name */
    public final ZPlanRedDotView f418614c;

    /* renamed from: d, reason: collision with root package name */
    public final AvatarHistoryControlView f418615d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f418616e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f418617f;

    /* renamed from: g, reason: collision with root package name */
    public final NativePanelLoadingIgv f418618g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f418619h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f418620i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f418621j;

    /* renamed from: k, reason: collision with root package name */
    public final RelativeLayout f418622k;

    /* renamed from: l, reason: collision with root package name */
    public final FrameLayout f418623l;

    ah(View view, ImageView imageView, ZPlanRedDotView zPlanRedDotView, AvatarHistoryControlView avatarHistoryControlView, ImageView imageView2, LinearLayout linearLayout, NativePanelLoadingIgv nativePanelLoadingIgv, ImageView imageView3, ImageView imageView4, ImageView imageView5, RelativeLayout relativeLayout, FrameLayout frameLayout) {
        this.f418612a = view;
        this.f418613b = imageView;
        this.f418614c = zPlanRedDotView;
        this.f418615d = avatarHistoryControlView;
        this.f418616e = imageView2;
        this.f418617f = linearLayout;
        this.f418618g = nativePanelLoadingIgv;
        this.f418619h = imageView3;
        this.f418620i = imageView4;
        this.f418621j = imageView5;
        this.f418622k = relativeLayout;
        this.f418623l = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418612a;
    }

    public static ah e(View view) {
        int i3 = R.id.p_e;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.p_e);
        if (imageView != null) {
            i3 = R.id.pwq;
            ZPlanRedDotView zPlanRedDotView = (ZPlanRedDotView) ViewBindings.findChildViewById(view, R.id.pwq);
            if (zPlanRedDotView != null) {
                i3 = R.id.pzo;
                AvatarHistoryControlView avatarHistoryControlView = (AvatarHistoryControlView) ViewBindings.findChildViewById(view, R.id.pzo);
                if (avatarHistoryControlView != null) {
                    i3 = R.id.q2v;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.q2v);
                    if (imageView2 != null) {
                        i3 = R.id.q4m;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.q4m);
                        if (linearLayout != null) {
                            i3 = R.id.q65;
                            NativePanelLoadingIgv nativePanelLoadingIgv = (NativePanelLoadingIgv) ViewBindings.findChildViewById(view, R.id.q65);
                            if (nativePanelLoadingIgv != null) {
                                i3 = R.id.q7h;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.q7h);
                                if (imageView3 != null) {
                                    i3 = R.id.f163542qp0;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163542qp0);
                                    if (imageView4 != null) {
                                        i3 = R.id.f163543qp1;
                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.f163543qp1);
                                        if (imageView5 != null) {
                                            i3 = R.id.f163544qp2;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163544qp2);
                                            if (relativeLayout != null) {
                                                i3 = R.id.f163545qp3;
                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f163545qp3);
                                                if (frameLayout != null) {
                                                    return new ah(view, imageView, zPlanRedDotView, avatarHistoryControlView, imageView2, linearLayout, nativePanelLoadingIgv, imageView3, imageView4, imageView5, relativeLayout, frameLayout);
                                                }
                                            }
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

    public static ah f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f167435da4, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
