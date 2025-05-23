package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.ZootopiaPullRefreshLayoutV2;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f399284a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f399285b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f399286c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399287d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f399288e;

    /* renamed from: f, reason: collision with root package name */
    public final AvatarPanelErrorView f399289f;

    /* renamed from: g, reason: collision with root package name */
    public final NativePanelLoadingIgv f399290g;

    /* renamed from: h, reason: collision with root package name */
    public final ZootopiaPullRefreshLayoutV2 f399291h;

    j(View view, TextView textView, ImageView imageView, TextView textView2, LinearLayout linearLayout, AvatarPanelErrorView avatarPanelErrorView, NativePanelLoadingIgv nativePanelLoadingIgv, ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV2) {
        this.f399284a = view;
        this.f399285b = textView;
        this.f399286c = imageView;
        this.f399287d = textView2;
        this.f399288e = linearLayout;
        this.f399289f = avatarPanelErrorView;
        this.f399290g = nativePanelLoadingIgv;
        this.f399291h = zootopiaPullRefreshLayoutV2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f399284a;
    }

    public static j e(View view) {
        int i3 = R.id.pfe;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pfe);
        if (textView != null) {
            i3 = R.id.prp;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.prp);
            if (imageView != null) {
                i3 = R.id.prr;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.prr);
                if (textView2 != null) {
                    i3 = R.id.prs;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.prs);
                    if (linearLayout != null) {
                        i3 = R.id.psw;
                        AvatarPanelErrorView avatarPanelErrorView = (AvatarPanelErrorView) ViewBindings.findChildViewById(view, R.id.psw);
                        if (avatarPanelErrorView != null) {
                            i3 = R.id.f163452q70;
                            NativePanelLoadingIgv nativePanelLoadingIgv = (NativePanelLoadingIgv) ViewBindings.findChildViewById(view, R.id.f163452q70);
                            if (nativePanelLoadingIgv != null) {
                                i3 = R.id.qep;
                                ZootopiaPullRefreshLayoutV2 zootopiaPullRefreshLayoutV2 = (ZootopiaPullRefreshLayoutV2) ViewBindings.findChildViewById(view, R.id.qep);
                                if (zootopiaPullRefreshLayoutV2 != null) {
                                    return new j(view, textView, imageView, textView2, linearLayout, avatarPanelErrorView, nativePanelLoadingIgv, zootopiaPullRefreshLayoutV2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static j f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d7o, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
