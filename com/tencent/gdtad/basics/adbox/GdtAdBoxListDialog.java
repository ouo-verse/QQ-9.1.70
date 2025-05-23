package com.tencent.gdtad.basics.adbox;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtAdBoxListDialog extends ReportDialog implements j {
    protected Activity C;
    protected com.tencent.gdtad.basics.adbox.a D;
    protected h E;
    protected g F;
    private ListView G;
    private f H;
    private View I;
    private volatile boolean J;
    private final boolean K;
    private final GdtAdBoxValidExpoReportHelper L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (GdtAdBoxListDialog.this.H != null && GdtAdBoxListDialog.this.L != null) {
                GdtAdBoxListDialog.this.H.a();
                GdtAdBoxListDialog.this.L.n(false);
                if (GdtAdBoxListDialog.this.K) {
                    GdtAdBoxListDialog.this.C.setRequestedOrientation(0);
                    return;
                }
                return;
            }
            QLog.e("GdtAdBoxListDialog", 1, "onDismiss mGdtAdBoxListAdapter is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GdtAdBoxListDialog.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.gdtad.basics.adbox.a aVar;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GdtAdBoxListDialog.this.J && (aVar = GdtAdBoxListDialog.this.D) != null && aVar.a() != null) {
                GdtAdBoxListDialog.this.D.a().onRefresh();
                GdtAdBoxListDialog.this.J = false;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public GdtAdBoxListDialog(@NonNull Context context) {
        super(context, R.style.avn);
        this.J = true;
        this.C = (Activity) context;
        this.L = new GdtAdBoxValidExpoReportHelper(new WeakReference(this.C));
        this.K = this.C.getResources().getConfiguration().orientation == 2;
    }

    private void W(g gVar) {
        GdtLog.d("GdtAdBoxListDialog", "bindData() called with: model = [" + gVar + "]");
        com.tencent.gdtad.basics.adbox.a aVar = this.D;
        if (aVar != null && aVar.c() != null) {
            int size = this.D.c().getAds().size();
            if (size == 0) {
                GdtLog.d("GdtAdBoxListDialog", "bindData() called with: total = [" + size + "]");
                this.I.post(new Runnable() { // from class: com.tencent.gdtad.basics.adbox.GdtAdBoxListDialog.4
                    @Override // java.lang.Runnable
                    public void run() {
                        GdtAdBoxListDialog.this.Z();
                    }
                });
                return;
            }
            if (size > 9) {
                size = 9;
            }
            List<GdtAd> ads = this.D.c().getAds();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar = new e(ads.get(i3));
                if (eVar.b()) {
                    arrayList.add(eVar);
                }
            }
            if (arrayList.isEmpty()) {
                QLog.e("GdtAdBoxListDialog", 1, "load valid ads is empty");
                this.I.post(new Runnable() { // from class: com.tencent.gdtad.basics.adbox.GdtAdBoxListDialog.5
                    @Override // java.lang.Runnable
                    public void run() {
                        GdtAdBoxListDialog.this.Z();
                    }
                });
                return;
            }
            f fVar = new f(this.C);
            this.H = fVar;
            fVar.d(arrayList, this.E, this.D);
            this.G.setAdapter((ListAdapter) this.H);
            this.L.m(arrayList);
            this.L.g(this.G);
            this.G.setOnScrollListener(new d());
        }
    }

    private void X() {
        g gVar = new g();
        this.F = gVar;
        h hVar = new h(this, gVar);
        this.E = hVar;
        hVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        new GdtAdBoxNoMoreDialog(this.C).show();
        this.J = true;
    }

    private void initView() {
        Window window = getWindow();
        window.requestFeature(1);
        FrameLayout frameLayout = (FrameLayout) window.getDecorView();
        View inflate = getLayoutInflater().inflate(R.layout.ech, (ViewGroup) frameLayout, false);
        this.I = inflate;
        setContentView(inflate);
        this.G = (ListView) frameLayout.findViewById(R.id.yvk);
        setOnDismissListener(new a());
        View findViewById = findViewById(R.id.dum);
        findViewById.setOnClickListener(new b());
        findViewById.setContentDescription(HardCodeUtil.qqStr(R.string.yjt));
        setCanceledOnTouchOutside(false);
        ((RelativeLayout) findViewById(R.id.f75373ys)).setOnClickListener(new c());
    }

    @Override // com.tencent.gdtad.basics.adbox.j
    public void L(g gVar) {
        W(gVar);
    }

    public void Y(com.tencent.gdtad.basics.adbox.a aVar) {
        this.D = aVar;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.E.a()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.K) {
            this.C.setRequestedOrientation(1);
        }
        initView();
        X();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        this.E.f();
        f fVar = this.H;
        if (fVar != null) {
            fVar.b();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.E.e();
        f fVar = this.H;
        if (fVar != null) {
            fVar.c();
        }
        if (this.K) {
            this.C.setRequestedOrientation(0);
        }
        this.L.n(false);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        GdtLog.d("GdtAdBoxListDialog", "onWindowFocusChanged() called with: hasFocus = [" + z16 + "]");
    }

    public void refresh() {
        this.C.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.basics.adbox.GdtAdBoxListDialog.7
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("GdtAdBoxListDialog", 1, "refresh");
                com.tencent.gdtad.basics.adbox.a aVar = GdtAdBoxListDialog.this.D;
                if (aVar != null && aVar.c() != null) {
                    List<GdtAd> ads = GdtAdBoxListDialog.this.D.c().getAds();
                    if (ads != null && !ads.isEmpty()) {
                        int size = ads.size();
                        if (size > 9) {
                            size = 9;
                        }
                        ArrayList arrayList = new ArrayList();
                        int i3 = 0;
                        while (i3 < size) {
                            int i16 = i3 + 1;
                            if (ads.size() >= i16) {
                                e eVar = new e(ads.get(i3));
                                if (eVar.b()) {
                                    arrayList.add(eVar);
                                }
                            }
                            i3 = i16;
                        }
                        if (arrayList.isEmpty()) {
                            QLog.e("GdtAdBoxListDialog", 1, "refresh valid ads is empty");
                            GdtAdBoxListDialog.this.Z();
                            return;
                        }
                        if (GdtAdBoxListDialog.this.H != null && GdtAdBoxListDialog.this.L != null) {
                            GdtAdBoxListDialog.this.H.e(arrayList);
                            GdtAdBoxListDialog.this.L.n(true);
                            GdtAdBoxListDialog.this.L.m(arrayList);
                            GdtAdBoxListDialog.this.L.g(GdtAdBoxListDialog.this.G);
                            GdtAdBoxListDialog.this.H.notifyDataSetChanged();
                        }
                        GdtAdBoxListDialog.this.J = true;
                        return;
                    }
                    QLog.e("GdtAdBoxListDialog", 1, "refresh ads is empty");
                    GdtAdBoxListDialog.this.Z();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class d implements AbsListView.OnScrollListener {
        d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
            if (i3 == 0) {
                GdtAdBoxListDialog.this.L.n(false);
                GdtAdBoxListDialog.this.L.g(GdtAdBoxListDialog.this.G);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }
}
