package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_plug_in_comment;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* loaded from: classes39.dex */
public class CellCommentPlugin implements SmartParcelable {

    @NeedParcel
    public int action_type;

    @NeedParcel
    public String action_url;

    @NeedParcel
    public int insert_index;

    @NeedParcel
    public String title;

    public String toString() {
        return "CellCommentPlugin{title='" + this.title + "', action_type=" + this.action_type + ", action_url='" + this.action_url + "', insert_index=" + this.insert_index + '}';
    }

    public static CellCommentPlugin create(s_plug_in_comment s_plug_in_commentVar) {
        if (s_plug_in_commentVar == null) {
            return null;
        }
        CellCommentPlugin cellCommentPlugin = new CellCommentPlugin();
        cellCommentPlugin.title = s_plug_in_commentVar.title;
        cellCommentPlugin.action_type = s_plug_in_commentVar.action_type;
        cellCommentPlugin.action_url = s_plug_in_commentVar.action_url;
        cellCommentPlugin.insert_index = s_plug_in_commentVar.insert_index;
        return cellCommentPlugin;
    }
}
