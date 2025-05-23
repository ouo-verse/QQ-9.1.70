package com.qzone.proxy.personalitycomponent.model;

import com.tencent.mobileqq.util.Utils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WidgetLunarData {
    public int animal;
    public String lunar_m = "";
    public String lunar_d = "";
    public String lunar_ex = "";
    public String solar = "";
    public String week = "";

    /* renamed from: yi, reason: collision with root package name */
    public String f50991yi = "";

    /* renamed from: ji, reason: collision with root package name */
    public String f50990ji = "";
    public String yi_ex = "";
    public String ji_ex = "";
    public String chong = "";
    public String sha = "";
    public String cheng = "";
    public String zhengchong = "";
    public String taishen = "";
    public int cachetime = 0;
    public int updatetime = 0;

    public String toString() {
        return "lunar_month = " + this.lunar_m + " lunar_day = " + this.lunar_d + " yi = " + this.f50991yi + " ji = " + this.f50990ji;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof WidgetLunarData)) {
            return false;
        }
        WidgetLunarData widgetLunarData = (WidgetLunarData) obj;
        return Utils.p(widgetLunarData.lunar_m, this.lunar_m) && Utils.p(widgetLunarData.lunar_d, this.lunar_d) && Utils.p(widgetLunarData.f50991yi, this.f50991yi) && Utils.p(widgetLunarData.f50990ji, this.f50990ji);
    }
}
