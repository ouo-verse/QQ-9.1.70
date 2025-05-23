package com.tencent.mobileqq.qqecommerce.base.publicaccount;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenter;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenterService;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.biz.eventprocessor.b;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/publicaccount/ECPublicAccountExpoHandler;", "Lcom/tencent/qqnt/chats/biz/eventprocessor/b$b;", "", "d", "", "Lcom/tencent/qqnt/chats/core/bizEvent/b;", "items", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "c", "()Lcom/tencent/common/app/business/BaseQQAppInterface;", "qqAppInterface", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECPublicAccountExpoHandler implements b.InterfaceC9565b {
    private final BaseQQAppInterface c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            return (BaseQQAppInterface) peekAppRuntime;
        }
        return null;
    }

    private final void d() {
        final BaseQQAppInterface c16 = c();
        if (c16 == null) {
            return;
        }
        ((IEcommerceMsgCenterService) c16.getRuntimeService(IEcommerceMsgCenterService.class)).fetchRedDotMessage(new Function1<MessageItem, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.base.publicaccount.ECPublicAccountExpoHandler$onCellExpo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageItem messageItem) {
                invoke2(messageItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MessageItem messageItem) {
                ((IEcommerceMsgCenter) QRoute.api(IEcommerceMsgCenter.class)).reportExposureInAIO(BaseQQAppInterface.this, NetConnInfoCenter.getServerTime(), messageItem);
            }
        });
    }

    @Override // com.tencent.qqnt.chats.biz.eventprocessor.b.InterfaceC9565b
    public void a(List<com.tencent.qqnt.chats.core.bizEvent.b> list) {
        b.InterfaceC9565b.a.a(this, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.chats.biz.eventprocessor.b.InterfaceC9565b
    public void b(List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        g gVar;
        Intrinsics.checkNotNullParameter(items, "items");
        b.InterfaceC9565b.a.b(this, items);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map<String, Object> b16 = ((com.tencent.qqnt.chats.core.bizEvent.b) it.next()).b();
            Object obj = b16 != null ? b16.get("expo_recent_data") : null;
            gVar = obj instanceof g ? (g) obj : null;
            if (gVar != null) {
                arrayList.add(gVar);
            }
        }
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object previous = listIterator.previous();
            if (a.a((g) previous)) {
                gVar = previous;
                break;
            }
        }
        if (gVar != null) {
            d();
        }
    }
}
