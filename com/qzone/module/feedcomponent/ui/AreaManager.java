package com.qzone.module.feedcomponent.ui;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.qzone.adapter.feedcomponent.l;
import com.qzone.canvasui.widget.CanvasMultiGifArea;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellQbossPsvAdv;
import com.qzone.proxy.feedcomponent.model.CellShareCard;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.text.NetImageCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.widget.x;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import com.tencent.smtt.sdk.TbsListener;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;

/* compiled from: P */
@Deprecated
/* loaded from: classes39.dex */
public class AreaManager {
    public static Drawable ADD_PHOTO_DRAWABLE = null;
    public static Drawable ADV_CLOSE_DRAWABLE = null;
    public static Drawable BIRTHDAY_CLOSE_DRAWABLE = null;
    public static Drawable BORDER_CONTAINER_ADV = null;
    public static Drawable COMMENT_COUNT_DRAWABLE = null;
    public static Drawable COMMENT_LINE_DRAWABLE = null;
    public static final Drawable DEFAULT_AVATAR;
    public static Drawable DEFAULT_BACKGROUND = null;
    public static Drawable DEFAULT_BACKGROUND_NETWORK = null;
    public static Drawable DEFAULT_BACKGROUND_SERVER = null;
    public static final OvalProcessor DEFAULT_OVAL_PROCESSOR;
    public static int DEFAULT_TITLEBAR_HEIGHT = 0;
    public static Drawable DELETE_DRAWABLE = null;
    public static Drawable DROPDOWN_DRAWABLE = null;
    public static int EXTEND_FEED_HORIZONTAL_INTERVAL = 0;
    public static int EXTEND_FEED_INNER_INTERVAL = 0;
    public static int EXTEND_FEED_OUTER_INTERVAL = 0;
    public static Drawable FEED_ANNIVERSARY_COLOR_COVER = null;
    public static Drawable FEED_ARROW_RIGHT_ICON = null;
    public static Drawable FEED_FRD_LIKE_MINI_APP_LOGO = null;
    public static Drawable FEED_FRD_LIKE_MINI_APP_PLAY_ICON = null;
    public static Drawable FEED_GALLERY_EVENT_TAG = null;
    public static int FEED_INTERVAL = 0;
    public static Drawable FEED_KINGCARD_PLAY_BG = null;
    public static Drawable FEED_KINGCARD_PLAY_ICON = null;
    public static Drawable FEED_TITLE_UPPER_BANNER_BG = null;
    public static Drawable FEED_VIDEO_BANNER_PRAISE_N = null;
    public static Drawable FEED_VIDEO_BANNER_PRAISE_P = null;
    public static Drawable FORWARD_DRAWABLE = null;
    public static Drawable GIF_DRAWABLE = null;
    public static Drawable GOLDEN_CUDGEL_DRAWABLE = null;
    public static Drawable HAS_PRAISE_DRAWABLE = null;
    public static Drawable HIGH_FIVE_CLICKED_DRAWABLE = null;
    public static Drawable HIGH_FIVE_NORMAL_DRAWABLE = null;
    public static Drawable ICON_VIDEO_PLAY = null;
    public static Drawable IMAGE_BACKGROUND = null;
    public static final Drawable IMAGE_VIDEO;
    public static boolean IS_NIGHT_MODE = false;
    public static Drawable LEFT_BG_DRAWABLE = null;
    public static Drawable LONG_PICS_BROWSING_DRAWABLE = null;
    public static final int MARGIN_LEFT;
    public static final int MARGIN_RIGHT;
    static final int MAX_CACHE_SIZE = 3040;
    public static Drawable MESSAGE_LIST_BACKGROUND = null;
    public static final int MSG_INVALIDATE_AREA = 1;
    public static final int MSG_INVALIDATE_VIEW = 5;
    public static final int MSG_LAYOUT_VIDEO_COVER = 7;
    public static final int MSG_REQUEST_LAYOUT_AREA = 2;
    public static final int MSG_REQUEST_LAYOUT_VIEW = 6;
    public static final int MSG_SET_AREA_DATA = 8;
    public static final int MSG_SET_COMMENT_PIC_DRAWABLE = 4;
    public static final int MSG_SET_COMMENT_PIC_GIF = 16;
    public static final int MSG_SET_MULTIC_PIC_DRAWABLE = 3;
    public static final int MSG_SET_MULTIC_PIC_GIF = 9;
    public static Drawable MULTIPICTURE_ARROW = null;
    public static final int NORMAL_FEED_WIDTH;
    public static Drawable PANORAMA_LOG0_DRAWABLE = null;
    public static final Drawable QQ_MUSIC_PLAY;
    public static final Drawable QQ_MUSIC_STOP;
    public static Drawable QZONE_FEED_VIDEO_WEISHI_LOGO = null;
    public static Drawable QZONE_NEW_GUIDE_SHADOW_BG = null;
    public static Drawable RAPID_COMMENT_IMMEDIATELY_DRAWABLE = null;
    public static Drawable RECOMMM_DRAWBLE = null;
    public static final int SCREEN_WIDTH;
    public static Drawable SKIN_FEED_INPUT_BOX_BACKGROUND = null;
    public static Drawable SKIN_ICON_GIFT = null;
    static final String TAG = "AreaManager";
    public static Drawable VISIT_DRAWABLE;
    public static final int dp0_5;

    /* renamed from: dp1, reason: collision with root package name */
    public static final int f48750dp1;
    public static final int dp10;
    public static final int dp10_5;
    public static final int dp11;
    public static final int dp110;
    public static final int dp12;
    public static final int dp120;
    public static final int dp13;
    public static final int dp14;
    public static final int dp15;
    public static final int dp16;
    public static final int dp160;
    public static final int dp170;
    public static final int dp18;

    /* renamed from: dp2, reason: collision with root package name */
    public static final int f48751dp2;
    public static final int dp20;
    public static final int dp200;
    public static final int dp201_5;
    public static final int dp21;
    public static final int dp22;
    public static final int dp24;
    public static final int dp27;
    public static final int dp28;

    /* renamed from: dp3, reason: collision with root package name */
    public static final int f48752dp3;
    public static final int dp30;
    public static final int dp32;
    public static final int dp33;
    public static final int dp34;
    public static final int dp35;
    public static final int dp36;
    public static final int dp37;

    /* renamed from: dp4, reason: collision with root package name */
    public static final int f48753dp4;
    public static final int dp40;
    public static final int dp44;
    public static final int dp45;
    public static final int dp48;
    public static final int dp4_5;
    public static final int dp5;
    public static final int dp50;
    public static final int dp52;
    public static final int dp53;
    public static final int dp55;
    public static final int dp6;
    public static final int dp60;
    public static final int dp68;
    public static final int dp7;
    public static final int dp75;
    public static final int dp8;
    public static final int dp80;
    public static final int dp9;
    public static final int dp96;
    public static int grayColor;
    public static int loveVipColor;
    static AreaManager mInstance;
    public static Handler mainHanlder;
    public static int vipColor;
    FeedTextArea preMeasureCampusTextArea;
    FeedTextArea preMeasureSummaryTextArea;
    static ConcurrentHashMap<String, SubArea> mAreaCache = new ConcurrentHashMap<>(300);
    static ConcurrentHashMap<Integer, Paint> mPaintCache = new ConcurrentHashMap<>(16, 0.75f, 2);

    static {
        int screenWidth = FeedGlobalEnv.g().getScreenWidth();
        SCREEN_WIDTH = screenWidth;
        dp0_5 = com.qzone.proxy.feedcomponent.util.g.a(0.5f);
        f48750dp1 = com.qzone.proxy.feedcomponent.util.g.a(1.0f);
        f48751dp2 = com.qzone.proxy.feedcomponent.util.g.a(2.0f);
        f48752dp3 = com.qzone.proxy.feedcomponent.util.g.a(3.0f);
        f48753dp4 = com.qzone.proxy.feedcomponent.util.g.a(4.0f);
        dp4_5 = com.qzone.proxy.feedcomponent.util.g.a(4.5f);
        dp5 = com.qzone.proxy.feedcomponent.util.g.a(5.0f);
        dp6 = com.qzone.proxy.feedcomponent.util.g.a(6.0f);
        dp7 = com.qzone.proxy.feedcomponent.util.g.a(7.0f);
        int a16 = com.qzone.proxy.feedcomponent.util.g.a(8.0f);
        dp8 = a16;
        dp9 = com.qzone.proxy.feedcomponent.util.g.a(9.0f);
        dp10 = com.qzone.proxy.feedcomponent.util.g.a(10.0f);
        dp10_5 = com.qzone.proxy.feedcomponent.util.g.a(10.5f);
        dp11 = com.qzone.proxy.feedcomponent.util.g.a(11.0f);
        dp12 = com.qzone.proxy.feedcomponent.util.g.a(12.0f);
        dp13 = com.qzone.proxy.feedcomponent.util.g.a(13.0f);
        dp14 = com.qzone.proxy.feedcomponent.util.g.a(14.0f);
        dp15 = com.qzone.proxy.feedcomponent.util.g.a(15.0f);
        dp16 = com.qzone.proxy.feedcomponent.util.g.a(16.0f);
        dp18 = com.qzone.proxy.feedcomponent.util.g.a(18.0f);
        int a17 = com.qzone.proxy.feedcomponent.util.g.a(20.0f);
        dp20 = a17;
        dp21 = com.qzone.proxy.feedcomponent.util.g.a(21.0f);
        dp22 = com.qzone.proxy.feedcomponent.util.g.a(22.0f);
        dp24 = com.qzone.proxy.feedcomponent.util.g.a(24.0f);
        dp27 = com.qzone.proxy.feedcomponent.util.g.a(27.0f);
        dp28 = com.qzone.proxy.feedcomponent.util.g.a(28.0f);
        dp30 = com.qzone.proxy.feedcomponent.util.g.a(30.0f);
        dp32 = com.qzone.proxy.feedcomponent.util.g.a(32.0f);
        dp33 = com.qzone.proxy.feedcomponent.util.g.a(33.0f);
        dp34 = com.qzone.proxy.feedcomponent.util.g.a(34.0f);
        dp35 = com.qzone.proxy.feedcomponent.util.g.a(35.0f);
        dp36 = com.qzone.proxy.feedcomponent.util.g.a(36.0f);
        dp37 = com.qzone.proxy.feedcomponent.util.g.a(37.0f);
        dp40 = com.qzone.proxy.feedcomponent.util.g.a(40.0f);
        dp44 = com.qzone.proxy.feedcomponent.util.g.a(44.0f);
        dp45 = com.qzone.proxy.feedcomponent.util.g.a(45.0f);
        dp48 = com.qzone.proxy.feedcomponent.util.g.a(48.0f);
        dp50 = com.qzone.proxy.feedcomponent.util.g.a(50.0f);
        dp52 = com.qzone.proxy.feedcomponent.util.g.a(52.0f);
        dp53 = com.qzone.proxy.feedcomponent.util.g.a(53.0f);
        dp55 = com.qzone.proxy.feedcomponent.util.g.a(55.0f);
        dp60 = com.qzone.proxy.feedcomponent.util.g.a(60.0f);
        dp75 = com.qzone.proxy.feedcomponent.util.g.a(75.0f);
        dp80 = com.qzone.proxy.feedcomponent.util.g.a(80.0f);
        dp96 = com.qzone.proxy.feedcomponent.util.g.a(96.0f);
        dp68 = com.qzone.proxy.feedcomponent.util.g.a(68.0f);
        dp110 = com.qzone.proxy.feedcomponent.util.g.a(110.0f);
        dp120 = com.qzone.proxy.feedcomponent.util.g.a(120.0f);
        dp160 = com.qzone.proxy.feedcomponent.util.g.a(160.0f);
        dp170 = com.qzone.proxy.feedcomponent.util.g.a(170.0f);
        dp200 = com.qzone.proxy.feedcomponent.util.g.a(200.0f);
        dp201_5 = com.qzone.proxy.feedcomponent.util.g.a(201.5f);
        FEED_INTERVAL = a16;
        EXTEND_FEED_OUTER_INTERVAL = a16;
        EXTEND_FEED_INNER_INTERVAL = a17;
        EXTEND_FEED_HORIZONTAL_INTERVAL = a17 + a16;
        NORMAL_FEED_WIDTH = screenWidth - a16;
        DEFAULT_TITLEBAR_HEIGHT = (int) (FeedGlobalEnv.g().getDensity() * 76.0f);
        MARGIN_LEFT = com.qzone.adapter.feedcomponent.j.f(274);
        MARGIN_RIGHT = com.qzone.adapter.feedcomponent.j.f(275);
        IMAGE_VIDEO = com.qzone.adapter.feedcomponent.j.g(643);
        QQ_MUSIC_STOP = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON);
        QQ_MUSIC_PLAY = com.qzone.adapter.feedcomponent.j.g(567);
        OvalProcessor ovalProcessor = new OvalProcessor();
        DEFAULT_OVAL_PROCESSOR = ovalProcessor;
        DEFAULT_AVATAR = ovalProcessor.process(com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.CURRUNT_TIME));
        grayColor = com.qzone.adapter.feedcomponent.j.c(11);
        vipColor = com.qzone.adapter.feedcomponent.j.c(5);
        loveVipColor = com.qzone.adapter.feedcomponent.j.c(47);
        DEFAULT_BACKGROUND = com.qzone.adapter.feedcomponent.j.g(7);
        DEFAULT_BACKGROUND_NETWORK = com.qzone.adapter.feedcomponent.j.g(835);
        DEFAULT_BACKGROUND_SERVER = com.qzone.adapter.feedcomponent.j.g(836);
        ICON_VIDEO_PLAY = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT);
        DELETE_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(550);
        SKIN_FEED_INPUT_BOX_BACKGROUND = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.TITLE_BAR);
        IMAGE_BACKGROUND = com.qzone.adapter.feedcomponent.j.g(552);
        COMMENT_LINE_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.LOADING);
        HAS_PRAISE_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.VIDEO_SURFACE);
        VISIT_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON);
        GIF_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(555);
        GOLDEN_CUDGEL_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.CONTROLLER_PROGRESS);
        LONG_PICS_BROWSING_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(944);
        LEFT_BG_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.PLAYER_DURATION);
        FORWARD_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(801);
        COMMENT_COUNT_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(com.tencent.luggage.wxa.uf.f.CTRL_INDEX);
        RECOMMM_DRAWBLE = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.GET_MORE_JUMP_TIPS_BTN);
        RAPID_COMMENT_IMMEDIATELY_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(588);
        ADD_PHOTO_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(718);
        MULTIPICTURE_ARROW = com.qzone.adapter.feedcomponent.j.g(TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION);
        DROPDOWN_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(719);
        ADV_CLOSE_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(726);
        BIRTHDAY_CLOSE_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(726);
        PANORAMA_LOG0_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(QCircleReportHelper.SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_GROUP_PAGE);
        HIGH_FIVE_NORMAL_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(869);
        HIGH_FIVE_CLICKED_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(870);
        FEED_VIDEO_BANNER_PRAISE_N = com.qzone.adapter.feedcomponent.j.g(920);
        FEED_VIDEO_BANNER_PRAISE_P = com.qzone.adapter.feedcomponent.j.g(921);
        MESSAGE_LIST_BACKGROUND = com.qzone.adapter.feedcomponent.j.g(QVipServiceAccountFolderProcessor.CMD);
        FEED_GALLERY_EVENT_TAG = com.qzone.adapter.feedcomponent.j.g(804);
        BORDER_CONTAINER_ADV = com.qzone.adapter.feedcomponent.j.g(766);
        FEED_ANNIVERSARY_COLOR_COVER = com.qzone.adapter.feedcomponent.j.g(806);
        QZONE_NEW_GUIDE_SHADOW_BG = com.qzone.adapter.feedcomponent.j.g(com.tencent.luggage.wxa.i2.b.CTRL_INDEX);
        FEED_ARROW_RIGHT_ICON = com.qzone.adapter.feedcomponent.j.g(832);
        SKIN_ICON_GIFT = com.qzone.adapter.feedcomponent.j.g(com.qzone.adapter.feedcomponent.j.h(577));
        QZONE_FEED_VIDEO_WEISHI_LOGO = com.qzone.adapter.feedcomponent.j.g(871);
        FEED_FRD_LIKE_MINI_APP_LOGO = com.qzone.adapter.feedcomponent.j.g(963);
        FEED_FRD_LIKE_MINI_APP_PLAY_ICON = com.qzone.adapter.feedcomponent.j.g(964);
        FEED_KINGCARD_PLAY_ICON = com.qzone.adapter.feedcomponent.j.g(925);
        FEED_KINGCARD_PLAY_BG = com.qzone.adapter.feedcomponent.j.g(926);
        FEED_TITLE_UPPER_BANNER_BG = com.qzone.adapter.feedcomponent.j.g(936);
        mainHanlder = new l(Looper.getMainLooper()) { // from class: com.qzone.module.feedcomponent.ui.AreaManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Object obj = message.obj;
                if (obj == null) {
                    return;
                }
                int i3 = message.what;
                if (i3 == 8) {
                    AreaDataHolder areaDataHolder = (AreaDataHolder) obj;
                    SubArea subArea = areaDataHolder.getSubArea();
                    subArea.setAreaData(message.arg1, message.arg2, areaDataHolder);
                    subArea.recyleAreaDataHolder(areaDataHolder);
                    return;
                }
                if (i3 == 9) {
                    CanvasMultiGifArea.DrawableHolder drawableHolder = (CanvasMultiGifArea.DrawableHolder) obj;
                    CanvasMultiGifArea.setGifArea(drawableHolder.picArea, message.arg1, message.arg2, drawableHolder.autoGifDrawable);
                    CanvasMultiGifArea.DrawableHolder.recyle(drawableHolder);
                    return;
                }
                if (i3 != 16) {
                    switch (i3) {
                        case 1:
                            if (obj instanceof DittoArea) {
                                ((DittoArea) obj).invalidate();
                                return;
                            } else {
                                ((SubArea) obj).invalidate();
                                return;
                            }
                        case 2:
                            if (obj instanceof DittoArea) {
                                ((DittoArea) obj).requestLayout();
                                return;
                            } else {
                                ((SubArea) obj).requestLayout();
                                return;
                            }
                        case 3:
                            CanvasMultiGifArea.DrawableHolder drawableHolder2 = (CanvasMultiGifArea.DrawableHolder) obj;
                            CanvasMultiGifArea.setPicArea(drawableHolder2.picArea, message.arg1, message.arg2, drawableHolder2.drawable, drawableHolder2.url, drawableHolder2.downloadInfo);
                            CanvasMultiGifArea.DrawableHolder.recyle(drawableHolder2);
                            return;
                        case 4:
                            CanvasMultiGifArea.DrawableHolderV2 drawableHolderV2 = (CanvasMultiGifArea.DrawableHolderV2) obj;
                            CanvasMultiGifArea.setPicArea(drawableHolderV2.picArea, message.arg1, message.arg2, drawableHolderV2.drawable, null, null);
                            CanvasMultiGifArea.DrawableHolderV2.recyle(drawableHolderV2);
                            return;
                        case 5:
                            ((View) obj).invalidate();
                            return;
                        case 6:
                            ((View) obj).requestLayout();
                            return;
                        default:
                            return;
                    }
                }
                CanvasMultiGifArea.DrawableHolderV2 drawableHolderV22 = (CanvasMultiGifArea.DrawableHolderV2) obj;
                CanvasMultiGifArea.setGifArea(drawableHolderV22.picArea, message.arg1, message.arg2, drawableHolderV22.autoGifDrawable);
                CanvasMultiGifArea.DrawableHolderV2.recyle(drawableHolderV22);
            }
        };
        Drawable drawable = SKIN_FEED_INPUT_BOX_BACKGROUND;
        if (drawable != null) {
            drawable.setBounds(0, 0, AreaConst.getCommentWidth(), AreaConst.DEFAULT_GUIDE_HEIGHT);
        }
        Drawable drawable2 = COMMENT_LINE_DRAWABLE;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, AreaConst.DEFAULT_PRAISE_WIDTH, AreaConst.COMMENT_LINE_HEIGHT);
        }
        Drawable drawable3 = HAS_PRAISE_DRAWABLE;
        if (drawable3 != null) {
            int i3 = AreaConst.dp20;
            drawable3.setBounds(0, 0, i3, i3);
        }
        if (RECOMMM_DRAWBLE == null) {
            RECOMMM_DRAWBLE = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.GET_MORE_JUMP_TIPS_BTN);
        }
        Drawable drawable4 = RECOMMM_DRAWBLE;
        if (drawable4 != null) {
            int i16 = AreaConst.dp40;
            drawable4.setBounds(0, 0, i16, i16);
        }
        if (DELETE_DRAWABLE == null) {
            DELETE_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(550);
        }
        Drawable drawable5 = DELETE_DRAWABLE;
        if (drawable5 != null) {
            int i17 = AreaConst.dp20;
            drawable5.setBounds(0, 0, i17, i17);
        }
        if (DROPDOWN_DRAWABLE == null) {
            DROPDOWN_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(719);
        }
        Drawable drawable6 = DROPDOWN_DRAWABLE;
        if (drawable6 != null) {
            int i18 = AreaConst.dp20;
            drawable6.setBounds(0, 0, i18, i18);
        }
        if (ADV_CLOSE_DRAWABLE == null) {
            ADV_CLOSE_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(726);
        }
        Drawable drawable7 = ADV_CLOSE_DRAWABLE;
        if (drawable7 != null) {
            int i19 = AreaConst.dp15;
            drawable7.setBounds(0, 0, i19, i19);
        }
        if (BIRTHDAY_CLOSE_DRAWABLE == null) {
            BIRTHDAY_CLOSE_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(726);
        }
        Drawable drawable8 = BIRTHDAY_CLOSE_DRAWABLE;
        if (drawable8 != null) {
            int i26 = AreaConst.dp9;
            drawable8.setBounds(0, 0, i26, i26);
        }
        if (HIGH_FIVE_NORMAL_DRAWABLE == null) {
            HIGH_FIVE_NORMAL_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(869);
        }
        Drawable drawable9 = HIGH_FIVE_NORMAL_DRAWABLE;
        if (drawable9 != null) {
            int i27 = AreaConst.dp32;
            drawable9.setBounds(0, 0, i27, i27);
        }
        if (HIGH_FIVE_CLICKED_DRAWABLE == null) {
            HIGH_FIVE_CLICKED_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(870);
        }
        Drawable drawable10 = HIGH_FIVE_CLICKED_DRAWABLE;
        if (drawable10 != null) {
            int i28 = AreaConst.dp32;
            drawable10.setBounds(0, 0, i28, i28);
        }
    }

    AreaManager() {
        init();
    }

    public static AreaManager getInstance() {
        if (mInstance == null) {
            synchronized (AreaManager.class) {
                if (mInstance == null) {
                    mInstance = new AreaManager();
                    SubAreaShell.loadPool();
                }
            }
        }
        return mInstance;
    }

    public String convertNetImageCellDp2Px(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = x.f61179i.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        String group = matcher.group();
        int length = group.length() - 1;
        int indexOf = group.indexOf(",w:");
        int indexOf2 = group.indexOf(",h:");
        StringBuilder sb5 = new StringBuilder(group.substring(0, indexOf + 3));
        sb5.append(Math.round((Integer.valueOf(group.substring(r2, indexOf2)).intValue() * DittoUIEngine.g().getDensity()) / 2.0f));
        int round = Math.round((Integer.valueOf(group.substring(indexOf2 + 3, length)).intValue() * DittoUIEngine.g().getDensity()) / 2.0f);
        sb5.append(",h:");
        sb5.append(round);
        sb5.append("}");
        return str.replace(group, sb5.toString());
    }

    public SubArea getCommentCountInfoArea(String str, String str2) {
        return getCommentCountInfoArea(str, str2, false);
    }

    public SubArea getForwardListArea(String str, String str2, boolean z16) {
        return getForwardListArea(str, str2, z16, false);
    }

    public Paint getPaintForTextArea(int i3) {
        Paint paint = mPaintCache.get(Integer.valueOf(i3));
        if (paint == null) {
            paint = new Paint(1);
            if (i3 != Integer.MAX_VALUE) {
                mPaintCache.put(Integer.valueOf(i3), paint);
            }
        }
        return paint;
    }

    public SubArea getVisitListArea(String str, String str2) {
        return getVisitListArea(str, str2, false);
    }

    protected void init() {
        IS_NIGHT_MODE = com.qzone.adapter.feedcomponent.j.R();
    }

    public void onConfigurationChanged(Configuration configuration) {
        CanvasMultiGifArea.onConfigurationChanged(configuration);
        com.qzone.adapter.feedcomponent.b.d(configuration);
        GuideCommentArea.onConfigurationChanged(configuration);
    }

    public void onThemeColorChange() {
        AreaConst.normalMaxLines = com.qzone.adapter.feedcomponent.h.b("QZoneSetting", "FeedTextMaxLine", 10);
        AreaConst.packOrUnpackDirect = com.qzone.adapter.feedcomponent.h.b("QZoneSetting", "FeedSummaryExpandDirect", 1);
        AreaConst.packShowLine = com.qzone.adapter.feedcomponent.h.b("QZoneSetting", "FeedSummaryShowNumUnExpand", 8);
        AreaConst.maxPack = com.qzone.adapter.feedcomponent.h.b("QZoneSetting", "FeedSummaryMaxMaxLine", 20);
        AreaConst.minPack = com.qzone.adapter.feedcomponent.h.b("QZoneSetting", "FeedSummaryMinMaxLine", 10);
        vipColor = com.qzone.adapter.feedcomponent.j.c(5);
        loveVipColor = com.qzone.adapter.feedcomponent.j.c(47);
        DELETE_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(550);
        SKIN_FEED_INPUT_BOX_BACKGROUND = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.TITLE_BAR);
        IMAGE_BACKGROUND = com.qzone.adapter.feedcomponent.j.g(552);
        COMMENT_LINE_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.LOADING);
        HAS_PRAISE_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.VIDEO_SURFACE);
        LEFT_BG_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.PLAYER_DURATION);
        VISIT_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.SWITCH_LANDSCAPE_BUTTON);
        Drawable drawable = DELETE_DRAWABLE;
        if (drawable != null) {
            int i3 = AreaConst.dp20;
            drawable.setBounds(0, 0, i3, i3);
        }
        Drawable drawable2 = SKIN_FEED_INPUT_BOX_BACKGROUND;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, AreaConst.getCommentWidth(), AreaConst.DEFAULT_GUIDE_HEIGHT);
        }
        Drawable drawable3 = HAS_PRAISE_DRAWABLE;
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), HAS_PRAISE_DRAWABLE.getIntrinsicHeight());
        }
        AreaConst.DEFAULT_COMMENT_PADDING = 0;
        AreaConst.DEFAULT_HEIGHT = (int) (FeedGlobalEnv.g().getDensity() * 80.0f);
        AreaConst.PASSIVE_HEIGHT = (int) (FeedGlobalEnv.g().getDensity() * 80.0f);
        AreaConst.TIME_LBS_WIDTH = FeedGlobalEnv.g().getScreenWidth() - ((int) (FeedGlobalEnv.g().getDensity() * 114.0f));
        AreaConst.RECOMM_SUMMARY_WIDTH = FeedGlobalEnv.g().getScreenWidth() - ((int) (FeedGlobalEnv.g().getDensity() * 89.0f));
        AreaConst.feedWidth = FeedGlobalEnv.g().getScreenWidth() - (AreaConst.FEED_INTERVAL * 2);
        PraiseAvatarsArea.onThemeChange();
        mAreaCache.clear();
        IS_NIGHT_MODE = com.qzone.adapter.feedcomponent.j.R();
        RAPID_COMMENT_IMMEDIATELY_DRAWABLE = com.qzone.adapter.feedcomponent.j.g(588);
        GuideCommentArea.onThemeChange();
        ((ColorDrawable) FeedView.mBackgroundDrawablePart1).setColor(com.qzone.adapter.feedcomponent.j.s());
        ((ColorDrawable) FeedView.mBackgroundDrawableForward).setColor(com.qzone.adapter.feedcomponent.j.E());
    }

    public synchronized int preCalcCampusContentTextSize(CellShareCard cellShareCard) {
        if (cellShareCard != null) {
            if (!TextUtils.isEmpty(cellShareCard.content)) {
                if (this.preMeasureCampusTextArea == null) {
                    this.preMeasureSummaryTextArea = new FeedTextArea(83);
                }
                int screenWidth = (FeedGlobalEnv.g().getScreenWidth() - dp20) - (dp14 * 2);
                this.preMeasureSummaryTextArea.setTextSize(22.0f);
                this.preMeasureSummaryTextArea.setRichText(cellShareCard.content, false);
                int preMeasuewLine = this.preMeasureSummaryTextArea.preMeasuewLine(screenWidth);
                if (preMeasuewLine <= 1) {
                    cellShareCard.content_line = preMeasuewLine;
                    cellShareCard.content_TextSize = 22;
                    return preMeasuewLine;
                }
                this.preMeasureSummaryTextArea.setTextSize(20.0f);
                this.preMeasureSummaryTextArea.setRichText(cellShareCard.content, false);
                int preMeasuewLine2 = this.preMeasureSummaryTextArea.preMeasuewLine(screenWidth);
                if (preMeasuewLine2 <= 2) {
                    cellShareCard.content_line = preMeasuewLine2;
                    cellShareCard.content_TextSize = 20;
                    return preMeasuewLine2;
                }
                cellShareCard.content_line = 3;
                cellShareCard.content_TextSize = 17;
                return 3;
            }
        }
        return 0;
    }

    public SubArea putAreaToCache(String str, SubArea subArea) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return mAreaCache.put(str, subArea);
    }

    public SubArea removeAreaFromCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return mAreaCache.remove(str);
    }

    public static void clearBigDrawableMemory() {
        FEED_FRD_LIKE_MINI_APP_PLAY_ICON = null;
        LONG_PICS_BROWSING_DRAWABLE = null;
        HIGH_FIVE_NORMAL_DRAWABLE = null;
        HIGH_FIVE_CLICKED_DRAWABLE = null;
    }

    public SubArea getCommentCountInfoArea(String str, String str2, boolean z16) {
        FeedTextAreaEx feedTextAreaEx = str2 != null ? (FeedTextAreaEx) mAreaCache.get(str2) : null;
        if (feedTextAreaEx != null) {
            return feedTextAreaEx;
        }
        FeedTextAreaEx feedTextAreaEx2 = new FeedTextAreaEx(78);
        feedTextAreaEx2.setTextSize(AreaConst.praiseListTextSize);
        feedTextAreaEx2.setTextColor(com.qzone.adapter.feedcomponent.j.J());
        Drawable drawable = COMMENT_COUNT_DRAWABLE;
        feedTextAreaEx2.setDataExtra(str, "commentCount", drawable, drawable.getIntrinsicWidth());
        feedTextAreaEx2.setImageSpace(AreaConst.f48749dp4);
        feedTextAreaEx2.setHasPressState(!z16);
        feedTextAreaEx2.setMaxWidth(AreaConst.getDefaultWidth());
        feedTextAreaEx2.measure(-2, 0);
        putAreaToCache(str2, feedTextAreaEx2);
        return feedTextAreaEx2;
    }

    public SubArea getForwardListArea(String str, String str2, boolean z16, boolean z17) {
        FeedTextAreaEx feedTextAreaEx = str2 != null ? (FeedTextAreaEx) mAreaCache.get(str2) : null;
        if (feedTextAreaEx != null && !z16) {
            return feedTextAreaEx;
        }
        FeedTextAreaEx feedTextAreaEx2 = new FeedTextAreaEx(76);
        feedTextAreaEx2.setTextSize(AreaConst.praiseListTextSize);
        feedTextAreaEx2.setTextColor(com.qzone.adapter.feedcomponent.j.J());
        Drawable drawable = FORWARD_DRAWABLE;
        feedTextAreaEx2.setDataExtra(str, "forward", drawable, drawable.getIntrinsicWidth());
        feedTextAreaEx2.setImageSpace(AreaConst.f48749dp4);
        feedTextAreaEx2.setHasPressState(!z17);
        feedTextAreaEx2.setMaxWidth(AreaConst.getDefaultWidth());
        feedTextAreaEx2.measure(-2, 0);
        putAreaToCache(str2, feedTextAreaEx2);
        return feedTextAreaEx2;
    }

    public SubArea getVisitListArea(String str, String str2, boolean z16) {
        FeedTextAreaEx feedTextAreaEx = str2 != null ? (FeedTextAreaEx) mAreaCache.get(str2) : null;
        if (feedTextAreaEx == null) {
            feedTextAreaEx = new FeedTextAreaEx(30);
            feedTextAreaEx.setTextSize(AreaConst.visitListTextSize);
            feedTextAreaEx.setTextColor(-7894119);
            feedTextAreaEx.setData(str, 7, (Drawable) null);
            feedTextAreaEx.setImageSpace(AreaConst.f48749dp4);
            feedTextAreaEx.setHasPressState(!z16);
            feedTextAreaEx.setMaxWidth(AreaConst.getDefaultWidth());
            feedTextAreaEx.measure(-2, 0);
            if (str2 != null) {
                putAreaToCache(str2, feedTextAreaEx);
            }
        }
        return feedTextAreaEx;
    }

    public SubArea getCommentArea(Comment comment, int i3, String str) {
        SubArea subArea = str != null ? mAreaCache.get(str) : null;
        SubArea subArea2 = subArea;
        if (subArea == null) {
            CommentTextArea commentTextArea = new CommentTextArea(1);
            commentTextArea.setIsNeedLineSpace(false);
            commentTextArea.setData(comment);
            subArea2 = commentTextArea;
        }
        CommentTextArea commentTextArea2 = (CommentTextArea) subArea2;
        commentTextArea2.commentIndex = i3;
        commentTextArea2.isComment = true;
        return subArea2;
    }

    public SubArea getInterestArea(String str, String str2, String str3, boolean z16) {
        ColorFeedTextArea colorFeedTextArea = str3 != null ? (ColorFeedTextArea) mAreaCache.get(str3) : null;
        if (colorFeedTextArea != null && !z16) {
            return colorFeedTextArea;
        }
        ColorFeedTextArea colorFeedTextArea2 = new ColorFeedTextArea(25);
        colorFeedTextArea2.setTextSize(AreaConst.visitListTextSize);
        colorFeedTextArea2.setMaxLine(1);
        colorFeedTextArea2.setTextColor(com.qzone.adapter.feedcomponent.j.o());
        colorFeedTextArea2.setLinkColor(com.qzone.adapter.feedcomponent.j.o());
        colorFeedTextArea2.setData(str, 7);
        colorFeedTextArea2.setEllipsisStr(str2);
        colorFeedTextArea2.setMaxWidth(AreaConst.SCREEN_WIDTH - AreaConst.LIKE_LIST_MAX_WIDTH_RIGHT_OFFSET);
        colorFeedTextArea2.measure(-2, 0);
        putAreaToCache(str3, colorFeedTextArea2);
        return colorFeedTextArea2;
    }

    public SubArea getPicTextArea(String str, String str2, String str3) {
        PlayBarUserArea playBarUserArea = str3 != null ? (PlayBarUserArea) mAreaCache.get(str3) : null;
        if (playBarUserArea != null) {
            return playBarUserArea;
        }
        PlayBarUserArea playBarUserArea2 = new PlayBarUserArea();
        playBarUserArea2.setPostFix(str2);
        playBarUserArea2.setData(str, 0);
        playBarUserArea2.measure(PlayBarUserArea.DEFAULT_WIDTH, 0);
        putAreaToCache(str3, playBarUserArea2);
        return playBarUserArea2;
    }

    public SubArea getPraiseAvatarsArea(CellLikeInfo cellLikeInfo, String str, boolean z16) {
        PraiseAvatarsArea praiseAvatarsArea = str != null ? (PraiseAvatarsArea) mAreaCache.get(str) : null;
        if (praiseAvatarsArea != null && !z16) {
            return praiseAvatarsArea;
        }
        PraiseAvatarsArea praiseAvatarsArea2 = new PraiseAvatarsArea();
        praiseAvatarsArea2.setUsers(cellLikeInfo.getUserList(), cellLikeInfo.likeNum);
        praiseAvatarsArea2.measure(AreaConst.SCREEN_WIDTH, 0);
        putAreaToCache(str, praiseAvatarsArea2);
        return praiseAvatarsArea2;
    }

    public SubArea getPraiseListArea(String str, boolean z16, String str2, boolean z17, boolean z18) {
        FeedTextAreaEx feedTextAreaEx = str2 != null ? (FeedTextAreaEx) mAreaCache.get(str2) : null;
        if (feedTextAreaEx == null || z17) {
            feedTextAreaEx = new FeedTextAreaEx(25);
            feedTextAreaEx.setTextSize(AreaConst.praiseListTextSize);
            feedTextAreaEx.setImageSpace(AreaConst.f48748dp3);
            feedTextAreaEx.setIsNeedLineSpace(Boolean.FALSE);
            feedTextAreaEx.setTextColor(com.qzone.adapter.feedcomponent.j.J());
            int i3 = AreaConst.f48749dp4;
            feedTextAreaEx.setLineSpace(i3);
            if (!z18) {
                Drawable drawable = HAS_PRAISE_DRAWABLE;
                feedTextAreaEx.setDataExtra(str, "praise", drawable, drawable.getIntrinsicWidth());
                feedTextAreaEx.setImageSpace(i3);
            } else {
                feedTextAreaEx.setData(str, 7);
            }
            ArrayList<TextCell> cells = feedTextAreaEx.getCells();
            if (cells != null) {
                Iterator<TextCell> it = cells.iterator();
                while (it.hasNext()) {
                    TextCell next = it.next();
                    if (next instanceof NetImageCell) {
                        ((NetImageCell) next).mWidth = 50;
                    }
                }
            }
            feedTextAreaEx.setMaxWidth(AreaConst.getDefaultWidth());
            feedTextAreaEx.measure(-2, 0);
            feedTextAreaEx.setHasPressState(true);
            putAreaToCache(str2, feedTextAreaEx);
        }
        return feedTextAreaEx;
    }

    public SubArea getReplyArea(Comment comment, Reply reply, int i3, int i16, String str) {
        CommentTextArea commentTextArea = str != null ? (CommentTextArea) mAreaCache.get(str) : null;
        if (commentTextArea == null) {
            commentTextArea = new CommentTextArea(2);
            commentTextArea.setIsNeedLineSpace(false);
            commentTextArea.setData(comment, reply, i16);
        }
        commentTextArea.commentIndex = i3;
        commentTextArea.replyIndex = i16;
        commentTextArea.isComment = false;
        return commentTextArea;
    }

    public void onRefresh() {
        int c16 = com.qzone.adapter.feedcomponent.j.c(20);
        if (com.qzone.proxy.feedcomponent.b.g()) {
            com.qzone.proxy.feedcomponent.b.a(TAG, "onRefresh() FeedResources.getColor(FeedResources.ColorID.SKIN_FEED_BACKGROUND_COLOR) : " + String.format("%x", Integer.valueOf(c16)));
        }
        if (c16 != com.qzone.adapter.feedcomponent.j.m()) {
            com.qzone.adapter.feedcomponent.j.S();
        }
        DittoUIEngine.g().clearRichTextAreaCache();
    }

    public SubArea getLeftThumbAdsSummaryArea(CellQbossPsvAdv cellQbossPsvAdv, String str) {
        SubArea subArea = null;
        subArea = null;
        if (cellQbossPsvAdv != null && (!TextUtils.isEmpty(cellQbossPsvAdv.getSummary()) || cellQbossPsvAdv.getCountDownTime() != 0)) {
            SubArea subArea2 = str != null ? mAreaCache.get(str) : null;
            int defaultWidth = AreaConst.getDefaultWidth();
            if (cellQbossPsvAdv.getPicdata() != null) {
                defaultWidth -= com.qzone.adapter.feedcomponent.b.f41876w;
            }
            if (cellQbossPsvAdv.getBtnText() != null) {
                defaultWidth -= AreaConst.dp24 + AreaConst.dp60;
            }
            if (subArea2 == null) {
                FeedTextArea feedTextArea = new FeedTextArea(72);
                feedTextArea.setTextSize(14.0f);
                feedTextArea.setTextColor(Color.parseColor("#707070"));
                if (cellQbossPsvAdv.getCountDownTime() != 0) {
                    feedTextArea.setData(cellQbossPsvAdv.getCountDownString(), 0);
                } else {
                    feedTextArea.setData(cellQbossPsvAdv.getSummary(), 0);
                }
                feedTextArea.setLineSpace(com.qzone.proxy.feedcomponent.util.g.a(5.0f));
                feedTextArea.setMaxLine(2);
                feedTextArea.setTextBold(false);
                feedTextArea.measure(defaultWidth, 0);
                putAreaToCache(str, feedTextArea);
                subArea = feedTextArea;
            } else {
                subArea = subArea2;
                if (cellQbossPsvAdv.getCountDownTime() != 0) {
                    FeedTextArea feedTextArea2 = (FeedTextArea) subArea2;
                    feedTextArea2.setData(cellQbossPsvAdv.getCountDownString(), 0);
                    feedTextArea2.setLineSpace(com.qzone.proxy.feedcomponent.util.g.a(5.0f));
                    feedTextArea2.setMaxLine(2);
                    feedTextArea2.setTextBold(false);
                    subArea2.measure(defaultWidth, 0);
                    subArea = subArea2;
                }
            }
        }
        return subArea;
    }

    public SubArea getLeftThumbAdsTitleArea(CellQbossPsvAdv cellQbossPsvAdv, String str) {
        if (cellQbossPsvAdv == null || TextUtils.isEmpty(cellQbossPsvAdv.getTitle())) {
            return null;
        }
        SubArea subArea = str != null ? mAreaCache.get(str) : null;
        int defaultWidth = AreaConst.getDefaultWidth();
        if (cellQbossPsvAdv.getPicdata() != null) {
            defaultWidth -= com.qzone.adapter.feedcomponent.b.f41876w;
        }
        if (cellQbossPsvAdv.getBtnText() != null) {
            defaultWidth -= AreaConst.dp24 + AreaConst.dp60;
        }
        if (subArea != null) {
            return subArea;
        }
        FeedTextArea feedTextArea = new FeedTextArea(71);
        feedTextArea.setTextSize(16.0f);
        feedTextArea.setTextColor(com.qzone.adapter.feedcomponent.j.o());
        feedTextArea.setData(cellQbossPsvAdv.getTitle(), 0);
        feedTextArea.setLineSpace(com.qzone.proxy.feedcomponent.util.g.a(5.0f));
        feedTextArea.setMaxLine(1);
        feedTextArea.setTextBold(false);
        feedTextArea.measure(defaultWidth, 0);
        putAreaToCache(str, feedTextArea);
        return feedTextArea;
    }

    public SubArea getRightThumAdsRightBtnArea(CellQbossPsvAdv cellQbossPsvAdv, String str) {
        if (cellQbossPsvAdv == null || TextUtils.isEmpty(cellQbossPsvAdv.getBtnText())) {
            return null;
        }
        SubArea subArea = str != null ? mAreaCache.get(str) : null;
        if (subArea != null && !(subArea instanceof TextButtonArea)) {
            com.qzone.proxy.feedcomponent.b.c("wesley", "" + subArea.getClass());
        }
        int i3 = AreaConst.dp60;
        if (subArea != null) {
            return subArea;
        }
        String btnText = cellQbossPsvAdv.getBtnText();
        if (btnText != null && btnText.length() > 3) {
            btnText = btnText.substring(0, 3);
        }
        TextButtonArea textButtonArea = new TextButtonArea(73, 14.0f, i3, AreaConst.dp30, FeedGlobalEnv.getContext().getResources().getDrawable(com.qzone.adapter.feedcomponent.j.h(706)), btnText, com.qzone.adapter.feedcomponent.j.c(21));
        textButtonArea.measure(i3, 0);
        putAreaToCache(str, textButtonArea);
        return textButtonArea;
    }

    public int measureContainerFeedSummaryLine(CellSummary cellSummary, boolean z16) {
        int i3;
        int i16;
        if (cellSummary == null) {
            return 0;
        }
        if (this.preMeasureSummaryTextArea == null) {
            FeedTextArea feedTextArea = new FeedTextArea(6);
            this.preMeasureSummaryTextArea = feedTextArea;
            feedTextArea.setTextSize(AreaConst.summaryTextSize);
            this.preMeasureSummaryTextArea.setTextColor(com.qzone.adapter.feedcomponent.j.o());
            this.preMeasureSummaryTextArea.setLineSpace(com.qzone.proxy.feedcomponent.util.g.a(3.0f));
            FeedTextArea feedTextArea2 = this.preMeasureSummaryTextArea;
            if (!z16) {
                i16 = AreaConst.normalMaxLines;
            } else {
                i16 = AreaConst.ADV_CONTAINER_SUMMARY_MAX_LINE;
            }
            feedTextArea2.setMaxLine(i16);
            this.preMeasureSummaryTextArea.setShowMore(!z16);
            this.preMeasureSummaryTextArea.setHasMore(cellSummary.isMore > 0);
        }
        this.preMeasureSummaryTextArea.setData(cellSummary.summary, 0);
        FeedTextArea feedTextArea3 = this.preMeasureSummaryTextArea;
        if (z16) {
            i3 = AreaConst.commentSummaryWidth_Rec;
        } else {
            i3 = AreaConst.commentWidth_Rec;
        }
        return feedTextArea3.preMeasuewLine(i3);
    }
}
