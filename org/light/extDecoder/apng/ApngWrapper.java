package org.light.extDecoder.apng;

import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.CRC32;
import org.light.extDecoder.apng.chunk.Chunk;
import org.light.extDecoder.apng.chunk.FCTLChunk;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ApngWrapper {
    private File file;
    private int height;
    private int width;
    private List<ApngFrameResource> frameList = new ArrayList();
    private int loopCount = 0;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ApngFrameResource {
        public final byte blend_op;
        public final byte dispose_op;
        public int frameDuration;
        public int frameHeight;
        public int frameWidth;
        public int frameX;
        public int frameY;
        public byte[] ihdrData;
        public List<Chunk> imageChunks = new ArrayList();
        public List<Chunk> prefixChunks = new ArrayList();
        public static final byte[] sPNGSignatures = {-119, 80, 78, 71, 13, 10, 26, 10};
        public static final byte[] sPNGEndChunk = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, Constants.VIRTUAL_GAMEPAD_SDK_DATA, -126};
        private static ThreadLocal<CRC32> sCRC32 = new ThreadLocal<>();

        public ApngFrameResource(FCTLChunk fCTLChunk) {
            this.blend_op = fCTLChunk.blend_op;
            this.dispose_op = fCTLChunk.dispose_op;
            int i3 = fCTLChunk.delay_num * 1000;
            short s16 = fCTLChunk.delay_den;
            int i16 = i3 / (s16 == 0 ? (short) 100 : s16);
            this.frameDuration = i16;
            if (i16 < 10) {
                this.frameDuration = 100;
            }
            this.frameWidth = fCTLChunk.width;
            this.frameHeight = fCTLChunk.height;
            this.frameX = fCTLChunk.x_offset;
            this.frameY = fCTLChunk.y_offset;
        }

        public CRC32 getCRC32() {
            CRC32 crc32 = sCRC32.get();
            if (crc32 == null) {
                CRC32 crc322 = new CRC32();
                sCRC32.set(crc322);
                return crc322;
            }
            return crc32;
        }

        public String toString() {
            return "ApngFrameResource{frameWidth=" + this.frameWidth + ", frameHeight=" + this.frameHeight + ", frameX=" + this.frameX + ", frameY=" + this.frameY + ", frameDuration=" + this.frameDuration + ", blend_op=" + ((int) this.blend_op) + ", dispose_op=" + ((int) this.dispose_op) + ", ihdrData=" + Arrays.toString(this.ihdrData) + ", imageChunks=" + this.imageChunks + ", prefixChunks=" + this.prefixChunks + '}';
        }
    }

    public File getFile() {
        return this.file;
    }

    public List<ApngFrameResource> getFrameList() {
        return this.frameList;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLoopCount() {
        return this.loopCount;
    }

    public int getWidth() {
        return this.width;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setFrameList(List<ApngFrameResource> list) {
        this.frameList = list;
    }

    public void setHeight(int i3) {
        this.height = i3;
    }

    public void setLoopCount(int i3) {
        this.loopCount = i3;
    }

    public void setWidth(int i3) {
        this.width = i3;
    }
}
