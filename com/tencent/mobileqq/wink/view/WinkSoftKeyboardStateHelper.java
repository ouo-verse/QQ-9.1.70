package com.tencent.mobileqq.wink.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkSoftKeyboardStateHelper implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: d, reason: collision with root package name */
    private final List<a> f326894d;

    /* renamed from: e, reason: collision with root package name */
    private final View f326895e;

    /* renamed from: f, reason: collision with root package name */
    private int f326896f;

    /* renamed from: h, reason: collision with root package name */
    private int f326897h;

    /* renamed from: i, reason: collision with root package name */
    private int f326898i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f326899m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(int i3) {
            WinkSoftKeyboardStateHelper.this.n(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            WinkSoftKeyboardStateHelper.this.l();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(int i3) {
            WinkSoftKeyboardStateHelper.this.m(i3);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3 = ScreenUtil.SCREEN_HIGHT / 4;
            final int j3 = WinkSoftKeyboardStateHelper.this.j();
            if (!WinkSoftKeyboardStateHelper.this.f326899m && j3 >= i3) {
                WinkSoftKeyboardStateHelper.this.f326899m = true;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.ap
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkSoftKeyboardStateHelper.AnonymousClass1.this.d(j3);
                    }
                });
            } else if (WinkSoftKeyboardStateHelper.this.f326899m && j3 < i3) {
                WinkSoftKeyboardStateHelper.this.f326899m = false;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.aq
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkSoftKeyboardStateHelper.AnonymousClass1.this.e();
                    }
                });
            }
            if (j3 != WinkSoftKeyboardStateHelper.this.f326898i) {
                WinkSoftKeyboardStateHelper.this.f326898i = j3;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.ar
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkSoftKeyboardStateHelper.AnonymousClass1.this.f(j3);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void a(int i3);

        void onSoftKeyboardClosed();

        void onSoftKeyboardOpened(int i3);
    }

    public WinkSoftKeyboardStateHelper(View view) {
        this(view, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j() {
        try {
            if (this.f326895e == null) {
                return 0;
            }
            Rect rect = new Rect();
            this.f326895e.getWindowVisibleDisplayFrame(rect);
            if (this.f326896f == 0) {
                this.f326896f = rect.height();
            }
            int i3 = this.f326896f - (rect.bottom - rect.top);
            if (QLog.isDevelopLevel() && QLog.isDebugVersion()) {
                w53.b.a("WinkSoftKeyboardStateHelper", "onGlobalLayout , activityRootView.Height = " + this.f326896f + " heightDiff = " + i3 + " (r.bottom - r.top) = " + (rect.bottom - rect.top));
            }
            return i3;
        } catch (Throwable th5) {
            w53.b.c("WinkSoftKeyboardStateHelper", "getHeightDiff error=" + th5);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        for (a aVar : this.f326894d) {
            if (aVar != null) {
                aVar.onSoftKeyboardClosed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i3) {
        for (a aVar : this.f326894d) {
            if (aVar != null) {
                aVar.a(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i3) {
        this.f326897h = i3;
        for (a aVar : this.f326894d) {
            if (aVar != null) {
                aVar.onSoftKeyboardOpened(i3);
            }
        }
    }

    public void i(a aVar) {
        this.f326894d.add(aVar);
    }

    public boolean k() {
        return this.f326899m;
    }

    public void o() {
        this.f326894d.clear();
        View view = this.f326895e;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (this.f326895e == null) {
            w53.b.c("WinkSoftKeyboardStateHelper", "onGlobalLayout activityRootView is null");
            return;
        }
        try {
            ThreadManagerV2.excute(new AnonymousClass1(), 16, null, true);
        } catch (Throwable th5) {
            QLog.e("WinkSoftKeyboardStateHelper", 1, "onGlobalLayout error=" + th5);
        }
    }

    public WinkSoftKeyboardStateHelper(View view, boolean z16) {
        this.f326894d = new LinkedList();
        this.f326895e = view;
        this.f326899m = z16;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
}
