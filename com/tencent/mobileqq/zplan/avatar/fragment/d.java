package com.tencent.mobileqq.zplan.avatar.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.avatar.edit.ClipperInfo;
import com.tencent.mobileqq.zplan.avatar.param.ZPlanAvatarEventType;
import com.tencent.mobileqq.zplan.view.ZPlanRoundImageLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ZPlanAvatarPicEditFragment F;

    /* renamed from: m, reason: collision with root package name */
    private final Context f331759m;
    private final ArrayList<c> C = new ArrayList<>();
    private int D = -1;
    private int E = 0;
    private boolean G = false;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f331760d;

        a(b bVar) {
            this.f331760d = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = d.this.C.iterator();
            while (it.hasNext()) {
                ((c) it.next()).f331763b = false;
            }
            d.this.G = true;
            int i3 = d.this.D;
            d.this.D = ((Integer) view.getTag()).intValue();
            if (i3 != d.this.D) {
                if (i3 != -1) {
                    d.this.n0(i3).f331763b = false;
                    d.this.notifyItemChanged(i3);
                }
                d dVar = d.this;
                c n06 = dVar.n0(dVar.D);
                n06.f331763b = true;
                if (!n06.f331762a) {
                    this.f331760d.G.setVisibility(0);
                }
                d dVar2 = d.this;
                dVar2.notifyItemChanged(dVar2.D);
                d.this.F.Ij(d.this.D);
                HashMap hashMap = new HashMap();
                hashMap.put("zplan_current_action", Integer.valueOf(((c) d.this.C.get(d.this.D)).f331764c));
                VideoReport.setElementParams(view, hashMap);
                VideoReport.reportEvent("clck", this.f331760d.E, hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b extends RecyclerView.ViewHolder {
        public RelativeLayout E;
        public ZPlanRoundImageLayout F;
        public View G;
        public TextView H;
        public ImageView I;

        public b(View view) {
            super(view);
            this.E = (RelativeLayout) view.findViewById(R.id.q4h);
            this.F = (ZPlanRoundImageLayout) view.findViewById(R.id.p9s);
            this.G = view.findViewById(R.id.q5z);
            this.H = (TextView) view.findViewById(R.id.r48);
            this.I = (ImageView) view.findViewById(R.id.r49);
        }

        public void l(int i3) {
            VideoReport.setElementId(this.E, "em_zplan_act");
            VideoReport.setElementExposePolicy(this.E, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this.E, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementReuseIdentifier(this.E, String.valueOf(i3));
            VideoReport.setElementClickPolicy(this.E, ClickPolicy.REPORT_NONE);
            HashMap hashMap = new HashMap();
            hashMap.put("zplan_current_action", Integer.valueOf(i3));
            VideoReport.setElementParams(this.E, hashMap);
        }
    }

    public d(Context context, ZPlanAvatarPicEditFragment zPlanAvatarPicEditFragment) {
        this.f331759m = context;
        this.F = zPlanAvatarPicEditFragment;
    }

    private void p0(c cVar, b bVar) {
        if (!ZPlanQQMC.INSTANCE.enableZPlanEditAvatarV2()) {
            QLog.w("ZPlanAvatarEditActionAdapter", 1, "enableZPlanEditAvatarV2 false.");
            List<Integer> list = cVar.f331773l;
            String c26 = ZPlanFeatureSwitch.f369852a.c2();
            if (!TextUtils.isEmpty(c26) && list != null && list.contains(Integer.valueOf(ZPlanAvatarEventType.TIME_LIMIT.getEventType()))) {
                bVar.H.setText(c26);
                bVar.H.setVisibility(0);
                return;
            } else {
                bVar.H.setVisibility(8);
                return;
            }
        }
        List<Integer> list2 = cVar.f331773l;
        if (((list2 == null || list2.size() <= 0) ? 0 : list2.get(0).intValue()) == 0) {
            bVar.I.setVisibility(8);
            return;
        }
        String str = cVar.f331774m;
        if (TextUtils.isEmpty(str)) {
            QLog.e("ZPlanAvatarEditActionAdapter", 1, "eventInfo config error! eventTag exists, but no event info.");
            bVar.I.setVisibility(8);
            return;
        }
        try {
            String optString = new JSONObject(str).optString("tag_icon_url", "");
            if (TextUtils.isEmpty(optString)) {
                QLog.i("ZPlanAvatarEditActionAdapter", 1, "has event, but tag icon url empty.");
                bVar.I.setVisibility(8);
                return;
            }
            URLDrawable drawable = URLDrawable.getDrawable(optString, URLDrawable.URLDrawableOptions.obtain());
            if (drawable == null) {
                QLog.e("ZPlanAvatarEditActionAdapter", 1, "has event, but can not get icon urlDrawable successfully.");
                bVar.I.setVisibility(8);
            } else {
                bVar.I.setImageDrawable(drawable);
                bVar.I.setVisibility(0);
            }
        } catch (Throwable th5) {
            QLog.e("ZPlanAvatarEditActionAdapter", 1, "setEventTagUI failed.", th5);
            bVar.I.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.C.size();
    }

    public c n0(int i3) {
        if (i3 < this.C.size()) {
            return this.C.get(i3);
        }
        return null;
    }

    public void o0(ArrayList<c> arrayList) {
        this.C.clear();
        this.C.addAll(arrayList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new b(LayoutInflater.from(this.f331759m).inflate(R.layout.d2t, viewGroup, false));
    }

    public void q0(int i3) {
        this.E = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        int dpToPx;
        if (viewHolder == null || i3 >= getNUM_BACKGOURND_ICON() || !(viewHolder instanceof b)) {
            return;
        }
        b bVar = (b) viewHolder;
        c n06 = n0(i3);
        if (n06 == null) {
            return;
        }
        bVar.l(n06.f331764c);
        boolean z16 = (TextUtils.isEmpty(n06.f331765d) || TextUtils.isEmpty(n06.f331766e)) ? false : true;
        n06.f331762a = z16;
        if (z16 && bVar.G.getVisibility() == 0) {
            bVar.G.setVisibility(8);
        }
        p0(n06, bVar);
        boolean isOutboundHeadFeatureOn = ((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn();
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        boolean z17 = isOutboundHeadFeatureOn && zPlanFeatureSwitch.j0() && zPlanFeatureSwitch.i0();
        String str = n06.f331766e;
        if (z17) {
            str = n06.f331765d;
        }
        ZPlanRoundImageLayout zPlanRoundImageLayout = bVar.F;
        if (!n06.f331762a) {
            str = n06.f331768g;
        }
        zPlanRoundImageLayout.setAvatarImageUrl(str, Boolean.valueOf(z17), n06.f331770i);
        bVar.F.setBackgroundImageColor(Color.parseColor("#E6EAF0"));
        bVar.F.setRadius(50);
        bVar.F.setInnerMargin(ViewUtils.dpToPx(4.0f));
        if (n06.f331763b) {
            bVar.F.setStrokeDrawable(this.f331759m.getDrawable(R.drawable.gox));
        } else {
            bVar.F.setStrokeDrawable(new ColorDrawable(0));
        }
        bVar.E.setTag(Integer.valueOf(i3));
        bVar.E.setOnClickListener(new a(bVar));
        if (i3 == 0) {
            dpToPx = ViewUtils.dpToPx(18.0f);
        } else {
            dpToPx = ViewUtils.dpToPx(10.0f);
        }
        bVar.E.setPadding(dpToPx, 0, i3 == getNUM_BACKGOURND_ICON() - 1 ? ViewUtils.dpToPx(18.0f) : 0, 0);
        VideoReport.setElementReuseIdentifier(bVar.F, n06.f331764c + "");
    }

    public void r0(int i3) {
        if (i3 >= 0 && i3 < this.C.size()) {
            this.D = i3;
            c cVar = this.C.get(i3);
            if (cVar != null) {
                cVar.f331763b = true;
            }
        }
        notifyItemChanged(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        boolean f331762a;

        /* renamed from: b, reason: collision with root package name */
        boolean f331763b;

        /* renamed from: c, reason: collision with root package name */
        int f331764c;

        /* renamed from: d, reason: collision with root package name */
        String f331765d;

        /* renamed from: e, reason: collision with root package name */
        String f331766e;

        /* renamed from: f, reason: collision with root package name */
        String f331767f;

        /* renamed from: g, reason: collision with root package name */
        String f331768g;

        /* renamed from: h, reason: collision with root package name */
        String f331769h;

        /* renamed from: i, reason: collision with root package name */
        Double f331770i;

        /* renamed from: j, reason: collision with root package name */
        ClipperInfo f331771j;

        /* renamed from: k, reason: collision with root package name */
        ClipperInfo f331772k;

        /* renamed from: l, reason: collision with root package name */
        List<Integer> f331773l;

        /* renamed from: m, reason: collision with root package name */
        String f331774m;

        public c() {
            this.f331770i = Double.valueOf(0.25d);
            this.f331771j = null;
            this.f331772k = null;
            this.f331773l = null;
            this.f331774m = null;
        }

        public c(boolean z16, int i3, String str, String str2, String str3, String str4, Double d16, ClipperInfo clipperInfo, ClipperInfo clipperInfo2, List<Integer> list, String str5) {
            this.f331763b = z16;
            this.f331764c = i3;
            this.f331765d = str;
            this.f331766e = str2;
            this.f331768g = str3;
            this.f331769h = str4;
            this.f331770i = d16;
            this.f331771j = clipperInfo;
            this.f331772k = clipperInfo2;
            this.f331773l = list;
            this.f331774m = str5;
        }
    }
}
