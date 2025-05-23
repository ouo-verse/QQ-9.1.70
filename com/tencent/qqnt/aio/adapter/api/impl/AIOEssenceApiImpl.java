package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.qqnt.aio.adapter.api.IAIOEssenceApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEssenceApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEssenceApi;", "()V", "getEssenceMenuType", "", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "isFullScreenEssenceEnable", "", "aioParam", "Lcom/tencent/aio/data/AIOParam;", "onEssenceMenuClicked", "", "context", "Landroid/content/Context;", "isCancel", "setEssenceMsgFromFullScreen", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AIOEssenceApiImpl implements IAIOEssenceApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEssenceApi
    public int getEssenceMenuType(AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return com.tencent.mobileqq.troop.essencemsg.u.f(msgItem);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEssenceApi
    public boolean isFullScreenEssenceEnable(AIOParam aioParam) {
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        aioParam.r().c().e();
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEssenceApi
    public void onEssenceMenuClicked(Context context, AIOMsgItem msgItem, boolean isCancel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        com.tencent.mobileqq.troop.essencemsg.u.t(msgItem.getMsgRecord(), com.tencent.mobileqq.troop.essencemsg.u.j(msgItem), isCancel ? 2 : 1, 1);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEssenceApi
    public void setEssenceMsgFromFullScreen(MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        com.tencent.mobileqq.troop.essencemsg.u.t(msgRecord, com.tencent.mobileqq.troop.essencemsg.u.k(msgRecord), 1, 2);
    }
}
