package cooperation.ad;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.IAdConfigApi;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.dd;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdReportHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0006J\u0016\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u0004\u0018\u00010\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00106\u001a\u0004\u0018\u0001038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u0010 R\u0014\u0010<\u001a\u0002098BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;\u00a8\u0006@"}, d2 = {"Lcooperation/ad/AmsAdTabBannerModule;", "", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", HippyTKDListViewAdapter.X, "", "u", BdhLogUtil.LogTag.Tag_Conn, "w", "Landroid/view/View;", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", "t", ReportConstant.COSTREPORT_PREFIX, "", "componentId", "o", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "j", "Lcom/tencent/mobileqq/activity/home/a;", "a", "Lcom/tencent/mobileqq/activity/home/a;", "getAmsAdTabConversationApi", "()Lcom/tencent/mobileqq/activity/home/a;", "amsAdTabConversationApi", "b", "Z", "getMIsShowingTabBanner", "()Z", "setMIsShowingTabBanner", "(Z)V", "mIsShowingTabBanner", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "c", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "mProcessorProxy", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "d", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "mExposureChecker", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "e", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "mAdExposureCheckerCallback", DomainData.DOMAIN_NAME, "()Landroid/view/View;", "mTitleView", "Landroid/app/Activity;", "l", "()Landroid/app/Activity;", "mActivity", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mCanShowTabBanner", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "i", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "entity", "<init>", "(Lcom/tencent/mobileqq/activity/home/a;)V", "f", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class AmsAdTabBannerModule {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.activity.home.a amsAdTabConversationApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowingTabBanner;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GdtThirdProcessorProxy mProcessorProxy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdExposureChecker mExposureChecker;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdExposureChecker.ExposureCallback mAdExposureCheckerCallback;

    public AmsAdTabBannerModule(@NotNull com.tencent.mobileqq.activity.home.a amsAdTabConversationApi) {
        Intrinsics.checkNotNullParameter(amsAdTabConversationApi, "amsAdTabConversationApi");
        this.amsAdTabConversationApi = amsAdTabConversationApi;
        this.mProcessorProxy = new GdtThirdProcessorProxy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(View view) {
        view.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(AmsAdTabBannerModule this$0, GdtAd gdtAd, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(gdtAd, "$gdtAd");
        this$0.s();
        ((IAdApi) QRoute.api(IAdApi.class)).report("amsBannerClickClose", i.f390099a.a(gdtAd));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C() {
        QLog.d("AmsAdTabBannerModule", 2, "tryRecoverTianShuBanner");
        BannerManager.l().D(VasADBannerProcessor.f185279h, 3003);
    }

    private final void D(GdtAd gdtAd) {
        boolean z16;
        boolean z17;
        String amsBannerPushStr = gdtAd.getAmsBannerPushStr();
        boolean z18 = false;
        if (amsBannerPushStr != null && amsBannerPushStr.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        String string = i().getString("ams_banner_expose_pushs", "");
        JSONArray jSONArray = new JSONArray();
        if (string != null) {
            if (string.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (true == z17) {
                z18 = true;
            }
        }
        if (z18) {
            jSONArray = new JSONArray(string);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("update_time", System.currentTimeMillis());
        jSONObject.put("ams_banner_push", amsBannerPushStr);
        jSONArray.mo162put(jSONObject);
        i().putString("ams_banner_expose_pushs", jSONArray.toString());
    }

    private final MMKVOptionEntityV2 i() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        return fromV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final Activity l() {
        return this.amsAdTabConversationApi.a();
    }

    private final boolean m() {
        if (this.amsAdTabConversationApi.j() || this.amsAdTabConversationApi.i()) {
            return false;
        }
        return true;
    }

    private final View n() {
        return this.amsAdTabConversationApi.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(GdtAd gdtAd, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(gdtAd, "$gdtAd");
        MaskAdReportHelper.INSTANCE.reportAdByUrl(gdtAd.getUrlForImpression());
    }

    private final void q(final GdtAd gdtAd, View view) {
        if (!gdtAd.isValid()) {
            return;
        }
        AdExposureChecker adExposureChecker = new AdExposureChecker(gdtAd, new WeakReference(view));
        this.mExposureChecker = adExposureChecker;
        adExposureChecker.setCallback(new WeakReference<>(new AdExposureChecker.ExposureCallback() { // from class: cooperation.ad.q
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                AmsAdTabBannerModule.r(GdtAd.this, weakReference);
            }
        }));
        AdExposureChecker adExposureChecker2 = this.mExposureChecker;
        if (adExposureChecker2 != null) {
            adExposureChecker2.startCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(GdtAd gdtAd, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(gdtAd, "$gdtAd");
        MaskAdReportHelper.INSTANCE.reportAdByUrl(gdtAd.getUrlForImpression());
    }

    private final void u() {
        View view;
        QLog.d("AmsAdTabBannerModule", 2, "removeTitleBanner");
        View n3 = n();
        if (n3 != null) {
            view = n3.findViewById(R.id.f164313sn2);
        } else {
            view = null;
        }
        if (view == null) {
            return;
        }
        if (n3 instanceof ViewGroup) {
            ((ViewGroup) n3).removeView(view);
        }
        Conversation.u g16 = this.amsAdTabConversationApi.g();
        if (g16 != null) {
            g16.g();
        }
        Conversation conversation = this.amsAdTabConversationApi.h().get();
        if (conversation != null) {
            conversation.refreshStatusBarUIByTheme();
        }
        if (ThemeUtil.isNowThemeIsSuperTheme()) {
            dd.a(n3, R.drawable.skin_header_bar_bg);
        }
        n3.requestLayout();
        n3.post(new Runnable() { // from class: cooperation.ad.j
            @Override // java.lang.Runnable
            public final void run() {
                AmsAdTabBannerModule.v(AmsAdTabBannerModule.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(AmsAdTabBannerModule this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.amsAdTabConversationApi.c().e(0);
    }

    private final void w(GdtAd gdtAd) {
        if (!gdtAd.isValid()) {
            QLog.e("AmsAdTabBannerModule", 1, "expose cancel, adInfo is null");
            return;
        }
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtAd.info;
        if (adInfo != null) {
            MaskAdReportHelper.INSTANCE.reportAdByUrl(GdtOriginalExposureReporter.replaceUrlMacros(adInfo.report_info.original_exposure_url.get(), adInfo.product_type.get(), l(), adInfo.app_info.app_package_name.get()));
        }
        this.mProcessorProxy.c2sReportAsync(0, 0, gdtAd.info);
    }

    private final boolean x(final GdtAd gdtAd) {
        Integer num;
        Resources resources;
        DisplayMetrics displayMetrics;
        String basic_img = gdtAd.getBasic_img();
        Intrinsics.checkNotNullExpressionValue(basic_img, "gdtAd.basic_img");
        QLog.d("AmsAdTabBannerModule", 1, "showTitleBanner ,bannerBgUrl = " + basic_img);
        View n3 = n();
        if (!(n3 instanceof RelativeLayout)) {
            QLog.e("AmsAdTabBannerModule", 1, "showTitleBanner return, titleView is not RelativeLayout");
            return false;
        }
        RelativeLayout relativeLayout = (RelativeLayout) n3;
        View findViewById = relativeLayout.findViewById(R.id.f87554uo);
        if (findViewById != null) {
            relativeLayout.removeView(findViewById);
        }
        View inflate = LayoutInflater.from(l()).inflate(R.layout.gvy, (ViewGroup) n3, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout2 = (RelativeLayout) inflate;
        Conversation conversation = this.amsAdTabConversationApi.h().get();
        if (conversation != null) {
            num = Integer.valueOf(conversation.statusTitleHeightInNormalState);
        } else {
            num = null;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        int dip2px = ViewUtils.dip2px(40.0f);
        if (num != null) {
            num.intValue();
            if (num.intValue() > 0) {
                intRef.element = num.intValue() + dip2px;
            } else {
                int height = relativeLayout.getHeight();
                Conversation conversation2 = this.amsAdTabConversationApi.h().get();
                if (conversation2 != null) {
                    conversation2.statusTitleHeightInNormalState = height;
                }
                intRef.element = height + dip2px;
            }
        }
        QLog.d("AmsAdTabBannerModule", 2, "showTitleBanner, statusTitleHeight = " + intRef.element + " , 40dp = " + dip2px);
        if (intRef.element <= ViewUtils.dip2px(50.0f)) {
            intRef.element = ViewUtils.dip2px(125.0f);
        }
        if (relativeLayout.getChildCount() > 0 && relativeLayout.getChildAt(0).getId() == R.id.f164618t91) {
            relativeLayout.addView(relativeLayout2, 1, new RelativeLayout.LayoutParams(-1, intRef.element));
        } else {
            relativeLayout.addView(relativeLayout2, 0, new RelativeLayout.LayoutParams(-1, intRef.element));
        }
        ((TextView) relativeLayout2.findViewById(R.id.f87574uq)).setText(gdtAd.getText());
        relativeLayout2.requestLayout();
        relativeLayout.requestLayout();
        relativeLayout.post(new Runnable() { // from class: cooperation.ad.m
            @Override // java.lang.Runnable
            public final void run() {
                AmsAdTabBannerModule.y(AmsAdTabBannerModule.this, intRef);
            }
        });
        q(gdtAd, relativeLayout2);
        w(gdtAd);
        D(gdtAd);
        View findViewById2 = relativeLayout2.findViewById(R.id.f87564up);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "bannerContainer.findView\u2026ring_festival_banner_img)");
        ImageView imageView = (ImageView) findViewById2;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mRequestHeight = intRef.element;
        Activity l3 = l();
        if (l3 != null && (resources = l3.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            obtain.mRequestWidth = displayMetrics.widthPixels;
        }
        URLDrawable drawable = URLDrawable.getDrawable(new URL(basic_img), obtain);
        if (drawable.getStatus() == 1) {
            ((IAdApi) QRoute.api(IAdApi.class)).report("amsBannerImgLoadSuccess", i.f390099a.a(gdtAd));
        }
        if (drawable.getStatus() == 2) {
            ((IAdApi) QRoute.api(IAdApi.class)).report("amsBannerImgLoadFailed", i.f390099a.a(gdtAd));
        }
        imageView.setImageDrawable(drawable);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cooperation.ad.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmsAdTabBannerModule.z(AmsAdTabBannerModule.this, gdtAd, view);
            }
        });
        View findViewById3 = relativeLayout2.findViewById(R.id.f87544un);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "bannerContainer.findView\u2026ng_2022_banner_close_btn)");
        ImageView imageView2 = (ImageView) findViewById3;
        imageView2.setImageResource(R.drawable.mhj);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: cooperation.ad.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AmsAdTabBannerModule.B(AmsAdTabBannerModule.this, gdtAd, view);
            }
        });
        if (((IAdConfigApi) QRoute.api(IAdConfigApi.class)).getCanShowTabAdBannerGuide()) {
            QLog.i("AmsAdTabBannerModule", 2, "update: mHasAmsAdBanner");
            i.f390099a.b().set(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(AmsAdTabBannerModule this$0, Ref.IntRef statusTitleHeight) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(statusTitleHeight, "$statusTitleHeight");
        this$0.amsAdTabConversationApi.c().e(statusTitleHeight.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(AmsAdTabBannerModule this$0, GdtAd gdtAd, final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(gdtAd, "$gdtAd");
        view.setClickable(false);
        view.postDelayed(new Runnable() { // from class: cooperation.ad.p
            @Override // java.lang.Runnable
            public final void run() {
                AmsAdTabBannerModule.A(view);
            }
        }, 1000L);
        this$0.o(gdtAd, 10092);
        QLog.i("AmsAdTabBannerModule", 2, "showTitleBanner: banner onClick");
        this$0.s();
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final ArrayList<String> j() {
        boolean z16;
        ArrayList<String> arrayList = new ArrayList<>();
        String string = i().getString("ams_banner_expose_pushs", "");
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return arrayList;
        }
        JSONArray jSONArray = new JSONArray(string);
        ArrayList arrayList2 = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList2.add(jSONArray.getJSONObject(i3));
        }
        final AmsAdTabBannerModule$getExposePushList$1 amsAdTabBannerModule$getExposePushList$1 = new Function2<JSONObject, JSONObject, Integer>() { // from class: cooperation.ad.AmsAdTabBannerModule$getExposePushList$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Integer invoke(JSONObject jSONObject, JSONObject jSONObject2) {
                return Integer.valueOf(jSONObject.optLong("update_time", 0L) < jSONObject2.optLong("update_time", 0L) ? 1 : jSONObject.optLong("update_time", 0L) > jSONObject2.optLong("update_time", 0L) ? -1 : 0);
            }
        };
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, new Comparator() { // from class: cooperation.ad.l
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int k3;
                k3 = AmsAdTabBannerModule.k(Function2.this, obj, obj2);
                return k3;
            }
        });
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(((JSONObject) it.next()).getString("ams_banner_push"));
        }
        if (arrayList.size() > 5) {
            return new ArrayList<>(arrayList.subList(0, 5));
        }
        return arrayList;
    }

    public final void o(@NotNull final GdtAd gdtAd, int componentId) {
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        this.mAdExposureCheckerCallback = new AdExposureChecker.ExposureCallback() { // from class: cooperation.ad.k
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                AmsAdTabBannerModule.p(GdtAd.this, weakReference);
            }
        };
        AdExposureChecker.onClick(l(), gdtAd, new WeakReference(this.mAdExposureCheckerCallback));
        this.mProcessorProxy.c2sReportAsync(1, 0, gdtAd.info);
        GdtHandler.Params params = new GdtHandler.Params();
        params.f108486ad = gdtAd;
        params.activity = new WeakReference<>(l());
        Bundle bundle = new Bundle();
        params.extra = bundle;
        params.componentID = componentId;
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_ams_aio_banner");
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        i iVar = i.f390099a;
        iVar.d(System.currentTimeMillis());
        ((IAdApi) QRoute.api(IAdApi.class)).report("amsBannerClickJump", iVar.a(gdtAd));
    }

    public final void s() {
        this.amsAdTabConversationApi.b().r();
        QLog.d("AmsAdTabBannerModule", 1, "onMsgTabBannerHide");
        this.mIsShowingTabBanner = false;
        i.f390099a.b().set(false);
        u();
        C();
    }

    public final void t(@NotNull GdtAd gdtAd) {
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        QLog.d("AmsAdTabBannerModule", 1, "onMsgTabBannerShow");
        if (!m()) {
            QLog.d("AmsAdTabBannerModule", 2, "onMsgTabBannerShow return: is not DefaultTheme or study or elder");
            s();
            ((IAdApi) QRoute.api(IAdApi.class)).report("amsBannerShowFailed", i.f390099a.a(gdtAd));
            return;
        }
        Conversation.u g16 = this.amsAdTabConversationApi.g();
        if (g16 != null) {
            g16.l();
        }
        Conversation.u g17 = this.amsAdTabConversationApi.g();
        if (g17 != null) {
            g17.h();
        }
        QLog.d("AmsAdTabBannerModule", 2, "onMsgTabBannerShow, data = " + gdtAd);
        this.mIsShowingTabBanner = x(gdtAd);
        ((IAdApi) QRoute.api(IAdApi.class)).report("amsBannerShowSuccess", i.f390099a.a(gdtAd));
        Conversation conversation = this.amsAdTabConversationApi.h().get();
        if (conversation != null) {
            conversation.removeTitleBackground();
        }
    }
}
