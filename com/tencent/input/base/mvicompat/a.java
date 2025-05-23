package com.tencent.input.base.mvicompat;

import androidx.core.util.Consumer;
import com.tencent.input.base.mvicompat.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005R\u001c\u0010\n\u001a\u00028\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/input/base/mvicompat/a;", "TypeToHost", "TypeToDelegate", "Lcom/tencent/input/base/mvicompat/b;", "H", "Landroidx/core/util/Consumer;", "M", "()Lcom/tencent/input/base/mvicompat/b;", "L0", "(Lcom/tencent/input/base/mvicompat/b;)V", "mHost", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface a<TypeToHost, TypeToDelegate, H extends b<TypeToHost>> extends Consumer<TypeToDelegate> {
    void L0(@NotNull H h16);

    @NotNull
    H M();
}
