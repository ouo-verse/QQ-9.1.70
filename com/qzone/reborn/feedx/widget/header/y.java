package com.qzone.reborn.feedx.widget.header;

import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxMoodListViewModel;
import com.qzone.reborn.feedx.widget.header.ab;
import com.qzone.widget.DisallowInterceptRecycleView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import java.util.ArrayList;
import java.util.List;
import x6.e;

/* compiled from: P */
/* loaded from: classes37.dex */
public class y extends d {

    /* renamed from: f, reason: collision with root package name */
    private QZoneFeedxMoodListViewModel f56336f;

    /* renamed from: h, reason: collision with root package name */
    private x6.e f56337h;

    /* renamed from: i, reason: collision with root package name */
    private DisallowInterceptRecycleView f56338i;

    /* renamed from: m, reason: collision with root package name */
    private ab f56339m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements RecyclerView.RecyclerListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            if (!(viewHolder instanceof ab.a) || viewHolder == null) {
                return;
            }
            ((ab.a) viewHolder).q();
        }
    }

    public y(View view) {
        super(view);
        this.f56338i = (DisallowInterceptRecycleView) view.findViewById(R.id.nfs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(x6.e eVar) {
        this.f56337h = eVar;
        if (eVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(6);
        List<e.a> list = this.f56337h.f447272c;
        if (list != null && list.size() >= 1) {
            for (int i3 = 0; i3 < this.f56337h.f447272c.size(); i3++) {
                q5.c cVar = new q5.c();
                e.a aVar = this.f56337h.f447272c.get(i3);
                if (aVar != null) {
                    cVar.f428372b = aVar.f447276b;
                    cVar.f428373c = aVar.f447277c;
                    cVar.f428371a = aVar.f447278d;
                    cVar.f428375e = aVar.f447280f;
                    cVar.f428374d = aVar.f447275a;
                    cVar.f428377g = aVar.f447279e;
                    cVar.f428378h = this.f56337h.f447274e;
                    arrayList.add(cVar);
                }
            }
        }
        ab abVar = this.f56339m;
        if (abVar != null) {
            abVar.p0(arrayList);
        }
        if (!com.qzone.util.am.h(this.f56337h.f447274e)) {
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(this.f56337h.f447274e, LoginData.getInstance().getUinString());
        }
        com.qzone.publish.utils.b.f52149c = true;
    }

    private void p() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(g());
        linearLayoutManager.setOrientation(0);
        this.f56338i.setLayoutManager(linearLayoutManager);
        ab abVar = new ab(g());
        this.f56339m = abVar;
        this.f56338i.setAdapter(abVar);
        this.f56338i.setRecyclerListener(new a());
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneMoodListHeaderShortcutElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        QZoneFeedxMoodListViewModel qZoneFeedxMoodListViewModel = (QZoneFeedxMoodListViewModel) k(QZoneFeedxMoodListViewModel.class);
        this.f56336f = qZoneFeedxMoodListViewModel;
        qZoneFeedxMoodListViewModel.v2().observe(i(), new Observer() { // from class: com.qzone.reborn.feedx.widget.header.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                y.this.o((x6.e) obj);
            }
        });
        p();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onResume() {
        super.onResume();
        this.f56339m.o0();
    }
}
