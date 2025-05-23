package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.p001double;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildDoubleItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportAttr;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GuildBaseDoubleAttr extends QSearchReportAttr {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildBaseDoubleAttr.class, "playIndex", "getPlayIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildBaseDoubleAttr.class, "keyword", "getKeyword()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildBaseDoubleAttr.class, "pageStatus", "getPageStatus()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/PageStatus;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GuildBaseDoubleAttr.class, "userScrolling", "getUserScrolling()Z", 0)};
    public SearchGuildDoubleItemModel data;
    public int index;
    public final ReadWriteProperty playIndex$delegate = c.a(0);
    public String title = "";
    public final ReadWriteProperty keyword$delegate = c.a("");
    public String traceId = "";
    public final ReadWriteProperty pageStatus$delegate = c.a(PageStatus.DID_APPEAR);
    public final ReadWriteProperty userScrolling$delegate = c.a(Boolean.FALSE);

    public final int getPlayIndex() {
        return ((Number) this.playIndex$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }
}
