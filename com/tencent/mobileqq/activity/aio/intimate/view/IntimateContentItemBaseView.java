package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Deprecated
/* loaded from: classes10.dex */
public abstract class IntimateContentItemBaseView extends RelativeLayout implements View.OnClickListener, View.OnTouchListener {
    protected int C;
    protected boolean D;
    private long E;

    /* renamed from: d, reason: collision with root package name */
    protected Context f179219d;

    /* renamed from: e, reason: collision with root package name */
    protected String f179220e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f179221f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f179222h;

    /* renamed from: i, reason: collision with root package name */
    protected IntimateInfo f179223i;

    /* renamed from: m, reason: collision with root package name */
    protected int f179224m;

    public IntimateContentItemBaseView(Context context) {
        this(context, null);
    }

    protected abstract boolean a();

    protected abstract void b();

    protected abstract void c(View view);

    protected abstract void i(IntimateInfo intimateInfo, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public QQAppInterface j() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            return null;
        }
        return (QQAppInterface) peekAppRuntime;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String k() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        return peekAppRuntime.getCurrentAccountUin();
    }

    public void l() {
        if (this.D) {
            return;
        }
        this.D = true;
        b();
    }

    public void m() {
        this.f179221f = false;
        d();
    }

    public void n() {
        this.f179221f = false;
        this.f179222h = false;
        e();
    }

    public void o() {
        this.f179221f = true;
        this.f179222h = true;
        f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.E >= 500) {
            this.E = elapsedRealtime;
            c(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
    
        if (r4 != 3) goto L11;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                view.performClick();
            }
            view.setAlpha(1.0f);
        } else {
            view.setAlpha(0.5f);
        }
        return true;
    }

    public void p() {
        this.f179221f = false;
        g();
    }

    public void q() {
        if (QLog.isColorLevel()) {
            QLog.i("IntimateContentItemBaseView", 2, "onResumed isOpened:" + this.f179222h);
        }
        if (!this.f179222h) {
            return;
        }
        this.f179221f = true;
        h();
    }

    public void r(IntimateInfo intimateInfo, int i3) {
        this.f179223i = intimateInfo;
        this.f179224m = i3;
        if (!a()) {
            setVisibility(8);
            return;
        }
        if (!this.D) {
            l();
        }
        setVisibility(0);
        i(intimateInfo, i3);
    }

    public void setCurrentShowType(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("IntimateContentItemBaseView", 2, "setCurrentShowType showType: " + i3 + "  old:" + this.C);
        }
        this.C = i3;
    }

    public void setFriendUin(String str) {
        this.f179220e = str;
    }

    public IntimateContentItemBaseView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IntimateContentItemBaseView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f179220e = "";
        this.f179221f = false;
        this.f179222h = false;
        this.D = false;
        this.f179219d = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
    }

    protected void g() {
    }

    protected void h() {
    }
}
