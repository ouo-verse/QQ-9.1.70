package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import f35.e;
import java.util.List;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPGuideTagCardAttr extends NBPGuideTagBaseCardAttr {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagCardAttr.class, "mainTagId", "getMainTagId()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPGuideTagCardAttr.class, "themeIndex", "getThemeIndex()I", 0)};
    public List<String> tagCommonIconList;
    public List<e> tagSpecificIconList;
    public final ReadWriteProperty mainTagId$delegate = c.a(-1);
    public final ReadWriteProperty themeIndex$delegate = c.a(0);

    public final int getThemeIndex() {
        return ((Number) this.themeIndex$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }
}
