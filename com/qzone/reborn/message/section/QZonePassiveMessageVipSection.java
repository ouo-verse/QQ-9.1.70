package com.qzone.reborn.message.section;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import bl.CommonNoticeBean;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellMallInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.presenter.ca;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ui.IVipFrameDrawable;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.mobileqq.vip.api.IVipIconUtilsForQzone;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J \u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J*\u0010!\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u00132\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0014R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0018\u00100\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/qzone/reborn/message/section/QZonePassiveMessageVipSection;", "Lcom/qzone/reborn/message/section/y;", "", "K", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "J", "M", "H", "L", "", "unionVipZipUrl", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, CoverDBCacheData.URLS, "P", "Landroid/graphics/drawable/Drawable;", "drawable", ExifInterface.LATITUDE_SOUTH, "tenYearsIdString", "", "iconHeight", BdhLogUtil.LogTag.Tag_Req, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lbl/a;", "data", "position", "", "", "payload", "N", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "mYellowDiamondContainer", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mYellowDiamondStaticPicView", BdhLogUtil.LogTag.Tag_Conn, "mYellowDiamondAnimView", "D", "mQQUnionVipAnimView", "E", "Landroid/graphics/drawable/Drawable;", "mQQUnionVipAnimation", "Lcom/tencent/mobileqq/vas/ui/IVipFrameDrawable;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/vas/ui/IVipFrameDrawable;", "mLV10Animation", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePassiveMessageVipSection extends y {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mYellowDiamondAnimView;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mQQUnionVipAnimView;

    /* renamed from: E, reason: from kotlin metadata */
    private Drawable mQQUnionVipAnimation;

    /* renamed from: F, reason: from kotlin metadata */
    private IVipFrameDrawable mLV10Animation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mYellowDiamondContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mYellowDiamondStaticPicView;

    private final void H(BusinessFeedData feedData) {
        QQUnionIconInfo qQUnionIconInfo;
        if (!(!feedData.getFeedCommInfo().isBizRecomFeeds() && (feedData.isQQUnionVip() || feedData.isQQNewVip()))) {
            L();
            return;
        }
        ImageView imageView = null;
        if (feedData.isQQNewVip()) {
            qQUnionIconInfo = com.qzone.adapter.feedcomponent.i.H().w0(-1, QQUnionIconInfo.convertToQQUnionIconMap(feedData.cellMallInfo.cellQQNewVip.qqNewVipIconMap));
        } else if (feedData.isQQUnionVip()) {
            com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
            CellMallInfo.CellQQUionVip cellQQUionVip = feedData.cellMallInfo.cellQQUionVip;
            qQUnionIconInfo = H.w0(cellQQUionVip.iLevel, QQUnionIconInfo.convertToQQUnionIconMap(cellQQUionVip.qqUnionIconMap));
        } else {
            qQUnionIconInfo = null;
        }
        if (qQUnionIconInfo != null && !TextUtils.isEmpty(qQUnionIconInfo.mIconUrl)) {
            String unionVipZipUrl = qQUnionIconInfo.mIconUrl;
            String urls = QQUnionIconInfo.getCarouselUrls(qQUnionIconInfo);
            if (!TextUtils.isEmpty(urls)) {
                Intrinsics.checkNotNullExpressionValue(urls, "urls");
                P(urls);
            } else {
                String tenYearsIdString = QQUnionIconInfo.getTenYellowId(qQUnionIconInfo);
                if (!TextUtils.isEmpty(tenYearsIdString)) {
                    Intrinsics.checkNotNullExpressionValue(tenYearsIdString, "tenYearsIdString");
                    Intrinsics.checkNotNullExpressionValue(unionVipZipUrl, "unionVipZipUrl");
                    R(tenYearsIdString, unionVipZipUrl, qQUnionIconInfo.mIconHeight);
                } else {
                    Intrinsics.checkNotNullExpressionValue(unionVipZipUrl, "unionVipZipUrl");
                    Q(unionVipZipUrl);
                }
            }
            if (qQUnionIconInfo.mIconWidth > 0 && qQUnionIconInfo.mIconHeight > 0) {
                ImageView imageView2 = this.mQQUnionVipAnimView;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mQQUnionVipAnimView");
                    imageView2 = null;
                }
                ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
                layoutParams.width = ViewUtils.dpToPx(qQUnionIconInfo.mIconWidth / 2);
                layoutParams.height = ViewUtils.dpToPx(qQUnionIconInfo.mIconHeight / 2);
            }
            FrameLayout frameLayout = this.mYellowDiamondContainer;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondContainer");
                frameLayout = null;
            }
            frameLayout.setVisibility(0);
            ImageView imageView3 = this.mYellowDiamondStaticPicView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondStaticPicView");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
            ImageView imageView4 = this.mYellowDiamondAnimView;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondAnimView");
                imageView4 = null;
            }
            imageView4.setVisibility(8);
            ImageView imageView5 = this.mQQUnionVipAnimView;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mQQUnionVipAnimView");
                imageView5 = null;
            }
            imageView5.setVisibility(0);
            ImageView imageView6 = this.mQQUnionVipAnimView;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mQQUnionVipAnimView");
                imageView6 = null;
            }
            imageView6.setScaleType(ImageView.ScaleType.FIT_XY);
            ImageView imageView7 = this.mQQUnionVipAnimView;
            if (imageView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mQQUnionVipAnimView");
            } else {
                imageView = imageView7;
            }
            imageView.setContentDescription("\u94ed\u724c");
            return;
        }
        L();
    }

    private final void J(BusinessFeedData feedData) {
        FrameLayout frameLayout = null;
        if (!feedData.getUser().isEnableShowIcon(1L)) {
            FrameLayout frameLayout2 = this.mYellowDiamondContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondContainer");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.setVisibility(8);
            return;
        }
        FrameLayout frameLayout3 = this.mYellowDiamondContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondContainer");
        } else {
            frameLayout = frameLayout3;
        }
        frameLayout.setVisibility(0);
        M(feedData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K() {
        com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
        FrameLayout frameLayout = this.mYellowDiamondContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondContainer");
            frameLayout = null;
        }
        Context context = frameLayout.getContext();
        Object obj = ((CommonNoticeBean) this.mData).getNotice().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
        H.q(context, (BusinessFeedData) (obj instanceof BusinessFeedData ? obj : null));
    }

    private final void L() {
        ImageView imageView = this.mQQUnionVipAnimView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQQUnionVipAnimView");
            imageView = null;
        }
        imageView.setImageDrawable(null);
        ImageView imageView3 = this.mQQUnionVipAnimView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQQUnionVipAnimView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setVisibility(8);
    }

    private final void M(BusinessFeedData feedData) {
        User user = feedData.getUser();
        int i3 = user.vip;
        boolean z16 = user.isCustomDiamond;
        View view = null;
        if (!z16 && i3 == 2) {
            if (!TextUtils.isEmpty(user.yellowDiamondUrl)) {
                com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
                Option url = Option.obtain().setUrl(user.yellowDiamondUrl);
                ImageView imageView = this.mYellowDiamondAnimView;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondAnimView");
                    imageView = null;
                }
                a16.h(url.setTargetView(imageView));
            } else {
                ImageView imageView2 = this.mYellowDiamondAnimView;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondAnimView");
                    imageView2 = null;
                }
                imageView2.setVisibility(8);
            }
        } else {
            ImageView imageView3 = this.mYellowDiamondAnimView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondAnimView");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
        }
        Drawable M0 = com.qzone.adapter.feedcomponent.i.H().M0(user, null);
        if (M0 != null) {
            com.qzone.adapter.feedcomponent.i.H().r2(feedData);
            ImageView imageView4 = this.mYellowDiamondStaticPicView;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondStaticPicView");
                imageView4 = null;
            }
            imageView4.setVisibility(0);
            ImageView imageView5 = this.mYellowDiamondStaticPicView;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondStaticPicView");
                imageView5 = null;
            }
            imageView5.setImageDrawable(M0);
            ImageView imageView6 = this.mYellowDiamondStaticPicView;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondStaticPicView");
                imageView6 = null;
            }
            imageView6.setScaleType(ImageView.ScaleType.MATRIX);
            if (!z16 && i3 == 2 && (M0 instanceof m15.a)) {
                m15.a aVar = (m15.a) M0;
                aVar.b();
                aVar.c();
                ImageView imageView7 = this.mYellowDiamondAnimView;
                if (imageView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondAnimView");
                    imageView7 = null;
                }
                Intrinsics.checkNotNullExpressionValue(imageView7.getLayoutParams(), "mYellowDiamondAnimView.getLayoutParams()");
                if (feedData.getCellUserInfo().getLuckyMoneyPics() != null && feedData.getCellUserInfo().getLuckyMoneyPics().size() > 0) {
                    ImageView imageView8 = this.mYellowDiamondAnimView;
                    if (imageView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondAnimView");
                        imageView8 = null;
                    }
                    imageView8.setVisibility(0);
                } else {
                    ImageView imageView9 = this.mYellowDiamondAnimView;
                    if (imageView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondAnimView");
                        imageView9 = null;
                    }
                    imageView9.setVisibility(0);
                }
            }
            ImageView imageView10 = this.mYellowDiamondStaticPicView;
            if (imageView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondStaticPicView");
            } else {
                view = imageView10;
            }
            view.setContentDescription("vip" + user.vipLevel);
            return;
        }
        ImageView imageView11 = this.mYellowDiamondAnimView;
        if (imageView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondAnimView");
            imageView11 = null;
        }
        imageView11.setVisibility(8);
        FrameLayout frameLayout = this.mYellowDiamondContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondContainer");
        } else {
            view = frameLayout;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(QZonePassiveMessageVipSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void P(String urls) {
        if (TextUtils.isEmpty(urls)) {
            return;
        }
        IVipFrameDrawable iVipFrameDrawable = this.mLV10Animation;
        if (iVipFrameDrawable != null) {
            S(iVipFrameDrawable != null ? iVipFrameDrawable.getDrawable() : null);
        } else {
            ((IVipIconUtils) QRoute.api(IVipIconUtils.class)).getQzoneNamePlateDrawable(urls, new Function1<IVipFrameDrawable, Unit>() { // from class: com.qzone.reborn.message.section.QZonePassiveMessageVipSection$playLVTenNamePlate$1
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
                    Drawable drawable = iVipFrameDrawable2.getDrawable();
                    if (drawable.getIntrinsicHeight() <= 0 || drawable.getIntrinsicWidth() <= 0) {
                        return;
                    }
                    QZonePassiveMessageVipSection.this.mLV10Animation = iVipFrameDrawable2;
                    QZonePassiveMessageVipSection.this.S(drawable);
                }
            });
        }
    }

    private final void Q(String unionVipZipUrl) {
        if (!TextUtils.isEmpty(unionVipZipUrl) && (this.mQQUnionVipAnimation == null || !Intrinsics.areEqual(unionVipZipUrl, ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getAnimationResZipUrl(this.mQQUnionVipAnimation)))) {
            if (this.mQQUnionVipAnimation == null) {
                this.mQQUnionVipAnimation = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
            }
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.mQQUnionVipAnimation, unionVipZipUrl, 10);
        }
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.mQQUnionVipAnimation, ca.R);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(this.mQQUnionVipAnimation);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.mQQUnionVipAnimation, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.mQQUnionVipAnimation, true);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.mQQUnionVipAnimation);
        ImageView imageView = this.mQQUnionVipAnimView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQQUnionVipAnimView");
            imageView = null;
        }
        imageView.setImageDrawable(this.mQQUnionVipAnimation);
    }

    private final void R(String tenYearsIdString, String unionVipZipUrl, int iconHeight) {
        if (TextUtils.isEmpty(tenYearsIdString)) {
            return;
        }
        Drawable qzoneLetterSwitchIcon = ((IVipIconUtilsForQzone) QRoute.api(IVipIconUtilsForQzone.class)).getQzoneLetterSwitchIcon(unionVipZipUrl, new Regex("#").split(tenYearsIdString, 0), "bg.png", "fc.png", ViewUtils.dpToPx(iconHeight));
        ImageView imageView = this.mQQUnionVipAnimView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQQUnionVipAnimView");
            imageView = null;
        }
        imageView.setImageDrawable(qzoneLetterSwitchIcon);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.nd8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ser_yellow_vip_container)");
        this.mYellowDiamondContainer = (FrameLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.nd9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026er_yellow_vip_static_pic)");
        this.mYellowDiamondStaticPicView = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.nd7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026one_user_yellow_vip_anim)");
        this.mYellowDiamondAnimView = (ImageView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.nd5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026zone_user_union_vip_anim)");
        this.mQQUnionVipAnimView = (ImageView) findViewById4;
        FrameLayout frameLayout = this.mYellowDiamondContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondContainer");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.section.at
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZonePassiveMessageVipSection.O(QZonePassiveMessageVipSection.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n8q};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonNoticeBean data, int position, List<Object> payload) {
        bl.f notice;
        if (data == null || (notice = data.getNotice()) == null) {
            return;
        }
        Object obj = notice.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
        FrameLayout frameLayout = null;
        if (!(obj instanceof BusinessFeedData)) {
            obj = null;
        }
        BusinessFeedData businessFeedData = (BusinessFeedData) obj;
        if (businessFeedData != null) {
            if (businessFeedData.isFakeFeed()) {
                FrameLayout frameLayout2 = this.mYellowDiamondContainer;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondContainer");
                } else {
                    frameLayout = frameLayout2;
                }
                frameLayout.setVisibility(8);
                return;
            }
            J(businessFeedData);
            H(businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        ImageView imageView = this.mQQUnionVipAnimView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQQUnionVipAnimView");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = (drawable.getIntrinsicWidth() * ViewUtils.dip2px(20.0f)) / drawable.getIntrinsicHeight();
        layoutParams.height = ViewUtils.dip2px(20.0f);
        ImageView imageView3 = this.mQQUnionVipAnimView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQQUnionVipAnimView");
            imageView3 = null;
        }
        imageView3.setLayoutParams(layoutParams);
        ImageView imageView4 = this.mQQUnionVipAnimView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQQUnionVipAnimView");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setImageDrawable(drawable);
    }
}
