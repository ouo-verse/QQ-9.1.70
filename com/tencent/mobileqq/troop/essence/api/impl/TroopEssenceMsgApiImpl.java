package com.tencent.mobileqq.troop.essence.api.impl;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.troop.essence.api.ITroopEssenceMsgApi;
import com.tencent.qqnt.graytips.action.f;
import com.tencent.qqnt.graytips.handler.b;
import js2.LaunchEssenceDetailsActionInfo;
import js2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/essence/api/impl/TroopEssenceMsgApiImpl;", "Lcom/tencent/mobileqq/troop/essence/api/ITroopEssenceMsgApi;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/graytips/handler/b;", "getEssenceMsgHandlerClz", "", "troopUin", "", WadlProxyConsts.KEY_JUMP_URL, "Lcom/tencent/qqnt/graytips/action/f;", "getGrayTipsToDetailsWebActionInfo", "<init>", "()V", "Companion", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopEssenceMsgApiImpl implements ITroopEssenceMsgApi {
    public static final String TAG = "TroopEssenceMsgApiImpl";

    @Override // com.tencent.mobileqq.troop.essence.api.ITroopEssenceMsgApi
    public Class<? extends b> getEssenceMsgHandlerClz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.troop.essence.api.ITroopEssenceMsgApi
    public f getGrayTipsToDetailsWebActionInfo(long troopUin, String jumpUrl) {
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        return new LaunchEssenceDetailsActionInfo(troopUin, jumpUrl);
    }
}
