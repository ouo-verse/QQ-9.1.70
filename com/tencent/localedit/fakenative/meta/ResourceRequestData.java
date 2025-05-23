package com.tencent.localedit.fakenative.meta;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J<\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001eJ\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/tencent/localedit/fakenative/meta/ResourceRequestData;", "", "fileBytes", "", WadlProxyConsts.PARAM_FILENAME, "", "fileSize", "", "globalPadId", "([BLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getFileBytes", "()[B", "getFileName", "()Ljava/lang/String;", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getGlobalPadId", "component1", "component2", "component3", "component4", "copy", "([BLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/tencent/localedit/fakenative/meta/ResourceRequestData;", "equals", "", "other", "hashCode", "", "toMap", "", "toString", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class ResourceRequestData {

    @Nullable
    private final byte[] fileBytes;

    @Nullable
    private final String fileName;

    @Nullable
    private final Long fileSize;

    @NotNull
    private final String globalPadId;

    public ResourceRequestData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ResourceRequestData copy$default(ResourceRequestData resourceRequestData, byte[] bArr, String str, Long l3, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bArr = resourceRequestData.fileBytes;
        }
        if ((i3 & 2) != 0) {
            str = resourceRequestData.fileName;
        }
        if ((i3 & 4) != 0) {
            l3 = resourceRequestData.fileSize;
        }
        if ((i3 & 8) != 0) {
            str2 = resourceRequestData.globalPadId;
        }
        return resourceRequestData.copy(bArr, str, l3, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final byte[] getFileBytes() {
        return this.fileBytes;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getFileSize() {
        return this.fileSize;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getGlobalPadId() {
        return this.globalPadId;
    }

    @NotNull
    public final ResourceRequestData copy(@Nullable byte[] fileBytes, @Nullable String fileName, @Nullable Long fileSize, @NotNull String globalPadId) {
        Intrinsics.checkNotNullParameter(globalPadId, "globalPadId");
        return new ResourceRequestData(fileBytes, fileName, fileSize, globalPadId);
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other == null) {
            cls = null;
        } else {
            cls = other.getClass();
        }
        if (!Intrinsics.areEqual(ResourceRequestData.class, cls)) {
            return false;
        }
        if (other != null) {
            ResourceRequestData resourceRequestData = (ResourceRequestData) other;
            if (Arrays.equals(this.fileBytes, resourceRequestData.fileBytes) && Intrinsics.areEqual(this.fileName, resourceRequestData.fileName)) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.localedit.fakenative.meta.ResourceRequestData");
    }

    @Nullable
    public final byte[] getFileBytes() {
        return this.fileBytes;
    }

    @Nullable
    public final String getFileName() {
        return this.fileName;
    }

    @Nullable
    public final Long getFileSize() {
        return this.fileSize;
    }

    @NotNull
    public final String getGlobalPadId() {
        return this.globalPadId;
    }

    public int hashCode() {
        return Arrays.hashCode(this.fileBytes);
    }

    @NotNull
    public final Map<String, Object> toMap() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("fileBytes", this.fileBytes), TuplesKt.to(WadlProxyConsts.PARAM_FILENAME, this.fileName), TuplesKt.to("fileSize", this.fileSize), TuplesKt.to("globalPadId", this.globalPadId));
        return mapOf;
    }

    @NotNull
    public String toString() {
        List list;
        list = MapsKt___MapsKt.toList(toMap());
        return list.toString();
    }

    public ResourceRequestData(@Nullable byte[] bArr, @Nullable String str, @Nullable Long l3, @NotNull String globalPadId) {
        Intrinsics.checkNotNullParameter(globalPadId, "globalPadId");
        this.fileBytes = bArr;
        this.fileName = str;
        this.fileSize = l3;
        this.globalPadId = globalPadId;
    }

    public /* synthetic */ ResourceRequestData(byte[] bArr, String str, Long l3, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bArr, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : l3, (i3 & 8) != 0 ? String.valueOf(UUID.randomUUID()) : str2);
    }
}
