package com.tencent.input.base.panelcontainer;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J&\u0010\t\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0006\b\u0001\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/input/base/panelcontainer/c;", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "", "", "panelId", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "b", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface c<C extends com.tencent.mvi.api.runtime.b> {
    @NotNull
    BaseVB<? extends ol3.b, ? extends MviUIState, C> b(int panelId);
}
