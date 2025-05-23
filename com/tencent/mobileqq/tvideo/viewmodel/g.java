package com.tencent.mobileqq.tvideo.viewmodel;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.squareup.wire.AnyMessage;
import com.squareup.wire.ProtoAdapter;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.mobileqq.tvideo.net.utils.TVideoConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tvideo.protocol.pb.AdResponseInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.q;
import tvideo.GetVideoListResp;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0016\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016J\"\u0010\u001f\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dR\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010,\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010!\u001a\u0004\b\u001c\u0010#\"\u0004\b.\u0010%R\"\u00105\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R0\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010A\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010!\u001a\u0004\b?\u0010#\"\u0004\b@\u0010%R0\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020B\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u00108\u001a\u0004\bD\u0010:\"\u0004\bE\u0010<R\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/tvideo/viewmodel/g;", "Lcom/tencent/biz/qqcircle/immersive/layer/base/e;", "Ltvideo/GetVideoListResp;", "rsp", "", "q2", "Lfeedcloud/FeedCloudRead$StGetFeedListRsp;", ICustomDataEditor.STRING_PARAM_2, "r2", "", "errMsg", "", "retCode", "t2", "Lcom/tencent/mobileqq/tvideo/viewmodel/QFSTVideoFeedListRequest;", Const.BUNDLE_KEY_REQUEST, "x2", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "feeds", "B2", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "errorCode", "z2", "getLogTag", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "bean", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "channelId", "v2", "K", "Z", "isFirstRequest", "()Z", "setFirstRequest", "(Z)V", "L", "I", "getPageNum", "()I", Constants.BASE_IN_PLUGIN_VERSION, "(I)V", "pageNum", "M", "setLoadMore", "N", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "getInitBean", "()Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "setInitBean", "(Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;)V", "initBean", "", "P", "Ljava/util/Map;", "getPageContext", "()Ljava/util/Map;", "setPageContext", "(Ljava/util/Map;)V", "pageContext", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getHasFakeFeed", "setHasFakeFeed", "hasFakeFeed", "", BdhLogUtil.LogTag.Tag_Req, "getVrPageInfo", "E2", "vrPageInfo", "Lix2/a;", ExifInterface.LATITUDE_SOUTH, "Lix2/a;", "adFunnelVrReportHelper", "<init>", "()V", "T", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g extends com.tencent.biz.qqcircle.immersive.layer.base.e {

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isFirstRequest;

    /* renamed from: L, reason: from kotlin metadata */
    private int pageNum;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isLoadMore;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Map<String, String> pageContext;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean hasFakeFeed;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Map<String, ? extends Object> vrPageInfo;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private QCircleInitBean initBean = new QCircleInitBean();

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final ix2.a adFunnelVrReportHelper = new ix2.a();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2(long j3, String requestId, g this$0) {
        Intrinsics.checkNotNullParameter(requestId, "$requestId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        nw2.a aVar = new nw2.a();
        aVar.j(7).i(j3).k(requestId);
        this$0.adFunnelVrReportHelper.d(aVar, this$0.vrPageInfo);
    }

    private final void B2(final List<FeedCloudMeta$StFeed> feeds) {
        QAdThreadManager.INSTANCE.execIo(new Runnable() { // from class: com.tencent.mobileqq.tvideo.viewmodel.f
            @Override // java.lang.Runnable
            public final void run() {
                g.C2(g.this, feeds);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(g this$0, List feeds) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feeds, "$feeds");
        this$0.adFunnelVrReportHelper.e(feeds, null, this$0.vrPageInfo);
    }

    private final void q2(GetVideoListResp rsp) {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
        try {
            gy2.c.F(this.pageNum, rsp.data.report_map);
            feedCloudRead$StGetFeedListRsp.mergeFrom(rsp.data.st_get_feed_list_rsp.getValue().toByteArray());
            s2(feedCloudRead$StGetFeedListRsp);
            r2(rsp);
        } catch (Exception e16) {
            QLog.e("QFSLayerTVideoViewModel", 4, "decode error, e=" + e16.getMessage(), e16);
            u2(this, "\u89e3\u6790\u5931\u8d25", 0L, 2, null);
        }
    }

    private final void r2(GetVideoListResp rsp) {
        Map<String, String> map;
        GetVideoListResp.Data data;
        AnyMessage anyMessage;
        GetVideoListResp.Data data2 = rsp.data;
        Object obj = null;
        if (data2 != null) {
            map = data2.page_context;
        } else {
            map = null;
        }
        this.pageContext = map;
        if (!TextUtils.isEmpty(TVideoConfig.f304492a.b()) && (data = rsp.data) != null && (anyMessage = data.ad_rsp_info) != null) {
            try {
                ProtoAdapter<AdResponseInfo> ADAPTER = AdResponseInfo.ADAPTER;
                Intrinsics.checkNotNullExpressionValue(ADAPTER, "ADAPTER");
                obj = anyMessage.unpack(ADAPTER);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            AdResponseInfo adResponseInfo = (AdResponseInfo) obj;
            if (adResponseInfo != null) {
                q.a(TVideoConfig.f304492a.b(), adResponseInfo.ad_fresh_info.ad_fresh_inside_list, this.isFirstRequest);
                q.b(adResponseInfo.ad_fresh_info.ad_fresh_list);
            }
        }
    }

    private final void s2(FeedCloudRead$StGetFeedListRsp rsp) {
        boolean z16;
        LoadInfo loadInfo = this.f86506m;
        boolean z17 = true;
        if (rsp.isFinish.get() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        loadInfo.setFinish(z16);
        QLog.e("QFSLayerTVideoViewModel", 4, "handleFeedListResponse  pageNum =" + this.pageNum);
        this.pageNum = this.pageNum + 1;
        boolean z18 = this.isLoadMore;
        List<FeedCloudMeta$StFeed> list = rsp.vecFeed.get();
        if (rsp.isFinish.get() <= 0) {
            z17 = false;
        }
        k2(z18, list, z17, 0);
        List<FeedCloudMeta$StFeed> list2 = rsp.vecFeed.get();
        Intrinsics.checkNotNullExpressionValue(list2, "rsp.vecFeed.get()");
        B2(list2);
        if (rsp.vecFeed.get() != null) {
            com.tencent.mobileqq.tvideo.binge.data.b.d().g(rsp.vecFeed.get());
        }
    }

    private final void t2(String errMsg, long retCode) {
        boolean z16;
        if (!this.hasFakeFeed && this.pageNum == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        UIStateData<List<e30.b>> loadMore = UIStateData.obtainError(errMsg).setRetCode(retCode).setLoadMore(this.isLoadMore);
        if (!z16) {
            loadMore.setState(0);
        }
        this.D.setValue(loadMore);
    }

    static /* synthetic */ void u2(g gVar, String str, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        gVar.t2(str, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w2(g this$0, QFSTVideoFeedListRequest request, BaseRequest baseRequest, boolean z16, long j3, String str, GetVideoListResp getVideoListResp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        QLog.d("QFSLayerTVideoViewModel", 4, "isSuccess=" + z16 + " \uff1b retCode=" + j3 + " \uff1b errMsg=" + str + " \uff1b rsp=" + getVideoListResp);
        if (z16 && getVideoListResp != null && j3 == 0) {
            this$0.q2(getVideoListResp);
            return;
        }
        this$0.t2(str, j3);
        String traceId = request.getTraceId();
        Intrinsics.checkNotNullExpressionValue(traceId, "request.traceId");
        this$0.z2(traceId, j3);
    }

    private final void x2(final QFSTVideoFeedListRequest request) {
        QAdThreadManager.INSTANCE.execIo(new Runnable() { // from class: com.tencent.mobileqq.tvideo.viewmodel.d
            @Override // java.lang.Runnable
            public final void run() {
                g.y2(QFSTVideoFeedListRequest.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y2(QFSTVideoFeedListRequest request, g this$0) {
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        nw2.a aVar = new nw2.a();
        aVar.j(1).k(request.getTraceId());
        this$0.adFunnelVrReportHelper.c(aVar, this$0.vrPageInfo);
    }

    private final void z2(final String requestId, final long errorCode) {
        QAdThreadManager.INSTANCE.execIo(new Runnable() { // from class: com.tencent.mobileqq.tvideo.viewmodel.e
            @Override // java.lang.Runnable
            public final void run() {
                g.A2(errorCode, requestId, this);
            }
        });
    }

    public final void D2(int i3) {
        this.pageNum = i3;
    }

    public final void E2(@Nullable Map<String, ? extends Object> map) {
        this.vrPageInfo = map;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.e, com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseViewModel, com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerTVideoViewModel";
    }

    public final void v2(@Nullable QCircleInitBean bean, boolean isLoadMore, int channelId) {
        boolean z16;
        QLog.d("QFSLayerTVideoViewModel", 4, "requestFeedList");
        if (bean != null) {
            this.initBean = bean;
        }
        this.isLoadMore = isLoadMore;
        if (jy2.g.S(this.initBean.getFeed()) && isLoadMore) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.hasFakeFeed = z16;
        if (this.pageNum == 0 && !z16) {
            this.D.setValue(UIStateData.obtainLoading());
        }
        if (!isLoadMore) {
            this.pageContext = null;
        }
        final QFSTVideoFeedListRequest qFSTVideoFeedListRequest = new QFSTVideoFeedListRequest(new k(this.pageNum, this.pageContext, channelId, jy2.g.s(jy2.g.q(this.initBean.getFeed()))));
        x2(qFSTVideoFeedListRequest);
        sendRequest(qFSTVideoFeedListRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.tvideo.viewmodel.c
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj) {
                g.w2(g.this, qFSTVideoFeedListRequest, baseRequest, z17, j3, str, (GetVideoListResp) obj);
            }
        });
    }
}
