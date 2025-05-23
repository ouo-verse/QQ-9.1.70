package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nj1.FeedWebDetailParams;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\u0004H\u0014\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/g;", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/c;", "Lnj1/b;", "r", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g extends c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(g this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i(str);
    }

    private final FeedWebDetailParams r() {
        boolean z16;
        String placeHolder = g("defaultPlaceholder");
        if (d("supportAtInComment") == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int d16 = d("maxTextLength");
        String troopName = h("groupName", "");
        QLog.i("DetailConfigMethod", 1, "onInvoke supportAt=" + z16 + " textLength=" + d16 + " troopName=" + troopName + " placeHolder=" + placeHolder);
        Intrinsics.checkNotNullExpressionValue(troopName, "troopName");
        Intrinsics.checkNotNullExpressionValue(placeHolder, "placeHolder");
        return new FeedWebDetailParams(d16, z16, troopName, placeHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "detailConfig";
    }

    @Override // ok1.a
    protected boolean o(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.i("DetailConfigMethod", 1, "onInvoke url=" + url + " pkgName=" + pkgName + " method=" + method);
        lj1.a l3 = l();
        boolean z16 = false;
        if (l3 == null) {
            return false;
        }
        l3.setSendCommentCallBack(new GuildFeedDetailWebViewFragment.g() { // from class: com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.f
            @Override // com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment.g
            public final void onResult(String str) {
                g.q(g.this, str);
            }
        });
        l3.updateGuildFeedInfo(h("guildId", ""), h("channelId", ""), h("feedId", ""));
        if (d("isInputBarShow") == 1) {
            z16 = true;
        }
        l3.updateBottomBarVisible(z16);
        l3.setDefaultPlaceholder(g("defaultPlaceholder"));
        l3.updateWebParams(r());
        return true;
    }
}
