package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Redirect implements ISSOReqModel, ISSORspModel<Redirect> {
    public final int jumpType;
    public final String url;
    public final int weight;

    public Redirect() {
        this(0, null, 0, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("jump_type", this.jumpType);
        eVar.v("url", this.url);
        eVar.t("weight", this.weight);
        return eVar;
    }

    public Redirect(int i3, String str, int i16) {
        this.jumpType = i3;
        this.url = str;
        this.weight = i16;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final Redirect decode(e eVar) {
        return new Redirect(eVar.k("jump_type", 0), eVar.q("url", ""), eVar.k("weight", 0));
    }

    public /* synthetic */ Redirect(int i3, String str, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", 0);
    }
}
