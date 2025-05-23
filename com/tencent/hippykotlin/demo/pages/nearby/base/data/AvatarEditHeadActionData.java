package com.tencent.hippykotlin.demo.pages.nearby.base.data;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import v35.b;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AvatarEditHeadActionData {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AvatarEditHeadActionData.class, "avatarNormalPath", "getAvatarNormalPath()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AvatarEditHeadActionData.class, "isSelected", "isSelected()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AvatarEditHeadActionData.class, "isRecordFinish", "isRecordFinish()Z", 0)};
    public int actionId;
    public final String actionName;
    public String appearanceKey;
    public final ReadWriteProperty avatarNormalPath$delegate;
    public final int avatarSize;
    public final b boundsClipperInfo;
    public final String defaultUrl;
    public final String eventInfo;
    public final ArrayList<Integer> eventTags;
    public final ReadWriteProperty isRecordFinish$delegate;
    public final ReadWriteProperty isSelected$delegate;
    public final double maskRate;
    public final String uin;

    public AvatarEditHeadActionData() {
        this((String) null, 0, (String) null, (String) null, (String) null, 0.0d, (b) null, (ArrayList) null, (String) null, 1023);
    }

    public final String getAvatarNormalPath() {
        return (String) this.avatarNormalPath$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setSelected(boolean z16) {
        this.isSelected$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[EditAvatarData actionId:");
        m3.append(this.actionId);
        m3.append(", appearanceKey:");
        m3.append(this.appearanceKey);
        m3.append(", maskRate:");
        m3.append(this.maskRate);
        m3.append(']');
        return m3.toString();
    }

    public AvatarEditHeadActionData(String str, int i3, String str2, String str3, int i16, String str4, double d16, b bVar, ArrayList<Integer> arrayList, String str5) {
        this.uin = str;
        this.actionId = i3;
        this.actionName = str2;
        this.defaultUrl = str3;
        this.avatarSize = i16;
        this.appearanceKey = str4;
        this.maskRate = d16;
        this.boundsClipperInfo = bVar;
        this.eventTags = arrayList;
        this.eventInfo = str5;
        this.avatarNormalPath$delegate = c.a("");
        Boolean bool = Boolean.FALSE;
        this.isSelected$delegate = c.a(bool);
        this.isRecordFinish$delegate = c.a(bool);
    }

    public /* synthetic */ AvatarEditHeadActionData(String str, int i3, String str2, String str3, String str4, double d16, b bVar, ArrayList arrayList, String str5, int i16) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? -1 : i3, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : str3, (i16 & 16) != 0 ? 640 : 0, (i16 & 32) != 0 ? "" : str4, (i16 & 64) != 0 ? 0.25d : d16, (i16 & 128) != 0 ? null : bVar, (ArrayList<Integer>) ((i16 & 256) != 0 ? null : arrayList), (i16 & 512) != 0 ? "" : str5);
    }
}
