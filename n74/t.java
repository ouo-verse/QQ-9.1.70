package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class t implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419413a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f419414b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f419415c;

    /* renamed from: d, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419416d;

    /* renamed from: e, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f419417e;

    t(View view, Button button, FrameLayout frameLayout, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2) {
        this.f419413a = view;
        this.f419414b = button;
        this.f419415c = frameLayout;
        this.f419416d = zplanExcludeFontPaddingTextView;
        this.f419417e = zplanExcludeFontPaddingTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419413a;
    }

    public static t e(View view) {
        int i3 = R.id.f163313pg2;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.f163313pg2);
        if (button != null) {
            i3 = R.id.psn;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.psn);
            if (frameLayout != null) {
                i3 = R.id.qti;
                ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.qti);
                if (zplanExcludeFontPaddingTextView != null) {
                    i3 = R.id.qtj;
                    ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2 = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.qtj);
                    if (zplanExcludeFontPaddingTextView2 != null) {
                        return new t(view, button, frameLayout, zplanExcludeFontPaddingTextView, zplanExcludeFontPaddingTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static t f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d_f, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
