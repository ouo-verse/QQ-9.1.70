package com.tencent.mobileqq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RichMediaBrowserConstants {
    static IPatchRedirector $redirector_ = null;
    public static final String EXTRA_AIO_CURRENT_PANEL_STATE = "extra.AIO_CURRENT_PANEL_STATE";
    public static final String EXTRA_CAN_FORWARD_TO_GROUP_ALBUM = "extra.CAN_FORWARD_TO_GROUP_ALBUM";
    public static final String EXTRA_FORWARD_TO_QZONE_SRC = "extra.EXTRA_FORWARD_TO_QZONE_SRC";
    public static final String EXTRA_FROM_AIO = "extra.FROM_AIO";
    public static final String EXTRA_ISAPOLLO = "extra.IS_APOLLO";
    public static final String EXTRA_IS_FROM_CHAT_FILE_HISTORY = "extra.IS_FROM_CHAT_FILE_HISTORY";
    public static String EXTRA_IS_MIXED_MSG = null;
    public static String EXTRA_IS_REPLY_SRC_MSG_EXIST = null;
    public static final String EXTRA_IS_STARTING_CHAT_FILE_HISTORY = "extra.IS_STARTING_CHAT_FILE_HISTORY";
    public static final String EXTRA_KEEP_ENTRANCE = "extra.EXTRA_KEEP_ENTRANCE";
    public static final String EXTRA_MOBILE_QQ_PROCESS_ID = "extra.MOBILE_QQ_PROCESS_ID";
    public static final String EXTRA_MSG_ID = "extra.MSG_ID";
    public static final String EXTRA_OCR = "extra.OCR";
    public static final String EXTRA_USE_FEED_SHOW_LONG_IMAGE_UI = "extra_use_feed_show_long_image_ui";
    public static final String GROUP_EMO_PREVIEW = "group.emo.big.preview";
    public static final String INTERNAL_EXTRA_CURRENT_IMAGE = "extra.EXTRA_CURRENT_IMAGE";
    public static final String INTERNAL_EXTRA_CURRENT_IMAGE_LIST = "extra.EXTRA_CURRENT_IMAGE_LIST";
    public static final String INTERNAL_EXTRA_ENTRANCE = "extra.EXTRA_ENTRANCE";
    public static final String INTERNAL_EXTRA_FORBID_FETCH_ALL_IMAGE = "extra.EXTRA_FORBID_FETCH_ALL_IMAGE";
    public static final String IS_APP_SHARE_PIC = "IS_APP_SHARE_PIC";
    public static final String KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT = "key_allow_forward_photo_preview_edit";
    public static final String KEY_TYPE_FROM_NEW_IMG_SHARE_ACTION_SHEET = "key_new_img_shareactionsheet";
    public static final String SINGLE_FORWARD_CONTACTS = "Pic_Forward_Contacts";
    public static final String SINGLE_FORWARD_GRPALBUM = "Pic_Forward_Grpalbum";
    public static final String SINGLE_FORWARD_QZONE = "Pic_Forward_Qzone";
    public static final String SINGLE_PIC_SAVE = "Pic_save";
    public static final String TROOP_FILE_ERROR = "TroopFileError";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27221);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            EXTRA_IS_REPLY_SRC_MSG_EXIST = "extra.IS_REPLY_SRC_MSG_EXIST";
            EXTRA_IS_MIXED_MSG = "extra.IS_MIXED_MSG";
        }
    }

    public RichMediaBrowserConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
