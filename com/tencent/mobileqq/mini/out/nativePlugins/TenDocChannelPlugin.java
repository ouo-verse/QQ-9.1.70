package com.tencent.mobileqq.mini.out.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import lr2.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class TenDocChannelPlugin implements NativePlugin {
    private static final String ACTION_IMPORT = "openLocalFilesToImport";
    private static final String ACTION_OPEN_EXPORT = "openExportedFile";
    private static final String ACTION_START_EXPORT = "txDocsStartExport";
    public static final String PLUGIN_NAME = "tdoc_channel";
    public static final String TAG = "TenDocChannelPlugin";

    private synchronized void handleDownloadExportedFile(Activity activity, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean optBoolean = jSONObject.optBoolean("success");
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString(WadlProxyConsts.PARAM_FILENAME);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSuccess", optBoolean);
            bundle.putString("url", optString);
            bundle.putString(WadlProxyConsts.PARAM_FILENAME, optString2);
            String url = (!(activity instanceof TeamWorkDocEditBrowserActivity) || ((TeamWorkDocEditBrowserActivity) activity).getHostWebView() == null) ? null : ((TeamWorkDocEditBrowserActivity) activity).getHostWebView().getUrl();
            if (TextUtils.isEmpty(url)) {
                url = jSONObject.optString("refer_url");
            }
            bundle.putString("docUrl", url);
            bundle.putString("cookie", CookieManager.getInstance().getCookie(optString));
            bundle.putBoolean(ITeamWorkUtils.FILE_BROWSER_PARAMS_KEY_MINI_PROGRAM, true);
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "TeamWorkModule", "action_download_export_file", bundle);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "downloadExportedFile exception e = " + e16.toString());
        }
    }

    private synchronized void handleStartExportedFile(Activity activity, String str) {
        try {
            String optString = new JSONObject(str).optString(WadlProxyConsts.PARAM_FILENAME);
            Bundle bundle = new Bundle();
            bundle.putString(WadlProxyConsts.PARAM_FILENAME, optString);
            QLog.d(TAG, 1, "downloadExportedFile handleStartExportedFile out");
            bundle.putBoolean(ITeamWorkUtils.FILE_BROWSER_PARAMS_KEY_MINI_PROGRAM, true);
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "TeamWorkModule", "action_start_export_file", bundle);
            a.j(null, "0X800A4B2");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "startExportedFile exception e = " + e16.toString());
        }
    }

    private synchronized void openFMActivityToImport(Activity activity, String str) {
        try {
            String optString = new JSONObject(str).optString("folderId");
            Intent intent = new Intent();
            intent.setClassName(activity, "com.tencent.mobileqq.filemanager.activity.FMActivity.class");
            intent.putExtra(t.f292401f, true);
            intent.addFlags(536870912);
            intent.putExtra("selectMode", true);
            intent.putExtra(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, 9);
            intent.putExtra("peerType", 10006);
            intent.putExtra("enterfrom", 9);
            intent.putExtra("tab_tab_type", 7);
            intent.putExtra("only_show_local_tab", true);
            intent.putExtra(t.f292402g, optString);
            intent.putExtra("smart_device_support_flag", 8);
            activity.startActivity(intent);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "openFMActivityToImport exception", e16);
        }
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
            String string = jSONObject2.getString("action");
            String string2 = jSONObject2.getString("data");
            if (TextUtils.equals(string, ACTION_IMPORT)) {
                openFMActivityToImport(jSContext.getActivity(), string2);
            } else if (TextUtils.equals(string, ACTION_START_EXPORT)) {
                handleStartExportedFile(jSContext.getActivity(), string2);
            } else if (TextUtils.equals(string, ACTION_OPEN_EXPORT)) {
                handleDownloadExportedFile(jSContext.getActivity(), string2);
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parse param failed", e16);
        }
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
    }
}
