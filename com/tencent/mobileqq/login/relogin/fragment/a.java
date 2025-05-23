package com.tencent.mobileqq.login.relogin.fragment;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.ColorRes;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&J$\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u00068\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/fragment/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "maskColorResId", "Le72/b;", "callback", "", "c", "", "fadeInDuration", "d", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)[I", "I", "b", "()I", "avatarTargetSize", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int avatarTargetSize;

    public a() {
        int dpToPx;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        if (MainResourceConfig.INSTANCE.i()) {
            dpToPx = ViewUtils.dpToPx(36.0f) - (ViewUtils.dpToPx(1.0f) * 2);
        } else {
            dpToPx = ViewUtils.dpToPx(36.0f);
        }
        this.avatarTargetSize = dpToPx;
    }

    @NotNull
    public final int[] a(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (int[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new int[]{(int) ((ViewUtils.dpToPx(16.0f) + (ViewUtils.dpToPx(36.0f) * 0.5f)) - (this.avatarTargetSize * 0.5f)), (int) ((ImmersiveUtils.getStatusBarHeight(context) + (context.getResources().getDimensionPixelSize(R.dimen.title_bar_height) * 0.5f)) - (this.avatarTargetSize * 0.5f))};
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.avatarTargetSize;
    }

    public abstract void c(@NotNull Activity activity, @NotNull View rootView, @ColorRes int maskColorResId, @Nullable e72.b callback);

    public abstract void d(@NotNull Activity activity, long fadeInDuration, @Nullable e72.b callback);
}
