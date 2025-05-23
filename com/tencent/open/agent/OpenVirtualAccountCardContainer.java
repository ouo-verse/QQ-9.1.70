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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.open.agent.util.t;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenVirtualAccountCardContainer extends RelativeLayout {
    private static final int[] D = {R.string.f170822ak3};
    private static final int[] E = {R.drawable.cja};
    private static final int[] F = {R.id.epz};
    public d C;

    /* renamed from: d, reason: collision with root package name */
    private LayoutInflater f339936d;

    /* renamed from: e, reason: collision with root package name */
    private Context f339937e;

    /* renamed from: f, reason: collision with root package name */
    private View f339938f;

    /* renamed from: h, reason: collision with root package name */
    private View f339939h;

    /* renamed from: i, reason: collision with root package name */
    private View f339940i;

    /* renamed from: m, reason: collision with root package name */
    private View f339941m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            t.b("OpenVirtualAccountCardContainer", "on MainAccount click");
            OpenVirtualAccountCardContainer.this.h(true);
            OpenVirtualAccountCardContainer.this.C.c();
            OpenVirtualAccountCardContainer.c(OpenVirtualAccountCardContainer.this);
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
            Iterator it = OpenVirtualAccountCardContainer.this.C.f339944d.iterator();
            while (it.hasNext()) {
                ((hp3.h) it.next()).f405844d = false;
            }
            t.b("OpenVirtualAccountCardContainer", "onItemClick position=" + i3);
            ((hp3.h) OpenVirtualAccountCardContainer.this.C.f339944d.get(i3)).f405844d = true;
            OpenVirtualAccountCardContainer.this.h(false);
            OpenVirtualAccountCardContainer.this.C.notifyDataSetChanged();
            OpenVirtualAccountCardContainer.c(OpenVirtualAccountCardContainer.this);
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface c {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private SwipeMenuLayout f339950a;

        /* renamed from: b, reason: collision with root package name */
        private URLImageView f339951b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f339952c;

        /* renamed from: d, reason: collision with root package name */
        private ImageView f339953d;

        /* renamed from: e, reason: collision with root package name */
        private Button f339954e;

        e() {
        }
    }

    public OpenVirtualAccountCardContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f339937e = context;
        this.f339936d = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    static /* bridge */ /* synthetic */ c c(OpenVirtualAccountCardContainer openVirtualAccountCardContainer) {
        openVirtualAccountCardContainer.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z16) {
        int i3;
        View view = this.f339941m;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ImageView imageView, String str) {
        Drawable drawable;
        if (imageView == null) {
            return;
        }
        URLDrawable uRLDrawable = null;
        try {
            drawable = this.f339937e.getResources().getDrawable(R.drawable.f160830com);
        } catch (OutOfMemoryError e16) {
            t.d("OpenVirtualAccountCardContainer", "-->create color drawable oom.", e16);
            drawable = null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
        } catch (IllegalArgumentException e17) {
            t.e("OpenVirtualAccountCardContainer", "setVirtualIcon exception url=", str, ",excption=", e17.toString());
        }
        if (uRLDrawable != null) {
            uRLDrawable.setDecodeHandler(com.tencent.open.agent.util.p.j());
            if (uRLDrawable.getStatus() == 2) {
                uRLDrawable.restartDownload();
            }
            if (uRLDrawable.getStatus() != 2) {
                imageView.setImageDrawable(uRLDrawable);
            } else {
                t.b("OpenVirtualAccountCardContainer", "getImageError: ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i3) {
        if (i3 >= 3) {
            this.f339938f.setVisibility(8);
            this.f339939h.setVisibility(0);
        } else {
            this.f339938f.setVisibility(0);
            this.f339939h.setVisibility(8);
        }
    }

    public long g() {
        if (this.C.f339944d != null && this.C.f339944d.size() > 0) {
            for (hp3.h hVar : this.C.f339944d) {
                if (hVar.f405844d) {
                    return hVar.f405843c;
                }
            }
            return 0L;
        }
        return 0L;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        t.b("OpenVirtualAccountCardContainer", "onFinishInflate " + Log.getStackTraceString(new Throwable()));
        View findViewById = super.findViewById(R.id.f163865ap);
        this.f339940i = findViewById;
        findViewById.setOnClickListener(new a());
        this.f339938f = super.findViewById(R.id.bbw);
        this.f339939h = super.findViewById(R.id.kzd);
        this.f339941m = super.findViewById(R.id.im7);
        FitHeightListView fitHeightListView = (FitHeightListView) super.findViewById(R.id.kze);
        d dVar = new d();
        this.C = dVar;
        fitHeightListView.setAdapter((ListAdapter) dVar);
        fitHeightListView.setOnItemClickListener(new b());
    }

    public void setVirtualData(List<hp3.h> list, String str) {
        this.C.d(list, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d extends BaseAdapter implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private List<hp3.h> f339944d;

        /* renamed from: e, reason: collision with root package name */
        String f339945e;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f339947d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ e f339948e;

            a(int i3, e eVar) {
                this.f339947d = i3;
                this.f339948e = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (d.this.f339944d != null && this.f339947d < d.this.f339944d.size() && this.f339947d >= 0) {
                    this.f339948e.f339950a.h();
                    if (OpenVirtualAccountCardContainer.this.f339937e != null && d.this.f339944d.get(this.f339947d) != null) {
                        OpenVirtualAccountCardContainer.c(OpenVirtualAccountCardContainer.this);
                    }
                    d.this.f339944d.remove(d.this.f339944d.get(this.f339947d));
                    d.this.notifyDataSetChanged();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        d() {
        }

        private void b(e eVar, int i3) {
            hp3.h hVar = this.f339944d.get(i3);
            eVar.f339952c.setText(hVar.f405842b);
            if (hVar.f405844d) {
                eVar.f339953d.setVisibility(0);
                OpenVirtualAccountCardContainer.this.h(false);
            } else {
                eVar.f339953d.setVisibility(4);
            }
            if (hVar.f405841a != null) {
                OpenVirtualAccountCardContainer.this.i(eVar.f339951b, hVar.f405841a);
            }
        }

        void c() {
            List<hp3.h> list = this.f339944d;
            if (list != null && list.size() > 0) {
                Iterator<hp3.h> it = this.f339944d.iterator();
                while (it.hasNext()) {
                    it.next().f405844d = false;
                }
                notifyDataSetChanged();
            }
        }

        void d(List<hp3.h> list, String str) {
            boolean z16;
            if (this.f339944d != null) {
                if (str == null) {
                    str = "";
                }
                if (!str.equals(this.f339945e)) {
                    this.f339945e = str;
                } else if (list != null) {
                    for (hp3.h hVar : list) {
                        if (hVar.f405843c == OpenVirtualAccountCardContainer.this.g()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        hVar.f405844d = z16;
                    }
                }
            }
            this.f339944d = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<hp3.h> list = this.f339944d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            List<hp3.h> list = this.f339944d;
            if (list != null && i3 < list.size()) {
                return this.f339944d.get(i3);
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
            e eVar;
            if (view == null) {
                eVar = new e();
                View inflate = OpenVirtualAccountCardContainer.this.f339936d.inflate(R.layout.f168471x2, viewGroup, false);
                inflate.setPadding(0, BaseAIOUtils.f(8.0f, OpenVirtualAccountCardContainer.this.getResources()), 0, BaseAIOUtils.f(8.0f, OpenVirtualAccountCardContainer.this.getResources()));
                eVar.f339951b = (URLImageView) inflate.findViewById(R.id.kzc);
                eVar.f339952c = (TextView) inflate.findViewById(R.id.kzf);
                eVar.f339953d = (ImageView) inflate.findViewById(R.id.imc);
                eVar.f339954e = (Button) inflate.findViewById(R.id.bfz);
                eVar.f339950a = (SwipeMenuLayout) inflate;
                inflate.setTag(eVar);
                view2 = inflate;
            } else {
                view2 = view;
                eVar = (e) view.getTag();
            }
            b(eVar, i3);
            eVar.f339954e.setOnClickListener(new a(i3, eVar));
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            int size;
            OpenVirtualAccountCardContainer openVirtualAccountCardContainer = OpenVirtualAccountCardContainer.this;
            List<hp3.h> list = this.f339944d;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            openVirtualAccountCardContainer.j(size);
            List<hp3.h> list2 = this.f339944d;
            if (list2 == null || list2.size() == 0) {
                OpenVirtualAccountCardContainer.this.h(true);
            } else {
                Iterator<hp3.h> it = this.f339944d.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    if (it.next().f405844d) {
                        OpenVirtualAccountCardContainer.this.h(false);
                        z16 = true;
                    }
                }
                if (!z16) {
                    OpenVirtualAccountCardContainer.this.h(true);
                }
            }
            super.notifyDataSetChanged();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public void setOnDeleteVirtualListener(c cVar) {
    }
}
