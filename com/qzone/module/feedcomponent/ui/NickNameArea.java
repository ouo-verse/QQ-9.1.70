package com.qzone.module.feedcomponent.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.CellTheme;
import com.qzone.proxy.feedcomponent.model.User;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class NickNameArea extends FeedTextArea {
    static final int DEFAULT_SPACE;
    static PorterDuffXfermode FLASH_FERMODE = null;
    static final int IDLE_MSG_TYPE = 1;
    static Bitmap MASK_BITMAP = null;
    static Paint MASK_PAINT = null;
    static Drawable NICKNAME_FLASH = null;
    static Drawable NICKNAME_LOVE_VIP_FLASH = null;
    static Drawable NICKNAME_TEN_VIP_FLASH = null;
    static final String TAG = "NickNameArea";
    static final float TEXT_SIZE;
    static int mMaxFlashCount = 2;
    Drawable CURRENT_NICKNAME_FLASH;
    private String flag;
    boolean mAvatarDoingAnim;
    CellTheme mCellTheme;
    int mFlashCount;
    StaticHandler mHandler;
    boolean mIsStartScroll;
    boolean mNicknameFlash;
    Scroller mScroller;
    int mSubLen;
    int mTextWidth;
    User mUser;
    public int oldHeightMeasureSpec;
    public int oldWidthMeasureSpec;
    Bitmap tenMaskBitmap;

    public NickNameArea(String str) {
        super(str.equals("3") ? Integer.MAX_VALUE : 16);
        this.mNicknameFlash = true;
        this.mHandler = new StaticHandler(Looper.getMainLooper(), this);
        this.flag = str;
        setFlashCount(com.qzone.adapter.feedcomponent.h.b("QZoneSetting", "FeedNickNameSplashCount", 2));
    }

    private int getLeftOffset() {
        int i3;
        if (this.flag.equals("3")) {
            i3 = this.mTextWidth;
        } else {
            i3 = this.mHeight;
        }
        return (int) (((this.mScroller.getCurrX() / this.mTextWidth) * (r2 + i3)) - i3);
    }

    public static int px2dip(float f16) {
        return (int) ((f16 / FeedGlobalEnv.g().getDensity()) + 0.5f);
    }

    public static synchronized void setFlashCount(int i3) {
        synchronized (NickNameArea.class) {
            mMaxFlashCount = i3;
        }
    }

    public static synchronized void setMaxFlashCount(int i3) {
        synchronized (NickNameArea.class) {
            mMaxFlashCount = i3;
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        Scroller scroller;
        boolean draw = super.draw(canvas, paint);
        if (!this.mAvatarDoingAnim && this.mNicknameFlash && (scroller = this.mScroller) != null && scroller.computeScrollOffset()) {
            canvas.saveLayerAlpha(0.0f, 0.0f, this.mTextWidth, this.mHeight, 255);
            super.draw(canvas, paint);
            if (this.flag.equals("3")) {
                Bitmap bitmap = this.tenMaskBitmap;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, getLeftOffset(), 0.0f, MASK_PAINT);
                }
            } else {
                Bitmap bitmap2 = MASK_BITMAP;
                if (bitmap2 != null) {
                    canvas.drawBitmap(bitmap2, getLeftOffset(), 0.0f, MASK_PAINT);
                }
            }
            canvas.restore();
            postInvalidateAll();
        } else if (this.mIsStartScroll) {
            if (this.mFlashCount > 0 && !this.mAvatarDoingAnim) {
                this.mHandler.sendEmptyMessageDelayed(1, 200L);
            } else {
                this.mNicknameFlash = false;
            }
        }
        return draw;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea, com.qzone.module.feedcomponent.ui.ViewArea
    public Object getData() {
        return this.mUser;
    }

    public void initShadow() {
        Canvas canvas;
        if (this.mTextWidth == 0) {
            return;
        }
        if (MASK_BITMAP == null || this.tenMaskBitmap == null) {
            if (this.mHeight <= 0) {
                this.mHeight = com.qzone.adapter.feedcomponent.b.f41860g;
            }
            if (this.flag.equals("3")) {
                this.tenMaskBitmap = Bitmap.createBitmap(this.mTextWidth, this.mHeight, Bitmap.Config.ARGB_8888);
            } else {
                int i3 = this.mHeight;
                MASK_BITMAP = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
            }
        }
        if (this.CURRENT_NICKNAME_FLASH != null) {
            if (this.flag.equals("3")) {
                canvas = new Canvas(this.tenMaskBitmap);
                this.CURRENT_NICKNAME_FLASH.setBounds(0, 0, this.mTextWidth, this.mHeight);
            } else {
                canvas = new Canvas(MASK_BITMAP);
                Drawable drawable = this.CURRENT_NICKNAME_FLASH;
                int i16 = this.mHeight;
                drawable.setBounds(0, 0, i16, i16);
            }
            this.CURRENT_NICKNAME_FLASH.draw(canvas);
        }
        if (MASK_PAINT == null) {
            Paint paint = new Paint();
            MASK_PAINT = paint;
            paint.setXfermode(FLASH_FERMODE);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
        View.MeasureSpec.getMode(i3);
        View.MeasureSpec.getSize(i3);
        super.measure(i3, i16);
        this.mTextWidth = getMeasuredWidth();
        this.mHeight = Math.max(this.mHeight, com.qzone.adapter.feedcomponent.b.f41860g);
        this.oldWidthMeasureSpec = i3;
        this.oldHeightMeasureSpec = i16;
    }

    public void onStateIdle() {
        this.mFlashCount = mMaxFlashCount;
        this.mHandler.sendEmptyMessageDelayed(1, 200L);
    }

    public void setAvatarRedPocketAnimState(boolean z16) {
        this.mAvatarDoingAnim = z16;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextArea, com.qzone.module.feedcomponent.ui.SubArea, com.qzone.module.feedcomponent.ui.ViewArea
    public void setMaxWidth(int i3) {
        super.setMaxWidth(i3);
    }

    public void setNickNameFlash(boolean z16) {
        Scroller scroller;
        this.mNicknameFlash = z16;
        this.mIsStartScroll = false;
        if (z16 || (scroller = this.mScroller) == null) {
            return;
        }
        scroller.forceFinished(true);
    }

    public void setTheme(CellTheme cellTheme, String str) {
        this.mCellTheme = cellTheme;
        User user = this.mUser;
        if (user == null) {
            return;
        }
        if (user.vip > 0 && !str.equals("0")) {
            if (str.equals("2")) {
                super.setTextColor(AreaManager.loveVipColor);
                return;
            } else {
                if (str.equals("1")) {
                    super.setTextColor(AreaManager.vipColor);
                    return;
                }
                return;
            }
        }
        CellTheme cellTheme2 = this.mCellTheme;
        if (cellTheme2 != null) {
            super.setTextColor(cellTheme2.majorForeColor);
        } else {
            super.setTextColor(com.qzone.adapter.feedcomponent.j.o());
        }
    }

    public void setUser(User user, String str) {
        this.mUser = user;
        super.setMaxLine(1);
        super.setTextBold(false);
        super.setTextSizeInSp(TEXT_SIZE);
        if (this.mUser.vip > 0 && !str.equals("0")) {
            if (this.flag.equals("3")) {
                this.CURRENT_NICKNAME_FLASH = NICKNAME_TEN_VIP_FLASH;
            } else if (this.flag.equals("2")) {
                this.CURRENT_NICKNAME_FLASH = NICKNAME_LOVE_VIP_FLASH;
                super.setTextColor(AreaManager.loveVipColor);
            } else {
                this.CURRENT_NICKNAME_FLASH = NICKNAME_FLASH;
                super.setTextColor(AreaManager.vipColor);
            }
        } else {
            CellTheme cellTheme = this.mCellTheme;
            if (cellTheme != null) {
                super.setTextColor(cellTheme.majorForeColor);
            } else {
                super.setTextColor(com.qzone.adapter.feedcomponent.j.o());
            }
        }
        setPlainText(user.nickName);
        setLongclickable(false);
        setHasPressState(true);
    }

    void startScroll() {
        int i3 = this.mFlashCount;
        if (i3 == 0) {
            return;
        }
        if (MASK_BITMAP == null && this.tenMaskBitmap == null) {
            return;
        }
        this.mFlashCount = i3 - 1;
        if (this.mScroller == null) {
            this.mScroller = new Scroller(FeedGlobalEnv.getContext(), new LinearInterpolator());
        }
        this.mScroller.forceFinished(true);
        Scroller scroller = this.mScroller;
        int i16 = this.mTextWidth;
        scroller.startScroll(0, 0, i16, 0, px2dip(i16) * 17);
        this.mIsStartScroll = true;
    }

    public void reset() {
        this.mAvatarDoingAnim = false;
        clearClickListener();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class StaticHandler extends Handler {
        WeakReference<NickNameArea> mThisView;

        public StaticHandler(Looper looper, NickNameArea nickNameArea) {
            super(looper);
            this.mThisView = null;
            this.mThisView = new WeakReference<>(nickNameArea);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<NickNameArea> weakReference;
            NickNameArea nickNameArea;
            if (!com.qzone.adapter.feedcomponent.i.H().g1() || (weakReference = this.mThisView) == null || message == null || (nickNameArea = weakReference.get()) == null || message.what != 1) {
                return;
            }
            NickNameArea.onStateIdle(nickNameArea);
        }

        public StaticHandler(NickNameArea nickNameArea) {
            this.mThisView = null;
            this.mThisView = new WeakReference<>(nickNameArea);
        }
    }

    static {
        try {
            NICKNAME_FLASH = com.qzone.adapter.feedcomponent.j.g(com.tencent.luggage.wxa.c3.f.CTRL_INDEX);
            NICKNAME_LOVE_VIP_FLASH = com.qzone.adapter.feedcomponent.j.g(981);
            NICKNAME_TEN_VIP_FLASH = com.qzone.adapter.feedcomponent.j.g(982);
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.d(TAG, "", e16);
        }
        DEFAULT_SPACE = (int) (FeedGlobalEnv.g().getDensity() * 8.0f);
        TEXT_SIZE = com.qzone.adapter.feedcomponent.j.e(276);
        FLASH_FERMODE = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    static void onStateIdle(NickNameArea nickNameArea) {
        if (nickNameArea.mNicknameFlash) {
            Scroller scroller = nickNameArea.mScroller;
            if (scroller == null || !scroller.computeScrollOffset()) {
                nickNameArea.startScroll();
                nickNameArea.postInvalidateAll();
            }
        }
    }
}
