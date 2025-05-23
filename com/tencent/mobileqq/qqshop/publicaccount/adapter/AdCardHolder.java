package com.tencent.mobileqq.qqshop.publicaccount.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ecshop.api.IEcshopService;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 h2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001iB\u000f\u0012\u0006\u0010e\u001a\u00020B\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0014J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0014J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015J)\u0010 \u001a\u00020\u00062!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u001aJ\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004J\b\u0010#\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020)H\u0004J\b\u0010+\u001a\u00020\u0006H\u0015J\b\u0010,\u001a\u00020\u0006H\u0015J\b\u0010-\u001a\u00020\u0006H\u0017J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010*\u001a\u00020.H\u0016J\u0010\u00100\u001a\u00020\u00062\u0006\u0010*\u001a\u00020.H\u0016J\b\u00101\u001a\u00020\u0006H\u0016J\b\u00102\u001a\u00020)H\u0016R\u001a\u00107\u001a\u0002038\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b#\u00104\u001a\u0004\b5\u00106R\u001a\u0010=\u001a\u0002088\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010CR\u0014\u0010E\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010:R\u0014\u0010F\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010:R\u0014\u0010H\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010@R\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010MR\u0016\u0010P\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010OR\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010OR\u0016\u0010Q\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010OR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00101R\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010OR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010c\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdCardHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/view/View$OnAttachStateChangeListener;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "p", ReportConstant.COSTREPORT_PREFIX, "r", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/p;", "headCardModel", "", "headPosition", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Req, "O", "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "iconDrawable", "N", HippyTKDListViewAdapter.X, "P", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "msgId", "deleteListener", "J", "isLastMsg", "L", "E", "isVisible", "M", "stop", "H", "y", "", "v", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "I", "toString", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "w", "()Landroid/widget/RelativeLayout;", "videoContainer", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "t", "()Landroid/widget/ImageView;", "adCardImage", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "adCardTitle", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "adCardBtnContainer", "smallShakeIcon", "bigShakeIcon", "K", "adCardBtn", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "adCardAdSourceLayout", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isReported", "Z", "isShowBigShake", "isAttached", ExifInterface.LATITUDE_SOUTH, "T", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/p;", "u", "()Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/p;", "setHeadCardModel", "(Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/p;)V", "Lcom/tencent/mobileqq/qqshop/publicaccount/shake/b;", "U", "Lcom/tencent/mobileqq/qqshop/publicaccount/shake/b;", "adShakeHelper", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "V", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "exposureChecker", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "W", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "exposureCheckerCallback", "itemView", "<init>", "(Landroid/view/ViewGroup;)V", "X", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class AdCardHolder extends RecyclerView.ViewHolder implements LifecycleObserver, View.OnAttachStateChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout videoContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ImageView adCardImage;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView adCardTitle;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ViewGroup adCardBtnContainer;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ImageView smallShakeIcon;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ImageView bigShakeIcon;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final TextView adCardBtn;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout adCardAdSourceLayout;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isReported;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isShowBigShake;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isVisible;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isAttached;

    /* renamed from: R, reason: from kotlin metadata */
    private int headPosition;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isLastMsg;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private p headCardModel;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqshop.publicaccount.shake.b adShakeHelper;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private AdExposureChecker exposureChecker;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private AdExposureChecker.ExposureCallback exposureCheckerCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdCardHolder$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.adapter.AdCardHolder$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31049);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCardHolder(@NotNull ViewGroup itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.f167092kq3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.video_container)");
        this.videoContainer = (RelativeLayout) findViewById;
        View findViewById2 = itemView.findViewById(R.id.sbh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.ad_card_image)");
        this.adCardImage = (ImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.sbj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.ad_card_title)");
        this.adCardTitle = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.sbb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.ad_card_btn_container)");
        this.adCardBtnContainer = (ViewGroup) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.f86374rh);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.small_shake_icon)");
        this.smallShakeIcon = (ImageView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.t6u);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.big_shake_icon)");
        this.bigShakeIcon = (ImageView) findViewById6;
        View findViewById7 = itemView.findViewById(R.id.sba);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.ad_card_btn)");
        this.adCardBtn = (TextView) findViewById7;
        View findViewById8 = itemView.findViewById(R.id.sb7);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.\u2026ad_card_ad_source_layout)");
        this.adCardAdSourceLayout = (LinearLayout) findViewById8;
        this.isReported = new AtomicBoolean(false);
        this.headPosition = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(AdCardHolder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(AdCardHolder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(p headCardModel, qq_ad_get.QQAdGetRsp.AdInfo adInfo, AdCardHolder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(headCardModel, "$headCardModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.ecshop.view.b.f203962a.b(headCardModel.g(), adInfo, this$0.adCardAdSourceLayout, headCardModel.c());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Q() {
        if (this.adShakeHelper == null) {
            com.tencent.mobileqq.qqshop.publicaccount.shake.b bVar = new com.tencent.mobileqq.qqshop.publicaccount.shake.b(this);
            this.adShakeHelper = bVar;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            bVar.i(context);
        }
    }

    private final void p(final GdtAd gdtAd) {
        if (com.tencent.mobileqq.qqshop.abtest.a.f274440a.a()) {
            AdExposureChecker adExposureChecker = this.exposureChecker;
            if (adExposureChecker != null) {
                if (adExposureChecker != null) {
                    adExposureChecker.startCheck();
                    return;
                }
                return;
            }
            this.exposureCheckerCallback = new AdExposureChecker.ExposureCallback() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.d
                @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
                public final void onExposure(WeakReference weakReference) {
                    AdCardHolder.q(AdCardHolder.this, gdtAd, weakReference);
                }
            };
            AdExposureChecker adExposureChecker2 = new AdExposureChecker(gdtAd, new mqq.util.WeakReference(this.itemView));
            this.exposureChecker = adExposureChecker2;
            adExposureChecker2.setCallback(new mqq.util.WeakReference(this.exposureCheckerCallback));
            AdExposureChecker adExposureChecker3 = this.exposureChecker;
            if (adExposureChecker3 != null) {
                adExposureChecker3.startCheck();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(AdCardHolder this$0, GdtAd gdtAd, WeakReference weakReference) {
        MsgRecord msgRecord;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(gdtAd, "$gdtAd");
        com.tencent.mobileqq.qqshop.report.gdt.b bVar = com.tencent.mobileqq.qqshop.report.gdt.b.f274718a;
        p pVar = this$0.headCardModel;
        if (pVar != null) {
            msgRecord = pVar.h();
        } else {
            msgRecord = null;
        }
        bVar.d(msgRecord, gdtAd);
    }

    private final void r() {
        Object obj;
        Object obj2;
        HashMap<String, String> hashMapOf;
        p pVar = this.headCardModel;
        if (pVar == null) {
            return;
        }
        MsgRecord h16 = pVar.h();
        if (com.tencent.mobileqq.qqshop.abtest.a.f274440a.a() && pVar.n()) {
            AdExposureChecker.onClick(this.itemView.getContext(), new GdtAd(pVar.a()), new mqq.util.WeakReference(this.exposureCheckerCallback));
        }
        if (pVar.n() && h16 != null) {
            com.tencent.mobileqq.qqshop.report.gdt.b.f274718a.c(h16, new GdtAd(pVar.a()));
        }
        Pair[] pairArr = new Pair[5];
        String str = "0";
        if (pVar.n()) {
            obj = "0";
        } else {
            obj = "1";
        }
        pairArr[0] = TuplesKt.to("op_in", obj);
        pairArr[1] = TuplesKt.to("ext1", pVar.d());
        if (!this.isLastMsg) {
            obj2 = "0";
        } else {
            obj2 = "1";
        }
        pairArr[2] = TuplesKt.to("op_type", obj2);
        pairArr[3] = TuplesKt.to("ext10", pVar.i());
        pairArr[4] = TuplesKt.to("ext23", String.valueOf(getAdapterPosition() + 1));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        if (pVar.n()) {
            if (pVar.o()) {
                str = "1";
            }
            hashMapOf.put("ext2", str);
            hashMapOf.put("ext21", String.valueOf(com.tencent.mobileqq.ecshop.ad.a.c(pVar.a())));
        }
        com.tencent.mobileqq.qqshop.report.beacon.b.f274709a.b("pa_msg_card_click", hashMapOf);
    }

    private final void s() {
        Object obj;
        Object obj2;
        HashMap<String, String> hashMapOf;
        p pVar = this.headCardModel;
        if (pVar == null) {
            return;
        }
        if (pVar.n()) {
            p(new GdtAd(pVar.a()));
        }
        if (y() && this.isReported.compareAndSet(false, true)) {
            if (!com.tencent.mobileqq.qqshop.abtest.a.f274440a.a() && pVar.n()) {
                com.tencent.mobileqq.qqshop.report.gdt.b.f274718a.d(pVar.h(), new GdtAd(pVar.a()));
            }
            Pair[] pairArr = new Pair[5];
            String str = "0";
            if (pVar.n()) {
                obj = "0";
            } else {
                obj = "1";
            }
            pairArr[0] = TuplesKt.to("op_in", obj);
            pairArr[1] = TuplesKt.to("ext1", pVar.d());
            if (!this.isLastMsg) {
                obj2 = "0";
            } else {
                obj2 = "1";
            }
            pairArr[2] = TuplesKt.to("op_type", obj2);
            pairArr[3] = TuplesKt.to("ext10", pVar.i());
            pairArr[4] = TuplesKt.to("ext23", String.valueOf(getAdapterPosition() + 1));
            hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
            if (pVar.n()) {
                if (pVar.o()) {
                    str = "1";
                }
                hashMapOf.put("ext2", str);
                hashMapOf.put("ext21", String.valueOf(com.tencent.mobileqq.ecshop.ad.a.c(pVar.a())));
            }
            com.tencent.mobileqq.qqshop.report.beacon.b.f274709a.b("pa_msg_card_show", hashMapOf);
            QLog.d("AdCardHolder", 1, "doReportShow " + v());
        }
    }

    private final boolean z() {
        p pVar = this.headCardModel;
        if (pVar == null || !pVar.n() || !com.tencent.mobileqq.qqshop.publicaccount.shake.a.f274656a.a(pVar) || !this.isLastMsg) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        p pVar = this.headCardModel;
        if (pVar == null) {
            return;
        }
        IEcshopService iEcshopService = (IEcshopService) com.tencent.mobileqq.ecshop.utils.a.a().getRuntimeService(IEcshopService.class, "");
        qq_ad_get.QQAdGetRsp.AdInfo a16 = pVar.a();
        boolean o16 = pVar.o();
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        iEcshopService.enterGDTVideoActivity(a16, IPublicAccountUtil.UIN_FOR_SHOP, o16, (Activity) context);
        r();
    }

    public void B(@NotNull p headCardModel, int headPosition) {
        boolean z16;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) headCardModel, headPosition);
            return;
        }
        Intrinsics.checkNotNullParameter(headCardModel, "headCardModel");
        this.headCardModel = headCardModel;
        this.headPosition = headPosition;
        this.adCardImage.setImageDrawable(com.tencent.mobileqq.ecshop.utils.f.c(headCardModel.e(), ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.nhp), null, 4, null));
        this.adCardTitle.setText(headCardModel.k());
        TextView textView = this.adCardBtn;
        String b16 = headCardModel.b();
        if (b16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            b16 = "\u67e5\u770b\u8be6\u60c5";
        }
        textView.setText(b16);
        this.smallShakeIcon.setVisibility(8);
        if (headCardModel.q()) {
            this.videoContainer.setVisibility(0);
        } else {
            this.videoContainer.setVisibility(8);
        }
        float dip2px = ViewUtils.dip2px(4.0f);
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        com.tencent.mobileqq.ecshop.utils.f.d(itemView, dip2px);
        com.tencent.mobileqq.ecshop.utils.f.d(this.adCardImage, dip2px);
        com.tencent.mobileqq.ecshop.utils.f.d(this.videoContainer, dip2px);
        com.tencent.mobileqq.ecshop.utils.f.d(this.adCardAdSourceLayout, 5.0f);
        boolean isAdClickAreaSwitchOn = EcshopConfUtil.isAdClickAreaSwitchOn();
        if (isAdClickAreaSwitchOn) {
            view = this.adCardBtnContainer;
        } else {
            view = this.itemView;
        }
        Intrinsics.checkNotNullExpressionValue(view, "if (clickAreaSwitchOn) a\u2026tnContainer else itemView");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AdCardHolder.C(AdCardHolder.this, view2);
            }
        });
        if (!isAdClickAreaSwitchOn) {
            this.videoContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AdCardHolder.D(AdCardHolder.this, view2);
                }
            });
        }
        this.itemView.addOnAttachStateChangeListener(this);
        if (headCardModel.n()) {
            GdtAd gdtAd = new GdtAd(headCardModel.a());
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            GdtOriginalExposureReporter.reportOriginalExposure(gdtAd, (Activity) context);
            p(new GdtAd(headCardModel.a()));
            return;
        }
        AdExposureChecker adExposureChecker = this.exposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityDestroy();
        }
        this.exposureChecker = null;
        this.exposureCheckerCallback = null;
    }

    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            s();
            O();
        }
    }

    public void H(boolean stop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, stop);
        }
    }

    public void I() {
        Lifecycle lifecycle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        QLog.d("AdCardHolder", 1, "release " + v());
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this.itemView);
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        this.itemView.removeOnAttachStateChangeListener(this);
        com.tencent.mobileqq.qqshop.publicaccount.shake.b bVar = this.adShakeHelper;
        if (bVar != null) {
            bVar.e();
        }
        this.adShakeHelper = null;
        this.bigShakeIcon.setImageDrawable(null);
        this.smallShakeIcon.setImageDrawable(null);
    }

    public final void J(@NotNull Function1<? super Long, Unit> deleteListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) deleteListener);
            return;
        }
        Intrinsics.checkNotNullParameter(deleteListener, "deleteListener");
        final p pVar = this.headCardModel;
        if (pVar == null) {
            return;
        }
        final qq_ad_get.QQAdGetRsp.AdInfo a16 = pVar.a();
        if (pVar.n() && a16 != null) {
            pVar.r(deleteListener);
            this.adCardAdSourceLayout.setVisibility(0);
            this.adCardAdSourceLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdCardHolder.K(p.this, a16, this, view);
                }
            });
            return;
        }
        this.adCardAdSourceLayout.setVisibility(8);
    }

    public final void L(boolean isLastMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, isLastMsg);
        } else {
            this.isLastMsg = isLastMsg;
        }
    }

    public void M(boolean isVisible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, isVisible);
            return;
        }
        this.isVisible = isVisible;
        if (isVisible) {
            s();
            O();
            return;
        }
        com.tencent.mobileqq.qqshop.publicaccount.shake.b bVar = this.adShakeHelper;
        if (bVar != null) {
            bVar.e();
        }
        this.adShakeHelper = null;
        this.isReported.set(false);
    }

    public final void N(@NotNull APNGDrawable iconDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) iconDrawable);
            return;
        }
        Intrinsics.checkNotNullParameter(iconDrawable, "iconDrawable");
        if (!this.isShowBigShake) {
            QLog.d("AdCardHolder", 1, "showBigShakeIcon");
            this.bigShakeIcon.setImageDrawable(iconDrawable);
            this.bigShakeIcon.setVisibility(0);
            iconDrawable.start();
            this.isShowBigShake = true;
            return;
        }
        this.bigShakeIcon.setVisibility(8);
        this.bigShakeIcon.setImageDrawable(null);
    }

    protected void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (z() && y()) {
            Q();
        }
    }

    public final void P(@NotNull APNGDrawable iconDrawable) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) iconDrawable);
            return;
        }
        Intrinsics.checkNotNullParameter(iconDrawable, "iconDrawable");
        boolean z16 = true;
        QLog.d("AdCardHolder", 1, "showSmallShakeIcon");
        iconDrawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(this.smallShakeIcon.getContext(), R.color.qui_button_text_primary_default), PorterDuff.Mode.SRC_ATOP));
        this.smallShakeIcon.setImageDrawable(iconDrawable);
        this.smallShakeIcon.setVisibility(0);
        TextView textView = this.adCardBtn;
        p pVar = this.headCardModel;
        if (pVar == null || !pVar.p()) {
            z16 = false;
        }
        if (z16) {
            str = "\u6447\u52a8\u67e5\u770b";
        } else {
            str = "\u6447\u52a8\u6216\u70b9\u51fb\u4e86\u89e3\u66f4\u591a";
        }
        textView.setText(str);
        iconDrawable.start();
    }

    public void R() {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        p pVar = this.headCardModel;
        if (pVar == null) {
            return;
        }
        if (!pVar.n()) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(pVar.f(), SchemaUtils.SCHEMA_MQQAPI, false, 2, null);
            if (startsWith$default) {
                Intent intent = new Intent(this.itemView.getContext(), (Class<?>) JumpActivity.class);
                intent.setData(Uri.parse(pVar.f()));
                this.itemView.getContext().startActivity(intent);
            } else {
                Intent intent2 = new Intent(this.itemView.getContext(), (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("url", pVar.f());
                intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                intent2.putExtra("big_brother_source_key", ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(IPublicAccountUtil.UIN_FOR_SHOP));
                this.itemView.getContext().startActivity(intent2);
            }
        } else {
            IEcshopService iEcshopService = (IEcshopService) com.tencent.mobileqq.ecshop.utils.a.a().getRuntimeService(IEcshopService.class, "");
            qq_ad_get.QQAdGetRsp.AdInfo a16 = pVar.a();
            boolean o16 = pVar.o();
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            iEcshopService.enterGdtCanvasActivity(a16, IPublicAccountUtil.UIN_FOR_SHOP, o16, (Activity) context);
        }
        r();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        I();
        AdExposureChecker adExposureChecker = this.exposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqshop.publicaccount.shake.b bVar = this.adShakeHelper;
        if (bVar != null) {
            bVar.f();
        }
        AdExposureChecker adExposureChecker = this.exposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqshop.publicaccount.shake.b bVar = this.adShakeHelper;
        if (bVar != null) {
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            bVar.h(context);
            com.tencent.mobileqq.qqshop.publicaccount.shake.b bVar2 = this.adShakeHelper;
            if (bVar2 != null) {
                bVar2.g();
            }
        }
        AdExposureChecker adExposureChecker = this.exposureChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityResume();
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View v3) {
        Lifecycle lifecycle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) v3);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        QLog.d("AdCardHolder", 1, "onViewAttachedToWindow " + v());
        this.isAttached = true;
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this.itemView);
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(this);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View v3) {
        Lifecycle lifecycle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) v3);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        QLog.d("AdCardHolder", 1, "onViewDetachedFromWindow " + v());
        this.isAttached = false;
        this.isReported.set(false);
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this.itemView);
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        com.tencent.mobileqq.qqshop.publicaccount.shake.b bVar = this.adShakeHelper;
        if (bVar != null) {
            bVar.e();
        }
        this.adShakeHelper = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ImageView t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ImageView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.adCardImage;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return "position = " + getAdapterPosition() + " , " + Integer.toHexString(hashCode());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final p u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (p) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.headCardModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "position=" + getAdapterPosition() + " headPosition=" + this.headPosition + " isLastMsg=" + this.isLastMsg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RelativeLayout w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.videoContainer;
    }

    public final void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            QLog.d("AdCardHolder", 1, "hideBigShakeIcon");
            com.tencent.mobileqq.qqshop.publicaccount.shake.a.c(com.tencent.mobileqq.qqshop.publicaccount.shake.a.f274656a, this.bigShakeIcon, 0L, 2, null);
        }
    }

    public boolean y() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (!this.isVisible || !this.isAttached) {
            return false;
        }
        Object parent = this.itemView.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        } else {
            view = null;
        }
        if (GdtUIUtils.getPercentageOfGlobalVisibleRect(view) < 0.5d) {
            return false;
        }
        return true;
    }
}
