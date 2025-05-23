package com.tencent.qcircle.weseevideo.model.template;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.light.LightMediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieMediaTemplateModel;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MediaTemplateModel {
    private String smartMatchTemplateTips;
    private MovieMediaTemplateModel movieMediaTemplateModel = new MovieMediaTemplateModel();
    private AutomaticMediaTemplateModel automaticMediaTemplateModel = new AutomaticMediaTemplateModel();
    private LightMediaTemplateModel lightMediaTemplateModel = new LightMediaTemplateModel();
    private MediaResourceModel originMediaResourceModel = null;

    @NonNull
    public AutomaticMediaTemplateModel getAutomaticMediaTemplateModel() {
        return this.automaticMediaTemplateModel;
    }

    public LightMediaTemplateModel getLightMediaTemplateModel() {
        return this.lightMediaTemplateModel;
    }

    @NonNull
    public MovieMediaTemplateModel getMovieMediaTemplateModel() {
        return this.movieMediaTemplateModel;
    }

    public MediaResourceModel getOriginMediaResourceModel() {
        return this.originMediaResourceModel;
    }

    @Nullable
    public String getSmartMatchTemplateTips() {
        return this.smartMatchTemplateTips;
    }

    public boolean isAutoTemplateEmpty() {
        return this.automaticMediaTemplateModel.isEmpty();
    }

    public boolean isEmpty() {
        if (isAutoTemplateEmpty() && isMovieTemplateEmpty() && isLightTemplateEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isLightTemplateEmpty() {
        return this.lightMediaTemplateModel.isEmpty();
    }

    public boolean isMovieTemplateEmpty() {
        return this.movieMediaTemplateModel.isEmpty();
    }

    public void setAutomaticMediaTemplateModel(@NonNull AutomaticMediaTemplateModel automaticMediaTemplateModel) {
        this.automaticMediaTemplateModel = automaticMediaTemplateModel;
    }

    public void setLightMediaTemplateModel(LightMediaTemplateModel lightMediaTemplateModel) {
        this.lightMediaTemplateModel = lightMediaTemplateModel;
    }

    public void setMovieMediaTemplateModel(@NonNull MovieMediaTemplateModel movieMediaTemplateModel) {
        this.movieMediaTemplateModel = movieMediaTemplateModel;
    }

    public void setOriginMediaResourceModel(MediaResourceModel mediaResourceModel) {
        this.originMediaResourceModel = mediaResourceModel;
    }

    public void setSmartMatchTemplateTips(@Nullable String str) {
        this.smartMatchTemplateTips = str;
    }
}
