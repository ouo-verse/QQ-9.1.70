package com.qzone.album.business.photolist.ui.timeline.view;

import NS_MOBILE_PHOTO.TabTimeLine;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import cooperation.qzone.util.SystemUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes39.dex */
public class RecentPhotoTimeLineView extends AbstractTimeLineView {
    private static final int F = ar.e(70.0f);
    private static final int G = ar.e(15.0f);
    private static final int H = ar.e(15.0f);
    private static final int I = ar.e(7.0f);
    private static final int J = ar.e(8.0f);
    public static int K = 3;
    public static int L = 4;
    public static int M = 1;
    public static int N = 2;
    private ArrayList<TabTimeLine> C;
    private long D;
    private ListView.OnScrollChangeListener E;

    /* renamed from: f, reason: collision with root package name */
    private TextView f43821f;

    /* renamed from: h, reason: collision with root package name */
    private ListView f43822h;

    /* renamed from: i, reason: collision with root package name */
    private b f43823i;

    /* renamed from: m, reason: collision with root package name */
    private int f43824m;

    /* loaded from: classes39.dex */
    class a implements ListView.OnScrollChangeListener {
        a() {
        }

        @Override // com.tencent.widget.ListView.OnScrollChangeListener
        public void onScrollChanged(int i3, int i16, int i17) {
            b.a item = RecentPhotoTimeLineView.this.f43823i.getItem(i3);
            if (item == null || item.f43831a == RecentPhotoTimeLineView.this.D) {
                return;
            }
            RecentPhotoTimeLineView.this.D = item.f43831a;
            RecentPhotoTimeLineView.this.f43821f.setText(String.format(Locale.getDefault(), "%d\u5e74", Long.valueOf(RecentPhotoTimeLineView.this.D)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            b.a item;
            RecentPhotoTimeLineView recentPhotoTimeLineView = RecentPhotoTimeLineView.this;
            if (recentPhotoTimeLineView.f43743d == null || i3 == recentPhotoTimeLineView.f43824m || (item = RecentPhotoTimeLineView.this.f43823i.getItem(i3)) == null || item.f43834d != RecentPhotoTimeLineView.M) {
                return;
            }
            RecentPhotoTimeLineView.this.f43743d.a(item.f43836f, item.f43837g, i3);
            RecentPhotoTimeLineView.this.f43823i.d(view, i3);
        }
    }

    public RecentPhotoTimeLineView(Context context) {
        super(context);
        this.D = 0L;
        this.E = new a();
        o();
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void b() {
        b bVar = this.f43823i;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void o() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bv_, this);
        this.f43822h = (ListView) inflate.findViewById(R.id.f166980jm1);
        this.f43821f = (TextView) inflate.findViewById(R.id.f166981jm2);
        b bVar = new b(getContext());
        this.f43823i = bVar;
        this.f43822h.setAdapter((ListAdapter) bVar);
        this.f43822h.setOnItemClickListener(new c());
        this.f43822h.setOnScrollChangeListener(this.E);
        this.f43822h.setBackgroundResource(0);
    }

    public void setPaddingForTimeLineHeader(Activity activity) {
        this.f43821f.setPadding(0, SystemUtil.getNotchHeight(getContext(), activity), 0, 0);
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void setRecentPhotoData(ArrayList<TabTimeLine> arrayList) {
        this.C = arrayList;
        this.f43823i.setData(arrayList);
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void setSelection(long j3) {
        b bVar = this.f43823i;
        if (bVar != null) {
            bVar.c(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<a> f43826d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        private Context f43827e;

        /* renamed from: f, reason: collision with root package name */
        private final int f43828f;

        /* renamed from: h, reason: collision with root package name */
        private final int f43829h;

        /* loaded from: classes39.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            long f43831a;

            /* renamed from: b, reason: collision with root package name */
            long f43832b;

            /* renamed from: c, reason: collision with root package name */
            int f43833c;

            /* renamed from: d, reason: collision with root package name */
            int f43834d;

            /* renamed from: e, reason: collision with root package name */
            boolean f43835e;

            /* renamed from: f, reason: collision with root package name */
            long f43836f;

            /* renamed from: g, reason: collision with root package name */
            long f43837g;

            public a() {
            }
        }

        /* renamed from: com.qzone.album.business.photolist.ui.timeline.view.RecentPhotoTimeLineView$b$b, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        public class C0350b {

            /* renamed from: a, reason: collision with root package name */
            RelativeLayout f43839a;

            /* renamed from: b, reason: collision with root package name */
            TextView f43840b;

            /* renamed from: c, reason: collision with root package name */
            TextView f43841c;

            /* renamed from: d, reason: collision with root package name */
            TextView f43842d;

            /* renamed from: e, reason: collision with root package name */
            LinearLayout f43843e;

            /* renamed from: f, reason: collision with root package name */
            View f43844f;

            public C0350b() {
            }
        }

        public b(Context context) {
            this.f43827e = context;
            Resources resources = context.getResources();
            this.f43828f = resources.getColor(R.color.qzone_skin_homepage_timeline_text_color_normal);
            this.f43829h = resources.getColor(R.color.qzone_skin_homepage_timeline_text_color_selected);
        }

        private View b(int i3) {
            int firstVisiblePosition = RecentPhotoTimeLineView.this.f43822h.getFirstVisiblePosition();
            int childCount = (RecentPhotoTimeLineView.this.f43822h.getChildCount() + firstVisiblePosition) - 1;
            if (i3 < firstVisiblePosition || i3 > childCount) {
                return null;
            }
            return RecentPhotoTimeLineView.this.f43822h.getChildAt(i3 - firstVisiblePosition);
        }

        void c(long j3) {
            if (this.f43826d == null || j3 <= 0) {
                return;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j3 * 1000);
            int i3 = calendar.get(1);
            int i16 = calendar.get(2) + 1;
            for (int i17 = 0; i17 < this.f43826d.size(); i17++) {
                a aVar = this.f43826d.get(i17);
                if (aVar != null) {
                    if (aVar.f43831a == i3 && aVar.f43832b == i16 && aVar.f43834d == RecentPhotoTimeLineView.M) {
                        aVar.f43835e = true;
                        RecentPhotoTimeLineView.this.f43824m = i17;
                    } else {
                        aVar.f43835e = false;
                    }
                }
            }
            notifyDataSetChanged();
        }

        void d(View view, int i3) {
            if (i3 != RecentPhotoTimeLineView.this.f43824m && i3 >= 0 && i3 < getCount() && RecentPhotoTimeLineView.this.f43824m >= 0 && RecentPhotoTimeLineView.this.f43824m < getCount()) {
                this.f43826d.get(RecentPhotoTimeLineView.this.f43824m).f43835e = false;
                View b16 = b(RecentPhotoTimeLineView.this.f43824m);
                if (b16 != null && ((C0350b) b16.getTag()) != null) {
                    b16.setBackgroundResource(0);
                }
                RecentPhotoTimeLineView.this.f43824m = i3;
                this.f43826d.get(i3).f43835e = true;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<a> arrayList = this.f43826d;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            C0350b c0350b;
            if (view == null) {
                view = LayoutInflater.from(this.f43827e).inflate(R.layout.bva, (ViewGroup) null);
                c0350b = new C0350b();
                c0350b.f43839a = (RelativeLayout) view.findViewById(R.id.dpq);
                c0350b.f43840b = (TextView) view.findViewById(R.id.jji);
                c0350b.f43841c = (TextView) view.findViewById(R.id.ezf);
                c0350b.f43842d = (TextView) view.findViewById(R.id.ezg);
                c0350b.f43843e = (LinearLayout) view.findViewById(R.id.eze);
                c0350b.f43844f = view.findViewById(R.id.l6j);
                view.setTag(c0350b);
            } else {
                c0350b = (C0350b) view.getTag();
            }
            a item = getItem(i3);
            if (item != null) {
                ViewGroup.LayoutParams layoutParams = c0350b.f43839a.getLayoutParams();
                int i16 = item.f43833c;
                if (i16 == RecentPhotoTimeLineView.L) {
                    c0350b.f43841c.setText(String.valueOf(item.f43832b));
                    c0350b.f43843e.setVisibility(0);
                    c0350b.f43840b.setVisibility(8);
                    c0350b.f43844f.setVisibility(8);
                    if (item.f43835e) {
                        c0350b.f43841c.setTextColor(this.f43829h);
                        c0350b.f43841c.setTextSize(50.0f);
                        c0350b.f43842d.setTextColor(this.f43829h);
                        c0350b.f43842d.setTextSize(16.0f);
                        if (layoutParams != null) {
                            layoutParams.height = RecentPhotoTimeLineView.F + RecentPhotoTimeLineView.I + RecentPhotoTimeLineView.J;
                        }
                        c0350b.f43843e.setPadding(0, 0, 0, 0);
                        view.setBackgroundResource(R.drawable.qzone_skin_homepage_timeline_item_selected_bg);
                    } else {
                        c0350b.f43841c.setTextColor(this.f43828f);
                        c0350b.f43841c.setTextSize(25.0f);
                        c0350b.f43842d.setTextColor(this.f43828f);
                        c0350b.f43842d.setTextSize(12.0f);
                        if (layoutParams != null) {
                            layoutParams.height = -2;
                        }
                        int i17 = RecentPhotoTimeLineView.G;
                        a item2 = getItem(i3 - 1);
                        if (item2 != null && item2.f43835e) {
                            i17 -= RecentPhotoTimeLineView.J;
                        }
                        int i18 = RecentPhotoTimeLineView.H;
                        a item3 = getItem(i3 + 1);
                        if (item3 != null && item3.f43835e) {
                            i18 -= RecentPhotoTimeLineView.I;
                        }
                        c0350b.f43843e.setPadding(0, i17, 0, i18);
                        view.setBackgroundResource(0);
                    }
                } else if (i16 == RecentPhotoTimeLineView.K) {
                    c0350b.f43840b.setText(item.f43831a + l.a(R.string.svc));
                    c0350b.f43840b.setVisibility(0);
                    c0350b.f43843e.setVisibility(8);
                    c0350b.f43844f.setVisibility(0);
                    if (layoutParams != null) {
                        layoutParams.height = -2;
                    }
                    view.setBackgroundResource(0);
                }
                if (layoutParams != null) {
                    c0350b.f43839a.setLayoutParams(layoutParams);
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a getItem(int i3) {
            ArrayList<a> arrayList;
            if (i3 < 0 || i3 >= getCount() || (arrayList = this.f43826d) == null || arrayList.isEmpty()) {
                return null;
            }
            return this.f43826d.get(i3);
        }

        public void setData(ArrayList<TabTimeLine> arrayList) {
            if (arrayList == null) {
                return;
            }
            this.f43826d.clear();
            Iterator<TabTimeLine> it = arrayList.iterator();
            boolean z16 = true;
            long j3 = -1;
            while (it.hasNext()) {
                TabTimeLine next = it.next();
                a aVar = new a();
                long j16 = next.year;
                if (j3 != j16) {
                    if (!z16) {
                        aVar.f43834d = RecentPhotoTimeLineView.N;
                        aVar.f43833c = RecentPhotoTimeLineView.K;
                        aVar.f43831a = j16;
                        this.f43826d.add(aVar);
                    }
                    j3 = next.year;
                }
                a aVar2 = new a();
                aVar2.f43834d = RecentPhotoTimeLineView.M;
                aVar2.f43833c = RecentPhotoTimeLineView.L;
                aVar2.f43831a = next.year;
                aVar2.f43832b = next.month;
                aVar2.f43836f = next.begin_time;
                aVar2.f43837g = next.end_time;
                this.f43826d.add(aVar2);
                z16 = false;
            }
            notifyDataSetChanged();
        }
    }

    public RecentPhotoTimeLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = 0L;
        this.E = new a();
        o();
    }

    public RecentPhotoTimeLineView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = 0L;
        this.E = new a();
        o();
    }
}
