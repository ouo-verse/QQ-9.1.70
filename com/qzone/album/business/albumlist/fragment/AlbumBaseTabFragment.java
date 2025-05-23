package com.qzone.album.business.albumlist.fragment;

import BOSSStrategyCenter.tAdvDesc;
import NS_MOBILE_FEEDS.s_memory_seal_off;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.base.AlbumPersonalizeManager;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QzoneAlbumRecentAllPhotoRequest;
import com.qzone.album.ui.widget.AlbumTimeLineView;
import com.qzone.album.ui.widget.c;
import com.qzone.app.ImageEnvImpl;
import com.qzone.app.ImageLogger;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.detail.ui.component.FeedDetailCommentTips;
import com.qzone.misc.network.qboss.manager.QzoneQBossManager;
import com.qzone.misc.network.qboss.protocol.QzoneQBossAdvRequest;
import com.qzone.reborn.layer.share.QZoneDeletePhotoBean;
import com.qzone.util.ar;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.ResDownloadManger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class AlbumBaseTabFragment extends BaseFragment implements com.qzone.album.env.common.c, com.qzone.album.business.albumlist.fragment.d {
    public j C;
    View D;
    public s_memory_seal_off F;
    protected ProgressBar G;
    protected int I;
    protected QZonePullToRefreshListView J;
    protected com.qzone.album.business.photolist.adapter.c K;
    protected View M;
    protected Object N;
    public Long P;
    protected Bundle Q;
    public com.qzone.album.base.Service.a R;
    public AlbumCacheDataManager S;
    private RelativeLayout T;
    protected QZonePullToRefreshListView V;
    protected ViewStub W;
    private String X;
    private String Y;
    private String Z;

    /* renamed from: b0, reason: collision with root package name */
    protected ImageView f42243b0;

    /* renamed from: c0, reason: collision with root package name */
    protected com.qzone.album.ui.widget.c f42244c0;

    /* renamed from: d0, reason: collision with root package name */
    protected FrameLayout f42245d0;

    /* renamed from: h0, reason: collision with root package name */
    protected FeedDetailCommentTips f42249h0;

    /* renamed from: i0, reason: collision with root package name */
    protected LinearLayout f42250i0;

    /* renamed from: j0, reason: collision with root package name */
    int f42251j0;

    /* renamed from: k0, reason: collision with root package name */
    private mc.a f42252k0;

    /* renamed from: l0, reason: collision with root package name */
    View f42253l0;

    /* renamed from: m0, reason: collision with root package name */
    TextView f42254m0;
    protected int E = 1;
    public int H = R.string.f172988gb2;
    protected boolean L = true;
    protected ImageView U = null;

    /* renamed from: a0, reason: collision with root package name */
    protected boolean f42242a0 = false;

    /* renamed from: e0, reason: collision with root package name */
    protected int f42246e0 = 5;

    /* renamed from: f0, reason: collision with root package name */
    private long f42247f0 = 0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f42248g0 = 5;

    /* renamed from: n0, reason: collision with root package name */
    protected AbsCompatRequest.a f42255n0 = new k(this);

    /* renamed from: o0, reason: collision with root package name */
    protected AbsCompatRequest.a f42256o0 = new h();

    /* renamed from: p0, reason: collision with root package name */
    private q7.a<p7.b> f42257p0 = new b();

    /* renamed from: q0, reason: collision with root package name */
    private Runnable f42258q0 = new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.13
        @Override // java.lang.Runnable
        public void run() {
            AlbumBaseTabFragment albumBaseTabFragment = AlbumBaseTabFragment.this;
            if (albumBaseTabFragment.C != null) {
                if (!albumBaseTabFragment.ni()) {
                    AlbumBaseTabFragment.this.oi();
                } else {
                    AlbumBaseTabFragment.this.zh(1);
                    AlbumBaseTabFragment.this.c0();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements AbsCompatRequest.a {
        a() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            AlbumBaseTabFragment.this.Oh(sVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements AdapterView.OnItemClickListener {
        e() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            AlbumBaseTabFragment.this.ji(adapterView, view, i3, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements AbsListView.OnScrollListener {
        f() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            AlbumBaseTabFragment.this.Ci(absListView, i3, i16, i17);
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 == 0) {
                com.qzone.album.env.common.a.m().Y("qzone_album_first_page", false);
                AlbumBaseTabFragment.this.wh();
                ImageEnvImpl.setShouldPlayAnimWebp(true);
            } else if (i3 == 1) {
                ImageEnvImpl.setShouldPlayAnimWebp(false);
            } else if (i3 != 2) {
                com.qzone.album.env.common.a.m().X("qzone_album_first_page");
            } else {
                AlbumBaseTabFragment.this.wh();
                ImageEnvImpl.setShouldPlayAnimWebp(false);
            }
            AlbumBaseTabFragment.this.Di(absListView, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class h implements AbsCompatRequest.a {
        h() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QZLog.i("AlbumBaseTabFragment", "end get more list recognize : " + System.currentTimeMillis());
            if (AlbumBaseTabFragment.this.isAdded() && sVar != null && absCompatRequest.isGetMore()) {
                AlbumBaseTabFragment.this.Lh(sVar);
                com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", AlbumBaseTabFragment.this.getTagName(), " doGetMore end");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f42274d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f42275e;

        i(String str, String str2) {
            this.f42274d = str;
            this.f42275e = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            yo.d.d(this.f42274d, AlbumBaseTabFragment.this.getActivity(), null);
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(this.f42275e, String.valueOf(LoginData.getInstance().getUin()));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface j {
        void A0(int i3, int i16, Intent intent);

        long U();

        boolean checkNetworkConnect();

        Activity getHostActivity();

        void showNoNetworkTips();

        void t();

        AlbumTimeLineView v1();

        void x0(AbsListView absListView, int i3, int i16, int i17);

        void y();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class k implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<AlbumBaseTabFragment> f42277a;

        k(AlbumBaseTabFragment albumBaseTabFragment) {
            this.f42277a = new WeakReference<>(albumBaseTabFragment);
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QZLog.i("AlbumBaseTabFragment", "end refresh list recognize : " + System.currentTimeMillis());
            WeakReference<AlbumBaseTabFragment> weakReference = this.f42277a;
            AlbumBaseTabFragment albumBaseTabFragment = weakReference != null ? weakReference.get() : null;
            if (albumBaseTabFragment == null) {
                QZLog.i("AlbumBaseTabFragment", "fragment == null");
                return;
            }
            com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", albumBaseTabFragment.getTagName(), " refresh complete");
            if (albumBaseTabFragment.isAdded() && sVar != null) {
                albumBaseTabFragment.Qh();
                albumBaseTabFragment.wi(true);
                albumBaseTabFragment.Nh(sVar);
            }
            albumBaseTabFragment.Rh();
        }
    }

    public static int Eh(int i3, int i16) {
        if (i3 == 1) {
            return 3;
        }
        if (i16 != 2 && i16 == 1) {
            return 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(s sVar) {
        if (sVar.getSucceed() && (sVar.getData() instanceof QzoneQBossAdvRequest.a)) {
            try {
                ArrayList<tAdvDesc> arrayList = ((QzoneQBossAdvRequest.a) sVar.getData()).f48461b.get(2516);
                if (arrayList != null && arrayList.size() != 0 && arrayList.get(0) != null) {
                    tAdvDesc tadvdesc = arrayList.get(0);
                    this.Z = tadvdesc.res_traceinfo;
                    JSONObject jSONObject = new JSONObject(tadvdesc.res_data);
                    this.X = jSONObject.optString("img");
                    String optString = jSONObject.optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                    this.Y = optString;
                    Ai(this.X, optString, this.Z);
                }
            } catch (Exception unused) {
                com.qzone.proxy.feedcomponent.b.c("AlbumBaseTabFragment", "onHandleMessage MSG_ALBUM_LIST_QBOSS_VIPBANNER Exception");
            }
        }
    }

    private void Uh() {
        com.qzone.album.env.common.b.a();
    }

    private void Wh() {
        if (ImageManagerEnv.getAppContext() == null) {
            ImageManagerEnv.init(BaseApplication.getContext(), new ImageEnvImpl(), new ImageLogger());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ci() {
        this.f42252k0.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi(String str) {
        ImageLoader.getInstance().loadImageAsync(str, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi() {
        Handler F;
        if (this.C == null || (F = t4.a.N().F(this.C.getHostActivity())) == null) {
            return;
        }
        F.removeCallbacks(this.f42258q0);
        F.postDelayed(this.f42258q0, 500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bh() {
        if (QZLog.isColorLevel()) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "AlbumBaseTabFragment\t doGetMore()");
        }
    }

    public abstract int Ch();

    @Override // com.qzone.album.env.common.c
    /* renamed from: Dh, reason: merged with bridge method [inline-methods] */
    public QZonePullToRefreshListView R3() {
        return this.J;
    }

    public void Ei(long j3) {
        this.f42247f0 = j3;
    }

    public abstract String Fh();

    protected abstract void Fi();

    protected abstract String Gh();

    protected boolean Gi() {
        return true;
    }

    public void Hh() {
        if (this.C == null || P2()) {
            return;
        }
        this.R.t0(new a());
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public boolean I6(long j3) {
        return this.f42247f0 < j3;
    }

    public void Ih() {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_VIDEO_LIST_BANNER_REQUEST_QBOSS, 1);
        long config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_VIDEO_LIST_BANNER_REQUEST_DURATION, 7);
        long j3 = 0;
        try {
            String L = u4.a.z().L("video_tab_banner_close_time_" + this.P, null);
            if (!TextUtils.isEmpty(L)) {
                j3 = Long.parseLong(L);
            }
        } catch (Exception e16) {
            QZLog.e("AlbumBaseTabFragment", 2, "get last close time exception", e16);
        }
        if (System.currentTimeMillis() - j3 < config2 * 24 * 60 * 60 * 1000 || this.C == null || P2() || config <= 0) {
            return;
        }
        QzoneQBossManager.c().h(2659, null, p7.b.class, this.f42257p0);
    }

    public com.qzone.album.business.photolist.adapter.c Jh() {
        return this.K;
    }

    protected void Lh(s sVar) {
        s_memory_seal_off s_memory_seal_offVar;
        Sh();
        if (sVar == null) {
            com.qzone.proxy.feedcomponent.b.c("AlbumBaseTabFragment", "resultObject is null");
            return;
        }
        di();
        this.F = null;
        if (sVar.getSucceed()) {
            this.J.s0(getString(R.string.gm6));
            boolean hasMore = sVar.getHasMore();
            t4.a.N().V(Fh(), hasMore);
            if (P2() && sVar.a() != null && (sVar.a().getData() instanceof QzoneAlbumRecentAllPhotoRequest.a) && (s_memory_seal_offVar = ((QzoneAlbumRecentAllPhotoRequest.a) sVar.a().getData()).f43984g) != null) {
                this.F = s_memory_seal_offVar;
                qi(s_memory_seal_offVar.no_right_summary, s_memory_seal_offVar.summary);
            }
            if (hasMore) {
                ri(5);
            } else {
                xi(this.K.getCount());
            }
        } else {
            this.J.r0(getString(R.string.gm5), sVar.getMessage());
            ri(this.f42246e0);
        }
        xh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Nh(s sVar) {
        com.qzone.album.ui.widget.c cVar;
        Sh();
        if (sVar == null) {
            com.qzone.album.ui.widget.c cVar2 = this.f42244c0;
            if (cVar2 != null) {
                cVar2.l(5);
            }
            QZonePullToRefreshListView qZonePullToRefreshListView = this.J;
            if (qZonePullToRefreshListView != null) {
                qZonePullToRefreshListView.l0();
            }
            ri(this.f42246e0);
            com.qzone.proxy.feedcomponent.b.c("AlbumBaseTabFragment", "resultObject is null");
            return;
        }
        di();
        this.F = null;
        if (sVar.getSucceed()) {
            if (sVar.getNewCnt() == 0) {
                pi();
                if (P2() && sVar.a() != null && (sVar.a().getData() instanceof QzoneAlbumRecentAllPhotoRequest.a)) {
                    QzoneAlbumRecentAllPhotoRequest.a aVar = (QzoneAlbumRecentAllPhotoRequest.a) sVar.a().getData();
                    s_memory_seal_off s_memory_seal_offVar = aVar.f43984g;
                    if (s_memory_seal_offVar != null && !TextUtils.isEmpty(s_memory_seal_offVar.summary)) {
                        this.F = aVar.f43984g;
                    }
                    s_memory_seal_off s_memory_seal_offVar2 = aVar.f43984g;
                    if (s_memory_seal_offVar2 != null && !TextUtils.isEmpty(s_memory_seal_offVar2.no_right_summary) && !TextUtils.isEmpty(aVar.f43984g.summary)) {
                        s_memory_seal_off s_memory_seal_offVar3 = aVar.f43984g;
                        this.F = s_memory_seal_offVar3;
                        qi(s_memory_seal_offVar3.no_right_summary, s_memory_seal_offVar3.summary);
                    }
                }
            }
            QZonePullToRefreshListView qZonePullToRefreshListView2 = this.J;
            if (qZonePullToRefreshListView2 != null) {
                qZonePullToRefreshListView2.s0(getString(R.string.gm6));
            }
            boolean hasMore = sVar.getHasMore();
            t4.a.N().V(Fh(), hasMore);
            if (hasMore) {
                ri(5);
            } else {
                xi(this.K.getCount());
            }
        } else {
            com.qzone.album.ui.widget.c cVar3 = this.f42244c0;
            if (cVar3 != null) {
                cVar3.l(5);
            }
            if (sVar.getReturnCode() == -10650 && (cVar = this.f42244c0) != null) {
                cVar.i(R.string.f171144cj1);
            }
            this.J.r0(getString(R.string.gm5), sVar.getMessage());
            ri(this.f42246e0);
        }
        xh();
    }

    @Override // com.qzone.album.env.common.c
    public final boolean P2() {
        Long l3 = this.P;
        return l3 == null || l3.longValue() != com.qzone.album.env.common.a.m().s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ph() {
        com.qzone.album.business.photolist.adapter.c cVar = this.K;
        return (cVar == null || cVar.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Qh() {
        ProgressBar progressBar = this.G;
        if (progressBar == null || progressBar.getVisibility() == 8) {
            return;
        }
        this.G.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Sh() {
        j jVar = this.C;
        if (jVar != null) {
            jVar.y();
        }
    }

    @Override // com.qzone.album.env.common.c
    public boolean Ta() {
        j jVar = this.C;
        return jVar != null && jVar.checkNetworkConnect();
    }

    protected void Th() {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.J;
        if (qZonePullToRefreshListView != null) {
            qZonePullToRefreshListView.l0();
        }
        Sh();
    }

    protected abstract void Vh();

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xh() {
        Vh();
        QZonePullToRefreshListView qZonePullToRefreshListView = (QZonePullToRefreshListView) this.D.findViewById(R.id.album_list);
        this.J = qZonePullToRefreshListView;
        qZonePullToRefreshListView.g0().setHeaderLayoutBackgroundColor(16777215);
        this.J.setOnRefreshListener(new d());
        this.J.setOnFirstDrawListner(new QZonePullToRefreshListView.b() { // from class: com.qzone.album.business.albumlist.fragment.a
            @Override // com.qzone.widget.QZonePullToRefreshListView.b
            public final void V9() {
                AlbumBaseTabFragment.this.ci();
            }
        });
        if (this instanceof AlbumRecentTabFragment) {
            this.J.j0().setOnItemClickListener(new e());
        }
        this.J.setOnScrollListener(new f());
        if (Gi()) {
            this.f42244c0 = new com.qzone.album.ui.widget.c(this, new g());
        }
        ai(true);
        if (this.K != null) {
            this.J.j0().setAdapter((ListAdapter) this.K);
        }
        this.J.setSupportPullUp(true);
        Fi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Yh(boolean z16) {
        boolean z17 = false;
        if (this.f42249h0 != null) {
            return false;
        }
        QZonePullToRefreshListView qZonePullToRefreshListView = this.J;
        if (qZonePullToRefreshListView != null && qZonePullToRefreshListView.j0() != null && this.C != null) {
            this.f42250i0 = new LinearLayout(getActivity());
            this.f42250i0.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            z17 = true;
            this.f42250i0.setOrientation(1);
            this.f42250i0.setGravity(1);
            this.J.j0().addHeaderView(this.f42250i0);
            FeedDetailCommentTips feedDetailCommentTips = new FeedDetailCommentTips(getActivity(), t4.a.N().F(this.C.getHostActivity()));
            this.f42249h0 = feedDetailCommentTips;
            feedDetailCommentTips.K = true;
            feedDetailCommentTips.setLoadingDataText(getString(R.string.f170931b54));
            this.f42249h0.setLoadingMoreDataText(getString(R.string.f170932b55));
            if (!z16) {
                ti(5);
            } else {
                this.f42248g0 = 3;
                ti(3);
            }
            this.f42250i0.addView(this.f42249h0);
        }
        return z17;
    }

    protected void Zh(int i3, int i16) {
        RelativeLayout.LayoutParams layoutParams;
        int l3 = ar.l();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l3, (i3 * l3) / i16);
        ImageView imageView = this.U;
        if (imageView != null) {
            imageView.setLayoutParams(layoutParams2);
            QZonePullToRefreshListView qZonePullToRefreshListView = (QZonePullToRefreshListView) this.D.findViewById(R.id.album_list);
            this.V = qZonePullToRefreshListView;
            if (qZonePullToRefreshListView != null && (layoutParams = (RelativeLayout.LayoutParams) qZonePullToRefreshListView.getLayoutParams()) != null) {
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, this.U.getLayoutParams().height);
                this.V.setLayoutParams(layoutParams);
            }
            RelativeLayout relativeLayout = this.T;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ai(boolean z16) {
        QZonePullToRefreshListView qZonePullToRefreshListView;
        if (this.C == null || this.M != null || (qZonePullToRefreshListView = this.J) == null || qZonePullToRefreshListView.j0() == null) {
            return false;
        }
        this.f42245d0 = new FrameLayout(this.C.getHostActivity());
        this.J.j0().addFooterView(this.f42245d0);
        if (this.f42253l0 == null) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.bux, (ViewGroup) null);
            this.f42253l0 = inflate;
            this.f42254m0 = (TextView) inflate.findViewById(R.id.epp);
            AsyncImageView asyncImageView = (AsyncImageView) this.f42253l0.findViewById(R.id.jte);
            String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_ARCHIVE_MEMORY, QzoneConfig.SECONDARY_MEMOEY_DIVIMAGE_URL, QzoneConfig.DefaultValue.DEFAULT_MEMORY_DIVIMAGE_URL);
            if (!TextUtils.isEmpty(config)) {
                asyncImageView.setAsyncImage(config);
            }
            FrameLayout frameLayout = this.f42245d0;
            if (frameLayout != null) {
                frameLayout.addView(this.f42253l0);
            }
        }
        this.M = t4.a.N().H(this.C.getHostActivity());
        if (!z16) {
            ri(5);
        } else {
            this.f42246e0 = 3;
            ri(3);
        }
        this.f42245d0.addView(this.M);
        return true;
    }

    protected boolean bi() {
        return t4.a.N().J(this.C.getHostActivity());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c0() {
        if (QZLog.isColorLevel()) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "AlbumBaseTabFragment\t doRefresh()");
        }
    }

    protected abstract void di();

    protected boolean ei() {
        return true;
    }

    protected boolean fi() {
        return true;
    }

    @Override // com.qzone.album.env.common.c
    public Activity getCurrentActivity() {
        j jVar = this.C;
        if (jVar != null) {
            return jVar.getHostActivity();
        }
        return null;
    }

    @Override // com.qzone.album.env.common.c
    public View getRootView() {
        return this.D;
    }

    protected String getTagName() {
        return "AlbumBaseTabFragment";
    }

    public void gi() {
        com.qzone.album.business.photolist.adapter.c cVar = this.K;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
        QZonePullToRefreshListView qZonePullToRefreshListView = this.J;
        if (qZonePullToRefreshListView != null) {
            qZonePullToRefreshListView.g0().setTextColor(AlbumPersonalizeManager.L().I());
        }
    }

    public final void hi() {
        if (this.C == null) {
            return;
        }
        if (!yh()) {
            t4.a.N().M(this.C.getHostActivity());
        } else if (li()) {
            zh(2);
            Bh();
        }
    }

    public void ii(s sVar, int i3) {
        com.qzone.proxy.feedcomponent.b.a("AlbumBaseTabFragment", "onHandleMessage, what: " + i3);
        if (i3 != -10000) {
            Sh();
        } else {
            hi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initData() {
        this.R = com.qzone.album.base.Service.a.W();
        this.S = AlbumCacheDataManager.J();
    }

    protected abstract void ji(AdapterView<?> adapterView, View view, int i3, long j3);

    public final void ki() {
        if (this.C == null) {
            return;
        }
        if (!yh()) {
            if (fi()) {
                t4.a.N().M(this.C.getHostActivity());
                Rh();
                com.qzone.album.ui.widget.c cVar = this.f42244c0;
                if (cVar != null) {
                    cVar.l(0);
                    return;
                }
                return;
            }
            return;
        }
        oi();
    }

    public boolean li() {
        View view = this.M;
        if (view == null) {
            return false;
        }
        return ((FeedDetailCommentTips) view).h();
    }

    protected boolean ni() {
        return !t4.a.N().J(this.C.getHostActivity());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof j) {
            this.C = (j) activity;
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.qzone.album.business.photolist.adapter.c cVar = this.K;
        if (cVar != null) {
            cVar.b(configuration);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Wh();
        Uh();
        t4.a.N().l();
        parseIntent();
        t4.a.N().k();
        initData();
        t4.a.N().i();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.D = layoutInflater.inflate(Ch(), viewGroup, false);
        Xh();
        Bi();
        t4.a.N().j();
        di();
        if (ei()) {
            update();
        }
        xh();
        gi();
        return this.D;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f42252k0.b();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f42252k0.c();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("key_album_owner_uin", this.P.longValue());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        this.Q = bundle;
        if (bundle != null) {
            this.P = Long.valueOf(bundle.getLong("key_album_owner_uin", 0L));
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public void onWindowFocusChanged() {
        com.qzone.album.env.common.a.m().d("[PhotoAlbum]AlbumPerformance", "AlbumBaseTabFragment", " onWindowFocusChanged end");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseIntent() {
        Intent intent;
        j jVar = this.C;
        if (jVar == null || (intent = jVar.getHostActivity().getIntent()) == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        this.Q = extras;
        if (extras != null) {
            this.P = Long.valueOf(extras.getLong("key_album_owner_uin", 0L));
            this.f42251j0 = this.Q.getInt(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_FROM, -1);
        }
        this.N = ro.a.a(intent);
        Bundle bundle = this.Q;
        if (bundle != null) {
            this.f42252k0 = new mc.a(Gh(), bundle.getLong(PerfTracer.PARAM_CLICK_TIME, 0L));
        }
    }

    protected abstract void pi();

    @Override // com.qzone.common.activities.base.BaseFragment
    public void showNoNetworkTips() {
        j jVar = this.C;
        if (jVar != null) {
            jVar.showNoNetworkTips();
        }
    }

    protected final void si(int i3, boolean z16) {
        if (this.f42245d0 == null || this.M == null || this.C == null) {
            return;
        }
        t4.a.N().L(this.C.getHostActivity(), this.M, i3);
        if (z16) {
            this.f42246e0 = i3;
        }
        if (i3 == 3) {
            if (this.f42245d0.getVisibility() != 8) {
                this.f42245d0.setVisibility(8);
                return;
            }
            return;
        }
        s_memory_seal_off s_memory_seal_offVar = this.F;
        if (s_memory_seal_offVar != null && !TextUtils.isEmpty(s_memory_seal_offVar.summary)) {
            this.f42245d0.setVisibility(0);
            this.M.setVisibility(8);
            this.f42253l0.setVisibility(0);
            this.f42254m0.setText(this.F.summary);
            return;
        }
        if (this.f42245d0.getVisibility() != 0) {
            this.f42245d0.setVisibility(0);
            this.M.setVisibility(0);
            this.f42253l0.setVisibility(8);
        }
    }

    protected final void ui(int i3, boolean z16) {
        FeedDetailCommentTips feedDetailCommentTips;
        if (this.f42250i0 == null || (feedDetailCommentTips = this.f42249h0) == null) {
            return;
        }
        feedDetailCommentTips.setState(i3);
        if (z16) {
            this.f42248g0 = i3;
        }
        if (i3 == 3) {
            if (this.f42250i0.getVisibility() != 8) {
                this.f42250i0.setVisibility(8);
            }
        } else if (this.f42250i0.getVisibility() != 0) {
            this.f42250i0.setVisibility(0);
        }
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public void update() {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.J;
        if (qZonePullToRefreshListView != null) {
            qZonePullToRefreshListView.setRefreshing(false);
        }
        j jVar = this.C;
        if (jVar != null) {
            Ei(jVar.U());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vi(String str) {
        if (this.C == null) {
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Drawable drawableAsync = ResDownloadManger.getmInstance().getDrawableAsync(7, str, new ResDownloadManger.ResLoadListener() { // from class: com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.8
            @Override // cooperation.qzone.util.ResDownloadManger.ResLoadListener
            public void onDownloaded(int i3, String str2, final Bitmap bitmap) {
                if (AlbumBaseTabFragment.this.C == null) {
                    QZLog.e("AlbumBaseTabFragment", 1, "[onDownloaded] type: " + i3 + " | resName: " + str2);
                    return;
                }
                QZLog.d("AlbumBaseTabFragment", 2, "subInitUI getBitmapDrawable onDownLoaded hasRefreshFinish:" + AlbumBaseTabFragment.this.f42242a0);
                AlbumBaseTabFragment.this.C.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AlbumBaseTabFragment albumBaseTabFragment = AlbumBaseTabFragment.this;
                        if (albumBaseTabFragment.f42242a0) {
                            return;
                        }
                        albumBaseTabFragment.f42243b0.setImageDrawable(new BitmapDrawable(bitmap));
                        AlbumBaseTabFragment.this.f42243b0.setScaleType(ImageView.ScaleType.FIT_XY);
                        AlbumBaseTabFragment.this.f42243b0.setVisibility(0);
                    }
                });
            }

            @Override // cooperation.qzone.util.ResDownloadManger.ResLoadListener
            public void onFailed(int i3, String str2) {
                if (AlbumBaseTabFragment.this.C == null) {
                    QZLog.e("AlbumBaseTabFragment", 1, "[onFailed] type: " + i3 + " | resName: " + str2);
                    return;
                }
                com.qzone.proxy.feedcomponent.b.i("AlbumBaseTabFragment", "subInitUI getBitmapDrawable onFailed");
                AlbumBaseTabFragment.this.C.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AlbumBaseTabFragment.this.f42243b0.setImageDrawable(null);
                        AlbumBaseTabFragment.this.f42243b0.setVisibility(8);
                    }
                });
            }
        }, options);
        if (drawableAsync != null && !this.f42242a0) {
            this.f42243b0.setImageDrawable(drawableAsync);
            this.f42243b0.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f42243b0.setVisibility(0);
            return;
        }
        this.f42243b0.setVisibility(8);
    }

    protected void wh() {
        if (this.J.isOverscrollHeadVisiable() || this.J.j0().getLastVisiblePosition() < (this.J.j0().getCount() - 1) - this.E) {
            return;
        }
        hi();
    }

    public void wi(boolean z16) {
        this.L = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void xh() {
        com.qzone.album.business.photolist.adapter.c cVar = this.K;
        if (cVar == null || !cVar.isEmpty()) {
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "AlbumBaseTabFragment\t checkHideFooter");
        }
        ri(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xi(int i3) {
        if (this.M != null) {
            new Rect();
            s_memory_seal_off s_memory_seal_offVar = this.F;
            if (s_memory_seal_offVar != null && !TextUtils.isEmpty(s_memory_seal_offVar.summary)) {
                ri(7);
            } else if (i3 > 2) {
                ri(7);
            } else {
                ri(6);
            }
        }
    }

    protected boolean yh() {
        j jVar = this.C;
        boolean checkNetworkConnect = jVar == null ? false : jVar.checkNetworkConnect();
        Mh(checkNetworkConnect);
        return checkNetworkConnect;
    }

    public final void zh(int i3) {
        String str;
        this.I = i3;
        if (i3 == 1) {
            if (this.M != null && this.C != null && t4.a.N().I(this.C.getHostActivity(), this.M)) {
                ri(this.f42246e0);
            }
            if (this.L) {
                zi();
            }
            str = "TYPE_REFRESH";
        } else if (i3 != 2) {
            str = "";
        } else {
            if (bi()) {
                Th();
            }
            j jVar = this.C;
            this.f42246e0 = t4.a.N().G(jVar == null ? null : jVar.getHostActivity(), this.M);
            si(1, false);
            str = "TYPE_GET_MORE";
        }
        xh();
        if (QZLog.isColorLevel()) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "AlbumBaseTabFragment\t checkRefreshOrGetMoreState(), reqType: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zi() {
        j jVar = this.C;
        if (jVar != null) {
            jVar.t();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements q7.a<p7.b> {
        b() {
        }

        @Override // q7.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(p7.b bVar) {
            if (bVar != null) {
                QZLog.i("AlbumBaseTabFragment", 2, "[cache]video list qboss imgUrl = " + bVar.f425445d + " jumpUrl=" + bVar.f425446e);
            }
        }

        @Override // q7.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(p7.b bVar, boolean z16) {
            if (!z16) {
                u4.a.z().f0("video_tab_banner_visible_" + AlbumBaseTabFragment.this.P, false);
                return;
            }
            if (bVar != null) {
                u4.a.z().h0("video_tab_banner_img_url_" + AlbumBaseTabFragment.this.P, bVar.f425445d);
                u4.a.z().h0("video_tab_banner_jump_url_" + AlbumBaseTabFragment.this.P, bVar.f425446e);
                AlbumBaseTabFragment.this.mi(bVar.f425445d);
                if (QZLog.isColorLevel()) {
                    QZLog.i("AlbumBaseTabFragment", 2, "[network]video list qboss imgUrl = " + bVar.f425445d + " jumpUrl=" + bVar.f425446e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Rh() {
        this.f42242a0 = true;
        j jVar = this.C;
        if (jVar == null) {
            QZLog.e("AlbumBaseTabFragment", 1, "[hideLoadingImage] tab operator should not be null.");
        } else {
            jVar.getHostActivity().runOnUiThread(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    ImageView imageView = AlbumBaseTabFragment.this.f42243b0;
                    if (imageView == null || imageView.getVisibility() != 0) {
                        return;
                    }
                    AlbumBaseTabFragment.this.f42243b0.setVisibility(8);
                    AlbumBaseTabFragment.this.f42243b0.setBackgroundDrawable(null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ri(int i3) {
        si(i3, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ti(int i3) {
        ui(i3, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Kh(QZoneDeletePhotoBean qZoneDeletePhotoBean, int i3) {
        if (qZoneDeletePhotoBean != null && this.S != null) {
            if (!TextUtils.isEmpty(qZoneDeletePhotoBean.albumId)) {
                this.S.r0(this.P.longValue(), qZoneDeletePhotoBean.albumId, qZoneDeletePhotoBean.photoIdList, i3);
                return;
            } else {
                this.S.s0(this.P.longValue(), qZoneDeletePhotoBean.videoIdList, i3);
                return;
            }
        }
        RFWLog.e("AlbumBaseTabFragment", RFWLog.USR, "photo id list is not valid");
    }

    public void Mh(boolean z16) {
        if (z16) {
            return;
        }
        Th();
        ri(this.f42246e0);
        xh();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof j) {
            this.C = (j) context;
        }
    }

    public void Ai(String str, String str2, String str3) {
        if (str == null || str2 == null) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.flo);
        this.W = viewStub;
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.T = (RelativeLayout) this.D.findViewById(R.id.f166470fe2);
        ImageView imageView = (ImageView) this.D.findViewById(R.id.gjx);
        this.U = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.U.setVisibility(8);
            Drawable loadImage = ImageLoader.getInstance().loadImage(str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.6
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str4, final Drawable drawable, ImageLoader.Options options) {
                    AlbumBaseTabFragment.this.U.post(new Runnable() { // from class: com.qzone.album.business.albumlist.fragment.AlbumBaseTabFragment.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AlbumBaseTabFragment.this.U.setImageDrawable(drawable);
                            int intrinsicHeight = drawable.getIntrinsicHeight();
                            int intrinsicWidth = drawable.getIntrinsicWidth();
                            AlbumBaseTabFragment.this.U.setVisibility(0);
                            AlbumBaseTabFragment.this.Zh(intrinsicHeight, intrinsicWidth);
                        }
                    });
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageCanceled(String str4, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageFailed(String str4, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageProgress(String str4, float f16, ImageLoader.Options options) {
                }
            });
            if (loadImage != null) {
                this.U.setImageDrawable(loadImage);
                int intrinsicHeight = loadImage.getIntrinsicHeight();
                int intrinsicWidth = loadImage.getIntrinsicWidth();
                this.U.setVisibility(0);
                Zh(intrinsicHeight, intrinsicWidth);
            }
            this.U.setOnClickListener(new i(str2, str3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements QZonePullToRefreshListView.c {
        d() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void Y() {
            AlbumBaseTabFragment.this.Sh();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onRefresh() {
            j jVar;
            if (AlbumBaseTabFragment.this.Ph() && (jVar = AlbumBaseTabFragment.this.C) != null && !jVar.checkNetworkConnect()) {
                com.qzone.album.env.common.a.m().U(R.string.ghi);
            }
            AlbumBaseTabFragment.this.ki();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullEnd() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullStart() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements c.b {
        g() {
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void a() {
            com.qzone.album.env.common.a.m().b("[PhotoAlbum]emptyViewController", "opClick");
            AlbumBaseTabFragment.this.Ah();
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void refresh() {
            try {
                AlbumBaseTabFragment.this.wi(true);
                AlbumBaseTabFragment albumBaseTabFragment = AlbumBaseTabFragment.this;
                albumBaseTabFragment.f42242a0 = false;
                albumBaseTabFragment.yi();
                AlbumBaseTabFragment.this.update();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void b() {
        }
    }

    protected void Ah() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bi() {
    }

    protected void yi() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements ImageLoader.ImageLoadListener {
        c() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (drawable != null) {
                u4.a.z().f0("video_tab_banner_visible_" + AlbumBaseTabFragment.this.P, true);
                return;
            }
            u4.a.z().f0("video_tab_banner_visible_" + AlbumBaseTabFragment.this.P, false);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Di(AbsListView absListView, int i3) {
    }

    protected void qi(String str, String str2) {
    }

    @Override // com.qzone.album.business.albumlist.fragment.d
    public void Y4(Fragment fragment, boolean z16, com.qzone.album.business.albumlist.fragment.e eVar) {
    }

    protected void Ci(AbsListView absListView, int i3, int i16, int i17) {
    }
}
