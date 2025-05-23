package com.qzone.album.data.model;

import NS_MOBILE_MAIN_PAGE.s_red_info;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RedInfo implements SmartParcelable {

    @NeedParcel
    public String desc;

    @NeedParcel
    public String logo;

    @NeedParcel
    public String summary;

    @NeedParcel
    public long uIsNew;

    @NeedParcel
    public long uin;

    public static RedInfo createFrom(s_red_info s_red_infoVar) {
        RedInfo redInfo = new RedInfo();
        redInfo.logo = s_red_infoVar.logo;
        redInfo.summary = s_red_infoVar.summary;
        redInfo.desc = s_red_infoVar.desc;
        redInfo.uIsNew = s_red_infoVar.uIsNew;
        redInfo.uin = s_red_infoVar.uin;
        return redInfo;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("RedInfo {\n");
        if (!TextUtils.isEmpty(this.logo)) {
            sb5.append("logo: ");
            sb5.append(this.logo);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.summary)) {
            sb5.append("summary: ");
            sb5.append(this.summary);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.desc)) {
            sb5.append("desc: ");
            sb5.append(this.desc);
            sb5.append("\n");
        }
        sb5.append("uIsNew: ");
        sb5.append(this.uIsNew);
        sb5.append("\n");
        sb5.append("uin: ");
        sb5.append(this.uin);
        sb5.append("}");
        return sb5.toString();
    }
}
