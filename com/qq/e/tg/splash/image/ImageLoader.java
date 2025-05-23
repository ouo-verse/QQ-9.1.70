package com.qq.e.tg.splash.image;

import android.widget.ImageView;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.splash.image.ImageTask;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ImageLoader {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ImageLoader f40835a;

    protected ImageLoader() {
    }

    public static ImageLoader getInstance() {
        if (f40835a == null) {
            synchronized (ImageLoader.class) {
                if (f40835a == null) {
                    f40835a = new ImageLoader();
                }
            }
        }
        return f40835a;
    }

    public void displayImage(ImageTask.Params params) {
        ImageLoadingListener imageLoadingListener;
        if (params != null && params.isValid()) {
            GdtSDKThreadManager.getInstance().runOnThread(3, new ImageTask(params));
        } else {
            if (params == null || (imageLoadingListener = params.imageLoadingListener) == null) {
                return;
            }
            imageLoadingListener.onLoadingFailed(null, params.imageView, 406);
        }
    }

    public void displayImage(String str, ImageView imageView) {
        displayImage(str, imageView, null);
    }

    public void displayImage(String str, ImageView imageView, ImageLoadingListener imageLoadingListener) {
        if (StringUtil.isEmpty(str)) {
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingFailed(str, imageView, 406);
            }
        } else {
            ImageTask.Params params = new ImageTask.Params();
            params.imgUrl = str;
            params.imageView = imageView;
            params.imageLoadingListener = imageLoadingListener;
            GdtSDKThreadManager.getSubThreadHandler().post(new ImageTask(params));
        }
    }

    public void displayImage(String str, String str2, boolean z16, ImageView imageView, ImageLoadingListener imageLoadingListener) {
        if (StringUtil.isEmpty(str)) {
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingFailed(str, imageView, 406);
                return;
            }
            return;
        }
        if (!z16) {
            ImageTask.Params params = new ImageTask.Params();
            params.imgUrl = str;
            params.imageView = imageView;
            params.imageLoadingListener = imageLoadingListener;
            params.isGaussianUrl = false;
            GdtSDKThreadManager.getSubThreadHandler().post(new ImageTask(params));
        }
        if (StringUtil.isEmpty(str2)) {
            return;
        }
        ImageTask.Params params2 = new ImageTask.Params();
        params2.imgUrl = str2;
        params2.imageView = imageView;
        params2.isGaussianUrl = true;
        GdtSDKThreadManager.getSubThreadHandler().post(new ImageTask(params2));
    }
}
