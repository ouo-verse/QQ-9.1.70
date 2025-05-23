package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bo implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f418865a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f418866b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f418867c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f418868d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f418869e;

    /* renamed from: f, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f418870f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f418871g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f418872h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f418873i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f418874j;

    bo(FrameLayout frameLayout, TextView textView, ImageView imageView, TextView textView2, FrameLayout frameLayout2, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, LinearLayout linearLayout, ImageView imageView2, TextView textView3, TextView textView4) {
        this.f418865a = frameLayout;
        this.f418866b = textView;
        this.f418867c = imageView;
        this.f418868d = textView2;
        this.f418869e = frameLayout2;
        this.f418870f = zplanExcludeFontPaddingTextView;
        this.f418871g = linearLayout;
        this.f418872h = imageView2;
        this.f418873i = textView3;
        this.f418874j = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f418865a;
    }

    public static bo e(View view) {
        int i3 = R.id.phn;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.phn);
        if (textView != null) {
            i3 = R.id.f163400px4;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f163400px4);
            if (imageView != null) {
                i3 = R.id.px7;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.px7);
                if (textView2 != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i3 = R.id.qam;
                    ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.qam);
                    if (zplanExcludeFontPaddingTextView != null) {
                        i3 = R.id.qdo;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.qdo);
                        if (linearLayout != null) {
                            i3 = R.id.qls;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.qls);
                            if (imageView2 != null) {
                                i3 = R.id.qlv;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.qlv);
                                if (textView3 != null) {
                                    i3 = R.id.qmu;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.qmu);
                                    if (textView4 != null) {
                                        return new bo(frameLayout, textView, imageView, textView2, frameLayout, zplanExcludeFontPaddingTextView, linearLayout, imageView2, textView3, textView4);
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

    public static bo g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ddo, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
