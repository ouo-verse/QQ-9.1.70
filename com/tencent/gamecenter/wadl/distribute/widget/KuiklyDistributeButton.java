package com.tencent.gamecenter.wadl.distribute.widget;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.distribute.data.ButtonDataBuilder;
import com.tencent.gamecenter.wadl.distribute.data.ButtonStatus;
import com.tencent.gamecenter.wadl.distribute.data.ButtonUiBuilder;
import com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nf2.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\bM\u0010NB\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u00a2\u0006\u0004\bM\u0010QB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u0012\u0006\u0010R\u001a\u00020\u0017\u00a2\u0006\u0004\bM\u0010SJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\f\u0010\u000e\u001a\u00020\u0006*\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\f\u0010\u0011\u001a\u00020\u000b*\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J \u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0010H\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010(\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J\n\u0010/\u001a\u0004\u0018\u00010.H\u0016J\n\u00101\u001a\u0004\u0018\u000100H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\u0010\u00103\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016J \u00104\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J \u00105\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\"\u0010;\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00122\b\u00108\u001a\u0004\u0018\u0001072\u0006\u0010:\u001a\u000209H\u0016J\b\u0010<\u001a\u00020\u0006H\u0014J\b\u0010=\u001a\u00020\u0006H\u0014J\b\u0010>\u001a\u00020\u0012H\u0016J\b\u0010?\u001a\u00020\u0006H\u0016R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010AR\u0016\u0010D\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010CR\u0016\u0010F\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010ER$\u0010J\u001a\u0012\u0012\u0004\u0012\u00020)0Gj\b\u0012\u0004\u0012\u00020)`H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010IR\u0014\u0010L\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010K\u00a8\u0006T"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/widget/KuiklyDistributeButton;", "Landroid/widget/FrameLayout;", "Lcom/tencent/gamecenter/wadl/distribute/widget/IDistributeButton;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Landroid/content/Context;", "context", "", "i", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder;", "builder", "b", "Lorg/json/JSONObject;", "c", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonDataBuilder;", "f", "", "a", "d", "", "appId", "", "followStatus", "subscribeStatus", "k", "", "progress", "taskStatus", "j", "Landroid/view/View;", "view", "l", "e", "setDataBuilder", "setUiBuilder", "update", "updateWithInitStatus", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonStatus;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "Lcom/tencent/gamecenter/wadl/distribute/listener/IButtonEventListener;", "listener", "addEventListener", "removeEventListener", "removeEventListeners", "Landroid/view/ViewGroup;", "getBgView", "Landroid/widget/TextView;", "getTipsView", "isKuiklyWidget", "onKuiklyWidgetClick", "onKuiklyDownloadTaskStatusChange", "onKuiklyFollowOrSubscribeStatusChange", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", NodeProps.ON_DETACHED_FROM_WINDOW, NodeProps.ON_ATTACHED_TO_WINDOW, "isKuiklyViewDetach", "removeKuiklyView", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "kuiklyRenderView", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder;", "uiBuilder", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonDataBuilder;", "dataBuilder", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "eventListeners", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonStatus;", "buttonStatus", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class KuiklyDistributeButton extends FrameLayout implements IDistributeButton, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile g kuiklyRenderView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ButtonUiBuilder uiBuilder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ButtonDataBuilder dataBuilder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<IButtonEventListener> eventListeners;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ButtonStatus buttonStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/gamecenter/wadl/distribute/widget/KuiklyDistributeButton$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ButtonUiBuilder f106924a;

        b(ButtonUiBuilder buttonUiBuilder) {
            this.f106924a = buttonUiBuilder;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f106924a.getBgCorner());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KuiklyDistributeButton(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean a() {
        if (this.uiBuilder == null) {
            QLog.e("wadl_distribute_KuiklyDistributeButton", 1, "uiBuilder has not set before update ");
            return false;
        }
        if (this.dataBuilder != null) {
            return true;
        }
        QLog.e("wadl_distribute_KuiklyDistributeButton", 1, "dataBuilder has not set before update");
        return false;
    }

    private final void b(ButtonUiBuilder builder) {
        ButtonUiBuilder buttonUiBuilder = this.uiBuilder;
        if (buttonUiBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
            buttonUiBuilder = null;
        }
        if (buttonUiBuilder.getIsWholeClipRound()) {
            setOutlineProvider(new b(builder));
            setClipToOutline(true);
        }
    }

    private final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("business", g());
        jSONObject.put(SensorJsPlugin.SENSOR_INTERVAL_UI, h());
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void d() {
        boolean z16;
        IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        g createKuiklyRenderView = iQQKuiklyFactory.createKuiklyRenderView(context, this);
        addView((View) createKuiklyRenderView);
        long currentTimeMillis = System.currentTimeMillis();
        String scheme = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAME_CENTER_DISTRIBUTE_BTN_CONFIG).optString(ZPlanPublishSource.FROM_SCHEME);
        if (scheme != null && scheme.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            scheme = "mqqapi://kuikly/open?src_type=web&version=1&page_name=QQGameCenterChannelDistributionCard&bundle_name=gamecenter_channel_distribution_card&sync_rendering=0&use_host_display_metrics=1";
        }
        if (QLog.isColorLevel()) {
            QLog.i("wadl_distribute_KuiklyDistributeButton", 2, "read scheme cost:" + (System.currentTimeMillis() - currentTimeMillis) + ",scheme:" + scheme);
        }
        Intrinsics.checkNotNullExpressionValue(scheme, "scheme");
        createKuiklyRenderView.d(scheme, null);
        ((View) createKuiklyRenderView).setBackgroundColor(0);
        createKuiklyRenderView.onResume();
        this.kuiklyRenderView = createKuiklyRenderView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e() {
        try {
            synchronized (this) {
                g gVar = this.kuiklyRenderView;
                if (gVar != 0) {
                    gVar.onDetach();
                    Intrinsics.checkNotNull(gVar, "null cannot be cast to non-null type android.view.View");
                    removeView((View) gVar);
                    this.kuiklyRenderView = null;
                }
            }
        } catch (Throwable th5) {
            QLog.e("wadl_distribute_KuiklyDistributeButton", 1, th5, new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014 A[Catch: all -> 0x0021, TRY_LEAVE, TryCatch #0 {all -> 0x0021, blocks: (B:3:0x0002, B:5:0x0008, B:10:0x0014), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JSONObject f(ButtonDataBuilder buttonDataBuilder) {
        String attaReportData;
        boolean z16;
        try {
            attaReportData = buttonDataBuilder.getAttaReportData();
        } catch (Throwable th5) {
            QLog.e("wadl_distribute_KuiklyDistributeButton", 1, th5, new Object[0]);
        }
        if (attaReportData != null && attaReportData.length() != 0) {
            z16 = false;
            if (!z16) {
                String attaReportData2 = buttonDataBuilder.getAttaReportData();
                Intrinsics.checkNotNull(attaReportData2);
                return new JSONObject(attaReportData2);
            }
            return new JSONObject();
        }
        z16 = true;
        if (!z16) {
        }
        return new JSONObject();
    }

    private final JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        jSONObject.put("aggregatedBuffer", buttonDataBuilder.getAggregatedBuffer());
        jSONObject.put("bufferFromCache", buttonDataBuilder.getBufferFromCache());
        jSONObject.put("gameChannelId", buttonDataBuilder.getApkChannel());
        jSONObject.put("attaReportData", f(buttonDataBuilder));
        jSONObject.put("isSupportSpark", buttonDataBuilder.getIsSupportSpark());
        jSONObject.put("sparkTaskKey", buttonDataBuilder.getSparkTaskKey());
        jSONObject.put(QQBrowserActivity.APP_PARAM, buttonDataBuilder.getExtraParams());
        jSONObject.put("guildID", buttonDataBuilder.getGuildID());
        return jSONObject;
    }

    private final JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        m(jSONObject);
        return jSONObject;
    }

    private final void i(Context context) {
        QLog.i("wadl_distribute_KuiklyDistributeButton", 2, "initView");
        setBackgroundColor(0);
        d();
    }

    private final void j(String appId, float progress, int taskStatus) {
        synchronized (this) {
            Iterator<IButtonEventListener> it = this.eventListeners.iterator();
            while (it.hasNext()) {
                it.next().onDownloadTaskStatusChange(appId, progress, taskStatus);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void k(String appId, int followStatus, int subscribeStatus) {
        synchronized (this) {
            Iterator<IButtonEventListener> it = this.eventListeners.iterator();
            while (it.hasNext()) {
                it.next().onFollowOrSubscribeStatusChange(appId, followStatus, subscribeStatus);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void l(View view) {
        synchronized (this) {
            Iterator<IButtonEventListener> it = this.eventListeners.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void m(JSONObject jSONObject) {
        ButtonUiBuilder buttonUiBuilder = this.uiBuilder;
        if (buttonUiBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
            buttonUiBuilder = null;
        }
        jSONObject.put("guildUIColor", buttonUiBuilder.getGuildUIColor());
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void addEventListener(@NotNull IButtonEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this) {
            if (!this.eventListeners.contains(listener)) {
                this.eventListeners.add(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    @Nullable
    public ViewGroup getBgView() {
        return null;
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    @NotNull
    /* renamed from: getStatus, reason: from getter */
    public ButtonStatus getButtonStatus() {
        return this.buttonStatus;
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    @Nullable
    public TextView getTipsView() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public boolean isKuiklyViewDetach() {
        if (this.kuiklyRenderView == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public boolean isKuiklyWidget() {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.i("wadl_distribute_KuiklyDistributeButton", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.i("wadl_distribute_KuiklyDistributeButton", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void onKuiklyDownloadTaskStatusChange(@NotNull String appId, float progress, int taskStatus) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        QLog.i("wadl_distribute_KuiklyDistributeButton", 2, "[onKuiklyDownloadTaskStatusChange] appId:" + appId + ",progress:" + progress + ",taskStatus:" + taskStatus);
        this.buttonStatus.setDownloadTaskStatus(taskStatus);
        j(appId, progress, taskStatus);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void onKuiklyFollowOrSubscribeStatusChange(@NotNull String appId, int followStatus, int subscribeStatus) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        QLog.i("wadl_distribute_KuiklyDistributeButton", 2, "[onKuiklyFollowOrSubscribeStatusChange] appId:" + appId + ",followStatus:" + followStatus + ",subscribeStatus:" + subscribeStatus);
        this.buttonStatus.setFollowStatus(followStatus);
        this.buttonStatus.setSubscribeStatus(subscribeStatus);
        k(appId, followStatus, subscribeStatus);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void onKuiklyWidgetClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        QLog.i("wadl_distribute_KuiklyDistributeButton", 2, "[onKuiklyWidgetClick] view:" + view);
        l(view);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.i("wadl_distribute_KuiklyDistributeButton", 1, "[onPageLoadComplete] isSucceed:" + isSucceed + ",errorReason:" + errorReason + ",executeMode:" + executeMode);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void removeEventListener(@NotNull IButtonEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this) {
            if (this.eventListeners.contains(listener)) {
                this.eventListeners.remove(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void removeEventListeners() {
        synchronized (this) {
            this.eventListeners.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void removeKuiklyView() {
        e();
        QLog.i("wadl_distribute_KuiklyDistributeButton", 1, "removeKuiklyView:" + hashCode());
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void setDataBuilder(@NotNull ButtonDataBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.dataBuilder = builder;
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void setUiBuilder(@NotNull ButtonUiBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.uiBuilder = builder;
        b(builder);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        h.a.c(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        h.a.d(this);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void update() {
        if (!a()) {
            return;
        }
        JSONObject c16 = c();
        QLog.i("wadl_distribute_KuiklyDistributeButton", 2, "updateWithInitStatus,covertDataToJson:" + c16);
        if (this.kuiklyRenderView == null) {
            QLog.e("wadl_distribute_KuiklyDistributeButton", 1, "update when kuiklyRenderView is null");
            return;
        }
        g gVar = this.kuiklyRenderView;
        if (gVar != null) {
            gVar.sentEvent("EVENT_GAME_CENTER_DISTRIBUTE_INFO_UPDATE", a.e(c16));
        }
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void updateWithInitStatus(int followStatus, int subscribeStatus) {
        update();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KuiklyDistributeButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KuiklyDistributeButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.eventListeners = new ArrayList<>();
        this.buttonStatus = new ButtonStatus(0, 0, 0);
        i(context);
    }
}
