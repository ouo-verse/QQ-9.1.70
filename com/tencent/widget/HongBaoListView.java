package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.portal.HongBaoPendantHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.module.ConversationHongBaoV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HongBaoListView extends FPSSwipListView {
    static IPatchRedirector $redirector_;
    public ConversationHongBaoV2 C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H;
    public boolean[] I;
    public float[] J;
    public int K;
    public i L;
    public int M;
    public boolean N;
    public boolean P;
    private long Q;
    private View R;
    public HongBaoPendantHolder S;
    public int T;
    public int U;
    public boolean V;
    public boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public Handler f384569a0;

    /* renamed from: f, reason: collision with root package name */
    OverScrollViewListener f384570f;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f384571h;

    /* renamed from: i, reason: collision with root package name */
    Drawable f384572i;

    /* renamed from: m, reason: collision with root package name */
    View f384573m;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HongBaoListView.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            if (i3 != 7) {
                                if (i3 == 8) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("HongBaoListView", 2, "handleMessage MSG_JUMP_PREGUIDE");
                                    }
                                    if (!HongBaoListView.this.isStackFromBottom()) {
                                        HongBaoListView.this.setStackFromBottom(true);
                                    }
                                    HongBaoListView.this.setStackFromBottom(false);
                                    HongBaoListView hongBaoListView = HongBaoListView.this;
                                    if (!hongBaoListView.P) {
                                        HongBaoListView.this.springBackTo(-((int) hongBaoListView.getResources().getDimension(R.dimen.aex)));
                                    }
                                }
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_PREGUIDE_END");
                                }
                                HongBaoListView.this.setIsShowingPreguide(false);
                                HongBaoListView.this.setSpringbackOffset(0);
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_THIRD_GUIDE_HIDE");
                            }
                            HongBaoListView.this.d0(300L);
                            HongBaoListView.this.f384569a0.sendEmptyMessageDelayed(7, 300L);
                            HongBaoListView.this.getClass();
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_THIRD_GUIDE_SHOW");
                        }
                        HongBaoListView.this.setIsShowingPreguide(true);
                        HongBaoListView hongBaoListView2 = HongBaoListView.this;
                        int i16 = hongBaoListView2.U;
                        int i17 = i16 / 2;
                        hongBaoListView2.setSpringbackOffset(-i16);
                        int i18 = message.arg1;
                        if (i18 != 0) {
                            i17 = i18;
                        }
                        HongBaoListView.this.springBackTo(-i17);
                        HongBaoListView.this.f384569a0.sendEmptyMessageDelayed(6, 2000L);
                        HongBaoListView.this.getClass();
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_FIRST_GUIDE_HIDE");
                    }
                    HongBaoListView.this.d0(300L);
                    HongBaoListView.this.f384569a0.sendEmptyMessageDelayed(7, 300L);
                    HongBaoListView.this.getClass();
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("HongBaoListView", 2, "handleMessage MSG_WHAT_FIRST_GUIDE_SHOW");
                }
                HongBaoListView.this.setIsShowingPreguide(true);
                HongBaoListView hongBaoListView3 = HongBaoListView.this;
                hongBaoListView3.springBackTo(-hongBaoListView3.U);
                HongBaoListView.this.getClass();
                HongBaoListView.this.f384569a0.sendEmptyMessageDelayed(2, 2000L);
                HongBaoListView.this.invalidate();
            }
            return false;
        }
    }

    public HongBaoListView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.C = null;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = -1;
        this.I = new boolean[10];
        this.J = new float[10];
        this.K = 1;
        this.L = null;
        this.N = false;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.f384569a0 = new Handler(Looper.getMainLooper(), new a());
    }

    public void c0(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) motionEvent);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("HongBaoListView", 2, "onTouchEvent debug click event x = " + motionEvent.getX() + ", y = " + motionEvent.getY() + ", getScrollY() = " + getScrollY());
        }
        if (this.S != null && currentTimeMillis - this.Q > 800 && getScrollY() == 0) {
            this.Q = currentTimeMillis;
            if (this.S.k().contains(motionEvent.getX(), motionEvent.getY())) {
                RectF i3 = this.S.i();
                if (i3 != null && i3.contains(motionEvent.getX(), motionEvent.getY())) {
                    i iVar = this.L;
                    if (iVar != null) {
                        iVar.b();
                    }
                } else {
                    i iVar2 = this.L;
                    if (iVar2 != null) {
                        iVar2.a();
                    }
                }
            }
        }
        this.N = false;
    }

    public void d0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, j3);
        } else {
            springBackOverScrollHeaderView();
        }
    }

    @Override // com.tencent.mobileqq.fpsreport.FPSSwipListView, com.tencent.widget.XListView, com.tencent.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        HongBaoPendantHolder hongBaoPendantHolder = this.S;
        if (this.P && hongBaoPendantHolder != null) {
            int listViewScrollY = getListViewScrollY();
            if (listViewScrollY < 0) {
                listViewScrollY = 0;
            }
            hongBaoPendantHolder.P = -listViewScrollY;
            if (hongBaoPendantHolder.b(canvas)) {
                invalidate();
            }
        }
    }

    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            if (this.E) {
                return;
            }
            this.f384569a0.removeMessages(1);
            this.f384569a0.removeMessages(2);
            setIsShowingPreguide(false);
        }
    }

    public void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.D) {
            if (this.W) {
                OverScroller.BOUNCE_DURANTION = 300;
                return;
            } else {
                OverScroller.BOUNCE_DURANTION = 600;
                return;
            }
        }
        OverScroller.BOUNCE_DURANTION = 400;
    }

    @Override // com.tencent.widget.ListView
    public int getListViewScrollY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null) {
            return getScrollY();
        }
        int firstVisiblePosition = getFirstVisiblePosition();
        if (firstVisiblePosition >= this.mHeaderViewInfos.size()) {
            Iterator<ListView.FixedViewInfo> it = this.mHeaderViewInfos.iterator();
            while (it.hasNext()) {
                i3 += it.next().view.getHeight();
            }
            return i3 + (-childAt.getTop()) + ((firstVisiblePosition - this.mHeaderViewInfos.size()) * childAt.getHeight());
        }
        int i16 = 0;
        while (i3 < firstVisiblePosition) {
            i16 += this.mHeaderViewInfos.get(i3).view.getHeight();
            i3++;
        }
        return (-childAt.getTop()) + i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView
    public int getSpringbackOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        if (this.D && !this.E) {
            return super.getSpringbackOffset();
        }
        return super.getSpringbackOffset();
    }

    @Override // com.tencent.widget.ListView
    public boolean isOverscrollHeadVisiable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        if (this.D) {
            if (getScrollY() < 0) {
                return true;
            }
            return false;
        }
        return super.isOverscrollHeadVisiable();
    }

    @Override // com.tencent.widget.SwipListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        HongBaoPendantHolder hongBaoPendantHolder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.G && !this.E) {
            ConversationHongBaoV2 conversationHongBaoV2 = this.C;
            if (conversationHongBaoV2 != null && !conversationHongBaoV2.L) {
                return true;
            }
            if ((motionEvent.getAction() & 255) == 0) {
                this.J[0] = motionEvent.getY();
                this.I[0] = true;
                if (this.P && (hongBaoPendantHolder = this.S) != null && hongBaoPendantHolder.k().contains(motionEvent.getX(), motionEvent.getY())) {
                    if (getScrollY() == 0) {
                        this.N = true;
                    }
                    super.onInterceptTouchEvent(motionEvent);
                    if (QLog.isColorLevel()) {
                        QLog.d("HongBaoListView", 2, "2021_UI_ConversationHongBaoV2 HongBaoListView onInterceptTouchEvent return true, mComboListener = " + ((Object) null));
                    }
                    return true;
                }
                this.N = false;
                e0();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.View
    public void onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        try {
            super.onOverScrolled(i3, i16, z16, z17);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    @Override // com.tencent.widget.SwipListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (this.P && this.N && action == 1) {
            c0(motionEvent);
        }
        if (this.D && !this.E) {
            ConversationHongBaoV2 conversationHongBaoV2 = this.C;
            if (conversationHongBaoV2 != null && !conversationHongBaoV2.L) {
                return true;
            }
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            if (action != 5) {
                                if (action == 6) {
                                    this.I[motionEvent.getActionIndex()] = false;
                                }
                            } else {
                                int actionIndex = motionEvent.getActionIndex();
                                this.J[actionIndex] = (int) motionEvent.getY(actionIndex);
                                this.I[actionIndex] = true;
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("HongBaoListView", 2, "2021_UI_ConversationHongBaoV2 HongBaoListView ACTION_CANCEL mComboListener = " + ((Object) null));
                            }
                            this.H = -1;
                            this.N = false;
                        }
                    } else {
                        motionEvent.findPointerIndex(this.H);
                    }
                } else {
                    this.H = -1;
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("HongBaoListView", 2, "2021_UI_ConversationHongBaoV2 HongBaoListView ACTION_DOWN mComboListener = " + ((Object) null));
            }
            return onTouchEvent;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.AbsListView
    public void onTouchUpWithYVelocity(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) view, i3);
            return;
        }
        super.onVisibilityChanged(view, i3);
        if (this.V) {
            this.V = false;
        }
    }

    public void setComboListener(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) fVar);
        }
    }

    @Override // com.tencent.widget.ListView
    public void setContentBackground(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
            return;
        }
        if (drawable != null) {
            this.f384571h = drawable;
        }
        if (this.mForHongBao) {
            super.setContentBackground(drawable, false);
        } else {
            super.setContentBackground(drawable);
        }
    }

    public void setHongBaoModeListScrollHeader(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) view);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HongBaoListView", 2, "setHongBaoModeListScrollHeader view = " + view);
        }
        this.R = view;
    }

    public void setIsShowingPreguide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        } else {
            this.W = z16;
            f0();
        }
    }

    @Override // com.tencent.widget.ListView
    public void setOverScrollHeader(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            this.f384573m = view;
        }
        if (this.mForHongBao) {
            super.setOverScrollHeader(null);
        } else {
            super.setOverScrollHeader(view);
        }
    }

    @Override // com.tencent.widget.ListView
    public void setOverScrollListener(OverScrollViewListener overScrollViewListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) overScrollViewListener);
            return;
        }
        if (overScrollViewListener != null) {
            this.f384570f = overScrollViewListener;
        }
        if (this.mForHongBao) {
            super.setOverScrollListener(null);
        } else {
            super.setOverScrollListener(overScrollViewListener);
        }
    }

    @Override // com.tencent.widget.ListView
    public void setOverscrollHeader(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawable);
            return;
        }
        if (drawable != null) {
            this.f384572i = drawable;
        }
        if (this.mForHongBao) {
            super.setOverscrollHeader(null);
        } else {
            super.setOverscrollHeader(drawable);
        }
    }

    public void setOverscrollHeaderShadowEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else if (z16) {
            this.mOverScrollHeaderShadow = getResources().getDrawable(R.drawable.csv);
        } else {
            this.mOverScrollHeaderShadow = null;
        }
    }

    public void setPendantListener(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) iVar);
        } else {
            this.L = iVar;
        }
    }

    public void setSpringbackOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.M = i3;
        }
    }

    public HongBaoListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.C = null;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = -1;
        this.I = new boolean[10];
        this.J = new float[10];
        this.K = 1;
        this.L = null;
        this.N = false;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.f384569a0 = new Handler(Looper.getMainLooper(), new a());
    }
}
