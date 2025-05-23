package com.tencent.open.agent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.open.agent.util.t;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenCardNewContainer extends BaseCardContainer {
    private static final int[] W = {R.string.f170822ak3};

    /* renamed from: a0, reason: collision with root package name */
    private static final int[] f339879a0 = {R.drawable.cja};

    /* renamed from: b0, reason: collision with root package name */
    private static final int[] f339880b0 = {R.id.epz};
    protected OpenAuthorityAccountNewView H;
    private LayoutInflater I;
    private ImageView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private View N;
    private View P;
    private View.OnClickListener Q;
    private View R;
    private View S;
    public h T;
    public e U;
    private String V;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            OpenCardNewContainer.this.H.setMainAccountSelect(true);
            OpenCardNewContainer.this.T.c();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            Iterator it = OpenCardNewContainer.this.T.f339891d.iterator();
            while (it.hasNext()) {
                ((hp3.h) it.next()).f405844d = false;
            }
            t.b("OpenCardNewContainer", "onItemClick position=" + i3);
            ((hp3.h) OpenCardNewContainer.this.T.f339891d.get(i3)).f405844d = true;
            OpenCardNewContainer.this.H.setMainAccountSelect(false);
            OpenCardNewContainer.this.T.notifyDataSetChanged();
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class c implements d {
        c() {
        }

        @Override // com.tencent.open.agent.OpenCardNewContainer.d
        public void a() {
            OpenCardNewContainer.n(OpenCardNewContainer.this);
            throw null;
        }

        @Override // com.tencent.open.agent.OpenCardNewContainer.d
        public void b() {
            t.b("OpenCardNewContainer", "onAddAccount");
            OpenCardNewContainer.n(OpenCardNewContainer.this);
            throw null;
        }

        @Override // com.tencent.open.agent.OpenCardNewContainer.d
        public void c(String str, boolean z16) {
            OpenCardNewContainer.n(OpenCardNewContainer.this);
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface d {
        void a();

        void b();

        void c(String str, boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        List<hp3.e> f339884d;

        /* renamed from: e, reason: collision with root package name */
        String f339885e;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ hp3.e f339887d;

            a(hp3.e eVar) {
                this.f339887d = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                this.f339887d.f405825g = ((Switch) view).isChecked();
                hp3.e eVar = this.f339887d;
                com.tencent.open.agent.util.g.Q(null, "0X800B936", eVar.f405825g ? 1 : 0, new String[]{OpenCardNewContainer.this.V, "", e.this.f339885e, eVar.f405820b});
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        e() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<hp3.e> list = this.f339884d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            List<hp3.e> list = this.f339884d;
            if (list != null && i3 < list.size()) {
                return this.f339884d.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            f fVar;
            hp3.e eVar = this.f339884d.get(i3);
            if (view == null) {
                view = OpenCardNewContainer.this.I.inflate(R.layout.f168472x3, viewGroup, false);
                fVar = new f();
                fVar.f339889a = (TextView) view.findViewById(R.id.f240107z);
                fVar.f339890b = (Switch) view.findViewById(R.id.flh);
                view.setTag(fVar);
            } else {
                fVar = (f) view.getTag();
            }
            fVar.f339890b.setChecked(eVar.f405825g);
            fVar.f339890b.setOnClickListener(new a(eVar));
            fVar.f339889a.setText(eVar.f405820b);
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        public void setData(List<hp3.e> list) {
            this.f339884d = list;
            notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class f {

        /* renamed from: a, reason: collision with root package name */
        TextView f339889a;

        /* renamed from: b, reason: collision with root package name */
        Switch f339890b;

        f() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface g {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class h extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private List<hp3.h> f339891d;

        /* renamed from: e, reason: collision with root package name */
        String f339892e;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f339894d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ i f339895e;

            a(int i3, i iVar) {
                this.f339894d = i3;
                this.f339895e = iVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (h.this.f339891d != null && this.f339894d < h.this.f339891d.size() && this.f339894d >= 0) {
                    this.f339895e.f339897a.h();
                    h hVar = h.this;
                    if (OpenCardNewContainer.this.f339595d != null && hVar.f339891d.get(this.f339894d) != null) {
                        OpenCardNewContainer.n(OpenCardNewContainer.this);
                    }
                    h.this.f339891d.remove(h.this.f339891d.get(this.f339894d));
                    h.this.notifyDataSetChanged();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        h() {
        }

        private void b(i iVar, int i3) {
            hp3.h hVar = this.f339891d.get(i3);
            iVar.f339899c.setText(hVar.f405842b);
            if (hVar.f405844d) {
                iVar.f339900d.setVisibility(0);
                OpenCardNewContainer.this.H.setMainAccountSelect(false);
            } else {
                iVar.f339900d.setVisibility(4);
            }
            if (hVar.f405841a != null) {
                OpenCardNewContainer.this.s(iVar.f339898b, hVar.f405841a);
            }
        }

        void c() {
            List<hp3.h> list = this.f339891d;
            if (list != null && list.size() > 0) {
                Iterator<hp3.h> it = this.f339891d.iterator();
                while (it.hasNext()) {
                    it.next().f405844d = false;
                }
                notifyDataSetChanged();
            }
        }

        void d(List<hp3.h> list, String str) {
            boolean z16;
            if (this.f339891d != null) {
                if (str == null) {
                    str = "";
                }
                if (!str.equals(this.f339892e)) {
                    this.f339892e = str;
                } else if (list != null) {
                    for (hp3.h hVar : list) {
                        if (hVar.f405843c == OpenCardNewContainer.this.q()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        hVar.f405844d = z16;
                    }
                }
            }
            this.f339891d = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<hp3.h> list = this.f339891d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            List<hp3.h> list = this.f339891d;
            if (list != null && i3 < list.size()) {
                return this.f339891d.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            i iVar;
            if (view == null) {
                iVar = new i();
                View inflate = OpenCardNewContainer.this.I.inflate(R.layout.f168471x2, viewGroup, false);
                iVar.f339898b = (URLImageView) inflate.findViewById(R.id.kzc);
                iVar.f339899c = (TextView) inflate.findViewById(R.id.kzf);
                iVar.f339900d = (ImageView) inflate.findViewById(R.id.imc);
                iVar.f339901e = (Button) inflate.findViewById(R.id.bfz);
                iVar.f339897a = (SwipeMenuLayout) inflate;
                inflate.setTag(iVar);
                view2 = inflate;
            } else {
                view2 = view;
                iVar = (i) view.getTag();
            }
            b(iVar, i3);
            iVar.f339901e.setOnClickListener(new a(i3, iVar));
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            int size;
            OpenCardNewContainer openCardNewContainer = OpenCardNewContainer.this;
            List<hp3.h> list = this.f339891d;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            openCardNewContainer.t(size);
            List<hp3.h> list2 = this.f339891d;
            if (list2 != null && list2.size() != 0) {
                Iterator<hp3.h> it = this.f339891d.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    if (it.next().f405844d) {
                        OpenCardNewContainer.this.H.setMainAccountSelect(false);
                        z16 = true;
                    }
                }
                if (!z16) {
                    OpenCardNewContainer.this.H.setMainAccountSelect(true);
                }
            } else {
                OpenCardNewContainer.this.H.setMainAccountSelect(true);
            }
            super.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private SwipeMenuLayout f339897a;

        /* renamed from: b, reason: collision with root package name */
        private URLImageView f339898b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f339899c;

        /* renamed from: d, reason: collision with root package name */
        private ImageView f339900d;

        /* renamed from: e, reason: collision with root package name */
        private Button f339901e;

        i() {
        }
    }

    public OpenCardNewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = "";
        this.I = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    static /* bridge */ /* synthetic */ ep3.h n(OpenCardNewContainer openCardNewContainer) {
        openCardNewContainer.getClass();
        return null;
    }

    private void r(int i3) {
        OpenAuthorityAccountNewView openAuthorityAccountNewView = this.H;
        if (openAuthorityAccountNewView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) openAuthorityAccountNewView.getLayoutParams();
        if (i3 == 1) {
            layoutParams.setMargins(BaseAIOUtils.f(16.0f, getResources()), layoutParams.topMargin, BaseAIOUtils.f(16.0f, getResources()), layoutParams.bottomMargin);
            this.H.setLayoutParams(layoutParams);
            this.H.setBackgroundResource(R.drawable.k6a);
        } else {
            layoutParams.setMargins(0, layoutParams.topMargin, 0, layoutParams.bottomMargin);
            this.H.setLayoutParams(layoutParams);
            this.H.setBackgroundResource(17170445);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(ImageView imageView, String str) {
        Drawable drawable;
        if (imageView == null) {
            return;
        }
        URLDrawable uRLDrawable = null;
        try {
            drawable = this.f339595d.getResources().getDrawable(R.drawable.f160830com);
        } catch (OutOfMemoryError e16) {
            t.d("OpenCardNewContainer", "-->create color drawable oom.", e16);
            drawable = null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
        } catch (IllegalArgumentException e17) {
            t.e("OpenCardNewContainer", "setVirtualIcon exception url=", str, ",excption=", e17.toString());
        }
        if (uRLDrawable != null) {
            uRLDrawable.setDecodeHandler(com.tencent.open.agent.util.p.j());
            if (uRLDrawable.getStatus() == 2) {
                uRLDrawable.restartDownload();
            }
            if (uRLDrawable.getStatus() != 2) {
                imageView.setImageDrawable(uRLDrawable);
            } else {
                t.b("OpenCardNewContainer", "getImageError: ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3) {
        if (i3 >= 3) {
            this.R.setVisibility(8);
            this.S.setVisibility(0);
        } else {
            this.R.setVisibility(0);
            this.S.setVisibility(8);
        }
    }

    private void u() {
        this.D.setVisibility(0);
        Context context = this.f339595d;
        if (context instanceof QBaseActivity) {
            ImmersiveUtils.setStatusTextColor(false, ((QBaseActivity) context).getWindow());
        }
        Context context2 = this.f339595d;
        boolean z16 = context2 instanceof PublicFragmentActivityForOpenSDK;
        if (context2 instanceof AuthorityActivity) {
            ((AuthorityActivity) context2).L2();
        } else if (context2 instanceof QuickLoginAuthorityActivity) {
            ((QuickLoginAuthorityActivity) context2).Q2();
        }
        int i3 = (int) (this.f339595d.getResources().getDisplayMetrics().widthPixels * 0.64266664f);
        i(this.E, i3, i3 - this.C.getHeight(), null);
    }

    @Override // com.tencent.open.agent.BaseCardContainer
    protected void e() {
        t.e("OpenCardNewContainer", "displayCoverContainer ");
        if (!this.f339599i) {
            this.f339599i = true;
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.BaseCardContainer, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        t.b("OpenCardNewContainer", "onFinishInflate " + Log.getStackTraceString(new Throwable()));
        OpenAuthorityAccountNewView openAuthorityAccountNewView = (OpenAuthorityAccountNewView) super.findViewById(R.id.f163903bt);
        this.H = openAuthorityAccountNewView;
        openAuthorityAccountNewView.setOnClickListener(new a());
        this.H.T.setOnClickListener(this.Q);
        this.J = (ImageView) super.findViewById(R.id.f164385vs);
        this.K = (TextView) super.findViewById(R.id.f164387vu);
        this.L = (TextView) super.findViewById(R.id.w3);
        this.M.setVisibility(8);
        this.N = super.findViewById(R.id.f11992786);
        this.P.setVisibility(8);
        View findViewById = super.findViewById(R.id.f164384vr);
        findViewById.setFocusable(true);
        findViewById.setFocusableInTouchMode(true);
        findViewById.requestFocus();
        this.R = super.findViewById(R.id.bbw);
        this.S = super.findViewById(R.id.kzd);
        FitHeightListView fitHeightListView = (FitHeightListView) super.findViewById(R.id.kze);
        h hVar = new h();
        this.T = hVar;
        fitHeightListView.setAdapter((ListAdapter) hVar);
        fitHeightListView.setOnItemClickListener(new b());
        ListView listView = (ListView) super.findViewById(R.id.fle);
        e eVar = new e();
        this.U = eVar;
        listView.setAdapter((ListAdapter) eVar);
    }

    public long q() {
        if (this.H.w()) {
            return this.H.v();
        }
        if (this.T.f339891d != null && this.T.f339891d.size() > 0) {
            for (hp3.h hVar : this.T.f339891d) {
                if (hVar.f405844d) {
                    return hVar.f405843c;
                }
            }
            return 0L;
        }
        return 0L;
    }

    public void setAccountEventListener(d dVar) {
        if (dVar != null) {
            this.H.setAccountEventListener(dVar);
        }
    }

    public void setAddVirtualAccountClickListener(View.OnClickListener onClickListener) {
        this.R.setOnClickListener(onClickListener);
    }

    public void setCurrentAppId(String str) {
        this.V = str;
    }

    public void setOnChangeAccountClickListener(View.OnClickListener onClickListener) {
        this.Q = onClickListener;
    }

    public void setPermissionListData(List<hp3.e> list) {
        if (this.U != null && list != null && list.size() != 0) {
            this.H.setPermissionListMode(true);
            r(1);
            this.P.setVisibility(0);
            this.U.setData(list);
            setPermissionTipsVisibility();
            this.N.setVisibility(8);
        }
    }

    public void setPermissionTipsVisibility() {
        e eVar;
        int i3;
        TextView textView = this.M;
        if (textView != null && (eVar = this.U) != null) {
            if (eVar.getCount() == 0) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            textView.setVisibility(i3);
        }
    }

    public void setPresenter(ep3.h hVar) {
        t.b("OpenCardNewContainer", "setPresenter " + Log.getStackTraceString(new Throwable()));
        this.H.setAccountEventListener(new c());
    }

    public void setVirtualListData(List<hp3.h> list, String str) {
        e eVar = this.U;
        if (eVar == null || eVar.getCount() == 0) {
            this.H.setPermissionListMode(false);
            r(0);
            this.P.setVisibility(8);
            this.N.setVisibility(0);
            this.T.d(list, str);
        }
    }

    public void setOnUpdateStatusBarListener(g gVar) {
    }
}
