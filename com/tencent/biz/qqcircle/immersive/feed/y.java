package com.tencent.biz.qqcircle.immersive.feed;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.debug.QCircleDebugInfoDataManager;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSShowFeedDebugEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class y extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private static Boolean Q = Boolean.TRUE;
    private static int R = 0;
    private View I;
    private TextView J;
    private View K;
    private QUIPageTabBar L;
    private ViewPager M;
    private d N;
    private TextView P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements QCircleDebugInfoDataManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StFeed f86384a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f86385b;

        b(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
            this.f86384a = feedCloudMeta$StFeed;
            this.f86385b = i3;
        }

        @Override // com.tencent.biz.qqcircle.debug.QCircleDebugInfoDataManager.a
        public void a(Map<String, String> map) {
            y.this.q1(this.f86384a, this.f86385b - 1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private View f86387a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f86388b;

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d extends PagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        private final Context f86389d;

        /* renamed from: e, reason: collision with root package name */
        private final LruCache<Integer, c> f86390e = new LruCache<>(100);

        /* renamed from: f, reason: collision with root package name */
        private final List<String> f86391f = new ArrayList();

        public d(Context context) {
            this.f86389d = context;
        }

        public void d(List<String> list) {
            this.f86391f.clear();
            if (list != null && !list.isEmpty()) {
                this.f86391f.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.f86391f.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i3) {
            c cVar = this.f86390e.get(Integer.valueOf(i3));
            if (cVar == null) {
                View inflate = View.inflate(this.f86389d, R.layout.g_n, null);
                c cVar2 = new c();
                cVar2.f86387a = inflate;
                cVar2.f86388b = (TextView) inflate.findViewById(R.id.f365214s);
                this.f86390e.put(Integer.valueOf(i3), cVar2);
                cVar = cVar2;
            }
            TextView textView = cVar.f86388b;
            String str = this.f86391f.get(i3);
            textView.setText(str);
            textView.setOnLongClickListener(new e(str));
            viewGroup.addView(cVar.f86387a);
            return cVar.f86387a;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            if (view == obj) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class e implements View.OnLongClickListener {

        /* renamed from: d, reason: collision with root package name */
        private String f86392d;

        public e(String str) {
            this.f86392d = str;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            if (view != null && !TextUtils.isEmpty(this.f86392d)) {
                com.tencent.biz.qqcircle.utils.s.a(view.getContext(), this.f86392d);
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f189313z2), 0);
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    private void j1() {
        ViewStub viewStub = (ViewStub) this.C.findViewById(R.id.f365514v);
        if (viewStub == null) {
            return;
        }
        QLog.d(w0(), 1, "[checkInit]");
        View inflate = viewStub.inflate();
        this.I = inflate;
        this.P = (TextView) inflate.findViewById(R.id.f33110vk);
        this.J = (TextView) this.I.findViewById(R.id.f33100vj);
        this.K = this.I.findViewById(R.id.f365114r);
        this.L = (QUIPageTabBar) this.I.findViewById(R.id.f365314t);
        ViewPager viewPager = (ViewPager) this.I.findViewById(R.id.f365414u);
        this.M = viewPager;
        viewPager.addOnPageChangeListener(new a());
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y.this.m1(view);
            }
        });
    }

    private String k1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = true;
        if (feedCloudMeta$StFeed.commonInfo.contentCategory.get() != 1) {
            z16 = false;
        }
        sb5.append("\u662f\u5426\u4e3a\u641e\u7b11\u7c7b\u578b\uff1a");
        sb5.append(z16);
        sb5.append("\n");
        List<FeedCloudCommon$Entry> list = feedCloudMeta$StFeed.debugInfo.debugMap.get();
        if (list.size() > 0) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                sb5.append(feedCloudCommon$Entry.key.get());
                sb5.append(MsgSummary.STR_COLON);
                sb5.append(feedCloudCommon$Entry.value.get());
                sb5.append("\n");
            }
        }
        return sb5.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void l1(@NonNull QFSShowFeedDebugEvent qFSShowFeedDebugEvent) {
        QLog.d(w0(), 1, "[handleShowFeedDebugEvent] isShowFeedInfo = " + qFSShowFeedDebugEvent.isShowFeedInfo());
        if (qFSShowFeedDebugEvent.isShowFeedInfo()) {
            p1((FeedCloudMeta$StFeed) this.f85017h);
            o1(0);
        } else {
            o1(8);
        }
        s1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void m1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Q = Boolean.valueOf(!Q.booleanValue());
        q1((FeedCloudMeta$StFeed) this.f85017h, 3);
        s1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void o1(int i3) {
        View view = this.I;
        if (view != null && view.getVisibility() != i3) {
            this.I.setVisibility(i3);
        }
    }

    private void p1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        q1(feedCloudMeta$StFeed, 3);
        t1(feedCloudMeta$StFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void q1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        String str;
        QLog.d(w0(), 1, "[updateDebugPageData] retryCount = " + i3);
        j1();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add("\u8fd0\u8425\u4fe1\u606f");
        boolean b16 = com.tencent.biz.qqcircle.debug.g.b();
        String g16 = QCircleDebugInfoDataManager.h().g((FeedCloudMeta$StFeed) this.f85017h);
        if (!b16) {
            arrayList2.add("\u6253\u5f00feed\u8c03\u8bd5\u4fe1\u606f\u65b9\u5f0f\uff1a\u70b9\u51fb\u5206\u4eab\u6309\u94ae -> \u6253\u5f00\u8c03\u8bd5 -> \u6253\u5f00feed\u8c03\u8bd5\u4fe1\u606f");
        } else if (TextUtils.isEmpty(g16)) {
            arrayList2.add("\u6b63\u5728\u52a0\u8f7d\u3002\u3002\u3002\u3002\u3002\u3002\u8bf7\u7a0d\u7b49");
        } else {
            arrayList2.add(g16);
        }
        arrayList.add("\u63a8\u8350\u4fe1\u606f");
        if (b16) {
            arrayList2.add(k1(feedCloudMeta$StFeed));
        } else {
            arrayList2.add("\u6253\u5f00feed\u8c03\u8bd5\u4fe1\u606f\u65b9\u5f0f\uff1a\u70b9\u51fb\u5206\u4eab\u6309\u94ae -> \u6253\u5f00\u8c03\u8bd5 -> \u6253\u5f00feed\u8c03\u8bd5\u4fe1\u606f");
        }
        if (this.N == null) {
            d dVar = new d(m0());
            this.N = dVar;
            ViewPager viewPager = this.M;
            if (viewPager != null) {
                viewPager.setAdapter(dVar);
            }
        }
        this.N.d(arrayList2);
        QUIPageTabBar qUIPageTabBar = this.L;
        if (qUIPageTabBar != null) {
            qUIPageTabBar.setTabData((String[]) arrayList.toArray(new String[0]));
            this.L.setViewPager(this.M);
        }
        r1();
        if (Q.booleanValue() && i3 > 0 && TextUtils.isEmpty(g16) && b16) {
            String w06 = w0();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[updateDebugPageData] not has feedFeature, requestSingleFeedFeature, feedId = ");
            T t16 = this.f85017h;
            if (t16 == 0) {
                str = "";
            } else {
                str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
            }
            sb5.append(str);
            sb5.append(", retryCount = ");
            sb5.append(i3);
            QLog.e(w06, 1, sb5.toString());
            QCircleDebugInfoDataManager.h().o(feedCloudMeta$StFeed, new b(feedCloudMeta$StFeed, i3));
        }
    }

    private void r1() {
        ViewPager viewPager = this.M;
        if (viewPager != null && this.L != null) {
            try {
                viewPager.setCurrentItem(R);
                this.L.setCurrentPosition(R);
            } catch (IllegalArgumentException e16) {
                QLog.e(w0(), 1, "[updateDebugPagePosition] e:" + e16.getMessage());
            }
        }
    }

    private void s1() {
        if (this.J != null && this.K != null) {
            if (Q.booleanValue()) {
                this.J.setText("-\u6536\u8d77Debug\u4fe1\u606f\u9762\u677f(\u957f\u6309\u6587\u672c\u53ef\u590d\u5236)");
                this.K.setVisibility(0);
            } else {
                this.J.setText("+\u5c55\u5f00Debug\u4fe1\u606f\u9762\u677f(\u957f\u6309\u6587\u672c\u53ef\u590d\u5236)");
                this.K.setVisibility(8);
            }
        }
    }

    private void t1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        j1();
        if (this.P == null) {
            return;
        }
        if (com.tencent.biz.qqcircle.rerank.util.a.b(feedCloudMeta$StFeed)) {
            this.P.setVisibility(0);
        } else {
            this.P.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSShowFeedDebugEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        if (com.tencent.biz.qqcircle.debug.g.c()) {
            p1(feedCloudMeta$StFeed);
            o1(0);
        } else {
            o1(8);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (com.tencent.biz.qqcircle.debug.g.c()) {
            s1();
            r1();
            o1(0);
            return;
        }
        o1(8);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSShowFeedDebugEvent) {
            l1((QFSShowFeedDebugEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public String w0() {
        return "QFSFeedChildDebugInfoPresenter";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            y.R = i3;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }
}
