package org.light.extDecoder.apng;

import android.graphics.Bitmap;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ApngDecoder {
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final String TAG = "ApngDecoder";
    private final ApngFrameReader frameReader;
    private int loadPointer;
    private int framePointer = -1;
    private PackFrame mFrontFrame = new PackFrame(null, -1);
    private PackFrame mBackFrame = new PackFrame(null, -1);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class PackFrame {
        ApngFrame frame;
        int pointer;

        public PackFrame(ApngFrame apngFrame, int i3) {
            this.frame = apngFrame;
            this.pointer = i3;
        }
    }

    public ApngDecoder(ApngWrapper apngWrapper, Bitmap.Config config) throws IOException {
        this.frameReader = new ApngFrameReader(apngWrapper, config);
        initFrame();
    }

    private void initFrame() {
        PackFrame packFrame = this.mFrontFrame;
        packFrame.pointer = 0;
        this.frameReader.getFrame(0, packFrame);
        PackFrame packFrame2 = this.mBackFrame;
        packFrame2.pointer = 1;
        this.frameReader.getFrame(1, packFrame2);
    }

    private void loadFrame(int i3) {
        if (this.loadPointer == i3) {
            return;
        }
        this.loadPointer = i3;
        PackFrame packFrame = this.mBackFrame;
        packFrame.pointer = i3;
        this.frameReader.getFrame(i3, packFrame);
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % getFrameCount();
    }

    public void clear() {
        this.frameReader.release();
        this.mFrontFrame.frame.recycle();
        this.mBackFrame.frame.recycle();
        this.mFrontFrame = null;
        this.mBackFrame = null;
        this.framePointer = -1;
    }

    public int getByteSize() {
        return 0;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public int getDelay(int i3) {
        return (int) this.frameReader.getDelay(i3);
    }

    public int getFrameCount() {
        return this.frameReader.getFrameCount();
    }

    public int getHeight() {
        return this.frameReader.getHeight();
    }

    public int getLoopCount() {
        return 0;
    }

    public int getNextDelay() {
        return getDelay(getCurrentFrameIndex());
    }

    public synchronized ApngFrame getNextFrame() {
        PackFrame packFrame = this.mFrontFrame;
        int i3 = packFrame.pointer;
        int i16 = this.framePointer;
        if (i3 != i16) {
            this.mFrontFrame = this.mBackFrame;
            this.mBackFrame = packFrame;
            loadFrame((i16 + 1) % getFrameCount());
        }
        return this.mFrontFrame.frame;
    }

    public int getWidth() {
        return this.frameReader.getWidth();
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
        this.frameReader.reset();
        initFrame();
    }
}
