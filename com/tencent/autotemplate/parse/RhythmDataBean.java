package com.tencent.autotemplate.parse;

import com.google.gson.annotations.SerializedName;
import com.tencent.autotemplate.model.rhythm.TAVEffectPoint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RhythmDataBean {
    static IPatchRedirector $redirector_;

    @SerializedName("allData")
    public List<PackedEffectPoints> allData;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class PackedEffectPoints {
        static IPatchRedirector $redirector_;

        @SerializedName("effectPoints")
        public List<TAVEffectPoint> effectPoints;

        @SerializedName("name")
        public String name;

        public PackedEffectPoints() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public List<TAVEffectPoint> getEffectPoints() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.effectPoints;
        }

        public String getName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.name;
        }

        public void setEffectPoints(List<TAVEffectPoint> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            } else {
                this.effectPoints = list;
            }
        }

        public void setName(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                this.name = str;
            }
        }
    }

    public RhythmDataBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public List<PackedEffectPoints> getAllData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.allData;
    }

    public void setAllData(List<PackedEffectPoints> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        } else {
            this.allData = list;
        }
    }
}
