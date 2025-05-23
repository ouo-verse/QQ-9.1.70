package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.nativeui.view.entrance.PortalStoreFilterEntranceView;
import com.tencent.sqshow.zootopia.nativeui.view.title.PortalStorePanelSectionView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bx implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418945a;

    /* renamed from: b, reason: collision with root package name */
    public final PortalStoreFilterEntranceView f418946b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewPager f418947c;

    /* renamed from: d, reason: collision with root package name */
    public final HorizontalScrollView f418948d;

    /* renamed from: e, reason: collision with root package name */
    public final PortalStorePanelSectionView f418949e;

    bx(View view, PortalStoreFilterEntranceView portalStoreFilterEntranceView, ViewPager viewPager, HorizontalScrollView horizontalScrollView, PortalStorePanelSectionView portalStorePanelSectionView) {
        this.f418945a = view;
        this.f418946b = portalStoreFilterEntranceView;
        this.f418947c = viewPager;
        this.f418948d = horizontalScrollView;
        this.f418949e = portalStorePanelSectionView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418945a;
    }

    public static bx e(View view) {
        int i3 = R.id.f163382pu1;
        PortalStoreFilterEntranceView portalStoreFilterEntranceView = (PortalStoreFilterEntranceView) ViewBindings.findChildViewById(view, R.id.f163382pu1);
        if (portalStoreFilterEntranceView != null) {
            i3 = R.id.qbj;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.qbj);
            if (viewPager != null) {
                i3 = R.id.qjm;
                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, R.id.qjm);
                if (horizontalScrollView != null) {
                    i3 = R.id.qjn;
                    PortalStorePanelSectionView portalStorePanelSectionView = (PortalStorePanelSectionView) ViewBindings.findChildViewById(view, R.id.qjn);
                    if (portalStorePanelSectionView != null) {
                        return new bx(view, portalStoreFilterEntranceView, viewPager, horizontalScrollView, portalStorePanelSectionView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bx f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.de7, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
