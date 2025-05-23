package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import android.os.Bundle;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/o;", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/c;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class o extends c {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final String f220024i = "stage";

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final String f220025m = "feedInfos";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "exposeRecommends";
    }

    @Override // ok1.a
    protected boolean o(@Nullable String url, @Nullable String pkgName, @Nullable String method) {
        boolean z16;
        if (l() == null) {
            return false;
        }
        String g16 = g(f220024i);
        String g17 = g(f220025m);
        if (g17 != null && g17.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildFeedsExposeRecommendsMethod", 2, "stage = " + g16 + ", feedInfos is empty");
            }
            return false;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildFeedsExposeRecommendsMethod", 2, "stage = " + g16 + ", feedInfos =" + g17);
        }
        Bundle bundle = new Bundle();
        bundle.putString("stage", g16);
        bundle.putString("info", g17);
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "action_to_expose_recommend", bundle);
        return true;
    }
}
