package com.tencent.state.square.avatar.filament;

import android.os.Process;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.mmkv.IMMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/avatar/filament/FilamentReportHelper;", "", "()V", "isFirstFilamentAfterInstall", "", "isUsedFilament", "markUsedFilament", "", "setUsedFilamentAfterInstall", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FilamentReportHelper {
    public static final FilamentReportHelper INSTANCE = new FilamentReportHelper();

    FilamentReportHelper() {
    }

    public final boolean isFirstFilamentAfterInstall() {
        return !Intrinsics.areEqual(SquareBaseKt.getSquareCommon().getAppReportVersionName(), IMMKV.DefaultImpls.decodeString$default(SquareBaseKt.getSquareMMKV(), SKey.Filament.LAST_USE_FILAMENT_QQ_VERSION, "", null, false, 12, null));
    }

    public final boolean isUsedFilament() {
        return IMMKV.DefaultImpls.decodeInt$default(SquareBaseKt.getSquareMMKV(), SKey.Filament.LAST_USE_FILAMENT_IN_DETAIL_PAGE_PID, -1, null, false, 12, null) == Process.myPid();
    }

    public final void markUsedFilament() {
        IMMKV.DefaultImpls.encodeInt$default(SquareBaseKt.getSquareMMKV(), SKey.Filament.LAST_USE_FILAMENT_IN_DETAIL_PAGE_PID, Process.myPid(), null, false, 12, null);
    }

    public final void setUsedFilamentAfterInstall() {
        IMMKV.DefaultImpls.encodeString$default(SquareBaseKt.getSquareMMKV(), SKey.Filament.LAST_USE_FILAMENT_QQ_VERSION, SquareBaseKt.getSquareCommon().getAppReportVersionName(), null, false, 12, null);
    }
}
