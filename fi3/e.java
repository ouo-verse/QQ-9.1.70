package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.state.view.CircleBoarderImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f399249a;

    /* renamed from: b, reason: collision with root package name */
    public final CircleBoarderImageView f399250b;

    /* renamed from: c, reason: collision with root package name */
    public final CircleBoarderImageView f399251c;

    /* renamed from: d, reason: collision with root package name */
    public final CircleBoarderImageView f399252d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399253e;

    e(LinearLayout linearLayout, CircleBoarderImageView circleBoarderImageView, CircleBoarderImageView circleBoarderImageView2, CircleBoarderImageView circleBoarderImageView3, TextView textView) {
        this.f399249a = linearLayout;
        this.f399250b = circleBoarderImageView;
        this.f399251c = circleBoarderImageView2;
        this.f399252d = circleBoarderImageView3;
        this.f399253e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f399249a;
    }

    public static e g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static e e(View view) {
        int i3 = R.id.pbe;
        CircleBoarderImageView circleBoarderImageView = (CircleBoarderImageView) ViewBindings.findChildViewById(view, R.id.pbe);
        if (circleBoarderImageView != null) {
            i3 = R.id.pbf;
            CircleBoarderImageView circleBoarderImageView2 = (CircleBoarderImageView) ViewBindings.findChildViewById(view, R.id.pbf);
            if (circleBoarderImageView2 != null) {
                i3 = R.id.pbg;
                CircleBoarderImageView circleBoarderImageView3 = (CircleBoarderImageView) ViewBindings.findChildViewById(view, R.id.pbg);
                if (circleBoarderImageView3 != null) {
                    i3 = R.id.f163556qr4;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f163556qr4);
                    if (textView != null) {
                        return new e((LinearLayout) view, circleBoarderImageView, circleBoarderImageView2, circleBoarderImageView3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static e h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d4_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
