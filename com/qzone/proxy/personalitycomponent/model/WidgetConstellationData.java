package com.qzone.proxy.personalitycomponent.model;

import com.tencent.mobileqq.util.Utils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WidgetConstellationData {
    public static final int ENUM_CONS_AQUARIUS = 10;
    public static final int ENUM_CONS_ARIES = 0;
    public static final int ENUM_CONS_CANCER = 3;
    public static final int ENUM_CONS_CAPRICORNUS = 9;
    public static final int ENUM_CONS_GEMINI = 2;
    public static final int ENUM_CONS_LEO = 4;
    public static final int ENUM_CONS_LIBRA = 6;
    public static final int ENUM_CONS_PISCES = 11;
    public static final int ENUM_CONS_SAGITTARIUS = 8;
    public static final int ENUM_CONS_SCORPIO = 7;
    public static final int ENUM_CONS_TAURUS = 1;
    public static final int ENUM_CONS_VIRGO = 5;
    public String bad;
    public int constellationId;
    public String desc;
    public String good;
    public String interval;
    public String name;
    public String color = "";
    public String num = "";
    public int love = 0;
    public int work = 0;
    public int money = 0;
    public int health = 0;
    public String date = "";
    public int lucky = 0;
    public int cachetime = 0;
    public int updatetime = 0;

    public String toString() {
        return " ownConstellation = " + this.name + " goodConstellation = " + this.good + " badConstellation = " + this.bad + " luck = " + this.lucky;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof WidgetConstellationData)) {
            return false;
        }
        WidgetConstellationData widgetConstellationData = (WidgetConstellationData) obj;
        return widgetConstellationData.constellationId == this.constellationId && widgetConstellationData.lucky == this.lucky && Utils.p(widgetConstellationData.name, this.name) && Utils.p(widgetConstellationData.good, this.good) && Utils.p(widgetConstellationData.bad, this.bad);
    }
}
