package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class az implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f420956a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f420957b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f420958c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final EditText f420959d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420960e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f420961f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f420962g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final HorizontalScrollView f420963h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f420964i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f420965j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f420966k;

    az(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull EditText editText, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout2, @NonNull TextView textView3, @NonNull HorizontalScrollView horizontalScrollView, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f420956a = frameLayout;
        this.f420957b = textView;
        this.f420958c = textView2;
        this.f420959d = editText;
        this.f420960e = linearLayout;
        this.f420961f = frameLayout2;
        this.f420962g = textView3;
        this.f420963h = horizontalScrollView;
        this.f420964i = constraintLayout;
        this.f420965j = textView4;
        this.f420966k = textView5;
    }

    @NonNull
    public static az e(@NonNull View view) {
        int i3 = R.id.tzc;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tzc);
        if (textView != null) {
            i3 = R.id.uai;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.uai);
            if (textView2 != null) {
                i3 = R.id.bry;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.bry);
                if (editText != null) {
                    i3 = R.id.usx;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.usx);
                    if (linearLayout != null) {
                        i3 = R.id.uth;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.uth);
                        if (frameLayout != null) {
                            i3 = R.id.zym;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.zym);
                            if (textView3 != null) {
                                i3 = R.id.f27030f5;
                                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, R.id.f27030f5);
                                if (horizontalScrollView != null) {
                                    i3 = R.id.iet;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.iet);
                                    if (constraintLayout != null) {
                                        i3 = R.id.f166845in0;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f166845in0);
                                        if (textView4 != null) {
                                            i3 = R.id.f112856p2;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.f112856p2);
                                            if (textView5 != null) {
                                                return new az((FrameLayout) view, textView, textView2, editText, linearLayout, frameLayout, textView3, horizontalScrollView, constraintLayout, textView4, textView5);
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

    @NonNull
    public static az g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hxc, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f420956a;
    }
}
