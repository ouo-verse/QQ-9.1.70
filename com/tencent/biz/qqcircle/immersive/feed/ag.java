package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.events.QFSFullScreenAlbumModeChangeEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ag extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private TextView I;
    private Runnable J;
    private View K;
    private ImageView L;
    private View M;
    private TextView N;
    private String P;
    private int Q;

    /* JADX WARN: Multi-variable type inference failed */
    private void h1(View view, String str) {
        VideoReport.setElementId(view, str);
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, com.tencent.biz.qqcircle.immersive.utils.ab.b((FeedCloudMeta$StFeed) this.f85017h));
        hashMap.put("xsj_feed_id", com.tencent.biz.qqcircle.utils.bj.g((FeedCloudMeta$StFeed) this.f85017h));
        VideoReport.setElementParams(view, hashMap);
    }

    private void i1(boolean z16) {
        ViewGroup.LayoutParams layoutParams;
        float dimension;
        View view = this.K;
        if (view == null) {
            layoutParams = null;
        } else {
            layoutParams = view.getLayoutParams();
        }
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            return;
        }
        if (z16) {
            dimension = m0().getResources().getDimension(R.dimen.d2h);
        } else {
            dimension = m0().getResources().getDimension(R.dimen.d2i);
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int dimension2 = (int) m0().getResources().getDimension(R.dimen.d2j);
        int i3 = this.Q;
        layoutParams2.setMargins(dimension2 + i3, 0, i3, (int) dimension);
        View view2 = this.K;
        if (view2 != null) {
            view2.setLayoutParams(layoutParams2);
        }
    }

    private void j1(@NonNull com.tencent.biz.qqcircle.immersive.feed.event.j jVar) {
        if (jVar.a()) {
            p1(this.K, false);
        } else {
            i1(jVar.b());
        }
    }

    private void k1(com.tencent.biz.qqcircle.immersive.feed.event.x xVar) {
        this.Q = xVar.a();
    }

    private void l1(@NonNull com.tencent.biz.qqcircle.immersive.feed.event.y yVar) {
        if (TextUtils.isEmpty(yVar.b())) {
            QLog.e("QFSFeedChildFullScreenPlayPromptPresenter", 1, "[handlerPromptMsg] current prompt msg should not be null.");
            return;
        }
        this.P = yVar.a();
        q1(yVar.d());
        o1(yVar.b());
        p1(this.K, true);
        if (yVar.c() > 0) {
            if (this.J != null) {
                RFWThreadManager.getUIHandler().removeCallbacks(this.J);
            }
            this.J = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.af
                @Override // java.lang.Runnable
                public final void run() {
                    ag.this.n1();
                }
            };
            RFWThreadManager.getUIHandler().postDelayed(this.J, yVar.c());
        }
    }

    private void m1() {
        QLog.d("QFSFeedChildFullScreenPlayPromptPresenter", 1, "[handlerScreenPromptCancel] handler screen prompt cancel...");
        QCircleToast.o(m0().getResources().getString(R.string.f1907342w), 0);
        SimpleEventBus.getInstance().dispatchEvent(new QFSFullScreenAlbumModeChangeEvent(false, this.P));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n1() {
        p1(this.K, false);
    }

    private void o1(String str) {
        TextView textView = this.I;
        if (textView == null) {
            QLog.e("QFSFeedChildFullScreenPlayPromptPresenter", 1, "[setPromptText] current play prompt text view should not be null.");
        } else {
            textView.setText(str);
        }
    }

    private void q1(int i3) {
        if (i3 == 3) {
            p1(this.L, true);
            p1(this.M, true);
            p1(this.N, true);
            h1(this.K, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_TIP);
            h1(this.N, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_TIP_NEGATIVE_FEEDBACK);
            return;
        }
        p1(this.L, false);
        p1(this.M, false);
        p1(this.N, false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.y) {
            l1((com.tencent.biz.qqcircle.immersive.feed.event.y) hVar);
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.j) {
            j1((com.tencent.biz.qqcircle.immersive.feed.event.j) hVar);
        } else if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.x) {
            k1((com.tencent.biz.qqcircle.immersive.feed.event.x) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.K = view.findViewById(R.id.f42621k_);
        this.I = (TextView) view.findViewById(R.id.f42611k9);
        this.L = (ImageView) view.findViewById(R.id.f42351jj);
        this.M = view.findViewById(R.id.f42681kf);
        TextView textView = (TextView) view.findViewById(R.id.f42671ke);
        this.N = textView;
        textView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f42671ke) {
            m1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        o1("");
        p1(this.K, false);
        if (this.J != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.J);
        }
        i1(false);
    }

    public void p1(View view, boolean z16) {
        int i3;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildFullScreenPlayPromptPresenter";
    }
}
