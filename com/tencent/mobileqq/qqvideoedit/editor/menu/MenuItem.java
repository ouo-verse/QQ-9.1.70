package com.tencent.mobileqq.qqvideoedit.editor.menu;

import androidx.annotation.DrawableRes;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes17.dex */
public enum MenuItem {
    CROP("\u88c1\u526a", R.drawable.qui_crop_icon_white, MenuType.CROP),
    TEXT("\u6587\u5b57", R.drawable.qui_edit_imgviewer_icon_white, MenuType.TEXT),
    VOLUME("\u58f0\u97f3", R.drawable.qui_voice_high_icon_white, MenuType.SWITCH_VOLUME);


    @DrawableRes
    private final int icon;
    private final MenuType menuType;
    private final String name;

    MenuItem(String str, int i3, MenuType menuType) {
        this.name = str;
        this.icon = i3;
        this.menuType = menuType;
    }

    @DrawableRes
    public int getIcon() {
        return this.icon;
    }

    public MenuType getMenuType() {
        return this.menuType;
    }

    public String getName() {
        return this.name;
    }
}
