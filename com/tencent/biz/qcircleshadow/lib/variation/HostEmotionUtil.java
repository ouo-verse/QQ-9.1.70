package com.tencent.biz.qcircleshadow.lib.variation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qqemoticon.api.ISysEmoApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.qzone.widget.QzoneEmotionUtils;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostEmotionUtil {
    public static String EMO_PREFIX() {
        return QzoneEmotionUtils.EMO_PREFIX;
    }

    public static String EMO_TAIL() {
        return QzoneEmotionUtils.EMO_TAIL;
    }

    public static String SIGN_ICON_URL_END() {
        return QzoneEmotionUtils.SIGN_ICON_URL_END;
    }

    public static String SIGN_ICON_URL_PREFIX() {
        return QzoneEmotionUtils.SIGN_ICON_URL_PREFIX;
    }

    public static void addToCommonUse(SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
        systemAndEmojiEmoticonInfo.addToCommonUsed(MobileQQ.sMobileQQ.waitAppRuntime(null), (Parcelable) null);
    }

    public static String getDescription(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QQSysFaceUtil.getLocalIdFromEMCode(str) != -1) {
            return QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.getLocalIdFromEMCode(str));
        }
        if (QQEmojiUtil.getLocalIdFromEMCode(str) == -1) {
            return null;
        }
        return QQEmojiUtil.getEmojiDescription(QQEmojiUtil.getLocalIdFromEMCode(str));
    }

    public static Drawable getEmoDrawableFromEMCode(String str) {
        return ((ISysEmoApi) QRoute.api(ISysEmoApi.class)).getEmoDrawableFromEMCode(str);
    }

    public static String getEmoString(int i3, int i16) {
        return ((ISysEmoApi) QRoute.api(ISysEmoApi.class)).getEmoString(i3, i16);
    }

    public static String getEmoUrlFromConfig(String str) throws Exception {
        return QzoneEmotionUtils.getEmoUrlFromConfig(str);
    }

    public static View getEmojiPanel(Context context, EditText editText, EmoticonCallback emoticonCallback, int i3) {
        return new SystemAndEmojiUniversalPanel.Builder(context).setEmoticonCallback(emoticonCallback).setShowCommonUsedSystemEmoji(true).setShowDeleteButton(editText).setRowCount(i3).create(QCircleServiceImpl.getQQService().getEmotionImpl());
    }

    public static String getEmojiString(int i3) {
        return com.tencent.mobileqq.text.TextUtils.getEmojiString(i3);
    }

    public static String getFaceString(int i3) {
        return QQSysFaceUtil.getFaceString(i3);
    }

    public static String splash2Emo(String str) {
        return QzoneEmotionUtils.splash2Emo(str);
    }

    public static String substring(String str, int i3) {
        if (str.length() <= i3) {
            return str;
        }
        String neoTextAfter = com.tencent.mobileqq.text.TextUtils.getNeoTextAfter(str, 0, i3, false);
        if (neoTextAfter.length() < str.length()) {
            return neoTextAfter + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return neoTextAfter;
    }
}
