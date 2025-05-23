package com.tencent.state.map;

import android.graphics.Rect;
import com.tencent.state.map.IMapLocator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/map/MapBaseLocator;", "Lcom/tencent/state/map/IMapLocator;", "()V", "mCenterIndex", "", "getMCenterIndex", "()I", "setMCenterIndex", "(I)V", "mMapHeight", "getMMapHeight", "setMMapHeight", "mMapWidth", "getMMapWidth", "setMMapWidth", "viewPort", "Landroid/graphics/Rect;", "getViewPort", "()Landroid/graphics/Rect;", "getCenterIndex", "getMapHeight", "getMapWidth", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public abstract class MapBaseLocator implements IMapLocator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Location DEFAULT_LOCATION = new Location(0, 0, 0, 0, 0, 0, 48, null);
    private static final Rect DEFAULT_POSITION = new Rect();
    private int mCenterIndex;
    private int mMapHeight;
    private int mMapWidth;
    private final Rect viewPort = new Rect();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/map/MapBaseLocator$Companion;", "", "()V", "DEFAULT_LOCATION", "Lcom/tencent/state/map/Location;", "getDEFAULT_LOCATION$annotations", "getDEFAULT_LOCATION", "()Lcom/tencent/state/map/Location;", "DEFAULT_POSITION", "Landroid/graphics/Rect;", "getDEFAULT_POSITION$annotations", "getDEFAULT_POSITION", "()Landroid/graphics/Rect;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class Companion {
        Companion() {
        }

        public final Location getDEFAULT_LOCATION() {
            return MapBaseLocator.DEFAULT_LOCATION;
        }

        public final Rect getDEFAULT_POSITION() {
            return MapBaseLocator.DEFAULT_POSITION;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getDEFAULT_LOCATION$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getDEFAULT_POSITION$annotations() {
        }
    }

    public static final Location getDEFAULT_LOCATION() {
        return DEFAULT_LOCATION;
    }

    public static final Rect getDEFAULT_POSITION() {
        return DEFAULT_POSITION;
    }

    @Override // com.tencent.state.map.IMapLocator
    public void addItemLocation(int i3, MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        IMapLocator.DefaultImpls.addItemLocation(this, i3, data);
    }

    @Override // com.tencent.state.map.IMapLocator
    /* renamed from: getCenterIndex, reason: from getter */
    public int getMCenterIndex() {
        return this.mCenterIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMCenterIndex() {
        return this.mCenterIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMMapHeight() {
        return this.mMapHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getMMapWidth() {
        return this.mMapWidth;
    }

    @Override // com.tencent.state.map.IMapLocator
    public int getMapHeight() {
        return this.mMapHeight;
    }

    @Override // com.tencent.state.map.IMapLocator
    public int getMapWidth() {
        return this.mMapWidth;
    }

    @Override // com.tencent.state.map.IMapLocator
    public Rect getViewPort() {
        return this.viewPort;
    }

    @Override // com.tencent.state.map.IMapLocator
    public void setItemLocation(int i3, MapItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        IMapLocator.DefaultImpls.setItemLocation(this, i3, data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMCenterIndex(int i3) {
        this.mCenterIndex = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMMapHeight(int i3) {
        this.mMapHeight = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMMapWidth(int i3) {
        this.mMapWidth = i3;
    }
}
