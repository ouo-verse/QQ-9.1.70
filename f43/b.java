package f43;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vasgift.mvvm.business.QQGiftPanelViewModel;
import com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPanelItemViewImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends BaseAdapter {

    /* renamed from: m, reason: collision with root package name */
    protected static final int f397826m = 2131243513;

    /* renamed from: d, reason: collision with root package name */
    protected final Context f397827d;

    /* renamed from: e, reason: collision with root package name */
    protected List<d> f397828e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    protected final com.tencent.mobileqq.vasgift.mvvm.business.a f397829f;

    /* renamed from: h, reason: collision with root package name */
    protected int f397830h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.qqgift.mvvm.business.data.b f397831i;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public View f397832a;

        public a(View view) {
            this.f397832a = view;
        }
    }

    public b(Context context, com.tencent.mobileqq.vasgift.mvvm.business.a aVar) {
        this.f397827d = context;
        this.f397829f = aVar;
    }

    protected sh2.b a(Context context) {
        QQGiftPanelItemViewImpl qQGiftPanelItemViewImpl = new QQGiftPanelItemViewImpl(context);
        qQGiftPanelItemViewImpl.setViewModel((QQGiftPanelViewModel) this.f397829f);
        return qQGiftPanelItemViewImpl;
    }

    public void b(List<d> list, int i3, com.tencent.mobileqq.qqgift.mvvm.business.data.b bVar) {
        this.f397828e.clear();
        this.f397828e.addAll(list);
        this.f397830h = i3;
        this.f397831i = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f397828e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f397828e.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        int i16;
        int i17;
        String str;
        d.b bVar;
        d dVar = this.f397828e.get(i3);
        if (view == null) {
            view = (View) a(this.f397827d);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        KeyEvent.Callback callback = aVar.f397832a;
        if (callback instanceof sh2.b) {
            sh2.b bVar2 = (sh2.b) callback;
            if (((IVasTempApi) QRoute.api(IVasTempApi.class)).isTabletDevice(BaseApplication.getContext())) {
                i16 = 10;
            } else {
                i16 = 8;
            }
            int i18 = this.f397830h;
            if (i18 > 0) {
                i17 = (i18 - 1) * i16;
            } else {
                i17 = 0;
            }
            bVar2.setIsSelected(dVar, i17 + i3);
            bVar2.d(dVar.C);
            bVar2.h(dVar.R, dVar.Q);
            bVar2.e(dVar.W, dVar.Z);
            if (dVar.f264881h == 6) {
                str = dVar.f264880g0;
            } else {
                str = "";
            }
            bVar2.f(dVar.f264876e, str);
            bVar2.a(f397826m);
            if (dVar.f264875d0) {
                List<d.b> list = dVar.f264879f0;
                if (list != null && !list.isEmpty()) {
                    bVar = dVar.f264879f0.get(0);
                } else {
                    bVar = null;
                }
                bVar2.c(dVar.f264876e, dVar.f264877e0, bVar);
            } else {
                bVar2.g(dVar.f264878f, dVar.f264881h);
            }
            com.tencent.mobileqq.qqgift.mvvm.business.data.b bVar3 = this.f397831i;
            if (bVar3 != null) {
                bVar2.b(dVar.f264875d0, bVar3);
            }
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }
}
