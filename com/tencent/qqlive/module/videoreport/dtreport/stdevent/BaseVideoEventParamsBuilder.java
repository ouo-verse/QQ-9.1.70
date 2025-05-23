package com.tencent.qqlive.module.videoreport.dtreport.stdevent;

import com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseEventParamsBuilder;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.PlayParamConst;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes22.dex */
abstract class BaseVideoEventParamsBuilder<T> extends BaseEventParamsBuilder<T> {
    private Boolean mIsVertical;
    private PlayParamConst.PlayLoopType mPlayLoopType;
    private String mPlaySessionId;
    private PlayParamConst.PlayType mPlayType;
    private String mVideoContentId;
    private Integer mVideoHeight;
    private long mVideoStaticDuration;
    private Integer mVideoWidth;

    public BaseVideoEventParamsBuilder(String str, long j3, String str2) {
        this.mVideoContentId = str;
        this.mVideoStaticDuration = j3;
        this.mPlaySessionId = str2;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.IEventParamsBuilder
    public final Map<String, String> build() {
        String str;
        HashMap hashMap = new HashMap(this.mEventParams);
        putSingleParam(hashMap, PlayParamConst.ParamKey.VIDEO_CONTENT_ID, this.mVideoContentId);
        putSingleParam(hashMap, PlayParamConst.ParamKey.VIDEO_STATIC_DURATION, Long.valueOf(this.mVideoStaticDuration));
        putSingleParam(hashMap, "video_width", this.mVideoWidth);
        putSingleParam(hashMap, "video_height", this.mVideoHeight);
        Boolean bool = this.mIsVertical;
        if (bool == null) {
            str = null;
        } else if (bool.booleanValue()) {
            str = "1";
        } else {
            str = "0";
        }
        putSingleParam(hashMap, PlayParamConst.ParamKey.IS_VERTICAL, str);
        putSingleParam(hashMap, PlayParamConst.ParamKey.PLAY_SESSION_ID, this.mPlaySessionId);
        putSingleParam(hashMap, PlayParamConst.ParamKey.PLAY_TYPE, this.mPlayType);
        putSingleParam(hashMap, PlayParamConst.ParamKey.PLAY_LOOP_TYPE, this.mPlayLoopType);
        onBuild(hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.stdevent.BaseEventParamsBuilder
    public final BaseEventParamsBuilder.CheckResult checkValidity() {
        StringBuilder sb5 = new StringBuilder();
        String[] strArr = {"PlaySessionId", "VideoContentId"};
        boolean z16 = true;
        Object[] objArr = {this.mPlaySessionId, this.mVideoContentId};
        for (int i3 = 0; i3 < 2; i3++) {
            z16 &= checkSingleParam(sb5, strArr[i3], objArr[i3]);
        }
        return new BaseEventParamsBuilder.CheckResult(z16, sb5.toString());
    }

    abstract void onBuild(Map<String, String> map);

    public T setPlayLoopType(PlayParamConst.PlayLoopType playLoopType) {
        this.mPlayLoopType = playLoopType;
        return self();
    }

    public T setPlayType(PlayParamConst.PlayType playType) {
        this.mPlayType = playType;
        return self();
    }

    public T setVertical(boolean z16) {
        this.mIsVertical = Boolean.valueOf(z16);
        return self();
    }

    public T setVideoHeight(int i3) {
        this.mVideoHeight = Integer.valueOf(i3);
        return self();
    }

    public T setVideoWidth(int i3) {
        this.mVideoWidth = Integer.valueOf(i3);
        return self();
    }
}
