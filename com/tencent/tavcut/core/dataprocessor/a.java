package com.tencent.tavcut.core.dataprocessor;

import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/tavcut/core/dataprocessor/a;", "", "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "clips", "", "modifyClipsDuration", "", "setClipAssetsWithCallback", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface a {
    void setClipAssetsWithCallback(@NotNull List<ClipSource> clips, boolean modifyClipsDuration);
}
