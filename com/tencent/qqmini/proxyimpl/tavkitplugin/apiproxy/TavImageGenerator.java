package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.tav.core.CGMathFunctions;
import com.tencent.tav.core.VideoCompositionDecoderTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes34.dex */
public class TavImageGenerator {

    /* compiled from: P */
    /* loaded from: classes34.dex */
    private class ImageGeneratorThread extends BaseHandlerThread implements Handler.Callback {
        private VideoCompositing C;

        /* renamed from: m, reason: collision with root package name */
        private VideoCompositionDecoderTrack f348005m;
        final /* synthetic */ TavImageGenerator this$0;

        private Bitmap d(RenderContext renderContext, CMSampleBuffer cMSampleBuffer) {
            Matrix matrix;
            CGSize cGSize;
            TextureInfo textureInfo = cMSampleBuffer.getTextureInfo();
            if (textureInfo == null) {
                return null;
            }
            Bitmap l3 = l(renderContext, textureInfo);
            Matrix j3 = j(TavImageGenerator.d(null), new CGSize(textureInfo.width, textureInfo.height));
            Matrix matrix2 = new Matrix();
            matrix2.postScale(1.0f, -1.0f);
            matrix2.postTranslate(0.0f, l3.getHeight());
            if (j3 != null) {
                j3.postConcat(matrix2);
                matrix = j3;
            } else {
                matrix = matrix2;
            }
            if (TavImageGenerator.d(null) != null) {
                cGSize = TavImageGenerator.d(null);
            } else {
                cGSize = new CGSize(textureInfo.width, textureInfo.height);
            }
            return Bitmap.createBitmap(l3, 0, 0, (int) cGSize.width, (int) cGSize.height, matrix, true);
        }

        private Bitmap e(CMTime cMTime) throws Exception {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return g(cMTime);
            }
            throw new Exception("cannot process in the main thread");
        }

        private void f(Message message) {
            Object obj = message.obj;
            if (obj instanceof a) {
                a aVar = (a) obj;
                try {
                    e(aVar.f348006a);
                } catch (Exception e16) {
                    Logger.e(TavImageGenerator.a(null), "doGeneratorCover: ", e16);
                }
                a.a(aVar);
            }
        }

        private Bitmap g(CMTime cMTime) {
            RenderContext k3 = k();
            return d(k3, i(cMTime, k3));
        }

        private CMSampleBuffer i(CMTime cMTime, RenderContext renderContext) {
            VideoCompositionDecoderTrack videoCompositionDecoderTrack = this.f348005m;
            videoCompositionDecoderTrack.getClass();
            videoCompositionDecoderTrack.seekTo(cMTime, false, true);
            return this.f348005m.readSample(cMTime);
        }

        private Bitmap l(RenderContext renderContext, TextureInfo textureInfo) {
            renderContext.makeCurrent();
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLES20.glBindFramebuffer(36160, iArr[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, textureInfo.textureID, 0);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(textureInfo.width * textureInfo.height * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.rewind();
            GLES20.glReadPixels(0, 0, textureInfo.width, textureInfo.height, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocateDirect);
            Bitmap createBitmap = Bitmap.createBitmap(textureInfo.width, textureInfo.height, Bitmap.Config.ARGB_8888);
            allocateDirect.rewind();
            createBitmap.copyPixelsFromBuffer(allocateDirect);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            return createBitmap;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                f(message);
                return false;
            }
            if (i3 != 2) {
                return false;
            }
            TavImageGenerator.c(null).removeCallbacksAndMessages(null);
            h();
            quit();
            return false;
        }

        private void h() {
            Logger.d(TavImageGenerator.a(null), "doRelease: start, thread = " + Thread.currentThread().getName());
            VideoCompositionDecoderTrack videoCompositionDecoderTrack = this.f348005m;
            if (videoCompositionDecoderTrack != null) {
                videoCompositionDecoderTrack.release();
                this.f348005m = null;
            }
            VideoCompositing videoCompositing = this.C;
            if (videoCompositing != null) {
                videoCompositing.release();
                this.C = null;
            }
            if (TavImageGenerator.e(null) != null) {
                TavImageGenerator.e(null).release();
                TavImageGenerator.g(null, null);
            }
            TavImageGenerator.h(null, null);
            Logger.d(TavImageGenerator.a(null), "doRelease: end, thread = " + Thread.currentThread().getName());
        }

        private RenderContext k() {
            if (TavImageGenerator.e(null) == null) {
                TavImageGenerator.d(null).getClass();
                CGSize d16 = TavImageGenerator.d(null);
                TavImageGenerator.g(null, new RenderContext((int) d16.width, (int) d16.height));
                TavImageGenerator.e(null).setParams(TavImageGenerator.f(null));
            }
            TavImageGenerator.e(null).makeCurrent();
            return TavImageGenerator.e(null);
        }

        private Matrix j(CGSize cGSize, CGSize cGSize2) {
            if (cGSize == null || cGSize2 == null || TavImageGenerator.b(null) == -1) {
                return null;
            }
            CGRect cGRect = new CGRect(new PointF(), cGSize2);
            CGRect cGRect2 = new CGRect(new PointF(), cGSize);
            switch (TavImageGenerator.b(null)) {
                case 101:
                    return CGMathFunctions.transformBySourceRectFit(cGRect, cGRect2);
                case 102:
                    return CGMathFunctions.transformBySourceRectFill(cGRect, cGRect2);
                case 103:
                    return CGMathFunctions.transformByScaleFitRect(cGRect, cGRect2);
                default:
                    return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private final CMTime f348006a;

        static /* bridge */ /* synthetic */ b a(a aVar) {
            aVar.getClass();
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public interface b {
    }

    static /* bridge */ /* synthetic */ String a(TavImageGenerator tavImageGenerator) {
        throw null;
    }

    static /* bridge */ /* synthetic */ int b(TavImageGenerator tavImageGenerator) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Handler c(TavImageGenerator tavImageGenerator) {
        throw null;
    }

    static /* bridge */ /* synthetic */ CGSize d(TavImageGenerator tavImageGenerator) {
        throw null;
    }

    static /* bridge */ /* synthetic */ RenderContext e(TavImageGenerator tavImageGenerator) {
        throw null;
    }

    static /* bridge */ /* synthetic */ RenderContextParams f(TavImageGenerator tavImageGenerator) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void g(TavImageGenerator tavImageGenerator, RenderContext renderContext) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void h(TavImageGenerator tavImageGenerator, VideoComposition videoComposition) {
        throw null;
    }
}
