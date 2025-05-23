package com.tencent.tavcut.core.session;

import com.gyailib.library.GYTrackStickerInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/tavcut/core/session/IStickerUpdateCallback;", "", "onUpdate", "", "stickerName", "", "stickerInfo", "Lcom/gyailib/library/GYTrackStickerInfo;", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IStickerUpdateCallback {
    void onUpdate(@NotNull String stickerName, @NotNull GYTrackStickerInfo stickerInfo);
}
