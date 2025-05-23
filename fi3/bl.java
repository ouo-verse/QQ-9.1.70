package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomePriceHintView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bl implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f399115a;

    /* renamed from: b, reason: collision with root package name */
    public final MiniHomePriceHintView f399116b;

    /* renamed from: c, reason: collision with root package name */
    public final View f399117c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f399118d;

    /* renamed from: e, reason: collision with root package name */
    public final RelativeLayout f399119e;

    bl(RelativeLayout relativeLayout, MiniHomePriceHintView miniHomePriceHintView, View view, ImageView imageView, RelativeLayout relativeLayout2) {
        this.f399115a = relativeLayout;
        this.f399116b = miniHomePriceHintView;
        this.f399117c = view;
        this.f399118d = imageView;
        this.f399119e = relativeLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f399115a;
    }

    public static bl g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bl e(View view) {
        int i3 = R.id.pze;
        MiniHomePriceHintView miniHomePriceHintView = (MiniHomePriceHintView) ViewBindings.findChildViewById(view, R.id.pze);
        if (miniHomePriceHintView != null) {
            i3 = R.id.f163429q30;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.f163429q30);
            if (findChildViewById != null) {
                i3 = R.id.f163433q34;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163433q34);
                if (imageView != null) {
                    i3 = R.id.f163434q35;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163434q35);
                    if (relativeLayout != null) {
                        return new bl((RelativeLayout) view, miniHomePriceHintView, findChildViewById, imageView, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bl h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ddj, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
