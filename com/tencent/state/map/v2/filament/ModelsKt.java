package com.tencent.state.map.v2.filament;

import com.tencent.filament.zplan.scene.square.Location;
import com.tencent.filament.zplan.scene.square.ObjectState;
import com.tencent.filament.zplan.scene.square.ObjectTapType;
import com.tencent.filament.zplan.scene.square.Size;
import com.tencent.filament.zplan.scene.square.ViewportInfo;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.state.map.v2.ObjectType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0000\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0000\u001a\u00020\u0007*\u00020\b\u001a\f\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\f\u001a\u00020\n*\u00020\u000f\u001a\n\u0010\f\u001a\u00020\u0004*\u00020\u0003\u001a\n\u0010\f\u001a\u00020\u0006*\u00020\u0005\u001a\n\u0010\f\u001a\u00020\b*\u00020\u0007\u00a8\u0006\u0010"}, d2 = {"toFilament", "Lcom/tencent/filament/zplan/scene/square/Location;", "Lcom/tencent/state/map/v2/Location;", "Lcom/tencent/filament/zplan/scene/square/ObjectType;", "Lcom/tencent/state/map/v2/ObjectType;", "Lcom/tencent/filament/zplan/scene/square/Size;", "Lcom/tencent/state/map/v2/Size;", "Lcom/tencent/filament/zplan/scene/square/ViewportInfo;", "Lcom/tencent/state/map/v2/ViewportInfo;", "toObjectTapType", "Lcom/tencent/state/map/v2/ObjectTapType;", "Lcom/tencent/filament/zplan/view/event/TouchEventType;", "toSquare", "Lcom/tencent/state/map/v2/ObjectState;", "Lcom/tencent/filament/zplan/scene/square/ObjectState;", "Lcom/tencent/filament/zplan/scene/square/ObjectTapType;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class ModelsKt {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        static {
            int[] iArr = new int[TouchEventType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TouchEventType.Tap.ordinal()] = 1;
            iArr[TouchEventType.DoubleTap.ordinal()] = 2;
            iArr[TouchEventType.LongPress.ordinal()] = 3;
            int[] iArr2 = new int[ObjectState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ObjectState.INIT.ordinal()] = 1;
            iArr2[ObjectState.LOADED.ordinal()] = 2;
            iArr2[ObjectState.MOVING.ordinal()] = 3;
            iArr2[ObjectState.REMOVED.ordinal()] = 4;
            iArr2[ObjectState.INTERACTING.ordinal()] = 5;
            int[] iArr3 = new int[ObjectTapType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[ObjectTapType.SINGLE.ordinal()] = 1;
            iArr3[ObjectTapType.DOUBLE.ordinal()] = 2;
            iArr3[ObjectTapType.LONG.ordinal()] = 3;
            int[] iArr4 = new int[ObjectType.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[ObjectType.AVATAR.ordinal()] = 1;
            iArr4[ObjectType.IMAGE.ordinal()] = 2;
            int[] iArr5 = new int[com.tencent.filament.zplan.scene.square.ObjectType.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[com.tencent.filament.zplan.scene.square.ObjectType.AVATAR.ordinal()] = 1;
            iArr5[com.tencent.filament.zplan.scene.square.ObjectType.IMAGE.ordinal()] = 2;
        }
    }

    public static final Location toFilament(com.tencent.state.map.v2.Location toFilament) {
        Intrinsics.checkNotNullParameter(toFilament, "$this$toFilament");
        return new Location(toFilament.getX(), toFilament.getY());
    }

    public static final com.tencent.state.map.v2.ObjectTapType toObjectTapType(TouchEventType toObjectTapType) {
        Intrinsics.checkNotNullParameter(toObjectTapType, "$this$toObjectTapType");
        int i3 = WhenMappings.$EnumSwitchMapping$0[toObjectTapType.ordinal()];
        if (i3 == 1) {
            return com.tencent.state.map.v2.ObjectTapType.SINGLE;
        }
        if (i3 == 2) {
            return com.tencent.state.map.v2.ObjectTapType.DOUBLE;
        }
        if (i3 != 3) {
            return null;
        }
        return com.tencent.state.map.v2.ObjectTapType.LONG;
    }

    public static final com.tencent.state.map.v2.Location toSquare(Location toSquare) {
        Intrinsics.checkNotNullParameter(toSquare, "$this$toSquare");
        return new com.tencent.state.map.v2.Location(toSquare.getX(), toSquare.getY());
    }

    public static final Size toFilament(com.tencent.state.map.v2.Size toFilament) {
        Intrinsics.checkNotNullParameter(toFilament, "$this$toFilament");
        return new Size(toFilament.getWidth(), toFilament.getHeight());
    }

    public static final com.tencent.state.map.v2.Size toSquare(Size toSquare) {
        Intrinsics.checkNotNullParameter(toSquare, "$this$toSquare");
        return new com.tencent.state.map.v2.Size(toSquare.getWidth(), toSquare.getHeight());
    }

    public static final ViewportInfo toFilament(com.tencent.state.map.v2.ViewportInfo toFilament) {
        Intrinsics.checkNotNullParameter(toFilament, "$this$toFilament");
        return new ViewportInfo(toFilament.getScale(), toFilament(toFilament.getCenter()));
    }

    public static final com.tencent.state.map.v2.ViewportInfo toSquare(ViewportInfo toSquare) {
        Intrinsics.checkNotNullParameter(toSquare, "$this$toSquare");
        return new com.tencent.state.map.v2.ViewportInfo(toSquare.getScale(), toSquare(toSquare.getCenter()));
    }

    public static final com.tencent.filament.zplan.scene.square.ObjectType toFilament(ObjectType toFilament) {
        Intrinsics.checkNotNullParameter(toFilament, "$this$toFilament");
        int i3 = WhenMappings.$EnumSwitchMapping$3[toFilament.ordinal()];
        if (i3 == 1) {
            return com.tencent.filament.zplan.scene.square.ObjectType.AVATAR;
        }
        if (i3 == 2) {
            return com.tencent.filament.zplan.scene.square.ObjectType.IMAGE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final com.tencent.state.map.v2.ObjectState toSquare(ObjectState toSquare) {
        Intrinsics.checkNotNullParameter(toSquare, "$this$toSquare");
        int i3 = WhenMappings.$EnumSwitchMapping$1[toSquare.ordinal()];
        if (i3 == 1) {
            return com.tencent.state.map.v2.ObjectState.INIT;
        }
        if (i3 == 2) {
            return com.tencent.state.map.v2.ObjectState.LOADED;
        }
        if (i3 == 3) {
            return com.tencent.state.map.v2.ObjectState.MOVING;
        }
        if (i3 == 4) {
            return com.tencent.state.map.v2.ObjectState.REMOVED;
        }
        if (i3 == 5) {
            return com.tencent.state.map.v2.ObjectState.INTERACTING;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final com.tencent.state.map.v2.ObjectTapType toSquare(ObjectTapType toSquare) {
        Intrinsics.checkNotNullParameter(toSquare, "$this$toSquare");
        int i3 = WhenMappings.$EnumSwitchMapping$2[toSquare.ordinal()];
        if (i3 == 1) {
            return com.tencent.state.map.v2.ObjectTapType.SINGLE;
        }
        if (i3 == 2) {
            return com.tencent.state.map.v2.ObjectTapType.DOUBLE;
        }
        if (i3 == 3) {
            return com.tencent.state.map.v2.ObjectTapType.LONG;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ObjectType toSquare(com.tencent.filament.zplan.scene.square.ObjectType toSquare) {
        Intrinsics.checkNotNullParameter(toSquare, "$this$toSquare");
        int i3 = WhenMappings.$EnumSwitchMapping$4[toSquare.ordinal()];
        if (i3 == 1) {
            return ObjectType.AVATAR;
        }
        if (i3 == 2) {
            return ObjectType.IMAGE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
