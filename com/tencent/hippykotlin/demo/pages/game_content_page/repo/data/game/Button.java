package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Button implements ISSOReqModel, ISSORspModel<Button> {
    public final String jumpUrl;
    public final String title;

    public Button() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("title", this.title);
        eVar.v("jump_url", this.jumpUrl);
        return eVar;
    }

    public Button(String str, String str2) {
        this.title = str;
        this.jumpUrl = str2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final Button decode(e eVar) {
        return new Button(eVar.q("title", ""), eVar.q("jump_url", ""));
    }

    public /* synthetic */ Button(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "");
    }
}
