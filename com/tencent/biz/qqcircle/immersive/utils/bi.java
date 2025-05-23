package com.tencent.biz.qqcircle.immersive.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bi {

    /* renamed from: a, reason: collision with root package name */
    private static Pair<String, Bitmap> f90189a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f90190b = new Object();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(Pair<String, Bitmap> pair);
    }

    public static void d() {
        RFWThreadManager.getInstance().getSerialThreadHandler().removeCallbacksAndMessages(f90190b);
        QLog.d("QFP-QFSVideoCaptureFrameUtils", 1, "[cancelTextureTask] cancel texture task.");
    }

    public static void e(Option option, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!h()) {
            return;
        }
        if (!g(feedCloudMeta$StFeed)) {
            QLog.e("QFP-QFSVideoCaptureFrameUtils", 1, "[clearOptionCover] current exists capture frame.");
        } else {
            if (option == null) {
                return;
            }
            QCircleFeedPicLoader.g().removeCache(option);
        }
    }

    private static Bitmap f(TextureView textureView) {
        if (textureView == null) {
            QLog.e("QFP-QFSVideoCaptureFrameUtils", 1, "[createTextureFrameBitmap] texture view should not be null.");
            return null;
        }
        if (!textureView.isAvailable()) {
            QLog.e("QFP-QFSVideoCaptureFrameUtils", 1, "[createTextureFrameBitmap] current surface not is available, end flow.");
            return null;
        }
        DisplayMetrics displayMetrics = textureView.getResources().getDisplayMetrics();
        int width = textureView.getWidth();
        int height = textureView.getHeight();
        if (width > 0 && height > 0) {
            try {
                return textureView.getBitmap(Bitmap.createBitmap(displayMetrics, width, height, Bitmap.Config.RGB_565));
            } catch (Throwable th5) {
                QLog.e("QFP-QFSVideoCaptureFrameUtils", 1, "[createTextureFrameBitmap] error: ", th5);
                return null;
            }
        }
        QLog.e("QFP-QFSVideoCaptureFrameUtils", 1, "[createTextureFrameBitmap] previewWidth <= 0 || previewHeight <= 0.");
        return null;
    }

    public static boolean g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Pair<String, Bitmap> pair;
        if (!h() || (pair = f90189a) == null) {
            return false;
        }
        String str = (String) pair.first;
        String g16 = com.tencent.biz.qqcircle.utils.bj.g(feedCloudMeta$StFeed);
        cq cqVar = cq.f92752a;
        if (cqVar.s(feedCloudMeta$StFeed)) {
            String n3 = cqVar.n(feedCloudMeta$StFeed);
            if (!TextUtils.equals(g16, str) && !TextUtils.equals(n3, str)) {
                QLog.e("QFP-QFSVideoCaptureFrameUtils", 1, "[isExistsCurrentFrame] current load texture bitmap not is feed, load fail, feedId: " + str + "\uff0ccurrentFeedId\uff1a" + g16);
                return false;
            }
        } else if (!TextUtils.equals(g16, str)) {
            QLog.e("QFP-QFSVideoCaptureFrameUtils", 1, "[isExistsCurrentFrame] current load texture bitmap not is feed, load fail, feedId: " + str);
            return false;
        }
        Bitmap bitmap = (Bitmap) f90189a.second;
        if (bitmap != null && !bitmap.isRecycled()) {
            return true;
        }
        QLog.d("QFP-QFSVideoCaptureFrameUtils", 1, "[isExistsCurrentFrame] load bitmap is illegality, load fail. feedId: " + str);
        return false;
    }

    public static boolean h() {
        return uq3.c.W5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(a aVar) {
        if (aVar == null) {
            QLog.e("QFP-QFSVideoCaptureFrameUtils", 1, "[notifySaveSurfaceCover] callback should not be null.");
        } else {
            aVar.a(f90189a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(QFSVideoView qFSVideoView, FeedCloudMeta$StFeed feedCloudMeta$StFeed, a aVar, int i3, String str) {
        RFWPlayer qCirclePlayer;
        ISuperPlayer superPlayer;
        ISPlayerVideoView videoView;
        View renderView;
        int hashCode;
        if (qFSVideoView == null) {
            qCirclePlayer = null;
        } else {
            qCirclePlayer = qFSVideoView.getQCirclePlayer();
        }
        if (qCirclePlayer != null && !qCirclePlayer.isFirstRenderCallback()) {
            QLog.d("QFP-QFSVideoCaptureFrameUtils", 1, "[saveTextureFrameToBitmap] current first render not callback, save frame fail.");
            m(feedCloudMeta$StFeed, null, aVar);
            return;
        }
        if (qFSVideoView == null) {
            superPlayer = null;
        } else {
            superPlayer = qFSVideoView.getSuperPlayer();
        }
        if (superPlayer == null) {
            videoView = null;
        } else {
            videoView = superPlayer.getVideoView();
        }
        if (videoView == null) {
            renderView = null;
        } else {
            renderView = videoView.getRenderView();
        }
        if (!(renderView instanceof TextureView)) {
            QLog.e("QFP-QFSVideoCaptureFrameUtils", 1, "[saveTextureFrameToBitmap] view not is texture view, view: " + renderView);
            m(feedCloudMeta$StFeed, null, aVar);
            return;
        }
        Bitmap f16 = f((TextureView) renderView);
        if (f16 == null) {
            hashCode = -1;
        } else {
            hashCode = f16.hashCode();
        }
        QLog.d("QFP-QFSVideoCaptureFrameUtils", 1, "[saveTextureFrameToBitmap] video view id: " + i3 + " | feedId: " + str + " | bitmap id: " + hashCode);
        m(feedCloudMeta$StFeed, f16, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(ISuperPlayer iSuperPlayer, String str, a aVar, int i3) {
        ISPlayerVideoView videoView;
        View renderView;
        int hashCode;
        if (iSuperPlayer == null) {
            videoView = null;
        } else {
            videoView = iSuperPlayer.getVideoView();
        }
        if (videoView == null) {
            renderView = null;
        } else {
            renderView = videoView.getRenderView();
        }
        if (!(renderView instanceof TextureView)) {
            QLog.e("QFP-QFSVideoCaptureFrameUtils", 1, "[saveTextureFrameToBitmap] view not is texture view, view: " + renderView);
            n(str, null, aVar);
            return;
        }
        Bitmap f16 = f((TextureView) renderView);
        if (f16 == null) {
            hashCode = -1;
        } else {
            hashCode = f16.hashCode();
        }
        QLog.d("QFP-QFSVideoCaptureFrameUtils", 1, "[saveTextureFrameToBitmap] video view id: " + i3 + " | feedId: " + str + " | bitmap id: " + hashCode);
        n(str, f16, aVar);
    }

    public static boolean l(ImageView imageView, Option option, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Bitmap bitmap;
        int hashCode;
        if (!h()) {
            return false;
        }
        if (imageView != null && feedCloudMeta$StFeed != null) {
            if (!g(feedCloudMeta$StFeed)) {
                return false;
            }
            e(option, feedCloudMeta$StFeed);
            Bitmap bitmap2 = (Bitmap) f90189a.second;
            imageView.setImageBitmap(bitmap2);
            int hashCode2 = imageView.hashCode();
            int byteCount = bitmap2.getByteCount();
            int hashCode3 = bitmap2.hashCode();
            if (imageView.getDrawable() instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            } else {
                bitmap = null;
            }
            if (bitmap == null) {
                hashCode = -1;
            } else {
                hashCode = bitmap.hashCode();
            }
            QLog.d("QFP-QFSVideoCaptureFrameUtils", 1, "[loadBitmapToCoverView] frame bitmap byte count: " + byteCount + " | frameBitmapHashCode: " + hashCode3 + " | coverBitmapHashCode: " + hashCode + " | coverHashCode: " + hashCode2);
            return true;
        }
        QLog.e("QFP-QFSVideoCaptureFrameUtils", 1, "[loadBitmapToCoverView] coverView == null || feed == null, load fail.");
        return false;
    }

    private static void m(FeedCloudMeta$StFeed feedCloudMeta$StFeed, Bitmap bitmap, a aVar) {
        n(com.tencent.biz.qqcircle.utils.bj.g(feedCloudMeta$StFeed), bitmap, aVar);
    }

    private static void n(String str, Bitmap bitmap, final a aVar) {
        if (!TextUtils.isEmpty(str) && bitmap != null) {
            f90189a = new Pair<>(str, bitmap);
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.bg
            @Override // java.lang.Runnable
            public final void run() {
                bi.i(bi.a.this);
            }
        });
    }

    public static void o() {
        String str;
        Bitmap bitmap;
        int hashCode;
        if (!h()) {
            return;
        }
        Pair<String, Bitmap> pair = f90189a;
        if (pair == null) {
            str = null;
        } else {
            str = (String) pair.first;
        }
        if (pair == null) {
            bitmap = null;
        } else {
            bitmap = (Bitmap) pair.second;
        }
        if (bitmap == null) {
            hashCode = -1;
        } else {
            hashCode = bitmap.hashCode();
        }
        QLog.d("QFP-QFSVideoCaptureFrameUtils", 1, "[release] feedId: " + str + " | bitmapHashCode: " + hashCode);
        f90189a = null;
    }

    public static void p(a aVar) {
        QFSVideoView qFSVideoView;
        FeedCloudMeta$StFeed data;
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference == null) {
            qFSVideoView = null;
        } else {
            qFSVideoView = weakReference.get();
        }
        if (qFSVideoView == null) {
            data = null;
        } else {
            data = qFSVideoView.getData();
        }
        if (!h()) {
            m(data, null, aVar);
        } else {
            q(qFSVideoView, data, aVar);
        }
    }

    public static void q(final QFSVideoView qFSVideoView, final FeedCloudMeta$StFeed feedCloudMeta$StFeed, final a aVar) {
        int hashCode;
        if (!h()) {
            m(feedCloudMeta$StFeed, null, aVar);
            return;
        }
        if (qFSVideoView == null) {
            hashCode = -1;
        } else {
            hashCode = qFSVideoView.hashCode();
        }
        final int i3 = hashCode;
        final String g16 = com.tencent.biz.qqcircle.utils.bj.g(feedCloudMeta$StFeed);
        QLog.d("QFP-QFSVideoCaptureFrameUtils", 1, "[saveTextureFrameToBitmap] video view id: " + i3 + " | feedId: " + g16);
        d();
        RFWThreadManager.getInstance().getSerialThreadHandler().postAtTime(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.bf
            @Override // java.lang.Runnable
            public final void run() {
                bi.j(QFSVideoView.this, feedCloudMeta$StFeed, aVar, i3, g16);
            }
        }, f90190b, SystemClock.uptimeMillis());
    }

    public static void r(final ISuperPlayer iSuperPlayer, final String str, final a aVar) {
        final int hashCode;
        if (!h()) {
            n(str, null, aVar);
            return;
        }
        if (iSuperPlayer == null) {
            hashCode = -1;
        } else {
            hashCode = iSuperPlayer.hashCode();
        }
        QLog.d("QFP-QFSVideoCaptureFrameUtils", 1, "[saveTextureFrameToBitmap] video view id: " + hashCode + " | feedId: " + str);
        Handler serialThreadHandler = RFWThreadManager.getInstance().getSerialThreadHandler();
        Object obj = f90190b;
        serialThreadHandler.removeCallbacksAndMessages(obj);
        RFWThreadManager.getInstance().getSerialThreadHandler().postAtTime(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.bh
            @Override // java.lang.Runnable
            public final void run() {
                bi.k(ISuperPlayer.this, str, aVar, hashCode);
            }
        }, obj, SystemClock.uptimeMillis());
    }
}
