package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.agent.util.t;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CommonCardContainer extends LinearLayout {
    private static final int[] K = {R.string.f170822ak3};
    private static final int[] L = {R.drawable.cja};
    private static final int[] M = {R.id.epz};
    private View C;
    private View D;
    public g E;
    private String F;
    private f G;
    private ep3.d H;
    Context I;
    CardContainerHelper J;

    /* renamed from: d, reason: collision with root package name */
    protected CommonAuthorityAccountView f339753d;

    /* renamed from: e, reason: collision with root package name */
    private LayoutInflater f339754e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f339755f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f339756h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f339757i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f339758m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CommonCardContainer.this.f339753d.setMainAccountSelect(true);
            CommonCardContainer.this.E.c();
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
            Iterator it = CommonCardContainer.this.E.f339764d.iterator();
            while (it.hasNext()) {
                ((hp3.h) it.next()).f405844d = false;
            }
            t.b("CommonCardContainer", "onItemClick position=" + i3);
            ((hp3.h) CommonCardContainer.this.E.f339764d.get(i3)).f405844d = true;
            CommonCardContainer.this.f339753d.setMainAccountSelect(false);
            CommonCardContainer.this.E.notifyDataSetChanged();
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ep3.i f339761d;

        c(ep3.i iVar) {
            this.f339761d = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ep3.i iVar = this.f339761d;
            if (iVar != null) {
                iVar.a();
            } else {
                CommonCardContainer.this.H.i();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class d implements e {
        d() {
        }

        @Override // com.tencent.open.agent.CommonCardContainer.e
        public void a() {
            CommonCardContainer.this.H.b();
        }

        @Override // com.tencent.open.agent.CommonCardContainer.e
        public void b() {
            t.b("CommonCardContainer", "onAddAccount");
            CommonCardContainer.this.H.l();
            CommonCardContainer.this.e();
        }

        @Override // com.tencent.open.agent.CommonCardContainer.e
        public void c(String str, boolean z16) {
            CommonCardContainer.this.H.d(str, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface e {
        void a();

        void b();

        void c(String str, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface f {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class g extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private List<hp3.h> f339764d;

        /* renamed from: e, reason: collision with root package name */
        String f339765e;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f339767d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ h f339768e;

            a(int i3, h hVar) {
                this.f339767d = i3;
                this.f339768e = hVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (g.this.f339764d != null && this.f339767d < g.this.f339764d.size() && this.f339767d >= 0) {
                    this.f339768e.f339770a.h();
                    if (CommonCardContainer.this.getContext() != null && g.this.f339764d.get(this.f339767d) != null && CommonCardContainer.this.H != null) {
                        CommonCardContainer.this.H.e(((hp3.h) g.this.f339764d.get(this.f339767d)).f405843c, com.tencent.open.agent.util.p.m());
                    }
                    g.this.f339764d.remove(g.this.f339764d.get(this.f339767d));
                    g.this.notifyDataSetChanged();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        g() {
        }

        private void b(h hVar, int i3, View view) {
            hp3.h hVar2 = this.f339764d.get(i3);
            hVar.f339772c.setText(hVar2.f405842b);
            if (hVar2.f405844d) {
                hVar.f339773d.setVisibility(0);
                CommonCardContainer.this.f339753d.setMainAccountSelect(false);
            } else {
                hVar.f339773d.setVisibility(4);
            }
            if (hVar2.f405841a != null) {
                CommonCardContainer.this.n(hVar.f339771b, hVar2.f405841a);
            }
        }

        void c() {
            List<hp3.h> list = this.f339764d;
            if (list != null && list.size() > 0) {
                Iterator<hp3.h> it = this.f339764d.iterator();
                while (it.hasNext()) {
                    it.next().f405844d = false;
                }
                notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void d(List<hp3.h> list, String str) {
            if (this.f339764d != null) {
                if (str == null) {
                    str = "";
                }
                if (!str.equals(this.f339765e)) {
                    this.f339765e = str;
                } else if (list != null) {
                    for (hp3.h hVar : list) {
                        if (hVar.f405843c == CommonCardContainer.this.h()) {
                            hVar.f405844d = true;
                        } else {
                            hVar.f405844d = false;
                        }
                    }
                }
            }
            this.f339764d = list;
            notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void e(long j3) {
            for (hp3.h hVar : this.f339764d) {
                if (hVar.f405843c == j3) {
                    hVar.f405844d = true;
                } else {
                    hVar.f405844d = false;
                }
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<hp3.h> list = this.f339764d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            List<hp3.h> list = this.f339764d;
            if (list != null && i3 < list.size()) {
                return this.f339764d.get(i3);
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
            h hVar;
            int i16;
            if (view == null) {
                hVar = new h();
                View inflate = CommonCardContainer.this.f339754e.inflate(R.layout.ftr, viewGroup, false);
                hVar.f339771b = (URLImageView) inflate.findViewById(R.id.kzc);
                hVar.f339772c = (TextView) inflate.findViewById(R.id.kzf);
                if (OpenConfig.o()) {
                    boolean isNowThemeIsNight = ((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isNowThemeIsNight(null, false, null);
                    TextView textView = hVar.f339772c;
                    if (isNowThemeIsNight) {
                        i16 = -1;
                    } else {
                        i16 = -16777216;
                    }
                    textView.setTextColor(i16);
                }
                hVar.f339773d = (ImageView) inflate.findViewById(R.id.imc);
                hVar.f339774e = (Button) inflate.findViewById(R.id.bfz);
                hVar.f339770a = (SwipeMenuLayout) inflate;
                inflate.setTag(hVar);
                view2 = inflate;
            } else {
                view2 = view;
                hVar = (h) view.getTag();
            }
            b(hVar, i3, view2);
            hVar.f339774e.setOnClickListener(new a(i3, hVar));
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            int size;
            CommonCardContainer commonCardContainer = CommonCardContainer.this;
            List<hp3.h> list = this.f339764d;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            commonCardContainer.p(size);
            List<hp3.h> list2 = this.f339764d;
            if (list2 != null && list2.size() != 0) {
                Iterator<hp3.h> it = this.f339764d.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    if (it.next().f405844d) {
                        CommonCardContainer.this.f339753d.setMainAccountSelect(false);
                        z16 = true;
                    }
                }
                if (!z16) {
                    CommonCardContainer.this.f339753d.setMainAccountSelect(true);
                }
            } else {
                CommonCardContainer.this.f339753d.setMainAccountSelect(true);
            }
            super.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        private SwipeMenuLayout f339770a;

        /* renamed from: b, reason: collision with root package name */
        private URLImageView f339771b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f339772c;

        /* renamed from: d, reason: collision with root package name */
        private ImageView f339773d;

        /* renamed from: e, reason: collision with root package name */
        private Button f339774e;

        h() {
        }
    }

    public CommonCardContainer(Context context) {
        this(context, null);
        this.I = context;
    }

    private void k() {
        this.J = new CardContainerHelper(this);
    }

    private void m(TextView textView, boolean z16) {
        int i3;
        if (textView != null) {
            if (z16) {
                i3 = -1;
            } else {
                i3 = -16777216;
            }
            textView.setTextColor(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(ImageView imageView, String str) {
        Drawable drawable;
        if (imageView == null) {
            return;
        }
        URLDrawable uRLDrawable = null;
        try {
            drawable = getContext().getResources().getDrawable(R.drawable.f160830com);
        } catch (OutOfMemoryError e16) {
            t.d("CommonCardContainer", "-->create color drawable oom.", e16);
            drawable = null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
        } catch (IllegalArgumentException e17) {
            t.e("CommonCardContainer", "setVirtualIcon exception url=", str, ",excption=", e17.toString());
        }
        if (uRLDrawable != null) {
            uRLDrawable.setDecodeHandler(com.tencent.open.agent.util.p.j());
            if (uRLDrawable.getStatus() == 2) {
                uRLDrawable.restartDownload();
            }
            if (uRLDrawable.getStatus() != 2) {
                imageView.setImageDrawable(uRLDrawable);
            } else {
                t.b("CommonCardContainer", "getImageError: ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3) {
        if (i3 >= 3) {
            this.C.setVisibility(8);
            this.D.setVisibility(0);
        } else {
            this.C.setVisibility(0);
            this.D.setVisibility(8);
        }
    }

    private void s() {
        f fVar;
        this.J.f339709h.setVisibility(8);
        Context context = this.I;
        if (context instanceof QBaseActivity) {
            ImmersiveUtils.setStatusTextColor(false, ((QBaseActivity) context).getWindow());
        }
        Context context2 = this.I;
        if ((context2 instanceof PublicFragmentActivityForOpenSDK) && (fVar = this.G) != null) {
            fVar.a();
        } else if (context2 instanceof AuthorityActivity) {
            ((AuthorityActivity) context2).L2();
        } else if (context2 instanceof QuickLoginAuthorityActivity) {
            ((QuickLoginAuthorityActivity) context2).Q2();
        }
        int i3 = (int) (this.I.getResources().getDisplayMetrics().widthPixels * 0.64266664f);
        int height = i3 - this.J.f339708g.getHeight();
        CardContainerHelper cardContainerHelper = this.J;
        cardContainerHelper.h(cardContainerHelper.f339710i, i3, height, null);
    }

    public void e() {
        CommonAuthorityAccountView commonAuthorityAccountView = this.f339753d;
        if (commonAuthorityAccountView != null) {
            commonAuthorityAccountView.c();
        }
    }

    protected void f() {
        t.e("CommonCardContainer", "displayCoverContainer ");
        CardContainerHelper cardContainerHelper = this.J;
        if (!cardContainerHelper.f339706e) {
            cardContainerHelper.f339706e = true;
            s();
            this.J.f339710i.setVisibility(8);
            this.J.f339708g.setVisibility(8);
            this.J.f339709h.setVisibility(8);
        }
    }

    public boolean g(List<hp3.e> list, String str) {
        boolean z16;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.J.f339704c.clear();
        if (!TextUtils.isEmpty(str)) {
            this.f339757i.setText(str);
        }
        if (list.isEmpty()) {
            t.b("CommonCardContainer", "authList isEmpty");
        } else {
            StringBuilder sb5 = new StringBuilder(list.size() * 128);
            for (hp3.e eVar : list) {
                hp3.e eVar2 = new hp3.e();
                eVar2.f405823e = eVar.f405823e;
                eVar2.f405819a = eVar.f405819a;
                eVar2.f405824f = eVar.f405824f;
                eVar2.f405822d = eVar.f405822d;
                eVar2.f405820b = eVar.f405820b;
                sb5.append(eVar2.toString());
                sb5.append("\n");
                this.J.f339704c.add(eVar2);
            }
            t.b("CommonCardContainer", sb5.toString());
        }
        if (this.J.f339704c.size() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            URLImageView uRLImageView = this.J.f339710i;
            r(1);
            t.b("CommonCardContainer", "--> has been authority.");
            CardContainerHelper cardContainerHelper = this.J;
            cardContainerHelper.i(uRLImageView, cardContainerHelper.f(this.F));
        } else {
            r(0);
            t.b("CommonCardContainer", "--> has not been authority.");
        }
        return z16;
    }

    public long h() {
        if (this.E.f339764d != null && this.E.f339764d.size() > 0) {
            for (hp3.h hVar : this.E.f339764d) {
                if (hVar.f405844d) {
                    return hVar.f405843c;
                }
            }
            return 0L;
        }
        return 0L;
    }

    @Nullable
    public hp3.h i() {
        if (this.E.f339764d != null && this.E.f339764d.size() > 0) {
            for (hp3.h hVar : this.E.f339764d) {
                if (hVar.f405844d) {
                    return hVar;
                }
            }
            return null;
        }
        return null;
    }

    public String j() {
        g gVar = this.E;
        if (gVar == null) {
            return "";
        }
        String str = gVar.f339765e;
        CommonAuthorityAccountView commonAuthorityAccountView = this.f339753d;
        if (commonAuthorityAccountView == null) {
            return "";
        }
        return commonAuthorityAccountView.v(str);
    }

    public void l() {
        if (!this.J.f339706e) {
            return;
        }
        try {
            s();
        } catch (Exception e16) {
            t.d("CommonCardContainer", "Exception", e16);
        }
    }

    public void o(String str, Bitmap bitmap) {
        setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.f339756h.setText(str);
            this.f339756h.setTextColor(-16777216);
        }
        if (bitmap != null) {
            this.f339755f.setImageBitmap(bitmap);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.J.g();
        boolean z16 = false;
        t.b("CommonCardContainer", "onFinishInflate " + Log.getStackTraceString(new Throwable()));
        CommonAuthorityAccountView commonAuthorityAccountView = (CommonAuthorityAccountView) super.findViewById(R.id.f163903bt);
        this.f339753d = commonAuthorityAccountView;
        commonAuthorityAccountView.setOnClickListener(new a());
        if (OpenConfig.o()) {
            z16 = ((IThemeUtilApi) QRoute.api(IThemeUtilApi.class)).isNowThemeIsNight(null, false, null);
        }
        this.f339755f = (ImageView) super.findViewById(R.id.f164385vs);
        this.f339756h = (TextView) super.findViewById(R.id.f164387vu);
        TextView textView = (TextView) super.findViewById(R.id.w3);
        this.f339757i = textView;
        m(textView, z16);
        View findViewById = super.findViewById(R.id.f164384vr);
        findViewById.setFocusable(true);
        findViewById.setFocusableInTouchMode(true);
        findViewById.requestFocus();
        this.C = super.findViewById(R.id.bbw);
        TextView textView2 = (TextView) super.findViewById(R.id.ub8);
        this.f339758m = textView2;
        m(textView2, z16);
        this.D = super.findViewById(R.id.kzd);
        FitHeightListView fitHeightListView = (FitHeightListView) super.findViewById(R.id.kze);
        g gVar = new g();
        this.E = gVar;
        fitHeightListView.setAdapter((ListAdapter) gVar);
        fitHeightListView.setOnItemClickListener(new b());
        f();
    }

    public void q(String str) {
        CommonAuthorityAccountView commonAuthorityAccountView;
        if (!TextUtils.isEmpty(str) && (commonAuthorityAccountView = this.f339753d) != null) {
            commonAuthorityAccountView.t(str);
        }
    }

    public void r(int i3) {
        t.b("CommonCardContainer", "switchToMode -->mode: " + i3 + ", mMode=" + this.J.f339707f);
        this.J.j(this.F);
        this.J.f339707f = i3;
    }

    public void setCurrentAppId(String str) {
        this.F = str;
    }

    public void setOnUpdateStatusBarListener(f fVar) {
        this.G = fVar;
    }

    public void setPresenter(ep3.d dVar, ep3.i iVar) {
        t.b("CommonCardContainer", "setPresenter " + Log.getStackTraceString(new Throwable()));
        this.H = dVar;
        this.C.setOnClickListener(new c(iVar));
        this.f339753d.setAccountEventListener(new d());
    }

    public CommonCardContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = "";
        this.I = context;
        this.f339754e = (LayoutInflater) context.getSystemService("layout_inflater");
        k();
    }
}
