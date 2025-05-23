package com.tencent.mobileqq.ark.api.module;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.download.ArkDownloadController;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ao;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import d91.g;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.Foreground;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes11.dex */
public class ArkAppDownloadModule extends ArkAppQQModuleBase {

    /* renamed from: l, reason: collision with root package name */
    private WadlProxyServiceCallBackInterface f198888l;

    /* renamed from: m, reason: collision with root package name */
    private d f198889m;

    /* renamed from: n, reason: collision with root package name */
    private e f198890n;

    /* renamed from: o, reason: collision with root package name */
    private c f198891o;

    /* renamed from: p, reason: collision with root package name */
    private ArrayList<Long> f198892p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f198893q;

    /* renamed from: r, reason: collision with root package name */
    private INetInfoHandler f198894r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f198895s;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements WadlProxyServiceCallBackInterface {
        a() {
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
        public void onQueryCallback(ArrayList<WadlResult> arrayList) {
            if (arrayList != null) {
                QLog.i("ark.download.module", 1, "ark.dctrl.onQueryCallback:" + arrayList.toString());
            }
            if (ArkAppDownloadModule.this.f198889m != null) {
                if (arrayList != null) {
                    GameCenterUtil.handleQueryResult(arrayList);
                }
                ArkAppDownloadModule.this.f198889m.a(arrayList);
            }
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
        public void onQueryCallbackVia(ArrayList<WadlResult> arrayList) {
            if (arrayList != null) {
                QLog.i("ark.download.module", 1, "ark.dctrl.onQueryCallbackVia:" + arrayList.toString());
            }
            if (ArkAppDownloadModule.this.f198890n != null) {
                if (arrayList != null) {
                    GameCenterUtil.handleQueryResult(arrayList);
                }
                ArkAppDownloadModule.this.f198890n.a(arrayList);
            }
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
        public void onWadlTaskStatusChanged(WadlResult wadlResult) {
            String str;
            if (ArkAppDownloadModule.this.f198891o != null) {
                if (wadlResult != null) {
                    GameCenterUtil.handleQueryResult(wadlResult);
                }
                ArkAppDownloadModule.this.f198891o.a(wadlResult);
                if (wadlResult == null) {
                    return;
                }
                QLog.i("ark.download.module", 1, "ark.dctrl.onWadlTaskStatusChanged:" + wadlResult.toString());
                WadlParams wadlParams = wadlResult.wadlParams;
                if (wadlParams != null) {
                    str = wadlParams.appId;
                } else {
                    str = "";
                }
                String str2 = str;
                int i3 = wadlResult.taskStatus;
                if (i3 != 6) {
                    if (i3 != 7) {
                        if (i3 != 9) {
                            if (i3 == 14) {
                                ReportController.r(null, "dc00898", "", "", "0X8009E18", "0X8009E18", 0, 0, "", "", str2, "");
                                return;
                            }
                            return;
                        }
                        ReportController.r(null, "dc00898", "", "", "0X8009E17", "0X8009E17", 0, 0, "", "", str2, "");
                        return;
                    }
                    ReportController.r(null, "dc00898", "", "", "0X8009E15", "0X8009E15", 0, 0, "", "", str2, "");
                    return;
                }
                ReportController.r(null, "dc00898", "", "", "0X8009E14", "0X8009E14", 0, 0, "", "", str2, "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements INetInfoHandler {
        b() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            QLog.e("ark.download.module", 1, "onNetMobile2None");
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            QLog.e("ark.download.module", 1, "onNetMobile2Wifi", str);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            QLog.e("ark.download.module", 1, "ark.dctrl.onNetNone2Mobile", str);
            Activity topActivity = Foreground.getTopActivity();
            if (ArkAppDownloadModule.this.f198895s && !ArkAppDownloadModule.this.f198893q && topActivity != null && ArkAppDownloadModule.this.Q(topActivity.getString(R.string.f170463ru))) {
                ArkAppDownloadModule.this.f198893q = true;
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            QLog.e("ark.download.module", 1, "onNetNone2Wifi", str);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            QLog.e("ark.download.module", 1, "onNetWifi2Mobile", str);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            QLog.e("ark.download.module", 1, "onNetWifi2None");
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    interface c {
        void a(WadlResult wadlResult);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    interface d {
        void a(ArrayList<WadlResult> arrayList);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    interface e {
        void a(ArrayList<WadlResult> arrayList);
    }

    public ArkAppDownloadModule(ark.Application application, int i3) {
        super(application, i3);
        this.f198893q = false;
        this.f198895s = false;
        this.f198892p = new ArrayList<>();
        this.f198888l = new a();
        WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this.f198888l);
        this.f198894r = new b();
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            AppNetConnInfo.registerConnectionChangeReceiver(topActivity, this.f198894r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int L(final Context context, double d16, final WadlParams wadlParams) {
        boolean z16;
        if (context != null) {
            final SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(IArkModuleAPIAuthority.SP_ARK_AUTHORITY, 0);
            final String str = "key_download_show_not_wifi_dialog" + wadlParams.appId;
            if (sharedPreferences != null) {
                z16 = sharedPreferences.getBoolean(str, true);
            } else {
                z16 = true;
            }
            if (d16 > Utils.z()) {
                ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.9

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule$9$a */
                    /* loaded from: classes11.dex */
                    class a implements DialogInterface.OnClickListener {
                        a() {
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        DialogUtil.createCustomDialog(Foreground.getTopActivity(), 230, (String) null, context.getString(R.string.f170455rl), (String) null, context.getString(R.string.f170459rp), new a(), (DialogInterface.OnClickListener) null).show();
                        ReportController.r(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "5", "", wadlParams.appId, "");
                    }
                });
                return 2;
            }
            if (z16 && NetworkUtil.isNetworkAvailable(context) && NetworkUtil.getNetworkType(context) != 1) {
                final String format = String.format(context.getString(R.string.f170461rr), ao.a((long) d16));
                final String string = context.getString(R.string.f170460rq);
                ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.10

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule$10$a */
                    /* loaded from: classes11.dex */
                    class a implements DialogInterface.OnClickListener {
                        a() {
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            WadlProxyServiceUtil.getProxyService().doDownloadAction(wadlParams);
                            ArkAppDownloadModule.this.f198895s = true;
                            ReportController.r(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "7", "", wadlParams.appId, "");
                            if (dialogInterface instanceof QQCustomDialog) {
                                boolean z16 = !((QQCustomDialog) dialogInterface).getCheckBoxState();
                                SharedPreferences sharedPreferences = sharedPreferences;
                                if (sharedPreferences != null) {
                                    try {
                                        sharedPreferences.edit().putBoolean(str, z16).apply();
                                    } catch (Exception e16) {
                                        QLog.e("ark.download.module", 1, "start download sp error : ", e16);
                                    }
                                }
                            }
                        }
                    }

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule$10$b */
                    /* loaded from: classes11.dex */
                    class b implements DialogInterface.OnClickListener {
                        b() {
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                            ReportController.r(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "8", "", wadlParams.appId, "");
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Context context2 = context;
                        if (context2 == null) {
                            QLog.e("ark.download.module", 1, "start download context is null");
                            return;
                        }
                        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context2, 230, (String) null, format, context2.getString(R.string.cancel), context.getString(R.string.f170453rj), new a(), new b());
                        createCustomDialog.setCheckBox(string, null);
                        createCustomDialog.show();
                        ReportController.r(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "6", "", wadlParams.appId, "");
                    }
                });
                return 2;
            }
        }
        WadlProxyServiceUtil.getProxyService().doDownloadAction(wadlParams);
        this.f198895s = true;
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String M(int i3) {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            if (i3 != 1) {
                if (i3 != 3) {
                    return topActivity.getString(R.string.f170458ro);
                }
                return topActivity.getString(R.string.f170457rn);
            }
            return topActivity.getString(R.string.f170456rm);
        }
        return "";
    }

    private JSONObject N(WadlParams wadlParams, String str) {
        int i3;
        try {
            JSONObject jSONObject = new JSONObject();
            if (wadlParams != null) {
                jSONObject.put("actionCode", wadlParams.actionCode);
                jSONObject.put("appId", wadlParams.appId);
                jSONObject.put("apkUrl", wadlParams.apkUrl);
                jSONObject.put(WadlProxyConsts.APKSIGN, wadlParams.apkSign);
                jSONObject.put("versionCode", wadlParams.versionCode);
                jSONObject.put("packageName", wadlParams.packageName);
                jSONObject.put("appName", wadlParams.appName);
                if (wadlParams.delayDownload) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                jSONObject.put("delayDownload", i3);
                jSONObject.put("fromWebUrl", wadlParams.fromWebUrl);
                jSONObject.put("apkChannel", wadlParams.apkChannel);
                jSONObject.put("via", wadlParams.via);
                jSONObject.put("yyStartTime", wadlParams.yyStartTime);
                jSONObject.put("yyEndTime", wadlParams.yyEndTime);
                jSONObject.put("adtag", wadlParams.adtag);
                jSONObject.put("from", wadlParams.from);
                jSONObject.put(WadlProxyConsts.FLAGS, wadlParams.flags);
                jSONObject.put(WadlProxyConsts.EXTRA_DATA, wadlParams.extraData);
                jSONObject.put("sourceId", wadlParams.sourceId);
            }
            return jSONObject;
        } catch (Exception e16) {
            QLog.i("ark.download.module", 1, str + " parseWadlParams error::", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject O(WadlResult wadlResult, String str) {
        JSONObject N;
        try {
            JSONObject jSONObject = new JSONObject();
            if (wadlResult == null) {
                jSONObject.put("taskStatus", -1);
                jSONObject.put("progress", 0);
            } else {
                WadlParams wadlParams = wadlResult.wadlParams;
                if (wadlParams != null && (N = N(wadlParams, str)) != null) {
                    jSONObject.put("wadlParams", N.toString());
                }
                jSONObject.put("event", wadlResult.event);
                jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, wadlResult.taskId);
                jSONObject.put("taskStatus", wadlResult.taskStatus);
                jSONObject.put("fileSize", wadlResult.fileSize);
                jSONObject.put("downloadFileSize", wadlResult.downloadFileSize);
                jSONObject.put("downloadFilePath", wadlResult.downloadFilePath);
                jSONObject.put(WadlProxyConsts.CREATE_TIME, wadlResult.createTime);
                jSONObject.put("errCode", GameCenterUtil.getWadlErrCode(wadlResult.errCode));
                jSONObject.put("progress", wadlResult.progress);
            }
            return jSONObject;
        } catch (Exception e16) {
            QLog.i("ark.download.module", 1, str + " parseWadlResult error::", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray P(ArrayList<WadlResult> arrayList, String str) {
        JSONObject O;
        if (arrayList != null && arrayList.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<WadlResult> it = arrayList.iterator();
            while (it.hasNext()) {
                WadlResult next = it.next();
                if (next != null && (O = O(next, str)) != null) {
                    jSONArray.mo162put(O);
                }
            }
            return jSONArray;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q(final String str) {
        try {
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.8
                @Override // java.lang.Runnable
                public void run() {
                    Activity topActivity = Foreground.getTopActivity();
                    if (topActivity != null) {
                        QQToast.makeText(topActivity, str, 0).show();
                    }
                }
            });
            return true;
        } catch (Exception e16) {
            QLog.i("ark.download.module", 1, " showToast error::", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public void Destruct() {
        super.Destruct();
        WadlProxyServiceUtil.getProxyService().unRegisterWadlServiceCallBack(this.f198888l);
        this.f198888l = null;
        this.f198889m = null;
        this.f198890n = null;
        AppNetConnInfo.unregisterNetInfoHandler(this.f198894r);
        this.f198894r = null;
        ArrayList<Long> arrayList = this.f198892p;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < this.f198892p.size(); i3++) {
                l(this.f198892p.get(i3).longValue());
            }
            this.f198892p.clear();
        }
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public String GetTypeName() {
        return "QQDownload";
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean HasMethod(String str) {
        if (str.equals("QueryPackageState") || str.equals("QueryPackageStateVia") || str.equals("StartDownload") || str.equals("PauseDownload") || str.equals("ContinueDownload") || str.equals("InstallPackage") || str.equals("DownloadInit") || str.equals("QueryPackageInfo")) {
            return true;
        }
        return str.equals("DeletePackage");
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean Invoke(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        boolean z16;
        boolean z17;
        ArrayList<String> arrayList;
        String str2;
        String str3;
        int i3;
        if (!com.tencent.mobileqq.ark.module.a.a(this.f199566b, this.f199565a, this.f199570f, "permission.DOWNLOAD")) {
            QLog.i("ark.download.module", 1, "ark.dctrl.ArkAppDownloadModule.invokeFunc permission denied");
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null) {
                Q(topActivity.getString(R.string.f170462rt));
            }
            return false;
        }
        QLog.i("ark.download.module", 1, String.format("ark.dctrl.ArkAppDownloadModule.invokeFunc.%s", str));
        int i16 = 2;
        if (str.equals("QueryPackageState")) {
            if (variantWrapperArr == null || variantWrapperArr.length < 2 || !variantWrapperArr[0].IsString()) {
                return false;
            }
            String GetString = variantWrapperArr[0].GetString();
            final long g16 = g(variantWrapperArr[1].Copy());
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(GetString);
            QLog.i("ark.download.module", 1, String.format("ark.dctrl.QueryPackageState.appid:%s", Long.valueOf(g16)));
            this.f198889m = new d() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.1
                @Override // com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.d
                public void a(final ArrayList<WadlResult> arrayList3) {
                    ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(((com.tencent.mobileqq.ark.module.b) ArkAppDownloadModule.this).f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String str4;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            ark.VariantWrapper l3 = ArkAppDownloadModule.this.l(g16);
                            if (l3 == null) {
                                QLog.i("ark.download.module", 1, "ark.dctrl.onQueryPackageState Callback is null");
                                return;
                            }
                            ark.VariantWrapper Create = l3.Create();
                            Create.SetNull();
                            ark.VariantWrapper Create2 = l3.Create();
                            JSONArray P = ArkAppDownloadModule.this.P(arrayList3, "QueryPackageState");
                            if (P != null) {
                                str4 = P.toString();
                            } else {
                                str4 = "";
                            }
                            Create.SetTableAsJsonString(str4);
                            l3.InvokeDefault(new ark.VariantWrapper[]{Create}, Create2);
                            Create2.Reset();
                            Create.Reset();
                            l3.Reset();
                            QLog.i("ark.download.module", 1, "ark.dctrl.onQueryPackageState result:" + str4);
                        }
                    });
                }
            };
            if (arrayList2.size() > 0) {
                WadlProxyServiceUtil.getProxyService().doQueryAction(arrayList2);
            }
            return true;
        }
        if (str.equals("QueryPackageInfo")) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 1 && variantWrapperArr[0].IsString()) {
                try {
                    String GetString2 = variantWrapperArr[0].GetString();
                    if (QLog.isColorLevel()) {
                        QLog.i("ark.download.module", 1, "QueryPackageInfo pkgName:" + GetString2);
                    }
                    PackageInfo packageInfo = GameCenterUtil.getPackageInfo(GetString2);
                    if (packageInfo != null) {
                        i3 = packageInfo.versionCode;
                        str2 = packageInfo.versionName;
                        str3 = GameCenterUtil.getFileChannel(GameCenterUtil.getApkSourceDir(GetString2));
                    } else {
                        str2 = "";
                        str3 = "";
                        i3 = 0;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("packageName", GetString2);
                    jSONObject.put("versionCode", i3);
                    jSONObject.put("versionName", str2);
                    jSONObject.put(WadlProxyConsts.CHANNEL, str3);
                    if (QLog.isColorLevel()) {
                        QLog.i("ark.download.module", 1, "QueryPackageInfo result:" + jSONObject.toString());
                    }
                    variantWrapper.SetTableAsJsonString(jSONObject.toString());
                    return true;
                } catch (Throwable th5) {
                    QLog.i("ark.download.module", 1, "QueryPackageInfo result fail:" + th5.getMessage());
                }
            }
            return false;
        }
        if (str.equals("QueryPackageStateVia")) {
            if (variantWrapperArr == null || variantWrapperArr.length < 2 || !variantWrapperArr[0].IsString()) {
                return false;
            }
            String GetString3 = variantWrapperArr[0].GetString();
            QLog.i("ark.download.module", 1, String.format("ark.dctrl.QueryPackageStateVia.via:%s", GetString3));
            final long g17 = g(variantWrapperArr[1].Copy());
            this.f198890n = new e() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.2
                @Override // com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.e
                public void a(final ArrayList<WadlResult> arrayList3) {
                    ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(((com.tencent.mobileqq.ark.module.b) ArkAppDownloadModule.this).f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String str4;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            ark.VariantWrapper l3 = ArkAppDownloadModule.this.l(g17);
                            if (l3 == null) {
                                QLog.d("ark.download.module", 1, "ark.dctrl.onQueryPackageStateVia Callback is null");
                                return;
                            }
                            ark.VariantWrapper Create = l3.Create();
                            Create.SetNull();
                            ark.VariantWrapper Create2 = l3.Create();
                            JSONArray P = ArkAppDownloadModule.this.P(arrayList3, "QueryPackageStateVia");
                            if (P != null) {
                                str4 = P.toString();
                            } else {
                                str4 = "";
                            }
                            Create.SetTableAsJsonString(str4);
                            l3.InvokeDefault(new ark.VariantWrapper[]{Create}, Create2);
                            Create2.Reset();
                            Create.Reset();
                            l3.Reset();
                            QLog.e("ark.download.module", 1, "ark.dctrl.QueryPackageStateVia result : " + str4);
                        }
                    });
                }
            };
            if (!TextUtils.isEmpty(GetString3)) {
                WadlProxyServiceUtil.getProxyService().doQueryActionByVia(GetString3);
            }
            return true;
        }
        if (str.equals("DownloadInit")) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 1) {
                long g18 = g(variantWrapperArr[0].Copy());
                QLog.i("ark.download.module", 1, "ark.dctrl.DownloadInit callbackid=" + g18);
                this.f198891o = new c() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.3
                    @Override // com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.c
                    public void a(final WadlResult wadlResult) {
                        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(((com.tencent.mobileqq.ark.module.b) ArkAppDownloadModule.this).f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                String str4;
                                if (ArkAppDownloadModule.this.f198892p != null && ArkAppDownloadModule.this.f198892p.size() > 0) {
                                    for (int i17 = 0; i17 < ArkAppDownloadModule.this.f198892p.size(); i17++) {
                                        ArkAppDownloadModule arkAppDownloadModule = ArkAppDownloadModule.this;
                                        ark.VariantWrapper d16 = arkAppDownloadModule.d(((Long) arkAppDownloadModule.f198892p.get(i17)).longValue());
                                        if (d16 != null && wadlResult != null) {
                                            ark.VariantWrapper Create = d16.Create();
                                            Create.SetNull();
                                            ark.VariantWrapper Create2 = d16.Create();
                                            int convertRemoteStatusToLocal = GameCenterUtil.convertRemoteStatusToLocal(wadlResult.taskStatus);
                                            if (-2 == convertRemoteStatusToLocal) {
                                                int wadlErrCode = GameCenterUtil.getWadlErrCode(wadlResult.errCode);
                                                String M = ArkAppDownloadModule.this.M(wadlErrCode);
                                                if (!TextUtils.isEmpty(M)) {
                                                    ArkAppDownloadModule.this.Q(M);
                                                }
                                                QLog.e("ark.download.module", 1, "ark.dctrl.download error code:", Integer.valueOf(wadlErrCode));
                                                if ((wadlErrCode == 4 || wadlErrCode == 5) && wadlResult.wadlParams != null) {
                                                    WadlProxyServiceWrap proxyService = WadlProxyServiceUtil.getProxyService();
                                                    WadlParams wadlParams = wadlResult.wadlParams;
                                                    proxyService.deleteDownload(wadlParams.from, wadlParams.appId);
                                                }
                                            } else if (2 == convertRemoteStatusToLocal) {
                                                ArkAppDownloadModule.this.f198895s = true;
                                            }
                                            JSONObject O = ArkAppDownloadModule.this.O(wadlResult, "DownloadInit");
                                            if (O != null) {
                                                str4 = O.toString();
                                            } else {
                                                str4 = "";
                                            }
                                            Create.SetTableAsJsonString(str4);
                                            d16.InvokeDefault(new ark.VariantWrapper[]{Create}, Create2);
                                            Create2.Reset();
                                            Create.Reset();
                                            QLog.i("ark.download.module", 1, "ark.dctrl.onDownloadState callback : " + str4);
                                        } else {
                                            QLog.d("ark.download.module", 1, "ark.dctrl.onDownloadState Callback is null");
                                            return;
                                        }
                                    }
                                }
                            }
                        });
                    }
                };
                this.f198892p.add(Long.valueOf(g18));
                variantWrapper.SetBool(true);
                return true;
            }
            variantWrapper.SetBool(false);
            return true;
        }
        if (str.equals("StartDownload")) {
            if (this.f198891o == null) {
                QLog.e("ark.download.module", 1, "should DownloadInit first ");
                variantWrapper.SetInt(-1);
                return true;
            }
            final Activity topActivity2 = Foreground.getTopActivity();
            if (variantWrapperArr != null && variantWrapperArr.length >= 2 && variantWrapperArr[0].IsString()) {
                String GetString4 = variantWrapperArr[0].GetString();
                final double GetDouble = variantWrapperArr[1].GetDouble();
                final WadlParams wadlParams = new WadlParams(GetString4);
                int i17 = wadlParams.actionCode;
                if (i17 == 12) {
                    ReportController.r(null, "dc00898", "", "", "0X8009E12", "0X8009E12", 0, 0, "", "", wadlParams.appId, "");
                } else if (i17 == 2) {
                    ReportController.r(null, "dc00898", "", "", "0X8009E11", "0X8009E11", 0, 0, "", "", wadlParams.appId, "");
                }
                g arkPlatformConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkPlatformConfig();
                if (arkPlatformConfig != null && arkPlatformConfig.c() != null && (arrayList = arkPlatformConfig.c().f395985o) != null && arrayList.contains(this.f199566b)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                QLog.d("ark.download.module", 1, "ark.dctrl [StartDownload] mAppName:", this.f199566b, ",showDownloadCtrlDialog=", Boolean.valueOf(z17), ",appid=", wadlParams.appId, ",name=", wadlParams.appName, ",iconUrl:", wadlParams.iconUrl);
                if (z17) {
                    ArkDownloadController.i().l(this.f199566b, wadlParams.appId, wadlParams.appName, wadlParams.iconUrl, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i18) {
                            WadlParams wadlParams2 = wadlParams;
                            QLog.d("ark.download.module", 1, "ark.dctrl [StartDownload] dialog callback appid=", wadlParams2.appId, ",name=", wadlParams2.appName, ",which:", Integer.valueOf(i18));
                            if (i18 == 1) {
                                ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(((com.tencent.mobileqq.ark.module.b) ArkAppDownloadModule.this).f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                        ArkAppDownloadModule.this.L(topActivity2, GetDouble, wadlParams);
                                    }
                                });
                            }
                        }
                    });
                } else {
                    i16 = L(topActivity2, GetDouble, wadlParams);
                }
            } else {
                i16 = -2;
            }
            variantWrapper.SetInt(i16);
            return true;
        }
        if (str.equals("PauseDownload")) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 2 && variantWrapperArr[1].IsString()) {
                int GetInt = variantWrapperArr[0].GetInt();
                String GetString5 = variantWrapperArr[1].GetString();
                QLog.d("ark.download.module", 1, "ark.dctrl.pause download appid:", GetString5, ",from:", Integer.valueOf(GetInt));
                WadlProxyServiceUtil.getProxyService().doPauseAction(GetInt, GetString5);
                variantWrapper.SetBool(true);
                ReportController.r(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "1", "", GetString5, "");
                return true;
            }
            variantWrapper.SetBool(false);
            return true;
        }
        if (str.equals("ContinueDownload")) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 2 && variantWrapperArr[1].IsString()) {
                final int GetInt2 = variantWrapperArr[0].GetInt();
                final String GetString6 = variantWrapperArr[1].GetString();
                QLog.d("ark.download.module", 1, "ark.dctrl.continue download appid:", GetString6, ",from:", Integer.valueOf(GetInt2));
                final Activity topActivity3 = Foreground.getTopActivity();
                final SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(IArkModuleAPIAuthority.SP_ARK_AUTHORITY, 0);
                final String str4 = "key_download_show_not_wifi_dialog" + GetString6;
                if (sharedPreferences != null) {
                    z16 = sharedPreferences.getBoolean(str4, true);
                } else {
                    z16 = true;
                }
                if (z16 && topActivity3 != null && NetworkUtil.isNetworkAvailable(topActivity3) && NetworkUtil.getNetworkType(topActivity3) != 1) {
                    final String string = topActivity3.getString(R.string.f170454rk);
                    final String string2 = topActivity3.getString(R.string.f170460rq);
                    ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.5

                        /* compiled from: P */
                        /* renamed from: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule$5$a */
                        /* loaded from: classes11.dex */
                        class a implements DialogInterface.OnClickListener {
                            a() {
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                ArkAppDownloadModule.this.f198895s = true;
                                WadlProxyServiceWrap proxyService = WadlProxyServiceUtil.getProxyService();
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                proxyService.doResumeAction(GetInt2, GetString6);
                                ReportController.r(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "7", "", GetString6, "");
                                if (dialogInterface instanceof QQCustomDialog) {
                                    boolean z16 = !((QQCustomDialog) dialogInterface).getCheckBoxState();
                                    SharedPreferences sharedPreferences = sharedPreferences;
                                    if (sharedPreferences != null) {
                                        try {
                                            sharedPreferences.edit().putBoolean(str4, z16).apply();
                                        } catch (Exception e16) {
                                            QLog.e("ark.download.module", 1, "ark.dctrl.continue download sp error : ", e16);
                                        }
                                    }
                                }
                            }
                        }

                        /* compiled from: P */
                        /* renamed from: com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule$5$b */
                        /* loaded from: classes11.dex */
                        class b implements DialogInterface.OnClickListener {
                            b() {
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                                ReportController.r(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "8", "", GetString6, "");
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Context context = topActivity3;
                            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, string, context.getString(R.string.cancel), topActivity3.getString(R.string.f170453rj), new a(), new b());
                            createCustomDialog.setCheckBox(string2, null);
                            createCustomDialog.show();
                            ReportController.r(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "6", "", GetString6, "");
                        }
                    });
                    variantWrapper.SetBool(true);
                    return true;
                }
                WadlProxyServiceUtil.getProxyService().doResumeAction(GetInt2, GetString6);
                this.f198895s = true;
                ReportController.r(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "2", "", GetString6, "");
                variantWrapper.SetBool(true);
                return true;
            }
            variantWrapper.SetBool(false);
            return true;
        }
        if (str.equals("InstallPackage")) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 1 && variantWrapperArr[0].IsString()) {
                String GetString7 = variantWrapperArr[0].GetString();
                QLog.d("ark.download.module", 1, "ark.dctrl.install package:", GetString7);
                WadlParams wadlParams2 = new WadlParams(GetString7);
                WadlProxyServiceUtil.getProxyService().doInstallAction(wadlParams2);
                ReportController.r(null, "dc00898", "", "", "0X8009E16", "0X8009E16", 0, 0, "", "", wadlParams2.appId, "");
                variantWrapper.SetBool(true);
                return true;
            }
            variantWrapper.SetBool(false);
            return true;
        }
        if (!str.equals("DeletePackage")) {
            return false;
        }
        if (variantWrapperArr != null && variantWrapperArr.length >= 2 && variantWrapperArr[1].IsString()) {
            int GetInt3 = variantWrapperArr[0].GetInt();
            String GetString8 = variantWrapperArr[1].GetString();
            QLog.d("ark.download.module", 1, "ark.dctrl.delete package appId:", GetString8, ",from:", Integer.valueOf(GetInt3));
            WadlProxyServiceUtil.getProxyService().deleteDownload(GetInt3, GetString8);
            variantWrapper.SetBool(true);
            return true;
        }
        variantWrapper.SetBool(false);
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    protected com.tencent.mobileqq.ark.module.e[] e() {
        return null;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean n() {
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean o() {
        return true;
    }
}
