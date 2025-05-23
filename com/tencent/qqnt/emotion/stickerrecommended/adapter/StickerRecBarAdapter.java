package com.tencent.qqnt.emotion.stickerrecommended.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import com.tencent.aio.data.AIOContact;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.emotion.stickerrecommended.IRecommendEmotionService;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.a;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.StickerRecKeywordFrom;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.ZPlanStickerRecPresenter;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.b;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.d;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.e;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.h;
import com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent;
import com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.qqnt.emotion.stickerrecommended.mvvm.g;
import com.tencent.qqnt.emotion.stickerrecommended.o;
import com.tencent.qqnt.emotion.stickerrecommended.p;
import com.tencent.qqnt.emotion.stickerrecommended.view.EmotionKeywordHorizonListView;
import com.tencent.util.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class StickerRecBarAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_;
    private static int M;
    public static final int N;
    public static final int P;
    public static final int Q;
    private EditText C;
    private String D;
    private String E;
    private int F;
    private String G;
    private StickerRecKeywordFrom H;
    private IStickerRecManager I;
    private EmotionKeywordHorizonListView J;
    private com.tencent.qqnt.emotion.stickerrecommended.adapter.a K;
    private g L;

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.qqnt.emotion.stickerrecommended.g> f356448d;

    /* renamed from: e, reason: collision with root package name */
    private Context f356449e;

    /* renamed from: f, reason: collision with root package name */
    private AppInterface f356450f;

    /* renamed from: h, reason: collision with root package name */
    private AIOContact f356451h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f356452i;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f356453m;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    class a implements a.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StickerRecBarAdapter.this);
            }
        }

        @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.a.b
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                StickerRecBarAdapter.this.o(z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45491);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
            return;
        }
        int i3 = 0 + 1;
        N = 0;
        int i16 = i3 + 1;
        M = i16;
        P = i3;
        Q = i16;
    }

    public StickerRecBarAdapter(Context context, AppInterface appInterface, com.tencent.aio.api.runtime.a aVar, ViewGroup viewGroup, EditText editText, EmotionKeywordHorizonListView emotionKeywordHorizonListView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, aVar, viewGroup, editText, emotionKeywordHorizonListView);
            return;
        }
        this.F = 0;
        this.f356449e = context;
        this.f356450f = appInterface;
        this.f356448d = new ArrayList();
        this.f356452i = aVar;
        this.f356453m = viewGroup;
        this.f356451h = aVar.g().r().c();
        this.C = editText;
        this.I = StickerRecManagerImpl.get(appInterface);
        this.J = emotionKeywordHorizonListView;
        this.K = new com.tencent.qqnt.emotion.stickerrecommended.adapter.a();
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        this.f356448d.clear();
        com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.a.j();
        ZPlanStickerRecPresenter.j();
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else if (this.f356448d.size() > 0) {
            StickerRecManagerImpl.get(this.f356450f).collectReportData(this.f356448d, this.D, this.E, this.F);
        }
    }

    public d e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (d) iPatchRedirector.redirect((short) 18, (Object) this, i3);
        }
        if (i3 == P) {
            return new ZPlanStickerRecPresenter(this.f356450f, this.f356452i, this.C);
        }
        return new com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.a(this.f356450f, this.f356452i, this.C);
    }

    public e f(int i3, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (e) iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) dVar);
        }
        if (i3 == P) {
            return new h(dVar, this.f356449e, this.f356452i, this.f356453m, this.C, this.f356450f);
        }
        return new b(dVar, this.f356449e, this.f356452i, this.f356453m, this.C);
    }

    public com.tencent.qqnt.emotion.stickerrecommended.g g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.qqnt.emotion.stickerrecommended.g) iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
        if (i3 >= this.f356448d.size()) {
            if (QLog.isColorLevel()) {
                QLog.e("StickerRecBarAdapter", 2, "get view position exception , position = " + i3 + ",size = " + this.f356448d.size());
                return null;
            }
            return null;
        }
        return this.f356448d.get(i3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        List<com.tencent.qqnt.emotion.stickerrecommended.g> list = this.f356448d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        return this.f356448d.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, i3)).intValue();
        }
        if (p.a(g(i3))) {
            return P;
        }
        return N;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        e eVar;
        View view2;
        d presenter;
        View view3;
        View view4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            view3 = (View) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), view, viewGroup);
        } else if (i3 >= this.f356448d.size()) {
            if (QLog.isColorLevel()) {
                QLog.e("StickerRecBarAdapter", 2, "get view position exception , position = " + i3 + ",size = " + this.f356448d.size());
            }
            view3 = null;
        } else {
            com.tencent.qqnt.emotion.stickerrecommended.g gVar = this.f356448d.get(i3);
            if (view == null) {
                presenter = e(getItemViewType(i3));
                eVar = f(getItemViewType(i3), presenter);
                view2 = eVar.getView();
                view2.setTag(eVar);
            } else {
                eVar = (e) view.getTag();
                view2 = view;
                presenter = eVar.getPresenter();
            }
            eVar.a(this.H);
            presenter.a(this.H);
            presenter.b(this.D, this.F);
            presenter.c(eVar, gVar);
            view3 = view2;
            view4 = view3;
            EventCollector.getInstance().onListGetView(i3, view4, viewGroup, getItemId(i3));
            return view3;
        }
        view4 = view;
        EventCollector.getInstance().onListGetView(i3, view4, viewGroup, getItemId(i3));
        return view3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return Q;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        try {
            d();
            ThreadManager.getFileThreadHandler().post(new Runnable(com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.a.k()) { // from class: com.tencent.qqnt.emotion.stickerrecommended.adapter.StickerRecBarAdapter.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f356454d;

                {
                    this.f356454d = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StickerRecBarAdapter.this, (Object) r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IStickerRecManager iStickerRecManager = StickerRecManagerImpl.get(StickerRecBarAdapter.this.f356450f);
                    iStickerRecManager.updateSort(StickerRecBarAdapter.this.f356451h);
                    iStickerRecManager.updateStickerLastTime(this.f356454d);
                }
            });
        } finally {
            try {
            } finally {
            }
        }
    }

    public void i(StickerRecKeywordFrom stickerRecKeywordFrom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) stickerRecKeywordFrom);
        } else {
            this.H = stickerRecKeywordFrom;
        }
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.D = str;
        }
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.E = str;
        }
    }

    public void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.F = i3;
        }
    }

    public void m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.G = str;
        }
    }

    public void n(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
        } else {
            this.L = gVar;
        }
    }

    public boolean o(boolean z16) {
        com.tencent.aio.api.runtime.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, z16)).booleanValue();
        }
        if (this.L.R1()) {
            return false;
        }
        if (this.F != 1) {
            String specKeyWord = ((IRecommendEmotionService) QRoute.api(IRecommendEmotionService.class)).getSpecKeyWord(this.f356452i);
            if (!TextUtils.isEmpty(specKeyWord)) {
                if (z16 && this.D.equalsIgnoreCase(specKeyWord)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecBarAdapter", 2, "showEmotionKeywordLayout isNeedShow = ", Boolean.valueOf(z16), ", word = ", k.f(this.D, Arrays.asList("word")));
        }
        if (z16 && (aVar = this.f356452i) != null) {
            aVar.e().h(new StickerRecommendEvent.ShowEmotionKeywordLayout(this.G));
        }
        return z16;
    }

    public void setData(List<com.tencent.qqnt.emotion.stickerrecommended.g> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        if (list != null && !list.isEmpty()) {
            this.L.f0(false);
            QLog.e("StickerRecBarAdapter", 1, "setData");
            c();
            this.f356448d.addAll(list);
            this.J.resetCurrentX(0);
            this.K.l(new a());
            this.K.h(this.f356448d);
            notifyDataSetChanged();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("setData:");
                for (com.tencent.qqnt.emotion.stickerrecommended.g gVar : list) {
                    if (gVar != null && StickerRecManagerImpl.isStickerRecFromRemote(gVar)) {
                        sb5.append("thumb=");
                        sb5.append(((o) gVar).getThumbUrl());
                        sb5.append(",");
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecBarAdapter", 2, sb5.toString());
                    return;
                }
                return;
            }
            return;
        }
        QLog.e("StickerRecBarAdapter", 1, "setData data is null or empty");
    }
}
