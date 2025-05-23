package com.tencent.qqnt.aio.adapter.clickresponder;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/clickresponder/g;", "Lcom/tencent/qqnt/aio/adapter/clickresponder/b;", "Landroid/content/Context;", "context", "", "isScaleChat", "Lcom/tencent/mobileqq/aio/msg/ah;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g extends b {
    @Override // com.tencent.qqnt.aio.adapter.clickresponder.b, com.tencent.qqnt.aio.adapter.clickresponder.e
    public void a(Context context, boolean isScaleChat, ah item) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.d("NicePicsResponder", 1, "click tofu: " + item);
        String valueOf = String.valueOf(item.getMsgRecord().peerUin);
        if (Intrinsics.areEqual("0", valueOf)) {
            valueOf = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(item.getMsgRecord().peerUid);
            Intrinsics.checkNotNullExpressionValue(valueOf, "api(IRelationNTUinAndUid\u2026d(item.msgRecord.peerUid)");
        }
        if (!(context instanceof Activity)) {
            QLog.e("NicePicsResponder", 1, "clickTofu is error! context is invalid!");
        } else {
            PhotoWallView.jumpToPhotoWall((Activity) context, valueOf, false);
            QLog.i("NicePicsResponder", 1, "jump photo wall is executed!");
        }
    }
}
