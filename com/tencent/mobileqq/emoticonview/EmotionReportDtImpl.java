package com.tencent.mobileqq.emoticonview;

import android.view.View;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTReport;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionReportDtImpl implements IDTReport {
    static IPatchRedirector $redirector_ = null;
    public static final String AIO_YELLOW_STICKERS_ID = "aio_yellow_stickers_id";
    public static final String CURRENT_TAB = "current_tab";
    public static final String EM_AIO_ALBUM_STICKERS = "em_aio_album_stickers";
    public static final String EM_AIO_ALBUM_STICKERS_TAB = "em_aio_album_stickers_tab";
    public static final String EM_AIO_FAVORITES_STICKERS = "em_aio_favorites_stickers";
    public static final String EM_AIO_FAVORITES_STICKERS_TAB = "em_aio_favorites_stickers_tab";
    public static final String EM_AIO_SETTING_BELOW_TEXTBOX = "em_aio_setting_below_textbox";
    public static final String EM_AIO_STICKERS_MALL_BELOW_TEXTBOX = "em_aio_stickers_mall_below_textbox";
    public static final String EM_AIO_STICKERS_PANEL = "em_aio_stickers_panel";
    public static final String EM_AIO_TEXTBOX_STICKERS_RECOMMEND_BAR = "em_aio_textbox_stickers_recommend_bar";
    public static final String EM_AIO_YELLOW_STICKERS = "em_aio_yellow_stickers";
    public static final String EM_AIO_YELLOW_STICKERS_TAB = "em_aio_yellow_stickers_tab";
    public static final String EM_LITTLE_YELLOW_FACE_EMOJI = "em_littleyellow_face_emoji";
    public static final String EM_NT_AIO_EMO_PANEL = "em_bas_aio_bottom_emoji_panel";
    public static final String ID_STICKERS_A_SET = "id_stickers_a_set";
    public static final String IS_RED_TIPS_BEFORE = "is_red_tips_before";
    public static final String KEY_TYPE_AIO_STICKERS_TAB_ENTRY = "type_aio_stickers_tab_entry";
    public static final String LOG_TAG = "EmotionReportDtImpl";
    public static final String ORDER_IN_ALBUM_STICKERS = "order_in_album_stickers";
    public static final String ORDER_IN_FAVORITES_STICKERS = "order_in_favorites_stickers";
    public static final String ORDER_IN_YELLOW_STICKERS = "order_in_yellow_stickers";
    public static final String ORDER_TAB_IN_STICKERS_PANEL = "order_tab_in_stickers_panel";
    public static final String PARAM_EXPRESSION_IS_RECENT_USE = "is_recent_use";
    public static final String PARAM_EXPRESSION_PACK_ID = "expression_pack_id";
    public static final String PARAM_EXPRESSION_YELLOW_FACE_TYPE = "yellowface_type";
    public static final String TEXT_IN_TEXTBOX = "text_in_textbox";
    public static final String TYPE_YELLOW_STICKERS = "type_yellow_stickers";

    public EmotionReportDtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void bindSystemAndEmojiFaceView(View view, SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo, int i3, int i16) {
        if (view != null && systemAndEmojiEmoticonInfo != null && i3 >= 0) {
            if (systemAndEmojiEmoticonInfo.emotionType == 3) {
                if (QLog.isColorLevel()) {
                    QLog.i(LOG_TAG, 2, "bindSystemAndEmojiFaceView, ignore type title:" + systemAndEmojiEmoticonInfo.emotionType);
                    return;
                }
                return;
            }
            int[] systemAndEmojiFaceIndexResult = getSystemAndEmojiFaceIndexResult(systemAndEmojiEmoticonInfo, i16);
            int i17 = systemAndEmojiFaceIndexResult[0];
            int i18 = systemAndEmojiFaceIndexResult[1];
            VideoReport.setElementId(view, EM_AIO_YELLOW_STICKERS);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            HashMap hashMap = new HashMap();
            hashMap.put(ORDER_IN_YELLOW_STICKERS, String.valueOf(i3 - i18));
            hashMap.put(TYPE_YELLOW_STICKERS, String.valueOf(i17));
            hashMap.put(AIO_YELLOW_STICKERS_ID, String.valueOf(getSystemAndEmojiFaceSvrId(systemAndEmojiEmoticonInfo)));
            VideoReport.setElementParams(view, hashMap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(LOG_TAG, 2, "bindSystemAndEmojiFaceView, input params error, emotionOrder:" + i3);
        }
    }

    public static int[] getSystemAndEmojiFaceIndexResult(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo, int i3) {
        int[] iArr = {0, 0};
        if (systemAndEmojiEmoticonInfo == null) {
            return iArr;
        }
        if (systemAndEmojiEmoticonInfo.isCommonUsed) {
            iArr[0] = 0;
            iArr[1] = i3 * 1;
            return iArr;
        }
        int i16 = systemAndEmojiEmoticonInfo.emotionType;
        if (i16 == 1) {
            iArr[0] = 1;
            iArr[1] = i3 * 2;
            return iArr;
        }
        if (i16 == 2) {
            iArr[0] = 2;
            iArr[1] = i3 * 3;
        }
        return iArr;
    }

    public static int getSystemAndEmojiFaceSvrId(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
        if (systemAndEmojiEmoticonInfo == null) {
            return -1;
        }
        int i3 = systemAndEmojiEmoticonInfo.emotionType;
        if (i3 == 2) {
            return QQSysAndEmojiResMgr.getInstance().getResImpl(2).getServerId(systemAndEmojiEmoticonInfo.code);
        }
        if (i3 != 1) {
            return -1;
        }
        return QQSysFaceUtil.convertToServer(systemAndEmojiEmoticonInfo.code);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTReport
    public boolean dtEvent(Object obj, String str, Map<String, String> map, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 2, this, obj, str, map, Boolean.valueOf(z16))).booleanValue();
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.api.IDTReport
    public boolean dtEvent(Object obj, String str, Map<String, String> map, boolean z16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 3, this, obj, str, map, Boolean.valueOf(z16), str2)).booleanValue();
    }
}
