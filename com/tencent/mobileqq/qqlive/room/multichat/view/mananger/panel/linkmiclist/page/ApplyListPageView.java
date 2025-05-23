package com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page.ApplyListPageItemView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes17.dex */
public class ApplyListPageView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private long C;
    private int D;
    private List<qn3.a> E;
    private RecyclerView.OnScrollListener F;

    /* renamed from: d, reason: collision with root package name */
    private TextView f271769d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f271770e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f271771f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f271772h;

    /* renamed from: i, reason: collision with root package name */
    private d f271773i;

    /* renamed from: m, reason: collision with root package name */
    private LoadingView f271774m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ApplyListPageView.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (1 == motionEvent.getAction()) {
                ApplyListPageView.this.f271772h.setOnScrollListener(null);
                return false;
            }
            if (motionEvent.getAction() == 0) {
                ApplyListPageView.this.f271772h.setOnScrollListener(ApplyListPageView.this.F);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ApplyListPageView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ApplyListPageView.b(ApplyListPageView.this);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes17.dex */
    class c extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ApplyListPageView.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            super.onScrolled(recyclerView, i3, i16);
            if (!ApplyListPageView.this.canScrollVertically(1) && i16 > 0 && ApplyListPageView.this.E != null && ApplyListPageView.this.E.size() > 0) {
                ApplyListPageView.b(ApplyListPageView.this);
            }
            if (i16 < 0) {
                ApplyListPageView.this.f271774m.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class d extends RecyclerView.Adapter<b> {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name */
        private ApplyListPageItemView.c f271778m;

        /* loaded from: classes17.dex */
        class a implements ApplyListPageItemView.c {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page.ApplyListPageItemView.c
            public void a(qn3.a aVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                } else {
                    ApplyListPageView.this.E.remove(aVar);
                    ApplyListPageView.this.f271773i.notifyDataSetChanged();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes17.dex */
        public class b extends RecyclerView.ViewHolder {
            static IPatchRedirector $redirector_;
            private ApplyListPageItemView E;

            public b(View view) {
                super(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) view);
                } else {
                    this.E = (ApplyListPageItemView) view;
                }
            }

            void l(qn3.a aVar) {
                this.E.d(aVar);
                ApplyListPageItemView applyListPageItemView = this.E;
                ApplyListPageView.b(ApplyListPageView.this);
                applyListPageItemView.setCallBack(null);
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ApplyListPageView.this);
            } else {
                this.f271778m = new a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            if (ApplyListPageView.this.E == null) {
                return 0;
            }
            return ApplyListPageView.this.E.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(b bVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar, i3);
            } else if (ApplyListPageView.this.E != null && i3 < ApplyListPageView.this.E.size()) {
                bVar.l((qn3.a) ApplyListPageView.this.E.get(i3));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            ApplyListPageItemView applyListPageItemView = new ApplyListPageItemView(ApplyListPageView.this.getContext());
            applyListPageItemView.setUiCallBack(this.f271778m);
            return new b(applyListPageItemView);
        }
    }

    public ApplyListPageView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.C = 0L;
        this.D = 0;
        this.F = new c();
        j();
    }

    static /* bridge */ /* synthetic */ qi2.a b(ApplyListPageView applyListPageView) {
        applyListPageView.getClass();
        return null;
    }

    private void j() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fmb, (ViewGroup) this, true);
        this.f271769d = (TextView) inflate.findViewById(R.id.f165090uu4);
        this.f271770e = (ViewGroup) inflate.findViewById(R.id.yjc);
        this.f271771f = (TextView) inflate.findViewById(R.id.txj);
        this.f271774m = (LoadingView) inflate.findViewById(R.id.ys9);
        this.f271772h = (RecyclerView) inflate.findViewById(R.id.suu);
        this.f271773i = new d();
        this.f271772h.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f271772h.setAdapter(this.f271773i);
        this.f271772h.setOnTouchListener(new a());
        this.f271771f.setOnClickListener(new b());
    }

    private void k(List<qn3.a> list) {
        List<qn3.a> list2;
        boolean z16;
        if (this.D != 0 && (list2 = this.E) != null && list2.size() != 0) {
            for (qn3.a aVar : list) {
                Iterator<qn3.a> it = this.E.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (aVar.f429099b == it.next().f429099b) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    this.E.add(aVar);
                }
            }
            return;
        }
        this.E = list;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindPageParamsToRootView(this, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID);
            ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindElementExcludeClickForCustomWindow(this.f271772h, IMultiAvChatReporter.ELEMENT_MANAGEMENT, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateManagementElementParam(0));
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        List<qn3.a> list = this.E;
        if (list != null) {
            list.clear();
        }
        this.f271773i.notifyDataSetChanged();
        this.D = 0;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.E.size();
    }

    public void setCallBack(qi2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        }
    }

    public void setData(List<qn3.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() != 0) {
            this.f271774m.setVisibility(8);
            k(list);
            this.f271773i.notifyDataSetChanged();
            List<qn3.a> list2 = this.E;
            if (list2 != null && list2.size() > 0) {
                this.f271769d.setVisibility(8);
                this.f271770e.setVisibility(0);
                return;
            } else {
                this.f271769d.setVisibility(0);
                this.f271770e.setVisibility(8);
                return;
            }
        }
        if (this.D == 0) {
            h();
        }
        List<qn3.a> list3 = this.E;
        if (list3 != null && list3.size() > 0) {
            this.f271774m.setLoadingStatus(false);
            return;
        }
        List<qn3.a> list4 = this.E;
        if (list4 == null || list4.size() <= 0) {
            this.f271769d.setVisibility(0);
            this.f271770e.setVisibility(8);
        }
    }

    public ApplyListPageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.C = 0L;
        this.D = 0;
        this.F = new c();
        j();
    }

    public ApplyListPageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.C = 0L;
        this.D = 0;
        this.F = new c();
        j();
    }
}
