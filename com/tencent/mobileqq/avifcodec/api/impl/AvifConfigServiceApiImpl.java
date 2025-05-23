package com.tencent.mobileqq.avifcodec.api.impl;

import android.os.Build;
import androidx.annotation.NonNull;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.avifcodec.api.IAvifConfigServiceApi;
import com.tencent.mobileqq.avifcodec.config.pb.AvifCodecConfig$Ability;
import com.tencent.mobileqq.avifcodec.config.pb.AvifCodecConfig$AbilityInfo;
import com.tencent.mobileqq.avifcodec.config.pb.AvifCodecConfig$CertainAbility;
import com.tencent.mobileqq.avifcodec.config.pb.AvifCodecConfig$CodecConfigReq;
import com.tencent.mobileqq.avifcodec.config.pb.AvifCodecConfig$CodecConfigRsp;
import com.tencent.mobileqq.avifcodec.config.pb.AvifCodecConfig$FeatureInfo;
import com.tencent.mobileqq.avifcodec.util.a;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import x91.b;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AvifConfigServiceApiImpl implements IAvifConfigServiceApi, b {
    static IPatchRedirector $redirector_ = null;
    private static final int ABILITY_COMMON = 0;
    private static final String AND_PLATFORM_PB_REQUEST_HEAD = "android_";
    private static final int APP_ID = 0;
    private static final String APP_VERSION;
    private static final String DES_COMMON = "common";
    private static final String DEVICE_NAME;
    private static final int DIRECTION_SOFT_DEC = 3;
    private static final int MAX_DEC_HEIGHT = 4096;
    private static final int MAX_DEC_WIDTH = 4096;
    private static final int MIN_REQUEST_DELAY_MS = 1800000;
    private static final String OS_VERSION;
    private static final int PROTOCOL_AVC = 2;
    private static final int SCENE_TYPE = 1;
    private static final String TAG = "AvifConfigServiceApiImpl";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33493);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        APP_VERSION = AppSetting.f99551k;
        OS_VERSION = Integer.toString(Build.VERSION.SDK_INT);
        DEVICE_NAME = DeviceInfoMonitor.getModel();
    }

    public AvifConfigServiceApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean checkCanStartRequestAndUpdate(boolean z16) {
        boolean z17;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        long d16 = a.c().d(0L);
        if (serverTimeMillis <= d16 && d16 != 0 && !z16) {
            z17 = false;
        } else {
            long b16 = serverTimeMillis + a.c().b(1800000L);
            a.c().i(b16);
            QLog.i(TAG, 2, "updateDelay is " + b16);
            z17 = true;
        }
        QLog.i(TAG, 2, "checkCanStartRequestAndUpdate result:= " + z17);
        return z17;
    }

    private byte[] composeRequestIntent() {
        String platformChipName = getPlatformChipName();
        AvifCodecConfig$CodecConfigReq avifCodecConfig$CodecConfigReq = new AvifCodecConfig$CodecConfigReq();
        avifCodecConfig$CodecConfigReq.app_id.set(0L);
        PBStringField pBStringField = avifCodecConfig$CodecConfigReq.app_version;
        String str = APP_VERSION;
        pBStringField.set(str);
        avifCodecConfig$CodecConfigReq.scenes.set(1);
        avifCodecConfig$CodecConfigReq.platform_chipinfo.set(platformChipName);
        PBStringField pBStringField2 = avifCodecConfig$CodecConfigReq.os_version;
        String str2 = OS_VERSION;
        pBStringField2.set(str2);
        PBStringField pBStringField3 = avifCodecConfig$CodecConfigReq.device_name;
        String str3 = DEVICE_NAME;
        pBStringField3.set(str3);
        if (QLog.isColorLevel() || QLog.isDebugVersion()) {
            StringBuilder sb5 = new StringBuilder(50);
            sb5.append("composeRequestIntent\n ");
            sb5.append("app_id:=");
            sb5.append(0);
            sb5.append("\n");
            sb5.append("app_version:=");
            sb5.append(str);
            sb5.append("\n");
            sb5.append("scenes:=");
            sb5.append(1);
            sb5.append("\n");
            sb5.append("chip:=");
            sb5.append(platformChipName);
            sb5.append("\n");
            sb5.append("os_version:=");
            sb5.append(str2);
            sb5.append("\n");
            sb5.append("device_name:=");
            sb5.append(str3);
            sb5.append("\n");
            QLog.d(TAG, 1, sb5.toString());
        }
        return avifCodecConfig$CodecConfigReq.toByteArray();
    }

    private String getPlatformChipName() {
        return AND_PLATFORM_PB_REQUEST_HEAD + Build.HARDWARE + "_" + AVCoreSystemInfo.getCpuModel();
    }

    private boolean parseAndSaveAvifConfig(byte[] bArr) {
        boolean z16;
        boolean z17;
        AvifCodecConfig$CodecConfigRsp avifCodecConfig$CodecConfigRsp = new AvifCodecConfig$CodecConfigRsp();
        try {
            avifCodecConfig$CodecConfigRsp.mergeFrom(bArr);
            List<AvifCodecConfig$Ability> list = avifCodecConfig$CodecConfigRsp.ability.get();
            if (list.isEmpty()) {
                QLog.d(TAG, 1, "abilityList is empty");
                return false;
            }
            ArrayList<AvifCodecConfig$CertainAbility> arrayList = new ArrayList();
            for (AvifCodecConfig$Ability avifCodecConfig$Ability : list) {
                if (avifCodecConfig$Ability.scenes.get() == 1) {
                    arrayList.addAll(avifCodecConfig$Ability.certain_ability.get());
                }
            }
            if (arrayList.isEmpty()) {
                QLog.d(TAG, 1, "SCENES_NOT_REALTIME is empty");
                return false;
            }
            ArrayList<AvifCodecConfig$AbilityInfo> arrayList2 = new ArrayList();
            for (AvifCodecConfig$CertainAbility avifCodecConfig$CertainAbility : arrayList) {
                if (avifCodecConfig$CertainAbility.f200173protocol.get() == 2 && avifCodecConfig$CertainAbility.codec_type.get() == 3 && avifCodecConfig$CertainAbility.ability_enum.get() == 0) {
                    arrayList2.addAll(avifCodecConfig$CertainAbility.ability_info.get());
                }
            }
            if (arrayList2.isEmpty()) {
                QLog.d(TAG, 1, "AVC SOFT-COMMON-DEC is empty");
                return false;
            }
            ArrayList arrayList3 = new ArrayList();
            for (AvifCodecConfig$AbilityInfo avifCodecConfig$AbilityInfo : arrayList2) {
                if (avifCodecConfig$AbilityInfo.min_width.get() <= 4096 && avifCodecConfig$AbilityInfo.min_height.get() <= 4096) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (avifCodecConfig$AbilityInfo.max_width.get() >= 4096 && avifCodecConfig$AbilityInfo.max_height.get() >= 4096) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z16 && z17) {
                    arrayList3.addAll(avifCodecConfig$AbilityInfo.feature_info.get());
                }
            }
            if (arrayList3.isEmpty()) {
                QLog.d(TAG, 1, "definition filter is empty");
                return false;
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                if (((AvifCodecConfig$FeatureInfo) it.next()).feature_name.get().equalsIgnoreCase("common")) {
                    return true;
                }
            }
            return false;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(TAG, 1, "parseAndSaveAvifConfig fail", e16);
            return false;
        }
    }

    private void requestForAvifConfig(AppRuntime appRuntime) {
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), com.tencent.mobileqq.avifcodec.config.a.class);
        newIntent.putExtra("reqType", 1);
        newIntent.putExtra("vMsg", composeRequestIntent());
        appRuntime.startServlet(newIntent);
    }

    private boolean updateRequestDelayTime(long j3) {
        boolean z16;
        long b16 = a.c().b(1800000L);
        if (j3 != b16 && j3 >= 1800000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            j3 = b16;
        }
        if (z16) {
            a.c().h(j3);
            QLog.i(TAG, 2, "updateCycle is " + j3);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.avifcodec.api.IAvifConfigServiceApi
    public com.tencent.mobileqq.avifcodec.data.a getDecoderSupportAndUpdate(@NonNull AppRuntime appRuntime, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.avifcodec.data.a) iPatchRedirector.redirect((short) 5, this, appRuntime, Long.valueOf(j3));
        }
        com.tencent.mobileqq.avifcodec.data.a isSupportDecoder = isSupportDecoder();
        if (checkCanStartRequestAndUpdate(updateRequestDelayTime(j3))) {
            requestForAvifConfig(appRuntime);
        }
        return isSupportDecoder;
    }

    @Override // com.tencent.mobileqq.avifcodec.api.IAvifConfigServiceApi
    public com.tencent.mobileqq.avifcodec.data.a getEncoderSupportAndUpdate(@NonNull AppRuntime appRuntime, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.avifcodec.data.a) iPatchRedirector.redirect((short) 3, this, appRuntime, Long.valueOf(j3));
        }
        return isSupportEncoder();
    }

    @Override // com.tencent.mobileqq.avifcodec.api.IAvifConfigServiceApi
    public com.tencent.mobileqq.avifcodec.data.a isSupportDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.avifcodec.data.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new com.tencent.mobileqq.avifcodec.data.a(a.c().f(), a.c().e());
    }

    @Override // com.tencent.mobileqq.avifcodec.api.IAvifConfigServiceApi
    public com.tencent.mobileqq.avifcodec.data.a isSupportEncoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.avifcodec.data.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.mobileqq.avifcodec.data.a(a.c().g(), 1);
    }

    @Override // x91.b
    public void onReceiveAvifConfig(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr);
            return;
        }
        int i3 = 0;
        if (bArr == null) {
            QLog.w(TAG, 1, " onReceiveAvifConfig failed with data null");
            a.c().j(false);
            a.c().k(2);
            return;
        }
        boolean parseAndSaveAvifConfig = parseAndSaveAvifConfig(bArr);
        if (!parseAndSaveAvifConfig) {
            i3 = 3;
        }
        a.c().j(parseAndSaveAvifConfig);
        a.c().k(i3);
        QLog.d(TAG, 1, "onReceiveAvifConfig support:=" + parseAndSaveAvifConfig);
    }
}
