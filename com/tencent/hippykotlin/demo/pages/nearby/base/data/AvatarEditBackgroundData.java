package com.tencent.hippykotlin.demo.pages.nearby.base.data;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AvatarEditBackgroundData {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AvatarEditBackgroundData.class, "isSelected", "isSelected()Z", 0)};

    /* renamed from: id, reason: collision with root package name */
    public final int f114206id;
    public final ReadWriteProperty isSelected$delegate;
    public final String url;

    public AvatarEditBackgroundData() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public final void setSelected(boolean z16) {
        this.isSelected$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }

    public AvatarEditBackgroundData(int i3, String str) {
        this.f114206id = i3;
        this.url = str;
        this.isSelected$delegate = c.a(Boolean.FALSE);
    }

    public /* synthetic */ AvatarEditBackgroundData(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(-1, "");
    }
}
