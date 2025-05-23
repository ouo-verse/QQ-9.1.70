package com.tencent.qcircle.weseevideo.model.template.auto;

import android.text.TextUtils;
import com.tencent.autotemplate.model.TAVTransitionAutomaticEffect;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieSegmentModel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AutomaticMediaTemplateModel {
    public static final String SCALE_MODE_ASPECT_FILL = "aspectFill";
    public static final String SCALE_MODE_ASPECT_FIT = "aspectFit";
    public static final String TEMPLATE_ASSET_PATH = "pag";
    private AEFrameModel aeFrameModel;
    private boolean isRhythmTemplate;
    private boolean isSwitchToTemplateByUser;
    private ArrayList<TAVTransitionAutomaticEffect> mTransitionEffects;
    private int randomIndex;
    private int randomType;
    private String rhythmEffectID;
    private String assetDir = "";
    private String templateDir = "";
    private String templateFileName = "";
    private String imagePagAssetDir = "";
    private List<MovieSegmentModel> rhythmSegmentModels = new ArrayList();
    private List<Integer> rhythmSecondEffectIndices = new ArrayList();

    public void clearAllRhythmCache() {
        setRhythmTemplate(false);
        setRhythmEffectID(null);
        clearSegmentModels();
        clearTransitionEffects();
        clearSecondEffectIndices();
        setRandomIndex(0);
        setRandomType(0);
    }

    public void clearSecondEffectIndices() {
        List<Integer> list = this.rhythmSecondEffectIndices;
        if (list != null) {
            list.clear();
        }
    }

    public void clearSegmentModels() {
        List<MovieSegmentModel> list = this.rhythmSegmentModels;
        if (list != null) {
            list.clear();
        }
    }

    public void clearTransitionEffects() {
        ArrayList<TAVTransitionAutomaticEffect> arrayList = this.mTransitionEffects;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public AEFrameModel getAEFrameModel() {
        return this.aeFrameModel;
    }

    public String getAssetDir() {
        return this.assetDir;
    }

    public String getImagePagAssetDir() {
        return this.imagePagAssetDir;
    }

    public int getRandomIndex() {
        return this.randomIndex;
    }

    public int getRandomType() {
        return this.randomType;
    }

    public String getRhythmEffectID() {
        return this.rhythmEffectID;
    }

    public List<Integer> getRhythmSecondEffectIndices() {
        return this.rhythmSecondEffectIndices;
    }

    public List<MovieSegmentModel> getRhythmSegmentModels() {
        return this.rhythmSegmentModels;
    }

    public String getTemplateDir() {
        return this.templateDir;
    }

    public String getTemplateFileName() {
        return this.templateFileName;
    }

    public ArrayList<TAVTransitionAutomaticEffect> getTransitionEffects() {
        return this.mTransitionEffects;
    }

    public boolean isContainSegments() {
        List<MovieSegmentModel> list = this.rhythmSegmentModels;
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (TextUtils.isEmpty(this.assetDir) && TextUtils.isEmpty(this.templateDir) && TextUtils.isEmpty(this.templateFileName)) {
            return true;
        }
        return false;
    }

    public boolean isRhythmTemplate() {
        return this.isRhythmTemplate;
    }

    public boolean isSwitchToTemplateByUser() {
        return this.isSwitchToTemplateByUser;
    }

    public void setAEFrameModel(AEFrameModel aEFrameModel) {
        this.aeFrameModel = aEFrameModel;
    }

    public void setAssetDir(String str) {
        this.assetDir = str;
    }

    public void setImagePagAssetDir(String str) {
        this.imagePagAssetDir = str;
    }

    public void setRandomIndex(int i3) {
        this.randomIndex = i3;
    }

    public void setRandomType(int i3) {
        this.randomType = i3;
    }

    public void setRhythmEffectID(String str) {
        this.rhythmEffectID = str;
    }

    public void setRhythmSecondEffectIndices(List<Integer> list) {
        this.rhythmSecondEffectIndices = list;
    }

    public void setRhythmSegmentModels(List<MovieSegmentModel> list) {
        this.rhythmSegmentModels = list;
    }

    public void setRhythmTemplate(boolean z16) {
        this.isRhythmTemplate = z16;
    }

    public void setSwitchToTemplateByUser(boolean z16) {
        this.isSwitchToTemplateByUser = z16;
    }

    public void setTemplateDir(String str) {
        this.templateDir = str;
    }

    public void setTemplateFileName(String str) {
        this.templateFileName = str;
    }

    public void setTransitionEffects(ArrayList<TAVTransitionAutomaticEffect> arrayList) {
        this.mTransitionEffects = arrayList;
    }
}
