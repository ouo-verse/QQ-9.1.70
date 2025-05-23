package com.tencent.tuxmetersdk.model;

import retrofit2.d;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ITuxBackEndServiceApi {
    @POST("reach/{business}/getconfig")
    d<GetConfigRsp> getConfig(@Path("business") String str, @Body GetConfigReq getConfigReq);

    @POST("surveys/{business}/inapp")
    d<PersonalizedSurveyRsp> getPersonalizedSurvey(@Path("business") String str, @Body PersonalizedSurveyReq personalizedSurveyReq);

    @POST("reach/{business}/init")
    d<InitRsp> initSDK(@Path("business") String str, @Body InitReq initReq);

    @POST("surveys/{business}/upload")
    d<SurveyReportRsp> surveyReport(@Path("business") String str, @Header("Authorization") String str2, @Body SurveyReportReq surveyReportReq);

    @POST("surveys/{business}/preupload")
    d<SurveyReportRsp> surveyReportPre(@Path("business") String str, @Header("Authorization") String str2, @Body SurveyReportReq surveyReportReq);
}
