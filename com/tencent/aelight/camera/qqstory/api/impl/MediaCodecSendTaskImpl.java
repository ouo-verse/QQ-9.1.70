package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.c;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.VideoSendPublicParam;
import com.tencent.aelight.camera.qqstory.api.IMediaCodecSendTask;
import com.tencent.aelight.camera.struct.editor.VideoSendPublicParamBase;

/* compiled from: P */
/* loaded from: classes32.dex */
public class MediaCodecSendTaskImpl implements IMediaCodecSendTask {
    VideoSendPublicParam createParam(VideoSendPublicParamBase videoSendPublicParamBase) {
        VideoSendPublicParam videoSendPublicParam = new VideoSendPublicParam();
        if (videoSendPublicParamBase == null) {
            return videoSendPublicParam;
        }
        videoSendPublicParam.mContext = videoSendPublicParamBase.mContext;
        videoSendPublicParam.mVideoCacheDir = videoSendPublicParamBase.mVideoCacheDir;
        videoSendPublicParam.mEncodeMode = videoSendPublicParamBase.mEncodeMode;
        videoSendPublicParam.mVideoFilePath = videoSendPublicParamBase.mVideoFilePath;
        videoSendPublicParam.mThumbFilePath = videoSendPublicParamBase.mThumbFilePath;
        videoSendPublicParam.mThumbWidth = videoSendPublicParamBase.mThumbWidth;
        videoSendPublicParam.mThumbHeight = videoSendPublicParamBase.mThumbHeight;
        videoSendPublicParam.fakeVid = videoSendPublicParamBase.fakeVid;
        videoSendPublicParam.recordTime = videoSendPublicParamBase.recordTime;
        videoSendPublicParam.mUserCallBack = videoSendPublicParamBase.mUserCallBack;
        videoSendPublicParam.mContent = videoSendPublicParamBase.mContent;
        videoSendPublicParam.mPriv = videoSendPublicParamBase.mPriv;
        videoSendPublicParam.mPrivUinList = videoSendPublicParamBase.mPrivUinList;
        videoSendPublicParam.mEnableEditVideo = videoSendPublicParamBase.mEnableEditVideo;
        videoSendPublicParam.topicSyncQzone = videoSendPublicParamBase.topicSyncQzone;
        videoSendPublicParam.fontId = videoSendPublicParamBase.fontId;
        videoSendPublicParam.fontFormatType = videoSendPublicParamBase.fontFormatType;
        videoSendPublicParam.fontUrl = videoSendPublicParamBase.fontUrl;
        videoSendPublicParam.superFontId = videoSendPublicParamBase.superFontId;
        videoSendPublicParam.superFontInfo = videoSendPublicParamBase.superFontInfo;
        videoSendPublicParam.generateGif = videoSendPublicParamBase.generateGif;
        videoSendPublicParam.timerDelete = videoSendPublicParamBase.timerDelete;
        videoSendPublicParam.isUploadOrigin = videoSendPublicParamBase.isUploadOrigin;
        videoSendPublicParam.entrySource = videoSendPublicParamBase.entrySource;
        videoSendPublicParam.mUin = videoSendPublicParamBase.mUin;
        videoSendPublicParam.mUinType = videoSendPublicParamBase.mUinType;
        videoSendPublicParam.mTroopUin = videoSendPublicParamBase.mTroopUin;
        return videoSendPublicParam;
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IMediaCodecSendTask
    public void execute(VideoSendPublicParamBase videoSendPublicParamBase) {
        new c(createParam(videoSendPublicParamBase)).execute(new Void[0]);
    }
}
