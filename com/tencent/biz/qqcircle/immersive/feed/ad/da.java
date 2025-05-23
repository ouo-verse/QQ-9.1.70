package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ad.tangram.widget.bubble.GdtBubbleDanmakuLayout;
import com.tencent.ad.tangram.widget.bubble.GdtBubbleDanmakuParams;
import com.tencent.ad.tangram.widget.bubble.GdtLogProxy;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.util.GdtAntiSpamReportHelper;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;
import tencent.gdt.qq_common;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 m2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001nB\u0007\u00a2\u0006\u0004\bk\u0010lJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00130\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020\bH\u0002J\b\u0010 \u001a\u00020\bH\u0002J\b\u0010!\u001a\u00020\bH\u0002J\b\u0010\"\u001a\u00020\bH\u0002J\b\u0010#\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020\bH\u0002J\u0012\u0010(\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002J\u0012\u0010*\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010&H\u0002J\u001a\u0010,\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010&2\u0006\u0010+\u001a\u00020\u0006H\u0002R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u00101R\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010HR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010DR\u0016\u0010`\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010NR\u0018\u0010c\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010bR\u0018\u0010f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010.R\u0016\u0010j\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010N\u00a8\u0006o"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/da;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "", "w0", "data", "", "position", "", "p1", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedUnSelected", "onFeedSelected", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "event", "C0", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "getEventClass", "simpleBaseEvent", "onReceiveEvent", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSFeedAdCardAnimEvent;", "k1", "q1", "t1", "w1", "B1", "C1", "y1", ICustomDataEditor.STRING_PARAM_1, "l1", "r1", ICustomDataEditor.NUMBER_PARAM_1, "o1", "m1", "Landroid/view/View;", "targetView", "u1", "view", "j1", NodeProps.VISIBLE, "z1", "Lcom/tencent/gdtad/util/GdtAntiSpamReportHelper;", "I", "Lcom/tencent/gdtad/util/GdtAntiSpamReportHelper;", "mAntiSpamReportHelper", "J", "Landroid/view/View;", "mAdCardLayout", "K", "mAdSimpleBanner", "Lcom/tencent/ad/tangram/widget/bubble/GdtLogProxy;", "L", "Lcom/tencent/ad/tangram/widget/bubble/GdtLogProxy;", "mGdtLogger", "Lcom/tencent/ad/tangram/widget/bubble/GdtBubbleDanmakuLayout;", "M", "Lcom/tencent/ad/tangram/widget/bubble/GdtBubbleDanmakuLayout;", "mBubbleDanmakuLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "N", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mGameBannerLayout", "Landroid/widget/ImageView;", "P", "Landroid/widget/ImageView;", "mGameBannerIcon", "Landroid/widget/TextView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/TextView;", "mGameBannerDesc", BdhLogUtil.LogTag.Tag_Req, "mGameBannerTitle", "", ExifInterface.LATITUDE_SOUTH, "Z", "mIsGameBanner", "", "T", "mAdBannerDelayMillis", "Landroid/widget/LinearLayout;", "U", "Landroid/widget/LinearLayout;", "mPoiLayout", "V", "mPoiStoreName", "Lcom/tencent/biz/qqcircle/richframework/widget/SquareImageView;", "W", "Lcom/tencent/biz/qqcircle/richframework/widget/SquareImageView;", "mPoiIcon", "X", "mPoiArrow", "Y", "mIsPoiBanner", "Lcom/tencent/gdtad/aditem/GdtAd;", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "a0", "Lfeedcloud/FeedCloudMeta$StFeed;", "mAdFeed", "b0", "mAdCardStyle", "c0", "mIsInitView", "<init>", "()V", "d0", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class da extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: d0, reason: collision with root package name */
    @NotNull
    private static final a f85613d0 = new a(null);

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View mAdCardLayout;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private View mAdSimpleBanner;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private GdtLogProxy mGdtLogger;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private GdtBubbleDanmakuLayout mBubbleDanmakuLayout;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout mGameBannerLayout;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private ImageView mGameBannerIcon;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private TextView mGameBannerDesc;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private TextView mGameBannerTitle;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean mIsGameBanner;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mPoiLayout;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private TextView mPoiStoreName;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private SquareImageView mPoiIcon;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private ImageView mPoiArrow;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean mIsPoiBanner;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private GdtAd mAd;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed mAdFeed;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int mAdCardStyle;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsInitView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final GdtAntiSpamReportHelper mAntiSpamReportHelper = new GdtAntiSpamReportHelper();

    /* renamed from: T, reason: from kotlin metadata */
    private long mAdBannerDelayMillis = 1000;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/da$a;", "", "", "ADCARD_WITH_BUBBLE_HEIGHT_DP", "I", "AD_BANNER_AVATAR_SIZE", "", "BANNER_DEFAULT_DELAY_MILLIS", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/ad/da$b", "Lcom/tencent/ad/tangram/widget/bubble/GdtLogProxy;", "", "tag", "msg", "", "d", "e", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements GdtLogProxy {
        b() {
        }

        @Override // com.tencent.ad.tangram.widget.bubble.GdtLogProxy
        public void d(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d(tag, 1, msg2);
        }

        @Override // com.tencent.ad.tangram.widget.bubble.GdtLogProxy
        public void e(@NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e(tag, 1, msg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(View view, int i3) {
        af.r0(view, i3);
    }

    private final void B1() {
        String str;
        qq_common.LocalStoreInfo localStoreInfo;
        PBStringField pBStringField;
        TextView textView = this.mPoiStoreName;
        if (textView != null) {
            GdtAd gdtAd = this.mAd;
            if (gdtAd != null && (localStoreInfo = gdtAd.getLocalStoreInfo()) != null && (pBStringField = localStoreInfo.store_name) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            textView.setText(str);
        }
    }

    private final void C1() {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BannerInfo F = af.F(this.mAd);
        if (F == null) {
            QLog.d("QFSFeedChildAdTopAreaPresenter", 1, "init bannerInfo is null");
            return;
        }
        String str = F.icon_url.get();
        Intrinsics.checkNotNullExpressionValue(str, "bannerInfo.icon_url.get()");
        if (!TextUtils.isEmpty(str)) {
            Option regionWidth = Option.obtain().setRequestWidth(com.tencent.biz.qqcircle.utils.cx.a(24.0f)).setRequestHeight(com.tencent.biz.qqcircle.utils.cx.a(24.0f)).setTargetView(this.mGameBannerIcon).setUrl(str).setRegionHeight(com.tencent.biz.qqcircle.utils.cx.a(24.0f)).setRegionWidth(com.tencent.biz.qqcircle.utils.cx.a(24.0f));
            regionWidth.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(regionWidth);
        }
        String str2 = F.icon_title.get();
        Intrinsics.checkNotNullExpressionValue(str2, "bannerInfo.icon_title.get()");
        TextView textView = this.mGameBannerTitle;
        if (textView != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "\u5c0f\u6e38\u620f";
            }
            textView.setText(str2);
        }
        TextView textView2 = this.mGameBannerDesc;
        if (textView2 != null) {
            textView2.setText(F.button_txt.get());
        }
    }

    private final void j1(View view) {
        int i3;
        if (view == null) {
            return;
        }
        Integer a16 = com.tencent.biz.qqcircle.immersive.feed.ad.a.f85437a.a(view, false);
        String adAntiSpamForClickParams = this.mAntiSpamReportHelper.getAdAntiSpamForClickParams(this.C);
        com.tencent.biz.qqcircle.immersive.utils.j jVar = com.tencent.biz.qqcircle.immersive.utils.j.f90213a;
        GdtAd gdtAd = this.mAd;
        int i16 = this.f85018i;
        QCircleExtraTypeInfo r16 = r();
        if (a16 != null) {
            i3 = a16.intValue();
        } else {
            i3 = 1000;
        }
        jVar.J(gdtAd, view, i16, r16, i3, adAntiSpamForClickParams);
    }

    private final void k1(QFSFeedAdCardAnimEvent event) {
        String str;
        GdtAd gdtAd = this.mAd;
        if (gdtAd == null || (str = gdtAd.getTraceId()) == null) {
            str = "";
        }
        if (!TextUtils.equals(str, event.getTraceId())) {
            QLog.e("QFSFeedChildAdTopAreaPresenter", 1, "[handleCardAnimEvent] error, not the same ad");
            return;
        }
        if (Intrinsics.areEqual(event.getState(), "1")) {
            if (this.mIsPoiBanner) {
                z1(this.mPoiLayout, 0);
                return;
            }
            w1();
        }
        if (Intrinsics.areEqual(event.getState(), "2") && event.getStatus() == 1) {
            z1(this.mGameBannerLayout, 8);
            z1(this.mPoiLayout, 8);
        }
    }

    private final void l1() {
        View view;
        View view2 = this.C;
        if (view2 != null && !this.mIsInitView) {
            this.mIsInitView = true;
            ViewStub viewStub = (ViewStub) view2.findViewById(R.id.v9u);
            if (viewStub != null) {
                viewStub.inflate();
            }
            View findViewById = this.C.findViewById(R.id.v9q);
            this.mAdCardLayout = findViewById;
            if (findViewById != null) {
                view = findViewById.findViewById(R.id.f38701_o);
            } else {
                view = null;
            }
            this.mAdSimpleBanner = view;
            return;
        }
        QLog.w("QFSFeedChildAdTopAreaPresenter", 1, "initAdCard cancel, rootView=" + view2 + ",isInitView=" + this.mIsInitView);
    }

    private final void m1() {
        LinearLayout linearLayout;
        TextView textView;
        SquareImageView squareImageView;
        ViewStub viewStub;
        View view = this.mAdCardLayout;
        if (view != null && (viewStub = (ViewStub) view.findViewById(R.id.f38511_6)) != null) {
            viewStub.inflate();
        }
        View view2 = this.mAdCardLayout;
        ImageView imageView = null;
        if (view2 != null) {
            linearLayout = (LinearLayout) view2.findViewById(R.id.f38471_2);
        } else {
            linearLayout = null;
        }
        this.mPoiLayout = linearLayout;
        View view3 = this.mAdCardLayout;
        if (view3 != null) {
            textView = (TextView) view3.findViewById(R.id.f38501_5);
        } else {
            textView = null;
        }
        this.mPoiStoreName = textView;
        View view4 = this.mAdCardLayout;
        if (view4 != null) {
            squareImageView = (SquareImageView) view4.findViewById(R.id.f38491_4);
        } else {
            squareImageView = null;
        }
        this.mPoiIcon = squareImageView;
        View view5 = this.mAdCardLayout;
        if (view5 != null) {
            imageView = (ImageView) view5.findViewById(R.id.f38481_3);
        }
        this.mPoiArrow = imageView;
        u1(this.mPoiLayout);
        u1(this.mPoiIcon);
        u1(this.mPoiStoreName);
        u1(this.mPoiArrow);
        LinearLayout linearLayout2 = this.mPoiLayout;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    private final void n1() {
        View view;
        View view2 = this.C;
        List<String> list = null;
        if (view2 != null) {
            view = view2.findViewById(R.id.f379818q);
        } else {
            view = null;
        }
        if (view != null) {
            int dpToPx = ImmersiveUtils.dpToPx(294.0f);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = dpToPx;
            }
            QLog.d("QFSFeedChildAdCardPresenter", 2, "updateDanmakuLayout updatedHeight:" + dpToPx);
            view.setLayoutParams(layoutParams);
            View findViewById = view.findViewById(R.id.f165345vm4);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.ad.tangram.widget.bubble.GdtBubbleDanmakuLayout");
            GdtBubbleDanmakuLayout gdtBubbleDanmakuLayout = (GdtBubbleDanmakuLayout) findViewById;
            this.mBubbleDanmakuLayout = gdtBubbleDanmakuLayout;
            u1(gdtBubbleDanmakuLayout);
            GdtBubbleDanmakuParams gdtBubbleDanmakuParams = new GdtBubbleDanmakuParams();
            gdtBubbleDanmakuParams.setBubbleItemCount(3);
            gdtBubbleDanmakuParams.setMotionLengthDp(32);
            GdtAd gdtAd = this.mAd;
            if (gdtAd != null) {
                list = gdtAd.getDanmakuContents();
            }
            gdtBubbleDanmakuParams.setContents(list);
            GdtBubbleDanmakuLayout gdtBubbleDanmakuLayout2 = this.mBubbleDanmakuLayout;
            if (gdtBubbleDanmakuLayout2 != null) {
                gdtBubbleDanmakuLayout2.init(gdtBubbleDanmakuParams);
            }
            this.mGdtLogger = new b();
            GdtBubbleDanmakuLayout gdtBubbleDanmakuLayout3 = this.mBubbleDanmakuLayout;
            if (gdtBubbleDanmakuLayout3 != null) {
                gdtBubbleDanmakuLayout3.setLogger(new WeakReference<>(this.mGdtLogger));
            }
        }
    }

    private final void o1() {
        ImageView imageView;
        TextView textView;
        ViewStub viewStub;
        ConstraintLayout constraintLayout;
        View view = this.mAdCardLayout;
        if (view == null) {
            return;
        }
        TextView textView2 = null;
        if (this.mGameBannerLayout == null) {
            if (view != null) {
                viewStub = (ViewStub) view.findViewById(R.id.f38911a9);
            } else {
                viewStub = null;
            }
            if (viewStub != null) {
                View inflate = viewStub.inflate();
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                constraintLayout = (ConstraintLayout) inflate;
            } else {
                View view2 = this.mAdCardLayout;
                if (view2 != null) {
                    constraintLayout = (ConstraintLayout) view2.findViewById(R.id.f38871a5);
                } else {
                    constraintLayout = null;
                }
            }
            this.mGameBannerLayout = constraintLayout;
        }
        ConstraintLayout constraintLayout2 = this.mGameBannerLayout;
        if (constraintLayout2 != null) {
            imageView = (ImageView) constraintLayout2.findViewById(R.id.f38901a8);
        } else {
            imageView = null;
        }
        this.mGameBannerIcon = imageView;
        ConstraintLayout constraintLayout3 = this.mGameBannerLayout;
        if (constraintLayout3 != null) {
            textView = (TextView) constraintLayout3.findViewById(R.id.f38891a7);
        } else {
            textView = null;
        }
        this.mGameBannerDesc = textView;
        ConstraintLayout constraintLayout4 = this.mGameBannerLayout;
        if (constraintLayout4 != null) {
            textView2 = (TextView) constraintLayout4.findViewById(R.id.f38921a_);
        }
        this.mGameBannerTitle = textView2;
        u1(this.mGameBannerLayout);
        u1(this.mGameBannerDesc);
        u1(this.mGameBannerTitle);
        u1(this.mGameBannerIcon);
        ConstraintLayout constraintLayout5 = this.mGameBannerLayout;
        if (constraintLayout5 != null) {
            constraintLayout5.setVisibility(8);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0012, code lost:
    
        if (r1 == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void q1() {
        if (this.mIsPoiBanner) {
            View view = this.mAdSimpleBanner;
            if (view != null) {
                boolean z16 = false;
                if (view != null && view.getVisibility() == 0) {
                    z16 = true;
                }
            }
            z1(this.mPoiLayout, 8);
            return;
        }
        w1();
    }

    private final void r1() {
        GdtBubbleDanmakuLayout gdtBubbleDanmakuLayout = this.mBubbleDanmakuLayout;
        if (gdtBubbleDanmakuLayout != null) {
            gdtBubbleDanmakuLayout.recycle();
        }
        this.mBubbleDanmakuLayout = null;
    }

    private final void s1() {
        af.r0(this.mGameBannerLayout, 8);
        af.r0(this.mPoiLayout, 8);
    }

    private final void t1() {
        long j3;
        PBUInt64Field pBUInt64Field;
        eq eqVar = eq.f85700a;
        this.mIsGameBanner = eqVar.a(this.mAd, this.mAdCardStyle);
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mAdFeed;
        if (feedCloudMeta$StFeed != null && (pBUInt64Field = feedCloudMeta$StFeed.createTime) != null) {
            j3 = pBUInt64Field.get() * 1000;
        } else {
            j3 = 1000;
        }
        this.mAdBannerDelayMillis = j3;
        this.mIsPoiBanner = eqVar.j(this.mAd, this.mAdCardStyle);
    }

    private final void u1(View targetView) {
        this.mAntiSpamReportHelper.listenOnTouchEvent(targetView);
        if (targetView != null) {
            targetView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.cz
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    da.v1(da.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(da this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r0 == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void w1() {
        boolean z16;
        if (this.mIsGameBanner) {
            Boolean I = af.I(this.mAdFeed);
            Intrinsics.checkNotNullExpressionValue(I, "getShowGameBannerInstantly(mAdFeed)");
            if (I.booleanValue()) {
                View view = this.mAdSimpleBanner;
                if (view != null) {
                    if (view != null && view.getVisibility() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
                z1(this.mGameBannerLayout, 0);
                return;
            }
        }
        if (this.mIsGameBanner && !af.K(this.mAdFeed)) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.cy
                @Override // java.lang.Runnable
                public final void run() {
                    da.x1(da.this);
                }
            }, this.mAdBannerDelayMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(da this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ConstraintLayout constraintLayout = this$0.mGameBannerLayout;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
    }

    private final void y1() {
        if (af.Z(this.mAd) && af.z(this.mAd) == 1) {
            String x16 = af.x(this.mAd);
            if (TextUtils.isEmpty(x16)) {
                x16 = "\u6447\u52a8\u6216\u70b9\u51fb\u67e5\u770b\u8be6\u60c5";
            }
            TextView textView = this.mGameBannerDesc;
            if (textView != null) {
                textView.setText(x16);
            }
        }
    }

    private final void z1(final View view, final int visible) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.cx
            @Override // java.lang.Runnable
            public final void run() {
                da.A1(view, visible);
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(@Nullable com.tencent.biz.qqcircle.immersive.feed.event.h event) {
        String str;
        String str2;
        super.C0(event);
        String str3 = null;
        if (event instanceof com.tencent.biz.qqcircle.immersive.feed.event.e) {
            String mTraceId = ((com.tencent.biz.qqcircle.immersive.feed.event.e) event).getMTraceId();
            GdtAd gdtAd = this.mAd;
            if (gdtAd != null) {
                str2 = gdtAd.getTraceId();
            } else {
                str2 = null;
            }
            if (!TextUtils.equals(mTraceId, str2)) {
                return;
            }
            z1(this.mGameBannerLayout, 8);
            z1(this.mPoiLayout, 8);
        }
        if (event instanceof com.tencent.biz.qqcircle.immersive.feed.event.f) {
            String mTraceId2 = ((com.tencent.biz.qqcircle.immersive.feed.event.f) event).getMTraceId();
            GdtAd gdtAd2 = this.mAd;
            if (gdtAd2 != null) {
                str = gdtAd2.getTraceId();
            } else {
                str = null;
            }
            if (TextUtils.equals(mTraceId2, str) && !eq.f85700a.f(this.mAdCardStyle)) {
                q1();
            } else {
                return;
            }
        }
        if (event instanceof com.tencent.biz.qqcircle.immersive.feed.event.c) {
            String a16 = ((com.tencent.biz.qqcircle.immersive.feed.event.c) event).a();
            GdtAd gdtAd3 = this.mAd;
            if (gdtAd3 != null) {
                str3 = gdtAd3.getTraceId();
            }
            if (!TextUtils.equals(a16, str3)) {
                return;
            }
            y1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(QFSFeedAdCardAnimEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        QLog.i("QFSFeedChildAdTopAreaPresenter", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        GdtBubbleDanmakuLayout gdtBubbleDanmakuLayout = this.mBubbleDanmakuLayout;
        if (gdtBubbleDanmakuLayout != null && gdtBubbleDanmakuLayout != null) {
            gdtBubbleDanmakuLayout.recycle();
        }
        this.mAntiSpamReportHelper.onDestroy();
        super.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        if (af.a0(this.mAd, this.mAdCardStyle)) {
            return;
        }
        if (this.mIsPoiBanner) {
            B1();
        } else if (this.mIsGameBanner) {
            C1();
        }
        this.mAntiSpamReportHelper.setExpoTime();
        super.K0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedUnSelected(selectInfo);
        ConstraintLayout constraintLayout = this.mGameBannerLayout;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        LinearLayout linearLayout = this.mPoiLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        GdtBubbleDanmakuLayout gdtBubbleDanmakuLayout = this.mBubbleDanmakuLayout;
        if (gdtBubbleDanmakuLayout != null) {
            gdtBubbleDanmakuLayout.setVisibility(8);
        }
        this.mAntiSpamReportHelper.resetExpoTime();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSFeedAdCardAnimEvent) {
            k1((QFSFeedAdCardAnimEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        if (data == null) {
            QLog.e("QFSFeedChildAdTopAreaPresenter", 1, "[onBindData] data should not be null.");
            return;
        }
        U0(ae.b(this.E.g(), position));
        try {
            FeedCloudMeta$StFeed c16 = u.c(this.E);
            this.mAdFeed = c16;
            this.mAdCardStyle = c16.status.get();
            this.mAd = new GdtAd(u.e(this.E));
        } catch (Throwable th5) {
            QLog.e("QFSFeedChildAdTopAreaPresenter", 1, "[onBindData] failed, error is " + th5);
        }
        r1();
        t1();
        if (!af.a0(this.mAd, this.mAdCardStyle) && !eq.f85700a.h(this.mAd)) {
            l1();
            if (this.mIsPoiBanner) {
                m1();
            } else if (this.mIsGameBanner) {
                o1();
            }
            if (af.g(this.mAd, this.mAdCardStyle)) {
                n1();
            }
            s1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdTopAreaPresenter";
    }
}
