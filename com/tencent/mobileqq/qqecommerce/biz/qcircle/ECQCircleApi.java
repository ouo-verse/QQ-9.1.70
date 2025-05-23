package com.tencent.mobileqq.qqecommerce.biz.qcircle;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ark.ark;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.f;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager;
import com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi;
import com.tencent.ecommerce.biz.qcircle.api.IECQCircleAvatarView;
import com.tencent.ecommerce.biz.qcircle.api.IECQCircleRichTextView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qqecommerce.base.video.ECVideoInfo;
import com.tencent.mobileqq.qqecommerce.biz.event.QFSHRGameTabCallbackEvent;
import com.tencent.mobileqq.qqecommerce.biz.event.QFSOpenCommentEvent;
import com.tencent.mobileqq.qqecommerce.biz.event.QFSOpenPersonalDetailPageEvent;
import com.tencent.mobileqq.qqecommerce.biz.event.QFSOpenSharePanelEvent;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.HRVideoView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import feedcloud.FeedCloudMeta$StFeed;
import fg2.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u001c\u0010\u000e\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0014\u0010\u000f\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J\u0014\u0010\u0010\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J\u001c\u0010\u0012\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0014\u0010\u0013\u001a\u00020\u00042\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J<\u0010 \u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a2\"\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u001cj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d`\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020&H\u0016J\b\u0010(\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J<\u0010.\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u0006H\u0016J2\u0010.\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010/H\u0016J2\u0010.\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0010\u00102\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n012\u0006\u00103\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0006H\u0016J\u0018\u00108\u001a\u00020\u00042\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u00020\fH\u0016JH\u0010=\u001a\u00020\u00042\u0006\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020&2\"\u0010<\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001cj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u001e2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0016J@\u0010A\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u00062\"\u0010?\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001cj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u001e2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030\nH\u0016R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/qcircle/ECQCircleApi;", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleApi;", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "", "a", "", QZoneClickReport.ClickReportConfig.SOURCE_FROM_MAINENTRY, "subEntrance", "b", "Lcom/tencent/mobileqq/pb/MessageMicro;", "feedPb", "", "isPraise", "feedRequestDoLike", "openQCircleComment", "openQCircleSharePanel", "pageId", "preDownloadVideo", "openQCirclePersonalDetailPage", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleAvatarView;", "createQCircleAvatarView", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleRichTextView;", "createQCircleRichTextView", "", "viewWidth", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "propMap", "calculateQCircleRichTextHeight", "", "time", "getDateFormat", "getDeviceInfo", "getPluginQua", "", "getQQCirCurrentTabIndex", "getQQTabCurrentIndex", "getQua", "source", "subSource", "playPos", "pageName", "launchQCircleFeed", "Landroid/view/View;", "videoView", "", "feedPbList", "pageToken", "ktvPageClose", "Landroid/widget/ImageView;", "imageView", "url", "loadFeedImage", "getFeedMuteConfig", "actionType", "subActionType", "extra", "reportToDc5507", AdMetricTag.EVENT_NAME, "toStringMap", "stfeed", "reportToDt", "Lcom/tencent/mobileqq/qqecommerce/biz/qcircle/ECQCircleGetDeviceInfoRequest;", "Lcom/tencent/mobileqq/qqecommerce/biz/qcircle/ECQCircleGetDeviceInfoRequest;", "getDeviceInfoRequest", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECQCircleApi implements IECQCircleApi {

    /* renamed from: c, reason: collision with root package name */
    private static IECQCircleRichTextView f263370c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ECQCircleGetDeviceInfoRequest getDeviceInfoRequest = new ECQCircleGetDeviceInfoRequest();

    private final void a(JSONObject json) {
        String str;
        long optLong = json.optLong("tab_mask");
        if (optLong == 1) {
            str = QCircleDaTongConstant.ElementParamValue.TOTAL_FEEDCARD;
        } else if (optLong == 2) {
            str = QCircleDaTongConstant.ElementParamValue.XSJ_FEEDCARD;
        } else {
            str = "";
        }
        b(QCircleDaTongConstant.ElementParamValue.QQ_SEARCHBAR_RESULT_LEVEL2, str);
    }

    private final void b(String mainEntrance, String subEntrance) {
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_main_entrance", mainEntrance);
        params.put("xsj_sub_entrance", subEntrance);
        params.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_PAGE_STACK_NUM, Integer.valueOf(QCircleReportHelper.getQQCirclePageStackNum()));
        QCircleDTLoginReporter.executeDaTongLoginReport(params);
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public float calculateQCircleRichTextHeight(Context context, float viewWidth, HashMap<String, Object> propMap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(propMap, "propMap");
        if (f263370c == null) {
            f263370c = createQCircleRichTextView(context);
        }
        IECQCircleRichTextView iECQCircleRichTextView = f263370c;
        if (iECQCircleRichTextView != null) {
            iECQCircleRichTextView.setViewWidth(viewWidth);
        }
        IECQCircleRichTextView iECQCircleRichTextView2 = f263370c;
        if (iECQCircleRichTextView2 != null) {
            IECQCircleRichTextView.a.a(iECQCircleRichTextView2, propMap, false, 2, null);
        }
        IECQCircleRichTextView iECQCircleRichTextView3 = f263370c;
        if (iECQCircleRichTextView3 != null) {
            return iECQCircleRichTextView3.calculateViewHeight();
        }
        return 0.0f;
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public IECQCircleAvatarView createQCircleAvatarView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (IECQCircleAvatarView) LayoutInflater.from(context).inflate(R.layout.cvr, (ViewGroup) null).findViewById(R.id.ogs);
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public IECQCircleRichTextView createQCircleRichTextView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        KeyEvent.Callback inflate = LayoutInflater.from(context).inflate(R.layout.cvs, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.ecommerce.biz.qcircle.api.IECQCircleRichTextView");
        return (IECQCircleRichTextView) inflate;
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public void feedRequestDoLike(MessageMicro<?> feedPb, boolean isPraise) {
        Intrinsics.checkNotNullParameter(feedPb, "feedPb");
        if (feedPb instanceof FeedCloudMeta$StFeed) {
            if (QLog.isColorLevel()) {
                QLog.d("ECQCircleApi", 2, "feedRequestDoLike feedId:" + ((FeedCloudMeta$StFeed) feedPb).f398449id.get() + " isPraise:" + isPraise);
            }
            ha0.b.h((FeedCloudMeta$StFeed) feedPb, isPraise, BaseApplication.getContext());
            return;
        }
        QLog.e("ECQCircleApi", 1, "feedRequestDoLike error, feedPb:" + feedPb + " isPraise:" + isPraise);
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public String getDateFormat(long time) {
        String d16 = com.tencent.biz.qqcircle.widgets.comment.b.d(time);
        Intrinsics.checkNotNullExpressionValue(d16, "formatMessageDateTime(time)");
        return d16;
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public String getDeviceInfo() {
        return this.getDeviceInfoRequest.getDeviceInfo();
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public boolean getFeedMuteConfig() {
        return f.e();
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public String getPluginQua() {
        String pluginQUA = ((IQCircleConfigApi) QRoute.api(IQCircleConfigApi.class)).getPluginQUA();
        Intrinsics.checkNotNullExpressionValue(pluginQUA, "api(IQCircleConfigApi::class.java).pluginQUA");
        return pluginQUA;
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public int getQQCirCurrentTabIndex() {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        SimpleEventBus.getInstance().dispatchEvent(new QFSHRGameTabCallbackEvent(1, new Function1<Object, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.qcircle.ECQCircleApi$getQQCirCurrentTabIndex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Ref.IntRef.this.element = ((Integer) it).intValue();
            }
        }));
        return intRef.element;
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public int getQQTabCurrentIndex() {
        FragmentManager supportFragmentManager;
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        Fragment findFragmentByTag = (qBaseActivity == null || (supportFragmentManager = qBaseActivity.getSupportFragmentManager()) == null) ? null : supportFragmentManager.findFragmentByTag(MainFragment.class.getSimpleName());
        MainFragment mainFragment = findFragmentByTag instanceof MainFragment ? (MainFragment) findFragmentByTag : null;
        if (mainFragment != null) {
            return mainFragment.getCurrentTab();
        }
        return -1;
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public String getQua() {
        String qua3 = QUA.getQUA3();
        Intrinsics.checkNotNullExpressionValue(qua3, "getQUA3()");
        return qua3;
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public void ktvPageClose(String pageToken) {
        Intrinsics.checkNotNullParameter(pageToken, "pageToken");
        d.f398596a.b(pageToken);
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public void launchQCircleFeed(Context context, MessageMicro<?> feedPb, int source, int subSource, long playPos, String pageName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedPb, "feedPb");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        if (feedPb instanceof FeedCloudMeta$StFeed) {
            QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
            HashMap<String, String> hashMap = new HashMap<>(2);
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) feedPb;
            String str = feedCloudMeta$StFeed.f398449id.get();
            Intrinsics.checkNotNullExpressionValue(str, "feedPb.id.get()");
            hashMap.put("feedid", str);
            hashMap.put(QCircleSchemeAttr.Detail.CURRENT_TIME, String.valueOf(playPos));
            qCircleLayerBean.setSchemeAttrs(hashMap);
            qCircleLayerBean.setSourceType(source);
            qCircleLayerBean.getExtraTypeInfo().subSource = subSource;
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setSourceType(source);
            qCircleInitBean.getExtraTypeInfo().subSource = subSource;
            qCircleLayerBean.setTransInitBean(qCircleInitBean);
            qCircleLayerBean.setFeed(feedCloudMeta$StFeed);
            qCircleLayerBean.setGetFeedList(true);
            QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
            qQCircleFeedBase$StFeedListBusiReqData.isReqLayer.set(true);
            qCircleLayerBean.setFeedListBusiReqData(qQCircleFeedBase$StFeedListBusiReqData);
            qCircleInitBean.setFeedListBusiReqData(qQCircleFeedBase$StFeedListBusiReqData);
            c.u(context, qCircleLayerBean);
            return;
        }
        QLog.e("ECQCircleApi", 1, "launchQCircleFeed error, feedPb:" + feedPb);
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public void loadFeedImage(ImageView imageView, String url) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(url, "url");
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setTargetView(imageView).setUrl(url).setLoadingDrawableColor(0));
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public void openQCircleComment(MessageMicro<?> feedPb) {
        Intrinsics.checkNotNullParameter(feedPb, "feedPb");
        SimpleEventBus.getInstance().dispatchEvent(new QFSOpenCommentEvent(feedPb));
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public void openQCirclePersonalDetailPage(MessageMicro<?> feedPb) {
        Intrinsics.checkNotNullParameter(feedPb, "feedPb");
        SimpleEventBus.getInstance().dispatchEvent(new QFSOpenPersonalDetailPageEvent(feedPb));
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public void openQCircleSharePanel(MessageMicro<?> feedPb) {
        Intrinsics.checkNotNullParameter(feedPb, "feedPb");
        SimpleEventBus.getInstance().dispatchEvent(new QFSOpenSharePanelEvent(feedPb));
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public void preDownloadVideo(MessageMicro<?> feedPb, String pageId) {
        Intrinsics.checkNotNullParameter(feedPb, "feedPb");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        if (feedPb instanceof FeedCloudMeta$StFeed) {
            RFWVideoPreloadManager.g(126).preloadVideo(gb0.b.n((FeedCloudMeta$StFeed) feedPb, true), pageId);
        }
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public void reportToDc5507(int actionType, int subActionType, HashMap<String, String> extra, MessageMicro<?> feedPb) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(feedPb, "feedPb");
        if (feedPb instanceof FeedCloudMeta$StFeed) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c((FeedCloudMeta$StFeed) feedPb));
            dataBuilder.setActionType(actionType).setSubActionType(subActionType).setExtras(extra);
            QCircleLpReportDc05507.report(dataBuilder);
        }
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public void reportToDt(String eventName, HashMap<String, String> toStringMap, MessageMicro<?> stfeed) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(toStringMap, "toStringMap");
        Intrinsics.checkNotNullParameter(stfeed, "stfeed");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = stfeed instanceof FeedCloudMeta$StFeed ? (FeedCloudMeta$StFeed) stfeed : null;
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        if (feedCloudMeta$StFeed != null) {
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            Map<String, Object> e16 = ua0.c.e(feedCloudMeta$StFeed);
            Intrinsics.checkNotNullExpressionValue(e16, "convertDataToDTParamsMap(feed)");
            params.putAll(e16);
            params.put("xsj_custom_pgid", "pg_xsj_game_tab_page");
        }
        VideoReport.reportEvent(eventName, params);
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    public void launchQCircleFeed(Context context, int source, int subSource, String pageName, View videoView) {
        HRVideoView hRVideoView;
        ECVideoInfo eCVideoInfo;
        MessageMicro<?> g16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        if (!(videoView instanceof HRVideoView) || (eCVideoInfo = (hRVideoView = (HRVideoView) videoView).getCom.tencent.mobileqq.qcircle.api.constant.QCircleScheme.AttrDetail.VIDEO_INFO java.lang.String()) == null || (g16 = eCVideoInfo.g()) == null) {
            return;
        }
        launchQCircleFeed(context, g16, source, subSource, hRVideoView.r0(), pageName);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void launchQCircleFeed(Context context, List<? extends MessageMicro<?>> feedPbList, String pageToken, JSONObject json) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedPbList, "feedPbList");
        Intrinsics.checkNotNullParameter(pageToken, "pageToken");
        Intrinsics.checkNotNullParameter(json, "json");
        QLog.d("ECQCircleApi", 1, "#launchQCircleFeed: multiFeeds begin");
        ArrayList arrayList = new ArrayList();
        for (MessageMicro<?> messageMicro : feedPbList) {
            if (messageMicro instanceof FeedCloudMeta$StFeed) {
                arrayList.add(messageMicro);
            }
        }
        if (arrayList.isEmpty()) {
            QLog.w("ECQCircleApi", 1, "#launchQCircleFeed: no data");
            return;
        }
        QLog.d("ECQCircleApi", 1, "#launchQCircleFeed: feed size=" + arrayList.size() + ", json=" + json);
        boolean optBoolean = json.optBoolean("useOneDragN");
        String optString = json.optString("keyword");
        if (optBoolean) {
            if (optString != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(optString);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        QLog.w("ECQCircleApi", 1, "#launchQCircleFeed: useOneDragN=true, keyword=" + optString);
                        optBoolean = false;
                    }
                }
            }
            z16 = true;
            if (z16) {
            }
        }
        int optInt = json.optInt("sourceType");
        int optInt2 = json.optInt("subSourceType");
        String optString2 = json.optString("pageName");
        long optLong = json.optLong("playPosition");
        int optInt3 = json.optInt("playIndex");
        int i3 = optInt3 < arrayList.size() ? optInt3 : 0;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) arrayList.get(i3);
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        HashMap<String, String> hashMap = new HashMap<>(2);
        String str = feedCloudMeta$StFeed.f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "feedPb.id.get()");
        hashMap.put("feedid", str);
        hashMap.put(QCircleSchemeAttr.Detail.CURRENT_TIME, String.valueOf(optLong));
        qCircleLayerBean.setSchemeAttrs(hashMap);
        qCircleLayerBean.setSourceType(optInt);
        qCircleLayerBean.getExtraTypeInfo().subSource = optInt2;
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setSourceType(optInt);
        qCircleInitBean.getExtraTypeInfo().subSource = optInt2;
        qCircleLayerBean.setTransInitBean(qCircleInitBean);
        fg2.c a16 = d.f398596a.a(pageToken);
        a16.i2(optBoolean);
        a16.h2(optString);
        a16.f2(arrayList);
        qCircleLayerBean.setDataPosInList(i3);
        if (Intrinsics.areEqual(optString2, "qsearch_detail")) {
            qCircleLayerBean.setLayerBizAssemblerType("biz_qq_search");
            a(json);
        }
        qCircleLayerBean.setGlobalViewModelKey(a16.U1());
        qCircleLayerBean.setFeed(feedCloudMeta$StFeed);
        c.u(context, qCircleLayerBean);
    }
}
