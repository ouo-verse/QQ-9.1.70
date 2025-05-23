package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.canvasui.widget.TagImageArea;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellLeftThumb;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.text.ColorTextCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.UrlCell;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasLeftThumbView extends QzoneCanvasAreaView {
    private static final int COLOR_T1 = j.o();
    private static final int COLOR_T2 = j.F();
    private static Drawable PASSIVE_FEED_SHADOW_BG = j.g(915);
    private boolean isPassive;

    @DittoField
    RichCanvasTextArea left_thumb_content;

    @DittoField
    TagImageArea left_thumb_image;

    @DittoField
    DittoAreaGroup left_thumb_right_root;

    @DittoField
    DittoAreaGroup left_thumb_root;

    @DittoField
    RichCanvasTextArea left_thumb_title;
    private BusinessFeedData mFeedData;
    private CellLeftThumb mLeftThumbData;

    @DittoField
    DittoAreaGroup root_bg;

    @DittoField
    DittoArea shadow;

    @DittoField
    DittoArea tag_container;

    public CanvasLeftThumbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isPassive = false;
        setContentAreaForJsonFile("qzone_canvas_ui_leftthumb_new.json");
    }

    public static int getLeftThumbImageSize() {
        return ViewUtils.getScreenWidth() / 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"left_thumb_root", "left_thumb_title", "left_thumb_content", "left_thumb_image"})
    public void onCanvasAreaClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        FeedElement feedElement;
        b.c("CANVASLOG", "onCanvasAreaClicked " + dittoArea.getId());
        g gVar = this.onFeedElementClickListener;
        if (gVar == null) {
            return;
        }
        if (obj != null && (obj instanceof TextCell)) {
            TextCell textCell = (TextCell) obj;
            if (textCell instanceof UserNameCell) {
                BusinessFeedData businessFeedData = this.mFeedData;
                if (businessFeedData != null && businessFeedData.isGDTAdvFeed() && this.mFeedData.feedType == 4098) {
                    this.onFeedElementClickListener.onClick(this, FeedElement.LEFT_THUMB_VIEW_NICKNAME, this.feedPosition, ((UserNameCell) textCell).getUin());
                    return;
                } else {
                    this.onFeedElementClickListener.onClick(this, FeedElement.FRIEND_NICKNAME, this.feedPosition, ((UserNameCell) textCell).getUin());
                    return;
                }
            }
            if ((textCell instanceof UrlCell) || (textCell instanceof ColorTextCell)) {
                UrlCell urlCell = (UrlCell) obj;
                if (urlCell.getAction() == 2) {
                    g gVar2 = this.onFeedElementClickListener;
                    FeedElement feedElement2 = FeedElement.LEFT_THUMB;
                    int i3 = this.feedPosition;
                    gVar2.onClick(this, feedElement2, i3, Integer.valueOf(i3));
                    return;
                }
                this.onFeedElementClickListener.onClick(this, FeedElement.URL, this.feedPosition, new e(urlCell.getUrl(), urlCell.post, this.feedPosition));
                return;
            }
            return;
        }
        if (dittoArea == this.left_thumb_image) {
            feedElement = FeedElement.LEFT_THUMB_PIC;
        } else {
            feedElement = FeedElement.LEFT_THUMB;
        }
        gVar.onClick(this, feedElement, this.feedPosition, this.mLeftThumbData);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, android.view.View
    protected void onDraw(Canvas canvas) {
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

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        this.mLeftThumbData = null;
        this.mFeedData = null;
        TagImageArea tagImageArea = this.left_thumb_image;
        if (tagImageArea != null) {
            tagImageArea.onRecycled();
        }
        RichCanvasTextArea richCanvasTextArea = this.left_thumb_title;
        if (richCanvasTextArea != null) {
            richCanvasTextArea.onRecycled();
        }
        RichCanvasTextArea richCanvasTextArea2 = this.left_thumb_content;
        if (richCanvasTextArea2 != null) {
            richCanvasTextArea2.onRecycled();
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void setAlpha(int i3) {
        int b16 = com.qzone.proxy.feedcomponent.util.g.b(i3);
        this.mTrans = b16;
        super.setAlpha(b16);
        this.left_thumb_right_root.setAlpha(this.mTrans);
        DittoAreaGroup dittoAreaGroup = this.root_bg;
        if (dittoAreaGroup != null) {
            dittoAreaGroup.setAlpha(this.mTrans);
        }
    }

    public void setFeedData(BusinessFeedData businessFeedData, CellLeftThumb cellLeftThumb, FeedPictureInfo feedPictureInfo) {
        int i3;
        CellLeftThumb leftThumb;
        if (businessFeedData != null) {
            this.isPassive = businessFeedData.feedType == 4098;
        }
        boolean z16 = (businessFeedData == null || businessFeedData.getCellSummaryV2() == null || TextUtils.isEmpty(businessFeedData.getCellSummaryV2().displayStr)) ? false : true;
        if (!this.isPassive) {
            setContentAreaForJsonFile("qzone_canvas_ui_leftthumb_new.json");
            int leftThumbImageSize = getLeftThumbImageSize();
            TagImageArea tagImageArea = this.left_thumb_image;
            if (tagImageArea != null) {
                tagImageArea.getLayoutAttr().height = leftThumbImageSize;
                this.left_thumb_image.getLayoutAttr().width = leftThumbImageSize;
            }
            this.left_thumb_right_root.getLayoutAttr().height = leftThumbImageSize;
            this.tag_container.getLayoutAttr().height = leftThumbImageSize;
            LayoutAttrSet layoutAttr = this.shadow.getLayoutAttr();
            int i16 = AreaConst.dp6;
            layoutAttr.height = leftThumbImageSize + i16;
            this.left_thumb_title.setTextBold(true);
            this.shadow.setShadowDrawable(j.G());
            this.shadow.setShadowSize(AreaConst.dp5, AreaConst.dp3_75, i16, AreaConst.f48749dp4);
            this.root_bg.setBackgroundColor(j.E());
            DittoAreaGroup dittoAreaGroup = this.root_bg;
            if (feedPictureInfo == null) {
                leftThumbImageSize = AreaConst.dp10;
            }
            dittoAreaGroup.setPadding(leftThumbImageSize, 0, 0, 0);
        } else if (i.H().k1()) {
            setContentAreaForJsonFile("qzone_canvas_ui_leftthumb.json");
            this.shadow.setBackgroundDrawable(PASSIVE_FEED_SHADOW_BG);
            this.left_thumb_right_root.setBackgroundColor(j.m());
            DittoAreaGroup dittoAreaGroup2 = this.left_thumb_root;
            int i17 = AreaConst.f48746dp1;
            dittoAreaGroup2.setPadding(-i17, z16 ? i17 : 0, -i17, AreaConst.dp2_5);
        } else {
            setContentAreaForJsonFile("qzone_canvas_ui_leftthumb_old.json");
            this.left_thumb_right_root.setBackgroundColor(j.E());
            DittoAreaGroup dittoAreaGroup3 = this.left_thumb_root;
            if (z16) {
                i3 = AreaConst.dp7;
            } else {
                i3 = AreaConst.f48749dp4;
            }
            dittoAreaGroup3.setPadding(0, i3, 0, AreaConst.dp5);
        }
        if (cellLeftThumb != null) {
            leftThumb = cellLeftThumb;
        } else {
            leftThumb = businessFeedData != null ? businessFeedData.getLeftThumb() : null;
        }
        this.mLeftThumbData = leftThumb;
        this.mFeedData = businessFeedData;
        if (businessFeedData != null && leftThumb != null) {
            setVisibility(0);
            this.left_thumb_right_root.setAlpha(this.mTrans);
            String parseTitle = this.mLeftThumbData.getParseTitle();
            String parseSummary = this.mLeftThumbData.getParseSummary();
            if (feedPictureInfo != null && this.left_thumb_image != null) {
                ImageLoader.Options obtain = ImageLoader.Options.obtain();
                obtain.extraProcessor = feedPictureInfo.c();
                LayoutAttrSet layoutAttr2 = this.left_thumb_image.getLayoutAttr();
                if (layoutAttr2 != null) {
                    obtain.extraProcessor = new NormalFeedImageProcessor(layoutAttr2.width, layoutAttr2.height, 0.5f, 0.5f);
                }
                this.left_thumb_image.setVisibility(0);
                PictureUrl h16 = feedPictureInfo.h();
                String str = h16 != null ? h16.url : null;
                if (str != null && str.startsWith("avatar://")) {
                    this.left_thumb_image.setAvatarUrl(str, obtain, AreaManager.IMAGE_BACKGROUND);
                } else {
                    this.left_thumb_image.setImage(feedPictureInfo, this.mLeftThumbData.getQQMusicId(), this.mLeftThumbData.getPicActionUrl(), AreaManager.IMAGE_BACKGROUND, obtain);
                }
                this.left_thumb_image.setContentDescription("\u56fe\u7247");
            } else {
                TagImageArea tagImageArea2 = this.left_thumb_image;
                if (tagImageArea2 != null) {
                    tagImageArea2.setVisibility(8);
                    this.left_thumb_image.setContentDescription("");
                }
            }
            if (!TextUtils.isEmpty(parseTitle)) {
                this.left_thumb_title.setVisibility(0);
                this.left_thumb_content.setAreaCacheKey(this.mLeftThumbData.integerUniTitle);
                this.left_thumb_title.setTextColor(j.o());
                this.left_thumb_title.setText(parseTitle);
                this.left_thumb_title.setContentDescription(parseTitle);
            } else {
                this.left_thumb_title.setVisibility(8);
                this.left_thumb_title.setContentDescription("");
            }
            this.left_thumb_title.setMaxLines(2);
            if (!TextUtils.isEmpty(parseSummary)) {
                this.left_thumb_content.setVisibility(0);
                this.left_thumb_content.setAreaCacheKey(this.mLeftThumbData.integerUniSummary);
                this.left_thumb_content.setFont(this.mLeftThumbData.getFontId(false), this.mLeftThumbData.getFontUrl(false), this.mLeftThumbData.getFontType(false));
                this.left_thumb_content.setTextEffect(this.mLeftThumbData.getSuperFontInfo(false));
                if (TextUtils.isEmpty(parseTitle)) {
                    this.left_thumb_content.setTextColor(j.o());
                } else if (this.isPassive) {
                    this.left_thumb_content.setTextColor(Color.parseColor("#cccccc"));
                } else {
                    this.left_thumb_content.setTextColor(COLOR_T2);
                }
                if (!this.isPassive) {
                    this.left_thumb_content.setTextColor(j.o());
                }
                this.left_thumb_content.setMaxLines(TextUtils.isEmpty(parseTitle) ? 2 : 1);
                this.left_thumb_content.setText(parseSummary);
                this.left_thumb_content.setContentDescription(parseSummary);
            } else {
                this.left_thumb_content.setVisibility(8);
                this.left_thumb_content.setContentDescription("");
            }
            updateAccessibility();
            return;
        }
        setVisibility(8);
    }
}
