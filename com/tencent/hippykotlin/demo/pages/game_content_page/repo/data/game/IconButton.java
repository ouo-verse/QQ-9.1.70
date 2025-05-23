package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class IconButton implements ISSOReqModel, ISSORspModel<IconButton> {
    public final String iconDefault;
    public final String iconNight;
    public final String jumpUrl;
    public final String subTitle;
    public final String title;

    public IconButton() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("title", this.title);
        eVar.v("jump_url", this.jumpUrl);
        eVar.v("icon_default", this.iconDefault);
        eVar.v("icon_night", this.iconNight);
        eVar.v("sub_title", this.subTitle);
        return eVar;
    }

    public IconButton(String str, String str2, String str3, String str4, String str5) {
        this.title = str;
        this.jumpUrl = str2;
        this.iconDefault = str3;
        this.iconNight = str4;
        this.subTitle = str5;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final IconButton decode(e eVar) {
        return new IconButton(eVar.q("title", ""), eVar.q("jump_url", ""), eVar.q("icon_default", ""), eVar.q("icon_night", ""), eVar.q("sub_title", ""));
    }

    public /* synthetic */ IconButton(String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", "", "");
    }
}
