package com.tencent.tavkit.composition.model;

import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.video.TAVAttachTimeRangeSourceEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVVideoConfiguration implements Cloneable {
    public static CGRect DEFAULT_VIDEO_FRAME;
    public static final CGRect FIX_RENDER_SIZE = new CGRect();
    public static final CGRect SOURCE_SIZE;

    @Nullable
    private CGRect frame = DEFAULT_VIDEO_FRAME;
    private int preferRotation = 0;
    private TAVVideoConfigurationContentMode contentMode = TAVVideoConfigurationContentMode.aspectFit;
    private Matrix transform = new Matrix();
    private List<TAVVideoEffect> effects = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum TAVVideoConfigurationContentMode {
        aspectFit,
        aspectFill,
        scaleToFit
    }

    static {
        CGRect cGRect = new CGRect();
        SOURCE_SIZE = cGRect;
        DEFAULT_VIDEO_FRAME = cGRect;
    }

    public void addEffect(TAVVideoEffect tAVVideoEffect) {
        if (this.effects == null) {
            this.effects = new ArrayList();
        }
        this.effects.add(tAVVideoEffect);
    }

    public boolean frameEnable() {
        CGRect cGRect = this.frame;
        if (cGRect != null && cGRect != FIX_RENDER_SIZE && cGRect != SOURCE_SIZE && Utils.isRectValid(cGRect)) {
            return true;
        }
        return false;
    }

    public TAVVideoConfigurationContentMode getContentMode() {
        return this.contentMode;
    }

    public List<TAVVideoEffect> getEffects() {
        return this.effects;
    }

    @Nullable
    public CGRect getFrame() {
        return this.frame;
    }

    public int getPreferRotation() {
        return this.preferRotation;
    }

    public Matrix getTransform() {
        return this.transform;
    }

    public void setContentMode(TAVVideoConfigurationContentMode tAVVideoConfigurationContentMode) {
        this.contentMode = tAVVideoConfigurationContentMode;
    }

    public void setEffects(List<TAVVideoEffect> list) {
        this.effects = list;
    }

    public void setFrame(@Nullable CGRect cGRect) {
        this.frame = cGRect;
    }

    public void setPreferRotation(int i3) {
        this.preferRotation = i3;
    }

    public void setTransform(Matrix matrix) {
        this.transform = matrix;
    }

    public String toString() {
        return "TAVVideoConfiguration{contentMode=" + this.contentMode + ", frame=" + this.frame + ", transform=" + this.transform + '}';
    }

    public void updateTimeRange(CMTimeRange cMTimeRange) {
        List<TAVVideoEffect> list = this.effects;
        if (list == null) {
            return;
        }
        for (TAVVideoEffect tAVVideoEffect : list) {
            if (tAVVideoEffect instanceof TAVAttachTimeRangeSourceEffect) {
                ((TAVAttachTimeRangeSourceEffect) tAVVideoEffect).attachTimeRange(cMTimeRange);
            }
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVVideoConfiguration m271clone() {
        TAVVideoConfiguration tAVVideoConfiguration = new TAVVideoConfiguration();
        tAVVideoConfiguration.contentMode = this.contentMode;
        tAVVideoConfiguration.frame = this.frame;
        tAVVideoConfiguration.transform = this.transform;
        tAVVideoConfiguration.effects = new ArrayList(this.effects);
        tAVVideoConfiguration.preferRotation = this.preferRotation;
        return tAVVideoConfiguration;
    }
}
