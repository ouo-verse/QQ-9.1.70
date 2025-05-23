package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_gps;
import NS_MOBILE_FEEDS.s_shoot_info;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ShootInfo implements SmartParcelable {

    @NeedParcel
    public int altitude;
    String cachedShootInfo;

    @NeedParcel
    public Map<String, String> extendinfo = null;

    @NeedParcel
    public String iconToken;

    @NeedParcel
    public int latitude;

    @NeedParcel
    public int longitude;

    @NeedParcel
    public String shoot_location;

    @NeedParcel
    public long shoot_time;

    public static String getShootDateCuttedString(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j3));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(System.currentTimeMillis()));
        if (calendar.get(1) == calendar2.get(1)) {
            return new SimpleDateFormat("MM\u6708dd\u65e5").format(new Date(j3));
        }
        return new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5").format(new Date(j3));
    }

    public static String getShootDateString(long j3) {
        return new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5").format(new Date(j3));
    }

    public String getShootInfoString() {
        if (this.shoot_time == 0 || TextUtils.isEmpty(this.shoot_location)) {
            return null;
        }
        if (this.cachedShootInfo == null) {
            this.cachedShootInfo = this.shoot_location + " \u62cd\u6444\u4e8e" + getShootDateCuttedString(this.shoot_time);
        }
        return this.cachedShootInfo;
    }

    public static ShootInfo create(s_shoot_info s_shoot_infoVar) {
        if (s_shoot_infoVar == null || s_shoot_infoVar.shoot_gps == null) {
            return null;
        }
        ShootInfo shootInfo = new ShootInfo();
        s_gps s_gpsVar = s_shoot_infoVar.shoot_gps;
        shootInfo.latitude = s_gpsVar.latitude;
        shootInfo.longitude = s_gpsVar.longitude;
        shootInfo.altitude = s_gpsVar.altitude;
        shootInfo.shoot_location = s_shoot_infoVar.shoot_location;
        shootInfo.shoot_time = s_shoot_infoVar.shoot_time * 1000;
        shootInfo.extendinfo = s_shoot_infoVar.extendinfo;
        shootInfo.iconToken = s_shoot_infoVar.icon_token;
        return shootInfo;
    }
}
