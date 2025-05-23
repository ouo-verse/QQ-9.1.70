package com.tencent.luggage.wxa.qq;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.luggage.wxa.ar.j0;
import com.tencent.luggage.wxa.ar.p0;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y;
import com.tencent.luggage.wxa.ar.z0;
import com.tencent.xweb.CommandCfgPlugin;
import com.tencent.xweb.FileReaderCrashDetector;
import com.tencent.xweb.FileReaderHelper;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.xwalk.plugin.XFileSchedulerFactory;
import com.tencent.xweb.xwalk.plugin.XWalkFullScreenVideoPlugin;
import com.tencent.xweb.xwalk.plugin.XWalkPlugin;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import com.tencent.xweb.xwalk.plugin.XWalkPluginUpdateListener;
import com.tencent.xweb.xwalk.plugin.XWalkPluginUpdater;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements XWalkPluginUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public boolean f138990a = false;

        /* renamed from: b, reason: collision with root package name */
        public ProgressDialog f138991b = null;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f138992c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f138993d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f138994e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ XWalkPluginUpdater f138995f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f138996g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f138997h;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.qq.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class DialogInterfaceOnClickListenerC6656a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC6656a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (!a.this.f138990a) {
                    a.this.f138995f.cancelPluginUpdate();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                a.this.f138991b.dismiss();
            }
        }

        public a(String str, boolean z16, Context context, XWalkPluginUpdater xWalkPluginUpdater, boolean z17, ValueCallback valueCallback) {
            this.f138992c = str;
            this.f138993d = z16;
            this.f138994e = context;
            this.f138995f = xWalkPluginUpdater;
            this.f138996g = z17;
            this.f138997h = valueCallback;
        }

        @Override // com.tencent.xweb.xwalk.plugin.XWalkPluginUpdateListener
        public void onXWalkPluginUpdateCompleted(int i3) {
            int i16;
            this.f138990a = true;
            XWalkPlugin plugin = XWalkPluginManager.getPlugin(this.f138992c);
            if (plugin != null) {
                i16 = plugin.getAvailableVersion(true);
            } else {
                i16 = -1;
            }
            switch (i3) {
                case -11:
                    a(this.f138992c + " \u66f4\u65b0\u5931\u8d25\uff0c\u63d2\u4ef6\u5b89\u88c5\u5931\u8d25\uff0cErrCode = " + i3);
                    break;
                case -10:
                    a(this.f138992c + " \u66f4\u65b0\u5931\u8d25\uff0c\u63d2\u4ef6\u4e0b\u8f7d\u5931\u8d25\uff0cErrCode = " + i3);
                    break;
                case -9:
                    a(this.f138992c + " \u66f4\u65b0\u5931\u8d25\uff0c\u63d2\u4ef6\u4e0b\u8f7d\u6216\u5b89\u88c5\u5931\u8d25\uff0cErrCode = " + i3);
                    break;
                case -8:
                    a(this.f138992c + " \u66f4\u65b0\u5931\u8d25\uff0c\u672a\u627e\u5230\u53ef\u7528\u66f4\u65b0\uff0c\u5f53\u524d\u5df2\u5b89\u88c5\u7248\u672c" + i16 + "\uff0cErrCode = " + i3);
                    ProgressDialog progressDialog = this.f138991b;
                    if (progressDialog != null && this.f138996g) {
                        progressDialog.dismiss();
                        break;
                    }
                    break;
                case -7:
                    a(this.f138992c + " \u66f4\u65b0\u5931\u8d25\uff0c\u914d\u7f6e\u4e2d\u672a\u5305\u542b\u63d2\u4ef6\u4fe1\u606f\uff0cErrCode = " + i3);
                    break;
                case -6:
                    a(this.f138992c + " \u66f4\u65b0\u5931\u8d25\uff0c\u914d\u7f6e\u89e3\u6790\u5931\u8d25\uff0cErrCode = " + i3);
                    break;
                case -5:
                    a(this.f138992c + " \u66f4\u65b0\u5931\u8d25\uff0c\u914d\u7f6e\u4e0b\u8f7d\u5931\u8d25\uff0cErrCode = " + i3);
                    break;
                case -4:
                    a(this.f138992c + " \u66f4\u65b0\u5931\u8d25\uff0c\u5176\u5b83\u4efb\u52a1\u6b63\u5728\u66f4\u65b0\u63d2\u4ef6\uff0cErrCode = " + i3);
                    break;
                case -3:
                    a(this.f138992c + " \u66f4\u65b0\u5931\u8d25\uff0c\u672a\u5230\u68c0\u67e5\u65f6\u95f4\uff0cErrCode = " + i3);
                    break;
                case -2:
                    a(this.f138992c + " \u66f4\u65b0\u5931\u8d25\uff0c\u65e0\u7f51\u7edc\uff0cErrCode = " + i3);
                    break;
                case -1:
                    a(this.f138992c + " \u66f4\u65b0\u88ab\u53d6\u6d88\uff0cErrCode = " + i3);
                    break;
                case 0:
                    a(this.f138992c + " \u66f4\u65b0\u5b8c\u6210\uff0c\u5df2\u5b89\u88c5\u7248\u672c" + i16);
                    ProgressDialog progressDialog2 = this.f138991b;
                    if (progressDialog2 != null) {
                        progressDialog2.setProgress(100);
                        this.f138991b.getButton(-2).setVisibility(8);
                        this.f138991b.getButton(-1).setVisibility(0);
                        if (this.f138996g) {
                            this.f138991b.dismiss();
                            break;
                        }
                    }
                    break;
                default:
                    a(this.f138992c + " \u66f4\u65b0\u5931\u8d25\uff0c\u672a\u77e5\u9519\u8bef\uff0cErrCode = " + i3);
                    break;
            }
            ValueCallback valueCallback = this.f138997h;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.xweb.xwalk.plugin.XWalkPluginUpdateListener
        public void onXWalkPluginUpdateProgress(int i3) {
            ProgressDialog progressDialog;
            if (!this.f138990a && (progressDialog = this.f138991b) != null) {
                progressDialog.setProgress(i3);
            }
        }

        @Override // com.tencent.xweb.xwalk.plugin.XWalkPluginUpdateListener
        public void onXWalkPluginUpdateStarted() {
            a(this.f138992c + " \u4e0b\u8f7d\u66f4\u65b0\u4e2d");
        }

        public final void a(String str) {
            x0.d("XWebDebugPluginHelper", "showMessage, shouldAlert:" + this.f138993d + ", message:" + str);
            if (this.f138993d) {
                if (this.f138991b == null) {
                    ProgressDialog progressDialog = new ProgressDialog(this.f138994e);
                    this.f138991b = progressDialog;
                    progressDialog.setProgressStyle(1);
                    this.f138991b.setMessage(str);
                    this.f138991b.setCancelable(false);
                    this.f138991b.setCanceledOnTouchOutside(false);
                    this.f138991b.setButton(-2, "\u53d6\u6d88", new DialogInterfaceOnClickListenerC6656a());
                    this.f138991b.setButton(-1, "\u5b8c\u6210", new b());
                    this.f138991b.show();
                    this.f138991b.getButton(-1).setVisibility(8);
                }
                this.f138991b.setMessage(str);
                return;
            }
            Toast.makeText(this.f138994e, str, 0).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends AsyncTask {

        /* renamed from: a, reason: collision with root package name */
        public ProgressDialog f139000a = null;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f139001b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ XWalkPlugin f139002c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f139003d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f139004e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f139005f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f139006g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f139007h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f139008i;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                b.this.f139000a.hide();
            }
        }

        public b(Context context, XWalkPlugin xWalkPlugin, int i3, boolean z16, String str, String str2, boolean z17, ValueCallback valueCallback) {
            this.f139001b = context;
            this.f139002c = xWalkPlugin;
            this.f139003d = i3;
            this.f139004e = z16;
            this.f139005f = str;
            this.f139006g = str2;
            this.f139007h = z17;
            this.f139008i = valueCallback;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            ProgressDialog progressDialog = new ProgressDialog(this.f139001b);
            this.f139000a = progressDialog;
            progressDialog.setProgressStyle(0);
            this.f139000a.setMessage("\u5b89\u88c5\u4e2d");
            this.f139000a.setCancelable(false);
            this.f139000a.setCanceledOnTouchOutside(false);
            this.f139000a.setButton(-1, "\u5b8c\u6210", new a());
            this.f139000a.show();
            this.f139000a.getButton(-1).setVisibility(8);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            File file;
            try {
                boolean z16 = true;
                int availableVersion = this.f139002c.getAvailableVersion(true);
                int i3 = this.f139003d;
                if (i3 <= 0) {
                    i3 = 99999;
                    if (availableVersion >= 99999) {
                        i3 = availableVersion + 1;
                    }
                } else if (availableVersion > 0) {
                    String versionDir = this.f139002c.getVersionDir(availableVersion);
                    this.f139002c.setAvailableVersion(-1, true);
                    if (versionDir != null && !versionDir.isEmpty()) {
                        w.a(versionDir);
                    }
                }
                j0 j0Var = new j0();
                j0Var.f121684l = i3;
                j0Var.f121678f = false;
                j0Var.f121697y = this.f139002c.getDownloadFullPath(i3, false);
                file = new File(j0Var.f121697y);
                try {
                    if (this.f139004e) {
                        w.a(this.f139001b.getAssets().open(this.f139005f), file);
                    } else {
                        w.a(this.f139006g, file.getPath());
                    }
                    j0Var.f121676d = y.a(file.getPath());
                    j0Var.f121696x = true;
                    if (this.f139002c.performInstall(j0Var) != 0) {
                        z16 = false;
                    }
                    return Boolean.valueOf(z16);
                } catch (Exception e16) {
                    e = e16;
                    x0.c("XWebDebugPluginHelper", "loadZipFormatPluginFromLocal error: " + e);
                    if (file != null) {
                        w.a(file.getAbsolutePath());
                    }
                    return Boolean.FALSE;
                }
            } catch (Exception e17) {
                e = e17;
                file = null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                this.f139000a.setMessage("\u5b89\u88c5\u5b8c\u6210");
            } else {
                String str = this.f139004e ? "asset/" : "sdcard/apkxwebtest/";
                this.f139000a.setMessage("\u5b89\u88c5\u5931\u8d25\uff0c\u8bf7\u786e\u4fdd\u6587\u4ef6\u5b58\u5728: " + str + this.f139005f);
            }
            this.f139000a.getButton(-1).setVisibility(0);
            if (this.f139007h) {
                this.f139000a.hide();
            }
            ValueCallback valueCallback = this.f139008i;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(bool);
            }
        }
    }

    public static boolean a() {
        Iterator<XWalkPlugin> it = XWalkPluginManager.getAllPlugins().iterator();
        while (it.hasNext()) {
            it.next().setAvailableVersion(-1, true);
        }
        String b16 = u0.b();
        if (b16.isEmpty()) {
            return true;
        }
        return w.a(b16);
    }

    public static String b() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\n\n>>>>>> plugin info start >>>>>>");
        sb5.append("\n plugin config url = ");
        sb5.append(z0.d());
        sb5.append("\n plugin config period(minutes) = ");
        sb5.append(z0.e() / 60000);
        sb5.append("\n\n plugin version:");
        for (XWalkPlugin xWalkPlugin : XWalkPluginManager.getAllPlugins()) {
            if (xWalkPlugin != null) {
                sb5.append("\n ");
                sb5.append(xWalkPlugin.getPluginName());
                sb5.append(" = ");
                sb5.append(xWalkPlugin.getAvailableVersion(true));
            }
        }
        sb5.append("\n\n plugin commands:");
        String abstractInfo = CommandCfgPlugin.getInstance().getAbstractInfo();
        if (abstractInfo != null && !abstractInfo.isEmpty()) {
            sb5.append("\n");
            sb5.append(abstractInfo);
        } else {
            sb5.append("\n null\n");
        }
        sb5.append("\n\n xfiles setting:");
        if (WebDebugCfg.getInst() != null) {
            sb5.append("\n disable cache = ");
            sb5.append(WebDebugCfg.getInst().getDisableFileReaderCache());
            sb5.append("\n disable crash detect = ");
            sb5.append(WebDebugCfg.getInst().getDisableFileReaderCrashDetect());
        }
        sb5.append("\n\n plugin scheduler:");
        for (XWalkPlugin xWalkPlugin2 : XWalkPluginManager.getAllPlugins()) {
            if (xWalkPlugin2 != null) {
                XFileSchedulerFactory.XFileScheduler scheduler = XFileSchedulerFactory.getScheduler(xWalkPlugin2.getPluginName());
                sb5.append("\n ");
                sb5.append(scheduler.dumpSchedule());
            }
        }
        XFileSchedulerFactory.XFileScheduler xFileScheduler = new XFileSchedulerFactory.XFileScheduler("");
        sb5.append("\n plugin update match gap backward(update speed) = ");
        sb5.append(xFileScheduler.getCurHourSpeed(xFileScheduler.getCurHourSpeedConfig(false)));
        sb5.append("\n plugin update match gap forward(\u63d0\u524d\u66f4\u65b0) = ");
        sb5.append(xFileScheduler.getCurHourSpeed(xFileScheduler.getCurHourSpeedConfig(true)));
        sb5.append(c());
        sb5.append("\n<<<<<< plugin info end <<<<<<\n");
        return "" + sb5.toString();
    }

    public static String c() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\n\n file reader type:");
        for (String str : FileReaderHelper.ALL_FILE_FORMATS) {
            sb5.append("\n ");
            sb5.append(str);
            sb5.append(":");
            sb5.append("  cmd-tools-");
            sb5.append(CommandCfgPlugin.getInstance().getFileReaderType(str, "tools"));
            sb5.append("  cmd-appbrand-");
            sb5.append(CommandCfgPlugin.getInstance().getFileReaderType(str, "appbrand"));
        }
        sb5.append("\n\n use office reader:");
        for (String str2 : FileReaderHelper.OFFICE_READER_FORMATS) {
            sb5.append("\n ");
            sb5.append(str2);
            sb5.append(": force-");
            sb5.append(WebDebugCfg.getInst().getForceUseOfficeReader(str2));
            sb5.append("  cmd-tools-");
            sb5.append(CommandCfgPlugin.getInstance().getCmdUseOfficeReader(str2, "tools"));
            sb5.append("  cmd-appbrand-");
            sb5.append(CommandCfgPlugin.getInstance().getCmdUseOfficeReader(str2, "appbrand"));
            sb5.append("  cmd-mm-");
            sb5.append(CommandCfgPlugin.getInstance().getCmdUseOfficeReader(str2, "mm"));
        }
        return sb5.toString();
    }

    public static boolean a(String str) {
        XWalkPlugin plugin = XWalkPluginManager.getPlugin(str);
        if (plugin == null) {
            return false;
        }
        int availableVersion = plugin.getAvailableVersion(true);
        if (availableVersion < 0) {
            return true;
        }
        String versionDir = plugin.getVersionDir(availableVersion);
        plugin.setAvailableVersion(-1, true);
        if (versionDir == null || versionDir.isEmpty()) {
            return false;
        }
        return w.a(versionDir);
    }

    public static boolean a(Context context, String str, String str2, boolean z16) {
        if (!"all".equalsIgnoreCase(str) && !TextUtils.isEmpty(str)) {
            if (XWalkPluginManager.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO.equalsIgnoreCase(str)) {
                a(context, XWalkPluginManager.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO, z16, false, null);
                return true;
            }
            if (XWalkPluginManager.XWALK_PLUGIN_NAME_PDF.equalsIgnoreCase(str)) {
                a(context, XWalkPluginManager.XWALK_PLUGIN_NAME_PDF, z16, false, null);
                return true;
            }
            if (XWalkPluginManager.XWALK_PLUGIN_NAME_PPT.equalsIgnoreCase(str)) {
                a(context, XWalkPluginManager.XWALK_PLUGIN_NAME_PPT, z16, false, null);
                return true;
            }
            if (XWalkPluginManager.XWALK_PLUGIN_NAME_WORD.equalsIgnoreCase(str)) {
                a(context, XWalkPluginManager.XWALK_PLUGIN_NAME_WORD, z16, false, null);
                return true;
            }
            if (XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL.equalsIgnoreCase(str)) {
                a(context, XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL, z16, false, null);
                return true;
            }
            if (XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE.equalsIgnoreCase(str)) {
                a(context, XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE, z16, false, null);
                return true;
            }
            if (XWalkPluginManager.XWALK_PLUGIN_NAME_TXT.equalsIgnoreCase(str)) {
                a(context, XWalkPluginManager.XWALK_PLUGIN_NAME_TXT, z16, false, null);
                return true;
            }
            p0.a(context, "\u68c0\u6d4b\u63d2\u4ef6\u66f4\u65b0\u5931\u8d25\uff0c\u53c2\u6570\u9519\u8bef", z16);
            return false;
        }
        p0.a(context, "\u5f00\u59cb\u68c0\u6d4b\u6240\u6709\u63d2\u4ef6\u66f4\u65b0", false);
        XWebSdk.setForceCheckUpdate();
        XWalkPluginUpdater xWalkPluginUpdater = new XWalkPluginUpdater();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ConstValue.XWEB_UPDATER_START_CHECK_TYPE, str2);
        xWalkPluginUpdater.startCheck(context, hashMap);
        return true;
    }

    public static boolean b(Context context, String str, boolean z16, boolean z17, ValueCallback valueCallback) {
        return a(context, str, -1, z16, z17, false, valueCallback);
    }

    public static void a(Context context, String str, boolean z16, boolean z17, ValueCallback valueCallback) {
        XWalkPluginUpdater xWalkPluginUpdater = new XWalkPluginUpdater();
        xWalkPluginUpdater.setPluginOnlyOneToUpdate(str, new a(str, z16, context, xWalkPluginUpdater, z17, valueCallback));
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ConstValue.XWEB_UPDATER_START_CHECK_TYPE, "1");
        xWalkPluginUpdater.startCheck(context, hashMap);
    }

    public static com.tencent.luggage.wxa.qq.a a(Context context, String str) {
        FileReaderHelper.UseOfficeReader useOfficeReader;
        String[] strArr;
        if (TextUtils.isEmpty(str)) {
            p0.a(context, "\u5f3a\u5236\u8bbe\u7f6eOfficeReader\u5931\u8d25\uff0c\u53c2\u6570\u4e3a\u7a7a", false);
            return com.tencent.luggage.wxa.qq.a.a();
        }
        String[] split = str.split("_");
        if (str.length() < 2) {
            p0.a(context, "\u5f3a\u5236\u8bbe\u7f6eOfficeReader\u5931\u8d25\uff0c\u53c2\u6570\u9519\u8bef", false);
            return com.tencent.luggage.wxa.qq.a.a();
        }
        String str2 = split[split.length - 1];
        if ("yes".equalsIgnoreCase(str2)) {
            useOfficeReader = FileReaderHelper.UseOfficeReader.yes;
        } else if ("no".equalsIgnoreCase(str2)) {
            useOfficeReader = FileReaderHelper.UseOfficeReader.no;
        } else if ("none".equalsIgnoreCase(str2)) {
            useOfficeReader = FileReaderHelper.UseOfficeReader.none;
        } else {
            p0.a(context, "\u5f3a\u5236\u8bbe\u7f6eOfficeReader\u5931\u8d25\uff0c\u7c7b\u578b\u9519\u8bef", false);
            return com.tencent.luggage.wxa.qq.a.a();
        }
        if (split.length == 2 && "all".equalsIgnoreCase(split[0])) {
            strArr = FileReaderHelper.OFFICE_READER_FORMATS;
        } else {
            String[] strArr2 = new String[split.length - 1];
            for (int i3 = 0; i3 < split.length - 1; i3++) {
                strArr2[i3] = split[i3];
            }
            strArr = strArr2;
        }
        String forceUseOfficeReader = WebDebugCfg.getInst().setForceUseOfficeReader(strArr, useOfficeReader);
        if (!forceUseOfficeReader.isEmpty()) {
            p0.a(context, "\u683c\u5f0f:" + forceUseOfficeReader + "\u5f3a\u5236OfficeReader\u72b6\u6001:" + useOfficeReader, false);
            return com.tencent.luggage.wxa.qq.a.b();
        }
        p0.a(context, "\u5f3a\u5236\u8bbe\u7f6eOfficeReader\u5931\u8d25", false);
        return com.tencent.luggage.wxa.qq.a.a();
    }

    public static boolean a(String str, FileReaderHelper.UseOfficeReader useOfficeReader) {
        if (WebDebugCfg.getInst() == null) {
            x0.f("XWebDebugPluginHelper", "forceUseOfficeReader, WebDebugCfg.getInst is null");
            return false;
        }
        String[] strArr = (str == null || str.isEmpty() || "all".equalsIgnoreCase(str)) ? FileReaderHelper.OFFICE_READER_FORMATS : new String[]{str};
        String forceUseOfficeReader = WebDebugCfg.getInst().setForceUseOfficeReader(strArr, useOfficeReader);
        x0.d("XWebDebugPluginHelper", "forceUseOfficeReader, result:" + forceUseOfficeReader + ", useOfficeReader:" + useOfficeReader + ", ext:" + str);
        if (forceUseOfficeReader.isEmpty()) {
            return false;
        }
        FileReaderCrashDetector.resetCrashInfo(strArr);
        return true;
    }

    public static boolean a(Context context, String str, int i3, boolean z16, boolean z17, boolean z18, ValueCallback valueCallback) {
        File file = new File(Environment.getExternalStorageDirectory().getPath());
        if (file.listFiles() == null) {
            Toast.makeText(context, "\u8bf7\u786e\u8ba4\u5e94\u7528\u6743\u9650\uff0c\u5728\u6743\u9650\u7ba1\u7406\u6253\u5f00\u5e94\u7528\u7684\u8bfb\u5199\u5b58\u50a8\u6743\u9650", 0).show();
            valueCallback.onReceiveValue(Boolean.FALSE);
            return false;
        }
        XWalkPlugin plugin = XWalkPluginManager.getPlugin(str);
        if (plugin == null) {
            Toast.makeText(context, "\u627e\u4e0d\u5230\u5bf9\u5e94\u63d2\u4ef6", 0).show();
            valueCallback.onReceiveValue(Boolean.FALSE);
            return false;
        }
        String a16 = a(str, z17);
        new b(context, plugin, i3, z16, a16, file.getPath() + "/apkxwebtest/" + a16, z18, valueCallback).execute(new Void[0]);
        return true;
    }

    public static String a(String str, boolean z16) {
        return XWalkPluginManager.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO.equals(str) ? XWalkFullScreenVideoPlugin.FULLSCREEN_VIDEO_JS_FILENAME : XWalkPluginManager.XWALK_PLUGIN_NAME_PPT.equals(str) ? "xfiles_ppt_reader.zip" : XWalkPluginManager.XWALK_PLUGIN_NAME_PDF.equals(str) ? z16 ? "xfiles_pdf_reader_arm64.zip" : "xfiles_pdf_reader_arm.zip" : XWalkPluginManager.XWALK_PLUGIN_NAME_WORD.equals(str) ? z16 ? "xfiles_word_reader_arm64.zip" : "xfiles_word_reader_arm.zip" : XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL.equals(str) ? "xfiles_excel_reader.zip" : XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE.equals(str) ? z16 ? "xfiles_office_reader_arm64.zip" : "xfiles_office_reader_arm.zip" : XWalkPluginManager.XWALK_PLUGIN_NAME_TXT.equals(str) ? "xfiles_txt_reader.zip" : "";
    }
}
