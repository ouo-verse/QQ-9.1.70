package com.tencent.biz.qcircleshadow.lib.variation;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleFaceBitmapListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.ipc.IBitmapBinder;
import eipc.EIPCResult;
import ew.c;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostFaceUtils {
    private static final String TAG = "HostFaceUtils";

    public static AppInterface getAppInterface() {
        if (getAppRunTime() instanceof AppInterface) {
            return (AppInterface) getAppRunTime();
        }
        return null;
    }

    public static AppRuntime getAppRunTime() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static IQQAvatarDataService getAvatarDataService() {
        return (IQQAvatarDataService) getAppRunTime().getRuntimeService(IQQAvatarDataService.class, "");
    }

    public static String getAvatarDownloadUrl(String str) {
        Setting qQHeadSettingFromDB = getAvatarDataService().getQQHeadSettingFromDB(str);
        if (qQHeadSettingFromDB == null) {
            return "";
        }
        return c.a(qQHeadSettingFromDB.url, 640, qQHeadSettingFromDB.bFaceFlags);
    }

    public static Bitmap getBitmapFromCache(String str) {
        return getAvatarDataService().getBitmapFromCache(str);
    }

    public static String getFaceBitmapCacheKey(int i3, String str, byte b16, int i16) {
        return getAvatarDataService().getFaceBitmapCacheKey(i3, str, b16, i16, 100, false);
    }

    public static Drawable getFaceDrawable(int i3, int i16, String str) {
        if (getAppInterface() != null) {
            return FaceDrawable.getFaceDrawable(getAppInterface(), i3, i16, str);
        }
        return null;
    }

    public static Drawable getHeadDrawable(String str) {
        return getHeadDrawable(str, 1);
    }

    @Nullable
    protected static BitmapDrawable getHeadDrawableByIPC(String str, int i3, @Nullable QCircleFaceBitmapListener qCircleFaceBitmapListener) {
        Bundle bundle = new Bundle();
        bundle.putString(IQCircleIPCApi.BUNDLE_KEY_TARGET_UIN, str);
        bundle.putInt(IQCircleIPCApi.BUNDLE_KEY_TARGET_HEAD_TYPE, i3);
        bundle.setClassLoader(HostFaceUtils.class.getClassLoader());
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), IQCircleIPCApi.MODULE_NAME, IQCircleIPCApi.ACTION_GET_HEAD_BITMAP, bundle);
        if (callServer != null && callServer.isSuccess()) {
            try {
                Bitmap bitmap = IBitmapBinder.Stub.asInterface(callServer.data.getBinder(IQCircleIPCApi.BUNDLE_KEY_IMAGE_BITMAP)).getBitmap();
                if (bitmap != null) {
                    if (qCircleFaceBitmapListener != null) {
                        qCircleFaceBitmapListener.getFaceBitmap(bitmap);
                    }
                    return new BitmapDrawable(bitmap);
                }
                if (qCircleFaceBitmapListener != null) {
                    qCircleFaceBitmapListener.getFaceBitmap(null);
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
        return null;
    }

    @Nullable
    protected static Drawable getHeadDrawableInMainProcess(String str, int i3, @Nullable QCircleFaceBitmapListener qCircleFaceBitmapListener) {
        Bitmap bitmapFromCache = getBitmapFromCache(getFaceBitmapCacheKey(i3, str, (byte) 3, 0, 100, true));
        QLog.d(TAG, 1, "getHeadDrawableInMainProcess uin=", str, ", bmp=", bitmapFromCache);
        if (bitmapFromCache != null) {
            return new BitmapDrawable(bitmapFromCache);
        }
        Drawable defaultDrawable = FaceDrawable.getDefaultDrawable(i3, 4);
        return getFaceDrawable(i3, str, 4, defaultDrawable, defaultDrawable, qCircleFaceBitmapListener);
    }

    public static String getQQAvatarDownLoadUrl(String str, byte b16, byte b17, int i3) {
        return AvatarDownloadUtil.getQQAvatarDownLoadUrl(str, b16, b17, i3);
    }

    public static String getFaceBitmapCacheKey(int i3, String str, byte b16, int i16, int i17, boolean z16) {
        return getAvatarDataService().getFaceBitmapCacheKey(i3, str, b16, i16, i17, z16);
    }

    public static Drawable getHeadDrawable(String str, int i3) {
        return getHeadDrawable(str, i3, null);
    }

    public static FaceDrawable getFaceDrawable(int i3, final String str, int i16, Drawable drawable, Drawable drawable2, @Nullable final QCircleFaceBitmapListener qCircleFaceBitmapListener) {
        if (getAppInterface() != null) {
            return FaceDrawable.getFaceDrawable(getAppInterface(), i3, String.valueOf(str), i16, drawable, drawable2, new FaceDrawable.OnLoadingStateChangeListener() { // from class: com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils.1
                @Override // com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener
                public void onLoadingStateChanged(int i17, int i18) {
                    QLog.d(HostFaceUtils.TAG, 2, "curState=", Integer.valueOf(i18), ",oldState=", Integer.valueOf(i17));
                    if (i18 == 1) {
                        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(HostFaceUtils.getAppInterface(), 1, 4, String.valueOf(str));
                        QCircleFaceBitmapListener qCircleFaceBitmapListener2 = qCircleFaceBitmapListener;
                        if (qCircleFaceBitmapListener2 != null) {
                            qCircleFaceBitmapListener2.getFaceBitmap(faceDrawable.getLoadedBitmap());
                            return;
                        }
                        return;
                    }
                    QCircleFaceBitmapListener qCircleFaceBitmapListener3 = qCircleFaceBitmapListener;
                    if (qCircleFaceBitmapListener3 != null) {
                        qCircleFaceBitmapListener3.getFaceBitmap(null);
                    }
                }
            });
        }
        return null;
    }

    public static Drawable getHeadDrawable(String str, int i3, @Nullable QCircleFaceBitmapListener qCircleFaceBitmapListener) {
        if (MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof AppInterface) {
            return getHeadDrawableInMainProcess(str, i3, qCircleFaceBitmapListener);
        }
        return getHeadDrawableByIPC(str, i3, qCircleFaceBitmapListener);
    }
}
