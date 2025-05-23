package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendH5GameChannel implements Serializable {
    public GProRecommendCoverInfo cover;
    public GProRecommendH5Game data;
    long serialVersionUID;

    public GProRecommendH5GameChannel() {
        this.serialVersionUID = 1L;
        this.data = new GProRecommendH5Game();
        this.cover = new GProRecommendCoverInfo();
    }

    public GProRecommendCoverInfo getCover() {
        return this.cover;
    }

    public GProRecommendH5Game getData() {
        return this.data;
    }

    public String toString() {
        return "GProRecommendH5GameChannel{data=" + this.data + ",cover=" + this.cover + ",}";
    }

    public GProRecommendH5GameChannel(GProRecommendH5Game gProRecommendH5Game, GProRecommendCoverInfo gProRecommendCoverInfo) {
        this.serialVersionUID = 1L;
        this.data = new GProRecommendH5Game();
        new GProRecommendCoverInfo();
        this.data = gProRecommendH5Game;
        this.cover = gProRecommendCoverInfo;
    }
}
