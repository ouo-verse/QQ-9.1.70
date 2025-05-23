package com.tencent.filament.zplan.avatar.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u001dB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\u0015\u001a\u00020\bH\u00c6\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/filament/zplan/avatar/exception/FetchFileException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "type", "Lcom/tencent/filament/zplan/avatar/exception/FetchFileException$Type;", "errorCode", "", "errorMessage", "", "url", "(Lcom/tencent/filament/zplan/avatar/exception/FetchFileException$Type;ILjava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "getType", "()Lcom/tencent/filament/zplan/avatar/exception/FetchFileException$Type;", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "Type", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class FetchFileException extends RuntimeException {
    private final int errorCode;

    @Nullable
    private final String errorMessage;

    @NotNull
    private final Type type;

    @NotNull
    private final String url;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/filament/zplan/avatar/exception/FetchFileException$Type;", "", "(Ljava/lang/String;I)V", "DOWNLOAD_FAIL", "UNZIP_FAIL", "FILE_NOT_FOUND", "FILE_IS_EMPTY", "FILE_IS_BROKEN", "VERIFY_FAIL", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public enum Type {
        DOWNLOAD_FAIL,
        UNZIP_FAIL,
        FILE_NOT_FOUND,
        FILE_IS_EMPTY,
        FILE_IS_BROKEN,
        VERIFY_FAIL
    }

    public /* synthetic */ FetchFileException(Type type, int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, i3, (i16 & 4) != 0 ? null : str, str2);
    }

    public static /* synthetic */ FetchFileException copy$default(FetchFileException fetchFileException, Type type, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            type = fetchFileException.type;
        }
        if ((i16 & 2) != 0) {
            i3 = fetchFileException.errorCode;
        }
        if ((i16 & 4) != 0) {
            str = fetchFileException.errorMessage;
        }
        if ((i16 & 8) != 0) {
            str2 = fetchFileException.url;
        }
        return fetchFileException.copy(type, i3, str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final FetchFileException copy(@NotNull Type type, int errorCode, @Nullable String errorMessage, @NotNull String url) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(url, "url");
        return new FetchFileException(type, errorCode, errorMessage, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof FetchFileException) {
                FetchFileException fetchFileException = (FetchFileException) other;
                if (!Intrinsics.areEqual(this.type, fetchFileException.type) || this.errorCode != fetchFileException.errorCode || !Intrinsics.areEqual(this.errorMessage, fetchFileException.errorMessage) || !Intrinsics.areEqual(this.url, fetchFileException.url)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i3;
        int i16;
        Type type = this.type;
        int i17 = 0;
        if (type != null) {
            i3 = type.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = ((i3 * 31) + this.errorCode) * 31;
        String str = this.errorMessage;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return i19 + i17;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        return "FetchFileException(type=" + this.type + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", url=" + this.url + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchFileException(@NotNull Type type, int i3, @Nullable String str, @NotNull String url) {
        super("fetch file failed, errorCode: " + i3 + ", errorMessage: " + str + ", url: " + url);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(url, "url");
        this.type = type;
        this.errorCode = i3;
        this.errorMessage = str;
        this.url = url;
    }
}
