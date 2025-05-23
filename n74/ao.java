package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.utils.ui.ZPlanMaxHeightScrollView;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ao implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f418677a;

    /* renamed from: b, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f418678b;

    /* renamed from: c, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f418679c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f418680d;

    /* renamed from: e, reason: collision with root package name */
    public final View f418681e;

    /* renamed from: f, reason: collision with root package name */
    public final ZPlanMaxHeightScrollView f418682f;

    /* renamed from: g, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f418683g;

    ao(FrameLayout frameLayout, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2, LinearLayout linearLayout, View view, ZPlanMaxHeightScrollView zPlanMaxHeightScrollView, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView3) {
        this.f418677a = frameLayout;
        this.f418678b = zplanExcludeFontPaddingTextView;
        this.f418679c = zplanExcludeFontPaddingTextView2;
        this.f418680d = linearLayout;
        this.f418681e = view;
        this.f418682f = zPlanMaxHeightScrollView;
        this.f418683g = zplanExcludeFontPaddingTextView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f418677a;
    }

    public static ao g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static ao e(View view) {
        int i3 = R.id.qvf;
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.qvf);
        if (zplanExcludeFontPaddingTextView != null) {
            i3 = R.id.qvg;
            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.qvg);
            if (zplanExcludeFontPaddingTextView2 != null) {
                i3 = R.id.qvh;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qvh);
                if (linearLayout != null) {
                    i3 = R.id.qvi;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.qvi);
                    if (findChildViewById != null) {
                        i3 = R.id.qvj;
                        ZPlanMaxHeightScrollView zPlanMaxHeightScrollView = (ZPlanMaxHeightScrollView) ViewBindings.findChildViewById(view, R.id.qvj);
                        if (zPlanMaxHeightScrollView != null) {
                            i3 = R.id.qvk;
                            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView3 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.qvk);
                            if (zplanExcludeFontPaddingTextView3 != null) {
                                return new ao((FrameLayout) view, zplanExcludeFontPaddingTextView, zplanExcludeFontPaddingTextView2, linearLayout, findChildViewById, zPlanMaxHeightScrollView, zplanExcludeFontPaddingTextView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ao h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dac, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
