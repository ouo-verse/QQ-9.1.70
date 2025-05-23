package com.tencent.tavkit.component.effectchain;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.BaseVideoEffect;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.report.FilterChainReportSession;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes26.dex */
public class VideoEffectProxy implements TAVVideoEffect {
    private final List<FilterProxy> filterProxies = new ArrayList();

    @NonNull
    private CopyOnWriteArrayList<TAVVideoEffect> effects = new CopyOnWriteArrayList<>();
    private boolean autoCheckEffectRemove = true;

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    public TAVVideoEffect.Filter createFilter() {
        FilterProxy filterProxy = new FilterProxy();
        this.filterProxies.add(filterProxy);
        return filterProxy;
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    @NonNull
    public String effectId() {
        return "VideoEffectProxy" + Integer.toHexString(hashCode());
    }

    @NonNull
    public synchronized List<TAVVideoEffect> getEffects() {
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

    public synchronized void setEffects(@NonNull CopyOnWriteArrayList<TAVVideoEffect> copyOnWriteArrayList) {
        this.effects = copyOnWriteArrayList;
    }

    /* loaded from: classes26.dex */
    private static class FilterProxy implements TAVVideoEffect.Filter, IReportable {
        private final HashMap<String, TAVVideoEffect.Filter> filterMap;
        private boolean onEffectRemove;
        private final FilterChainReportSession reportSession;

        FilterProxy() {
            this.filterMap = new HashMap<>();
            this.reportSession = new FilterChainReportSession();
        }

        private void checkRuntimeRelease(List<TAVVideoEffect> list) {
            this.onEffectRemove = false;
            ArrayList arrayList = new ArrayList();
            for (TAVVideoEffect tAVVideoEffect : list) {
                if (!TextUtils.isEmpty(tAVVideoEffect.effectId())) {
                    arrayList.add(tAVVideoEffect.effectId());
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

        private TAVVideoEffect.Filter createFilter(TAVVideoEffect tAVVideoEffect, RenderInfo renderInfo) {
            if (tAVVideoEffect instanceof BaseVideoEffect) {
                return ((BaseVideoEffect) tAVVideoEffect).createFilter(renderInfo);
            }
            return tAVVideoEffect.createFilter();
        }

        @Nullable
        private TAVVideoEffect.Filter getCacheFilter(TAVVideoEffect tAVVideoEffect, RenderInfo renderInfo) {
            if (tAVVideoEffect != null && !TextUtils.isEmpty(tAVVideoEffect.effectId())) {
                String effectId = tAVVideoEffect.effectId();
                TAVVideoEffect.Filter filter = this.filterMap.get(effectId);
                if (filter == null) {
                    TAVVideoEffect.Filter createFilter = createFilter(tAVVideoEffect, renderInfo);
                    this.filterMap.put(effectId, createFilter);
                    return createFilter;
                }
                return filter;
            }
            return null;
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        @NonNull
        public CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            if (!(tAVVideoEffect instanceof VideoEffectProxy)) {
                return cIImage;
            }
            VideoEffectProxy videoEffectProxy = (VideoEffectProxy) tAVVideoEffect;
            List<TAVVideoEffect> effects = videoEffectProxy.getEffects();
            if (videoEffectProxy.isAutoCheckEffectRemove() || this.onEffectRemove) {
                checkRuntimeRelease(effects);
            }
            Iterator<TAVVideoEffect> it = effects.iterator();
            while (it.hasNext()) {
                cIImage = apply(cIImage, renderInfo, it.next());
            }
            return cIImage;
        }

        @Override // com.tencent.tavkit.report.IReportable
        public String getReportKey() {
            return MemoryReportHelper.appendReportKey(this.filterMap.values());
        }

        public void notifyOnEffectRemove() {
            this.onEffectRemove = true;
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public synchronized void release() {
            Iterator<TAVVideoEffect.Filter> it = this.filterMap.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.filterMap.clear();
            this.reportSession.commit();
        }

        @NotNull
        private CIImage apply(CIImage cIImage, RenderInfo renderInfo, TAVVideoEffect tAVVideoEffect) {
            TAVVideoEffect.Filter cacheFilter = getCacheFilter(tAVVideoEffect, renderInfo);
            if (cacheFilter == null) {
                return cIImage;
            }
            long nanoTime = System.nanoTime();
            String reportKey = cacheFilter instanceof IReportable ? ((IReportable) cacheFilter).getReportKey() : null;
            CIImage apply = cacheFilter.apply(tAVVideoEffect, cIImage, renderInfo);
            if (!TextUtils.isEmpty(reportKey)) {
                this.reportSession.tick(reportKey, System.nanoTime() - nanoTime);
            }
            return apply;
        }
    }
}
