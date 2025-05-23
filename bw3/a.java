package bw3;

import android.text.TextUtils;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"Lbw3/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements b {
    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        g gVar = b16 instanceof g ? (g) b16 : null;
        return gVar != null && TextUtils.equals(IMiniGamePublicAccountApi.PEER_UID_MINI_GAME, gVar.k()) && gVar.n() == 103;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(b.a params) {
        String str;
        ArrayList<MsgAbstractElement> arrayList;
        Object orNull;
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if ((b16 instanceof g) && (arrayList = ((g) b16).s().abstractContent) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
            MsgAbstractElement msgAbstractElement = (MsgAbstractElement) orNull;
            if (msgAbstractElement != null) {
                str = msgAbstractElement.customContent;
                MiniGamePublicAccountHelper.launchMiniGamePublicAccountFromAIO(BaseApplication.context, str);
                ((IMsgService) QRoute.api(IMsgService.class)).setMsgRead(new Contact(103, IMiniGamePublicAccountApi.PEER_UID_MINI_GAME, ""), null);
                return true;
            }
        }
        str = null;
        MiniGamePublicAccountHelper.launchMiniGamePublicAccountFromAIO(BaseApplication.context, str);
        ((IMsgService) QRoute.api(IMsgService.class)).setMsgRead(new Contact(103, IMiniGamePublicAccountApi.PEER_UID_MINI_GAME, ""), null);
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(b.a aVar) {
        return b.C9598b.a(this, aVar);
    }
}
