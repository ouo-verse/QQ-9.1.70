package com.tencent.tavmovie.base;

import android.graphics.Matrix;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVMovieVideoConfiguration implements Cloneable {
    private Matrix transform;
    private CGRect frame = TAVVideoConfiguration.DEFAULT_VIDEO_FRAME;
    private List<? extends TAVVideoEffect> effects = new ArrayList();
    private int preferRotation = 0;
    private TAVVideoConfiguration.TAVVideoConfigurationContentMode contentMode = TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit;

    public TAVVideoConfiguration convertToConfiguration() {
        TAVVideoConfiguration tAVVideoConfiguration = new TAVVideoConfiguration();
        tAVVideoConfiguration.setFrame(this.frame);
        tAVVideoConfiguration.setContentMode(this.contentMode);
        tAVVideoConfiguration.setTransform(this.transform);
        tAVVideoConfiguration.getEffects().addAll(this.effects);
        tAVVideoConfiguration.setPreferRotation(this.preferRotation);
        return tAVVideoConfiguration;
    }

    public TAVVideoConfiguration.TAVVideoConfigurationContentMode getContentMode() {
        return this.contentMode;
    }

    public CGRect getFrame() {
        return this.frame;
    }

    public int getPreferRotation() {
        return this.preferRotation;
    }

    public Matrix getTransform() {
        return this.transform;
    }

    public void setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode tAVVideoConfigurationContentMode) {
        this.contentMode = tAVVideoConfigurationContentMode;
    }

    public void setEffects(List<? extends TAVVideoEffect> list) {
        this.effects = list;
    }

    public void setFrame(CGRect cGRect) {
        this.frame = cGRect;
    }

    public void setPreferRotation(int i3) {
        this.preferRotation = i3;
    }

    public void setTransform(Matrix matrix) {
        this.transform = matrix;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVMovieVideoConfiguration m277clone() {
        TAVMovieVideoConfiguration tAVMovieVideoConfiguration = new TAVMovieVideoConfiguration();
        CGRect cGRect = this.frame;
        if (cGRect != null && cGRect != TAVVideoConfiguration.FIX_RENDER_SIZE && cGRect != TAVVideoConfiguration.SOURCE_SIZE) {
            tAVMovieVideoConfiguration.frame = cGRect.m257clone();
        } else {
            tAVMovieVideoConfiguration.frame = cGRect;
        }
        tAVMovieVideoConfiguration.contentMode = this.contentMode;
        tAVMovieVideoConfiguration.transform = new Matrix(this.transform);
        tAVMovieVideoConfiguration.effects = new ArrayList(this.effects);
        tAVMovieVideoConfiguration.preferRotation = this.preferRotation;
        return tAVMovieVideoConfiguration;
    }
}
