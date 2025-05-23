package com.tencent.mtt.hippy.dom.node;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.uimanager.h;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f implements h.a {

    /* renamed from: c, reason: collision with root package name */
    private static final int f337410c = ViewConfiguration.getLongPressTimeout();

    /* renamed from: d, reason: collision with root package name */
    private static final int f337411d = ViewConfiguration.getTapTimeout();

    /* renamed from: b, reason: collision with root package name */
    final int f337413b;

    /* renamed from: h, reason: collision with root package name */
    private int f337417h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mtt.hippy.uimanager.h f337418i;

    /* renamed from: j, reason: collision with root package name */
    private Handler f337419j;

    /* renamed from: k, reason: collision with root package name */
    private HippyEngineContext f337420k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f337421l;

    /* renamed from: a, reason: collision with root package name */
    boolean f337412a = false;

    /* renamed from: f, reason: collision with root package name */
    private int f337415f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f337416g = 0;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<String> f337414e = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 3) {
                f.this.f337412a = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i3, boolean z16) {
        this.f337413b = i3;
        this.f337421l = z16;
    }

    public void a(ArrayList<String> arrayList) {
        this.f337414e = arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
    
        if (r11.f337414e.contains(com.tencent.mtt.hippy.dom.node.NodeProps.ON_LONG_CLICK) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006a, code lost:
    
        if (r11.f337414e.contains(com.tencent.mtt.hippy.dom.node.NodeProps.ON_LONG_CLICK) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
    
        if (java.lang.Math.abs(r2 - r11.f337416g) >= android.view.ViewConfiguration.getTouchSlop()) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(View view, MotionEvent motionEvent) {
        if (this.f337420k == null && (view.getContext() instanceof HippyInstanceContext)) {
            this.f337420k = ((HippyInstanceContext) view.getContext()).getEngineContext();
        }
        this.f337417h = view.getId();
        int action = motionEvent.getAction();
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        boolean z16 = false;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3 || action == 4) {
                        Handler handler = this.f337419j;
                        if (handler != null) {
                            handler.removeMessages(3);
                        }
                        if (!this.f337414e.contains(NodeProps.ON_CLICK)) {
                        }
                    }
                } else {
                    if (!this.f337414e.contains(NodeProps.ON_CLICK)) {
                    }
                    if (Math.abs(x16 - this.f337415f) < ViewConfiguration.getTouchSlop()) {
                    }
                }
            } else {
                if ((this.f337414e.contains(NodeProps.ON_CLICK) || this.f337414e.contains(NodeProps.ON_LONG_CLICK)) && Math.abs(x16 - this.f337415f) < ViewConfiguration.getTouchSlop() && Math.abs(y16 - this.f337416g) < ViewConfiguration.getTouchSlop()) {
                    if (this.f337414e.contains(NodeProps.ON_LONG_CLICK) && this.f337412a) {
                        NativeGestureDispatcher.handleLongClick(this.f337420k, this.f337413b);
                    } else {
                        NativeGestureDispatcher.handleClick(view, this.f337420k, this.f337413b, true);
                    }
                    z16 = true;
                }
                Handler handler2 = this.f337419j;
                if (handler2 != null) {
                    handler2.removeMessages(3);
                }
            }
            this.f337415f = x16;
            this.f337416g = y16;
            return z16;
        }
        this.f337412a = false;
        if (this.f337414e.contains(NodeProps.ON_LONG_CLICK)) {
            if (this.f337419j == null) {
                this.f337419j = new a();
            }
            this.f337419j.sendEmptyMessageAtTime(3, motionEvent.getDownTime() + f337411d + f337410c);
        }
        z16 = true;
        this.f337415f = x16;
        this.f337416g = y16;
        return z16;
    }

    @Override // com.tencent.mtt.hippy.uimanager.h.a
    public void handle(String str, float f16, float f17) {
        if (TextUtils.equals(str, NodeProps.ON_PRESS_IN)) {
            NativeGestureDispatcher.handlePressIn(this.f337420k, this.f337413b);
            return;
        }
        if (TextUtils.equals(str, NodeProps.ON_PRESS_OUT)) {
            NativeGestureDispatcher.handlePressOut(this.f337420k, this.f337413b);
            return;
        }
        if (TextUtils.equals(str, NodeProps.ON_TOUCH_DOWN)) {
            NativeGestureDispatcher.handleTouchDown(this.f337420k, this.f337413b, f16, f17, this.f337417h);
            return;
        }
        if (TextUtils.equals(str, "onTouchMove")) {
            NativeGestureDispatcher.handleTouchMove(this.f337420k, this.f337413b, f16, f17, this.f337417h);
        } else if (TextUtils.equals(str, "onTouchEnd")) {
            NativeGestureDispatcher.handleTouchEnd(this.f337420k, this.f337413b, f16, f17, this.f337417h);
        } else if (TextUtils.equals(str, "onTouchCancel")) {
            NativeGestureDispatcher.handleTouchCancel(this.f337420k, this.f337413b, f16, f17, this.f337417h);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.h.a
    public boolean needHandle(String str) {
        ArrayList<String> arrayList = this.f337414e;
        if (arrayList != null) {
            return arrayList.contains(str);
        }
        return false;
    }

    public boolean a() {
        return this.f337421l;
    }

    public boolean a(View view, MotionEvent motionEvent) {
        if (this.f337418i == null) {
            this.f337418i = new com.tencent.mtt.hippy.uimanager.h(this);
        }
        this.f337417h = view.getId();
        return this.f337418i.a(motionEvent);
    }
}
