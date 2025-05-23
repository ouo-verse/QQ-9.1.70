package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/w;", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/c;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class w extends c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(w this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "recoverComment";
    }

    @Override // ok1.a
    protected boolean o(@Nullable String url, @Nullable String pkgName, @Nullable String method) {
        lj1.a l3 = l();
        if (l3 == null) {
            return false;
        }
        l3.recoverComment4Web(new GuildFeedDetailWebViewFragment.f() { // from class: com.tencent.mobileqq.guild.feed.jsbridge.methods.detail.v
            @Override // com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment.f
            public final void onResult(String str) {
                w.q(w.this, str);
            }
        });
        return true;
    }
}
