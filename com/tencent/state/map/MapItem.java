package com.tencent.state.map;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0000H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0003H\u0016R\u0014\u0010\u000b\u001a\u00020\u0003X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/map/MapItem;", "", "type", "", "uin", "", "isCenter", "", "location", "Lcom/tencent/state/map/Location;", "(ILjava/lang/String;ZLcom/tencent/state/map/Location;)V", "appId", "getAppId", "()I", "()Z", "isFixed", "isFromCache", "setFromCache", "(Z)V", "getLocation", "()Lcom/tencent/state/map/Location;", "setLocation", "(Lcom/tencent/state/map/Location;)V", "getType", "getUin", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "canUpdate", "newItem", "getItemViewLocation", "Landroid/graphics/Rect;", "getUnitType", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes4.dex */
public abstract class MapItem {
    private final int appId;
    private final boolean isCenter;
    private boolean isFromCache;

    @NotNull
    private Location location;
    private final int type;

    @NotNull
    private String uin;

    public MapItem(int i3, @NotNull String uin, boolean z16, @NotNull Location location) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(location, "location");
        this.type = i3;
        this.uin = uin;
        this.isCenter = z16;
        this.location = location;
    }

    public boolean canUpdate(@NotNull MapItem newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return false;
    }

    public int getAppId() {
        return this.appId;
    }

    @NotNull
    public Rect getItemViewLocation() {
        return MapItemKt.access$toItemViewLocation(this.location, this.type);
    }

    @NotNull
    public final Location getLocation() {
        return this.location;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getUin() {
        return this.uin;
    }

    public int getUnitType() {
        return -1;
    }

    /* renamed from: isCenter, reason: from getter */
    public final boolean getIsCenter() {
        return this.isCenter;
    }

    public abstract boolean isFixed();

    /* renamed from: isFromCache, reason: from getter */
    public final boolean getIsFromCache() {
        return this.isFromCache;
    }

    public final void setFromCache(boolean z16) {
        this.isFromCache = z16;
    }

    public final void setLocation(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "<set-?>");
        this.location = location;
    }

    public final void setUin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uin = str;
    }
}
