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
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bc implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f399055a;

    /* renamed from: b, reason: collision with root package name */
    public final ZootopiaDownloadButton f399056b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f399057c;

    /* renamed from: d, reason: collision with root package name */
    public final RoundRelativeLayout f399058d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f399059e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f399060f;

    bc(LinearLayout linearLayout, ZootopiaDownloadButton zootopiaDownloadButton, ImageView imageView, RoundRelativeLayout roundRelativeLayout, ImageView imageView2, TextView textView) {
        this.f399055a = linearLayout;
        this.f399056b = zootopiaDownloadButton;
        this.f399057c = imageView;
        this.f399058d = roundRelativeLayout;
        this.f399059e = imageView2;
        this.f399060f = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f399055a;
    }

    public static bc e(View view) {
        int i3 = R.id.pfv;
        ZootopiaDownloadButton zootopiaDownloadButton = (ZootopiaDownloadButton) ViewBindings.findChildViewById(view, R.id.pfv);
        if (zootopiaDownloadButton != null) {
            i3 = R.id.r58;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.r58);
            if (imageView != null) {
                i3 = R.id.r59;
                RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) ViewBindings.findChildViewById(view, R.id.r59);
                if (roundRelativeLayout != null) {
                    i3 = R.id.r5_;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.r5_);
                    if (imageView2 != null) {
                        i3 = R.id.r5b;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.r5b);
                        if (textView != null) {
                            return new bc((LinearLayout) view, zootopiaDownloadButton, imageView, roundRelativeLayout, imageView2, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bc g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dcr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
