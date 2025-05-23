package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class l {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements QQAnimationDrawable.QQAnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f90224a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f90225b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQAnimationDrawable.QQAnimationListener[] f90226c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAnimationDrawable.QQAnimationListener f90227d;

        a(ImageView imageView, Runnable runnable, QQAnimationDrawable.QQAnimationListener[] qQAnimationListenerArr, QQAnimationDrawable.QQAnimationListener qQAnimationListener) {
            this.f90224a = imageView;
            this.f90225b = runnable;
            this.f90226c = qQAnimationListenerArr;
            this.f90227d = qQAnimationListener;
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onPlay(int i3) {
            QQAnimationDrawable.QQAnimationListener qQAnimationListener = this.f90227d;
            if (qQAnimationListener != null) {
                qQAnimationListener.onPlay(i3);
            }
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onStart() {
            QQAnimationDrawable.QQAnimationListener qQAnimationListener = this.f90227d;
            if (qQAnimationListener != null) {
                qQAnimationListener.onStart();
            }
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onStop() {
            this.f90224a.removeCallbacks(this.f90225b);
            QQAnimationDrawable.QQAnimationListener qQAnimationListener = this.f90226c[0];
            if (qQAnimationListener != null) {
                qQAnimationListener.onStop();
            }
        }
    }

    public static QQAnimationDrawable b(String str, Map<String, RFWMultiDownloadHelper.DownloadResult> map) {
        RFWMultiDownloadHelper.DownloadResult downloadResult;
        String[] b16;
        if (!TextUtils.isEmpty(str) && map != null) {
            try {
                if (map.containsKey(str) && (downloadResult = map.get(str)) != null && (b16 = q50.a.b(str, downloadResult.mFilePath)) != null && b16.length > 0) {
                    QQAnimationDrawable qQAnimationDrawable = new QQAnimationDrawable();
                    qQAnimationDrawable.setPngPaths(b16, true);
                    return qQAnimationDrawable;
                }
            } catch (Exception e16) {
                QLog.e("QFSAnimUtils", 1, "getAnimationDrawable error" + e16.getMessage());
                e16.printStackTrace();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(String str, QQAnimationDrawable.QQAnimationListener[] qQAnimationListenerArr) {
        QLog.d("QFSAnimUtils", 1, "autoStopCallRunnable call " + str);
        QQAnimationDrawable.QQAnimationListener qQAnimationListener = qQAnimationListenerArr[0];
        if (qQAnimationListener != null) {
            qQAnimationListener.onStop();
            qQAnimationListenerArr[0] = null;
        }
    }

    public static QQAnimationDrawable d(final String str, Map<String, RFWMultiDownloadHelper.DownloadResult> map, long j3, ImageView imageView, QQAnimationDrawable.QQAnimationListener qQAnimationListener) {
        if (!TextUtils.isEmpty(str) && imageView != null) {
            QQAnimationDrawable b16 = b(str, map);
            if (b16 == null) {
                QLog.d("QFSAnimUtils", 1, "playAnim but animationDrawable is null");
                if (qQAnimationListener != null) {
                    qQAnimationListener.onStop();
                }
                return null;
            }
            b16.setOneShot(true);
            b16.setDuration(j3);
            final QQAnimationDrawable.QQAnimationListener[] qQAnimationListenerArr = {qQAnimationListener};
            Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.c(str, qQAnimationListenerArr);
                }
            };
            imageView.postDelayed(runnable, j3 + 400);
            b16.setListener(new a(imageView, runnable, qQAnimationListenerArr, qQAnimationListener));
            imageView.setImageDrawable(b16);
            b16.start();
            return b16;
        }
        if (qQAnimationListener != null) {
            qQAnimationListener.onStop();
        }
        return null;
    }
}
