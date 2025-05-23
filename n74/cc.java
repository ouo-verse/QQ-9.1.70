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
import com.tencent.sqshow.zootopia.nativeui.view.entrance.PortalStoreColorEntranceView;
import com.tencent.sqshow.zootopia.nativeui.view.title.PortalStorePanelCategoryView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cc implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418973a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager f418974b;

    /* renamed from: c, reason: collision with root package name */
    public final PortalStorePanelCategoryView f418975c;

    /* renamed from: d, reason: collision with root package name */
    public final PortalStoreColorEntranceView f418976d;

    /* renamed from: e, reason: collision with root package name */
    public final HorizontalScrollView f418977e;

    cc(View view, ViewPager viewPager, PortalStorePanelCategoryView portalStorePanelCategoryView, PortalStoreColorEntranceView portalStoreColorEntranceView, HorizontalScrollView horizontalScrollView) {
        this.f418973a = view;
        this.f418974b = viewPager;
        this.f418975c = portalStorePanelCategoryView;
        this.f418976d = portalStoreColorEntranceView;
        this.f418977e = horizontalScrollView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: getRoot */
    public View getMContainer() {
        return this.f418973a;
    }

    public static cc e(View view) {
        int i3 = R.id.f163308pf2;
        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, R.id.f163308pf2);
        if (viewPager != null) {
            i3 = R.id.pip;
            PortalStorePanelCategoryView portalStorePanelCategoryView = (PortalStorePanelCategoryView) ViewBindings.findChildViewById(view, R.id.pip);
            if (portalStorePanelCategoryView != null) {
                i3 = R.id.pkr;
                PortalStoreColorEntranceView portalStoreColorEntranceView = (PortalStoreColorEntranceView) ViewBindings.findChildViewById(view, R.id.pkr);
                if (portalStoreColorEntranceView != null) {
                    i3 = R.id.qo9;
                    HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, R.id.qo9);
                    if (horizontalScrollView != null) {
                        return new cc(view, viewPager, portalStorePanelCategoryView, portalStoreColorEntranceView, horizontalScrollView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static cc f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.dee, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
