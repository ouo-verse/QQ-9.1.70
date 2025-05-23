package com.tencent.mobileqq.minigame.va;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/QueryAndUpdateVAListener;", "", "notingToDo", "", "onSilenceUpdate", VirtualAppProxy.KEY_GAME_ID, "", VirtualAppProxy.KEY_AUTO_DOWNLOAD, "", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface QueryAndUpdateVAListener {
    void notingToDo();

    void onSilenceUpdate(@NotNull String gameId, boolean autoDownload);
}
