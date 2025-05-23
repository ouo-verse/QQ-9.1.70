package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameTab;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.IconButton;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GCPIconButtonItemAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPIconButtonItemAttr.class, "pageDidAppearTimes", "getPageDidAppearTimes()I", 0)};
    public IconButton activityData;
    public GameTab gameTab;
    public int index;
    public final ReadWriteProperty pageDidAppearTimes$delegate = c.a(0);

    public final IconButton getActivityData() {
        IconButton iconButton = this.activityData;
        if (iconButton != null) {
            return iconButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("activityData");
        return null;
    }
}
