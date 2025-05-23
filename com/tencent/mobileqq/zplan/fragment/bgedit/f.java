package com.tencent.mobileqq.zplan.fragment.bgedit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.fragment.bgedit.ZPlanBgEditFragment;
import com.tencent.mobileqq.zplan.model.g;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes34.dex */
public class f extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private static final int I = ViewUtils.dip2px(4.0f);
    private static final int J = ViewUtils.dip2px(10.0f);
    private int C;
    private int D;
    private final Activity E;
    private final ZPlanBgEditFragment.e F;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private final HashSet<g> f333604d = new HashSet<>();

    /* renamed from: e, reason: collision with root package name */
    private int f333605e = -1;

    /* renamed from: f, reason: collision with root package name */
    private String f333606f = "";

    /* renamed from: h, reason: collision with root package name */
    private String f333607h = "";

    /* renamed from: i, reason: collision with root package name */
    private volatile int f333608i = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f333609m = 0;
    private final ArrayList<g> G = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class a extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        private final int f333610d;

        public a(int i3) {
            this.f333610d = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            int i3 = this.f333610d;
            float f16 = ((i3 * 2) * 1.0f) / 3.0f;
            float f17 = childLayoutPosition % 3;
            rect.left = (int) ((i3 - f16) * f17);
            rect.right = (int) (f16 - (f17 * (i3 - f16)));
            rect.bottom = f.J;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        public RoundRectImageView f333611d;

        /* renamed from: e, reason: collision with root package name */
        public CheckBox f333612e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f333613f;

        /* renamed from: h, reason: collision with root package name */
        public TextView f333614h;

        public c(View view) {
            super(view);
            this.f333611d = (RoundRectImageView) view.findViewById(R.id.pd8);
            this.f333612e = (CheckBox) view.findViewById(R.id.qjs);
            this.f333613f = (ImageView) view.findViewById(R.id.qjo);
            this.f333614h = (TextView) view.findViewById(R.id.qiw);
            this.f333611d.setCornerRadiusAndMode(f.I, 1);
        }
    }

    public f(Context context, Activity activity, RecyclerView recyclerView, ZPlanBgEditFragment.e eVar, boolean z16) {
        this.E = activity;
        M();
        recyclerView.setAdapter(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
        recyclerView.addItemDecoration(new a(ViewUtils.dip2px(10.0f)));
        this.F = eVar;
        this.H = z16;
    }

    private void F(View view, g gVar, String str) {
        if ("imp".equals(str) && gVar.c()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("dt_pgid", "pg_zplan_qqusercard_setting_xiaowo_background");
        String a16 = gVar.a();
        if (!TextUtils.isEmpty(a16)) {
            hashMap.put("zplan_background_id", a16);
        }
        VideoReport.setElementId(view, "em_zplan_background");
        VideoReport.reportEvent(str, view, hashMap);
        if ("imp".equals(str)) {
            gVar.p(true);
        }
    }

    private void G(b bVar) {
        View view = bVar.itemView;
        VideoReport.setElementId(view, "em_zplan_select_from_album");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(b bVar, View view) {
        this.F.b();
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.reportEvent("clck", bVar.itemView, hashMap);
    }

    public HashSet<g> A() {
        return this.f333604d;
    }

    public String B() {
        return this.f333606f;
    }

    public String C() {
        return this.f333607h;
    }

    public g D() {
        int i3 = this.f333605e;
        if (i3 < 0 || i3 >= this.G.size()) {
            return null;
        }
        return v().get(this.f333605e);
    }

    public int E() {
        return this.f333604d.size();
    }

    public boolean H() {
        Iterator<g> it = this.G.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.d() == 4 || next.d() == 3) {
                return true;
            }
        }
        return false;
    }

    public void J() {
        Iterator<g> it = this.G.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.d() == 4 || next.d() == 3) {
                next.q(2);
            }
        }
        notifyItemRangeChanged(0, getItemCount());
        this.f333604d.clear();
    }

    public void K() {
        int size = this.G.size();
        this.G.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void L(int i3) {
        this.f333605e = i3;
    }

    public void P(String str) {
        this.f333606f = str;
    }

    public void Q(String str) {
        this.f333607h = str;
    }

    public void R(int i3) {
        this.f333608i = i3;
    }

    public void S(int i3) {
        this.f333609m = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.G.size() + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return i3 == getItemCount() - 1 ? 1 : 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            int intValue = ((Integer) view.getTag()).intValue();
            g y16 = y(intValue);
            int i3 = this.f333609m;
            if (i3 != 0) {
                if (i3 == 1) {
                    if (y16.n()) {
                        if (y16.e() == 1) {
                            this.f333604d.remove(y16);
                            y16.q(2);
                        } else {
                            this.f333604d.add(y16);
                            y16.q(1);
                        }
                        notifyItemChanged(intValue);
                    }
                    this.F.c();
                    return;
                }
                return;
            }
            int i16 = this.f333605e;
            this.f333605e = intValue;
            if (i16 != intValue) {
                y(i16).q(2);
                y(this.f333605e).q(1);
                notifyItemChanged(i16);
                notifyItemChanged(this.f333605e);
                P(v().get(this.f333605e).i());
                this.F.a(this.f333605e);
                F(view, y16, "clck");
            }
        }
    }

    public void s() {
        Iterator<g> it = this.G.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.d() == 4 || next.d() == 3) {
                this.f333604d.add(next);
                next.q(1);
            }
        }
        notifyItemRangeChanged(0, getItemCount());
    }

    public void t(List<? extends g> list) {
        this.G.clear();
        this.G.addAll(list);
        notifyItemRangeChanged(0, getItemCount());
    }

    public void u() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.G.size(); i3++) {
            if (this.f333604d.contains(this.G.get(i3))) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) arrayList.get(size)).intValue();
            this.G.remove(intValue);
            notifyItemRemoved(intValue);
        }
        notifyDataSetChanged();
    }

    public List<g> v() {
        return this.G;
    }

    public g x(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (g gVar : v()) {
            if (str.equals(gVar.i()) || str.equals(gVar.b())) {
                return gVar;
            }
        }
        return null;
    }

    public g y(int i3) {
        if (i3 >= this.G.size()) {
            return new g();
        }
        return this.G.get(i3);
    }

    public int z(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        List<g> v3 = v();
        for (int i3 = 0; i3 < v3.size(); i3++) {
            g gVar = v3.get(i3);
            if (str.equals(gVar.i()) || str.equals(gVar.b())) {
                return i3;
            }
        }
        return 0;
    }

    public int w() {
        for (int i3 = 0; i3 < this.G.size(); i3++) {
            if (this.G.get(i3).d() == 1) {
                return i3;
            }
        }
        return -1;
    }

    private void M() {
        int screenWidth = ((ViewUtils.getScreenWidth() - (ViewUtils.dip2px(10.0f) * 2)) - (ViewUtils.dip2px(20.0f) * 2)) / 3;
        this.C = screenWidth;
        this.D = (int) (screenWidth / 0.886f);
    }

    private void N(c cVar, g gVar) {
        Activity activity;
        if (gVar == null || (activity = this.E) == null) {
            return;
        }
        Drawable drawable = ResourcesCompat.getDrawable(activity.getResources(), R.drawable.f159782gp1, null);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = this.C;
        obtain.mRequestHeight = this.D;
        obtain.mLoadingDrawable = drawable;
        String i3 = gVar.i();
        String b16 = gVar.b();
        if (this.H && !TextUtils.isEmpty(b16)) {
            cVar.f333611d.setImageDrawable(URLDrawable.getDrawable(b16, obtain));
        } else {
            if (TextUtils.isEmpty(i3)) {
                return;
            }
            cVar.f333611d.setImageDrawable(URLDrawable.getDrawable(i3, obtain));
        }
    }

    private void O(c cVar, g gVar) {
        if (gVar == null || this.E == null) {
            return;
        }
        cVar.f333614h.setVisibility(gVar.d() == 5 ? 0 : 8);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder == null || i3 >= getItemCount()) {
            return;
        }
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            g y16 = y(i3);
            cVar.itemView.setTag(Integer.valueOf(i3));
            boolean z16 = y16.e() == 1;
            cVar.f333613f.setVisibility(z16 ? 0 : 8);
            cVar.f333612e.setEnabled(true);
            cVar.f333612e.setChecked(z16);
            cVar.f333612e.setVisibility(0);
            if (this.f333609m == 1 && !y16.n()) {
                cVar.f333612e.setVisibility(8);
            }
            N(cVar, y16);
            O(cVar, y16);
            cVar.itemView.setOnClickListener(this);
            F(cVar.itemView, y16, "imp");
            return;
        }
        if (viewHolder instanceof b) {
            final b bVar = (b) viewHolder;
            bVar.itemView.setVisibility(this.f333609m != 1 ? 0 : 8);
            bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.fragment.bgedit.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.this.I(bVar, view);
                }
            });
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == 0) {
            c cVar = new c(this.E.getLayoutInflater().inflate(R.layout.daj, viewGroup, false));
            cVar.itemView.getLayoutParams().height = this.D;
            return cVar;
        }
        if (i3 != 1) {
            return null;
        }
        b bVar = new b(this.E.getLayoutInflater().inflate(R.layout.dak, viewGroup, false));
        bVar.itemView.getLayoutParams().height = this.D;
        G(bVar);
        return bVar;
    }
}
