package dk3;

import bk3.a;
import bk3.b;
import ck3.ZPlanModReqInfo;
import com.google.protobuf.nano.MessageNano;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import com.tencent.zplan.resource.api.ZPlanUserAvatarInfoReq;
import com.tencent.zplan.resource.api.a;
import cy4.ZPlanResourceBusinessData;
import cy4.c;
import hv4.f;
import hv4.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import qu4.h;
import qu4.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J$\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J \u0010\u0013\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J8\u0010\u0017\u001a\u00020\f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016JV\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001aj\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J8\u0010 \u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182&\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001aj\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u001bH\u0016R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Ldk3/a;", "Lbk3/a;", "Lcom/tencent/zplan/resource/api/b;", "zPlanUserAvatarInfoReq", "Lqu4/s;", "V0", "Lcom/tencent/zplan/resource/api/a;", "resourceCallback", "Lvj3/b;", "mobileDownloadHandler", "", "throwError", "", "B", "Lck3/b;", "modInfo", "T0", "", "userReqInfo", "l", "", "stickerIdList", "onlyRequestInfo", "x0", "", "businessScene", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QQBrowserActivity.APP_PARAM, "Lhv4/k;", "extReqInfo", "p0", "w0", "Ljd3/a;", "b", "Ljd3/a;", "loadingReporter", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements bk3.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final jd3.a loadingReporter = new jd3.a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000O\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J2\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0016\u00a8\u0006\u001c"}, d2 = {"dk3/a$a", "Lbk3/b;", "", "progress", "", "totalTaskCount", "completedTaskCount", "", "f", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Lcy4/c;", "statisticData", "c", "", "checkCostTime", "", "needDownloadRes", "Lhv4/f;", "originalRspInfo", "a", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "errorCode", "", "errorMessage", "failedTaskCount", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dk3.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10187a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.zplan.resource.api.a f394037a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f394038b;

        C10187a(com.tencent.zplan.resource.api.a aVar, a aVar2) {
            this.f394037a = aVar;
            this.f394038b = aVar2;
        }

        @Override // bk3.b
        public void a(long checkCostTime, boolean needDownloadRes, f originalRspInfo) {
            Intrinsics.checkNotNullParameter(originalRspInfo, "originalRspInfo");
            com.tencent.zplan.resource.api.a aVar = this.f394037a;
            b bVar = aVar instanceof b ? (b) aVar : null;
            if (bVar != null) {
                bVar.a(checkCostTime, needDownloadRes, originalRspInfo);
            }
        }

        @Override // com.tencent.zplan.resource.api.a
        public void c(ZPlanResourceBusinessData businessData, c statisticData) {
            Intrinsics.checkNotNullParameter(businessData, "businessData");
            com.tencent.zplan.resource.api.a aVar = this.f394037a;
            if (aVar != null) {
                aVar.c(businessData, statisticData);
            }
        }

        @Override // com.tencent.zplan.resource.api.a
        public void d(ZPlanSceneResourceErrType errType, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
            Intrinsics.checkNotNullParameter(errType, "errType");
            com.tencent.zplan.resource.api.a aVar = this.f394037a;
            if (aVar != null) {
                aVar.d(errType, errorCode, errorMessage, totalTaskCount, failedTaskCount);
            }
            jd3.a aVar2 = this.f394038b.loadingReporter;
            if (errorMessage == null) {
                errorMessage = "";
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("zplan_error_msg", "\u70ed\u66f4\u68c0\u67e5\u5931\u8d25, errType= " + errType + ", totalTaskCount= " + totalTaskCount + ", failedTaskCount= " + failedTaskCount);
            Unit unit = Unit.INSTANCE;
            aVar2.d(errorCode, errorMessage, hashMap);
        }

        @Override // com.tencent.zplan.resource.api.a
        public void f(float progress, int totalTaskCount, int completedTaskCount) {
            b.a.a(this, progress, totalTaskCount, completedTaskCount);
            com.tencent.zplan.resource.api.a aVar = this.f394037a;
            if (aVar != null) {
                aVar.f(progress, totalTaskCount, completedTaskCount);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final s V0(ZPlanUserAvatarInfoReq zPlanUserAvatarInfoReq) {
        qu4.a c16;
        String dressKey;
        dw4.b value;
        int i3;
        qu4.a aVar;
        s sVar = new s();
        String uin = zPlanUserAvatarInfoReq.getUin();
        if (uin != null) {
            sVar.f429669a = uin;
        }
        Integer gender = zPlanUserAvatarInfoReq.getGender();
        if (gender != null) {
            sVar.f429670b = gender.intValue();
        }
        if (zPlanUserAvatarInfoReq.getAvatarCharacter() != null) {
            try {
                c16 = qu4.a.c(MessageNano.toByteArray(zPlanUserAvatarInfoReq.getAvatarCharacter()));
            } catch (Exception unused) {
                QLog.e("ZPlanResourceImpl", 1, "convertSceneExtInfo, AvatarCharacter error - " + zPlanUserAvatarInfoReq.getAvatarCharacter());
            }
            if (c16 != null) {
                sVar.f429671c = c16;
            }
            dressKey = zPlanUserAvatarInfoReq.getDressKey();
            if (dressKey != null) {
                h hVar = new h();
                hVar.f429598b = dressKey;
                sVar.f429672d = hVar;
            }
            if (zPlanUserAvatarInfoReq.getAvatarCharacter() == null && Intrinsics.areEqual(zPlanUserAvatarInfoReq.getUin(), w.f373306a.b())) {
                long currentTimeMillis = System.currentTimeMillis();
                value = com.tencent.sqshow.dresskey.b.f369818a.l("ZPlanResourceImpl", false).getValue();
                h hVar2 = value != null ? value.f395115b : null;
                QLog.i("ZPlanResourceImpl", 1, "convertSceneExtInfo, readAvatarCacheFromDressKey, cacheDressKeyInfo = " + hVar2 + ", costTime = " + (System.currentTimeMillis() - currentTimeMillis));
                if (value != null) {
                    Integer gender2 = zPlanUserAvatarInfoReq.getGender();
                    if (gender2 != null) {
                        i3 = gender2.intValue();
                    } else {
                        i3 = value.f395116c;
                    }
                    if (i3 == UEAvatarGender.MALE.getIndex()) {
                        aVar = value.f395117d;
                    } else {
                        aVar = value.f395118e;
                    }
                    h hVar3 = value.f395115b;
                    if (aVar != null && hVar3 != null) {
                        sVar.f429673e = true;
                        sVar.f429671c = aVar;
                        sVar.f429672d = hVar3;
                        sVar.f429670b = i3;
                    }
                }
            }
            return sVar;
        }
        c16 = null;
        if (c16 != null) {
        }
        dressKey = zPlanUserAvatarInfoReq.getDressKey();
        if (dressKey != null) {
        }
        if (zPlanUserAvatarInfoReq.getAvatarCharacter() == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            value = com.tencent.sqshow.dresskey.b.f369818a.l("ZPlanResourceImpl", false).getValue();
            if (value != null) {
            }
            QLog.i("ZPlanResourceImpl", 1, "convertSceneExtInfo, readAvatarCacheFromDressKey, cacheDressKeyInfo = " + hVar2 + ", costTime = " + (System.currentTimeMillis() - currentTimeMillis2));
            if (value != null) {
            }
        }
        return sVar;
    }

    @Override // bk3.a
    public void B(com.tencent.zplan.resource.api.a resourceCallback, vj3.b mobileDownloadHandler, boolean throwError) {
        if (ZPlanQQMC.INSTANCE.disableUEHotPatch()) {
            QLog.e("ZPlanResourceImpl-ZPlanUEHotPatchManager", 1, "skip UEHotPatch!");
            if (resourceCallback != null) {
                a.C10071a.b(resourceCallback, ZPlanResourceBusinessData.INSTANCE.a(), null, 2, null);
                return;
            }
            return;
        }
        p0(1, null, null, new C10187a(resourceCallback, this), mobileDownloadHandler);
    }

    @Override // bk3.a
    public void T0(ZPlanModReqInfo modInfo, com.tencent.zplan.resource.api.a resourceCallback, vj3.b mobileDownloadHandler) {
        Intrinsics.checkNotNullParameter(modInfo, "modInfo");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(VRReportDefine$ReportParam.AD_MOD_ID, modInfo.getModId());
        hashMap.put("mod_pack_ver", modInfo.getModLocalVersion());
        hashMap.put("mod_pack_type", String.valueOf(modInfo.getModPackType()));
        p0(8, hashMap, null, resourceCallback, mobileDownloadHandler);
    }

    @Override // bk3.a
    public void l(List<ZPlanUserAvatarInfoReq> userReqInfo, com.tencent.zplan.resource.api.a resourceCallback) {
        Intrinsics.checkNotNullParameter(userReqInfo, "userReqInfo");
        HashMap hashMap = new HashMap();
        k kVar = new k();
        if (!userReqInfo.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = userReqInfo.iterator();
            while (it.hasNext()) {
                arrayList.add(V0((ZPlanUserAvatarInfoReq) it.next()));
            }
            Object[] array = arrayList.toArray(new s[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            kVar.f406441b = (s[]) array;
        }
        a.C0132a.d(this, 2, hashMap, kVar, resourceCallback, null, 16, null);
    }

    @Override // bk3.a
    public void p0(int businessScene, HashMap<String, String> extraParams, k extReqInfo, com.tencent.zplan.resource.api.a resourceCallback, vj3.b mobileDownloadHandler) {
        fk3.a.k(fk3.a.f399712a, businessScene, extraParams, extReqInfo, false, resourceCallback, mobileDownloadHandler, 8, null);
    }

    @Override // bk3.a
    public boolean w0(int businessScene, HashMap<String, String> extraParams) {
        return fk3.a.f399712a.f(businessScene, extraParams);
    }

    @Override // bk3.a
    public void x0(List<ZPlanUserAvatarInfoReq> userReqInfo, List<String> stickerIdList, boolean onlyRequestInfo, com.tencent.zplan.resource.api.a resourceCallback) {
        k kVar;
        IntRange indices;
        Intrinsics.checkNotNullParameter(stickerIdList, "stickerIdList");
        HashMap hashMap = new HashMap();
        if (userReqInfo != null) {
            k kVar2 = new k();
            if (!userReqInfo.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = userReqInfo.iterator();
                while (it.hasNext()) {
                    arrayList.add(V0((ZPlanUserAvatarInfoReq) it.next()));
                }
                Object[] array = arrayList.toArray(new s[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                kVar2.f406441b = (s[]) array;
            }
            kVar = kVar2;
        } else {
            kVar = null;
        }
        StringBuilder sb5 = new StringBuilder();
        indices = CollectionsKt__CollectionsKt.getIndices(stickerIdList);
        Iterator<Integer> it5 = indices.iterator();
        while (it5.hasNext()) {
            int nextInt = ((IntIterator) it5).nextInt();
            sb5.append(stickerIdList.get(nextInt));
            if (nextInt < stickerIdList.size() - 1) {
                sb5.append(",");
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stickerIdsBuilder.toString()");
        hashMap.put("sticker_ids", sb6);
        fk3.a.k(fk3.a.f399712a, 3, hashMap, kVar, onlyRequestInfo, resourceCallback, null, 32, null);
    }
}
