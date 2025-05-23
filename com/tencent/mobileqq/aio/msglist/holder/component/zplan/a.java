package com.tencent.mobileqq.aio.msglist.holder.component.zplan;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ZPlanMsgItem;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/zplan/a;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "a", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "d", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a extends AbsAIOMsgProcessor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
    }

    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    @NotNull
    public List<com.tencent.aio.data.msglist.a> a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        int i3;
        AIOMsgItem aIOMsgItem;
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        ArrayList<com.tencent.aio.data.msglist.a> arrayList = new ArrayList();
        arrayList.addAll(displayList);
        ArrayList arrayList2 = new ArrayList();
        Pair pair = null;
        Pair pair2 = null;
        int i16 = 0;
        for (com.tencent.aio.data.msglist.a aVar : arrayList) {
            int i17 = i16 + 1;
            if (aVar instanceof AIOMsgItem) {
                aIOMsgItem = (AIOMsgItem) aVar;
            } else {
                aIOMsgItem = null;
            }
            if (aIOMsgItem != null && (aVar instanceof ZPlanMsgItem) && com.tencent.mobileqq.aio.utils.d.f0(aIOMsgItem)) {
                arrayList2.add(aVar);
                if (!aVar.isSelf()) {
                    Pair pair3 = new Pair(Integer.valueOf(i16), aVar);
                    i16 = i17;
                    pair2 = pair;
                    pair = pair3;
                }
            }
            i16 = i17;
        }
        int size = arrayList2.size();
        if (size > 1 && size - 2 >= 0) {
            int i18 = 0;
            while (true) {
                ZPlanMsgItem zPlanMsgItem = (ZPlanMsgItem) arrayList2.get(i18);
                if (!zPlanMsgItem.E2()) {
                    zPlanMsgItem.I2();
                }
                if (i18 == i3) {
                    break;
                }
                i18++;
            }
        }
        if (size > 0) {
            ZPlanMsgItem zPlanMsgItem2 = (ZPlanMsgItem) arrayList2.get(size - 1);
            if (zPlanMsgItem2.H() && !zPlanMsgItem2.E2()) {
                zPlanMsgItem2.I2();
            }
        }
        if (pair != null) {
            ((ZPlanMsgItem) pair.getSecond()).H2(true);
        }
        if (pair2 != null) {
            ((ZPlanMsgItem) pair2.getSecond()).H2(false);
        }
        return arrayList;
    }
}
