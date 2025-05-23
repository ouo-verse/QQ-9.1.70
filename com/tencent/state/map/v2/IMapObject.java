package com.tencent.state.map.v2;

import androidx.core.app.NotificationCompat;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&JR\u0010\b\u001a\u00020\t2H\b\u0002\u0010\n\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&Jb\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172H\b\u0002\u0010\n\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0011H&J\b\u0010\u0018\u001a\u00020\tH&J\b\u0010\u0019\u001a\u00020\tH&J$\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001dH&JZ\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2H\b\u0002\u0010\n\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0011H&\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/map/v2/IMapObject;", "", "getMapLocation", "Lcom/tencent/state/map/v2/Location;", "getObjectParams", "Lcom/tencent/state/map/v2/ObjectParams;", "getState", "Lcom/tencent/state/map/v2/ObjectState;", "interaction", "", "callback", "Lkotlin/Function2;", "Lcom/tencent/state/map/v2/MapError;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_ERROR, "data", "Lcom/tencent/state/map/v2/MapCallback;", "isPlaying", "", CanvasView.ACTION_MOVETO, "targetLocation", "duration", "", "play", "reset", "stop", "waitForAnimationEnd", "onStopped", "Lkotlin/Function0;", "updateResource", "params", "Lcom/tencent/state/map/v2/ObjectUpdateResourceParams;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface IMapObject {
    Location getMapLocation();

    ObjectParams getObjectParams();

    ObjectState getState();

    void interaction(Function2<? super MapError, ? super Unit, Unit> callback);

    boolean isPlaying();

    void moveTo(Location targetLocation, long duration, Function2<? super MapError, ? super Unit, Unit> callback);

    void play();

    void reset();

    void stop(boolean waitForAnimationEnd, Function0<Unit> onStopped);

    void updateResource(ObjectUpdateResourceParams params, Function2<? super MapError, ? super Unit, Unit> callback);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void interaction$default(IMapObject iMapObject, Function2 function2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    function2 = null;
                }
                iMapObject.interaction(function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: interaction");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void moveTo$default(IMapObject iMapObject, Location location, long j3, Function2 function2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    function2 = null;
                }
                iMapObject.moveTo(location, j3, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveTo");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void updateResource$default(IMapObject iMapObject, ObjectUpdateResourceParams objectUpdateResourceParams, Function2 function2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function2 = null;
                }
                iMapObject.updateResource(objectUpdateResourceParams, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateResource");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void stop$default(IMapObject iMapObject, boolean z16, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                if ((i3 & 2) != 0) {
                    function0 = null;
                }
                iMapObject.stop(z16, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stop");
        }
    }
}
