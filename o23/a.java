package o23;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasReadPublicAccount;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\n"}, d2 = {"Lo23/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "<init>", "()V", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements b {
    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (!(b16 instanceof g)) {
            return false;
        }
        g gVar = (g) b16;
        return gVar.n() == 103 && ((IVasReadPublicAccount) QRoute.api(IVasReadPublicAccount.class)).isVipRead(String.valueOf(gVar.l()));
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ((IVasReadPublicAccount) QRoute.api(IVasReadPublicAccount.class)).startVipReadFragment(params.c().getContext());
        ((IMsgService) QRoute.api(IMsgService.class)).setMsgRead(new Contact(103, IVasReadPublicAccount.READ_UID, ""), null);
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(b.a aVar) {
        return b.C9598b.a(this, aVar);
    }
}
