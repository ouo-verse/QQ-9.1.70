package com.tencent.autotemplate.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVEffectsModel {
    static IPatchRedirector $redirector_;

    @SerializedName("filters")
    public List<TAVEffectAutomaticEffect> filterEffects;

    @SerializedName("lyricsStyles")
    public List<TAVEffectAutomaticEffect> lyricsStyles;

    @SerializedName(JsonUtils.KEY_OVERLAYS)
    public List<TAVEffectAutomaticEffect> overlayEffects;

    @SerializedName("painting")
    public List<TAVEffectAutomaticEffect> paintings;

    @SerializedName("text")
    public List<TAVEffectAutomaticEffect> textStickers;

    public TAVEffectsModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void setAllFileDir(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (!CollectionUtil.isEmptyList(this.filterEffects)) {
            Iterator<TAVEffectAutomaticEffect> it = this.filterEffects.iterator();
            while (it.hasNext()) {
                it.next().fileDir = str;
            }
        }
        if (!CollectionUtil.isEmptyList(this.overlayEffects)) {
            Iterator<TAVEffectAutomaticEffect> it5 = this.overlayEffects.iterator();
            while (it5.hasNext()) {
                it5.next().fileDir = str;
            }
        }
        if (!CollectionUtil.isEmptyList(this.lyricsStyles)) {
            Iterator<TAVEffectAutomaticEffect> it6 = this.lyricsStyles.iterator();
            while (it6.hasNext()) {
                it6.next().fileDir = str;
            }
        }
        if (!CollectionUtil.isEmptyList(this.textStickers)) {
            Iterator<TAVEffectAutomaticEffect> it7 = this.textStickers.iterator();
            while (it7.hasNext()) {
                it7.next().fileDir = str;
            }
        }
        if (!CollectionUtil.isEmptyList(this.paintings)) {
            Iterator<TAVEffectAutomaticEffect> it8 = this.paintings.iterator();
            while (it8.hasNext()) {
                it8.next().fileDir = str;
            }
        }
    }
}
