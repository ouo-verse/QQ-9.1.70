package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/IMiniGameVABannerService;", "Lmqq/app/api/IRuntimeService;", "onBannerClose", "", "onDownloadStart", VirtualAppProxy.KEY_GAME_ID, "", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface IMiniGameVABannerService extends IRuntimeService {
    void onBannerClose();

    void onDownloadStart(@Nullable String gameId);
}
