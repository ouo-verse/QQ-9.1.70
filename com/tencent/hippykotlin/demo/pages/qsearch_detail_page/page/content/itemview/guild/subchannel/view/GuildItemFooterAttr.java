package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.guild.SearchGuildBaseItemModel;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildItemFooterAttr extends k {
    public float buttonWidth;
    public SearchGuildBaseItemModel data;
    public String buttonText = "";
    public h buttonColor = h.INSTANCE.j();
    public e reportParams = new e();
    public String traceId = "";

    public final SearchGuildBaseItemModel getData() {
        SearchGuildBaseItemModel searchGuildBaseItemModel = this.data;
        if (searchGuildBaseItemModel != null) {
            return searchGuildBaseItemModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }
}
