package k80;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class g extends d implements QFSSearchVideoPlayHelper.d, e80.f {
    private QFSVideoView R;
    protected QFSSearchVideoPlayHelper S;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a implements QFSSearchVideoPlayHelper.d {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<g> f411878d;

        public a(g gVar) {
            this.f411878d = null;
            this.f411878d = new WeakReference<>(gVar);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public void R() {
            g gVar = this.f411878d.get();
            if (gVar != null) {
                gVar.R();
            } else {
                QLog.w("QFSSearchBaseCardVideoPresenter", 1, "onReplay error");
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public int b0() {
            g gVar = this.f411878d.get();
            if (gVar != null) {
                return gVar.b0();
            }
            QLog.w("QFSSearchBaseCardVideoPresenter", 1, "getStartOffset error");
            return 0;
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public void c0(int i3, int i16) {
            g gVar = this.f411878d.get();
            if (gVar != null) {
                gVar.c0(i3, i16);
            } else {
                QLog.w("QFSSearchBaseCardVideoPresenter", 1, "updatePlayProgress error");
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public void d0() {
            g gVar = this.f411878d.get();
            if (gVar != null) {
                gVar.d0();
            } else {
                QLog.w("QFSSearchBaseCardVideoPresenter", 1, "onCancelPlay error");
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public void o0() {
            g gVar = this.f411878d.get();
            if (gVar != null) {
                gVar.o0();
            } else {
                QLog.w("QFSSearchBaseCardVideoPresenter", 1, "onPostPlay error");
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public void onCompletion() {
            g gVar = this.f411878d.get();
            if (gVar != null) {
                gVar.onCompletion();
            } else {
                QLog.w("QFSSearchBaseCardVideoPresenter", 1, "onCompletion error");
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public boolean onPlayError(int i3) {
            g gVar = this.f411878d.get();
            if (gVar != null) {
                return gVar.onPlayError(i3);
            }
            QLog.w("QFSSearchBaseCardVideoPresenter", 1, "onPlayError error:" + i3);
            return false;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopEnd() {
            g gVar = this.f411878d.get();
            if (gVar != null) {
                gVar.onVideoLoopEnd();
            } else {
                QLog.w("QFSSearchBaseCardVideoPresenter", 1, "onVideoLoopEnd error");
            }
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopStart() {
            g gVar = this.f411878d.get();
            if (gVar != null) {
                gVar.onVideoLoopStart();
            } else {
                QLog.w("QFSSearchBaseCardVideoPresenter", 1, "onVideoLoopStart error");
            }
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
        public void p0(ISuperPlayer iSuperPlayer) {
            g gVar = this.f411878d.get();
            if (gVar != null) {
                gVar.t1(false);
                gVar.p0(iSuperPlayer);
            } else {
                QLog.w("QFSSearchBaseCardVideoPresenter", 1, "onVideoLoopStart error");
            }
        }
    }

    private static void A1(View view, int i3, int i16) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = i3;
        layoutParams.height = i16;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        view.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void B1() {
        Size g16 = ad.g(this.C);
        q50.b.e().b(this.K);
        Option requestHeight = Option.getDefaultOptions(null).setTargetView(this.J).setUrl(((FeedCloudMeta$StFeed) this.f85017h).cover.picUrl.get()).setLoadingDrawableColor(0).setRequestWidth(g16.getWidth()).setRequestHeight(g16.getHeight());
        this.K = requestHeight;
        requestHeight.setSupportRecycler(true);
        this.K.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1() {
        final Bitmap y16 = this.S.y(this.J.getWidth(), this.J.getHeight());
        this.C.post(new Runnable() { // from class: k80.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.G1(y16);
            }
        });
    }

    private static Size E1(Size size, int i3, int i16) {
        if (i3 == -1 && i16 == -1) {
            return new Size(-1, -1);
        }
        int width = size.getWidth();
        return new Size(width, (int) ((width / i3) * i16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G1(Bitmap bitmap) {
        if (bitmap == null) {
            q50.b.e().n(this.K);
        } else {
            this.J.setImageBitmap(bitmap);
        }
        this.R.setVisibility(4);
        this.J.setVisibility(0);
    }

    private void I1() {
        q50.b.e().n(this.K);
        this.J.setVisibility(0);
        this.R.setVisibility(4);
    }

    private void K1(int i3) {
        ISuperPlayer superPlayer = this.R.getSuperPlayer();
        if (superPlayer != null) {
            superPlayer.setXYaxis(i3);
            this.R.requestLayout();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void L1() {
        ISuperPlayer superPlayer = this.R.getSuperPlayer();
        if (superPlayer != null && superPlayer.isPlaying()) {
            int durationMs = (int) superPlayer.getDurationMs();
            int currentPositionMs = (int) superPlayer.getCurrentPositionMs();
            l80.b F1 = F1();
            if (F1 != null) {
                F1.h(durationMs, currentPositionMs, ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
            }
        }
    }

    private void Y0(View view, int i3, int i16) {
        float f16;
        if (i16 != 0 && i3 != 0 && view != null) {
            Size E1 = E1(ad.g(this.C), i3, i16);
            int width = E1.getWidth();
            int height = E1.getHeight();
            A1(view, width, height);
            int j3 = bz.j();
            if (j3 > 0) {
                f16 = j3 / r0.getWidth();
            } else {
                f16 = 1.5f;
            }
            DisplayUtil.adjustViewSize(new DisplayUtil.AdjustViewSizeParams().setView(view).setDefaultWidth(width).setDefaultHeight(height).setTargetWidth(j3).setMaxCardWidthScale(f16).setLayoutParams(view.getLayoutParams()));
            return;
        }
        QLog.d("QFSSearchBaseCardVideoPresenter", 1, "setSize origin size zero");
    }

    @Override // k80.d, com.tencent.biz.qqcircle.immersive.views.search.util.f.b
    public void B(boolean z16) {
        super.B(z16);
        this.R.setOutPutMute(z16);
    }

    protected Size D1() {
        return ad.g(this.C);
    }

    @Nullable
    protected l80.b F1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void H1() {
        this.R.setVisibility(0);
        Boolean J = QFSSearchPrerenderManager.J(this.S.B(), (FeedCloudMeta$StFeed) this.f85017h);
        if (J != null && J.booleanValue()) {
            this.L.setStatusPlay();
        } else {
            this.L.setStatusLoading();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void J1() {
        QFSSearchPrerenderManager.E(this.C.getContext()).R((FeedCloudMeta$StFeed) this.f85017h, null, i1(), this.f85018i);
    }

    @Override // k80.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull @NotNull View view) {
        super.N0(view);
        this.R = (QFSVideoView) view.findViewById(R.id.f517228v);
        QFSSearchVideoPlayHelper qFSSearchVideoPlayHelper = new QFSSearchVideoPlayHelper(this.L, this.M, i1(), QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE);
        this.S = qFSSearchVideoPlayHelper;
        qFSSearchVideoPlayHelper.T(this.R);
        this.S.R(new a(this));
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void R() {
        r1(true);
        t1(true);
    }

    @Override // k80.d, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        super.a();
        I1();
        this.S.K();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void d0() {
        this.L.h();
    }

    @Override // e80.f
    public void e0() {
        super.a();
        I1();
        this.S.V(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k80.d
    protected void g1() {
        float f16;
        if (this.f85017h == 0) {
            QLog.d("QFSSearchBaseCardVideoPresenter", 1, "stFeed is null");
            return;
        }
        this.J.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int i3 = ((FeedCloudMeta$StFeed) this.f85017h).video.width.get();
        int i16 = ((FeedCloudMeta$StFeed) this.f85017h).video.height.get();
        if (i16 > i3) {
            Y0(this.J, -1, -1);
            Y0(this.R, -1, -1);
        } else {
            Y0(this.J, i3, i16);
            Y0(this.R, i3, i16);
        }
        Size D1 = D1();
        int j3 = bz.j();
        if (j3 > 0) {
            f16 = j3 / D1.getWidth();
        } else {
            f16 = 1.5f;
        }
        DisplayUtil.adjustViewSize(new DisplayUtil.AdjustViewSizeParams().setView(this.I).setDefaultWidth(D1.getWidth()).setDefaultHeight(D1.getHeight()).setTargetWidth(j3).setMaxCardWidthScale(f16).setLayoutParams(this.I.getLayoutParams()));
        K1(2);
    }

    @Override // k80.d
    public void k1() {
        if (this.C == null) {
            return;
        }
        this.R.setVisibility(8);
    }

    public void o0() {
        this.L.setStatusPlay();
        ad.c(this.J, this.K);
    }

    @Override // k80.d
    protected void o1() {
        super.o1();
        J1();
    }

    public boolean onPlayError(int i3) {
        this.L.h();
        return false;
    }

    @Override // k80.d, e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        stop();
    }

    @Override // k80.d, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        if (isPlaying()) {
            return;
        }
        super.play();
        H1();
        this.S.I();
    }

    @Override // k80.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: q1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.S.Q(i3);
        this.S.S(feedCloudMeta$StFeed);
        this.J.setVisibility(0);
        this.R.setVisibility(4);
        this.R.bindData(this.f85017h, i3);
        g1();
        B1();
    }

    @Override // k80.d
    protected void r1(boolean z16) {
        QFSVideoView qFSVideoView = this.R;
        if (qFSVideoView == null) {
            return;
        }
        this.N.c(qFSVideoView);
    }

    @Override // k80.d, e80.g
    public void stop() {
        if (!isPlaying()) {
            return;
        }
        L1();
        super.stop();
        this.S.V(new Runnable() { // from class: k80.e
            @Override // java.lang.Runnable
            public final void run() {
                g.this.C1();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k80.d
    protected void t1(boolean z16) {
        QFSVideoView qFSVideoView = this.R;
        if (qFSVideoView == null) {
            return;
        }
        this.N.b(qFSVideoView, VideoReport.getElementParams(this.C), (FeedCloudMeta$StFeed) this.f85017h, r0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchBaseCardVideoPresenter";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void onCompletion() {
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
    public void onVideoLoopEnd() {
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
    public void onVideoLoopStart() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void p0(ISuperPlayer iSuperPlayer) {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    @Deprecated
    public final void c0(int i3, int i16) {
    }
}
