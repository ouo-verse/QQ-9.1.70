package com.qzone.common.activities.base;

import android.os.Message;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.detail.ui.component.FeedDetailCommentTips;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.mobileqq.R;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CustomListViewActivity extends QZoneTitleBarActivity {
    public int K0;
    protected BaseAdapter L0;
    protected QZonePullToRefreshListView M0;
    protected FeedDetailCommentTips N0;
    protected FeedDetailCommentTips O0;
    protected LinearLayout P0;
    protected LinearLayout Q0;
    protected TextView T0;
    public int U0;
    protected int R0 = 5;
    protected int S0 = 5;
    public int V0 = R.string.gea;
    protected boolean W0 = true;
    protected int X0 = 500;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements d5.g {
        a() {
        }

        @Override // d5.g
        public boolean onClick(View view) {
            return CustomListViewActivity.this.S3(view);
        }

        @Override // d5.g
        public void onDoubleClick(View view) {
            CustomListViewActivity.this.T3(view);
        }
    }

    protected final void C3() {
        BaseAdapter baseAdapter = this.L0;
        if (baseAdapter == null || !baseAdapter.isEmpty()) {
            return;
        }
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, this.TAG + "\t checkHideFooter");
        b4(3);
    }

    protected boolean D3() {
        boolean checkNetworkConnect = super.checkNetworkConnect();
        K3(checkNetworkConnect);
        return checkNetworkConnect;
    }

    protected final void E3(int i3) {
        this.K0 = i3;
        if (i3 == 1) {
            FeedDetailCommentTips feedDetailCommentTips = this.N0;
            if (feedDetailCommentTips != null && feedDetailCommentTips.g()) {
                b4(this.R0);
            }
            if (this.W0) {
                t();
            }
        } else if (i3 == 2) {
            if (g3()) {
                L3();
            }
            this.R0 = this.N0.e();
            c4(1, false);
        } else if (i3 == 3) {
            if (g3()) {
                L3();
            }
            this.S0 = this.O0.e();
            e4(1, false);
        }
        C3();
    }

    protected void F3() {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, this.TAG + "\t doGetMore()");
    }

    protected void H3() {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, this.TAG + "\t doRefresh()");
    }

    public View I3() {
        FeedDetailCommentTips feedDetailCommentTips = this.N0;
        if (feedDetailCommentTips != null) {
            return feedDetailCommentTips.d();
        }
        return null;
    }

    protected long J3() {
        return 0L;
    }

    protected void L3() {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.M0;
        if (qZonePullToRefreshListView == null) {
            return;
        }
        qZonePullToRefreshListView.l0();
        y();
    }

    protected boolean M3() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P3(long... jArr) {
        if (this.M0 != null) {
            long j3 = (jArr == null || jArr.length <= 0) ? 0L : jArr[0];
            if (j3 == 0) {
                j3 = J3();
            }
            if (j3 == 0) {
                return;
            }
            this.M0.setLastUpdateTimeStamp(String.format(getString(R.string.c0o), com.qzone.album.util.g.b(j3)));
        }
    }

    protected void Q3() {
        if (!D3()) {
            if (M3()) {
                showNoNetworkTips();
            }
        } else if (U3()) {
            E3(2);
            F3();
        }
    }

    protected void R3() {
        if (!D3()) {
            if (M3()) {
                showNoNetworkTips();
            }
        } else if (V3()) {
            E3(3);
            G3();
        }
    }

    protected boolean S3(View view) {
        scrollToTop();
        return true;
    }

    protected void T3(View view) {
        scrollToTop();
    }

    protected boolean U3() {
        FeedDetailCommentTips feedDetailCommentTips = this.N0;
        if (feedDetailCommentTips == null) {
            return false;
        }
        return feedDetailCommentTips.h();
    }

    protected boolean V3() {
        FeedDetailCommentTips feedDetailCommentTips = this.O0;
        if (feedDetailCommentTips == null) {
            return false;
        }
        return feedDetailCommentTips.h();
    }

    protected boolean W3() {
        return !g3();
    }

    protected final void c4(int i3, boolean z16) {
        FeedDetailCommentTips feedDetailCommentTips;
        if (this.Q0 == null || (feedDetailCommentTips = this.N0) == null) {
            return;
        }
        feedDetailCommentTips.setState(i3);
        if (z16) {
            this.R0 = i3;
        }
        if (i3 == 3) {
            if (this.Q0.getVisibility() != 8) {
                this.Q0.setVisibility(8);
            }
        } else if (this.Q0.getVisibility() != 0) {
            this.Q0.setVisibility(0);
        }
    }

    protected final void e4(int i3, boolean z16) {
        FeedDetailCommentTips feedDetailCommentTips;
        if (this.P0 == null || (feedDetailCommentTips = this.O0) == null) {
            return;
        }
        feedDetailCommentTips.setState(i3);
        if (z16) {
            this.S0 = i3;
        }
        if (i3 == 3) {
            if (this.P0.getVisibility() != 8) {
                this.P0.setVisibility(8);
            }
        } else if (this.P0.getVisibility() != 0) {
            this.P0.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.QZoneTitleBarActivity
    public View onCreateCenterView() {
        super.onCreateCenterView();
        X3(this.f45404f0);
        return this.f45400b0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (message == null) {
            return;
        }
        if (message.what == 87 && W3()) {
            E3(1);
            H3();
        }
        if (message.what == -10000) {
            Q3();
        }
        if (message.what == -10001) {
            R3();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity
    public void onNetStateChanged(boolean z16) {
        super.onNetStateChanged(z16);
        K3(z16);
        if (!z16) {
            a4(R.string.f170565u8);
            return;
        }
        BaseAdapter baseAdapter = this.L0;
        if (baseAdapter != null && baseAdapter.getCount() <= 0) {
            QZonePullToRefreshListView qZonePullToRefreshListView = this.M0;
            if (qZonePullToRefreshListView != null) {
                qZonePullToRefreshListView.setRefreshing(false);
                return;
            }
            return;
        }
        a4(this.U0);
    }

    public final void onRefresh() {
        if (!D3()) {
            if (M3()) {
                showNoNetworkTips();
            }
        } else {
            getHandler().removeMessages(87);
            getHandler().sendEmptyMessageDelayed(87, this.X0);
        }
    }

    public void scrollToTop() {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.M0;
        if (qZonePullToRefreshListView == null) {
            return;
        }
        if (qZonePullToRefreshListView.j0() == null || this.M0.j0().getFirstVisiblePosition() != 0) {
            this.M0.scrollToTop();
        }
    }

    protected final void b4(int i3) {
        c4(i3, true);
    }

    protected final void d4(int i3) {
        e4(i3, true);
    }

    protected void K3(boolean z16) {
        if (z16) {
            return;
        }
        L3();
        b4(this.R0);
        d4(this.S0);
        C3();
    }

    public void X3(View view) {
        if (view != null) {
            new com.qzone.widget.c(view).d(new a());
        }
    }

    protected void a4(int i3) {
        if (i3 <= 0) {
            i3 = this.V0;
        }
        TextView textView = this.T0;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.T0.setText(i3);
        if (i3 != R.string.f170565u8) {
            this.U0 = i3;
        }
    }

    protected void G3() {
    }
}
