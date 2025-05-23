package com.tencent.gamecenter.wadl.distribute.provider;

import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/provider/TextContentFetcherAdapter;", "Lcom/tencent/gamecenter/wadl/distribute/provider/ITextContentFetcher;", "()V", "fetchCanDownloadContent", "", "fetchDownloadedContent", "fetchFollowedContent", "fetchInitContent", "fetchInstalledContent", "fetchPausedContent", "fetchProgressContentWithPlaceHolder", "fetchSubscribedContent", "fetchUpdateContent", "fetchWaitFollowContent", "fetchWaitSubscribeContent", "getString", "resId", "", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class TextContentFetcherAdapter implements ITextContentFetcher {
    private final String getString(int resId) {
        String string = MobileQQ.sMobileQQ.getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(resId)");
        return string;
    }

    @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
    @NotNull
    public String fetchCanDownloadContent() {
        return getString(R.string.f170853zs1);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
    @NotNull
    public String fetchDownloadedContent() {
        return getString(R.string.f170855zs3);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
    @NotNull
    public String fetchFollowedContent() {
        return getString(R.string.f170854zs2);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
    @NotNull
    public String fetchInitContent() {
        return "";
    }

    @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
    @NotNull
    public String fetchInstalledContent() {
        return getString(R.string.zs7);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
    @NotNull
    public String fetchPausedContent() {
        return getString(R.string.zs6);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
    @NotNull
    public String fetchProgressContentWithPlaceHolder() {
        String string = MobileQQ.sMobileQQ.getString(R.string.f170852zs0);
        Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(\n   \u2026oad_progress_palceholder)");
        return string;
    }

    @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
    @NotNull
    public String fetchSubscribedContent() {
        return getString(R.string.zs8);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
    @NotNull
    public String fetchUpdateContent() {
        return getString(R.string.zs9);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
    @NotNull
    public String fetchWaitFollowContent() {
        return getString(R.string.zs_);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
    @NotNull
    public String fetchWaitSubscribeContent() {
        return getString(R.string.zsa);
    }
}
