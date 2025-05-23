package com.tencent.mobileqq.vas.api.impl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.api.EIPCCallbackWrapper;
import com.tencent.mobileqq.vas.api.IVasUtilProxy;
import com.tencent.mobileqq.vas.api.IVasYellowDiamondPay;
import com.tencent.mobileqq.vas.api.f;
import com.tencent.mobileqq.vas.manager.api.IGXHManager;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0002+,B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J2\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J6\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\t2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001ej\b\u0012\u0004\u0012\u00020\u0004`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasYellowDiamondPayImpl;", "Lcom/tencent/mobileqq/vas/api/IVasYellowDiamondPay;", "", "registerReceiver", "Lcom/tencent/mobileqq/vas/api/IVasYellowDiamondPay$a;", "callback", "addPayCallback", "", "isSuccess", "", "code", "", "msg", "notifyResult", "url", "openPayWithSchema", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "userId", "aid", "itemId", "openPayItem", "payType", "payFromQzonePhotoRepair", "", DownloadInfo.spKey_Config, "payFromAIEliminate", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "yellowDiamondPayToggle", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "payListeners", "Ljava/util/ArrayList;", "Landroid/content/IntentFilter;", "intentFilter", "Landroid/content/IntentFilter;", "Lcom/tencent/mobileqq/vas/api/impl/VasYellowDiamondPayImpl$VasPayReceiver;", "mReceiver", "Lcom/tencent/mobileqq/vas/api/impl/VasYellowDiamondPayImpl$VasPayReceiver;", "<init>", "()V", "Companion", "a", "VasPayReceiver", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasYellowDiamondPayImpl implements IVasYellowDiamondPay {

    @NotNull
    private static final String ACTION_WEBVIEW_DISPATCH_EVENT = "com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT";

    @NotNull
    public static final String TAG = "VasYellowDiamondPay";

    @NotNull
    private final UnitedProxy yellowDiamondPayToggle = com.tencent.mobileqq.vas.ar.INSTANCE.a("linkliang", "2024-07-08", "vas_qzone_photo_repair_pay_9080");

    @NotNull
    private final ArrayList<IVasYellowDiamondPay.a> payListeners = new ArrayList<>();

    @NotNull
    private final IntentFilter intentFilter = new IntentFilter(ACTION_WEBVIEW_DISPATCH_EVENT);

    @NotNull
    private final VasPayReceiver mReceiver = new VasPayReceiver(this);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasYellowDiamondPayImpl$VasPayReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/tencent/mobileqq/vas/api/impl/VasYellowDiamondPayImpl;", "a", "Lcom/tencent/mobileqq/vas/api/impl/VasYellowDiamondPayImpl;", "getPay", "()Lcom/tencent/mobileqq/vas/api/impl/VasYellowDiamondPayImpl;", OpenConstants.ApiName.PAY, "<init>", "(Lcom/tencent/mobileqq/vas/api/impl/VasYellowDiamondPayImpl;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class VasPayReceiver extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final VasYellowDiamondPayImpl pay;

        public VasPayReceiver(@NotNull VasYellowDiamondPayImpl pay) {
            Intrinsics.checkNotNullParameter(pay, "pay");
            this.pay = pay;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String stringExtra = intent.getStringExtra("event");
            if (!Intrinsics.areEqual(stringExtra, "vipPayResult")) {
                return;
            }
            String str = "";
            boolean z16 = false;
            int i3 = -1;
            try {
                String stringExtra2 = intent.getStringExtra("data");
                QLog.i(VasYellowDiamondPayImpl.TAG, 1, "onReceive event:" + stringExtra + ", data:" + stringExtra2);
                if (stringExtra2 != null) {
                    JSONObject jSONObject = new JSONObject(stringExtra2);
                    i3 = jSONObject.optInt("ret", -1);
                    String optString = jSONObject.optString("msg", "error");
                    Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"msg\", \"error\")");
                    str = optString;
                }
            } catch (JSONException e16) {
                QLog.e(VasYellowDiamondPayImpl.TAG, 1, e16, new Object[0]);
            }
            if (i3 == 0) {
                VipNtMMKV.INSTANCE.getCommon(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()).encodeBool("vas_qzone_vip_pay", true);
            }
            VasYellowDiamondPayImpl vasYellowDiamondPayImpl = this.pay;
            if (i3 == 0) {
                z16 = true;
            }
            vasYellowDiamondPayImpl.notifyResult(z16, i3, str);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/api/impl/VasYellowDiamondPayImpl$b", "Lcom/tencent/mobileqq/vip/api/h;", "", "vipMa", "billno", "payStr", "", "b", "", "code", "a", "msg", "c", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements com.tencent.mobileqq.vip.api.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IVasYellowDiamondPay.a f308550a;

        b(IVasYellowDiamondPay.a aVar) {
            this.f308550a = aVar;
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void a(int code) {
            IVasYellowDiamondPay.a aVar = this.f308550a;
            if (aVar != null) {
                aVar.onResult(true, 0, "success");
            }
        }

        @Override // com.tencent.mobileqq.vip.api.h
        public void b(@NotNull String vipMa, @NotNull String billno, @NotNull String payStr) {
            Intrinsics.checkNotNullParameter(vipMa, "vipMa");
            Intrinsics.checkNotNullParameter(billno, "billno");
            Intrinsics.checkNotNullParameter(payStr, "payStr");
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void c(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            IVasYellowDiamondPay.a aVar = this.f308550a;
            if (aVar != null) {
                aVar.onResult(false, code, msg2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void payFromAIEliminate$lambda$4(IVasYellowDiamondPay.a aVar, String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        JSONObject jSONObject = new JSONObject(jsonString);
        if (aVar != null) {
            boolean optBoolean = jSONObject.optBoolean("status");
            int optInt = jSONObject.optInt("code");
            String optString = jSONObject.optString("msg");
            Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"msg\")");
            aVar.onResult(optBoolean, optInt, optString);
        }
    }

    private final void registerReceiver() {
        try {
            QLog.i(TAG, 1, "registerReceiver");
            BaseApplication.context.registerReceiver(this.mReceiver, this.intentFilter);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "registerReceiver failed!", e16);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay
    public void addPayCallback(@NotNull IVasYellowDiamondPay.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.payListeners.contains(callback)) {
            registerReceiver();
            this.payListeners.add(callback);
        }
    }

    public final void notifyResult(boolean isSuccess, int code, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        for (IVasYellowDiamondPay.a aVar : this.payListeners) {
            if (isSuccess) {
                aVar.onResult(true, 0, msg2);
            } else {
                aVar.onResult(false, code, msg2);
            }
        }
        this.payListeners.clear();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay
    public void openPayItem(@NotNull Activity activity, @NotNull String userId, @NotNull String aid, @NotNull String itemId, @Nullable IVasYellowDiamondPay.a callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        new e23.c(activity).b(userId, aid, itemId, new b(callback));
    }

    @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay
    public void openPayWithSchema(@NotNull String url, @Nullable IVasYellowDiamondPay.a callback) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(url, "url");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
        if (startsWith$default) {
            return;
        }
        if (callback != null) {
            addPayCallback(callback);
        }
        IVasUtilProxy iVasUtilProxy = (IVasUtilProxy) QRoute.api(IVasUtilProxy.class);
        Context applicationContext = MobileQQ.sMobileQQ.peekAppRuntime().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.peekAppRuntime().applicationContext");
        iVasUtilProxy.openSchema(applicationContext, url);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay
    public void payFromAIEliminate(@NotNull Activity activity, int payType, @NotNull Map<String, String> config, @Nullable final IVasYellowDiamondPay.a callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(config, "config");
        boolean z16 = true;
        QLog.i(TAG, 1, "payFromAIEliminate payType:" + payType + ", config:" + config);
        if (payType == IVasYellowDiamondPay.PayType.OPEN.ordinal()) {
            String str = config.get("join_url_android");
            if (str != null) {
                openPayWithSchema(str, callback);
                return;
            }
            return;
        }
        if (payType == IVasYellowDiamondPay.PayType.RENEW.ordinal()) {
            String str2 = config.get("renew_url_android");
            if (str2 != null) {
                openPayWithSchema(str2, callback);
                return;
            }
            return;
        }
        if (payType == IVasYellowDiamondPay.PayType.ITEM.ordinal()) {
            String uin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            if (uin != null && uin.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            IGXHManager gxh = VasUtil.getService().getGxh();
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            String str3 = config.get("item_aid_android");
            String str4 = "";
            if (str3 == null) {
                str3 = "";
            }
            String str5 = config.get("item_id_android");
            if (str5 != null) {
                str4 = str5;
            }
            gxh.openPayItem(uin, str3, str4, EIPCCallbackWrapper.newInstance(new f.b() { // from class: com.tencent.mobileqq.vas.api.impl.au
                @Override // com.tencent.mobileqq.vas.api.f.b
                public final void onCallback(String str6) {
                    VasYellowDiamondPayImpl.payFromAIEliminate$lambda$4(IVasYellowDiamondPay.a.this, str6);
                }
            }));
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay
    public void payFromQzonePhotoRepair(@NotNull Activity activity, int payType, @Nullable IVasYellowDiamondPay.a callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        JSONObject json = this.yellowDiamondPayToggle.getJson();
        String openUrl = json.optString("pay_and");
        String renewalUrl = json.optString("renewal_and");
        String itemAid = json.optString("item_aid_and");
        String itemId = json.optString("item_id");
        if (payType == IVasYellowDiamondPay.PayType.OPEN.ordinal()) {
            Intrinsics.checkNotNullExpressionValue(openUrl, "openUrl");
            openPayWithSchema(openUrl, callback);
            return;
        }
        if (payType == IVasYellowDiamondPay.PayType.RENEW.ordinal()) {
            Intrinsics.checkNotNullExpressionValue(renewalUrl, "renewalUrl");
            openPayWithSchema(renewalUrl, callback);
            return;
        }
        if (payType == IVasYellowDiamondPay.PayType.ITEM.ordinal()) {
            String uin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            if (uin != null && uin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            Intrinsics.checkNotNullExpressionValue(itemAid, "itemAid");
            Intrinsics.checkNotNullExpressionValue(itemId, "itemId");
            openPayItem(activity, uin, itemAid, itemId, callback);
        }
    }
}
