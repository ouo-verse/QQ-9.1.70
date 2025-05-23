package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeConnectInviteView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bi implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399098a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f399099b;

    /* renamed from: c, reason: collision with root package name */
    public final RelativeLayout f399100c;

    /* renamed from: d, reason: collision with root package name */
    public final MiniHomeConnectInviteView f399101d;

    /* renamed from: e, reason: collision with root package name */
    public final RelativeLayout f399102e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f399103f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f399104g;

    /* renamed from: h, reason: collision with root package name */
    public final RelativeLayout f399105h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f399106i;

    /* renamed from: j, reason: collision with root package name */
    public final RelativeLayout f399107j;

    bi(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, MiniHomeConnectInviteView miniHomeConnectInviteView, RelativeLayout relativeLayout3, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout4, TextView textView, RelativeLayout relativeLayout5) {
        this.f399098a = constraintLayout;
        this.f399099b = relativeLayout;
        this.f399100c = relativeLayout2;
        this.f399101d = miniHomeConnectInviteView;
        this.f399102e = relativeLayout3;
        this.f399103f = imageView;
        this.f399104g = imageView2;
        this.f399105h = relativeLayout4;
        this.f399106i = textView;
        this.f399107j = relativeLayout5;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399098a;
    }

    public static bi g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bi e(View view) {
        int i3 = R.id.pek;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.pek);
        if (relativeLayout != null) {
            i3 = R.id.q2i;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.q2i);
            if (relativeLayout2 != null) {
                i3 = R.id.q2j;
                MiniHomeConnectInviteView miniHomeConnectInviteView = (MiniHomeConnectInviteView) ViewBindings.findChildViewById(view, R.id.q2j);
                if (miniHomeConnectInviteView != null) {
                    i3 = R.id.q97;
                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.q97);
                    if (relativeLayout3 != null) {
                        i3 = R.id.qha;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.qha);
                        if (imageView != null) {
                            i3 = R.id.qr8;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.qr8);
                            if (imageView2 != null) {
                                i3 = R.id.qr_;
                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.qr_);
                                if (relativeLayout4 != null) {
                                    i3 = R.id.qrg;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qrg);
                                    if (textView != null) {
                                        i3 = R.id.f163560qs3;
                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f163560qs3);
                                        if (relativeLayout5 != null) {
                                            return new bi((ConstraintLayout) view, relativeLayout, relativeLayout2, miniHomeConnectInviteView, relativeLayout3, imageView, imageView2, relativeLayout4, textView, relativeLayout5);
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

    public static bi h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ddg, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
