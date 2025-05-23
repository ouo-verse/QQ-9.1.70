package com.tencent.zplan.resource.api;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import cy4.ZPlanResourceBusinessData;
import cy4.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J2\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH&J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/zplan/resource/api/a;", "", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Lcy4/c;", "statisticData", "", "c", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "", "errorCode", "", "errorMessage", "totalTaskCount", "failedTaskCount", "d", "", "progress", "completedTaskCount", "f", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface a {
    void c(@NotNull ZPlanResourceBusinessData businessData, @Nullable c statisticData);

    void d(@NotNull ZPlanSceneResourceErrType errType, int errorCode, @Nullable String errorMessage, int totalTaskCount, int failedTaskCount);

    void f(float progress, int totalTaskCount, int completedTaskCount);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.resource.api.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10071a {
        public static /* synthetic */ void b(a aVar, ZPlanResourceBusinessData zPlanResourceBusinessData, c cVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    cVar = null;
                }
                aVar.c(zPlanResourceBusinessData, cVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDownloadSuccess");
        }

        public static void a(@NotNull a aVar, float f16, int i3, int i16) {
        }
    }
}
