package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreColorPanelTopOptView;
import com.tencent.sqshow.zootopia.nativeui.view.color.ColorPickerTitleView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cb implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f418968a;

    /* renamed from: b, reason: collision with root package name */
    public final View f418969b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorPickerTitleView f418970c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f418971d;

    /* renamed from: e, reason: collision with root package name */
    public final PortalStoreColorPanelTopOptView f418972e;

    cb(LinearLayout linearLayout, View view, ColorPickerTitleView colorPickerTitleView, FrameLayout frameLayout, PortalStoreColorPanelTopOptView portalStoreColorPanelTopOptView) {
        this.f418968a = linearLayout;
        this.f418969b = view;
        this.f418970c = colorPickerTitleView;
        this.f418971d = frameLayout;
        this.f418972e = portalStoreColorPanelTopOptView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f418968a;
    }

    public static cb g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static cb e(View view) {
        int i3 = R.id.pks;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.pks);
        if (findChildViewById != null) {
            i3 = R.id.pkt;
            ColorPickerTitleView colorPickerTitleView = (ColorPickerTitleView) ViewBindings.findChildViewById(view, R.id.pkt);
            if (colorPickerTitleView != null) {
                i3 = R.id.qbf;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.qbf);
                if (frameLayout != null) {
                    i3 = R.id.qs7;
                    PortalStoreColorPanelTopOptView portalStoreColorPanelTopOptView = (PortalStoreColorPanelTopOptView) ViewBindings.findChildViewById(view, R.id.qs7);
                    if (portalStoreColorPanelTopOptView != null) {
                        return new cb((LinearLayout) view, findChildViewById, colorPickerTitleView, frameLayout, portalStoreColorPanelTopOptView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static cb h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ded, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
