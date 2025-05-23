package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_gift;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellGiftInfo implements SmartParcelable {

    @NeedParcel
    public int actionType;

    @NeedParcel
    public String actionUrl;

    @NeedParcel
    public String audioBgUrl;

    @NeedParcel
    public String audioUrl;

    @NeedParcel
    public String bigGitUrl;

    @NeedParcel
    public String giftBackId;

    @NeedParcel
    public String giftDesc;

    @NeedParcel
    public String giftId;

    @NeedParcel
    public String giftName;

    @NeedParcel
    public String giftType;

    @NeedParcel
    public String smallGiftUrl;

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellGiftInfo {\n");
        if (!TextUtils.isEmpty(this.giftName)) {
            sb5.append("giftName: ");
            sb5.append(this.giftName);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.giftType)) {
            sb5.append("giftType: ");
            sb5.append(this.giftType);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.giftId)) {
            sb5.append("giftId: ");
            sb5.append(this.giftId);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.giftDesc)) {
            sb5.append("giftDesc: ");
            sb5.append(this.giftDesc);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.giftBackId)) {
            sb5.append("giftBackId: ");
            sb5.append(this.giftBackId);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.smallGiftUrl)) {
            sb5.append("smallGiftUrl: ");
            sb5.append(this.smallGiftUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.bigGitUrl)) {
            sb5.append("bigGitUrl: ");
            sb5.append(this.bigGitUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.audioUrl)) {
            sb5.append("audioUrl: ");
            sb5.append(this.audioUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.audioBgUrl)) {
            sb5.append("audioBgUrl: ");
            sb5.append(this.audioBgUrl);
            sb5.append("\n");
        }
        sb5.append("}");
        return sb5.toString();
    }

    public static CellGiftInfo create(l lVar) {
        if (lVar == null || lVar.f50380u == null) {
            return null;
        }
        CellGiftInfo cellGiftInfo = new CellGiftInfo();
        Map<Integer, String> map = lVar.f50380u.gifturl;
        if (map != null) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                int intValue = entry.getKey().intValue();
                if (intValue == 1) {
                    cellGiftInfo.smallGiftUrl = entry.getValue();
                } else if (intValue == 2) {
                    cellGiftInfo.bigGitUrl = entry.getValue();
                } else if (intValue == 3) {
                    cellGiftInfo.audioUrl = entry.getValue();
                } else if (intValue == 4) {
                    cellGiftInfo.audioBgUrl = entry.getValue();
                }
            }
        }
        cell_gift cell_giftVar = lVar.f50380u;
        cellGiftInfo.giftBackId = cell_giftVar.giftbackid;
        cellGiftInfo.giftDesc = cell_giftVar.giftdesc;
        cellGiftInfo.giftId = cell_giftVar.giftid;
        cellGiftInfo.giftName = cell_giftVar.giftname;
        cellGiftInfo.giftType = cell_giftVar.gifttype;
        cellGiftInfo.actionUrl = cell_giftVar.actionurl;
        cellGiftInfo.actionType = cell_giftVar.giftactiontype;
        return cellGiftInfo;
    }
}
