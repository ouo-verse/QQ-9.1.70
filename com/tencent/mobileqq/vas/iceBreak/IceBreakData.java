package com.tencent.mobileqq.vas.iceBreak;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u000e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vas/iceBreak/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "content", "b", "I", "c", "()I", "templateId", "", "J", "getMsgId", "()J", "msgId", "d", "Z", "()Z", "isSender", "Lcom/tencent/mobileqq/vas/iceBreak/c;", "e", "Lcom/tencent/mobileqq/vas/iceBreak/c;", "()Lcom/tencent/mobileqq/vas/iceBreak/c;", "listener", "<init>", "(Ljava/lang/CharSequence;IJZLcom/tencent/mobileqq/vas/iceBreak/c;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.iceBreak.b, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class IceBreakData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CharSequence content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int templateId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long msgId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSender;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final c listener;

    public IceBreakData(@NotNull CharSequence content, int i3, long j3, boolean z16, @Nullable c cVar) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.templateId = i3;
        this.msgId = j3;
        this.isSender = z16;
        this.listener = cVar;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final CharSequence getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final c getListener() {
        return this.listener;
    }

    /* renamed from: c, reason: from getter */
    public final int getTemplateId() {
        return this.templateId;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsSender() {
        return this.isSender;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IceBreakData)) {
            return false;
        }
        IceBreakData iceBreakData = (IceBreakData) other;
        if (Intrinsics.areEqual(this.content, iceBreakData.content) && this.templateId == iceBreakData.templateId && this.msgId == iceBreakData.msgId && this.isSender == iceBreakData.isSender && Intrinsics.areEqual(this.listener, iceBreakData.listener)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.content.hashCode() * 31) + this.templateId) * 31) + androidx.fragment.app.a.a(this.msgId)) * 31;
        boolean z16 = this.isSender;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        c cVar = this.listener;
        if (cVar == null) {
            hashCode = 0;
        } else {
            hashCode = cVar.hashCode();
        }
        return i16 + hashCode;
    }

    @NotNull
    public String toString() {
        CharSequence charSequence = this.content;
        return "IceBreakData(content=" + ((Object) charSequence) + ", templateId=" + this.templateId + ", msgId=" + this.msgId + ", isSender=" + this.isSender + ", listener=" + this.listener + ")";
    }
}
