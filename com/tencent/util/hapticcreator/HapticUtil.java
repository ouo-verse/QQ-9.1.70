package com.tencent.util.hapticcreator;

import android.content.Context;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.mtgpa.haptic.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\f\u001a\u00020\tR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/util/hapticcreator/HapticUtil;", "", "Landroid/content/Context;", "context", "", "init", "isExperiment", "Landroid/view/View;", "view", "", "play", "playActually", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "TAG", "Ljava/lang/String;", "playJson", "Lcom/tencent/mtgpa/haptic/a;", "hapticPlayer", "Lcom/tencent/mtgpa/haptic/a;", "Z", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class HapticUtil {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final HapticUtil INSTANCE;

    @NotNull
    private static final String TAG = "HapticUtil";

    @NotNull
    private static final a hapticPlayer;
    private static boolean init = false;

    @NotNull
    private static final String playJson = "{\n  \"Pattern\" : [\n    {\n      \"Event\" : {\n        \"Parameters\" : {\n          \"Frequency\" : 30,\n          \"Intensity\" : 100\n        },\n        \"RelativeTime\" : 0,\n        \"Type\" : \"transient\"\n      }\n    }\n  ]\n}";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34724);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new HapticUtil();
            hapticPlayer = new a();
        }
    }

    HapticUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean init(Context context) {
        boolean z16 = init;
        if (z16) {
            return z16;
        }
        if (context != null) {
            init = true;
            try {
                hapticPlayer.c(context);
            } catch (Exception e16) {
                QLog.i(TAG, 1, "HapticPlayer init fail:" + e16);
                init = false;
            }
        }
        return init;
    }

    public final boolean isExperiment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (!ABTestController.getInstance().isTabSDKInited()) {
            return false;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(QCommonOnlineExpProviderImpl.EXP_EXP_QQ_ZHENGAN);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance()\n          \u2026rImpl.EXP_EXP_QQ_ZHENGAN)");
        expEntity.reportExpExposure();
        return expEntity.isExperiment(QCommonOnlineExpProviderImpl.EXP_EXP_QQ_ZHENGAN_B);
    }

    public final void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public final void play(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            if (!isExperiment()) {
                return;
            }
            playActually(view);
        }
    }

    public final void playActually(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication != null) {
            if (view != null) {
                view.setHapticFeedbackEnabled(false);
            }
            if (INSTANCE.init(baseApplication)) {
                try {
                    hapticPlayer.a(playJson);
                } catch (Exception e16) {
                    QLog.i(TAG, 1, "HapticPlayer play fail:" + e16);
                }
            }
        }
    }
}
