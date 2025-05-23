package com.tencent.tuxmetersdk.export.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import com.tencent.tuxmetersdk.impl.event.TuxEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class EventErrorHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String EVENT_ERROR_EVENT_CODE = "tux_event_code";
    public static final String EVENT_ERROR_EVENT_PARAMS = "tux_event_params";
    public static final String EVENT_ERROR_MSG = "tux_error_msg";

    public EventErrorHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void realReport(EventErrorCode eventErrorCode, ITuxSurveyEventCallback iTuxSurveyEventCallback, List<TuxEvent> list, TuxSurveyConfig tuxSurveyConfig, Map<String, String> map) {
        TuxEvent tuxEvent;
        if (iTuxSurveyEventCallback != null && list != null) {
            try {
                if (!list.isEmpty()) {
                    tuxEvent = list.get(0);
                } else {
                    tuxEvent = null;
                }
                HashMap hashMap = new HashMap();
                if (map != null) {
                    hashMap.putAll(map);
                }
                if (tuxEvent != null) {
                    hashMap.put(EVENT_ERROR_EVENT_CODE, tuxEvent.getEventCode());
                    hashMap.put(EVENT_ERROR_EVENT_PARAMS, tuxEvent.getParamsOfJson());
                }
                iTuxSurveyEventCallback.onEventErrorCode(eventErrorCode, hashMap, tuxSurveyConfig);
            } catch (Exception unused) {
            }
        }
    }

    public static void reportEventException(ITuxSurveyEventCallback iTuxSurveyEventCallback, TuxEvent tuxEvent, TuxSurveyConfig tuxSurveyConfig, String str) {
        if (iTuxSurveyEventCallback != null && tuxEvent != null && str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(EVENT_ERROR_MSG, str);
            realReport(EventErrorCode.EVENT_EXCEPTION, iTuxSurveyEventCallback, Collections.singletonList(tuxEvent), tuxSurveyConfig, hashMap);
        }
    }

    public static void reportEventExposed(ITuxSurveyEventCallback iTuxSurveyEventCallback, List<TuxEvent> list, TuxSurveyConfig tuxSurveyConfig) {
        realReport(EventErrorCode.EVENT_EXPOSED, iTuxSurveyEventCallback, list, tuxSurveyConfig, null);
    }

    public static void reportEventInSilent(ITuxSurveyEventCallback iTuxSurveyEventCallback, List<TuxEvent> list, TuxSurveyConfig tuxSurveyConfig) {
        realReport(EventErrorCode.EVENT_IN_SILENT, iTuxSurveyEventCallback, list, tuxSurveyConfig, null);
    }

    public static void reportEventSatisfiedFailed(ITuxSurveyEventCallback iTuxSurveyEventCallback, List<TuxEvent> list, TuxSurveyConfig tuxSurveyConfig) {
        realReport(EventErrorCode.EVENT_SATISFIED_FAILED, iTuxSurveyEventCallback, list, tuxSurveyConfig, null);
    }

    public static void reportEventWaiting(ITuxSurveyEventCallback iTuxSurveyEventCallback, List<TuxEvent> list, TuxSurveyConfig tuxSurveyConfig) {
        realReport(EventErrorCode.EVENT_WAIT_FOR_RSP, iTuxSurveyEventCallback, list, tuxSurveyConfig, null);
    }

    public static void reportEventsException(ITuxSurveyEventCallback iTuxSurveyEventCallback, List<TuxEvent> list, TuxSurveyConfig tuxSurveyConfig, String str) {
        if (iTuxSurveyEventCallback != null && list != null && str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(EVENT_ERROR_MSG, str);
            realReport(EventErrorCode.EVENT_EXCEPTION, iTuxSurveyEventCallback, list, tuxSurveyConfig, hashMap);
        }
    }
}
