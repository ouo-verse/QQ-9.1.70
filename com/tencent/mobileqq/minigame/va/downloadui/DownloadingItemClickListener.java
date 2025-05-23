package com.tencent.mobileqq.minigame.va.downloadui;

import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/DownloadingItemClickListener;", "", "onItemCancelDownloadClick", "", "data", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "onItemPauseDownloadClick", "onItemStartDownloadClick", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public interface DownloadingItemClickListener {
    void onItemCancelDownloadClick(MiniGameDownloadDataWrapper data);

    void onItemPauseDownloadClick(MiniGameDownloadDataWrapper data);

    void onItemStartDownloadClick(MiniGameDownloadDataWrapper data);
}
