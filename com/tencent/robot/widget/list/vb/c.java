package com.tencent.robot.widget.list.vb;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mvi.api.runtime.b;
import com.tencent.robot.widget.list.vb.f;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005J\u0017\u0010\b\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\b\u0010\tJ<\u0010\u0011\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0012\u0006\b\u0000\u0012\u00028\u00000\rj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u00100\f2\u0006\u0010\u000b\u001a\u00020\nH&J8\u0010\u0015\u001a*\u0012&\u0012$\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00120\u0013j\b\u0012\u0004\u0012\u00028\u0001`\u00140\f2\u0006\u0010\u000b\u001a\u00020\u0012H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/widget/list/vb/c;", "Lcom/tencent/robot/widget/list/vb/f;", "V", "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "a", "(Lcom/tencent/mvi/api/help/a;)Lcom/tencent/robot/widget/list/vb/f;", "Lcom/tencent/robot/widget/list/vb/d;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lcom/tencent/robot/widget/list/vb/a;", "Lcom/tencent/robot/widget/list/vb/CommonListUIState;", "Lcom/tencent/robot/widget/list/vb/ICommonListVBDelegate;", "b", "Lcom/tencent/robot/widget/list/vb/e;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/robot/widget/list/vb/ICommonListVMDelegate;", "c", "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface c<V extends f, C extends com.tencent.mvi.api.runtime.b> {
    @NotNull
    V a(@NotNull com.tencent.mvi.api.help.a createViewParams);

    @NotNull
    List<com.tencent.input.base.mvicompat.c<a, CommonListUIState, d, ? super V>> b(@NotNull d host);

    @NotNull
    List<com.tencent.input.base.mvicompat.e<a, CommonListUIState, C, e>> c(@NotNull e host);
}
