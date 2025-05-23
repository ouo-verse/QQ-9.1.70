package com.qzone.album.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.widget.AbsListView;
import com.tencent.widget.HeaderViewListAdapter;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteNewErrorCode;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGestureSelectListView extends QZonePullToRefreshListView {
    int U;
    float V;
    float W;

    /* renamed from: a0, reason: collision with root package name */
    int f44223a0;

    /* renamed from: b0, reason: collision with root package name */
    int f44224b0;

    /* renamed from: c0, reason: collision with root package name */
    int f44225c0;

    /* renamed from: d0, reason: collision with root package name */
    AbsListView.OnScrollListener f44226d0;

    /* renamed from: e0, reason: collision with root package name */
    c f44227e0;

    /* renamed from: f0, reason: collision with root package name */
    AtomicBoolean f44228f0;

    /* renamed from: g0, reason: collision with root package name */
    AtomicBoolean f44229g0;

    /* renamed from: h0, reason: collision with root package name */
    AtomicBoolean f44230h0;

    /* renamed from: i0, reason: collision with root package name */
    final int f44231i0;

    /* renamed from: j0, reason: collision with root package name */
    boolean f44232j0;

    /* renamed from: k0, reason: collision with root package name */
    boolean f44233k0;

    /* renamed from: l0, reason: collision with root package name */
    a f44234l0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        boolean a(View view);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private class b implements AbsListView.OnScrollListener {
        b() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            QzoneGestureSelectListView qzoneGestureSelectListView = QzoneGestureSelectListView.this;
            if (qzoneGestureSelectListView.f44232j0) {
                int i18 = i3 + i16;
                if (qzoneGestureSelectListView.f44233k0 && Math.abs(i18 - qzoneGestureSelectListView.f44224b0) >= 3 && Math.abs(i18 - QzoneGestureSelectListView.this.f44224b0) <= 5) {
                    QzoneGestureSelectListView qzoneGestureSelectListView2 = QzoneGestureSelectListView.this;
                    int i19 = qzoneGestureSelectListView2.f44224b0;
                    int i26 = i17 - 1;
                    if (i19 + 3 > i26) {
                        qzoneGestureSelectListView2.f44224b0 = i26;
                    } else {
                        qzoneGestureSelectListView2.f44224b0 = i19 + 3;
                    }
                    qzoneGestureSelectListView2.f44227e0.onSelectChanged(qzoneGestureSelectListView2.f44224b0, qzoneGestureSelectListView2.v0(qzoneGestureSelectListView2.V));
                } else {
                    QzoneGestureSelectListView qzoneGestureSelectListView3 = QzoneGestureSelectListView.this;
                    if (!qzoneGestureSelectListView3.f44233k0 && Math.abs(i3 - qzoneGestureSelectListView3.f44224b0) >= 3 && Math.abs(i3 - QzoneGestureSelectListView.this.f44224b0) <= 5) {
                        QzoneGestureSelectListView qzoneGestureSelectListView4 = QzoneGestureSelectListView.this;
                        int i27 = qzoneGestureSelectListView4.f44224b0;
                        if (i27 - 3 < 0) {
                            qzoneGestureSelectListView4.f44224b0 = 0;
                        } else {
                            qzoneGestureSelectListView4.f44224b0 = i27 - 3;
                        }
                        qzoneGestureSelectListView4.f44227e0.onSelectChanged(qzoneGestureSelectListView4.f44224b0, qzoneGestureSelectListView4.v0(qzoneGestureSelectListView4.V));
                    }
                }
            }
            AbsListView.OnScrollListener onScrollListener = QzoneGestureSelectListView.this.f44226d0;
            if (onScrollListener != null) {
                onScrollListener.onScroll(absListView, i3, i16, i17);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            AbsListView.OnScrollListener onScrollListener = QzoneGestureSelectListView.this.f44226d0;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface c {
        void a(int i3, int i16);

        void b(int i3, int i16);

        void onSelectChanged(int i3, int i16);
    }

    public QzoneGestureSelectListView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v0(float f16) {
        int h16;
        if ((getAdapter() instanceof HeaderViewListAdapter) && (((HeaderViewListAdapter) getAdapter()).getWrappedAdapter() instanceof com.qzone.album.business.photolist.adapter.a) && (h16 = ((com.qzone.album.business.photolist.adapter.a) ((HeaderViewListAdapter) getAdapter()).getWrappedAdapter()).h()) > 0) {
            return (int) (f16 / h16);
        }
        return 0;
    }

    private boolean w0(MotionEvent motionEvent) {
        if (this.f44234l0 == null) {
            return false;
        }
        return this.f44234l0.a(getChildAt(findClosestMotionRow((int) motionEvent.getY()) - this.mFirstPosition));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        if (r0 != 3) goto L32;
     */
    @Override // com.qzone.widget.QZonePullToRefreshListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (w0(motionEvent)) {
            return false;
        }
        if (!this.f44230h0.get()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.f44228f0.get()) {
            return true;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    float abs = Math.abs(x16 - this.V);
                    if (abs > Math.abs(y16 - this.W) * 1.73f && abs > this.U) {
                        this.f44228f0.set(true);
                        this.V = x16;
                        this.W = y16;
                    }
                }
            }
            boolean z16 = this.f44228f0.get();
            this.f44228f0.set(false);
            this.f44223a0 = -1;
            this.f44224b0 = -1;
            this.f44229g0.set(false);
            if (z16) {
                return true;
            }
        } else {
            this.V = x16;
            this.W = y16;
            int pointToPosition = pointToPosition((int) x16, (int) y16) - getHeaderViewsCount();
            if (pointToPosition != -1) {
                this.f44224b0 = pointToPosition;
                this.f44223a0 = pointToPosition;
            }
        }
        if (this.f44228f0.get()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        if (r0 != 3) goto L85;
     */
    @Override // com.qzone.widget.QZonePullToRefreshListView, cooperation.qzone.api.FeedListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar;
        c cVar2;
        if (!this.f44230h0.get()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int i3 = action & 255;
        if (i3 != 0) {
            int i16 = 0;
            if (i3 != 1) {
                if (i3 == 2) {
                    float f16 = this.V;
                    if (!this.f44228f0.get()) {
                        float abs = Math.abs(x16 - this.V);
                        if (abs > Math.abs(y16 - this.W) * 1.73f && abs > this.U) {
                            this.f44228f0.set(true);
                            this.V = x16;
                            this.W = y16;
                        }
                    }
                    if (!this.f44228f0.get() || this.f44232j0) {
                        if (this.f44228f0.get() && this.f44232j0 && y16 > 250.0f && y16 < getHeight()) {
                            abordFling();
                            this.f44232j0 = false;
                        }
                    } else if (y16 < 250.0f || y16 > getHeight()) {
                        this.f44232j0 = true;
                        if (y16 < 250.0f) {
                            this.f44233k0 = false;
                            i16 = XhsShareConstants$XhsShareNoteNewErrorCode.UNKNOWN;
                        } else if (y16 > getHeight()) {
                            this.f44233k0 = true;
                            i16 = ThemeConstants.ZIP_VERSION;
                        }
                        smoothScrollBy(i16, 1000000);
                    }
                    if (this.f44228f0.get()) {
                        if (!this.f44229g0.get() && this.f44223a0 != -1) {
                            int v06 = v0(f16);
                            this.f44225c0 = v06;
                            c cVar3 = this.f44227e0;
                            if (cVar3 != null) {
                                cVar3.b(this.f44223a0, v06);
                            }
                            this.f44229g0.set(true);
                        }
                        int pointToPosition = pointToPosition((int) x16, (int) y16) - getHeaderViewsCount();
                        int v07 = v0(x16);
                        if (pointToPosition != -1) {
                            if (!this.f44229g0.get()) {
                                this.f44224b0 = pointToPosition;
                                this.f44223a0 = pointToPosition;
                                int v08 = v0(f16);
                                this.f44225c0 = v08;
                                c cVar4 = this.f44227e0;
                                if (cVar4 != null) {
                                    cVar4.b(this.f44223a0, v08);
                                }
                                this.f44229g0.set(true);
                            } else if (this.f44224b0 != pointToPosition || v07 != this.f44225c0) {
                                this.f44224b0 = pointToPosition;
                                this.f44225c0 = v07;
                                if (!this.f44232j0 && (cVar2 = this.f44227e0) != null) {
                                    cVar2.onSelectChanged(pointToPosition, v07);
                                }
                            }
                        }
                    }
                }
            }
            if (this.f44232j0) {
                abordFling();
                this.f44232j0 = false;
            }
            boolean z16 = this.f44228f0.get();
            this.f44228f0.set(false);
            this.f44229g0.set(false);
            if (z16 && (cVar = this.f44227e0) != null) {
                cVar.a(this.f44224b0, v0(x16));
            }
            this.f44223a0 = -1;
            this.f44224b0 = -1;
            if (z16) {
                return true;
            }
        } else {
            this.V = x16;
            this.W = y16;
        }
        if (this.f44228f0.get()) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setGestureSelectMode(boolean z16) {
        this.f44230h0.set(z16);
    }

    public void setInterceptTouchEventListener(a aVar) {
        this.f44234l0 = aVar;
    }

    public void setOnIndexChangedListener(c cVar) {
        this.f44227e0 = cVar;
    }

    @Override // com.tencent.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f44226d0 = onScrollListener;
    }

    public QzoneGestureSelectListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44223a0 = -1;
        this.f44224b0 = -1;
        this.f44225c0 = -1;
        this.f44228f0 = new AtomicBoolean(false);
        this.f44229g0 = new AtomicBoolean(false);
        this.f44230h0 = new AtomicBoolean(false);
        this.f44231i0 = ThemeConstants.ZIP_VERSION;
        this.f44232j0 = false;
        this.f44233k0 = true;
        this.f44234l0 = null;
        this.U = ViewConfiguration.get(context).getScaledTouchSlop();
        super.setOnScrollListener(new b());
    }
}
