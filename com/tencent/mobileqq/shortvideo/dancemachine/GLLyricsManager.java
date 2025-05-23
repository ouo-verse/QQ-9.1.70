package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLLyricsManager {
    private GLViewContext mContext;
    private String mKey;
    private GLLyricsView mLyricsView;
    private long mStartRecordMis;

    public GLLyricsManager(GLViewContext gLViewContext, String str) {
        this.mContext = gLViewContext;
        this.mKey = str;
        GLLyricsView gLLyricsView = new GLLyricsView(this.mContext, this.mKey);
        this.mLyricsView = gLLyricsView;
        gLLyricsView.setTextSize(DisplayUtils.pixelToRealPixel(56.0f));
        this.mLyricsView.setShadowPadding(DisplayUtils.pixelToRealPixel(20.0f));
    }

    private void ResetLyricsViewLayout(String str) {
        if (str == null) {
            this.mLyricsView.setVisibility(false);
            return;
        }
        this.mLyricsView.clearTextCache();
        this.mLyricsView.setText(str, -1);
        Rect surfaceViewSize = this.mContext.getSurfaceViewSize();
        int width = surfaceViewSize.width();
        int height = surfaceViewSize.height();
        float f16 = width;
        RectF rectF = new RectF(0.0f, 0.0f, f16, height);
        float textWidth = ((f16 - this.mLyricsView.getTextWidth()) - this.mLyricsView.getShadowPadding()) / 2.0f;
        float pixelToRealPixel = ((height - DisplayUtils.pixelToRealPixel(100.0f)) - this.mLyricsView.getTextHeight()) - this.mLyricsView.getShadowPadding();
        rectF.set(textWidth, pixelToRealPixel, f16 - textWidth, this.mLyricsView.getTextHeight() + pixelToRealPixel + this.mLyricsView.getShadowPadding());
        this.mLyricsView.setImageRegion(rectF);
        this.mLyricsView.setImageClipDrawRegion(rectF);
        this.mLyricsView.setVisibility(true);
    }

    private int calculateNewStatus(ResourceManager.LyricItem lyricItem) {
        long uptimeMillis = SystemClock.uptimeMillis() - this.mStartRecordMis;
        int i3 = lyricItem.startTime;
        if (i3 > uptimeMillis) {
            return 0;
        }
        if (i3 <= uptimeMillis && lyricItem.endTime > uptimeMillis) {
            return 1;
        }
        return 2;
    }

    public void clearStatus() {
        this.mStartRecordMis = 0L;
        this.mLyricsView.setVisibility(false);
    }

    public void drawFrame() {
        List<ResourceManager.LyricItem> lyricsList = ResourceManager.getInstance().getLyricsList();
        if (lyricsList != null && lyricsList.size() > 0 && this.mStartRecordMis > 0) {
            Iterator<ResourceManager.LyricItem> it = lyricsList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ResourceManager.LyricItem next = it.next();
                int i3 = next.status;
                if (i3 != 2) {
                    if (i3 == 1) {
                        int calculateNewStatus = calculateNewStatus(next);
                        if (calculateNewStatus == 2) {
                            ResetLyricsViewLayout(null);
                            next.status = calculateNewStatus;
                        } else if (calculateNewStatus == 1) {
                            break;
                        }
                    } else {
                        int calculateNewStatus2 = calculateNewStatus(next);
                        if (calculateNewStatus2 == 1) {
                            ResetLyricsViewLayout(next.text);
                            next.status = calculateNewStatus2;
                            break;
                        } else if (calculateNewStatus2 == 2) {
                            ResetLyricsViewLayout(null);
                            next.status = calculateNewStatus2;
                        }
                    }
                }
            }
            this.mLyricsView.draw();
        }
    }

    public void updateStartTimestamp(long j3) {
        this.mStartRecordMis = j3;
    }
}
