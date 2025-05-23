package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class am implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f418670a;

    /* renamed from: b, reason: collision with root package name */
    public final URLImageView f418671b;

    /* renamed from: c, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f418672c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f418673d;

    am(RelativeLayout relativeLayout, URLImageView uRLImageView, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, ImageView imageView) {
        this.f418670a = relativeLayout;
        this.f418671b = uRLImageView;
        this.f418672c = zplanExcludeFontPaddingTextView;
        this.f418673d = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f418670a;
    }

    public static am g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static am e(View view) {
        int i3 = R.id.q0d;
        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.q0d);
        if (uRLImageView != null) {
            i3 = R.id.qan;
            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.qan);
            if (zplanExcludeFontPaddingTextView != null) {
                i3 = R.id.f163520qk3;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163520qk3);
                if (imageView != null) {
                    return new am((RelativeLayout) view, uRLImageView, zplanExcludeFontPaddingTextView, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static am h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.daa, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
