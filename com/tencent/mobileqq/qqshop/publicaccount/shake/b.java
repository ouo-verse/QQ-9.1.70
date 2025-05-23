package com.tencent.mobileqq.qqshop.publicaccount.shake;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gdtad.basics.adshake.OnShakeListener;
import com.tencent.gdtad.basics.adshake.ShakeSensor;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.publicaccount.adapter.AdCardHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 -2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010'R\u0016\u0010*\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/shake/b;", "Landroid/os/Handler$Callback;", "", "l", "j", "", "d", "Landroid/content/Context;", "context", "i", h.F, "k", "g", "f", "e", "Landroid/os/Message;", "msg", "handleMessage", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdCardHolder;", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdCardHolder;", "cardHolder", "Landroid/os/Handler;", "Landroid/os/Handler;", "mainHandler", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$ShakeAdEffectBean;", "Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$ShakeAdEffectBean;", "shakeConfig", "Lcom/tencent/gdtad/basics/adshake/ShakeSensor;", "Lcom/tencent/gdtad/basics/adshake/ShakeSensor;", "shakeSensor", "", "D", "bigShakeIconDurationS", "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "smallShakeIconDrawable", BdhLogUtil.LogTag.Tag_Conn, "bigShakeIconDrawable", "Z", "isSmallShakeIconCanStart", "E", "isBigShakeIconCanStart", "<init>", "(Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdCardHolder;)V", UserInfo.SEX_FEMALE, "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private APNGDrawable bigShakeIconDrawable;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isSmallShakeIconCanStart;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isBigShakeIconCanStart;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AdCardHolder cardHolder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mainHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EcshopConfBean.ShakeAdEffectBean shakeConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ShakeSensor shakeSensor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private double bigShakeIconDurationS;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private APNGDrawable smallShakeIconDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/shake/b$a;", "", "", "BIG_SHAKE_ICON_DURATION_S_DEFAULT", "D", "", "MSG_HIDE_BIG_SHAKE_ICON", "I", "MSG_SHOW_BIG_SHAKE_ICON", "MSG_SHOW_SMALL_SHAKE_ICON", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.shake.b$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqshop/publicaccount/shake/b$b", "Lcom/tencent/gdtad/basics/adshake/OnShakeListener;", "", "shakeValue", "", "shakenCount", "", "onShaking", "onShakeComplete", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.shake.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8430b implements OnShakeListener {
        static IPatchRedirector $redirector_;

        C8430b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.gdtad.basics.adshake.OnShakeListener
        public void onShakeComplete(double shakeValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Double.valueOf(shakeValue));
                return;
            }
            QLog.d("AdShakeSensorWrapper", 1, "onShakeComplete: shakeValue " + shakeValue);
            if (!b.this.cardHolder.y() || !b.this.d()) {
                ShakeSensor shakeSensor = b.this.shakeSensor;
                if (shakeSensor != null) {
                    shakeSensor.reset();
                    return;
                }
                return;
            }
            b.this.cardHolder.R();
        }

        @Override // com.tencent.gdtad.basics.adshake.OnShakeListener
        public void onShaking(double shakeValue, int shakenCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Double.valueOf(shakeValue), Integer.valueOf(shakenCount));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34066);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull AdCardHolder cardHolder) {
        EcshopConfBean.ShakeAdEffectBean shakeAdEffectBean;
        Intrinsics.checkNotNullParameter(cardHolder, "cardHolder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cardHolder);
            return;
        }
        this.cardHolder = cardHolder;
        this.mainHandler = new Handler(Looper.getMainLooper(), this);
        EcshopConfBean ecshopConfBean = EcshopConfUtil.getEcshopConfBean();
        if (ecshopConfBean != null) {
            shakeAdEffectBean = ecshopConfBean.shakeAdEffectBean;
        } else {
            shakeAdEffectBean = null;
        }
        this.shakeConfig = shakeAdEffectBean == null ? new EcshopConfBean.ShakeAdEffectBean() : shakeAdEffectBean;
        this.bigShakeIconDurationS = 2.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d() {
        return GuardManager.sInstance.isApplicationForeground();
    }

    private final void j() {
        APNGDrawable aPNGDrawable = this.smallShakeIconDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.stop();
        }
        APNGDrawable aPNGDrawable2 = this.bigShakeIconDrawable;
        if (aPNGDrawable2 != null) {
            aPNGDrawable2.stop();
        }
    }

    private final void l() {
        EcshopConfBean.ShakeAdEffectBean shakeAdEffectBean = this.shakeConfig;
        String smallShakeIconUrl = shakeAdEffectBean.smallShakeUrl;
        String bigShakeIconUrl = shakeAdEffectBean.bigShakeUrl;
        IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
        Intrinsics.checkNotNullExpressionValue(smallShakeIconUrl, "smallShakeIconUrl");
        this.smallShakeIconDrawable = iVasApngFactory.getApngDrawable("AdShakeSensorWrapper", smallShakeIconUrl);
        IVasApngFactory iVasApngFactory2 = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
        Intrinsics.checkNotNullExpressionValue(bigShakeIconUrl, "bigShakeIconUrl");
        this.bigShakeIconDrawable = iVasApngFactory2.getApngDrawable("AdShakeSensorWrapper", bigShakeIconUrl);
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        k();
        this.shakeSensor = null;
        this.mainHandler.removeCallbacksAndMessages(null);
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            k();
            j();
        }
    }

    public final void g() {
        APNGDrawable aPNGDrawable;
        APNGDrawable aPNGDrawable2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.isBigShakeIconCanStart && (aPNGDrawable2 = this.bigShakeIconDrawable) != null) {
            aPNGDrawable2.start();
        }
        if (this.isSmallShakeIconCanStart && (aPNGDrawable = this.smallShakeIconDrawable) != null) {
            aPNGDrawable.start();
        }
    }

    public final void h(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this.shakeConfig.isValid()) {
            return;
        }
        ShakeSensor shakeSensor = this.shakeSensor;
        if (shakeSensor != null) {
            shakeSensor.setShakeListener(null);
        }
        EcshopConfBean.ShakeAdEffectBean shakeAdEffectBean = this.shakeConfig;
        ShakeSensor shakeSensor2 = new ShakeSensor(context, shakeAdEffectBean.shakeAcceleration / 100, shakeAdEffectBean.shakeMinCount);
        EcshopConfBean.ShakeAdEffectBean shakeAdEffectBean2 = this.shakeConfig;
        shakeSensor2.setShakeFactor(shakeAdEffectBean2.shakeAxisX, shakeAdEffectBean2.shakeAxisY, shakeAdEffectBean2.shakeAxisZ);
        shakeSensor2.setShakeListener(new C8430b());
        shakeSensor2.register();
        this.shakeSensor = shakeSensor2;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d("AdCardHolder", 2, "handleMessage: msg what " + msg2.what);
        int i3 = msg2.what;
        if (i3 != 1) {
            if (i3 != 2) {
                return false;
            }
            APNGDrawable aPNGDrawable = this.bigShakeIconDrawable;
            if (aPNGDrawable != null) {
                aPNGDrawable.stop();
            }
            this.cardHolder.x();
            this.isBigShakeIconCanStart = false;
        } else {
            APNGDrawable aPNGDrawable2 = this.bigShakeIconDrawable;
            if (aPNGDrawable2 != null) {
                this.cardHolder.N(aPNGDrawable2);
                this.mainHandler.sendEmptyMessageDelayed(2, a.f274656a.d(this.bigShakeIconDurationS));
            }
            this.isBigShakeIconCanStart = true;
            APNGDrawable aPNGDrawable3 = this.smallShakeIconDrawable;
            if (aPNGDrawable3 != null) {
                this.cardHolder.P(aPNGDrawable3);
            }
            this.isSmallShakeIconCanStart = true;
        }
        return true;
    }

    public final void i(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        h(context);
        l();
        double d16 = this.shakeConfig.shakeStayTime;
        if (d16 > 0.0d) {
            this.bigShakeIconDurationS = d16;
        }
        this.mainHandler.sendEmptyMessage(1);
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ShakeSensor shakeSensor = this.shakeSensor;
        if (shakeSensor != null) {
            shakeSensor.unregister();
        }
        this.shakeSensor = null;
    }
}
