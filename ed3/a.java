package ed3;

import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import com.tencent.zplan.resource.api.ZPlanUserAvatarInfoReq;
import com.tencent.zplan.resource.api.a;
import cy4.ZPlanResourceBusinessData;
import cy4.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Led3/a;", "", "", "b", "", "Z", "hasPreloaded", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f396118a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean hasPreloaded;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J2\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"ed3/a$a", "Lcom/tencent/zplan/resource/api/a;", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Lcy4/c;", "statisticData", "", "c", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "", "errorCode", "", "errorMessage", "totalTaskCount", "failedTaskCount", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ed3.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10232a implements com.tencent.zplan.resource.api.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f396120a;

        C10232a(long j3) {
            this.f396120a = j3;
        }

        @Override // com.tencent.zplan.resource.api.a
        public void c(ZPlanResourceBusinessData businessData, c statisticData) {
            Intrinsics.checkNotNullParameter(businessData, "businessData");
            QLog.i("ZPlanAvatarInfoPreloader", 1, "preloadAvatarSuitInfo success, costTime= " + (System.currentTimeMillis() - this.f396120a) + " ");
            a.hasPreloaded = true;
        }

        @Override // com.tencent.zplan.resource.api.a
        public void d(ZPlanSceneResourceErrType errType, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
            Intrinsics.checkNotNullParameter(errType, "errType");
            QLog.e("ZPlanAvatarInfoPreloader", 1, "preloadAvatarSuitInfo error, costTime= " + (System.currentTimeMillis() - this.f396120a) + ", errorCode= " + errorCode + ", errorMessage= " + errorMessage);
        }

        @Override // com.tencent.zplan.resource.api.a
        public void f(float f16, int i3, int i16) {
            a.C10071a.a(this, f16, i3, i16);
        }
    }

    a() {
    }

    public final void b() {
        List<ZPlanUserAvatarInfoReq> list;
        if (hasPreloaded) {
            QLog.i("ZPlanAvatarInfoPreloader", 1, "preloadAvatarSuitInfo hasLoaded");
            return;
        }
        QLog.i("ZPlanAvatarInfoPreloader", 1, "preloadAvatarSuitInfo BEGIN");
        long currentTimeMillis = System.currentTimeMillis();
        bk3.a aVar = (bk3.a) vb3.a.f441346a.a(bk3.a.class);
        list = ArraysKt___ArraysKt.toList(new ZPlanUserAvatarInfoReq[]{new ZPlanUserAvatarInfoReq(w.f373306a.b(), null, null, null, 14, null)});
        aVar.l(list, new C10232a(currentTimeMillis));
    }
}
