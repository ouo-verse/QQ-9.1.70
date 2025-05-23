package com.qzone.proxy.feedcomponent.model;

import NS_CAMPUS_INTERLOCUTION_FEEDS.share_detail_item;
import NS_MOBILE_FEEDS.cell_share_card;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ImageUrl;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellShareCard implements SmartParcelable {
    public String contentAreaKey;

    @NeedParcel
    public ImageUrl imageUrl;
    public Integer integerContentAreaKey;

    @NeedParcel
    public String portrait;

    @NeedParcel
    public ImageUrl portraitImageUrl;

    @NeedParcel
    public String share_content;

    @NeedParcel
    public long userType;

    @NeedParcel
    public int action_type = 0;

    @NeedParcel
    public String action_url = "";

    @NeedParcel
    public int type = 0;

    @NeedParcel
    public String pic_url = "";

    @NeedParcel
    public long uin = 0;

    @NeedParcel
    public String nick = "";

    @NeedParcel
    public String optype = "";

    @NeedParcel
    public String content = "";

    @NeedParcel
    public int content_line = -1;

    @NeedParcel
    public int content_TextSize = 22;

    @NeedParcel
    public long visit_num = 0;

    @NeedParcel
    public long answer_num = 0;

    @NeedParcel
    public String school_name = "";

    @NeedParcel
    public String module_name = "";

    public String getPicUrl() {
        return this.pic_url;
    }

    public static CellShareCard create(l lVar) {
        cell_share_card cell_share_cardVar;
        if (lVar != null && (cell_share_cardVar = lVar.f50369o0) != null && cell_share_cardVar.content_buf != null) {
            try {
                share_detail_item share_detail_itemVar = (share_detail_item) com.qzone.adapter.feedcomponent.i.H().u(share_detail_item.class, lVar.f50369o0.content_buf);
                if (share_detail_itemVar == null) {
                    return null;
                }
                CellShareCard cellShareCard = new CellShareCard();
                cellShareCard.action_type = share_detail_itemVar.action_type;
                cellShareCard.action_url = share_detail_itemVar.action_url;
                cellShareCard.type = share_detail_itemVar.type;
                String str = share_detail_itemVar.pic_url;
                cellShareCard.pic_url = str;
                cellShareCard.imageUrl = PictureUrl.calculateImageUrl(str);
                cellShareCard.uin = share_detail_itemVar.uin;
                cellShareCard.nick = share_detail_itemVar.nick;
                cellShareCard.optype = share_detail_itemVar.optype;
                cellShareCard.content = share_detail_itemVar.content;
                cellShareCard.visit_num = share_detail_itemVar.visit_num;
                cellShareCard.answer_num = share_detail_itemVar.answer_num;
                cellShareCard.school_name = share_detail_itemVar.school_name;
                cellShareCard.module_name = share_detail_itemVar.module_name;
                String str2 = share_detail_itemVar.portrait;
                cellShareCard.portrait = str2;
                cellShareCard.portraitImageUrl = PictureUrl.calculateImageUrl(str2);
                cellShareCard.userType = share_detail_itemVar.user_type;
                cellShareCard.share_content = share_detail_itemVar.share_content;
                return cellShareCard;
            } catch (Exception e16) {
                com.qzone.proxy.feedcomponent.b.d("Feed", "decode CellShareCard error!", e16);
            }
        }
        return null;
    }
}
