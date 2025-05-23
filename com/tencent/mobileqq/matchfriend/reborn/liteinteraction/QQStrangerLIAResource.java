package com.tencent.mobileqq.matchfriend.reborn.liteinteraction;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "emojiId", "", "b", "Ljava/lang/CharSequence;", "c", "()Ljava/lang/CharSequence;", "summary", "Ljava/lang/String;", "()Ljava/lang/String;", "label", "d", "textMsg", "<init>", "(ILjava/lang/CharSequence;Ljava/lang/String;Ljava/lang/CharSequence;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.f, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerLIAResource {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int emojiId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final CharSequence summary;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String label;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final CharSequence textMsg;

    public QQStrangerLIAResource() {
        this(0, null, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getEmojiId() {
        return this.emojiId;
    }

    /* renamed from: b, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: c, reason: from getter */
    public final CharSequence getSummary() {
        return this.summary;
    }

    /* renamed from: d, reason: from getter */
    public final CharSequence getTextMsg() {
        return this.textMsg;
    }

    public int hashCode() {
        return (((((this.emojiId * 31) + this.summary.hashCode()) * 31) + this.label.hashCode()) * 31) + this.textMsg.hashCode();
    }

    public String toString() {
        int i3 = this.emojiId;
        CharSequence charSequence = this.summary;
        return "QQStrangerLIAResource(emojiId=" + i3 + ", summary=" + ((Object) charSequence) + ", label=" + this.label + ", textMsg=" + ((Object) this.textMsg) + ")";
    }

    public QQStrangerLIAResource(int i3, CharSequence summary, String label, CharSequence textMsg) {
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(textMsg, "textMsg");
        this.emojiId = i3;
        this.summary = summary;
        this.label = label;
        this.textMsg = textMsg;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerLIAResource)) {
            return false;
        }
        QQStrangerLIAResource qQStrangerLIAResource = (QQStrangerLIAResource) other;
        return this.emojiId == qQStrangerLIAResource.emojiId && Intrinsics.areEqual(this.summary, qQStrangerLIAResource.summary) && Intrinsics.areEqual(this.label, qQStrangerLIAResource.label) && Intrinsics.areEqual(this.textMsg, qQStrangerLIAResource.textMsg);
    }

    public /* synthetic */ QQStrangerLIAResource(int i3, String str, String str2, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : str3);
    }
}
