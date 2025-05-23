package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_recomm_action;
import NS_MOBILE_FEEDS.s_button;
import NS_MOBILE_FEEDS.s_rank;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellRecommAction implements SmartParcelable {

    @NeedParcel
    public int actionType;

    @NeedParcel
    public String add_group_url;

    @NeedParcel
    public int advPos;

    @NeedParcel
    public int allcount;

    @NeedParcel
    public String alternate_ad_identification;

    @NeedParcel
    public int btnType;

    @NeedParcel
    public int buttonActionType;

    @NeedParcel
    public int buttonStyle;

    @NeedParcel
    public String buttonText;

    @NeedParcel
    public String buttonUrl;

    @NeedParcel
    public String channel;

    @NeedParcel
    public int countDownTimer;

    @NeedParcel
    public String currency_pass_field;

    @NeedParcel
    public int dest_type;

    @NeedParcel
    public String dest_url;

    @NeedParcel
    public int detailActionType;

    @NeedParcel
    public String detailText;

    @NeedParcel
    public String detailUrl;

    @NeedParcel
    public Map<Integer, String> extendInfo = null;

    @NeedParcel
    public int hasFollowed;

    @NeedParcel
    public String installed_buttontxt;

    @NeedParcel
    public String interact_left_text;

    @NeedParcel
    public int isHideActionArea;

    @NeedParcel
    public int isReport;

    @NeedParcel
    public s_button left_bottom_button;

    @NeedParcel
    public int multiAdvOffset;

    @NeedParcel
    public int product_type;

    @NeedParcel
    public long productid;

    @NeedParcel
    public int rankCurrentWithHalfStar;

    @NeedParcel
    public int rankMax;

    @NeedParcel
    public ArrayList<User> relation_chain;

    @NeedParcel
    public int relation_total_number;

    @NeedParcel
    public String remark;

    @NeedParcel
    public String reportUrl;

    /* renamed from: rl, reason: collision with root package name */
    @NeedParcel
    public String f50232rl;

    @NeedParcel
    public int style;

    @NeedParcel
    public int templ_layout;

    @NeedParcel
    public String tipsIconUrl;

    @NeedParcel
    public ArrayList<User> userList;

    @NeedParcel
    public String via;

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellRecommAction {\n");
        sb5.append("rankMax: ");
        sb5.append(this.rankMax);
        sb5.append("\n");
        sb5.append("rankCurrentWithHalfStar: ");
        sb5.append(this.rankCurrentWithHalfStar);
        sb5.append("\n");
        if (this.relation_chain != null) {
            for (int i3 = 0; i3 < this.relation_chain.size(); i3++) {
                sb5.append("relation_chain[");
                sb5.append(i3);
                sb5.append("]: ");
                sb5.append(this.relation_chain.get(i3).toString());
                sb5.append("\n");
            }
            sb5.append("relation_total_number: ");
            sb5.append(this.relation_total_number);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.remark)) {
            sb5.append("remark: ");
            sb5.append(this.remark);
            sb5.append("\n");
        }
        if (this.userList != null) {
            for (int i16 = 0; i16 < this.userList.size(); i16++) {
                sb5.append("userList[");
                sb5.append(i16);
                sb5.append("]: ");
                sb5.append(this.userList.get(i16).toString());
                sb5.append("\n");
            }
        }
        sb5.append("actionType: ");
        sb5.append(this.actionType);
        sb5.append("\n");
        sb5.append("btnType: ");
        sb5.append(this.btnType);
        sb5.append("\n");
        sb5.append("isReport: ");
        sb5.append(this.isReport);
        sb5.append("\n");
        sb5.append("reportUrl: ");
        sb5.append(this.reportUrl);
        sb5.append("\n");
        sb5.append("allcount: ");
        sb5.append(this.allcount);
        sb5.append("\n");
        sb5.append("hasFollowed: ");
        sb5.append(this.hasFollowed);
        sb5.append("\n");
        sb5.append("buttonText: ");
        sb5.append(this.buttonText);
        sb5.append("\n");
        sb5.append("buttonActionType: ");
        sb5.append(this.buttonActionType);
        sb5.append("\n");
        sb5.append("isHideActionArea: ");
        sb5.append(this.isHideActionArea);
        sb5.append("\n");
        sb5.append("buttonUrl: ");
        sb5.append(this.buttonUrl);
        sb5.append("\n");
        sb5.append("buttonStyle: ");
        sb5.append(this.buttonStyle);
        sb5.append("\n");
        sb5.append("detailText: ");
        sb5.append(this.detailText);
        sb5.append("\n");
        sb5.append("detailActionType: ");
        sb5.append(this.detailActionType);
        sb5.append("\n");
        sb5.append("detailUrl: ");
        sb5.append(this.detailUrl);
        sb5.append("\n");
        sb5.append("advPos: ");
        sb5.append(this.advPos);
        sb5.append("\n");
        sb5.append("multiAdvOffset: ");
        sb5.append(this.multiAdvOffset);
        sb5.append("\n");
        sb5.append("countDownTimer: ");
        sb5.append(this.countDownTimer);
        sb5.append("\n");
        sb5.append("productid: ");
        sb5.append(this.productid);
        sb5.append("\n");
        sb5.append("dest_type: ");
        sb5.append(this.dest_type);
        sb5.append("\n");
        sb5.append("product_type: ");
        sb5.append(this.product_type);
        sb5.append("\n");
        sb5.append("dest_url: ");
        sb5.append(this.dest_url);
        sb5.append("\n");
        sb5.append("rl: ");
        sb5.append(this.f50232rl);
        sb5.append("\n");
        sb5.append("add_group_url: ");
        sb5.append(this.add_group_url);
        sb5.append("\n");
        sb5.append("}");
        return sb5.toString();
    }

    public static CellRecommAction create(l lVar) {
        if (lVar == null || lVar.C == null) {
            return null;
        }
        CellRecommAction cellRecommAction = new CellRecommAction();
        cell_recomm_action cell_recomm_actionVar = lVar.C;
        s_rank s_rankVar = cell_recomm_actionVar.s_app_rank;
        cellRecommAction.rankMax = s_rankVar.max;
        cellRecommAction.rankCurrentWithHalfStar = s_rankVar.half_star_num;
        if (cell_recomm_actionVar.relation_chain != null) {
            cellRecommAction.relation_chain = new ArrayList<>();
            int size = lVar.C.relation_chain.size();
            for (int i3 = 0; i3 < size; i3++) {
                User q16 = com.qzone.proxy.feedcomponent.util.e.q(lVar.C.relation_chain.get(i3));
                com.qzone.proxy.feedcomponent.util.e.c(lVar, q16);
                cellRecommAction.relation_chain.add(q16);
            }
            cellRecommAction.relation_total_number = lVar.C.relation_total_number;
        } else {
            cellRecommAction.relation_total_number = 0;
        }
        cell_recomm_action cell_recomm_actionVar2 = lVar.C;
        cellRecommAction.remark = cell_recomm_actionVar2.remark;
        if (cell_recomm_actionVar2.userlist != null) {
            cellRecommAction.userList = new ArrayList<>();
            int size2 = lVar.C.userlist.size();
            for (int i16 = 0; i16 < size2; i16++) {
                User q17 = com.qzone.proxy.feedcomponent.util.e.q(lVar.C.userlist.get(i16));
                com.qzone.proxy.feedcomponent.util.e.c(lVar, q17);
                cellRecommAction.userList.add(q17);
            }
        }
        cell_recomm_action cell_recomm_actionVar3 = lVar.C;
        cellRecommAction.actionType = cell_recomm_actionVar3.actiontype;
        cellRecommAction.btnType = cell_recomm_actionVar3.btn_type;
        cellRecommAction.isReport = cell_recomm_actionVar3.is_report;
        cellRecommAction.reportUrl = cell_recomm_actionVar3.report_url;
        cellRecommAction.allcount = cell_recomm_actionVar3.allcount;
        cellRecommAction.buttonText = cell_recomm_actionVar3.button_text;
        cellRecommAction.buttonActionType = cell_recomm_actionVar3.button_actiontype;
        cellRecommAction.isHideActionArea = cell_recomm_actionVar3.is_hide_action_area;
        cellRecommAction.buttonUrl = cell_recomm_actionVar3.button_url;
        cellRecommAction.buttonStyle = cell_recomm_actionVar3.button_style;
        cellRecommAction.detailText = cell_recomm_actionVar3.detail_text;
        cellRecommAction.detailActionType = cell_recomm_actionVar3.detail_actiontype;
        cellRecommAction.detailUrl = cell_recomm_actionVar3.detail_url;
        cellRecommAction.tipsIconUrl = cell_recomm_actionVar3.tips_icon;
        cellRecommAction.advPos = cell_recomm_actionVar3.adv_pos;
        cellRecommAction.multiAdvOffset = cell_recomm_actionVar3.multi_adv_offset;
        cellRecommAction.interact_left_text = cell_recomm_actionVar3.interact_left_text;
        cellRecommAction.installed_buttontxt = cell_recomm_actionVar3.installed_buttontxt;
        cellRecommAction.alternate_ad_identification = cell_recomm_actionVar3.alternate_ad_identification;
        cellRecommAction.countDownTimer = cell_recomm_actionVar3.count_down_timer;
        cellRecommAction.extendInfo = cell_recomm_actionVar3.extend_info;
        cellRecommAction.left_bottom_button = cell_recomm_actionVar3.left_bottom_button;
        cellRecommAction.currency_pass_field = cell_recomm_actionVar3.currency_pass_field;
        cellRecommAction.via = cell_recomm_actionVar3.via;
        cellRecommAction.channel = cell_recomm_actionVar3.channel;
        cellRecommAction.productid = cell_recomm_actionVar3.productid;
        cellRecommAction.templ_layout = cell_recomm_actionVar3.templ_layout;
        cellRecommAction.dest_type = cell_recomm_actionVar3.dest_type;
        cellRecommAction.product_type = cell_recomm_actionVar3.product_type;
        cellRecommAction.dest_url = cell_recomm_actionVar3.dest_url;
        cellRecommAction.f50232rl = cell_recomm_actionVar3.f24985rl;
        cellRecommAction.style = cell_recomm_actionVar3.style;
        cellRecommAction.add_group_url = cell_recomm_actionVar3.add_group_url;
        return cellRecommAction;
    }
}
