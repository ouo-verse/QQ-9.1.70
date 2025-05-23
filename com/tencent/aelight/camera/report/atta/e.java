package com.tencent.aelight.camera.report.atta;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007R(\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0006\u0010\b\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aelight/camera/report/atta/e;", "", "Landroid/content/Context;", "context", "", "a", "b", "", "Ljava/lang/String;", "getCurrentMaterialId", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "getCurrentMaterialId$annotations", "()V", "currentMaterialId", "<init>", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f69039a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String currentMaterialId = "0";

    e() {
    }

    @JvmStatic
    public static final long a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    @JvmStatic
    public static final long b() {
        return com.tencent.qqperf.tools.f.a("-1");
    }

    public static final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        currentMaterialId = str;
    }
}
