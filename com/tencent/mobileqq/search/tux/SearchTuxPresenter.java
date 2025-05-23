package com.tencent.mobileqq.search.tux;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.search.tux.SearchTuxPresenter;
import com.tencent.mobileqq.search.tux.f;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.tuxmeterqui.TuxMeterUI;
import com.tencent.tuxmeterqui.config.TuxNativeSurveySetting;
import com.tencent.tuxmeterqui.config.TuxQuestionConfig;
import com.tencent.tuxmeterqui.view.TuxBaseNativeView;
import com.tencent.tuxmetersdk.export.config.DisappearReason;
import com.tencent.tuxmetersdk.export.config.TriggerErrorCode;
import com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback;
import com.tencent.tuxmetersdk.export.listener.ITuxTriggerFullListener;
import com.tencent.tuxmetersdk.impl.TuxMeterSDK;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import com.tencent.tuxmetersdk.impl.event.TuxEvent;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.util.QQToastUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u0004:\u0001,B\u0007\u00a2\u0006\u0004\b*\u0010+J4\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u000f*\u00020\u000fH\u0002J\u001c\u0010\u0014\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J,\u0010\u0019\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u0018\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/search/tux/SearchTuxPresenter;", "Lqn2/d;", "Lcom/tencent/mobileqq/search/tux/g;", "Lcom/tencent/mobileqq/search/tux/k;", "Lqn2/b;", "model", "searchTuxView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/tuxmetersdk/impl/TuxSurveyConfig;", "surveyConfig", "Lcom/tencent/tuxmeterqui/config/TuxNativeSurveySetting;", "nativeSurveySetting", "Lcom/tencent/tuxmeterqui/view/TuxBaseNativeView;", "j", "Landroid/view/View;", "parentView", "", "i", "k", "g", "view", "", "postion", "globalPosition", tl.h.F, "Lcom/tencent/tuxmetersdk/impl/event/TuxEvent;", "d", "Lkotlin/Lazy;", "l", "()Lcom/tencent/tuxmetersdk/impl/event/TuxEvent;", "tuxEvent", "e", "I", "getPosition", "()I", "setPosition", "(I)V", "position", "f", "getGlobalPosition", "setGlobalPosition", "<init>", "()V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchTuxPresenter implements qn2.d<g, k>, qn2.b<g> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tuxEvent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int position;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int globalPosition;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/search/tux/SearchTuxPresenter$a;", "", "Lcom/tencent/tuxmetersdk/impl/TuxSurveyConfig;", "Lcom/tencent/mobileqq/search/tux/i;", "tuxReportData", "", "a", "", "EVENT_CODE_PAGE_LOAD", "Ljava/lang/String;", "KEY_KEYWORD", "KEY_PAGE_ID", "KEY_TRACE_ID", "PAGE_ID_DIRECT", "PAGE_ID_NETWORK", "SCENE_SEARCH_DIRECT", "SCENE_SEARCH_NETWORK", "TAG", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.tux.SearchTuxPresenter$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull TuxSurveyConfig tuxSurveyConfig, @NotNull i tuxReportData) {
            String substringAfter$default;
            Intrinsics.checkNotNullParameter(tuxSurveyConfig, "<this>");
            Intrinsics.checkNotNullParameter(tuxReportData, "tuxReportData");
            substringAfter$default = StringsKt__StringsKt.substringAfter$default(tuxReportData.getTraceId(), util.base64_pad_url, (String) null, 2, (Object) null);
            tuxSurveyConfig.appendExtInfo("traceid", substringAfter$default);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/search/tux/SearchTuxPresenter$b", "Lcom/tencent/tuxmetersdk/export/listener/ITuxTriggerFullListener;", "Lcom/tencent/tuxmetersdk/impl/TuxSurveyConfig;", "surveyConfig", "Lcom/tencent/tuxmetersdk/export/injector/event/ITuxSurveyEventCallback;", "surveyEventCallback", "", "onTrigger", "", "errInfo", "onFailure", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements ITuxTriggerFullListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f284903b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f284904c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f284905d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TuxNativeSurveySetting f284906e;

        b(g gVar, k kVar, Activity activity, TuxNativeSurveySetting tuxNativeSurveySetting) {
            this.f284903b = gVar;
            this.f284904c = kVar;
            this.f284905d = activity;
            this.f284906e = tuxNativeSurveySetting;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(SearchTuxPresenter this$0, g gVar, k kVar, Activity activity, TuxSurveyConfig surveyConfig, TuxNativeSurveySetting nativeSurveySetting) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(surveyConfig, "$surveyConfig");
            Intrinsics.checkNotNullExpressionValue(nativeSurveySetting, "nativeSurveySetting");
            TuxBaseNativeView j3 = this$0.j(gVar, kVar, activity, surveyConfig, nativeSurveySetting);
            if (j3 != null) {
                com.tencent.mobileqq.search.tux.b tuxStatisticIoc = gVar.getTuxStatisticIoc();
                if (tuxStatisticIoc != null) {
                    tuxStatisticIoc.b(surveyConfig);
                }
                com.tencent.mobileqq.search.tux.b tuxStatisticIoc2 = gVar.getTuxStatisticIoc();
                boolean z16 = false;
                if (tuxStatisticIoc2 != null && !tuxStatisticIoc2.getHasSearchTuxShowed()) {
                    z16 = true;
                }
                if (z16) {
                    j3.reportSurveyExposureEvent();
                    gVar.getTuxStatisticIoc().e(true);
                }
            }
        }

        @Override // com.tencent.tuxmetersdk.export.listener.ITuxTriggerFullListener
        public void onFailure(@NotNull String errInfo) {
            Intrinsics.checkNotNullParameter(errInfo, "errInfo");
            this.f284904c.m(null);
            com.tencent.mobileqq.search.tux.b tuxStatisticIoc = this.f284903b.getTuxStatisticIoc();
            if (tuxStatisticIoc != null) {
                tuxStatisticIoc.removeTuxItem();
            }
            QLog.e("SearchTuxPresenter", 1, "onFailure errInfo:" + errInfo);
        }

        @Override // com.tencent.tuxmetersdk.export.listener.ITuxTriggerListener
        public void onTrigger(@NotNull final TuxSurveyConfig surveyConfig, @NotNull ITuxSurveyEventCallback surveyEventCallback) {
            Intrinsics.checkNotNullParameter(surveyConfig, "surveyConfig");
            Intrinsics.checkNotNullParameter(surveyEventCallback, "surveyEventCallback");
            QLog.i("SearchTuxPresenter", 1, "onTrigger surveyConfig=" + surveyConfig);
            if (!Intrinsics.areEqual(surveyConfig.getResource().getSceneId(), "137")) {
                surveyEventCallback.onReceiveTriggerErrorCode(surveyConfig, TriggerErrorCode.SCENE_ID_NOT_MATCH);
                QLog.w("SearchTuxPresenter", 1, "not match, sceneId=" + surveyConfig.getResource().getSceneId());
                return;
            }
            surveyEventCallback.onStartWhenTrigger(surveyConfig);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final SearchTuxPresenter searchTuxPresenter = SearchTuxPresenter.this;
            final g gVar = this.f284903b;
            final k kVar = this.f284904c;
            final Activity activity = this.f284905d;
            final TuxNativeSurveySetting tuxNativeSurveySetting = this.f284906e;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.tux.h
                @Override // java.lang.Runnable
                public final void run() {
                    SearchTuxPresenter.b.b(SearchTuxPresenter.this, gVar, kVar, activity, surveyConfig, tuxNativeSurveySetting);
                }
            });
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/search/tux/SearchTuxPresenter$c", "Lcom/tencent/mobileqq/search/tux/f;", "Lcom/tencent/tuxmetersdk/model/Question;", "question", "Lcom/tencent/tuxmetersdk/model/Option;", "option", "", "url", "", "onStarQuestionClick", "Lcom/tencent/tuxmetersdk/impl/TuxSurveyConfig;", "surveyConfig", "onSurveyClose", "onSurveySubmit", "", "a", "Z", "getHasClick", "()Z", "setHasClick", "(Z)V", "hasClick", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements f {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean hasClick;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f284908b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ SearchTuxPresenter f284909c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g f284910d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<TuxBaseNativeView> f284911e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f284912f;

        c(k kVar, SearchTuxPresenter searchTuxPresenter, g gVar, Ref.ObjectRef<TuxBaseNativeView> objectRef, Activity activity) {
            this.f284908b = kVar;
            this.f284909c = searchTuxPresenter;
            this.f284910d = gVar;
            this.f284911e = objectRef;
            this.f284912f = activity;
        }

        @Override // com.tencent.tuxmeterqui.config.TuxEventListener
        public void onStarQuestionClick(@Nullable Question question, @Nullable Option option, @Nullable String url) {
            View view;
            View k3;
            String str;
            f.a.a(this, question, option, url);
            if (this.hasClick) {
                return;
            }
            this.hasClick = true;
            k kVar = this.f284908b;
            if (kVar != null && (view = kVar.getView()) != null && (k3 = this.f284909c.k(view)) != null) {
                if (option != null) {
                    str = option.getText();
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "0";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "option?.text ?: \"0\"");
                }
                VideoReport.setElementParam(k3, "satisfaction_degree", str);
                com.tencent.mobileqq.search.report.a.f(com.tencent.mobileqq.search.report.a.f283716a, "clck", k3, null, 4, null);
            }
        }

        @Override // com.tencent.tuxmeterqui.config.TuxEventListener
        public void onSurveyClose(@Nullable TuxSurveyConfig surveyConfig) {
            f.a.b(this, surveyConfig);
            com.tencent.mobileqq.search.tux.b tuxStatisticIoc = this.f284910d.getTuxStatisticIoc();
            if (tuxStatisticIoc != null) {
                tuxStatisticIoc.f(true);
            }
            com.tencent.mobileqq.search.tux.b tuxStatisticIoc2 = this.f284910d.getTuxStatisticIoc();
            if (tuxStatisticIoc2 != null) {
                tuxStatisticIoc2.removeTuxItem();
            }
            TuxBaseNativeView tuxBaseNativeView = this.f284911e.element;
            if (tuxBaseNativeView != null) {
                tuxBaseNativeView.reportSurveyDisappearEvent(DisappearReason.SLIDE_DOWN);
            }
            QLog.i("SearchTuxPresenter", 1, "onSurveyClose");
        }

        @Override // com.tencent.tuxmeterqui.config.TuxEventListener
        public void onSurveyDisplayed(@Nullable TuxSurveyConfig tuxSurveyConfig) {
            f.a.c(this, tuxSurveyConfig);
        }

        @Override // com.tencent.tuxmeterqui.config.TuxEventListener
        public void onSurveySubmit(@Nullable TuxSurveyConfig surveyConfig) {
            f.a.d(this, surveyConfig);
            QQToastUtil.showQQToastInUiThread(2, this.f284912f.getString(R.string.f224776ju));
            TuxBaseNativeView tuxBaseNativeView = this.f284911e.element;
            if (tuxBaseNativeView != null) {
                tuxBaseNativeView.reportSurveyDisappearEvent(DisappearReason.SUBMIT);
            }
            QLog.i("SearchTuxPresenter", 1, "onSurveySubmit");
        }
    }

    public SearchTuxPresenter() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TuxEvent>() { // from class: com.tencent.mobileqq.search.tux.SearchTuxPresenter$tuxEvent$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TuxEvent invoke() {
                HashMap hashMapOf;
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("page_id", "qq_search_direct"));
                return new TuxEvent("page_load", hashMapOf);
            }
        });
        this.tuxEvent = lazy;
        this.position = -1;
        this.globalPosition = -1;
    }

    private final void i(View parentView) {
        Map mutableMapOf;
        int i3 = this.position;
        if (i3 != -1 && this.globalPosition != -1) {
            am.m(parentView, i3, "5", "30", String.valueOf(parentView.hashCode()), 1, "40", "");
            View k3 = k(parentView);
            if (k3 != null) {
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("satisfaction_degree", ""));
                int i16 = this.globalPosition;
                int hashCode = parentView.hashCode();
                int i17 = this.globalPosition;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(hashCode);
                sb5.append(i17);
                am.t(k3, "\u4f60\u5bf9\u672c\u6b21\u641c\u7d22\u7ed3\u679c\u6ee1\u610f\u5417\uff1f", "40", "", 0, i16, sb5.toString(), null, null, mutableMapOf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [T, android.view.View, com.tencent.tuxmeterqui.view.TuxBaseNativeView] */
    public final TuxBaseNativeView j(g model, k searchTuxView, Activity activity, TuxSurveyConfig surveyConfig, TuxNativeSurveySetting nativeSurveySetting) {
        INSTANCE.a(surveyConfig, model.getTuxReportData());
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? tuxNativeSurveyView = TuxMeterUI.getInstance().getTuxNativeSurveyView(activity, surveyConfig, nativeSurveySetting, new c(searchTuxView, this, model, objectRef, activity));
        if (tuxNativeSurveyView != 0) {
            if (searchTuxView != 0) {
                searchTuxView.a(tuxNativeSurveyView);
            }
            objectRef.element = tuxNativeSurveyView;
            i(tuxNativeSurveyView);
        }
        return tuxNativeSurveyView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View k(View view) {
        ViewGroup viewGroup;
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return null;
        }
        return viewGroup.getChildAt(0);
    }

    private final TuxEvent l() {
        return (TuxEvent) this.tuxEvent.getValue();
    }

    @Override // qn2.d
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void a(@Nullable g model, @Nullable k searchTuxView) {
        i tuxReportData;
        Activity j3;
        boolean z16;
        TuxSurveyConfig tuxSurveyConfig;
        if (model == null || (tuxReportData = model.getTuxReportData()) == null || searchTuxView == null || (j3 = searchTuxView.j()) == null || Intrinsics.areEqual(tuxReportData, searchTuxView.getTuxItem())) {
            return;
        }
        com.tencent.mobileqq.search.tux.b tuxStatisticIoc = model.getTuxStatisticIoc();
        if (tuxStatisticIoc != null && tuxStatisticIoc.getHasSearchTuxClosed()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            model.getTuxStatisticIoc().removeTuxItem();
            return;
        }
        searchTuxView.m(tuxReportData.a());
        TuxNativeSurveySetting.Builder isDarkMode = new TuxNativeSurveySetting.Builder().isDarkMode(je0.a.a(j3));
        TuxQuestionConfig tuxQuestionConfig = new TuxQuestionConfig();
        TuxQuestionConfig.TuxUIConfig tuxUIConfig = new TuxQuestionConfig.TuxUIConfig();
        tuxUIConfig.parentViewBackgroundColor = 0;
        tuxQuestionConfig.uiConfig = tuxUIConfig;
        TuxNativeSurveySetting.Builder viewQuestionConfig = isDarkMode.setViewQuestionConfig(tuxQuestionConfig);
        TuxQuestionConfig tuxQuestionConfig2 = new TuxQuestionConfig();
        TuxQuestionConfig.TuxUIConfig tuxUIConfig2 = new TuxQuestionConfig.TuxUIConfig();
        tuxUIConfig2.titleTextSizeSp = 14.0f;
        tuxUIConfig2.titleTextColor = R.color.qui_common_text_primary;
        tuxUIConfig2.titleTypeface = 0;
        tuxUIConfig2.padding = new RectF(0.0f, 1.0f, 0.0f, 10.0f);
        tuxUIConfig2.itemBgDrawableResId = R.drawable.qui_common_fill_light_primary_bg_selector;
        tuxQuestionConfig2.uiConfig = tuxUIConfig2;
        TuxNativeSurveySetting nativeSurveySetting = viewQuestionConfig.addStarStarQuestionConfig(tuxQuestionConfig2).build();
        com.tencent.mobileqq.search.tux.b tuxStatisticIoc2 = model.getTuxStatisticIoc();
        if (tuxStatisticIoc2 != null) {
            tuxSurveyConfig = tuxStatisticIoc2.getCacheSurveyConfig();
        } else {
            tuxSurveyConfig = null;
        }
        if (tuxSurveyConfig != null) {
            TuxSurveyConfig cacheSurveyConfig = model.getTuxStatisticIoc().getCacheSurveyConfig();
            if (cacheSurveyConfig != null) {
                Intrinsics.checkNotNullExpressionValue(nativeSurveySetting, "nativeSurveySetting");
                j(model, searchTuxView, j3, cacheSurveyConfig, nativeSurveySetting);
            }
            QLog.i("SearchTuxPresenter", 1, "bind just recreate view, tuxItem=" + tuxReportData);
            return;
        }
        QLog.i("SearchTuxPresenter", 1, "start reportWithTriggerListener");
        TuxMeterSDK.getInstance().reportWithTriggerListener(l(), new b(model, searchTuxView, j3, nativeSurveySetting));
    }

    @Override // qn2.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void b(@Nullable g model, @Nullable View view, int postion, int globalPosition) {
        this.position = postion;
        this.globalPosition = globalPosition;
        if (view != null) {
            i(view);
        }
    }
}
