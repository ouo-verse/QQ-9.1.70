package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bm implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final RelativeLayout f399120a;

    /* renamed from: b, reason: collision with root package name */
    public final QQProAvatarView f399121b;

    /* renamed from: c, reason: collision with root package name */
    public final QUIButton f399122c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f399123d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399124e;

    bm(RelativeLayout relativeLayout, QQProAvatarView qQProAvatarView, QUIButton qUIButton, TextView textView, TextView textView2) {
        this.f399120a = relativeLayout;
        this.f399121b = qQProAvatarView;
        this.f399122c = qUIButton;
        this.f399123d = textView;
        this.f399124e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f399120a;
    }

    public static bm g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bm e(View view) {
        int i3 = R.id.pax;
        QQProAvatarView qQProAvatarView = (QQProAvatarView) ViewBindings.findChildViewById(view, R.id.pax);
        if (qQProAvatarView != null) {
            i3 = R.id.ph_;
            QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.ph_);
            if (qUIButton != null) {
                i3 = R.id.q_k;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.q_k);
                if (textView != null) {
                    i3 = R.id.f163506qh4;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f163506qh4);
                    if (textView2 != null) {
                        return new bm((RelativeLayout) view, qQProAvatarView, qUIButton, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static bm h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ddk, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}
