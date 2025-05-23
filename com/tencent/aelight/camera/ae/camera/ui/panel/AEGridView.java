package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEGridView extends RecyclerView {

    /* renamed from: d, reason: collision with root package name */
    private Context f62889d;

    /* renamed from: e, reason: collision with root package name */
    private int f62890e;

    /* renamed from: f, reason: collision with root package name */
    private int f62891f;

    /* renamed from: h, reason: collision with root package name */
    private b f62892h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            Log.d("dtexpose", "onScrollStateChanged-" + i3);
            if (i3 == 0 || i3 == 1 || i3 == 2) {
                AEGridView.this.f(recyclerView);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(boolean z16, int i3);

        void b(int[] iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        private int f62894d;

        /* renamed from: e, reason: collision with root package name */
        private int f62895e;

        public c(int i3, int i16) {
            this.f62894d = i3;
            this.f62895e = i16;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.top = this.f62895e;
        }
    }

    public AEGridView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.f62889d = context;
        int f16 = BaseAIOUtils.f(60.0f, context.getResources());
        int f17 = BaseAIOUtils.f(12.0f, this.f62889d.getResources());
        int f18 = BaseAIOUtils.f(10.0f, this.f62889d.getResources());
        int i3 = this.f62889d.getResources().getDisplayMetrics().widthPixels;
        int i16 = (i3 - f18) / (f16 + f18);
        this.f62890e = i16;
        setPadding((i3 - (f16 * i16)) / (i16 + 1), 0, 0, f17 * 4);
        setClipToPadding(false);
        setLayoutManager(new GridLayoutManager(getContext(), this.f62890e));
        addItemDecoration(new c(this.f62890e, f18));
        addOnScrollListener(new a());
        this.f62891f = f16;
    }

    public void c(b bVar) {
        this.f62892h = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0090 A[Catch: Exception -> 0x009b, TRY_LEAVE, TryCatch #0 {Exception -> 0x009b, blocks: (B:11:0x0025, B:13:0x002f, B:16:0x005d, B:21:0x0061, B:22:0x008c, B:24:0x0090, B:30:0x0044, B:32:0x0048), top: B:10:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(RecyclerView recyclerView) {
        int i3;
        int[] d16;
        int orientation;
        int i16;
        Log.d("dtexpose", "handleCurrentVisibleItems-");
        if (recyclerView != null && recyclerView.getVisibility() == 0 && recyclerView.isShown() && recyclerView.getGlobalVisibleRect(new Rect())) {
            try {
                int[] iArr = new int[2];
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    Log.d("dtexpose", "LinearLayoutManager-");
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    d16 = e(linearLayoutManager);
                    orientation = linearLayoutManager.getOrientation();
                } else if (layoutManager instanceof GridLayoutManager) {
                    Log.d("dtexpose", "GridLayoutManager-");
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                    d16 = d(gridLayoutManager);
                    orientation = gridLayoutManager.getOrientation();
                } else {
                    i3 = -1;
                    if (iArr == null && iArr.length >= 2) {
                        Log.d("dtexpose", "\u5c4f\u5e55\u5185\u53ef\u89c1\u6761\u76ee\u7684\u8d77\u59cb\u4f4d\u7f6e\uff1a" + iArr[0] + "---" + iArr[1]);
                        this.f62892h.b(iArr);
                        for (i16 = iArr[0]; i16 <= iArr[1]; i16++) {
                            g(layoutManager.findViewByPosition(i16), i16, i3);
                        }
                    }
                    return;
                }
                int[] iArr2 = d16;
                i3 = orientation;
                iArr = iArr2;
                if (iArr == null) {
                    return;
                }
                Log.d("dtexpose", "\u5c4f\u5e55\u5185\u53ef\u89c1\u6761\u76ee\u7684\u8d77\u59cb\u4f4d\u7f6e\uff1a" + iArr[0] + "---" + iArr[1]);
                this.f62892h.b(iArr);
                while (i16 <= iArr[1]) {
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                Log.d("dtexpose", e16.getMessage());
            }
        }
    }

    public void h(int i3) {
        int f16 = ((i3 / this.f62890e) - 1) * (this.f62891f + BaseAIOUtils.f(10.0f, this.f62889d.getResources()));
        if (f16 < 0) {
            f16 = 0;
        }
        smoothScrollBy(0, f16);
    }

    private int[] d(GridLayoutManager gridLayoutManager) {
        return new int[]{gridLayoutManager.findFirstVisibleItemPosition(), gridLayoutManager.findLastVisibleItemPosition()};
    }

    private int[] e(LinearLayoutManager linearLayoutManager) {
        return new int[]{linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()};
    }

    public AEGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void g(View view, int i3, int i16) {
        if (view != null && view.getVisibility() == 0 && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            if (this.f62892h == null) {
                Log.e("dtexpose", "mExposeListener is null ");
                return;
            }
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            if (i16 == 1) {
                rect.height();
                int measuredHeight = view.getMeasuredHeight() / 2;
            }
            if (i16 == 0) {
                rect.width();
                int measuredWidth = view.getMeasuredWidth() / 2;
            }
            if (globalVisibleRect) {
                this.f62892h.a(true, i3);
            } else {
                this.f62892h.a(false, i3);
            }
        }
    }

    public AEGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init(context);
    }
}
