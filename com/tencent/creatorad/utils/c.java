package com.tencent.creatorad.utils;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.creatorad.pb.CreatorReader$GetShareADRsp;
import com.tencent.creatorad.pb.CreatorReader$ShareAD;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Foreground;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static Activity a() {
        if (Foreground.getTopActivity() != null) {
            return Foreground.getTopActivity();
        }
        return QBaseActivity.sTopActivity;
    }

    public static String b(GdtAd gdtAd) {
        String advertiser_corporate_image_name = gdtAd.getAdvertiser_corporate_image_name();
        String description = gdtAd.getDescription();
        String text = gdtAd.getText();
        if (!TextUtils.isEmpty(description)) {
            return description;
        }
        if (!TextUtils.isEmpty(text)) {
            return text;
        }
        if (!TextUtils.isEmpty(advertiser_corporate_image_name)) {
            return advertiser_corporate_image_name;
        }
        return "";
    }

    public static String c() {
        return GdtDeviceInfoHelper.getClientMode();
    }

    public static qq_ad_get.QQAdGet.DeviceInfo d() {
        GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(BaseApplication.getContext(), new GdtDeviceInfoHelper.Params());
        if (create != null) {
            return create.deviceInfo;
        }
        return null;
    }

    public static boolean e(CreatorReader$GetShareADRsp creatorReader$GetShareADRsp) {
        if (creatorReader$GetShareADRsp != null && creatorReader$GetShareADRsp.ads.size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean f(CreatorReader$ShareAD creatorReader$ShareAD, int i3) {
        if (creatorReader$ShareAD == null) {
            QLog.e("Utils", 1, "shareAD null");
            return false;
        }
        if (creatorReader$ShareAD.qq_ad_get_rsp.pos_ads_info.size() > 0 && creatorReader$ShareAD.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.size() > i3) {
            return true;
        }
        QLog.e("Utils", 1, "open feed back out of range " + i3);
        return false;
    }

    public static boolean g(CreatorReader$ShareAD creatorReader$ShareAD) {
        if (creatorReader$ShareAD == null) {
            QLog.e("Utils", 1, "shareAD null");
            return false;
        }
        if (creatorReader$ShareAD.qq_ad_get_rsp.pos_ads_info.size() > 0 && creatorReader$ShareAD.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.size() > 0) {
            return true;
        }
        return false;
    }
}
