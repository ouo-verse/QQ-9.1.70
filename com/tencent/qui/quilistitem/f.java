package com.tencent.qui.quilistitem;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH&\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qui/quilistitem/f;", "Landroid/view/View;", "T", "", "Landroid/content/Context;", "context", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "(Landroid/content/Context;)Landroid/view/View;", "view", "", "themeId", "", "a", "(Landroid/view/View;I)V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public interface f<T extends View> {
    void a(@NotNull T view, int themeId);

    @NotNull
    T createView(@NotNull Context context);
}
