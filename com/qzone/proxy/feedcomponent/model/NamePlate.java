package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_nameplate;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* loaded from: classes39.dex */
public class NamePlate implements SmartParcelable {

    @NeedParcel
    public int nameplateid = 0;

    @NeedParcel
    public String icon = "";

    @NeedParcel
    public String jumpurl = "";

    public static NamePlate create(s_nameplate s_nameplateVar) {
        if (s_nameplateVar == null) {
            return null;
        }
        NamePlate namePlate = new NamePlate();
        namePlate.nameplateid = s_nameplateVar.nameplateid;
        namePlate.icon = s_nameplateVar.icon;
        namePlate.jumpurl = s_nameplateVar.jumpurl;
        return namePlate;
    }
}
