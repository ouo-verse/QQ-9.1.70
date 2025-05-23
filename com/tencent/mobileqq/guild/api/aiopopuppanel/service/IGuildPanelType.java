package com.tencent.mobileqq.guild.api.aiopopuppanel.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes12.dex */
public @interface IGuildPanelType {
    public static final int POPUP_PANEL_AT = 1;
    public static final int POPUP_PANEL_GUILD_SELECTOR = 32;
    public static final int POPUP_PANEL_HASHTAG = 2;
    public static final int POPUP_PANEL_MASK = -1;
    public static final int POPUP_PANEL_NONE = 0;
    public static final int POPUP_PANEL_PART = 8;
    public static final int POPUP_PANEL_SLASH = 4;
    public static final int POPUP_PANEL_TROOP_TAG = 16;
}
