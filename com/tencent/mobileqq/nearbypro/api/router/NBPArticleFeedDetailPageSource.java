package com.tencent.mobileqq.nearbypro.api.router;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/router/NBPArticleFeedDetailPageSource;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "PERSONAL_PROFILE", "SQUARE_FEED", "INTERACTIVE_NOTIFICATION", "H5_ACTIVITY", "FEED_DETAIL", "AIO_QUOTE_ARK", "FEED_SHARE_ARK", "FEED_SHARE_H5", "FEED_DETAIL_FOLLOWING", "QQSTRANGER_PUBLIC_ACCOUNT", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public enum NBPArticleFeedDetailPageSource {
    PERSONAL_PROFILE(0),
    SQUARE_FEED(1),
    INTERACTIVE_NOTIFICATION(2),
    H5_ACTIVITY(5),
    FEED_DETAIL(6),
    AIO_QUOTE_ARK(7),
    FEED_SHARE_ARK(13),
    FEED_SHARE_H5(14),
    FEED_DETAIL_FOLLOWING(15),
    QQSTRANGER_PUBLIC_ACCOUNT(16);

    private final int value;

    NBPArticleFeedDetailPageSource(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
