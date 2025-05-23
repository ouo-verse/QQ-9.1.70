package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken;
import com.tencent.kuikly.core.base.h;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoThemeData {
    public static final JubaoThemeData INSTANCE = new JubaoThemeData();
    public static final h operateViewBorderColor = new h(4293915903L);

    public final h getButtonBorderSecondaryDefault() {
        if (!VasUIToken.INSTANCE.isDarkMode()) {
            return new h(4291611852L);
        }
        return new h(4282203453L);
    }

    public final h getButtonTextSecondaryDefault() {
        if (!VasUIToken.INSTANCE.isDarkMode()) {
            return new h(4278190080L);
        }
        return new h(4293980404L);
    }

    public final h getConfirmBtnBgColor() {
        if (!VasUIToken.INSTANCE.isDarkMode()) {
            return new h(4278229503L);
        }
        return new h(4278216396L);
    }

    public final h getConfirmBtnTextColor() {
        if (!VasUIToken.INSTANCE.isDarkMode()) {
            return new h(4294967295L);
        }
        return new h(4293980404L);
    }

    public final h getContentTextColor() {
        if (!VasUIToken.INSTANCE.isDarkMode()) {
            return new h(4287664276L);
        }
        return new h(4287664276L);
    }

    public final h getDisableBtnBgColor() {
        if (!VasUIToken.INSTANCE.isDarkMode()) {
            return new h(4291611852L);
        }
        return new h(4284309089L);
    }

    public final h getFillStandardBrand() {
        if (!VasUIToken.INSTANCE.isDarkMode()) {
            return new h(167793150L);
        }
        return new h(352321535L);
    }

    public final h getItemViewTextColor() {
        if (!VasUIToken.INSTANCE.isDarkMode()) {
            return new h(4279901214L);
        }
        return new h(4293980404L);
    }

    public final h getNavTitleTextColor() {
        if (!VasUIToken.INSTANCE.isDarkMode()) {
            return new h(4279901214L);
        }
        return new h(4293980404L);
    }

    public final h getPageBackgroundColor() {
        if (!VasUIToken.INSTANCE.isDarkMode()) {
            return new h(4294177783L);
        }
        return new h(4279177491L);
    }

    public final h getPartingLineColor() {
        if (!VasUIToken.INSTANCE.isDarkMode()) {
            return new h(436207616L);
        }
        return new h(452984831L);
    }

    public final h getTitleTextColor() {
        if (!VasUIToken.INSTANCE.isDarkMode()) {
            return new h(4279901214L);
        }
        return new h(4293980404L);
    }
}
