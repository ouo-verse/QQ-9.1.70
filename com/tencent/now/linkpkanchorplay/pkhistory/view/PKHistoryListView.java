package com.tencent.now.linkpkanchorplay.pkhistory.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import g55.at;
import g55.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import um3.b;

/* loaded from: classes22.dex */
public class PKHistoryListView extends FrameLayout {
    private um3.b C;
    private String D;
    private boolean E;
    private d F;

    /* renamed from: d, reason: collision with root package name */
    private View f338385d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f338386e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView f338387f;

    /* renamed from: h, reason: collision with root package name */
    private vm3.b f338388h;

    /* renamed from: i, reason: collision with root package name */
    private List<at> f338389i;

    /* renamed from: m, reason: collision with root package name */
    private long f338390m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (PKHistoryListView.this.F != null) {
                PKHistoryListView.this.F.onBack();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            if (PKHistoryListView.this.E && PKHistoryListView.this.i()) {
                PKHistoryListView pKHistoryListView = PKHistoryListView.this;
                pKHistoryListView.j(pKHistoryListView.D);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class c implements b.a {
        c() {
        }

        @Override // um3.b.a
        public void a(o oVar) {
            if (oVar != null) {
                PKHistoryListView.this.k(oVar);
            }
        }
    }

    /* loaded from: classes22.dex */
    public interface d {
        void onBack();
    }

    public PKHistoryListView(@NonNull Context context, long j3) {
        super(context);
        this.f338385d = null;
        this.f338386e = null;
        this.f338387f = null;
        this.f338388h = null;
        this.f338389i = new ArrayList();
        this.C = null;
        this.D = "";
        this.E = false;
        this.F = null;
        this.f338390m = j3;
        h();
    }

    private void g() {
        this.f338388h = new vm3.b(3);
        j(this.D);
        this.f338387f.addOnScrollListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        if (this.f338388h.getNUM_BACKGOURND_ICON() > 0 && this.f338387f.computeVerticalScrollExtent() + this.f338387f.computeVerticalScrollOffset() >= this.f338387f.computeVerticalScrollRange()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        if (this.C == null) {
            um3.b bVar = new um3.b();
            this.C = bVar;
            bVar.b();
        }
        this.C.d(this.f338390m, str, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(o oVar) {
        this.D = oVar.f401376e;
        this.E = oVar.f401374c;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, oVar.f401373b);
        this.f338389i.addAll(arrayList);
        if (this.f338389i.size() == 0) {
            this.f338386e.setVisibility(0);
            return;
        }
        this.f338386e.setVisibility(8);
        if (this.f338387f.getAdapter() == null) {
            this.f338388h.setData(this.f338389i);
            this.f338387f.setAdapter(this.f338388h);
        } else {
            this.f338388h.notifyDataSetChanged();
        }
    }

    public void h() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.feu, (ViewGroup) this, true);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.xa5);
        this.f338387f = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f338387f.setHasFixedSize(true);
        View findViewById = inflate.findViewById(R.id.t2s);
        this.f338385d = findViewById;
        findViewById.setOnClickListener(new a());
        this.f338386e = (TextView) inflate.findViewById(R.id.bws);
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        um3.b bVar = this.C;
        if (bVar != null) {
            bVar.e();
        }
        this.F = null;
    }

    public void setCallback(d dVar) {
        this.F = dVar;
    }

    public void setCurRoomId(long j3) {
        this.f338390m = j3;
    }

    public PKHistoryListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f338385d = null;
        this.f338386e = null;
        this.f338387f = null;
        this.f338388h = null;
        this.f338389i = new ArrayList();
        this.f338390m = 0L;
        this.C = null;
        this.D = "";
        this.E = false;
        this.F = null;
        h();
    }

    public PKHistoryListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338385d = null;
        this.f338386e = null;
        this.f338387f = null;
        this.f338388h = null;
        this.f338389i = new ArrayList();
        this.f338390m = 0L;
        this.C = null;
        this.D = "";
        this.E = false;
        this.F = null;
        h();
    }
}
