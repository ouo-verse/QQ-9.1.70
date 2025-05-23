package com.tencent.mobileqq.qqlive.huya;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huya.huyasdk.api.HuyaLiveRoom;
import com.huya.huyasdk.api.HuyaLiveStream;
import com.huya.huyasdk.api.HuyaSdk;
import com.huya.huyasdk.api.HuyaStatisticLive;
import com.huya.huyasdk.api.IHYLogger;
import com.huya.huyasdk.api.LifecycleApi;
import com.huya.huyasdk.api.UrlCallback;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\b\u0004\n\u0002\b\u0007*\u0002#'\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J.\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\nJ,\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018J\"\u0010\u001d\u001a\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012R\u0016\u0010\"\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYa;", "", "", "l", "p", "", "originUrl", "Lcom/tencent/mobileqq/qqlive/huya/d;", "callback", "i", "", "uid", "Lkotlin/Function0;", "success", "failed", "f", "g", "presenterUid", "", "gameTypeId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqlive/huya/b;", "barrageInfo", "Lkotlin/Function2;", "", "o", "invoke", HippyReporter.RemoveEngineReason.INVALID, "e", "ratio", tl.h.F, "b", "Z", "sdkEnabled", "com/tencent/mobileqq/qqlive/huya/QQLiveHuYa$receiver$1", "c", "Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYa$receiver$1;", "receiver", "com/tencent/mobileqq/qqlive/huya/QQLiveHuYa$a", "d", "Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYa$a;", "logger", "<init>", "()V", "qq-live-huya_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveHuYa {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQLiveHuYa f271333a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean sdkEnabled;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final QQLiveHuYa$receiver$1 receiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a logger;

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/qqlive/huya/QQLiveHuYa$a", "Lcom/huya/huyasdk/api/IHYLogger;", "", "tag", "", "msg", "", "debug", "info", "error", "", "t", "uncaughtException", "flushToDisk", "", "level", "", "isLogLevelEnabled", "qq-live-huya_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements IHYLogger {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.huya.huyasdk.api.IHYLogger
        public void debug(@Nullable Object tag, @Nullable String msg2) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, tag, (Object) msg2);
                return;
            }
            if (QLog.isColorLevel()) {
                if (tag instanceof String) {
                    str = (String) tag;
                } else {
                    str = null;
                }
                String str2 = "QQLiveHuYa_SDK_" + str;
                if (msg2 == null) {
                    msg2 = "";
                }
                QLog.d(str2, 4, msg2);
            }
        }

        @Override // com.huya.huyasdk.api.IHYLogger
        public void error(@Nullable Object tag, @Nullable String msg2) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, tag, (Object) msg2);
                return;
            }
            if (tag instanceof String) {
                str = (String) tag;
            } else {
                str = null;
            }
            String str2 = "QQLiveHuYa_SDK_" + str;
            if (msg2 == null) {
                msg2 = "";
            }
            QLog.e(str2, 1, msg2);
        }

        @Override // com.huya.huyasdk.api.IHYLogger
        public void flushToDisk() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.huya.huyasdk.api.IHYLogger
        public void info(@Nullable Object tag, @Nullable String msg2) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, tag, (Object) msg2);
                return;
            }
            if (tag instanceof String) {
                str = (String) tag;
            } else {
                str = null;
            }
            String str2 = "QQLiveHuYa_SDK_" + str;
            if (msg2 == null) {
                msg2 = "";
            }
            QLog.i(str2, 2, msg2);
        }

        @Override // com.huya.huyasdk.api.IHYLogger
        public boolean isLogLevelEnabled(int level) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, level)).booleanValue();
            }
            return true;
        }

        @Override // com.huya.huyasdk.api.IHYLogger
        public void uncaughtException(@Nullable Throwable t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) t16);
            } else {
                QLog.e("QQLiveHuYa_SDK", 1, t16, new Object[0]);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.mobileqq.qqlive.huya.QQLiveHuYa$receiver$1] */
    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32987);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        QQLiveHuYa qQLiveHuYa = new QQLiveHuYa();
        f271333a = qQLiveHuYa;
        receiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qqlive.huya.QQLiveHuYa$receiver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                m mVar = m.f271359a;
                z16 = QQLiveHuYa.sdkEnabled;
                mVar.i(z16);
            }
        };
        logger = new a();
        qQLiveHuYa.p();
    }

    QQLiveHuYa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final String originUrl, final d dVar) {
        Intrinsics.checkNotNullParameter(originUrl, "$originUrl");
        HuyaLiveStream.refreshTokenWithStreamUrl(originUrl, new UrlCallback() { // from class: com.tencent.mobileqq.qqlive.huya.g
            @Override // com.huya.huyasdk.api.UrlCallback
            public final void onUrlCallback(String str, Throwable th5) {
                QQLiveHuYa.k(originUrl, dVar, str, th5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(String originUrl, d dVar, String str, Throwable th5) {
        String str2;
        Intrinsics.checkNotNullParameter(originUrl, "$originUrl");
        if (th5 != null) {
            str2 = th5.getMessage();
        } else {
            str2 = null;
        }
        QLog.d("QQLiveHuYa", 2, "refresh originUrl: " + originUrl + " urlWithToken:" + str + " throwable:" + str2);
        if (dVar != null) {
            dVar.onUrlCallback(str);
        }
    }

    private final void l() {
        if (BaseApplication.getContext() != null && BaseApplication.getContext().getContentResolver() != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NewIntent.ACTION_LOGIN);
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
            MobileQQ.sMobileQQ.registerReceiver(receiver, intentFilter);
        }
    }

    private final void p() {
        QLog.i("QQLiveHuYa", 1, "setupHuYa");
        j jVar = (j) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("102401");
        boolean z16 = false;
        if (jVar != null && jVar.b()) {
            z16 = true;
        }
        if (z16) {
            try {
                HuyaSdk.setup(BaseApplication.getContext().getApplicationContext(), "huyasdk_qq_adr", logger, new LifecycleApi() { // from class: com.tencent.mobileqq.qqlive.huya.f
                    @Override // com.huya.huyasdk.api.LifecycleApi
                    public final boolean isForeGround() {
                        boolean q16;
                        q16 = QQLiveHuYa.q();
                        return q16;
                    }
                });
                l();
                sdkEnabled = true;
                return;
            } catch (Throwable th5) {
                QLog.e("QQLiveHuYa", 1, "setup huya sdk throw t:", th5);
                return;
            }
        }
        QLog.w("QQLiveHuYa", 1, "config not support to setup huya sdk");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q() {
        return Foreground.isCurrentProcessForeground();
    }

    public final void e(@NotNull Function0<Unit> invoke, @NotNull Function0<Unit> invalid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) invoke, (Object) invalid);
            return;
        }
        Intrinsics.checkNotNullParameter(invoke, "invoke");
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        if (!sdkEnabled) {
            QLog.i("QQLiveHuYa", 2, "callWithLogin but sdk not setup");
            invalid.invoke();
        } else {
            m.f271359a.c(invoke, invalid);
        }
    }

    public final void f(long uid, @Nullable Function0<Unit> success, @Nullable final Function0<Unit> failed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(uid), success, failed);
        } else {
            e(new QQLiveHuYa$enterRoom$1(uid, success, failed), new Function0<Unit>(failed) { // from class: com.tencent.mobileqq.qqlive.huya.QQLiveHuYa$enterRoom$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function0<Unit> $failed;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$failed = failed;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) failed);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.e("QQLiveHuYa", 1, "try enterHuYaRoom but login error");
                    Function0<Unit> function0 = this.$failed;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            });
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (!sdkEnabled) {
            QLog.i("QQLiveHuYa", 2, "exitRoom but sdk not setup");
        } else {
            HuyaLiveRoom.quitLive();
        }
    }

    public final int h(int ratio) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, ratio)).intValue();
        }
        if (ratio < 1000) {
            return StreamDefinition.SD.getValue();
        }
        boolean z17 = true;
        if (1000 <= ratio && ratio < 1500) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return StreamDefinition.HD.getValue();
        }
        if (1500 > ratio || ratio >= 4000) {
            z17 = false;
        }
        if (z17) {
            return StreamDefinition.SHD.getValue();
        }
        if (ratio >= 4000) {
            return StreamDefinition.FHD.getValue();
        }
        return StreamDefinition.UNKNOWN.getValue();
    }

    public final void i(@NotNull final String originUrl, @Nullable final d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) originUrl, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        if (!sdkEnabled) {
            QLog.i("QQLiveHuYa", 2, "refreshUrlWithToken but sdk not setup");
            if (callback != null) {
                callback.onUrlCallback(null);
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqlive.huya.e
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveHuYa.j(originUrl, callback);
            }
        }, 128, null, false);
    }

    public final void m(long presenterUid, int gameTypeId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(presenterUid), Integer.valueOf(gameTypeId));
        } else if (!sdkEnabled) {
            QLog.i("QQLiveHuYa", 2, "reportLivePreviewBegin but sdk not setup");
        } else {
            HuyaStatisticLive.reportLivePreviewBegin(presenterUid, gameTypeId);
        }
    }

    public final void n(long presenterUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, presenterUid);
        } else if (!sdkEnabled) {
            QLog.i("QQLiveHuYa", 2, "reportLivePreviewBegin but sdk not setup");
        } else {
            HuyaStatisticLive.reportLivePreviewEnd(presenterUid);
        }
    }

    public final void o(@NotNull b barrageInfo, @Nullable final Function2<? super Boolean, ? super Integer, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) barrageInfo, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(barrageInfo, "barrageInfo");
            e(new QQLiveHuYa$sendBarrage$1(barrageInfo, callback), new Function0<Unit>(callback) { // from class: com.tencent.mobileqq.qqlive.huya.QQLiveHuYa$sendBarrage$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function2<Boolean, Integer, Unit> $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Function2<Boolean, Integer, Unit> function2 = this.$callback;
                    if (function2 != null) {
                        function2.invoke(Boolean.FALSE, -1);
                    }
                }
            });
        }
    }
}
