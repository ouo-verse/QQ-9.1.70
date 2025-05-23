package com.tencent.mobileqq.vas.adv.base.service;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.AdvPush;
import com.tencent.mobileqq.vas.adv.common.pb.SplashAd;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mobileqq.vas.api.impl.PbProtocolSSoImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;
import tencent.gdt.adSchedule$QueryAllReq;
import tencent.gdt.adSchedule$QueryAllRsp;
import tencent.gdt.adSchedule$ReportReq;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b;\u0010<J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\u001e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H\u0002J(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0014H\u0002J\u001e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\nH\u0002J@\u0010!\u001a\u00020\u0006\"\u000e\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\u001a2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\f\u0010#\u001a\u00020\"*\u00020\u0002H\u0002J\f\u0010$\u001a\u00020\"*\u00020\u0016H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\u001c\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004J\u001c\u0010*\u001a\u00020\u00062\u0006\u0010'\u001a\u00020)2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0004J\u001c\u0010,\u001a\u00020\u00062\u0006\u0010'\u001a\u00020+2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\u0004J\u001c\u0010.\u001a\u00020\u00062\u0006\u0010'\u001a\u00020-2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004J\u001c\u00101\u001a\u00020\u00062\u0006\u0010'\u001a\u00020/2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002000\u0004J\u001c\u00105\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00102\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020403J\u0014\u00108\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020706J\u000e\u0010:\u001a\u00020\u00062\u0006\u0010'\u001a\u000209\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/service/e;", "", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "advRsp", "Lbz2/a;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ltencent/gdt/access$AdGetRsp;", DomainData.DOMAIN_NAME, "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "j", "Ltencent/gdt/access$FeedAdGetRsp;", "feedAdvRsp", "o", "", "cmd", "cmdKey", "reqBytes", "Lcom/tencent/mobileqq/vas/adv/base/support/app/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", "reportRsp", "l", "i", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "errCode", "errMsg", "", "e", "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", tl.h.F, "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvReq;", Const.BUNDLE_KEY_REQUEST, "u", "Ltencent/gdt/access$AdGetReq;", "v", "Ltencent/gdt/access$FeedAdGetReq;", "w", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportReq;", "r", "Lcom/tencent/mobileqq/vas/adv/common/pb/AdvPush$AdvPushReq;", "Lcom/tencent/mobileqq/vas/adv/common/pb/AdvPush$AdvPushRsp;", HippyTKDListViewAdapter.X, "req", "Lbz2/b;", "Lcom/tencent/mobileqq/vas/adv/common/pb/SplashAd$SplashAdGetRsp;", "y", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "Ltencent/gdt/adSchedule$QueryAllRsp;", "t", "Ltencent/gdt/adSchedule$ReportReq;", ReportConstant.COSTREPORT_PREFIX, "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f307985a = new e();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/vas/adv/base/service/e$a", "Lcom/tencent/mobileqq/vas/adv/base/support/app/d;", "", "returnCode", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "errorCode", "", "errMsg", "", "e", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements com.tencent.mobileqq.vas.adv.base.support.app.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bz2.a<adv_report.MobileAdvReportRsp> f307986a;

        a(bz2.a<adv_report.MobileAdvReportRsp> aVar) {
            this.f307986a = aVar;
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void a(int errorCode, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            e.f307985a.k(this.f307986a, VasAdvServiceCode.REPORT_CMD_ERROR, "report ad onError: " + errMsg, e16);
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void b(int returnCode, @NotNull byte[] rspBytes) {
            Intrinsics.checkNotNullParameter(rspBytes, "rspBytes");
            try {
                e eVar = e.f307985a;
                eVar.l(eVar.i(rspBytes), this.f307986a);
            } catch (Exception e16) {
                e.f307985a.k(this.f307986a, VasAdvServiceCode.REPORT_RSP_PARSE_ERR, "parse report rsp exception: " + e16.getMessage(), e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/vas/adv/base/service/e$b", "Lcom/tencent/mobileqq/vas/adv/base/support/app/d;", "", "returnCode", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "errorCode", "", "errMsg", "", "e", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements com.tencent.mobileqq.vas.adv.base.support.app.d {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void a(int errorCode, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("VasAdvService", 1, "request reportAdDownloadEvent error:" + errorCode, e16);
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void b(int returnCode, @NotNull byte[] rspBytes) {
            Intrinsics.checkNotNullParameter(rspBytes, "rspBytes");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/vas/adv/base/service/e$c", "Lcom/tencent/mobileqq/vas/adv/base/support/app/d;", "", "returnCode", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "errorCode", "", "errMsg", "", "e", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements com.tencent.mobileqq.vas.adv.base.support.app.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VasResultCallback<adSchedule$QueryAllRsp> f307987a;

        c(VasResultCallback<adSchedule$QueryAllRsp> vasResultCallback) {
            this.f307987a = vasResultCallback;
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void a(int errorCode, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("VasAdvService", 1, "request reqScheduleAd error:" + errorCode, e16);
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void b(int returnCode, @NotNull byte[] rspBytes) {
            Intrinsics.checkNotNullParameter(rspBytes, "rspBytes");
            try {
                adSchedule$QueryAllRsp adschedule_queryallrsp = new adSchedule$QueryAllRsp();
                adschedule_queryallrsp.mergeFrom(rspBytes);
                this.f307987a.onResult(adschedule_queryallrsp);
            } catch (Exception e16) {
                QLog.e("VasAdvService", 1, "request reqScheduleAd failed:" + e16 + ".message", e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/vas/adv/base/service/e$d", "Lcom/tencent/mobileqq/vas/adv/base/support/app/d;", "", "returnCode", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "errorCode", "", "errMsg", "", "e", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements com.tencent.mobileqq.vas.adv.base.support.app.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bz2.a<vac_adv_get.VacAdvRsp> f307988a;

        d(bz2.a<vac_adv_get.VacAdvRsp> aVar) {
            this.f307988a = aVar;
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void a(int errorCode, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            e.f307985a.k(this.f307988a, VasAdvServiceCode.REQUEST_CMD_ERROR, "request ad onError: " + errMsg, e16);
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void b(int returnCode, @NotNull byte[] rspBytes) {
            Intrinsics.checkNotNullParameter(rspBytes, "rspBytes");
            try {
                e eVar = e.f307985a;
                eVar.m(eVar.j(rspBytes), this.f307988a);
            } catch (Exception e16) {
                e.f307985a.k(this.f307988a, VasAdvServiceCode.REQUEST_RSP_PARSE_ERR, "parse rsp exception: " + e16.getMessage(), e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/vas/adv/base/service/e$e", "Lcom/tencent/mobileqq/vas/adv/base/support/app/d;", "", "returnCode", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "errorCode", "", "errMsg", "", "e", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.adv.base.service.e$e, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C8898e implements com.tencent.mobileqq.vas.adv.base.support.app.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bz2.a<access.AdGetRsp> f307989a;

        C8898e(bz2.a<access.AdGetRsp> aVar) {
            this.f307989a = aVar;
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void a(int errorCode, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            e.f307985a.k(this.f307989a, VasAdvServiceCode.REQUEST_CMD_ERROR, "request ad onError: " + errMsg, e16);
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void b(int returnCode, @NotNull byte[] rspBytes) {
            Intrinsics.checkNotNullParameter(rspBytes, "rspBytes");
            try {
                access.AdGetRsp adGetRsp = new access.AdGetRsp();
                adGetRsp.mergeFrom(rspBytes);
                e.f307985a.n(adGetRsp, this.f307989a);
            } catch (Exception e16) {
                e.f307985a.k(this.f307989a, VasAdvServiceCode.REQUEST_RSP_PARSE_ERR, "parse rsp exception: " + e16.getMessage(), e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/vas/adv/base/service/e$f", "Lcom/tencent/mobileqq/vas/adv/base/support/app/d;", "", "returnCode", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "errorCode", "", "errMsg", "", "e", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class f implements com.tencent.mobileqq.vas.adv.base.support.app.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bz2.a<access.FeedAdGetRsp> f307990a;

        f(bz2.a<access.FeedAdGetRsp> aVar) {
            this.f307990a = aVar;
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void a(int errorCode, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            e.f307985a.k(this.f307990a, VasAdvServiceCode.REQUEST_CMD_ERROR, "request ad onError: " + errMsg, e16);
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void b(int returnCode, @NotNull byte[] rspBytes) {
            Intrinsics.checkNotNullParameter(rspBytes, "rspBytes");
            try {
                access.FeedAdGetRsp feedAdGetRsp = new access.FeedAdGetRsp();
                feedAdGetRsp.mergeFrom(rspBytes);
                e.f307985a.o(feedAdGetRsp, this.f307990a);
            } catch (Exception e16) {
                e.f307985a.k(this.f307990a, VasAdvServiceCode.REQUEST_RSP_PARSE_ERR, "parse rsp exception: " + e16.getMessage(), e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/vas/adv/base/service/e$g", "Lcom/tencent/mobileqq/vas/adv/base/support/app/d;", "", "returnCode", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "errorCode", "", "errMsg", "", "e", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class g implements com.tencent.mobileqq.vas.adv.base.support.app.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bz2.a<AdvPush.AdvPushRsp> f307991a;

        g(bz2.a<AdvPush.AdvPushRsp> aVar) {
            this.f307991a = aVar;
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void a(int errorCode, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f307991a.b(VasAdvServiceCode.REQUEST_CMD_ERROR, "request pa ad error:" + errMsg, e16);
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void b(int returnCode, @NotNull byte[] rspBytes) {
            Intrinsics.checkNotNullParameter(rspBytes, "rspBytes");
            try {
                AdvPush.AdvPushRsp advPushRsp = new AdvPush.AdvPushRsp();
                advPushRsp.mergeFrom(rspBytes);
                this.f307991a.a(advPushRsp);
            } catch (Exception e16) {
                this.f307991a.b(VasAdvServiceCode.REQUEST_RSP_PARSE_ERR, "fail to parse rsp:" + e16.getMessage(), e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/vas/adv/base/service/e$h", "Lcom/tencent/mobileqq/vas/adv/base/support/app/d;", "", "returnCode", "", PbProtocolSSoImpl.RESP_KEY_IS_DATA, "", "b", "errorCode", "", "errMsg", "", "e", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class h implements com.tencent.mobileqq.vas.adv.base.support.app.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bz2.b<SplashAd.SplashAdGetRsp> f307992a;

        h(bz2.b<SplashAd.SplashAdGetRsp> bVar) {
            this.f307992a = bVar;
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void a(int errorCode, @NotNull String errMsg, @Nullable Throwable e16) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f307992a.a(errorCode, "request pa ad error:" + errMsg, e16);
        }

        @Override // com.tencent.mobileqq.vas.adv.base.support.app.d
        public void b(int returnCode, @NotNull byte[] rspBytes) {
            Intrinsics.checkNotNullParameter(rspBytes, "rspBytes");
            try {
                SplashAd.SplashAdGetRsp splashAdGetRsp = new SplashAd.SplashAdGetRsp();
                splashAdGetRsp.mergeFrom(rspBytes);
                ((IGdtAPI) QRoute.api(IGdtAPI.class)).updateSplashTab(splashAdGetRsp.preload_switch.get());
                ((IGdtAPI) QRoute.api(IGdtAPI.class)).updateSplashExpIds(splashAdGetRsp.united_exp_ids.get());
                String str = "";
                if (!splashAdGetRsp.ext.isEmpty()) {
                    for (SplashAd.ExpInfo expInfo : splashAdGetRsp.ext.get()) {
                        if (expInfo.key.get().equals("empty_report_new_logic") && expInfo.value.get().equals("1")) {
                            str = expInfo.exp_id.get();
                            Intrinsics.checkNotNullExpressionValue(str, "item.exp_id.get()");
                        }
                    }
                }
                ((IGdtAPI) QRoute.api(IGdtAPI.class)).updateSplashEmptyReportExp(str);
                this.f307992a.b(returnCode, splashAdGetRsp);
            } catch (Exception e16) {
                this.f307992a.a(2002, "fail to parse rsp:" + e16.getMessage(), e16);
            }
        }
    }

    e() {
    }

    private final String h() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final adv_report.MobileAdvReportRsp i(byte[] rspBytes) {
        adv_report.MobileAdvReportRsp mobileAdvReportRsp = new adv_report.MobileAdvReportRsp();
        mobileAdvReportRsp.mergeFrom(rspBytes);
        return mobileAdvReportRsp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final vac_adv_get.VacAdvRsp j(byte[] rspBytes) {
        vac_adv_get.VacAdvRsp vacAdvRsp = new vac_adv_get.VacAdvRsp();
        vacAdvRsp.mergeFrom(rspBytes);
        return vacAdvRsp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends MessageMicro<T>> void k(bz2.a<T> callback, VasAdvServiceCode errCode, String errMsg, Throwable e16) {
        callback.b(errCode, errMsg, e16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(adv_report.MobileAdvReportRsp reportRsp, bz2.a<adv_report.MobileAdvReportRsp> callback) {
        boolean p16 = p(reportRsp);
        if (p16) {
            callback.a(reportRsp);
            return;
        }
        if (!p16) {
            k(callback, VasAdvServiceCode.REPORT_RSP_FAIL, "report rsp ret code:" + reportRsp.ret_code.get(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(vac_adv_get.VacAdvRsp advRsp, bz2.a<vac_adv_get.VacAdvRsp> callback) {
        boolean q16 = q(advRsp);
        if (q16) {
            callback.a(advRsp);
            return;
        }
        if (!q16) {
            k(callback, VasAdvServiceCode.REQUEST_RSP_FAIL, "rsp err code:" + advRsp.err_code.get(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(access.AdGetRsp advRsp, bz2.a<access.AdGetRsp> callback) {
        boolean has = advRsp.qq_ad_get_rsp.has();
        if (has) {
            callback.a(advRsp);
        } else if (!has) {
            VasAdvServiceCode vasAdvServiceCode = VasAdvServiceCode.REQUEST_RSP_FAIL;
            String str = advRsp.ret_msg.err_msg.get();
            Intrinsics.checkNotNullExpressionValue(str, "advRsp.ret_msg.err_msg.get()");
            callback.b(vasAdvServiceCode, str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(access.FeedAdGetRsp feedAdvRsp, bz2.a<access.FeedAdGetRsp> callback) {
        callback.a(feedAdvRsp);
    }

    private final boolean p(adv_report.MobileAdvReportRsp mobileAdvReportRsp) {
        if (mobileAdvReportRsp.ret_code.get() == 0) {
            return true;
        }
        return false;
    }

    private final boolean q(vac_adv_get.VacAdvRsp vacAdvRsp) {
        if (vacAdvRsp.err_code.get() == 0) {
            return true;
        }
        return false;
    }

    private final void z(String cmd, String cmdKey, byte[] reqBytes, com.tencent.mobileqq.vas.adv.base.support.app.d callback) {
        VasAdvSupport.INSTANCE.a().c(cmd, cmdKey, reqBytes, callback);
    }

    public final void r(@NotNull adv_report.MobileAdvReportReq request, @NotNull bz2.a<adv_report.MobileAdvReportRsp> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            byte[] byteArray = request.toByteArray();
            z("MobileAdv.AdvReport", h(), byteArray, new a(callback));
        } catch (Throwable th5) {
            k(callback, VasAdvServiceCode.CREATE_REPORT_ERR, "create report request error, abort report ad", th5);
            QLog.e("VasAdvService", 1, "create report request error, abort report ad", th5);
        }
    }

    public final void s(@NotNull adSchedule$ReportReq request) {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            byte[] byteArray = request.toByteArray();
            z("trpc.apps.preorder.SsoPreorder.SsoReport", h(), byteArray, new b());
        } catch (Throwable th5) {
            QLog.e("VasAdvService", 1, "create reportAdDownloadEvent error, abort reportAdDownloadEvent", th5);
        }
    }

    public final void t(@NotNull VasResultCallback<adSchedule$QueryAllRsp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            byte[] byteArray = new MessageMicro<adSchedule$QueryAllReq>() { // from class: tencent.gdt.adSchedule$QueryAllReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], adSchedule$QueryAllReq.class);
            }.toByteArray();
            z("trpc.apps.preorder.SsoPreorder.SsoQueryAll", h(), byteArray, new c(callback));
        } catch (Throwable th5) {
            QLog.e("VasAdvService", 1, "create reqScheduleAd error, abort reqScheduleAd", th5);
        }
    }

    public final void u(@NotNull vac_adv_get.VacAdvReq request, @NotNull bz2.a<vac_adv_get.VacAdvRsp> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            byte[] byteArray = request.toByteArray();
            z("MobileAdv.AdvGet", h(), byteArray, new d(callback));
        } catch (Throwable th5) {
            k(callback, VasAdvServiceCode.CREATE_REQUEST_ERR, "create request ad error, abort request ad", th5);
            QLog.e("VasAdvService", 1, "create request ad error, abort request ad", th5);
        }
    }

    public final void v(@NotNull access.AdGetReq request, @NotNull bz2.a<access.AdGetRsp> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            byte[] byteArray = request.toByteArray();
            z("trpc.commercial.access.access_sso.SsoAdGet", h(), byteArray, new C8898e(callback));
        } catch (Throwable th5) {
            k(callback, VasAdvServiceCode.CREATE_REQUEST_ERR, "create request ad error, abort request ad", th5);
            QLog.e("VasAdvService", 1, "create request ad error, abort request ad", th5);
        }
    }

    public final void w(@NotNull access.FeedAdGetReq request, @NotNull bz2.a<access.FeedAdGetRsp> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            byte[] byteArray = request.toByteArray();
            z("trpc.commercial.access.access_sso.SsoFeedAdGet", h(), byteArray, new f(callback));
        } catch (Throwable th5) {
            k(callback, VasAdvServiceCode.CREATE_REQUEST_ERR, "create request ad error, abort request ad", th5);
            QLog.e("VasAdvService", 1, "create request ad error, abort request ad", th5);
        }
    }

    public final void x(@NotNull AdvPush.AdvPushReq request, @NotNull bz2.a<AdvPush.AdvPushRsp> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            byte[] byteArray = request.toByteArray();
            z("trpc.sq_adv.official_account_adv_push.OfficialAccountAdvPush.AdvPush", h(), byteArray, new g(callback));
        } catch (Throwable th5) {
            k(callback, VasAdvServiceCode.CREATE_REQUEST_ERR, "create requestPublicAccountAdReq error, abort requestPublicAccountAd", th5);
            QLog.e("VasAdvService", 1, "create requestPublicAccountAdReq error, abort requestPublicAccountAd", th5);
        }
    }

    public final void y(@NotNull String req, @NotNull bz2.b<SplashAd.SplashAdGetRsp> callback) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            SplashAd.SplashAdGetReq splashAdGetReq = new SplashAd.SplashAdGetReq();
            splashAdGetReq.ad_req.set(req);
            splashAdGetReq.client_mod.set(GdtDeviceInfoHelper.getClientMode());
            byte[] byteArray = splashAdGetReq.toByteArray();
            z("trpc.commercial.access.access_sso.SsoSplashAdGet", h(), byteArray, new h(callback));
        } catch (Throwable th5) {
            callback.a(1007, "create requestPublicAccountAdReq error, abort requestPublicAccountAd", th5);
            QLog.e("VasAdvService", 1, "create requestPublicAccountAdReq error, abort requestPublicAccountAd", th5);
        }
    }
}
