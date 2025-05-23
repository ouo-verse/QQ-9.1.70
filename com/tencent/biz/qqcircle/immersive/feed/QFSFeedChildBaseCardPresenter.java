package com.tencent.biz.qqcircle.immersive.feed;

import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedCardAnimWrap;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.biz.qqcircle.widgets.RoundImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashSet;

/* loaded from: classes4.dex */
public abstract class QFSFeedChildBaseCardPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private static final Long T = 1000L;
    private static final Long U = 500L;
    private static final Long V = 20000L;
    protected View I;
    private RoundFrameLayout J;
    protected RoundImageView K;
    protected TextView L;
    protected TextView M;
    protected Button N;
    protected TextView P;
    protected QFSFeedCardAnimWrap R;
    protected HashSet<Integer> Q = new HashSet<>();
    protected boolean S = false;

    /* JADX WARN: Multi-variable type inference failed */
    private long h1() {
        long j3;
        PBUInt64Field pBUInt64Field;
        FeedCloudMeta$StFeed c16 = com.tencent.biz.qqcircle.immersive.feed.ad.u.c(this.E);
        if (c16 != null) {
            pBUInt64Field = c16.createTime;
        } else {
            T t16 = this.f85017h;
            if (t16 != 0) {
                pBUInt64Field = ((FeedCloudMeta$StFeed) t16).createTimeNs;
            } else {
                j3 = 0;
                if (j3 >= U.longValue() || j3 > V.longValue()) {
                    return T.longValue();
                }
                return j3;
            }
        }
        j3 = pBUInt64Field.get() * 1000;
        if (j3 >= U.longValue()) {
        }
        return T.longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        if (k1()) {
            j1(this.C);
            QFSFeedCardAnimWrap qFSFeedCardAnimWrap = this.R;
            if (qFSFeedCardAnimWrap != null) {
                qFSFeedCardAnimWrap.C();
            }
            l1((FeedCloudMeta$StFeed) this.f85017h);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        QFSFeedCardAnimWrap qFSFeedCardAnimWrap = this.R;
        if (qFSFeedCardAnimWrap != null) {
            qFSFeedCardAnimWrap.D();
        }
        View view = this.I;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    protected abstract boolean g1();

    protected QFSFeedCardAnimWrap.j i1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j1(View view) {
        if (view != null && !this.S) {
            this.S = true;
            View inflate = ((ViewStub) view.findViewById(R.id.v_b)).inflate();
            this.I = inflate;
            this.J = (RoundFrameLayout) inflate.findViewById(R.id.f39371bh);
            this.K = (RoundImageView) this.I.findViewById(R.id.f38591_d);
            this.L = (TextView) this.I.findViewById(R.id.f38621_g);
            this.M = (TextView) this.I.findViewById(R.id.f38581_c);
            this.N = (Button) this.I.findViewById(R.id.f38571_b);
            this.P = (TextView) this.I.findViewById(R.id.f39331bd);
            this.J.setOnClickListener(this);
            this.I.setOnClickListener(this);
            this.K.setOnClickListener(this);
            this.L.setOnClickListener(this);
            this.M.setOnClickListener(this);
            this.N.setOnClickListener(this);
            this.Q.add(Integer.valueOf(R.id.f39371bh));
            this.Q.add(Integer.valueOf(R.id.f38591_d));
            this.Q.add(Integer.valueOf(R.id.f38621_g));
            this.Q.add(Integer.valueOf(R.id.f38581_c));
            this.Q.add(Integer.valueOf(R.id.f38571_b));
            this.R = new QFSFeedCardAnimWrap(view, this.I, i1());
            return;
        }
        QLog.w("QFSFeedChildBusinessCardPresenter", 1, "[initAdPupWindow] cancel, rootView=" + view + ",isInitView=" + this.S);
    }

    protected abstract boolean k1();

    /* JADX INFO: Access modifiers changed from: protected */
    public void l1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        PBUInt64Field pBUInt64Field;
        if (feedCloudMeta$StFeed != null && this.S && this.I != null && this.R != null) {
            FeedCloudMeta$StFeed c16 = com.tencent.biz.qqcircle.immersive.feed.ad.u.c(this.E);
            if (c16 != null) {
                pBUInt64Field = c16.createTime;
            } else {
                pBUInt64Field = feedCloudMeta$StFeed.createTime;
            }
            long j3 = pBUInt64Field.get() * 1000;
            if (j3 < U.longValue() || j3 > V.longValue()) {
                j3 = T.longValue();
            }
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBaseCardPresenter.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    QFSFeedChildBaseCardPresenter.this.I.setVisibility(0);
                    QFSFeedChildBaseCardPresenter qFSFeedChildBaseCardPresenter = QFSFeedChildBaseCardPresenter.this;
                    qFSFeedChildBaseCardPresenter.m1((FeedCloudMeta$StFeed) qFSFeedChildBaseCardPresenter.f85017h);
                }
            });
            this.R.p(j3, h1(), g1());
        }
    }

    protected abstract void m1(FeedCloudMeta$StFeed feedCloudMeta$StFeed);
}
