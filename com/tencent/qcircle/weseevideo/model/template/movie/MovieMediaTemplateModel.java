package com.tencent.qcircle.weseevideo.model.template.movie;

import android.text.TextUtils;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import com.tencent.qcircle.weseevideo.model.utils.Utils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.ttpic.baseutils.io.FileUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MovieMediaTemplateModel {
    private boolean isAsset;
    private CMTime maxDuration;
    private CMTime minDuration;
    private String movieTemplateCateId;
    private String movieTemplateType;
    private String segmentInfo;
    private String filePath = "";
    private String movieTemplateId = "";
    private ArrayList<MovieSegmentModel> movieSegmentModels = new ArrayList<>();
    private boolean isRedPacketTemplate = false;
    private ArrayList<MovieStickerTextModel> movieStickerTextModels = new ArrayList<>();
    private AIAbilityModel mAiAbility = new AIAbilityModel();

    public void clearAIAbilityModel() {
        this.mAiAbility.setAiAbilityType(AIAbilityModel.AIAbilityType.ORDINARY);
        this.mAiAbility.getReplaceBeforeDetectVideos().clear();
        this.mAiAbility.getAfterAiProcessClips().clear();
        this.mAiAbility.setTotalNeedClips(0);
        this.mAiAbility.getAiEffectIndexs().clear();
    }

    public void clearSegmentModels() {
        ArrayList<MovieSegmentModel> arrayList = this.movieSegmentModels;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public boolean equals(Object obj) {
        ArrayList<MovieSegmentModel> arrayList;
        ArrayList<MovieSegmentModel> arrayList2;
        CMTime cMTime;
        ArrayList<MovieStickerTextModel> arrayList3;
        ArrayList<MovieStickerTextModel> arrayList4;
        CMTime cMTime2;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MovieMediaTemplateModel movieMediaTemplateModel = (MovieMediaTemplateModel) obj;
        if (this.isAsset == movieMediaTemplateModel.isAsset && this.isRedPacketTemplate == movieMediaTemplateModel.isRedPacketTemplate && Utils.equals(this.filePath, movieMediaTemplateModel.filePath) && Utils.equals(this.movieTemplateId, movieMediaTemplateModel.movieTemplateId) && Utils.equals(this.movieTemplateCateId, movieMediaTemplateModel.movieTemplateCateId) && (((arrayList = this.movieSegmentModels) == (arrayList2 = movieMediaTemplateModel.movieSegmentModels) || (arrayList != null && arrayList.equals(arrayList2))) && Utils.equals(this.segmentInfo, movieMediaTemplateModel.segmentInfo) && (cMTime = this.maxDuration) != null && cMTime.equalsTo(movieMediaTemplateModel.maxDuration) && (((arrayList3 = this.movieStickerTextModels) == (arrayList4 = movieMediaTemplateModel.movieStickerTextModels) || (arrayList3 != null && arrayList3.equals(arrayList4))) && (cMTime2 = this.minDuration) != null && cMTime2.equals(movieMediaTemplateModel.minDuration) && Utils.equals(this.movieTemplateType, movieMediaTemplateModel.movieTemplateType)))) {
            return true;
        }
        return false;
    }

    public AIAbilityModel getAiAbilityModel() {
        return this.mAiAbility;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public CMTime getMaxDuration() {
        return this.maxDuration;
    }

    public CMTime getMinDuration() {
        return this.minDuration;
    }

    public ArrayList<MovieSegmentModel> getMovieSegmentModels() {
        return this.movieSegmentModels;
    }

    public ArrayList<MovieStickerTextModel> getMovieStickerTextModels() {
        return this.movieStickerTextModels;
    }

    public String getMovieTemplateCateId() {
        return this.movieTemplateCateId;
    }

    public String getMovieTemplateId() {
        return this.movieTemplateId;
    }

    public String getMovieTemplateType() {
        return this.movieTemplateType;
    }

    public String getSegmentInfo() {
        return this.segmentInfo;
    }

    public boolean isAsset() {
        return this.isAsset;
    }

    public boolean isContainSegments() {
        ArrayList<MovieSegmentModel> arrayList = this.movieSegmentModels;
        if (arrayList != null && !arrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (!TextUtils.isEmpty(this.filePath) && FileUtils.exists(this.filePath)) {
            return false;
        }
        return true;
    }

    public boolean isRedPacketTemplate() {
        return this.isRedPacketTemplate;
    }

    public void setAiAbility(AIAbilityModel aIAbilityModel) {
        this.mAiAbility = aIAbilityModel;
    }

    public void setAsset(boolean z16) {
        this.isAsset = z16;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setMaxDuration(CMTime cMTime) {
        this.maxDuration = cMTime;
    }

    public void setMinDuration(CMTime cMTime) {
        this.minDuration = cMTime;
    }

    public void setMovieSegmentModels(ArrayList<MovieSegmentModel> arrayList) {
        this.movieSegmentModels = arrayList;
    }

    public void setMovieStickerTextModels(ArrayList<MovieStickerTextModel> arrayList) {
        this.movieStickerTextModels = arrayList;
    }

    public void setMovieTemplateCateId(String str) {
        this.movieTemplateCateId = str;
    }

    public void setMovieTemplateId(String str) {
        this.movieTemplateId = str;
    }

    public void setMovieTemplateType(String str) {
        this.movieTemplateType = str;
    }

    public void setRedPacketTemplate(boolean z16) {
        this.isRedPacketTemplate = z16;
    }

    public void setSegmentInfo(String str) {
        this.segmentInfo = str;
    }

    public String toString() {
        return "MovieMediaTemplateModel{isAsset=" + this.isAsset + ", filePath='" + this.filePath + "', movieTemplateId='" + this.movieTemplateId + "', movieTemplateCateId='" + this.movieTemplateCateId + "', movieSegmentModels=" + this.movieSegmentModels + ", segmentInfo='" + this.segmentInfo + "', maxDuration=" + this.maxDuration + ", isRedPacketTemplate=" + this.isRedPacketTemplate + ", movieStickerTextModels=" + this.movieStickerTextModels + ", movieTemplateType= " + this.movieTemplateType + '}';
    }
}
