package com.qzone.common.activities.base;

import android.os.Message;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qzone.detail.ui.component.FeedDetailCommentTips;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.mobileqq.R;
import com.tencent.widget.AbsListView;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CustomListViewFragmentV2 extends QZoneTitleBarFragmentV2 {

    /* renamed from: h0, reason: collision with root package name */
    public int f45058h0;

    /* renamed from: i0, reason: collision with root package name */
    protected BaseAdapter f45059i0;

    /* renamed from: j0, reason: collision with root package name */
    protected QZonePullToRefreshListView f45060j0;

    /* renamed from: k0, reason: collision with root package name */
    protected FeedDetailCommentTips f45061k0;

    /* renamed from: l0, reason: collision with root package name */
    protected FeedDetailCommentTips f45062l0;

    /* renamed from: m0, reason: collision with root package name */
    protected LinearLayout f45063m0;

    /* renamed from: n0, reason: collision with root package name */
    protected LinearLayout f45064n0;

    /* renamed from: q0, reason: collision with root package name */
    protected TextView f45067q0;

    /* renamed from: r0, reason: collision with root package name */
    protected ProgressBar f45068r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f45069s0;

    /* renamed from: o0, reason: collision with root package name */
    protected int f45065o0 = 5;

    /* renamed from: p0, reason: collision with root package name */
    protected int f45066p0 = 5;

    /* renamed from: t0, reason: collision with root package name */
    public int f45070t0 = R.string.gea;

    /* renamed from: u0, reason: collision with root package name */
    protected boolean f45071u0 = true;

    /* renamed from: v0, reason: collision with root package name */
    protected int f45072v0 = 500;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements d5.g {
        a() {
        }

        @Override // d5.g
        public boolean onClick(View view) {
            return CustomListViewFragmentV2.this.vi(view);
        }

        @Override // d5.g
        public void onDoubleClick(View view) {
            CustomListViewFragmentV2.this.wi(view);
        }
    }

    protected final void Di(int i3, boolean z16) {
        FeedDetailCommentTips feedDetailCommentTips;
        if (this.f45064n0 == null || (feedDetailCommentTips = this.f45061k0) == null) {
            return;
        }
        feedDetailCommentTips.setState(i3);
        if (z16) {
            this.f45065o0 = i3;
        }
        if (i3 == 3) {
            if (this.f45064n0.getVisibility() != 8) {
                this.f45064n0.setVisibility(8);
            }
        } else if (this.f45064n0.getVisibility() != 0) {
            this.f45064n0.setVisibility(0);
        }
    }

    protected final void Fi(int i3, boolean z16) {
        FeedDetailCommentTips feedDetailCommentTips;
        if (this.f45063m0 == null || (feedDetailCommentTips = this.f45062l0) == null) {
            return;
        }
        feedDetailCommentTips.setState(i3);
        if (z16) {
            this.f45066p0 = i3;
        }
        if (i3 == 3) {
            if (this.f45063m0.getVisibility() != 8) {
                this.f45063m0.setVisibility(8);
            }
        } else if (this.f45063m0.getVisibility() != 0) {
            this.f45063m0.setVisibility(0);
        }
    }

    public void Hi(boolean z16) {
        this.f45071u0 = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ii() {
        ProgressBar progressBar = this.f45068r0;
        if (progressBar == null || progressBar.getVisibility() == 0) {
            return;
        }
        this.f45068r0.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c0() {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, BaseFragment.TAG + "\t doRefresh()");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void fi() {
        BaseAdapter baseAdapter = this.f45059i0;
        if (baseAdapter == null || !baseAdapter.isEmpty()) {
            return;
        }
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, BaseFragment.TAG + "\t checkHideFooter");
        Ci(3);
    }

    protected boolean gi() {
        boolean checkNetworkConnect = super.checkNetworkConnect();
        li(checkNetworkConnect);
        return checkNetworkConnect;
    }

    protected final void hi(int i3) {
        this.f45058h0 = i3;
        if (i3 == 1) {
            FeedDetailCommentTips feedDetailCommentTips = this.f45061k0;
            if (feedDetailCommentTips != null && feedDetailCommentTips.g()) {
                Ci(this.f45065o0);
            }
            if (this.f45071u0) {
                ci();
            }
        } else if (i3 == 2) {
            if (Jh()) {
                oi();
            }
            this.f45065o0 = this.f45061k0.e();
            Di(1, false);
        } else if (i3 == 3) {
            if (Jh()) {
                oi();
            }
            this.f45066p0 = this.f45062l0.e();
            Fi(1, false);
        }
        fi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ii() {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, BaseFragment.TAG + "\t doGetMore()");
    }

    protected long ki() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mi() {
        TextView textView = this.f45067q0;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.f45067q0.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ni() {
        ProgressBar progressBar = this.f45068r0;
        if (progressBar == null || progressBar.getVisibility() == 8) {
            return;
        }
        this.f45068r0.setVisibility(8);
    }

    protected void oi() {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.f45060j0;
        if (qZonePullToRefreshListView == null) {
            return;
        }
        qZonePullToRefreshListView.l0();
        Dh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2
    public View onCreateCenterView() {
        super.onCreateCenterView();
        Ai(this.F);
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (message == null) {
            return;
        }
        if (message.what == 87 && zi()) {
            hi(1);
            c0();
        }
        if (message.what == -10000) {
            ti();
        }
        if (message.what == -10001) {
            ui();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onNetStateChanged(boolean z16) {
        super.onNetStateChanged(z16);
        li(z16);
        if (!z16) {
            Bi(R.string.f170565u8);
            return;
        }
        BaseAdapter baseAdapter = this.f45059i0;
        if (baseAdapter != null && baseAdapter.getCount() <= 0) {
            QZonePullToRefreshListView qZonePullToRefreshListView = this.f45060j0;
            if (qZonePullToRefreshListView != null) {
                qZonePullToRefreshListView.setRefreshing(false);
                return;
            }
            return;
        }
        Bi(this.f45069s0);
    }

    public final void onRefresh() {
        if (!gi()) {
            if (ri()) {
                showNoNetworkTips();
            }
        } else {
            getHandler().removeMessages(87);
            getHandler().sendEmptyMessageDelayed(87, this.f45072v0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean qi(boolean z16) {
        boolean z17 = false;
        if (this.f45061k0 != null) {
            return false;
        }
        QZonePullToRefreshListView qZonePullToRefreshListView = this.f45060j0;
        if (qZonePullToRefreshListView != null && qZonePullToRefreshListView.j0() != null) {
            this.f45064n0 = new LinearLayout(getActivity());
            this.f45064n0.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            z17 = true;
            this.f45064n0.setOrientation(1);
            this.f45064n0.setGravity(1);
            this.f45060j0.j0().addFooterView(this.f45064n0);
            FeedDetailCommentTips feedDetailCommentTips = new FeedDetailCommentTips(getActivity(), getHandler());
            this.f45061k0 = feedDetailCommentTips;
            feedDetailCommentTips.setLoadingDataText(getString(R.string.f170931b54));
            this.f45061k0.setLoadingMoreDataText(getString(R.string.f170932b55));
            if (!z16) {
                Ci(5);
            } else {
                this.f45065o0 = 3;
                Ci(3);
            }
            this.f45064n0.addView(this.f45061k0);
        }
        return z17;
    }

    protected boolean ri() {
        return false;
    }

    public void scrollToTop() {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.f45060j0;
        if (qZonePullToRefreshListView == null) {
            return;
        }
        if (qZonePullToRefreshListView.j0() == null || this.f45060j0.j0().getFirstVisiblePosition() != 0) {
            this.f45060j0.scrollToTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void si(long... jArr) {
        if (this.f45060j0 != null) {
            long j3 = (jArr == null || jArr.length <= 0) ? 0L : jArr[0];
            if (j3 == 0) {
                j3 = ki();
            }
            if (j3 == 0) {
                return;
            }
            this.f45060j0.setLastUpdateTimeStamp(String.format(getString(R.string.c0o), com.qzone.album.util.g.b(j3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ti() {
        if (!gi()) {
            if (ri()) {
                showNoNetworkTips();
            }
        } else if (xi()) {
            hi(2);
            ii();
        }
    }

    protected void ui() {
        if (!gi()) {
            if (ri()) {
                showNoNetworkTips();
            }
        } else if (yi()) {
            hi(3);
            ji();
        }
    }

    protected boolean vi(View view) {
        scrollToTop();
        return true;
    }

    protected void wi(View view) {
        scrollToTop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean xi() {
        FeedDetailCommentTips feedDetailCommentTips = this.f45061k0;
        if (feedDetailCommentTips == null) {
            return false;
        }
        return feedDetailCommentTips.h();
    }

    protected boolean yi() {
        FeedDetailCommentTips feedDetailCommentTips = this.f45062l0;
        if (feedDetailCommentTips == null) {
            return false;
        }
        return feedDetailCommentTips.h();
    }

    protected boolean zi() {
        return !Jh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Ci(int i3) {
        Di(i3, true);
    }

    protected final void Ei(int i3) {
        Fi(i3, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean pi() {
        return qi(false);
    }

    public void Ai(View view) {
        if (view != null) {
            new com.qzone.widget.c(view).d(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bi(int i3) {
        if (i3 <= 0) {
            i3 = this.f45070t0;
        }
        TextView textView = this.f45067q0;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.f45067q0.setText(i3);
        if (i3 != R.string.f170565u8) {
            this.f45069s0 = i3;
        }
    }

    protected void li(boolean z16) {
        if (z16) {
            return;
        }
        oi();
        Ci(this.f45065o0);
        Ei(this.f45066p0);
        fi();
    }

    public void Gi(int i3) {
        if (i3 > -1) {
            this.f45072v0 = i3;
        }
    }

    protected void ji() {
    }
}
