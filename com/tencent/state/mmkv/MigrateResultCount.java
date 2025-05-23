package com.tencent.state.mmkv;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/mmkv/MigrateResultCount;", "", "()V", "errorCount", "", "getErrorCount", "()I", "setErrorCount", "(I)V", "sourceNotExistCount", "getSourceNotExistCount", "setSourceNotExistCount", "successItemCount", "getSuccessItemCount", "setSuccessItemCount", "targetExistCount", "getTargetExistCount", "setTargetExistCount", "totalItemCount", "getTotalItemCount", "setTotalItemCount", "unSupportTypeCount", "getUnSupportTypeCount", "setUnSupportTypeCount", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
final class MigrateResultCount {
    private int errorCount;
    private int sourceNotExistCount;
    private int successItemCount;
    private int targetExistCount;
    private int totalItemCount;
    private int unSupportTypeCount;

    public final int getErrorCount() {
        return this.errorCount;
    }

    public final int getSourceNotExistCount() {
        return this.sourceNotExistCount;
    }

    public final int getSuccessItemCount() {
        return this.successItemCount;
    }

    public final int getTargetExistCount() {
        return this.targetExistCount;
    }

    public final int getTotalItemCount() {
        return this.totalItemCount;
    }

    public final int getUnSupportTypeCount() {
        return this.unSupportTypeCount;
    }

    public final void setErrorCount(int i3) {
        this.errorCount = i3;
    }

    public final void setSourceNotExistCount(int i3) {
        this.sourceNotExistCount = i3;
    }

    public final void setSuccessItemCount(int i3) {
        this.successItemCount = i3;
    }

    public final void setTargetExistCount(int i3) {
        this.targetExistCount = i3;
    }

    public final void setTotalItemCount(int i3) {
        this.totalItemCount = i3;
    }

    public final void setUnSupportTypeCount(int i3) {
        this.unSupportTypeCount = i3;
    }

    public String toString() {
        return "totalCount:" + this.totalItemCount + ", successCount:" + this.successItemCount + ", sourceNotExistCount:" + this.sourceNotExistCount + ", targetExistCount:" + this.targetExistCount + ", unSupportTypeCount:" + this.unSupportTypeCount + ", errorCount:" + this.errorCount;
    }
}
