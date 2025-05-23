package com.tencent.tavkit.component.effectchain;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.report.FilterChainReportSession;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes26.dex */
public class VideoMixEffectProxy implements TAVVideoMixEffect {
    private final List<FilterProxy> filterProxies = new ArrayList();

    @NonNull
    private CopyOnWriteArrayList<TAVVideoMixEffect> effects = new CopyOnWriteArrayList<>();
    private boolean autoCheckEffectRemove = true;

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    public TAVVideoMixEffect.Filter createFilter() {
        FilterProxy filterProxy = new FilterProxy();
        this.filterProxies.add(filterProxy);
        return filterProxy;
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect
    @NonNull
    public String effectId() {
        return "VideoMixEffectProxy" + Integer.toHexString(hashCode());
    }

    @NonNull
    public List<TAVVideoMixEffect> getEffects() {
        return this.effects;
    }

    public boolean isAutoCheckEffectRemove() {
        return this.autoCheckEffectRemove;
    }

    public void notifyOnEffectRemove() {
        Iterator<FilterProxy> it = this.filterProxies.iterator();
        while (it.hasNext()) {
            it.next().notifyOnEffectRemove();
        }
    }

    public void setAutoCheckEffectRemove(boolean z16) {
        this.autoCheckEffectRemove = z16;
    }

    public void setEffects(@NonNull CopyOnWriteArrayList<TAVVideoMixEffect> copyOnWriteArrayList) {
        this.effects = copyOnWriteArrayList;
    }

    /* loaded from: classes26.dex */
    private static class FilterProxy implements TAVVideoMixEffect.Filter, IReportable {
        private final HashMap<String, TAVVideoMixEffect.Filter> filterMap;
        private boolean onEffectRemove;
        private final FilterChainReportSession reportSession;

        FilterProxy() {
            this.filterMap = new HashMap<>();
            this.reportSession = new FilterChainReportSession();
        }

        private void checkRuntimeRelease(List<TAVVideoMixEffect> list) {
            if (!this.onEffectRemove) {
                return;
            }
            this.onEffectRemove = false;
            ArrayList arrayList = new ArrayList();
            for (TAVVideoMixEffect tAVVideoMixEffect : list) {
                if (!TextUtils.isEmpty(tAVVideoMixEffect.effectId())) {
                    arrayList.add(tAVVideoMixEffect.effectId());
                }
            }
            Iterator it = new HashSet(this.filterMap.keySet()).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!arrayList.contains(str)) {
                    this.filterMap.get(str).release();
                    this.filterMap.remove(str);
                }
            }
        }

        @Nullable
        private TAVVideoMixEffect.Filter getCacheFilter(TAVVideoMixEffect tAVVideoMixEffect) {
            if (tAVVideoMixEffect != null && !TextUtils.isEmpty(tAVVideoMixEffect.effectId())) {
                String effectId = tAVVideoMixEffect.effectId();
                if (this.filterMap.containsKey(effectId)) {
                    return this.filterMap.get(effectId);
                }
                TAVVideoMixEffect.Filter createFilter = tAVVideoMixEffect.createFilter();
                this.filterMap.put(effectId, createFilter);
                return createFilter;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyOnEffectRemove() {
            this.onEffectRemove = true;
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
        public CIImage apply(TAVVideoMixEffect tAVVideoMixEffect, ImageCollection imageCollection, RenderInfo renderInfo) {
            CIImage cIImage = null;
            if (!(tAVVideoMixEffect instanceof VideoMixEffectProxy)) {
                return null;
            }
            VideoMixEffectProxy videoMixEffectProxy = (VideoMixEffectProxy) tAVVideoMixEffect;
            List<TAVVideoMixEffect> effects = videoMixEffectProxy.getEffects();
            if (videoMixEffectProxy.isAutoCheckEffectRemove() || this.onEffectRemove) {
                checkRuntimeRelease(effects);
            }
            Iterator<TAVVideoMixEffect> it = effects.iterator();
            while (it.hasNext()) {
                cIImage = apply(imageCollection, renderInfo, cIImage, it.next());
            }
            return cIImage;
        }

        @Override // com.tencent.tavkit.report.IReportable
        public String getReportKey() {
            return MemoryReportHelper.appendReportKey(this.filterMap.values());
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public synchronized void release() {
            Iterator<TAVVideoMixEffect.Filter> it = this.filterMap.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.filterMap.clear();
            this.reportSession.commit();
        }

        private CIImage apply(ImageCollection imageCollection, RenderInfo renderInfo, CIImage cIImage, TAVVideoMixEffect tAVVideoMixEffect) {
            TAVVideoMixEffect.Filter cacheFilter = getCacheFilter(tAVVideoMixEffect);
            if (cacheFilter == null) {
                return cIImage;
            }
            long nanoTime = System.nanoTime();
            String reportKey = cacheFilter instanceof IReportable ? ((IReportable) cacheFilter).getReportKey() : null;
            CIImage apply = cacheFilter.apply(tAVVideoMixEffect, imageCollection, renderInfo);
            if (!TextUtils.isEmpty(reportKey)) {
                this.reportSession.tick(reportKey, System.nanoTime() - nanoTime);
            }
            return apply;
        }
    }
}
