package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_remark;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellRemarkInfo implements SmartParcelable {
    public static final String REMARK_TAB = "remark";
    public static final String SHOOTINFO_TAB = "shootinfo";

    @NeedParcel
    public int action_type;

    @NeedParcel
    public String action_url = "";
    public Integer integerUnikeyRemark;
    public Integer integerUnikeyShoot;

    @NeedParcel
    public String remark;

    @NeedParcel
    public String remark_down;

    @NeedParcel
    public String remark_up;

    @NeedParcel
    public ShootInfo shoot_info;

    @NeedParcel
    public int time;
    public String unikeyRemark;
    public String unikeyShoot;

    public String getJumpUrl() {
        Map<String, String> map;
        ShootInfo shootInfo = this.shoot_info;
        if (shootInfo == null || (map = shootInfo.extendinfo) == null) {
            return null;
        }
        String str = map.get("jump_type");
        String str2 = this.shoot_info.extendinfo.get("jump_id");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return "https://m.qzone.com/urljump/urljump?jump_type=" + str + "&jump_id=" + str2;
    }

    public String getRemarkDisplayStr() {
        String str = "";
        if (this.remark == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.remark);
        int i3 = this.time;
        if (i3 > 0) {
            str = com.qzone.proxy.feedcomponent.util.c.d(i3);
        }
        sb5.append(str);
        return sb5.toString();
    }

    public String getRemarkKey() {
        return this.unikeyRemark;
    }

    public String getShootInfoString() {
        ShootInfo shootInfo = this.shoot_info;
        if (shootInfo == null) {
            return null;
        }
        String lbsJumpInfo = getLbsJumpInfo(shootInfo);
        return !TextUtils.isEmpty(lbsJumpInfo) ? lbsJumpInfo : this.shoot_info.getShootInfoString();
    }

    public String getShootInfoStringOrig() {
        ShootInfo shootInfo = this.shoot_info;
        if (shootInfo == null) {
            return null;
        }
        return shootInfo.getShootInfoString();
    }

    public String getShootKey() {
        return this.unikeyShoot;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.remark) && TextUtils.isEmpty(this.remark_up) && TextUtils.isEmpty(this.remark_down) && this.time == 0 && this.shoot_info == null;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellRemarkInfo {\n");
        if (!TextUtils.isEmpty(this.remark)) {
            sb5.append("remark: ");
            sb5.append(this.remark);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.remark_up)) {
            sb5.append("remark_up: ");
            sb5.append(this.remark_up);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.remark_down)) {
            sb5.append("remark_down: ");
            sb5.append(this.remark_down);
            sb5.append("\n");
        }
        sb5.append("time: ");
        sb5.append(this.time);
        sb5.append(", ");
        ShootInfo shootInfo = this.shoot_info;
        if (shootInfo != null && !TextUtils.isEmpty(shootInfo.getShootInfoString())) {
            sb5.append("shoot_info: ");
            sb5.append(this.shoot_info.getShootInfoString());
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.unikeyRemark)) {
            sb5.append("unikeyRemark: ");
            sb5.append(this.unikeyRemark);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.unikeyShoot)) {
            sb5.append("unikeyShoot: ");
            sb5.append(this.unikeyShoot);
            sb5.append("\n");
        }
        sb5.append("}");
        return sb5.toString();
    }

    public static CellRemarkInfo create(l lVar) {
        if (lVar == null || lVar.f50360k == null) {
            return null;
        }
        CellRemarkInfo cellRemarkInfo = new CellRemarkInfo();
        cell_remark cell_remarkVar = lVar.f50360k;
        cellRemarkInfo.remark = cell_remarkVar.remark;
        cellRemarkInfo.remark_up = cell_remarkVar.remark_up;
        cellRemarkInfo.remark_down = cell_remarkVar.remark_down;
        cellRemarkInfo.time = cell_remarkVar.time;
        cellRemarkInfo.shoot_info = ShootInfo.create(cell_remarkVar.shoot_info);
        cell_remark cell_remarkVar2 = lVar.f50360k;
        cellRemarkInfo.action_type = cell_remarkVar2.action_type;
        cellRemarkInfo.action_url = cell_remarkVar2.action_url;
        return cellRemarkInfo;
    }

    String getLbsJumpInfo(ShootInfo shootInfo) {
        String str;
        if (shootInfo != null && shootInfo.extendinfo != null && !TextUtils.isEmpty(shootInfo.getShootInfoString())) {
            String str2 = shootInfo.extendinfo.get("jump_type");
            String str3 = shootInfo.extendinfo.get("jump_id");
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                str = null;
            } else {
                str = "https://m.qzone.com/urljump/urljump?jump_type=" + str2 + "&jump_id=" + str3;
            }
            if (!TextUtils.isEmpty(str)) {
                return "{url:" + str + ",text:" + shootInfo.getShootInfoString() + "}";
            }
        }
        return null;
    }
}
