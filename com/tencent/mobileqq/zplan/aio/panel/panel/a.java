package com.tencent.mobileqq.zplan.aio.panel.panel;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.zplan.aio.panel.page.Page;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\rH&R\u0018\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00108&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/panel/a;", "", "data", "", "source", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;", "b", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "c", "viewHolder", "Lkotlinx/coroutines/flow/StateFlow;", "", "d", "Ljava/lang/Class;", "a", "()Ljava/lang/Class;", "dataClass", "", "getPageType", "()I", "pageType", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface a {
    Class<?> a();

    Object b(Object obj, String str, Continuation<? super Page> continuation);

    RecyclerView.ViewHolder c(RecyclerView parent);

    void d(RecyclerView.ViewHolder viewHolder, StateFlow<? extends Page> source);

    int getPageType();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.panel.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9148a {
        public static /* synthetic */ Object a(a aVar, Object obj, String str, Continuation continuation, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 2) != 0) {
                    str = "UNKNOWN";
                }
                return aVar.b(obj, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCreatePage");
        }
    }
}
