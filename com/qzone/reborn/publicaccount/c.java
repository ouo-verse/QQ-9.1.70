package com.qzone.reborn.publicaccount;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.n;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0011\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/publicaccount/c;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "", "uid", "", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c implements com.tencent.qqnt.chats.main.vm.usecase.click.b {
    private final void a(String uid) {
        IKernelService iKernelService;
        w msgService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) == null || (msgService = iKernelService.getMsgService()) == null) {
            return;
        }
        msgService.setMsgRead(new Contact(103, uid, ""), null);
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g ? (com.tencent.qqnt.chats.core.adapter.itemdata.g) b16 : null;
        return gVar != null && TextUtils.equals(String.valueOf(gVar.l()), AppConstants.VALUE.UIN_QZONE) && gVar.n() == 103;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
            ((IQzoneMsgApi) QRoute.api(IQzoneMsgApi.class)).openContentBox(params.c().getContext());
            com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) b16;
            n.j(gVar.s().unreadCnt > 0);
            a(gVar.k());
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(b.a aVar) {
        return b.C9598b.a(this, aVar);
    }
}
