package com.tencent.mobileqq.springhb.entry;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.entry.model.MsgTabBannerData;
import com.tencent.mobileqq.springhb.entry.model.TimeInfo;
import com.tencent.mobileqq.springhb.entry.worker.e;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.WeakReferenceHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00013B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b0\u00101J\u0012\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0006\u0010\u0013\u001a\u00020\u0005J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010&R\u0014\u0010*\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010)R\u0014\u0010/\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/g;", "Landroid/os/Handler$Callback;", "Lcom/tencent/mobileqq/springhb/entry/worker/e$b;", "", "from", "", "j", ReportConstant.COSTREPORT_PREFIX, "", "k", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "l", "Lcom/tencent/mobileqq/springhb/entry/model/MsgTabBannerData;", "msgTabBannerData", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/os/Message;", "msg", "handleMessage", "r", tl.h.F, "f", "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "d", "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "getSpringApi", "()Lcom/tencent/mobileqq/springhb/entry/worker/d;", "springApi", "e", "Lcom/tencent/mobileqq/springhb/entry/model/MsgTabBannerData;", "bannerData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/springhb/entry/a;", "Landroidx/lifecycle/MutableLiveData;", DomainData.DOMAIN_NAME, "()Landroidx/lifecycle/MutableLiveData;", "countdownMutableLiveData", "Lcom/tencent/util/WeakReferenceHandler;", "Lcom/tencent/util/WeakReferenceHandler;", "uiHandler", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()J", "beginTime", "p", "endTime", "o", "()Ljava/lang/String;", "countdownText", "<init>", "(Lcom/tencent/mobileqq/springhb/entry/worker/d;)V", "i", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class g extends e.b implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.springhb.entry.worker.d springApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MsgTabBannerData bannerData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<a> countdownMutableLiveData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReferenceHandler uiHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/g$a;", "", "", "ONCE_DELAY_POST_MS", "J", "", "ONE_DAY_MS", "I", "STATUS_PAUSE", "STATUS_RUN", "STATUS_STOP", "", "TAG", "Ljava/lang/String;", "WHAT_MSG_LOOP", "WHAT_MSG_RUN", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.entry.g$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60613);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g(@NotNull com.tencent.mobileqq.springhb.entry.worker.d springApi) {
        Intrinsics.checkNotNullParameter(springApi, "springApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) springApi);
            return;
        }
        this.springApi = springApi;
        this.countdownMutableLiveData = new MutableLiveData<>();
        this.uiHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    }

    private final void j(String from) {
        long m3;
        this.uiHandler.removeMessages(102);
        this.uiHandler.removeMessages(101);
        Manager manager = this.springApi.g().getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager");
        long I = ((SpringFestivalEntryManager) manager).I();
        if (I >= m()) {
            this.uiHandler.sendEmptyMessage(102);
            m3 = 0;
        } else if (m() - I <= 86400000) {
            if (m() - I <= MiniBoxNoticeInfo.MIN_5) {
                long m16 = m() - I;
                this.uiHandler.sendEmptyMessageDelayed(102, m16);
                m3 = m16;
            } else {
                this.uiHandler.sendEmptyMessageDelayed(101, MiniBoxNoticeInfo.MIN_5);
                m3 = 300000;
            }
        } else {
            m3 = (m() - I) - 86400000;
            this.uiHandler.sendEmptyMessageDelayed(101, m3);
        }
        QLog.i("SpringHb_SpringBannerTextVM", 1, "checkAndRun from:" + from + " currentTime:" + I + " beginTime:" + m() + " delayMs:" + m3);
    }

    private final boolean k() {
        Manager manager = this.springApi.g().getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager");
        long I = ((SpringFestivalEntryManager) manager).I();
        if (l(I)) {
            return true;
        }
        MsgTabBannerData msgTabBannerData = this.bannerData;
        MsgTabBannerData msgTabBannerData2 = null;
        if (msgTabBannerData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerData");
            msgTabBannerData = null;
        }
        TimeInfo timeInfo = msgTabBannerData.countDownTimeInfo;
        MsgTabBannerData msgTabBannerData3 = this.bannerData;
        if (msgTabBannerData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerData");
        } else {
            msgTabBannerData2 = msgTabBannerData3;
        }
        QLog.i("SpringHb_SpringBannerTextVM", 1, "checkCountDownTimeValid unValid countDownTimeInfo:" + timeInfo + " configTimeInfo:" + msgTabBannerData2.configTimeInfo + " currentTime:" + I + " textEmpty:" + TextUtils.isEmpty(o()));
        return false;
    }

    private final boolean l(long currentTime) {
        if (m() < p() && p() - m() <= 86400000) {
            long m3 = m();
            MsgTabBannerData msgTabBannerData = this.bannerData;
            MsgTabBannerData msgTabBannerData2 = null;
            if (msgTabBannerData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bannerData");
                msgTabBannerData = null;
            }
            if (m3 >= msgTabBannerData.configTimeInfo.begin) {
                long p16 = p();
                MsgTabBannerData msgTabBannerData3 = this.bannerData;
                if (msgTabBannerData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bannerData");
                } else {
                    msgTabBannerData2 = msgTabBannerData3;
                }
                if (p16 > msgTabBannerData2.configTimeInfo.end || currentTime >= p() || TextUtils.isEmpty(o())) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private final long m() {
        MsgTabBannerData msgTabBannerData = this.bannerData;
        if (msgTabBannerData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerData");
            msgTabBannerData = null;
        }
        return msgTabBannerData.countDownTimeInfo.begin;
    }

    private final String o() {
        MsgTabBannerData msgTabBannerData = this.bannerData;
        if (msgTabBannerData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerData");
            msgTabBannerData = null;
        }
        String str = msgTabBannerData.countDownText;
        Intrinsics.checkNotNullExpressionValue(str, "bannerData.countDownText");
        return str;
    }

    private final long p() {
        MsgTabBannerData msgTabBannerData = this.bannerData;
        if (msgTabBannerData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannerData");
            msgTabBannerData = null;
        }
        return msgTabBannerData.countDownTimeInfo.end;
    }

    private final void s() {
        Manager manager = this.springApi.g().getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager");
        long I = ((SpringFestivalEntryManager) manager).I();
        QLog.i("SpringHb_SpringBannerTextVM", 1, "runCountDown currentTime:" + I + " beginTime:" + m() + " endTime:" + p());
        if (p() > I) {
            this.countdownMutableLiveData.setValue(new a(p() - I, o(), 0, 4, null));
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.worker.e.b
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.f();
        QLog.i("SpringHb_SpringBannerTextVM", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.uiHandler.removeMessages(102);
        this.uiHandler.removeMessages(101);
        this.countdownMutableLiveData.setValue(new a(0L, "", 2));
    }

    @Override // com.tencent.mobileqq.springhb.entry.worker.e.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.h();
        QLog.i("SpringHb_SpringBannerTextVM", 1, "onResume");
        if (k()) {
            j("onResume");
        } else {
            this.countdownMutableLiveData.setValue(new a(0L, "", 3));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 != 101) {
            if (i3 == 102) {
                s();
                return true;
            }
            return true;
        }
        j("whatMsgLoop");
        return true;
    }

    @NotNull
    public final MutableLiveData<a> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.countdownMutableLiveData;
    }

    public final void q(@NotNull MsgTabBannerData msgTabBannerData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgTabBannerData);
            return;
        }
        Intrinsics.checkNotNullParameter(msgTabBannerData, "msgTabBannerData");
        QLog.i("SpringHb_SpringBannerTextVM", 1, "onCreate");
        this.bannerData = msgTabBannerData;
        if (!k()) {
            return;
        }
        j("onCreate");
        this.springApi.l().c(this);
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i("SpringHb_SpringBannerTextVM", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.uiHandler.removeMessages(102);
        this.uiHandler.removeMessages(101);
        this.springApi.l().n(this);
    }
}
