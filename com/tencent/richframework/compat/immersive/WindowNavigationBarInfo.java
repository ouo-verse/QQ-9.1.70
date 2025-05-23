package com.tencent.richframework.compat.immersive;

import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR-\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR-\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R!\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR-\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR-\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\tR!\u0010$\u001a\u0012\u0012\u0004\u0012\u00020%0\u001bj\b\u0012\u0004\u0012\u00020%`\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/richframework/compat/immersive/WindowNavigationBarInfo;", "", "()V", "heightHashMap", "Ljava/util/HashMap;", "", "Lcom/tencent/richframework/compat/immersive/NavigationBarInfo;", "Lkotlin/collections/HashMap;", "getHeightHashMap", "()Ljava/util/HashMap;", "leftSidePaddingHashMap", "getLeftSidePaddingHashMap", "marginHashMap", "getMarginHashMap", "naviBarHeight", "", "getNaviBarHeight", "()I", "setNaviBarHeight", "(I)V", "naviBarLeft", "getNaviBarLeft", "setNaviBarLeft", "naviBarRight", "getNaviBarRight", "setNaviBarRight", "navigationBarHeightCallback", "Ljava/util/HashSet;", "Lcom/tencent/richframework/compat/immersive/RFWNavigationBarImmersiveHelper$NavigationBarHeightChangeCallback;", "Lkotlin/collections/HashSet;", "getNavigationBarHeightCallback", "()Ljava/util/HashSet;", "paddingBottomHashMap", "getPaddingBottomHashMap", "rightSidePaddingHashMap", "getRightSidePaddingHashMap", "runnable", "Ljava/lang/Runnable;", "getRunnable", "compat-auto-immersive_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class WindowNavigationBarInfo {
    private int naviBarHeight = -1;
    private int naviBarLeft = -1;
    private int naviBarRight = -1;

    @NotNull
    private final HashSet<Runnable> runnable = new HashSet<>();

    @NotNull
    private final HashMap<String, NavigationBarInfo> paddingBottomHashMap = new HashMap<>();

    @NotNull
    private final HashMap<String, NavigationBarInfo> marginHashMap = new HashMap<>();

    @NotNull
    private final HashMap<String, NavigationBarInfo> heightHashMap = new HashMap<>();

    @NotNull
    private final HashMap<String, NavigationBarInfo> rightSidePaddingHashMap = new HashMap<>();

    @NotNull
    private final HashMap<String, NavigationBarInfo> leftSidePaddingHashMap = new HashMap<>();

    @NotNull
    private final HashSet<RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback> navigationBarHeightCallback = new HashSet<>();

    @NotNull
    public final HashMap<String, NavigationBarInfo> getHeightHashMap() {
        return this.heightHashMap;
    }

    @NotNull
    public final HashMap<String, NavigationBarInfo> getLeftSidePaddingHashMap() {
        return this.leftSidePaddingHashMap;
    }

    @NotNull
    public final HashMap<String, NavigationBarInfo> getMarginHashMap() {
        return this.marginHashMap;
    }

    public final int getNaviBarHeight() {
        return this.naviBarHeight;
    }

    public final int getNaviBarLeft() {
        return this.naviBarLeft;
    }

    public final int getNaviBarRight() {
        return this.naviBarRight;
    }

    @NotNull
    public final HashSet<RFWNavigationBarImmersiveHelper.NavigationBarHeightChangeCallback> getNavigationBarHeightCallback() {
        return this.navigationBarHeightCallback;
    }

    @NotNull
    public final HashMap<String, NavigationBarInfo> getPaddingBottomHashMap() {
        return this.paddingBottomHashMap;
    }

    @NotNull
    public final HashMap<String, NavigationBarInfo> getRightSidePaddingHashMap() {
        return this.rightSidePaddingHashMap;
    }

    @NotNull
    public final HashSet<Runnable> getRunnable() {
        return this.runnable;
    }

    public final void setNaviBarHeight(int i3) {
        this.naviBarHeight = i3;
    }

    public final void setNaviBarLeft(int i3) {
        this.naviBarLeft = i3;
    }

    public final void setNaviBarRight(int i3) {
        this.naviBarRight = i3;
    }
}
