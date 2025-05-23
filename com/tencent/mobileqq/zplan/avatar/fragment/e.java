package com.tencent.mobileqq.zplan.avatar.fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.view.ZPlanRoundImageLayout;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ZPlanAvatarPicEditFragment F;

    /* renamed from: m, reason: collision with root package name */
    private final Context f331775m;
    private final ArrayList<a> C = new ArrayList<>();
    private int D = -1;
    private String E = "";
    private boolean G = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f331776a;

        /* renamed from: b, reason: collision with root package name */
        int f331777b;

        /* renamed from: c, reason: collision with root package name */
        String f331778c;

        public a() {
        }

        public a(boolean z16, int i3, String str) {
            this.f331776a = z16;
            this.f331777b = i3;
            this.f331778c = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b extends RecyclerView.ViewHolder {
        public LinearLayout E;
        public ZPlanRoundImageLayout F;

        public b(View view) {
            super(view);
            this.E = (LinearLayout) view.findViewById(R.id.q4h);
            this.F = (ZPlanRoundImageLayout) view.findViewById(R.id.pdn);
            VideoReport.setElementId(this.E, "em_zplan_background");
            VideoReport.setElementExposePolicy(this.E, ExposurePolicy.REPORT_FIRST);
            VideoReport.setElementClickPolicy(this.E, ClickPolicy.REPORT_NONE);
            HashMap hashMap = new HashMap();
            hashMap.put("zplan_current_background_id", e.this.E);
            VideoReport.setElementParams(this.E, hashMap);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.G = true;
            int i3 = e.this.D;
            e.this.D = ((Integer) view.getTag()).intValue();
            if (i3 != e.this.D) {
                if (i3 != -1) {
                    e.this.o0(i3).f331776a = false;
                    e.this.notifyItemChanged(i3);
                }
                e eVar = e.this;
                eVar.o0(eVar.D).f331776a = true;
                e eVar2 = e.this;
                eVar2.notifyItemChanged(eVar2.D);
                e.this.F.Jj(e.this.D);
                HashMap hashMap = new HashMap();
                hashMap.put("zplan_current_background_id", ((a) e.this.C.get(e.this.D)).f331778c);
                VideoReport.setElementParams(view, hashMap);
                VideoReport.reportEvent("clck", view, hashMap);
            }
        }
    }

    public e(Context context, ZPlanAvatarPicEditFragment zPlanAvatarPicEditFragment) {
        this.f331775m = context;
        this.F = zPlanAvatarPicEditFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.C.size();
    }

    public a o0(int i3) {
        if (i3 < this.C.size()) {
            return this.C.get(i3);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new b(LayoutInflater.from(this.f331775m).inflate(R.layout.d2u, viewGroup, false));
    }

    public void p0(ArrayList<a> arrayList) {
        this.C.clear();
        this.C.addAll(arrayList);
    }

    public void q0(String str) {
        this.E = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        int dpToPx;
        if (viewHolder == null || i3 >= getNUM_BACKGOURND_ICON() || !(viewHolder instanceof b)) {
            return;
        }
        b bVar = (b) viewHolder;
        a o06 = o0(i3);
        if (o06 == null) {
            return;
        }
        bVar.F.setBackgroundImageUrl(o06.f331778c);
        bVar.F.setRadius(50);
        bVar.F.setInnerMargin(ViewUtils.dpToPx(3.0f));
        if (o06.f331776a) {
            bVar.F.setStrokeDrawable(this.f331775m.getDrawable(R.drawable.f159781gp0));
        } else {
            bVar.F.setStrokeDrawable(new ColorDrawable(0));
        }
        bVar.E.setTag(Integer.valueOf(i3));
        bVar.E.setOnClickListener(new c());
        if (i3 == 0) {
            dpToPx = ViewUtils.dpToPx(18.0f);
        } else {
            dpToPx = ViewUtils.dpToPx(9.0f);
        }
        bVar.E.setPadding(dpToPx, 0, i3 == getNUM_BACKGOURND_ICON() + (-1) ? ViewUtils.dpToPx(18.0f) : 0, 0);
        VideoReport.setElementReuseIdentifier(bVar.E, i3 + "");
    }

    public void r0(int i3) {
        if (i3 < 0 || i3 >= this.C.size()) {
            return;
        }
        this.D = i3;
        a aVar = this.C.get(i3);
        if (aVar != null) {
            aVar.f331776a = true;
        }
    }
}
