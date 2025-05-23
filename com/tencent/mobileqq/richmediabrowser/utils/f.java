package com.tencent.mobileqq.richmediabrowser.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {
    public static void b(Context context, String str, int i3, AIOBrowserBaseData aIOBrowserBaseData) {
        a(context, str, i3, d.a(aIOBrowserBaseData));
    }

    public static void c(Context context, String str, int i3, boolean z16, String str2, String str3, String str4, String str5, int i16, String str6, String str7, Intent intent) {
        String str8;
        int i17;
        String str9;
        String str10;
        String str11 = str6;
        Intent intent2 = intent == null ? new Intent() : intent;
        intent2.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        intent2.putExtra("detectType", i16);
        intent2.putExtra("fromPicQRDecode", true);
        boolean z17 = false;
        String str12 = null;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 1000 || i3 == 1004) {
                        str8 = str7;
                        if (!TextUtils.equals(str2, str11)) {
                            str8 = str11;
                        }
                        i17 = 13;
                    } else if (i3 != 3000) {
                        if (i3 != 10014) {
                            if (TextUtils.equals(str2, str11)) {
                                str11 = str7;
                            }
                            str8 = str11;
                            i17 = 0;
                        } else {
                            if (z16) {
                                i17 = 12;
                            } else {
                                i17 = 11;
                                z17 = true;
                            }
                            if ((context instanceof Activity) && ((Activity) context).getIntent() != null) {
                                String stringExtra = ((Activity) context).getIntent().getStringExtra(IGuildForwardUtilsApi.EXTRA_GUILD_ID);
                                if (!TextUtils.isEmpty(stringExtra)) {
                                    intent2.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, stringExtra);
                                    intent2.putExtra("friendUin", str7);
                                }
                            }
                            str8 = null;
                        }
                    }
                }
                if (z16) {
                    i17 = 4;
                } else {
                    i17 = 2;
                    z17 = true;
                }
                str8 = null;
            } else {
                str8 = str7;
                i17 = z16 ? 3 : 1;
                if (!TextUtils.equals(str2, str11)) {
                    str8 = str11;
                }
            }
        } catch (Throwable th5) {
            BrowserLogHelper.getInstance().getGalleryLog().d("GalleryJumpUtils", 4, "onQRDecodeSucceed error:" + th5.getMessage());
        }
        if (!TextUtils.isEmpty(str4)) {
            int picDownloadPort = BaseDownloadProcessor.getPicDownloadPort();
            String str13 = z17 ? IPicTransFile.GROUP_PIC_DOWNLOAD_DOMAIN : IPicTransFile.C2C_PIC_DOWNLOAD_DOMAIN;
            if (!TextUtils.isEmpty(str13)) {
                if (picDownloadPort != 80) {
                    str12 = str13 + ":" + picDownloadPort + str4;
                } else {
                    str12 = str13 + str4;
                }
            }
        } else if (!TextUtils.isEmpty(str5)) {
            if (i17 == 1) {
                String str14 = "c2cpicdw.qpic.cn/offpic_new";
                if (!TextUtils.isEmpty(str2)) {
                    str14 = "c2cpicdw.qpic.cn/offpic_new/" + str2;
                }
                if (str5.startsWith("/")) {
                    str9 = str14 + str5 + "/0";
                } else {
                    str9 = str14 + "/" + str5 + "/0";
                }
            } else if (i17 == 2) {
                String str15 = "gchat.qpic.cn/gchatpic_new";
                if (!TextUtils.isEmpty(str2)) {
                    str15 = "gchat.qpic.cn/gchatpic_new/" + str2;
                }
                if (str5.startsWith("/")) {
                    str9 = str15 + "0-0-" + str5.replace(".jpg", "") + "/0";
                } else {
                    str9 = str15 + "/0-0-" + str5.replace(".jpg", "") + "/0";
                }
            }
            str10 = str9;
            intent2.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(str3, str10, str5, str2, str8, i17));
            RouteUtils.startActivity(context, intent2, "/qrscan/scanner");
        }
        str10 = str12;
        intent2.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(str3, str10, str5, str2, str8, i17));
        RouteUtils.startActivity(context, intent2, "/qrscan/scanner");
    }

    public static void d(Activity activity, Bundle bundle) {
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(activity), null);
        Bundle bundle2 = new Bundle(bundle);
        BrowserLogHelper.getInstance().getGalleryLog().d("GalleryJumpUtils", 4, "AIOGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
        bundle2.putBoolean(PeakConstants.IS_WAIT_DEST_RESULT, true);
        bundle2.putBoolean(PeakConstants.IS_FORWARD, true);
        bundle2.putInt(PeakConstants.SEND_BUSINESS_TYPE, 1031);
        m3.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
        m3.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        m3.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
        m3.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
        m3.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
        bundle2.putBoolean("PicContants.NEED_COMPRESS", false);
        m3.putExtras(bundle2);
        String string = bundle2.getString("GALLERY.FORWORD_LOCAL_PATH");
        ArrayList arrayList = new ArrayList();
        arrayList.add(string);
        PhotoUtils.sendPhoto(activity, m3, arrayList, bundle2.getInt(PeakConstants.SEND_SIZE_SPEC, 0), true);
    }

    public static void a(Context context, String str, int i3, AIORichMediaData aIORichMediaData) {
    }
}
