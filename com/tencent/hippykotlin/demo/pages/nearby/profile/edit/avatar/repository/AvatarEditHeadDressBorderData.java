package com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.repository;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AvatarEditHeadDressBorderData {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AvatarEditHeadDressBorderData.class, "isSelected", "isSelected()Z", 0)};
    public final String dressId;
    public final int dressStatus;
    public final ReadWriteProperty isSelected$delegate;
    public final String name;
    public final String showPic;
    public final String url;

    public AvatarEditHeadDressBorderData() {
        this(null, null, null, null, 0, 31, null);
    }

    public final void setSelected(boolean z16) {
        this.isSelected$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }

    public AvatarEditHeadDressBorderData(String str, String str2, String str3, String str4, int i3) {
        this.dressId = str;
        this.name = str2;
        this.showPic = str3;
        this.url = str4;
        this.dressStatus = i3;
        this.isSelected$delegate = c.a(Boolean.FALSE);
    }

    public /* synthetic */ AvatarEditHeadDressBorderData(String str, String str2, String str3, String str4, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", 0);
    }
}
