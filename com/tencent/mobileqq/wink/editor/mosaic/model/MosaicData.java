package com.tencent.mobileqq.wink.editor.mosaic.model;

import com.tencent.mobileqq.wink.mosaic.model.MosaicLinePath;
import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB/\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J5\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R$\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/editor/mosaic/model/MosaicData;", "Ljava/io/Serializable;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/wink/mosaic/model/MosaicLinePath;", "component1", "component2", "", "component3", "pathList", "undoPathList", "resultPath", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getPathList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "getUndoPathList", "Ljava/lang/String;", "getResultPath", "()Ljava/lang/String;", "setResultPath", "(Ljava/lang/String;)V", "<init>", "(Ljava/util/concurrent/CopyOnWriteArrayList;Ljava/util/concurrent/CopyOnWriteArrayList;Ljava/lang/String;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class MosaicData implements Serializable {
    private static final long serialVersionUID = 599093123447237757L;

    @NotNull
    private final CopyOnWriteArrayList<MosaicLinePath> pathList;

    @Nullable
    private String resultPath;

    @NotNull
    private final CopyOnWriteArrayList<MosaicLinePath> undoPathList;

    public MosaicData(@NotNull CopyOnWriteArrayList<MosaicLinePath> pathList, @NotNull CopyOnWriteArrayList<MosaicLinePath> undoPathList, @Nullable String str) {
        Intrinsics.checkNotNullParameter(pathList, "pathList");
        Intrinsics.checkNotNullParameter(undoPathList, "undoPathList");
        this.pathList = pathList;
        this.undoPathList = undoPathList;
        this.resultPath = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MosaicData copy$default(MosaicData mosaicData, CopyOnWriteArrayList copyOnWriteArrayList, CopyOnWriteArrayList copyOnWriteArrayList2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            copyOnWriteArrayList = mosaicData.pathList;
        }
        if ((i3 & 2) != 0) {
            copyOnWriteArrayList2 = mosaicData.undoPathList;
        }
        if ((i3 & 4) != 0) {
            str = mosaicData.resultPath;
        }
        return mosaicData.copy(copyOnWriteArrayList, copyOnWriteArrayList2, str);
    }

    @NotNull
    public final CopyOnWriteArrayList<MosaicLinePath> component1() {
        return this.pathList;
    }

    @NotNull
    public final CopyOnWriteArrayList<MosaicLinePath> component2() {
        return this.undoPathList;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getResultPath() {
        return this.resultPath;
    }

    @NotNull
    public final MosaicData copy(@NotNull CopyOnWriteArrayList<MosaicLinePath> pathList, @NotNull CopyOnWriteArrayList<MosaicLinePath> undoPathList, @Nullable String resultPath) {
        Intrinsics.checkNotNullParameter(pathList, "pathList");
        Intrinsics.checkNotNullParameter(undoPathList, "undoPathList");
        return new MosaicData(pathList, undoPathList, resultPath);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MosaicData)) {
            return false;
        }
        MosaicData mosaicData = (MosaicData) other;
        if (Intrinsics.areEqual(this.pathList, mosaicData.pathList) && Intrinsics.areEqual(this.undoPathList, mosaicData.undoPathList) && Intrinsics.areEqual(this.resultPath, mosaicData.resultPath)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final CopyOnWriteArrayList<MosaicLinePath> getPathList() {
        return this.pathList;
    }

    @Nullable
    public final String getResultPath() {
        return this.resultPath;
    }

    @NotNull
    public final CopyOnWriteArrayList<MosaicLinePath> getUndoPathList() {
        return this.undoPathList;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.pathList.hashCode() * 31) + this.undoPathList.hashCode()) * 31;
        String str = this.resultPath;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final void setResultPath(@Nullable String str) {
        this.resultPath = str;
    }

    @NotNull
    public String toString() {
        return "MosaicData(pathList=" + this.pathList + ", undoPathList=" + this.undoPathList + ", resultPath=" + this.resultPath + ")";
    }

    public /* synthetic */ MosaicData(CopyOnWriteArrayList copyOnWriteArrayList, CopyOnWriteArrayList copyOnWriteArrayList2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(copyOnWriteArrayList, copyOnWriteArrayList2, (i3 & 4) != 0 ? null : str);
    }
}
