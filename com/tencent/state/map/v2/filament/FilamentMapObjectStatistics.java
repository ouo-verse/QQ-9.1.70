package com.tencent.state.map.v2.filament;

import com.tencent.filament.zplan.scene.square.SquareLoadObjectStatistics;
import com.tencent.state.square.avatar.filament.LoadFilamentAssetsStatistics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/map/v2/filament/FilamentMapObjectStatistics;", "", "sceneLoadStatistics", "Lcom/tencent/filament/zplan/scene/square/SquareLoadObjectStatistics;", "assetsLoadStatistics", "Lcom/tencent/state/square/avatar/filament/LoadFilamentAssetsStatistics;", "(Lcom/tencent/filament/zplan/scene/square/SquareLoadObjectStatistics;Lcom/tencent/state/square/avatar/filament/LoadFilamentAssetsStatistics;)V", "getAssetsLoadStatistics", "()Lcom/tencent/state/square/avatar/filament/LoadFilamentAssetsStatistics;", "setAssetsLoadStatistics", "(Lcom/tencent/state/square/avatar/filament/LoadFilamentAssetsStatistics;)V", "getSceneLoadStatistics", "()Lcom/tencent/filament/zplan/scene/square/SquareLoadObjectStatistics;", "setSceneLoadStatistics", "(Lcom/tencent/filament/zplan/scene/square/SquareLoadObjectStatistics;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final /* data */ class FilamentMapObjectStatistics {
    private LoadFilamentAssetsStatistics assetsLoadStatistics;
    private SquareLoadObjectStatistics sceneLoadStatistics;

    public FilamentMapObjectStatistics() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final SquareLoadObjectStatistics getSceneLoadStatistics() {
        return this.sceneLoadStatistics;
    }

    /* renamed from: component2, reason: from getter */
    public final LoadFilamentAssetsStatistics getAssetsLoadStatistics() {
        return this.assetsLoadStatistics;
    }

    public final FilamentMapObjectStatistics copy(SquareLoadObjectStatistics sceneLoadStatistics, LoadFilamentAssetsStatistics assetsLoadStatistics) {
        return new FilamentMapObjectStatistics(sceneLoadStatistics, assetsLoadStatistics);
    }

    public final LoadFilamentAssetsStatistics getAssetsLoadStatistics() {
        return this.assetsLoadStatistics;
    }

    public final SquareLoadObjectStatistics getSceneLoadStatistics() {
        return this.sceneLoadStatistics;
    }

    public int hashCode() {
        SquareLoadObjectStatistics squareLoadObjectStatistics = this.sceneLoadStatistics;
        int hashCode = (squareLoadObjectStatistics != null ? squareLoadObjectStatistics.hashCode() : 0) * 31;
        LoadFilamentAssetsStatistics loadFilamentAssetsStatistics = this.assetsLoadStatistics;
        return hashCode + (loadFilamentAssetsStatistics != null ? loadFilamentAssetsStatistics.hashCode() : 0);
    }

    public final void setAssetsLoadStatistics(LoadFilamentAssetsStatistics loadFilamentAssetsStatistics) {
        this.assetsLoadStatistics = loadFilamentAssetsStatistics;
    }

    public final void setSceneLoadStatistics(SquareLoadObjectStatistics squareLoadObjectStatistics) {
        this.sceneLoadStatistics = squareLoadObjectStatistics;
    }

    public String toString() {
        return "FilamentMapObjectStatistics(sceneLoadStatistics=" + this.sceneLoadStatistics + ", assetsLoadStatistics=" + this.assetsLoadStatistics + ")";
    }

    public FilamentMapObjectStatistics(SquareLoadObjectStatistics squareLoadObjectStatistics, LoadFilamentAssetsStatistics loadFilamentAssetsStatistics) {
        this.sceneLoadStatistics = squareLoadObjectStatistics;
        this.assetsLoadStatistics = loadFilamentAssetsStatistics;
    }

    public /* synthetic */ FilamentMapObjectStatistics(SquareLoadObjectStatistics squareLoadObjectStatistics, LoadFilamentAssetsStatistics loadFilamentAssetsStatistics, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : squareLoadObjectStatistics, (i3 & 2) != 0 ? null : loadFilamentAssetsStatistics);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilamentMapObjectStatistics)) {
            return false;
        }
        FilamentMapObjectStatistics filamentMapObjectStatistics = (FilamentMapObjectStatistics) other;
        return Intrinsics.areEqual(this.sceneLoadStatistics, filamentMapObjectStatistics.sceneLoadStatistics) && Intrinsics.areEqual(this.assetsLoadStatistics, filamentMapObjectStatistics.assetsLoadStatistics);
    }

    public static /* synthetic */ FilamentMapObjectStatistics copy$default(FilamentMapObjectStatistics filamentMapObjectStatistics, SquareLoadObjectStatistics squareLoadObjectStatistics, LoadFilamentAssetsStatistics loadFilamentAssetsStatistics, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            squareLoadObjectStatistics = filamentMapObjectStatistics.sceneLoadStatistics;
        }
        if ((i3 & 2) != 0) {
            loadFilamentAssetsStatistics = filamentMapObjectStatistics.assetsLoadStatistics;
        }
        return filamentMapObjectStatistics.copy(squareLoadObjectStatistics, loadFilamentAssetsStatistics);
    }
}
