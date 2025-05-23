package com.tencent.state.map.v2;

import android.content.Context;
import android.view.TextureView;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JZ\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2H\b\u0002\u0010\t\u001aB\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0010H&Jd\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152B\u0010\t\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00030\nj\b\u0012\u0004\u0012\u00020\u0017`\u0010H&J\b\u0010\u0018\u001a\u00020\u0003H&J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH&J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001aH&J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020\u001dH&J\b\u0010 \u001a\u00020!H&J\"\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H&J\b\u0010'\u001a\u00020\u0003H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010)\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010*\u001a\u00020+H&J\b\u0010,\u001a\u00020\u0003H&\u00a8\u0006-"}, d2 = {"Lcom/tencent/state/map/v2/IMap;", "", "addMapListener", "", "listener", "Lcom/tencent/state/map/v2/IMapListener;", "addObject", "params", "Lcom/tencent/state/map/v2/ObjectParams;", "callback", "Lkotlin/Function2;", "Lcom/tencent/state/map/v2/MapError;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_ERROR, "data", "Lcom/tencent/state/map/v2/MapCallback;", "boot", "context", "Landroid/content/Context;", "mapSize", "Lcom/tencent/state/map/v2/Size;", "viewportSize", "Landroid/view/TextureView;", "destroy", "getAllObjects", "", "Lcom/tencent/state/map/v2/IMapObject;", "getCurrentObjectIds", "", "getObject", "id", "getViewport", "Lcom/tencent/state/map/v2/ViewportInfo;", "moveViewport", "from", "to", "duration", "", "pause", "removeMapListener", "removeObject", "waitForAnimationEnd", "", "resume", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface IMap {
    void addMapListener(IMapListener listener);

    void addObject(ObjectParams params, Function2<? super MapError, ? super Unit, Unit> callback);

    void boot(Context context, Size mapSize, Size viewportSize, Function2<? super MapError, ? super TextureView, Unit> callback);

    void destroy();

    List<IMapObject> getAllObjects();

    List<String> getCurrentObjectIds();

    IMapObject getObject(String id5);

    ViewportInfo getViewport();

    void moveViewport(ViewportInfo from, ViewportInfo to5, int duration);

    void pause();

    void removeMapListener(IMapListener listener);

    void removeObject(String id5, boolean waitForAnimationEnd);

    void resume();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void addObject$default(IMap iMap, ObjectParams objectParams, Function2 function2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function2 = null;
                }
                iMap.addObject(objectParams, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addObject");
        }

        public static /* synthetic */ void removeObject$default(IMap iMap, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                iMap.removeObject(str, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeObject");
        }
    }
}
