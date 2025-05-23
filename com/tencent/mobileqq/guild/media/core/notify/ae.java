package com.tencent.mobileqq.guild.media.core.notify;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/ae;", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "", "d", "Z", "a", "()Z", "canTalk", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ae implements x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean canTalk;

    public ae() {
        this(false, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCanTalk() {
        return this.canTalk;
    }

    public ae(boolean z16) {
        this.canTalk = z16;
    }

    public /* synthetic */ ae(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
