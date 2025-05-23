package com.tencent.mobileqq.wink.magicstudio.model;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCStatus$GetStatusReply;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\tB3\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\fR\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "btnString", "d", "subtitleString", "c", "I", "()I", "actionType", "schemaUrl", "e", "Z", "()Z", "f", "(Z)V", "isFromMultiSelectPage", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.magicstudio.model.e, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MagicStudioButtonInfo {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String btnString;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String subtitleString;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int actionType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String schemaUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isFromMultiSelectPage;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/e$a;", "", "", PoiListCacheRecord.WEIGHT_TYPE, "b", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "buttonResp", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "a", "MAGIC_STUDIO_ACTION_TYPE_CREATE", "I", "MAGIC_STUDIO_ACTION_TYPE_DISABLE", "MAGIC_STUDIO_ACTION_TYPE_NOTHING", "MAGIC_STUDIO_ACTION_TYPE_SCHEMA", "MAGIC_STUDIO_ACTION_TYPE_SHARE", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.model.e$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MagicStudioButtonInfo a(@NotNull ShadowAIGCStatus$GetStatusReply buttonResp) {
            Intrinsics.checkNotNullParameter(buttonResp, "buttonResp");
            String str = buttonResp.button_info.text.get();
            Intrinsics.checkNotNullExpressionValue(str, "buttonResp.button_info.text.get()");
            String str2 = buttonResp.button_info.description.get();
            Intrinsics.checkNotNullExpressionValue(str2, "buttonResp.button_info.description.get()");
            return new MagicStudioButtonInfo(str, str2, b(buttonResp.button_info.type.get()), buttonResp.button_info.detail.get(), false, 16, null);
        }

        public final int b(int r26) {
            if (r26 == 2) {
                return 2;
            }
            if (r26 == 1) {
                return 1;
            }
            if (r26 == 3) {
                return 3;
            }
            if (r26 == 4) {
                return 4;
            }
            return -1;
        }

        Companion() {
        }
    }

    public MagicStudioButtonInfo(@NotNull String btnString, @NotNull String subtitleString, int i3, @Nullable String str, boolean z16) {
        Intrinsics.checkNotNullParameter(btnString, "btnString");
        Intrinsics.checkNotNullParameter(subtitleString, "subtitleString");
        this.btnString = btnString;
        this.subtitleString = subtitleString;
        this.actionType = i3;
        this.schemaUrl = str;
        this.isFromMultiSelectPage = z16;
    }

    /* renamed from: a, reason: from getter */
    public final int getActionType() {
        return this.actionType;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getBtnString() {
        return this.btnString;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getSubtitleString() {
        return this.subtitleString;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsFromMultiSelectPage() {
        return this.isFromMultiSelectPage;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MagicStudioButtonInfo)) {
            return false;
        }
        MagicStudioButtonInfo magicStudioButtonInfo = (MagicStudioButtonInfo) other;
        if (Intrinsics.areEqual(this.btnString, magicStudioButtonInfo.btnString) && Intrinsics.areEqual(this.subtitleString, magicStudioButtonInfo.subtitleString) && this.actionType == magicStudioButtonInfo.actionType && Intrinsics.areEqual(this.schemaUrl, magicStudioButtonInfo.schemaUrl) && this.isFromMultiSelectPage == magicStudioButtonInfo.isFromMultiSelectPage) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        this.isFromMultiSelectPage = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.btnString.hashCode() * 31) + this.subtitleString.hashCode()) * 31) + this.actionType) * 31;
        String str = this.schemaUrl;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i3 = (hashCode2 + hashCode) * 31;
        boolean z16 = this.isFromMultiSelectPage;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    @NotNull
    public String toString() {
        return "MagicStudioButtonInfo(btnString=" + this.btnString + ", subtitleString=" + this.subtitleString + ", actionType=" + this.actionType + ", schemaUrl=" + this.schemaUrl + ", isFromMultiSelectPage=" + this.isFromMultiSelectPage + ")";
    }

    public /* synthetic */ MagicStudioButtonInfo(String str, String str2, int i3, String str3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, str3, (i16 & 16) != 0 ? false : z16);
    }
}
