package com.qzone.module.feedcomponent.ui.canvasui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.qzone.adapter.feedcomponent.h;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.canvasui.widget.CanvasAttachArea;
import com.qzone.canvasui.widget.CanvasAvatarArea;
import com.qzone.canvasui.widget.CanvasFeedRecommendListArea;
import com.qzone.canvasui.widget.CanvasGifArea;
import com.qzone.canvasui.widget.CanvasNicknameArea;
import com.qzone.canvasui.widget.QzoneCanvasAreaView;
import com.qzone.canvasui.widget.RichCanvasTextArea;
import com.qzone.canvasui.widget.TimeCountDownArea;
import com.qzone.module.feedcomponent.FeedUtil;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.module.feedcomponent.ui.FeedAdvContainer;
import com.qzone.module.feedcomponent.ui.FeedTextArea;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.qzone.module.feedcomponent.ui.TitleAttachArea;
import com.qzone.module.feedcomponent.ui.common.WrapContentViewPager;
import com.qzone.module.feedcomponent.util.SimpleModelUtils;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCover;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedSignature;
import com.qzone.proxy.feedcomponent.model.CellHighFiveInfo;
import com.qzone.proxy.feedcomponent.model.CellMallInfo;
import com.qzone.proxy.feedcomponent.model.CellPermissionInfo;
import com.qzone.proxy.feedcomponent.model.CellRecommendList;
import com.qzone.proxy.feedcomponent.model.CellReferInfo;
import com.qzone.proxy.feedcomponent.model.CellUpperBanner;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.NamePlate;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.UserMedal;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.text.ColorTextCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.UrlCell;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.proxy.feedcomponent.util.QzoneZipCacheHelper;
import com.qzone.widget.QzoneZipAnimateUtil;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.annoations.DittoField;
import com.tencent.ditto.annoations.DittoOnClick;
import com.tencent.ditto.annoations.DittoOnLongClick;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoButtonArea;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.ditto.widget.FlexLinearAreaLayout;
import com.tencent.ditto.widget.LinearAreaLayout;
import com.tencent.ditto.widget.RelativeAreaLayout;
import com.tencent.luggage.wxa.yf.u;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ui.IVipFrameDrawable;
import com.tencent.mobileqq.vas.ui.c;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.mobileqq.vip.api.IVipIconUtilsForQzone;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.zipanimate.AnimationDrawableLoadedListener;
import cooperation.qzone.zipanimate.ZipDrawableLoader;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import java.io.File;
import java.io.FileFilter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import m15.a;
import s8.j;
import yo.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasTitleView extends QzoneCanvasAreaView {
    static Drawable AVATAR_BOTTOM_BAR_BACKGROUND_DRAWABLE = null;
    static Drawable AddedBg = null;
    static int AddedTextColor = 0;
    public static final int COMMENT = 34;
    public static final int GIFT = 51;
    public static final int GIVEBACK = 119;
    private static final int HIGH_FIVE_COUNT_ANIM_DELAY = 480;
    private static final String HIGH_FIVE_COUNT_PRODUCT_SIHN = "\u00d7";
    private static final String HIGH_FIVE_COUNT_THRESHOLD = "999+";
    public static final int HUNUAN = 136;
    public static final int JOINALBUM = 85;
    public static final int JOINEDALBUM = 102;
    public static final int LEAVE_MESSAGE = 153;
    public static final int LOOKUP = 68;
    static Drawable PASSIVE_FEED_COMMENT_CLICK = null;
    static Drawable PASSIVE_FEED_COMMENT_NORMAL = null;
    static Drawable PASSIVE_FEED_PRAISED = null;
    static Drawable PASSIVE_FEED_PRAISE_NORMAL = null;
    public static final int REPLY = 17;
    private static final String TAG = "CF-CanvasTitleView";
    static Drawable UnAddedBg;
    static int UnAddedTextColor;
    public static ImageUrl loverZoneIconImageUrl;
    public final int DEFULAT_SIZE;

    @DittoField
    RichCanvasTextArea action_area;

    @DittoField
    DittoButtonArea add_friend_button;
    private AnimationDrawableLoadedListener animationDrawableLoadedListener;

    @DittoField
    CanvasAttachArea attach_area;

    @DittoField
    CanvasAvatarArea avatar;

    @DittoField
    RichCanvasTextArea avatar_bottom_bar;

    @DittoField
    LinearAreaLayout avatar_bottom_bar_container;

    @DittoField
    AsyncCanvasImageArea avatar_decoration;

    @DittoField
    RichCanvasTextArea btn_menu_area;

    @DittoField
    protected RichCanvasTextArea campus_area;
    boolean canComment;
    boolean canGiveBack;
    boolean canHuNuan;
    boolean canJoinAlbum;
    boolean canLookUp;
    boolean canReply;
    boolean canReturnGift;

    @DittoField
    RichCanvasTextArea count_area;
    private Drawable customPassiveBubbleSkinDrawable;

    @DittoField
    TimeCountDownArea del_time_area;

    @DittoField
    AsyncCanvasImageArea feed_skin;

    @DittoField
    DittoImageArea feed_skin_animation_container;

    @DittoField
    protected DittoArea feed_title_root;

    @DittoField
    DittoButtonArea follow_button;

    @DittoField
    RichCanvasTextArea friendlike_play_count_area;
    int gapAlpha;
    Paint gapPaint;

    @DittoField
    LinearAreaLayout high_five_count_container;

    @DittoField
    DittoButtonArea high_five_count_first_area;

    @DittoField
    DittoButtonArea high_five_count_second_area;

    @DittoField
    AsyncCanvasImageArea icon_LiveMedal;

    @DittoField
    AsyncCanvasImageArea icon_LoverZone;

    @DittoField
    AsyncCanvasImageArea icon_Standalone;

    @DittoField
    CanvasGifArea icon_YellowVip_gif;

    @DittoField
    AsyncCanvasImageArea icon_YellowVip_staticpic;

    @DittoField
    AsyncCanvasImageArea icon_familyMedal;

    @DittoField
    AsyncCanvasImageArea icon_famous;

    @DittoField
    DittoImageArea icon_qq_union_vip;

    @DittoField
    AsyncCanvasImageArea icon_starvip;
    boolean isFriendLikeContainer;
    boolean joinedAlbum;

    @DittoField
    RelativeAreaLayout line_1;

    @DittoField
    FlexLinearAreaLayout line_1_1;

    @DittoField
    protected LinearAreaLayout line_1_2;

    @DittoField
    protected LinearAreaLayout line_2;
    private Drawable.Callback lvTenCallback;
    private ImageLoader.Options mAvatarDecorateOptions;
    Runnable mAvatarRedPocketAnimRunnable;
    protected BusinessFeedData mFeedData;
    private Drawable mFeedSkinAnimation;
    private ImageLoader.Options mFeedSkinOptions;
    private Drawable.Callback mFeedSkinZipAnimationCallback;
    private j mFeedVipResourceListener;
    boolean mHasInterest;
    private boolean mHasRecommHeader;
    boolean mIsAdvContainerFeed;
    boolean mIsDoingAvatartRedPocketAnim;
    private boolean mIsFeedSkinFirstLoad;
    private boolean mIsForward;
    private boolean mIsFromMessage;
    private boolean mIsPassive;
    private boolean mIsQQUnionVipFirstLoad;
    boolean mIsTodayInHistoryDetail;
    private Drawable mQQUnionVipAnimation;
    private Drawable.Callback mQQUnionZipAnimationCallback;
    private AnimationDrawable mSignatureAnimationDrawable;
    private Drawable.Callback mSignatureCallback;

    @DittoField
    LinearAreaLayout name_plate_layout;
    private boolean needShowHighFiveAnimation;

    @DittoField
    protected CanvasNicknameArea nickname;
    private boolean noNeedShow;

    @DittoField
    DittoArea original_flag;

    @DittoField
    DittoButtonArea passive_comment_btn;

    @DittoField
    LinearAreaLayout passive_comment_btn_container;

    @DittoField
    DittoButtonArea passive_comment_like_btn;

    @DittoField
    LinearAreaLayout passive_comment_like_btn_container;
    public final double per;

    @DittoField
    protected RichCanvasTextArea permission_area;

    @DittoField
    DittoImageArea qzone_vip_signature;

    @DittoField
    protected RichCanvasTextArea qzonedesc_area;

    @DittoField
    CanvasFeedRecommendListArea recommend_list_header;

    @DittoField
    DittoArea recommend_list_header_split_line;

    @DittoField
    protected RichCanvasTextArea refer_area;

    @DittoField
    protected RichCanvasTextArea time_area;

    @DittoField
    RelativeAreaLayout title_upper_banner;

    @DittoField
    AsyncCanvasImageArea upper_banner_background_image;

    @DittoField
    DittoButtonArea upper_banner_close_button;

    @DittoField
    DittoArea upper_banner_close_container;

    @DittoField
    DittoTextArea upper_banner_summary;

    @DittoField
    DittoTextArea upper_banner_title;
    private VideoPlayInfo videoPlayInfo;

    @DittoField
    RelativeAreaLayout yellowdiamond_container;
    public static final String replyText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CanvasUIReply", "\u56de\u590d");
    public static final String commentText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CanvasUIComment", "\u8bc4\u8bba");
    public static final String giftText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CanvasUIGift", "\u7b54\u8c22");
    public static final String lookUpText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CanvasUILookUp", "\u67e5\u770b");
    public static final String joinAlbumText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CanvasUIJoinAlbum", "\u901a\u8fc7");
    public static final String joinedAlbumText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CanvasUIJoinedAlbum", "\u5df2\u901a\u8fc7");
    public static final String highFive = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CanvasUIHighFive", "\u51fb\u638c");
    public static final String loverZoneIconUrlDafult = i.H().T("QZoneSetting", "sweetIconRUL", "https://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png");
    public static final String huNuanText = i.H().T("QZoneSetting", "hunuan_text", "\u4e92\u6696");
    public static final String giveBackText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CanvasUIGiveBack", "\u56de\u8d60");
    public static final String leaveMessageText = h.c(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "CanvasUILeaveMessage", "\u7ed9ta\u7559\u8a00");
    public static final float DRAWABLE_SCALE = FeedGlobalEnv.g().getScreenWidth() / 720.0f;
    public static String feedLocalAdIconUrl = "https://i.gtimg.cn/ams-web/public/client/adIcon/ad_location_icon_dart.png";
    static int FollowedBorderColor = -2171168;
    static int AddedBorderColor = -2171168;
    static int UnFollowBorderColor = -13076291;
    static int UnAddedBorderColor = -16735233;
    static int highFiveCountYellowColor = -13056;
    static int highFiveCountGrayColor = -5789785;
    static int UnFollowBgColor = -16725252;
    static int UnFollowBgColor2 = -16725252;
    static int FollowedBgColor = -1183755;
    static int UnFollowTextColor = -1;
    static int FollowedTextColor = -16777216;

    static {
        FeedGlobalEnv.g();
        AddedBg = FeedGlobalEnv.getContext().getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(707));
        UnAddedBg = FeedGlobalEnv.getContext().getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(706));
        UnAddedTextColor = com.qzone.adapter.feedcomponent.j.c(21);
        AddedTextColor = com.qzone.adapter.feedcomponent.j.F();
        PASSIVE_FEED_COMMENT_NORMAL = com.qzone.adapter.feedcomponent.j.g(900);
        PASSIVE_FEED_COMMENT_CLICK = com.qzone.adapter.feedcomponent.j.g(901);
        PASSIVE_FEED_PRAISE_NORMAL = com.qzone.adapter.feedcomponent.j.g(902);
        PASSIVE_FEED_PRAISED = com.qzone.adapter.feedcomponent.j.g(903);
        AVATAR_BOTTOM_BAR_BACKGROUND_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(949);
    }

    public CanvasTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsFeedSkinFirstLoad = false;
        this.mIsQQUnionVipFirstLoad = false;
        this.needShowHighFiveAnimation = false;
        this.isFriendLikeContainer = false;
        this.DEFULAT_SIZE = 48;
        this.per = 0.8d;
        this.animationDrawableLoadedListener = new AnimationDrawableLoadedListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.8
            @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
            public void onLoadedSuccess(AnimationDrawable animationDrawable) {
                CanvasTitleView.this.mSignatureAnimationDrawable = animationDrawable;
                CanvasTitleView.this.getHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            CanvasTitleView canvasTitleView = CanvasTitleView.this;
                            if (canvasTitleView.qzone_vip_signature == null || canvasTitleView.mSignatureAnimationDrawable == null) {
                                return;
                            }
                            CanvasTitleView canvasTitleView2 = CanvasTitleView.this;
                            canvasTitleView2.qzone_vip_signature.setImageDrawable(canvasTitleView2.mSignatureAnimationDrawable);
                            CanvasTitleView.this.qzone_vip_signature.setScaleType(ImageView.ScaleType.FIT_XY);
                            CanvasTitleView.this.mSignatureAnimationDrawable.setOneShot(false);
                            CanvasTitleView.this.mSignatureAnimationDrawable.setCallback(CanvasTitleView.this.mSignatureCallback);
                            CanvasTitleView.this.mSignatureAnimationDrawable.start();
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                });
                super.onLoadedSuccess(animationDrawable);
            }

            @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
            public void onNewLoadSuccess(final c cVar) {
                CanvasTitleView.this.getHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DittoImageArea dittoImageArea = CanvasTitleView.this.qzone_vip_signature;
                            if (dittoImageArea != null) {
                                dittoImageArea.setImageDrawable(cVar.getDrawable());
                                CanvasTitleView.this.qzone_vip_signature.setScaleType(ImageView.ScaleType.FIT_XY);
                                cVar.getDrawable().setCallback(CanvasTitleView.this.mSignatureCallback);
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                });
            }
        };
        this.mFeedVipResourceListener = new j() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.9
            @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
            public void onLoaded(final Drawable drawable) {
                CanvasTitleView.this.getHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BusinessFeedData businessFeedData = CanvasTitleView.this.mFeedData;
                        if (businessFeedData == null || businessFeedData.getUser() == null || businessFeedData.isQQUnionVip() || drawable == null) {
                            return;
                        }
                        CanvasTitleView.this.icon_YellowVip_staticpic.setVisibility(0);
                        CanvasTitleView.this.icon_YellowVip_staticpic.setImageDrawable(drawable);
                        boolean z16 = businessFeedData.getUser().isCustomDiamond;
                        int i3 = businessFeedData.getUser().vip;
                        if (z16 || i3 != 2) {
                            return;
                        }
                        Drawable drawable2 = drawable;
                        if (drawable2 instanceof a) {
                            CanvasTitleView.this.icon_YellowVip_gif.setMargin(((a) drawable2).b(), ((a) drawable).c(), 0, 0);
                            if (businessFeedData.getCellUserInfo().getLuckyMoneyPics() != null && businessFeedData.getCellUserInfo().getLuckyMoneyPics().size() > 0) {
                                CanvasTitleView.this.icon_YellowVip_gif.setVisibility(8);
                            } else {
                                CanvasTitleView.this.icon_YellowVip_gif.setVisibility(0);
                            }
                        }
                    }
                });
            }

            @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
            public void onFailed() {
            }
        };
        this.lvTenCallback = new Drawable.Callback() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.10
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                DittoImageArea dittoImageArea = CanvasTitleView.this.icon_qq_union_vip;
                if (dittoImageArea != null) {
                    dittoImageArea.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            }
        };
        this.mFeedSkinZipAnimationCallback = new Drawable.Callback() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.11
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                DittoImageArea dittoImageArea = CanvasTitleView.this.feed_skin_animation_container;
                if (dittoImageArea != null) {
                    dittoImageArea.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            }
        };
        this.mSignatureCallback = new Drawable.Callback() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.12
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                DittoImageArea dittoImageArea = CanvasTitleView.this.qzone_vip_signature;
                if (dittoImageArea != null) {
                    dittoImageArea.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
                CanvasTitleView.this.scheduleDrawable(drawable, runnable, j3);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                CanvasTitleView.this.unscheduleDrawable(drawable, runnable);
            }
        };
        this.mQQUnionZipAnimationCallback = new Drawable.Callback() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.13
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                DittoImageArea dittoImageArea = CanvasTitleView.this.feed_skin_animation_container;
                if (dittoImageArea != null) {
                    dittoImageArea.invalidate();
                }
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            }
        };
        init();
    }

    private DittoArea buildNamePlateArea(final NamePlate namePlate) {
        String str = namePlate.icon;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LayoutAttrSet layoutAttrSet = new LayoutAttrSet();
        layoutAttrSet.leftMargin = ViewUtils.dpToPx(6.0f);
        layoutAttrSet.centerVertical = true;
        layoutAttrSet.width = -2;
        layoutAttrSet.height = ViewUtils.dpToPx(16.0f);
        final AsyncCanvasImageArea asyncCanvasImageArea = new AsyncCanvasImageArea(this.name_plate_layout.mHost, layoutAttrSet);
        Drawable loadImage = ImageLoader.getInstance().loadImage(PictureUrl.calculateImageUrl(str), str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.6
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                if (drawable == null) {
                    return;
                }
                asyncCanvasImageArea.setImageDrawable(drawable);
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
        }, null);
        if (loadImage != null) {
            asyncCanvasImageArea.setImageDrawable(loadImage);
        }
        asyncCanvasImageArea.clickListener = new DittoArea.ClickListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.7
            @Override // com.tencent.ditto.area.DittoArea.ClickListener
            public void onClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
                d.c(namePlate.jumpurl, CanvasTitleView.this.getContext());
                CanvasTitleView canvasTitleView = CanvasTitleView.this;
                canvasTitleView.reportNamePlate(2, canvasTitleView.mFeedData, namePlate.nameplateid);
            }
        };
        reportNamePlate(1, this.mFeedData, namePlate.nameplateid);
        return asyncCanvasImageArea;
    }

    private void centerLine1() {
        this.line_1.getLayoutAttr().alignParentTop = false;
        this.line_1.getLayoutAttr().centerVertical = true;
        this.line_1.getLayoutAttr().mAttrs.put(LayoutAttrDefine.ALIGN_PARENT_TOP, Boolean.FALSE);
        this.line_1.getLayoutAttr().mAttrs.put(LayoutAttrDefine.CENTER_VERTICAL, Boolean.TRUE);
    }

    public static String getCompleteUrl(String str) {
        Matcher matcher = Pattern.compile("((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?", 2).matcher(str);
        matcher.find();
        return matcher.group();
    }

    private void init() {
        setContentAreaForJsonFile("qzone_canvas_ui_titleview.json");
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        this.mAvatarDecorateOptions = obtain;
        obtain.clipHeight = AreaConst.dp59;
        obtain.clipWidth = AreaConst.dp52;
        int screenWidth = FeedGlobalEnv.g().getScreenWidth();
        int i3 = (screenWidth * 60) / 640;
        if (FeedGlobalEnv.g().getDensityDpi() >= 560) {
            i3 = (int) (((screenWidth * 90) / SubAccountBindActivity.ERROR_ACCOUNT_LOCK) + 0.5f);
        }
        ImageLoader.Options obtain2 = ImageLoader.Options.obtain();
        this.mFeedSkinOptions = obtain2;
        obtain2.clipHeight = i3;
        obtain2.clipWidth = screenWidth;
        obtain2.priority = false;
        obtain2.imageConfig = Bitmap.Config.ARGB_4444;
        obtain2.preferQuality = false;
        this.gapAlpha = 255;
        Paint paint = new Paint();
        this.gapPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        AsyncCanvasImageArea asyncCanvasImageArea = this.icon_familyMedal;
        if (asyncCanvasImageArea != null) {
            asyncCanvasImageArea.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    private boolean isResizeSimpleFirstFeedHeight() {
        if (!SimpleModelUtils.isFirstFeed(this.feedPosition)) {
            return false;
        }
        boolean isSimpleModeFeed = SimpleModelUtils.isSimpleModeFeed();
        boolean z16 = !SimpleModelUtils.isLoadFeedSkin(this.mFeedData, canShowFeedSkin());
        boolean isFeedSkinPlus = SimpleModelUtils.isFeedSkinPlus(this.mFeedData);
        SimpleModelUtils.printDebugLog("[isResizeSimpleFirstFeedHeight] isSimpleModeFirstFeed: " + isSimpleModeFeed + " | isNotLoadFeedSkin: " + z16 + " | isFeedSkinPlus: " + isFeedSkinPlus);
        if (isSimpleModeFeed) {
            return z16 || isFeedSkinPlus;
        }
        return false;
    }

    private boolean isSetVipSignature() {
        CellFeedSignature cellFeedSignature;
        BusinessFeedData businessFeedData = this.mFeedData;
        return (businessFeedData == null || (cellFeedSignature = businessFeedData.cellFeedSignature) == null || TextUtils.isEmpty(cellFeedSignature.strUrl)) ? false : true;
    }

    private boolean playLVTenNamePlate(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ((IVipIconUtils) QRoute.api(IVipIconUtils.class)).getQzoneNamePlateDrawable(str, new Function1<IVipFrameDrawable, Unit>() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.1
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(IVipFrameDrawable iVipFrameDrawable) {
                if (iVipFrameDrawable == null) {
                    return null;
                }
                Drawable drawable = iVipFrameDrawable.getDrawable();
                if (drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0) {
                    CanvasTitleView.this.updateLayout(drawable);
                }
                return null;
            }
        });
        return true;
    }

    private void playNormalNamePlate(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mQQUnionVipAnimation == null || !str.equals(((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getAnimationResZipUrl(this.mQQUnionVipAnimation))) {
            if (this.mQQUnionVipAnimation == null) {
                this.mQQUnionVipAnimation = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
            }
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.mQQUnionVipAnimation, str, 10);
            this.mIsFeedSkinFirstLoad = false;
        }
        this.mQQUnionVipAnimation.setCallback(this.mQQUnionZipAnimationCallback);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.mQQUnionVipAnimation, DRAWABLE_SCALE);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(this.mQQUnionVipAnimation);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.mQQUnionVipAnimation, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.mQQUnionVipAnimation, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.mQQUnionVipAnimation);
        this.icon_qq_union_vip.setImageDrawable(this.mQQUnionVipAnimation);
    }

    private boolean playTenYellowNamePlate(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Drawable qzoneLetterSwitchIcon = ((IVipIconUtilsForQzone) QRoute.api(IVipIconUtilsForQzone.class)).getQzoneLetterSwitchIcon(str2, Arrays.asList(str.split("#")), "bg.png", "fc.png", ViewUtils.dpToPx(i3));
        qzoneLetterSwitchIcon.setCallback(this.mQQUnionZipAnimationCallback);
        this.icon_qq_union_vip.setImageDrawable(qzoneLetterSwitchIcon);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportNamePlate(int i3, BusinessFeedData businessFeedData, int i16) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = 201;
        lpReportInfo_pf00064.subactionType = 6;
        lpReportInfo_pf00064.reserves = i3;
        lpReportInfo_pf00064.reserves5 = String.valueOf(i16);
        if (businessFeedData != null) {
            lpReportInfo_pf00064.reserves6 = String.valueOf(businessFeedData.getUser().uin);
        }
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false);
    }

    private void resetFeedSkinAnimation() {
        if (this.mFeedSkinAnimation != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.mFeedSkinAnimation);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.mFeedSkinAnimation);
            this.mFeedSkinAnimation = null;
        }
        DittoImageArea dittoImageArea = this.feed_skin_animation_container;
        if (dittoImageArea != null) {
            dittoImageArea.setImageDrawable(null);
            this.feed_skin_animation_container.setVisibility(8);
        }
    }

    private void resetLine1() {
        this.line_1.getLayoutAttr().alignParentTop = true;
        this.line_1.getLayoutAttr().centerVertical = false;
        this.line_1.getLayoutAttr().mAttrs.put(LayoutAttrDefine.ALIGN_PARENT_TOP, Boolean.TRUE);
        this.line_1.getLayoutAttr().mAttrs.put(LayoutAttrDefine.CENTER_VERTICAL, Boolean.FALSE);
    }

    private void resetQQUnionAnimation() {
        if (this.mQQUnionVipAnimation != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.mQQUnionVipAnimation);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.mQQUnionVipAnimation);
            this.mQQUnionVipAnimation = null;
        }
    }

    private void resetSignatureAnimation() {
        AnimationDrawable animationDrawable = this.mSignatureAnimationDrawable;
        if (animationDrawable != null) {
            tryRecycleAnimationDrawable(animationDrawable);
            this.mSignatureAnimationDrawable = null;
        }
    }

    private void setDescAreaClickAble() {
        BusinessFeedData businessFeedData;
        RichCanvasTextArea richCanvasTextArea = this.qzonedesc_area;
        if (richCanvasTextArea == null || richCanvasTextArea.getTextArea() == null || (businessFeedData = this.mFeedData) == null) {
            return;
        }
        if (QZoneAdFeedDataExtKt.isLocalAd(businessFeedData)) {
            this.qzonedesc_area.getTextArea().setCellClickable(false);
        } else {
            this.qzonedesc_area.getTextArea().setCellClickable(true);
        }
    }

    private boolean showFeedSkin() {
        return (this.mHasInterest || this.mHasRecommHeader || (this.mFeedData.getFeedCommInfo().isTopFeed() && this.mFeedData.feedType == 3) || showUpperBanner() || showRecommendListHeader()) ? false : true;
    }

    private boolean showHighFiveButton(BusinessFeedData businessFeedData) {
        return TitleAttachArea.showHigh5Button(businessFeedData) || TitleAttachArea.needHighlightHigh5Button(businessFeedData) || TitleAttachArea.showMultipleHighFiveIcon(businessFeedData);
    }

    private void showQzoneDesc() {
        resetSignatureAnimation();
        if (isSetVipSignature()) {
            cooperation.vip.c.b(141, 1);
            this.qzone_vip_signature.setVisibility(0);
            String str = this.mFeedData.cellFeedSignature.strUrl;
            QzoneZipAnimateUtil.j(str, "vip_signature", str.hashCode() + "", -1, -1, 100, this.animationDrawableLoadedListener);
            CellFeedSignature cellFeedSignature = this.mFeedData.cellFeedSignature;
            if (cellFeedSignature.iWidth <= 0 || cellFeedSignature.iHeight <= 0) {
                return;
            }
            LayoutAttrSet layoutAttr = this.qzone_vip_signature.getLayoutAttr();
            layoutAttr.width = ViewUtils.dpToPx(this.mFeedData.cellFeedSignature.iWidth);
            layoutAttr.height = ViewUtils.dpToPx(this.mFeedData.cellFeedSignature.iHeight);
            layoutAttr.topMargin = ViewUtils.dpToPx(1.0f);
            return;
        }
        if (this.mFeedData.getUser() == null || TextUtils.isEmpty(this.mFeedData.getUser().qzoneDesc)) {
            return;
        }
        cooperation.vip.c.b(140, 1);
        this.qzonedesc_area.setVisibility(0);
        this.qzonedesc_area.setAreaCacheKey(this.mFeedData.getUser().integerDesuniKey);
        this.qzonedesc_area.setMaxLines(1);
        if (QZoneAdFeedDataExtKt.isLocalAd(this.mFeedData)) {
            if (i.H().p1()) {
                this.qzonedesc_area.setText(AreaManager.getInstance().convertNetImageCellDp2Px(this.mFeedData.getUser().qzoneDesc.replace(getCompleteUrl(this.mFeedData.getUser().qzoneDesc), feedLocalAdIconUrl).replace("18", "28").replace("22", "28")));
                this.qzonedesc_area.setLinkColor(Color.parseColor("#66EBEBF5"));
                return;
            }
            this.qzonedesc_area.setText(AreaManager.getInstance().convertNetImageCellDp2Px(this.mFeedData.getUser().qzoneDesc));
            return;
        }
        this.qzonedesc_area.setText(this.mFeedData.getUser().qzoneDesc);
    }

    private boolean showRecommendListHeader() {
        ArrayList<CellRecommendList.RecommendMan> userList;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || !businessFeedData.getFeedCommInfo().isShowFeedRecommend()) {
            return false;
        }
        BusinessFeedData businessFeedData2 = this.mFeedData;
        return (businessFeedData2.feedType == 2 || (userList = businessFeedData2.getCellRecommendListSafe().getUserList()) == null || userList.size() <= 0) ? false : true;
    }

    private boolean showUpperBanner() {
        BusinessFeedData businessFeedData = this.mFeedData;
        return (businessFeedData.feedType == 2 || businessFeedData.getUpperBanner() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout(Drawable drawable) {
        LayoutAttrSet layoutAttr = this.icon_qq_union_vip.getLayoutAttr();
        layoutAttr.width = (drawable.getIntrinsicWidth() * ViewUtils.dip2px(20.0f)) / drawable.getIntrinsicHeight();
        layoutAttr.height = ViewUtils.dip2px(20.0f);
        layoutAttr.centerVertical = true;
        this.icon_qq_union_vip.setLayoutAttr(layoutAttr);
        drawable.setCallback(this.lvTenCallback);
        this.icon_qq_union_vip.width = drawable.getMinimumWidth();
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.icon_qq_union_vip.setImageDrawable(drawable);
        drawable.setCallback(this.lvTenCallback);
        this.icon_qq_union_vip.width = drawable.getMinimumWidth();
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.icon_qq_union_vip.setImageDrawable(drawable);
    }

    public boolean canShowFeedSkin() {
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || businessFeedData.getUser() == null || !hasValidUserInfo(this.mFeedData.getUser()) || this.mIsForward || !i.H().d1() || showUpperBanner() || showRecommendListHeader() || i.H().p1()) {
            return false;
        }
        if (this.mFeedData.getCellLuckyMoney() == null) {
            return (this.mIsPassive || AreaManager.IS_NIGHT_MODE || i.H().u1(this.mFeedData) || this.mFeedData.getFeedCommInfo().recomtype == 7 || this.mFeedData.getFeedCommInfo().isBizRecomFeeds() || this.mHasInterest || this.mFeedData.isSubFeed) ? false : true;
        }
        return true;
    }

    void drawFakeGap(Canvas canvas) {
        if (!FeedUtil.isCurrentFeedAdvFeedTopAfter(this.mFeedData) || this.mIsForward || this.mHasRecommHeader || this.mHasInterest || this.mIsAdvContainerFeed) {
            BusinessFeedData businessFeedData = this.mFeedData;
            if (businessFeedData != null && businessFeedData.ignoreTitleGap != 0) {
                this.gapPaint.setAlpha(255);
                this.gapPaint.setColor(com.qzone.adapter.feedcomponent.j.m());
                float screenWidth = FeedGlobalEnv.g().getScreenWidth();
                int i3 = AreaConst.FEED_BACKGROUND_PART1_HEIGHT;
                canvas.drawRect(0.0f, 0.0f, screenWidth, i3, this.gapPaint);
                this.gapPaint.setColor(com.qzone.adapter.feedcomponent.j.H());
                if ((this.mFeedData.ignoreTitleGap & 2) != 0) {
                    canvas.drawRect(AreaConst.dp8, i3 - AreaConst.dp0_5, FeedGlobalEnv.g().getScreenWidth() - r1, i3, this.gapPaint);
                    return;
                }
                return;
            }
            if (i.q1() && !this.mIsForward && !this.mHasInterest) {
                this.gapPaint.setColor(com.qzone.adapter.feedcomponent.j.s());
                this.gapPaint.setAlpha(this.gapAlpha);
                canvas.drawRect(0.0f, 0.0f, FeedGlobalEnv.g().getScreenWidth(), AreaConst.FEED_BACKGROUND_PART1_HEIGHT, this.gapPaint);
                return;
            }
            boolean z16 = !i.f41890d || i.O0();
            if (!i.f41893g || !i.O0() || this.mIsForward || this.mHasRecommHeader || this.mHasInterest || this.mIsAdvContainerFeed) {
                return;
            }
            if (this.gapAlpha == 255) {
                if (z16) {
                    this.gapPaint.setColor(com.qzone.adapter.feedcomponent.j.s());
                    this.gapPaint.setAlpha(this.gapAlpha);
                    canvas.drawRect(0.0f, 0.0f, FeedGlobalEnv.g().getScreenWidth(), AreaConst.FEED_BACKGROUND_PART1_HEIGHT, this.gapPaint);
                    return;
                } else {
                    this.gapPaint.setColor(com.qzone.adapter.feedcomponent.j.m());
                    canvas.drawRect(0.0f, 0.0f, FeedGlobalEnv.g().getScreenWidth(), AreaConst.FEED_BACKGROUND_PART1_HEIGHT, this.gapPaint);
                    return;
                }
            }
            if (z16) {
                this.gapPaint.setColor(com.qzone.adapter.feedcomponent.j.s());
                this.gapPaint.setAlpha(this.gapAlpha);
                canvas.drawRect(0.0f, 0.0f, FeedGlobalEnv.g().getScreenWidth(), AreaConst.FEED_BACKGROUND_PART1_HEIGHT, this.gapPaint);
            } else {
                this.gapPaint.setColor(com.qzone.adapter.feedcomponent.j.m());
                this.gapPaint.setAlpha(this.gapAlpha);
                canvas.drawRect(0.0f, 0.0f, FeedGlobalEnv.g().getScreenWidth(), AreaConst.FEED_BACKGROUND_PART1_HEIGHT, this.gapPaint);
            }
        }
    }

    void drawFeedSkin(Canvas canvas) {
        Drawable drawable = this.customPassiveBubbleSkinDrawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.customPassiveBubbleSkinDrawable.getIntrinsicHeight();
            this.customPassiveBubbleSkinDrawable.setBounds(canvas.getWidth() - ((int) ((intrinsicHeight == 0 ? 1.0f : (canvas.getHeight() - AreaConst.FEED_BACKGROUND_PART1_HEIGHT) / intrinsicHeight) * intrinsicWidth)), AreaConst.FEED_BACKGROUND_PART1_HEIGHT, canvas.getWidth(), canvas.getHeight());
            this.customPassiveBubbleSkinDrawable.draw(canvas);
        }
    }

    public boolean getIsTodayInHistoryDetail() {
        return this.mIsTodayInHistoryDetail;
    }

    public boolean isForward() {
        return this.mIsForward;
    }

    boolean isNeedShowAddFriendBtn() {
        BusinessFeedData businessFeedData = this.mFeedData;
        return businessFeedData != null && businessFeedData.getFeedCommInfo().isNeedAddFriendBtn();
    }

    boolean isNeedShowFollowBtn() {
        int i3;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || !businessFeedData.getFeedCommInfo().isNeedFollowBtn()) {
            return false;
        }
        if (this.mFeedData.getFeedCommInfo().isLikeRecommFamousFeed() && this.mFeedData.getFeedCommInfo().isExistDroplistFollowButton()) {
            return true;
        }
        if (this.isFriendLikeContainer) {
            return !(this.mFeedData.getFeedCommInfo().recomlayout == 1);
        }
        if (this.mFeedData.isBrandUgcAdvFeeds() && this.mFeedData.getCellBottomRecomm() != null) {
            return false;
        }
        if (!this.mIsForward && this.mFeedData.getCellInterest() == null) {
            BusinessFeedData businessFeedData2 = this.mFeedData;
            if (!businessFeedData2.isSubFeed && (i3 = businessFeedData2.feedType) != 2 && (i3 != 4097 || !businessFeedData2.isBrandUgcAdvFeeds())) {
                BusinessFeedData businessFeedData3 = this.mFeedData;
                if ((businessFeedData3.feedType == 12289 && businessFeedData3.getUser() != null && this.mFeedData.getUser().isCanShowFamousIcon()) || this.mFeedData.isRecommendFeed()) {
                    return true;
                }
                return this.mFeedData.isMsgFeed();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnLongClick(values = {"attach_area"})
    public void onCanvasAreaLongClick(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        b.c("CANVASLOG", "onCanvasAreaLongClicked " + dittoArea.getId());
        if (this.onFeedElementClickListener != null && dittoArea == this.attach_area && i.H().X0()) {
            this.onFeedElementClickListener.a(FeedElement.Debug, Integer.valueOf(this.feedPosition), this, null);
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.tencent.ditto.DittoAreaView, android.view.View
    protected void onDraw(Canvas canvas) {
        setDescAreaClickAble();
        drawFakeGap(canvas);
        drawFeedSkin(canvas);
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

    public void onPause() {
        if (this.mFeedSkinAnimation != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.mFeedSkinAnimation);
        }
        if (this.mQQUnionVipAnimation != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.mQQUnionVipAnimation);
        }
        AnimationDrawable animationDrawable = this.mSignatureAnimationDrawable;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void onStateIdle() {
        CanvasNicknameArea canvasNicknameArea = this.nickname;
        if (canvasNicknameArea != null && canvasNicknameArea.getVisibility() == 0) {
            this.nickname.onStateIdle();
        }
        CanvasGifArea canvasGifArea = this.icon_YellowVip_gif;
        if (canvasGifArea != null && canvasGifArea.getVisibility() == 0) {
            this.icon_YellowVip_gif.playGif();
        }
        if (this.mFeedSkinAnimation != null && this.feed_skin_animation_container.getVisibility() == 0) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.mFeedSkinAnimation);
        }
        if (this.mQQUnionVipAnimation != null && this.icon_qq_union_vip.getVisibility() == 0) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.mQQUnionVipAnimation);
        }
        if (this.mSignatureAnimationDrawable == null || this.qzone_vip_signature.getVisibility() != 0) {
            return;
        }
        this.mSignatureAnimationDrawable.start();
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
        CanvasGifArea canvasGifArea = this.icon_YellowVip_gif;
        if (canvasGifArea != null) {
            canvasGifArea.stopGif();
        }
        if (this.mFeedSkinAnimation != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.mFeedSkinAnimation);
        }
        if (this.mQQUnionVipAnimation != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.mQQUnionVipAnimation);
        }
        AnimationDrawable animationDrawable = this.mSignatureAnimationDrawable;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void setCanComment(boolean z16) {
        this.canComment = z16;
    }

    public void setCanGiveBack(boolean z16) {
        this.canGiveBack = z16;
    }

    public void setCanHuNuan(boolean z16) {
        this.canHuNuan = z16;
    }

    public void setCanJoinAlbum(boolean z16) {
        this.canJoinAlbum = z16;
    }

    public void setCanLookUp(boolean z16) {
        this.canLookUp = z16;
    }

    public void setCanReply(boolean z16) {
        this.canReply = z16;
    }

    public void setCanReturnGift(boolean z16) {
        this.canReturnGift = z16;
    }

    public void setHasInterest(boolean z16) {
        this.mHasInterest = z16;
    }

    public void setIsForward(boolean z16) {
        this.mIsForward = z16;
    }

    public void setIsTodayInHistoryDetail(boolean z16) {
        this.mIsTodayInHistoryDetail = z16;
    }

    public void setJoinedAlbum(boolean z16) {
        this.joinedAlbum = z16;
    }

    public void setVideoPlayInfo(VideoPlayInfo videoPlayInfo) {
        this.videoPlayInfo = videoPlayInfo;
    }

    public void startAvatarRedPocketAnim() {
        if (this.mIsDoingAvatartRedPocketAnim) {
            return;
        }
        this.mIsDoingAvatartRedPocketAnim = true;
        if (this.mAvatarRedPocketAnimRunnable == null) {
            this.mAvatarRedPocketAnimRunnable = new Runnable() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.14
                @Override // java.lang.Runnable
                public void run() {
                    CanvasTitleView.this.avatar.setIsNeedDoRedPocketAnim(true);
                    float redPocketAnimParams = CanvasTitleView.this.avatar.getRedPocketAnimParams();
                    if (redPocketAnimParams < 0.999f) {
                        CanvasTitleView.this.avatar.setRedPocketAnimParams(redPocketAnimParams + ((1.0f - redPocketAnimParams) * 0.2f));
                        if (i.H().g1()) {
                            CanvasTitleView.this.avatar.invalidate();
                        }
                    } else if (redPocketAnimParams < 1.0f) {
                        CanvasTitleView.this.avatar.setRedPocketAnimParams(1.0f);
                        if (i.H().g1()) {
                            CanvasTitleView.this.avatar.invalidate();
                        }
                    } else {
                        CanvasTitleView.this.avatar.setRedPocketAnimParams(0.0f);
                        if (i.H().g1()) {
                            CanvasTitleView.this.avatar.invalidate();
                        }
                    }
                    if (CanvasTitleView.this.avatar.getRedPocketAnimParams() >= 1.0f) {
                        CanvasTitleView.this.getHandler().postDelayed(this, 1000L);
                    } else {
                        CanvasTitleView.this.getHandler().postDelayed(this, 5L);
                    }
                }
            };
        }
        getHandler().postDelayed(this.mAvatarRedPocketAnimRunnable, 100L);
    }

    public void startHighFiveCountAnimation() {
        final String valueOf;
        if (TitleAttachArea.showMultipleHighFiveIcon(this.mFeedData)) {
            long highFiveCount = getHighFiveCount(this.mFeedData) + 1;
            if (highFiveCount > 999) {
                valueOf = HIGH_FIVE_COUNT_THRESHOLD;
            } else {
                valueOf = String.valueOf(highFiveCount);
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -ViewUtils.dpToPx(14.0f));
            AnimationSet animationSet = new AnimationSet(false);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(translateAnimation);
            animationSet.setDuration(480L);
            animationSet.setStartOffset(100L);
            animationSet.start();
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.16
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    CanvasTitleView.this.needShowHighFiveAnimation = false;
                    CanvasTitleView.this.high_five_count_first_area.setTextColor(CanvasTitleView.highFiveCountYellowColor);
                    CanvasTitleView.this.high_five_count_first_area.setText(CanvasTitleView.HIGH_FIVE_COUNT_PRODUCT_SIHN + valueOf);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.high_five_count_first_area.setAnimation(animationSet);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -ViewUtils.dpToPx(14.0f));
            AnimationSet animationSet2 = new AnimationSet(false);
            animationSet2.addAnimation(alphaAnimation2);
            animationSet2.addAnimation(translateAnimation2);
            animationSet2.setDuration(480L);
            animationSet2.setStartOffset(100L);
            animationSet2.start();
            this.high_five_count_second_area.setText(HIGH_FIVE_COUNT_PRODUCT_SIHN + valueOf);
            this.high_five_count_second_area.setTextColor(highFiveCountYellowColor);
            this.high_five_count_second_area.setAnimation(animationSet2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:273:0x078c, code lost:
    
        if (r7.feedType != 4097) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0795, code lost:
    
        r1 = r1.getUser().underNicknameDesc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x079f, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) != false) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x07a7, code lost:
    
        if (r23.mFeedData.getFeedCommInfo() == null) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x07b3, code lost:
    
        if (r23.mFeedData.getFeedCommInfo().isLikeRecommFamousFeed() == false) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x07b5, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x07c2, code lost:
    
        if (r23.mFeedData.getFeedCommInfo().isExistDroplistFollowButton() == false) goto L326;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x07c4, code lost:
    
        if (r7 != false) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x07c6, code lost:
    
        r7 = r23.mFeedData;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x07ca, code lost:
    
        if (r7.feedType != 12289) goto L326;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x07d0, code lost:
    
        if (r7.getUser() == null) goto L326;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x07dc, code lost:
    
        if (r23.mFeedData.getUser().isCanShowFamousIcon() == false) goto L326;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x07e4, code lost:
    
        if (r23.mFeedData.getCellInterest() != null) goto L326;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x07e6, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x07e9, code lost:
    
        if (r7 == false) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x07ef, code lost:
    
        if (r1.length() <= 7) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x07f1, code lost:
    
        r1 = r1.substring(0, 7) + com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo.APPNAME_SUFFIX;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0807, code lost:
    
        r23.time_area.setVisibility(0);
        r23.time_area.setAreaCacheKey(r23.mFeedData.getIntegerTimeLbsKey());
        r23.time_area.setText(r1);
        r23.time_area.setContentDescription(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x07e8, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x07b7, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x0793, code lost:
    
        if (r1.feedType == r8) goto L306;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x084f, code lost:
    
        if (r23.mFeedData.getUser().isCanShowFamousIcon() != false) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0ac2, code lost:
    
        if (r23.mFeedData.getCellInterest() == null) goto L420;
     */
    /* JADX WARN: Code restructure failed: missing block: B:562:0x0105, code lost:
    
        if (com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt.isLocalAd(r1) == false) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:322:0x08d5  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0e7b  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0acf  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0ae4  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0b02  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x0b6e  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0e48  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x0e56  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x0b87  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x095f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update() {
        CellPermissionInfo permissionInfoV2;
        String valueOf;
        boolean z16;
        boolean z17;
        CellMallInfo.CellSweetVip cellSweetVip;
        QQUnionIconInfo qQUnionIconInfo;
        CanvasGifArea canvasGifArea;
        ImageUrl imageUrl;
        String str;
        int i3;
        String str2;
        String str3;
        PictureUrl pictureUrl;
        ImageUrl imageUrl2;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null && businessFeedData.getUser() != null && hasValidUserInfo(this.mFeedData.getUser())) {
            if (this.mFeedData.isSubOfFriendBirthdayContainerFeed()) {
                setPadding(AreaManager.f48752dp3, 0, 0, 0);
            } else {
                setPadding(0, 0, 0, 0);
            }
            if (QZoneAdFeedDataExtKt.isAdLittleIconStyle(this.mFeedData)) {
                setVisibility(8);
                return;
            }
            setContentAreaForJsonFile("qzone_canvas_ui_titleview.json");
            if (showUpperBanner()) {
                CellUpperBanner upperBanner = this.mFeedData.getUpperBanner();
                this.title_upper_banner.setBackgroundColor(com.qzone.adapter.feedcomponent.j.s());
                this.title_upper_banner.setVisibility(0);
                this.upper_banner_background_image.setScaleType(ImageView.ScaleType.FIT_XY);
                PictureItem pictureItem = upperBanner.picdata;
                if (pictureItem != null && (pictureUrl = pictureItem.currentUrl) != null && (imageUrl2 = pictureUrl.imageUrl) != null) {
                    this.upper_banner_background_image.setAsyncImage(imageUrl2, imageUrl2.url, AreaManager.FEED_TITLE_UPPER_BANNER_BG, null, AreaConst.SCREEN_WIDTH, AreaConst.dp77);
                }
                this.upper_banner_title.setText(upperBanner.title);
                this.upper_banner_summary.setText(upperBanner.summary);
                if (h.b("QZoneSetting", "FeedShowTitleUpperBannerCloseIcon", 1) != 0) {
                    this.upper_banner_close_button.setBackgroundDrawable(AreaManager.ADV_CLOSE_DRAWABLE);
                    this.upper_banner_close_button.setVisibility(0);
                } else {
                    this.upper_banner_close_button.setVisibility(8);
                }
            } else {
                this.title_upper_banner.setVisibility(8);
            }
            if (showRecommendListHeader()) {
                this.recommend_list_header.setData(this.mFeedData.getCellRecommendList(), this);
                this.recommend_list_header.setVisibility(0);
                this.recommend_list_header_split_line.setVisibility(0);
            } else {
                this.recommend_list_header.setVisibility(8);
                this.recommend_list_header_split_line.setVisibility(8);
            }
            AsyncCanvasImageArea asyncCanvasImageArea = this.icon_familyMedal;
            if (asyncCanvasImageArea != null) {
                asyncCanvasImageArea.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            if (this.mFeedData.isGDTAdvFeed()) {
                if (!this.mFeedData.isBrandUgcAdvFeeds() || this.mFeedData.feedType != 4097) {
                    BusinessFeedData businessFeedData2 = this.mFeedData;
                    if (businessFeedData2.feedType == 2) {
                    }
                }
                this.line_2.setVisibility(8);
                if (getVisibility() != 0) {
                    setVisibility(0);
                }
                updateSimpleInfo();
                resetFeedSkinAnimation();
                if (!this.mIsForward) {
                    updateAccessibility();
                    return;
                }
                boolean z18 = this.mFeedData.isSingleAdvContainerFeed() || this.mFeedData.isSubOfMultiAdvContainerFeed();
                String str4 = "";
                if (canShowFeedSkin()) {
                    FeedSkinData cellFeedSkinInfo = this.mFeedData.getCellFeedSkinInfo();
                    if (cellFeedSkinInfo != null) {
                        str3 = cellFeedSkinInfo.sSkinId;
                        i3 = cellFeedSkinInfo.nSkinType;
                        str2 = cellFeedSkinInfo.sPicUrl;
                    } else {
                        i3 = 0;
                        str2 = "";
                        str3 = null;
                    }
                    CellCover coverInfo = this.mFeedData.getCoverInfo();
                    if (coverInfo != null) {
                        str3 = coverInfo.coverId;
                        i3 = coverInfo.cover_type;
                        str2 = i.H().C0(str3);
                    }
                    if ((TextUtils.isEmpty(str3) || "-1".equals(str3)) && b.g()) {
                        b.a("canvastitleview", "@newcard update coverId is null");
                    }
                    if (!TextUtils.isEmpty(str3) && i3 != 392) {
                        if (!TextUtils.isEmpty(str2) && showFeedSkin()) {
                            this.feed_skin.setVisibility(0);
                            this.feed_skin.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            this.feed_skin.setAsyncImageZeroBound(null, str2, null, this.mFeedSkinOptions);
                        } else {
                            this.feed_skin.setVisibility(8);
                        }
                    } else if (!TextUtils.isEmpty(str3)) {
                        this.feed_skin.setVisibility(4);
                        this.feed_skin.setAsyncImage(null, null, null, null);
                    } else {
                        this.feed_skin.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(cellFeedSkinInfo.strFrameZip) && cellFeedSkinInfo.iFrameRate > 0 && !isSpecialSkin(cellFeedSkinInfo)) {
                        this.mFeedSkinAnimation = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
                        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.mFeedSkinAnimation, cellFeedSkinInfo.strFrameZip, cellFeedSkinInfo.iFrameRate);
                        this.mFeedSkinAnimation.setCallback(this.mFeedSkinZipAnimationCallback);
                        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.mFeedSkinAnimation, DRAWABLE_SCALE);
                        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(this.mFeedSkinAnimation);
                        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.mFeedSkinAnimation, true);
                        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.mFeedSkinAnimation, true);
                        this.mIsFeedSkinFirstLoad = false;
                        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.mFeedSkinAnimation);
                        this.feed_skin_animation_container.getLayoutAttr().width = (int) ((ViewUtils.getScreenWidth() * u.CTRL_INDEX) / 720.0f);
                        this.feed_skin_animation_container.getLayoutAttr().height = (int) ((ViewUtils.getScreenWidth() * 128) / 720.0f);
                        this.feed_skin_animation_container.requestLayout();
                        this.feed_skin_animation_container.setVisibility(0);
                        this.feed_skin_animation_container.setImageDrawable(this.mFeedSkinAnimation);
                        this.feed_skin_animation_container.setScaleType(ImageView.ScaleType.FIT_XY);
                    }
                } else {
                    this.feed_skin.setVisibility(8);
                }
                if (this.mIsPassive) {
                    FeedSkinData cellFeedSkinInfo2 = this.mFeedData.getCellFeedSkinInfo();
                    if (cellFeedSkinInfo2 != null) {
                        str = cellFeedSkinInfo2.customBubbleSkinUrl;
                        imageUrl = cellFeedSkinInfo2.customBubbleSkinImageUrl;
                    } else {
                        imageUrl = null;
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        ImageLoader.Options obtain = ImageLoader.Options.obtain();
                        obtain.useMainThread = true;
                        Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.2
                            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                            public void onImageLoaded(String str5, Drawable drawable, ImageLoader.Options options) {
                                CanvasTitleView.this.customPassiveBubbleSkinDrawable = drawable;
                                CanvasTitleView.this.postInvalidate();
                            }

                            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                            public void onImageCanceled(String str5, ImageLoader.Options options) {
                            }

                            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                            public void onImageFailed(String str5, ImageLoader.Options options) {
                            }

                            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                            public void onImageProgress(String str5, float f16, ImageLoader.Options options) {
                            }
                        }, obtain);
                        if (loadImage != null) {
                            this.customPassiveBubbleSkinDrawable = loadImage;
                        }
                    } else {
                        this.customPassiveBubbleSkinDrawable = null;
                    }
                } else {
                    this.customPassiveBubbleSkinDrawable = null;
                }
                User user = this.mFeedData.getUser();
                if (user != null) {
                    this.avatar.setVisibility(0);
                    this.avatar.setUser(user);
                    if (this.mFeedData.getCellUserInfo().getLuckyMoneyPics() != null && this.mFeedData.getCellUserInfo().getLuckyMoneyPics().size() > 0) {
                        this.avatar.setIsNeedDoRedPocketAnim(true);
                        this.nickname.setAvatarRedPocketAnimState(true);
                        CanvasGifArea canvasGifArea2 = this.icon_YellowVip_gif;
                        if (canvasGifArea2 != null && canvasGifArea2.getVisibility() == 0) {
                            this.icon_YellowVip_gif.setVisibility(8);
                        }
                        startAvatarRedPocketAnim();
                    } else {
                        this.avatar.setIsNeedDoRedPocketAnim(false);
                        this.nickname.setAvatarRedPocketAnimState(false);
                        if (this.mAvatarRedPocketAnimRunnable != null) {
                            getHandler().removeCallbacks(this.mAvatarRedPocketAnimRunnable);
                            this.mAvatarRedPocketAnimRunnable = null;
                            this.avatar.invalidate();
                            this.mIsDoingAvatartRedPocketAnim = false;
                        }
                    }
                    UserMedal userMedal = user.famousSpaceMedal;
                    if (userMedal != null && !TextUtils.isEmpty(userMedal.picUrl)) {
                        byte b16 = user.vipShowType;
                        int i16 = (b16 == 4 || b16 == 8) ? AsyncCanvasImageArea.DEFAULT_FAMOUS_ICON_HEIGHT : AsyncCanvasImageArea.DEFAULT_RIGHT_ICON_HEIGHT;
                        CanvasAvatarArea canvasAvatarArea = this.avatar;
                        UserMedal userMedal2 = user.famousSpaceMedal;
                        canvasAvatarArea.setRightCornerIcon(userMedal2.imageUrl, userMedal2.picUrl, i16);
                        this.avatar_decoration.setVisibility(8);
                    } else {
                        this.avatar.setRightCornerIcon(null, null);
                        if (!TextUtils.isEmpty(user.feedAvatarDecorationUrl)) {
                            this.avatar_decoration.setVisibility(0);
                            this.avatar_decoration.setScaleType(ImageView.ScaleType.FIT_XY);
                            this.avatar_decoration.setAsyncImage(user.feedAvatarDecorationImageUrl, user.feedAvatarDecorationUrl, null, this.mAvatarDecorateOptions, AreaConst.dp52, AreaConst.dp59);
                            LayoutAttrSet layoutAttr = this.avatar.getLayoutAttr();
                            int i17 = AreaManager.dp37;
                            layoutAttr.width = (int) (i17 * 0.95d);
                            this.avatar.getLayoutAttr().height = (int) (i17 * 0.95d);
                        } else {
                            this.avatar_decoration.setVisibility(8);
                            LayoutAttrSet layoutAttr2 = this.avatar.getLayoutAttr();
                            int i18 = AreaManager.dp37;
                            layoutAttr2.width = i18;
                            this.avatar.getLayoutAttr().height = i18;
                        }
                    }
                    if (this.avatar_bottom_bar_container != null && this.avatar_bottom_bar != null) {
                        if (TextUtils.isEmpty(user.avatarRecomBar)) {
                            this.avatar_bottom_bar.setVisibility(8);
                            this.avatar_bottom_bar_container.setVisibility(8);
                        } else {
                            this.avatar_bottom_bar.setBackgroundDrawable(AVATAR_BOTTOM_BAR_BACKGROUND_DRAWABLE);
                            this.avatar_bottom_bar.setText(user.avatarRecomBar);
                            this.avatar_bottom_bar.setVisibility(0);
                            this.avatar_bottom_bar_container.setVisibility(0);
                        }
                    }
                    if (user.isCanShowStarVip() && !z18 && !this.mFeedData.getFeedCommInfo().isBizRecomFeeds()) {
                        Drawable D0 = i.H().D0(user, new j() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.3
                            @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
                            public void onLoaded(Drawable drawable) {
                                CanvasTitleView.this.icon_starvip.setImageDrawable(drawable);
                            }

                            @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
                            public void onFailed() {
                            }
                        });
                        if (D0 != null) {
                            this.icon_starvip.setVisibility(0);
                            this.icon_starvip.setImageDrawable(D0);
                            i.H().h2();
                        } else {
                            this.icon_starvip.setVisibility(8);
                        }
                    } else {
                        this.icon_starvip.setVisibility(8);
                    }
                    if (user.isEnableShowIcon(1L) && !this.mFeedData.getFeedCommInfo().isBizRecomFeeds() && !z18) {
                        this.yellowdiamond_container.setVisibility(0);
                        int i19 = user.vip;
                        boolean z19 = user.isCustomDiamond;
                        if (!z19 && i19 == 2 && (canvasGifArea = this.icon_YellowVip_gif) != null) {
                            canvasGifArea.setGifImage(user.yellowDiamondUrl, ViewUtils.dip2px(19.2f), ViewUtils.dip2px(19.2f), false, new AutoGifDrawable.GifDownloadCallBackListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.4
                                @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                                public void onImageLoaded(String str5, Drawable drawable, ImageLoader.Options options) {
                                    if (CanvasTitleView.this.getHandler() != null) {
                                        CanvasTitleView.this.getHandler().post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.4.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                CanvasGifArea canvasGifArea3 = CanvasTitleView.this.icon_YellowVip_gif;
                                                if (canvasGifArea3 != null) {
                                                    canvasGifArea3.playGif();
                                                }
                                            }
                                        });
                                    }
                                }

                                @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                                public void onImageCanceled(String str5, ImageLoader.Options options) {
                                }

                                @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                                public void onImageFailed(String str5, ImageLoader.Options options) {
                                }

                                @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
                                public void onImageProgress(String str5, float f16, ImageLoader.Options options) {
                                }
                            });
                        } else {
                            CanvasGifArea canvasGifArea3 = this.icon_YellowVip_gif;
                            if (canvasGifArea3 != null) {
                                canvasGifArea3.setVisibility(8);
                            }
                        }
                        Drawable M0 = i.H().M0(user, this.mFeedVipResourceListener);
                        if (M0 != null) {
                            i.H().r2(this.mFeedData);
                            this.icon_YellowVip_staticpic.setVisibility(0);
                            this.icon_YellowVip_staticpic.setImageDrawable(M0);
                            this.icon_YellowVip_staticpic.setScaleType(ImageView.ScaleType.MATRIX);
                            if (!z19 && i19 == 2 && this.icon_YellowVip_gif != null && (M0 instanceof a)) {
                                a aVar = (a) M0;
                                this.icon_YellowVip_gif.setMargin(aVar.b(), aVar.c(), 0, 0);
                                BusinessFeedData businessFeedData3 = this.mFeedData;
                                if (businessFeedData3 != null && businessFeedData3.getCellUserInfo().getLuckyMoneyPics() != null && this.mFeedData.getCellUserInfo().getLuckyMoneyPics().size() > 0) {
                                    this.icon_YellowVip_gif.setVisibility(8);
                                } else {
                                    this.icon_YellowVip_gif.setVisibility(0);
                                    this.icon_YellowVip_gif.playGif();
                                }
                            }
                        } else {
                            CanvasGifArea canvasGifArea4 = this.icon_YellowVip_gif;
                            if (canvasGifArea4 != null) {
                                canvasGifArea4.setVisibility(8);
                            }
                            this.yellowdiamond_container.setVisibility(8);
                        }
                    } else {
                        this.yellowdiamond_container.setVisibility(8);
                    }
                    if (!this.mFeedData.getFeedCommInfo().isBizRecomFeeds() && !z18 && (this.mFeedData.isQQUnionVip() || this.mFeedData.isQQNewVip())) {
                        if (this.mFeedData.isQQNewVip()) {
                            qQUnionIconInfo = i.H().w0(-1, QQUnionIconInfo.convertToQQUnionIconMap(this.mFeedData.cellMallInfo.cellQQNewVip.qqNewVipIconMap));
                        } else if (this.mFeedData.isQQUnionVip()) {
                            i H = i.H();
                            CellMallInfo.CellQQUionVip cellQQUionVip = this.mFeedData.cellMallInfo.cellQQUionVip;
                            qQUnionIconInfo = H.w0(cellQQUionVip.iLevel, QQUnionIconInfo.convertToQQUnionIconMap(cellQQUionVip.qqUnionIconMap));
                        } else {
                            qQUnionIconInfo = null;
                        }
                        if (qQUnionIconInfo != null && !TextUtils.isEmpty(qQUnionIconInfo.mIconUrl)) {
                            String str5 = qQUnionIconInfo.mIconUrl;
                            String carouselUrls = QQUnionIconInfo.getCarouselUrls(qQUnionIconInfo);
                            if (!TextUtils.isEmpty(carouselUrls)) {
                                playLVTenNamePlate(carouselUrls);
                            } else {
                                String tenYellowId = QQUnionIconInfo.getTenYellowId(qQUnionIconInfo);
                                if (!TextUtils.isEmpty(tenYellowId)) {
                                    playTenYellowNamePlate(tenYellowId, str5, qQUnionIconInfo.mIconHeight);
                                } else {
                                    playNormalNamePlate(str5);
                                }
                            }
                            if (qQUnionIconInfo.mIconWidth > 0 && qQUnionIconInfo.mIconHeight > 0) {
                                LayoutAttrSet layoutAttr3 = this.icon_qq_union_vip.getLayoutAttr();
                                layoutAttr3.width = ViewUtils.dpToPx(qQUnionIconInfo.mIconWidth / 2.0f);
                                layoutAttr3.height = ViewUtils.dpToPx(qQUnionIconInfo.mIconHeight / 2.0f);
                            }
                            this.yellowdiamond_container.setVisibility(0);
                            this.icon_YellowVip_staticpic.setVisibility(8);
                            CanvasGifArea canvasGifArea5 = this.icon_YellowVip_gif;
                            if (canvasGifArea5 != null) {
                                canvasGifArea5.setVisibility(8);
                            }
                            this.icon_qq_union_vip.setVisibility(0);
                            this.icon_qq_union_vip.setScaleType(ImageView.ScaleType.FIT_XY);
                        } else {
                            this.icon_qq_union_vip.setVisibility(8);
                        }
                    } else {
                        resetQQUnionAnimation();
                        DittoImageArea dittoImageArea = this.icon_qq_union_vip;
                        if (dittoImageArea != null) {
                            dittoImageArea.setImageDrawable(null);
                            this.icon_qq_union_vip.setVisibility(8);
                        }
                    }
                    AsyncCanvasImageArea asyncCanvasImageArea2 = this.icon_familyMedal;
                    if (asyncCanvasImageArea2 != null) {
                        asyncCanvasImageArea2.setVisibility(8);
                    }
                    this.icon_LiveMedal.setVisibility(8);
                    this.icon_Standalone.setVisibility(8);
                    this.name_plate_layout.setVisibility(8);
                    if (user.isSweetVip != 0 && user.vipShowType != 4 && !this.mFeedData.getFeedCommInfo().isBizRecomFeeds()) {
                        this.icon_LoverZone.setVisibility(0);
                        String m06 = i.H().m0(user.uin + "");
                        if (!TextUtils.isEmpty(m06)) {
                            loverZoneIconImageUrl = PictureUrl.calculateImageUrl(m06);
                        } else {
                            CellMallInfo cellMallInfo = this.mFeedData.cellMallInfo;
                            if (cellMallInfo != null && (cellSweetVip = cellMallInfo.cellSweetVip) != null && !TextUtils.isEmpty(cellSweetVip.iconPicUrl)) {
                                m06 = this.mFeedData.cellMallInfo.cellSweetVip.iconPicUrl;
                                loverZoneIconImageUrl = PictureUrl.calculateImageUrl(m06);
                            } else {
                                m06 = loverZoneIconUrlDafult;
                                loverZoneIconImageUrl = PictureUrl.calculateImageUrl(m06);
                            }
                        }
                        Drawable loadImage2 = ImageLoader.getInstance().loadImage(loverZoneIconImageUrl, m06, new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.5
                            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                            public void onImageLoaded(String str6, Drawable drawable, ImageLoader.Options options) {
                                AsyncCanvasImageArea asyncCanvasImageArea3;
                                if (drawable == null || (asyncCanvasImageArea3 = CanvasTitleView.this.icon_LoverZone) == null) {
                                    return;
                                }
                                asyncCanvasImageArea3.setImageDrawable(drawable);
                                BusinessFeedData businessFeedData4 = CanvasTitleView.this.mFeedData;
                                CellFeedCommInfo feedCommInfo = businessFeedData4 == null ? null : businessFeedData4.getFeedCommInfo();
                                if (feedCommInfo != null) {
                                    i.H().d2(feedCommInfo.feedsType);
                                }
                            }

                            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                            public void onImageCanceled(String str6, ImageLoader.Options options) {
                            }

                            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                            public void onImageFailed(String str6, ImageLoader.Options options) {
                            }

                            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                            public void onImageProgress(String str6, float f16, ImageLoader.Options options) {
                            }
                        }, null);
                        if (loadImage2 != null) {
                            this.icon_LoverZone.setImageDrawable(loadImage2);
                            i.H().d2(this.mFeedData.getFeedCommInfo().feedsType);
                        }
                    } else {
                        this.icon_LoverZone.setVisibility(8);
                    }
                    if (user.displayflag == 1) {
                        this.original_flag.setVisibility(0);
                    } else {
                        this.original_flag.setVisibility(8);
                    }
                }
                if (this.mIsPassive && this.mFeedData.getTitleInfoV2() != null && !TextUtils.isEmpty(this.mFeedData.getTitleInfoV2().title)) {
                    this.action_area.setVisibility(0);
                    this.action_area.setText(this.mFeedData.getTitleInfoV2().title);
                } else {
                    this.action_area.setVisibility(8);
                }
                this.del_time_area.setVisibility(8);
                this.time_area.setVisibility(8);
                if (!this.mFeedData.getFeedCommInfo().needAdvReport() && !this.mFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && !this.mFeedData.getFeedCommInfo().isLikeRecommFamousFeed() && (!this.mFeedData.getFeedCommInfo().isBizRecomFeeds() || this.mFeedData.getFeedCommInfo().recomtype == 7 || this.mFeedData.getFeedCommInfo().isPicUpLayout())) {
                    if (this.mFeedData.isDeleteOnTimeFeed()) {
                        this.del_time_area.setVisibility(0);
                        this.time_area.setVisibility(8);
                        this.del_time_area.setAreaCacheKey(this.mFeedData.getIntegerTimeDelKey());
                        TimeCountDownArea timeCountDownArea = this.del_time_area;
                        BusinessFeedData businessFeedData4 = this.mFeedData;
                        timeCountDownArea.setTime(businessFeedData4, businessFeedData4.getFeedCommInfo().feedsDelTime);
                    } else {
                        this.del_time_area.setVisibility(8);
                        String timeLbsStr = this.mFeedData.getTimeLbsStr();
                        if (!TextUtils.isEmpty(timeLbsStr)) {
                            this.time_area.setVisibility(0);
                            this.time_area.setAreaCacheKey(this.mFeedData.getIntegerTimeLbsKey());
                            this.time_area.setText(timeLbsStr);
                            this.time_area.setContentDescription(timeLbsStr);
                        } else {
                            this.time_area.setVisibility(8);
                        }
                    }
                }
                if (!this.mFeedData.isGDTAdvFeed()) {
                    BusinessFeedData businessFeedData5 = this.mFeedData;
                    int i26 = (!businessFeedData5.isSubFeed || (r7 = businessFeedData5.parentFeedData) == null) ? 4097 : 4097;
                }
                if (!this.mFeedData.getFeedCommInfo().isRankingFeeds() && !this.mFeedData.getFeedCommInfo().isMayKnowFriendFeed()) {
                    BusinessFeedData businessFeedData6 = this.mFeedData;
                    if (businessFeedData6.feedType == 12289) {
                        if (businessFeedData6.getUser() != null) {
                        }
                    }
                    if (!this.mFeedData.getFeedCommInfo().isBizRecomFeeds() && this.mFeedData.getReferInfoV2() != null && !TextUtils.isEmpty(this.mFeedData.getReferInfoV2().appName)) {
                        this.refer_area.setVisibility(0);
                        this.refer_area.setAreaCacheKey(this.mFeedData.getReferInfoV2().integerUniKeyTitle);
                        this.refer_area.setText(this.mFeedData.getReferInfoV2().image + " " + this.mFeedData.getReferInfoV2().appName);
                    } else {
                        this.refer_area.setVisibility(8);
                    }
                    this.permission_area.setVisibility(8);
                    this.qzonedesc_area.setVisibility(8);
                    this.qzone_vip_signature.setVisibility(8);
                    permissionInfoV2 = this.mFeedData.getPermissionInfoV2();
                    if (!isPermissionInfoNotEmpty(permissionInfoV2)) {
                        this.permission_area.setVisibility(0);
                        this.permission_area.setAreaCacheKey(Integer.valueOf((this.mFeedData.getFeedCommInfo().ugckey + "_permission_" + permissionInfoV2.permission_visit).hashCode()));
                        if (this.mFeedData.getCellTheme() != null) {
                            this.permission_area.setTextColor(this.mFeedData.getCellTheme().minorForeColor);
                        }
                        this.permission_area.setMaxLines(1);
                        if (!TextUtils.isEmpty(permissionInfoV2.permission_info)) {
                            int f06 = i.H().f0(permissionInfoV2.permission_visit);
                            if (f06 != 0) {
                                this.permission_area.setLeftDrawable(FeedGlobalEnv.getContext().getResources().getDrawable(f06), AreaConst.f48748dp3);
                            }
                            this.permission_area.setText(permissionInfoV2.permission_info);
                        } else if (!TextUtils.isEmpty(permissionInfoV2.status_info)) {
                            this.permission_area.setText(permissionInfoV2.status_info);
                        }
                    } else if (!this.mFeedData.getFeedCommInfo().isLikeRecommFamousFeed()) {
                        showQzoneDesc();
                    }
                    this.btn_menu_area.setVisibility(8);
                    this.btn_menu_area.setTag(null);
                    this.count_area.setVisibility(8);
                    this.attach_area.setVisibility(8);
                    this.high_five_count_first_area.setVisibility(8);
                    this.high_five_count_second_area.setVisibility(8);
                    this.passive_comment_btn_container.setVisibility(8);
                    this.passive_comment_like_btn_container.setVisibility(8);
                    if ((this.mIsPassive && !this.mIsFromMessage) || (!this.canComment && !this.canReply && !this.canReturnGift && !this.canLookUp && !this.canJoinAlbum && !this.joinedAlbum && !this.canGiveBack && !this.canHuNuan)) {
                        if (this.mFeedData.getFeedCommInfo().isBizRecomFeeds() && this.mFeedData.getCellCount() != null) {
                            if (!TextUtils.isEmpty(this.mFeedData.getCellCount().icon) || !TextUtils.isEmpty(this.mFeedData.getCellCount().desc)) {
                                this.count_area.setVisibility(0);
                                if (!TextUtils.isEmpty(this.mFeedData.getCellCount().icon) && this.mFeedData.getCellCount().icon.startsWith("http")) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("{img:");
                                    sb5.append(URLEncoder.encode(this.mFeedData.getCellCount().icon));
                                    sb5.append(",w:");
                                    int i27 = AreaConst.dp12;
                                    sb5.append(i27);
                                    sb5.append(",h:");
                                    sb5.append(i27);
                                    sb5.append("}");
                                    str4 = sb5.toString();
                                }
                                this.count_area.setText(str4 + " " + this.mFeedData.getCellCount().num + this.mFeedData.getCellCount().desc);
                                this.count_area.setTextColor(AreaManager.grayColor);
                            }
                        } else {
                            boolean z26 = this.mFeedData.getFeedCommInfo() != null && this.mFeedData.getFeedCommInfo().isLikeRecommFamousFeed();
                            if (this.mFeedData.getFeedCommInfo().isExistDroplistFollowButton()) {
                                if (!z26) {
                                    BusinessFeedData businessFeedData7 = this.mFeedData;
                                    if (businessFeedData7.feedType == 12289) {
                                        if (businessFeedData7.getUser() != null) {
                                            if (this.mFeedData.getUser().isCanShowFamousIcon()) {
                                            }
                                        }
                                    }
                                }
                                z16 = true;
                                if (this.mFeedData.getCellInterest() == null) {
                                    BusinessFeedData businessFeedData8 = this.mFeedData;
                                    if (!businessFeedData8.isSubFeed && !businessFeedData8.isUgcAdvFeeds() && !this.mHasRecommHeader) {
                                        z17 = true;
                                        if (!z17 || (com.qzone.proxy.feedcomponent.util.i.f(this.mFeedData) && this.mFeedData.feedType == 0) || this.mFeedData.isFriendBirthdayGift() || z16) {
                                            this.attach_area.setFeedData(this.mFeedData, false);
                                            CanvasAttachArea canvasAttachArea = this.attach_area;
                                            int i28 = AreaConst.f48748dp3;
                                            canvasAttachArea.setPadding(i28, 0, i28, i28);
                                            if (this.attach_area.getType() >= 0) {
                                                this.attach_area.setVisibility(this.mFeedData.hideMoreBtn ? 8 : 0);
                                                if (isNeedShowFollowBtn() && !this.mFeedData.isMsgFeed()) {
                                                    DittoButtonArea dittoButtonArea = this.follow_button;
                                                    dittoButtonArea.setMargin(dittoButtonArea.getMarginLeft(), this.follow_button.getMarginTop(), 0, this.follow_button.getMarginBottom());
                                                }
                                                this.attach_area.setContentDescription("\u4e0b\u62c9\u83dc\u5355");
                                                this.attach_area.setMargin(0, 0, 0, 0);
                                            }
                                        }
                                    }
                                }
                                z17 = false;
                                if (!z17 || (com.qzone.proxy.feedcomponent.util.i.f(this.mFeedData) && this.mFeedData.feedType == 0) || this.mFeedData.isFriendBirthdayGift() || z16) {
                                }
                            }
                            z16 = false;
                            if (this.mFeedData.getCellInterest() == null) {
                            }
                            z17 = false;
                            if (!z17 || (com.qzone.proxy.feedcomponent.util.i.f(this.mFeedData) && this.mFeedData.feedType == 0) || this.mFeedData.isFriendBirthdayGift() || z16) {
                            }
                        }
                    } else {
                        this.btn_menu_area.setVisibility(0);
                        this.btn_menu_area.setTag(Integer.valueOf(hashCode()));
                        if (!this.canGiveBack) {
                            RichCanvasTextArea richCanvasTextArea = this.btn_menu_area;
                            String str6 = giveBackText;
                            richCanvasTextArea.setText(str6);
                            this.btn_menu_area.setContentDescription(str6);
                            this.btn_menu_area.setTag(119);
                        } else if (this.canReturnGift) {
                            RichCanvasTextArea richCanvasTextArea2 = this.btn_menu_area;
                            String str7 = giftText;
                            richCanvasTextArea2.setText(str7);
                            this.btn_menu_area.setContentDescription(str7);
                            if (!this.mIsPassive && !this.mIsFromMessage) {
                                this.btn_menu_area.setLeftDrawable(AreaManager.SKIN_ICON_GIFT, AreaConst.dp5);
                            }
                            this.btn_menu_area.setTag(51);
                        } else if (this.canJoinAlbum) {
                            RichCanvasTextArea richCanvasTextArea3 = this.btn_menu_area;
                            String str8 = joinAlbumText;
                            richCanvasTextArea3.setText(str8);
                            this.btn_menu_area.setContentDescription(str8);
                            this.btn_menu_area.setTag(85);
                        } else if (this.joinedAlbum) {
                            RichCanvasTextArea richCanvasTextArea4 = this.btn_menu_area;
                            String str9 = joinedAlbumText;
                            richCanvasTextArea4.setText(str9);
                            this.btn_menu_area.setContentDescription(str9);
                            this.btn_menu_area.setTag(102);
                        } else if (this.canLookUp) {
                            RichCanvasTextArea richCanvasTextArea5 = this.btn_menu_area;
                            String str10 = lookUpText;
                            richCanvasTextArea5.setText(str10);
                            this.btn_menu_area.setContentDescription(str10);
                            this.btn_menu_area.setTag(68);
                        } else if (this.canHuNuan) {
                            RichCanvasTextArea richCanvasTextArea6 = this.btn_menu_area;
                            String str11 = huNuanText;
                            richCanvasTextArea6.setText(str11);
                            this.btn_menu_area.setContentDescription(str11);
                            this.btn_menu_area.setTag(136);
                        } else if (this.canReply) {
                            if (i.H().k1()) {
                                this.btn_menu_area.setVisibility(8);
                                this.passive_comment_btn.setBackgroundDrawable(PASSIVE_FEED_COMMENT_NORMAL);
                                this.passive_comment_btn_container.setVisibility(0);
                                this.passive_comment_btn_container.setTag(17);
                                if ((this.mFeedData.getFeedCommInfo().operatemask2 & 524288) != 0) {
                                    this.passive_comment_like_btn_container.setVisibility(0);
                                    Comment mainComment = this.mFeedData.getMainComment();
                                    if (mainComment != null) {
                                        if (mainComment.isliked) {
                                            this.passive_comment_like_btn.setBackgroundDrawable(PASSIVE_FEED_PRAISED);
                                        } else {
                                            this.passive_comment_like_btn.setBackgroundDrawable(PASSIVE_FEED_PRAISE_NORMAL);
                                        }
                                    }
                                    this.passive_comment_like_btn.invalidate();
                                } else {
                                    this.passive_comment_like_btn_container.setVisibility(8);
                                }
                            } else {
                                RichCanvasTextArea richCanvasTextArea7 = this.btn_menu_area;
                                String str12 = replyText;
                                richCanvasTextArea7.setText(str12);
                                this.btn_menu_area.setContentDescription(str12);
                                this.btn_menu_area.setTag(17);
                            }
                        } else if (this.canComment) {
                            if (this.mIsPassive) {
                                if (showHighFiveButton(this.mFeedData)) {
                                    this.btn_menu_area.setVisibility(8);
                                    this.attach_area.setFeedData(this.mFeedData, false);
                                    if (this.attach_area.getType() >= 0) {
                                        this.attach_area.setVisibility(0);
                                        if (this.attach_area.getType() == 85) {
                                            this.attach_area.setContentDescription("\u5df2\u51fb\u638c");
                                        } else {
                                            this.attach_area.setContentDescription(highFive);
                                        }
                                        this.attach_area.setMargin(0, 0, ViewUtils.dpToPx(8.0f), 0);
                                        long highFiveCount = getHighFiveCount(this.mFeedData);
                                        if (TitleAttachArea.showMultipleHighFiveIcon(this.mFeedData) && highFiveCount > 0) {
                                            this.high_five_count_first_area.setVisibility(0);
                                            this.high_five_count_second_area.setVisibility(0);
                                            if (this.attach_area.getType() == 85 && !this.needShowHighFiveAnimation) {
                                                long j3 = highFiveCount + 1;
                                                valueOf = j3 > 999 ? HIGH_FIVE_COUNT_THRESHOLD : String.valueOf(j3);
                                                this.high_five_count_first_area.setTextColor(highFiveCountYellowColor);
                                                this.high_five_count_second_area.setTextColor(highFiveCountYellowColor);
                                            } else {
                                                valueOf = highFiveCount > 999 ? HIGH_FIVE_COUNT_THRESHOLD : String.valueOf(highFiveCount);
                                                this.high_five_count_first_area.setTextColor(highFiveCountGrayColor);
                                                this.high_five_count_second_area.setTextColor(highFiveCountGrayColor);
                                            }
                                            if (!"1".equals(valueOf)) {
                                                this.high_five_count_first_area.setText(HIGH_FIVE_COUNT_PRODUCT_SIHN + valueOf);
                                                this.high_five_count_second_area.setText(HIGH_FIVE_COUNT_PRODUCT_SIHN + valueOf);
                                            }
                                        }
                                        this.needShowHighFiveAnimation = false;
                                    }
                                    if (i.H().k1()) {
                                        CanvasAttachArea canvasAttachArea2 = this.attach_area;
                                        int i29 = AreaConst.f48748dp3;
                                        canvasAttachArea2.setPadding(i29, AreaConst.dp4_5, -AreaConst.dp5, i29);
                                        this.high_five_count_container.setMargin(0, 0, 0, AreaConst.dp5_5);
                                    } else {
                                        CanvasAttachArea canvasAttachArea3 = this.attach_area;
                                        int i36 = AreaConst.f48748dp3;
                                        canvasAttachArea3.setPadding(i36, 0, i36, i36);
                                        this.high_five_count_container.setMargin(0, 0, AreaConst.dp8, AreaConst.dp10);
                                    }
                                } else if (i.H().k1()) {
                                    this.btn_menu_area.setVisibility(8);
                                    this.passive_comment_btn.setBackgroundDrawable(PASSIVE_FEED_COMMENT_NORMAL);
                                    this.passive_comment_btn_container.setVisibility(0);
                                    this.passive_comment_btn_container.setTag(34);
                                } else {
                                    BusinessFeedData businessFeedData9 = this.mFeedData;
                                    if (businessFeedData9 != null && businessFeedData9.getFeedCommInfo().isShowGoMessageBoard()) {
                                        RichCanvasTextArea richCanvasTextArea8 = this.btn_menu_area;
                                        String str13 = leaveMessageText;
                                        richCanvasTextArea8.setText(str13);
                                        this.btn_menu_area.setContentDescription(str13);
                                        this.btn_menu_area.setTag(153);
                                    } else {
                                        RichCanvasTextArea richCanvasTextArea9 = this.btn_menu_area;
                                        String str14 = replyText;
                                        richCanvasTextArea9.setText(str14);
                                        this.btn_menu_area.setContentDescription(str14);
                                    }
                                }
                            } else {
                                RichCanvasTextArea richCanvasTextArea10 = this.btn_menu_area;
                                String str15 = commentText;
                                richCanvasTextArea10.setText(str15);
                                this.btn_menu_area.setContentDescription(str15);
                            }
                            if (153 != ((Integer) this.btn_menu_area.getTag()).intValue()) {
                                this.btn_menu_area.setTag(34);
                            }
                        }
                        if (this.mFeedData.getCellTheme() == null) {
                            this.btn_menu_area.setTextColor(this.mFeedData.getCellTheme().majorForeColor);
                        } else if (this.joinedAlbum) {
                            this.btn_menu_area.setTextColor(AreaManager.grayColor);
                        } else {
                            this.btn_menu_area.setTextColor(com.qzone.adapter.feedcomponent.j.I());
                        }
                    }
                    this.friendlike_play_count_area.setVisibility(8);
                    boolean z27 = this.mFeedData.getFeedCommInfo().recomlayout == 1;
                    if (!this.isFriendLikeContainer && z27 && this.mFeedData.getCellFrdlikeContainer() != null && !TextUtils.isEmpty(this.mFeedData.getCellFrdlikeContainer().rightDesc)) {
                        this.friendlike_play_count_area.setVisibility(0);
                        this.friendlike_play_count_area.setText(this.mFeedData.getCellFrdlikeContainer().rightDesc);
                    } else {
                        this.friendlike_play_count_area.setVisibility(8);
                    }
                    this.campus_area.setVisibility(8);
                    if (this.line_2.isEmpty() && this.line_2.getVisibility() != 8) {
                        resetLine1();
                    } else {
                        centerLine1();
                    }
                    updateAccessibility();
                    return;
                }
                this.time_area.setVisibility(8);
                if (!this.mFeedData.getFeedCommInfo().isBizRecomFeeds()) {
                }
                this.refer_area.setVisibility(8);
                this.permission_area.setVisibility(8);
                this.qzonedesc_area.setVisibility(8);
                this.qzone_vip_signature.setVisibility(8);
                permissionInfoV2 = this.mFeedData.getPermissionInfoV2();
                if (!isPermissionInfoNotEmpty(permissionInfoV2)) {
                }
                this.btn_menu_area.setVisibility(8);
                this.btn_menu_area.setTag(null);
                this.count_area.setVisibility(8);
                this.attach_area.setVisibility(8);
                this.high_five_count_first_area.setVisibility(8);
                this.high_five_count_second_area.setVisibility(8);
                this.passive_comment_btn_container.setVisibility(8);
                this.passive_comment_like_btn_container.setVisibility(8);
                if (this.mIsPassive) {
                }
                this.btn_menu_area.setVisibility(0);
                this.btn_menu_area.setTag(Integer.valueOf(hashCode()));
                if (!this.canGiveBack) {
                }
                if (this.mFeedData.getCellTheme() == null) {
                }
                this.friendlike_play_count_area.setVisibility(8);
                if (this.mFeedData.getFeedCommInfo().recomlayout == 1) {
                }
                if (!this.isFriendLikeContainer) {
                }
                this.friendlike_play_count_area.setVisibility(8);
                this.campus_area.setVisibility(8);
                if (this.line_2.isEmpty()) {
                }
                centerLine1();
                updateAccessibility();
                return;
            }
            this.line_2.setVisibility(0);
            if (getVisibility() != 0) {
            }
            updateSimpleInfo();
            resetFeedSkinAnimation();
            if (!this.mIsForward) {
            }
        } else {
            setVisibility(8);
        }
    }

    public void updateGapAlpha() {
        this.gapAlpha = i.f41891e;
        postInvalidate();
    }

    protected void updateSimpleInfo() {
        UserMedal userMedal;
        User user = this.mFeedData.getUser();
        if (user != null) {
            this.nickname.setData(this.mFeedData, this.mIsForward);
            if (this.mIsForward && user.isCanShowFamousIcon() && (userMedal = user.famousSpaceMedal) != null && !TextUtils.isEmpty(userMedal.picUrl)) {
                this.icon_famous.setVisibility(0);
                Drawable a06 = i.H().a0();
                AsyncCanvasImageArea asyncCanvasImageArea = this.icon_famous;
                UserMedal userMedal2 = user.famousSpaceMedal;
                asyncCanvasImageArea.setAsyncImage(userMedal2.imageUrl, userMedal2.picUrl, a06, null);
                i.H().G(this.mFeedData, user);
            } else {
                this.icon_famous.setVisibility(8);
            }
        }
        this.follow_button.setVisibility(8);
        this.add_friend_button.setVisibility(8);
        LinearAreaLayout linearAreaLayout = this.line_1_2;
        linearAreaLayout.setMargin(linearAreaLayout.getMarginLeft(), this.line_1_2.getMarginTop(), 0, this.line_1_2.getMarginBottom());
        DittoButtonArea dittoButtonArea = this.follow_button;
        dittoButtonArea.setMargin(dittoButtonArea.getMarginLeft(), this.follow_button.getMarginTop(), AreaConst.dp10, this.follow_button.getMarginBottom());
        LinearAreaLayout linearAreaLayout2 = this.line_2;
        linearAreaLayout2.setMargin(linearAreaLayout2.getMarginLeft(), this.line_2.getMarginTop(), AreaManager.dp50, this.line_2.getMarginBottom());
        if (isNeedShowFollowBtn() || isNeedShowAddFriendBtn()) {
            if (isNeedShowFollowBtn()) {
                this.follow_button.setVisibility(0);
                if (this.mFeedData.getFeedCommInfo().isFollowed) {
                    this.follow_button.setText("\u5df2\u5173\u6ce8");
                    this.follow_button.setTextColor(com.qzone.adapter.feedcomponent.j.o());
                    this.follow_button.setBackgroundColor(com.qzone.adapter.feedcomponent.j.B());
                    this.follow_button.setContentDescription("\u5df2\u5173\u6ce8");
                } else {
                    this.follow_button.setText("\u5173\u6ce8");
                    this.follow_button.setTextColor(UnFollowTextColor);
                    this.follow_button.setBackgroundColor(com.qzone.adapter.feedcomponent.j.x());
                    this.follow_button.setContentDescription("\u5173\u6ce8");
                }
            } else {
                this.add_friend_button.setVisibility(0);
                if (this.mFeedData.getFeedCommInfo().isFriendAdded) {
                    this.add_friend_button.setText("\u5df2\u53d1\u9001");
                    this.add_friend_button.setTextColor(AddedTextColor);
                    this.add_friend_button.setBorderColor(AddedBorderColor);
                    this.add_friend_button.setContentDescription("\u5df2\u53d1\u9001");
                } else {
                    this.add_friend_button.setText("\u52a0\u597d\u53cb");
                    this.add_friend_button.setTextColor(UnAddedTextColor);
                    this.add_friend_button.setBorderColor(UnAddedBorderColor);
                    this.add_friend_button.setContentDescription("\u52a0\u597d\u53cb");
                }
            }
        }
        int i3 = showUpperBanner() ? AreaConst.dp105 : 0;
        int i16 = showRecommendListHeader() ? AreaConst.dp57 : 0;
        if (this.mIsForward) {
            this.feed_skin.setVisibility(8);
            this.avatar.setVisibility(8);
            this.avatar_decoration.setVisibility(8);
            this.icon_starvip.setVisibility(8);
            this.yellowdiamond_container.setVisibility(8);
            this.icon_LiveMedal.setVisibility(8);
            this.icon_familyMedal.setVisibility(8);
            this.icon_Standalone.setVisibility(8);
            this.icon_LoverZone.setVisibility(8);
            this.name_plate_layout.setVisibility(8);
            this.original_flag.setVisibility(8);
            this.action_area.setVisibility(8);
            this.btn_menu_area.setVisibility(8);
            this.count_area.setVisibility(8);
            this.friendlike_play_count_area.setVisibility(8);
            this.attach_area.setVisibility(8);
            this.line_2.setVisibility(8);
            centerLine1();
            this.feed_title_root.getLayoutAttr().height = ViewUtils.dpToPx(50.0f) + i3 + i16;
            this.line_1_1.getLayoutAttr().topMargin = AreaConst.dp9;
            this.line_1_2.getLayoutAttr().topMargin = AreaConst.dp5;
            SimpleModelUtils.printDebugLog("[updateSimpleInfo] current forward flow, title root height: " + this.feed_title_root.getLayoutAttr().height);
            return;
        }
        if (!showFeedSkin()) {
            this.feed_skin.setVisibility(8);
            this.feed_title_root.getLayoutAttr().height = AreaConst.dp64 + i3 + i16;
            SimpleModelUtils.printDebugLog("[updateSimpleInfo] not show feed skin flow, title root height: " + this.feed_title_root.getLayoutAttr().height);
            return;
        }
        if (isResizeSimpleFirstFeedHeight()) {
            this.feed_title_root.getLayoutAttr().height = AreaConst.dp64 + i3 + i16;
            SimpleModelUtils.printDebugLog("[updateSimpleInfo] simple mode first feed flow, title root height: " + this.feed_title_root.getLayoutAttr().height);
            return;
        }
        if (this.mFeedData.isSubFeed) {
            this.feed_skin.setVisibility(8);
            this.feed_title_root.getLayoutAttr().height = AreaConst.dp58 + i3 + i16;
            SimpleModelUtils.printDebugLog("[updateSimpleInfo] sub feed flow, title root height: " + this.feed_title_root.getLayoutAttr().height);
            return;
        }
        if (this.mIsTodayInHistoryDetail) {
            this.feed_title_root.getLayoutAttr().height = AreaConst.dp64 + i3 + i16;
            SimpleModelUtils.printDebugLog("[updateSimpleInfo] mIsTodayInHistoryDetail, title root height: " + this.feed_title_root.getLayoutAttr().height);
            return;
        }
        this.feed_title_root.getLayoutAttr().height = ViewUtils.dpToPx(79.0f) + i3 + i16;
        SimpleModelUtils.printDebugLog("[updateSimpleInfo] else flow, title root height: " + this.feed_title_root.getLayoutAttr().height);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        AnimationDrawable animationDrawable = this.mSignatureAnimationDrawable;
        if (animationDrawable != null) {
            return animationDrawable == drawable || super.verifyDrawable(drawable);
        }
        return super.verifyDrawable(drawable);
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView, com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        this.isFriendLikeContainer = false;
        this.mHasRecommHeader = false;
        recycleChild(this.avatar_bottom_bar);
        recycleChild(this.time_area);
        recycleChild(this.campus_area);
        recycleChild(this.refer_area);
        recycleChild(this.permission_area);
        recycleChild(this.qzonedesc_area);
        recycleChild(this.action_area);
        recycleChild(this.btn_menu_area);
        recycleChild(this.count_area);
        recycleChild(this.friendlike_play_count_area);
        CanvasNicknameArea canvasNicknameArea = this.nickname;
        if (canvasNicknameArea != null) {
            canvasNicknameArea.recycle();
        }
        CanvasGifArea canvasGifArea = this.icon_YellowVip_gif;
        if (canvasGifArea != null) {
            canvasGifArea.recycle();
        }
        DittoButtonArea dittoButtonArea = this.high_five_count_first_area;
        if (dittoButtonArea != null) {
            dittoButtonArea.setText(null);
            this.high_five_count_first_area.clearAnimation();
        }
        DittoButtonArea dittoButtonArea2 = this.high_five_count_second_area;
        if (dittoButtonArea2 != null) {
            dittoButtonArea2.setText(null);
            this.high_five_count_second_area.clearAnimation();
        }
        resetFeedSkinAnimation();
        resetQQUnionAnimation();
        resetSignatureAnimation();
    }

    @Override // com.qzone.canvasui.widget.QzoneCanvasAreaView
    public void reset() {
        this.mFeedData = null;
        this.mIsPassive = false;
        this.mIsFromMessage = false;
        this.noNeedShow = false;
        this.mHasRecommHeader = false;
        this.mHasInterest = false;
        this.canComment = false;
        this.canReply = false;
        this.canReturnGift = false;
        this.canLookUp = false;
        this.canJoinAlbum = false;
        this.joinedAlbum = false;
        this.isFriendLikeContainer = false;
        this.videoPlayInfo = null;
        this.mIsAdvContainerFeed = false;
        this.canGiveBack = false;
        resetFeedSkinAnimation();
        resetQQUnionAnimation();
        resetSignatureAnimation();
        CanvasAvatarArea canvasAvatarArea = this.avatar;
        if (canvasAvatarArea != null) {
            canvasAvatarArea.setMargin(ViewUtils.dpToPx(10.0f), 0, 0, 0);
        }
    }

    private long getHighFiveCount(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            b.a("CanvasTitleView", "[highFive].getHighFiveCount, mFeedData = null");
            return 0L;
        }
        if (businessFeedData.getCellDecorateInfo() == null) {
            b.a("CanvasTitleView", "[highFive].getHighFiveCount, CellDecorateInfo = null");
            return 0L;
        }
        CellHighFiveInfo cellHighFiveInfo = businessFeedData.getCellHighFiveInfo();
        if (cellHighFiveInfo != null) {
            return cellHighFiveInfo.highFiveCount;
        }
        b.a("CanvasTitleView", "[highFive].getHighFiveCount, cellHighFiveInfo = null");
        return 0L;
    }

    private static boolean hasExtendInfo(QQUnionIconInfo qQUnionIconInfo) {
        Map<String, String> map;
        return (qQUnionIconInfo == null || (map = qQUnionIconInfo.mExtendInfo) == null || map.isEmpty()) ? false : true;
    }

    private boolean isPermissionInfoNotEmpty(CellPermissionInfo cellPermissionInfo) {
        return (cellPermissionInfo == null || (TextUtils.isEmpty(cellPermissionInfo.status_info) && TextUtils.isEmpty(cellPermissionInfo.permission_info))) ? false : true;
    }

    private void recycleChild(RichCanvasTextArea richCanvasTextArea) {
        if (richCanvasTextArea != null) {
            richCanvasTextArea.onRecycled();
        }
    }

    private void tryRecycleAnimationDrawable(AnimationDrawable animationDrawable) {
        if (animationDrawable != null) {
            animationDrawable.stop();
            for (int i3 = 0; i3 < animationDrawable.getNumberOfFrames(); i3++) {
                Drawable frame = animationDrawable.getFrame(i3);
                if (frame != null) {
                    if (frame instanceof BitmapDrawable) {
                        BitmapDrawable bitmapDrawable = (BitmapDrawable) frame;
                        if (bitmapDrawable.getBitmap() != null) {
                            bitmapDrawable.getBitmap().recycle();
                        }
                    }
                    frame.setCallback(null);
                }
            }
            animationDrawable.setCallback(null);
        }
    }

    private boolean isSpecialSkin(FeedSkinData feedSkinData) {
        String str;
        final String str2;
        if (feedSkinData != null && !TextUtils.isEmpty(feedSkinData.strFrameZip)) {
            str = QzoneZipCacheHelper.d(ZipDrawableLoader.DEFAULT_BUSINESS, String.valueOf(feedSkinData.strFrameZip.hashCode()), 0);
        } else {
            str = "";
        }
        if (!(new File(str).exists() && new File(str).isDirectory())) {
            return false;
        }
        if (new File(str, "lv10").exists()) {
            File[] listFiles = new File(str, "lv10").listFiles();
            return listFiles != null && listFiles.length > 0;
        }
        if (!new File(str, "luxury10").exists()) {
            return false;
        }
        if (i.H().p1()) {
            str2 = "_dark";
        } else {
            str2 = "_light";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("/luxury10/");
        return new File(sb5.toString()).listFiles(new FileFilter() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.17
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.getName().contains(str2);
            }
        }).length == 1;
    }

    public void setFeedData(BusinessFeedData businessFeedData, boolean z16, boolean z17) {
        if (businessFeedData == null) {
            return;
        }
        this.mFeedData = businessFeedData;
        this.mIsPassive = z16;
        this.mIsFromMessage = z17;
        if (businessFeedData.getSinglePicAdvStyle() == 4) {
            this.noNeedShow = true;
            if (businessFeedData.isAdFeeds() && businessFeedData.isAdFeeds() && businessFeedData.getLocalInfo().canLike && businessFeedData.getLocalInfo().canShare && businessFeedData.getLocalInfo().canComment) {
                this.noNeedShow = false;
            }
        }
        BusinessFeedData businessFeedData2 = businessFeedData.parentFeedData;
        if (businessFeedData2 != null && businessFeedData2.isFriendLikeContainer()) {
            this.isFriendLikeContainer = true;
        } else {
            this.isFriendLikeContainer = false;
        }
        this.mHasRecommHeader = (this.noNeedShow || this.mFeedData.getRecommHeader() == null || this.mFeedData.feedType == 2) ? false : true;
        if (!this.mFeedData.isSubOfMultiAdvContainerFeed() && !this.mFeedData.isSingleAdvContainerNewStyle() && !this.isFriendLikeContainer) {
            this.mIsAdvContainerFeed = false;
        } else {
            this.mIsAdvContainerFeed = true;
        }
    }

    public static boolean hasValidUserInfo(User user) {
        if (user == null) {
            return false;
        }
        int i3 = user.from;
        if (i3 == 0 || i3 == 1) {
            return user.uin > 0;
        }
        if (i3 == 2 || i3 == 3 || i3 == 4) {
            return !TextUtils.isEmpty(user.logo);
        }
        if (i3 != 8) {
            return false;
        }
        return (user.logoImageUrl == null && TextUtils.isEmpty(user.logo) && user.uin <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DittoOnClick(values = {"avatar", "nickname", "attach_area", "avatar_decoration", "btn_menu_area", "feed_skin", "icon_Standalone", "name_plate_layout", "icon_LoverZone", "refer_area", "time_area", "icon_starvip", "yellowdiamond_container", "action_area", "add_friend_button", "follow_button", "permission_area", "icon_LiveMedal", "icon_familyMedal", "qzonedesc_area", "feed_title_root", "passive_comment_btn_container", "passive_comment_like_btn_container", "title_upper_banner", "upper_banner_close_container", "qzone_vip_signature"})
    public void onCanvasAreaClicked(DittoArea dittoArea, MotionEvent motionEvent, Object obj) {
        boolean z16;
        WrapContentViewPager wrapContentViewPager;
        b.c("CANVASLOG", "onCanvasAreaClicked " + dittoArea.getId());
        if (this.onFeedElementClickListener == null) {
            return;
        }
        BusinessFeedData businessFeedData = this.mFeedData;
        FeedElement feedElement = null;
        FeedElement feedElement2 = null;
        FeedElement feedElement3 = null;
        User user = businessFeedData != null ? businessFeedData.getUser() : null;
        if (obj != null && (obj instanceof TextCell)) {
            TextCell textCell = (TextCell) obj;
            if (textCell instanceof UserNameCell) {
                this.onFeedElementClickListener.onClick(this, FeedElement.FRIEND_NICKNAME, this.feedPosition, ((UserNameCell) textCell).getUin());
                return;
            }
            if (textCell instanceof UrlCell) {
                UrlCell urlCell = (UrlCell) textCell;
                if (urlCell.getAction() == 2) {
                    g gVar = this.onFeedElementClickListener;
                    FeedElement feedElement4 = FeedElement.CONTENT;
                    int i3 = this.feedPosition;
                    gVar.onClick(this, feedElement4, i3, Integer.valueOf(i3));
                    return;
                }
                if (dittoArea.getType() == 62) {
                    BusinessFeedData businessFeedData2 = this.mFeedData;
                    if (businessFeedData2 != null) {
                        this.onFeedElementClickListener.onClick(this, FeedElement.LBS_INFO, this.feedPosition, businessFeedData2.getLbsInfoV2());
                        return;
                    }
                    return;
                }
                e eVar = new e(urlCell.getUrl(), urlCell.post, this.feedPosition);
                eVar.d(dittoArea.getType());
                this.onFeedElementClickListener.onClick(this, FeedElement.URL, this.feedPosition, eVar);
                if (dittoArea == this.qzonedesc_area) {
                    cooperation.vip.c.b(140, 2);
                    return;
                }
                return;
            }
            if (textCell instanceof ColorTextCell) {
                if (textCell.getType() == 5) {
                    g gVar2 = this.onFeedElementClickListener;
                    FeedElement feedElement5 = FeedElement.CONTENT;
                    int i16 = this.feedPosition;
                    gVar2.onClick(this, feedElement5, i16, Integer.valueOf(i16));
                    return;
                }
                return;
            }
            g gVar3 = this.onFeedElementClickListener;
            FeedElement feedElement6 = FeedElement.NOTHING;
            int i17 = this.feedPosition;
            gVar3.onClick(this, feedElement6, i17, Integer.valueOf(i17));
            return;
        }
        long j3 = 0;
        if (dittoArea == this.avatar) {
            g gVar4 = this.onFeedElementClickListener;
            FeedElement feedElement7 = FeedElement.USER_AVATAR;
            int i18 = this.feedPosition;
            BusinessFeedData businessFeedData3 = this.mFeedData;
            if (businessFeedData3 != null && businessFeedData3.getUser() != null) {
                j3 = this.mFeedData.getUser().uin;
            }
            gVar4.onClick(this, feedElement7, i18, Long.valueOf(j3));
            return;
        }
        if (dittoArea == this.nickname) {
            setTag("title");
            g gVar5 = this.onFeedElementClickListener;
            FeedElement feedElement8 = FeedElement.USER_NICKNAME;
            int i19 = this.feedPosition;
            BusinessFeedData businessFeedData4 = this.mFeedData;
            if (businessFeedData4 != null && businessFeedData4.getUser() != null) {
                j3 = this.mFeedData.getUser().uin;
            }
            gVar5.onClick(this, feedElement8, i19, Long.valueOf(j3));
            return;
        }
        if (dittoArea == this.avatar_decoration) {
            g gVar6 = this.onFeedElementClickListener;
            FeedElement feedElement9 = FeedElement.USER_DECORATION;
            int i26 = this.feedPosition;
            BusinessFeedData businessFeedData5 = this.mFeedData;
            if (businessFeedData5 != null && businessFeedData5.getUser() != null) {
                j3 = this.mFeedData.getUser().uin;
            }
            gVar6.onClick(this, feedElement9, i26, Long.valueOf(j3));
            return;
        }
        if (dittoArea == this.attach_area) {
            int intValue = ((Integer) dittoArea.getTag()).intValue();
            if (intValue == 18) {
                g gVar7 = this.onFeedElementClickListener;
                FeedElement feedElement10 = FeedElement.DELETE_BUTTON;
                int i27 = this.feedPosition;
                gVar7.onClick(this, feedElement10, i27, Integer.valueOf(i27));
                return;
            }
            if (intValue == 66) {
                g gVar8 = this.onFeedElementClickListener;
                FeedElement feedElement11 = FeedElement.FEEDBACK;
                int i28 = this.feedPosition;
                gVar8.onClick(this, feedElement11, i28, Integer.valueOf(i28));
                return;
            }
            if (intValue == 70) {
                if (getParent() == null || getParent().getParent() == null || getParent().getParent().getParent() == null || (wrapContentViewPager = (WrapContentViewPager) getParent().getParent().getParent()) == null) {
                    return;
                }
                FeedAdvContainer.FeedContainerViewPager feedContainerViewPager = (FeedAdvContainer.FeedContainerViewPager) wrapContentViewPager.getAdapter();
                if (feedContainerViewPager != null) {
                    feedContainerViewPager.deleteFeedDataAndUpdate(this.mFeedData);
                }
                g gVar9 = this.onFeedElementClickListener;
                if (gVar9 != null) {
                    gVar9.onClick(this, FeedElement.FEED_FRIEND_BIRTHDAY_CARD_CLOSE, this.feedPosition, this.mFeedData);
                    return;
                }
                return;
            }
            if (intValue == 84) {
                this.needShowHighFiveAnimation = true;
                this.onFeedElementClickListener.onClick(this, FeedElement.HIGH_FIVE_BUTTON, this.feedPosition, this.mFeedData);
                return;
            }
            if (intValue == 86) {
                g gVar10 = this.onFeedElementClickListener;
                FeedElement feedElement12 = FeedElement.VISIT_RETURN;
                int i29 = this.feedPosition;
                gVar10.onClick(this, feedElement12, i29, Integer.valueOf(i29));
                return;
            }
            if (intValue == 59 || intValue == 60) {
                int[] locationToViewHost = DittoAreaView.getLocationToViewHost(dittoArea);
                this.onFeedElementClickListener.onClick(this, FeedElement.DROPDOWN_BUTTON, this.feedPosition, new ClickedPoint(locationToViewHost[0], locationToViewHost[1], 0, 0, dittoArea.getWidth(), dittoArea.getHeight()));
                return;
            }
            return;
        }
        if (dittoArea == this.btn_menu_area) {
            int intValue2 = ((Integer) dittoArea.getTag()).intValue();
            if (intValue2 == 17) {
                feedElement2 = FeedElement.REPLY_BUTTON;
            } else if (intValue2 == 34) {
                feedElement2 = FeedElement.COMMENT_BUTTON;
            } else if (intValue2 == 51) {
                feedElement2 = FeedElement.GIFT_BUTTON;
            } else if (intValue2 == 68) {
                feedElement2 = FeedElement.LOOKUP_BUTTON;
            } else if (intValue2 == 85) {
                feedElement2 = FeedElement.JOINALBUM_BUTTON;
            } else if (intValue2 == 119) {
                feedElement2 = FeedElement.AWARD;
            } else if (intValue2 == 136) {
                feedElement2 = FeedElement.TO_NUAN_PROFILE;
            } else if (intValue2 == 153) {
                feedElement2 = FeedElement.MESSAGE_ITEM;
            }
            if (feedElement2 == null) {
                return;
            }
            if (feedElement2 != FeedElement.COMMENT_BUTTON && feedElement2 != FeedElement.REPLY_BUTTON && feedElement2 != FeedElement.MESSAGE_ITEM) {
                if (feedElement2 == FeedElement.TO_NUAN_PROFILE) {
                    this.onFeedElementClickListener.onClick(this, feedElement2, this.feedPosition, Long.valueOf(user.uin));
                    i.H().f(84, 45, 1);
                }
            } else if (getParent() instanceof FeedView) {
                CanvasFeedContentView feedContentView = ((FeedView) getParent()).getFeedContentView();
                if (feedContentView != null) {
                    this.onFeedElementClickListener.onClick(feedContentView, feedElement2, this.feedPosition, new ClickedPoint(0, feedContentView.getHeight(), 0, 0, 0, 0));
                    return;
                }
                return;
            }
            g gVar11 = this.onFeedElementClickListener;
            int i36 = this.feedPosition;
            gVar11.onClick(this, feedElement2, i36, Integer.valueOf(i36));
            return;
        }
        if (dittoArea == this.feed_skin) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            BusinessFeedData businessFeedData6 = this.mFeedData;
            if (businessFeedData6 != null && businessFeedData6.getCellFeedSkinInfo().nSkinType != 380) {
                if (y16 <= 0.0f || y16 >= AreaConst.dp30 || x16 >= AreaConst.SCREEN_WIDTH || x16 <= AreaConst.dp88) {
                    return;
                }
                g gVar12 = this.onFeedElementClickListener;
                FeedElement feedElement13 = FeedElement.HABITED_AREA;
                int i37 = this.feedPosition;
                gVar12.onClick(this, feedElement13, i37, Integer.valueOf(i37));
                return;
            }
            if (y16 <= 0.0f || y16 >= AreaConst.dp50) {
                return;
            }
            if (x16 >= AreaConst.SCREEN_WIDTH || x16 <= (r2 * 3) / 4) {
                return;
            }
            g gVar13 = this.onFeedElementClickListener;
            FeedElement feedElement14 = FeedElement.HABITED_AREA_RIGHT;
            int i38 = this.feedPosition;
            gVar13.onClick(this, feedElement14, i38, Integer.valueOf(i38));
            return;
        }
        if (dittoArea == this.icon_Standalone) {
            g gVar14 = this.onFeedElementClickListener;
            FeedElement feedElement15 = FeedElement.STANDALONE_ICON;
            int i39 = this.feedPosition;
            gVar14.onClick(this, feedElement15, i39, Integer.valueOf(i39));
            return;
        }
        if (dittoArea == this.icon_LoverZone) {
            g gVar15 = this.onFeedElementClickListener;
            FeedElement feedElement16 = FeedElement.LOVER_ZONE_ICON;
            int i46 = this.feedPosition;
            gVar15.onClick(this, feedElement16, i46, Integer.valueOf(i46));
            return;
        }
        if (dittoArea == this.refer_area) {
            BusinessFeedData businessFeedData7 = this.mFeedData;
            CellReferInfo referInfoV2 = businessFeedData7 != null ? businessFeedData7.getReferInfoV2() : null;
            if (referInfoV2 == null) {
                return;
            }
            int i47 = referInfoV2.actionType;
            if (i47 == 17) {
                g gVar16 = this.onFeedElementClickListener;
                FeedElement feedElement17 = FeedElement.URL;
                int i48 = this.feedPosition;
                gVar16.onClick(this, feedElement17, i48, new e(referInfoV2.actionUrl, "", i48));
                return;
            }
            if (i47 != 2) {
                if (i47 != 6) {
                    this.onFeedElementClickListener.onClick(this, FeedElement.REFER, this.feedPosition, referInfoV2);
                    return;
                }
                return;
            } else {
                g gVar17 = this.onFeedElementClickListener;
                FeedElement feedElement18 = FeedElement.URL;
                int i49 = this.feedPosition;
                gVar17.onClick(this, feedElement18, i49, new e(referInfoV2.actionUrl, "", i49));
                return;
            }
        }
        if (dittoArea == this.time_area) {
            return;
        }
        if (dittoArea == this.icon_starvip) {
            g gVar18 = this.onFeedElementClickListener;
            FeedElement feedElement19 = FeedElement.STAR_VIP_ICON;
            int i56 = this.feedPosition;
            gVar18.onClick(this, feedElement19, i56, Integer.valueOf(i56));
            return;
        }
        if (dittoArea == this.yellowdiamond_container) {
            g gVar19 = this.onFeedElementClickListener;
            FeedElement feedElement20 = FeedElement.YELLOW_VIP_ICON;
            int i57 = this.feedPosition;
            gVar19.onClick(this, feedElement20, i57, Integer.valueOf(i57));
            return;
        }
        if (dittoArea == this.follow_button) {
            ClickedPoint clickedPoint = new ClickedPoint(dittoArea.getLeft(), dittoArea.getTop(), 0, 0, dittoArea.getWidth(), dittoArea.getHeight());
            if (this.mIsForward) {
                this.onFeedElementClickListener.onClick(this, FeedElement.FORWARD_FOLLOW, this.feedPosition, clickedPoint);
                return;
            } else {
                this.onFeedElementClickListener.onClick(this, FeedElement.LIKE_FOLLOW, this.feedPosition, clickedPoint);
                return;
            }
        }
        if (dittoArea == this.add_friend_button) {
            this.onFeedElementClickListener.onClick(this, FeedElement.FEED_ADD_FRIEND, this.feedPosition, null);
            return;
        }
        if (dittoArea == this.permission_area) {
            g gVar20 = this.onFeedElementClickListener;
            FeedElement feedElement21 = FeedElement.PERMISSION;
            int i58 = this.feedPosition;
            gVar20.onClick(this, feedElement21, i58, Integer.valueOf(i58));
            return;
        }
        if (dittoArea == this.icon_LiveMedal) {
            g gVar21 = this.onFeedElementClickListener;
            FeedElement feedElement22 = FeedElement.LIVE_VIP_ICON;
            int i59 = this.feedPosition;
            gVar21.onClick(this, feedElement22, i59, Integer.valueOf(i59));
            return;
        }
        RichCanvasTextArea richCanvasTextArea = this.qzonedesc_area;
        if (dittoArea == richCanvasTextArea) {
            FeedTextArea textArea = richCanvasTextArea.getTextArea();
            if (textArea != null) {
                this.onFeedElementClickListener.onClick(this, FeedElement.LOCAL_AD_TITLE_INFO, this.feedPosition, textArea.getCells());
                return;
            }
            return;
        }
        if (dittoArea == this.feed_title_root) {
            if (i.H().S0()) {
                boolean z17 = this.mIsPassive;
                if ((!this.mIsFromMessage && !z17) || !((z16 = this.canComment) || this.canReply || this.canReturnGift || this.canLookUp || this.canJoinAlbum)) {
                    feedElement3 = FeedElement.NOTHING;
                } else if (z16) {
                    if (z17) {
                        feedElement3 = FeedElement.REPLY_BUTTON;
                    } else {
                        feedElement3 = FeedElement.COMMENT_BUTTON;
                    }
                } else if (this.canReply) {
                    feedElement3 = FeedElement.REPLY_BUTTON;
                } else if (this.canReturnGift) {
                    feedElement3 = FeedElement.GIFT_BUTTON;
                } else if (this.canLookUp) {
                    feedElement3 = FeedElement.LOOKUP_BUTTON;
                } else if (this.canJoinAlbum) {
                    feedElement3 = FeedElement.JOINALBUM_BUTTON;
                }
                if (feedElement3 != null) {
                    g gVar22 = this.onFeedElementClickListener;
                    int i65 = this.feedPosition;
                    gVar22.onClick(this, feedElement3, i65, Integer.valueOf(i65));
                    return;
                }
                return;
            }
            if (this.isFriendLikeContainer) {
                this.onFeedElementClickListener.onClick(this, FeedElement.AUTO_VIDEO, this.feedPosition, this.videoPlayInfo);
                return;
            }
            boolean z18 = this.mIsForward;
            if (z18) {
                this.onFeedElementClickListener.onClick(this, FeedElement.NOTHING, this.feedPosition, Boolean.valueOf(z18));
                return;
            }
            g gVar23 = this.onFeedElementClickListener;
            FeedElement feedElement23 = FeedElement.NOTHING;
            int i66 = this.feedPosition;
            gVar23.onClick(this, feedElement23, i66, Integer.valueOf(i66));
            return;
        }
        if (dittoArea == this.passive_comment_btn_container) {
            this.passive_comment_btn.setBackgroundDrawable(PASSIVE_FEED_COMMENT_CLICK);
            this.passive_comment_btn.invalidate();
            getHandler().postDelayed(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.canvasui.CanvasTitleView.15
                @Override // java.lang.Runnable
                public void run() {
                    CanvasTitleView.this.passive_comment_btn.setBackgroundDrawable(CanvasTitleView.PASSIVE_FEED_COMMENT_NORMAL);
                    CanvasTitleView.this.passive_comment_btn.invalidate();
                }
            }, 50L);
            int intValue3 = ((Integer) dittoArea.getTag()).intValue();
            if (intValue3 == 17) {
                feedElement = FeedElement.REPLY_BUTTON;
            } else if (intValue3 == 34) {
                feedElement = FeedElement.COMMENT_BUTTON;
            }
            if (feedElement == null) {
                return;
            }
            if ((feedElement == FeedElement.COMMENT_BUTTON || feedElement == FeedElement.REPLY_BUTTON) && (getParent() instanceof FeedView)) {
                CanvasFeedContentView feedContentView2 = ((FeedView) getParent()).getFeedContentView();
                if (feedContentView2 != null) {
                    this.onFeedElementClickListener.onClick(feedContentView2, feedElement, this.feedPosition, new ClickedPoint(0, feedContentView2.getHeight(), 0, 0, 0, 0));
                    return;
                }
                return;
            }
            g gVar24 = this.onFeedElementClickListener;
            int i67 = this.feedPosition;
            gVar24.onClick(this, feedElement, i67, Integer.valueOf(i67));
            return;
        }
        if (dittoArea == this.passive_comment_like_btn_container) {
            BusinessFeedData businessFeedData8 = this.mFeedData;
            if (businessFeedData8 == null) {
                b.c("CanvasTitleView", "[onCanvasAreaClicked] feedData is null, area id:" + dittoArea.getId());
                return;
            }
            Comment mainComment = businessFeedData8.getMainComment();
            if (mainComment != null) {
                if (mainComment.isliked) {
                    this.passive_comment_like_btn.setBackgroundDrawable(PASSIVE_FEED_PRAISE_NORMAL);
                } else {
                    this.passive_comment_like_btn.setBackgroundDrawable(PASSIVE_FEED_PRAISED);
                }
                this.passive_comment_like_btn.invalidate();
            }
            ClickedComment clickedComment = new ClickedComment();
            clickedComment.setPosition(this.feedPosition);
            clickedComment.setComment(mainComment);
            this.onFeedElementClickListener.onClick(this, FeedElement.COMMENT_PRAISE_BUTTON, this.feedPosition, clickedComment);
            return;
        }
        if (dittoArea == this.upper_banner_close_container) {
            g gVar25 = this.onFeedElementClickListener;
            FeedElement feedElement24 = FeedElement.TITLE_UPPER_BANNER_CLOSE_BUTTON;
            int i68 = this.feedPosition;
            gVar25.onClick(this, feedElement24, i68, Integer.valueOf(i68));
            return;
        }
        if (dittoArea == this.qzone_vip_signature) {
            cooperation.vip.c.b(141, 2);
            g gVar26 = this.onFeedElementClickListener;
            FeedElement feedElement25 = FeedElement.FEED_VIP_SIGNATURE;
            int i69 = this.feedPosition;
            gVar26.onClick(this, feedElement25, i69, Integer.valueOf(i69));
        }
    }

    public View getFollowButtonPos(Rect rect) {
        return this;
    }
}
