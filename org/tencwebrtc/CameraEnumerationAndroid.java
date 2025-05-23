package org.tencwebrtc;

import android.graphics.ImageFormat;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CameraEnumerationAndroid {
    static final ArrayList<Size> COMMON_RESOLUTIONS = new ArrayList<>(Arrays.asList(new Size(160, 120), new Size(240, 160), new Size(320, 240), new Size(400, 240), new Size(480, 320), new Size(640, 360), new Size(640, 480), new Size(768, 480), new Size(854, 480), new Size(800, 600), new Size(960, 540), new Size(960, 640), new Size(1024, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT), new Size(1024, 600), new Size(1280, 720), new Size(1280, 1024), new Size(1920, 1080), new Size(1920, 1440), new Size(ExportOutput.VALUE_LEVEL_1440P_MAX_LENGTH, 1440), new Size(3840, 2160)));
    private static final String TAG = "CameraEnumerationAndroid";

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class CaptureFormat {
        public final FramerateRange framerate;
        public final int height;
        public final int imageFormat = 17;
        public final int width;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static class FramerateRange {
            public int max;
            public int min;

            public FramerateRange(int i3, int i16) {
                this.min = i3;
                this.max = i16;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof FramerateRange)) {
                    return false;
                }
                FramerateRange framerateRange = (FramerateRange) obj;
                if (this.min != framerateRange.min || this.max != framerateRange.max) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return (this.min * 65537) + 1 + this.max;
            }

            public String toString() {
                return "[" + (this.min / 1000.0f) + ":" + (this.max / 1000.0f) + "]";
            }
        }

        public CaptureFormat(int i3, int i16, int i17, int i18) {
            this.width = i3;
            this.height = i16;
            this.framerate = new FramerateRange(i17, i18);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CaptureFormat)) {
                return false;
            }
            CaptureFormat captureFormat = (CaptureFormat) obj;
            if (this.width != captureFormat.width || this.height != captureFormat.height || !this.framerate.equals(captureFormat.framerate)) {
                return false;
            }
            return true;
        }

        public int frameSize() {
            return frameSize(this.width, this.height, 17);
        }

        public int hashCode() {
            return (((this.width * 65497) + this.height) * 251) + 1 + this.framerate.hashCode();
        }

        public String toString() {
            return this.width + HippyTKDListViewAdapter.X + this.height + "@" + this.framerate;
        }

        public static int frameSize(int i3, int i16, int i17) {
            if (i17 == 17) {
                return ((i3 * i16) * ImageFormat.getBitsPerPixel(i17)) / 8;
            }
            throw new UnsupportedOperationException("Don't know how to calculate the frame size of non-NV21 image formats.");
        }

        public CaptureFormat(int i3, int i16, FramerateRange framerateRange) {
            this.width = i3;
            this.height = i16;
            this.framerate = framerateRange;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static abstract class ClosestComparator<T> implements Comparator<T> {
        ClosestComparator() {
        }

        @Override // java.util.Comparator
        public int compare(T t16, T t17) {
            return diff(t16) - diff(t17);
        }

        abstract int diff(T t16);
    }

    public static CaptureFormat.FramerateRange getClosestSupportedFramerateRange(List<CaptureFormat.FramerateRange> list, final int i3) {
        return (CaptureFormat.FramerateRange) Collections.min(list, new ClosestComparator<CaptureFormat.FramerateRange>() { // from class: org.tencwebrtc.CameraEnumerationAndroid.1
            private static final int MAX_FPS_DIFF_THRESHOLD = 5000;
            private static final int MAX_FPS_HIGH_DIFF_WEIGHT = 3;
            private static final int MAX_FPS_LOW_DIFF_WEIGHT = 1;
            private static final int MIN_FPS_HIGH_VALUE_WEIGHT = 4;
            private static final int MIN_FPS_LOW_VALUE_WEIGHT = 1;
            private static final int MIN_FPS_THRESHOLD = 8000;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            private int progressivePenalty(int i16, int i17, int i18, int i19) {
                if (i16 < i17) {
                    return i16 * i18;
                }
                return ((i16 - i17) * i19) + (i18 * i17);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.tencwebrtc.CameraEnumerationAndroid.ClosestComparator
            public int diff(CaptureFormat.FramerateRange framerateRange) {
                return progressivePenalty(framerateRange.min, 8000, 1, 4) + progressivePenalty(Math.abs((i3 * 1000) - framerateRange.max), 5000, 1, 3);
            }
        });
    }

    public static Size getClosestSupportedSize(List<Size> list, final int i3, final int i16) {
        return (Size) Collections.min(list, new ClosestComparator<Size>() { // from class: org.tencwebrtc.CameraEnumerationAndroid.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.tencwebrtc.CameraEnumerationAndroid.ClosestComparator
            public int diff(Size size) {
                return Math.abs(i3 - size.width) + Math.abs(i16 - size.height);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportCameraResolution(Histogram histogram, Size size) {
        histogram.addSample(COMMON_RESOLUTIONS.indexOf(size) + 1);
    }
}
