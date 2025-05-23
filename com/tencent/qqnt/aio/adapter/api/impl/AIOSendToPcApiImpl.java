package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.qqnt.aio.adapter.api.IAIOSendToPcApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOSendToPcApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOSendToPcApi;", "()V", "sendFileToPC", "", "context", "Landroid/content/Context;", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class AIOSendToPcApiImpl implements IAIOSendToPcApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IAIOSendToPcApi
    public void sendFileToPC(Context context, AIOMsgItem msgItem) {
        List listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(msgItem);
        ym2.a.e(listOf);
    }
}
