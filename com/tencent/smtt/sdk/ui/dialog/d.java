package com.tencent.smtt.sdk.ui.dialog;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsHandlerThread;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class d extends ReportDialog {

    /* renamed from: a, reason: collision with root package name */
    static WeakReference<ValueCallback<String>> f369542a;

    /* renamed from: b, reason: collision with root package name */
    protected List<b> f369543b;

    /* renamed from: c, reason: collision with root package name */
    protected final String f369544c;

    /* renamed from: d, reason: collision with root package name */
    protected final String f369545d;

    /* renamed from: e, reason: collision with root package name */
    protected final String f369546e;

    /* renamed from: f, reason: collision with root package name */
    protected final String f369547f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f369548g;

    /* renamed from: h, reason: collision with root package name */
    private ListView f369549h;

    /* renamed from: i, reason: collision with root package name */
    private Button f369550i;

    /* renamed from: j, reason: collision with root package name */
    private Button f369551j;

    /* renamed from: k, reason: collision with root package name */
    private final String f369552k;

    /* renamed from: l, reason: collision with root package name */
    private String f369553l;

    /* renamed from: m, reason: collision with root package name */
    private a f369554m;

    /* renamed from: n, reason: collision with root package name */
    private String f369555n;

    /* renamed from: o, reason: collision with root package name */
    private String f369556o;

    /* renamed from: p, reason: collision with root package name */
    private Handler f369557p;

    /* renamed from: q, reason: collision with root package name */
    private List<ResolveInfo> f369558q;

    /* renamed from: r, reason: collision with root package name */
    private Context f369559r;

    /* renamed from: s, reason: collision with root package name */
    private Intent f369560s;

    /* renamed from: t, reason: collision with root package name */
    private SharedPreferences f369561t;

    /* renamed from: u, reason: collision with root package name */
    private int f369562u;

    /* renamed from: v, reason: collision with root package name */
    private int f369563v;

    /* renamed from: w, reason: collision with root package name */
    private FrameLayout f369564w;

    /* renamed from: x, reason: collision with root package name */
    private LinearLayout f369565x;

    public d(Context context, String str, Intent intent, Bundle bundle, ValueCallback<String> valueCallback, String str2, String str3) {
        super(context, R.style.Theme.Dialog);
        Bundle bundle2;
        this.f369548g = false;
        this.f369552k = "TBSActivityPicker";
        this.f369544c = "extraMenu";
        this.f369545d = "name";
        this.f369546e = DittoImageArea.RESOURCE_ID;
        this.f369547f = "value";
        this.f369555n = "*/*";
        this.f369561t = null;
        this.f369562u = 0;
        this.f369563v = 0;
        this.f369556o = str3;
        this.f369559r = context;
        if (bundle != null) {
            bundle2 = bundle.getBundle("extraMenu");
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            this.f369543b = new ArrayList();
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                Bundle bundle3 = bundle2.getBundle(it.next());
                if (bundle3 != null) {
                    String string = bundle3.getString("name", null);
                    int i3 = bundle3.getInt(DittoImageArea.RESOURCE_ID, -1);
                    String string2 = bundle3.getString("value", null);
                    if (string != null && i3 != -1 && string2 != null) {
                        this.f369543b.add(new b(getContext(), i3, string, string2));
                    }
                }
            }
        } else {
            TbsLog.i("TBSActivityPicker", "no extra menu info in bundle");
        }
        this.f369553l = str;
        this.f369560s = intent;
        f369542a = new WeakReference<>(valueCallback);
        this.f369561t = context.getSharedPreferences(QbSdk.SHARE_PREFERENCES_NAME, 0);
        if (!TextUtils.isEmpty(str2)) {
            this.f369555n = str2;
        }
        TbsLog.i("TBSActivityPicker", "Intent:" + this.f369555n + " MineType:" + this.f369555n);
    }

    private void h() {
        ListAdapter adapter = this.f369549h.getAdapter();
        if (adapter == null) {
            return;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < adapter.getCount(); i16++) {
            View view = adapter.getView(i16, null, this.f369549h);
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            i3 += view.getMeasuredHeight();
        }
        float a16 = c.a(getContext()) * 0.8f;
        float a17 = c.a(getContext()) * 0.5f;
        float f16 = this.f369563v + i3 + this.f369562u;
        ViewGroup.LayoutParams layoutParams = this.f369565x.getLayoutParams();
        if (f16 > a16) {
            layoutParams.height = Float.valueOf(a16).intValue();
        } else if (f16 < a17) {
            layoutParams.height = Float.valueOf(a17).intValue();
        } else {
            layoutParams.height = Float.valueOf(f16).intValue();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        List<b> list;
        List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(this.f369559r.getPackageManager(), this.f369560s, 65536);
        this.f369558q = queryIntentActivities;
        TbsLog.i("TBSActivityPicker", "acts.size(): " + queryIntentActivities.size());
        if (queryIntentActivities.size() == 0 && (((list = this.f369543b) == null || list.isEmpty()) && MttLoader.isBrowserInstalled(this.f369559r))) {
            TbsLog.i("TBSActivityPicker", "no action has been found with Intent:" + this.f369560s.toString());
            this.f369548g = true;
        }
        e();
    }

    private void e() {
        Context context = this.f369559r;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.tencent.smtt.sdk.ui.dialog.d.2
                @Override // java.lang.Runnable
                public void run() {
                    String b16 = d.this.b();
                    TbsLog.i("TBSActivityPicker", "openFileReaderListWithQBDownload,defaultBrowser:" + b16);
                    if (b16 != null && !TextUtils.isEmpty(b16) && b16.startsWith("extraMenuEvent:")) {
                        TbsLog.i("TBSActivityPicker", "openFileReaderListWithQBDownload, is default extra menu action");
                        if (d.f369542a.get() != null) {
                            d.f369542a.get().onReceiveValue(b16);
                            return;
                        }
                        return;
                    }
                    if (b16 != null && !TextUtils.isEmpty(b16) && QbSdk.checkApkExist(d.this.f369559r, b16)) {
                        TbsLog.i("TBSActivityPicker", "openFileReaderListWithQBDownload, is default normal menu action");
                        if (TbsConfig.APP_QB.equals(b16)) {
                            d.this.f369560s.putExtra("ChannelID", d.this.f369559r.getApplicationContext().getPackageName());
                            d.this.f369560s.putExtra("PosID", "4");
                        }
                        if (!TextUtils.isEmpty(d.this.f369556o)) {
                            d.this.f369560s.putExtra("big_brother_source_key", d.this.f369556o);
                        }
                        d.this.f369560s.setPackage(b16);
                        d.this.f369559r.startActivity(d.this.f369560s);
                        if (d.f369542a.get() != null) {
                            d.f369542a.get().onReceiveValue("default browser:" + b16);
                            return;
                        }
                        return;
                    }
                    if (d.this.f369548g) {
                        TbsLog.i("TBSActivityPicker", "isDefaultDialog=true");
                        if (d.f369542a.get() != null) {
                            TbsLog.i("TBSActivityPicker", "isDefaultDialog=true, can not open");
                            d.f369542a.get().onReceiveValue("can not open");
                        }
                    } else {
                        try {
                            TbsLog.i("TBSActivityPicker", "isDefaultDialog=false,try to open dialog");
                            d.this.show();
                            d.this.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.smtt.sdk.ui.dialog.d.2.1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public void onDismiss(DialogInterface dialogInterface) {
                                    if (d.f369542a.get() != null) {
                                        d.f369542a.get().onReceiveValue("TbsReaderDialogClosed");
                                    }
                                    if (d.this.f369559r != null) {
                                        d.this.f369559r = null;
                                    }
                                }
                            });
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            TbsLog.i("TBSActivityPicker", "isDefaultDialog=false,try to open dialog, but failed");
                            if (d.f369542a.get() != null) {
                                d.f369542a.get().onReceiveValue("TbsReaderDialogClosed");
                            }
                        }
                    }
                    TbsLog.i("TBSActivityPicker", "unexpected return, dialogBuilder not show!");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        String[] strArr = {"com.tencent.mobileqq", AppConstants.TIM_PACKAGE_NAME};
        String packageName = getContext().getApplicationContext().getPackageName();
        for (int i3 = 0; i3 < 2; i3++) {
            if (strArr[i3].equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    private void g() {
        String str;
        String str2;
        a aVar = this.f369554m;
        Drawable drawable = null;
        b a16 = aVar != null ? aVar.a() : null;
        SharedPreferences sharedPreferences = this.f369561t;
        if (sharedPreferences != null) {
            Drawable c16 = c(sharedPreferences.getString("key_tbs_recommend_icon_url", null));
            str = this.f369561t.getString("key_tbs_recommend_label", null);
            str2 = this.f369561t.getString("key_tbs_recommend_description", null);
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = null;
            }
            drawable = c16;
        } else {
            str = null;
            str2 = null;
        }
        if (drawable == null) {
            drawable = e.a("application_icon");
        }
        Drawable drawable2 = drawable;
        if (str == null) {
            str = "QQ\u6d4f\u89c8\u5668";
        }
        String str3 = str;
        if (str2 == null) {
            str2 = e.b("x5_tbs_wechat_activity_picker_label_recommend");
        }
        a aVar2 = new a(getContext(), this.f369560s, new b(getContext(), drawable2, str3, TbsConfig.APP_QB, str2), this.f369543b, a16, this, this.f369549h, this.f369558q);
        this.f369554m = aVar2;
        this.f369549h.setAdapter((ListAdapter) aVar2);
        h();
    }

    public String b() {
        if (this.f369561t == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getTBSPickedDefaultBrowser: ");
        sb5.append(this.f369561t.getString("key_tbs_picked_default_browser_" + this.f369555n, null));
        TbsLog.i("TBSActivityPicker", sb5.toString());
        return this.f369561t.getString("key_tbs_picked_default_browser_" + this.f369555n, null);
    }

    public void c() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.horizontalMargin = 0.0f;
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
        }
        setContentView(a(getContext()));
        g();
        this.f369550i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.ui.dialog.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                b a16 = d.this.f369554m.a();
                ResolveInfo a17 = d.this.f369554m.a(a16);
                d.this.b("userClickAlwaysEvent:");
                if (a16 != null) {
                    if (!a16.e()) {
                        if (a17 != null) {
                            Intent intent = d.this.f369560s;
                            Context context = d.this.getContext();
                            String str = a17.activityInfo.packageName;
                            intent.setPackage(str);
                            if (TbsConfig.APP_QB.equals(str)) {
                                intent.putExtra("ChannelID", context.getApplicationContext().getPackageName());
                                intent.putExtra("PosID", "4");
                            }
                            if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                                intent.addFlags(1);
                            }
                            if (!TextUtils.isEmpty(d.this.f369556o)) {
                                intent.putExtra("big_brother_source_key", d.this.f369556o);
                            }
                            try {
                                context.startActivity(intent);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                            if (d.f369542a.get() != null) {
                                d.f369542a.get().onReceiveValue("always");
                            }
                            d.this.a(str);
                        } else {
                            d.this.a(a16);
                            d.this.dismiss();
                        }
                    } else {
                        String g16 = a16.g();
                        if (d.f369542a.get() != null) {
                            d.f369542a.get().onReceiveValue("extraMenuEvent:" + g16);
                        }
                        d.this.a("extraMenuEvent:" + g16);
                    }
                    d.this.dismiss();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.f369551j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.ui.dialog.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                b a16 = d.this.f369554m.a();
                ResolveInfo a17 = d.this.f369554m.a(a16);
                d.this.b("userClickOnceEvent:");
                d.this.a("");
                if (a16 != null) {
                    if (!a16.e()) {
                        if (a17 != null) {
                            Intent intent = d.this.f369560s;
                            Context context = d.this.getContext();
                            String str = a17.activityInfo.packageName;
                            intent.setPackage(str);
                            if (TbsConfig.APP_QB.equals(str)) {
                                intent.putExtra("ChannelID", context.getApplicationContext().getPackageName());
                                intent.putExtra("PosID", "4");
                            }
                            if (context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                                intent.addFlags(1);
                            }
                            if (!TextUtils.isEmpty(d.this.f369556o)) {
                                intent.putExtra("big_brother_source_key", d.this.f369556o);
                            }
                            try {
                                context.startActivity(intent);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                            if (d.f369542a.get() != null) {
                                d.f369542a.get().onReceiveValue("once");
                            }
                        } else {
                            d.this.a(a16);
                            d.this.dismiss();
                        }
                    } else if (d.this.f() && d.f369542a.get() != null) {
                        d.f369542a.get().onReceiveValue("extraMenuEvent:" + a16.g());
                    }
                    d.this.dismiss();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        ActivityInfo activityInfo;
        if (this.f369554m == null || !f()) {
            return;
        }
        b a16 = this.f369554m.a();
        ResolveInfo a17 = this.f369554m.a(a16);
        if (f369542a.get() != null) {
            if (a16 != null && a17 != null && (activityInfo = a17.activityInfo) != null && activityInfo.packageName != null) {
                f369542a.get().onReceiveValue(str + a17.activityInfo.packageName);
                return;
            }
            if (a16 != null) {
                if (a16.e()) {
                    f369542a.get().onReceiveValue(str + a16.g());
                    return;
                }
                if (a16.f()) {
                    f369542a.get().onReceiveValue(str + a16.d());
                    return;
                }
                return;
            }
            f369542a.get().onReceiveValue(str + "other");
        }
    }

    public void a() {
        Handler handler = new Handler(TbsHandlerThread.getInstance().getLooper()) { // from class: com.tencent.smtt.sdk.ui.dialog.d.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1001) {
                    d.this.d();
                }
            }
        };
        this.f369557p = handler;
        handler.obtainMessage(1001).sendToTarget();
    }

    public void a(String str) {
        TbsLog.i("TBSActivityPicker", "setTBSPickedDefaultBrowser:" + str);
        if (this.f369561t != null) {
            if (TextUtils.isEmpty(str)) {
                TbsLog.i("TBSActivityPicker", "paramString empty, remove: key_tbs_picked_default_browser_" + this.f369555n);
                this.f369561t.edit().remove("key_tbs_picked_default_browser_" + this.f369555n).commit();
                return;
            }
            TbsLog.i("TBSActivityPicker", "paramString not empty, set: key_tbs_picked_default_browser_" + this.f369555n + ContainerUtils.KEY_VALUE_DELIMITER + str);
            SharedPreferences.Editor edit = this.f369561t.edit();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("key_tbs_picked_default_browser_");
            sb5.append(this.f369555n);
            edit.putString(sb5.toString(), str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        String str;
        String str2;
        if (bVar.f()) {
            boolean matches = Build.CPU_ABI.matches("armeabi.*");
            if (f() && f369542a.get() != null) {
                if (matches) {
                    str2 = "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=11047&is64=0";
                } else {
                    str2 = "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=11047&is64=1";
                }
                f369542a.get().onReceiveValue(str2);
                return;
            }
            if (matches) {
                str = "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=11041&is64=0";
            } else {
                str = "https://mdc.html5.qq.com/d/directdown.jsp?channel_id=11041&is64=1";
            }
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
            intent.addFlags(268435456);
            try {
                getContext().startActivity(intent);
            } catch (Throwable unused) {
                Toast.makeText(getContext(), "\u60a8\u7684\u8bbe\u5907\u5c1a\u672a\u5b89\u88c5QQ\u6d4f\u89c8\u5668\uff0c\u8bf7\u5148\u4e0b\u8f7d", 1).show();
            }
        }
    }

    private Drawable c(String str) {
        Context context = getContext();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(context.getFilesDir(), str);
        if (!FileUtil.c(file)) {
            return null;
        }
        try {
            TbsLog.i("TBSActivityPicker", "load icon from: " + file.getAbsolutePath());
            return new BitmapDrawable(BitmapFactory.decodeFile(file.getAbsolutePath()));
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private View a(Context context) {
        this.f369564w = new FrameLayout(context);
        this.f369565x = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, Double.valueOf(c.a(context) * 0.5f).intValue());
        layoutParams.gravity = 17;
        this.f369565x.setLayoutParams(layoutParams);
        this.f369565x.setOrientation(1);
        this.f369563v = c.a(context, 72.0f);
        com.tencent.smtt.sdk.ui.dialog.widget.a aVar = new com.tencent.smtt.sdk.ui.dialog.widget.a(context, c.a(context, 12.0f), c.a(context, 35.0f), c.a(context, 15.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.f369563v);
        aVar.setImportantForAccessibility(4);
        aVar.setLayoutParams(layoutParams2);
        aVar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.ui.dialog.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                d.this.dismiss();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.f369565x.addView(aVar);
        ListView listView = new ListView(context);
        this.f369549h = listView;
        listView.setOverScrollMode(2);
        this.f369549h.setVerticalScrollBarEnabled(false);
        this.f369549h.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams3.weight = 1.0f;
        layoutParams3.gravity = 16;
        this.f369549h.setLayoutParams(layoutParams3);
        this.f369549h.setDividerHeight(0);
        this.f369565x.addView(this.f369549h);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f369562u = c.a(context, 150.0f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, this.f369562u);
        layoutParams4.weight = 0.0f;
        linearLayout.setLayoutParams(layoutParams4);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setContentDescription("x5_tbs_activity_picker_btn_container");
        linearLayout.setImportantForAccessibility(2);
        this.f369550i = new com.tencent.smtt.sdk.ui.dialog.widget.b(context, c.a(context, 12.0f), Color.parseColor("#EBEDF5"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, c.a(context, 90.0f));
        layoutParams5.weight = 1.0f;
        layoutParams5.topMargin = c.a(context, 30.0f);
        layoutParams5.bottomMargin = c.a(context, 30.0f);
        layoutParams5.leftMargin = c.a(context, 32.0f);
        layoutParams5.rightMargin = c.a(context, 8.0f);
        this.f369550i.setLayoutParams(layoutParams5);
        this.f369550i.setText(e.b("x5_tbs_wechat_activity_picker_label_always"));
        this.f369550i.setTextColor(Color.rgb(29, 29, 29));
        this.f369550i.setTextSize(0, c.a(context, 34.0f));
        linearLayout.addView(this.f369550i);
        this.f369551j = new com.tencent.smtt.sdk.ui.dialog.widget.b(context, c.a(context, 12.0f), Color.parseColor("#00CAFC"));
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, c.a(context, 90.0f));
        layoutParams6.weight = 1.0f;
        layoutParams6.topMargin = c.a(context, 30.0f);
        layoutParams6.bottomMargin = c.a(context, 30.0f);
        layoutParams6.leftMargin = c.a(context, 8.0f);
        layoutParams6.rightMargin = c.a(context, 32.0f);
        this.f369551j.setLayoutParams(layoutParams6);
        this.f369551j.setText(e.b("x5_tbs_wechat_activity_picker_label_once"));
        this.f369551j.setTextColor(Color.rgb(255, 255, 255));
        this.f369551j.setTextSize(0, c.a(context, 34.0f));
        linearLayout.addView(this.f369551j);
        this.f369565x.addView(linearLayout);
        this.f369564w.addView(this.f369565x);
        return this.f369564w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z16) {
        Button button = this.f369551j;
        if (button != null) {
            button.setEnabled(z16);
        }
        Button button2 = this.f369550i;
        if (button2 != null) {
            button2.setEnabled(z16);
        }
        b("userMenuClickEvent:");
    }
}
