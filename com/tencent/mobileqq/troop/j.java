package com.tencent.mobileqq.troop;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/j;", "Lcom/tencent/qqnt/chats/biz/summary/state/core/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "appRuntime", "", "a", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;Landroid/content/Context;Lmqq/app/AppRuntime;)Ljava/lang/Integer;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class j extends com.tencent.qqnt.chats.biz.summary.state.core.a {
    @Override // com.tencent.qqnt.chats.biz.summary.state.core.a
    public Integer a(com.tencent.qqnt.chats.core.adapter.itemdata.g item, Context context, AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        if ((appRuntime instanceof QQAppInterface) && item.n() == 2) {
            HashMap<LiteBusinessType, String> hashMap = item.s().liteBusiness;
            String str = hashMap != null ? hashMap.get(LiteBusinessType.KTEAMOFKINGS) : null;
            if (!TextUtils.isEmpty(str) && TextUtils.equals(str, item.k())) {
                return 14;
            }
        }
        return null;
    }
}
