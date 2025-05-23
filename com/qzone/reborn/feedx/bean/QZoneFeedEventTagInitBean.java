package com.qzone.reborn.feedx.bean;

import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/feedx/bean/QZoneFeedEventTagInitBean;", "Ljava/io/Serializable;", "eventTag", "", "pageFrom", "", "source", "source2", QZoneDTLoginReporter.SCHEMA, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getEventTag", "()Ljava/lang/String;", "setEventTag", "(Ljava/lang/String;)V", "getPageFrom", "()Ljava/lang/Integer;", "setPageFrom", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSchema", "setSchema", "getSource", "setSource", "getSource2", "setSource2", "toString", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneFeedEventTagInitBean implements Serializable {
    private String eventTag;
    private Integer pageFrom;
    private String schema;
    private Integer source;
    private Integer source2;

    public QZoneFeedEventTagInitBean() {
        this(null, null, null, null, null, 31, null);
    }

    public final String getEventTag() {
        return this.eventTag;
    }

    public final Integer getPageFrom() {
        return this.pageFrom;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Integer getSource() {
        return this.source;
    }

    public final Integer getSource2() {
        return this.source2;
    }

    public final void setEventTag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eventTag = str;
    }

    public final void setPageFrom(Integer num) {
        this.pageFrom = num;
    }

    public final void setSchema(String str) {
        this.schema = str;
    }

    public final void setSource(Integer num) {
        this.source = num;
    }

    public final void setSource2(Integer num) {
        this.source2 = num;
    }

    public String toString() {
        return "QZoneFeedEventTagInitBean(eventTag=" + this.eventTag + ", pageFrom='" + this.pageFrom + "', source='" + this.source + "', source2='" + this.source2 + "', schema=" + this.schema + ")";
    }

    public QZoneFeedEventTagInitBean(String eventTag, Integer num, Integer num2, Integer num3, String str) {
        Intrinsics.checkNotNullParameter(eventTag, "eventTag");
        this.eventTag = eventTag;
        this.pageFrom = num;
        this.source = num2;
        this.source2 = num3;
        this.schema = str;
    }

    public /* synthetic */ QZoneFeedEventTagInitBean(String str, Integer num, Integer num2, Integer num3, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? -1 : num, (i3 & 4) != 0 ? -1 : num2, (i3 & 8) != 0 ? 6 : num3, (i3 & 16) != 0 ? "" : str2);
    }
}
