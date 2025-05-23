package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar;

import c01.c;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPModalNavbarAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPModalNavbarAttr.class, OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "isFullScreen()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPModalNavbarAttr.class, "avatarOpacity", "getAvatarOpacity()F", 0)};
    public NBPHomePageBaseViewModel viewModel;
    public final ReadWriteProperty isFullScreen$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty avatarOpacity$delegate = c.a(Float.valueOf(0.0f));

    public final float getAvatarOpacity() {
        return ((Number) this.avatarOpacity$delegate.getValue(this, $$delegatedProperties[1])).floatValue();
    }

    public final boolean isFullScreen() {
        return ((Boolean) this.isFullScreen$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }
}
