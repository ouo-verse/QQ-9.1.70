package ca1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f30497a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f30498b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RFWRoundImageView f30499c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f30500d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f30501e;

    c(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull RFWRoundImageView rFWRoundImageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f30497a = constraintLayout;
        this.f30498b = button;
        this.f30499c = rFWRoundImageView;
        this.f30500d = textView;
        this.f30501e = textView2;
    }

    @NonNull
    public static c e(@NonNull View view) {
        int i3 = R.id.af6;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.af6);
        if (button != null) {
            i3 = R.id.dvu;
            RFWRoundImageView rFWRoundImageView = (RFWRoundImageView) ViewBindings.findChildViewById(view, R.id.dvu);
            if (rFWRoundImageView != null) {
                i3 = R.id.j7y;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.j7y);
                if (textView != null) {
                    i3 = R.id.title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                    if (textView2 != null) {
                        return new c((ConstraintLayout) view, button, rFWRoundImageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static c g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fce, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f30497a;
    }
}
