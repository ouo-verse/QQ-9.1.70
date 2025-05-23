package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class DistanceMatrixResultObject extends BaseObject {
    static IPatchRedirector $redirector_;
    public DistanceMatrixResult result;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class DistanceMatrixResult extends JsonComposer {
        static IPatchRedirector $redirector_;
        public List<RowResult> rows;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class RowResult extends JsonComposer {
            static IPatchRedirector $redirector_;
            public List<DistanceElement> elements;

            /* compiled from: P */
            /* loaded from: classes7.dex */
            public static final class DistanceElement extends JsonComposer {
                static IPatchRedirector $redirector_;
                public int distance;
                public int duration;
                public int status;

                public DistanceElement() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }
            }

            public RowResult() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public DistanceMatrixResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public DistanceMatrixResultObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
