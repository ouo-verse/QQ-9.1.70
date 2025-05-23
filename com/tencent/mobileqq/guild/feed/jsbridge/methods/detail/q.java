package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import android.util.Log;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/q;", "Lcom/tencent/mobileqq/guild/feed/jsbridge/methods/detail/c;", "", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "o", "k", tl.h.F, "Ljava/lang/String;", "KEY_FEED_ID", "i", "KER_COMMENDTS", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class q extends c {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KEY_FEED_ID = "feedId";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String KER_COMMENDTS = "comments";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @NotNull
    public String k() {
        return "updateHotCommentData";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    @Override // ok1.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean o(@Nullable String url, @Nullable String pkgName, @Nullable String method) {
        boolean z16;
        boolean z17;
        boolean isBlank;
        boolean isBlank2;
        if (l() == null) {
            return false;
        }
        String g16 = g(this.KEY_FEED_ID);
        String g17 = g(this.KER_COMMENDTS);
        if (g16 != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(g16);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (g17 != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(g17);
                        if (!isBlank) {
                            z17 = false;
                            if (!z17) {
                                Logger logger = Logger.f235387a;
                                if (QLog.isDevelopLevel()) {
                                    Log.d("GuildUpdateHotCommentOperation", "receive feedId=" + g16 + " comments=" + g17);
                                }
                                return true;
                            }
                        }
                    }
                    z17 = true;
                    if (!z17) {
                    }
                }
                Logger.f235387a.d().w("GuildUpdateHotCommentOperation", 1, "receive " + k() + " feedId=" + g16 + " comments=" + g17);
                return false;
            }
        }
        z16 = true;
        if (!z16) {
        }
        Logger.f235387a.d().w("GuildUpdateHotCommentOperation", 1, "receive " + k() + " feedId=" + g16 + " comments=" + g17);
        return false;
    }
}
