package com.tencent.gdtad.basics.adbox;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gdtad.basics.motivevideo.report.b;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<Activity> f108699d;

    /* renamed from: e, reason: collision with root package name */
    private h f108700e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.gdtad.basics.adbox.a f108701f;

    /* renamed from: h, reason: collision with root package name */
    private a f108702h;

    /* renamed from: i, reason: collision with root package name */
    private final List<e> f108703i = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public RelativeLayout f108704a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.gdtad.basics.adbox.a f108705b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f108706c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f108707d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f108708e;

        /* renamed from: f, reason: collision with root package name */
        public h f108709f;

        /* renamed from: g, reason: collision with root package name */
        private com.tencent.gdtad.basics.motivevideo.report.b f108710g = new com.tencent.gdtad.basics.motivevideo.report.b();

        /* renamed from: h, reason: collision with root package name */
        public GdtThirdProcessorProxy f108711h = new GdtThirdProcessorProxy();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.gdtad.basics.adbox.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class ViewOnClickListenerC1150a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f108712d;

            ViewOnClickListenerC1150a(Activity activity) {
                this.f108712d = activity;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                a aVar = a.this;
                aVar.f108709f.b(this.f108712d, view, aVar.c(view), a.this.f108710g, a.this.f108705b.c());
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b.a c(View view) {
            try {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                return new b.a(view.getWidth(), view.getHeight(), iArr[0], iArr[1]);
            } catch (Exception e16) {
                QLog.i("GdtAdBoxListAdapter", 1, "gdiReportExposure", e16);
                return null;
            }
        }

        public void d() {
            com.tencent.gdtad.basics.motivevideo.report.b bVar = this.f108710g;
            if (bVar != null) {
                bVar.h();
            }
            h hVar = this.f108709f;
            if (hVar != null) {
                hVar.d();
            }
            com.tencent.gdtad.basics.adbox.a aVar = this.f108705b;
            if (aVar != null) {
                aVar.e();
            }
        }

        public void e(e eVar, Activity activity) {
            try {
                Drawable gdtADBoxItemDrawable = this.f108711h.gdtADBoxItemDrawable(activity, eVar.f108694a);
                if (gdtADBoxItemDrawable != null) {
                    this.f108706c.setImageDrawable(gdtADBoxItemDrawable);
                }
            } catch (Exception e16) {
                GdtLog.e("GdtAdBoxListAdapter", "bad url params", e16);
            }
            this.f108707d.setText(eVar.f108695b);
            this.f108708e.setText(eVar.f108696c);
            this.f108706c.setContentDescription(eVar.f108695b);
            this.f108707d.setContentDescription(eVar.f108695b);
            this.f108704a.setTag(R.id.kx_, eVar.f108698e);
            this.f108704a.setTag(R.id.ljl, eVar.f108698e);
            this.f108704a.setOnClickListener(new ViewOnClickListenerC1150a(activity));
            this.f108710g.g(this.f108706c);
        }
    }

    public f(Activity activity) {
        this.f108699d = new WeakReference<>(activity);
    }

    public void a() {
        this.f108702h.d();
    }

    public void b() {
        this.f108700e.f();
    }

    public void c() {
        this.f108700e.e();
    }

    public void d(List<e> list, h hVar, com.tencent.gdtad.basics.adbox.a aVar) {
        e(list);
        this.f108700e = hVar;
        this.f108701f = aVar;
    }

    public void e(List<e> list) {
        this.f108703i.clear();
        this.f108703i.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f108703i.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f108703i.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (view != null) {
            this.f108702h = (a) view.getTag();
        } else {
            view = LayoutInflater.from(viewGroup.getContext().getApplicationContext()).inflate(R.layout.ecg, viewGroup, false);
            a aVar = new a();
            this.f108702h = aVar;
            aVar.f108709f = this.f108700e;
            aVar.f108705b = this.f108701f;
            aVar.f108704a = (RelativeLayout) view.findViewById(R.id.f75543z9);
            this.f108702h.f108706c = (ImageView) view.findViewById(R.id.dvu);
            this.f108702h.f108707d = (TextView) view.findViewById(R.id.tv_name);
            this.f108702h.f108708e = (TextView) view.findViewById(R.id.f167043k74);
            view.setTag(this.f108702h);
        }
        try {
            this.f108702h.e(this.f108703i.get(i3), this.f108699d.get());
        } catch (Exception e16) {
            QLog.e("GdtAdBoxListAdapter", 1, "getView exception: " + Log.getStackTraceString(e16));
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }
}
