package com.tencent.mobileqq.qqpermission.business;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.util.QPLog;
import com.tencent.mobileqq.widget.az;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes17.dex */
public class QQPermissionBusinessManager {
    static IPatchRedirector $redirector_ = null;
    private static Map<String, BusinessData> BUSINESS_ID_SCENE_PERMISSIONS = null;
    private static String BUSINESS_NAME_PATTERN = null;
    private static final String TAG = "QQPermissionBusinessManager";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class BusinessData {
        static IPatchRedirector $redirector_;
        int nameResId;
        String[] needPermissions;

        public BusinessData(int i3, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) strArr);
            } else {
                this.nameResId = i3;
                this.needPermissions = strArr;
            }
        }
    }

    /* loaded from: classes17.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f274299a;

        /* renamed from: b, reason: collision with root package name */
        public String f274300b;

        /* renamed from: c, reason: collision with root package name */
        public String f274301c;

        /* renamed from: d, reason: collision with root package name */
        public String[] f274302d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f274303e;

        public a(String str, String[] strArr, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, strArr, str2);
                return;
            }
            this.f274299a = str;
            this.f274300b = QQPermissionConstants.BUSINESS_MODULE_MAP.get(str);
            this.f274302d = strArr;
            this.f274301c = str2;
            this.f274303e = true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31993);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        BUSINESS_NAME_PATTERN = null;
        ArrayMap arrayMap = new ArrayMap();
        BUSINESS_ID_SCENE_PERMISSIONS = arrayMap;
        arrayMap.put(QQPermissionConstants.Business.ID.TEST, new BusinessData(R.string.f201594v8, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", QQPermissionConstants.Permission.READ_CONTACTS, QQPermissionConstants.Permission.WRITE_CONTACTS, QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.RECORD_AUDIO, QQPermissionConstants.Permission.READ_SMS, QQPermissionConstants.Permission.PERMISSION_NOTIFICATION, QQPermissionConstants.Permission.ACTIVITY_RECOGNITION}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_PLUGIN, new BusinessData(R.string.f202644y2, new String[]{QQPermissionConstants.Permission.SEND_SMS, QQPermissionConstants.Permission.WRITE_CALENDAR, QQPermissionConstants.Permission.CALL_PHONE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", QQPermissionConstants.Permission.READ_CONTACTS, QQPermissionConstants.Permission.WRITE_CONTACTS, QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.RECORD_AUDIO, QQPermissionConstants.Permission.READ_SMS, QQPermissionConstants.Permission.PERMISSION_NOTIFICATION, QQPermissionConstants.Permission.GET_ACCOUNTS}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_WEATHER, new BusinessData(R.string.f202224wx, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", QQPermissionConstants.Permission.WRITE_CALENDAR}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_ASSISTANT, new BusinessData(R.string.f201724vk, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_HEALTH, new BusinessData(R.string.f202164wr, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.ACTIVITY_RECOGNITION}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_QWALLET, new BusinessData(R.string.f202214ww, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.RECORD_AUDIO, QQPermissionConstants.Permission.READ_CONTACTS, "android.permission.ACCESS_COARSE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_KANDIAN, new BusinessData(R.string.f201884w0, new String[]{"android.permission.ACCESS_FINE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_TROOP, new BusinessData(R.string.f202184wt, new String[]{QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_TROOP_APP, new BusinessData(R.string.f202194wu, new String[]{QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_TROOP_COMMON_COMPONENT, new BusinessData(R.string.f202204wv, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.KANDIAN_PUBLISHER, new BusinessData(R.string.f201894w1, new String[]{"android.permission.ACCESS_FINE_LOCATION", QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.CAMERA}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_QCIRCLE, new BusinessData(R.string.f202044wf, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_CONTACTS, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_CHANNEL_FEED, new BusinessData(R.string.f201774vp, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_LIVE, new BusinessData(R.string.f201904w2, new String[]{"android.permission.ACCESS_COARSE_LOCATION", QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_QAV, new BusinessData(R.string.f202034we, new String[]{QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.RECORD_AUDIO, QQPermissionConstants.Permission.BLUETOOTH_CONNECT, QQPermissionConstants.Permission.BLUETOOTH_SCAN, QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_ONLINE_STATUS_SMART_STATUS_ID, new BusinessData(R.string.f201974w9, new String[]{"android.permission.ACCESS_FINE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_ONLINE_STATUS_WEATHER_ID, new BusinessData(R.string.f201984w_, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QLINK, new BusinessData(R.string.f201654vd, new String[]{"android.permission.ACCESS_FINE_LOCATION", QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.BLUETOOTH_SCAN, QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE, QQPermissionConstants.Permission.BLUETOOTH_CONNECT}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.TBS_TOOL, new BusinessData(R.string.f202484xm, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.DATALINE, new BusinessData(R.string.f201584v7, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.CAMERA}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_FILE, new BusinessData(R.string.f201874vz, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_VOICE_ASSISTANT, new BusinessData(R.string.f202294x4, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, new BusinessData(R.string.f201814vt, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, "android.permission.ACCESS_FINE_LOCATION", QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_NEARBY, new BusinessData(R.string.f201954w7, new String[]{"android.permission.ACCESS_COARSE_LOCATION", QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.RECORD_AUDIO, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, "android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_STRANGER, new BusinessData(R.string.f201934w5, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, "android.permission.ACCESS_COARSE_LOCATION", QQPermissionConstants.Permission.BLUETOOTH_SCAN, QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE, QQPermissionConstants.Permission.BLUETOOTH_CONNECT}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_PHONECONTACT, new BusinessData(R.string.f202004wb, new String[]{QQPermissionConstants.Permission.READ_CONTACTS, QQPermissionConstants.Permission.WRITE_CONTACTS, QQPermissionConstants.Permission.GET_ACCOUNTS}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_QR_DISPLAY, new BusinessData(R.string.f202054wg, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_PC_LOGIN, new BusinessData(R.string.f202644y2, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_NEW_GUIDE, new BusinessData(R.string.f201964w8, new String[]{QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.READ_CONTACTS}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_FRIEND_PROFILE_IMAGE, new BusinessData(R.string.f202114wm, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_INVITATION_WEBVIEW, new BusinessData(R.string.f202644y2, new String[]{QQPermissionConstants.Permission.SEND_SMS}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_ADD_CONTACT_TROOP, new BusinessData(R.string.f202644y2, new String[]{"android.permission.ACCESS_FINE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, new BusinessData(R.string.f202014wc, new String[]{QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.WRITE_CONTACTS, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, "android.permission.ACCESS_COARSE_LOCATION", QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_CONDITION_SEARCH, new BusinessData(R.string.f201824vu, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_BUSINESS_BIG_SEARCH, new BusinessData(R.string.f202304x5, new String[]{"android.permission.ACCESS_COARSE_LOCATION", QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_CHANNEL_AUDIO, new BusinessData(R.string.f201754vn, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO, QQPermissionConstants.Permission.BLUETOOTH_CONNECT}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_CHANNEL_WORLD, new BusinessData(R.string.f202244wz, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_CHANNEL_LIVE, new BusinessData(R.string.f201794vr, new String[]{QQPermissionConstants.Permission.CAMERA}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_CHANNEL_MAINFRAME, new BusinessData(R.string.f201804vs, new String[]{"android.permission.ACCESS_FINE_LOCATION", QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_CHANNEL_CONTENT_SHARE, new BusinessData(R.string.f201764vo, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_ID, new BusinessData(R.string.f202174ws, new String[]{QQPermissionConstants.Permission.CAMERA, "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", QQPermissionConstants.Permission.PERMISSION_NOTIFICATION}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_AIO_ALBUM, new BusinessData(R.string.f201674vf, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.SOGOU_EMOJI, new BusinessData(R.string.f202154wq, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_AIO_CAMERA, new BusinessData(R.string.f201684vg, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.CAMERA}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_SCREENSHOT, new BusinessData(R.string.f202134wo, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_ALBUM, new BusinessData(R.string.f201674vf, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_MINIAPP_SAVE, new BusinessData(R.string.f201944w6, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_QZONE, new BusinessData(R.string.f202064wh, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", QQPermissionConstants.Permission.RECORD_AUDIO, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.ACCESS_MEDIA_LOCATION}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_MINIAPP_MYSITE, new BusinessData(R.string.f201944w6, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_AVGAME, new BusinessData(R.string.f201744vm, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO, QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_AV, new BusinessData(R.string.f201734vl, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO, QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.BLUETOOTH_SCAN, QQPermissionConstants.Permission.BLUETOOTH_CONNECT, QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_OLYMPIC_TORCH, new BusinessData(R.string.f201694vh, new String[]{QQPermissionConstants.Permission.CAMERA}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.GY_FLASH_SHOW_UNIT, new BusinessData(R.string.f201614v_, new String[]{QQPermissionConstants.Permission.CAMERA, "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_CAMERA, new BusinessData(R.string.f201684vg, new String[]{QQPermissionConstants.Permission.CAMERA, "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_LOCATION, new BusinessData(R.string.f201914w3, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_MAP, new BusinessData(R.string.f201924w4, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_SHARE, new BusinessData(R.string.f202144wp, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_PUBLIC_MINI_PERMISSION_CAMERA, new BusinessData(R.string.f201944w6, new String[]{QQPermissionConstants.Permission.CAMERA}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_PUBLIC_MINI_PERMISSION_READ_EXTERNAL_STORAGE, new BusinessData(R.string.f201944w6, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_PUBLIC_MINI_PERMISSION_RECORD_AUDIO, new BusinessData(R.string.f201944w6, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_OPENSDK_AUTH, new BusinessData(R.string.f201994wa, new String[]{QQPermissionConstants.Permission.CAMERA}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.FACE_IDENTIFICATION, new BusinessData(R.string.f201604v9, new String[]{QQPermissionConstants.Permission.CAMERA}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_PUBLIC_ACCOUNT, new BusinessData(R.string.f202024wd, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", QQPermissionConstants.Permission.WRITE_CONTACTS, QQPermissionConstants.Permission.CALL_PHONE, QQPermissionConstants.Permission.SEND_SMS}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_REMINDER, new BusinessData(R.string.f202074wi, new String[]{QQPermissionConstants.Permission.WRITE_CALENDAR}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_ARK, new BusinessData(R.string.f201714vj, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_EMOTICON, new BusinessData(R.string.f201844vw, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.TENCENT_DOCS_CAMERA, new BusinessData(R.string.f202284x3, new String[]{QQPermissionConstants.Permission.CAMERA}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.TENCENT_DOCS_VOICE, new BusinessData(R.string.f202284x3, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_ZPLAN, new BusinessData(R.string.f202254x0, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.ZPLAN_PET_SHARE, new BusinessData(R.string.f202274x2, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_ZPLAN_LIGHTAI, new BusinessData(R.string.f202264x1, new String[]{QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA, new BusinessData(R.string.f202034we, new String[]{QQPermissionConstants.Permission.BLUETOOTH_SCAN, QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE, QQPermissionConstants.Permission.BLUETOOTH_CONNECT}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_RECORD_AUDIO, new BusinessData(R.string.f202094wk, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_EDIT_VIDEO, new BusinessData(R.string.f202084wj, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_EDIT_PHOTO, new BusinessData(R.string.f202084wj, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_SCAN_AR, new BusinessData(R.string.f201704vi, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_CONTACT_LOCATION, new BusinessData(R.string.f201834vv, new String[]{"android.permission.ACCESS_FINE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_FACE_2_FACE_ADD_CONTACT_LOCATION, new BusinessData(R.string.f201854vx, new String[]{"android.permission.ACCESS_FINE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_CONTACT_STORAGE, new BusinessData(R.string.f201834vv, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_AIO_STORAGE, new BusinessData(R.string.f201664ve, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_PROFILE_CARD_CONTACT, new BusinessData(R.string.f202014wc, new String[]{QQPermissionConstants.Permission.WRITE_CONTACTS}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_LABEL_SHARE_STORAGE, new BusinessData(R.string.f202014wc, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_SIGN_TEXT_EDIT_LOCATION, new BusinessData(R.string.f202014wc, new String[]{"android.permission.ACCESS_FINE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_SCAN_OCR, new BusinessData(R.string.f202124wn, new String[]{QQPermissionConstants.Permission.CAMERA}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, new BusinessData(R.string.f202104wl, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_WEBVIEW, new BusinessData(R.string.f202234wy, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.RECORD_AUDIO, "android.permission.ACCESS_FINE_LOCATION"}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.ZPLAN_SHARE, new BusinessData(R.string.f202254x0, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.ZPLAN_GAME, new BusinessData(R.string.f202254x0, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.ZPLAN_DETAIL, new BusinessData(R.string.f202254x0, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_FAV, new BusinessData(R.string.f201864vy, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, "android.permission.ACCESS_FINE_LOCATION", QQPermissionConstants.Permission.RECORD_AUDIO, QQPermissionConstants.Permission.CAMERA, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_CHANNEL_KARAOKE, new BusinessData(R.string.f201784vq, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_STRANGER_PARTY_ROOM, new BusinessData(R.string.z7_, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_GAME_CENTER_CALENDAR, new BusinessData(R.string.f201634vb, new String[]{QQPermissionConstants.Permission.WRITE_CALENDAR}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_GAME_CENTER_VOICE, new BusinessData(R.string.f201634vb, new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_BUSINESS_GAME_CENTER, new BusinessData(R.string.f201634vb, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}));
        BUSINESS_ID_SCENE_PERMISSIONS.put(QQPermissionConstants.Business.ID.QQ_BUSINESS_FLOCK, new BusinessData(R.string.f201624va, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, "android.permission.ACCESS_FINE_LOCATION"}));
    }

    public QQPermissionBusinessManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean check(BusinessConfig businessConfig, String[] strArr) {
        boolean z16;
        if (!BUSINESS_ID_SCENE_PERMISSIONS.containsKey(businessConfig.getBusinessId())) {
            QPLog.e(TAG, "check: business id not exist!");
            return false;
        }
        String[] strArr2 = BUSINESS_ID_SCENE_PERMISSIONS.get(businessConfig.getBusinessId()).needPermissions;
        for (String str : strArr) {
            int length = strArr2.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (strArr2[i3].equals(str)) {
                        z16 = true;
                        break;
                    }
                    i3++;
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                QPLog.e(TAG, "check: permission not register!");
                return false;
            }
        }
        return true;
    }

    public static List<a> findBusinessIdList(String str, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : BUSINESS_ID_SCENE_PERMISSIONS.keySet()) {
            String[] strArr = BUSINESS_ID_SCENE_PERMISSIONS.get(str2).needPermissions;
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (list.contains(strArr[i3])) {
                    arrayList.add(new a(str2, strArr, str));
                    break;
                }
                i3++;
            }
        }
        return arrayList;
    }

    public static String getBusinessName(Context context, String str) {
        int i3;
        if (!BUSINESS_ID_SCENE_PERMISSIONS.containsKey(str) || (i3 = BUSINESS_ID_SCENE_PERMISSIONS.get(str).nameResId) <= 0) {
            return "";
        }
        if (BUSINESS_NAME_PATTERN == null) {
            BUSINESS_NAME_PATTERN = context.getString(R.string.f201644vc);
        }
        return String.format(BUSINESS_NAME_PATTERN, az.g(i3));
    }

    public static String[] getBusinessPermissionList(String str) {
        if (!BUSINESS_ID_SCENE_PERMISSIONS.containsKey(str)) {
            return null;
        }
        return BUSINESS_ID_SCENE_PERMISSIONS.get(str).needPermissions;
    }
}
