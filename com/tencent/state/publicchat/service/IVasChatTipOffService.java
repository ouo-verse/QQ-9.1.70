package com.tencent.state.publicchat.service;

import com.tencent.rapier.a;
import com.tencent.rapier.annotation.Route;
import kotlin.Metadata;
import ys4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H'\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/publicchat/service/IVasChatTipOffService;", "", "Lys4/a;", "req", "", "source", "Lcom/tencent/rapier/a;", "Lys4/b;", "getImpeachSeqID", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface IVasChatTipOffService {
    @Route(method = "GetImpeachSeqID", service = "trpc.qmeta.public_chat_tipoff_svr.TipOff")
    a<b> getImpeachSeqID(ys4.a req, int source);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ a getImpeachSeqID$default(IVasChatTipOffService iVasChatTipOffService, ys4.a aVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                return iVasChatTipOffService.getImpeachSeqID(aVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getImpeachSeqID");
        }
    }
}
