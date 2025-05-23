package com.tencent.mobileqq.guild.feed.publish.result;

import androidx.annotation.Keep;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/result/EditTextLinkResult;", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "", "desc", "(Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getLink", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class EditTextLinkResult {

    @NotNull
    private final String desc;

    @NotNull
    private final String link;

    public EditTextLinkResult(@NotNull String link, @NotNull String desc) {
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.link = link;
        this.desc = desc;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final String getLink() {
        return this.link;
    }
}
