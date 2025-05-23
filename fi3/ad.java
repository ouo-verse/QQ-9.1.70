package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.widget.impl.button.ZplanCommonButton;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ad implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f398791a;

    /* renamed from: b, reason: collision with root package name */
    public final ZplanCommonButton f398792b;

    /* renamed from: c, reason: collision with root package name */
    public final View f398793c;

    /* renamed from: d, reason: collision with root package name */
    public final View f398794d;

    /* renamed from: e, reason: collision with root package name */
    public final View f398795e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f398796f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f398797g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f398798h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f398799i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f398800j;

    ad(View view, ZplanCommonButton zplanCommonButton, View view2, View view3, View view4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f398791a = view;
        this.f398792b = zplanCommonButton;
        this.f398793c = view2;
        this.f398794d = view3;
        this.f398795e = view4;
        this.f398796f = textView;
        this.f398797g = textView2;
        this.f398798h = textView3;
        this.f398799i = textView4;
        this.f398800j = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f398791a;
    }

    public static ad e(View view) {
        int i3 = R.id.f163312pg1;
        ZplanCommonButton zplanCommonButton = (ZplanCommonButton) ViewBindings.findChildViewById(view, R.id.f163312pg1);
        if (zplanCommonButton != null) {
            i3 = R.id.q0p;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.q0p);
            if (findChildViewById != null) {
                i3 = R.id.f163419q12;
                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f163419q12);
                if (findChildViewById2 != null) {
                    i3 = R.id.q5i;
                    View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.q5i);
                    if (findChildViewById3 != null) {
                        i3 = R.id.qtk;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qtk);
                        if (textView != null) {
                            i3 = R.id.qu5;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qu5);
                            if (textView2 != null) {
                                i3 = R.id.qua;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qua);
                                if (textView3 != null) {
                                    i3 = R.id.que;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.que);
                                    if (textView4 != null) {
                                        i3 = R.id.qui;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.qui);
                                        if (textView5 != null) {
                                            return new ad(view, zplanCommonButton, findChildViewById, findChildViewById2, findChildViewById3, textView, textView2, textView3, textView4, textView5);
                                        }
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

    public static ad f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d9d, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
