package com.tencent.mobileqq.zplan.easteregg.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.easteregg.asyntask.AsynTaskHandler;
import com.tencent.mobileqq.zplan.easteregg.model.EasterEggBgParam;
import com.tencent.mobileqq.zplan.easteregg.model.EasterEggBgResult;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/manager/d;", "Lcom/tencent/mobileqq/zplan/easteregg/manager/f;", "Lcom/tencent/mobileqq/zplan/easteregg/model/c;", "Lcom/tencent/mobileqq/zplan/easteregg/manager/h;", "params", "Lcom/tencent/mobileqq/zplan/easteregg/manager/g;", "listener", "", "b", "", "a", "I", "getType", "()I", "setType", "(I)V", "type", "", "Z", "needZPlanOutBoundAvatar", "<init>", "()V", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d implements f<com.tencent.mobileqq.zplan.easteregg.model.c, IEasterEggResourceTaskResult> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int type = 1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean needZPlanOutBoundAvatar = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).needOutBoundAvatar2EasterEgg();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/manager/d$b", "Lcom/tencent/mobileqq/zplan/easteregg/asyntask/a;", "Lcom/tencent/mobileqq/zplan/easteregg/model/b;", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zplan.easteregg.asyntask.a<EasterEggBgResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g<IEasterEggResourceTaskResult> f332926a;

        b(g<IEasterEggResourceTaskResult> gVar) {
            this.f332926a = gVar;
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.asyntask.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(EasterEggBgResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result.getCode() != 0) {
                QLog.i("GetBackgroundTask", 1, "queryBackground onError");
                this.f332926a.a(result.getCode(), null);
            } else if (TextUtils.isEmpty(result.getPath())) {
                QLog.i("GetBackgroundTask", 1, "queryBackground path is empty");
                this.f332926a.a(6, null);
            } else {
                QLog.i("GetBackgroundTask", 1, "queryBackground onResource");
                this.f332926a.a(0, new IEasterEggResourceTaskResult(null, null, null, result.getPath(), null, null, 55, null));
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.manager.f
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(com.tencent.mobileqq.zplan.easteregg.model.c params, g<IEasterEggResourceTaskResult> listener) {
        AsynTaskHandler bVar;
        com.tencent.mobileqq.zplan.easteregg.a aVar;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            long parseLong = Long.parseLong(params.getUin());
            if (!this.needZPlanOutBoundAvatar) {
                com.tencent.mobileqq.zplan.easteregg.a aVar2 = params.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
                if (!(aVar2 != null && aVar2.getIsOutBoundAvatar())) {
                    bVar = new a();
                    aVar = params.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
                    if (aVar != null || (r6 = aVar.getBackgroundUrl()) == null) {
                        String str = "";
                    }
                    bVar.e(new EasterEggBgParam(parseLong, str), new b(listener));
                }
            }
            bVar = new com.tencent.mobileqq.zplan.easteregg.manager.b();
            aVar = params.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
            if (aVar != null) {
            }
            String str2 = "";
            bVar.e(new EasterEggBgParam(parseLong, str2), new b(listener));
        } catch (Exception unused) {
            QLog.i("GetBackgroundTask", 1, "queryBackground uin error");
            listener.a(1, null);
        }
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.manager.f
    public int getType() {
        return this.type;
    }
}
