package com.qzone.proxy.feedcomponent.ui;

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
import com.qzone.util.ar;
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

/* loaded from: classes39.dex */
public class HomePageTimeLineView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private b f50788d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f50789e;

    /* renamed from: f, reason: collision with root package name */
    private ListView f50790f;

    /* renamed from: h, reason: collision with root package name */
    private int f50791h;

    /* renamed from: i, reason: collision with root package name */
    private ListView.OnScrollChangeListener f50792i;

    /* renamed from: m, reason: collision with root package name */
    private static final int f50787m = ar.e(70.0f);
    private static final int C = ar.e(15.0f);
    private static final int D = ar.e(15.0f);
    private static final int E = ar.e(7.0f);
    private static final int F = ar.e(8.0f);
    public static int G = 3;
    public static int H = 4;
    public static int I = 1;
    public static int J = 2;

    /* loaded from: classes39.dex */
    class a implements ListView.OnScrollChangeListener {
        a() {
        }

        @Override // com.tencent.widget.ListView.OnScrollChangeListener
        public void onScrollChanged(int i3, int i16, int i17) {
            b.C0432b item;
            if (HomePageTimeLineView.this.f50788d == null || (item = HomePageTimeLineView.this.f50788d.getItem(i3)) == null) {
                return;
            }
            HomePageTimeLineView.this.f50789e.setText(item.f50806a + com.qzone.util.l.a(R.string.n8l));
        }
    }

    /* loaded from: classes39.dex */
    public interface c {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            HomePageTimeLineView.c(HomePageTimeLineView.this);
        }
    }

    public HomePageTimeLineView(Context context) {
        super(context);
        this.f50792i = new a();
        j();
    }

    static /* bridge */ /* synthetic */ c c(HomePageTimeLineView homePageTimeLineView) {
        homePageTimeLineView.getClass();
        return null;
    }

    public void j() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bv_, this);
        this.f50790f = (ListView) inflate.findViewById(R.id.f166980jm1);
        this.f50789e = (TextView) inflate.findViewById(R.id.f166981jm2);
        b bVar = new b(getContext());
        this.f50788d = bVar;
        this.f50790f.setAdapter((ListAdapter) bVar);
        this.f50790f.setOnItemClickListener(new d());
        this.f50790f.setOnScrollChangeListener(this.f50792i);
        this.f50790f.setBackgroundResource(0);
    }

    public void setData(ProfileTimeLine profileTimeLine) {
        b bVar = this.f50788d;
        if (bVar != null) {
            bVar.b(profileTimeLine);
        }
    }

    public void setPaddingForTimeLineHeader(Activity activity) {
        this.f50789e.setPadding(0, SystemUtil.getNotchHeight(getContext(), activity), 0, 0);
    }

    public void setSelection(long j3) {
        b bVar = this.f50788d;
        if (bVar != null) {
            bVar.c(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private CopyOnWriteArrayList<C0432b> f50794d = new CopyOnWriteArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        private Context f50795e;

        /* renamed from: f, reason: collision with root package name */
        private final int f50796f;

        /* renamed from: h, reason: collision with root package name */
        private final int f50797h;

        /* loaded from: classes39.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            RelativeLayout f50799a;

            /* renamed from: b, reason: collision with root package name */
            TextView f50800b;

            /* renamed from: c, reason: collision with root package name */
            TextView f50801c;

            /* renamed from: d, reason: collision with root package name */
            TextView f50802d;

            /* renamed from: e, reason: collision with root package name */
            LinearLayout f50803e;

            /* renamed from: f, reason: collision with root package name */
            View f50804f;

            public a() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.qzone.proxy.feedcomponent.ui.HomePageTimeLineView$b$b, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        public class C0432b {

            /* renamed from: a, reason: collision with root package name */
            int f50806a;

            /* renamed from: b, reason: collision with root package name */
            int f50807b;

            /* renamed from: c, reason: collision with root package name */
            int f50808c;

            /* renamed from: d, reason: collision with root package name */
            int f50809d;

            /* renamed from: e, reason: collision with root package name */
            boolean f50810e;

            C0432b() {
            }
        }

        b(Context context) {
            this.f50795e = context;
            Resources resources = context.getResources();
            this.f50796f = resources.getColor(R.color.qzone_skin_homepage_timeline_text_color_normal);
            this.f50797h = resources.getColor(R.color.qzone_skin_homepage_timeline_text_color_selected);
        }

        void c(long j3) {
            if (this.f50794d == null || j3 <= 0) {
                return;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j3);
            int i3 = calendar.get(1);
            int i16 = calendar.get(2) + 1;
            for (int i17 = 0; i17 < this.f50794d.size(); i17++) {
                C0432b c0432b = this.f50794d.get(i17);
                if (c0432b != null) {
                    if (c0432b.f50806a == i3 && c0432b.f50807b == i16 && c0432b.f50809d == HomePageTimeLineView.I) {
                        c0432b.f50810e = true;
                        HomePageTimeLineView.this.f50791h = i17;
                    } else {
                        c0432b.f50810e = false;
                    }
                }
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            CopyOnWriteArrayList<C0432b> copyOnWriteArrayList = this.f50794d;
            if (copyOnWriteArrayList != null) {
                return copyOnWriteArrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        public void b(ProfileTimeLine profileTimeLine) {
            if (profileTimeLine == null || profileTimeLine.timeLines == null) {
                return;
            }
            this.f50794d.clear();
            ArrayList arrayList = new ArrayList(profileTimeLine.timeLines.keySet());
            Collections.sort(arrayList, Collections.reverseOrder());
            Iterator it = arrayList.iterator();
            boolean z16 = true;
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                if (!z16) {
                    C0432b c0432b = new C0432b();
                    c0432b.f50809d = HomePageTimeLineView.J;
                    c0432b.f50808c = HomePageTimeLineView.G;
                    c0432b.f50806a = num.intValue();
                    this.f50794d.add(c0432b);
                }
                ArrayList<Integer> arrayList2 = profileTimeLine.timeLines.get(num);
                Collections.sort(arrayList2, Collections.reverseOrder());
                Iterator<Integer> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    Integer next = it5.next();
                    C0432b c0432b2 = new C0432b();
                    c0432b2.f50809d = HomePageTimeLineView.I;
                    c0432b2.f50808c = HomePageTimeLineView.H;
                    c0432b2.f50806a = num.intValue();
                    c0432b2.f50807b = next.intValue();
                    this.f50794d.add(c0432b2);
                }
                z16 = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f50795e).inflate(R.layout.bva, (ViewGroup) null);
                aVar = new a();
                aVar.f50799a = (RelativeLayout) view.findViewById(R.id.dpq);
                aVar.f50800b = (TextView) view.findViewById(R.id.jji);
                aVar.f50801c = (TextView) view.findViewById(R.id.ezf);
                TextView textView = (TextView) view.findViewById(R.id.ezg);
                aVar.f50802d = textView;
                textView.setFocusable(true);
                aVar.f50802d.setFocusableInTouchMode(true);
                aVar.f50802d.requestFocus();
                aVar.f50802d.requestFocusFromTouch();
                aVar.f50803e = (LinearLayout) view.findViewById(R.id.eze);
                aVar.f50804f = view.findViewById(R.id.l6j);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            C0432b item = getItem(i3);
            if (item != null) {
                ViewGroup.LayoutParams layoutParams = aVar.f50799a.getLayoutParams();
                int i16 = item.f50808c;
                if (i16 == HomePageTimeLineView.H) {
                    aVar.f50801c.setText(String.valueOf(item.f50807b));
                    aVar.f50803e.setVisibility(0);
                    aVar.f50800b.setVisibility(8);
                    aVar.f50804f.setVisibility(8);
                    if (item.f50810e) {
                        aVar.f50801c.setTextColor(this.f50797h);
                        aVar.f50801c.setTextSize(50.0f);
                        aVar.f50802d.setTextColor(this.f50797h);
                        aVar.f50802d.setTextSize(16.0f);
                        if (layoutParams != null) {
                            layoutParams.height = HomePageTimeLineView.f50787m + HomePageTimeLineView.E + HomePageTimeLineView.F;
                        }
                        aVar.f50803e.setPadding(0, 0, 0, 0);
                        view.setBackgroundResource(R.drawable.qzone_skin_homepage_timeline_item_selected_bg);
                    } else {
                        aVar.f50801c.setTextColor(this.f50796f);
                        aVar.f50801c.setTextSize(25.0f);
                        aVar.f50802d.setTextColor(this.f50796f);
                        aVar.f50802d.setTextSize(12.0f);
                        if (layoutParams != null) {
                            layoutParams.height = -2;
                        }
                        int i17 = HomePageTimeLineView.C;
                        C0432b item2 = getItem(i3 - 1);
                        if (item2 != null && item2.f50810e) {
                            i17 -= HomePageTimeLineView.F;
                        }
                        int i18 = HomePageTimeLineView.D;
                        C0432b item3 = getItem(i3 + 1);
                        if (item3 != null && item3.f50810e) {
                            i18 -= HomePageTimeLineView.E;
                        }
                        aVar.f50803e.setPadding(0, i17, 0, i18);
                        view.setBackgroundResource(0);
                    }
                } else if (i16 == HomePageTimeLineView.G) {
                    aVar.f50800b.setText(item.f50806a + com.qzone.util.l.a(R.string.n8s));
                    aVar.f50800b.setVisibility(0);
                    aVar.f50803e.setVisibility(8);
                    aVar.f50804f.setVisibility(0);
                    if (layoutParams != null) {
                        layoutParams.height = -2;
                    }
                    view.setBackgroundResource(0);
                }
                if (layoutParams != null) {
                    aVar.f50799a.setLayoutParams(layoutParams);
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0432b getItem(int i3) {
            CopyOnWriteArrayList<C0432b> copyOnWriteArrayList;
            if (i3 < 0 || i3 >= getCount() || (copyOnWriteArrayList = this.f50794d) == null || copyOnWriteArrayList.isEmpty()) {
                return null;
            }
            return this.f50794d.get(i3);
        }
    }

    public HomePageTimeLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f50792i = new a();
        j();
    }

    public HomePageTimeLineView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f50792i = new a();
        j();
    }

    public void setTimeLineListener(c cVar) {
    }
}
