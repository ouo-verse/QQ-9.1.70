package com.tencent.mobileqq.tablequery;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TableQueryViewer extends RelativeLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private Button C;
    private boolean D;
    private boolean E;
    private HorizontalScrollView F;
    private LinearLayout G;
    private View H;
    private RelativeLayout I;
    private WindowManager J;
    private TableQueryViewer K;
    private boolean L;
    private int M;
    private List N;

    /* renamed from: d, reason: collision with root package name */
    private ListView f291360d;

    /* renamed from: e, reason: collision with root package name */
    private d f291361e;

    /* renamed from: f, reason: collision with root package name */
    private TableQueryController f291362f;

    /* renamed from: h, reason: collision with root package name */
    private Button f291363h;

    /* renamed from: i, reason: collision with root package name */
    private Button f291364i;

    /* renamed from: m, reason: collision with root package name */
    private Button f291365m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements AdapterView.OnItemLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f291366d;

        a(Context context) {
            this.f291366d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TableQueryViewer.this, (Object) context);
            }
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemLongClickBefore(adapterView, view, i3, j3);
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
            } else {
                String str = ((com.tencent.mobileqq.tablequery.a) TableQueryViewer.this.N.get(i3)).f291376b;
                ClipboardManager clipboardManager = (ClipboardManager) view.getContext().getSystemService("clipboard");
                if (clipboardManager != null && !TextUtils.isEmpty(str)) {
                    ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText("bigT", str));
                    QQToast.makeText(TableQueryViewer.this.getContext(), this.f291366d.getString(R.string.ill), 0).show();
                }
            }
            EventCollector.getInstance().onItemLongClick(adapterView, view, i3, j3);
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TableQueryViewer.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            Context context = TableQueryViewer.this.getContext();
            int action = motionEvent.getAction();
            int rawY = (int) motionEvent.getRawY();
            if (action == 0) {
                TableQueryViewer.this.M = (int) motionEvent.getY();
                return false;
            }
            if (action != 2) {
                return false;
            }
            if (TableQueryViewer.this.L || Math.abs(motionEvent.getY() - TableQueryViewer.this.M) > x.c(context, 10.0f)) {
                TableQueryViewer.this.L = true;
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) TableQueryViewer.this.getLayoutParams();
                layoutParams.y = (rawY - TableQueryViewer.this.M) - x.c(context, 0.0f);
                int height = TableQueryViewer.this.J.getDefaultDisplay().getHeight();
                int i3 = layoutParams.y;
                if (i3 < 0) {
                    layoutParams.y = 0;
                } else if (i3 > height - TableQueryViewer.this.getHeight()) {
                    layoutParams.y = height - TableQueryViewer.this.getHeight();
                }
                TableQueryViewer.this.J.updateViewLayout(TableQueryViewer.this.K, layoutParams);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TextView f291369a;

        /* renamed from: b, reason: collision with root package name */
        TextView f291370b;

        /* renamed from: c, reason: collision with root package name */
        TextView f291371c;

        /* renamed from: d, reason: collision with root package name */
        TextView f291372d;

        public c(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TableQueryViewer.this, (Object) view);
                return;
            }
            TextView textView = (TextView) view.findViewById(R.id.m_i);
            this.f291369a = textView;
            textView.setTextSize(10.0f);
            TextView textView2 = (TextView) view.findViewById(R.id.m_g);
            this.f291370b = textView2;
            textView2.setTextSize(10.0f);
            TextView textView3 = (TextView) view.findViewById(R.id.m_j);
            this.f291371c = textView3;
            textView3.setTextSize(10.0f);
            TextView textView4 = (TextView) view.findViewById(R.id.m_e);
            this.f291372d = textView4;
            textView4.setTextSize(10.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d extends BaseAdapter {
        static IPatchRedirector $redirector_;

        protected d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TableQueryViewer.this);
            }
        }

        private List<com.tencent.mobileqq.tablequery.a> a() {
            return TableQueryViewer.this.N;
        }

        private int b() {
            return a().size();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return b();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return a().get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            c cVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    view = LayoutInflater.from(TableQueryViewer.this.getContext()).inflate(R.layout.cel, viewGroup, false);
                    cVar = new c(view);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                com.tencent.mobileqq.tablequery.a aVar = a().get(i3);
                cVar.f291369a.setText(aVar.f291376b);
                cVar.f291372d.setText(aVar.f291385k);
                cVar.f291370b.setText(aVar.f291377c);
                cVar.f291371c.setText(aVar.f291380f);
                if (i3 % 2 == 0) {
                    view.setBackgroundColor(TableQueryViewer.this.getContext().getResources().getColor(R.color.a5n));
                } else {
                    view.setBackgroundColor(TableQueryViewer.this.getContext().getResources().getColor(R.color.f158017al3));
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    public TableQueryViewer(Context context) {
        super(context);
        String string;
        String string2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.D = true;
        this.E = true;
        this.L = false;
        this.N = new LinkedList();
        LayoutInflater.from(context).inflate(R.layout.cek, this);
        this.J = (WindowManager) context.getSystemService("window");
        this.F = (HorizontalScrollView) findViewById(R.id.m3a);
        this.f291360d = (ListView) findViewById(R.id.m_f);
        this.f291363h = (Button) findViewById(R.id.f165693ll2);
        this.f291364i = (Button) findViewById(R.id.ayc);
        Button button = (Button) findViewById(R.id.lfr);
        this.C = button;
        if (TableQueryController.f291348h) {
            string = context.getString(R.string.ilm);
        } else {
            string = context.getString(R.string.ilq);
        }
        button.setText(string);
        Button button2 = (Button) findViewById(R.id.f166755m50);
        this.f291365m = button2;
        if (TableQueryController.f291350j) {
            string2 = context.getString(R.string.ilo);
        } else {
            string2 = context.getString(R.string.ilp);
        }
        button2.setText(string2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.m_h);
        this.G = linearLayout;
        linearLayout.setBackgroundColor(getResources().getColor(R.color.f156789bm));
        for (int i3 = 0; i3 < this.G.getChildCount(); i3++) {
            View childAt = this.G.getChildAt(i3);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTextColor(-1);
                textView.setTypeface(Typeface.defaultFromStyle(1));
            }
        }
        this.H = findViewById(R.id.m5q);
        this.I = (RelativeLayout) findViewById(R.id.lfw);
        this.f291362f = TableQueryController.g();
        d dVar = new d();
        this.f291361e = dVar;
        this.f291360d.setAdapter((ListAdapter) dVar);
        this.f291363h.setOnClickListener(this);
        this.f291364i.setOnClickListener(this);
        this.f291365m.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.K = this;
        this.f291360d.setOnItemLongClickListener(new a(context));
        this.I.setOnTouchListener(new b());
    }

    public void h(com.tencent.mobileqq.tablequery.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.N.add(0, aVar);
            this.f291361e.notifyDataSetChanged();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.N.clear();
            this.f291361e.notifyDataSetChanged();
        }
    }

    public int j(com.tencent.mobileqq.tablequery.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar)).intValue();
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.N.size(); i16++) {
            if (aVar.f291376b.contains(((com.tencent.mobileqq.tablequery.a) this.N.get(i16)).f291375a)) {
                this.N.set(i16, aVar);
                this.f291361e.notifyDataSetChanged();
                i3++;
            }
        }
        return i3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f165693ll2) {
                if (this.E) {
                    this.F.setVisibility(8);
                    this.f291363h.setText(getContext().getString(R.string.ilw));
                    this.F.setEnabled(false);
                    this.E = false;
                } else {
                    this.F.setVisibility(0);
                    this.f291363h.setText(getContext().getString(R.string.iln));
                    this.F.setEnabled(true);
                    this.E = true;
                }
            } else if (id5 == R.id.ayc) {
                i();
            } else if (id5 == R.id.f166755m50) {
                if (TableQueryController.f291350j) {
                    this.f291365m.setText(getContext().getString(R.string.ilp));
                    TableQueryController.f291350j = false;
                } else {
                    this.f291365m.setText(getContext().getString(R.string.ilo));
                    TableQueryController.f291350j = true;
                }
            } else if (id5 == R.id.lfr) {
                if (TableQueryController.f291348h) {
                    this.C.setText(getContext().getString(R.string.ilq));
                    TableQueryController.f291348h = false;
                } else {
                    this.C.setText(getContext().getString(R.string.ilm));
                    TableQueryController.f291348h = true;
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, i16);
        }
    }
}
