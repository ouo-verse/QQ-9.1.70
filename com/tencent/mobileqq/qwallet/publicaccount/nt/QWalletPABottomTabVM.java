package com.tencent.mobileqq.qwallet.publicaccount.nt;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.aio.PAInputIntent;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.publicaccount.nt.QWalletPABottomTabState;
import com.tencent.mobileqq.qwallet.publicaccount.nt.QWalletPABottomTabVM;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ll2.a;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u000eH\u0016J&\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0007J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/qwallet/publicaccount/nt/QWalletPABottomTabVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lll2/a;", "Lcom/tencent/mobileqq/qwallet/publicaccount/nt/QWalletPABottomTabState;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/content/Context;", "context", "", "param", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "selectMode", "o", "Lcom/tencent/aio/api/runtime/a;", "onCreate", "listId", "authKey", AppConstants.Key.COLUMN_MSG_SENDER_UIN, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "intent", DomainData.DOMAIN_NAME, "", "d", "J", "uin", "e", "Z", "isQWalletPA", "Lcom/tencent/mvi/base/route/a;", "f", "Lcom/tencent/mvi/base/route/a;", "mAction1", "<init>", "()V", h.F, "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletPABottomTabVM extends com.tencent.aio.base.mvvm.b<a, QWalletPABottomTabState> implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long uin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isQWalletPA;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a mAction1 = new b();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/publicaccount/nt/QWalletPABottomTabVM$b", "Lcom/tencent/mvi/base/route/a;", "", "sticky", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
                QWalletPABottomTabVM.this.o(((AIOMsgListEvent.MultiSelectModeChangeEvent) i3).b());
            } else if (i3 instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
                QWalletPABottomTabVM.this.o(((AIOMsgListEvent.LongShotModeChangeEvent) i3).b());
            } else if (i3 instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
                QWalletPABottomTabVM.this.o(((FullScreenMsgIntent.OnFullScreenModeChanged) i3).a());
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void o(boolean selectMode) {
        updateUI(new QWalletPABottomTabState.ChangeTabVisibilityState(!selectMode));
        if (selectMode) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PAInputIntent.InputContainerVisibleIntent(0));
        } else {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PAInputIntent.InputContainerVisibleIntent(8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(com.tencent.aio.api.runtime.a context, QWalletPABottomTabVM this$0, String str, String str2, String params) {
        Context context2;
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QWalletPABottomTabVM", 1, "notify: appName " + str + ", eventName " + str2 + ", params " + params);
        if (Intrinsics.areEqual(str2, "GrapRedPack") && (context2 = context.c().getContext()) != null) {
            Intrinsics.checkNotNullExpressionValue(params, "params");
            this$0.q(context2, params);
        }
        return Intrinsics.areEqual("com.tencent.qianbao", str);
    }

    private final void q(Context context, String param) {
        JSONObject jSONObject = new JSONObject(param);
        String listId = jSONObject.optString("billno");
        String authKey = jSONObject.optString("authkey");
        Intrinsics.checkNotNullExpressionValue(listId, "listId");
        Intrinsics.checkNotNullExpressionValue(authKey, "authKey");
        m(context, listId, authKey, String.valueOf(this.uin));
    }

    public final void m(@NotNull Context context, @NotNull String listId, @NotNull String authKey, @NotNull String senderUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listId, "listId");
        Intrinsics.checkNotNullParameter(authKey, "authKey");
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        String c16 = com.tencent.mobileqq.base.a.c();
        String b16 = com.tencent.mobileqq.base.a.b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("listid", listId);
        jSONObject.put("authkey", authKey);
        jSONObject.put("name", b16);
        jSONObject.put("groupuin", senderUin);
        jSONObject.put("grouptype", 0);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(WadlProxyConsts.CHANNEL, 2);
        Unit unit = Unit.INSTANCE;
        jSONObject.put("detailinfo", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("userId", c16);
        jSONObject3.put(HippyHeaderListViewController.VIEW_TAG, "graphb");
        jSONObject3.put(j.T0, "appid#1344242394|bargainor_id#1000030201|channel#msg");
        jSONObject3.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 2);
        jSONObject3.put("extra_data", jSONObject.toString());
        jSONObject3.put("senderuin", senderUin);
        Intent intent = new Intent();
        intent.putExtra("callbackSn", "0");
        intent.putExtra(ark.ARKMETADATA_JSON, jSONObject3.toString());
        intent.putExtra("pay_requestcode", 5);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTER_PAY_BRIDGE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C10731a) {
            if (this.isQWalletPA) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PAInputIntent.InputContainerVisibleIntent(8));
                return;
            }
            return;
        }
        super.handleIntent(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.qianbao", null);
        if (this.isQWalletPA) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction1);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.LongShotModeChangeEvent.class).getQualifiedName(), this.mAction1);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class).getQualifiedName(), this.mAction1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.isQWalletPA) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PAInputIntent.InputContainerVisibleIntent(8));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        context.d().getLifecycle().addObserver(this);
        long j3 = context.g().l().getLong("key_peerUin", 0L);
        this.uin = j3;
        boolean areEqual = Intrinsics.areEqual(IPublicAccountUtil.UIN_FOR_WALLET, String.valueOf(j3));
        this.isQWalletPA = areEqual;
        updateUI(new QWalletPABottomTabState.ChangeTabVisibilityState(areEqual));
        if (this.isQWalletPA) {
            updateUI(QWalletPABottomTabState.HidePAMenuState.f279144d);
            context.e().h(new PAInputIntent.InputContainerVisibleIntent(8));
            ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification("com.tencent.qianbao", new g() { // from class: ll2.c
                @Override // com.tencent.mobileqq.ark.module.g
                public final boolean notify(String str, String str2, String str3) {
                    boolean p16;
                    p16 = QWalletPABottomTabVM.p(com.tencent.aio.api.runtime.a.this, this, str, str2, str3);
                    return p16;
                }
            });
        }
        if (Intrinsics.areEqual(IPublicAccountUtil.UIN_FOR_SHOP, String.valueOf(this.uin))) {
            ((IEcshopReportApi) QRoute.api(IEcshopReportApi.class)).doReportBeacon("pa_msg_page_show", new HashMap<>());
        }
        if (this.isQWalletPA) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction1);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.LongShotModeChangeEvent.class).getQualifiedName(), this.mAction1);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class).getQualifiedName(), this.mAction1);
        }
    }
}
