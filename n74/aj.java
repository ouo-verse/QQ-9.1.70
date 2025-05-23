package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aj implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418626a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f418627b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f418628c;

    /* renamed from: d, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f418629d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f418630e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f418631f;

    /* renamed from: g, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f418632g;

    /* renamed from: h, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f418633h;

    /* renamed from: i, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f418634i;

    /* renamed from: j, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f418635j;

    /* renamed from: k, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f418636k;

    aj(View view, ImageView imageView, ImageView imageView2, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, TextView textView, TextView textView2, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView3, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView4, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView5, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView6) {
        this.f418626a = view;
        this.f418627b = imageView;
        this.f418628c = imageView2;
        this.f418629d = zplanExcludeFontPaddingTextView;
        this.f418630e = textView;
        this.f418631f = textView2;
        this.f418632g = zplanExcludeFontPaddingTextView2;
        this.f418633h = zplanExcludeFontPaddingTextView3;
        this.f418634i = zplanExcludeFontPaddingTextView4;
        this.f418635j = zplanExcludeFontPaddingTextView5;
        this.f418636k = zplanExcludeFontPaddingTextView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418626a;
    }

    public static aj e(View view) {
        int i3 = R.id.q0w;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.q0w);
        if (imageView != null) {
            i3 = R.id.q0x;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.q0x);
            if (imageView2 != null) {
                i3 = R.id.qte;
                ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.qte);
                if (zplanExcludeFontPaddingTextView != null) {
                    i3 = R.id.qtf;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qtf);
                    if (textView != null) {
                        i3 = R.id.qtg;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qtg);
                        if (textView2 != null) {
                            i3 = R.id.f163562qt0;
                            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163562qt0);
                            if (zplanExcludeFontPaddingTextView2 != null) {
                                i3 = R.id.f163566qt4;
                                ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView3 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163566qt4);
                                if (zplanExcludeFontPaddingTextView3 != null) {
                                    i3 = R.id.f163567qu0;
                                    ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView4 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163567qu0);
                                    if (zplanExcludeFontPaddingTextView4 != null) {
                                        i3 = R.id.f163568qu1;
                                        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView5 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163568qu1);
                                        if (zplanExcludeFontPaddingTextView5 != null) {
                                            i3 = R.id.f163569qu2;
                                            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView6 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163569qu2);
                                            if (zplanExcludeFontPaddingTextView6 != null) {
                                                return new aj(view, imageView, imageView2, zplanExcludeFontPaddingTextView, textView, textView2, zplanExcludeFontPaddingTextView2, zplanExcludeFontPaddingTextView3, zplanExcludeFontPaddingTextView4, zplanExcludeFontPaddingTextView5, zplanExcludeFontPaddingTextView6);
                                            }
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

    public static aj f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.da6, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
