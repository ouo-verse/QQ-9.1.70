package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public abstract class GamePAHippyBaseFragment<P extends QQGameHippyBasePresenter> extends CommonHippyFragment implements mh2.a<P> {
    P C = (P) V();
    protected int D = 0;

    public static void yh() {
        ((IWebProcessManagerService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(31, null);
    }

    private void zh(JSONObject jSONObject) {
        Bundle parameters;
        SerializableMap serializableMap;
        if (jSONObject != null && (parameters = getParameters()) != null && (serializableMap = (SerializableMap) parameters.getSerializable(OpenHippyInfo.EXTRA_KEY_JS_PARAM_MAP)) != null && serializableMap.getMap() != null) {
            String str = serializableMap.getMap().get("push_extra");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("GpInitData");
                if (optJSONObject != null) {
                    optJSONObject.put("gameExtra", str);
                }
            } catch (JSONException e16) {
                QLog.e("BaseHippyFragment", 2, "putExtraData e:" + e16);
            }
        }
    }

    @Override // mh2.a
    public HippyQQPreloadEngine Wg() {
        return this.mHippyQQEngine;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public JSONObject doBussinessInitData(JSONObject jSONObject) {
        JSONObject o16 = this.C.o(jSONObject);
        zh(o16);
        if (QLog.isColorLevel()) {
            QLog.i("BaseHippyFragment", 2, "jsInitData: " + o16);
        }
        return o16;
    }

    public void finish() {
        this.C.x();
    }

    @Override // mh2.a
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.C.b(this);
        this.C.e(activity);
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return this.C.q();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.C.f(configuration);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.C.g(bundle);
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.C.r(layoutInflater, viewGroup, bundle);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.C.s();
        this.C.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.C.t();
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        this.C.u();
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.C.v();
    }

    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.C.w();
    }

    @Override // com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.C.h();
    }

    public void uh(long j3) {
        this.D = 1;
    }

    public void xh(long j3) {
        yh();
        this.D = 2;
    }

    public void vh() {
    }

    public void wh() {
    }
}
