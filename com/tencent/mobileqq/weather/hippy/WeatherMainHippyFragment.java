package com.tencent.mobileqq.weather.hippy;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.ShareResultCallbackBase;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.hippy.qq.utils.screenshot.ShareImageUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.util.g;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdLoadHelper;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.hippy.WeatherMainHippyFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import ee2.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u001a\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001c\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\"\u0010!\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016R\u0014\u0010&\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R$\u00103\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/weather/hippy/WeatherMainHippyFragment;", "Lcom/tencent/mobileqq/vas/adv/fragment/AdHippyFragment;", "Lcom/tencent/hippy/qq/api/ShareResultCallbackBase;", "", OcrConfig.CHINESE, "", "firstPosId", "Ah", "Bh", "", "getLayoutResId", "", "gotoErrorUrl", "Lorg/json/JSONObject;", "jsInitData", "doBussinessInitData", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "retCode", "Ltencent/gdt/access$AdGetRsp;", "rsp", "onAdRsp", AdMetricTag.EVENT_NAME, "", "dataObj", "sendHippyNativeEvent", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "updateAdInfoList", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "TAG", "D", "Z", "isPreLoadAd", "E", "isWeatherWeek", "Lcom/tencent/hippy/qq/utils/screenshot/ShareImageUtils$ShareResultCallBack;", UserInfo.SEX_FEMALE, "Lcom/tencent/hippy/qq/utils/screenshot/ShareImageUtils$ShareResultCallBack;", "getShareResultCallback", "()Lcom/tencent/hippy/qq/utils/screenshot/ShareImageUtils$ShareResultCallBack;", "setShareResultCallback", "(Lcom/tencent/hippy/qq/utils/screenshot/ShareImageUtils$ShareResultCallBack;)V", "shareResultCallback", "<init>", "()V", "G", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WeatherMainHippyFragment extends AdHippyFragment implements ShareResultCallbackBase {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String TAG = "WeatherMainHippyFragment";

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isPreLoadAd = true;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isWeatherWeek;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ShareImageUtils.ShareResultCallBack shareResultCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/weather/hippy/WeatherMainHippyFragment$b", "Lcom/tencent/mobileqq/soso/location/LbsManagerServiceOnLocationChangeListener;", "", "errCode", "Lcom/tencent/mobileqq/soso/location/data/SosoLbsInfo;", "info", "", "onLocationFinish", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends LbsManagerServiceOnLocationChangeListener {
        b() {
            super("qq_weather", false);
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int errCode, @Nullable SosoLbsInfo info) {
            String str;
            Double d16;
            SosoLocation sosoLocation;
            SosoLocation sosoLocation2;
            SosoLocation sosoLocation3;
            HippyMap hippyMap = new HippyMap();
            if (errCode == 0 && info != null && (sosoLocation3 = info.mLocation) != null && (str = sosoLocation3.cityCode) != null) {
                Intrinsics.checkNotNullExpressionValue(str, "info.mLocation.cityCode");
                if (Math.abs(info.mLocation.mLat02) > 1.0E-6d && Math.abs(info.mLocation.mLon02) > 1.0E-6d) {
                    SosoLocation sosoLocation4 = info.mLocation;
                    double[] a16 = g.a(sosoLocation4.mLon02, sosoLocation4.mLat02);
                    SosoLocation sosoLocation5 = info.mLocation;
                    sosoLocation5.mLat84 = a16[1];
                    sosoLocation5.mLon84 = a16[0];
                }
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                if (WeatherMainHippyFragment.this.getActivity() != null) {
                    QQToast.makeText(WeatherMainHippyFragment.this.getActivity(), HardCodeUtil.qqStr(R.string.f238537k1), 0).show();
                }
                hippyMap.pushString("adCode", str);
                hippyMap.pushString(QCircleSchemeAttr.Polymerize.LAT, "0");
                hippyMap.pushString("lon", "0");
                WeatherMainHippyFragment.this.sendHippyNativeEvent("updateAdCode", hippyMap);
                return;
            }
            if (!TextUtils.isEmpty(str) && com.tencent.mobileqq.weather.util.b.f(WeatherMainHippyFragment.this.getActivity(), QQPermissionConstants.Business.SCENE.WEATHER_H5)) {
                try {
                    hippyMap.pushString("adCode", str);
                    Double d17 = null;
                    if (info != null && (sosoLocation2 = info.mLocation) != null) {
                        d16 = Double.valueOf(sosoLocation2.mLat84);
                    } else {
                        d16 = null;
                    }
                    hippyMap.pushString(QCircleSchemeAttr.Polymerize.LAT, String.valueOf(d16));
                    if (info != null && (sosoLocation = info.mLocation) != null) {
                        d17 = Double.valueOf(sosoLocation.mLon84);
                    }
                    hippyMap.pushString("lon", String.valueOf(d17));
                    WeatherMainHippyFragment.this.sendHippyNativeEvent("updateAdCode", hippyMap);
                } catch (Throwable th5) {
                    QLog.e(WeatherMainHippyFragment.this.TAG, 1, "send adcode to hippy failed, errCode \uff1a" + errCode + ", exception : " + th5);
                }
            }
            QLog.i(WeatherMainHippyFragment.this.TAG, 1, "errCode \uff1a" + errCode + ", curAdCode: " + str);
        }
    }

    private final void Ah(String firstPosId) {
        IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        build.getAdvPos().add(firstPosId);
        build.setUin(MaskAdLoadHelper.INSTANCE.getCurrentUin());
        build.setBusiType(10);
        iVasAdvApi.requestAd(build, getAdvCallback());
        setMBusinessName("weather");
        com.tencent.mobileqq.weather.b.a().b((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime());
    }

    private final void Bh() {
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(WeatherMainHippyFragment this$0) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle arguments = this$0.getArguments();
        if (arguments == null || (bundle = arguments.getBundle("params")) == null) {
            bundle = new Bundle();
        }
        String string = bundle.getString("url", "");
        String c16 = com.tencent.mobileqq.weather.util.b.c(string, 1);
        boolean L = com.tencent.mobileqq.weather.util.g.f313646a.L(string);
        this$0.isWeatherWeek = L;
        if (L && Intrinsics.areEqual(com.tencent.mobileqq.weather.util.b.b(string, "hasredpoint"), "1")) {
            Serializable serializable = bundle.getSerializable("qqWeatherParams");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.hippy.qq.utils.SerializableMap");
            String weatherWeekFirstPosId = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherWeekFirstPosId();
            HashMap<String, String> map = ((SerializableMap) serializable).getMap();
            if (map.containsKey("first_pos_id")) {
                String str = map.get("first_pos_id");
                Intrinsics.checkNotNull(str, "null cannot be cast to non-null type kotlin.String");
                weatherWeekFirstPosId = str;
            }
            this$0.Ah(weatherWeekFirstPosId);
            return;
        }
        if (!Intrinsics.areEqual(c16, "aio") && !TextUtils.isEmpty(string)) {
            this$0.isPreLoadAd = false;
        } else {
            this$0.zh();
        }
    }

    private final void zh() {
        boolean z16;
        setMMaskPosId(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherFirstPosId());
        setMTianShuPosId(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherTianShuPosId());
        IVasMaskAdvPreloadApi iVasMaskAdvPreloadApi = (IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class);
        MaskAdvName maskAdvName = MaskAdvName.QQ_WEATHER;
        setMMaskAdInfoList(iVasMaskAdvPreloadApi.getMaskAdInfoList(maskAdvName));
        setMTianShuAdInfoList(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(MaskAdvName.TIANSHU));
        initAdInfoList();
        IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        build.getAdvPos().add(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherFirstPosId());
        build.getAdvPos().add(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherSecondPosId());
        build.getAdvPos().add(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getWeatherTianShuPosId());
        build.setUin(MaskAdLoadHelper.INSTANCE.getCurrentUin());
        build.setBusiType(10);
        build.setSpecifiedAdsJsonList(getMMaskAdInfoList());
        build.setSpecifiedTianShuAdsJsonList(getMTianShuAdInfoList());
        build.setTargetPosId(getMMaskPosId());
        build.setTianShuPosId(getMTianShuPosId());
        iVasAdvApi.requestAd(build, getAdvCallback());
        setMBusinessName("weather");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AdHippyFragment.AID_SET, getMCachedAidSet().toString());
        reportToBeacon(maskAdvName, AdHippyFragment.MASK_AD_DISPLAY_REQUEST_START, jSONObject);
        com.tencent.mobileqq.weather.b.a().b((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime());
        ArrayList<JSONObject> mMaskAdInfoList = getMMaskAdInfoList();
        if (mMaskAdInfoList != null && !mMaskAdInfoList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            reportRequestWithSource();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    @NotNull
    public JSONObject doBussinessInitData(@Nullable JSONObject jsInitData) {
        SerializableMap serializableMap;
        JSONObject doBussinessInitData = super.doBussinessInitData(jsInitData);
        if (doBussinessInitData == null) {
            doBussinessInitData = new JSONObject();
        }
        try {
            HashMap hashMap = new HashMap();
            Bundle parameters = getParameters();
            if (parameters != null) {
                Serializable serializable = parameters.getSerializable("qqWeatherParams");
                Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.hippy.qq.utils.SerializableMap");
                serializableMap = (SerializableMap) serializable;
            } else {
                serializableMap = null;
            }
            if (serializableMap != null) {
                HashMap<String, String> map = serializableMap.getMap();
                Intrinsics.checkNotNull(map, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
                hashMap.putAll(map);
            }
            String currentUin = getQBaseActivity().getAppRuntime().getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "qBaseActivity.appRuntime.currentUin");
            hashMap.put("uin", currentUin);
            hashMap.put("isAuth", Boolean.valueOf(com.tencent.mobileqq.weather.util.b.f(getActivity(), QQPermissionConstants.Business.SCENE.WEATHER_H5)));
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushBoolean("isPreLoadAd", this.isPreLoadAd);
            hippyMap.pushBoolean("isKuikly", com.tencent.mobileqq.weather.util.g.f313646a.F());
            hashMap.put("experimentMap", hippyMap);
            doBussinessInitData.put("qqWeatherParams", ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).wrapHashMap(null, hashMap));
            return doBussinessInitData;
        } catch (Throwable th5) {
            try {
                QLog.e(this.TAG, 1, "init Data failed,  exception : " + th5);
            } catch (Throwable unused) {
            }
            return doBussinessInitData;
        }
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment
    protected int getLayoutResId() {
        return R.layout.h7d;
    }

    @Override // com.tencent.hippy.qq.api.ShareResultCallbackBase
    @Nullable
    public ShareImageUtils.ShareResultCallBack getShareResultCallback() {
        return this.shareResultCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    public boolean gotoErrorUrl() {
        QBaseActivity qBaseActivity;
        if (!isFragmentDestroyed() && (qBaseActivity = getQBaseActivity()) != null) {
            ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).openWeatherWebForHippy(qBaseActivity, getParameters().getString("adcode", EmoticonPackage.MAGIC_FACE_EPID));
            getQBaseActivity().finish();
            return true;
        }
        return super.gotoErrorUrl();
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        int i3;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5 || requestCode == 21) {
            if (resultCode == -1) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            ShareImageUtils.ShareResultCallBack shareResultCallback = getShareResultCallback();
            if (shareResultCallback != null) {
                shareResultCallback.callBack(i3);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment
    public void onAdRsp(int retCode, @Nullable access.AdGetRsp rsp) {
        boolean z16;
        String str;
        JSONObject jSONObject;
        access.RetMsg retMsg;
        PBStringField pBStringField;
        access.UserActionReportInfo userActionReportInfo;
        if (retCode == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = AdHippyFragment.MASK_AD_DISPLAY_REQUEST_SUCCESS;
        } else {
            str = AdHippyFragment.MASK_AD_DISPLAY_REQUEST_FAILED;
        }
        String str2 = null;
        if (!this.isWeatherWeek && ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).isShowMaskAdForWeather() && z16 && rsp != null) {
            qq_ad_get.QQAdGetRsp qQAdGetRsp = rsp.qq_ad_get_rsp.get();
            Intrinsics.checkNotNullExpressionValue(qQAdGetRsp, "it.qq_ad_get_rsp.get()");
            qq_ad_get.QQAdGetRsp qQAdGetRsp2 = qQAdGetRsp;
            if (rsp.action_report_infos.get().size() > 0) {
                userActionReportInfo = rsp.action_report_infos.get(0);
            } else {
                userActionReportInfo = null;
            }
            jSONObject = startShowMaskAd(qQAdGetRsp2, userActionReportInfo, "weather");
        } else {
            jSONObject = null;
        }
        reportToBeacon(MaskAdvName.QQ_WEATHER, str, jSONObject);
        com.tencent.mobileqq.weather.b a16 = com.tencent.mobileqq.weather.b.a();
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (rsp != null && (retMsg = rsp.ret_msg) != null && (pBStringField = retMsg.err_msg) != null) {
            str2 = pBStringField.get();
        }
        a16.c(appInterface, retCode, str2);
    }

    @Override // com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThreadManagerV2.excute(new Runnable() { // from class: q43.e
            @Override // java.lang.Runnable
            public final void run() {
                WeatherMainHippyFragment.yh(WeatherMainHippyFragment.this);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment, com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QQPermission.exitModule("biz_src_qqweather");
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        d.b("weather");
    }

    @Override // com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment, com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        d.a("weather");
        if (com.tencent.mobileqq.weather.util.b.f(getActivity(), QQPermissionConstants.Business.SCENE.WEATHER_H5)) {
            Bh();
        }
        QQPermission.enterModule("biz_src_qqweather");
        super.onResume();
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void sendHippyNativeEvent(@Nullable String eventName, @Nullable Object dataObj) {
        super.sendHippyNativeEvent(eventName, dataObj);
        if (TextUtils.equals(eventName, AdHippyFragment.SEND_AD_EVENT_NAME)) {
            com.tencent.mobileqq.weather.b.a().e((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null), "new_folder_click_adtohippy");
        }
    }

    @Override // com.tencent.hippy.qq.api.ShareResultCallbackBase
    public void setShareResultCallback(@Nullable ShareImageUtils.ShareResultCallBack shareResultCallBack) {
        this.shareResultCallback = shareResultCallBack;
    }

    @Override // com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment
    public void updateAdInfoList() {
        setMMaskAdInfoList(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(MaskAdvName.QQ_WEATHER));
        setMTianShuAdInfoList(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(MaskAdvName.TIANSHU));
        initAdInfoList();
    }
}
