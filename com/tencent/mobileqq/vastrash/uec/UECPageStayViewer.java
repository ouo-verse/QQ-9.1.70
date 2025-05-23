package com.tencent.mobileqq.vastrash.uec;

import NS_USER_ACTION_REPORT.QQStayTimeInfo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes20.dex */
public class UECPageStayViewer extends RelativeLayout implements View.OnClickListener {
    private UECPageStayViewer C;
    private boolean D;
    private int E;
    private ArrayList<QQStayTimeInfo> F;

    /* renamed from: d, reason: collision with root package name */
    private ListView f312408d;

    /* renamed from: e, reason: collision with root package name */
    private c f312409e;

    /* renamed from: f, reason: collision with root package name */
    private Button f312410f;

    /* renamed from: h, reason: collision with root package name */
    private Button f312411h;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f312412i;

    /* renamed from: m, reason: collision with root package name */
    private WindowManager f312413m;

    /* loaded from: classes20.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Context context = UECPageStayViewer.this.getContext();
            int action = motionEvent.getAction();
            int rawY = (int) motionEvent.getRawY();
            if (action == 0) {
                UECPageStayViewer.this.E = (int) motionEvent.getY();
                return false;
            }
            if (action != 2) {
                return false;
            }
            if (UECPageStayViewer.this.D || Math.abs(motionEvent.getY() - UECPageStayViewer.this.E) > x.c(context, 10.0f)) {
                UECPageStayViewer.this.D = true;
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) UECPageStayViewer.this.getLayoutParams();
                layoutParams.y = (rawY - UECPageStayViewer.this.E) - x.c(context, 0.0f);
                int height = UECPageStayViewer.this.f312413m.getDefaultDisplay().getHeight();
                int i3 = layoutParams.y;
                if (i3 < 0) {
                    layoutParams.y = 0;
                } else if (i3 > height - UECPageStayViewer.this.getHeight()) {
                    layoutParams.y = height - UECPageStayViewer.this.getHeight();
                }
                UECPageStayViewer.this.f312413m.updateViewLayout(UECPageStayViewer.this.C, layoutParams);
            }
            return true;
        }
    }

    /* loaded from: classes20.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        TextView f312415a;

        /* renamed from: b, reason: collision with root package name */
        TextView f312416b;

        /* renamed from: c, reason: collision with root package name */
        TextView f312417c;

        public b(View view) {
            TextView textView = (TextView) view.findViewById(R.id.m_e);
            this.f312415a = textView;
            textView.setTextSize(10.0f);
            TextView textView2 = (TextView) view.findViewById(R.id.f919356i);
            this.f312416b = textView2;
            textView2.setTextSize(10.0f);
            TextView textView3 = (TextView) view.findViewById(R.id.f919456j);
            this.f312417c = textView3;
            textView3.setTextSize(10.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes20.dex */
    public class c extends BaseAdapter {
        protected c() {
        }

        private ArrayList<QQStayTimeInfo> b() {
            return UECPageStayViewer.this.F;
        }

        private int c() {
            return b().size();
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQStayTimeInfo getItem(int i3) {
            return b().get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return c();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(UECPageStayViewer.this.getContext()).inflate(R.layout.h57, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            QQStayTimeInfo qQStayTimeInfo = b().get(i3);
            bVar.f312415a.setText(qQStayTimeInfo.page_info);
            bVar.f312416b.setText(qQStayTimeInfo.page_info_ext);
            bVar.f312417c.setText(qQStayTimeInfo.stay_time + "");
            if (i3 % 2 == 0) {
                view.setBackgroundColor(UECPageStayViewer.this.getContext().getResources().getColor(R.color.a5n));
            } else {
                view.setBackgroundColor(UECPageStayViewer.this.getContext().getResources().getColor(R.color.f158017al3));
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    public UECPageStayViewer(Context context) {
        super(context);
        this.D = false;
        this.F = new ArrayList<>();
        LayoutInflater.from(context).inflate(R.layout.h56, this);
        this.f312413m = (WindowManager) context.getSystemService("window");
        this.f312408d = (ListView) findViewById(R.id.m_f);
        this.f312410f = (Button) findViewById(R.id.f165693ll2);
        this.f312411h = (Button) findViewById(R.id.ayc);
        this.f312412i = (RelativeLayout) findViewById(R.id.lfw);
        c cVar = new c();
        this.f312409e = cVar;
        this.f312408d.setAdapter((ListAdapter) cVar);
        this.f312410f.setOnClickListener(this);
        this.f312411h.setOnClickListener(this);
        this.C = this;
        this.f312412i.setOnTouchListener(new a());
    }

    private void k() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vastrash.uec.UECPageStayViewer.2
            @Override // java.lang.Runnable
            public void run() {
                if (UECPageStayViewer.this.f312409e != null) {
                    UECPageStayViewer.this.f312409e.notifyDataSetChanged();
                }
            }
        });
    }

    public void i(ArrayList<QQStayTimeInfo> arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator<QQStayTimeInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            this.F.add(0, it.next());
        }
        k();
    }

    public void j() {
        this.F.clear();
        this.f312409e.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f165693ll2) {
            com.tencent.mobileqq.vastrash.uec.a.b().c();
        } else if (id5 == R.id.ayc) {
            j();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
