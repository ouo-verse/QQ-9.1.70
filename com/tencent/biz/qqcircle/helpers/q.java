package com.tencent.biz.qqcircle.helpers;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.fragments.message.item.QFSBaseMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSCategoryMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSChatMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSDefaultNoticeMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSFollowMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSHeadMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSMessageFriendRecomContractGuideItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSMessageFriendRecomHeadItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSMessageFriendRecomItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSMessageLoadMoreItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSMessageMsgRecomHeadItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSMessageQuickThankItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSMultiPersonalMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSNewFriendThankMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSNormalMessageItemView;
import com.tencent.biz.qqcircle.fragments.message.item.QFSSplitLineItemView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QFSMessageNoticeDeleteRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.IQZoneRedPointApi;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StNoticeCategory;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StGetNoticeCategoriesPageRsp;
import feedcloud.FeedCloudRead$StNoticeCategoryItem;
import feedcloud.FeedCloudWrite$StDelNoticeCategoryPageAndDetailRsp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleClientData$MsgBizReport;
import qqcircle.QQCircleCounter$MergePsvRedPointsRsp;
import qqcircle.QQCircleCounterMsg$MergePsvRedPoint;
import qqcircle.QQCircleFeedBase$StNoticeBusiData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class q {

    /* renamed from: h, reason: collision with root package name */
    private static volatile q f84649h;

    /* renamed from: i, reason: collision with root package name */
    private static final Map<Integer, Class<? extends QFSBaseMessageItemView>> f84650i;

    /* renamed from: b, reason: collision with root package name */
    private long f84652b;

    /* renamed from: d, reason: collision with root package name */
    private long f84654d;

    /* renamed from: f, reason: collision with root package name */
    private long f84656f;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, QQCircleCounterMsg$MergePsvRedPoint> f84651a = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final List<QCircleRecentDataInterface> f84653c = new CopyOnWriteArrayList();

    /* renamed from: e, reason: collision with root package name */
    private boolean f84655e = false;

    /* renamed from: g, reason: collision with root package name */
    private final Set<String> f84657g = new ConcurrentSkipListSet();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements Comparator<QFSMessageItemInfo> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(QFSMessageItemInfo qFSMessageItemInfo, QFSMessageItemInfo qFSMessageItemInfo2) {
            if (qFSMessageItemInfo.getType() == -101) {
                return -1;
            }
            if (qFSMessageItemInfo2.getType() == -101) {
                return 1;
            }
            if (q.this.H(qFSMessageItemInfo)) {
                return -1;
            }
            if (q.this.H(qFSMessageItemInfo2)) {
                return 1;
            }
            if (qFSMessageItemInfo.isNeedTop()) {
                return -1;
            }
            if (qFSMessageItemInfo2.isNeedTop()) {
                return 1;
            }
            return Long.compare(qFSMessageItemInfo2.getMessageTimestamp(), qFSMessageItemInfo.getMessageTimestamp());
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudWrite$StDelNoticeCategoryPageAndDetailRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VSDispatchObserver.OnVSRspCallBack f84659a;

        b(VSDispatchObserver.OnVSRspCallBack onVSRspCallBack) {
            this.f84659a = onVSRspCallBack;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudWrite$StDelNoticeCategoryPageAndDetailRsp feedCloudWrite$StDelNoticeCategoryPageAndDetailRsp) {
            if (!z16 || j3 != 0) {
                QLog.e("QFSMessageListHelper", 1, "deleteMessage error:retCode=" + j3 + ",errorMsg=" + str + ",traceId=" + baseRequest.getTraceId());
                QCircleToast.h(R.string.f188363wh, 2000);
            }
            VSDispatchObserver.OnVSRspCallBack onVSRspCallBack = this.f84659a;
            if (onVSRspCallBack != null) {
                onVSRspCallBack.onReceive(baseRequest, z16, j3, str, feedCloudWrite$StDelNoticeCategoryPageAndDetailRsp);
            }
        }
    }

    static {
        ArrayMap arrayMap = new ArrayMap();
        f84650i = arrayMap;
        arrayMap.put(-101, QFSHeadMessageItemView.class);
        arrayMap.put(-102, QFSCategoryMessageItemView.class);
        arrayMap.put(-103, QFSChatMessageItemView.class);
        arrayMap.put(0, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(3, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(5, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(6, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(7, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(8, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(9, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(10, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(11, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(13, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(14, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(31, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(1, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(2, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(19, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(20, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(21, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(22, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(23, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(24, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(25, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(29, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(30, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(32, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(34, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(35, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(36, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(37, QFSDefaultNoticeMessageItemView.class);
        arrayMap.put(4, QFSFollowMessageItemView.class);
        arrayMap.put(-1000, QFSSplitLineItemView.class);
        arrayMap.put(-1001, QFSMessageLoadMoreItemView.class);
        arrayMap.put(-1002, QFSMessageFriendRecomHeadItemView.class);
        arrayMap.put(-1006, QFSMessageMsgRecomHeadItemView.class);
        arrayMap.put(-1007, QFSMessageFriendRecomItemView.class);
        arrayMap.put(-104, QFSMessageFriendRecomItemView.class);
        arrayMap.put(-1005, QFSMessageFriendRecomContractGuideItemView.class);
        arrayMap.put(-1004, QFSMessageQuickThankItemView.class);
        arrayMap.put(12, QFSNormalMessageItemView.class);
        arrayMap.put(18, QFSNormalMessageItemView.class);
        arrayMap.put(33, QFSNormalMessageItemView.class);
        arrayMap.put(15, QFSNormalMessageItemView.class);
        arrayMap.put(17, QFSMultiPersonalMessageItemView.class);
        arrayMap.put(38, QFSNewFriendThankMessageItemView.class);
        arrayMap.put(39, QFSDefaultNoticeMessageItemView.class);
    }

    private void D(@NonNull FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp, boolean z16, boolean z17) {
        if (z16) {
            return;
        }
        QQCircleCounter$MergePsvRedPointsRsp qQCircleCounter$MergePsvRedPointsRsp = new QQCircleCounter$MergePsvRedPointsRsp();
        try {
            qQCircleCounter$MergePsvRedPointsRsp.mergeFrom(feedCloudRead$StGetNoticeCategoriesPageRsp.red_point_bytes.get().toByteArray());
            T(qQCircleCounter$MergePsvRedPointsRsp);
        } catch (Exception e16) {
            QLog.e("QFSMessageListHelper", 1, "getNoticeBusiData error" + e16.getMessage());
        }
        if (z17) {
            h();
        }
        this.f84652b = feedCloudRead$StGetNoticeCategoriesPageRsp.rsp_timestamp.get();
        PBRepeatMessageField<QQCircleCounterMsg$MergePsvRedPoint> pBRepeatMessageField = qQCircleCounter$MergePsvRedPointsRsp.redPoints;
        for (int i3 = 0; i3 < pBRepeatMessageField.size(); i3++) {
            QQCircleCounterMsg$MergePsvRedPoint qQCircleCounterMsg$MergePsvRedPoint = pBRepeatMessageField.get(i3);
            if (qQCircleCounterMsg$MergePsvRedPoint.categoryID.get() != 0) {
                this.f84651a.put(String.valueOf(qQCircleCounterMsg$MergePsvRedPoint.categoryID.get()), qQCircleCounterMsg$MergePsvRedPoint);
            }
            if (!TextUtils.isEmpty(qQCircleCounterMsg$MergePsvRedPoint.feedID.get())) {
                this.f84651a.put(qQCircleCounterMsg$MergePsvRedPoint.feedID.get(), qQCircleCounterMsg$MergePsvRedPoint);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H(QFSMessageItemInfo qFSMessageItemInfo) {
        if (qFSMessageItemInfo != null && qFSMessageItemInfo.getType() == -100 && qFSMessageItemInfo.getStNotice() != null && qFSMessageItemInfo.getStNotice().noticeType.get() == 33) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I() {
        ((IQZoneRedPointApi) QRoute.api(IQZoneRedPointApi.class)).refreshRedPoint();
        QLog.d("QFSMessageListHelper", 1, "[qqVideoRedPoint]real refreshQzoneRedPoint");
    }

    private void R(@NonNull FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp, @NonNull List<QFSMessageItemInfo> list) {
        if (!feedCloudRead$StGetNoticeCategoriesPageRsp.has_more.get()) {
            this.f84654d = 0L;
        } else if (!RFSafeListUtils.isEmpty(list)) {
            this.f84654d = list.get(list.size() - 1).getMessageTimestamp();
        }
    }

    private void T(@NonNull QQCircleCounter$MergePsvRedPointsRsp qQCircleCounter$MergePsvRedPointsRsp) {
        boolean canTogetherRefreshWithQQVideo = ((IQZoneRedPointApi) QRoute.api(IQZoneRedPointApi.class)).canTogetherRefreshWithQQVideo(qQCircleCounter$MergePsvRedPointsRsp.hasQzonePsv.get());
        QLog.d("QFSMessageListHelper", 1, "[qqVideoRedPoint]tryRefreshQzoneRedPoint qzoneFlag:" + qQCircleCounter$MergePsvRedPointsRsp.hasQzonePsv.get() + ",canTogetherRefreshWithQQVideo:" + canTogetherRefreshWithQQVideo);
        if (canTogetherRefreshWithQQVideo) {
            k();
        }
    }

    private void e(PBRepeatMessageField<FeedCloudRead$StNoticeCategoryItem> pBRepeatMessageField, boolean z16, @NonNull List<QFSMessageItemInfo> list, String str, boolean z17) {
        if (pBRepeatMessageField == null) {
            QLog.e("QFSMessageListHelper", 1, "[addNormalItems] items is null");
            return;
        }
        for (int i3 = 0; i3 < pBRepeatMessageField.size(); i3++) {
            FeedCloudRead$StNoticeCategoryItem feedCloudRead$StNoticeCategoryItem = pBRepeatMessageField.get(i3);
            if (feedCloudRead$StNoticeCategoryItem.type.get() == 1) {
                FeedCloudMeta$StNoticeCategory feedCloudMeta$StNoticeCategory = feedCloudRead$StNoticeCategoryItem.category;
                QFSMessageItemInfo qFSMessageItemInfo = new QFSMessageItemInfo(-102);
                qFSMessageItemInfo.setStNoticeCategory(feedCloudMeta$StNoticeCategory);
                qFSMessageItemInfo.setTraceId(str);
                qFSMessageItemInfo.setIsListTopItem(z17);
                qFSMessageItemInfo.setMessageTimestamp(feedCloudMeta$StNoticeCategory.newest_notice_timestamp.get());
                list.add(qFSMessageItemInfo);
            } else if (feedCloudRead$StNoticeCategoryItem.type.get() == 0) {
                QFSMessageItemInfo qFSMessageItemInfo2 = new QFSMessageItemInfo(-100);
                FeedCloudMeta$StNotice feedCloudMeta$StNotice = feedCloudRead$StNoticeCategoryItem.notice;
                qFSMessageItemInfo2.setStNotice(feedCloudMeta$StNotice);
                qFSMessageItemInfo2.setTraceId(str);
                qFSMessageItemInfo2.setIsListTopItem(z17);
                qFSMessageItemInfo2.setMessageTimestamp(feedCloudMeta$StNotice.createTime.get());
                qFSMessageItemInfo2.setNoticeBusiData(x(feedCloudMeta$StNotice, z16));
                qFSMessageItemInfo2.setUserBusiData(C(feedCloudMeta$StNotice, z16));
                list.add(qFSMessageItemInfo2);
            }
        }
    }

    private void f(@NonNull FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp, boolean z16, @NonNull List<QFSMessageItemInfo> list) {
        ArrayMap arrayMap = new ArrayMap();
        PBRepeatMessageField<FeedCloudRead$StNoticeCategoryItem> pBRepeatMessageField = feedCloudRead$StGetNoticeCategoriesPageRsp.top_items;
        for (int i3 = 0; i3 < pBRepeatMessageField.size(); i3++) {
            FeedCloudRead$StNoticeCategoryItem feedCloudRead$StNoticeCategoryItem = pBRepeatMessageField.get(i3);
            if (feedCloudRead$StNoticeCategoryItem != null) {
                if (feedCloudRead$StNoticeCategoryItem.type.get() == 0 && feedCloudRead$StNoticeCategoryItem.notice.noticeType.get() == 33) {
                    QFSMessageItemInfo qFSMessageItemInfo = new QFSMessageItemInfo(-100);
                    FeedCloudMeta$StNotice feedCloudMeta$StNotice = feedCloudRead$StNoticeCategoryItem.notice;
                    qFSMessageItemInfo.setStNotice(feedCloudMeta$StNotice);
                    qFSMessageItemInfo.setMessageTimestamp(feedCloudMeta$StNotice.createTime.get());
                    qFSMessageItemInfo.setNoticeBusiData(x(feedCloudMeta$StNotice, z16));
                    qFSMessageItemInfo.setUserBusiData(C(feedCloudMeta$StNotice, z16));
                    list.add(qFSMessageItemInfo);
                } else if (feedCloudRead$StNoticeCategoryItem.type.get() == 1) {
                    FeedCloudMeta$StNoticeCategory feedCloudMeta$StNoticeCategory = feedCloudRead$StNoticeCategoryItem.category;
                    int i16 = feedCloudMeta$StNoticeCategory.f398455id.get();
                    if (i16 != 1 && i16 != 2 && i16 != 3) {
                        if (i16 == 4) {
                            QFSMessageItemInfo qFSMessageItemInfo2 = new QFSMessageItemInfo(-102);
                            qFSMessageItemInfo2.setNeedTop(true);
                            qFSMessageItemInfo2.setStNoticeCategory(feedCloudMeta$StNoticeCategory);
                            list.add(qFSMessageItemInfo2);
                        }
                    } else {
                        arrayMap.put(Integer.valueOf(feedCloudMeta$StNoticeCategory.f398455id.get()), feedCloudMeta$StNoticeCategory);
                    }
                }
            }
        }
        if (!arrayMap.isEmpty()) {
            QFSMessageItemInfo qFSMessageItemInfo3 = new QFSMessageItemInfo(-101);
            qFSMessageItemInfo3.setNeedTop(true);
            qFSMessageItemInfo3.setHeadNoticeCategoryMap(arrayMap);
            list.add(qFSMessageItemInfo3);
        }
    }

    private void k() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.helpers.p
            @Override // java.lang.Runnable
            public final void run() {
                q.I();
            }
        }, 2000L);
    }

    private void o(List<QCircleRecentDataInterface> list) {
        if (this.f84654d <= 0) {
            return;
        }
        Iterator<QCircleRecentDataInterface> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getDisplayTime() < this.f84654d) {
                it.remove();
            }
        }
    }

    private void p(List<QCircleRecentDataInterface> list, int i3) {
        if (F(i3)) {
            ListIterator<QCircleRecentDataInterface> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (!TextUtils.isEmpty(listIterator.next().getExtraInfo())) {
                    listIterator.remove();
                }
            }
        }
    }

    private void q(@Nullable List<QFSMessageItemInfo> list, @NonNull List<QCircleRecentDataInterface> list2) {
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        for (QFSMessageItemInfo qFSMessageItemInfo : list) {
            if (qFSMessageItemInfo.getType() == -103) {
                Iterator<QCircleRecentDataInterface> it = list2.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().getRecentUserUin(), qFSMessageItemInfo.getRecentData().getRecentUserUin())) {
                        it.remove();
                    }
                }
            }
        }
    }

    public static q r() {
        if (f84649h == null) {
            synchronized (q.class) {
                if (f84649h == null) {
                    f84649h = new q();
                }
            }
        }
        return f84649h;
    }

    public Map<Integer, Class<? extends QFSBaseMessageItemView>> A() {
        return f84650i;
    }

    public long B() {
        return this.f84652b;
    }

    public QQCircleBase$StUserBusiData C(FeedCloudMeta$StNotice feedCloudMeta$StNotice, boolean z16) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        if (feedCloudMeta$StNotice.noticeType.get() == 1) {
            feedCloudMeta$StUser = feedCloudMeta$StNotice.operation.comment.postUser.get();
        } else if (feedCloudMeta$StNotice.noticeType.get() == 2) {
            List<FeedCloudMeta$StReply> list = feedCloudMeta$StNotice.operation.comment.vecReply.get();
            if (!RFSafeListUtils.isEmpty(list)) {
                feedCloudMeta$StUser = list.get(list.size() - 1).postUser;
            } else {
                feedCloudMeta$StUser = null;
            }
        } else {
            feedCloudMeta$StUser = feedCloudMeta$StNotice.operation.opUser.get();
        }
        QQCircleBase$StUserBusiData userExtraData = QCircleHostUtil.getUserExtraData(feedCloudMeta$StUser);
        if (userExtraData != null && z16) {
            userExtraData.has_unread_feed.set(false);
        }
        return userExtraData;
    }

    public boolean E() {
        return this.f84655e;
    }

    public boolean F(int i3) {
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    public boolean G(String str) {
        return this.f84657g.contains(str);
    }

    public void J(List<QCircleRecentDataInterface> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (QCircleRecentDataInterface qCircleRecentDataInterface : list) {
            if (qCircleRecentDataInterface != null) {
                Iterator<QCircleRecentDataInterface> it = this.f84653c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    QCircleRecentDataInterface next = it.next();
                    if (next.getContactId() == qCircleRecentDataInterface.getContactId()) {
                        this.f84653c.remove(next);
                        break;
                    }
                }
                arrayList.add(qCircleRecentDataInterface);
            }
        }
        if (arrayList.size() > 0) {
            this.f84653c.addAll(arrayList);
        }
    }

    public boolean K(boolean z16, boolean z17, long j3, FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp) {
        if (z16 && j3 == 0 && !z17 && feedCloudRead$StGetNoticeCategoriesPageRsp != null && feedCloudRead$StGetNoticeCategoriesPageRsp.rsp_timestamp.has()) {
            return true;
        }
        return false;
    }

    public void L(QFSMessageItemInfo qFSMessageItemInfo) {
        if (qFSMessageItemInfo == null) {
            return;
        }
        this.f84657g.add(qFSMessageItemInfo.getMsgId());
    }

    public void M() {
        RFWLog.d("QFSMessageListHelper", RFWLog.USR, "onPageExit");
        this.f84657g.clear();
    }

    public synchronized void N(List<QFSMessageItemInfo> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            return;
        }
        Iterator<QFSMessageItemInfo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == -103) {
                it.remove();
            }
        }
    }

    public void O(int i3) {
        P(String.valueOf(i3));
    }

    public void P(String str) {
        QQCircleCounterMsg$MergePsvRedPoint qQCircleCounterMsg$MergePsvRedPoint = this.f84651a.get(str);
        if (qQCircleCounterMsg$MergePsvRedPoint != null) {
            qQCircleCounterMsg$MergePsvRedPoint.num.set(0);
            qQCircleCounterMsg$MergePsvRedPoint.type.set(0);
        }
    }

    public void Q(long j3) {
        this.f84656f = j3;
    }

    public synchronized void S(@NonNull List<QFSMessageItemInfo> list) {
        Collections.sort(list, new a());
    }

    public synchronized void c(@NonNull List<QFSMessageItemInfo> list, int i3) {
        d(null, list, i3);
    }

    public synchronized void d(@Nullable List<QFSMessageItemInfo> list, @NonNull List<QFSMessageItemInfo> list2, int i3) {
        List<QCircleRecentDataInterface> s16 = r().s();
        p(s16, i3);
        if (RFSafeListUtils.isEmpty(s16)) {
            QLog.e("QFSMessageListHelper", 1, "addFilterChatItems chatDataList is empty");
            return;
        }
        QLog.d("QFSMessageListHelper", 1, "addFilterChatItems needFilterList.size = " + RFSafeListUtils.getSize(list) + ", chatDataList.size = " + RFSafeListUtils.getSize(list2));
        n(list, s16);
        for (QCircleRecentDataInterface qCircleRecentDataInterface : s16) {
            QFSMessageItemInfo qFSMessageItemInfo = new QFSMessageItemInfo(-103);
            qFSMessageItemInfo.setRecentData(qCircleRecentDataInterface);
            qFSMessageItemInfo.setMessageTimestamp(qCircleRecentDataInterface.getDisplayTime());
            list2.add(qFSMessageItemInfo);
        }
    }

    public void g() {
        this.f84653c.clear();
    }

    public void h() {
        this.f84651a.clear();
    }

    public void i(QCircleRecentDataInterface qCircleRecentDataInterface) {
        if (qCircleRecentDataInterface == null) {
            return;
        }
        for (QCircleRecentDataInterface qCircleRecentDataInterface2 : this.f84653c) {
            if (qCircleRecentDataInterface2.getContactId() == qCircleRecentDataInterface.getContactId()) {
                this.f84653c.remove(qCircleRecentDataInterface2);
                return;
            }
        }
    }

    public void j(QFSMessageItemInfo qFSMessageItemInfo, VSDispatchObserver.OnVSRspCallBack onVSRspCallBack) {
        QFSMessageNoticeDeleteRequest qFSMessageNoticeDeleteRequest;
        int type = qFSMessageItemInfo.getType();
        if (type == -100) {
            qFSMessageNoticeDeleteRequest = new QFSMessageNoticeDeleteRequest(qFSMessageItemInfo.getStNotice());
        } else if (type == -102) {
            qFSMessageNoticeDeleteRequest = new QFSMessageNoticeDeleteRequest(qFSMessageItemInfo.getStNoticeCategory().f398455id.get());
        } else {
            qFSMessageNoticeDeleteRequest = null;
        }
        if (qFSMessageNoticeDeleteRequest == null) {
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(qFSMessageNoticeDeleteRequest, new b(onVSRspCallBack));
    }

    public void l(FeedCloudMeta$StNotice feedCloudMeta$StNotice, Map<String, Object> map) {
        if (feedCloudMeta$StNotice != null && map != null) {
            m(feedCloudMeta$StNotice.busiReport.get().toByteArray(), map);
        }
    }

    public void m(byte[] bArr, Map<String, Object> map) {
        QQCircleClientData$MsgBizReport qQCircleClientData$MsgBizReport = new QQCircleClientData$MsgBizReport();
        try {
            qQCircleClientData$MsgBizReport.mergeFrom(bArr);
            if (!TextUtils.isEmpty(qQCircleClientData$MsgBizReport.datongJsonData.get())) {
                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleClientData$MsgBizReport.datongJsonData.get());
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            QLog.w("QFSMessageListHelper", 1, "dtMessageView, transferInfo error");
        }
    }

    public synchronized List<QCircleRecentDataInterface> n(@Nullable List<QFSMessageItemInfo> list, @NonNull List<QCircleRecentDataInterface> list2) {
        q(list, list2);
        o(list2);
        return list2;
    }

    public List<QCircleRecentDataInterface> s() {
        return new ArrayList(this.f84653c);
    }

    public long t() {
        return this.f84656f;
    }

    public List<QFSMessageItemInfo> u(@NonNull FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp, boolean z16, boolean z17) {
        this.f84655e = z16;
        D(feedCloudRead$StGetNoticeCategoriesPageRsp, z16, z17);
        ArrayList arrayList = new ArrayList();
        f(feedCloudRead$StGetNoticeCategoriesPageRsp, z16, arrayList);
        e(feedCloudRead$StGetNoticeCategoriesPageRsp.items, z16, arrayList, null, false);
        R(feedCloudRead$StGetNoticeCategoriesPageRsp, arrayList);
        return arrayList;
    }

    public List<QFSMessageItemInfo> v(@NonNull FeedCloudRead$StGetNoticeCategoriesPageRsp feedCloudRead$StGetNoticeCategoriesPageRsp, boolean z16, boolean z17, String str) {
        this.f84655e = z16;
        D(feedCloudRead$StGetNoticeCategoriesPageRsp, z16, z17);
        ArrayList arrayList = new ArrayList();
        e(feedCloudRead$StGetNoticeCategoriesPageRsp.top_items, z16, arrayList, str, true);
        e(feedCloudRead$StGetNoticeCategoriesPageRsp.items, z16, arrayList, str, false);
        R(feedCloudRead$StGetNoticeCategoriesPageRsp, arrayList);
        return arrayList;
    }

    public Map<String, Object> w(QCircleInitBean qCircleInitBean) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (qCircleInitBean != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_PAGE_REF_EID, qCircleInitBean.getLaunchFrom());
        }
        return buildElementParams;
    }

    public QQCircleFeedBase$StNoticeBusiData x(FeedCloudMeta$StNotice feedCloudMeta$StNotice, boolean z16) {
        QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData;
        if (feedCloudMeta$StNotice.busiData.get() != null) {
            qQCircleFeedBase$StNoticeBusiData = new QQCircleFeedBase$StNoticeBusiData();
            try {
                qQCircleFeedBase$StNoticeBusiData.mergeFrom(feedCloudMeta$StNotice.busiData.get().toByteArray());
            } catch (Exception e16) {
                QLog.e("QFSMessageListHelper", 1, "getNoticeBusiData error" + e16.getMessage());
            }
        } else {
            qQCircleFeedBase$StNoticeBusiData = null;
        }
        if (qQCircleFeedBase$StNoticeBusiData != null && z16) {
            qQCircleFeedBase$StNoticeBusiData.messageBoxRedPointInfo.needShow.set(false);
        }
        return qQCircleFeedBase$StNoticeBusiData;
    }

    public QQCircleCounterMsg$MergePsvRedPoint y(int i3) {
        return z(String.valueOf(i3));
    }

    public QQCircleCounterMsg$MergePsvRedPoint z(String str) {
        return this.f84651a.get(str);
    }
}
