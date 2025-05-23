package com.tencent.richframework.gallery.delegate.outer;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/richframework/gallery/delegate/outer/InnerErrorInfo;", "", "", "toString", "", "hashCode", "other", "", "equals", "errorCode", "I", "getErrorCode", "()I", "<init>", "(I)V", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final /* data */ class InnerErrorInfo {
    private final int errorCode;

    public InnerErrorInfo(int i3) {
        this.errorCode = i3;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof InnerErrorInfo) || this.errorCode != ((InnerErrorInfo) other).errorCode) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public int hashCode() {
        return this.errorCode;
    }

    @NotNull
    public String toString() {
        return "InnerErrorInfo(errorCode=" + this.errorCode + ")";
    }
}
