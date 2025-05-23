package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class an implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f420834a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420835b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final am f420836c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f420837d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f420838e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f420839f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f420840g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f420841h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final FrameLayout f420842i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420843j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final am f420844k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final am f420845l;

    an(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull am amVar, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout2, @NonNull am amVar2, @NonNull am amVar3) {
        this.f420834a = view;
        this.f420835b = linearLayout;
        this.f420836c = amVar;
        this.f420837d = textView;
        this.f420838e = textView2;
        this.f420839f = textView3;
        this.f420840g = textView4;
        this.f420841h = imageView;
        this.f420842i = frameLayout;
        this.f420843j = linearLayout2;
        this.f420844k = amVar2;
        this.f420845l = amVar3;
    }

    @NonNull
    public static an e(@NonNull View view) {
        int i3 = R.id.ugh;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ugh);
        if (linearLayout != null) {
            i3 = R.id.v6o;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.v6o);
            if (findChildViewById != null) {
                am e16 = am.e(findChildViewById);
                i3 = R.id.x_5;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.x_5);
                if (textView != null) {
                    i3 = R.id.x_6;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.x_6);
                    if (textView2 != null) {
                        i3 = R.id.f26510dq;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f26510dq);
                        if (textView3 != null) {
                            i3 = R.id.f26520dr;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f26520dr);
                            if (textView4 != null) {
                                i3 = R.id.f70963mv;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.f70963mv);
                                if (imageView != null) {
                                    i3 = R.id.f776344w;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f776344w);
                                    if (frameLayout != null) {
                                        i3 = R.id.f7767450;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f7767450);
                                        if (linearLayout2 != null) {
                                            i3 = R.id.f81604em;
                                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f81604em);
                                            if (findChildViewById2 != null) {
                                                am e17 = am.e(findChildViewById2);
                                                i3 = R.id.f96455hq;
                                                View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.f96455hq);
                                                if (findChildViewById3 != null) {
                                                    return new an(view, linearLayout, e16, textView, textView2, textView3, textView4, imageView, frameLayout, linearLayout2, e17, am.e(findChildViewById3));
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static an f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hvw, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f420834a;
    }
}
