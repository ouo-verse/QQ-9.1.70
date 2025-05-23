package com.tencent.guild.aio.input.at.quickAt.selectmember.view;

import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import xo0.b;
import ze1.c;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GuildAtSelectItemListView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private final b f111008d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f111009e;

    /* renamed from: f, reason: collision with root package name */
    private xo0.a f111010f;

    /* renamed from: h, reason: collision with root package name */
    private vo0.a f111011h;

    /* renamed from: i, reason: collision with root package name */
    private c f111012i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                return;
            }
            if (GuildAtSelectItemListView.this.f111010f.getNUM_BACKGOURND_ICON() - ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() < 10 && GuildAtSelectItemListView.this.f111012i != null && GuildAtSelectItemListView.this.f111012i.b()) {
                QLog.e("GuildAtSelectItemListVi", 1, "load more");
                GuildAtSelectItemListView.this.f111012i.a();
            }
        }
    }

    public GuildAtSelectItemListView(b bVar, vo0.b bVar2, boolean z16) {
        super(bVar.b());
        this.f111008d = bVar;
        f();
        g(bVar2);
        e(z16);
    }

    private void e(boolean z16) {
        this.f111010f = new xo0.a(this.f111008d, this.f111011h, z16);
        this.f111009e.setLayoutManager(new LinearLayoutManager(this.f111008d.b(), 1, false));
        this.f111009e.setAdapter(this.f111010f);
        this.f111009e.addOnScrollListener(new a());
        this.f111011h.a(this.f111010f);
    }

    private void f() {
        RecyclerView recyclerView = new RecyclerView(this.f111008d.b());
        this.f111009e = recyclerView;
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        addView(this.f111009e, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void g(vo0.b bVar) {
        vo0.a aVar = new vo0.a();
        this.f111011h = aVar;
        aVar.a(bVar);
    }

    public int c() {
        xo0.a aVar = this.f111010f;
        if (aVar == null) {
            return 0;
        }
        return aVar.getNUM_BACKGOURND_ICON();
    }

    public List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> d() {
        return this.f111011h.d();
    }

    public boolean h() {
        return this.f111011h.e();
    }

    public void i() {
        this.f111010f.u0();
        this.f111011h.j();
        this.f111010f.u0();
    }

    public void j() {
        this.f111011h.k();
        this.f111010f.onDestroy();
    }

    public boolean k(int i3) {
        return this.f111009e.canScrollVertically(i3);
    }

    public void l(long j3, int i3) {
        this.f111011h.o(j3, i3);
    }

    public void setEnableMultiSelectMode(boolean z16) {
        this.f111011h.m(z16);
    }

    public void setMemberDataList(List<com.tencent.guild.aio.input.at.quickAt.selectmember.data.a> list) {
        this.f111011h.n(list);
    }

    public void setRecycleViewOverScrollMode(int i3) {
        this.f111009e.setOverScrollMode(i3);
    }

    public void setRecyclerViewSelection(int i3) {
        this.f111009e.getLayoutManager().scrollToPosition(i3);
    }

    public void setSearchContext(c cVar) {
        this.f111012i = cVar;
    }
}
