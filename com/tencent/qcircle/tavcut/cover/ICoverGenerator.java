package com.tencent.qcircle.tavcut.cover;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.composition.TAVSource;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ICoverGenerator {
    void generateCoverByIndex(int i3, CMTime cMTime);

    void generateCoverByIndexRange(int i3, int i16);

    void generateCoverByTimeRange(long j3, long j16);

    void init(TAVSource tAVSource, long j3, int i3, int i16, int i17);

    void init(TAVSource tAVSource, List<CMTime> list, int i3, int i16);

    void pause();

    void release();

    void resume();

    void setCoverCache(CoverCache coverCache);

    void setRenderContextParamas(RenderContextParams renderContextParams);
}
