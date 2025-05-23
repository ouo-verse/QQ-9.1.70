package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.h;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.CanvasAvatarArea;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
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
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import java.util.List;
import java.util.Map;

/* loaded from: classes39.dex */
public class CanvasFriendPlayingCardView2 extends QzoneCanvasAreaView {
    private static final String TAG = "FRIENDPLAYING";

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
    private int mIndex;

    @DittoField("jump_button")
    DittoButtonArea mJumpButton;
    private PicText mPlayPicText;

    @DittoField("card_root")
    DittoArea mRoot;

    @DittoField("text_desc")
    DittoTextArea mTextDesc;

    @DittoField("text_title")
    DittoTextArea mTextTitle;
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
            int i17 = AreaManager.dp15;
            layoutAttrSet.height = i17;
            layoutAttrSet.width = i17;
            CanvasAvatarArea canvasAvatarArea = new CanvasAvatarArea(CanvasFriendPlayingCardView2.this, layoutAttrSet);
            canvasAvatarArea.setBorderColor(j.m());
            canvasAvatarArea.setBorderWidth(AreaManager.f48750dp1);
            canvasAvatarArea.setBorderRadius(AreaManager.dp10);
            canvasAvatarArea.setUser(this.userList.get(i16));
            canvasAvatarArea.invalidate();
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

    public CanvasFriendPlayingCardView2(Context context) {
        super(context);
        this.mIndex = 0;
        initUI();
    }

    private void initUI() {
        setContentAreaForJsonFile("qzone_canvas_ui_friend_playing_card2.json");
        AvatarAdapter avatarAdapter = new AvatarAdapter();
        this.mAvatarAdapter = avatarAdapter;
        this.mAvatars.setAdapter(avatarAdapter);
        this.mAvatars.setItemInterval(-AreaManager.f48753dp4);
        this.mTextTitle.setMaxLines(1);
        Paint paint = new Paint();
        this.shadowPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.shadowPaint.setStrokeWidth(1.0f);
        this.mRoot.getLayoutAttr().width = (ViewUtils.getScreenWidth() - (AreaConst.dp5 * 2)) / 3;
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        this.bgLogoOptions = obtain;
        obtain.clipHeight = this.bgLogo.getLayoutAttr().height;
        this.bgLogoOptions.clipWidth = this.bgLogo.getLayoutAttr().width;
        ImageLoader.Options options = this.bgLogoOptions;
        options.priority = false;
        options.imageConfig = Bitmap.Config.ARGB_4444;
        options.preferQuality = false;
    }

    private void setBgPic() {
        PictureItem pictureItem;
        PicText picText = this.mPlayPicText;
        String str = (picText == null || (pictureItem = picText.pictureItem) == null) ? null : pictureItem.miniGameBgUrl;
        if (i.H().p1()) {
            if ((h.b("QZoneSetting", "FeedFriendPlayingCardUseSpecifyImageInNight", 1) == 1) || str == null) {
                int i3 = this.mIndex;
                str = i3 == 0 ? "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/feed/night/friend_playing_bg1.png" : i3 == 1 ? "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/feed/night/friend_playing_bg2.png" : "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/feed/night/friend_playing_bg3.png";
            }
        } else if (str == null) {
            int i16 = this.mIndex;
            str = i16 == 0 ? "https://qzonestyle.gtimg.cn/aoi/sola/20190822155743_kLBbr2frKw.png" : i16 == 1 ? "https://qzonestyle.gtimg.cn/aoi/sola/20190822155743_9QVXdic7OM.png" : "https://qzonestyle.gtimg.cn/aoi/sola/20190822155743_pnCMKtwc5H.png";
        }
        this.bgLogo.setAsyncImage(null, str, null, this.bgLogoOptions);
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
        RectF rectF = new RectF(paddingLeft + i3, i3 + i16, getWidth() - getPaddingRight(), getBottom() - CardUtils.CARD_SHADOW_SIZE);
        RectF rectF2 = new RectF(0.0f, rectF.top + i16, rectF.right - AreaConst.f48748dp3, rectF.bottom - i16);
        canvas.save();
        Path path = new Path();
        path.addRoundRect(rectF2, 12.0f, 12.0f, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        canvas.restore();
        CardUtils.drawCardShadow(canvas, rectF, false, 12, this.shadowPaint);
    }

    @Override // android.view.View
    public void setAlpha(float f16) {
        try {
            this.mRoot.setAlpha(f16);
        } catch (Throwable th5) {
            b.d("Feed", "", th5);
        }
    }

    public void setData(BusinessFeedData businessFeedData, PicText picText, int i3) {
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        this.mPlayPicText = picText;
        this.mFeedData = businessFeedData;
        this.mIndex = i3;
        if (!TextUtils.isEmpty(picText.strHeader)) {
            this.mTextTitle.setVisibility(0);
            this.mTextDesc.setVisibility(0);
            this.mAvatars.setVisibility(8);
            PicText picText2 = this.mPlayPicText;
            if (picText2 != null) {
                this.mTextTitle.setText(picText2.strHeader);
                this.mTextDesc.setText(this.mPlayPicText.summary);
            }
        } else {
            this.mTextDesc.setVisibility(8);
            this.mAvatars.setVisibility(0);
            this.mTextTitle.setVisibility(0);
            PicText picText3 = this.mPlayPicText;
            if (picText3 != null) {
                this.mTextTitle.setText(picText3.summary);
                this.mAvatarAdapter.userList = this.mPlayPicText.userList;
            }
            this.mAvatars.reloadRows();
        }
        PicText picText4 = this.mPlayPicText;
        if (picText4 != null && (pictureItem = picText4.pictureItem) != null && (pictureUrl = pictureItem.currentUrl) != null) {
            AsyncCanvasImageArea asyncCanvasImageArea = this.mGameLogo;
            asyncCanvasImageArea.setAsyncImage(pictureUrl.imageUrl, pictureUrl.url, null, null, asyncCanvasImageArea.getLayoutAttr().width, this.mGameLogo.getLayoutAttr().height);
        }
        setBgPic();
        PicText picText5 = this.mPlayPicText;
        if (picText5 != null) {
            this.mGameName.setText(picText5.title, 8, MiniBoxNoticeInfo.APPNAME_SUFFIX);
            this.mJumpButton.setText(this.mPlayPicText.descBeforeClick);
        }
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2 == null || this.mPlayPicText == null || businessFeedData2 == null || businessFeedData2.getOperationInfoV2() == null || this.mFeedData.getOperationInfoV2().feedReportCookie == null) {
            return;
        }
        Map<Integer, String> cloneFeedReportCookieSync = this.mFeedData.getOperationInfoV2().cloneFeedReportCookieSync();
        cloneFeedReportCookieSync.put(17, this.mPlayPicText.actionUrl);
        i.H().A(12, 26, 19, System.currentTimeMillis(), this.mFeedData, this.mFeedPosition, this.mIndex, cloneFeedReportCookieSync);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void setFeedPosition(int i3) {
        this.mFeedPosition = i3;
    }

    public CanvasFriendPlayingCardView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndex = 0;
        initUI();
    }
}
