package com.tencent.mobileqq.zootopia.service.api.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.boodo.CommonVideoViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaPortalMallSendGiftService;
import com.tencent.mobileqq.zootopia.service.api.impl.ZootopiaPortalMallSendGiftServiceImpl;
import com.tencent.mobileqq.zootopia.view.z;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import trpc.zplan.avatar_mall.MallSendGift$GiftItemReply;
import trpc.zplan.avatar_mall.MallSendGift$GiftItemRequest;
import trpc.zplan.avatar_mall.MallSendGift$RspHeader;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJD\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002JA\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J,\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J.\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/api/impl/ZootopiaPortalMallSendGiftServiceImpl;", "Lcom/tencent/mobileqq/zootopia/service/api/IZootopiaPortalMallSendGiftService;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "nickName", "toUin", "", "itemId", "iconUrl", "Lkotlin/Function1;", "", "", "callback", "checkAndSendGift", "Ltrpc/zplan/avatar_mall/MallSendGift$GiftItemReply;", "rsp", "", "errorMsgId", CommonVideoViewController.PropName.SHOW_ERROR_TOAST, "(Landroid/app/Activity;Ltrpc/zplan/avatar_mall/MallSendGift$GiftItemReply;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;)V", "onSendSuccess", "onPayError", "showPayPanel", "notifyUpdateBalance", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaPortalMallSendGiftServiceImpl implements IZootopiaPortalMallSendGiftService {
    private static final String METHOD = "SsoGiftItem";
    private static final String PAY_PANEL_BUSINESS_NAME = "zplan";
    private static final String REPORT_ITEM_ID = "zplan_gift_id";
    private static final String SERVICE = "trpc.zplan.avatar_mall.Avatar";
    private static final String TAG = "ZootopiaPortalMallSendGiftServiceImpl";

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/service/api/impl/ZootopiaPortalMallSendGiftServiceImpl$b", "Lcom/tencent/mobileqq/zplan/servlet/b;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zplan.servlet.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f329172e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f329173f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ z f329174h;

        /* JADX WARN: Multi-variable type inference failed */
        b(Activity activity, Function1<? super Boolean, Unit> function1, z zVar) {
            this.f329172e = activity;
            this.f329173f = function1;
            this.f329174h = zVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(z loadingDialog) {
            Intrinsics.checkNotNullParameter(loadingDialog, "$loadingDialog");
            try {
                loadingDialog.dismiss();
            } catch (Exception e16) {
                QLog.e(ZootopiaPortalMallSendGiftServiceImpl.TAG, 1, "loadingDialog hide error", e16);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int type, boolean isSuccess, Object data) {
            MallSendGift$RspHeader mallSendGift$RspHeader;
            PBStringField pBStringField;
            MallSendGift$RspHeader mallSendGift$RspHeader2;
            PBInt32Field pBInt32Field;
            QLog.d(ZootopiaPortalMallSendGiftServiceImpl.TAG, 4, "checkAndSendGift isSuccess:" + isSuccess);
            if (data instanceof byte[]) {
                MallSendGift$GiftItemReply rsp = new MallSendGift$GiftItemReply().mergeFrom((byte[]) data);
                String str = null;
                Integer valueOf = (rsp == null || (mallSendGift$RspHeader2 = rsp.rsp_header) == null || (pBInt32Field = mallSendGift$RspHeader2.func_ret) == null) ? null : Integer.valueOf(pBInt32Field.get());
                if (valueOf != null && valueOf.intValue() == 0) {
                    ZootopiaPortalMallSendGiftServiceImpl zootopiaPortalMallSendGiftServiceImpl = ZootopiaPortalMallSendGiftServiceImpl.this;
                    Activity activity = this.f329172e;
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    zootopiaPortalMallSendGiftServiceImpl.onSendSuccess(activity, rsp, this.f329173f);
                } else if (valueOf != null && valueOf.intValue() == 23006) {
                    ZootopiaPortalMallSendGiftServiceImpl zootopiaPortalMallSendGiftServiceImpl2 = ZootopiaPortalMallSendGiftServiceImpl.this;
                    Activity activity2 = this.f329172e;
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    zootopiaPortalMallSendGiftServiceImpl2.onPayError(activity2, rsp, this.f329173f);
                } else if (valueOf != null && valueOf.intValue() == 10) {
                    ZootopiaPortalMallSendGiftServiceImpl.showErrorToast$default(ZootopiaPortalMallSendGiftServiceImpl.this, this.f329172e, rsp, this.f329173f, null, 8, null);
                } else if (valueOf != null && valueOf.intValue() == 10030) {
                    ZootopiaPortalMallSendGiftServiceImpl.this.showErrorToast(this.f329172e, rsp, this.f329173f, Integer.valueOf(R.string.xjo));
                } else if (valueOf != null && valueOf.intValue() == 10035) {
                    ZootopiaPortalMallSendGiftServiceImpl.this.showErrorToast(this.f329172e, rsp, this.f329173f, Integer.valueOf(R.string.xjm));
                } else if (valueOf != null && valueOf.intValue() == 10038) {
                    ZootopiaPortalMallSendGiftServiceImpl.this.showErrorToast(this.f329172e, rsp, this.f329173f, Integer.valueOf(R.string.xjq));
                } else if (valueOf != null && valueOf.intValue() == 10039) {
                    ZootopiaPortalMallSendGiftServiceImpl.this.showErrorToast(this.f329172e, rsp, this.f329173f, Integer.valueOf(R.string.xjn));
                } else if (valueOf != null && valueOf.intValue() == 10040) {
                    ZootopiaPortalMallSendGiftServiceImpl.this.showErrorToast(this.f329172e, rsp, this.f329173f, Integer.valueOf(R.string.xjl));
                } else if (valueOf != null && valueOf.intValue() == 10042) {
                    ZootopiaPortalMallSendGiftServiceImpl.this.showErrorToast(this.f329172e, rsp, this.f329173f, Integer.valueOf(R.string.xjr));
                    ZootopiaPortalMallSendGiftServiceImpl.this.notifyUpdateBalance();
                } else if (valueOf != null && valueOf.intValue() == 10043) {
                    ZootopiaPortalMallSendGiftServiceImpl.this.showErrorToast(this.f329172e, rsp, this.f329173f, Integer.valueOf(R.string.xjs));
                } else if (valueOf != null && valueOf.intValue() == 10044) {
                    ZootopiaPortalMallSendGiftServiceImpl.this.showErrorToast(this.f329172e, rsp, this.f329173f, Integer.valueOf(R.string.xjt));
                } else {
                    ZootopiaPortalMallSendGiftServiceImpl.showErrorToast$default(ZootopiaPortalMallSendGiftServiceImpl.this, this.f329172e, rsp, this.f329173f, null, 8, null);
                }
                if (rsp != null && (mallSendGift$RspHeader = rsp.rsp_header) != null && (pBStringField = mallSendGift$RspHeader.f437272msg) != null) {
                    str = pBStringField.get();
                }
                QLog.d(ZootopiaPortalMallSendGiftServiceImpl.TAG, 4, "checkAndSendGift rsp:" + str);
            } else {
                ZootopiaPortalMallSendGiftServiceImpl.showErrorToast$default(ZootopiaPortalMallSendGiftServiceImpl.this, this.f329172e, null, this.f329173f, null, 8, null);
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final z zVar = this.f329174h;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.service.api.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaPortalMallSendGiftServiceImpl.b.b(z.this);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/service/api/impl/ZootopiaPortalMallSendGiftServiceImpl$c", "Lcom/tencent/mobileqq/vas/pay/api/IVasNativePayManager$PayObserver;", "", "onOpenPayViewFail", "onOpenPayViewSuccess", "onPaySuccess", "", "code", "onPayError", "onPayViewClose", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements IVasNativePayManager.PayObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayError(int code) {
            QLog.e(ZootopiaPortalMallSendGiftServiceImpl.TAG, 1, "onPaySuccess, code: " + code);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewFail() {
            QLog.e(ZootopiaPortalMallSendGiftServiceImpl.TAG, 1, "onOpenPayViewFail");
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewSuccess() {
            QLog.d(ZootopiaPortalMallSendGiftServiceImpl.TAG, 4, "onOpenPayViewSuccess");
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPaySuccess() {
            QLog.e(ZootopiaPortalMallSendGiftServiceImpl.TAG, 1, "onPaySuccess");
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayViewClose() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyUpdateBalance() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("reason", "sendGift");
        ar.f328509a.a("N2L_NeedUpdateBalance", jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPayError(Activity activity, MallSendGift$GiftItemReply rsp, Function1<? super Boolean, Unit> callback) {
        PBStringField pBStringField;
        PBInt32Field pBInt32Field;
        MallSendGift$RspHeader mallSendGift$RspHeader = rsp.rsp_header;
        String str = null;
        Integer valueOf = (mallSendGift$RspHeader == null || (pBInt32Field = mallSendGift$RspHeader.func_ret) == null) ? null : Integer.valueOf(pBInt32Field.get());
        MallSendGift$RspHeader mallSendGift$RspHeader2 = rsp.rsp_header;
        if (mallSendGift$RspHeader2 != null && (pBStringField = mallSendGift$RspHeader2.f437272msg) != null) {
            str = pBStringField.get();
        }
        QLog.e(TAG, 1, "onPayError rsp:" + valueOf + "-" + str);
        if (rsp.pay_res.get() == -10010) {
            showErrorToast(activity, rsp, callback, Integer.valueOf(R.string.xjp));
            showPayPanel(activity, rsp);
        } else {
            showErrorToast$default(this, activity, rsp, callback, null, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSendSuccess(final Activity activity, MallSendGift$GiftItemReply rsp, Function1<? super Boolean, Unit> callback) {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        if (uIHandlerV2 != null) {
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.service.api.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaPortalMallSendGiftServiceImpl.onSendSuccess$lambda$2(activity);
                }
            });
        }
        callback.invoke(Boolean.TRUE);
        notifyUpdateBalance();
        yb4.e.g(yb4.e.f450058a, "sendGift", 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSendSuccess$lambda$2(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QQToast.makeText(activity, 2, activity.getString(R.string.xju), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showErrorToast$lambda$1(Activity activity, String message) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(message, "$message");
        QQToast.makeText(activity, 1, message, 0).show();
    }

    private final void showPayPanel(Activity activity, MallSendGift$GiftItemReply rsp) {
        String str;
        IVasNativePayManager iVasNativePayManager = (IVasNativePayManager) QRoute.api(IVasNativePayManager.class);
        IVasNativePayManager.ReportData reportData = new IVasNativePayManager.ReportData("1009", "0", "1", "0");
        Map<String, String> mDtData = reportData.mDtData;
        Intrinsics.checkNotNullExpressionValue(mDtData, "mDtData");
        PBUInt64Field pBUInt64Field = rsp.product_id;
        if (pBUInt64Field == null || (str = Long.valueOf(pBUInt64Field.get()).toString()) == null) {
            str = "";
        }
        mDtData.put(REPORT_ITEM_ID, str);
        Unit unit = Unit.INSTANCE;
        iVasNativePayManager.initAndShowPayPanel(activity, IVasNativePayManager.TITLE_RECHARGE, "zplan", reportData, new c());
    }

    @Override // com.tencent.mobileqq.zootopia.service.api.IZootopiaPortalMallSendGiftService
    public void checkAndSendGift(Activity activity, Bundle extraData, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (extraData == null) {
            QLog.e(TAG, 1, "checkAndSendGift extraData is null");
            return;
        }
        String nickName = extraData.getString("uinname", "");
        String toUin = extraData.getString("uin", "");
        long j3 = extraData.getLong("gift_item_id", 0L);
        String itemUrl = extraData.getString("gift_icon_url", "");
        Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
        Intrinsics.checkNotNullExpressionValue(toUin, "toUin");
        Intrinsics.checkNotNullExpressionValue(itemUrl, "itemUrl");
        checkAndSendGift(activity, nickName, toUin, j3, itemUrl, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorToast(final Activity activity, MallSendGift$GiftItemReply rsp, Function1<? super Boolean, Unit> callback, Integer errorMsgId) {
        final String str;
        MallSendGift$RspHeader mallSendGift$RspHeader;
        PBStringField pBStringField;
        MallSendGift$RspHeader mallSendGift$RspHeader2;
        PBStringField pBStringField2;
        MallSendGift$RspHeader mallSendGift$RspHeader3;
        PBInt32Field pBInt32Field;
        String str2 = null;
        QLog.e(TAG, 1, "showErrorToast rsp:" + ((rsp == null || (mallSendGift$RspHeader3 = rsp.rsp_header) == null || (pBInt32Field = mallSendGift$RspHeader3.func_ret) == null) ? null : Integer.valueOf(pBInt32Field.get())) + "-" + ((rsp == null || (mallSendGift$RspHeader2 = rsp.rsp_header) == null || (pBStringField2 = mallSendGift$RspHeader2.f437272msg) == null) ? null : pBStringField2.get()));
        if (errorMsgId != null) {
            str = activity.getResources().getString(errorMsgId.intValue());
        } else {
            if (rsp != null && (mallSendGift$RspHeader = rsp.rsp_header) != null && (pBStringField = mallSendGift$RspHeader.f437272msg) != null) {
                str2 = pBStringField.get();
            }
            str = str2 == null ? "\u8d60\u9001\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5" : str2;
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (errorMsgId != null) \u2026?: \"\u8d60\u9001\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\"\n        }");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        if (uIHandlerV2 != null) {
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.service.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaPortalMallSendGiftServiceImpl.showErrorToast$lambda$1(activity, str);
                }
            });
        }
        callback.invoke(Boolean.FALSE);
    }

    static /* synthetic */ void showErrorToast$default(ZootopiaPortalMallSendGiftServiceImpl zootopiaPortalMallSendGiftServiceImpl, Activity activity, MallSendGift$GiftItemReply mallSendGift$GiftItemReply, Function1 function1, Integer num, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            num = null;
        }
        zootopiaPortalMallSendGiftServiceImpl.showErrorToast(activity, mallSendGift$GiftItemReply, function1, num);
    }

    private final void checkAndSendGift(Activity activity, String nickName, String toUin, long itemId, String iconUrl, Function1<? super Boolean, Unit> callback) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof AppInterface)) {
            QLog.e(TAG, 1, "checkAndSendGift app is not AppInterface");
            return;
        }
        AppInterface appInterface = (AppInterface) waitAppRuntime;
        String currentNickname = appInterface.getCurrentNickname();
        MallSendGift$GiftItemRequest mallSendGift$GiftItemRequest = new MallSendGift$GiftItemRequest();
        mallSendGift$GiftItemRequest.uin_name.set(currentNickname);
        mallSendGift$GiftItemRequest.to_uin.set(toUin);
        mallSendGift$GiftItemRequest.product_id.set(itemId);
        mallSendGift$GiftItemRequest.icon_url.set(iconUrl);
        mallSendGift$GiftItemRequest.to_uin_name.set(nickName);
        BusinessHandler businessHandler = appInterface.getBusinessHandler(ZPlanRequestHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.sqshow.servlet.ZPlanRequestHandler");
        z zVar = new z(activity, false, false, 6, null);
        zVar.show();
        ((ZPlanRequestHandler) businessHandler).request("trpc.zplan.avatar_mall.Avatar.SsoGiftItem", mallSendGift$GiftItemRequest.toByteArray(), new b(activity, callback, zVar));
    }
}
