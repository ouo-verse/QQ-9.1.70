package com.tencent.qcircle.weseevideo.camera.mvauto.data;

import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVComposition;

/* loaded from: classes22.dex */
public class CompositionPack {
    private TAVComposition mComposition;
    private CMTimeRange mTimeRange;
    private int useTemplate = 0;

    /* loaded from: classes22.dex */
    public class TemplateConstantType {
        public static final int AUTO_TEMPLATE = 1;
        public static final int MOVIE_TEMPLATE = 2;
        public static final int ORIGINAL = 0;

        public TemplateConstantType() {
        }
    }

    public TAVComposition getComposition() {
        return this.mComposition;
    }

    public CMTimeRange getTimeRange() {
        return this.mTimeRange;
    }

    public int getUseTemplate() {
        return this.useTemplate;
    }

    public void setComposition(TAVComposition tAVComposition) {
        this.mComposition = tAVComposition;
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.mTimeRange = cMTimeRange;
    }

    public void setUseTemplate(int i3) {
        this.useTemplate = i3;
    }
}
