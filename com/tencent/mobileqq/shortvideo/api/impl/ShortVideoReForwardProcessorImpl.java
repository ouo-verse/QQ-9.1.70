package com.tencent.mobileqq.shortvideo.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor;
import com.tencent.mobileqq.shortvideo.ac;
import com.tencent.mobileqq.shortvideo.api.IShortVideoReForwardProcessor;
import com.tencent.mobileqq.shortvideo.h;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes18.dex */
public class ShortVideoReForwardProcessorImpl implements IShortVideoReForwardProcessor {
    private static final String TAG = "ShortVideoReForwardProcessorImpl";

    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoReForwardProcessor
    public boolean handleForwardVideoNotExistsOnServer(BaseQQAppInterface baseQQAppInterface, MessageForShortVideo messageForShortVideo) {
        if (!(baseQQAppInterface instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "[H265_VIDEO]", Long.valueOf(messageForShortVideo.uniseq), " handleForwardVideoNotExistsOnServer return, app is not QQAppInterface.");
            return false;
        }
        if (messageForShortVideo == null) {
            QLog.e(TAG, 1, "[H265_VIDEO]", " handleForwardVideoNotExistsOnServer return, msg is null.");
            return false;
        }
        if (!h.l(baseQQAppInterface)) {
            QLog.d(TAG, 1, "[H265_VIDEO]", Long.valueOf(messageForShortVideo.uniseq), " handleForwardVideoNotExistsOnServer return, disable transcoding h265 to h264 when forward video.");
            return false;
        }
        if (!h.m(messageForShortVideo)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[H265_VIDEO]", Long.valueOf(messageForShortVideo.uniseq), " handleForwardVideoNotExistsOnServer return, not h265 video.");
            }
            return false;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) baseQQAppInterface;
        if (!ac.d(ac.c(j.i(messageForShortVideo)), ac.b(qQAppInterface))) {
            QLog.d(TAG, 1, "[H265_VIDEO]", Long.valueOf(messageForShortVideo.uniseq), " handleForwardVideoNotExistsOnServer return, don't need to transcoding to H264 by compressing video.");
            return false;
        }
        messageForShortVideo.md5 = null;
        VideoCompressProcessor.b().d(messageForShortVideo.uniseq, new VideoCompressProcessor.CompressTask(qQAppInterface, BaseApplication.getContext(), messageForShortVideo, null));
        return true;
    }
}
