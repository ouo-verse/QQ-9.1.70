package com.tencent.sqshow.zootopia.nativeui.view.page;

import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.AvatarSlot;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.state.report.SquareReportConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import mqq.app.MobileQQ;
import uv4.az;
import uv4.be;
import uv4.bk;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0016J\u0016\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010#R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u0006/"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/page/ZPlanAvatarPreDownloadManager;", "", "", "start", "Luv4/az;", "storeItem", "", "duration", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Luv4/bk;", "data", "i", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "g", "", "slotId", "itemId", "", "l", "o", "r", tl.h.F, "source", "p", "k", "", "b", "Ljava/util/List;", "dataList", "c", "Z", "isDownloading", "Lkotlinx/coroutines/CoroutineScope;", "d", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "e", "canPreDownload", "f", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanAvatarPreDownloadManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanAvatarPreDownloadManager f371947a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final List<bk> dataList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isDownloading;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static CoroutineScope coroutineScope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean canPreDownload;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static String source;

    static {
        ZPlanAvatarPreDownloadManager zPlanAvatarPreDownloadManager = new ZPlanAvatarPreDownloadManager();
        f371947a = zPlanAvatarPreDownloadManager;
        dataList = new ArrayList();
        source = "";
        boolean m3 = zPlanAvatarPreDownloadManager.m();
        canPreDownload = m3;
        if (m3) {
            coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        }
        QLog.i("ZPlanAvatarPreDownloadManager", 1, "ZPlanAvatarPreDownloadManager canPreDownload: " + canPreDownload);
    }

    ZPlanAvatarPreDownloadManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0056 A[EDGE_INSN: B:31:0x0056->B:32:0x0056 BREAK  A[LOOP:0: B:9:0x0019->B:37:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[LOOP:0: B:9:0x0019->B:37:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean i(bk data) {
        be beVar;
        Object obj;
        boolean z16;
        az azVar;
        az azVar2;
        be beVar2;
        az azVar3 = data.f440366b;
        if (azVar3 == null || (beVar = azVar3.f440290q) == null) {
            return true;
        }
        long j3 = beVar.f440324a;
        long j16 = azVar3.f440275b;
        Iterator<T> it = dataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            bk bkVar = (bk) obj;
            if ((bkVar == null || (azVar2 = bkVar.f440366b) == null || (beVar2 = azVar2.f440290q) == null || ((long) beVar2.f440324a) != j3) ? false : true) {
                if ((bkVar == null || (azVar = bkVar.f440366b) == null || ((long) azVar.f440275b) != j16) ? false : true) {
                    z16 = true;
                    if (!z16) {
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        return ((bk) obj) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(bk data, FilamentUrlTemplate urlTemplate) {
        az azVar = data.f440366b;
        if (azVar == null || azVar.f440290q == null) {
            return false;
        }
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
        return FilamentFileUtil.INSTANCE.fileExistsAtPath(zPlanAvatarResourceHelper.N0(zPlanAvatarResourceHelper.p0(r94.b.M(azVar), azVar.f440275b, urlTemplate), urlTemplate));
    }

    private final String l(int slotId, int itemId) {
        return slotId + "-" + itemId;
    }

    private final boolean m() {
        if (!FilamentApiImpl.f369933a.d()) {
            return false;
        }
        boolean enableZPlanStorePreload = ZPlanQQMC.INSTANCE.enableZPlanStorePreload();
        QLog.i("ZPlanAvatarPreDownloadManager", 1, "ZPlanAvatarPreDownloadManager onSwitch: " + enableZPlanStorePreload);
        if (!enableZPlanStorePreload) {
            return false;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_zplan_avatar_mall_preload_test");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026LL_PRELOAD_TEST\n        )");
        expEntity.reportExpExposure();
        if (expEntity.isExperiment("exp_zplan_avatar_mall_preload_test_A")) {
            QLog.i("ZPlanAvatarPreDownloadManager", 1, "exp_zplan_avatar_mall_preload_test_A");
            return false;
        }
        QLog.i("ZPlanAvatarPreDownloadManager", 1, "exp_zplan_avatar_mall_preload_test_B");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(boolean start, az storeItem, long duration) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, source);
        hashMap.put("zplan_item_id", Integer.valueOf(storeItem.f440275b));
        hashMap.put("zplan_gender", Integer.valueOf(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex()));
        hashMap.put("zplan_is_ai_sculpt", Integer.valueOf(r94.b.A(storeItem) ? 1 : 0));
        if (!start) {
            hashMap.put("zplan_loading_lvtm", Long.valueOf(duration));
            str = "ev_zplan_item_pre_download_success";
        } else {
            str = "ev_zplan_item_pre_download_begin";
        }
        VideoReport.reportEvent(str, null, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(FilamentUrlTemplate urlTemplate) {
        List<bk> list = dataList;
        List<bk> list2 = list;
        if ((list2 == null || list2.isEmpty()) || isDownloading) {
            return;
        }
        g(list.get(0), urlTemplate);
        list.remove(0);
    }

    public final String h() {
        return source;
    }

    public final void p(String source2) {
        Intrinsics.checkNotNullParameter(source2, "source");
        source = source2;
    }

    public final void r(bk data) {
        az azVar;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!canPreDownload || (azVar = data.f440366b) == null || azVar.f440290q == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(azVar, "data.storeItem");
        if (r94.b.M(azVar) == AvatarSlot.cfgpb_AvatarSlot_EN_SLOT_EPAULET.getValue() + 1 || i(data)) {
            return;
        }
        dataList.add(0, data);
        q(FilamentFeatureUtil.f106409g.F());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int slotId, int itemId) {
        try {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
            from.encodeBool(l(slotId, itemId), true);
        } catch (Exception e16) {
            QLog.i("ZPlanAvatarPreDownloadManager", 1, e16.toString());
        }
    }

    public final boolean k(int slotId, int itemId) {
        try {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
            return from.decodeBool(l(slotId, itemId), false);
        } catch (Exception unused) {
            return false;
        }
    }

    private final void g(bk data, FilamentUrlTemplate urlTemplate) {
        az azVar = data.f440366b;
        if (azVar == null || azVar.f440290q == null) {
            return;
        }
        String p06 = ZPlanAvatarResourceHelper.f105660o.p0(r94.b.M(azVar), azVar.f440275b, urlTemplate);
        if (p06.length() == 0) {
            isDownloading = false;
            return;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        isDownloading = true;
        n(true, azVar, 0L);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new ZPlanAvatarPreDownloadManager$downloadItem$1(azVar, System.currentTimeMillis(), booleanRef, data, urlTemplate, p06, null), 2, null);
    }
}
