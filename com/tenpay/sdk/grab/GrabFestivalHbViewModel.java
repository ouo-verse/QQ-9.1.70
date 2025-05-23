package com.tenpay.sdk.grab;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.report.IReportApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tk2.FestivalHbData;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 P2\u00020\u0001:\u0002PQB\u0007\u00a2\u0006\u0004\bN\u0010OJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\"\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0002J\u0010\u0010%\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020#R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020.0&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010(R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020.0)8\u0006\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\t0&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010(R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\t0)8\u0006\u00a2\u0006\f\n\u0004\b3\u0010+\u001a\u0004\b4\u0010-R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\f0&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010(R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\f0)8\u0006\u00a2\u0006\f\n\u0004\b6\u0010+\u001a\u0004\b7\u0010-R\u001c\u00109\u001a\b\u0012\u0004\u0012\u0002080&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010(R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u0002080)8\u0006\u00a2\u0006\f\n\u0004\b:\u0010+\u001a\u0004\b;\u0010-R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020#0&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010(R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020#0)8\u0006\u00a2\u0006\f\n\u0004\b=\u0010+\u001a\u0004\b>\u0010-R\u0016\u0010?\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010@R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010AR\u0016\u0010B\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010AR\u0016\u0010C\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006R"}, d2 = {"Lcom/tenpay/sdk/grab/GrabFestivalHbViewModel;", "Landroidx/lifecycle/ViewModel;", "", "wish", "", "onChangeWish", "", "amount", "onChangeAmount", "Ltk2/a$a;", EventKey.ACT, "onChangeActivity", "Ltk2/a$b;", "anim", "onChangeAnim", "Landroid/os/Bundle;", "args", "getAmount", "grabState", "sendState", "handleGrabByState", "status", "updateUi", "updateUiOnSuccess", "updateUiOnOverdue", "updateUiOnReceive", "updateUiOnNoGrab", "reportActivityClick", "reportClose", "reportShow", "init", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "url", "onActivityClick", "", "fromUser", "onClose", "Landroidx/lifecycle/MutableLiveData;", "_wishLiveData", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "wishLiveData", "Landroidx/lifecycle/LiveData;", "getWishLiveData", "()Landroidx/lifecycle/LiveData;", "", "_amountLiveData", "amountLiveData", "getAmountLiveData", "_activityLiveData", "activityLiveData", "getActivityLiveData", "_animLiveData", "animLiveData", "getAnimLiveData", "Lorg/json/JSONObject;", "_overdueLiveData", "overdueLiveData", "getOverdueLiveData", "_closeLiveData", "closeLiveData", "getCloseLiveData", "skinId", "I", "Ljava/lang/String;", "groupId", "sendObj", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", "hbApi", "Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", "Lcom/tencent/mobileqq/qwallet/report/IReportApi;", "reportApi", "Lcom/tencent/mobileqq/qwallet/report/IReportApi;", "Lcom/tencent/mobileqq/qwallet/hb/HbInfo$a;", "bundleInfo", "Lcom/tencent/mobileqq/qwallet/hb/HbInfo$a;", "<init>", "()V", "Companion", "GrabStatus", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class GrabFestivalHbViewModel extends ViewModel {

    @NotNull
    private static final String TAG = "QWallet.Festival.GrabFestivalThemeHbView";

    @NotNull
    private MutableLiveData<FestivalHbData.Extra> _activityLiveData;

    @NotNull
    private MutableLiveData<Float> _amountLiveData;

    @NotNull
    private MutableLiveData<FestivalHbData.Anim> _animLiveData;

    @NotNull
    private MutableLiveData<Boolean> _closeLiveData;

    @NotNull
    private MutableLiveData<JSONObject> _overdueLiveData;

    @NotNull
    private MutableLiveData<String> _wishLiveData;

    @NotNull
    private final LiveData<FestivalHbData.Extra> activityLiveData;
    private int amount;

    @NotNull
    private final LiveData<Float> amountLiveData;

    @NotNull
    private final LiveData<FestivalHbData.Anim> animLiveData;

    @NotNull
    private final HbInfo.a bundleInfo;

    @NotNull
    private final LiveData<Boolean> closeLiveData;

    @NotNull
    private String groupId;

    @NotNull
    private final IQWalletFestivalHbApi hbApi;

    @NotNull
    private final LiveData<JSONObject> overdueLiveData;

    @NotNull
    private final IReportApi reportApi;
    private JSONObject sendObj;
    private int skinId;

    @NotNull
    private String wish;

    @NotNull
    private final LiveData<String> wishLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tenpay/sdk/grab/GrabFestivalHbViewModel$GrabStatus;", "", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes27.dex */
    public @interface GrabStatus {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tenpay/sdk/grab/GrabFestivalHbViewModel$GrabStatus$Companion;", "", "()V", "OTHER_ALREADY_GRAB", "", "getOTHER_ALREADY_GRAB", "()I", "setOTHER_ALREADY_GRAB", "(I)V", "OTHER_NO_GRAB", "getOTHER_NO_GRAB", "setOTHER_NO_GRAB", "OVERDUE", "getOVERDUE", "setOVERDUE", "SUCCESS", "getSUCCESS", "setSUCCESS", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            private static int SUCCESS;
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static int OVERDUE = 1;
            private static int OTHER_NO_GRAB = 2;
            private static int OTHER_ALREADY_GRAB = 3;

            Companion() {
            }

            public final int getOTHER_ALREADY_GRAB() {
                return OTHER_ALREADY_GRAB;
            }

            public final int getOTHER_NO_GRAB() {
                return OTHER_NO_GRAB;
            }

            public final int getOVERDUE() {
                return OVERDUE;
            }

            public final int getSUCCESS() {
                return SUCCESS;
            }

            public final void setOTHER_ALREADY_GRAB(int i3) {
                OTHER_ALREADY_GRAB = i3;
            }

            public final void setOTHER_NO_GRAB(int i3) {
                OTHER_NO_GRAB = i3;
            }

            public final void setOVERDUE(int i3) {
                OVERDUE = i3;
            }

            public final void setSUCCESS(int i3) {
                SUCCESS = i3;
            }
        }
    }

    public GrabFestivalHbViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._wishLiveData = mutableLiveData;
        this.wishLiveData = mutableLiveData;
        MutableLiveData<Float> mutableLiveData2 = new MutableLiveData<>();
        this._amountLiveData = mutableLiveData2;
        this.amountLiveData = mutableLiveData2;
        MutableLiveData<FestivalHbData.Extra> mutableLiveData3 = new MutableLiveData<>();
        this._activityLiveData = mutableLiveData3;
        this.activityLiveData = mutableLiveData3;
        MutableLiveData<FestivalHbData.Anim> mutableLiveData4 = new MutableLiveData<>();
        this._animLiveData = mutableLiveData4;
        this.animLiveData = mutableLiveData4;
        MutableLiveData<JSONObject> mutableLiveData5 = new MutableLiveData<>();
        this._overdueLiveData = mutableLiveData5;
        this.overdueLiveData = mutableLiveData5;
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>();
        this._closeLiveData = mutableLiveData6;
        this.closeLiveData = mutableLiveData6;
        this.wish = "";
        this.groupId = "";
        QRouteApi api = QRoute.api(IQWalletFestivalHbApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQWalletFestivalHbApi::class.java)");
        this.hbApi = (IQWalletFestivalHbApi) api;
        QRouteApi api2 = QRoute.api(IReportApi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IReportApi::class.java)");
        this.reportApi = (IReportApi) api2;
        this.bundleInfo = new HbInfo.a();
    }

    private final int getAmount(Bundle args) {
        try {
            JSONObject jSONObject = new JSONObject(args.getString("recv_object", ""));
            if (jSONObject.optInt("amount") > 0) {
                return jSONObject.optInt("amount");
            }
        } catch (Exception unused) {
            QLog.w(TAG, 2, "recObj parse error");
        }
        try {
            JSONObject jSONObject2 = new JSONObject(args.getString("self_object", ""));
            if (jSONObject2.optInt("amount") > 0) {
                return jSONObject2.optInt("amount");
            }
        } catch (Exception unused2) {
            QLog.w(TAG, 1, "selfObj parse error");
        }
        JSONObject jSONObject3 = this.sendObj;
        if (jSONObject3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendObj");
            jSONObject3 = null;
        }
        return jSONObject3.optInt("total_amount");
    }

    private final void handleGrabByState(int grabState, int sendState) {
        int success;
        if (grabState != 0 && grabState != 1) {
            if (grabState != 3) {
                if (grabState != 6) {
                    if (grabState != 9) {
                        if (grabState != 10) {
                            success = 0;
                            onClose(false);
                        }
                    }
                } else if (sendState != 2) {
                    if (sendState != 3 && sendState != 4) {
                        success = GrabStatus.INSTANCE.getOTHER_NO_GRAB();
                    } else {
                        success = GrabStatus.INSTANCE.getOVERDUE();
                    }
                } else {
                    success = GrabStatus.INSTANCE.getOTHER_ALREADY_GRAB();
                }
                updateUi(success);
            }
            success = GrabStatus.INSTANCE.getOVERDUE();
            updateUi(success);
        }
        success = GrabStatus.INSTANCE.getSUCCESS();
        updateUi(success);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(GrabFestivalHbViewModel this$0, Bundle args) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(args, "$args");
        this$0.hbApi.checkIfNeedLoadLightSdk();
        HbInfo.c(args, this$0.bundleInfo);
        HbInfo.a aVar = this$0.bundleInfo;
        JSONObject festivalHbPanelConfig = this$0.hbApi.getFestivalHbPanelConfig();
        JSONObject jSONObject = null;
        if (festivalHbPanelConfig != null) {
            str = festivalHbPanelConfig.optString("name");
        } else {
            str = null;
        }
        aVar.panel_name = str;
        String string = args.getString("send_object");
        if (!TextUtils.isEmpty(string)) {
            try {
                this$0.skinId = args.getInt("grab_skin_id");
                String string2 = args.getString("grab_group_id", "");
                Intrinsics.checkNotNullExpressionValue(string2, "args.getString(HbConstan\u2026rabKey.GRAB_GROUP_ID, \"\")");
                this$0.groupId = string2;
                Intrinsics.checkNotNull(string);
                JSONObject jSONObject2 = new JSONObject(string);
                this$0.sendObj = jSONObject2;
                String optString = jSONObject2.optString("wishing");
                Intrinsics.checkNotNullExpressionValue(optString, "sendObj.optString(HbCons\u2026nts.GrabKey.SEND_WISHING)");
                this$0.wish = optString;
                JSONObject jSONObject3 = this$0.sendObj;
                if (jSONObject3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sendObj");
                } else {
                    jSONObject = jSONObject3;
                }
                int optInt = jSONObject.optInt("state");
                int i3 = args.getInt("grab_status");
                this$0.amount = this$0.getAmount(args);
                this$0.handleGrabByState(i3, optInt);
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
            QLog.i(TAG, 2, "[handleGrabStatus] sendObj:" + string);
            return;
        }
        this$0.sendObj = new JSONObject();
        this$0.updateUiOnOverdue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChangeActivity(FestivalHbData.Extra act) {
        this._activityLiveData.postValue(act);
    }

    private final void onChangeAmount(int amount) {
        this._amountLiveData.postValue(Float.valueOf(amount / 100));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChangeAnim(FestivalHbData.Anim anim) {
        this._animLiveData.postValue(anim);
    }

    private final void onChangeWish(String wish) {
        this._wishLiveData.postValue(wish);
    }

    public static /* synthetic */ void onClose$default(GrabFestivalHbViewModel grabFestivalHbViewModel, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        grabFestivalHbViewModel.onClose(z16);
    }

    private final void reportActivityClick() {
        IReportApi iReportApi = this.reportApi;
        String str = this.bundleInfo.panel_name;
        if (str == null) {
            str = "";
        }
        iReportApi.reportHongbaoTo644("festival.activity.click", "1", str, String.valueOf(this.skinId), "");
    }

    private final void reportClose() {
        IReportApi iReportApi = this.reportApi;
        String str = this.bundleInfo.panel_name;
        if (str == null) {
            str = "";
        }
        iReportApi.reportHongbaoTo644("festival.grap.close", "1", str, String.valueOf(this.skinId), "");
    }

    private final void reportShow() {
        IReportApi iReportApi = this.reportApi;
        String str = this.bundleInfo.panel_name;
        if (str == null) {
            str = "";
        }
        iReportApi.reportHongbaoTo644("festival.grap.show", "1", str, String.valueOf(this.skinId), "");
    }

    private final void updateUi(int status) {
        GrabStatus.Companion companion = GrabStatus.INSTANCE;
        if (status == companion.getSUCCESS()) {
            updateUiOnSuccess();
        } else if (status == companion.getOVERDUE()) {
            updateUiOnOverdue();
        } else if (status == companion.getOTHER_NO_GRAB()) {
            updateUiOnNoGrab();
        } else if (status == companion.getOTHER_ALREADY_GRAB()) {
            updateUiOnReceive();
        }
        QLog.i(TAG, 1, "[updateUi] status:" + status);
        reportShow();
    }

    private final void updateUiOnNoGrab() {
        onChangeAmount(this.amount);
        onChangeWish(this.wish);
        onChangeActivity(new FestivalHbData.Extra(MobileQQ.sMobileQQ.getString(R.string.f212445nj), null, null, 6, null));
        this.hbApi.getSkinData(this.skinId, new Function1<HbSkinData, Unit>() { // from class: com.tenpay.sdk.grab.GrabFestivalHbViewModel$updateUiOnNoGrab$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinData hbSkinData) {
                invoke2(hbSkinData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable HbSkinData hbSkinData) {
                Unit unit;
                int i3;
                IQWalletFestivalHbApi iQWalletFestivalHbApi;
                if (hbSkinData != null) {
                    GrabFestivalHbViewModel grabFestivalHbViewModel = GrabFestivalHbViewModel.this;
                    iQWalletFestivalHbApi = grabFestivalHbViewModel.hbApi;
                    grabFestivalHbViewModel.onChangeAnim(iQWalletFestivalHbApi.convertHbData(hbSkinData).getAnim());
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    i3 = GrabFestivalHbViewModel.this.skinId;
                    QLog.i("QWallet.Festival.GrabFestivalThemeHbView", 1, "get skinData failed,skinId:" + i3);
                }
            }
        });
    }

    private final void updateUiOnOverdue() {
        MutableLiveData<JSONObject> mutableLiveData = this._overdueLiveData;
        JSONObject jSONObject = this.sendObj;
        if (jSONObject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendObj");
            jSONObject = null;
        }
        mutableLiveData.postValue(jSONObject);
    }

    private final void updateUiOnReceive() {
        onChangeAmount(this.amount);
        onChangeWish(this.wish);
        onChangeActivity(new FestivalHbData.Extra(MobileQQ.sMobileQQ.getString(R.string.f212425nh), null, null, 6, null));
        this.hbApi.getSkinData(this.skinId, new Function1<HbSkinData, Unit>() { // from class: com.tenpay.sdk.grab.GrabFestivalHbViewModel$updateUiOnReceive$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinData hbSkinData) {
                invoke2(hbSkinData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable HbSkinData hbSkinData) {
                Unit unit;
                int i3;
                IQWalletFestivalHbApi iQWalletFestivalHbApi;
                if (hbSkinData != null) {
                    GrabFestivalHbViewModel grabFestivalHbViewModel = GrabFestivalHbViewModel.this;
                    iQWalletFestivalHbApi = grabFestivalHbViewModel.hbApi;
                    grabFestivalHbViewModel.onChangeAnim(iQWalletFestivalHbApi.convertHbData(hbSkinData).getAnim());
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    i3 = GrabFestivalHbViewModel.this.skinId;
                    QLog.i("QWallet.Festival.GrabFestivalThemeHbView", 1, "get skinData failed,skinId:" + i3);
                }
            }
        });
    }

    private final void updateUiOnSuccess() {
        onChangeAmount(this.amount);
        onChangeWish(this.wish);
        this.hbApi.getSkinData(this.skinId, new Function1<HbSkinData, Unit>() { // from class: com.tenpay.sdk.grab.GrabFestivalHbViewModel$updateUiOnSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinData hbSkinData) {
                invoke2(hbSkinData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable HbSkinData hbSkinData) {
                int i3;
                IQWalletFestivalHbApi iQWalletFestivalHbApi;
                if (hbSkinData == null) {
                    i3 = GrabFestivalHbViewModel.this.skinId;
                    QLog.i("QWallet.Festival.GrabFestivalThemeHbView", 1, "get skinData failed,skinId:" + i3);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                GrabFestivalHbViewModel grabFestivalHbViewModel = GrabFestivalHbViewModel.this;
                iQWalletFestivalHbApi = grabFestivalHbViewModel.hbApi;
                FestivalHbData convertHbData = iQWalletFestivalHbApi.convertHbData(hbSkinData);
                grabFestivalHbViewModel.onChangeActivity(convertHbData.getCom.tencent.qqlive.module.videoreport.constants.EventKey.ACT java.lang.String());
                grabFestivalHbViewModel.onChangeAnim(convertHbData.getAnim());
            }
        });
    }

    @NotNull
    public final LiveData<FestivalHbData.Extra> getActivityLiveData() {
        return this.activityLiveData;
    }

    @NotNull
    public final LiveData<Float> getAmountLiveData() {
        return this.amountLiveData;
    }

    @NotNull
    public final LiveData<FestivalHbData.Anim> getAnimLiveData() {
        return this.animLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getCloseLiveData() {
        return this.closeLiveData;
    }

    @NotNull
    public final LiveData<JSONObject> getOverdueLiveData() {
        return this.overdueLiveData;
    }

    @NotNull
    public final LiveData<String> getWishLiveData() {
        return this.wishLiveData;
    }

    public final void init(@NotNull final Bundle args) {
        Intrinsics.checkNotNullParameter(args, "args");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.grab.n
            @Override // java.lang.Runnable
            public final void run() {
                GrabFestivalHbViewModel.init$lambda$0(GrabFestivalHbViewModel.this, args);
            }
        }, 16, null, false);
    }

    public final void onActivityClick(@Nullable FragmentActivity activity, @NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        reportActivityClick();
        com.tencent.mobileqq.qwallet.utils.k.h(activity, url);
    }

    public final void onClose(boolean fromUser) {
        this._closeLiveData.postValue(Boolean.valueOf(fromUser));
        reportClose();
    }
}
