package com.tencent.aelight.camera.ae.download;

import com.tencent.aelight.camera.download.api.AEResInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002\u001a\u0006\u0010\b\u001a\u00020\u0000\u00a8\u0006\t"}, d2 = {"", "b", "", "filename", "d", "agentType", "", "c", "a", "aelight_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AENewResUtilKt {
    public static final void a() {
        ms.a.f("AEResUtil", "loadConfig  doSetup begin ");
        BuildersKt__BuildersKt.runBlocking$default(null, new AENewResUtilKt$doSetup$1(null), 1, null);
    }

    public static final void b() {
        BuildersKt__BuildersKt.runBlocking$default(null, new AENewResUtilKt$doSync$1(null), 1, null);
    }

    public static final boolean c(String agentType) {
        Intrinsics.checkNotNullParameter(agentType, "agentType");
        return AEResInfo.PAG_BASIC64.equals(agentType) || AEResInfo.LIGHT_SDK_BASIC64.equals(agentType) || AEResInfo.FILAMENT_BASIC64.equals(agentType);
    }

    public static final void d(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        BuildersKt__BuildersKt.runBlocking$default(null, new AENewResUtilKt$safeLoadSo$1(filename, null), 1, null);
    }
}
