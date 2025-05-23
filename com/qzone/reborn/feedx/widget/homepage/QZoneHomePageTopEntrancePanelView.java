package com.qzone.reborn.feedx.widget.homepage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.homepage.ui.component.newpanel.HomePanelItem;
import com.qzone.personalize.model.CustomNaviCacheData;
import com.qzone.reborn.feedx.viewmodel.w;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes37.dex */
public class QZoneHomePageTopEntrancePanelView extends QZoneBaseWidgetView {
    private RecyclerView C;
    private a D;
    private View E;

    /* renamed from: e, reason: collision with root package name */
    private LifecycleOwner f56389e;

    /* renamed from: f, reason: collision with root package name */
    private final com.qzone.reborn.feedx.viewmodel.c f56390f;

    /* renamed from: h, reason: collision with root package name */
    private final w f56391h;

    /* renamed from: i, reason: collision with root package name */
    private final com.qzone.reborn.feedx.viewmodel.f f56392i;

    /* renamed from: m, reason: collision with root package name */
    private int f56393m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes37.dex */
    public static class a extends RecyclerView.Adapter<b> {
        private x6.a F;

        /* renamed from: m, reason: collision with root package name */
        private List<HomePanelItem> f56395m = new ArrayList();
        private List<QZoneHomePageTopEntrancePanelItemView> C = new ArrayList();
        private int D = 0;
        private boolean E = false;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            List<HomePanelItem> list = this.f56395m;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            if (ArrayUtils.isOutOfArrayIndex(0, this.f56395m)) {
                return 0;
            }
            return this.f56395m.get(i3).tabId;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(b bVar, int i3) {
            if (RFSafeListUtils.isEmpty(this.f56395m) || this.f56395m.size() <= i3) {
                return;
            }
            bVar.l(this.f56395m.get(i3), i3);
            View view = bVar.itemView;
            if (view instanceof QZoneHomePageTopEntrancePanelItemView) {
                QZoneHomePageTopEntrancePanelItemView qZoneHomePageTopEntrancePanelItemView = (QZoneHomePageTopEntrancePanelItemView) view;
                qZoneHomePageTopEntrancePanelItemView.v0(this.D);
                qZoneHomePageTopEntrancePanelItemView.x0(this.E);
                qZoneHomePageTopEntrancePanelItemView.y0(this.F);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
            QZoneHomePageTopEntrancePanelItemView a16 = QZoneHomePageTopEntranceFactory.f56381a.a(i3, viewGroup.getContext());
            a16.setParentView(viewGroup);
            a16.setViewType(i3);
            a16.initView();
            this.C.add(a16);
            return new b(a16);
        }

        public void l0(boolean z16) {
            this.E = z16;
        }

        public void m0(x6.a aVar) {
            this.F = aVar;
        }

        public void n0(int i3) {
            this.D = i3;
            notifyDataSetChanged();
        }

        public void setDataList(List<HomePanelItem> list) {
            this.f56395m.clear();
            if (list == null) {
                notifyDataSetChanged();
            } else {
                this.f56395m.addAll(list);
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes37.dex */
    public static class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }

        public void l(HomePanelItem homePanelItem, int i3) {
            View view = this.itemView;
            if (view instanceof QZoneBaseWidgetView) {
                ((QZoneBaseWidgetView) view).setData(homePanelItem, i3);
            }
        }
    }

    public QZoneHomePageTopEntrancePanelView(Context context, LifecycleOwner lifecycleOwner, com.qzone.reborn.feedx.viewmodel.c cVar) {
        super(context);
        this.f56393m = 255;
        this.f56389e = lifecycleOwner;
        this.f56390f = cVar;
        this.C = (RecyclerView) findViewById(R.id.ncz);
        View findViewById = findViewById(R.id.f162925nd0);
        this.E = findViewById;
        findViewById.setVisibility(8);
        this.f56391h = (w) cVar.W(w.class);
        this.f56392i = (com.qzone.reborn.feedx.viewmodel.f) cVar.W(com.qzone.reborn.feedx.viewmodel.f.class);
        v0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i3) {
        this.f56393m = i3;
        if (this.C.getBackground() != null && this.E.getBackground() != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QZoneHomePageTopEntrancePanelView", 2, "[updateBackgroundAlpha] mBackgroundAlpha = " + this.f56393m);
            }
            com.qzone.reborn.feedx.widget.i.a(this.C, this.f56393m);
            com.qzone.reborn.feedx.widget.i.a(this.E, this.f56393m);
            return;
        }
        QLog.e("QZoneHomePageTopEntrancePanelView", 1, "[changeAlpha] background == null");
    }

    private void v0() {
        this.D = new a();
        this.C.setLayoutManager(new LinearLayoutManager(getContext()));
        this.C.setAdapter(this.D);
        this.f56392i.M1().observe(this.f56389e, new Observer() { // from class: com.qzone.reborn.feedx.widget.homepage.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneHomePageTopEntrancePanelView.this.u0(((Integer) obj).intValue());
            }
        });
        this.f56391h.C2().observe(this.f56389e, new Observer() { // from class: com.qzone.reborn.feedx.widget.homepage.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneHomePageTopEntrancePanelView.this.x0((x6.a) obj);
            }
        });
        this.f56391h.A2().observe(this.f56389e, new Observer() { // from class: com.qzone.reborn.feedx.widget.homepage.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneHomePageTopEntrancePanelView.this.w0((CustomNaviCacheData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(final CustomNaviCacheData customNaviCacheData) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.homepage.QZoneHomePageTopEntrancePanelView.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.qzone.personalize.business.b.q(customNaviCacheData)) {
                    CustomNaviCacheData customNaviCacheData2 = customNaviCacheData;
                    int i3 = (int) customNaviCacheData2.profileCrossBarBgColor;
                    int i16 = (int) customNaviCacheData2.profileDescTextColor;
                    QZoneHomePageTopEntrancePanelView.this.C.setBackgroundColor(i3);
                    QZoneHomePageTopEntrancePanelView.this.D.n0(i16);
                } else {
                    QZoneHomePageTopEntrancePanelView.this.C.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
                    QZoneHomePageTopEntrancePanelView.this.D.n0(0);
                }
                QZoneHomePageTopEntrancePanelView qZoneHomePageTopEntrancePanelView = QZoneHomePageTopEntrancePanelView.this;
                qZoneHomePageTopEntrancePanelView.u0(qZoneHomePageTopEntrancePanelView.f56393m);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(x6.a aVar) {
        if (aVar == null) {
            QLog.e("QZoneHomePageTopEntrancePanelView", 1, "[updateEntranceInfo] userInfoData == null");
            return;
        }
        ArrayList<HomePanelItem> arrayList = aVar.mTopPanelShowList;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[updateEntranceInfo] topPanelShowList.size = ");
        sb5.append(arrayList == null ? -1 : arrayList.size());
        QLog.d("QZoneHomePageTopEntrancePanelView", 1, sb5.toString());
        boolean G = com.qzone.reborn.feedx.util.k.G(aVar);
        this.D.l0(G);
        boolean z16 = G && arrayList != null && arrayList.size() > 0;
        if (z16) {
            this.D.setDataList(arrayList);
            this.D.m0(aVar);
            this.E.setVisibility(0);
        }
        setVisibility(z16 ? 0 : 8);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cof;
    }

    public void onDestroy() {
        a aVar = this.D;
        if (aVar == null || ArrayUtils.isOutOfArrayIndex(0, aVar.C)) {
            return;
        }
        Iterator it = this.D.C.iterator();
        while (it.hasNext()) {
            ((QZoneHomePageTopEntrancePanelItemView) it.next()).onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
