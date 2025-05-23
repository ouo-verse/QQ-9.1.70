package com.qzone.reborn.feedx.widget.homepage;

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
import com.qzone.proxy.feedcomponent.model.ProfileTimeLine;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import cooperation.qzone.util.SystemUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes37.dex */
public class QZoneHomePageTimeLineView extends RelativeLayout {
    public static int C = 3;
    public static int D = 4;
    public static int E = 1;
    public static int F = 2;

    /* renamed from: d, reason: collision with root package name */
    private b f56356d;

    /* renamed from: e, reason: collision with root package name */
    private c f56357e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f56358f;

    /* renamed from: h, reason: collision with root package name */
    private ListView f56359h;

    /* renamed from: i, reason: collision with root package name */
    private int f56360i;

    /* renamed from: m, reason: collision with root package name */
    private final ListView.OnScrollChangeListener f56361m;

    /* loaded from: classes37.dex */
    class a implements ListView.OnScrollChangeListener {
        a() {
        }

        @Override // com.tencent.widget.ListView.OnScrollChangeListener
        public void onScrollChanged(int i3, int i16, int i17) {
            b.C0475b item;
            if (QZoneHomePageTimeLineView.this.f56356d == null || (item = QZoneHomePageTimeLineView.this.f56356d.getItem(i3)) == null) {
                return;
            }
            QZoneHomePageTimeLineView.this.f56358f.setText(item.f56374a + l.a(R.string.n8l));
        }
    }

    /* loaded from: classes37.dex */
    public interface c {
        void a(long j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes37.dex */
    public class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            if (QZoneHomePageTimeLineView.this.f56357e != null && QZoneHomePageTimeLineView.this.f56356d != null && i3 != QZoneHomePageTimeLineView.this.f56360i) {
                b.C0475b item = QZoneHomePageTimeLineView.this.f56356d.getItem(i3);
                com.qzone.misc.network.report.c.b("308", "66");
                if (item != null && item.f56377d == QZoneHomePageTimeLineView.E) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(item.f56374a, item.f56375b, 1, 0, 0, 0);
                    QZoneHomePageTimeLineView.this.f56357e.a(calendar.getTimeInMillis() - 1000);
                    QZoneHomePageTimeLineView.this.f56356d.e(view, i3);
                }
            }
            fo.c.b("dt_clck", QZoneHomePageTimeLineView.this.f56359h, "em_qz_time_shaft_select", null);
        }
    }

    public QZoneHomePageTimeLineView(Context context) {
        super(context);
        this.f56361m = new a();
        g();
    }

    public void g() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.chi, this);
        this.f56359h = (ListView) inflate.findViewById(R.id.f162945nh0);
        this.f56358f = (TextView) inflate.findViewById(R.id.f162949nh4);
        b bVar = new b(getContext());
        this.f56356d = bVar;
        this.f56359h.setAdapter((ListAdapter) bVar);
        this.f56359h.setOnItemClickListener(new d());
        this.f56359h.setOnScrollChangeListener(this.f56361m);
        this.f56359h.setBackgroundResource(0);
        fo.c.r(this.f56359h, "em_qz_time_shaft_select", null);
    }

    public void h() {
        b bVar = this.f56356d;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void setData(ProfileTimeLine profileTimeLine) {
        b bVar = this.f56356d;
        if (bVar != null) {
            bVar.c(profileTimeLine);
        }
    }

    public void setPaddingForTimeLineHeader(Activity activity) {
        this.f56358f.setPadding(0, SystemUtil.getNotchHeight(getContext(), activity), 0, 0);
    }

    public void setSelection(long j3) {
        b bVar = this.f56356d;
        if (bVar != null) {
            bVar.d(j3);
        }
    }

    public void setTimeLineListener(c cVar) {
        this.f56357e = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private CopyOnWriteArrayList<C0475b> f56363d = new CopyOnWriteArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        private final Context f56364e;

        /* renamed from: f, reason: collision with root package name */
        private final int f56365f;

        /* renamed from: h, reason: collision with root package name */
        private final int f56366h;

        /* loaded from: classes37.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            RelativeLayout f56368a;

            /* renamed from: b, reason: collision with root package name */
            TextView f56369b;

            /* renamed from: c, reason: collision with root package name */
            TextView f56370c;

            /* renamed from: d, reason: collision with root package name */
            TextView f56371d;

            /* renamed from: e, reason: collision with root package name */
            LinearLayout f56372e;

            public a() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.qzone.reborn.feedx.widget.homepage.QZoneHomePageTimeLineView$b$b, reason: collision with other inner class name */
        /* loaded from: classes37.dex */
        public class C0475b {

            /* renamed from: a, reason: collision with root package name */
            int f56374a;

            /* renamed from: b, reason: collision with root package name */
            int f56375b;

            /* renamed from: c, reason: collision with root package name */
            int f56376c;

            /* renamed from: d, reason: collision with root package name */
            int f56377d;

            /* renamed from: e, reason: collision with root package name */
            boolean f56378e;

            C0475b() {
            }
        }

        b(Context context) {
            this.f56364e = context;
            Resources resources = context.getResources();
            this.f56365f = resources.getColor(R.color.qui_common_text_primary);
            this.f56366h = resources.getColor(R.color.qui_common_brand_standard);
        }

        private View b(int i3) {
            int firstVisiblePosition = QZoneHomePageTimeLineView.this.f56359h.getFirstVisiblePosition();
            int childCount = (QZoneHomePageTimeLineView.this.f56359h.getChildCount() + firstVisiblePosition) - 1;
            if (i3 < firstVisiblePosition || i3 > childCount) {
                return null;
            }
            return QZoneHomePageTimeLineView.this.f56359h.getChildAt(i3 - firstVisiblePosition);
        }

        void d(long j3) {
            if (this.f56363d == null || j3 <= 0) {
                return;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j3);
            int i3 = calendar.get(1);
            int i16 = calendar.get(2) + 1;
            for (int i17 = 0; i17 < this.f56363d.size(); i17++) {
                C0475b c0475b = this.f56363d.get(i17);
                if (c0475b != null) {
                    if (c0475b.f56374a == i3 && c0475b.f56375b == i16 && c0475b.f56377d == QZoneHomePageTimeLineView.E) {
                        c0475b.f56378e = true;
                        QZoneHomePageTimeLineView.this.f56360i = i17;
                    } else {
                        c0475b.f56378e = false;
                    }
                }
            }
            notifyDataSetChanged();
        }

        void e(View view, int i3) {
            if (i3 != QZoneHomePageTimeLineView.this.f56360i && i3 >= 0 && i3 < getCount() && QZoneHomePageTimeLineView.this.f56360i >= 0 && QZoneHomePageTimeLineView.this.f56360i < getCount()) {
                this.f56363d.get(QZoneHomePageTimeLineView.this.f56360i).f56378e = false;
                View b16 = b(QZoneHomePageTimeLineView.this.f56360i);
                if (b16 != null && ((a) b16.getTag()) != null) {
                    b16.setBackgroundResource(0);
                }
                QZoneHomePageTimeLineView.this.f56360i = i3;
                this.f56363d.get(i3).f56378e = true;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            CopyOnWriteArrayList<C0475b> copyOnWriteArrayList = this.f56363d;
            if (copyOnWriteArrayList != null) {
                return copyOnWriteArrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        public void c(ProfileTimeLine profileTimeLine) {
            if (profileTimeLine == null || profileTimeLine.timeLines == null) {
                return;
            }
            this.f56363d.clear();
            ArrayList arrayList = new ArrayList(profileTimeLine.timeLines.keySet());
            Collections.sort(arrayList, Collections.reverseOrder());
            Iterator it = arrayList.iterator();
            boolean z16 = true;
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (!z16) {
                    C0475b c0475b = new C0475b();
                    c0475b.f56377d = QZoneHomePageTimeLineView.F;
                    c0475b.f56376c = QZoneHomePageTimeLineView.C;
                    c0475b.f56374a = num.intValue();
                    this.f56363d.add(c0475b);
                }
                ArrayList<Integer> arrayList2 = profileTimeLine.timeLines.get(num);
                Collections.sort(arrayList2, Collections.reverseOrder());
                Iterator<Integer> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    Integer next = it5.next();
                    C0475b c0475b2 = new C0475b();
                    c0475b2.f56377d = QZoneHomePageTimeLineView.E;
                    c0475b2.f56376c = QZoneHomePageTimeLineView.D;
                    c0475b2.f56374a = num.intValue();
                    c0475b2.f56375b = next.intValue();
                    this.f56363d.add(c0475b2);
                }
                z16 = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f56364e).inflate(R.layout.chj, (ViewGroup) null);
                aVar = new a();
                aVar.f56368a = (RelativeLayout) view.findViewById(R.id.ks_);
                aVar.f56369b = (TextView) view.findViewById(R.id.ngu);
                aVar.f56370c = (TextView) view.findViewById(R.id.f162759mh2);
                TextView textView = (TextView) view.findViewById(R.id.f162760mh3);
                aVar.f56371d = textView;
                textView.setFocusable(true);
                aVar.f56371d.setFocusableInTouchMode(true);
                aVar.f56371d.requestFocus();
                aVar.f56371d.requestFocusFromTouch();
                aVar.f56372e = (LinearLayout) view.findViewById(R.id.f162758mh1);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            C0475b item = getItem(i3);
            if (item != null) {
                int i16 = item.f56376c;
                if (i16 == QZoneHomePageTimeLineView.D) {
                    aVar.f56370c.setText(String.valueOf(item.f56375b));
                    aVar.f56372e.setVisibility(0);
                    aVar.f56369b.setVisibility(8);
                    if (item.f56378e) {
                        aVar.f56370c.setTextColor(this.f56366h);
                        aVar.f56371d.setTextColor(this.f56366h);
                    } else {
                        aVar.f56370c.setTextColor(this.f56365f);
                        aVar.f56371d.setTextColor(this.f56365f);
                    }
                } else if (i16 == QZoneHomePageTimeLineView.C) {
                    aVar.f56369b.setText(item.f56374a + l.a(R.string.n8s));
                    aVar.f56369b.setVisibility(0);
                    aVar.f56372e.setVisibility(8);
                    view.setBackgroundResource(0);
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0475b getItem(int i3) {
            CopyOnWriteArrayList<C0475b> copyOnWriteArrayList;
            if (i3 < 0 || i3 >= getCount() || (copyOnWriteArrayList = this.f56363d) == null || copyOnWriteArrayList.isEmpty()) {
                return null;
            }
            return this.f56363d.get(i3);
        }
    }

    public QZoneHomePageTimeLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f56361m = new a();
        g();
    }

    public QZoneHomePageTimeLineView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f56361m = new a();
        g();
    }
}
