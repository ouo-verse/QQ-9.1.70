package com.enrique.stackblur;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class NativeBlurProcess implements BlurProcess {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class NativeTask implements Callable<Void> {
        private final Bitmap _bitmapOut;
        private final int _coreIndex;
        private final int _radius;
        private final int _round;
        private final int _totalCores;

        public NativeTask(Bitmap bitmap, int i3, int i16, int i17, int i18) {
            this._bitmapOut = bitmap;
            this._radius = i3;
            this._totalCores = i16;
            this._coreIndex = i17;
            this._round = i18;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            NativeBlurProcess.functionToBlur(this._bitmapOut, this._radius, this._totalCores, this._coreIndex, this._round);
            return null;
        }
    }

    static {
        System.loadLibrary("blur");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void functionToBlur(Bitmap bitmap, int i3, int i16, int i17, int i18);

    @Override // com.enrique.stackblur.BlurProcess
    public Bitmap blur(Bitmap bitmap, float f16) {
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        int i3 = StackBlurManager.EXECUTOR_THREADS;
        ArrayList arrayList = new ArrayList(i3);
        ArrayList arrayList2 = new ArrayList(i3);
        for (int i16 = 0; i16 < i3; i16++) {
            int i17 = (int) f16;
            int i18 = i16;
            arrayList.add(new NativeTask(copy, i17, i3, i18, 1));
            arrayList2.add(new NativeTask(copy, i17, i3, i18, 2));
        }
        try {
            ExecutorService executorService = StackBlurManager.EXECUTOR;
            executorService.invokeAll(arrayList);
            executorService.invokeAll(arrayList2);
        } catch (InterruptedException unused) {
        }
        return copy;
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
