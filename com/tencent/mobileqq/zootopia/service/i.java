package com.tencent.mobileqq.zootopia.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.sso.api.IZplanVasProxyServlet;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import e33.RspErrorData;
import e33.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JJ\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000fJB\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0015JH\u0010\u0018\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000fJV\u0010\u001c\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000fJR\u0010\u001e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0015\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/i;", "", "", "errorCode", "", "errorMsg", "", "l", DomainData.DOMAIN_NAME, "Lcom/tencent/common/app/AppInterface;", "app", "", "ownerId", "groupId", "source", "Lkotlin/Function3;", "", "callback", "f", "status", "billNum", "Lkotlin/Function2;", "k", "authType", tl.h.F, ISchemeApi.KEY_GUILD_ID_TYPE, "guildId", "ownerUin", "e", "channelId", "j", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class i {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/i$b", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e33.b {

        /* renamed from: a */
        final /* synthetic */ Function3<Boolean, Boolean, String, Unit> f329238a;

        /* renamed from: b */
        final /* synthetic */ i f329239b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function3<? super Boolean, ? super Boolean, ? super String, Unit> function3, i iVar) {
            this.f329238a = function3;
            this.f329239b = iVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.i("ZootopiaResidenceAuthService", 1, "applyChannelResidenceAuth fail " + errCode + ", " + errMsg);
            this.f329238a.invoke(Boolean.FALSE, Boolean.TRUE, errMsg == null ? "" : errMsg);
            i iVar = this.f329239b;
            int intValue = errCode != null ? errCode.intValue() : -1;
            if (errMsg == null) {
                errMsg = "";
            }
            iVar.l(intValue, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            QLog.i("ZootopiaResidenceAuthService", 1, "applyChannelResidenceAuth success");
            this.f329238a.invoke(Boolean.TRUE, Boolean.FALSE, "success");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/i$c", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements e33.b {

        /* renamed from: a */
        final /* synthetic */ Function3<Boolean, Boolean, String, Unit> f329240a;

        /* renamed from: b */
        final /* synthetic */ i f329241b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function3<? super Boolean, ? super Boolean, ? super String, Unit> function3, i iVar) {
            this.f329240a = function3;
            this.f329241b = iVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.i("ZootopiaResidenceAuthService", 1, "applyResidenceAuth fail " + errCode + ", " + errMsg);
            this.f329240a.invoke(Boolean.FALSE, Boolean.TRUE, errMsg == null ? "" : errMsg);
            i iVar = this.f329241b;
            int intValue = errCode != null ? errCode.intValue() : -1;
            if (errMsg == null) {
                errMsg = "";
            }
            iVar.l(intValue, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            QLog.i("ZootopiaResidenceAuthService", 1, "applyResidenceAuth success");
            this.f329240a.invoke(Boolean.TRUE, Boolean.FALSE, "success");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/i$d", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements e33.b {

        /* renamed from: a */
        final /* synthetic */ Function3<Integer, Integer, String, Unit> f329242a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function3<? super Integer, ? super Integer, ? super String, Unit> function3) {
            this.f329242a = function3;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.i("ZootopiaResidenceAuthService", 1, "applyResidenceAuth fail " + errCode + ", " + errMsg);
            Function3<Integer, Integer, String, Unit> function3 = this.f329242a;
            Integer valueOf = Integer.valueOf(errCode != null ? errCode.intValue() : -1);
            if (errMsg == null) {
                errMsg = "";
            }
            function3.invoke(0, valueOf, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            QLog.i("ZootopiaResidenceAuthService", 1, "getAuthRecordStatus success");
            try {
                this.f329242a.invoke(Integer.valueOf(kw4.e.c(data).f413340a), 0, "");
            } catch (Throwable unused) {
                QLog.e("ZootopiaResidenceAuthService", 1, "getAuthRecordStatus parse data error");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/i$e", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements e33.b {

        /* renamed from: a */
        final /* synthetic */ Function2<Integer, String, Unit> f329243a;

        /* renamed from: b */
        final /* synthetic */ i f329244b;

        /* JADX WARN: Multi-variable type inference failed */
        e(Function2<? super Integer, ? super String, Unit> function2, i iVar) {
            this.f329243a = function2;
            this.f329244b = iVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.i("ZootopiaResidenceAuthService", 1, "makeChannelResidenceAuthDecision fail " + errCode + ", " + errMsg);
            Function2<Integer, String, Unit> function2 = this.f329243a;
            Integer valueOf = Integer.valueOf(errCode != null ? errCode.intValue() : -1);
            if (errMsg == null) {
                errMsg = "";
            }
            function2.invoke(valueOf, errMsg);
            this.f329244b.n(errCode != null ? errCode.intValue() : -1);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            QLog.i("ZootopiaResidenceAuthService", 1, "makeChannelResidenceAuthDecision success");
            this.f329243a.invoke(0, "success");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/i$f", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements e33.b {

        /* renamed from: a */
        final /* synthetic */ Function2<Integer, String, Unit> f329245a;

        /* renamed from: b */
        final /* synthetic */ i f329246b;

        /* JADX WARN: Multi-variable type inference failed */
        f(Function2<? super Integer, ? super String, Unit> function2, i iVar) {
            this.f329245a = function2;
            this.f329246b = iVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.i("ZootopiaResidenceAuthService", 1, "applyResidenceAuth fail " + errCode + ", " + errMsg);
            Function2<Integer, String, Unit> function2 = this.f329245a;
            Integer valueOf = Integer.valueOf(errCode != null ? errCode.intValue() : -1);
            if (errMsg == null) {
                errMsg = "";
            }
            function2.invoke(valueOf, errMsg);
            this.f329246b.n(errCode != null ? errCode.intValue() : -1);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            QLog.i("ZootopiaResidenceAuthService", 1, "makeResidenceAuthDecision success");
            this.f329245a.invoke(0, "success");
        }
    }

    public static final void m(int i3, String errorMsg, int i16) {
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        if (-22606 == i3) {
            QQToastUtil.showQQToast(1, errorMsg);
        } else {
            QQToastUtil.showQQToast(1, i16);
        }
    }

    public final void h(AppInterface app, long j3, int i3, int i16, Function3<? super Integer, ? super Integer, ? super String, Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        kw4.d dVar = new kw4.d();
        dVar.f413338a = j3;
        dVar.f413339b = i3;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(dVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.wo_auth_apply_svr.WoAuthApplySvr", "GetAuthRecordStatus", byteArray, emptyMap, new d(callback), i16);
    }

    public final void k(AppInterface app, int status, long billNum, int source, Function2<? super Integer, ? super String, Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        kw4.f fVar = new kw4.f();
        fVar.f413341a = status;
        fVar.f413342b = billNum;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(fVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.wo_auth_apply_svr.WoAuthApplySvr", "MakeDecision", byteArray, emptyMap, new f(callback, this), source);
    }

    public static final void o(int i3) {
        QQToastUtil.showQQToast(1, i3);
    }

    public final void e(AppInterface app, int r122, long guildId, long ownerUin, int source, Function3<? super Boolean, ? super Boolean, ? super String, Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        kw4.b bVar = new kw4.b();
        ou4.a aVar = new ou4.a();
        aVar.f424104a = r122;
        aVar.f424105b = guildId;
        bVar.f413332a = aVar;
        bVar.f413333b = ownerUin;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(bVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.wo_auth_apply_svr.WoAuthApplySvr", "ChannelApplyVisitWo", byteArray, emptyMap, new b(callback, this), source);
    }

    public final void f(AppInterface app, long ownerId, long groupId, int source, Function3<? super Boolean, ? super Boolean, ? super String, Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        kw4.a aVar = new kw4.a();
        aVar.f413330a = ownerId;
        aVar.f413331b = groupId;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.wo_auth_apply_svr.WoAuthApplySvr", "ApplyWoAuth", byteArray, emptyMap, new c(callback, this), source);
    }

    public final void j(AppInterface app, long guildId, long channelId, int status, long billNum, int source, Function2<? super Integer, ? super String, Unit> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        kw4.c cVar = new kw4.c();
        cVar.f413334a = guildId;
        cVar.f413335b = channelId;
        cVar.f413336c = status;
        cVar.f413337d = billNum;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(cVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.wo_auth_apply_svr.WoAuthApplySvr", "ChannelDecision", byteArray, emptyMap, new e(callback, this), source);
    }

    public static /* synthetic */ void i(i iVar, AppInterface appInterface, long j3, int i3, int i16, Function3 function3, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            i16 = 4;
        }
        iVar.h(appInterface, j3, i3, i16, function3);
    }

    public final void l(final int errorCode, final String errorMsg) {
        final int i3 = errorCode == -22604 ? R.string.xk6 : R.string.xk_;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.service.g
            @Override // java.lang.Runnable
            public final void run() {
                i.m(errorCode, errorMsg, i3);
            }
        });
    }

    public final void n(int i3) {
        final int i16 = i3 == -11056 ? R.string.xka : R.string.xk_;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.service.h
            @Override // java.lang.Runnable
            public final void run() {
                i.o(i16);
            }
        });
    }
}
