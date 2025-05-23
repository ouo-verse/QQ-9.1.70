package com.tencent.qcircle.weseevideo.composition.builder;

import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.qcircle.weseevideo.model.template.light.LightTemplate;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieTemplate;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MediaBuilderOutput {
    private TAVAutomaticTemplate automaticTemplate;
    private LightTemplate lightTemplate;
    private MovieTemplate movieTemplate;

    public TAVAutomaticTemplate getAutomaticTemplate() {
        return this.automaticTemplate;
    }

    public LightTemplate getLightTemplate() {
        return this.lightTemplate;
    }

    public MovieTemplate getMovieTemplate() {
        return this.movieTemplate;
    }

    public void setAutomaticTemplate(TAVAutomaticTemplate tAVAutomaticTemplate) {
        this.automaticTemplate = tAVAutomaticTemplate;
    }

    public void setLightTemplate(LightTemplate lightTemplate) {
        this.lightTemplate = lightTemplate;
    }

    public void setMovieTemplate(MovieTemplate movieTemplate) {
        this.movieTemplate = movieTemplate;
    }
}
