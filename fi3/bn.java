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
import com.tencent.mobileqq.zplan.minihome.view.MiniHomePriceHintView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bn implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f399125a;

    /* renamed from: b, reason: collision with root package name */
    public final MiniHomePriceHintView f399126b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f399127c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399128d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f399129e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f399130f;

    /* renamed from: g, reason: collision with root package name */
    public final RelativeLayout f399131g;

    /* renamed from: h, reason: collision with root package name */
    public final View f399132h;

    bn(RelativeLayout relativeLayout, MiniHomePriceHintView miniHomePriceHintView, TextView textView, TextView textView2, RecyclerView recyclerView, ImageView imageView, RelativeLayout relativeLayout2, View view) {
        this.f399125a = relativeLayout;
        this.f399126b = miniHomePriceHintView;
        this.f399127c = textView;
        this.f399128d = textView2;
        this.f399129e = recyclerView;
        this.f399130f = imageView;
        this.f399131g = relativeLayout2;
        this.f399132h = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f399125a;
    }

    public static bn g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bn e(View view) {
        int i3 = R.id.pze;
        MiniHomePriceHintView miniHomePriceHintView = (MiniHomePriceHintView) ViewBindings.findChildViewById(view, R.id.pze);
        if (miniHomePriceHintView != null) {
            i3 = R.id.q2u;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.q2u);
            if (textView != null) {
                i3 = R.id.q2z;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.q2z);
                if (textView2 != null) {
                    i3 = R.id.f163431q32;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f163431q32);
                    if (recyclerView != null) {
                        i3 = R.id.f163433q34;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163433q34);
                        if (imageView != null) {
                            i3 = R.id.f163434q35;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163434q35);
                            if (relativeLayout != null) {
                                i3 = R.id.qb8;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.qb8);
                                if (findChildViewById != null) {
                                    return new bn((RelativeLayout) view, miniHomePriceHintView, textView, textView2, recyclerView, imageView, relativeLayout, findChildViewById);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bn h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ddl, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
