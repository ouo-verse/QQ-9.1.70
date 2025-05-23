package com.tencent.biz.richframework.layoutinflater;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R(\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\fR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000e\u00a8\u0006&"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "", "", "toString", "", "hashCode", "other", "", "equals", "resName", "Ljava/lang/String;", "getResName", "()Ljava/lang/String;", "setResName", "(Ljava/lang/String;)V", "isMergeRes", "Z", "()Z", "Ljava/lang/Class;", "customContextClass", "Ljava/lang/Class;", "getCustomContextClass", "()Ljava/lang/Class;", "setCustomContextClass", "(Ljava/lang/Class;)V", "resId", "I", "getResId", "()I", "setResId", "(I)V", "parentViewClassName", "getParentViewClassName", "itemLayoutManager", "getItemLayoutManager", "setItemLayoutManager", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final /* data */ class PreloadRequest {

    @Nullable
    private Class<?> customContextClass;
    private final boolean isMergeRes;

    @NotNull
    private String itemLayoutManager;

    @NotNull
    private final String parentViewClassName;
    private int resId;

    @NotNull
    private String resName;

    @JvmOverloads
    public PreloadRequest() {
        this(0, null, null, 7, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PreloadRequest) {
                PreloadRequest preloadRequest = (PreloadRequest) other;
                if (this.resId != preloadRequest.resId || !Intrinsics.areEqual(this.parentViewClassName, preloadRequest.parentViewClassName) || !Intrinsics.areEqual(this.itemLayoutManager, preloadRequest.itemLayoutManager)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Class<?> getCustomContextClass() {
        return this.customContextClass;
    }

    @NotNull
    public final String getItemLayoutManager() {
        return this.itemLayoutManager;
    }

    @NotNull
    public final String getParentViewClassName() {
        return this.parentViewClassName;
    }

    public final int getResId() {
        return this.resId;
    }

    @NotNull
    public final String getResName() {
        return this.resName;
    }

    public int hashCode() {
        int i3;
        int i16 = this.resId * 31;
        String str = this.parentViewClassName;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i16 + i3) * 31;
        String str2 = this.itemLayoutManager;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return i18 + i17;
    }

    /* renamed from: isMergeRes, reason: from getter */
    public final boolean getIsMergeRes() {
        return this.isMergeRes;
    }

    public final void setCustomContextClass(@Nullable Class<?> cls) {
        this.customContextClass = cls;
    }

    public final void setResName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resName = str;
    }

    @NotNull
    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("PreloadRequest(resId=");
        sb5.append(this.resId);
        sb5.append(", parentViewClassName='");
        sb5.append(this.parentViewClassName);
        sb5.append("', itemLayoutManager='");
        sb5.append(this.itemLayoutManager);
        sb5.append("', resName='");
        sb5.append(this.resName);
        sb5.append("', isMergeRes=");
        sb5.append(this.isMergeRes);
        sb5.append(", customContextClass=");
        Class<?> cls = this.customContextClass;
        if (cls != null) {
            str = cls.getName();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(')');
        return sb5.toString();
    }

    @JvmOverloads
    public PreloadRequest(int i3, @NotNull String parentViewClassName, @NotNull String itemLayoutManager) {
        Intrinsics.checkNotNullParameter(parentViewClassName, "parentViewClassName");
        Intrinsics.checkNotNullParameter(itemLayoutManager, "itemLayoutManager");
        this.resId = i3;
        this.parentViewClassName = parentViewClassName;
        this.itemLayoutManager = itemLayoutManager;
        this.resName = "";
    }

    public /* synthetic */ PreloadRequest(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2);
    }
}
