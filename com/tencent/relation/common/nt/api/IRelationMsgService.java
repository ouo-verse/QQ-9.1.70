package com.tencent.relation.common.nt.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.relation.common.nt.data.a;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\u000f\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\nH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/relation/common/nt/api/IRelationMsgService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/relation/common/nt/data/a;", "qqRelationContact", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "", "deleteRecentContacts", "", "getPeerUid", "Ljava/util/ArrayList;", "", "sortedContactList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "deleteRecentForwardContacts", "relation-common-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRelationMsgService extends QRouteApi {
    void deleteRecentContacts(@NotNull a qqRelationContact, @Nullable IOperateCallback cb5);

    void deleteRecentForwardContacts(@NotNull ArrayList<Long> sortedContactList, @NotNull ArrayList<RecentContactInfo> changedList);

    @NotNull
    String getPeerUid(@NotNull a qqRelationContact);
}
