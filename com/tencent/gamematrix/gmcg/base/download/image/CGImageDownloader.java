package com.tencent.gamematrix.gmcg.base.download.image;

import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.android.volley.VolleyError;
import com.android.volley.h;
import com.android.volley.toolbox.i;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.network.CGHttpReqManager;
import com.tencent.gamematrix.gmcg.base.utils.CGAppUtil;
import java.io.File;
import java.io.FileOutputStream;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGImageDownloader implements h.b<Bitmap>, h.a {
    private ResultListener mDownloadResultListener;
    private String mImageSavePath;
    private String mImageUrl;
    private String mReqTag = "CGImageDownloader@" + System.currentTimeMillis();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onImageDownloadResult(boolean z16, String str, String str2);
    }

    public CGImageDownloader(@NonNull String str, @NonNull String str2, ResultListener resultListener) {
        this.mImageUrl = str;
        this.mImageSavePath = CGAppUtil.getAppImgSaveDir() + File.separator + str2 + ".jpg";
        this.mDownloadResultListener = resultListener;
    }

    public void cancel() {
        CGHttpReqManager.get().cancelReqByTag(this.mReqTag);
    }

    public void download() {
        CGLog.i("CGImageDownloader download: " + this.mImageUrl + "|" + this.mImageSavePath);
        i iVar = new i(this.mImageUrl, this, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.RGB_565, this);
        iVar.setTag(this.mReqTag);
        CGHttpReqManager.get().newReq(iVar);
    }

    @Override // com.android.volley.h.a
    public void onErrorResponse(VolleyError volleyError) {
        if (volleyError != null && volleyError.networkResponse != null) {
            CGLog.e("CGImageDownloader onErrorResponse: " + volleyError.networkResponse.f31331a + "|" + new String(volleyError.networkResponse.f31332b));
        }
        ResultListener resultListener = this.mDownloadResultListener;
        if (resultListener != null) {
            resultListener.onImageDownloadResult(false, this.mImageUrl, this.mImageSavePath);
        }
    }

    @Override // com.android.volley.h.b
    public void onResponse(Bitmap bitmap) {
        boolean z16;
        CGLog.i("CGImageDownloader onResponse");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.mImageSavePath));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            z16 = true;
        } catch (Exception e16) {
            e16.printStackTrace();
            z16 = false;
        }
        ResultListener resultListener = this.mDownloadResultListener;
        if (resultListener != null) {
            resultListener.onImageDownloadResult(z16, this.mImageUrl, this.mImageSavePath);
        }
    }
}
