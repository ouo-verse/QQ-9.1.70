package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.Switch;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class s implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421114a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f421115b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f421116c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final HorizontalScrollView f421117d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f421118e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f421119f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f421120g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final Switch f421121h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f421122i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f421123j;

    s(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull HorizontalScrollView horizontalScrollView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout3, @NonNull Switch r85, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f421114a = view;
        this.f421115b = linearLayout;
        this.f421116c = linearLayout2;
        this.f421117d = horizontalScrollView;
        this.f421118e = textView;
        this.f421119f = textView2;
        this.f421120g = linearLayout3;
        this.f421121h = r85;
        this.f421122i = textView3;
        this.f421123j = textView4;
    }

    @NonNull
    public static s e(@NonNull View view) {
        int i3 = R.id.f165360vo1;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f165360vo1);
        if (linearLayout != null) {
            i3 = R.id.vo5;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.vo5);
            if (linearLayout2 != null) {
                i3 = R.id.vo9;
                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, R.id.vo9);
                if (horizontalScrollView != null) {
                    i3 = R.id.vom;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vom);
                    if (textView != null) {
                        i3 = R.id.voo;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.voo);
                        if (textView2 != null) {
                            i3 = R.id.f82534h5;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f82534h5);
                            if (linearLayout3 != null) {
                                i3 = R.id.f911154a;
                                Switch r102 = (Switch) ViewBindings.findChildViewById(view, R.id.f911154a);
                                if (r102 != null) {
                                    i3 = R.id.f166986jo4;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f166986jo4);
                                    if (textView3 != null) {
                                        i3 = R.id.f113406qj;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f113406qj);
                                        if (textView4 != null) {
                                            return new s(view, linearLayout, linearLayout2, horizontalScrollView, textView, textView2, linearLayout3, r102, textView3, textView4);
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
    public static s f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hts, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f421114a;
    }
}
