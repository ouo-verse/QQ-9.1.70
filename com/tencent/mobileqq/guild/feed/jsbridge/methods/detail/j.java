package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/j;", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/c;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j extends c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(j this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("FeedCommentMethod", 2, "callbackToJs result=" + str);
        }
        this$0.i(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "openCommentComponent";
    }

    @Override // ok1.a
    protected boolean o(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        lj1.a l3 = l();
        if (l3 == null) {
            return false;
        }
        String guildId = g("guildId");
        String channelId = g("channelId");
        String feedId = g("feedId");
        String g16 = g("placeholder");
        long f16 = f("feedCreateTime");
        String posterId = g("posterId");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            str = g16;
            logger.d().d("FeedCommentMethod", 2, "guildId = " + guildId + ", channelId=" + channelId + ", feedId=" + feedId + ", placeholder=" + g16 + ", posterId =" + posterId + ", feedCreateTime= " + f16);
        } else {
            str = g16;
        }
        if (guildId != null && guildId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (channelId != null && channelId.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (feedId != null && feedId.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18) {
                    if (posterId != null && posterId.length() != 0) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    if (!z19) {
                        l3.setSendOtherFeedCommentCallBack(new GuildFeedDetailWebViewFragment.g() { // from class: com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.i
                            @Override // com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment.g
                            public final void onResult(String str2) {
                                j.q(j.this, str2);
                            }
                        });
                        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
                        Intrinsics.checkNotNullExpressionValue(channelId, "channelId");
                        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
                        Intrinsics.checkNotNullExpressionValue(posterId, "posterId");
                        l3.showInputPopForRecommendFeed(new bj1.a(guildId, channelId, feedId, f16, posterId), str, d("maxTextLength"));
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
