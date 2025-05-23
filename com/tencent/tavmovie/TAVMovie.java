package com.tencent.tavmovie;

import com.google.gson.GsonBuilder;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavmovie.base.TAVDecodeAndEncodeBase;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieSegment;
import com.tencent.tavmovie.base.TAVMovieTimeEffect;
import com.tencent.tavmovie.filter.TAVBigStickerOverlayEffect;
import com.tencent.tavmovie.filter.TAVMovieFilterChainContext;
import com.tencent.tavmovie.filter.TAVStickerOverlayEffect;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavmovie.utils.CloneUtil;
import com.tencent.tavmovie.utils.TAVMovieTimeEffectUtil;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVMovie implements TAVDecodeAndEncodeBase, Cloneable {
    private static final String TAG = "TAVMovie";
    protected TAVMovieClip backgroundMusic;
    protected List<TAVMovieClip> backgroundMusics;
    protected TAVStickerRenderContext bigStickerRenderContext;
    protected List<TAVVideoEffect> filters;
    protected TAVTemplate movieTemplate;
    protected List<TAVClip> overlays;
    protected boolean realTimeReleaseEachSticker;
    protected boolean realTimeReleaseStickerContext;
    protected CGSize renderSize;
    protected TAVStickerRenderContext stickerRenderContext;
    protected List<TAVMovieSticker> stickers;
    protected TAVMovieSticker templateSticker;
    protected int backgroundColor = -1;
    protected List<TAVMovieClip> clips = new ArrayList();
    protected List<TAVClip> tavClips = new ArrayList();
    protected List<TAVMovieTimeEffect> timeEffects = new ArrayList();

    public void addBackgroundMusic(TAVMovieClip tAVMovieClip) {
        if (this.backgroundMusics == null) {
            this.backgroundMusics = new ArrayList();
        }
        this.backgroundMusics.add(tAVMovieClip);
    }

    public void addClipsObject(TAVMovieClip tAVMovieClip) {
        if (tAVMovieClip == null) {
            return;
        }
        if (this.clips == null) {
            this.clips = new ArrayList();
        }
        this.clips.add(tAVMovieClip);
    }

    public void addFilter(TAVVideoEffect tAVVideoEffect) {
        if (tAVVideoEffect == null) {
            return;
        }
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        if (!this.filters.contains(tAVVideoEffect)) {
            this.filters.add(tAVVideoEffect);
        }
    }

    public void addOverlay(TAVClip tAVClip) {
        if (tAVClip == null) {
            return;
        }
        if (this.overlays == null) {
            this.overlays = new ArrayList();
        }
        this.overlays.add(tAVClip);
    }

    public void addStickersObject(TAVMovieSticker tAVMovieSticker) {
        if (tAVMovieSticker == null) {
            return;
        }
        if (this.stickers == null) {
            this.stickers = new ArrayList();
        }
        this.stickers.add(tAVMovieSticker);
    }

    public void addTavClip(TAVClip tAVClip) {
        this.tavClips.add(tAVClip);
    }

    public TAVComposition convertToComposition() {
        TAVStickerRenderContext tAVStickerRenderContext;
        TAVComposition tAVComposition = new TAVComposition();
        tAVComposition.setRenderSize(this.renderSize);
        tAVComposition.setBackgroundColor(this.backgroundColor);
        CMTime cMTime = new CMTime(0.0f);
        TAVTemplate tAVTemplate = this.movieTemplate;
        if (tAVTemplate != null) {
            List<TAVMovieSegment> convertClips = tAVTemplate.convertClips(this.clips);
            fillCompositionBySegment(tAVComposition, convertClips);
            Iterator<TAVMovieSegment> it = convertClips.iterator();
            while (it.hasNext()) {
                cMTime = cMTime.add(it.next().getPlayDuration());
            }
        } else {
            List<TAVClip> convertToTAVClips = convertToTAVClips(this.clips);
            if (convertToTAVClips == null) {
                convertToTAVClips = new ArrayList<>();
            }
            convertToTAVClips.addAll(this.tavClips);
            List<TAVClip> applyTimeEffectsNew = TAVMovieTimeEffectUtil.applyTimeEffectsNew(convertToTAVClips, TAVMovieTimeEffectUtil.pretreatTimeEffects(this.timeEffects));
            tAVComposition.addVideoChannel(applyTimeEffectsNew);
            tAVComposition.addAudioChannel(applyTimeEffectsNew);
            Iterator<TAVClip> it5 = applyTimeEffectsNew.iterator();
            while (it5.hasNext()) {
                cMTime.add(it5.next().getDuration());
            }
        }
        tAVComposition.setOverlays(this.overlays);
        if (this.backgroundMusics == null) {
            this.backgroundMusics = new ArrayList();
        }
        TAVMovieClip tAVMovieClip = this.backgroundMusic;
        if (tAVMovieClip != null) {
            this.backgroundMusics.add(0, tAVMovieClip);
        }
        if (!this.backgroundMusics.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (TAVMovieClip tAVMovieClip2 : this.backgroundMusics) {
                tAVMovieClip2.getResource().setTimeRange(new CMTimeRange(tAVMovieClip2.getResource().getTimeRange().getStart(), cMTime));
                arrayList.add(tAVMovieClip2.convertToClip());
            }
            tAVComposition.setAudios(arrayList);
        }
        TAVMovieFilterChainContext tAVMovieFilterChainContext = new TAVMovieFilterChainContext();
        List<TAVVideoEffect> list = this.filters;
        if (list != null && list.size() > 0) {
            for (TAVVideoEffect tAVVideoEffect : this.filters) {
                if (tAVVideoEffect != null) {
                    tAVMovieFilterChainContext.addFilter(tAVVideoEffect);
                }
            }
        }
        if (this.templateSticker != null && (tAVStickerRenderContext = this.bigStickerRenderContext) != null) {
            tAVStickerRenderContext.setRenderSize(this.renderSize);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.templateSticker.getSticker());
            this.bigStickerRenderContext.reloadStickers(arrayList2);
            tAVComposition.setVideoMixEffect(new TAVBigStickerOverlayEffect(this.bigStickerRenderContext));
        }
        initStickers(tAVMovieFilterChainContext);
        tAVComposition.setGlobalVideoEffect(tAVMovieFilterChainContext);
        return tAVComposition;
    }

    protected List<TAVClip> convertToTAVClips(List<TAVMovieClip> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TAVMovieClip tAVMovieClip : list) {
            if (tAVMovieClip != null) {
                arrayList.add(tAVMovieClip.convertToClip());
            }
        }
        return arrayList;
    }

    @Override // com.tencent.tavmovie.base.TAVDecodeAndEncodeBase
    public TAVDecodeAndEncodeBase decodeFromJsonString(String str) {
        return (TAVDecodeAndEncodeBase) new GsonBuilder().create().fromJson(str, (Class) getClass());
    }

    @Override // com.tencent.tavmovie.base.TAVDecodeAndEncodeBase
    public String encodeToJsonString() {
        return new GsonBuilder().create().toJson(this);
    }

    public TAVMovieSticker fetchStickerModelWithUniqueId(String str) {
        List<TAVMovieSticker> list = this.stickers;
        if (list != null && list.size() != 0) {
            for (TAVMovieSticker tAVMovieSticker : this.stickers) {
                if (tAVMovieSticker != null && tAVMovieSticker.getSticker().getUniqueId().equals(str)) {
                    return tAVMovieSticker;
                }
            }
        }
        return null;
    }

    protected void fillCompositionBySegment(TAVComposition tAVComposition, List<TAVMovieSegment> list) {
        if (tAVComposition != null && list != null && list.size() != 0) {
            ArrayList<List> arrayList = new ArrayList();
            Iterator<TAVMovieSegment> it = list.iterator();
            while (true) {
                boolean z16 = false;
                if (!it.hasNext()) {
                    break;
                }
                TAVMovieSegment next = it.next();
                if (arrayList.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(next);
                    arrayList.add(arrayList2);
                } else {
                    Iterator it5 = arrayList.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        List list2 = (List) it5.next();
                        if (!((TAVMovieSegment) list2.get(list2.size() - 1)).getTimeRange().containsTime(next.getTimeRange().getStart())) {
                            list2.add(next);
                            z16 = true;
                            break;
                        }
                    }
                    if (!z16) {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(next);
                        arrayList.add(arrayList3);
                    }
                }
            }
            ArrayList<List<? extends TAVTransitionableVideo>> arrayList4 = new ArrayList();
            for (List list3 : arrayList) {
                ArrayList arrayList5 = new ArrayList();
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    TAVMovieSegment tAVMovieSegment = (TAVMovieSegment) list3.get(i3);
                    if (i3 == 0) {
                        if (tAVMovieSegment.getTimeRange().getStart().bigThan(CMTime.CMTimeZero)) {
                            arrayList5.add(new TAVClip(new TAVEmptyResource(((TAVMovieSegment) list3.get(0)).getTimeRange().getStart())));
                        }
                        arrayList5.addAll(tAVMovieSegment.getFullTavClips());
                    } else {
                        CMTime sub = tAVMovieSegment.getTimeRange().getStart().sub(((TAVMovieSegment) list3.get(i3 - 1)).getTimeRange().getEnd());
                        if (sub.bigThan(CMTime.CMTimeZero)) {
                            arrayList5.add(new TAVClip(new TAVEmptyResource(sub)));
                        }
                        arrayList5.addAll(tAVMovieSegment.getFullTavClips());
                    }
                }
                arrayList4.add(arrayList5);
            }
            for (List<? extends TAVTransitionableVideo> list4 : arrayList4) {
                tAVComposition.addVideoChannel(list4);
                tAVComposition.addAudioChannel(list4);
            }
        }
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public TAVMovieClip getBackgroundMusic() {
        return this.backgroundMusic;
    }

    public List<TAVMovieClip> getBackgroundMusics() {
        return this.backgroundMusics;
    }

    public TAVStickerRenderContext getBigStickerRenderContext() {
        return this.bigStickerRenderContext;
    }

    public List<TAVMovieClip> getClips() {
        return this.clips;
    }

    public List<TAVVideoEffect> getFilters() {
        return this.filters;
    }

    public TAVTemplate getMovieTemplate() {
        return this.movieTemplate;
    }

    public List<TAVClip> getOverlays() {
        return this.overlays;
    }

    public CGSize getRenderSize() {
        return this.renderSize;
    }

    public TAVStickerRenderContext getStickerRenderContext() {
        return this.stickerRenderContext;
    }

    public List<TAVMovieSticker> getStickers() {
        return this.stickers;
    }

    public List<TAVClip> getTavClips() {
        return this.tavClips;
    }

    public TAVMovieSticker getTemplateSticker() {
        return this.templateSticker;
    }

    public List<TAVMovieTimeEffect> getTimeEffects() {
        return this.timeEffects;
    }

    protected void initStickers(TAVMovieFilterChainContext tAVMovieFilterChainContext) {
        List<TAVMovieSticker> list = this.stickers;
        if (list != null && list.size() > 0 && this.stickerRenderContext != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<TAVMovieSticker> it = this.stickers.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getSticker());
            }
            this.stickerRenderContext.setRenderSize(this.renderSize);
            TAVStickerOverlayEffect tAVStickerOverlayEffect = new TAVStickerOverlayEffect(this.stickerRenderContext);
            tAVMovieFilterChainContext.addFilter(tAVStickerOverlayEffect);
            boolean z16 = this.realTimeReleaseStickerContext;
            if (z16) {
                tAVStickerOverlayEffect.setStickers(arrayList, z16, this.realTimeReleaseEachSticker);
            } else {
                this.stickerRenderContext.reloadStickers(arrayList);
            }
        }
    }

    public boolean isHardMode() {
        return this.realTimeReleaseStickerContext;
    }

    public void release() {
        List<TAVMovieClip> list = this.clips;
        if (list != null) {
            for (TAVMovieClip tAVMovieClip : list) {
                if (tAVMovieClip != null) {
                    tAVMovieClip.release();
                }
            }
        }
    }

    public void removeClipsObject(TAVMovieClip tAVMovieClip) {
        List<TAVMovieClip> list;
        if (tAVMovieClip != null && (list = this.clips) != null && list.size() != 0) {
            this.clips.remove(tAVMovieClip);
        }
    }

    public void removeFilter(TAVVideoEffect.Filter filter) {
        List<TAVVideoEffect> list;
        if (filter != null && (list = this.filters) != null) {
            list.remove(filter);
        }
    }

    public void removeObjectFromClipsAtIndex(int i3) {
        List<TAVMovieClip> list = this.clips;
        if (list != null && list.size() != 0 && i3 >= 0 && i3 < this.clips.size()) {
            this.clips.remove(i3);
        }
    }

    public void removeStickerWithUniqueId(String str) {
        TAVMovieSticker tAVMovieSticker;
        List<TAVMovieSticker> list = this.stickers;
        if (list != null && list.size() != 0) {
            Iterator<TAVMovieSticker> it = this.stickers.iterator();
            while (true) {
                if (it.hasNext()) {
                    tAVMovieSticker = it.next();
                    if (tAVMovieSticker != null && tAVMovieSticker.getSticker().getUniqueId().equals(str)) {
                        break;
                    }
                } else {
                    tAVMovieSticker = null;
                    break;
                }
            }
            if (tAVMovieSticker != null) {
                this.stickers.remove(tAVMovieSticker);
            }
        }
    }

    public void removeStickersObject(TAVMovieSticker tAVMovieSticker) {
        List<TAVMovieSticker> list;
        if (tAVMovieSticker != null && (list = this.stickers) != null && list.size() != 0) {
            this.stickers.remove(tAVMovieSticker);
        }
    }

    public void setBackgroundColor(int i3) {
        this.backgroundColor = i3;
    }

    public void setBackgroundMusic(TAVMovieClip tAVMovieClip) {
        this.backgroundMusic = tAVMovieClip;
    }

    public void setBackgroundMusics(List<TAVMovieClip> list) {
        this.backgroundMusics = list;
    }

    public void setBigStickerRenderContext(TAVStickerRenderContext tAVStickerRenderContext) {
        this.bigStickerRenderContext = tAVStickerRenderContext;
    }

    public void setClips(List<TAVMovieClip> list) {
        this.clips = list;
    }

    public void setHardMode(boolean z16, boolean z17) {
        this.realTimeReleaseStickerContext = z16;
        this.realTimeReleaseEachSticker = z17;
    }

    public void setMovieTemplate(TAVTemplate tAVTemplate) {
        this.movieTemplate = tAVTemplate;
    }

    public void setOverlays(List<TAVClip> list) {
        this.overlays = list;
    }

    public void setRenderSize(CGSize cGSize) {
        this.renderSize = cGSize;
    }

    public void setStickerRenderContext(TAVStickerRenderContext tAVStickerRenderContext) {
        this.stickerRenderContext = tAVStickerRenderContext;
    }

    public void setStickers(List<TAVMovieSticker> list) {
        this.stickers = list;
    }

    public void setTavClips(List<TAVClip> list) {
        this.tavClips = list;
    }

    public void setTemplateSticker(TAVMovieSticker tAVMovieSticker) {
        this.templateSticker = tAVMovieSticker;
    }

    public void setTimeEffects(List<TAVMovieTimeEffect> list) {
        this.timeEffects = list;
    }

    public TAVComposition updateComposition() {
        TAVTemplate tAVTemplate = this.movieTemplate;
        if (tAVTemplate != null) {
            this.clips = tAVTemplate.getMovieClips();
        }
        return convertToComposition();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVMovie m273clone() {
        TAVMovie tAVMovie = new TAVMovie();
        tAVMovie.renderSize = this.renderSize.m258clone();
        tAVMovie.backgroundColor = this.backgroundColor;
        tAVMovie.backgroundMusic = this.backgroundMusic.m275clone();
        tAVMovie.clips = CloneUtil.cloneMovieClips(this.clips);
        tAVMovie.movieTemplate = this.movieTemplate;
        tAVMovie.stickers = CloneUtil.cloneTemplateStickers(this.stickers);
        return tAVMovie;
    }
}
