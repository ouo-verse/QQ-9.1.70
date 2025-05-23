package com.tencent.mobileqq.wink.editor;

import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.mobileqq.winkreport.datong.WinkSchemeConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/MaterialType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TEMPLATE", "AUTO_TEMPLATE", "FIRST_TEMPLATE", "COVER_TEMPLATE", "H5", "CAMERA", "MATERIAL_GROUP", ComponentFactory.ComponentType.PAG, "STICKER", "LYRIC_STICKER", "FILTER", "TEXT", "SPECIAL_EFFECT", "PICK_ONLINE", "DAILY_SIGN_MOOD", "DAILY_SIGN_MUSIC", "DAILY_SIGN_BACKGROUND", "PIC_RECOMMEND", "PIC_RECOMMEND_USER_PUBLISHED", "QZONE_MAGIC_STUDIO", "QZONE_RECOMMEND_TEMPLATE", "OPENING_ENDING", "VIDEO", "IMAGE", "ONLINE_VIDEO_LIGHTSDK", "MAGIC_AVATAR", "OPEN_END_AIGC_TEMPLATE", "UGC_BOT", "TEXT_FONT", "IMAGE_TEMPLATE", "NULL", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum MaterialType {
    TEMPLATE("template"),
    AUTO_TEMPLATE("auto_template"),
    FIRST_TEMPLATE(WinkSchemeConstant.SchemeKey.KEY_SCHEMA_FIRST_TEMPLATE),
    COVER_TEMPLATE("cover_template"),
    H5("h5"),
    CAMERA("camera_motion"),
    MATERIAL_GROUP("material_group"),
    PAG("pag"),
    STICKER("sticker"),
    LYRIC_STICKER("lyric_sticker"),
    FILTER("filter"),
    TEXT("text"),
    SPECIAL_EFFECT("special_effect"),
    PICK_ONLINE("pick_online"),
    DAILY_SIGN_MOOD("daily_sign_mood"),
    DAILY_SIGN_MUSIC("daily_sign_music"),
    DAILY_SIGN_BACKGROUND("daily_background"),
    PIC_RECOMMEND("pic_recommend"),
    PIC_RECOMMEND_USER_PUBLISHED("pic_recommend_user_published"),
    QZONE_MAGIC_STUDIO("qzone_magic_studio"),
    QZONE_RECOMMEND_TEMPLATE("recommend_template"),
    OPENING_ENDING("opening_ending"),
    VIDEO("video"),
    IMAGE("image"),
    ONLINE_VIDEO_LIGHTSDK("onlineVideoLightSDK"),
    MAGIC_AVATAR("Magic_Avatar"),
    OPEN_END_AIGC_TEMPLATE("openEndAigcTemplate"),
    UGC_BOT("ugc_bot"),
    TEXT_FONT("text_font"),
    IMAGE_TEMPLATE("image_template"),
    NULL("");


    @NotNull
    private final String type;

    MaterialType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
