package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import com.tencent.widget.Switch;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class an implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f418674a;

    /* renamed from: b, reason: collision with root package name */
    public final ZplanExcludeFontPaddingTextView f418675b;

    /* renamed from: c, reason: collision with root package name */
    public final Switch f418676c;

    an(RelativeLayout relativeLayout, ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView, Switch r36) {
        this.f418674a = relativeLayout;
        this.f418675b = zplanExcludeFontPaddingTextView;
        this.f418676c = r36;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f418674a;
    }

    public static an g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static an e(View view) {
        int i3 = R.id.f163384pu3;
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = (ZplanExcludeFontPaddingTextView) ViewBindings.findChildViewById(view, R.id.f163384pu3);
        if (zplanExcludeFontPaddingTextView != null) {
            i3 = R.id.f163385pu4;
            Switch r26 = (Switch) ViewBindings.findChildViewById(view, R.id.f163385pu4);
            if (r26 != null) {
                return new an((RelativeLayout) view, zplanExcludeFontPaddingTextView, r26);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static an h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dab, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
