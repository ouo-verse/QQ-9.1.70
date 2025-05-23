package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.richmediabrowser.api.IVideoDepend;
import com.tencent.mobileqq.richmediabrowser.utils.f;
import com.tencent.mobileqq.shortvideo.h;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.util.Pair;
import cooperation.peak.PeakConstants;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.d;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class VideoDependImpl implements IVideoDepend {
    @Override // com.tencent.mobileqq.richmediabrowser.api.IVideoDepend
    public VideoPlayParam buildVideoPlayParam(MessageRecord messageRecord, VideoPlayParam videoPlayParam) {
        if ((messageRecord instanceof MessageForShortVideo) && videoPlayParam != null) {
            videoPlayParam.mVideoFileTimeMs = r3.videoFileTime * 1000;
            videoPlayParam.mFileID = h.a((MessageForShortVideo) messageRecord);
            videoPlayParam.mFileSize = r3.videoFileSize;
            return videoPlayParam;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IVideoDepend
    public void dealAddFavorite(Intent intent, Activity activity, AppRuntime appRuntime, int i3, int i16, int i17) {
        QfavBuilder.i0(intent).h(activity, BaseApplicationImpl.getApplication().getRuntime().getAccount());
        d.b(appRuntime, i3, i16, i17);
        d.e(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IVideoDepend
    public String getCameraMaterialName() {
        return PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IVideoDepend
    public String getCameraVideoParam() {
        return PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IVideoDepend
    public int getVideoIpType() {
        return 1005;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IVideoDepend
    public Pair<Boolean, Boolean> hasCode(Bitmap bitmap) {
        ScannerResult decodeQQCodeFromBmp = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromBmp(bitmap, 3);
        if (decodeQQCodeFromBmp != null) {
            return new Pair<>(Boolean.valueOf(decodeQQCodeFromBmp.l()), Boolean.valueOf(decodeQQCodeFromBmp.j()));
        }
        Boolean bool = Boolean.FALSE;
        return new Pair<>(bool, bool);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IVideoDepend
    public void onQRDecodeSucceed(Context context, String str, int i3, boolean z16, String str2, String str3, String str4, String str5, int i16, String str6, String str7) {
        if (i16 == 1) {
            Intent intent = new Intent();
            intent.putExtra("detectType", 1);
            intent.putExtra("fromPicQRDecode", true);
            f.c(context, str, i3, z16, str2, str3, str4, str5, 1, str6, str7, intent);
            return;
        }
        if (i16 == 2) {
            Intent intent2 = new Intent();
            intent2.putExtra("detectType", 2);
            intent2.putExtra("fromPicQRDecode", true);
            f.c(context, str, i3, z16, str2, str3, str4, str5, 2, str6, str7, intent2);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IVideoDepend
    public void sendToQZone(Activity activity, String str, String str2) {
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = str;
        QZoneHelper.forwardToPublishMood(activity, userInfo, str2, 10001);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IVideoDepend
    public void stopPttMsgPlay(AppRuntime appRuntime) {
        MediaPlayerManager q16 = MediaPlayerManager.q(appRuntime);
        if (q16 != null && q16.t()) {
            ReportController.o(null, "dc00898", "", "", "0X800C391", "0X800C391", 5, 0, "", "", "", "");
            q16.D(false);
        }
    }
}
