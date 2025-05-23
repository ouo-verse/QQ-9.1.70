package com.qzone.publish.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.util.image.ImageInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.util.QZLog;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {
    public static int c(String str) {
        String[] mimeType;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        String mimeType2 = MimeTypesTools.getMimeType(BaseApplication.getContext(), str);
        if (TextUtils.isEmpty(mimeType2) || (mimeType = MimeHelper.getMimeType(mimeType2)) == null) {
            return -1;
        }
        return QAlbumUtil.MEDIA_TYPE_MAPS.get(mimeType[0]).intValue();
    }

    public static boolean d() {
        Bundle bundle;
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneVideoSoDownloadModule", "action_check_avcodec_is_ok", null);
        if (callServer != null && (bundle = callServer.data) != null) {
            boolean z16 = bundle.getBoolean("key_is_avcodec_ok", false);
            QZLog.i("[upload2] [PublishUtils]", 1, "is libavcodec loaded : " + z16);
            return z16;
        }
        QZLog.e("[upload2] [PublishUtils]", "call remote action_check_avcodec_is_ok error, return default false");
        return false;
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isDirectory();
    }

    public static boolean f() {
        boolean z16 = QZoneVideoCommonUtils.getTrimSupport().isAvailable() && d();
        QZLog.i("[upload2] [PublishUtils]", "check VideoCompressEnv: " + z16);
        return z16;
    }

    public static ArrayList<MediaWrapper> h(List<String> list) {
        ArrayList<MediaWrapper> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    QZLog.e("[upload2] [PublishUtils]", "wrapperImage2Media, path:" + str);
                    arrayList.add(new MediaWrapper(new ImageInfo(str)));
                }
            }
        }
        return arrayList;
    }

    public static boolean b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.length() > 0;
            }
            return false;
        } catch (Throwable th5) {
            QZLog.e("[upload2] [PublishUtils]", "checkFile error", th5);
            return false;
        }
    }

    public static boolean g(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            QZLog.e("[upload2] [PublishUtils]", "isVideoNeedCompress false video info = null");
            return false;
        }
        if (!shuoshuoVideoInfo.mNeedProcess) {
            QZLog.e("[upload2] [PublishUtils]", "isVideoNeedCompress false mNeedProcess = false");
            return false;
        }
        if (!f() && shuoshuoVideoInfo.mVideoType != 0) {
            return false;
        }
        QZLog.e("[upload2] [PublishUtils]", "videoInfo.mVideoType = 0");
        return true;
    }

    public static boolean a(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            return false;
        }
        QZLog.i("[upload2] [PublishUtils]", "upload2_canUploadWithoutCompress videoPath:" + shuoshuoVideoInfo.mVideoPath + ", startTime:" + shuoshuoVideoInfo.mStartTime + ", endTime:" + shuoshuoVideoInfo.mEndTime + ", totalDuration:" + shuoshuoVideoInfo.mTotalDuration);
        if (TextUtils.isEmpty(shuoshuoVideoInfo.mVideoPath)) {
            return false;
        }
        File file = new File(shuoshuoVideoInfo.mVideoPath);
        return file.exists() && !file.isDirectory() && shuoshuoVideoInfo.mStartTime == 0 && shuoshuoVideoInfo.mDuration == shuoshuoVideoInfo.mTotalDuration;
    }
}
