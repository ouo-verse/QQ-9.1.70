package com.qzone.common.activities.base;

import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.common.activities.titlebuilder.a;
import com.qzone.detail.ui.component.FeedDetailCommentTips;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.mobileqq.R;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CustomListViewFragment<T extends com.qzone.common.activities.titlebuilder.a> extends QZoneTitleBarFragment {
    private static final String Z = BaseFragment.TAG + ".refresh";
    public int C;
    public BaseAdapter D;
    protected QZonePullToRefreshListView E;
    protected FeedDetailCommentTips F;
    protected FeedDetailCommentTips G;
    protected LinearLayout H;
    protected LinearLayout I;
    protected TextView P;
    public int Q;
    public T U;
    private com.qzone.feed.ui.activity.f V;
    private d5.f W;
    public d5.x X;
    protected int J = 5;
    protected int K = 5;
    private boolean L = false;
    private String M = "";
    private String N = "";
    public int R = R.string.gea;
    protected boolean S = true;
    protected int T = 500;
    protected boolean Y = false;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements d5.g {
        a() {
        }

        @Override // d5.g
        public boolean onClick(View view) {
            return CustomListViewFragment.this.Kh(view);
        }

        @Override // d5.g
        public void onDoubleClick(View view) {
            CustomListViewFragment.this.Lh(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements d5.g {
        b() {
        }

        @Override // d5.g
        public boolean onClick(View view) {
            return CustomListViewFragment.this.Kh(view);
        }

        @Override // d5.g
        public void onDoubleClick(View view) {
            CustomListViewFragment.this.Lh(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ah() {
        com.qzone.feed.ui.activity.f fVar = this.V;
        if (fVar != null) {
            fVar.y();
            return;
        }
        T t16 = this.U;
        if (t16 != null) {
            t16.y();
        }
    }

    protected void Bh() {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.E;
        if (qZonePullToRefreshListView == null) {
            return;
        }
        qZonePullToRefreshListView.l0();
        Ah();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Dh(boolean z16) {
        String string;
        boolean z17 = false;
        if (this.F != null) {
            return false;
        }
        QZonePullToRefreshListView qZonePullToRefreshListView = this.E;
        if (qZonePullToRefreshListView != null && qZonePullToRefreshListView.j0() != null && this.containerInf != null) {
            this.I = new LinearLayout(this.containerInf.getActivity());
            this.I.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            z17 = true;
            this.I.setOrientation(1);
            this.I.setGravity(1);
            this.E.j0().addFooterView(this.I);
            FeedDetailCommentTips feedDetailCommentTips = new FeedDetailCommentTips(this.containerInf.getActivity(), getHandler());
            this.F = feedDetailCommentTips;
            String str = "";
            if (this.containerInf == null) {
                string = "";
            } else {
                string = this.containerInf.getString(R.string.f170931b54);
            }
            feedDetailCommentTips.setLoadingDataText(string);
            FeedDetailCommentTips feedDetailCommentTips2 = this.F;
            if (this.containerInf != null) {
                str = this.containerInf.getString(R.string.f170932b55);
            }
            feedDetailCommentTips2.setLoadingMoreDataText(str);
            if (!z16) {
                Rh(5);
            } else {
                this.J = 3;
                Rh(3);
            }
            this.I.addView(this.F);
        }
        return z17;
    }

    protected boolean Eh() {
        com.qzone.feed.ui.activity.f fVar = this.V;
        if (fVar != null) {
            return fVar.isRefreshing();
        }
        T t16 = this.U;
        if (t16 != null) {
            return t16.isRefreshing();
        }
        return false;
    }

    protected boolean Fh() {
        return false;
    }

    protected boolean Gh() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Hh(long... jArr) {
        String string;
        if (this.E != null) {
            long j3 = (jArr == null || jArr.length <= 0) ? 0L : jArr[0];
            if (j3 == 0) {
                j3 = yh();
            }
            if (j3 == 0) {
                return;
            }
            QZonePullToRefreshListView qZonePullToRefreshListView = this.E;
            String str = "";
            if (this.containerInf == null) {
                string = "";
            } else {
                string = this.containerInf.getString(R.string.c0o);
            }
            Object[] objArr = new Object[1];
            d5.f fVar = this.W;
            if (fVar != null) {
                str = fVar.a(j3);
            }
            objArr[0] = str;
            qZonePullToRefreshListView.setLastUpdateTimeStamp(String.format(string, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ih() {
        if (!th()) {
            if (Gh()) {
                showNoNetworkTips();
            }
        } else {
            if (!Mh() || Eh()) {
                return;
            }
            QZLog.d(BaseFragment.TAG, 2, "do get more step");
            uh(2);
            vh();
        }
    }

    protected void Jh() {
        if (!th()) {
            if (Gh()) {
                showNoNetworkTips();
            }
        } else if (Nh()) {
            uh(3);
            wh();
        }
    }

    protected boolean Kh(View view) {
        scrollToTop();
        return true;
    }

    protected void Lh(View view) {
        scrollToTop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Mh() {
        FeedDetailCommentTips feedDetailCommentTips = this.F;
        if (feedDetailCommentTips == null) {
            return false;
        }
        return feedDetailCommentTips.h();
    }

    protected boolean Nh() {
        FeedDetailCommentTips feedDetailCommentTips = this.G;
        if (feedDetailCommentTips == null) {
            return false;
        }
        return feedDetailCommentTips.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Oh() {
        return !Eh();
    }

    protected final void Sh(int i3, boolean z16) {
        FeedDetailCommentTips feedDetailCommentTips;
        if (this.I == null || (feedDetailCommentTips = this.F) == null) {
            return;
        }
        feedDetailCommentTips.setNoMoreDataVisibility(this.L);
        String str = this.M;
        if (str != null && !str.equals("")) {
            this.F.setLoadingMoreDataText(this.M);
        }
        String str2 = this.N;
        if (str2 != null && !str2.equals("")) {
            this.F.setNoMoreDataText(this.N);
        }
        this.F.setState(i3);
        if (z16) {
            this.J = i3;
        }
        if (i3 == 3) {
            if (this.I.getVisibility() != 8) {
                this.I.setVisibility(8);
            }
        } else if (this.I.getVisibility() != 0) {
            this.I.setVisibility(0);
        }
    }

    protected final void Uh(int i3, boolean z16) {
        FeedDetailCommentTips feedDetailCommentTips;
        if (this.H == null || (feedDetailCommentTips = this.G) == null) {
            return;
        }
        feedDetailCommentTips.setState(i3);
        if (z16) {
            this.K = i3;
        }
        if (i3 == 3) {
            if (this.H.getVisibility() != 8) {
                this.H.setVisibility(8);
            }
        } else if (this.H.getVisibility() != 0) {
            this.H.setVisibility(0);
        }
    }

    public void Vh(T t16) {
        this.U = t16;
    }

    protected void Wh() {
        com.qzone.feed.ui.activity.f fVar = this.V;
        if (fVar != null) {
            fVar.t();
            return;
        }
        T t16 = this.U;
        if (t16 != null) {
            t16.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c0() {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, BaseFragment.TAG + "\t doRefresh()");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        T t16 = this.U;
        if (t16 != null) {
            t16.G6(new b());
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        T t16 = this.U;
        if (t16 != null) {
            t16.G6(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (message == null) {
            return;
        }
        if (message.what == 87) {
            if (Oh()) {
                uh(1);
                c0();
            } else {
                QZLog.w(Z, "preRefresh()=true \u6b63\u5728\u8f6c\u83ca\u82b1\uff0c\u8bf4\u660e\u6b63\u5728\u8bf7\u6c42\u5237\u65b0\uff0c\u6b64\u6b21\u8bf7\u554a\u5ffd\u7565");
            }
        }
        if (message.what == -10000) {
            Ih();
        }
        if (message.what == -10001) {
            Jh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onNetStateChanged(boolean z16) {
        super.onNetStateChanged(z16);
        zh(z16);
        if (!z16) {
            Qh(R.string.f170565u8);
            return;
        }
        BaseAdapter baseAdapter = this.D;
        if (baseAdapter != null && baseAdapter.getCount() <= 0) {
            QZonePullToRefreshListView qZonePullToRefreshListView = this.E;
            if (qZonePullToRefreshListView != null) {
                qZonePullToRefreshListView.setRefreshing(false);
                return;
            }
            return;
        }
        Qh(this.Q);
    }

    public final void onRefresh() {
        if (!th()) {
            if (Gh()) {
                showNoNetworkTips();
            }
            QZLog.e(BaseFragment.TAG, 1, "[onRefresh] no network");
        } else {
            if (getHandler().hasMessages(87)) {
                QZLog.w(Z, "\u6b63\u5728\u5904\u7406\u5237\u65b0\u8bf7\u6c42\uff0c\u6b64\u6b21\u8bf7\u6c42\u5ffd\u7565");
                return;
            }
            QZLog.i(BaseFragment.TAG, 1, "[onRefresh] onRefresh hashCode = " + hashCode());
            getHandler().sendEmptyMessage(87);
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (QZLog.isColorLevel()) {
            String str = BaseFragment.TAG;
            QZLog.d(str, 2, "support:" + ImmersiveUtils.isSupporImmersive() + " sdk:" + Build.VERSION.SDK_INT);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("FEATURE_NO_TITLE:");
            sb5.append(getWindow().hasFeature(1));
            QZLog.d(str, 2, sb5.toString());
        }
        if (this.X != null && this.containerInf != null) {
            this.X.a(this.containerInf.getActivity());
        }
        T t16 = this.U;
        if (t16 != null) {
            t16.E1(R.color.skin_color_title_immersive_bar, R.drawable.qq_title_immersive_bar, Fh());
        }
    }

    public void scrollToTop() {
        QZonePullToRefreshListView qZonePullToRefreshListView = this.E;
        if (qZonePullToRefreshListView == null) {
            return;
        }
        if (qZonePullToRefreshListView.j0() == null || this.E.j0().getFirstVisiblePosition() != 0) {
            this.E.scrollToTop();
        }
    }

    @Inject
    @Named("CustomListViewFragmentDateImp")
    public void setDateInf(d5.f fVar) {
        this.W = fVar;
    }

    @Inject
    @Named("CustomListViewFragmentPublishQueueImp")
    public void setPublishQueueInf(d5.x xVar) {
        this.X = xVar;
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void setTitle(CharSequence charSequence) {
        T t16 = this.U;
        if (t16 != null) {
            t16.setTitle(charSequence);
        } else {
            super.setTitle(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void sh() {
        BaseAdapter baseAdapter = this.D;
        if (baseAdapter == null || !baseAdapter.isEmpty()) {
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d(QZLog.TO_DEVICE_TAG, 1, BaseFragment.TAG + "\t checkHideFooter");
        }
        Rh(3);
    }

    protected boolean th() {
        boolean checkNetworkConnect = super.checkNetworkConnect();
        zh(checkNetworkConnect);
        return checkNetworkConnect;
    }

    protected final void uh(int i3) {
        this.C = i3;
        if (i3 == 1) {
            FeedDetailCommentTips feedDetailCommentTips = this.F;
            if (feedDetailCommentTips != null && feedDetailCommentTips.g()) {
                Rh(this.J);
            }
            if (this.S) {
                Wh();
            }
        } else if (i3 == 2) {
            if (Eh()) {
                Bh();
            }
            this.J = this.F.e();
            Sh(1, false);
        } else if (i3 == 3) {
            if (Eh()) {
                Bh();
            }
            this.K = this.G.e();
            Uh(1, false);
        }
        sh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vh() {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, BaseFragment.TAG + "\t doGetMore()");
    }

    public T xh() {
        return this.U;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long yh() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ch() {
        return Dh(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Rh(int i3) {
        Sh(i3, true);
    }

    protected final void Th(int i3) {
        Uh(i3, true);
    }

    protected void Qh(int i3) {
        if (i3 <= 0) {
            i3 = this.R;
        }
        TextView textView = this.P;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.P.setText(i3);
        if (i3 != R.string.f170565u8) {
            this.Q = i3;
        }
    }

    protected void zh(boolean z16) {
        if (z16) {
            return;
        }
        Bh();
        Rh(this.J);
        Th(this.K);
        sh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ph() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wh() {
    }
}
