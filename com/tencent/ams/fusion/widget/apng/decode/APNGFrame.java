package com.tencent.ams.fusion.widget.apng.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.ams.fusion.widget.apng.frame.animation.decode.Frame;
import com.tencent.ams.fusion.widget.apng.io.APNGReader;
import com.tencent.ams.fusion.widget.apng.io.APNGWriter;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* loaded from: classes3.dex */
public class APNGFrame extends Frame<APNGReader, APNGWriter> {
    static final /* synthetic */ boolean $assertionsDisabled;
    static IPatchRedirector $redirector_;
    private static ThreadLocal<CRC32> sCRC32;
    private static final byte[] sPNGEndChunk;
    private static final byte[] sPNGSignatures;
    public final byte blendOp;
    public final byte disposeOp;
    byte[] ihdrData;
    List<Chunk> imageChunks;
    List<Chunk> prefixChunks;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52162);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        $assertionsDisabled = true;
        sPNGSignatures = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        sPNGEndChunk = new byte[]{0, 0, 0, 0, 73, 69, 78, 68, -82, 66, Constants.VIRTUAL_GAMEPAD_SDK_DATA, -126};
        sCRC32 = new ThreadLocal<>();
    }

    public APNGFrame(APNGReader aPNGReader, FCTLChunk fCTLChunk) {
        super(aPNGReader);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aPNGReader, (Object) fCTLChunk);
            return;
        }
        this.imageChunks = new ArrayList();
        this.prefixChunks = new ArrayList();
        this.blendOp = fCTLChunk.blendOp;
        this.disposeOp = fCTLChunk.disposeOp;
        int i3 = fCTLChunk.delayNum * 1000;
        short s16 = fCTLChunk.delayDen;
        int i16 = i3 / (s16 == 0 ? (short) 100 : s16);
        this.frameDuration = i16;
        if (i16 < 10) {
            this.frameDuration = 100;
        }
        this.frameWidth = fCTLChunk.width;
        this.frameHeight = fCTLChunk.height;
        this.frameX = fCTLChunk.xOffset;
        this.frameY = fCTLChunk.yOffset;
    }

    private int encode(APNGWriter aPNGWriter) throws IOException {
        int i3;
        Iterator<Chunk> it = this.prefixChunks.iterator();
        int i16 = 33;
        while (it.hasNext()) {
            i16 += it.next().length + 12;
        }
        for (Chunk chunk : this.imageChunks) {
            if (chunk instanceof IDATChunk) {
                i3 = chunk.length + 12;
            } else if (chunk instanceof FDATChunk) {
                i3 = chunk.length + 8;
            }
            i16 += i3;
        }
        int length = i16 + sPNGEndChunk.length;
        aPNGWriter.reset(length);
        aPNGWriter.putBytes(sPNGSignatures);
        aPNGWriter.writeInt(13);
        int position = aPNGWriter.position();
        aPNGWriter.writeFourCC(IHDRChunk.ID);
        aPNGWriter.writeInt(this.frameWidth);
        aPNGWriter.writeInt(this.frameHeight);
        aPNGWriter.putBytes(this.ihdrData);
        CRC32 crc32 = getCRC32();
        crc32.reset();
        crc32.update(aPNGWriter.toByteArray(), position, 17);
        aPNGWriter.writeInt((int) crc32.getValue());
        for (Chunk chunk2 : this.prefixChunks) {
            if (!(chunk2 instanceof IENDChunk)) {
                ((APNGReader) this.reader).reset();
                ((APNGReader) this.reader).skip(chunk2.offset);
                ((APNGReader) this.reader).read(aPNGWriter.toByteArray(), aPNGWriter.position(), chunk2.length + 12);
                aPNGWriter.skip(chunk2.length + 12);
            }
        }
        for (Chunk chunk3 : this.imageChunks) {
            if (chunk3 instanceof IDATChunk) {
                ((APNGReader) this.reader).reset();
                ((APNGReader) this.reader).skip(chunk3.offset);
                if (((APNGReader) this.reader).read(aPNGWriter.toByteArray(), aPNGWriter.position(), chunk3.length + 12) != -1) {
                    aPNGWriter.skip(chunk3.length + 12);
                }
            } else if (chunk3 instanceof FDATChunk) {
                aPNGWriter.writeInt(chunk3.length - 4);
                int position2 = aPNGWriter.position();
                aPNGWriter.writeFourCC(IDATChunk.ID);
                ((APNGReader) this.reader).reset();
                ((APNGReader) this.reader).skip(chunk3.offset + 4 + 4 + 4);
                if (((APNGReader) this.reader).read(aPNGWriter.toByteArray(), aPNGWriter.position(), chunk3.length - 4) != -1) {
                    aPNGWriter.skip(chunk3.length - 4);
                    crc32.reset();
                    crc32.update(aPNGWriter.toByteArray(), position2, chunk3.length);
                    aPNGWriter.writeInt((int) crc32.getValue());
                }
            }
        }
        aPNGWriter.putBytes(sPNGEndChunk);
        return length;
    }

    private CRC32 getCRC32() {
        CRC32 crc32 = sCRC32.get();
        if (crc32 == null) {
            CRC32 crc322 = new CRC32();
            sCRC32.set(crc322);
            return crc322;
        }
        return crc32;
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.decode.Frame
    public Bitmap draw(Canvas canvas, Paint paint, int i3, Bitmap bitmap, APNGWriter aPNGWriter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, canvas, paint, Integer.valueOf(i3), bitmap, aPNGWriter);
        }
        if (i3 == 0) {
            return null;
        }
        try {
            int encode = encode(aPNGWriter);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i3;
            options.inMutable = true;
            options.inBitmap = bitmap;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(aPNGWriter.toByteArray(), 0, encode, options);
            if (!$assertionsDisabled && decodeByteArray == null) {
                throw new AssertionError();
            }
            float f16 = i3;
            canvas.drawBitmap(decodeByteArray, this.frameX / f16, this.frameY / f16, paint);
            return decodeByteArray;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
