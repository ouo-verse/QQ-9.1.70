package com.tencent.mobileqq.tvideo.base;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.ITVideoPublicAccountLauncherApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h implements com.tencent.qqnt.chats.main.vm.usecase.click.b {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Context context, int i3, String str, ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            MsgRecord msgRecord = (MsgRecord) arrayList.get(arrayList.size() - 1);
            if (msgRecord == null) {
                e(context, "");
                return;
            } else {
                e(context, ((IPublicAccountMsgExtMrg) QRoute.api(IPublicAccountMsgExtMrg.class)).getBytesOacMsgExtend(msgRecord));
                return;
            }
        }
        e(context, "");
    }

    private void e(Context context, String str) {
        ((ITVideoPublicAccountLauncherApi) QRoute.api(ITVideoPublicAccountLauncherApi.class)).launchTVideoPublicAccountPage((BaseQQAppInterface) jy2.g.e(), context, str);
    }

    private void f(final Context context, com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).asyncGetLastMsgRecord(gVar.s(), new IMsgOperateCallback() { // from class: com.tencent.mobileqq.tvideo.base.g
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                h.this.c(context, i3, str, arrayList);
            }
        });
    }

    private void g(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar) {
        if (gVar.x().b() > 0 && com.tencent.qqnt.msg.f.e() != null) {
            com.tencent.qqnt.msg.f.e().setMsgRead(new Contact(gVar.n(), gVar.k(), ""), new IOperateCallback() { // from class: com.tencent.mobileqq.tvideo.base.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    h.d(i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(@NonNull b.a aVar) {
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = aVar.b();
        if (!(b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g)) {
            return false;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) b16;
        if (gVar.n() != 103 || AppConstants.TVIDEO_PUBLIC_ACCOUNT_UIN_LONGVALUE != gVar.l()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(@NonNull b.a aVar) {
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = aVar.b();
        if (!(b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g)) {
            return false;
        }
        Context context = aVar.c().getContext();
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) b16;
        g(gVar);
        f(context, gVar);
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(@NonNull b.a aVar) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(int i3, String str) {
    }
}
