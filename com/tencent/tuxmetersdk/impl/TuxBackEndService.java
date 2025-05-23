package com.tencent.tuxmetersdk.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.export.injector.thread.ITuxThread;
import com.tencent.tuxmetersdk.model.GetConfigReq;
import com.tencent.tuxmetersdk.model.GetConfigRsp;
import com.tencent.tuxmetersdk.model.ITuxBackEndServiceApi;
import com.tencent.tuxmetersdk.model.InitReq;
import com.tencent.tuxmetersdk.model.InitRsp;
import com.tencent.tuxmetersdk.model.PersonalizedSurveyReq;
import com.tencent.tuxmetersdk.model.PersonalizedSurveyRsp;
import com.tencent.tuxmetersdk.model.Resource;
import com.tencent.tuxmetersdk.model.SurveyReportReq;
import com.tencent.tuxmetersdk.model.SurveyReportRsp;
import java.lang.reflect.Type;
import java.util.HashMap;
import retrofit2.ab;
import retrofit2.ac;
import retrofit2.f;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxBackEndService {
    static IPatchRedirector $redirector_;
    private final ac retrofit;
    private final TuxMeterSDKSetting setting;
    private final ITuxBackEndServiceApi tuxBackEndService;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ResourceDeserializer implements JsonDeserializer<Resource> {
        static IPatchRedirector $redirector_ = null;
        static final String COMPONENT_PARAMS_KEY = "component_params";
        static final String COMPONENT_TYPE_KEY = "component_type";

        ResourceDeserializer() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ ResourceDeserializer(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) anonymousClass1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
        @Override // com.google.gson.JsonDeserializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Resource deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject jsonObject;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Resource) iPatchRedirector.redirect((short) 2, this, jsonElement, type, jsonDeserializationContext);
            }
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            String asString = asJsonObject.has("url_of_param") ? asJsonObject.get("url_of_param").getAsString() : "";
            String asString2 = asJsonObject.has("id") ? asJsonObject.get("id").getAsString() : "";
            if (asJsonObject.has("location")) {
                JsonElement parse = new JsonParser().parse(asJsonObject.get("location").getAsString());
                if (parse != null && parse.isJsonObject()) {
                    jsonObject = parse.getAsJsonObject();
                    return new Resource(asString, asString2, jsonObject, !asJsonObject.has(COMPONENT_TYPE_KEY) ? asJsonObject.get(COMPONENT_TYPE_KEY).getAsInt() : 0, !asJsonObject.has(COMPONENT_PARAMS_KEY) ? (HashMap) new Gson().fromJson(asJsonObject.get(COMPONENT_PARAMS_KEY).getAsString(), new TypeToken<HashMap<String, String>>() { // from class: com.tencent.tuxmetersdk.impl.TuxBackEndService.ResourceDeserializer.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ResourceDeserializer.this);
                            }
                        }
                    }.getType()) : null);
                }
            }
            jsonObject = null;
            return new Resource(asString, asString2, jsonObject, !asJsonObject.has(COMPONENT_TYPE_KEY) ? asJsonObject.get(COMPONENT_TYPE_KEY).getAsInt() : 0, !asJsonObject.has(COMPONENT_PARAMS_KEY) ? (HashMap) new Gson().fromJson(asJsonObject.get(COMPONENT_PARAMS_KEY).getAsString(), new TypeToken<HashMap<String, String>>() { // from class: com.tencent.tuxmetersdk.impl.TuxBackEndService.ResourceDeserializer.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ResourceDeserializer.this);
                    }
                }
            }.getType()) : null);
        }
    }

    public TuxBackEndService(TuxMeterSDKSetting tuxMeterSDKSetting, ITuxThread iTuxThread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tuxMeterSDKSetting, (Object) iTuxThread);
            return;
        }
        this.setting = tuxMeterSDKSetting;
        ac d16 = new ac.b().b(getRequestUrl()).e(iTuxThread.getWorkExecutor()).a(buildGsonConverter()).d();
        this.retrofit = d16;
        this.tuxBackEndService = (ITuxBackEndServiceApi) d16.b(ITuxBackEndServiceApi.class);
    }

    private o45.a buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Resource.class, new ResourceDeserializer(null));
        return o45.a.f(gsonBuilder.create());
    }

    private String generateAuthHeader(String str) {
        return "Bearer " + str;
    }

    private String getRequestUrl() {
        return this.setting.getTuxDomainWithDefault().getDomainByEnvironment(this.setting.getEnvironment());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PersonalizedSurveyRsp getPersonalizedSurvey(PersonalizedSurveyReq personalizedSurveyReq) {
        PersonalizedSurveyRsp personalizedSurveyRsp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PersonalizedSurveyRsp) iPatchRedirector.redirect((short) 6, (Object) this, (Object) personalizedSurveyReq);
        }
        Integer num = null;
        try {
            ab<PersonalizedSurveyRsp> execute = this.tuxBackEndService.getPersonalizedSurvey(personalizedSurveyReq.getBusiness(), personalizedSurveyReq).execute();
            if (execute.d()) {
                personalizedSurveyRsp = execute.a();
            } else {
                int b16 = execute.b();
                String e16 = execute.e();
                PersonalizedSurveyRsp personalizedSurveyRsp2 = new PersonalizedSurveyRsp();
                try {
                    num = Integer.valueOf(b16);
                    personalizedSurveyRsp2.setCode(num);
                    personalizedSurveyRsp2.setMsg(e16);
                    personalizedSurveyRsp = personalizedSurveyRsp2;
                } catch (Exception unused) {
                    num = personalizedSurveyRsp2;
                    return num;
                }
            }
            return personalizedSurveyRsp;
        } catch (Exception unused2) {
        }
    }

    public void getSurveyConfig(GetConfigReq getConfigReq, f<GetConfigRsp> fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) getConfigReq, (Object) fVar);
        } else {
            this.tuxBackEndService.getConfig(getConfigReq.getBusiness(), getConfigReq).g(fVar);
        }
    }

    public void initSDK(InitReq initReq, f<InitRsp> fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) initReq, (Object) fVar);
        } else {
            this.tuxBackEndService.initSDK(initReq.getBusiness(), initReq).g(fVar);
        }
    }

    public void surveyReport(String str, String str2, SurveyReportReq surveyReportReq, f<SurveyReportRsp> fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, surveyReportReq, fVar);
        } else {
            this.tuxBackEndService.surveyReport(str, generateAuthHeader(str2), surveyReportReq).g(fVar);
        }
    }

    public void surveyReportPre(String str, String str2, SurveyReportReq surveyReportReq, f<SurveyReportRsp> fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, surveyReportReq, fVar);
        } else {
            this.tuxBackEndService.surveyReportPre(str, generateAuthHeader(str2), surveyReportReq).g(fVar);
        }
    }
}
