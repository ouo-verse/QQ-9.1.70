package com.tencent.mobileqq.wink.picker.core.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes21.dex */
public class MediaRecyclerView extends RecyclerView {
    float C;
    int D;
    int E;
    AtomicBoolean F;
    AtomicBoolean G;
    AtomicBoolean H;
    boolean I;
    boolean J;
    LinearSmoothScroller K;

    /* renamed from: f, reason: collision with root package name */
    GridLayoutManager f324717f;

    /* renamed from: h, reason: collision with root package name */
    c f324718h;

    /* renamed from: i, reason: collision with root package name */
    int f324719i;

    /* renamed from: m, reason: collision with root package name */
    float f324720m;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 500.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i3) {
            int i16;
            GridLayoutManager gridLayoutManager = MediaRecyclerView.this.f324717f;
            if (gridLayoutManager != null && gridLayoutManager.getChildCount() != 0 && MediaRecyclerView.this.f324717f.getChildAt(0) != null) {
                GridLayoutManager gridLayoutManager2 = MediaRecyclerView.this.f324717f;
                View childAt = gridLayoutManager2.getChildAt(0);
                Objects.requireNonNull(childAt);
                if (i3 < gridLayoutManager2.getPosition(childAt)) {
                    i16 = -1;
                } else {
                    i16 = 1;
                }
                return new PointF(0.0f, i16);
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface c {
        void onSelectBegin(int i3);

        void onSelectChanged(int i3, int i16);

        void onSelectEnd();
    }

    public MediaRecyclerView(@NonNull Context context) {
        super(context);
    }

    private void handleMove(float f16, float f17) {
        if (!this.F.get()) {
            float abs = Math.abs(f16 - this.f324720m);
            if (abs > Math.abs(f17 - this.C) * 1.73f && abs > this.f324719i) {
                this.F.set(true);
                this.f324720m = f16;
                this.C = f17;
            }
        }
        if (this.F.get()) {
            if (this.I) {
                handleMoveScrolling(f17);
            } else {
                handleMoveNoScrolling(f17);
            }
        }
        handleScroll((int) f16, (int) f17);
    }

    private void handleMoveNoScrolling(float f16) {
        if (f16 < 0.0f || f16 > getHeight()) {
            this.I = true;
            int i3 = 0;
            if (f16 < 0.0f) {
                this.J = false;
            } else if (f16 > getHeight()) {
                RecyclerView.Adapter adapter = getAdapter();
                Objects.requireNonNull(adapter);
                i3 = adapter.getItemCount();
                this.J = true;
            }
            this.K.setTargetPosition(i3);
            this.f324717f.startSmoothScroll(this.K);
        }
    }

    private void handleMoveScrolling(float f16) {
        if (f16 > 0.0f && f16 < getHeight()) {
            stopScroll();
            this.I = false;
        }
    }

    private void handleScroll(int i3, int i16) {
        int i17;
        if (this.F.get()) {
            int i18 = -1;
            if (!this.G.get() && (i17 = this.D) != -1) {
                c cVar = this.f324718h;
                if (cVar != null) {
                    cVar.onSelectBegin(i17);
                }
                this.G.set(true);
            }
            View findChildViewUnder = findChildViewUnder(i3, i16);
            if (findChildViewUnder != null) {
                i18 = getChildAdapterPosition(findChildViewUnder);
            }
            handleScrollSelectState(i18);
        }
    }

    private void handleScrollSelectState(int i3) {
        c cVar;
        if (i3 != -1) {
            if (!this.G.get()) {
                this.E = i3;
                this.D = i3;
                c cVar2 = this.f324718h;
                if (cVar2 != null) {
                    cVar2.onSelectBegin(i3);
                }
                this.G.set(true);
                return;
            }
            if (this.E != i3) {
                this.E = i3;
                if (!this.I && (cVar = this.f324718h) != null) {
                    cVar.onSelectChanged(this.D, i3);
                }
            }
        }
    }

    private boolean handleUp() {
        c cVar;
        if (this.I) {
            stopScroll();
            this.I = false;
        }
        boolean z16 = this.F.get();
        this.D = -1;
        this.E = -1;
        this.F.set(false);
        this.G.set(false);
        if (z16 && (cVar = this.f324718h) != null) {
            cVar.onSelectEnd();
        }
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r7 != 3) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean processEvent(MotionEvent motionEvent, int i3) {
        int i16;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int i17 = i3 & 255;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 == 2) {
                    float abs = Math.abs(x16 - this.f324720m);
                    if (abs > Math.abs(y16 - this.C) * 1.73f && abs > this.f324719i) {
                        this.F.set(true);
                        this.f324720m = x16;
                        this.C = y16;
                    }
                }
            }
            boolean z16 = this.F.get();
            this.F.set(false);
            this.D = -1;
            this.E = -1;
            this.G.set(false);
            if (z16) {
                return true;
            }
        } else {
            this.f324720m = x16;
            this.C = y16;
            View findChildViewUnder = findChildViewUnder((int) x16, (int) y16);
            if (findChildViewUnder != null) {
                i16 = getChildAdapterPosition(findChildViewUnder);
            } else {
                i16 = -1;
            }
            if (i16 != -1) {
                this.E = i16;
                this.D = i16;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        if (r0 != 3) goto L19;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.H.get()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    handleMove(x16, y16);
                }
            }
            if (handleUp()) {
                return true;
            }
        } else {
            this.f324720m = x16;
            this.C = y16;
        }
        if (this.F.get() || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.H.get()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if ((action == 2 && this.F.get()) || processEvent(motionEvent, action) || this.F.get() || super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setGridLayoutManager(@Nullable GridLayoutManager gridLayoutManager) {
        super.setLayoutManager(gridLayoutManager);
        this.f324717f = gridLayoutManager;
        this.H.set(true);
    }

    public void setOnIndexChangedListener(c cVar) {
        this.f324718h = cVar;
    }

    public MediaRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = -1;
        this.E = -1;
        this.F = new AtomicBoolean(false);
        this.G = new AtomicBoolean(false);
        this.H = new AtomicBoolean(false);
        this.I = false;
        this.J = true;
        this.f324719i = ViewConfiguration.get(context).getScaledTouchSlop() * 15;
        addOnScrollListener(new b());
        this.K = new a(context);
    }

    public MediaRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            MediaRecyclerView mediaRecyclerView = MediaRecyclerView.this;
            if (mediaRecyclerView.I) {
                if (mediaRecyclerView.J) {
                    mediaRecyclerView.E = mediaRecyclerView.f324717f.findLastVisibleItemPosition();
                } else {
                    mediaRecyclerView.E = mediaRecyclerView.f324717f.findFirstCompletelyVisibleItemPosition();
                }
                MediaRecyclerView mediaRecyclerView2 = MediaRecyclerView.this;
                mediaRecyclerView2.f324718h.onSelectChanged(mediaRecyclerView2.D, mediaRecyclerView2.E);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
        }
    }
}
