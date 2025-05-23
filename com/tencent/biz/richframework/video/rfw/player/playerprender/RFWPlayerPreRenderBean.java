package com.tencent.biz.richframework.video.rfw.player.playerprender;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import java.util.LinkedList;

/* loaded from: classes5.dex */
public class RFWPlayerPreRenderBean {
    private Activity mActivity;
    private RFWStVideo mCurrentVideo;
    private boolean mForceRender;
    private final int mFromType;
    private boolean mIsJumpTrigger;
    private boolean mIsMultiLevel;
    private RFWPlayerOptions mPlayerOptions;
    private RFWPlayerReportInfo mPreloadOriginData;
    private RFWStVideo mPreloadVideo;
    private LinkedList<String> mProcessOrder = new LinkedList<>();
    private final int mSceneId;
    private String mSourceType;

    public RFWPlayerPreRenderBean(int i3, int i16) {
        this.mSceneId = i3;
        this.mFromType = i16;
    }

    private void updateOptionPreloadSource() {
        if (this.mPlayerOptions != null && !TextUtils.isEmpty(this.mSourceType)) {
            this.mPlayerOptions.setPreloadSourceType(this.mSourceType);
        }
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public RFWStVideo getCurrentVideo() {
        return this.mCurrentVideo;
    }

    public int getFromType() {
        return this.mFromType;
    }

    public RFWPlayerOptions getPlayerOptions() {
        return this.mPlayerOptions;
    }

    public RFWPlayerReportInfo getPreloadOriginData() {
        return this.mPreloadOriginData;
    }

    public RFWStVideo getPreloadVideo() {
        return this.mPreloadVideo;
    }

    public LinkedList<String> getProcessOrder() {
        return this.mProcessOrder;
    }

    public int getSceneId() {
        return this.mSceneId;
    }

    public String getSourceType() {
        return this.mSourceType;
    }

    public boolean isForceRender() {
        return this.mForceRender;
    }

    public boolean isJumpTrigger() {
        return this.mIsJumpTrigger;
    }

    public boolean isMultiLevel() {
        return this.mIsMultiLevel;
    }

    public RFWPlayerPreRenderBean setActivity(Activity activity) {
        this.mActivity = activity;
        return this;
    }

    public RFWPlayerPreRenderBean setCurrentPlayVideo(RFWStVideo rFWStVideo) {
        this.mCurrentVideo = rFWStVideo;
        return this;
    }

    public RFWPlayerPreRenderBean setForceRender(boolean z16) {
        this.mForceRender = z16;
        return this;
    }

    public RFWPlayerPreRenderBean setIsJumpTrigger(boolean z16) {
        this.mIsJumpTrigger = z16;
        if (z16) {
            this.mForceRender = true;
        }
        return this;
    }

    public RFWPlayerPreRenderBean setMultiLevel(boolean z16) {
        this.mIsMultiLevel = z16;
        return this;
    }

    public RFWPlayerPreRenderBean setPlayerOptions(RFWPlayerOptions rFWPlayerOptions) {
        this.mPlayerOptions = rFWPlayerOptions;
        updateOptionPreloadSource();
        return this;
    }

    public RFWPlayerPreRenderBean setPreloadOriginData(RFWPlayerReportInfo rFWPlayerReportInfo) {
        this.mPreloadOriginData = rFWPlayerReportInfo;
        return this;
    }

    public RFWPlayerPreRenderBean setPreloadVideo(RFWStVideo rFWStVideo) {
        this.mPreloadVideo = rFWStVideo;
        return this;
    }

    public RFWPlayerPreRenderBean setProcessOrder(LinkedList<String> linkedList) {
        if (linkedList == null) {
            return this;
        }
        this.mProcessOrder = linkedList;
        return this;
    }

    public RFWPlayerPreRenderBean setSourceType(String str) {
        this.mSourceType = str;
        updateOptionPreloadSource();
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("QFSPlayerPreRenderBean{");
        stringBuffer.append("mFromType=");
        stringBuffer.append(this.mFromType);
        stringBuffer.append(" mForceRender=");
        stringBuffer.append(this.mForceRender);
        stringBuffer.append(", mActivity=");
        stringBuffer.append(this.mActivity);
        stringBuffer.append(", mIsMultiLevel=");
        stringBuffer.append(this.mIsMultiLevel);
        stringBuffer.append(", mPlayerOptions=");
        stringBuffer.append(this.mPlayerOptions);
        stringBuffer.append(", mSourceType=");
        stringBuffer.append(this.mSourceType);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
