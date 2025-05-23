package com.tencent.gamecenter.wadl.distribute.provider;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/provider/ITextContentFetcher;", "", "fetchCanDownloadContent", "", "fetchDownloadedContent", "fetchFollowedContent", "fetchInitContent", "fetchInstalledContent", "fetchPausedContent", "fetchProgressContentWithPlaceHolder", "fetchSubscribedContent", "fetchUpdateContent", "fetchWaitFollowContent", "fetchWaitSubscribeContent", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface ITextContentFetcher {
    @NotNull
    String fetchCanDownloadContent();

    @NotNull
    String fetchDownloadedContent();

    @NotNull
    String fetchFollowedContent();

    @NotNull
    String fetchInitContent();

    @NotNull
    String fetchInstalledContent();

    @NotNull
    String fetchPausedContent();

    @NotNull
    String fetchProgressContentWithPlaceHolder();

    @NotNull
    String fetchSubscribedContent();

    @NotNull
    String fetchUpdateContent();

    @NotNull
    String fetchWaitFollowContent();

    @NotNull
    String fetchWaitSubscribeContent();
}
