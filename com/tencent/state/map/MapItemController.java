package com.tencent.state.map;

import com.tencent.state.square.exposure.EmptyExposureManager;
import com.tencent.state.square.exposure.IExposureManager;
import com.tencent.state.square.guide.GuideContext;
import com.tencent.state.square.media.SquarePlayerPool;
import cooperation.qzone.report.QZonePushReporter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u001a\u0010\"\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105\u00a8\u00066"}, d2 = {"Lcom/tencent/state/map/MapItemController;", "", "rpm", "Lcom/tencent/state/map/IMapPlayManager;", "locator", "Lcom/tencent/state/map/IMapLocator;", "manipulator", "Lcom/tencent/state/map/IMapViewManipulator;", "viewManager", "Lcom/tencent/state/map/IMapItemViewManager;", "listener", "Lcom/tencent/state/map/IMapViewListener;", QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE, "Lcom/tencent/state/square/exposure/IExposureManager;", "playerPool", "Lcom/tencent/state/square/media/SquarePlayerPool;", "(Lcom/tencent/state/map/IMapPlayManager;Lcom/tencent/state/map/IMapLocator;Lcom/tencent/state/map/IMapViewManipulator;Lcom/tencent/state/map/IMapItemViewManager;Lcom/tencent/state/map/IMapViewListener;Lcom/tencent/state/square/exposure/IExposureManager;Lcom/tencent/state/square/media/SquarePlayerPool;)V", "blockClick", "", "getBlockClick", "()Z", "setBlockClick", "(Z)V", "blockScale", "getBlockScale", "setBlockScale", "blockScroll", "getBlockScroll", "setBlockScroll", "getExposure", "()Lcom/tencent/state/square/exposure/IExposureManager;", "hasCheckRoleBornAnim", "getHasCheckRoleBornAnim", "setHasCheckRoleBornAnim", "isWelcomeScaleAnimDone", "setWelcomeScaleAnimDone", "itemAlpha", "", "getItemAlpha", "()F", "setItemAlpha", "(F)V", "getListener", "()Lcom/tencent/state/map/IMapViewListener;", "getLocator", "()Lcom/tencent/state/map/IMapLocator;", "getManipulator", "()Lcom/tencent/state/map/IMapViewManipulator;", "getPlayerPool", "()Lcom/tencent/state/square/media/SquarePlayerPool;", "getRpm", "()Lcom/tencent/state/map/IMapPlayManager;", "getViewManager", "()Lcom/tencent/state/map/IMapItemViewManager;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public class MapItemController {
    private boolean blockClick;
    private boolean blockScale;
    private boolean blockScroll;
    private final IExposureManager exposure;
    private boolean hasCheckRoleBornAnim;
    private boolean isWelcomeScaleAnimDone;
    private float itemAlpha;
    private final IMapViewListener listener;
    private final IMapLocator locator;
    private final IMapViewManipulator manipulator;
    private final SquarePlayerPool playerPool;
    private final IMapPlayManager rpm;
    private final IMapItemViewManager viewManager;

    public MapItemController(IMapPlayManager rpm, IMapLocator locator, IMapViewManipulator manipulator, IMapItemViewManager viewManager, IMapViewListener iMapViewListener, IExposureManager exposure, SquarePlayerPool playerPool) {
        Intrinsics.checkNotNullParameter(rpm, "rpm");
        Intrinsics.checkNotNullParameter(locator, "locator");
        Intrinsics.checkNotNullParameter(manipulator, "manipulator");
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        Intrinsics.checkNotNullParameter(exposure, "exposure");
        Intrinsics.checkNotNullParameter(playerPool, "playerPool");
        this.rpm = rpm;
        this.locator = locator;
        this.manipulator = manipulator;
        this.viewManager = viewManager;
        this.listener = iMapViewListener;
        this.exposure = exposure;
        this.playerPool = playerPool;
        this.itemAlpha = 1.0f;
        this.isWelcomeScaleAnimDone = true;
        this.hasCheckRoleBornAnim = GuideContext.INSTANCE.hasCheckedCreateRoleGuide();
    }

    public final boolean getBlockClick() {
        return this.blockClick;
    }

    public final boolean getBlockScale() {
        return this.blockScale;
    }

    public final boolean getBlockScroll() {
        return this.blockScroll;
    }

    public final IExposureManager getExposure() {
        return this.exposure;
    }

    public final boolean getHasCheckRoleBornAnim() {
        return this.hasCheckRoleBornAnim;
    }

    public final float getItemAlpha() {
        return this.itemAlpha;
    }

    public final IMapViewListener getListener() {
        return this.listener;
    }

    public final IMapLocator getLocator() {
        return this.locator;
    }

    public final IMapViewManipulator getManipulator() {
        return this.manipulator;
    }

    public final SquarePlayerPool getPlayerPool() {
        return this.playerPool;
    }

    public final IMapPlayManager getRpm() {
        return this.rpm;
    }

    public final IMapItemViewManager getViewManager() {
        return this.viewManager;
    }

    /* renamed from: isWelcomeScaleAnimDone, reason: from getter */
    public final boolean getIsWelcomeScaleAnimDone() {
        return this.isWelcomeScaleAnimDone;
    }

    public final void setBlockClick(boolean z16) {
        this.blockClick = z16;
    }

    public final void setBlockScale(boolean z16) {
        this.blockScale = z16;
    }

    public final void setBlockScroll(boolean z16) {
        this.blockScroll = z16;
    }

    public final void setHasCheckRoleBornAnim(boolean z16) {
        this.hasCheckRoleBornAnim = z16;
    }

    public final void setItemAlpha(float f16) {
        this.itemAlpha = f16;
    }

    public final void setWelcomeScaleAnimDone(boolean z16) {
        this.isWelcomeScaleAnimDone = z16;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MapItemController(IMapPlayManager iMapPlayManager, IMapLocator iMapLocator, IMapViewManipulator iMapViewManipulator, IMapItemViewManager iMapItemViewManager, IMapViewListener iMapViewListener, IExposureManager iExposureManager, SquarePlayerPool squarePlayerPool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(iMapPlayManager, iMapLocator, iMapViewManipulator, iMapItemViewManager, r7, r8, r9);
        SquarePlayerPool squarePlayerPool2;
        Function0 function0 = null;
        byte b16 = 0;
        IMapViewListener iMapViewListener2 = (i3 & 16) != 0 ? null : iMapViewListener;
        IExposureManager emptyExposureManager = (i3 & 32) != 0 ? new EmptyExposureManager() : iExposureManager;
        if ((i3 & 64) != 0) {
            squarePlayerPool2 = new SquarePlayerPool(function0, 1, b16 == true ? 1 : 0);
        } else {
            squarePlayerPool2 = squarePlayerPool;
        }
    }
}
