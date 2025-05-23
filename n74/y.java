package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.action.ColorPanelTopOptView;
import com.tencent.sqshow.zootopia.nativeui.view.color.ColorPickerTitleView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class y implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f419468a;

    /* renamed from: b, reason: collision with root package name */
    public final View f419469b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorPickerTitleView f419470c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f419471d;

    /* renamed from: e, reason: collision with root package name */
    public final ColorPanelTopOptView f419472e;

    y(LinearLayout linearLayout, View view, ColorPickerTitleView colorPickerTitleView, FrameLayout frameLayout, ColorPanelTopOptView colorPanelTopOptView) {
        this.f419468a = linearLayout;
        this.f419469b = view;
        this.f419470c = colorPickerTitleView;
        this.f419471d = frameLayout;
        this.f419472e = colorPanelTopOptView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f419468a;
    }

    public static y g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static y e(View view) {
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
                    ColorPanelTopOptView colorPanelTopOptView = (ColorPanelTopOptView) ViewBindings.findChildViewById(view, R.id.qs7);
                    if (colorPanelTopOptView != null) {
                        return new y((LinearLayout) view, findChildViewById, colorPickerTitleView, frameLayout, colorPanelTopOptView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static y h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_m, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
