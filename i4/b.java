package i4;

import android.os.Handler;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.ui.widget.QzoneGestureSelectListView;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.activities.base.QZoneTitleBarActivity;
import com.qzone.detail.ui.component.FeedDetailCommentTips;
import com.qzone.widget.c;
import com.tencent.mobileqq.R;
import com.tencent.widget.AbsListView;
import cooperation.qzone.util.QZLog;
import d5.g;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends i4.a {
    protected FeedDetailCommentTips C;
    protected FeedDetailCommentTips D;
    protected LinearLayout E;
    protected LinearLayout F;
    protected int G;
    protected int H;
    protected TextView I;
    protected ProgressBar J;
    public int K;
    public int L;
    protected boolean M;
    protected int N;

    /* renamed from: f, reason: collision with root package name */
    private final String f407175f;

    /* renamed from: h, reason: collision with root package name */
    public int f407176h;

    /* renamed from: i, reason: collision with root package name */
    protected BaseAdapter f407177i;

    /* renamed from: m, reason: collision with root package name */
    protected QzoneGestureSelectListView f407178m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements g {
        a() {
        }

        @Override // d5.g
        public boolean onClick(View view) {
            return b.this.p0(view);
        }

        @Override // d5.g
        public void onDoubleClick(View view) {
            b.this.q0(view);
        }
    }

    public b(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.f407175f = "CustomListViewController";
        this.G = 5;
        this.H = 5;
        this.L = R.string.gea;
        this.M = true;
        this.N = 500;
    }

    protected final void B0(int i3, boolean z16) {
        FeedDetailCommentTips feedDetailCommentTips;
        if (this.E == null || (feedDetailCommentTips = this.D) == null) {
            return;
        }
        feedDetailCommentTips.setState(i3);
        if (z16) {
            this.H = i3;
        }
        if (i3 == 3) {
            if (this.E.getVisibility() != 8) {
                this.E.setVisibility(8);
            }
        } else if (this.E.getVisibility() != 0) {
            this.E.setVisibility(0);
        }
    }

    public void C0(boolean z16) {
        this.M = z16;
    }

    @Override // i4.a
    public void L(boolean z16) {
        g0(z16);
        if (!z16) {
            x0(R.string.f170565u8);
            return;
        }
        BaseAdapter baseAdapter = this.f407177i;
        if (baseAdapter != null && baseAdapter.getCount() <= 0) {
            QzoneGestureSelectListView qzoneGestureSelectListView = this.f407178m;
            if (qzoneGestureSelectListView != null) {
                qzoneGestureSelectListView.setRefreshing(false);
                return;
            }
            return;
        }
        x0(this.K);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void X() {
        BaseAdapter baseAdapter = this.f407177i;
        if (baseAdapter == null || !baseAdapter.isEmpty()) {
            return;
        }
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "CustomListViewController\t checkHideFooter");
        y0(3);
    }

    protected boolean Y() {
        FragmentActivity fragmentActivity = this.f407174e;
        if (fragmentActivity == null || !(fragmentActivity instanceof BaseActivity)) {
            return false;
        }
        boolean checkNetworkConnect = ((BaseActivity) fragmentActivity).checkNetworkConnect();
        g0(checkNetworkConnect);
        return checkNetworkConnect;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Z(int i3) {
        String str;
        this.f407176h = i3;
        FragmentActivity fragmentActivity = this.f407174e;
        if (fragmentActivity == null || !(fragmentActivity instanceof QZoneTitleBarActivity)) {
            return;
        }
        QZoneTitleBarActivity qZoneTitleBarActivity = (QZoneTitleBarActivity) fragmentActivity;
        if (i3 == 1) {
            FeedDetailCommentTips feedDetailCommentTips = this.C;
            if (feedDetailCommentTips != null && feedDetailCommentTips.g()) {
                y0(this.G);
            }
            if (this.M) {
                qZoneTitleBarActivity.t();
            }
            str = "TYPE_REFRESH";
        } else if (i3 == 2) {
            if (qZoneTitleBarActivity.g3()) {
                i0();
            }
            this.G = this.C.e();
            z0(1, false);
            str = "TYPE_GET_MORE";
        } else if (i3 != 3) {
            str = "";
        } else {
            if (qZoneTitleBarActivity.g3()) {
                i0();
            }
            this.H = this.D.e();
            B0(1, false);
            str = "TYPE_LOAD_MORE_UP";
        }
        X();
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "CustomListViewController\t checkRefreshOrGetMoreState(), reqType: " + str + "\t footerPreState:" + this.G);
    }

    protected void a0() {
        throw null;
    }

    protected void c0() {
        throw null;
    }

    public View d0() {
        FeedDetailCommentTips feedDetailCommentTips = this.C;
        if (feedDetailCommentTips != null) {
            return feedDetailCommentTips.d();
        }
        return null;
    }

    public Handler e0() {
        throw null;
    }

    protected long f0() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h0() {
        ProgressBar progressBar = this.J;
        if (progressBar == null || progressBar.getVisibility() == 8) {
            return;
        }
        this.J.setVisibility(8);
    }

    protected void i0() {
        QzoneGestureSelectListView qzoneGestureSelectListView = this.f407178m;
        if (qzoneGestureSelectListView == null) {
            return;
        }
        qzoneGestureSelectListView.l0();
        FragmentActivity fragmentActivity = this.f407174e;
        if (fragmentActivity == null || !(fragmentActivity instanceof QZoneTitleBarActivity)) {
            return;
        }
        ((QZoneTitleBarActivity) fragmentActivity).y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j0(boolean z16) {
        boolean z17 = false;
        if (this.C != null) {
            return false;
        }
        QzoneGestureSelectListView qzoneGestureSelectListView = this.f407178m;
        if (qzoneGestureSelectListView != null && qzoneGestureSelectListView.j0() != null) {
            this.F = new LinearLayout(this.f407174e);
            this.F.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            z17 = true;
            this.F.setOrientation(1);
            this.F.setGravity(1);
            this.f407178m.j0().addFooterView(this.F);
            FeedDetailCommentTips feedDetailCommentTips = new FeedDetailCommentTips(this.f407174e, e0());
            this.C = feedDetailCommentTips;
            feedDetailCommentTips.setLoadingDataText(I(R.string.f170931b54));
            this.C.setLoadingMoreDataText(I(R.string.f170932b55));
            if (!z16) {
                y0(5);
            } else {
                this.G = 3;
                y0(3);
            }
            this.F.addView(this.C);
        }
        return z17;
    }

    protected boolean k0() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l0(long... jArr) {
        if (this.f407178m != null) {
            long j3 = (jArr == null || jArr.length <= 0) ? 0L : jArr[0];
            if (j3 == 0) {
                j3 = f0();
            }
            if (j3 == 0) {
                return;
            }
            this.f407178m.setLastUpdateTimeStamp(String.format(I(R.string.c0o), com.qzone.album.util.g.b(j3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m0() {
        FragmentActivity fragmentActivity;
        if (!Y()) {
            if (k0() && (fragmentActivity = this.f407174e) != null && (fragmentActivity instanceof BaseActivity)) {
                ((BaseActivity) fragmentActivity).showNoNetworkTips();
                return;
            }
            return;
        }
        if (r0()) {
            Z(2);
            a0();
        }
    }

    protected void n0() {
        FragmentActivity fragmentActivity;
        if (!Y()) {
            if (k0() && (fragmentActivity = this.f407174e) != null && (fragmentActivity instanceof BaseActivity)) {
                ((BaseActivity) fragmentActivity).showNoNetworkTips();
                return;
            }
            return;
        }
        if (s0()) {
            Z(3);
            b0();
        }
    }

    public final void o0() {
        FragmentActivity fragmentActivity;
        if (!Y()) {
            if (k0() && (fragmentActivity = this.f407174e) != null && (fragmentActivity instanceof BaseActivity)) {
                ((BaseActivity) fragmentActivity).showNoNetworkTips();
                return;
            }
            return;
        }
        e0().removeMessages(87);
        e0().sendEmptyMessageDelayed(87, this.N);
    }

    protected boolean p0(View view) {
        u0();
        return true;
    }

    protected void q0(View view) {
        u0();
    }

    protected boolean r0() {
        FeedDetailCommentTips feedDetailCommentTips = this.C;
        if (feedDetailCommentTips == null) {
            return false;
        }
        return feedDetailCommentTips.h();
    }

    protected boolean s0() {
        FeedDetailCommentTips feedDetailCommentTips = this.D;
        if (feedDetailCommentTips == null) {
            return false;
        }
        return feedDetailCommentTips.h();
    }

    protected boolean t0() {
        FragmentActivity fragmentActivity = this.f407174e;
        if (fragmentActivity == null || !(fragmentActivity instanceof QZoneTitleBarActivity)) {
            return false;
        }
        return !((QZoneTitleBarActivity) fragmentActivity).g3();
    }

    public void u0() {
        throw null;
    }

    public void v0(int i3) {
        View d06 = d0();
        if (d06 != null) {
            d06.setPadding(d06.getPaddingLeft(), d06.getPaddingTop(), d06.getPaddingRight(), i3);
        }
    }

    protected final void z0(int i3, boolean z16) {
        if (this.F == null || this.C == null) {
            return;
        }
        QZLog.i(QZLog.TO_DEVICE_TAG, "CustomListViewController setFooterState(), state: " + i3);
        this.C.setState(i3);
        if (z16) {
            this.G = i3;
        }
        if (i3 == 3) {
            if (this.F.getVisibility() != 8) {
                this.F.setVisibility(8);
            }
        } else if (this.F.getVisibility() != 0) {
            this.F.setVisibility(0);
        }
    }

    protected final void A0(int i3) {
        B0(i3, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void y0(int i3) {
        z0(i3, true);
    }

    protected void g0(boolean z16) {
        if (z16) {
            return;
        }
        i0();
        y0(this.G);
        A0(this.H);
        X();
    }

    public void w0(View view) {
        if (view != null) {
            new c(view).d(new a());
        }
    }

    protected void x0(int i3) {
        if (i3 <= 0) {
            i3 = this.L;
        }
        TextView textView = this.I;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.I.setText(i3);
        if (i3 != R.string.f170565u8) {
            this.K = i3;
        }
    }

    @Override // i4.a
    public void K(s sVar, int i3) {
        if (i3 == 87 && t0()) {
            Z(1);
            c0();
        }
        if (i3 == -10000) {
            m0();
        }
        if (i3 == -10001) {
            n0();
        }
    }

    protected void b0() {
    }
}
