package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoCoverOpenTrafficText;
import com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class BaseVideoCover extends View implements Recycleable {
    public static final String LOG_TAG = "AutoVideoCover";
    public static final int MSG_REFRESH_LOADING = 1;
    private static int globalUniNum = 1;
    protected int HEIGHT_COUNT;
    public int URL_STATE_LOAD_IMAGE_ING;
    protected int WIDTH_COUNT;
    int actionCharWidth;
    public Drawable actionIcon;
    protected String coverErrorMsg;
    protected final PicListener downloadListener;
    public Drawable erroIcon;
    public Drawable freeTrafficPlayIconBg;
    public Drawable freeTrafficPlayIconButton;
    public String freeTrafficText;
    protected volatile boolean hasDrawingTask;
    protected boolean isLandscape;
    public boolean isVideoStored;
    public int loadFailedTextId;
    protected int mCoverHeight;
    protected int mCoverIconSpac;
    protected View mCoverRelatView;
    protected int mCoverWidth;
    protected Handler mHandler;
    private boolean mIsJustShowReplayIcon;
    private boolean mIsLikeFriendVideo;
    private boolean mIsNetworkDisconnect;
    private boolean mIsVideoPicMixMode;
    private int mLikeFriendVideoCoverHeight;
    private int mLikeFriendVideoCoverWidth;
    protected int mMaxWidth;
    public Drawable mOpenFreeTrafficBg;
    protected int mOpenFreeTrafficNormalTextWidth;
    protected VideoCoverOpenTrafficText mOpenFreeTrafficText;
    protected int mOpenFreeTrafficUnderLineTextWidth;
    protected BaseVideo mParent;
    protected boolean mShowOpenFreeTraffic;
    protected int mUni;
    protected HashMap<String, b> mUrlStateHash;
    public TextView mVideoDescText;
    private int mVideoPicMixModeClipSize;
    public CoverWarnType mWarnType;
    protected int percent;
    protected int picHeight;
    protected int picWidth;
    public Drawable playIcon;
    protected ImageUrl preImgUrl;
    protected ImageLoader.Options preOpt;
    protected String preUrl;
    protected Rect rectLoadingFrome;
    protected Rect rectLoadingTo;
    public Drawable retryIcon;
    public boolean showPlayIcon;
    protected Drawable singleDrawable;
    protected boolean storeIconClicked;
    protected String timeDes;
    public Drawable videoBgBottom;
    public Drawable videoBgTop;
    protected VideoPlayInfo videoPlayInfo;
    int warnCharWidth;
    public Drawable warnIcon;
    protected static HashMap<String, Boolean> sPlayOnWifiMap = new HashMap<>();
    protected static int PLAY_ON_WIFI_REPORT_EXPOSE = 1;
    protected static int PLAY_ON_WIFI_REPORT_CLICK = 2;
    private static final ColorDrawable BLACK_DRAWBLE = new ColorDrawable(Color.parseColor("#000000"));

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public enum CoverWarnType {
        DEFAULT,
        NETWORK_DISCONNECT,
        NETWORK_CHANGE
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            BaseVideoCover.this.invalidate();
            BaseVideoCover.this.hasDrawingTask = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        int f279593a = 0;

        /* renamed from: b, reason: collision with root package name */
        ImageLoader.Options f279594b = null;

        /* renamed from: c, reason: collision with root package name */
        String f279595c = null;

        public b() {
        }
    }

    public BaseVideoCover(Context context, BaseVideo baseVideo) {
        this(context, null, baseVideo);
    }

    public static HashMap<String, Boolean> getPlayOnWifiMap() {
        return sPlayOnWifiMap;
    }

    protected static int getUniNum() {
        int i3 = globalUniNum + 1;
        globalUniNum = i3;
        return i3;
    }

    private void initLoadingPxData() {
        if (this.HEIGHT_COUNT == -1) {
            Bitmap bitmap = FeedVideoEnv.bitmapDst;
            if (bitmap != null) {
                this.HEIGHT_COUNT = bitmap.getHeight();
            } else {
                this.HEIGHT_COUNT = 0;
            }
        }
        if (this.WIDTH_COUNT == -1) {
            Bitmap bitmap2 = FeedVideoEnv.bitmapDst;
            if (bitmap2 != null) {
                this.WIDTH_COUNT = bitmap2.getWidth();
            } else {
                this.WIDTH_COUNT = 0;
            }
        }
    }

    protected void drawComplete(Canvas canvas) {
        this.mHandler.removeMessages(1);
        this.hasDrawingTask = false;
        VideoPlayInfo videoPlayInfo = this.videoPlayInfo;
        String string = FeedVideoEnv.feedResources.getString((videoPlayInfo == null || !videoPlayInfo.k()) ? 1368 : 1366);
        VideoPlayInfo videoPlayInfo2 = this.videoPlayInfo;
        String string2 = FeedVideoEnv.feedResources.getString((videoPlayInfo2 == null || !videoPlayInfo2.k()) ? 1369 : 1367);
        FeedVideoEnv.getCompleteTaskDrawable().setBounds(0, this.mCoverHeight - FeedVideoEnv.dpToPx(39.0f), this.mCoverWidth, this.mCoverHeight);
        FeedVideoEnv.getCompleteTaskDrawable().draw(canvas);
        int dpToPx = FeedVideoEnv.dpToPx(13.0f);
        int dpToPx2 = FeedVideoEnv.dpToPx(12.0f);
        int dpToPx3 = FeedVideoEnv.dpToPx(8.0f);
        int dpToPx4 = FeedVideoEnv.dpToPx(12.0f);
        int dpToPx5 = ((((this.mCoverWidth / 2) - dpToPx) - FeedVideoEnv.dp8) - FeedVideoEnv.dpToPx(33.0f)) - (FeedVideoEnv.getAdvCharWidth() * 4);
        int dpToPx6 = this.mCoverHeight - ((FeedVideoEnv.dpToPx(39.0f) + dpToPx2) / 2);
        FeedVideoEnv.getReplayBtnNew().setBounds(dpToPx5, dpToPx6, dpToPx5 + dpToPx, dpToPx2 + dpToPx6);
        FeedVideoEnv.getReplayBtnNew().draw(canvas);
        canvas.drawText(string2, dpToPx5 + FeedVideoEnv.dp8 + dpToPx, (this.mCoverHeight - FeedVideoEnv.dpToPx(39.0f)) + FeedVideoEnv.ADV_ACTION_TEXT_PADDING_TOP_12, FeedVideoEnv.advActionTextPaint_12);
        int dpToPx7 = (this.mCoverWidth / 2) + FeedVideoEnv.dpToPx(33.0f);
        FeedVideoEnv.getMoreBtnNew().setBounds(dpToPx7, dpToPx6, dpToPx7 + dpToPx3, dpToPx4 + dpToPx6);
        FeedVideoEnv.getMoreBtnNew().draw(canvas);
        canvas.drawText(string, dpToPx7 + FeedVideoEnv.dpToPx(11.0f) + dpToPx3, (this.mCoverHeight - FeedVideoEnv.dpToPx(39.0f)) + FeedVideoEnv.ADV_ACTION_TEXT_PADDING_TOP_12, FeedVideoEnv.advActionTextPaint_12);
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(FeedVideoEnv.f279794dp1);
        int i3 = (this.mCoverWidth - FeedVideoEnv.f279794dp1) / 2;
        float f16 = i3;
        canvas.drawLine(f16, this.mCoverHeight - ((FeedVideoEnv.dpToPx(39.0f) + FeedVideoEnv.dpToPx(11.0f)) / 2), f16, r1 + FeedVideoEnv.dpToPx(11.0f), paint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawCover(Canvas canvas) {
        if (this.singleDrawable == null) {
            PlayerUtils.log(5, LOG_TAG, "drawCover singleDrawable is null");
            return;
        }
        if (this.mIsLikeFriendVideo) {
            canvas.save();
            ColorDrawable colorDrawable = BLACK_DRAWBLE;
            colorDrawable.setBounds(0, 0, this.mCoverWidth, this.mCoverHeight);
            colorDrawable.draw(canvas);
            canvas.translate((this.mCoverWidth - this.mLikeFriendVideoCoverWidth) / 2, (this.mCoverHeight - this.mLikeFriendVideoCoverHeight) / 2);
            Drawable drawable = this.singleDrawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, this.mLikeFriendVideoCoverWidth, this.mLikeFriendVideoCoverHeight);
                this.singleDrawable.draw(canvas);
            }
            canvas.restore();
        } else {
            synchronized (this) {
                Drawable drawable2 = this.singleDrawable;
                if (drawable2 != null && canvas != null) {
                    drawable2.setBounds(0, 0, this.mCoverWidth, this.mCoverHeight);
                    this.singleDrawable.draw(canvas);
                }
            }
        }
        if (com.qzone.util.image.d.f(this.coverErrorMsg)) {
            if (com.qzone.util.image.d.g(this.coverErrorMsg)) {
                String j3 = com.qzone.util.image.d.j(this.coverErrorMsg);
                if (TextUtils.isEmpty(j3)) {
                    return;
                }
                int i3 = this.mCoverHeight;
                com.qzone.util.image.d.a(canvas, j3, i3, i3, 0);
                return;
            }
            com.qzone.util.image.d.b(canvas, this.mCoverWidth, this.mCoverHeight, this.coverErrorMsg, 0);
        }
    }

    protected void drawFreeTrafficPlayIcon(Canvas canvas) {
        FeedVideoEnv.externalFunc.reportClick("8", ThemeReporter.FROM_NIGHT_ROAMING, "1");
        if (this.freeTrafficPlayIconBg != null && this.freeTrafficPlayIconButton != null && this.playIcon != null) {
            boolean z16 = this.mIsVideoPicMixMode;
            if (z16) {
                int dpToPx = FeedVideoEnv.dpToPx(40.0f);
                Drawable drawable = this.playIcon;
                int i3 = this.picWidth;
                int i16 = this.picHeight;
                drawable.setBounds((i3 - dpToPx) / 2, (i16 - dpToPx) / 2, (i3 + dpToPx) / 2, (i16 + dpToPx) / 2);
                this.playIcon.draw(canvas);
                return;
            }
            if (!z16 && this.picWidth < FeedVideoEnv.getScreenWidth() / 2) {
                int dpToPx2 = FeedVideoEnv.dpToPx(60.0f);
                Drawable drawable2 = this.playIcon;
                int i17 = this.picWidth;
                int i18 = this.picHeight;
                drawable2.setBounds((i17 - dpToPx2) / 2, (i18 - dpToPx2) / 2, (i17 + dpToPx2) / 2, (i18 + dpToPx2) / 2);
                this.playIcon.draw(canvas);
                return;
            }
            int dpToPx3 = FeedVideoEnv.dpToPx(132.0f);
            int dpToPx4 = FeedVideoEnv.dpToPx(44.0f);
            int i19 = (this.picWidth - dpToPx3) / 2;
            int i26 = (this.picHeight - dpToPx4) / 2;
            int dpToPx5 = FeedVideoEnv.dpToPx(17.0f);
            int dpToPx6 = FeedVideoEnv.dpToPx(16.0f);
            this.freeTrafficPlayIconBg.setBounds(i19, i26, (this.picWidth + dpToPx3) / 2, (this.picHeight + dpToPx4) / 2);
            this.freeTrafficPlayIconBg.draw(canvas);
            this.freeTrafficPlayIconButton.setBounds(FeedVideoEnv.dpToPx(18.0f) + i19, FeedVideoEnv.dpToPx(14.0f) + i26, FeedVideoEnv.dpToPx(14.0f) + i19 + dpToPx5, FeedVideoEnv.dpToPx(14.0f) + i26 + dpToPx6);
            this.freeTrafficPlayIconButton.draw(canvas);
            canvas.drawText(this.freeTrafficText, i19 + FeedVideoEnv.dpToPx(35.0f), i26 + FeedVideoEnv.dpToPx(28.0f), FeedVideoEnv.videoFreeTrafficPaint);
            return;
        }
        PlayerUtils.log(5, LOG_TAG, "Error! play icon is null");
    }

    protected void drawLoadingIcon(Canvas canvas) {
        initLoadingPxData();
        if (FeedVideoEnv.bitmapDst != null && FeedVideoEnv.bitmapSrc != null) {
            canvas.drawBitmap(FeedVideoEnv.bitmapDst, (this.mCoverWidth - this.WIDTH_COUNT) / 2, (this.mCoverHeight - this.HEIGHT_COUNT) / 2, FeedVideoEnv.sPaint);
            this.rectLoadingFrome.set(0, 0, this.percent, this.HEIGHT_COUNT);
            Rect rect = this.rectLoadingTo;
            int i3 = this.mCoverWidth;
            int i16 = this.WIDTH_COUNT;
            int i17 = this.mCoverHeight;
            int i18 = this.HEIGHT_COUNT;
            rect.set((i3 - i16) / 2, (i17 - i18) / 2, ((i3 - i16) / 2) + this.percent, (i17 + i18) / 2);
            canvas.drawBitmap(FeedVideoEnv.bitmapSrc, this.rectLoadingFrome, this.rectLoadingTo, FeedVideoEnv.sPaint);
            return;
        }
        PlayerUtils.log(5, LOG_TAG, "drawLoadingIcon: bitmap is null!!!");
    }

    protected void drawOpenFreeTraffic(Canvas canvas) {
        VideoPlayInfo videoPlayInfo = this.videoPlayInfo;
        if (videoPlayInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(videoPlayInfo.openFreeTrafficText) && !TextUtils.isEmpty(this.videoPlayInfo.openFreeTrafficJumpUrl)) {
            VideoCoverOpenTrafficText videoCoverOpenTrafficText = this.mOpenFreeTrafficText;
            if (videoCoverOpenTrafficText == null || !videoCoverOpenTrafficText.isValid() || this.picWidth < FeedVideoEnv.getScreenWidth() / 2) {
                return;
            }
            this.mOpenFreeTrafficNormalTextWidth = (int) FeedVideoEnv.videoOpenFreeTrafficPaint.measureText(this.mOpenFreeTrafficText.mNormalText);
            this.mOpenFreeTrafficUnderLineTextWidth = (int) FeedVideoEnv.videoOpenFreeTrafficPaint.measureText(this.mOpenFreeTrafficText.mUnderLineText);
            canvas.drawColor(Color.argb(51, 0, 0, 0));
            int i3 = (this.picHeight / 2) + FeedVideoEnv.dp48;
            int i16 = (((this.picWidth - this.mOpenFreeTrafficNormalTextWidth) - this.mOpenFreeTrafficUnderLineTextWidth) / 2) + FeedVideoEnv.f279794dp1;
            FeedVideoEnv.videoOpenFreeTrafficPaint.setAlpha(255);
            canvas.drawText(this.mOpenFreeTrafficText.mUnderLineText, i16, i3 + FeedVideoEnv.dp5, FeedVideoEnv.videoOpenFreeTrafficPaint);
            return;
        }
        PlayerUtils.log(5, LOG_TAG, "drawOpenFreeTrafficTip Error! bg is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawPlayIcon(Canvas canvas) {
        if (this.playIcon == null) {
            PlayerUtils.log(5, LOG_TAG, "Error! play icon is null");
            return;
        }
        if (this.mIsVideoPicMixMode) {
            int dpToPx = FeedVideoEnv.dpToPx(40.0f);
            Drawable drawable = this.playIcon;
            int i3 = this.picWidth;
            int i16 = this.picHeight;
            drawable.setBounds((i3 - dpToPx) / 2, (i16 - dpToPx) / 2, (i3 + dpToPx) / 2, (i16 + dpToPx) / 2);
        } else {
            int dpToPx2 = FeedVideoEnv.dpToPx(60.0f);
            Drawable drawable2 = this.playIcon;
            int i17 = this.picWidth;
            int i18 = this.picHeight;
            drawable2.setBounds((i17 - dpToPx2) / 2, (i18 - dpToPx2) / 2, (i17 + dpToPx2) / 2, (i18 + dpToPx2) / 2);
        }
        this.playIcon.draw(canvas);
    }

    protected void drawVideoInfo(Canvas canvas) {
        int i3;
        int i16;
        if (this.videoPlayInfo == null) {
            PlayerUtils.log(5, LOG_TAG, "drawCover videoPlayInfo is null");
            return;
        }
        this.videoBgTop.setBounds(0, 0, this.mCoverWidth, FeedVideoEnv.dpToPx(80.0f));
        this.videoBgTop.draw(canvas);
        this.videoBgBottom.setBounds(0, this.mCoverHeight - FeedVideoEnv.dpToPx(34.0f), this.mCoverWidth, this.mCoverHeight);
        this.videoBgTop.draw(canvas);
        String str = this.videoPlayInfo.videoDesc;
        if (TextUtils.isEmpty(str)) {
            i3 = 0;
            i16 = 0;
        } else {
            int measureText = (int) FeedVideoEnv.videoDescTextPaint.measureText(str);
            i3 = FeedVideoEnv.dpToPx(12.0f);
            i16 = FeedVideoEnv.dpToPx(28.0f);
            if (measureText > this.mCoverWidth - (FeedVideoEnv.dpToPx(12.0f) * 2)) {
                str = str.substring(0, ((this.mCoverWidth - (FeedVideoEnv.dpToPx(12.0f) * 2)) / FeedVideoEnv.getVideoDescCharWidth()) - 2) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            canvas.drawText(str, i3, i16, FeedVideoEnv.videoDescTextPaint);
        }
        VideoPlayInfo videoPlayInfo = this.videoPlayInfo;
        if (videoPlayInfo.playCount > 0 && videoPlayInfo.orgwebsite == 1) {
            canvas.drawText("\u64ad\u653e" + convertNum(this.videoPlayInfo.playCount, false), i3, i16 + FeedVideoEnv.dpToPx(22.0f), FeedVideoEnv.videoPlayCountTextPaint);
        }
        if (TextUtils.isEmpty(this.videoPlayInfo.showVideoTime)) {
            return;
        }
        canvas.drawText(this.videoPlayInfo.showVideoTime, (this.mCoverWidth - FeedVideoEnv.dpToPx(12.0f)) - ((int) FeedVideoEnv.videoDurationTimePaint.measureText(r0)), this.mCoverHeight - FeedVideoEnv.dpToPx(10.0f), FeedVideoEnv.videoDurationTimePaint);
    }

    protected int getCornerRadius() {
        return 0;
    }

    protected Drawable getDefaultDrawable() {
        return FeedVideoEnv.DEFAULT_BACKGROUND;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getMaxWidth() {
        int i3;
        if (useBigPhotoMode() && FeedVideoEnv.externalFunc.isPicBigMode()) {
            i3 = FeedVideoEnv.SCREEN_WIDTH;
        } else {
            i3 = FeedVideoEnv.DEFAULT_WIDTH;
        }
        int i16 = this.mMaxWidth;
        return i16 == 0 ? i3 : i16;
    }

    public int getPicHeight() {
        return this.picHeight;
    }

    public int getPicWidth() {
        return this.picWidth;
    }

    protected boolean isActionArea(float f16, float f17) {
        int i3 = ((this.mCoverWidth - FeedVideoEnv.ERROR_ICON_WIDTH) - FeedVideoEnv.dp6) - (FeedVideoEnv.dp15 * 2);
        int i16 = this.actionCharWidth;
        int i17 = (i3 - i16) / 2;
        int i18 = ((((this.mCoverHeight - FeedVideoEnv.ERROR_ICON_HEIGTH) - FeedVideoEnv.dp33) - FeedVideoEnv.dp20) / 2) + FeedVideoEnv.ERROR_ICON_WIDTH + FeedVideoEnv.dp20;
        return f16 > ((float) i17) && f16 < ((float) (((((i17 + FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH) + FeedVideoEnv.ERROR_ICON_WIDTH) + FeedVideoEnv.dp6) + (FeedVideoEnv.dp15 * 2)) + i16)) && f17 > ((float) i18) && f17 < ((float) (i18 + FeedVideoEnv.dp33));
    }

    protected boolean isInBottomLeftArea(float f16, float f17) {
        int dpToPx = ((((this.mCoverWidth / 2) - FeedVideoEnv.dpToPx(13.0f)) - FeedVideoEnv.dp8) - FeedVideoEnv.dpToPx(33.0f)) - (FeedVideoEnv.getAdvCharWidth() * 4);
        int dpToPx2 = this.mCoverHeight - ((FeedVideoEnv.dpToPx(39.0f) + FeedVideoEnv.dpToPx(12.0f)) / 2);
        return f16 > ((float) dpToPx) && f16 < ((float) (((((dpToPx + dpToPx) + FeedVideoEnv.ERROR_ICON_WIDTH) + FeedVideoEnv.dp6) + (FeedVideoEnv.dp15 * 2)) + (FeedVideoEnv.getAdvCharWidth() * 4))) && f17 > ((float) dpToPx2) && f17 < ((float) (dpToPx2 + FeedVideoEnv.dp35));
    }

    protected boolean isInFloatMore(float f16, float f17) {
        int i3;
        if (this.isLandscape) {
            int i16 = this.mCoverWidth;
            int i17 = FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH;
            int i18 = this.mCoverIconSpac;
            i3 = (((i16 - (i17 * 2)) - (i18 * 1)) / 2) + i17 + i18;
        } else {
            int i19 = this.mCoverWidth;
            int i26 = FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH;
            int i27 = this.mCoverIconSpac;
            i3 = (((i19 - (i26 * 3)) - (i27 * 2)) / 2) + ((i26 + i27) * 2);
        }
        int floatCharWidth = (((this.mCoverHeight - FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH) - FeedVideoEnv.dp10) - FeedVideoEnv.getFloatCharWidth()) / 2;
        return f16 > ((float) i3) && f16 < ((float) (i3 + FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH)) && f17 > ((float) floatCharWidth) && f17 < ((float) ((floatCharWidth + FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH) + FeedVideoEnv.dp15));
    }

    protected boolean isInFloatRedpocket(float f16, float f17) {
        int i3 = this.mCoverWidth;
        int i16 = FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH;
        int i17 = this.mCoverIconSpac;
        int i18 = (((i3 - (i16 * 3)) - (i17 * 2)) / 2) + i16 + i17;
        int floatCharWidth = (((this.mCoverHeight - FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH) - FeedVideoEnv.dp10) - FeedVideoEnv.getFloatCharWidth()) / 2;
        return f16 > ((float) i18) && f16 < ((float) (i18 + FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH)) && f17 > ((float) floatCharWidth) && f17 < ((float) ((floatCharWidth + FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH) + FeedVideoEnv.dp15));
    }

    protected boolean isInFloatReplay(float f16, float f17) {
        int i3;
        if (this.isLandscape) {
            i3 = ((this.mCoverWidth - (FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH * 2)) - this.mCoverIconSpac) / 2;
        } else if (this.mIsJustShowReplayIcon) {
            i3 = (this.mCoverWidth - FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH) / 2;
        } else {
            i3 = ((this.mCoverWidth - (FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH * 3)) - (this.mCoverIconSpac * 2)) / 2;
        }
        int floatCharWidth = (((this.mCoverHeight - FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH) - FeedVideoEnv.dp10) - FeedVideoEnv.getFloatCharWidth()) / 2;
        return f16 > ((float) i3) && f16 < ((float) (i3 + FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH)) && f17 > ((float) floatCharWidth) && f17 < ((float) ((floatCharWidth + FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH) + FeedVideoEnv.dp15));
    }

    protected boolean isInGetMoreArea(float f16, float f17) {
        int advCharWidth = (((this.mCoverWidth - FeedVideoEnv.ADVERTISE_ACTION_BUTTON_WIDTH) - FeedVideoEnv.dp10) - (FeedVideoEnv.getAdvCharWidth() * 4)) / 2;
        int i3 = ((this.mCoverHeight - (FeedVideoEnv.ADVERTISE_ACTION_BUTTON_HEIGHT * 2)) - FeedVideoEnv.dp25) / 2;
        return f16 > ((float) advCharWidth) && f16 < ((float) (((advCharWidth + FeedVideoEnv.ADVERTISE_ACTION_BUTTON_WIDTH) + FeedVideoEnv.dp10) + (FeedVideoEnv.getAdvCharWidth() * 4))) && f17 > ((float) i3) && f17 < ((float) (i3 + FeedVideoEnv.ADVERTISE_ACTION_BUTTON_HEIGHT));
    }

    protected boolean isInOpenFreeTrafficArea(float f16, float f17) {
        int i3 = this.mOpenFreeTrafficUnderLineTextWidth;
        if (i3 < 0) {
            return false;
        }
        int i16 = this.mCoverWidth;
        int i17 = this.mOpenFreeTrafficNormalTextWidth;
        int i18 = (((i16 - i17) - i3) / 2) + i17 + FeedVideoEnv.f279795dp3;
        int i19 = (this.picHeight / 2) + FeedVideoEnv.dp48;
        return f16 > ((float) i18) && f16 < ((float) ((i3 + i18) + FeedVideoEnv.dpToPx(10.0f))) && f17 > ((float) i19) && f17 < ((float) (FeedVideoEnv.dp15 + i19));
    }

    protected boolean isInPlayIcon(float f16, float f17) {
        return false;
    }

    protected boolean isInReplayArea(float f16, float f17) {
        int dpToPx = (this.mCoverWidth / 2) + FeedVideoEnv.dpToPx(33.0f);
        int dpToPx2 = this.mCoverHeight - ((FeedVideoEnv.dpToPx(39.0f) + FeedVideoEnv.dpToPx(12.0f)) / 2);
        return f16 > ((float) dpToPx) && f16 < ((float) (((dpToPx + FeedVideoEnv.dpToPx(8.0f)) + FeedVideoEnv.dpToPx(11.0f)) + (FeedVideoEnv.getAdvCharWidth() * 4))) && f17 > ((float) dpToPx2) && f17 < ((float) (dpToPx2 + FeedVideoEnv.dpToPx(12.0f)));
    }

    protected boolean isInRestartArea(float f16, float f17) {
        int advCharWidth = ((((this.mCoverWidth - FeedVideoEnv.ERROR_ICON_WIDTH) - FeedVideoEnv.dp6) - (FeedVideoEnv.dp15 * 2)) - (FeedVideoEnv.getAdvCharWidth() * 4)) / 2;
        int i3 = ((((this.mCoverHeight - FeedVideoEnv.ERROR_ICON_HEIGTH) - FeedVideoEnv.dp35) - FeedVideoEnv.dp25) / 2) + FeedVideoEnv.ERROR_ICON_WIDTH + FeedVideoEnv.dp25;
        return f16 > ((float) advCharWidth) && f16 < ((float) (((((advCharWidth + advCharWidth) + FeedVideoEnv.ERROR_ICON_WIDTH) + FeedVideoEnv.dp6) + (FeedVideoEnv.dp15 * 2)) + (FeedVideoEnv.getAdvCharWidth() * 4))) && f17 > ((float) i3) && f17 < ((float) (i3 + FeedVideoEnv.dp35));
    }

    protected boolean isInStoreIcon(float f16, float f17) {
        if (this.mParent instanceof FeedAutoVideoFull) {
            return false;
        }
        int i3 = this.mCoverWidth;
        if (f16 >= i3) {
            return false;
        }
        int i16 = FeedVideoEnv.dp40;
        return f16 > ((float) (i3 - i16)) && f17 > 0.0f && f17 < ((float) i16);
    }

    public boolean isShowOpenFreeTraffic() {
        return this.mShowOpenFreeTraffic;
    }

    public boolean isShowPlayIcon() {
        return this.showPlayIcon;
    }

    public boolean isShowStoreIcon() {
        return false;
    }

    protected boolean needRoundCorner() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.singleDrawable == null) {
            PlayerUtils.log(5, LOG_TAG, "basevideodebug singleDrawable is null");
            return;
        }
        if (this.mParent.isShowCoverImage()) {
            drawCover(canvas);
        }
        BaseVideo baseVideo = this.mParent;
        boolean z16 = baseVideo instanceof FeedAutoVideoFull;
        if (baseVideo.getState() == 2) {
            processLoadingIcon(canvas);
            return;
        }
        if (this.mParent.getState() == 1) {
            this.mHandler.removeMessages(1);
            this.hasDrawingTask = false;
            setCoverWarnType(canvas, this.mWarnType);
            return;
        }
        if (this.mParent.getState() == 5) {
            this.mHandler.removeMessages(1);
            this.hasDrawingTask = false;
            setCoverWarnType(canvas, this.mWarnType);
            return;
        }
        if (this.mParent.getState() == 4) {
            drawComplete(canvas);
            return;
        }
        if (this.mParent.getState() == 8) {
            this.mHandler.removeMessages(1);
            this.hasDrawingTask = false;
            canvas.drawRect(0.0f, 0.0f, this.mCoverWidth, this.mCoverHeight, FeedVideoEnv.videoFloatCompleteMaskPaint);
            String string = FeedVideoEnv.feedResources.getString(1378);
            String string2 = FeedVideoEnv.feedResources.getString(1380);
            String string3 = FeedVideoEnv.feedResources.getString(1379);
            BaseVideo baseVideo2 = this.mParent;
            if (baseVideo2 instanceof FeedAutoVideoFull) {
                ((FeedAutoVideoFull) baseVideo2).getClass();
            }
            if (!this.isLandscape) {
                if (this.mIsJustShowReplayIcon) {
                    int i3 = (this.mCoverWidth - FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH) / 2;
                    int floatCharWidth = (((this.mCoverHeight - FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH) - FeedVideoEnv.dp10) - FeedVideoEnv.getFloatCharWidth()) / 2;
                    FeedVideoEnv.getFloatReplayDrawable().setBounds(i3, floatCharWidth, FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH + i3, FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + floatCharWidth);
                    FeedVideoEnv.getFloatReplayDrawable().draw(canvas);
                    canvas.drawText(string2, i3 + FeedVideoEnv.f279794dp1, floatCharWidth + FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + FeedVideoEnv.dp15, FeedVideoEnv.videoFloatCompleteTextPaint);
                    return;
                }
                int i16 = FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH * 3;
                int i17 = FeedVideoEnv.dp60;
                int i18 = i16 - (i17 * 2);
                int i19 = this.mCoverWidth;
                if (i19 - i18 < 0) {
                    this.mCoverIconSpac = FeedVideoEnv.dp60 - (((i18 - i19) / 2) + FeedVideoEnv.dp5);
                } else {
                    this.mCoverIconSpac = i17;
                }
                int i26 = ((i19 - (FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH * 3)) - (this.mCoverIconSpac * 2)) / 2;
                int floatCharWidth2 = (((this.mCoverHeight - FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH) - FeedVideoEnv.dp10) - FeedVideoEnv.getFloatCharWidth()) / 2;
                FeedVideoEnv.getFloatReplayDrawable().setBounds(i26, floatCharWidth2, FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH + i26, FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + floatCharWidth2);
                FeedVideoEnv.getFloatReplayDrawable().draw(canvas);
                canvas.drawText(string2, FeedVideoEnv.f279794dp1 + i26, FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + floatCharWidth2 + FeedVideoEnv.dp15, FeedVideoEnv.videoFloatCompleteTextPaint);
                int i27 = i26 + FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH + this.mCoverIconSpac;
                FeedVideoEnv.getFloatRedPacketDrawable().setBounds(i27, floatCharWidth2, FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH + i27, FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + floatCharWidth2);
                FeedVideoEnv.getFloatRedPacketDrawable().draw(canvas);
                canvas.drawText(string3, FeedVideoEnv.f279794dp1 + i27, FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + floatCharWidth2 + FeedVideoEnv.dp15, FeedVideoEnv.videoFloatCompleteTextPaint);
                int i28 = i27 + FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH + this.mCoverIconSpac;
                FeedVideoEnv.getFloatMoreDrawable().setBounds(i28, floatCharWidth2, FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH + i28, FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + floatCharWidth2);
                FeedVideoEnv.getFloatMoreDrawable().draw(canvas);
                canvas.drawText(string, i28 + FeedVideoEnv.f279794dp1, floatCharWidth2 + FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + FeedVideoEnv.dp15, FeedVideoEnv.videoFloatCompleteTextPaint);
                return;
            }
            int i29 = ((this.mCoverWidth - (FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH * 2)) - this.mCoverIconSpac) / 2;
            int floatCharWidth3 = (((this.mCoverHeight - FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH) - FeedVideoEnv.dp10) - FeedVideoEnv.getFloatCharWidth()) / 2;
            FeedVideoEnv.getFloatReplayDrawable().setBounds(i29, floatCharWidth3, FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH + i29, FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + floatCharWidth3);
            FeedVideoEnv.getFloatReplayDrawable().draw(canvas);
            canvas.drawText(string2, FeedVideoEnv.f279794dp1 + i29, FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + floatCharWidth3 + FeedVideoEnv.dp15, FeedVideoEnv.videoFloatCompleteTextPaint);
            int i36 = i29 + FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH + this.mCoverIconSpac;
            FeedVideoEnv.getFloatMoreDrawable().setBounds(i36, floatCharWidth3, FeedVideoEnv.FLOAT_COMPLETE_ICON_WIDTH + i36, FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + floatCharWidth3);
            FeedVideoEnv.getFloatMoreDrawable().draw(canvas);
            canvas.drawText(string, i36 + FeedVideoEnv.f279794dp1, floatCharWidth3 + FeedVideoEnv.FLOAT_COMPLETE_ICON_HEIGTH + FeedVideoEnv.dp15, FeedVideoEnv.videoFloatCompleteTextPaint);
            return;
        }
        if (this.mParent.getState() == 6) {
            this.mHandler.removeMessages(1);
            this.hasDrawingTask = false;
            canvas.drawRect(0.0f, 0.0f, this.mCoverWidth, this.mCoverHeight, FeedVideoEnv.errorActionMaskPaint);
            String string4 = FeedVideoEnv.feedResources.getString(this.loadFailedTextId);
            int advCharWidth = (((this.mCoverWidth - FeedVideoEnv.ERROR_ICON_WIDTH) - FeedVideoEnv.dp6) - (FeedVideoEnv.getAdvCharWidth() * string4.length())) / 2;
            int i37 = (this.mCoverHeight - FeedVideoEnv.ERROR_ICON_HEIGTH) / 2;
            this.erroIcon.setBounds(advCharWidth, i37, FeedVideoEnv.ERROR_ICON_WIDTH + advCharWidth, FeedVideoEnv.ERROR_ICON_HEIGTH + i37);
            this.erroIcon.draw(canvas);
            canvas.drawText(string4, advCharWidth + FeedVideoEnv.dp6 + FeedVideoEnv.ERROR_ICON_WIDTH, i37 + FeedVideoEnv.ERROR_TEXT_PADDING_TOP, FeedVideoEnv.advActionTextPaint);
            return;
        }
        if (this.mParent.getState() == 7) {
            this.mHandler.removeMessages(1);
            this.hasDrawingTask = false;
            canvas.drawRect(0.0f, 0.0f, this.mCoverWidth, this.mCoverHeight, FeedVideoEnv.errorActionMaskPaint);
            String string5 = FeedVideoEnv.feedResources.getString(this.loadFailedTextId);
            String string6 = FeedVideoEnv.feedResources.getString(1377);
            int advCharWidth2 = (((this.mCoverWidth - FeedVideoEnv.ERROR_ICON_WIDTH) - FeedVideoEnv.dp6) - (FeedVideoEnv.getAdvCharWidth() * string5.length())) / 2;
            int i38 = (((this.mCoverHeight - FeedVideoEnv.ERROR_ICON_HEIGTH) - FeedVideoEnv.dp35) - FeedVideoEnv.dp25) / 2;
            this.erroIcon.setBounds(advCharWidth2, i38, FeedVideoEnv.ERROR_ICON_WIDTH + advCharWidth2, FeedVideoEnv.ERROR_ICON_HEIGTH + i38);
            this.erroIcon.draw(canvas);
            canvas.drawText(string5, advCharWidth2 + FeedVideoEnv.dp6 + FeedVideoEnv.ERROR_ICON_WIDTH, FeedVideoEnv.ERROR_TEXT_PADDING_TOP + i38, FeedVideoEnv.advActionTextPaint);
            int advCharWidth3 = ((((this.mCoverWidth - FeedVideoEnv.ERROR_ICON_WIDTH) - FeedVideoEnv.dp6) - (FeedVideoEnv.dp15 * 2)) - (FeedVideoEnv.getAdvCharWidth() * string6.length())) / 2;
            int i39 = i38 + FeedVideoEnv.ERROR_ICON_WIDTH + FeedVideoEnv.dp25;
            canvas.drawRoundRect(new RectF(advCharWidth3, i39, advCharWidth3 + FeedVideoEnv.ERROR_ICON_WIDTH + FeedVideoEnv.dp6 + (FeedVideoEnv.dp15 * 2) + (FeedVideoEnv.getAdvCharWidth() * string6.length()), FeedVideoEnv.dp35 + i39), 10.0f, 10.0f, FeedVideoEnv.retryActionTextPaint);
            int advCharWidth4 = (((this.mCoverWidth - FeedVideoEnv.ERROR_ICON_WIDTH) - FeedVideoEnv.dp6) - (FeedVideoEnv.getAdvCharWidth() * string6.length())) / 2;
            int i46 = i39 + FeedVideoEnv.ERROR_RECT_PADDING_TOP;
            this.retryIcon.setBounds(advCharWidth4, i46, FeedVideoEnv.ERROR_ICON_WIDTH + advCharWidth4, FeedVideoEnv.ERROR_ICON_HEIGTH + i46);
            this.retryIcon.draw(canvas);
            canvas.drawText(string6, advCharWidth4 + FeedVideoEnv.dp6 + FeedVideoEnv.ERROR_ICON_WIDTH, i46 + FeedVideoEnv.ERROR_TEXT_PADDING_TOP, FeedVideoEnv.advActionTextPaint);
        }
    }

    protected void onJumpToVideoTab() {
        BaseVideo baseVideo = this.mParent;
        if (baseVideo != null) {
            baseVideo.jumpToVideoTab();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17 = this.picWidth;
        this.mCoverWidth = i17;
        int i18 = this.picHeight;
        this.mCoverHeight = i18;
        setMeasuredDimension(i17, i18);
    }

    protected void onOpenFreeTrafficClicked() {
        String str;
        VideoPlayInfo videoPlayInfo = this.videoPlayInfo;
        if (videoPlayInfo == null || TextUtils.isEmpty(videoPlayInfo.openFreeTrafficJumpUrl)) {
            return;
        }
        FeedVideoEnv.externalFunc.openBrowser(this.videoPlayInfo.openFreeTrafficJumpUrl, -1, new Bundle(), "");
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
        if (this.videoPlayInfo.isLiveVideo) {
            str = "1";
        } else {
            str = "2";
        }
        feedVideoExternalFunc.reportClick("8", ThemeReporter.FROM_CLEANER, str);
    }

    protected void onPlayButtonAdvClicked() {
        BaseVideo baseVideo = this.mParent;
        if (baseVideo != null) {
            baseVideo.getBaseVideoManager().startVideo(this.mParent);
        }
    }

    protected void onPlayButtonClicked() {
        if (this.mParent != null) {
            BaseVideoManager.getFeedVideoManager().startVideo(this.mParent);
        }
    }

    protected void onPlayResumeClicked() {
        BaseVideo baseVideo = this.mParent;
        if (baseVideo == null || this.mWarnType != CoverWarnType.NETWORK_CHANGE) {
            return;
        }
        baseVideo.getBaseVideoManager().startVideo(this.mParent);
        BaseVideoManager.getFeedVideoManager().g();
        BaseVideoManager.getFeedVideoManager().setIsNeedPlayTip(false);
        BaseVideoManager.getFeedVideoManager().l().edit().putLong("BaseVideoManager.key_current_store_stamp", System.currentTimeMillis()).apply();
        BaseVideoManager.getFeedVideoManager().f279610e = -2L;
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover.4
            @Override // java.lang.Runnable
            public void run() {
                BaseVideoCover.this.mParent.mShowCoverWarnType = false;
                PlayerUtils.log(4, BaseVideoCover.LOG_TAG, "show cover warn type = " + BaseVideoCover.this.mParent.mShowCoverWarnType);
                BaseVideoCover.this.mParent.mTimeview.setVisibility(0);
                BaseVideoCover.this.mParent.mPlayCountView.setVisibility(0);
                BaseVideoCover.this.mParent.mSoundLinesLayout.setVisibility(0);
            }
        });
    }

    public synchronized void onRecycled() {
        String str = this.preUrl;
        if (str != null) {
            removeUrlHash(str);
        }
        this.preOpt = null;
        this.preUrl = null;
        this.preImgUrl = null;
        this.singleDrawable = null;
        this.timeDes = null;
    }

    protected void onShowFloatRedpocket() {
        BaseVideo baseVideo = this.mParent;
        if (baseVideo != null) {
            baseVideo.showRedpocket();
        }
    }

    public void onStateIdle() {
        boolean z16;
        Drawable drawable;
        PlayerUtils.log(3, "rubin", "AutoVideoCover onStateIdle");
        if (this.singleDrawable == getDefaultDrawable() && this.preOpt != null) {
            PlayerUtils.log(3, "rubin", "AutoVideoCover position 8");
            Drawable loadImage = ImageLoader.getInstance(FeedVideoEnv.getApplicationContext()).loadImage(this.preImgUrl, this.preUrl, this.downloadListener, this.preOpt);
            this.singleDrawable = loadImage;
            if (loadImage != null) {
                this.picHeight = loadImage.getIntrinsicHeight();
                int intrinsicWidth = this.singleDrawable.getIntrinsicWidth();
                this.picWidth = intrinsicWidth;
                int min = Math.min(intrinsicWidth, FeedVideoEnv.DEFAULT_WIDTH);
                this.picHeight = (this.picHeight * min) / this.picWidth;
                this.picWidth = min;
                z16 = true;
                drawable = this.singleDrawable;
                if (drawable == null && drawable != getDefaultDrawable() && z16) {
                    PlayerUtils.log(3, "rubin", "AutoVideoCoversingleDrawable != null && singleDrawable != getDefaultDrawable() && needInvalidate");
                    invalidate();
                    return;
                }
                return;
            }
            PlayerUtils.log(3, "rubin", "AutoVideoCover position 9");
            this.singleDrawable = getDefaultDrawable();
        }
        z16 = false;
        drawable = this.singleDrawable;
        if (drawable == null) {
        }
    }

    protected void onVideoStoreClicked() {
        if (this.mParent != null) {
            if (this.isVideoStored) {
                FeedVideoEnv.externalFunc.showToast(FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videounstoretoasttext", "\u64a4\u9500\u6210\u529f"));
                this.isVideoStored = false;
            } else {
                FeedVideoEnv.externalFunc.showToast(FeedVideoEnv.externalFunc.getWnsConfig("VideoSDKSetting", "videostoretoasttext", "\u8be5\u89c6\u9891\u5c06\u5728\u6709WiFi\u65f6\u63a8\u8350\u7ed9\u4f60"));
                this.isVideoStored = true;
            }
            long j3 = this.mParent.getVideoPlayInfo().authorUin;
            long j16 = this.mParent.getVideoPlayInfo().feedTime;
            String str = this.mParent.getVideoPlayInfo().cellId;
            if (this.mParent.getVideoPlayInfo().originFeedTime != 0) {
                j16 = this.mParent.getVideoPlayInfo().originFeedTime;
            }
            if (this.mParent.getVideoPlayInfo().ugcFeedsCreateTime != 0) {
                j16 = this.mParent.getVideoPlayInfo().ugcFeedsCreateTime;
            }
            if (this.mParent.getVideoPlayInfo().originCellId != null) {
                str = this.mParent.getVideoPlayInfo().originCellId;
            }
            String str2 = str;
            if (!TextUtils.isEmpty(str2)) {
                if (sPlayOnWifiMap.containsKey(str2)) {
                    sPlayOnWifiMap.remove(str2);
                }
                sPlayOnWifiMap.put(str2, Boolean.valueOf(this.isVideoStored));
            }
            long j17 = j16 / 1000;
            PlayerUtils.log(4, LOG_TAG, "onVideoStoreClicked feedsUin = " + j3 + ", time = " + j17 + ", feedsKey = " + str2 + ", videoStored" + (true ^ this.isVideoStored));
            FeedVideoEnv.externalFunc.reportOnWifiPlay(j3, j17, str2, this.isVideoStored);
            try {
                reportStoreIconToLp(PLAY_ON_WIFI_REPORT_CLICK, Integer.parseInt(this.mParent.getVideoPlayInfo().videoPlayScene));
            } catch (Exception unused) {
                PlayerUtils.log(6, LOG_TAG, "video play scene = " + this.mParent.getVideoPlayInfo().videoPlayScene);
            }
            invalidate();
        }
    }

    protected void processLoadingIcon(Canvas canvas) {
        int i3 = this.mCoverHeight;
        int i16 = FeedVideoEnv.dp60;
        if (i3 <= i16 || this.mCoverWidth <= i16) {
            return;
        }
        if (!this.hasDrawingTask) {
            this.percent += 9;
        }
        int i17 = this.percent;
        if (i17 > this.WIDTH_COUNT) {
            i17 = 0;
        }
        this.percent = i17;
        drawLoadingIcon(canvas);
        if (this.hasDrawingTask) {
            return;
        }
        this.mHandler.removeMessages(1);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(Message.obtain(handler, 1), 250L);
        this.hasDrawingTask = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reCaculateSize(int i3, int i16) {
        int maxWidth = getMaxWidth();
        if (!this.mIsVideoPicMixMode) {
            this.picWidth = maxWidth;
            this.picHeight = (int) ((maxWidth / i3) * i16);
        } else {
            this.picWidth = i3;
            this.picHeight = i16;
        }
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover.3
            @Override // java.lang.Runnable
            public void run() {
                BaseVideoCover.this.requestLayout();
            }
        });
    }

    public void removeUrlHash(String str) {
        HashMap<String, b> hashMap = this.mUrlStateHash;
        if (hashMap == null || hashMap.get(str) == null) {
            return;
        }
        b bVar = this.mUrlStateHash.get(str);
        if (bVar.f279595c == null || bVar.f279594b == null) {
            return;
        }
        ImageLoader.getInstance(null).cancel(bVar.f279595c, this.downloadListener, bVar.f279594b);
        this.mUrlStateHash.remove(str);
    }

    public synchronized void reset() {
        this.mMaxWidth = 0;
        this.picHeight = 0;
        this.picWidth = 0;
        this.mCoverHeight = 0;
        this.mCoverWidth = 0;
        this.videoPlayInfo = null;
        this.mWarnType = CoverWarnType.DEFAULT;
        this.mIsNetworkDisconnect = false;
    }

    public void setJustShowReplyIcon(boolean z16) {
        this.mIsJustShowReplayIcon = z16;
    }

    public void setLikeFriendVideo(boolean z16) {
        this.mIsLikeFriendVideo = z16;
    }

    @Deprecated
    public void setMaxWidth(int i3) {
        this.mMaxWidth = i3;
    }

    public synchronized void setPicInfo(PictureUrl pictureUrl, final String str, final VideoPlayInfo videoPlayInfo) {
        int i3;
        int i16;
        String str2;
        ImageUrl imageUrl;
        ImageProcessor imageProcessor;
        int i17;
        int i18;
        int i19;
        onRecycled();
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover.2
            @Override // java.lang.Runnable
            public void run() {
                BaseVideoCover baseVideoCover = BaseVideoCover.this;
                baseVideoCover.timeDes = str;
                baseVideoCover.percent = 0;
                baseVideoCover.videoPlayInfo = videoPlayInfo;
            }
        });
        if (this.mIsLikeFriendVideo) {
            i3 = FeedVideoEnv.externalFunc.getCommentWidth_Rec();
            i16 = (int) ((i3 * 9.0f) / 16.0f);
        } else {
            i3 = 0;
            i16 = 0;
        }
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        int uniNum = getUniNum();
        this.mUni = uniNum;
        if (pictureUrl != null) {
            str2 = pictureUrl.url;
            imageUrl = pictureUrl.imgUrl;
        } else {
            str2 = null;
            imageUrl = null;
        }
        obtain.obj = Integer.valueOf(uniNum);
        int maxWidth = getMaxWidth();
        if (!this.mIsVideoPicMixMode) {
            if (needRoundCorner()) {
                imageProcessor = new RoundCornerProcessor(getCornerRadius());
            } else {
                imageProcessor = videoPlayInfo.processor;
            }
            obtain.extraProcessor = imageProcessor;
            if (pictureUrl != null && (videoPlayInfo.width == 0 || videoPlayInfo.height == 0)) {
                int i26 = pictureUrl.width;
                if (i26 != 0 && (i17 = pictureUrl.height) != 0) {
                    obtain.clipWidth = i26;
                    obtain.clipHeight = i17;
                }
                obtain.clipWidth = maxWidth;
                obtain.clipHeight = maxWidth;
            } else if (this.mIsLikeFriendVideo) {
                int i27 = videoPlayInfo.width;
                int i28 = videoPlayInfo.height;
                if (i27 >= i28) {
                    obtain.clipHeight = (int) ((i3 * i28) / i27);
                    obtain.clipWidth = i3;
                } else {
                    obtain.clipWidth = (i27 * i16) / i28;
                    obtain.clipHeight = i16;
                }
                this.mLikeFriendVideoCoverWidth = obtain.clipWidth;
                this.mLikeFriendVideoCoverHeight = obtain.clipHeight;
            } else {
                obtain.clipWidth = videoPlayInfo.width;
                obtain.clipHeight = videoPlayInfo.height;
            }
        } else if (pictureUrl != null && (i18 = pictureUrl.width) != 0 && (i19 = pictureUrl.height) != 0) {
            BaseVideo baseVideo = this.mParent;
            if (baseVideo != null) {
                baseVideo.setVideoOriginalSize(i18, i19);
            }
            float f16 = i18 < i19 ? (((i19 - i18) / 3.0f) + (i18 / 2.0f)) / i19 : 0.5f;
            int min = Math.min(i18, i19);
            obtain.extraProcessor = new NormalFeedImageProcessor(min, min, 0.5f, f16);
            obtain.clipWidth = min;
            obtain.clipHeight = min;
        } else {
            obtain.extraProcessor = new NormalFeedImageProcessor(maxWidth, maxWidth);
            obtain.clipWidth = maxWidth;
            obtain.clipHeight = maxWidth;
        }
        obtain.preferQuality = false;
        obtain.disableHitRateReport = true;
        if (str2 != null) {
            if (this.mUrlStateHash.get(str2) == null) {
                Drawable loadImage = ImageLoader.getInstance(null).loadImage(imageUrl, str2, this.downloadListener, obtain);
                this.preUrl = str2;
                this.preImgUrl = imageUrl;
                this.preOpt = obtain;
                if (loadImage != null) {
                    this.singleDrawable = loadImage;
                    this.mUrlStateHash.remove(str2);
                } else {
                    b bVar = new b();
                    bVar.f279594b = obtain;
                    bVar.f279595c = str2;
                    bVar.f279593a = this.URL_STATE_LOAD_IMAGE_ING;
                    this.mUrlStateHash.put(str2, bVar);
                }
            }
        } else {
            PlayerUtils.log(6, LOG_TAG, "signUrl is null");
        }
        Drawable drawable = this.singleDrawable;
        if (drawable == null) {
            this.singleDrawable = getDefaultDrawable();
            if (!this.mIsLikeFriendVideo) {
                i3 = obtain.clipWidth;
                i16 = obtain.clipHeight;
            }
        } else if (!this.mIsLikeFriendVideo) {
            i16 = drawable.getIntrinsicHeight();
            i3 = this.singleDrawable.getIntrinsicWidth();
        }
        if (this.mIsVideoPicMixMode) {
            i3 = this.mVideoPicMixModeClipSize;
            i16 = i3;
        }
        VideoPlayInfo videoPlayInfo2 = this.videoPlayInfo;
        if (videoPlayInfo2 != null && !TextUtils.isEmpty(videoPlayInfo2.openFreeTrafficText)) {
            this.mOpenFreeTrafficText = BaseVideoCoverUtils.parseOpenTrafficText(videoPlayInfo2.openFreeTrafficText);
        }
        reCaculateSize(i3, i16);
        forceLayout();
    }

    public synchronized void setPicInfoOnCoverThread(PictureUrl pictureUrl, String str, VideoPlayInfo videoPlayInfo) {
        setPicInfo(pictureUrl, str, videoPlayInfo);
    }

    public void setShowOpenFreeTrafficIcon(boolean z16) {
        this.mShowOpenFreeTraffic = z16;
    }

    public void setShowPlayIcon(boolean z16) {
        this.showPlayIcon = z16;
    }

    public void setVideoPicMixMode(boolean z16) {
        this.mIsVideoPicMixMode = z16;
    }

    public void setVideoPicMixModeClipSize(int i3) {
        this.mVideoPicMixModeClipSize = i3;
    }

    protected synchronized boolean useBigPhotoMode() {
        boolean z16;
        VideoPlayInfo videoPlayInfo = this.videoPlayInfo;
        if (videoPlayInfo != null) {
            z16 = TextUtils.isEmpty(videoPlayInfo.getDisplayRemark());
        }
        return z16;
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class PicListener implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<BaseVideoCover> f279588d;

        public PicListener(BaseVideoCover baseVideoCover) {
            this.f279588d = new WeakReference<>(baseVideoCover);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            WeakReference<BaseVideoCover> weakReference;
            final BaseVideoCover baseVideoCover;
            if (options == null || (weakReference = this.f279588d) == null || (baseVideoCover = weakReference.get()) == null) {
                return;
            }
            baseVideoCover.coverErrorMsg = options.errCode;
            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover.PicListener.1
                @Override // java.lang.Runnable
                public void run() {
                    baseVideoCover.invalidate();
                }
            });
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            Object obj;
            WeakReference<BaseVideoCover> weakReference;
            final BaseVideoCover baseVideoCover;
            if (options == null || (obj = options.obj) == null || !(obj instanceof Integer) || drawable == null || (weakReference = this.f279588d) == null || (baseVideoCover = weakReference.get()) == null) {
                return;
            }
            if (!TextUtils.isEmpty(options.errCode)) {
                baseVideoCover.coverErrorMsg = options.errCode;
            } else {
                baseVideoCover.coverErrorMsg = null;
            }
            if (baseVideoCover.mUni == ((Integer) options.obj).intValue()) {
                baseVideoCover.singleDrawable = drawable;
                boolean z16 = false;
                if (!baseVideoCover.mIsVideoPicMixMode) {
                    if (!baseVideoCover.mIsLikeFriendVideo) {
                        if (baseVideoCover.picHeight != drawable.getIntrinsicHeight()) {
                            baseVideoCover.picHeight = drawable.getIntrinsicHeight();
                            z16 = true;
                        }
                        if (baseVideoCover.picWidth != drawable.getIntrinsicWidth()) {
                            baseVideoCover.picWidth = drawable.getIntrinsicWidth();
                            z16 = true;
                        }
                        baseVideoCover.reCaculateSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    }
                } else {
                    baseVideoCover.reCaculateSize(baseVideoCover.mVideoPicMixModeClipSize, baseVideoCover.mVideoPicMixModeClipSize);
                }
                if (z16 && FeedVideoEnv.externalFunc.getCurrentLoadingImgStatus()) {
                    PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover.PicListener.2
                        @Override // java.lang.Runnable
                        public void run() {
                            baseVideoCover.requestLayout();
                        }
                    });
                } else {
                    PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.video.BaseVideoCover.PicListener.3
                        @Override // java.lang.Runnable
                        public void run() {
                            baseVideoCover.invalidate();
                        }
                    });
                }
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    public BaseVideoCover(Context context, AttributeSet attributeSet, BaseVideo baseVideo) {
        this(context, attributeSet, 0, baseVideo);
    }

    public BaseVideoCover(Context context, AttributeSet attributeSet, int i3, BaseVideo baseVideo) {
        super(context, attributeSet, i3);
        this.mUni = -1;
        this.singleDrawable = getDefaultDrawable();
        this.WIDTH_COUNT = -1;
        this.HEIGHT_COUNT = -1;
        this.rectLoadingFrome = new Rect();
        this.rectLoadingTo = new Rect();
        this.mCoverIconSpac = FeedVideoEnv.dp60;
        this.mUrlStateHash = new HashMap<>();
        this.mIsJustShowReplayIcon = false;
        this.URL_STATE_LOAD_IMAGE_ING = 1;
        this.loadFailedTextId = 1371;
        this.freeTrafficText = FeedVideoEnv.feedResources.getString(1384);
        this.mOpenFreeTrafficNormalTextWidth = -1;
        this.mOpenFreeTrafficUnderLineTextWidth = -1;
        this.mShowOpenFreeTraffic = false;
        this.warnCharWidth = 0;
        this.actionCharWidth = 0;
        this.mWarnType = CoverWarnType.DEFAULT;
        this.showPlayIcon = true;
        this.mIsVideoPicMixMode = false;
        this.mIsLikeFriendVideo = false;
        this.mIsNetworkDisconnect = false;
        this.storeIconClicked = false;
        this.isVideoStored = false;
        this.mHandler = new a(Looper.getMainLooper());
        setContentDescription(LOG_TAG);
        this.freeTrafficPlayIconBg = FeedVideoEnv.getFreeTrafficPlayIconBg();
        this.freeTrafficPlayIconButton = FeedVideoEnv.getFreeTrafficPlayIconButton();
        this.playIcon = FeedVideoEnv.getIconReadyPlay();
        this.erroIcon = FeedVideoEnv.getVideoErrorDrawable();
        this.retryIcon = FeedVideoEnv.getRetryIconDrawable();
        this.warnIcon = FeedVideoEnv.getWarnIconDrawable();
        this.actionIcon = FeedVideoEnv.getActionIconDrawable();
        this.videoBgTop = FeedVideoEnv.getVideoFloatBgTopDrawable();
        this.videoBgBottom = FeedVideoEnv.getVideoFloatBgBottomDrawable();
        this.mParent = baseVideo;
        this.downloadListener = new PicListener(this);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        boolean z16 = false;
        boolean z17 = this.mParent.getState() == 1 && isInPlayIcon(x16, y16);
        boolean z18 = this.mParent.getState() == 4 && isInGetMoreArea(x16, y16);
        boolean z19 = this.mParent.getState() == 4 && isInReplayArea(x16, y16);
        boolean z26 = this.mParent.getState() == 7 && isInRestartArea(x16, y16);
        boolean z27 = this.mParent.getState() == 8 && isInFloatReplay(x16, y16);
        boolean z28 = this.mParent.getState() == 8 && isInFloatRedpocket(x16, y16);
        boolean z29 = this.mParent.getState() == 8 && isInFloatMore(x16, y16);
        boolean z36 = this.mParent.getState() == 1 && isActionArea(x16, y16) && this.mIsNetworkDisconnect;
        this.storeIconClicked = this.mParent.getState() == 1 && isInStoreIcon(x16, y16);
        boolean z37 = this.mShowOpenFreeTraffic && this.mParent.getState() == 1 && isInOpenFreeTrafficArea(x16, y16);
        VideoPlayInfo videoPlayInfo = this.videoPlayInfo;
        if (videoPlayInfo != null && videoPlayInfo.k()) {
            if (this.mParent.getState() == 4 && isInBottomLeftArea(x16, y16)) {
                z16 = true;
            }
            if (motionEvent.getAction() == 0) {
                if ((z17 || z19) && !BaseVideoManager.belowICE_CREAM && !FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED) {
                    this.mParent.onAdvertiseMoreClicked();
                } else if (z18 || z26 || z16) {
                    this.mParent.onReplayClicked();
                }
                return true;
            }
            if (motionEvent.getAction() == 1 && !z17 && !z18 && !z19 && !z26 && !z16) {
                this.mParent.onVideoCoverBlankClicked();
            }
            return super.onTouchEvent(motionEvent);
        }
        if (!z17 && !z18 && !z19 && !z26 && !z27 && !z28 && !z29 && !z36 && ((!this.storeIconClicked || !isShowStoreIcon()) && !z37 && this.mWarnType != CoverWarnType.NETWORK_DISCONNECT)) {
            if (this.mParent.getState() == 5) {
                BaseVideo baseVideo = this.mParent;
                if (baseVideo instanceof FeedAutoVideoFull) {
                    FeedAutoVideoFull feedAutoVideoFull = (FeedAutoVideoFull) baseVideo;
                    FeedAutoVideoControllerView feedAutoVideoControllerView = feedAutoVideoFull.f279637e;
                    if (feedAutoVideoControllerView != null) {
                        feedAutoVideoControllerView.doPauseResume();
                    }
                    FeedAutoVideoFull.h hVar = feedAutoVideoFull.B0;
                    if (hVar != null && hVar.isPlaying()) {
                        feedAutoVideoFull.U = false;
                    } else {
                        feedAutoVideoFull.U = true;
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            if ((z17 || z19) && !BaseVideoManager.belowICE_CREAM && !FeedVideoEnv.CLOSE_HARDWARE_ACCELERATED) {
                this.mParent.onAdvertiseMoreClicked();
            } else if (z18 || z26 || z27) {
                onPlayButtonClicked();
            } else if (z28) {
                onShowFloatRedpocket();
            } else if (z29) {
                onJumpToVideoTab();
            } else if (z36) {
                onPlayResumeClicked();
            } else if (this.storeIconClicked) {
                onVideoStoreClicked();
            } else if (z37) {
                onOpenFreeTrafficClicked();
            }
        }
        return true;
    }

    public void runOnCoverThread(Runnable runnable) {
        HandlerThread coverThread;
        if (runnable == null || (coverThread = BaseVideoCoverUtils.getInstance().getCoverThread()) == null || coverThread.getLooper() == null) {
            return;
        }
        Handler handler = new Handler(coverThread.getLooper());
        if (coverThread.getLooper().getThread() != Thread.currentThread()) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCoverWarnType(Canvas canvas, CoverWarnType coverWarnType) {
        VideoPlayInfo videoPlayInfo;
        long j3;
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        if (CoverWarnType.DEFAULT != coverWarnType && !this.mIsVideoPicMixMode) {
            if (CoverWarnType.NETWORK_CHANGE == coverWarnType) {
                Drawable drawable = this.warnIcon;
                Drawable drawable2 = this.actionIcon;
                VideoPlayInfo videoPlayInfo2 = this.videoPlayInfo;
                if (videoPlayInfo2 == null || videoPlayInfo2.segmentVideoInfo.getDefaultUrl() == null) {
                    j3 = -1;
                } else {
                    String defaultUrl = this.videoPlayInfo.segmentVideoInfo.getDefaultUrl();
                    l h16 = s.g().h(this.videoPlayInfo.segmentVideoInfo.getDefaultUrl(), false);
                    if (h16 != null && (arrayList = h16.f280002b) != null && arrayList.size() > 0) {
                        defaultUrl = h16.f280002b.get(0).url;
                    }
                    j3 = VideoManager.getInstance().getUnCachedSize(defaultUrl);
                    PlayerUtils.log(5, "zakiwang", "remainUnCachedBytes:" + j3);
                }
                String string = FeedVideoEnv.feedResources.getString(1382);
                this.warnCharWidth = (FeedVideoEnv.getWarnCharWidth() * (string.length() - 1)) + FeedVideoEnv.getCommaCharWidth();
                if (j3 > 0) {
                    string = "\u5f53\u524d\u4e3a\u975ewifi\u73af\u5883\uff0c\u89c2\u770b\u5c06\u6d88\u8017" + getRemainUnCachedSize(j3) + "\u6d41\u91cf";
                    this.warnCharWidth = (FeedVideoEnv.getWarnCharWidth() * (string.length() - 8)) + FeedVideoEnv.getCommaCharWidth() + (FeedVideoEnv.getNumberCharWidth() * 7);
                }
                String string2 = FeedVideoEnv.feedResources.getString(1381);
                this.actionCharWidth = FeedVideoEnv.getActionCharWidth() * string2.length();
                canvas.drawRect(0.0f, 0.0f, this.mCoverWidth, this.mCoverHeight, FeedVideoEnv.errorActionMaskPaint);
                int i3 = (((this.mCoverWidth - FeedVideoEnv.ERROR_ICON_WIDTH) - FeedVideoEnv.dp6) - this.warnCharWidth) / 2;
                int i16 = (((this.mCoverHeight - FeedVideoEnv.ERROR_ICON_HEIGTH) - FeedVideoEnv.dp33) - FeedVideoEnv.dp20) / 2;
                StaticLayout staticLayout = new StaticLayout("\u3000  " + string, FeedVideoEnv.warnActionTextPaintNew, this.mCoverWidth - (FeedVideoEnv.dpToPx(12.0f) * 2), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                int height = staticLayout.getHeight();
                if (this.warnCharWidth > this.mCoverWidth - (FeedVideoEnv.dpToPx(12.0f) * 2)) {
                    i3 = FeedVideoEnv.dpToPx(12.0f);
                    i16 = (((this.mCoverHeight - height) - FeedVideoEnv.dp33) - FeedVideoEnv.dp20) / 2;
                }
                drawable.setBounds(i3, i16, FeedVideoEnv.ERROR_ICON_WIDTH + i3, FeedVideoEnv.ERROR_ICON_HEIGTH + i16);
                drawable.draw(canvas);
                canvas.save();
                canvas.translate(i3, i16 - FeedVideoEnv.f279795dp3);
                staticLayout.draw(canvas);
                canvas.restore();
                int i17 = ((((this.mCoverWidth - FeedVideoEnv.ERROR_ICON_WIDTH) - FeedVideoEnv.dp6) - (FeedVideoEnv.dp15 * 2)) - this.actionCharWidth) / 2;
                int i18 = i16 + height + FeedVideoEnv.dp20;
                canvas.drawRoundRect(new RectF(i17, i18, i17 + FeedVideoEnv.ERROR_ICON_WIDTH + FeedVideoEnv.dp6 + (FeedVideoEnv.dp15 * 2) + this.actionCharWidth, FeedVideoEnv.dp33 + i18), 4.0f, 4.0f, FeedVideoEnv.actionActionBgPaint);
                int i19 = (((this.mCoverWidth - FeedVideoEnv.ERROR_ICON_WIDTH) - FeedVideoEnv.dp6) - this.actionCharWidth) / 2;
                int i26 = i18 + FeedVideoEnv.dp9;
                drawable2.setBounds(i19, i26, FeedVideoEnv.ERROR_ICON_WIDTH + i19, FeedVideoEnv.ERROR_ICON_HEIGTH + i26);
                drawable2.draw(canvas);
                canvas.drawText(string2, i19 + FeedVideoEnv.dp6 + FeedVideoEnv.ERROR_ICON_WIDTH, i26 + FeedVideoEnv.ERROR_TEXT_PADDING_TOP, FeedVideoEnv.actionActionTextPaint);
                this.mParent.isTimeViewVisible(false);
                this.mParent.mShowCoverWarnType = true;
            } else if (CoverWarnType.NETWORK_DISCONNECT == coverWarnType) {
                this.mIsNetworkDisconnect = true;
                Drawable drawable3 = this.warnIcon;
                String string3 = FeedVideoEnv.feedResources.getString(1383);
                this.warnCharWidth = (FeedVideoEnv.getWarnCharWidth() * string3.length()) + FeedVideoEnv.getCommaCharWidth() + FeedVideoEnv.getSpaceCharWidth() + FeedVideoEnv.dp9;
                canvas.drawRect(0.0f, 0.0f, this.mCoverWidth, this.mCoverHeight, FeedVideoEnv.errorActionMaskPaint);
                int i27 = (((this.mCoverWidth - FeedVideoEnv.ERROR_ICON_WIDTH) - FeedVideoEnv.dp6) - this.warnCharWidth) / 2;
                int i28 = (this.mCoverHeight - FeedVideoEnv.ERROR_ICON_HEIGTH) / 2;
                drawable3.setBounds(i27, i28, FeedVideoEnv.ERROR_ICON_WIDTH + i27, FeedVideoEnv.ERROR_ICON_HEIGTH + i28);
                drawable3.draw(canvas);
                canvas.drawText(string3, i27 + FeedVideoEnv.dp6 + FeedVideoEnv.ERROR_ICON_WIDTH, i28 + FeedVideoEnv.ERROR_TEXT_PADDING_TOP, FeedVideoEnv.warnActionTextPaint);
                this.mParent.isTimeViewVisible(false);
                this.mParent.mShowCoverWarnType = true;
                return;
            }
        } else {
            int i29 = this.mCoverHeight;
            int i36 = FeedVideoEnv.dp60;
            if (i29 > i36 && this.mCoverWidth > i36 && (videoPlayInfo = this.videoPlayInfo) != null && videoPlayInfo.videoStatus != 3) {
                if (this.mShowOpenFreeTraffic) {
                    drawOpenFreeTraffic(canvas);
                }
                if (this.showPlayIcon) {
                    drawPlayIcon(canvas);
                }
            }
        }
        this.mIsNetworkDisconnect = false;
    }

    private String getRemainUnCachedSize(long j3) {
        if (j3 > 1073741824) {
            float f16 = ((float) j3) / 1.07374182E9f;
            if (j3 > 107374182400L) {
                return ((int) (f16 + 0.5f)) + "G";
            }
            return String.format("%.1f", Float.valueOf(f16)) + "G";
        }
        if (j3 > 1048576) {
            float f17 = ((float) j3) / 1048576.0f;
            if (j3 > 1047527424) {
                return "999M";
            }
            if (j3 > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                return ((int) (f17 + 0.5f)) + "M";
            }
            return String.format("%.1f", Float.valueOf(f17)) + "M";
        }
        if (j3 <= 1024) {
            if (j3 > 0) {
                return "0K";
            }
            return "";
        }
        float f18 = ((float) j3) / 1024.0f;
        if (j3 > 1022976) {
            return "999K";
        }
        if (j3 > FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) {
            return ((int) (f18 + 0.5f)) + "K";
        }
        return String.format("%.1f", Float.valueOf(f18)) + "K";
    }

    private String convertNum(long j3, boolean z16) {
        if (j3 >= SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            long j16 = ((j3 / 10000000) + 5) / 10;
            if (j16 >= 10000) {
                return "9999\u4ebf";
            }
            return j16 + "\u4ebf";
        }
        if (j3 >= 10000) {
            long j17 = ((j3 / 1000) + 5) / 10;
            if (j17 >= 10000) {
                return "9999\u4e07";
            }
            return j17 + "\u4e07";
        }
        return String.valueOf(j3);
    }

    public void reportStoreIconToLp(int i3, int i16) {
        if ((i3 == 1 || i3 == 2) && i16 >= 0 && i16 <= 5) {
            if (i16 == 4 || i16 == 5) {
                i16 = 4;
            }
            FeedVideoEnv.externalFunc.reportToLp00064(646, i3, i16);
        }
    }
}
