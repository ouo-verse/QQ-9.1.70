package com.tencent.state.map.v2;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u00a8\u0006\u0003"}, d2 = {"isInScreen", "", "Lcom/tencent/state/map/v2/ObjectState;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class IMapObjectKt {
    public static final boolean isInScreen(ObjectState objectState) {
        return objectState == ObjectState.LOADED || objectState == ObjectState.MOVING || objectState == ObjectState.INTERACTING;
    }
}
