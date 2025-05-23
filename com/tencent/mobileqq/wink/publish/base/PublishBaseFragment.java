package com.tencent.mobileqq.wink.publish.base;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.publish.b;
import com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import uq3.c;
import za3.a;

/* loaded from: classes21.dex */
public abstract class PublishBaseFragment extends ImmersivePartFragment implements IWinkCrashReportCallback {
    private void rh(View view, String str) {
        String tag;
        if (view == null) {
            QLog.i("FSBaseFragment", 1, "reportDaTongRegister mContentView == null , subPage: " + getPageId());
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        if (!TextUtils.isEmpty(getPageId())) {
            tag = getPageId();
        } else {
            tag = getTAG();
        }
        VideoReport.setPageId(view, tag);
        if (!TextUtils.isEmpty(ph())) {
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_ref_pgid", ph());
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, ph());
            if (getChildDaTongPageParams() != null) {
                hashMap.putAll(getChildDaTongPageParams());
            }
            if (tag.equals(WinkDaTongReportConstant.PageId.PG_XSJ_PUBLISH_NEW_PAGE)) {
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_NUM, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_NUM));
                hashMap.put("xsj_picture_num", WinkDatongCurrentParams.get("xsj_picture_num"));
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM));
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_VIDEO_MATERIAL_ID));
                WinkContext.Companion companion = WinkContext.INSTANCE;
                if (!TextUtils.isEmpty(companion.d().p(QCircleScheme.AttrQQPublish.IS_TEAM_LEADER))) {
                    hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_TEAM_LEADER, companion.d().p(QCircleScheme.AttrQQPublish.IS_TEAM_LEADER));
                }
                HashMap<String, Object> hashMap2 = WinkDatongCurrentParams.params;
                if (hashMap2 != null) {
                    hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHOSE_QZONE_ALBUM, hashMap2.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CHOSE_QZONE_ALBUM));
                    if (WinkDatongCurrentParams.params.containsKey("xsj_qzone_entrance_source")) {
                        hashMap.put("xsj_qzone_entrance_source", WinkDatongCurrentParams.params.get("xsj_qzone_entrance_source"));
                    }
                }
                HashMap<String, Object> hashMap3 = WinkDatongCurrentParams.params;
                if (hashMap3 != null && hashMap3.containsKey(WinkDaTongReportConstant.ElementParamKey.XSJ_MEMORIES_ALBUM_ID)) {
                    hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MEMORIES_ALBUM_ID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MEMORIES_ALBUM_ID));
                    hashMap.put("xsj_template_id", WinkDatongCurrentParams.get("xsj_template_id"));
                }
                try {
                    if (getActivity() != null && getActivity().getIntent() != null) {
                        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE, getActivity().getIntent().getStringExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_AUTO_VIDEO_SOURCE));
                        if (QQWinkConstants.WinkTaskRoute.AIGC.equals(getActivity().getIntent().getStringExtra(QQWinkConstants.WinkTaskRoute.WINK_TASK_ROUTE))) {
                            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_MAGIC_DRAW, "1");
                        } else {
                            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_MAGIC_DRAW, "0");
                        }
                        if (Objects.equals(Boolean.TRUE, Boolean.valueOf(getActivity().getIntent().getBooleanExtra("aigc_img_mode", false)))) {
                            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FROM, QCircleDaTongConstant.ElementParamValue.XSJ_AIGC_PICTURE_TAB);
                        } else {
                            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FROM, QCircleDaTongConstant.ElementParamValue.XSJ_AIGC_CHARACTER_TAB);
                        }
                    }
                } catch (Exception e16) {
                    QLog.i("FSBaseFragment", 1, "registerDaTongReportPageId error " + e16.getMessage());
                }
                hashMap.put("xsj_material_id", WinkDatongCurrentParams.get("xsj_material_id"));
                hashMap.put("xsj_material_type", WinkDatongCurrentParams.get("xsj_material_type"));
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_LIST_ITEM_NAME));
                hashMap.put("xsj_challenge_topic", WinkDatongCurrentParams.get("xsj_challenge_topic"));
                if (getActivity() != null) {
                    b.f325659a.a(getActivity().getIntent(), hashMap);
                }
            }
            VideoReport.setPageParams(view, new WinkDTParamBuilder().buildPageParams(hashMap, str));
        } else {
            VideoReport.setPageParams(view, new WinkDTParamBuilder().buildPageParams(getChildDaTongPageParams(), str));
        }
        QLog.i("FSBaseFragment", 1, "reportDaTongRegister subPage: " + getTAG() + ", pageId: " + tag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public Object createViewTagData() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> getChildDaTongPageParams() {
        return new HashMap();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public abstract String getTAG();

    public abstract String getPageId();

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public PartManager getPartManager() {
        if (this.mPartManager == null) {
            this.mPartManager = new PartManager(this, getView());
        }
        return this.mPartManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        if (c.P6()) {
            return !QQTheme.isNowThemeIsNight();
        }
        return super.isUseDarkTextStatusBar();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        QLog.d(getTAG(), 1, getTAG() + "->onAttach");
        super.onAttach(activity);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onAttachReport() {
        a.b(this);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateReport() {
        a.c(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateViewReport() {
        a.d(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCustomReport(int i3) {
        a.e(this, i3);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.d(getTAG(), 1, getTAG() + "->onDestroy");
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyReport() {
        a.f(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyViewReport() {
        a.g(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        QLog.d(getTAG(), 1, getTAG() + "->onDetach");
        super.onDetach();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onHiddenChangedReport(boolean z16) {
        a.h(this, z16);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        onPauseReport();
        super.onPause();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onPauseReport() {
        a.i(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        onResumeReport();
        super.onResume();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onResumeReport() {
        a.j(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        QLog.d(getTAG(), 1, getTAG() + "->onViewCreatedBeforePartInit");
        super.onViewCreatedBeforePartInit(view, bundle);
        qh(view);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onViewCreatedReport() {
        a.k(this);
    }

    public abstract String ph();

    protected void qh(View view) {
        HashMap hashMap;
        String str;
        if (getActivity() != null && getActivity().getIntent() != null) {
            hashMap = (HashMap) getActivity().getIntent().getSerializableExtra(QQWinkConstants.PUBLISH_EDIT_DATONG_DATA);
        } else {
            hashMap = null;
        }
        if (hashMap != null) {
            if (hashMap.get("xsj_operation_activity_id") != null) {
                WinkDatongCurrentParams.put("xsj_operation_activity_id", hashMap.get("xsj_operation_activity_id"));
            }
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, hashMap.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE));
        }
        try {
            str = WinkContext.INSTANCE.d().getDtParams().c();
        } catch (Exception e16) {
            w53.b.e("FSBaseFragment", e16);
            str = "0";
        }
        rh(view, str);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        QLog.d(getTAG(), 1, getTAG() + "->setUserVisibleHint:" + z16);
        super.setUserVisibleHint(z16);
    }
}
