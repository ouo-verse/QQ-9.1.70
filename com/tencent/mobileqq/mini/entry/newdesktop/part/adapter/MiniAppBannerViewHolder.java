package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import NS_COMM.COMM;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopBannerModuleInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppBannerViewHolder;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.qzone.widget.QzoneEmotionUtils;
import cooperation.vip.tianshu.TianShuManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u0002/0B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000eH\u0002J\u0010\u0010#\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%J\u0018\u0010&\u001a\u00020\u001f2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0002J\b\u0010*\u001a\u00020\u001fH\u0002J\b\u0010+\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J\u0006\u0010-\u001a\u00020\u001fJ\b\u0010.\u001a\u00020\u001fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0012j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppBannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "APP_ID", "", "BANNER_PIC_URL", "CLICK_SCHEMA", "IMG_HEIGHT_IN_DP", "", "IMG_WIDTH_IN_DP", "ITEM_ID", "MARGIN_IN_DP", "", "PAGE_ID", "TRACE_INFO", "mBannerInfoMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mImgHeight", "mImgWidth", "mIvBanner", "Landroid/widget/ImageView;", "mMiniAppDesktopViewModel", "Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "getMMiniAppDesktopViewModel", "()Lcom/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel;", "mMiniAppDesktopViewModel$delegate", "Lkotlin/Lazy;", "bannerReport", "", "isClick", "", "footageId", "bindView", "bannerModuleInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopBannerModuleInfo;", "extractInfo", "extraInfoMap", "", "LNS_COMM/COMM$Entry;", "handleClick", "obtainFootageId", "reportClick2Tianshu", "reportExposure", "showBanner", "BannerExposureData", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppBannerViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "MiniAppDesktopPart.MiniAppBannerViewHolder";
    private final String APP_ID;
    private final String BANNER_PIC_URL;
    private final String CLICK_SCHEMA;
    private final float IMG_HEIGHT_IN_DP;
    private final float IMG_WIDTH_IN_DP;
    private final String ITEM_ID;
    private final int MARGIN_IN_DP;
    private final String PAGE_ID;
    private final String TRACE_INFO;
    private final HashMap<String, String> mBannerInfoMap;
    private int mImgHeight;
    private int mImgWidth;
    private ImageView mIvBanner;

    /* renamed from: mMiniAppDesktopViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mMiniAppDesktopViewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppBannerViewHolder(final View itemView) {
        super(itemView);
        Lazy lazy;
        int d16;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.MARGIN_IN_DP = 30;
        this.IMG_WIDTH_IN_DP = 315.0f;
        this.IMG_HEIGHT_IN_DP = 158.0f;
        this.BANNER_PIC_URL = "url";
        this.CLICK_SCHEMA = ZPlanPublishSource.FROM_SCHEME;
        this.APP_ID = "appId";
        this.PAGE_ID = "pageId";
        this.ITEM_ID = "itemId";
        this.TRACE_INFO = MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO;
        this.mBannerInfoMap = new HashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniAppDeskTopViewModel>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppBannerViewHolder$mMiniAppDesktopViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppDeskTopViewModel invoke() {
                ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(itemView);
                MiniAppDeskTopViewModel miniAppDeskTopViewModel = viewModelStoreOwner != null ? (MiniAppDeskTopViewModel) new ViewModelProvider(viewModelStoreOwner).get(MiniAppDeskTopViewModel.class) : null;
                if (miniAppDeskTopViewModel != null) {
                    Context context = itemView.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    miniAppDeskTopViewModel.setContextHashCode(((Activity) context).hashCode());
                }
                return miniAppDeskTopViewModel;
            }
        });
        this.mMiniAppDesktopViewModel = lazy;
        View findViewById = itemView.findViewById(R.id.reg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_pull_down_banner)");
        this.mIvBanner = (ImageView) findViewById;
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD && (d16 = com.tencent.mobileqq.pad.m.d()) != 0) {
            i3 = d16;
        }
        int f16 = i3 - (BaseAIOUtils.f(30, this.mIvBanner.getResources()) * 2);
        this.mImgWidth = f16;
        this.mImgHeight = (int) (((158.0f * 1.0f) * f16) / 315.0f);
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 2, "width:" + this.mImgWidth + ",height:" + this.mImgHeight);
        }
        ViewGroup.LayoutParams layoutParams = this.mIvBanner.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.width = this.mImgWidth;
        layoutParams2.height = this.mImgHeight;
        this.mIvBanner.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniAppBannerViewHolder._init_$lambda$0(MiniAppBannerViewHolder.this, view);
            }
        });
        itemView.post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.b
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppBannerViewHolder._init_$lambda$1(itemView, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(MiniAppBannerViewHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(View itemView, MiniAppBannerViewHolder this$0) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(itemView);
        if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MiniAppBannerViewHolder$2$1(this$0, null), 3, null);
    }

    private final void bannerReport(final boolean isClick, final int footageId) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.c
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppBannerViewHolder.bannerReport$lambda$3(isClick, footageId);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniAppDeskTopViewModel getMMiniAppDesktopViewModel() {
        return (MiniAppDeskTopViewModel) this.mMiniAppDesktopViewModel.getValue();
    }

    private final void handleClick() {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        Map mutableMapOf;
        String str = this.mBannerInfoMap.get(this.CLICK_SCHEMA);
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (MiniAppLauncher.isMiniAppScheme(str)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            ax c16 = bi.c((QQAppInterface) peekAppRuntime, activity, str);
            if (c16 != null) {
                c16.b();
            }
        } else if (MiniAppLauncher.isFakeUrl(str)) {
            MiniAppLauncher.startMiniApp(activity, str, 3011, null);
            MiniAppUtils.updateMiniAppList(104);
        } else {
            Intrinsics.checkNotNull(str);
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str, "https", false, 2, null);
                if (!startsWith$default2) {
                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(str, SchemaUtils.SCHEMA_MQQAPI, false, 2, null);
                    if (startsWith$default3) {
                        Intent intent = new Intent(activity, (Class<?>) JumpActivity.class);
                        intent.setData(Uri.parse(str));
                        activity.startActivity(intent);
                    }
                }
            }
            Intent intent2 = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent2.putExtra("url", str);
            intent2.putExtra("webStyle", "noBottomBar");
            intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
            activity.startActivity(intent2);
        }
        reportClick2Tianshu();
        bannerReport(true, obtainFootageId());
        MiniAppDesktopDtReportHelper companion = MiniAppDesktopDtReportHelper.INSTANCE.getInstance();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("adID", String.valueOf(obtainFootageId())));
        MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(companion, "qq_clck", MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_BANNER, mutableMapOf, null, 8, null);
    }

    private final int obtainFootageId() {
        String str = this.mBannerInfoMap.get(this.TRACE_INFO);
        if (QLog.isDebugVersion()) {
            QLog.i(TAG, 4, "obtainFootageId: traceInfo=" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return new JSONObject(str).optInt("tianshu_footageid", -1);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "obtainFootageId: error, traceInfo=" + str, e16);
            return -1;
        }
    }

    private final void reportClick2Tianshu() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.d
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppBannerViewHolder.reportClick2Tianshu$lambda$2(MiniAppBannerViewHolder.this);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportClick2Tianshu$lambda$2(MiniAppBannerViewHolder this$0) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[reportClick2Tianshu]");
        }
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            str = runtime.getAccount();
            Intrinsics.checkNotNullExpressionValue(str, "appRuntime.account");
        } else {
            str = "";
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = str + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = this$0.mBannerInfoMap.get(this$0.APP_ID);
        tianShuReportData.mPageId = this$0.mBannerInfoMap.get(this$0.PAGE_ID);
        tianShuReportData.mItemId = this$0.mBannerInfoMap.get(this$0.ITEM_ID);
        tianShuReportData.mActionId = 102;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mBusiInfo = this$0.mBannerInfoMap.get(this$0.TRACE_INFO);
        TianShuManager.getInstance().report(tianShuReportData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBanner() {
        boolean endsWith$default;
        final String str = this.mBannerInfoMap.get(this.BANNER_PIC_URL);
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "url is empty.");
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mRequestWidth = this.mImgWidth;
        obtain.mRequestHeight = this.mImgHeight;
        Intrinsics.checkNotNull(str);
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, null);
        if (endsWith$default) {
            obtain.mPlayGifImage = true;
        }
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        if (drawable2.getStatus() == 1) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 2, "exist in local.");
            }
            this.itemView.setVisibility(0);
            this.mIvBanner.setImageDrawable(drawable2);
            reportExposure();
            return;
        }
        drawable2.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppBannerViewHolder$showBanner$1
            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable urlDrawable) {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable urlDrawable, Throwable throwable) {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                QLog.e("MiniAppDesktopPart.MiniAppBannerViewHolder", 1, "load banner failed. url=" + str);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable urlDrawable, int i3) {
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable urlDrawable) {
                ImageView imageView;
                Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
                if (QLog.isColorLevel()) {
                    QLog.d("MiniAppDesktopPart.MiniAppBannerViewHolder", 2, "[onLoadSuccessed]");
                }
                MiniAppBannerViewHolder.this.itemView.setVisibility(0);
                imageView = MiniAppBannerViewHolder.this.mIvBanner;
                imageView.setImageDrawable(urlDrawable);
                MiniAppBannerViewHolder.this.reportExposure();
            }
        });
        drawable2.startDownload();
    }

    public final void bindView(DesktopBannerModuleInfo bannerModuleInfo) {
        if (!MiniAppUtils.isTeenagerMode()) {
            if ((bannerModuleInfo != null ? bannerModuleInfo.extInfo : null) != null && bannerModuleInfo.extInfo.mapInfo != null) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "bannerModuleInfo:" + bannerModuleInfo);
                }
                extractInfo(bannerModuleInfo.extInfo.mapInfo.get());
                this.itemView.setVisibility(8);
                showBanner();
                return;
            }
        }
        this.itemView.setVisibility(8);
    }

    public final void reportExposure() {
        Map mutableMapOf;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[reportExposure]");
        }
        Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.MiniAppExposureManager");
        String str = this.mBannerInfoMap.get(this.APP_ID);
        String str2 = this.mBannerInfoMap.get(this.PAGE_ID);
        String str3 = this.mBannerInfoMap.get(this.ITEM_ID);
        String str4 = this.mBannerInfoMap.get(this.TRACE_INFO);
        BannerExposureData bannerExposureData = new BannerExposureData(str, str2, str3, 101);
        bannerExposureData.setBusiInfo(str4);
        bannerExposureData.setFootageId(obtainFootageId());
        ((MiniAppExposureManager) manager).putReportDataToMap(str3, bannerExposureData);
        bannerReport(false, obtainFootageId());
        MiniAppDesktopDtReportHelper companion = MiniAppDesktopDtReportHelper.INSTANCE.getInstance();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("adID", String.valueOf(obtainFootageId())));
        MiniAppDesktopDtReportHelper.miniAppDesktopCommonReport$default(companion, "qq_imp", MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_BANNER, mutableMapOf, null, 8, null);
    }

    private final void extractInfo(List<COMM.Entry> extraInfoMap) {
        List<COMM.Entry> list = extraInfoMap;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = extraInfoMap.size();
        for (int i3 = 0; i3 < size; i3++) {
            COMM.Entry entry = extraInfoMap.get(i3);
            PBStringField pBStringField = entry.key;
            if (pBStringField != null && entry.value != null) {
                String key = pBStringField.get();
                String value = entry.value.get();
                HashMap<String, String> hashMap = this.mBannerInfoMap;
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Intrinsics.checkNotNullExpressionValue(value, "value");
                hashMap.put(key, value);
                if (QLog.isDevelopLevel()) {
                    QLog.i(TAG, 2, key + ":" + value);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0007J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppBannerViewHolder$BannerExposureData;", "Lcom/tencent/mobileqq/mini/entry/MiniAppExposureManager$TianShuExposureData;", "appId", "", "pageId", "itemId", "actionId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "footageId", "bannerReport", "", "isClick", "", "report", "setFootageId", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class BannerExposureData extends MiniAppExposureManager.TianShuExposureData {
        private int footageId;

        public BannerExposureData(String str, String str2, String str3, int i3) {
            super(str, str2, str3, i3);
            this.footageId = -1;
        }

        private final void bannerReport(final boolean isClick, final int footageId) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.e
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBannerViewHolder.BannerExposureData.bannerReport$lambda$0(isClick, footageId);
                }
            }, 16, null, true);
        }

        @Override // com.tencent.mobileqq.mini.entry.MiniAppExposureManager.TianShuExposureData, com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
            super.report();
            QLog.i(MiniAppBannerViewHolder.TAG, 1, "[BannerExposureData], appId:" + this.appId + ",pageId:" + this.pageId + ",itemId:" + this.itemId + ",actionId:" + this.actionId);
            bannerReport(false, this.footageId);
        }

        public final void setFootageId(int footageId) {
            this.footageId = footageId;
        }

        @Override // com.tencent.mobileqq.mini.entry.MiniAppExposureManager.TianShuExposureData
        public String toString() {
            return "BannerExposureData{appId='" + this.appId + "', pageId='" + this.pageId + "', itemId='" + this.itemId + "', actionId=" + this.actionId + ", busiInfo='" + this.busiInfo + "'}";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bannerReport$lambda$0(boolean z16, int i3) {
            String str;
            if (z16) {
                str = "item_click";
            } else {
                str = "item_expo";
            }
            List<COMM.Entry> newBusinessEntries = MiniProgramReportHelper.newBusinessEntries(null, null, "3011", "desktop", "banner", str, null, null, null, null, null, null, null, null, null);
            if (i3 != -1) {
                COMM.Entry entry = new COMM.Entry();
                entry.key.set(DittoImageArea.RESOURCE_ID);
                entry.value.set(String.valueOf(i3));
                newBusinessEntries.add(entry);
            }
            if (QLog.isColorLevel()) {
                QLog.i(MiniAppBannerViewHolder.TAG, 2, "bannerReport: isClick=" + z16 + ", footageId=" + i3);
            }
            MiniProgramLpReportDC04239.reportAsync(newBusinessEntries);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bannerReport$lambda$3(boolean z16, int i3) {
        String str;
        if (z16) {
            str = "item_click";
        } else {
            str = "item_expo";
        }
        List<COMM.Entry> newBusinessEntries = MiniProgramReportHelper.newBusinessEntries(null, null, "3011", "desktop", "banner", str, null, null, null, null, null, null, null, null, null);
        if (i3 != -1) {
            COMM.Entry entry = new COMM.Entry();
            entry.key.set(DittoImageArea.RESOURCE_ID);
            entry.value.set(String.valueOf(i3));
            newBusinessEntries.add(entry);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "bannerReport: isClick=" + z16 + ", footageId=" + i3);
        }
        MiniProgramLpReportDC04239.reportAsync(newBusinessEntries);
    }
}
