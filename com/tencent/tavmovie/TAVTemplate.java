package com.tencent.tavmovie;

import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavmovie.base.TAVMovieClip;
import com.tencent.tavmovie.base.TAVMovieSegment;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TAVTemplate {
    TAVComposition buildCompositionFromMovie(TAVMovie tAVMovie);

    List<TAVMovieSegment> convertClips(List<TAVMovieClip> list);

    List<TAVMovieClip> getMovieClips();

    void parseToMovie(TAVMovie tAVMovie);
}
