package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.CanvasAvatarArea;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.module.feedcomponent.ui.FeedChildView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellShareCard;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.luggage.wxa.q2.d;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CampusShardCardView extends QzoneCanvasAreaView implements FeedChildView {

    @DittoField
    RichCanvasTextArea answer_count;

    @DittoField
    RichCanvasTextArea answer_info;

    @DittoField
    CanvasAvatarArea avatar;

    @DittoField
    AsyncCanvasImageArea background;

    @DittoField
    AsyncCanvasImageArea cover;
    private ImageLoader.Options mBackgroundOptions;
    private Drawable mDefaultBackground;
    private CellShareCard mShareCard;

    @DittoField
    AsyncCanvasImageArea module_img;

    @DittoField
    RichCanvasTextArea module_name;

    @DittoField
    RichCanvasTextArea read_count;

    @DittoField
    RichCanvasTextArea read_info;

    @DittoField
    RichCanvasTextArea share_desc;

    @DittoField
    LinearAreaLayout share_module_layout;

    @DittoField
    RelativeAreaLayout sharecard_root;

    @DittoField
    RichCanvasTextArea title;
    private static Drawable mModuleDrawable = j.g(d.CTRL_INDEX);
    public static FeedViewSection.SectionController CampusCardController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CampusShardCardView.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            CellShareCard cellShareCard;
            return businessFeedData == null || (cellShareCard = businessFeedData.cellShareCard) == null || cellShareCard.type == 4;
        }
    };

    public CampusShardCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDefaultBackground = new ColorDrawable(j.m());
        setContentAreaForJsonFile("qzone_canvas_ui_campus_share_card.json");
    }

    private static Drawable getModuleDrawable() {
        Drawable drawable = mModuleDrawable;
        if (drawable != null) {
            return drawable;
        }
        Drawable g16 = j.g(d.CTRL_INDEX);
        mModuleDrawable = g16;
        return g16;
    }

    private void setTitleAndModule() {
        if (!TextUtils.isEmpty(this.mShareCard.content)) {
            this.title.setVisibility(0);
            int i3 = this.mShareCard.content_line;
            if (i3 > 0) {
                this.title.setMaxLines(i3);
                this.title.setTextSize(this.mShareCard.content_TextSize);
            }
            if (!TextUtils.isEmpty(this.mShareCard.contentAreaKey)) {
                this.title.setAreaCacheKey(this.mShareCard.integerContentAreaKey);
            }
            this.title.setText(this.mShareCard.content);
        } else {
            this.title.setVisibility(8);
        }
        if (this.mShareCard.type == 3) {
            this.share_module_layout.setVisibility(0);
            this.module_img.setImageDrawable(getModuleDrawable());
            if (TextUtils.isEmpty(this.mShareCard.school_name) && TextUtils.isEmpty(this.mShareCard.module_name)) {
                this.module_name.setVisibility(8);
                return;
            }
            this.module_name.setVisibility(0);
            this.module_name.setText("#" + this.mShareCard.module_name + "#");
            return;
        }
        this.share_module_layout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"sharecard_root", "avatar"})
    public void onCanvasAreaClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        b.c("CANVASLOG", "onCanvasAreaClicked " + dittoArea.getId());
        g gVar = this.onFeedElementClickListener;
        if (gVar == null) {
            return;
        }
        if (dittoArea == this.sharecard_root) {
            FeedElement feedElement = FeedElement.SHAREDCARD;
            int i3 = this.feedPosition;
            gVar.onClick(this, feedElement, i3, Integer.valueOf(i3));
        } else if (dittoArea == this.avatar) {
            FeedElement feedElement2 = FeedElement.USER_AVATAR;
            int i16 = this.feedPosition;
            CellShareCard cellShareCard = this.mShareCard;
            gVar.onClick(this, feedElement2, i16, Long.valueOf(cellShareCard != null ? cellShareCard.uin : 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        this.mShareCard = null;
        setVisibility(8);
    }

    public static void clearImgCache() {
        mModuleDrawable = null;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.cellShareCard == null) {
            return;
        }
        setVisibility(0);
        this.mShareCard = businessFeedData.cellShareCard;
        setContentAreaForJsonFile("qzone_canvas_ui_campus_share_card.json");
        b.i("Feed", "CampusShardCardView pic_url:" + this.mShareCard.pic_url);
        if (this.mBackgroundOptions == null) {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            this.mBackgroundOptions = obtain;
            obtain.clipWidth = FeedGlobalEnv.g().getScreenWidth() - (AreaManager.dp10 * 2);
            this.mBackgroundOptions.clipHeight = AreaManager.dp20 * 10;
            ImageLoader.Options options = this.mBackgroundOptions;
            NormalFeedImageProcessor normalFeedImageProcessor = new NormalFeedImageProcessor(options.clipWidth, options.clipHeight, 0.5f, 0.5f);
            normalFeedImageProcessor.setDefaultScaleType(10);
            this.mBackgroundOptions.extraProcessor = normalFeedImageProcessor;
        }
        ColorDrawable colorDrawable = new ColorDrawable(j.m());
        this.mDefaultBackground = colorDrawable;
        ImageLoader.Options options2 = this.mBackgroundOptions;
        colorDrawable.setBounds(0, 0, options2.clipWidth, options2.clipHeight);
        if (this.mShareCard.type != 3) {
            this.cover.setVisibility(0);
            this.cover.setBackgroundColor(-16777216);
            this.cover.setAlpha(102.0f);
        } else {
            this.cover.setVisibility(8);
        }
        String picUrl = this.mShareCard.getPicUrl();
        this.background.setScaleType(ImageView.ScaleType.CENTER);
        this.background.setAsyncImage(this.mShareCard.imageUrl, picUrl, this.mDefaultBackground, this.mBackgroundOptions);
        if (!TextUtils.isEmpty(this.mShareCard.nick)) {
            this.avatar.setVisibility(0);
            this.share_desc.setVisibility(0);
            if (!TextUtils.isEmpty(this.mShareCard.portrait)) {
                CanvasAvatarArea canvasAvatarArea = this.avatar;
                CellShareCard cellShareCard = this.mShareCard;
                canvasAvatarArea.setAvatarUrl(cellShareCard.portraitImageUrl, cellShareCard.portrait, AreaManager.dp20, AreaManager.DEFAULT_AVATAR);
            } else {
                this.avatar.setAvatar(this.mShareCard.uin, AreaManager.dp20, AreaManager.DEFAULT_AVATAR);
            }
            this.share_desc.setText(this.mShareCard.nick + " " + this.mShareCard.optype);
        } else {
            this.avatar.setVisibility(8);
            this.share_desc.setVisibility(8);
        }
        CellShareCard cellShareCard2 = this.mShareCard;
        if (cellShareCard2.visit_num > 0 && cellShareCard2.answer_num > 0) {
            this.read_count.setVisibility(0);
            this.read_info.setVisibility(0);
            this.read_count.setText(getCountDesc(this.mShareCard.visit_num));
            this.answer_count.setVisibility(0);
            this.answer_info.setVisibility(0);
            this.answer_count.setText(getCountDesc(this.mShareCard.answer_num));
        } else {
            this.read_count.setVisibility(8);
            this.read_info.setVisibility(8);
            this.answer_count.setVisibility(8);
            this.answer_info.setVisibility(8);
        }
        setTitleAndModule();
    }

    String getCountDesc(long j3) {
        if (j3 > SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            return (j3 / SafeBitmapFactory.PX_THRESHOID_DEFAULTS) + "\u4ebf";
        }
        if (j3 > 10000000) {
            return (j3 / 10000000) + "\u5343\u4e07";
        }
        if (j3 > 1000000) {
            return (j3 / 1000000) + "\u767e\u4e07";
        }
        if (j3 > JsonGrayBusiId.UI_RESERVE_100000_110000) {
            return (j3 / 10000) + "\u4e07";
        }
        if (j3 > 10000) {
            return (Math.round((float) (j3 / 1000)) / 10.0d) + "\u4e07";
        }
        return "" + j3;
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }
}
