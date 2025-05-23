package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.bizdapters.CommodityAdapter;
import com.tencent.biz.subscribe.bizdapters.f;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.base.video.player.videourl.api.IThirdVideoManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeVideoDetailFragment extends SubscribeBaseFragment implements a.e {
    private static int W;
    private VideoPlayerView M;
    private View N;
    private boolean P;
    private TextView Q;
    protected BlockContainer R;
    private f S;
    private com.tencent.biz.subscribe.bizdapters.c T;
    private ImageView U;
    private ImageView V;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (SubscribeVideoDetailFragment.this.S != null && SubscribeVideoDetailFragment.this.M != null) {
                boolean z16 = true;
                ve0.b R0 = SubscribeVideoDetailFragment.this.S.R0(1);
                if (SubscribeVideoDetailFragment.this.M.A1() && SubscribeVideoDetailFragment.this.M.z1()) {
                    z16 = false;
                }
                R0.f441508h = z16;
                SubscribeVideoDetailFragment.this.Eh(R0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SubscribeVideoDetailFragment.this.onBackEvent();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c extends com.tencent.biz.subscribe.framework.b {
        c() {
        }

        @Override // com.tencent.biz.subscribe.framework.b
        public void b(ISuperPlayer iSuperPlayer) {
            try {
                if (QQPlayerService.s0()) {
                    QQPlayerService.m1(SubscribeVideoDetailFragment.this.getBaseActivity());
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("SubscribeVideoDetailFragment", 2, "QQPlayerService.stopPlayMusic exception!", e16);
                }
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class d implements s52.a {
        d() {
        }
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    protected void Bh(View view) {
        View view2 = ((IphoneTitleBarFragment) this).mContentView;
        if (view2 == null) {
            return;
        }
        view2.setBackgroundColor(-16777216);
        hideTitleBar();
        if (getBaseActivity().getRequestedOrientation() != 1) {
            getBaseActivity().setRequestedOrientation(1);
        }
        if (this.C == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putByteArray("bundle_key_subscribe_feed_bytes_array", this.C.toByteArray());
        bundle.putSerializable("bundle_key_feed_extra_type_info", this.D);
        f fVar = new f(bundle);
        this.S = fVar;
        fVar.F1((ViewGroup) ((IphoneTitleBarFragment) this).mContentView);
        af0.b bVar = this.J;
        if (bVar != null) {
            bVar.w(this.S);
        }
        BlockContainer blockContainer = (BlockContainer) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166789m61);
        this.R = blockContainer;
        blockContainer.setLayoutManagerType(3, 2);
        this.R.setParentFragment(this);
        this.R.setEnableLoadMore(true);
        this.R.setExtraTypeInfo(this.D);
        this.R.n(this.S);
        this.R.n(new CommodityAdapter(bundle));
        com.tencent.biz.subscribe.bizdapters.c cVar = new com.tencent.biz.subscribe.bizdapters.c(bundle);
        this.T = cVar;
        this.R.n(cVar);
        this.R.o(this);
        this.R.p();
        VideoPlayerView videoPlayerView = (VideoPlayerView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.mfu);
        this.M = videoPlayerView;
        videoPlayerView.setExtraTypeInfo(this.D);
        this.N = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.lxq);
        ImageView imageView = (ImageView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ln8);
        this.U = imageView;
        imageView.setBackgroundResource(R.drawable.h38);
        ImageView imageView2 = (ImageView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.loj);
        this.V = imageView2;
        imageView2.setBackgroundResource(R.drawable.h37);
        this.Q = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.lo5);
        this.V.setOnClickListener(new a());
        this.U.setOnClickListener(new b());
        this.M.setBaseVideoViewListenerSets(new c());
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    public void Eh(ve0.b bVar) {
        VideoPlayerView videoPlayerView = this.M;
        if (videoPlayerView != null && videoPlayerView.z1()) {
            this.E.O(this.M.z1());
        }
        super.Eh(bVar);
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    public void Fh(final CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        super.Fh(certifiedAccountMeta$StFeed);
        com.tencent.qav.thread.a.c().post(new Runnable() { // from class: com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (SubscribeVideoDetailFragment.this.S != null) {
                    SubscribeVideoDetailFragment.this.S.b1(SubscribeVideoDetailFragment.this.S.u1(), true);
                    SubscribeVideoDetailFragment.this.S.M0(certifiedAccountMeta$StFeed);
                }
            }
        });
    }

    public void Ih(boolean z16, int i3) {
        VideoPlayerView videoPlayerView;
        if (LiuHaiUtils.isLiuHaiUseValid() && getBaseActivity() != null && this.N != null && (videoPlayerView = this.M) != null) {
            if (z16 && !videoPlayerView.A1()) {
                ViewGroup.LayoutParams layoutParams = this.N.getLayoutParams();
                layoutParams.height = i3;
                this.N.setLayoutParams(layoutParams);
                this.N.setVisibility(0);
                return;
            }
            this.N.setVisibility(8);
        }
    }

    public void Jh(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        f fVar;
        if (this.M != null && (fVar = this.S) != null) {
            fVar.D1(certifiedAccountMeta$StFeed);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.c7h;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        BlockContainer blockContainer = this.R;
        if (blockContainer != null && blockContainer.l()) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LiuHaiUtils.initLiuHaiProperty(getBaseActivity());
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen();
        W = hashCode();
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        BlockContainer blockContainer;
        super.onDestroy();
        f fVar = this.S;
        if (fVar != null && fVar.t1() && (blockContainer = this.R) != null) {
            blockContainer.m();
        }
        TimeAndCountHelper.d().h("subscribe_freshman_interaction_guide");
        TimeAndCountHelper.d().h("subscribe_freshman_share_guide");
        f fVar2 = this.S;
        if (fVar2 != null) {
            fVar2.Z0();
        }
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        VideoPlayerView videoPlayerView;
        super.onPause();
        if (!this.G && (videoPlayerView = this.M) != null) {
            if (videoPlayerView.C1() && !this.M.B1()) {
                this.M.R();
                this.P = true;
            }
            this.M.H1(true);
        }
        this.G = false;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (W != hashCode()) {
            VideoPlayerView videoPlayerView = this.M;
            if (videoPlayerView != null) {
                videoPlayerView.U();
                QLog.d("SubscribeVideoDetailFragment", 4, "resetDataSource");
            }
        } else {
            VideoPlayerView videoPlayerView2 = this.M;
            if (videoPlayerView2 != null) {
                if (this.P && !videoPlayerView2.C1()) {
                    this.M.N1();
                }
                this.M.H1(false);
                QLog.d("SubscribeVideoDetailFragment", 4, "continue to play");
            }
        }
        this.P = false;
    }

    @Override // com.tencent.biz.subscribe.part.block.a.e
    public void r2(String str, a.d dVar) {
        if ("share_key_subscribe_feeds_update".equals(str) && dVar != null && this.E != null) {
            Object obj = dVar.f96169a;
            if ((obj instanceof CertifiedAccountMeta$StFeed) && ((CertifiedAccountMeta$StFeed) obj).type.get() == 3) {
                ((IThirdVideoManager) QRoute.api(IThirdVideoManager.class)).sendUrlToUUIDRequest(((CertifiedAccountMeta$StFeed) dVar.f96169a).video.playUrl.get(), new d());
            }
        }
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    protected View th() {
        return this.V;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    protected TextView uh() {
        return this.Q;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment, bf0.a
    public int[] x1(int i3, int i16) {
        int screenWidth = (int) (ImmersiveUtils.getScreenWidth() * (i16 / i3));
        int[] iArr = new int[2];
        iArr[0] = ImmersiveUtils.getScreenWidth();
        int i17 = f.E0;
        if (screenWidth > i17) {
            screenWidth = i17;
        }
        iArr[1] = screenWidth;
        return iArr;
    }

    @Override // com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
    protected void xh(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        f fVar = this.S;
        if (fVar != null) {
            fVar.f1(certifiedAccountMeta$StFeed);
        }
    }
}
