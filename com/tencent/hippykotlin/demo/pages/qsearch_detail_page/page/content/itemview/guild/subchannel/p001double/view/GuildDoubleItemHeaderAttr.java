package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildDoubleItemHeaderAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildDoubleItemHeaderAttr.class, "iconSrcAnd", "getIconSrcAnd()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildDoubleItemHeaderAttr.class, "iconSrcIOS", "getIconSrcIOS()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildDoubleItemHeaderAttr.class, "iconSrcImg", "getIconSrcImg()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildDoubleItemHeaderAttr.class, "pageStatus", "getPageStatus()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/PageStatus;", 0)};
    public h iconBgColor;
    public h iconColor;
    public final ReadWriteProperty iconSrcAnd$delegate;
    public final ReadWriteProperty iconSrcIOS$delegate;
    public final ReadWriteProperty iconSrcImg$delegate;
    public final ReadWriteProperty pageStatus$delegate;
    public UnifySearchTabInfo tabData;
    public String avatar = "";
    public String text = "";

    public GuildDoubleItemHeaderAttr() {
        h.Companion companion = h.INSTANCE;
        this.iconColor = companion.j();
        this.iconSrcAnd$delegate = c.a("ecommerce_search_guild_live");
        this.iconSrcIOS$delegate = c.a("ec_search_guild_live.pag");
        this.iconBgColor = companion.j();
        this.iconSrcImg$delegate = c.a("");
        this.pageStatus$delegate = c.a(PageStatus.DID_APPEAR);
    }

    public final void setIconSrcAnd(String str) {
        this.iconSrcAnd$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final void setIconSrcIOS(String str) {
        this.iconSrcIOS$delegate.setValue(this, $$delegatedProperties[1], str);
    }
}
