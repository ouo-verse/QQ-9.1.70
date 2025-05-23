package com.tencent.mobileqq.studymode.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IStudyModeManager extends QRouteApi {
    public static final int NORMAL_MODE = 0;
    public static final int STUDY_MODE = 1;
    public static final String STUDY_MODE_ULR_FILTER_EQUAL = "com.tencent.mobileqq.studymode.url.filter.equal";
    public static final String STUDY_MODE_ULR_FILTER_PROCESS_NAME = "IStudyModeUrlFilterIpcClient";
    public static final String STUDY_MODE_ULR_FILTER_RESULT = "com.tencent.mobileqq.studymode.url.filter.result";
    public static final String STUDY_MODE_ULR_FILTER_RESULT_TIME = "com.tencent.mobileqq.studymode.url.filter.result.time";
    public static final String STUDY_MODE_URL_FILTER_PATH = "com.tencent.mobileqq.studymode.url.filter";
    public static final String STUDY_MODE_URL_FILTER_PATH_URL = "com.tencent.mobileqq.studymode.url.filter.url";
    public static final String STUDY_MODE_URL_FILTER_RESULT_FAIL = "com.tencent.mobileqq.studymode.url.filter.result.fail";
    public static final String STUDY_MODE_URL_FILTER_RESULT_SUC = "com.tencent.mobileqq.studymode.url.filter.result.suc";

    boolean getStudyModeSwitch();

    void onAccountChange();

    void openUrlFilterMainFragment(Context context, Intent intent);

    void registerStudyModeChangeListener(StudyModeChangeListener studyModeChangeListener);

    void registerStudyModeSetting();

    boolean studyMode9165Switch();

    boolean studyModeUrlFilterNeed();

    void unregisterStudyModeChangeListener(StudyModeChangeListener studyModeChangeListener);

    boolean urlFilterCheckedSupportOpen(String str);
}
