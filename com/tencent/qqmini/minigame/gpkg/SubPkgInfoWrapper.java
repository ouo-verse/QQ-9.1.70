package com.tencent.qqmini.minigame.gpkg;

import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001b\u0010\f\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u0013\u0010\u000b\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqmini/minigame/gpkg/SubPkgInfoWrapper;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Lkotlin/Lazy;", "()Ljava/lang/String;", "name", "Lcom/tencent/qqmini/sdk/launcher/model/SubPkgInfo;", "b", "Lcom/tencent/qqmini/sdk/launcher/model/SubPkgInfo;", "d", "()Lcom/tencent/qqmini/sdk/launcher/model/SubPkgInfo;", "subPkgInfo", "c", "Ljava/lang/String;", "root", "savePath", "<init>", "(Lcom/tencent/qqmini/sdk/launcher/model/SubPkgInfo;Ljava/lang/String;Ljava/lang/String;)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final /* data */ class SubPkgInfoWrapper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final SubPkgInfo subPkgInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String root;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String savePath;

    public SubPkgInfoWrapper(@NotNull SubPkgInfo subPkgInfo, @NotNull String root, @NotNull String savePath) {
        Lazy lazy;
        Intrinsics.checkParameterIsNotNull(subPkgInfo, "subPkgInfo");
        Intrinsics.checkParameterIsNotNull(root, "root");
        Intrinsics.checkParameterIsNotNull(savePath, "savePath");
        this.subPkgInfo = subPkgInfo;
        this.root = root;
        this.savePath = savePath;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.qqmini.minigame.gpkg.SubPkgInfoWrapper$name$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return SubPkgInfoWrapper.this.getSubPkgInfo().getPureSubPkgName();
            }
        });
        this.name = lazy;
    }

    @NotNull
    public final String a() {
        return (String) this.name.getValue();
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getRoot() {
        return this.root;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getSavePath() {
        return this.savePath;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final SubPkgInfo getSubPkgInfo() {
        return this.subPkgInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SubPkgInfoWrapper) {
                SubPkgInfoWrapper subPkgInfoWrapper = (SubPkgInfoWrapper) other;
                if (!Intrinsics.areEqual(this.subPkgInfo, subPkgInfoWrapper.subPkgInfo) || !Intrinsics.areEqual(this.root, subPkgInfoWrapper.root) || !Intrinsics.areEqual(this.savePath, subPkgInfoWrapper.savePath)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        SubPkgInfo subPkgInfo = this.subPkgInfo;
        int i17 = 0;
        if (subPkgInfo != null) {
            i3 = subPkgInfo.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        String str = this.root;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str2 = this.savePath;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "SubPkgInfoWrapper(subPkgInfo=" + this.subPkgInfo + ", root=" + this.root + ", savePath=" + this.savePath + ")";
    }
}
