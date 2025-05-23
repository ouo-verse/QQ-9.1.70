package p81;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tx.x2j.AioNotificationHeaderItemBinding;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class g implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f425739a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f425740b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f425741c;

    g(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f425739a = relativeLayout;
        this.f425740b = textView;
        this.f425741c = textView2;
    }

    @NonNull
    public static g e(@NonNull View view) {
        int i3 = R.id.sjc;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.sjc);
        if (textView != null) {
            i3 = R.id.sjd;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.sjd);
            if (textView2 != null) {
                return new g((RelativeLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static g g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioNotificationHeaderItemBinding aioNotificationHeaderItemBinding = new AioNotificationHeaderItemBinding();
        aioNotificationHeaderItemBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioNotificationHeaderItemBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dvw, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f425739a;
    }
}
