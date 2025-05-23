package com.tencent.superplayer.utils;

import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKTPCapability;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.thumbplayer.api.capability.TPDecoderCapability;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.common.TPMD5Util;
import java.util.ArrayList;

/* loaded from: classes26.dex */
public class SuperPlayerAV1MediaCodecDetectUtils {

    /* loaded from: classes26.dex */
    class a implements ISuperPlayer.OnCaptureImageListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f373991d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f373992e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer f373993f;

        a(Runnable runnable, d dVar, ISuperPlayer iSuperPlayer) {
            this.f373991d = runnable;
            this.f373992e = dVar;
            this.f373993f = iSuperPlayer;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
        public void onCaptureImageFailed(ISuperPlayer iSuperPlayer, int i3, int i16) {
            ThreadUtil.getSubThreadHandler().removeCallbacks(this.f373991d);
            this.f373992e.a(new e().e(true).d(false));
            this.f373993f.release();
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
        public void onCaptureImageSucceed(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, Bitmap bitmap) {
            if (SuperPlayerAV1MediaCodecDetectUtils.b(bitmap)) {
                ThreadUtil.getSubThreadHandler().removeCallbacks(this.f373991d);
                this.f373992e.a(new e().e(true).d(false));
                this.f373993f.release();
                LogUtil.e("SuperPlayerAV1MediaCode", "detect failed black bitmap");
                return;
            }
            ThreadUtil.getSubThreadHandler().removeCallbacks(this.f373991d);
            this.f373992e.a(new e().e(true).d(true));
            this.f373993f.release();
            LogUtil.e("SuperPlayerAV1MediaCode", "detect success");
        }
    }

    /* loaded from: classes26.dex */
    class b implements ISuperPlayer.OnErrorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f373994d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f373995e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ISuperPlayer f373996f;

        b(Runnable runnable, d dVar, ISuperPlayer iSuperPlayer) {
            this.f373994d = runnable;
            this.f373995e = dVar;
            this.f373996f = iSuperPlayer;
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
        public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
            ThreadUtil.getSubThreadHandler().removeCallbacks(this.f373994d);
            this.f373995e.a(new e().e(true).d(false));
            this.f373996f.release();
            LogUtil.e("SuperPlayerAV1MediaCode", "playerError:" + i17);
            return false;
        }
    }

    /* loaded from: classes26.dex */
    class c implements ISuperPlayer.OnVideoPreparedListener {
        c() {
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
            iSuperPlayer.setOutputMute(true);
            iSuperPlayer.start();
            iSuperPlayer.pause();
            try {
                iSuperPlayer.captureImageInTime(0L, iSuperPlayer.getVideoWidth() / 2, iSuperPlayer.getVideoHeight() / 2);
            } catch (IllegalAccessException e16) {
                LogUtil.e(LogUtil.TAG, e16.toString());
            }
        }
    }

    /* loaded from: classes26.dex */
    public interface d {
        void a(e eVar);
    }

    /* loaded from: classes26.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        boolean f373997a;

        /* renamed from: b, reason: collision with root package name */
        boolean f373998b;

        /* renamed from: c, reason: collision with root package name */
        boolean f373999c;

        public boolean a() {
            return this.f373998b;
        }

        public boolean b() {
            return this.f373997a;
        }

        public boolean c() {
            return this.f373999c;
        }

        public e d(boolean z16) {
            this.f373998b = z16;
            return this;
        }

        public e e(boolean z16) {
            this.f373997a = z16;
            return this;
        }

        public e f(boolean z16) {
            this.f373999c = z16;
            return this;
        }

        public String toString() {
            return "SuperAV1DetectResult{mIsSystemSupport=" + this.f373997a + ", mIsDetectBimMapSupport=" + this.f373998b + ", mIsTimeOut=" + this.f373999c + '}';
        }
    }

    public static void a(@NonNull String str, long j3, int i3, final int i16, @NonNull final d dVar) throws Exception {
        if (Looper.getMainLooper() != Looper.myLooper() && !TextUtils.isEmpty(str)) {
            if (!c()) {
                dVar.a(new e().e(false));
                LogUtil.e("SuperPlayerAV1MediaCode", "isVideoDecoderSupported avl mediaCodec:false");
                return;
            }
            final ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(SuperPlayerSDKMgr.getContext(), i3, null);
            Runnable runnable = new Runnable() { // from class: com.tencent.superplayer.utils.SuperPlayerAV1MediaCodecDetectUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.a(new e().e(true).f(true).d(false));
                    createMediaPlayer.release();
                    LogUtil.e("SuperPlayerAV1MediaCode", "timeout:" + i16);
                }
            };
            createMediaPlayer.setOutputMute(true);
            createMediaPlayer.setOnCaptureImageListener(new a(runnable, dVar, createMediaPlayer));
            createMediaPlayer.setOnErrorListener(new b(runnable, dVar, createMediaPlayer));
            createMediaPlayer.setOnVideoPreparedListener(new c());
            SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(str, 101, TPMD5Util.getMd5(str));
            createVideoInfoForUrl.setVideoDurationMs(j3);
            SuperPlayerOption obtain = SuperPlayerOption.obtain();
            ArrayList arrayList = new ArrayList();
            arrayList.add(TPOptionalParam.buildQueueInt(TPOptionalID.OPTIONAL_ID_BEFORE_QUEUE_INT_VIDEO_DECODER_TYPE, new int[]{102}));
            createMediaPlayer.setPlayerOptionalParamList(arrayList);
            createMediaPlayer.openMediaPlayer(SuperPlayerSDKMgr.getContext(), createVideoInfoForUrl, 1000L, obtain);
            ThreadUtil.getSubThreadHandler().postDelayed(runnable, i16);
            return;
        }
        throw new Exception("detectAV1MediaCodecSupport failed, is main thread or url is empty");
    }

    public static boolean b(Bitmap bitmap) {
        if (bitmap == null || bitmap.getConfig() != Bitmap.Config.RGB_565) {
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        for (int i3 = 0; i3 < height; i3 += 10) {
            for (int i16 = 0; i16 < width; i16 += 10) {
                if (bitmap.getPixel(i16, i3) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean c() {
        try {
            if (TPDecoderCapability.getVideoDecoderCapability(1029, 102, 1920, 1080, 30.0f) == 1) {
                LogUtil.e("SuperPlayerAV1MediaCode", "isVideoDecoderSupported():FHDtrue");
                return true;
            }
            if (TPDecoderCapability.getVideoDecoderCapability(1029, 102, 1280, 720, 30.0f) == 1) {
                LogUtil.e("SuperPlayerAV1MediaCode", "isVideoDecoderSupported():SHDtrue");
                return true;
            }
            if (TPDecoderCapability.getVideoDecoderCapability(1029, 102, TVKTPCapability.HD_WIDTH, 480, 30.0f) == 1) {
                LogUtil.e("SuperPlayerAV1MediaCode", "isVideoDecoderSupported():HDtrue");
                return true;
            }
            if (TPDecoderCapability.getVideoDecoderCapability(1029, 102, 480, 270, 30.0f) != 1) {
                return false;
            }
            LogUtil.e("SuperPlayerAV1MediaCode", "isVideoDecoderSupported():SDtrue");
            return true;
        } catch (TPLoadLibraryException e16) {
            TVKLogUtil.e("SuperPlayerAV1MediaCode", "isVideoDecoderSupported(), has exception:" + e16);
            return false;
        }
    }
}
