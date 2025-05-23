package l20;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.google.gson.Gson;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aioshare.QFSAIOSendDataManager;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSAIOFeedShareInitBean;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.request.QFSBatchGetFeedSharePanelRequest;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.util.LoadingUtil;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShare;
import feedcloud.FeedCloudRead$StBatchGetFeedSharePanelRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH\u0016R\u0014\u0010\u0018\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Ll20/d;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View$OnClickListener;", "", "G9", "C9", "Lfeedcloud/FeedCloudRead$StBatchGetFeedSharePanelRsp;", "rsp", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "feedList", "E9", "B9", "Landroid/os/Bundle;", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getLogTag", "v", NodeProps.ON_CLICK, "d", "Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "e", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mHalfScreenView", "f", "Landroid/view/View;", "mBottom", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "mTvSend", "<init>", "()V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d extends u implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "QFSAIOFeedShareBottomPart";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUSHalfScreenFloatingView mHalfScreenView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mBottom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mTvSend;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Ll20/d$a;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", ReportConstant.COSTREPORT_PREFIX, "", "", "getDynamicParams", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements IDynamicParams {
        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@NotNull String s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
            Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put(QCircleDaTongConstant.ElementParamKey.XSJ_CONTENT, new Gson().toJson(QFSAIOSendDataManager.f82679a.b()));
            return params;
        }
    }

    private final void B9() {
        TextView textView = this.mTvSend;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSend");
            textView = null;
        }
        VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_SEND_BUTTON);
        TextView textView3 = this.mTvSend;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSend");
            textView3 = null;
        }
        VideoReport.setElementExposePolicy(textView3, ExposurePolicy.REPORT_NONE);
        TextView textView4 = this.mTvSend;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSend");
        } else {
            textView2 = textView4;
        }
        VideoReport.setEventDynamicParams(textView2, new a());
    }

    private final void C9() {
        final List list = null;
        final Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getContext(), null, false);
        showLoadingDialog.show();
        List<FeedCloudMeta$StFeed> value = QFSAIOSendDataManager.f82679a.c().getValue();
        if (value != null) {
            list = CollectionsKt___CollectionsKt.toList(value);
        }
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = ((FeedCloudMeta$StFeed) it.next()).f398449id.get();
                Intrinsics.checkNotNullExpressionValue(str, "it.id.get()");
                arrayList.add(str);
            }
            QFSBatchGetFeedSharePanelRequest qFSBatchGetFeedSharePanelRequest = new QFSBatchGetFeedSharePanelRequest(arrayList, 0, 13);
            VSNetworkHelper vSNetworkHelper = VSNetworkHelper.getInstance();
            VSDispatchObserver.OnVSRspCallBack onVSRspCallBack = new VSDispatchObserver.OnVSRspCallBack() { // from class: l20.a
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                    d.D9(d.this, showLoadingDialog, list, baseRequest, z16, j3, str2, (FeedCloudRead$StBatchGetFeedSharePanelRsp) obj);
                }
            };
            Intrinsics.checkNotNull(onVSRspCallBack, "null cannot be cast to non-null type com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack<feedcloud.FeedCloudRead.StBatchGetFeedSharePanelRsp?>");
            vSNetworkHelper.sendRequest(qFSBatchGetFeedSharePanelRequest, onVSRspCallBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(d this$0, Dialog dialog, List this_apply, BaseRequest request, boolean z16, long j3, String errMsg, FeedCloudRead$StBatchGetFeedSharePanelRsp feedCloudRead$StBatchGetFeedSharePanelRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.d(this$0.TAG, 1, "requestData onReceive: dispatch Success:" + z16 + " | TraceId:" + request.getTraceId() + " | SeqId:" + request.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + errMsg);
        dialog.dismiss();
        if (feedCloudRead$StBatchGetFeedSharePanelRsp != null && !feedCloudRead$StBatchGetFeedSharePanelRsp.share_info.isEmpty() && z16) {
            this$0.E9(feedCloudRead$StBatchGetFeedSharePanelRsp, this_apply);
            return;
        }
        QLog.e(this$0.TAG, 1, "traceId: " + request.getTraceId() + ", isSuccess: " + z16);
        QQToast.makeText(this$0.getContext(), com.tencent.biz.qqcircle.utils.h.a(R.string.ci8), 0).show();
    }

    private final void E9(final FeedCloudRead$StBatchGetFeedSharePanelRsp rsp, final List<FeedCloudMeta$StFeed> feedList) {
        if (rsp.share_info == null) {
            QLog.e(this.TAG, 1, "rsp.shareInfo is null");
            return;
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mHalfScreenView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.t();
        Handler mainHandler = getMainHandler();
        Runnable runnable = new Runnable() { // from class: l20.c
            @Override // java.lang.Runnable
            public final void run() {
                d.F9(FeedCloudRead$StBatchGetFeedSharePanelRsp.this, feedList, this);
            }
        };
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mHalfScreenView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHalfScreenView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView3;
        }
        mainHandler.postDelayed(runnable, qUSHalfScreenFloatingView2.w());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(FeedCloudRead$StBatchGetFeedSharePanelRsp rsp, List feedList, d this$0) {
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        Intrinsics.checkNotNullParameter(feedList, "$feedList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<FeedCloudMeta$StShare> list = rsp.share_info.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.share_info.get()");
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            FeedCloudMeta$StShare feedCloudMeta$StShare = (FeedCloudMeta$StShare) obj;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) feedList.get(i3);
            feedCloudMeta$StFeed.share.set(feedCloudMeta$StShare);
            PBStringField pBStringField = feedCloudMeta$StShare.feed_id;
            pBStringField.set("0" + pBStringField.get());
            Activity activity = this$0.getActivity();
            if (activity != null) {
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                Intent s16 = QCircleBaseShareOperation.s(this$0.getActivity(), feedCloudMeta$StFeed);
                Bundle I9 = this$0.I9();
                s16.setClass(activity, QCircleHostClassHelper.getForwardRecentTranslucentActivityClass());
                s16.putExtras(I9);
                activity.startActivity(s16);
            }
            i3 = i16;
        }
    }

    private final void G9() {
        QFSAIOSendDataManager.f82679a.c().observe(getHostFragment(), new Observer() { // from class: l20.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.H9(d.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(d this$0, List list) {
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        View view = this$0.mBottom;
        Integer num = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottom");
            view = null;
        }
        if (z16) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
        TextView textView = this$0.mTvSend;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSend");
            textView = null;
        }
        Application application = RFWApplication.getApplication();
        Object[] objArr = new Object[1];
        if (list != null) {
            num = Integer.valueOf(list.size());
        }
        objArr[0] = num;
        textView.setText(application.getString(R.string.f195294e8, objArr));
    }

    private final Bundle I9() {
        QFSAIOFeedShareInitBean qFSAIOFeedShareInitBean;
        Bundle bundle = new Bundle();
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (qCircleInitBean instanceof QFSAIOFeedShareInitBean) {
            qFSAIOFeedShareInitBean = (QFSAIOFeedShareInitBean) qCircleInitBean;
        } else {
            qFSAIOFeedShareInitBean = null;
        }
        if (qFSAIOFeedShareInitBean != null) {
            String aioUin = qFSAIOFeedShareInitBean.getAioUin();
            int i3 = 1;
            if (qFSAIOFeedShareInitBean.getAioChatType() == 1) {
                i3 = 0;
            }
            bundle.putInt(QCircleHostConstants._ForwardRecentActivity.KEY_REQ(), 3);
            bundle.putInt(QCircleHostConstants._ForwardRecentActivity.KEY_DIRECT_SHOW_UIN_TYPE(), i3);
            bundle.putString(QCircleHostConstants._ForwardRecentActivity.KEY_DIRECT_SHOW_UIN(), aioUin);
            bundle.putString(QCircleHostConstants.AppConstants.Key.UIN(), aioUin);
            bundle.putInt(QCircleHostConstants.AppConstants.Key.UIN_TYPE(), i3);
        }
        return bundle;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!fb0.a.a(this.TAG) && v3.getId() == R.id.f111156kg) {
            C9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.x5m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026lf_screen_aio_feed_share)");
        this.mHalfScreenView = (QUSHalfScreenFloatingView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.abp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.bottom)");
        this.mBottom = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f111156kg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_send)");
        TextView textView = (TextView) findViewById3;
        this.mTvSend = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSend");
            textView = null;
        }
        textView.setOnClickListener(this);
        G9();
        B9();
    }
}
