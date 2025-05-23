package com.tencent.mobileqq.flock.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001 B!\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001a\u001a\u00020\n\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u001b\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001b\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/flock/widget/AvatarView;", "Landroid/widget/FrameLayout;", "", "c", "", "isMulti", "g", "", "uin", "d", "", "avatarSize", "avatarBorderWidth", "setAvatarSize", tl.h.F, "I", "e", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "avatarBg", "avatarView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "i", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AvatarView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private static final int C;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    private static final int f210494m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int avatarSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int avatarBorderWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView avatarBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView avatarView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/flock/widget/AvatarView$a;", "", "", "DEFAULT_AVATAR_BORDER_WIDTH", "I", "DEFAULT_AVATAR_SIZE", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.widget.AvatarView$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49510);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        f210494m = ImmersiveUtils.dpToPx(20.0f);
        C = ImmersiveUtils.dpToPx(0.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.avatarSize = f210494m;
        this.avatarBorderWidth = C;
        LayoutInflater.from(context).inflate(R.layout.e7k, this);
        View findViewById = findViewById(R.id.f164546a31);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar_bg)");
        this.avatarBg = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f164551a35);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.avatar_img)");
        this.avatarView = (ImageView) findViewById2;
    }

    private final void c() {
        ImageView imageView = this.avatarBg;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            int i3 = this.avatarSize;
            int i16 = this.avatarBorderWidth;
            layoutParams2.width = (i16 * 2) + i3;
            layoutParams2.height = i3 + (i16 * 2);
            imageView.setLayoutParams(layoutParams2);
            ImageView imageView2 = this.avatarView;
            ViewGroup.LayoutParams layoutParams3 = imageView2.getLayoutParams();
            if (layoutParams3 != null) {
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                int i17 = this.avatarSize;
                layoutParams4.width = i17;
                layoutParams4.height = i17;
                imageView2.setLayoutParams(layoutParams4);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    private final void d(final String uin) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.flock.widget.a
            @Override // java.lang.Runnable
            public final void run() {
                AvatarView.e(uin, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String uin, final AvatarView this$0) {
        AppRuntime appRuntime;
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(1, 3);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime instanceof AppInterface) {
            appInterface = (AppInterface) appRuntime;
        } else {
            appInterface = null;
        }
        final FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(appInterface, 1, uin, 3, defaultDrawable, defaultDrawable, null);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.flock.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                AvatarView.f(AvatarView.this, faceDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AvatarView this$0, FaceDrawable faceDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.avatarView.setImageDrawable(faceDrawable);
    }

    private final void g(boolean isMulti) {
        int i3;
        ImageView imageView = this.avatarBg;
        if (isMulti) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public static /* synthetic */ void i(AvatarView avatarView, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        avatarView.h(str, z16);
    }

    public static /* synthetic */ void setAvatarSize$default(AvatarView avatarView, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = f210494m;
        }
        if ((i17 & 2) != 0) {
            i16 = C;
        }
        avatarView.setAvatarSize(i3, i16);
    }

    public final void h(@NotNull String uin, boolean isMulti) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, uin, Boolean.valueOf(isMulti));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        c();
        g(isMulti);
        d(uin);
    }

    public final void setAvatarSize(int avatarSize, int avatarBorderWidth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(avatarSize), Integer.valueOf(avatarBorderWidth));
        } else if (avatarSize >= 0 && avatarBorderWidth >= 0) {
            this.avatarSize = avatarSize;
            this.avatarBorderWidth = avatarBorderWidth;
            c();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
    }
}
