package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.deserializer.RoutePlanningStepDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class RoutePlanningObject extends BaseObject {
    static IPatchRedirector $redirector_;

    /* loaded from: classes7.dex */
    public static final class Step extends JsonComposer {
        static IPatchRedirector $redirector_;
        public String accessorial_desc;
        public String act_desc;
        public String dir_desc;
        public float distance;
        public String instruction;

        @Json(deserializer = RoutePlanningStepDeserializer.class)
        public List<Integer> polyline_idx;
        public String road_name;
        public int type;

        public Step() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public RoutePlanningObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
