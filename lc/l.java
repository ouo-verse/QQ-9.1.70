package lc;

import NS_MOBILE_FEEDS.mobile_detail_rsp;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.detail.business.protocol.QzoneGetFeedDetailRequest;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.publish.business.task.QZoneUploadShuoShuoTask;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Llc/l;", "Lcom/qzone/common/business/IQZoneServiceListener;", "Lcom/qzone/common/business/task/QZoneTask;", "task", "", "e", "onTaskResponse", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class l implements IQZoneServiceListener {

    /* renamed from: d, reason: collision with root package name */
    public static final l f414349d = new l();

    l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QZoneTask qZoneTask) {
        f414349d.e(qZoneTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QZoneTask qZoneTask) {
        f414349d.e(qZoneTask);
    }

    public final void e(QZoneTask task) {
        Map<String, String> map;
        Intrinsics.checkNotNullParameter(task, "task");
        if (TextUtils.isEmpty(task.clientKey)) {
            QLog.e("QZPublishX_QZPublishXMoodFakeFeedReqOperate", 1, "getShuoShuoFakeFeedRequest , localKey is empty!");
            return;
        }
        QLog.i("QZPublishX_QZPublishXMoodFakeFeedReqOperate", 1, "start get fake feed, fakeKey:" + task.clientKey);
        boolean z16 = task instanceof QZoneUploadShuoShuoTask;
        if (z16) {
            map = ((QZoneUploadShuoShuoTask) task).getLocalUrlMap();
        } else {
            map = (Map) task.getParameter("loacal_url_map");
        }
        QZoneTask qZoneTask = new QZoneTask(new QzoneGetFeedDetailRequest(LoginData.getInstance().getUin(), 311, task.clientKey, task.taskRetryCount), null, this, 10003);
        qZoneTask.clientKey = task.clientKey;
        qZoneTask.taskRetryCount = task.taskRetryCount + 1;
        if (z16) {
            qZoneTask.addParameter("shuoshuo_video_info", ((QZoneUploadShuoShuoTask) task).getVideoInfo());
        } else if (task.getParameter("shuoshuo_video_info") != null) {
            qZoneTask.addParameter("shuoshuo_video_info", task.getParameter("shuoshuo_video_info"));
        }
        if (map != null) {
            qZoneTask.addParameter("loacal_url_map", map);
        }
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(final QZoneTask task) {
        List emptyList;
        int i3;
        if (task == null || task.mType != 10003) {
            return;
        }
        if (task.succeeded()) {
            mobile_detail_rsp mobile_detail_rspVar = (mobile_detail_rsp) task.mRequest.rsp;
            if ((mobile_detail_rspVar != null ? mobile_detail_rspVar.detail_data : null) != null) {
                QLog.i("QZPublishX_QZPublishXMoodFakeFeedReqOperate", 1, "get fake feed succeed, clientKey:" + task.clientKey);
                BusinessFeedData businessFeedData = BusinessFeedData.createFrom(mobile_detail_rspVar.detail_data);
                businessFeedData.getLocalInfo().setHalfReal();
                businessFeedData.feedType = 4097;
                businessFeedData.getFeedCommInfo().clientkey = task.clientKey;
                Map<String, String> map = (Map) task.getParameter("loacal_url_map");
                c cVar = c.f414336a;
                Intrinsics.checkNotNullExpressionValue(businessFeedData, "businessFeedData");
                cVar.h(map, businessFeedData);
                ShuoshuoVideoInfo shuoshuoVideoInfo = (ShuoshuoVideoInfo) task.getParameter("shuoshuo_video_info");
                if (shuoshuoVideoInfo != null && businessFeedData.getVideoInfo() != null && !TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath)) {
                    businessFeedData.getVideoInfo().videoUrl = new VideoUrl(shuoshuoVideoInfo.mVideoPath);
                }
                com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().preCalculateData(businessFeedData, true);
                i iVar = i.f414345a;
                String str = task.clientKey;
                Intrinsics.checkNotNullExpressionValue(str, "task.clientKey");
                iVar.t(str, businessFeedData);
                return;
            }
        }
        UniAttribute uniAttribute = task.mUniAttr;
        if (uniAttribute != null && uniAttribute.containsKey("retry_time_interval") && task.mUniAttr.get("retry_time_interval") != null) {
            int parseInt = Integer.parseInt(task.mUniAttr.get("retry_time_interval").toString());
            QLog.e("QZPublishX_QZPublishXMoodFakeFeedReqOperate", 1, "get fake feed fail, errorCode:" + task.mResultCode + ", errormsg:" + task.f45835msg + ", retryCount:" + task.taskRetryCount + ", next retry time:" + parseInt + ", fakeKey:" + task.clientKey);
            if (parseInt > 0) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: lc.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.c(QZoneTask.this);
                    }
                }, parseInt * 1000);
                return;
            }
        }
        String timeOutConfig = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FAKE_FEED_RETRY_TIMEOUT, QzoneConfig.DefaultValue.DEFAULT_FAKE_FEED_RETRY_TIMEOUT);
        Intrinsics.checkNotNullExpressionValue(timeOutConfig, "timeOutConfig");
        List<String> split = new Regex("/").split(timeOutConfig, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr == null || (i3 = task.taskRetryCount) > strArr.length) {
            return;
        }
        int parseInt2 = Integer.parseInt(strArr[i3 - 1]);
        QLog.i("QZPublishX_QZPublishXMoodFakeFeedReqOperate", 1, "get fake feed fail(timeout), next retry time:" + parseInt2 + ", fakeKey:" + task.clientKey);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).postDelayed(new Runnable() { // from class: lc.k
            @Override // java.lang.Runnable
            public final void run() {
                l.d(QZoneTask.this);
            }
        }, (long) (parseInt2 * 1000));
    }
}
