package fy;

import com.tencent.biz.pubaccount.api.IPublicAccountReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"Lfy/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/c;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "invoke", "<init>", "()V", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements com.tencent.qqnt.chats.main.vm.usecase.click.c {
    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.c
    public void invoke(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        g gVar = b16 instanceof g ? (g) b16 : null;
        if (gVar != null) {
            if (gVar.n() == 103 || gVar.n() == 118) {
                if (params.a().b() == 3) {
                    ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).reportItemClickOnServiceFolder(gVar.s());
                } else {
                    ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).reportItemClickOnConversation(gVar.s());
                }
                ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).reportPublicAccountADDuration(gVar.s());
                if (((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).isValidUin(String.valueOf(gVar.s().peerUin))) {
                    ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(String.valueOf(gVar.s().peerUin), gVar.s().peerUid);
                }
            }
        }
    }
}
