package com.qzone.module.covercomponent.manage;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.module.covercomponent.ui.CoverQzoneShowWebView;
import com.qzone.module.covercomponent.utils.CoverHelper;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.adapter.CoverJumpAction;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneCoverContainerManager {

    /* renamed from: a, reason: collision with root package name */
    private static CoverQzoneShowWebView.WebviewCoverListener f48644a;

    /* renamed from: b, reason: collision with root package name */
    private static CoverQzoneShowWebView.WebviewCoverListener f48645b;

    /* renamed from: c, reason: collision with root package name */
    private static CoverQzoneShowWebView.WebviewCoverClickListener f48646c;

    /* renamed from: d, reason: collision with root package name */
    private static CoverQzoneShowWebView.WebviewCoverListener f48647d;

    public static String addParameter(String str, String str2, String str3) {
        StringBuilder sb5;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf(63);
        int indexOf2 = str.indexOf(35);
        String str4 = (indexOf != -1 ? Typography.amp : '?') + encodeUrl(str2) + '=' + encodeUrl(str3);
        if (indexOf2 == -1) {
            sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(str4);
        } else {
            sb5 = new StringBuilder();
            sb5.append(str.substring(0, indexOf2));
            sb5.append(str4);
            sb5.append(str.substring(indexOf2));
        }
        return sb5.toString();
    }

    public static String encodeUrl(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            throw new IllegalArgumentException(e16);
        }
    }

    public static Map<String, String> getArguments(String str) {
        HashMap hashMap = new HashMap();
        try {
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split != null && split.length == 2) {
                    hashMap.put(split[0], URLDecoder.decode(split[1]));
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public static CoverQzoneShowWebView.WebviewCoverListener getDynamicAlbumCoverListener() {
        if (f48644a == null) {
            f48644a = new CoverQzoneShowWebView.WebviewCoverListener() { // from class: com.qzone.module.covercomponent.manage.QZoneCoverContainerManager.1
                @Override // com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.WebviewCoverListener
                public void onDowngradeImageClick(Context context, long j3, int i3) {
                    if (context == null || j3 == 0) {
                        return;
                    }
                    long loginUin = CoverEnv.getLoginUin();
                    String config = CoverEnv.getConfig("H5Url", QzoneCoverConst.SECONDARY_COVER_DYNAMIC_ALBUM_SETTING_URL, CoverHelper.JUMP_COVER_MALL_URL_DEFAULT);
                    String coverJumpUrlFromJce = CoverEnv.getCoverJumpUrlFromJce(j3);
                    if (!TextUtils.isEmpty(coverJumpUrlFromJce)) {
                        config = coverJumpUrlFromJce;
                    }
                    CoverJumpAction.handleScheme(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceWithQua(QZoneCoverContainerManager.replaceWithUin(config, loginUin)), "{from}", "dynamicCover"), "{page}", String.valueOf(i3)), "{hostUin}", String.valueOf(j3)), context, null);
                }
            };
        }
        return f48644a;
    }

    public static CoverQzoneShowWebView.WebviewCoverListener getQzoneShowListener() {
        if (f48647d == null) {
            f48647d = new CoverQzoneShowWebView.WebviewCoverListener() { // from class: com.qzone.module.covercomponent.manage.QZoneCoverContainerManager.4
                @Override // com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.WebviewCoverListener
                public void onDowngradeImageClick(Context context, long j3, int i3) {
                    String config;
                    if (context == null || j3 == 0) {
                        return;
                    }
                    long loginUin = CoverEnv.getLoginUin();
                    if (loginUin > 0 && loginUin == j3) {
                        config = CoverEnv.getConfig("H5Url", QzoneCoverConst.SECONDARY_COVER_QZONE_SHOW_SETTING_URL, CoverHelper.JUMP_COVER_MALL_URL_DEFAULT);
                    } else {
                        config = CoverEnv.getConfig("H5Url", QzoneCoverConst.SECONDARY_COVER_QZONE_SHOW_GUEST_PAGE_URL, CoverHelper.JUMP_COVER_MALL_URL_DEFAULT);
                    }
                    String coverJumpUrlFromJce = CoverEnv.getCoverJumpUrlFromJce(j3);
                    if (!TextUtils.isEmpty(coverJumpUrlFromJce)) {
                        config = coverJumpUrlFromJce;
                    }
                    CoverJumpAction.handleScheme(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceUrlParam(QZoneCoverContainerManager.replaceWithUin(config, j3), "{screenWidth}", String.valueOf(CoverEnv.getScreenWidth())), "{from}", "qzshowcover"), "{page}", String.valueOf(i3)), "{hostUin}", String.valueOf(j3)), context, null);
                }
            };
        }
        return f48647d;
    }

    public static CoverQzoneShowWebView.WebviewCoverClickListener getWebviewCoverClickListener() {
        if (f48646c == null) {
            f48646c = new CoverQzoneShowWebView.WebviewCoverClickListener() { // from class: com.qzone.module.covercomponent.manage.QZoneCoverContainerManager.3
                @Override // com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.WebviewCoverClickListener
                public void onClick(Context context, long j3, int i3) {
                    QZoneCoverContainerManager.b(context, j3, i3);
                }
            };
        }
        return f48646c;
    }

    public static CoverQzoneShowWebView.WebviewCoverListener getWebviewCoverListener() {
        if (f48645b == null) {
            f48645b = new CoverQzoneShowWebView.WebviewCoverListener() { // from class: com.qzone.module.covercomponent.manage.QZoneCoverContainerManager.2
                @Override // com.qzone.module.covercomponent.ui.CoverQzoneShowWebView.WebviewCoverListener
                public void onDowngradeImageClick(Context context, long j3, int i3) {
                    QZoneCoverContainerManager.b(context, j3, i3);
                }
            };
        }
        return f48645b;
    }

    public static String replaceUrlParam(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        return str.replace(str2, str3);
    }

    public static String replaceWithQua(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("{qua}", CoverEnv.getQUA()).replace("{QUA}", CoverEnv.getQUA());
    }

    public static String replaceWithUin(String str, long j3) {
        if (str == null) {
            return null;
        }
        return str.replace("{uin}", String.valueOf(j3)).replace("{UIN}", String.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, long j3, int i3) {
        if (context == null || j3 == 0) {
            return;
        }
        long loginUin = CoverEnv.getLoginUin();
        String config = CoverEnv.getConfig("H5Url", QzoneCoverConst.SECONDARY_WEBVIEW_COERR, CoverHelper.JUMP_COVER_MALL_URL_DEFAULT);
        String coverJumpUrlFromJce = CoverEnv.getCoverJumpUrlFromJce(j3);
        if (!TextUtils.isEmpty(coverJumpUrlFromJce)) {
            config = coverJumpUrlFromJce;
        }
        CoverJumpAction.handleScheme(replaceUrlParam(replaceUrlParam(replaceUrlParam(replaceWithQua(replaceWithUin(config, loginUin)), "{from}", "webviewCover"), "{page}", String.valueOf(i3)), "{hostUin}", String.valueOf(j3)), context, null);
    }
}
