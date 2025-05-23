package com.tencent.mobileqq.zootopia.download.mod.hotpatch;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import ck3.ZPlanModHotPatchStatus;
import ck3.ZPlanModReqInfo;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.space.MapOccupiedSpaceManager;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.resource.api.data.mod.ZPlanResHubResultInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.ab;
import com.tencent.sqshow.zootopia.utils.t;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import cy4.ZPlanResourceBusinessData;
import hv4.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import vj3.b;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001:\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b>\u0010?J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J6\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0017J6\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0017J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002J \u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u0017J\u000e\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010$\u001a\u00020\u0017J\u0006\u0010%\u001a\u00020\u0017R0\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0&j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R0\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020+0&j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020+`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010)RH\u00101\u001a6\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00170.0&j\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00170.`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010)RX\u00105\u001aF\u0012\u0004\u0012\u00020\u0002\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u000102j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`30&j\"\u0012\u0004\u0012\u00020\u0002\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u000102j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`3`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010)R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ZPlanModHotPatchManager;", "", "", "modId", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/a;", "listener", "", "l", "r", "Lcom/tencent/mobileqq/zplan/resource/api/data/mod/ZPlanResHubResultInfo;", "resultInfo", UserInfo.SEX_FEMALE, "checkModVersion", "D", "newHotPatchInfo", "oldHotPatchInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "y", "logMsg", BdhLogUtil.LogTag.Tag_Conn, "B", "downloadSrc", "resourceCallback", "", "fromEnterMod", "needMobileDownloadTips", "t", "Lck3/b;", "modInfo", ReportConstant.COSTREPORT_PREFIX, "o", "reason", "fromClearCache", "p", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ZPlanModHotPatchConfig;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "hotPatchInfoMap", "Lck3/a;", "c", "downloadStatusMap", "Lkotlin/Pair;", "", "d", "downloadQueryResultCache", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "downloadListenerMap", "Lbc3/a;", "f", "Lbc3/a;", "hotPatchReporter", "com/tencent/mobileqq/zootopia/download/mod/hotpatch/ZPlanModHotPatchManager$downloadListenerProxy$1", "g", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ZPlanModHotPatchManager$downloadListenerProxy$1;", "downloadListenerProxy", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanModHotPatchManager {

    /* renamed from: a */
    public static final ZPlanModHotPatchManager f328077a = new ZPlanModHotPatchManager();

    /* renamed from: b, reason: from kotlin metadata */
    private static final HashMap<String, ZPlanResHubResultInfo> hotPatchInfoMap = new HashMap<>();

    /* renamed from: c, reason: from kotlin metadata */
    private static final HashMap<String, ZPlanModHotPatchStatus> downloadStatusMap = new HashMap<>();

    /* renamed from: d, reason: from kotlin metadata */
    private static final HashMap<String, Pair<Long, Boolean>> downloadQueryResultCache = new HashMap<>();

    /* renamed from: e, reason: from kotlin metadata */
    private static final HashMap<String, ArrayList<com.tencent.mobileqq.zootopia.download.mod.hotpatch.a>> downloadListenerMap = new HashMap<>();

    /* renamed from: f, reason: from kotlin metadata */
    private static final bc3.a hotPatchReporter = new bc3.a();

    /* renamed from: g, reason: from kotlin metadata */
    private static final ZPlanModHotPatchManager$downloadListenerProxy$1 downloadListenerProxy = new ZPlanModHotPatchManager$downloadListenerProxy$1();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/download/mod/hotpatch/ZPlanModHotPatchManager$b", "Lvj3/b;", "", "needDownloadSize", "Lvj3/c;", "resultCallback", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements vj3.b {

        /* renamed from: a */
        final /* synthetic */ String f328089a;

        /* renamed from: b */
        final /* synthetic */ String f328090b;

        b(String str, String str2) {
            this.f328089a = str;
            this.f328090b = str2;
        }

        @Override // vj3.b
        public boolean a() {
            return b.a.a(this);
        }

        @Override // vj3.b
        public void b(long needDownloadSize, vj3.c resultCallback) {
            Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
            ZPlanModHotPatchManager.f328077a.B(this.f328089a + ", checkWhenMobileDownload  BEGIN");
            ZPlanModHotPatchManager.downloadListenerProxy.checkWhenMobileDownload(this.f328090b, needDownloadSize, resultCallback);
        }
    }

    ZPlanModHotPatchManager() {
    }

    public final void B(String logMsg) {
        QLog.e("ZPlanModHotPatchManager", 1, logMsg);
    }

    public final void C(String str) {
        QLog.i("ZPlanModHotPatchManager", 1, str);
    }

    public final ZPlanResHubResultInfo D(String modId, String checkModVersion) {
        ZPlanResHubResultInfo zPlanResHubResultInfo;
        HashMap<String, ZPlanResHubResultInfo> hashMap = hotPatchInfoMap;
        ZPlanResHubResultInfo zPlanResHubResultInfo2 = hashMap.get(modId);
        if (zPlanResHubResultInfo2 != null) {
            if (TextUtils.isEmpty(checkModVersion) || Intrinsics.areEqual(checkModVersion, zPlanResHubResultInfo2.getModMainPakVersion())) {
                return zPlanResHubResultInfo2;
            }
            B("readHotPatchCacheInfo modVersion not equal, cache= " + zPlanResHubResultInfo2.getModMainPakVersion() + ", input= " + checkModVersion);
            return null;
        }
        byte[] bytes = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBytes(y(modId), new byte[0]);
        if (!(!(bytes.length == 0)) || (zPlanResHubResultInfo = (ZPlanResHubResultInfo) bf3.a.f28357a.c(bytes)) == null) {
            return null;
        }
        hashMap.put(modId, zPlanResHubResultInfo);
        if (TextUtils.isEmpty(checkModVersion) || Intrinsics.areEqual(checkModVersion, zPlanResHubResultInfo.getModMainPakVersion())) {
            return zPlanResHubResultInfo;
        }
        B("readHotPatchCacheInfo modVersion not equal, dbCache= " + zPlanResHubResultInfo.getModMainPakVersion() + ", input= " + checkModVersion);
        return null;
    }

    public final void F(String str, ZPlanResHubResultInfo zPlanResHubResultInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        m(str, zPlanResHubResultInfo, E(this, str, null, 2, null));
        hotPatchInfoMap.put(str, zPlanResHubResultInfo);
        byte[] a16 = bf3.a.f28357a.a(zPlanResHubResultInfo);
        if (a16 != null) {
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBytes(f328077a.y(str), a16);
        }
        C("saveHotPatchInfo-" + str + ", " + zPlanResHubResultInfo + ", costTime= " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public static final /* synthetic */ HashMap c() {
        return downloadListenerMap;
    }

    public static final /* synthetic */ void i(ZPlanModHotPatchManager zPlanModHotPatchManager, String str) {
        zPlanModHotPatchManager.C(str);
    }

    private final void l(String modId, com.tencent.mobileqq.zootopia.download.mod.hotpatch.a listener) {
        if (TextUtils.isEmpty(modId) || listener == null) {
            return;
        }
        HashMap<String, ArrayList<com.tencent.mobileqq.zootopia.download.mod.hotpatch.a>> hashMap = downloadListenerMap;
        ArrayList<com.tencent.mobileqq.zootopia.download.mod.hotpatch.a> arrayList = hashMap.get(modId);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            hashMap.put(modId, arrayList);
            C("newListenerList");
        } else {
            C("listenerList already exist!!!");
        }
        if (arrayList.contains(listener)) {
            return;
        }
        arrayList.add(listener);
    }

    public static final void n(ZPlanResHubResultInfo zPlanResHubResultInfo, ZPlanResHubResultInfo newHotPatchInfo) {
        Intrinsics.checkNotNullParameter(newHotPatchInfo, "$newHotPatchInfo");
        try {
            FileUtils.deleteDirectory(zPlanResHubResultInfo.getResHubLocalPath());
            if (TextUtils.isEmpty(zPlanResHubResultInfo.getResHubOriginalPath()) || Intrinsics.areEqual(zPlanResHubResultInfo.getResHubOriginalPath(), newHotPatchInfo.getResHubOriginalPath())) {
                return;
            }
            String resHubOriginalPath = zPlanResHubResultInfo.getResHubOriginalPath();
            String str = null;
            if (resHubOriginalPath != null) {
                String separator = File.separator;
                Intrinsics.checkNotNullExpressionValue(separator, "separator");
                str = StringsKt__StringsKt.substringBeforeLast$default(resHubOriginalPath, separator, (String) null, 2, (Object) null);
            }
            f328077a.B("clear old resHubPath! fixedResHubPath=" + str + ", old= " + zPlanResHubResultInfo.getResHubOriginalPath() + ", new= " + newHotPatchInfo.getResHubOriginalPath());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            FileUtils.deleteDirectory(str);
        } catch (Exception e16) {
            QLog.e("ZPlanModHotPatchManager", 1, "checkClearOldHotPatch exception", e16);
        }
    }

    public static final void w(ZPlanModReqInfo modInfo, boolean z16, String logPrefix, String modId, boolean z17, long j3) {
        Intrinsics.checkNotNullParameter(modInfo, "$modInfo");
        Intrinsics.checkNotNullParameter(logPrefix, "$logPrefix");
        Intrinsics.checkNotNullParameter(modId, "$modId");
        ((bk3.a) vb3.a.f441346a.a(bk3.a.class)).T0(modInfo, new a(logPrefix, modId, modInfo, z17, j3), !z16 ? null : new b(logPrefix, modId));
    }

    private final String y(String modId) {
        return "zplan_mod_hotpatch_" + ab.INSTANCE.b() + "_" + modId;
    }

    public final boolean A() {
        HashMap<String, ZPlanModHotPatchStatus> hashMap = downloadStatusMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ZPlanModHotPatchStatus> entry : hashMap.entrySet()) {
            if (entry.getValue().getIsDownloading()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        boolean z16 = !linkedHashMap.isEmpty();
        QLog.i("ZPlanModHotPatchManager", 1, "isDownloadingHotPatch = " + z16 + ", " + downloadStatusMap);
        return z16;
    }

    public final boolean o(String modId) {
        String str;
        Intrinsics.checkNotNullParameter(modId, "modId");
        ZPlanModHotPatchStatus zPlanModHotPatchStatus = downloadStatusMap.get(modId);
        if (zPlanModHotPatchStatus == null) {
            return true;
        }
        if (zPlanModHotPatchStatus.getIsDownloading()) {
            return false;
        }
        ZPlanModHotPatchConfig z16 = z(modId);
        if (!z16.getEnableHotPatch()) {
            return false;
        }
        long validTime = z16.getValidTime();
        if (zPlanModHotPatchStatus.getLastFinishTime() <= 0 || System.currentTimeMillis() - zPlanModHotPatchStatus.getLastFinishTime() >= validTime) {
            return true;
        }
        ZPlanResHubResultInfo E = E(this, modId, null, 2, null);
        if (E == null || (str = E.getResHubLocalPath()) == null) {
            str = "";
        }
        if (FileUtils.fileExists(str)) {
            return false;
        }
        q(this, modId, "checkNeedSilentDownloadModHotPatch, file not exist", false, 4, null);
        return true;
    }

    public final void p(String modId, String reason, boolean fromClearCache) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        HashMap<String, ZPlanModHotPatchStatus> hashMap = downloadStatusMap;
        ZPlanModHotPatchStatus zPlanModHotPatchStatus = hashMap.get(modId);
        B("clearHotPatchInfo - " + modId + ", reason= " + reason + ", currentStatus= " + zPlanModHotPatchStatus);
        boolean z16 = false;
        if (zPlanModHotPatchStatus != null && !zPlanModHotPatchStatus.getIsDownloading()) {
            z16 = true;
        }
        if (z16) {
            hashMap.remove(modId);
        }
        if (fromClearCache) {
            r(modId);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s(String downloadSrc, final ZPlanModReqInfo modInfo, com.tencent.mobileqq.zootopia.download.mod.hotpatch.a aVar, final boolean z16, final boolean z17) {
        long j3;
        boolean z18;
        String str;
        Intrinsics.checkNotNullParameter(downloadSrc, "downloadSrc");
        Intrinsics.checkNotNullParameter(modInfo, "modInfo");
        final String modId = modInfo.getModId();
        final String str2 = downloadSrc + " downloadModHotPatchResource-" + modId;
        ZPlanModHotPatchConfig z19 = z(modId);
        if (!z19.getEnableHotPatch()) {
            C(str2 + ", enableHotPatch false!");
            if (aVar != null) {
                aVar.onDownloadSuccess(modId, null, false, false);
                return;
            }
            return;
        }
        HashMap<String, ZPlanModHotPatchStatus> hashMap = downloadStatusMap;
        ZPlanModHotPatchStatus zPlanModHotPatchStatus = hashMap.get(modId);
        long validTime = z19.getValidTime();
        if (zPlanModHotPatchStatus == null || zPlanModHotPatchStatus.getIsDownloading() || zPlanModHotPatchStatus.getLastFinishTime() <= 0 || System.currentTimeMillis() - zPlanModHotPatchStatus.getLastFinishTime() >= validTime) {
            j3 = 0;
        } else {
            ZPlanResHubResultInfo D = D(modId, modInfo.getModLocalVersion());
            if (D == null || (str = D.getResHubLocalPath()) == null) {
                str = "";
            }
            if (FileUtils.fileExists(str)) {
                C(str2 + ", directly return, lastTime= " + t.f373300a.f(zPlanModHotPatchStatus.getLastFinishTime()) + ", resValidDuration= " + validTime + ", modInfo= " + modInfo + ", cacheInfo= " + D);
                if (aVar != null) {
                    aVar.onDownloadSuccess(modId, D, false, false);
                }
                z18 = true;
                j3 = 0;
                if (z18) {
                    if (aVar != null) {
                        aVar.onRealCheckStart(modId);
                    }
                    l(modId, aVar);
                    if (zPlanModHotPatchStatus != null && zPlanModHotPatchStatus.getIsDownloading()) {
                        B(str2 + ", already downloading, wait...");
                        Pair<Long, Boolean> pair = downloadQueryResultCache.get(modId);
                        if (pair != null) {
                            f328077a.C(str2 + ", onDownloadInfoCheckResult, cache = " + pair);
                            if (aVar != null) {
                                aVar.onCheckResult(modId, pair.getFirst().longValue(), pair.getSecond().booleanValue());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    C(str2 + ", START - " + modInfo);
                    hashMap.put(modId, new ZPlanModHotPatchStatus(true, j3));
                    downloadQueryResultCache.remove(modId);
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            ZPlanModHotPatchManager.w(ZPlanModReqInfo.this, z17, str2, modId, z16, currentTimeMillis);
                        }
                    }, 128, null, false);
                    hotPatchReporter.i(modInfo, z16 ^ true);
                    return;
                }
                return;
            }
            j3 = 0;
            q(this, modId, "hit time limit, but file not exist", false, 4, null);
        }
        z18 = false;
        if (z18) {
        }
    }

    public final boolean x() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("zplan_mod_hotpatch_silent_switch", false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0018, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r2, new java.lang.String[]{";"}, false, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003c, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ZPlanModHotPatchConfig z(String modId) {
        Integer intOrNull;
        List split$default;
        Intrinsics.checkNotNullParameter(modId, "modId");
        Map<String, String> x26 = ZPlanFeatureSwitch.f369852a.x2();
        String str = x26.get("ModIdList");
        boolean contains = (str == null || split$default == null) ? false : split$default.contains(modId);
        String str2 = x26.get("HotPatchValidTime");
        int intValue = (str2 == null || intOrNull == null) ? 1 : intOrNull.intValue();
        return new ZPlanModHotPatchConfig(modId, contains, intValue * 60 * 1000);
    }

    @Metadata(d1 = {"\u0000M\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J2\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0016\u00a8\u0006\u001c"}, d2 = {"com/tencent/mobileqq/zootopia/download/mod/hotpatch/ZPlanModHotPatchManager$a", "Lbk3/b;", "", "checkCostTime", "", "needDownloadRes", "Lhv4/f;", "originalRspInfo", "", "a", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Lcy4/c;", "statisticData", "c", "", "progress", "", "totalTaskCount", "completedTaskCount", "f", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "errorCode", "", "errorMessage", "failedTaskCount", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements bk3.b {

        /* renamed from: a */
        final /* synthetic */ String f328084a;

        /* renamed from: b */
        final /* synthetic */ String f328085b;

        /* renamed from: c */
        final /* synthetic */ ZPlanModReqInfo f328086c;

        /* renamed from: d */
        final /* synthetic */ boolean f328087d;

        /* renamed from: e */
        final /* synthetic */ long f328088e;

        a(String str, String str2, ZPlanModReqInfo zPlanModReqInfo, boolean z16, long j3) {
            this.f328084a = str;
            this.f328085b = str2;
            this.f328086c = zPlanModReqInfo;
            this.f328087d = z16;
            this.f328088e = j3;
        }

        @Override // com.tencent.zplan.resource.api.a
        public void f(float progress, int totalTaskCount, int completedTaskCount) {
            ZPlanModHotPatchManager.downloadListenerProxy.onDownloadProgress(this.f328085b, progress, totalTaskCount, completedTaskCount);
        }

        @Override // com.tencent.zplan.resource.api.a
        public void c(ZPlanResourceBusinessData r19, cy4.c statisticData) {
            ZPlanResHubResultInfo D;
            Intrinsics.checkNotNullParameter(r19, "businessData");
            ZPlanModHotPatchManager.downloadQueryResultCache.remove(this.f328085b);
            boolean z16 = false;
            ZPlanModHotPatchManager.downloadStatusMap.put(this.f328085b, new ZPlanModHotPatchStatus(false, System.currentTimeMillis()));
            Object originalExtInfoBytes = r19.getOriginalExtInfoBytes();
            ZPlanResHubResultInfo zPlanResHubResultInfo = originalExtInfoBytes instanceof ZPlanResHubResultInfo ? (ZPlanResHubResultInfo) originalExtInfoBytes : null;
            if (zPlanResHubResultInfo != null && zPlanResHubResultInfo.isValid()) {
                z16 = true;
            }
            if (!z16 || zPlanResHubResultInfo == null) {
                D = ZPlanModHotPatchManager.f328077a.D(this.f328085b, this.f328086c.getModLocalVersion());
            } else {
                zPlanResHubResultInfo.setModMainPakVersion(this.f328086c.getModLocalVersion());
                ZPlanModHotPatchManager.f328077a.F(this.f328085b, zPlanResHubResultInfo);
                MapOccupiedSpaceManager.f329259b.B(this.f328086c.getModId());
                D = zPlanResHubResultInfo;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f328088e;
            ZPlanModHotPatchManager.f328077a.C(this.f328084a + ", onDownloadSuccess, totalCostTime= " + currentTimeMillis + ", callbackResHubInfo= " + zPlanResHubResultInfo + ", finalFixed= " + D);
            ZPlanModHotPatchManager.downloadListenerProxy.onDownloadSuccess(this.f328085b, D, true, z16);
            ZPlanModHotPatchManager.hotPatchReporter.h(true, 0, "", this.f328086c, this.f328087d ^ true, currentTimeMillis, true, z16);
        }

        @Override // com.tencent.zplan.resource.api.a
        public void d(ZPlanSceneResourceErrType r202, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
            Intrinsics.checkNotNullParameter(r202, "errType");
            ZPlanModHotPatchManager.downloadQueryResultCache.remove(this.f328085b);
            ZPlanModHotPatchManager.downloadStatusMap.put(this.f328085b, new ZPlanModHotPatchStatus(false, 0L));
            long currentTimeMillis = System.currentTimeMillis() - this.f328088e;
            ZPlanModHotPatchManager.f328077a.B(this.f328084a + ", onDownloadError, totalCostTime= " + currentTimeMillis + ", " + errorCode + ", " + errorMessage);
            ZPlanModHotPatchManager.downloadListenerProxy.onDownloadError(this.f328085b, r202, errorCode, errorMessage, totalTaskCount, failedTaskCount);
            ZPlanModHotPatchManager.hotPatchReporter.h(false, errorCode, errorMessage == null ? "" : errorMessage, this.f328086c, !this.f328087d, currentTimeMillis, true, true);
            com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.u(this.f328085b, "", errorCode, errorMessage == null ? "" : errorMessage, 1);
        }

        @Override // bk3.b
        public void a(long checkCostTime, boolean needDownloadRes, f originalRspInfo) {
            Intrinsics.checkNotNullParameter(originalRspInfo, "originalRspInfo");
            ZPlanModHotPatchManager.f328077a.C(this.f328084a + ", onDownloadInfoCheckResult, checkCostTime= " + checkCostTime + ", needDownloadRes= " + needDownloadRes);
            ZPlanModHotPatchManager.downloadQueryResultCache.put(this.f328085b, new Pair(Long.valueOf(checkCostTime), Boolean.valueOf(needDownloadRes)));
            ZPlanModHotPatchManager.downloadListenerProxy.onCheckResult(this.f328085b, checkCostTime, needDownloadRes);
            if (needDownloadRes) {
                ZPlanModHotPatchManager.hotPatchReporter.f(this.f328086c, !this.f328087d, (r20 & 4) != 0 ? false : false, (r20 & 8) != 0 ? false : false, (r20 & 16) != 0 ? 0 : 0, (r20 & 32) != 0 ? "" : null, (r20 & 64) != 0 ? 0L : 0L);
            }
        }
    }

    private final void m(String str, final ZPlanResHubResultInfo zPlanResHubResultInfo, final ZPlanResHubResultInfo zPlanResHubResultInfo2) {
        if (zPlanResHubResultInfo2 == null || TextUtils.isEmpty(zPlanResHubResultInfo2.getResHubLocalPath()) || Intrinsics.areEqual(zPlanResHubResultInfo2.getResHubLocalPath(), zPlanResHubResultInfo.getResHubLocalPath())) {
            return;
        }
        B("checkClearOldHotPatch! old= " + zPlanResHubResultInfo2.getResHubLocalPath() + ", new= " + zPlanResHubResultInfo.getResHubLocalPath());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanModHotPatchManager.n(ZPlanResHubResultInfo.this, zPlanResHubResultInfo);
            }
        }, 64, null, false);
    }

    static /* synthetic */ ZPlanResHubResultInfo E(ZPlanModHotPatchManager zPlanModHotPatchManager, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        return zPlanModHotPatchManager.D(str, str2);
    }

    public static /* synthetic */ void q(ZPlanModHotPatchManager zPlanModHotPatchManager, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        zPlanModHotPatchManager.p(str, str2, z16);
    }

    public final void t(final String downloadSrc, final String modId, final com.tencent.mobileqq.zootopia.download.mod.hotpatch.a resourceCallback, final boolean fromEnterMod, final boolean needMobileDownloadTips) {
        Intrinsics.checkNotNullParameter(downloadSrc, "downloadSrc");
        Intrinsics.checkNotNullParameter(modId, "modId");
        final String str = downloadSrc + " downloadModHotPatchResource-" + modId;
        C(str + " withId");
        if (!z(modId).getEnableHotPatch()) {
            C(str + ", enableHotPatch false!");
            if (resourceCallback != null) {
                resourceCallback.onDownloadSuccess(modId, null, false, false);
                return;
            }
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        ZootopiaDownloadManager.f327992a.Y(modId, new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager$downloadModHotPatchResource$1
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
            public final void invoke2(final ZootopiaDownloadData zootopiaDownloadData) {
                final String str2 = str;
                final String str3 = modId;
                final String str4 = downloadSrc;
                final a aVar = resourceCallback;
                final boolean z16 = fromEnterMod;
                final boolean z17 = needMobileDownloadTips;
                final long j3 = currentTimeMillis;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager$downloadModHotPatchResource$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ZootopiaDownloadData zootopiaDownloadData2 = ZootopiaDownloadData.this;
                        if (zootopiaDownloadData2 != null) {
                            ZPlanModHotPatchManager zPlanModHotPatchManager = ZPlanModHotPatchManager.f328077a;
                            zPlanModHotPatchManager.C(str2 + ", " + zootopiaDownloadData2.getSummaryData().getTitle() + ", downloadStatus= " + ZootopiaDownloadData.this.getResData().getDownloadStatus());
                            zPlanModHotPatchManager.s(str4, new ZPlanModReqInfo(str3, ZootopiaDownloadData.this.getResData().getModVersionSimpleData().getNowMapVer(), ZootopiaDownloadData.this.getResData().getModVersionSimpleData().getPackType()), aVar, z16, z17);
                            return;
                        }
                        ZPlanModHotPatchManager.f328077a.B(str2 + ", getDownloadData null");
                        if (aVar != null) {
                            String str5 = "downloadData is null - " + str3;
                            aVar.onDownloadError(str3, ZPlanSceneResourceErrType.QueryResourceError, -1000901, str5, 0, 0);
                            ZPlanModReqInfo zPlanModReqInfo = new ZPlanModReqInfo(str3, "", -1);
                            ZPlanModHotPatchManager.hotPatchReporter.i(zPlanModReqInfo, !z16);
                            ZPlanModHotPatchManager.hotPatchReporter.h(false, -1000901, str5, zPlanModReqInfo, !z16, System.currentTimeMillis() - j3, false, false);
                            com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.u(str3, "", -1000901, str5, 1);
                        }
                    }
                });
            }
        });
    }

    private final void r(String modId) {
        ZPlanResHubResultInfo E = E(this, modId, null, 2, null);
        C("clearHotPatchResultInfo - " + modId + ", oldCacheInfo= " + E);
        if (E != null && E.getResId() != null && !TextUtils.isEmpty(E.getAppId()) && !TextUtils.isEmpty(E.getResId())) {
            vb3.a aVar = vb3.a.f441346a;
            ((vj3.a) aVar.a(vj3.a.class)).f(false);
            vj3.a aVar2 = (vj3.a) aVar.a(vj3.a.class);
            String appId = E.getAppId();
            if (appId == null) {
                appId = "";
            }
            String appKey = E.getAppKey();
            if (appKey == null) {
                appKey = "";
            }
            String env = E.getEnv();
            if (env == null) {
                env = "";
            }
            String resId = E.getResId();
            aVar2.x(appId, appKey, env, resId != null ? resId : "");
        }
        m(modId, new ZPlanResHubResultInfo("", "", "", null, null, null, null, null, 248, null), E);
        hotPatchInfoMap.remove(modId);
        downloadQueryResultCache.remove(modId);
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).remove(y(modId));
    }

    public static /* synthetic */ void u(ZPlanModHotPatchManager zPlanModHotPatchManager, String str, ZPlanModReqInfo zPlanModReqInfo, com.tencent.mobileqq.zootopia.download.mod.hotpatch.a aVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        zPlanModHotPatchManager.s(str, zPlanModReqInfo, aVar, (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? false : z17);
    }

    public static /* synthetic */ void v(ZPlanModHotPatchManager zPlanModHotPatchManager, String str, String str2, com.tencent.mobileqq.zootopia.download.mod.hotpatch.a aVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        zPlanModHotPatchManager.t(str, str2, aVar, (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? false : z17);
    }
}
