package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.CanvasAvatarArea;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.module.feedcomponent.extend.AlphaGradientProcessor;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.module.feedcomponent.util.CardUtils;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PicText;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoListArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import java.util.List;
import java.util.Map;

/* loaded from: classes39.dex */
public class CanvasFriendPlayingCardView extends QzoneCanvasAreaView {
    private static final String TAG = "FRIENDPLAYING";
    private static Drawable mMaskDrawable;

    @DittoField("bg_logo")
    AsyncCanvasImageArea bgLogo;
    private ImageLoader.Options bgLogoOptions;
    private AvatarAdapter mAvatarAdapter;

    @DittoField("avatars")
    DittoListArea mAvatars;
    private BusinessFeedData mFeedData;
    private int mFeedPosition;

    @DittoField("game_logo")
    AsyncCanvasImageArea mGameLogo;

    @DittoField(CrashRtInfoHolder.BeaconKey.GAME_NAME)
    DittoTextArea mGameName;

    @DittoField("game_rank_text")
    DittoTextArea mGameRankText;
    private int mIndex;

    @DittoField("jump_button")
    DittoButtonArea mJumpButton;
    private PicText mPlayPicText;

    @DittoField("player_counts")
    DittoTextArea mPlayerCounts;

    @DittoField("card_root")
    DittoArea mRoot;

    @DittoField("user_rank_text")
    DittoTextArea mUserRankText;
    private Paint shadowPaint;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class AvatarAdapter implements DittoListArea.ListAreaAdapter {
        protected List<User> userList;

        AvatarAdapter() {
        }

        @Override // com.tencent.ditto.widget.DittoListArea.ListAreaAdapter
        public DittoArea getArea(DittoListArea dittoListArea, int i3, int i16) {
            LayoutAttrSet layoutAttrSet = new LayoutAttrSet();
            int i17 = AreaManager.dp20;
            layoutAttrSet.height = i17;
            layoutAttrSet.width = i17;
            CanvasAvatarArea canvasAvatarArea = new CanvasAvatarArea(CanvasFriendPlayingCardView.this, layoutAttrSet);
            canvasAvatarArea.setBorderColor(j.m());
            canvasAvatarArea.setBorderWidth(AreaManager.f48750dp1);
            canvasAvatarArea.setBorderRadius(AreaManager.dp10);
            canvasAvatarArea.setUser(this.userList.get(i16));
            return canvasAvatarArea;
        }

        @Override // com.tencent.ditto.widget.DittoListArea.ListAreaAdapter
        public int numberOfRows(DittoListArea dittoListArea, int i3) {
            List<User> list = this.userList;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    public CanvasFriendPlayingCardView(Context context) {
        super(context);
        this.mIndex = 0;
        initUI();
    }

    private void initUI() {
        setContentAreaForJsonFile("qzone_canvas_ui_friend_playing_card.json");
        AvatarAdapter avatarAdapter = new AvatarAdapter();
        this.mAvatarAdapter = avatarAdapter;
        this.mAvatars.setAdapter(avatarAdapter);
        this.mAvatars.setItemInterval(-AreaManager.f48750dp1);
        this.mUserRankText.setMaxLines(1);
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        this.bgLogoOptions = obtain;
        obtain.clipWidth = this.bgLogo.getLayoutAttr().width;
        this.bgLogoOptions.clipHeight = this.bgLogo.getLayoutAttr().height;
        this.bgLogoOptions.extraProcessor = new AlphaGradientProcessor();
        Paint paint = new Paint();
        this.shadowPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.shadowPaint.setStrokeWidth(1.0f);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public int getFeedPosition() {
        return this.mFeedPosition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"jump_button", "card_root"})
    public void onClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        PicText picText = this.mPlayPicText;
        if (picText != null && picText.actionUrl != null) {
            this.onFeedElementClickListener.onClick(this, FeedElement.URL, getFeedPosition(), new e(this.mPlayPicText.actionUrl, null, getFeedPosition()));
        }
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || this.mPlayPicText == null || businessFeedData == null || businessFeedData.getOperationInfoV2() == null || this.mFeedData.getOperationInfoV2().feedReportCookie == null) {
            return;
        }
        Map<Integer, String> cloneFeedReportCookieSync = this.mFeedData.getOperationInfoV2().cloneFeedReportCookieSync();
        cloneFeedReportCookieSync.put(17, this.mPlayPicText.actionUrl);
        i.H().A(12, 26, 1, System.currentTimeMillis(), this.mFeedData, this.mFeedPosition, this.mIndex, cloneFeedReportCookieSync);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, android.view.View
    public void onDraw(Canvas canvas) {
        int paddingLeft = CardUtils.CARD_SHADOW_WIDTH_SPACE + getPaddingLeft();
        int i3 = AreaConst.f48746dp1;
        int i16 = CardUtils.CARD_SHADOW_TOP_SPACE;
        RectF rectF = new RectF(paddingLeft + i3, i16 + i3, (getWidth() - getPaddingRight()) - i3, getBottom() - CardUtils.CARD_SHADOW_SIZE);
        float f16 = rectF.top + i16;
        float f17 = rectF.right;
        int i17 = AreaConst.f48748dp3;
        RectF rectF2 = new RectF(0.0f, f16, f17 - i17, rectF.bottom - i16);
        canvas.save();
        Path path = new Path();
        path.addRoundRect(rectF2, 8.0f, 8.0f, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.save();
        canvas.translate(i17, 0.0f);
        super.onDraw(canvas);
        canvas.restore();
        canvas.restore();
        CardUtils.drawCardShadow(canvas, rectF, false, 8, this.shadowPaint);
    }

    @Override // android.view.View
    public void setAlpha(float f16) {
        try {
            this.mRoot.setAlpha(f16);
        } catch (Throwable th5) {
            b.d("Feed", "", th5);
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void setFeedPosition(int i3) {
        this.mFeedPosition = i3;
    }

    public CanvasFriendPlayingCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndex = 0;
        initUI();
    }

    public void setPlayPicText(BusinessFeedData businessFeedData, PicText picText, int i3) {
        PictureUrl pictureUrl;
        this.mPlayPicText = picText;
        this.mFeedData = businessFeedData;
        this.mIndex = i3;
        if (!TextUtils.isEmpty(picText.strHeader)) {
            this.mPlayerCounts.setVisibility(0);
            this.mGameRankText.setVisibility(0);
            this.mAvatars.setVisibility(8);
            this.mUserRankText.setVisibility(8);
            PicText picText2 = this.mPlayPicText;
            if (picText2 != null) {
                this.mPlayerCounts.setText(picText2.strHeader);
                this.mGameRankText.setText(this.mPlayPicText.summary);
            }
        } else {
            this.mPlayerCounts.setVisibility(8);
            this.mGameRankText.setVisibility(8);
            this.mAvatars.setVisibility(0);
            this.mUserRankText.setVisibility(0);
            PicText picText3 = this.mPlayPicText;
            if (picText3 != null) {
                this.mUserRankText.setText(picText3.summary);
                this.mAvatarAdapter.userList = this.mPlayPicText.userList;
            }
            this.mAvatars.reloadRows();
        }
        PicText picText4 = this.mPlayPicText;
        if (picText4 != null) {
            PictureItem pictureItem = picText4.pictureItem;
            if (pictureItem != null && (pictureUrl = pictureItem.currentUrl) != null) {
                AsyncCanvasImageArea asyncCanvasImageArea = this.mGameLogo;
                asyncCanvasImageArea.setAsyncImage(pictureUrl.imageUrl, pictureUrl.url, null, null, asyncCanvasImageArea.getLayoutAttr().width, this.mGameLogo.getLayoutAttr().height);
                AsyncCanvasImageArea asyncCanvasImageArea2 = this.bgLogo;
                PictureUrl pictureUrl2 = this.mPlayPicText.pictureItem.currentUrl;
                asyncCanvasImageArea2.setAsyncImage(pictureUrl2.imageUrl, pictureUrl2.url, null, this.bgLogoOptions, asyncCanvasImageArea2.getLayoutAttr().width, this.bgLogo.getLayoutAttr().height);
            }
            this.mGameName.setText(this.mPlayPicText.title);
            this.mJumpButton.setText(this.mPlayPicText.descBeforeClick);
        }
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2 == null || this.mPlayPicText == null || businessFeedData2 == null || businessFeedData2.getOperationInfoV2() == null || this.mFeedData.getOperationInfoV2().feedReportCookie == null) {
            return;
        }
        Map<Integer, String> cloneFeedReportCookieSync = this.mFeedData.getOperationInfoV2().cloneFeedReportCookieSync();
        cloneFeedReportCookieSync.put(17, this.mPlayPicText.actionUrl);
        i.H().A(12, 26, 19, System.currentTimeMillis(), this.mFeedData, this.mFeedPosition, this.mIndex, cloneFeedReportCookieSync);
        i.H().I1(FeedElement.FRIEND_PLAYING_CARD, this.feedPosition, this.mPlayPicText.actionUrl);
    }
}
