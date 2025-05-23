package com.tencent.mobileqq.qwallet.api.impl;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import com.qwallet.activity.MidasPayBridgeFragment;
import com.qwallet.activity.QvipPayFullWindowActivity;
import com.qwallet.data.PayPucAccManager;
import com.qwallet.pay.PayLogicFactory;
import com.qwallet.pay.b;
import com.qwallet.pay.r;
import com.qwallet.pay.s;
import com.qwallet.temp.IQWalletPBTemp;
import com.qwallet.utils.QWalletUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.IAPMidasNetCallBack;
import com.tencent.midas.api.request.APMidasAccountRequest;
import com.tencent.mobileqq.QWalletAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.data.QWalletGoldMsgTipsElem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.e;
import com.tencent.mobileqq.qwallet.h5.QWalletH5Fragment;
import com.tencent.mobileqq.qwallet.home.u;
import com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin;
import com.tencent.mobileqq.qwallet.pet.QWalletPetFragment;
import com.tencent.mobileqq.qwallet.pet.download.PetDownloadManager;
import com.tencent.mobileqq.qwallet.pet.fragment.HalfWebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qwallet.aio.AIOContextHolder;
import com.tencent.qqnt.qwallet.db.HbStateEntity;
import com.tencent.qqnt.qwallet.db.QWalletDBManager;
import com.tencent.qqnt.qwallet.unclaimed.UnclaimedDialogFragment;
import com.tenpay.api.TenpayInterface;
import com.tenpay.idverify.IdVerifyEntryFragment;
import com.tenpay.idverify.IdVerifyModule;
import com.tenpay.pay.PayModule;
import com.tenpay.payment.qrcodehb.QrCodeHbFragment;
import com.tenpay.payment.qrcodehb.QrCodeHbManager;
import com.tenpay.payment.transfer.PayTransferFragment;
import com.tenpay.realname.RealNameSource;
import com.tenpay.sdk.activity.ChoosePayChannelFragment;
import com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler;
import com.tenpay.sdk.util.HongBaoStateHelper;
import cooperation.qwallet.plugin.QWalletToolFragmentActivity;
import cooperation.qwallet.plugin.QWalletToolService;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import tk2.GoldMsgTipsElemBean;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0012\n\u0002\b\u000e\u0018\u0000 d2\u00020\u0001:\u0001eB\u0007\u00a2\u0006\u0004\bb\u0010cJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0016J<\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010!\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\rH\u0016J\u0010\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0\u0006H\u0016J$\u0010*\u001a\u00020\t2\u0006\u0010'\u001a\u00020&2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0(H\u0016J\b\u0010,\u001a\u00020+H\u0016J\u001c\u00100\u001a\u00020/2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u001c\u00101\u001a\u00020/2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J&\u00102\u001a\u00020/2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J4\u00106\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020\u00022\"\u00105\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r03j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`4H\u0016J4\u00107\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020\u00022\"\u00105\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r03j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`4H\u0016J\b\u00109\u001a\u000208H\u0016J\u001c\u0010;\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010:\u001a\u0004\u0018\u00010\rH\u0016J(\u0010?\u001a\u00020\t2\u0006\u0010'\u001a\u00020<2\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010@\u001a\u00020\rH\u0016J:\u0010G\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020\u0010H\u0016J\u0010\u0010J\u001a\u00020I2\u0006\u0010H\u001a\u00020\rH\u0016J\u0010\u0010M\u001a\u00020\t2\u0006\u0010L\u001a\u00020KH\u0016J\u0012\u0010O\u001a\u00020\t2\b\u0010N\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010P\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010S\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020/H\u0016J\u0010\u0010T\u001a\u00020/2\u0006\u0010Q\u001a\u00020\rH\u0016J \u0010W\u001a\u00020\r2\u0006\u0010U\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010V\u001a\u00020\u0010H\u0016J\u0010\u0010Z\u001a\u00020\t2\u0006\u0010Y\u001a\u00020XH\u0016J\u0010\u0010\\\u001a\u00020\r2\u0006\u0010[\u001a\u00020\rH\u0016J$\u0010]\u001a\u00020\t2\u0006\u0010[\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0(H\u0016J\u0018\u0010_\u001a\u00020\t2\u0006\u0010[\u001a\u00020\r2\u0006\u0010^\u001a\u00020/H\u0016J(\u0010`\u001a\u00020I2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010a\u001a\u00020\rH\u0016\u00a8\u0006f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/impl/NewQWalletApiImpl;", "Lcom/tencent/mobileqq/qwallet/api/INewQWalletApi;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "clazz", "", "launchFragment", "Lcom/tencent/mobileqq/app/QBaseFragment;", "qWalletFragment", "", "url", "openUrl", "", WadlProxyConsts.CHANNEL, "launchHomeFragment", "launchQVipPayBridgeFragment", "Lmqq/app/MobileQQ;", "app", "processName", "Lmqq/app/AppRuntime;", "createQWalletAppInterface", "tag", "uin", "", "reqMap", "Landroid/os/ResultReceiver;", "callback", WebViewPlugin.KEY_REQUEST, "crashInfo", "reportCrash", "appIdStr", "hexGuid", "Landroid/app/Service;", "getQWalletToolServiceClass", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function1;", "receiver", "queryQbData", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "getQWalletJSPlugin", "Landroid/os/Bundle;", "bundle", "", "isFromQWalletPage", "isFromHalfWebPage", "shouldInterceptQQBrowserDelegationActivity", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "attrMap", "parseJumpQWalletPetAction", "parseJumpIdVerifyEntryAction", "Lcom/tencent/qqnt/graytips/handler/c;", "getGrayTipActionHandler", QZoneDTLoginReporter.SCHEMA, "handleFakeUrl", "Lcom/tencent/mobileqq/app/QBaseActivity;", "appId", "appType", "startPreLogin", "getFinancialPetStoragePath", "Lorg/json/JSONArray;", "payChannels", "tokenId", "comeFrom", "sourceId", "requestCode", "startHbPay", "troopId", "Landroidx/fragment/app/DialogFragment;", "startUnclaimed", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "bindAioContext", QrCodeHbFragment.KEY_IN_QR_TOKEN, "saveQrCodeHbToken", "launchPayTransferPage", IPublicAccountBrowser.KEY_PUB_UIN, "isFollow", "ipcFollowUin", "ipcIsFollowUin", "faceType", "idType", "ipcGetFaceFilePath", "", "pushData", "pushBy0x210Sub0x66", "listId", "getHbStateText", "getHbStateAsync", "isSelf", "updateStateByGrayBar", "createPayChannelDialog", PanoramaConfig.KEY_CURRENT_UIN, "<init>", "()V", "Companion", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class NewQWalletApiImpl implements INewQWalletApi {

    @NotNull
    private static final String MIDAS_OFFER_ID_QVIP = "1450000515";

    @NotNull
    private static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";

    @NotNull
    private static final String TAG = "NewQWalletApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindAioContext$lambda$4(com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "$aioContext");
        AIOContextHolder.f361707d.a(aioContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHbStateAsync$lambda$5(String listId, Function1 callback) {
        String str;
        Intrinsics.checkNotNullParameter(listId, "$listId");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        HbStateEntity y16 = QWalletDBManager.f361825a.y(listId, com.tencent.mobileqq.base.a.c());
        if (y16 == null || (str = y16.getText()) == null) {
            str = "";
        }
        callback.invoke(str);
    }

    private final void launchFragment(Context context, Intent intent, Class<? extends QWalletBaseFragment> clazz) {
        com.tencent.mobileqq.base.c.f(context, intent, clazz, false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchQVipPayBridgeFragment$lambda$0(Context context) {
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.setResult(-1);
        }
        QLog.d(TAG, 1, "onFinishPay: ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryQbData$lambda$2(final Activity activity, final Function1 receiver) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        com.tencent.mobileqq.qwallet.e.c(false, null, new e.a() { // from class: com.tencent.mobileqq.qwallet.api.impl.NewQWalletApiImpl$queryQbData$1$1
            @Override // com.tencent.mobileqq.qwallet.e.a
            public void onFinish(int code, @Nullable String errMsg, @Nullable String pskey) {
                QLog.i("NewQWalletApiImpl", 1, "getPsKey finish: " + pskey);
                final APMidasAccountRequest aPMidasAccountRequest = new APMidasAccountRequest();
                aPMidasAccountRequest.setOfferId("1450000515");
                aPMidasAccountRequest.setOpenId(com.tencent.mobileqq.base.a.c());
                aPMidasAccountRequest.setOpenKey(pskey);
                aPMidasAccountRequest.setSessionId("uin");
                aPMidasAccountRequest.setSessionType("pskey_120");
                aPMidasAccountRequest.setPf("qq_m_qq-2013-android-537035451-mvip.pingtai.mobileqq.mywallet.00001");
                aPMidasAccountRequest.setPfKey("pfKey");
                aPMidasAccountRequest.setBalanceType("qqacct_balance");
                aPMidasAccountRequest.setBalanceExtras("");
                Activity activity2 = activity;
                boolean o16 = r.o();
                final Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final Activity activity3 = activity;
                final Function1<String, Unit> function1 = receiver;
                QWalletUtils.m(activity2, aPMidasAccountRequest, o16, new ResultReceiver(uIHandlerV2) { // from class: com.tencent.mobileqq.qwallet.api.impl.NewQWalletApiImpl$queryQbData$1$1$onFinish$1

                    /* compiled from: P */
                    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qwallet/api/impl/NewQWalletApiImpl$queryQbData$1$1$onFinish$1$a", "Lcom/tencent/midas/api/IAPMidasNetCallBack;", "", "reqType", "", "MidasNetStop", "result", "MidasNetFinish", "", QzoneIPCModule.RESULT_CODE, "resultMsg", "MidasNetError", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
                    /* loaded from: classes16.dex */
                    public static final class a implements IAPMidasNetCallBack {

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ Function1<String, Unit> f277098a;

                        /* JADX WARN: Multi-variable type inference failed */
                        a(Function1<? super String, Unit> function1) {
                            this.f277098a = function1;
                        }

                        @Override // com.tencent.midas.api.IAPMidasNetCallBack
                        public void MidasNetError(@Nullable String reqType, int resultCode, @Nullable String resultMsg) {
                            QLog.i("NewQWalletApiImpl", 1, "queryQbData onError");
                        }

                        @Override // com.tencent.midas.api.IAPMidasNetCallBack
                        public void MidasNetFinish(@Nullable String reqType, @Nullable String result) {
                            if (QLog.isColorLevel()) {
                                QLog.i("NewQWalletApiImpl", 2, "queryQbData onFinish");
                            }
                            if (result != null) {
                                this.f277098a.invoke(result);
                            }
                        }

                        @Override // com.tencent.midas.api.IAPMidasNetCallBack
                        public void MidasNetStop(@Nullable String reqType) {
                            if (QLog.isColorLevel()) {
                                QLog.i("NewQWalletApiImpl", 1, "queryQbData onStop");
                            }
                        }
                    }

                    @Override // android.os.ResultReceiver
                    protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                        QLog.i("NewQWalletApiImpl", 1, "queryQbData");
                        APMidasPayAPI.getInfo(activity3, APMidasAccountRequest.NET_REQ_ACCOUNT, aPMidasAccountRequest, new a(function1));
                    }
                });
            }
        }, 3, null);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    @NotNull
    public String appIdStr() {
        return com.tencent.mobileqq.base.b.b();
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void bindAioContext(@NotNull final com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            AIOContextHolder.f361707d.a(aioContext);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    NewQWalletApiImpl.bindAioContext$lambda$4(com.tencent.aio.api.runtime.a.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    @NotNull
    public DialogFragment createPayChannelDialog(@NotNull JSONArray payChannels, @NotNull String tokenId, @NotNull String comeFrom, @NotNull ResultReceiver callback) {
        Intrinsics.checkNotNullParameter(payChannels, "payChannels");
        Intrinsics.checkNotNullParameter(tokenId, "tokenId");
        Intrinsics.checkNotNullParameter(comeFrom, "comeFrom");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return ChoosePayChannelFragment.INSTANCE.newInstance(payChannels, tokenId, comeFrom, callback);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    @Nullable
    public AppRuntime createQWalletAppInterface(@Nullable MobileQQ app, @Nullable String processName) {
        if (app != null && processName != null) {
            return new QWalletAppInterface(app, processName);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    @NotNull
    public String currentUin() {
        return com.tencent.mobileqq.base.a.c();
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    @NotNull
    public String getFinancialPetStoragePath() {
        return PetDownloadManager.f278805a.w();
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    @NotNull
    public com.tencent.qqnt.graytips.handler.c getGrayTipActionHandler() {
        return new tx3.a();
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void getHbStateAsync(@NotNull final String listId, @NotNull final Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(listId, "listId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                NewQWalletApiImpl.getHbStateAsync$lambda$5(listId, callback);
            }
        }, 32, null, false);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    @NotNull
    public String getHbStateText(@NotNull String listId) {
        Intrinsics.checkNotNullParameter(listId, "listId");
        return HongBaoStateHelper.INSTANCE.getStateText(listId);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    @NotNull
    public WebViewPlugin getQWalletJSPlugin() {
        return new QWalletJsPlugin();
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    @NotNull
    public Class<? extends Service> getQWalletToolServiceClass() {
        return QWalletToolService.class;
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void handleFakeUrl(@Nullable Context context, @Nullable String schema) {
        new QWalletFakeUrlHandler(context, null, 2, null).dispatch(schema);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    @NotNull
    public String hexGuid() {
        return com.tencent.mobileqq.base.b.d();
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void ipcFollowUin(@NotNull String puin, boolean isFollow) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(puin, "puin");
        if (isFollow) {
            BaseApplication baseApplication = null;
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) waitAppRuntime;
            } else {
                appInterface = null;
            }
            IPublicAccountUtil iPublicAccountUtil = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
            if (appInterface != null) {
                baseApplication = appInterface.getApp();
            }
            iPublicAccountUtil.followUin(appInterface, baseApplication, puin, null, false, 6);
            return;
        }
        if (!TextUtils.isEmpty(puin)) {
            PayPucAccManager.e(puin);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    @NotNull
    public String ipcGetFaceFilePath(int faceType, @NotNull String uin, int idType) {
        String str;
        IQQAvatarDataService iQQAvatarDataService;
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iQQAvatarDataService = (IQQAvatarDataService) peekAppRuntime.getRuntimeService(IQQAvatarDataService.class, "")) != null) {
            str = iQQAvatarDataService.getCustomFaceFilePath(faceType, uin, idType);
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public boolean ipcIsFollowUin(@NotNull String puin) {
        Intrinsics.checkNotNullParameter(puin, "puin");
        AppInterface appInterface = null;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) waitAppRuntime;
        }
        return ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isFollowUin(appInterface, puin);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public boolean isFromHalfWebPage(@Nullable Activity activity, @Nullable Bundle bundle) {
        if (HalfWebViewFragment.INSTANCE.a(activity, bundle)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public boolean isFromQWalletPage(@Nullable Activity activity, @Nullable Bundle bundle) {
        if (QWalletH5Fragment.INSTANCE.a(activity, bundle)) {
            return true;
        }
        com.tencent.mobileqq.qwallet.home.a aVar = com.tencent.mobileqq.qwallet.home.a.f278002a;
        if (aVar.a(activity)) {
            aVar.b(bundle);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void launchHomeFragment(@NotNull Context context, @NotNull Intent intent, int channel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        u.f278200a.g(context, intent, channel);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void launchPayTransferPage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.mobileqq.base.c.f(context, new Intent(), PayTransferFragment.class, false, 8, null);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void launchQVipPayBridgeFragment(@NotNull Context context, @NotNull Intent intent) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (PayLogicFactory.b(intent)) {
            com.tencent.mobileqq.base.c.f(context, intent, MidasPayBridgeFragment.class, false, 8, null);
            return;
        }
        com.qwallet.pay.b b16 = s.e().b(context, intent, new b.a() { // from class: com.tencent.mobileqq.qwallet.api.impl.c
            @Override // com.qwallet.pay.b.a
            public final void x2(Context context2) {
                NewQWalletApiImpl.launchQVipPayBridgeFragment$lambda$0(context2);
            }
        });
        if (b16 != null) {
            b16.a(context);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w(TAG, 1, "launchQVipPayBridgeFragment: fail to create logic");
        }
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void openUrl(@NotNull QBaseFragment qWalletFragment, @NotNull String url) {
        Intrinsics.checkNotNullParameter(qWalletFragment, "qWalletFragment");
        Intrinsics.checkNotNullParameter(url, "url");
        if (qWalletFragment instanceof QWalletBaseFragment) {
            QvipPayFullWindowActivity.openUrl((QWalletBaseFragment) qWalletFragment, url, true, 0, "from_qwallet_success_page");
        } else {
            QLog.d(TAG, 1, "openUrl: invalid params, qWalletFragment is not QWalletBaseFragment");
        }
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public boolean parseJumpIdVerifyEntryAction(@NotNull Context context, @NotNull HashMap<String, String> attrMap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrMap, "attrMap");
        Intent intent = new Intent();
        intent.putExtra(IdVerifyEntryFragment.IN_EXTRA_LIST_ID, attrMap.get("list_id"));
        intent.putExtra(IdVerifyEntryFragment.IN_EXTRA_EXT_INFO, attrMap.get("ext_info"));
        intent.putExtra("sourceId", attrMap.get("sourceId"));
        intent.putExtra(RealNameSource.EXTRA_KEY_SOURCE_NAME, attrMap.get(RealNameSource.EXTRA_KEY_SOURCE_NAME));
        IdVerifyModule.startFromApiGotoView(context, intent);
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public boolean parseJumpQWalletPetAction(@NotNull Context context, @NotNull HashMap<String, String> attrMap) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrMap, "attrMap");
        String str = attrMap.get("pet_url");
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        try {
            String decodedUrl = Uri.decode(Uri.decode(str));
            QWalletPetFragment.Companion companion = QWalletPetFragment.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(decodedUrl, "decodedUrl");
            companion.a(context, decodedUrl);
            return true;
        } catch (Exception e16) {
            QLog.w(TAG, 1, "parseJumpQWalletPetAction fail", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void pushBy0x210Sub0x66(@NotNull byte[] pushData) {
        Intrinsics.checkNotNullParameter(pushData, "pushData");
        QWalletGoldMsgTipsElem convertTroopTips = ((IQWalletPBTemp) QRoute.api(IQWalletPBTemp.class)).convertTroopTips(pushData);
        if (convertTroopTips.type == 3) {
            String str = convertTroopTips.billno;
            Intrinsics.checkNotNullExpressionValue(str, "elem.billno");
            ux3.d.INSTANCE.d(new GoldMsgTipsElemBean(str, convertTroopTips.action, convertTroopTips.type));
        }
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void queryQbData(@NotNull final Activity activity, @NotNull final Function1<? super String, Unit> receiver) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                NewQWalletApiImpl.queryQbData$lambda$2(activity, receiver);
            }
        }, 128, null, true);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void reportCrash(@Nullable String crashInfo) {
        QWalletToolFragmentActivity.handleNoCatchCrash(crashInfo);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void requestData(@NotNull Context context, @NotNull String tag, @NotNull String uin, @NotNull Map<String, String> reqMap, @NotNull ResultReceiver callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(reqMap, "reqMap");
        Intrinsics.checkNotNullParameter(callback, "callback");
        TenpayInterface.requestData(context, tag, uin, reqMap, callback);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void saveQrCodeHbToken(@Nullable String qrToken) {
        QrCodeHbManager.INSTANCE.saveQrCodeHbToken(qrToken);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public boolean shouldInterceptQQBrowserDelegationActivity(@Nullable Activity activity, @Nullable String url, @Nullable Intent intent) {
        HashMap<String, String> hashMap;
        String str = null;
        try {
            hashMap = HttpUtil.decodeURL(url);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "shouldInterceptQQBrowserDelegationActivity: " + url, e16);
            hashMap = null;
        }
        if (QWalletH5Fragment.INSTANCE.c(activity, url, hashMap, intent)) {
            return true;
        }
        if (hashMap != null) {
            str = hashMap.get("financial-pet-webview");
        }
        boolean areEqual = Intrinsics.areEqual(str, "1");
        if (activity != null && url != null && areEqual) {
            QWalletPetFragment.INSTANCE.a(activity, url);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void startHbPay(@NotNull Context context, @Nullable JSONArray payChannels, @NotNull String tokenId, @NotNull String comeFrom, @NotNull String sourceId, int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tokenId, "tokenId");
        Intrinsics.checkNotNullParameter(comeFrom, "comeFrom");
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        PayModule.INSTANCE.startHbPay(context, payChannels, tokenId, comeFrom, sourceId, requestCode);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void startPreLogin(@NotNull QBaseActivity activity, @NotNull String appId, int appType, @NotNull String url) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(url, "url");
        com.tencent.mobileqq.qwallet.h5.b.f277185a.f(activity, appId, appType, url);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    @NotNull
    public DialogFragment startUnclaimed(@NotNull String troopId) {
        Intrinsics.checkNotNullParameter(troopId, "troopId");
        return UnclaimedDialogFragment.INSTANCE.a(troopId);
    }

    @Override // com.tencent.mobileqq.qwallet.api.INewQWalletApi
    public void updateStateByGrayBar(@NotNull String listId, boolean isSelf) {
        Intrinsics.checkNotNullParameter(listId, "listId");
        HongBaoStateHelper.INSTANCE.setStateByGrayBar(listId, isSelf);
    }
}
