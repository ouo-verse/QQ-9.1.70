package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_yytag;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class YYTag implements SmartParcelable {

    @NeedParcel
    public int actiontype;

    @NeedParcel
    public ArrayList<Integer> beginEndSeconds;

    @NeedParcel
    public int displaytype;

    @NeedParcel
    public int scene;

    @NeedParcel
    public String logo = "";

    @NeedParcel
    public String content = "";

    @NeedParcel
    public String actionurl = "";

    public static YYTag create(s_yytag s_yytagVar) {
        if (s_yytagVar == null) {
            return null;
        }
        YYTag yYTag = new YYTag();
        yYTag.logo = s_yytagVar.logo;
        yYTag.content = s_yytagVar.content;
        yYTag.actiontype = s_yytagVar.actiontype;
        yYTag.actionurl = s_yytagVar.actionurl;
        yYTag.scene = s_yytagVar.scene;
        yYTag.displaytype = s_yytagVar.displaytype;
        yYTag.beginEndSeconds = s_yytagVar.beginEndSeconds;
        return yYTag;
    }
}
