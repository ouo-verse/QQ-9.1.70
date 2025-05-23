package com.tencent.biz.pubaccount.recentcontact;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/pubaccount/recentcontact/a;", "Lcom/tencent/biz/pubaccount/recentcontact/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class a implements b {
    @Override // com.tencent.biz.pubaccount.recentcontact.b
    public void a(RecentContactInfo item) {
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.d("DefaultPAUnfollowClickListener", 4, "onMenuUnfollowClick Demo");
    }
}
