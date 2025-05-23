package com.tencent.mobileqq.zootopia.service;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.zootopia.ipc.ab;
import com.tencent.mobileqq.zootopia.ipc.ac;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import zb3.ZootopiaRankConfigData;
import zb3.ZootopiaRankHeadNickData;
import zb3.ZootopiaRankShowInfo;
import zb3.ZootopiaUserRankData;
import zb3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 .2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010+\u001a\u00020\u0005\u00a2\u0006\u0004\b,\u0010-J6\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J*\u0010\u0010\u001a\u00020\u000b2\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002JF\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0002H\u0002JR\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0016\u0010$\u001a\u0004\u0018\u00010#2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J4\u0010%\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J(\u0010&\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0002R\u0017\u0010+\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/f;", "", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzb3/k;", "callback", "", "mapId", "rankId", "showSwitch", "", "clientKey", "", "p", "", "Lzb3/l;", "openIdList", "o", "openId", CommonConstant.KEY_ACCESS_TOKEN, "", "refreshToken", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lev4/b;", "rsp", "r", "Lev4/h;", "it", "Lev4/e;", "conf", "self", "Lzb3/p;", ReportConstant.COSTREPORT_PREFIX, "Lzb3/j;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/app/QQAppInterface;", tl.h.F, "l", "j", "a", "I", "getSource", "()I", "source", "<init>", "(I)V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int source;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/f$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<List<ZootopiaRankHeadNickData>> f329204a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f329205b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f329206c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<String> f329207d;

        b(com.tencent.mobileqq.zootopia.api.e<List<ZootopiaRankHeadNickData>> eVar, boolean z16, f fVar, List<String> list) {
            this.f329204a = eVar;
            this.f329205b = z16;
            this.f329206c = fVar;
            this.f329207d = list;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaMapRankService", 1, "loadNickAndHead errCode:" + errCode + ", errMsg:" + errMsg);
            if (errCode != null && errCode.intValue() == -23 && this.f329205b) {
                this.f329206c.o(this.f329204a, this.f329207d);
            } else {
                this.f329204a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
            }
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            ev4.d c16 = ev4.d.c(data);
            QLog.i("ZootopiaMapRankService", 1, "loadNickAndHead rsp.size:" + c16.f397217a.length);
            ev4.g[] gVarArr = c16.f397217a;
            Intrinsics.checkNotNullExpressionValue(gVarArr, "rsp.userInfoList");
            ArrayList arrayList = new ArrayList(gVarArr.length);
            for (ev4.g gVar : gVarArr) {
                String str = gVar.f397239b;
                Intrinsics.checkNotNullExpressionValue(str, "it.nick");
                String str2 = gVar.f397240c;
                Intrinsics.checkNotNullExpressionValue(str2, "it.headUrl");
                String str3 = gVar.f397238a;
                Intrinsics.checkNotNullExpressionValue(str3, "it.openid");
                arrayList.add(new ZootopiaRankHeadNickData(str, str2, str3));
            }
            this.f329204a.onResultSuccess(arrayList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/f$e", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements td3.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<k> f329218b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f329219c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f329220d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f329221e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f329222f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f329223g;

        e(com.tencent.mobileqq.zootopia.api.e<k> eVar, int i3, int i16, boolean z16, int i17, String str) {
            this.f329218b = eVar;
            this.f329219c = i3;
            this.f329220d = i16;
            this.f329221e = z16;
            this.f329222f = i17;
            this.f329223g = str;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaMapRankService", 1, "loadRank mapId:" + this.f329219c + ", rankId:" + this.f329220d + " -- errCode:" + errCode + ", errMsg:" + errMsg);
            if (errCode != null && errCode.intValue() == -23 && this.f329221e) {
                f.this.p(this.f329218b, this.f329219c, this.f329220d, this.f329222f, this.f329223g);
            } else {
                this.f329218b.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
            }
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            try {
                k r16 = f.this.r(ev4.b.c(data));
                if (r16 != null) {
                    this.f329218b.onResultSuccess(r16);
                } else {
                    this.f329218b.onResultFailure(-2, "zootopiaRankData merge fail");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaMapRankService", 1, "loadRank throw e:" + e16.getMessage());
            }
        }
    }

    public f(int i3) {
        this.source = i3;
    }

    private final QQAppInterface h(com.tencent.mobileqq.zootopia.api.e<?> callback) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        boolean z16 = waitAppRuntime instanceof QQAppInterface;
        if (!z16) {
            callback.onResultFailure(-2, "\u83b7\u53d6app\u5f02\u5e38");
        }
        if (z16) {
            return (QQAppInterface) waitAppRuntime;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(com.tencent.mobileqq.zootopia.api.e callback, f this$0, List openIdList) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(openIdList, "$openIdList");
        ((ac) k74.i.INSTANCE.a(ac.class)).getOpenIdInfoSilent(new c(callback, this$0, openIdList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(com.tencent.mobileqq.zootopia.api.e callback, f this$0, int i3, int i16, int i17, String clientKey) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clientKey, "$clientKey");
        ((ac) k74.i.INSTANCE.a(ac.class)).getOpenIdInfoSilent(new d(callback, this$0, i3, i16, i17, clientKey));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(com.tencent.mobileqq.zootopia.api.e<List<ZootopiaRankHeadNickData>> callback, List<String> openIdList) {
        ((ac) k74.i.INSTANCE.a(ac.class)).reAuthOpenIdSilent(new C9124f(callback, this, openIdList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(com.tencent.mobileqq.zootopia.api.e<k> callback, int mapId, int rankId, int showSwitch, String clientKey) {
        ((ac) k74.i.INSTANCE.a(ac.class)).reAuthOpenIdSilent(new g(callback, this, mapId, rankId, showSwitch, clientKey));
    }

    private final ZootopiaUserRankData s(ev4.h it, ev4.e conf, ev4.h self) {
        ZootopiaRankHeadNickData zootopiaRankHeadNickData;
        ZootopiaRankHeadNickData zootopiaRankHeadNickData2;
        int i3 = it.f397242a;
        String score = it.f397245d;
        String openid = it.f397246e;
        String rankTableSortSuffix = conf.f397224f;
        int i16 = self.f397242a;
        boolean z16 = i3 == i16;
        if (i3 == i16) {
            String str = self.f397244c;
            Intrinsics.checkNotNullExpressionValue(str, "self.nick");
            String str2 = self.f397243b;
            Intrinsics.checkNotNullExpressionValue(str2, "self.headUrl");
            String str3 = self.f397246e;
            Intrinsics.checkNotNullExpressionValue(str3, "self.openid");
            zootopiaRankHeadNickData = new ZootopiaRankHeadNickData(str, str2, str3);
        } else {
            if (!TextUtils.isEmpty(it.f397243b)) {
                String str4 = it.f397244c;
                Intrinsics.checkNotNullExpressionValue(str4, "it.nick");
                String str5 = it.f397243b;
                Intrinsics.checkNotNullExpressionValue(str5, "it.headUrl");
                String str6 = it.f397246e;
                Intrinsics.checkNotNullExpressionValue(str6, "it.openid");
                zootopiaRankHeadNickData2 = new ZootopiaRankHeadNickData(str4, str5, str6);
                Intrinsics.checkNotNullExpressionValue(score, "score");
                Intrinsics.checkNotNullExpressionValue(rankTableSortSuffix, "rankTableSortSuffix");
                Intrinsics.checkNotNullExpressionValue(openid, "openid");
                return new ZootopiaUserRankData(i3, score, rankTableSortSuffix, z16, openid, zootopiaRankHeadNickData2);
            }
            zootopiaRankHeadNickData = null;
        }
        zootopiaRankHeadNickData2 = zootopiaRankHeadNickData;
        Intrinsics.checkNotNullExpressionValue(score, "score");
        Intrinsics.checkNotNullExpressionValue(rankTableSortSuffix, "rankTableSortSuffix");
        Intrinsics.checkNotNullExpressionValue(openid, "openid");
        return new ZootopiaUserRankData(i3, score, rankTableSortSuffix, z16, openid, zootopiaRankHeadNickData2);
    }

    public final void j(final List<String> openIdList, final com.tencent.mobileqq.zootopia.api.e<List<ZootopiaRankHeadNickData>> callback) {
        Intrinsics.checkNotNullParameter(openIdList, "openIdList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.service.d
            @Override // java.lang.Runnable
            public final void run() {
                f.k(com.tencent.mobileqq.zootopia.api.e.this, this, openIdList);
            }
        });
    }

    public final void l(final int mapId, final int rankId, final int showSwitch, final String clientKey, final com.tencent.mobileqq.zootopia.api.e<k> callback) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.service.e
            @Override // java.lang.Runnable
            public final void run() {
                f.n(com.tencent.mobileqq.zootopia.api.e.this, this, mapId, rankId, showSwitch, clientKey);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/f$c", "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements ab {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<List<ZootopiaRankHeadNickData>> f329208a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f329209b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f329210c;

        c(com.tencent.mobileqq.zootopia.api.e<List<ZootopiaRankHeadNickData>> eVar, f fVar, List<String> list) {
            this.f329208a = eVar;
            this.f329209b = fVar;
            this.f329210c = list;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void b(int errCode, String errMsg) {
            this.f329209b.o(this.f329208a, this.f329210c);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void c() {
            this.f329208a.onResultFailure(-2, "onReAuthorization");
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void a(ZootopiaOpenIdResult result) {
            if (result != null) {
                this.f329209b.i(result.getOpenId(), result.getAccessToken(), this.f329210c, true, this.f329208a);
            } else {
                this.f329208a.onResultFailure(-999, "empty onOpenIdResult");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/f$d", "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements ab {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<k> f329211a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f329212b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f329213c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f329214d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f329215e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f329216f;

        d(com.tencent.mobileqq.zootopia.api.e<k> eVar, f fVar, int i3, int i16, int i17, String str) {
            this.f329211a = eVar;
            this.f329212b = fVar;
            this.f329213c = i3;
            this.f329214d = i16;
            this.f329215e = i17;
            this.f329216f = str;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void b(int errCode, String errMsg) {
            this.f329212b.p(this.f329211a, this.f329213c, this.f329214d, this.f329215e, this.f329216f);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void c() {
            this.f329211a.onResultFailure(-2, "onReAuthorization");
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void a(ZootopiaOpenIdResult result) {
            if (result != null) {
                this.f329212b.m(this.f329213c, this.f329214d, this.f329215e, this.f329216f, result.getOpenId(), result.getAccessToken(), true, this.f329211a);
            } else {
                this.f329211a.onResultFailure(-999, "empty onOpenIdResult");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/f$f", "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.service.f$f, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9124f implements ab {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<List<ZootopiaRankHeadNickData>> f329224a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f329225b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f329226c;

        C9124f(com.tencent.mobileqq.zootopia.api.e<List<ZootopiaRankHeadNickData>> eVar, f fVar, List<String> list) {
            this.f329224a = eVar;
            this.f329225b = fVar;
            this.f329226c = list;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void b(int errCode, String errMsg) {
            this.f329224a.onResultFailure(-2, "onOpenIdError");
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void a(ZootopiaOpenIdResult result) {
            if (result != null) {
                this.f329225b.i(result.getOpenId(), result.getAccessToken(), this.f329226c, false, this.f329224a);
            } else {
                this.f329224a.onResultFailure(-999, "empty onOpenIdResult");
            }
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void c() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/f$g", "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements ab {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<k> f329227a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f329228b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f329229c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f329230d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f329231e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f329232f;

        g(com.tencent.mobileqq.zootopia.api.e<k> eVar, f fVar, int i3, int i16, int i17, String str) {
            this.f329227a = eVar;
            this.f329228b = fVar;
            this.f329229c = i3;
            this.f329230d = i16;
            this.f329231e = i17;
            this.f329232f = str;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void b(int errCode, String errMsg) {
            this.f329227a.onResultFailure(-2, "onOpenIdError");
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void a(ZootopiaOpenIdResult result) {
            if (result != null) {
                this.f329228b.m(this.f329229c, this.f329230d, this.f329231e, this.f329232f, result.getOpenId(), result.getAccessToken(), false, this.f329227a);
            } else {
                this.f329227a.onResultFailure(-999, "empty onOpenIdResult");
            }
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void c() {
        }
    }

    private final ZootopiaRankConfigData q(ev4.e it) {
        ev4.f[] fVarArr = it.f397231m;
        Intrinsics.checkNotNullExpressionValue(fVarArr, "it.showInfoList");
        ArrayList arrayList = new ArrayList(fVarArr.length);
        for (ev4.f fVar : fVarArr) {
            int i3 = fVar.f397233a;
            int i16 = fVar.f397234b;
            String str = fVar.f397235c;
            Intrinsics.checkNotNullExpressionValue(str, "it.showName");
            arrayList.add(new ZootopiaRankShowInfo(i3, i16, str, fVar.f397236d));
        }
        int i17 = it.f397219a;
        int i18 = it.f397220b;
        String str2 = it.f397221c;
        Intrinsics.checkNotNullExpressionValue(str2, "it.rankTable");
        String str3 = it.f397222d;
        Intrinsics.checkNotNullExpressionValue(str3, "it.rankTableSort");
        String str4 = it.f397223e;
        Intrinsics.checkNotNullExpressionValue(str4, "it.rankTableSortPrefix");
        String str5 = it.f397224f;
        Intrinsics.checkNotNullExpressionValue(str5, "it.rankTableSortSuffix");
        int i19 = it.f397225g;
        String str6 = it.f397226h;
        Intrinsics.checkNotNullExpressionValue(str6, "it.rankTimeOpen");
        String str7 = it.f397227i;
        Intrinsics.checkNotNullExpressionValue(str7, "it.rankTimeClose");
        String str8 = it.f397228j;
        Intrinsics.checkNotNullExpressionValue(str8, "it.rankHelpDesc");
        int i26 = it.f397229k;
        String str9 = it.f397230l;
        Intrinsics.checkNotNullExpressionValue(str9, "it.rankIcon");
        return new ZootopiaRankConfigData(i17, i18, str2, str3, str4, str5, i19, str6, str7, str8, i26, str9, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k r(ev4.b rsp) {
        if (rsp == null) {
            return null;
        }
        ev4.e[] eVarArr = rsp.f397208b;
        Intrinsics.checkNotNullExpressionValue(eVarArr, "rsp.rankConfLsit");
        ArrayList arrayList = new ArrayList(eVarArr.length);
        for (ev4.e it : eVarArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(q(it));
        }
        ev4.h[] hVarArr = rsp.f397210d;
        Intrinsics.checkNotNullExpressionValue(hVarArr, "rsp.userRankDataList");
        ArrayList arrayList2 = new ArrayList(hVarArr.length);
        for (ev4.h it5 : hVarArr) {
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            ev4.e eVar = rsp.f397207a;
            Intrinsics.checkNotNullExpressionValue(eVar, "rsp.rankConf");
            ev4.h hVar = rsp.f397209c;
            Intrinsics.checkNotNullExpressionValue(hVar, "rsp.selfRankData");
            arrayList2.add(s(it5, eVar, hVar));
        }
        ev4.e eVar2 = rsp.f397207a;
        Intrinsics.checkNotNullExpressionValue(eVar2, "rsp.rankConf");
        ZootopiaRankConfigData q16 = q(eVar2);
        ev4.h hVar2 = rsp.f397209c;
        Intrinsics.checkNotNullExpressionValue(hVar2, "rsp.selfRankData");
        ev4.e eVar3 = rsp.f397207a;
        Intrinsics.checkNotNullExpressionValue(eVar3, "rsp.rankConf");
        ev4.h hVar3 = rsp.f397209c;
        Intrinsics.checkNotNullExpressionValue(hVar3, "rsp.selfRankData");
        ZootopiaUserRankData s16 = s(hVar2, eVar3, hVar3);
        int i3 = rsp.f397211e;
        String str = rsp.f397212f;
        Intrinsics.checkNotNullExpressionValue(str, "rsp.serverKey");
        return new k(q16, arrayList, s16, arrayList2, i3, str, rsp.f397213g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String openId, String accessToken, List<String> openIdList, boolean refreshToken, com.tencent.mobileqq.zootopia.api.e<List<ZootopiaRankHeadNickData>> callback) {
        Map emptyMap;
        QQAppInterface h16 = h(callback);
        if (h16 == null) {
            return;
        }
        ev4.c cVar = new ev4.c();
        Object[] array = openIdList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        cVar.f397216c = (String[]) array;
        cVar.f397214a = openId;
        cVar.f397215b = accessToken;
        QLog.i("ZootopiaMapRankService", 1, "loadNickAndHead openIdList.size:" + openIdList.size());
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(cVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, h16, "trpc.metaverse.rank_server.RankServer", "GetUserNickAndHeadUrl", byteArray, emptyMap, new b(callback, refreshToken, this, openIdList), 0, 0, 192, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int mapId, int rankId, int showSwitch, String clientKey, String openId, String accessToken, boolean refreshToken, com.tencent.mobileqq.zootopia.api.e<k> callback) {
        Map emptyMap;
        QQAppInterface h16 = h(callback);
        if (h16 == null) {
            return;
        }
        ev4.a aVar = new ev4.a();
        aVar.f397201a = mapId;
        aVar.f397202b = rankId;
        aVar.f397203c = showSwitch;
        aVar.f397206f = clientKey;
        aVar.f397204d = openId;
        aVar.f397205e = accessToken;
        QLog.i("ZootopiaMapRankService", 1, "loadRank mapId:" + mapId + ", rankId:" + rankId + " -- showSwitch:" + showSwitch);
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, h16, "trpc.metaverse.rank_server.RankServer", "GetRankInfo", byteArray, emptyMap, new e(callback, mapId, rankId, refreshToken, showSwitch, clientKey), this.source, 0, 128, null);
    }
}
