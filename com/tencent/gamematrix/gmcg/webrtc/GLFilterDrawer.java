package com.tencent.gamematrix.gmcg.webrtc;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.RawRes;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmvideofilter.VideoFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.StringTokenizer;
import org.tencwebrtc.RendererCommon;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GLFilterDrawer implements RendererCommon.GlDrawer {
    static int ref;

    public GLFilterDrawer(Context context) {
        ref++;
        CGLog.i("VideoFilter GLFilterDrawer Cons ref:" + ref);
    }

    public static void initTvesrKernelBuffer5x5(Context context) {
        ByteBuffer loadFilterParams = loadFilterParams(context, 54432, R.raw.tve_qp2440_k5_ks3_wz);
        CGLog.i("VideoFilter initTvesrKernelBuffer5x5 start to set tvesr kernel buffer");
        VideoFilter.load_kernel(loadFilterParams, 54432);
    }

    private static ByteBuffer loadFilterParams(Context context, int i3, @RawRes int i16) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i3 * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i16)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    allocateDirect.position(0);
                    return allocateDirect;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                while (stringTokenizer.hasMoreTokens()) {
                    allocateDirect.putFloat(Float.parseFloat(stringTokenizer.nextToken()));
                }
            }
        } catch (Resources.NotFoundException unused) {
            CGLog.e("VideoFilter load weight error$e");
            return null;
        } catch (IOException unused2) {
            CGLog.e("VideoFilter load weight error$e");
            return null;
        } catch (NumberFormatException unused3) {
            CGLog.e("VideoFilter load weight error$e");
            return null;
        }
    }

    @Override // org.tencwebrtc.RendererCommon.GlDrawer
    public void drawOes(int i3, float[] fArr, int i16, int i17, int i18, int i19, int i26, int i27) {
        VideoFilter.drawOes(i3, fArr, i16, i17, i18, i19, i26, i27);
    }

    @Override // org.tencwebrtc.RendererCommon.GlDrawer
    public void drawRgb(int i3, float[] fArr, int i16, int i17, int i18, int i19, int i26, int i27) {
        CGLog.e("VideoFilter drawRgb only supprt hardware decode");
    }

    @Override // org.tencwebrtc.RendererCommon.GlDrawer
    public void drawYuv(int[] iArr, float[] fArr, int i3, int i16, int i17, int i18, int i19, int i26) {
        VideoFilter.drawYuv(iArr, fArr, i3, i16, i17, i18, i19, i26);
    }

    @Override // org.tencwebrtc.RendererCommon.GlDrawer
    public void release() {
        ref--;
        CGLog.i("VideoFilter GLFilterDrawer release ref:" + ref);
        VideoFilter.release();
    }
}
