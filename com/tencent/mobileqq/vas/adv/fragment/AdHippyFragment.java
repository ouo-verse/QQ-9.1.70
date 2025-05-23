package com.tencent.mobileqq.vas.adv.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.f;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.adv.api.MaskAdDisappearListener;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdClickHelper;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdRenderProxy;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdReportHelper;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001XB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000208H\u0004J\u001a\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\t2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010=\u001a\u0002082\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u000208H\u0016J\b\u0010A\u001a\u000208H\u0014J\b\u0010B\u001a\u000208H\u0016J\b\u0010C\u001a\u000208H\u0016J\b\u0010D\u001a\u00020\u000fH\u0016J\b\u0010E\u001a\u000208H\u0016J\b\u0010F\u001a\u000208H\u0004J\"\u0010G\u001a\u0002082\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\r2\b\u0010K\u001a\u0004\u0018\u00010\u000bH\u0004J\b\u0010L\u001a\u000208H\u0002J\u0012\u0010M\u001a\u0002082\b\u0010N\u001a\u0004\u0018\u00010\rH\u0016J$\u0010O\u001a\u0002082\b\u0010P\u001a\u0004\u0018\u00010\r2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020\u000fH\u0002J\"\u0010T\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u0001042\u0006\u0010H\u001a\u00020\rH\u0004J\b\u0010W\u001a\u000208H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r0\u001ej\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r`\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\"j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`#X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\"j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`#X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\u001c\u00100\u001a\u0004\u0018\u00010\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/fragment/AdHippyFragment;", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "Lcom/tencent/mobileqq/vas/adv/api/MaskAdDisappearListener;", "()V", "advCallback", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "getAdvCallback", "()Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "mAdRetCode", "", "mAdRspJson", "Lorg/json/JSONObject;", "mAdRspMsg", "", "mAdRspSuccess", "", "mBusinessName", "getMBusinessName", "()Ljava/lang/String;", "setMBusinessName", "(Ljava/lang/String;)V", "mCachedAidSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getMCachedAidSet", "()Ljava/util/HashSet;", "setMCachedAidSet", "(Ljava/util/HashSet;)V", "mCachedFilePathMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mJsLoadSuccess", "mMaskAdInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMMaskAdInfoList", "()Ljava/util/ArrayList;", "setMMaskAdInfoList", "(Ljava/util/ArrayList;)V", "mMaskPosId", "getMMaskPosId", "setMMaskPosId", "mMaskProxy", "Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdRenderProxy;", "mTianShuAdInfoList", "getMTianShuAdInfoList", "setMTianShuAdInfoList", "mTianShuPosId", "getMTianShuPosId", "setMTianShuPosId", "mUserActionReportInfo", "Ltencent/gdt/access$UserActionReportInfo;", "getAdHippyMap", "Lcom/tencent/mtt/hippy/common/HippyMap;", "initAdInfoList", "", "onAdRsp", "retCode", "rsp", "Ltencent/gdt/access$AdGetRsp;", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onLoadHippySuccess", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "qOnBackPressed", "qOnNewIntent", "reportRequestWithSource", "reportToBeacon", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "Lcom/tencent/mobileqq/vas/adv/common/data/MaskAdvName;", "eventId", "params", "sendAdToHippy", "sendMaskAdDisappear", AdMetricTag.EVENT_NAME, "showMaskAd", "resPath", "maskAd", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "isTianShuAd", "startShowMaskAd", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "userActionReportInfo", "updateAdInfoList", "Companion", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public class AdHippyFragment extends CommonHippyFragment implements MaskAdDisappearListener {
    public static final int AD_INVALID = 0;
    public static final int AD_VALID = 1;

    @NotNull
    public static final String AID_SET = "aid_set";

    @NotNull
    private static final String EXTRA_KEY_AD = "adRsp";

    @NotNull
    private static final String EXTRA_KEY_AD_MSG = "adMsg";

    @NotNull
    public static final String EXTRA_KEY_AID = "aid";

    @NotNull
    private static final String EXTRA_KEY_LOAD_AD_RET_CODE = "retCode";
    public static final int EXTRA_KEY_REQ_AD_SUCCESS = 0;

    @NotNull
    public static final String HEALTH_NAME = "sport";

    @NotNull
    public static final String MASK_AD_DISPLAY_REQUEST_FAILED = "maskAdDisplayRequestFailed";

    @NotNull
    public static final String MASK_AD_DISPLAY_REQUEST_START = "maskAdDisplayRequestStart";

    @NotNull
    public static final String MASK_AD_DISPLAY_REQUEST_SUCCESS = "maskAdDisplayRequestSuccess";

    @NotNull
    public static final String RES_PATH = "res_path";

    @NotNull
    public static final String SEND_AD_EVENT_NAME = "sendAd";

    @NotNull
    public static final String WEATHER_NAME = "weather";

    @Nullable
    private JSONObject mAdRspJson;

    @Nullable
    private String mAdRspMsg;
    private volatile boolean mAdRspSuccess;

    @Nullable
    private String mBusinessName;
    private volatile boolean mJsLoadSuccess;

    @Nullable
    private ArrayList<JSONObject> mMaskAdInfoList;

    @Nullable
    private String mMaskPosId;

    @Nullable
    private MaskAdRenderProxy mMaskProxy;

    @Nullable
    private ArrayList<JSONObject> mTianShuAdInfoList;

    @Nullable
    private String mTianShuPosId;

    @Nullable
    private access.UserActionReportInfo mUserActionReportInfo;
    private volatile int mAdRetCode = -1;

    @NotNull
    private HashSet<Long> mCachedAidSet = new HashSet<>();

    @NotNull
    private HashMap<Long, String> mCachedFilePathMap = new HashMap<>();

    @NotNull
    private final VasAdCallback advCallback = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/adv/fragment/AdHippyFragment$a", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "rsp", "", "msg", "", "onRsp", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements VasAdCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        public void onRsp(int retCode, @Nullable access.AdGetRsp rsp, @NotNull String msg2) {
            qq_ad_get.QQAdGetRsp qQAdGetRsp;
            access.RetMsg retMsg;
            PBStringField pBStringField;
            qq_ad_get.QQAdGetRsp qQAdGetRsp2;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            AdHippyFragment adHippyFragment = AdHippyFragment.this;
            String str = null;
            if (rsp != null && (qQAdGetRsp2 = rsp.qq_ad_get_rsp) != null) {
                qQAdGetRsp = qQAdGetRsp2.get();
            } else {
                qQAdGetRsp = null;
            }
            adHippyFragment.mAdRspJson = (JSONObject) GdtJsonPbUtil.pbToJson(qQAdGetRsp);
            AdHippyFragment.this.mAdRetCode = retCode;
            AdHippyFragment adHippyFragment2 = AdHippyFragment.this;
            if (rsp != null && (retMsg = rsp.ret_msg) != null && (pBStringField = retMsg.err_msg) != null) {
                str = pBStringField.get();
            }
            adHippyFragment2.mAdRspMsg = str;
            AdHippyFragment.this.mAdRspSuccess = true;
            AdHippyFragment.this.onAdRsp(retCode, rsp);
            AdHippyFragment.this.sendAdToHippy();
        }
    }

    private final HippyMap getAdHippyMap() {
        String valueOf;
        HippyMap hippyMap = new HippyMap();
        try {
            hippyMap.pushInt("retCode", this.mAdRetCode);
            hippyMap.pushString(EXTRA_KEY_AD_MSG, this.mAdRspMsg);
            JSONObject jSONObject = this.mAdRspJson;
            if (jSONObject == null) {
                valueOf = "";
            } else {
                valueOf = String.valueOf(jSONObject);
            }
            hippyMap.pushString(EXTRA_KEY_AD, valueOf);
        } catch (Throwable th5) {
            QLog.i("BaseHippyFragment", 1, "get Ad failed,  exception : " + th5);
        }
        return hippyMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0() {
        ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).requestMaskAdAndDownloadFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendAdToHippy() {
        if (this.mJsLoadSuccess && this.mAdRspSuccess && this.mAdRetCode == 0) {
            sendHippyNativeEvent(SEND_AD_EVENT_NAME, getAdHippyMap());
        }
    }

    private final void showMaskAd(final String resPath, final qq_ad_get.QQAdGetRsp.AdInfo maskAd, final boolean isTianShuAd) {
        boolean z16;
        FragmentActivity activity;
        if (resPath != null && resPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && maskAd != null && (activity = getActivity()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.fragment.b
                @Override // java.lang.Runnable
                public final void run() {
                    AdHippyFragment.showMaskAd$lambda$3(AdHippyFragment.this, resPath, maskAd, isTianShuAd);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMaskAd$lambda$3(AdHippyFragment this$0, String str, qq_ad_get.QQAdGetRsp.AdInfo adInfo, boolean z16) {
        MaskAdvName maskAdvName;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            if (TextUtils.equals(this$0.mBusinessName, "weather")) {
                maskAdvName = MaskAdvName.QQ_WEATHER;
            } else {
                maskAdvName = MaskAdvName.QQ_HEALTH;
            }
            MaskAdRenderProxy maskAdRenderProxy = new MaskAdRenderProxy(activity, maskAdvName, str, adInfo);
            this$0.mMaskProxy = maskAdRenderProxy;
            access.UserActionReportInfo userActionReportInfo = this$0.mUserActionReportInfo;
            if (userActionReportInfo != null) {
                maskAdRenderProxy.setUserActionReportInfo(userActionReportInfo);
            }
            MaskAdRenderProxy maskAdRenderProxy2 = this$0.mMaskProxy;
            if (maskAdRenderProxy2 != null) {
                maskAdRenderProxy2.setDisappearListener(this$0);
            }
            MaskAdRenderProxy maskAdRenderProxy3 = this$0.mMaskProxy;
            if (maskAdRenderProxy3 != null) {
                maskAdRenderProxy3.setIsTianShuAd(z16);
            }
            MaskAdRenderProxy maskAdRenderProxy4 = this$0.mMaskProxy;
            if (maskAdRenderProxy4 != null) {
                ViewGroup mRootView = this$0.mRootView;
                Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
                maskAdRenderProxy4.startShow(mRootView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final VasAdCallback getAdvCallback() {
        return this.advCallback;
    }

    @Nullable
    protected final String getMBusinessName() {
        return this.mBusinessName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final HashSet<Long> getMCachedAidSet() {
        return this.mCachedAidSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final ArrayList<JSONObject> getMMaskAdInfoList() {
        return this.mMaskAdInfoList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final String getMMaskPosId() {
        return this.mMaskPosId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final ArrayList<JSONObject> getMTianShuAdInfoList() {
        return this.mTianShuAdInfoList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final String getMTianShuPosId() {
        return this.mTianShuPosId;
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initAdInfoList() {
        ArrayList<JSONObject> arrayList = this.mMaskAdInfoList;
        if (arrayList != null) {
            Iterator<JSONObject> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                long optLong = next.optLong("aid", 0L);
                if (optLong != 0) {
                    this.mCachedAidSet.add(Long.valueOf(optLong));
                    HashMap<Long, String> hashMap = this.mCachedFilePathMap;
                    Long valueOf = Long.valueOf(optLong);
                    String optString = next.optString(RES_PATH, "");
                    Intrinsics.checkNotNullExpressionValue(optString, "json.optString(RES_PATH, \"\")");
                    hashMap.put(valueOf, optString);
                }
            }
        }
        ArrayList<JSONObject> arrayList2 = this.mTianShuAdInfoList;
        if (arrayList2 != null) {
            Iterator<JSONObject> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                JSONObject next2 = it5.next();
                long optLong2 = next2.optLong("aid", 0L);
                if (optLong2 != 0) {
                    this.mCachedAidSet.add(Long.valueOf(optLong2));
                    HashMap<Long, String> hashMap2 = this.mCachedFilePathMap;
                    Long valueOf2 = Long.valueOf(optLong2);
                    String optString2 = next2.optString(RES_PATH, "");
                    Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(RES_PATH, \"\")");
                    hashMap2.put(valueOf2, optString2);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.adv.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                AdHippyFragment.onCreate$lambda$0();
            }
        }, 128, null, false);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MaskAdRenderProxy maskAdRenderProxy = this.mMaskProxy;
        if (maskAdRenderProxy != null) {
            maskAdRenderProxy.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippySuccess() {
        this.mJsLoadSuccess = true;
        sendAdToHippy();
        super.onLoadHippySuccess();
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MaskAdRenderProxy maskAdRenderProxy = this.mMaskProxy;
        if (maskAdRenderProxy != null) {
            maskAdRenderProxy.onPause();
        }
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MaskAdRenderProxy maskAdRenderProxy = this.mMaskProxy;
        if (maskAdRenderProxy != null) {
            maskAdRenderProxy.onResume();
        }
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void reportRequestWithSource() {
        boolean equals$default;
        String str;
        MaskAdReportHelper maskAdReportHelper = MaskAdReportHelper.INSTANCE;
        equals$default = StringsKt__StringsJVMKt.equals$default(this.mBusinessName, "weather", false, 2, null);
        if (equals$default) {
            str = "1";
        } else {
            str = "2";
        }
        maskAdReportHelper.reportAction("new_folder_splashad_requestwithsource", "", "", str, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void reportToBeacon(@NotNull MaskAdvName businessName, @NotNull String eventId, @Nullable JSONObject params) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).reportEventToBeacon(businessName, eventId, params);
    }

    @Override // com.tencent.mobileqq.vas.adv.api.MaskAdDisappearListener
    public void sendMaskAdDisappear(@Nullable String eventName) {
        sendHippyNativeEvent(eventName, new HippyMap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMBusinessName(@Nullable String str) {
        this.mBusinessName = str;
    }

    protected final void setMCachedAidSet(@NotNull HashSet<Long> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.mCachedAidSet = hashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMMaskAdInfoList(@Nullable ArrayList<JSONObject> arrayList) {
        this.mMaskAdInfoList = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMMaskPosId(@Nullable String str) {
        this.mMaskPosId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMTianShuAdInfoList(@Nullable ArrayList<JSONObject> arrayList) {
        this.mTianShuAdInfoList = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setMTianShuPosId(@Nullable String str) {
        this.mTianShuPosId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final JSONObject startShowMaskAd(@NotNull qq_ad_get.QQAdGetRsp rsp, @Nullable access.UserActionReportInfo userActionReportInfo, @NotNull String businessName) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        String str;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        this.mUserActionReportInfo = userActionReportInfo;
        List<qq_ad_get.QQAdGetRsp.PosAdInfo> list = rsp.pos_ads_info.get();
        JSONObject jSONObject = new JSONObject();
        boolean z16 = false;
        jSONObject.put(businessName, 0);
        Iterator<qq_ad_get.QQAdGetRsp.PosAdInfo> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                qq_ad_get.QQAdGetRsp.PosAdInfo next = it.next();
                if (next.has() && !next.ads_info.get().isEmpty()) {
                    adInfo = next.ads_info.get().get(0);
                    long j3 = adInfo.report_info.trace_info.aid.get();
                    if (jSONObject.has(businessName)) {
                        jSONObject.put(businessName, 1);
                    }
                    if (TextUtils.equals(this.mMaskPosId, next.pos_id.get()) && MaskAdClickHelper.INSTANCE.isMaskAd(new GdtAd(adInfo).getInnerShowType())) {
                        str = this.mCachedFilePathMap.get(Long.valueOf(j3));
                        break;
                    }
                    if (TextUtils.equals(this.mTianShuPosId, next.pos_id.get())) {
                        str = this.mCachedFilePathMap.get(Long.valueOf(j3));
                        z16 = true;
                        break;
                    }
                } else {
                    QLog.d("BaseHippyFragment", 2, "show maskAd, adInfo inValid\uff0cpos_id is" + next.pos_id.get());
                }
            } else {
                adInfo = null;
                str = null;
                break;
            }
        }
        if (adInfo != null) {
            showMaskAd(str, adInfo, z16);
        }
        return jSONObject;
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
    }

    public void updateAdInfoList() {
    }

    public void onAdRsp(int retCode, @Nullable access.AdGetRsp rsp) {
    }
}
