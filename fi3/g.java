package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f399262a;

    /* renamed from: b, reason: collision with root package name */
    public final ZootopiaDownloadButton f399263b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f399264c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399265d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399266e;

    /* renamed from: f, reason: collision with root package name */
    public final RoundImageView f399267f;

    /* renamed from: g, reason: collision with root package name */
    public final RelativeLayout f399268g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f399269h;

    g(View view, ZootopiaDownloadButton zootopiaDownloadButton, LinearLayout linearLayout, TextView textView, TextView textView2, RoundImageView roundImageView, RelativeLayout relativeLayout, TextView textView3) {
        this.f399262a = view;
        this.f399263b = zootopiaDownloadButton;
        this.f399264c = linearLayout;
        this.f399265d = textView;
        this.f399266e = textView2;
        this.f399267f = roundImageView;
        this.f399268g = relativeLayout;
        this.f399269h = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f399262a;
    }

    public static g e(View view) {
        int i3 = R.id.pfv;
        ZootopiaDownloadButton zootopiaDownloadButton = (ZootopiaDownloadButton) ViewBindings.findChildViewById(view, R.id.pfv);
        if (zootopiaDownloadButton != null) {
            i3 = R.id.qza;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qza);
            if (linearLayout != null) {
                i3 = R.id.qzb;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qzb);
                if (textView != null) {
                    i3 = R.id.qzc;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qzc);
                    if (textView2 != null) {
                        i3 = R.id.qzg;
                        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.qzg);
                        if (roundImageView != null) {
                            i3 = R.id.qzh;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qzh);
                            if (relativeLayout != null) {
                                i3 = R.id.qzi;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qzi);
                                if (textView3 != null) {
                                    return new g(view, zootopiaDownloadButton, linearLayout, textView, textView2, roundImageView, relativeLayout, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static g f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d7j, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
