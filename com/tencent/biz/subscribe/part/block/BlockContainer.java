package com.tencent.biz.subscribe.part.block;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.part.block.base.c;
import com.tencent.biz.subscribe.part.block.base.d;
import com.tencent.biz.subscribe.part.block.base.e;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseFragment;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BlockContainer extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private StatusView f96132d;

    /* renamed from: e, reason: collision with root package name */
    protected NestScrollRecyclerView f96133e;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.biz.subscribe.part.block.a f96134f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView.LayoutManager f96135h;

    /* renamed from: i, reason: collision with root package name */
    private BaseFragment f96136i;

    /* renamed from: m, reason: collision with root package name */
    private ExtraTypeInfo f96137m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends RecyclerView.ItemDecoration {
        public a(com.tencent.biz.subscribe.part.block.a aVar) {
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            com.tencent.biz.subscribe.part.block.a aVar = BlockContainer.this.f96134f;
            if (aVar != null && aVar.Y(childLayoutPosition) != null) {
                BlockContainer.this.f96134f.Y(childLayoutPosition).G(rect, view, recyclerView, state);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            super.onDraw(canvas, recyclerView, state);
            int childCount = recyclerView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                com.tencent.biz.subscribe.part.block.a aVar = BlockContainer.this.f96134f;
                if (aVar != null && aVar.Y(i3) != null) {
                    BlockContainer.this.f96134f.Y(i3).Y(canvas, recyclerView, recyclerView.getChildAt(i3), state);
                }
            }
        }
    }

    public BlockContainer(Context context) {
        this(context, null);
    }

    @NotNull
    private com.tencent.biz.subscribe.part.block.a a() {
        return new com.tencent.biz.subscribe.part.block.a(this);
    }

    protected StatusView b(View view) {
        StatusView statusView = new StatusView(getContext());
        statusView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        statusView.setVisibility(8);
        return statusView;
    }

    public com.tencent.biz.subscribe.part.block.a c() {
        return this.f96134f;
    }

    public ExtraTypeInfo d() {
        if (this.f96137m == null) {
            this.f96137m = new ExtraTypeInfo();
        }
        return this.f96137m;
    }

    public BaseFragment e() {
        return this.f96136i;
    }

    protected int f() {
        return R.layout.c6t;
    }

    public NestScrollRecyclerView g() {
        return this.f96133e;
    }

    public StatusView h() {
        if (this.f96132d == null) {
            StatusView b16 = b(this);
            this.f96132d = b16;
            b16.setVisibility(8);
            addView(this.f96132d, new ViewGroup.LayoutParams(-1, -1));
        }
        return this.f96132d;
    }

    protected void i(FrameLayout frameLayout) {
        NestScrollRecyclerView nestScrollRecyclerView = (NestScrollRecyclerView) frameLayout.findViewById(R.id.lcd);
        this.f96133e = nestScrollRecyclerView;
        nestScrollRecyclerView.setHasFixedSize(true);
        this.f96133e.setNestedScrollingEnabled(false);
        com.tencent.biz.subscribe.part.block.a a16 = a();
        this.f96134f = a16;
        this.f96133e.setAdapter(a16);
        this.f96133e.addItemDecoration(new a(this.f96134f));
        setLayoutManagerType(1, 1);
        this.f96133e.setItemAnimator(null);
        this.f96133e.setOverScrollMode(2);
    }

    protected void j() {
        LayoutInflater.from(getContext()).inflate(f(), this);
        i(this);
    }

    public boolean k() {
        com.tencent.biz.subscribe.part.block.a aVar = this.f96134f;
        if (aVar != null) {
            return aVar.C();
        }
        return false;
    }

    public boolean l() {
        com.tencent.biz.subscribe.part.block.a aVar = this.f96134f;
        if (aVar != null) {
            return aVar.i0();
        }
        return false;
    }

    public void m() {
        NestScrollRecyclerView nestScrollRecyclerView = this.f96133e;
        if (nestScrollRecyclerView != null) {
            if (nestScrollRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                ((LinearLayoutManager) this.f96133e.getLayoutManager()).setRecycleChildrenOnDetach(true);
            }
            this.f96133e.setAdapter(null);
        }
        com.tencent.biz.subscribe.part.block.a aVar = this.f96134f;
        if (aVar != null) {
            aVar.destroy();
        }
        if (h() != null && h().s() != null) {
            h().s().setImageDrawable(null);
        }
        this.f96136i = null;
    }

    public void n(MultiViewBlock multiViewBlock) {
        com.tencent.biz.subscribe.part.block.a aVar = this.f96134f;
        if (aVar != null) {
            aVar.k0(multiViewBlock);
        }
    }

    public void o(a.e eVar) {
        com.tencent.biz.subscribe.part.block.a aVar = this.f96134f;
        if (aVar != null) {
            aVar.m0(eVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void p() {
        com.tencent.biz.subscribe.part.block.a aVar = this.f96134f;
        if (aVar != null) {
            aVar.j0();
        }
    }

    public void setBlockWrapper(BlockPart blockPart) {
        com.tencent.biz.subscribe.part.block.a aVar = this.f96134f;
        if (aVar != null) {
            aVar.n0(blockPart);
        }
    }

    public void setEnableLoadMore(boolean z16) {
        com.tencent.biz.subscribe.part.block.a aVar = this.f96134f;
        if (aVar != null) {
            aVar.L(z16);
        }
    }

    public void setEnableRefresh(boolean z16) {
        com.tencent.biz.subscribe.part.block.a aVar = this.f96134f;
        if (aVar != null) {
            aVar.M(z16);
        }
    }

    public void setExtraTypeInfo(ExtraTypeInfo extraTypeInfo) {
        this.f96137m = extraTypeInfo;
    }

    public void setLayoutManagerType(int i3, int i16) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.f96133e.setHasFixedSize(false);
                    e eVar = new e(i16, 1);
                    this.f96135h = eVar;
                    eVar.setGapStrategy(0);
                }
            } else {
                c cVar = new c(getContext(), i16);
                this.f96135h = cVar;
                cVar.setSpanSizeLookup(this.f96134f.d0());
            }
        } else {
            this.f96135h = new d(getContext(), 1, false);
        }
        this.f96133e.setLayoutManager(this.f96135h);
        this.f96134f.P(this.f96135h);
    }

    public void setParentFragment(BaseFragment baseFragment) {
        this.f96136i = baseFragment;
    }

    public void setRefreshing(boolean z16) {
        com.tencent.biz.subscribe.part.block.a aVar = this.f96134f;
        if (aVar != null) {
            if (z16 && !aVar.F()) {
                this.f96134f.N(true);
            }
            if (!z16 && this.f96134f.F()) {
                this.f96134f.N(false);
            }
        }
    }

    public void setShareData(String str, a.d dVar) {
        com.tencent.biz.subscribe.part.block.a aVar = this.f96134f;
        if (aVar != null) {
            aVar.o0(str, dVar);
        }
    }

    public void setStatusView(StatusView statusView) {
        StatusView statusView2 = this.f96132d;
        if (statusView2 != null) {
            ((ViewGroup) statusView2.getParent()).removeView(this.f96132d);
        }
        this.f96132d = statusView;
        addView(statusView, new ViewGroup.LayoutParams(-1, -1));
    }

    public BlockContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BlockContainer(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        j();
    }
}
