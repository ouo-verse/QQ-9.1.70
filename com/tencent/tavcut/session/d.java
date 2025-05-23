package com.tencent.tavcut.session;

import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.rendermodel.RenderModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/tavcut/session/d;", "", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "newData", "", "duration", "mediaDuration", "", ICustomDataEditor.STRING_ARRAY_PARAM_1, "onRenderDataApplied", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface d {
    void a1(@NotNull RenderModel newData, long duration, long mediaDuration);

    void onRenderDataApplied();
}
