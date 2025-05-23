package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.mobileqq.guild.data.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\f\u001a\u00060\u0004j\u0002`\u0005\u00a2\u0006\u0004\b\u001a\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R&\u0010\f\u001a\u00060\u0004j\u0002`\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0006\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/i;", "", "", "d", "Lcom/tencent/mobileqq/guild/data/o;", "Lcom/tencent/mobileqq/guild/feed/publish/api/MediumUploadTaskInfo;", "a", "Lcom/tencent/mobileqq/guild/data/o;", "b", "()Lcom/tencent/mobileqq/guild/data/o;", "g", "(Lcom/tencent/mobileqq/guild/data/o;)V", "referent", "", "Z", "c", "()Z", "f", "(Z)V", "isInconsistent", "", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "inconsistencyMessage", "<init>", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private o referent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isInconsistent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String inconsistencyMessage;

    public i(@NotNull o referent) {
        Intrinsics.checkNotNullParameter(referent, "referent");
        this.referent = referent;
        this.inconsistencyMessage = "";
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getInconsistencyMessage() {
        return this.inconsistencyMessage;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final o getReferent() {
        return this.referent;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsInconsistent() {
        return this.isInconsistent;
    }

    public final void d() {
        this.isInconsistent = false;
        this.inconsistencyMessage = "";
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.inconsistencyMessage = str;
    }

    public final void f(boolean z16) {
        this.isInconsistent = z16;
    }

    public final void g(@NotNull o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<set-?>");
        this.referent = oVar;
    }
}
