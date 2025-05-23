package com.tencent.mobileqq.wink.magicstudio.model;

import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getTipID", "()Ljava/lang/String;", "tipID", "b", "getSchema", QZoneDTLoginReporter.SCHEMA, "c", "getText", "text", "d", "getTopic", "topic", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.magicstudio.model.g, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MagicStudioTip {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tipID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String schema;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String topic;

    public MagicStudioTip(@NotNull String tipID, @NotNull String schema, @NotNull String text, @NotNull String topic) {
        Intrinsics.checkNotNullParameter(tipID, "tipID");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(topic, "topic");
        this.tipID = tipID;
        this.schema = schema;
        this.text = text;
        this.topic = topic;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MagicStudioTip)) {
            return false;
        }
        MagicStudioTip magicStudioTip = (MagicStudioTip) other;
        if (Intrinsics.areEqual(this.tipID, magicStudioTip.tipID) && Intrinsics.areEqual(this.schema, magicStudioTip.schema) && Intrinsics.areEqual(this.text, magicStudioTip.text) && Intrinsics.areEqual(this.topic, magicStudioTip.topic)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.tipID.hashCode() * 31) + this.schema.hashCode()) * 31) + this.text.hashCode()) * 31) + this.topic.hashCode();
    }

    @NotNull
    public String toString() {
        return "MagicStudioTip(tipID=" + this.tipID + ", schema=" + this.schema + ", text=" + this.text + ", topic=" + this.topic + ")";
    }
}
