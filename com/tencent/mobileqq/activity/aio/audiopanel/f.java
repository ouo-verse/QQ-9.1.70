package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f implements ImageAssetDelegate {

    /* renamed from: a, reason: collision with root package name */
    private Context f178319a;

    /* renamed from: b, reason: collision with root package name */
    String f178320b;

    public f(Context context, String str) {
        this.f178319a = context;
        this.f178320b = AudioTransitionAnimManager.f178234j + str + LottieLoader.FILE_IMAGES;
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    @Nullable
    public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(this.f178320b + lottieImageAsset.getFileName());
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
            try {
                fileInputStream.close();
            } catch (Throwable th6) {
                QLog.i("LoginBtnImageAssetDelegate", 2, "fetchBitmap  close error " + th6.getMessage());
            }
            return decodeStream;
        } catch (Throwable th7) {
            th = th7;
            try {
                QLog.i("LoginBtnImageAssetDelegate", 2, "fetchBitmap error " + th.getMessage());
                return null;
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th8) {
                        QLog.i("LoginBtnImageAssetDelegate", 2, "fetchBitmap  close error " + th8.getMessage());
                    }
                }
            }
        }
    }
}
