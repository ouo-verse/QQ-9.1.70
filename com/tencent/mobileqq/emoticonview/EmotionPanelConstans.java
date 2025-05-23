package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.api.IVasEmojiManagerService;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* loaded from: classes12.dex */
public class EmotionPanelConstans extends EmoticonViewBinder implements MarketFaceConstants {
    static IPatchRedirector $redirector_ = null;
    public static final int COLUMNNUM_CAMERA_EMO = 4;
    public static final int COLUMNNUM_CMSHOW = 4;
    public static final int COLUMNNUM_FAVORITE = 4;
    public static final int COLUMNNUM_HOTPIC_SEARCH = 4;
    public static final int COLUMNNUM_MAGIC_FACE = 4;
    public static final int COLUMNNUM_RECOMMENT = 3;
    public static final int COLUMNNUM_SMALL_EMOTION = 7;
    public static final int COLUMNNUM_ZPLAN = 4;
    public static final int COLUMNNUM_ZPLAN_BIG_SCREEN = 5;
    public static final int COLUMNUM_BIG_EMOTION = 4;
    public static final int COLUMN_NUM_AI_EMOTICON = 5;
    public static final int COLUMN_NUM_ANI_STICKER = 5;
    public static final int COLUMN_NUM_HOTPIC_SEARCH_TAB = 4;
    public static final int PANEL_TYPE_AI = 22;
    public static final int PANEL_TYPE_ANI_STICKER = 21;
    public static final int PANEL_TYPE_BIG_EMOTION_COMPLETE_INVALID = 10;
    public static final int PANEL_TYPE_BIG_EMOTION_DOWNLOADED = 6;
    public static final int PANEL_TYPE_BIG_EMOTION_NEED_UPDATE = 8;
    public static final int PANEL_TYPE_CAMERA_EMOTION = 13;
    public static final int PANEL_TYPE_CMSHOW_EMOTION = 15;
    public static final int PANEL_TYPE_EMOJI_EMOTICON = 17;
    public static final int PANEL_TYPE_EMOTION_COMPLETE_INVALID = 12;
    public static final int PANEL_TYPE_EMOTION_NEED_DOWNLOAD_OR_INVALID = 7;
    public static final int PANEL_TYPE_FAVORITE = 4;
    public static final int PANEL_TYPE_GUILD_REACTION_RECENT_EMOTICON = 18;
    public static final int PANEL_TYPE_HOTPIC_SEARCH_EMOTION = 14;
    public static final int PANEL_TYPE_HOTPIC_SEARCH_TAB = 20;
    public static final int PANEL_TYPE_MAGIC_FACE = 5;
    public static final int PANEL_TYPE_RECOMMEND = 3;
    public static final int PANEL_TYPE_SMALL_EMOTION_COMPLETE_INVALID = 11;
    public static final int PANEL_TYPE_SMALL_EMOTION_DOWNLOADED = 2;
    public static final int PANEL_TYPE_SMALL_EMOTION_NEED_UPDATE = 9;
    public static final int PANEL_TYPE_SYSTEM_AND_EMOJI = 1;
    public static final int PANEL_TYPE_SYS_EMOTICON = 16;
    public static final int PANEL_TYPE_TKD_COMMENT_END = 1100;
    public static final int PANEL_TYPE_TKD_COMMENT_START = 1000;
    public static final int PANEL_TYPE_ZPLAN_EMOTION = 19;
    public static final String RELATED_EMO_C2C_HTTP_PREFIX = "https://c2cpicdw.qpic.cn";
    public static final String RELATED_EMO_GROUP_HTTP_PREFIX = "https://gchat.qpic.cn";
    public static final String TAG = "EmotionPanelConstans";
    public static String emoticonAIOPreviewExtensionUrl;
    public static String emoticonEncryptExtensionApngUrl;
    public static String emoticonEncryptExtensionUrl;
    public static String emoticonPNGZIPUrl;
    public static String emoticonPreviewUrl;
    public static String emoticonRecommendUrl;
    public static String emoticonSoundUrl;
    public static String giftBigAnimationPath;
    public static String smallApngUrl;
    public static String smallEmoticonJsonUrl;
    public static String smallEmoticonThumbUrl;
    public static String smallGifUrl;
    public static String smallRecommendUrl;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45442);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        smallGifUrl = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].gif";
        smallApngUrl = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId]_apng.png";
        smallEmoticonJsonUrl = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/xydata.json";
        smallEmoticonThumbUrl = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].png";
        emoticonSoundUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/ring.amr";
        emoticonPNGZIPUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/pngframe.zip";
        emoticonPreviewUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/126x126.png";
        emoticonEncryptExtensionUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]";
        emoticonEncryptExtensionApngUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]_apng";
        emoticonAIOPreviewExtensionUrl = "https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]x[height].png";
        emoticonRecommendUrl = "https://gxh.vip.qq.com/club/item/parcel/img/parcel/[mod]/[epId]/200x200.png";
        smallRecommendUrl = "https://gxh.vip.qq.com/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/200x200.png";
        giftBigAnimationPath = AppConstants.SDCARD_GIFT_SAVE + "[epId]" + File.separator;
    }

    public EmotionPanelConstans(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        }
    }

    private static int getEmotionPanelType(IEmoticonMainPanelApp iEmoticonMainPanelApp, EmotionPanelInfo emotionPanelInfo, boolean z16) {
        if (iEmoticonMainPanelApp != null && emotionPanelInfo != null) {
            EmoticonPackage emoticonPackage = emotionPanelInfo.emotionPkg;
            if (emoticonPackage == null) {
                QLog.e(TAG, 1, "getEmotionPanelType emotionPkg is null; type = " + emotionPanelInfo.type);
                return -1;
            }
            boolean emoticonPkgNeedUpdate = ((IVasEmojiManagerService) QRoute.api(IVasEmojiManagerService.class)).emoticonPkgNeedUpdate(emoticonPackage.status, emoticonPackage.updateFlag);
            int i3 = emoticonPackage.status;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getEmotionPanelType epid = " + emoticonPackage.epId + "status = " + i3 + ";shouldUpdate = " + emoticonPkgNeedUpdate);
            }
            if (emoticonPackage.valid && i3 != 3 && isAuthorized(iEmoticonMainPanelApp, emoticonPackage)) {
                if (emoticonPkgNeedUpdate) {
                    if (z16) {
                        return 9;
                    }
                    return 8;
                }
                if (i3 != 2) {
                    return 7;
                }
                if (z16) {
                    return 2;
                }
                return 6;
            }
            if (i3 != 2) {
                return 7;
            }
            return 12;
        }
        QLog.e(TAG, 1, "getEmotionPanelType app or panelinfo is null");
        return -1;
    }

    public static int getPanelType(IEmoticonMainPanelApp iEmoticonMainPanelApp, EmotionPanelInfo emotionPanelInfo) {
        if (emotionPanelInfo == null) {
            return -1;
        }
        int i3 = emotionPanelInfo.type;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getPanelType type = " + i3);
        }
        switch (i3) {
            case 1:
                return 16;
            case 2:
                return 17;
            case 3:
            case 5:
            case 13:
            case 14:
            case 18:
            default:
                if (i3 < 1000 || i3 > 1100) {
                    return -1;
                }
                return i3;
            case 4:
                return 4;
            case 6:
                return getEmotionPanelType(iEmoticonMainPanelApp, emotionPanelInfo, false);
            case 7:
                return 1;
            case 8:
                return 3;
            case 9:
                return 5;
            case 10:
                return getEmotionPanelType(iEmoticonMainPanelApp, emotionPanelInfo, true);
            case 11:
                return 13;
            case 12:
                return 14;
            case 15:
                return 15;
            case 16:
                return 18;
            case 17:
                return 19;
            case 19:
                return 21;
            case 20:
                return 22;
        }
    }

    public static boolean isAuthorized(IEmoticonMainPanelApp iEmoticonMainPanelApp, EmoticonPackage emoticonPackage) {
        if (emoticonPackage != null && iEmoticonMainPanelApp != null) {
            return ((IVasEmojiManagerService) QRoute.api(IVasEmojiManagerService.class)).isAuthorized(iEmoticonMainPanelApp, emoticonPackage.mobileFeetype);
        }
        return false;
    }
}
