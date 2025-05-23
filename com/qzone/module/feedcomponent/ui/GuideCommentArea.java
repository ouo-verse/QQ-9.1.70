package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.CellPokeLike;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.qphone.base.BaseConstants;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GuideCommentArea extends SubArea {
    static final int DEFAULT_BOTTOM;
    static final int DEFAULT_LINE_HEIGHT;
    static final int DEFAULT_LINE_START_X;
    static final int DEFAULT_LINE_START_Y;
    static final int DEFAULT_LINE_WIDTH = 1;
    static final int DEFAULT_RC_BMP_HEIGHT;
    static final int DEFAULT_RC_BMP_WIDTH;
    static final int DEFAULT_RC_LEFT;
    static final int DEFAULT_RC_TOP;
    static final String GUIDE_STR = "\u8bc4\u8bba";
    static final int GUIDE_STR_PADDING_TOP;
    private static final String TAG = "GuideCommentArea";
    static Bitmap doodleBitmap;
    public static Rect iconRect;
    static Bitmap presentIcon;
    static Drawable presentIconDrawable;
    static Bitmap rcBitmap;
    public static final Paint rcPaint;
    static Bitmap rcRedPocketDisable;
    static Bitmap rcRedPocketEnable;
    private String hintText;
    boolean isOnClickRapidComment;
    boolean isPressed;
    private CellPokeLike mCellPokeLike;
    boolean mEnableRedPocket;
    private boolean mIsCommentPokeLike;
    boolean mNeedToShowDoodle;
    boolean mNeedToShowRapidCommentInBox;
    public boolean mNeedToShowRedPocket;
    Bitmap mPolyLikeCountBitmap;
    private PolyLikeCountHolder mPolyLikeHolder;
    String mRedPocketIconUrl;
    boolean mShowGiftIcon;
    private int mTrans;
    private Handler mUiHandler;
    private Paint mWhiteBgPaint;
    Bitmap rcRedPocketUrlIcon;
    static final int DEFAULT_PADDING_LEFT = (int) (FeedGlobalEnv.g().getDensity() * 10.0f);
    static int DEFAULT_RIGHT = AreaManager.SKIN_FEED_INPUT_BOX_BACKGROUND.getBounds().right;
    public int commentIconVisibility = 0;
    private boolean mUseWhiteBgCommentBar = false;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private class PolyLikeCountHolder {
        View itemView;

        /* renamed from: l1, reason: collision with root package name */
        View f48754l1;

        /* renamed from: l2, reason: collision with root package name */
        View f48755l2;
        View l3;
        View list;
        View sep;

        /* renamed from: tv, reason: collision with root package name */
        TextView f48756tv;

        /* renamed from: v1, reason: collision with root package name */
        ImageView f48757v1;

        /* renamed from: v2, reason: collision with root package name */
        ImageView f48758v2;
        ImageView v3;

        public PolyLikeCountHolder(View view) {
            this.itemView = view;
            int O = com.qzone.adapter.feedcomponent.j.O(2879);
            int O2 = com.qzone.adapter.feedcomponent.j.O(2880);
            int O3 = com.qzone.adapter.feedcomponent.j.O(2881);
            int O4 = com.qzone.adapter.feedcomponent.j.O(2882);
            int O5 = com.qzone.adapter.feedcomponent.j.O(2883);
            int O6 = com.qzone.adapter.feedcomponent.j.O(2884);
            int O7 = com.qzone.adapter.feedcomponent.j.O(2885);
            int O8 = com.qzone.adapter.feedcomponent.j.O(BaseConstants.CODE_SERVER_RETURN_ERROR);
            int O9 = com.qzone.adapter.feedcomponent.j.O(BaseConstants.CODE_RESENDMSG);
            this.f48757v1 = (ImageView) this.itemView.findViewById(O);
            this.f48758v2 = (ImageView) this.itemView.findViewById(O2);
            this.v3 = (ImageView) this.itemView.findViewById(O3);
            this.f48754l1 = this.itemView.findViewById(O5);
            this.f48755l2 = this.itemView.findViewById(O6);
            this.l3 = this.itemView.findViewById(O7);
            this.f48756tv = (TextView) this.itemView.findViewById(O4);
            this.sep = this.itemView.findViewById(O9);
            this.list = this.itemView.findViewById(O8);
        }
    }

    static {
        int i3 = AreaManager.SKIN_FEED_INPUT_BOX_BACKGROUND.getBounds().bottom;
        DEFAULT_BOTTOM = i3;
        int a16 = com.qzone.proxy.feedcomponent.util.g.a(4.5f);
        GUIDE_STR_PADDING_TOP = a16;
        int density = (int) (FeedGlobalEnv.g().getDensity() * 29.0f);
        DEFAULT_RC_BMP_WIDTH = density;
        int density2 = (int) (FeedGlobalEnv.g().getDensity() * 29.0f);
        DEFAULT_RC_BMP_HEIGHT = density2;
        int density3 = (DEFAULT_RIGHT + ((int) (FeedGlobalEnv.g().getDensity() * 3.0f))) - density;
        DEFAULT_RC_LEFT = density3;
        DEFAULT_RC_TOP = ((int) ((i3 - density2) * 0.3d)) + a16;
        DEFAULT_LINE_HEIGHT = (int) (FeedGlobalEnv.g().getDensity() * 20.0f);
        int density4 = density3 - ((int) (FeedGlobalEnv.g().getDensity() * 10.0f));
        DEFAULT_LINE_START_X = density4;
        DEFAULT_LINE_START_Y = (int) (FeedGlobalEnv.g().getDensity() * 5.0f);
        int i16 = AreaConst.dp5;
        iconRect = new Rect(density4 - i16, 0, DEFAULT_RIGHT + i16, i3 + i16);
        Paint paint = new Paint();
        rcPaint = paint;
        Drawable drawable = AreaManager.RAPID_COMMENT_IMMEDIATELY_DRAWABLE;
        if (drawable != null) {
            drawable.setBounds(0, 0, density, density2);
        }
        Drawable drawable2 = AreaManager.ADD_PHOTO_DRAWABLE;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, density, density2);
        }
        rcBitmap = FeedGlobalEnv.g().drawableToBitmap(AreaManager.RAPID_COMMENT_IMMEDIATELY_DRAWABLE);
        doodleBitmap = FeedGlobalEnv.g().drawableToBitmap(AreaManager.ADD_PHOTO_DRAWABLE);
        presentIconDrawable = com.qzone.adapter.feedcomponent.j.t();
        presentIcon = FeedGlobalEnv.g().drawableToBitmap(presentIconDrawable);
        paint.setAntiAlias(true);
    }

    public GuideCommentArea() {
        this.mType = 4;
        Paint paint = new Paint();
        this.mWhiteBgPaint = paint;
        paint.setColor(-1);
        this.mUiHandler = new Handler(Looper.getMainLooper());
    }

    private String getEmotionUrlByPos(int i3) {
        String strEmotionByPos;
        ArrayList<String> arrayList;
        CellPokeLike cellPokeLike = this.mCellPokeLike;
        if (cellPokeLike != null && (arrayList = cellPokeLike.emotionList) != null) {
            if (arrayList.size() <= i3) {
                return null;
            }
            strEmotionByPos = this.mCellPokeLike.emotionList.get(i3);
        } else {
            strEmotionByPos = FeedGlobalEnv.g().getStrEmotionByPos(i3 != 1 ? i3 == 2 ? 4 : 1 : 2);
        }
        return FeedGlobalEnv.g().getImgUrlByStrEmotion(strEmotionByPos);
    }

    public static void onConfigurationChanged(Configuration configuration) {
        AreaManager.SKIN_FEED_INPUT_BOX_BACKGROUND.setBounds(0, 0, AreaConst.getCommentWidth(), AreaConst.DEFAULT_GUIDE_HEIGHT);
        DEFAULT_RIGHT = AreaManager.SKIN_FEED_INPUT_BOX_BACKGROUND.getBounds().right;
        Drawable drawable = AreaManager.RAPID_COMMENT_IMMEDIATELY_DRAWABLE;
        int i3 = DEFAULT_RC_BMP_WIDTH;
        int i16 = DEFAULT_RC_BMP_HEIGHT;
        drawable.setBounds(0, 0, i3, i16);
        AreaManager.ADD_PHOTO_DRAWABLE.setBounds(0, 0, i3, i16);
    }

    public static void onThemeChange() {
        Drawable drawable = AreaManager.RAPID_COMMENT_IMMEDIATELY_DRAWABLE;
        int i3 = DEFAULT_RC_BMP_WIDTH;
        int i16 = DEFAULT_RC_BMP_HEIGHT;
        drawable.setBounds(0, 0, i3, i16);
        rcBitmap = FeedGlobalEnv.g().drawableToBitmap(AreaManager.RAPID_COMMENT_IMMEDIATELY_DRAWABLE);
        AreaManager.ADD_PHOTO_DRAWABLE.setBounds(0, 0, i3, i16);
        doodleBitmap = FeedGlobalEnv.g().drawableToBitmap(AreaManager.ADD_PHOTO_DRAWABLE);
        rcPaint.setAntiAlias(true);
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        int width;
        int i3;
        String str;
        if (this.mUseWhiteBgCommentBar) {
            canvas.drawRect(canvas.getClipBounds(), this.mWhiteBgPaint);
        } else {
            Drawable drawable = AreaManager.SKIN_FEED_INPUT_BOX_BACKGROUND;
            if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setColor(com.qzone.adapter.feedcomponent.j.u());
            }
            AreaManager.SKIN_FEED_INPUT_BOX_BACKGROUND.draw(canvas);
        }
        if (paint != null) {
            paint.setColor(com.qzone.adapter.feedcomponent.j.v());
        }
        try {
            if (!TextUtils.isEmpty(this.hintText)) {
                str = this.hintText;
            } else {
                str = GUIDE_STR;
            }
            canvas.drawText(str, DEFAULT_PADDING_LEFT, (AreaConst.DEFAULT_GUIDE_HEIGHT / 2) + GUIDE_STR_PADDING_TOP, paint);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.commentIconVisibility != 0) {
            return true;
        }
        Bitmap bitmap = this.mPolyLikeCountBitmap;
        if (bitmap == null || !this.mIsCommentPokeLike) {
            if (this.mShowGiftIcon) {
                if (presentIconDrawable != com.qzone.adapter.feedcomponent.j.t()) {
                    try {
                        presentIcon.recycle();
                        presentIconDrawable = com.qzone.adapter.feedcomponent.j.t();
                        presentIcon = FeedGlobalEnv.g().drawableToBitmap(presentIconDrawable);
                    } catch (Throwable th5) {
                        com.qzone.proxy.feedcomponent.b.d(TAG, "presentIcon resource changed, but update presentIcon error!", th5);
                    }
                }
                bitmap = presentIcon;
            } else if (this.mNeedToShowRapidCommentInBox) {
                bitmap = rcBitmap;
            } else {
                bitmap = this.mNeedToShowDoodle ? doodleBitmap : null;
            }
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return true;
        }
        if (bitmap == this.mPolyLikeCountBitmap) {
            width = DEFAULT_RIGHT;
            i3 = bitmap.getWidth();
        } else {
            width = (DEFAULT_RIGHT - bitmap.getWidth()) - AreaManager.dp10;
            i3 = AreaManager.f48752dp3;
        }
        canvas.drawBitmap(bitmap, width - i3, DEFAULT_RC_TOP, rcPaint);
        return true;
    }

    public String getContentDescription() {
        if (this.mIsCommentPokeLike) {
            return GUIDE_STR;
        }
        if (this.mShowGiftIcon) {
            return "\u6253\u8d4f";
        }
        if (this.mNeedToShowRedPocket) {
            return "\u7ea2\u5305\u6253\u8d4f";
        }
        if (!this.mNeedToShowRapidCommentInBox || this.commentIconVisibility != 0) {
            return GUIDE_STR;
        }
        return "\u5feb\u8bc4";
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea, com.qzone.module.feedcomponent.ui.ViewArea
    public Object getData() {
        if (this.isOnClickRapidComment && !this.mIsCommentPokeLike) {
            this.isOnClickRapidComment = false;
            if (this.mShowGiftIcon) {
                return FeedElement.AWARD;
            }
            if (this.mNeedToShowDoodle) {
                return FeedElement.ADD_DOODLE_COMMENT;
            }
            if (this.mNeedToShowRedPocket) {
                return FeedElement.RED_POCKET_IMMEDIATELY;
            }
            if (this.mNeedToShowRapidCommentInBox && this.commentIconVisibility == 0) {
                return FeedElement.RAPID_COMMENT_IMMEDIATELY;
            }
            return FeedElement.COMMENT_GUIDE_ITEM;
        }
        return FeedElement.COMMENT_GUIDE_ITEM;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getHeight() {
        return AreaConst.DEFAULT_GUIDE_HEIGHT;
    }

    public RectF getRCRect() {
        int i3 = DEFAULT_LINE_START_X;
        int i16 = AreaConst.dp5;
        return new RectF(i3 - i16, 0.0f, DEFAULT_RIGHT + i16, DEFAULT_BOTTOM + i16);
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getWidth() {
        return 0;
    }

    public boolean hasGuideCommentRedPocketIconUrl() {
        return !TextUtils.isEmpty(this.mRedPocketIconUrl);
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean onTouchEvent(MotionEvent motionEvent, SubAreaShell subAreaShell, boolean z16) {
        if (motionEvent.getAction() == 0) {
            this.isPressed = true;
            return true;
        }
        if (motionEvent.getAction() != 2) {
            if (motionEvent.getAction() == 1) {
                if (this.isPressed && subAreaShell != null) {
                    if (this.commentIconVisibility == 0 && getRCRect().contains(motionEvent.getX(), motionEvent.getY())) {
                        this.isOnClickRapidComment = true;
                    } else {
                        this.isOnClickRapidComment = false;
                    }
                    subAreaShell.onAreaClicked(this, null);
                }
                clearTouchingEvent();
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 4) {
                clearTouchingEvent();
            }
        }
        return false;
    }

    public void setCellPokeLike(CellPokeLike cellPokeLike) {
        this.mCellPokeLike = cellPokeLike;
    }

    public void setCommentPokeLike(boolean z16) {
        this.mIsCommentPokeLike = z16;
    }

    public void setEnableRedPocket(boolean z16) {
        this.mEnableRedPocket = z16;
    }

    public void setGuideCommentRedPocketIconUrl(String str, ImageUrl imageUrl) {
        Drawable loadImage;
        this.mRedPocketIconUrl = str;
        this.rcRedPocketUrlIcon = null;
        if (str == null || (loadImage = ImageLoader.getInstance().loadImage(imageUrl, str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.GuideCommentArea.1
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                if (drawable != null) {
                    Bitmap A0 = com.qzone.adapter.feedcomponent.i.H().A0(drawable, com.qzone.proxy.feedcomponent.util.g.a(20.0f), com.qzone.proxy.feedcomponent.util.g.a(20.0f));
                    if (A0 == null) {
                        A0 = FeedGlobalEnv.g().drawableToBitmap(drawable);
                    }
                    GuideCommentArea guideCommentArea = GuideCommentArea.this;
                    guideCommentArea.rcRedPocketUrlIcon = A0;
                    guideCommentArea.invalidate();
                }
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
            }
        }, null)) == null) {
            return;
        }
        Bitmap A0 = com.qzone.adapter.feedcomponent.i.H().A0(loadImage, com.qzone.proxy.feedcomponent.util.g.a(20.0f), com.qzone.proxy.feedcomponent.util.g.a(20.0f));
        if (A0 == null) {
            A0 = FeedGlobalEnv.g().drawableToBitmap(loadImage);
        }
        this.rcRedPocketUrlIcon = A0;
    }

    public void setHintText(String str) {
        this.hintText = str;
    }

    public void setRapidIconVisibility(int i3) {
        this.commentIconVisibility = i3;
        invalidate();
    }

    public void setShowDoodleIcon(boolean z16) {
        this.mNeedToShowDoodle = z16;
    }

    public void setShowRapidCommentInBox(boolean z16) {
        this.mNeedToShowRapidCommentInBox = z16;
    }

    public void setShowRedPocket(boolean z16) {
        this.mNeedToShowRedPocket = z16;
    }

    public void setTrans(int i3) {
        this.mTrans = i3;
        this.mWhiteBgPaint.setAlpha(i3);
        AreaManager.SKIN_FEED_INPUT_BOX_BACKGROUND.setAlpha(this.mTrans);
    }

    public void setUseWhiteBg(boolean z16) {
        this.mUseWhiteBgCommentBar = z16;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void clearTouchingEvent() {
        this.isPressed = false;
    }

    public void setShowGiftIcon(boolean z16) {
        this.mShowGiftIcon = false;
    }

    private static String getDisplayCount(int i3) {
        if (i3 <= 999) {
            return String.valueOf(i3);
        }
        if (i3 <= 9999) {
            return (i3 / 1000) + "." + ((i3 % 1000) / 100) + "k";
        }
        if (i3 <= 9990000) {
            int i16 = i3 / 10000;
            int i17 = (i3 % 10000) / 1000;
            if (i16 < 10) {
                return i16 + "." + i17 + "w";
            }
            return i16 + "w";
        }
        return "999w+";
    }

    public void setPolyLikeCount(Context context) {
        int i3;
        ImageView imageView;
        View view;
        if (context != null) {
            this.mPolyLikeHolder = new PolyLikeCountHolder(View.inflate(context, com.qzone.adapter.feedcomponent.j.j(1717), null));
        }
        if (this.mPolyLikeHolder == null) {
            return;
        }
        if (com.qzone.adapter.feedcomponent.i.H().p1()) {
            this.mPolyLikeHolder.sep.setBackgroundColor(872415231);
            this.mPolyLikeHolder.f48756tv.setTextColor(-1);
        } else {
            this.mPolyLikeHolder.sep.setBackgroundColor(855836698);
            this.mPolyLikeHolder.f48756tv.setTextColor(-16578534);
        }
        try {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPolyLikeHolder.list.getLayoutParams();
            int i16 = AreaConst.f48746dp1;
            layoutParams.bottomMargin = i16;
            ((LinearLayout.LayoutParams) this.mPolyLikeHolder.f48756tv.getLayoutParams()).bottomMargin = i16;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        for (int i17 = 0; i17 < 3; i17++) {
            if (i17 == 0) {
                PolyLikeCountHolder polyLikeCountHolder = this.mPolyLikeHolder;
                imageView = polyLikeCountHolder.f48757v1;
                view = polyLikeCountHolder.f48754l1;
            } else if (i17 == 1) {
                PolyLikeCountHolder polyLikeCountHolder2 = this.mPolyLikeHolder;
                imageView = polyLikeCountHolder2.f48758v2;
                view = polyLikeCountHolder2.f48755l2;
            } else {
                PolyLikeCountHolder polyLikeCountHolder3 = this.mPolyLikeHolder;
                imageView = polyLikeCountHolder3.v3;
                view = polyLikeCountHolder3.l3;
            }
            String emotionUrlByPos = getEmotionUrlByPos(i17);
            if (emotionUrlByPos == null) {
                view.setVisibility(8);
            } else {
                setPolyLikeDrawable(imageView, view, emotionUrlByPos);
            }
        }
        CellPokeLike cellPokeLike = this.mCellPokeLike;
        if (cellPokeLike != null && (i3 = cellPokeLike.count) > 0) {
            this.mPolyLikeHolder.f48756tv.setText(getDisplayCount(i3));
            this.mPolyLikeHolder.f48756tv.setVisibility(0);
        } else {
            this.mPolyLikeHolder.f48756tv.setVisibility(8);
        }
        this.mPolyLikeHolder.itemView.setDrawingCacheEnabled(true);
        this.mPolyLikeHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        View view2 = this.mPolyLikeHolder.itemView;
        view2.layout(0, 0, view2.getMeasuredWidth(), this.mPolyLikeHolder.itemView.getMeasuredHeight());
        this.mPolyLikeHolder.itemView.buildDrawingCache(true);
        Bitmap bitmap = this.mPolyLikeCountBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mPolyLikeCountBitmap = Bitmap.createBitmap(this.mPolyLikeHolder.itemView.getDrawingCache());
        this.mPolyLikeHolder.itemView.setDrawingCacheEnabled(false);
    }

    private void setPolyLikeDrawable(ImageView imageView, View view, String str) {
        if (imageView == null || str == null) {
            return;
        }
        Drawable loadImageSync = ImageLoader.getInstance().loadImageSync(str);
        if (loadImageSync == null) {
            ImageLoader.getInstance().downloadImageOnly(str, null);
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
            imageView.setImageDrawable(loadImageSync);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
    }
}
