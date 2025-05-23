package com.tencent.mobileqq.activity.qcircle.bubble;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/bubble/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "text", "c", "textColor", "Z", "()Z", "bold", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.activity.qcircle.bubble.g, reason: from toString */
/* loaded from: classes10.dex */
public final /* data */ class QCircleTabRedPointBubbleContentElement {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String textColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean bold;

    public QCircleTabRedPointBubbleContentElement(@NotNull String text, @NotNull String textColor, boolean z16) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        this.text = text;
        this.textColor = textColor;
        this.bold = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getBold() {
        return this.bold;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QCircleTabRedPointBubbleContentElement)) {
            return false;
        }
        QCircleTabRedPointBubbleContentElement qCircleTabRedPointBubbleContentElement = (QCircleTabRedPointBubbleContentElement) other;
        if (Intrinsics.areEqual(this.text, qCircleTabRedPointBubbleContentElement.text) && Intrinsics.areEqual(this.textColor, qCircleTabRedPointBubbleContentElement.textColor) && this.bold == qCircleTabRedPointBubbleContentElement.bold) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.text.hashCode() * 31) + this.textColor.hashCode()) * 31;
        boolean z16 = this.bold;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "QCircleTabRedPointBubbleContentElement(text=" + this.text + ", textColor=" + this.textColor + ", bold=" + this.bold + ")";
    }
}
