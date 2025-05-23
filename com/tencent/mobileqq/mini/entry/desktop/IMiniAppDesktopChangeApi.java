package com.tencent.mobileqq.mini.entry.desktop;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/desktop/IMiniAppDesktopChangeApi;", "", "addDesktopChangeListener", "", "listener", "Lcom/tencent/mobileqq/mini/entry/desktop/DesktopChangeListener;", "removeDesktopChangeListener", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface IMiniAppDesktopChangeApi {
    void addDesktopChangeListener(@Nullable DesktopChangeListener listener);

    void removeDesktopChangeListener(@Nullable DesktopChangeListener listener);
}
