package com.tencent.mobileqq.intervideo.now.dynamic;

import android.content.Context;
import android.os.Bundle;
import com.tencent.intervideo.nowproxy.ability.ExtSdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.DownloadCallback;
import com.tencent.qqinterface.QQBaseAbilityInterface;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQBaseAbilityInterfaceImpl implements QQBaseAbilityInterface {
    SdkBaseAbilityImpl baseHolder = SdkBaseAbilityImpl.getsInstance();

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void beaconReportData(Bundle bundle, int i3) {
        ExtSdkBizAbilityImpl.getInstance().beaconReportData(bundle, i3);
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void doCgiReq(Bundle bundle, CommonCallback<Bundle> commonCallback) {
        this.baseHolder.doCgiReq(bundle, commonCallback);
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void download(Bundle bundle, final DownloadCallback downloadCallback) {
        String string = bundle.getString("url", "");
        final String string2 = bundle.getString("path", "");
        this.baseHolder.download(bundle.getBoolean(VRReportDefine$ReportParam.IS_PRE_DOWNLOAD, false), string, string2, bundle.getBundle(QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA), new com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback() { // from class: com.tencent.mobileqq.intervideo.now.dynamic.QQBaseAbilityInterfaceImpl.1
            @Override // com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback
            public void onDownloadError(int i3, int i16, String str) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("errCode", i3);
                bundle2.putInt("httpCode", i16);
                bundle2.putString("errMsg", str);
                downloadCallback.onResult(bundle2);
            }

            @Override // com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback
            public void onDownloadSuccess(String str) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("errCode", 0);
                bundle2.putString("errMsg", "Download Success");
                bundle2.putString("filePath", string2);
                downloadCallback.onResult(bundle2);
            }

            @Override // com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback
            public void onProgress(int i3, int i16) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("downloadSize", i3);
                bundle2.putLong("totalSize", i16);
                if (i16 == 0) {
                    bundle2.putInt("percent", 0);
                } else {
                    bundle2.putInt("percent", (i3 / i16) * 100);
                }
                downloadCallback.onProgress(bundle2);
            }

            @Override // com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback
            public void onDownloadCancel() {
            }
        });
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public Future<Bundle> getA1(String str, String str2, String str3, String str4) {
        return this.baseHolder.getA1(str, str2, str3, str4);
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public Future<Bundle> getAccessToken(String str, String str2) {
        return this.baseHolder.getAccessToken(str, str2);
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public String getSelfUin() {
        return "";
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public Bundle getTickets() {
        return this.baseHolder.getTickets();
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void hasPluginLoaded() {
        this.baseHolder.hasPluginLoaded();
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public boolean isMobileNet() {
        return false;
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void openWebView(Bundle bundle) {
        this.baseHolder.openWebView(bundle, null);
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void printQLog(Bundle bundle) {
        this.baseHolder.printQLog(bundle);
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void reportData(Bundle bundle) {
        this.baseHolder.reportData(bundle);
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public String reqDns(String str) {
        return this.baseHolder.reqDns(str);
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void sendSSOTask(Bundle bundle, CommonCallback<Bundle> commonCallback) {
        this.baseHolder.sendSSOTask(bundle, commonCallback);
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void showToast(Context context, CharSequence charSequence, int i3) {
        this.baseHolder.showToast(context, charSequence, i3);
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public boolean useIpDirectConnect() {
        return this.baseHolder.useIpDirectConnect();
    }

    @Override // com.tencent.qqinterface.QQBaseAbilityInterface
    public void jumpAction(String str) {
    }
}
