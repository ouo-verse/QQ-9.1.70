package com.tencent.biz.subscribe.bizdapters;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.subscribe.widget.QCircleRecommendItemView;
import com.tencent.biz.subscribe.widget.QCircleRecommendNoneView;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StDittoFeed;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeQCircleFeedsAdapter extends MultiViewBlock<FeedCloudMeta$StFeed> {
    private String C;
    private String D;
    private boolean E;

    /* renamed from: m, reason: collision with root package name */
    private int f95763m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class SubscribeCircleFeedReportTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<SubscribeQCircleFeedsAdapter> f95764d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<QCircleRecommendItemView> f95765e;

        /* renamed from: f, reason: collision with root package name */
        private int f95766f;

        public SubscribeCircleFeedReportTask(SubscribeQCircleFeedsAdapter subscribeQCircleFeedsAdapter, QCircleRecommendItemView qCircleRecommendItemView, int i3) {
            this.f95764d = new WeakReference<>(subscribeQCircleFeedsAdapter);
            this.f95765e = new WeakReference<>(qCircleRecommendItemView);
            this.f95766f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SubscribeQCircleFeedsAdapter subscribeQCircleFeedsAdapter;
            WeakReference<SubscribeQCircleFeedsAdapter> weakReference = this.f95764d;
            QCircleRecommendItemView qCircleRecommendItemView = null;
            if (weakReference == null) {
                subscribeQCircleFeedsAdapter = null;
            } else {
                subscribeQCircleFeedsAdapter = weakReference.get();
            }
            if (subscribeQCircleFeedsAdapter == null) {
                QLog.e("SCF-SubscribeQCircleFeedsAdapter", 1, "[run] adapter should not be null.");
                return;
            }
            WeakReference<QCircleRecommendItemView> weakReference2 = this.f95765e;
            if (weakReference2 != null) {
                qCircleRecommendItemView = weakReference2.get();
            }
            subscribeQCircleFeedsAdapter.o0(qCircleRecommendItemView, this.f95766f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f95767d;

        a(int i3) {
            this.f95767d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SubscribeQCircleFeedsAdapter.this.n0(this.f95767d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b extends RecyclerView.ViewHolder {
        public QCircleRecommendItemView E;

        public b(QCircleRecommendItemView qCircleRecommendItemView) {
            super(qCircleRecommendItemView);
            this.E = qCircleRecommendItemView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c extends RecyclerView.ViewHolder {
        public QCircleRecommendNoneView E;

        public c(QCircleRecommendNoneView qCircleRecommendNoneView) {
            super(qCircleRecommendNoneView);
            this.E = qCircleRecommendNoneView;
        }
    }

    public SubscribeQCircleFeedsAdapter() {
        super(null);
        this.f95763m = 0;
        this.C = "";
        this.D = "";
        this.E = false;
    }

    private void k0(c cVar, int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        cVar.E.setData(feedCloudMeta$StFeed);
        cVar.E.setSourceType(this.f95763m);
        cVar.E.setDataSize(getNUM_BACKGOURND_ICON());
        cVar.E.setPosition(i3);
    }

    private void l0(@NonNull RecyclerView.ViewHolder viewHolder, int i3, int i16, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        b bVar = (b) viewHolder;
        bVar.E.setData(feedCloudMeta$StFeed);
        bVar.E.setOnClickListener(new a(i16));
        RFWThreadManager.getInstance().execOnSubThread(new SubscribeCircleFeedReportTask(this, bVar.E, i3));
    }

    private void m0(View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        String str;
        PBStringField pBStringField;
        if (view == null) {
            QLog.e("SCF-SubscribeQCircleFeedsAdapter", 1, "[bindViewReport] item view should not be null.");
            return;
        }
        if (feedCloudMeta$StFeed == null) {
            QLog.e("SCF-SubscribeQCircleFeedsAdapter", 1, "[bindViewReport] feed should not be null.");
            return;
        }
        PBStringField pBStringField2 = feedCloudMeta$StFeed.f398449id;
        String str2 = "";
        if (pBStringField2 == null) {
            str = "";
        } else {
            str = pBStringField2.get();
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
        if (feedCloudMeta$StUser != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
            str2 = pBStringField.get();
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_DYH_XSJFEED);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.DYH_FEED_NUM, Integer.valueOf(getDataList().size()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(i3 + 1));
        buildElementParams.put("xsj_feed_id", str);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str2);
        QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
        try {
            qQCircleFeedBase$StReportInfoForClient.mergeFrom(feedCloudMeta$StFeed.reportInfoForClient.get().toByteArray());
            if (!TextUtils.isEmpty(qQCircleFeedBase$StReportInfoForClient.datongJsonData.get())) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleFeedBase$StReportInfoForClient.datongJsonData.get());
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        VideoReport.setElementParams(view, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(int i3) {
        List<FeedCloudMeta$StFeed> list;
        String str;
        FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed;
        PBUInt32Field pBUInt32Field;
        List<FeedCloudMeta$StFeed> dataList = getDataList();
        if (dataList != null && dataList.size() > i3) {
            HashMap<String, String> hashMap = new HashMap<>();
            HashMap<String, byte[]> hashMap2 = new HashMap<>();
            ArrayList arrayList = new ArrayList();
            if (this.f95763m == 46) {
                list = new ArrayList<>();
                list.add((FeedCloudMeta$StFeed) RFSafeListUtils.get(dataList, i3));
            } else {
                list = dataList;
            }
            for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list) {
                if (feedCloudMeta$StFeed != null) {
                    String str2 = feedCloudMeta$StFeed.f398449id.get();
                    if (!TextUtils.isEmpty(str2) && ((feedCloudMeta$StDittoFeed = feedCloudMeta$StFeed.dittoFeed) == null || (pBUInt32Field = feedCloudMeta$StDittoFeed.dittoId) == null || pBUInt32Field.get() != 31)) {
                        arrayList.add(str2);
                        hashMap2.put(str2, feedCloudMeta$StFeed.toByteArray());
                    }
                }
            }
            Gson gson = new Gson();
            if (this.E) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put(QCircleSchemeAttr.Detail.IS_FIRST_LOGIN, str);
            hashMap.put(QCircleSchemeAttr.Detail.FEED_LIST_BYTE_ID, gson.toJson(arrayList));
            hashMap.put("feedid", dataList.get(i3).f398449id.get());
            hashMap.put("sourcetype", String.valueOf(this.f95763m));
            hashMap.put(QCircleSchemeAttr.Detail.FEED_ATTACH_INFO, this.C);
            hashMap.put("xsj_main_entrance", QCircleDaTongConstant.ElementParamValue.QQ_SUBSCRIPTION);
            hashMap.put("key_scheme", this.D);
            hashMap.put(QCircleSchemeAttr.Detail.IS_MIDDLE_PAGE, "1");
            int i16 = this.f95763m;
            if (i16 == 46) {
                hashMap.put("xsj_sub_entrance", QCircleDaTongConstant.ElementParamValue.EXPLORE_SINGLE_CONTENT);
                hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_DYH_EXPLORE_PAGE);
            } else if (i16 == 45) {
                hashMap.put("xsj_sub_entrance", QCircleDaTongConstant.ElementParamValue.FOLLOW_SINGLE_CONTENT);
                hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_DYH_FOLLOWING_PAGE);
            }
            com.tencent.mobileqq.activity.qcircle.utils.c.g().enterBySchemeAction(getContext(), QCircleScheme.Q_CIRCLE_ACTION_OPEN_CIRCLE_CONTENT_DETAIL, hashMap, hashMap2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(QCircleRecommendItemView qCircleRecommendItemView, int i3) {
        m0(qCircleRecommendItemView, (FeedCloudMeta$StFeed) RFSafeListUtils.get(getDataList(), i3), i3);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<E> list = this.mDataList;
        if (list == 0) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        PBUInt32Field pBUInt32Field;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) RFSafeListUtils.get(this.mDataList, i3);
        if (feedCloudMeta$StFeed == null) {
            QLog.e("SCF-SubscribeQCircleFeedsAdapter", 1, "[getItemViewType] error: ", new NullPointerException("current feed should not be null"));
            return 10089;
        }
        FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed = feedCloudMeta$StFeed.dittoFeed;
        if (feedCloudMeta$StDittoFeed == null || (pBUInt32Field = feedCloudMeta$StDittoFeed.dittoId) == null || pBUInt32Field.get() != 31) {
            return 10089;
        }
        return 10088;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) RFSafeListUtils.get(getDataList(), i3);
        if (viewHolder instanceof b) {
            l0(viewHolder, i3, i3, feedCloudMeta$StFeed);
        } else if (viewHolder instanceof c) {
            k0((c) viewHolder, i3, feedCloudMeta$StFeed);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        Context context = viewGroup.getContext();
        if (i3 == 10089) {
            return new b(new QCircleRecommendItemView(context));
        }
        if (i3 == 10088) {
            return new c(new QCircleRecommendNoneView(context));
        }
        return new b(new QCircleRecommendItemView(context));
    }

    public void p0(String str) {
        this.C = str;
    }

    public void q0(String str) {
        this.D = str;
    }

    public void r0(boolean z16) {
        this.E = z16;
    }

    public void s0(int i3) {
        this.f95763m = i3;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
