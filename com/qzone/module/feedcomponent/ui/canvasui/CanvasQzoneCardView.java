package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.h;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.module.feedcomponent.ui.AvatarArea;
import com.qzone.module.feedcomponent.ui.FeedChildView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellShareCard;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.UserMedal;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.proxy.feedcomponent.util.d;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasQzoneCardView extends QzoneCanvasAreaView implements FeedChildView {
    public static final Drawable DEFAULT_AVATAR = AvatarArea.DEFAULT_AVATAR;
    public static FeedViewSection.SectionController QzoneCardController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasQzoneCardView.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            if (businessFeedData == null) {
                return true;
            }
            if (businessFeedData.isQzoneCardFeed()) {
                return false;
            }
            return !businessFeedData.isCampusHomeShareFeed() || businessFeedData.cellShareCard == null;
        }
    };
    private static String comeToPlayText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ComeToPlayWithMe", "\u6765\u7a7a\u95f4\u548c\u6211\u4e00\u8d77\u73a9\u800d\u5427~");
    public final int BTN_NORMAL_COLOR;
    public final int BTN_PRESSED_BORDER_COLOR;
    private ImageLoader.Options campusAvatarBgOptions;
    private BusinessFeedData feedData;
    private boolean isFollowBtn;
    private boolean isFriendAdded;
    private String mCardUniKey;

    @DittoField
    AsyncCanvasImageArea qzone_card_avatar;

    @DittoField
    AsyncCanvasImageArea qzone_card_avatar_bg;

    @DittoField
    DittoImageArea qzone_card_bg;

    @DittoField
    LinearAreaLayout qzone_card_center_container;

    @DittoField
    RichCanvasTextArea qzone_card_desc;

    @DittoField
    DittoArea qzone_card_divider;

    @DittoField
    AsyncCanvasImageArea qzone_card_famousspace_icon;

    @DittoField
    DittoTextArea qzone_card_fans;

    @DittoField
    DittoTextArea qzone_card_fans_desc;

    @DittoField
    DittoButtonArea qzone_card_follow_button;

    @DittoField
    LinearAreaLayout qzone_card_left_container;

    @DittoField
    RichCanvasTextArea qzone_card_nickname;

    @DittoField
    LinearAreaLayout qzone_card_right_container;

    @DittoField
    RelativeAreaLayout qzone_card_root_container;

    @DittoField
    DittoTextArea qzone_card_visitor;

    @DittoField
    DittoTextArea qzone_card_visitor_desc;
    private User user;

    public CanvasQzoneCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isFollowBtn = true;
        this.isFriendAdded = false;
        this.BTN_NORMAL_COLOR = Color.parseColor("#ffca00");
        this.BTN_PRESSED_BORDER_COLOR = Color.parseColor("#d0d1d2");
        this.mCardUniKey = null;
        this.campusAvatarBgOptions = null;
    }

    private void setFollowBtnColor(int i3, int i16) {
        DittoButtonArea dittoButtonArea = this.qzone_card_follow_button;
        if (dittoButtonArea != null) {
            dittoButtonArea.setBackgroundColor(i3);
            this.qzone_card_follow_button.setBorderColor(i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"qzone_card_follow_button", "qzone_card_avatar", "qzone_card_root_container", "qzone_card_nickname", "qzone_card_desc"})
    public void onCanvasAreaClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        g gVar = this.onFeedElementClickListener;
        if (gVar == null) {
            return;
        }
        if (this.qzone_card_follow_button == dittoArea) {
            if (this.isFollowBtn) {
                gVar.onClick(this, FeedElement.FORWARD_FOLLOW, this.feedPosition, null);
                return;
            } else {
                if (this.isFriendAdded) {
                    return;
                }
                gVar.onClick(this, FeedElement.FEED_QZONE_CARD_ADD_FRIEND, this.feedPosition, null);
                return;
            }
        }
        BusinessFeedData businessFeedData = this.feedData;
        if (businessFeedData != null && businessFeedData.isCampusHomeShareFeed()) {
            g gVar2 = this.onFeedElementClickListener;
            FeedElement feedElement = FeedElement.SHAREDCARD;
            int i3 = this.feedPosition;
            gVar2.onClick(this, feedElement, i3, Integer.valueOf(i3));
            return;
        }
        this.onFeedElementClickListener.onClick(this, FeedElement.QZONE_CARD, this.feedPosition, this.user);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ditto.DittoAreaView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ditto.DittoAreaView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void reset() {
        super.reset();
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void setAlpha(int i3) {
        int b16 = com.qzone.proxy.feedcomponent.util.g.b(i3);
        this.mTrans = b16;
        super.setAlpha(b16);
        Drawable n3 = j.n();
        if (n3 != null) {
            n3.setAlpha(this.mTrans);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        this.feedData = businessFeedData;
        update();
    }

    public void update() {
        boolean z16;
        g gVar;
        g gVar2;
        int i3;
        setContentAreaForJsonFile("qzone_canvas_ui_qzonecard.json");
        BusinessFeedData businessFeedData = this.feedData;
        if (businessFeedData != null && businessFeedData.isCampusHomeShareFeed()) {
            updateCampus();
            return;
        }
        setVisibility(0);
        this.qzone_card_left_container.getLayoutAttr().leftMargin = AreaManager.dp21;
        this.qzone_card_center_container.getLayoutAttr().leftMargin = AreaManager.dp8;
        BusinessFeedData businessFeedData2 = this.feedData;
        if (businessFeedData2 != null) {
            this.user = businessFeedData2.getOriginalInfo().getUser();
        }
        this.qzone_card_avatar.setDrawCircleBorder(true);
        AsyncCanvasImageArea asyncCanvasImageArea = this.qzone_card_avatar;
        asyncCanvasImageArea.setAvatar(this.user.uin, AreaConst.dp50 - (asyncCanvasImageArea.getBorderWidth() * 2), DEFAULT_AVATAR);
        UserMedal userMedal = this.user.famousSpaceMedal;
        if (userMedal != null && !TextUtils.isEmpty(userMedal.picUrl)) {
            User user = this.user;
            byte b16 = user.vipShowType;
            if (b16 != 4 && b16 != 8) {
                i3 = AsyncCanvasImageArea.DEFAULT_RIGHT_ICON_HEIGHT;
            } else {
                i3 = AsyncCanvasImageArea.DEFAULT_FAMOUS_ICON_HEIGHT;
            }
            AsyncCanvasImageArea asyncCanvasImageArea2 = this.qzone_card_avatar;
            UserMedal userMedal2 = user.famousSpaceMedal;
            asyncCanvasImageArea2.setRightCornerIcon(userMedal2.imageUrl, userMedal2.picUrl, i3);
        } else {
            this.qzone_card_avatar.setRightCornerIcon(null, null);
        }
        this.qzone_card_nickname.setMaxLines(1);
        this.qzone_card_nickname.setTextBold(false);
        this.qzone_card_nickname.setVisibility(0);
        this.qzone_card_nickname.setText(this.user.nickName);
        this.qzone_card_desc.setTextColor(j.o());
        this.qzone_card_desc.setVisibility(0);
        if (!TextUtils.isEmpty(this.user.qzoneDesc)) {
            this.qzone_card_desc.setText(this.user.qzoneDesc);
        } else {
            this.qzone_card_desc.setText(comeToPlayText);
        }
        this.qzone_card_right_container.setVisibility(0);
        if (this.user.fansCount > 0) {
            this.qzone_card_fans.setVisibility(0);
            this.qzone_card_fans_desc.setVisibility(0);
            this.qzone_card_fans.setText(getCountDesc(this.user.fansCount));
            this.qzone_card_fans.setTypeface(null, 1);
        } else {
            this.qzone_card_fans_desc.setVisibility(8);
            this.qzone_card_fans.setVisibility(8);
        }
        long j3 = this.user.visitorCount;
        if (j3 > 0) {
            this.qzone_card_visitor.setText(getCountDesc(j3));
            this.qzone_card_visitor.setVisibility(0);
            this.qzone_card_visitor_desc.setVisibility(0);
            this.qzone_card_visitor.setTypeface(null, 1);
        } else {
            this.qzone_card_visitor.setVisibility(8);
            this.qzone_card_visitor_desc.setVisibility(8);
        }
        User user2 = this.user;
        if (user2.fansCount == 0 && user2.visitorCount == 0 && user2.uin == i.H().j0()) {
            this.qzone_card_divider.setVisibility(8);
        } else {
            this.qzone_card_divider.setVisibility(0);
        }
        if (this.feedData != null) {
            if (TextUtils.isEmpty(this.mCardUniKey) || !this.mCardUniKey.equals(this.feedData.getFeedCommInfo().feedskey)) {
                this.mCardUniKey = this.feedData.getFeedCommInfo().feedskey;
                z16 = true;
            } else {
                z16 = false;
            }
            long j16 = this.feedData.getOriginalInfo().getFeedCommInfo().operatemask;
            if (!d.j(j16, 27) && !d.j(j16, 20)) {
                this.isFollowBtn = false;
                if (d.j(this.feedData.getOriginalInfo().getFeedCommInfo().operatemask2, 7)) {
                    this.isFriendAdded = false;
                    this.qzone_card_follow_button.setVisibility(0);
                    this.qzone_card_follow_button.setText("\u52a0\u597d\u53cb");
                    int i16 = this.BTN_NORMAL_COLOR;
                    setFollowBtnColor(i16, i16);
                    if (z16 && (gVar2 = this.onFeedElementClickListener) != null) {
                        gVar2.onClick(this, FeedElement.FEED_QZONE_CARD_ADDFRIEND_BTN_EXPOSE, this.feedPosition, null);
                    }
                } else {
                    this.isFriendAdded = true;
                    if (this.user.uin == i.H().j0()) {
                        this.qzone_card_follow_button.setVisibility(8);
                    } else {
                        this.qzone_card_follow_button.setVisibility(0);
                        this.qzone_card_follow_button.setText("\u5df2\u6dfb\u52a0");
                        setFollowBtnColor(j.B(), this.BTN_PRESSED_BORDER_COLOR);
                    }
                }
            } else {
                boolean z17 = this.feedData.getOriginalInfo().getFeedCommInfo().isFollowed;
                this.isFollowBtn = true;
                this.qzone_card_follow_button.setVisibility(0);
                if (z17) {
                    this.qzone_card_follow_button.setText("\u5df2\u5173\u6ce8");
                    setFollowBtnColor(j.B(), this.BTN_PRESSED_BORDER_COLOR);
                } else {
                    this.qzone_card_follow_button.setText("\u5173\u6ce8");
                    int i17 = this.BTN_NORMAL_COLOR;
                    setFollowBtnColor(i17, i17);
                }
                if (z16 && (gVar = this.onFeedElementClickListener) != null) {
                    gVar.onClick(this, FeedElement.FEED_QZONE_CARD_FOLLOW_BTN_EXPOSE, this.feedPosition, null);
                }
            }
        }
        this.qzone_card_bg.setBackgroundDrawable(j.n());
        this.qzone_card_famousspace_icon.setVisibility(8);
        this.qzone_card_avatar_bg.setAsyncImage(null, "https://qzonestyle.gtimg.cn/aoi/sola/20170904163718_wDdesSPzAR.png", null, null);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
        this.mScrollState = 2;
    }

    public void updateCampus() {
        setVisibility(0);
        LayoutAttrSet layoutAttr = this.qzone_card_left_container.getLayoutAttr();
        int i3 = AreaManager.f48750dp1;
        layoutAttr.leftMargin = i3 * 33;
        this.qzone_card_center_container.getLayoutAttr().leftMargin = i3 * 41;
        this.qzone_card_avatar.setDrawCircleBorder(true);
        AsyncCanvasImageArea asyncCanvasImageArea = this.qzone_card_avatar;
        CellShareCard cellShareCard = this.feedData.cellShareCard;
        asyncCanvasImageArea.setAvatarUrl(cellShareCard.portraitImageUrl, cellShareCard.portrait, AreaConst.dp50 - (asyncCanvasImageArea.getBorderWidth() * 2), DEFAULT_AVATAR);
        this.qzone_card_nickname.setMaxLines(1);
        this.qzone_card_nickname.setTextBold(true);
        this.qzone_card_nickname.setVisibility(0);
        this.qzone_card_nickname.setText(this.feedData.cellShareCard.nick);
        b.e("Feed", "Campus nickname:" + this.feedData.cellShareCard.nick);
        this.qzone_card_desc.setTextColor(j.F());
        this.qzone_card_desc.setVisibility(0);
        if (!TextUtils.isEmpty(this.feedData.cellShareCard.share_content)) {
            this.qzone_card_desc.setText(this.feedData.cellShareCard.share_content);
        }
        this.qzone_card_right_container.setVisibility(8);
        this.qzone_card_bg.setBackgroundDrawable(j.n());
        if (this.feedData.cellShareCard.userType == 1) {
            this.qzone_card_famousspace_icon.setImageDrawable(j.g(711));
            this.qzone_card_famousspace_icon.setVisibility(0);
        } else {
            this.qzone_card_famousspace_icon.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.feedData.cellShareCard.pic_url)) {
            return;
        }
        if (this.campusAvatarBgOptions == null) {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            this.campusAvatarBgOptions = obtain;
            int i16 = AreaConst.f48746dp1;
            obtain.clipWidth = i16 * 105;
            obtain.clipHeight = i16 * 105;
            ImageLoader.Options options = this.campusAvatarBgOptions;
            NormalFeedImageProcessor normalFeedImageProcessor = new NormalFeedImageProcessor(options.clipWidth, options.clipHeight, 0.5f, 0.5f);
            normalFeedImageProcessor.setDefaultScaleType(10);
            this.campusAvatarBgOptions.extraProcessor = normalFeedImageProcessor;
        }
        AsyncCanvasImageArea asyncCanvasImageArea2 = this.qzone_card_avatar_bg;
        CellShareCard cellShareCard2 = this.feedData.cellShareCard;
        asyncCanvasImageArea2.setAsyncImage(cellShareCard2.imageUrl, cellShareCard2.pic_url, null, this.campusAvatarBgOptions);
    }

    private String getCountDesc(long j3) {
        if (j3 < 10000) {
            return "" + j3;
        }
        if (j3 < 10000000) {
            return (j3 / 10000) + "\u4e07";
        }
        if (j3 < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            return (j3 / 10000000) + "\u5343\u4e07";
        }
        return (j3 / SafeBitmapFactory.PX_THRESHOID_DEFAULTS) + "\u4ebf";
    }

    public void updateFriendUI() {
    }
}
