package com.tencent.hippy.qq.adapter;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.api.IHippyDomNodeManager;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.dom.node.DomNodeRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class HippyQQThirdPartyAdapter extends HippyThirdPartyAdapter {
    private static final String TAG = "HippyQQThirdPartyAdapter";
    protected String bundleName;
    protected int bundleVersion;
    protected JSONObject mExtraData;
    protected String mPageUrl;
    protected JSONObject renderData;
    protected String renderTag;
    protected int renderVersion;

    @Override // com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter
    public String getAppVersion() {
        return AppSetting.f99551k;
    }

    @Override // com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter
    public JSONObject getExtraData() {
        return this.mExtraData;
    }

    @Override // com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter
    public String getPackageName() {
        return "mqq";
    }

    @Override // com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter
    public String getPageUrl() {
        return this.mPageUrl;
    }

    public void initSnapShotData(@NonNull JSONObject jSONObject) {
        this.bundleVersion = jSONObject.optInt(HippyQQConstants.KEY_BUNDLE_VERSION);
        this.renderVersion = jSONObject.optInt("renderVersion");
        this.bundleName = jSONObject.optString("bundleName");
        this.renderData = jSONObject.optJSONObject("renderData");
        this.renderTag = jSONObject.optString(HippyQQConstants.KEY_RENDER_TAG);
    }

    @Override // com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter
    public void saveInstanceState(ArrayList<DomNodeRecord> arrayList, Object obj) {
        QLog.e(TAG, 1, "[saveInstanceState] bundlerName:" + this.bundleName + ",bundleVersion:" + this.bundleVersion);
        if (TextUtils.isEmpty(this.bundleName)) {
            return;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            QLog.e(TAG, 1, "[saveInstanceState] recordList is empty");
            arrayList = new ArrayList<>();
        }
        ArrayList<DomNodeRecord> arrayList2 = arrayList;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            ((IHippyDomNodeManager) waitAppRuntime.getRuntimeService(IHippyDomNodeManager.class, ProcessConstant.MULTI)).saveInstanceState(this.bundleVersion, this.bundleName, this.renderVersion, this.renderData, this.renderTag, arrayList2);
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter
    public void setExtraData(JSONObject jSONObject) {
        this.mExtraData = jSONObject;
    }

    @Override // com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter
    public void setPageUrl(String str) {
        this.mPageUrl = str;
    }

    @Override // com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter
    public void onRuntimeDestroy() {
    }

    @Override // com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter
    public void onRuntimeInit(long j3) {
    }
}
