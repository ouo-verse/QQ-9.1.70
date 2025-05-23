package com.qzone.module.feedcomponent.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.p;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.processor.MarkProcessor;
import com.tencent.component.media.image.processor.MergeProcessor;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes39.dex */
public class PraiseAvatarsArea extends SubArea implements r {
    static final int DRAW_MODE_AVATARS = 1;
    static final int DRAW_MODE_NOTHING = 0;
    static final int DRAW_MODE_PRAISE_TEXT_ONLY = 2;
    static final int MARGIN_LEFT;
    static final int MAX_COLUMN_COUNT;
    static final int MAX_ROW_COUNT = 2;
    static final OvalProcessor OVAL_PROCESSOR;
    static final Drawable SUPER_LIKE;
    static final Bitmap SUPER_LIKE_BITMAP;
    static final String TAG = "PraiseAvatarsArea";
    private static String feelGoodText;
    static int mAvatarCustomCountTextColor;
    static int mAvatarCustomCountTextSize;
    static MergeProcessor mSuperLikeProcessor;
    static final Paint sAvatarCountRingTextPaint;
    static final Paint sAvatarCountTextPaint;
    static final Paint sAvatarCustomCountTextPaint;
    static int sAvatarKey;
    static final Paint sAvatarPressStatePaint;
    static final int sAvatarVerticalSpacing;
    static final int sFirstAvatarX;
    static final int sFirstAvatarXWithoutPraiseIcon;
    static final int sFirstAvatarY;
    static final int sPraiseIconSize;
    static final Paint sRingPaint;
    String mCustomMoreString;
    int mDrawMode;
    int mHeight;
    int mLikeNum;
    int mMaxShowAvatarsCount;
    float mOnTouchDownX;
    float mOnTouchDownY;
    float sAvatarCountRingTextCenterX;
    int sAvatarOffsetX;
    int sAvatarOffsetY;
    int sAvatarSize;
    Rect[] sAvatarsTouchRects;
    Rect[] sAvatarsTouchRectsWithoutPraiseIcon;
    int sPraiseIconCenter;
    int sPraiseIconMarginTopWhileHasAvatars;
    float sRingCenterXY;
    RectF sRingRectF;
    float sRingTranslate;

    /* renamed from: sb, reason: collision with root package name */
    StringBuilder f48759sb;
    Drawable DRAWABLE_DEFAULT_AVATAR = AvatarArea.DEFAULT_AVATAR;
    int avatarStrokeSize = AreaManager.f48751dp2;
    final Map<String, Drawable> mAvatarDrawables = Collections.synchronizedMap(new LinkedHashMap());
    List<CellLikeInfo.LikeMan> mUsers = new ArrayList();
    int mWidth = FeedGlobalEnv.g().getScreenWidth();
    List<Drawable> mAvatarRowCache = new ArrayList(MAX_COLUMN_COUNT);
    int mOnTouchDownPos = -1;
    boolean mAvatarPressEnable = true;
    boolean mShowPraiseIcon = true;
    ImageLoader.ImageLoadListener mImageLoadListener = new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.PraiseAvatarsArea.1
        private static final int maxInvalidateInterval = 250;

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            PraiseAvatarsArea praiseAvatarsArea = PraiseAvatarsArea.this;
            Map<String, Drawable> map = praiseAvatarsArea.mAvatarDrawables;
            if (drawable == null) {
                drawable = praiseAvatarsArea.DRAWABLE_DEFAULT_AVATAR;
            }
            map.put(str, drawable);
            Handler handler = AreaManager.mainHanlder;
            if (handler.hasMessages(1, PraiseAvatarsArea.this)) {
                return;
            }
            handler.sendMessageDelayed(handler.obtainMessage(1, PraiseAvatarsArea.this), 250L);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    };

    static {
        OvalProcessor ovalProcessor = new OvalProcessor();
        OVAL_PROCESSOR = ovalProcessor;
        Drawable g16 = com.qzone.adapter.feedcomponent.j.g(595);
        SUPER_LIKE = g16;
        int a16 = com.qzone.proxy.feedcomponent.util.g.a(8.0f);
        MARGIN_LEFT = a16;
        MAX_COLUMN_COUNT = com.qzone.adapter.feedcomponent.b.f41861h;
        int width = AreaManager.HAS_PRAISE_DRAWABLE.getBounds().width();
        sPraiseIconSize = width;
        sAvatarVerticalSpacing = com.qzone.proxy.feedcomponent.util.g.a(7.0f);
        sFirstAvatarX = width + a16 + com.qzone.proxy.feedcomponent.util.g.a(9.0f);
        sFirstAvatarXWithoutPraiseIcon = a16;
        sFirstAvatarY = 0;
        Paint paint = new Paint(1);
        sRingPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.5f);
        paint.setColor(com.qzone.adapter.feedcomponent.j.c(8));
        Paint paint2 = new Paint(1);
        sAvatarPressStatePaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.parseColor("#80808080"));
        Paint paint3 = new Paint(129);
        sAvatarCountRingTextPaint = paint3;
        paint3.setColor(com.qzone.adapter.feedcomponent.j.F());
        paint3.setTextAlign(Paint.Align.CENTER);
        Paint paint4 = new Paint(129);
        sAvatarCountTextPaint = paint4;
        paint4.setColor(com.qzone.adapter.feedcomponent.j.I());
        paint4.setTextSize((int) FeedGlobalEnv.g().getSpValue(AreaConst.visitListTextSize));
        Paint paint5 = new Paint(129);
        sAvatarCustomCountTextPaint = paint5;
        int o16 = com.qzone.adapter.feedcomponent.j.o();
        mAvatarCustomCountTextColor = o16;
        paint5.setColor(o16);
        paint5.setTextSize((int) FeedGlobalEnv.g().getSpValue(AreaConst.visitListTextSize));
        MergeProcessor mergeProcessor = new MergeProcessor();
        mSuperLikeProcessor = mergeProcessor;
        mergeProcessor.addProcessor(ovalProcessor);
        if (g16 instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) g16).getBitmap();
            SUPER_LIKE_BITMAP = bitmap;
            mSuperLikeProcessor.addProcessor(new MarkProcessor(bitmap, 3, 0.4f));
        } else {
            SUPER_LIKE_BITMAP = null;
        }
        sAvatarKey = 1;
        feelGoodText = com.qzone.adapter.feedcomponent.h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ManyPeopleFeelGood", "\u4eba\u89c9\u5f97\u5f88\u8d5e");
    }

    public PraiseAvatarsArea() {
        this.mType = 36;
        setAvatarSize(AreaConst.dp20);
    }

    static int generateAvatarKey() {
        int i3 = sAvatarKey + 1;
        sAvatarKey = i3;
        return i3;
    }

    public static void onThemeChange() {
        sRingPaint.setColor(com.qzone.adapter.feedcomponent.j.c(8));
        sAvatarCountRingTextPaint.setColor(com.qzone.adapter.feedcomponent.j.F());
        sAvatarCountTextPaint.setColor(com.qzone.adapter.feedcomponent.j.I());
        sAvatarCustomCountTextPaint.setColor(mAvatarCustomCountTextColor);
    }

    void calcDrawMode() {
        if (this.mUsers.size() != 0) {
            this.mDrawMode = 1;
        } else if (this.mLikeNum > 0) {
            this.mDrawMode = 2;
        } else {
            this.mDrawMode = 0;
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        int i3;
        int i16;
        int i17 = this.mDrawMode;
        if (i17 == 1) {
            if (this.mShowPraiseIcon) {
                drawPraiseIcon(canvas, this.sPraiseIconMarginTopWhileHasAvatars);
            }
            canvas.save();
            if (this.mShowPraiseIcon) {
                i3 = sFirstAvatarX;
            } else {
                i3 = sFirstAvatarXWithoutPraiseIcon;
            }
            canvas.translate(i3, sFirstAvatarY + this.avatarStrokeSize);
            drawAvatarList(canvas);
            canvas.restore();
        } else if (i17 == 2) {
            if (this.mShowPraiseIcon) {
                drawPraiseIcon(canvas, 0);
            }
            canvas.save();
            if (this.mShowPraiseIcon) {
                i16 = sFirstAvatarX;
            } else {
                i16 = sFirstAvatarXWithoutPraiseIcon;
            }
            canvas.translate(i16, sFirstAvatarY);
            drawAvatarsCountTextNoRing(canvas);
            canvas.restore();
        }
        return true;
    }

    void drawAndAvatarCountTextWithRing(Canvas canvas, int i3) {
        String str;
        drawRing(canvas, i3);
        int i16 = this.mLikeNum;
        int i17 = 10;
        int i18 = 12;
        try {
            if (i16 >= 10000) {
                int round = Math.round(i16 / 10000.0f);
                if (round > 999) {
                    round = 999;
                }
                str = round + "w";
            } else if (i16 >= 1000) {
                str = Math.round(i16 / 1000.0f) + "k";
            } else {
                str = String.valueOf(i16);
                i17 = 12;
            }
            i18 = i17;
        } catch (Exception unused) {
            str = "0";
        }
        int spValue = (int) FeedGlobalEnv.g().getSpValue(i18);
        Paint paint = sAvatarCountRingTextPaint;
        paint.setTextSize(spValue);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f16 = this.sRingCenterXY;
        float f17 = fontMetrics.descent;
        canvas.drawText(str, this.sAvatarCountRingTextCenterX, (f16 - f17) + ((f17 - fontMetrics.ascent) / 2.0f), paint);
    }

    void drawAvatarRow(Canvas canvas, List<Drawable> list, int i3, int i16, boolean z16) {
        canvas.save();
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        for (Drawable drawable : list) {
            int i17 = this.sAvatarSize;
            canvas.drawCircle(i17 / 2, i17 / 2, (i17 + this.avatarStrokeSize) / 2, paint);
            drawable.draw(canvas);
            if (i3 == this.mOnTouchDownPos && this.mAvatarPressEnable) {
                canvas.drawArc(this.sRingRectF, 0.0f, 360.0f, false, sAvatarPressStatePaint);
            }
            canvas.translate(i16, 0.0f);
            i3++;
        }
        if (z16) {
            drawAndAvatarCountTextWithRing(canvas, i3);
        }
        if (this.mCustomMoreString != null) {
            drawCustomAvatarsCountText(canvas);
        }
        canvas.restore();
    }

    void drawAvatarsCountTextNoRing(Canvas canvas) {
        canvas.drawText(this.mLikeNum + feelGoodText, 0.0f, this.sPraiseIconCenter, sAvatarCountTextPaint);
    }

    void drawCustomAvatarsCountText(Canvas canvas) {
        if (this.mCustomMoreString != null) {
            Paint paint = sAvatarCustomCountTextPaint;
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f16 = this.sRingCenterXY;
            float f17 = fontMetrics.descent;
            canvas.drawText(String.format(this.mCustomMoreString, Integer.valueOf(this.mLikeNum)), 0.0f, (f16 - f17) + ((f17 - fontMetrics.ascent) / 2.0f), paint);
        }
    }

    void drawPraiseIcon(Canvas canvas, int i3) {
        canvas.save();
        canvas.translate(MARGIN_LEFT, i3);
        AreaManager.HAS_PRAISE_DRAWABLE.draw(canvas);
        canvas.restore();
    }

    void drawRing(Canvas canvas, int i3) {
        canvas.save();
        float f16 = this.sRingTranslate;
        canvas.translate(f16, f16);
        canvas.drawArc(this.sRingRectF, 0.0f, 360.0f, false, sRingPaint);
        if (i3 == this.mOnTouchDownPos && this.mAvatarPressEnable) {
            canvas.drawArc(this.sRingRectF, 0.0f, 360.0f, false, sAvatarPressStatePaint);
        }
        canvas.restore();
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getHeight() {
        return this.mHeight;
    }

    int getMaxShowAvatarsCount(int i3, int i16) {
        int i17 = MAX_COLUMN_COUNT;
        return (i17 * 2 == i16 && i17 * 2 == i3) ? i17 * 2 : i3 < i17 * 2 ? i3 : (i17 * 2) - 1;
    }

    public String getReadStr() {
        StringBuilder sb5 = this.f48759sb;
        if (sb5 == null) {
            return "";
        }
        return sb5.toString();
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getWidth() {
        return this.mWidth;
    }

    Drawable loadAvatar(long j3, int i3) {
        String P = com.qzone.adapter.feedcomponent.i.H().P(Long.valueOf(j3));
        return loadAvatar(PictureUrl.calculateAvaterImageUrl(P), P, j3, i3);
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
        int i17;
        int i18;
        int i19 = this.mDrawMode;
        if (i19 == 0) {
            this.mHeight = 0;
            return;
        }
        if (i19 != 1) {
            if (i19 != 2) {
                return;
            }
            this.mHeight = sPraiseIconSize;
            return;
        }
        float size = this.mUsers.size() * 1.0f;
        int i26 = MAX_COLUMN_COUNT;
        int ceil = (int) Math.ceil(size / i26);
        boolean showRingAtEnd = showRingAtEnd();
        if (showRingAtEnd && this.mUsers.size() % i26 == 0 && ceil < 2) {
            ceil++;
        }
        if (ceil <= 2) {
            i17 = this.sAvatarSize * ceil;
            i18 = sAvatarVerticalSpacing * (ceil - 1);
        } else {
            i17 = this.sAvatarSize * 2;
            i18 = sAvatarVerticalSpacing * 1;
        }
        int size2 = this.mUsers.size();
        if (size2 < i26) {
            i26 = showRingAtEnd ? size2 + 1 : size2;
        }
        int i27 = ((this.sAvatarSize * i26) + sFirstAvatarXWithoutPraiseIcon) - (AreaManager.f48752dp3 * (i26 - 1));
        int i28 = this.avatarStrokeSize;
        this.mWidth = i27 + i28;
        this.mHeight = i17 + i18 + (i28 * 2);
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean onTouchEvent(MotionEvent motionEvent, SubAreaShell subAreaShell, boolean z16) {
        if (this.mDrawMode == 0) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            if (this.mDrawMode == 2 && isInViewRect(motionEvent.getY())) {
                return true;
            }
            this.mOnTouchDownPos = -1;
            this.mOnTouchDownX = motionEvent.getX();
            this.mOnTouchDownY = motionEvent.getY();
            int length = this.sAvatarsTouchRects.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (isInTouchRect(this.mOnTouchDownX, this.mOnTouchDownY, i3)) {
                    this.mOnTouchDownPos = i3;
                    invalidate();
                    break;
                }
                i3++;
            }
            int i16 = this.mOnTouchDownPos;
            return i16 != -1 && i16 <= this.mLikeNum;
        }
        if (motionEvent.getAction() == 2) {
            if (this.mDrawMode == 2 && isInViewRect(motionEvent.getY())) {
                return true;
            }
            int i17 = this.mOnTouchDownPos;
            if (i17 != -1 && i17 <= this.mLikeNum) {
                if (isInTouchRect(motionEvent.getX(), motionEvent.getY(), this.mOnTouchDownPos)) {
                    return true;
                }
                clearTouchingEvent();
                return false;
            }
        } else if (motionEvent.getAction() == 1) {
            if (this.mDrawMode == 2 && isInViewRect(motionEvent.getY())) {
                if (subAreaShell != null) {
                    subAreaShell.onAreaClicked(this, null);
                }
                clearTouchingEvent();
                return true;
            }
            int i18 = this.mOnTouchDownPos;
            if (i18 != -1 && i18 <= this.mLikeNum) {
                if (isInTouchRect(motionEvent.getX(), motionEvent.getY(), this.mOnTouchDownPos)) {
                    if (subAreaShell != null) {
                        subAreaShell.onAreaClicked(this, null);
                    }
                    clearTouchingEvent();
                    return true;
                }
                clearTouchingEvent();
                return false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 4) {
            clearTouchingEvent();
        }
        return false;
    }

    public void setAvatarPressEnable(boolean z16) {
        this.mAvatarPressEnable = z16;
    }

    public void setAvatarSize(int i3) {
        this.sAvatarSize = i3;
        this.sAvatarOffsetX = (AreaConst.f48748dp3 * (-1)) + i3;
        this.sAvatarOffsetY = sAvatarVerticalSpacing + i3;
        Drawable drawable = this.DRAWABLE_DEFAULT_AVATAR;
        int i16 = 0;
        if (drawable != null) {
            drawable.setBounds(0, 0, i3, i3);
        }
        int i17 = this.sAvatarSize;
        this.sPraiseIconMarginTopWhileHasAvatars = (i17 - sPraiseIconSize) / 2;
        this.sPraiseIconCenter = i17 / 2;
        float f16 = i17;
        float f17 = f16 - 1.5f;
        this.sRingTranslate = 0.75f;
        this.sRingCenterXY = f16 / 2.0f;
        this.sRingRectF = new RectF(0.0f, 0.0f, f17, f17);
        this.sAvatarCountRingTextCenterX = this.sRingCenterXY;
        int i18 = MAX_COLUMN_COUNT;
        this.sAvatarsTouchRects = new Rect[i18 * 2];
        this.sAvatarsTouchRectsWithoutPraiseIcon = new Rect[i18 * 2];
        while (true) {
            Rect[] rectArr = this.sAvatarsTouchRects;
            if (i16 >= rectArr.length) {
                return;
            }
            int i19 = MARGIN_LEFT + sPraiseIconSize;
            int i26 = MAX_COLUMN_COUNT;
            int i27 = this.sAvatarOffsetX;
            int i28 = i19 + ((i16 % i26) * i27);
            int i29 = this.sAvatarOffsetY;
            int i36 = (i16 / i26) * i29;
            int i37 = i27 + i28;
            int i38 = i29 + i36;
            rectArr[i16] = new Rect(i28, i36, i37, i38);
            int i39 = sFirstAvatarX - sFirstAvatarXWithoutPraiseIcon;
            this.sAvatarsTouchRectsWithoutPraiseIcon[i16] = new Rect(i28 - i39, i36, i37 - i39, i38);
            i16++;
        }
    }

    public void setCustomString(String str, int i3, int i16) {
        this.mCustomMoreString = str;
        mAvatarCustomCountTextColor = i3;
        mAvatarCustomCountTextSize = i16;
        Paint paint = sAvatarCustomCountTextPaint;
        paint.setColor(i3);
        paint.setTextSize((int) FeedGlobalEnv.g().getSpValue(mAvatarCustomCountTextSize));
    }

    public void setShowPraiseIcon(boolean z16) {
        this.mShowPraiseIcon = z16;
    }

    public void setUsers(List<CellLikeInfo.LikeMan> list, int i3) {
        StringBuilder sb5;
        User user;
        StringBuilder sb6;
        if (com.qzone.adapter.feedcomponent.i.H().S0()) {
            StringBuilder sb7 = this.f48759sb;
            if (sb7 == null) {
                this.f48759sb = new StringBuilder();
            } else {
                sb7.delete(0, sb7.length());
            }
        }
        this.mUsers = list;
        if (list == null) {
            this.mUsers = Collections.emptyList();
            this.mLikeNum = 0;
        } else {
            this.mLikeNum = i3;
        }
        List<CellLikeInfo.LikeMan> list2 = this.mUsers;
        calcDrawMode();
        int size = list2.size();
        this.mMaxShowAvatarsCount = getMaxShowAvatarsCount(size, this.mLikeNum);
        this.mAvatarDrawables.clear();
        for (int i16 = 0; i16 < this.mMaxShowAvatarsCount && i16 < size; i16++) {
            Drawable drawable = null;
            try {
                user = list2.get(i16).user;
            } catch (Exception unused) {
                user = null;
            }
            if (user == null) {
                break;
            }
            long j3 = user.uin;
            if (com.qzone.adapter.feedcomponent.i.H().S0() && (sb6 = this.f48759sb) != null) {
                sb6.append("," + user.nickName);
            }
            int i17 = user.from;
            if (i17 == 0 || i17 == 1) {
                if (j3 > 0) {
                    drawable = loadAvatar(j3, user.superLike);
                }
            } else if (i17 == 2) {
                drawable = loadAvatar(user.logoImageUrl, user.logo, j3 == 0 ? generateAvatarKey() : j3, user.superLike);
            } else if (i17 == 4) {
                drawable = loadAvatar(user.logoImageUrl, user.logo, j3 == 0 ? generateAvatarKey() : j3, user.superLike);
            }
            if (drawable == null) {
                drawable = this.DRAWABLE_DEFAULT_AVATAR;
            }
            this.mAvatarDrawables.put(com.qzone.adapter.feedcomponent.i.H().P(Long.valueOf(j3)), drawable);
        }
        if (!com.qzone.adapter.feedcomponent.i.H().S0() || (sb5 = this.f48759sb) == null) {
            return;
        }
        sb5.append("\u7b49" + this.mLikeNum + "\u4eba\u5df2\u8d5e");
    }

    boolean showRingAtEnd() {
        return this.mLikeNum > this.mMaxShowAvatarsCount && this.mCustomMoreString == null;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea, com.qzone.module.feedcomponent.ui.ViewArea
    public p getData() {
        int i3 = this.mDrawMode;
        if (i3 != 1) {
            if (i3 == 2) {
                return new p(this.mUsers, this.mLikeNum, -1, true);
            }
            return null;
        }
        if (showRingAtEnd() && this.mOnTouchDownPos == this.mMaxShowAvatarsCount) {
            return new p(this.mUsers, this.mLikeNum, -1, true);
        }
        return new p(this.mUsers, this.mLikeNum, this.mOnTouchDownPos, false);
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void clearTouchingEvent() {
        this.mOnTouchDownX = -1.0f;
        this.mOnTouchDownY = -1.0f;
        this.mOnTouchDownPos = -1;
        invalidate();
    }

    Drawable loadAvatar(ImageUrl imageUrl, String str, long j3, int i3) {
        ImageProcessor imageProcessor;
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        if (i3 == 1) {
            imageProcessor = mSuperLikeProcessor;
        } else {
            imageProcessor = OVAL_PROCESSOR;
        }
        obtain.extraProcessor = imageProcessor;
        int i16 = this.sAvatarSize;
        obtain.clipHeight = i16;
        obtain.clipWidth = i16;
        return ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, this.mImageLoadListener, obtain);
    }

    boolean isInTouchRect(float f16, float f17, int i3) {
        Rect rect;
        if (i3 < 0) {
            return false;
        }
        Rect[] rectArr = this.sAvatarsTouchRects;
        if (i3 > rectArr.length) {
            return false;
        }
        if (this.mShowPraiseIcon) {
            rect = rectArr[i3];
        } else {
            rect = this.sAvatarsTouchRectsWithoutPraiseIcon[i3];
        }
        return rect != null && rect.contains((int) f16, (int) f17);
    }

    void drawAvatarList(Canvas canvas) {
        this.mAvatarRowCache.clear();
        boolean showRingAtEnd = showRingAtEnd();
        int i3 = 0;
        int i16 = 0;
        for (Drawable drawable : this.mAvatarDrawables.values()) {
            boolean z16 = i3 != 0 && (i3 + 1) % MAX_COLUMN_COUNT == 0;
            boolean z17 = i3 == this.mMaxShowAvatarsCount - 1;
            int i17 = this.sAvatarSize;
            drawable.setBounds(0, 0, i17, i17);
            this.mAvatarRowCache.add(drawable);
            if (z16 || z17) {
                int i18 = MAX_COLUMN_COUNT;
                int i19 = i16 * i18;
                boolean z18 = z17 && showRingAtEnd && this.mAvatarRowCache.size() < i18;
                boolean z19 = z17 && showRingAtEnd && this.mAvatarRowCache.size() == i18;
                drawAvatarRow(canvas, this.mAvatarRowCache, i19, this.sAvatarOffsetX, z18);
                if (z19) {
                    canvas.save();
                    canvas.translate(0.0f, this.sAvatarOffsetY);
                    drawAndAvatarCountTextWithRing(canvas, i19);
                    canvas.restore();
                    this.mAvatarRowCache.clear();
                    return;
                }
                i16++;
                this.mAvatarRowCache.clear();
                if (z16 && !z17) {
                    canvas.translate(0.0f, this.sAvatarOffsetY);
                }
            }
            i3++;
        }
    }

    boolean isInViewRect(float f16) {
        return 0.0f < f16 && f16 < ((float) this.mHeight);
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
    }
}
