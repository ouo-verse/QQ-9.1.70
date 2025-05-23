package org.light.extDecoder.apng;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.util.Iterator;
import java.util.zip.CRC32;
import org.light.extDecoder.apng.ApngDecoder;
import org.light.extDecoder.apng.ApngFrame;
import org.light.extDecoder.apng.ApngWrapper;
import org.light.extDecoder.apng.chunk.Chunk;
import org.light.extDecoder.apng.chunk.FDATChunk;
import org.light.extDecoder.apng.chunk.IDATChunk;
import org.light.extDecoder.apng.chunk.IENDChunk;
import org.light.extDecoder.apng.chunk.IHDRChunk;
import org.light.extDecoder.apng.io.APNGReader;
import org.light.extDecoder.apng.io.APNGWriter;
import org.light.extDecoder.apng.io.FileReader;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ApngFrameReader {
    private static final String TAG = "ApngFrameReader";
    private final APNGReader apngReader;
    private final ApngWrapper apngWrapper;
    private final Bitmap.Config config;
    private final ApngRender apngRender = new ApngRender();
    private final APNGWriter apngWriter = new APNGWriter();

    public ApngFrameReader(ApngWrapper apngWrapper, Bitmap.Config config) throws IOException {
        this.apngWrapper = apngWrapper;
        this.config = config;
        this.apngReader = new APNGReader(new FileReader(apngWrapper.getFile()));
    }

    private int encode(ApngWrapper.ApngFrameResource apngFrameResource) throws IOException {
        int i3;
        Iterator<Chunk> it = apngFrameResource.prefixChunks.iterator();
        int i16 = 33;
        while (it.hasNext()) {
            i16 += it.next().length + 12;
        }
        for (Chunk chunk : apngFrameResource.imageChunks) {
            if (chunk instanceof IDATChunk) {
                i3 = chunk.length + 12;
            } else if (chunk instanceof FDATChunk) {
                i3 = chunk.length + 8;
            }
            i16 += i3;
        }
        int length = i16 + ApngWrapper.ApngFrameResource.sPNGEndChunk.length;
        this.apngWriter.reset(length);
        this.apngWriter.putBytes(ApngWrapper.ApngFrameResource.sPNGSignatures);
        this.apngWriter.writeInt(13);
        int position = this.apngWriter.position();
        this.apngWriter.writeFourCC(IHDRChunk.ID);
        this.apngWriter.writeInt(apngFrameResource.frameWidth);
        this.apngWriter.writeInt(apngFrameResource.frameHeight);
        this.apngWriter.putBytes(apngFrameResource.ihdrData);
        CRC32 crc32 = apngFrameResource.getCRC32();
        crc32.reset();
        crc32.update(this.apngWriter.toByteArray(), position, 17);
        this.apngWriter.writeInt((int) crc32.getValue());
        for (Chunk chunk2 : apngFrameResource.prefixChunks) {
            if (!(chunk2 instanceof IENDChunk)) {
                this.apngReader.reset();
                this.apngReader.skip(chunk2.offset);
                this.apngReader.read(this.apngWriter.toByteArray(), this.apngWriter.position(), chunk2.length + 12);
                this.apngWriter.skip(chunk2.length + 12);
            }
        }
        for (Chunk chunk3 : apngFrameResource.imageChunks) {
            if (chunk3 instanceof IDATChunk) {
                this.apngReader.reset();
                this.apngReader.skip(chunk3.offset);
                this.apngReader.read(this.apngWriter.toByteArray(), this.apngWriter.position(), chunk3.length + 12);
                this.apngWriter.skip(chunk3.length + 12);
            } else if (chunk3 instanceof FDATChunk) {
                this.apngWriter.writeInt(chunk3.length - 4);
                int position2 = this.apngWriter.position();
                this.apngWriter.writeFourCC(IDATChunk.ID);
                this.apngReader.reset();
                this.apngReader.skip(chunk3.offset + 4 + 4 + 4);
                this.apngReader.read(this.apngWriter.toByteArray(), this.apngWriter.position(), chunk3.length - 4);
                this.apngWriter.skip(chunk3.length - 4);
                crc32.reset();
                crc32.update(this.apngWriter.toByteArray(), position2, chunk3.length);
                this.apngWriter.writeInt((int) crc32.getValue());
            }
        }
        this.apngWriter.putBytes(ApngWrapper.ApngFrameResource.sPNGEndChunk);
        return length;
    }

    public Bitmap getBitmap(Bitmap bitmap, ApngWrapper.ApngFrameResource apngFrameResource) {
        try {
            int encode = encode(apngFrameResource);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = this.config;
            options.inSampleSize = 1;
            options.inMutable = true;
            if (bitmap != null) {
                options.inBitmap = bitmap;
            }
            byte[] byteArray = this.apngWriter.toByteArray();
            try {
                return BitmapFactory.decodeByteArray(byteArray, 0, encode, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = 1;
                options2.inMutable = true;
                return BitmapFactory.decodeByteArray(byteArray, 0, encode, options2);
            }
        } catch (IOException e16) {
            LightLogUtil.e(TAG, e16.getMessage(), e16);
            return null;
        }
    }

    public long getDelay(int i3) {
        ApngWrapper apngWrapper = this.apngWrapper;
        if (apngWrapper != null && apngWrapper.getFrameList() != null) {
            return this.apngWrapper.getFrameList().get(i3).frameDuration;
        }
        return 0L;
    }

    public void getFrame(int i3, ApngDecoder.PackFrame packFrame) {
        Bitmap bitmap;
        ApngWrapper.ApngFrameResource apngFrameResource = this.apngWrapper.getFrameList().get(i3);
        if (packFrame.frame == null) {
            packFrame.frame = new ApngFrame();
        }
        if (packFrame.frame.getFrameSource() != null) {
            bitmap = ((ApngFrame.FrameBitmap) packFrame.frame.getFrameSource()).getBitmap();
        } else {
            bitmap = null;
        }
        packFrame.frame.setSource(apngFrameResource, getBitmap(bitmap, apngFrameResource), this.apngRender);
    }

    public int getFrameCount() {
        ApngWrapper apngWrapper = this.apngWrapper;
        if (apngWrapper != null && apngWrapper.getFrameList() != null) {
            return this.apngWrapper.getFrameList().size();
        }
        return 0;
    }

    public int getHeight() {
        return this.apngWrapper.getHeight();
    }

    public int getWidth() {
        return this.apngWrapper.getWidth();
    }

    public void reset() {
        this.apngRender.reset();
    }

    public void release() {
    }
}
