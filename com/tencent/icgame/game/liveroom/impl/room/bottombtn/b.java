package com.tencent.icgame.game.liveroom.impl.room.bottombtn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import ep4.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b extends RecyclerView.Adapter<c> {
    private List<ButtonBean> C = new ArrayList();
    private InterfaceC5831b D;
    private Context E;

    /* renamed from: m, reason: collision with root package name */
    private d f115175m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ButtonBean f115176d;

        a(ButtonBean buttonBean) {
            this.f115176d = buttonBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (b.this.D != null) {
                b.this.D.a(view, this.f115176d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.bottombtn.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC5831b {
        void a(View view, ButtonBean buttonBean);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class c extends RecyclerView.ViewHolder {
        private final RedPointIconView E;
        private final TextView F;

        public c(@NonNull View view) {
            super(view);
            this.E = (RedPointIconView) view.findViewById(R.id.t_a);
            this.F = (TextView) view.findViewById(R.id.t_b);
        }
    }

    public b(Context context) {
        this.E = context;
    }

    private void j0(View view, String str) {
        Map<String, String> m06 = m0(str);
        if (view != null) {
            ((ru0.a) qx0.a.b(ru0.a.class)).a(view, true, null, str, m06);
        }
    }

    private void k0(View view, String str) {
        Map<String, String> n06 = n0(str);
        if (view != null) {
            ((ru0.a) qx0.a.b(ru0.a.class)).a(view, true, null, "em_icgame_commercial", n06);
        }
    }

    private String l0(Context context, String str) {
        if (context.getString(R.string.zfu).equals(str)) {
            return "em_icgame_share";
        }
        if (context.getString(R.string.zfp).equals(str)) {
            return "em_icgame_clarity_change";
        }
        return "";
    }

    private Map<String, String> m0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("zengzhi_moduleid", "em_icgame_morefunction_entrance");
        hashMap.put("dt_pgid", "pg_icgame_audience");
        hashMap.put("eid", str);
        if (!hashMap.containsKey(DTParamKey.REPORT_KEY_APPKEY)) {
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05GC39G3MA0B");
        }
        return hashMap;
    }

    @NotNull
    private Map<String, String> n0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("zengzhi_moduleid", "em_icgame_morefunction_entrance");
        hashMap.put("icgame_function_name", str);
        hashMap.put("dt_pgid", "pg_icgame_audience");
        hashMap.put("eid", "em_icgame_commercial");
        if (!hashMap.containsKey(DTParamKey.REPORT_KEY_APPKEY)) {
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND05GC39G3MA0B");
        }
        return hashMap;
    }

    private void r0(View view, String str, String str2) {
        VideoReport.reportEvent(str2, view, m0(str));
    }

    private void s0(View view, String str, String str2) {
        VideoReport.reportEvent(str2, null, n0(str));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c cVar, int i3) {
        ButtonBean buttonBean = this.C.get(i3);
        if (buttonBean.getType() == 1) {
            ep4.a bottomItem = buttonBean.getBottomItem();
            cVar.E.C0(true, bottomItem.f396936a, false);
            cVar.F.setText(bottomItem.f396937b);
        } else {
            cVar.E.B0(true, buttonBean.getResourceId(), false);
            cVar.F.setText(buttonBean.getName());
        }
        cVar.itemView.setOnClickListener(new a(buttonBean));
        if (buttonBean.getType() == 1) {
            k0(cVar.itemView, buttonBean.getBottomItem().f396937b);
        }
        if (buttonBean.getType() == 2) {
            j0(cVar.itemView, l0(this.E, buttonBean.getName()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fbe, viewGroup, false));
    }

    public void q0() {
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            ButtonBean buttonBean = this.C.get(i3);
            if (buttonBean.getType() == 1) {
                s0(null, buttonBean.getBottomItem().f396937b, "imp_end");
            }
            if (buttonBean.getType() == 2) {
                r0(null, l0(this.E, buttonBean.getName()), "imp_end");
            }
        }
    }

    public void t0(d dVar, List<ButtonBean> list) {
        this.C = list;
        this.f115175m = dVar;
    }

    public void u0(InterfaceC5831b interfaceC5831b) {
        this.D = interfaceC5831b;
    }
}
