package com.qzone.component.banner;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import com.qzone.component.banner.SwipeOpeationBannerChild;
import com.qzone.widget.swipestack.SwipeStack;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import yo.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SwipeOperationAdsBanner extends Banner implements com.qzone.component.banner.b {
    c C;
    com.qzone.feed.business.model.a D;
    String E;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<SwipeOpeationBannerChild.i> f46543h;

    /* renamed from: i, reason: collision with root package name */
    SwipeStack f46544i;

    /* renamed from: m, reason: collision with root package name */
    View f46545m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements SwipeStack.d {
        a() {
        }

        @Override // com.qzone.widget.swipestack.SwipeStack.d
        public void c() {
            QZLog.i("SwipeOperationAdsBanner", 2, "onStackEmpty");
        }

        @Override // com.qzone.widget.swipestack.SwipeStack.d
        public void a(int i3, View view) {
            Object tag;
            if (view != null && (tag = view.getTag(R.id.f166935j90)) != null && (tag instanceof b)) {
                ((b) tag).b();
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("SwipeOperationAdsBanner", 2, String.format("onMoveToTop %d,%s", Integer.valueOf(i3), String.valueOf(view)));
            }
        }

        @Override // com.qzone.widget.swipestack.SwipeStack.d
        public void b(int i3, View view) {
            Object tag;
            if (view != null && (tag = view.getTag(R.id.f166935j90)) != null && (tag instanceof b)) {
                ((b) tag).a();
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("SwipeOperationAdsBanner", 2, String.format("onViewSwiped %d,%s", Integer.valueOf(i3), String.valueOf(view)));
            }
            e.a(SwipeOperationAdsBanner.this.E, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    interface b {
        void a();

        void b();
    }

    public SwipeOperationAdsBanner(Context context) {
        super(context);
    }

    private void u() {
        if (this.f46545m == null || this.D == null) {
            return;
        }
        int color = getResources().getColor(R.color.qzone_skin_feed_background_color);
        this.f46545m.setBackgroundColor(Color.argb(this.D.f47124h, Color.red(color), Color.green(color), Color.blue(color)));
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 700;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 21;
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        View inflate = viewStub.inflate();
        this.f46545m = inflate;
        SwipeStack swipeStack = (SwipeStack) inflate.findViewById(R.id.j8v);
        this.f46544i = swipeStack;
        swipeStack.bringToFront();
        this.f46544i.setmLoop(true);
        this.f46543h = new ArrayList<>();
        c cVar = new c(this.f46543h);
        this.C = cVar;
        this.f46544i.setAdapter(cVar);
        this.f46544i.setmListener(new a());
        this.f46297e = true;
        inflate.setVisibility(8);
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        if (this.f46297e) {
            if (z16) {
                this.f46545m.setVisibility(0);
            } else {
                this.f46545m.setVisibility(8);
                e.e();
            }
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        if (this.f46297e) {
            return this.f46545m.isShown();
        }
        return false;
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        this.D = aVar;
        u();
        if (aVar != null) {
            try {
                BusinessADBannerData businessADBannerData = aVar.f47123g;
                String str = businessADBannerData.dynBannerJsonData;
                String str2 = businessADBannerData.strTraceInfo;
                this.E = str2;
                e.d(str2, 0);
                QZLog.i("SwipeOperationAdsBanner", 2, "bannerData:", str);
                ArrayList<SwipeOpeationBannerChild.i> a16 = SwipeOpeationBannerChild.i.a(str);
                Iterator<SwipeOpeationBannerChild.i> it = a16.iterator();
                while (it.hasNext()) {
                    SwipeOpeationBannerChild.i next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.f46542o)) {
                        next.f46542o = BusinessADBannerData.getJumpTraceInfoUrl(next.f46542o, this.E);
                    }
                }
                SwipeStack swipeStack = this.f46544i;
                if (swipeStack != null) {
                    swipeStack.z();
                }
                ArrayList<SwipeOpeationBannerChild.i> arrayList = this.f46543h;
                if (arrayList != null) {
                    arrayList.clear();
                    this.f46543h.addAll(a16);
                }
                this.C.notifyDataSetChanged();
                c();
            } catch (Throwable th5) {
                g();
                QZLog.e("SwipeOperationAdsBanner", "SwipeOperationAdsBanner", th5);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private List<SwipeOpeationBannerChild.i> f46547d;

        public c(List<SwipeOpeationBannerChild.i> list) {
            this.f46547d = list;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SwipeOpeationBannerChild.i getItem(int i3) {
            return this.f46547d.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f46547d.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(SwipeOperationAdsBanner.this.getContext()).inflate(R.layout.bnw, viewGroup, false);
            }
            SwipeOpeationBannerChild m3 = SwipeOpeationBannerChild.m();
            m3.p(view);
            m3.q(SwipeOperationAdsBanner.this);
            m3.s(SwipeOperationAdsBanner.this.C.getItem(i3));
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    public SwipeOperationAdsBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.qzone.component.banner.b
    public void a(int i3) {
        QZLog.i("SwipeOperationAdsBanner", 2, "onDelClick:", Integer.valueOf(i3));
        g();
        e.c(this.E);
    }

    @Override // com.qzone.component.banner.b
    public void b(int i3) {
        QZLog.i("SwipeOperationAdsBanner", 2, "picClick:", Integer.valueOf(i3));
        if (i3 < 0 || i3 >= this.C.getCount()) {
            return;
        }
        SwipeOpeationBannerChild.i item = this.C.getItem(i3);
        if (!TextUtils.isEmpty(item.f46541n) || !TextUtils.isEmpty(item.f46542o)) {
            HashMap hashMap = new HashMap();
            hashMap.put("key1", "adbanner");
            if (QZLog.isColorLevel()) {
                QZLog.d("SwipeOperationAdsBanner", 2, "----jump url:" + item.f46542o);
                QZLog.d("SwipeOperationAdsBanner", 2, "----schemeUrl url:" + item.f46541n);
            }
            g gVar = new g(item.f46541n);
            gVar.f450709b = item.f46542o;
            gVar.f450714g = hashMap;
            yo.d.b(getContext(), gVar);
        }
        e.b(this.E, i3);
    }
}
