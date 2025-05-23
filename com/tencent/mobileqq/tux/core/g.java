package com.tencent.mobileqq.tux.core;

import android.app.Activity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tux.core.h;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.TuxMeterUI;
import com.tencent.tuxmeterqui.config.TuxEventListener;
import com.tencent.tuxmeterqui.config.TuxNativeSurveySetting;
import com.tencent.tuxmeterqui.view.TuxBaseNativeView;
import com.tencent.tuxmetersdk.export.config.DisappearReason;
import com.tencent.tuxmetersdk.export.config.EventErrorHelper;
import com.tencent.tuxmetersdk.export.config.TuxEnvironment;
import com.tencent.tuxmetersdk.export.config.TuxSurveyEvent;
import com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback;
import com.tencent.tuxmetersdk.export.injector.log.ITuxLog;
import com.tencent.tuxmetersdk.export.listener.ITuxFetchDataListener;
import com.tencent.tuxmetersdk.export.listener.ITuxInitListener;
import com.tencent.tuxmetersdk.export.listener.ITuxTriggerFullListener;
import com.tencent.tuxmetersdk.export.listener.ITuxTriggerListener;
import com.tencent.tuxmetersdk.impl.TuxMeterSDK;
import com.tencent.tuxmetersdk.impl.TuxMeterSDKSetting;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import com.tencent.tuxmetersdk.impl.event.TuxEvent;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Question;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J \u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u001e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u000b0%j\b\u0012\u0004\u0012\u00020\u000b`&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R0\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0*j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/tux/core/g;", "", "", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/tuxmetersdk/impl/TuxSurveyConfig;", "surveyConfig", "Lcom/tencent/tuxmetersdk/export/injector/event/ITuxSurveyEventCallback;", "surveyEventCallback", "j", "t", "", "arkUid", "tuxType", "careInfo", "r", "errInfo", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqcareInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/tuxmetersdk/impl/TuxMeterSDKSetting;", "b", "Lcom/tencent/tuxmetersdk/impl/TuxMeterSDKSetting;", "tuxMeterSetting", "Lcom/tencent/mobileqq/tux/ui/c;", "c", "Lcom/tencent/mobileqq/tux/ui/c;", "tuxUiWrapper", "Lcom/tencent/mobileqq/tux/core/h;", "d", "Lcom/tencent/mobileqq/tux/core/h;", "tuxStatus", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "triggerArkUidList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "g", "Ljava/util/HashMap;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "<init>", "()V", "qqtux-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f303454a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static TuxMeterSDKSetting tuxMeterSetting;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.mobileqq.tux.ui.c tuxUiWrapper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static h tuxStatus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean hasStart;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<String> triggerArkUidList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, String> reportParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/tux/core/g$a", "Lcom/tencent/tuxmeterqui/config/TuxEventListener;", "Lcom/tencent/tuxmetersdk/impl/TuxSurveyConfig;", "surveyConfig", "", "onSurveyDisplayed", "Lcom/tencent/tuxmetersdk/model/Question;", "question", "Lcom/tencent/tuxmetersdk/model/Option;", "option", "", "url", "onStarQuestionClick", "onSurveyClose", "onSurveySubmit", "qqtux-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements TuxEventListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ITuxSurveyEventCallback f303461a;

        a(ITuxSurveyEventCallback iTuxSurveyEventCallback) {
            this.f303461a = iTuxSurveyEventCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iTuxSurveyEventCallback);
            }
        }

        @Override // com.tencent.tuxmeterqui.config.TuxEventListener
        public void onStarQuestionClick(@NotNull Question question, @NotNull Option option, @NotNull String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, question, option, url);
                return;
            }
            Intrinsics.checkNotNullParameter(question, "question");
            Intrinsics.checkNotNullParameter(option, "option");
            Intrinsics.checkNotNullParameter(url, "url");
        }

        @Override // com.tencent.tuxmeterqui.config.TuxEventListener
        public void onSurveyClose(@NotNull TuxSurveyConfig surveyConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) surveyConfig);
                return;
            }
            Intrinsics.checkNotNullParameter(surveyConfig, "surveyConfig");
            com.tencent.mobileqq.tux.ui.c cVar = g.tuxUiWrapper;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tuxUiWrapper");
                cVar = null;
            }
            cVar.b();
        }

        @Override // com.tencent.tuxmeterqui.config.TuxEventListener
        public void onSurveyDisplayed(@NotNull TuxSurveyConfig surveyConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) surveyConfig);
            } else {
                Intrinsics.checkNotNullParameter(surveyConfig, "surveyConfig");
            }
        }

        @Override // com.tencent.tuxmeterqui.config.TuxEventListener
        public void onSurveySubmit(@NotNull TuxSurveyConfig surveyConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) surveyConfig);
                return;
            }
            Intrinsics.checkNotNullParameter(surveyConfig, "surveyConfig");
            com.tencent.mobileqq.tux.ui.c cVar = g.tuxUiWrapper;
            com.tencent.mobileqq.tux.ui.c cVar2 = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tuxUiWrapper");
                cVar = null;
            }
            cVar.f(1);
            com.tencent.mobileqq.tux.ui.c cVar3 = g.tuxUiWrapper;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tuxUiWrapper");
            } else {
                cVar2 = cVar3;
            }
            cVar2.b();
            this.f303461a.onDisappear(surveyConfig, DisappearReason.SUBMIT);
            g.f303454a.t();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/tux/core/g$b", "Lcom/tencent/tuxmetersdk/export/injector/log/ITuxLog;", "", "tag", "content", "", "v", "d", "i", "w", "e", "qqtux-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements ITuxLog {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.tuxmetersdk.export.injector.log.ITuxLog
        public void d(@NotNull String tag, @NotNull String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag, (Object) content);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(content, "content");
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, content);
            }
        }

        @Override // com.tencent.tuxmetersdk.export.injector.log.ITuxLog
        public void e(@NotNull String tag, @NotNull String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) tag, (Object) content);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(content, "content");
            QLog.e(tag, 1, content);
        }

        @Override // com.tencent.tuxmetersdk.export.injector.log.ITuxLog
        public void i(@NotNull String tag, @NotNull String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag, (Object) content);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(content, "content");
            QLog.i(tag, 1, content);
        }

        @Override // com.tencent.tuxmetersdk.export.injector.log.ITuxLog
        public void v(@NotNull String tag, @NotNull String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag, (Object) content);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(content, "content");
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, content);
            }
        }

        @Override // com.tencent.tuxmetersdk.export.injector.log.ITuxLog
        public void w(@NotNull String tag, @NotNull String content) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) tag, (Object) content);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(content, "content");
            QLog.w(tag, 1, content);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/tux/core/g$c", "Lcom/tencent/tuxmetersdk/export/listener/ITuxInitListener;", "", "onSuccess", "", "code", "", "msg", "onFailure", "qqtux-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements ITuxInitListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.tuxmetersdk.export.listener.ITuxInitListener
        public void onFailure(int code, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, code, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            g gVar = g.f303454a;
            g.tuxStatus = h.c.f303466a;
            QLog.d("TuxSdkHelper", 1, "TuxInit onFailure code:" + code + ", msg:" + msg2);
        }

        @Override // com.tencent.tuxmetersdk.export.listener.ITuxInitListener
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            g gVar = g.f303454a;
            g.tuxStatus = h.d.f303467a;
            QLog.d("TuxSdkHelper", 1, "TuxInitListener onSuccess");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/tux/core/g$d", "Lcom/tencent/tuxmetersdk/export/listener/ITuxFetchDataListener;", "", "onSuccess", "", "code", "", "msg", "onFailure", "qqtux-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d implements ITuxFetchDataListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.tuxmetersdk.export.listener.ITuxFetchDataListener
        public void onFailure(int code, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, code, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            g gVar = g.f303454a;
            g.tuxStatus = h.a.f303464a;
            QLog.d("TuxSdkHelper", 1, "TuxFetchData onFailure code:" + code + ", msg:" + msg2);
        }

        @Override // com.tencent.tuxmetersdk.export.listener.ITuxFetchDataListener
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            g gVar = g.f303454a;
            g.tuxStatus = h.b.f303465a;
            QLog.d("TuxSdkHelper", 1, "TuxFetchData onSuccess");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/tux/core/g$e", "Lcom/tencent/tuxmetersdk/export/listener/ITuxTriggerFullListener;", "Lcom/tencent/tuxmetersdk/impl/TuxSurveyConfig;", "surveyConfig", "Lcom/tencent/tuxmetersdk/export/injector/event/ITuxSurveyEventCallback;", "surveyEventCallback", "", "onTrigger", "", "errInfo", "onFailure", "qqtux-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class e implements ITuxTriggerFullListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f303462a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f303463b;

        e(String str, String str2) {
            this.f303462a = str;
            this.f303463b = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // com.tencent.tuxmetersdk.export.listener.ITuxTriggerFullListener
        public void onFailure(@NotNull String errInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(errInfo, "errInfo");
            QLog.e("TuxSdkHelper", 1, "onFailure errInfo:" + errInfo);
            com.tencent.mobileqq.tux.ui.c cVar = g.tuxUiWrapper;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tuxUiWrapper");
                cVar = null;
            }
            cVar.f(3);
            g.f303454a.s(this.f303462a, this.f303463b, errInfo);
        }

        @Override // com.tencent.tuxmetersdk.export.listener.ITuxTriggerListener
        public void onTrigger(@NotNull TuxSurveyConfig surveyConfig, @NotNull ITuxSurveyEventCallback surveyEventCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) surveyConfig, (Object) surveyEventCallback);
                return;
            }
            Intrinsics.checkNotNullParameter(surveyConfig, "surveyConfig");
            Intrinsics.checkNotNullParameter(surveyEventCallback, "surveyEventCallback");
            g.f303454a.j(surveyConfig, surveyEventCallback);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34645);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f303454a = new g();
        tuxStatus = h.f.f303469a;
        hasStart = new AtomicBoolean(false);
        triggerArkUidList = new ArrayList<>();
        reportParams = new HashMap<>();
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(final TuxSurveyConfig surveyConfig, final ITuxSurveyEventCallback surveyEventCallback) {
        QLog.d("TuxSdkHelper", 1, "TriggerTux sceneId:" + surveyConfig.getResource().getSceneId() + ", isTipsStyle:" + TuxMeterUI.getInstance().isTuxSurveyTipsStyle(surveyConfig));
        HashMap<String, String> hashMap = reportParams;
        if (hashMap.containsKey("ark_uid")) {
            surveyConfig.appendExtInfo("ark_uid", hashMap.get("ark_uid"));
        }
        if (hashMap.containsKey("qqcare_info")) {
            surveyConfig.appendExtInfo("qqcare_info", hashMap.get("qqcare_info"));
        }
        surveyEventCallback.onStartWhenTrigger(surveyConfig);
        com.tencent.mobileqq.tux.ui.c cVar = tuxUiWrapper;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tuxUiWrapper");
            cVar = null;
        }
        final Activity c16 = cVar.c();
        if (c16 != null) {
            c16.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tux.core.c
                @Override // java.lang.Runnable
                public final void run() {
                    g.k(c16, surveyConfig, surveyEventCallback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Activity activity, final TuxSurveyConfig surveyConfig, final ITuxSurveyEventCallback surveyEventCallback) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(surveyConfig, "$surveyConfig");
        Intrinsics.checkNotNullParameter(surveyEventCallback, "$surveyEventCallback");
        TuxBaseNativeView tuxNativeSurveyView = TuxMeterUI.getInstance().getTuxNativeSurveyView(activity, surveyConfig, new TuxNativeSurveySetting.Builder().isDarkMode(true).build(), new a(surveyEventCallback));
        if (tuxNativeSurveyView != null) {
            QLog.d("TuxSdkHelper", 1, "TuxView is not null and launchPopupDialog");
            com.tencent.mobileqq.tux.ui.c cVar = tuxUiWrapper;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tuxUiWrapper");
                cVar = null;
            }
            cVar.d(activity, tuxNativeSurveyView, new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.tux.core.e
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    g.l(ITuxSurveyEventCallback.this, surveyConfig);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ITuxSurveyEventCallback surveyEventCallback, TuxSurveyConfig surveyConfig) {
        Intrinsics.checkNotNullParameter(surveyEventCallback, "$surveyEventCallback");
        Intrinsics.checkNotNullParameter(surveyConfig, "$surveyConfig");
        com.tencent.mobileqq.tux.ui.c cVar = tuxUiWrapper;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tuxUiWrapper");
            cVar = null;
        }
        cVar.b();
        surveyEventCallback.onDisappear(surveyConfig, DisappearReason.CLICK_BACK);
    }

    private final void n() {
        TuxMeterSDKSetting build = new TuxMeterSDKSetting.Builder().appId("qq").appKey("7gHjsFUabJ6m8JCS8DCmCxCQpejmdDWr").uid(o.c()).appVersion(AppSetting.f99551k).environment(TuxEnvironment.RELEASE).reporter(new com.tencent.mobileqq.tux.core.a()).logger(new b()).storage(new com.tencent.mobileqq.tux.core.b()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              \u2026\n                .build()");
        tuxMeterSetting = build;
    }

    private final void o() {
        tuxUiWrapper = new com.tencent.mobileqq.tux.ui.c();
        TuxMeterSDK tuxMeterSDK = TuxMeterSDK.getInstance();
        BaseApplication context = BaseApplication.getContext();
        TuxMeterSDKSetting tuxMeterSDKSetting = tuxMeterSetting;
        if (tuxMeterSDKSetting == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tuxMeterSetting");
            tuxMeterSDKSetting = null;
        }
        tuxMeterSDK.start(context, tuxMeterSDKSetting, new c(), new d(), new ITuxTriggerListener() { // from class: com.tencent.mobileqq.tux.core.d
            @Override // com.tencent.tuxmetersdk.export.listener.ITuxTriggerListener
            public final void onTrigger(TuxSurveyConfig tuxSurveyConfig, ITuxSurveyEventCallback iTuxSurveyEventCallback) {
                g.p(tuxSurveyConfig, iTuxSurveyEventCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(TuxSurveyConfig surveyConfig, ITuxSurveyEventCallback surveyEventCallback) {
        g gVar = f303454a;
        Intrinsics.checkNotNullExpressionValue(surveyConfig, "surveyConfig");
        Intrinsics.checkNotNullExpressionValue(surveyEventCallback, "surveyEventCallback");
        gVar.j(surveyConfig, surveyEventCallback);
    }

    private final void r(String arkUid, String tuxType, String careInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("ark_uid", arkUid);
        hashMap.put("rate_type", tuxType);
        hashMap.put("qqcare_info", careInfo);
        hashMap.put(EventErrorHelper.EVENT_ERROR_EVENT_CODE, "click_rate");
        ITuxSurveyEventCallback surveyEventCallback = TuxMeterSDK.getInstance().getSurveyEventCallback();
        if (surveyEventCallback != null) {
            surveyEventCallback.onEventAction(TuxSurveyEvent.TUX_EVENT_PERMANENT, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(String arkUid, String tuxType, String errInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("ark_uid", arkUid);
        hashMap.put("rate_type", tuxType);
        hashMap.put(EventErrorHelper.EVENT_ERROR_EVENT_CODE, "report_error");
        hashMap.put("tux_error_info", errInfo);
        ITuxSurveyEventCallback surveyEventCallback = TuxMeterSDK.getInstance().getSurveyEventCallback();
        if (surveyEventCallback != null) {
            surveyEventCallback.onEventAction(TuxSurveyEvent.TUX_EVENT_PERMANENT, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        final JSONObject jSONObject = new JSONObject();
        String str = reportParams.get("ark_uid");
        if (str != null) {
            jSONObject.put("ark_uid", str);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.tux.core.f
            @Override // java.lang.Runnable
            public final void run() {
                g.u(JSONObject.this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "$jsonObj");
        try {
            QLog.d("TuxSdkHelper", 1, "postArkNotify json content:", jsonObj.toString());
            ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify("com.tencent.babyq.feedback", "", "TuxSubmitNotify", jsonObj.toString());
        } catch (UnsatisfiedLinkError e16) {
            QLog.e("TuxSdkHelper", 1, "", e16);
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!hasStart.compareAndSet(false, true)) {
            QLog.d("TuxSdkHelper", 1, "Already start");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        tuxStatus = h.e.f303468a;
        n();
        long currentTimeMillis2 = System.currentTimeMillis();
        o();
        QLog.d("TuxSdkHelper", 1, "initSetting:" + (currentTimeMillis2 - currentTimeMillis) + ", startTux:" + (System.currentTimeMillis() - currentTimeMillis2));
    }

    public final void q(@NotNull String arkUid, @NotNull String tuxType, @NotNull String qqcareInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, arkUid, tuxType, qqcareInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(arkUid, "arkUid");
        Intrinsics.checkNotNullParameter(tuxType, "tuxType");
        Intrinsics.checkNotNullParameter(qqcareInfo, "qqcareInfo");
        r(arkUid, tuxType, qqcareInfo);
        com.tencent.mobileqq.tux.ui.c cVar = null;
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.e("TuxSdkHelper", 1, "Network is not available");
            com.tencent.mobileqq.tux.ui.c cVar2 = tuxUiWrapper;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tuxUiWrapper");
            } else {
                cVar = cVar2;
            }
            cVar.f(3);
            s(arkUid, tuxType, "network_error");
            return;
        }
        h hVar = tuxStatus;
        if (Intrinsics.areEqual(hVar, h.f.f303469a)) {
            m();
            com.tencent.mobileqq.tux.ui.c cVar3 = tuxUiWrapper;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tuxUiWrapper");
            } else {
                cVar = cVar3;
            }
            cVar.f(3);
            return;
        }
        if (Intrinsics.areEqual(hVar, h.b.f303465a)) {
            HashMap<String, String> hashMap = reportParams;
            hashMap.clear();
            hashMap.put("ark_uid", arkUid);
            hashMap.put("rate_type", tuxType);
            hashMap.put("qqcare_info", qqcareInfo);
            TuxMeterSDK.getInstance().reportWithTriggerListener(new TuxEvent("click_rate", hashMap), new e(arkUid, tuxType));
            return;
        }
        com.tencent.mobileqq.tux.ui.c cVar4 = tuxUiWrapper;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tuxUiWrapper");
        } else {
            cVar = cVar4;
        }
        cVar.f(3);
    }
}
