package la0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSJumpPublishEvent;
import com.tencent.biz.qqcircle.wink.DTButtonInfo;
import com.tencent.biz.qqcircle.wink.e;
import com.tencent.biz.qqcircle.wink.f;
import com.tencent.biz.qqcircle.wink.g;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.api.IReportApi;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import oa0.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u0006\u0010!\u001a\u00020\u001d\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\b\u001a\u00020\u0004*\u00020\u0007H\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lla0/b;", "Landroid/view/View$OnClickListener;", "", "traceId", "", "d", "e", "Landroid/os/Bundle;", "a", "", "", "c", "b", "", "pageId", IProfileCardConst.KEY_FROM_TYPE, "f", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Ljava/lang/String;", "getLogTag", "()Ljava/lang/String;", "logTag", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lla0/a;", "Lla0/a;", "getDelegatee", "()Lla0/a;", "delegatee", "", h.F, "Z", "isPeakAliveWhenClick", "<init>", "(Ljava/lang/String;Landroid/content/Context;Lla0/a;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a delegatee;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isPeakAliveWhenClick;

    public b(@NotNull String logTag, @NotNull Context context, @NotNull a delegatee) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegatee, "delegatee");
        this.logTag = logTag;
        this.context = context;
        this.delegatee = delegatee;
    }

    private final void a(Bundle bundle) {
        IReportApi.ReportFeedInfo s16 = e.f93946a.s();
        bundle.putString("key_enter_wink_feed_id", s16.getFeedId());
        bundle.putInt("key_enter_wink_feed_position", s16.getFeedIndex());
        bundle.putString("key_enter_wink_feed_authorUin", s16.getFeedAuthorUin());
        bundle.putString("key_enter_wink_seal_transfer", s16.getSealTransfer());
        bundle.putString("key_enter_wink_feed_materialInfo", s16.getMaterialInfos());
    }

    private final Bundle b() {
        String str;
        Intent intent;
        Bundle extras;
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_qcircle_is_peak_alive_when_entry", this.isPeakAliveWhenClick);
        Activity activity = this.delegatee.getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (extras = intent.getExtras()) != null) {
            bundle.putAll(extras);
        }
        Object obj = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID);
        if (obj == null || (str = obj.toString()) == null) {
            str = "";
        }
        bundle.putString("xsj_ref_pgid", str);
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setFromReportBean(this.delegatee.getReportBean().m466clone());
        Unit unit = Unit.INSTANCE;
        bundle.putSerializable("key_bundle_common_init_bean", qCircleInitBean);
        bundle.putString("key_plus_entrance_location", this.delegatee.L8());
        bundle.putBoolean("key_is_from_feed_publish", true);
        bundle.putBoolean(QQWinkConstants.SHOW_DIALOG_BEFORE_JUMP, true);
        return bundle;
    }

    private final Map<String, Object> c() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        e eVar = e.f93946a;
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "this");
        eVar.p(buildElementParams);
        eVar.o(buildElementParams);
        buildElementParams.put("xsj_publish_location", eVar.w());
        buildElementParams.put("key_qcircle_report_page_id", Integer.valueOf(this.delegatee.getReportBean().getPageId()));
        Intrinsics.checkNotNullExpressionValue(buildElementParams, "QCircleDTParamBuilder().\u2026tBean().pageId)\n        }");
        return buildElementParams;
    }

    private final void d(String traceId) {
        QLog.i(this.logTag, 1, "handleJumpToWink ");
        f(this.delegatee.getPageId(), this.delegatee.G());
        g gVar = g.f93952a;
        Context activity = this.delegatee.getActivity();
        if (activity == null) {
            activity = this.context;
        }
        if (!gVar.a(activity, traceId, this.delegatee.G())) {
            QLog.e(this.logTag, 1, "handleJumpToWink, check break ");
            return;
        }
        boolean isPeakAlive = QCirclePluginInitHelper.isPeakAlive(this.context);
        this.isPeakAliveWhenClick = isPeakAlive;
        if (!isPeakAlive) {
            Context activity2 = this.delegatee.getActivity();
            if (activity2 == null) {
                activity2 = this.context;
            }
            QCirclePluginInitHelper.PreloadWink(activity2);
        }
        e(traceId);
    }

    private final void e(String traceId) {
        Bundle b16 = b();
        String b17 = c.b(b16, this.delegatee.getActivity());
        QLog.d(this.logTag, 1, "jumpToPublishPage, schema:" + b17 + " ");
        c.a(b16, this.delegatee.getActivity());
        a(b16);
        SimpleEventBus.getInstance().dispatchEvent(new QFSJumpPublishEvent());
        Map<String, Object> c16 = c();
        f fVar = f.f93951a;
        Context activity = this.delegatee.getActivity();
        if (activity == null) {
            activity = this.context;
        }
        fVar.a(activity, b16, this.delegatee.G(), traceId, c16);
    }

    private final void f(int pageId, int fromType) {
        e eVar = e.f93946a;
        eVar.g(pageId, fromType);
        eVar.l(new DTButtonInfo(null, null, 3, null));
        eVar.b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (!FastClickUtils.isFastDoubleClick(this.logTag)) {
            QLog.i(this.logTag, 1, "click publish start ");
            String traceId = QCirclePublishQualityReporter.getTraceId();
            try {
                com.tencent.biz.qqcircle.wink.h.f93953a.a(this.context, traceId, this.delegatee.G(), "");
            } catch (Exception e16) {
                QLog.e(this.logTag, 1, e16, new Object[0]);
            }
            if (this.delegatee.w8(v3)) {
                f(this.delegatee.getPageId(), this.delegatee.G());
            } else {
                Intrinsics.checkNotNullExpressionValue(traceId, "traceId");
                d(traceId);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
