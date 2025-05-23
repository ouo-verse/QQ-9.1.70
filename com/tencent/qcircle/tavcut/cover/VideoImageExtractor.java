package com.tencent.qcircle.tavcut.cover;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.common.constants.RenderInfoParamsConst;
import com.tencent.qcircle.weseevideo.editor.utils.HandlerUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.composition.TAVSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoImageExtractor {
    private List<Bitmap> mBitMapList;
    private CountDownLatch mCountDownLatch;
    private int mCoverHeight;
    private CoverProvider mCoverProvider;
    private int mCoverWidth;
    private TAVSource mTavSource;
    private List<CMTime> mTimeInfo;

    private List<CMTime> getCMTimeInfos(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CMTime.fromMs(it.next().longValue()));
        }
        return arrayList;
    }

    public List<Bitmap> extractImages() {
        if (this.mCoverProvider != null) {
            HandlerUtils.getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.qcircle.tavcut.cover.VideoImageExtractor.2
                @Override // java.lang.Runnable
                public void run() {
                    VideoImageExtractor.this.mCoverProvider.init(VideoImageExtractor.this.mTavSource, VideoImageExtractor.this.mTimeInfo, VideoImageExtractor.this.mCoverWidth, VideoImageExtractor.this.mCoverHeight);
                }
            }, 300L);
            try {
                this.mCountDownLatch.await();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return this.mBitMapList;
    }

    public void initCoverProvider(List<Long> list, @NonNull TAVSource tAVSource, CGSize cGSize, int i3) {
        this.mBitMapList = new ArrayList();
        this.mTimeInfo = getCMTimeInfos(list);
        this.mCoverHeight = (int) cGSize.height;
        this.mCoverWidth = (int) cGSize.width;
        Logger.i("VideoImageExtractor", "width = " + this.mCoverWidth + "height = " + this.mCoverHeight);
        if (i3 > 0) {
            int i16 = this.mCoverWidth;
            int i17 = this.mCoverHeight;
            float f16 = (i16 * 1.0f) / i17;
            if (i17 > i16) {
                if (i17 > i3) {
                    this.mCoverHeight = i3;
                    this.mCoverWidth = (int) (i3 * f16);
                }
            } else if (i16 > i3) {
                this.mCoverWidth = i3;
                this.mCoverHeight = (int) (i3 / f16);
            }
        }
        Logger.i("VideoImageExtractor", "scaled width = " + this.mCoverWidth + "height = " + this.mCoverHeight);
        this.mTavSource = tAVSource;
        if (this.mCoverProvider == null) {
            this.mCoverProvider = new CoverProvider();
            RenderContextParams renderContextParams = new RenderContextParams();
            renderContextParams.putParam("video_cover", RenderInfoParamsConst.Params.VIDEO_COVER_PARAM);
            this.mCoverProvider.setRenderContextParams(renderContextParams);
            this.mCountDownLatch = new CountDownLatch(list.size());
            this.mCoverProvider.setCoverListener(new CoverListener() { // from class: com.tencent.qcircle.tavcut.cover.VideoImageExtractor.1
                @Override // com.tencent.qcircle.tavcut.cover.CoverListener
                public void onCover(int i18, Bitmap bitmap) {
                    Logger.i("Cover", "generated Bitmap = " + bitmap.toString());
                    VideoImageExtractor.this.mBitMapList.add(bitmap);
                    VideoImageExtractor.this.mCountDownLatch.countDown();
                }
            });
        }
    }

    public void release() {
        this.mCoverProvider.release();
    }
}
