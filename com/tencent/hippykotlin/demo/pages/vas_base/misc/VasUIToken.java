package com.tencent.hippykotlin.demo.pages.vas_base.misc;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.h;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class VasUIToken {
    public static final VasUIToken INSTANCE = new VasUIToken();
    public static Boolean isCurrentThemeDark;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("bubble_guest", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.1
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4280559144L);
            }
        });
        linkedHashMap.put("bubble_guest_text_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.2
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4279901214L);
                }
                return new h(4293980404L);
            }
        });
        linkedHashMap.put("bubble_guest_text_secondary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.3
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4287664276L);
                }
                return new h(4287664276L);
            }
        });
        linkedHashMap.put("bubble_host_bottom", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.4
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278229503L);
                }
                return new h(4280559144L);
            }
        });
        linkedHashMap.put("bubble_host_text_link", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.5
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4288801279L);
                }
                return new h(4281169893L);
            }
        });
        linkedHashMap.put("bubble_host_text_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.6
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4293980404L);
            }
        });
        linkedHashMap.put("bubble_host_text_secondary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.7
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(3439329279L);
                }
                return new h(4287664276L);
            }
        });
        linkedHashMap.put("bubble_host_top", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.8
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278229503L);
                }
                return new h(4280559144L);
            }
        });
        linkedHashMap.put("qqsvip_text_highlight", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.9
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4291534941L);
                }
                return new h(4292785268L);
            }
        });
        linkedHashMap.put("qqsvip_text_price", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.10
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294917698L);
                }
                return new h(4294917698L);
            }
        });
        linkedHashMap.put("qqsvip_text_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.11
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4286729998L);
                }
                return new h(4293769836L);
            }
        });
        linkedHashMap.put("qqsvip_text_secondary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.12
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4293769836L);
                }
                return new h(4292454493L);
            }
        });
        linkedHashMap.put("text_allwhite_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.13
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4294967295L);
            }
        });
        linkedHashMap.put("text_allwhite_secondary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.14
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(3439329279L);
                }
                return new h(3439329279L);
            }
        });
        linkedHashMap.put("text_allwhite_tertiary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.15
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2365587455L);
                }
                return new h(2365587455L);
            }
        });
        linkedHashMap.put("text_link", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.16
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4281169893L);
                }
                return new h(4281169893L);
            }
        });
        linkedHashMap.put("text_nav_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.17
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4279901214L);
                }
                return new h(4293980404L);
            }
        });
        linkedHashMap.put("text_nav_secondary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.18
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4279901214L);
                }
                return new h(4293980404L);
            }
        });
        linkedHashMap.put("text_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.19
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4279901214L);
                }
                return new h(4293980404L);
            }
        });
        linkedHashMap.put("text_secondary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.20
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4287664276L);
                }
                return new h(4287664276L);
            }
        });
        linkedHashMap.put("text_secondary_light", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.21
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4289111718L);
                }
                return new h(4284309089L);
            }
        });
        linkedHashMap.put("text_tabbar_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.22
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4279901214L);
                }
                return new h(4293980404L);
            }
        });
        linkedHashMap.put("text_tertiary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.23
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4291611852L);
                }
                return new h(4284309089L);
            }
        });
        linkedHashMap.put("brand_light", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.24
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(855677439L);
                }
                return new h(855664332L);
            }
        });
        linkedHashMap.put("brand_standard", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.25
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278229503L);
                }
                return new h(4278216396L);
            }
        });
        linkedHashMap.put("on_brand_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.26
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4294967295L);
            }
        });
        linkedHashMap.put("qqsvip_brand_standard", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.27
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4293769836L);
                }
                return new h(4292454493L);
            }
        });
        linkedHashMap.put("qqsvip_qqcard_brand_standard", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.28
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294560553L);
                }
                return new h(4294560553L);
            }
        });
        linkedHashMap.put("button_border_error_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.29
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4291611852L);
                }
                return new h(4282203453L);
            }
        });
        linkedHashMap.put("button_border_error_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.30
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2160905420L);
                }
                return new h(2151497021L);
            }
        });
        linkedHashMap.put("button_border_error_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.31
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4291611852L);
                }
                return new h(4282203453L);
            }
        });
        linkedHashMap.put("button_border_ghost_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.32
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2164260863L);
                }
                return new h(4282203453L);
            }
        });
        linkedHashMap.put("button_border_ghost_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.33
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(872415231L);
                }
                return new h(2151497021L);
            }
        });
        linkedHashMap.put("button_border_ghost_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.34
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2164260863L);
                }
                return new h(4282203453L);
            }
        });
        linkedHashMap.put("button_border_primary_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.35
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("button_border_primary_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.36
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("button_border_primary_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.37
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("button_border_secondary_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.38
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4291611852L);
                }
                return new h(4282203453L);
            }
        });
        linkedHashMap.put("button_border_secondary_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.39
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2160905420L);
                }
                return new h(2151497021L);
            }
        });
        linkedHashMap.put("button_border_secondary_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.40
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4291611852L);
                }
                return new h(4282203453L);
            }
        });
        linkedHashMap.put("qqsvip_button_border_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.41
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("qqsvip_button_border_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.42
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("qqsvip_button_border_overlay_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.43
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("qqsvip_button_border_overlay_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.44
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("qqsvip_button_border_overlay_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.45
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("qqsvip_button_border_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.46
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("qqsvip_qqcard_button_border_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.47
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("qqsvip_qqcard_button_border_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.48
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("qqsvip_qqcard_button_border_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.49
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("button_text_error_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.50
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294396976L);
                }
                return new h(4294396976L);
            }
        });
        linkedHashMap.put("button_text_error_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.51
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(1308052528L);
                }
                return new h(1308052528L);
            }
        });
        linkedHashMap.put("button_text_error_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.52
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294396976L);
                }
                return new h(4294396976L);
            }
        });
        linkedHashMap.put("button_text_ghost_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.53
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4293980404L);
            }
        });
        linkedHashMap.put("button_text_ghost_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.54
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(1308622847L);
                }
                return new h(1308622847L);
            }
        });
        linkedHashMap.put("button_text_ghost_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.55
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4293980404L);
            }
        });
        linkedHashMap.put("button_text_primary_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.56
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4293980404L);
            }
        });
        linkedHashMap.put("button_text_primary_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.57
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2164260863L);
                }
                return new h(1307635956L);
            }
        });
        linkedHashMap.put("button_text_primary_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.58
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4293980404L);
            }
        });
        linkedHashMap.put("button_text_secondary_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.59
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278190080L);
                }
                return new h(4293980404L);
            }
        });
        linkedHashMap.put("button_text_secondary_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.60
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(1291845632L);
                }
                return new h(1307635956L);
            }
        });
        linkedHashMap.put("button_text_secondary_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.61
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278190080L);
                }
                return new h(4293980404L);
            }
        });
        linkedHashMap.put("qqsvip_button_text_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.62
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4286729998L);
                }
                return new h(4286729998L);
            }
        });
        linkedHashMap.put("qqsvip_button_text_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.63
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2156023566L);
                }
                return new h(2156023566L);
            }
        });
        linkedHashMap.put("qqsvip_button_text_overlay_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.64
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278190080L);
                }
                return new h(4294967295L);
            }
        });
        linkedHashMap.put("qqsvip_button_text_overlay_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.65
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(1291845632L);
                }
                return new h(1308622847L);
            }
        });
        linkedHashMap.put("qqsvip_button_text_overlay_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.66
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278190080L);
                }
                return new h(4294967295L);
            }
        });
        linkedHashMap.put("qqsvip_button_text_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.67
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4286729998L);
                }
                return new h(4286729998L);
            }
        });
        linkedHashMap.put("qqsvip_qqcard_button_text_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.68
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278190080L);
                }
                return new h(4278190080L);
            }
        });
        linkedHashMap.put("qqsvip_qqcard_button_text_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.69
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2147483648L);
                }
                return new h(2147483648L);
            }
        });
        linkedHashMap.put("qqsvip_qqcard_button_text_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.70
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278190080L);
                }
                return new h(4278190080L);
            }
        });
        linkedHashMap.put("button_bg_error_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.71
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("button_bg_error_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.72
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("button_bg_error_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.73
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(1305267404L);
                }
                return new h(2570927421L);
            }
        });
        linkedHashMap.put("button_bg_ghost_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.74
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("button_bg_ghost_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.75
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("button_bg_ghost_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.76
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(872415231L);
                }
                return new h(2570927421L);
            }
        });
        linkedHashMap.put("button_bg_primary_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.77
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278229503L);
                }
                return new h(4278216396L);
            }
        });
        linkedHashMap.put("button_bg_primary_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.78
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2147523071L);
                }
                return new h(2147509964L);
            }
        });
        linkedHashMap.put("button_bg_primary_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.79
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278225637L);
                }
                return new h(4278212525L);
            }
        });
        linkedHashMap.put("button_bg_secondary_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.80
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("button_bg_secondary_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.81
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(16777215L);
                }
                return new h(16777215L);
            }
        });
        linkedHashMap.put("button_bg_secondary_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.82
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(1305267404L);
                }
                return new h(2570927421L);
            }
        });
        linkedHashMap.put("qqsvip_button_bg_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.83
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294301867L);
                }
                return new h(4294102678L);
            }
        });
        linkedHashMap.put("qqsvip_button_bg_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.84
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2163595435L);
                }
                return new h(870696081L);
            }
        });
        linkedHashMap.put("qqsvip_button_bg_overlay_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.85
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(2570927421L);
            }
        });
        linkedHashMap.put("qqsvip_button_bg_overlay_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.86
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2164260863L);
                }
                return new h(1295859005L);
            }
        });
        linkedHashMap.put("qqsvip_button_bg_overlay_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.87
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(1305267404L);
                }
                return new h(1295859005L);
            }
        });
        linkedHashMap.put("qqsvip_button_bg_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.88
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294301867L);
                }
                return new h(4294102678L);
            }
        });
        linkedHashMap.put("qqsvip_qqcard_button_bg_default", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.89
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294956089L);
                }
                return new h(4294956089L);
            }
        });
        linkedHashMap.put("qqsvip_qqcard_button_bg_disable", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.90
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2164249657L);
                }
                return new h(2164249657L);
            }
        });
        linkedHashMap.put("qqsvip_qqcard_button_bg_pressed", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.91
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4292717080L);
                }
                return new h(4292717080L);
            }
        });
        linkedHashMap.put("system_color_black", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.92
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278190080L);
                }
                return new h(4294967295L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_01", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.93
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294834416L);
                }
                return new h(4279636233L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_02", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.94
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294768106L);
                }
                return new h(4280227853L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_03", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.95
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294634453L);
                }
                return new h(4282265627L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_04", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.96
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294435264L);
                }
                return new h(4284303400L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_05", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.97
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294301867L);
                }
                return new h(4286341173L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_06", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.98
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294102678L);
                }
                return new h(4288378946L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_07", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.99
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4293969025L);
                }
                return new h(4290416720L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_08", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.100
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4293769836L);
                }
                return new h(4292454493L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_09", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.101
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4291534941L);
                }
                return new h(4292785268L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_10", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.102
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4289299789L);
                }
                return new h(4293181835L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_11", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.103
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4287130174L);
                }
                return new h(4293512610L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_12", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.104
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4284829742L);
                }
                return new h(4293909178L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_13", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.105
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4282660127L);
                }
                return new h(4294239953L);
            }
        });
        linkedHashMap.put("qqsvip_color_gold_14", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.106
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4280424975L);
                }
                return new h(4294636520L);
            }
        });
        linkedHashMap.put("qqsvip_renew_border_gradient_1", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.107
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294962046L);
                }
                return new h(4288252748L);
            }
        });
        linkedHashMap.put("qqsvip_renew_border_gradient_2", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.108
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294955395L);
                }
                return new h(4283712811L);
            }
        });
        linkedHashMap.put("fill_allblack_medium", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.109
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(1493172224L);
                }
                return new h(1493172224L);
            }
        });
        linkedHashMap.put("fill_allblack_strong", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.110
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2147483648L);
                }
                return new h(2147483648L);
            }
        });
        linkedHashMap.put("fill_allblack_weak", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.111
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(1499883110L);
                }
                return new h(1499883110L);
            }
        });
        linkedHashMap.put("fill_allwhite_medium", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.112
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(872415231L);
                }
                return new h(872415231L);
            }
        });
        linkedHashMap.put("fill_allwhite_strong", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.113
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(1308622847L);
                }
                return new h(1308622847L);
            }
        });
        linkedHashMap.put("fill_allwhite_weak", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.114
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(654311423L);
                }
                return new h(654311423L);
            }
        });
        linkedHashMap.put("fill_light_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.115
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4279901214L);
            }
        });
        linkedHashMap.put("fill_light_secondary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.116
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4280559144L);
            }
        });
        linkedHashMap.put("fill_light_tertiary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.117
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(3439329279L);
                }
                return new h(452984831L);
            }
        });
        linkedHashMap.put("fill_standard_brand", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.118
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(167793150L);
                }
                return new h(352321535L);
            }
        });
        linkedHashMap.put("fill_standard_extra", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.119
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(83886080L);
                }
                return new h(352321535L);
            }
        });
        linkedHashMap.put("fill_standard_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.120
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(168628273L);
                }
                return new h(352321535L);
            }
        });
        linkedHashMap.put("fill_standard_quaternary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.121
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(637534208L);
                }
                return new h(654311423L);
            }
        });
        linkedHashMap.put("fill_standard_secondary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.122
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(436207616L);
                }
                return new h(452984831L);
            }
        });
        linkedHashMap.put("qqsvip_tag_text_allgold", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.123
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4286729998L);
                }
                return new h(4286729998L);
            }
        });
        linkedHashMap.put("qqsvip_tag_text_blue", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.124
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278229503L);
                }
                return new h(4278229503L);
            }
        });
        linkedHashMap.put("qqsvip_tag_text_gold", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.125
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4286729998L);
                }
                return new h(4293769836L);
            }
        });
        linkedHashMap.put("qqsvip_tag_text_green", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.126
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4279619955L);
                }
                return new h(4279619955L);
            }
        });
        linkedHashMap.put("qqsvip_tag_text_grey", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.127
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4287401100L);
                }
                return new h(4288256409L);
            }
        });
        linkedHashMap.put("qqsvip_tag_text_navyblue", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.128
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278216396L);
                }
                return new h(4278216396L);
            }
        });
        linkedHashMap.put("qqsvip_tag_text_orange", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.129
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294937920L);
                }
                return new h(4294937920L);
            }
        });
        linkedHashMap.put("qqsvip_tag_text_pink", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.130
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294928051L);
                }
                return new h(4294928051L);
            }
        });
        linkedHashMap.put("qqsvip_tag_text_purple", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.131
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4286932735L);
                }
                return new h(4286932735L);
            }
        });
        linkedHashMap.put("qqsvip_tag_text_red", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.132
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294917698L);
                }
                return new h(4294917698L);
            }
        });
        linkedHashMap.put("qqsvip_tag_text_white", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.133
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4294967295L);
            }
        });
        linkedHashMap.put("qqsvip_tag_text_yellow", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.134
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294947584L);
                }
                return new h(4294947584L);
            }
        });
        linkedHashMap.put("qqsvip_cornermark_bg_gold", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.135
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294301867L);
                }
                return new h(4294102678L);
            }
        });
        linkedHashMap.put("qqsvip_cornermark_bg_red", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.136
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294917698L);
                }
                return new h(4294917698L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_general_black", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.137
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(1291845632L);
                }
                return new h(1291845632L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_general_blue", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.138
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(436247039L);
                }
                return new h(1073781247L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_general_gold", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.139
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(871217772L);
                }
                return new h(1089321580L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_general_green", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.140
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(437637491L);
                }
                return new h(1075171699L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_general_grey", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.141
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(167772160L);
                }
                return new h(352321535L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_general_navyblue", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.142
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(436233932L);
                }
                return new h(1073768140L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_general_orange", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.143
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(452955456L);
                }
                return new h(1090489664L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_general_pink", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.144
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(452945587L);
                }
                return new h(1090479795L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_general_purple", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.145
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(444950271L);
                }
                return new h(1082484479L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_general_red", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.146
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(452942183L);
                }
                return new h(1090476391L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_general_yellow", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.147
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(452965120L);
                }
                return new h(1090499328L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_mall_blue", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.148
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278229503L);
                }
                return new h(4278229503L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_mall_gold", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.149
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294301867L);
                }
                return new h(4294301867L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_mall_green", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.150
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4279619955L);
                }
                return new h(4279619955L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_mall_navyblue", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.151
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278216396L);
                }
                return new h(4278216396L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_mall_orange", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.152
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294937920L);
                }
                return new h(4294937920L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_mall_pink", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.153
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294928051L);
                }
                return new h(4294928051L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_mall_purple", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.154
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4286932735L);
                }
                return new h(4286932735L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_mall_red", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.155
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294924647L);
                }
                return new h(4294924647L);
            }
        });
        linkedHashMap.put("qqsvip_tag_bg_mall_yellow", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.156
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294947584L);
                }
                return new h(4294947584L);
            }
        });
        linkedHashMap.put("bg_aio_01", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.157
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4293848561L);
                }
                return new h(4279177491L);
            }
        });
        linkedHashMap.put("bg_aio_02", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.158
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4293848561L);
                }
                return new h(4279177491L);
            }
        });
        linkedHashMap.put("bg_aio_03", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.159
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4293848561L);
                }
                return new h(4279177491L);
            }
        });
        linkedHashMap.put("bg_aio_04", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.160
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4293848561L);
                }
                return new h(4278190080L);
            }
        });
        linkedHashMap.put("bg_mask_safearea_00", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.161
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(0L);
                }
                return new h(0L);
            }
        });
        linkedHashMap.put("bg_mask_safearea_25", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.162
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(1073741824L);
                }
                return new h(1073741824L);
            }
        });
        linkedHashMap.put("bg_mask_safearea_35", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.163
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(1493172224L);
                }
                return new h(1493172224L);
            }
        });
        linkedHashMap.put("bg_nav_aio", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.164
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(3438539767L);
                }
                return new h(3424263198L);
            }
        });
        linkedHashMap.put("bg_nav_bottom", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.165
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(3438539767L);
                }
                return new h(3424921128L);
            }
        });
        linkedHashMap.put("bg_nav_bottom_aio", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.166
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(3438539767L);
                }
                return new h(3424263198L);
            }
        });
        linkedHashMap.put("bg_nav_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.167
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4293915903L);
                }
                return new h(4280361765L);
            }
        });
        linkedHashMap.put("bg_nav_secondary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.168
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4279901214L);
            }
        });
        linkedHashMap.put("border_allwhite_strong", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.169
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(3439329279L);
                }
                return new h(3439329279L);
            }
        });
        linkedHashMap.put("border_allwhite_weak", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.170
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(872415231L);
                }
                return new h(872415231L);
            }
        });
        linkedHashMap.put("border_light", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.171
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(218103808L);
                }
                return new h(234881023L);
            }
        });
        linkedHashMap.put("border_standard", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.172
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(436207616L);
                }
                return new h(452984831L);
            }
        });
        linkedHashMap.put("border_superlight", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.173
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(3439329279L);
            }
        });
        linkedHashMap.put("overlay_dark", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.174
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2147483648L);
                }
                return new h(2147483648L);
            }
        });
        linkedHashMap.put("overlay_light", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.175
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(251678207L);
                }
                return new h(150994943L);
            }
        });
        linkedHashMap.put("overlay_standard_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.176
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(436207616L);
                }
                return new h(452984831L);
            }
        });
        linkedHashMap.put("overlay_standard_secondary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.177
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(637534208L);
                }
                return new h(637534208L);
            }
        });
        linkedHashMap.put("bg_bottom_brand", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.178
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4293915903L);
                }
                return new h(4280361765L);
            }
        });
        linkedHashMap.put("bg_bottom_dark", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.179
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278190080L);
                }
                return new h(4278190080L);
            }
        });
        linkedHashMap.put("bg_bottom_light", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.180
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4279901214L);
            }
        });
        linkedHashMap.put("bg_bottom_standard", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.181
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294177783L);
                }
                return new h(4279177491L);
            }
        });
        linkedHashMap.put("bg_middle_light", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.182
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4280559144L);
            }
        });
        linkedHashMap.put("bg_middle_standard", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.183
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294309626L);
                }
                return new h(4279901214L);
            }
        });
        linkedHashMap.put("bg_top_dark", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.184
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(2986344448L);
                }
                return new h(2990884682L);
            }
        });
        linkedHashMap.put("bg_top_light", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.185
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4281282611L);
            }
        });
        linkedHashMap.put("qqsvip_bottom_standard", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.186
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294768106L);
                }
                return new h(4280227853L);
            }
        });
        linkedHashMap.put("icon_aio_nav_active", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.187
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278229503L);
                }
                return new h(4278216396L);
            }
        });
        linkedHashMap.put("icon_aio_toolbar_active", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.188
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278229503L);
                }
                return new h(4278216396L);
            }
        });
        linkedHashMap.put("icon_aio_toolbar_normal", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.189
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4281282611L);
                }
                return new h(4291217098L);
            }
        });
        linkedHashMap.put("icon_allwhite_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.190
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294967295L);
                }
                return new h(4294967295L);
            }
        });
        linkedHashMap.put("icon_nav_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.191
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4281282611L);
                }
                return new h(4291217098L);
            }
        });
        linkedHashMap.put("icon_nav_secondary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.192
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4281282611L);
                }
                return new h(4291217098L);
            }
        });
        linkedHashMap.put("icon_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.193
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4281282611L);
                }
                return new h(4291217098L);
            }
        });
        linkedHashMap.put("icon_secondary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.194
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4287664276L);
                }
                return new h(4287664276L);
            }
        });
        linkedHashMap.put("icon_tabbar_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.195
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4279901214L);
                }
                return new h(4291217098L);
            }
        });
        linkedHashMap.put("icon_tertiary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.196
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4291611852L);
                }
                return new h(4284309089L);
            }
        });
        linkedHashMap.put("qqsvip_icon_primary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.197
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4286729998L);
                }
                return new h(4293769836L);
            }
        });
        linkedHashMap.put("qqsvip_icon_secondary", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.198
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4293769836L);
                }
                return new h(4292454493L);
            }
        });
        linkedHashMap.put("feedback_error", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.199
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294396976L);
                }
                return new h(4294396976L);
            }
        });
        linkedHashMap.put("feedback_normal", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.200
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4278229503L);
                }
                return new h(4278229503L);
            }
        });
        linkedHashMap.put("feedback_success", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.201
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4279619955L);
                }
                return new h(4279619955L);
            }
        });
        linkedHashMap.put("feedback_warning", new Function0<h>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.misc.VasUIToken.202
            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                if (!VasUIToken.INSTANCE.isDarkMode()) {
                    return new h(4294947584L);
                }
                return new h(4294947584L);
            }
        });
    }

    public final boolean isDarkMode() {
        Boolean bool = isCurrentThemeDark;
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            return false;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return true;
        }
        return QUIToken.INSTANCE.isNightMode();
    }
}
