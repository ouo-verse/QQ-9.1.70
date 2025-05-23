package com.tencent.mobileqq.aio.msglist.holder.component.video;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J,\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoStateIconView;", "Landroid/widget/LinearLayout;", "", "id", "Landroid/graphics/drawable/Drawable;", "a", "b", "c", "icon", "Lkotlin/Pair;", "iconSizeDp", "", "text", "", "setContent", "f", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/VideoErrorStatus;", "errorStatus", "e", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "textView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOVideoStateIconView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView iconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView textView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoStateIconView$a;", "", "", "TAG", "Ljava/lang/String;", "", "TEXT_MARGIN_DP", "I", "TEXT_TOP_MARGIN_DP", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoStateIconView$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192187a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63945);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[VideoErrorStatus.values().length];
            try {
                iArr[VideoErrorStatus.Expired.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoErrorStatus.Failed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f192187a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63946);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOVideoStateIconView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        setGravity(17);
        setOrientation(1);
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.sk9);
        addView(imageView, new LinearLayout.LayoutParams(-2, -2));
        this.iconView = imageView;
        TextView textView = new TextView(context);
        textView.setId(R.id.ska);
        textView.setMaxLines(1);
        textView.setGravity(17);
        textView.setTextColor(context.getResources().getColor(R.color.qui_common_text_tertiary));
        textView.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = 7;
        layoutParams.leftMargin = 10;
        layoutParams.rightMargin = 10;
        Unit unit = Unit.INSTANCE;
        addView(textView, layoutParams);
        this.textView = textView;
    }

    private final Drawable a(int id5) {
        return ResourcesCompat.getDrawable(getContext().getResources(), id5, getContext().getTheme());
    }

    private final Drawable b() {
        return a(R.drawable.j9q);
    }

    private final Drawable c() {
        return a(R.drawable.qui_aio_fail_icon);
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            setVisibility(8);
        }
    }

    public final void e(@NotNull VideoErrorStatus errorStatus, @NotNull String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) errorStatus, (Object) text);
            return;
        }
        Intrinsics.checkNotNullParameter(errorStatus, "errorStatus");
        Intrinsics.checkNotNullParameter(text, "text");
        setVisibility(0);
        TextView textView = this.textView;
        if (TextUtils.isEmpty(text)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(text);
        }
        int i3 = b.f192187a[errorStatus.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                this.iconView.setImageDrawable(b());
            } else {
                this.iconView.setImageDrawable(c());
            }
        } else {
            this.iconView.setImageDrawable(b());
        }
        ImageView imageView = this.iconView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = com.tencent.mobileqq.aio.utils.p.c(23);
        layoutParams.height = com.tencent.mobileqq.aio.utils.p.c(23);
        imageView.setLayoutParams(layoutParams);
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        setVisibility(0);
        this.textView.setVisibility(8);
        this.iconView.setVisibility(0);
        this.iconView.setImageDrawable(a(R.drawable.j9r));
        ImageView imageView = this.iconView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = com.tencent.mobileqq.aio.utils.p.c(56);
        layoutParams.height = com.tencent.mobileqq.aio.utils.p.c(56);
        imageView.setLayoutParams(layoutParams);
    }

    public final void setContent(@Nullable Drawable icon, @NotNull Pair<Integer, Integer> iconSizeDp, @NotNull String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, icon, iconSizeDp, text);
            return;
        }
        Intrinsics.checkNotNullParameter(iconSizeDp, "iconSizeDp");
        Intrinsics.checkNotNullParameter(text, "text");
        this.textView.setText(text);
        this.iconView.setImageDrawable(icon);
        ImageView imageView = this.iconView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = com.tencent.mobileqq.aio.utils.p.c(iconSizeDp.getFirst().intValue());
        layoutParams.height = com.tencent.mobileqq.aio.utils.p.c(iconSizeDp.getSecond().intValue());
        imageView.setLayoutParams(layoutParams);
    }
}
