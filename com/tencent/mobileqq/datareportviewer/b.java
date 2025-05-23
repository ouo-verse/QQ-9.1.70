package com.tencent.mobileqq.datareportviewer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements View.OnTouchListener {
    static IPatchRedirector $redirector_;
    public static boolean F;
    private static b G;
    private boolean C;
    private boolean D;
    private BroadcastReceiver E;

    /* renamed from: d, reason: collision with root package name */
    private boolean f203344d;

    /* renamed from: e, reason: collision with root package name */
    private WindowManager f203345e;

    /* renamed from: f, reason: collision with root package name */
    private DataReportViewer f203346f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.datareportviewer.a> f203347h;

    /* renamed from: i, reason: collision with root package name */
    private HashMap<String, c> f203348i;

    /* renamed from: m, reason: collision with root package name */
    private int f203349m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends DataReportViewer {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Context K;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context);
            this.K = context2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, context, context2);
            }
        }

        @Override // com.tencent.mobileqq.datareportviewer.DataReportViewer
        public void e() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                i3 = 2038;
            } else {
                i3 = 2003;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, i3, 776, -2);
            layoutParams.gravity = 51;
            layoutParams.x = 0;
            layoutParams.y = x.c(this.K, 72.0f);
            b.this.f203345e.updateViewLayout(b.this.f203346f, layoutParams);
        }

        @Override // com.tencent.mobileqq.datareportviewer.DataReportViewer
        public void f() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int c16 = x.c(this.K, 50.0f);
            if (Build.VERSION.SDK_INT >= 26) {
                i3 = 2038;
            } else {
                i3 = 2003;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(c16, -2, i3, 776, -2);
            layoutParams.gravity = 51;
            layoutParams.x = 0;
            layoutParams.y = x.c(this.K, 72.0f);
            b.this.f203345e.updateViewLayout(b.this.f203346f, layoutParams);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.datareportviewer.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C7482b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        C7482b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            ReportData reportData = (ReportData) intent.getSerializableExtra("reportData");
            c cVar = (c) b.this.f203348i.get(reportData.actionName);
            if (cVar != null && cVar.d()) {
                b.this.n();
                b.this.f203346f.b(reportData);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71454);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            F = true;
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f203344d = false;
        this.f203347h = null;
        this.f203348i = new HashMap<>();
        this.E = new C7482b();
    }

    public static b i() {
        synchronized (b.class) {
            if (G == null) {
                synchronized (b.class) {
                    G = new b();
                }
            }
        }
        return G;
    }

    public void e(com.tencent.mobileqq.datareportviewer.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
            return;
        }
        this.f203347h.add(aVar);
        m();
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            this.f203348i.put(cVar.f203351c, cVar);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.D = false;
        BaseApplication.getContext().unregisterReceiver(this.E);
        j();
        p(BaseApplicationImpl.getApplication(), false);
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.D = true;
        BaseApplication.getContext().registerReceiver(this.E, new IntentFilter("action.data.report.viewer"));
        p(BaseApplicationImpl.getApplication(), true);
    }

    public ArrayList<com.tencent.mobileqq.datareportviewer.a> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.f203347h == null) {
            this.f203347h = new ArrayList<>(10);
            File fileStreamPath = BaseApplication.getContext().getFileStreamPath("DataReportConfigs");
            if (fileStreamPath != null && fileStreamPath.exists()) {
                try {
                    JSONArray jSONArray = new JSONArray(FileUtils.readFileContent(fileStreamPath));
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                        if (TextUtils.isEmpty(optJSONObject.optString(VipFunCallConstants.KEY_GROUP))) {
                            c c16 = c.c(optJSONObject);
                            this.f203347h.add(c16);
                            this.f203348i.put(c16.f203351c, c16);
                        } else {
                            d c17 = d.c(optJSONObject);
                            this.f203347h.add(c17);
                            Iterator<c> it = c17.f203354c.iterator();
                            while (it.hasNext()) {
                                c next = it.next();
                                this.f203348i.put(next.f203351c, next);
                            }
                        }
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return this.f203347h;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f203344d) {
            try {
                this.f203345e.removeViewImmediate(this.f203346f);
            } catch (Exception unused) {
            }
        }
        this.f203344d = false;
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.D;
    }

    public void l(com.tencent.mobileqq.datareportviewer.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) aVar);
            return;
        }
        this.f203347h.remove(aVar);
        m();
        if (aVar instanceof c) {
            this.f203348i.remove(((c) aVar).f203351c);
        } else if (aVar instanceof d) {
            Iterator<c> it = ((d) aVar).f203354c.iterator();
            while (it.hasNext()) {
                this.f203348i.remove(it.next().f203351c);
            }
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<com.tencent.mobileqq.datareportviewer.a> it = this.f203347h.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next().b());
        }
        FileUtils.writeFile(BaseApplication.getContext().getFileStreamPath("DataReportConfigs").getAbsolutePath(), jSONArray.toString());
    }

    public void n() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        if (this.f203346f == null) {
            this.f203345e = (WindowManager) context.getSystemService("window");
            a aVar = new a(context, context);
            this.f203346f = aVar;
            aVar.setOnTouchListener(this);
        }
        if (!this.f203344d) {
            try {
                this.f203345e.removeViewImmediate(this.f203346f);
            } catch (Exception unused) {
            }
            if (Build.VERSION.SDK_INT >= 26) {
                i3 = 2038;
            } else {
                i3 = 2003;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, i3, 776, -2);
            layoutParams.gravity = 51;
            layoutParams.x = 0;
            layoutParams.y = x.c(context, 72.0f);
            try {
                this.f203345e.addView(this.f203346f, layoutParams);
            } catch (Exception unused2) {
                QQToast.makeText(context, 1, HardCodeUtil.qqStr(R.string.f171830l94), 0).show();
            }
            this.f203344d = true;
        }
    }

    public void o(ArrayList<com.tencent.mobileqq.datareportviewer.a> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) arrayList);
            return;
        }
        HashMap hashMap = new HashMap();
        Iterator<com.tencent.mobileqq.datareportviewer.a> it = this.f203347h.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.datareportviewer.a next = it.next();
            hashMap.put(next.f203342a, Boolean.valueOf(next.f203343b));
        }
        int i3 = 0;
        while (i3 < this.f203347h.size()) {
            com.tencent.mobileqq.datareportviewer.a aVar = this.f203347h.get(i3);
            if (!aVar.a()) {
                this.f203347h.remove(i3);
                i3--;
                if (aVar instanceof c) {
                    this.f203348i.remove(((c) aVar).f203351c);
                } else if (aVar instanceof d) {
                    Iterator<c> it5 = ((d) aVar).f203354c.iterator();
                    while (it5.hasNext()) {
                        this.f203348i.remove(it5.next().f203351c);
                    }
                }
            }
            i3++;
        }
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            com.tencent.mobileqq.datareportviewer.a aVar2 = arrayList.get(i16);
            if (hashMap.containsKey(aVar2.f203342a)) {
                aVar2.f203343b = ((Boolean) hashMap.get(aVar2.f203342a)).booleanValue();
            } else {
                aVar2.f203343b = true;
            }
            if (aVar2 instanceof c) {
                c cVar = (c) aVar2;
                this.f203348i.put(cVar.f203351c, cVar);
            } else if (aVar2 instanceof d) {
                Iterator<c> it6 = ((d) aVar2).f203354c.iterator();
                while (it6.hasNext()) {
                    c next2 = it6.next();
                    this.f203348i.put(next2.f203351c, next2);
                }
            }
        }
        this.f203347h.addAll(arrayList);
        m();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        Context context = this.f203346f.getContext();
        int action = motionEvent.getAction();
        int rawY = (int) motionEvent.getRawY();
        if (action == 0) {
            this.f203349m = (int) motionEvent.getY();
            return false;
        }
        if (action != 2) {
            return false;
        }
        if (this.C || Math.abs(motionEvent.getY() - this.f203349m) > x.c(context, 10.0f)) {
            this.C = true;
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.f203346f.getLayoutParams();
            layoutParams.y = (rawY - this.f203349m) - x.c(context, 0.0f);
            int height = this.f203345e.getDefaultDisplay().getHeight();
            int i3 = layoutParams.y;
            if (i3 < 0) {
                layoutParams.y = 0;
            } else if (i3 > height - this.f203346f.getHeight()) {
                layoutParams.y = height - this.f203346f.getHeight();
            }
            this.f203345e.updateViewLayout(this.f203346f, layoutParams);
        }
        return true;
    }

    public void p(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, Boolean.valueOf(z16));
            return;
        }
        this.D = z16;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("DataReportViewerFloatViewHelper", z16);
        edit.apply();
    }
}
