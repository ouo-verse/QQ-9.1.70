package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bk implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f399110a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f399111b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f399112c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399113d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399114e;

    bk(RelativeLayout relativeLayout, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f399110a = relativeLayout;
        this.f399111b = imageView;
        this.f399112c = recyclerView;
        this.f399113d = textView;
        this.f399114e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f399110a;
    }

    public static bk e(View view) {
        int i3 = R.id.pk6;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pk6);
        if (imageView != null) {
            i3 = R.id.f163341pm0;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f163341pm0);
            if (recyclerView != null) {
                i3 = R.id.qo8;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qo8);
                if (textView != null) {
                    i3 = R.id.qr6;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qr6);
                    if (textView2 != null) {
                        return new bk((RelativeLayout) view, imageView, recyclerView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bk g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ddi, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
