package com.tencent.ttpic.openapi.view;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LazyLoadAnimationDrawable extends AnimationDrawable {
    private int cur = 0;
    private BitmapDrawable currentDrawable;
    private int[] durations;
    private String[] filenames;
    private BitmapDrawable nextDrawable;
    private Resources res;
    private int totalDuration;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Info {
        public int[] durations;
        public String[] filenames;
        public Resources res;
        public int totalDuration = 0;

        public Info(Resources resources, ArrayList<File> arrayList, int[] iArr, Integer[] numArr) {
            this.filenames = null;
            this.durations = null;
            this.res = resources;
            this.filenames = new String[arrayList.size()];
            this.durations = new int[arrayList.size()];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                this.filenames[i3] = arrayList.get(numArr[i3].intValue()).getAbsolutePath();
                this.durations[i3] = iArr[numArr[i3].intValue()];
                this.totalDuration += this.durations[i3];
            }
        }
    }

    public LazyLoadAnimationDrawable(Info info) {
        this.filenames = null;
        this.durations = null;
        this.totalDuration = 0;
        this.res = info.res;
        String[] strArr = info.filenames;
        this.filenames = strArr;
        this.durations = info.durations;
        this.totalDuration = info.totalDuration;
        if (strArr.length > 0) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.res, this.filenames[this.cur]);
            this.nextDrawable = bitmapDrawable;
            addFrame(bitmapDrawable, this.durations[this.cur]);
        }
    }

    public void clear() {
        this.res = null;
        BitmapDrawable bitmapDrawable = this.currentDrawable;
        if (bitmapDrawable != null) {
            BitmapUtils.recycle(bitmapDrawable.getBitmap());
        }
        BitmapDrawable bitmapDrawable2 = this.nextDrawable;
        if (bitmapDrawable2 != null) {
            BitmapUtils.recycle(bitmapDrawable2.getBitmap());
        }
    }

    public int getTotalDuration() {
        return this.totalDuration;
    }

    @Override // android.graphics.drawable.AnimationDrawable, java.lang.Runnable
    public void run() {
        LogUtils.d("111", "test animation running");
        this.cur++;
        BitmapDrawable bitmapDrawable = this.currentDrawable;
        if (bitmapDrawable != null) {
            BitmapUtils.recycle(bitmapDrawable.getBitmap());
        }
        this.currentDrawable = this.nextDrawable;
        if (this.cur < this.filenames.length) {
            BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.res, this.filenames[this.cur]);
            this.nextDrawable = bitmapDrawable2;
            addFrame(bitmapDrawable2, this.durations[this.cur]);
            super.run();
        }
    }
}
