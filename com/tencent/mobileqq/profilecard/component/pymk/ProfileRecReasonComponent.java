package com.tencent.mobileqq.profilecard.component.pymk;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001'B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0014H\u0002J\u0012\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u001c\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010%\u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010&\u001a\u00020\u001bH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/profilecard/component/pymk/ProfileRecReasonComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileContentComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "reasonText", "Landroid/widget/TextView;", "getReasonText", "()Landroid/widget/TextView;", "setReasonText", "(Landroid/widget/TextView;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "getComponentName", "", "getComponentType", "", "getProfileContentKey", "getReason", "data", "initDTReport", "", "reason", "initView", "isInExperiment", "", "onCreate", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseActivity;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onDataUpdate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Companion", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public class ProfileRecReasonComponent extends AbsProfileContentComponent {
    public static final String EM_PYMK_RECOMMEND_REASON = "em_pymk_recommend_reason";
    private static final String EXP_NAME = "exp_pymk_profile_reasons";
    private static final String EXP_NAME_NO_REASON = "exp_pymk_profile_reasons_0";
    private static final String EXP_NAME_REASON = "exp_pymk_profile_reasons_1";
    public static final String KEY_PYMK_RECOMMEND_REASON = "pymk_recommend_reason";
    public static final String TAG = "ProfileRecReasonComponent";
    private static String currentUserUin;
    private static ExpEntityInfo expInfo;
    private TextView reasonText;
    private View rootView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileRecReasonComponent(IComponentCenter componentCenter, ProfileCardInfo cardInfo) {
        super(componentCenter, cardInfo);
        Intrinsics.checkNotNullParameter(componentCenter, "componentCenter");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initDTReport(String reason) {
        View view = (View) this.mViewContainer;
        if (view != null) {
            VideoReport.setElementId(view, EM_PYMK_RECOMMEND_REASON);
            VideoReport.setElementParam(view, KEY_PYMK_RECOMMEND_REASON, reason);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        }
    }

    private final boolean isInExperiment() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "null";
        }
        if (!Intrinsics.areEqual(currentAccountUin, currentUserUin) || expInfo == null) {
            QLog.i(TAG, 1, "get exp exp_pymk_profile_reasons and report current " + currentAccountUin);
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(EXP_NAME);
            expInfo = expEntity;
            if (expEntity != null) {
                expEntity.reportExpExposure();
            }
            currentUserUin = currentAccountUin;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("experiment ");
        ExpEntityInfo expEntityInfo = expInfo;
        sb5.append(expEntityInfo != null ? expEntityInfo.getAssignment() : null);
        QLog.i(TAG, 1, sb5.toString());
        ExpEntityInfo expEntityInfo2 = expInfo;
        if (expEntityInfo2 != null) {
            return Intrinsics.areEqual(expEntityInfo2.getAssignment(), EXP_NAME_REASON);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1051;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_PYMK_REASON_DATA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView getReasonText() {
        return this.reasonText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View getRootView() {
        return this.rootView;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View, VIEW] */
    public void initView(String reason) {
        QBaseActivity qBaseActivity;
        if (this.rootView == null && (qBaseActivity = this.mActivity) != null) {
            View inflate = LayoutInflater.from(qBaseActivity).inflate(R.layout.czi, (ViewGroup) null);
            this.rootView = inflate;
            this.reasonText = inflate != null ? (TextView) inflate.findViewById(R.id.owg) : null;
        }
        TextView textView = this.reasonText;
        if (textView != null) {
            textView.setText("\u53ef\u80fd\u8ba4\u8bc6\u7684\u4eba\uff1a" + reason);
        }
        this.mViewContainer = this.rootView;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity activity, Bundle savedInstanceState) {
        super.onCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setReasonText(TextView textView) {
        this.reasonText = textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setRootView(View view) {
        this.rootView = view;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo data) {
        super.lambda$checkValidComponent$3((ProfileRecReasonComponent) data);
        if ((data != null ? data.card : null) == null) {
            return true;
        }
        String reason = getReason(data);
        if (TextUtils.isEmpty(reason)) {
            return true;
        }
        initView(reason);
        if (reason != null) {
            initDTReport(reason);
        }
        return true;
    }

    private final String getReason(ProfileCardInfo data) {
        String uid;
        AllInOne allInOne = data != null ? data.allInOne : null;
        if (allInOne == null) {
            return null;
        }
        if (!TextUtils.isEmpty(allInOne.uid)) {
            uid = allInOne.uid;
        } else {
            uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(allInOne.uin);
        }
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        if (iFriendsInfoService.isFriend(uid, TAG)) {
            QLog.i(TAG, 1, "getReason fail because is friend  " + allInOne.uin);
            return null;
        }
        Bundle bundle = allInOne.extras;
        String string = bundle != null ? bundle.getString("recommend_reason") : null;
        if (string == null) {
            string = "";
        }
        if (!TextUtils.isEmpty(string)) {
            if (isInExperiment()) {
                return string;
            }
            QLog.i(TAG, 1, "getReason fail because not exp " + allInOne.uin);
            return null;
        }
        QLog.i(TAG, 1, "getReason fail because no reason " + allInOne.uin);
        return null;
    }
}
