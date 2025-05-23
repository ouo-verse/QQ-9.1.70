package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.subscript.c;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.i;
import com.tencent.mobileqq.activity.recent.o;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends BaseAdapter implements DecodeTaskCompletionListener, c.b {
    public static int Y = 0;
    public static int Z = 1;

    /* renamed from: a0, reason: collision with root package name */
    public static int f80067a0 = 2;

    /* renamed from: b0, reason: collision with root package name */
    private static int f80068b0 = 3;

    /* renamed from: c0, reason: collision with root package name */
    public static int f80069c0;
    private Resources C;
    private QQAppInterface D;
    private XListView E;
    private LayoutInflater F;
    private i G;
    private DragFrameLayout H;
    private com.tencent.biz.pubaccount.subscript.c I;
    private SubscriptRecommendController J;
    private float R;
    private float S;
    private float T;
    private float U;
    private boolean V;
    private View.OnClickListener X;

    /* renamed from: m, reason: collision with root package name */
    private Activity f80075m;

    /* renamed from: d, reason: collision with root package name */
    public int f80070d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f80071e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f80072f = -1;

    /* renamed from: h, reason: collision with root package name */
    public boolean f80073h = false;

    /* renamed from: i, reason: collision with root package name */
    private final int f80074i = 10;
    private List<w62.a> K = new ArrayList();
    private List<ReadInJoyArticle> L = new ArrayList();
    private List<Object> M = new ArrayList();
    private HashSet<String> N = new HashSet<>();
    private int P = 0;
    private HashMap<String, Bitmap> Q = new HashMap<>();
    private boolean W = false;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.subscript.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0817a {

        /* renamed from: a, reason: collision with root package name */
        String f80076a;

        /* renamed from: b, reason: collision with root package name */
        ViewGroup f80077b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f80078c;

        /* renamed from: d, reason: collision with root package name */
        TextView f80079d;

        /* renamed from: e, reason: collision with root package name */
        TextView f80080e;

        /* renamed from: f, reason: collision with root package name */
        DragTextView f80081f;

        /* renamed from: g, reason: collision with root package name */
        TextView f80082g;

        /* renamed from: h, reason: collision with root package name */
        ImageView f80083h;

        /* renamed from: i, reason: collision with root package name */
        ImageView f80084i;

        /* renamed from: j, reason: collision with root package name */
        Button f80085j;

        /* renamed from: k, reason: collision with root package name */
        Button f80086k;

        /* renamed from: l, reason: collision with root package name */
        Button f80087l;

        /* renamed from: m, reason: collision with root package name */
        Button f80088m;

        public C0817a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class b {

        /* renamed from: a, reason: collision with root package name */
        ViewGroup f80090a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList<ViewGroup> f80091b = new ArrayList<>();

        b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class c {
        c() {
        }
    }

    public a(Activity activity, QQAppInterface qQAppInterface, XListView xListView, LayoutInflater layoutInflater) {
        this.R = 0.0f;
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
        this.V = false;
        this.f80075m = activity;
        this.C = activity.getResources();
        this.D = qQAppInterface;
        this.E = xListView;
        this.F = layoutInflater;
        this.G = new i(qQAppInterface, this, false);
        this.V = ThemeUtil.isInNightMode(qQAppInterface);
        this.R = this.f80075m.getResources().getDimension(R.dimen.aah);
        this.S = this.f80075m.getResources().getDimension(R.dimen.aaj);
        this.T = this.f80075m.getResources().getDimension(R.dimen.aai);
        this.U = this.f80075m.getResources().getDimension(R.dimen.aag);
    }

    private void e(C0817a c0817a, String str) {
        Bitmap bitmap = this.Q.get(str);
        if (bitmap == null) {
            c0817a.f80078c.setImageDrawable(this.G.e(1008, str));
        } else {
            c0817a.f80078c.setImageBitmap(bitmap);
        }
    }

    @Override // com.tencent.biz.pubaccount.subscript.c.b
    public boolean a(ImageView imageView) {
        if (imageView.getTag(R.id.j7k).equals(Integer.valueOf(Z)) || !imageView.getTag(R.id.j7k).equals(Integer.valueOf(Y))) {
            return true;
        }
        int childCount = this.E.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Object tag = this.E.getChildAt(i3).getTag();
            if (tag != null && (tag instanceof C0817a) && ((C0817a) tag).f80076a.equals(imageView.getTag(R.id.j7l))) {
                return true;
            }
        }
        return false;
    }

    public void b() {
        boolean z16;
        boolean z17 = false;
        if (this.f80070d == 1 && this.f80071e) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f80072f == 1 && this.f80073h) {
            z17 = true;
        }
        this.M.clear();
        this.M.addAll(this.K);
        if (z16 && this.L.size() > 0) {
            if (this.M.size() <= 6) {
                this.M.add(ReadInJoyArticle.TAG);
            } else {
                this.M.add(6, ReadInJoyArticle.TAG);
            }
        }
        if (z17) {
            if (this.M.size() <= 3) {
                this.M.add("SubscriptRecommendController");
            } else {
                this.M.add(3, "SubscriptRecommendController");
            }
        }
    }

    public void c() {
        if (!this.N.isEmpty()) {
            ReportController.n(null, "CliOper", "", "", "0X8006110", "0X8006110", 0, this.N.size(), 0, "", "", "", "");
        }
        int i3 = this.P;
        if (i3 > 0) {
            ReportController.n(null, "CliOper", "", "", "0X8006154", "0X8006154", 0, i3, 0, "", "", "", "");
        }
        if (this.W) {
            ReportController.o(this.D, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
        }
        this.N.clear();
        this.N = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.G.r();
        this.F = null;
        this.E = null;
        this.Q.clear();
        this.Q = null;
        this.C = null;
        this.f80075m = null;
    }

    public void d(DragFrameLayout dragFrameLayout) {
        this.H = dragFrameLayout;
    }

    public void f(View.OnClickListener onClickListener) {
        this.X = onClickListener;
    }

    public void g(com.tencent.biz.pubaccount.subscript.c cVar) {
        this.I = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.M.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.M.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        int i16 = f80068b0;
        Object obj = this.M.get(i3);
        if (obj instanceof w62.a) {
            return Y;
        }
        boolean z16 = obj instanceof String;
        if (z16 && obj.equals("SubscriptRecommendController")) {
            return f80067a0;
        }
        if (z16 && obj.equals(ReadInJoyArticle.TAG)) {
            return Z;
        }
        return i16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        String str;
        String str2;
        w62.a aVar;
        View view4;
        c cVar;
        Resources resources;
        int i16;
        Resources resources2;
        int i17;
        Resources resources3;
        int i18;
        if (i3 < 0 || i3 >= this.M.size()) {
            view2 = view;
        } else {
            int itemViewType = getItemViewType(i3);
            int i19 = 0;
            if (view == null) {
                if (itemViewType == Y) {
                    C0817a c0817a = new C0817a();
                    View inflate = this.F.inflate(R.layout.f168560ac2, (ViewGroup) null);
                    c0817a.f80077b = (ViewGroup) inflate.findViewById(R.id.j7_);
                    c0817a.f80078c = (ImageView) inflate.findViewById(R.id.j7n);
                    c0817a.f80079d = (TextView) inflate.findViewById(R.id.j7s);
                    c0817a.f80080e = (TextView) inflate.findViewById(R.id.i6p);
                    c0817a.f80081f = (DragTextView) inflate.findViewById(R.id.kik);
                    c0817a.f80082g = (TextView) inflate.findViewById(R.id.c7d);
                    c0817a.f80083h = (ImageView) inflate.findViewById(R.id.c6m);
                    c0817a.f80084i = (ImageView) inflate.findViewById(R.id.c6q);
                    c0817a.f80085j = (Button) inflate.findViewById(R.id.eqh);
                    c0817a.f80086k = (Button) inflate.findViewById(R.id.eqn);
                    c0817a.f80087l = (Button) inflate.findViewById(R.id.eqm);
                    c0817a.f80088m = (Button) inflate.findViewById(R.id.f166236eq0);
                    c0817a.f80077b.setOnClickListener(this.X);
                    c0817a.f80081f.setDragViewType(0, inflate);
                    c0817a.f80081f.setOnModeChangeListener(this.H);
                    c0817a.f80085j.setOnClickListener(this.X);
                    c0817a.f80086k.setOnClickListener(this.X);
                    c0817a.f80087l.setOnClickListener(this.X);
                    c0817a.f80088m.setOnClickListener(this.X);
                    TextView textView = c0817a.f80082g;
                    if (this.V) {
                        resources = this.C;
                        i16 = R.color.f157561t7;
                    } else {
                        resources = this.C;
                        i16 = R.color.f157560t6;
                    }
                    textView.setTextColor(resources.getColor(i16));
                    TextView textView2 = c0817a.f80079d;
                    if (this.V) {
                        resources2 = this.C;
                        i17 = R.color.f157566tc;
                    } else {
                        resources2 = this.C;
                        i17 = R.color.f157565tb;
                    }
                    textView2.setTextColor(resources2.getColor(i17));
                    TextView textView3 = c0817a.f80080e;
                    if (this.V) {
                        resources3 = this.C;
                        i18 = R.color.f157569tf;
                    } else {
                        resources3 = this.C;
                        i18 = R.color.f157568te;
                    }
                    textView3.setTextColor(resources3.getColor(i18));
                    cVar = c0817a;
                    view4 = inflate;
                } else if (itemViewType == Z) {
                    b bVar = new b();
                    View inflate2 = this.F.inflate(R.layout.f168561ac4, (ViewGroup) null);
                    ViewGroup viewGroup2 = (ViewGroup) inflate2.findViewById(R.id.e0h);
                    bVar.f80090a = viewGroup2;
                    viewGroup2.setOnClickListener(this.X);
                    ((TextView) bVar.f80090a.findViewById(R.id.e0i)).setCompoundDrawablesWithIntrinsicBounds(0, 0, !this.V ? R.drawable.du6 : R.drawable.du7, 0);
                    bVar.f80091b.add((ViewGroup) inflate2.findViewById(R.id.f165987e02));
                    bVar.f80091b.add((ViewGroup) inflate2.findViewById(R.id.f165988e03));
                    bVar.f80091b.add((ViewGroup) inflate2.findViewById(R.id.f165989e04));
                    bVar.f80091b.add((ViewGroup) inflate2.findViewById(R.id.f165990e05));
                    int size = bVar.f80091b.size();
                    int color = this.C.getColor(!this.V ? R.color.f157575tl : R.color.f157576tm);
                    for (int i26 = 0; i26 < size; i26++) {
                        ViewGroup viewGroup3 = bVar.f80091b.get(i26);
                        viewGroup3.setOnClickListener(this.X);
                        viewGroup3.setTag(Integer.valueOf(i26));
                        ((TextView) viewGroup3.findViewById(R.id.f164499zu)).setTextColor(color);
                    }
                    inflate2.setTag(-3, 0);
                    cVar = bVar;
                    view4 = inflate2;
                } else if (itemViewType == f80067a0) {
                    c cVar2 = new c();
                    View inflate3 = this.F.inflate(R.layout.ac6, (ViewGroup) null);
                    this.J.B(inflate3);
                    this.J.c();
                    this.J.D();
                    inflate3.setTag(-3, 0);
                    this.W = true;
                    cVar = cVar2;
                    view4 = inflate3;
                } else {
                    view4 = view;
                    cVar = null;
                }
                if (view4 != null) {
                    view4.setTag(cVar);
                }
                view3 = view4;
            } else {
                view3 = view;
            }
            if (view3 != null) {
                String str3 = "^\\s+";
                if (itemViewType == Y) {
                    view3.setTag(R.id.j7f, Integer.valueOf(i3));
                    C0817a c0817a2 = (C0817a) view3.getTag();
                    w62.a aVar2 = (w62.a) getItem(i3);
                    HashSet<String> hashSet = this.N;
                    if (hashSet != null) {
                        hashSet.add(aVar2.f444667c);
                    }
                    String str4 = aVar2.f444667c;
                    c0817a2.f80076a = str4;
                    e(c0817a2, str4);
                    String o16 = TroopBarAssistantManager.n().o(aVar2.f444667c);
                    if (TextUtils.isEmpty(o16)) {
                        c0817a2.f80079d.setText(aVar2.f444667c);
                    } else {
                        c0817a2.f80079d.setText(o16);
                    }
                    c0817a2.f80080e.setText(o.c().d(aVar2.f444667c, aVar2.f444668d));
                    int i27 = aVar2.f444666b;
                    com.tencent.widget.d.c(c0817a2.f80081f, i27 > 0 ? 3 : 0, i27, R.drawable.skin_tips_newmessage, 99, null);
                    if (aVar2.f444669e.size() > 0) {
                        w62.b bVar2 = aVar2.f444669e.get(0);
                        int i28 = bVar2.f444671a;
                        if (i28 == 0) {
                            c0817a2.f80082g.setMaxLines(1);
                            c0817a2.f80082g.setText(new QQText(bVar2.f444674d.replaceFirst("^\\s+", ""), 3, 20));
                            c0817a2.f80083h.setVisibility(8);
                            c0817a2.f80084i.setVisibility(8);
                            str2 = o16;
                            aVar = aVar2;
                        } else if (i28 == 1) {
                            c0817a2.f80082g.setMaxLines(2);
                            c0817a2.f80082g.setText(bVar2.f444673c.replaceFirst("^\\s+", ""));
                            c0817a2.f80083h.setVisibility(0);
                            if (TextUtils.isEmpty(bVar2.f444679i)) {
                                c0817a2.f80084i.setVisibility(8);
                            } else {
                                c0817a2.f80084i.setVisibility(0);
                            }
                            c0817a2.f80083h.setTag(R.id.j7l, c0817a2.f80076a);
                            c0817a2.f80083h.setTag(R.id.j7k, Integer.valueOf(Y));
                            ViewGroup.LayoutParams layoutParams = c0817a2.f80083h.getLayoutParams();
                            str2 = o16;
                            this.I.b(((IPublicAccountHttpDownloader) QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(bVar2.f444672b, 1, aVar2.f444667c), c0817a2.f80083h, layoutParams.width, layoutParams.height, this);
                            if (c0817a2.f80083h.getDrawable() instanceof URLDrawable) {
                                URLDrawable uRLDrawable = (URLDrawable) c0817a2.f80083h.getDrawable();
                                if (i3 >= 10) {
                                    uRLDrawable.setAutoDownload(false);
                                }
                            }
                            aVar = aVar2;
                        } else if (i28 == 2) {
                            c0817a2.f80082g.setMaxLines(1);
                            c0817a2.f80082g.setText(R.string.e0q);
                            c0817a2.f80083h.setVisibility(0);
                            c0817a2.f80084i.setVisibility(8);
                            c0817a2.f80083h.setTag(R.id.j7l, c0817a2.f80076a);
                            c0817a2.f80083h.setTag(R.id.j7k, Integer.valueOf(Y));
                            ViewGroup.LayoutParams layoutParams2 = c0817a2.f80083h.getLayoutParams();
                            str2 = o16;
                            aVar = aVar2;
                            this.I.b(((IPublicAccountHttpDownloader) QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(bVar2.f444678h.toString(), 1, aVar2.f444667c), c0817a2.f80083h, layoutParams2.width, layoutParams2.height, this);
                        } else {
                            str2 = o16;
                            aVar = aVar2;
                            c0817a2.f80082g.setMaxLines(1);
                            c0817a2.f80082g.setText(R.string.e0r);
                            c0817a2.f80083h.setVisibility(8);
                            c0817a2.f80084i.setVisibility(8);
                        }
                    } else {
                        str2 = o16;
                        aVar = aVar2;
                        if (QLog.isColorLevel() && QLog.isColorLevel()) {
                            QLog.w("SubscriptFeedsAdapter", 2, "getView feed.mItems.size() == 0, is error!!");
                        }
                    }
                    c0817a2.f80077b.setTag(R.id.j7c, Integer.valueOf(aVar.f444666b));
                    c0817a2.f80077b.setTag(R.id.j7l, aVar.f444667c);
                    c0817a2.f80077b.setTag(R.id.j7e, str2);
                    c0817a2.f80077b.setTag(R.id.j7d, Integer.valueOf(f80069c0));
                    c0817a2.f80081f.setTag(R.id.j7c, aVar);
                    c0817a2.f80085j.setTag(R.id.j7l, aVar.f444667c);
                    c0817a2.f80086k.setTag(R.id.j7l, aVar.f444667c);
                    c0817a2.f80087l.setTag(R.id.j7l, aVar.f444667c);
                    c0817a2.f80087l.setTag(R.id.j7e, str2);
                    c0817a2.f80088m.setTag(R.id.j7l, aVar.f444667c);
                    if (!TroopBarAssistantManager.n().z(aVar.f444667c, this.D)) {
                        if (!this.V) {
                            c0817a2.f80077b.setBackgroundResource(R.drawable.a2m);
                        } else {
                            c0817a2.f80077b.setBackgroundResource(R.drawable.a2o);
                        }
                        view3.setTag(-3, Integer.valueOf((int) (this.R + this.T + this.U)));
                        c0817a2.f80085j.setVisibility(0);
                        c0817a2.f80086k.setVisibility(8);
                    } else {
                        if (!this.V) {
                            c0817a2.f80077b.setBackgroundResource(R.drawable.a2n);
                        } else {
                            c0817a2.f80077b.setBackgroundResource(R.drawable.a2p);
                        }
                        view3.setTag(-3, Integer.valueOf((int) (this.S + this.T + this.U)));
                        c0817a2.f80085j.setVisibility(8);
                        c0817a2.f80086k.setVisibility(0);
                    }
                } else if (itemViewType == Z) {
                    view3.setTag(R.id.j7f, Integer.valueOf(i3));
                    this.P++;
                    b bVar3 = (b) view3.getTag();
                    int size2 = bVar3.f80091b.size();
                    while (i19 < size2) {
                        ViewGroup viewGroup4 = bVar3.f80091b.get(i19);
                        TextView textView4 = (TextView) viewGroup4.findViewById(R.id.f164499zu);
                        ImageView imageView = (ImageView) viewGroup4.findViewById(R.id.f164498zt);
                        if (i19 < this.L.size()) {
                            ReadInJoyArticle readInJoyArticle = this.L.get(i19);
                            textView4.setText(readInJoyArticle.mTitle.replaceFirst(str3, ""));
                            imageView.setTag(R.id.j7k, Integer.valueOf(Z));
                            WindowManager windowManager = (WindowManager) this.f80075m.getSystemService("window");
                            str = str3;
                            this.I.b(((IPublicAccountHttpDownloader) QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(readInJoyArticle.mFirstPagePicUrl, 1), imageView, windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight(), this);
                        } else {
                            str = str3;
                        }
                        i19++;
                        str3 = str;
                    }
                }
                view2 = view3;
                EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
                return view3;
            }
            view2 = view3;
        }
        view3 = null;
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return f80068b0;
    }

    public void h(SubscriptRecommendController subscriptRecommendController) {
        this.J = subscriptRecommendController;
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        if (bitmap != null && this.E != null && str != null && str.length() != 0) {
            this.Q.put(str, bitmap);
            int childCount = this.E.getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                Object tag = this.E.getChildAt(i17).getTag();
                if (tag != null && (tag instanceof C0817a)) {
                    C0817a c0817a = (C0817a) tag;
                    if (str.equals(c0817a.f80076a)) {
                        e(c0817a, str);
                    }
                }
            }
        }
    }
}
