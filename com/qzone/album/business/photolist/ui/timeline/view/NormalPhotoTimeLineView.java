package com.qzone.album.business.photolist.ui.timeline.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.data.model.TimeLine;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import cooperation.qzone.util.SystemUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes39.dex */
public class NormalPhotoTimeLineView extends AbstractTimeLineView {
    private static final int F = ar.e(70.0f);
    private static final int G = ar.e(15.0f);
    private static final int H = ar.e(15.0f);
    private static final int I = ar.e(7.0f);
    private static final int J = ar.e(8.0f);
    public static int K = 3;
    public static int L = 4;
    public static int M = 1;
    public static int N = 2;
    private static final int P = Color.parseColor("#000000");
    private static final int Q = Color.parseColor("#00A3FF");
    private ArrayList<TimeLine> C;
    private int D;
    private ListView.OnScrollChangeListener E;

    /* renamed from: f, reason: collision with root package name */
    private TextView f43771f;

    /* renamed from: h, reason: collision with root package name */
    private ListView f43772h;

    /* renamed from: i, reason: collision with root package name */
    private b f43773i;

    /* renamed from: m, reason: collision with root package name */
    private int f43774m;

    /* loaded from: classes39.dex */
    class a implements ListView.OnScrollChangeListener {
        a() {
        }

        @Override // com.tencent.widget.ListView.OnScrollChangeListener
        public void onScrollChanged(int i3, int i16, int i17) {
            b.a item = NormalPhotoTimeLineView.this.f43773i.getItem(i3);
            if (item == null || item.f43779a == NormalPhotoTimeLineView.this.D) {
                return;
            }
            NormalPhotoTimeLineView.this.D = item.f43779a;
            NormalPhotoTimeLineView.this.f43771f.setText(String.format(Locale.getDefault(), "%d\u5e74", Integer.valueOf(NormalPhotoTimeLineView.this.D)));
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
            NormalPhotoTimeLineView normalPhotoTimeLineView = NormalPhotoTimeLineView.this;
            if (normalPhotoTimeLineView.f43743d == null || i3 == normalPhotoTimeLineView.f43774m || (item = NormalPhotoTimeLineView.this.f43773i.getItem(i3)) == null || item.f43782d != NormalPhotoTimeLineView.M) {
                return;
            }
            Calendar.getInstance().set(item.f43779a, item.f43780b, 1, 0, 0, 0);
            NormalPhotoTimeLineView.this.f43743d.a(item.f43784f, item.f43785g, i3);
            NormalPhotoTimeLineView.this.f43773i.e(view, i3);
        }
    }

    public NormalPhotoTimeLineView(Context context) {
        super(context);
        this.D = 0;
        this.E = new a();
        q();
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void b() {
        b bVar = this.f43773i;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void q() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bv_, this);
        this.f43772h = (ListView) inflate.findViewById(R.id.f166980jm1);
        this.f43771f = (TextView) inflate.findViewById(R.id.f166981jm2);
        b bVar = new b(getContext());
        this.f43773i = bVar;
        this.f43772h.setAdapter((ListAdapter) bVar);
        this.f43772h.setOnItemClickListener(new c());
        this.f43772h.setOnScrollChangeListener(this.E);
        this.f43772h.setBackgroundResource(0);
        this.f43744e = new n4.c();
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void setIsAscOrder(boolean z16) {
        ((n4.c) this.f43744e).o(z16);
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void setNormalData(ArrayList<TimeLine> arrayList, boolean z16) {
        ((n4.c) this.f43744e).m(arrayList);
        this.C = arrayList;
        this.f43773i.c(o4.c.a(arrayList), z16);
    }

    public void setPaddingForTimeLineHeader(Activity activity) {
        this.f43771f.setPadding(0, SystemUtil.getNotchHeight(getContext(), activity), 0, 0);
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void setSelection(long j3) {
        b bVar = this.f43773i;
        if (bVar != null) {
            bVar.d(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<a> f43776d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        private Context f43777e;

        /* loaded from: classes39.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            int f43779a;

            /* renamed from: b, reason: collision with root package name */
            int f43780b;

            /* renamed from: c, reason: collision with root package name */
            int f43781c;

            /* renamed from: d, reason: collision with root package name */
            int f43782d;

            /* renamed from: e, reason: collision with root package name */
            boolean f43783e;

            /* renamed from: f, reason: collision with root package name */
            long f43784f;

            /* renamed from: g, reason: collision with root package name */
            long f43785g;

            public a() {
            }
        }

        /* renamed from: com.qzone.album.business.photolist.ui.timeline.view.NormalPhotoTimeLineView$b$b, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        public class C0348b {

            /* renamed from: a, reason: collision with root package name */
            RelativeLayout f43787a;

            /* renamed from: b, reason: collision with root package name */
            TextView f43788b;

            /* renamed from: c, reason: collision with root package name */
            TextView f43789c;

            /* renamed from: d, reason: collision with root package name */
            TextView f43790d;

            /* renamed from: e, reason: collision with root package name */
            LinearLayout f43791e;

            /* renamed from: f, reason: collision with root package name */
            View f43792f;

            public C0348b() {
            }
        }

        public b(Context context) {
            this.f43777e = context;
        }

        private View b(int i3) {
            int firstVisiblePosition = NormalPhotoTimeLineView.this.f43772h.getFirstVisiblePosition();
            int childCount = (NormalPhotoTimeLineView.this.f43772h.getChildCount() + firstVisiblePosition) - 1;
            if (i3 < firstVisiblePosition || i3 > childCount) {
                return null;
            }
            return NormalPhotoTimeLineView.this.f43772h.getChildAt(i3 - firstVisiblePosition);
        }

        void d(long j3) {
            if (this.f43776d == null || j3 <= 0) {
                return;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j3 * 1000);
            int i3 = calendar.get(1);
            int i16 = calendar.get(2) + 1;
            for (int i17 = 0; i17 < this.f43776d.size(); i17++) {
                a aVar = this.f43776d.get(i17);
                if (aVar != null) {
                    if (aVar.f43779a == i3 && aVar.f43780b == i16 && aVar.f43782d == NormalPhotoTimeLineView.M) {
                        aVar.f43783e = true;
                        NormalPhotoTimeLineView.this.f43774m = i17;
                    } else {
                        aVar.f43783e = false;
                    }
                }
            }
            notifyDataSetChanged();
        }

        void e(View view, int i3) {
            if (i3 != NormalPhotoTimeLineView.this.f43774m && i3 >= 0 && i3 < getCount() && NormalPhotoTimeLineView.this.f43774m >= 0 && NormalPhotoTimeLineView.this.f43774m < getCount()) {
                this.f43776d.get(NormalPhotoTimeLineView.this.f43774m).f43783e = false;
                View b16 = b(NormalPhotoTimeLineView.this.f43774m);
                if (b16 != null && ((C0348b) b16.getTag()) != null) {
                    b16.setBackgroundResource(0);
                    b16.setBackgroundColor(-1);
                }
                NormalPhotoTimeLineView.this.f43774m = i3;
                this.f43776d.get(i3).f43783e = true;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<a> arrayList = this.f43776d;
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
            C0348b c0348b;
            if (view == null) {
                view = LayoutInflater.from(this.f43777e).inflate(R.layout.bva, (ViewGroup) null);
                c0348b = new C0348b();
                c0348b.f43787a = (RelativeLayout) view.findViewById(R.id.dpq);
                c0348b.f43788b = (TextView) view.findViewById(R.id.jji);
                c0348b.f43789c = (TextView) view.findViewById(R.id.ezf);
                c0348b.f43790d = (TextView) view.findViewById(R.id.ezg);
                c0348b.f43791e = (LinearLayout) view.findViewById(R.id.eze);
                c0348b.f43792f = view.findViewById(R.id.l6j);
                view.setTag(c0348b);
            } else {
                c0348b = (C0348b) view.getTag();
            }
            a item = getItem(i3);
            if (item != null) {
                ViewGroup.LayoutParams layoutParams = c0348b.f43787a.getLayoutParams();
                int i16 = item.f43781c;
                if (i16 == NormalPhotoTimeLineView.L) {
                    c0348b.f43789c.setText(String.valueOf(item.f43780b));
                    c0348b.f43791e.setVisibility(0);
                    c0348b.f43788b.setVisibility(8);
                    c0348b.f43792f.setVisibility(8);
                    if (item.f43783e) {
                        c0348b.f43789c.setTextColor(NormalPhotoTimeLineView.Q);
                        c0348b.f43789c.setTextSize(50.0f);
                        c0348b.f43790d.setTextColor(NormalPhotoTimeLineView.Q);
                        c0348b.f43790d.setTextSize(16.0f);
                        if (layoutParams != null) {
                            layoutParams.height = NormalPhotoTimeLineView.F + NormalPhotoTimeLineView.I + NormalPhotoTimeLineView.J;
                        }
                        c0348b.f43791e.setPadding(0, 0, 0, 0);
                        view.setBackgroundResource(R.drawable.qzone_skin_homepage_timeline_item_selected_bg);
                    } else {
                        c0348b.f43789c.setTextColor(NormalPhotoTimeLineView.P);
                        c0348b.f43789c.setTextSize(25.0f);
                        c0348b.f43790d.setTextColor(NormalPhotoTimeLineView.P);
                        c0348b.f43790d.setTextSize(12.0f);
                        if (layoutParams != null) {
                            layoutParams.height = -2;
                        }
                        int i17 = NormalPhotoTimeLineView.G;
                        a item2 = getItem(i3 - 1);
                        if (item2 != null && item2.f43783e) {
                            i17 -= NormalPhotoTimeLineView.J;
                        }
                        int i18 = NormalPhotoTimeLineView.H;
                        a item3 = getItem(i3 + 1);
                        if (item3 != null && item3.f43783e) {
                            i18 -= NormalPhotoTimeLineView.I;
                        }
                        c0348b.f43791e.setPadding(0, i17, 0, i18);
                        view.setBackgroundResource(0);
                    }
                } else if (i16 == NormalPhotoTimeLineView.K) {
                    c0348b.f43788b.setText(item.f43779a + l.a(R.string.f172241os0));
                    c0348b.f43788b.setVisibility(0);
                    c0348b.f43791e.setVisibility(8);
                    c0348b.f43792f.setVisibility(0);
                    if (layoutParams != null) {
                        layoutParams.height = -2;
                    }
                    view.setBackgroundResource(0);
                }
                if (layoutParams != null) {
                    c0348b.f43787a.setLayoutParams(layoutParams);
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a getItem(int i3) {
            ArrayList<a> arrayList;
            if (i3 < 0 || i3 >= getCount() || (arrayList = this.f43776d) == null || arrayList.isEmpty()) {
                return null;
            }
            return this.f43776d.get(i3);
        }

        public void c(HashMap<Integer, HashMap<Integer, ArrayList<TimeLine>>> hashMap, boolean z16) {
            if (hashMap == null) {
                return;
            }
            this.f43776d.clear();
            Object[] array = hashMap.keySet().toArray();
            if (array != null) {
                if (z16) {
                    Arrays.sort(array);
                } else {
                    Arrays.sort(array, Collections.reverseOrder());
                }
                boolean z17 = true;
                int i3 = 0;
                while (i3 < array.length) {
                    if (!z17) {
                        a aVar = new a();
                        aVar.f43782d = NormalPhotoTimeLineView.N;
                        aVar.f43781c = NormalPhotoTimeLineView.K;
                        aVar.f43779a = ((Integer) array[i3]).intValue();
                        this.f43776d.add(aVar);
                    }
                    Object[] array2 = hashMap.get(array[i3]).keySet().toArray();
                    if (array2 != null) {
                        if (z16) {
                            Arrays.sort(array2);
                        } else {
                            Arrays.sort(array2, Collections.reverseOrder());
                        }
                        for (int i16 = 0; i16 < array2.length; i16++) {
                            a aVar2 = new a();
                            Iterator<TimeLine> it = hashMap.get(array[i3]).get(array2[i16]).iterator();
                            while (it.hasNext()) {
                                TimeLine next = it.next();
                                long j3 = aVar2.f43784f;
                                if (j3 == 0 || next.beginTime < j3) {
                                    aVar2.f43784f = next.beginTime;
                                }
                                long j16 = aVar2.f43785g;
                                if (j16 == 0 || next.endTime > j16) {
                                    aVar2.f43785g = next.endTime;
                                }
                            }
                            aVar2.f43782d = NormalPhotoTimeLineView.M;
                            aVar2.f43781c = NormalPhotoTimeLineView.L;
                            aVar2.f43779a = ((Integer) array[i3]).intValue();
                            aVar2.f43780b = ((Integer) array2[i16]).intValue();
                            this.f43776d.add(aVar2);
                        }
                    }
                    i3++;
                    z17 = false;
                }
            }
            notifyDataSetChanged();
        }
    }

    public NormalPhotoTimeLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = 0;
        this.E = new a();
        q();
    }

    public NormalPhotoTimeLineView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = 0;
        this.E = new a();
        q();
    }
}
