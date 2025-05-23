package com.tencent.biz.qqcircle.immersive.personal.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.reflect.TypeToken;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.bean.QFSPushBoxBean;
import com.tencent.biz.qqcircle.events.QCircleAlbumEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSUpdatePushStateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager;
import com.tencent.biz.qqcircle.immersive.events.QFSDoTopProfileEvent;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedAdapter;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSJustWatchedEvent;
import com.tencent.biz.qqcircle.immersive.personal.publishguide.BannerInfo;
import com.tencent.biz.qqcircle.immersive.personal.publishguide.PublishGuideData;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSDraftViewModel;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNormalNoMoreHintView;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalQzoneAlumView;
import com.tencent.biz.qqcircle.immersive.utils.ad;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.Pair;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.JsonBinder;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import feedcloud.FeedCloudMeta$PushBoxViewInfo;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$PushBoxBasic;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* loaded from: classes4.dex */
public class QFSPersonalProductFeedFragment extends QFSPersonalFeedFragment {
    private int U;
    private String V;
    private o30.b W;
    private QFSDraftViewModel Y;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.e f88654a0;

    /* renamed from: c0, reason: collision with root package name */
    private c f88656c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.publishguide.h f88657d0;

    /* renamed from: f0, reason: collision with root package name */
    private PublishGuideData f88659f0;
    private int X = -1;
    private final com.tencent.biz.qqcircle.immersive.personal.bean.j Z = new com.tencent.biz.qqcircle.immersive.personal.bean.j();

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f88655b0 = false;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f88658e0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements com.tencent.biz.qqcircle.immersive.personal.publishguide.f {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.publishguide.f
        public void a(@NonNull BannerInfo bannerInfo) {
            FragmentActivity activity = QFSPersonalProductFeedFragment.this.getActivity();
            if (activity != null) {
                QFSPersonalProductFeedFragment.this.M.T1(activity, bannerInfo);
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.publishguide.f
        public void b(@NonNull BannerInfo bannerInfo) {
            QFSPersonalProductFeedFragment.this.M.U1(bannerInfo);
        }
    }

    /* loaded from: classes4.dex */
    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            QFSPersonalProductFeedFragment.this.ui();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSPersonalProductFeedFragment> f88662a;

        /* loaded from: classes4.dex */
        class a extends TypeToken<List<QFSPushBoxBean>> {
            a() {
            }
        }

        public c(QFSPersonalProductFeedFragment qFSPersonalProductFeedFragment) {
            this.f88662a = new WeakReference<>(qFSPersonalProductFeedFragment);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("push_box_json");
            if (!TextUtils.isEmpty(stringExtra) && this.f88662a.get() != null) {
                QFSPersonalProductFeedFragment qFSPersonalProductFeedFragment = this.f88662a.get();
                List<QFSPushBoxBean> fromJson = JsonBinder.getInstance().fromJson(stringExtra, new a().getType());
                if (fromJson == null) {
                    return;
                }
                qFSPersonalProductFeedFragment.di(fromJson);
            }
        }
    }

    private void Wh() {
        if (this.L != null && this.J != null) {
            if (!this.Z.c()) {
                QLog.d("QFSPersonalProductFeedFragment", 1, "checkDraftData, all data not ready ");
                return;
            }
            String b16 = this.Z.b();
            QLog.d("QFSPersonalProductFeedFragment", 1, "checkDraftData, draftGuideInfo: " + b16);
            if (this.L.L2() && this.Q) {
                com.tencent.biz.qqcircle.immersive.personal.bean.k a16 = this.Z.a();
                TextUtils.isEmpty(b16);
                a16.r(b16);
                this.J.p0(a16);
                this.F.E9();
                return;
            }
            this.J.E0();
            return;
        }
        QLog.d("QFSPersonalProductFeedFragment", 1, "checkDraftData, mViewModel is null or mPersonalFeedAdapter is null ");
    }

    private FeedCloudMeta$FeedAlbumInfo Xh(QCircleAlbumEvent qCircleAlbumEvent) {
        FeedCloudMeta$FeedAlbumInfo feedCloudMeta$FeedAlbumInfo = new FeedCloudMeta$FeedAlbumInfo();
        FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum = new FeedCloudMeta$FeedAlbum();
        feedCloudMeta$FeedAlbum.f398441id.set(qCircleAlbumEvent.albumId);
        feedCloudMeta$FeedAlbum.title.set(qCircleAlbumEvent.title);
        feedCloudMeta$FeedAlbum.cover_url.set(qCircleAlbumEvent.coverUrl);
        feedCloudMeta$FeedAlbum.description.set(qCircleAlbumEvent.description);
        feedCloudMeta$FeedAlbum.feed_count.set((int) qCircleAlbumEvent.itemCount);
        feedCloudMeta$FeedAlbumInfo.album.set(feedCloudMeta$FeedAlbum);
        return feedCloudMeta$FeedAlbumInfo;
    }

    private void Yh() {
        VideoReport.setElementId(((QCircleBaseFragment) this).mContentView, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_PRODUCT_TAB);
    }

    private void ai(QFSDoTopProfileEvent qFSDoTopProfileEvent) {
        QFSPersonalFeedAdapter qFSPersonalFeedAdapter = this.J;
        if (qFSPersonalFeedAdapter == null) {
            return;
        }
        List<com.tencent.biz.qqcircle.immersive.personal.bean.k> dataList = qFSPersonalFeedAdapter.getDataList();
        for (int i3 = 0; i3 < dataList.size(); i3++) {
            com.tencent.biz.qqcircle.immersive.personal.bean.k kVar = dataList.get(i3);
            if (kVar != null && TextUtils.equals(kVar.d(), qFSDoTopProfileEvent.mTargetFeedId)) {
                boolean q16 = kVar.q();
                boolean z16 = qFSDoTopProfileEvent.isDoProfile;
                if (q16 != z16) {
                    kVar.s(z16);
                    this.J.notifyItemChanged(i3);
                    return;
                }
                return;
            }
        }
    }

    private void bi() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar;
        if (this.f88654a0 != null && (rVar = this.L) != null && rVar.o2().getValue() != null) {
            com.tencent.biz.qqcircle.immersive.personal.interceptor.e N1 = this.f88654a0.N1();
            com.tencent.biz.qqcircle.immersive.personal.interceptor.e n26 = this.L.n2();
            boolean p16 = n26.p(N1.f(), N1.q());
            String l26 = this.L.l2();
            if (p16) {
                for (int size = n26.f().size(); size < n26.f().size(); size++) {
                    this.J.addData(new com.tencent.biz.qqcircle.immersive.personal.bean.k(this.L.i2(), n26.f().get(size), this.N));
                }
            }
            ti(l26);
            ri(l26);
        }
    }

    private void ei(QCircleAlbumEvent qCircleAlbumEvent) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.L;
        if (rVar == null) {
            return;
        }
        int i3 = qCircleAlbumEvent.state;
        if (i3 == 1) {
            rVar.b2(qCircleAlbumEvent.albumId);
            return;
        }
        if (i3 == 3) {
            this.L.a2(new b40.a(Xh(qCircleAlbumEvent)));
        } else if (i3 == 2) {
            this.L.c2(new b40.a(Xh(qCircleAlbumEvent)));
        }
    }

    private void gi() {
        o30.b bVar = this.W;
        if (bVar == null) {
            QLog.d("QFSPersonalProductFeedFragment", 1, "[updatePersonInfoPymkData] person info pymk child view should not be null.");
        } else {
            bVar.d();
        }
    }

    private void hi(UIStateData<List<e30.b>> uIStateData) {
        if (uIStateData.getIsLoadMore()) {
            return;
        }
        if (this.X == -1) {
            if (this.L.k2().getValue() == null) {
                return;
            }
            this.f88654a0.P1(this.L.k2().getValue());
        } else {
            this.f88654a0.U1(true);
            ui();
        }
    }

    private void initReceiver() {
        if (getActivity() != null) {
            RFWLog.i("QFSPersonalProductFeedFragment", RFWLog.USR, "registerReceiver");
            this.f88656c0 = new c(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_open_push_box");
            try {
                getActivity().registerReceiver(this.f88656c0, intentFilter);
            } catch (Exception e16) {
                RFWLog.e("QFSPersonalProductFeedFragment", RFWLog.USR, "registerReceiver failure , msg = " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ji(Integer num) {
        this.N = num.intValue();
        if (getArguments() != null) {
            getArguments().putInt("fs_key_personal_feed_type", num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ki(UIStateData uIStateData) {
        Mh(uIStateData);
        wi(uIStateData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void li(QFSPersonalInfo qFSPersonalInfo) {
        vi(qFSPersonalInfo);
        this.J.Q0(qFSPersonalInfo.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void mi(PublishGuideData publishGuideData) {
        this.J.N0(Zh(publishGuideData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ni(String str) {
        QLog.d("QFSPersonalProductFeedFragment", 1, "getDraftGuideLiveData, draftGuideInfo: " + str);
        if (this.Z.e(str)) {
            Wh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void oi(Pair pair) {
        this.f88658e0 = false;
        Zh(this.f88659f0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pi(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar) {
        boolean z16 = true;
        QLog.d("QFSPersonalProductFeedFragment", 1, "getDraftFeedInfo, draftFeedInfo: " + kVar);
        this.Z.d(kVar);
        if (kVar == null) {
            z16 = false;
        }
        this.Q = z16;
        Wh();
    }

    private void qi() {
        if (this.I != null && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101466", true)) {
            try {
                if (((QCircleBaseFragment) this).mContentView.getParent() instanceof View) {
                    ((View) ((QCircleBaseFragment) this).mContentView.getParent()).setTag(R.id.ve5, null);
                }
                this.J.M0(null);
                this.I.setScrollContainer(false);
            } catch (Exception e16) {
                RFWLog.d("QFSPersonalProductFeedFragment", RFWLog.USR, "releaseRecycleView error", e16);
            }
        }
    }

    private void ri(String str) {
        this.I.scrollToPosition(this.X);
        getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalProductFeedFragment.3
            @Override // java.lang.Runnable
            public void run() {
                List<e30.b> t06 = QFSPersonalProductFeedFragment.this.J.t0();
                QFSPersonalProductFeedFragment qFSPersonalProductFeedFragment = QFSPersonalProductFeedFragment.this;
                ad.h(t06, qFSPersonalProductFeedFragment.I, qFSPersonalProductFeedFragment.K.Jh(), QFSPersonalProductFeedFragment.this.X);
            }
        });
    }

    private void si() {
        UIStateData<List<e30.b>> value;
        if (!this.f88655b0 || (value = this.L.o2().getValue()) == null) {
            return;
        }
        value.setData(value.getIsLoadMore(), this.L.n2().f());
        this.L.o2().setValue(value);
        this.f88655b0 = false;
    }

    private void ti(String str) {
        for (int i3 = 0; i3 < this.J.getItemCount(); i3++) {
            if (TextUtils.equals(str, this.J.getItem(i3).d())) {
                this.X = i3;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui() {
        if (this.f88654a0 != null && this.X >= 0 && this.L.o2().getValue() != null) {
            int i3 = this.X;
            if (i3 < 6) {
                this.f88654a0.R1(true);
                return;
            }
            int i16 = this.P;
            if (i16 != 0 && i16 == i3 / 3) {
                this.f88654a0.R1(true);
                return;
            }
            UIStateData<List<e30.b>> value = this.L.o2().getValue();
            if (value != null && value.getIsFinish() && vh(this.I)) {
                this.f88654a0.R1(true);
            } else {
                this.f88654a0.R1(false);
            }
        }
    }

    private void vi(QFSPersonalInfo qFSPersonalInfo) {
        BlockPart blockPart;
        int i3;
        if (qFSPersonalInfo != null && (blockPart = this.E) != null && blockPart.getBlockContainer() != null && this.E.getBlockContainer().getBlockMerger() != null) {
            if (this.L.L2() && QFSPersonalInfo.O) {
                QFSPersonalQzoneAlumView qFSPersonalQzoneAlumView = new QFSPersonalQzoneAlumView(getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, cx.a(16.0f), 0, cx.a(5.0f));
                qFSPersonalQzoneAlumView.setLayoutParams(layoutParams);
                int i16 = qFSPersonalInfo.f88423j;
                if (i16 > 0) {
                    i3 = 4;
                } else {
                    i3 = 3;
                }
                qFSPersonalQzoneAlumView.c(i16, i3);
                this.E.getBlockContainer().getBlockMerger().setCustomNoMoreDataView(qFSPersonalQzoneAlumView);
                this.E.getBlockContainer().getBlockMerger().notifyDataSetChanged();
                return;
            }
            QFSNormalNoMoreHintView qFSNormalNoMoreHintView = new QFSNormalNoMoreHintView(getContext());
            qFSNormalNoMoreHintView.setHintText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1921446p));
            this.E.getBlockContainer().getBlockMerger().setCustomNoMoreDataView(qFSNormalNoMoreHintView);
        }
    }

    private void wi(UIStateData<List<e30.b>> uIStateData) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.L;
        if (rVar != null && !rVar.L2() && com.tencent.biz.qqcircle.manager.i.a("qfs_personal_entrance_show")) {
            if (uIStateData != null && uIStateData.getState() == 0 && this.L.g2().getValue() != null && !this.L.g2().getValue().L && !this.L.K2()) {
                xi(this.L.g2().getValue().f88416c);
                return;
            } else {
                if (uIStateData == null || uIStateData.getState() != 1) {
                    gi();
                    return;
                }
                return;
            }
        }
        gi();
    }

    private void xi(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        o30.b bVar = this.W;
        if (bVar == null) {
            QLog.d("QFSPersonalProductFeedFragment", 1, "[updatePersonInfoPymkData] person info pymk child view should not be null.");
        } else {
            bVar.h(feedCloudMeta$StUser);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment
    protected void Eh(UIStateData<List<e30.b>> uIStateData) {
        NestScrollRecyclerView nestScrollRecyclerView;
        if (uIStateData == null) {
            RFWLog.e("QFSPersonalProductFeedFragment", RFWLog.USR, "[handleSuccess] uiStateData = " + uIStateData);
            return;
        }
        if (this.J != null && uIStateData.getData() != null && this.L != null) {
            this.X = -1;
            ArrayList<com.tencent.biz.qqcircle.immersive.personal.bean.k> arrayList = new ArrayList<>();
            String l26 = this.L.l2();
            for (int i3 = 0; i3 < uIStateData.getData().size(); i3++) {
                e30.b bVar = uIStateData.getData().get(i3);
                if (bVar != null && bVar.g() != null) {
                    if (bVar.g().feedType.get() == 6 && bVar.g().type.get() == 4) {
                        RFWLog.d("QFSPersonalProductFeedFragment", RFWLog.USR, "[handleSuccess] ditto feed -> guild, mViewModel.getOwnerUin() = " + this.L.i2());
                        arrayList.add(new com.tencent.biz.qqcircle.immersive.personal.bean.i(this.L.i2(), bVar, this.N, AudienceReportConst.EVENT_ID_BUFFER_END));
                    } else {
                        com.tencent.biz.qqcircle.immersive.personal.bean.k kVar = new com.tencent.biz.qqcircle.immersive.personal.bean.k(this.L.i2(), bVar, this.N);
                        if (!bVar.g().promoteInfo.usePromoteTicket.get() && TextUtils.equals(bVar.g().f398449id.get(), l26)) {
                            this.L.L2();
                        }
                        arrayList.add(kVar);
                    }
                }
            }
            QLog.i("QFSPersonalProductFeedFragment", 1, "[handleSuccess] -> data size = " + arrayList.size());
            this.J.o0(arrayList);
            if (!uIStateData.getIsLoadMore() && (nestScrollRecyclerView = this.I) != null) {
                nestScrollRecyclerView.scrollToPosition(0);
            }
            this.F.E9();
            ti(l26);
            hi(uIStateData);
            return;
        }
        RFWLog.e("QFSPersonalProductFeedFragment", RFWLog.USR, "[handleSuccess] mPersonalFeedAdapter = " + this.J + " mViewModel = " + this.L);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment
    protected void Fh() {
        super.Fh();
        NestScrollRecyclerView nestScrollRecyclerView = this.I;
        if (nestScrollRecyclerView == null) {
            return;
        }
        nestScrollRecyclerView.addOnScrollListener(new b());
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment
    void Ih() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.L;
        if (rVar == null) {
            return;
        }
        rVar.o2().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalProductFeedFragment.this.ki((UIStateData) obj);
            }
        });
        t30.f fVar = new t30.f(getTAG(), t30.f.U1(this.J), this.L.o2());
        this.S = fVar;
        fVar.a2(1);
        if (this.L.g2().getValue() != null) {
            this.J.Q0(this.L.g2().getValue().j());
        }
        this.L.g2().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalProductFeedFragment.this.li((QFSPersonalInfo) obj);
            }
        });
        this.M.Q1().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalProductFeedFragment.this.mi((PublishGuideData) obj);
            }
        });
        this.L.f2().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalProductFeedFragment.this.ni((String) obj);
            }
        });
        this.L.W1();
        this.L.X.observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalProductFeedFragment.this.oi((Pair) obj);
            }
        });
        this.Y.R1().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalProductFeedFragment.this.pi((com.tencent.biz.qqcircle.immersive.personal.bean.k) obj);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment
    boolean Kh() {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.L;
        if (rVar == null) {
            return false;
        }
        return "qfs_personal_tab_product".equals(rVar.t2());
    }

    public com.tencent.biz.qqcircle.immersive.personal.publishguide.h Zh(PublishGuideData publishGuideData) {
        if (this.f88657d0 == null) {
            this.f88657d0 = new com.tencent.biz.qqcircle.immersive.personal.publishguide.h(new a());
        }
        if (publishGuideData != null) {
            this.f88659f0 = publishGuideData;
        }
        if (this.f88658e0 && ii()) {
            this.f88657d0.d(publishGuideData);
        } else {
            this.f88657d0.d(null);
        }
        return this.f88657d0;
    }

    protected void ci(QCirclePolyPraiseUpdateEvent qCirclePolyPraiseUpdateEvent) {
        String str = qCirclePolyPraiseUpdateEvent.mTargetFeedId;
        int i3 = qCirclePolyPraiseUpdateEvent.mPraisedStatus;
        int i16 = qCirclePolyPraiseUpdateEvent.mPraisedNum;
        boolean isPraised = qCirclePolyPraiseUpdateEvent.isPraised();
        RFWLog.i(getTAG(), RFWLog.USR, "handlePraisedUpdateEvent feedId = " + str + ",praisedStatus = " + i3 + ",praisedCount = " + i16 + ",isPraised = " + isPraised);
        for (e30.b bVar : this.L.n2().f()) {
            if (bVar != null && bVar.g() != null && TextUtils.equals(str, bVar.g().f398449id.get())) {
                bVar.g().likeInfo.status.set(i3);
                bVar.g().likeInfo.count.set(i16);
                bVar.g().likeInfo.setHasFlag(true);
                this.f88655b0 = true;
                return;
            }
        }
    }

    protected void di(@NonNull List<QFSPushBoxBean> list) {
        if (this.J != null && this.L != null) {
            HashMap hashMap = new HashMap();
            for (QFSPushBoxBean qFSPushBoxBean : list) {
                hashMap.put(qFSPushBoxBean.getFeedId(), qFSPushBoxBean);
            }
            for (int i3 = 0; i3 < this.J.getDataList().size(); i3++) {
                com.tencent.biz.qqcircle.immersive.personal.bean.k item = this.J.getItem(i3);
                QFSPushBoxBean qFSPushBoxBean2 = (QFSPushBoxBean) hashMap.get(item.d());
                if (qFSPushBoxBean2 != null) {
                    FeedCloudMeta$PushBoxViewInfo pushBoxViewInfo = qFSPushBoxBean2.getPushBoxViewInfo();
                    item.h(pushBoxViewInfo);
                    QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = (QQCircleFeedBase$StFeedBusiReqData) item.c().b("DITTO_FEED_BUSI_REQ_DATA");
                    qQCircleFeedBase$StFeedBusiReqData.pushList.pushBoxViewInfo.set(pushBoxViewInfo);
                    item.c().o("DITTO_FEED_BUSI_REQ_DATA", qQCircleFeedBase$StFeedBusiReqData);
                    this.J.notifyItemChanged(i3);
                    com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.L;
                    if (rVar != null && rVar.n2() != null && this.L.n2().f() != null && this.L.n2().f().size() > i3) {
                        e30.b bVar = this.L.n2().f().get(i3);
                        bVar.o("DITTO_FEED_BUSI_REQ_DATA", qQCircleFeedBase$StFeedBusiReqData);
                        bVar.g().busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StFeedBusiReqData.toByteArray()));
                    }
                }
            }
        }
    }

    protected void fi(QFSUpdatePushStateEvent qFSUpdatePushStateEvent) {
        if (qFSUpdatePushStateEvent == null) {
            return;
        }
        List<FeedCloudWrite$PushBoxBasic> pushBoxBasics = qFSUpdatePushStateEvent.getPushBoxBasics();
        ArrayList arrayList = new ArrayList();
        for (FeedCloudWrite$PushBoxBasic feedCloudWrite$PushBoxBasic : pushBoxBasics) {
            if (feedCloudWrite$PushBoxBasic != null) {
                arrayList.add(new QFSPushBoxBean(feedCloudWrite$PushBoxBasic));
            }
        }
        di(arrayList);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(QFSDoTopProfileEvent.class);
        eventClass.add(QCircleAlbumEvent.class);
        eventClass.add(QFSJustWatchedEvent.class);
        eventClass.add(QCirclePolyPraiseUpdateEvent.class);
        eventClass.add(QFSUpdatePushStateEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalProductFeedFragment";
    }

    public boolean ii() {
        QFSPersonalInfo value;
        b40.d j3;
        List<b40.a> a16;
        if (this.L.g2() != null && (value = this.L.g2().getValue()) != null && (j3 = value.j()) != null && (a16 = j3.a()) != null) {
            return a16.isEmpty();
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment
    protected void initViewModel() {
        super.initViewModel();
        this.L.p2().observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.fragment.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalProductFeedFragment.this.ji((Integer) obj);
            }
        });
        this.Y = (QFSDraftViewModel) getViewModel(this.K, null, QFSDraftViewModel.class);
        this.f88654a0 = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.e) getViewModel(this.K, null, com.tencent.biz.qqcircle.immersive.personal.viewmodel.e.class);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initReceiver();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("QFSPersonalProductFeedFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        if (getActivity() != null && this.f88656c0 != null) {
            RFWLog.i("QFSPersonalProductFeedFragment", RFWLog.USR, "unregisterReceiver");
            try {
                getActivity().unregisterReceiver(this.f88656c0);
            } catch (Exception e16) {
                RFWLog.e("QFSPersonalProductFeedFragment", RFWLog.USR, "unregisterReceiver failure , msg = " + e16.getMessage());
            }
        }
        this.f88654a0 = new com.tencent.biz.qqcircle.immersive.personal.viewmodel.e();
        this.M.Z1();
        qi();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSDoTopProfileEvent) {
            ai((QFSDoTopProfileEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleAlbumEvent) {
            ei((QCircleAlbumEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSJustWatchedEvent) {
            bi();
        } else if (simpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent) {
            ci((QCirclePolyPraiseUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSUpdatePushStateEvent) {
            fi((QFSUpdatePushStateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        si();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalFeedFragment, com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalBaseNestScrollFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected void onViewCreatedAfterPartInit(View view, Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        QFSHodorCollectManager.f84689a.c("qfs_personal_profile_create_cost");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        if (getReportBean() != null) {
            this.U = getReportBean().getFromPageId();
            this.V = getReportBean().getDtFromPageId();
        }
        o30.b bVar = new o30.b(this);
        this.W = bVar;
        bVar.e(((QCircleBaseFragment) this).mContentView);
        Yh();
    }
}
