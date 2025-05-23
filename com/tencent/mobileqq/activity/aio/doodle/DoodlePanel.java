package com.tencent.mobileqq.activity.aio.doodle;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker;
import com.tencent.mobileqq.doodle.IDoodleXPanelContainer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public class DoodlePanel extends BaseDoodlePanel implements View.OnClickListener, View.OnLongClickListener, com.tencent.widget.j {
    public static int H;
    public static final int I;
    private boolean C;
    private a61.b D;
    private int E;
    private long F;
    private ProgressDialog G;

    /* renamed from: d, reason: collision with root package name */
    private Button f178398d;

    /* renamed from: e, reason: collision with root package name */
    private GifTemplatePicker f178399e;

    /* renamed from: f, reason: collision with root package name */
    private Button f178400f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f178401h;

    /* renamed from: i, reason: collision with root package name */
    protected DoodleLayout f178402i;

    /* renamed from: m, reason: collision with root package name */
    public AppRuntime f178403m;

    /* loaded from: classes10.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                DoodleLayout doodleLayout = DoodlePanel.this.f178402i;
                if (doodleLayout != null) {
                    doodleLayout.c(false, false);
                }
                DoodlePanel.this.e();
            }
        }
    }

    static {
        Resources resources = BaseApplication.getContext().getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        I = ((int) ((Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) * 1.0f) / 1.1329305f)) + Utils.n(81.0f, resources);
        H = -1;
    }

    public DoodlePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178401h = false;
        this.C = false;
        this.F = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        boolean z16;
        DoodleLayout doodleLayout = this.f178402i;
        if (doodleLayout != null) {
            boolean z17 = false;
            int e16 = doodleLayout.e(false, false);
            Button button = this.f178398d;
            if (button != null) {
                if (e16 > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                button.setEnabled(z16);
            }
            Button button2 = this.f178400f;
            if (button2 != null) {
                if (e16 > 0) {
                    z17 = true;
                }
                button2.setEnabled(z17);
            }
        }
    }

    private boolean g() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.F < 500) {
            QLog.d("Scribble", 2, " send click is invalid, lasttime:" + this.F + " currenttime:" + currentTimeMillis);
            return false;
        }
        this.F = currentTimeMillis;
        QLog.d("Scribble", 2, " send click is valid, lasttime:" + this.F);
        return true;
    }

    @Override // com.tencent.widget.j
    public int a() {
        this.E = f();
        QLog.d("Scribble", 2, "getDefaultExternalPanelheight , orginal:" + ((IDoodleXPanelContainer) QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight() + " return:" + this.E);
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (QLog.isColorLevel()) {
            QLog.d("Scribble", 2, "cancelProgressDialog " + System.currentTimeMillis());
        }
        ProgressDialog progressDialog = this.G;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.G.cancel();
        }
    }

    public int f() {
        int width;
        Resources resources = BaseApplication.getContext().getResources();
        if (resources != null) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            Object parent = getParent();
            if ((parent instanceof View) && min != (width = ((View) parent).getWidth()) && width > 0) {
                QLog.d("Scribble", 2, "getPanelHeight , disWidth:" + min + " winwidth:" + width);
                int n3 = ((int) ((((float) width) * 1.0f) / 1.1329305f)) + Utils.n(81.0f, resources);
                QLog.d("Scribble", 2, "getPanelHeight , disWidth:" + min + " winwidth:" + width + " nWinHeight:" + n3);
                return n3;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getPanelHeight , use max height:");
        int i3 = I;
        sb5.append(i3);
        QLog.d("Scribble", 2, sb5.toString());
        return i3;
    }

    public void h() {
        DoodleLayout doodleLayout = this.f178402i;
        if (doodleLayout != null) {
            doodleLayout.c(true, true);
        }
        GifTemplatePicker gifTemplatePicker = this.f178399e;
        if (gifTemplatePicker != null) {
            gifTemplatePicker.e(gifTemplatePicker.i(), false);
        }
        e();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.dyq) {
            DoodleLayout doodleLayout = this.f178402i;
            if (doodleLayout != null) {
                doodleLayout.i();
            }
            e();
            ReportController.o(this.f178403m, "dc00898", "", "", "0X80081B6", "0X80081B6", 1, 0, "", "", "", "");
        } else if (id5 == R.id.ajw && !g()) {
            QLog.d("Scribble", 2, " onsend error, invalid click, return");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.C) {
            if (((IDoodleXPanelContainer) QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight() == this.E) {
                ((IDoodleXPanelContainer) QRoute.api(IDoodleXPanelContainer.class)).setExternalPanelheight(H);
            }
            QLog.d("Scribble", 2, "onDetachedFromWindow, set mExternalPanelheight :" + ((IDoodleXPanelContainer) QRoute.api(IDoodleXPanelContainer.class)).getExternalPanelheight());
        }
        this.C = false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        if (view.getId() == R.id.dyq) {
            a aVar = new a();
            DialogUtil.createCustomDialog(getContext(), 230, (String) null, getContext().getString(R.string.f170212j0), getContext().getString(R.string.f170210iy), getContext().getString(R.string.f170211iz), aVar, aVar).show();
        }
        ReportController.o(this.f178403m, "dc00898", "", "", "0X80081B7", "0X80081B7", 1, 0, "", "", "", "");
        EventCollector.getInstance().onViewLongClicked(view);
        return true;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
    }

    public DoodlePanel(Context context) {
        this(context, null);
    }
}
