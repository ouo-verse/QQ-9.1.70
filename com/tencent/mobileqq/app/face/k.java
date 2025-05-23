package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.avatar.api.impl.QQAvatarManagerServiceImpl;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.HeadRequest;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes11.dex */
public class k extends FaceDecoderBase implements DecodeCompletionListener, FaceDownloader.FaceDownloadListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    AppInterface f195597d;

    /* renamed from: e, reason: collision with root package name */
    FaceObserver f195598e;

    /* renamed from: f, reason: collision with root package name */
    FaceDownloader f195599f;

    public k(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f195597d = appInterface;
        FaceDownloader faceDownloader = ((QQAvatarManagerServiceImpl) appInterface.getRuntimeService(IQQAvatarManagerService.class, ProcessConstant.NEARBY)).getFaceDownloader();
        this.f195599f = faceDownloader;
        faceDownloader.addFaceDownloadListener(this);
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public void destory() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        FaceObserver faceObserver = this.f195598e;
        if (faceObserver != null && (appInterface = this.f195597d) != null) {
            appInterface.removeObserver(faceObserver);
            this.f195598e = null;
        }
        FaceDownloader faceDownloader = this.f195599f;
        if (faceDownloader != null && this.f195597d != null) {
            faceDownloader.removeFaceDownloadListener(this);
        }
        this.f195597d = null;
        super.destory();
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public Bitmap getBitmapFromCache(int i3, String str, int i16, byte b16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Byte.valueOf(b16), Integer.valueOf(i17));
        }
        if (this.f195597d == null) {
            return null;
        }
        String faceBmpCacheKey = FaceInfo.getFaceBmpCacheKey(i3, str, i16, b16, i17);
        Bitmap faceFromCache = ((IQQAvatarManagerService) this.f195597d.getRuntimeService(IQQAvatarManagerService.class, ProcessConstant.NEARBY)).getFaceFromCache(faceBmpCacheKey);
        if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "getBitmapFromcache bmpkey = " + faceBmpCacheKey + " and bmp = " + faceFromCache);
        }
        return faceFromCache;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public Drawable getFaceDrawableByBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, (Object) this, (Object) bitmap);
        }
        if (bitmap != null) {
            return new BitmapDrawable(bitmap);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.face.DecodeCompletionListener
    public void onDecodeTaskCompleted(FaceInfo faceInfo, Bitmap bitmap) {
        int i3;
        long j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) faceInfo, (Object) bitmap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onDecodeTaskCompleted,avatar=" + bitmap + ",faceInfo=" + faceInfo);
        }
        if (faceInfo != null && this.f195597d != null) {
            this.iRunningRequests--;
            if (!this.mReadyRequests.isEmpty() && !this.mPause) {
                runNextTask();
            }
            FaceInfo remove = this.mInProgress.remove(faceInfo.getFaceKey());
            if (remove != null) {
                int i16 = FaceInfo.TIME_REQ_END;
                if (bitmap != null) {
                    i3 = FaceInfo.RESULT_SUC;
                } else {
                    i3 = FaceInfo.RESULT_FAIL;
                }
                remove.markTime(i16, i3);
                if (this.mStatDecodeTime && bitmap != null) {
                    long[] jArr = remove.mTimes;
                    if (jArr[FaceInfo.TIME_REQ_END] > 0 && jArr[FaceInfo.TIME_BEGINE] > 0) {
                        j3 = jArr[FaceInfo.TIME_REQ_END] - jArr[FaceInfo.TIME_BEGINE];
                    } else {
                        j3 = 0;
                    }
                    if (j3 > 0) {
                        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
                        if (systemNetwork == 1) {
                            str = "actNearByFaceShowCostWIFI";
                        } else if (systemNetwork == 2) {
                            str = "actNearByFaceShowCost2G";
                        } else if (systemNetwork == 3) {
                            str = "actNearByFaceShowCost3G";
                        } else if (systemNetwork == 4) {
                            str = "actNearByFaceShowCost4G";
                        } else {
                            str = null;
                        }
                        String str2 = str;
                        if (str2 != null) {
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f195597d.getCurrentAccountUin(), str2, true, j3, 0L, null, "");
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onDecodeTaskCompleted.cost=" + j3);
                        }
                    }
                }
            }
            DecodeTaskCompletionListener decodeTaskCompletionListener = this.mDecodeTaskCompletionListener;
            if (decodeTaskCompletionListener != null && bitmap != null) {
                decodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), faceInfo.headType, faceInfo.uin, bitmap);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.face.DecodeCompletionListener
    public void onDecodeTaskCompletedNeedDownload(FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) faceInfo);
            return;
        }
        if (faceInfo != null && this.f195597d != null) {
            this.iRunningRequests--;
            if (faceInfo.headType == 32 && faceInfo.mHeadInfo == null && this.mInProgress.get(faceInfo.getFaceKey()) != null) {
                ((FaceHandler) this.f195597d.getBusinessHandler(FaceConstant.Nearby.NEAR_BY_FACE_HANDLER)).G2(faceInfo);
            }
            if (!this.mPause && !this.mReadyRequests.isEmpty() && this.iRunningRequests < this.maxDecodingTask) {
                runNextTask();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDownloader.FaceDownloadListener
    public void onFaceDownloadFinished(boolean z16, FaceInfo faceInfo, Bitmap bitmap) {
        int i3;
        long j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), faceInfo, bitmap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onFaceDownloadFinished,isSuccess=" + z16 + ",faceInfo=" + faceInfo + ",bitmap=" + bitmap);
        }
        if (faceInfo != null && this.f195597d != null) {
            FaceInfo remove = this.mInProgress.remove(faceInfo.getFaceKey());
            if (remove != null) {
                int i16 = FaceInfo.TIME_REQ_END;
                if (bitmap != null) {
                    i3 = FaceInfo.RESULT_SUC;
                } else {
                    i3 = FaceInfo.RESULT_FAIL;
                }
                remove.markTime(i16, i3);
                if (this.mStatDecodeTime && bitmap != null) {
                    long[] jArr = remove.mTimes;
                    if (jArr[FaceInfo.TIME_REQ_END] > 0 && jArr[FaceInfo.TIME_BEGINE] > 0) {
                        j3 = jArr[FaceInfo.TIME_REQ_END] - jArr[FaceInfo.TIME_BEGINE];
                    } else {
                        j3 = 0;
                    }
                    if (j3 > 0) {
                        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
                        if (systemNetwork == 1) {
                            str = "actNearByFaceShowCostWIFI";
                        } else if (systemNetwork == 2) {
                            str = "actNearByFaceShowCost2G";
                        } else if (systemNetwork == 3) {
                            str = "actNearByFaceShowCost3G";
                        } else if (systemNetwork == 4) {
                            str = "actNearByFaceShowCost4G";
                        } else {
                            str = "";
                        }
                        String str2 = str;
                        if (!TextUtils.isEmpty(str2)) {
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f195597d.getCurrentAccountUin(), str2, true, j3, 0L, null, "");
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onFaceDownloadFinished.cost=" + j3);
                        }
                    }
                }
            }
            DecodeTaskCompletionListener decodeTaskCompletionListener = this.mDecodeTaskCompletionListener;
            if (decodeTaskCompletionListener != null && bitmap != null) {
                decodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), faceInfo.headType, faceInfo.uin, bitmap);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public boolean preloadFacesWithFaceInfo(ArrayList<HeadRequest> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList)).booleanValue();
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "preloadFacesWithFaceInfo.size = " + arrayList.size());
        }
        new ArrayList(arrayList.size());
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            HeadRequest headRequest = arrayList.get(i3);
            if (getBitmapFromCache(32, headRequest.f306382d, headRequest.f306383e, (byte) 3, 0) == null) {
                requestDecodeFaceWithFaceInfo(headRequest.f306382d, headRequest.f306383e, true, 32, true, (byte) 1, 3, headRequest.f306385h);
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public void refreshFaceWithTimeStamp(int i3, String str, int i16, long j3, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public boolean requestDecodeFace(String str, int i3, boolean z16, int i16, boolean z17, byte b16, int i17, int i18, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Boolean.valueOf(z17), Byte.valueOf(b16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z18))).booleanValue();
        }
        if (str != null && str.length() >= 5) {
            String faceKey = FaceInfo.getFaceKey(i16, str, i3, i18);
            FaceInfo faceInfo = this.mInProgress.get(faceKey);
            if (faceInfo != null && !faceInfo.isTimeOut(FaceInfo.TIME_BEGINE, MiniBoxNoticeInfo.MIN_5)) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeStrangeFace, uin repeat. uin=" + str);
                }
                if (faceInfo.appendToTail && !z17) {
                    faceInfo.appendToTail = false;
                }
                return true;
            }
            FaceInfo faceInfo2 = new FaceInfo(i16, str, z17, (byte) 1, i17, false, i3, z18, i18);
            faceInfo2.markTime(FaceInfo.TIME_BEGINE);
            this.mInProgress.put(faceKey, faceInfo2);
            enqueueDecode(faceInfo2);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeStrangeFace fail , uin = " + str);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public boolean requestDecodeFaceWithFaceInfo(String str, int i3, boolean z16, int i16, boolean z17, byte b16, int i17, QQHeadInfo qQHeadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Boolean.valueOf(z17), Byte.valueOf(b16), Integer.valueOf(i17), qQHeadInfo)).booleanValue();
        }
        if (str != null && str.length() >= 5) {
            String faceKey = FaceInfo.getFaceKey(i16, str, i3, 0);
            FaceInfo faceInfo = this.mInProgress.get(faceKey);
            if (faceInfo != null && !faceInfo.isTimeOut(FaceInfo.TIME_BEGINE, MiniBoxNoticeInfo.MIN_5)) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeFaceWithFaceInfo, uin repeat. uin=" + str);
                }
                if (faceInfo.appendToTail && !z17) {
                    faceInfo.appendToTail = false;
                }
                if (qQHeadInfo != null) {
                    faceInfo.bindHeadInfo(qQHeadInfo);
                }
                return true;
            }
            FaceInfo faceInfo2 = new FaceInfo(i16, str, z17, (byte) 1, i17, false, i3, 1);
            faceInfo2.bindHeadInfo(qQHeadInfo);
            faceInfo2.markTime(FaceInfo.TIME_BEGINE);
            this.mInProgress.put(faceKey, faceInfo2);
            if (QLog.isColorLevel()) {
                QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeFaceWithFaceInfo.uin = " + str + ",faceinfo=" + faceInfo2);
            }
            enqueueDecode(faceInfo2);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeFaceWithFaceInfo fail , uin = " + str);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    protected void runNextTask() {
        FaceInfo faceInfo;
        Throwable th5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        try {
            faceInfo = this.mReadyRequests.removeFirst();
        } catch (Throwable th6) {
            faceInfo = null;
            th5 = th6;
        }
        try {
            this.iRunningRequests++;
            FaceDecodeTask.execute(FaceDecodeTask.getFaceDecodeTask(this.f195597d, faceInfo, this));
        } catch (Throwable th7) {
            th5 = th7;
            if (faceInfo != null) {
                this.iRunningRequests--;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "runNextTask faceInfo is " + faceInfo, th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.face.FaceDecoderBase
    public void setAppRuntime(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appInterface);
        } else if (this.f195597d != appInterface) {
            destory();
            this.f195597d = appInterface;
        }
    }
}
