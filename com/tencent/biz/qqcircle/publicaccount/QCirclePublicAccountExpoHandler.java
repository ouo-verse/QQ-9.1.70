package com.tencent.biz.qqcircle.publicaccount;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.biz.eventprocessor.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qqcircle/publicaccount/QCirclePublicAccountExpoHandler;", "Lcom/tencent/qqnt/chats/biz/eventprocessor/b$b;", "", "c", "d", "", "Lcom/tencent/qqnt/chats/core/bizEvent/b;", "items", "b", "<init>", "()V", "a", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QCirclePublicAccountExpoHandler implements b.InterfaceC9565b {
    private final void c() {
        final BaseQQAppInterface b16;
        b16 = e.b();
        if (b16 == null) {
            return;
        }
        ((IQCirclePublicAccountMessageService) b16.getRuntimeService(IQCirclePublicAccountMessageService.class)).fetchLastMessageInfo(new Function1<QCirclePublicAccountMessageInfo, Unit>() { // from class: com.tencent.biz.qqcircle.publicaccount.QCirclePublicAccountExpoHandler$onCellExpo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                invoke2(qCirclePublicAccountMessageInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                if (qCirclePublicAccountMessageInfo == null) {
                    return;
                }
                ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportMessageCellExposure(BaseQQAppInterface.this, NetConnInfoCenter.getServerTime(), qCirclePublicAccountMessageInfo);
            }
        });
    }

    private final void d() {
        final BaseQQAppInterface b16;
        b16 = e.b();
        if (b16 == null) {
            return;
        }
        ((IQCirclePublicAccountMessageService) b16.getRuntimeService(IQCirclePublicAccountMessageService.class)).fetchLastMessageInfo(new Function1<QCirclePublicAccountMessageInfo, Unit>() { // from class: com.tencent.biz.qqcircle.publicaccount.QCirclePublicAccountExpoHandler$onRedDotExpo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                invoke2(qCirclePublicAccountMessageInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
                ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportRedPointExposureOnce(BaseQQAppInterface.this, NetConnInfoCenter.getServerTime(), qCirclePublicAccountMessageInfo);
            }
        });
    }

    @Override // com.tencent.qqnt.chats.biz.eventprocessor.b.InterfaceC9565b
    public void a(@NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> list) {
        b.InterfaceC9565b.a.a(this, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.chats.biz.eventprocessor.b.InterfaceC9565b
    public void b(@NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar;
        Object obj;
        Intrinsics.checkNotNullParameter(items, "items");
        b.InterfaceC9565b.a.b(this, items);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = items.iterator();
        while (true) {
            gVar = null;
            if (!it.hasNext()) {
                break;
            }
            Map<String, Object> b16 = ((com.tencent.qqnt.chats.core.bizEvent.b) it.next()).b();
            if (b16 != null) {
                obj = b16.get("expo_recent_data");
            } else {
                obj = null;
            }
            if (obj instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) obj;
            }
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
            if (ia0.a.a((com.tencent.qqnt.chats.core.adapter.itemdata.g) previous)) {
                gVar = previous;
                break;
            }
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar2 = gVar;
        if (gVar2 != null) {
            c();
            if (gVar2.x().c() == 3 || gVar2.x().c() == 1) {
                d();
            }
        }
    }
}
