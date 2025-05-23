package com.qzone.publish.business.model.intimate;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u001b\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskParams;", "Ljava/io/Serializable;", "", "component1", "component2", "type", "exactType", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getType", "()I", "setType", "(I)V", "getExactType", "setExactType", "<init>", "(II)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final /* data */ class IntimateUploadTaskParams implements Serializable {
    private static final long serialVersionUID = 1948538260691651090L;
    private int exactType;
    private int type;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IntimateUploadTaskParams() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final int getExactType() {
        return this.exactType;
    }

    public final IntimateUploadTaskParams copy(int type, int exactType) {
        return new IntimateUploadTaskParams(type, exactType);
    }

    public final int getExactType() {
        return this.exactType;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type * 31) + this.exactType;
    }

    public final void setExactType(int i3) {
        this.exactType = i3;
    }

    public final void setType(int i3) {
        this.type = i3;
    }

    public String toString() {
        return "IntimateUploadTaskParams(type=" + this.type + ", exactType=" + this.exactType + ")";
    }

    public IntimateUploadTaskParams(int i3, int i16) {
        this.type = i3;
        this.exactType = i16;
    }

    public /* synthetic */ IntimateUploadTaskParams(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? -1 : i3, (i17 & 2) != 0 ? -1 : i16);
    }

    public static /* synthetic */ IntimateUploadTaskParams copy$default(IntimateUploadTaskParams intimateUploadTaskParams, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = intimateUploadTaskParams.type;
        }
        if ((i17 & 2) != 0) {
            i16 = intimateUploadTaskParams.exactType;
        }
        return intimateUploadTaskParams.copy(i3, i16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntimateUploadTaskParams)) {
            return false;
        }
        IntimateUploadTaskParams intimateUploadTaskParams = (IntimateUploadTaskParams) other;
        return this.type == intimateUploadTaskParams.type && this.exactType == intimateUploadTaskParams.exactType;
    }
}
