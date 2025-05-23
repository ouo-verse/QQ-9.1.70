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
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qqcircle.adapter.am;
import com.tencent.biz.qqcircle.immersive.manager.b;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.utils.s;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReporter;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSReportInfoFloatingWindow implements View.OnClickListener, QCircleReporter.QCircleReportListener {
    private Button C;
    private Button D;
    private Button E;
    private Button F;
    private RecyclerView G;
    private am H;
    private int I;
    private int J;
    private int K;
    private int L;
    private final List<String> M = new ArrayList();
    private boolean N = true;

    /* renamed from: d, reason: collision with root package name */
    private WindowManager f84342d;

    /* renamed from: e, reason: collision with root package name */
    private WindowManager.LayoutParams f84343e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f84344f;

    /* renamed from: h, reason: collision with root package name */
    private final Context f84345h;

    /* renamed from: i, reason: collision with root package name */
    private View f84346i;

    /* renamed from: m, reason: collision with root package name */
    private Button f84347m;

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
                    int rawX = ((int) motionEvent.getRawX()) - QFSReportInfoFloatingWindow.this.I;
                    int rawY = ((int) motionEvent.getRawY()) - QFSReportInfoFloatingWindow.this.J;
                    QFSReportInfoFloatingWindow.this.f84343e.x = QFSReportInfoFloatingWindow.this.K + rawX;
                    QFSReportInfoFloatingWindow.this.f84343e.y = QFSReportInfoFloatingWindow.this.L + rawY;
                    QFSReportInfoFloatingWindow.this.f84342d.updateViewLayout(QFSReportInfoFloatingWindow.this.f84346i, QFSReportInfoFloatingWindow.this.f84343e);
                    return true;
                }
                return true;
            }
            QFSReportInfoFloatingWindow.this.I = (int) motionEvent.getRawX();
            QFSReportInfoFloatingWindow.this.J = (int) motionEvent.getRawY();
            QFSReportInfoFloatingWindow qFSReportInfoFloatingWindow = QFSReportInfoFloatingWindow.this;
            qFSReportInfoFloatingWindow.K = qFSReportInfoFloatingWindow.f84343e.x;
            QFSReportInfoFloatingWindow qFSReportInfoFloatingWindow2 = QFSReportInfoFloatingWindow.this;
            qFSReportInfoFloatingWindow2.L = qFSReportInfoFloatingWindow2.f84343e.y;
            return true;
        }
    }

    public QFSReportInfoFloatingWindow(Context context) {
        this.f84345h = context.getApplicationContext();
        o(context);
        v(context);
    }

    private void n(String str) {
        if (this.M.size() >= 500) {
            this.M.clear();
        }
        this.M.add(str);
    }

    private void o(Context context) {
        this.f84342d = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f84343e = layoutParams;
        layoutParams.width = DisplayUtil.dip2px(context, 300.0f);
        WindowManager.LayoutParams layoutParams2 = this.f84343e;
        layoutParams2.height = -2;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams2.type = 2038;
        } else {
            layoutParams2.type = 2;
        }
        layoutParams2.flags = 40;
        layoutParams2.format = -3;
        layoutParams2.gravity = 8388659;
        layoutParams2.y = DisplayUtil.dip2px(context, 80.0f);
        this.f84343e.x = DisplayUtil.dip2px(context, 0.0f);
    }

    private View.OnTouchListener p() {
        return new a();
    }

    private void q() {
        if (this.M.size() == 0) {
            return;
        }
        this.M.clear();
        this.H.clearData();
        w();
    }

    private void r() {
        if (this.M.size() == 0) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = this.M.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
        }
        s.a(this.G.getContext(), sb5.toString());
        QCircleToast.o(h.a(R.string.f189313z2), 0);
    }

    private void s() {
        if (this.N) {
            this.G.setVisibility(8);
            this.N = false;
        } else {
            this.G.setVisibility(0);
            this.N = true;
        }
    }

    private void t(final String str, final String str2) {
        RecyclerView recyclerView = this.G;
        if (recyclerView == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.tencent.biz.qqcircle.debug.report.QFSReportInfoFloatingWindow.2
            @Override // java.lang.Runnable
            public void run() {
                if (QFSReportInfoFloatingWindow.this.H == null) {
                    return;
                }
                QFSReportInfoFloatingWindow.this.H.k0(str, str2);
                QFSReportInfoFloatingWindow.this.w();
            }
        });
    }

    private void u() {
        if (this.G == null) {
            return;
        }
        this.G.setLayoutManager(new b(this.f84345h, 1, false));
        am amVar = new am();
        this.H = amVar;
        this.G.setAdapter(amVar);
    }

    private void v(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.gqh, (ViewGroup) null, false);
        this.f84346i = inflate;
        this.f84347m = (Button) inflate.findViewById(R.id.f521129x);
        this.C = (Button) this.f84346i.findViewById(R.id.f521029w);
        this.D = (Button) this.f84346i.findViewById(R.id.f521229y);
        this.G = (RecyclerView) this.f84346i.findViewById(R.id.f52172_3);
        this.E = (Button) this.f84346i.findViewById(R.id.f52152_1);
        this.F = (Button) this.f84346i.findViewById(R.id.f52142_0);
        this.f84347m.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.F.setOnTouchListener(p());
        u();
        QLog.d("QFSReportInfoFloatingWindow", 1, "Report info board init.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        RecyclerView recyclerView = this.G;
        if (recyclerView != null && this.H != null) {
            if (recyclerView.getScrollState() == 0 || !this.G.isComputingLayout()) {
                this.H.notifyDataSetChanged();
                this.G.smoothScrollToPosition(this.H.getItemCount());
            }
        }
    }

    private String x(int i3, List<FeedCloudCommon$Entry> list, boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("dcId:");
        sb5.append(i3);
        sb5.append(", ");
        if (z16) {
            sb5.append(y(list));
            return sb5.toString();
        }
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            sb5.append(feedCloudCommon$Entry.key.get());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(feedCloudCommon$Entry.value.get());
            sb5.append(", \n");
        }
        sb5.append("\n");
        return sb5.toString();
    }

    private String y(List<FeedCloudCommon$Entry> list) {
        StringBuilder sb5 = new StringBuilder();
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            if (feedCloudCommon$Entry.key.get().equals("actiontype") || feedCloudCommon$Entry.key.get().equals("subactiontype")) {
                sb5.append(feedCloudCommon$Entry.key.get());
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(feedCloudCommon$Entry.value.get());
                sb5.append(", ");
            }
        }
        sb5.append("\n");
        return sb5.toString();
    }

    public void A() {
        if (!HostAppSettingUtil.isDebugVersion()) {
            return;
        }
        if (this.f84344f) {
            QLog.d("QFSReportInfoFloatingWindow", 1, "is showing");
            return;
        }
        this.f84344f = true;
        try {
            WindowManager windowManager = this.f84342d;
            if (windowManager == null) {
                return;
            }
            windowManager.addView(this.f84346i, this.f84343e);
            QCircleReporter.getInstance().addReportListener(this);
        } catch (Throwable th5) {
            QLog.e("QFSReportInfoFloatingWindow", 1, "show error: " + th5);
        }
    }

    @Override // cooperation.qqcircle.report.QCircleReporter.QCircleReportListener
    public void onAddReportData(int i3, List<FeedCloudCommon$Entry> list) {
        if (i3 == 5507 || i3 == 5504 || i3 == 5501) {
            String x16 = x(i3, list, true);
            String x17 = x(i3, list, false);
            n(x17);
            t(x16, x17);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f521029w) {
            q();
        } else if (id5 == R.id.f521229y) {
            r();
        } else if (id5 == R.id.f52152_1) {
            s();
        } else if (id5 == R.id.f521129x) {
            z();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void z() {
        if (!this.f84344f) {
            return;
        }
        this.f84344f = false;
        if (this.f84342d == null) {
            return;
        }
        QCircleReporter.getInstance().removeReportListener(this);
        this.f84342d.removeView(this.f84346i);
    }
}
