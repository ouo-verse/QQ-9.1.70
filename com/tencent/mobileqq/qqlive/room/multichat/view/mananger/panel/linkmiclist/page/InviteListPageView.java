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
import com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page.InviteListPageItemView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes17.dex */
public class InviteListPageView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private LoadingView C;
    private int D;
    private List<qn3.a> E;
    private long F;
    private RecyclerView.OnScrollListener G;

    /* renamed from: d, reason: collision with root package name */
    private TextView f271787d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f271788e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f271789f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f271790h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f271791i;

    /* renamed from: m, reason: collision with root package name */
    private d f271792m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InviteListPageView.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (1 == motionEvent.getAction()) {
                InviteListPageView.this.f271791i.setOnScrollListener(null);
                return false;
            }
            if (motionEvent.getAction() == 0) {
                InviteListPageView.this.f271791i.setOnScrollListener(InviteListPageView.this.G);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InviteListPageView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                InviteListPageView.a(InviteListPageView.this);
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportClickForCustomWindow(InviteListPageView.this.f271790h, new ConcurrentHashMap<>());
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InviteListPageView.this);
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
            if (!InviteListPageView.this.canScrollVertically(1) && i16 > 0 && InviteListPageView.this.E != null && InviteListPageView.this.E.size() > 0) {
                InviteListPageView.a(InviteListPageView.this);
            }
            if (i16 < 0) {
                InviteListPageView.this.C.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class d extends RecyclerView.Adapter<b> {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name */
        private InviteListPageItemView.b f271796m;

        /* loaded from: classes17.dex */
        class a implements InviteListPageItemView.b {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }

            @Override // com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page.InviteListPageItemView.b
            public void a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    InviteListPageView.this.F = System.currentTimeMillis();
                }
            }

            @Override // com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page.InviteListPageItemView.b
            public long b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return InviteListPageView.this.F;
                }
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes17.dex */
        public class b extends RecyclerView.ViewHolder {
            static IPatchRedirector $redirector_;
            private InviteListPageItemView E;

            public b(View view) {
                super(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) view);
                } else {
                    this.E = (InviteListPageItemView) view;
                }
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InviteListPageView.this);
            } else {
                this.f271796m = new a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            if (InviteListPageView.this.E == null) {
                return 0;
            }
            return InviteListPageView.this.E.size();
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
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                InviteListPageItemView inviteListPageItemView = bVar.E;
                InviteListPageView.a(InviteListPageView.this);
                inviteListPageItemView.setCallBack(null);
                bVar.E.e((qn3.a) InviteListPageView.this.E.get(i3));
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
            }
            InviteListPageItemView inviteListPageItemView = new InviteListPageItemView(InviteListPageView.this.getContext());
            InviteListPageView.a(InviteListPageView.this);
            inviteListPageItemView.setCallBack(null);
            inviteListPageItemView.setUiCallback(this.f271796m);
            return new b(inviteListPageItemView);
        }
    }

    public InviteListPageView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.D = 0;
        this.F = 0L;
        this.G = new c();
        j();
    }

    static /* bridge */ /* synthetic */ qi2.a a(InviteListPageView inviteListPageView) {
        inviteListPageView.getClass();
        return null;
    }

    private void j() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fmf, (ViewGroup) this, true);
        this.f271787d = (TextView) inflate.findViewById(R.id.f165090uu4);
        this.f271788e = (ViewGroup) inflate.findViewById(R.id.yjc);
        this.f271790h = (TextView) inflate.findViewById(R.id.xrl);
        this.f271789f = (TextView) inflate.findViewById(R.id.f115036uy);
        this.C = (LoadingView) inflate.findViewById(R.id.ys9);
        this.f271791i = (RecyclerView) inflate.findViewById(R.id.xrm);
        this.f271792m = new d();
        this.f271791i.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f271791i.setAdapter(this.f271792m);
        this.f271791i.setOnTouchListener(new a());
        this.f271790h.setOnClickListener(new b());
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

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindPageParamsToRootView(this, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID);
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindElementExcludeClickForCustomWindow(this.f271790h, IMultiAvChatReporter.ELEMENT_INVITE_FRIENTS, new ConcurrentHashMap<>());
        ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).bindElementExcludeClickForCustomWindow(this.f271791i, IMultiAvChatReporter.ELEMENT_MANAGEMENT, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateManagementElementParam(1));
    }

    public void setCallBack(qi2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    public void setData(List<qn3.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() != 0) {
            this.C.setVisibility(8);
            k(list);
            this.f271792m.notifyDataSetChanged();
            this.f271789f.setText("\u89c2\u4f17\u5217\u8868");
            List<qn3.a> list2 = this.E;
            if (list2 != null && list2.size() > 0) {
                this.f271787d.setVisibility(8);
                this.f271788e.setVisibility(0);
                return;
            } else {
                this.f271787d.setVisibility(0);
                this.f271788e.setVisibility(8);
                return;
            }
        }
        List<qn3.a> list3 = this.E;
        if (list3 != null && list3.size() > 0) {
            this.C.setLoadingStatus(false);
            return;
        }
        List<qn3.a> list4 = this.E;
        if (list4 == null || list4.size() <= 0) {
            this.f271787d.setVisibility(0);
            this.f271788e.setVisibility(8);
        }
    }

    public InviteListPageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.D = 0;
        this.F = 0L;
        this.G = new c();
        j();
    }

    public InviteListPageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = 0;
        this.F = 0L;
        this.G = new c();
        j();
    }
}
