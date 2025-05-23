package com.tencent.mobileqq.wink.publish.fs.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.event.WinkPublishInitializationCompletedEvent;
import com.tencent.mobileqq.wink.pubcover.w;
import com.tencent.mobileqq.wink.publish.base.PublishBaseFragment;
import com.tencent.mobileqq.wink.publish.fs.activity.FSUploadActivityFragment;
import com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishTagViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.report.PublishActivityErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import j93.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import uq3.c;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, scene = QQPermissionConstants.Business.SCENE.CIRCLE_PUBLISH_UPLOAD)
/* loaded from: classes21.dex */
public class FSUploadActivityFragment extends PublishBaseFragment {
    public static final String I = UploadConstants.TAG + "FSUploadActivityFragment";
    private View C;
    private PublishViewModel D;
    private PartsStateViewModel E;
    public String F = "";
    private long G;
    private boolean H;

    private boolean isFromDailySign() {
        if (getActivity() == null || getActivity().getIntent() == null || getActivity().getIntent().getIntExtra(QQWinkConstants.PUBLISH_ENTRANCE, -1) != 7) {
            return false;
        }
        return true;
    }

    private boolean isZShowTemplate() {
        MetaMaterial metaMaterial;
        String str;
        if (getActivity() == null || getActivity().getIntent() == null || (metaMaterial = (MetaMaterial) getActivity().getIntent().getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL)) == null || (str = metaMaterial.additionalFields.get(QQWinkConstants.ZSHOW_MATERIAL_SCENE_KEY)) == null) {
            return false;
        }
        return str.equals(QQWinkConstants.BUSINESS_ZSHOW_NAME);
    }

    private void th() {
        HashMap hashMap;
        if (this.D != null && getActivity() != null && getActivity().getIntent() != null && (hashMap = (HashMap) getActivity().getIntent().getSerializableExtra("key_attrs")) != null) {
            this.D.Q = (String) hashMap.get(QCircleScheme.AttrQQPublish.MINI_GAME_ID);
            this.D.R = (String) hashMap.get(QCircleScheme.AttrQQPublish.BUSINESS_TASK_NAME);
            this.D.S = (String) hashMap.get(QCircleScheme.AttrQQPublish.BUSINESS_TASK_SHOW_BACK_DIALOG);
            this.D.T = (String) hashMap.get("target");
            this.D.U = (String) hashMap.get("taskid");
        }
    }

    private void uh() {
        String str = I;
        QLog.d(str, 1, "initViewModelData...activity: " + getActivity());
        if (getActivity() == null) {
            QLog.e(str, 1, "initViewModelData activity is null");
            return;
        }
        if (this.D == null) {
            this.D = (PublishViewModel) getViewModel(PublishViewModel.class);
        }
        if (this.E == null) {
            this.E = (PartsStateViewModel) getViewModel(PartsStateViewModel.class);
        }
        this.D.w2(getActivity().getIntent(), false);
        PublishTagViewModel publishTagViewModel = (PublishTagViewModel) getViewModel(PublishTagViewModel.class);
        publishTagViewModel.W1(getActivity().getIntent());
        this.F = publishTagViewModel.getTagsJoinedFromIntent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit vh(WinkDc5507ReportData.a aVar) {
        aVar.b(1005);
        aVar.j(1);
        return null;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        uh();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return new ArrayList();
        }
        return a.INSTANCE.a(activity.getIntent()).c(activity.getIntent());
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment
    protected Map<String, Object> getChildDaTongPageParams() {
        Map<String, Object> childDaTongPageParams = super.getChildDaTongPageParams();
        childDaTongPageParams.put("xsj_operation_activity_id", WinkDatongCurrentParams.get("xsj_operation_activity_id"));
        childDaTongPageParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE));
        childDaTongPageParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME));
        childDaTongPageParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_ZPLAN_AR_TYPE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_ZPLAN_AR_TYPE));
        if (WinkDatongCurrentParams.contains(WinkDaTongReportConstant.ElementParamKey.XSJ_LIVE_AVATAR_ENTRANCE)) {
            childDaTongPageParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LIVE_AVATAR_ENTRANCE, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_LIVE_AVATAR_ENTRANCE));
        }
        childDaTongPageParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_EMOTION, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_EMOTION));
        childDaTongPageParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_EMOTION_NAME, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_EMOTION_NAME));
        Object obj = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_CUSTOM_TEXT);
        if (obj instanceof Integer) {
            childDaTongPageParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_CUSTOM_TEXT, obj);
            if (((Integer) obj).intValue() == 1) {
                childDaTongPageParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CUSTOM_TEXT_WORDNUMBER, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CUSTOM_TEXT_WORDNUMBER));
            } else {
                childDaTongPageParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PRESET_TEXT_ID, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_PRESET_TEXT_ID));
            }
        }
        Object obj2 = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_CUSTOM_BACKGROUND);
        if (obj2 instanceof Integer) {
            childDaTongPageParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_USE_CUSTOM_BACKGROUND, obj2);
            if (((Integer) obj2).intValue() == 0) {
                childDaTongPageParams.put("xsj_background_id", WinkDatongCurrentParams.get("xsj_background_id"));
            }
        }
        return childDaTongPageParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.guh;
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return I;
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment
    public String getPageId() {
        return WinkDaTongReportConstant.PageId.PG_XSJ_PUBLISH_NEW_PAGE;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.G = System.currentTimeMillis();
        this.H = true;
        if (getActivity() != null) {
            getActivity().getWindow().setSoftInputMode(3);
            getActivity().getWindow().setSoftInputMode(32);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        WinkContext.INSTANCE.d().m().j(getActivity(), getArguments());
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), getActivity().getWindow());
        QLog.d(AECameraConstants.TAG + I, 1, "[onCreate...] + END, time cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        QLog.d(AECameraConstants.TAG + I, 1, "[onCreateView...] + END, time cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PublishViewModel publishViewModel = this.D;
        if (publishViewModel != null) {
            publishViewModel.onCleared();
        }
        w.f325612a.a();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        QLog.d(I, 1, "onNewIntent...");
        getActivity().setIntent(intent);
        if (this.D == null) {
            this.D = (PublishViewModel) getViewModel(PublishViewModel.class);
        }
        if (this.E == null) {
            this.E = (PartsStateViewModel) getViewModel(PartsStateViewModel.class);
        }
        this.D.w2(getActivity().getIntent(), true);
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        super.onPause();
        QLog.d(AECameraConstants.TAG + I, 1, "[onPause...] + END, time cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        m93.a.f416460b.a(i3, strArr, iArr);
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Intent intent = null;
        try {
            if (this.H) {
                this.H = false;
                this.G = System.currentTimeMillis() - this.G;
                com.tencent.mobileqq.wink.publish.a.d(com.tencent.mobileqq.wink.publish.a.b(getActivity().getIntent()), QCirclePublishQualityReporter.P_PUBLISH_ACTIVITY_RESUME_COST_TIME, new PublishActivityErrorCode(0L, null), this.G, com.tencent.mobileqq.wink.publish.a.c(getActivity().getIntent()), "");
            }
        } catch (Exception e16) {
            QLog.e(I, 1, "WinkPublishReport failed", e16);
        }
        if (getActivity() != null) {
            intent = getActivity().getIntent();
        }
        t53.a.b(intent, t53.a.f435443a.d(), new Function1() { // from class: l93.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vh5;
                vh5 = FSUploadActivityFragment.vh((WinkDc5507ReportData.a) obj);
                return vh5;
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        QLog.d(I, 1, "onSaveInstanceState...");
        PublishViewModel publishViewModel = this.D;
        if (publishViewModel != null && publishViewModel.v2()) {
            PublishViewModel publishViewModel2 = this.D;
            if (!publishViewModel2.f326001c0 && publishViewModel2.f326018r0 != 3 && !isZShowTemplate() && !isFromDailySign() && this.D.I.getValue() != null && !this.D.I.getValue().booleanValue()) {
                this.D.t3(this, 5);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        long currentTimeMillis = System.currentTimeMillis();
        super.onStart();
        QLog.d(AECameraConstants.TAG + I, 1, "[onStart...] + END, time cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.C = view.findViewById(R.id.f58452q2);
        if (c.Q6()) {
            View view2 = this.C;
            view2.setPadding(view2.getPaddingLeft(), ViewUtils.dip2px(8.0f), this.C.getPaddingRight(), this.C.getPaddingBottom());
        }
        th();
        SimpleEventBus.getInstance().dispatchEvent(new WinkPublishInitializationCompletedEvent(), true);
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        if (ImmersiveUtils.isSupporImmersive() == 1 && getActivity() != null) {
            ImmersiveUtils.setStatusTextColor(isUseDarkTextStatusBar(), getActivity().getWindow());
        }
        if (needAdjustImmersive()) {
            RFWThemeUtil.setNavigationBarColor(getActivity(), view.getContext().getColor(R.color.qui_common_bg_bottom_light));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        QLog.d(I, 1, "onViewStateRestored...");
    }

    @Override // com.tencent.mobileqq.wink.publish.base.PublishBaseFragment
    public String ph() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            return getActivity().getIntent().getStringExtra("xsj_ref_pgid");
        }
        return "";
    }
}
