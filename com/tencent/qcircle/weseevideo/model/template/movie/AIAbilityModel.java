package com.tencent.qcircle.weseevideo.model.template.movie;

import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AIAbilityModel {
    public static final String AI_KEY = "effectType";
    public static final String BACKGROUND_DETECT_VALUE = "portraitDetect";
    private int mTotalNeedClips;
    private AIAbilityType aiAbilityType = AIAbilityType.ORDINARY;
    private List<Integer> aiEffectIndexs = new ArrayList();
    private List<MediaClipModel> videos = new ArrayList();
    private List<MediaClipModel> replaceBeforeDetectVideos = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum AIAbilityType {
        ORDINARY,
        BACKGROUND_DETECT
    }

    public List<MediaClipModel> getAfterAiProcessClips() {
        return this.videos;
    }

    public AIAbilityType getAiAbilityType() {
        return this.aiAbilityType;
    }

    public List<Integer> getAiEffectIndexs() {
        return this.aiEffectIndexs;
    }

    public List<MediaClipModel> getReplaceBeforeDetectVideos() {
        return this.replaceBeforeDetectVideos;
    }

    public int getTotalNeedClips() {
        return this.mTotalNeedClips;
    }

    public void setAiAbilityType(AIAbilityType aIAbilityType) {
        this.aiAbilityType = aIAbilityType;
    }

    public void setTotalNeedClips(int i3) {
        this.mTotalNeedClips = i3;
    }
}
