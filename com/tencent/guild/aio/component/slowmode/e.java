package com.tencent.guild.aio.component.slowmode;

import com.tencent.mvi.base.route.k;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/e;", "Lcom/tencent/mvi/base/route/k;", "", "a", "Z", "()Z", "isLimited", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e implements k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isLimited;

    public e(boolean z16) {
        this.isLimited = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIsLimited() {
        return this.isLimited;
    }
}
