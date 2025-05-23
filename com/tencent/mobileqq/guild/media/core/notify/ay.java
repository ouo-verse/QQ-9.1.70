package com.tencent.mobileqq.guild.media.core.notify;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/ay;", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "", "d", "Z", "b", "()Z", "isSend", "", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "input", "<init>", "(ZLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ay implements x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isSend;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String input;

    public ay() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getInput() {
        return this.input;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsSend() {
        return this.isSend;
    }

    public ay(boolean z16, @NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.isSend = z16;
        this.input = input;
    }

    public /* synthetic */ ay(boolean z16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? "" : str);
    }
}
