package com.tencent.mobileqq.bubble;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.m;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ChatXListView extends FPSXListView {
    static IPatchRedirector $redirector_;
    private static int N;
    private static int P;
    private Path C;
    private boolean D;
    private DashPathEffect E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private int J;
    private ArrayList<b> K;
    private boolean L;
    private float M;

    /* renamed from: i, reason: collision with root package name */
    private a61.c f200599i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f200600m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void onLayout(boolean z16, int i3, int i16, int i17, int i18);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface c {
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface d {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71041);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            N = 100;
            P = 100;
        }
    }

    public ChatXListView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void g0(Context context) {
        if (P == N && (context instanceof Activity)) {
            ThreadManagerV2.post(new Runnable(context) { // from class: com.tencent.mobileqq.bubble.ChatXListView.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f200601d;

                {
                    this.f200601d = context;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatXListView.this, (Object) context);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    int height = ((Activity) this.f200601d).getWindowManager().getDefaultDisplay().getHeight();
                    if (height <= 0) {
                        i3 = ChatXListView.N;
                    } else {
                        i3 = height >> 2;
                    }
                    ChatXListView.P = i3;
                    if (QLog.isColorLevel()) {
                        QLog.d("ChatXListView", 2, "ChatXListView open_panel_threshold_value = " + ChatXListView.P);
                    }
                }
            }, 5, null, true);
        }
    }

    private void h0(boolean z16) {
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.d(AdapterView.TAG, 2, "onDisableLayoutChanged() called with: mHasPendingLayout = [" + this.H + "]");
            }
            if (this.H) {
                requestLayout();
            }
        }
    }

    private void i0() {
        if (this.f200599i == null) {
            return;
        }
        int i3 = BaseChatItemLayout.J;
    }

    @Override // com.tencent.widget.XListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) motionEvent)).booleanValue();
        }
        motionEvent.getAction();
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.mobileqq.fpsreport.FPSXListView, com.tencent.widget.XListView, com.tencent.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) canvas);
        } else {
            super.draw(canvas);
        }
    }

    public boolean f0(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    @Override // android.view.View
    public boolean isInEditMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.widget.AdapterView
    public void offsetChildrenTopAndBottomWrap(int i3) {
        a61.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        super.offsetChildrenTopAndBottomWrap(i3);
        if (i3 != 0 && (cVar = this.f200599i) != null) {
            cVar.s(i3);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) accessibilityNodeInfo);
            return;
        }
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        rect.bottom -= this.mListPadding.bottom;
        accessibilityNodeInfo.setBoundsInScreen(rect);
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 2) {
            if (m.f179512b) {
                return false;
            }
            if (f0(motionEvent)) {
                m.f179512b = true;
                return false;
            }
        } else {
            m.f179512b = false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (this.F) {
            this.H = true;
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        i0();
        Iterator<b> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().onLayout(z16, i3, i16, i17, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.XListView, com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (this.F) {
            this.H = true;
            setMeasuredDimension(this.I, this.J);
        } else {
            super.onMeasure(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        a61.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onScrollChanged(i3, i16, i17, i18);
        int i19 = i16 - i18;
        if (i19 != 0 && (cVar = this.f200599i) != null) {
            cVar.s(-i19);
        }
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.AbsListView
    public View retrieveFromScrap(ArrayList<View> arrayList, int i3) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (View) iPatchRedirector.redirect((short) 28, (Object) this, (Object) arrayList, i3);
        }
        int size = arrayList.size();
        if (size > 0) {
            if (this.G) {
                j3 = getItemIdAtPosition(i3);
            } else {
                j3 = -1;
            }
            for (int i16 = 0; i16 < size; i16++) {
                View view = arrayList.get(i16);
                if (((AbsListView.LayoutParams) view.getLayoutParams()).scrappedFromPosition == i3) {
                    arrayList.remove(i16);
                    return view;
                }
                if (this.G) {
                    Object tag = view.getTag(R.id.ttc);
                    if ((tag instanceof Long) && ((Long) tag).longValue() == j3) {
                        arrayList.remove(i16);
                        return view;
                    }
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }

    public void setChatPie(a61.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cVar);
        } else {
            this.f200599i = cVar;
        }
    }

    public void setDisableLayout(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (this.F != z16) {
            this.F = z16;
            this.I = i3;
            this.J = i16;
            h0(z16);
        }
    }

    public void setOnMeasureListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) cVar);
        }
    }

    public void setOnTouchEventConsumer(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
        }
    }

    public void setRetrieveByIdEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.G = z16;
        }
    }

    public void setShouldPlayVideo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.L = z16;
        }
    }

    public void setShowPanelListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        }
    }

    public ChatXListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.listViewStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public ChatXListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f200600m = new Paint(1);
        this.C = new Path();
        this.D = false;
        this.E = new DashPathEffect(new float[]{2.0f, 6.0f}, 0.0f);
        this.K = new ArrayList<>();
        this.L = true;
        this.M = -1.0f;
        g0(context);
    }
}
