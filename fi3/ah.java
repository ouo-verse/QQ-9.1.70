package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ah implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f398811a;

    /* renamed from: b, reason: collision with root package name */
    public final RoundImageView f398812b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f398813c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f398814d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f398815e;

    ah(View view, RoundImageView roundImageView, TextView textView, TextView textView2, TextView textView3) {
        this.f398811a = view;
        this.f398812b = roundImageView;
        this.f398813c = textView;
        this.f398814d = textView2;
        this.f398815e = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f398811a;
    }

    public static ah e(View view) {
        int i3 = R.id.f163611r22;
        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.f163611r22);
        if (roundImageView != null) {
            i3 = R.id.f163612r23;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163612r23);
            if (textView != null) {
                i3 = R.id.f163613r24;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f163613r24);
                if (textView2 != null) {
                    i3 = R.id.f163614r25;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f163614r25);
                    if (textView3 != null) {
                        return new ah(view, roundImageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ah f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d9j, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
