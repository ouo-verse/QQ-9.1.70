package com.tencent.mobileqq.splashad;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IRealTimeConfigApi;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splash.c;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.SplashShowException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0007J*\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0007J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0011J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0016J\u0016\u0010(\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\rR\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/splashad/l;", "Landroid/os/Handler$Callback;", "Lcom/tencent/mobileqq/splash/c$a;", "", "l", "Lmqq/app/AppActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/splashad/SplashWidget;", "splashWidget", "isColdStartup", "Lcom/tencent/mobileqq/splash/a;", "splashPreloadCallback", "j", "", "what", "", "delayMillis", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, tl.h.F, "o", "callback", "r", "Lcom/tencent/mobileqq/splash/b;", "finishCallBack", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "duration", "onDurationUpdate", "delay", "a", "Lcom/tencent/mobileqq/splash/c;", "splashCallBack", "b", "c", "Landroid/os/Message;", "msg", "handleMessage", "type", "time", DomainData.DOMAIN_NAME, "g", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "mUiHandler", "Lcom/tencent/mobileqq/splashad/r;", "f", "Lcom/tencent/mobileqq/splashad/r;", "mSplashStrategy", "Lcom/tencent/mobileqq/splashad/processor/a;", "Lcom/tencent/mobileqq/splashad/processor/a;", "mDefaultSplashProcessor", "i", "Lcom/tencent/mobileqq/splash/c;", "mSplashCallback", "Lcom/tencent/mobileqq/splash/a;", "mSplashPreloadCallback", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/splash/b;", "mResultListener", "D", "J", "mDuration", "E", "Z", "mHasBizSplash", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class l implements Handler.Callback, c.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.splash.b mResultListener;

    /* renamed from: D, reason: from kotlin metadata */
    private static long mDuration;

    /* renamed from: E, reason: from kotlin metadata */
    private static boolean mHasBizSplash;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final l f288780d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler mUiHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final r mSplashStrategy;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.splashad.processor.a mDefaultSplashProcessor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.splash.c mSplashCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.splash.a mSplashPreloadCallback;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60493);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        l lVar = new l();
        f288780d = lVar;
        mUiHandler = new Handler(Looper.getMainLooper(), lVar);
        mSplashStrategy = new r();
        mDefaultSplashProcessor = new com.tencent.mobileqq.splashad.processor.a();
    }

    l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void h() {
        QLog.i("SplashController", 1, "destroy!");
        mSplashCallback = null;
        mResultListener = null;
        final SplashADView n3 = SplashADView.n(null, null);
        if (n3 != null) {
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.splashad.j
                @Override // java.lang.Runnable
                public final void run() {
                    l.i(SplashADView.this);
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(SplashADView splashADView) {
        splashADView.O();
    }

    private final boolean j(AppActivity activity, SplashWidget splashWidget, boolean isColdStartup, com.tencent.mobileqq.splash.a splashPreloadCallback) {
        boolean z16;
        mSplashPreloadCallback = splashPreloadCallback;
        List<com.tencent.mobileqq.splashad.processor.d> c16 = mSplashStrategy.c(isColdStartup);
        if (c16.size() > 1) {
            final ArrayList<Integer> splashAdPriority = ((IGdtAPI) QRoute.api(IGdtAPI.class)).getSplashAdPriority();
            Collections.sort(c16, new Comparator() { // from class: com.tencent.mobileqq.splashad.i
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int k3;
                    k3 = l.k(splashAdPriority, (com.tencent.mobileqq.splashad.processor.d) obj, (com.tencent.mobileqq.splashad.processor.d) obj2);
                    return k3;
                }
            });
        }
        boolean z17 = true;
        for (com.tencent.mobileqq.splashad.processor.d dVar : c16) {
            try {
                Integer bizType = dVar.getBizType();
                Intrinsics.checkNotNullExpressionValue(bizType, "bizType");
                if (!SplashADUtil.x(bizType.intValue(), isColdStartup) || dVar.a()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!isColdStartup) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    dVar.c(z16);
                    try {
                        boolean b16 = dVar.b(activity, splashWidget, this, splashPreloadCallback);
                        QLog.d("SplashController", 1, dVar.getTag() + " process cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", result:" + b16);
                        if (b16) {
                            if (!dVar.a()) {
                                onDurationUpdate(1500L);
                                if (bizType.intValue() == 4) {
                                    z17 = false;
                                } else {
                                    SplashADUtil.E(bizType.intValue(), isColdStartup);
                                }
                            } else {
                                onDurationUpdate(((IRealTimeConfigApi) QRoute.api(IRealTimeConfigApi.class)).getRealTimeSplashDelayTime());
                            }
                            mHasBizSplash = true;
                            break;
                        }
                        continue;
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e("QSplash@VasSplashUtil", 1, "show SplashAd initView error ", e);
                    }
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        SplashEmptyReportHelper.f288736a.b();
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(ArrayList arrayList, com.tencent.mobileqq.splashad.processor.d dVar, com.tencent.mobileqq.splashad.processor.d dVar2) {
        return Intrinsics.compare(arrayList.indexOf(dVar.getBizType()), arrayList.indexOf(dVar2.getBizType()));
    }

    @JvmStatic
    public static final boolean l() {
        return mHasBizSplash;
    }

    @JvmStatic
    public static final void o() {
        ThreadManager.getFileThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.splashad.k
            @Override // java.lang.Runnable
            public final void run() {
                l.p();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU)");
        from.encodeLong("splashshowtime", timeInMillis);
        if (QLog.isColorLevel()) {
            QLog.d("SplashController", 2, "\u663e\u793a\u4e86\u4e00\u4e2a\u975e\u9ed8\u8ba4\u95ea\u5c4f\u65f6\u95f4\u662f" + calendar);
        }
    }

    private final void q(int what, long delayMillis) {
        Handler handler = mUiHandler;
        handler.removeMessages(what);
        handler.sendEmptyMessageDelayed(what, delayMillis);
    }

    @Override // com.tencent.mobileqq.splash.c.a
    public void a(long delay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, delay);
        } else {
            q(1002, delay);
        }
    }

    @Override // com.tencent.mobileqq.splash.c.a
    public void b(@NotNull com.tencent.mobileqq.splash.c splashCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) splashCallBack);
        } else {
            Intrinsics.checkNotNullParameter(splashCallBack, "splashCallBack");
            mSplashCallback = splashCallBack;
        }
    }

    @Override // com.tencent.mobileqq.splash.c.a
    public void c(long delay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, delay);
            return;
        }
        if (mResultListener == null) {
            QLog.i("SplashController", 1, "onSplashShow, cancel");
            return;
        }
        QLog.i("SplashController", 1, "onSplashShow, delay:" + delay);
        q(1001, 0L);
    }

    public final void g(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, type);
        } else {
            mSplashStrategy.b(type);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        switch (msg2.what) {
            case 1001:
                QLog.i("SplashController", 1, "start show splash, duration:" + mDuration);
                com.tencent.mobileqq.splash.c cVar = mSplashCallback;
                if (cVar == null) {
                    mDuration = 0L;
                }
                if (cVar != null) {
                    try {
                        cVar.a(this);
                    } catch (Exception e16) {
                        mDuration = 0L;
                        QLog.e("SplashController", 1, "error occur while bindView ", e16);
                        SplashShowException splashShowException = new SplashShowException("bindView", e16);
                        String message = e16.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        com.tencent.qqperf.monitor.crash.catchedexception.a.c(splashShowException, message);
                    }
                }
                q(1002, mDuration);
                break;
            case 1002:
                QLog.i("SplashController", 1, "finish show splash, duration:" + mDuration + ", listener:" + mResultListener);
                com.tencent.mobileqq.splash.c cVar2 = mSplashCallback;
                if (cVar2 != null) {
                    cVar2.b();
                }
                com.tencent.mobileqq.splash.b bVar = mResultListener;
                if (bVar != null) {
                    bVar.onCompleted((int) mDuration);
                }
                h();
                break;
            case 1003:
                com.tencent.mobileqq.splash.c cVar3 = mSplashCallback;
                if (cVar3 != null) {
                    cVar3.c();
                    break;
                }
                break;
        }
        return true;
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            q(1003, 0L);
        }
    }

    public final void n(int type, long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(type), Long.valueOf(time));
        } else {
            mSplashStrategy.f(type, time);
        }
    }

    @Override // com.tencent.mobileqq.splash.c.a
    public void onDurationUpdate(long duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, duration);
        } else {
            mDuration = duration;
        }
    }

    public final boolean r(@NotNull AppActivity activity, boolean isColdStartup, @Nullable com.tencent.mobileqq.splash.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, activity, Boolean.valueOf(isColdStartup), callback)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        mHasBizSplash = false;
        SplashWidget splashWidget = new SplashWidget(activity);
        try {
            Intent intent = activity.getIntent();
            if (intent != null) {
                if (intent.getBooleanExtra("switch_account_restart_disable_splash", false)) {
                    z16 = true;
                }
            }
        } catch (Exception e16) {
            QLog.e("SplashController", 1, "setupSplash intent getBoolean exception: ", e16);
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("SplashController", 2, "switch account restart disable biz splash");
            }
            mDefaultSplashProcessor.b(activity, splashWidget, null, callback);
            com.tencent.mobileqq.startup.a.f289677r = true;
        } else if (j(activity, splashWidget, isColdStartup, callback)) {
            mDefaultSplashProcessor.b(activity, splashWidget, null, callback);
        }
        return mHasBizSplash;
    }

    public final void s(@NotNull com.tencent.mobileqq.splash.b finishCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) finishCallBack);
            return;
        }
        Intrinsics.checkNotNullParameter(finishCallBack, "finishCallBack");
        mResultListener = finishCallBack;
        q(1001, mDuration);
    }
}
