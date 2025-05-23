package com.tencent.qqnt.aio.adapter.clickresponder;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/clickresponder/GeQianResponder;", "Lcom/tencent/qqnt/aio/adapter/clickresponder/b;", "Landroid/content/Context;", "context", "", "isScaleChat", "Lcom/tencent/mobileqq/aio/msg/ah;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GeQianResponder extends b {
    @Override // com.tencent.qqnt.aio.adapter.clickresponder.b, com.tencent.qqnt.aio.adapter.clickresponder.e
    public void a(final Context context, boolean isScaleChat, final ah item) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.d("GeQianResponder", 1, "click tofu: " + item);
        com.tencent.nt.adapter.session.c.h(item.getMsgRecord().peerUid.toString(), item.getMsgRecord().chatType, new Function2<Boolean, com.tencent.nt.adapter.session.f, Unit>() { // from class: com.tencent.qqnt.aio.adapter.clickresponder.GeQianResponder$clickTofu$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, com.tencent.nt.adapter.session.f fVar) {
                invoke(bool.booleanValue(), fVar);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, com.tencent.nt.adapter.session.f fVar) {
                if (fVar == null) {
                    QLog.i("GeQianResponder", 1, "SessionConverterUtils.uid2Uin failed");
                    return;
                }
                Intent intent = new Intent(context, (Class<?>) PublicFragmentActivity.class);
                intent.putExtra("key_uin", fVar.a());
                intent.putExtra("key_uin_name", item.getMsgRecord().peerName);
                intent.putExtra("key_open_via", "history-liaotian");
                PublicFragmentActivity.b.a(context, intent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
            }
        });
    }
}
