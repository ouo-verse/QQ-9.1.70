package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import com.tencent.sqshow.zootopia.nativeui.view.title.PortalStorePanelThirdTitleView;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.ZootopiaPullRefreshLayoutV2;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bs implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418906a;

    /* renamed from: b, reason: collision with root package name */
    public final AvatarPanelErrorView f418907b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f418908c;

    /* renamed from: d, reason: collision with root package name */
    public final NativePanelLoadingIgv f418909d;

    /* renamed from: e, reason: collision with root package name */
    public final ZootopiaPullRefreshLayoutV2 f418910e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f418911f;

    /* renamed from: g, reason: collision with root package name */
    public final HorizontalScrollView f418912g;

    /* renamed from: h, reason: collision with root package name */
    public final PortalStorePanelThirdTitleView f418913h;

    bs(View view, AvatarPanelErrorView avatarPanelErrorView, FrameLayout frameLayout, NativePanelLoadingIgv nativePanelLoadingIgv, ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV2, ImageView imageView, HorizontalScrollView horizontalScrollView, PortalStorePanelThirdTitleView portalStorePanelThirdTitleView) {
        this.f418906a = view;
        this.f418907b = avatarPanelErrorView;
        this.f418908c = frameLayout;
        this.f418909d = nativePanelLoadingIgv;
        this.f418910e = zootopiaPullRefreshLayoutV2;
        this.f418911f = imageView;
        this.f418912g = horizontalScrollView;
        this.f418913h = portalStorePanelThirdTitleView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418906a;
    }

    public static bs e(View view) {
        int i3 = R.id.psq;
        AvatarPanelErrorView avatarPanelErrorView = (AvatarPanelErrorView) ViewBindings.findChildViewById(view, R.id.psq);
        if (avatarPanelErrorView != null) {
            i3 = R.id.f163448q61;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f163448q61);
            if (frameLayout != null) {
                i3 = R.id.q6m;
                NativePanelLoadingIgv nativePanelLoadingIgv = (NativePanelLoadingIgv) ViewBindings.findChildViewById(view, R.id.q6m);
                if (nativePanelLoadingIgv != null) {
                    i3 = R.id.qgo;
                    ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV2 = (ZootopiaPullRefreshLayoutV2) ViewBindings.findChildViewById(view, R.id.qgo);
                    if (zootopiaPullRefreshLayoutV2 != null) {
                        i3 = R.id.qks;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.qks);
                        if (imageView != null) {
                            i3 = R.id.qqq;
                            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, R.id.qqq);
                            if (horizontalScrollView != null) {
                                i3 = R.id.qqr;
                                PortalStorePanelThirdTitleView portalStorePanelThirdTitleView = (PortalStorePanelThirdTitleView) ViewBindings.findChildViewById(view, R.id.qqr);
                                if (portalStorePanelThirdTitleView != null) {
                                    return new bs(view, avatarPanelErrorView, frameLayout, nativePanelLoadingIgv, zootopiaPullRefreshLayoutV2, imageView, horizontalScrollView, portalStorePanelThirdTitleView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bs f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.f167453de2, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
