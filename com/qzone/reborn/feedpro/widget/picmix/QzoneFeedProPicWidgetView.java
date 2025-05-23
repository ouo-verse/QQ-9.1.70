package com.qzone.reborn.feedpro.widget.picmix;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.utils.aq;
import com.qzone.reborn.util.m;
import com.qzone.reborn.util.r;
import com.qzone.util.l;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedDataUtilKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.libra.LoadState;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.extension.gif.GifDrawable;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00017B\u0013\b\u0016\u0012\b\b\u0001\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100B\u001f\b\u0016\u0012\b\b\u0001\u0010.\u001a\u00020-\u0012\n\b\u0001\u00102\u001a\u0004\u0018\u000101\u00a2\u0006\u0004\b/\u00103B'\b\u0016\u0012\b\b\u0001\u0010.\u001a\u00020-\u0012\n\b\u0001\u00102\u001a\u0004\u0018\u000101\u0012\u0006\u00104\u001a\u00020\u0017\u00a2\u0006\u0004\b/\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\"\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0014J\u0006\u0010\u001a\u001a\u00020\u0004J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0017H\u0014J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00068"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicWidgetView;", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProMixBaseWidgetView;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonImage;", "picInfo", "", "I0", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonPicUrl;", "picUrl", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "C0", "F0", "commonImage", "K0", "", "type", "H0", "Landroid/widget/TextView;", "D0", "", "G0", "", "getLayoutId", "getLogTag", "E0", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", QAdVrReportParams.ParamKey.MEDIA, com.tencent.luggage.wxa.c8.c.G, "o0", "Landroid/view/ViewGroup$LayoutParams;", "rootViewParams", "m0", "Landroid/widget/ImageView;", "q0", "E", "Landroid/widget/ImageView;", "mImageView", UserInfo.SEX_FEMALE, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "mMedia", "G", "Landroid/widget/TextView;", "mTvPicTypeText", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProPicWidgetView extends QzoneFeedProMixBaseWidgetView {

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mImageView;

    /* renamed from: F, reason: from kotlin metadata */
    private CommonMedia mMedia;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mTvPicTypeText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProPicWidgetView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C0(CommonPicUrl picUrl, LoadState state, Option option) {
        int i3;
        ViewGroup.LayoutParams layoutParams;
        CommonCellMedia cellMedia;
        List<CommonMedia> mediaItems;
        if (getMFeedData() != null) {
            CommonFeed mFeedData = getMFeedData();
            if ((mFeedData != null ? mFeedData.getCellMedia() : null) == null || picUrl == null || !state.isFinishSuccess()) {
                return;
            }
            CommonFeed mFeedData2 = getMFeedData();
            int i16 = 0;
            if (((mFeedData2 == null || (cellMedia = mFeedData2.getCellMedia()) == null || (mediaItems = cellMedia.getMediaItems()) == null || mediaItems.size() != 1) ? false : true) == true) {
                if (picUrl.getWidth() <= 0 || picUrl.getHeight() <= 0) {
                    Context context = getContext();
                    aq aqVar = aq.f54314a;
                    Pair<Integer, Integer> c16 = com.qzone.reborn.feedx.widget.picmixvideo.a.c(context, aqVar.f(CommonFeedExtKt.getFeedUniqueKey(getMFeedData()), picUrl));
                    Integer num = c16 != null ? (Integer) c16.first : null;
                    if ((num == null ? 0 : num.intValue()) > 0) {
                        Integer num2 = c16 != null ? (Integer) c16.second : null;
                        if ((num2 == null ? 0 : num2.intValue()) > 0) {
                            return;
                        }
                    }
                    if (option.getResultBitMap() != null) {
                        i16 = option.getResultBitMap().getWidth();
                        i3 = option.getResultBitMap().getHeight();
                    } else if (option.getAnimatable() instanceof GifDrawable) {
                        Animatable animatable = option.getAnimatable();
                        Intrinsics.checkNotNull(animatable, "null cannot be cast to non-null type com.tencent.libra.extension.gif.GifDrawable");
                        int intrinsicWidth = ((GifDrawable) animatable).getIntrinsicWidth();
                        Animatable animatable2 = option.getAnimatable();
                        Intrinsics.checkNotNull(animatable2, "null cannot be cast to non-null type com.tencent.libra.extension.gif.GifDrawable");
                        i16 = intrinsicWidth;
                        i3 = ((GifDrawable) animatable2).getIntrinsicHeight();
                    } else {
                        i3 = 0;
                    }
                    if (i16 == 0 && i3 == 0) {
                        CommonFeed mFeedData3 = getMFeedData();
                        String feedContentSummary = mFeedData3 != null ? CommonFeedDataUtilKt.getFeedContentSummary(mFeedData3) : null;
                        CommonFeed mFeedData4 = getMFeedData();
                        QLog.e("QzoneFeedProPicWidgetView", 1, "adjustSinglePicNoHW | bitmapWidth == 0 && bitmapHeight == 0 | text = " + feedContentSummary + " | feedskey = " + (mFeedData4 != null ? CommonFeedExtKt.getFeedUniqueKey(mFeedData4) : null));
                        return;
                    }
                    com.qzone.reborn.feedx.widget.picmixvideo.a.a(getContext(), aqVar.f(CommonFeedExtKt.getFeedUniqueKey(getMFeedData()), picUrl), i16, i3);
                    ViewGroup.LayoutParams layoutParams2 = v0().getLayoutParams();
                    if (layoutParams2 != null) {
                        Context context2 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        aqVar.a(context2, CommonFeedExtKt.getFeedUniqueKey(getMFeedData()), layoutParams2, picUrl, r0());
                        v0().setLayoutParams(layoutParams2);
                        ImageView imageView = this.mImageView;
                        if (imageView != null && (layoutParams = imageView.getLayoutParams()) != null) {
                            Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
                            layoutParams.width = layoutParams2.width;
                            layoutParams.height = layoutParams2.height;
                            ImageView imageView2 = this.mImageView;
                            if (imageView2 != null) {
                                imageView2.setLayoutParams(layoutParams);
                            }
                        }
                        F0(picUrl);
                        String feedUniqueKey = CommonFeedExtKt.getFeedUniqueKey(getMFeedData());
                        int mFeedPosition = getMFeedPosition();
                        String url = picUrl.getUrl();
                        int i17 = layoutParams2.width;
                        int i18 = layoutParams2.height;
                        CommonFeed mFeedData5 = getMFeedData();
                        QLog.i("QzoneFeedProPicWidgetView", 1, "adjustSinglePicNoHW | feedId = " + feedUniqueKey + " | pos = " + mFeedPosition + " | url = " + url + " | width = " + i17 + " | height = " + i18 + " | this = " + this + " | mFeedData = " + (mFeedData5 != null ? Integer.valueOf(mFeedData5.hashCode()) : null));
                    }
                }
            }
        }
    }

    private final TextView D0() {
        TextView textView = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388691);
        r rVar = r.f59560a;
        layoutParams.setMargins(rVar.e(6), 0, 0, rVar.e(6));
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(textView.getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
        textView.setGravity(17);
        textView.setTextSize(11.0f);
        textView.setIncludeFontPadding(false);
        textView.setShadowLayer(3.0f, 0.0f, 0.0f, Color.parseColor("#CC000000"));
        return textView;
    }

    private final boolean G0() {
        CommonCellMedia cellMedia;
        CommonFeed mFeedData = getMFeedData();
        if (mFeedData == null || (cellMedia = mFeedData.getCellMedia()) == null) {
            return false;
        }
        return cellMedia.getLongPicsBrowsingMode();
    }

    private final void H0(String type) {
        if (this.mTvPicTypeText == null) {
            TextView D0 = D0();
            addView(D0);
            this.mTvPicTypeText = D0;
        }
        TextView textView = this.mTvPicTypeText;
        if (textView != null) {
            textView.setText(type);
            textView.setVisibility(0);
        }
    }

    private final void I0(CommonImage picInfo) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        CommonCellUserInfo cellUserInfo;
        CommonUser user;
        ViewGroup.LayoutParams layoutParams3;
        final CommonPicUrl e16 = xd.d.e(picInfo);
        if (e16 == null) {
            return;
        }
        Option e17 = com.tencent.mobileqq.qzone.picload.c.e(e16.getUrl());
        e17.setTargetView(this.mImageView);
        ImageView imageView = this.mImageView;
        if (imageView != null && (layoutParams3 = imageView.getLayoutParams()) != null) {
            Intrinsics.checkNotNullExpressionValue(layoutParams3, "layoutParams");
            e17.setRequestWidth(layoutParams3.width);
            e17.setRequestHeight(layoutParams3.height);
        }
        if (!xd.d.i(picInfo)) {
            e17.setGroupKey(new LibraGroupKey(picInfo.getLloc()));
        }
        m mVar = m.f59551a;
        e17.setLoadingDrawable(mVar.b(getContext()));
        e17.setFailDrawable(mVar.a(getContext()));
        if (!ImageUtil.isJpgFile(e16.getUrl())) {
            e17.setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        }
        String d16 = com.tencent.mobileqq.qzone.picload.c.a().d(e17);
        ImageView imageView2 = this.mImageView;
        if ((imageView2 != null ? imageView2.getTag() : null) != null) {
            ImageView imageView3 = this.mImageView;
            if (Intrinsics.areEqual(imageView3 != null ? imageView3.getTag() : null, d16)) {
                QLog.d("QzoneFeedProPicWidgetView", 4, "same url, just return: " + d16);
                return;
            }
        }
        ImageView imageView4 = this.mImageView;
        if (imageView4 != null) {
            imageView4.setTag(com.tencent.mobileqq.qzone.picload.c.a().d(e17));
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Pic bindData  | mFeedPosition = " + getMFeedPosition());
        sb5.append(" | mPicPosition = " + getMPicPosition());
        ImageView imageView5 = this.mImageView;
        sb5.append(" | drawable = " + (imageView5 != null ? imageView5.getDrawable() : null));
        sb5.append(" | seq = " + e17.getSeq());
        CommonFeed mFeedData = getMFeedData();
        sb5.append(" | nick = " + ((mFeedData == null || (cellUserInfo = mFeedData.getCellUserInfo()) == null || (user = cellUserInfo.getUser()) == null) ? null : user.getNick()));
        CommonFeed mFeedData2 = getMFeedData();
        sb5.append(" | text = " + (mFeedData2 != null ? CommonFeedDataUtilKt.getFeedContentSummary(mFeedData2) : null));
        CommonFeed mFeedData3 = getMFeedData();
        sb5.append(" | feedskey = " + (mFeedData3 != null ? CommonFeedExtKt.getFeedUniqueKey(mFeedData3) : null));
        sb5.append(" | url = " + e16.getUrl());
        sb5.append(" | dataWidth = " + e16.getWidth());
        sb5.append(" | dataHeight = " + e16.getHeight());
        ImageView imageView6 = this.mImageView;
        sb5.append(" | picWidth = " + ((imageView6 == null || (layoutParams2 = imageView6.getLayoutParams()) == null) ? null : Integer.valueOf(layoutParams2.width)));
        ImageView imageView7 = this.mImageView;
        sb5.append(" | picHeight = " + ((imageView7 == null || (layoutParams = imageView7.getLayoutParams()) == null) ? null : Integer.valueOf(layoutParams.height)));
        sb5.append(" | this = " + ((Object) sb5));
        CommonFeed mFeedData4 = getMFeedData();
        sb5.append(" | mFeedData = " + (mFeedData4 != null ? Integer.valueOf(mFeedData4.hashCode()) : null));
        Unit unit = Unit.INSTANCE;
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        QLog.d("QzoneFeedProPicWidgetView", 1, sb6);
        com.tencent.mobileqq.qzone.picload.c.a().i(e17, new IPicLoadStateListener() { // from class: com.qzone.reborn.feedpro.widget.picmix.e
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QzoneFeedProPicWidgetView.J0(QzoneFeedProPicWidgetView.this, e16, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(QzoneFeedProPicWidgetView this$0, CommonPicUrl commonPicUrl, LoadState state, Option option) {
        CommonCellMedia cellMedia;
        List<CommonMedia> mediaItems;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (state.isFinishSuccess() && option.getAnimatable() != null) {
            Animatable animatable = option.getAnimatable();
            r01.c cVar = animatable instanceof r01.c ? (r01.c) animatable : null;
            if (cVar != null) {
                cVar.setLoopCount(65535);
            }
            Animatable animatable2 = option.getAnimatable();
            if (animatable2 != null) {
                animatable2.start();
            }
        }
        if (state.isFinishSuccess() && this$0.getMFeedData() != null) {
            CommonFeed mFeedData = this$0.getMFeedData();
            boolean z16 = false;
            if (mFeedData != null && (cellMedia = mFeedData.getCellMedia()) != null && (mediaItems = cellMedia.getMediaItems()) != null && mediaItems.size() == 1) {
                z16 = true;
            }
            if (z16) {
                Intrinsics.checkNotNullExpressionValue(state, "state");
                Intrinsics.checkNotNullExpressionValue(option, "option");
                this$0.C0(commonPicUrl, state, option);
            }
        }
        if (state.isFinishError()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loadImage | state = " + state);
            CommonFeed mFeedData2 = this$0.getMFeedData();
            sb5.append(" | feedskey = " + (mFeedData2 != null ? CommonFeedExtKt.getFeedUniqueKey(mFeedData2) : null));
            sb5.append(" | pos = " + this$0.getMFeedPosition());
            sb5.append(" | url = " + commonPicUrl.getUrl());
            Unit unit = Unit.INSTANCE;
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
            QLog.e("QzoneFeedProPicWidgetView", 1, sb6);
        }
    }

    private final void K0(CommonImage commonImage) {
        if (commonImage.getIsGif()) {
            String a16 = l.a(R.string.rhn);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_feedx_pic_tpye_gif)");
            H0(a16);
        } else if (G0()) {
            String a17 = l.a(R.string.rhp);
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_feedx_pic_tpye_long_pic)");
            H0(a17);
        } else {
            TextView textView = this.mTvPicTypeText;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void E0() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = new RoundCorneredFrameLayout(getContext());
        roundCorneredFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        z0(roundCorneredFrameLayout);
        addView(v0());
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mImageView = imageView;
        v0().addView(this.mImageView);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView
    protected String getLogTag() {
        return "QzoneFeedProPicWidgetView";
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView
    protected void m0(CommonMedia media, ViewGroup.LayoutParams rootViewParams) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        Intrinsics.checkNotNullParameter(media, "media");
        CommonImage image = media.getImage();
        Integer num = null;
        CommonPicUrl e16 = image != null ? xd.d.e(image) : null;
        aq aqVar = aq.f54314a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        aqVar.a(context, CommonFeedExtKt.getFeedUniqueKey(getMFeedData()), rootViewParams, e16, r0());
        ImageView imageView = this.mImageView;
        ViewGroup.LayoutParams layoutParams3 = imageView != null ? imageView.getLayoutParams() : null;
        if (layoutParams3 != null) {
            layoutParams3.width = rootViewParams != null ? rootViewParams.width : -2;
        }
        ImageView imageView2 = this.mImageView;
        ViewGroup.LayoutParams layoutParams4 = imageView2 != null ? imageView2.getLayoutParams() : null;
        if (layoutParams4 != null) {
            layoutParams4.height = rootViewParams != null ? rootViewParams.height : -2;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("adjustItemSingleViewSize | feedId = " + CommonFeedExtKt.getFeedUniqueKey(getMFeedData()));
        sb5.append(" | pos = " + getMFeedPosition());
        sb5.append(" | url = " + (e16 != null ? e16.getUrl() : null));
        sb5.append(" | width = " + (e16 != null ? Integer.valueOf(e16.getWidth()) : null));
        sb5.append(" | height = " + (e16 != null ? Integer.valueOf(e16.getHeight()) : null));
        ImageView imageView3 = this.mImageView;
        sb5.append(" | paramWidth = " + ((imageView3 == null || (layoutParams2 = imageView3.getLayoutParams()) == null) ? null : Integer.valueOf(layoutParams2.width)));
        ImageView imageView4 = this.mImageView;
        if (imageView4 != null && (layoutParams = imageView4.getLayoutParams()) != null) {
            num = Integer.valueOf(layoutParams.height);
        }
        sb5.append(" | paramHeight = " + num);
        Unit unit = Unit.INSTANCE;
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        QLog.i("QzoneFeedProPicWidgetView", 1, sb6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0 */
    public void bindData(CommonMedia media, int pos) {
        Intrinsics.checkNotNullParameter(media, "media");
        super.bindData(media, pos);
        this.mMedia = media;
        CommonImage image = media.getImage();
        if (image != null) {
            I0(image);
            K0(image);
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView
    /* renamed from: q0, reason: from getter */
    public ImageView getMImageView() {
        return this.mImageView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProPicWidgetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProPicWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        E0();
    }

    private final void F0(CommonPicUrl picUrl) {
        ViewGroup.LayoutParams layoutParams;
        if (picUrl == null || this.mImageView == null) {
            return;
        }
        Option obtain = Option.obtain();
        String url = picUrl.getUrl();
        if (url == null) {
            url = "";
        }
        obtain.setUrl(url);
        ImageView imageView = this.mImageView;
        if (imageView != null && (layoutParams = imageView.getLayoutParams()) != null) {
            Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
            obtain.setRequestWidth(layoutParams.width);
            obtain.setRequestHeight(layoutParams.height);
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(obtain);
    }
}
