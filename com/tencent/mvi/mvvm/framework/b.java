package com.tencent.mvi.mvvm.framework;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.log.c;
import com.tencent.mvi.mvvm.BaseVB;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aH\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u0018\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00022\u001c\u0010\u0006\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/mvvm/framework/FrameworkVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mvi/mvvm/BaseVB;", "child", "", "a", "mvi_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public final class b {
    public static final <C extends com.tencent.mvi.api.runtime.b> void a(@NotNull FrameworkVB<? extends ol3.b, ? extends MviUIState, C> buildChildWithoutAdd, @NotNull BaseVB<? extends ol3.b, ? extends MviUIState, C> child) {
        Intrinsics.checkNotNullParameter(buildChildWithoutAdd, "$this$buildChildWithoutAdd");
        Intrinsics.checkNotNullParameter(child, "child");
        buildChildWithoutAdd.getMChildren().add(child);
        Context mContext = buildChildWithoutAdd.getMContext();
        View hostView = buildChildWithoutAdd.getHostView();
        if (hostView != null) {
            child.buildViewTree(mContext, (ViewGroup) hostView, buildChildWithoutAdd.getMStrategyService());
            if (buildChildWithoutAdd.getMMviContext$mvi_debug() == null) {
                c.f337783b.b(FrameworkVB.TAG, "mMviContext is Null");
                return;
            }
            C mMviContext$mvi_debug = buildChildWithoutAdd.getMMviContext$mvi_debug();
            Intrinsics.checkNotNull(mMviContext$mvi_debug);
            child.buildVM(mMviContext$mvi_debug);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
