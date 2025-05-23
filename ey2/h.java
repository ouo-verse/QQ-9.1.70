package ey2;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeClickEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeExpandFullScreenEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import tvideo.EpisodeListStyle;
import tvideo.VideoPlot;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h extends k {

    /* renamed from: c0, reason: collision with root package name */
    private static final int f397394c0 = cx.a(20.0f);

    /* renamed from: d0, reason: collision with root package name */
    private static final int f397395d0 = cx.a(15.0f);

    /* renamed from: e0, reason: collision with root package name */
    private static final int f397396e0 = cx.a(80.0f);

    /* renamed from: b0, reason: collision with root package name */
    private final int f397397b0 = cx.a(16.0f);

    private void E1(@NonNull Rect rect, int i3) {
        if (i3 % 8 != 0) {
            rect.left = this.f397397b0;
        }
        if (i3 >= 8) {
            rect.top = f397394c0;
        }
    }

    private void G1(@NonNull Rect rect, int i3) {
        if (i3 > 0) {
            rect.top = f397395d0;
        }
    }

    private boolean R1() {
        if (2 == m0().getResources().getConfiguration().orientation) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoEpisodeExpandFullScreenEvent(false));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoEpisodeExpandFullScreenEvent(false));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // ey2.k, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: A1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
    }

    @Override // ey2.k
    protected void F1(@NonNull Rect rect, int i3) {
        if (J() == EpisodeListStyle.EpisodeListStyleLongStrip.getValue()) {
            G1(rect, i3);
        } else {
            E1(rect, i3);
        }
    }

    @Override // ey2.k, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        QLog.d("QFSTVideoEpisodeExpandFullScreenPresenter", 1, this + " onDetachedFromWindow");
    }

    @Override // ey2.k
    protected void M1() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.I.getLayoutParams();
        if (J() == EpisodeListStyle.EpisodeListStyleLongStrip.getValue()) {
            layoutParams.width = -1;
            layoutParams.gravity = 3;
            int i3 = f397396e0;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i3;
        } else {
            layoutParams.width = -2;
            layoutParams.gravity = 1;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
        this.I.setLayoutParams(layoutParams);
    }

    @Override // ey2.k, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
    }

    @Override // ey2.k, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList getEventClass() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QFSTVideoEpisodeExpandFullScreenEvent.class);
        return arrayList;
    }

    @Override // ey2.k, ey2.n.a
    public void k(VideoPlot videoPlot) {
        QFSTVideoEpisodeClickEvent qFSTVideoEpisodeClickEvent = new QFSTVideoEpisodeClickEvent();
        qFSTVideoEpisodeClickEvent.setPos(this.f85018i);
        qFSTVideoEpisodeClickEvent.setVideoPlot(videoPlot);
        qFSTVideoEpisodeClickEvent.setVideoFeed(this.K);
        qFSTVideoEpisodeClickEvent.setVideoPlotDetails(this.J);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoEpisodeClickEvent);
        SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoEpisodeExpandFullScreenEvent(false));
    }

    @Override // ey2.k
    protected int m1() {
        return R.id.f45541s6;
    }

    @Override // ey2.k
    protected RecyclerView.LayoutManager n1() {
        if (J() == EpisodeListStyle.EpisodeListStyleLongStrip.getValue()) {
            return new LinearLayoutManager(m0(), 1, false);
        }
        return new GridLayoutManager(m0(), 8);
    }

    @Override // ey2.k, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (E0() && (simpleBaseEvent instanceof QFSTVideoEpisodeExpandFullScreenEvent)) {
            K1(((QFSTVideoEpisodeExpandFullScreenEvent) simpleBaseEvent).isExpand());
            if (R1()) {
                cy2.b.e().u();
            }
        }
    }

    @Override // ey2.k, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewHolderDetachedFromWindow(viewHolder);
        QLog.d("QFSTVideoEpisodeExpandFullScreenPresenter", 1, this + " onViewHolderDetachedFromWindow");
    }

    @Override // ey2.k
    protected void s1() {
        n nVar = new n(this.K, true, this);
        this.L = nVar;
        this.I.setAdapter(nVar);
    }

    @Override // ey2.k
    protected void u1() {
        this.f85016f.setOnClickListener(new View.OnClickListener() { // from class: ey2.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.S1(view);
            }
        });
        ((ImageView) this.f85016f.findViewById(R.id.az7)).setOnClickListener(new View.OnClickListener() { // from class: ey2.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.y1(view);
            }
        });
    }

    @Override // ey2.k, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoEpisodeExpandFullScreenPresenter";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ey2.k
    public void w1() {
        super.w1();
    }
}
