package com.tencent.mobileqq.zplan.servlet;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.utils.af;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.trpcprotocol.zplan.CheckZplanAccessableAction$AccessableItem;
import com.tencent.trpcprotocol.zplan.CheckZplanAccessableAction$CheckAccessableRequest;
import com.tencent.trpcprotocol.zplan.CheckZplanAccessableAction$CheckAccessableResponse;
import com.tencent.trpcprotocol.zplan.CheckZplanAccessableAction$DetailResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002J.\u0010\u0011\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J,\u0010\u0013\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/o;", "", "Lcom/tencent/trpcprotocol/zplan/CheckZplanAccessableAction$CheckAccessableRequest;", "body", "Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;", "c", "", "", "uins", "appids", "b", "data", "Lcom/tencent/trpcprotocol/zplan/CheckZplanAccessableAction$CheckAccessableResponse;", "d", "Lnk3/m;", "callback", "", "e", "Lnk3/n;", "f", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f335425a = new o();

    o() {
    }

    private final CheckZplanAccessableAction$CheckAccessableRequest b(List<Long> uins, List<Long> appids) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(appids);
        if (appids.isEmpty()) {
            QLog.w("[zplan]ZPlanWhiteListRequest", 1, "appids isEmpty");
        } else if (!arrayList.contains(1000L)) {
            arrayList.add(1000L);
        }
        CheckZplanAccessableAction$CheckAccessableRequest checkZplanAccessableAction$CheckAccessableRequest = new CheckZplanAccessableAction$CheckAccessableRequest();
        checkZplanAccessableAction$CheckAccessableRequest.hardware_info.set(ByteStringMicro.copyFromUtf8(com.tencent.mobileqq.zplan.utils.i.b()));
        checkZplanAccessableAction$CheckAccessableRequest.uins.set(uins);
        checkZplanAccessableAction$CheckAccessableRequest.appids.set(arrayList);
        checkZplanAccessableAction$CheckAccessableRequest.phone_type.set(DeviceInfoMonitor.getModel());
        checkZplanAccessableAction$CheckAccessableRequest.client_version.set("android " + AppSetting.f99551k + "." + AppSetting.f99542b);
        return checkZplanAccessableAction$CheckAccessableRequest;
    }

    private final oidb_sso$OIDBSSOPkg c(CheckZplanAccessableAction$CheckAccessableRequest body) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(4266);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(body.toByteArray()));
        return oidb_sso_oidbssopkg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CheckZplanAccessableAction$CheckAccessableResponse d(Object data) {
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
            oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
            Integer valueOf = oidb_sso_oidbssopkg.uint32_result.has() ? Integer.valueOf(oidb_sso_oidbssopkg.uint32_result.get()) : null;
            String str = oidb_sso_oidbssopkg.str_error_msg.has() ? oidb_sso_oidbssopkg.str_error_msg.get() : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                CheckZplanAccessableAction$CheckAccessableResponse checkZplanAccessableAction$CheckAccessableResponse = new CheckZplanAccessableAction$CheckAccessableResponse();
                checkZplanAccessableAction$CheckAccessableResponse.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                return checkZplanAccessableAction$CheckAccessableResponse;
            }
            QLog.e("[zplan]ZPlanWhiteListRequest", 1, "extract0x10aaRespPkg fail, result:" + valueOf + ", errMsg:" + str);
            return null;
        } catch (Throwable th5) {
            QLog.e("[zplan]ZPlanWhiteListRequest", 1, "extract0x10aaRespPkg exception:", th5);
            return null;
        }
    }

    @Deprecated(message = "\u8001\u63a5\u53e3\uff0c\u65b0\u4e1a\u52a1\u5efa\u8bae\u4e0d\u518d\u4f7f\u7528", replaceWith = @ReplaceWith(expression = "ZPlanWhiteListRequest#getAccessibleDetail", imports = {}))
    public final void e(List<Long> uins, List<Long> appids, nk3.m callback) {
        Intrinsics.checkNotNullParameter(uins, "uins");
        Intrinsics.checkNotNullParameter(appids, "appids");
        f(uins, appids, new a(callback));
    }

    public final void f(List<Long> uins, List<Long> appids, nk3.n callback) {
        Intrinsics.checkNotNullParameter(uins, "uins");
        Intrinsics.checkNotNullParameter(appids, "appids");
        oidb_sso$OIDBSSOPkg c16 = c(b(uins, appids));
        ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
        if (a16 != null) {
            a16.request("OidbSvcTrpcTcp.0x10aa", c16.toByteArray(), new b(callback, appids));
        } else if (callback != null) {
            callback.a(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/servlet/o$b", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ nk3.n f335426d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<Long> f335427e;

        b(nk3.n nVar, List<Long> list) {
            this.f335426d = nVar;
            this.f335427e = list;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            boolean enableFlushAccessableDiskCacheOnce = ZPlanQQMC.INSTANCE.enableFlushAccessableDiskCacheOnce();
            try {
                CheckZplanAccessableAction$CheckAccessableResponse d16 = o.f335425a.d(data);
                if (d16 == null) {
                    QLog.e("[zplan]ZPlanWhiteListRequest", 1, "getAccessibleDetail response is null");
                    nk3.n nVar = this.f335426d;
                    if (nVar != null) {
                        nVar.a(null);
                        return;
                    }
                    return;
                }
                List<CheckZplanAccessableAction$AccessableItem> list = d16.accessable_items.get();
                if (list != null && list.size() != 0) {
                    for (CheckZplanAccessableAction$AccessableItem checkZplanAccessableAction$AccessableItem : list) {
                        List<CheckZplanAccessableAction$DetailResult> list2 = checkZplanAccessableAction$AccessableItem.appid_detail_results.get();
                        if (list2 != null && list2.size() != 0) {
                            ArrayList arrayList = new ArrayList();
                            for (CheckZplanAccessableAction$DetailResult checkZplanAccessableAction$DetailResult : list2) {
                                AccessibleDetail accessibleDetail = new AccessibleDetail(checkZplanAccessableAction$DetailResult.get().appid.get(), checkZplanAccessableAction$DetailResult.get().appid_exsit.get(), checkZplanAccessableAction$DetailResult.get().phone_pass.get(), checkZplanAccessableAction$DetailResult.get().uin_pass.get(), checkZplanAccessableAction$DetailResult.get().all_pass.get(), checkZplanAccessableAction$DetailResult.get().switch_pass.get(), checkZplanAccessableAction$DetailResult.get().entrance_type.get(), checkZplanAccessableAction$DetailResult.get().setting_pass.get());
                                arrayList.add(accessibleDetail);
                                if (this.f335426d != null && accessibleDetail.getAppid() == this.f335427e.get(0).longValue()) {
                                    this.f335426d.a(accessibleDetail);
                                    QLog.i("[zplan]ZPlanWhiteListRequest", 1, "getAccessibleDetail return value:" + accessibleDetail);
                                }
                                QLog.i("[zplan]ZPlanWhiteListRequest", 1, "uin:" + checkZplanAccessableAction$AccessableItem.uin + " resultItem:" + accessibleDetail);
                                af.f335758a.g(checkZplanAccessableAction$AccessableItem.uin.get(), accessibleDetail, !enableFlushAccessableDiskCacheOnce);
                            }
                        }
                        QLog.e("[zplan]ZPlanWhiteListRequest", 1, "getAccessibleDetail appid_detail_results invalid " + list2);
                        nk3.n nVar2 = this.f335426d;
                        if (nVar2 != null) {
                            nVar2.a(null);
                            return;
                        }
                        return;
                    }
                    if (enableFlushAccessableDiskCacheOnce) {
                        af.f335758a.a();
                    }
                    boolean enableRefrshFilmentSwitch = ZPlanQQMC.INSTANCE.enableRefrshFilmentSwitch();
                    QLog.i("[zplan]ZPlanWhiteListRequest", 1, "enableRefreshFilamentSwitch " + enableRefrshFilmentSwitch);
                    if (enableRefrshFilmentSwitch) {
                        FilamentApiImpl.f369933a.loadConfig(null);
                    }
                    uk3.c.f439112a.b(d16.req_gap_seconds.get());
                    return;
                }
                QLog.e("[zplan]ZPlanWhiteListRequest", 1, "accessibleItems invalid", list);
                nk3.n nVar3 = this.f335426d;
                if (nVar3 != null) {
                    nVar3.a(null);
                }
            } catch (Exception e16) {
                nk3.n nVar4 = this.f335426d;
                if (nVar4 != null) {
                    nVar4.a(null);
                }
                QLog.e("[zplan]ZPlanWhiteListRequest", 1, "getAccessibleDetail onUpdate exception:", e16);
                if (enableFlushAccessableDiskCacheOnce) {
                    af.f335758a.a();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/servlet/o$a", "Lnk3/n;", "Lcom/tencent/mobileqq/zplan/model/AccessibleDetail;", "detailResult", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements nk3.n {
        a(nk3.m mVar) {
        }

        @Override // nk3.n
        public void a(AccessibleDetail detailResult) {
            if (detailResult == null) {
                return;
            }
            uk3.i.f439124a.d();
        }
    }
}
