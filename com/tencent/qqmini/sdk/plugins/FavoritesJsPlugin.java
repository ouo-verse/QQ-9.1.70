package com.tencent.qqmini.sdk.plugins;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqmini.sdk.action.FavoritesAction;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.FavoritesProxy;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerFavoritesData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.utils.MiniProgramShareUtils;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class FavoritesJsPlugin extends BaseJsPlugin {
    private static final String KEY_BIZ_DATA_LIST = "bitDataList";
    private static final String KEY_ENTRY_PATH = "entryPath";
    private static final String KEY_PIC_PATH = "picPath";
    private static final String KEY_SUMMARY = "summary";
    private static final String KEY_TITLE = "title";
    private static final String TAG = "FavoritesJsPlugin";

    public static void addFavoritesBundle(Bundle bundle, MiniCmdCallback miniCmdCallback) {
        InnerFavoritesData.Builder builder = new InnerFavoritesData.Builder();
        builder.setTitle(bundle.getString("title"));
        builder.setSummary(bundle.getString("summary"));
        builder.setEntryPath(bundle.getString(KEY_ENTRY_PATH));
        builder.setPicPath(bundle.getString(KEY_PIC_PATH));
        builder.setAction(1);
        builder.setBizDataList(bundle.getString(KEY_BIZ_DATA_LIST));
        InnerFavoritesData build = builder.build();
        if (ProxyManager.get(FavoritesProxy.class) != null) {
            ((FavoritesProxy) ProxyManager.get(FavoritesProxy.class)).onJsAddToFavorites(build);
            if (miniCmdCallback != null) {
                try {
                    miniCmdCallback.onCmdResult(true, new Bundle());
                    return;
                } catch (Throwable th5) {
                    QMLog.e(TAG, "addFavoritesBundle", th5);
                    return;
                }
            }
            return;
        }
        if (miniCmdCallback != null) {
            try {
                miniCmdCallback.onCmdResult(false, new Bundle());
            } catch (Throwable th6) {
                QMLog.e(TAG, "addFavoritesBundle", th6);
            }
        }
    }

    private String fixEntryPath(String str, String str2) {
        if (this.mMiniAppContext.isMiniGame()) {
            if (TextUtils.isEmpty(str2)) {
                return "miniGamePath";
            }
            return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.mApkgInfo.getAppConfigInfo().entryPagePath;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
        }
        return str;
    }

    private String fixPicPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return getDefaultPic();
        }
        try {
            if (!str.startsWith("http")) {
                if (this.mMiniAppContext.isMiniGame()) {
                    MiniAppFileManager miniAppFileManager = (MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class);
                    if (miniAppFileManager != null) {
                        return miniAppFileManager.getAbsolutePath(str);
                    }
                    return str;
                }
                ByteArrayInputStream readApkgToStream = this.mApkgInfo.readApkgToStream(str);
                if (readApkgToStream != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = readApkgToStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            String tmpPathByUrl = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(str);
                            new File(tmpPathByUrl).setWritable(true);
                            FileOutputStream fileOutputStream = new FileOutputStream(tmpPathByUrl);
                            fileOutputStream.write(byteArrayOutputStream.toByteArray());
                            fileOutputStream.close();
                            byteArrayOutputStream.close();
                            readApkgToStream.close();
                            return tmpPathByUrl;
                        }
                    }
                } else {
                    return getDefaultPic();
                }
            } else {
                return str;
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "fixPicPath", th5);
            return getDefaultPic();
        }
    }

    private String fixTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            String str2 = this.mMiniAppInfo.name;
            if (str2 == null) {
                return "";
            }
            return str2;
        }
        return str;
    }

    private String getDefaultPic() {
        String str = this.mMiniAppInfo.iconUrl;
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendAddFavoritesToQQ(InnerFavoritesData innerFavoritesData, final RequestEvent requestEvent) {
        Bundle bundle = new Bundle();
        bundle.putString("title", innerFavoritesData.title);
        bundle.putString("summary", innerFavoritesData.summary);
        bundle.putString(KEY_ENTRY_PATH, innerFavoritesData.entryPath);
        bundle.putString(KEY_PIC_PATH, innerFavoritesData.picPath);
        bundle.putString(KEY_BIZ_DATA_LIST, innerFavoritesData.bizDataList);
        AppBrandCmdProxy.g().sendCmd("cmd_add_qq_favorites", bundle, new MiniCmdCallback.Stub() { // from class: com.tencent.qqmini.sdk.plugins.FavoritesJsPlugin.2
            @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
            public void onCmdResult(boolean z16, Bundle bundle2) throws RemoteException {
                QMLog.d(FavoritesJsPlugin.TAG, "sendAddFavoritesToQQ done succ = " + z16);
                if (z16) {
                    RequestEvent.this.ok();
                    QMLog.d(FavoritesJsPlugin.TAG, "sendAddFavoritesToQQ ok");
                } else {
                    RequestEvent.this.fail();
                    QMLog.d(FavoritesJsPlugin.TAG, "sendAddFavoritesToQQ fail");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorToast(final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.FavoritesJsPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                MiniToast.makeText(((BaseJsPlugin) FavoritesJsPlugin.this).mContext, 1, str, 0).show();
            }
        });
    }

    @JsEvent({"addFavorites"})
    public void addFavorites(RequestEvent requestEvent) {
        ShareState obtain = GetShareState.obtain(this.mMiniAppContext);
        if (obtain != null) {
            obtain.launchFrom = 1;
        }
        this.mMiniAppContext.performAction(FavoritesAction.obtain(1));
    }

    @JsEvent({com.tencent.luggage.wxa.b7.b.NAME})
    public void addToFavorites(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String fixTitle = fixTitle(jSONObject.optString("title", ""));
            addToFavoritesHelp(new InnerFavoritesData.Builder().setTitle(fixTitle).setEntryPath(fixEntryPath(jSONObject.optString("path", ""), jSONObject.optString("query", ""))).setMiniAppInfo(this.mMiniAppInfo).setSummary(this.mMiniAppInfo.desc).setPicPath(fixPicPath(jSONObject.optString("imageUrl", ""))).setBizDataList(null).setAction(1).build(), requestEvent);
        } catch (Throwable th5) {
            QMLog.e(TAG, com.tencent.luggage.wxa.b7.b.NAME, th5);
            showErrorToast("\u6536\u85cf\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
            requestEvent.fail(th5.getMessage());
        }
    }

    public void addToFavoritesHelp(final InnerFavoritesData innerFavoritesData, final RequestEvent requestEvent) {
        MiniAppInfo miniAppInfo = innerFavoritesData.getMiniAppInfo();
        int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        String str = miniAppInfo.appId;
        String str2 = innerFavoritesData.summary;
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getShareInfo(MiniProgramShareUtils.newShareInfoRequest(str, str2, str2, seconds, 1, 1, miniAppInfo.getReportType(), innerFavoritesData.picPath, null, innerFavoritesData.entryPath, miniAppInfo.iconUrl, null, miniAppInfo.verType, miniAppInfo.versionId, 7, false, "", null, "", "", ""), new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.FavoritesJsPlugin.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                try {
                    if (z16 && jSONObject != null) {
                        innerFavoritesData.entryPath = jSONObject.getJSONObject(QQCustomArkDialogUtil.META_DATA).getJSONObject("detail_1").optString("url");
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("appName", jSONObject.optString("appName"));
                        jSONObject2.put(QQCustomArkDialogUtil.APP_VIEW, jSONObject.optString(QQCustomArkDialogUtil.APP_VIEW));
                        jSONObject2.put(QQCustomArkDialogUtil.META_DATA, jSONObject.optJSONObject(QQCustomArkDialogUtil.META_DATA));
                        jSONObject2.put(QQCustomArkDialogUtil.APP_MIN_VERSION, jSONObject.optString("ver"));
                        jSONObject2.put("appConfig", jSONObject.optJSONObject(DownloadInfo.spKey_Config));
                        jSONObject2.put(QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT, jSONObject.optString("prompt"));
                        innerFavoritesData.bizDataList = jSONObject2.toString();
                        FavoritesJsPlugin.sendAddFavoritesToQQ(innerFavoritesData, requestEvent);
                        return;
                    }
                    QMLog.d(FavoritesJsPlugin.TAG, "addFavorites AsyncResult isSuc = " + z16 + " ret = " + jSONObject);
                    if (jSONObject == null) {
                        FavoritesJsPlugin.this.showErrorToast("\u6536\u85cf\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                        requestEvent.fail("request no response");
                    } else {
                        String string = jSONObject.getString("errMsg");
                        FavoritesJsPlugin.this.showErrorToast(string);
                        requestEvent.fail(string);
                    }
                } catch (JSONException e16) {
                    QMLog.e(FavoritesJsPlugin.TAG, "addFavorites AsyncResult", e16);
                    FavoritesJsPlugin.this.showErrorToast("\u6536\u85cf\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                    requestEvent.fail(e16.getMessage());
                }
            }
        });
    }
}
