package com.qzone.album.business.photolist.ui.timeline.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.qzone.album.data.model.TimeLine;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.proxy.feedcomponent.widget.SafeTextView;
import com.qzone.util.l;
import com.qzone.widget.CommonLine;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.mobileqq.R;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes39.dex */
public class ParentingPhotoTimeLineView extends AbstractTimeLineView {
    public static int E = 46;
    public static int F = 36;
    public static int G = 50;
    public static int H = 10;
    public static int I = 1;
    public static int J = 2;
    public static int K = 3;
    public static int L = 4;
    public static int M = 5;
    public static int N = 6;
    public static int P = 1;
    public static int Q = 2;
    public static int R = 3;
    public static int S = 4;
    public static int T = 5;
    private ArrayList<TimeLine> C;
    private long D;

    /* renamed from: f, reason: collision with root package name */
    private View f43795f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f43796h;

    /* renamed from: i, reason: collision with root package name */
    private QZonePullToRefreshListView f43797i;

    /* renamed from: m, reason: collision with root package name */
    private b f43798m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            Object itemAtPosition = adapterView.getItemAtPosition(i3);
            if (itemAtPosition == null || !(itemAtPosition instanceof b.C0349b)) {
                return;
            }
            b.C0349b c0349b = (b.C0349b) itemAtPosition;
            ParentingPhotoTimeLineView parentingPhotoTimeLineView = ParentingPhotoTimeLineView.this;
            if (parentingPhotoTimeLineView.f43743d != null) {
                parentingPhotoTimeLineView.f43798m.d(c0349b);
                ParentingPhotoTimeLineView.this.f43743d.c(c0349b.f43813a);
            }
        }
    }

    public ParentingPhotoTimeLineView(Context context) {
        super(context);
        this.C = new ArrayList<>();
        f();
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void b() {
        b bVar = this.f43798m;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void f() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bvb, this);
        this.f43795f = inflate;
        this.f43797i = (QZonePullToRefreshListView) inflate.findViewById(R.id.f166980jm1);
        RelativeLayout relativeLayout = (RelativeLayout) this.f43795f.findViewById(R.id.f166979jm0);
        this.f43796h = relativeLayout;
        relativeLayout.setAlpha(0.9f);
        this.f43798m = new b(getContext());
        this.f43797i.j0().setAdapter((ListAdapter) this.f43798m);
        this.f43797i.j0().setOnItemClickListener(new a());
        this.f43797i.setBackgroundResource(0);
        this.f43797i.setSupportPullDown(false);
        this.f43744e = new n4.b();
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void setLoverAndParentingData(ArrayList<TimeLine> arrayList, long j3) {
        ((n4.b) this.f43744e).m(arrayList);
        this.C = arrayList;
        this.f43798m.setData(arrayList);
        this.D = j3;
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void setSelection(long j3) {
        b bVar = this.f43798m;
        if (bVar != null) {
            bVar.c(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<C0349b> f43800d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        private Context f43801e;

        /* loaded from: classes39.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            RelativeLayout f43803a;

            /* renamed from: b, reason: collision with root package name */
            RelativeLayout f43804b;

            /* renamed from: c, reason: collision with root package name */
            RelativeLayout f43805c;

            /* renamed from: d, reason: collision with root package name */
            SafeTextView f43806d;

            /* renamed from: e, reason: collision with root package name */
            SafeTextView f43807e;

            /* renamed from: f, reason: collision with root package name */
            SafeTextView f43808f;

            /* renamed from: g, reason: collision with root package name */
            CommonLine f43809g;

            /* renamed from: h, reason: collision with root package name */
            CommonLine f43810h;

            /* renamed from: i, reason: collision with root package name */
            ImageView f43811i;

            public a() {
            }
        }

        /* renamed from: com.qzone.album.business.photolist.ui.timeline.view.ParentingPhotoTimeLineView$b$b, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        public class C0349b {

            /* renamed from: a, reason: collision with root package name */
            TimeLine f43813a;

            /* renamed from: e, reason: collision with root package name */
            int f43817e;

            /* renamed from: f, reason: collision with root package name */
            int f43818f;

            /* renamed from: b, reason: collision with root package name */
            String f43814b = "";

            /* renamed from: c, reason: collision with root package name */
            String f43815c = "";

            /* renamed from: d, reason: collision with root package name */
            String f43816d = "";

            /* renamed from: g, reason: collision with root package name */
            boolean f43819g = false;

            public C0349b() {
            }
        }

        public b(Context context) {
            this.f43801e = context;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0349b getItem(int i3) {
            ArrayList<C0349b> arrayList = this.f43800d;
            if (arrayList != null) {
                return arrayList.get(i3);
            }
            return null;
        }

        public void c(long j3) {
            TimeLine timeLine;
            ArrayList<C0349b> arrayList = this.f43800d;
            if (arrayList == null || j3 <= 0) {
                return;
            }
            Iterator<C0349b> it = arrayList.iterator();
            while (it.hasNext()) {
                C0349b next = it.next();
                if (next != null && (timeLine = next.f43813a) != null) {
                    if (timeLine.beginTime <= j3 && timeLine.endTime >= j3 && next.f43818f == ParentingPhotoTimeLineView.P) {
                        next.f43819g = true;
                    } else {
                        next.f43819g = false;
                    }
                }
            }
            notifyDataSetChanged();
        }

        public void d(C0349b c0349b) {
            TimeLine timeLine;
            TimeLine timeLine2;
            ArrayList<C0349b> arrayList = this.f43800d;
            if (arrayList == null || c0349b == null) {
                return;
            }
            Iterator<C0349b> it = arrayList.iterator();
            while (it.hasNext()) {
                C0349b next = it.next();
                if (next != null && (timeLine = next.f43813a) != null && (timeLine2 = c0349b.f43813a) != null) {
                    if (timeLine.beginTime == timeLine2.beginTime && timeLine.endTime == timeLine2.endTime && next.f43818f == c0349b.f43818f) {
                        next.f43819g = true;
                    } else {
                        next.f43819g = false;
                    }
                }
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<C0349b> arrayList = this.f43800d;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        private C0349b b(int i3) {
            if (i3 <= 0 || ParentingPhotoTimeLineView.this.C.size() <= i3 || ParentingPhotoTimeLineView.this.C.get(i3) == null) {
                return null;
            }
            int i16 = i3 - 1;
            if (ParentingPhotoTimeLineView.this.C.get(i16) == null) {
                return null;
            }
            long j3 = ((TimeLine) ParentingPhotoTimeLineView.this.C.get(i3)).showYear;
            long j16 = ((TimeLine) ParentingPhotoTimeLineView.this.C.get(i16)).showYear;
            if (j3 < 1 || j3 == j16) {
                if (j3 != 0 || j3 == j16) {
                    return null;
                }
                C0349b c0349b = new C0349b();
                c0349b.f43813a = (TimeLine) ParentingPhotoTimeLineView.this.C.get(i3);
                c0349b.f43814b = "";
                c0349b.f43815c = l.a(R.string.ozf);
                c0349b.f43816d = o4.b.b(ParentingPhotoTimeLineView.this.D, 0);
                c0349b.f43817e = ParentingPhotoTimeLineView.I;
                c0349b.f43818f = ParentingPhotoTimeLineView.Q;
                c0349b.f43819g = false;
                return c0349b;
            }
            C0349b c0349b2 = new C0349b();
            c0349b2.f43813a = (TimeLine) ParentingPhotoTimeLineView.this.C.get(i3);
            c0349b2.f43814b = "";
            c0349b2.f43815c = c0349b2.f43813a.showYear + l.a(R.string.oze);
            c0349b2.f43816d = o4.b.b(ParentingPhotoTimeLineView.this.D, c0349b2.f43813a.showYear);
            c0349b2.f43817e = ParentingPhotoTimeLineView.J;
            c0349b2.f43818f = ParentingPhotoTimeLineView.Q;
            c0349b2.f43819g = false;
            return c0349b2;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f43801e).inflate(R.layout.bvc, (ViewGroup) null);
                aVar = new a();
                aVar.f43803a = (RelativeLayout) view.findViewById(R.id.dpq);
                aVar.f43804b = (RelativeLayout) view.findViewById(R.id.jg5);
                aVar.f43805c = (RelativeLayout) view.findViewById(R.id.d_8);
                aVar.f43811i = (ImageView) view.findViewById(R.id.f165733da3);
                aVar.f43809g = (CommonLine) view.findViewById(R.id.d_q);
                aVar.f43810h = (CommonLine) view.findViewById(R.id.d_p);
                aVar.f43806d = (SafeTextView) view.findViewById(R.id.f166963jg2);
                aVar.f43807e = (SafeTextView) view.findViewById(R.id.jg9);
                aVar.f43808f = (SafeTextView) view.findViewById(R.id.f166965jh1);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            C0349b item = getItem(i3);
            if (item == null) {
                return view;
            }
            aVar.f43804b.setVisibility(0);
            aVar.f43805c.setVisibility(0);
            RelativeLayout relativeLayout = aVar.f43803a;
            if (relativeLayout != null) {
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new AbsListView.LayoutParams(-1, -2);
                }
                int i16 = item.f43818f;
                if (i16 != ParentingPhotoTimeLineView.Q && i16 != ParentingPhotoTimeLineView.R) {
                    if (i16 == ParentingPhotoTimeLineView.P) {
                        layoutParams.height = u4.a.z().o(ParentingPhotoTimeLineView.F);
                    } else if (i16 == ParentingPhotoTimeLineView.S) {
                        layoutParams.height = u4.a.z().o(ParentingPhotoTimeLineView.G);
                    } else if (i16 == ParentingPhotoTimeLineView.T) {
                        layoutParams.height = u4.a.z().o(ParentingPhotoTimeLineView.H);
                    }
                } else {
                    layoutParams.height = u4.a.z().o(ParentingPhotoTimeLineView.E);
                }
                aVar.f43803a.setLayoutParams(layoutParams);
            }
            if (item.f43819g) {
                aVar.f43806d.setTextColor(ParentingPhotoTimeLineView.this.getResources().getColor(R.color.f156956g4));
                aVar.f43807e.setTextColor(ParentingPhotoTimeLineView.this.getResources().getColor(R.color.f156956g4));
                aVar.f43808f.setTextColor(ParentingPhotoTimeLineView.this.getResources().getColor(R.color.f156956g4));
            } else {
                aVar.f43806d.setTextColor(ParentingPhotoTimeLineView.this.getResources().getColorStateList(R.color.a_j));
                aVar.f43807e.setTextColor(ParentingPhotoTimeLineView.this.getResources().getColorStateList(R.color.a_j));
                aVar.f43808f.setTextColor(ParentingPhotoTimeLineView.this.getResources().getColorStateList(R.color.a_j));
            }
            int i17 = item.f43817e;
            if (i17 == ParentingPhotoTimeLineView.L) {
                if (item.f43819g) {
                    aVar.f43811i.setBackgroundResource(R.drawable.gts);
                } else {
                    aVar.f43811i.setBackgroundResource(R.drawable.gtw);
                }
                aVar.f43806d.setText(item.f43814b);
                aVar.f43806d.setVisibility(0);
                aVar.f43807e.setVisibility(8);
                aVar.f43808f.setVisibility(8);
            } else if (i17 == ParentingPhotoTimeLineView.K) {
                aVar.f43811i.setBackgroundResource(R.drawable.gtv);
                aVar.f43806d.setText(item.f43814b);
                aVar.f43806d.setVisibility(8);
                aVar.f43807e.setText(item.f43815c);
                aVar.f43807e.setVisibility(0);
                aVar.f43808f.setText(item.f43816d);
                aVar.f43808f.setVisibility(0);
            } else if (i17 == ParentingPhotoTimeLineView.J) {
                aVar.f43811i.setBackgroundResource(R.drawable.gtt);
                aVar.f43806d.setText(item.f43814b);
                aVar.f43806d.setVisibility(8);
                aVar.f43807e.setText(item.f43815c);
                aVar.f43807e.setVisibility(0);
                aVar.f43808f.setText(item.f43816d);
                aVar.f43808f.setVisibility(0);
            } else if (i17 == ParentingPhotoTimeLineView.I) {
                aVar.f43811i.setBackgroundResource(R.drawable.gtu);
                aVar.f43806d.setText(item.f43814b);
                aVar.f43806d.setVisibility(8);
                aVar.f43807e.setText(item.f43815c);
                aVar.f43807e.setVisibility(0);
                aVar.f43808f.setText(item.f43816d);
                aVar.f43808f.setVisibility(0);
            } else if (i17 == ParentingPhotoTimeLineView.M || i17 == ParentingPhotoTimeLineView.N) {
                aVar.f43804b.setVisibility(8);
                aVar.f43805c.setVisibility(8);
            }
            return view;
        }

        public void setData(ArrayList<TimeLine> arrayList) {
            int i3;
            if (arrayList == null) {
                return;
            }
            this.f43800d.clear();
            int size = arrayList.size();
            C0349b c0349b = new C0349b();
            if (size > 0) {
                c0349b.f43813a = arrayList.get(size - 1);
            } else {
                c0349b.f43813a = null;
            }
            c0349b.f43818f = ParentingPhotoTimeLineView.R;
            c0349b.f43817e = ParentingPhotoTimeLineView.K;
            c0349b.f43814b = "";
            c0349b.f43815c = l.a(R.string.ozg);
            c0349b.f43816d = o4.b.a();
            c0349b.f43819g = false;
            this.f43800d.add(c0349b);
            if (size == 1 && ParentingPhotoTimeLineView.this.D != 0 && QZoneAlbumUtil.e(System.currentTimeMillis(), ParentingPhotoTimeLineView.this.D)) {
                C0349b c0349b2 = new C0349b();
                c0349b2.f43818f = ParentingPhotoTimeLineView.T;
                c0349b2.f43817e = ParentingPhotoTimeLineView.N;
                c0349b2.f43814b = "";
                c0349b2.f43815c = "";
                c0349b2.f43816d = "";
                c0349b2.f43819g = false;
                this.f43800d.add(c0349b2);
                C0349b c0349b3 = new C0349b();
                c0349b3.f43813a = (TimeLine) ParentingPhotoTimeLineView.this.C.get(0);
                c0349b3.f43814b = "";
                c0349b3.f43815c = l.a(R.string.ozi);
                c0349b3.f43816d = o4.b.b(ParentingPhotoTimeLineView.this.D, 0);
                c0349b3.f43817e = ParentingPhotoTimeLineView.I;
                c0349b3.f43818f = ParentingPhotoTimeLineView.Q;
                c0349b3.f43819g = false;
                this.f43800d.add(c0349b3);
            }
            for (int i16 = size - 1; i16 >= 0; i16--) {
                TimeLine timeLine = arrayList.get(i16);
                if (timeLine != null && (i3 = timeLine.showYear) >= -1) {
                    if (i3 < 0 || timeLine.showMonth != 0 || timeLine.showWeek != 0 || timeLine.showDay != 0) {
                        C0349b c0349b4 = new C0349b();
                        c0349b4.f43813a = timeLine;
                        c0349b4.f43814b = timeLine.toShowAgeStr(8);
                        c0349b4.f43817e = ParentingPhotoTimeLineView.L;
                        c0349b4.f43818f = ParentingPhotoTimeLineView.P;
                        c0349b4.f43819g = false;
                        this.f43800d.add(c0349b4);
                    }
                    if (b(i16) != null) {
                        C0349b c0349b5 = new C0349b();
                        c0349b5.f43818f = ParentingPhotoTimeLineView.T;
                        c0349b5.f43817e = ParentingPhotoTimeLineView.N;
                        c0349b5.f43814b = "";
                        c0349b5.f43815c = "";
                        c0349b5.f43816d = "";
                        c0349b5.f43819g = false;
                        this.f43800d.add(c0349b5);
                        this.f43800d.add(b(i16));
                    }
                }
            }
            C0349b c0349b6 = new C0349b();
            c0349b6.f43818f = ParentingPhotoTimeLineView.S;
            c0349b6.f43817e = ParentingPhotoTimeLineView.M;
            c0349b6.f43814b = "";
            c0349b6.f43815c = "";
            c0349b6.f43816d = "";
            c0349b6.f43819g = false;
            this.f43800d.add(c0349b6);
            notifyDataSetChanged();
        }
    }

    public ParentingPhotoTimeLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = new ArrayList<>();
        f();
    }

    public ParentingPhotoTimeLineView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = new ArrayList<>();
        f();
    }
}
