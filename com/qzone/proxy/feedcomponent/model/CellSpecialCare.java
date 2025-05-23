package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_special_care;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellSpecialCare implements SmartParcelable {

    @NeedParcel
    public int commentCnt;

    @NeedParcel
    public PictureUrl iconUrlAfterClick;

    @NeedParcel
    public PictureUrl iconUrlBeforeClick;

    @NeedParcel
    public int intimacy;

    @NeedParcel
    public boolean isSpecialCare;

    @NeedParcel
    public int likeCnt;

    @NeedParcel
    public int rankpercent;

    @NeedParcel
    public String relationContent;

    @NeedParcel
    public User userInfo;

    @NeedParcel
    public int visitCnt;

    @NeedParcel
    public String descriptionBeforeClick = "";

    @NeedParcel
    public String descriptionAfterClick = "";

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellSpecialCare {\n");
        sb5.append("userInfo: ");
        sb5.append(this.userInfo.toString());
        sb5.append("\n");
        sb5.append("intimacy: ");
        sb5.append(this.intimacy);
        sb5.append("\n");
        sb5.append("rankpercent: ");
        sb5.append(this.rankpercent);
        sb5.append("\n");
        sb5.append("iconUrlBeforeClick: ");
        sb5.append(this.iconUrlBeforeClick.toString());
        sb5.append("\n");
        sb5.append("iconUrlAfterClick: ");
        sb5.append(this.iconUrlAfterClick.toString());
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.descriptionBeforeClick)) {
            sb5.append("desc: ");
            sb5.append(this.descriptionBeforeClick);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.descriptionAfterClick)) {
            sb5.append("desc: ");
            sb5.append(this.descriptionAfterClick);
            sb5.append("\n");
        }
        sb5.append("isSpecialCare: ");
        sb5.append(this.isSpecialCare);
        sb5.append("\n");
        sb5.append("visitCnt: ");
        sb5.append(this.visitCnt);
        sb5.append("\n");
        sb5.append("likeCnt: ");
        sb5.append(this.likeCnt);
        sb5.append("\n");
        sb5.append("commentCnt: ");
        sb5.append(this.commentCnt);
        sb5.append("\n");
        sb5.append("relationContent: ");
        sb5.append(this.relationContent);
        sb5.append("\n");
        sb5.append("}");
        return sb5.toString();
    }

    public static CellSpecialCare create(l lVar) {
        if (lVar == null || lVar.I == null) {
            return null;
        }
        CellSpecialCare cellSpecialCare = new CellSpecialCare();
        User q16 = com.qzone.proxy.feedcomponent.util.e.q(lVar.I.userinfo);
        com.qzone.proxy.feedcomponent.util.e.c(lVar, q16);
        cellSpecialCare.userInfo = q16;
        cell_special_care cell_special_careVar = lVar.I;
        cellSpecialCare.intimacy = cell_special_careVar.intimacy;
        cellSpecialCare.rankpercent = cell_special_careVar.rankpercent;
        cellSpecialCare.iconUrlBeforeClick = com.qzone.proxy.feedcomponent.util.e.n(cell_special_careVar.icon_before_click);
        cellSpecialCare.iconUrlAfterClick = com.qzone.proxy.feedcomponent.util.e.n(lVar.I.icon_after_click);
        cell_special_care cell_special_careVar2 = lVar.I;
        cellSpecialCare.descriptionBeforeClick = cell_special_careVar2.desc_before_click;
        cellSpecialCare.descriptionAfterClick = cell_special_careVar2.desc_after_click;
        cellSpecialCare.visitCnt = cell_special_careVar2.visit_count;
        cellSpecialCare.likeCnt = cell_special_careVar2.like_count;
        cellSpecialCare.commentCnt = cell_special_careVar2.comment_count;
        cellSpecialCare.relationContent = cell_special_careVar2.relation_content;
        return cellSpecialCare;
    }
}
