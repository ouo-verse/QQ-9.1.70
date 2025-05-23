package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cc implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399231a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f399232b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f399233c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399234d;

    /* renamed from: e, reason: collision with root package name */
    public final NativePanelLoadingIgv f399235e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f399236f;

    /* renamed from: g, reason: collision with root package name */
    public final RecyclerView f399237g;

    cc(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, NativePanelLoadingIgv nativePanelLoadingIgv, LinearLayout linearLayout, RecyclerView recyclerView) {
        this.f399231a = constraintLayout;
        this.f399232b = imageView;
        this.f399233c = textView;
        this.f399234d = textView2;
        this.f399235e = nativePanelLoadingIgv;
        this.f399236f = linearLayout;
        this.f399237g = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399231a;
    }

    public static cc g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static cc e(View view) {
        int i3 = R.id.pzi;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pzi);
        if (imageView != null) {
            i3 = R.id.pzk;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.pzk);
            if (textView != null) {
                i3 = R.id.pzl;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pzl);
                if (textView2 != null) {
                    i3 = R.id.q65;
                    NativePanelLoadingIgv nativePanelLoadingIgv = (NativePanelLoadingIgv) ViewBindings.findChildViewById(view, R.id.q65);
                    if (nativePanelLoadingIgv != null) {
                        i3 = R.id.qrv;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qrv);
                        if (linearLayout != null) {
                            i3 = R.id.qv6;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.qv6);
                            if (recyclerView != null) {
                                return new cc((ConstraintLayout) view, imageView, textView, textView2, nativePanelLoadingIgv, linearLayout, recyclerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static cc h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167467dh1, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
