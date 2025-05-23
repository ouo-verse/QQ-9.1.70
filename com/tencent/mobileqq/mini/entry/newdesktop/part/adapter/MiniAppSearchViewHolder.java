package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.PartLifecycleHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.part.MiniAppDesktopPartHost;
import com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0010J(\u0010\u0017\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppSearchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mMiniAppSearchBar", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "bindView", "", "searchInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopSearchInfo;", "createLaunchParam", "Lcom/tencent/mobileqq/mini/sdk/LaunchParam;", "appInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "scene", "", "slotId", "removeOverridePendingTransitionInSpecificDevice", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "setSearchBarColorType", "colorType", "startMiniApp", "miniAppInfo", "updateSearchKeyword", "partHost", "Lcom/tencent/biz/richframework/PartLifecycleHost;", "searchKeyword", "", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppSearchViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "MiniAppSearchViewHolder";
    private QUISearchBar mMiniAppSearchBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppSearchViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.rks);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.qsb_miniapp_search)");
        this.mMiniAppSearchBar = (QUISearchBar) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0(MiniAppSearchViewHolder this$0, DesktopSearchInfo desktopSearchInfo, View view) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_MINI_APP_USE_NATIVE_SEARCH, 1) == 1;
        String obj = this$0.mMiniAppSearchBar.getInputWidget().getText().toString();
        if (z16) {
            Intent intent = new Intent();
            intent.putExtra(MiniAppSearchFragment.IS_FROM_MINI_DESKTOP, true);
            if (!TextUtils.isEmpty(obj) && !Intrinsics.areEqual(obj, HardCodeUtil.qqStr(R.string.f172191o72))) {
                intent.putExtra(MiniAppSearchFragment.KEY_RECOMMEND_WORD, obj);
            }
            PublicFragmentActivity.start(this$0.itemView.getContext(), intent, ((IMiniAppService) QRoute.api(IMiniAppService.class)).getMiniAppSearchFragmentClass());
        } else {
            if ((desktopSearchInfo != null ? desktopSearchInfo.mAppInfo : null) == null) {
                QLog.e(TAG, 1, "click search bar searchInfo is null");
            }
            try {
                Context context = this$0.itemView.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                Activity activity = (Activity) context;
                MiniAppInfo miniAppInfo = desktopSearchInfo != null ? desktopSearchInfo.mAppInfo : null;
                Intrinsics.checkNotNull(miniAppInfo);
                this$0.startMiniApp(activity, miniAppInfo, 3006, 0);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "click search bar exception: " + Log.getStackTraceString(e16));
            }
        }
        Context context2 = this$0.itemView.getContext();
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
        this$0.removeOverridePendingTransitionInSpecificDevice((Activity) context2);
        MiniProgramLpReportDC04239.reportAsync("desktop", "search", "click_search", obj);
        if ((desktopSearchInfo != null ? desktopSearchInfo.mAppInfo : null) == null || (i3 = desktopSearchInfo.mAppInfo.tianshuAdId) <= 0) {
            return;
        }
        MiniAppUtils.miniAppTianShuReport("tianshu.78", "tianshu.78", String.valueOf(i3), 102);
    }

    private final LaunchParam createLaunchParam(MiniAppInfo appInfo, int scene, int slotId) {
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = appInfo.appId;
        String str = "";
        launchParam.envVersion = "";
        launchParam.entryPath = "";
        launchParam.navigateExtData = "";
        launchParam.reportData = appInfo.reportData;
        launchParam.scene = scene;
        launchParam.tianshuAdId = appInfo.tianshuAdId;
        launchParam.via = appInfo.via;
        if (slotId != 0) {
            str = String.valueOf(slotId);
        }
        launchParam.slotId = str;
        return launchParam;
    }

    private final void removeOverridePendingTransitionInSpecificDevice(Activity activity) {
        boolean equals;
        String b16 = com.tencent.mobileqq.utils.m.b();
        if (b16 != null) {
            equals = StringsKt__StringsJVMKt.equals(b16, "samsung-SM-A5260", true);
            if (!equals) {
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                ((Activity) context).overridePendingTransition(0, R.anim.f155053hw);
                return;
            }
        }
        QLog.e(TAG, 1, "device is samsung-SM-A5260!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSearchKeyword$lambda$1(PartLifecycleHost partHost, String keyword) {
        Intrinsics.checkNotNullParameter(partHost, "$partHost");
        Intrinsics.checkNotNullParameter(keyword, "$keyword");
        if (partHost instanceof MiniAppDesktopPartHost) {
            MiniAppDesktopPartHost miniAppDesktopPartHost = (MiniAppDesktopPartHost) partHost;
            if (miniAppDesktopPartHost.getMIsNeedSearchKeyReport()) {
                miniAppDesktopPartHost.setNeedSearchKeyReport(false);
                MiniAppConfig miniAppConfig = new MiniAppConfig(new MiniAppInfo());
                miniAppConfig.launchParam.scene = 3006;
                MiniProgramLpReportDC04239.reportAsync(miniAppConfig, "page_view", "em_expo", "pulldown_searchbox", "", "");
            }
        }
        if (TextUtils.isEmpty(keyword) || Intrinsics.areEqual(HardCodeUtil.qqStr(R.string.f172191o72), keyword)) {
            return;
        }
        QLog.d(TAG, 1, "SearchViewHolder pulldown_search_hotword keyword = " + keyword);
        MiniAppConfig miniAppConfig2 = new MiniAppConfig(new MiniAppInfo());
        miniAppConfig2.launchParam.scene = 3006;
        MiniProgramLpReportDC04239.reportAsync(miniAppConfig2, "page_view", "em_expo", "pulldown_search_hotword", "", keyword);
    }

    public final void setSearchBarColorType(int colorType) {
        this.mMiniAppSearchBar.setColorType(colorType);
        this.mMiniAppSearchBar.setBackground(new ColorDrawable(0));
    }

    public final void startMiniApp(Activity activity, MiniAppInfo miniAppInfo, int scene, int slotId) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        try {
            if (TextUtils.isEmpty(miniAppInfo.downloadUrl)) {
                MiniAppLauncher.launchMiniAppById(activity, createLaunchParam(miniAppInfo, scene, slotId), null);
            } else {
                MiniAppLauncher.launchAppByAppInfo(activity, miniAppInfo, scene, slotId);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "startMiniApp exception: " + Log.getStackTraceString(e16));
        }
    }

    public final void updateSearchKeyword(final PartLifecycleHost partHost, DesktopSearchInfo searchInfo, String searchKeyword) {
        CharSequence trim;
        int i3;
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(searchKeyword, "searchKeyword");
        QLog.i(TAG, 1, "updateSearchKeyword:" + searchKeyword);
        this.mMiniAppSearchBar.setBackground(new ColorDrawable(0));
        QuickPinyinEditText inputWidget = this.mMiniAppSearchBar.getInputWidget();
        trim = StringsKt__StringsKt.trim((CharSequence) searchKeyword);
        inputWidget.setText(trim.toString());
        this.mMiniAppSearchBar.getClearView().setVisibility(8);
        final String obj = this.mMiniAppSearchBar.getInputWidget().getText().toString();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            Manager manager = peekAppRuntime.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.MiniAppExposureManager");
            MiniAppExposureManager miniAppExposureManager = (MiniAppExposureManager) manager;
            miniAppExposureManager.putReportDataToMap("search", new MiniAppExposureManager.CardModuleExposureData("desktop", "search", "expo_search", obj));
            if ((searchInfo != null ? searchInfo.mAppInfo : null) != null && (i3 = searchInfo.mAppInfo.tianshuAdId) > 0) {
                String valueOf = String.valueOf(i3);
                miniAppExposureManager.putReportDataToMap(valueOf, new MiniAppExposureManager.TianShuExposureData("tianshu.78", "tianshu.78", valueOf, 101));
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.q
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppSearchViewHolder.updateSearchKeyword$lambda$1(PartLifecycleHost.this, obj);
            }
        }, 16, null, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bindView(final DesktopSearchInfo searchInfo) {
        QuickPinyinEditText inputWidget;
        CharSequence trim;
        if (searchInfo != null) {
            List<String> list = searchInfo.keyword;
            if (!(list == null || list.isEmpty())) {
                QuickPinyinEditText inputWidget2 = this.mMiniAppSearchBar.getInputWidget();
                String str = searchInfo.keyword.get(0);
                Intrinsics.checkNotNullExpressionValue(str, "searchInfo.keyword[0]");
                trim = StringsKt__StringsKt.trim((CharSequence) str);
                inputWidget2.setText(trim.toString());
                inputWidget = this.mMiniAppSearchBar.getInputWidget();
                if (inputWidget != null) {
                    inputWidget.setTextColor(this.itemView.getResources().getColor(R.color.qui_common_text_secondary));
                }
                this.mMiniAppSearchBar.setBackground(new ColorDrawable(0));
                this.mMiniAppSearchBar.getInputWidget().setBackground(new ColorDrawable(0));
                this.mMiniAppSearchBar.getClearView().setVisibility(8);
                this.mMiniAppSearchBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MiniAppSearchViewHolder.bindView$lambda$0(MiniAppSearchViewHolder.this, searchInfo, view);
                    }
                });
            }
        }
        this.mMiniAppSearchBar.getInputWidget().setText(R.string.f172191o72);
        inputWidget = this.mMiniAppSearchBar.getInputWidget();
        if (inputWidget != null) {
        }
        this.mMiniAppSearchBar.setBackground(new ColorDrawable(0));
        this.mMiniAppSearchBar.getInputWidget().setBackground(new ColorDrawable(0));
        this.mMiniAppSearchBar.getClearView().setVisibility(8);
        this.mMiniAppSearchBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniAppSearchViewHolder.bindView$lambda$0(MiniAppSearchViewHolder.this, searchInfo, view);
            }
        });
    }
}
