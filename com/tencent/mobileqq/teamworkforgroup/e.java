package com.tencent.mobileqq.teamworkforgroup;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamwork.m;
import com.tencent.mobileqq.teamworkforgroup.a;
import com.tencent.mobileqq.teamworkforgroup.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends com.tencent.mobileqq.teamwork.g implements a.d {
    private AppInterface C;
    private Context D;
    private k F;
    private j G;
    protected View.OnClickListener H;
    protected View.OnLongClickListener I;

    /* renamed from: d, reason: collision with root package name */
    private Activity f292598d;

    /* renamed from: f, reason: collision with root package name */
    private m f292600f;

    /* renamed from: h, reason: collision with root package name */
    protected Handler f292601h;

    /* renamed from: i, reason: collision with root package name */
    private c f292602i = new c();

    /* renamed from: m, reason: collision with root package name */
    protected List<Object> f292603m = new ArrayList();
    protected boolean J = false;
    protected boolean K = false;
    public int L = -1;
    protected View.OnClickListener M = new a();
    protected int E = 1;

    /* renamed from: e, reason: collision with root package name */
    private long f292599e = com.tencent.mobileqq.service.message.e.K0() * 1000;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getTag() instanceof b.a) {
                b.a aVar = (b.a) view.getTag();
                if (e.this.H != null && aVar.f292582a.isClickable()) {
                    e.this.H.onClick(view);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public e(AppInterface appInterface, Activity activity, m mVar, Handler handler) {
        this.C = appInterface;
        this.D = activity;
        this.f292598d = activity;
        this.f292600f = mVar;
        this.f292601h = handler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.teamworkforgroup.a.d
    public void a(int i3, h hVar) {
        m mVar;
        m mVar2;
        PadInfo padInfo = (PadInfo) hVar;
        if (i3 == R.id.azy && (mVar2 = this.f292600f) != null) {
            mVar2.D1(padInfo);
        }
        if (i3 == R.id.azw && (mVar = this.f292600f) != null) {
            mVar.X1(padInfo);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.g
    public void b(List<? extends Object> list) {
        this.f292603m.clear();
        if (list != null && !list.isEmpty()) {
            this.f292603m.addAll(list);
        } else {
            this.f292603m.add(this.f292602i);
        }
        notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.teamwork.g
    public void c(View.OnClickListener onClickListener) {
        this.H = onClickListener;
    }

    public void d(List<? extends Object> list) {
        if (list != null && !list.isEmpty()) {
            this.f292603m.addAll(list);
            Handler handler = this.f292601h;
            if (handler != null) {
                handler.sendEmptyMessage(4);
            }
            notifyDataSetChanged();
            return;
        }
        e();
        Handler handler2 = this.f292601h;
        if (handler2 != null) {
            handler2.sendEmptyMessage(3);
        }
    }

    public void e() {
        List<Object> list = this.f292603m;
        if (list != null) {
            list.clear();
        }
    }

    protected void f(b bVar) {
        if (bVar instanceof com.tencent.mobileqq.teamworkforgroup.a) {
            ((com.tencent.mobileqq.teamworkforgroup.a) bVar).h(this);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f292603m.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f292603m.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        return ((h) this.f292603m.get(i3)).getCloudFileType();
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        h hVar = (h) this.f292603m.get(i3);
        if (hVar.getCloudFileType() == 10) {
            k kVar = this.F;
            bVar = kVar;
            if (kVar == null) {
                k kVar2 = new k(this.C, this.D, this, this.E);
                this.F = kVar2;
                bVar = kVar2;
            }
        } else {
            j jVar = this.G;
            bVar = jVar;
            if (jVar == null) {
                j jVar2 = new j(this.C, this.D, this, this.E);
                this.G = jVar2;
                bVar = jVar2;
            }
        }
        b bVar2 = bVar;
        f(bVar2);
        View a16 = bVar2.a(i3, hVar, view, viewGroup, this.J, false, this.M, this.I, this.K, this.L);
        EventCollector.getInstance().onListGetView(i3, a16, viewGroup, getItemId(i3));
        return a16;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 12;
    }
}
