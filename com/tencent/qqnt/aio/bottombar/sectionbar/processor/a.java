package com.tencent.qqnt.aio.bottombar.sectionbar.processor;

import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/a;", "", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/b;", "model", "", "a", "", "sectionType", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "c", "", "b", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface a {
    void a(@NotNull com.tencent.qqnt.aio.bottombar.sectionbar.model.b model);

    boolean b();

    void c(int sectionType, @NotNull MviUIState state);
}
