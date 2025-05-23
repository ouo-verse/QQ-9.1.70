package com.tencent.qqnt.aio.api.impl;

import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOBlurApi;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOBlurApiImpl;", "Lcom/tencent/qqnt/aio/api/IAIOBlurApi;", "", "isNotSupportDevice", "Lcom/tencent/qqnt/aio/data/b;", "param", "enableBlur", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOBlurApiImpl implements IAIOBlurApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AIOBlurApiImpl";

    @NotNull
    private static final Lazy<Boolean> switch$delegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOBlurApiImpl$a;", "", "", "switch$delegate", "Lkotlin/Lazy;", "b", "()Z", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.impl.AIOBlurApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) AIOBlurApiImpl.switch$delegate.getValue()).booleanValue();
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
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63302);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AIOBlurApiImpl$Companion$switch$2.INSTANCE);
        switch$delegate = lazy;
    }

    public AIOBlurApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean isNotSupportDevice() {
        if (!INSTANCE.b() || PadUtil.a(BaseApplication.context) != DeviceType.TABLET) {
            return false;
        }
        if (com.tencent.common.config.pad.d.d()) {
            QLog.i(TAG, 1, "[isNotSupportDevice]: huawei pad");
            return true;
        }
        if (!com.tencent.common.config.pad.c.c()) {
            return false;
        }
        QLog.i(TAG, 1, "[isNotSupportDevice]: honor pad");
        return true;
    }

    @Override // com.tencent.qqnt.aio.api.IAIOBlurApi
    public boolean enableBlur(@NotNull com.tencent.qqnt.aio.data.b param) {
        String str;
        BaseApplication baseApplication;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) param)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Integer a16 = param.a();
        if (a16 == null) {
            return false;
        }
        if (a16.intValue() != 2 && a16.intValue() != 1 && a16.intValue() != 104 && a16.intValue() != 111 && a16.intValue() != 106 && a16.intValue() != 105 && a16.intValue() != 101 && a16.intValue() != 100 && a16.intValue() != 117 && a16.intValue() != 102) {
            return false;
        }
        IRobotServiceApi iRobotServiceApi = (IRobotServiceApi) QRoute.api(IRobotServiceApi.class);
        Long b16 = param.b();
        if (b16 != null) {
            str = b16.toString();
        } else {
            str = null;
        }
        if (iRobotServiceApi.isRobotAIO(str, a16) || isNotSupportDevice()) {
            return false;
        }
        if ((!QQTheme.isDefaultOrDIYTheme() && (!QQTheme.isNowThemeDefaultNight() || !((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("aio_night_blur_908_118374089", true))) || (baseApplication = BaseApplication.context) == null || !com.tencent.qui.quiblurview.c.f363628c.b(baseApplication)) {
            return false;
        }
        return true;
    }
}
