package com.tencent.state.square.record;

import com.tencent.zplan.meme.action.MODE;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/record/RecordType;", "", "(Ljava/lang/String;I)V", "isFilamentFrame", "", "toRecordMode", "Lcom/tencent/zplan/meme/action/MODE;", "MP4_SQUARE", "FILAMENT_SQUARE", "FILAMENT_NEARBY", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public enum RecordType {
    MP4_SQUARE,
    FILAMENT_SQUARE,
    FILAMENT_NEARBY;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecordType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[RecordType.FILAMENT_SQUARE.ordinal()] = 1;
            iArr[RecordType.FILAMENT_NEARBY.ordinal()] = 2;
        }
    }

    public final boolean isFilamentFrame() {
        if (this != FILAMENT_SQUARE && this != FILAMENT_NEARBY) {
            return false;
        }
        return true;
    }

    @NotNull
    public final MODE toRecordMode() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return MODE.MP4;
            }
            return MODE.FRAME;
        }
        return MODE.FRAME;
    }
}
