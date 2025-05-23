package com.tencent.mtt.hippy.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.a.c;
import com.tencent.mtt.hippy.a.p;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes20.dex */
public class l implements View.OnClickListener, c.a, n, p.a {

    /* renamed from: a, reason: collision with root package name */
    final k f336979a;

    /* renamed from: b, reason: collision with root package name */
    h f336980b;

    /* renamed from: c, reason: collision with root package name */
    ProgressDialog f336981c;

    /* renamed from: d, reason: collision with root package name */
    c f336982d;

    /* renamed from: e, reason: collision with root package name */
    private final i f336983e;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<Context, e> f336984f;

    /* renamed from: g, reason: collision with root package name */
    private final Stack<e> f336985g;

    /* renamed from: h, reason: collision with root package name */
    private final p f336986h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(HippyGlobalConfigs hippyGlobalConfigs, String str, String str2, String str3) {
        k kVar = new k(hippyGlobalConfigs, str, str3);
        this.f336979a = kVar;
        this.f336983e = new i(str, str2);
        this.f336985g = new Stack<>();
        this.f336984f = new HashMap<>();
        this.f336986h = new p(kVar);
        e();
    }

    private void e() {
        Context context;
        if (this.f336985g.size() > 0) {
            context = this.f336985g.peek().getContext();
        } else {
            context = null;
        }
        if (context == null) {
            return;
        }
        if (this.f336981c == null) {
            ReportProgressDialog reportProgressDialog = new ReportProgressDialog(context);
            this.f336981c = reportProgressDialog;
            reportProgressDialog.setCancelable(true);
            this.f336981c.setProgressStyle(0);
        }
        this.f336981c.show();
    }

    @Override // com.tencent.mtt.hippy.a.n
    public String a(String str) {
        return this.f336979a.a(this.f336983e.a(), str, this.f336983e.c(), false, false);
    }

    @Override // com.tencent.mtt.hippy.a.n
    public void b() {
        h hVar = this.f336980b;
        if (hVar != null) {
            hVar.onDevBundleReLoad();
        }
    }

    @Override // com.tencent.mtt.hippy.a.p.a
    public void c() {
        b();
    }

    @Override // com.tencent.mtt.hippy.a.p.a
    public void d() {
        b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f336983e.d();
        if (view.getContext() instanceof Application) {
            LogUtils.e("DevServerImpl", "Hippy context is an Application, so can not show a dialog!");
        } else {
            new AlertDialog.Builder(view.getContext()).setItems(new String[]{"Reload"}, new DialogInterface.OnClickListener() { // from class: com.tencent.mtt.hippy.a.l.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    if (i3 == 0) {
                        l.this.b();
                    }
                }
            }).show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mtt.hippy.a.n
    public String a(String str, String str2, String str3) {
        k kVar = this.f336979a;
        if (TextUtils.isEmpty(str3)) {
            str3 = this.f336983e.b();
        }
        return kVar.a(str, str3, str2);
    }

    @Override // com.tencent.mtt.hippy.a.n
    public void b(HippyRootView hippyRootView) {
        LogUtils.d("DevServerImpl", "hippy DevServerImpl detachFromHost");
        Context host = hippyRootView.getHost();
        e eVar = this.f336984f.get(host);
        if (eVar != null) {
            this.f336985g.remove(eVar);
            this.f336984f.remove(host);
            ViewParent parent = eVar.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(eVar);
            }
        }
    }

    @Override // com.tencent.mtt.hippy.a.c.a
    public void a() {
        b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.ViewGroup] */
    @Override // com.tencent.mtt.hippy.a.n
    public void a(HippyRootView hippyRootView) {
        LogUtils.d("DevServerImpl", "hippy DevServerImpl attachToHost");
        Context host = hippyRootView.getHost();
        e eVar = new e(host);
        eVar.setOnClickListener(this);
        HippyRootView hippyRootView2 = hippyRootView;
        if (host instanceof Activity) {
            hippyRootView2 = (ViewGroup) ((Activity) host).getWindow().getDecorView();
        }
        hippyRootView2.addView(eVar);
        this.f336984f.put(host, eVar);
        this.f336985g.push(eVar);
    }

    @Override // com.tencent.mtt.hippy.a.n
    public void a(h hVar) {
        this.f336980b = hVar;
    }

    @Override // com.tencent.mtt.hippy.a.n
    public void a(String str, final h hVar) {
        this.f336979a.a(new a() { // from class: com.tencent.mtt.hippy.a.l.2
            @Override // com.tencent.mtt.hippy.a.a
            public void a(InputStream inputStream) {
                ProgressDialog progressDialog = l.this.f336981c;
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                h hVar2 = hVar;
                if (hVar2 != null) {
                    hVar2.onDevBundleLoadReady(inputStream);
                }
            }

            @Override // com.tencent.mtt.hippy.a.a
            public void a(Exception exc) {
                h hVar2 = hVar;
                if (hVar2 != null) {
                    hVar2.onInitDevError(exc);
                }
                if (l.this.f336985g.isEmpty()) {
                    l.this.f336980b.onInitDevError(exc);
                } else {
                    l.this.a(exc);
                }
            }
        }, str);
    }

    @Override // com.tencent.mtt.hippy.a.n
    public void a(final Throwable th5) {
        ProgressDialog progressDialog = this.f336981c;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        if (this.f336985g.size() <= 0) {
            return;
        }
        c cVar = this.f336982d;
        if (cVar == null || !cVar.isShowing()) {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mtt.hippy.a.l.3
                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.f336985g.size() > 0) {
                        l.this.f336982d = new c(((e) l.this.f336985g.peek()).getContext());
                        l.this.f336982d.a(th5);
                        l lVar = l.this;
                        lVar.f336982d.a(lVar);
                        l.this.f336982d.show();
                    }
                }
            });
        }
    }
}
