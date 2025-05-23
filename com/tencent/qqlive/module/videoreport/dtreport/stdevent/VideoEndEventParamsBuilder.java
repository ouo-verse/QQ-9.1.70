package com.tencent.qqlive.module.videoreport.dtreport.stdevent;

import android.support.annotation.CallSuper;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.PlayParamConst;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes22.dex */
public class VideoEndEventParamsBuilder extends BaseVideoEventParamsBuilder<VideoEndEventParamsBuilder> {
    private long mPlayEndTime;
    private long mPlayLvtm;
    private double mPlayPer;
    private String mVideoErrorCode;

    public VideoEndEventParamsBuilder(String str, long j3, String str2, long j16, long j17, double d16) {
        super(str, j3, str2);
        this.mPlayEndTime = j16;
        this.mPlayLvtm = j17;
        this.mPlayPer = d16;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseVideoEventParamsBuilder
    @CallSuper
    void onBuild(Map<String, String> map) {
        putSingleParam(map, "video_error_code", this.mVideoErrorCode);
        putSingleParam(map, PlayParamConst.ParamKey.PLAY_END_TIME, Long.valueOf(this.mPlayEndTime));
        putSingleParam(map, PlayParamConst.ParamKey.PLAY_LVTM, Long.valueOf(this.mPlayLvtm));
        putSingleParam(map, PlayParamConst.ParamKey.PLAY_PER, String.format(Locale.getDefault(), "%.2f", Double.valueOf(this.mPlayPer)));
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseEventParamsBuilder
    public /* bridge */ /* synthetic */ Object setCustomParams(Map map) {
        return super.setCustomParams(map);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.qqlive.module.videoreport.dtreport.stdevent.VideoEndEventParamsBuilder] */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseVideoEventParamsBuilder
    public /* bridge */ /* synthetic */ VideoEndEventParamsBuilder setPlayLoopType(PlayParamConst.PlayLoopType playLoopType) {
        return super.setPlayLoopType(playLoopType);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.qqlive.module.videoreport.dtreport.stdevent.VideoEndEventParamsBuilder] */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseVideoEventParamsBuilder
    public /* bridge */ /* synthetic */ VideoEndEventParamsBuilder setPlayType(PlayParamConst.PlayType playType) {
        return super.setPlayType(playType);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.qqlive.module.videoreport.dtreport.stdevent.VideoEndEventParamsBuilder] */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseVideoEventParamsBuilder
    public /* bridge */ /* synthetic */ VideoEndEventParamsBuilder setVertical(boolean z16) {
        return super.setVertical(z16);
    }

    public VideoEndEventParamsBuilder setVideoErrorCode(String str) {
        this.mVideoErrorCode = str;
        return this;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.qqlive.module.videoreport.dtreport.stdevent.VideoEndEventParamsBuilder] */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseVideoEventParamsBuilder
    public /* bridge */ /* synthetic */ VideoEndEventParamsBuilder setVideoHeight(int i3) {
        return super.setVideoHeight(i3);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.tencent.qqlive.module.videoreport.dtreport.stdevent.VideoEndEventParamsBuilder] */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseVideoEventParamsBuilder
    public /* bridge */ /* synthetic */ VideoEndEventParamsBuilder setVideoWidth(int i3) {
        return super.setVideoWidth(i3);
    }
}
