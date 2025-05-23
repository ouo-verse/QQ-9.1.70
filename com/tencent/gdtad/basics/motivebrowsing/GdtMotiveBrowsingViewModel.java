package com.tencent.gdtad.basics.motivebrowsing;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.AdLinkReportForClick;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivebrowsing.l;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ$\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J,\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003J\u001a\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u001b\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\tJ\b\u0010\u001d\u001a\u00020\tH\u0014J\u0006\u0010\u001e\u001a\u00020\u0003R\u0018\u0010!\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010&\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020(0'8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u0010\u0012\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00104\u001a\n 1*\u0004\u0018\u000100008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010/R\u0017\u0010<\u001a\u0002078\u0006\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0017\u0010A\u001a\u00020=8\u0006\u00a2\u0006\f\n\u0004\b/\u0010>\u001a\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/gdtad/basics/motivebrowsing/l$b;", "", "type", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL, "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "adInfo", "", "e2", "", "clickStartTimeMillis", "f2", "b2", "Lrx/Subscription;", "subscription", "j2", "countDownTime", "U1", "url", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "model", "c1", "w1", "", "c2", "d2", SemanticAttributes.DbSystemValues.H2, "onCleared", "X1", "i", "Lrx/Subscription;", "leftSecondSubscription", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "autoCountAfter5Second", BdhLogUtil.LogTag.Tag_Conn, "Z", "hasCountDown", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/gdtad/basics/motivebrowsing/v;", "D", "Landroidx/lifecycle/MutableLiveData;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Landroidx/lifecycle/MutableLiveData;", "motiveBrowsingData", "E", "I", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Ljava/util/regex/Pattern;", "msgPathPattern", "G", "leftSecond", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "H", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "getGdtThirdProcessorProxy", "()Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "gdtThirdProcessorProxy", "Lcom/tencent/gdtad/basics/motivebrowsing/l;", "Lcom/tencent/gdtad/basics/motivebrowsing/l;", "Z1", "()Lcom/tencent/gdtad/basics/motivebrowsing/l;", "mGdtMotiveBrowsingExperimentReportHelper", "<init>", "()V", "J", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtMotiveBrowsingViewModel extends ViewModel implements l.b {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasCountDown;

    /* renamed from: E, reason: from kotlin metadata */
    private int countDownTime;

    /* renamed from: G, reason: from kotlin metadata */
    private int leftSecond;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Subscription leftSecondSubscription;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Subscription autoCountAfter5Second;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<MotiveBrowsingData> motiveBrowsingData = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    private final Pattern msgPathPattern = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final GdtThirdProcessorProxy gdtThirdProcessorProxy = new GdtThirdProcessorProxy();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final l mGdtMotiveBrowsingExperimentReportHelper = new l();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2() {
        j2(this.autoCountAfter5Second);
        this.autoCountAfter5Second = null;
        if (!this.hasCountDown) {
            if (QLog.isColorLevel()) {
                QLog.d("GdtMotiveBrowsingViewModel", 2, "onCountDown");
            }
            this.hasCountDown = true;
            this.leftSecond = this.countDownTime;
            h2();
        }
    }

    private final void e2(int type, String reportUrl, qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        f2(type, reportUrl, adInfo, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
    }

    private final void f2(final int type, final String reportUrl, final qq_ad_get.QQAdGetRsp.AdInfo adInfo, final long clickStartTimeMillis) {
        if (QLog.isColorLevel()) {
            QLog.d("GdtMotiveBrowsingViewModel", 2, "report reportUrl : " + reportUrl);
        }
        this.gdtThirdProcessorProxy.c2sReportAsync(type, 0, adInfo);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.basics.motivebrowsing.u
            @Override // java.lang.Runnable
            public final void run() {
                GdtMotiveBrowsingViewModel.g2(type, adInfo, clickStartTimeMillis, reportUrl);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c A[Catch: all -> 0x00a8, TRY_LEAVE, TryCatch #3 {all -> 0x00a8, blocks: (B:32:0x0085, B:34:0x008c), top: B:31:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void g2(int i3, qq_ad_get.QQAdGetRsp.AdInfo adInfo, long j3, String str) {
        boolean z16;
        HttpURLConnection httpURLConnection = null;
        if (i3 == 1) {
            try {
                AdLinkReportForClick.linkReportForReportStart(BaseApplication.getContext(), new GdtAd(adInfo), j3, 2);
            } catch (Throwable th5) {
                th = th5;
                try {
                    QLog.d("GdtMotiveBrowsingViewModel", 1, th, new Object[0]);
                    if (i3 == 1) {
                    }
                    if (httpURLConnection == null) {
                    }
                } catch (Throwable th6) {
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable th7) {
                            QLog.d("GdtMotiveBrowsingViewModel", 1, th7, new Object[0]);
                        }
                    }
                    throw th6;
                }
            }
        }
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
        if (httpURLConnection2 != null) {
            try {
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(10000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                if (QLog.isColorLevel()) {
                    QLog.d("GdtMotiveBrowsingViewModel", 2, "reportBannerAd rspCode" + responseCode);
                }
                if (i3 == 1) {
                    BaseApplication context = BaseApplication.getContext();
                    GdtAd gdtAd = new GdtAd(adInfo);
                    if (responseCode != 200 && responseCode != 302) {
                        z16 = false;
                        AdLinkReportForClick.linkReportForReportEnd(context, gdtAd, z16, j3, 2);
                    }
                    z16 = true;
                    AdLinkReportForClick.linkReportForReportEnd(context, gdtAd, z16, j3, 2);
                }
            } catch (Throwable th8) {
                httpURLConnection = httpURLConnection2;
                th = th8;
                QLog.d("GdtMotiveBrowsingViewModel", 1, th, new Object[0]);
                if (i3 == 1) {
                    AdLinkReportForClick.linkReportForReportEnd(BaseApplication.getContext(), new GdtAd(adInfo), false, j3, 2);
                }
                if (httpURLConnection == null) {
                    try {
                        httpURLConnection.disconnect();
                        return;
                    } catch (Throwable th9) {
                        QLog.d("GdtMotiveBrowsingViewModel", 1, th9, new Object[0]);
                        return;
                    }
                }
                return;
            }
        }
        if (httpURLConnection2 != null) {
            try {
                httpURLConnection2.disconnect();
            } catch (Throwable th10) {
                QLog.d("GdtMotiveBrowsingViewModel", 1, th10, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j2(Subscription subscription) {
        boolean z16 = false;
        if (subscription != null && !subscription.isUnsubscribed()) {
            z16 = true;
        }
        if (z16) {
            subscription.unsubscribe();
        }
    }

    public final void U1(int countDownTime) {
        this.countDownTime = countDownTime;
        if (QLog.isColorLevel()) {
            QLog.d("GdtMotiveBrowsingViewModel", 2, "autoCountCheck");
        }
        Observable<Long> timer = Observable.timer(0L, TimeUnit.SECONDS, AndroidSchedulers.mainThread());
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingViewModel$autoCountCheck$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l3) {
                GdtMotiveBrowsingViewModel.this.b2();
            }
        };
        this.autoCountAfter5Second = timer.subscribe(new Action1() { // from class: com.tencent.gdtad.basics.motivebrowsing.s
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                GdtMotiveBrowsingViewModel.W1(Function1.this, obj);
            }
        });
    }

    /* renamed from: X1, reason: from getter */
    public final int getLeftSecond() {
        return this.leftSecond;
    }

    @NotNull
    /* renamed from: Z1, reason: from getter */
    public final l getMGdtMotiveBrowsingExperimentReportHelper() {
        return this.mGdtMotiveBrowsingExperimentReportHelper;
    }

    @NotNull
    public final MutableLiveData<MotiveBrowsingData> a2() {
        return this.motiveBrowsingData;
    }

    @Override // com.tencent.gdtad.basics.motivebrowsing.l.b
    public void c1(@NotNull String url, @Nullable GdtMotiveVideoModel model) {
        Intrinsics.checkNotNullParameter(url, "url");
        w1(url, model, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
    }

    public final boolean c2(@NotNull String url, @Nullable GdtMotiveVideoModel model) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(url, "url");
        GdtLog.i("GdtMotiveBrowsingViewModel", "onHandleUrl url: " + url);
        if (model != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "gdtmsg://e.qq.com/startCountDown/rewardAD/", false, 2, null);
            if (!startsWith$default) {
                return false;
            }
            b2();
            return true;
        }
        return true;
    }

    public final void d2() {
        j2(this.leftSecondSubscription);
        this.leftSecondSubscription = null;
    }

    public final void h2() {
        if (this.leftSecondSubscription == null && this.leftSecond > 0) {
            this.motiveBrowsingData.setValue(new MotiveBrowsingData(1, null, this.leftSecond, 2, null));
            Observable<Long> interval = Observable.interval(1L, TimeUnit.SECONDS, AndroidSchedulers.mainThread());
            final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingViewModel$resumeCountDown$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke2(l3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long l3) {
                    int i3;
                    int i16;
                    int i17;
                    Subscription subscription;
                    int i18;
                    GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel = GdtMotiveBrowsingViewModel.this;
                    i3 = gdtMotiveBrowsingViewModel.leftSecond;
                    gdtMotiveBrowsingViewModel.leftSecond = i3 - 1;
                    if (QLog.isColorLevel()) {
                        i18 = GdtMotiveBrowsingViewModel.this.leftSecond;
                        QLog.d("GdtMotiveBrowsingViewModel", 2, "onCountDown subscribe value : " + i18);
                    }
                    i16 = GdtMotiveBrowsingViewModel.this.leftSecond;
                    if (i16 <= 0) {
                        GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel2 = GdtMotiveBrowsingViewModel.this;
                        subscription = gdtMotiveBrowsingViewModel2.leftSecondSubscription;
                        gdtMotiveBrowsingViewModel2.j2(subscription);
                        GdtMotiveBrowsingViewModel.this.leftSecondSubscription = null;
                    }
                    MutableLiveData<MotiveBrowsingData> a26 = GdtMotiveBrowsingViewModel.this.a2();
                    i17 = GdtMotiveBrowsingViewModel.this.leftSecond;
                    a26.setValue(new MotiveBrowsingData(1, null, i17, 2, null));
                }
            };
            this.leftSecondSubscription = interval.subscribe(new Action1() { // from class: com.tencent.gdtad.basics.motivebrowsing.t
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    GdtMotiveBrowsingViewModel.i2(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        if (QLog.isColorLevel()) {
            QLog.d("GdtMotiveBrowsingViewModel", 2, "onCleared");
        }
        j2(this.leftSecondSubscription);
        this.leftSecondSubscription = null;
        j2(this.autoCountAfter5Second);
        this.autoCountAfter5Second = null;
    }

    @Override // com.tencent.gdtad.basics.motivebrowsing.l.b
    public void w1(@NotNull String url, @Nullable GdtMotiveVideoModel model, long clickStartTimeMillis) {
        boolean startsWith$default;
        boolean startsWith$default2;
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        GdtLog.i("GdtMotiveBrowsingViewModel", "onHandleUrl url: " + url);
        if (model != null) {
            String str2 = null;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "gdtmsg://e.qq.com/reportExposureRewardAd/rewardAD", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "gdtmsg://e.qq.com/reportClickRewardAd/rewardAD/", false, 2, null);
                if (startsWith$default2) {
                    GdtAd gdtAd = model.getGdtAd();
                    if (gdtAd != null) {
                        str = gdtAd.getUrlForClick();
                    } else {
                        str = null;
                    }
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (str != null) {
                        str2 = this.mGdtMotiveBrowsingExperimentReportHelper.c(str);
                    }
                    f2(1, str2, model.getAdInfo(), clickStartTimeMillis);
                    return;
                }
                return;
            }
            GdtAd gdtAd2 = model.getGdtAd();
            if (gdtAd2 != null) {
                str2 = gdtAd2.getUrlForImpression();
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            e2(0, str2, model.getAdInfo());
        }
    }
}
