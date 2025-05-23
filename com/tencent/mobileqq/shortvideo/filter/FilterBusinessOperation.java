package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.MovieMaterial;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FilterBusinessOperation {
    private QQFilterRenderManager mCommonOperation;
    private QQDanceEventHandler mDanceEventHandler;
    private MusicItemInfo mMusicItemInfo;
    private MovieMaterial movieMaterial;
    private WeakReference<QQSpecialAVFilter.MusicWaveformSupporter> musicWaveformSupporterWeakReference;
    private List<FilterDesc> mFilterDescMap = new CopyOnWriteArrayList();
    private long mPresentTimeStamp = 0;
    private long mOrgSamplerStamp = 0;
    private long mVideoStartTimeMs = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilterBusinessOperation(QQFilterRenderManager qQFilterRenderManager) {
        this.mCommonOperation = qQFilterRenderManager;
    }

    private void changeColorFilter(VideoFilterBase videoFilterBase) {
        QQPtColorFilter qQPtColorFilter;
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(184);
        if (qQFilters != null && qQFilters.size() == 1 && (qQPtColorFilter = (QQPtColorFilter) qQFilters.get(0)) != null) {
            qQPtColorFilter.setEffectFilter(videoFilterBase);
        }
    }

    private FilterDesc getSelectedTypeFilter(int i3) {
        for (FilterDesc filterDesc : this.mFilterDescMap) {
            if (i3 == QQAVImageFilterConstants.getFilterType(filterDesc.f281357id)) {
                return filterDesc;
            }
        }
        return null;
    }

    private void removeSelectedFilterDesc(FilterDesc filterDesc) {
        for (FilterDesc filterDesc2 : this.mFilterDescMap) {
            if (filterDesc.name.equals(filterDesc2.name)) {
                this.mFilterDescMap.remove(filterDesc2);
            }
        }
    }

    private void setAvSingleFilter(FilterDesc filterDesc) {
        QQAVFilter qQAVFilter;
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(70);
        if (qQFilters != null && qQFilters.size() == 1 && (qQAVFilter = (QQAVFilter) qQFilters.get(0)) != null) {
            qQAVFilter.setCurrentId(filterDesc, true);
        }
    }

    private void setAvSingleFilterForTimeSlamp(List<FilterDesc> list, List<Long> list2) {
        QQAVFilter qQAVFilter;
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(70);
        if (qQFilters != null && qQFilters.size() == 1 && (qQAVFilter = (QQAVFilter) qQFilters.get(0)) != null) {
            qQAVFilter.setAVListAndTimeSlamp(list, list2);
        }
    }

    private void setPtColorFilter(FilterDesc filterDesc) {
        QQPtColorFilter qQPtColorFilter;
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(184);
        if (qQFilters != null && qQFilters.size() == 1 && (qQPtColorFilter = (QQPtColorFilter) qQFilters.get(0)) != null) {
            qQPtColorFilter.setLutResPath(filterDesc);
        }
    }

    private void setQmcfArtFilter(FilterDesc filterDesc) {
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(90);
        if (qQFilters != null && qQFilters.size() == 1) {
            if (filterDesc == null) {
                if (QmcfManager.getInstance().getCurrQmcfMode() == 1) {
                    QmcfManager.getInstance().setCurrQmcfMode(0);
                }
            } else {
                QmcfManager.getInstance().switchQmcfModel(QmcfManager.getInstance().getMatchQmcfMode(filterDesc.type), filterDesc.getResFold(SdkContext.getInstance().getResources().getArtFilterResource().getFilterResPath()));
            }
        }
    }

    private void setSelectedFilterDesc(List<FilterDesc> list) {
        this.mFilterDescMap.clear();
        if (list != null && list.size() > 0) {
            Iterator<FilterDesc> it = list.iterator();
            while (it.hasNext()) {
                this.mFilterDescMap.add(it.next());
            }
        }
    }

    private void setSingleMTVFilter(FilterDesc filterDesc) {
        QQMTVFilter qQMTVFilter;
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(180);
        if (qQFilters != null && qQFilters.size() == 1 && (qQMTVFilter = (QQMTVFilter) qQFilters.get(0)) != null) {
            qQMTVFilter.setCurrentId(filterDesc);
        }
    }

    private void setSpecialSingleFilter(FilterDesc filterDesc) {
        QQSpecialAVFilter qQSpecialAVFilter;
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(80);
        if (qQFilters != null && qQFilters.size() == 1 && (qQSpecialAVFilter = (QQSpecialAVFilter) qQFilters.get(0)) != null) {
            qQSpecialAVFilter.setCurrentId(filterDesc);
        }
    }

    public void SetTimeStamp(long j3, long j16) {
        this.mPresentTimeStamp = j3;
        this.mOrgSamplerStamp = j16;
    }

    public void addSelectedFilterDesc(FilterDesc filterDesc) {
        FilterDesc selectedTypeFilter = getSelectedTypeFilter(QQAVImageFilterConstants.getFilterType(filterDesc.f281357id));
        if (selectedTypeFilter != null) {
            this.mFilterDescMap.remove(selectedTypeFilter);
        }
        this.mFilterDescMap.add(filterDesc);
    }

    public int getAVFilterFilterType() {
        QQAVFilter qQAVFilter;
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(70);
        if (qQFilters == null || qQFilters.size() < 1 || (qQAVFilter = (QQAVFilter) qQFilters.get(0)) == null) {
            return 0;
        }
        return qQAVFilter.getAVFilterType();
    }

    public FilterDesc getCurrentAVFilterIdByType(int i3) {
        for (FilterDesc filterDesc : this.mFilterDescMap) {
            if (filterDesc != null && QQAVImageFilterConstants.getFilterType(filterDesc.f281357id) == i3) {
                return filterDesc;
            }
        }
        return null;
    }

    public List<FilterDesc> getCurrentAVFilterIdList() {
        return this.mFilterDescMap;
    }

    public float getCurrentMusicGain() {
        QQSpecialAVFilter.MusicWaveformSupporter musicWaveformSupporter;
        WeakReference<QQSpecialAVFilter.MusicWaveformSupporter> weakReference = this.musicWaveformSupporterWeakReference;
        if (weakReference != null) {
            musicWaveformSupporter = weakReference.get();
        } else {
            musicWaveformSupporter = null;
        }
        if (musicWaveformSupporter != null) {
            return musicWaveformSupporter.getCurrentMusicGain();
        }
        return -1.0f;
    }

    public QQDanceEventHandler getDanceEventHandler() {
        return this.mDanceEventHandler;
    }

    public MovieMaterial getMovieMaterial() {
        return this.movieMaterial;
    }

    public MusicItemInfo getMusicItemInfo() {
        FilterDesc currentAVFilterIdByType = getCurrentAVFilterIdByType(2);
        if (currentAVFilterIdByType != null && QQAVImageFilterConstants.isMusicSpecialFilter(currentAVFilterIdByType.f281357id)) {
            return this.mMusicItemInfo;
        }
        return null;
    }

    public long getOrgTimeStamp() {
        return this.mOrgSamplerStamp;
    }

    public long getPresentTimeStamp() {
        return this.mPresentTimeStamp;
    }

    public long getVideoStartTime() {
        return this.mVideoStartTimeMs;
    }

    public boolean hasAvOrSpecialEffect() {
        if (getCurrentAVFilterIdList() != null && getCurrentAVFilterIdList().size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isRunningMovieFilter() {
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(100);
        if (qQFilters == null || qQFilters.size() <= 0) {
            return false;
        }
        return ((QQMovieFilter) qQFilters.get(0)).isFilterWork();
    }

    public void playMovie(String str, String str2, boolean z16, HWDecodeListener hWDecodeListener, float f16, float f17, float f18, float f19) {
        float f26;
        FilterBusinessOperation filterBusinessOperation;
        float f27 = 0.0f;
        if (f16 == 0.0f && f17 == 0.0f && f18 == 0.0f && f19 == 0.0f) {
            filterBusinessOperation = this;
            f26 = 0.0f;
        } else {
            float f28 = f18 / 2.0f;
            float f29 = ((f28 - f16) / f28) * 0.5f;
            float f36 = f19 / 2.0f;
            f26 = ((f17 - f36) / f36) * 0.5f;
            f27 = f29;
            filterBusinessOperation = this;
        }
        List<QQBaseFilter> qQFilters = filterBusinessOperation.mCommonOperation.getQQFilters(100);
        if (qQFilters != null && qQFilters.size() > 0) {
            Iterator<QQBaseFilter> it = qQFilters.iterator();
            while (it.hasNext()) {
                ((QQMovieFilter) it.next()).startPlay(str, str2, z16, f27, f26, hWDecodeListener);
            }
        }
    }

    public void setDanceEventHandler(QQDanceEventHandler qQDanceEventHandler) {
        this.mDanceEventHandler = qQDanceEventHandler;
    }

    public void setDynamicStickerParam(List<DynamicStickerData> list) {
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(120);
        if (qQFilters != null && qQFilters.size() > 0) {
            ((QQDynamicStickersFilter) qQFilters.get(0)).InitDynamicStickers(list);
        }
    }

    public void setFilterEffect(FilterDesc filterDesc) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(filterDesc);
        setSelectedFilterDesc(arrayList);
        if (filterDesc == null) {
            setAvSingleFilter(null);
            setSpecialSingleFilter(null);
            setQmcfArtFilter(null);
            setPtColorFilter(null);
            SLog.i("FilterRender", "set currentFilter null");
            return;
        }
        SLog.i("FilterRender", "set currentFilter " + filterDesc.name);
        int i3 = filterDesc.type;
        if (i3 == 0) {
            setAvSingleFilter(filterDesc);
            setSpecialSingleFilter(null);
            setQmcfArtFilter(null);
            setPtColorFilter(null);
            return;
        }
        if (i3 == 2) {
            setAvSingleFilter(null);
            setSpecialSingleFilter(filterDesc);
            setQmcfArtFilter(null);
            setPtColorFilter(null);
            return;
        }
        if (i3 != 1 && i3 != 3) {
            if (i3 == 5) {
                setQmcfArtFilter(null);
                setSpecialSingleFilter(null);
                setAvSingleFilter(null);
                setPtColorFilter(filterDesc);
                return;
            }
            SLog.e("FilterRender", "set currentFilter unKnown");
            return;
        }
        setAvSingleFilter(null);
        setSpecialSingleFilter(null);
        setQmcfArtFilter(filterDesc);
        setPtColorFilter(null);
    }

    public void setFilterEffectList(List<FilterDesc> list) {
        setSelectedFilterDesc(list);
        setAvSingleFilter(null);
        setSpecialSingleFilter(null);
        setSingleMTVFilter(null);
        if (list != null && list.size() != 0) {
            for (FilterDesc filterDesc : list) {
                if (filterDesc != null) {
                    int filterType = QQAVImageFilterConstants.getFilterType(filterDesc.f281357id);
                    if (filterType == 0) {
                        setQmcfArtFilter(null);
                        setPtColorFilter(null);
                        setAvSingleFilter(filterDesc);
                    } else if (filterType == 2) {
                        setQmcfArtFilter(null);
                        setPtColorFilter(null);
                        setSpecialSingleFilter(filterDesc);
                    } else if (filterType == 1) {
                        setPtColorFilter(null);
                        setQmcfArtFilter(filterDesc);
                    } else if (filterType == 4) {
                        setPtColorFilter(null);
                        setSingleMTVFilter(filterDesc);
                    } else if (filterType == 5) {
                        setPtColorFilter(filterDesc);
                        setQmcfArtFilter(null);
                    }
                }
            }
            return;
        }
        setQmcfArtFilter(null);
        setPtColorFilter(null);
    }

    public void setImgHazeRmoveFilterEnable(boolean z16) {
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(13);
        if (qQFilters != null && qQFilters.size() > 0) {
            ((QQImgHazeRmoveFilter) qQFilters.get(0)).setEnable(z16);
        }
    }

    public void setMovieEffectPoint(float f16, float f17, float f18, float f19) {
        MovieMaterial movieMaterial = this.movieMaterial;
        if (movieMaterial != null && FileUtil.fileExistsAndNotEmpty(movieMaterial.doodleVideoPath)) {
            float f26 = f18 / 2.0f;
            float f27 = ((f26 - f16) / f26) * 0.5f;
            float f28 = f19 / 2.0f;
            float f29 = ((f17 - f28) / f28) * 0.5f;
            List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(100);
            if (qQFilters != null && qQFilters.size() > 0) {
                Iterator<QQBaseFilter> it = qQFilters.iterator();
                while (it.hasNext()) {
                    QQMovieFilter qQMovieFilter = (QQMovieFilter) it.next();
                    MovieMaterial movieMaterial2 = this.movieMaterial;
                    qQMovieFilter.startPlay(movieMaterial2.doodleVideoPath, movieMaterial2.doodleAudioPath, movieMaterial2.loopDoodle, f27, f29, null);
                }
            }
        }
    }

    public void setMusicWaveformSupporter(QQSpecialAVFilter.MusicWaveformSupporter musicWaveformSupporter) {
        this.musicWaveformSupporterWeakReference = new WeakReference<>(musicWaveformSupporter);
        if (musicWaveformSupporter != null) {
            this.mMusicItemInfo = musicWaveformSupporter.getMusicItemInfo();
        } else {
            this.mMusicItemInfo = null;
        }
    }

    public void setTrackerStickerParam(ArrayList<TrackerStickerParam> arrayList) {
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(110);
        if (qQFilters != null && qQFilters.size() > 0) {
            ((QQTrackerStickersFilter) qQFilters.get(0)).InitTrackerStickers(arrayList);
        }
    }

    public void setVideoStartTime(long j3) {
        this.mVideoStartTimeMs = j3;
    }

    public void updateBeautyFilter(float f16) {
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(20);
        if (qQFilters != null && qQFilters.size() > 0) {
            Iterator<QQBaseFilter> it = qQFilters.iterator();
            while (it.hasNext()) {
                ((QQBeautyFilter) it.next()).updateBeautyFilter(f16);
            }
        }
    }

    public void updateBeautyFilter3Param(float f16, float f17, float f18) {
        List<QQBaseFilter> qQFilters = this.mCommonOperation.getQQFilters(20);
        if (qQFilters != null && qQFilters.size() > 0) {
            Iterator<QQBaseFilter> it = qQFilters.iterator();
            while (it.hasNext()) {
                ((QQBeautyFilter) it.next()).updateBeautyFilterParam(f16, f17, f18);
            }
        }
    }

    public void setFilterEffectList(List<FilterDesc> list, boolean z16) {
        if (list == null) {
            return;
        }
        if (z16) {
            for (FilterDesc filterDesc : list) {
                if (filterDesc != null) {
                    int filterType = QQAVImageFilterConstants.getFilterType(filterDesc.f281357id);
                    if (QQAVImageFilterConstants.isNormalFilterSpecialCases(filterDesc.f281357id, filterDesc.name)) {
                        setQmcfArtFilter(null);
                        FilterDesc selectedTypeFilter = getSelectedTypeFilter(1);
                        if (selectedTypeFilter != null) {
                            removeSelectedFilterDesc(selectedTypeFilter);
                        }
                        setSpecialSingleFilter(null);
                        FilterDesc selectedTypeFilter2 = getSelectedTypeFilter(2);
                        if (selectedTypeFilter2 != null) {
                            removeSelectedFilterDesc(selectedTypeFilter2);
                        }
                        setAvSingleFilter(filterDesc);
                    } else if (filterType == 0) {
                        setAvSingleFilter(filterDesc);
                    } else if (filterType == 2) {
                        setSpecialSingleFilter(filterDesc);
                    } else if (filterType == 1) {
                        setQmcfArtFilter(filterDesc);
                    } else if (filterType == 4) {
                        setSingleMTVFilter(filterDesc);
                    }
                    addSelectedFilterDesc(filterDesc);
                }
            }
            return;
        }
        for (FilterDesc filterDesc2 : list) {
            if (filterDesc2 != null) {
                int filterType2 = QQAVImageFilterConstants.getFilterType(filterDesc2.f281357id);
                if (filterType2 == 0) {
                    FilterDesc selectedTypeFilter3 = getSelectedTypeFilter(filterType2);
                    if (selectedTypeFilter3 != null && selectedTypeFilter3.name.equals(filterDesc2.name)) {
                        setAvSingleFilter(null);
                    }
                } else if (filterType2 == 2) {
                    setSpecialSingleFilter(null);
                } else if (filterType2 == 1) {
                    setQmcfArtFilter(null);
                } else if (filterType2 == 4) {
                    setSingleMTVFilter(null);
                }
                removeSelectedFilterDesc(filterDesc2);
            }
        }
    }
}
