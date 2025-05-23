package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_refer;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellReferInfo implements SmartParcelable {
    public static final String REFER_TAB = "referinfo";

    @NeedParcel
    public int actionType;

    @NeedParcel
    public String actionUrl;

    @NeedParcel
    public String appName;

    @NeedParcel
    public String appNameReadableStr;

    @NeedParcel
    public String appid;

    @NeedParcel
    public String downloadUrl;

    @NeedParcel
    public String icon;

    @NeedParcel
    public String iconToken;
    public Integer integerUniKey;
    public Integer integerUniKeyTitle;

    @NeedParcel
    public boolean showLinkColor;
    public String uniKey;
    public String uniKeyTitle;
    public String image = "";

    @NeedParcel
    public String textColor = "";

    @NeedParcel
    public String nightTextColor = "";

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellReferInfo {\n");
        if (!TextUtils.isEmpty(this.appName)) {
            sb5.append("appName: ");
            sb5.append(this.appName);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.actionUrl)) {
            sb5.append("actionUrl: ");
            sb5.append(this.actionUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.downloadUrl)) {
            sb5.append("downloadUrl: ");
            sb5.append(this.downloadUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.appid)) {
            sb5.append("appid: ");
            sb5.append(this.appid);
            sb5.append("\n");
        }
        sb5.append("actionType");
        sb5.append(this.actionType);
        sb5.append("\n");
        sb5.append("showLinkColor");
        sb5.append(this.showLinkColor);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.uniKey)) {
            sb5.append("uniKey: ");
            sb5.append(this.uniKey);
            sb5.append("\n");
        }
        sb5.append("}");
        return sb5.toString();
    }

    public static CellReferInfo create(l lVar) {
        if (lVar == null || lVar.f50386x == null) {
            return null;
        }
        CellReferInfo cellReferInfo = new CellReferInfo();
        String str = lVar.f50386x.appname;
        cellReferInfo.appName = str;
        if (str != null) {
            cellReferInfo.appNameReadableStr = str.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", "");
        }
        cell_refer cell_referVar = lVar.f50386x;
        cellReferInfo.actionUrl = cell_referVar.actionurl;
        cellReferInfo.downloadUrl = cell_referVar.downloadurl;
        cellReferInfo.appid = cell_referVar.appid;
        cellReferInfo.actionType = cell_referVar.actiontype;
        cellReferInfo.icon = cell_referVar.icon;
        cellReferInfo.showLinkColor = cell_referVar.show_link_color;
        cellReferInfo.iconToken = cell_referVar.icon_token;
        cellReferInfo.textColor = cell_referVar.text_color;
        cellReferInfo.nightTextColor = cell_referVar.night_text_color;
        return cellReferInfo;
    }
}
