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
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f30482a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f30483b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QQProAvatarView f30484c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f30485d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f30486e;

    a(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull QQProAvatarView qQProAvatarView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f30482a = constraintLayout;
        this.f30483b = button;
        this.f30484c = qQProAvatarView;
        this.f30485d = textView;
        this.f30486e = textView2;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.af6;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.af6);
        if (button != null) {
            i3 = R.id.f165909du3;
            QQProAvatarView qQProAvatarView = (QQProAvatarView) ViewBindings.findChildViewById(view, R.id.f165909du3);
            if (qQProAvatarView != null) {
                i3 = R.id.j7y;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.j7y);
                if (textView != null) {
                    i3 = R.id.title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                    if (textView2 != null) {
                        return new a((ConstraintLayout) view, button, qQProAvatarView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dzj, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getMRv() {
        return this.f30482a;
    }
}
