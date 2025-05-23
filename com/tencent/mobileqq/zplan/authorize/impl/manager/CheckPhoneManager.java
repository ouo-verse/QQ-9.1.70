package com.tencent.mobileqq.zplan.authorize.impl.manager;

import com.google.protobuf.nano.MessageNano;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.sdk.app.WadlConstant;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkpublish.config.WinkPublishConfigConstant;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import gw4.f;
import gw4.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003$%&B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\"\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ \u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ \u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u0014\u001a\u00020\fJ\u0016\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0019J\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001dJ\u0016\u0010!\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager;", "", "", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$EntryType;", "entryType", "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$DataType;", "dataType", "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$a;", "checkPhoneCallback", "", "needUpdate", "", "c", "", "entranceId", "e", h.F, "i", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mapId", "Lgw4/f;", "commonCheckResult", "r", "Lgw4/b;", "j", "checkEntranceResult", DomainData.DOMAIN_NAME, "Lgw4/g;", "l", "qqForceUpgradeInfo", "p", "k", "<init>", "()V", "a", "DataType", "EntryType", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CheckPhoneManager {

    /* renamed from: a, reason: collision with root package name */
    public static final CheckPhoneManager f331491a = new CheckPhoneManager();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$DataType;", "", "(Ljava/lang/String;I)V", IYunGameConstant.MIDAS_FLATFORM_TYPE, QzoneDataUpdateAction.UPDATE, "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum DataType {
        PHONE,
        UPDATE
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$EntryType;", "", "(Ljava/lang/String;I)V", "AVATAR", "MOD", "PAGE", "THIRD", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum EntryType {
        AVATAR,
        MOD,
        PAGE,
        THIRD
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f331492a;

        static {
            int[] iArr = new int[EntryType.values().length];
            try {
                iArr[EntryType.AVATAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EntryType.MOD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EntryType.THIRD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f331492a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lgw4/c;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements e<gw4.c> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DataType f331493d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f331494e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f331495f;

        c(DataType dataType, a aVar, String str) {
            this.f331493d = dataType;
            this.f331494e = aVar;
            this.f331495f = str;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(gw4.c result) {
            gw4.h hVar;
            Intrinsics.checkNotNullParameter(result, "result");
            gw4.b[] bVarArr = result.f403463b;
            String str = null;
            QLog.d("CheckPhoneManager", 1, "checkEntrance => " + (bVarArr != null ? Integer.valueOf(bVarArr.length) : null));
            gw4.b[] bVarArr2 = result.f403463b;
            Intrinsics.checkNotNullExpressionValue(bVarArr2, "result.list");
            if (bVarArr2.length == 0) {
                if (this.f331493d == DataType.PHONE) {
                    a aVar = this.f331494e;
                    if (aVar != null) {
                        a.C9150a.c(aVar, false, false, null, 6, null);
                    }
                } else {
                    a aVar2 = this.f331494e;
                    if (aVar2 != null) {
                        aVar2.b(true);
                    }
                }
                QLog.e("CheckPhoneManager", 1, "checkPhoneByMapId error , result list is empty");
                return;
            }
            gw4.b checkEntranceResult = result.f403463b[0];
            f fVar = checkEntranceResult.f403460b;
            if (Intrinsics.areEqual(checkEntranceResult.f403459a, this.f331495f)) {
                CheckPhoneManager checkPhoneManager = CheckPhoneManager.f331491a;
                String str2 = this.f331495f;
                Intrinsics.checkNotNullExpressionValue(checkEntranceResult, "checkEntranceResult");
                checkPhoneManager.n(str2, checkEntranceResult);
                if (this.f331493d == DataType.PHONE) {
                    f fVar2 = checkEntranceResult.f403460b;
                    if (fVar2 != null && (hVar = fVar2.f403474e) != null) {
                        str = hVar.f403479a;
                    }
                    if (str == null) {
                        str = "";
                    }
                    a aVar3 = this.f331494e;
                    if (aVar3 != null) {
                        int i3 = fVar.f403471b;
                        aVar3.a(i3 == 1, i3 != 0, str);
                    }
                } else {
                    a aVar4 = this.f331494e;
                    if (aVar4 != null) {
                        aVar4.b(checkEntranceResult.f403461c);
                    }
                }
                QLog.i("CheckPhoneManager", 1, "checkPhoneByMapId success , mapID == " + this.f331495f + " :: result == " + fVar.f403471b);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            if (this.f331493d == DataType.PHONE) {
                a aVar = this.f331494e;
                if (aVar != null) {
                    a.C9150a.c(aVar, false, false, null, 6, null);
                }
            } else {
                a aVar2 = this.f331494e;
                if (aVar2 != null) {
                    aVar2.b(true);
                }
            }
            QLog.e("CheckPhoneManager", 1, "CheckPhoneRequest error " + error + ", " + message);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lgw4/c;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements e<gw4.c> {
        d() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(gw4.c result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("CheckPhoneManager", 1, "preLoadAllMapData success :: result size == " + result.f403463b.length);
            gw4.b[] bVarArr = result.f403463b;
            Intrinsics.checkNotNullExpressionValue(bVarArr, "result.list");
            for (gw4.b it : bVarArr) {
                CheckPhoneManager checkPhoneManager = CheckPhoneManager.f331491a;
                String str = it.f403459a;
                Intrinsics.checkNotNullExpressionValue(str, "it.entranceId");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                checkPhoneManager.n(str, it);
            }
            g gVar = result.f403462a;
            if (gVar != null) {
                CheckPhoneManager checkPhoneManager2 = CheckPhoneManager.f331491a;
                Intrinsics.checkNotNullExpressionValue(gVar, "result.qqForceUpgradeInfo");
                checkPhoneManager2.p(gVar);
                return;
            }
            QLog.i("CheckPhoneManager", 1, "preLoadAllMapData success :: has no force update info");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("CheckPhoneManager", 1, "preLoadAllMapData error :: " + error + ", " + message);
        }
    }

    CheckPhoneManager() {
    }

    private final void c(int sceneId, EntryType entryType, DataType dataType, a checkPhoneCallback, boolean needUpdate) {
        gw4.h hVar;
        String k3 = k(sceneId, entryType);
        QLog.i("CheckPhoneManager", 1, "checkPhoneByMapIdFromCacheOrNet start :: entranceId == " + k3);
        gw4.b j3 = j(k3);
        if (j3 != null) {
            if (dataType == DataType.PHONE) {
                f fVar = j3.f403460b;
                if (fVar != null) {
                    QLog.i("CheckPhoneManager", 1, "checkPhoneByMapIdFromCacheOrNet success :: cache exist , entranceId == " + k3 + " , result == " + fVar.f403471b);
                    f fVar2 = j3.f403460b;
                    String str = (fVar2 == null || (hVar = fVar2.f403474e) == null) ? null : hVar.f403479a;
                    if (str == null) {
                        str = "";
                    }
                    if (checkPhoneCallback != null) {
                        int i3 = fVar2.f403471b;
                        checkPhoneCallback.a(i3 == 1, i3 != 0, str);
                    }
                } else {
                    QLog.i("CheckPhoneManager", 1, "checkPhoneByMapIdFromCacheOrNet success :: cache exist , entranceId == " + k3 + " , no need to check");
                    if (checkPhoneCallback != null) {
                        a.C9150a.c(checkPhoneCallback, true, false, null, 6, null);
                    }
                }
            } else {
                QLog.i("CheckPhoneManager", 1, "checkPhoneByMapIdFromCacheOrNet success :: cache exist , entranceId == " + k3 + " , force update result == " + j3.f403461c);
                if (checkPhoneCallback != null) {
                    checkPhoneCallback.b(j3.f403461c);
                }
            }
            if (needUpdate) {
                f(this, k3, dataType, null, 4, null);
                return;
            }
            return;
        }
        if (dataType == DataType.PHONE) {
            QLog.i("CheckPhoneManager", 1, "checkPhoneByMapIdFromCacheOrNet :: cache not exist , entranceId == " + k3 + " , start net request");
            e(k3, dataType, checkPhoneCallback);
            return;
        }
        QLog.i("CheckPhoneManager", 1, "checkPhoneByMapIdFromCacheOrNet :: cache not exist , entranceId == " + k3 + " ,do not show dialog");
        if (checkPhoneCallback != null) {
            checkPhoneCallback.b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String str, String entranceId, gw4.b checkEntranceResult) {
        Intrinsics.checkNotNullParameter(entranceId, "$entranceId");
        Intrinsics.checkNotNullParameter(checkEntranceResult, "$checkEntranceResult");
        IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
        String str2 = "phone_cache" + v84.a.a() + str + entranceId;
        byte[] byteArray = MessageNano.toByteArray(checkEntranceResult);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(checkEntranceResult)");
        iZPlanMMKVApi.setBytes(str2, byteArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(g qqForceUpgradeInfo) {
        Intrinsics.checkNotNullParameter(qqForceUpgradeInfo, "$qqForceUpgradeInfo");
        IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
        byte[] byteArray = MessageNano.toByteArray(qqForceUpgradeInfo);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(qqForceUpgradeInfo)");
        iZPlanMMKVApi.setBytes("update_cache", byteArray);
    }

    public final void e(String entranceId, DataType dataType, a checkPhoneCallback) {
        Intrinsics.checkNotNullParameter(entranceId, "entranceId");
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        QLog.i("CheckPhoneManager", 1, "checkPhoneByMapId start , entranceId == " + entranceId);
        if (entranceId.length() == 0) {
            QLog.e("CheckPhoneManager", 1, "checkPhoneByMapIdFromNet error :: entranceId is empty");
            if (dataType == DataType.PHONE) {
                if (checkPhoneCallback != null) {
                    a.C9150a.c(checkPhoneCallback, false, false, null, 6, null);
                    return;
                }
                return;
            } else {
                if (checkPhoneCallback != null) {
                    checkPhoneCallback.b(true);
                    return;
                }
                return;
            }
        }
        gw4.a aVar = new gw4.a();
        aVar.f403456a = new String[]{entranceId};
        aVar.f403457b = qb4.a.f428794a.e();
        if (!ZootopiaDownloadManager.f327992a.m0()) {
            if (dataType == DataType.PHONE) {
                if (checkPhoneCallback != null) {
                    a.C9150a.c(checkPhoneCallback, false, false, null, 6, null);
                }
            } else if (checkPhoneCallback != null) {
                checkPhoneCallback.b(true);
            }
            QLog.e("CheckPhoneManager", 1, "checkPhoneByMapId error , net work unavailable");
            return;
        }
        QLog.i("CheckPhoneManager", 1, "checkPhoneByMapId expId=" + aVar.f403457b);
        re3.a.b(re3.a.f431164a, aVar, new c(dataType, checkPhoneCallback, entranceId), 0, 4, null);
    }

    public final void g(int sceneId, EntryType entryType, a checkPhoneCallback) {
        Intrinsics.checkNotNullParameter(entryType, "entryType");
        d(this, sceneId, entryType, DataType.UPDATE, checkPhoneCallback, false, 16, null);
    }

    public final void h(int sceneId, EntryType entryType, a checkPhoneCallback) {
        Intrinsics.checkNotNullParameter(entryType, "entryType");
        d(this, sceneId, entryType, DataType.PHONE, checkPhoneCallback, false, 16, null);
    }

    public final void i(int sceneId, EntryType entryType, a checkPhoneCallback) {
        Intrinsics.checkNotNullParameter(entryType, "entryType");
        c(sceneId, entryType, DataType.PHONE, checkPhoneCallback, true);
    }

    public final gw4.b j(String entranceId) {
        Intrinsics.checkNotNullParameter(entranceId, "entranceId");
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount == null) {
            return null;
        }
        String uin = firstSimpleAccount.getUin();
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        if (!(uin.length() > 0)) {
            return null;
        }
        byte[] bytes = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBytes("phone_cache" + v84.a.a() + uin + entranceId, new byte[0]);
        if (!(bytes.length == 0)) {
            return gw4.b.d(bytes);
        }
        return null;
    }

    public final String k(int sceneId, EntryType entryType) {
        String str;
        Intrinsics.checkNotNullParameter(entryType, "entryType");
        int i3 = b.f331492a[entryType.ordinal()];
        if (i3 == 1) {
            str = WinkPublishConfigConstant.EVENTID_PREFIX_QCIRCLE_AVATAR;
        } else if (i3 == 2) {
            str = "Mod_";
        } else if (i3 != 3) {
            str = "Page_";
        } else {
            str = "Third_";
        }
        return str + sceneId;
    }

    public final g l() {
        byte[] bytes = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBytes("update_cache", new byte[0]);
        if (!(bytes.length == 0)) {
            return g.c(bytes);
        }
        return null;
    }

    public final void n(final String entranceId, final gw4.b checkEntranceResult) {
        Intrinsics.checkNotNullParameter(entranceId, "entranceId");
        Intrinsics.checkNotNullParameter(checkEntranceResult, "checkEntranceResult");
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        Unit unit = null;
        if (firstSimpleAccount != null) {
            final String uin = firstSimpleAccount.getUin();
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            if (uin.length() > 0) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.authorize.impl.manager.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        CheckPhoneManager.o(uin, entranceId, checkEntranceResult);
                    }
                }, 64, null, true);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e("CheckPhoneManager", 1, "saveCheckResultCache :: simpleAccount is null");
        }
    }

    public final void p(final g qqForceUpgradeInfo) {
        Intrinsics.checkNotNullParameter(qqForceUpgradeInfo, "qqForceUpgradeInfo");
        String str = qqForceUpgradeInfo.f403477c;
        Intrinsics.checkNotNullExpressionValue(str, "qqForceUpgradeInfo.promptMessage");
        if (str.length() > 0) {
            String str2 = qqForceUpgradeInfo.f403476b;
            Intrinsics.checkNotNullExpressionValue(str2, "qqForceUpgradeInfo.backgroundUrl");
            if (str2.length() > 0) {
                String str3 = qqForceUpgradeInfo.f403478d;
                Intrinsics.checkNotNullExpressionValue(str3, "qqForceUpgradeInfo.jumpUrl");
                if (str3.length() > 0) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.authorize.impl.manager.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            CheckPhoneManager.q(g.this);
                        }
                    }, 64, null, true);
                    QLog.i("CheckPhoneManager", 1, "saveForceUpdateResultCache :: jumpUrl == " + qqForceUpgradeInfo.f403478d + " , backgroundUrl == " + qqForceUpgradeInfo.f403476b + " , isForce == " + qqForceUpgradeInfo.f403475a);
                }
            }
        }
    }

    public final void r(int mapId, f commonCheckResult) {
        Intrinsics.checkNotNullParameter(commonCheckResult, "commonCheckResult");
        QLog.i("CheckPhoneManager", 1, "updateCheckResultCache :: mapId == " + mapId + " , result == " + commonCheckResult.f403471b);
        String k3 = k(mapId, EntryType.MOD);
        gw4.b j3 = j(k3);
        if (j3 != null) {
            j3.f403460b = commonCheckResult;
            f331491a.n(k3, j3);
        }
    }

    public final void m() {
        QLog.i("CheckPhoneManager", 1, "preLoadAllMapData start");
        gw4.a aVar = new gw4.a();
        aVar.f403456a = new String[0];
        re3.a.b(re3.a.f431164a, aVar, new d(), 0, 4, null);
    }

    public static /* synthetic */ void f(CheckPhoneManager checkPhoneManager, String str, DataType dataType, a aVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        checkPhoneManager.e(str, dataType, aVar);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$a;", "", "", WadlConstant.SIGN_IS_WHITE, "isNotBlack", "", "redirectScheme", "", "a", "result", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface a {
        void a(boolean isWhite, boolean isNotBlack, String redirectScheme);

        void b(boolean result);

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager$a$a, reason: collision with other inner class name */
        /* loaded from: classes35.dex */
        public static final class C9150a {
            public static void b(a aVar, boolean z16, boolean z17, String redirectScheme) {
                Intrinsics.checkNotNullParameter(redirectScheme, "redirectScheme");
            }

            public static /* synthetic */ void c(a aVar, boolean z16, boolean z17, String str, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 2) != 0) {
                        z17 = false;
                    }
                    if ((i3 & 4) != 0) {
                        str = "";
                    }
                    aVar.a(z16, z17, str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPhoneResult");
            }

            public static void a(a aVar, boolean z16) {
            }
        }
    }

    static /* synthetic */ void d(CheckPhoneManager checkPhoneManager, int i3, EntryType entryType, DataType dataType, a aVar, boolean z16, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            z16 = false;
        }
        checkPhoneManager.c(i3, entryType, dataType, aVar, z16);
    }
}
