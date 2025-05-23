package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusUserInfo implements ISSOReqModel, ISSORspModel<QPlusUserInfo> {
    public final long fansCount;
    public final long feedCount;
    public final String icon;
    public final boolean isBigV;
    public final boolean isBlueV;
    public final String nickname;
    public final long uin;

    public QPlusUserInfo() {
        this(0L, null, null, 0L, 0L, false, false, 127, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.u("uin", this.uin);
        eVar.v("nickname", this.nickname);
        eVar.v("icon", this.icon);
        eVar.u(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_FANS_COUNT, this.fansCount);
        eVar.u("feed_count", this.feedCount);
        eVar.w("isBigV", this.isBigV);
        eVar.w("isBlueV", this.isBlueV);
        return eVar;
    }

    public QPlusUserInfo(long j3, String str, String str2, long j16, long j17, boolean z16, boolean z17) {
        this.uin = j3;
        this.nickname = str;
        this.icon = str2;
        this.fansCount = j16;
        this.feedCount = j17;
        this.isBigV = z16;
        this.isBlueV = z17;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusUserInfo decode(e eVar) {
        return new QPlusUserInfo(eVar.o("uin", 0L), eVar.q("nickname", ""), eVar.q("icon", ""), eVar.o(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_FANS_COUNT, 0L), eVar.o("feed_count", 0L), eVar.g("isBigV", false), eVar.g("isBlueV", false));
    }

    public /* synthetic */ QPlusUserInfo(long j3, String str, String str2, long j16, long j17, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", "", 0L, 0L, false, false);
    }
}
