package com.tencent.ams.fusion.widget.apng.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.tencent.ams.fusion.widget.apng.frame.animation.decode.Frame;
import com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder;
import com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader;
import com.tencent.ams.fusion.widget.apng.frame.animation.loader.Loader;
import com.tencent.ams.fusion.widget.apng.io.APNGReader;
import com.tencent.ams.fusion.widget.apng.io.APNGWriter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class APNGDecoder extends FrameSeqDecoder<APNGReader, APNGWriter> {
    static IPatchRedirector $redirector_;
    private APNGWriter apngWriter;
    private int mLoopCount;
    private final Paint paint;
    private SnapShot snapShot;

    public APNGDecoder(Loader loader, FrameSeqDecoder.RenderListener renderListener) {
        super(loader, renderListener);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) loader, (Object) renderListener);
            return;
        }
        Paint paint = new Paint();
        this.paint = paint;
        this.snapShot = new SnapShot(this, null);
        paint.setAntiAlias(true);
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder
    protected int getLoopCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mLoopCount;
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder
    protected void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.snapShot.byteBuffer = null;
            this.apngWriter = null;
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder
    protected void renderFrame(Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) frame);
            return;
        }
        if (frame != null && this.fullRect != null && this.sampleSize != 0) {
            try {
                Bitmap obtainBitmap = obtainBitmap(this.fullRect.width() / this.sampleSize, this.fullRect.height() / this.sampleSize);
                Canvas canvas = this.cachedCanvas.get(obtainBitmap);
                if (canvas == null) {
                    canvas = new Canvas(obtainBitmap);
                    this.cachedCanvas.put(obtainBitmap, canvas);
                }
                Canvas canvas2 = canvas;
                if (frame instanceof APNGFrame) {
                    this.frameBuffer.rewind();
                    obtainBitmap.copyPixelsFromBuffer(this.frameBuffer);
                    if (this.frameIndex == 0) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else {
                        canvas2.save();
                        canvas2.clipRect(this.snapShot.dstRect);
                        SnapShot snapShot = this.snapShot;
                        byte b16 = snapShot.disposeOp;
                        if (b16 != 1) {
                            if (b16 == 2) {
                                snapShot.byteBuffer.rewind();
                                obtainBitmap.copyPixelsFromBuffer(this.snapShot.byteBuffer);
                            }
                        } else {
                            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                        }
                        canvas2.restore();
                    }
                    if (((APNGFrame) frame).disposeOp == 2) {
                        SnapShot snapShot2 = this.snapShot;
                        if (snapShot2.disposeOp != 2) {
                            snapShot2.byteBuffer.rewind();
                            obtainBitmap.copyPixelsToBuffer(this.snapShot.byteBuffer);
                        }
                    }
                    this.snapShot.disposeOp = ((APNGFrame) frame).disposeOp;
                    canvas2.save();
                    if (((APNGFrame) frame).blendOp == 0) {
                        int i3 = frame.frameX;
                        int i16 = this.sampleSize;
                        int i17 = frame.frameY;
                        canvas2.clipRect(i3 / i16, i17 / i16, (i3 + frame.frameWidth) / i16, (i17 + frame.frameHeight) / i16);
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    }
                    Rect rect = this.snapShot.dstRect;
                    int i18 = frame.frameX;
                    int i19 = this.sampleSize;
                    int i26 = frame.frameY;
                    rect.set(i18 / i19, i26 / i19, (i18 + frame.frameWidth) / i19, (i26 + frame.frameHeight) / i19);
                    canvas2.restore();
                }
                Bitmap obtainBitmap2 = obtainBitmap(frame.frameWidth, frame.frameHeight);
                recycleBitmap(frame.draw(canvas2, this.paint, this.sampleSize, obtainBitmap2, getWriter()));
                recycleBitmap(obtainBitmap2);
                this.frameBuffer.rewind();
                obtainBitmap.copyPixelsToBuffer(this.frameBuffer);
                recycleBitmap(obtainBitmap);
            } catch (Error e16) {
                e16.printStackTrace();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class SnapShot {
        static IPatchRedirector $redirector_;
        ByteBuffer byteBuffer;
        byte disposeOp;
        Rect dstRect;

        SnapShot() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.dstRect = new Rect();
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) APNGDecoder.this);
            }
        }

        /* synthetic */ SnapShot(APNGDecoder aPNGDecoder, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aPNGDecoder, (Object) anonymousClass1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder
    public APNGReader getReader(Reader reader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new APNGReader(reader) : (APNGReader) iPatchRedirector.redirect((short) 3, (Object) this, (Object) reader);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder
    public APNGWriter getWriter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (APNGWriter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.apngWriter == null) {
            this.apngWriter = new APNGWriter();
        }
        return this.apngWriter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.decode.FrameSeqDecoder
    public Rect read(APNGReader aPNGReader) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Rect) iPatchRedirector.redirect((short) 6, (Object) this, (Object) aPNGReader);
        }
        List<Chunk> parse = APNGParser.parse(aPNGReader);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        Iterator<Chunk> it = parse.iterator();
        APNGFrame aPNGFrame = null;
        boolean z16 = false;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Chunk next = it.next();
            if (next instanceof ACTLChunk) {
                this.mLoopCount = ((ACTLChunk) next).numPlays;
                z16 = true;
            } else if (next instanceof FCTLChunk) {
                aPNGFrame = new APNGFrame(aPNGReader, (FCTLChunk) next);
                aPNGFrame.prefixChunks = arrayList;
                aPNGFrame.ihdrData = bArr;
                this.frames.add(aPNGFrame);
            } else if (next instanceof FDATChunk) {
                if (aPNGFrame != null) {
                    aPNGFrame.imageChunks.add(next);
                }
            } else if (next instanceof IDATChunk) {
                if (!z16) {
                    StillFrame stillFrame = new StillFrame(aPNGReader);
                    stillFrame.frameWidth = i3;
                    stillFrame.frameHeight = i16;
                    setLoopLimit(1);
                    this.frames.add(stillFrame);
                    this.mLoopCount = 1;
                    break;
                }
                if (aPNGFrame != null) {
                    aPNGFrame.imageChunks.add(next);
                }
            } else if (next instanceof IHDRChunk) {
                IHDRChunk iHDRChunk = (IHDRChunk) next;
                i3 = iHDRChunk.width;
                i16 = iHDRChunk.height;
                bArr = iHDRChunk.data;
            } else if (!(next instanceof IENDChunk)) {
                arrayList.add(next);
            }
        }
        int i17 = i3 * i16;
        int i18 = this.sampleSize;
        this.frameBuffer = ByteBuffer.allocate(((i17 / (i18 * i18)) + 1) * 4);
        SnapShot snapShot = this.snapShot;
        int i19 = this.sampleSize;
        snapShot.byteBuffer = ByteBuffer.allocate(((i17 / (i19 * i19)) + 1) * 4);
        return new Rect(0, 0, i3, i16);
    }
}
