package com.tencent.mobileqq.activity.aio.confess;

import a61.c;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.j;

/* loaded from: classes10.dex */
public class ConfessPanel extends RelativeLayout implements View.OnClickListener, View.OnLongClickListener, j {
    public static int D = -1;
    public static final int E;
    public static int F;
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private boolean f178338d;

    /* renamed from: e, reason: collision with root package name */
    private int f178339e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f178340f;

    /* renamed from: h, reason: collision with root package name */
    private c f178341h;

    /* renamed from: i, reason: collision with root package name */
    private int f178342i;

    /* renamed from: m, reason: collision with root package name */
    private int f178343m;

    static {
        int i3 = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().widthPixels;
        E = d(i3);
        F = i3;
    }

    public ConfessPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178338d = false;
        this.f178340f = false;
        this.C = false;
    }

    private void b(c cVar, int i3) {
        if (cVar == null) {
            return;
        }
        this.f178342i = f(cVar);
        this.f178343m = c(getResources(), i3, this.f178342i) - this.f178342i;
    }

    public static int c(Resources resources, int i3, int i16) {
        int i17 = i3 + i16;
        int i18 = resources.getDisplayMetrics().heightPixels;
        if (i17 > i18 || i17 > i18 * 0.6f) {
            i17 = (int) (i18 * 0.6f);
        }
        int i19 = XPanelContainer.f384715i0;
        if (i17 < i19 + i16) {
            i17 = i19 + i16;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ConfessPanel", 2, String.format("adjustPanelHeight [maxPanelH,toolbarH,screenH,ExternalH,dstHeight]=[%d,%d,%d,%d,%d]", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i18), Integer.valueOf(XPanelContainer.f384715i0), Integer.valueOf(i17)));
        }
        return i17;
    }

    public static int d(int i3) {
        return (int) ((i3 * 1.0f) / 1.1329305f);
    }

    public static int f(c cVar) {
        InputLinearLayout inputLinearLayout = cVar.f25586k;
        int i3 = 0;
        if (inputLinearLayout != null) {
            i3 = 0 + inputLinearLayout.getHeight();
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConfessPanel", 2, "getToolbarHeight =" + i3);
        }
        return i3;
    }

    @Override // com.tencent.widget.j
    public int a() {
        this.f178339e = e();
        QLog.d("ConfessPanel", 2, "getDefaultExternalPanelheight , orginal:" + XPanelContainer.f384714h0 + " return:" + this.f178339e);
        return this.f178339e;
    }

    public int e() {
        int width;
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        if (baseApplicationImpl != null && baseApplicationImpl.getResources() != null) {
            Object parent = getParent();
            if ((parent instanceof View) && F != (width = ((View) parent).getWidth()) && width > 0) {
                F = width;
                QLog.d("ConfessPanel", 2, "getPanelHeight , sLastScreenWidth:" + F + " winwidth:" + width);
                int d16 = d(width);
                b(this.f178341h, d16);
                QLog.d("ConfessPanel", 2, "getPanelHeight , sLastScreenWidth:" + F + " winwidth:" + width + " nWinHeight:" + d16);
                return this.f178343m;
            }
        }
        QLog.d("ConfessPanel", 2, "getPanelHeight , use max height:" + this.f178343m);
        return this.f178343m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f178338d) {
            if (XPanelContainer.f384714h0 == this.f178339e) {
                XPanelContainer.f384714h0 = D;
            }
            QLog.d("ConfessPanel", 2, "onDetachedFromWindow, set mExternalPanelheight :" + XPanelContainer.f384714h0);
        }
        this.f178338d = false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        EventCollector.getInstance().onViewLongClicked(view);
        return false;
    }

    public ConfessPanel(Context context) {
        super(context);
        this.f178338d = false;
        this.f178340f = false;
        this.C = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
