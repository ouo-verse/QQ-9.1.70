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
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.album.util.g;
import com.qzone.proxy.feedcomponent.widget.SafeTextView;
import com.qzone.util.l;
import com.qzone.widget.CommonLine;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;
import n4.d;

/* loaded from: classes39.dex */
public class TravelPhotoTimeLineView extends AbstractTimeLineView {
    public static int E = 46;
    public static int F = 36;
    public static int G = 50;
    public static int H = 10;
    public static int I = 1;
    public static int J = 2;
    public static int K = 3;
    public static int L = 4;
    public static int M = 5;
    public static int N = 1;
    public static int P = 2;
    public static int Q = 3;
    public static int R = 4;
    public static int S = 5;
    private ArrayList<PhotoPoiArea> C;
    private long D;

    /* renamed from: f, reason: collision with root package name */
    private View f43847f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f43848h;

    /* renamed from: i, reason: collision with root package name */
    private QZonePullToRefreshListView f43849i;

    /* renamed from: m, reason: collision with root package name */
    private b f43850m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            Object itemAtPosition = adapterView.getItemAtPosition(i3);
            if (itemAtPosition == null || !(itemAtPosition instanceof b.C0351b)) {
                return;
            }
            b.C0351b c0351b = (b.C0351b) itemAtPosition;
            TravelPhotoTimeLineView travelPhotoTimeLineView = TravelPhotoTimeLineView.this;
            if (travelPhotoTimeLineView.f43743d != null) {
                travelPhotoTimeLineView.f43850m.e(c0351b);
                TravelPhotoTimeLineView.this.f43743d.b(c0351b.f43867a);
            }
        }
    }

    public TravelPhotoTimeLineView(Context context) {
        super(context);
        this.C = new ArrayList<>();
        f();
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void b() {
        b bVar = this.f43850m;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void f() {
        this.f43847f = LayoutInflater.from(getContext()).inflate(R.layout.bve, this);
        this.f43849i = (QZonePullToRefreshListView) findViewById(R.id.f166980jm1);
        RelativeLayout relativeLayout = (RelativeLayout) this.f43847f.findViewById(R.id.f166979jm0);
        this.f43848h = relativeLayout;
        relativeLayout.setAlpha(0.9f);
        this.f43849i.j0().setOnItemClickListener(new a());
        this.f43850m = new b(getContext());
        this.f43849i.j0().setAdapter((ListAdapter) this.f43850m);
        this.f43849i.setBackgroundResource(0);
        this.f43849i.setSupportPullDown(false);
        this.f43744e = new d();
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void setSelection(long j3) {
        b bVar = this.f43850m;
        if (bVar != null) {
            bVar.d(j3);
        }
    }

    @Override // com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView
    public void setTravelData(ArrayList<PhotoPoiArea> arrayList, long j3) {
        ((d) this.f43744e).m(arrayList);
        this.C = arrayList;
        this.f43850m.setData(arrayList);
        this.D = j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b extends BaseAdapter {

        /* renamed from: e, reason: collision with root package name */
        private long f43853e;

        /* renamed from: h, reason: collision with root package name */
        private Context f43855h;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<C0351b> f43852d = new ArrayList<>();

        /* renamed from: f, reason: collision with root package name */
        private String f43854f = "";

        /* loaded from: classes39.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            RelativeLayout f43857a;

            /* renamed from: b, reason: collision with root package name */
            RelativeLayout f43858b;

            /* renamed from: c, reason: collision with root package name */
            RelativeLayout f43859c;

            /* renamed from: d, reason: collision with root package name */
            SafeTextView f43860d;

            /* renamed from: e, reason: collision with root package name */
            SafeTextView f43861e;

            /* renamed from: f, reason: collision with root package name */
            SafeTextView f43862f;

            /* renamed from: g, reason: collision with root package name */
            CommonLine f43863g;

            /* renamed from: h, reason: collision with root package name */
            CommonLine f43864h;

            /* renamed from: i, reason: collision with root package name */
            ImageView f43865i;

            public a() {
            }
        }

        /* renamed from: com.qzone.album.business.photolist.ui.timeline.view.TravelPhotoTimeLineView$b$b, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        public class C0351b {

            /* renamed from: a, reason: collision with root package name */
            PhotoPoiArea f43867a;

            /* renamed from: e, reason: collision with root package name */
            int f43871e;

            /* renamed from: f, reason: collision with root package name */
            int f43872f;

            /* renamed from: b, reason: collision with root package name */
            String f43868b = "";

            /* renamed from: c, reason: collision with root package name */
            String f43869c = "";

            /* renamed from: d, reason: collision with root package name */
            String f43870d = "";

            /* renamed from: g, reason: collision with root package name */
            boolean f43873g = false;

            public C0351b() {
            }
        }

        public b(Context context) {
            this.f43855h = context;
        }

        private String a(long j3) {
            double d16 = (j3 - this.f43853e) / 8.64E7d;
            if (d16 >= 0.0d) {
                int ceil = (int) Math.ceil(d16);
                if (ceil == 0) {
                    return "DAY 1";
                }
                return "DAY " + ceil;
            }
            return l.a(R.string.f172798u93) + (-((int) Math.floor(d16))) + l.a(R.string.f172797u92);
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0351b getItem(int i3) {
            ArrayList<C0351b> arrayList = this.f43852d;
            if (arrayList != null) {
                return arrayList.get(i3);
            }
            return null;
        }

        public void d(long j3) {
            PhotoPoiArea photoPoiArea;
            ArrayList<C0351b> arrayList = this.f43852d;
            if (arrayList == null || j3 <= 0) {
                return;
            }
            Iterator<C0351b> it = arrayList.iterator();
            while (it.hasNext()) {
                C0351b next = it.next();
                if (next != null && (photoPoiArea = next.f43867a) != null) {
                    if (photoPoiArea.startShootTime <= j3 && photoPoiArea.endShootTime >= j3 && next.f43872f == TravelPhotoTimeLineView.K) {
                        next.f43873g = true;
                    } else {
                        next.f43873g = false;
                    }
                }
            }
            notifyDataSetChanged();
        }

        public void e(C0351b c0351b) {
            PhotoPoiArea photoPoiArea;
            PhotoPoiArea photoPoiArea2;
            ArrayList<C0351b> arrayList = this.f43852d;
            if (arrayList == null || c0351b == null) {
                return;
            }
            Iterator<C0351b> it = arrayList.iterator();
            while (it.hasNext()) {
                C0351b next = it.next();
                if (next != null && (photoPoiArea = next.f43867a) != null && (photoPoiArea2 = c0351b.f43867a) != null) {
                    if (photoPoiArea.startShootTime == photoPoiArea2.startShootTime && photoPoiArea.endShootTime == photoPoiArea2.endShootTime && next.f43872f == c0351b.f43872f) {
                        next.f43873g = true;
                    } else {
                        next.f43873g = false;
                    }
                }
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<C0351b> arrayList = this.f43852d;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        private C0351b c(int i3) {
            if (i3 < 0 || TravelPhotoTimeLineView.this.C.size() - 1 <= i3 || TravelPhotoTimeLineView.this.C.get(i3) == null) {
                return null;
            }
            int i16 = i3 + 1;
            if (TravelPhotoTimeLineView.this.C.get(i16) == null) {
                return null;
            }
            long j3 = ((PhotoPoiArea) TravelPhotoTimeLineView.this.C.get(i3)).startShootTime * 1000;
            long j16 = ((PhotoPoiArea) TravelPhotoTimeLineView.this.C.get(i16)).startShootTime * 1000;
            if (g.l(j3, j16)) {
                return null;
            }
            C0351b c0351b = new C0351b();
            c0351b.f43867a = (PhotoPoiArea) TravelPhotoTimeLineView.this.C.get(i16);
            c0351b.f43871e = TravelPhotoTimeLineView.I;
            c0351b.f43872f = TravelPhotoTimeLineView.N;
            c0351b.f43868b = "";
            c0351b.f43869c = a(j16);
            c0351b.f43870d = QZoneAlbumUtil.n(j16);
            c0351b.f43873g = false;
            return c0351b;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            a aVar;
            ViewGroup.LayoutParams layoutParams;
            if (view == null) {
                view = LayoutInflater.from(this.f43855h).inflate(R.layout.bvf, (ViewGroup) null);
                aVar = new a();
                aVar.f43857a = (RelativeLayout) view.findViewById(R.id.dpq);
                aVar.f43858b = (RelativeLayout) view.findViewById(R.id.jg5);
                aVar.f43859c = (RelativeLayout) view.findViewById(R.id.d_8);
                aVar.f43865i = (ImageView) view.findViewById(R.id.f165733da3);
                aVar.f43863g = (CommonLine) view.findViewById(R.id.d_q);
                aVar.f43864h = (CommonLine) view.findViewById(R.id.d_p);
                aVar.f43860d = (SafeTextView) view.findViewById(R.id.jik);
                aVar.f43861e = (SafeTextView) view.findViewById(R.id.jgk);
                aVar.f43862f = (SafeTextView) view.findViewById(R.id.f166965jh1);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            C0351b item = getItem(i3);
            if (item != null) {
                aVar.f43858b.setVisibility(0);
                aVar.f43859c.setVisibility(0);
                RelativeLayout relativeLayout = aVar.f43857a;
                if (relativeLayout != null && (layoutParams = relativeLayout.getLayoutParams()) != null) {
                    int i16 = item.f43872f;
                    if (i16 != TravelPhotoTimeLineView.N && i16 != TravelPhotoTimeLineView.P) {
                        if (i16 == TravelPhotoTimeLineView.Q) {
                            layoutParams.height = u4.a.z().o(TravelPhotoTimeLineView.F);
                        } else if (i16 == TravelPhotoTimeLineView.R) {
                            layoutParams.height = u4.a.z().o(TravelPhotoTimeLineView.G);
                        } else if (i16 == TravelPhotoTimeLineView.S) {
                            layoutParams.height = u4.a.z().o(TravelPhotoTimeLineView.H);
                        }
                    } else {
                        layoutParams.height = u4.a.z().o(TravelPhotoTimeLineView.E);
                    }
                    aVar.f43857a.setLayoutParams(layoutParams);
                }
                if (item.f43873g) {
                    aVar.f43860d.setTextColor(TravelPhotoTimeLineView.this.getResources().getColor(R.color.f156957g5));
                    aVar.f43861e.setTextColor(TravelPhotoTimeLineView.this.getResources().getColor(R.color.f156957g5));
                    aVar.f43862f.setTextColor(TravelPhotoTimeLineView.this.getResources().getColor(R.color.f156957g5));
                } else {
                    aVar.f43860d.setTextColor(TravelPhotoTimeLineView.this.getResources().getColorStateList(R.color.a_j));
                    aVar.f43861e.setTextColor(TravelPhotoTimeLineView.this.getResources().getColorStateList(R.color.a_j));
                    aVar.f43862f.setTextColor(TravelPhotoTimeLineView.this.getResources().getColorStateList(R.color.a_j));
                }
                int i17 = item.f43871e;
                if (i17 == TravelPhotoTimeLineView.K) {
                    if (item.f43873g) {
                        aVar.f43865i.setBackgroundResource(R.drawable.gtz);
                    } else {
                        aVar.f43865i.setBackgroundResource(R.drawable.gtw);
                    }
                    aVar.f43860d.setText(item.f43868b);
                    aVar.f43860d.setVisibility(0);
                    aVar.f43861e.setVisibility(8);
                    aVar.f43862f.setVisibility(8);
                } else if (i17 == TravelPhotoTimeLineView.I) {
                    aVar.f43865i.setBackgroundResource(R.drawable.fw_);
                    aVar.f43860d.setText(item.f43868b);
                    aVar.f43860d.setVisibility(8);
                    aVar.f43861e.setText(item.f43869c);
                    aVar.f43861e.setVisibility(0);
                    aVar.f43862f.setText(item.f43870d);
                    aVar.f43862f.setVisibility(0);
                } else if (i17 == TravelPhotoTimeLineView.J) {
                    aVar.f43865i.setBackgroundResource(R.drawable.fwa);
                    aVar.f43860d.setText(item.f43868b);
                    aVar.f43860d.setVisibility(8);
                    aVar.f43861e.setText(item.f43869c);
                    aVar.f43861e.setVisibility(0);
                    aVar.f43862f.setText(item.f43870d);
                    aVar.f43862f.setVisibility(0);
                } else if (i17 == TravelPhotoTimeLineView.L || i17 == TravelPhotoTimeLineView.M) {
                    aVar.f43858b.setVisibility(8);
                    aVar.f43859c.setVisibility(8);
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        public void setData(ArrayList<PhotoPoiArea> arrayList) {
            if (arrayList == null) {
                return;
            }
            this.f43852d.clear();
            this.f43854f = "";
            if (TravelPhotoTimeLineView.this.C == null) {
                return;
            }
            if (TravelPhotoTimeLineView.this.D == 0) {
                if (TravelPhotoTimeLineView.this.C.size() > 0 && TravelPhotoTimeLineView.this.C.get(0) != null) {
                    this.f43853e = ((PhotoPoiArea) TravelPhotoTimeLineView.this.C.get(0)).startShootTime * 1000;
                }
            } else {
                this.f43853e = TravelPhotoTimeLineView.this.D * 1000;
            }
            if (this.f43853e > com.qzone.album.business.photolist.adapter.a.f42649b0) {
                this.f43853e = 1L;
            }
            this.f43853e = QZoneAlbumUtil.q(this.f43853e);
            if (arrayList.size() > 0 && arrayList.get(0) != null) {
                C0351b c0351b = new C0351b();
                c0351b.f43867a = arrayList.get(0);
                c0351b.f43872f = TravelPhotoTimeLineView.N;
                c0351b.f43871e = TravelPhotoTimeLineView.I;
                c0351b.f43868b = "";
                c0351b.f43869c = a(arrayList.get(0).startShootTime * 1000);
                c0351b.f43870d = QZoneAlbumUtil.n(arrayList.get(0).startShootTime * 1000);
                c0351b.f43873g = false;
                this.f43852d.add(c0351b);
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0351b c0351b2 = new C0351b();
                PhotoPoiArea photoPoiArea = arrayList.get(i3);
                c0351b2.f43867a = photoPoiArea;
                if (photoPoiArea != null) {
                    c0351b2.f43872f = TravelPhotoTimeLineView.Q;
                    c0351b2.f43871e = TravelPhotoTimeLineView.K;
                    String sceneryStr = arrayList.get(i3).toSceneryStr();
                    c0351b2.f43868b = sceneryStr;
                    c0351b2.f43869c = "";
                    c0351b2.f43870d = "";
                    c0351b2.f43873g = false;
                    if (!sceneryStr.equals(l.a(R.string.f172799u94)) || !this.f43854f.equals(c0351b2.f43868b)) {
                        this.f43852d.add(c0351b2);
                        this.f43854f = c0351b2.f43868b;
                    }
                    if (c(i3) != null) {
                        C0351b c0351b3 = new C0351b();
                        c0351b3.f43872f = TravelPhotoTimeLineView.S;
                        c0351b3.f43871e = TravelPhotoTimeLineView.M;
                        c0351b3.f43868b = "";
                        c0351b3.f43869c = "";
                        c0351b3.f43870d = "";
                        c0351b3.f43873g = false;
                        this.f43852d.add(c0351b3);
                        this.f43852d.add(c(i3));
                        this.f43854f = "";
                    }
                }
            }
            if (arrayList.size() > 0) {
                C0351b c0351b4 = new C0351b();
                c0351b4.f43867a = arrayList.get(arrayList.size() - 1);
                c0351b4.f43872f = TravelPhotoTimeLineView.P;
                c0351b4.f43871e = TravelPhotoTimeLineView.J;
                c0351b4.f43868b = "";
                c0351b4.f43869c = "THE END";
                c0351b4.f43870d = "";
                c0351b4.f43873g = false;
                this.f43852d.add(c0351b4);
            }
            C0351b c0351b5 = new C0351b();
            c0351b5.f43872f = TravelPhotoTimeLineView.R;
            c0351b5.f43871e = TravelPhotoTimeLineView.L;
            c0351b5.f43868b = "";
            c0351b5.f43869c = "";
            c0351b5.f43870d = "";
            c0351b5.f43873g = false;
            this.f43852d.add(c0351b5);
            notifyDataSetChanged();
        }
    }

    public TravelPhotoTimeLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = new ArrayList<>();
        f();
    }

    public TravelPhotoTimeLineView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = new ArrayList<>();
        f();
    }
}
