package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class j implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FlexboxLayout f405379a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f405380b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405381c;

    j(@NonNull FlexboxLayout flexboxLayout, @NonNull View view, @NonNull TextView textView) {
        this.f405379a = flexboxLayout;
        this.f405380b = view;
        this.f405381c = textView;
    }

    @NonNull
    public static j e(@NonNull View view) {
        int i3 = R.id.bmt;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.bmt);
        if (findChildViewById != null) {
            i3 = R.id.title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
            if (textView != null) {
                return new j((FlexboxLayout) view, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static j g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hnt, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout getRoot() {
        return this.f405379a;
    }
}
