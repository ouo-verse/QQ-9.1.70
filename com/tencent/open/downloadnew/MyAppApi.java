package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.YybUpgradeDialog;
import com.tencent.mobileqq.upgrade.k;
import com.tencent.mobileqq.utils.dx;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.k;
import com.tencent.open.business.base.appreport.AppReportReceiver;
import com.tencent.open.downloadnew.YybHandleUtil;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.OuterCallLog;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.Foreground;
import mqq.app.NewIntent;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MyAppApi extends com.tencent.open.downloadnew.c {

    /* renamed from: v, reason: collision with root package name */
    protected static MyAppApi f341276v;

    /* renamed from: a, reason: collision with root package name */
    protected TMAssistantBaseCallYYB f341277a;

    /* renamed from: e, reason: collision with root package name */
    protected long f341281e;

    /* renamed from: h, reason: collision with root package name */
    protected DialogInterface.OnClickListener f341284h;

    /* renamed from: i, reason: collision with root package name */
    protected h f341285i;

    /* renamed from: j, reason: collision with root package name */
    protected MyAppDialog f341286j;

    /* renamed from: l, reason: collision with root package name */
    protected long f341288l;

    /* renamed from: p, reason: collision with root package name */
    protected TMAssistantCallYYBParamStruct f341292p;

    /* renamed from: q, reason: collision with root package name */
    TMAssistantCallYYBParamStruct f341293q;

    /* renamed from: b, reason: collision with root package name */
    protected ITMAssistantCallBackListener f341278b = new QQDownloadListener();

    /* renamed from: c, reason: collision with root package name */
    protected boolean f341279c = false;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f341280d = false;

    /* renamed from: f, reason: collision with root package name */
    protected long f341282f = -1;

    /* renamed from: g, reason: collision with root package name */
    protected final long f341283g = 180000;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f341287k = false;

    /* renamed from: m, reason: collision with root package name */
    boolean f341289m = false;

    /* renamed from: n, reason: collision with root package name */
    String f341290n = "";

    /* renamed from: o, reason: collision with root package name */
    protected boolean f341291o = false;

    /* renamed from: r, reason: collision with root package name */
    protected YYBDownloadListener f341294r = null;

    /* renamed from: s, reason: collision with root package name */
    private boolean f341295s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f341296t = false;

    /* renamed from: u, reason: collision with root package name */
    private final int f341297u = 7090000;

    /* compiled from: P */
    /* renamed from: com.tencent.open.downloadnew.MyAppApi$3, reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (MyAppApi.e()) {
                if (TMAssistantCallYYB_V2.getInstance().getIPCInterface() == null) {
                    com.tencent.open.base.f.e("TAMST_WAKE", "getIPCInterface() == null");
                    int qQDownloaderVersionCode = GlobalUtil.getInstance().getQQDownloaderVersionCode();
                    OuterCallReportModel f16 = MyAppApi.f();
                    if (qQDownloaderVersionCode >= 7172130) {
                        com.tencent.open.base.f.e("TAMST_WAKE", "YYB version code:" + qQDownloaderVersionCode + ",use new wake!");
                        Intent intent = new Intent();
                        intent.setClassName(SDKConst.SELF_PACKAGENAME, JefsClass.LIVE_PUSH_PUSHACTIVITY);
                        intent.putExtra("from", com.tencent.open.adapter.a.f().e().getPackageName());
                        intent.putExtra("via", "CALL_LIVE_QQ");
                        intent.addFlags(268435456);
                        try {
                            com.tencent.open.adapter.a.f().e().startActivity(intent);
                            f16.mComponentName = JefsClass.LIVE_PUSH_PUSHACTIVITY;
                        } catch (ActivityNotFoundException e16) {
                            com.tencent.open.base.f.c("TAMST_WAKE", "activity not found error:" + e16.getMessage());
                        } catch (SecurityException unused) {
                        }
                    } else {
                        com.tencent.open.base.f.e("TAMST_WAKE", "YYB version code:" + qQDownloaderVersionCode + ",use old wake!");
                    }
                    MyAppApi.Z(f16);
                    com.tencent.open.downloadnew.d.x();
                } else {
                    com.tencent.open.base.f.e("TAMST_WAKE", "don't need tmast wake");
                }
            } else {
                com.tencent.open.base.f.e("TAMST_WAKE", "can not do tmast!");
            }
            com.tencent.open.base.f.a("TAMST_WAKE", "costTime = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    protected class QQDownloadListener implements ITMAssistantCallBackListener {
        protected QQDownloadListener() {
        }

        @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
        public void onDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, long j3, long j16) {
            MyAppApi.this.f341296t = true;
            com.tencent.open.base.f.e("MyAppApi", "onDownloadTaskProgressChanged  receiveDataLen:" + j3 + ",totalDataLen:" + j16);
            int i3 = (int) ((((float) j3) * 100.0f) / ((float) j16));
            DownloadManager C = DownloadManager.C();
            DownloadInfo w3 = C.w(tMAssistantCallYYBParamStruct.SNGAppId);
            if (w3 == null) {
                w3 = MyAppApi.this.s(tMAssistantCallYYBParamStruct, null);
                C.e(w3);
            }
            w3.Q = i3;
            w3.k(2);
            C.K(2, w3);
            DownloadManagerV2.V().l0(tMAssistantCallYYBParamStruct, i3);
            com.tencent.open.base.f.h("MyAppApi", "onDownloadTaskProgressChanged info state=" + w3.f() + " progress=" + w3.Q);
        }

        @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
        public void onDownloadTaskStateChanged(final TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, final int i3, final int i16, final String str) {
            MyAppApi myAppApi = MyAppApi.this;
            myAppApi.f341280d = true;
            myAppApi.f341296t = true;
            com.tencent.open.base.f.e("MyAppApi", "onDownloadTaskStateChanged");
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (tMAssistantCallYYBParamStruct != null) {
                        com.tencent.open.base.f.h("State_Log", "OpenSDK onDownloadTaskStateChanged state=" + i3 + " errorCode=" + i16 + " param SNGAppId=" + tMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + tMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + tMAssistantCallYYBParamStruct.taskAppId + " packageName=" + tMAssistantCallYYBParamStruct.taskPackageName + " version=" + tMAssistantCallYYBParamStruct.taskVersion + " uin=" + tMAssistantCallYYBParamStruct.uin + " via=" + tMAssistantCallYYBParamStruct.via);
                        int o16 = DownloadManager.o(i3);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("onDownloadTaskStateChanged--localState = ");
                        sb5.append(o16);
                        sb5.append("state = ");
                        sb5.append(i3);
                        sb5.append("errorCode = ");
                        sb5.append(i16);
                        com.tencent.open.base.f.a("State_Log", sb5.toString());
                        DownloadManager C = DownloadManager.C();
                        DownloadInfo n06 = C.n0(tMAssistantCallYYBParamStruct.SNGAppId, o16);
                        TMAssistantCallYYBTaskInfo tMAssistantCallYYBTaskInfo = null;
                        if (n06 == null && i3 != 6) {
                            n06 = MyAppApi.this.s(tMAssistantCallYYBParamStruct, null);
                            C.e(n06);
                            C.n0(tMAssistantCallYYBParamStruct.SNGAppId, o16);
                        } else {
                            int i17 = i3;
                            if ((i17 == 2 || i17 == 3) && MyAppApi.this.R()) {
                                try {
                                    tMAssistantCallYYBTaskInfo = MyAppApi.this.x().getDownloadTaskState(tMAssistantCallYYBParamStruct);
                                    if (tMAssistantCallYYBTaskInfo != null) {
                                        int i18 = (int) ((((float) tMAssistantCallYYBTaskInfo.mReceiveDataLen) * 100.0f) / ((float) tMAssistantCallYYBTaskInfo.mTotalDataLen));
                                        if (n06 != null) {
                                            n06.Q = i18;
                                        }
                                        com.tencent.open.base.f.h("MyAppApi", "onDownloadTaskStateChanged info progress = " + i18);
                                    }
                                } catch (Exception e16) {
                                    com.tencent.open.base.f.d("MyAppApi", "getDownloadTaskState>>>", e16);
                                }
                            }
                        }
                        TMAssistantCallYYBTaskInfo tMAssistantCallYYBTaskInfo2 = tMAssistantCallYYBTaskInfo;
                        if (n06 != null) {
                            com.tencent.open.base.f.a("State_Log", "onDownloadTaskStateChanged notifyListener localState=" + o16 + " dlInfo=" + n06.toString());
                            C.L(o16, n06, i16, str);
                        } else {
                            com.tencent.open.base.f.a("MyAppApi", "onDownloadTaskStateChanged notifyListener error dlInfo == null");
                        }
                        DownloadManagerV2.V().m0(tMAssistantCallYYBParamStruct, i3, tMAssistantCallYYBTaskInfo2, i16, str);
                        return;
                    }
                    com.tencent.open.base.f.h("State_Log", "OpenSDK onDownloadTaskStateChanged state=" + i3 + " errorCode=" + i16 + " param== null");
                }
            });
        }

        @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
        public void onQQDownloaderInvalid() {
            com.tencent.open.base.f.e("MyAppApi", HardCodeUtil.qqStr(R.string.ocu));
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.2
                @Override // java.lang.Runnable
                public void run() {
                    DownloadManager.C().S();
                }
            });
        }

        @Override // com.tencent.tmassistantsdk.ITMAssistantCallBackListener
        public void onServiceFree() {
            com.tencent.open.base.f.e("MyAppApi", "OnServiceFree");
            try {
                ((TMAssistantCallYYB_V2) MyAppApi.this.f341277a).releaseIPCConnected();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            MyAppApi myAppApi = MyAppApi.this;
            myAppApi.f341286j = null;
            myAppApi.f341287k = false;
            myAppApi.f341287k = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f341374d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f341375e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f341376f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f341377h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f341378i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f341379m;

        b(Bundle bundle, boolean z16, Activity activity, String str, DialogInterface.OnClickListener onClickListener, String str2) {
            this.f341374d = bundle;
            this.f341375e = z16;
            this.f341376f = activity;
            this.f341377h = str;
            this.f341378i = onClickListener;
            this.f341379m = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            com.tencent.open.base.f.a("MyAppApi", "---onConfirm--onClick");
            if (!MyAppApi.G()) {
                MyAppApi myAppApi = MyAppApi.this;
                myAppApi.f341285i = new h();
                MyAppApi myAppApi2 = MyAppApi.this;
                h hVar = myAppApi2.f341285i;
                hVar.f341397b = true;
                hVar.f341398c = true;
                hVar.f341399d = null;
                hVar.f341396a = this.f341374d;
                hVar.f341400e = 2;
                if (this.f341375e) {
                    myAppApi2.r(this.f341376f, this.f341377h, 0, "", "");
                } else {
                    MyAppApi myAppApi3 = MyAppApi.this;
                    new g(this.f341376f, myAppApi3.f341285i).execute(new Void[0]);
                }
            } else {
                MyAppApi.this.p0(this.f341376f, this.f341378i);
            }
            MyAppApi.this.f341287k = true;
            com.tencent.open.business.base.e.d(ThemeReporter.FROM_DIY, com.tencent.open.business.base.e.c(this.f341377h, "NEWYYB"), this.f341379m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.tencent.open.base.f.a("MyAppApi", "onReceive ---INTENT = " + intent);
            if (intent != null && intent.getAction().equals(NewIntent.ACTION_ACCOUNT_EXPIRED)) {
                MyAppApi.this.f0();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class d implements DialogInterface.OnClickListener {
        final /* synthetic */ String C;
        final /* synthetic */ String D;
        final /* synthetic */ boolean E;
        final /* synthetic */ boolean F;
        final /* synthetic */ int G;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f341381d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f341382e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bundle f341383f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f341384h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f341385i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Activity f341386m;

        d(boolean z16, DialogInterface.OnClickListener onClickListener, Bundle bundle, int i3, boolean z17, Activity activity, String str, String str2, boolean z18, boolean z19, int i16) {
            this.f341381d = z16;
            this.f341382e = onClickListener;
            this.f341383f = bundle;
            this.f341384h = i3;
            this.f341385i = z17;
            this.f341386m = activity;
            this.C = str;
            this.D = str2;
            this.E = z18;
            this.F = z19;
            this.G = i16;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            com.tencent.open.base.f.a("MyAppApi", "---onConfirm--onClick");
            if (!MyAppApi.G()) {
                MyAppApi myAppApi = MyAppApi.this;
                myAppApi.f341285i = new h();
                h hVar = MyAppApi.this.f341285i;
                hVar.f341397b = this.f341381d;
                hVar.f341398c = true;
                hVar.f341399d = this.f341382e;
                Bundle bundle = this.f341383f;
                hVar.f341396a = bundle;
                hVar.f341400e = this.f341384h;
                if (this.f341385i) {
                    MyAppApi.this.r(this.f341386m, this.C, 0, this.D, bundle.getString(com.tencent.open.downloadnew.e.f341508q));
                    MyAppDialog myAppDialog = MyAppApi.this.f341286j;
                    if (myAppDialog != null && myAppDialog.isShowing()) {
                        MyAppApi.this.f341286j.Y(0, 1);
                    }
                } else {
                    MyAppApi myAppApi2 = MyAppApi.this;
                    new g(this.f341386m, myAppApi2.f341285i).execute(new Void[0]);
                }
            } else {
                if (!com.tencent.open.downloadnew.d.i() && !this.E) {
                    DialogInterface.OnClickListener onClickListener = this.f341382e;
                    if (onClickListener != null) {
                        onClickListener.onClick(null, 0);
                    }
                } else if (this.f341384h == 0) {
                    MyAppApi.this.n0(this.f341386m, this.f341383f, this.f341381d, this.F);
                } else {
                    MyAppApi.this.r0(this.f341386m, this.f341383f, this.f341381d, this.F);
                }
                MyAppDialog myAppDialog2 = MyAppApi.this.f341286j;
                if (myAppDialog2 != null && myAppDialog2.isShowing()) {
                    MyAppApi.this.f341286j.dismiss();
                }
            }
            String str = this.f341383f.getString(com.tencent.open.downloadnew.e.f341497f) + "_" + this.f341383f.getString(com.tencent.open.downloadnew.e.f341494c) + "_" + this.f341383f.getString(com.tencent.open.downloadnew.e.f341495d);
            MyAppApi.this.f341287k = true;
            com.tencent.open.business.base.e.d(ThemeReporter.FROM_DIY, com.tencent.open.business.base.e.c(this.C, "NEWYYB"), this.D);
            np3.a.g().j(25, (System.currentTimeMillis() / 1000) + "|100|" + str);
            ReportController.o(null, "dc00898", "", "", "0X8008F7D", "0X8008F7D", 0, 0, "", "", "", "");
            if (this.G == 1) {
                AppCenterReporter.p("6006", "1", "0", this.C, this.f341383f.getString("pageId") + "_" + this.f341383f.getString("moduleId") + "_" + this.f341383f.getString(com.tencent.open.downloadnew.e.f341497f) + "_" + this.f341383f.getString(com.tencent.open.downloadnew.e.f341494c) + "_" + this.f341383f.getString(com.tencent.open.downloadnew.e.f341495d));
            }
            if ("ANDROID.QQ.YYBXZGAMECENTER".equals(this.C) || "ANDROID.QQ.NEWYYBXZGAMECENTER".equals(this.C)) {
                hl0.a.b(null, "765", "205010", this.D, "76501", "1", "156");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        String f341387d;

        /* renamed from: e, reason: collision with root package name */
        String f341388e;

        public e(String str, String str2) {
            this.f341387d = com.tencent.open.business.base.e.c(str, "NEWYYB");
            this.f341388e = str2;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MyAppApi.this.X(this.f341388e);
            com.tencent.open.business.base.e.d("720", this.f341387d, this.f341388e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        DialogInterface.OnClickListener f341390d;

        /* renamed from: e, reason: collision with root package name */
        String f341391e;

        /* renamed from: f, reason: collision with root package name */
        String f341392f;

        public f(DialogInterface.OnClickListener onClickListener, String str, String str2) {
            this.f341390d = onClickListener;
            this.f341391e = com.tencent.open.business.base.e.c(str, "NEWYYB");
            this.f341392f = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DialogInterface.OnClickListener onClickListener = this.f341390d;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            MyAppApi myAppApi = MyAppApi.this;
            myAppApi.f341284h = null;
            myAppApi.f341285i = null;
            com.tencent.open.business.base.e.d("710", this.f341391e, this.f341392f);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    protected class g extends YybHandleUtil.a {

        /* renamed from: d, reason: collision with root package name */
        h f341394d;

        public g(Activity activity, h hVar) {
            super(activity);
            this.f341394d = hVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.open.downloadnew.YybHandleUtil.a, android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            long j3;
            Bundle bundle;
            a();
            if (bool.booleanValue()) {
                if (YybHandleUtil.c()) {
                    MyAppApi myAppApi = MyAppApi.this;
                    myAppApi.f341279c = true;
                    myAppApi.f341280d = false;
                    h hVar = this.f341394d;
                    int i3 = hVar.f341400e;
                    if (i3 != 0) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                j3 = myAppApi.k(hVar.f341396a, hVar.f341397b, hVar.f341398c);
                            } else {
                                j3 = myAppApi.m(hVar.f341396a);
                            }
                        } else {
                            myAppApi.f341291o = true;
                            if (myAppApi.f341292p != null) {
                                j3 = myAppApi.x().addDownloadTaskFromAuthorize(MyAppApi.this.f341292p, "2");
                            } else {
                                com.tencent.open.base.f.c("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
                                j3 = -1;
                            }
                        }
                    } else {
                        j3 = myAppApi.j(hVar.f341396a, hVar.f341397b, hVar.f341398c);
                    }
                    MyAppApi myAppApi2 = MyAppApi.this;
                    myAppApi2.f341281e = j3;
                    myAppApi2.f341282f = System.currentTimeMillis();
                    if (bool.booleanValue() && (bundle = this.f341394d.f341396a) != null) {
                        String c16 = com.tencent.open.business.base.e.c(bundle.getString(com.tencent.open.downloadnew.e.f341500i), "NEWYYB");
                        com.tencent.open.business.base.e.d("311", c16, this.f341394d.f341396a.getString(com.tencent.open.downloadnew.e.f341493b));
                        Context e16 = com.tencent.open.adapter.a.f().e();
                        if (e16 != null) {
                            com.tencent.open.business.base.e.j(e16, "312", c16, this.f341394d.f341396a.getString(com.tencent.open.downloadnew.e.f341493b));
                        }
                    }
                    MyAppDialog myAppDialog = MyAppApi.this.f341286j;
                    if (myAppDialog != null && myAppDialog.isShowing()) {
                        MyAppApi.this.f341286j.dismiss();
                        return;
                    }
                    return;
                }
                DialogInterface.OnClickListener onClickListener = this.f341394d.f341399d;
                if (onClickListener != null) {
                    onClickListener.onClick(null, 0);
                }
                MyAppApi.this.f341284h = null;
                return;
            }
            DialogInterface.OnClickListener onClickListener2 = this.f341394d.f341399d;
            if (onClickListener2 != null) {
                onClickListener2.onClick(null, 0);
            }
            MyAppApi.this.f341284h = null;
        }

        @Override // com.tencent.open.downloadnew.YybHandleUtil.a, android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
            DialogInterface.OnClickListener onClickListener = this.f341394d.f341399d;
            if (onClickListener != null) {
                onClickListener.onClick(null, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class h {

        /* renamed from: a, reason: collision with root package name */
        Bundle f341396a;

        /* renamed from: b, reason: collision with root package name */
        boolean f341397b;

        /* renamed from: c, reason: collision with root package name */
        boolean f341398c;

        /* renamed from: d, reason: collision with root package name */
        DialogInterface.OnClickListener f341399d;

        /* renamed from: e, reason: collision with root package name */
        int f341400e;

        protected h() {
        }
    }

    protected MyAppApi() {
        try {
            K();
        } catch (Throwable th5) {
            com.tencent.open.base.f.d("MyAppApi", "MyAppApi init>>>", th5);
        }
        I();
        d0();
        c0();
    }

    @NonNull
    private static OuterCallReportModel B() {
        OuterCallReportModel defaultModel = OuterCallReportModel.getDefaultModel();
        defaultModel.mOuterCallMode = 0;
        defaultModel.mOuterCallType = 1;
        defaultModel.mOuterCallTime = System.currentTimeMillis();
        defaultModel.mComponentName = "SplashActivity";
        return defaultModel;
    }

    public static int C() {
        return TMAssistantBaseCallYYB.getQQDownloadApiLevel(BaseApplicationImpl.getApplication());
    }

    public static synchronized boolean F() {
        boolean z16;
        synchronized (MyAppApi.class) {
            if (f341276v != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public static boolean G() {
        try {
            int p16 = p();
            if (p16 == 2 || p16 == 1) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            com.tencent.open.base.f.d("MyAppApi", "hasValidQQDownloader>>>", e16);
            return false;
        }
    }

    public static void I() {
        com.tencent.open.downloadnew.d.q();
    }

    private static boolean M() {
        if (N() && com.tencent.open.downloadnew.d.l() && Q()) {
            return true;
        }
        return false;
    }

    private static boolean N() {
        return false;
    }

    public static boolean O() {
        return "com.tencent.mobileqq".equals(BaseApplicationImpl.getApplication().getQQProcessName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.f341184e.startsWith("1101070898")) {
            return true;
        }
        return false;
    }

    private static boolean Q() {
        if (!Foreground.isCurrentProcessForeground() && !com.tencent.open.downloadnew.d.k()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Z(OuterCallReportModel outerCallReportModel) {
        GlobalUtil.getInstance().setContext(com.tencent.open.adapter.a.f().e());
        SDKReportManager2.getInstance().postReport(15, outerCallReportModel.toString());
    }

    public static void b0() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.open.base.f.a("MyAppApi", "MyAppApi init>>> preInit");
                    if (!com.tencent.open.downloadnew.d.m()) {
                        return;
                    }
                    GlobalUtil.getInstance().setContext(com.tencent.open.adapter.a.f().e());
                    if (MyAppApi.g()) {
                        MyAppApi.u0();
                    }
                } catch (Exception e16) {
                    com.tencent.open.base.f.c("TAMST_WAKE", "activity not found error:" + e16.getMessage());
                }
            }
        });
    }

    private void c0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        com.tencent.open.adapter.a.f().e().registerReceiver(new AppReportReceiver(), intentFilter);
    }

    static /* bridge */ /* synthetic */ boolean e() {
        return o();
    }

    static /* bridge */ /* synthetic */ OuterCallReportModel f() {
        return B();
    }

    static /* bridge */ /* synthetic */ boolean g() {
        return M();
    }

    public static void m0() {
        I();
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.1
            @Override // java.lang.Runnable
            public void run() {
                MyAppApi.b0();
            }
        }, 16, null, true, 5000L);
    }

    private static boolean o() {
        if (com.tencent.open.downloadnew.d.h() && TMAssistantBaseCallYYB.getQQDownloadApiLevel(com.tencent.open.adapter.a.f().e()) >= 7) {
            return true;
        }
        return false;
    }

    public static int p() {
        PackageManager packageManager;
        Context e16 = com.tencent.open.adapter.a.f().e();
        if (e16 == null || (packageManager = e16.getPackageManager()) == null) {
            return 1;
        }
        try {
            if (InstalledAppListMonitor.getPackageInfo(packageManager, SDKConst.SELF_PACKAGENAME, 0) == null) {
                return 1;
            }
            if (2 <= GlobalUtil.getInstance().getQQDownloaderAPILevel()) {
                return 0;
            }
            return 2;
        } catch (PackageManager.NameNotFoundException e17) {
            com.tencent.open.base.f.c("TAMST_WAKE", "yyb installed check error:" + e17.getMessage());
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u0() {
        com.tencent.open.downloadnew.h.c().f();
        OuterCallReportModel B = B();
        B.mComponentName = "com.live.watermelon.Instrumentation";
        Z(B);
    }

    @NotNull
    private String w(String str) {
        if (TextUtils.isEmpty(str)) {
            return "1101070898";
        }
        return "1101070898_" + str;
    }

    public static MyAppApi z() {
        if (f341276v == null) {
            synchronized (MyAppApi.class) {
                if (f341276v == null) {
                    f341276v = new MyAppApi();
                }
            }
        }
        b0();
        return f341276v;
    }

    protected int A(Bundle bundle) {
        if (bundle != null && bundle.getInt(com.tencent.open.downloadnew.e.f341502k) == 3) {
            return 2;
        }
        return 1;
    }

    public void D(final Activity activity, final Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        int i3;
        boolean z16;
        final String str;
        int i16;
        com.tencent.open.base.f.a("TIME-STATISTIC", "MyAppApi--handleDownloadAction");
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(activity) >= 6) {
            bundle.putLong(OuterCallLog.OuterCall_MyAppApi_HandleDownloadAction, System.currentTimeMillis());
        }
        try {
            i3 = x().checkQQDownloaderInstalled();
        } catch (Exception e16) {
            e16.printStackTrace();
            i3 = -1;
        }
        boolean z17 = bundle.getBoolean(com.tencent.open.downloadnew.e.f341498g, false);
        boolean z18 = bundle.getBoolean(com.tencent.open.downloadnew.e.f341499h, true);
        int i17 = bundle.getInt(com.tencent.open.downloadnew.e.f341505n);
        final int i18 = bundle.getInt(com.tencent.open.downloadnew.e.f341502k);
        final String string = bundle.getString(com.tencent.open.downloadnew.e.f341500i);
        final String string2 = bundle.getString(com.tencent.open.downloadnew.e.f341493b);
        int i19 = bundle.getInt("dialogType");
        int i26 = bundle.getInt(com.tencent.open.downloadnew.e.f341512u, 0);
        int i27 = bundle.getInt(com.tencent.open.downloadnew.e.f341513v, 0);
        boolean u16 = com.tencent.open.downloadnew.d.u();
        boolean d16 = com.tencent.open.downloadnew.d.d();
        com.tencent.open.base.f.a("OpenConfig-MyAppApi", " useMyAppFlag = " + u16);
        DownloadInfo w3 = DownloadManager.C().w(string2);
        if (w3 != null && w3.J == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((!u16 || !d16) && !z16) {
            if (onClickListener != null) {
                com.tencent.open.base.f.h("MyAppApi", "allowMyApp=" + u16 + " allowMyAppDownload=" + d16 + " taskExist=" + z16);
                onClickListener.onClick(null, 0);
            }
            com.tencent.open.business.base.e.d("200", string, string2);
            return;
        }
        if (i3 != 2 && i3 != 1) {
            if (i3 == 0) {
                if (!com.tencent.open.downloadnew.d.i() && !z16) {
                    if (onClickListener != null) {
                        onClickListener.onClick(null, 0);
                    }
                    com.tencent.open.business.base.e.d("200", string, string2);
                    return;
                }
                String c16 = com.tencent.open.business.base.e.c(string, "YYB");
                if (i17 == 0) {
                    n0(activity, bundle, z17, z18);
                } else {
                    r0(activity, bundle, z17, z18);
                }
                if (w3 == null && (i18 == 2 || i18 == 12)) {
                    com.tencent.open.business.base.e.d(ThemeReporter.FROM_NIGHT, c16, string2);
                    return;
                } else {
                    com.tencent.open.business.base.e.d("200", c16, string2);
                    return;
                }
            }
            return;
        }
        MyAppDialog myAppDialog = this.f341286j;
        if (myAppDialog != null && myAppDialog.isShowing()) {
            if (this.f341286j.N() == activity) {
                com.tencent.open.base.f.h("MyAppApi", "mTipDialog is showing return");
                return;
            } else {
                try {
                    this.f341286j.dismiss();
                } catch (Exception unused) {
                }
                this.f341286j = null;
            }
        } else {
            this.f341286j = null;
        }
        if (com.tencent.open.downloadnew.d.g() && (i18 == 2 || i18 == 12)) {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.7
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.open.business.base.e.d(ThemeReporter.FROM_NIGHT, com.tencent.open.business.base.e.c(string, "NEWYYB"), string2);
                }
            });
            final boolean s16 = com.tencent.open.downloadnew.d.s();
            final d dVar = new d(z17, onClickListener, bundle, i17, s16, activity, string, string2, z16, z18, i19);
            final f fVar = new f(onClickListener, string, string2);
            final e eVar = new e(string, string2);
            if (i27 > 0 && i26 > 0 && (i16 = i27 - i26) > 0) {
                str = YybHandleUtil.a(i16);
            } else {
                str = null;
            }
            final String string3 = bundle.getString("source");
            final int i28 = i3;
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.9
                @Override // java.lang.Runnable
                public void run() {
                    MyAppApi.this.i0(activity, i18, i28, str, dVar, fVar, eVar, string3, s16, bundle);
                }
            });
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.10
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.open.business.base.e.d("100", com.tencent.open.business.base.e.c(string, "NEWYYB"), string2);
                    com.tencent.open.downloadnew.d.b();
                    if ("ANDROID.QQ.YYBXZGAMECENTER".equals(string) || "ANDROID.QQ.NEWYYBXZGAMECENTER".equals(string)) {
                        hl0.a.b(null, "765", "205008", string2, "76501", "1", "156");
                    }
                }
            });
            this.f341284h = onClickListener;
            return;
        }
        com.tencent.open.base.f.h("MyAppApi", "not allowShowDialog return actionCode = " + i18);
        if (onClickListener != null) {
            onClickListener.onClick(null, 0);
        }
        com.tencent.open.business.base.e.d("200", string, string2);
    }

    public void E(Activity activity, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        int i3;
        boolean z16;
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(activity) >= 6) {
            bundle.putLong(OuterCallLog.OuterCall_MyAppApi_HandleDownloadAction, System.currentTimeMillis());
        }
        try {
            i3 = x().checkQQDownloaderInstalled();
        } catch (Exception e16) {
            e16.printStackTrace();
            i3 = -1;
        }
        boolean z17 = bundle.getBoolean(com.tencent.open.downloadnew.e.f341498g, false);
        boolean z18 = bundle.getBoolean(com.tencent.open.downloadnew.e.f341499h, true);
        int i16 = bundle.getInt(com.tencent.open.downloadnew.e.f341505n);
        int i17 = bundle.getInt(com.tencent.open.downloadnew.e.f341502k);
        boolean u16 = com.tencent.open.downloadnew.d.u();
        boolean d16 = com.tencent.open.downloadnew.d.d();
        String string = bundle.getString(com.tencent.open.downloadnew.e.f341493b);
        String string2 = bundle.getString(com.tencent.open.downloadnew.e.f341500i);
        DownloadInfo w3 = DownloadManager.C().w(string);
        if (w3 != null && w3.J == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.open.base.f.a("OpenConfig-MyAppApi", " useMyAppFlag = " + u16);
        if ((!u16 || !d16) && !z16) {
            if (onClickListener != null) {
                onClickListener.onClick(null, 0);
            }
            com.tencent.open.business.base.e.d("200", string2, string);
            return;
        }
        if (i3 != 2 && i3 != 1) {
            if (!com.tencent.open.downloadnew.d.i() && !z16) {
                if (onClickListener != null) {
                    onClickListener.onClick(null, 0);
                }
                com.tencent.open.business.base.e.d("200", string2, string);
                return;
            }
            if (i16 == 0) {
                n0(activity, bundle, z17, z18);
            } else {
                r0(activity, bundle, z17, z18);
            }
            String c16 = com.tencent.open.business.base.e.c(string2, "YYB");
            if (w3 == null && (i17 == 2 || i17 == 12)) {
                com.tencent.open.business.base.e.d(ThemeReporter.FROM_NIGHT, c16, string);
                return;
            } else {
                com.tencent.open.business.base.e.d("200", c16, string);
                return;
            }
        }
        if (onClickListener != null) {
            onClickListener.onClick(null, 0);
        }
        com.tencent.open.business.base.e.d(ThemeReporter.FROM_NIGHT, string2, string);
    }

    public boolean H() {
        return this.f341296t;
    }

    public void J(Activity activity) {
        new YybHandleUtil.a(activity, null).execute(new Void[0]);
    }

    public void K() {
        if (u() <= 2) {
            this.f341277a = TMAssistantCallYYB_V1.getInstance();
        } else {
            this.f341277a = TMAssistantCallYYB_V2.getInstance();
        }
        this.f341277a.initTMAssistantCallYYBApi(com.tencent.open.adapter.a.f().e());
        e0();
    }

    public void L() {
        TMAssistantCallYYB_V2 tMAssistantCallYYB_V2 = TMAssistantCallYYB_V2.getInstance();
        this.f341277a = tMAssistantCallYYB_V2;
        tMAssistantCallYYB_V2.initTMAssistantCallYYBApi(com.tencent.open.adapter.a.f().e());
        e0();
    }

    public boolean R() {
        if (u() <= 2) {
            return false;
        }
        return true;
    }

    public boolean S() {
        PackageManager packageManager = BaseActivity.sTopActivity.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, SDKConst.SELF_PACKAGENAME, 0);
                if (packageInfo != null) {
                    if (packageInfo.versionCode < 7090000) {
                        return false;
                    }
                    return true;
                }
            } catch (PackageManager.NameNotFoundException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public void T(final Activity activity) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.5
            @Override // java.lang.Runnable
            public void run() {
                MyAppApi myAppApi = MyAppApi.this;
                if (myAppApi.f341291o && myAppApi.f341292p != null) {
                    myAppApi.U(activity);
                } else {
                    myAppApi.V(activity);
                }
            }
        });
    }

    protected void U(Activity activity) {
        if (this.f341291o && this.f341292p != null) {
            if (!v0()) {
                z();
                if (G()) {
                    if (this.f341281e != -1) {
                        x().removeDownloadTask(this.f341281e);
                    }
                    p0(activity, null);
                }
            }
            this.f341291o = false;
            q();
            return;
        }
        this.f341291o = false;
        this.f341292p = null;
        q();
    }

    protected void V(Activity activity) {
        boolean z16;
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        long currentTimeMillis = System.currentTimeMillis() - this.f341282f;
        com.tencent.open.base.f.a("MyAppApi", "judgeInstallFlag -- mInstalledFlag = " + this.f341279c + "mInstallTime = " + this.f341282f + " countTime =" + currentTimeMillis);
        if (this.f341279c) {
            if (this.f341282f != -1 && currentTimeMillis <= 180000) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (G()) {
                if (!v0()) {
                    this.f341280d = false;
                } else {
                    this.f341280d = true;
                }
                if (!this.f341280d && !z16) {
                    if (this.f341281e != -1) {
                        x().removeDownloadTask(this.f341281e);
                    }
                    if (com.tencent.open.downloadnew.d.i()) {
                        h hVar = this.f341285i;
                        if (hVar != null) {
                            if (hVar.f341400e == 0) {
                                n0(activity, hVar.f341396a, hVar.f341397b, hVar.f341398c);
                            } else {
                                r0(activity, hVar.f341396a, hVar.f341397b, hVar.f341398c);
                            }
                        }
                    } else if (!z16 && (onClickListener2 = this.f341284h) != null) {
                        onClickListener2.onClick(null, 0);
                    }
                }
            } else {
                try {
                    if (new File(com.tencent.open.adapter.a.f().e().getFilesDir() + File.separator + "yyb_via_info.txt").exists()) {
                        com.tencent.open.adapter.a.f().e().deleteFile("yyb_via_info.txt");
                    }
                } catch (Exception unused) {
                }
                if (!this.f341280d && !z16) {
                    if (this.f341281e != -1) {
                        x().removeDownloadTask(this.f341281e);
                    }
                    if (!z16 && (onClickListener = this.f341284h) != null) {
                        onClickListener.onClick(null, 0);
                    }
                }
            }
            q();
        }
        if (!this.f341289m && !G()) {
            SharedPreferences sharedPreferences = com.tencent.open.adapter.a.f().e().getSharedPreferences("showTost_pf", 0);
            this.f341289m = sharedPreferences.getBoolean(UIJsPlugin.EVENT_SHOW_TOAST, false);
            this.f341290n = sharedPreferences.getString("toast_msg", "");
        }
        if (this.f341289m) {
            if (!G()) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.6
                    @Override // java.lang.Runnable
                    public void run() {
                        ToastUtil.a().e(MyAppApi.this.f341290n);
                    }
                }, 2000L);
            }
            this.f341289m = false;
            SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("showTost_pf", 0).edit();
            edit.putBoolean(UIJsPlugin.EVENT_SHOW_TOAST, this.f341289m);
            edit.commit();
        }
    }

    public void W(final Activity activity, final String str, final boolean z16) {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.21
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.open.base.f.a("MyAppApi", "---isAutoInstall:" + com.tencent.open.downloadnew.d.v() + " url:" + com.tencent.open.downloadnew.d.n() + " interval:" + com.tencent.open.downloadnew.d.B());
                boolean y16 = com.tencent.open.downloadnew.d.y();
                if (!MyAppApi.G() && y16) {
                    com.tencent.open.base.f.a("MyAppApi", "---startDownloadYYB---");
                    MyAppApi myAppApi = MyAppApi.this;
                    myAppApi.f341285i = new h();
                    MyAppApi myAppApi2 = MyAppApi.this;
                    h hVar = myAppApi2.f341285i;
                    hVar.f341397b = true;
                    hVar.f341398c = false;
                    hVar.f341399d = null;
                    hVar.f341396a = null;
                    hVar.f341400e = -1;
                    if (z16) {
                        myAppApi2.r(activity, str, 0, "", "");
                    } else {
                        myAppApi2.r(activity, str, 1, "", "");
                    }
                }
            }
        }, 0L);
    }

    protected void X(String str) {
        DownloadManager C = DownloadManager.C();
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.f341184e = str;
        downloadInfo.k(10);
        C.K(10, downloadInfo);
    }

    public void Y() {
        try {
            this.f341277a.unregisterListener(this.f341278b);
            this.f341277a.destroyQQDownloaderOpenSDK();
        } catch (Exception e16) {
            com.tencent.open.base.f.b("MyAppApi", "onDestroy>>>", e16);
        }
        synchronized (MyAppApi.class) {
            f341276v = null;
        }
    }

    public void a0(final Activity activity, String str) {
        com.tencent.open.base.f.a("YybUpgradeDialog", "preDownload called,get updateDetail info");
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.20
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                int i3;
                UpgradeDetailWrapper.b bVar;
                com.tencent.open.base.f.a("MyAppApi", "---isAutoInstall:" + com.tencent.open.downloadnew.d.v() + " url:" + com.tencent.open.downloadnew.d.n() + " interval:" + com.tencent.open.downloadnew.d.B());
                if (com.tencent.open.base.a.j(activity) && com.tencent.open.base.a.k(activity)) {
                    boolean d16 = com.tencent.mobileqq.cooperation.a.d(SDKConst.SELF_PACKAGENAME, BaseActivity.sTopActivity);
                    boolean y16 = com.tencent.open.downloadnew.d.y();
                    UpgradeDetailWrapper j3 = k.i().j();
                    if (j3 != null && j3.f306174i != null && j3.f306174i.dialog != null) {
                        z16 = j3.f306174i.dialog.f306164p;
                    } else {
                        z16 = false;
                    }
                    boolean b16 = dx.b();
                    if (b16) {
                        int d17 = dx.d();
                        if (j3 != null && (bVar = j3.f306173h) != null) {
                            i3 = bVar.f306179d;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != d17) {
                            dx.i(false);
                            dx.k(i3);
                            b16 = false;
                        }
                    }
                    com.tencent.open.base.f.a("YybUpgradeDialog", "predownload flags:isInstalled=" + d16 + " needDownloadYYB = " + y16 + " allowPreDownload=" + z16 + " hasPreDownloadSucc=" + b16);
                    if (!d16 && !MyAppApi.G() && y16 && z16 && !b16) {
                        com.tencent.open.base.f.a("YybUpgradeDialog", "---start pre Download YYB---");
                        MyAppApi myAppApi = MyAppApi.this;
                        myAppApi.f341285i = new h();
                        MyAppApi myAppApi2 = MyAppApi.this;
                        h hVar = myAppApi2.f341285i;
                        hVar.f341397b = true;
                        hVar.f341398c = false;
                        hVar.f341399d = null;
                        hVar.f341396a = null;
                        hVar.f341400e = -1;
                        myAppApi2.f341295s = true;
                        MyAppApi.this.r(activity, "ANDROIDQQ.NEWYYB.QQUPDATE", 1, "", "");
                        return;
                    }
                    com.tencent.open.base.f.a("YybUpgradeDialog", "don't need preDownload return");
                }
            }
        }, 0L);
    }

    protected void d0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
        com.tencent.open.adapter.a.f().e().registerReceiver(new c(), intentFilter);
    }

    protected void e0() {
        x().registerListener(this.f341278b);
    }

    public void f0() {
        this.f341288l = 0L;
    }

    public void g0(boolean z16, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f341289m = z16;
        this.f341290n = str;
        if (z16) {
            SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("showTost_pf", 0).edit();
            edit.putBoolean(UIJsPlugin.EVENT_SHOW_TOAST, this.f341289m);
            edit.putString("toast_msg", str);
            edit.commit();
        }
    }

    public void h0(boolean z16) {
        this.f341296t = z16;
    }

    protected void i0(Activity activity, int i3, int i16, String str, final DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener, String str2, boolean z16, Bundle bundle) {
        String str3;
        String string;
        String string2 = bundle.getString(com.tencent.open.downloadnew.e.f341507p);
        int i17 = bundle.getInt("dialogType");
        int i18 = bundle.getInt("auto_start_yyb_download");
        com.tencent.open.base.f.a("TIME-STATISTIC", "MyAppApi--showTipDialog");
        com.tencent.open.base.f.a("MyAppApi", "-showTipDialog-");
        if (activity == null) {
            return;
        }
        Resources resources = activity.getResources();
        int i19 = 1;
        if (i16 == 1) {
            if (i3 != 2) {
                if (i3 == 12 && !TextUtils.isEmpty(str)) {
                    i19 = 2;
                } else {
                    i19 = 1;
                }
            }
        } else if (i3 == 2 || i3 != 12 || TextUtils.isEmpty(str)) {
            i19 = 3;
        } else {
            i19 = 4;
        }
        if (TextUtils.isEmpty(string2)) {
            str3 = com.tencent.open.downloadnew.d.o(i19, str2);
        } else {
            str3 = string2;
        }
        if (TextUtils.isEmpty(str3)) {
            if (i19 != 1) {
                if (i19 != 2) {
                    if (i19 != 3) {
                        if (i19 != 4) {
                            str3 = resources.getString(R.string.anw);
                        } else {
                            str3 = resources.getString(R.string.anz, str);
                        }
                    } else {
                        str3 = resources.getString(R.string.any);
                    }
                } else {
                    str3 = resources.getString(R.string.anx, str);
                }
            } else {
                str3 = resources.getString(R.string.anw);
            }
        }
        if ((i19 == 2 || i19 == 4) && TextUtils.isEmpty(string2)) {
            try {
                str3 = String.format(str3, str);
            } catch (Exception e16) {
                if (i19 == 2) {
                    string = resources.getString(R.string.anw);
                } else {
                    string = resources.getString(R.string.any);
                }
                com.tencent.open.base.f.a("MyAppApi", " errorMsg = " + e16.getMessage());
                str3 = string;
            }
        }
        String string3 = resources.getString(R.string.ao8);
        if (i16 == 1 && i17 == 1) {
            string3 = resources.getString(R.string.ao9);
            str3 = resources.getString(R.string.f170839ao0);
        }
        final MyAppDialog myAppDialog = new MyAppDialog(activity);
        myAppDialog.W(R.string.f170842ao3, onClickListener2, true);
        myAppDialog.P(R.string.ao6, onClickListener, !z16);
        myAppDialog.X(string3);
        myAppDialog.Q(str3);
        if (i17 == 1) {
            myAppDialog.U(R.string.f170842ao3, Color.parseColor("#D2D1D1"), onClickListener2, true);
            myAppDialog.O(R.string.ao6, Color.parseColor("#3AC8FF"), onClickListener, !z16);
            myAppDialog.S(activity.getResources().getDrawable(R.drawable.f161282tt));
            myAppDialog.R(Color.parseColor("#848484"));
        }
        myAppDialog.setCancelable(true);
        myAppDialog.setOnCancelListener(onCancelListener);
        myAppDialog.setOnDismissListener(new a());
        if ((activity instanceof AppActivity) && !((AppActivity) activity).isResume()) {
            com.tencent.open.base.f.a("TIME-STATISTIC", "MyAppApi--showTipDialog---cancel !isResume");
            return;
        }
        try {
            if (!activity.isFinishing()) {
                myAppDialog.show();
                ReportController.o(null, "dc00898", "", "", "0X8008F7A", "0X8008F7A", 0, 0, "", "", "", "");
                if (i17 == 1) {
                    AppCenterReporter.v("6006", "0", "0", bundle.getString(com.tencent.open.downloadnew.e.f341500i), bundle.getString("pageId") + "_" + bundle.getString("moduleId") + "_" + bundle.getString(com.tencent.open.downloadnew.e.f341497f) + "_" + bundle.getString(com.tencent.open.downloadnew.e.f341494c) + "_" + bundle.getString(com.tencent.open.downloadnew.e.f341495d));
                    if (i18 == 1) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.15
                            @Override // java.lang.Runnable
                            public void run() {
                                onClickListener.onClick(myAppDialog, 0);
                            }
                        });
                    }
                }
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        com.tencent.open.base.f.a("TIME-STATISTIC", "MyAppApi--showTipDialog---complete");
        this.f341286j = myAppDialog;
    }

    protected long j(Bundle bundle, boolean z16, boolean z17) {
        com.tencent.open.base.f.a("MyAppApi", "--addDownloadTaskFromAppDetail--params = " + bundle + "autoDownload = " + z16);
        if (bundle == null) {
            return -1L;
        }
        TMAssistantCallYYBParamStruct t16 = t(bundle);
        this.f341293q = t16;
        return x().addDownloadTaskFromAppDetail(t16, z16, z16);
    }

    public void j0(final Context context, JSONArray jSONArray, int i3, final String str, String str2) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < length; i16++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i16);
            if (optJSONObject != null) {
                TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct = new TMAssistantCallYYBParamStruct();
                tMAssistantCallYYBParamStruct.recommendId = optJSONObject.optString("recommendId");
                tMAssistantCallYYBParamStruct.channelId = optJSONObject.optString(com.tencent.open.downloadnew.e.M);
                tMAssistantCallYYBParamStruct.taskPackageName = optJSONObject.optString(com.tencent.open.downloadnew.e.f341497f);
                tMAssistantCallYYBParamStruct.taskVersion = optJSONObject.optInt(com.tencent.open.downloadnew.e.f341496e);
                tMAssistantCallYYBParamStruct.via = optJSONObject.optString(com.tencent.open.downloadnew.e.f341500i);
                tMAssistantCallYYBParamStruct.taskApkId = optJSONObject.optString(com.tencent.open.downloadnew.e.f341495d);
                tMAssistantCallYYBParamStruct.taskAppId = optJSONObject.optString(com.tencent.open.downloadnew.e.f341494c);
                String optString = optJSONObject.optString(com.tencent.open.downloadnew.e.f341494c);
                tMAssistantCallYYBParamStruct.SNGAppId = optString;
                if (TextUtils.isEmpty(optString)) {
                    tMAssistantCallYYBParamStruct.SNGAppId = optJSONObject.optString(com.tencent.open.downloadnew.e.f341493b);
                }
                if (TextUtils.isEmpty(tMAssistantCallYYBParamStruct.via)) {
                    tMAssistantCallYYBParamStruct.via = str;
                }
                tMAssistantCallYYBParamStruct.source = str2;
                arrayList.add(tMAssistantCallYYBParamStruct);
            }
        }
        int i17 = 2;
        if (i3 == 2) {
            i17 = 3;
        }
        final int i18 = i17;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.11
            @Override // java.lang.Runnable
            public void run() {
                TMAssistantCallYYB_V2.getInstance().startBatchOperation(context, arrayList, i18, str);
            }
        }, 16, null, true);
    }

    protected long k(Bundle bundle, boolean z16, boolean z17) {
        com.tencent.open.base.f.a("MyAppApi", "--addDownloadTaskFromTaskList--params = " + bundle + "autoDownload = " + z16);
        if (bundle == null) {
            return -1L;
        }
        TMAssistantCallYYBParamStruct t16 = t(bundle);
        this.f341293q = t16;
        return x().addDownloadTaskFromTaskList(t16, z16, z16);
    }

    public void k0(final Activity activity, final String str, String str2) {
        long j3 = 0;
        if (!"biz_src_yyb".equals(str2)) {
            long B = com.tencent.open.downloadnew.d.B();
            if (B <= 0) {
                j3 = 2000;
            } else {
                j3 = B;
            }
        }
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.19
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.open.base.f.a("MyAppApi", "---isAutoInstall:" + com.tencent.open.downloadnew.d.v() + " url:" + com.tencent.open.downloadnew.d.n() + " interval:" + com.tencent.open.downloadnew.d.B());
                if (com.tencent.open.base.a.j(activity) && com.tencent.open.base.a.k(activity)) {
                    boolean y16 = com.tencent.open.downloadnew.d.y();
                    boolean j16 = com.tencent.open.downloadnew.d.j();
                    String e16 = ea.e1(activity, "wifiAutoPreDown");
                    if (!MyAppApi.G() && y16 && j16 && "true".equals(e16)) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.19.1
                            @Override // java.lang.Runnable
                            public void run() {
                            }
                        });
                        com.tencent.open.base.f.a("MyAppApi", "---startDownloadYYB---");
                        MyAppApi myAppApi = MyAppApi.this;
                        myAppApi.f341285i = new h();
                        MyAppApi myAppApi2 = MyAppApi.this;
                        h hVar = myAppApi2.f341285i;
                        hVar.f341397b = true;
                        hVar.f341398c = false;
                        hVar.f341399d = null;
                        hVar.f341396a = null;
                        hVar.f341400e = -1;
                        myAppApi2.r(activity, str, 1, "", "");
                    }
                }
            }
        }, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long l(Bundle bundle) {
        try {
            com.tencent.open.base.f.a("MyAppApi", "--addDownloadTaskFromTmast--params = " + bundle);
            if (bundle == null) {
                return -1L;
            }
            bundle.getString("url");
            return x().addDownloadTaskFromTmast(bundle);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1L;
        }
    }

    public void l0(Activity activity, String str, String str2, int i3, String str3, boolean z16) {
        com.tencent.open.base.f.a("MyAppApi", "startDownloadYyb");
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(str)) {
            str = "https://a.app.qq.com/o/myapp-down?g_f=991310";
        }
        bundle.putString(com.tencent.open.downloadnew.e.f341493b, w(str3));
        bundle.putString(com.tencent.open.downloadnew.e.f341501j, str);
        bundle.putString(com.tencent.open.downloadnew.e.f341497f, SDKConst.SELF_PACKAGENAME);
        bundle.putInt(com.tencent.open.downloadnew.e.f341502k, 2);
        bundle.putString(com.tencent.open.downloadnew.e.f341500i, str2);
        bundle.putString(com.tencent.open.downloadnew.e.f341503l, YybHandleUtil.f341435c);
        if (i3 == 1) {
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341515x, true);
        } else {
            bundle.putBoolean(com.tencent.open.downloadnew.e.f341515x, false);
        }
        bundle.putInt(com.tencent.open.downloadnew.e.E, i3);
        bundle.putString(com.tencent.open.downloadnew.e.f341504m, "yyb");
        bundle.putString(com.tencent.open.downloadnew.e.f341494c, "5848");
        bundle.putBoolean(com.tencent.open.downloadnew.e.f341498g, true);
        bundle.putBoolean(com.tencent.open.downloadnew.e.f341499h, z16);
        bundle.putInt(com.tencent.open.downloadnew.e.f341505n, 1);
        DownloadApi.d(activity, bundle, "biz_src_yyb", null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long m(Bundle bundle) {
        try {
            com.tencent.open.base.f.a("MyAppApi", "--addDownloadTaskFromAppDetail--params = " + bundle);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (bundle == null) {
            return -1L;
        }
        String string = bundle.getString("url");
        if (!TextUtils.isEmpty(string)) {
            if (!string.startsWith(JefsClass.SCHEME_YYB_PREFIX) && !string.startsWith("tpmast")) {
                return x().addDownloadTaskFromWebview(bundle);
            }
            return x().addDownloadTaskFromTmast(bundle);
        }
        return -1L;
    }

    public boolean n() {
        if (G() && com.tencent.open.downloadnew.d.u() && com.tencent.open.downloadnew.d.i()) {
            return true;
        }
        return false;
    }

    public boolean n0(final Context context, final Bundle bundle, final boolean z16, final boolean z17) {
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27 = z16;
        com.tencent.open.base.f.a("TIME-STATISTIC", "MyAppApi--startToAppDetail ");
        if (bundle == null) {
            return false;
        }
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(context) >= 6) {
            bundle.putLong(OuterCallLog.OuterCall_MyAppApi_StartToAppDetail, System.currentTimeMillis());
        }
        final TMAssistantCallYYBParamStruct t16 = t(bundle);
        if (!DownloadApi.l(t16.SNGAppId)) {
            return false;
        }
        boolean p16 = com.tencent.open.downloadnew.d.p();
        final long l3 = com.tencent.open.adapter.a.f().l();
        if (p16 && l3 > 0 && l3 != this.f341288l) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18 && context != null && ((z26 = context instanceof BaseActivity))) {
            final com.tencent.open.base.k kVar = new com.tencent.open.base.k();
            kVar.d(new k.b() { // from class: com.tencent.open.downloadnew.MyAppApi.12
                @Override // com.tencent.open.base.k.b
                public void a() {
                    ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z28;
                            boolean z29;
                            com.tencent.open.base.f.a("TIME-STATISTIC", "onGetA1Fail");
                            AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                            DownloadManager.C().e(MyAppApi.this.s(t16, bundle));
                            try {
                                com.tencent.open.base.f.h("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + t16.SNGAppId + " apkId=" + t16.taskApkId + " taskAppId=" + t16.taskAppId + " packageName=" + t16.taskPackageName + " version=" + t16.taskVersion + " uin=" + t16.uin + " via=" + t16.via);
                                com.tencent.open.base.f.a("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
                                if (MyAppApi.this.u() <= 2) {
                                    TMAssistantCallYYB_V1 tMAssistantCallYYB_V1 = (TMAssistantCallYYB_V1) MyAppApi.this.x();
                                    AnonymousClass12 anonymousClass122 = AnonymousClass12.this;
                                    tMAssistantCallYYB_V1.startToAppDetail(context, t16, z16, z17);
                                } else {
                                    int i3 = bundle.getInt(com.tencent.open.downloadnew.e.f341502k);
                                    AnonymousClass12 anonymousClass123 = AnonymousClass12.this;
                                    int A = MyAppApi.this.A(bundle);
                                    AnonymousClass12 anonymousClass124 = AnonymousClass12.this;
                                    boolean z36 = z16;
                                    boolean z37 = z17;
                                    if (i3 == 3) {
                                        z28 = false;
                                        z29 = false;
                                    } else {
                                        z28 = z36;
                                        z29 = z37;
                                    }
                                    TMAssistantCallYYB_V2 tMAssistantCallYYB_V2 = (TMAssistantCallYYB_V2) MyAppApi.this.x();
                                    AnonymousClass12 anonymousClass125 = AnonymousClass12.this;
                                    tMAssistantCallYYB_V2.startToAppDetail(context, t16, z28, z29, A);
                                }
                            } catch (Exception e16) {
                                com.tencent.open.base.f.j("MyAppApi", "startToAppDetail err", e16);
                            }
                        }
                    });
                }

                @Override // com.tencent.open.base.k.b
                public void b(final String str, final byte[] bArr) {
                    com.tencent.open.base.f.a("TIME-STATISTIC", "onGetA1");
                    ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z28;
                            boolean z29;
                            kVar.a();
                            try {
                                AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                                final DownloadInfo s16 = MyAppApi.this.s(t16, bundle);
                                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.12.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        DownloadManager.C().e(s16);
                                    }
                                }, 32, null, true);
                                byte[] bArr2 = bArr;
                                if (bArr2 != null && bArr2.length != 0) {
                                    StringBuilder sb5 = new StringBuilder();
                                    TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct = t16;
                                    sb5.append(str);
                                    sb5.append("&identity=");
                                    sb5.append(util.buf_to_string(bArr));
                                    tMAssistantCallYYBParamStruct.uin = sb5.toString();
                                    AnonymousClass12 anonymousClass122 = AnonymousClass12.this;
                                    MyAppApi.this.f341288l = l3;
                                }
                                com.tencent.open.base.f.h("MyAppApi", "OpenSDK startToAppDetail param SNGAppId=" + t16.SNGAppId + " apkId=" + t16.taskApkId + " taskAppId=" + t16.taskAppId + " packageName=" + t16.taskPackageName + " version=" + t16.taskVersion + " uin=" + t16.uin + " via=" + t16.via);
                                com.tencent.open.base.f.a("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
                                if (MyAppApi.this.u() <= 2) {
                                    TMAssistantCallYYB_V1 tMAssistantCallYYB_V1 = (TMAssistantCallYYB_V1) MyAppApi.this.x();
                                    AnonymousClass12 anonymousClass123 = AnonymousClass12.this;
                                    tMAssistantCallYYB_V1.startToAppDetail(context, t16, z16, z17);
                                    return;
                                }
                                int i3 = bundle.getInt(com.tencent.open.downloadnew.e.f341502k);
                                AnonymousClass12 anonymousClass124 = AnonymousClass12.this;
                                int A = MyAppApi.this.A(bundle);
                                AnonymousClass12 anonymousClass125 = AnonymousClass12.this;
                                boolean z36 = z16;
                                boolean z37 = z17;
                                if (i3 == 3) {
                                    z28 = false;
                                    z29 = false;
                                } else {
                                    z28 = z36;
                                    z29 = z37;
                                }
                                TMAssistantCallYYB_V2 tMAssistantCallYYB_V2 = (TMAssistantCallYYB_V2) MyAppApi.this.x();
                                AnonymousClass12 anonymousClass126 = AnonymousClass12.this;
                                tMAssistantCallYYB_V2.startToAppDetail(context, t16, z28, z29, A);
                            } catch (Exception e16) {
                                com.tencent.open.base.f.j("MyAppApi", "startToAppDetail err", e16);
                            }
                        }
                    });
                }
            });
            if (z26) {
                kVar.b(((BaseActivity) context).getAppRuntime(), 710020706L, SDKConst.SELF_PACKAGENAME);
                return true;
            }
            return true;
        }
        DownloadManager.C().e(s(t16, bundle));
        try {
            com.tencent.open.base.f.h("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + t16.SNGAppId + " apkId=" + t16.taskApkId + " taskAppId=" + t16.taskAppId + " source=" + t16.source + " packageName=" + t16.taskPackageName + " version=" + t16.taskVersion + " uin=" + t16.uin + " via=" + t16.via + " autoDownload=" + z27 + " autoInstall=" + z17);
            com.tencent.open.base.f.a("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
            if (u() <= 2) {
                ((TMAssistantCallYYB_V1) x()).startToAppDetail(context, t16, z27, z17);
            } else {
                int i3 = bundle.getInt(com.tencent.open.downloadnew.e.f341502k);
                int A = A(bundle);
                if (i3 == 3) {
                    z19 = false;
                    z27 = false;
                } else {
                    z19 = z17;
                }
                ((TMAssistantCallYYB_V2) x()).startToAppDetail(context, t16, z27, z19, A);
            }
            return true;
        } catch (Exception e16) {
            com.tencent.open.base.f.j("MyAppApi", "startToAppDetail err", e16);
            return false;
        }
    }

    public void o0(final String str, final DialogInterface.OnClickListener onClickListener, final Activity activity) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.16
            @Override // java.lang.Runnable
            public void run() {
                MyAppApi.this.q0(str, onClickListener, activity);
            }
        });
    }

    protected void p0(final Activity activity, final DialogInterface.OnClickListener onClickListener) {
        boolean z16;
        boolean p16 = com.tencent.open.downloadnew.d.p();
        final long l3 = com.tencent.open.adapter.a.f().l();
        if (p16 && l3 > 0 && l3 != this.f341288l) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (this.f341292p != null) {
                if (u() <= 2) {
                    ((TMAssistantCallYYB_V1) x()).startToAuthorized(activity, this.f341292p, "2");
                } else {
                    ((TMAssistantCallYYB_V2) x()).startToAuthorized(activity, this.f341292p, "2");
                }
                this.f341292p = null;
                return;
            }
            com.tencent.open.base.f.c("MyAppApi", "startToAuthorizedDirect mLastAuthorizeParam = null, needCarryQQIdentity = false");
            return;
        }
        final com.tencent.open.base.k kVar = new com.tencent.open.base.k();
        kVar.d(new k.b() { // from class: com.tencent.open.downloadnew.MyAppApi.17
            @Override // com.tencent.open.base.k.b
            public void a() {
                com.tencent.open.base.f.h("MyAppApi", "onGetA1Fail ---");
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.17.2
                    @Override // java.lang.Runnable
                    public void run() {
                        kVar.a();
                        MyAppApi myAppApi = MyAppApi.this;
                        if (myAppApi.f341292p != null) {
                            if (myAppApi.u() <= 2) {
                                TMAssistantCallYYB_V1 tMAssistantCallYYB_V1 = (TMAssistantCallYYB_V1) MyAppApi.this.x();
                                AnonymousClass17 anonymousClass17 = AnonymousClass17.this;
                                tMAssistantCallYYB_V1.startToAuthorized(activity, MyAppApi.this.f341292p, "2");
                            } else {
                                TMAssistantCallYYB_V2 tMAssistantCallYYB_V2 = (TMAssistantCallYYB_V2) MyAppApi.this.x();
                                AnonymousClass17 anonymousClass172 = AnonymousClass17.this;
                                tMAssistantCallYYB_V2.startToAuthorized(activity, MyAppApi.this.f341292p, "2");
                            }
                            MyAppApi.this.f341292p = null;
                            return;
                        }
                        com.tencent.open.base.f.c("MyAppApi", "startToAuthorizedDirect->onGetA1Fail mLastAuthorizeParam = null, needCarryQQIdentity = true");
                    }
                });
            }

            @Override // com.tencent.open.base.k.b
            public void b(final String str, final byte[] bArr) {
                com.tencent.open.base.f.h("MyAppApi", "onGetA1 ---");
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.17.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str2;
                        kVar.a();
                        if (MyAppApi.this.f341292p != null) {
                            try {
                                byte[] bArr2 = bArr;
                                if (bArr2 != null && bArr2.length != 0) {
                                    StringBuilder sb5 = new StringBuilder();
                                    try {
                                        str2 = util.buf_to_string(bArr);
                                    } catch (Exception e16) {
                                        e16.printStackTrace();
                                        str2 = null;
                                    }
                                    TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct = MyAppApi.this.f341292p;
                                    sb5.append(str);
                                    sb5.append("&identity=");
                                    sb5.append(str2);
                                    tMAssistantCallYYBParamStruct.uin = sb5.toString();
                                    AnonymousClass17 anonymousClass17 = AnonymousClass17.this;
                                    MyAppApi.this.f341288l = l3;
                                }
                            } catch (Exception e17) {
                                e17.printStackTrace();
                            }
                            if (MyAppApi.this.u() <= 2) {
                                TMAssistantCallYYB_V1 tMAssistantCallYYB_V1 = (TMAssistantCallYYB_V1) MyAppApi.this.x();
                                AnonymousClass17 anonymousClass172 = AnonymousClass17.this;
                                tMAssistantCallYYB_V1.startToAuthorized(activity, MyAppApi.this.f341292p, "2");
                            } else {
                                TMAssistantCallYYB_V2 tMAssistantCallYYB_V2 = (TMAssistantCallYYB_V2) MyAppApi.this.x();
                                AnonymousClass17 anonymousClass173 = AnonymousClass17.this;
                                tMAssistantCallYYB_V2.startToAuthorized(activity, MyAppApi.this.f341292p, "2");
                            }
                            AnonymousClass17 anonymousClass174 = AnonymousClass17.this;
                            MyAppApi.this.f341292p = null;
                            DialogInterface.OnClickListener onClickListener2 = onClickListener;
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(null, 0);
                                return;
                            }
                            return;
                        }
                        com.tencent.open.base.f.c("MyAppApi", "startToAuthorizedDirect->onGetA1 mLastAuthorizeParam = null, needCarryQQIdentity = true");
                    }
                });
            }
        });
        if (activity instanceof BaseActivity) {
            kVar.b(((BaseActivity) activity).getAppRuntime(), 710020706L, SDKConst.SELF_PACKAGENAME);
        }
    }

    protected void q() {
        com.tencent.open.base.f.a("MyAppApi", "clearInstallParam");
        this.f341284h = null;
        this.f341285i = null;
        this.f341279c = false;
        this.f341280d = false;
        this.f341293q = null;
    }

    protected void q0(String str, DialogInterface.OnClickListener onClickListener, Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appid", "");
            jSONObject.optString("myAppid", "");
            jSONObject.optString("apkId", "");
            String optString2 = jSONObject.optString("versionCode", "");
            String optString3 = jSONObject.optString("via", "");
            jSONObject.optString(DKEngine.GlobalKey.APP_PACKAGE_NAME, "");
            String optString4 = jSONObject.optString("appName", HardCodeUtil.qqStr(R.string.ocy));
            jSONObject.optString("channelId", "");
            String optString5 = jSONObject.optString("appAuthorizedStr", "");
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(optString2)) {
                optString2 = "1";
            }
            int parseInt = Integer.parseInt(optString2);
            bundle.putString(com.tencent.open.downloadnew.e.f341493b, jSONObject.optString("appid", ""));
            bundle.putString(com.tencent.open.downloadnew.e.f341494c, jSONObject.optString("myAppid", ""));
            bundle.putString(com.tencent.open.downloadnew.e.f341495d, jSONObject.optString("apkId"));
            bundle.putInt(com.tencent.open.downloadnew.e.f341496e, parseInt);
            bundle.putString(com.tencent.open.downloadnew.e.f341497f, jSONObject.optString(DKEngine.GlobalKey.APP_PACKAGE_NAME));
            bundle.putString(com.tencent.open.downloadnew.e.f341500i, jSONObject.optString("via"));
            bundle.putString(com.tencent.open.downloadnew.e.f341503l, jSONObject.optString("appName"));
            bundle.putString(com.tencent.open.downloadnew.e.B, jSONObject.optString("channelId"));
            bundle.putString(com.tencent.open.downloadnew.e.D, jSONObject.optString(WadlProxyConsts.CHANNEL));
            bundle.putString(com.tencent.open.downloadnew.e.f341514w, jSONObject.optString("uin"));
            TMAssistantCallYYBParamStruct t16 = t(bundle);
            this.f341292p = t16;
            t16.actionFlag = "2";
            if (G()) {
                p0(activity, onClickListener);
                return;
            }
            if (TextUtils.isEmpty(optString5)) {
                optString5 = optString4 + HardCodeUtil.qqStr(R.string.ocv);
            }
            boolean s16 = com.tencent.open.downloadnew.d.s();
            b bVar = new b(bundle, s16, activity, optString3, onClickListener, optString);
            f fVar = new f(onClickListener, optString3, optString);
            e eVar = new e(optString3, optString);
            bundle.putString(com.tencent.open.downloadnew.e.f341507p, optString5);
            i0(activity, 1, 1, "0", bVar, fVar, eVar, "biz_src_yyb", s16, bundle);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    protected void r(Activity activity, String str, int i3, String str2, String str3) {
        com.tencent.open.base.f.a("MyAppApi", "downloadYyb");
        if (i3 == 1) {
            DownloadApi.b("_1101070898");
        }
        if (this.f341294r == null) {
            this.f341294r = new YYBDownloadListener();
            DownloadManager.C().Y(this.f341294r);
        }
        DownloadInfo w3 = DownloadManager.C().w(w(str2));
        com.tencent.open.base.f.a("MyAppApi", "---startDownloadYYB---" + w3);
        if (w3 != null) {
            if (i3 == 1) {
                w3.T = false;
                w3.U = true;
                w3.W = 1;
            } else {
                w3.T = true;
                w3.U = false;
                w3.W = 0;
            }
            w3.C = str;
            DownloadManager.C().e(w3);
            DownloadManager.C().d0(w3);
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = com.tencent.open.downloadnew.d.n();
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "https://a.app.qq.com/o/myapp-down?g_f=991310";
        }
        l0(activity, str3, str, i3, str2, false);
    }

    protected void r0(final Context context, final Bundle bundle, final boolean z16, final boolean z17) {
        boolean z18;
        boolean z19;
        boolean z26;
        com.tencent.open.base.f.a("TIME-STATISTIC", "MyAppApi--startToDownloadTaskList");
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(context) >= 6 && bundle != null) {
            bundle.putLong(OuterCallLog.OuterCall_MyAppApi_StartToDownloadList, System.currentTimeMillis());
        }
        if (bundle != null && context != null) {
            final TMAssistantCallYYBParamStruct t16 = t(bundle);
            boolean p16 = com.tencent.open.downloadnew.d.p();
            final long l3 = com.tencent.open.adapter.a.f().l();
            if (p16 && l3 > 0 && l3 != this.f341288l) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18 && ((z26 = context instanceof BaseActivity))) {
                final com.tencent.open.base.k kVar = new com.tencent.open.base.k();
                kVar.d(new k.b() { // from class: com.tencent.open.downloadnew.MyAppApi.13
                    @Override // com.tencent.open.base.k.b
                    public void a() {
                        com.tencent.open.base.f.a("TIME-STATISTIC", "onGetA1Fail");
                        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.13.2
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z27;
                                boolean z28;
                                AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                                DownloadManager.C().e(MyAppApi.this.s(t16, bundle));
                                try {
                                    com.tencent.open.base.f.h("State_Log", "OpenSDK startToDownloadTaskList param SNGAppId=" + t16.SNGAppId + " apkId=" + t16.taskApkId + " taskAppId=" + t16.taskAppId + " packageName=" + t16.taskPackageName + " version=" + t16.taskVersion + " uin=" + t16.uin + " via=" + t16.via);
                                    com.tencent.open.base.f.a("TIME-STATISTIC", "mDownloadSdk.startToDownloadTaskList");
                                    if (MyAppApi.this.u() <= 2) {
                                        TMAssistantCallYYB_V1 tMAssistantCallYYB_V1 = (TMAssistantCallYYB_V1) MyAppApi.this.x();
                                        AnonymousClass13 anonymousClass132 = AnonymousClass13.this;
                                        tMAssistantCallYYB_V1.startToDownloadTaskList(context, t16, z16, z17);
                                    } else {
                                        int i3 = bundle.getInt(com.tencent.open.downloadnew.e.f341502k);
                                        AnonymousClass13 anonymousClass133 = AnonymousClass13.this;
                                        int A = MyAppApi.this.A(bundle);
                                        AnonymousClass13 anonymousClass134 = AnonymousClass13.this;
                                        boolean z29 = z16;
                                        boolean z36 = z17;
                                        if (i3 == 3) {
                                            z27 = false;
                                            z28 = false;
                                        } else {
                                            z27 = z29;
                                            z28 = z36;
                                        }
                                        TMAssistantCallYYB_V2 tMAssistantCallYYB_V2 = (TMAssistantCallYYB_V2) MyAppApi.this.x();
                                        AnonymousClass13 anonymousClass135 = AnonymousClass13.this;
                                        tMAssistantCallYYB_V2.startToDownloadTaskList(context, t16, z27, z28, A);
                                    }
                                } catch (Exception e16) {
                                    com.tencent.open.base.f.c("MyAppApi", "--startToDownloadTaskList--Exception = " + e16);
                                }
                            }
                        });
                    }

                    @Override // com.tencent.open.base.k.b
                    public void b(final String str, final byte[] bArr) {
                        com.tencent.open.base.f.a("TIME-STATISTIC", "onGetA1");
                        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z27;
                                boolean z28;
                                kVar.a();
                                try {
                                    AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                                    DownloadManager.C().e(MyAppApi.this.s(t16, bundle));
                                    byte[] bArr2 = bArr;
                                    if (bArr2 != null && bArr2.length != 0) {
                                        StringBuilder sb5 = new StringBuilder();
                                        TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct = t16;
                                        sb5.append(str);
                                        sb5.append("&identity=");
                                        sb5.append(util.buf_to_string(bArr));
                                        tMAssistantCallYYBParamStruct.uin = sb5.toString();
                                        AnonymousClass13 anonymousClass132 = AnonymousClass13.this;
                                        MyAppApi.this.f341288l = l3;
                                    }
                                    com.tencent.open.base.f.h("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + t16.SNGAppId + " apkId=" + t16.taskApkId + " taskAppId=" + t16.taskAppId + " packageName=" + t16.taskPackageName + " version=" + t16.taskVersion + " uin=" + t16.uin + " via=" + t16.via);
                                    com.tencent.open.base.f.a("TIME-STATISTIC", "mDownloadSdk.startToDownloadTaskList");
                                    if (MyAppApi.this.u() <= 2) {
                                        TMAssistantCallYYB_V1 tMAssistantCallYYB_V1 = (TMAssistantCallYYB_V1) MyAppApi.this.x();
                                        AnonymousClass13 anonymousClass133 = AnonymousClass13.this;
                                        tMAssistantCallYYB_V1.startToDownloadTaskList(context, t16, z16, z17);
                                        return;
                                    }
                                    int i3 = bundle.getInt(com.tencent.open.downloadnew.e.f341502k);
                                    AnonymousClass13 anonymousClass134 = AnonymousClass13.this;
                                    int A = MyAppApi.this.A(bundle);
                                    AnonymousClass13 anonymousClass135 = AnonymousClass13.this;
                                    boolean z29 = z16;
                                    boolean z36 = z17;
                                    if (i3 == 3) {
                                        z27 = false;
                                        z28 = false;
                                    } else {
                                        z27 = z29;
                                        z28 = z36;
                                    }
                                    TMAssistantCallYYB_V2 tMAssistantCallYYB_V2 = (TMAssistantCallYYB_V2) MyAppApi.this.x();
                                    AnonymousClass13 anonymousClass136 = AnonymousClass13.this;
                                    tMAssistantCallYYB_V2.startToDownloadTaskList(context, t16, z27, z28, A);
                                } catch (Exception e16) {
                                    com.tencent.open.base.f.j("MyAppApi", "startToAppDetail err", e16);
                                }
                            }
                        });
                    }
                });
                if (z26) {
                    kVar.b(((BaseActivity) context).getAppRuntime(), 710020706L, SDKConst.SELF_PACKAGENAME);
                    return;
                }
                return;
            }
            DownloadManager.C().e(s(t16, bundle));
            try {
                com.tencent.open.base.f.h("State_Log", "OpenSDK startToDownloadTaskList param SNGAppId=" + t16.SNGAppId + " apkId=" + t16.taskApkId + " taskAppId=" + t16.taskAppId + " packageName=" + t16.taskPackageName + " version=" + t16.taskVersion + " uin=" + t16.uin + " via=" + t16.via);
                com.tencent.open.base.f.a("TIME-STATISTIC", "mDownloadSdk.startToDownloadTaskList");
                if (u() <= 2) {
                    ((TMAssistantCallYYB_V1) x()).startToDownloadTaskList(context, t16, z16, z17);
                } else {
                    boolean z27 = z17;
                    int i3 = bundle.getInt(com.tencent.open.downloadnew.e.f341502k);
                    int A = A(bundle);
                    if (i3 == 3) {
                        z19 = false;
                        z27 = false;
                    } else {
                        z19 = z16;
                    }
                    ((TMAssistantCallYYB_V2) x()).startToDownloadTaskList(context, t16, z19, z27, A);
                }
            } catch (Exception e16) {
                com.tencent.open.base.f.c("MyAppApi", "--startToDownloadTaskList--Exception = " + e16);
            }
        }
    }

    public DownloadInfo s(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, Bundle bundle) {
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.J = 1;
        downloadInfo.f341184e = tMAssistantCallYYBParamStruct.SNGAppId;
        downloadInfo.G = tMAssistantCallYYBParamStruct.taskAppId;
        downloadInfo.f341189h = tMAssistantCallYYBParamStruct.taskPackageName;
        downloadInfo.H = tMAssistantCallYYBParamStruct.taskApkId;
        downloadInfo.I = tMAssistantCallYYBParamStruct.taskVersion;
        downloadInfo.f341188g0 = tMAssistantCallYYBParamStruct.recommendId;
        downloadInfo.f341192i0 = tMAssistantCallYYBParamStruct.channelId;
        if (bundle != null) {
            downloadInfo.C = bundle.getString(com.tencent.open.downloadnew.e.f341500i);
            downloadInfo.f341191i = bundle.getString(com.tencent.open.downloadnew.e.f341503l);
            downloadInfo.f341186f = bundle.getString(com.tencent.open.downloadnew.e.f341501j);
            downloadInfo.K = bundle.getInt(com.tencent.open.downloadnew.e.G);
        }
        return downloadInfo;
    }

    public boolean s0(Context context, Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        com.tencent.open.base.f.a("TIME-STATISTIC", "mDownloadSdk.startToDownloadListWithParams");
        x().startToDownloadTaskListWithParams(context, bundle);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected TMAssistantCallYYBParamStruct t(Bundle bundle) {
        String c16;
        String str;
        String str2;
        String str3;
        String string = bundle.getString(com.tencent.open.downloadnew.e.f341493b);
        String string2 = bundle.getString(com.tencent.open.downloadnew.e.f341494c);
        String string3 = bundle.getString(com.tencent.open.downloadnew.e.f341495d);
        String string4 = bundle.getString(com.tencent.open.downloadnew.e.f341497f);
        String string5 = bundle.getString(com.tencent.open.downloadnew.e.f341500i);
        int i3 = bundle.getInt(com.tencent.open.downloadnew.e.f341496e);
        if (i3 == 0) {
            try {
                i3 = Integer.valueOf(bundle.getString(com.tencent.open.downloadnew.e.f341496e)).intValue();
            } catch (Exception unused) {
            }
        }
        int i16 = i3;
        if (this.f341279c) {
            c16 = com.tencent.open.business.base.e.c(string5, "NEWYYB");
        } else {
            c16 = com.tencent.open.business.base.e.c(string5, "YYB");
        }
        String str4 = c16;
        bundle.getString(com.tencent.open.downloadnew.e.B);
        String string6 = bundle.getString(com.tencent.open.downloadnew.e.D);
        int i17 = bundle.getInt(com.tencent.open.downloadnew.e.C);
        if (i17 == 1) {
            string6 = "ANDROIDQQ-gray";
            str = "1";
        } else {
            if (TextUtils.isEmpty(string6)) {
                str2 = i17 + "";
                str3 = "ANDROIDQQ";
                com.tencent.open.base.f.e("State_Log", " channelId:" + str3);
                TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct = new TMAssistantCallYYBParamStruct(string, string2, string3, i16, str4, string4, "", "", str3, str2);
                if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(com.tencent.open.adapter.a.f().e()) >= 6) {
                    tMAssistantCallYYBParamStruct.timePointMap.put(OuterCallLog.OuterCall_JS_DoDownloadAction, Long.valueOf(bundle.getLong(OuterCallLog.OuterCall_JS_DoDownloadAction, 0L)));
                    tMAssistantCallYYBParamStruct.timePointMap.put(OuterCallLog.OuterCall_DownloadApi_DoDownloadAction, Long.valueOf(bundle.getLong(OuterCallLog.OuterCall_DownloadApi_DoDownloadAction, 0L)));
                    tMAssistantCallYYBParamStruct.timePointMap.put(OuterCallLog.OuterCall_DownloadApi_DoDownloadActionByMyApp, Long.valueOf(bundle.getLong(OuterCallLog.OuterCall_DownloadApi_DoDownloadActionByMyApp, 0L)));
                    tMAssistantCallYYBParamStruct.timePointMap.put(OuterCallLog.OuterCall_MyAppApi_HandleDownloadAction, Long.valueOf(bundle.getLong(OuterCallLog.OuterCall_MyAppApi_HandleDownloadAction, 0L)));
                    tMAssistantCallYYBParamStruct.timePointMap.put(OuterCallLog.OuterCall_MyAppApi_StartToAppDetail, Long.valueOf(bundle.getLong(OuterCallLog.OuterCall_MyAppApi_StartToAppDetail, 0L)));
                    tMAssistantCallYYBParamStruct.timePointMap.put(OuterCallLog.OuterCall_MyAppApi_StartToDownloadList, Long.valueOf(bundle.getLong(OuterCallLog.OuterCall_MyAppApi_StartToDownloadList, 0L)));
                }
                tMAssistantCallYYBParamStruct.source = bundle.getString("big_brother_source_key");
                tMAssistantCallYYBParamStruct.recommendId = bundle.getString("recommendId");
                com.tencent.open.base.f.e("MyAppApi", "recommendId:" + tMAssistantCallYYBParamStruct.recommendId);
                return tMAssistantCallYYBParamStruct;
            }
            str = i17 + "";
        }
        str3 = string6;
        str2 = str;
        com.tencent.open.base.f.e("State_Log", " channelId:" + str3);
        TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct2 = new TMAssistantCallYYBParamStruct(string, string2, string3, i16, str4, string4, "", "", str3, str2);
        if (TMAssistantBaseCallYYB.getQQDownloadApiLevel(com.tencent.open.adapter.a.f().e()) >= 6) {
        }
        tMAssistantCallYYBParamStruct2.source = bundle.getString("big_brother_source_key");
        tMAssistantCallYYBParamStruct2.recommendId = bundle.getString("recommendId");
        com.tencent.open.base.f.e("MyAppApi", "recommendId:" + tMAssistantCallYYBParamStruct2.recommendId);
        return tMAssistantCallYYBParamStruct2;
    }

    public boolean t0(Context context, Bundle bundle) {
        com.tencent.open.base.f.a("TIME-STATISTIC", "MyAppApi--startToWebView");
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString("url");
        com.tencent.open.base.f.a("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
        x().startToWebView(context, string);
        return true;
    }

    protected int u() {
        int qQDownloadApiLevel = TMAssistantBaseCallYYB.getQQDownloadApiLevel(com.tencent.open.adapter.a.f().e());
        if (!com.tencent.mobileqq.cooperation.a.d(SDKConst.SELF_PACKAGENAME, BaseActivity.sTopActivity)) {
            return 3;
        }
        return qQDownloadApiLevel;
    }

    public String v() {
        Bundle bundle;
        h hVar = this.f341285i;
        if (hVar != null && (bundle = hVar.f341396a) != null) {
            return bundle.getString(com.tencent.open.downloadnew.e.f341493b);
        }
        return "";
    }

    protected boolean v0() {
        return !TMAssistantBaseCallYYB.isExistActoin(this.f341281e);
    }

    protected synchronized TMAssistantBaseCallYYB x() {
        if (this.f341277a == null) {
            K();
        }
        return this.f341277a;
    }

    public TMAssistantDownloadTaskInfo y(Bundle bundle) {
        if (bundle == null || !G()) {
            return null;
        }
        TMAssistantCallYYBParamStruct t16 = t(bundle);
        if (u() <= 2) {
            TMAssistantCallYYBTaskInfo downloadTaskState = ((TMAssistantCallYYB_V1) x()).getDownloadTaskState(t16);
            if (downloadTaskState == null) {
                return null;
            }
            return new TMAssistantDownloadTaskInfo(downloadTaskState.mUrl, downloadTaskState.mSavePath, downloadTaskState.mState, downloadTaskState.mReceiveDataLen, downloadTaskState.mTotalDataLen, downloadTaskState.mContentType);
        }
        TMAssistantCallYYBTaskInfo downloadTaskState2 = ((TMAssistantCallYYB_V2) x()).getDownloadTaskState(t16);
        if (downloadTaskState2 == null) {
            return null;
        }
        return new TMAssistantDownloadTaskInfo(downloadTaskState2.mUrl, downloadTaskState2.mSavePath, downloadTaskState2.mState, downloadTaskState2.mReceiveDataLen, downloadTaskState2.mTotalDataLen, downloadTaskState2.mContentType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class YYBDownloadListener implements DownloadListener {
        protected YYBDownloadListener() {
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void installSucceed(String str, String str2) {
            if (str.startsWith("1101070898") && str2.equals(SDKConst.SELF_PACKAGENAME)) {
                MyAppDialog myAppDialog = MyAppApi.this.f341286j;
                if (myAppDialog != null && myAppDialog.isShowing()) {
                    MyAppApi.this.f341286j.dismiss();
                }
                DownloadManager.C().j0(MyAppApi.this.f341294r);
                MyAppApi.this.f341294r = null;
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadCancel(DownloadInfo downloadInfo) {
            if (!MyAppApi.this.P(downloadInfo)) {
                return;
            }
            com.tencent.open.base.f.a("MyAppApi", "onDownloadCancel");
            MyAppDialog myAppDialog = MyAppApi.this.f341286j;
            if (myAppDialog != null && myAppDialog.isShowing()) {
                MyAppApi myAppApi = MyAppApi.this;
                if (myAppApi.f341287k) {
                    myAppApi.f341286j.Y(downloadInfo.Q, downloadInfo.f());
                }
            }
            DownloadManager.C().j0(MyAppApi.this.f341294r);
            MyAppApi.this.f341294r = null;
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
            if (!MyAppApi.this.P(downloadInfo)) {
                return;
            }
            com.tencent.open.base.f.a("MyAppApi", "onDownloadError");
            if (downloadInfo.Q != 100 && downloadInfo.P != 4) {
                MyAppDialog myAppDialog = MyAppApi.this.f341286j;
                if (myAppDialog != null && myAppDialog.isShowing()) {
                    MyAppApi myAppApi = MyAppApi.this;
                    if (myAppApi.f341287k) {
                        myAppApi.f341286j.Y(downloadInfo.Q, downloadInfo.f());
                        return;
                    }
                    return;
                }
                return;
            }
            onDownloadFinish(downloadInfo);
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadFinish(final DownloadInfo downloadInfo) {
            long j3;
            if (!MyAppApi.this.P(downloadInfo)) {
                return;
            }
            if (MyAppApi.this.f341295s) {
                UpgradeDetailWrapper j16 = com.tencent.mobileqq.upgrade.k.i().j();
                if (j16 != null && j16.f306173h != null) {
                    dx.i(true);
                    dx.k(j16.f306173h.f306179d);
                    YybUpgradeDialog.o0();
                    com.tencent.open.base.f.a("YybUpgradeDialog", "pre download success state saved!");
                }
            } else {
                ReportController.o(null, "dc00898", "", "", "0X8008F7E", "0X8008F7E", 0, 0, "", "", "", "");
            }
            com.tencent.open.base.f.a("MyAppApi", "onDownloadFinish");
            MyAppDialog myAppDialog = MyAppApi.this.f341286j;
            if (myAppDialog != null && myAppDialog.isShowing()) {
                MyAppApi myAppApi = MyAppApi.this;
                if (myAppApi.f341287k) {
                    myAppApi.f341286j.Y(100, 4);
                }
            }
            com.tencent.open.base.f.a("MyAppApi", "mInstallParam: " + MyAppApi.this.f341285i);
            h hVar = MyAppApi.this.f341285i;
            if (hVar != null) {
                if (hVar.f341398c) {
                    ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MyAppDialog myAppDialog2 = MyAppApi.this.f341286j;
                            if (myAppDialog2 != null && myAppDialog2.isShowing()) {
                                MyAppApi.this.f341286j.dismiss();
                            }
                            DownloadManager.C().I(downloadInfo);
                            new Handler(Looper.getMainLooper()).postAtTime(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (com.tencent.open.adapter.a.f().e() != null) {
                                        DisplayMetrics displayMetrics = new DisplayMetrics();
                                        ((WindowManager) com.tencent.open.adapter.a.f().e().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                                        int i3 = displayMetrics.widthPixels;
                                        float f16 = displayMetrics.density;
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                                        RelativeLayout relativeLayout = new RelativeLayout(com.tencent.open.adapter.a.f().e());
                                        relativeLayout.setLayoutParams(layoutParams);
                                        relativeLayout.setBackgroundColor(-855638017);
                                        relativeLayout.setGravity(17);
                                        int i16 = (int) ((10.0f * f16) + 0.5f);
                                        relativeLayout.setPadding(i16, i16, i16, i16);
                                        TextView textView = new TextView(com.tencent.open.adapter.a.f().e());
                                        textView.setWidth((int) (i3 * 0.9d));
                                        textView.setHeight((int) ((f16 * 96.0f) + 0.5f));
                                        textView.setBackgroundColor(com.tencent.open.adapter.a.f().e().getResources().getColor(R.color.ajr));
                                        textView.setText(R.string.i3d);
                                        textView.setTextColor(com.tencent.open.adapter.a.f().e().getResources().getColor(R.color.black));
                                        textView.setSingleLine();
                                        textView.setGravity(17);
                                        relativeLayout.addView(textView);
                                        ToastUtil.a().d(relativeLayout, 1);
                                        com.tencent.open.base.f.a("MyAppApi", HardCodeUtil.qqStr(R.string.ocx) + System.currentTimeMillis());
                                    }
                                }
                            }, 1000L);
                        }
                    }, 16, null, true, 500L);
                    MyAppApi myAppApi2 = MyAppApi.this;
                    myAppApi2.f341279c = true;
                    myAppApi2.f341280d = false;
                } else if (com.tencent.open.business.base.a.l() == 1 && com.tencent.open.downloadnew.d.v()) {
                    ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DownloadInfo downloadInfo2;
                            com.tencent.open.base.f.a("MyAppApi", "rooted and start silent install...");
                            long currentTimeMillis = System.currentTimeMillis();
                            if (com.tencent.open.downloadnew.d.t(currentTimeMillis)) {
                                if (com.tencent.open.business.base.a.u() && (downloadInfo2 = downloadInfo) != null && !TextUtils.isEmpty(downloadInfo2.L)) {
                                    com.tencent.open.business.base.a.v(downloadInfo.L);
                                } else {
                                    com.tencent.open.base.f.a("MyAppApi", "root confused and remember user operation time!");
                                    com.tencent.open.downloadnew.d.A(currentTimeMillis);
                                }
                            }
                        }
                    }, 500L);
                    MyAppApi myAppApi3 = MyAppApi.this;
                    myAppApi3.f341279c = true;
                    myAppApi3.f341280d = false;
                }
                MyAppApi myAppApi4 = MyAppApi.this;
                h hVar2 = myAppApi4.f341285i;
                int i3 = hVar2.f341400e;
                if (i3 != -1) {
                    if (i3 != 0) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                j3 = myAppApi4.k(hVar2.f341396a, hVar2.f341397b, hVar2.f341398c);
                            } else {
                                j3 = myAppApi4.m(hVar2.f341396a);
                            }
                        } else {
                            myAppApi4.f341291o = true;
                            if (myAppApi4.f341292p != null) {
                                j3 = myAppApi4.x().addDownloadTaskFromAuthorize(MyAppApi.this.f341292p, "2");
                            } else {
                                com.tencent.open.base.f.c("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
                            }
                        }
                    } else {
                        j3 = myAppApi4.j(hVar2.f341396a, hVar2.f341397b, hVar2.f341398c);
                    }
                    MyAppApi myAppApi5 = MyAppApi.this;
                    myAppApi5.f341281e = j3;
                    myAppApi5.f341282f = System.currentTimeMillis();
                }
                j3 = 0;
                MyAppApi myAppApi52 = MyAppApi.this;
                myAppApi52.f341281e = j3;
                myAppApi52.f341282f = System.currentTimeMillis();
            }
            DownloadManager.C().j0(MyAppApi.this.f341294r);
            MyAppApi.this.f341294r = null;
            if ("ANDROID.QQ.YYBXZGAMECENTER".equals(downloadInfo.C) || "ANDROID.QQ.NEWYYBXZGAMECENTER".equals(downloadInfo.C)) {
                hl0.a.b(null, "765", "205011", downloadInfo.f341184e, "76501", "1", "156");
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadPause(DownloadInfo downloadInfo) {
            if (!MyAppApi.this.P(downloadInfo)) {
                return;
            }
            com.tencent.open.base.f.a("MyAppApi", "onDownloadPause");
            MyAppDialog myAppDialog = MyAppApi.this.f341286j;
            if (myAppDialog != null && myAppDialog.isShowing()) {
                MyAppApi myAppApi = MyAppApi.this;
                if (myAppApi.f341287k) {
                    myAppApi.f341286j.Y(downloadInfo.Q, downloadInfo.f());
                }
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadUpdate(List<DownloadInfo> list) {
            if (list == null) {
                return;
            }
            for (DownloadInfo downloadInfo : list) {
                if (MyAppApi.this.P(downloadInfo)) {
                    com.tencent.open.base.f.a("MyAppApi", "onDownloadUpdate STATE = " + downloadInfo.f());
                    MyAppDialog myAppDialog = MyAppApi.this.f341286j;
                    if (myAppDialog != null && myAppDialog.isShowing()) {
                        MyAppApi myAppApi = MyAppApi.this;
                        if (myAppApi.f341287k) {
                            myAppApi.f341286j.Y(downloadInfo.Q, downloadInfo.f());
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadWait(DownloadInfo downloadInfo) {
            if (!MyAppApi.this.P(downloadInfo)) {
                return;
            }
            com.tencent.open.base.f.a("MyAppApi", "onDownloadWait");
            MyAppDialog myAppDialog = MyAppApi.this.f341286j;
            if (myAppDialog != null && myAppDialog.isShowing()) {
                MyAppApi myAppApi = MyAppApi.this;
                if (myAppApi.f341287k) {
                    myAppApi.f341286j.Y(downloadInfo.Q, downloadInfo.f());
                }
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void packageReplaced(String str, String str2) {
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void uninstallSucceed(String str, String str2) {
        }
    }
}
