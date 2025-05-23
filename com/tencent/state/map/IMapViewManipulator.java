package com.tencent.state.map;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H&J=\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H&J7\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H&J?\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H&J9\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H&J\u0018\u0010\u0012\u001a\u00020\b2\u000e\u0010\u0013\u001a\n\u0012\u0002\b\u00030\u0014j\u0002`\u0015H&J7\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/map/IMapViewManipulator;", "", "locateTo", "", "index", "", "endCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "duration", "uin", "", "type", "locateToMe", "offset", "scaleToCenter", "holder", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "scaleToTarget", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public interface IMapViewManipulator {
    void locateTo(int index, int duration, Function1<? super Boolean, Unit> endCallback);

    void locateTo(int index, Function1<? super Boolean, Unit> endCallback);

    void locateTo(String uin, int type, Function1<? super Boolean, Unit> endCallback);

    void locateTo(String uin, Function1<? super Boolean, Unit> endCallback);

    void locateToMe(int offset, Function1<? super Boolean, Unit> endCallback);

    boolean scaleToCenter(MapViewHolder<?> holder);

    void scaleToTarget(int index, Function1<? super Boolean, Unit> endCallback);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void locateTo$default(IMapViewManipulator iMapViewManipulator, String str, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    function1 = null;
                }
                iMapViewManipulator.locateTo(str, (Function1<? super Boolean, Unit>) function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: locateTo");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void locateTo$default(IMapViewManipulator iMapViewManipulator, String str, int i3, Function1 function1, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    function1 = null;
                }
                iMapViewManipulator.locateTo(str, i3, (Function1<? super Boolean, Unit>) function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: locateTo");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void scaleToTarget$default(IMapViewManipulator iMapViewManipulator, int i3, Function1 function1, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    function1 = null;
                }
                iMapViewManipulator.scaleToTarget(i3, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scaleToTarget");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void locateToMe$default(IMapViewManipulator iMapViewManipulator, int i3, Function1 function1, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 1) != 0) {
                    i3 = 0;
                }
                if ((i16 & 2) != 0) {
                    function1 = null;
                }
                iMapViewManipulator.locateToMe(i3, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: locateToMe");
        }
    }
}
