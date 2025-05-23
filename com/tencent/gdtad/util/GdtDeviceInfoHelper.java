package com.tencent.gdtad.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.device.AdDevice;
import com.tencent.ad.tangram.device.AdTAID;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.lbs.AdLocation;
import com.tencent.ad.tangram.lbs.AdLocationManager;
import com.tencent.ad.tangram.privacy.AdPrivacyPolicyManager;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.common.config.AppSetting;
import com.tencent.gathererga.tangram.c;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.IGdtMotiveAPI;
import com.tencent.gdtad.config.IGdtConfigAPI;
import com.tencent.gdtad.config.IGdtConfigManagerForExperimentAPI;
import com.tencent.gdtad.config.data.c;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.kuikly.IGdtKuiklyAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.capability.TPVCodecCapabilityForGet;
import cooperation.qzone.PlatformInfor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import org.light.LightConstants;
import tencent.gdt.qq_ad_get;
import tencent.gdt.qq_common;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtDeviceInfoHelper {
    private static final long ANALYSIS_INTERVAL = 60000;
    private static final int GATHER_EVERYTIME = 1;
    private static final int GATHER_ONCE_WHEN_APP_INSTALL = 3;
    private static final int GATHER_ONCE_WHEN_PROCESS_STARTUP = 2;
    private static final int JUMP_ABILITY_SUPPORT_THIRD_AD = 9999;
    private static final String SWITCH_DYNAMIC_HIPPY_MOTIVE_AD = "102992";

    @NonNull
    private static final String TAG = "GdtDeviceInfoHelper";
    private static final String WX_OPENSDK_VERSION = "com.tencent.mm.BuildInfo.OPEN_SDK_VERSION";
    private static final String WX_PACKAGE_NAME = "com.tencent.mm";
    private static final HashSet<Integer> ID_LIST = new HashSet<Integer>() { // from class: com.tencent.gdtad.util.GdtDeviceInfoHelper.1
        {
            add(318);
            add(408);
        }
    };
    private static volatile long sTimeMillis = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class GatherConfig {
        boolean enableUseInterface;
        private int gatherType;
        boolean enableUseFile = false;
        boolean enableWriteFile = false;
        boolean enableDeleteFile = false;

        GatherConfig(int i3, boolean z16) {
            this.gatherType = i3;
            this.enableUseInterface = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class Params {

        @Deprecated
        public String businessIdForAidTicketAndTaidTicket;
        public boolean supportOpenMotiveAd;
        public boolean supportWXMINIAuthorizationState = false;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class Result {
        public qq_ad_get.QQAdGet.DeviceInfo deviceInfo;

        @NonNull
        public List<AdAnalysisEvent> eventsForAnalysis = new ArrayList();
    }

    private static boolean canGatherOnMainThread(int i3) {
        return !ID_LIST.contains(Integer.valueOf(i3));
    }

    @Nullable
    @Deprecated
    public static Result create(@Nullable Context context, @Nullable Params params) throws IllegalArgumentException {
        com.tencent.gdtad.config.data.c cVar = null;
        if (context != null && params != null && Looper.myLooper() != Looper.getMainLooper()) {
            GdtLog.i(TAG, "[create] supportOpenMotiveAd:" + params.supportOpenMotiveAd + " supportWXMINIAuthorizationState:" + params.supportWXMINIAuthorizationState);
            long currentTimeMillis = System.currentTimeMillis();
            IGdtAdAPI iGdtAdAPI = (IGdtAdAPI) QRoute.api(IGdtAdAPI.class);
            if (iGdtAdAPI == null) {
                QLog.i(TAG, 1, "gdtAdAPI == null");
                return null;
            }
            iGdtAdAPI.initGdtContext(context, new InitGdtContextParams());
            t.h(params.supportWXMINIAuthorizationState);
            Result result = new Result();
            result.deviceInfo = new qq_ad_get.QQAdGet.DeviceInfo();
            if (!AdPrivacyPolicyManager.getInstance().isAllowed()) {
                GdtLog.e(TAG, "create not allowed");
                return result;
            }
            try {
                cVar = ((IGdtConfigAPI) QRoute.api(IGdtConfigAPI.class)).getConfigForDeviceInfo();
            } catch (Throwable th5) {
                GdtLog.e(TAG, "[create]", th5);
            }
            GdtLog.d(TAG, "[create]");
            fillDeviceInfo(context, params, cVar, result);
            fillDeviceInfoWithOthers(context, params, result);
            result.eventsForAnalysis.add(AdAnalysisHelperForUtil.createEventForDeviceInfoEnd(context, System.currentTimeMillis() - currentTimeMillis));
            reportForAnalysis(context, params, result);
            return result;
        }
        GdtLog.e(TAG, "create error");
        return null;
    }

    private static AdAnalysisEvent createEventForDeviceIdentifier(Context context, int i3, com.tencent.gathererga.tangram.d dVar) {
        int errorCode;
        int a16;
        int i16 = Integer.MIN_VALUE;
        if (dVar == null) {
            errorCode = Integer.MIN_VALUE;
        } else {
            errorCode = (int) dVar.getErrorCode();
        }
        if (dVar != null) {
            i16 = (int) dVar.c();
        }
        if (dVar == null) {
            a16 = 0;
        } else {
            a16 = dVar.a();
        }
        return AdAnalysisHelperForUtil.createEventForDeviceIdentifier(context, i3, errorCode, i16, a16);
    }

    @Nullable
    private static com.tencent.gathererga.core.e createFetchPriority(int i3, boolean z16, boolean z17) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    GdtLog.e(TAG, "createFetchPriority error, unknown gatherType");
                    return null;
                }
                if (z16) {
                    return com.tencent.gathererga.core.internal.provider.b.f().i().k().n().h(true).g(z17).f();
                }
                return com.tencent.gathererga.core.internal.provider.b.f().i().k().h(true).g(z17).f();
            }
            if (!z16) {
                return null;
            }
            return com.tencent.gathererga.core.internal.provider.b.f().i().l().h(true).g(false).f();
        }
        if (!z16) {
            return null;
        }
        return com.tencent.gathererga.core.internal.provider.b.f().j().h(true).g(false).f();
    }

    private static Map<Integer, GatherConfig> createGatherConfigMap(com.tencent.gdtad.config.data.c cVar) {
        c.a[] aVarArr;
        HashMap<Integer, GatherConfig> hashMap = new HashMap<Integer, GatherConfig>() { // from class: com.tencent.gdtad.util.GdtDeviceInfoHelper.2
            {
                put(119, new GatherConfig(1, true));
                put(125, new GatherConfig(1, true));
                put(305, new GatherConfig(1, true));
                put(312, new GatherConfig(1, true));
                put(313, new GatherConfig(1, true));
                put(501, new GatherConfig(1, true));
                put(118, new GatherConfig(2, true));
                put(124, new GatherConfig(2, true));
                put(126, new GatherConfig(2, true));
                put(414, new GatherConfig(2, true));
                put(116, new GatherConfig(3, false));
                put(117, new GatherConfig(3, false));
                put(308, new GatherConfig(3, false));
                put(403, new GatherConfig(3, false));
                put(318, new GatherConfig(3, false));
                put(408, new GatherConfig(3, false));
                put(409, new GatherConfig(3, false));
                put(410, new GatherConfig(3, false));
                put(411, new GatherConfig(3, false));
                put(412, new GatherConfig(3, false));
                put(413, new GatherConfig(3, false));
            }
        };
        if (cVar != null) {
            aVarArr = cVar.ext;
        } else {
            aVarArr = null;
        }
        if (aVarArr != null && aVarArr.length > 0) {
            for (c.a aVar : aVarArr) {
                if (aVar == null) {
                    GdtLog.e(TAG, "[createGatherConfigMap] error, unknown id");
                } else if (!hashMap.containsKey(Integer.valueOf(aVar.f109148id))) {
                    GdtLog.e(TAG, "[createGatherConfigMap] error, unknown id");
                } else {
                    GatherConfig gatherConfig = hashMap.get(Integer.valueOf(aVar.f109148id));
                    if (gatherConfig == null) {
                        GdtLog.e(TAG, "[createGatherConfigMap] error");
                    } else {
                        boolean[] zArr = aVar.f109149s;
                        if (zArr != null && zArr.length > 0) {
                            if (zArr.length != 3) {
                                GdtLog.e(TAG, "[createGatherConfigMap] error, ext[?].s.length error");
                            } else {
                                gatherConfig.enableUseInterface = zArr[0];
                                boolean z16 = zArr[1];
                                gatherConfig.enableUseFile = z16;
                                gatherConfig.enableWriteFile = z16;
                                gatherConfig.enableDeleteFile = zArr[2];
                                hashMap.put(Integer.valueOf(aVar.f109148id), gatherConfig);
                            }
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    @NonNull
    private static com.tencent.gathererga.tangram.c createIdSetting(GatherConfig gatherConfig, com.tencent.gathererga.core.e eVar, com.tencent.gathererga.core.e eVar2) {
        boolean z16;
        boolean z17;
        boolean z18;
        com.tencent.gathererga.tangram.c cVar = new com.tencent.gathererga.tangram.c();
        if (gatherConfig != null) {
            z16 = gatherConfig.enableUseInterface;
        } else {
            z16 = false;
        }
        cVar.k(z16);
        if (gatherConfig != null) {
            z17 = gatherConfig.enableUseFile;
        } else {
            z17 = false;
        }
        cVar.l(z17);
        if (gatherConfig != null) {
            z18 = gatherConfig.enableDeleteFile;
        } else {
            z18 = false;
        }
        cVar.h(z18);
        cVar.i(eVar);
        cVar.m(eVar2);
        cVar.j(false);
        c.a aVar = new c.a();
        aVar.e(true);
        cVar.g(aVar);
        return cVar;
    }

    @NonNull
    private static ConcurrentHashMap<Integer, com.tencent.gathererga.tangram.c> createIdSettingMap(com.tencent.gdtad.config.data.c cVar) {
        Map<Integer, GatherConfig> createGatherConfigMap = createGatherConfigMap(cVar);
        ConcurrentHashMap<Integer, com.tencent.gathererga.tangram.c> concurrentHashMap = new ConcurrentHashMap<>();
        if (createGatherConfigMap != null && !createGatherConfigMap.isEmpty()) {
            for (Map.Entry<Integer, GatherConfig> entry : createGatherConfigMap.entrySet()) {
                if (entry == null) {
                    GdtLog.e(TAG, "createIdSettingMap error, entry is null");
                } else {
                    int intValue = entry.getKey().intValue();
                    GatherConfig value = entry.getValue();
                    if (value == null) {
                        GdtLog.e(TAG, "createIdSettingMap error, config is null");
                    } else {
                        concurrentHashMap.put(Integer.valueOf(intValue), createIdSetting(value, createFetchPriority(value.gatherType, canGatherOnMainThread(intValue), value.enableWriteFile), createUpdatePriority(value.gatherType, canGatherOnMainThread(intValue), value.enableWriteFile)));
                    }
                }
            }
            return concurrentHashMap;
        }
        GdtLog.e(TAG, "createIdSettingMap error, map is null");
        return concurrentHashMap;
    }

    @Nullable
    private static com.tencent.gathererga.core.e createUpdatePriority(int i3, boolean z16, boolean z17) {
        if (i3 != 1) {
            if (i3 == 2) {
                return null;
            }
            if (i3 != 3) {
                GdtLog.e(TAG, "createUpdatePriority error, unknown gatherType");
                return null;
            }
            return com.tencent.gathererga.core.internal.provider.b.f().i().k().n().h(true).g(z17).f();
        }
        if (!z16) {
            return null;
        }
        return com.tencent.gathererga.core.internal.provider.b.f().i().h(true).g(false).f();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(105:13|(2:14|15)|16|(1:18)(1:212)|(1:20)(1:211)|21|(1:23)(1:210)|(1:25)(1:209)|26|(1:28)(1:208)|(1:30)(1:207)|31|(1:33)(1:206)|34|(1:36)(1:205)|(1:38)(1:204)|39|(1:41)|(1:43)(1:203)|(1:45)(1:202)|46|(1:201)(1:50)|51|(1:200)(1:55)|56|(79:195|196|(1:60)|61|(1:63)|64|(1:66)|67|(1:71)|72|(1:74)|75|(1:77)|78|(1:80)|81|(1:83)|84|(3:188|189|(1:191))|86|(1:88)|89|(1:91)|92|(1:94)|95|(1:97)|98|(1:100)|101|(1:103)|104|(1:106)|107|(1:109)|110|(1:112)|113|(1:115)|116|(1:118)|119|(1:121)|122|(1:124)|125|(1:127)|128|(1:130)|131|(1:133)|134|(1:136)|137|138|139|(1:141)|142|(1:144)|145|(1:147)|148|(1:150)|151|152|153|154|(1:156)|157|(1:159)|160|(1:162)|163|164|165|(1:167)|(1:178)(1:171)|172|(2:174|176)(1:177))|58|(0)|61|(0)|64|(0)|67|(2:69|71)|72|(0)|75|(0)|78|(0)|81|(0)|84|(0)|86|(0)|89|(0)|92|(0)|95|(0)|98|(0)|101|(0)|104|(0)|107|(0)|110|(0)|113|(0)|116|(0)|119|(0)|122|(0)|125|(0)|128|(0)|131|(0)|134|(0)|137|138|139|(0)|142|(0)|145|(0)|148|(0)|151|152|153|154|(0)|157|(0)|160|(0)|163|164|165|(0)|(1:169)|178|172|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(106:13|14|15|16|(1:18)(1:212)|(1:20)(1:211)|21|(1:23)(1:210)|(1:25)(1:209)|26|(1:28)(1:208)|(1:30)(1:207)|31|(1:33)(1:206)|34|(1:36)(1:205)|(1:38)(1:204)|39|(1:41)|(1:43)(1:203)|(1:45)(1:202)|46|(1:201)(1:50)|51|(1:200)(1:55)|56|(79:195|196|(1:60)|61|(1:63)|64|(1:66)|67|(1:71)|72|(1:74)|75|(1:77)|78|(1:80)|81|(1:83)|84|(3:188|189|(1:191))|86|(1:88)|89|(1:91)|92|(1:94)|95|(1:97)|98|(1:100)|101|(1:103)|104|(1:106)|107|(1:109)|110|(1:112)|113|(1:115)|116|(1:118)|119|(1:121)|122|(1:124)|125|(1:127)|128|(1:130)|131|(1:133)|134|(1:136)|137|138|139|(1:141)|142|(1:144)|145|(1:147)|148|(1:150)|151|152|153|154|(1:156)|157|(1:159)|160|(1:162)|163|164|165|(1:167)|(1:178)(1:171)|172|(2:174|176)(1:177))|58|(0)|61|(0)|64|(0)|67|(2:69|71)|72|(0)|75|(0)|78|(0)|81|(0)|84|(0)|86|(0)|89|(0)|92|(0)|95|(0)|98|(0)|101|(0)|104|(0)|107|(0)|110|(0)|113|(0)|116|(0)|119|(0)|122|(0)|125|(0)|128|(0)|131|(0)|134|(0)|137|138|139|(0)|142|(0)|145|(0)|148|(0)|151|152|153|154|(0)|157|(0)|160|(0)|163|164|165|(0)|(1:169)|178|172|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0551, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0552, code lost:
    
        com.tencent.gdtad.log.GdtLog.e(com.tencent.gdtad.util.GdtDeviceInfoHelper.TAG, "divided by 0", r0);
        r0 = -2.14748365E9f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x04bb, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x04bc, code lost:
    
        com.tencent.gdtad.log.GdtLog.e(com.tencent.gdtad.util.GdtDeviceInfoHelper.TAG, "fillDeviceInfo", r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x05d3 A[Catch: all -> 0x05fe, TryCatch #5 {all -> 0x05fe, blocks: (B:165:0x05cb, B:167:0x05d3, B:169:0x05e2, B:171:0x05ea, B:172:0x05f0, B:174:0x05f6), top: B:164:0x05cb }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x05f6 A[Catch: all -> 0x05fe, TRY_LEAVE, TryCatch #5 {all -> 0x05fe, blocks: (B:165:0x05cb, B:167:0x05d3, B:169:0x05e2, B:171:0x05ea, B:172:0x05f0, B:174:0x05f6), top: B:164:0x05cb }] */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0388 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void fillDeviceInfo(Context context, Params params, com.tencent.gdtad.config.data.c cVar, Result result) {
        String str;
        String str2;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        long j3;
        int i26;
        long j16;
        int i27;
        boolean z16;
        List<AdAnalysisEvent> list;
        long j17;
        int parseInt;
        int intFromGatherer;
        String stringFromGatherer;
        String stringFromGatherer2;
        String stringFromGatherer3;
        String stringFromGatherer4;
        int i28;
        String stringFromGatherer5;
        String packageName;
        int weChatAPIVer;
        String[] strArr;
        String stringFromGatherer6;
        String stringFromGatherer7;
        ArrayList<qq_common.DeviceExt.HevcCompatibilityInfo> hevcCompatibilityInfo;
        float f16;
        Boolean d16;
        String jSBundleInfo;
        Object pbToJson;
        String str3;
        if (context == null) {
            GdtLog.e(TAG, "create error");
            return;
        }
        if (result != null && result.deviceInfo != null) {
            com.tencent.mobileqq.util.a.c();
            com.tencent.gathererga.tangram.e a16 = com.tencent.mobileqq.util.a.a();
            if (a16 == null) {
                GdtLog.e(TAG, "gatherer is not init");
                return;
            }
            a16.c();
            updateSettings(cVar);
            try {
                com.tencent.mobileqq.util.a.e();
            } catch (Throwable th5) {
                GdtLog.e(TAG, "fillDeviceInfo", th5);
            }
            Map<Integer, com.tencent.gathererga.tangram.d> a17 = a16.a();
            long currentTimeMillis = System.currentTimeMillis();
            AdTAID.Entity entity = AdTAID.getInstance().getEntity(context);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (entity != null) {
                str = entity.aidTicket;
            } else {
                str = null;
            }
            if (entity != null) {
                str2 = entity.taidTicket;
            } else {
                str2 = null;
            }
            List<AdAnalysisEvent> list2 = result.eventsForAnalysis;
            if (entity != null) {
                i3 = entity.errorCodeForAidTicket;
            } else {
                i3 = Integer.MIN_VALUE;
            }
            if (entity != null) {
                i16 = entity.originErrorCode;
            } else {
                i16 = Integer.MIN_VALUE;
            }
            list2.add(AdAnalysisHelperForUtil.createEventForAidTicket(context, i3, i16, currentTimeMillis2));
            List<AdAnalysisEvent> list3 = result.eventsForAnalysis;
            if (entity != null) {
                i17 = entity.errorCodeForTaidTicket;
            } else {
                i17 = Integer.MIN_VALUE;
            }
            if (entity != null) {
                i18 = entity.originErrorCode;
            } else {
                i18 = Integer.MIN_VALUE;
            }
            list3.add(AdAnalysisHelperForUtil.createEventForTaidTicket(context, i17, i18, currentTimeMillis2));
            com.tencent.gathererga.tangram.d dVar = a17.get(305);
            result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, 1039, dVar));
            com.tencent.gathererga.tangram.d dVar2 = a17.get(308);
            String stringFromGatherer8 = getStringFromGatherer(dVar2);
            result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_USER_AGENT, dVar2));
            com.tencent.gathererga.tangram.d dVar3 = a17.get(128);
            String stringFromGatherer9 = getStringFromGatherer(dVar3);
            List<AdAnalysisEvent> list4 = result.eventsForAnalysis;
            boolean isEmpty = TextUtils.isEmpty(stringFromGatherer9);
            int i29 = LightConstants.ErrorCode.HEAD_INSET_RESOURCE_NOT_SUPPORT;
            if (!isEmpty) {
                i19 = 0;
            } else {
                i19 = -600;
            }
            if (dVar3 != null) {
                j3 = dVar3.c();
            } else {
                j3 = -2147483648L;
            }
            if (dVar3 != null) {
                i26 = dVar3.a();
            } else {
                i26 = Integer.MIN_VALUE;
            }
            list4.add(AdAnalysisHelperForUtil.createEventForDeviceIdentifier(context, 1150, i19, j3, i26));
            com.tencent.gathererga.tangram.d dVar4 = a17.get(318);
            String stringFromGatherer10 = getStringFromGatherer(dVar4);
            result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_WEBVIEW_USER_AGENT, dVar4));
            com.tencent.gathererga.tangram.d dVar5 = a17.get(408);
            String stringFromGatherer11 = getStringFromGatherer(dVar5);
            result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION, dVar5));
            com.tencent.gathererga.tangram.d dVar6 = a17.get(409);
            String stringFromGatherer12 = getStringFromGatherer(dVar6);
            result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_VERSION_CODENAME, dVar6));
            com.tencent.gathererga.tangram.d dVar7 = a17.get(410);
            String stringFromGatherer13 = getStringFromGatherer(dVar7);
            result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_BUILD_ID, dVar7));
            com.tencent.gathererga.tangram.d dVar8 = a17.get(411);
            String stringFromGatherer14 = getStringFromGatherer(dVar8);
            result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_VERSION_RELEASE_OR_CODENAME, dVar8));
            com.tencent.gathererga.tangram.d dVar9 = a17.get(412);
            String stringFromGatherer15 = getStringFromGatherer(dVar9);
            result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_VERSION_INCREMENTAL, dVar9));
            com.tencent.gathererga.tangram.d dVar10 = a17.get(413);
            String stringFromGatherer16 = getStringFromGatherer(dVar10);
            result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_JAVA_VM_VERSION, dVar10));
            com.tencent.gathererga.tangram.d dVar11 = a17.get(701);
            String stringFromGatherer17 = getStringFromGatherer(dVar11);
            List<AdAnalysisEvent> list5 = result.eventsForAnalysis;
            if (!TextUtils.isEmpty(stringFromGatherer17)) {
                i29 = 0;
            }
            if (dVar11 != null) {
                j16 = dVar11.c();
            } else {
                j16 = -2147483648L;
            }
            if (dVar11 != null) {
                i27 = dVar11.a();
            } else {
                i27 = Integer.MIN_VALUE;
            }
            list5.add(AdAnalysisHelperForUtil.createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_QIMEI36, i29, j16, i27));
            long currentTimeMillis3 = System.currentTimeMillis();
            AdLocation locationCache = AdLocationManager.getInstance().getLocationCache(context);
            if (locationCache != null && locationCache.isValid()) {
                z16 = true;
            } else {
                z16 = false;
            }
            List<AdAnalysisEvent> list6 = result.eventsForAnalysis;
            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
            if (z16 && locationCache.timeMillis != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                list = list6;
                j17 = System.currentTimeMillis() - locationCache.timeMillis;
            } else {
                list = list6;
                j17 = -2147483648L;
            }
            list.add(AdAnalysisHelperForUtil.createEventForLocation(context, z16, currentTimeMillis4, j17));
            String stringFromGatherer18 = getStringFromGatherer(dVar);
            try {
                if (!TextUtils.isEmpty(stringFromGatherer18)) {
                    try {
                        parseInt = Integer.parseInt(stringFromGatherer18);
                    } catch (Throwable th6) {
                        GdtLog.e(TAG, th6.getMessage());
                    }
                    if (parseInt >= 0) {
                        result.deviceInfo.carrier_code.set(parseInt);
                    }
                    intFromGatherer = getIntFromGatherer(a17.get(312), 0);
                    if (intFromGatherer >= 0) {
                        result.deviceInfo.conn.set(intFromGatherer);
                    }
                    com.tencent.gathererga.tangram.d dVar12 = a17.get(403);
                    stringFromGatherer = getStringFromGatherer(dVar12);
                    result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_OS_VERSION, dVar12));
                    if (!TextUtils.isEmpty(stringFromGatherer)) {
                        result.deviceInfo.os_ver.set(stringFromGatherer);
                    }
                    int i36 = 2;
                    result.deviceInfo.os_type.set(2);
                    if (locationCache != null && locationCache.isValid()) {
                        qq_ad_get.QQAdGet.DeviceInfo.Location location = new qq_ad_get.QQAdGet.DeviceInfo.Location();
                        location.coordinates_type.set(0);
                        location.latitude.set(Double.valueOf(locationCache.latitude * 1000000.0d).intValue());
                        location.longitude.set(Double.valueOf(locationCache.longitude * 1000000.0d).intValue());
                        result.deviceInfo.location.set(location);
                    }
                    com.tencent.gathererga.tangram.d dVar13 = a17.get(116);
                    stringFromGatherer2 = getStringFromGatherer(dVar13);
                    result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_MANUFACTURER, dVar13));
                    if (!TextUtils.isEmpty(stringFromGatherer2)) {
                        result.deviceInfo.manufacturer.set(stringFromGatherer2);
                    }
                    com.tencent.gathererga.tangram.d dVar14 = a17.get(117);
                    stringFromGatherer3 = getStringFromGatherer(dVar14);
                    result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_MODEL, dVar14));
                    if (!TextUtils.isEmpty(stringFromGatherer3)) {
                        result.deviceInfo.device_brand_and_model.set(stringFromGatherer3);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        result.deviceInfo.aid_ticket.set(str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        result.deviceInfo.taid_ticket.set(str2);
                    }
                    stringFromGatherer4 = getStringFromGatherer(a17.get(313));
                    if (!TextUtils.isEmpty(stringFromGatherer4)) {
                        try {
                            i28 = Integer.parseInt(stringFromGatherer4);
                        } catch (Throwable th7) {
                            GdtLog.e(TAG, th7.getMessage());
                            i28 = Integer.MIN_VALUE;
                        }
                        if (i28 >= 0) {
                            result.deviceInfo.origin_network_type.set(i28);
                        }
                    }
                    stringFromGatherer5 = getStringFromGatherer(a17.get(118));
                    if (!TextUtils.isEmpty(stringFromGatherer5)) {
                        result.deviceInfo.brand.set(stringFromGatherer5);
                    }
                    qq_common.DeviceExt.AttriDeviceInfo.UserAgentInfo.SystemInfo systemInfo = new qq_common.DeviceExt.AttriDeviceInfo.UserAgentInfo.SystemInfo();
                    if (!TextUtils.isEmpty(stringFromGatherer)) {
                        systemInfo.b_v_r.set(stringFromGatherer);
                    }
                    if (!TextUtils.isEmpty(stringFromGatherer3)) {
                        systemInfo.b_m.set(stringFromGatherer3);
                    }
                    if (!TextUtils.isEmpty(stringFromGatherer12)) {
                        systemInfo.b_v_c.set(stringFromGatherer12);
                    }
                    if (!TextUtils.isEmpty(stringFromGatherer13)) {
                        systemInfo.b_i.set(stringFromGatherer13);
                    }
                    if (!TextUtils.isEmpty(stringFromGatherer9)) {
                        systemInfo.sw_s.set(stringFromGatherer9);
                    }
                    if (!TextUtils.isEmpty(stringFromGatherer2)) {
                        systemInfo.b_mf.set(stringFromGatherer2);
                    }
                    if (!TextUtils.isEmpty(stringFromGatherer14)) {
                        systemInfo.b_r_o_c.set(stringFromGatherer14);
                    }
                    if (!TextUtils.isEmpty(stringFromGatherer16)) {
                        systemInfo.jvm_v.set(stringFromGatherer16);
                    }
                    if (!TextUtils.isEmpty(stringFromGatherer15)) {
                        systemInfo.b_v_i.set(stringFromGatherer15);
                    }
                    qq_common.DeviceExt.AttriDeviceInfo.UserAgentInfo userAgentInfo = new qq_common.DeviceExt.AttriDeviceInfo.UserAgentInfo();
                    userAgentInfo.s_i.set(systemInfo);
                    if (!TextUtils.isEmpty(stringFromGatherer11)) {
                        userAgentInfo.c_i.set(stringFromGatherer11);
                    }
                    qq_common.DeviceExt deviceExt = new qq_common.DeviceExt();
                    if (!TextUtils.isEmpty(stringFromGatherer8)) {
                        deviceExt.attri_info.f435906ua.set(stringFromGatherer8);
                    }
                    if (!TextUtils.isEmpty(stringFromGatherer10)) {
                        deviceExt.attri_info.w_u.set(stringFromGatherer10);
                    }
                    deviceExt.attri_info.ua_i.set(userAgentInfo);
                    packageName = context.getPackageName();
                    if (!TextUtils.isEmpty(packageName)) {
                        deviceExt.attri_info.app_bundle_id.set(packageName);
                    }
                    if (!TextUtils.isEmpty(stringFromGatherer17)) {
                        deviceExt.qi36.set(stringFromGatherer17);
                    }
                    weChatAPIVer = getWeChatAPIVer(context);
                    if (weChatAPIVer >= 0) {
                        deviceExt.wechat_installed_info.api_ver.set(weChatAPIVer);
                    }
                    PBEnumField pBEnumField = deviceExt.mqq_config_status;
                    if (cVar != null) {
                        i36 = 1;
                    }
                    pBEnumField.set(i36);
                    deviceExt.qqb_external_exp_info.traffic_type.set(26);
                    strArr = ((IGdtConfigManagerForExperimentAPI) QRoute.api(IGdtConfigManagerForExperimentAPI.class)).getExperimentIdList();
                    if (strArr != null) {
                        deviceExt.qqb_external_exp_info.exp_id.set(Arrays.asList(strArr));
                    }
                    deviceExt.harmony_sys_info.is_harmony_os.set(getBooleanFromGatherer(a17.get(126), false));
                    deviceExt.harmony_sys_info.harmony_pure_mode.set(getIntFromGatherer(a17.get(125), -1));
                    stringFromGatherer6 = getStringFromGatherer(a17.get(124));
                    if (!TextUtils.isEmpty(stringFromGatherer6)) {
                        deviceExt.harmony_sys_info.os_version.set(stringFromGatherer6);
                    }
                    stringFromGatherer7 = getStringFromGatherer(a17.get(414));
                    AdDevice.getInstance().setManufacturerOSVersion(stringFromGatherer7);
                    if (!TextUtils.isEmpty(stringFromGatherer7)) {
                        deviceExt.m_os.set(stringFromGatherer7);
                    }
                    hevcCompatibilityInfo = getHevcCompatibilityInfo();
                    if (hevcCompatibilityInfo != null) {
                        deviceExt.hevc_compatibility_info.set(hevcCompatibilityInfo);
                    }
                    f16 = FontSettingManager.getFontLevel() / 16.0f;
                    if (f16 > 0.0f) {
                        deviceExt.font_size.set(f16);
                    }
                    d16 = n.c().d(context);
                    result.eventsForAnalysis.add(AdAnalysisHelperForUtil.createEventForQuickApp(context, d16));
                    if (d16 != null) {
                        deviceExt.targeting_ability.support_quick_app_link.set(d16.booleanValue());
                    }
                    deviceExt.targeting_ability.web_wx_mgame.set(true);
                    jSBundleInfo = getJSBundleInfo(context, params);
                    if (!TextUtils.isEmpty(jSBundleInfo)) {
                        deviceExt.jsbundle_info.set(jSBundleInfo);
                    }
                    deviceExt.module_name.set(DKEngine.DKModuleID.PCAD_REWARD);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(9999);
                    deviceExt.jump_ability.set(arrayList);
                    deviceExt.device_model_type.set(AdDevice.getInstance().getDeviceType(context));
                    deviceExt.wechat_authorization_status.set(t.c());
                    pbToJson = GdtJsonPbUtil.pbToJson(deviceExt);
                    if (pbToJson instanceof JSONObject) {
                        ((JSONObject) pbToJson).put("client_mode", getClientMode());
                    }
                    if (pbToJson == null && !JSONObject.NULL.equals(pbToJson)) {
                        str3 = pbToJson.toString();
                    } else {
                        str3 = null;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        result.deviceInfo.device_ext.set(str3);
                        return;
                    }
                    return;
                }
                pbToJson = GdtJsonPbUtil.pbToJson(deviceExt);
                if (pbToJson instanceof JSONObject) {
                }
                if (pbToJson == null) {
                }
                str3 = null;
                if (TextUtils.isEmpty(str3)) {
                }
            } catch (Throwable th8) {
                GdtLog.e(TAG, "createV2", th8);
                return;
            }
            parseInt = 0;
            if (parseInt >= 0) {
            }
            intFromGatherer = getIntFromGatherer(a17.get(312), 0);
            if (intFromGatherer >= 0) {
            }
            com.tencent.gathererga.tangram.d dVar122 = a17.get(403);
            stringFromGatherer = getStringFromGatherer(dVar122);
            result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_OS_VERSION, dVar122));
            if (!TextUtils.isEmpty(stringFromGatherer)) {
            }
            int i362 = 2;
            result.deviceInfo.os_type.set(2);
            if (locationCache != null) {
                qq_ad_get.QQAdGet.DeviceInfo.Location location2 = new qq_ad_get.QQAdGet.DeviceInfo.Location();
                location2.coordinates_type.set(0);
                location2.latitude.set(Double.valueOf(locationCache.latitude * 1000000.0d).intValue());
                location2.longitude.set(Double.valueOf(locationCache.longitude * 1000000.0d).intValue());
                result.deviceInfo.location.set(location2);
            }
            com.tencent.gathererga.tangram.d dVar132 = a17.get(116);
            stringFromGatherer2 = getStringFromGatherer(dVar132);
            result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_MANUFACTURER, dVar132));
            if (!TextUtils.isEmpty(stringFromGatherer2)) {
            }
            com.tencent.gathererga.tangram.d dVar142 = a17.get(117);
            stringFromGatherer3 = getStringFromGatherer(dVar142);
            result.eventsForAnalysis.add(createEventForDeviceIdentifier(context, gdt_analysis_event.EVENT_GET_MODEL, dVar142));
            if (!TextUtils.isEmpty(stringFromGatherer3)) {
            }
            if (!TextUtils.isEmpty(str)) {
            }
            if (!TextUtils.isEmpty(str2)) {
            }
            stringFromGatherer4 = getStringFromGatherer(a17.get(313));
            if (!TextUtils.isEmpty(stringFromGatherer4)) {
            }
            stringFromGatherer5 = getStringFromGatherer(a17.get(118));
            if (!TextUtils.isEmpty(stringFromGatherer5)) {
            }
            qq_common.DeviceExt.AttriDeviceInfo.UserAgentInfo.SystemInfo systemInfo2 = new qq_common.DeviceExt.AttriDeviceInfo.UserAgentInfo.SystemInfo();
            if (!TextUtils.isEmpty(stringFromGatherer)) {
            }
            if (!TextUtils.isEmpty(stringFromGatherer3)) {
            }
            if (!TextUtils.isEmpty(stringFromGatherer12)) {
            }
            if (!TextUtils.isEmpty(stringFromGatherer13)) {
            }
            if (!TextUtils.isEmpty(stringFromGatherer9)) {
            }
            if (!TextUtils.isEmpty(stringFromGatherer2)) {
            }
            if (!TextUtils.isEmpty(stringFromGatherer14)) {
            }
            if (!TextUtils.isEmpty(stringFromGatherer16)) {
            }
            if (!TextUtils.isEmpty(stringFromGatherer15)) {
            }
            qq_common.DeviceExt.AttriDeviceInfo.UserAgentInfo userAgentInfo2 = new qq_common.DeviceExt.AttriDeviceInfo.UserAgentInfo();
            userAgentInfo2.s_i.set(systemInfo2);
            if (!TextUtils.isEmpty(stringFromGatherer11)) {
            }
            qq_common.DeviceExt deviceExt2 = new qq_common.DeviceExt();
            if (!TextUtils.isEmpty(stringFromGatherer8)) {
            }
            if (!TextUtils.isEmpty(stringFromGatherer10)) {
            }
            deviceExt2.attri_info.ua_i.set(userAgentInfo2);
            packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
            }
            if (!TextUtils.isEmpty(stringFromGatherer17)) {
            }
            weChatAPIVer = getWeChatAPIVer(context);
            if (weChatAPIVer >= 0) {
            }
            PBEnumField pBEnumField2 = deviceExt2.mqq_config_status;
            if (cVar != null) {
            }
            pBEnumField2.set(i362);
            deviceExt2.qqb_external_exp_info.traffic_type.set(26);
            strArr = ((IGdtConfigManagerForExperimentAPI) QRoute.api(IGdtConfigManagerForExperimentAPI.class)).getExperimentIdList();
            if (strArr != null) {
            }
            deviceExt2.harmony_sys_info.is_harmony_os.set(getBooleanFromGatherer(a17.get(126), false));
            deviceExt2.harmony_sys_info.harmony_pure_mode.set(getIntFromGatherer(a17.get(125), -1));
            stringFromGatherer6 = getStringFromGatherer(a17.get(124));
            if (!TextUtils.isEmpty(stringFromGatherer6)) {
            }
            stringFromGatherer7 = getStringFromGatherer(a17.get(414));
            AdDevice.getInstance().setManufacturerOSVersion(stringFromGatherer7);
            if (!TextUtils.isEmpty(stringFromGatherer7)) {
            }
            hevcCompatibilityInfo = getHevcCompatibilityInfo();
            if (hevcCompatibilityInfo != null) {
            }
            f16 = FontSettingManager.getFontLevel() / 16.0f;
            if (f16 > 0.0f) {
            }
            d16 = n.c().d(context);
            result.eventsForAnalysis.add(AdAnalysisHelperForUtil.createEventForQuickApp(context, d16));
            if (d16 != null) {
            }
            deviceExt2.targeting_ability.web_wx_mgame.set(true);
            jSBundleInfo = getJSBundleInfo(context, params);
            if (!TextUtils.isEmpty(jSBundleInfo)) {
            }
            deviceExt2.module_name.set(DKEngine.DKModuleID.PCAD_REWARD);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(9999);
            deviceExt2.jump_ability.set(arrayList2);
            deviceExt2.device_model_type.set(AdDevice.getInstance().getDeviceType(context));
            deviceExt2.wechat_authorization_status.set(t.c());
        } else {
            GdtLog.e(TAG, "create error, result is null");
        }
    }

    private static void fillDeviceInfoWithOthers(@Nullable Context context, @Nullable Params params, @Nullable Result result) {
        if (context != null && params != null && result != null && result.deviceInfo != null) {
            if (!TextUtils.isEmpty(GdtVersionUtil.getQQVersion())) {
                result.deviceInfo.qq_ver.set(GdtVersionUtil.getQQVersion());
            }
            if (AppSetting.f() >= 0) {
                result.deviceInfo.app_version_id.set(AppSetting.f());
            }
            result.deviceInfo.is_googleplay_version.set(false);
        }
    }

    private static void fillJSBundleInfoKuiklyVersion(Context context, Params params, JSONObject jSONObject) {
        com.tencent.gdtad.config.data.k kVar;
        String str = null;
        try {
            kVar = ((IGdtConfigAPI) QRoute.api(IGdtConfigAPI.class)).getConfigForWXCustomerService();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[fillJSBundleInfoKuiklyVersion]", th5);
            kVar = null;
        }
        if (kVar == null) {
            GdtLog.i(TAG, "[fillJSBundleInfoKuiklyVersion] not enabled");
            return;
        }
        int deviceType = AdDevice.getInstance().getDeviceType(context);
        if (deviceType != 1) {
            GdtLog.i(TAG, "[fillJSBundleInfoKuiklyVersion] not enabled, deviceType:" + deviceType);
            return;
        }
        try {
            long localVersion = ((IGdtKuiklyAPI) QRoute.api(IGdtKuiklyAPI.class)).getLocalVersion(context, "gdt_wx_customer_service_card_module", "gdt_wx_customer_service_card_page");
            if (localVersion > 0) {
                str = String.valueOf(localVersion);
            }
        } catch (Throwable th6) {
            QLog.e(TAG, 1, "[fillJSBundleInfoKuiklyVersion]", th6);
        }
        if (!TextUtils.isEmpty(str)) {
            AdJSONUtil.put(jSONObject, "qq_kuikly_wx_customer_service", str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void fillJSBundleInfoRewardVersion(Context context, Params params, JSONObject jSONObject) {
        String str;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(SWITCH_DYNAMIC_HIPPY_MOTIVE_AD, true)) {
            GdtLog.i(TAG, "[fillJSBundleInfoRewardVersion] hippy dynamic motive ad is offline, return null");
            return;
        }
        int deviceType = AdDevice.getInstance().getDeviceType(context);
        if (deviceType != 1 && deviceType != 2) {
            GdtLog.i(TAG, "[fillJSBundleInfoRewardVersion] error, not enabled, deviceType:" + deviceType);
            return;
        }
        if (params != null && params.supportOpenMotiveAd) {
            try {
                str = ((IGdtMotiveAPI) QRoute.api(IGdtMotiveAPI.class)).getJSBundleVersion();
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[fillJSBundleInfoRewardVersion]", th5);
            }
            if (TextUtils.isEmpty(str)) {
                AdJSONUtil.put(jSONObject, DKEngine.DKModuleID.PCAD_REWARD, str);
                return;
            }
            return;
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
        }
    }

    private static boolean getBooleanFromGatherer(@Nullable com.tencent.gathererga.tangram.d dVar, boolean z16) {
        if (dVar == null) {
            return z16;
        }
        if (dVar.getResult() instanceof Boolean) {
            return ((Boolean) dVar.getResult()).booleanValue();
        }
        return z16;
    }

    public static String getClientMode() {
        String str;
        if (QQTheme.isNowSimpleUI()) {
            str = PlatformInfor.SIMPLE_MODE;
        } else {
            str = "default";
        }
        if (SimpleUIUtil.isNowElderMode()) {
            str = PlatformInfor.ELDER_MODE;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            str = "teenager";
        }
        initAppSettingInOntherProcess();
        if (AppSetting.f99565y) {
            return str + "_talkback";
        }
        return str;
    }

    @Nullable
    private static String getHashStringFromGatherer(@Nullable com.tencent.gathererga.tangram.d dVar) {
        if (dVar == null) {
            return null;
        }
        return dVar.b();
    }

    @Nullable
    private static ArrayList<qq_common.DeviceExt.HevcCompatibilityInfo> getHevcCompatibilityInfo() {
        TPVCodecCapabilityForGet tPVCodecCapabilityForGet;
        try {
            tPVCodecCapabilityForGet = com.tencent.superplayer.utils.e.c(172);
        } catch (Throwable th5) {
            GdtLog.e(TAG, "[getHevcCompatibilityInfoV2]", th5);
            tPVCodecCapabilityForGet = null;
        }
        if (tPVCodecCapabilityForGet == null) {
            GdtLog.e(TAG, "[getHevcCompatibilityInfoV2] error");
            return null;
        }
        if (tPVCodecCapabilityForGet.getMaxLumaSamples() != -1 && tPVCodecCapabilityForGet.getMaxFramerateFormaxLumaSamples() != -1) {
            qq_common.DeviceExt.HevcCompatibilityInfo hevcCompatibilityInfo = new qq_common.DeviceExt.HevcCompatibilityInfo();
            hevcCompatibilityInfo.video_player_type.set(1);
            if (tPVCodecCapabilityForGet.getMaxLumaSamples() > 0) {
                hevcCompatibilityInfo.max_luma_samples.set(tPVCodecCapabilityForGet.getMaxLumaSamples());
            }
            if (tPVCodecCapabilityForGet.getMaxFramerateFormaxLumaSamples() > 0) {
                hevcCompatibilityInfo.max_fps.set(tPVCodecCapabilityForGet.getMaxFramerateFormaxLumaSamples());
            }
            ArrayList<qq_common.DeviceExt.HevcCompatibilityInfo> arrayList = new ArrayList<>();
            arrayList.add(hevcCompatibilityInfo);
            return arrayList;
        }
        GdtLog.d(TAG, "[getHevcCompatibilityInfoV2] error, value is -1");
        return null;
    }

    private static int getIntFromGatherer(@Nullable com.tencent.gathererga.tangram.d dVar, int i3) {
        if (dVar == null) {
            return i3;
        }
        if (dVar.getResult() instanceof Integer) {
            return ((Integer) dVar.getResult()).intValue();
        }
        return i3;
    }

    private static String getJSBundleInfo(Context context, Params params) {
        boolean z16;
        try {
            z16 = ((IGdtConfigAPI) QRoute.api(IGdtConfigAPI.class)).isJSBundleV2Enabled();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[getJSBundleInfo]", th5);
            z16 = false;
        }
        if (z16) {
            return getJSBundleInfoV2(context, params);
        }
        return getJSBundleInfoV1(params);
    }

    @Nullable
    private static String getJSBundleInfoV1(@Nullable Params params) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(SWITCH_DYNAMIC_HIPPY_MOTIVE_AD, true)) {
            GdtLog.i(TAG, "[getJSBundleInfoV1] hippy dynamic motive ad is offline, return null");
            return null;
        }
        if (params != null && params.supportOpenMotiveAd) {
            int deviceType = AdDevice.getInstance().getDeviceType(BaseApplication.getContext());
            if (deviceType != 1 && deviceType != 2) {
                GdtLog.i(TAG, "[getJSBundleInfoV1] error, not enabled, deviceType:" + deviceType);
                return null;
            }
            try {
                return ((IGdtMotiveAPI) QRoute.api(IGdtMotiveAPI.class)).getJsBundleInfo();
            } catch (Throwable th5) {
                GdtLog.e(TAG, "[getJSBundleInfoV1] error", th5);
                return null;
            }
        }
        GdtLog.d(TAG, "[getJSBundleInfoV1] params don't support");
        return null;
    }

    public static String getJSBundleInfoV2(Context context, Params params) {
        JSONObject newJSONObject = AdJSONUtil.newJSONObject();
        fillJSBundleInfoRewardVersion(context, params, newJSONObject);
        fillJSBundleInfoKuiklyVersion(context, params, newJSONObject);
        String adJSONUtil = AdJSONUtil.toString(newJSONObject);
        if (newJSONObject.length() <= 0) {
            return null;
        }
        return adJSONUtil;
    }

    @Nullable
    private static String getStringFromGatherer(@Nullable com.tencent.gathererga.tangram.d dVar) {
        if (dVar == null) {
            return null;
        }
        if (dVar.getResult() instanceof String) {
            return (String) dVar.getResult();
        }
        if (!(dVar.getResult() instanceof Integer)) {
            return null;
        }
        return dVar.getResult().toString();
    }

    public static int getWeChatAPIVer(@Nullable Context context) {
        Bundle bundle;
        if (context == null) {
            GdtLog.e(TAG, "getWXAppSupportAPI: context is null");
            return 0;
        }
        try {
            if (context.getPackageManager() == null) {
                GdtLog.e(TAG, "getWXAppSupportAPI: getPackageManager is null");
                return 0;
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.tencent.mm", 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return 0;
            }
            return bundle.getInt(WX_OPENSDK_VERSION, 0);
        } catch (Throwable th5) {
            GdtLog.e(TAG, "getWXAppSupportAPI: error " + th5);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Context context) {
        AdTAID.getInstance().init(context);
        AdLocationManager.getInstance().init(context);
    }

    private static void initAppSettingInOntherProcess() {
        boolean z16;
        if (MobileQQ.sProcessId != 1 && !AppSetting.f99565y) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) MobileQQ.sMobileQQ.getSystemService("accessibility");
                boolean isEnabled = accessibilityManager.isEnabled();
                boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
                if (isEnabled && isTouchExplorationEnabled) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                AppSetting.f99565y = z16;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "initAppSettingInOntherProcess", th5);
            }
        }
    }

    private static void reportForAnalysis(Context context, @Nullable Params params, @Nullable Result result) {
        List<AdAnalysisEvent> list;
        if (params != null && result != null && (list = result.eventsForAnalysis) != null && !list.isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (sTimeMillis != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && currentTimeMillis - sTimeMillis < 60000) {
                return;
            }
            sTimeMillis = currentTimeMillis;
            GdtLog.i(TAG, "reportForAnalysis");
            AdAnalysis.getInstance().handleAsync(new WeakReference<>(context), result.eventsForAnalysis);
        }
    }

    public static void updateSettings(com.tencent.gdtad.config.data.c cVar) {
        com.tencent.mobileqq.util.a.c();
        com.tencent.gathererga.tangram.e a16 = com.tencent.mobileqq.util.a.a();
        ConcurrentHashMap<Integer, com.tencent.gathererga.tangram.c> createIdSettingMap = createIdSettingMap(cVar);
        if (a16 != null) {
            a16.f(createIdSettingMap);
        }
    }
}
