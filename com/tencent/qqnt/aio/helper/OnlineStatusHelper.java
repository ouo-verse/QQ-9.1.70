package com.tencent.qqnt.aio.helper;

import android.text.TextUtils;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001b\u0010.\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b#\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/aio/helper/OnlineStatusHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", DomainData.DOMAIN_NAME, tl.h.F, "p", "i", "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "e", "Ljava/lang/String;", "mUin", "", "f", "Z", "mSportSwitch", "Lh43/a;", "Lh43/a;", "mOnDelayLoadGetStepInfoCallback", "mRefreshStepGetStepInfoCallback", "Lcom/tencent/mobileqq/app/ar;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/app/ar;", "onlineStateObserver", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", BdhLogUtil.LogTag.Tag_Conn, "Lhx3/b;", "ntOnlineStatusCallback", "D", "Lkotlin/Lazy;", "()Z", "onlineStatusNTData", "<init>", "()V", "E", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class OnlineStatusHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: C, reason: from kotlin metadata */
    private hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> ntOnlineStatusCallback;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy onlineStatusNTData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private h43.a mOnDelayLoadGetStepInfoCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private h43.a mRefreshStepGetStepInfoCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mSportSwitch = true;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.app.ar onlineStateObserver = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J'\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0014\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"com/tencent/qqnt/aio/helper/OnlineStatusHelper$c", "Lcom/tencent/mobileqq/app/ar;", "", "isSuccess", "", "type", "", "uinOrMobileStr", "Lfriendlist/GetOnlineInfoResp;", "resp", "", "onGetOnlineInfoByUinOrMobile", "", "uin", "onUpdateOnlineFriend", "(Z[Ljava/lang/String;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends com.tencent.mobileqq.app.ar {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onGetOnlineInfoByUinOrMobile(boolean isSuccess, long type, String uinOrMobileStr, GetOnlineInfoResp resp) {
            Intrinsics.checkNotNullParameter(uinOrMobileStr, "uinOrMobileStr");
            Intrinsics.checkNotNullParameter(resp, "resp");
            if (TextUtils.equals(uinOrMobileStr, OnlineStatusHelper.this.mUin)) {
                QLog.d("OnlineStatusHelper", 1, "onGetOnlineInfoByUinOrMobile isSuccess=" + isSuccess);
                OnlineStatusHelper.this.i();
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateOnlineFriend(boolean isSuccess, String[] uin) {
            QLog.d("OnlineStatusHelper", 1, "onUpdateOnlineFriend isSuccess=" + isSuccess);
            OnlineStatusHelper.this.i();
        }
    }

    public OnlineStatusHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.helper.OnlineStatusHelper$onlineStatusNTData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(OnlineStatusToggleUtils.F());
            }
        });
        this.onlineStatusNTData = lazy;
    }

    private final void h() {
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        if (this.ntOnlineStatusCallback != null || (aVar = this.mAIOContext) == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) {
            return;
        }
        b bVar = new b(j3, this);
        ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).addOnlineStatusSimpleInfoCallback(j3, "OnlineStatusHelper", bVar);
        this.ntOnlineStatusCallback = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        if (this.mSportSwitch) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.cr
                @Override // java.lang.Runnable
                public final void run() {
                    OnlineStatusHelper.j(OnlineStatusHelper.this);
                }
            }, 32, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final OnlineStatusHelper this$0) {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid;
        AIOParam g17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null || (onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(j3, "OnlineStatusHelper_checkIsNeedRefreshStep")) == null) {
            return;
        }
        final boolean equals = TextUtils.equals(this$0.mUin, qQAppInterface.getCurrentUin());
        if (((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOldStatus(onlineStatusSimpleInfoWithUid) == AppRuntime.Status.online && onlineStatusSimpleInfoWithUid.e0() == 2017) {
            this$0.mRefreshStepGetStepInfoCallback = new h43.a() { // from class: com.tencent.qqnt.aio.helper.cs
                @Override // h43.a
                public final void a(h43.f fVar) {
                    OnlineStatusHelper.k(equals, this$0, fVar);
                }
            };
            IQQHealthStatusApi iQQHealthStatusApi = (IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class);
            com.tencent.aio.api.runtime.a aVar2 = this$0.mAIOContext;
            iQQHealthStatusApi.getStepInfo((aVar2 == null || (g17 = aVar2.g()) == null) ? null : su3.c.b(g17), Boolean.valueOf(equals), this$0.mRefreshStepGetStepInfoCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(boolean z16, OnlineStatusHelper this$0, h43.f fVar) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IOnlineStatusService iOnlineStatusService = peekAppRuntime != null ? (IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "") : null;
            if (iOnlineStatusService != null) {
                iOnlineStatusService.setStepStatusInfo(fVar);
            }
        } else {
            com.tencent.mobileqq.onlinestatus.utils.ag.f256338a.b(this$0.mUin, fVar);
        }
        com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.h(new AIOTitleEvent.SubTitleRequestEvent(0));
        }
        QLog.i("OnlineStatusHelper", 1, "refreshSubTitle");
    }

    private final boolean m() {
        return ((Boolean) this.onlineStatusNTData.getValue()).booleanValue();
    }

    private final void n() {
        AIOParam g16;
        AIOParam g17;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        String str = null;
        this.mUin = (aVar == null || (g17 = aVar.g()) == null) ? null : su3.c.b(g17);
        if (this.mSportSwitch) {
            this.mOnDelayLoadGetStepInfoCallback = new h43.a() { // from class: com.tencent.qqnt.aio.helper.cq
                @Override // h43.a
                public final void a(h43.f fVar) {
                    OnlineStatusHelper.o(OnlineStatusHelper.this, fVar);
                }
            };
            IQQHealthStatusApi iQQHealthStatusApi = (IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class);
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 != null && (g16 = aVar2.g()) != null) {
                str = su3.c.b(g16);
            }
            iQQHealthStatusApi.getStepInfo(str, Boolean.FALSE, this.mOnDelayLoadGetStepInfoCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(OnlineStatusHelper this$0, h43.f fVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.onlinestatus.utils.ag.f256338a.b(this$0.mUin, fVar);
    }

    private final void p() {
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> bVar = this.ntOnlineStatusCallback;
        if (bVar == null || (aVar = this.mAIOContext) == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) {
            return;
        }
        ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).removeOnlineStatusSimpleInfoCallback(j3, "OnlineStatusHelper", bVar);
        this.ntOnlineStatusCallback = null;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350645j1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "OnlineStatusHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.mAIOContext = param.a();
        this.mSportSwitch = OnlineStatusToggleUtils.A();
        if (m()) {
            h();
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ((QQAppInterface) peekAppRuntime).addObserver(this.onlineStateObserver);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        if (m()) {
            p();
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ((QQAppInterface) peekAppRuntime).removeObserver(this.onlineStateObserver);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/helper/OnlineStatusHelper$b", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f350357a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OnlineStatusHelper f350358b;

        b(String str, OnlineStatusHelper onlineStatusHelper) {
            this.f350357a = str;
            this.f350358b = onlineStatusHelper;
        }

        @Override // hx3.b
        public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> responseData) {
            ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> b16;
            Object orNull;
            if (responseData == null || (b16 = responseData.b()) == null) {
                return;
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(b16, 0);
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar = (com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c) orNull;
            if (cVar != null && Intrinsics.areEqual(cVar.getUid(), this.f350357a)) {
                QLog.d("OnlineStatusHelper", 1, "onNTQueryResult " + this.f350357a);
                this.f350358b.i();
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12, 0, 4};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 4) {
            n();
        } else {
            if (state != 12) {
                return;
            }
            onDestroy();
        }
    }
}
