package com.tencent.biz.qqcircle.immersive.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSResetPublishShareBannerShowTimeEvent;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class z extends BaseListViewAdapter<e40.o> {
    public static final String F = "com.tencent.biz.qqcircle.immersive.adapter.z";
    private LayoutInflater C;
    private b D;
    private String E;

    /* renamed from: m, reason: collision with root package name */
    private Context f84744m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {
        private RoundCornerImageView E;
        private TextView F;

        public a(@NonNull View view) {
            super(view);
            this.E = (RoundCornerImageView) view.findViewById(R.id.f55732ip);
            this.F = (TextView) view.findViewById(R.id.f55742iq);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(e40.o oVar);
    }

    public z(Context context) {
        this.f84744m = context;
        this.C = LayoutInflater.from(context);
    }

    private void j0(View view, int i3) {
        int itemViewType = getItemViewType(i3);
        e40.o oVar = (e40.o) this.mDataList.get(i3);
        if (oVar == null) {
            QLog.e(F, 1, "bind dtreport failed with null info");
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYLIST_ITEM_INDEX, Integer.valueOf(i3 + 1));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYLIST_ITEM_UIN, oVar.c());
        String str = QCircleDaTongConstant.ElementId.EM_XSJ_PYLIST;
        if (itemViewType == 0) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYLIST_ITEM_STYPE, 1);
        } else if (itemViewType == 1) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYLIST_ITEM_STYPE, 2);
        } else if (itemViewType == 2) {
            str = QCircleDaTongConstant.ElementId.EM_XSJ_PYLIST_MORE_BUTTON;
        }
        buildElementParams.put("xsj_eid", str);
        buildElementParams.put("xsj_custom_pgid", this.E);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private void k0(View view, int i3) {
        int itemViewType = getItemViewType(i3);
        e40.o oVar = (e40.o) this.mDataList.get(i3);
        if (oVar == null) {
            QLog.e(F, 1, "bind dtreport failed with null info");
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYLIST_ITEM_INDEX, Integer.valueOf(i3 + 1));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYLIST_ITEM_UIN, oVar.c());
        String str = QCircleDaTongConstant.ElementId.EM_XSJ_PYLIST;
        if (itemViewType == 0) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYLIST_ITEM_STYPE, 1);
        } else if (itemViewType == 1) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PYLIST_ITEM_STYPE, 2);
        } else if (itemViewType == 2) {
            str = QCircleDaTongConstant.ElementId.EM_XSJ_PYLIST_MORE_BUTTON;
        }
        buildElementParams.put("xsj_eid", str);
        buildElementParams.put("xsj_custom_pgid", this.E);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(e40.o oVar, a aVar, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        b bVar = this.D;
        if (bVar != null) {
            bVar.a(oVar);
            j0(aVar.itemView, i3);
            SimpleEventBus.getInstance().dispatchEvent(new QFSResetPublishShareBannerShowTimeEvent());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.mDataList.size() > 0 && i3 <= this.mDataList.size() - 1) {
            return ((e40.o) this.mDataList.get(i3)).b();
        }
        return 0;
    }

    public void m0(String str) {
        this.E = str;
    }

    public void n0(b bVar) {
        this.D = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i3) {
        Drawable q16;
        final a aVar = (a) viewHolder;
        int i16 = 1;
        if (i3 > this.mDataList.size() - 1) {
            return;
        }
        int itemViewType = getItemViewType(i3);
        final e40.o oVar = (e40.o) this.mDataList.get(i3);
        if (itemViewType == 2) {
            aVar.F.setText(this.f84744m.getResources().getString(R.string.f184883n3));
            aVar.E.setImageDrawable(this.f84744m.getResources().getDrawable(R.drawable.oqu));
        } else {
            aVar.F.setText(oVar.a());
            if (TextUtils.isEmpty(oVar.c())) {
                q16 = com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.nqp);
            } else {
                if (itemViewType == 1) {
                    i16 = 4;
                }
                q16 = QCirclePluginGlobalInfo.q(oVar.c(), i16);
            }
            aVar.E.setImageDrawable(q16);
        }
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.adapter.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                z.this.l0(oVar, aVar, i3, view);
            }
        });
        k0(aVar.itemView, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 2) {
            return new a(this.C.inflate(R.layout.gta, viewGroup, false));
        }
        return new a(this.C.inflate(R.layout.gt_, viewGroup, false));
    }
}
