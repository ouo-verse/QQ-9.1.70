package com.tencent.mobileqq.vas.troopnick.shop.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ShopLayout extends FrameLayout implements View.OnClickListener {
    private long C;
    private RecyclerView.OnScrollListener D;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f311086d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.vas.troopnick.shop.widget.a f311087e;

    /* renamed from: f, reason: collision with root package name */
    private int f311088f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.vas.troopnick.shop.adapter.b f311089h;

    /* renamed from: i, reason: collision with root package name */
    private d f311090i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f311091m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends GridLayoutManager {
        a(Context context, int i3) {
            super(context, i3);
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            if (ShopLayout.this.f311091m && super.canScrollHorizontally()) {
                return true;
            }
            return false;
        }

        @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            if (ShopLayout.this.f311091m && super.canScrollVertically()) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends GridLayoutManager.SpanSizeLookup {
        b() {
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i3) {
            if (ShopLayout.this.f311087e.getItemViewType(i3) == 0) {
                return 1;
            }
            return 3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            int i16;
            if (ShopLayout.this.f311090i != null) {
                ShopLayout.this.f311090i.hideInputMethod();
            }
            if (i3 == 0) {
                RecyclerView.LayoutManager layoutManager = ShopLayout.this.f311086d.getLayoutManager();
                if (layoutManager instanceof GridLayoutManager) {
                    i16 = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                } else {
                    i16 = 0;
                }
                if (layoutManager.getChildCount() > 0 && i16 >= layoutManager.getItemCount() - 1) {
                    ShopLayout.this.i(true);
                    QLog.d("ShopLayout", 2, " load more shop data newState:" + i3 + " lastVisiblePosition:" + i16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface d {
        void hideInputMethod();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface e {
        void a(int i3, int i16);
    }

    public ShopLayout(@NonNull Context context) {
        super(context);
        this.f311091m = true;
        this.C = 0L;
        this.D = new c();
        g();
    }

    private void e() {
        TextView textView = (TextView) findViewById(R.id.mca);
        if (ThemeUtil.isNowThemeIsNight(ThemeUtil.getCreateAppRuntime(), false, null)) {
            this.f311086d.setBackgroundColor(-16777216);
            textView.setTextColor(-1);
        } else {
            this.f311086d.setBackgroundColor(-1);
            textView.setTextColor(getContext().getColor(R.color.f156903es));
        }
    }

    private void g() {
        View.inflate(getContext(), R.layout.hhn, this);
        this.f311086d = (RecyclerView) findViewById(R.id.f166916is1);
        a aVar = new a(getContext(), 3);
        aVar.setSpanSizeLookup(new b());
        this.f311086d.setLayoutManager(aVar);
        com.tencent.mobileqq.vas.troopnick.shop.widget.a aVar2 = new com.tencent.mobileqq.vas.troopnick.shop.widget.a(getContext());
        this.f311087e = aVar2;
        this.f311086d.setAdapter(aVar2);
        this.f311086d.setOnScrollListener(this.D);
        e();
        findViewById(R.id.f165084bw1).setVisibility(8);
        findViewById(R.id.mca).setOnClickListener(this);
        findViewById(R.id.f165763fq0).setOnClickListener(this);
        h();
        o33.a.a(0, 0, 0, 100);
    }

    public com.tencent.mobileqq.vas.troopnick.shop.widget.a f() {
        return this.f311087e;
    }

    public void h() {
        this.f311086d.setAdapter(this.f311087e);
    }

    public void i(boolean z16) {
        com.tencent.mobileqq.vas.troopnick.shop.adapter.b bVar = this.f311089h;
        if (bVar == null) {
            return;
        }
        if (z16) {
            bVar.loadMore();
        } else {
            bVar.request();
        }
    }

    public void j() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.C;
        if (j3 == 0) {
            this.C = currentTimeMillis;
        } else if (currentTimeMillis - j3 > 2000) {
            this.C = currentTimeMillis;
            i(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.mca || id5 == R.id.f165763fq0) {
            i(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setAppId(int i3) {
        this.f311088f = i3;
    }

    public void setEnableScroll(boolean z16) {
        this.f311091m = z16;
    }

    public void setHideInputmethod(d dVar) {
        this.f311090i = dVar;
    }

    public void setItemId(int i3) {
        this.f311087e.C(i3);
    }

    public void setRequest(com.tencent.mobileqq.vas.troopnick.shop.adapter.b bVar) {
        this.f311089h = bVar;
        bVar.request();
    }

    public void setShopCallback(e eVar) {
        this.f311087e.D(eVar);
    }

    public ShopLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f311091m = true;
        this.C = 0L;
        this.D = new c();
        g();
    }

    public ShopLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f311091m = true;
        this.C = 0L;
        this.D = new c();
        g();
    }
}
