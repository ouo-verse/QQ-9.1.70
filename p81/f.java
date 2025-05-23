package p81;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.notification.background.AIONotificationBlurView;
import com.tencent.mobileqq.aio.notification.list.AIONotificationScrollLayout;
import com.tx.x2j.AioNotificationContainerBinding;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f425731a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f425732b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f425733c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final NestedScrollView f425734d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RecyclerView f425735e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final AIONotificationScrollLayout f425736f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final AIONotificationBlurView f425737g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f425738h;

    f(@NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull NestedScrollView nestedScrollView, @NonNull RecyclerView recyclerView, @NonNull AIONotificationScrollLayout aIONotificationScrollLayout, @NonNull AIONotificationBlurView aIONotificationBlurView, @NonNull View view) {
        this.f425731a = frameLayout;
        this.f425732b = relativeLayout;
        this.f425733c = imageView;
        this.f425734d = nestedScrollView;
        this.f425735e = recyclerView;
        this.f425736f = aIONotificationScrollLayout;
        this.f425737g = aIONotificationBlurView;
        this.f425738h = view;
    }

    @NonNull
    public static f e(@NonNull View view) {
        int i3 = R.id.sj5;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.sj5);
        if (relativeLayout != null) {
            i3 = R.id.sj7;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.sj7);
            if (imageView != null) {
                i3 = R.id.sj8;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.sj8);
                if (nestedScrollView != null) {
                    i3 = R.id.sj9;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.sj9);
                    if (recyclerView != null) {
                        i3 = R.id.sj_;
                        AIONotificationScrollLayout aIONotificationScrollLayout = (AIONotificationScrollLayout) ViewBindings.findChildViewById(view, R.id.sj_);
                        if (aIONotificationScrollLayout != null) {
                            i3 = R.id.t97;
                            AIONotificationBlurView aIONotificationBlurView = (AIONotificationBlurView) ViewBindings.findChildViewById(view, R.id.t97);
                            if (aIONotificationBlurView != null) {
                                i3 = R.id.gm7;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.gm7);
                                if (findChildViewById != null) {
                                    return new f((FrameLayout) view, relativeLayout, imageView, nestedScrollView, recyclerView, aIONotificationScrollLayout, aIONotificationBlurView, findChildViewById);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static f g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioNotificationContainerBinding aioNotificationContainerBinding = new AioNotificationContainerBinding();
        aioNotificationContainerBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioNotificationContainerBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dvv, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getMRv() {
        return this.f425731a;
    }
}
