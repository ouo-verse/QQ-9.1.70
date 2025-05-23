package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
class GuideVideoHandler$2 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f185716d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f185717e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ MqqHandler f185718f;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        MediaMetadataRetriever mediaMetadataRetriever;
        Bitmap bitmap;
        Message obtainMessage;
        Bitmap frameAtTime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Uri parse = Uri.parse("android.resource://" + this.f185716d.getApplicationContext().getPackageName() + "/" + R.raw.f169435a2);
        try {
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            } catch (Exception e16) {
                e = e16;
                mediaMetadataRetriever = null;
            } catch (OutOfMemoryError unused) {
                mediaMetadataRetriever = null;
            } catch (Throwable th5) {
                th = th5;
                mediaMetadataRetriever = null;
                bitmap = null;
            }
            try {
                mediaMetadataRetriever.setDataSource(this.f185716d, parse);
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.f185717e * 1000);
            } catch (Exception e17) {
                e = e17;
                if (QLog.isColorLevel()) {
                    QLog.d("LoginActivity.GuideVideoHandler", 2, e, "getVideoFrame --- Exception");
                }
                obtainMessage = this.f185718f.obtainMessage();
                obtainMessage.obj = null;
                obtainMessage.what = 101;
                this.f185718f.sendMessage(obtainMessage);
                mediaMetadataRetriever.release();
                a.e(null, false);
            } catch (OutOfMemoryError unused2) {
                if (QLog.isColorLevel()) {
                    QLog.d("LoginActivity.GuideVideoHandler", 2, "getVideoFrame --- OutOfMemoryError");
                }
                obtainMessage = this.f185718f.obtainMessage();
                obtainMessage.obj = null;
                obtainMessage.what = 101;
                this.f185718f.sendMessage(obtainMessage);
                mediaMetadataRetriever.release();
                a.e(null, false);
            }
            if (frameAtTime == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("LoginActivity.GuideVideoHandler", 2, "getLocalVideoThumbnail \u83b7\u53d6\u5931\u8d25");
                }
                this.f185718f.sendEmptyMessage(101);
                Message obtainMessage2 = this.f185718f.obtainMessage();
                obtainMessage2.obj = null;
                obtainMessage2.what = 101;
                this.f185718f.sendMessage(obtainMessage2);
                mediaMetadataRetriever.release();
                a.e(null, false);
                return;
            }
            int i3 = this.f185716d.getResources().getDisplayMetrics().widthPixels;
            float height = this.f185716d.getResources().getDisplayMetrics().heightPixels / frameAtTime.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(i3 / frameAtTime.getWidth(), height);
            bitmap = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("LoginActivity.GuideVideoHandler", 2, "getLocalVideoThumbnail \u5b8c\u6210\u65f6\u95f4:%s", (System.currentTimeMillis() - currentTimeMillis) + " bitmap = " + bitmap);
                }
                obtainMessage = this.f185718f.obtainMessage();
                obtainMessage.obj = bitmap;
                obtainMessage.what = 101;
                this.f185718f.sendMessage(obtainMessage);
                mediaMetadataRetriever.release();
                a.e(null, false);
            } catch (Throwable th6) {
                th = th6;
                Message obtainMessage3 = this.f185718f.obtainMessage();
                obtainMessage3.obj = bitmap;
                obtainMessage3.what = 101;
                this.f185718f.sendMessage(obtainMessage3);
                mediaMetadataRetriever.release();
                a.e(null, false);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            bitmap = null;
        }
    }
}
