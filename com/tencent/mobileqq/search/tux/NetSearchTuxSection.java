package com.tencent.mobileqq.search.tux;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.tux.NetSearchTuxSection;
import com.tencent.mobileqq.search.tux.f;
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
import hp2.al;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J2\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0014J(\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00142\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u0010\f\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u00100R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00078F\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/search/tux/NetSearchTuxSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/tux/d;", "Lcom/tencent/mobileqq/search/tux/i;", "tuxReportData", "Landroid/view/ViewGroup;", "tuxParentView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/tuxmetersdk/impl/TuxSurveyConfig;", "surveyConfig", "Lcom/tencent/tuxmeterqui/config/TuxNativeSurveySetting;", "nativeSurveySetting", "Lcom/tencent/tuxmeterqui/view/TuxBaseNativeView;", "b0", "Landroid/view/View;", "containerView", "", "y", "data", "", "g0", "", "getViewStubLayoutId", "position", "", "", "payload", "c0", "Lhp2/al;", "D", "Lhp2/al;", "bind", "E", "Lcom/tencent/mobileqq/search/tux/i;", "currentTuxReportDataItem", "Lcom/tencent/mobileqq/search/tux/b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/search/tux/b;", "tuxStatisticIoc", "Lcom/tencent/tuxmetersdk/impl/event/TuxEvent;", "G", "Lkotlin/Lazy;", "i0", "()Lcom/tencent/tuxmetersdk/impl/event/TuxEvent;", "tuxEvent", "H", "e0", "()Lcom/tencent/tuxmeterqui/config/TuxNativeSurveySetting;", "d0", "()Landroid/app/Activity;", "<init>", "()V", "I", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchTuxSection extends BaseSearchTemplateSection<d> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private al bind;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private i currentTuxReportDataItem;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.search.tux.b tuxStatisticIoc;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy tuxEvent;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy nativeSurveySetting;

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/search/tux/NetSearchTuxSection$b", "Lcom/tencent/mobileqq/search/tux/f;", "Lcom/tencent/tuxmetersdk/model/Question;", "question", "Lcom/tencent/tuxmetersdk/model/Option;", "option", "", "url", "", "onStarQuestionClick", "Lcom/tencent/tuxmetersdk/impl/TuxSurveyConfig;", "surveyConfig", "onSurveyClose", "onSurveySubmit", "", "a", "Z", "getHasClick", "()Z", "setHasClick", "(Z)V", "hasClick", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements f {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean hasClick;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<TuxBaseNativeView> f284892c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f284893d;

        b(Ref.ObjectRef<TuxBaseNativeView> objectRef, Activity activity) {
            this.f284892c = objectRef;
            this.f284893d = activity;
        }

        @Override // com.tencent.tuxmeterqui.config.TuxEventListener
        public void onStarQuestionClick(@Nullable Question question, @Nullable Option option, @Nullable String url) {
            String str;
            f.a.a(this, question, option, url);
            if (this.hasClick) {
                return;
            }
            this.hasClick = true;
            View containerView = NetSearchTuxSection.this.getContainerView();
            if (containerView != null) {
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
                VideoReport.setElementParam(containerView, "satisfaction_degree", str);
                com.tencent.mobileqq.search.report.a.f(com.tencent.mobileqq.search.report.a.f283716a, "clck", containerView, null, 4, null);
            }
        }

        @Override // com.tencent.tuxmeterqui.config.TuxEventListener
        public void onSurveyClose(@Nullable TuxSurveyConfig surveyConfig) {
            f.a.b(this, surveyConfig);
            com.tencent.mobileqq.search.tux.b bVar = NetSearchTuxSection.this.tuxStatisticIoc;
            if (bVar != null) {
                bVar.f(true);
            }
            com.tencent.mobileqq.search.tux.b bVar2 = NetSearchTuxSection.this.tuxStatisticIoc;
            if (bVar2 != null) {
                bVar2.removeTuxItem();
            }
            TuxBaseNativeView tuxBaseNativeView = this.f284892c.element;
            if (tuxBaseNativeView != null) {
                tuxBaseNativeView.reportSurveyDisappearEvent(DisappearReason.SLIDE_DOWN);
            }
            QLog.i("NetSearchTuxSection", 1, "onSurveyClose");
        }

        @Override // com.tencent.tuxmeterqui.config.TuxEventListener
        public void onSurveyDisplayed(@Nullable TuxSurveyConfig tuxSurveyConfig) {
            f.a.c(this, tuxSurveyConfig);
        }

        @Override // com.tencent.tuxmeterqui.config.TuxEventListener
        public void onSurveySubmit(@Nullable TuxSurveyConfig surveyConfig) {
            f.a.d(this, surveyConfig);
            QQToastUtil.showQQToastInUiThread(2, this.f284893d.getString(R.string.f224776ju));
            TuxBaseNativeView tuxBaseNativeView = this.f284892c.element;
            if (tuxBaseNativeView != null) {
                tuxBaseNativeView.reportSurveyDisappearEvent(DisappearReason.SUBMIT);
            }
            QLog.i("NetSearchTuxSection", 1, "onSurveySubmit");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/search/tux/NetSearchTuxSection$c", "Lcom/tencent/tuxmetersdk/export/listener/ITuxTriggerFullListener;", "Lcom/tencent/tuxmetersdk/impl/TuxSurveyConfig;", "surveyConfig", "Lcom/tencent/tuxmetersdk/export/injector/event/ITuxSurveyEventCallback;", "surveyEventCallback", "", "onTrigger", "", "errInfo", "onFailure", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements ITuxTriggerFullListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f284895b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConstraintLayout f284896c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f284897d;

        c(d dVar, ConstraintLayout constraintLayout, Activity activity) {
            this.f284895b = dVar;
            this.f284896c = constraintLayout;
            this.f284897d = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(NetSearchTuxSection this$0, d data, ConstraintLayout rootView, Activity context, TuxSurveyConfig surveyConfig) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(rootView, "$rootView");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(surveyConfig, "$surveyConfig");
            TuxBaseNativeView b06 = this$0.b0(data.getTuxReportData(), rootView, context, surveyConfig, this$0.e0());
            if (b06 != null) {
                com.tencent.mobileqq.search.tux.b bVar = this$0.tuxStatisticIoc;
                if (bVar != null) {
                    bVar.b(surveyConfig);
                }
                com.tencent.mobileqq.search.tux.b bVar2 = this$0.tuxStatisticIoc;
                boolean z16 = false;
                if (bVar2 != null && !bVar2.getHasSearchTuxShowed()) {
                    z16 = true;
                }
                if (z16) {
                    b06.reportSurveyExposureEvent();
                    com.tencent.mobileqq.search.tux.b bVar3 = this$0.tuxStatisticIoc;
                    if (bVar3 != null) {
                        bVar3.e(true);
                    }
                }
            }
        }

        @Override // com.tencent.tuxmetersdk.export.listener.ITuxTriggerFullListener
        public void onFailure(@NotNull String errInfo) {
            Intrinsics.checkNotNullParameter(errInfo, "errInfo");
            NetSearchTuxSection.this.currentTuxReportDataItem = null;
            com.tencent.mobileqq.search.tux.b bVar = NetSearchTuxSection.this.tuxStatisticIoc;
            if (bVar != null) {
                bVar.removeTuxItem();
            }
            QLog.e("NetSearchTuxSection", 1, "onFailure errInfo:" + errInfo);
        }

        @Override // com.tencent.tuxmetersdk.export.listener.ITuxTriggerListener
        public void onTrigger(@NotNull final TuxSurveyConfig surveyConfig, @NotNull ITuxSurveyEventCallback surveyEventCallback) {
            Intrinsics.checkNotNullParameter(surveyConfig, "surveyConfig");
            Intrinsics.checkNotNullParameter(surveyEventCallback, "surveyEventCallback");
            QLog.i("NetSearchTuxSection", 1, "onTrigger surveyConfig=" + surveyConfig);
            if (!Intrinsics.areEqual(surveyConfig.getResource().getSceneId(), "138")) {
                surveyEventCallback.onReceiveTriggerErrorCode(surveyConfig, TriggerErrorCode.SCENE_ID_NOT_MATCH);
                QLog.w("NetSearchTuxSection", 1, "not match, sceneId=" + surveyConfig.getResource().getSceneId());
                return;
            }
            surveyEventCallback.onStartWhenTrigger(surveyConfig);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final NetSearchTuxSection netSearchTuxSection = NetSearchTuxSection.this;
            final d dVar = this.f284895b;
            final ConstraintLayout constraintLayout = this.f284896c;
            final Activity activity = this.f284897d;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.tux.e
                @Override // java.lang.Runnable
                public final void run() {
                    NetSearchTuxSection.c.b(NetSearchTuxSection.this, dVar, constraintLayout, activity, surveyConfig);
                }
            });
        }
    }

    public NetSearchTuxSection() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TuxEvent>() { // from class: com.tencent.mobileqq.search.tux.NetSearchTuxSection$tuxEvent$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TuxEvent invoke() {
                HashMap hashMapOf;
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("page_id", "qq_search_network"));
                return new TuxEvent("page_load", hashMapOf);
            }
        });
        this.tuxEvent = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TuxNativeSurveySetting>() { // from class: com.tencent.mobileqq.search.tux.NetSearchTuxSection$nativeSurveySetting$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TuxNativeSurveySetting invoke() {
                TuxNativeSurveySetting.Builder isDarkMode = new TuxNativeSurveySetting.Builder().isDarkMode(NetSearchTuxSection.this.d0() != null ? je0.a.a(NetSearchTuxSection.this.d0()) : false);
                TuxQuestionConfig tuxQuestionConfig = new TuxQuestionConfig();
                TuxQuestionConfig.TuxUIConfig tuxUIConfig = new TuxQuestionConfig.TuxUIConfig();
                tuxUIConfig.parentViewBackgroundColor = 0;
                tuxQuestionConfig.uiConfig = tuxUIConfig;
                TuxNativeSurveySetting.Builder viewQuestionConfig = isDarkMode.setViewQuestionConfig(tuxQuestionConfig);
                TuxQuestionConfig tuxQuestionConfig2 = new TuxQuestionConfig();
                NetSearchTuxSection netSearchTuxSection = NetSearchTuxSection.this;
                TuxQuestionConfig.TuxUIConfig tuxUIConfig2 = new TuxQuestionConfig.TuxUIConfig();
                tuxUIConfig2.titleTextSizeSp = 16.0f;
                if (netSearchTuxSection.d0() != null) {
                    tuxUIConfig2.titleTextColor = R.color.qui_common_text_primary;
                }
                tuxUIConfig2.titleTypeface = 0;
                tuxQuestionConfig2.uiConfig = tuxUIConfig2;
                return viewQuestionConfig.addStarStarQuestionConfig(tuxQuestionConfig2).build();
            }
        });
        this.nativeSurveySetting = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, android.view.View, com.tencent.tuxmeterqui.view.TuxBaseNativeView] */
    public final TuxBaseNativeView b0(i tuxReportData, ViewGroup tuxParentView, Activity activity, TuxSurveyConfig surveyConfig, TuxNativeSurveySetting nativeSurveySetting) {
        SearchTuxPresenter.INSTANCE.a(surveyConfig, tuxReportData);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? tuxNativeSurveyView = TuxMeterUI.getInstance().getTuxNativeSurveyView(activity, surveyConfig, nativeSurveySetting, new b(objectRef, activity));
        if (tuxNativeSurveyView != 0) {
            tuxParentView.removeAllViews();
            tuxParentView.addView(tuxNativeSurveyView);
            objectRef.element = tuxNativeSurveyView;
        }
        return tuxNativeSurveyView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TuxNativeSurveySetting e0() {
        Object value = this.nativeSurveySetting.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-nativeSurveySetting>(...)");
        return (TuxNativeSurveySetting) value;
    }

    private final TuxEvent i0() {
        return (TuxEvent) this.tuxEvent.getValue();
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull d data, int position, @Nullable List<Object> payload) {
        ConstraintLayout constraintLayout;
        Activity d06;
        TuxSurveyConfig tuxSurveyConfig;
        Intrinsics.checkNotNullParameter(data, "data");
        al alVar = this.bind;
        if (alVar == null || (constraintLayout = alVar.f405601b) == null || (d06 = d0()) == null || Intrinsics.areEqual(this.currentTuxReportDataItem, data.getTuxReportData())) {
            return;
        }
        com.tencent.mobileqq.search.tux.b bVar = this.tuxStatisticIoc;
        boolean z16 = false;
        if (bVar != null && bVar.getHasSearchTuxClosed()) {
            z16 = true;
        }
        if (z16) {
            com.tencent.mobileqq.search.tux.b bVar2 = this.tuxStatisticIoc;
            if (bVar2 != null) {
                bVar2.removeTuxItem();
                return;
            }
            return;
        }
        this.currentTuxReportDataItem = data.getTuxReportData().a();
        com.tencent.mobileqq.search.tux.b bVar3 = (com.tencent.mobileqq.search.tux.b) SectionIOCKt.getIocInterface(this, com.tencent.mobileqq.search.tux.b.class);
        this.tuxStatisticIoc = bVar3;
        if (bVar3 != null) {
            tuxSurveyConfig = bVar3.getCacheSurveyConfig();
        } else {
            tuxSurveyConfig = null;
        }
        TuxSurveyConfig tuxSurveyConfig2 = tuxSurveyConfig;
        if (tuxSurveyConfig2 != null) {
            b0(data.getTuxReportData(), constraintLayout, d06, tuxSurveyConfig2, e0());
            QLog.i("NetSearchTuxSection", 1, "bind just recreate view, tuxItem=" + data.getTuxReportData());
            return;
        }
        QLog.i("NetSearchTuxSection", 1, "start reportWithTriggerListener");
        TuxMeterSDK.getInstance().reportWithTriggerListener(i0(), new c(data, constraintLayout, d06));
    }

    @Nullable
    public final Activity d0() {
        Context context = this.mRootView.getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public int N(@NotNull d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable View containerView) {
        if (containerView != null) {
            this.bind = al.e(containerView);
        }
    }
}
