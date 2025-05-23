package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.ZootopiaPullRefreshLayoutV2;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class n implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399303a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f399304b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f399305c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f399306d;

    /* renamed from: e, reason: collision with root package name */
    public final AvatarPanelErrorView f399307e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f399308f;

    /* renamed from: g, reason: collision with root package name */
    public final NativePanelLoadingIgv f399309g;

    /* renamed from: h, reason: collision with root package name */
    public final ZootopiaPullRefreshLayoutV2 f399310h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f399311i;

    n(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, ImageView imageView, AvatarPanelErrorView avatarPanelErrorView, FrameLayout frameLayout, NativePanelLoadingIgv nativePanelLoadingIgv, ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV2, TextView textView2) {
        this.f399303a = constraintLayout;
        this.f399304b = textView;
        this.f399305c = linearLayout;
        this.f399306d = imageView;
        this.f399307e = avatarPanelErrorView;
        this.f399308f = frameLayout;
        this.f399309g = nativePanelLoadingIgv;
        this.f399310h = zootopiaPullRefreshLayoutV2;
        this.f399311i = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399303a;
    }

    public static n g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static n e(View view) {
        int i3 = R.id.prr;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.prr);
        if (textView != null) {
            i3 = R.id.prs;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.prs);
            if (linearLayout != null) {
                i3 = R.id.pru;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pru);
                if (imageView != null) {
                    i3 = R.id.psw;
                    AvatarPanelErrorView avatarPanelErrorView = (AvatarPanelErrorView) ViewBindings.findChildViewById(view, R.id.psw);
                    if (avatarPanelErrorView != null) {
                        i3 = R.id.q6v;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q6v);
                        if (frameLayout != null) {
                            i3 = R.id.f163452q70;
                            NativePanelLoadingIgv nativePanelLoadingIgv = (NativePanelLoadingIgv) ViewBindings.findChildViewById(view, R.id.f163452q70);
                            if (nativePanelLoadingIgv != null) {
                                i3 = R.id.qep;
                                ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV2 = (ZootopiaPullRefreshLayoutV2) ViewBindings.findChildViewById(view, R.id.qep);
                                if (zootopiaPullRefreshLayoutV2 != null) {
                                    i3 = R.id.qrr;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qrr);
                                    if (textView2 != null) {
                                        return new n((ConstraintLayout) view, textView, linearLayout, imageView, avatarPanelErrorView, frameLayout, nativePanelLoadingIgv, zootopiaPullRefreshLayoutV2, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static n h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d7s, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
