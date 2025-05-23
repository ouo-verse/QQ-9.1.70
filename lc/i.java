package lc;

import android.content.Intent;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.publish.business.publishqueue.common.CommonPublishVideoStatusInfo;
import com.qzone.publish.business.task.qzonealbumx.QZPublishXUploadShuoShuoTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.qqvideo.layer.QZoneQVideoFeedConvertManager;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b<\u0010=J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u0007Jp\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\"\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0019j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u001a2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001cJl\u0010 \u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020\u00172\"\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0019j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u001a2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001cJr\u0010!\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\"\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0019j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u001a2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001cJ\u0016\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u000eJ*\u0010'\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u000eJ \u0010(\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010+\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020)J@\u0010/\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2&\u0010,\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u001a2\b\u0010.\u001a\u0004\u0018\u00010-J\u000e\u00100\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u00102\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u0004J\u001e\u00105\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00104\u001a\u000203J\u0016\u00107\u001a\u0002062\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u000eR\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\t088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006>"}, d2 = {"Llc/i;", "", "Lcom/qzone/publish/business/task/qzonealbumx/QZPublishXUploadShuoShuoTask;", "task", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "businessFeedData", "", "v", "Lsm/i;", "listener", "i", "y", HippyTKDListViewAdapter.X, "", "clientKey", "", PhotoCategorySinglePicInfo.UPLOAD_TIME, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "poiInfo", "", "Lcom/qzone/publish/ui/model/MediaWrapper;", "mediaList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extendInfo", "", "shootParams", "f", QAdVrReportParams.ParamKey.MEDIA, "g", tl.h.F, "Lcom/qzone/publish/ui/model/c;", "params", "j", "lbsAddress", "fakeContent", "k", "l", "Lcom/qzone/publish/business/publishqueue/common/g;", "videoStatusInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "localUrlMap", "Lcom/qq/jce/wup/UniAttribute;", "uniAttr", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "feedData", "t", "", "type", "o", "", "u", "", "b", "Ljava/util/Set;", "publishListenerList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f414345a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Set<sm.i> publishListenerList = new LinkedHashSet();

    i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(String clientKey, CommonPublishVideoStatusInfo videoStatusInfo) {
        Intrinsics.checkNotNullParameter(clientKey, "$clientKey");
        Intrinsics.checkNotNullParameter(videoStatusInfo, "$videoStatusInfo");
        try {
            Iterator<T> it = publishListenerList.iterator();
            while (it.hasNext()) {
                ((sm.i) it.next()).z5(clientKey, videoStatusInfo);
            }
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    private final BusinessFeedData m(QZPublishXUploadShuoShuoTask task) {
        c cVar = c.f414336a;
        String str = task.clientKey;
        Intrinsics.checkNotNullExpressionValue(str, "task.clientKey");
        Map<String, String> localUrlMap = task.getLocalUrlMap();
        UniAttribute uniAttribute = task.mUniAttr;
        Intrinsics.checkNotNullExpressionValue(uniAttribute, "task.mUniAttr");
        BusinessFeedData f16 = cVar.f(str, localUrlMap, uniAttribute);
        if (f16 == null) {
            return null;
        }
        if (task.getVideoInfo() != null) {
            task.getVideoInfo().mIsFakeFeed = false;
            VideoInfo h16 = m.f414350a.h(task.getVideoInfo());
            long config = QzoneConfig.getInstance().getConfig("QZVideo", QzoneConfig.SECONDARY_CIRCLE_PLAY_SECOND_FAKEFEED_VALIDTIME, 4499);
            if (h16.videoTime <= config) {
                h16.validVideoTime = config;
                if (h16.playType == 1) {
                    h16.playType = (byte) 3;
                }
            }
            f16.setVideoInfo(h16);
            f16.getLocalInfo().setHalfReal();
            com.qzone.adapter.feedcomponent.i.H().O1(task.getCommentUniKey(), h16);
        }
        if (task.isTemplateShuoshuo()) {
            if (f16.getPictureInfo() != null && bl.c(f16.getPictureInfo().pics)) {
                f16.getPictureInfo().pics.get(0).audio_summary = task.getAudioSummary();
            }
            if (f16.getCellSummaryV2() != null && !TextUtils.isEmpty(f16.getCellSummaryV2().summary)) {
                f16.getCellSummaryV2().summary = "";
            }
        }
        f16.getPermissionInfo().permission_mask = 1 | f16.getPermissionInfo().permission_mask;
        if (task.getPoiInfo() != null) {
            if (!TextUtils.isEmpty(task.getPoiInfo().poiDefaultName)) {
                f16.getLbsInfo().location = task.getPoiInfo().poiDefaultName;
            } else {
                f16.getLbsInfo().location = task.getPoiInfo().address;
            }
        }
        f16.preCalculate();
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "$feedData");
        try {
            Iterator<T> it = publishListenerList.iterator();
            while (it.hasNext()) {
                ((sm.i) it.next()).I4(feedData);
            }
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(QZPublishXUploadShuoShuoTask task) {
        Intrinsics.checkNotNullParameter(task, "$task");
        for (sm.i iVar : publishListenerList) {
            try {
                String str = task.clientKey;
                Intrinsics.checkNotNullExpressionValue(str, "task.clientKey");
                iVar.v1(str);
            } catch (Exception e16) {
                xe.b.f447841a.d(e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(QZPublishXUploadShuoShuoTask task) {
        Intrinsics.checkNotNullParameter(task, "$task");
        try {
            l.f414349d.e(task);
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    private final void v(final BusinessFeedData businessFeedData) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: lc.h
            @Override // java.lang.Runnable
            public final void run() {
                i.w(BusinessFeedData.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(businessFeedData, "$businessFeedData");
        try {
            Iterator<T> it = publishListenerList.iterator();
            while (it.hasNext()) {
                ((sm.i) it.next()).i7(businessFeedData);
            }
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    public final synchronized void i(sm.i listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Set<sm.i> set = publishListenerList;
        if (set.contains(listener)) {
            RFWLog.e("QZPublishX_QZoneXPublishFakeFeedManager", RFWLog.USR, "[addPublishListener] contain listener:" + listener + ", size=" + set.size());
            return;
        }
        set.add(listener);
        RFWLog.d("QZPublishX_QZoneXPublishFakeFeedManager", RFWLog.USR, "[addPublishListener]  listener:" + listener + ", size=" + set.size());
    }

    public final void j(com.qzone.publish.ui.model.c params, String clientKey) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        QLog.i("QZPublishX_QZoneXPublishFakeFeedManager", 1, "addShuoShuoPicFakeFeed clientKey=" + clientKey + " | mClientKey=" + params.f51945g0);
        if (u(params, clientKey)) {
            return;
        }
        try {
            BusinessFeedData i3 = c.f414336a.i(params, clientKey);
            if (i3 == null) {
                return;
            }
            v(i3);
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    public final void k(com.qzone.publish.ui.model.c params, String clientKey, String lbsAddress, String fakeContent) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        QLog.i("QZPublishX_QZoneXPublishFakeFeedManager", 1, "addShuoShuoSingleVideoFakeFeed clientKey=" + clientKey + " | lbsAddress=" + lbsAddress + " | fakeContent=" + fakeContent + " | params=" + params);
        if (u(params, clientKey)) {
            return;
        }
        try {
            ShuoshuoVideoInfo videoInfo = params.M.get(0).getVideoInfo();
            if (videoInfo != null) {
                videoInfo.mIsFakeFeed = true;
            }
            v(c.f414336a.d(clientKey, lbsAddress, params, fakeContent, params.M.get(0).getVideoInfo(), null));
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    public final void n(String clientKey, HashMap<String, String> localUrlMap, UniAttribute uniAttr) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        QLog.i("QZPublishX_QZoneXPublishFakeFeedManager", 1, "handlePublishSuccess\uff0c clientKey=" + clientKey + ", uniAttr=" + uniAttr);
        if (TextUtils.isEmpty(clientKey) || uniAttr == null) {
            return;
        }
        try {
            BusinessFeedData f16 = c.f414336a.f(clientKey, localUrlMap, uniAttr);
            if (f16 == null) {
                QZLog.e("QZPublishX_QZoneXPublishFakeFeedManager", "handlePublishSuccess  businessFeedData == null");
            } else {
                o(f16, clientKey, 2);
            }
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    public final void o(final BusinessFeedData feedData, String clientKey, int type) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        QLog.i("QZPublishX_QZoneXPublishFakeFeedManager", 1, "handleBusinessAndNotifyUpdate clientKey=" + clientKey + ", feedData=" + feedData.getCommentInfo().feedkey + ", type=" + type);
        if (FeedManager.shouldFilterDeletedFakeFeed(feedData)) {
            return;
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: lc.g
            @Override // java.lang.Runnable
            public final void run() {
                i.p(BusinessFeedData.this);
            }
        });
        com.qzone.common.business.service.d.INSTANCE.a().g(clientKey, type, feedData);
    }

    public final void q(final QZPublishXUploadShuoShuoTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.mResultCode == -11258) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: lc.e
                @Override // java.lang.Runnable
                public final void run() {
                    i.r(QZPublishXUploadShuoShuoTask.this);
                }
            });
            return;
        }
        if ((task.getTotalImgCount() > 0 && task.isUploadMoodStep()) || task.isDynamicTask()) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: lc.f
                @Override // java.lang.Runnable
                public final void run() {
                    i.s(QZPublishXUploadShuoShuoTask.this);
                }
            }, 1000L);
            return;
        }
        BusinessFeedData m3 = m(task);
        if (m3 == null) {
            QLog.e("QZPublishX_QZoneXPublishFakeFeedManager", 1, "handlePublishShuoShuoTaskResponse  businessFeedData == null");
            return;
        }
        String str = task.clientKey;
        Intrinsics.checkNotNullExpressionValue(str, "task.clientKey");
        t(str, m3);
        if (TextUtils.isEmpty(task.mRequest.getContentCacheUnikey())) {
            return;
        }
        if (!Intrinsics.areEqual(task.mRequest.getContentCacheUnikey(), "content_cache_key_default_value")) {
            t5.a.b(task.mRequest.getContentCacheUnikey());
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AniversayFeedShareToQzoneSuccess", "\u5206\u4eab\u6210\u529f");
        if (task.succeeded()) {
            ToastUtil.s(config, 5);
        }
    }

    public final void t(String clientKey, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        QLog.i("QZPublishX_QZoneXPublishFakeFeedManager", 1, "handlePublishMoodTaskSuccess\uff0c clientKey=" + clientKey + ", feedskey=" + feedData.cellFeedCommInfo.feedskey);
        if (TextUtils.isEmpty(clientKey) || QZoneQVideoFeedConvertManager.f58793a.a(null, clientKey, feedData)) {
            return;
        }
        try {
            o(feedData, clientKey, 1);
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    public final boolean u(com.qzone.publish.ui.model.c params, String clientKey) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        ShuoshuoVideoInfo shuoshuoVideoInfo = params.f51946h;
        if (shuoshuoVideoInfo == null || TextUtils.isEmpty(shuoshuoVideoInfo.topicId)) {
            if (params.f51957s <= 0) {
                return false;
            }
            QLog.w("QZPublishX_QZoneXPublishFakeFeedManager", 1, "interceptNoGenerateFakeFeed  params.publishTime > 0");
            return true;
        }
        Intent intent = new Intent(PeakConstants.ACTION_TOPIC_VIDEO_FAKE_FEED);
        intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_CLIENTKEY, clientKey);
        intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_PATH, params.f51946h.mCoverUrl);
        intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_WIDTH, params.f51946h.mVideoWidth);
        intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_THUMB_HEIGHT, params.f51946h.mVideoHeight);
        intent.putExtra(PeakConstants.KEY_TOPIC_VIDEO_SHUOSHUO_CONTENT, params.f51934b);
        BaseApplication.getContext().sendBroadcast(intent);
        QLog.w("QZPublishX_QZoneXPublishFakeFeedManager", 1, "interceptNoGenerateFakeFeed  peak intercept");
        return true;
    }

    public final synchronized void x() {
        publishListenerList.clear();
        RFWLog.d("QZPublishX_QZoneXPublishFakeFeedManager", RFWLog.USR, "[removeAllPublishListener]");
    }

    public final synchronized void y(sm.i listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Set<sm.i> set = publishListenerList;
        set.remove(listener);
        RFWLog.d("QZPublishX_QZoneXPublishFakeFeedManager", RFWLog.USR, "[removePublishListener]  listener:" + listener + ", size=" + set.size());
    }

    public final void z(final String clientKey, final CommonPublishVideoStatusInfo videoStatusInfo) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(videoStatusInfo, "videoStatusInfo");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: lc.d
            @Override // java.lang.Runnable
            public final void run() {
                i.A(clientKey, videoStatusInfo);
            }
        });
    }

    public final void f(String clientKey, long uploadTime, CommonAlbumInfo albumInfo, LbsDataV2.PoiInfo poiInfo, List<? extends MediaWrapper> mediaList, HashMap<String, String> extendInfo, Map<String, String> shootParams) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(extendInfo, "extendInfo");
        QLog.i("QZPublishX_QZoneXPublishFakeFeedManager", 1, "addAlbumPicFakeFeed clientKey=" + clientKey + " | uploadTime=" + uploadTime + " | albumId=" + albumInfo.getAlbumId() + " | mediaSize=" + mediaList.size());
        try {
            v(c.f414336a.a(poiInfo, mediaList, clientKey, shootParams, extendInfo, uploadTime, albumInfo));
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    public final void g(String clientKey, long uploadTime, CommonAlbumInfo albumInfo, LbsDataV2.PoiInfo poiInfo, MediaWrapper media, HashMap<String, String> extendInfo, Map<String, String> shootParams) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(extendInfo, "extendInfo");
        String albumId = albumInfo != null ? albumInfo.getAlbumId() : null;
        QLog.i("QZPublishX_QZoneXPublishFakeFeedManager", 1, "addAlbumSingleVideoFakeFeed clientKey=" + clientKey + " | uploadTime=" + uploadTime + " | albumId=" + albumId + " | mediaPath=" + media.getVideoInfo().mVideoPath);
        try {
            v(c.f414336a.b(poiInfo, clientKey, media, shootParams, uploadTime, albumInfo, extendInfo));
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    public final void l(com.qzone.publish.ui.model.c params, String clientKey, String lbsAddress) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        QLog.i("QZPublishX_QZoneXPublishFakeFeedManager", 1, "addShuoShuoVideoMixFakeFeed clientKey=" + clientKey + " | lbsAddress=" + lbsAddress + " | params=" + params);
        if (u(params, clientKey)) {
            return;
        }
        try {
            c cVar = c.f414336a;
            long j3 = params.f51957s;
            ArrayList<MediaWrapper> arrayList = params.M;
            Intrinsics.checkNotNullExpressionValue(arrayList, "params.mediaWrapperList");
            Map<String, String> map = params.f51935b0;
            Intrinsics.checkNotNullExpressionValue(map, "params.storedExtendInfo");
            Map<String, String> map2 = params.f51954p;
            Map<String, byte[]> b16 = params.b();
            PublishEventTag publishEventTag = params.C;
            HashMap<String, String> hashMap = params.L;
            Intrinsics.checkNotNullExpressionValue(hashMap, "params.imagePanoramaMap");
            v(cVar.j(clientKey, j3, null, lbsAddress, arrayList, map, map2, b16, publishEventTag, hashMap));
        } catch (Exception e16) {
            xe.b.f447841a.d(e16);
        }
    }

    public final void h(String clientKey, long uploadTime, CommonAlbumInfo albumInfo, LbsDataV2.PoiInfo poiInfo, List<? extends MediaWrapper> mediaList, HashMap<String, String> extendInfo, Map<String, String> shootParams) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(extendInfo, "extendInfo");
        String albumId = albumInfo != null ? albumInfo.getAlbumId() : null;
        QLog.i("QZPublishX_QZoneXPublishFakeFeedManager", 1, "addAlbumVideoMixFakeFeed clientKey=" + clientKey + " | uploadTime=" + uploadTime + " | albumId=" + albumId + " | mediaSize=" + mediaList.size());
        try {
            c cVar = c.f414336a;
            String e16 = cVar.e(poiInfo);
            HashMap hashMap = new HashMap();
            cVar.g(mediaList, null, hashMap);
            v(cVar.j(clientKey, uploadTime, albumInfo, e16, mediaList, extendInfo, shootParams, null, null, hashMap));
        } catch (Exception e17) {
            xe.b.f447841a.d(e17);
        }
    }
}
