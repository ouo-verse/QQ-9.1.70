package com.tencent.state.map;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/map/UnitType;", "", "()V", "UNIT_TYPE_FRIEND", "", "UNIT_TYPE_GROUP", "UNIT_TYPE_STRANGER", "UNIT_TYPE_UN_KNOW", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes4.dex */
public final class UnitType {

    @NotNull
    public static final UnitType INSTANCE = new UnitType();
    public static final int UNIT_TYPE_FRIEND = 0;
    public static final int UNIT_TYPE_GROUP = 1;
    public static final int UNIT_TYPE_STRANGER = 2;
    public static final int UNIT_TYPE_UN_KNOW = -1;

    UnitType() {
    }
}
