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
public class LoversPhotoTimeLineView extends AbstractTimeLineView {
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
    private View f43745f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f43746h;

    /* renamed from: i, reason: collision with root package name */
    private QZonePullToRefreshListView f43747i;

    /* renamed from: m, reason: collision with root package name */
    private b f43748m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            Object itemAtPosition = adapterView.getItemAtPosition(i3);
            if (itemAtPosition == null || !(itemAtPosition instanceof b.C0347b)) {
                return;
            }
            b.C0347b c0347b = (b.C0347b) itemAtPosition;
            LoversPhotoTimeLineView.this.f43748m.d(c0347b);
            LoversPhotoTimeLineView.this.f43743d.c(c0347b.f43763a);
        }
    }

    public LoversPhotoTimeLineView(Context context) {
        super(context);
        this.C = new ArrayList<>();
        f();
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void b() {
        b bVar = this.f43748m;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void f() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bvb, this);
        this.f43745f = inflate;
        this.f43747i = (QZonePullToRefreshListView) inflate.findViewById(R.id.f166980jm1);
        RelativeLayout relativeLayout = (RelativeLayout) this.f43745f.findViewById(R.id.f166979jm0);
        this.f43746h = relativeLayout;
        relativeLayout.setAlpha(0.9f);
        this.f43748m = new b(getContext());
        this.f43747i.j0().setAdapter((ListAdapter) this.f43748m);
        this.f43747i.j0().setOnItemClickListener(new a());
        this.f43747i.setBackgroundResource(0);
        this.f43747i.setSupportPullDown(false);
        this.f43744e = new n4.b();
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void setLoverAndParentingData(ArrayList<TimeLine> arrayList, long j3) {
        ((n4.b) this.f43744e).m(arrayList);
        this.C = arrayList;
        this.f43748m.setData(arrayList);
        this.D = j3;
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void setSelection(long j3) {
        b bVar = this.f43748m;
        if (bVar != null) {
            bVar.c(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<C0347b> f43750d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        private Context f43751e;

        /* loaded from: classes39.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            RelativeLayout f43753a;

            /* renamed from: b, reason: collision with root package name */
            RelativeLayout f43754b;

            /* renamed from: c, reason: collision with root package name */
            RelativeLayout f43755c;

            /* renamed from: d, reason: collision with root package name */
            SafeTextView f43756d;

            /* renamed from: e, reason: collision with root package name */
            SafeTextView f43757e;

            /* renamed from: f, reason: collision with root package name */
            SafeTextView f43758f;

            /* renamed from: g, reason: collision with root package name */
            CommonLine f43759g;

            /* renamed from: h, reason: collision with root package name */
            CommonLine f43760h;

            /* renamed from: i, reason: collision with root package name */
            ImageView f43761i;

            public a() {
            }
        }

        /* renamed from: com.qzone.album.business.photolist.ui.timeline.view.LoversPhotoTimeLineView$b$b, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        public class C0347b {

            /* renamed from: a, reason: collision with root package name */
            TimeLine f43763a;

            /* renamed from: e, reason: collision with root package name */
            int f43767e;

            /* renamed from: f, reason: collision with root package name */
            int f43768f;

            /* renamed from: b, reason: collision with root package name */
            String f43764b = "";

            /* renamed from: c, reason: collision with root package name */
            String f43765c = "";

            /* renamed from: d, reason: collision with root package name */
            String f43766d = "";

            /* renamed from: g, reason: collision with root package name */
            boolean f43769g = false;

            public C0347b() {
            }
        }

        public b(Context context) {
            this.f43751e = context;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0347b getItem(int i3) {
            ArrayList<C0347b> arrayList = this.f43750d;
            if (arrayList != null) {
                return arrayList.get(i3);
            }
            return null;
        }

        public void c(long j3) {
            TimeLine timeLine;
            ArrayList<C0347b> arrayList = this.f43750d;
            if (arrayList == null || j3 <= 0) {
                return;
            }
            Iterator<C0347b> it = arrayList.iterator();
            while (it.hasNext()) {
                C0347b next = it.next();
                if (next != null && (timeLine = next.f43763a) != null) {
                    if (timeLine.beginTime <= j3 && timeLine.endTime >= j3 && next.f43768f == LoversPhotoTimeLineView.P) {
                        next.f43769g = true;
                    } else {
                        next.f43769g = false;
                    }
                }
            }
            notifyDataSetChanged();
        }

        public void d(C0347b c0347b) {
            TimeLine timeLine;
            TimeLine timeLine2;
            ArrayList<C0347b> arrayList = this.f43750d;
            if (arrayList == null || c0347b == null) {
                return;
            }
            Iterator<C0347b> it = arrayList.iterator();
            while (it.hasNext()) {
                C0347b next = it.next();
                if (next != null && (timeLine = next.f43763a) != null && (timeLine2 = c0347b.f43763a) != null) {
                    if (timeLine.beginTime == timeLine2.beginTime && timeLine.endTime == timeLine2.endTime && next.f43768f == c0347b.f43768f) {
                        next.f43769g = true;
                    } else {
                        next.f43769g = false;
                    }
                }
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<C0347b> arrayList = this.f43750d;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        private C0347b b(int i3) {
            if (i3 <= 0 || LoversPhotoTimeLineView.this.C.size() <= i3 || LoversPhotoTimeLineView.this.C.get(i3) == null) {
                return null;
            }
            int i16 = i3 - 1;
            if (LoversPhotoTimeLineView.this.C.get(i16) == null) {
                return null;
            }
            long j3 = ((TimeLine) LoversPhotoTimeLineView.this.C.get(i3)).showYear;
            long j16 = ((TimeLine) LoversPhotoTimeLineView.this.C.get(i16)).showYear;
            if (j3 < 1 || j3 == j16) {
                if (j3 != 0 || j3 == j16) {
                    return null;
                }
                C0347b c0347b = new C0347b();
                c0347b.f43763a = (TimeLine) LoversPhotoTimeLineView.this.C.get(i3);
                c0347b.f43764b = "";
                c0347b.f43765c = l.a(R.string.nw9);
                c0347b.f43766d = o4.b.b(LoversPhotoTimeLineView.this.D, 0);
                c0347b.f43767e = LoversPhotoTimeLineView.I;
                c0347b.f43768f = LoversPhotoTimeLineView.Q;
                c0347b.f43769g = false;
                return c0347b;
            }
            C0347b c0347b2 = new C0347b();
            c0347b2.f43763a = (TimeLine) LoversPhotoTimeLineView.this.C.get(i3);
            c0347b2.f43764b = "";
            c0347b2.f43765c = c0347b2.f43763a.showYear + l.a(R.string.nw6);
            c0347b2.f43766d = o4.b.b(LoversPhotoTimeLineView.this.D, c0347b2.f43763a.showYear);
            c0347b2.f43767e = LoversPhotoTimeLineView.J;
            c0347b2.f43768f = LoversPhotoTimeLineView.Q;
            c0347b2.f43769g = false;
            return c0347b2;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f43751e).inflate(R.layout.bvc, (ViewGroup) null);
                aVar = new a();
                aVar.f43753a = (RelativeLayout) view.findViewById(R.id.dpq);
                aVar.f43754b = (RelativeLayout) view.findViewById(R.id.jg5);
                aVar.f43755c = (RelativeLayout) view.findViewById(R.id.d_8);
                aVar.f43761i = (ImageView) view.findViewById(R.id.f165733da3);
                aVar.f43759g = (CommonLine) view.findViewById(R.id.d_q);
                aVar.f43760h = (CommonLine) view.findViewById(R.id.d_p);
                aVar.f43756d = (SafeTextView) view.findViewById(R.id.f166963jg2);
                aVar.f43757e = (SafeTextView) view.findViewById(R.id.jg9);
                aVar.f43758f = (SafeTextView) view.findViewById(R.id.f166965jh1);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            C0347b item = getItem(i3);
            if (item == null) {
                return view;
            }
            aVar.f43754b.setVisibility(0);
            aVar.f43755c.setVisibility(0);
            RelativeLayout relativeLayout = aVar.f43753a;
            if (relativeLayout != null) {
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new AbsListView.LayoutParams(-1, -2);
                }
                int i16 = item.f43768f;
                if (i16 != LoversPhotoTimeLineView.Q && i16 != LoversPhotoTimeLineView.R) {
                    if (i16 == LoversPhotoTimeLineView.P) {
                        layoutParams.height = u4.a.z().o(LoversPhotoTimeLineView.F);
                    } else if (i16 == LoversPhotoTimeLineView.S) {
                        layoutParams.height = u4.a.z().o(LoversPhotoTimeLineView.G);
                    } else if (i16 == LoversPhotoTimeLineView.T) {
                        layoutParams.height = u4.a.z().o(LoversPhotoTimeLineView.H);
                    }
                } else {
                    layoutParams.height = u4.a.z().o(LoversPhotoTimeLineView.E);
                }
                aVar.f43753a.setLayoutParams(layoutParams);
            }
            if (item.f43769g) {
                aVar.f43756d.setTextColor(LoversPhotoTimeLineView.this.getResources().getColor(R.color.f156955g3));
                aVar.f43757e.setTextColor(LoversPhotoTimeLineView.this.getResources().getColor(R.color.f156955g3));
                aVar.f43758f.setTextColor(LoversPhotoTimeLineView.this.getResources().getColor(R.color.f156955g3));
            } else {
                aVar.f43756d.setTextColor(LoversPhotoTimeLineView.this.getResources().getColorStateList(R.color.a_j));
                aVar.f43757e.setTextColor(LoversPhotoTimeLineView.this.getResources().getColorStateList(R.color.a_j));
                aVar.f43758f.setTextColor(LoversPhotoTimeLineView.this.getResources().getColorStateList(R.color.a_j));
            }
            int i17 = item.f43767e;
            if (i17 == LoversPhotoTimeLineView.L) {
                if (item.f43769g) {
                    aVar.f43761i.setBackgroundResource(R.drawable.gts);
                } else {
                    aVar.f43761i.setBackgroundResource(R.drawable.gtw);
                }
                aVar.f43756d.setText(item.f43764b);
                aVar.f43756d.setVisibility(0);
                aVar.f43757e.setVisibility(8);
                aVar.f43758f.setVisibility(8);
            } else if (i17 == LoversPhotoTimeLineView.K) {
                aVar.f43761i.setBackgroundResource(R.drawable.fw9);
                aVar.f43756d.setText(item.f43764b);
                aVar.f43756d.setVisibility(8);
                aVar.f43757e.setText(item.f43765c);
                aVar.f43757e.setVisibility(0);
                aVar.f43758f.setText(item.f43766d);
                aVar.f43758f.setVisibility(0);
            } else if (i17 == LoversPhotoTimeLineView.J) {
                aVar.f43761i.setBackgroundResource(R.drawable.fw7);
                aVar.f43756d.setText(item.f43764b);
                aVar.f43756d.setVisibility(8);
                aVar.f43757e.setText(item.f43765c);
                aVar.f43757e.setVisibility(0);
                aVar.f43758f.setText(item.f43766d);
                aVar.f43758f.setVisibility(0);
            } else if (i17 == LoversPhotoTimeLineView.I) {
                aVar.f43761i.setBackgroundResource(R.drawable.fw8);
                aVar.f43756d.setText(item.f43764b);
                aVar.f43756d.setVisibility(8);
                aVar.f43757e.setText(item.f43765c);
                aVar.f43757e.setVisibility(0);
                aVar.f43758f.setText(item.f43766d);
                aVar.f43758f.setVisibility(0);
            } else if (i17 == LoversPhotoTimeLineView.M || i17 == LoversPhotoTimeLineView.N) {
                aVar.f43754b.setVisibility(8);
                aVar.f43755c.setVisibility(8);
            }
            return view;
        }

        public void setData(ArrayList<TimeLine> arrayList) {
            int i3;
            if (arrayList == null) {
                return;
            }
            this.f43750d.clear();
            int size = arrayList.size();
            C0347b c0347b = new C0347b();
            if (size > 0) {
                c0347b.f43763a = arrayList.get(size - 1);
            } else {
                c0347b.f43763a = null;
            }
            c0347b.f43768f = LoversPhotoTimeLineView.R;
            c0347b.f43767e = LoversPhotoTimeLineView.K;
            c0347b.f43764b = "";
            c0347b.f43765c = l.a(R.string.nw5);
            c0347b.f43766d = o4.b.a();
            c0347b.f43769g = false;
            this.f43750d.add(c0347b);
            if (size == 1 && LoversPhotoTimeLineView.this.D != 0 && QZoneAlbumUtil.e(System.currentTimeMillis(), LoversPhotoTimeLineView.this.D)) {
                C0347b c0347b2 = new C0347b();
                c0347b2.f43768f = LoversPhotoTimeLineView.T;
                c0347b2.f43767e = LoversPhotoTimeLineView.N;
                c0347b2.f43764b = "";
                c0347b2.f43765c = "";
                c0347b2.f43766d = "";
                c0347b2.f43769g = false;
                this.f43750d.add(c0347b2);
                C0347b c0347b3 = new C0347b();
                c0347b3.f43763a = (TimeLine) LoversPhotoTimeLineView.this.C.get(0);
                c0347b3.f43764b = "";
                c0347b3.f43765c = l.a(R.string.nw7);
                c0347b3.f43766d = o4.b.b(LoversPhotoTimeLineView.this.D, 0);
                c0347b3.f43767e = LoversPhotoTimeLineView.I;
                c0347b3.f43768f = LoversPhotoTimeLineView.Q;
                c0347b3.f43769g = false;
                this.f43750d.add(c0347b3);
            }
            for (int i16 = size - 1; i16 >= 0; i16--) {
                TimeLine timeLine = arrayList.get(i16);
                if (timeLine != null && (i3 = timeLine.showYear) >= -1) {
                    if (i3 < 0 || timeLine.showMonth != 0 || timeLine.showWeek != 0 || timeLine.showDay != 0) {
                        C0347b c0347b4 = new C0347b();
                        c0347b4.f43763a = timeLine;
                        c0347b4.f43764b = timeLine.toShowAgeStr(11);
                        c0347b4.f43767e = LoversPhotoTimeLineView.L;
                        c0347b4.f43768f = LoversPhotoTimeLineView.P;
                        c0347b4.f43769g = false;
                        this.f43750d.add(c0347b4);
                    }
                    if (b(i16) != null) {
                        C0347b c0347b5 = new C0347b();
                        c0347b5.f43768f = LoversPhotoTimeLineView.T;
                        c0347b5.f43767e = LoversPhotoTimeLineView.N;
                        c0347b5.f43764b = "";
                        c0347b5.f43765c = "";
                        c0347b5.f43766d = "";
                        c0347b5.f43769g = false;
                        this.f43750d.add(c0347b5);
                        this.f43750d.add(b(i16));
                    }
                }
            }
            C0347b c0347b6 = new C0347b();
            c0347b6.f43768f = LoversPhotoTimeLineView.S;
            c0347b6.f43767e = LoversPhotoTimeLineView.M;
            c0347b6.f43764b = "";
            c0347b6.f43765c = "";
            c0347b6.f43766d = "";
            c0347b6.f43769g = false;
            this.f43750d.add(c0347b6);
            notifyDataSetChanged();
        }
    }

    public LoversPhotoTimeLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = new ArrayList<>();
        f();
    }

    public LoversPhotoTimeLineView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = new ArrayList<>();
        f();
    }
}
