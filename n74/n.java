package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
public final class n implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f419374a;

    /* renamed from: b, reason: collision with root package name */
    public final URLImageView f419375b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f419376c;

    /* renamed from: d, reason: collision with root package name */
    public final URLImageView f419377d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f419378e;

    /* renamed from: f, reason: collision with root package name */
    public final ZPlanPageDataErrorHintView f419379f;

    /* renamed from: g, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419380g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f419381h;

    /* renamed from: i, reason: collision with root package name */
    public final ProgressBar f419382i;

    n(FrameLayout frameLayout, URLImageView uRLImageView, FrameLayout frameLayout2, URLImageView uRLImageView2, LinearLayout linearLayout, ZPlanPageDataErrorHintView zPlanPageDataErrorHintView, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, FrameLayout frameLayout3, ProgressBar progressBar) {
        this.f419374a = frameLayout;
        this.f419375b = uRLImageView;
        this.f419376c = frameLayout2;
        this.f419377d = uRLImageView2;
        this.f419378e = linearLayout;
        this.f419379f = zPlanPageDataErrorHintView;
        this.f419380g = zplanExcludeFontPaddingTextView;
        this.f419381h = frameLayout3;
        this.f419382i = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f419374a;
    }

    public static n e(View view) {
        int i3 = R.id.pb6;
        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.pb6);
        if (uRLImageView != null) {
            i3 = R.id.pb_;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.pb_);
            if (frameLayout != null) {
                i3 = R.id.f163450q63;
                URLImageView uRLImageView2 = (URLImageView) ViewBindings.findChildViewById(view, R.id.f163450q63);
                if (uRLImageView2 != null) {
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
                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.q6f);
                                if (frameLayout2 != null) {
                                    i3 = R.id.q6h;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.q6h);
                                    if (progressBar != null) {
                                        return new n((FrameLayout) view, uRLImageView, frameLayout, uRLImageView2, linearLayout, zPlanPageDataErrorHintView, zplanExcludeFontPaddingTextView, frameLayout2, progressBar);
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

    public static n g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d_8, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
