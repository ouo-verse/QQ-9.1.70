package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.aio.data.AIOContact;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.qqnt.aio.adapter.api.IMultiSelectApi;
import com.tencent.qqnt.aio.forward.NtMsgForwardUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/MultiSelectApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IMultiSelectApi;", "Landroid/content/Context;", "context", "", "forwardType", "Lcom/tencent/aio/data/AIOContact;", "contact", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "Lcom/tencent/mvi/base/route/j;", "messenger", "", "multiForwardSelect", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MultiSelectApiImpl implements IMultiSelectApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IMultiSelectApi
    public void multiForwardSelect(Context context, int forwardType, AIOContact contact, List<? extends AIOMsgItem> msgList, com.tencent.mvi.base.route.j messenger) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        NtMsgForwardUtils.f349949a.y(context, forwardType, contact, msgList, messenger);
    }
}
