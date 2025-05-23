package com.tencent.ecommerce.biz.consumer.ui.api;

import android.view.ViewGroup;
import com.tencent.ecommerce.biz.consumer.event.IECEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/ui/api/IECGoodsViewModel;", "Lcom/tencent/ecommerce/biz/consumer/event/IECEvent;", "addJumpLisenter", "", "listener", "Lkotlin/Function1;", "", "onWrapperViewAppear", "isContinuation", "", "onWrapperViewDisappear", "setTopWrapperView", "viewGroup", "Landroid/view/ViewGroup;", "setWrapperView", "wrapperView", "bigWrapperView", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECGoodsViewModel extends IECEvent {
    void addJumpLisenter(@NotNull Function1<? super String, Unit> listener);

    void onWrapperViewAppear(boolean isContinuation);

    void onWrapperViewDisappear();

    void setTopWrapperView(@NotNull ViewGroup viewGroup);

    void setWrapperView(@NotNull ViewGroup wrapperView, @Nullable ViewGroup bigWrapperView);
}
