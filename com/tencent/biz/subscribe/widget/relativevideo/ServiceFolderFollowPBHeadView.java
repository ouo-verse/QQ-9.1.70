package com.tencent.biz.subscribe.widget.relativevideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.api.IPublicAccountReport;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.i;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes5.dex */
public class ServiceFolderFollowPBHeadView extends RelativeFeedBaseHeaderView {
    private static String S = "ServiceFolderFollowPBHeadView";
    private RecyclerView E;
    private TextView F;
    private LinearLayout G;
    private TextView H;
    private TextView I;
    private ServiceAccountFoldAdapter J;
    private LinearLayoutManager K;
    private boolean L;
    private String M;
    private RelativeLayout N;
    private ImageView P;
    private ViewPager Q;
    private QCircleServiceFolderView R;

    /* loaded from: classes5.dex */
    public static class ServiceAccountFoldAdapter extends RecyclerView.Adapter implements DecodeTaskCompletionListener {
        private RecyclerView C;
        private DragFrameLayout D;

        /* renamed from: h, reason: collision with root package name */
        private Context f96530h;

        /* renamed from: i, reason: collision with root package name */
        private i f96531i;

        /* renamed from: d, reason: collision with root package name */
        private boolean f96527d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f96528e = true;

        /* renamed from: m, reason: collision with root package name */
        private HashMap<String, Bitmap> f96532m = new HashMap<>();

        /* renamed from: f, reason: collision with root package name */
        private List<RecentContactInfo> f96529f = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class a extends RecyclerView.OnScrollListener {
            a() {
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                super.onScrollStateChanged(recyclerView, i3);
                if (ServiceAccountFoldAdapter.this.f96528e && !recyclerView.isComputingLayout() && i3 == 0) {
                    ServiceAccountFoldAdapter.this.f96528e = false;
                    ServiceAccountFoldAdapter.this.notifyDataSetChanged();
                }
            }
        }

        public ServiceAccountFoldAdapter(Context context, RecyclerView recyclerView) {
            this.f96530h = context;
            this.C = recyclerView;
            this.f96531i = new i(((BaseActivity) context).app, this, false);
        }

        private void t() {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ServiceAccountFoldAdapter.this.C != null) {
                        ServiceAccountFoldAdapter.this.f96528e = true;
                        if (!ServiceAccountFoldAdapter.this.C.isComputingLayout() && ServiceAccountFoldAdapter.this.C.getScrollState() == 0) {
                            ServiceAccountFoldAdapter.this.f96528e = false;
                            ServiceAccountFoldAdapter.this.notifyDataSetChanged();
                        }
                    }
                }
            });
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f96529f.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            b bVar = (b) viewHolder;
            bVar.h(this.f96527d);
            bVar.d(this.f96529f.get(i3), i3);
            EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new b(LayoutInflater.from(this.f96530h).inflate(R.layout.c9s, viewGroup, false), this.f96531i, this.f96532m, this.D);
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            if (bitmap != null && str != null && str.length() != 0) {
                this.f96532m.put(str, bitmap);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.C.getLayoutManager();
                for (int i17 = 0; i17 < getItemCount(); i17++) {
                    View findViewByPosition = linearLayoutManager.findViewByPosition(i17);
                    if (findViewByPosition != null) {
                        RecyclerView.ViewHolder childViewHolder = this.C.getChildViewHolder(findViewByPosition);
                        if (childViewHolder instanceof b) {
                            b bVar = (b) childViewHolder;
                            if (str.equals(String.valueOf(bVar.f96535d.getPeerUin()))) {
                                bVar.g(bVar.f96536e, str);
                                return;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        public void s() {
            HashMap<String, Bitmap> hashMap = this.f96532m;
            if (hashMap != null) {
                hashMap.clear();
            }
            i iVar = this.f96531i;
            if (iVar != null) {
                iVar.r();
            }
            if (this.D != null) {
                this.D = null;
            }
        }

        public void u(List<RecentContactInfo> list) {
            this.f96529f.clear();
            this.f96529f.addAll(list);
            t();
        }

        public void v(DragFrameLayout dragFrameLayout) {
            this.D = dragFrameLayout;
        }

        public void w(boolean z16) {
            this.f96527d = z16;
        }

        public void x() {
            this.C.addOnScrollListener(new a());
        }
    }

    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(ServiceFolderFollowPBHeadView.this.M)) {
                com.tencent.biz.subscribe.d.l(ServiceFolderFollowPBHeadView.this.M);
            } else {
                QLog.e(ServiceFolderFollowPBHeadView.S, 2, "jump error mJumpWebMessageListUrl is null");
            }
            ServiceFolderFollowPBHeadView.this.G.setVisibility(8);
            ReportController.o(null, "dc00898", "", "", "auth_page", "msg_exp", 0, 0, "", "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes5.dex */
    private static class b extends RecyclerView.ViewHolder {
        private com.tencent.mobileqq.activity.recent.cur.b C;
        private boolean D;

        /* renamed from: d, reason: collision with root package name */
        public RecentContactInfo f96535d;

        /* renamed from: e, reason: collision with root package name */
        private URLImageView f96536e;

        /* renamed from: f, reason: collision with root package name */
        private TextView f96537f;

        /* renamed from: h, reason: collision with root package name */
        private DragTextView f96538h;

        /* renamed from: i, reason: collision with root package name */
        private i f96539i;

        /* renamed from: m, reason: collision with root package name */
        private HashMap<String, Bitmap> f96540m;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RecentContactInfo f96541d;

            a(RecentContactInfo recentContactInfo) {
                this.f96541d = recentContactInfo;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).reportItemClickOnServiceFolder(this.f96541d);
                ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).reportPublicAccountADDuration(this.f96541d);
                b.this.j(view, this.f96541d);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public b(View view, i iVar, HashMap<String, Bitmap> hashMap, DragFrameLayout dragFrameLayout) {
            super(view);
            this.D = false;
            this.f96539i = iVar;
            this.f96540m = hashMap;
            this.C = dragFrameLayout;
            this.f96536e = (URLImageView) view.findViewById(R.id.m85);
            this.f96537f = (TextView) view.findViewById(R.id.m89);
            this.f96538h = (DragTextView) view.findViewById(R.id.m8b);
        }

        private int e(RecentContactInfo recentContactInfo) {
            if (recentContactInfo.getUnreadFlag() == 1) {
                return 2;
            }
            if (recentContactInfo.getUnreadCnt() > 0) {
                return 1;
            }
            return 0;
        }

        private boolean f(RecentContactInfo recentContactInfo, RecentContactInfo recentContactInfo2) {
            boolean z16;
            if (recentContactInfo != null && recentContactInfo2 != null) {
                if (recentContactInfo.getPeerUin() == recentContactInfo2.getPeerUin() && recentContactInfo.getUnreadCnt() == recentContactInfo2.getUnreadCnt() && recentContactInfo.getMsgTime() == recentContactInfo2.getMsgTime() && recentContactInfo.getPeerName().equals(recentContactInfo2.getPeerName())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.d(ServiceFolderFollowPBHeadView.S, 4, "isSameServiceData:" + z16);
            }
            return false;
        }

        private void i(View view, RecentContactInfo recentContactInfo) {
            Intent intent = new Intent(view.getContext(), (Class<?>) ChatActivity.class);
            intent.putExtra("uintype", 1008);
            intent.putExtra("uin", String.valueOf(recentContactInfo.getPeerUin()));
            intent.putExtra("key_peerId", recentContactInfo.getPeerUid());
            intent.putExtra("uinname", recentContactInfo.getPeerName());
            intent.putExtra("start_time", System.currentTimeMillis());
            intent.putExtra("red_hot_count", recentContactInfo.getUnreadCnt());
            intent.putExtra(IPublicAccountReport.INTENT_KEY_FROM, 2);
            view.getContext().startActivity(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(View view, RecentContactInfo recentContactInfo) {
            if (((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).isValidUin(String.valueOf(recentContactInfo.getPeerUin()))) {
                ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(String.valueOf(recentContactInfo.getPeerUin()), recentContactInfo.getPeerUid());
            }
            if (TextUtils.equals(String.valueOf(recentContactInfo.getPeerUin()), qb2.a.f428781a)) {
                qb2.b.e(view.getContext(), String.valueOf(recentContactInfo.getPeerUin()), 1);
            } else {
                i(view, recentContactInfo);
            }
        }

        public void d(RecentContactInfo recentContactInfo, int i3) {
            int i16;
            int i17;
            int i18;
            if (recentContactInfo != null && !f(this.f96535d, recentContactInfo)) {
                this.f96535d = recentContactInfo;
                this.itemView.setTag(recentContactInfo);
                this.f96538h.setTag(R.id.m87, this.f96535d);
                this.f96538h.setTag(R.id.m85, Integer.valueOf(i3));
                this.f96537f.setText(recentContactInfo.getPeerName());
                if (this.D) {
                    this.f96537f.setTextColor(-5723992);
                }
                g(this.f96536e, String.valueOf(recentContactInfo.getPeerUin()));
                int unreadCnt = (int) recentContactInfo.getUnreadCnt();
                int e16 = e(recentContactInfo);
                if (unreadCnt > 0) {
                    if (e16 == 0) {
                        this.f96538h.setDragViewType(-1, this.itemView);
                        this.f96538h.setOnModeChangeListener(null);
                    } else {
                        if (e16 == 2) {
                            this.f96538h.setDragViewType(-1, this.itemView);
                            this.f96538h.setOnModeChangeListener(null);
                            i16 = 1;
                            i17 = 0;
                            i18 = i17;
                            com.tencent.widget.d.c(this.f96538h, i16, i17, i18, 99, null);
                            this.itemView.setOnClickListener(new a(recentContactInfo));
                            ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).reportItemShowOnServiceFolder(recentContactInfo);
                        }
                        this.f96538h.setDragViewType(0, this.itemView);
                        this.f96538h.setOnModeChangeListener(this.C);
                        i17 = unreadCnt;
                        i16 = 3;
                        i18 = R.drawable.skin_tips_newmessage;
                        com.tencent.widget.d.c(this.f96538h, i16, i17, i18, 99, null);
                        this.itemView.setOnClickListener(new a(recentContactInfo));
                        ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).reportItemShowOnServiceFolder(recentContactInfo);
                    }
                }
                i16 = 0;
                i17 = 0;
                i18 = i17;
                com.tencent.widget.d.c(this.f96538h, i16, i17, i18, 99, null);
                this.itemView.setOnClickListener(new a(recentContactInfo));
                ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).reportItemShowOnServiceFolder(recentContactInfo);
            }
        }

        @RequiresApi(api = 8)
        public void g(ImageView imageView, String str) {
            Bitmap bitmap = this.f96540m.get(str);
            if (bitmap == null) {
                imageView.setImageDrawable(this.f96539i.e(1008, str));
            } else {
                imageView.setImageBitmap(bitmap);
            }
            if (this.D) {
                imageView.setColorFilter(1711276032);
            }
        }

        public void h(boolean z16) {
            this.D = z16;
        }
    }

    public ServiceFolderFollowPBHeadView(Context context) {
        super(context);
        this.L = false;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public int i() {
        return R.layout.c9u;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.L = SubscribeUtils.m();
        this.F = (TextView) view.findViewById(R.id.f83414jh);
        this.E = (RecyclerView) view.findViewById(R.id.m8c);
        this.G = (LinearLayout) view.findViewById(R.id.m8_);
        this.H = (TextView) view.findViewById(R.id.m8a);
        this.I = (TextView) view.findViewById(R.id.m87);
        ServiceAccountFoldAdapter serviceAccountFoldAdapter = new ServiceAccountFoldAdapter(getContext(), this.E);
        this.J = serviceAccountFoldAdapter;
        serviceAccountFoldAdapter.w(this.L);
        this.E.setAdapter(this.J);
        this.J.x();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.K = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.E.setLayoutManager(this.K);
        this.R = (QCircleServiceFolderView) view.findViewById(R.id.f83404jg);
        this.N = (RelativeLayout) view.findViewById(R.id.uvu);
        this.P = (ImageView) view.findViewById(R.id.uvt);
        this.P.setImageDrawable(URLDrawable.getDrawable("https://sola.gtimg.cn/aoi/sola/20201119210154_6KQkLOzrpX.png", (URLDrawable.URLDrawableOptions) null));
        if (this.G.getBackground() != null && (this.G.getBackground() instanceof GradientDrawable)) {
            ((GradientDrawable) this.G.getBackground()).setColor(Color.parseColor("#00cafc"));
        }
        this.G.setOnClickListener(new a());
        if (this.L) {
            this.I.setTextColor(-10132123);
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public void setData(Object obj) {
        List<RecentContactInfo> list = (List) obj;
        ServiceAccountFoldAdapter serviceAccountFoldAdapter = this.J;
        if (serviceAccountFoldAdapter != null) {
            serviceAccountFoldAdapter.u(list);
        }
    }

    public void setDragHost(DragFrameLayout dragFrameLayout) {
        ServiceAccountFoldAdapter serviceAccountFoldAdapter = this.J;
        if (serviceAccountFoldAdapter != null) {
            serviceAccountFoldAdapter.v(dragFrameLayout);
        }
    }

    public void setJumpWebMessageListUrl(String str) {
        this.M = str;
    }

    public void setQCircleData(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        QCircleServiceFolderView qCircleServiceFolderView = this.R;
        if (qCircleServiceFolderView == null) {
            return;
        }
        qCircleServiceFolderView.setData(feedCloudRead$StGetFeedListRsp, 45);
    }

    public void setTopBannerVisibility(boolean z16) {
        if (z16) {
            if (this.F.getVisibility() == 8) {
                this.F.setVisibility(0);
            }
            if (this.E.getVisibility() == 8) {
                this.E.setVisibility(0);
                VSReporter.m("auth_follow", "service_exp", 0, 0, new String[0]);
                return;
            }
            return;
        }
        if (this.F.getVisibility() == 0) {
            this.F.setVisibility(8);
        }
        if (this.E.getVisibility() == 0) {
            this.E.setVisibility(8);
        }
    }

    public void setmFolderViewPager(ViewPager viewPager) {
        this.Q = viewPager;
    }

    public void w() {
        ServiceAccountFoldAdapter serviceAccountFoldAdapter = this.J;
        if (serviceAccountFoldAdapter != null) {
            serviceAccountFoldAdapter.s();
        }
    }

    public void y(final int i3) {
        this.H.post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.2
            @Override // java.lang.Runnable
            public void run() {
                if (i3 > 0) {
                    ServiceFolderFollowPBHeadView.this.G.setVisibility(0);
                    ServiceFolderFollowPBHeadView.this.H.setText(i3 + HardCodeUtil.qqStr(R.string.ozs));
                    return;
                }
                ServiceFolderFollowPBHeadView.this.G.setVisibility(8);
            }
        });
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void c(Object obj) {
    }

    public void x(boolean z16, String str) {
    }
}
