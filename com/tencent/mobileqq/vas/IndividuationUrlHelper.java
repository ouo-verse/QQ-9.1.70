package com.tencent.mobileqq.vas;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasWebUrl;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class IndividuationUrlHelper {
    private static final String TAG = "IndividuationUrlHelper";
    public static final int VIP_TYPE_NONE = 1;
    public static final int VIP_TYPE_SVIP = 4;
    public static final int VIP_TYPE_VIP = 2;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface AdTag {
        public static final String DETAIL_FONT_ADTAG = "mvip.gexinghua.mobile.font.client_tab_store";
        public static final String DETAIL_PENDANT_ADTAG = "mvip.gexinghua.mobile.faceaddon.client_tab_store";
        public static final String INDIVIDUATION_BUBBLE_ADTAG = "mvip.gongneng.android.bubble.index_dynamic_tab";
        public static final String INDIVIDUATION_COLORRING_ADTAG = "mvip.gongneng.anroid.individuation.web";
        public static final String INDIVIDUATION_FUNCALL_ADTAG = "mvip.gongneng.anroid.individuation.web";
        public static final String INDIVIDUATION_SUIT_ADTAG = "mvip.gongneng.android.gxsuit";
        public static final String INDIVIDUATION_THEME_ADTAG = "mvip.gongneng.android.theme.index_dynamic_tab";
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface UrlId {
        public static final String BUBBLE_DETAIL = "bubbleDetail";
        public static final String BUBBLE_DETAIL_DLG = "bubbleDetailDialog";
        public static final String BUBBLE_HOME = "bubble";
        public static final String BUBBLE_PREVIEW = "bubblePreview";
        public static final String CALL_DETAIL = "callDetail";
        public static final String CALL_HOME = "call";
        public static final String CARD_DETAIL = "cardDetail";
        public static final String CARD_HOME = "card";
        public static final String CARD_WORD = "cardWord";
        public static final String CARD_WZRY_MADE = "gameHonourAddHonour";
        public static final String CHAT_BG_DETAIL = "backgroundDetail";
        public static final String CHAT_BG_HOME = "background";
        public static final String COLORRING_AUDIO = "colorringAudio";
        public static final String COLORRING_CONFIG = "colorringConfig";
        public static final String COLORRING_COVER = "colorringCover";
        public static final String DIY_PIC = "diyPic";
        public static final String EMOJI_AUTHOR_DETAIL = "emojiAuthorDetail";
        public static final String EMOJI_DETAIL = "emojiDetail";
        public static final String EMOJI_HOME = "emoji";
        public static final String EMOJI_OPEN_AUTHOR_DETAIL = "openAuthorDetail";
        public static final String EMOTICON_KEYWORD = "emoticonKeyword";
        public static final String FACE_HOME = "faceEntryUrl";
        public static final String FONT_AIO_IMG = "fontAioImg";
        public static final String FONT_DETAIL = "fontDetail";
        public static final String FONT_DETAIL_DLG = "fontDetailDialog";
        public static final String FONT_EFFECT = "aioMagicFontEntrance";
        public static final String FONT_EFFECT_NONE = "aioNoMagicFontEntrance";
        public static final String FONT_HOME = "font";
        public static final String FONT_PREVIEW = "fontPreview";
        public static final String FRIEND_TO_DIY_PENDANT_HOME = "FriendToDIYPendant";
        public static final String FRIEND_TO_PENDANT_HOME = "FriendToPendant";
        public static final String FUNCALL_MINE = "funCallMine";
        public static final String FUNNY_PIC = "funnyPic";
        public static final String GROUP_KEYWORD = "groupkeywords";
        public static final String INDIVIDUATION_MAIN_PAGE = "personalIndex";
        public static final String KUOLIE_PERSONAL_CARD_MASTER = "kuoliePersonalCardMaster";
        public static final String LINK_PENDANT_SET = "linkPendantSet";
        public static final String MAGIC_PLUS = "magicPlus";
        public static final String MY_FONT = "myFont";
        public static final String MY_PENDANT = "myPendantUrl";
        public static final String NAMEPLATE_CLICK_DEFAULT = "NameplateClickDefault";
        public static final String NAMEPLATE_CLICK_SVIP = "NameplateClickSvip";
        public static final String PENDANT_DETAIL = "pendantDetail";
        public static final String PENDANT_DETAIL_DLG = "pendantDetailDialog";
        public static final String PENDANT_HOME = "pendant";
        public static final String PLATEOFKINGDAN = "gameIconSetupH5Url";
        public static final String PRAISE_HOME = "praise";
        public static final String RARE_CARD = "rareCard";
        public static final String RARE_PENDANT_ACTIVITY = "rarePendantActivity";
        public static final String RED_PACKET_HOME = "hongbao";
        public static final String RING_DETAIL = "ringDetail";
        public static final String RING_HOME = "ring";
        public static final String SIGNATURE_DIY_EDIT = "signatureDIYEntrance";
        public static final String SIGNATURE_EDIT = "signatureEntrance";
        public static final String SIGNATURE_TEMPLATE = "signatureTemplate";
        public static final String SMALL_EMOJI_LIST = "smallEmojiList";
        public static final String SPECIALCARE_MALL_URL = "specialCareRingUrl";
        public static final String STICKER_DETAIL = "aioEmojiStickerDetail";
        public static final String SUIT_DETAIL = "suitDetail";
        public static final String SUIT_HOME = "suit";
        public static final String THEME_DETAIL = "themeDetail";
        public static final String THEME_HOME = "theme";
        public static final String THEME_PATCH = "themepatch";
        public static final String TROOP_ENTER_EFFECT = "troopEnterEffect";
        public static final String VASCLASS_PROFILESTORY_URL = "vasClassProfileStoryUrl";
        public static final String VIP_CHAT_ROAM_CELL = "vipRoamChatCell";
        public static final String VIP_EXTEND_ICON = "extendnameplateiconurl";
        public static final String VIP_EXTEND_ICON_URL = "extendnameplatejumpurl_";
        public static final String VIP_GAMECENTER_LEBA = "vipGameCenter";
        public static final String VIP_GAMECENTER_PERSONAL_CARD = "vipPersonalCardMyGame";
        public static final String VIP_PERSONAL_CARD_CUSTOM = "vipPersonalCardCustom";
        public static final String VIP_PERSONAL_CARD_MASTER = "vipPersonalCardMaster";
        public static final String VIP_UP_GROUP_LIMIT = "vipUpGroupLimit";
    }

    private static String decodeMarketDetailUrl(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "decodeMarketDetailUrl:" + str + ", id=" + str2);
            }
            String decodeMarketUrl = decodeMarketUrl(str, str3);
            if (!TextUtils.isEmpty(decodeMarketUrl)) {
                return decodeMarketUrl.replace("[id]", str2);
            }
            return decodeMarketUrl;
        }
        return null;
    }

    private static String decodeMarketUrl(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "decodeMarketUrl:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str + "&adtag=" + str2;
        }
        return str;
    }

    public static String getMarketDetailUrl(Context context, String str, String str2, String str3) {
        return decodeMarketDetailUrl(getUrl(str), str2, str3);
    }

    public static String getMarketUrl(Context context, String str, String str2) {
        return decodeMarketUrl(getUrl(str), str2);
    }

    @Deprecated
    public static String getUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        VasCommonReporter.getHistoryFeature("individua_geturl").setValue2(str).reportEveryDay();
        return ((IVasWebUrl) QRoute.api(IVasWebUrl.class)).getUrl(str);
    }
}
