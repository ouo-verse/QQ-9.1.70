package com.tencent.open.agent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.open.agent.util.t;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenCardContainer extends BaseCardContainer {
    private static final int[] T = {R.string.f170822ak3};
    private static final int[] U = {R.drawable.cja};
    private static final int[] V = {R.id.epz};
    protected OpenAuthorityAccountView H;
    private LayoutInflater I;
    private ImageView J;
    private TextView K;
    private TextView L;
    private View M;
    private View N;
    public e P;
    private String Q;
    private d R;
    private ep3.d S;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            OpenCardContainer.this.H.setMainAccountSelect(true);
            OpenCardContainer.this.P.c();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements c {
        b() {
        }

        @Override // com.tencent.open.agent.OpenCardContainer.c
        public void a() {
            OpenCardContainer.this.S.b();
        }

        @Override // com.tencent.open.agent.OpenCardContainer.c
        public void b() {
            t.b("OpenCardContainer", "onAddAccount");
            OpenCardContainer.this.S.l();
            OpenCardContainer.this.p();
        }

        @Override // com.tencent.open.agent.OpenCardContainer.c
        public void c(String str, boolean z16) {
            OpenCardContainer.this.S.d(str, z16);
        }

        @Override // com.tencent.open.agent.OpenCardContainer.c
        public String getCurrentAccount() {
            return OpenCardContainer.this.S.getCurrentAccount();
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface c {
        void a();

        void b();

        void c(String str, boolean z16);

        String getCurrentAccount();
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private List<hp3.h> f339864d;

        /* renamed from: e, reason: collision with root package name */
        String f339865e;

        /* renamed from: f, reason: collision with root package name */
        boolean f339866f = false;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ f f339868d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f339869e;

            a(f fVar, int i3) {
                this.f339868d = fVar;
                this.f339869e = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z16;
                EventCollector.getInstance().onViewClickedBefore(view);
                this.f339868d.f339873a.h();
                if (e.this.f339864d != null && this.f339869e < e.this.f339864d.size() && this.f339869e >= 0) {
                    e eVar = e.this;
                    if (OpenCardContainer.this.f339595d != null && eVar.f339864d.get(this.f339869e) != null && OpenCardContainer.this.S != null) {
                        z16 = OpenCardContainer.this.S.e(((hp3.h) e.this.f339864d.get(this.f339869e)).f405843c, com.tencent.open.agent.util.p.m());
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        e.this.f339864d.remove(e.this.f339864d.get(this.f339869e));
                        e.this.notifyDataSetChanged();
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class b implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f339871d;

            b(int i3) {
                this.f339871d = i3;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (e.this.f339864d != null && this.f339871d < e.this.f339864d.size() && this.f339871d >= 0) {
                    Iterator it = OpenCardContainer.this.P.f339864d.iterator();
                    while (it.hasNext()) {
                        ((hp3.h) it.next()).f405844d = false;
                    }
                    t.b("OpenCardContainer", "onItemClick position=" + this.f339871d);
                    ((hp3.h) e.this.f339864d.get(this.f339871d)).f405844d = true;
                    OpenCardContainer.this.H.setMainAccountSelect(false);
                    e.this.notifyDataSetChanged();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        e() {
        }

        private void b(f fVar, int i3) {
            hp3.h hVar = this.f339864d.get(i3);
            fVar.f339876d.setText(hVar.f405842b);
            if (hVar.f405844d) {
                fVar.f339877e.setVisibility(0);
                OpenCardContainer.this.H.setMainAccountSelect(false);
            } else {
                fVar.f339877e.setVisibility(4);
            }
            if (hVar.f405841a != null) {
                OpenCardContainer.this.t(fVar.f339875c, hVar.f405841a);
            }
        }

        void c() {
            List<hp3.h> list = this.f339864d;
            if (list != null && list.size() > 0) {
                Iterator<hp3.h> it = this.f339864d.iterator();
                while (it.hasNext()) {
                    it.next().f405844d = false;
                }
                notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void d(List<hp3.h> list, String str) {
            if (this.f339864d != null) {
                if (str == null) {
                    str = "";
                }
                if (!str.equals(this.f339865e)) {
                    this.f339865e = str;
                } else if (list != null) {
                    for (hp3.h hVar : list) {
                        if (hVar.f405843c == OpenCardContainer.this.r()) {
                            hVar.f405844d = true;
                        } else {
                            hVar.f405844d = false;
                        }
                    }
                }
            }
            this.f339866f = true;
            this.f339864d = list;
            notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void e(long j3) {
            for (hp3.h hVar : this.f339864d) {
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
            List<hp3.h> list = this.f339864d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            List<hp3.h> list = this.f339864d;
            if (list != null && i3 < list.size()) {
                return this.f339864d.get(i3);
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
            f fVar;
            if (view == null) {
                fVar = new f();
                View inflate = OpenCardContainer.this.I.inflate(R.layout.f168471x2, viewGroup, false);
                fVar.f339874b = inflate.findViewById(R.id.b8q);
                fVar.f339875c = (URLImageView) inflate.findViewById(R.id.kzc);
                fVar.f339876d = (TextView) inflate.findViewById(R.id.kzf);
                fVar.f339877e = (ImageView) inflate.findViewById(R.id.imc);
                fVar.f339878f = (Button) inflate.findViewById(R.id.bfz);
                fVar.f339873a = (SwipeMenuLayout) inflate;
                inflate.setTag(fVar);
                view2 = inflate;
            } else {
                view2 = view;
                fVar = (f) view.getTag();
            }
            if (this.f339866f && SwipeMenuLayout.f() == fVar.f339873a) {
                fVar.f339873a.l();
                this.f339866f = false;
            }
            b(fVar, i3);
            fVar.f339878f.setOnClickListener(new a(fVar, i3));
            fVar.f339874b.setOnClickListener(new b(i3));
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            int size;
            OpenCardContainer openCardContainer = OpenCardContainer.this;
            List<hp3.h> list = this.f339864d;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            openCardContainer.v(size);
            List<hp3.h> list2 = this.f339864d;
            if (list2 != null && list2.size() != 0) {
                Iterator<hp3.h> it = this.f339864d.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    if (it.next().f405844d) {
                        OpenCardContainer.this.H.setMainAccountSelect(false);
                        z16 = true;
                    }
                }
                if (!z16) {
                    OpenCardContainer.this.H.setMainAccountSelect(true);
                }
            } else {
                OpenCardContainer.this.H.setMainAccountSelect(true);
            }
            super.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private SwipeMenuLayout f339873a;

        /* renamed from: b, reason: collision with root package name */
        private View f339874b;

        /* renamed from: c, reason: collision with root package name */
        private URLImageView f339875c;

        /* renamed from: d, reason: collision with root package name */
        private TextView f339876d;

        /* renamed from: e, reason: collision with root package name */
        private ImageView f339877e;

        /* renamed from: f, reason: collision with root package name */
        private Button f339878f;

        f() {
        }
    }

    public OpenCardContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Q = "";
        this.I = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void t(ImageView imageView, String str) {
        Drawable drawable;
        if (imageView == null) {
            return;
        }
        URLDrawable uRLDrawable = null;
        try {
            if (QQTheme.isNowThemeIsNight()) {
                drawable = this.f339595d.getResources().getDrawable(R.drawable.n5b);
            } else {
                drawable = this.f339595d.getResources().getDrawable(R.drawable.n5a);
            }
        } catch (OutOfMemoryError e16) {
            t.d("OpenCardContainer", "-->create color drawable oom.", e16);
            drawable = null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
        } catch (IllegalArgumentException e17) {
            t.e("OpenCardContainer", "setVirtualIcon exception url=", str, ",excption=", e17.toString());
        }
        if (uRLDrawable != null) {
            uRLDrawable.setDecodeHandler(com.tencent.open.agent.util.p.j());
            if (uRLDrawable.getStatus() == 2) {
                uRLDrawable.restartDownload();
            }
            if (uRLDrawable.getStatus() != 2) {
                imageView.setImageDrawable(uRLDrawable);
            } else {
                t.b("OpenCardContainer", "getImageError: ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i3) {
        if (i3 >= 3) {
            this.N.setVisibility(0);
            View view = this.M;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        this.N.setVisibility(8);
        View view2 = this.M;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    private void y() {
        d dVar;
        this.D.setVisibility(0);
        Context context = this.f339595d;
        if (context instanceof QBaseActivity) {
            ImmersiveUtils.setStatusTextColor(false, ((QBaseActivity) context).getWindow());
        }
        Context context2 = this.f339595d;
        if ((context2 instanceof PublicFragmentActivityForOpenSDK) && (dVar = this.R) != null) {
            dVar.a();
        } else if (context2 instanceof AuthorityActivity) {
            ((AuthorityActivity) context2).L2();
        } else if (context2 instanceof QuickLoginAuthorityActivity) {
            ((QuickLoginAuthorityActivity) context2).Q2();
        }
        int d16 = d((int) (this.f339595d.getResources().getDisplayMetrics().widthPixels * 0.64266664f));
        i(this.E, d16, d16 - this.C.getHeight(), null);
    }

    @Override // com.tencent.open.agent.BaseCardContainer
    protected void e() {
        t.e("OpenCardContainer", "displayCoverContainer ");
        if (!this.f339599i) {
            this.f339599i = true;
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.BaseCardContainer, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        t.b("OpenCardContainer", "onFinishInflate " + Log.getStackTraceString(new Throwable()));
        OpenAuthorityAccountView openAuthorityAccountView = (OpenAuthorityAccountView) super.findViewById(R.id.f163903bt);
        this.H = openAuthorityAccountView;
        openAuthorityAccountView.setOnClickListener(new a());
        this.J = (ImageView) super.findViewById(R.id.f164385vs);
        this.K = (TextView) super.findViewById(R.id.f164387vu);
        this.L = (TextView) super.findViewById(R.id.w3);
        View findViewById = super.findViewById(R.id.f164384vr);
        findViewById.setFocusable(true);
        findViewById.setFocusableInTouchMode(true);
        findViewById.requestFocus();
        this.N = super.findViewById(R.id.kzd);
        this.M = findViewById(R.id.f95235ef);
        ListView listView = (ListView) super.findViewById(R.id.kze);
        e eVar = new e();
        this.P = eVar;
        listView.setAdapter((ListAdapter) eVar);
        listView.getLayoutParams().height = Integer.MAX_VALUE;
    }

    public void p() {
        OpenAuthorityAccountView openAuthorityAccountView = this.H;
        if (openAuthorityAccountView != null) {
            openAuthorityAccountView.c();
        }
    }

    public boolean q(List<hp3.e> list, String str) {
        boolean z16;
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f339597f.clear();
        if (!TextUtils.isEmpty(str)) {
            this.L.setText(str);
        }
        if (list.isEmpty()) {
            t.b("OpenCardContainer", "authList isEmpty");
        } else {
            StringBuilder sb5 = new StringBuilder(list.size() * 128);
            for (hp3.e eVar : list) {
                hp3.e eVar2 = new hp3.e();
                eVar2.f405823e = eVar.f405823e;
                eVar2.f405819a = eVar.f405819a;
                eVar2.f405824f = eVar.f405824f;
                eVar2.f405822d = eVar.f405822d;
                eVar2.f405820b = eVar.f405820b;
                eVar2.f405821c = eVar.f405821c;
                sb5.append(eVar2.toString());
                sb5.append("\n");
                this.f339597f.add(eVar2);
            }
            t.b("OpenCardContainer", sb5.toString());
        }
        if (this.f339597f.size() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            URLImageView uRLImageView = this.E;
            x(1);
            t.b("OpenCardContainer", "--> has been authority.");
            j(uRLImageView, h(this.Q));
        } else {
            x(0);
            t.b("OpenCardContainer", "--> has not been authority.");
            j(this.E, h(this.Q));
        }
        return z16;
    }

    public long r() {
        if (this.P.f339864d != null && this.P.f339864d.size() > 0) {
            for (hp3.h hVar : this.P.f339864d) {
                if (hVar.f405844d) {
                    return hVar.f405843c;
                }
            }
            return 0L;
        }
        return 0L;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void s() {
        if (!this.f339599i) {
            return;
        }
        try {
            y();
        } catch (Exception e16) {
            t.d("OpenCardContainer", "Exception", e16);
        }
    }

    public void setAccountEventListener(c cVar) {
        if (cVar != null) {
            this.H.setAccountEventListener(cVar);
        }
    }

    public void setAddVirtualAccountClickListener(View.OnClickListener onClickListener) {
        this.M.setOnClickListener(onClickListener);
    }

    public void setCurrentAppId(String str) {
        this.Q = str;
    }

    public void setOnUpdateStatusBarListener(d dVar) {
        this.R = dVar;
    }

    public void setPresenter(ep3.d dVar) {
        t.b("OpenCardContainer", "setPresenter " + Log.getStackTraceString(new Throwable()));
        this.S = dVar;
        this.H.setAccountEventListener(new b());
    }

    public void u(String str, Bitmap bitmap) {
        setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.K.setText(this.f339595d.getResources().getString(R.string.f172772rc, str));
        }
        if (bitmap != null) {
            this.J.setImageBitmap(bitmap);
        }
    }

    public void w(String str) {
        OpenAuthorityAccountView openAuthorityAccountView;
        if (!TextUtils.isEmpty(str) && (openAuthorityAccountView = this.H) != null) {
            openAuthorityAccountView.t(str);
        }
    }

    public void x(int i3) {
        t.b("OpenCardContainer", "switchToMode -->mode: " + i3 + ", mMode=" + this.f339600m);
        k(this.Q);
        this.f339600m = i3;
    }
}
