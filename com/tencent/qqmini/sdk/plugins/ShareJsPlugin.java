package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.gg.g;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.WnsUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class ShareJsPlugin extends BaseJsPlugin {
    private static final int ACTION_SHEET_DEFAULT_TYPE = 0;
    private static final int ACTION_SHEET_SHARE_PANEL_TYPE = 1;
    public static final String API_OPEN_QZONE_PUBLISH = "openQzonePublish";
    public static final int ERRCODE_INVITE_CANCEL = 1;
    public static final int ERRCODE_INVITE_REQUIRE = 2;
    public static final String ERRMSG_INVITE_CANCEL = "\u7528\u6237\u53d6\u6d88";
    public static final String ERRMSG_INVITE_REQUIRE = "\u5206\u4eab\u5931\u8d25";
    public static final int NEED_HIDE = 0;
    public static final int NEED_SHOW = 1;
    public static final String SHARE_ITEM_GUILD = "guild";
    public static final String SHARE_ITEM_QQ = "qq";
    public static final String SHARE_ITEM_QZONE = "qzone";
    public static final String SHARE_ITEM_WECHAT_FRIEND = "wechatFriends";
    public static final String SHARE_ITEM_WECHAT_MOMENT = "wechatMoment";
    public static final int SHARE_MENU_STATE_NEED_HIDE = 0;
    public static final int SHARE_MENU_STATE_NEED_SHOW = 1;
    public static final int SHARE_MENU_STATE_UNDEFINED = -1;
    private static final String TAG = "ShareJsPlugin";
    public static final int UNDEFINED = -1;
    private ShareProxy mShareProxy = (ShareProxy) ProxyManager.get(ShareProxy.class);

    /* loaded from: classes23.dex */
    class a implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348247a;

        a(RequestEvent requestEvent) {
            this.f348247a = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            if (z16) {
                this.f348247a.ok();
                return;
            }
            String str = ShareJsPlugin.ERRMSG_INVITE_REQUIRE;
            if (jSONObject != null) {
                str = jSONObject.optString("errMsg", ShareJsPlugin.ERRMSG_INVITE_REQUIRE);
            }
            this.f348247a.fail(str);
        }
    }

    private void doShareAppPictureMessage(String str, boolean z16, String str2, boolean z17, InnerShareData.Builder builder, ShareChatModel shareChatModel) {
        if (z16) {
            builder.setSharePicPath(str).setShareChatModel(shareChatModel).build().shareAppPictureMessage(this.mMiniAppContext);
            return;
        }
        if (!StringUtil.isEmpty(str) && (z16 || z17)) {
            if (!z16 && z17) {
                builder.setSharePicPath(str2).setShareChatModel(shareChatModel).setIsLocalPic(true).build().shareAppPictureMessage(this.mMiniAppContext);
                return;
            }
            return;
        }
        handleShareAppWithDefaultPic(builder, shareChatModel);
    }

    private String fixPath(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.mMiniAppContext.isMiniGame()) {
                return "miniGamePath";
            }
            return this.mApkgInfo.getAppConfigInfo().entryPagePath;
        }
        return str;
    }

    private GetScreenshot.Callback getScreenShotCallback(final InnerShareData.Builder builder) {
        return new GetScreenshot.Callback() { // from class: com.tencent.qqmini.sdk.plugins.ShareJsPlugin.1
            @Override // com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback
            public void onGetScreenshot(String str) {
                if (TextUtils.isEmpty(str)) {
                    builder.setSharePicPath(((BaseJsPlugin) ShareJsPlugin.this).mApkgInfo.iconUrl).build().shareAppMessage();
                    QMLog.e(ShareJsPlugin.TAG, "getScreenshot failed, savedScreenshotPath = null");
                } else {
                    builder.setSharePicPath(str).setIsLocalPic(true).build().shareAppMessage();
                }
            }
        };
    }

    private ShareChatModel getShareChatModel(int i3, JSONObject jSONObject, ShareState shareState) {
        if (i3 == 5) {
            String optString = jSONObject.optString("chatDataHash");
            ShareChatModel shareChatModel = shareState.shareChatModel;
            if (shareChatModel == null || !shareChatModel.getEntryHash().equals(optString)) {
                QMLog.e(TAG, "shareAppMessageDirectly fail, entryDataHash is no match:" + optString);
            } else {
                return shareChatModel;
            }
        }
        return null;
    }

    private EntryModel getShareQQDirectlyModel(int i3, JSONObject jSONObject, ShareState shareState) {
        EntryModel entryModel;
        if (i3 == 2) {
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            String optString = jSONObject.optString("entryDataHash");
            if (optString != null && (entryModel = miniAppInfo.launchParam.entryModel) != null && optString.equals(entryModel.getEntryHash())) {
                return miniAppInfo.launchParam.entryModel;
            }
            QMLog.e(TAG, "shareAppMessageDirectly fail, entryDataHash is no match:" + optString);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getShareType(int i3, String str) {
        switch (i3) {
            case 0:
            case 2:
            case 5:
                return 0;
            case 1:
                return 1;
            case 3:
                return 3;
            case 4:
                return 4;
            case 6:
                return "shareAppMessageDirectlyToFriendList".equals(str) ? 0 : -1;
            default:
                if (MoreItem.isValidExtendedItemId(i3)) {
                    return 6;
                }
                break;
        }
    }

    private void handleShareAppWithDefaultPic(final InnerShareData.Builder builder, final ShareChatModel shareChatModel) {
        if (this.mMiniAppContext.isMiniGame()) {
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo != null) {
                builder.setSharePicPath(miniAppInfo.iconUrl).setShareChatModel(shareChatModel).build().shareAppPictureMessage(this.mMiniAppContext);
                return;
            } else {
                QMLog.e(TAG, "startShareNetworkPicMessage with iconUrl failed, mini app info is null");
                return;
            }
        }
        ShareState obtain = GetShareState.obtain(this.mMiniAppContext);
        if (obtain != null) {
            if (obtain.isGettingScreenShot) {
                QMLog.e(TAG, "sharePicMessage getScreenshot isGettingScreenShot now, return directly !");
            } else {
                GetScreenshot.obtain(this.mMiniAppContext, new GetScreenshot.Callback() { // from class: com.tencent.qqmini.sdk.plugins.ShareJsPlugin.3
                    @Override // com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback
                    public void onGetScreenshot(String str) {
                        if (TextUtils.isEmpty(str)) {
                            QMLog.e(ShareJsPlugin.TAG, "getScreenshot failed, savedScreenshotPath = null");
                            if (((BaseJsPlugin) ShareJsPlugin.this).mMiniAppInfo != null) {
                                builder.setSharePicPath(((BaseJsPlugin) ShareJsPlugin.this).mMiniAppInfo.iconUrl).setShareChatModel(shareChatModel).setIsLocalPic(false).build().shareAppPictureMessage(((BaseJsPlugin) ShareJsPlugin.this).mMiniAppContext);
                                return;
                            } else {
                                QMLog.e(ShareJsPlugin.TAG, "getScreenshot failed, apkgInfo is null");
                                return;
                            }
                        }
                        builder.setSharePicPath(str).setShareChatModel(shareChatModel).setIsLocalPic(true).build().shareAppPictureMessage(((BaseJsPlugin) ShareJsPlugin.this).mMiniAppContext);
                    }
                });
            }
        }
    }

    private int handleShareDirectly(RequestEvent requestEvent, int i3, int i16, ShareState shareState) {
        if (com.tencent.luggage.wxa.c3.e.NAME.equals(requestEvent.event) || "shareAppMessageDirectlyToFriendList".equals(requestEvent.event)) {
            if (i16 == -1) {
                int defaultShareTarget = this.mShareProxy.getDefaultShareTarget();
                if (MoreItem.isValidExtendedItemId(defaultShareTarget)) {
                    i16 = 6;
                    i3 = defaultShareTarget;
                } else {
                    i16 = 0;
                    i3 = 0;
                }
            }
            shareState.fromShareMenuBtn = i16;
        }
        return i3;
    }

    private JSONObject handleStagingShareJsonParams(JSONObject jSONObject, ShareState shareState) throws JSONException {
        if (!TextUtils.isEmpty(shareState.stagingJsonParams)) {
            JSONObject jSONObject2 = new JSONObject(shareState.stagingJsonParams);
            shareState.stagingJsonParams = null;
            return jSONObject2;
        }
        return jSONObject;
    }

    private boolean isLocalResourceExists(String str, String str2) {
        if (!TextUtils.isEmpty(str) && new File(str2).exists()) {
            return true;
        }
        return false;
    }

    private boolean isNetworkImageUrl(String str) {
        if (!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) {
            return false;
        }
        return true;
    }

    private boolean isParamEmpty(RequestEvent requestEvent) {
        String str = requestEvent.jsonParams;
        if (str != null && !"null".equals(str) && !"{}".equals(requestEvent.jsonParams)) {
            return false;
        }
        return true;
    }

    private void shareToQQ(String str, InnerShareData.Builder builder) {
        MiniAppFileManager miniAppFileManager = (MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class);
        boolean isNetworkImageUrl = isNetworkImageUrl(str);
        boolean isLocalResourceExists = isLocalResourceExists(str, miniAppFileManager.getAbsolutePath(str));
        if (!StringUtil.isEmpty(str) && (isNetworkImageUrl || isLocalResourceExists)) {
            if (!str.startsWith("http") && !str.startsWith("https")) {
                builder.setSharePicPath(miniAppFileManager.getAbsolutePath(str)).setIsLocalPic(true).build().shareAppMessage();
                return;
            } else {
                builder.setSharePicPath(str).build().shareAppMessage();
                return;
            }
        }
        if (this.mMiniAppContext.isMiniGame()) {
            builder.setSharePicPath(WnsUtil.defaultShareImg()).build().shareAppMessage();
            QMLog.e(TAG, "shareAppMessageDirectly fail, [isNetworkImageUrl=" + isNetworkImageUrl + "] [isLocalResourceExists=" + isLocalResourceExists + "] [imageUrl=" + str + "], use default share image");
            return;
        }
        if (GetShareState.obtain(this.mMiniAppContext) != null) {
            if (GetShareState.obtain(this.mMiniAppContext).isGettingScreenShot) {
                QMLog.e(TAG, "getScreenshot isGettingScreenShot now, return directly !");
            } else {
                GetScreenshot.obtain(this.mMiniAppContext, getScreenShotCallback(builder));
            }
        }
    }

    private void shareToQzone(String str, final InnerShareData.Builder builder) {
        if (!str.startsWith("http") && !str.startsWith("https")) {
            String absolutePath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
            if (!StringUtil.isEmpty(absolutePath)) {
                builder.setSharePicPath(absolutePath).setIsLocalPic(true).build().shareAppMessage();
                return;
            } else {
                GetScreenshot.obtain(this.mMiniAppContext, new GetScreenshot.Callback() { // from class: com.tencent.qqmini.sdk.plugins.ShareJsPlugin.2
                    @Override // com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback
                    public void onGetScreenshot(String str2) {
                        if (TextUtils.isEmpty(str2)) {
                            builder.setSharePicPath(((BaseJsPlugin) ShareJsPlugin.this).mMiniAppInfo.iconUrl).build().shareAppMessage();
                            QMLog.e(ShareJsPlugin.TAG, "getScreenshot for QzoneShare failed, savedScreenshotPath = null");
                        } else {
                            builder.setSharePicPath(str2).setIsLocalPic(true).build().shareAppMessage();
                        }
                    }
                });
                return;
            }
        }
        builder.setSharePicPath(str).build().shareAppMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDefaultActionSheet(final ActionSheet actionSheet, JSONObject jSONObject, JSONArray jSONArray, final RequestEvent requestEvent) {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            if (jSONArray.isNull(i3)) {
                requestEvent.fail();
                return;
            }
            actionSheet.addButton(jSONArray.optString(i3), 9, jSONObject.optString("itemColor"));
        }
        actionSheet.addCancelButton("\u53d6\u6d88");
        actionSheet.show();
        actionSheet.setOutsideDismissEnableCompat(true);
        actionSheet.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.qqmini.sdk.plugins.ShareJsPlugin.5
            @Override // com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnDismissListener
            public void onDismiss() {
                requestEvent.fail();
            }
        });
        actionSheet.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.qqmini.sdk.plugins.ShareJsPlugin.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                requestEvent.fail();
            }
        });
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqmini.sdk.plugins.ShareJsPlugin.7
            @Override // com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i16) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("tapIndex", i16);
                    requestEvent.ok(jSONObject2);
                    actionSheet.dismiss();
                } catch (JSONException e16) {
                    QMLog.e(ShareJsPlugin.TAG, requestEvent.event + " error.", e16);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSharePanelActionSheet(RequestEvent requestEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        HashMap<String, Integer> hashMap = new HashMap<>();
        if (isParamEmpty(requestEvent)) {
            try {
                new JSONObject().put("errMsg", "param is null!");
                requestEvent.fail();
            } catch (JSONException e16) {
                QMLog.e(TAG, requestEvent.event + " error.", e16);
            }
            QMLog.e(TAG, requestEvent.event + " return errMsg: param is null!");
            return;
        }
        try {
            JSONArray jSONArray = (JSONArray) new JSONObject(requestEvent.jsonParams).opt(VideoTemplateParser.ITEM_LIST);
            if (jSONArray == null) {
                try {
                    new JSONObject().put("errMsg", "itemList is null!");
                    requestEvent.fail();
                } catch (JSONException e17) {
                    QMLog.e(TAG, requestEvent.event + " error.", e17);
                }
                QMLog.e(TAG, requestEvent.event + " return errMsg: itemList is null!");
                return;
            }
            boolean z19 = false;
            char c16 = '\uffff';
            char c17 = '\uffff';
            char c18 = '\uffff';
            char c19 = '\uffff';
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String string = jSONArray.getString(i3);
                if (string.equalsIgnoreCase("qq")) {
                    hashMap.put(ShareState.KEY_TAP_INDEX_QQ, Integer.valueOf(i3));
                    c16 = 1;
                }
                if (string.equalsIgnoreCase("qzone")) {
                    hashMap.put(ShareState.KEY_TAP_INDEX_QZONE, Integer.valueOf(i3));
                    c17 = 1;
                }
                if (string.equalsIgnoreCase(SHARE_ITEM_WECHAT_FRIEND)) {
                    hashMap.put(ShareState.KEY_TAP_INDEX_WX, Integer.valueOf(i3));
                    c18 = 1;
                }
                if (string.equalsIgnoreCase(SHARE_ITEM_WECHAT_MOMENT)) {
                    hashMap.put(ShareState.KEY_TAP_INDEX_WX_MOMENTS, Integer.valueOf(i3));
                    c19 = 1;
                }
            }
            if (c16 == '\uffff') {
                c16 = 0;
            }
            if (c17 == '\uffff') {
                c17 = 0;
            }
            if (c18 == '\uffff') {
                c18 = 0;
            }
            if (c19 == '\uffff') {
                c19 = 0;
            }
            ShareState obtain = GetShareState.obtain(this.mMiniAppContext);
            if (obtain != null) {
                obtain.launchFrom = 1;
                if (c16 == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                obtain.withShareQQ = z16;
                if (c17 == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                obtain.withShareQzone = z17;
                if (c18 == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                obtain.withShareWeChatFriend = z18;
                if (c19 == 1) {
                    z19 = true;
                }
                obtain.withShareWeChatMoment = z19;
                obtain.withShareOthers = true;
                obtain.tapIndexMap = hashMap;
                obtain.shareEvent = requestEvent.event;
                obtain.shareCallbackId = requestEvent.callbackId;
                obtain.requestEvent = requestEvent;
            }
            this.mShareProxy.showSharePanel(this.mMiniAppContext);
        } catch (JSONException e18) {
            e18.printStackTrace();
            QMLog.e(TAG, e18.getMessage(), e18);
            requestEvent.fail();
        }
    }

    public void handleShareAppMessage(RequestEvent requestEvent, int i3) {
        int i16;
        try {
            boolean equals = com.tencent.luggage.wxa.c3.e.NAME.equals(requestEvent.event);
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            int optInt = jSONObject.optInt("shareTarget", -1);
            int shareType = getShareType(optInt, requestEvent.event);
            ShareState obtain = GetShareState.obtain(this.mMiniAppContext);
            EntryModel shareQQDirectlyModel = getShareQQDirectlyModel(optInt, jSONObject, obtain);
            ShareChatModel shareChatModel = getShareChatModel(optInt, jSONObject, obtain);
            String optString = jSONObject.optString("shareTemplateId");
            String optString2 = jSONObject.optString("shareTemplateData");
            int handleShareDirectly = handleShareDirectly(requestEvent, optInt, shareType, obtain);
            if (obtain != null) {
                obtain.shareEvent = requestEvent.event;
                obtain.shareCallbackId = requestEvent.callbackId;
                obtain.requestEvent = requestEvent;
            }
            String optString3 = jSONObject.optString("shareActionName");
            if (obtain != null && !TextUtils.isEmpty(optString3)) {
                obtain.shareEvent = optString3;
            }
            QMLog.d(TAG, "shareAppMessage param: " + jSONObject.toString());
            if (obtain != null) {
                jSONObject = handleStagingShareJsonParams(jSONObject, obtain);
            }
            String optString4 = jSONObject.optString("path");
            if (TextUtils.isEmpty(optString4)) {
                optString4 = jSONObject.optString("query");
            }
            String optString5 = jSONObject.optString("title");
            String optString6 = jSONObject.optString("imageUrl");
            String optString7 = jSONObject.optString("generalWebpageUrl");
            String fixPath = fixPath(optString4);
            InnerShareData.Builder builder = new InnerShareData.Builder();
            if (equals) {
                i16 = 11;
            } else {
                i16 = 12;
            }
            InnerShareData.Builder shareOrigin = builder.setShareSource(i16).setShareTarget(handleShareDirectly).setTitle(this.mMiniAppInfo.name).setSummary(optString5).setEntryPath(fixPath).setWebUrl(optString7).setTemplateId(optString).setTemplateData(optString2).setEntryModel(shareQQDirectlyModel).setShareChatModel(shareChatModel).setWithShareTicket(obtain.withShareTicket).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachActivity()).setShareInMiniProcess(obtain.isShareInMiniProcess).setShareOrigin(i3);
            int i17 = obtain.fromShareMenuBtn;
            if (i17 == 1) {
                shareToQzone(optString6, shareOrigin);
                return;
            }
            if (i17 != 3 && i17 != 4) {
                shareToQQ(optString6, shareOrigin);
                return;
            }
            shareOrigin.setSharePicPath(this.mMiniAppInfo.iconUrl).build().shareAppMessage();
        } catch (JSONException e16) {
            QMLog.e(TAG, e16.getMessage(), e16);
            e16.printStackTrace();
        }
    }

    public void handleShareAppPictureMessage(RequestEvent requestEvent, int i3) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            int optInt = jSONObject.optInt("shareTarget", -1);
            int shareType = getShareType(optInt);
            ShareState obtain = GetShareState.obtain(this.mMiniAppContext);
            if ("shareAppPictureMessageDirectly".equals(requestEvent.event)) {
                if (shareType == -1) {
                    optInt = this.mShareProxy.getDefaultShareTarget();
                    if (MoreItem.isValidExtendedItemId(optInt)) {
                        shareType = 6;
                    } else {
                        optInt = 0;
                        shareType = 0;
                    }
                }
                if (obtain != null) {
                    obtain.fromShareMenuBtn = shareType;
                }
            }
            if (obtain != null) {
                obtain.shareEvent = requestEvent.event;
                obtain.shareCallbackId = requestEvent.callbackId;
                obtain.requestEvent = requestEvent;
            }
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("imageUrl");
            boolean isNetworkImageUrl = isNetworkImageUrl(optString2);
            MiniAppFileManager miniAppFileManager = (MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class);
            if (miniAppFileManager != null) {
                String absolutePath = miniAppFileManager.getAbsolutePath(optString2);
                boolean isLocalResourceExists = isLocalResourceExists(optString2, absolutePath);
                if (obtain != null) {
                    doShareAppPictureMessage(optString2, isNetworkImageUrl, absolutePath, isLocalResourceExists, new InnerShareData.Builder().setShareSource(11).setShareTarget(optInt).setTitle(this.mMiniAppInfo.name).setSummary(optString).setFromActivity(this.mMiniAppContext.getAttachActivity()).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachActivity()).setShareInMiniProcess(obtain.isShareInMiniProcess).setShareOrigin(i3), getShareChatModel(optInt, jSONObject, obtain));
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @JsEvent({com.tencent.luggage.wxa.gg.a.NAME})
    public void hideShareMenu(RequestEvent requestEvent) {
        try {
            JSONArray jSONArray = (JSONArray) new JSONObject(requestEvent.jsonParams).opt("hideShareItems");
            ShareState obtain = GetShareState.obtain(this.mMiniAppContext);
            if (obtain != null) {
                obtain.withShareOthers = false;
                if (jSONArray == null) {
                    obtain.withShareQQ = false;
                    obtain.withShareQzone = false;
                    obtain.withShareWeChatFriend = false;
                    obtain.withShareWeChatMoment = false;
                    obtain.withShareGuild = false;
                } else {
                    List asList = Arrays.asList(JSONUtil.jsonArrayToStringArray(jSONArray));
                    if (asList.contains("qq")) {
                        obtain.withShareQQ = false;
                    }
                    if (asList.contains("qzone")) {
                        obtain.withShareQzone = false;
                    }
                    if (asList.contains(SHARE_ITEM_WECHAT_FRIEND)) {
                        obtain.withShareWeChatFriend = false;
                    }
                    if (asList.contains(SHARE_ITEM_WECHAT_MOMENT)) {
                        obtain.withShareWeChatMoment = false;
                    }
                    if (asList.contains("guild")) {
                        obtain.withShareGuild = false;
                    }
                }
            }
            requestEvent.ok();
        } catch (JSONException unused) {
        }
    }

    @JsEvent({API_OPEN_QZONE_PUBLISH})
    public void openQzonePublish(RequestEvent requestEvent) {
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (!channelProxy.openQzonePublish(iMiniAppContext, iMiniAppContext.getAttachActivity(), requestEvent.jsonParams, this.mMiniAppInfo)) {
            MiniToast.makeText(this.mMiniAppContext.getAttachActivity(), 0, "\u6682\u4e0d\u652f\u6301\u5728" + QUAUtil.getApplicationName(this.mContext) + "\u4e2d\u53d1\u8868\u8bf4\u8bf4", 1);
        }
    }

    @JsEvent({com.tencent.luggage.wxa.c3.d.NAME, "shareAppMessageDirectlyToFriendList"})
    public void shareAppMessage(RequestEvent requestEvent) {
        handleShareAppMessage(requestEvent, 1);
    }

    @JsEvent({com.tencent.luggage.wxa.c3.e.NAME})
    public void shareAppMessageDirectly(RequestEvent requestEvent) {
        if (!QUAUtil.isQQApp() && !QUAUtil.isMicroApp()) {
            ShareState obtain = GetShareState.obtain(this.mMiniAppContext);
            if (obtain != null) {
                obtain.stagingJsonParams = requestEvent.jsonParams;
            }
            this.mShareProxy.showSharePanel(this.mMiniAppContext);
            return;
        }
        handleShareAppMessage(requestEvent, 2);
    }

    @JsEvent({"shareAppPictureMessage"})
    public void shareAppPictureMessage(RequestEvent requestEvent) {
        handleShareAppPictureMessage(requestEvent, 1);
    }

    @JsEvent({"shareAppPictureMessageDirectly"})
    public void shareAppPictureMessageDirectly(RequestEvent requestEvent) {
        if (!QUAUtil.isQQApp() && !QUAUtil.isMicroApp()) {
            this.mShareProxy.showSharePanel(this.mMiniAppContext);
        } else {
            handleShareAppPictureMessage(requestEvent, 2);
        }
    }

    @JsEvent({"shareGamePicture"})
    public void shareGamePicture(RequestEvent requestEvent) {
        int i3;
        String str;
        ShareProxy shareProxy = (ShareProxy) ProxyManager.get(ShareProxy.class);
        if (shareProxy == null) {
            requestEvent.fail("\u5f53\u524d\u5e73\u53f0\u4e0d\u652f\u6301\u672c\u63a5\u53e3\u3002");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("path", "");
            String optString2 = jSONObject.optString("type", "");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                if ("qq".equalsIgnoreCase(optString2)) {
                    i3 = 0;
                } else if ("qzone".equalsIgnoreCase(optString2)) {
                    i3 = 1;
                } else if ("wechat".equalsIgnoreCase(optString2)) {
                    i3 = 3;
                } else if ("wxmoment".equalsIgnoreCase(optString2)) {
                    i3 = 4;
                } else {
                    requestEvent.fail("\u6682\u4e0d\u652f\u6301\u5176\u4ed6\u5206\u4eab\u7c7b\u578b\u3002");
                    return;
                }
                File file = new File(optString);
                if (file.exists()) {
                    str = file.getAbsolutePath();
                    QMLog.i(TAG, "shareGamePicture use direct local path.");
                } else {
                    MiniAppFileManager miniAppFileManager = (MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class);
                    if (miniAppFileManager == null) {
                        str = "";
                    } else {
                        String absolutePath = miniAppFileManager.getAbsolutePath(optString);
                        if (!isLocalResourceExists(optString, absolutePath)) {
                            requestEvent.fail("\u5206\u4eab\u56fe\u7247\u4e0d\u5b58\u5728\uff0cpath=" + optString);
                            QMLog.w(TAG, "shareGamePicture not exists, path=" + optString);
                            return;
                        }
                        str = absolutePath;
                    }
                    QMLog.i(TAG, "shareGamePicture use minigame path.");
                }
                if (shareProxy.shareGamePicture(this.mMiniAppContext.getAttachActivity(), new InnerShareData.Builder().setEntryPath(jSONObject.optString("shareData", "")).setSharePicPath(str).setMiniAppInfo(this.mMiniAppInfo).setShareTarget(i3).setShareOrigin(2).build())) {
                    requestEvent.ok();
                    return;
                } else {
                    requestEvent.fail("\u5f53\u524d\u5e73\u53f0\u4e0d\u652f\u6301\u672c\u63a5\u53e3\u3002");
                    return;
                }
            }
            requestEvent.fail("\u53c2\u6570\u4e0d\u5408\u6cd5\uff0cpath=" + optString + ", type=" + optString2);
        } catch (JSONException e16) {
            QMLog.e(TAG, "shareGamePicture: exception, data=" + requestEvent.jsonParams, e16);
        }
    }

    @JsEvent({"shareGameStructMessage"})
    public void shareGameStructMessage(RequestEvent requestEvent) {
        int i3;
        String str;
        ShareProxy shareProxy = (ShareProxy) ProxyManager.get(ShareProxy.class);
        if (shareProxy == null) {
            requestEvent.fail("\u5f53\u524d\u5e73\u53f0\u4e0d\u652f\u6301\u672c\u63a5\u53e3\u3002");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
            String optString3 = jSONObject.optString("preview");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                String optString4 = jSONObject.optString("type", "qq");
                String optString5 = jSONObject.optString("desc");
                if ("qq".equalsIgnoreCase(optString4)) {
                    i3 = 0;
                } else if ("wechat".equalsIgnoreCase(optString4)) {
                    i3 = 3;
                } else if ("wxmoment".equalsIgnoreCase(optString4)) {
                    i3 = 4;
                } else {
                    requestEvent.fail("\u4ec5\u652f\u6301 qq/wechat/wxmoment \u5206\u4eab\u7c7b\u578b\u3002");
                    return;
                }
                String str2 = "";
                File file = new File(optString3);
                if (file.exists()) {
                    str = file.getAbsolutePath();
                    QMLog.i(TAG, "shareGameStructMessage use direct local path.");
                } else {
                    MiniAppFileManager miniAppFileManager = (MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class);
                    if (miniAppFileManager != null) {
                        str2 = miniAppFileManager.getAbsolutePath(optString3);
                        if (!isLocalResourceExists(optString3, str2)) {
                            requestEvent.fail("\u5206\u4eab\u56fe\u7247\u4e0d\u5b58\u5728\uff0cpreview=" + optString3);
                            QMLog.w(TAG, "shareGameStructMessage not exists, preview=" + optString3);
                            return;
                        }
                    }
                    QMLog.i(TAG, "shareGameStructMessage use minigame path.");
                    str = str2;
                }
                shareProxy.shareGameStructMessage(new InnerShareData.Builder().setFromActivity(this.mMiniAppContext.getAttachActivity()).setMiniAppInfo(this.mMiniAppInfo).setShareTarget(i3).setTitle(optString).setSummary(optString5).setSharePicPath(str).setTargetUrl(optString2).setShareOrigin(2).build(), new a(requestEvent));
                return;
            }
            requestEvent.fail("\u53c2\u6570\u4e0d\u5408\u6cd5\uff0ctitle=" + optString + ", jumpUrl=" + optString2 + ", preview=" + optString3);
        } catch (Exception e16) {
            QMLog.e(TAG, "shareGameStructMessage: exception, data=" + requestEvent.jsonParams, e16);
        }
    }

    @JsEvent({"shareInvite"})
    public void shareInvite(RequestEvent requestEvent) {
        ShareState obtain = GetShareState.obtain(this.mMiniAppContext);
        if (obtain != null) {
            obtain.shareEvent = requestEvent.event;
            obtain.shareCallbackId = requestEvent.callbackId;
            obtain.requestEvent = requestEvent;
        }
        new InnerShareData.Builder().setShareSource(11).setShareTarget(7).setTemplateId("657667B4D8C04B3F84E4AAA3D046A903").setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachActivity()).setEvent(requestEvent.event).setSubScene(InnerShareData.SUB_SCENE_ARK_INVITE_API).setCallbackId(requestEvent.callbackId).build().shareAppMessage();
    }

    @JsEvent({"showActionSheet"})
    public void showActionSheet(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.ShareJsPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Activity attachActivity = ((BaseJsPlugin) ShareJsPlugin.this).mMiniAppContext.getAttachActivity();
                    if (attachActivity == null) {
                        QMLog.e(ShareJsPlugin.TAG, "activity null error.");
                        requestEvent.fail();
                        return;
                    }
                    ActionSheet create = ActionSheet.create(attachActivity);
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    JSONArray optJSONArray = jSONObject.optJSONArray(VideoTemplateParser.ITEM_LIST);
                    int optInt = jSONObject.optInt("actionSheetType", 0);
                    if (optInt == 0) {
                        ShareJsPlugin.this.showDefaultActionSheet(create, jSONObject, optJSONArray, requestEvent);
                        return;
                    }
                    if (optInt == 1) {
                        ShareJsPlugin.this.showSharePanelActionSheet(requestEvent);
                        return;
                    }
                    QMLog.e(ShareJsPlugin.TAG, requestEvent.event + " actionSheetType undefined: " + optInt);
                } catch (JSONException e16) {
                    QMLog.e(ShareJsPlugin.TAG, requestEvent.event + " error.", e16);
                }
            }
        });
    }

    @JsEvent({com.tencent.luggage.wxa.gg.c.NAME, com.tencent.luggage.wxa.gg.d.NAME})
    public void showShareMenu(RequestEvent requestEvent) {
        List emptyList;
        JSONObject jSONObject;
        ShareState obtain = GetShareState.obtain(this.mMiniAppContext);
        if (obtain != null) {
            obtain.withShareOthers = true;
            obtain.withShareTicket = false;
            obtain.withShareQQ = true;
            obtain.withShareQzone = true;
            obtain.withShareWeChatFriend = true;
            obtain.withShareWeChatMoment = true;
            obtain.withShareGuild = true;
        }
        if (!isParamEmpty(requestEvent)) {
            try {
                jSONObject = new JSONObject(requestEvent.jsonParams);
                if (obtain != null) {
                    obtain.withShareTicket = jSONObject.optBoolean("withShareTicket", false);
                }
            } catch (JSONException e16) {
                requestEvent.fail();
                QMLog.e(TAG, e16.getMessage(), e16);
                emptyList = Collections.emptyList();
            }
            if (!jSONObject.has("showShareItems")) {
                requestEvent.ok();
                return;
            }
            emptyList = Arrays.asList(JSONUtil.jsonArrayToStringArray((JSONArray) jSONObject.opt("showShareItems")));
            if (obtain != null) {
                obtain.withShareQQ = emptyList.contains("qq");
                obtain.withShareQzone = emptyList.contains("qzone");
                obtain.withShareWeChatFriend = emptyList.contains(SHARE_ITEM_WECHAT_FRIEND);
                obtain.withShareWeChatMoment = emptyList.contains(SHARE_ITEM_WECHAT_MOMENT);
                obtain.withShareGuild = emptyList.contains("guild");
            }
        }
        requestEvent.ok();
    }

    @JsEvent({g.NAME})
    public void updateShareMenuShareTicket(RequestEvent requestEvent) {
        try {
            boolean optBoolean = new JSONObject(requestEvent.jsonParams).optBoolean("withShareTicket", false);
            ShareState obtain = GetShareState.obtain(this.mMiniAppContext);
            if (obtain != null) {
                obtain.withShareTicket = optBoolean;
            }
            requestEvent.ok();
        } catch (JSONException e16) {
            QMLog.e(TAG, e16.getMessage(), e16);
            e16.printStackTrace();
        }
    }

    private int getShareType(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                return 1;
            }
            if (i3 != 2) {
                if (i3 == 3) {
                    return 3;
                }
                if (i3 == 4) {
                    return 4;
                }
                if (i3 != 5) {
                    return MoreItem.isValidExtendedItemId(i3) ? 6 : -1;
                }
                return 5;
            }
        }
        return 0;
    }
}
