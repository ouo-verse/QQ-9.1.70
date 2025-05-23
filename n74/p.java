package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.avatar.loading.view.ZPlanPageDataErrorHintView;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class p implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f419387a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f419388b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f419389c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f419390d;

    /* renamed from: e, reason: collision with root package name */
    public final URLImageView f419391e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f419392f;

    /* renamed from: g, reason: collision with root package name */
    public final ZPlanPageDataErrorHintView f419393g;

    /* renamed from: h, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419394h;

    /* renamed from: i, reason: collision with root package name */
    public final FrameLayout f419395i;

    /* renamed from: j, reason: collision with root package name */
    public final ProgressBar f419396j;

    p(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, URLImageView uRLImageView, LinearLayout linearLayout, ZPlanPageDataErrorHintView zPlanPageDataErrorHintView, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, FrameLayout frameLayout4, ProgressBar progressBar) {
        this.f419387a = frameLayout;
        this.f419388b = frameLayout2;
        this.f419389c = frameLayout3;
        this.f419390d = imageView;
        this.f419391e = uRLImageView;
        this.f419392f = linearLayout;
        this.f419393g = zPlanPageDataErrorHintView;
        this.f419394h = zplanExcludeFontPaddingTextView;
        this.f419395i = frameLayout4;
        this.f419396j = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f419387a;
    }

    public static p e(View view) {
        int i3 = R.id.pb_;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pb_);
        if (frameLayout != null) {
            i3 = R.id.pcy;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pcy);
            if (frameLayout2 != null) {
                i3 = R.id.f163299pd3;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163299pd3);
                if (imageView != null) {
                    i3 = R.id.f163450q63;
                    URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.f163450q63);
                    if (uRLImageView != null) {
                        i3 = R.id.f163451q64;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f163451q64);
                        if (linearLayout != null) {
                            i3 = R.id.q6_;
                            ZPlanPageDataErrorHintView zPlanPageDataErrorHintView = (ZPlanPageDataErrorHintView) ViewBindings.findChildViewById(view, R.id.q6_);
                            if (zPlanPageDataErrorHintView != null) {
                                i3 = R.id.q6c;
                                ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.q6c);
                                if (zplanExcludeFontPaddingTextView != null) {
                                    i3 = R.id.q6f;
                                    FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q6f);
                                    if (frameLayout3 != null) {
                                        i3 = R.id.q6h;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.q6h);
                                        if (progressBar != null) {
                                            return new p((FrameLayout) view, frameLayout, frameLayout2, imageView, uRLImageView, linearLayout, zPlanPageDataErrorHintView, zplanExcludeFontPaddingTextView, frameLayout3, progressBar);
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

    public static p g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_a, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
