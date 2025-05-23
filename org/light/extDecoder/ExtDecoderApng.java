package org.light.extDecoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import java.io.File;
import org.light.ExtImageDecoder;
import org.light.extDecoder.apng.ApngDecoder;
import org.light.extDecoder.apng.ApngFrame;
import org.light.extDecoder.apng.ApngParser;
import org.light.extDecoder.apng.ApngWrapper;
import org.light.extDecoder.apng.io.APNGReader;
import org.light.extDecoder.apng.io.FileReader;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ExtDecoderApng extends ExtImageDecoder {
    private static final String TAG = "ExtDecoderApng";
    private Canvas canvas;
    private ApngDecoder decoder;
    private Paint paint;
    private Bitmap retBitmap;

    public ExtDecoderApng(int i3, String str) {
        super(i3, str);
        this.decoder = null;
        this.retBitmap = null;
        this.canvas = null;
        this.paint = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                LightLogUtil.e(TAG, "ExtDecoderApng: file not found");
                return;
            }
            ApngWrapper parse = ApngParser.parse(new APNGReader(new FileReader(file)));
            if (parse == null) {
                LightLogUtil.e(TAG, "ExtDecoderApng: ApngParser.parse failed");
                return;
            }
            parse.setFile(file);
            this.decoder = new ApngDecoder(parse, Bitmap.Config.ARGB_8888);
            this.retBitmap = Bitmap.createBitmap(parse.getWidth(), parse.getHeight(), Bitmap.Config.ARGB_8888);
            this.canvas = new Canvas(this.retBitmap);
            this.paint = new Paint();
        } catch (Exception e16) {
            this.decoder = null;
            LightLogUtil.e(TAG, e16.getMessage(), e16);
        }
    }

    private void decodeAndRenderNext() {
        this.decoder.advance();
        this.decoder.getNextFrame().draw(this.canvas, this.paint, this.retBitmap);
    }

    private boolean decodeFrameSuccess() {
        ApngFrame nextFrame = this.decoder.getNextFrame();
        if (nextFrame == null || nextFrame.getFrameSource() == null) {
            return false;
        }
        return true;
    }

    private void resetDecoder() {
        this.decoder.resetFrameIndex();
        this.canvas.save();
        Canvas canvas = this.canvas;
        canvas.clipRect(0, 0, canvas.getWidth(), this.canvas.getHeight());
        this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        this.canvas.restore();
        this.decoder.getNextFrame().draw(this.canvas, this.paint, this.retBitmap);
    }

    @Override // org.light.ExtImageDecoder
    public Bitmap decodeFrame(long j3) {
        if (this.decoder == null) {
            return null;
        }
        try {
            if (r1.getCurrentFrameIndex() > j3) {
                resetDecoder();
            }
            while (this.decoder.getCurrentFrameIndex() < j3) {
                decodeAndRenderNext();
            }
            if (!decodeFrameSuccess()) {
                LightLogUtil.e(TAG, "decode failed: frame == null, " + j3);
                return null;
            }
            return this.retBitmap;
        } catch (Exception e16) {
            LightLogUtil.e(TAG, e16.getMessage(), e16);
            return null;
        }
    }

    @Override // org.light.ExtImageDecoder
    public long[] getAllFrameDelay() {
        ApngDecoder apngDecoder = this.decoder;
        if (apngDecoder == null) {
            return null;
        }
        try {
            int frameCount = apngDecoder.getFrameCount();
            long[] jArr = new long[frameCount];
            for (int i3 = 0; i3 < frameCount; i3++) {
                jArr[i3] = this.decoder.getDelay(i3) * 1000;
            }
            return jArr;
        } catch (Exception e16) {
            LightLogUtil.e(TAG, e16.getMessage(), e16);
            return null;
        }
    }

    @Override // org.light.ExtImageDecoder
    public void onRelease() {
        try {
            ApngDecoder apngDecoder = this.decoder;
            if (apngDecoder != null) {
                apngDecoder.clear();
                this.decoder = null;
            }
            this.retBitmap.recycle();
            this.retBitmap = null;
        } catch (Exception e16) {
            LightLogUtil.e(TAG, e16.getMessage(), e16);
        }
    }
}
