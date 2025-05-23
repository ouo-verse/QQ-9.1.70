package com.tencent.mobileqq.vas.updatesystem;

import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AbiUtil;
import java.io.File;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasUpdateConstants {
    public static final long BID_COMIC = 100;
    public static final long BID_DEFAULT_CARD = 33;
    public static final long BID_FONT = 5;
    public static final long BID_JSON = 1000;
    public static final long BID_NAME_PLATE = 34;
    public static final long BID_POKE = 21;
    public static final long BID_PROFILE_CARD = 15;

    @Deprecated
    public static final long BID_REDPACKET = 16;
    public static final long BID_SONIC_TEMPLATE_UPDATE = 1001;
    public static final long BID_STICKER_GUIDE_MATERIAL = 1004;
    public static final String BUSINESS_VAS_UPDATE_SYSTEM = "vas_update_system";
    public static final String ENGINE_CONFIG_PATH;
    public static final boolean IS_CPU_64_BIT;
    public static final String SCID_APNG_SO;
    public static final String SCID_AVATARIN_PENDANT_JSON = "avatarInPendant_json";
    public static final String SCID_BLESS_VOICECHANGE = "blessVoiceList.json";
    public static final String SCID_BUBBLE_PASTER_PREFIX = "bubble.paster.";
    public static final String SCID_BUBBLE_PREFIX = "bubble.android.";
    public static final String SCID_CARD_PREFIX = "card.";
    public static final String SCID_CHANGEVOICE = "changeVoice_json";
    public static final String SCID_CHATBG_PREFIX = "chatbg.";
    public static final String SCID_COLORFONT_SO;
    public static final String SCID_COMIC_CONFIG = "vipComic_config_v2.json";
    public static final String SCID_COMIC_NAV_CONFIG = "vipComic_nav_config.json";
    public static final String SCID_COMIC_NAV_ICON = "vipComic_nav_tabIcon.zip";
    public static final String SCID_COMIC_PLAYER_SO = "libqgplayer_765_64";
    public static final String SCID_DEFAULT_CARD_CFG_PREFIX = "profileitem.";
    public static final String SCID_DEFAULT_FONT = "defaultFont_775";
    public static final String SCID_DIY_CARD_CONFIG = "card.diyFontConfig.json";
    public static final String SCID_DIY_CARD_FONT_PREFIX = "font.diycard.android.";
    public static final String SCID_EMOJI_KEYWORD = "keywordList_2.json";
    public static final String SCID_EMOTICON_RECOMMEND_EFFECT = "emotionRecommendEffect";
    public static final String SCID_ENTER_EFFECT_CONFIG = "groupeffect_config.json";
    public static final String SCID_ENTER_EFFECT_VIP_ICONS = "enterEffectVipIcons";
    public static final String SCID_FACE_PREFIX = "face.";
    public static final String SCID_FLASH_CHAT_PREFIX = "flashchat.";
    public static final String SCID_FLATBUFFERS;
    public static final String SCID_FONT_EFFECT = "magicFontConfig.json";
    public static final String SCID_FONT_FZ_PREFIX = "font.fzfont.android.";
    public static final String SCID_FONT_PREFIX = "font.main.android.";
    public static final String SCID_H5_MAGIC_ZIP = "bqmall.android.h5magic.";
    public static final String SCID_HIBOOM_CONFIG_PREFIX = "font.hiFontQQ.json.";
    public static final String SCID_HIBOOM_FONT_PREFIX = "font.hifont.android.";
    public static final String SCID_HIBOOM_TAG = "font.hiFontQQ.tags";
    public static final String SCID_HYFONT_SO;
    public static final String SCID_KANDIAN_RECOMMENT_EMOTICON = "watch_focus.json";
    public static final String SCID_MAGIC_FACE_ENTRY_CONFIG = "emoji_app_vip_emoji_aio_android_config.json";
    public static final String SCID_NAME_PLATE_SRC = "namePlate.{id}.zip";
    public static final String SCID_PENDANT_FONT_PREFIX = "faceAddon.stickerFont.android.";
    public static final String SCID_PENDANT_MARKET_CONFIG = "pendant_market_json.android.v2";
    public static final String SCID_PENDANT_PASTER_PREFIX = "faceAddon.sticker.";
    public static final String SCID_PENDANT_PREFIX = "pendant.";
    public static final String SCID_PERSONAL_CONFIG = "vip_personal_card.json";
    public static final String SCID_POKE_EFFECT_LIST = "poke.effectList";
    public static final String SCID_POKE_EFFECT_PREFIX = "poke.item.res.";
    public static final String SCID_POKE_PANEL_PREFIX = "poke.item.effect.";
    public static final String SCID_PRAISE_CONFIG = "praise.config.json";
    public static final String SCID_PRAISE_PREFIX = "praise.android.";

    @Deprecated
    public static final String SCID_REDPACKET_300CHAR = "iRedPacket_v3.char300.json";

    @Deprecated
    public static final String SCID_REDPACKET_CONFIG = "iRedPacket_v3.json";

    @Deprecated
    public static final String SCID_REDPACKET_FONT_ZIP = "iRedPacket_v3.font.zip";

    @Deprecated
    public static final String SCID_REDPACKET_PACKETS_ZIP = "luckyMoney.item.";

    @Deprecated
    public static final String SCID_REDPACKET_SPECIAL_ZIP = "iRedPacket_v3.specialChar.zip";
    public static final String SCID_SIGNATURE_STICKER_PREFIX = "signature.sticker.";
    public static final String SCID_SIGNATURE_TEMPLATE_CONFIG_PREFIX = "signature.item.";

    @Deprecated
    public static final String SCID_SONIC_FILE_DISCARD = "sonicTemplateUpdate.json";
    public static final String SCID_STICKER_MATERIAL = "emojiStickerGuideZip_v2";
    public static final String SCID_SYSTEM_EMOJI_WHITE_LIST = "emoji.systemEmojiWhiteList.json";
    public static final String SCID_THEME_DIY_BG = "diytheme.json";
    public static final String SCID_THEME_DIY_STYLE = "diytheme.style.json";
    public static final String SCID_URL_CONFIGURABLE = "vipData_individuation_url.android.json";
    public static final String SCID_VAS_MONITOR_BLACKLIST = "monitorAppid";
    public static final String SCID_WZRY_TEMPLATE = "cardWZ.zip";
    public static final String SP_QUICK_UPDATE_PREFIX = "quick_update_";
    private static final String TAG = "VasUpdateConstants";

    static {
        String str;
        String str2;
        String str3;
        String str4;
        boolean isArm64Runtime = AbiUtil.isArm64Runtime(VasUtil.getApp().getApplicationContext());
        IS_CPU_64_BIT = isArm64Runtime;
        ENGINE_CONFIG_PATH = BaseApplication.getContext().getFilesDir().getAbsolutePath() + File.separator + "quickupdate";
        if (isArm64Runtime) {
            str = "libFlatBuffersParser_64";
        } else {
            str = "libFlatBuffersParser";
        }
        SCID_FLATBUFFERS = str;
        if (isArm64Runtime) {
            str2 = "libColorFont_818_64";
        } else {
            str2 = "libColorFont_818";
        }
        SCID_COLORFONT_SO = str2;
        if (isArm64Runtime) {
            str3 = "libVipFont_8417_64";
        } else {
            str3 = "libVipFont_8417";
        }
        SCID_HYFONT_SO = str3;
        if (isArm64Runtime) {
            str4 = "libAPNG_845_64";
        } else {
            str4 = "libAPNG_845";
        }
        SCID_APNG_SO = str4;
    }

    public static QQVasUpdateBusiness<?> getNewBusiness(long j3) {
        if (QQVasUpdateBusiness.isUseUpdateBusinessMigration(j3).booleanValue()) {
            try {
                return QQVasUpdateBusiness.getBusiness(j3);
            } catch (Exception e16) {
                QLog.w(TAG, 1, "getNewBusiness", e16);
                return null;
            }
        }
        return null;
    }
}
