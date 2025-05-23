package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.GamePrivilegeInfo;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class GCPGameMetaInfoBarAttr extends k {
    public GamePrivilegeInfo privilegeInfo;

    public final GamePrivilegeInfo getPrivilegeInfo() {
        GamePrivilegeInfo gamePrivilegeInfo = this.privilegeInfo;
        if (gamePrivilegeInfo != null) {
            return gamePrivilegeInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privilegeInfo");
        return null;
    }
}
