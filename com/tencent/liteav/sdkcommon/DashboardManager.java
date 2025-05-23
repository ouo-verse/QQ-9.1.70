package com.tencent.liteav.sdkcommon;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.internal.view.SupportMenu;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.sdkcommon.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@JNINamespace("liteav::dashboard")
/* loaded from: classes7.dex */
public class DashboardManager {
    private static final int LOG_MAX_SIZE = 15000;
    private static final String TAG = "DashboardManager";
    private final Context mAppContext;
    private final g mDashboardManagerView;
    private boolean mIsInit;
    private final g.a mSelectedDashboardChangeListener;
    private String mSelectedDashboardId;
    private final Handler mUIHandler;
    private final ArrayList<String> mDashboards = new ArrayList<>();
    private final Map<String, String> mDashboardStatus = new HashMap();
    private final Map<String, StringBuilder> mDashboardLogs = new HashMap();

    public DashboardManager() {
        g.a aVar = new g.a() { // from class: com.tencent.liteav.sdkcommon.DashboardManager.1
            @Override // com.tencent.liteav.sdkcommon.g.a
            public final void a(int i3) {
                if (DashboardManager.this.mDashboards.size() <= i3) {
                    return;
                }
                DashboardManager dashboardManager = DashboardManager.this;
                dashboardManager.mSelectedDashboardId = (String) dashboardManager.mDashboards.get(i3);
                if (!DashboardManager.this.mDashboards.contains(DashboardManager.this.mSelectedDashboardId)) {
                    return;
                }
                DashboardManager.this.mDashboardManagerView.b((String) DashboardManager.this.mDashboardStatus.get(DashboardManager.this.mSelectedDashboardId));
                StringBuilder sb5 = (StringBuilder) DashboardManager.this.mDashboardLogs.get(DashboardManager.this.mSelectedDashboardId);
                if (sb5 != null) {
                    DashboardManager.this.mDashboardManagerView.a(sb5.toString());
                } else {
                    DashboardManager.this.mDashboardManagerView.a("");
                }
            }
        };
        this.mSelectedDashboardChangeListener = aVar;
        LiteavLog.i(TAG, "java DashBoardManager Construct");
        this.mIsInit = false;
        Context applicationContext = ContextUtils.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mDashboardManagerView = new g(applicationContext, aVar);
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDashboardInternal(String str) {
        if (!this.mDashboards.contains(str)) {
            this.mDashboards.add(str);
            g gVar = this.mDashboardManagerView;
            gVar.f119122e.add(str);
            if (gVar.f119129l == null) {
                gVar.f119129l = gVar.f119122e.getItem(0);
                gVar.f119132o.a(0);
            }
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appendLogInternal(String str, String str2) {
        g gVar;
        TextView textView;
        if (this.mDashboards.contains(str)) {
            StringBuilder sb5 = this.mDashboardLogs.get(str);
            if (sb5 == null) {
                sb5 = new StringBuilder();
                this.mDashboardLogs.put(str, sb5);
            }
            sb5.append(str2);
            sb5.append("\n");
            boolean z16 = false;
            if (sb5.length() > 15000) {
                sb5.delete(0, sb5.length() / 2);
            }
            if (str.equals(this.mSelectedDashboardId) && (textView = (gVar = this.mDashboardManagerView).f119126i) != null) {
                textView.append(str2 + "\n");
                ScrollView scrollView = gVar.f119128k;
                if (scrollView != null) {
                    if (scrollView.getScrollY() + gVar.f119128k.getHeight() + gVar.a(100) >= gVar.f119126i.getMeasuredHeight()) {
                        z16 = true;
                    }
                    if (z16) {
                        gVar.f119121d.post(i.a(gVar));
                    }
                }
            }
        }
    }

    private boolean checkPermission() {
        if (LiteavSystemInfo.getSystemOSVersionInt() > 23 && !Settings.canDrawOverlays(this.mAppContext)) {
            Toast.makeText(this.mAppContext, "no system alert window permission, please authorize", 0).show();
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean init() {
        boolean z16;
        if (this.mIsInit) {
            return true;
        }
        g gVar = this.mDashboardManagerView;
        Context context = gVar.f119120c;
        if (context == null) {
            Log.e("DashboardManagerView", "dashBoardManagerView context is null", new Object[0]);
        } else {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            gVar.f119123f = windowManager;
            if (windowManager == null) {
                Log.e("DashboardManagerView", "get windowManager is fail", new Object[0]);
            } else {
                windowManager.getDefaultDisplay().getMetrics(gVar.f119118a);
                gVar.f119131n = gVar.f119118a.heightPixels - gVar.a(50);
                z16 = true;
                if (z16) {
                    return false;
                }
                g gVar2 = this.mDashboardManagerView;
                if (Build.VERSION.SDK_INT >= 26) {
                    gVar2.f119119b.type = 2038;
                } else {
                    gVar2.f119119b.type = 2002;
                }
                WindowManager.LayoutParams layoutParams = gVar2.f119119b;
                layoutParams.format = 1;
                layoutParams.gravity = 8388659;
                layoutParams.width = gVar2.f119118a.widthPixels;
                layoutParams.height = gVar2.f119131n;
                layoutParams.x = 0;
                layoutParams.y = 0;
                layoutParams.flags = 32;
                LinearLayout linearLayout = new LinearLayout(gVar2.f119120c);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                linearLayout.setOrientation(1);
                linearLayout.setOnTouchListener(new g.b(gVar2, (byte) 0));
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(gVar2.a(70), gVar2.a(40));
                Button button = new Button(gVar2.f119120c);
                button.setText("Resize");
                button.setLayoutParams(layoutParams2);
                button.setOnClickListener(j.a(gVar2, button));
                Button button2 = new Button(gVar2.f119120c);
                button2.setText("close");
                layoutParams2.leftMargin = gVar2.a(10);
                button2.setLayoutParams(layoutParams2);
                button2.setOnClickListener(k.a(gVar2));
                LinearLayout linearLayout2 = new LinearLayout(gVar2.f119120c);
                linearLayout2.addView(button);
                linearLayout2.addView(button2);
                linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                linearLayout2.setOrientation(0);
                linearLayout2.setBackgroundColor(-7829368);
                linearLayout2.setAlpha(0.5f);
                linearLayout.addView(linearLayout2);
                Spinner spinner = new Spinner(gVar2.f119120c);
                gVar2.f119127j = spinner;
                spinner.setAdapter((SpinnerAdapter) gVar2.f119122e);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, gVar2.a(30));
                layoutParams3.topMargin = gVar2.a(2);
                gVar2.f119127j.setLayoutParams(layoutParams3);
                gVar2.f119127j.setOnItemSelectedListener(new g.c(gVar2, (byte) 0));
                gVar2.f119127j.setBackgroundColor(-7829368);
                gVar2.f119127j.setAlpha(0.5f);
                linearLayout.addView(gVar2.f119127j);
                gVar2.f119125h = new TextView(gVar2.f119120c);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, gVar2.a(160));
                layoutParams4.topMargin = gVar2.a(10);
                layoutParams4.leftMargin = gVar2.a(10);
                layoutParams4.rightMargin = gVar2.a(3);
                gVar2.f119125h.setLayoutParams(layoutParams4);
                gVar2.f119125h.setTextColor(SupportMenu.CATEGORY_MASK);
                linearLayout.addView(gVar2.f119125h);
                gVar2.f119128k = new ScrollView(gVar2.f119120c);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, gVar2.b());
                layoutParams5.leftMargin = gVar2.a(10);
                layoutParams5.rightMargin = gVar2.a(3);
                gVar2.f119128k.setLayoutParams(layoutParams5);
                gVar2.f119128k.setVerticalScrollBarEnabled(true);
                gVar2.f119126i = new TextView(gVar2.f119120c);
                gVar2.f119126i.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                gVar2.f119126i.setTextColor(SupportMenu.CATEGORY_MASK);
                gVar2.f119128k.addView(gVar2.f119126i);
                gVar2.f119128k.fullScroll(130);
                linearLayout.addView(gVar2.f119128k);
                gVar2.f119124g = linearLayout;
                gVar2.f119132o.a(0);
                this.mIsInit = true;
                return true;
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllDashboardInternal() {
        this.mDashboards.clear();
        this.mDashboardStatus.clear();
        this.mDashboardLogs.clear();
        g gVar = this.mDashboardManagerView;
        gVar.f119122e.clear();
        gVar.f119129l = null;
        TextView textView = gVar.f119125h;
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = gVar.f119126i;
        if (textView2 != null) {
            textView2.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDashboardInternal(String str) {
        if (this.mDashboards.contains(str)) {
            this.mDashboards.remove(str);
            this.mDashboardStatus.remove(str);
            this.mDashboardLogs.remove(str);
            g gVar = this.mDashboardManagerView;
            if (str.equals(gVar.f119129l)) {
                int position = gVar.f119122e.getPosition(gVar.f119129l);
                if (position != gVar.f119122e.getCount() - 1) {
                    int i3 = position + 1;
                    gVar.f119129l = gVar.f119122e.getItem(i3);
                    gVar.f119132o.a(i3 - 1);
                    Spinner spinner = gVar.f119127j;
                    if (spinner != null) {
                        spinner.setSelection(i3);
                    }
                } else if (position > 0) {
                    int i16 = position - 1;
                    gVar.f119129l = gVar.f119122e.getItem(i16);
                    gVar.f119132o.a(i16);
                    Spinner spinner2 = gVar.f119127j;
                    if (spinner2 != null) {
                        spinner2.setSelection(i16);
                    }
                }
            }
            gVar.f119122e.remove(str);
            if (gVar.f119122e.getCount() == 0) {
                gVar.f119129l = null;
            }
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusInternal(String str, String str2) {
        if (this.mDashboards.contains(str)) {
            this.mDashboardStatus.put(str, str2);
            if (str.equals(this.mSelectedDashboardId)) {
                this.mDashboardManagerView.b(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDashboardInternal(boolean z16) {
        if (z16 && (!checkPermission() || !init())) {
            LiteavLog.i(TAG, "init or check permission is fail");
        } else {
            this.mDashboardManagerView.a(z16);
        }
    }

    public int addDashboard(String str) {
        LiteavLog.i(TAG, "addDashboard dashboardId = ".concat(String.valueOf(str)));
        this.mUIHandler.post(b.a(this, str));
        return 0;
    }

    public int appendLog(String str, String str2) {
        this.mUIHandler.post(f.a(this, str, str2));
        return 0;
    }

    public int removeAllDashboard() {
        LiteavLog.i(TAG, "removeAllDashboard ");
        this.mUIHandler.post(d.a(this));
        return 0;
    }

    public int removeDashboard(String str) {
        LiteavLog.i(TAG, "removeDashboard dashboardId = ".concat(String.valueOf(str)));
        this.mUIHandler.post(c.a(this, str));
        return 0;
    }

    public int setStatus(String str, String str2) {
        this.mUIHandler.post(e.a(this, str, str2));
        return 0;
    }

    public int showDashboard(boolean z16) {
        LiteavLog.i(TAG, "showDashBoard isShow = ".concat(String.valueOf(z16)));
        this.mUIHandler.post(a.a(this, z16));
        return 0;
    }
}
