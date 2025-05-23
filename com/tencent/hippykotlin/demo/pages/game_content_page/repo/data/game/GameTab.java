package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.base.BaseObject;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameTab extends BaseObject implements ISSOReqModel, ISSORspModel<GameTab> {
    public final boolean enableRedPoint;

    /* renamed from: id, reason: collision with root package name */
    public final String f114192id;
    public final String name;

    public GameTab() {
        this(null, null, false, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("name", this.name);
        eVar.v("id", this.f114192id);
        eVar.w("enable_red_point", this.enableRedPoint);
        return eVar;
    }

    public /* synthetic */ GameTab(String str, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", false);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GameTab decode(e eVar) {
        return new GameTab(eVar.q("name", ""), eVar.q("id", ""), eVar.g("enable_red_point", false));
    }

    public GameTab(String str, String str2, boolean z16) {
        this.name = str;
        this.f114192id = str2;
        this.enableRedPoint = z16;
    }
}
