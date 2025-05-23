package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qqcircle.immersive.refresh.ChrysanthemumLoadingView;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaRefreshView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bd implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f418817a;

    /* renamed from: b, reason: collision with root package name */
    public final ChrysanthemumLoadingView f418818b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f418819c;

    /* renamed from: d, reason: collision with root package name */
    public final ZootopiaRefreshView f418820d;

    bd(LinearLayout linearLayout, ChrysanthemumLoadingView chrysanthemumLoadingView, TextView textView, ZootopiaRefreshView zootopiaRefreshView) {
        this.f418817a = linearLayout;
        this.f418818b = chrysanthemumLoadingView;
        this.f418819c = textView;
        this.f418820d = zootopiaRefreshView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f418817a;
    }

    public static bd e(View view) {
        int i3 = R.id.f163452q70;
        ChrysanthemumLoadingView chrysanthemumLoadingView = (ChrysanthemumLoadingView) ViewBindings.findChildViewById(view, R.id.f163452q70);
        if (chrysanthemumLoadingView != null) {
            i3 = R.id.qtp;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qtp);
            if (textView != null) {
                i3 = R.id.r1g;
                ZootopiaRefreshView zootopiaRefreshView = (ZootopiaRefreshView) ViewBindings.findChildViewById(view, R.id.r1g);
                if (zootopiaRefreshView != null) {
                    return new bd((LinearLayout) view, chrysanthemumLoadingView, textView, zootopiaRefreshView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bd g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dbt, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
