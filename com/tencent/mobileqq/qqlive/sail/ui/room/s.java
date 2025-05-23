package com.tencent.mobileqq.qqlive.sail.ui.room;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.displayview.IDisplayViewApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ(\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J \u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/s;", "", "Landroid/view/View;", "videoContainer", "", "orientation", "width", "height", "", "b", "a", "I", "videoLandscapeTopMargin", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final s f273162a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int videoLandscapeTopMargin;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53102);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f273162a = new s();
            videoLandscapeTopMargin = ((IDisplayViewApi) QRoute.api(IDisplayViewApi.class)).getHorizontalVideoTopMargin(true);
        }
    }

    s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@Nullable View videoContainer, int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, videoContainer, Integer.valueOf(width), Integer.valueOf(height));
            return;
        }
        if (videoContainer != null) {
            ViewGroup.LayoutParams layoutParams = videoContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            int screenWidth = ViewUtils.getScreenWidth();
            int screenHeight = ViewUtils.getScreenHeight();
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i("Audience|VideoLayoutAdjustmentHelper", "handleFolderScreenParams", "video width=" + width + ", video height=" + height + ", screenWidth=" + screenWidth + ", screenHeight=" + screenHeight);
            }
            if (width <= height) {
                z16 = false;
            }
            if (z16) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = videoLandscapeTopMargin;
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = ((IDisplayViewApi) QRoute.api(IDisplayViewApi.class)).getHorizontalVideoHeight(width, height);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (screenHeight * 0.5625f);
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
            }
        }
    }

    public final void b(@Nullable View videoContainer, int orientation, int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, videoContainer, Integer.valueOf(orientation), Integer.valueOf(width), Integer.valueOf(height));
            return;
        }
        if (videoContainer != null) {
            ViewGroup.LayoutParams layoutParams = videoContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            int screenWidth = ViewUtils.getScreenWidth();
            int screenHeight = ViewUtils.getScreenHeight();
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i("Audience|VideoLayoutAdjustmentHelper", "adjustOnNormalScreen", "video width=" + width + ", video height=" + height + ", screenWidth=" + screenWidth + ", screenHeight=" + screenHeight);
            }
            if (orientation != 1) {
                if (orientation != 2) {
                    companion.w("Audience|VideoLayoutAdjustmentHelper", "adjustForNormalScreen", "unknown orientation=" + orientation);
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = 0;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
                    layoutParams2.bottomToBottom = 0;
                }
            } else if (width > height) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = videoLandscapeTopMargin;
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = ((IDisplayViewApi) QRoute.api(IDisplayViewApi.class)).getHorizontalVideoHeight(width, height);
                layoutParams2.bottomToBottom = -1;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
                layoutParams2.bottomToBottom = 0;
            }
            videoContainer.setLayoutParams(layoutParams2);
        }
    }
}
