package com.tencent.could.huiyansdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.Gson;
import com.tencent.could.component.common.ai.net.IJsonDataListener;
import com.tencent.could.huiyansdk.api.HuiYanAuthImp;
import com.tencent.could.huiyansdk.api.HuiYanSdk;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.common.a;
import com.tencent.could.huiyansdk.entity.CameraRiskChangeInfo;
import com.tencent.could.huiyansdk.entity.CameraRiskParam;
import com.tencent.could.huiyansdk.entity.CameraRiskParamConfig;
import com.tencent.could.huiyansdk.entity.CameraRiskParamData;
import com.tencent.could.huiyansdk.entity.LiveTypeDataConfig;
import com.tencent.could.huiyansdk.entity.OperationModeConfig;
import com.tencent.could.huiyansdk.entity.UpdateYtConfig;
import com.tencent.could.huiyansdk.manager.f;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.operate.HuiYanOperateBody;
import com.tencent.could.huiyansdk.operate.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class g implements IJsonDataListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.tencent.could.huiyansdk.callback.d f100303a;

    public g(com.tencent.could.huiyansdk.callback.d dVar) {
        this.f100303a = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
        }
    }

    @Override // com.tencent.could.component.common.ai.net.IJsonDataListener
    public void onFailed(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        k.a.f100197a.a(2, "HuiYanSenderHelper", "get config error! " + str);
        ((j) this.f100303a).a(str);
        e.a("get config error: " + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x018c  */
    @Override // com.tencent.could.component.common.ai.net.IJsonDataListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(String str) {
        CameraRiskParamData cameraRiskParamData;
        HuiYanOperateBody huiYanOperateBody;
        LiveTypeDataConfig.AngleDetectConfig angleDetectConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        com.tencent.could.huiyansdk.manager.k kVar = k.a.f100197a;
        kVar.a(1, "HuiYanSenderHelper", "got config: " + str);
        OperationModeConfig operationModeConfig = (OperationModeConfig) new Gson().fromJson(str, OperationModeConfig.class);
        if (operationModeConfig == null) {
            kVar.a(2, "HuiYanSenderHelper", "operation mode config is null");
            ((j) this.f100303a).a(str);
            e.a("config == null");
            return;
        }
        String cameraConfig = operationModeConfig.getCameraConfig();
        kVar.a(1, "CameraDataEncryptHelper", "decodeCameraData input : " + cameraConfig);
        if (TextUtils.isEmpty(cameraConfig)) {
            kVar.a(2, "CameraDataEncryptHelper", "CameraData: " + cameraConfig);
        } else {
            byte[] decode = Base64.decode(cameraConfig, 2);
            if (decode.length < 2) {
                kVar.a(2, "CameraDataEncryptHelper", "CameraData: " + cameraConfig);
            } else {
                byte b16 = decode[0];
                byte b17 = decode[1];
                int length = decode.length;
                int i3 = length - 2;
                if (i3 >= 0) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(decode, 2, bArr, 0, Math.min(decode.length - 2, i3));
                    try {
                        cameraRiskParamData = (CameraRiskParamData) new Gson().fromJson(new String(CommonUtils.encryptAESDecode(CommonUtils.hexStringToBytes(c.f100300a[b17]), CommonUtils.hexStringToBytes(c.f100301b[b17]), bArr)), CameraRiskParamData.class);
                    } catch (Exception e16) {
                        k.a.f100197a.a(2, "CameraDataEncryptHelper", "CameraData e: " + e16.getLocalizedMessage());
                    }
                    if (cameraRiskParamData == null) {
                        CameraRiskParamConfig cameraRiskParamConfig = new CameraRiskParamConfig();
                        CameraRiskParam start = cameraRiskParamData.getStart();
                        if (start != null) {
                            CameraRiskChangeInfo cameraRiskChangeInfo = new CameraRiskChangeInfo();
                            cameraRiskChangeInfo.setExposure((float) start.getExposure());
                            cameraRiskChangeInfo.setWhiteBalance(com.tencent.could.huiyansdk.manager.f.a(start.getWhiteBalance()));
                            cameraRiskChangeInfo.setNetZoom(start.getZoom());
                            cameraRiskChangeInfo.setDelay(start.getIntervalTime());
                            cameraRiskChangeInfo.setRiskCameraType(f.a.f100180a.a(cameraRiskChangeInfo));
                            cameraRiskParamConfig.setCameraRiskChangeStageStart(cameraRiskChangeInfo);
                        }
                        CameraRiskParam reflect = cameraRiskParamData.getReflect();
                        if (reflect != null) {
                            CameraRiskChangeInfo cameraRiskChangeInfo2 = new CameraRiskChangeInfo();
                            cameraRiskChangeInfo2.setExposure((float) reflect.getExposure());
                            cameraRiskChangeInfo2.setWhiteBalance(com.tencent.could.huiyansdk.manager.f.a(reflect.getWhiteBalance()));
                            cameraRiskChangeInfo2.setNetZoom(reflect.getZoom());
                            cameraRiskChangeInfo2.setDelay(reflect.getIntervalTime());
                            cameraRiskChangeInfo2.setRiskCameraType(f.a.f100180a.a(cameraRiskChangeInfo2));
                            cameraRiskParamConfig.setCameraRiskChangeStageReflect(cameraRiskChangeInfo2);
                        }
                        cameraRiskParamConfig.setStage(cameraRiskParamData.getStage());
                        HuiYanSdkImp.getInstance().setCameraRiskParamConfig(cameraRiskParamConfig);
                        k.a.f100197a.a(1, "HuiYanSenderHelper", "update setCameraRiskParamConfig");
                    } else {
                        HuiYanSdkImp.getInstance().setCameraRiskParamConfig(null);
                    }
                    com.tencent.could.huiyansdk.operate.c cVar = c.b.f100258a;
                    cVar.a("GetConfigDataUseTime", 2, false, "");
                    huiYanOperateBody = cVar.f100252a;
                    if (huiYanOperateBody != null) {
                        huiYanOperateBody.updateInfo("GetConfigData", 1, 1L, System.currentTimeMillis());
                    }
                    HuiYanAuthImp.getInstance().setOperationModeConfig(operationModeConfig);
                    angleDetectConfig = operationModeConfig.getAngleDetectConfig();
                    if (angleDetectConfig != null) {
                        UpdateYtConfig updateYtConfig = new UpdateYtConfig();
                        UpdateYtConfig.AngleDetectConfig angleDetectConfig2 = new UpdateYtConfig.AngleDetectConfig();
                        updateYtConfig.angleDetectConfig = angleDetectConfig2;
                        angleDetectConfig2.secondaryPitchThreshold = angleDetectConfig.getSecondaryPitchThreshold();
                        updateYtConfig.angleDetectConfig.secondaryRollThreshold = angleDetectConfig.getSecondaryRollThreshold();
                        updateYtConfig.angleDetectConfig.secondaryYawThreshold = angleDetectConfig.getSecondaryYawThreshold();
                        HuiYanSdk.updateYtConfigFunction(updateYtConfig);
                    }
                    com.tencent.could.huiyansdk.common.a aVar = a.C1019a.f100038a;
                    aVar.f100034c = "parallel".equals(operationModeConfig.getOperationMode());
                    aVar.f100035d = operationModeConfig.getNonce();
                    if (!TextUtils.isEmpty(operationModeConfig.getEncryptPubKey())) {
                        HuiYanAuthImp.getInstance().setPubKey(operationModeConfig.getEncryptPubKey());
                    }
                    k.a.f100197a.a(1, "HuiYanSenderHelper", "parallel: " + aVar.f100034c);
                    ((j) this.f100303a).f100306a.onSuccess();
                }
                throw new IllegalArgumentException("2 > " + length);
            }
        }
        cameraRiskParamData = null;
        if (cameraRiskParamData == null) {
        }
        com.tencent.could.huiyansdk.operate.c cVar2 = c.b.f100258a;
        cVar2.a("GetConfigDataUseTime", 2, false, "");
        huiYanOperateBody = cVar2.f100252a;
        if (huiYanOperateBody != null) {
        }
        HuiYanAuthImp.getInstance().setOperationModeConfig(operationModeConfig);
        angleDetectConfig = operationModeConfig.getAngleDetectConfig();
        if (angleDetectConfig != null) {
        }
        com.tencent.could.huiyansdk.common.a aVar2 = a.C1019a.f100038a;
        aVar2.f100034c = "parallel".equals(operationModeConfig.getOperationMode());
        aVar2.f100035d = operationModeConfig.getNonce();
        if (!TextUtils.isEmpty(operationModeConfig.getEncryptPubKey())) {
        }
        k.a.f100197a.a(1, "HuiYanSenderHelper", "parallel: " + aVar2.f100034c);
        ((j) this.f100303a).f100306a.onSuccess();
    }
}
