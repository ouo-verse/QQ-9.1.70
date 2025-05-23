package com.qzone.module.feedcomponent.ui.canvasui;

import NS_MOBILE_FEEDS.cnst.ADV_DESC;
import NS_MOBILE_FEEDS.s_button;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.h;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.gdtui.CanvasRecommActionButton;
import com.qzone.canvasui.gdtui.asynarea.CanvasRecommFriends;
import com.qzone.canvasui.gdtui.asynarea.CanvasRecommStars;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.CanvasCountDownArea;
import com.qzone.canvasui.widget.CanvasGifArea;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.module.feedcomponent.ui.FeedChildView;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.util.GdtCanvasUiUtil;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.ViewSectionType;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellRecommAction;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.util.g;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import cooperation.qzone.widget.QzoneEmotionUtils;
import g6.a;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasRecommAction extends MarginCanvasAreaView implements FeedChildView {
    private static final String TAG = "CanvasRecommAction";
    private static Drawable advBackgroundDrawable;
    private static Drawable advSkinBackgroundDrawable;
    public static final int backgroundColor;
    private static Drawable backgroundDrawable;
    private static String friendPlayingText;
    public static final int skinBackgroundColor;
    private static Drawable skinBackgroundDrawable;
    public AdExposureChecker.ExposureCallback adExposureCheckerCallback;
    private String addGroupUrl;

    @DittoField
    public CanvasCountDownArea count_down_area;

    @DittoField
    CanvasRecommFriends friend_chain_area;

    @DittoField
    public DittoImageArea gdt_adv_animation_begin_image;

    @DittoField
    public DittoImageArea gdt_adv_animation_end_image;

    @DittoField
    CanvasGifArea gdt_dynamic_tag_gif;

    @DittoField
    DittoImageArea gdt_dynamic_tag_img;

    @DittoField
    AsyncCanvasImageArea gdt_good_bg;

    @DittoField
    public CanvasRecommActionButton gdt_good_button;

    @DittoField
    RelativeAreaLayout gdt_good_container;

    @DittoField
    DittoTextArea gdt_good_desc;

    @DittoField
    RelativeAreaLayout gdt_good_desc_container;

    @DittoField
    AsyncCanvasImageArea gdt_good_image;

    @DittoField
    DittoTextArea gdt_good_prise;

    @DittoField
    CanvasRecommActionButton gdt_label1;

    @DittoField
    CanvasRecommActionButton gdt_label2;

    @DittoField
    CanvasRecommActionButton gdt_label3;

    @DittoField
    LinearAreaLayout gdt_label_container;
    private AutoGifDrawable.GifDownloadCallBackListener gifDownloadCallBackListener;
    private ImageLoader.ImageLoadListener imageLoadListener;

    @DittoField
    LinearAreaLayout layout_mini_app_text;
    private String leftTextUrl;
    public BusinessFeedData mFeedData;
    private Runnable mSetupButtonStyleRunnable;

    @DittoField
    DittoImageArea mini_app_icon;

    @DittoField
    RelativeAreaLayout qzone_recomm_action_root_container;

    @DittoField
    public CanvasRecommActionButton right_button_area;

    @DittoField
    CanvasGifArea right_button_gif_area;

    @DittoField
    CanvasRecommStars stars_area;

    @DittoField
    public RichCanvasTextArea text_area;

    @DittoField
    DittoTextArea text_mini_app;

    @DittoField
    DittoTextArea text_mini_app_desc;
    protected boolean used;
    public static final int GDT_LABEL_BG_NIGHT = Color.parseColor("#1F1F1F");
    public static final int GDT_LABEL_BG = Color.parseColor("#F5F6FA");
    public static final int GDT_LABEL_TEXT_NIGHT = Color.parseColor("#EBEBF5");
    public static final int GDT_LABEL_TEXT = Color.parseColor("#878B99");
    public static String feedCountDownIcon = "https://public.gdtimg.com/ams-web/public/client/adIcon/ad_countdown_icon_dart.png";
    public static FeedViewSection.SectionController RecommActionController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction.3
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            if (businessFeedData == null || (businessFeedData.getFeedCommInfo().feedsAttr & 32768) > 0 || businessFeedData.isCanvasAd()) {
                return true;
            }
            if ((businessFeedData.isSingleAdvContainerFeed() && !businessFeedData.isSubFeed && !businessFeedData.isAdvContainerThreeGridStyle()) || businessFeedData.getRecommAction() == null || businessFeedData.getRecommAction().isHideActionArea != 0 || businessFeedData.isAlbumRecFeed()) {
                return true;
            }
            if (businessFeedData.isGDTAdvFeed()) {
                return !GdtAdFeedUtil.isSectionVisible(businessFeedData, ViewSectionType.RECOMM_ACTION);
            }
            return false;
        }
    };

    static {
        int m3 = j.m();
        backgroundColor = m3;
        int parseColor = Color.parseColor("#1F1F1F");
        skinBackgroundColor = parseColor;
        backgroundDrawable = new ColorDrawable(m3);
        skinBackgroundDrawable = new ColorDrawable(parseColor);
        advBackgroundDrawable = j.g(729);
        advSkinBackgroundDrawable = j.g(954);
        friendPlayingText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ManyFriendPlaying", "\u4e2a\u597d\u53cb\u5728\u73a9");
    }

    public CanvasRecommAction(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.used = false;
        this.gifDownloadCallBackListener = new AutoGifDrawable.GifDownloadCallBackListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction.1
            @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
            public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
                if (CanvasRecommAction.this.getHandler() != null) {
                    CanvasRecommAction.this.getHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CanvasGifArea canvasGifArea = CanvasRecommAction.this.gdt_dynamic_tag_gif;
                            if (canvasGifArea == null || canvasGifArea.getVisibility() != 0) {
                                return;
                            }
                            CanvasRecommAction.this.gdt_dynamic_tag_gif.playGif();
                        }
                    });
                }
            }

            @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
            public void onImageFailed(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            }
        };
        this.imageLoadListener = new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction.2
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str, ImageLoader.Options options) {
                b.c(CanvasRecommAction.TAG, "dynamic tag icon loaded failed");
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
                CanvasRecommAction.this.gdt_dynamic_tag_img.setImageDrawable(drawable);
                b.e(CanvasRecommAction.TAG, "dynamic tag icon loaded success");
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            }
        };
        this.adExposureCheckerCallback = null;
        setContentAreaForJsonFile("qzone_canvas_ui_recommAction.json");
        setVisibility(8);
    }

    private void gdtSupplementaryReport() {
        GdtAd gdtAd = new GdtAd(GdtFeedUtilForQZone.f(this.mFeedData));
        if (this.adExposureCheckerCallback == null) {
            this.adExposureCheckerCallback = new AdExposureChecker.ExposureCallback() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction.6
                @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
                public void onExposure(WeakReference<View> weakReference) {
                    if (b.g()) {
                        b.c("AdExposureChecker", "onExposure");
                    }
                    CanvasRecommAction canvasRecommAction = CanvasRecommAction.this;
                    GdtAdFeedUtil.doEffectiveExposureReport(canvasRecommAction.mFeedData, canvasRecommAction.getFeedPosition(), 0);
                }
            };
        }
        AdExposureChecker.onClick(getContext(), gdtAd, new WeakReference(this.adExposureCheckerCallback));
    }

    public static String getCompleteUrl(String str) {
        Matcher matcher = Pattern.compile("((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?", 2).matcher(str);
        matcher.find();
        return matcher.group();
    }

    private boolean isGifUrl(String str) {
        return str.contains(QzoneEmotionUtils.SIGN_ICON_URL_END);
    }

    private void setGdtLabelTextField(String[] strArr) {
        int i3;
        int i16;
        LayoutAttrSet layoutAttr = this.right_button_area.getLayoutAttr();
        this.gdt_label_container.setVisibility(0);
        LayoutAttrSet layoutAttr2 = this.gdt_label_container.getLayoutAttr();
        LayoutAttrSet layoutAttr3 = this.gdt_label2.getLayoutAttr();
        LayoutAttrSet layoutAttr4 = this.gdt_label3.getLayoutAttr();
        if (layoutAttr2 != null && layoutAttr3 != null && layoutAttr4 != null && layoutAttr != null) {
            layoutAttr2.setLeftMargin(g.a(2.0f));
            layoutAttr3.setLeftMargin(g.a(4.0f));
            layoutAttr4.setLeftMargin(g.a(4.0f));
            layoutAttr.setRightMargin(AreaConst.f48747dp2);
        }
        this.gdt_label1.setText(strArr[0]);
        this.gdt_label2.setText(strArr[1]);
        this.gdt_label3.setText(strArr[2]);
        if (i.H().p1()) {
            i3 = GDT_LABEL_BG_NIGHT;
        } else {
            i3 = GDT_LABEL_BG;
        }
        if (i.H().p1()) {
            i16 = GDT_LABEL_TEXT_NIGHT;
        } else {
            i16 = GDT_LABEL_TEXT;
        }
        this.gdt_label1.setBackgroundColor(i3);
        this.gdt_label2.setBackgroundColor(i3);
        this.gdt_label3.setBackgroundColor(i3);
        this.gdt_label1.setTextColor(i16);
        this.gdt_label2.setTextColor(i16);
        this.gdt_label3.setTextColor(i16);
        this.gdt_label1.setVisibility(!TextUtils.isEmpty(strArr[0]) ? 0 : 8);
        this.gdt_label2.setVisibility(!TextUtils.isEmpty(strArr[1]) ? 0 : 8);
        this.gdt_label3.setVisibility(TextUtils.isEmpty(strArr[2]) ? 8 : 0);
        this.text_area.setVisibility(8);
    }

    private void setLeftCornerAdStyle() {
        BusinessFeedData businessFeedData;
        BusinessFeedData businessFeedData2 = this.mFeedData;
        if (businessFeedData2 == null || businessFeedData2.getRecommAction() == null || (businessFeedData = this.mFeedData) == null || businessFeedData.getRecommAction() == null || this.mFeedData.getRecommAction().extendInfo == null) {
            return;
        }
        String dynamicTagIconUrl = GdtAdFeedUtil.getDynamicTagIconUrl(this.mFeedData);
        if (!TextUtils.isEmpty(dynamicTagIconUrl)) {
            showDynamicTag(dynamicTagIconUrl);
        } else {
            showNormalLabel(GdtAdFeedUtil.getIndustryLabels(this.mFeedData));
        }
    }

    private void setLeftFieldText() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || businessFeedData.getRecommAction() == null) {
            return;
        }
        if (this.count_down_area.getVisibility() != 0) {
            if (!TextUtils.isEmpty(this.mFeedData.getRecommAction().remark)) {
                this.text_area.setText(AreaManager.getInstance().convertNetImageCellDp2Px(this.mFeedData.getRecommAction().remark));
            } else {
                this.text_area.setVisibility(4);
            }
        }
        this.stars_area.setVisibility(8);
        this.gdt_label_container.setVisibility(8);
        this.gdt_dynamic_tag_gif.setVisibility(8);
        this.gdt_dynamic_tag_img.setVisibility(8);
    }

    private void setPickedBrandAdView() {
        String str;
        String str2;
        String str3;
        this.qzone_recomm_action_root_container.getLayoutAttr().width = -1;
        this.gdt_good_container.setVisibility(0);
        this.gdt_good_desc_container.setVisibility(0);
        String str4 = (this.mFeedData.getCellSummary() == null || this.mFeedData.getCellSummary().mapExt == null || !this.mFeedData.getCellSummary().mapExt.containsKey(ADV_DESC.value)) ? null : this.mFeedData.getCellSummary().mapExt.get(ADV_DESC.value);
        if (this.mFeedData.getRecommAction() != null && this.mFeedData.getRecommAction().extendInfo != null && this.mFeedData.getRecommAction().extendInfo.containsKey(12) && this.mFeedData.getRecommAction().extendInfo.containsKey(9) && this.mFeedData.getRecommAction().extendInfo.containsKey(11)) {
            str = this.mFeedData.getRecommAction().extendInfo.get(9);
            str2 = this.mFeedData.getRecommAction().extendInfo.get(12);
            str3 = this.mFeedData.getRecommAction().extendInfo.get(11);
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        LayoutAttrSet layoutAttr = this.gdt_good_bg.getLayoutAttr();
        LayoutAttrSet layoutAttr2 = this.gdt_good_image.getLayoutAttr();
        if (layoutAttr != null && layoutAttr2 != null) {
            this.gdt_good_bg.setAsyncImage(null, str, null, null);
            this.gdt_good_bg.setVisibility(0);
            this.gdt_good_image.setAsyncImage(null, str2, null, null);
            this.gdt_good_bg.setVisibility(0);
            this.gdt_good_desc.setText(str4);
            this.gdt_good_desc.setVisibility(0);
            this.gdt_good_prise.setText("\uffe5" + str3);
            this.gdt_good_prise.setVisibility(0);
            this.gdt_good_button.setVisibility(0);
            setButtonTextForPickedBrand(this.gdt_good_button);
            this.gdt_good_button.setBackgroundColor(j.x());
            if (this.gdt_good_desc.getText().length() > 12) {
                this.gdt_good_desc.getLayoutAttr().setMargin(g.a(8.0f), g.a(4.0f), 0, 0);
                this.gdt_good_prise.getLayoutAttr().setMargin(g.a(8.0f), g.a(40.0f), 0, 0);
            }
            this.text_area.setVisibility(8);
        }
        if (i.H().p1()) {
            this.gdt_good_button.setBackgroundColor(Color.parseColor("#0071FF"));
            this.gdt_good_container.setBackgroundColor(Color.parseColor("#1F1F1F"));
            this.gdt_good_desc_container.setBackgroundColor(Color.parseColor("#1F1F1F"));
            this.gdt_good_desc.setTextColor(Color.parseColor("#FFFFFF"));
            this.gdt_good_prise.setTextColor(Color.parseColor("#0071FF"));
            return;
        }
        this.gdt_good_container.setBackgroundColor(Color.parseColor("#F5F6FA"));
        this.gdt_good_desc_container.setBackgroundColor(Color.parseColor("#F5F6FA"));
        this.gdt_good_desc.setTextColor(Color.parseColor("#03081A"));
        this.gdt_good_prise.setTextColor(Color.parseColor("#00CAFC"));
    }

    private void setupFriendPlayingUI() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null) {
            if (businessFeedData.isFriendPlayingRecomm()) {
                this.text_area.setVisibility(8);
                this.layout_mini_app_text.setVisibility(0);
                CellRecommAction recommAction = this.mFeedData.getRecommAction();
                if (recommAction != null) {
                    s_button s_buttonVar = recommAction.left_bottom_button;
                    if (s_buttonVar != null) {
                        this.text_mini_app.setIncludeFontPadding(false);
                        this.text_mini_app.setText(s_buttonVar.text, 8, MiniBoxNoticeInfo.APPNAME_SUFFIX);
                        if (s_buttonVar.button_img != null) {
                            ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImageAsync(s_buttonVar.button_img, new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction.5
                                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                                public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
                                    CanvasRecommAction.this.mini_app_icon.setImageDrawable(drawable);
                                    CanvasRecommAction.this.mini_app_icon.setVisibility(0);
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
                            });
                        }
                    }
                    this.text_mini_app_desc.setText(this.mFeedData.getRecommAction().remark, 16, MiniBoxNoticeInfo.APPNAME_SUFFIX);
                }
            } else {
                if (QZoneAdFeedDataExtKt.isBrandOptimizationAdv(this.mFeedData)) {
                    setPickedBrandAdView();
                }
                if (!CanvasCountDownArea.checkDataValid(this.mFeedData) && !this.mFeedData.isSubOfSingleAdvContainerFeed() && !this.mFeedData.isAdvContainerThreeGridStyle()) {
                    setLeftCornerAdStyle();
                }
                this.layout_mini_app_text.setVisibility(8);
                this.mini_app_icon.setVisibility(8);
            }
            showRightButton(true);
        }
    }

    private void showDynamicTag(String str) {
        if (isGifUrl(str)) {
            this.gdt_dynamic_tag_gif.setGifImage(str, g.a(77.0f), g.a(20.0f), true, this.gifDownloadCallBackListener);
            this.gdt_dynamic_tag_gif.setVisibility(0);
            this.gdt_dynamic_tag_img.setVisibility(8);
        } else {
            ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImageAsync(str, this.imageLoadListener);
            this.gdt_dynamic_tag_img.setDimens(g.a(77.0f), g.a(20.0f));
            this.gdt_dynamic_tag_img.setVisibility(0);
            this.gdt_dynamic_tag_gif.setVisibility(8);
        }
    }

    private void showRightButton(boolean z16) {
        int x16;
        int i3;
        if (this.mFeedData == null) {
            return;
        }
        if (i.H().p1()) {
            x16 = Color.parseColor("#0071FF");
        } else {
            x16 = j.x();
        }
        int parseColor = Color.parseColor("#FFFFFFFF");
        int showButtonDelay = GdtAdFeedUtil.getShowButtonDelay(this.mFeedData) * 1000;
        a.b bVar = new a.b();
        bVar.f401409b = this.mFeedData;
        bVar.f401414g = new WeakReference<>(getRootView());
        bVar.f401410c = 0;
        bVar.f401412e = FeedElement.RECOMM_ACTION_LEFT_TEXT;
        String buttonText = GdtAdFeedUtil.getButtonText(bVar);
        if (this.mFeedData.isFriendPlayingRecomm()) {
            x16 = j.B();
            parseColor = j.o();
            i3 = 0;
        } else if (QZoneAdFeedDataExtKt.isBrandOptimizationAdv(this.mFeedData)) {
            i3 = 8;
        } else {
            buttonText = buttonText + " \uff1e";
            parseColor = Color.parseColor("#878B99");
            Runnable runnable = new Runnable() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasRecommAction.4
                @Override // java.lang.Runnable
                public void run() {
                    CanvasRecommAction.this.right_button_area.setTextColor(Color.parseColor("#00CAFC"));
                    CanvasRecommAction.this.requestLayout();
                    CanvasRecommAction.this.invalidate();
                }
            };
            this.mSetupButtonStyleRunnable = runnable;
            if (z16) {
                postDelayed(runnable, showButtonDelay);
            }
            i3 = 0;
            x16 = 0;
        }
        this.right_button_area.setMargin(0, g.a(11.0f), g.a(11.0f), 0);
        this.right_button_area.setBackgroundColor(x16);
        this.right_button_area.setTextColor(parseColor);
        this.right_button_area.setVisibility(i3);
        this.right_button_area.setText(buttonText);
        this.right_button_area.setAlpha(255.0f);
    }

    private void updateLeftTextView() {
        this.text_area.setVisibility(0);
        this.text_area.setMargin(g.a(11.0f), g.a(11.0f), 0, 0);
        if (CanvasCountDownArea.checkDataValid(this.mFeedData)) {
            this.text_area.setText(AreaManager.getInstance().convertNetImageCellDp2Px("{img:https://public.gdtimg.com/aoi/sola/20180315155236_1Z7VSVY2pO.png,w:28,h:28} {text:\u5269\u4f59\u65f6\u95f4,color:707070}"));
            this.stars_area.setVisibility(8);
            this.gdt_label_container.setVisibility(8);
            this.count_down_area.setVisibility(0);
            this.count_down_area.updateView();
            if (i.H().p1()) {
                String replace = "{img:https://public.gdtimg.com/aoi/sola/20180315155236_1Z7VSVY2pO.png,w:28,h:28} {text:\u5269\u4f59\u65f6\u95f4,color:707070}".replace(getCompleteUrl("{img:https://public.gdtimg.com/aoi/sola/20180315155236_1Z7VSVY2pO.png,w:28,h:28} {text:\u5269\u4f59\u65f6\u95f4,color:707070}"), feedCountDownIcon);
                if (replace.contains("707070")) {
                    replace = replace.replace("707070", "66EBEBF5");
                }
                this.text_area.setText(AreaManager.getInstance().convertNetImageCellDp2Px(replace));
            }
        } else if (this.mFeedData.getRecommAction().relation_chain != null && this.mFeedData.getRecommAction().relation_total_number != 0) {
            this.text_area.setText(this.mFeedData.getRecommAction().relation_total_number + friendPlayingText);
        } else if (!TextUtils.isEmpty(this.mFeedData.getRecommAction().remark)) {
            if (i.H().p1()) {
                this.text_area.setTextColor(Color.parseColor("#66EBEBF5"));
                if (this.mFeedData.getRecommAction().remark.contains("285c95")) {
                    this.mFeedData.getRecommAction().remark = this.mFeedData.getRecommAction().remark.replace("285c95", "0071FF");
                }
            } else {
                this.text_area.setTextColor(Color.parseColor("#878B99"));
            }
        }
        setLeftFieldText();
    }

    private void updateRoot() {
        if (!this.mFeedData.isSubOfSingleAdvContainerFeed() && !this.mFeedData.isAdvContainerThreeGridStyle()) {
            if (QZoneAdFeedDataExtKt.isAdvContainerSixGridStyle(this.mFeedData)) {
                this.qzone_recomm_action_root_container.getLayoutAttr().height = 0;
                this.gdt_good_container.getLayoutAttr().height = 0;
                this.gdt_good_desc_container.getLayoutAttr().height = 0;
            } else if (QZoneAdFeedDataExtKt.isBrandOptimizationAdv(this.mFeedData)) {
                this.qzone_recomm_action_root_container.getLayoutAttr().height = g.a(68.0f);
                this.gdt_good_container.getLayoutAttr().height = g.a(68.0f);
                this.gdt_good_desc_container.getLayoutAttr().height = g.a(68.0f);
                this.qzone_recomm_action_root_container.getLayoutAttr().topMargin = g.a(2.0f);
            } else {
                this.qzone_recomm_action_root_container.getLayoutAttr().height = g.a(53.0f);
                this.gdt_good_container.getLayoutAttr().height = 0;
                this.gdt_good_desc_container.getLayoutAttr().height = 0;
            }
            this.qzone_recomm_action_root_container.getLayoutAttr().rightMargin = (int) (DittoUIEngine.g().getDensity() * 6.0f);
            this.qzone_recomm_action_root_container.getLayoutAttr().leftMargin = (int) (DittoUIEngine.g().getDensity() * 6.0f);
            if (i.H().p1()) {
                advSkinBackgroundDrawable.setAlpha(this.mTrans);
                this.qzone_recomm_action_root_container.setBackgroundDrawable(advSkinBackgroundDrawable);
            } else {
                advBackgroundDrawable.setAlpha(this.mTrans);
                this.qzone_recomm_action_root_container.setBackgroundDrawable(advBackgroundDrawable);
            }
        } else {
            this.qzone_recomm_action_root_container.getLayoutAttr().rightMargin = 0;
            this.qzone_recomm_action_root_container.getLayoutAttr().leftMargin = 0;
            if (i.H().p1()) {
                skinBackgroundDrawable.setAlpha(this.mTrans);
                this.qzone_recomm_action_root_container.setBackgroundDrawable(skinBackgroundDrawable);
            } else {
                backgroundDrawable.setAlpha(this.mTrans);
                this.qzone_recomm_action_root_container.setBackgroundDrawable(backgroundDrawable);
            }
        }
        if (this.mFeedData.isFriendPlayingRecomm()) {
            this.qzone_recomm_action_root_container.getLayoutAttr().bottomMargin = g.a(12.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.module.feedcomponent.ui.canvasui.MarginCanvasAreaView, com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.text_area.getTextArea() != null) {
            this.leftTextUrl = GdtCanvasUiUtil.getUrlFromCells(this.text_area.getTextArea().getCells());
        }
        super.onDraw(canvas);
    }

    public void onPause() {
        b.e(TAG, "[onPause] " + getFeedPosition());
        showRightButton(false);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        super.onRecycled();
        b.e(TAG, "[onRecycled] " + getFeedPosition());
        Runnable runnable = this.mSetupButtonStyleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.mSetupButtonStyleRunnable = null;
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void reset() {
        if (this.used) {
            b.e(TAG, "[reset]");
            this.mFeedData = null;
            GdtCanvasUiUtil.resetSubView(this);
            setVisibility(8);
            this.text_area.setVisibility(8);
            if (this.right_button_area != null) {
                FeedGlobalEnv.g().removeButton(this.right_button_area.getPresenter());
            }
            CanvasRecommStars canvasRecommStars = this.stars_area;
            if (canvasRecommStars != null) {
                canvasRecommStars.setVisibility(8);
            }
            CanvasCountDownArea canvasCountDownArea = this.count_down_area;
            if (canvasCountDownArea != null) {
                canvasCountDownArea.setVisibility(8);
            }
            DittoTextArea dittoTextArea = this.text_mini_app;
            if (dittoTextArea != null) {
                dittoTextArea.setIncludeFontPadding(true);
            }
            CanvasGifArea canvasGifArea = this.gdt_dynamic_tag_gif;
            if (canvasGifArea != null) {
                canvasGifArea.setVisibility(8);
            }
            DittoImageArea dittoImageArea = this.gdt_dynamic_tag_img;
            if (dittoImageArea != null) {
                dittoImageArea.setVisibility(8);
            }
            this.used = false;
        }
    }

    public void setCountDownTimeViewGone() {
        this.count_down_area.setVisibility(8);
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || businessFeedData.getRecommAction() == null || TextUtils.isEmpty(this.mFeedData.getRecommAction().remark)) {
            return;
        }
        this.text_area.setText(AreaManager.getInstance().convertNetImageCellDp2Px(this.mFeedData.getRecommAction().remark));
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        this.mFeedData = businessFeedData;
        GdtCanvasUiUtil.setSubViewData(businessFeedData, this);
        update();
    }

    public void setTrans(int i3) {
        this.mTrans = g.b(i3);
        if (this.mFeedData != null) {
            updateRoot();
        }
    }

    public void update() {
        this.used = true;
        if (QZoneAdFeedDataExtKt.isGdt585AdVideo(this.mFeedData)) {
            setVisibility(8);
            return;
        }
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.getRecommAction() != null) {
            this.addGroupUrl = this.mFeedData.getRecommAction().add_group_url;
        }
        setVisibility(0);
        updateRoot();
        GdtCanvasUiUtil.updateSubView(this);
        updateLeftTextView();
        setupFriendPlayingUI();
    }

    private void setButtonTextForPickedBrand(CanvasRecommActionButton canvasRecommActionButton) {
        BusinessFeedData businessFeedData;
        if (canvasRecommActionButton == null || (businessFeedData = this.mFeedData) == null || businessFeedData.getRecommAction() == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.mFeedData.getRecommAction().buttonText)) {
            canvasRecommActionButton.setText(this.mFeedData.getRecommAction().buttonText);
        } else if (this.mFeedData.isAppAd()) {
            canvasRecommActionButton.setText("\u53bb\u4e0b\u8f7d");
        } else {
            canvasRecommActionButton.setText("\u53bb\u770b\u770b");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"friend_chain_area", "stars_area", "text_area", "count_down_area", "right_button_area", "right_button_gif_area", "qzone_recomm_action_root_container", "gdt_good_image", "gdt_good_bg", "gdt_good_desc", "gdt_good_prise", "gdt_good_button", "gdt_good_desc_container", "gdt_good_container", "gdt_label_container", "gdt_dynamic_tag_gif", "gdt_dynamic_tag_img"})
    public void onAreaClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        if (dittoArea == null) {
            return;
        }
        if (dittoArea.getId().equals(this.count_down_area.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.RECOMM_ACTION_LEFT_TEXT, this.feedPosition, null);
        } else if (dittoArea.getId().equals(this.text_area.getId())) {
            com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
            FeedElement feedElement = FeedElement.RECOMM_ACTION_LEFT_TEXT;
            int i3 = this.feedPosition;
            String str = this.leftTextUrl;
            gVar.onClick(this, feedElement, i3, str != null ? new e(str, null, i3) : null);
        } else if (dittoArea.getId().equals(this.gdt_dynamic_tag_img.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.RECOMM_ACTION_LEFT_TEXT, this.feedPosition, null);
        } else if (dittoArea.getId().equals(this.gdt_dynamic_tag_gif.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.RECOMM_ACTION_LEFT_TEXT, this.feedPosition, null);
        } else if (dittoArea.getId().equals(this.friend_chain_area.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.RECOMM_ACTION_LEFT_TEXT, this.feedPosition, null);
        } else if (dittoArea.getId().equals(this.stars_area.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.RECOMMAD_ACTION_STAR, this.feedPosition, null);
        } else if (dittoArea.getId().equals(this.qzone_recomm_action_root_container.getId())) {
            BusinessFeedData businessFeedData = this.mFeedData;
            if (businessFeedData != null && businessFeedData.isFriendPlayingRecomm()) {
                this.onFeedElementClickListener.onClick(this, FeedElement.ACTION_BUTTON, this.feedPosition, null);
            } else {
                this.onFeedElementClickListener.onClick(this, FeedElement.NOTHING, this.feedPosition, null);
            }
        } else if (dittoArea.getId().equals(this.right_button_area.getId())) {
            if (!TextUtils.isEmpty(this.addGroupUrl)) {
                Intent intent = new Intent();
                intent.setClass(getContext(), FeedGlobalEnv.g().getAddGroupQQProxy());
                intent.putExtra("url", this.addGroupUrl);
                getContext().startActivity(intent);
                this.onFeedElementClickListener.onClick(null, FeedElement.ACTION_BUTTON, this.feedPosition, null);
            } else {
                this.onFeedElementClickListener.onClick(this, FeedElement.ACTION_BUTTON, this.feedPosition, null);
            }
        } else if (dittoArea.getId().equals(this.right_button_gif_area.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.ACTION_BUTTON, this.feedPosition, null);
        } else if (dittoArea.getId().equals(this.gdt_good_image.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV, this.feedPosition, null);
        } else if (dittoArea.getId().equals(this.gdt_good_bg.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV, this.feedPosition, null);
        } else if (dittoArea.getId().equals(this.gdt_good_desc.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV, this.feedPosition, null);
        } else if (dittoArea.getId().equals(this.gdt_good_prise.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV, this.feedPosition, null);
        } else if (dittoArea.getId().equals(this.gdt_good_button.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.ACTION_BUTTON, this.feedPosition, null);
        } else if (dittoArea.getId().equals(this.gdt_good_desc_container.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV, this.feedPosition, null);
        } else if (dittoArea.getId().equals(this.gdt_good_container.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV, this.feedPosition, null);
        } else if (dittoArea.getId().equals(this.gdt_label_container.getId())) {
            this.onFeedElementClickListener.onClick(this, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV, this.feedPosition, null);
        }
        gdtSupplementaryReport();
    }

    private void showNormalLabel(String[] strArr) {
        if (strArr != null && strArr.length != 0 && !TextUtils.isEmpty(strArr[0])) {
            this.gdt_dynamic_tag_img.setVisibility(8);
            this.gdt_dynamic_tag_gif.setVisibility(8);
            setGdtLabelTextField(strArr);
            return;
        }
        this.gdt_label_container.setVisibility(8);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }
}
