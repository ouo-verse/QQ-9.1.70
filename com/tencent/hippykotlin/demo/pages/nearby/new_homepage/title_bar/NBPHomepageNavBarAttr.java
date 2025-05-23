package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.title_bar;

import c01.c;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPHomepageNavBarAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomepageNavBarAttr.class, OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, "isFullScreen()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomepageNavBarAttr.class, "avatarOpacity", "getAvatarOpacity()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPHomepageNavBarAttr.class, "isMinScreen", "isMinScreen()Z", 0)};
    public final ReadWriteProperty avatarOpacity$delegate;
    public final ReadWriteProperty isFullScreen$delegate;
    public final ReadWriteProperty isMinScreen$delegate;
    public boolean isSelf = true;
    public NBPHomePageBaseViewModel viewModel;

    public NBPHomepageNavBarAttr() {
        Boolean bool = Boolean.FALSE;
        this.isFullScreen$delegate = c.a(bool);
        this.avatarOpacity$delegate = c.a(Float.valueOf(0.0f));
        this.isMinScreen$delegate = c.a(bool);
    }
}
