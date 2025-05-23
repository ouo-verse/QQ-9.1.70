package com.tencent.mobileqq.zplan.avatar.edit;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.profilecommon.processor.AvatarHistoryNumProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rainbow.api.IRainbowApi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.zplan.avatar.ZPlanEditAvatarEntranceScene;
import com.tencent.mobileqq.zplan.avatar.b;
import com.tencent.mobileqq.zplan.avatar.manager.ZPlanEditAvatarAllConfigInfo;
import com.tencent.mobileqq.zplan.avatar.manager.ZPlanEditAvatarDataManager;
import com.tencent.mobileqq.zplan.avatar.report.ZPlanAvatarEditDaTongReport;
import com.tencent.mobileqq.zplan.avatar.upload.a;
import com.tencent.mobileqq.zplan.model.ZPlanStickerInfo;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.model.MemeResult;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class ZPlanEditAvatarManager implements Manager {
    private String L;
    private int M;
    private com.tencent.mobileqq.zplan.avatar.edit.g N;
    private com.tencent.mobileqq.zplan.avatar.edit.d P;
    private List<com.tencent.mobileqq.zplan.avatar.edit.d> Q;
    private List<com.tencent.mobileqq.zplan.avatar.edit.d> R;
    private List<com.tencent.mobileqq.zplan.avatar.edit.d> S;
    private List<BackgroundInfo> T;
    private ConcurrentHashMap<Integer, Integer> W;

    /* renamed from: d, reason: collision with root package name */
    private final AppInterface f331570d;

    /* renamed from: e, reason: collision with root package name */
    private i f331571e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f331572f = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f331573h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f331574i = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f331575m = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private volatile boolean I = false;
    private final j[] J = new j[2];
    private final Map<com.tencent.zplan.meme.a, j> K = Collections.synchronizedMap(new HashMap());
    private int U = 5;
    private int V = 60;
    boolean X = ZPlanQQMC.INSTANCE.enableZPlanEditAvatarV2();
    ZPlanAvatarEditDaTongReport Y = new ZPlanAvatarEditDaTongReport();
    private final com.tencent.mobileqq.zplan.servlet.b Z = new d();

    /* renamed from: a0, reason: collision with root package name */
    private final com.tencent.mobileqq.rainbow.a f331568a0 = new e();

    /* renamed from: b0, reason: collision with root package name */
    private int f331569b0 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class a implements com.tencent.mobileqq.zplan.avatar.edit.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f331588a;

        a(j jVar) {
            this.f331588a = jVar;
        }

        @Override // com.tencent.mobileqq.zplan.avatar.edit.e
        public void a(boolean z16, com.tencent.mobileqq.zplan.avatar.edit.d dVar, String str) {
            QLog.d("[ZPlanEditAvatarManager]", 1, "composeAvatar success:" + z16 + " filePath:" + str);
            if (!z16 || TextUtils.isEmpty(str)) {
                ZPlanEditAvatarManager.this.x0(this.f331588a, "composeAvatar error");
                return;
            }
            j jVar = this.f331588a;
            jVar.f331608d = str;
            jVar.f331610f.d(str);
            ZPlanEditAvatarManager.this.F0(this.f331588a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class b implements com.tencent.mobileqq.zplan.servlet.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f331590a;

        b(j jVar) {
            this.f331590a = jVar;
        }

        @Override // com.tencent.mobileqq.zplan.servlet.d
        public void a(boolean z16, Object obj) {
            if (z16 && obj != null) {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                QLog.d("[ZPlanEditAvatarManager]", 1, "getZPlanEditAvatarSetting flag:" + booleanValue);
                ZPlanEditAvatarUtils.f331613a.i0(ZPlanEditAvatarManager.this.f331570d, booleanValue);
                if (booleanValue) {
                    ZPlanEditAvatarManager.this.E0(this.f331590a);
                    return;
                } else {
                    QLog.d("[ZPlanEditAvatarManager]", 1, "getZPlanEditAvatarSetting flag false stop upload");
                    return;
                }
            }
            QLog.e("[ZPlanEditAvatarManager]", 1, "getZPlanEditAvatarSetting fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class f implements com.tencent.mobileqq.zootopia.api.e {
        f() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int i3, String str) {
            QLog.i("[ZPlanEditAvatarManager]", 1, "getActionStickerInfo code=" + i3 + ", message=" + str);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultSuccess(Object obj) {
            try {
                ZPlanStickerInfo[] zPlanStickerInfoArr = (ZPlanStickerInfo[]) obj;
                QLog.i("[ZPlanEditAvatarManager]", 1, "getActionStickerInfo success, size=" + zPlanStickerInfoArr.length);
                JSONObject jSONObject = new JSONObject();
                for (ZPlanStickerInfo zPlanStickerInfo : zPlanStickerInfoArr) {
                    jSONObject.put(String.valueOf(zPlanStickerInfo.getStickerId()), zPlanStickerInfo.getData());
                }
                ZPlanEditAvatarUtils.f331613a.e0(ZPlanEditAvatarManager.this.f331570d.getCurrentUin(), jSONObject.toString());
            } catch (JSONException e16) {
                QLog.e("[ZPlanEditAvatarManager]", 1, "getActionStickerInfo failed", e16);
            } catch (Exception e17) {
                QLog.e("[ZPlanEditAvatarManager]", 1, "getActionStickerInfo failed", e17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class g implements com.tencent.mobileqq.zplan.avatar.manager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Priority f331599a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f331600b;

        g(Priority priority, int i3) {
            this.f331599a = priority;
            this.f331600b = i3;
        }

        @Override // com.tencent.mobileqq.zplan.avatar.manager.a
        public void a(boolean z16, ZPlanEditAvatarAllConfigInfo zPlanEditAvatarAllConfigInfo) {
            QLog.i("[ZPlanEditAvatarManager]", 1, "[preRecordActionWithCacheV2] getAvatarInfoForPreRecord done, isSuccess: " + z16);
            if (z16 && zPlanEditAvatarAllConfigInfo != null) {
                ZPlanEditAvatarUtils zPlanEditAvatarUtils = ZPlanEditAvatarUtils.f331613a;
                List<Integer> P = zPlanEditAvatarUtils.P(ZPlanEditAvatarManager.this.P, zPlanEditAvatarAllConfigInfo.c(), zPlanEditAvatarAllConfigInfo.getGlobalConfig().preRecNum);
                if (P.isEmpty()) {
                    QLog.e("[ZPlanEditAvatarManager]", 1, "[preRecordActionWithCacheV2]failed, preRecordActionIdList null.");
                    return;
                }
                List<com.tencent.mobileqq.zplan.avatar.edit.d> l3 = com.tencent.mobileqq.zplan.avatar.edit.d.l(P, ZPlanEditAvatarManager.this.f331570d.getCurrentUin(), ZPlanEditAvatarManager.this.L);
                if (l3.isEmpty()) {
                    QLog.e("[ZPlanEditAvatarManager]", 1, "[preRecordActionWithCacheV2]failed, avatarDataList null.");
                    return;
                }
                QLog.i("[ZPlanEditAvatarManager]", 1, "[preRecordActionWithCacheV2] start preRecord, preRecordActionIdList: " + P);
                zPlanEditAvatarUtils.a0(l3, this.f331599a, this.f331600b, null, null);
                return;
            }
            QLog.e("[ZPlanEditAvatarManager]", 1, "[preRecordActionWithCacheV2]failed, allConfigInfo null or not success.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class h implements com.tencent.mobileqq.zplan.avatar.edit.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Priority f331602a;

        h(Priority priority) {
            this.f331602a = priority;
        }

        @Override // com.tencent.mobileqq.zplan.avatar.edit.f
        public void a(boolean z16, com.tencent.mobileqq.zplan.avatar.edit.d dVar) {
            QLog.i("[ZPlanEditAvatarManager]", 1, "getEditAvatarInfo:" + z16 + ",EditAvatarData:" + dVar);
            if (z16) {
                ZPlanEditAvatarManager.this.P = dVar;
                ZPlanEditAvatarManager.this.F = true;
                ZPlanEditAvatarManager.this.A0(this.f331602a);
                return;
            }
            QLog.e("[ZPlanEditAvatarManager]", 1, "getEditAvatarInfo error, stop update with appearance task");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public class i extends TransProcessorHandler {
        public i(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (ZPlanEditAvatarManager.this.I) {
                Object obj = message.obj;
                if (!(obj instanceof FileMsg)) {
                    QLog.e("[ZPlanEditAvatarManager]", 1, "msg.obj type error");
                    return;
                }
                FileMsg fileMsg = (FileMsg) obj;
                int i3 = message.what;
                if (i3 == 1003) {
                    ZPlanEditAvatarManager.this.f0(fileMsg);
                } else {
                    if (i3 != 1005) {
                        return;
                    }
                    ZPlanEditAvatarManager.this.e0(fileMsg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public long f331605a;

        /* renamed from: b, reason: collision with root package name */
        public int f331606b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f331607c;

        /* renamed from: d, reason: collision with root package name */
        public String f331608d;

        /* renamed from: e, reason: collision with root package name */
        public com.tencent.mobileqq.zplan.avatar.edit.d f331609e;

        /* renamed from: f, reason: collision with root package name */
        public ZPlanAvatarUploadParam f331610f;

        /* renamed from: g, reason: collision with root package name */
        public String f331611g = ZPlanEditAvatarEntranceScene.UNKNOWN.getSourceString();

        /* renamed from: h, reason: collision with root package name */
        public Long f331612h;

        j() {
        }

        public String toString() {
            return "[EditAvatarTask avatarSource:" + this.f331611g + ",timestamp:" + this.f331605a + ",editAvatarData:" + this.f331609e + ", isSyncQzone:" + this.f331607c + ", retryTime:" + this.f331606b + "]";
        }
    }

    public ZPlanEditAvatarManager(QQAppInterface qQAppInterface) {
        this.f331570d = qQAppInterface;
        h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(Priority priority) {
        com.tencent.mobileqq.zplan.avatar.edit.d dVar = this.P;
        if (dVar == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "[followAppearanceChg] startBuildUpdateWithAppearanceTask local selfEditAvatarData == null stop update with appearance");
            return;
        }
        com.tencent.mobileqq.zplan.avatar.edit.d a16 = com.tencent.mobileqq.zplan.avatar.edit.d.a(dVar);
        if (a16 != null) {
            String appearanceKey = a16.getAppearanceKey();
            if (!TextUtils.isEmpty(this.L) && !this.L.equals(appearanceKey)) {
                QLog.i("[ZPlanEditAvatarManager]", 1, "[followAppearanceChg] need change avatar new appearance:" + this.L + ", remote appearance: " + appearanceKey);
                t0();
                a16.r(this.L);
                if (this.X) {
                    QLog.i("[ZPlanEditAvatarManager]", 1, "enableEditAvatarV2 true.");
                    I(a16, priority);
                    return;
                }
                j H = H(a16);
                if (H == null) {
                    QLog.e("[ZPlanEditAvatarManager]", 1, "[followAppearanceChg] build task failed, task null.");
                    return;
                } else {
                    if (G(H)) {
                        D0(priority);
                        return;
                    }
                    return;
                }
            }
            QLog.d("[ZPlanEditAvatarManager]", 1, "[followAppearanceChg] do not need change avatar same appearance:" + this.L);
            return;
        }
        QLog.d("[ZPlanEditAvatarManager]", 1, "[followAppearanceChg]do not need change avatar, avatarInfo is null");
    }

    private void D0(Priority priority) {
        j T = T();
        if (T == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "startTask failed, task null.");
        } else if (ZPlanEditAvatarEntranceScene.FOLLOW_APPEARANCE.getSourceString().equals(T.f331611g)) {
            C0(T, priority);
        } else {
            F0(T);
        }
    }

    private boolean G(j jVar) {
        synchronized (this.J) {
            j[] jVarArr = this.J;
            j jVar2 = jVarArr[0];
            if (jVar2 == null) {
                jVarArr[0] = jVar;
                jVarArr[1] = null;
                return true;
            }
            if (jVar.f331605a - jVar2.f331605a > 30000) {
                jVarArr[0] = jVar;
                jVarArr[1] = null;
                return true;
            }
            jVarArr[1] = jVar;
            return false;
        }
    }

    private void G0(String str) {
        AvatarHistoryNumProcessor avatarHistoryNumProcessor;
        if (ea.h0(this.f331570d.getApp(), str) == 2 || (avatarHistoryNumProcessor = (AvatarHistoryNumProcessor) com.tencent.mobileqq.profilecommon.utils.a.a(AvatarHistoryNumProcessor.class, this.f331570d)) == null) {
            return;
        }
        avatarHistoryNumProcessor.a();
    }

    private j H(com.tencent.mobileqq.zplan.avatar.edit.d dVar) {
        com.tencent.mobileqq.zplan.avatar.edit.d b06 = b0(dVar);
        if (b06 == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "buildUpdateWithAppearanceTask failed, updatedAvatarData invalid.");
            return null;
        }
        QLog.i("[ZPlanEditAvatarManager]", 1, "[followAppearanceChg] buildUpdateWithAppearanceTask editAvatarData: " + b06);
        j jVar = new j();
        jVar.f331605a = System.currentTimeMillis();
        jVar.f331606b = 2;
        jVar.f331609e = b06;
        jVar.f331611g = ZPlanEditAvatarEntranceScene.FOLLOW_APPEARANCE.getSourceString();
        jVar.f331612h = Long.valueOf(System.currentTimeMillis());
        return jVar;
    }

    private void I(com.tencent.mobileqq.zplan.avatar.edit.d dVar, Priority priority) {
        AppInterface appInterface = this.f331570d;
        if (appInterface == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "buildUpdateWithAppearanceTaskV2 failed, mApp null.");
            return;
        }
        long longAccountUin = appInterface.getLongAccountUin();
        if (dVar != null && dVar.getActionId() != -1) {
            ZPlanEditAvatarDataManager.f331961a.f(longAccountUin, this.M, new c(dVar.getActionId(), dVar, priority));
        } else {
            QLog.e("[ZPlanEditAvatarManager]", 1, "getUpdatedAvatarDataWithAppearanceChg failed, input oldData invalid.");
        }
    }

    private void I0(String str) {
        if (((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(str, INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, (Object) (-1))).intValue() != 1) {
            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(str, INearbySPUtil.SP_KEY_QQ_AVATAR_TYPE, (Object) 1);
        }
    }

    private j J(com.tencent.mobileqq.zplan.avatar.edit.d dVar, String str, boolean z16, ZPlanAvatarUploadParam zPlanAvatarUploadParam, String str2) {
        j jVar = new j();
        jVar.f331605a = System.currentTimeMillis();
        jVar.f331606b = 1;
        jVar.f331609e = dVar;
        jVar.f331608d = str;
        jVar.f331607c = z16;
        jVar.f331610f = zPlanAvatarUploadParam;
        jVar.f331611g = str2;
        return jVar;
    }

    private void K(Priority priority) {
        com.tencent.mobileqq.zplan.avatar.edit.d dVar = this.P;
        if (dVar == null) {
            QLog.i("[ZPlanEditAvatarManager]", 1, "checkSelfDataValid, selfEditAvatarData null.");
            this.F = false;
            H0(priority);
        } else {
            if (TextUtils.isEmpty(dVar.getAppearanceKey())) {
                QLog.i("[ZPlanEditAvatarManager]", 1, "checkSelfDataValid, selfEditAvatarData invalid.");
                this.P = null;
                this.F = false;
                H0(priority);
                return;
            }
            QLog.i("[ZPlanEditAvatarManager]", 1, "[getEditAvatarInfo] selfEditAvatarData from local: " + this.P + "updatedAppearanceKey: " + this.L);
            this.F = true;
            A0(priority);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L(j jVar, String str, int i3) {
        if (!ZPlanEditAvatarEntranceScene.FOLLOW_APPEARANCE.getSourceString().equals(jVar.f331611g)) {
            return false;
        }
        com.tencent.mobileqq.zplan.avatar.edit.d dVar = jVar.f331609e;
        return dVar.getActionId() == i3 && TextUtils.equals(dVar.getAppearanceKey(), str);
    }

    private void O(final Priority priority) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarManager.7
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("[ZPlanEditAvatarManager]", 1, "doUpdateWithAppearance appearanceKey:" + ZPlanEditAvatarManager.this.L);
                ZPlanEditAvatarManager.this.U(priority);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(List<com.tencent.mobileqq.zplan.avatar.edit.d> list) {
        if (!ZPlanFeatureSwitch.f369852a.a3()) {
            QLog.i("[ZPlanEditAvatarManager]", 1, "getActionStickerInfo no need");
            return;
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        int[] iArr = new int[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            iArr[i3] = list.get(i3).getActionId();
        }
        com.tencent.mobileqq.zplan.servlet.n.INSTANCE.a(this.f331570d, iArr, new f());
    }

    private j T() {
        j jVar;
        synchronized (this.J) {
            jVar = this.J[0];
        }
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(Priority priority) {
        AppInterface appInterface = this.f331570d;
        if (appInterface == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "getEditAvatarInfo failed, app null.");
            return;
        }
        String currentUin = appInterface.getCurrentUin();
        ZPlanEditAvatarUtils zPlanEditAvatarUtils = ZPlanEditAvatarUtils.f331613a;
        String y16 = zPlanEditAvatarUtils.y(currentUin);
        if (TextUtils.isEmpty(y16)) {
            this.P = null;
            this.F = false;
        } else {
            this.P = zPlanEditAvatarUtils.H(currentUin, y16);
        }
        K(priority);
    }

    private int c0(int i3) {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = this.W;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(i3))) {
            Integer num = this.W.get(Integer.valueOf(i3));
            if (num == null) {
                QLog.e("[ZPlanEditAvatarManager]", 1, "getUpdatedAvatarDataWithAppearanceChg failed, newId in map invalid.");
                return -1;
            }
            QLog.i("[ZPlanEditAvatarManager]", 1, "getUpdatedAvatarDataWithAppearanceChg id updated, oldId: " + i3 + ", newId: " + num);
            return num.intValue();
        }
        QLog.i("[ZPlanEditAvatarManager]", 1, "getUpdatedIdIfNeed, no need update, id: " + i3);
        return i3;
    }

    private boolean g0() {
        if (this.f331570d == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "[hasCustomDressUp] invalid app");
            return false;
        }
        return ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(this.f331570d.getCurrentUin()).hasCustomDressUp();
    }

    private void h0() {
        ZPlanUserInfo userZPlanInfo = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(this.f331570d.getCurrentUin());
        this.L = userZPlanInfo.appearanceKey;
        this.M = userZPlanInfo.gender;
        this.f331570d.addObserver(this.Z);
        this.f331570d.addObserver(this.f331568a0);
        i iVar = new i(ThreadManagerV2.getQQCommonThreadLooper());
        this.f331571e = iVar;
        iVar.addFilter(NearbyPeoplePhotoUploadProcessor.class);
        QLog.i("[ZPlanEditAvatarManager]", 1, "try add upload handler.");
        ((ITransFileController) this.f331570d.getRuntimeService(ITransFileController.class, "all")).addHandle(this.f331571e);
        ZPlanEditAvatarUtils zPlanEditAvatarUtils = ZPlanEditAvatarUtils.f331613a;
        this.f331572f = zPlanEditAvatarUtils.Y();
        this.f331573h = zPlanEditAvatarUtils.R();
        this.f331575m = zPlanEditAvatarUtils.Q();
        this.G = zPlanEditAvatarUtils.N();
        this.H = zPlanEditAvatarUtils.M();
        this.D = zPlanEditAvatarUtils.X(this.f331570d);
        QLog.i("[ZPlanEditAvatarManager]", 1, "init avatarToggleSwitch:" + this.f331572f + " preFetchConfigSwitch:" + this.G + " preFetchAvatarInfoSwitch:" + this.H);
        if (this.f331572f) {
            if (!this.X && this.G) {
                QLog.w("[ZPlanEditAvatarManager]", 1, "enableEditAvatarV2: " + this.X);
                P();
            }
            if (this.D && this.H) {
                a0(true);
            }
        }
    }

    private void j0(String str) {
        ((CardHandler) this.f331570d.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).z5(true, str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        synchronized (this.J) {
            j[] jVarArr = this.J;
            j jVar = jVarArr[1];
            if (jVar != null) {
                jVarArr[0] = jVar;
                jVarArr[1] = null;
            } else {
                jVarArr[0] = null;
            }
        }
        D0(Priority.LOW);
    }

    private void l0(j jVar, boolean z16) {
        com.tencent.mobileqq.zplan.avatar.edit.g gVar;
        QLog.i("[ZPlanEditAvatarManager]", 1, "onFinishUploadAvatar, isSuccess: " + z16 + ", task: " + jVar);
        if (ZPlanEditAvatarEntranceScene.FOLLOW_APPEARANCE.getSourceString().equals(jVar.f331611g) || (gVar = this.N) == null) {
            return;
        }
        gVar.a(z16, "");
    }

    private void m0(boolean z16) {
        j T = T();
        if (T == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "onUploadFinish currentTask is null");
            v0(NetworkUtil.isNetSupport(this.f331570d.getApp()) ? 4 : 1);
            k0();
        } else {
            if (z16) {
                ZPlanEditAvatarUtils zPlanEditAvatarUtils = ZPlanEditAvatarUtils.f331613a;
                zPlanEditAvatarUtils.i0(this.f331570d, true);
                String h16 = zPlanEditAvatarUtils.h(T.f331609e);
                zPlanEditAvatarUtils.d0(h16, T.f331609e.getUin());
                zPlanEditAvatarUtils.h0(h16);
                w0(T);
                l0(T, true);
                k0();
                return;
            }
            y0(T);
        }
    }

    private void t0() {
        String currentUin;
        HashMap<String, String> hashMap = new HashMap<>();
        AppInterface appInterface = this.f331570d;
        if (appInterface == null) {
            currentUin = "";
        } else {
            currentUin = appInterface.getCurrentUin();
        }
        String str = currentUin;
        hashMap.put("self_uin", str);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "ev_kl_zplan_avatar_find_diff", true, 0L, 0L, hashMap, "", false);
    }

    private void u0() {
        String currentUin;
        HashMap<String, String> hashMap = new HashMap<>();
        AppInterface appInterface = this.f331570d;
        if (appInterface == null) {
            currentUin = "";
        } else {
            currentUin = appInterface.getCurrentUin();
        }
        String str = currentUin;
        hashMap.put("self_uin", str);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "ev_kl_zplan_avatar_check_begin", true, 0L, 0L, hashMap, "", false);
    }

    private void v0(int i3) {
        String url;
        j T = T();
        if (T == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "reportChangeAvatarFail failed, task null.");
            return;
        }
        com.tencent.mobileqq.zplan.avatar.edit.d dVar = T.f331609e;
        if (dVar == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "reportChangeAvatarFail failed, editAvatarData null.");
            return;
        }
        BackgroundInfo backgroundInfo = dVar.getBackgroundInfo();
        if (backgroundInfo == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "reportChangeAvatarFail failed, bgInfo null.");
            return;
        }
        String valueOf = String.valueOf(dVar.getActionId());
        if (backgroundInfo.getUrl() == null) {
            url = "";
        } else {
            url = backgroundInfo.getUrl();
        }
        this.Y.j(new b.AvatarRenewReportParam(valueOf, url, ZPlanEditAvatarUtils.f331613a.z(dVar.j()), T.f331611g, "", String.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(j jVar, String str) {
        QLog.e("[ZPlanEditAvatarManager]", 1, "retry time:" + jVar.f331606b + ",reason:" + str);
        int i3 = jVar.f331606b;
        if (i3 <= 0) {
            v0(0);
            k0();
        } else {
            jVar.f331606b = i3 - 1;
            C0(jVar, Priority.MIDDLE);
        }
    }

    private void y0(j jVar) {
        QLog.e("[ZPlanEditAvatarManager]", 1, "retry time:" + jVar.f331606b + ",reason uploadAvatar error");
        int i3 = jVar.f331606b;
        if (i3 <= 0) {
            l0(jVar, false);
            k0();
        } else {
            jVar.f331606b = i3 - 1;
            F0(jVar);
        }
    }

    public void J0() {
        this.L = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(this.f331570d.getCurrentUin()).appearanceKey;
        u0();
        this.D = ZPlanEditAvatarUtils.f331613a.X(this.f331570d);
        QLog.d("[ZPlanEditAvatarManager]", 1, "updateWithAppearance toggleSwitch:" + this.f331572f + ",isUseZPlanAvatar:" + this.D);
        if (this.f331572f && this.D) {
            O(Priority.MIDDLE);
        }
    }

    public void K0(Priority priority) {
        QLog.d("[ZPlanEditAvatarManager]", 1, "[updateWithAppearanceWithCache] start priority:" + priority);
        if (!this.f331572f) {
            QLog.w("[ZPlanEditAvatarManager]", 1, "[updateWithAppearanceWithCache] avatarToggleSwitch invalid stop");
            return;
        }
        boolean X = ZPlanEditAvatarUtils.f331613a.X(this.f331570d);
        this.D = X;
        if (!X) {
            QLog.w("[ZPlanEditAvatarManager]", 1, "[updateWithAppearanceWithCache] isUseZPlanAvatar invalid stop");
            return;
        }
        this.L = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(this.f331570d.getCurrentUin()).appearanceKey;
        QLog.w("[ZPlanEditAvatarManager]", 1, "[updateWithAppearanceWithCache] data not Ready start query");
        O(priority);
    }

    public void L0(String str, com.tencent.mobileqq.zplan.avatar.edit.d dVar, Boolean bool, ZPlanAvatarUploadParam zPlanAvatarUploadParam, String str2) {
        String str3;
        QLog.d("[ZPlanEditAvatarManager]", 1, "uploadAvatar isSyncQzone:" + bool);
        if (!this.I && dVar != null) {
            j J = J(dVar, str, bool.booleanValue(), zPlanAvatarUploadParam, str2);
            synchronized (this.J) {
                this.J[0] = J;
            }
            D0(Priority.LOW);
            return;
        }
        com.tencent.mobileqq.zplan.avatar.edit.g gVar = this.N;
        if (gVar != null) {
            if (this.I) {
                str3 = "\u5934\u50cf\u4e0a\u4f20\u4e2d\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85";
            } else {
                str3 = "";
            }
            gVar.a(false, str3);
        }
        if (this.I) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "uploadAvatar is uploading");
        } else if (dVar == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "uploadAvatar editAvatarData is null");
        }
    }

    public ConcurrentHashMap<Integer, Integer> Q() {
        return this.W;
    }

    public List<BackgroundInfo> S() {
        if (this.E) {
            return this.T;
        }
        return new ArrayList();
    }

    public List<com.tencent.mobileqq.zplan.avatar.edit.d> V() {
        if (this.E) {
            return this.S;
        }
        return new ArrayList();
    }

    public List<com.tencent.mobileqq.zplan.avatar.edit.d> X() {
        if (this.E) {
            return this.R;
        }
        return new ArrayList();
    }

    public int Y() {
        return this.U;
    }

    public boolean i0() {
        this.D = ZPlanEditAvatarUtils.f331613a.X(this.f331570d);
        QLog.i("[ZPlanEditAvatarManager]", 1, "[isDataReady] isConfigReady:" + this.E + " isUserAvatarDataReady:" + this.F + " isUseZPlanAvatar:" + this.D);
        return this.E && (this.F || !this.D);
    }

    public void n0(final boolean z16, long j3) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarManager.5
            @Override // java.lang.Runnable
            public void run() {
                Priority priority;
                Priority priority2;
                ZPlanEditAvatarManager zPlanEditAvatarManager = ZPlanEditAvatarManager.this;
                if (zPlanEditAvatarManager.X) {
                    if (z16) {
                        priority2 = Priority.MIDDLE;
                    } else {
                        priority2 = Priority.LOW;
                    }
                    zPlanEditAvatarManager.s0(priority2, 0);
                    return;
                }
                if (z16) {
                    priority = Priority.MIDDLE;
                } else {
                    priority = Priority.LOW;
                }
                zPlanEditAvatarManager.r0(priority, 0);
            }
        }, 16, null, false, j3);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.f331570d.removeObserver(this.Z);
        this.f331570d.removeObserver(this.f331568a0);
        QLog.i("[ZPlanEditAvatarManager]", 1, "try remove upload handler.");
        ((ITransFileController) this.f331570d.getRuntimeService(ITransFileController.class, "all")).removeHandle(this.f331571e);
        this.K.clear();
        FaceUtil.setTempAvatarFilePath(null);
    }

    public void p0() {
        if (this.f331572f && this.f331575m) {
            if (this.C) {
                return;
            }
            this.C = true;
            n0(true, 500L);
            return;
        }
        QLog.d("[ZPlanEditAvatarManager]", 1, "preRecordActionInMall avatarToggleSwitch:" + this.f331572f + ",preRecordActionInMall:" + this.f331575m);
    }

    public void q0() {
        if (this.f331572f && this.f331573h) {
            if (this.f331574i) {
                return;
            }
            this.f331574i = true;
            n0(false, 3000L);
            return;
        }
        QLog.d("[ZPlanEditAvatarManager]", 1, "preRecordActionInSummary avatarToggleSwitch:" + this.f331572f + ",preRecordInSummary:" + this.f331573h);
    }

    public void r0(Priority priority, int i3) {
        List<com.tencent.mobileqq.zplan.avatar.edit.d> list;
        QLog.d("[ZPlanEditAvatarManager]", 1, "[preRecordActionWithCache] priority:" + priority);
        if (this.f331570d != null && i0() && g0()) {
            QLog.d("[ZPlanEditAvatarManager]", 1, "[preRecordActionWithCache] data ready preRecordNumber\uff1b" + this.U);
            if (this.M == 2) {
                list = this.S;
            } else {
                list = this.R;
            }
            this.Q = list;
            ZPlanEditAvatarUtils zPlanEditAvatarUtils = ZPlanEditAvatarUtils.f331613a;
            zPlanEditAvatarUtils.a0(com.tencent.mobileqq.zplan.avatar.edit.d.l(zPlanEditAvatarUtils.O(this.P, list, this.U), this.f331570d.getCurrentUin(), this.L), priority, i3, null, null);
            return;
        }
        QLog.d("[ZPlanEditAvatarManager]", 1, "[preRecordActionWithCache] data ready false or not has custom dress up");
    }

    public void s0(Priority priority, int i3) {
        QLog.d("[ZPlanEditAvatarManager]", 1, "[preRecordActionWithCacheV2] priority:" + priority);
        AppInterface appInterface = this.f331570d;
        if (appInterface != null && g0()) {
            ZPlanEditAvatarDataManager.f331961a.g(appInterface.getLongAccountUin(), this.M, new g(priority, i3));
        } else {
            QLog.e("[ZPlanEditAvatarManager]", 1, "[preRecordActionWithCacheV2]failed, app null or hasCustomDressup false.");
        }
    }

    public void z0(com.tencent.mobileqq.zplan.avatar.edit.g gVar) {
        this.N = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(j jVar, String str) {
        QLog.d("[ZPlanEditAvatarManager]", 1, "startCompose");
        ZPlanEditAvatarUtils.f331613a.j(jVar.f331609e, str, new a(jVar));
    }

    private void C0(final j jVar, Priority priority) {
        QLog.d("[ZPlanEditAvatarManager]", 1, "startRecord");
        final WeakReference weakReference = new WeakReference(this);
        com.tencent.zplan.meme.a aVar = new com.tencent.zplan.meme.a() { // from class: com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarManager.9
            @Override // com.tencent.zplan.meme.a
            public void l9(boolean z16, MemeResult memeResult) {
                ZPlanEditAvatarManager zPlanEditAvatarManager = (ZPlanEditAvatarManager) weakReference.get();
                if (zPlanEditAvatarManager == null) {
                    return;
                }
                final int intValue = memeResult.d() != null ? memeResult.d().intValue() : -1;
                final String recordPath = memeResult.getRecordPath();
                QLog.d("[ZPlanEditAvatarManager]", 1, "recordEditAvatar success:" + z16 + " id:" + intValue + " recordPath:" + recordPath);
                final j jVar2 = (j) zPlanEditAvatarManager.K.remove(this);
                if (jVar2 != null) {
                    if (!zPlanEditAvatarManager.L(jVar2, zPlanEditAvatarManager.L, intValue)) {
                        QLog.e("[ZPlanEditAvatarManager]", 1, "recordEditAvatar is not current task");
                        zPlanEditAvatarManager.k0();
                        return;
                    } else if (!z16 || TextUtils.isEmpty(recordPath) || intValue == -1) {
                        zPlanEditAvatarManager.x0(jVar2, "recordEditAvatar error");
                        return;
                    } else {
                        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarManager.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                j jVar3;
                                com.tencent.mobileqq.zplan.avatar.edit.d dVar;
                                String url;
                                ZPlanEditAvatarManager zPlanEditAvatarManager2 = (ZPlanEditAvatarManager) weakReference.get();
                                if (zPlanEditAvatarManager2 == null || (jVar3 = jVar) == null || (dVar = jVar3.f331609e) == null) {
                                    return;
                                }
                                ZPlanEditAvatarUtils zPlanEditAvatarUtils = ZPlanEditAvatarUtils.f331613a;
                                String B = zPlanEditAvatarUtils.B(intValue, recordPath, dVar, zPlanEditAvatarManager2.L, 1);
                                String B2 = zPlanEditAvatarUtils.B(intValue, recordPath, jVar.f331609e, zPlanEditAvatarManager2.L, 0);
                                BackgroundInfo backgroundInfo = jVar.f331609e.getBackgroundInfo();
                                if (backgroundInfo == null || !backgroundInfo.c()) {
                                    return;
                                }
                                j jVar4 = jVar2;
                                double maskRate = jVar.f331609e.getMaskRate();
                                int intValue2 = backgroundInfo.getId() == null ? 0 : backgroundInfo.getId().intValue();
                                if (backgroundInfo.getUrl() == null) {
                                    url = "";
                                } else {
                                    url = backgroundInfo.getUrl();
                                }
                                jVar4.f331610f = new ZPlanAvatarUploadParam(B, "", maskRate, intValue2, url);
                                zPlanEditAvatarManager2.B0(jVar2, B2);
                            }
                        });
                        return;
                    }
                }
                QLog.e("[ZPlanEditAvatarManager]", 1, "recordEditAvatar avatarTask can not find");
            }

            @Override // com.tencent.zplan.meme.a
            public void d3(MemeAction memeAction, float f16) {
            }
        };
        this.K.put(aVar, jVar);
        ZPlanEditAvatarUtils.f331613a.b0(jVar.f331609e, priority, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(j jVar) {
        this.I = true;
        FaceUtil.startUploadZplanAvatar();
        com.tencent.mobileqq.zplan.avatar.upload.a aVar = com.tencent.mobileqq.zplan.avatar.upload.a.f331975a;
        ProfileCardUtil.a b16 = aVar.b(this.f331570d, jVar.f331608d, true);
        QLog.i("[ZPlanEditAvatarManager]", 1, "startUpload, checkResult errorCode: " + b16.f306430a + ", errorDesc: " + b16.f306431b);
        if (jVar.f331610f != null && b16.f306430a == 0 && FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS.equals(b16.f306431b)) {
            QLog.d("[ZPlanEditAvatarManager]", 1, QZoneJsConstants.METHOD_RECORDER_START_UPLOAD);
            aVar.e(this.f331570d, jVar.f331608d, 22, jVar.f331607c, false, new a.ZplanAvatarInfo((byte) 1, jVar.f331610f.getBackgroundId(), (byte) (jVar.f331610f.getMaskRate() * 100.0d)));
            return;
        }
        if (b16.f306430a == -10001) {
            v0(1);
        }
        jVar.f331606b = 0;
        QLog.e("[ZPlanEditAvatarManager]", 1, "startUpload fail checkBeforeUpload error");
        this.I = false;
        FaceUtil.setUploadZplanFinish(false);
        m0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(j jVar) {
        if (jVar == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "[startUploadWithCheck] task == null return");
            return;
        }
        QLog.d("[ZPlanEditAvatarManager]", 1, "[startUploadWithCheck] task.avatarSource:" + jVar.f331611g);
        if (!ZPlanEditAvatarEntranceScene.FOLLOW_APPEARANCE.getSourceString().equals(jVar.f331611g)) {
            E0(jVar);
            return;
        }
        AppInterface appInterface = this.f331570d;
        if (appInterface == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "[startUploadWithCheck] mApp == null return");
        } else {
            ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).getZPlanEditAvatarSetting(this.f331570d, appInterface.getCurrentUin(), new b(jVar));
        }
    }

    private void H0(Priority priority) {
        QLog.w("[ZPlanEditAvatarManager]", 1, "[getEditAvatarInfo] local info null, start query.");
        ZPlanEditAvatarUtils.f331613a.J(this.f331570d.getLongAccountUin(), new h(priority));
    }

    private void M() {
        this.I = false;
        FaceUtil.setUploadZplanFinish(true);
        String currentAccountUin = this.f331570d.getCurrentAccountUin();
        j0(currentAccountUin);
        I0(currentAccountUin);
        G0(currentAccountUin);
        FaceUtil.setTempAvatarFilePath(null);
        QLog.i("[ZPlanEditAvatarManager]", 1, "upload avatar success");
        m0(true);
        this.f331569b0 = 0;
    }

    private void P() {
        QLog.i("[ZPlanEditAvatarManager]", 1, "getActionConfig start");
        ((IRainbowApi) QRoute.api(IRainbowApi.class)).getCmdRainbowData("zplan", "head", ZPlanFeatureSwitch.f369852a.O0(), "conf", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(final boolean z16) {
        QLog.i("[ZPlanEditAvatarManager]", 1, "getSelfAvatarInfo start");
        ZPlanEditAvatarUtils.f331613a.J(Long.parseLong(this.f331570d.getCurrentUin()), new com.tencent.mobileqq.zplan.avatar.edit.f() { // from class: com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarManager.4
            @Override // com.tencent.mobileqq.zplan.avatar.edit.f
            public void a(boolean z17, com.tencent.mobileqq.zplan.avatar.edit.d dVar) {
                QLog.d("[ZPlanEditAvatarManager]", 1, "getSelfAvatarInfo:" + z17 + ",EditAvatarData:" + dVar);
                if (z17) {
                    ZPlanEditAvatarManager.this.P = dVar;
                    ZPlanEditAvatarManager.this.F = true;
                    return;
                }
                QLog.d("[ZPlanEditAvatarManager]", 1, "getSelfAvatarInfo error needRetry:" + z16);
                if (z16) {
                    ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarManager.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ZPlanEditAvatarManager.this.a0(false);
                        }
                    }, 16, null, false, 1000L);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(List<String> list) {
        QLog.i("[ZPlanEditAvatarManager]", 1, "handleAppearanceKeyChanged");
        if (list.contains(this.f331570d.getCurrentUin())) {
            ZPlanUserInfo userZPlanInfo = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(this.f331570d.getCurrentUin());
            String str = userZPlanInfo.appearanceKey;
            int i3 = userZPlanInfo.gender;
            if ((TextUtils.isEmpty(str) || str.equals(this.L)) && i3 == this.M) {
                return;
            }
            this.L = str;
            this.M = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(FileMsg fileMsg) {
        this.I = false;
        FaceUtil.setUploadZplanFinish(false);
        QLog.e("[ZPlanEditAvatarManager]", 1, String.format("handleUploadError, errorCode=%s", Integer.valueOf(fileMsg.errorCode)));
        v0(3);
        com.tencent.mobileqq.zplan.avatar.edit.g gVar = this.N;
        if (gVar != null) {
            gVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(FileMsg fileMsg) {
        QLog.d("[ZPlanEditAvatarManager]", 1, String.format("handleUploadFinished, errorCode=%s, filePath= %s", Integer.valueOf(fileMsg.errorCode), fileMsg));
        if (!((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn()) {
            M();
            return;
        }
        this.f331569b0++;
        QLog.e("[ZPlanEditAvatarManager]", 1, "handleUploadFinished success Time: " + this.f331569b0);
        if (this.f331569b0 == 1) {
            j T = T();
            if (T != null) {
                ZPlanAvatarUploadParam zPlanAvatarUploadParam = T.f331610f;
                if (zPlanAvatarUploadParam == null) {
                    QLog.e("[ZPlanEditAvatarManager]", 1, "handleUploadFinished uploadParam is null");
                    M();
                    return;
                }
                String outOfFrameAvatarPath = zPlanAvatarUploadParam.getOutOfFrameAvatarPath();
                int backgroundId = zPlanAvatarUploadParam.getBackgroundId();
                byte maskRate = (byte) (zPlanAvatarUploadParam.getMaskRate() * 100.0d);
                com.tencent.mobileqq.zplan.avatar.upload.a aVar = com.tencent.mobileqq.zplan.avatar.upload.a.f331975a;
                ProfileCardUtil.a b16 = aVar.b(this.f331570d, outOfFrameAvatarPath, false);
                if (b16.f306430a == 0 && FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS.equals(b16.f306431b)) {
                    QLog.i("[ZPlanEditAvatarManager]", 1, "startUpload: outbounds: [" + backgroundId + "," + ((int) maskRate) + "]" + outOfFrameAvatarPath);
                    int i3 = backgroundId > 0 ? backgroundId : 1;
                    if (maskRate > 100 || maskRate < 0) {
                        maskRate = 25;
                    }
                    aVar.e(this.f331570d, outOfFrameAvatarPath, 22, false, false, new a.ZplanAvatarInfo((byte) 2, i3, maskRate));
                }
            } else {
                QLog.e("[ZPlanEditAvatarManager]", 1, "handleUploadFinished task is null");
            }
        }
        if (this.f331569b0 == 2) {
            M();
        }
    }

    private void w0(j jVar) {
        String url;
        if (jVar == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "reportChangeAvatarSuccess failed, task null.");
            return;
        }
        com.tencent.mobileqq.zplan.avatar.edit.d dVar = jVar.f331609e;
        if (dVar == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "reportChangeAvatarSuccess failed, editAvatarData null.");
            return;
        }
        String W = W(jVar);
        BackgroundInfo backgroundInfo = dVar.getBackgroundInfo();
        if (backgroundInfo == null) {
            QLog.e("[ZPlanEditAvatarManager]", 1, "reportChangeAvatarSuccess failed, bgInfo null.");
            return;
        }
        String valueOf = String.valueOf(dVar.getActionId());
        if (backgroundInfo.getUrl() == null) {
            url = "";
        } else {
            url = backgroundInfo.getUrl();
        }
        this.Y.k(new b.AvatarRenewReportParam(valueOf, url, ZPlanEditAvatarUtils.f331613a.z(dVar.j()), jVar.f331611g, W, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class c implements com.tencent.mobileqq.zplan.avatar.manager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f331592a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.avatar.edit.d f331593b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Priority f331594c;

        c(int i3, com.tencent.mobileqq.zplan.avatar.edit.d dVar, Priority priority) {
            this.f331592a = i3;
            this.f331593b = dVar;
            this.f331594c = priority;
        }

        @Override // com.tencent.mobileqq.zplan.avatar.manager.a
        public void a(boolean z16, ZPlanEditAvatarAllConfigInfo zPlanEditAvatarAllConfigInfo) {
            if (zPlanEditAvatarAllConfigInfo == null) {
                QLog.e("[ZPlanEditAvatarManager]", 1, "buildUpdateWithAppearanceTaskV2 failed, getAvatarInfo null.");
                return;
            }
            for (nu4.g gVar : zPlanEditAvatarAllConfigInfo.c()) {
                if (gVar != null) {
                    int i3 = gVar.f421361id;
                    int i16 = this.f331592a;
                    if (i3 == i16 || gVar.inBoundsId == i16) {
                        ZPlanEditAvatarManager.this.N(this.f331593b, gVar, this.f331594c);
                        return;
                    }
                }
            }
        }
    }

    private String W(j jVar) {
        if (jVar != null && ZPlanEditAvatarEntranceScene.FOLLOW_APPEARANCE.getSourceString().equals(jVar.f331611g) && jVar.f331612h.longValue() != 0) {
            return Long.toString(Long.valueOf(System.currentTimeMillis() - jVar.f331612h.longValue()).longValue());
        }
        return "";
    }

    private com.tencent.mobileqq.zplan.avatar.edit.d b0(com.tencent.mobileqq.zplan.avatar.edit.d dVar) {
        List<com.tencent.mobileqq.zplan.avatar.edit.d> list;
        if (dVar != null && dVar.getActionId() != -1 && i0() && (list = this.Q) != null && !list.isEmpty()) {
            int c06 = c0(dVar.getActionId());
            if (c06 == -1) {
                QLog.e("[ZPlanEditAvatarManager]", 1, "getUpdatedAvatarDataWithAppearanceChg failed, updated actionId invalid.");
                return null;
            }
            dVar.p(c06);
            for (com.tencent.mobileqq.zplan.avatar.edit.d dVar2 : this.Q) {
                if (dVar2 != null && c06 == dVar2.getActionId()) {
                    dVar.s(dVar2.getDefaultUrl());
                    dVar.u(dVar2.getMaskRate());
                    dVar.t(dVar2.getInBoundsClipperInfo());
                    dVar.v(dVar2.getOutBoundsClipperInfo());
                }
            }
            QLog.i("[ZPlanEditAvatarManager]", 1, "getUpdatedAvatarDataWithAppearanceChg success, editAvatarData: " + dVar);
            return dVar;
        }
        QLog.e("[ZPlanEditAvatarManager]", 1, "getUpdatedAvatarDataWithAppearanceChg failed, input oldData invalid.");
        return null;
    }

    /* loaded from: classes35.dex */
    class d implements com.tencent.mobileqq.zplan.servlet.b {
        d() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            List emptyList;
            if (i3 == 27405) {
                try {
                    emptyList = (List) obj;
                } catch (Throwable th5) {
                    QLog.e("[ZPlanEditAvatarManager]", 1, "onUpdate PROFILE_APPEARANCE_KEY exception", th5);
                    emptyList = Collections.emptyList();
                }
                ZPlanEditAvatarManager.this.d0(emptyList);
            }
        }
    }

    /* loaded from: classes35.dex */
    class e extends com.tencent.mobileqq.rainbow.a {
        e() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (i3 != 2) {
                return;
            }
            QLog.d("[ZPlanEditAvatarManager]", 1, "getCmdRainbowData:" + z16);
            if (z16 && (obj instanceof JSONObject)) {
                try {
                    JSONObject jSONObject = ((JSONObject) obj).getJSONObject("conf");
                    ZPlanEditAvatarManager zPlanEditAvatarManager = ZPlanEditAvatarManager.this;
                    ZPlanEditAvatarUtils zPlanEditAvatarUtils = ZPlanEditAvatarUtils.f331613a;
                    zPlanEditAvatarManager.R = zPlanEditAvatarUtils.I(jSONObject, 1);
                    ZPlanEditAvatarManager.this.S = zPlanEditAvatarUtils.I(jSONObject, 2);
                    ZPlanEditAvatarManager zPlanEditAvatarManager2 = ZPlanEditAvatarManager.this;
                    zPlanEditAvatarManager2.Q = zPlanEditAvatarManager2.M == 2 ? ZPlanEditAvatarManager.this.S : ZPlanEditAvatarManager.this.R;
                    ZPlanEditAvatarManager.this.T = zPlanEditAvatarUtils.E(jSONObject);
                    ZPlanEditAvatarManager.this.U = zPlanEditAvatarUtils.S(jSONObject, 5);
                    ZPlanEditAvatarManager.this.V = zPlanEditAvatarUtils.L(jSONObject, 60);
                    ZPlanEditAvatarManager.this.W = zPlanEditAvatarUtils.v(jSONObject);
                    ZPlanEditAvatarManager.this.E = true;
                    ZPlanEditAvatarManager zPlanEditAvatarManager3 = ZPlanEditAvatarManager.this;
                    zPlanEditAvatarManager3.R(zPlanEditAvatarManager3.R);
                } catch (JSONException e16) {
                    QLog.e("[ZPlanEditAvatarManager]", 1, "getConfigJsonObject error", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(com.tencent.mobileqq.zplan.avatar.edit.d dVar, nu4.g gVar, Priority priority) {
        if (gVar == null) {
            return;
        }
        dVar.p(gVar.f421361id);
        dVar.q(gVar.name);
        dVar.s(gVar.defaultUrl);
        dVar.u(gVar.maskRate);
        nu4.b bVar = gVar.inBoundsClipper;
        nu4.b bVar2 = gVar.outBoundsClipper;
        if (bVar == null || bVar2 == null) {
            return;
        }
        dVar.t(new ClipperInfo(bVar.f421349x, bVar.f421350y, bVar.width, bVar.height));
        dVar.v(new ClipperInfo(bVar2.f421349x, bVar2.f421350y, bVar2.width, bVar2.height));
        QLog.i("[ZPlanEditAvatarManager]", 1, "[followAppearanceChg] getUpdatedAvatarDataWithAppearanceChg success, buildUpdateWithAppearanceTask" + dVar);
        j jVar = new j();
        jVar.f331605a = System.currentTimeMillis();
        jVar.f331606b = 2;
        jVar.f331609e = dVar;
        jVar.f331611g = ZPlanEditAvatarEntranceScene.FOLLOW_APPEARANCE.getSourceString();
        jVar.f331612h = Long.valueOf(System.currentTimeMillis());
        if (G(jVar)) {
            D0(priority);
        }
    }
}
