package com.tencent.mobileqq.app;

import android.os.Environment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface AppOpenConstants {
    public static final IPatchRedirector $redirector_ = null;
    public static final String APP_NAME = "mobileQQ";
    public static final String HTTP_TYPE_QZONE_DOWNLOAD_EMO = "qzEmod";
    public static final String QCIRCLE_CHAT_UIN;
    public static final long QCIRCLE_CHAT_UIN_LONGVALUE = 9913;
    public static final String SDCARD_DCIM;
    public static final String SDCARD_IMG_CAMERA;
    public static final String SDCARD_IMG_SAVE;
    public static final String SDCARD_ROOT;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface EmoticonPanelType {
        public static final int MSG_FORWARD = 100003;
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface Key {
        public static final String FORWARD_ARK_APP_META = "forward_ark_app_meta";
        public static final String FORWARD_ARK_APP_NAME = "forward_ark_app_name";
        public static final String FORWARD_ARK_APP_PROMPT = "forward_ark_app_prompt";
        public static final String FORWARD_ARK_APP_VER = "forward_ark_app_ver";
        public static final String FORWARD_ARK_APP_VIEW = "forward_ark_app_view";
        public static final String FORWARD_ARK_BIZ_SRC = "forward_ark_biz_src";
        public static final String FORWARD_DISPLAY_ARK = "is_ark_display_share";
        public static final String FORWARD_TYPE = "forward_type";
        public static final String SHARE_REQ_DESC = "desc";
        public static final String SHARE_REQ_DETAIL_URL = "detail_url";
        public static final String SHARE_REQ_ID = "req_share_id";
        public static final String SHARE_REQ_IMAGE_URL = "image_url";
        public static final String SHARE_REQ_SHARE_QZONE_INFO = "share_qzone_info";
        public static final String SHARE_REQ_TITLE = "title";
        public static final String THIRD_PUSH_CLICK_TIME = "third_push_click_time";
        public static final String THIRD_PUSH_MSG_SEQ = "third_push_msg_seq";
        public static final String THIRD_PUSH_START_ACTIVITY_TIME = "third_push_start_activity_time";
        public static final String TROOP_INFO_FROM_TROOPSETTING = "troop_info_from_troopsetting";
        public static final String UIN = "uin";
        public static final String UIN_NAME = "uinname";
        public static final String UIN_TYPE = "uintype";
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface VALUE {
        public static final int UIN_TYPE_CONTACT_STRANGER_FRIEND = 1006;
        public static final int UIN_TYPE_FRIEND = 0;
        public static final int UIN_TYPE_INIT = -1;
        public static final int UIN_TYPE_TEMP_CIRCLE = 10008;
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(42038), (Class<?>) AppOpenConstants.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        SDCARD_ROOT = absolutePath;
        SDCARD_IMG_CAMERA = absolutePath + "/DCIM/Camera/";
        SDCARD_IMG_SAVE = absolutePath + "/Tencent/QQ_Images/";
        SDCARD_DCIM = absolutePath + "/DCIM/";
        QCIRCLE_CHAT_UIN = String.valueOf(QCIRCLE_CHAT_UIN_LONGVALUE);
    }
}
