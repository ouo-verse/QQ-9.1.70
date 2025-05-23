package com.tencent.mobileqq.vas.visitors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.vas.ui.IDynamicDrawable;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 12\u00020\u00012\u00020\u0002:\u000323\u001bB\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bJ\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u001a\u0010\u0018\u001a\u00020\b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\"R\"\u0010&\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\"R\"\u0010*\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\"R\"\u0010.\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\"\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/vas/visitors/AdComponent;", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "Landroid/view/View$OnClickListener;", "", "g", "", "isClick", "f", "", "url", "e", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "d", "result", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "onGetAdvs", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Ljava/lang/String;", "getAdUrl", "()Ljava/lang/String;", "adUrl", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "b", "()Landroid/widget/ImageView;", h.F, "(Landroid/widget/ImageView;)V", "adView", "getAdId", "setAdId", "(Ljava/lang/String;)V", "adId", "getTraceInfo", "setTraceInfo", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "i", "getReplaceAid", "setReplaceAid", "replaceAid", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getStyategyId", "setStyategyId", "styategyId", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "AdView", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class AdComponent implements TianShuGetAdvCallback, View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ImageView adView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String adUrl = "mqqapi://kuikly/open?aid={aid}&trace_detail=base64-&version=1&kr_turbo_display=svip&src_type=web&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_pay&bundle_name=vas_qqvip_pay&pay_type=svip&business_type=svip%2Cvip&half_pay=1&modal_mode=1&policy_id={policyId}";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String adId = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String traceInfo = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String replaceAid = "mvip.g.a.dz_paihangkt";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String styategyId = "quanlianghao1";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/visitors/AdComponent$AdView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @SuppressLint({"AppCompatCustomView"})
    /* loaded from: classes20.dex */
    public static final class AdView extends ImageView {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdView(@NotNull Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            Drawable drawable = getDrawable();
            if (drawable == null || drawable.getIntrinsicWidth() == 0) {
                return;
            }
            setMeasuredDimension(getMeasuredWidth(), (int) (getMeasuredWidth() * (drawable.getIntrinsicHeight() / drawable.getIntrinsicWidth())));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/visitors/AdComponent$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "aid", "b", "f", "banner", "c", "g", QCircleLpReportDc05494.KEY_PLACE, "d", h.F, "styategyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.visitors.AdComponent$a, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class AdInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String aid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String banner;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String place;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String styategyId;

        public AdInfo() {
            this(null, null, null, null, 15, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAid() {
            return this.aid;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getBanner() {
            return this.banner;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getPlace() {
            return this.place;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getStyategyId() {
            return this.styategyId;
        }

        public final void e(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.aid = str;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdInfo)) {
                return false;
            }
            AdInfo adInfo = (AdInfo) other;
            if (Intrinsics.areEqual(this.aid, adInfo.aid) && Intrinsics.areEqual(this.banner, adInfo.banner) && Intrinsics.areEqual(this.place, adInfo.place) && Intrinsics.areEqual(this.styategyId, adInfo.styategyId)) {
                return true;
            }
            return false;
        }

        public final void f(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.banner = str;
        }

        public final void g(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.place = str;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.styategyId = str;
        }

        public int hashCode() {
            return (((((this.aid.hashCode() * 31) + this.banner.hashCode()) * 31) + this.place.hashCode()) * 31) + this.styategyId.hashCode();
        }

        @NotNull
        public String toString() {
            return "AdInfo(aid=" + this.aid + ", banner=" + this.banner + ", place=" + this.place + ", styategyId=" + this.styategyId + ")";
        }

        public AdInfo(@NotNull String aid, @NotNull String banner, @NotNull String place, @NotNull String styategyId) {
            Intrinsics.checkNotNullParameter(aid, "aid");
            Intrinsics.checkNotNullParameter(banner, "banner");
            Intrinsics.checkNotNullParameter(place, "place");
            Intrinsics.checkNotNullParameter(styategyId, "styategyId");
            this.aid = aid;
            this.banner = banner;
            this.place = place;
            this.styategyId = styategyId;
        }

        public /* synthetic */ AdInfo(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AdComponent this$0, AdInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        this$0.e(info.getBanner());
    }

    private final void e(String url) {
        IVasApngFactory api = IVasApngFactory.INSTANCE.api();
        String name = AdComponent.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "AdComponent::class.java.name");
        APNGDrawable apngDrawable = api.getApngDrawable(name, url);
        b().setImageDrawable(apngDrawable);
        b().setScaleType(ImageView.ScaleType.FIT_CENTER);
        apngDrawable.setLoadedListener(new Function1<IDynamicDrawable, Unit>() { // from class: com.tencent.mobileqq.vas.visitors.AdComponent$refreshAdView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IDynamicDrawable iDynamicDrawable) {
                invoke2(iDynamicDrawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull IDynamicDrawable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                AdComponent.this.b().requestLayout();
            }
        });
    }

    private final void f(boolean isClick) {
        String str;
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mAppId = SearchConstants.PLATFORM;
        tianShuReportData.mPageId = "11";
        tianShuReportData.mTraceId = str + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mItemId = this.adId;
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        if (isClick) {
            tianShuReportData.mActionId = 102;
        } else {
            tianShuReportData.mActionId = 101;
        }
        tianShuReportData.mPositionId = "1061";
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = 1;
        tianShuReportData.mTriggerInfo = this.traceInfo;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
        String str2 = this.adId;
        if (str2 != null && !Intrinsics.areEqual(str2, "")) {
            ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).onPay(tianShuReportData.mActionId, Integer.parseInt(this.adId));
        }
    }

    private final void g() {
        List<TianShuAdPosItemData> listOf;
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 1061;
        tianShuAdPosItemData.mNeedCnt = 1;
        ITianshuManager iTianshuManager = (ITianshuManager) QRoute.api(ITianshuManager.class);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(tianShuAdPosItemData);
        iTianshuManager.requestAdv(listOf, this);
    }

    @NotNull
    public final ImageView b() {
        ImageView imageView = this.adView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adView");
        return null;
    }

    public final void d(@NotNull ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Context context = rootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        h(new AdView(context));
        rootView.addView(b(), -1, 88);
        if (VasUtil.getSignedService(MobileQQ.sMobileQQ.peekAppRuntime()).getVipStatus().isSVip()) {
            e("https://tianquan.gtimg.cn/shoal/qqgxh/f017d1a7-a399-46f8-b268-623fb9f74cdc.gif");
        } else {
            e("https://tianquan.gtimg.cn/shoal/qqgxh/f017d1a7-a399-46f8-b268-623fb9f74cdc.gif");
        }
        g();
        b().setOnClickListener(this);
        AccessibilityUtil.c(b(), "\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\u5c0a\u4eab\u4f53\u9a8c\uff0c\u7acb\u5373\u7eed\u8d39", Button.class.getName());
        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "11", "1", "", "paybar", "", "4", 101, 0, 0, "", "", "");
    }

    public final void h(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.adView = imageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        String replace$default;
        String replace$default2;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        Intent intent = new Intent(v3.getContext(), (Class<?>) JumpActivity.class);
        replace$default = StringsKt__StringsJVMKt.replace$default(this.adUrl, "{aid}", this.replaceAid, false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{policyId}", this.styategyId, false, 4, (Object) null);
        intent.setData(Uri.parse(replace$default2));
        v3.getContext().startActivity(intent);
        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "11", "1", "", this.replaceAid, "", "4", 102, 0, 0, "", "", "");
        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "11", "1", "", "paybar", "", "4", 102, 0, 0, "", "", "");
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
    public void onGetAdvs(boolean result, @Nullable TianShuAccess.GetAdsRsp getAdsRsp) {
        if (getAdsRsp == null) {
            QLog.w("VisitorsActivity", 1, "rsp null");
            return;
        }
        TianShuAccess.AdItem adItem = getAdsRsp.mapAds.get().get(0).value.lst.get(0);
        final AdInfo adInfo = new AdInfo(null, null, null, null, 15, null);
        List<TianShuAccess.MapEntry> argMap = adItem.argList.get();
        Intrinsics.checkNotNullExpressionValue(argMap, "argMap");
        int i3 = 0;
        for (Object obj : argMap) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TianShuAccess.MapEntry mapEntry = (TianShuAccess.MapEntry) obj;
            String str = mapEntry.key.get();
            String value = mapEntry.value.get();
            if (QLog.isColorLevel()) {
                QLog.w("VisitorsActivity", 1, "argList[" + i3 + "] : " + str + " " + value);
            }
            if (str != null) {
                switch (str.hashCode()) {
                    case -1396342996:
                        if (str.equals("banner")) {
                            Intrinsics.checkNotNullExpressionValue(value, "value");
                            adInfo.f(value);
                            break;
                        } else {
                            break;
                        }
                    case -1354875282:
                        if (str.equals("styategy_id")) {
                            Intrinsics.checkNotNullExpressionValue(value, "value");
                            adInfo.h(value);
                            break;
                        } else {
                            break;
                        }
                    case 96572:
                        if (str.equals("aid")) {
                            Intrinsics.checkNotNullExpressionValue(value, "value");
                            adInfo.e(value);
                            break;
                        } else {
                            break;
                        }
                    case 106748167:
                        if (str.equals(QCircleLpReportDc05494.KEY_PLACE)) {
                            Intrinsics.checkNotNullExpressionValue(value, "value");
                            adInfo.g(value);
                            break;
                        } else {
                            break;
                        }
                }
            }
            i3 = i16;
        }
        if (Intrinsics.areEqual(adInfo.getPlace(), "232")) {
            this.adId = String.valueOf(adItem.iAdId.get());
            String str2 = adItem.traceinfo.get();
            Intrinsics.checkNotNullExpressionValue(str2, "traceinfo.get()");
            this.traceInfo = str2;
            this.replaceAid = adInfo.getAid();
            this.styategyId = adInfo.getStyategyId();
            b().post(new Runnable() { // from class: com.tencent.mobileqq.vas.visitors.a
                @Override // java.lang.Runnable
                public final void run() {
                    AdComponent.c(AdComponent.this, adInfo);
                }
            });
            f(false);
            ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "11", "1", "", this.replaceAid, "", "4", 101, 0, 0, "", "", "");
        }
    }
}
