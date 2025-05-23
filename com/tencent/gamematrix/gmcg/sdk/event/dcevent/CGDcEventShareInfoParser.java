package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.GmCgEventShareInfoType;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameShareInfo;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGAppUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGImageUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGDcEventShareInfoParser implements GmCgDcEventParser {
    private static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    private static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
    private static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
    private static final int WXSceneTimeline = 1;
    private final ResultListener mResultListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class QQShareData {
        public String app_name;
        public String cflag;
        public String description;
        public String file_data;
        public String file_type;
        public String image_url;
        public String open_id;
        public String req_type;
        public String shareTarget;
        public String shareType;
        public String share_id;
        public String share_to_qq_ark_info;
        public String src_type;
        public String title;
        public String url;
        public String version;

        QQShareData() {
        }

        boolean isValid() {
            if (CGStringUtil.notEmpty(this.title) && CGStringUtil.notEmpty(this.description) && CGStringUtil.notEmpty(this.url)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onGmCgDcEventShareInfo(@GmCgEventShareInfoType int i3, GmCgGameShareInfo gmCgGameShareInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface SaveShareBase64ImageDataToFileListener {
        void onSaveSuccess(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class WeChatShareData {
        public String _message_token;
        public String _mmessage_appPackage;
        public String _mmessage_checksum;
        public String _mmessage_content;
        public String _mmessage_sdkVersion;
        public String _wxapi_basereq_openid;
        public String _wxapi_basereq_transaction;
        public String _wxapi_command_type;
        public String _wxapi_sendmessagetowx_req_media_type;
        public int _wxapi_sendmessagetowx_req_scene;
        public String _wxappextendobject_filePath;
        public String _wximageobject_imageData;
        public String _wximageobject_imagePath;
        public String _wxminiprogram_disableforward;
        public String _wxminiprogram_path;
        public String _wxminiprogram_type;
        public String _wxminiprogram_username;
        public String _wxminiprogram_webpageurl;
        public String _wxminiprogram_withsharetiket;
        public String _wxobject_description;
        public String _wxobject_identifier_;
        public String _wxobject_mediatagname;
        public String _wxobject_message_action;
        public String _wxobject_message_ext;
        public String _wxobject_sdkVer;
        public String _wxobject_thumbdata;
        public String _wxobject_title;
        public String _wxwebpageobject_webpageUrl;
        public String shareType;

        WeChatShareData() {
        }
    }

    public CGDcEventShareInfoParser(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    private void doQQShareDefault(boolean z16, String str, String str2, String str3, String str4, String str5) {
        GmCgGameShareInfo gmCgGameShareInfo = new GmCgGameShareInfo("qq\u7684\u9ed8\u8ba4\u5206\u4eab\u7c7b\u578b");
        gmCgGameShareInfo.setQQShareInfo(new GmCgGameShareInfo.QQShareInfo.Builder().setShareToZone(z16).setShareTitle(str).setShareDescription(str2).setShareImageUrl(str3).setShareJumpUrl(str4).setArkInfo(str5).build());
        onShareResult(0, gmCgGameShareInfo);
    }

    private void doQQShareImage(boolean z16, String str, String str2) {
        GmCgGameShareInfo gmCgGameShareInfo = new GmCgGameShareInfo("qq\u7684\u56fe\u7247\u5206\u4eab\u7c7b\u578b");
        gmCgGameShareInfo.setQQShareInfo(new GmCgGameShareInfo.QQShareInfo.Builder().setShareToZone(z16).setImageTypeShareData(str).setArkInfo(str2).build());
        onShareResult(0, gmCgGameShareInfo);
    }

    private void doWXShareDefault(boolean z16, String str, String str2, String str3, String str4, int i3) {
        GmCgGameShareInfo gmCgGameShareInfo = new GmCgGameShareInfo("\u5fae\u4fe1\u7684\u9ed8\u8ba4\u5206\u4eab\u7c7b\u578b");
        gmCgGameShareInfo.setWXShareInfo(new GmCgGameShareInfo.WXShareInfo.Builder().setShareToWXCircle(z16).setShareTargetUrl(str).setShareTile(str2).setShareDescription(str3).setShareThumbUrl(str4).setShareThumbId(i3).build());
        onShareResult(1, gmCgGameShareInfo);
    }

    private void doWXShareImage(boolean z16, @NonNull String str) {
        GmCgGameShareInfo gmCgGameShareInfo = new GmCgGameShareInfo("\u5fae\u4fe1\u7684\u56fe\u7247\u5206\u4eab\u7c7b\u578b");
        gmCgGameShareInfo.setWXShareInfo(new GmCgGameShareInfo.WXShareInfo.Builder().setShareToWXCircle(z16).setShareImageData(str).build());
        onShareResult(1, gmCgGameShareInfo);
    }

    private void doWxMiniProgramShare(String str, String str2, String str3, String str4, String str5) {
        GmCgGameShareInfo gmCgGameShareInfo = new GmCgGameShareInfo("\u5fae\u4fe1\u7684\u5c0f\u7a0b\u5e8f\u5206\u4eab\u7c7b\u578b");
        gmCgGameShareInfo.setWxMiniProgramInfo(new GmCgGameShareInfo.WxMiniProgramInfo.Builder().setAppUserName(str).setMiniProgramPath(str2).setAppPackage(str3).setShareTitle(str4).setShareDescription(str5).build());
        onShareResult(2, gmCgGameShareInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareToQQ$0(boolean z16, QQShareData qQShareData, String str) {
        doQQShareImage(z16, str, qQShareData.share_to_qq_ark_info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareToQQ$1(boolean z16, QQShareData qQShareData, String str) {
        doQQShareDefault(z16, qQShareData.title, qQShareData.description, str, qQShareData.url, qQShareData.share_to_qq_ark_info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shareToWeChat$2(boolean z16, String str, String str2) {
        doWXShareImage(z16, str);
    }

    private void onShareResult(@GmCgEventShareInfoType int i3, GmCgGameShareInfo gmCgGameShareInfo) {
        ResultListener resultListener = this.mResultListener;
        if (resultListener != null) {
            resultListener.onGmCgDcEventShareInfo(i3, gmCgGameShareInfo);
        }
    }

    private void saveShareBase64ImageDataToFile(String str, String str2, SaveShareBase64ImageDataToFileListener saveShareBase64ImageDataToFileListener) {
        CGImageUtil.loadBase64ImageSaveToPath(str, str2);
        if (saveShareBase64ImageDataToFileListener != null) {
            saveShareBase64ImageDataToFileListener.onSaveSuccess(str2);
        }
    }

    private void shareToQQ(String str) {
        try {
            final QQShareData qQShareData = (QQShareData) new Gson().fromJson(str, QQShareData.class);
            final boolean contains = qQShareData.shareTarget.contains("qzone");
            String str2 = "";
            if (CGStringUtil.notEmpty(qQShareData.url)) {
                try {
                    qQShareData.url = URLDecoder.decode(qQShareData.url, "utf-8");
                } catch (UnsupportedEncodingException | IllegalArgumentException e16) {
                    e16.printStackTrace();
                }
            }
            if (CGStringUtil.notEmpty(qQShareData.image_url)) {
                if (qQShareData.image_url.startsWith("http")) {
                    try {
                        qQShareData.image_url = URLDecoder.decode(qQShareData.image_url, "utf-8");
                    } catch (UnsupportedEncodingException e17) {
                        e17.printStackTrace();
                    }
                }
                if (CGStringUtil.isEmpty("")) {
                    str2 = qQShareData.image_url;
                }
            }
            if (CGStringUtil.notEmpty(qQShareData.file_data)) {
                if (qQShareData.file_data.startsWith("http")) {
                    try {
                        qQShareData.file_data = URLDecoder.decode(qQShareData.file_data, "utf-8");
                    } catch (UnsupportedEncodingException e18) {
                        e18.printStackTrace();
                    }
                }
                if (CGStringUtil.isEmpty(str2)) {
                    str2 = qQShareData.file_data;
                }
            }
            String str3 = str2;
            int parseInt = Integer.parseInt(qQShareData.req_type);
            if (parseInt != 1) {
                if (parseInt != 3 && parseInt != 5) {
                    onShareResult(3, new GmCgGameShareInfo("\u6682\u4e0d\u652f\u6301\u8be5qq\u5206\u4eab\u65b9\u5f0f"));
                    return;
                }
                if (CGStringUtil.notEmpty(str3) && !str3.startsWith("http")) {
                    if (str3.startsWith("http")) {
                        doQQShareImage(contains, str3, qQShareData.share_to_qq_ark_info);
                        return;
                    }
                    saveShareBase64ImageDataToFile(str3, CGAppUtil.getTempAppImageSaveDir() + File.separator + "share_qq_" + System.currentTimeMillis() + ".png", new SaveShareBase64ImageDataToFileListener() { // from class: com.tencent.gamematrix.gmcg.sdk.event.dcevent.a
                        @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventShareInfoParser.SaveShareBase64ImageDataToFileListener
                        public final void onSaveSuccess(String str4) {
                            CGDcEventShareInfoParser.this.lambda$shareToQQ$0(contains, qQShareData, str4);
                        }
                    });
                    return;
                }
                onShareResult(3, new GmCgGameShareInfo("\u6682\u4e0d\u652f\u6301\u8be5qq\u5206\u4eab\u65b9\u5f0f"));
                return;
            }
            if (CGStringUtil.notEmpty(str3) && !str3.startsWith("http")) {
                if (str3.startsWith("http")) {
                    doQQShareDefault(contains, qQShareData.title, qQShareData.description, str3, qQShareData.url, qQShareData.share_to_qq_ark_info);
                    return;
                }
                saveShareBase64ImageDataToFile(str3, CGAppUtil.getTempAppImageSaveDir() + File.separator + "share_qq_" + System.currentTimeMillis() + ".png", new SaveShareBase64ImageDataToFileListener() { // from class: com.tencent.gamematrix.gmcg.sdk.event.dcevent.b
                    @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventShareInfoParser.SaveShareBase64ImageDataToFileListener
                    public final void onSaveSuccess(String str4) {
                        CGDcEventShareInfoParser.this.lambda$shareToQQ$1(contains, qQShareData, str4);
                    }
                });
                return;
            }
            doQQShareDefault(contains, qQShareData.title, qQShareData.description, null, qQShareData.url, qQShareData.share_to_qq_ark_info);
        } catch (JsonSyntaxException unused) {
            onShareResult(5, new GmCgGameShareInfo("\u4e91\u6e38\u620fqq\u5206\u4eab\u5931\u8d25"));
            CGLog.e("shareToQQ:share data error: " + str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3 A[Catch: JsonSyntaxException -> 0x00f1, TryCatch #0 {JsonSyntaxException -> 0x00f1, blocks: (B:2:0x0000, B:5:0x0014, B:8:0x0020, B:9:0x003a, B:11:0x0042, B:13:0x005d, B:15:0x0065, B:17:0x006d, B:20:0x007d, B:22:0x0083, B:24:0x008c, B:26:0x0094, B:27:0x0099, B:29:0x00a1, B:30:0x00a6, B:34:0x00ad, B:36:0x00b3, B:38:0x00e4, B:40:0x0046, B:42:0x004e, B:43:0x0051, B:45:0x0059, B:47:0x0023, B:49:0x002b, B:50:0x002e, B:52:0x0036), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e4 A[Catch: JsonSyntaxException -> 0x00f1, TRY_LEAVE, TryCatch #0 {JsonSyntaxException -> 0x00f1, blocks: (B:2:0x0000, B:5:0x0014, B:8:0x0020, B:9:0x003a, B:11:0x0042, B:13:0x005d, B:15:0x0065, B:17:0x006d, B:20:0x007d, B:22:0x0083, B:24:0x008c, B:26:0x0094, B:27:0x0099, B:29:0x00a1, B:30:0x00a6, B:34:0x00ad, B:36:0x00b3, B:38:0x00e4, B:40:0x0046, B:42:0x004e, B:43:0x0051, B:45:0x0059, B:47:0x0023, B:49:0x002b, B:50:0x002e, B:52:0x0036), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void shareToWeChat(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        try {
            WeChatShareData weChatShareData = (WeChatShareData) new Gson().fromJson(str, WeChatShareData.class);
            boolean z16 = true;
            if (1 != weChatShareData._wxapi_sendmessagetowx_req_scene) {
                z16 = false;
            }
            final boolean z17 = z16;
            if (CGStringUtil.notEmpty(weChatShareData._wximageobject_imageData)) {
                str2 = weChatShareData._wximageobject_imageData;
            } else if (CGStringUtil.notEmpty(weChatShareData._wximageobject_imagePath)) {
                str2 = weChatShareData._wximageobject_imagePath;
            } else if (!CGStringUtil.notEmpty(weChatShareData._wxobject_thumbdata)) {
                str2 = "";
            } else {
                str2 = weChatShareData._wxobject_thumbdata;
            }
            if (CGStringUtil.notEmpty(weChatShareData._wxwebpageobject_webpageUrl)) {
                str4 = weChatShareData._wxwebpageobject_webpageUrl;
            } else if (CGStringUtil.notEmpty(weChatShareData._wxminiprogram_webpageurl)) {
                str4 = weChatShareData._wxminiprogram_webpageurl;
            } else {
                if (!CGStringUtil.notEmpty(weChatShareData._wxappextendobject_filePath)) {
                    str3 = "";
                    if (!CGStringUtil.notEmpty(weChatShareData._wxminiprogram_username) && CGStringUtil.notEmpty(weChatShareData._wxminiprogram_path)) {
                        doWxMiniProgramShare(weChatShareData._wxminiprogram_username, weChatShareData._wxminiprogram_path, weChatShareData._mmessage_appPackage, weChatShareData._wxobject_title, weChatShareData._wxobject_description);
                        return;
                    }
                    if (!CGStringUtil.notEmpty(str3) && str3.startsWith("http")) {
                        if (!CGStringUtil.notEmpty(weChatShareData._wxobject_title)) {
                            str5 = "";
                        } else {
                            str5 = weChatShareData._wxobject_title;
                        }
                        if (!CGStringUtil.notEmpty(weChatShareData._wxobject_description)) {
                            str6 = "";
                        } else {
                            str6 = weChatShareData._wxobject_description;
                        }
                        doWXShareDefault(z17, str3, str5, str6, null, -1);
                        return;
                    }
                    if (!CGStringUtil.notEmpty(str2)) {
                        final String str7 = CGAppUtil.getTempAppImageSaveDir() + File.separator + "share_wx_" + System.currentTimeMillis() + ".png";
                        saveShareBase64ImageDataToFile(str2, str7, new SaveShareBase64ImageDataToFileListener() { // from class: com.tencent.gamematrix.gmcg.sdk.event.dcevent.c
                            @Override // com.tencent.gamematrix.gmcg.sdk.event.dcevent.CGDcEventShareInfoParser.SaveShareBase64ImageDataToFileListener
                            public final void onSaveSuccess(String str8) {
                                CGDcEventShareInfoParser.this.lambda$shareToWeChat$2(z17, str7, str8);
                            }
                        });
                        return;
                    }
                    onShareResult(4, new GmCgGameShareInfo("\u6682\u65f6\u4e0d\u652f\u6301\u8be5\u5fae\u4fe1\u5206\u4eab\u7c7b\u578b"));
                    return;
                }
                str4 = weChatShareData._wxappextendobject_filePath;
            }
            str3 = str4;
            if (!CGStringUtil.notEmpty(weChatShareData._wxminiprogram_username)) {
            }
            if (!CGStringUtil.notEmpty(str3)) {
            }
            if (!CGStringUtil.notEmpty(str2)) {
            }
        } catch (JsonSyntaxException unused) {
            onShareResult(5, new GmCgGameShareInfo("\u4e91\u6e38\u620f\u5fae\u4fe1\u5206\u4eab\u5931\u8d25"));
            CGLog.e("shareToWeChat:share data error: " + str);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public void parseDcEventDataFromReceive(String str) {
        CGLog.i("CGDcEventShareInfoParser start parseDcEventDataFromReceive: " + str);
        JSONObject jsonObjectFromJsonObject = CGJsonUtil.getJsonObjectFromJsonObject(CGJsonUtil.getJsonObjectFromString(str), "shareEventFromGame");
        if (jsonObjectFromJsonObject != null) {
            String stringFromJsonObject = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject, "shareType", "");
            stringFromJsonObject.hashCode();
            if (!stringFromJsonObject.equals("wechat")) {
                if (!stringFromJsonObject.equals("qq")) {
                    onShareResult(5, new GmCgGameShareInfo("\u4e91\u6e38\u620f\u672a\u77e5\u5206\u4eab\u7c7b\u578b"));
                    CGLog.e("shareEventFromGame:unknown shareType: " + stringFromJsonObject);
                    return;
                }
                shareToQQ(jsonObjectFromJsonObject.toString());
                return;
            }
            shareToWeChat(jsonObjectFromJsonObject.toString());
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_SHARE_EVENT_FROM_GAME;
    }
}
