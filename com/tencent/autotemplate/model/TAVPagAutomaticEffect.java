package com.tencent.autotemplate.model;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavmovie.sticker.TAVMovieSticker;

/* loaded from: classes3.dex */
public class TAVPagAutomaticEffect extends TAVEffectAutomaticEffect {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_EXTRA_MATERIAL_ID = "key_extra_material_id";
    private transient TAVMovieSticker.TAVMovieStickerMode mode;
    private transient PointF position;
    private transient float rotation;
    private transient float scale;

    public TAVPagAutomaticEffect(@NonNull String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.rotation = 0.0f;
        this.scale = 1.0f;
        this.position = new PointF(0.5f, 0.5f);
    }

    public TAVMovieSticker convertToMovieStickerWithDuraton(float f16) {
        float f17;
        float f18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TAVMovieSticker) iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
        }
        if (!isAvailable()) {
            return null;
        }
        TAVMovieSticker tAVMovieSticker = new TAVMovieSticker(getFullPath());
        if (tAVMovieSticker.getSticker() == null) {
            return null;
        }
        TAVEffectParameter tAVEffectParameter = this.parameter;
        if (tAVEffectParameter != null) {
            tAVMovieSticker.setRotation(tAVEffectParameter.rotation);
            tAVMovieSticker.setScale(this.parameter.scale);
            if (this.parameter.position != null) {
                StickerPosition stickerPosition = this.parameter.position;
                tAVMovieSticker.setPosition(new PointF(stickerPosition.centerX, stickerPosition.centerY));
            }
        } else {
            tAVMovieSticker.setRotation(this.rotation);
            tAVMovieSticker.setScale(this.scale);
            tAVMovieSticker.setPosition(this.position);
        }
        tAVMovieSticker.getSticker().updateTextData();
        if (this.effectId != null) {
            tAVMovieSticker.getSticker().getExtraBundle().putString("key_extra_material_id", this.effectId);
        }
        tAVMovieSticker.setStickerMode(getMode());
        long j3 = this.startOffset;
        if (j3 > -1 && this.endOffset == -1) {
            f18 = (float) j3;
            long j16 = this.duration;
            if (j16 > 0) {
                f17 = (float) j16;
            } else {
                f17 = ((float) tAVMovieSticker.getSticker().durationTime()) / 1000.0f;
            }
        } else if (j3 == -1 && this.endOffset > -1) {
            long j17 = this.duration;
            if (j17 > 0) {
                f17 = (float) j17;
            } else {
                f17 = ((float) tAVMovieSticker.getSticker().durationTime()) / 1000.0f;
            }
            f18 = (f16 - f17) - ((float) this.endOffset);
        } else {
            f17 = (f16 - ((float) j3)) - ((float) this.endOffset);
            f18 = (float) j3;
        }
        TAVEffectParameter tAVEffectParameter2 = this.parameter;
        if (tAVEffectParameter2 != null) {
            long j18 = tAVEffectParameter2.rhythmPosition;
            if (j18 == 1) {
                f18 -= f17 / 2.0f;
            } else if (j18 == 2) {
                f18 -= f17;
            }
        }
        if (f17 <= 0.0f) {
            return null;
        }
        if (f18 < 0.0f) {
            f18 = 0.0f;
        }
        tAVMovieSticker.setTimeRange(CMTimeRange.fromMs(f18, f17));
        return tAVMovieSticker;
    }

    public PointF getPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PointF) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.position;
    }

    public float getRotation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
        }
        return this.rotation;
    }

    public float getScale() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.scale;
    }

    public CMTime getStickerDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CMTime) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        TAVMovieSticker tAVMovieSticker = new TAVMovieSticker(getFullPath());
        if (tAVMovieSticker.getSticker() == null) {
            return new CMTime(0L, 1000000);
        }
        return new CMTime(tAVMovieSticker.getSticker().durationTime(), 1000000);
    }

    public void setPosition(PointF pointF) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) pointF);
        } else {
            this.position = pointF;
        }
    }

    public void setRotation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
        } else {
            this.rotation = f16;
        }
    }

    public void setScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.scale = f16;
        }
    }
}
