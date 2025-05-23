package com.tencent.mobileqq.qwallet.api;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.fragment.app.DialogFragment;
import com.tencent.aio.api.runtime.a;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRemote;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.graytips.handler.c;
import com.tenpay.payment.qrcodehb.QrCodeHbFragment;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 _2\u00020\u0001:\u0001`J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0017\u001a\u00020\u0004H&J\b\u0010\u0018\u001a\u00020\u0004H&J\u0010\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u0019H&J<\u0010\"\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001e2\u0006\u0010!\u001a\u00020 H&J$\u0010'\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060%H&J\u0018\u0010+\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H'J\b\u0010,\u001a\u00020\u0004H&J\u0010\u0010-\u001a\u00020)2\u0006\u0010(\u001a\u00020\u0004H'J \u00100\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\fH'J\u0010\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u000201H&J\u0010\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0004H'J$\u00106\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060%H&J\u0018\u00108\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00042\u0006\u00107\u001a\u00020)H&J(\u0010>\u001a\u00020=2\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&J\b\u0010@\u001a\u00020?H&J\u001c\u0010C\u001a\u00020)2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010B\u001a\u0004\u0018\u00010AH&J\u001c\u0010D\u001a\u00020)2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010B\u001a\u0004\u0018\u00010AH&J&\u0010E\u001a\u00020)2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J4\u0010I\u001a\u00020)2\u0006\u0010\t\u001a\u00020\b2\"\u0010H\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040Fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`GH&J4\u0010J\u001a\u00020)2\u0006\u0010\t\u001a\u00020\b2\"\u0010H\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040Fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`GH&J\b\u0010L\u001a\u00020KH&J\u001c\u0010N\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010M\u001a\u0004\u0018\u00010\u0004H&J(\u0010R\u001a\u00020\u00062\u0006\u0010$\u001a\u00020O2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010S\u001a\u00020\u0004H&J:\u0010V\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\fH&J\u0010\u0010X\u001a\u00020=2\u0006\u0010W\u001a\u00020\u0004H&J\u0010\u0010[\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020YH&J\u0012\u0010]\u001a\u00020\u00062\b\u0010\\\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010^\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/INewQWalletApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "walletFragment", "", "url", "", "openUrl", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", WadlProxyConsts.CHANNEL, "launchHomeFragment", "launchQVipPayBridgeFragment", "Lmqq/app/MobileQQ;", "app", "processName", "Lmqq/app/AppRuntime;", "createQWalletAppInterface", "crashInfo", "reportCrash", "appIdStr", "hexGuid", "Ljava/lang/Class;", "Landroid/app/Service;", "getQWalletToolServiceClass", "tag", "uin", "", "reqMap", "Landroid/os/ResultReceiver;", "callback", WebViewPlugin.KEY_REQUEST, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function1;", "receiver", "queryQbData", IPublicAccountBrowser.KEY_PUB_UIN, "", "isFollow", "ipcFollowUin", PanoramaConfig.KEY_CURRENT_UIN, "ipcIsFollowUin", "faceType", "idType", "ipcGetFaceFilePath", "", "pushData", "pushBy0x210Sub0x66", "listId", "getHbStateText", "getHbStateAsync", "isSelf", "updateStateByGrayBar", "Lorg/json/JSONArray;", "payChannels", "tokenId", "comeFrom", "Landroidx/fragment/app/DialogFragment;", "createPayChannelDialog", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "getQWalletJSPlugin", "Landroid/os/Bundle;", "bundle", "isFromQWalletPage", "isFromHalfWebPage", "shouldInterceptQQBrowserDelegationActivity", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "attrMap", "parseJumpQWalletPetAction", "parseJumpIdVerifyEntryAction", "Lcom/tencent/qqnt/graytips/handler/c;", "getGrayTipActionHandler", QZoneDTLoginReporter.SCHEMA, "handleFakeUrl", "Lcom/tencent/mobileqq/app/QBaseActivity;", "appId", "appType", "startPreLogin", "getFinancialPetStoragePath", "sourceId", "requestCode", "startHbPay", "troopId", "startUnclaimed", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "bindAioContext", QrCodeHbFragment.KEY_IN_QR_TOKEN, "saveQrCodeHbToken", "launchPayTransferPage", "Companion", "a", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface INewQWalletApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f277087a;

    @NotNull
    public static final String QWALLET_SECURITY_WEB_URL_SOURCE = "mqq.wallet";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/INewQWalletApi$a;", "", "<init>", "()V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.api.INewQWalletApi$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f277087a = new Companion();

        Companion() {
        }
    }

    @NotNull
    String appIdStr();

    void bindAioContext(@NotNull a aioContext);

    @NotNull
    DialogFragment createPayChannelDialog(@NotNull JSONArray payChannels, @NotNull String tokenId, @NotNull String comeFrom, @NotNull ResultReceiver callback);

    @Nullable
    AppRuntime createQWalletAppInterface(@Nullable MobileQQ app, @Nullable String processName);

    @NotNull
    String currentUin();

    @NotNull
    String getFinancialPetStoragePath();

    @NotNull
    c getGrayTipActionHandler();

    void getHbStateAsync(@NotNull String listId, @NotNull Function1<? super String, Unit> callback);

    @Deprecated(message = "\u4f7f\u7528\u5f02\u6b65\u63a5\u53e3getHbStateAsync")
    @NotNull
    String getHbStateText(@NotNull String listId);

    @NotNull
    WebViewPlugin getQWalletJSPlugin();

    @NotNull
    Class<? extends Service> getQWalletToolServiceClass();

    void handleFakeUrl(@Nullable Context context, @Nullable String schema);

    @NotNull
    String hexGuid();

    @QRemote
    void ipcFollowUin(@NotNull String puin, boolean isFollow);

    @QRemote
    @NotNull
    String ipcGetFaceFilePath(int faceType, @NotNull String uin, int idType);

    @QRemote
    boolean ipcIsFollowUin(@NotNull String puin);

    boolean isFromHalfWebPage(@Nullable Activity activity, @Nullable Bundle bundle);

    boolean isFromQWalletPage(@Nullable Activity activity, @Nullable Bundle bundle);

    void launchHomeFragment(@NotNull Context context, @NotNull Intent intent, int channel);

    void launchPayTransferPage(@NotNull Context context);

    void launchQVipPayBridgeFragment(@NotNull Context context, @NotNull Intent intent);

    void openUrl(@NotNull QBaseFragment walletFragment, @NotNull String url);

    boolean parseJumpIdVerifyEntryAction(@NotNull Context context, @NotNull HashMap<String, String> attrMap);

    boolean parseJumpQWalletPetAction(@NotNull Context context, @NotNull HashMap<String, String> attrMap);

    void pushBy0x210Sub0x66(@NotNull byte[] pushData);

    void queryQbData(@NotNull Activity activity, @NotNull Function1<? super String, Unit> receiver);

    void reportCrash(@Nullable String crashInfo);

    void requestData(@NotNull Context context, @NotNull String tag, @NotNull String uin, @NotNull Map<String, String> reqMap, @NotNull ResultReceiver callback);

    void saveQrCodeHbToken(@Nullable String qrToken);

    boolean shouldInterceptQQBrowserDelegationActivity(@Nullable Activity activity, @Nullable String url, @Nullable Intent intent);

    void startHbPay(@NotNull Context context, @Nullable JSONArray payChannels, @NotNull String tokenId, @NotNull String comeFrom, @NotNull String sourceId, int requestCode);

    void startPreLogin(@NotNull QBaseActivity activity, @NotNull String appId, int appType, @NotNull String url);

    @NotNull
    DialogFragment startUnclaimed(@NotNull String troopId);

    void updateStateByGrayBar(@NotNull String listId, boolean isSelf);
}
