package k80;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b extends d implements QFSImageBanner.c {
    private ImageView R;
    private QFSImageBanner S;
    private p80.e T;
    private int U;
    private int V;
    private int W;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            if (i3 != b.this.U) {
                b.this.U = i3;
                if (i3 == 0) {
                    b.this.W++;
                    b.this.t1(true);
                } else if (i3 == b.this.V - 1) {
                    b.this.r1(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E1() {
        this.S.setCurrentItem(0, false);
    }

    @Override // k80.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.R = (ImageView) view.findViewById(R.id.f4890219);
        this.S = (QFSImageBanner) view.findViewById(R.id.f516728q);
        p80.e eVar = new p80.e();
        this.T = eVar;
        eVar.setEnableLoop(true);
        this.S.setAdapter(this.T);
        this.S.setEnableOperate(false);
        this.S.setOnItemClickListener(this);
        this.S.q0(new a());
        this.S.X().setOffscreenPageLimit(1);
    }

    @Override // k80.d, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        super.a();
        this.S.y0();
    }

    @Override // k80.d
    public void k1() {
        if (this.C == null) {
            return;
        }
        this.R.setVisibility(8);
        this.S.setVisibility(8);
        this.T.v0(null);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.c
    public void onItemClick(int i3) {
        o1();
    }

    @Override // k80.d, e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        super.pause();
        this.S.y0();
    }

    @Override // k80.d, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        if (isPlaying()) {
            return;
        }
        super.play();
        this.M.onPlay();
        this.S.v0();
        QFSSearchPrerenderManager.E(m0()).r(i1(), this.f85018i);
    }

    @Override // k80.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: q1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        this.S.setVisibility(0);
        this.J.setVisibility(4);
        if (!this.M.f()) {
            this.R.setVisibility(0);
        }
        this.V = feedCloudMeta$StFeed.images.size();
        this.W = 0;
        this.T.v0(feedCloudMeta$StFeed.images.get());
        this.S.post(new Runnable() { // from class: k80.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.E1();
            }
        });
    }

    @Override // k80.d
    protected void r1(boolean z16) {
        this.N.d(this.C, this.V, this.U, z16);
    }

    @Override // k80.d, e80.g
    public void stop() {
        if (!isPlaying()) {
            return;
        }
        super.stop();
        this.S.y0();
    }

    @Override // k80.d
    protected void t1(boolean z16) {
        this.N.e(this.C, this.U, z16, this.W);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchBaseCardImagePresenter";
    }
}
