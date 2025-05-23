package com.qzone.util;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.PhotoInfo;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aj {
    public static String c(PhotoInfo photoInfo) {
        return a(photoInfo);
    }

    public static String a(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return "";
        }
        if (!TextUtils.isEmpty(photoInfo.downloadUrl)) {
            QLog.i("QzonePhotoUtil", 1, "photo info id " + photoInfo.lloc + " go download url");
            return photoInfo.downloadUrl;
        }
        if (!TextUtils.isEmpty(photoInfo.orgUrl)) {
            QLog.i("QzonePhotoUtil", 1, "photo info id " + photoInfo.lloc + " go org url");
            return photoInfo.orgUrl;
        }
        if (!TextUtils.isEmpty(photoInfo.bigUrl)) {
            QLog.i("QzonePhotoUtil", 1, "photo info id " + photoInfo.lloc + " go big url");
            return photoInfo.bigUrl;
        }
        return photoInfo.currentUrl;
    }

    public static String b(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return "";
        }
        if (!TextUtils.isEmpty(photoInfo.orgUrl)) {
            QLog.i("QzonePhotoUtil", 1, "photo info id " + photoInfo.lloc + " go org url");
            return photoInfo.orgUrl;
        }
        if (!TextUtils.isEmpty(photoInfo.downloadUrl)) {
            QLog.i("QzonePhotoUtil", 1, "photo info id " + photoInfo.lloc + " go download url");
            return photoInfo.downloadUrl;
        }
        if (!TextUtils.isEmpty(photoInfo.bigUrl)) {
            QLog.i("QzonePhotoUtil", 1, "photo info id " + photoInfo.lloc + " go big url");
            return photoInfo.bigUrl;
        }
        return photoInfo.currentUrl;
    }

    public static String d(PhotoInfo photoInfo, int i3) {
        if (photoInfo == null) {
            return "";
        }
        return String.format(Locale.ENGLISH, "position=%d, currentUrl=%s, bigUrl=%s, orgUrl=%s, downloadUrl=%s", Integer.valueOf(i3), photoInfo.currentUrl, photoInfo.bigUrl, photoInfo.orgUrl, photoInfo.downloadUrl);
    }
}
