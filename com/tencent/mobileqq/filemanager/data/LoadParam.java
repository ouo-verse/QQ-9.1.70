package com.tencent.mobileqq.filemanager.data;

import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0010\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/filemanager/data/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/filemanager/widget/QfileTabBarView$h;", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "scanParams", "b", "Z", "()Z", "includeSystemMediaStorage", "I", "()I", "mediaFlag", "<init>", "(Ljava/util/List;ZI)V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.filemanager.data.k, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class LoadParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<QfileTabBarView.h> scanParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean includeSystemMediaStorage;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int mediaFlag;

    /* JADX WARN: Multi-variable type inference failed */
    public LoadParam(@NotNull List<? extends QfileTabBarView.h> scanParams, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(scanParams, "scanParams");
        this.scanParams = scanParams;
        this.includeSystemMediaStorage = z16;
        this.mediaFlag = i3;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIncludeSystemMediaStorage() {
        return this.includeSystemMediaStorage;
    }

    /* renamed from: b, reason: from getter */
    public final int getMediaFlag() {
        return this.mediaFlag;
    }

    @NotNull
    public final List<QfileTabBarView.h> c() {
        return this.scanParams;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadParam)) {
            return false;
        }
        LoadParam loadParam = (LoadParam) other;
        if (Intrinsics.areEqual(this.scanParams, loadParam.scanParams) && this.includeSystemMediaStorage == loadParam.includeSystemMediaStorage && this.mediaFlag == loadParam.mediaFlag) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.scanParams.hashCode() * 31;
        boolean z16 = this.includeSystemMediaStorage;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.mediaFlag;
    }

    @NotNull
    public String toString() {
        return "LoadParam(scanParams=" + this.scanParams + ", includeSystemMediaStorage=" + this.includeSystemMediaStorage + ", mediaFlag=" + this.mediaFlag + ')';
    }
}
