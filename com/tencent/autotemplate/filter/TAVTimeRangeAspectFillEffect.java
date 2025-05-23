package com.tencent.autotemplate.filter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVAttachTimeRangeSourceEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVTimeRangeAspectFillEffect extends TAVAspectFillEffect implements TAVAttachTimeRangeSourceEffect {
    static IPatchRedirector $redirector_;
    private final String TAG;
    private CMTimeRange timeRange;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class FilterWrapper implements TAVVideoEffect.Filter, TAVAttachTimeRangeSourceEffect.TimeAttachFilter {
        static IPatchRedirector $redirector_;

        @Nullable
        private TAVVideoEffect.Filter filter;

        FilterWrapper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TAVTimeRangeAspectFillEffect.this);
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        @NonNull
        public CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CIImage) iPatchRedirector.redirect((short) 2, this, tAVVideoEffect, cIImage, renderInfo);
            }
            if (this.filter == null) {
                this.filter = TAVTimeRangeAspectFillEffect.this.createSuperFilter();
            }
            return this.filter.apply(tAVVideoEffect, cIImage, renderInfo);
        }

        @Override // com.tencent.tavkit.composition.video.TAVAttachTimeRangeSourceEffect.TimeAttachFilter
        public void attachPositionTime(CMTime cMTime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) cMTime);
                return;
            }
            if (TAVTimeRangeAspectFillEffect.this.timeRange != null && cMTime != null) {
                long j3 = 100000;
                if (TAVTimeRangeAspectFillEffect.this.timeRange.getStartUs() - j3 > cMTime.getTimeUs() || TAVTimeRangeAspectFillEffect.this.timeRange.getEndUs() + j3 < cMTime.getTimeUs()) {
                    release();
                }
            }
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (this.filter != null) {
                Logger.d(TAVTimeRangeAspectFillEffect.this.TAG, "release() called\uff0cfilter = " + this.filter);
                this.filter.release();
                this.filter = null;
            }
        }

        /* synthetic */ FilterWrapper(TAVTimeRangeAspectFillEffect tAVTimeRangeAspectFillEffect, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tAVTimeRangeAspectFillEffect, (Object) anonymousClass1);
        }
    }

    public TAVTimeRangeAspectFillEffect(CGSize cGSize) {
        super(cGSize);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cGSize);
            return;
        }
        this.TAG = "TAVTimeRangeAspectFillE@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TAVVideoEffect.Filter createSuperFilter() {
        TAVVideoEffect.Filter createFilter = super.createFilter();
        Logger.d(this.TAG, "createSuperFilter() called filter = " + createFilter);
        return createFilter;
    }

    @Override // com.tencent.tavkit.composition.video.TAVAttachTimeRangeSourceEffect
    public void attachTimeRange(CMTimeRange cMTimeRange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cMTimeRange);
            return;
        }
        this.timeRange = cMTimeRange;
        if (cMTimeRange != null) {
            Logger.d(this.TAG, "attachTimeRange() called with: timeRange = [" + cMTimeRange.toSimpleString() + "]");
        }
    }

    @Override // com.tencent.autotemplate.filter.TAVAspectFillEffect, com.tencent.tavkit.composition.video.TAVVideoEffect
    @NonNull
    public String effectId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TAVTimeRangeAspectFillEffect" + Integer.toHexString(hashCode());
    }

    @Override // com.tencent.autotemplate.filter.TAVAspectFillEffect, com.tencent.tavkit.composition.video.TAVVideoEffect
    public FilterWrapper createFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new FilterWrapper(this, null) : (FilterWrapper) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
