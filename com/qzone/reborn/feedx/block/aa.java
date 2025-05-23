package com.qzone.reborn.feedx.block;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aa extends RFWAbsLoadMoreAdapter {
    private static final String D = HardCodeUtil.qqStr(R.string.f133506a);
    private static final String E = HardCodeUtil.qqStr(R.string.f133496_);
    private static final String F = HardCodeUtil.qqStr(R.string.f133516b);
    private a C;

    /* renamed from: m, reason: collision with root package name */
    protected b f54760m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f54761a = aa.D;

        /* renamed from: b, reason: collision with root package name */
        private String f54762b = aa.E;

        /* renamed from: c, reason: collision with root package name */
        private String f54763c = aa.F;

        public a d(String str) {
            this.f54762b = str;
            return this;
        }

        public a e(String str) {
            this.f54761a = str;
            return this;
        }

        public a f(String str) {
            this.f54763c = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class b extends RecyclerView.ViewHolder {
        private final ProgressBar E;
        private final TextView F;

        public b(View view) {
            super(view);
            this.E = (ProgressBar) view.findViewById(R.id.mgp);
            this.F = (TextView) view.findViewById(R.id.nke);
        }
    }

    private String m0() {
        a aVar = this.C;
        if (aVar != null) {
            return aVar.f54761a;
        }
        return D;
    }

    private String n0() {
        a aVar = this.C;
        if (aVar != null) {
            return aVar.f54762b;
        }
        return E;
    }

    private String o0() {
        a aVar = this.C;
        if (aVar != null) {
            return aVar.f54763c;
        }
        return F;
    }

    public b l0() {
        return this.f54760m;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        super.onBindViewHolder(viewHolder, i3);
        QLog.d("QZoneListLoadMoreAdapter", 1, "onBindViewHolder   | holder = " + viewHolder + " | position = " + i3 + " | hashcode = " + hashCode());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        QLog.d("QZoneListLoadMoreAdapter", 1, "onCreateViewHolder  hashcode = " + hashCode());
        b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f128072d, viewGroup, false));
        this.f54760m = bVar;
        bVar.itemView.setVisibility(4);
        return this.f54760m;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean z16) {
        QLog.d("QZoneListLoadMoreAdapter", 1, "onLoadMoreEnd  |  hasMore = " + z16 + " |  hashcode = " + hashCode());
        b bVar = this.f54760m;
        if (bVar == null) {
            QLog.d("QZoneListLoadMoreAdapter", 1, "onLoadMoreEnd  mLoadMoreViewHolder == null");
            return;
        }
        bVar.E.setVisibility(8);
        if (z16) {
            this.f54760m.F.setText(n0());
        } else {
            this.f54760m.F.setText(o0());
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        QLog.d("QZoneListLoadMoreAdapter", 1, "onLoadMoreStart  hashcode = " + hashCode());
        b bVar = this.f54760m;
        if (bVar == null) {
            QLog.d("QZoneListLoadMoreAdapter", 1, "onLoadMoreStart  mLoadMoreViewHolder == null");
            return;
        }
        bVar.itemView.setVisibility(0);
        this.f54760m.E.setVisibility(0);
        this.f54760m.F.setText(m0());
    }

    public void p0(a aVar) {
        this.C = aVar;
    }
}
