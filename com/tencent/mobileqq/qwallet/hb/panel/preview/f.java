package com.tencent.mobileqq.qwallet.hb.panel.preview;

import com.tencent.mobileqq.activity.aio.p;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000e\u001a\u00020\u0006R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/preview/f;", "", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "", "hbType", "", "e", "a", "f", "", "guildId", "subGuildId", "g", "b", "Lcom/tencent/mobileqq/activity/aio/p;", "currentPanelSessionInfo", "c", "I", "currentPanelHbType", "d", "currentSendHbSessionInfo", "currentSendHbType", "()Lcom/tencent/mobileqq/activity/aio/p;", "currentSessionInfo", "()I", "currentHbType", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static p currentPanelSessionInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static p currentSendHbSessionInfo;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f277592a = new f();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int currentPanelHbType = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int currentSendHbType = -1;

    f() {
    }

    public final void a() {
        currentPanelSessionInfo = null;
        currentPanelHbType = -1;
    }

    public final void b() {
        currentSendHbSessionInfo = null;
        currentSendHbType = -1;
    }

    public final int c() {
        int i3 = currentSendHbType;
        if (i3 == -1) {
            return currentPanelHbType;
        }
        return i3;
    }

    @Nullable
    public final p d() {
        p pVar = currentSendHbSessionInfo;
        if (pVar == null) {
            return currentPanelSessionInfo;
        }
        return pVar;
    }

    public final void e(@Nullable p sessionInfo, int hbType) {
        currentPanelSessionInfo = sessionInfo;
        currentPanelHbType = hbType;
    }

    public final void f() {
        currentSendHbSessionInfo = currentPanelSessionInfo;
        currentSendHbType = currentPanelHbType;
    }

    public final void g(@Nullable String guildId, @Nullable String subGuildId) {
        boolean z16;
        boolean z17 = false;
        if (guildId != null && guildId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (subGuildId == null || subGuildId.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                p pVar = new p();
                pVar.f179555d = 10014;
                pVar.f179559f = guildId;
                pVar.f179557e = subGuildId;
                currentSendHbSessionInfo = pVar;
                currentSendHbType = 1;
            }
        }
    }
}
