package com.tencent.mobileqq.zplan.smallhome.backload;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.ipc.f;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderController;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2;
import com.tencent.qphone.base.util.QLog;
import ic3.a;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import ud3.c;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/backload/ModBackLoadIPCImpl;", "", "", "isLoadingV2SwitchOn", "", "mapId", "", "startTime", "", "loadModInBackGround", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ModBackLoadIPCImpl {
    private static final String TAG = "ModBackLoadIPCImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isLoadingV2SwitchOn() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100472", true);
    }

    public void loadModInBackGround(final int mapId, final long startTime) {
        QLog.d(TAG, 1, "loadModInBackGround");
        if (((f) i.INSTANCE.a(f.class)).isInAvatarScene()) {
            QLog.i(TAG, 1, "loadModInBackGround, in avatar scene, do not load after download");
        } else {
            ZootopiaDownloadManagerIpc.f328013a.g(mapId, new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zplan.smallhome.backload.ModBackLoadIPCImpl$loadModInBackGround$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                    invoke2(zootopiaDownloadData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                    String str;
                    ZootopiaEnterParams b16;
                    boolean isLoadingV2SwitchOn;
                    ZootopiaResData resData;
                    String loadingId = ((a) i.INSTANCE.a(a.class)).getLoadingId(mapId);
                    ZootopiaEnterParams.Companion companion = ZootopiaEnterParams.INSTANCE;
                    int i3 = mapId;
                    long j3 = startTime;
                    if (zootopiaDownloadData == null || (resData = zootopiaDownloadData.getResData()) == null || (str = resData.getVersion()) == null) {
                        str = "";
                    }
                    b16 = companion.b(i3, (r22 & 2) != 0 ? null : null, (r22 & 4) != 0 ? Boolean.TRUE : null, (r22 & 8) != 0 ? Float.valueOf(100.0f) : null, "1", (r22 & 32) != 0 ? System.currentTimeMillis() : j3, (r22 & 64) != 0 ? "" : loadingId, (r22 & 128) != 0 ? "" : str);
                    isLoadingV2SwitchOn = this.isLoadingV2SwitchOn();
                    c a16 = isLoadingV2SwitchOn ? ZPlanUELoaderControllerV2.INSTANCE.a(b16) : ZPlanUELoaderController.Y.a(b16);
                    a16.Y8("1", true);
                    a16.jf(true);
                }
            });
        }
    }
}
