package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.troop.IceBreakHelper;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.f;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h extends RecyclerView.Adapter<a> implements View.OnClickListener {
    private static final HashMap<Integer, b> F = new HashMap<>();
    private final ArrayList<Integer> C = IceBreakHelper.INSTANCE.getTemplateList();
    private int D = 2000;
    private final com.tencent.mobileqq.vas.updatesystem.business.f E = (com.tencent.mobileqq.vas.updatesystem.business.f) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.updatesystem.business.f.class);

    /* renamed from: m, reason: collision with root package name */
    private final c f179466m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends RecyclerView.ViewHolder {
        public ImageView E;
        public ImageView F;
        public ImageView G;
        public ProgressBar H;
        public ImageView I;
        public TextView J;
        public View K;
        public View L;
        public RoundCorneredRelativeLayout M;

        public a(View view) {
            super(view);
            this.E = (ImageView) view.findViewById(R.id.lzw);
            this.F = (ImageView) view.findViewById(R.id.f82794hu);
            this.G = (ImageView) view.findViewById(R.id.imk);
            this.I = (ImageView) view.findViewById(R.id.lzt);
            this.H = (ProgressBar) view.findViewById(R.id.lzx);
            this.J = (TextView) view.findViewById(R.id.lzv);
            this.K = view.findViewById(R.id.f93955az);
            this.M = (RoundCorneredRelativeLayout) view.findViewById(R.id.f93965b0);
            this.L = view.findViewById(R.id.f783546u);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f179467a;

        /* renamed from: b, reason: collision with root package name */
        public int f179468b;

        /* renamed from: c, reason: collision with root package name */
        public int f179469c;

        public b(String str, int i3, int i16) {
            this.f179467a = str;
            this.f179468b = i3;
            this.f179469c = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
        void a(int i3);
    }

    public h(c cVar) {
        this.f179466m = cVar;
        n0();
    }

    private b k0(int i3) {
        IceBreakHelper iceBreakHelper = IceBreakHelper.INSTANCE;
        b bVar = F.get(Integer.valueOf(iceBreakHelper.getTemplateVipType().get(Integer.valueOf(i3)).intValue()));
        String str = iceBreakHelper.getNameConfig().get(Integer.valueOf(i3));
        if (bVar != null && !TextUtils.isEmpty(str)) {
            bVar.f179467a = str;
        }
        return bVar;
    }

    private void n0() {
        HashMap<Integer, b> hashMap = F;
        hashMap.clear();
        hashMap.put(0, new b(Constants.Business.DEFAULT, 0, 4));
        hashMap.put(2, new b("\u8d85\u7ea7\u4f1a\u5458", R.drawable.nuo, 2));
        hashMap.put(3, new b("\u5927\u4f1a\u5458", R.drawable.nun, 3));
        hashMap.put(1, new b("QQ\u4f1a\u5458", R.drawable.nup, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(final int i3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.o0(i3);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.C.size();
    }

    public int l0(int i3) {
        for (int i16 = 0; i16 < this.C.size(); i16++) {
            if (i3 == this.C.get(i16).intValue()) {
                return i16;
            }
        }
        return 0;
    }

    public int m0() {
        return this.D;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        t0(id5);
        ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A4F9", id5, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void o0(int i3) {
        for (int i16 = 0; i16 < this.C.size(); i16++) {
            if (i3 == this.C.get(i16).intValue()) {
                notifyItemChanged(i16);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i3) {
        if (this.C.size() <= i3) {
            QLog.e("JoinTroopBriefTemplateAdapter", 1, "itemList is invalid" + i3);
            return;
        }
        final int intValue = this.C.get(i3).intValue();
        b k06 = k0(intValue);
        int i16 = k06.f179468b;
        aVar.J.setText(k06.f179467a);
        if (i16 != 0) {
            aVar.I.setVisibility(0);
            aVar.I.setImageResource(i16);
        } else {
            aVar.I.setVisibility(8);
        }
        if (intValue == this.D) {
            aVar.F.setVisibility(0);
            aVar.G.setVisibility(0);
            TextView textView = aVar.J;
            textView.setTextColor(textView.getResources().getColor(R.color.qui_common_brand_standard));
        } else {
            aVar.F.setVisibility(8);
            aVar.G.setVisibility(8);
            TextView textView2 = aVar.J;
            textView2.setTextColor(textView2.getResources().getColor(R.color.qui_common_text_primary));
        }
        if (!this.E.isFileExists(intValue)) {
            this.E.addDownLoadListener(intValue, new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.p0(intValue);
                }
            });
            this.E.startDownload(intValue);
            aVar.E.setClickable(false);
            aVar.H.setVisibility(0);
            aVar.E.setImageDrawable(null);
            return;
        }
        aVar.E.setId(intValue);
        aVar.E.setOnClickListener(this);
        float c16 = x.c(aVar.E.getContext(), 4.5f);
        aVar.M.setRadius(c16, c16, c16, c16);
        aVar.H.setVisibility(8);
        f.Config e16 = this.E.e(intValue);
        if (e16 != null) {
            aVar.E.setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(e16.g().getAbsolutePath()).a());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        Context context = viewGroup.getContext();
        a aVar = new a(LayoutInflater.from(context).inflate(R.layout.hgs, viewGroup, false));
        int b16 = ((x.f(context).b() - (x.c(context, 16.0f) * 2)) - (x.c(context, 13.0f) * 3)) / 4;
        ViewGroup.LayoutParams layoutParams = aVar.L.getLayoutParams();
        layoutParams.width = b16;
        aVar.L.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = aVar.K.getLayoutParams();
        layoutParams2.height = (b16 * 52) / 76;
        aVar.K.setLayoutParams(layoutParams2);
        return aVar;
    }

    public void t0(int i3) {
        for (int i16 = 0; i16 < this.C.size(); i16++) {
            if (i3 == this.C.get(i16).intValue()) {
                this.D = i3;
                c cVar = this.f179466m;
                if (cVar != null) {
                    cVar.a(i3);
                }
                notifyDataSetChanged();
                return;
            }
        }
    }
}
