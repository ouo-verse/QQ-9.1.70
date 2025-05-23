package com.tencent.qcircle.weseevideo.model.utils;

import android.support.annotation.NonNull;
import com.tencent.qcircle.weishi.module.publisher.data.VolumeAutomaticEffect;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MusicMaterialMataDataBeanUtils {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class EndOutEffectFilter implements IFilter {
        EndOutEffectFilter() {
        }

        @Override // com.tencent.qcircle.weseevideo.model.utils.MusicMaterialMataDataBeanUtils.IFilter
        public boolean isMatch(@NonNull VolumeAutomaticEffect volumeAutomaticEffect) {
            if (volumeAutomaticEffect.getEndOffset() == 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface IFilter {
        boolean isMatch(@NonNull VolumeAutomaticEffect volumeAutomaticEffect);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class StartInEffectFilter implements IFilter {
        StartInEffectFilter() {
        }

        @Override // com.tencent.qcircle.weseevideo.model.utils.MusicMaterialMataDataBeanUtils.IFilter
        public boolean isMatch(@NonNull VolumeAutomaticEffect volumeAutomaticEffect) {
            if (volumeAutomaticEffect.getStartOffset() == 0) {
                return true;
            }
            return false;
        }
    }

    public static void clearMatchVolumeEffect(List<VolumeAutomaticEffect> list, IFilter iFilter) {
        if (CollectionUtils.isEmpty(list) || iFilter == null) {
            return;
        }
        Iterator<VolumeAutomaticEffect> it = list.iterator();
        while (it.hasNext()) {
            if (iFilter.isMatch(it.next())) {
                it.remove();
                return;
            }
        }
    }

    public static void clearSpecialEditEffect(MusicMaterialMetaDataBean musicMaterialMetaDataBean) {
        if (musicMaterialMetaDataBean == null) {
            return;
        }
        musicMaterialMetaDataBean.startInTime = 0L;
        musicMaterialMetaDataBean.endOutTime = 0L;
        musicMaterialMetaDataBean.isEdit = false;
        musicMaterialMetaDataBean.startPlayOffset = 0L;
        clearMatchVolumeEffect(musicMaterialMetaDataBean.mVolumeAutomaticEffectList, new StartInEffectFilter());
        clearMatchVolumeEffect(musicMaterialMetaDataBean.mVolumeAutomaticEffectList, new EndOutEffectFilter());
    }

    public static VolumeAutomaticEffect findMatchEffectFromBean(List<VolumeAutomaticEffect> list, IFilter iFilter) {
        if (iFilter == null || CollectionUtils.isEmpty(list)) {
            return null;
        }
        for (VolumeAutomaticEffect volumeAutomaticEffect : list) {
            if (iFilter.isMatch(volumeAutomaticEffect)) {
                return volumeAutomaticEffect;
            }
        }
        return null;
    }

    public static long getEndOutTimeFromBean(MusicMaterialMetaDataBean musicMaterialMetaDataBean) {
        VolumeAutomaticEffect findMatchEffectFromBean;
        if (musicMaterialMetaDataBean == null || (findMatchEffectFromBean = findMatchEffectFromBean(musicMaterialMetaDataBean.mVolumeAutomaticEffectList, new EndOutEffectFilter())) == null) {
            return 0L;
        }
        return findMatchEffectFromBean.getDuration();
    }

    public static long getStartInTimeFromBean(MusicMaterialMetaDataBean musicMaterialMetaDataBean) {
        VolumeAutomaticEffect findMatchEffectFromBean;
        if (musicMaterialMetaDataBean == null || (findMatchEffectFromBean = findMatchEffectFromBean(musicMaterialMetaDataBean.mVolumeAutomaticEffectList, new StartInEffectFilter())) == null) {
            return 0L;
        }
        return findMatchEffectFromBean.getDuration();
    }

    public static void setEndOutTime(MusicMaterialMetaDataBean musicMaterialMetaDataBean, long j3) {
        if (musicMaterialMetaDataBean == null) {
            return;
        }
        clearMatchVolumeEffect(musicMaterialMetaDataBean.mVolumeAutomaticEffectList, new EndOutEffectFilter());
        VolumeAutomaticEffect genEndOutVolumeAutomaticEffect = VolumeAutomaticEffect.INSTANCE.genEndOutVolumeAutomaticEffect(j3);
        if (musicMaterialMetaDataBean.mVolumeAutomaticEffectList == null) {
            musicMaterialMetaDataBean.mVolumeAutomaticEffectList = new ArrayList();
        }
        musicMaterialMetaDataBean.mVolumeAutomaticEffectList.add(genEndOutVolumeAutomaticEffect);
    }

    public static void setStartInTime(MusicMaterialMetaDataBean musicMaterialMetaDataBean, long j3) {
        if (musicMaterialMetaDataBean == null) {
            return;
        }
        clearMatchVolumeEffect(musicMaterialMetaDataBean.mVolumeAutomaticEffectList, new StartInEffectFilter());
        VolumeAutomaticEffect genStartInVolumeAutomaticEffect = VolumeAutomaticEffect.INSTANCE.genStartInVolumeAutomaticEffect(j3);
        if (musicMaterialMetaDataBean.mVolumeAutomaticEffectList == null) {
            musicMaterialMetaDataBean.mVolumeAutomaticEffectList = new ArrayList();
        }
        musicMaterialMetaDataBean.mVolumeAutomaticEffectList.add(genStartInVolumeAutomaticEffect);
    }
}
