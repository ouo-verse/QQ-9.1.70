package com.qzone.preview.photodanmaku.core;

import android.content.Context;
import com.qzone.preview.photodanmaku.config.PhotoDanmakuConfig;
import com.qzone.preview.photodanmaku.entity.AbsDanmaku;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes39.dex */
public class PhotoDanmakuFactory {
    private static final int MAX_RECYCLING_SIZE = 50;
    private static final String TAG = "PhotoDanmakuFactory";
    private final PhotoDanmakuDrawer mR2LDrawer;
    private final com.qzone.preview.photodanmaku.entity.a mR2LDuration;
    private final PhotoDanmakuConfig mR2LPhotoDanmakuConfig;
    private final BlockingQueue<AbsDanmaku> mR2LRecyclingQueue = new LinkedBlockingQueue();
    private final BlockingQueue<AbsDanmaku> mSenceRecyclingQueue = new LinkedBlockingQueue();
    private final com.qzone.preview.photodanmaku.entity.b mTimer;

    public PhotoDanmakuFactory(Context context, com.qzone.preview.photodanmaku.entity.b bVar, int i3) {
        this.mTimer = bVar;
        this.mR2LPhotoDanmakuConfig = PhotoDanmakuConfig.getConfig(context, 1, i3);
        this.mR2LDrawer = new PhotoDanmakuDrawer(context, null, null);
        this.mR2LDuration = new com.qzone.preview.photodanmaku.entity.a(r3.mDuration);
    }

    public void clear() {
        this.mR2LRecyclingQueue.clear();
        this.mSenceRecyclingQueue.clear();
    }

    public AbsDanmaku createDanmaku(int i3, long j3, String str, CharSequence charSequence, int i16, float f16, int i17) {
        AbsDanmaku createDanmaku = createDanmaku(i3);
        if (createDanmaku != null) {
            createDanmaku.setTime(j3);
            createDanmaku.setNickNameStr(str);
            createDanmaku.setText(charSequence);
            createDanmaku.setBorderWidth(f16);
            createDanmaku.setBorderColor(i17);
            createDanmaku.setTextColor(i16);
        }
        return createDanmaku;
    }

    public AbsDanmaku measureDanmaku(AbsDanmaku absDanmaku) {
        if (absDanmaku.getType() == 1 && !absDanmaku.isMeasured()) {
            absDanmaku.onMeasure(this.mR2LDrawer);
        }
        return absDanmaku;
    }

    public void recycle(AbsDanmaku absDanmaku) {
        absDanmaku.reset();
        if (absDanmaku.getType() == 1 && 50 > this.mR2LRecyclingQueue.size()) {
            this.mR2LRecyclingQueue.add(absDanmaku);
        }
    }

    public AbsDanmaku createDanmaku(int i3) {
        if (i3 != 1) {
            return null;
        }
        AbsDanmaku poll = this.mR2LRecyclingQueue.poll();
        return poll == null ? new com.qzone.preview.photodanmaku.entity.c(this.mR2LPhotoDanmakuConfig, this.mR2LDuration.a(), this.mTimer) : poll;
    }
}
