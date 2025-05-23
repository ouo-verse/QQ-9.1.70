package com.qzone.reborn.feedx.presenter.detailcomment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.feed.utils.AdsFeedbackReporter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellSummary;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.util.k;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001RB\u000f\u0012\u0006\u0010N\u001a\u00020M\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0014J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010)R\u0018\u00102\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010%R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006S"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/detailcomment/QZoneFeedxDetailAdBlockView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "Landroid/view/View$OnClickListener;", "", "initView", "currentAdFeedData", "y0", "x0", "feedData", "", "s0", "u0", "r0", "", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "q0", "w0", "v0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mAdContainer", "f", "mAdView", "Landroid/widget/RelativeLayout;", h.F, "Landroid/widget/RelativeLayout;", "mAdInfoView", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mAdImage", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mAdDes", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mAdAvatar", "D", "mAdName", "E", "mAdCloseBtn", "Lcom/qzone/reborn/feedx/viewmodel/h;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/viewmodel/h;", "mDetailViewModel", "G", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "mAdFeedData", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "H", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "mAdExposureChecker", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "I", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "mCallBack", "Lcom/tencent/gdtad/aditem/GdtAd;", "J", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "K", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mOnScrollListener", "L", "Z", "mIsExistMoreComment", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "M", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxDetailAdBlockView extends QZoneBaseWidgetView<BusinessFeedData> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneUserAvatarView mAdAvatar;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mAdName;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mAdCloseBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.viewmodel.h mDetailViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private BusinessFeedData mAdFeedData;

    /* renamed from: H, reason: from kotlin metadata */
    private AdExposureChecker mAdExposureChecker;

    /* renamed from: I, reason: from kotlin metadata */
    private AdExposureChecker.ExposureCallback mCallBack;

    /* renamed from: J, reason: from kotlin metadata */
    private GdtAd mAd;

    /* renamed from: K, reason: from kotlin metadata */
    private final RecyclerView.OnScrollListener mOnScrollListener;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIsExistMoreComment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mAdContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mAdView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mAdInfoView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mAdImage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mAdDes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/presenter/detailcomment/QZoneFeedxDetailAdBlockView$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState != 0 || QZoneAdFeedUtils.f55717a.p(QZoneFeedxDetailAdBlockView.this.mAdView, QZoneFeedxDetailAdBlockView.this.getHostActivity()) <= 1.0f) {
                return;
            }
            QZoneFeedxDetailAdBlockView.this.u0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedx/presenter/detailcomment/QZoneFeedxDetailAdBlockView$d", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            ImageView imageView = QZoneFeedxDetailAdBlockView.this.mAdImage;
            if (imageView != null && (viewTreeObserver = imageView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            ImageView imageView2 = QZoneFeedxDetailAdBlockView.this.mAdImage;
            if (imageView2 != null) {
                imageView2.getLayoutParams().height = (imageView2.getMeasuredWidth() * 9) / 16;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedx/presenter/detailcomment/QZoneFeedxDetailAdBlockView$e", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements ViewTreeObserver.OnGlobalLayoutListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            if (QZoneAdFeedUtils.f55717a.p(QZoneFeedxDetailAdBlockView.this.mAdView, QZoneFeedxDetailAdBlockView.this.getHostActivity()) > 1.0f) {
                QZoneFeedxDetailAdBlockView.this.u0();
            }
            LinearLayout linearLayout = QZoneFeedxDetailAdBlockView.this.mAdView;
            if (linearLayout == null || (viewTreeObserver = linearLayout.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxDetailAdBlockView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOnScrollListener = new b();
        this.mDetailViewModel = (com.qzone.reborn.feedx.viewmodel.h) p(com.qzone.reborn.feedx.viewmodel.h.class);
    }

    private final void initView() {
        if (this.mAdContainer != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.nm7);
        LinearLayout linearLayout = (LinearLayout) (viewStub != null ? viewStub.inflate() : null);
        this.mAdContainer = linearLayout;
        if (linearLayout == null) {
            return;
        }
        this.mAdView = linearLayout != null ? (LinearLayout) linearLayout.findViewById(R.id.f20277y) : null;
        LinearLayout linearLayout2 = this.mAdContainer;
        this.mAdInfoView = linearLayout2 != null ? (RelativeLayout) linearLayout2.findViewById(R.id.f20247v) : null;
        LinearLayout linearLayout3 = this.mAdContainer;
        this.mAdImage = linearLayout3 != null ? (ImageView) linearLayout3.findViewById(R.id.f20237u) : null;
        LinearLayout linearLayout4 = this.mAdContainer;
        this.mAdDes = linearLayout4 != null ? (TextView) linearLayout4.findViewById(R.id.f20227t) : null;
        LinearLayout linearLayout5 = this.mAdContainer;
        QZoneUserAvatarView qZoneUserAvatarView = linearLayout5 != null ? (QZoneUserAvatarView) linearLayout5.findViewById(R.id.f20197q) : null;
        this.mAdAvatar = qZoneUserAvatarView;
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setClickable(false);
        }
        LinearLayout linearLayout6 = this.mAdContainer;
        this.mAdName = linearLayout6 != null ? (TextView) linearLayout6.findViewById(R.id.f20267x) : null;
        LinearLayout linearLayout7 = this.mAdContainer;
        this.mAdCloseBtn = linearLayout7 != null ? (ImageView) linearLayout7.findViewById(R.id.f20207r) : null;
        LinearLayout linearLayout8 = this.mAdView;
        if (linearLayout8 != null) {
            linearLayout8.setOnClickListener(this);
        }
        ImageView imageView = this.mAdCloseBtn;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        if (k.f59549a.f()) {
            ImageView imageView2 = this.mAdImage;
            if (imageView2 != null) {
                imageView2.setBackgroundColor(-16777216);
            }
            ImageView imageView3 = this.mAdImage;
            if (imageView3 != null) {
                imageView3.setAlpha(0.8f);
            }
            TextView textView = this.mAdDes;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.mAdName;
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor("#66EBEBF5"));
            }
            QZoneUserAvatarView qZoneUserAvatarView2 = this.mAdAvatar;
            if (qZoneUserAvatarView2 != null) {
                qZoneUserAvatarView2.setBackgroundColor(Color.parseColor("#1F1F1F"));
            }
            QZoneUserAvatarView qZoneUserAvatarView3 = this.mAdAvatar;
            if (qZoneUserAvatarView3 != null) {
                qZoneUserAvatarView3.setAlpha(0.8f);
            }
            RelativeLayout relativeLayout = this.mAdInfoView;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(Color.parseColor("#1F1F1F"));
            }
        }
    }

    private final void r0() {
        boolean contains;
        String traceId;
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        HashSet<String> t16 = qZoneAdFeedUtils.t();
        GdtAd gdtAd = this.mAd;
        contains = CollectionsKt___CollectionsKt.contains(t16, gdtAd != null ? gdtAd.getTraceId() : null);
        if (contains) {
            QLog.e("QZoneFeedxDetailAdBlockView", 1, "[doOriginalExposureReport] cancel, has exposed");
            return;
        }
        GdtAd gdtAd2 = this.mAd;
        QLog.i("QZoneFeedxDetailAdBlockView", 1, "[doOriginalExposureReport] doOriginExpose + " + (gdtAd2 != null ? gdtAd2.getTraceId() : null));
        GdtAd gdtAd3 = this.mAd;
        if (gdtAd3 != null && (traceId = gdtAd3.getTraceId()) != null) {
            com.tencent.gdtad.util.e.a(qZoneAdFeedUtils.t(), traceId);
        }
        GdtAdFeedUtil.doOriginalExposureReport(this.mAdFeedData, getContext(), -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0() {
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.startCheck();
        }
        r0();
    }

    private final void x0() {
        if (this.mAdFeedData != null) {
            this.mAdExposureChecker = new AdExposureChecker(this.mAd, new WeakReference(this.mAdView));
            this.mCallBack = new c();
            AdExposureChecker adExposureChecker = this.mAdExposureChecker;
            if (adExposureChecker != null) {
                adExposureChecker.setCallback(new WeakReference<>(this.mCallBack));
            }
        }
        AdExposureChecker adExposureChecker2 = this.mAdExposureChecker;
        if (adExposureChecker2 != null) {
            adExposureChecker2.startCheck();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y0(BusinessFeedData currentAdFeedData) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        BusinessFeedData businessFeedData = this.mAdFeedData;
        if (!TextUtils.isEmpty(businessFeedData != null ? QZoneAdFeedDataExtKt.getTraceId(businessFeedData) : null)) {
            BusinessFeedData businessFeedData2 = this.mAdFeedData;
            if (TextUtils.equals(businessFeedData2 != null ? QZoneAdFeedDataExtKt.getTraceId(businessFeedData2) : null, QZoneAdFeedDataExtKt.getTraceId(currentAdFeedData))) {
                BusinessFeedData businessFeedData3 = this.mAdFeedData;
                String traceId = businessFeedData3 != null ? QZoneAdFeedDataExtKt.getTraceId(businessFeedData3) : null;
                LinearLayout linearLayout = this.mAdContainer;
                QLog.i("QZoneFeedxDetailAdBlockView", 1, "updateAdData, traceId: " + traceId + ", mAdContainer.visible:" + (linearLayout != null ? Integer.valueOf(linearLayout.getVisibility()) : null));
                return;
            }
        }
        this.mAdFeedData = currentAdFeedData;
        LinearLayout linearLayout2 = this.mAdContainer;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        ImageView imageView = this.mAdImage;
        if (imageView != null && (viewTreeObserver2 = imageView.getViewTreeObserver()) != null) {
            viewTreeObserver2.addOnGlobalLayoutListener(new d());
        }
        BusinessFeedData businessFeedData4 = this.mAdFeedData;
        if (businessFeedData4 != null) {
            if (!businessFeedData4.hasCalculate) {
                businessFeedData4.preCalculate();
            }
            TextView textView = this.mAdDes;
            if (textView != null) {
                CellSummary cellSummaryV2 = businessFeedData4.getCellSummaryV2();
                textView.setText(cellSummaryV2 != null ? cellSummaryV2.displayStr : null);
            }
            TextView textView2 = this.mAdName;
            if (textView2 != null) {
                textView2.setText(businessFeedData4.getUser().nickName);
            }
            FeedPictureInfo[] feedPics = businessFeedData4.getFeedPics(0);
            if (feedPics != null) {
                if (((feedPics.length == 0) ^ true) != false) {
                    PictureUrl h16 = feedPics[0].h();
                    com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setTargetView(this.mAdImage).setNeedShowLoadingDrawable(false).setNeedShowFailedDrawable(true).setUrl(h16 != null ? h16.url : null));
                }
            }
            com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setTargetView(this.mAdAvatar).setNeedShowLoadingDrawable(false).setUrl(businessFeedData4.getUser().logo));
        }
        this.mAd = new GdtAd(GdtFeedUtilForQZone.f(this.mAdFeedData));
        x0();
        LinearLayout linearLayout3 = this.mAdView;
        if (linearLayout3 != null && (viewTreeObserver = linearLayout3.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new e());
        }
        ViewGroup viewGroup = this.mParentView;
        if (viewGroup instanceof RecyclerView) {
            ((RecyclerView) viewGroup).addOnScrollListener(this.mOnScrollListener);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ch_;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        BusinessFeedData businessFeedData;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null && (businessFeedData = this.mAdFeedData) != null) {
            if (v3.getId() == R.id.f20207r) {
                QLog.i("QZoneFeedxDetailAdBlockView", 1, "onClick, close ad ");
                com.qzone.reborn.feedx.viewmodel.h hVar = this.mDetailViewModel;
                if (hVar != null) {
                    hVar.S1();
                }
                LinearLayout linearLayout = this.mAdView;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                AdsFeedbackReporter.report(this.mAdFeedData);
            } else {
                QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
                Activity hostActivity = getHostActivity();
                Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
                qZoneAdFeedUtils.G(hostActivity, v3, businessFeedData, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_ADV, 31, null);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void onDestroy() {
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityDestroy();
        }
        this.mAdExposureChecker = null;
        this.mCallBack = null;
        ViewGroup viewGroup = this.mParentView;
        if (viewGroup instanceof RecyclerView) {
            ((RecyclerView) viewGroup).removeOnScrollListener(this.mOnScrollListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void bindData(BusinessFeedData objData, int pos) {
        com.qzone.reborn.feedx.viewmodel.h hVar = this.mDetailViewModel;
        BusinessFeedData W1 = hVar != null ? hVar.W1() : null;
        com.qzone.reborn.feedx.viewmodel.h hVar2 = this.mDetailViewModel;
        boolean z16 = false;
        if (hVar2 != null && hVar2.A2()) {
            z16 = true;
        }
        if (z16) {
            this.mIsExistMoreComment = true;
        }
        if (s0(W1) && !this.mIsExistMoreComment) {
            initView();
            y0(W1);
            return;
        }
        QLog.e("QZoneFeedxDetailAdBlockView", 1, "hide detail ad, isAdDataValid:" + s0(W1) + ", mIsExistMoreComment:" + this.mIsExistMoreComment);
        LinearLayout linearLayout = this.mAdContainer;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    public final void v0() {
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityPause();
        }
    }

    public final void w0() {
        AdExposureChecker adExposureChecker = this.mAdExposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityResume();
        }
    }

    private final boolean s0(BusinessFeedData feedData) {
        return (feedData != null ? feedData.getPictureInfo() : null) != null && (feedData.isGDTAdvFeed() || feedData.isAdFeeds());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/feedx/presenter/detailcomment/QZoneFeedxDetailAdBlockView$c", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "view", "", "onExposure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements AdExposureChecker.ExposureCallback {
        c() {
        }

        @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
        public void onExposure(WeakReference<View> view) {
            if (view == null) {
                return;
            }
            QLog.i("QZoneFeedxDetailAdBlockView", 1, "onExposure");
            GdtAdFeedUtil.doEffectiveExposureReport(QZoneFeedxDetailAdBlockView.this.mAdFeedData, 0, 2);
        }
    }
}
