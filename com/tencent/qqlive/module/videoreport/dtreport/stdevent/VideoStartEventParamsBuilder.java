package com.tencent.qqlive.module.videoreport.dtreport.stdevent;

import android.support.annotation.CallSuper;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.PlayParamConst;
import java.util.Map;

/* loaded from: classes22.dex */
public class VideoStartEventParamsBuilder extends BaseVideoEventParamsBuilder<VideoStartEventParamsBuilder> {
    private long mPlayStartTime;

    public VideoStartEventParamsBuilder(String str, long j3, String str2, long j16) {
        super(str, j3, str2);
        this.mPlayStartTime = j16;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseVideoEventParamsBuilder
    @CallSuper
    void onBuild(Map<String, String> map) {
        putSingleParam(map, PlayParamConst.ParamKey.PLAY_START_TIME, String.valueOf(this.mPlayStartTime));
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseEventParamsBuilder
    public /* bridge */ /* synthetic */ Object setCustomParams(Map map) {
        return super.setCustomParams(map);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.qqlive.module.videoreport.dtreport.stdevent.VideoStartEventParamsBuilder] */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseVideoEventParamsBuilder
    public /* bridge */ /* synthetic */ VideoStartEventParamsBuilder setPlayLoopType(PlayParamConst.PlayLoopType playLoopType) {
        return super.setPlayLoopType(playLoopType);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.qqlive.module.videoreport.dtreport.stdevent.VideoStartEventParamsBuilder] */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseVideoEventParamsBuilder
    public /* bridge */ /* synthetic */ VideoStartEventParamsBuilder setPlayType(PlayParamConst.PlayType playType) {
        return super.setPlayType(playType);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.qqlive.module.videoreport.dtreport.stdevent.VideoStartEventParamsBuilder] */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseVideoEventParamsBuilder
    public /* bridge */ /* synthetic */ VideoStartEventParamsBuilder setVertical(boolean z16) {
        return super.setVertical(z16);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.qqlive.module.videoreport.dtreport.stdevent.VideoStartEventParamsBuilder] */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseVideoEventParamsBuilder
    public /* bridge */ /* synthetic */ VideoStartEventParamsBuilder setVideoHeight(int i3) {
        return super.setVideoHeight(i3);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.qqlive.module.videoreport.dtreport.stdevent.VideoStartEventParamsBuilder] */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseVideoEventParamsBuilder
    public /* bridge */ /* synthetic */ VideoStartEventParamsBuilder setVideoWidth(int i3) {
        return super.setVideoWidth(i3);
    }
}
