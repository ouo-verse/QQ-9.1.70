package com.tencent.biz.richframework.localupload.recommend.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016B!\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0017J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWClassifyInfo;", "", "other", "", "equals", "", "hashCode", "", "toString", "classifyId", "Ljava/lang/String;", "getClassifyId", "()Ljava/lang/String;", "setClassifyId", "(Ljava/lang/String;)V", "subClassifyId", "getSubClassifyId", "setSubClassifyId", "selectArg", "getSelectArg", "setSelectArg", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RFWClassifyInfo {

    @NotNull
    private String classifyId;

    @NotNull
    private String selectArg;

    @NotNull
    private String subClassifyId;

    public RFWClassifyInfo(@NotNull String classifyId) {
        Intrinsics.checkNotNullParameter(classifyId, "classifyId");
        this.subClassifyId = "";
        this.selectArg = "";
        this.classifyId = classifyId;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof RFWClassifyInfo)) {
            return false;
        }
        RFWClassifyInfo rFWClassifyInfo = (RFWClassifyInfo) other;
        if (!Intrinsics.areEqual(rFWClassifyInfo.classifyId, this.classifyId) || !Intrinsics.areEqual(rFWClassifyInfo.subClassifyId, this.subClassifyId) || !Intrinsics.areEqual(rFWClassifyInfo.selectArg, this.selectArg)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String getClassifyId() {
        return this.classifyId;
    }

    @NotNull
    public final String getSelectArg() {
        return this.selectArg;
    }

    @NotNull
    public final String getSubClassifyId() {
        return this.subClassifyId;
    }

    public int hashCode() {
        return this.classifyId.hashCode();
    }

    @NotNull
    public String toString() {
        return "RFWClassifyInfo{classifyId:" + this.classifyId + ",subClassifyId:" + this.subClassifyId + ",selectArg:" + this.selectArg + "}";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RFWClassifyInfo(@NotNull String classifyId, @NotNull String subClassifyId) {
        this(classifyId);
        Intrinsics.checkNotNullParameter(classifyId, "classifyId");
        Intrinsics.checkNotNullParameter(subClassifyId, "subClassifyId");
        this.subClassifyId = subClassifyId;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RFWClassifyInfo(@NotNull String classifyId, @NotNull String subClassifyId, @NotNull String selectArg) {
        this(classifyId, subClassifyId);
        Intrinsics.checkNotNullParameter(classifyId, "classifyId");
        Intrinsics.checkNotNullParameter(subClassifyId, "subClassifyId");
        Intrinsics.checkNotNullParameter(selectArg, "selectArg");
        this.selectArg = selectArg;
    }
}
