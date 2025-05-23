package com.tencent.tuxmetersdk.export.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxSurveyEvent {
    static IPatchRedirector $redirector_;
    public static String AFTER_TRIGGER;
    public static String ANSWER_DURATION;
    public static String BEFORE_TRIGGER;
    public static String CALL_BACKEND_API;
    public static String CLICK;
    public static String DELAY_DELIVER;
    public static String DELIVER_WHEN_TRIGGER;
    public static String DISAPPEAR;
    public static String EXPOSE;
    public static String HALF_FLOATING_LAYER_DISAPPEAR;
    public static String HALF_FLOATING_LAYER_EXPOSE;
    public static String PARSE_FAIL;
    public static String PRE_SUBMIT;
    public static String PROCESS_RULE;
    public static String SUBMIT;
    public static String TUX_EVENT_ERROR_CODE;
    public static String TUX_EVENT_PERMANENT;
    public static String TUX_EXT_INFO;
    public static String TUX_RESET_CONTROL;
    public static String TUX_SURVEY_EVENT_ERROR;
    public static String TUX_SURVEY_ON_TRIGGER;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7630);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        PARSE_FAIL = "tux_survey_parse_fail";
        BEFORE_TRIGGER = "tux_survey_before_trigger";
        DELIVER_WHEN_TRIGGER = "tux_survey_deliver_when_trigger";
        CALL_BACKEND_API = "tux_call_backend_api";
        PROCESS_RULE = "tux_survey_process_rule";
        DELAY_DELIVER = "tux_delay_deliver";
        AFTER_TRIGGER = "tux_survey_trigger";
        EXPOSE = "tux_survey_expose";
        CLICK = "tux_survey_click";
        PRE_SUBMIT = "tux_survey_pre_submit";
        SUBMIT = "tux_survey_submit";
        DISAPPEAR = "tux_survey_disappear";
        ANSWER_DURATION = "tux_survey_answer_duration";
        HALF_FLOATING_LAYER_EXPOSE = "tux_survey_half_floating_layer_expose";
        HALF_FLOATING_LAYER_DISAPPEAR = "tux_survey_half_floating_layer_disappear";
        TUX_RESET_CONTROL = "tux_reset_control";
        TUX_SURVEY_ON_TRIGGER = "tux_survey_on_trigger";
        TUX_SURVEY_EVENT_ERROR = "tux_survey_event_error";
        TUX_EXT_INFO = "ext_info";
        TUX_EVENT_ERROR_CODE = "event_error_code";
        TUX_EVENT_PERMANENT = "tux_event_permanent";
    }

    public TuxSurveyEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
