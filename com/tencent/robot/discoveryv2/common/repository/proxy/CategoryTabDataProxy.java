package com.tencent.robot.discoveryv2.common.repository.proxy;

import com.tencent.qqnt.kernel.nativeinterface.ListNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0005R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR2\u0010\u0012\u001a \u0012\u0004\u0012\u00020\u000f\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u00100\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/repository/proxy/CategoryTabDataProxy;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/ListNode;", "newTabList", "", "d", "Lkotlinx/coroutines/flow/Flow;", "b", "c", "", "a", "Ljava/util/List;", "mCategoryTabList", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Function1;", "Ljava/util/concurrent/ConcurrentHashMap;", "mCategoryTabListChangedListener", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class CategoryTabDataProxy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ListNode> mCategoryTabList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Function1<List<ListNode>, Unit>> mCategoryTabListChangedListener = new ConcurrentHashMap<>();

    @NotNull
    public final Flow<List<ListNode>> b() {
        return FlowKt.callbackFlow(new CategoryTabDataProxy$categoryTabListChangedNotificationFlow$1(this, null));
    }

    public final void c() {
        Iterator<Map.Entry<Integer, Function1<List<ListNode>, Unit>>> it = this.mCategoryTabListChangedListener.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().invoke(this.mCategoryTabList);
        }
    }

    public final void d(@NotNull List<ListNode> newTabList) {
        Intrinsics.checkNotNullParameter(newTabList, "newTabList");
        this.mCategoryTabList.clear();
        this.mCategoryTabList.addAll(newTabList);
    }
}
