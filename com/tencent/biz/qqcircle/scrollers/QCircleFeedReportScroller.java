package com.tencent.biz.qqcircle.scrollers;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.gallery.itemview.QFSGalleryWaterfallFeedItemView;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedAlignBaseItemView;
import com.tencent.biz.qqcircle.utils.q;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleWaterfallFeedItemView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k30.e;
import ua0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleFeedReportScroller extends com.tencent.biz.qqcircle.scrollers.a {
    private final QCircleReportBean G;
    private final int L;
    private final HashMap<Integer, a> H = new HashMap<>();
    private final HashMap<Integer, a> I = new HashMap<>();
    private final HashMap<Integer, a> J = new HashMap<>();
    private final ArrayList<b> K = new ArrayList<>();
    private boolean M = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private View f92273a;

        /* renamed from: b, reason: collision with root package name */
        private long f92274b;

        /* renamed from: c, reason: collision with root package name */
        private long f92275c;

        /* renamed from: d, reason: collision with root package name */
        private long f92276d;

        /* renamed from: e, reason: collision with root package name */
        private int f92277e;

        /* renamed from: f, reason: collision with root package name */
        private FeedCloudMeta$StFeed f92278f;

        public long c() {
            return this.f92275c;
        }

        public FeedCloudMeta$StFeed d() {
            return this.f92278f;
        }

        public View e() {
            return this.f92273a;
        }

        public int f() {
            return this.f92277e;
        }

        public long g() {
            return this.f92274b;
        }

        public long h() {
            return this.f92276d;
        }

        public void i(long j3) {
            this.f92275c = j3;
            this.f92276d = j3 - this.f92274b;
        }

        public void j(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f92278f = feedCloudMeta$StFeed;
        }

        public void k(View view) {
            this.f92273a = view;
        }

        public void l(int i3) {
            this.f92277e = i3;
        }

        public void m() {
            this.f92274b = System.currentTimeMillis();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a(RecyclerView recyclerView, int i3, int i16, boolean z16);

        void onPause();

        void onResume();
    }

    public QCircleFeedReportScroller(int i3, QCircleReportBean qCircleReportBean) {
        this.L = i3;
        this.G = qCircleReportBean;
    }

    private void E(RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setTag(R.id.f166942ja3, Boolean.FALSE);
        QCircleBaseWidgetView qCircleBaseWidgetView = (QCircleBaseWidgetView) viewHolder.itemView;
        FeedCloudMeta$StFeed Q = Q(qCircleBaseWidgetView);
        int P = P(qCircleBaseWidgetView);
        if (Q != null) {
            a aVar = new a();
            aVar.k(qCircleBaseWidgetView);
            aVar.l(P);
            aVar.j(Q);
            this.I.put(Integer.valueOf(P), aVar);
            QLog.d("QCircleFeedReportHelper", 4, "add baseExposePool from attach,index:" + P + ",feedId:" + Q.f398449id.get() + ",pageId:" + this.L);
        }
    }

    private void G(View view) {
        FeedCloudMeta$StFeed Q = Q(view);
        if (Q == null) {
            return;
        }
        int P = P(view);
        String str = Q.f398449id.get();
        if (!this.H.containsKey(Integer.valueOf(P))) {
            a aVar = new a();
            aVar.m();
            aVar.k(view);
            aVar.l(P);
            aVar.j(Q);
            this.H.put(Integer.valueOf(P), aVar);
            QLog.d("QCircleFeedReportHelper", 4, "record feed stay event from idle,index:" + P + ",feedId:" + str + ",pageId:" + this.L);
        }
    }

    private void H(final View view, final String str, final boolean z16) {
        if (!S(view)) {
            return;
        }
        if (z16 && !J(view)) {
            return;
        }
        final FeedCloudMeta$StFeed Q = Q(view);
        final int P = P(view);
        if (Q == null) {
            QLog.e("QCircleFeedReportHelper", 1, "asyncReportFeedExpose no feed data!from " + str + ",index:" + P + ",pageId:" + this.L);
            return;
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller.1
            @Override // java.lang.Runnable
            public void run() {
                if (z16) {
                    Map O = QCircleFeedReportScroller.this.O((QCircleBaseWidgetView) view);
                    O.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                    VideoReport.reportEvent(QCircleDaTongConstant.EventId.XSJ_FEED_IMPL, view, O);
                }
                QCircleFeedReportScroller.this.V(Q, P, z16);
                QLog.d("QCircleFeedReportHelper", 4, "report expose from " + str + ",isValid:" + z16 + ",index:" + P + ",feedId:" + Q.f398449id.get() + ",pageId:" + QCircleFeedReportScroller.this.G.getPageId());
            }
        });
    }

    private void I(final a aVar) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller.2
            @Override // java.lang.Runnable
            public void run() {
                QCircleFeedReportScroller.this.X(aVar);
            }
        });
    }

    private boolean J(View view) {
        if (view != null && view.getTag(R.id.f166942ja3) != null) {
            boolean z16 = !((Boolean) view.getTag(R.id.f166942ja3)).booleanValue();
            if (z16) {
                view.setTag(R.id.f166942ja3, Boolean.TRUE);
            }
            return z16;
        }
        return false;
    }

    private boolean K(Integer num, a aVar) {
        if (!this.H.containsValue(aVar)) {
            aVar.m();
            this.H.put(num, aVar);
            return true;
        }
        return false;
    }

    private boolean L(View view) {
        int i3;
        if (view != null) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            int height = view.getHeight();
            int i16 = rect.bottom;
            if (i16 > 0) {
                i3 = i16 - rect.top;
            } else {
                i3 = 0;
            }
            float f16 = i3 / height;
            if (f16 >= 0.5d && !Float.isNaN(f16)) {
                if ((view instanceof QCircleWaterfallFeedItemView) && f16 < 1.0f) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private void M(String str) {
        Iterator<Map.Entry<Integer, a>> it = this.H.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value != null) {
                I(value);
                QLog.d("QCircleFeedReportHelper", 4, "report feed stay event from flush by " + str + ",index:" + value.f() + ",feedId:" + value.d().f398449id.get() + ",pageId:" + this.L + ",stayTime:" + value.h() + "ms");
            }
            it.remove();
        }
        QLog.d("QCircleFeedReportHelper", 4, "flushStayEventReport by " + str + ",retain size:" + this.H.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str) {
        Iterator<Map.Entry<Integer, a>> it = this.J.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value != null) {
                H(value.f92273a, str, true);
                it.remove();
            }
        }
        QLog.d("QCircleFeedReportHelper", 4, "flushValidExposeReport by " + str + ",retain size:" + this.J.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public Map<String, Object> O(QCircleBaseWidgetView qCircleBaseWidgetView) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (qCircleBaseWidgetView != null && (qCircleBaseWidgetView.getData() instanceof e30.b) && ((e30.b) qCircleBaseWidgetView.getData()).g() != null) {
            buildElementParams.putAll(c.d((e30.b) qCircleBaseWidgetView.getData()));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(qCircleBaseWidgetView.getDataPosInList() + 1));
            buildElementParams.put("xsj_item_index", Integer.valueOf(qCircleBaseWidgetView.getDataPosInList()));
        }
        return buildElementParams;
    }

    private int P(View view) {
        if (!(view instanceof BaseWidgetView)) {
            return 0;
        }
        return ((BaseWidgetView) view).getDataPosInList();
    }

    private FeedCloudMeta$StFeed Q(View view) {
        if (!(view instanceof BaseWidgetView)) {
            return null;
        }
        BaseWidgetView baseWidgetView = (BaseWidgetView) view;
        if (!(baseWidgetView.getData() instanceof e30.b)) {
            return null;
        }
        return ((e30.b) baseWidgetView.getData()).g();
    }

    private FeedCloudMeta$StFeed R(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder != null) {
            return Q(viewHolder.itemView);
        }
        return null;
    }

    private boolean S(View view) {
        if (!(view instanceof QCircleWaterfallFeedItemView) && !(view instanceof QFSMixFeedAlignBaseItemView) && !(view instanceof QFSGalleryWaterfallFeedItemView)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void T(a aVar) {
        if (aVar != null && (aVar.e() instanceof QCircleBaseWidgetView)) {
            QCircleBaseWidgetView qCircleBaseWidgetView = (QCircleBaseWidgetView) aVar.e();
            FeedCloudMeta$StFeed g16 = ((e30.b) qCircleBaseWidgetView.getData()).g();
            String str = g16.f398449id.get();
            aVar.j(g16);
            QLog.d("QCircleFeedReportHelper", 4, "refreshBeanData,index:" + qCircleBaseWidgetView.getDataPosInList() + ",feedId:" + str + ",pageId:" + this.L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, boolean z16) {
        String valueOf;
        int i16;
        if (feedCloudMeta$StFeed != null) {
            W(feedCloudMeta$StFeed, i3, z16);
            int i17 = this.L;
            String str = "";
            if (i17 != 71 && i17 != 72 && i17 != 73) {
                valueOf = "";
            } else {
                valueOf = String.valueOf(this.f92282h.title);
            }
            int i18 = this.L;
            if (i18 == 691 || i18 == 831 || i18 == 851) {
                str = q.a(feedCloudMeta$StFeed);
            }
            QCircleLpReportDc05501.DataBuilder toUin = c.a(feedCloudMeta$StFeed).setToUin(feedCloudMeta$StFeed.poster.f398463id.get());
            if (z16) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setActionType(i16).setSubActionType(1).setIndex(i3).setExt2(valueOf).setExt6(str).setPageId(this.G.getPageId())));
        }
    }

    private void W(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, boolean z16) {
        String str;
        String str2;
        String str3;
        String str4;
        if (z16 && feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.images.get() != null) {
            String str5 = "";
            if (feedCloudMeta$StFeed.type.get() != 2 || feedCloudMeta$StFeed.images.size() <= 0) {
                str = "";
            } else {
                str = feedCloudMeta$StFeed.images.get(0).picId.get() + "";
            }
            FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = feedCloudMeta$StFeed.authSchoolInfo;
            if (feedCloudMeta$StTagInfo == null) {
                str2 = "";
            } else {
                str2 = feedCloudMeta$StTagInfo.tagName.get();
            }
            if (feedCloudMeta$StFeed.type.get() == 2) {
                str4 = "0";
                str5 = "1";
                str3 = feedCloudMeta$StFeed.images.size() + "";
            } else if (feedCloudMeta$StFeed.type.get() == 3) {
                str4 = "";
                str5 = "2";
                str3 = str4;
            } else {
                str3 = "";
                str4 = str3;
            }
            QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(c.c(feedCloudMeta$StFeed)).setActionType(1).setSubActionType(1).setToUin(feedCloudMeta$StFeed.poster.f398463id.get()).setPosition(i3).setPlayScene(1).setLloc(str).setExt1(str5).setExt2(str4).setExt3(str3).setExt6(str2).setPageId(this.G.getPageId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(a aVar) {
        if (aVar != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = aVar.f92278f;
            aVar.i(System.currentTimeMillis());
            QCircleLpReportDc05502.report(new QCircleLpReportDc05502.DataBuilder(c.b(feedCloudMeta$StFeed).setToUin(feedCloudMeta$StFeed.poster.f398463id.get()).setBeginTime(aVar.g()).setEndTime(aVar.c()).setStayTime(aVar.h()).setIndex(aVar.f()).setExt1("1").setPageId(this.L)));
        }
    }

    private void Y() {
        for (Map.Entry<Integer, a> entry : this.I.entrySet()) {
            int intValue = entry.getKey().intValue();
            a value = entry.getValue();
            if (!this.J.containsKey(Integer.valueOf(intValue)) && L(value.e()) && value.d() != null) {
                this.J.put(Integer.valueOf(intValue), value);
                if (RFWApplication.isDebug()) {
                    QLog.d("QCircleFeedReportHelper", 4, "add validExposePool from scroll,index:" + value.f() + ",feedId:" + value.d().f398449id.get() + ",pageId:" + this.L);
                }
                if (K(Integer.valueOf(intValue), value)) {
                    QLog.d("QCircleFeedReportHelper", 4, "record feed stay event from scroll,index:" + value.f() + ",feedId:" + value.d().f398449id.get() + ",pageId:" + this.L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(String str) {
        QLog.d("QCircleFeedReportHelper", 4, "scanValidExposeWhenRefreshOrResume,baseExposePool size:" + this.I.size() + ",validExposePool size:" + this.J.size());
        for (a aVar : this.I.values()) {
            if (aVar != null) {
                if (aVar.e() != null) {
                    aVar.e().setTag(R.id.f166942ja3, Boolean.FALSE);
                    H(aVar.e(), str, false);
                }
                T(aVar);
                if (L(aVar.e()) && aVar.d() != null) {
                    aVar.m();
                    this.H.put(Integer.valueOf(aVar.f()), aVar);
                    QLog.d("QCircleFeedReportHelper", 4, "record feed stay event from " + str + ",index:" + aVar.f() + ",feedId:" + aVar.d().f398449id.get() + ",pageId:" + this.L);
                    H(aVar.e(), str, true);
                }
            }
        }
    }

    public void F(b bVar) {
        this.K.add(bVar);
    }

    public void U(b bVar) {
        this.K.remove(bVar);
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void o() {
        if (this.M) {
            QLog.d("QCircleFeedReportHelper", 4, MiniSDKConst.NOTIFY_EVENT_ONPAUSE + ",pageId:" + this.L);
            N(MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            M(MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        this.M = l();
        if (this.K.size() > 0) {
            Iterator<b> it = this.K.iterator();
            while (it.hasNext()) {
                it.next().onPause();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void onDestroy() {
        Iterator<Integer> it = this.H.keySet().iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next != null) {
                a aVar = this.H.get(next);
                if (aVar != null) {
                    I(aVar);
                    if (aVar.d() != null) {
                        QLog.d("QCircleFeedReportHelper", 4, "report feed stay event from destory,index:" + aVar.f() + ",feedId:" + aVar.d().f398449id.get() + ",pageId:" + this.L + ",stayTime:" + aVar.h() + "ms");
                    }
                }
                it.remove();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void onResume() {
        boolean l3 = l();
        this.M = l3;
        if (l3) {
            QLog.d("QCircleFeedReportHelper", 4, "onResume,pageId:" + this.L);
            Z("onResume");
            N("onResume");
        }
        if (this.K.size() > 0) {
            Iterator<b> it = this.K.iterator();
            while (it.hasNext()) {
                it.next().onResume();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void p() {
        boolean l3 = l();
        this.M = l3;
        if (l3 && this.I.size() > 0) {
            QLog.d("QCircleFeedReportHelper", 4, "onRefresh,pageId:" + this.L);
            M(HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
            N(HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller.3
                @Override // java.lang.Runnable
                public void run() {
                    QCircleFeedReportScroller.this.Z(HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
                    QCircleFeedReportScroller.this.N(HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
                }
            }, 100L);
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void q(RecyclerView recyclerView, int i3, int i16, boolean z16) {
        if (!this.M) {
            return;
        }
        Y();
        if (this.K.size() > 0) {
            Iterator<b> it = this.K.iterator();
            while (it.hasNext()) {
                it.next().a(recyclerView, i3, i16, z16);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void r(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
        if (this.M && i3 == 0) {
            if (i16 <= i17) {
                while (i16 <= i17) {
                    try {
                        View findViewByPosition = layoutManager.findViewByPosition(i16);
                        if (S(findViewByPosition) && L(findViewByPosition)) {
                            G(findViewByPosition);
                            H(findViewByPosition, "onIdle", true);
                        }
                        i16++;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                VideoReport.traverseExposure();
            }
            e.i().w();
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void s(RecyclerView.ViewHolder viewHolder) {
        if (!S(viewHolder.itemView)) {
            return;
        }
        E(viewHolder);
        if (this.M) {
            H(viewHolder.itemView, "onAttach", false);
        }
    }

    @Override // com.tencent.biz.qqcircle.scrollers.a
    public void t(RecyclerView.ViewHolder viewHolder) {
        if (!S(viewHolder.itemView)) {
            return;
        }
        FeedCloudMeta$StFeed R = R(viewHolder);
        int P = P(viewHolder.itemView);
        if (R == null) {
            QLog.e("QCircleFeedReportHelper", 1, "onViewDetachedFromWindow holder miss feed data!pageId:" + this.L);
            return;
        }
        String str = R.f398449id.get();
        if (this.I.containsKey(Integer.valueOf(P))) {
            QLog.d("QCircleFeedReportHelper", 4, "remove baseExposePool from detach,index:" + P + ",feedId:" + str + ",pageId:" + this.L);
            this.I.remove(Integer.valueOf(P));
        }
        if (this.H.containsKey(Integer.valueOf(P))) {
            a aVar = this.H.get(Integer.valueOf(P));
            if (aVar != null) {
                I(aVar);
                QLog.d("QCircleFeedReportHelper", 4, "report feed stay event from detach,index:" + P + ",feedId:" + str + ",pageId:" + this.L + ",stayTime:" + aVar.h() + "ms");
            }
            this.H.remove(Integer.valueOf(P));
        }
        if (this.J.containsKey(Integer.valueOf(P))) {
            H(viewHolder.itemView, "onDetach", true);
            this.J.remove(Integer.valueOf(P));
        }
    }
}
