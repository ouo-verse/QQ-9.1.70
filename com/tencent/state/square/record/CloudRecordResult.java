package com.tencent.state.square.record;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\bH\u00c6\u0003J\t\u0010 \u001a\u00020\bH\u00c6\u0003J\t\u0010!\u001a\u00020\bH\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001J\t\u0010)\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012\u00a8\u0006*"}, d2 = {"Lcom/tencent/state/square/record/CloudRecordResult;", "", "type", "", "actionId", IECDtReport.ACTION_IDENTIFIER, "Lcom/tencent/state/square/record/RecordIdentifier;", "url", "", "md5", "coverUrl", "coverMd5", "recordWidth", "recordHeight", "(IILcom/tencent/state/square/record/RecordIdentifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getActionId", "()I", "getCoverMd5", "()Ljava/lang/String;", "getCoverUrl", "getIdentifier", "()Lcom/tencent/state/square/record/RecordIdentifier;", "getMd5", "getRecordHeight", "getRecordWidth", "getType", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class CloudRecordResult {
    private final int actionId;

    @NotNull
    private final String coverMd5;

    @NotNull
    private final String coverUrl;

    @NotNull
    private final RecordIdentifier identifier;

    @NotNull
    private final String md5;
    private final int recordHeight;
    private final int recordWidth;
    private final int type;

    @NotNull
    private final String url;

    public CloudRecordResult(int i3, int i16, @NotNull RecordIdentifier identifier, @NotNull String url, @NotNull String md5, @NotNull String coverUrl, @NotNull String coverMd5, int i17, int i18) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(coverMd5, "coverMd5");
        this.type = i3;
        this.actionId = i16;
        this.identifier = identifier;
        this.url = url;
        this.md5 = md5;
        this.coverUrl = coverUrl;
        this.coverMd5 = coverMd5;
        this.recordWidth = i17;
        this.recordHeight = i18;
    }

    public static /* synthetic */ CloudRecordResult copy$default(CloudRecordResult cloudRecordResult, int i3, int i16, RecordIdentifier recordIdentifier, String str, String str2, String str3, String str4, int i17, int i18, int i19, Object obj) {
        int i26;
        int i27;
        RecordIdentifier recordIdentifier2;
        String str5;
        String str6;
        String str7;
        String str8;
        int i28;
        int i29;
        if ((i19 & 1) != 0) {
            i26 = cloudRecordResult.type;
        } else {
            i26 = i3;
        }
        if ((i19 & 2) != 0) {
            i27 = cloudRecordResult.actionId;
        } else {
            i27 = i16;
        }
        if ((i19 & 4) != 0) {
            recordIdentifier2 = cloudRecordResult.identifier;
        } else {
            recordIdentifier2 = recordIdentifier;
        }
        if ((i19 & 8) != 0) {
            str5 = cloudRecordResult.url;
        } else {
            str5 = str;
        }
        if ((i19 & 16) != 0) {
            str6 = cloudRecordResult.md5;
        } else {
            str6 = str2;
        }
        if ((i19 & 32) != 0) {
            str7 = cloudRecordResult.coverUrl;
        } else {
            str7 = str3;
        }
        if ((i19 & 64) != 0) {
            str8 = cloudRecordResult.coverMd5;
        } else {
            str8 = str4;
        }
        if ((i19 & 128) != 0) {
            i28 = cloudRecordResult.recordWidth;
        } else {
            i28 = i17;
        }
        if ((i19 & 256) != 0) {
            i29 = cloudRecordResult.recordHeight;
        } else {
            i29 = i18;
        }
        return cloudRecordResult.copy(i26, i27, recordIdentifier2, str5, str6, str7, str8, i28, i29);
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final RecordIdentifier getIdentifier() {
        return this.identifier;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getCoverMd5() {
        return this.coverMd5;
    }

    /* renamed from: component8, reason: from getter */
    public final int getRecordWidth() {
        return this.recordWidth;
    }

    /* renamed from: component9, reason: from getter */
    public final int getRecordHeight() {
        return this.recordHeight;
    }

    @NotNull
    public final CloudRecordResult copy(int type, int actionId, @NotNull RecordIdentifier identifier, @NotNull String url, @NotNull String md5, @NotNull String coverUrl, @NotNull String coverMd5, int recordWidth, int recordHeight) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(coverMd5, "coverMd5");
        return new CloudRecordResult(type, actionId, identifier, url, md5, coverUrl, coverMd5, recordWidth, recordHeight);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof CloudRecordResult) {
                CloudRecordResult cloudRecordResult = (CloudRecordResult) other;
                if (this.type != cloudRecordResult.type || this.actionId != cloudRecordResult.actionId || !Intrinsics.areEqual(this.identifier, cloudRecordResult.identifier) || !Intrinsics.areEqual(this.url, cloudRecordResult.url) || !Intrinsics.areEqual(this.md5, cloudRecordResult.md5) || !Intrinsics.areEqual(this.coverUrl, cloudRecordResult.coverUrl) || !Intrinsics.areEqual(this.coverMd5, cloudRecordResult.coverMd5) || this.recordWidth != cloudRecordResult.recordWidth || this.recordHeight != cloudRecordResult.recordHeight) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getActionId() {
        return this.actionId;
    }

    @NotNull
    public final String getCoverMd5() {
        return this.coverMd5;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final RecordIdentifier getIdentifier() {
        return this.identifier;
    }

    @NotNull
    public final String getMd5() {
        return this.md5;
    }

    public final int getRecordHeight() {
        return this.recordHeight;
    }

    public final int getRecordWidth() {
        return this.recordWidth;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = ((this.type * 31) + this.actionId) * 31;
        RecordIdentifier recordIdentifier = this.identifier;
        int i26 = 0;
        if (recordIdentifier != null) {
            i3 = recordIdentifier.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = (i19 + i3) * 31;
        String str = this.url;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        String str2 = this.md5;
        if (str2 != null) {
            i17 = str2.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        String str3 = this.coverUrl;
        if (str3 != null) {
            i18 = str3.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (i29 + i18) * 31;
        String str4 = this.coverMd5;
        if (str4 != null) {
            i26 = str4.hashCode();
        }
        return ((((i36 + i26) * 31) + this.recordWidth) * 31) + this.recordHeight;
    }

    @NotNull
    public String toString() {
        return "CloudRecordResult(type=" + this.type + ", actionId=" + this.actionId + ", identifier=" + this.identifier + ", url=" + this.url + ", md5=" + this.md5 + ", coverUrl=" + this.coverUrl + ", coverMd5=" + this.coverMd5 + ", recordWidth=" + this.recordWidth + ", recordHeight=" + this.recordHeight + ")";
    }

    public /* synthetic */ CloudRecordResult(int i3, int i16, RecordIdentifier recordIdentifier, String str, String str2, String str3, String str4, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 0 : i3, i16, recordIdentifier, str, str2, str3, str4, i17, i18);
    }
}
