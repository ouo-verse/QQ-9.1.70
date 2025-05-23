package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.portal.home.banner.Banner;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bw implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f399171a;

    /* renamed from: b, reason: collision with root package name */
    public final Banner f399172b;

    /* renamed from: c, reason: collision with root package name */
    public final ZPlanMediaView f399173c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayoutCompat f399174d;

    /* renamed from: e, reason: collision with root package name */
    public final ZPlanMediaView f399175e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f399176f;

    /* renamed from: g, reason: collision with root package name */
    public final ZPlanMediaView f399177g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f399178h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f399179i;

    bw(LinearLayoutCompat linearLayoutCompat, Banner banner, ZPlanMediaView zPlanMediaView, LinearLayoutCompat linearLayoutCompat2, ZPlanMediaView zPlanMediaView2, TextView textView, ZPlanMediaView zPlanMediaView3, TextView textView2, TextView textView3) {
        this.f399171a = linearLayoutCompat;
        this.f399172b = banner;
        this.f399173c = zPlanMediaView;
        this.f399174d = linearLayoutCompat2;
        this.f399175e = zPlanMediaView2;
        this.f399176f = textView;
        this.f399177g = zPlanMediaView3;
        this.f399178h = textView2;
        this.f399179i = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f399171a;
    }

    public static bw e(View view) {
        int i3 = R.id.psz;
        Banner banner = (Banner) ViewBindings.findChildViewById(view, R.id.psz);
        if (banner != null) {
            i3 = R.id.f163376pt0;
            ZPlanMediaView zPlanMediaView = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.f163376pt0);
            if (zPlanMediaView != null) {
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
                i3 = R.id.f163380pt4;
                ZPlanMediaView zPlanMediaView2 = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.f163380pt4);
                if (zPlanMediaView2 != null) {
                    i3 = R.id.pt5;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pt5);
                    if (textView != null) {
                        i3 = R.id.pt6;
                        ZPlanMediaView zPlanMediaView3 = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.pt6);
                        if (zPlanMediaView3 != null) {
                            i3 = R.id.pt7;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pt7);
                            if (textView2 != null) {
                                i3 = R.id.pt8;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.pt8);
                                if (textView3 != null) {
                                    return new bw(linearLayoutCompat, banner, zPlanMediaView, linearLayoutCompat, zPlanMediaView2, textView, zPlanMediaView3, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bw g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dfm, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
