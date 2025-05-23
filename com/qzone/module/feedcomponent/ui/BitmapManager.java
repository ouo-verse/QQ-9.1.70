package com.qzone.module.feedcomponent.ui;

import android.graphics.Paint;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.component.media.image.ProgressTracer;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BitmapManager {
    public static boolean CLOSE_HARDWARE_ACCELERATED = false;
    protected static int COMMENT_HEIGHT = 0;
    static final int COMMENT_SIZE = 4;
    protected static int MAINBODY_HEIGHT = 0;
    static final int MAINBODY_SIZE = 3;
    public static boolean OPEN_BITMAP = false;
    public static final int TYPE_COMMENT = 2;
    public static final int TYPE_MAINBODY = 1;
    static BitmapManager mInstance;
    static int mem;
    final LinkedList<FeedBitmap> MAIMBODY_CACHE = new LinkedList<>();
    final LinkedList<FeedBitmap> COMMENT_CACHE = new LinkedList<>();

    public BitmapManager() {
        if (OPEN_BITMAP) {
            loadCommentBitmap();
            loadMainBodyBitmap();
        }
    }

    public static BitmapManager getInstance() {
        if (mInstance == null) {
            synchronized (BitmapManager.class) {
                if (mInstance == null) {
                    mInstance = new BitmapManager();
                }
            }
        }
        return mInstance;
    }

    void loadCommentBitmap() {
        for (int size = this.COMMENT_CACHE.size(); size < 4; size++) {
            this.COMMENT_CACHE.add(new FeedBitmap(2));
        }
    }

    void loadMainBodyBitmap() {
        for (int size = this.MAIMBODY_CACHE.size(); size < 3; size++) {
            this.MAIMBODY_CACHE.add(new FeedBitmap(1));
        }
    }

    public FeedBitmap obtainBitmap(int i3) {
        return obtainBitmap(i3, -1);
    }

    static {
        try {
            OPEN_BITMAP = false;
            com.qzone.proxy.feedcomponent.b.a("BitmapManager", "BitmapManager open:" + OPEN_BITMAP + ProgressTracer.SEPARATOR + CLOSE_HARDWARE_ACCELERATED);
            Paint paint = new Paint();
            paint.setTextSize(FeedGlobalEnv.g().getSpValue(AreaConst.summaryTextSize));
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            int ceil = (int) Math.ceil((double) (fontMetrics.descent - fontMetrics.top));
            int i3 = FeedTextArea.lineSpace;
            MAINBODY_HEIGHT = (ceil + i3) * 18;
            COMMENT_HEIGHT = (((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + i3) * 7;
        } catch (Throwable th5) {
            th5.printStackTrace();
            mem = 0;
            OPEN_BITMAP = false;
            CLOSE_HARDWARE_ACCELERATED = false;
            MAINBODY_HEIGHT = 0;
            COMMENT_HEIGHT = 0;
        }
    }

    public FeedBitmap obtainBitmap(int i3, int i16) {
        FeedBitmap poll;
        if ((i3 <= COMMENT_HEIGHT && this.COMMENT_CACHE.size() > 0) || this.MAIMBODY_CACHE.size() == 0) {
            poll = this.COMMENT_CACHE.poll();
        } else {
            poll = this.MAIMBODY_CACHE.poll();
        }
        if (poll != null) {
            poll.reset();
            poll.getBitmap().eraseColor(0);
        }
        return poll;
    }

    public void recyle(FeedBitmap feedBitmap) {
        if (feedBitmap != null) {
            int i3 = feedBitmap.mType;
            if (i3 == 1) {
                this.MAIMBODY_CACHE.add(feedBitmap);
            } else {
                if (i3 != 2) {
                    return;
                }
                this.COMMENT_CACHE.add(feedBitmap);
            }
        }
    }

    FeedBitmap obtainBitmap(int i3, boolean z16) {
        if (i3 > MAINBODY_HEIGHT) {
            return null;
        }
        if (z16) {
            FeedBitmap obtain = obtain(1, i3);
            return (obtain != null || i3 > COMMENT_HEIGHT) ? obtain : obtain(2, i3);
        }
        if (i3 > COMMENT_HEIGHT) {
            return obtain(1, i3);
        }
        FeedBitmap obtain2 = obtain(2, i3);
        return obtain2 == null ? obtain(1, i3) : obtain2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    FeedBitmap obtain(int i3, int i16) {
        FeedBitmap first;
        FeedBitmap feedBitmap = null;
        if (i3 != 1) {
            if (i3 == 2) {
                if (this.COMMENT_CACHE.size() == 0) {
                    return null;
                }
                first = this.COMMENT_CACHE.getFirst();
                int height = first.getHeight();
                int i17 = first.heightOffset;
                if (height - i17 >= i16) {
                    first.heightOffset = i17 + i16;
                    feedBitmap = first;
                } else {
                    this.COMMENT_CACHE.removeFirst().isUsed = true;
                    if (this.COMMENT_CACHE.size() != 0) {
                        feedBitmap = this.COMMENT_CACHE.getFirst();
                        feedBitmap.heightOffset += i16;
                    }
                }
            }
            if (feedBitmap != null) {
                feedBitmap.mReferenceCount++;
            }
            return feedBitmap;
        }
        if (this.MAIMBODY_CACHE.size() == 0) {
            return null;
        }
        first = this.MAIMBODY_CACHE.getFirst();
        if (first != null) {
            int height2 = first.getHeight();
            int i18 = first.heightOffset;
            if (height2 - i18 >= i16) {
                first.heightOffset = i18 + i16;
            } else {
                first.isUsed = true;
                this.MAIMBODY_CACHE.removeFirst();
                if (this.MAIMBODY_CACHE.size() != 0) {
                    feedBitmap = this.MAIMBODY_CACHE.getFirst();
                    feedBitmap.heightOffset += i16;
                }
                if (feedBitmap != null) {
                }
                return feedBitmap;
            }
        }
        feedBitmap = first;
        if (feedBitmap != null) {
        }
        return feedBitmap;
    }

    public void debug() {
    }
}
