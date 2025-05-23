package com.tencent.mobileqq.profilecard.component.content;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileGuideApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.utils.ProfileAccountInfoUtils;
import com.tencent.mobileqq.profilecard.component.head.BaseProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.container.ElegantContentContainer;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileCardPhotoWallData;
import com.tencent.mobileqq.profilecard.widget.ElegantProfileContentTitleView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.relation.common.abtest.a;
import com.tencent.relation.common.config.toggle.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class ElegantProfileAddProfileComponent extends AbsQQProfileContentComponent implements View.OnClickListener {
    private static final String CONFIG_NOT_SHOW_COMPLETION_BAR = "1";
    private static final String CONFIG_SHOW_COMPLETION_BAR = "2";
    private static final String CONFIG_TIPS = "tips";
    private static final String CONFIG_TIPS_COVER = "cover";
    private static final String CONFIG_TIPS_PRIORITY = "tipsPriority";
    private static final String CONFIG_WEIGHT = "weight";
    private static final String TAG = "ElegantProfileAddProfileComponent";
    private boolean isCoverTips;
    private boolean isInitDtReport;
    private boolean isShowBar;
    private int mTopPriority;
    private String mTopPriorityTips;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class CompletionConfig {
        public String name;
        public double weight = 0.0d;
        public String tips = "";
        public int tipsPriority = -1;

        CompletionConfig() {
        }
    }

    public ElegantProfileAddProfileComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.isCoverTips = false;
        this.mTopPriority = Integer.MAX_VALUE;
        this.mTopPriorityTips = "";
        this.isInitDtReport = false;
        this.isShowBar = "2".equals(c.A.d("completeInfoStyle", "1"));
    }

    private int getCompleteValue(ProfileCardInfo profileCardInfo) {
        String d16 = c.A.d("completeInfoConfig", "");
        ArrayList<CompletionConfig> arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(d16);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                CompletionConfig completionConfig = new CompletionConfig();
                String str = (String) keys.next();
                completionConfig.name = str;
                JSONObject jSONObject2 = (JSONObject) jSONObject.get(str);
                if (jSONObject2.has("weight")) {
                    completionConfig.weight = jSONObject2.getDouble("weight") * 100.0d;
                }
                if (jSONObject2.has("tips")) {
                    completionConfig.tips = jSONObject2.getString("tips");
                }
                if (jSONObject2.has(CONFIG_TIPS_PRIORITY)) {
                    completionConfig.tipsPriority = jSONObject2.getInt(CONFIG_TIPS_PRIORITY);
                }
                arrayList.add(completionConfig);
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "[getCompleteValue] JSONEXCEPTION:", e16);
        }
        int i3 = 0;
        for (CompletionConfig completionConfig2 : arrayList) {
            if (getNeedAddWeight(profileCardInfo, completionConfig2)) {
                i3 = (int) (i3 + completionConfig2.weight);
                if (completionConfig2.tipsPriority == this.mTopPriority) {
                    this.mTopPriority = Integer.MAX_VALUE;
                }
            } else {
                int i16 = completionConfig2.tipsPriority;
                if (i16 > 0 && i16 < this.mTopPriority) {
                    this.mTopPriority = i16;
                    this.mTopPriorityTips = completionConfig2.tips;
                    this.isCoverTips = "cover".equals(completionConfig2.name);
                }
            }
        }
        return i3;
    }

    private HashMap<String, String> getReportParams() {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        if (this.isShowBar) {
            str = "2";
        } else {
            str = "1";
        }
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_COMPLETEFILE_VERSION, str);
        return hashMap;
    }

    private int getScreenWidth() {
        return this.mActivity.getResources().getDisplayMetrics().widthPixels;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView, com.tencent.mobileqq.profilecard.widget.ElegantProfileContentTitleView, VIEW] */
    private boolean makeOrRefreshUi(ProfileCardInfo profileCardInfo) {
        boolean z16 = true;
        boolean z17 = profileCardInfo.allInOne.f260789pa == 0;
        int completeValue = getCompleteValue(profileCardInfo);
        boolean z18 = z17 && completeValue < 100;
        if (!z18) {
            VIEW view = this.mViewContainer;
            if (view != 0) {
                ((View) view).setVisibility(8);
            } else {
                z16 = false;
            }
        } else {
            if (this.mViewContainer == 0) {
                ?? elegantProfileContentTitleView = new ElegantProfileContentTitleView(this.mActivity);
                elegantProfileContentTitleView.setIcon(this.mActivity.getResources().getDrawable(R.drawable.qui_homework));
                elegantProfileContentTitleView.setArrowEnable(true);
                elegantProfileContentTitleView.setMarginBottomEnable(false);
                TextView textView = new TextView(this.mActivity);
                textView.setText("\u53bb\u5b8c\u5584");
                textView.setTextSize(1, 12.0f);
                textView.setTextColor(this.mActivity.getResources().getColor(R.color.qui_common_text_link));
                elegantProfileContentTitleView.mTitleExtContainer.removeAllViews();
                elegantProfileContentTitleView.mTitleExtContainer.addView(textView);
                elegantProfileContentTitleView.setClickBgArea(true);
                elegantProfileContentTitleView.setContentContainerMarginBottomEnable(this.isShowBar);
                if (this.isShowBar) {
                    View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.h0_, (ViewGroup) null);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.u2w);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.u2v);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                    layoutParams.width = ((getScreenWidth() - ViewUtils.dip2px(16.0f)) * completeValue) / 100;
                    imageView.setLayoutParams(layoutParams);
                    textView2.setText(this.mTopPriorityTips);
                    elegantProfileContentTitleView.addContentView(inflate);
                }
                this.mViewContainer = elegantProfileContentTitleView;
                ((View) elegantProfileContentTitleView).setOnClickListener(this);
                updateItemTheme(null, elegantProfileContentTitleView.mTitleText, elegantProfileContentTitleView.mTitleIcon, null, null);
            } else {
                z16 = false;
            }
            VIEW view2 = this.mViewContainer;
            if (view2 instanceof ElegantProfileContentTitleView) {
                ((ElegantProfileContentTitleView) view2).setTitle("\u8d44\u6599\u5b8c\u6210\u5ea6" + completeValue + "%");
                TextView textView3 = (TextView) ((ElegantProfileContentTitleView) this.mViewContainer).findViewById(R.id.u2v);
                if (textView3 != null) {
                    textView3.setText(this.mTopPriorityTips);
                }
            }
            b bVar = new b(81, null);
            ((View) this.mViewContainer).setVisibility(0);
            ((View) this.mViewContainer).setTag(bVar);
        }
        this.isForceHide = !z18;
        updateDivider(z18);
        return z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onClickInner() {
        if (this.isCoverTips) {
            IComponent component = this.mComponentCenter.getComponent(1002);
            if (component instanceof BaseProfileHeaderComponent) {
                ((BaseProfileHeaderComponent) component).enterCustomCover();
                return;
            }
        }
        ((IProfileGuideApi) QRoute.api(IProfileGuideApi.class)).jumpProfileEditWithData(this.mApp, this.mActivity, (ProfileCardInfo) this.mData, null);
    }

    private void updateDivider(boolean z16) {
        IComponentCenter iComponentCenter = this.mComponentCenter;
        if (iComponentCenter == null) {
            return;
        }
        IComponent component = iComponentCenter.getComponent(103);
        if (component instanceof ElegantContentContainer) {
            ((ElegantContentContainer) component).updateDivider(IProfileContentKey.MAP_KEY_ADD_PROFILE, z16);
        }
    }

    private void updateIsShowBar() {
        if (c.A.g(false)) {
            return;
        }
        if (a.d("exp_qqprofile_homepage_ui", "exp_qqprofile_homepage_ui_B")) {
            this.isShowBar = true;
        } else if (a.d("exp_qqprofile_homepage_ui", "exp_qqprofile_homepage_ui_C")) {
            this.isShowBar = false;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1038;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_ADD_PROFILE;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        updateIsShowBar();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        VIEW view;
        boolean makeOrRefreshUi = makeOrRefreshUi(profileCardInfo) | super.lambda$checkValidComponent$3((ElegantProfileAddProfileComponent) profileCardInfo);
        if (makeOrRefreshUi && !this.isInitDtReport && (view = this.mViewContainer) != 0) {
            ProfileCardDtReportUtil.initElementWithExposureParams((View) view, ProfileCardDtReportUtil.DT_REPORT_COMPLETEFILE, getReportParams());
            this.isInitDtReport = true;
        }
        return makeOrRefreshUi;
    }

    private boolean getNeedAddWeight(ProfileCardInfo profileCardInfo, CompletionConfig completionConfig) {
        if (profileCardInfo == null || profileCardInfo.card == null || completionConfig == null) {
            return false;
        }
        String str = completionConfig.name;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1877395451:
                if (str.equals("educate")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1405959847:
                if (str.equals("avatar")) {
                    c16 = 1;
                    break;
                }
                break;
            case -1249512767:
                if (str.equals("gender")) {
                    c16 = 2;
                    break;
                }
                break;
            case -1210261252:
                if (str.equals(IProfileProtocolConst.KEY_PROFESSION)) {
                    c16 = 3;
                    break;
                }
                break;
            case -847914212:
                if (str.equals("photoWall")) {
                    c16 = 4;
                    break;
                }
                break;
            case -485238799:
                if (str.equals(IProfileProtocolConst.KEY_HOMETOWN)) {
                    c16 = 5;
                    break;
                }
                break;
            case 3343799:
                if (str.equals("mail")) {
                    c16 = 6;
                    break;
                }
                break;
            case 3381091:
                if (str.equals("nick")) {
                    c16 = 7;
                    break;
                }
                break;
            case 93746367:
                if (str.equals("birth")) {
                    c16 = '\b';
                    break;
                }
                break;
            case 94852023:
                if (str.equals("cover")) {
                    c16 = '\t';
                    break;
                }
                break;
            case 950484093:
                if (str.equals(IProfileProtocolConst.KEY_COMPANY)) {
                    c16 = '\n';
                    break;
                }
                break;
            case 1901043637:
                if (str.equals("location")) {
                    c16 = 11;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                if (TextUtils.isEmpty(ProfileAccountInfoUtils.getSchool(profileCardInfo))) {
                    return false;
                }
                break;
            case 1:
            case 7:
                break;
            case 2:
                if (ProfileAccountInfoUtils.getGender(profileCardInfo) != 0 && ProfileAccountInfoUtils.getGender(profileCardInfo) != 1) {
                    return false;
                }
                break;
            case 3:
                if (TextUtils.isEmpty(ProfileAccountInfoUtils.getProfession(profileCardInfo))) {
                    return false;
                }
                break;
            case 4:
                ProfileCardPhotoWallData profileCardPhotoWallData = (ProfileCardPhotoWallData) profileCardInfo.getBusinessInfo(ProfileCardPhotoWallData.class);
                if (profileCardPhotoWallData == null || profileCardPhotoWallData.getSize() <= 0) {
                    return false;
                }
                break;
            case 5:
                if (TextUtils.isEmpty(ProfileAccountInfoUtils.getHometown(profileCardInfo))) {
                    return false;
                }
                break;
            case 6:
                if (TextUtils.isEmpty(ProfileAccountInfoUtils.getEmail(profileCardInfo))) {
                    return false;
                }
                break;
            case '\b':
                if (ProfileAccountInfoUtils.getBirthday(profileCardInfo) == 0) {
                    return false;
                }
                break;
            case '\t':
                return !profileCardInfo.card.isNoCover();
            case '\n':
                if (TextUtils.isEmpty(ProfileAccountInfoUtils.getCompany(profileCardInfo))) {
                    return false;
                }
                break;
            case 11:
                if (TextUtils.isEmpty(ProfileAccountInfoUtils.getLocationCity(profileCardInfo)) && TextUtils.isEmpty(ProfileAccountInfoUtils.getLocationCountry(profileCardInfo)) && TextUtils.isEmpty(ProfileAccountInfoUtils.getLocationProvince(profileCardInfo))) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && ((b) view.getTag()).f260135a == 81) {
            onClickInner();
            VideoReport.reportEvent("clck", this.mViewContainer, getReportParams());
        }
    }
}
