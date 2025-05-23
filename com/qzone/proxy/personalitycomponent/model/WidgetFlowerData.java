package com.qzone.proxy.personalitycomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.util.Utils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WidgetFlowerData implements SmartParcelable {

    @NeedParcel
    public String icon;

    @NeedParcel
    public int love;

    @NeedParcel
    public int loveMax;

    @NeedParcel
    public int nutrition;

    @NeedParcel
    public int nutritionMax;

    @NeedParcel
    public int sunshine;

    @NeedParcel
    public int sunshineMax;

    @NeedParcel
    public int water;

    @NeedParcel
    public int waterMax;

    @NeedParcel
    public int cachetime = 0;

    @NeedParcel
    public int updatetime = 0;

    public String toString() {
        return " sunshine = " + this.sunshine + " water = " + this.water + " love = " + this.love + " nutrition = " + this.nutrition;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof WidgetFlowerData)) {
            return false;
        }
        WidgetFlowerData widgetFlowerData = (WidgetFlowerData) obj;
        return widgetFlowerData.sunshine == this.sunshine && widgetFlowerData.water == this.water && widgetFlowerData.love == this.love && widgetFlowerData.nutrition == this.nutrition && Utils.p(widgetFlowerData.icon, this.icon);
    }
}
