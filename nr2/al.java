package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import com.tencent.timi.game.widget.MediumBoldTextView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class al implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f420822a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f420823b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final MediumBoldTextView f420824c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TimiGamePAGView f420825d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420826e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f420827f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f420828g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f420829h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420830i;

    al(@NonNull View view, @NonNull View view2, @NonNull MediumBoldTextView mediumBoldTextView, @NonNull TimiGamePAGView timiGamePAGView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout2) {
        this.f420822a = view;
        this.f420823b = view2;
        this.f420824c = mediumBoldTextView;
        this.f420825d = timiGamePAGView;
        this.f420826e = linearLayout;
        this.f420827f = textView;
        this.f420828g = textView2;
        this.f420829h = textView3;
        this.f420830i = linearLayout2;
    }

    @NonNull
    public static al e(@NonNull View view) {
        int i3 = R.id.lft;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.lft);
        if (findChildViewById != null) {
            i3 = R.id.xln;
            MediumBoldTextView mediumBoldTextView = (MediumBoldTextView) ViewBindings.findChildViewById(view, R.id.xln);
            if (mediumBoldTextView != null) {
                i3 = R.id.xlo;
                TimiGamePAGView timiGamePAGView = (TimiGamePAGView) ViewBindings.findChildViewById(view, R.id.xlo);
                if (timiGamePAGView != null) {
                    i3 = R.id.f219402d;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f219402d);
                    if (linearLayout != null) {
                        i3 = R.id.f926658h;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f926658h);
                        if (textView != null) {
                            i3 = R.id.f927158m;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f927158m);
                            if (textView2 != null) {
                                i3 = R.id.f927258n;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f927258n);
                                if (textView3 != null) {
                                    i3 = R.id.f927458p;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f927458p);
                                    if (linearLayout2 != null) {
                                        return new al(view, findChildViewById, mediumBoldTextView, timiGamePAGView, linearLayout, textView, textView2, textView3, linearLayout2);
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

    @NonNull
    public static al f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hvp, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f420822a;
    }
}
