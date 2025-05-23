package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.RequestServer;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class BookShelfJsPlugin extends BaseJsPlugin {
    private static final String TAG = "BookShelfJsPlugin";

    private String getAppId() {
        if (this.mMiniAppContext.getMiniAppInfo() != null) {
            return this.mMiniAppContext.getMiniAppInfo().appId;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jumpToBookShelfApp() {
        String config;
        try {
            config = WnsConfig.getConfig("qqminiapp", "bookshelf_mini_scheme", "mqqapi://miniapp/open?_atype=0&_mappid=1110651677&_mvid=&_path=pages%2Findex%2Findex&_vt=3&via=2016_61&_sig=3788661843");
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleUpdateBookshelf exception: ", th5);
        }
        if (!TextUtils.isEmpty(config)) {
            ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).openSchema(this.mMiniAppContext.getContext(), config, 1037, null);
            return true;
        }
        MiniToast.makeText(this.mMiniAppContext.getAttachActivity(), "\u4e66\u67b6\u6682\u672a\u53d1\u5e03\uff0c\u656c\u8bf7\u671f\u5f85", 0).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInsertSuccDialog() {
        String str;
        MiniCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.mMiniAppContext.getAttachActivity(), 230, "\u5df2\u6210\u529f\u540c\u6b65\u81f3\"\u6211\u7684\u4e66\u67b6\"", "\u53ef\u5728QQ\u5c0f\u7a0b\u5e8f\u4e0b\u62c9-\u6e38\u620f\u4e2d\u5fc3-\u5c0f\u7a0b\u5e8f\u4e2d\u67e5\u770b", "\u7a0d\u5019\u518d\u8bf4", "\u524d\u5f80\u4e66\u67b6", new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.plugins.BookShelfJsPlugin.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                String str2;
                MiniAppInfo miniAppInfo = ((BaseJsPlugin) BookShelfJsPlugin.this).mMiniAppContext.getMiniAppInfo();
                if (miniAppInfo != null) {
                    str2 = "" + miniAppInfo.getReportType();
                } else {
                    str2 = "0";
                }
                SDKMiniProgramLpReportDC04239.reportForSDK(miniAppInfo, str2, null, "bookshelf_enter", "toast_enter", "click", "");
                BookShelfJsPlugin.this.jumpToBookShelfApp();
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.plugins.BookShelfJsPlugin.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
            }
        });
        createCustomDialog.setTitleMutiLine();
        createCustomDialog.getTitleTextView().setGravity(1);
        createCustomDialog.getMessageTextView().setGravity(1);
        createCustomDialog.getMessageTextView().setTextColor(-7894119);
        createCustomDialog.getBtnight().setTextColor(-12541697);
        createCustomDialog.getBtnLeft().setTypeface(Typeface.defaultFromStyle(1));
        Drawable gifDrawable = ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getGifDrawable(WnsConfig.getConfig("qqminiapp", "bookshelf_guide_url", "https://down.qq.com/miniapp/image/bookshelf_iSpt_2.png"));
        if (gifDrawable != null) {
            createCustomDialog.getDialogImage().setVisibility(0);
            createCustomDialog.getDialogImage().setImageDrawable(gifDrawable);
        } else {
            createCustomDialog.getDialogImage().setVisibility(8);
        }
        createCustomDialog.setCanceledOnTouchOutside(false);
        createCustomDialog.show();
        MiniAppInfo miniAppInfo = this.mMiniAppContext.getMiniAppInfo();
        if (miniAppInfo != null) {
            str = "" + miniAppInfo.getReportType();
        } else {
            str = "0";
        }
        SDKMiniProgramLpReportDC04239.reportForSDK(miniAppInfo, str, null, "bookshelf_enter", "toast_enter", "expo", "");
    }

    @JsEvent({PluginConst.DataJsPluginConst.API_BOOKSHELF_INSERT})
    public String handleInsertBookshelf(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String appId = getAppId();
            String optString = jSONObject.optString("category");
            ArrayList<String> arrayList = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    arrayList.add((String) optJSONArray.get(i3));
                }
            }
            RequestServer.getInstance().insertBookShelf(appId, optString, arrayList, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.BookShelfJsPlugin.1
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                    try {
                        if (z16) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.putOpt("list", new JSONArray(jSONObject2.optString("key_result_data")));
                            requestEvent.ok(jSONObject3);
                            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.BookShelfJsPlugin.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    BookShelfJsPlugin.this.showInsertSuccDialog();
                                }
                            });
                        } else {
                            QMLog.e(BookShelfJsPlugin.TAG, "handleInsertBookshelf fail, retCode: " + jSONObject2.optLong("retCode") + "; errMsg : " + jSONObject2.optString("errMsg"));
                            requestEvent.fail(jSONObject2, null);
                        }
                    } catch (Throwable th5) {
                        QMLog.e(BookShelfJsPlugin.TAG, "handleInsertBookshelf exception: ", th5);
                        ApiUtil.wrapCallbackFail(requestEvent.event, null);
                    }
                }
            });
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleInsertBookshelf exception: ", th5);
            return ApiUtil.wrapCallbackFail(requestEvent.event, null).toString();
        }
    }

    @JsEvent({"navigateToBookshelf"})
    public String handleNavigateToBookshelf(RequestEvent requestEvent) {
        String str;
        try {
            MiniAppInfo miniAppInfo = this.mMiniAppContext.getMiniAppInfo();
            if (miniAppInfo != null) {
                str = "" + miniAppInfo.getReportType();
            } else {
                str = "0";
            }
            SDKMiniProgramLpReportDC04239.reportForSDK(miniAppInfo, str, null, "bookshelf_enter", "cp_enter", "click", "");
            if (jumpToBookShelfApp()) {
                return requestEvent.ok();
            }
            return requestEvent.fail();
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleUpdateBookshelf exception: ", th5);
            return requestEvent.fail();
        }
    }

    @JsEvent({"queryBookshelf"})
    public String handleQueryBookshelf(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String appId = getAppId();
            ArrayList<String> arrayList = new ArrayList<>();
            JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    arrayList.add((String) optJSONArray.get(i3));
                }
            }
            RequestServer.getInstance().queryBookShelf(appId, arrayList, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.BookShelfJsPlugin.4
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                    try {
                        if (z16) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.putOpt("list", new JSONArray(jSONObject2.optString("key_result_data")));
                            requestEvent.ok(jSONObject3);
                        } else {
                            QMLog.e(BookShelfJsPlugin.TAG, "handleQueryBookshelf fail, retCode: " + jSONObject2.optLong("retCode") + "; errMsg : " + jSONObject2.optString("errMsg"));
                            requestEvent.fail(jSONObject2, null);
                        }
                    } catch (Throwable th5) {
                        QMLog.e(BookShelfJsPlugin.TAG, "handleQueryBookshelf exception: ", th5);
                        ApiUtil.wrapCallbackFail(requestEvent.event, null);
                    }
                }
            });
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleQueryBookshelf exception: ", th5);
            return ApiUtil.wrapCallbackFail(requestEvent.event, null).toString();
        }
    }

    @JsEvent({"updateBookshelfReadTime"})
    public String handleUpdateBookshelf(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String appId = getAppId();
            String optString = jSONObject.optString("category");
            String optString2 = jSONObject.optString("contentId");
            RequestServer.getInstance().updateBookshelfReadtime(appId, optString, optString2, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.BookShelfJsPlugin.5
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                    try {
                        if (z16) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.putOpt("data", jSONObject2.optString("key_result_data"));
                            requestEvent.ok(jSONObject3);
                        } else {
                            QMLog.e(BookShelfJsPlugin.TAG, "handleQueryBookshelf fail, retCode: " + jSONObject2.optLong("retCode") + "; errMsg : " + jSONObject2.optString("errMsg"));
                            requestEvent.fail(jSONObject2, null);
                        }
                    } catch (Throwable th5) {
                        QMLog.e(BookShelfJsPlugin.TAG, "handleUpdateBookshelf exception: ", th5);
                        ApiUtil.wrapCallbackFail(requestEvent.event, null);
                    }
                }
            });
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, "handleUpdateBookshelf exception: ", th5);
            return ApiUtil.wrapCallbackFail(requestEvent.event, null).toString();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
    }
}
