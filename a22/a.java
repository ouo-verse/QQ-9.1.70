package a22;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.guild.aio.title.GuildImmersiveTitleBar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f25361a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f25362b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f25363c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f25364d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f25365e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final GuildImmersiveTitleBar f25366f;

    a(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull GuildImmersiveTitleBar guildImmersiveTitleBar) {
        this.f25361a = linearLayout;
        this.f25362b = linearLayout2;
        this.f25363c = imageView;
        this.f25364d = imageView2;
        this.f25365e = textView;
        this.f25366f = guildImmersiveTitleBar;
    }

    @NonNull
    public static a e(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.w2m;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.w2m);
        if (imageView != null) {
            i3 = R.id.w2o;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.w2o);
            if (imageView2 != null) {
                i3 = R.id.w2p;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.w2p);
                if (textView != null) {
                    i3 = R.id.xl7;
                    GuildImmersiveTitleBar guildImmersiveTitleBar = (GuildImmersiveTitleBar) ViewBindings.findChildViewById(view, R.id.xl7);
                    if (guildImmersiveTitleBar != null) {
                        return new a(linearLayout, linearLayout, imageView, imageView2, textView, guildImmersiveTitleBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.ext, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f25361a;
    }
}
