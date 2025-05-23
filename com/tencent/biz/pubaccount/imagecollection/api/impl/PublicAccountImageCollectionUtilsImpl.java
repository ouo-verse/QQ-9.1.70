package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.biz.qrcode.util.h;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes32.dex */
public class PublicAccountImageCollectionUtilsImpl implements IPublicAccountImageCollectionUtils {
    public static final String IMAGE_KEY = "image_key";
    public static final String POSITION_X = "positionX";
    public static final String POSITION_Y = "positionY";
    public static final String TAG = "PublicAccountImageCollectionUtils";
    public static final String VIEW_HEIGHT = "viewHeight";
    public static final String VIEW_WIDTH = "viewWidth";
    public static ConcurrentHashMap<String, SoftReference<Bitmap>> animationBitmapList = new ConcurrentHashMap<>();

    /* loaded from: classes32.dex */
    class a implements WXShareHelper.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f79799d;

        a(String str) {
            this.f79799d = str;
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            String str = this.f79799d;
            if (str == null || !str.equals(baseResp.transaction)) {
                return;
            }
            BaseApplication.getContext();
            int i3 = baseResp.errCode;
            if (i3 != -2) {
                if (i3 != 0) {
                    h.T(1, R.string.hit);
                } else {
                    h.T(2, R.string.hj9);
                }
            }
            WXShareHelper.b0().q0(this);
        }
    }

    private static Bitmap scaleBitmapForWeChat(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i3 = width * height;
            if (i3 > 8000) {
                double sqrt = Math.sqrt(8000.0d / i3);
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) (width * sqrt), (int) (height * sqrt), true);
            }
            return bitmap;
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "scaleBitmapForWeChat ERROR e=" + e16.getMessage());
            return null;
        } catch (OutOfMemoryError e17) {
            System.gc();
            e17.printStackTrace();
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "scaleBitmapForWeChat ERROR OutOfMemoryError");
            return null;
        }
    }

    public static void shareToWechatWithThumb(BaseActivity baseActivity, String str, String str2, String str3, Bitmap bitmap, int i3) {
        int i16;
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (WXShareHelper.b0().e0()) {
            i16 = !WXShareHelper.b0().f0() ? R.string.f173258ih2 : -1;
        } else {
            i16 = R.string.f173257ih1;
        }
        if (i16 != -1) {
            h.T(0, i16);
        } else {
            String valueOf = String.valueOf(System.currentTimeMillis());
            WXShareHelper.b0().A(new a(valueOf));
            WXShareHelper.b0().L0(valueOf, str, scaleBitmapForWeChat(bitmap), str2, str3, i3 == 9 ? 0 : 1);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "title=" + str + ", description=" + str2 + ", shareUrl=" + str3 + ", action=" + i3);
        }
    }

    @Override // com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils
    public boolean openPublicAccountImageCollectionMainActivity(Activity activity, Intent intent, String str) {
        return openPublicAccountImageCollectionMainActivityInner(activity, intent, str);
    }

    public static boolean openPublicAccountImageCollectionMainActivityInner(Activity activity, Intent intent, String str) {
        if (activity == null || intent == null) {
            return false;
        }
        intent.putExtra(IPublicAccountImageCollectionMainActivity.ARTICLE_ID, str);
        activity.startActivity(intent);
        return true;
    }
}
