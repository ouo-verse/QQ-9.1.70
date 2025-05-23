package hn2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class m implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RadiusFrameLayout f405389a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f405390b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405391c;

    m(@NonNull RadiusFrameLayout radiusFrameLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f405389a = radiusFrameLayout;
        this.f405390b = textView;
        this.f405391c = textView2;
    }

    @NonNull
    public static m e(@NonNull View view) {
        int i3 = R.id.f1069069z;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f1069069z);
        if (textView != null) {
            i3 = R.id.f106946_3;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f106946_3);
            if (textView2 != null) {
                return new m((RadiusFrameLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static m g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f169070ho2, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RadiusFrameLayout getRoot() {
        return this.f405389a;
    }
}
