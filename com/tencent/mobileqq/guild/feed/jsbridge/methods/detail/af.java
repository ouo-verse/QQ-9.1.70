package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/af;", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/c;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class af extends c {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "updateDetailJsonData";
    }

    @Override // ok1.a
    protected boolean o(@NotNull String url, @NotNull String pkgName, @NotNull String method) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        String g16 = g("feedId");
        String g17 = g("feedJson");
        long f16 = f("lastModifiedTime");
        if (!TextUtils.isEmpty(g16) && !TextUtils.isEmpty(g17)) {
            GuildFeedDetailDataCacheManager.y().J(g16, f16, g17);
            return true;
        }
        QLog.e("UpdateDetailJsonDataMethod", 1, "deleteDetailJsonData error for feedId is null or Json is null");
        return false;
    }
}
