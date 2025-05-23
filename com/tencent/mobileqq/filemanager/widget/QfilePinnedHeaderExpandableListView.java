package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;

/* loaded from: classes12.dex */
public class QfilePinnedHeaderExpandableListView extends FPSPinnedHeaderExpandableListView {
    private float C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private int H;
    private a I;
    private boolean J;
    private int K;
    private boolean L;

    /* renamed from: i, reason: collision with root package name */
    private float f209462i;

    /* renamed from: m, reason: collision with root package name */
    private float f209463m;

    /* loaded from: classes12.dex */
    public interface a {
        void a(int i3, int i16);

        void b(int i3, int i16);

        void c(boolean z16);

        void d(int i3, int i16, int i17, int i18);
    }

    public QfilePinnedHeaderExpandableListView(Context context) {
        super(context);
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.L = false;
        setNeedCheckSpringback(true);
        e0(context);
        setTouchSlop(context);
    }

    private void e0(Context context) {
        setSelector(R.color.ajr);
        setGroupIndicator(null);
    }

    public int[] f0(int i3, int i16) {
        int i17;
        Object tag;
        ViewGroup viewGroup = (ViewGroup) getChildAt(pointToPosition(i3, i16) - getFirstVisiblePosition());
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        int i18 = this.K;
        if (i18 == 0) {
            return null;
        }
        if (i3 > i18 * childCount) {
            i17 = childCount - 1;
        } else {
            i17 = i3 / i18;
        }
        View childAt = viewGroup.getChildAt(i17);
        if (childAt != null && (tag = childAt.getTag()) != null) {
            if (tag instanceof ob1.c) {
                ob1.c cVar = (ob1.c) tag;
                return new int[]{cVar.f422334i, cVar.f422333h};
            }
            if (ob1.a.class.isInstance(tag)) {
                ob1.a aVar = (ob1.a) tag;
                return new int[]{aVar.f422319h, aVar.f422318g};
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
    
        if (r0 != 3) goto L27;
     */
    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.J) {
            int action = motionEvent.getAction();
            if (action == 2 && this.L) {
                return true;
            }
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            int i3 = action & 255;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        float abs = Math.abs(x16 - this.f209462i);
                        if (abs > Math.abs(y16 - this.f209463m) * 1.73f && abs > this.C) {
                            this.L = true;
                            this.f209462i = x16;
                            this.f209463m = y16;
                        }
                    }
                }
                boolean z16 = this.L;
                this.L = false;
                this.G = -1;
                this.E = -1;
                this.H = -1;
                this.F = -1;
                this.D = false;
                if (z16) {
                    return true;
                }
            } else {
                this.f209462i = x16;
                this.f209463m = y16;
                int[] f06 = f0((int) x16, (int) y16);
                if (f06 != null) {
                    int i16 = f06[0];
                    this.G = i16;
                    this.E = i16;
                    int i17 = f06[1];
                    this.H = i17;
                    this.F = i17;
                }
            }
            if (this.L) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r0 != 3) goto L59;
     */
    @Override // com.tencent.widget.SwipPinnedHeaderExpandableListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (this.J) {
            int action = motionEvent.getAction();
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            int i19 = action & 255;
            if (i19 != 0) {
                if (i19 != 1) {
                    if (i19 == 2) {
                        if (!this.L) {
                            float abs = Math.abs(x16 - this.f209462i);
                            if (abs > Math.abs(y16 - this.f209463m) * 1.73f && abs > this.C) {
                                this.L = true;
                                this.f209462i = x16;
                                this.f209463m = y16;
                            } else {
                                a aVar = this.I;
                                if (aVar != null) {
                                    aVar.c(true);
                                }
                            }
                        }
                        if (this.L) {
                            if (!this.D && (i17 = this.E) != -1 && (i18 = this.F) != -1) {
                                a aVar2 = this.I;
                                if (aVar2 != null) {
                                    aVar2.b(i17, i18);
                                }
                                this.D = true;
                            }
                            int[] f06 = f0((int) x16, (int) y16);
                            if (f06 != null) {
                                i16 = f06[0];
                                i3 = f06[1];
                            } else {
                                i3 = -1;
                                i16 = -1;
                            }
                            if (i16 != -1 && i3 != -1) {
                                if (!this.D) {
                                    this.G = i16;
                                    this.E = i16;
                                    this.H = i3;
                                    this.F = i3;
                                    a aVar3 = this.I;
                                    if (aVar3 != null) {
                                        aVar3.b(i16, i3);
                                    }
                                    this.D = true;
                                } else {
                                    this.G = i16;
                                    this.H = i3;
                                    a aVar4 = this.I;
                                    if (aVar4 != null) {
                                        aVar4.d(this.E, this.F, i16, i3);
                                    }
                                }
                            }
                        }
                    }
                }
                boolean z16 = this.L;
                a aVar5 = this.I;
                if (aVar5 != null) {
                    if (z16) {
                        aVar5.a(this.G, this.H);
                    }
                    this.I.c(false);
                }
                this.G = -1;
                this.E = -1;
                this.H = -1;
                this.F = -1;
                this.L = false;
                this.D = false;
                if (z16) {
                    return true;
                }
            } else {
                this.f209462i = x16;
                this.f209463m = y16;
            }
            if (this.L) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setGridSize(int i3) {
        this.K = i3;
    }

    public void setOnIndexChangedListener(a aVar) {
        this.I = aVar;
    }

    public void setTouchSlop(Context context) {
        this.C = ViewConfiguration.get(context).getScaledTouchSlop() * 15;
    }

    public void setWhetherImageTab(boolean z16) {
        this.J = z16;
    }

    public QfilePinnedHeaderExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.L = false;
        e0(context);
        setTouchSlop(context);
    }

    public QfilePinnedHeaderExpandableListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.H = -1;
        this.L = false;
        e0(context);
        setTouchSlop(context);
    }
}
