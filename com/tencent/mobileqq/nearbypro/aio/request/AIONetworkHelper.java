package com.tencent.mobileqq.nearbypro.aio.request;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.nearbypro.aio.request.AIONetworkHelper;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.nearbypro.request.RspStatus;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.x;
import com.tencent.qqnt.kernel.nativeinterface.IFetchNearbyProUserInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProBytesEntry;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProClientInfo;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProCommonExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProEntry;
import com.tencent.qqnt.kernel.nativeinterface.NearbyProUserInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ5\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004JJ\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022:\b\u0002\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\fJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0011J \u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015J$\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/request/AIONetworkHelper;", "", "", "tinyId", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "token", "", "callBack", "j", "Lkotlin/Function2;", "openID", "", IProfileProtocolConst.PARAM_IS_FRIEND, "p", "", DomainData.DOMAIN_NAME, "tid", "forceUpdate", "Lcom/tencent/mobileqq/nearbypro/aio/request/AIONetworkHelper$a;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "<init>", "()V", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class AIONetworkHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIONetworkHelper f253140a = new AIONetworkHelper();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/request/AIONetworkHelper$a;", "", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/NearbyProUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface a {
        void a(int result, @NotNull String errMsg, @NotNull NearbyProUserInfo userInfo);
    }

    AIONetworkHelper() {
    }

    public static /* synthetic */ void h(AIONetworkHelper aIONetworkHelper, String str, boolean z16, a aVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        aIONetworkHelper.g(str, z16, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(a aVar, int i3, String errMsg, ArrayList cb5) {
        j.c().e("AIONetworkHelper", "fetchNearbyProUserInfo result = " + i3 + " errMsg = " + errMsg);
        if (i3 == 0 && cb5.size() > 0) {
            Intrinsics.checkNotNullExpressionValue(cb5, "cb");
            Iterator it = cb5.iterator();
            while (it.hasNext()) {
                NearbyProUserInfo it5 = (NearbyProUserInfo) it.next();
                if (aVar != null) {
                    Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    aVar.a(i3, errMsg, it5);
                }
            }
            return;
        }
        if (aVar != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            aVar.a(i3, errMsg, new NearbyProUserInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final Function1 function1, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, final fq4.b bVar) {
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        if (rspStatus.c() && bVar != null) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.aio.request.e
                @Override // java.lang.Runnable
                public final void run() {
                    AIONetworkHelper.l(Function1.this, bVar);
                }
            });
            return;
        }
        j.c().d("AIONetworkHelper", "getTempAIOToken rspStatus=" + rspStatus + ", rsp = " + bVar);
        if (!TextUtils.isEmpty(rspStatus.getMsg())) {
            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
            QBaseActivity sTopActivity = QBaseActivity.sTopActivity;
            Intrinsics.checkNotNullExpressionValue(sTopActivity, "sTopActivity");
            String msg2 = rspStatus.getMsg();
            Intrinsics.checkNotNull(msg2);
            commonUtils.showDialog((Context) sTopActivity, msg2, "\u6211\u77e5\u9053\u4e86", (String) null, true, (Function0<Unit>) new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.aio.request.AIONetworkHelper$getTempAIOToken$1$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 function1, fq4.b bVar) {
        if (function1 != null) {
            byte[] bArr = bVar.f400330b;
            Intrinsics.checkNotNullExpressionValue(bArr, "rsp.token");
            function1.invoke(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, fq4.d dVar) {
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        if (rspStatus.c() && dVar != null) {
            j.c().e("AIONetworkHelper", "reportJubao rspStatus=" + rspStatus + ", \u4e0a\u4f20\u6210\u529f");
            return;
        }
        j.c().d("AIONetworkHelper", "reportJubao rspStatus=" + rspStatus + ", rsp = " + dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final Function2 function2, NearbyProBaseRequest nearbyProBaseRequest, RspStatus rspStatus, final hq4.f fVar) {
        Intrinsics.checkNotNullParameter(nearbyProBaseRequest, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(rspStatus, "rspStatus");
        if (rspStatus.c() && fVar != null) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.aio.request.f
                @Override // java.lang.Runnable
                public final void run() {
                    AIONetworkHelper.r(Function2.this, fVar);
                }
            });
            return;
        }
        j.c().d("AIONetworkHelper", "tinyIDToOpenID rspStatus=" + rspStatus + ", rsp = " + fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function2 function2, hq4.f fVar) {
        if (function2 != null) {
            String str = fVar.f405968b;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.dstOpenid");
            function2.invoke(str, Boolean.valueOf(fVar.f405969c));
        }
    }

    public final void g(@NotNull String tid, boolean forceUpdate, @Nullable final a callback) {
        AppInterface appInterface;
        x nearbyProService;
        ArrayList<Long> arrayListOf;
        Intrinsics.checkNotNullParameter(tid, "tid");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IKernelService.class, "");
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null && (nearbyProService = iKernelService.getNearbyProService()) != null) {
            np4.c a16 = com.tencent.mobileqq.nearbypro.request.a.a();
            long m3 = ab2.a.f25767a.m();
            np4.b bVar = a16.f420673a;
            NearbyProCommonExtInfo nearbyProCommonExtInfo = new NearbyProCommonExtInfo(m3, new NearbyProClientInfo(bVar.f420670a, bVar.f420671b, bVar.f420672c), a16.f420674b, new NearbyProEntry(), new NearbyProBytesEntry());
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(Long.parseLong(tid)));
            nearbyProService.fetchNearbyProUserInfo(arrayListOf, nearbyProCommonExtInfo, forceUpdate, new IFetchNearbyProUserInfoCallback() { // from class: com.tencent.mobileqq.nearbypro.aio.request.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchNearbyProUserInfoCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    AIONetworkHelper.i(AIONetworkHelper.a.this, i3, str, arrayList);
                }
            });
        }
    }

    public final void j(@NotNull String tinyId, @Nullable final Function1<? super byte[], Unit> callBack) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        j.e().b(new GetAIOTokenRequest(tinyId), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.aio.request.c
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                AIONetworkHelper.k(Function1.this, (NearbyProBaseRequest) obj, rspStatus, (fq4.b) obj2);
            }
        });
    }

    public final void m(@NotNull String tid, boolean forceUpdate, @NotNull a callback) {
        Intrinsics.checkNotNullParameter(tid, "tid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        NearbyProUserInfo b16 = aa2.a.f25755a.b(Long.parseLong(tid));
        if (b16 != null && !TextUtils.isEmpty(b16.avatarUrl)) {
            callback.a(-1, "\u7f13\u5b58\u5934\u50cf\u4e3a\u7a7a", b16);
        } else {
            g(tid, forceUpdate, callback);
        }
    }

    public final void n(long tinyId) {
        j.e().b(new GetReportRequest(tinyId), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.aio.request.d
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                AIONetworkHelper.o((NearbyProBaseRequest) obj, rspStatus, (fq4.d) obj2);
            }
        });
    }

    public final void p(@NotNull String tinyId, @Nullable final Function2<? super String, ? super Boolean, Unit> callBack) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        j.e().b(new GetOpenIDRequest(tinyId), new com.tencent.mobileqq.nearbypro.request.b() { // from class: com.tencent.mobileqq.nearbypro.aio.request.a
            @Override // com.tencent.mobileqq.nearbypro.request.b
            public final void a(Object obj, RspStatus rspStatus, Object obj2) {
                AIONetworkHelper.q(Function2.this, (NearbyProBaseRequest) obj, rspStatus, (hq4.f) obj2);
            }
        });
    }
}
