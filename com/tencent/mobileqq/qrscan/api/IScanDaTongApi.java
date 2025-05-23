package com.tencent.mobileqq.qrscan.api;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IScanDaTongApi extends QRouteApi {
    public static final String ELEM_FLASHLIGHT_BTN = "em_flashlight_button";
    public static final String ELEM_GALLERY_BTN = "em_gallery_button";
    public static final String ELEM_HELP_BTN = "em_help_button";
    public static final String ELEM_MY_QR_BTN = "em_my_qrcode_button";
    public static final String FLASHLIGHT_OFF = "2";
    public static final String FLASHLIGHT_ON = "1";
    public static final String KEY_FLASHLIGHT_SWITCH = "flashlight_button_switch";
    public static final String KEY_PAGE_VERSION = "scan_pg_version";
    public static final String PAGE_ID_AR = "pg_scan_ar";
    public static final String PAGE_ID_OCR = "pg_scan_ocr";
    public static final String PAGE_ID_QR = "pg_scan_qrcode";
    public static final String VERSION_NEW = "1";
    public static final String VERSION_OLD = "2";

    void setFlashlightBtnInfo(View view, String str, boolean z16, boolean z17);

    void setGalleryBtnInfo(View view, String str, boolean z16);

    void setHelpBtnInfo(View view, String str, boolean z16);

    void setMyQrCodeInfo(View view, String str, boolean z16);

    void setPageParams(Activity activity, View view, String str, boolean z16);
}
