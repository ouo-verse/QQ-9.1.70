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
public final class i implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f399277a;

    /* renamed from: b, reason: collision with root package name */
    public final RoundImageView f399278b;

    /* renamed from: c, reason: collision with root package name */
    public final View f399279c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399280d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399281e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f399282f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f399283g;

    i(View view, RoundImageView roundImageView, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f399277a = view;
        this.f399278b = roundImageView;
        this.f399279c = view2;
        this.f399280d = textView;
        this.f399281e = textView2;
        this.f399282f = textView3;
        this.f399283g = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f399277a;
    }

    public static i e(View view) {
        int i3 = R.id.qzy;
        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.qzy);
        if (roundImageView != null) {
            i3 = R.id.qzz;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.qzz);
            if (findChildViewById != null) {
                i3 = R.id.f163598r01;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163598r01);
                if (textView != null) {
                    i3 = R.id.f163599r02;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f163599r02);
                    if (textView2 != null) {
                        i3 = R.id.f163600r03;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f163600r03);
                        if (textView3 != null) {
                            i3 = R.id.f163601r04;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f163601r04);
                            if (textView4 != null) {
                                return new i(view, roundImageView, findChildViewById, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static i f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d7l, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}
