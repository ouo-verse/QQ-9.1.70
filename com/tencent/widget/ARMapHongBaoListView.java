package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ARMapHongBaoListView extends HongBaoListView {
    static IPatchRedirector $redirector_;

    /* renamed from: b0, reason: collision with root package name */
    public com.tencent.mobileqq.armap.d f384495b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f384496c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f384497d0;

    /* renamed from: e0, reason: collision with root package name */
    public volatile com.tencent.mobileqq.armap.d f384498e0;

    /* renamed from: f0, reason: collision with root package name */
    boolean f384499f0;

    /* renamed from: g0, reason: collision with root package name */
    boolean f384500g0;

    /* renamed from: h0, reason: collision with root package name */
    boolean f384501h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f384502i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f384503j0;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface c {
    }

    public ARMapHongBaoListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f384496c0 = true;
        this.f384499f0 = true;
        this.f384500g0 = true;
        this.f384502i0 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) canvas);
        } else {
            boolean z16 = this.mForHongBao;
            super.dispatchDraw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        if (r4.f384498e0.b(r5) != false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    @Override // com.tencent.widget.HongBaoListView, com.tencent.mobileqq.fpsreport.FPSSwipListView, com.tencent.widget.XListView, com.tencent.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        boolean z17 = true;
        if ((this.D && this.f384497d0 && this.E && this.f384499f0) || this.G) {
            int listViewScrollY = getListViewScrollY();
            if (listViewScrollY < 0) {
                listViewScrollY = 0;
            }
            com.tencent.mobileqq.armap.d dVar = this.f384495b0;
            if (dVar != null) {
                dVar.P = -listViewScrollY;
                if (dVar.b(canvas)) {
                    z16 = true;
                    if (z16) {
                        invalidate();
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
        }
        if (this.f384501h0 && this.f384498e0 != null && this.f384500g0) {
            int listViewScrollY2 = getListViewScrollY();
            if (listViewScrollY2 < 0) {
                listViewScrollY2 = 0;
            }
            if (this.f384501h0 && this.f384498e0 != null) {
                this.f384498e0.P = -listViewScrollY2;
            }
            z17 = false;
            if (z17) {
                invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.HongBaoListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView
    public int getSpringbackOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("ARMapHongBaoListView", 2, "story getSpringbackOffset, scrollY:" + getScrollY());
        }
        return super.getSpringbackOffset();
    }

    @Override // com.tencent.widget.HongBaoListView, com.tencent.widget.SwipListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if ((!this.D || !this.E) && !this.G) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (!this.f384496c0) {
            return true;
        }
        if ((motionEvent.getAction() & 255) == 0) {
            if (this.f384497d0 && this.f384495b0 != null) {
                int listViewScrollY = getListViewScrollY();
                int scrollY = getScrollY();
                if (scrollY < 0) {
                    listViewScrollY = scrollY;
                }
                if (this.f384495b0.j(listViewScrollY).contains(motionEvent.getX(), motionEvent.getY())) {
                    this.N = true;
                    super.onInterceptTouchEvent(motionEvent);
                    return true;
                }
            } else {
                this.N = false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.HongBaoListView, com.tencent.widget.AbsListView, android.view.View
    public void onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            super.onOverScrolled(i3, i16, z16, z17);
        }
    }

    @Override // com.tencent.widget.AdapterView, android.view.ViewGroup
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        int bottom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) view, (Object) accessibilityEvent)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("ARMapHongBaoListView", 2, "onRequestSendAccessibilityEvent() called with: child = [" + view + "], event = [" + accessibilityEvent + "]");
        }
        boolean onRequestSendAccessibilityEvent = super.onRequestSendAccessibilityEvent(view, accessibilityEvent);
        if (accessibilityEvent.getEventType() == 32768 && (bottom = view.getBottom() - (getHeight() - getListPaddingBottom())) > 0) {
            smoothScrollBy(bottom, 200);
        }
        return onRequestSendAccessibilityEvent;
    }

    @Override // com.tencent.widget.HongBaoListView, com.tencent.widget.SwipListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.mForHongBao) {
            boolean z16 = this.mEnableStory;
        }
        if ((!this.D || !this.E) && !this.G) {
            return super.onTouchEvent(motionEvent);
        }
        if (!this.f384496c0) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (action != 1) {
            if (action != 2 && action == 3) {
                this.N = false;
            }
        } else {
            boolean z17 = this.N;
            this.N = false;
        }
        return onTouchEvent;
    }

    public void setActiveListViewListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        }
    }

    public void setEnableTouch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ARMapHongBaoListView", 2, "setEnableTouch, enableTouch:" + z16);
        }
        this.f384496c0 = z16;
    }

    public void setOnPendentClickListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) cVar);
        }
    }

    public void setPendantHolder(com.tencent.mobileqq.armap.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) dVar);
            return;
        }
        this.f384495b0 = dVar;
        boolean z16 = true;
        if (dVar != null) {
            this.G = true;
        } else {
            this.G = false;
        }
        if (dVar == null) {
            z16 = false;
        }
        this.f384497d0 = z16;
        invalidate();
    }

    public void setQQStoryListViewListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bVar);
        }
    }

    public void setScrollState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.f384503j0 = i3;
        }
    }

    public void setShowLightByUser(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        this.f384500g0 = z16;
        if (QLog.isColorLevel()) {
            QLog.i("ARMapHongBaoListView", 2, "setShowLightByUser:" + this.f384500g0);
        }
    }

    @Override // com.tencent.widget.ListView
    public void springBackOverScrollHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (!this.mForHongBao) {
            boolean z16 = this.mEnableStory;
        }
        super.springBackOverScrollHeaderView();
    }

    public ARMapHongBaoListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f384496c0 = true;
        this.f384499f0 = true;
        this.f384500g0 = true;
        this.f384502i0 = false;
    }
}
