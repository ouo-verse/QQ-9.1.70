package com.tencent.biz.qqcircle.adapter;

import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.immersive.part.window.QQLiveRemoteFloatWindowHelper;
import com.tencent.biz.qqcircle.immersive.views.live.QFSLiveAvatarAnimView;
import com.tencent.biz.qqcircle.immersive.views.live.QFSLiveDotWaveView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<FeedCloudMeta$StUser> C;

    /* renamed from: m, reason: collision with root package name */
    private IAegisLogApi f82647m = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ViewHolder {
        private QFSLiveDotWaveView E;
        private TextView F;
        private QFSLiveAvatarAnimView G;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.biz.qqcircle.adapter.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class ViewOnClickListenerC0842a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ FeedCloudMeta$StUser f82648d;

            ViewOnClickListenerC0842a(FeedCloudMeta$StUser feedCloudMeta$StUser) {
                this.f82648d = feedCloudMeta$StUser;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                EventCollector.getInstance().onViewClickedBefore(view);
                String str2 = this.f82648d.jumpUrl.get() + "&from=20";
                h.this.f82647m.i("QCircleLiveListAdapter", 1, "LiveViewHolder onClick jumpUrl=" + str2);
                String generateTraceId = ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).generateTraceId();
                String str3 = str2 + "&live_traceid=" + generateTraceId;
                ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterRoomByUrl(view.getContext(), str3);
                try {
                    str = Uri.parse(str3).getQueryParameter("roomid");
                } catch (Exception e16) {
                    QLog.e("QCircleLiveListAdapter", 1, "LiveViewHolder onClick parse roomid error", e16);
                    str = "";
                }
                ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(generateTraceId).roomId(str).eventId(QQLiveReportConstants.Event.E_ENTER_ROOM_CLICKED).ext6(QQLiveReportConstants.Scene.SCENE_QFS_FOLLOW_ENTRANCE).ext7(String.valueOf(System.currentTimeMillis())).ext8(String.valueOf(QQLiveRemoteFloatWindowHelper.f88336d.i())));
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public a(@NonNull View view) {
            super(view);
            this.G = (QFSLiveAvatarAnimView) view.findViewById(R.id.ykp);
            this.F = (TextView) view.findViewById(R.id.ykn);
            this.E = (QFSLiveDotWaveView) view.findViewById(R.id.ymi);
        }

        public void l(FeedCloudMeta$StUser feedCloudMeta$StUser) {
            this.F.setText(feedCloudMeta$StUser.nick.get());
            if (TextUtils.isEmpty(feedCloudMeta$StUser.icon.iconUrl.get())) {
                h.this.f82647m.i("QCircleLiveListAdapter", "bindData iconUrl=null");
                this.G.setAvatarDrawable(QCirclePluginGlobalInfo.p(feedCloudMeta$StUser.f398463id.get()));
            } else {
                this.G.setAvatarDrawable(URLDrawable.getDrawable(feedCloudMeta$StUser.icon.iconUrl.get()));
            }
            this.itemView.setOnClickListener(new ViewOnClickListenerC0842a(feedCloudMeta$StUser));
            QLog.i("QCircleLiveListAdapter", 1, "onBindViewHolder stUser=" + feedCloudMeta$StUser);
        }

        public void m(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3) {
            VideoReport.setElementExposePolicy(this.itemView, ExposurePolicy.REPORT_FIRST);
            VideoReport.setElementEndExposePolicy(this.itemView, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementId(this.itemView, QCircleDaTongConstant.ElementId.EM_XSJ_QQLIVE_AVATAR);
            VideoReport.setElementReuseIdentifier(this.itemView, feedCloudMeta$StUser.f398463id.get());
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQLIVE_INDEX, Integer.valueOf(i3 + 1));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StUser.f398463id.get());
            VideoReport.setElementParams(this.itemView, hashMap);
            VideoReport.setElementExposureMinRate(this.itemView, 0.1d);
        }

        public void o() {
            this.G.setEnablePlay(true);
            this.E.a();
        }

        public void p() {
            this.G.setEnablePlay(false);
            this.E.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b extends RecyclerView.ViewHolder {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), "mqqapi://vaslive/portal?source=1&from=1&qq_live_product_type=1&page=follow");
                h.this.f82647m.i("QCircleLiveListAdapter", 1, "MoreViewHolder onClick jumpUrl=mqqapi://vaslive/portal?source=1&from=1&qq_live_product_type=1&page=follow");
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public b(@NonNull View view) {
            super(view);
        }

        public void l(FeedCloudMeta$StUser feedCloudMeta$StUser) {
            this.itemView.setOnClickListener(new a());
        }
    }

    public h(List<FeedCloudMeta$StUser> list) {
        this.C = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.C.get(i3).type.get();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.C.get(i3);
        if (viewHolder instanceof a) {
            a aVar = (a) viewHolder;
            aVar.l(feedCloudMeta$StUser);
            aVar.m(feedCloudMeta$StUser, i3);
            return;
        }
        ((b) viewHolder).l(feedCloudMeta$StUser);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 1) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g3b, viewGroup, false));
        }
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g3c, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        this.f82647m.i("QCircleLiveListAdapter", 1, "onViewAttachedToWindow holder=" + viewHolder);
        if (viewHolder instanceof a) {
            ((a) viewHolder).o();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        this.f82647m.i("QCircleLiveListAdapter", 1, "onViewDetachedFromWindow holder=" + viewHolder);
        if (viewHolder instanceof a) {
            ((a) viewHolder).p();
        }
    }
}
