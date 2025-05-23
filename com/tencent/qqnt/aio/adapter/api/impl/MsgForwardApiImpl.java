package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.qqnt.aio.adapter.api.IMsgForwardApi;
import com.tencent.qqnt.aio.forward.NtMsgForwardUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/MsgForwardApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IMsgForwardApi;", "Landroid/content/Context;", "context", "Lcom/tencent/aio/data/AIOContact;", "contact", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/mvi/base/route/j;", "messenger", "", "forwardMsgSelect", "", "text", "forwardText", "Lyw3/a;", "getMemberViewController", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MsgForwardApiImpl implements IMsgForwardApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IMsgForwardApi
    public void forwardMsgSelect(Context context, AIOContact contact, AIOMsgItem msgItem, com.tencent.mvi.base.route.j messenger) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        if (context instanceof Activity) {
            NtMsgForwardUtils.f349949a.u((Activity) context, contact, msgItem);
            return;
        }
        throw new IllegalArgumentException("context must be Activity");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgForwardApi
    public void forwardText(Context context, AIOContact contact, String text, AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (context instanceof Activity) {
            NtMsgForwardUtils.f349949a.x((Activity) context, contact, text, msgItem);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgForwardApi
    public yw3.a getMemberViewController() {
        return new MsgForwardApiImpl$getMemberViewController$1();
    }
}
