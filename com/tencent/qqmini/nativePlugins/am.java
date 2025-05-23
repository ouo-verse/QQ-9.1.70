package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.mini.out.nativePlugins.TenDocChannelPlugin;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.smtt.sdk.CookieManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class am extends BaseJsPlugin {
    private JSONObject b(RequestEvent requestEvent) {
        try {
            return new JSONObject(requestEvent.jsonParams);
        } catch (JSONException unused) {
            QLog.e(TenDocChannelPlugin.TAG, 1, "Failed to parse jsonParams=" + requestEvent.jsonParams);
            return null;
        }
    }

    private synchronized void c(Activity activity, String str) {
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
            QLog.e(TenDocChannelPlugin.TAG, 1, "downloadExportedFile exception e = " + e16.toString());
        }
    }

    private synchronized void d(Activity activity, String str) {
        try {
            String optString = new JSONObject(str).optString(WadlProxyConsts.PARAM_FILENAME);
            Bundle bundle = new Bundle();
            bundle.putString(WadlProxyConsts.PARAM_FILENAME, optString);
            QLog.d(TenDocChannelPlugin.TAG, 1, "downloadExportedFile handleStartExportedFile qqmini");
            bundle.putBoolean(ITeamWorkUtils.FILE_BROWSER_PARAMS_KEY_MINI_PROGRAM, true);
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "TeamWorkModule", "action_start_export_file", bundle);
            lr2.a.j(null, "0X800A4B2");
        } catch (Exception e16) {
            QLog.e(TenDocChannelPlugin.TAG, 1, "startExportedFile exception e = " + e16.toString());
        }
    }

    private synchronized void e(Activity activity, String str) {
        try {
            String optString = new JSONObject(str).optString("folderId");
            Intent intent = new Intent();
            intent.setClassName(activity, "com.tencent.mobileqq.filemanager.activity.FMActivity.class");
            intent.putExtra(com.tencent.mobileqq.teamwork.t.f292401f, true);
            intent.addFlags(536870912);
            intent.putExtra("selectMode", true);
            intent.putExtra(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, 9);
            intent.putExtra("peerType", 10006);
            intent.putExtra("enterfrom", 9);
            intent.putExtra("tab_tab_type", 7);
            intent.putExtra("only_show_local_tab", true);
            intent.putExtra(com.tencent.mobileqq.teamwork.t.f292402g, optString);
            intent.putExtra("smart_device_support_flag", 8);
            activity.startActivity(intent);
        } catch (Exception e16) {
            QLog.e(TenDocChannelPlugin.TAG, 1, "openFMActivityToImport exception", e16);
        }
    }

    @JsEvent({TenDocChannelPlugin.PLUGIN_NAME})
    public void tdocChannel(RequestEvent requestEvent) {
        try {
            JSONObject b16 = b(requestEvent);
            if (b16 != null) {
                JSONObject jSONObject = new JSONObject(b16.optString("data"));
                String string = jSONObject.getString("action");
                String string2 = jSONObject.getString("data");
                Activity attachActivity = this.mMiniAppContext.getAttachActivity();
                if (TextUtils.equals(string, "openLocalFilesToImport")) {
                    e(attachActivity, string2);
                } else if (TextUtils.equals(string, "txDocsStartExport")) {
                    d(attachActivity, string2);
                } else if (TextUtils.equals(string, "openExportedFile")) {
                    c(attachActivity, string2);
                }
            }
        } catch (JSONException e16) {
            QLog.e(TenDocChannelPlugin.TAG, 1, "parse param failed", e16);
        }
    }
}
