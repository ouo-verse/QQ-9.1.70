package com.tencent.tavmovie;

import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVMovieBuilder {
    private TAVMovie movie;
    private TAVTemplate template;

    public TAVMovieBuilder(TAVMovie tAVMovie) {
        this(tAVMovie, null);
    }

    public AudioMix buildAudioMix() {
        if (this.movie != null) {
            return buildSource().getAudioMix();
        }
        return null;
    }

    public TAVSource buildSource() {
        TAVMovie tAVMovie = this.movie;
        TAVComposition tAVComposition = null;
        if (tAVMovie == null) {
            return null;
        }
        TAVTemplate tAVTemplate = this.template;
        if (tAVTemplate != null) {
            tAVComposition = tAVTemplate.buildCompositionFromMovie(tAVMovie);
        }
        if (tAVComposition == null) {
            tAVComposition = this.movie.convertToComposition();
        }
        return new TAVCompositionBuilder(tAVComposition).buildSource();
    }

    public VideoComposition buildVideoComposition() {
        if (this.movie != null) {
            return buildSource().getVideoComposition();
        }
        return null;
    }

    public TAVMovieBuilder(TAVMovie tAVMovie, TAVTemplate tAVTemplate) {
        this.movie = tAVMovie;
        this.template = tAVTemplate;
    }
}
