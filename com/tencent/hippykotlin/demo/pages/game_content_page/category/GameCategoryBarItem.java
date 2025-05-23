package com.tencent.hippykotlin.demo.pages.game_content_page.category;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameCategoryBarItem {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameCategoryBarItem.class, QZoneJsConstants.KEY_HIGH_FIVE_TEXT, "getItemText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameCategoryBarItem.class, "isSelected", "isSelected()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameCategoryBarItem.class, "showRedPoint", "getShowRedPoint()Z", 0)};
    public final ReadWriteProperty isSelected$delegate;
    public final ReadWriteProperty itemText$delegate = c.a("");
    public final ReadWriteProperty showRedPoint$delegate;

    public GameCategoryBarItem() {
        Boolean bool = Boolean.FALSE;
        this.isSelected$delegate = c.a(bool);
        this.showRedPoint$delegate = c.a(bool);
    }

    public final boolean isSelected() {
        return ((Boolean) this.isSelected$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final void setSelected(boolean z16) {
        this.isSelected$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }
}
