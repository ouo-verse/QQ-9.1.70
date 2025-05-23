package com.tencent.hippykotlin.demo.pages.nearby.base;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;

/* loaded from: classes31.dex */
public final class NBPSchemeGeneratorKt {
    public static final String getLandMarkScheme(int i3, String str, String str2) {
        StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("mqqapi://zplan/enterChatLand?src_type=app&version=1.0&appId=", i3, "&roomId=", str, "&source=6&jump_url=");
        m3.append(str2);
        return m3.toString();
    }
}
