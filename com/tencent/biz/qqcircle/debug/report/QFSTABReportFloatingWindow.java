package com.tencent.biz.qqcircle.debug.report;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qqcircle.immersive.manager.b;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qcircle.cooperation.config.debug.e;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSTABReportFloatingWindow implements View.OnClickListener {
    private static boolean P;
    private Button C;
    private Button D;
    private Button E;
    private Button F;
    private RecyclerView G;
    private com.tencent.biz.qqcircle.debug.report.a H;
    private int I;
    private int J;
    private int K;
    private int L;
    private final List<e> M = new ArrayList();
    private boolean N = true;

    /* renamed from: d, reason: collision with root package name */
    private WindowManager f84351d;

    /* renamed from: e, reason: collision with root package name */
    private WindowManager.LayoutParams f84352e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f84353f;

    /* renamed from: h, reason: collision with root package name */
    private View f84354h;

    /* renamed from: i, reason: collision with root package name */
    private Button f84355i;

    /* renamed from: m, reason: collision with root package name */
    private Button f84356m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    int rawX = ((int) motionEvent.getRawX()) - QFSTABReportFloatingWindow.this.I;
                    int rawY = ((int) motionEvent.getRawY()) - QFSTABReportFloatingWindow.this.J;
                    QFSTABReportFloatingWindow.this.f84352e.x = QFSTABReportFloatingWindow.this.K + rawX;
                    QFSTABReportFloatingWindow.this.f84352e.y = QFSTABReportFloatingWindow.this.L + rawY;
                    QFSTABReportFloatingWindow.this.f84351d.updateViewLayout(QFSTABReportFloatingWindow.this.f84354h, QFSTABReportFloatingWindow.this.f84352e);
                    return true;
                }
                return true;
            }
            QFSTABReportFloatingWindow.this.I = (int) motionEvent.getRawX();
            QFSTABReportFloatingWindow.this.J = (int) motionEvent.getRawY();
            QFSTABReportFloatingWindow qFSTABReportFloatingWindow = QFSTABReportFloatingWindow.this;
            qFSTABReportFloatingWindow.K = qFSTABReportFloatingWindow.f84352e.x;
            QFSTABReportFloatingWindow qFSTABReportFloatingWindow2 = QFSTABReportFloatingWindow.this;
            qFSTABReportFloatingWindow2.L = qFSTABReportFloatingWindow2.f84352e.y;
            return true;
        }
    }

    public QFSTABReportFloatingWindow(Context context) {
        this.f84353f = context.getApplicationContext();
        n(context);
        u(context);
    }

    private void n(Context context) {
        this.f84351d = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f84352e = layoutParams;
        layoutParams.width = -1;
        layoutParams.height = -2;
        if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext())) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f84352e.type = 2038;
            } else {
                this.f84352e.type = 2;
            }
        }
        WindowManager.LayoutParams layoutParams2 = this.f84352e;
        layoutParams2.flags = 40;
        layoutParams2.format = -3;
        layoutParams2.gravity = 8388659;
        layoutParams2.y = DisplayUtil.dip2px(context, 80.0f);
        this.f84352e.x = DisplayUtil.dip2px(context, 0.0f);
    }

    private View.OnTouchListener o() {
        return new a();
    }

    private void p(int i3) {
        com.tencent.biz.qqcircle.debug.report.a aVar;
        if (this.M.size() != 0 && (aVar = this.H) != null) {
            aVar.clearData();
            ArrayList arrayList = new ArrayList();
            for (e eVar : this.M) {
                if (eVar.d() == i3) {
                    arrayList.add(eVar);
                }
            }
            r(arrayList);
        }
    }

    private void q() {
        RecyclerView recyclerView = this.G;
        if (recyclerView == null) {
            return;
        }
        if (this.N) {
            recyclerView.setVisibility(8);
            this.N = false;
        } else {
            recyclerView.setVisibility(0);
            this.N = true;
        }
    }

    private void r(final List<e> list) {
        RecyclerView recyclerView = this.G;
        if (recyclerView == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.tencent.biz.qqcircle.debug.report.QFSTABReportFloatingWindow.2
            @Override // java.lang.Runnable
            public void run() {
                if (QFSTABReportFloatingWindow.this.H == null) {
                    return;
                }
                QFSTABReportFloatingWindow.this.H.setData(list);
                QFSTABReportFloatingWindow.this.v();
            }
        });
    }

    private void s() {
        this.f84356m.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.D.setOnTouchListener(o());
    }

    private void t() {
        if (this.G == null) {
            return;
        }
        this.G.setLayoutManager(new b(this.f84353f, 1, false));
        com.tencent.biz.qqcircle.debug.report.a aVar = new com.tencent.biz.qqcircle.debug.report.a();
        this.H = aVar;
        this.G.setAdapter(aVar);
    }

    private void u(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168760gt0, (ViewGroup) null, false);
        this.f84354h = inflate;
        this.f84356m = (Button) inflate.findViewById(R.id.f521129x);
        this.f84355i = (Button) this.f84354h.findViewById(R.id.f521029w);
        this.C = (Button) this.f84354h.findViewById(R.id.f52152_1);
        this.E = (Button) this.f84354h.findViewById(R.id.f520829u);
        this.F = (Button) this.f84354h.findViewById(R.id.f520929v);
        this.G = (RecyclerView) this.f84354h.findViewById(R.id.f52172_3);
        this.D = (Button) this.f84354h.findViewById(R.id.f52142_0);
        s();
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        RecyclerView recyclerView = this.G;
        if (recyclerView != null && this.H != null) {
            if (recyclerView.getScrollState() == 0 || !this.G.isComputingLayout()) {
                this.H.notifyDataSetChanged();
                this.G.smoothScrollToPosition(this.H.getItemCount());
            }
        }
    }

    private void w() {
        if (!P) {
            return;
        }
        P = false;
        WindowManager windowManager = this.f84351d;
        if (windowManager == null) {
            return;
        }
        windowManager.removeView(this.f84354h);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f521129x) {
            w();
        } else if (id5 == R.id.f52152_1) {
            q();
        } else if (id5 == R.id.f520829u) {
            p(1505);
        } else if (id5 == R.id.f520929v) {
            p(PlayerResources.ViewId.EXTENDED_VIEW_LEFT_TOP_CIRCLE);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void x() {
        if (!HostAppSettingUtil.isDebugVersion()) {
            return;
        }
        if (P) {
            QLog.d("QFSTABReportFloatingWindow", 1, "[show] is showing");
            return;
        }
        P = true;
        try {
            WindowManager windowManager = this.f84351d;
            if (windowManager == null) {
                return;
            }
            windowManager.addView(this.f84354h, this.f84352e);
            this.M.clear();
            this.M.addAll(e.f342446e);
            r(this.M);
        } catch (Throwable th5) {
            QLog.e("QFSTABReportFloatingWindow", 1, "[show] show error: " + th5);
        }
    }
}
