package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataMiniAppAdManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDesktopRvPartExpoHelper;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0002J*\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\b2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0014J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/MiniAppRvItemReportSection;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/section/AbsMiniAppRvItemSection;", "()V", "createLaunchParam", "Lcom/tencent/mobileqq/mini/sdk/LaunchParam;", "appInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "scene", "", "getViewStubLayoutId", "", "isGdtAd", "", "data", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "position", "onBindData", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "payload", "", "", "onInitView", "containerView", "Landroid/view/View;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppRvItemReportSection extends AbsMiniAppRvItemSection {
    private final LaunchParam createLaunchParam(MiniAppInfo appInfo, int scene) {
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = appInfo.appId;
        launchParam.envVersion = "";
        launchParam.entryPath = "";
        launchParam.navigateExtData = "";
        launchParam.reportData = appInfo.reportData;
        launchParam.scene = scene;
        launchParam.tianshuAdId = appInfo.tianshuAdId;
        launchParam.via = appInfo.via;
        return launchParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindData$lambda$1(DesktopItemInfo desktopItemInfo, int i3, MiniAppRvItemReportSection this$0) {
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DesktopAppInfo desktopAppInfo = (DesktopAppInfo) desktopItemInfo;
        MiniAppConfig miniAppConfig = new MiniAppConfig(desktopAppInfo.mMiniAppInfo);
        if (desktopAppInfo.getModuleType() == 1) {
            MiniAppDesktopRvPartExpoHelper.INSTANCE.reportRecentMiniAppToDc87(i3, desktopAppInfo.mMiniAppInfo, false);
            i16 = 3001;
        } else {
            i16 = 9999;
        }
        if (desktopAppInfo.getModuleType() == 3) {
            i16 = 3003;
        }
        MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
        Intrinsics.checkNotNullExpressionValue(miniAppInfo, "data.mMiniAppInfo");
        miniAppConfig.launchParam = this$0.createLaunchParam(miniAppInfo, i16);
        MiniAppDesktopRvPartExpoHelper.INSTANCE.reportRecentMiniAppToDc04239(miniAppConfig, false);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(DesktopItemInfo desktopItemInfo, int i3, List list) {
        onBindData2(desktopItemInfo, i3, (List<Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(final DesktopItemInfo data, final int position, List<Object> payload) {
        if (data == null || !(data instanceof DesktopAppInfo)) {
            return;
        }
        DesktopAppInfo desktopAppInfo = (DesktopAppInfo) data;
        if (desktopAppInfo.mMiniAppInfo != null) {
            if (isGdtAd(desktopAppInfo, position)) {
                DesktopDataMiniAppAdManager.getInstance().reportGdtMiniAppAdExposure(desktopAppInfo.mMiniAppInfo.gdtAdInfo, this.mRootView);
            }
            if (desktopAppInfo.getModuleType() == 1 || desktopAppInfo.getModuleType() == 3) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.section.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniAppRvItemReportSection.onBindData$lambda$1(DesktopItemInfo.this, position, this);
                    }
                }, 16, null, true);
            }
        }
    }

    private final boolean isGdtAd(DesktopAppInfo data, int position) {
        return (data != null && data.mModuleType == 1) && data.mMiniAppInfo.isGdtMiniAppAd && (5 == position || 6 == position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
    }
}
