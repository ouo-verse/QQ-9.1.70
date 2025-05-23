package com.tencent.mobileqq.qqlive.api.displayview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/displayview/IDisplayViewApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "enableHorizontalVideoSeamless", "", "getHorizontalVideoHeight", "", "videoWidth", "videoHeight", "getHorizontalVideoTopMargin", "containStatusBar", "Companion", "qq-live-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IDisplayViewApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int LANDSCAPE_VIDEO_DEFAULT_HEIGHT = 1080;
    public static final int LANDSCAPE_VIDEO_DEFAULT_WIDTH = 1920;
    public static final float LANDSCAPE_VIDEO_TOP_MARGIN_CONTAIN_STATUS_BAR_DP = 168.0f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/displayview/IDisplayViewApi$Companion;", "", "()V", "LANDSCAPE_VIDEO_DEFAULT_HEIGHT", "", "LANDSCAPE_VIDEO_DEFAULT_WIDTH", "LANDSCAPE_VIDEO_TOP_MARGIN_CONTAIN_STATUS_BAR_DP", "", "qq-live-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        static IPatchRedirector $redirector_ = null;
        public static final int LANDSCAPE_VIDEO_DEFAULT_HEIGHT = 1080;
        public static final int LANDSCAPE_VIDEO_DEFAULT_WIDTH = 1920;
        public static final float LANDSCAPE_VIDEO_TOP_MARGIN_CONTAIN_STATUS_BAR_DP = 168.0f;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21172);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                $$INSTANCE = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(21174), (Class<?>) IDisplayViewApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.$$INSTANCE;
        }
    }

    boolean enableHorizontalVideoSeamless();

    int getHorizontalVideoHeight(int videoWidth, int videoHeight);

    int getHorizontalVideoTopMargin(boolean containStatusBar);
}
