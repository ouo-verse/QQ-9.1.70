package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildAudienceInfo implements ISSOReqModel, ISSORspModel<GuildAudienceInfo> {
    public final String icon;
    public final int sex;
    public final long uin;

    public GuildAudienceInfo() {
        this(0L, null, 0, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.u("uin", this.uin);
        eVar.v("icon", this.icon);
        eVar.t("sex", this.sex);
        return eVar;
    }

    public GuildAudienceInfo(long j3, String str, int i3) {
        this.uin = j3;
        this.icon = str;
        this.sex = i3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GuildAudienceInfo decode(e eVar) {
        return new GuildAudienceInfo(eVar.o("uin", 0L), eVar.q("icon", ""), eVar.k("sex", 0));
    }

    public /* synthetic */ GuildAudienceInfo(long j3, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", 0);
    }
}
