package com.tencent.aelight.camera.ae.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.aelight.camera.ae.download.AEResDownload;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEMultiDownloadCallBack;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tenpay.util.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
import org.light.Config;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEResManager implements AEResDownload.b {

    /* renamed from: o, reason: collision with root package name */
    public static final AEResBeanWrapper f63585o;

    /* renamed from: p, reason: collision with root package name */
    public static final AEResBeanWrapper f63586p;

    /* renamed from: q, reason: collision with root package name */
    private static ConcurrentHashMap<String, Integer> f63587q;

    /* renamed from: r, reason: collision with root package name */
    private static JSONArray f63588r;

    /* renamed from: s, reason: collision with root package name */
    public static final List<String> f63589s;

    /* renamed from: t, reason: collision with root package name */
    public static final List<String> f63590t;

    /* renamed from: u, reason: collision with root package name */
    public static final List<String> f63591u;

    /* renamed from: v, reason: collision with root package name */
    public static final List<String> f63592v;

    /* renamed from: i, reason: collision with root package name */
    private JSONArray f63601i;

    /* renamed from: a, reason: collision with root package name */
    private boolean f63593a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f63594b = false;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Integer> f63595c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.aelight.camera.download.api.a> f63596d = new CopyOnWriteArrayList();

    /* renamed from: e, reason: collision with root package name */
    private LinkedList<AEResBeanWrapper> f63597e = new LinkedList<>();

    /* renamed from: f, reason: collision with root package name */
    private LinkedList<AEResBeanWrapper> f63598f = new LinkedList<>();

    /* renamed from: g, reason: collision with root package name */
    private LinkedList<String> f63599g = new LinkedList<>();

    /* renamed from: j, reason: collision with root package name */
    private Map<String, Long> f63602j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private AEResManagerConfigBean f63603k = null;

    /* renamed from: l, reason: collision with root package name */
    private final ConcurrentHashMap<String, AEResBeanWrapper> f63604l = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f63605m = new AtomicBoolean(false);

    /* renamed from: n, reason: collision with root package name */
    private BroadcastReceiver f63606n = new a();

    /* renamed from: h, reason: collision with root package name */
    private bc f63600h = ThreadManagerV2.newHandlerRecycleThread("Wink_ResDownload", 0).a(new Handler.Callback() { // from class: com.tencent.aelight.camera.ae.download.c
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean X;
            X = AEResManager.X(message);
            return X;
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d extends RunnableTask {
        d(BaseQQAppInterface baseQQAppInterface, String str, Runnable runnable, long j3) {
            super(baseQQAppInterface, str, runnable, j3);
        }

        @Override // com.tencent.mobileqq.transfile.predownload.RunnableTask, com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        protected void realCancel() {
            ms.a.f("AEResManager", "[startPreDownLoad], preDownloadTask.realCancel()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        static final AEResManager f63636a = new AEResManager();
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("assets");
        String str = File.separator;
        sb5.append(str);
        sb5.append(IQQGameCommApi.K_ABTEST_MODELS);
        sb5.append(str);
        sb5.append("QQAutoVideoFilterResource");
        f63586p = new AEResBeanWrapper(null, AEResInfo.AGENT_TYPE_VIDEO_FILTER, sb5.toString(), "b60e541f6a4f8258f2d3185671143b3a", "https://downv6.qq.com/shadow_qqcamera/Android/res/light-sdk_auto_video_filter_bundle_3.1.0.5.zip");
        f63587q = new ConcurrentHashMap<>();
        ArrayList arrayList = new ArrayList();
        f63589s = arrayList;
        ArrayList arrayList2 = new ArrayList();
        f63590t = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        f63591u = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        f63592v = arrayList4;
        String str2 = AEResInfo.AGENT_TYPE_FILAMENT;
        arrayList2.add(str2);
        String str3 = AEResInfo.AGENT_TYPE_PAG;
        arrayList2.add(str3);
        String str4 = AEResInfo.AGENT_TYPE_LIGHT_SDK_BASE;
        arrayList2.add(str4);
        arrayList.add("FACE_AGENT");
        arrayList.add(str2);
        arrayList.add(str4);
        arrayList.add(str3);
        arrayList3.add(AEResInfo.AGENT_TYPE_AE_BASE_RES);
        arrayList4.add(AEResInfo.AGENT_TYPE_AE_BASE_RES);
        arrayList4.add(str2);
        arrayList4.add(str4);
        arrayList4.add(str3);
        f63585o = new AEResBeanWrapper(null, AEResInfo.AGENT_TYPE_AE_BASE_RES, "", "84811c53b0b883f4618658614131ef86", "https://downv6.qq.com/shadow_qqcamera/Android/ae_base_Res_1.4.6_64Nohdr_20240905.zip");
    }

    AEResManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        ms.a.f("AEResManager", "reportPerformanceMD5FromDengTa");
        os.a aVar = os.a.f423933a;
        aVar.d(WinkDaTongReportConstant.ElementParamKey.XSJ_SDK_MD5, "");
        aVar.d(WinkDaTongReportConstant.ElementParamKey.XSJ_PAG_MD5, "");
        aVar.d(WinkDaTongReportConstant.ElementParamKey.XSJ_QUERY_MD5, "");
        String B = AEResUtil.B(AEResUtil.z() + AECameraConstants.LIB_LIGHT);
        aVar.h(WinkDaTongReportConstant.ElementParamKey.XSJ_SDK_MD5, B);
        String B2 = AEResUtil.B(AEResUtil.I(AEResInfo.LIGHT_RES_PAG) + AECameraConstants.LIB_PAG);
        aVar.h(WinkDaTongReportConstant.ElementParamKey.XSJ_PAG_MD5, B2);
        String B3 = AEResUtil.B(AEResUtil.z() + "liblight_device_query.so");
        aVar.h(WinkDaTongReportConstant.ElementParamKey.XSJ_QUERY_MD5, B3);
        ms.a.c("AEResManager", "verify sdkMD5 : " + B + "pagMD5:  " + B2 + "queryMD5: " + B3);
    }

    private List<AEResBeanWrapper> B() {
        return E(f63591u);
    }

    private void B0() {
        ms.a.f("AEResManager", "sync sendBroadCastToSyncMap");
        Intent intent = new Intent();
        intent.setAction("ACTION_RECEIVE_MSH_SET_SYNC");
        if (BaseApplication.getContext() != null) {
            intent.setPackage(BaseApplication.getContext().getPackageName());
            BaseApplication.getContext().sendBroadcast(intent);
        }
    }

    private List<AEResBeanWrapper> C() {
        return E(f63589s);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x012b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0032 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void C0() {
        String str;
        String str2;
        String str3;
        String str4;
        String U;
        this.f63604l.clear();
        this.f63604l.put(AEResInfo.AGENT_TYPE_AE_BASE_RES, f63585o);
        this.f63604l.put(AEResInfo.AGENT_TYPE_VIDEO_FILTER, f63586p);
        AEResManagerConfigBean aEResManagerConfigBean = this.f63603k;
        if (aEResManagerConfigBean == null) {
            ms.a.c("AEResManager", "configbean is null");
            return;
        }
        List<AEResManagerConfigBean.AEResBean> bundleList = aEResManagerConfigBean.getBundleList();
        if (bundleList == null) {
            return;
        }
        for (AEResManagerConfigBean.AEResBean aEResBean : bundleList) {
            AEResManagerConfigBean.AEResBean.PhoneLevelConfig R = R(aEResBean);
            if (R != null) {
                String md5 = R.getMd5();
                str2 = R.getUrl();
                str = md5;
            } else {
                str = "";
                str2 = str;
            }
            String agentType = aEResBean.getAgentType();
            if (AENewResUtilKt.c(agentType)) {
                ms.a.a("AEResManager", "need gzip sdk" + agentType);
                AEResManagerConfigBean.AEResBean.PhoneLevelConfig Q = Q(aEResBean);
                if (Q != null) {
                    String md52 = Q.getMd5();
                    str4 = Q.getUrl();
                    str3 = md52;
                    U = U(agentType);
                    ms.a.a("AEResManager", "gzip backHandMd5 : " + str + "  : backHandUrl " + str2 + "md5: " + str3 + "url: " + str4);
                    if (!AEResManagerConfigBean.DEFAULT_VERSION.equals(U)) {
                        ms.a.f("AEResManager", "version fix agentType" + agentType + " version " + U);
                    }
                    AEResBeanWrapper aEResBeanWrapper = new AEResBeanWrapper(aEResBean, agentType, aEResBean.getBundleName(), str3, str4, str, str2, U);
                    ms.a.a("AEResManager", "version fix  mBeanWrapperMap : " + agentType + " wrapper " + aEResBeanWrapper.md5 + " " + aEResBeanWrapper.url + aEResBeanWrapper.version);
                    this.f63604l.put(agentType, aEResBeanWrapper);
                    if (!agentType.equals(LightConstants.AgentType.PIC_ENHANCE_AGENT)) {
                        this.f63604l.put(LightConstants.AgentType.REALTIME_PIC_ENHANCE_AGENT, aEResBeanWrapper);
                    }
                }
            }
            str3 = str;
            str4 = str2;
            U = U(agentType);
            ms.a.a("AEResManager", "gzip backHandMd5 : " + str + "  : backHandUrl " + str2 + "md5: " + str3 + "url: " + str4);
            if (!AEResManagerConfigBean.DEFAULT_VERSION.equals(U)) {
            }
            AEResBeanWrapper aEResBeanWrapper2 = new AEResBeanWrapper(aEResBean, agentType, aEResBean.getBundleName(), str3, str4, str, str2, U);
            ms.a.a("AEResManager", "version fix  mBeanWrapperMap : " + agentType + " wrapper " + aEResBeanWrapper2.md5 + " " + aEResBeanWrapper2.url + aEResBeanWrapper2.version);
            this.f63604l.put(agentType, aEResBeanWrapper2);
            if (!agentType.equals(LightConstants.AgentType.PIC_ENHANCE_AGENT)) {
            }
        }
        AEResUtil.f63641b.set(false);
    }

    private List<AEResBeanWrapper> D() {
        ArrayList arrayList = new ArrayList();
        if (!this.f63604l.isEmpty()) {
            for (AEResInfo aEResInfo : AEResInfo.values) {
                if (!f63589s.contains(aEResInfo.agentType)) {
                    AEResBeanWrapper aEResBeanWrapper = this.f63604l.get(aEResInfo.agentType);
                    if (aEResBeanWrapper != null) {
                        arrayList.add(aEResBeanWrapper);
                    } else {
                        ms.a.c("AEResManager", "NO CONFIG found for " + aEResInfo.agentType);
                    }
                }
            }
        }
        return arrayList;
    }

    private void D0(QQAppInterface qQAppInterface, boolean z16) {
        AEResBeanWrapper pollFirst;
        ms.a.f("AEResManager_download", "[startDownLoad] + BEGIN");
        if (CollectionUtils.isEmpty(this.f63597e) && CollectionUtils.isEmpty(this.f63598f)) {
            ms.a.c("AEResManager_download", "[startDownLoad]  - END -, mDownLoadTaskQueue is empty");
            return;
        }
        if (!this.f63599g.isEmpty()) {
            ms.a.a("AEResManager", "download : already downing " + this.f63599g.size());
            return;
        }
        if (!this.f63598f.isEmpty()) {
            pollFirst = this.f63598f.pollFirst();
            if (pollFirst != null) {
                ms.a.a("AEResManager", "download : need download from mDownLoadHighProrityTaskQueue:" + pollFirst.agentType + "->" + pollFirst.bundleName + "->" + pollFirst.url);
                this.f63599g.add(pollFirst.md5);
            }
        } else {
            pollFirst = this.f63597e.pollFirst();
            if (pollFirst != null) {
                ms.a.a("AEResManager", "download : need download from mDownLoadTaskQueue:" + pollFirst.agentType + "->" + pollFirst.bundleName + "->" + pollFirst.url);
                this.f63599g.add(pollFirst.md5);
            }
        }
        if (pollFirst == null) {
            ms.a.c("AEResManager_download", "[startDownLoad], mDownLoadTaskQueue top element is null");
            ms.a.f("AEResManager_download", "[startDownLoad] + END");
            return;
        }
        if (this.f63595c.containsKey(pollFirst.md5)) {
            int intValue = this.f63595c.get(pollFirst.md5).intValue();
            if (z16 && !wq.a.f()) {
                ms.a.f("AEResManager", "[startDownLoad], isDownLoadImmediately=false");
                if (intValue == 3 || intValue == 2) {
                    return;
                }
                if (!E0(this, qQAppInterface, pollFirst)) {
                    t(qQAppInterface, pollFirst);
                    this.f63602j.put(pollFirst.agentType, Long.valueOf(System.currentTimeMillis()));
                    ms.a.f("AEResManager", "[startDownLoad], realDownloadResource()");
                    this.f63595c.put(pollFirst.md5, 3);
                    AEResDownload.k(pollFirst, this);
                } else {
                    this.f63595c.put(pollFirst.md5, 2);
                }
            } else {
                ms.a.f("AEResManager", "[startDownLoad], isDownLoadImmediately=true, status:" + intValue);
                if (intValue != 3) {
                    this.f63595c.put(pollFirst.md5, 3);
                    if (intValue == 2) {
                        t(qQAppInterface, pollFirst);
                    }
                    this.f63602j.put(pollFirst.agentType, Long.valueOf(System.currentTimeMillis()));
                    AEResDownload.k(pollFirst, this);
                }
            }
            ms.a.f("AEResManager", "[startDownLoad] + END");
            return;
        }
        ms.a.c("AEResManager_download", "[startDownLoad], cannot find " + pollFirst.md5 + " resNeedDownload in mStatusMap");
    }

    private List<AEResBeanWrapper> E(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (!this.f63604l.isEmpty() && list != null && !list.isEmpty()) {
            for (String str : list) {
                if (this.f63604l.get(str) != null) {
                    arrayList.add(this.f63604l.get(str));
                } else {
                    ms.a.c("AEResManager", "not contain id" + str);
                }
            }
        }
        return arrayList;
    }

    private QQAppInterface F() {
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    private List<AEResBeanWrapper> H() {
        return E(f63592v);
    }

    private AEResManagerConfigBean.AEResBean.PhoneLevelConfig I(String str, AEResManagerConfigBean.AEResBean aEResBean) {
        if (aEResBean == null) {
            ms.a.f("AEResManager", "getLevelConfig is null ");
            return null;
        }
        String str2 = str + AECameraConstants.GZIP_SUFFIX;
        ms.a.a("AEResManager", "gzipLevelStr :" + str2 + " " + aEResBean.getAgentType());
        try {
            JSONArray jSONArray = this.f63601i;
            if (jSONArray != null && jSONArray.length() != 0) {
                ms.a.f("AEResManager", "mFinalJsonArray " + this.f63601i.length());
                for (int i3 = 0; i3 < this.f63601i.length(); i3++) {
                    JSONObject jSONObject = this.f63601i.getJSONObject(i3);
                    String str3 = (String) jSONObject.get("bundle_name");
                    if (str3 != null && str3.equals(aEResBean.getBundleName())) {
                        JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                        if (optJSONObject == null) {
                            ms.a.c("AEResManager", "gzipLevelStr is null ");
                            return L(str, aEResBean);
                        }
                        AEResManagerConfigBean.AEResBean.PhoneLevelConfig phoneLevelConfig = new AEResManagerConfigBean.AEResBean.PhoneLevelConfig();
                        phoneLevelConfig.setMd5(optJSONObject.getString("md5"));
                        phoneLevelConfig.setUrl(optJSONObject.getString("url"));
                        ms.a.f("AEResManager", "gzipLevelStr agent type" + aEResBean.getAgentType() + " special " + aEResBean.isBundleSpecial() + " level " + str + " md5 :" + phoneLevelConfig.getMd5() + " url " + phoneLevelConfig.getUrl());
                        return phoneLevelConfig;
                    }
                }
                return L(str, aEResBean);
            }
            return aEResBean.getMiddle();
        } catch (Throwable th5) {
            ms.a.c("AEResManager", "other level" + th5.getMessage());
            return L(str, aEResBean);
        }
    }

    public static AEResManager J() {
        return e.f63636a;
    }

    private String K(Context context, String str) {
        StringBuilder sb5 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str), "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb5.append(readLine);
            }
            bufferedReader.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return sb5.toString();
    }

    private AEResManagerConfigBean.AEResBean.PhoneLevelConfig L(String str, AEResManagerConfigBean.AEResBean aEResBean) {
        if (aEResBean == null) {
            ms.a.f("AEResManager", "getLevelConfig is null ");
            return null;
        }
        ms.a.a("AEResManager", "levstr :" + str + " " + aEResBean.getAgentType());
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1979547688:
                if (str.equals("veryhigh")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c16 = 1;
                    break;
                }
                break;
            case 107348:
                if (str.equals(HippyImageInfo.QUALITY_LOW)) {
                    c16 = 2;
                    break;
                }
                break;
            case 3202466:
                if (str.equals("high")) {
                    c16 = 3;
                    break;
                }
                break;
            case 351789662:
                if (str.equals("verylow")) {
                    c16 = 4;
                    break;
                }
                break;
            case 839582905:
                if (str.equals("veryhigh_hexagon")) {
                    c16 = 5;
                    break;
                }
                break;
            case 1955330179:
                if (str.equals("high_hexagon")) {
                    c16 = 6;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return aEResBean.getVeryHigh();
            case 1:
                return aEResBean.getMiddle();
            case 2:
                return aEResBean.getLow();
            case 3:
                return aEResBean.getHigh();
            case 4:
                return aEResBean.getVeryLow();
            case 5:
                return aEResBean.getVeryHighHexagon();
            case 6:
                return aEResBean.getHighHexagon();
            default:
                ms.a.f("AEResManager", "get other device level ");
                try {
                    JSONArray jSONArray = this.f63601i;
                    if (jSONArray != null && jSONArray.length() != 0) {
                        ms.a.f("AEResManager", "mFinalJsonArray " + this.f63601i.length());
                        for (int i3 = 0; i3 < this.f63601i.length(); i3++) {
                            JSONObject jSONObject = this.f63601i.getJSONObject(i3);
                            String str2 = (String) jSONObject.get("bundle_name");
                            if (str2 != null && str2.equals(aEResBean.getBundleName())) {
                                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                                if (optJSONObject == null) {
                                    ms.a.c("AEResManager", "level is null ");
                                    return aEResBean.getMiddle();
                                }
                                AEResManagerConfigBean.AEResBean.PhoneLevelConfig phoneLevelConfig = new AEResManagerConfigBean.AEResBean.PhoneLevelConfig();
                                phoneLevelConfig.setMd5(optJSONObject.getString("md5"));
                                phoneLevelConfig.setUrl(optJSONObject.getString("url"));
                                ms.a.c("AEResManager", "agent type" + aEResBean.getAgentType() + " special " + aEResBean.isBundleSpecial() + " level " + str + " md5 :" + phoneLevelConfig.getMd5() + " url " + phoneLevelConfig.getUrl());
                                return phoneLevelConfig;
                            }
                        }
                        return aEResBean.getMiddle();
                    }
                    return aEResBean.getMiddle();
                } catch (Throwable th5) {
                    ms.a.c("AEResManager", "other level" + th5.getMessage());
                    return aEResBean.getMiddle();
                }
        }
    }

    private AEResBeanWrapper M() {
        return this.f63604l.get(AEResInfo.LIGHT_SDK_BASIC64);
    }

    private IPreDownloadController P(QQAppInterface qQAppInterface) {
        try {
            return (IPreDownloadController) qQAppInterface.getRuntimeService(IPreDownloadController.class);
        } catch (Exception unused) {
            ms.a.c("AEResManager", "IPreDownloadController need uin null or should add @Service{needUin=false}");
            return null;
        }
    }

    private List<AEResBeanWrapper> T() {
        return E(f63590t);
    }

    private String U(String str) {
        String pagVersion;
        if (!AEResInfo.PAG_BASIC64.equals(str) && !AEResInfo.PAG_BASIC32.equals(str)) {
            pagVersion = AEResManagerConfigBean.DEFAULT_VERSION;
        } else {
            pagVersion = this.f63603k.getPagVersion();
        }
        if (AEResInfo.FILAMENT_BASIC64.equals(str) || AEResInfo.FILAMENT_BASIC32.equals(str)) {
            pagVersion = this.f63603k.getFilamentVersion();
        }
        return (AEResInfo.LIGHT_SDK_BASIC64.equals(str) || AEResInfo.LIGHT_SDK_BASIC32.equals(str)) ? this.f63603k.getVersion() : pagVersion;
    }

    private boolean W() {
        String H = AEResUtil.H(M());
        if (H == null) {
            ms.a.c("AEResManager", "isSDKExist path is null");
            return false;
        }
        if (!new File(H).exists()) {
            ms.a.c("AEResManager", "isSDKExist so path not exist");
            return false;
        }
        ms.a.f("AEResManager", "isSDKExist path: " + H);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean X(Message message) {
        if (message.what != 100) {
            return false;
        }
        AEResUtil.d();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        u();
        Iterator<AEResBeanWrapper> it = D().iterator();
        while (it.hasNext()) {
            t0(it.next(), null, false, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(IAEMultiDownloadCallBack iAEMultiDownloadCallBack) {
        u();
        HashSet hashSet = new HashSet();
        List<AEResBeanWrapper> H = H();
        for (AEResBeanWrapper aEResBeanWrapper : H) {
            if (aEResBeanWrapper.agentType.equals(AEResInfo.AGENT_TYPE_AE_BASE_RES)) {
                aEResBeanWrapper.highPriority = true;
            }
            hashSet.add(aEResBeanWrapper.agentType);
        }
        c cVar = new c(iAEMultiDownloadCallBack, hashSet, new boolean[]{false});
        for (AEResBeanWrapper aEResBeanWrapper2 : H) {
            if (AEResUtil.W(aEResBeanWrapper2.agentType, "qq_default")) {
                ms.a.a("AEResManager", "isAEResExist  " + aEResBeanWrapper2.agentType);
                hashSet.remove(aEResBeanWrapper2.agentType);
            } else {
                t0(aEResBeanWrapper2, cVar, false, true, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0() {
        u();
        List<AEResBeanWrapper> C = C();
        for (AEResBeanWrapper aEResBeanWrapper : C) {
            if (!f63587q.containsKey(aEResBeanWrapper.agentType)) {
                f63587q.put(aEResBeanWrapper.agentType, 0);
            }
        }
        for (AEResBeanWrapper aEResBeanWrapper2 : C) {
            if (AEResUtil.W(aEResBeanWrapper2.agentType, "qq_default")) {
                ms.a.a("AEResManager", "isAEResExist  " + aEResBeanWrapper2.agentType);
                if (f63587q.containsKey(aEResBeanWrapper2.agentType)) {
                    f63587q.put(aEResBeanWrapper2.agentType, 4);
                }
            } else {
                t0(aEResBeanWrapper2, null, false, true, true);
            }
        }
        if (wq.a.d()) {
            for (AEResBeanWrapper aEResBeanWrapper3 : B()) {
                if (AEResUtil.W(aEResBeanWrapper3.agentType, "qq_default")) {
                    ms.a.a("AEResManager", "isAEResExist  " + aEResBeanWrapper3.agentType);
                } else {
                    t0(aEResBeanWrapper3, null, false, true, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(com.tencent.aelight.camera.download.api.a aVar) {
        u();
        for (AEResBeanWrapper aEResBeanWrapper : T()) {
            if (AEResUtil.W(aEResBeanWrapper.agentType, "qq_default")) {
                ms.a.a("AEResManager", "isAEResExist  " + aEResBeanWrapper.agentType);
            } else {
                t0(aEResBeanWrapper, aVar, false, true, true);
            }
        }
    }

    private boolean c0(String str) {
        try {
            if (!W()) {
                ms.a.f("AEResManager", "load SDK not Exist");
                return false;
            }
            AEResBeanWrapper M = M();
            ms.a.f("AEResManager", "load start" + Thread.currentThread().getName());
            ms.a.f("AEResManager", "load path: " + str);
            System.load(AEResUtil.H(M) + str);
            ms.a.f("AEResManager", "load end");
            return true;
        } catch (Throwable th5) {
            ms.a.d("AEResManager", "load error", th5);
            return false;
        }
    }

    private JSONArray d0(String str, String str2, String str3) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str3);
            JSONObject jSONObject3 = new JSONObject(str2);
            JSONArray jSONArray2 = jSONObject.getJSONArray(AECameraConstants.BUNDLE_LIST);
            JSONArray jSONArray3 = jSONObject2.getJSONArray(AECameraConstants.BUNDLE_LIST);
            JSONArray jSONArray4 = jSONObject3.getJSONArray(AECameraConstants.BUNDLE_LIST);
            jSONArray = Utils.joinJSONArray(Utils.joinJSONArray(jSONArray2, jSONArray3), jSONArray4);
            ms.a.a("AEResManager", "sdkArray " + jSONArray2.length() + " " + jSONArray3.length() + " " + jSONArray4.length() + ProgressTracer.SEPARATOR + jSONArray.length());
        } catch (Throwable th5) {
            ms.a.c("AEResManager", "loadAssetConfigJsonArray has exception " + th5.getMessage());
        }
        this.f63601i = jSONArray;
        if (jSONArray != null) {
            ms.a.f("AEResManager", "result " + this.f63601i.length());
        }
        return jSONArray;
    }

    private AEResManagerConfigBean e0() {
        String K = K(BaseApplication.context, "artifact_info_android.json");
        String K2 = K(BaseApplication.context, "light3d_artifact_info_and.json");
        String K3 = K(BaseApplication.context, "pag_artifact_info_android.json");
        AEResManagerConfigBean j06 = j0(K, false);
        AEResManagerConfigBean j07 = j0(K2, false);
        ms.a.f("AEResManager", "version fix filamentBean " + j07.getVersion());
        AEResManagerConfigBean j08 = j0(K3, false);
        d0(K, K3, K2);
        return f0(j06, j07, j08);
    }

    private AEResManagerConfigBean f0(AEResManagerConfigBean aEResManagerConfigBean, AEResManagerConfigBean aEResManagerConfigBean2, AEResManagerConfigBean aEResManagerConfigBean3) {
        if (aEResManagerConfigBean != null && aEResManagerConfigBean2 != null && aEResManagerConfigBean3 != null) {
            List<AEResManagerConfigBean.AEResBean> bundleList = aEResManagerConfigBean.getBundleList();
            List<AEResManagerConfigBean.AEResBean> bundleList2 = aEResManagerConfigBean2.getBundleList();
            List<AEResManagerConfigBean.AEResBean> bundleList3 = aEResManagerConfigBean3.getBundleList();
            if (bundleList != null && bundleList2 != null && bundleList3 != null) {
                ms.a.f("AEResManager", "sdk list size : " + bundleList.size() + "filament size: " + bundleList2.size() + "pag size: " + bundleList3.size());
                bundleList.addAll(bundleList2);
                bundleList.addAll(bundleList3);
                aEResManagerConfigBean.setBundleList(bundleList);
                aEResManagerConfigBean.setFilamentVersion(aEResManagerConfigBean2.getVersion());
                aEResManagerConfigBean.setPagVersion(aEResManagerConfigBean3.getVersion());
                ms.a.f("AEResManager", "version fix final sdk list size : " + aEResManagerConfigBean.getBundleList().size() + " version " + aEResManagerConfigBean.getVersion() + " pag version" + aEResManagerConfigBean.getPagVersion() + " filament version" + aEResManagerConfigBean.getFilamentVersion());
                return aEResManagerConfigBean;
            }
            ms.a.c("AEResManager", "sdk bundle list == null " + aEResManagerConfigBean + " " + aEResManagerConfigBean2 + "" + aEResManagerConfigBean3);
            return new AEResManagerConfigBean();
        }
        ms.a.c("AEResManager", "bean is null can not merge" + aEResManagerConfigBean + " " + aEResManagerConfigBean2 + "" + aEResManagerConfigBean3);
        return new AEResManagerConfigBean();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(String str, int i3, String str2, String str3) {
        String str4 = str;
        ms.a.f("AEResManager", "[onDownloadFinishInternal] - BEGIN -, result=" + i3 + ", name=" + str4 + ", filePath=" + str2);
        if (str4 == null) {
            str4 = "";
        }
        int i16 = (i3 == 0 || i3 == 1) ? 0 : i3;
        AEResBeanWrapper aEResBeanWrapper = this.f63604l.get(str4);
        if (aEResBeanWrapper == null) {
            return;
        }
        ms.a.a("AEResManager", "aeResInfo.md5" + aEResBeanWrapper.md5 + "request " + str3);
        String str5 = aEResBeanWrapper.md5;
        if (str5 != null && !str5.equals(str3)) {
            Iterator<String> it = this.f63599g.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && next.equals(str3)) {
                    ms.a.a("AEResManager", "delete wrapper.md5" + next);
                    it.remove();
                }
            }
            QQAppInterface F = F();
            if (F != null) {
                D0(F, false);
                return;
            } else {
                ms.a.c("AEResManager", "onDownloadFinishInternal|getAppInterFace() is null.");
                return;
            }
        }
        ms.a.f("AEResManager", "[onDownloadFinishInternal], realResult:" + i16 + ", matched aeResInfo=" + aEResBeanWrapper);
        if (i16 == 0) {
            this.f63595c.put(aEResBeanWrapper.md5, 4);
            this.f63599g.remove(str3);
            ms.a.a("AEResManager", "mDownLoadingQueue.remove" + aEResBeanWrapper);
            AEResUtil.u0(aEResBeanWrapper, str2);
            if (AEResInfo.AGENT_TYPE_LIGHT_SDK_BASE.equals(aEResBeanWrapper.agentType) && com.tencent.aelight.camera.ae.report.b.b().c()) {
                Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
                buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementParamValue.XSJ_CAMERA_BUNDULE_INFO);
                buildElementParams.put("xsj_actiontype", WinkDaTongReportConstant.ElementParamValue.XSJ_CAMERA_BUNDLE_DOWNLOAD);
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BUNDLE_COST_TIME, Long.valueOf(mq.a.d().g(IPrefRecorder.MILESTONE_BASE_BUNDLE_DOWNLOADED)));
                com.tencent.aelight.camera.ae.report.b.b().v("performance#camera_app#bundle_download", com.tencent.aelight.camera.ae.report.d.a(buildElementParams));
            }
            AEResUtil.v0(aEResBeanWrapper.agentType, aEResBeanWrapper.md5);
        } else {
            this.f63595c.put(aEResBeanWrapper.md5, 0);
            this.f63599g.remove(str3);
            if ((AEResInfo.LIGHT_SDK_BASIC64.equals(aEResBeanWrapper.agentType) || AEResInfo.LIGHT_SDK_BASIC32.equals(aEResBeanWrapper.agentType)) && !aEResBeanWrapper.md5.equals(aEResBeanWrapper.backupMd5)) {
                ms.a.c("AEResManager", "sdk zip change : " + aEResBeanWrapper.backupMd5 + " url " + aEResBeanWrapper.url);
                aEResBeanWrapper.md5 = aEResBeanWrapper.backupMd5;
                aEResBeanWrapper.url = aEResBeanWrapper.backupUrl;
            }
        }
        Iterator<com.tencent.aelight.camera.download.api.a> it5 = this.f63596d.iterator();
        while (it5.hasNext()) {
            try {
                it5.next().onAEDownloadFinish(z(aEResBeanWrapper.agentType), str2, i16 == 0, i16);
            } catch (Exception e16) {
                ms.a.a("AEResManager", "getAEResInfo has exception " + e16.getMessage());
            }
        }
        if (i3 != 1) {
            com.tencent.aelight.camera.ae.report.b.b().f(i3 == 0, 0, aEResBeanWrapper.agentType, "", i3, this.f63602j.get(aEResBeanWrapper.agentType) != null ? System.currentTimeMillis() - this.f63602j.get(aEResBeanWrapper.agentType).longValue() : -1L);
        }
        QQAppInterface F2 = F();
        if (F2 != null) {
            D0(F2, false);
        } else {
            ms.a.c("AEResManager", "onDownloadFinishInternal|getAppInterFace() is null.");
        }
        ms.a.f("AEResManager", "[onDownloadFinishInternal] - END -");
    }

    public static AEResManagerConfigBean j0(String str, boolean z16) {
        if (z16 && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("version");
                String string2 = jSONObject.getString(AECameraConstants.BUNDLE_PAGVERSION);
                String string3 = jSONObject.getString(AECameraConstants.BUNDLE_FILAMENTVERSION);
                JSONArray jSONArray = jSONObject.getJSONArray(AECameraConstants.BUNDLE_LIST);
                f63588r = jSONArray;
                if (jSONArray != null) {
                    ms.a.c("AEResManager", "version fix version : " + string + " pagVersion" + string2 + " filament version " + string3 + " hot fix length:" + f63588r.length());
                }
            } catch (Throwable th5) {
                ms.a.c("AEResManager", "e " + th5.getMessage());
            }
        }
        if (TextUtils.isEmpty(str)) {
            return new AEResManagerConfigBean();
        }
        try {
            return (AEResManagerConfigBean) new Gson().fromJson(str, AEResManagerConfigBean.class);
        } catch (Exception e16) {
            ms.a.d("AEResManager", "can not parse config json: ", e16);
            return new AEResManagerConfigBean();
        }
    }

    private void t(QQAppInterface qQAppInterface, AEResBeanWrapper aEResBeanWrapper) {
        ms.a.f("AEResManager", "[cancelPreDownLoad] - BEGIN -, aeResInfo=" + aEResBeanWrapper);
        IPreDownloadController P = P(qQAppInterface);
        if (P != null && P.isEnable()) {
            P.cancelPreDownload(aEResBeanWrapper.url);
            ms.a.f("AEResManager", "[cancelPreDownLoad], preDownloadController.isEnable() == " + P.isEnable());
        }
        ms.a.f("AEResManager", "[cancelPreDownLoad] - END -, aeResInfo=" + aEResBeanWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(AEResBeanWrapper aEResBeanWrapper, com.tencent.aelight.camera.download.api.a aVar, boolean z16, boolean z17, boolean z18) {
        if (!F0(aEResBeanWrapper)) {
            y0(aEResBeanWrapper, aVar, z16, z17, z18);
        } else {
            h.f63660a.b().add(new AEResManagerDownLoadPackage(aEResBeanWrapper, aVar, z16, z17, z18));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u() {
        os.a aVar = os.a.f423933a;
        String d16 = aVar.d("aesubVersion", AEResManagerConfigBean.DEFAULT_VERSION);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doSetup subVersion ");
        String str = AppSetting.f99551k;
        sb5.append(str);
        sb5.append(" default version ");
        sb5.append(d16);
        ms.a.f("AEResManager", sb5.toString());
        if (!str.equals(d16)) {
            this.f63605m.set(false);
        }
        if (this.f63605m.get()) {
            ms.a.f("AEResManager", "hasSetup already");
            return;
        }
        ms.a.a("AEResManager", "doSetup");
        AENewResUtilKt.a();
        this.f63605m.set(true);
        aVar.h("aesubVersion", str);
    }

    private void u0() {
        this.f63600h.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.d
            @Override // java.lang.Runnable
            public final void run() {
                AEResManager.this.a0();
            }
        });
    }

    private void v0(final com.tencent.aelight.camera.download.api.a aVar) {
        this.f63600h.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.e
            @Override // java.lang.Runnable
            public final void run() {
                AEResManager.this.b0(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.f63600h.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResManager.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator<AEResManagerDownLoadPackage> it = h.f63660a.b().iterator();
                while (it.hasNext()) {
                    AEResManagerDownLoadPackage next = it.next();
                    if (next != null && next.getMAEResBeanWrapper() != null && next.getMAEResBeanWrapper().originBean != null) {
                        ms.a.f("AEResManager", "continueDownLoadAfterLoad start " + next.getMAEResBeanWrapper().originBean.getBundleName());
                    }
                    if (next != null) {
                        AEResManager.this.y0(next.getMAEResBeanWrapper(), next.getMAeDownloadCallBack(), next.getNeedWiFi(), next.getIsAppStartUpRequest(), next.getIsHighPriority());
                    }
                }
                h.f63660a.a();
            }
        });
    }

    private void x() {
        boolean c16 = AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_LIGHT_SD_CARD_BUNDLE_CACHE, true, 0);
        ms.a.f("AEResManager", "deleteSdCardCache : " + c16);
        if (c16) {
            AECameraPrefsUtil.f().l(AECameraConstants.SP_KEY_LIGHT_SD_CARD_BUNDLE_CACHE, false, 0);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResManager.12
                @Override // java.lang.Runnable
                public void run() {
                    FileUtils.deleteFilesInDirectory(g.a.b.f65253b);
                    FileUtils.deleteFilesInDirectory(fq.b.f400301a);
                }
            }, 64, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(AEResBeanWrapper aEResBeanWrapper, com.tencent.aelight.camera.download.api.a aVar, boolean z16, boolean z17, boolean z18) {
        if (aEResBeanWrapper == null) {
            ms.a.c("AEResManager", "aeResInfo is null");
            return;
        }
        if (!this.f63595c.containsKey(aEResBeanWrapper.md5)) {
            this.f63595c.put(aEResBeanWrapper.md5, 0);
        }
        int intValue = this.f63595c.get(aEResBeanWrapper.md5).intValue();
        if (intValue == 4 && AEResUtil.S(aEResBeanWrapper)) {
            String P = AEResUtil.P(aEResBeanWrapper);
            if (aVar != null) {
                try {
                    aVar.onAEDownloadFinish(z(aEResBeanWrapper.agentType), P, true, 0);
                } catch (Exception e16) {
                    ms.a.a("AEResManager", "getAEResInfo has exception " + e16.getMessage());
                }
            }
            AEResUtil.u0(aEResBeanWrapper, P);
            return;
        }
        if (intValue == 4 && !AEResUtil.S(aEResBeanWrapper)) {
            ms.a.f("AEResManager", "[requestDownloadInternal], \u91cd\u7f6e\u5185\u5b58\u4e2d\u7684\u6587\u4ef6\u72b6\u6001\u4e3aIDLE");
            this.f63595c.put(aEResBeanWrapper.md5, 0);
            intValue = 0;
        }
        if (intValue == 3) {
            s(aVar);
            ms.a.f("AEResManager", "[requestDownloadInternal], packageIndex=" + aEResBeanWrapper.agentType + ", downloadStatus=DOWNLOAD_STATUS_DOWNLOADING");
            return;
        }
        if (!(NetworkUtil.isNetworkAvailable(null) && (!z16 || NetworkUtil.isWifiConnected(null)))) {
            if (aVar != null) {
                try {
                    aVar.onAEDownloadFinish(z(aEResBeanWrapper.agentType), null, false, -6);
                } catch (Exception e17) {
                    ms.a.a("AEResManager", "getAEResInfo has exception " + e17.getMessage());
                }
            }
            ms.a.c("AEResManager", "[requestDownloadInternal], packageIndex=" + aEResBeanWrapper.agentType + ", networkStatus=UNUSABLE");
            return;
        }
        ms.a.f("AEResManager", "[requestDownloadInternal], packageIndex=" + aEResBeanWrapper.agentType + ", networkStatus=USABLE");
        s(aVar);
        if (f63589s.contains(aEResBeanWrapper.agentType)) {
            if (!this.f63598f.contains(aEResBeanWrapper)) {
                this.f63598f.addLast(aEResBeanWrapper);
                this.f63595c.put(aEResBeanWrapper.md5, 1);
                ms.a.a("AEResManager", "download: add Priority queue " + aEResBeanWrapper.agentType);
            } else {
                ms.a.a("AEResManager", "download: already in  Priority queue" + aEResBeanWrapper.agentType);
            }
        } else if (!this.f63597e.contains(aEResBeanWrapper)) {
            ms.a.a("AEResManager", "download : add normal queue " + aEResBeanWrapper.agentType + z18);
            if (z18) {
                this.f63597e.addFirst(aEResBeanWrapper);
            } else {
                this.f63597e.addLast(aEResBeanWrapper);
            }
            this.f63595c.put(aEResBeanWrapper.md5, 1);
        } else if (z18) {
            ms.a.a("AEResManager", "download : queue already contain need high ");
            this.f63597e.remove(aEResBeanWrapper);
            this.f63597e.addFirst(aEResBeanWrapper);
        }
        QQAppInterface F = F();
        if (F != null) {
            ms.a.a("AEResManager", "[requestDownloadInternal] in main process ");
            D0(F, z17);
        } else {
            ms.a.a("AEResManager", "[requestDownloadInternal] not in main process\uff0c will download in main process by IPC ");
            AEResUtil.o0(aEResBeanWrapper.agentType, z18);
        }
    }

    private AEResInfo z(String str) {
        for (AEResInfo aEResInfo : AEResInfo.values) {
            if (aEResInfo.agentType.equals(str)) {
                return aEResInfo;
            }
        }
        ms.a.c("AEResManager", " can not find agentType " + str);
        return null;
    }

    private synchronized void z0(boolean z16) {
        ms.a.c("AEResManager", "resetBundleLevel directly :" + this.f63593a);
        H0(z16);
        if (this.f63593a) {
            ms.a.c("AEResManager", "continueDownLoadAfterLoad");
            w();
        }
        List<com.tencent.aelight.camera.download.api.a> list = this.f63596d;
        if (list != null) {
            list.add(new b(z16));
        }
    }

    public ConcurrentHashMap<String, Integer> A() {
        return f63587q;
    }

    public HashMap<String, AEResBeanWrapper> G() {
        u();
        return new HashMap<>(this.f63604l);
    }

    public void G0() {
        if (BaseApplicationImpl.getApplication() != null) {
            try {
                ms.a.f("AEResManager", "sync unregisterReceiver");
                BaseApplicationImpl.getApplication().unregisterReceiver(this.f63606n);
            } catch (Throwable unused) {
                ms.a.c("AEResManager", "can not unregister");
            }
        }
    }

    public void H0(boolean z16) {
        boolean z17;
        String str;
        String str2;
        if (uq3.c.Q4()) {
            ms.a.c("AEResManager", "updateBeanWrapperMapWithCVSO InterceptDownload");
            if (!W()) {
                ms.a.c("AEResManager", "updateBeanWrapperMapWithCVSO SDK not Exist");
                return;
            }
        }
        if ((!this.f63593a || z16) && c0("liblight_device_query.so")) {
            z17 = true;
        } else {
            this.f63594b = true;
            z17 = false;
        }
        if (!z17) {
            ms.a.f("AEResManager", "updateBeanWrapperMapWithCVSO !loaded");
            return;
        }
        ms.a.f("AEResManager", "updateBeanWrapperMapWithCVSO start");
        for (Map.Entry<String, AEResBeanWrapper> entry : this.f63604l.entrySet()) {
            if (entry.getValue() != null && entry.getValue().originBean != null && entry.getValue().originBean.isBundleSpecial()) {
                String resourceBundleLevelNameByAgentNameWithCV = Config.getResourceBundleLevelNameByAgentNameWithCV(entry.getValue().originBean.getAgentType());
                ms.a.f("AEResManager", "phone level for witchCV: " + entry.getValue().originBean.getAgentType() + MsgSummary.STR_COLON + resourceBundleLevelNameByAgentNameWithCV);
                AEResManagerConfigBean.AEResBean.PhoneLevelConfig L = L(resourceBundleLevelNameByAgentNameWithCV, entry.getValue().originBean);
                if (L != null) {
                    str = L.getMd5();
                    str2 = L.getUrl();
                } else {
                    str = "";
                    str2 = "";
                }
                entry.getValue().md5 = str;
                entry.getValue().url = str2;
                AEResUtil.f63641b.set(false);
                B0();
            }
        }
        this.f63593a = true;
        this.f63594b = true;
    }

    public List<AEResInfo> N() {
        ArrayList arrayList = new ArrayList();
        if (AEResInfo.values != null && f63590t != null) {
            int i3 = 0;
            while (true) {
                AEResInfo[] aEResInfoArr = AEResInfo.values;
                if (i3 >= aEResInfoArr.length) {
                    break;
                }
                AEResInfo aEResInfo = aEResInfoArr[i3];
                if (aEResInfo != null && f63590t.contains(aEResInfo.agentType)) {
                    arrayList.add(aEResInfo);
                }
                i3++;
            }
        }
        return arrayList;
    }

    public String O() {
        return j0(K(BaseApplication.context, "pag_artifact_info_android.json"), false).getVersion();
    }

    public int S(AEResInfo aEResInfo) {
        AEResBeanWrapper aEResBeanWrapper;
        Integer num;
        if (this.f63595c == null || aEResInfo == null || (aEResBeanWrapper = this.f63604l.get(aEResInfo.agentType)) == null || (num = this.f63595c.get(aEResBeanWrapper.md5)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean V(String str, String str2) {
        if (wq.a.h()) {
            return true;
        }
        int v3 = v(str2, str);
        ms.a.f("AEResManager", "version fix isMinVersionLimit jarVersion " + str + "soVersion " + str2 + " result " + v3);
        return v3 >= 0;
    }

    @Override // com.tencent.aelight.camera.ae.download.AEResDownload.b
    public void b(final String str, final int i3, final String str2, final String str3) {
        ms.a.f("AEResManager", "[onDownloadFinish] - BEGIN -, result=" + i3 + ", name=" + str + ", filePath=" + str2);
        this.f63600h.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResManager.8
            @Override // java.lang.Runnable
            public void run() {
                AEResManager.this.h0(str, i3, str2, str3);
            }
        });
        if (AEResInfo.LIGHT_SDK_BASIC32.equals(str) || AEResInfo.LIGHT_SDK_BASIC64.equals(str) || AEResInfo.PAG_BASIC64.equals(str) || AEResInfo.PAG_BASIC32.equals(str)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResManager.9
                @Override // java.lang.Runnable
                public void run() {
                    AEResManager.this.A0();
                }
            }, 64, null, false);
        }
        ms.a.f("AEResManager", "[onDownloadFinish] - END -");
    }

    public synchronized void g0() {
        ms.a.f("AEResManager", "[needCheckSetup] ");
        u();
    }

    public void k0() {
        ms.a.c("AEResManager", "preDownloadAllEssentialResources");
        mq.a.d().j(IPrefRecorder.MILESTONE_BASE_BUNDLE_DOWNLOADED);
        J().u0();
        x();
    }

    public void l0() {
        ms.a.f("AEResManager", "preDownloadAllNonEssentialResources");
        this.f63600h.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.b
            @Override // java.lang.Runnable
            public final void run() {
                AEResManager.this.Y();
            }
        });
    }

    public void m0(IAEMultiDownloadCallBack iAEMultiDownloadCallBack) {
        ms.a.c("AEResManager", "preDownloadEditorEssentialResources");
        J().s0(iAEMultiDownloadCallBack);
        x();
    }

    public void n0() {
        ms.a.c("AEResManager", "preDownloadSDKEssentialResources");
        J().v0(null);
    }

    public void o0() {
        if (BaseApplicationImpl.getApplication() != null) {
            ms.a.f("AEResManager", "sync registerReceiver");
            if (Looper.myLooper() != Looper.getMainLooper()) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResManager.13
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.a.a("AEResManager", "registerReceiverASync");
                        BaseApplicationImpl.getApplication().registerReceiver(AEResManager.this.f63606n, new IntentFilter("ACTION_RECEIVE_MSH_SET_SYNC"));
                    }
                }, 16, null, true);
            } else {
                ms.a.a("AEResManager", "registerReceiverSync");
                BaseApplicationImpl.getApplication().registerReceiver(this.f63606n, new IntentFilter("ACTION_RECEIVE_MSH_SET_SYNC"));
            }
        }
    }

    @Deprecated
    public void r0(AEResInfo aEResInfo, com.tencent.aelight.camera.download.api.a aVar, boolean z16) {
        ms.a.f("AEResManager", "[requestDownload] - BEGIN -, aeResInfo=" + aEResInfo);
        w0(aEResInfo.agentType, aVar, z16);
    }

    public void s0(final IAEMultiDownloadCallBack iAEMultiDownloadCallBack) {
        this.f63600h.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.f
            @Override // java.lang.Runnable
            public final void run() {
                AEResManager.this.Z(iAEMultiDownloadCallBack);
            }
        });
    }

    public void w0(final String str, final com.tencent.aelight.camera.download.api.a aVar, final boolean z16) {
        ms.a.f("AEResManager", "[requestDownloadSingle] - BEGIN -, aeResInfo=" + str);
        this.f63600h.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResManager.2
            @Override // java.lang.Runnable
            public void run() {
                AEResManager.this.u();
                AEResBeanWrapper aEResBeanWrapper = (AEResBeanWrapper) AEResManager.this.f63604l.get(str);
                if (aEResBeanWrapper != null) {
                    AEResManager.this.t0(aEResBeanWrapper, aVar, z16, false, false);
                }
            }
        });
        ms.a.f("AEResManager", "[requestDownloadSingle] - END -, aeResInfo=" + str);
    }

    public void x0(final String str, final com.tencent.aelight.camera.download.api.a aVar, final boolean z16) {
        ms.a.f("AEResManager", "[requestDownloadSingleHighPriority] - BEGIN -, aeResInfo=" + str);
        this.f63600h.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResManager.3
            @Override // java.lang.Runnable
            public void run() {
                AEResManager.this.u();
                AEResBeanWrapper aEResBeanWrapper = (AEResBeanWrapper) AEResManager.this.f63604l.get(str);
                if (aEResBeanWrapper != null) {
                    AEResManager.this.t0(aEResBeanWrapper, aVar, z16, false, true);
                }
            }
        });
        ms.a.f("AEResManager", "[requestDownloadSingle] - END -, aeResInfo=" + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void y(AEResManagerConfigBean aEResManagerConfigBean) {
        boolean z16;
        AEResManagerConfigBean aEResManagerConfigBean2;
        this.f63603k = e0();
        ms.a.f("AEResManager", "[doSetup] - assetConfig=" + this.f63603k + ", managerConfig=" + aEResManagerConfigBean);
        if (this.f63603k != null && (aEResManagerConfigBean == null || v(aEResManagerConfigBean.getVersion(), this.f63603k.getVersion()) <= 0)) {
            z16 = false;
            ms.a.f("AEResManager", "[doSetup] - selected ConfigBean=" + this.f63603k);
            aEResManagerConfigBean2 = this.f63603k;
            if (aEResManagerConfigBean2 != null && !AEResManagerConfigBean.DEFAULT_VERSION.equals(aEResManagerConfigBean2.getVersion())) {
                C0();
                z0(z16);
                ms.a.f("AEResManager", "doSetUpMergeBean end ");
            }
        }
        this.f63603k = aEResManagerConfigBean;
        this.f63601i = f63588r;
        z16 = true;
        ms.a.f("AEResManager", "[doSetup] - selected ConfigBean=" + this.f63603k);
        aEResManagerConfigBean2 = this.f63603k;
        if (aEResManagerConfigBean2 != null) {
            C0();
            z0(z16);
            ms.a.f("AEResManager", "doSetUpMergeBean end ");
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                ms.a.c("AEResManager", "sync onReceive " + intent.getAction());
                if ("ACTION_RECEIVE_MSH_SET_SYNC".equals(intent.getAction())) {
                    AEResUtil.f63641b.set(false);
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.download.AEResDownload.b
    public void a(final String str, final long j3, final long j16, final String str2) {
        this.f63600h.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResManager.11
            @Override // java.lang.Runnable
            public void run() {
                AEResManager.this.i0(str, j3, j16, str2);
            }
        });
    }

    private AEResManagerConfigBean.AEResBean.PhoneLevelConfig Q(AEResManagerConfigBean.AEResBean aEResBean) {
        if (aEResBean == null) {
            ms.a.f("AEResManager", "bean is null ");
            return null;
        }
        return I(Config.getResourceBundleLevelNameByAgentName(aEResBean.getAgentType()), aEResBean);
    }

    private AEResManagerConfigBean.AEResBean.PhoneLevelConfig R(AEResManagerConfigBean.AEResBean aEResBean) {
        if (aEResBean == null) {
            ms.a.f("AEResManager", "bean is null ");
            return null;
        }
        return L(Config.getResourceBundleLevelNameByAgentName(aEResBean.getAgentType()), aEResBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(String str, long j3, long j16, String str2) {
        if (str == null) {
            str = "";
        }
        this.f63595c.put(str2, 3);
        Iterator<com.tencent.aelight.camera.download.api.a> it = this.f63596d.iterator();
        while (it.hasNext()) {
            try {
                it.next().onAEProgressUpdate(z(str), j3, j16);
            } catch (Exception e16) {
                ms.a.a("AEResManager", "getAEResInfo has exception " + e16.getMessage());
            }
        }
    }

    private boolean F0(AEResBeanWrapper aEResBeanWrapper) {
        AEResManagerConfigBean.AEResBean aEResBean;
        if ((aEResBeanWrapper != null && aEResBeanWrapper.highPriority) || this.f63594b) {
            return false;
        }
        if (aEResBeanWrapper != null && (aEResBean = aEResBeanWrapper.originBean) != null && !aEResBean.isBundleSpecial()) {
            return false;
        }
        if (aEResBeanWrapper != null) {
            return (aEResBeanWrapper.agentType.equals(AEResInfo.LIGHT_SDK_BASIC64) || aEResBeanWrapper.agentType.equals(AEResInfo.LIGHT_SDK_BASIC32)) ? false : true;
        }
        return true;
    }

    private void s(com.tencent.aelight.camera.download.api.a aVar) {
        List<com.tencent.aelight.camera.download.api.a> list;
        if (aVar == null || (list = this.f63596d) == null || list.contains(aVar)) {
            return;
        }
        this.f63596d.add(aVar);
    }

    public void p0(com.tencent.aelight.camera.download.api.a aVar) {
        List<com.tencent.aelight.camera.download.api.a> list;
        if (aVar == null || (list = this.f63596d) == null) {
            return;
        }
        list.remove(aVar);
    }

    public void q0(long j3, AEResBeanWrapper aEResBeanWrapper, final long j16) {
        if (aEResBeanWrapper == null) {
            return;
        }
        final String str = aEResBeanWrapper.md5;
        final String str2 = aEResBeanWrapper.agentType;
        final long j17 = j3 / 1024;
        ms.a.a("AEResManager", "agentType" + str2 + " size : " + j17 + " cost : " + String.valueOf(j16));
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResManager.10
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("light_bundle_md5", str);
                hashMap.put("light_bundle_name", str2);
                hashMap.put("light_bundle_cost", String.valueOf(j16));
                hashMap.put("light_bundle_size", String.valueOf(j17));
                com.tencent.aelight.camera.ae.report.b.b().p(hashMap);
            }
        }, 16, null, false);
    }

    private boolean E0(final AEResDownload.b bVar, QQAppInterface qQAppInterface, final AEResBeanWrapper aEResBeanWrapper) {
        IPreDownloadController P = P(qQAppInterface);
        if (P != null && P.isEnable()) {
            boolean requestPreDownload = P.requestPreDownload(10091, null, aEResBeanWrapper.agentType, 0, aEResBeanWrapper.url, AEResUtil.P(aEResBeanWrapper), 4, 0, true, new d(qQAppInterface, "ae_camera_res", new Runnable() { // from class: com.tencent.aelight.camera.ae.download.AEResManager.6
                @Override // java.lang.Runnable
                public void run() {
                    ms.a.f("AEResManager", "[startPreDownLoad], preDownloadTask.run(), aeResInfo=" + aEResBeanWrapper);
                    AEResManager.this.f63595c.put(aEResBeanWrapper.md5, 3);
                    AEResManager.this.f63602j.put(aEResBeanWrapper.agentType, Long.valueOf(System.currentTimeMillis()));
                    AEResDownload.k(aEResBeanWrapper, bVar);
                }
            }, 4000L));
            ms.a.f("AEResManager", "[startPreDownLoad], preDownloadController.requestPreDownload(), succeeded=" + requestPreDownload);
            ms.a.f("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + aEResBeanWrapper);
            return requestPreDownload;
        }
        ms.a.f("AEResManager", "[startPreDownLoad], preDownloadController.isEnable() == false");
        ms.a.f("AEResManager", "[startPreDownLoad] - END -, aeResInfo=" + aEResBeanWrapper);
        return false;
    }

    private static int v(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.isEmpty() && str2.isEmpty()) {
            return 0;
        }
        if (str.isEmpty()) {
            return -1;
        }
        if (str2.isEmpty()) {
            return 1;
        }
        if (str.equals(str2)) {
            return 0;
        }
        if (str.contains("-")) {
            str = str.substring(0, str.indexOf("-"));
        }
        if (str2.contains("-")) {
            str2 = str2.substring(0, str2.indexOf("-"));
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i3 = 0;
        int i16 = 0;
        while (i3 < min) {
            i16 = Integer.parseInt(split[i3]) - Integer.parseInt(split2[i3]);
            if (i16 != 0) {
                break;
            }
            i3++;
        }
        if (i16 != 0) {
            return i16 > 0 ? 1 : -1;
        }
        for (int i17 = i3; i17 < split.length; i17++) {
            if (Integer.parseInt(split[i17]) > 0) {
                return 1;
            }
        }
        while (i3 < split2.length) {
            if (Integer.parseInt(split2[i3]) > 0) {
                return -1;
            }
            i3++;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d, reason: collision with root package name */
        private boolean f63628d = false;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f63629e;

        b(boolean z16) {
            this.f63629e = z16;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(AEResInfo aEResInfo, String str, boolean z16, int i3) {
            if (aEResInfo == null) {
                ms.a.c("AEResManager", "aeResInfo == null  hotfix == " + this.f63629e);
                return;
            }
            if (!aEResInfo.agentType.equals(AEResInfo.LIGHT_SDK_BASIC64) && !aEResInfo.agentType.equals(AEResInfo.LIGHT_SDK_BASIC32)) {
                ms.a.c("AEResManager", "aeResInfo.agentType == " + aEResInfo.agentType);
                return;
            }
            if (i3 != 0) {
                ms.a.c("AEResManager", "doSetup() downLoad error");
            }
            ms.a.c("AEResManager", "resetBundleLevel");
            AEResManager.this.H0(this.f63629e);
            AEResManager.this.w();
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(AEResInfo aEResInfo, long j3, long j16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IAEMultiDownloadCallBack f63631d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashSet f63632e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean[] f63633f;

        c(IAEMultiDownloadCallBack iAEMultiDownloadCallBack, HashSet hashSet, boolean[] zArr) {
            this.f63631d = iAEMultiDownloadCallBack;
            this.f63632e = hashSet;
            this.f63633f = zArr;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(AEResInfo aEResInfo, String str, boolean z16, int i3) {
            synchronized (this.f63631d) {
                ms.a.f("AEResManager", "bundle onAEDownloadFinish : agentType = " + aEResInfo.agentType + "downloaded= " + z16);
                this.f63632e.remove(aEResInfo.agentType);
                if (z16) {
                    if (this.f63632e.isEmpty()) {
                        AEResManager.this.p0(this);
                        this.f63631d.onAEMultiDownloadFinish(aEResInfo, true, i3);
                    }
                } else {
                    boolean[] zArr = this.f63633f;
                    if (!zArr[0]) {
                        zArr[0] = true;
                        AEResManager.this.p0(this);
                        this.f63631d.onAEMultiDownloadFinish(aEResInfo, false, i3);
                    }
                }
            }
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(AEResInfo aEResInfo, long j3, long j16) {
        }
    }
}
