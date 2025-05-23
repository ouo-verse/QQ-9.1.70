package com.tencent.biz.richframework.localupload.recommend.delegate;

import com.tencent.midas.api.APMidasPayAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendLogDelegate;", "", "debug", "", "tag", "", "msg", APMidasPayAPI.ENV_DEV, "error", "fatal", "t", "", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IRFWRecommendLogDelegate {
    void debug(@NotNull String tag, @NotNull String msg2);

    void dev(@NotNull String tag, @NotNull String msg2);

    void error(@NotNull String tag, @NotNull String msg2);

    void fatal(@NotNull String tag, @NotNull Throwable t16);
}
