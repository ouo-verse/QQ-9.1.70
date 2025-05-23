package com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QFSVideoOnPlayEvent;
import com.tencent.biz.qqcircle.immersive.utils.ac;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.event.QFSSearchVideoSelectFeedEvent;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.view.QFSSearchBaseCardItemView;
import com.tencent.biz.qqcircle.immersive.views.search.event.QFSSearchCheckPlayEvent;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e80.c;
import e80.g;
import e80.j;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import k80.b;
import k80.d;
import qqcircle.QQCircleFeedBase$StReportInfoForClient;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSSearchBaseCardItemView extends QFSSearchBaseWidgetView<FeedCloudMeta$StFeed> implements g, SimpleEventReceiver, c {
    private static final int G = QCircleApplication.getAPP().getResources().getDimensionPixelSize(R.dimen.d4x);
    private RoundCorneredFrameLayout C;
    protected FeedCloudMeta$StFeed D;
    private int E;
    private final int F;

    /* renamed from: e, reason: collision with root package name */
    private j<FeedCloudMeta$StFeed> f91075e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private k80.g f91076f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private b f91077h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private k80.c f91078i;

    /* renamed from: m, reason: collision with root package name */
    protected d f91079m;

    public QFSSearchBaseCardItemView(@NonNull Context context, int i3) {
        super(context);
        this.F = i3;
        x0(this);
        setPadding(G, 0, 0, 0);
    }

    private void C0(QFSVideoOnPlayEvent qFSVideoOnPlayEvent) {
        d dVar;
        if (this.D != null && (dVar = this.f91079m) != null) {
            dVar.v1(false);
            if (this.D.f398449id.get().equals(qFSVideoOnPlayEvent.getFeedId()) && qFSVideoOnPlayEvent.getPlayHashCode() == hashCode()) {
                return;
            }
            this.f91075e.stop();
            this.f91079m.l1();
        }
    }

    private void l0() {
        float f16;
        Size o06 = o0();
        int j3 = bz.j();
        if (j3 > 0) {
            f16 = j3 / o06.getWidth();
        } else {
            f16 = 1.5f;
        }
        DisplayUtil.adjustViewSize(new DisplayUtil.AdjustViewSizeParams().setView(this.C).setLayoutParams(this.C.getLayoutParams()).setDefaultWidth(o06.getWidth()).setDefaultHeight(o06.getHeight()).setTargetWidth(j3).setMaxCardWidthScale(f16));
    }

    private int p0() {
        if (p.y(this.D)) {
            return 4;
        }
        return this.D.type.get();
    }

    private b q0() {
        if (this.f91077h == null) {
            b z06 = z0();
            this.f91077h = z06;
            z06.N0(this);
        }
        return this.f91077h;
    }

    private k80.c r0() {
        if (this.f91078i == null) {
            k80.c A0 = A0();
            this.f91078i = A0;
            A0.N0(this);
        }
        return this.f91078i;
    }

    private int s0() {
        d dVar = this.f91079m;
        if (dVar != null && dVar.n1()) {
            return 0;
        }
        return 1;
    }

    private k80.g v0() {
        if (this.f91076f == null) {
            k80.g B0 = B0();
            this.f91076f = B0;
            B0.N0(this);
        }
        return this.f91076f;
    }

    private void w0(int i3) {
        d dVar = this.f91079m;
        if (dVar != null) {
            this.f91075e.d(dVar);
            this.f91079m.k1();
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    this.f91079m = null;
                    QLog.w("QFSSearchBaseCardItemView", 1, "#initPresenter: unknown type: " + i3 + ", id=" + this.D.f398449id.get() + ", content=" + ac.f90062a.a(this.D.content.get()));
                } else {
                    this.f91079m = r0();
                }
            } else {
                this.f91079m = v0();
            }
        } else {
            this.f91079m = q0();
        }
        d dVar2 = this.f91079m;
        if (dVar2 != null) {
            this.f91075e.c(dVar2);
        }
        this.f91075e.i(getQCircleExtraTypeInfo());
    }

    private void x0(View view) {
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) view.findViewById(R.id.f516528o);
        this.C = roundCorneredFrameLayout;
        roundCorneredFrameLayout.setRadius(cx.a(8.0f));
        j<FeedCloudMeta$StFeed> jVar = new j<>();
        this.f91075e = jVar;
        jVar.k(this.mParentView);
        n0(this.f91075e);
        this.f91075e.h(view);
        this.C.setTouchIntercept(new RoundCorneredFrameLayout.a() { // from class: m80.a
            @Override // com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout.a
            public final boolean a(MotionEvent motionEvent) {
                boolean y06;
                y06 = QFSSearchBaseCardItemView.this.y0(motionEvent);
                return y06;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean y0(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1 || !cx.i(this.C, true, false)) {
            return false;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSSearchVideoSelectFeedEvent(this.E, this.F));
        return true;
    }

    protected k80.c A0() {
        return new k80.c();
    }

    @NonNull
    protected abstract k80.g B0();

    protected void D0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_index", Integer.valueOf(i3));
        hashMap.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_NAME, feedCloudMeta$StFeed.poster.nick.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_MUTE, Integer.valueOf(s0()));
        hashMap.put("xsj_eid", u0());
        hashMap.put("eid", u0());
        if (p.y(this.D)) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_SEARCH_CONTENT_TYPE, "1");
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_SEARCH_LIVE_ROOM_ID, p.i(this.D, "live_roomid"));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_SEARCH_LIVE_STATUS, String.valueOf(p.j(this.D)));
        } else {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_HOT_SEARCH_CONTENT_TYPE, "0");
        }
        if (feedCloudMeta$StFeed.type.get() == 2 && feedCloudMeta$StFeed.images.has()) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_TYPE, 2);
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_PIC_NUM, Integer.valueOf(feedCloudMeta$StFeed.images.size()));
        }
        QQCircleFeedBase$StReportInfoForClient qQCircleFeedBase$StReportInfoForClient = new QQCircleFeedBase$StReportInfoForClient();
        try {
            qQCircleFeedBase$StReportInfoForClient.mergeFrom(feedCloudMeta$StFeed.reportInfoForClient.get().toByteArray());
            if (!TextUtils.isEmpty(qQCircleFeedBase$StReportInfoForClient.datongJsonData.get())) {
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, qQCircleFeedBase$StReportInfoForClient.datongJsonData.get());
            }
        } catch (InvalidProtocolBufferMicroException unused) {
            QLog.w("QFSSearchBaseCardItemView", 1, "[rankItemDtReport] InvalidProtocolBufferMicroException");
        }
        i.k(this, u0(), hashMap, feedCloudMeta$StFeed.hashCode());
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        this.f91075e.a();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSVideoOnPlayEvent.class);
        arrayList.add(QCircleConfigChangeEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchBaseCardItemView";
    }

    @Override // e80.g
    public boolean isPlaying() {
        return this.f91075e.isPlaying();
    }

    @Override // e80.c
    public boolean l() {
        d dVar = this.f91079m;
        if (dVar != null && dVar.l()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (i3 == 0) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSSearchCheckPlayEvent());
        }
        if (this.D == feedCloudMeta$StFeed) {
            l0();
            return;
        }
        if (isPlaying()) {
            this.f91075e.e0();
        }
        this.D = feedCloudMeta$StFeed;
        this.E = i3;
        w0(p0());
        this.f91075e.f(feedCloudMeta$StFeed, i3);
        l0();
        D0(feedCloudMeta$StFeed, i3);
    }

    protected Size o0() {
        return ad.g(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f91075e.e();
        l0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.f91075e.g();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSVideoOnPlayEvent) {
            C0((QFSVideoOnPlayEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            l0();
        }
    }

    @Override // e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        this.f91075e.pause();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        this.f91075e.play();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void setExtraTypeInfo(Serializable serializable) {
        super.setExtraTypeInfo(serializable);
        this.f91075e.i(getQCircleExtraTypeInfo());
    }

    public void setMaxItemCount(int i3) {
        k80.c cVar = this.f91078i;
        if (cVar != null) {
            cVar.Q1(i3);
        }
    }

    @Override // e80.g
    public void stop() {
        this.f91075e.stop();
    }

    protected abstract String u0();

    @NonNull
    protected abstract b z0();

    protected void n0(j<FeedCloudMeta$StFeed> jVar) {
    }
}
