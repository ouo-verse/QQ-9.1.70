package com.tencent.mobileqq.profilecard.utils;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.richframework.widget.listview.card.RFWCardExtension;
import com.tencent.biz.richframework.widget.listview.card.api.IRFWCardReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.StrongSimilarityData;
import com.tencent.mobileqq.profilecard.component.instep.ProfileInStepCardModel;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes35.dex */
public class ProfileInStepReportHelper {
    private static final String ADD_FRIEND_BUTTON_ELEMENT_ID = "em_profile_inside_addfriend_button";
    private static final String BUBBLE_TIPS_ELEMENT_ID = "em_profile_relation_strong";
    private static final String FULLSCREEN_CARD_ELEMENT_ID = "em_profile_infeatures_card";
    private static final String FULLSCREEN_PAGE_ID = "pg_user_profile_infeatures";
    private static final String MODULE_ELEMENT_ID = "em_profile_relation";
    private static final String NORMAL_CARD_ELEMENT_ID = "em_profile_features";
    private static final String PARAM_KEY_BUBBLE_CONTENT = "relation_content";
    private static final String PARAM_KEY_BUBBLE_EXP_TIME = "exposure_time";
    private static final String PARAM_KEY_FEATURE_NUM = "features_number";
    private static final String PARAM_KEY_FIRST_LEVEL_FEATURE_POSITION = "features_position";
    private static final String PARAM_KEY_FIRST_LEVEL_FEATURE_TITLE = "features_id";
    private static final String PARAM_KEY_SECOND_LEVEL_FEATURE_TITLE = "infeatures_id";
    private static final String PARAM_KEY_TAB_NAME = "tab_id";
    private static final String PARAM_KEY_TAB_VERSION = "tab_edition_id";

    public static void registerInStepElement(View view, int i3) {
        VideoReport.setElementId(view, MODULE_ELEMENT_ID);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_KEY_FEATURE_NUM, String.valueOf(i3));
        hashMap.put("tab_id", "exp_qqprofile_relation");
        hashMap.put(PARAM_KEY_TAB_VERSION, com.tencent.relation.common.abtest.a.b("exp_qqprofile_relation").getAssignment());
        VideoReport.setElementParams(view, hashMap);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    public static void reportBubbleTipsExpose(View view) {
        VideoReport.reportEvent("imp", view, null);
    }

    public static void initQUICardReport(RFWCardExtension rFWCardExtension, final List<ProfileInStepCardModel> list) {
        if (rFWCardExtension == null) {
            return;
        }
        rFWCardExtension.setReport(new IRFWCardReport() { // from class: com.tencent.mobileqq.profilecard.utils.ProfileInStepReportHelper.1
            public void onActionButtonElementRegister(View view) {
                VideoReport.setElementId(view, ProfileInStepReportHelper.ADD_FRIEND_BUTTON_ELEMENT_ID);
                VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            }

            @Override // com.tencent.biz.richframework.widget.listview.card.api.IRFWCardReport
            public void onFullScreenPageRegister(View view) {
                VideoReport.setPageId(view, ProfileInStepReportHelper.FULLSCREEN_PAGE_ID);
                HashMap hashMap = new HashMap();
                hashMap.put("tab_id", "exp_qqprofile_relation");
                hashMap.put(ProfileInStepReportHelper.PARAM_KEY_TAB_VERSION, com.tencent.relation.common.abtest.a.b("exp_qqprofile_relation").getAssignment());
                VideoReport.setPageParams(view, new PageParams(hashMap));
            }

            @Override // com.tencent.biz.richframework.widget.listview.card.api.IRFWCardReport
            public void onViewClick(View view) {
                VideoReport.reportEvent("clck", view, null);
            }

            @Override // com.tencent.biz.richframework.widget.listview.card.api.IRFWCardReport
            public void onFullScreenCardElementRegister(View view, int i3) {
                if (i3 < 0) {
                    return;
                }
                VideoReport.setElementId(view, ProfileInStepReportHelper.FULLSCREEN_CARD_ELEMENT_ID);
                HashMap hashMap = new HashMap();
                List list2 = list;
                if (list2 != null && i3 < list2.size()) {
                    ProfileInStepCardModel profileInStepCardModel = (ProfileInStepCardModel) list.get(i3);
                    hashMap.put(ProfileInStepReportHelper.PARAM_KEY_FIRST_LEVEL_FEATURE_TITLE, profileInStepCardModel.title);
                    hashMap.put(ProfileInStepReportHelper.PARAM_KEY_SECOND_LEVEL_FEATURE_TITLE, generateSubTitle(profileInStepCardModel.subTitles));
                }
                VideoReport.setElementParams(view, hashMap);
                VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            }

            @Override // com.tencent.biz.richframework.widget.listview.card.api.IRFWCardReport
            public void onNormalCardElementRegister(View view, int i3) {
                if (i3 < 0) {
                    return;
                }
                VideoReport.setElementId(view, ProfileInStepReportHelper.NORMAL_CARD_ELEMENT_ID);
                HashMap hashMap = new HashMap();
                List list2 = list;
                if (list2 != null && i3 < list2.size()) {
                    hashMap.put(ProfileInStepReportHelper.PARAM_KEY_FIRST_LEVEL_FEATURE_TITLE, ((ProfileInStepCardModel) list.get(i3)).title);
                    hashMap.put(ProfileInStepReportHelper.PARAM_KEY_FIRST_LEVEL_FEATURE_POSITION, String.valueOf(i3));
                }
                VideoReport.setElementParams(view, hashMap);
                VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            }

            private String generateSubTitle(List<String> list2) {
                int size = list2 == null ? 0 : list2.size();
                if (size == 0) {
                    return "";
                }
                StringBuilder sb5 = new StringBuilder(list2.get(0));
                for (int i3 = 1; i3 < size; i3++) {
                    sb5.append(";");
                    sb5.append(list2.get(i3));
                }
                return sb5.toString();
            }
        });
    }

    public static void registerBubbleTipsElement(Activity activity, View view, StrongSimilarityData strongSimilarityData) {
        View findViewById;
        if (activity == null || (findViewById = activity.findViewById(R.id.f28060hx)) == null) {
            return;
        }
        VideoReport.setLogicParent(view, findViewById);
        VideoReport.setElementId(view, BUBBLE_TIPS_ELEMENT_ID);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_KEY_BUBBLE_CONTENT, strongSimilarityData.content);
        hashMap.put(PARAM_KEY_BUBBLE_EXP_TIME, String.valueOf(strongSimilarityData.displayDuration));
        VideoReport.setElementParams(view, hashMap);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }
}
