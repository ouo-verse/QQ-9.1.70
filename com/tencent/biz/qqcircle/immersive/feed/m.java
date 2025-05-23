package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSHotCommentSwitchChangeEvent;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSBottomGuideMuteView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedBottomRecommendView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedBottomShareGuideView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedFreeFlowView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedFriendCommentGuideView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedShareQQGroupView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.autoslideguide.QFSAutoSlideGuideView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSFeedBottomConfigGuideFollowView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class m extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements com.tencent.biz.qqcircle.immersive.views.banner.bottom.a {
    protected final List<com.tencent.biz.qqcircle.immersive.views.banner.bottom.b> I = new ArrayList();
    private IOrderElement J;
    private com.tencent.biz.qqcircle.immersive.views.banner.bottom.r K;

    private void g1() {
        com.tencent.biz.qqcircle.immersive.manager.e.a().reloadGroupActivate(getContextHashCode(), getGroup(), getGroupExtraKey());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.C0(hVar);
        Iterator<com.tencent.biz.qqcircle.immersive.views.banner.bottom.b> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().f(hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.a
    public void E(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        T0(hVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        if (QLog.isDevelopLevel()) {
            QLog.d(getTAG(), 4, "onAttachedToWindow, this: " + this);
        }
        Iterator<com.tencent.biz.qqcircle.immersive.views.banner.bottom.b> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().onAttachedToWindow();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        if (QLog.isDevelopLevel()) {
            QLog.d(getTAG(), 4, "onDetachedFromWindow, this: " + this);
        }
        Iterator<com.tencent.biz.qqcircle.immersive.views.banner.bottom.b> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().onDetachedFromWindow();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.w(this));
        this.I.add(new QFSFeedBottomShareGuideView(this));
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.f(this));
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.p(this));
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.o(this));
        this.I.add(new QFSFeedBottomConfigGuideFollowView(this));
        this.I.add(new QFSFeedFreeFlowView(this));
        this.I.add(new QFSAutoSlideGuideView(this));
        this.I.add(new QFSFeedBottomRecommendView(this));
        this.I.add(new o(this));
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.af(this));
        this.I.add(new QFSFeedShareQQGroupView(this));
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.g(this));
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.m(this));
        this.I.add(new QFSFeedBottomGuideFollowView(this));
        com.tencent.biz.qqcircle.immersive.views.banner.bottom.d dVar = new com.tencent.biz.qqcircle.immersive.views.banner.bottom.d(this);
        dVar.x(y0());
        this.I.add(dVar);
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.ab(this));
        this.I.add(new QFSFeedFriendCommentGuideView(this));
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.aa(this));
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.q(this));
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.ac(this));
        com.tencent.biz.qqcircle.immersive.views.banner.bottom.r rVar = new com.tencent.biz.qqcircle.immersive.views.banner.bottom.r(this);
        this.K = rVar;
        this.I.add(rVar);
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.ae(this));
        this.I.add(new QFSBottomGuideMuteView(this));
        this.I.add(new QFSFeedChildBottomDynamicGuideView(this));
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.ag(this));
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.t(this));
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.h(this));
        this.I.add(new t70.d(this));
        this.I.add(new com.tencent.biz.qqcircle.immersive.views.banner.bottom.j(this));
        com.tencent.biz.qqcircle.immersive.manager.e.a().sortElement(this.K);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.a
    public t40.a e() {
        return s0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.a
    public String getContextHashCode() {
        return v0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSHotCommentSwitchChangeEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.a
    public String getGroup() {
        return "feed_type_bottom_banner_group";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.a
    public String getGroupExtraKey() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.a
    public View getRootView() {
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        Iterator<com.tencent.biz.qqcircle.immersive.views.banner.bottom.b> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().h(this.E, i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        QLog.d(getTAG(), 1, "onDestroy, this: " + this);
        Iterator<com.tencent.biz.qqcircle.immersive.views.banner.bottom.b> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        String str;
        Iterator<com.tencent.biz.qqcircle.immersive.views.banner.bottom.b> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().i();
        }
        T t16 = this.f85017h;
        if (t16 != 0 && ((FeedCloudMeta$StFeed) t16).poster != null && ((FeedCloudMeta$StFeed) t16).poster.frdState.get() == 1 && com.tencent.biz.qqcircle.immersive.utils.r.r0(this.E)) {
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this.K, RFWOrderElementManager.OrderMode.FORCE_MODE);
        } else {
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(getContextHashCode(), getGroup());
        }
        this.J = com.tencent.biz.qqcircle.immersive.manager.e.a().getGroupActivatingElement(getContextHashCode(), getGroup());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onFeedSelected] selectInfo: ");
        sb5.append(rFWFeedSelectInfo);
        sb5.append(", mCurrentShowingElement = ");
        sb5.append(this.J);
        sb5.append(", feed id = ");
        T t17 = this.f85017h;
        if (t17 == 0) {
            str = "";
        } else {
            str = ((FeedCloudMeta$StFeed) t17).f398449id.get();
        }
        sb5.append(str);
        sb5.append(", getContextHashCode = ");
        sb5.append(getContextHashCode());
        QLog.d("QFSFeedChildBottomBannerPresenter", 1, sb5.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        String str;
        String str2 = "";
        if (rFWFeedSelectInfo != null && TextUtils.equals(rFWFeedSelectInfo.getSelectedTag(), rFWFeedSelectInfo.getUnSelectedTag())) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onFeedUnSelected] mSelectedTag == mUnSelectedTag, mCurrentShowingElement = ");
            sb5.append(this.J);
            sb5.append(", feed id = ");
            T t16 = this.f85017h;
            if (t16 == 0) {
                str = "";
            } else {
                str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
            }
            sb5.append(str);
            sb5.append(", getContextHashCode = ");
            sb5.append(getContextHashCode());
            sb5.append(", selectInfo = ");
            sb5.append(rFWFeedSelectInfo);
            QLog.d("QFSFeedChildBottomBannerPresenter", 1, sb5.toString());
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("[onFeedUnSelected] selectInfo: ");
        sb6.append(rFWFeedSelectInfo);
        sb6.append(", feed id = ");
        T t17 = this.f85017h;
        if (t17 != 0) {
            str2 = ((FeedCloudMeta$StFeed) t17).f398449id.get();
        }
        sb6.append(str2);
        QLog.d("QFSFeedChildBottomBannerPresenter", 1, sb6.toString());
        com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(getContextHashCode(), getGroup());
        Iterator<com.tencent.biz.qqcircle.immersive.views.banner.bottom.b> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.d(getTAG(), 1, "onPaused, this: " + this);
        Iterator<com.tencent.biz.qqcircle.immersive.views.banner.bottom.b> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().onPaused(rFWFeedSelectInfo);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSHotCommentSwitchChangeEvent) {
            g1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QLog.d(getTAG(), 1, "onResume, this: " + this);
        Iterator<com.tencent.biz.qqcircle.immersive.views.banner.bottom.b> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().e(rFWFeedSelectInfo);
        }
        onFeedSelected(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildBottomBannerPresenter";
    }
}
