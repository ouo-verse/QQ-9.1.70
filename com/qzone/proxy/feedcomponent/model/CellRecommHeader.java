package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_recomm_header;
import NS_MOBILE_FEEDS.s_button;
import NS_MOBILE_FEEDS.s_picurl;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.net.URLEncoder;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellRecommHeader implements SmartParcelable {

    @NeedParcel
    public byte btnType;

    @NeedParcel
    public String customIconUrl;
    public String desLeftTitle;

    @NeedParcel
    public int icon_height;

    @NeedParcel
    public int icon_width;

    @NeedParcel
    public String leftTitle;

    @NeedParcel
    public s_button left_top_button;

    @NeedParcel
    public PictureUrl rightBgPic;

    @NeedParcel
    public String rightTitle;

    @NeedParcel
    public String desc = "";
    public Map<String, s_picurl> mapCoverUrl = null;

    @NeedParcel
    public long recomm_uin = 0;

    @NeedParcel
    public String action_url = "";

    public void calDesLeftTitle() {
        String str;
        int i3;
        String encode = TextUtils.isEmpty(this.customIconUrl) ? null : URLEncoder.encode(this.customIconUrl);
        int density = (int) (FeedGlobalEnv.g().getDensity() * 11.0f);
        int i16 = (this.customIconUrl == null || (i3 = this.icon_height) == 0) ? 0 : (this.icon_width * density) / i3;
        if (encode == null) {
            str = this.leftTitle;
        } else {
            str = "{img:" + encode + ",w:" + i16 + ",h:" + density + "} " + this.leftTitle;
        }
        this.desLeftTitle = str;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellRecommHeader {\n");
        if (!TextUtils.isEmpty(this.leftTitle)) {
            sb5.append("leftTitle: ");
            sb5.append(this.leftTitle);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.rightTitle)) {
            sb5.append("rightTitle: ");
            sb5.append(this.rightTitle);
            sb5.append(", ");
        }
        sb5.append("btnType: ");
        sb5.append((int) this.btnType);
        sb5.append(", ");
        if (!TextUtils.isEmpty(this.customIconUrl)) {
            sb5.append("customIconUrl: ");
            sb5.append(this.customIconUrl);
            sb5.append(", ");
        }
        sb5.append("icon_width: ");
        sb5.append(this.icon_width);
        sb5.append(", ");
        sb5.append("icon_height: ");
        sb5.append(this.icon_height);
        sb5.append(", ");
        if (!TextUtils.isEmpty(this.desc)) {
            sb5.append("desc: ");
            sb5.append(this.desc);
            sb5.append(", ");
        }
        sb5.append("}");
        return sb5.toString();
    }

    public static CellRecommHeader create(l lVar) {
        if (lVar == null || lVar.B == null) {
            return null;
        }
        CellRecommHeader cellRecommHeader = new CellRecommHeader();
        cell_recomm_header cell_recomm_headerVar = lVar.B;
        cellRecommHeader.leftTitle = cell_recomm_headerVar.left_title;
        cellRecommHeader.rightTitle = cell_recomm_headerVar.right_title;
        cellRecommHeader.btnType = cell_recomm_headerVar.btn_type;
        cellRecommHeader.customIconUrl = cell_recomm_headerVar.custom_icon;
        cellRecommHeader.icon_width = cell_recomm_headerVar.icon_width;
        cellRecommHeader.icon_height = cell_recomm_headerVar.icon_height;
        cellRecommHeader.desc = cell_recomm_headerVar.desc;
        cellRecommHeader.mapCoverUrl = cell_recomm_headerVar.mapCoverUrl;
        cellRecommHeader.recomm_uin = cell_recomm_headerVar.recomm_uin;
        cellRecommHeader.action_url = cell_recomm_headerVar.action_url;
        cellRecommHeader.left_top_button = cell_recomm_headerVar.left_top_button;
        cellRecommHeader.rightBgPic = com.qzone.proxy.feedcomponent.util.e.n(cell_recomm_headerVar.rightBgPic);
        return cellRecommHeader;
    }
}
