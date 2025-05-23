package com.tencent.tavkit.composition.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RenderInfo {
    private final CIContext ciContext;
    private final CGSize renderSize;
    private final CMTime time;
    private final List<TAVVideoCompositionTrack> tracks = new ArrayList();

    public RenderInfo(@NonNull CMTime cMTime, @NonNull CGSize cGSize, @NonNull CIContext cIContext) {
        this.time = cMTime;
        this.renderSize = cGSize;
        this.ciContext = cIContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTrack(TAVVideoCompositionTrack tAVVideoCompositionTrack) {
        if (!this.tracks.contains(tAVVideoCompositionTrack)) {
            this.tracks.add(tAVVideoCompositionTrack);
        }
    }

    @NonNull
    public CIContext getCiContext() {
        return this.ciContext;
    }

    @Nullable
    public Object getParam(String str) {
        RenderContextParams params = this.ciContext.getRenderContext().getParams();
        if (params != null) {
            return params.getParam(str);
        }
        return null;
    }

    public int getRenderHeight() {
        return (int) this.renderSize.height;
    }

    @NonNull
    public CGSize getRenderSize() {
        return this.renderSize;
    }

    public int getRenderWidth() {
        return (int) this.renderSize.width;
    }

    @NonNull
    public CMTime getTime() {
        return this.time;
    }

    @Nullable
    public Object getTrackExtraInfo(String str) {
        Iterator<TAVVideoCompositionTrack> it = this.tracks.iterator();
        while (it.hasNext()) {
            Object extraTrackInfo = it.next().getExtraTrackInfo(str);
            if (extraTrackInfo != null) {
                return extraTrackInfo;
            }
        }
        return null;
    }

    @NonNull
    public List<TAVVideoCompositionTrack> getTracks() {
        return this.tracks;
    }

    public void putParam(String str, Object obj) {
        RenderContextParams params = this.ciContext.getRenderContext().getParams();
        if (params != null) {
            params.putParam(str, obj);
        }
    }
}
