package com.tencent.autotemplate.model.rhythm;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.tencent.autotemplate.model.TAVEffectAutomaticEffect;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVRhythmEffects {
    static IPatchRedirector $redirector_;

    @SerializedName("highlightEffects")
    private List<TAVEffectAutomaticEffect> highlightEffects;

    @SerializedName("rhythmEffectID")
    private String rhythmEffectID;

    @SerializedName("secondEffects")
    private List<List<TAVEffectAutomaticEffect>> secondEffects;

    @SerializedName(JsonUtils.KEY_TRANSITIONS)
    private List<TAVTransitionAutomaticEffect> transitions;

    public TAVRhythmEffects() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.highlightEffects = new ArrayList();
        this.secondEffects = new ArrayList();
        this.transitions = new ArrayList();
    }

    public List<TAVEffectAutomaticEffect> getHighlightEffects() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.highlightEffects;
    }

    public String getRhythmEffectID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.rhythmEffectID;
    }

    public List<List<TAVEffectAutomaticEffect>> getSecondEffects() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.secondEffects;
    }

    public List<TAVTransitionAutomaticEffect> getTransitions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.transitions;
    }

    public void setFileDir(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (!CollectionUtil.isEmptyList(this.highlightEffects)) {
            Iterator<TAVEffectAutomaticEffect> it = this.highlightEffects.iterator();
            while (it.hasNext()) {
                it.next().setFileDir(str);
            }
        }
        if (!CollectionUtil.isEmptyList(this.secondEffects)) {
            Iterator<List<TAVEffectAutomaticEffect>> it5 = this.secondEffects.iterator();
            while (it5.hasNext()) {
                Iterator<TAVEffectAutomaticEffect> it6 = it5.next().iterator();
                while (it6.hasNext()) {
                    it6.next().setFileDir(str);
                }
            }
        }
        if (!CollectionUtil.isEmptyList(this.transitions)) {
            Iterator<TAVTransitionAutomaticEffect> it7 = this.transitions.iterator();
            while (it7.hasNext()) {
                it7.next().setFileDir(str);
            }
        }
    }

    public void setHighlightEffects(List<TAVEffectAutomaticEffect> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.highlightEffects = list;
        }
    }

    public void setSecondEffects(List<List<TAVEffectAutomaticEffect>> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else {
            this.secondEffects = list;
        }
    }

    public void setTransitions(@NonNull List<TAVTransitionAutomaticEffect> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
        } else {
            this.transitions = list;
        }
    }
}
