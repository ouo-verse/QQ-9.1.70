package com.tencent.mobileqq.vashealth.hippy;

import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdLoadHelper;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.vashealth.StepCounterPermissionUtils;
import g43.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vashealth/hippy/HealthMainHippyFragment;", "Lcom/tencent/mobileqq/vas/adv/fragment/AdHippyFragment;", "", "wh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", "getLayoutResId", "", "gotoErrorUrl", "Lorg/json/JSONObject;", "jsInitData", "doBussinessInitData", "retCode", "Ltencent/gdt/access$AdGetRsp;", "rsp", "onAdRsp", "onResume", "updateAdInfoList", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class HealthMainHippyFragment extends AdHippyFragment {
    private final void wh() {
        boolean z16;
        setMMaskPosId(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getHealthPosId());
        setMTianShuPosId(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getHealthTianShuPosId());
        IVasMaskAdvPreloadApi iVasMaskAdvPreloadApi = (IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class);
        MaskAdvName maskAdvName = MaskAdvName.QQ_HEALTH;
        setMMaskAdInfoList(iVasMaskAdvPreloadApi.getMaskAdInfoList(maskAdvName));
        setMTianShuAdInfoList(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(MaskAdvName.TIANSHU));
        initAdInfoList();
        IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        build.getAdvPos().add(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getHealthPosId());
        build.getAdvPos().add(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getHealthTianShuPosId());
        build.setUin(MaskAdLoadHelper.INSTANCE.getCurrentUin());
        build.setBusiType(13);
        build.setSpecifiedAdsJsonList(getMMaskAdInfoList());
        build.setSpecifiedTianShuAdsJsonList(getMTianShuAdInfoList());
        build.setTargetPosId(getMMaskPosId());
        build.setTianShuPosId(getMTianShuPosId());
        iVasAdvApi.requestAd(build, getAdvCallback());
        setMBusinessName(AdHippyFragment.HEALTH_NAME);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AdHippyFragment.AID_SET, getMCachedAidSet().toString());
        reportToBeacon(maskAdvName, AdHippyFragment.MASK_AD_DISPLAY_REQUEST_START, jSONObject);
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
        Serializable serializable;
        HashMap hashMap = new HashMap();
        Bundle parameters = getParameters();
        if (parameters != null && (serializable = parameters.getSerializable("qqHealthParams")) != null) {
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.hippy.qq.utils.SerializableMap");
            serializableMap = (SerializableMap) serializable;
        } else {
            serializableMap = null;
        }
        if (serializableMap != null) {
            HashMap<String, String> map = serializableMap.getMap();
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>");
            hashMap.putAll(map);
        }
        hashMap.put("isPreLoadAd", Boolean.TRUE);
        Bundle parameters2 = getParameters();
        if (parameters2 != null) {
            Object obj = parameters2.get("srcUrl");
            if (obj == null) {
                obj = "";
            }
            Intrinsics.checkNotNullExpressionValue(obj, "get(EXTRA_KEY_SRC_URL) ?: \"\"");
            hashMap.put("srcUrl", obj);
            Object obj2 = parameters2.get("loadStartTime");
            if (obj2 == null) {
                obj2 = Long.valueOf(System.currentTimeMillis());
            }
            Intrinsics.checkNotNullExpressionValue(obj2, "get(EXTRA_KEY_LOAD_START\u2026ystem.currentTimeMillis()");
            hashMap.put("loadStartTime", obj2);
        }
        JSONObject wrapHashMap = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).wrapHashMap(null, hashMap);
        JSONObject doBussinessInitData = super.doBussinessInitData(jsInitData);
        if (doBussinessInitData == null) {
            doBussinessInitData = new JSONObject();
        }
        doBussinessInitData.put("sportData", wrapHashMap);
        return doBussinessInitData;
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment
    protected int getLayoutResId() {
        return R.layout.f_t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment
    public boolean gotoErrorUrl() {
        QBaseActivity qBaseActivity;
        String str;
        if (!isFragmentDestroyed() && (qBaseActivity = getQBaseActivity()) != null) {
            IPublicAccountManager iPublicAccountManager = (IPublicAccountManager) QRoute.api(IPublicAccountManager.class);
            AppRuntime appRuntime = qBaseActivity.getAppRuntime();
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            AppInterface appInterface = (AppInterface) appRuntime;
            Bundle parameters = getParameters();
            c cVar = (c) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100502");
            if (cVar != null) {
                str = cVar.getMainPageUrl();
            } else {
                str = null;
            }
            iPublicAccountManager.handleUrlEvent(qBaseActivity, appInterface, parameters.getString("healthDefaultUrl", str), IPublicAccountUtil.UIN_FOR_HEALTH, null);
            getQBaseActivity().finish();
            return true;
        }
        return super.gotoErrorUrl();
    }

    @Override // com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment
    public void onAdRsp(int retCode, @Nullable access.AdGetRsp rsp) {
        boolean z16;
        String str;
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
        JSONObject jSONObject = null;
        access.UserActionReportInfo userActionReportInfo = null;
        jSONObject = null;
        jSONObject = null;
        if (((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).isShowMaskAdForHealth() && z16 && rsp != null) {
            qq_ad_get.QQAdGetRsp qQAdGetRsp = rsp.qq_ad_get_rsp.get();
            Intrinsics.checkNotNullExpressionValue(qQAdGetRsp, "it.qq_ad_get_rsp.get()");
            qq_ad_get.QQAdGetRsp qQAdGetRsp2 = qQAdGetRsp;
            if (rsp.action_report_infos.get().size() > 0) {
                userActionReportInfo = rsp.action_report_infos.get(0);
            }
            jSONObject = startShowMaskAd(qQAdGetRsp2, userActionReportInfo, AdHippyFragment.HEALTH_NAME);
        }
        reportToBeacon(MaskAdvName.QQ_HEALTH, str, jSONObject);
    }

    @Override // com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wh();
    }

    @Override // com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment, com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QQPermission.exitModule("biz_src_qqsport");
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment, com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        StepCounterPermissionUtils.q();
        QQPermission.enterModule("biz_src_qqsport");
        super.onResume();
    }

    @Override // com.tencent.mobileqq.vas.adv.fragment.AdHippyFragment
    public void updateAdInfoList() {
        setMMaskAdInfoList(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(MaskAdvName.QQ_HEALTH));
        setMTianShuAdInfoList(((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(MaskAdvName.TIANSHU));
        initAdInfoList();
    }
}
