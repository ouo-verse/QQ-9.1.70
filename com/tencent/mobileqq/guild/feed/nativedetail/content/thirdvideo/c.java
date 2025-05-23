package com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo;

import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/c;", "", "", "loadSucceed", "", "code", "", "msg", "onError", "", RemoteWebViewEvent.OPEN_FULL_SCREEN, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface c {
    void a(boolean openFullScreen);

    void loadSucceed();

    void onError(int code, @Nullable String msg2);
}
