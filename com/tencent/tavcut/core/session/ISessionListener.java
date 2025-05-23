package com.tencent.tavcut.core.session;

import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/tavcut/core/session/ISessionListener;", "", "onRenderDataApplied", "", "onRenderDataChanged", "newData", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "duration", "", "mediaDuration", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface ISessionListener {
    void onRenderDataApplied();

    void onRenderDataChanged(@NotNull LAKRenderModel newData, long duration, long mediaDuration);
}
