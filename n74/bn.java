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

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bn implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f418862a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f418863b;

    /* renamed from: c, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f418864c;

    bn(View view, ImageView imageView, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView) {
        this.f418862a = view;
        this.f418863b = imageView;
        this.f418864c = zplanExcludeFontPaddingTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f418862a;
    }

    public static bn e(View view) {
        int i3 = R.id.q6a;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.q6a);
        if (imageView != null) {
            i3 = R.id.q6b;
            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.q6b);
            if (zplanExcludeFontPaddingTextView != null) {
                return new bn(view, imageView, zplanExcludeFontPaddingTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bn f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.ddm, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
