package com.tencent.autotemplate.model;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.tencent.autotemplate.model.TAVBaseAutomaticEffect;
import com.tencent.autotemplate.model.rhythm.TAVTimeAutomaticEffect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.decoder.logger.Logger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVEffectAutomaticEffect extends TAVBaseAutomaticEffect {
    static IPatchRedirector $redirector_ = null;
    public static final int RHYTHM_EFFECT_APPLY_AUTO_ONLY = 100;
    public static final int RHYTHM_EFFECT_APPLY_BOTH = 0;
    public static final int RHYTHM_EFFECT_APPLY_HIGHLIGHT_PAG = 2;
    public static final int RHYTHM_EFFECT_APPLY_HIGHLIGHT_START = 1;
    public static final String TAG = "TAVEffectAutomaticEffect";

    @SerializedName("endOffset")
    public long endOffset;

    @SerializedName("isClosingcredits")
    public int isClosingcredits;

    @SerializedName("isOpeningCredits")
    public int isOpeningCredits;

    @SerializedName("isRelative")
    public int isRelative;

    @SerializedName("rhythmEffectType")
    public int rhythmEffectType;

    @SerializedName("startOffset")
    public long startOffset;

    public TAVEffectAutomaticEffect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.startOffset = -1L;
        this.endOffset = -1L;
        this.isOpeningCredits = 0;
        this.isClosingcredits = 0;
        this.rhythmEffectType = 0;
        this.isRelative = 0;
    }

    public TAVEffectAutomaticEffect copy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (TAVEffectAutomaticEffect) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypePAG) {
            return copyPAGEffectFrom();
        }
        if (getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeLUT) {
            return copyLUTEffectFrom();
        }
        if (getEffectType() == TAVBaseAutomaticEffect.TAVEffectType.TAVEffectTypeTime) {
            return copyTimeEffectFrom();
        }
        return this;
    }

    public TAVLUTAutomaticEffect copyLUTEffectFrom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (TAVLUTAutomaticEffect) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        TAVLUTAutomaticEffect tAVLUTAutomaticEffect = new TAVLUTAutomaticEffect(this.fileDir);
        tAVLUTAutomaticEffect.effectId = this.effectId;
        tAVLUTAutomaticEffect.effectTypeStr = this.effectTypeStr;
        tAVLUTAutomaticEffect.parameter = this.parameter;
        tAVLUTAutomaticEffect.duration = this.duration;
        tAVLUTAutomaticEffect.fileDir = this.fileDir;
        tAVLUTAutomaticEffect.startOffset = this.startOffset;
        tAVLUTAutomaticEffect.endOffset = this.endOffset;
        tAVLUTAutomaticEffect.isClosingcredits = this.isClosingcredits;
        tAVLUTAutomaticEffect.isOpeningCredits = this.isOpeningCredits;
        tAVLUTAutomaticEffect.rhythmEffectType = this.rhythmEffectType;
        tAVLUTAutomaticEffect.isRelative = this.isRelative;
        return tAVLUTAutomaticEffect;
    }

    public TAVPagAutomaticEffect copyPAGEffectFrom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (TAVPagAutomaticEffect) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        TAVPagAutomaticEffect tAVPagAutomaticEffect = new TAVPagAutomaticEffect(this.fileDir);
        tAVPagAutomaticEffect.effectId = this.effectId;
        tAVPagAutomaticEffect.effectTypeStr = this.effectTypeStr;
        tAVPagAutomaticEffect.parameter = this.parameter;
        tAVPagAutomaticEffect.duration = this.duration;
        tAVPagAutomaticEffect.fileDir = this.fileDir;
        tAVPagAutomaticEffect.startOffset = this.startOffset;
        tAVPagAutomaticEffect.endOffset = this.endOffset;
        tAVPagAutomaticEffect.isClosingcredits = this.isClosingcredits;
        tAVPagAutomaticEffect.isOpeningCredits = this.isOpeningCredits;
        tAVPagAutomaticEffect.rhythmEffectType = this.rhythmEffectType;
        tAVPagAutomaticEffect.isRelative = this.isRelative;
        return tAVPagAutomaticEffect;
    }

    public TAVTimeAutomaticEffect copyTimeEffectFrom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (TAVTimeAutomaticEffect) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        TAVTimeAutomaticEffect tAVTimeAutomaticEffect = new TAVTimeAutomaticEffect(this.fileDir);
        tAVTimeAutomaticEffect.effectId = this.effectId;
        tAVTimeAutomaticEffect.effectTypeStr = this.effectTypeStr;
        tAVTimeAutomaticEffect.parameter = this.parameter;
        tAVTimeAutomaticEffect.duration = this.duration;
        tAVTimeAutomaticEffect.fileDir = this.fileDir;
        tAVTimeAutomaticEffect.startOffset = this.startOffset;
        tAVTimeAutomaticEffect.endOffset = this.endOffset;
        tAVTimeAutomaticEffect.isClosingcredits = this.isClosingcredits;
        tAVTimeAutomaticEffect.isOpeningCredits = this.isOpeningCredits;
        tAVTimeAutomaticEffect.rhythmEffectType = this.rhythmEffectType;
        tAVTimeAutomaticEffect.isRelative = this.isRelative;
        return tAVTimeAutomaticEffect;
    }

    public long getEndOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.endOffset;
    }

    public int getRhythmEffectType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.rhythmEffectType;
    }

    public long getStartOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.startOffset;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (this.startOffset == -1 && this.endOffset == -1) {
            Logger.e(TAG, "this effect's startOffset == -1 and endOffset == -1, is wrong.");
            return false;
        }
        return true;
    }

    public boolean isClosingcredits() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.isClosingcredits == 1) {
            return true;
        }
        return false;
    }

    public boolean isOpeningCredits() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.isOpeningCredits == 1) {
            return true;
        }
        return false;
    }

    public int isRelative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.isRelative;
    }

    public void setClosingcredits(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.isClosingcredits = z16 ? 1 : 0;
        }
    }

    public void setEndOffset(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            this.endOffset = j3;
        }
    }

    public void setIsRelative(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.isRelative = i3;
        }
    }

    public void setOpeningCredits(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.isOpeningCredits = z16 ? 1 : 0;
        }
    }

    public void setRhythmEffectType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.rhythmEffectType = i3;
        }
    }

    public void setStartOffset(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.startOffset = j3;
        }
    }

    public TAVEffectAutomaticEffect(@NonNull String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.startOffset = -1L;
        this.endOffset = -1L;
        this.isOpeningCredits = 0;
        this.isClosingcredits = 0;
        this.rhythmEffectType = 0;
        this.isRelative = 0;
    }
}
