package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.os.Bundle;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetWatermarkDictRsp;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.config.g;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.aelight.camera.util.api.IVSConfigManager;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    private static volatile b f63434f;

    /* renamed from: b, reason: collision with root package name */
    private AEMaterialMetaData f63436b;

    /* renamed from: c, reason: collision with root package name */
    private SosoLocation f63437c;

    /* renamed from: a, reason: collision with root package name */
    private final int f63435a = 60000;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, String> f63438d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private long f63439e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f63440a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z16, c cVar) {
            super(str, z16);
            this.f63440a = cVar;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            SosoLocation sosoLocation;
            if (i3 != 0) {
                ms.a.c("WaterMarkManager", "LbsManagerService.startLocation: failed");
                return;
            }
            if (sosoLbsInfo != null && (sosoLocation = sosoLbsInfo.mLocation) != null) {
                b.this.f63437c = sosoLocation;
                double d16 = sosoLocation.mLat02;
                double d17 = sosoLocation.mLon02;
                ms.a.f("WaterMarkManager", "LbsManagerService.startLocation: success");
                b.this.j(d16, d17, this.f63440a);
                return;
            }
            ms.a.c("WaterMarkManager", "LbsManagerService.startLocation: location is null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void onGetWatermarkDict(Map<String, String> map);
    }

    public static b f() {
        if (f63434f == null) {
            synchronized (b.class) {
                if (f63434f == null) {
                    f63434f = new b();
                }
            }
        }
        return f63434f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(double d16, double d17, c cVar) {
        AppInterface a16 = QQStoryContext.a();
        if (a16 == null) {
            ms.a.c("WaterMarkManager", "requestDictBySSO | error:appInterface is null.");
            return;
        }
        CameraPeakServiceHandler cameraPeakServiceHandler = (CameraPeakServiceHandler) a16.getBusinessHandler(PeakAppInterface.I);
        if (cameraPeakServiceHandler == null) {
            ms.a.c("WaterMarkManager", "requestDictBySSO | error:reqHandler is null.");
            return;
        }
        a16.addObserver(new C0547b(cVar));
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", a16.getCurrentAccountUin(), AECameraConstants.CMD_WATERMARK_LOCATION);
        Bundle bundle = toServiceMsg.extraData;
        bundle.putDouble(AECameraConstants.KEY_LONGTITUDE, d17);
        bundle.putDouble(AECameraConstants.KEY_LATITUDE, d16);
        cameraPeakServiceHandler.send(toServiceMsg);
    }

    private synchronized boolean m() {
        return System.currentTimeMillis() - this.f63439e <= 60000;
    }

    private void n(c cVar) {
        ms.a.f("WaterMarkManager", "updateWMProps start");
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new a("qq_story_water_mark", false, cVar));
    }

    public AEMaterialMetaData e() {
        return this.f63436b;
    }

    public SosoLocation g() {
        return this.f63437c;
    }

    public void h(boolean z16) {
        ((IVSConfigManager) QRoute.api(IVSConfigManager.class)).setValue("WM_LIST_CONFIG_CHANGED", Boolean.valueOf(z16));
    }

    public void i() {
        synchronized (this) {
            this.f63436b = null;
            this.f63439e = 0L;
            this.f63438d.clear();
            this.f63437c = null;
        }
    }

    public void k(@Nonnull c cVar) {
        synchronized (this) {
            if (m()) {
                cVar.onGetWatermarkDict(Collections.unmodifiableMap(this.f63438d));
            } else {
                n(cVar);
            }
        }
    }

    public void l(AEMaterialMetaData aEMaterialMetaData) {
        this.f63436b = aEMaterialMetaData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.watermark.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0547b extends g {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f63442d;

        C0547b(c cVar) {
            this.f63442d = cVar;
        }

        @Override // com.tencent.aelight.camera.ae.config.g
        public void onUpdateWatermarkLocation(boolean z16, GetWatermarkDictRsp getWatermarkDictRsp) {
            if (!z16) {
                ms.a.c("WaterMarkManager", "requestDictBySSO retCode:" + getWatermarkDictRsp.Code);
                return;
            }
            Map<String, String> map = getWatermarkDictRsp.WatermarkDict;
            if (map == null) {
                ms.a.c("WaterMarkManager", "requestDictBySSO rsp.WatermarkDict is null.");
                return;
            }
            ms.a.f("WaterMarkManager", "requestDictBySSO [onReceive] watermarkDict.size:" + map.size());
            synchronized (b.this) {
                b.this.f63438d.clear();
                b.this.f63438d.putAll(map);
                b.this.f63439e = System.currentTimeMillis();
            }
            this.f63442d.onGetWatermarkDict(map);
        }
    }
}
