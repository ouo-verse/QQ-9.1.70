package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class y implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f421163a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final AvatarRoundImageView f421164b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f421165c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f421166d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f421167e;

    y(@NonNull FrameLayout frameLayout, @NonNull AvatarRoundImageView avatarRoundImageView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3) {
        this.f421163a = frameLayout;
        this.f421164b = avatarRoundImageView;
        this.f421165c = imageView;
        this.f421166d = imageView2;
        this.f421167e = imageView3;
    }

    @NonNull
    public static y e(@NonNull View view) {
        int i3 = R.id.a2o;
        AvatarRoundImageView avatarRoundImageView = (AvatarRoundImageView) ViewBindings.findChildViewById(view, R.id.a2o);
        if (avatarRoundImageView != null) {
            i3 = R.id.close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.close);
            if (imageView != null) {
                i3 = R.id.bat;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.bat);
                if (imageView2 != null) {
                    i3 = R.id.z5z;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.z5z);
                    if (imageView3 != null) {
                        return new y((FrameLayout) view, avatarRoundImageView, imageView, imageView2, imageView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static y g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f169115hu0, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f421163a;
    }
}
