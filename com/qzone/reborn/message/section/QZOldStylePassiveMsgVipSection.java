package com.qzone.reborn.message.section;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.message.section.QZOldStylePassiveMsgVipSection;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.ui.IVipFrameDrawable;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.mobileqq.vip.api.IVipIconUtilsForQzone;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001DB\u0007\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J*\u0010#\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00102\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0014R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010&R\u0018\u00103\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010&R\u0018\u00105\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010&R\u0018\u00106\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010&R\u0018\u00108\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010=R\u0014\u0010A\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010@\u00a8\u0006E"}, d2 = {"Lcom/qzone/reborn/message/section/QZOldStylePassiveMsgVipSection;", "Lcom/qzone/reborn/message/section/QZOldStylePassiveMsgBaseSection;", "Lcom/qzone/proxy/feedcomponent/model/User;", QCircleAlphaUserReporter.KEY_USER, "", "L", "M", "Landroid/graphics/drawable/Drawable;", "drawable", "T", "K", "", CoverDBCacheData.URLS, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "tenYearsIdString", "unionVipZipUrl", "", "iconHeight", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "G", "N", "H", "J", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "data", "position", "", "", "payload", "O", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mFeedSkinBg", "i", "mAvatarDecoration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mStarVipIcon", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "mYellowDiamondContainer", "D", "mYellowDiamondStaticPicView", "E", "mYellowDiamondAnimView", UserInfo.SEX_FEMALE, "mQQUnionVipAnimView", "mLoveDiamondPicView", "Landroid/graphics/drawable/Drawable;", "mQQUnionVipAnimation", "Lcom/tencent/mobileqq/vas/ui/IVipFrameDrawable;", "I", "Lcom/tencent/mobileqq/vas/ui/IVipFrameDrawable;", "mLV10Animation", "Ljava/lang/String;", "mLastUnionVipUrl", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "onClickListener", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZOldStylePassiveMsgVipSection extends QZOldStylePassiveMsgBaseSection {
    private static final String M = "QZOldStylePassiveMsgVipSection";
    private static float N = FeedGlobalEnv.g().getScreenWidth() / 720.0f;
    private static String P = "";

    /* renamed from: C, reason: from kotlin metadata */
    private FrameLayout mYellowDiamondContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mYellowDiamondStaticPicView;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mYellowDiamondAnimView;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView mQQUnionVipAnimView;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mLoveDiamondPicView;

    /* renamed from: H, reason: from kotlin metadata */
    private Drawable mQQUnionVipAnimation;

    /* renamed from: I, reason: from kotlin metadata */
    private IVipFrameDrawable mLV10Animation;

    /* renamed from: J, reason: from kotlin metadata */
    private String mLastUnionVipUrl = "";

    /* renamed from: K, reason: from kotlin metadata */
    private final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.message.section.r
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            QZOldStylePassiveMsgVipSection.P(QZOldStylePassiveMsgVipSection.this, view);
        }
    };

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mFeedSkinBg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mAvatarDecoration;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mStarVipIcon;

    private final void G() {
        ImageView imageView = this.mQQUnionVipAnimView;
        if (imageView != null) {
            if (imageView != null) {
                imageView.setImageDrawable(null);
            }
            ImageView imageView2 = this.mQQUnionVipAnimView;
            if (imageView2 == null) {
                return;
            }
            imageView2.setVisibility(8);
        }
    }

    private final void H(User user) {
        if (TextUtils.isEmpty(user.feedAvatarDecorationUrl)) {
            ImageView imageView = this.mAvatarDecoration;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.mAvatarDecoration;
            if (imageView2 == null) {
                return;
            }
            imageView2.setClickable(false);
            return;
        }
        ImageView imageView3 = this.mAvatarDecoration;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setTargetView(this.mAvatarDecoration).setNeedShowLoadingDrawable(false).setUrl(user.feedAvatarDecorationUrl));
        ImageView imageView4 = this.mAvatarDecoration;
        if (imageView4 == null) {
            return;
        }
        imageView4.setClickable(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J(User user) {
        if (user.isSweetVip != 0 && user.vipShowType != 4 && !((BusinessFeedData) this.mData).getFeedCommInfo().isBizRecomFeeds()) {
            ImageView imageView = this.mLoveDiamondPicView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
            long j3 = user.uin;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(j3);
            String m06 = H.m0(sb5.toString());
            if (TextUtils.isEmpty(m06)) {
                T t16 = this.mData;
                if (((BusinessFeedData) t16).cellMallInfo != null && ((BusinessFeedData) t16).cellMallInfo.cellSweetVip != null && !TextUtils.isEmpty(((BusinessFeedData) t16).cellMallInfo.cellSweetVip.iconPicUrl)) {
                    m06 = ((BusinessFeedData) this.mData).cellMallInfo.cellSweetVip.iconPicUrl;
                } else {
                    if (TextUtils.isEmpty(P)) {
                        String config = QzoneConfig.instance.getConfig("QZoneSetting", "sweetIconRUL", "https://qzonestyle.gtimg.cn/aoi/sola/20170905110724_aew14oIQKq.png");
                        Intrinsics.checkNotNullExpressionValue(config, "instance.getConfig(\n    \u2026URL\n                    )");
                        P = config;
                    }
                    m06 = P;
                }
            }
            if (m06 != null) {
                if ((m06.length() > 0 ? m06 : null) != null) {
                    FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(m06).l(VasDynamicDrawableCache.INSTANCE).a();
                    ImageView imageView2 = this.mLoveDiamondPicView;
                    if (imageView2 != null) {
                        imageView2.setImageDrawable(a16);
                    }
                    a16.c0(new Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit>() { // from class: com.qzone.reborn.message.section.QZOldStylePassiveMsgVipSection$initLoveDiamond$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
                            invoke2(dVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
                            Object obj;
                            Object obj2;
                            CellFeedCommInfo feedCommInfo;
                            obj = ((Section) QZOldStylePassiveMsgVipSection.this).mData;
                            if (obj == null) {
                                feedCommInfo = null;
                            } else {
                                obj2 = ((Section) QZOldStylePassiveMsgVipSection.this).mData;
                                feedCommInfo = ((BusinessFeedData) obj2).getFeedCommInfo();
                            }
                            if (feedCommInfo != null) {
                                com.qzone.adapter.feedcomponent.i.H().d2(feedCommInfo.feedsType);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        ImageView imageView3 = this.mLoveDiamondPicView;
        if (imageView3 == null) {
            return;
        }
        imageView3.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K() {
        QQUnionIconInfo qQUnionIconInfo;
        if (!(!((BusinessFeedData) this.mData).getFeedCommInfo().isBizRecomFeeds() && (((BusinessFeedData) this.mData).isQQUnionVip() || ((BusinessFeedData) this.mData).isQQNewVip()))) {
            G();
            return;
        }
        if (((BusinessFeedData) this.mData).isQQNewVip()) {
            qQUnionIconInfo = com.qzone.adapter.feedcomponent.i.H().w0(-1, QQUnionIconInfo.convertToQQUnionIconMap(((BusinessFeedData) this.mData).cellMallInfo.cellQQNewVip.qqNewVipIconMap));
        } else if (((BusinessFeedData) this.mData).isQQUnionVip()) {
            com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
            T t16 = this.mData;
            qQUnionIconInfo = H.w0(((BusinessFeedData) t16).cellMallInfo.cellQQUionVip.iLevel, QQUnionIconInfo.convertToQQUnionIconMap(((BusinessFeedData) t16).cellMallInfo.cellQQUionVip.qqUnionIconMap));
        } else {
            qQUnionIconInfo = null;
        }
        if (qQUnionIconInfo != null && !TextUtils.isEmpty(qQUnionIconInfo.mIconUrl)) {
            String unionVipZipUrl = qQUnionIconInfo.mIconUrl;
            String urls = QQUnionIconInfo.getCarouselUrls(qQUnionIconInfo);
            if (!TextUtils.isEmpty(urls)) {
                Intrinsics.checkNotNullExpressionValue(urls, "urls");
                Q(urls);
            } else {
                String tenYearsIdString = QQUnionIconInfo.getTenYellowId(qQUnionIconInfo);
                RFWLog.d(M, RFWLog.USR, "vip icon url: " + unionVipZipUrl);
                if (!Intrinsics.areEqual(this.mLastUnionVipUrl, unionVipZipUrl)) {
                    if (!TextUtils.isEmpty(tenYearsIdString)) {
                        Intrinsics.checkNotNullExpressionValue(tenYearsIdString, "tenYearsIdString");
                        Intrinsics.checkNotNullExpressionValue(unionVipZipUrl, "unionVipZipUrl");
                        S(tenYearsIdString, unionVipZipUrl, qQUnionIconInfo.mIconHeight);
                    } else {
                        Intrinsics.checkNotNullExpressionValue(unionVipZipUrl, "unionVipZipUrl");
                        R(unionVipZipUrl);
                    }
                    this.mLastUnionVipUrl = unionVipZipUrl;
                }
            }
            if (qQUnionIconInfo.mIconWidth > 0 && qQUnionIconInfo.mIconHeight > 0) {
                ImageView imageView = this.mQQUnionVipAnimView;
                ViewGroup.LayoutParams layoutParams = imageView != null ? imageView.getLayoutParams() : null;
                if (layoutParams != null) {
                    layoutParams.width = ViewUtils.dpToPx(qQUnionIconInfo.mIconWidth / 2);
                }
                if (layoutParams != null) {
                    layoutParams.height = ViewUtils.dpToPx(qQUnionIconInfo.mIconHeight / 2);
                }
            }
            FrameLayout frameLayout = this.mYellowDiamondContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            ImageView imageView2 = this.mYellowDiamondStaticPicView;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            ImageView imageView3 = this.mYellowDiamondAnimView;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            ImageView imageView4 = this.mQQUnionVipAnimView;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
            ImageView imageView5 = this.mQQUnionVipAnimView;
            if (imageView5 != null) {
                imageView5.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            ImageView imageView6 = this.mQQUnionVipAnimView;
            if (imageView6 == null) {
                return;
            }
            imageView6.setContentDescription("\u94ed\u724c");
            return;
        }
        G();
    }

    private final void L(User user) {
        if (user.isCanShowStarVip()) {
            Drawable D0 = com.qzone.adapter.feedcomponent.i.H().D0(user, new b());
            if (D0 != null) {
                ImageView imageView = this.mStarVipIcon;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                ImageView imageView2 = this.mStarVipIcon;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(D0);
                }
                com.qzone.adapter.feedcomponent.i.H().h2();
                return;
            }
            ImageView imageView3 = this.mStarVipIcon;
            if (imageView3 == null) {
                return;
            }
            imageView3.setVisibility(8);
            return;
        }
        ImageView imageView4 = this.mStarVipIcon;
        if (imageView4 == null) {
            return;
        }
        imageView4.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void N(User user) {
        int i3 = user.vip;
        boolean z16 = user.isCustomDiamond;
        if (!z16 && i3 == 2) {
            if (!TextUtils.isEmpty(user.yellowDiamondUrl)) {
                com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(user.yellowDiamondUrl).setTargetView(this.mYellowDiamondAnimView));
            } else {
                ImageView imageView = this.mYellowDiamondAnimView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            }
        } else {
            ImageView imageView2 = this.mYellowDiamondAnimView;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        }
        Drawable M0 = com.qzone.adapter.feedcomponent.i.H().M0(user, null);
        if (M0 != null) {
            com.qzone.adapter.feedcomponent.i.H().r2((BusinessFeedData) this.mData);
            ImageView imageView3 = this.mYellowDiamondStaticPicView;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            ImageView imageView4 = this.mYellowDiamondStaticPicView;
            if (imageView4 != null) {
                imageView4.setImageDrawable(M0);
            }
            ImageView imageView5 = this.mYellowDiamondStaticPicView;
            if (imageView5 != null) {
                imageView5.setScaleType(ImageView.ScaleType.MATRIX);
            }
            if (!z16 && i3 == 2 && (M0 instanceof m15.a)) {
                m15.a aVar = (m15.a) M0;
                aVar.b();
                aVar.c();
                ImageView imageView6 = this.mYellowDiamondAnimView;
                if (imageView6 != null) {
                    imageView6.getLayoutParams();
                }
                T t16 = this.mData;
                if (t16 != 0 && ((BusinessFeedData) t16).getCellUserInfo().getLuckyMoneyPics() != null && ((BusinessFeedData) this.mData).getCellUserInfo().getLuckyMoneyPics().size() > 0) {
                    ImageView imageView7 = this.mYellowDiamondAnimView;
                    if (imageView7 != null) {
                        imageView7.setVisibility(0);
                    }
                } else {
                    ImageView imageView8 = this.mYellowDiamondAnimView;
                    if (imageView8 != null) {
                        imageView8.setVisibility(0);
                    }
                }
            }
            ImageView imageView9 = this.mYellowDiamondStaticPicView;
            if (imageView9 == null) {
                return;
            }
            imageView9.setContentDescription("vip" + user.vipLevel);
            return;
        }
        ImageView imageView10 = this.mYellowDiamondAnimView;
        if (imageView10 != null) {
            imageView10.setVisibility(8);
        }
        FrameLayout frameLayout = this.mYellowDiamondContainer;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void P(QZOldStylePassiveMsgVipSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view.getId() == R.id.nd8) {
            com.qzone.adapter.feedcomponent.i.H().q(view.getContext(), (BusinessFeedData) this$0.mData);
        } else if (view.getId() == R.id.f162928nd3) {
            com.qzone.adapter.feedcomponent.i.H().p(view.getContext());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Q(String urls) {
        Unit unit;
        Drawable drawable;
        if (TextUtils.isEmpty(urls)) {
            return;
        }
        IVipFrameDrawable iVipFrameDrawable = this.mLV10Animation;
        if (iVipFrameDrawable == null || (drawable = iVipFrameDrawable.getDrawable()) == null) {
            unit = null;
        } else {
            T(drawable);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ((IVipIconUtils) QRoute.api(IVipIconUtils.class)).getQzoneNamePlateDrawable(urls, new Function1<IVipFrameDrawable, Unit>() { // from class: com.qzone.reborn.message.section.QZOldStylePassiveMsgVipSection$playLVTenNamePlate$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IVipFrameDrawable iVipFrameDrawable2) {
                    invoke2(iVipFrameDrawable2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(IVipFrameDrawable iVipFrameDrawable2) {
                    if (iVipFrameDrawable2 == null) {
                        return;
                    }
                    Drawable drawable2 = iVipFrameDrawable2.getDrawable();
                    if (drawable2.getIntrinsicHeight() <= 0 || drawable2.getIntrinsicWidth() <= 0) {
                        return;
                    }
                    QZOldStylePassiveMsgVipSection.this.mLV10Animation = iVipFrameDrawable2;
                    QZOldStylePassiveMsgVipSection.this.T(drawable2);
                }
            });
        }
    }

    private final void R(String unionVipZipUrl) {
        if (!TextUtils.isEmpty(unionVipZipUrl) && (this.mQQUnionVipAnimation == null || !Intrinsics.areEqual(unionVipZipUrl, ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getAnimationResZipUrl(this.mQQUnionVipAnimation)))) {
            if (this.mQQUnionVipAnimation == null) {
                this.mQQUnionVipAnimation = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
            }
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.mQQUnionVipAnimation, unionVipZipUrl, 10);
        }
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.mQQUnionVipAnimation, N);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(this.mQQUnionVipAnimation);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.mQQUnionVipAnimation, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.mQQUnionVipAnimation, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.mQQUnionVipAnimation);
        ImageView imageView = this.mQQUnionVipAnimView;
        if (imageView != null) {
            imageView.setImageDrawable(this.mQQUnionVipAnimation);
        }
    }

    private final void S(String tenYearsIdString, String unionVipZipUrl, int iconHeight) {
        List emptyList;
        if (TextUtils.isEmpty(tenYearsIdString)) {
            return;
        }
        List<String> split = new Regex("#").split(tenYearsIdString, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        Drawable qzoneLetterSwitchIcon = ((IVipIconUtilsForQzone) QRoute.api(IVipIconUtilsForQzone.class)).getQzoneLetterSwitchIcon(unionVipZipUrl, Arrays.asList(Arrays.copyOf(strArr, strArr.length)), "bg.png", "fc.png", ViewUtils.dpToPx(iconHeight));
        ImageView imageView = this.mQQUnionVipAnimView;
        if (imageView != null) {
            imageView.setImageDrawable(qzoneLetterSwitchIcon);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(Drawable drawable) {
        ImageView imageView = this.mQQUnionVipAnimView;
        ViewGroup.LayoutParams layoutParams = imageView != null ? imageView.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = (drawable.getIntrinsicWidth() * ViewUtils.dip2px(20.0f)) / drawable.getIntrinsicHeight();
        }
        if (layoutParams != null) {
            layoutParams.height = ViewUtils.dip2px(20.0f);
        }
        ImageView imageView2 = this.mQQUnionVipAnimView;
        if (imageView2 != null) {
            imageView2.setLayoutParams(layoutParams);
        }
        ImageView imageView3 = this.mQQUnionVipAnimView;
        if (imageView3 != null) {
            imageView3.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.mFeedSkinBg = (ImageView) containerView.findViewById(R.id.mxo);
        this.mAvatarDecoration = (ImageView) containerView.findViewById(R.id.ncc);
        this.mStarVipIcon = (ImageView) containerView.findViewById(R.id.f162928nd3);
        FrameLayout frameLayout = (FrameLayout) containerView.findViewById(R.id.nd8);
        this.mYellowDiamondContainer = frameLayout;
        this.mYellowDiamondStaticPicView = frameLayout != null ? (ImageView) frameLayout.findViewById(R.id.nd9) : null;
        FrameLayout frameLayout2 = this.mYellowDiamondContainer;
        this.mYellowDiamondAnimView = frameLayout2 != null ? (ImageView) frameLayout2.findViewById(R.id.nd7) : null;
        this.mLoveDiamondPicView = (ImageView) containerView.findViewById(R.id.f162926nd1);
        FrameLayout frameLayout3 = this.mYellowDiamondContainer;
        this.mQQUnionVipAnimView = frameLayout3 != null ? (ImageView) frameLayout3.findViewById(R.id.nd5) : null;
        FrameLayout frameLayout4 = this.mYellowDiamondContainer;
        if (frameLayout4 != null) {
            frameLayout4.setOnClickListener(this.onClickListener);
        }
        ImageView imageView = this.mLoveDiamondPicView;
        if (imageView != null) {
            imageView.setOnClickListener(this.onClickListener);
        }
        ImageView imageView2 = this.mFeedSkinBg;
        if (imageView2 == null) {
            return;
        }
        imageView2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nog};
    }

    private final void M(User user) {
        if (!user.isEnableShowIcon(1L)) {
            FrameLayout frameLayout = this.mYellowDiamondContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        } else {
            FrameLayout frameLayout2 = this.mYellowDiamondContainer;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            N(user);
        }
        K();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindData(BusinessFeedData data, int position, List<Object> payload) {
        if (data != null) {
            if (data.isFakeFeed()) {
                ImageView imageView = this.mStarVipIcon;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                FrameLayout frameLayout = this.mYellowDiamondContainer;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                ImageView imageView2 = this.mAvatarDecoration;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                ImageView imageView3 = this.mFeedSkinBg;
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
                ImageView imageView4 = this.mLoveDiamondPicView;
                if (imageView4 == null) {
                    return;
                }
                imageView4.setVisibility(8);
                return;
            }
            User user = data.getUser();
            Intrinsics.checkNotNullExpressionValue(user, "feedData.getUser()");
            H(user);
            L(user);
            M(user);
            J(user);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/message/section/QZOldStylePassiveMsgVipSection$b", "Ls8/j;", "", "onFailed", "Landroid/graphics/drawable/Drawable;", "drawable", "onLoaded", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements s8.j {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QZOldStylePassiveMsgVipSection this$0, Drawable drawable) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(drawable, "$drawable");
            ImageView imageView = this$0.mStarVipIcon;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }

        @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
        public void onLoaded(final Drawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            ImageView imageView = QZOldStylePassiveMsgVipSection.this.mStarVipIcon;
            if (imageView != null) {
                final QZOldStylePassiveMsgVipSection qZOldStylePassiveMsgVipSection = QZOldStylePassiveMsgVipSection.this;
                imageView.post(new Runnable() { // from class: com.qzone.reborn.message.section.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZOldStylePassiveMsgVipSection.b.b(QZOldStylePassiveMsgVipSection.this, drawable);
                    }
                });
            }
        }

        @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
        public void onFailed() {
        }
    }
}
