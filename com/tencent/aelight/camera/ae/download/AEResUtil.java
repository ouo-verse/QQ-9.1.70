package com.tencent.aelight.camera.ae.download;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.j;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack;
import com.tencent.aelight.camera.qipc.api.IAECameraGetInfoServer;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.video.decode.AVDecodeError;
import common.config.service.QzoneConfig;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mqq.app.MobileQQ;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEResUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, AEResBeanWrapper> f63640a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f63641b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f63642c = new AtomicInteger(-1);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.aelight.camera.download.api.a f63644d;

        a(com.tencent.aelight.camera.download.api.a aVar) {
            this.f63644d = aVar;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Bundle bundle;
            ms.a.c("AEResUtil", "bundle download QIPCClientHelper onCallback");
            if (eIPCResult == null || (bundle = eIPCResult.data) == null) {
                return;
            }
            String string = bundle.getString("action_type");
            string.hashCode();
            if (string.equals("ACTION_DOWNLOAD_AE_RES_CALLBACK") && eIPCResult.isSuccess()) {
                String string2 = eIPCResult.data.getString("KEY_RES_AGENT_TYPE");
                int i3 = eIPCResult.data.getInt("KEY_RES_ERROR_TYPE");
                ms.a.c("AEResUtil", "bundle download call back agentType " + string2 + " errorType" + i3);
                if (this.f63644d != null) {
                    for (AEResInfo aEResInfo : AEResInfo.values) {
                        if (aEResInfo.agentType.equals(string2)) {
                            this.f63644d.onAEDownloadFinish(aEResInfo, null, true, i3);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IAEMultiDownloadCallBack f63645d;

        b(IAEMultiDownloadCallBack iAEMultiDownloadCallBack) {
            this.f63645d = iAEMultiDownloadCallBack;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Bundle bundle;
            ms.a.c("AEResUtil", "preDownloadEditorEssentialBundles bundle download QIPCClientHelper onCallback");
            if (eIPCResult == null || (bundle = eIPCResult.data) == null) {
                return;
            }
            String string = bundle.getString("action_type");
            string.hashCode();
            if (string.equals("ACTION_PRE_DOWNLOAD_EDITOR_ESSENTIALS") && eIPCResult.isSuccess()) {
                AEResInfo aEResInfo = (AEResInfo) eIPCResult.data.getSerializable("KEY_RES_AGENT_TYPE");
                int i3 = eIPCResult.data.getInt("KEY_RES_ERROR_TYPE");
                boolean z16 = eIPCResult.data.getBoolean("KEY_RES_EXIT_STATUS");
                ms.a.c("AEResUtil", "bundle download call back agentType " + aEResInfo + " errorType" + i3);
                IAEMultiDownloadCallBack iAEMultiDownloadCallBack = this.f63645d;
                if (iAEMultiDownloadCallBack != null) {
                    iAEMultiDownloadCallBack.onAEMultiDownloadFinish(aEResInfo, z16, i3);
                }
            }
        }
    }

    public static String A() {
        return g.a.C0559a.f65251e;
    }

    public static String B(String str) {
        String str2;
        ms.a.a("AEResUtil", "[verifyResource] filepath " + str);
        if (TextUtils.isEmpty(str)) {
            ms.a.c("AEResUtil", "[verifyResource] filePath :null");
            return "";
        }
        File file = new File(str);
        if (!file.exists()) {
            ms.a.c("AEResUtil", "|verifyResource() file[" + str + "] not exist..");
            return "";
        }
        try {
            try {
                str2 = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
            } catch (UnsatisfiedLinkError unused) {
                str2 = com.tencent.qqprotect.singleupdate.a.d(file);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            str2 = null;
        }
        ms.a.c("AEResUtil", "verifyResource() ,md5=" + str2);
        return str2 == null ? "" : str2;
    }

    public static List<String> C(VideoMaterial videoMaterial) {
        if (videoMaterial != null && videoMaterial.getLightAsset() != null) {
            String[] renderAgentTypes = videoMaterial.getLightAsset().getRenderAgentTypes();
            if (renderAgentTypes == null) {
                ms.a.c("AEResUtil", "resultStr is null");
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList(Arrays.asList(renderAgentTypes));
            ms.a.f("AEResUtil", "material needed agents origin=" + arrayList);
            if (arrayList.removeAll(AEResInfo.AGENT_TYPES_IN_FACE_BUNDLE)) {
                if (!arrayList.contains("FACE_AGENT")) {
                    arrayList.add("FACE_AGENT");
                }
                ms.a.f("AEResUtil", "material needed agents after handle=" + arrayList);
            }
            if (arrayList.removeAll(AEResInfo.AGENT_TYPES_IN_3DMM_BUNDLE)) {
                if (!arrayList.contains("k3D_MM_AGENT")) {
                    arrayList.add("k3D_MM_AGENT");
                }
                ms.a.f("AEResUtil", "material needed agents after handle=" + arrayList);
            }
            return arrayList;
        }
        ms.a.c("AEResUtil", "videoMaterial is null");
        return new ArrayList();
    }

    public static List<String> D(VideoMaterial videoMaterial) {
        return E(videoMaterial, QQWinkConstants.ENTRY_QQ_OTHER);
    }

    public static List<String> E(VideoMaterial videoMaterial, String str) {
        List<String> C = C(videoMaterial);
        ArrayList arrayList = new ArrayList();
        for (String str2 : C) {
            if (!W(str2, str)) {
                arrayList.add(str2);
            }
        }
        ms.a.a("AEResUtil", "all needed agentTypes=" + C + ", need download agentTypes=" + arrayList);
        return arrayList;
    }

    public static List<String> F(List<AEResInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (AEResInfo aEResInfo : list) {
                if (!U(aEResInfo)) {
                    ms.a.f("AEResUtil", "need download agentType");
                    arrayList.add(aEResInfo.agentType);
                }
            }
        }
        return arrayList;
    }

    public static List<String> G(List<String> list) {
        Stream stream;
        Stream filter;
        Collector list2;
        Object collect;
        stream = list.stream();
        filter = stream.filter(new Predicate() { // from class: com.tencent.aelight.camera.ae.download.p
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean h06;
                h06 = AEResUtil.h0((String) obj);
                return h06;
            }
        });
        list2 = Collectors.toList();
        collect = filter.collect(list2);
        return (List) collect;
    }

    public static String J(String str) {
        return H(l(str));
    }

    public static String N(AEResInfo aEResInfo) {
        AEResBeanWrapper l3;
        String str;
        return (aEResInfo == null || TextUtils.isEmpty(aEResInfo.agentType) || (l3 = l(aEResInfo.agentType)) == null || (str = l3.version) == null) ? AEResManagerConfigBean.DEFAULT_VERSION : str;
    }

    public static Map<String, AEResBeanWrapper> O() {
        return f63640a;
    }

    public static boolean Q() {
        return FeatureManager.isBasicFeaturesFunctionReady();
    }

    public static boolean R() {
        return FeatureManager.isBasicFeaturesFunctionReady();
    }

    public static boolean V(String str) {
        return W(str, QQWinkConstants.ENTRY_QQ_OTHER);
    }

    public static boolean W(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            ms.a.c("AEResUtil", "agentType is null ");
            return false;
        }
        if (AEResInfo.AGENT_TYPES_IN_FACE_BUNDLE.contains(str)) {
            str = "FACE_AGENT";
        }
        if (AEResInfo.AGENT_TYPES_IN_3DMM_BUNDLE.contains(str)) {
            str = "k3D_MM_AGENT";
        }
        AEResBeanWrapper l3 = l(str);
        if (l3 == null) {
            ms.a.c("AEResUtil", "wrapper is null " + str);
            return false;
        }
        return S(l3);
    }

    private static boolean X(String str) {
        return AEResInfo.LIGHT_SDK_BASIC32.equals(str) || AEResInfo.LIGHT_SDK_BASIC64.equals(str) || AEResInfo.AGENT_TYPE_AE_BASE_RES.equals(str);
    }

    public static boolean Y() {
        return j0();
    }

    public static boolean Z() {
        return a0(QQWinkConstants.ENTRY_QQ_OTHER);
    }

    public static boolean a0(String str) {
        return (n(AEResInfo.AE_RES_BASE_PACKAGE.agentType, str) == 1 && n(AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType, str) == 1) ? false : true;
    }

    public static boolean b(AEResInfo aEResInfo) {
        return U(aEResInfo);
    }

    public static boolean b0() {
        return c0(QQWinkConstants.ENTRY_QQ_OTHER);
    }

    public static void c() {
        ms.a.a("AEResUtil", "checkSyncBeanWrapperMap");
        AtomicBoolean atomicBoolean = f63641b;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                return;
            }
            e();
            atomicBoolean.set(true);
            if (QLog.isColorLevel()) {
                ms.a.a("AEResUtil", "sync finish, map=" + f63640a);
            }
        }
    }

    public static boolean c0(String str) {
        return W(AEResInfo.AE_RES_BASE_PACKAGE.agentType, str) && W(AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType, str);
    }

    public static void d() {
        ms.a.a("AEResUtil", "doASync");
        AtomicBoolean atomicBoolean = f63641b;
        if (atomicBoolean.get()) {
            ms.a.c("AEResUtil", "HASSYNCED repeat doASync");
            return;
        }
        ms.a.a("AEResUtil", "doASync start");
        e();
        ms.a.a("AEResUtil", "doASync end");
        atomicBoolean.set(true);
    }

    public static boolean d0() {
        return FeatureManager.Features.LIGHT_SDK.isFunctionReady();
    }

    private static void e() {
        Bundle bundle;
        Serializable serializable;
        Map<String, AEResBeanWrapper> map = f63640a;
        map.clear();
        if (e0()) {
            map.putAll(AEResManager.J().G());
            return;
        }
        if (QzoneConfig.enableDoNewSync() && Looper.myLooper() == Looper.getMainLooper()) {
            AENewResUtilKt.b();
            return;
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), IAECameraGetInfoServer.NAME, "ACTION_SYNC_AE_RES_WRAPPER_MAP", new Bundle());
        if (callServer != null && (bundle = callServer.data) != null) {
            try {
                serializable = bundle.getSerializable("KEY_RESP_COMMON_DATA_KEY");
            } catch (Exception e16) {
                ms.a.c("AEResUtil", "doSync result getSerializable error. " + e16.getMessage());
                serializable = null;
            }
            if (serializable != null && (serializable instanceof Map)) {
                f63640a.putAll((Map) serializable);
                return;
            }
            return;
        }
        ms.a.c("AEResUtil", "doSync result is null or result.data is null.");
    }

    public static boolean e0() {
        return MobileQQ.PACKAGE_NAME.equals(BaseApplication.processName);
    }

    public static void f(final String str) {
        ms.a.a("AEResUtil", "pre: downloadMaterialNeedBundle");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResUtil.4
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent(com.tencent.aelight.camera.aebase.a.a().getApplicationContext(), (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass());
                intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 8);
                intent.putExtra("local_path", str);
                try {
                    com.tencent.aelight.camera.aebase.a.a().getApplicationContext().startService(intent);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AEResUtil", 2, "preLoadPeakProcess, ", th5);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AEResUtil", 2, "preLoadPeakProcess");
                }
            }
        }, 64, null, false);
    }

    public static boolean f0() {
        return V(AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType) && V(AEResInfo.LIGHT_RES_FILAMENT.agentType) && V(AEResInfo.LIGHT_RES_PAG.agentType);
    }

    public static void g(List<String> list, boolean z16) {
        ms.a.f("AEResUtil", "downloadMultiBundles" + z16);
        if (list == null || list.size() == 0) {
            return;
        }
        ms.a.a("PreCheckAERes", "[setMaterial] bundleStatus not ready, go fetch bundles ...");
        for (String str : list) {
            if (z16) {
                i(str);
            } else {
                h(str);
            }
        }
    }

    public static void g0(AEResBeanWrapper aEResBeanWrapper) {
        if (aEResBeanWrapper == null) {
            ms.a.c("AEResUtil", "aeResInfo is null");
            return;
        }
        if (!AENewResUtilKt.c(aEResBeanWrapper.agentType) || wq.a.g()) {
            return;
        }
        aEResBeanWrapper.md5 = aEResBeanWrapper.backupMd5;
        aEResBeanWrapper.url = aEResBeanWrapper.backupUrl;
        ms.a.f("AEResUtil", "do not gzip sdk should change url : " + aEResBeanWrapper.md5);
    }

    public static void h(String str) {
        if (V(str)) {
            return;
        }
        ms.a.f("AEResUtil", "downloadSingleBundle : " + str);
        if (e0()) {
            AEResManager.J().w0(str, null, false);
        } else {
            o0(str, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean h0(String str) {
        return !str.equals(LightConstants.AgentType.QNN_HTP_BUNDLE);
    }

    public static void i(String str) {
        if (V(str)) {
            return;
        }
        ms.a.f("AEResUtil", "downloadSingleBundleHighPriority : " + str);
        if (e0()) {
            AEResManager.J().x0(str, null, false);
        } else {
            o0(str, true);
        }
    }

    private static boolean i0(String str) {
        try {
            AENewResUtilKt.d(str);
            return true;
        } catch (Throwable th5) {
            ms.a.d("AEResUtil", "load error", th5);
            return false;
        }
    }

    public static void j(String str, com.tencent.aelight.camera.download.api.a aVar) {
        if (!V(str)) {
            ms.a.f("AEResUtil", "bundle download downloadSingleBundleWithCallBack : " + str);
            if (e0()) {
                AEResManager.J().w0(str, aVar, false);
                return;
            } else {
                p0(str, aVar);
                return;
            }
        }
        if (aVar != null) {
            for (AEResInfo aEResInfo : AEResInfo.values) {
                if (aEResInfo.agentType.equals(str)) {
                    aVar.onAEDownloadFinish(aEResInfo, null, true, 1);
                }
            }
        }
    }

    public static synchronized boolean j0() {
        boolean Q;
        synchronized (AEResUtil.class) {
            if (!Q()) {
                if (com.tencent.aelight.camera.ae.d.h()) {
                    ms.a.c("AEResUtil", "SoLoader.loadSvFilterSo success:" + FeatureManager.loadBasicFeatures());
                } else {
                    ms.a.c("AEResUtil", "SoLoader.loadSvFilterSo success: false -> AEKitForQQ init failed");
                }
            }
            Q = Q();
        }
        return Q;
    }

    public static String k() {
        return I(AEResInfo.AE_RES_BASE_PACKAGE);
    }

    public static synchronized boolean k0() {
        boolean j06;
        synchronized (AEResUtil.class) {
            j06 = j0();
        }
        return j06;
    }

    private static AEResBeanWrapper l(String str) {
        c();
        return f63640a.get(str);
    }

    public static synchronized boolean l0() {
        synchronized (AEResUtil.class) {
            AEResInfo aEResInfo = AEResInfo.LIGHT_RES_FILAMENT;
            if (U(aEResInfo)) {
                String J = J(aEResInfo.agentType);
                try {
                    System.loadLibrary(AECameraConstants.LIB_V8);
                    boolean i06 = i0(J + AECameraConstants.FILAMENT_NAME);
                    ms.a.c("AEResUtil", "loadFilamentResult" + i06);
                    return i06;
                } catch (Throwable th5) {
                    ms.a.d("AEResUtil", "loadFilamentResult error", th5);
                }
            }
            return false;
        }
    }

    public static synchronized boolean m0() {
        synchronized (AEResUtil.class) {
            AEResInfo aEResInfo = AEResInfo.LIGHT_RES_PAG;
            if (U(aEResInfo)) {
                String J = J(aEResInfo.agentType);
                try {
                    System.loadLibrary(AECameraConstants.LIB_V8);
                    boolean i06 = i0(J + AECameraConstants.LIB_PAG);
                    ms.a.c("AEResUtil", "loadPagResult" + i06);
                    return i06;
                } catch (Throwable th5) {
                    ms.a.d("AEResUtil", "loadLib error", th5);
                }
            }
            return false;
        }
    }

    public static int n(String str, String str2) {
        int i3;
        if (com.tencent.mobileqq.shortvideo.util.f.m()) {
            i3 = W(str, str2) ? 1 : 2;
        } else {
            i3 = 0;
        }
        ms.a.a("AEResUtil", "getFilterSoState " + i3);
        return i3;
    }

    public static synchronized boolean n0() {
        boolean z16;
        synchronized (AEResUtil.class) {
            AEResInfo aEResInfo = AEResInfo.LIGHT_RES_FILAMENT;
            if (U(aEResInfo) && U(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
                AEResInfo aEResInfo2 = AEResInfo.LIGHT_RES_PAG;
                if (U(aEResInfo2)) {
                    String z17 = z();
                    String J = J(aEResInfo.agentType);
                    String J2 = J(aEResInfo2.agentType);
                    try {
                        System.loadLibrary(AECameraConstants.LIB_V8);
                        if (i0(J2 + AECameraConstants.LIB_PAG)) {
                            if (i0(J + AECameraConstants.FILAMENT_NAME)) {
                                if (i0(z17 + AECameraConstants.LIB_LIGHT)) {
                                    z16 = true;
                                    ms.a.c("AEResUtil", "loadLightResult" + z16);
                                    return z16;
                                }
                            }
                        }
                        z16 = false;
                        ms.a.c("AEResUtil", "loadLightResult" + z16);
                        return z16;
                    } catch (Throwable th5) {
                        ms.a.d("AEResUtil", "loadLib error", th5);
                    }
                }
            }
            return false;
        }
    }

    public static Map<String, String> o() {
        HashMap hashMap = new HashMap();
        c();
        for (Map.Entry<String, AEResBeanWrapper> entry : f63640a.entrySet()) {
            if (!X(entry.getKey())) {
                AEResBeanWrapper value = entry.getValue();
                if (T(value, false)) {
                    hashMap.put(entry.getKey(), t(value));
                }
            }
        }
        return hashMap;
    }

    public static void o0(String str, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putString("KEY_RES_AGENTTYPE", str);
        bundle.putBoolean("KEY_RES_PRIORITY", z16);
        QIPCClientHelper.getInstance().getClient().callServer(IAECameraGetInfoServer.NAME, "ACTION_DOWNLOAD_AE_RES", bundle, null);
    }

    public static String p(String str) {
        return AECameraPrefsUtil.f().j("key_ae_light_res_md5_" + str, "", 4);
    }

    public static void p0(String str, com.tencent.aelight.camera.download.api.a aVar) {
        ms.a.c("AEResUtil", "bundle download peakRequestAEBundlesCallBack " + str);
        Bundle bundle = new Bundle();
        bundle.putString("KEY_RES_AGENTTYPE", str);
        QIPCClientHelper.getInstance().getClient().callServer(IAECameraGetInfoServer.NAME, "ACTION_DOWNLOAD_AE_RES_CALLBACK", bundle, new a(aVar));
    }

    public static String q() {
        return j.b.f65593a + File.separator;
    }

    public static void q0() {
        ms.a.c("AEResUtil", "preDownloadAllEssentialBundles");
        if (e0()) {
            AEResManager.J().k0();
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    QIPCClientHelper.getInstance().getClient().callServer(IAECameraGetInfoServer.NAME, "ACTION_PRE_DOWNLOAD_ALL_ESSENTIALS", new Bundle(), null);
                }
            }, 128, null, true);
        }
    }

    public static void r0() {
        ms.a.f("AEResUtil", "preDownloadAllNonEssentialBundles");
        if (e0()) {
            AEResManager.J().l0();
        } else {
            QIPCClientHelper.getInstance().getClient().callServer(IAECameraGetInfoServer.NAME, "ACTION_PRE_DOWNLOAD_ALL_NON_ESSENTIALS", new Bundle(), null);
        }
    }

    public static String s() {
        AEResBeanWrapper l3 = l(AEResInfo.LIGHT_RES_BASE_PACKAGE.agentType);
        if (!S(l3)) {
            ms.a.c("AEResUtil", "[getLightAssetsDir]: LightBasePackage not exist, return empty path!");
            return "";
        }
        return H(l3) + "assets" + File.separator;
    }

    public static void s0(IAEMultiDownloadCallBack iAEMultiDownloadCallBack) {
        ms.a.c("AEResUtil", "preDownloadEditorEssentialBundles");
        if (e0()) {
            AEResManager.J().m0(iAEMultiDownloadCallBack);
        } else {
            QIPCClientHelper.getInstance().getClient().callServer(IAECameraGetInfoServer.NAME, "ACTION_PRE_DOWNLOAD_EDITOR_ESSENTIALS", new Bundle(), new b(iAEMultiDownloadCallBack));
        }
        h("FACE_AGENT");
    }

    public static void t0() {
        ms.a.c("AEResUtil", "preDownloadAllEssentialBundles");
        if (e0()) {
            AEResManager.J().n0();
        } else {
            QIPCClientHelper.getInstance().getClient().callServer(IAECameraGetInfoServer.NAME, "ACTION_PRE_DOWNLOAD_SDK_ESSENTIALS", new Bundle(), null);
        }
    }

    public static String v(String str) {
        return t(l(str));
    }

    public static void v0(String str, String str2) {
        AECameraPrefsUtil.f().p("key_ae_light_res_md5_" + str, str2, 4);
    }

    public static String w() {
        String s16 = s();
        if (TextUtils.isEmpty(s16)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(s16);
        sb5.append(WadlProxyConsts.KEY_MATERIAL);
        String str = File.separator;
        sb5.append(str);
        sb5.append("video_empty");
        sb5.append(str);
        sb5.append(TemplateBean.TEMPLATE_JSON);
        return sb5.toString();
    }

    public static int w0(String str, String str2) {
        String str3;
        ms.a.a("AEResUtil", "|verifyResource() lResMd5=" + str + ", filepath=" + str2);
        if (TextUtils.isEmpty(str2)) {
            ms.a.c("AEResUtil", "[verifyResource] filePath :null");
            return -105;
        }
        if (TextUtils.isEmpty(str)) {
            ms.a.c("AEResUtil", "[verifyResource] lResMd5 :null");
            return -106;
        }
        File file = new File(str2);
        if (!file.exists()) {
            ms.a.c("AEResUtil", "|verifyResource() file[" + str2 + "] not exist..");
            return -107;
        }
        try {
            try {
                str3 = HexUtil.bytes2HexStr(MD5.getFileMd5(str2));
            } catch (Exception e16) {
                e16.printStackTrace();
                str3 = null;
            }
        } catch (UnsatisfiedLinkError unused) {
            str3 = com.tencent.qqprotect.singleupdate.a.d(file);
        }
        ms.a.a("AEResUtil", "|verifyResource()  lResMd5=" + str + ",md5=" + str3);
        if (str.equalsIgnoreCase(str3)) {
            return 0;
        }
        ms.a.c("AEResUtil", "[verifyResource] equalsIgnoreCase :false");
        return AVDecodeError.VIDEO_DECODE_V_ERR;
    }

    public static String x() {
        String s16 = s();
        if (TextUtils.isEmpty(s16)) {
            return "";
        }
        return s16 + WadlProxyConsts.KEY_MATERIAL + File.separator + "video_empty_segmentation";
    }

    @Deprecated
    public static String y() {
        AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BASE_PACKAGE;
        if (!U(aEResInfo)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(I(aEResInfo));
        sb5.append("assets");
        String str = File.separator;
        sb5.append(str);
        sb5.append(IQQGameCommApi.K_ABTEST_MODELS);
        sb5.append(str);
        return sb5.toString();
    }

    public static String z() {
        return I(AEResInfo.LIGHT_RES_BASE_PACKAGE);
    }

    public static boolean S(AEResBeanWrapper aEResBeanWrapper) {
        return T(aEResBeanWrapper, true);
    }

    public static boolean T(AEResBeanWrapper aEResBeanWrapper, boolean z16) {
        if (aEResBeanWrapper == null) {
            ms.a.c("AEResUtil", "[isAEResExist] aeResInfo is null ");
            return false;
        }
        g0(aEResBeanWrapper);
        String H = H(aEResBeanWrapper);
        String L = L(aEResBeanWrapper);
        if (!TextUtils.isEmpty(H) && !TextUtils.isEmpty(L)) {
            File file = new File(H);
            if (!file.exists()) {
                if (z16) {
                    ms.a.c("AEResUtil", "[isAEResExist] exists=false, aeResInfo=" + aEResBeanWrapper);
                } else {
                    ms.a.a("AEResUtil", "[isAEResExist] exists=false, aeResInfo=" + aEResBeanWrapper);
                }
                return false;
            }
            k.c(aEResBeanWrapper, H, null, false);
            if (AEResInfo.AGENT_TYPE_AE_BASE_RES.equals(aEResBeanWrapper.agentType)) {
                return FeatureManager.Features.YT_COMMON.isSoReadyInDirectory(H) && FeatureManager.Features.PTU_ALGO.isSoReadyInDirectory(H) && FeatureManager.Features.PTU_TOOLS.isSoReadyInDirectory(H);
            }
            if (AEResInfo.LIGHT_RES_FILAMENT.agentType.equals(aEResBeanWrapper.agentType)) {
                try {
                    File file2 = new File(file + File.separator + AECameraConstants.FILAMENT_NAME);
                    boolean V = AEResManager.J().V("3.145.5.4474", aEResBeanWrapper.version);
                    ms.a.f("AEResUtil", "version fix exit jarVersion 3.145.5.4474soVersion " + aEResBeanWrapper.version + " result " + V);
                    return file2.exists() && V;
                } catch (Throwable th5) {
                    ms.a.c("AEResUtil", th5.getMessage());
                }
            }
            if (AEResInfo.LIGHT_RES_PAG.agentType.equals(aEResBeanWrapper.agentType)) {
                try {
                    String str = file + File.separator + AECameraConstants.LIB_PAG;
                    boolean V2 = AEResManager.J().V(AECameraConstants.PAG_VERSION, aEResBeanWrapper.version);
                    ms.a.f("AEResUtil", "version fix exit jarVersion 4.2.81-noffavcsoVersion " + aEResBeanWrapper.version + " result " + V2);
                    return new File(str).exists() && V2;
                } catch (Throwable th6) {
                    ms.a.c("AEResUtil", th6.getMessage());
                }
            }
            if (AEResInfo.AGENT_TYPE_LIGHT_SDK_BASE.equals(aEResBeanWrapper.agentType)) {
                boolean isSoReadyInDirectory = FeatureManager.Features.LIGHT_SDK.isSoReadyInDirectory(H);
                boolean fileExists = FileUtils.fileExists(L);
                if (!fileExists) {
                    ms.a.c("AEResUtil", "[isAEResExist] LIGHT_SDK isSoReady = " + isSoReadyInDirectory + ", isTagExist = false");
                }
                return isSoReadyInDirectory && fileExists;
            }
            boolean z17 = new File(t(aEResBeanWrapper)).exists() && FileUtils.fileExists(L);
            boolean fileExists2 = FileUtils.fileExists(L);
            if (!fileExists2) {
                ms.a.c("AEResUtil", "[isAEResExist] exists=" + z17 + ", tagExist = false, aeResInfo= " + aEResBeanWrapper);
            }
            return z17 && fileExists2;
        }
        ms.a.c("AEResUtil", "[isAEResExist] soRootPath=null, aeResInfo=" + aEResBeanWrapper);
        return false;
    }

    public static String I(AEResInfo aEResInfo) {
        if (aEResInfo != null && !TextUtils.isEmpty(aEResInfo.agentType)) {
            return J(aEResInfo.agentType);
        }
        return "";
    }

    public static String t(AEResBeanWrapper aEResBeanWrapper) {
        if (aEResBeanWrapper == null) {
            return "";
        }
        return H(aEResBeanWrapper) + aEResBeanWrapper.bundleName + AECameraConstants.BUNDLE;
    }

    public static String u(AEResInfo aEResInfo) {
        if (aEResInfo != null && !TextUtils.isEmpty(aEResInfo.agentType)) {
            return v(aEResInfo.agentType);
        }
        return "";
    }

    public static void u0(AEResBeanWrapper aEResBeanWrapper, String str) {
        boolean z16;
        if (aEResBeanWrapper == null || TextUtils.isEmpty(aEResBeanWrapper.agentType)) {
            return;
        }
        ms.a.a("AEResUtil", "\u4e0b\u8f7d\u5b8c\u6210 \u53d1\u9001\u5e7f\u64ad" + aEResBeanWrapper.agentType);
        Intent intent = new Intent();
        intent.setAction(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BROADCAST_ACTION);
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.putExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BUNDLE_ZIP_PATH, str);
        intent.putExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_AGENT_TYPE, aEResBeanWrapper.agentType);
        intent.putExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BUNDLE_REGISTER_PATH, t(aEResBeanWrapper));
        ConcurrentHashMap<String, Integer> A = AEResManager.J().A();
        if (!A.isEmpty()) {
            if (A.containsKey(aEResBeanWrapper.agentType) && A.get(aEResBeanWrapper.agentType).intValue() == 0) {
                A.put(aEResBeanWrapper.agentType, 4);
            }
            Iterator<String> it = A.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = true;
                    break;
                } else if (A.get(it.next()).intValue() != 4) {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                intent.putExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_ALL_BASE, true);
                ms.a.c("AEResUtil", "bundle all done");
            } else {
                intent.putExtra(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_ALL_BASE, false);
                ms.a.c("AEResUtil", "bundle not all done");
            }
        }
        BaseApplication.getContext().sendBroadcast(intent);
    }

    public static boolean U(AEResInfo aEResInfo) {
        if (aEResInfo == null || TextUtils.isEmpty(aEResInfo.agentType)) {
            return false;
        }
        AEResBeanWrapper l3 = l(aEResInfo.agentType);
        if (l3 == null) {
            ms.a.c("AEResUtil", "wrapper  is null ");
            return false;
        }
        return S(l3);
    }

    public static String H(AEResBeanWrapper aEResBeanWrapper) {
        if (aEResBeanWrapper == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(g.a.c.f65267b);
        sb5.append(aEResBeanWrapper.agentType);
        String str = File.separator;
        sb5.append(str);
        sb5.append(aEResBeanWrapper.md5);
        sb5.append(str);
        return sb5.toString();
    }

    public static String K(AEResBeanWrapper aEResBeanWrapper) {
        if (aEResBeanWrapper == null) {
            return null;
        }
        return g.a.c.f65267b + aEResBeanWrapper.agentType + File.separator;
    }

    public static String L(AEResBeanWrapper aEResBeanWrapper) {
        if (aEResBeanWrapper == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(g.a.c.f65267b);
        sb5.append(aEResBeanWrapper.agentType);
        String str = File.separator;
        sb5.append(str);
        sb5.append(aEResBeanWrapper.md5);
        sb5.append(str);
        sb5.append(".ResCopyFinished");
        return sb5.toString();
    }

    public static String M(AEResBeanWrapper aEResBeanWrapper) {
        if (aEResBeanWrapper == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(g.a.c.f65267b);
        sb5.append(aEResBeanWrapper.agentType);
        String str = File.separator;
        sb5.append(str);
        sb5.append(aEResBeanWrapper.md5);
        sb5.append("_temp");
        sb5.append(str);
        return sb5.toString();
    }

    public static String P(AEResBeanWrapper aEResBeanWrapper) {
        if (aEResBeanWrapper == null) {
            return null;
        }
        return g.a.b.f65253b + aEResBeanWrapper.agentType + "_" + aEResBeanWrapper.md5 + ".zip";
    }

    public static int m(AEResInfo aEResInfo) {
        if (aEResInfo == null) {
            return 2;
        }
        return n(aEResInfo.agentType, QQWinkConstants.ENTRY_QQ_OTHER);
    }

    public static String r(AEResBeanWrapper aEResBeanWrapper) {
        if (aEResBeanWrapper == null) {
            return null;
        }
        return g.a.b.f65253b + aEResBeanWrapper.agentType + "_" + aEResBeanWrapper.md5 + ".7z";
    }
}
