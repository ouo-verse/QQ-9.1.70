package com.tencent.mobileqq.ad.cardad.utils;

import android.content.Context;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.shake.GdtShakeSensor;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 '2\u00020\u0001:\u0002\f\u0003B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001b\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/utils/a;", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$OnShakeListener;", "", "b", "d", "g", "", "canShake", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lcom/tencent/mobileqq/ad/cardad/utils/a$b;", "shakeListener", "a", "e", "f", "c", "onShakeComplete", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor;", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor;", "mShakeSensor", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$Params;", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$Params;", "mShakeParams", h.F, "Z", "mCanShake", "i", "Lcom/tencent/gdtad/aditem/GdtAd;", "mGdtAd", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/ad/cardad/utils/a$b;", "mShakeListener", BdhLogUtil.LogTag.Tag_Conn, "mIsRegistered", "<init>", "(Landroid/content/Context;)V", "D", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a implements GdtShakeSensor.OnShakeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private volatile boolean mIsRegistered;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtShakeSensor mShakeSensor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtShakeSensor.Params mShakeParams;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mCanShake;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtAd mGdtAd;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mShakeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/utils/a$a;", "", "", "BIG_SHAKE_ICON_DISAPPEAR_ANIM_DURATION", "J", "BIG_SHAKE_ICON_DURATION_MS", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.cardad.utils.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/utils/a$b;", "", "", "onShakeComplete", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface b {
        void onShakeComplete();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26487);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext);
        } else {
            this.mContext = mContext;
        }
    }

    private final void b() {
        GdtAd gdtAd;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        if (this.mCanShake && (gdtAd = this.mGdtAd) != null) {
            if (gdtAd != null) {
                adInfo = gdtAd.info;
            } else {
                adInfo = null;
            }
            this.mShakeParams = new GdtShakeSensor.Params(adInfo);
        }
    }

    private final void d() {
        if (this.mIsRegistered) {
            return;
        }
        QLog.d("CardAdQQShopShakeHelper", 2, "register");
        GdtShakeSensor gdtShakeSensor = new GdtShakeSensor();
        gdtShakeSensor.setShakeFactor(this.mShakeParams);
        gdtShakeSensor.setShakeListener(new WeakReference<>(this));
        gdtShakeSensor.register(this.mContext);
        this.mShakeSensor = gdtShakeSensor;
        this.mIsRegistered = true;
    }

    private final void g() {
        if (!this.mIsRegistered) {
            return;
        }
        QLog.d("CardAdQQShopShakeHelper", 2, "unregister");
        GdtShakeSensor gdtShakeSensor = this.mShakeSensor;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.unregister(this.mContext);
        }
        this.mShakeSensor = null;
        this.mIsRegistered = false;
    }

    public final void a(boolean canShake, @NotNull GdtAd gdtAd, @Nullable b shakeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(canShake), gdtAd, shakeListener);
            return;
        }
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        this.mCanShake = canShake;
        this.mGdtAd = gdtAd;
        this.mShakeListener = shakeListener;
        b();
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        f();
        GdtShakeSensor gdtShakeSensor = this.mShakeSensor;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.reset();
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            d();
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            g();
        }
    }

    @Override // com.tencent.gdtad.views.shake.GdtShakeSensor.OnShakeListener
    public void onShakeComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.d("CardAdQQShopShakeHelper", 1, "onShakeComplete");
        b bVar = this.mShakeListener;
        if (bVar != null) {
            bVar.onShakeComplete();
        }
        GdtShakeSensor gdtShakeSensor = this.mShakeSensor;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.reset();
        }
        g();
    }
}
