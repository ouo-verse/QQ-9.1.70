package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QFSVideoOnPlayEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class at extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements j30.a {
    private j30.d I;

    private void g1(String str) {
        QLog.d(getTAG(), 1, str, " mViewType=", Integer.valueOf(this.f85015e), ",feedId=", h1(), ",pos=", Integer.valueOf(this.f85018i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String h1() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    private void i1(QFSVideoOnPlayEvent qFSVideoOnPlayEvent) {
        String feedId = qFSVideoOnPlayEvent.getFeedId();
        int playHashCode = qFSVideoOnPlayEvent.getPlayHashCode();
        String h16 = h1();
        int hashCode = hashCode();
        if (TextUtils.equals(h16, feedId) && playHashCode == hashCode) {
            g1("handleOnReceivePlay return");
            return;
        }
        j30.d dVar = this.I;
        if (dVar != null) {
            dVar.b();
        }
        g1("handleOnReceivePlay");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        j30.d b16 = j30.f.b(this.f85015e);
        this.I = b16;
        if (b16 != null) {
            View d16 = b16.d(view, this);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(d16);
            }
        }
        g1("onInitView");
    }

    @Override // j30.a
    public int c() {
        return m0().getResources().getDimensionPixelSize(R.dimen.d3b);
    }

    @Override // j30.a
    public void d(String str) {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(str, 3));
        g1("deleteFeed feedId=" + str);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSVideoOnPlayEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            g1("onBindData data invalid:");
            return;
        }
        j30.d dVar = this.I;
        if (dVar != null) {
            dVar.a(feedCloudMeta$StFeed, i3);
        }
        g1("onBindData");
    }

    @Override // j30.a
    public void m() {
        if (this.f85017h == 0) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSVideoOnPlayEvent(h1(), hashCode()));
        g1("notifyPlayAudioOrVideo");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        j30.d dVar = this.I;
        if (dVar != null) {
            dVar.onDestroy();
        }
        g1(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        j30.d dVar = this.I;
        if (dVar != null) {
            dVar.onItemSelected(rFWFeedSelectInfo.getPosition());
        }
        g1("onFeedSelected");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        j30.d dVar = this.I;
        if (dVar != null) {
            dVar.e(rFWFeedSelectInfo.getPosition());
        }
        g1("onFeedUnSelected");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        j30.d dVar = this.I;
        if (dVar != null) {
            dVar.onPaused();
        }
        g1("onPaused");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSVideoOnPlayEvent) {
            i1((QFSVideoOnPlayEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        j30.d dVar = this.I;
        if (dVar != null) {
            dVar.c();
        }
        g1("onResumed");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onStop(rFWFeedSelectInfo);
        j30.d dVar = this.I;
        if (dVar != null) {
            dVar.onStop();
        }
        g1(DKHippyEvent.EVENT_STOP);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewHolderAttachedToWindow(viewHolder);
        j30.d dVar = this.I;
        if (dVar != null) {
            dVar.C(viewHolder);
        }
        g1("onViewHolderAttachedToWindow");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewHolderDetachedFromWindow(viewHolder);
        j30.d dVar = this.I;
        if (dVar != null) {
            dVar.a0(viewHolder);
        }
        g1("onViewHolderDetachedFromWindow");
    }

    @Override // j30.a
    public void s(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setFeed(feedCloudMeta$StFeed);
        qCircleInitBean.setUser(feedCloudMeta$StFeed.poster.get());
        qCircleInitBean.setFromReportBean(getReportBean().m466clone());
        com.tencent.biz.qqcircle.launcher.c.d0(m0(), qCircleInitBean);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        if (this.I == null) {
            return "QFSFeedChildOuterInjectItemViewPresenter_";
        }
        return "QFSFeedChildOuterInjectItemViewPresenter_" + this.I.getLogTag();
    }
}
