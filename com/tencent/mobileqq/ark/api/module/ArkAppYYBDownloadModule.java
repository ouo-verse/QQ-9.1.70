package com.tencent.mobileqq.ark.api.module;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appcommon.js.e;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes11.dex */
public class ArkAppYYBDownloadModule extends ArkAppQQModuleBase {

    /* renamed from: l, reason: collision with root package name */
    private DownloadListener f199035l;

    /* renamed from: m, reason: collision with root package name */
    private e f199036m;

    /* renamed from: n, reason: collision with root package name */
    private ArrayList<Long> f199037n;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements DownloadListener {
        a() {
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void installSucceed(String str, String str2) {
            ArkAppYYBDownloadModule.r(ArkAppYYBDownloadModule.this);
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadCancel(DownloadInfo downloadInfo) {
            if (downloadInfo != null) {
                ArkAppYYBDownloadModule.r(ArkAppYYBDownloadModule.this);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadError(DownloadInfo downloadInfo, int i3, String str, int i16) {
            if (downloadInfo != null) {
                ArkAppYYBDownloadModule.r(ArkAppYYBDownloadModule.this);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadFinish(DownloadInfo downloadInfo) {
            if (downloadInfo != null) {
                ArkAppYYBDownloadModule.r(ArkAppYYBDownloadModule.this);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadPause(DownloadInfo downloadInfo) {
            if (downloadInfo != null) {
                ArkAppYYBDownloadModule.r(ArkAppYYBDownloadModule.this);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadUpdate(List<DownloadInfo> list) {
            if (list != null) {
                ArkAppYYBDownloadModule.r(ArkAppYYBDownloadModule.this);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void onDownloadWait(DownloadInfo downloadInfo) {
            if (downloadInfo != null) {
                ArkAppYYBDownloadModule.r(ArkAppYYBDownloadModule.this);
            }
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void packageReplaced(String str, String str2) {
            ArkAppYYBDownloadModule.r(ArkAppYYBDownloadModule.this);
        }

        @Override // com.tencent.open.downloadnew.DownloadListener
        public void uninstallSucceed(String str, String str2) {
            ArkAppYYBDownloadModule.r(ArkAppYYBDownloadModule.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    interface b {
    }

    public ArkAppYYBDownloadModule(ark.Application application, int i3) {
        super(application, i3);
        this.f199036m = null;
        QLog.i("ArkApp.downloadyyb.module", 1, "init");
        this.f199037n = new ArrayList<>();
        this.f199035l = new a();
    }

    static /* bridge */ /* synthetic */ b r(ArkAppYYBDownloadModule arkAppYYBDownloadModule) {
        arkAppYYBDownloadModule.getClass();
        return null;
    }

    private void u(int i3, JSONArray jSONArray, final long j3) {
        try {
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < length; i16++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i16);
                DownloadInfo downloadInfo = new DownloadInfo();
                downloadInfo.f341186f = jSONObject.optString("url");
                downloadInfo.f341189h = jSONObject.optString("packageName");
                downloadInfo.I = jSONObject.optInt("versionCode");
                downloadInfo.f341184e = jSONObject.optString("appId");
                downloadInfo.m();
                arrayList.add(downloadInfo);
            }
            QLog.d("ArkApp.downloadyyb.module", 1, "queryPackageStateYYB action is " + i3);
            if (i3 == 1 && arrayList.size() > 0) {
                BaseActivity baseActivity = BaseActivity.sTopActivity;
                JSONArray jSONArray2 = new JSONArray();
                for (int i17 = 0; i17 < arrayList.size(); i17++) {
                    DownloadInfo downloadInfo2 = (DownloadInfo) arrayList.get(i17);
                    boolean isAppInstalled = PackageUtil.isAppInstalled(baseActivity, downloadInfo2.f341189h);
                    JSONObject t16 = t(downloadInfo2);
                    t16.put("isInstall", isAppInstalled);
                    jSONArray2.mo162put(t16);
                }
                final String jSONArray3 = jSONArray2.toString();
                ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(this.f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppYYBDownloadModule.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ark.VariantWrapper l3 = ArkAppYYBDownloadModule.this.l(j3);
                            if (l3 == null) {
                                QLog.d("ArkApp.downloadyyb.module", 1, "onQueryPackageState Callback is null");
                                return;
                            }
                            ark.VariantWrapper Create = l3.Create();
                            Create.SetNull();
                            ark.VariantWrapper Create2 = l3.Create();
                            Create.SetTableAsJsonString(jSONArray3);
                            l3.InvokeDefault(new ark.VariantWrapper[]{Create}, Create2);
                            Create2.Reset();
                            Create.Reset();
                            l3.Reset();
                            if (QLog.isColorLevel()) {
                                QLog.i("ArkApp.downloadyyb.module", 1, "queryPackageStateYYB : " + jSONArray3);
                            }
                        } catch (Exception e16) {
                            QLog.e("ArkApp.downloadyyb.module", 1, "QUERRY_PACKAGE_INSTALL  : " + e16);
                        }
                    }
                });
            }
        } catch (Exception e16) {
            QLog.e("ArkApp.downloadyyb.module", 1, "[innerQuery] e=", e16);
        }
    }

    private boolean v(final String str) {
        try {
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppYYBDownloadModule.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseActivity baseActivity = BaseActivity.sTopActivity;
                    if (baseActivity != null) {
                        QQToast.makeText(baseActivity, str, 0).show();
                    }
                }
            });
            return true;
        } catch (Exception e16) {
            QLog.e("ArkApp.downloadyyb.module", 1, " showToast error::", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public void Destruct() {
        ArrayList<Long> arrayList = this.f199037n;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < this.f199037n.size(); i3++) {
                l(this.f199037n.get(i3).longValue());
            }
            this.f199037n.clear();
        }
        this.f199035l = null;
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public String GetTypeName() {
        return "QQYYBDownload";
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean HasMethod(String str) {
        if (str.equals("getQueryDownloadAction") || str.equals(WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION) || str.equals("RegisterDownloadCallBackListener")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean Invoke(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (!com.tencent.mobileqq.ark.module.a.a(this.f199566b, this.f199565a, this.f199570f, "permission.YYB_DOWNLOAD")) {
            QLog.i("ArkApp.downloadyyb.module", 1, "ArkAppYYBDownloadModule.invokeFunc permission denied");
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            if (baseActivity != null) {
                v(baseActivity.getString(R.string.f170462rt));
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ArkApp.downloadyyb.module", 1, String.format("ArkAppYYBDownloadModule.invokeFunc.%s", str));
        }
        if (str.equals("getQueryDownloadAction")) {
            if (variantWrapperArr != null && variantWrapperArr.length >= 2 && variantWrapperArr[0].IsString()) {
                String GetString = variantWrapperArr[0].GetString();
                long g16 = g(variantWrapperArr[1].Copy());
                if (QLog.isColorLevel()) {
                    QLog.i("ArkApp.downloadyyb.module", 1, "<getQueryDownloadAction> paramJson=" + GetString);
                }
                try {
                    JSONObject jSONObject = new JSONObject(GetString);
                    u(jSONObject.optInt("actioncode"), new JSONArray(jSONObject.optString("queryParams")), g16);
                } catch (JSONException e16) {
                    QLog.e("ArkApp.downloadyyb.module", 1, "[queryDownloadAction] e=" + e16.getMessage());
                }
            }
            return true;
        }
        if (str.equals(WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION)) {
            QLog.e("ArkApp.downloadyyb.module", 1, "should DownloadInit first ");
            variantWrapper.SetInt(-2);
            return true;
        }
        if (!str.equals("RegisterDownloadCallBackListener")) {
            return false;
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
        return false;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean o() {
        return true;
    }

    public JSONObject t(DownloadInfo downloadInfo) {
        JSONObject jSONObject = new JSONObject();
        if (downloadInfo != null) {
            try {
                jSONObject.put("appid", downloadInfo.f341184e);
                jSONObject.put("state", downloadInfo.f());
                jSONObject.put(WadlResult.WEB_KEY_PROGRESS, downloadInfo.Q);
                jSONObject.put("packagename", downloadInfo.f341189h);
                if (TextUtils.isEmpty(downloadInfo.L)) {
                    jSONObject.put("final_file_exits", "false");
                } else {
                    jSONObject.put("final_file_exits", new File(downloadInfo.L).exists());
                }
            } catch (JSONException e16) {
                QLog.e("ArkApp.downloadyyb.module", 1, "tranDownloadToJSONObject ", e16);
            }
        }
        return jSONObject;
    }
}
