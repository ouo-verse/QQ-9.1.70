package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cm implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419034a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f419035b;

    /* renamed from: c, reason: collision with root package name */
    public final ZPlanMediaView f419036c;

    /* renamed from: d, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419037d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f419038e;

    /* renamed from: f, reason: collision with root package name */
    public final ZPlanRedDotView f419039f;

    cm(View view, ImageView imageView, ZPlanMediaView zPlanMediaView, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, ImageView imageView2, ZPlanRedDotView zPlanRedDotView) {
        this.f419034a = view;
        this.f419035b = imageView;
        this.f419036c = zPlanMediaView;
        this.f419037d = zplanExcludeFontPaddingTextView;
        this.f419038e = imageView2;
        this.f419039f = zPlanRedDotView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419034a;
    }

    public static cm e(View view) {
        int i3 = R.id.pd_;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pd_);
        if (imageView != null) {
            i3 = R.id.q0f;
            ZPlanMediaView zPlanMediaView = (ZPlanMediaView) ViewBindings.findChildViewById(view, R.id.q0f);
            if (zPlanMediaView != null) {
                i3 = R.id.q_7;
                ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.q_7);
                if (zplanExcludeFontPaddingTextView != null) {
                    i3 = R.id.q_a;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.q_a);
                    if (imageView2 != null) {
                        i3 = R.id.qrz;
                        ZPlanRedDotView zPlanRedDotView = (ZPlanRedDotView) ViewBindings.findChildViewById(view, R.id.qrz);
                        if (zPlanRedDotView != null) {
                            return new cm(view, imageView, zPlanMediaView, zplanExcludeFontPaddingTextView, imageView2, zPlanRedDotView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static cm f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.deu, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
